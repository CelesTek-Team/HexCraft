package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.util.HexDevice;
import com.celestek.hexcraft.util.HexEnergyNode;
import com.celestek.hexcraft.util.HexUtils;
import gregapi.code.TagData;
import gregapi.data.TD;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import gregapi.tileentity.energy.ITileEntityEnergy;

import java.util.*;

import static java.util.Collections.EMPTY_LIST;

public class TileEnergyNodePortLU extends TileEntity implements ITileHexEnergyPort, ITileEntityEnergy {

    /**** Static Values ****/

    public static final String ID = "tileEnergyNodePortLU";

    // NBT Names
    private static final String NBT_ENERGY_PORTS = "energy_ports";

    private static final String NBT_ENERGY_BUFFER_FILLED = "energy_buffer_filled";

    private static final String NBT_LINKED_PORT_EXISTS = "linked_port_exists";
    private static final String NBT_LINKED_PORT = "linked_port";
    private static final String NBT_PORT_TIER = "port_tier";
    private static final String NBT_PORT_EFFICIENCY = "port_efficiency";

    /**** Variables ****/

    // Prepare port list.
    private ArrayList<HexDevice> energyPorts;

    // Prepare energy buffer variables.
    private float energyBufferTotal;
    private float energyBufferFilled;

    // Prepare port variables.
    private HexDevice linkedPort;
    private int portTier;
    private int portEfficiency;
    private final int portType;

    // LU Specific things
    private boolean mIsDead;


    /**** Common TileEntity Methods ****/

    public TileEnergyNodePortLU() {

        this.energyBufferTotal = 0;
        this.energyBufferFilled = 0;

        this.portTier = 0;
        this.portEfficiency = 0;
        this.portType = HexEnergyNode.PORT_TYPE_LU;

        this.mIsDead = false;
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
        tagCompound.setFloat(NBT_ENERGY_BUFFER_FILLED, energyBufferFilled);

        // Write the port variables.
        HexUtils.writeHexDeviceToNBT(tagCompound, NBT_LINKED_PORT, linkedPort);
        tagCompound.setBoolean(NBT_LINKED_PORT_EXISTS, linkedPort != null);
        tagCompound.setInteger(NBT_PORT_TIER, portTier);
        tagCompound.setInteger(NBT_PORT_EFFICIENCY, portEfficiency);
    }

