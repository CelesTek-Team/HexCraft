package com.celestek.hexcraft.tileentity;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.util.HexDevice;
import com.celestek.hexcraft.util.HexEnergyNode;
import com.celestek.hexcraft.util.HexUtils;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class TileEnergyNodePortRF extends TileEntity implements ITileHexEnergyPort, IEnergyHandler {

    /**** Static Values ****/

    public static final String ID = "tileEnergyNodePortRF";

    // NBT Names
    private static final String NBT_ENERGY_PORTS = "energy_ports";

    private static final String NBT_LINKED_PORT_EXISTS = "linked_port_exists";
    private static final String NBT_LINKED_PORT = "linked_port";
    private static final String NBT_PORT_TIER = "port_tier";

    /**** Variables ****/

    // Prepare port list.
    private ArrayList<HexDevice> energyPorts;

    // Prepare energy buffer variables.
    private EnergyStorage energyBuffer;

    // Prepare port variables.
    private HexDevice linkedPort;
    private int portTier;
    private int portType;

    // RF Specific things.


    /**** Common TileEntity Methods ****/

    public TileEnergyNodePortRF() {

        this.energyBuffer = new EnergyStorage(0, 0, 0);

        this.portTier = 0;
        this.portType = HexEnergyNode.PORT_TYPE_RF;
    }

    /**
     * Writes the tags to NBT.
     */
    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);

        // Write the port list.
        HexUtils.writeHexDevicesArrayToNBT(tagCompound, NBT_ENERGY_PORTS, energyPorts);

        // Write the energy buffer variables.
        energyBuffer.writeToNBT(tagCompound);

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

        // Read the port list.
        energyPorts = HexUtils.readHexDevicesArrayFromNBT(tagCompound, NBT_ENERGY_PORTS);

        // Read the port variables.
        if (tagCompound.getBoolean(NBT_LINKED_PORT_EXISTS))
            linkedPort = HexUtils.readHexDeviceFromNBT(tagCompound, NBT_LINKED_PORT);
        else
            linkedPort = null;
        portTier = tagCompound.getInteger(NBT_PORT_TIER);
        energyBuffer.setCapacity((int) HexEnergyNode.parseEnergyPerTick(portType, portTier) * 2);

        // Read the energy buffer variables.
        energyBuffer.readFromNBT(tagCompound);
    }

    /**
     * Fired on every tick. Main processing is done here.
     */
    @Override
    public void updateEntity() {
        // Confirm that this is server side.
        if (!worldObj.isRemote) {
            // Situation in which the linked port is input, and this port is output.
            if (linkedPort != null
                    && HexUtils.getMetaBitBiInt(HexEnergyNode.META_MODE_0, HexEnergyNode.META_MODE_1, worldObj, linkedPort.x, linkedPort.y, linkedPort.z) == HexEnergyNode.PORT_MODE_INPUT
                    && HexUtils.getMetaBitBiInt(HexEnergyNode.META_MODE_0, HexEnergyNode.META_MODE_1, worldObj, xCoord, yCoord, zCoord) == HexEnergyNode.PORT_MODE_OUTPUT) {
                if (energyBuffer.getMaxExtract() == 0) {
                    energyBuffer.setMaxExtract((int) HexEnergyNode.parseEnergyPerTick(portType, portTier));
                    energyBuffer.setMaxReceive(0);
                    markDirty();
                }

                // Fill the port buffer until it is full.
                if (energyBuffer.getEnergyStored() < energyBuffer.getMaxEnergyStored()) {
                    ITileHexEnergyPort port = (ITileHexEnergyPort) worldObj.getTileEntity(linkedPort.x, linkedPort.y, linkedPort.z);
                    if (port != null) {
                        float multi = port.getMultiplier(portType, portTier);
                        float conv = HexEnergyNode.parseConversionMultiplier(port.getPortType(), portType);
                        energyBuffer.setEnergyStored((int) Math.ceil(
                                energyBuffer.getEnergyStored() + port.drainPortEnergy((energyBuffer.getMaxEnergyStored() - energyBuffer.getEnergyStored()) / conv) * multi));
                    }
                }

                if (energyBuffer.getEnergyStored() > 0) {
                    for (int i = 0; i < 6; i++) {
                        TileEntity tile = worldObj.getTileEntity(
                                xCoord + ForgeDirection.getOrientation(i).offsetX,
                                yCoord + ForgeDirection.getOrientation(i).offsetY,
                                zCoord + ForgeDirection.getOrientation(i).offsetZ);
                        if (tile instanceof IEnergyHandler && !(tile instanceof ITileHexEnergyPort)) {
                            energyBuffer.extractEnergy(((IEnergyHandler)tile).receiveEnergy(
                                    ForgeDirection.getOrientation(i).getOpposite(),
                                    energyBuffer.extractEnergy(energyBuffer.getMaxExtract(), true), false), false);
                        }
                    }
                }
            }
            // Situation in which the linked port is output, and this port is input.
            else if (linkedPort != null
                    && HexUtils.getMetaBitBiInt(HexEnergyNode.META_MODE_0, HexEnergyNode.META_MODE_1, worldObj, linkedPort.x, linkedPort.y, linkedPort.z) == HexEnergyNode.PORT_MODE_OUTPUT
                    && HexUtils.getMetaBitBiInt(HexEnergyNode.META_MODE_0, HexEnergyNode.META_MODE_1, worldObj, xCoord, yCoord, zCoord) == HexEnergyNode.PORT_MODE_INPUT) {
                if (energyBuffer.getMaxReceive() == 0) {
                    energyBuffer.setMaxExtract(0);
                    energyBuffer.setMaxReceive((int) HexEnergyNode.parseEnergyPerTick(portType, portTier));
                    markDirty();
                }
            }
            else {
                energyBuffer.setMaxExtract(0);
                energyBuffer.setMaxReceive(0);
            }
        }
    }

    /**** IEnergyHandler Methods ****/

    /**
     * Returns TRUE if the TileEntity can connect on a given side.
     */
    @Override
    public boolean canConnectEnergy(ForgeDirection from) {
        return HexUtils.getMetaBit(HexBlocks.META_STRUCTURE_IS_PART, worldObj, xCoord, yCoord, zCoord);
    }

    /**
     * Add energy to an IEnergyReceiver, internal distribution is left entirely to the IEnergyReceiver.
     * @param from Orientation the energy is received from.
     * @param maxReceive Maximum amount of energy to receive.
     * @param simulate If TRUE, the charge will only be simulated.
     * @return Amount of energy that was (or would have been, if simulated) received.
     */
    @Override
    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
        return energyBuffer.receiveEnergy(maxReceive, simulate);
    }

    /**
     * Remove energy from an IEnergyProvider, internal distribution is left entirely to the IEnergyProvider.
     * @param from Orientation the energy is extracted from.
     * @param maxExtract Maximum amount of energy to extract.
     * @param simulate If TRUE, the extraction will only be simulated.
     * @return Amount of energy that was (or would have been, if simulated) extracted.
     */
    @Override
    public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
        return energyBuffer.extractEnergy(maxExtract, simulate);
    }


    /**
     * Returns the amount of energy currently stored.
     */
    @Override
    public int getEnergyStored(ForgeDirection from) {
        return energyBuffer.getEnergyStored();
    }

    /**
     * Returns the maximum amount of energy that can be stored.
     */
    @Override
    public int getMaxEnergyStored(ForgeDirection from) {
        return energyBuffer.getMaxEnergyStored();
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
                System.out.println("[Energy Node Port: RF] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Ports received. n: " + this.energyPorts.size());
            else
                System.out.println("[Energy Node Port: RF] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Ports received. n: " + 0);
        }
        markDirty();
    }

    /**
     * Called when setting up an Energy Node to set the tier.
     * @param portTier Tier of the port.
     */
    @Override
    public void setPortTier(int portTier) {
        this.portTier = portTier;
        this.energyBuffer.setCapacity((int) HexEnergyNode.parseEnergyPerTick(this.portType, this.portTier) * 2);

        energyBuffer.setMaxExtract(0);
        energyBuffer.setMaxReceive(0);
        markDirty();

        if (HexConfig.cfgEnergyNodeDebug)
            System.out.println("[Energy Node Port: RF] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Port tier set to: " + portTier);
    }

    /**
     * Called when retrieving the tier.
     * @return Tier integer.
     */
    @Override
    public int getPortTier() {
        return this.portTier;
    }

    /**
     * Called when retrieving the type.
     * @return Tier integer.
     */
    @Override
    public int getPortType() {
        return this.portType;
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
            markDirty();
            return true;
        }
        return false;
    }

    /**
     * Breaks a link between two ports.
     */
    @Override
    public void breakPortLink() {
        if (linkedPort != null) {
            ITileHexEnergyPort port = (ITileHexEnergyPort) worldObj.getTileEntity(linkedPort.x, linkedPort.y, linkedPort.z);

            unlinkPort();
            if (port != null)
                port.unlinkPort();

            if (port instanceof TileEnergyNodePortHEX) {
                TileEnergyNodePortHEX tileEnergyNodePortHEX = (TileEnergyNodePortHEX) port;
                tileEnergyNodePortHEX.unlinkPortAnalyze();
            }
            markDirty();
        }
    }

    /**
     * Called when unlinking ports to set the link to null.
     */
    @Override
    public void unlinkPort() {
        linkedPort = null;
        markDirty();
    }

    /**
     * Called to empty the buffer.
     */
    @Override
    public void emptyBuffer() {
        energyBuffer.setEnergyStored(0);
        markDirty();
    }

    /**
     * Called by output ports to determine the conversion multiplier.
     * @param typeOut The type of energy of output port.
     * @param tierOut The tier of core of output port.
     * @return The multiplier to use.
     */
    @Override
    public float getMultiplier(int typeOut, int tierOut) {
        return HexEnergyNode.parseConversionMultiplier(portType, typeOut) * HexEnergyNode.parseEfficiencyMultiplier(portTier, tierOut);
    }

    /**
     * Called by output ports to drain energy.
     * @param amount The amount of energy requested.
     * @return The amount of energy actually drained.
     */
    @Override
    public float drainPortEnergy(float amount) {
        if (amount < energyBuffer.getEnergyStored()) {
            energyBuffer.setEnergyStored(Math.round(energyBuffer.getEnergyStored() - amount));
            if (HexConfig.cfgEnergyNodeVerboseDebug && HexConfig.cfgEnergyNodeDebug)
                System.out.println("[Energy Node Port: RF] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Port conversion requested. r: " + amount + " d(f): " + amount + " f: " + energyBuffer.getEnergyStored());
            return amount;
        }
        else {
            float partial = energyBuffer.getEnergyStored();
            energyBuffer.setEnergyStored(0);
            if (HexConfig.cfgEnergyNodeVerboseDebug && HexConfig.cfgEnergyNodeDebug)
                System.out.println("[Energy Node Port: RF] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Port conversion requested. r: " + amount + " d(p): " + partial + " f: " + energyBuffer.getEnergyStored());
            return partial;
        }
    }

    /**
     * Called by Hexorium Probe to display tile entity info to chat.
     * @param player Player to show the message to.
     */
    @Override
    public void displayInfoPort(EntityPlayer player) {
        HexUtils.addChatProbeTitle(player);
        // If player is not sneaking.
        if (!player.isSneaking()) {
            HexUtils.addChatProbeGenericInfo(player, worldObj, xCoord, yCoord, zCoord);
            player.addChatMessage(new ChatComponentTranslation("msg.probeTypePort.txt"));
            int mode = HexUtils.getMetaBitBiInt(HexEnergyNode.META_MODE_0, HexEnergyNode.META_MODE_1, worldObj, xCoord, yCoord, zCoord);
            player.addChatMessage(new ChatComponentTranslation("msg.probePortMode" + (mode + 1) + ".txt"));
            player.addChatMessage(new ChatComponentTranslation("msg.probeEnergy.txt",  energyBuffer.getEnergyStored(), "RF",
                    energyBuffer.getMaxEnergyStored(), "RF"));

            boolean isPart = HexUtils.getMetaBit(HexBlocks.META_STRUCTURE_IS_PART, worldObj, xCoord, yCoord, zCoord);
            if (isPart && linkedPort != null && mode == HexEnergyNode.PORT_MODE_INPUT) {
                ITileHexEnergyPort port = (ITileHexEnergyPort) worldObj.getTileEntity(linkedPort.x, linkedPort.y, linkedPort.z);
                player.addChatMessage(new ChatComponentTranslation("msg.probeEfficiency.txt", (portTier + 1),
                        Math.round((1 - HexEnergyNode.parseEfficiencyMultiplier(portTier, port.getPortTier())) * 100), 0, "RF"));
            }
            else if (isPart && linkedPort != null && mode == HexEnergyNode.PORT_MODE_OUTPUT) {
                ITileHexEnergyPort port = (ITileHexEnergyPort) worldObj.getTileEntity(linkedPort.x, linkedPort.y, linkedPort.z);
                player.addChatMessage(new ChatComponentTranslation("msg.probeEfficiency.txt", (portTier + 1),
                        Math.round((1 - HexEnergyNode.parseEfficiencyMultiplier(portTier, port.getPortTier())) * 100),
                        energyBuffer.getMaxExtract(), "RF"));
            }
            else if (isPart)
                player.addChatMessage(new ChatComponentTranslation("msg.probeEfficiencyTier.txt", (portTier + 1)));
            else
                player.addChatMessage(new ChatComponentTranslation("msg.probeEfficiencyNotFormed.txt"));

            if (isPart)
                player.addChatMessage(new ChatComponentTranslation("msg.probeFormedYes.txt"));
            else
                player.addChatMessage(new ChatComponentTranslation("msg.probeFormedNo.txt"));
            if (linkedPort != null) {
                player.addChatMessage(new ChatComponentTranslation("msg.probeLinkedYes.txt"));
                player.addChatMessage(new ChatComponentTranslation("msg.probeConnectedEntry.txt", linkedPort.x, linkedPort.y, linkedPort.z,
                        worldObj.getBlock(linkedPort.x, linkedPort.y, linkedPort.z).getLocalizedName()));
            }
            else
                player.addChatMessage(new ChatComponentTranslation("msg.probeLinkedNo.txt"));
        }
        // If player is sneaking.
        else {
            player.addChatMessage(new ChatComponentTranslation("msg.probeConnectedPorts.txt"));
            HexUtils.addChatProbeConnectedMachines(player, energyPorts, worldObj, xCoord, yCoord, zCoord);
        }
    }
}
