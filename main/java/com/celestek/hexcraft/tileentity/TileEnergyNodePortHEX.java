package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.block.BlockEnergyNodeCore;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.util.HexDevice;
import com.celestek.hexcraft.util.HexEnergyNode;
import com.celestek.hexcraft.util.HexUtils;
import com.celestek.hexcraft.util.NetworkAnalyzer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import org.lwjgl.Sys;

import java.util.ArrayList;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.7.0
 */

public class TileEnergyNodePortHEX extends TileEntity implements ITileHexEnergyPort, ITileHexEnergySource, ITileHexEnergyDrain {

    /**** Static Values ****/

    public static final String ID = "tileEnergyNodePortHEX";

    // NBT Names
    private static final String NBT_ENERGY_SOURCES = "energy_sources";
    private static final String NBT_ENERGY_DRAINS = "energy_drains";
    private static final String NBT_ENERGY_PORTS = "energy_ports";

    private static final String NBT_ENERGY_BUFFER_FILLED = "energy_buffer_filled";
    private static final String NBT_ENERGY_BUFFER_DRAINED = "energy_buffer_drained";

    private static final String NBT_USABLE_SOURCES = "usable_sources";
    private static final String NBT_HAS_ENERGY = "has_energy";

    private static final String NBT_LINKED_PORT_EXISTS = "linked_port_exists";
    private static final String NBT_LINKED_PORT = "linked_port";
    private static final String NBT_PORT_TIER = "port_tier";

    /**** Variables ****/

    // Prepare lists.
    private ArrayList<HexDevice> energySources;
    private ArrayList<HexDevice> energyDrains;
    private ArrayList<HexDevice> energyPorts;

    // Prepare energy buffer variables.
    private float energyBufferTotal;
    private float energyBufferFilled;
    private float energyBufferDrained;

    // Prepare state variables.
    private int usableSources;
    private boolean hasEnergy;

    // Prepare port variables.
    private HexDevice linkedPort;
    private int portTier;
    private int portType;

    // Prepare the recheck variables.
    private int recheckCountdown;
    private int recheckCounter;
    private boolean shouldRecheck;


    /**** Common TileEntity Methods ****/

    public TileEnergyNodePortHEX() {

        this.energyBufferTotal = 6400;

        this.usableSources = 0;
        this.hasEnergy = false;

        this.portTier = 0;
        this.portType = HexEnergyNode.PORT_TYPE_HEX;

        this.recheckCountdown = 10;
        this.recheckCounter = 0;
        this.shouldRecheck = false;
    }