    /**
     * Reads the tags from NBT.
     */
    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);

        // Read the port list.
        energyPorts = HexUtils.readHexDevicesArrayFromNBT(tagCompound, NBT_ENERGY_PORTS);

        // Read the energy buffer variables.
        energyBufferFilled = tagCompound.getFloat(NBT_ENERGY_BUFFER_FILLED);

        // Read the port variables.
        if (tagCompound.getBoolean(NBT_LINKED_PORT_EXISTS))
            linkedPort = HexUtils.readHexDeviceFromNBT(tagCompound, NBT_LINKED_PORT);
        else
            linkedPort = null;
        portTier = tagCompound.getInteger(NBT_PORT_TIER);
        portEfficiency = tagCompound.getInteger(NBT_PORT_EFFICIENCY);
        energyBufferTotal = HexEnergyNode.parseEnergyPerTick(portType, portTier) * HexConfig.cfgEnergyBufferMultiplier;
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

                // Fill the port buffer until it is full.
                if (energyBufferFilled < energyBufferTotal) {
                    ITileHexEnergyPort port = (ITileHexEnergyPort) worldObj.getTileEntity(linkedPort.x, linkedPort.y, linkedPort.z);
                    if (port != null) {
                        float multi = port.getMultiplier(portType, portEfficiency);
                        float conv = HexEnergyNode.parseConversionMultiplier(port.getPortType(), portType);
                        energyBufferFilled = energyBufferFilled + port.drainPortEnergy((energyBufferTotal - energyBufferFilled) / conv) * multi;
                    }
                }

                long size = Math.round(HexEnergyNode.parseEnergyPerTick(this.portType, this.portTier));
                if (Math.max(0, energyBufferFilled) > size)
                    energyBufferFilled -= ITileEntityEnergy.Util.emitEnergyToNetwork(TD.Energy.LU, size, 1, this) * size;
            }
        }
    }

    /**
     * Forward for the base TileEntity's invalidate(), used for destroying the energy net link.
     * Both invalidate and onChunkUnload have to be used.
     */
    @Override
    public void invalidate() {
        super.invalidate();

        onChunkUnload();
    }

    @Override
    public void onChunkUnload() {
        super.onChunkUnload();
        mIsDead = true;
    }

    /**** ITileEntityEnergy Methods ****/

    /**
     * You do not have to check for this Function, this is only for things like Energy Network optimisation and similar.
     *
     * @param aEnergyType The Type of Energy
     * @param aEmitting if it is asked to emit this Energy Type, otherwise it is asked to accept this Energy Type.
     * @param aSide 0 - 5 = Vanilla Directions of the Implementors Block. 6 = No specific Side (don't do Side checks for this Side)
     * @return if this TileEntity has anything to do with this Type of Energy, depending on insert or extract request. The returning Value must be constant for this TileEntity.
     */
    @Override
    public boolean isEnergyType(TagData aEnergyType, byte aSide, boolean aEmitting) {
        return HexUtils.getMetaBit(HexBlocks.META_STRUCTURE_IS_PART, worldObj, xCoord, yCoord, zCoord) && aEnergyType == TD.Energy.LU;
    }

    /**
     * Gets all the Types of Energy, which are relevant to this TileEntity.
     *
     * @param aSide 0 - 5 = Vanilla Directions of the Implementors Block. 6 = No specific Side (should return all related Types of Energy)
     * @return any Type of Energy that is related to this TileEntity. This is especially useful for Data Displays and Redstone Conditions, where people can select the Energy Type via GUI or something.
     */
    @Override
    @SuppressWarnings("unchecked")
    public Collection<TagData> getEnergyTypes(byte aSide) {
        if (HexUtils.getMetaBit(HexBlocks.META_STRUCTURE_IS_PART, worldObj, xCoord, yCoord, zCoord))
            return TD.Energy.LU.AS_LIST;
        else
            return EMPTY_LIST;
    }

    // Connectivity

    /**
     * This Method may be called by a different Thread. Take that into account when implementing it.
     *
     * @param aEnergyType The Type of Energy
     * @param aSide 0 - 5 = Vanilla Directions of the Implementors Block. 6 = No specific Side (don't do Side checks for this Side)
     * @param aTheoretical true if this is only checking for Conductor Connections. Use it in case things like Redstone or Covers for example can toggle the connectivity of this Side for this Energy Type, but you still want to visually connect to it, even if it temporarily wouldn't accept Energy Interactions from that Side right now. Basically, so that the Conductor doesn't visually toggle on/off all the time causing Sync Lag.
     */
    @Override
    public boolean isEnergyAcceptingFrom(TagData aEnergyType, byte aSide, boolean aTheoretical) {
        if (isFormedInput())
            return aEnergyType == TD.Energy.LU;
        else
            return false;
    }

    /**
     * This Method may be called by a different Thread. Take that into account when implementing it. As in do not make a direct call to set Blocks or explode things, just set a flag to do it in the next tick.
     *
     * @param aEnergyType The Type of Energy
     * @param aSide 0 - 5 = Vanilla Directions of the Implementors Block. 6 = No specific Side (don't do Side checks for this Side)
     * @param aTheoretical true if this is only checking for Conductor Connections. Use it in case things like Redstone or Covers for example can toggle the connectivity of this Side for this Energy Type, but you still want to visually connect to it, even if it temporarily wouldn't accept Energy Interactions from that Side right now. Basically, so that the Conductor doesn't visually toggle on/off all the time causing Sync Lag.
     */
    @Override
    public boolean isEnergyEmittingTo(TagData aEnergyType, byte aSide, boolean aTheoretical) {
        if (isFormedOutput())
            return aEnergyType == TD.Energy.LU;
        else
            return false;
    }

    // Push based Energy.

    /**
     * This Method may be called by a different Thread. Take that into account when implementing it. As in do not make a direct call to set Blocks or explode things, just set a flag to do it in the next tick.
     *
     * Inject Energy Call for Electricity. Gets called by EnergyEmitters to inject Energy into your Block
     *
     * Note: The IMPLEMENTOR of this Function has to check for isEnergyAcceptingFrom, when implementing this Function, NOT the one injecting the Energy, because the Network won't check for that by itself.
     *
     * @param aEnergyType The Type of Energy
     * @param aDoInject if this is supposed to increase the internal Energy. true = Yes, this is a normal Operation. false = No, this is just a simulation.
     * @param aSide 0 - 5 = Vanilla Directions of the Implementors Block. 6 = No specific Side (don't do Side checks for this Side)
     * @return amount of used aAmount. 0 if not accepted anything.
     */
    @Override
    public long doEnergyInjection(TagData aEnergyType, byte aSide, long aSize, long aAmount, boolean aDoInject) {
        aSize = Math.abs(aSize);
        if (linkedPort != null && aSize >= getEnergySizeInputMin(aEnergyType, aSide) && aSize <= getEnergySizeInputMax(aEnergyType, aSide)) {
            if (Math.max(0, energyBufferTotal - energyBufferFilled) > aSize) {
                long pushed = Math.min(Math.round(Math.floor(Math.max(0, energyBufferTotal - energyBufferFilled))), aSize * aAmount);
                if (aDoInject)
                    energyBufferFilled += pushed - pushed % aSize;
                return pushed / aSize;
            }
        }
        return 0;
    }

    /**
     * This Method may be called by a different Thread. Take that into account when implementing it.
     *
     * Some Energy Networks use this Value to pre-calculate the Energy Flow.
     *
     * @param aEnergyType The Type of Energy
     * @param aSide 0 - 5 = Vanilla Directions of the Implementors Block. 6 = No specific Side (don't do Side checks for this Side)
     * @param aSize the Energy Packet Size to be demanded. getEnergySizeInputRecommended is the recommended Power Level.
     * @return The Amount of Energy Packets of aSize Size this TileEntity needs
     */
    @Override
    public long getEnergyDemanded(TagData aEnergyType, byte aSide, long aSize) {
        aSize = Math.abs(aSize);
        if (linkedPort != null && aSize >= getEnergySizeInputMin(aEnergyType, aSide) && aSize <= getEnergySizeInputMax(aEnergyType, aSide)) {
            if (Math.max(0, energyBufferTotal - energyBufferFilled) > aSize) {
                long demanded = Math.round(Math.floor(Math.max(0, energyBufferTotal - energyBufferFilled)));
                return demanded / aSize;
            }
        }
        return 0;
    }


    // Pull based Energy.

    /**
     * This Method may be called by a different Thread. Take that into account when implementing it.
     *
     * Extract Energy Call for Electricity. Gets called by Energy Networks to extract Energy from your Block
     *
     * Note: The IMPLEMENTOR of this Function has to check for isEnergyEmittingTo, when implementing this Function, NOT the one extracting the Energy, because the Network won't check for that by itself.
     *
     * @param aEnergyType The Type of Energy
     * @param aDoExtract if this is supposed to decrease the internal Energy. true = Yes, this is a normal Operation. false = No, this is just a simulation.
     * @param aSide 0 - 5 = Vanilla Directions of the Implementors Block. 6 = No specific Side (don't do Side checks for this Side)
     * @return amount of taken aAmount. 0 if not accepted anything.
     */
    @Override
    public long doEnergyExtraction(TagData aEnergyType, byte aSide, long aSize, long aAmount, boolean aDoExtract) {
        aSize = Math.abs(aSize);
        if (aAmount >= 1 && linkedPort != null && aSize >= getEnergySizeOutputMin(aEnergyType, aSide) && aSize <= getEnergySizeOutputMax(aEnergyType, aSide)) {
            if (Math.max(0, energyBufferFilled) > aSize) {
                if (aDoExtract)
                    energyBufferFilled -= aSize;
                return 1;
            }
        }
        return 0;
    }

    /**
     * This Method may be called by a different Thread. Take that into account when implementing it.
     *
     * Some Energy Networks use this Value to pre-calculate the Energy Flow.
     *
     * @param aEnergyType The Type of Energy
     * @param aSide 0 - 5 = Vanilla Directions of the Implementors Block. 6 = No specific Side (don't do Side checks for this Side)
     * @param aSize the Energy Packet Size to be taken. getEnergySizeOutputRecommended is the recommended Power Level.
     * @return The Amount of Energy Packets of aSize Size this TileEntity offers
     */
    @Override
    public long getEnergyOffered(TagData aEnergyType, byte aSide, long aSize) {
        aSize = Math.abs(aSize);
        if (linkedPort != null && aSize >= getEnergySizeOutputMin(aEnergyType, aSide) && aSize <= getEnergySizeOutputMax(aEnergyType, aSide)) {
            if (Math.max(0, energyBufferFilled) > aSize)
                return 1;
        }
        return 0;
    }


    // Parameters for the minimum Packet Sizes in order for things to actually work.

    @Override
    public long getEnergySizeInputMin(TagData aEnergyType, byte aSide) {
        if (isFormedInput() && aEnergyType == TD.Energy.LU)
            return Math.round(Math.floor(HexEnergyNode.parseEnergyPerTick(this.portType, this.portTier)
                    - HexEnergyNode.parseEnergyPerTick(this.portType, this.portTier) * HexConfig.cfgEnergyTransferLUMinMulti));
        else
            return 0;
    }

    @Override
    public long getEnergySizeOutputMin(TagData aEnergyType, byte aSide) {
        if (isFormedOutput() && aEnergyType == TD.Energy.LU)
            return Math.round(Math.floor(HexEnergyNode.parseEnergyPerTick(this.portType, this.portTier)
                    - HexEnergyNode.parseEnergyPerTick(this.portType, this.portTier) * HexConfig.cfgEnergyTransferLUMinMulti));
        else
            return 0;
    }

    @Override
    public long getEnergySizeInputRecommended(TagData aEnergyType, byte aSide) {
        if (isFormedInput() && aEnergyType == TD.Energy.LU)
            return Math.round(Math.floor(HexEnergyNode.parseEnergyPerTick(this.portType, this.portTier)));
        else
            return 0;
    }

    @Override
    public long getEnergySizeOutputRecommended(TagData aEnergyType, byte aSide) {
        if (isFormedOutput() && aEnergyType == TD.Energy.LU)
            return Math.round(Math.floor(HexEnergyNode.parseEnergyPerTick(this.portType, this.portTier)));
        else
            return 0;
    }

    @Override
    public long getEnergySizeInputMax(TagData aEnergyType, byte aSide) {
        if (isFormedInput() && aEnergyType == TD.Energy.LU)
            return Math.round(Math.floor(HexEnergyNode.parseEnergyPerTick(this.portType, this.portTier)
                    + HexEnergyNode.parseEnergyPerTick(this.portType, this.portTier) * HexConfig.cfgEnergyTransferLUMaxMulti));
        else
            return 0;
    }

    @Override
    public long getEnergySizeOutputMax(TagData aEnergyType, byte aSide) {
        if (isFormedOutput() && aEnergyType == TD.Energy.LU)
            return Math.round(Math.floor(HexEnergyNode.parseEnergyPerTick(this.portType, this.portTier)
                    + HexEnergyNode.parseEnergyPerTick(this.portType, this.portTier) * HexConfig.cfgEnergyTransferLUMaxMulti));
        else
            return 0;
    }

    @Override
    public boolean isDead() {
        return this.mIsDead || isInvalid();
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
                System.out.println("[Energy Node Port: LU] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Ports received. n: " + this.energyPorts.size());
            else
                System.out.println("[Energy Node Port: LU] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Ports received. n: " + 0);
        }
        markDirty();
    }

    /**
     * Called when setting up an Energy Node to set the tier.
     * @param portTier Tier of the port.
     */
    @Override
    public void setupPort(int portTier, int portEfficiency) {
        this.portTier = portTier;
        this.portEfficiency = portEfficiency;
        this.energyBufferTotal = HexEnergyNode.parseEnergyPerTick(this.portType, this.portTier) * HexConfig.cfgEnergyBufferMultiplier;

        if (HexConfig.cfgEnergyNodeDebug)
            System.out.println("[Energy Node Port: LU] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Port tier set to: " + portTier);
        markDirty();
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
     * Called when retrieving the efficiency tier.
     * @return Efficiency tier integer.
     */
    public int getPortEfficiency() {
        return this.portEfficiency;
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
        energyBufferFilled = 0;
        markDirty();
    }

    /**
     * Called by output ports to determine the conversion multiplier.
     * @param typeOut The type of energy of output port.
     * @param efficiencyOut The tier of core of output port.
     * @return The multiplier to use.
     */
    @Override
    public float getMultiplier(int typeOut, int efficiencyOut) {
        return HexEnergyNode.parseConversionMultiplier(portType, typeOut) * HexEnergyNode.parseEfficiencyMultiplier(portEfficiency, efficiencyOut);
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
                System.out.println("[Energy Node Port: LU] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Port conversion requested. r: " + amount + " d(f): " + amount + " f: " + energyBufferFilled);
            return amount;
        }
        else {
            float partial = energyBufferFilled;
            energyBufferFilled = 0;
            if (HexConfig.cfgEnergyNodeVerboseDebug && HexConfig.cfgEnergyNodeDebug)
                System.out.println("[Energy Node Port: LU] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Port conversion requested. r: " + amount + " d(p): " + partial + " f: " + energyBufferFilled);
            return partial;
        }
    }

    /**
     * Called by Hexorium Probe to display tile entity info to chat.
     * @param player Player to show the message to.
     */
    @Override
    public void displayInfoPort(EntityPlayer player) {
        HexEnergyNode.displayInfoPort("LU", player, energyPorts, linkedPort, worldObj, xCoord, yCoord, zCoord, portType, portTier, portEfficiency, energyBufferFilled, energyBufferTotal);
    }

    /**
     * Check if the port is formed and is input.
     * @return Boolean result.
     */
    @Override
    public boolean isFormedInput() {
        return HexUtils.getMetaBit(HexBlocks.META_STRUCTURE_IS_PART, worldObj, xCoord, yCoord, zCoord) &&
                HexUtils.getMetaBitBiInt(HexEnergyNode.META_MODE_0, HexEnergyNode.META_MODE_1, worldObj, xCoord, yCoord, zCoord) == HexEnergyNode.PORT_MODE_INPUT;
    }

    /**
     * Check if the port is formed and is output.
     * @return Boolean result.
     */
    @Override
    public boolean isFormedOutput() {
        return HexUtils.getMetaBit(HexBlocks.META_STRUCTURE_IS_PART, worldObj, xCoord, yCoord, zCoord) &&
                HexUtils.getMetaBitBiInt(HexEnergyNode.META_MODE_0, HexEnergyNode.META_MODE_1, worldObj, xCoord, yCoord, zCoord) == HexEnergyNode.PORT_MODE_OUTPUT;
    }
}