    /**
     * Writes the tags to NBT.
     */
    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);

        // Write the machine lists.
        HexUtils.writeHexDevicesArrayToNBT(tagCompound, NBT_ENERGY_SOURCES, energySources);
        HexUtils.writeHexDevicesArrayToNBT(tagCompound, NBT_ENERGY_DRAINS, energyDrains);
        HexUtils.writeHexDevicesArrayToNBT(tagCompound, NBT_ENERGY_PORTS, energyPorts);

        // Write the energy buffer variables.
        tagCompound.setFloat(NBT_ENERGY_BUFFER_FILLED, energyBufferFilled);
        tagCompound.setFloat(NBT_ENERGY_BUFFER_DRAINED, energyBufferDrained);

        // Write the state variables.
        tagCompound.setInteger(NBT_USABLE_SOURCES, usableSources);
        tagCompound.setBoolean(NBT_HAS_ENERGY, hasEnergy);

        // Write the port variables.
        HexUtils.writeHexDeviceToNBT(tagCompound, NBT_LINKED_PORT, linkedPort);
        tagCompound.setBoolean(NBT_LINKED_PORT_EXISTS, linkedPort != null);
        tagCompound.setInteger(NBT_PORT_TIER, portTier);
    }

    /**
     * Reads the tags from NBT.
     */
    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);

        // Read the machine lists.
        energySources = HexUtils.readHexDevicesArrayFromNBT(tagCompound, NBT_ENERGY_SOURCES);
        energyDrains = HexUtils.readHexDevicesArrayFromNBT(tagCompound, NBT_ENERGY_DRAINS);
        energyPorts = HexUtils.readHexDevicesArrayFromNBT(tagCompound, NBT_ENERGY_PORTS);

        // Read the energy buffer variables.
        energyBufferFilled = tagCompound.getFloat(NBT_ENERGY_BUFFER_FILLED);
        energyBufferDrained = tagCompound.getFloat(NBT_ENERGY_BUFFER_DRAINED);

        // Read the state variables.
        usableSources = tagCompound.getInteger(NBT_USABLE_SOURCES);
        hasEnergy = tagCompound.getBoolean(NBT_HAS_ENERGY);

        // Read the port variables.
        if (tagCompound.getBoolean(NBT_LINKED_PORT_EXISTS))
            linkedPort = HexUtils.readHexDeviceFromNBT(tagCompound, NBT_LINKED_PORT);
        else
            linkedPort = null;
        portTier = tagCompound.getInteger(NBT_PORT_TIER);
    }

    /**
     * Fired on every tick. Main processing is done here.
     */
    @Override
    public void updateEntity() {
        // Confirm that this is server side.
        if (!worldObj.isRemote) {
            if (linkedPort != null) {
                // Situation in which the linked port is input, and this port is output.
                if (HexUtils.getMetaBitBiInt(HexEnergyNode.META_MODE_0, HexEnergyNode.META_MODE_1, worldObj, linkedPort.x, linkedPort.y, linkedPort.z) == HexEnergyNode.PORT_MODE_INPUT
                        && HexUtils.getMetaBitBiInt(HexEnergyNode.META_MODE_0, HexEnergyNode.META_MODE_1, worldObj, xCoord, yCoord, zCoord) == HexEnergyNode.PORT_MODE_OUTPUT) {
                    // Fill the port buffer until it is full.
                    if (energyBufferFilled < energyBufferTotal) {
                        ITileHexEnergyPort port = (ITileHexEnergyPort) worldObj.getTileEntity(linkedPort.x, linkedPort.y, linkedPort.z);

                        energyBufferFilled = energyBufferFilled + port.drainPortEnergy(energyBufferTotal - energyBufferFilled) * port.getMultiplier(portType, portTier, false);
                    }

                    // Check if states have changed and send a recheck if so.
                    if (energyBufferFilled > 0 && !hasEnergy) {
                        hasEnergy = true;
                        shouldRecheck = true;
                    }
                    else if (energyBufferFilled <= 0 && hasEnergy) {
                        hasEnergy = false;
                        shouldRecheck = true;
                    }

                    // Recheck only on certain ticks.
                    if (recheckCounter >= recheckCountdown) {
                        if (shouldRecheck)
                            sendRecheck();
                        shouldRecheck = false;
                        recheckCounter = 0;
                    }
                    else
                        recheckCounter++;

                    energyBufferDrained = 0;
                }
                // Situation in which the linked port is output, and this port is input.
                else if (HexUtils.getMetaBitBiInt(HexEnergyNode.META_MODE_0, HexEnergyNode.META_MODE_1, worldObj, linkedPort.x, linkedPort.y, linkedPort.z) == HexEnergyNode.PORT_MODE_OUTPUT
                        && HexUtils.getMetaBitBiInt(HexEnergyNode.META_MODE_0, HexEnergyNode.META_MODE_1, worldObj, xCoord, yCoord, zCoord) == HexEnergyNode.PORT_MODE_INPUT) {
                    energyBufferDrained = 0;
                    // Check the situation in which the machine has available energy sources and items to process.
                    if (canDrainSource() && (energyBufferFilled < energyBufferTotal)) {
                        // Drain from all sources.
                        drainFromSources();
                        energyBufferFilled = energyBufferFilled + energyBufferDrained;
                    }

                    hasEnergy = false;
                }
                else
                    hasEnergy = false;
            }
            else
                hasEnergy = false;
        }
    }

    /**** ITileHexEnergySource Methods ****/

    /**
     * Saves the ArrayList of energy drains.
     * @param energyDrains The ArrayList to save.
     */
    @Override
    public void setDrains(ArrayList<HexDevice> energyDrains) {
        this.energyDrains = energyDrains;
        if (HexConfig.cfgGeneralMachineNetworkDebug && HexConfig.cfgGeneralNetworkDebug)
            System.out.println("[Energy Node Port: HEX] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Drains received. d: " + energyDrains.size());
    }

    /**
     * Called by drains to check if they can drain energy.
     * @return Boolean if energy can be drained.
     */
    @Override
    public boolean canDrainEnergy() {
        return hasEnergy
                && linkedPort != null
                && HexUtils.getMetaBitBiInt(HexEnergyNode.META_MODE_0, HexEnergyNode.META_MODE_1, worldObj, xCoord, yCoord, zCoord) == HexEnergyNode.PORT_MODE_OUTPUT;
    }

    /**
     * Called by drains to drain energy.
     * @param amount The amount of energy requested.
     * @return The amount of energy actually drained.
     */
    @Override
    public float drainEnergy(float amount) {
        if (canDrainEnergy()) {
            // If there is enough energy left this tick, return full requested energy to drain.
            if (energyBufferDrained + amount < getEnergyPerTick()) {
                energyBufferFilled = energyBufferFilled - amount;
                energyBufferDrained = energyBufferDrained + amount;
                if (HexConfig.cfgGeneralMachineNetworkDebug && HexConfig.cfgGeneralNetworkDebug)
                    System.out.println("[Energy Node Port: HEX] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Drain requested. r: " + amount + " d(f): " + amount + " t: " + energyBufferDrained);
                return amount;
            }
            // Otherwise, return only the remaining energy.
            else {
                float partial = getEnergyPerTick() - energyBufferDrained;
                energyBufferFilled = energyBufferFilled - partial;
                energyBufferDrained = getEnergyPerTick();
                if (HexConfig.cfgGeneralMachineNetworkDebug && HexConfig.cfgGeneralNetworkDebug)
                    System.out.println("[Energy Node Port: HEX] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Drain requested. r: " + amount + " d(p): " + partial + " t: " + energyBufferDrained);
                return partial;
            }
        }
        // If the source cannot provide energy, return 0.
        else {
            if (HexConfig.cfgGeneralMachineNetworkDebug && HexConfig.cfgGeneralNetworkDebug)
                System.out.println("[Energy Node Port: HEX] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Drain requested. r: " + amount + " d(n): " + 0 + " t: " + energyBufferDrained);
            return 0;
        }
    }

    /**
     * Called by drains to determine the amount of energy available per tick.
     * @return The amount of energy available per tick.
     */
    @Override
    public float getEnergyPerTick() {
        if (canDrainEnergy()) {
            ITileHexEnergyPort port = (ITileHexEnergyPort) worldObj.getTileEntity(linkedPort.x, linkedPort.y, linkedPort.z);
            return HexEnergyNode.parseEnergyPerTick(portType, portTier) * port.getMultiplier(portType, portTier, true);
        }
        else
            return 0;
    }

    /**
     * Called by Hexorium Probe to display tile entity info to chat.
     * @param player Player to show the message to.
     */
    @Override
    public void displayInfoSource(EntityPlayer player) {
        displayInfoPort(player);
    }

    /**** Custom Methods ****/

    /**
     * Sends a recheck request to all drains.
     */
    private void sendRecheck() {
        if (HexConfig.cfgGeneralMachineNetworkDebug && HexConfig.cfgGeneralNetworkDebug)
            System.out.println("[Energy Node Port: HEX] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Requesting recheck.");
        if (energyDrains != null)
            // Parse the whole energyDrains ArrayList and call recheckSources() on each of them.
            for (HexDevice entry : energyDrains)
                if (HexUtils.checkChunk(worldObj, entry.x, entry.z)) {
                    ITileHexEnergyDrain energyDrain = (ITileHexEnergyDrain) worldObj.getTileEntity(entry.x, entry.y, entry.z);
                    if (energyDrain != null)
                        energyDrain.recheckSources();
                }
    }

    /**** ITileHexEnergyDrain Methods ****/

    /**
     * Saves the ArrayList of energy sources.
     * @param energySources The ArrayList to save.
     */
    @Override
    public void setSources(ArrayList<HexDevice> energySources) {
        this.energySources = energySources;
        if (HexConfig.cfgGeneralMachineNetworkDebug && HexConfig.cfgGeneralNetworkDebug)
            System.out.println("[Energy Node Port: HEX] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Sources received. s: " + energySources.size());
        recheckSources();
    }

    /**
     * Called by sources to force drains to recheck them.
     */
    @Override
    public void recheckSources() {
        scanSources();
        if (HexConfig.cfgGeneralMachineNetworkDebug && HexConfig.cfgGeneralNetworkDebug)
            System.out.println("[Energy Node Port: HEX] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Recheck requested. s: " + usableSources);
    }

    /**
     * Called by Hexorium Probe to display tile entity info to chat.
     * @param player Player to show the message to.
     */
    @Override
    public void displayInfoDrain(EntityPlayer player) {
        displayInfoPort(player);
    }

    /**** Custom Methods ****/

    /**
     * Called to check if there are any usable sources available.
     */
    private void scanSources() {
        usableSources = 0;

        if(energySources != null)
            // Parse the whole energySources ArrayList and call canDrainSource() on each of them.
            for (HexDevice entry : energySources)
                if (HexUtils.checkChunk(worldObj, entry.x, entry.z)) {
                    ITileHexEnergySource energySource = (ITileHexEnergySource) worldObj.getTileEntity(entry.x, entry.y, entry.z);
                    if (energySource != null)
                        if (energySource.canDrainEnergy())
                            usableSources++;
                }
    }

    /**
     * Called to drain from all sources.
     */
    private void drainFromSources() {
        if (energySources != null)
            // Parse the whole energySources ArrayList and attempt to drain energy from every source.
            for (HexDevice entry : energySources)
                if (HexUtils.checkChunk(worldObj, entry.x, entry.z)) {
                    ITileHexEnergySource energySource = (ITileHexEnergySource) worldObj.getTileEntity(entry.x, entry.y, entry.z);
                    if (energySource != null)
                        if (energySource.canDrainEnergy())
                            if (energyBufferFilled + energyBufferDrained < energyBufferTotal) {
                                if (energyBufferTotal - energyBufferFilled - energyBufferDrained < energySource.getEnergyPerTick())
                                    energyBufferDrained = energyBufferDrained + energySource.drainEnergy(energyBufferTotal - energyBufferFilled - energyBufferDrained);
                                else
                                    energyBufferDrained = energyBufferDrained + energySource.drainEnergy(energySource.getEnergyPerTick());
                            }
                }
    }

    /**
     * Called to check if there are any usable sources available.
     * @return If there are any usable sources.
     */
    private boolean canDrainSource() {
        return usableSources > 0;
    }

    /**** ITileHexEnergyPort Methods ****/

    /**
     * Saves the ArrayList of energy ports.
     * @param energyPorts The ArrayList to save.
     */
    @Override
    public void setPorts(ArrayList<HexDevice> energyPorts) {

        if (energyPorts != null && energyPorts.size() != 0) {
            this.energyPorts = energyPorts;

            // If the port is already linked, analyze the incoming list and unlink if necessary.
            if (this.linkedPort != null) {
                boolean checkLink = false;
                for (HexDevice entry : this.energyPorts)
                    if (entry.x == this.linkedPort.x && entry.y == this.linkedPort.y && entry.z == this.linkedPort.z)
                        checkLink = true;
                if (!checkLink) {
                    breakPortLink();
                }
            }
        }
        else {
            this.energyPorts = null;
            breakPortLink();
        }
        if (HexConfig.cfgGeneralMachineNetworkDebug && HexConfig.cfgGeneralNetworkDebug) {
            if (this.energyPorts != null)
                System.out.println("[Energy Node Port: HEX] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Ports received. n: " + this.energyPorts.size());
            else
                System.out.println("[Energy Node Port: HEX] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Ports received. n: " + 0);
        }
    }

    /**
     * Called when setting up an Energy Node to set the tier.
     * @param portTier Tier of the port.
     */
    @Override
    public void setPortTier(int portTier) {
        this.portTier = portTier;
        if (HexConfig.cfgEnergyNodeDebug)
            System.out.println("[Energy Node Port: HEX] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Port tier set to: " + portTier);
    }

    /**
     * Checks if ports are connected via network.
     * @param x X coordinate of the target port.
     * @param y Y coordinate of the target port.
     * @param z Z coordinate of the target port.
     * @return Boolean whether the port are on same network.
     */
    @Override
    public boolean checkPortConnectivity(int x, int y, int z) {
        // Return true if the port exists in the list.
        if (energyPorts != null)
            for (HexDevice entry : energyPorts)
                if (entry.x == x && entry.y == y && entry.z == z)
                    return true;

        return false;
    }

    /**
     * Checks if ports are already linked.
     * @param x X coordinate of the target port.
     * @param y Y coordinate of the target port.
     * @param z Z coordinate of the target port.
     * @return Boolean whether the ports are already linked.
     */
    @Override
    public boolean checkPortLinked(int x, int y, int z) {
        // Return true if the port is already linked with target.
        return linkedPort != null && linkedPort.x == x && linkedPort.y == y && linkedPort.z == z;
    }

    /**
     * Called when linking ports.
     * @param x X coordinate of the calling port.
     * @param y Y coordinate of the calling port.
     * @param z Z coordinate of the calling port.
     * @return Whether the linking was successful.
     */
    @Override
    public boolean linkPort(int x, int y, int z) {
        ITileHexEnergyPort energyPort = (ITileHexEnergyPort) worldObj.getTileEntity(x, y, z);

        if (energyPort != null) {

            // If the port is already linked, unlink it.
            if (linkedPort != null) {
                ITileHexEnergyPort old = (ITileHexEnergyPort) worldObj.getTileEntity(linkedPort.x, linkedPort.y, linkedPort.z);
                if (old != null) {
                    old.breakPortLink();
                }
            }

            // Link the port with new target.
            linkedPort = new HexDevice(x, y, z, worldObj.getBlock(xCoord, yCoord, zCoord));
            return true;
        }
        return false;
    }

    /**
     * Breaks a link between two ports.
     */
    public void breakPortLink() {
        if (linkedPort != null) {
            ITileHexEnergyPort port = (ITileHexEnergyPort) worldObj.getTileEntity(linkedPort.x, linkedPort.y, linkedPort.z);

            unlinkPort();
            if (port != null)
                port.unlinkPort();

            unlinkPortAnalyze();
            if (port instanceof TileEnergyNodePortHEX) {
                TileEnergyNodePortHEX tileEnergyNodePortHEX = (TileEnergyNodePortHEX) port;
                tileEnergyNodePortHEX.unlinkPortAnalyze();
            }
        }
    }

    /**
     * Called when unlinking ports to set the link to null.
     */
    @Override
    public void unlinkPort() {
        linkedPort = null;
    }

    /**
     * Called to empty the buffer.
     */
    public void emptyBuffer() {
        energyBufferFilled = 0;
    }

    /**
     * Called by output ports to determine the conversion multiplier.
     * @param typeOut The type of energy of output port.
     * @param tierOut The tier of core of output port.
     * @param inverse Whether the conversion should be inverse (called by outputs).
     * @return The multiplier to use.
     */
    @Override
    public float getMultiplier(int typeOut, int tierOut, boolean inverse) {
        float multiplier = HexEnergyNode.parseConversionMultiplier(portType, typeOut);
        if (inverse)
            multiplier = 1F / multiplier;
        return multiplier * HexEnergyNode.parseEfficiencyMultiplier(portTier, tierOut);
    }

    /**
     * Called by output ports to drain energy.
     * @param amount The amount of energy requested.
     * @return The amount of energy actually drained.
     */
    @Override
    public float drainPortEnergy(float amount) {
        if (amount < energyBufferFilled) {
            energyBufferFilled = energyBufferFilled - amount;
            if (HexConfig.cfgEnergyNodeVerboseDebug && HexConfig.cfgEnergyNodeDebug)
                System.out.println("[Energy Node Port: HEX] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Port conversion requested. r: " + amount + " d(f): " + amount + " f: " + energyBufferFilled);
            return amount;
        }
        else {
            float partial = energyBufferFilled;
            energyBufferFilled = 0;
            if (HexConfig.cfgEnergyNodeVerboseDebug && HexConfig.cfgEnergyNodeDebug)
                System.out.println("[Energy Node Port: HEX] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Port conversion requested. r: " + amount + " d(p): " + partial + " f: " + energyBufferFilled);
            return partial;
        }
    }

    /**
     * Called by Hexorium Probe to display tile entity info to chat.
     * @param player Player to show the message to.
     */
    @Override
    public void displayInfoPort(EntityPlayer player) {
        player.addChatMessage(new ChatComponentTranslation(""));
        player.addChatMessage(new ChatComponentTranslation("[" + I18n.format("item.itemHexoriumProbe.name") + "]"));
        // If player is not sneaking.
        if (!player.isSneaking()) {
            player.addChatMessage(new ChatComponentTranslation("  " + I18n.format("msg.probeName.txt") + ": " + worldObj.getBlock(xCoord, yCoord, zCoord).getLocalizedName()));
            player.addChatMessage(new ChatComponentTranslation("  " + I18n.format("msg.probeType.txt") + ": " + I18n.format("msg.probeTypePort.txt")));
            int mode = HexUtils.getMetaBitBiInt(HexEnergyNode.META_MODE_0, HexEnergyNode.META_MODE_1, worldObj, xCoord, yCoord, zCoord);
            player.addChatMessage(new ChatComponentTranslation("  " + I18n.format("msg.probeMode.txt") + ": " + I18n.format("msg.probePortMode" + (mode + 1) + ".txt")));
            player.addChatMessage(new ChatComponentTranslation("  " + I18n.format("msg.probeEnergy.txt") + ": " + Math.round(energyBufferFilled) + " HEX / " + Math.round(energyBufferTotal) + " HEX"));
            if (HexUtils.getMetaBit(HexBlocks.META_STRUCTURE_IS_PART, worldObj, xCoord, yCoord, zCoord))
                player.addChatMessage(new ChatComponentTranslation("  " + I18n.format("msg.probeFormed.txt") + ": " + I18n.format("msg.probeYes.txt")));
            else
                player.addChatMessage(new ChatComponentTranslation("  " + I18n.format("msg.probeFormed.txt") + ": " + I18n.format("msg.probeNo.txt")));
            if (linkedPort != null) {
                player.addChatMessage(new ChatComponentTranslation("  " + I18n.format("msg.probeLinked.txt") + ": " + I18n.format("msg.probeYes.txt")));
                player.addChatMessage(new ChatComponentTranslation("    (" + linkedPort.x + ", " + linkedPort.y + ", " + linkedPort.z + ") "
                        + worldObj.getBlock(linkedPort.x, linkedPort.y, linkedPort.z).getLocalizedName()));
            }
            else
                player.addChatMessage(new ChatComponentTranslation("  " + I18n.format("msg.probeLinked.txt") + ": " + I18n.format("msg.probeNo.txt")));
        }
        // If player is sneaking.
        else {
            player.addChatMessage(new ChatComponentTranslation("  " + I18n.format("msg.probeConnectedSources.txt") + ":"));
            if (energySources != null && energySources.size() != 0)
                for (HexDevice entry : energySources)
                    player.addChatMessage(new ChatComponentTranslation("    (" + entry.x + ", " + entry.y + ", " + entry.z + ") "
                            + worldObj.getBlock(entry.x, entry.y, entry.z).getLocalizedName()));
            else
                player.addChatMessage(new ChatComponentTranslation("    " + I18n.format("msg.probeNone.txt")));

            player.addChatMessage(new ChatComponentTranslation("  " + I18n.format("msg.probeConnectedDrains.txt") + ":"));
            if (energyDrains != null && energyDrains.size() != 0)
                for (HexDevice entry : energyDrains)
                    player.addChatMessage(new ChatComponentTranslation("    (" + entry.x + ", " + entry.y + ", " + entry.z + ") "
                            + worldObj.getBlock(entry.x, entry.y, entry.z).getLocalizedName()));
            else
                player.addChatMessage(new ChatComponentTranslation("    " + I18n.format("msg.probeNone.txt")));

            player.addChatMessage(new ChatComponentTranslation("  " + I18n.format("msg.probeConnectedPorts.txt") + ":"));
            if (energyPorts != null && energyPorts.size() != 0)
                for (HexDevice entry : energyPorts)
                    player.addChatMessage(new ChatComponentTranslation("    (" + entry.x + ", " + entry.y + ", " + entry.z + ") "
                            + worldObj.getBlock(entry.x, entry.y, entry.z).getLocalizedName()));
            else
                player.addChatMessage(new ChatComponentTranslation("    " + I18n.format("msg.probeNone.txt")));
        }
    }

    /**** Custom Methods ****/

    /**
     * Called to get the tunneled port.
     */
    public HexDevice getTunnel() {
            return linkedPort;
    }

    /**
     * Called when unlinking ports, this method is called after unlinkPort.
     * Used to rescan the network.
     */
    public void unlinkPortAnalyze() {
        if (HexUtils.getMetaBitBiInt(HexEnergyNode.META_MODE_0, HexEnergyNode.META_MODE_1, worldObj, xCoord, yCoord, zCoord) == HexEnergyNode.PORT_MODE_TUNNEL) {
            // Locate the Energy Node Core.
            int xc = xCoord;
            int yc = yCoord;
            int zc = zCoord;
            int xp = xCoord;
            int yp = yCoord;
            int zp = zCoord;

            int side = 0;
            if (worldObj.getBlock(xCoord, yCoord + 1, zCoord) instanceof BlockEnergyNodeCore)
                side = 0;
            else if (worldObj.getBlock(xCoord, yCoord - 1, zCoord) instanceof BlockEnergyNodeCore)
                side = 1;
            else if (worldObj.getBlock(xCoord, yCoord, zCoord + 1) instanceof BlockEnergyNodeCore)
                side = 2;
            else if (worldObj.getBlock(xCoord, yCoord, zCoord - 1) instanceof BlockEnergyNodeCore)
                side = 3;
            else if (worldObj.getBlock(xCoord + 1, yCoord, zCoord) instanceof BlockEnergyNodeCore)
                side = 4;
            else if (worldObj.getBlock(xCoord - 1, yCoord, zCoord) instanceof BlockEnergyNodeCore)
                side = 5;

            switch (side) {
                case 0: yc++; yp--; break;
                case 1: yc--; yp++; break;
                case 2: zc++; zp--; break;
                case 3: zc--; zp++; break;
                case 4: xc++; xp--; break;
                case 5: xc--; xp++; break;
            }

            /* DO ANALYSIS */
            NetworkAnalyzer analyzerCore = new NetworkAnalyzer();
            analyzerCore.analyzeCable(worldObj, xc, yc, zc, worldObj.getBlock(xc, yc, zc));
            NetworkAnalyzer analyzerPort = new NetworkAnalyzer();
            analyzerPort.analyzeCable(worldObj, xp, yp, zp, worldObj.getBlock(xp, yp, zp));
        }
    }
}
