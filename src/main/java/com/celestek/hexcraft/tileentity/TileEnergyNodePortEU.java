package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.util.HexDevice;
import com.celestek.hexcraft.util.HexEnergyNode;
import com.celestek.hexcraft.util.HexUtils;
import cpw.mods.fml.common.FMLCommonHandler;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergySink;
import ic2.api.energy.tile.IEnergySource;
import ic2.api.info.Info;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;

public class TileEnergyNodePortEU extends TileEntity implements ITileHexEnergyPort, IEnergySource, IEnergySink {

    /**** Static Values ****/

    public static final String ID = "tileEnergyNodePortEU";

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

    // EU Specific things.
    private boolean addedToEnet;
    private boolean switchedA;
    private boolean switchedB;


    /**** Common TileEntity Methods ****/

    public TileEnergyNodePortEU() {

        this.energyBufferTotal = 0;
        this.energyBufferFilled = 0;

        this.portTier = 0;
        this.portEfficiency = 0;
        this.portType = HexEnergyNode.PORT_TYPE_EU;

        this.addedToEnet = false;
        this.switchedA = false;
        this.switchedB = false;
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
        if (!addedToEnet) onLoaded();
        // Confirm that this is server side.
        if (!worldObj.isRemote) {
            // Situation in which the linked port is input, and this port is output.
            if (linkedPort != null
                    && HexUtils.getMetaBitBiInt(HexEnergyNode.META_MODE_0, HexEnergyNode.META_MODE_1, worldObj, linkedPort.x, linkedPort.y, linkedPort.z) == HexEnergyNode.PORT_MODE_INPUT
                    && HexUtils.getMetaBitBiInt(HexEnergyNode.META_MODE_0, HexEnergyNode.META_MODE_1, worldObj, xCoord, yCoord, zCoord) == HexEnergyNode.PORT_MODE_OUTPUT) {
                if (!switchedA) {
                    switchedA = true;
                    switchedB = false;
                    MinecraftForge.EVENT_BUS.post(new EnergyTileUnloadEvent(this));
                    MinecraftForge.EVENT_BUS.post(new EnergyTileLoadEvent(this));
                }

                // Fill the port buffer until it is full.
                if (energyBufferFilled < energyBufferTotal) {
                    ITileHexEnergyPort port = (ITileHexEnergyPort) worldObj.getTileEntity(linkedPort.x, linkedPort.y, linkedPort.z);
                    if (port != null) {
                        float multi = port.getMultiplier(portType, portEfficiency);
                        float conv = HexEnergyNode.parseConversionMultiplier(port.getPortType(), portType);
                        energyBufferFilled = energyBufferFilled + port.drainPortEnergy((energyBufferTotal - energyBufferFilled) / conv) * multi;
                    }
                }
            }
            // Situation in which the linked port is output, and this port is input.
            else if (linkedPort != null
                    && HexUtils.getMetaBitBiInt(HexEnergyNode.META_MODE_0, HexEnergyNode.META_MODE_1, worldObj, linkedPort.x, linkedPort.y, linkedPort.z) == HexEnergyNode.PORT_MODE_OUTPUT
                    && HexUtils.getMetaBitBiInt(HexEnergyNode.META_MODE_0, HexEnergyNode.META_MODE_1, worldObj, xCoord, yCoord, zCoord) == HexEnergyNode.PORT_MODE_INPUT) {
                if (!switchedB) {
                    switchedA = false;
                    switchedB = true;
                    MinecraftForge.EVENT_BUS.post(new EnergyTileUnloadEvent(this));
                    MinecraftForge.EVENT_BUS.post(new EnergyTileLoadEvent(this));
                }
            }
            else {
                switchedA = false;
                switchedB = false;
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

    /**
     * Forward for the base TileEntity's onChunkUnload(), used for destroying the energy net link.
     * Both invalidate and onChunkUnload have to be used.
     */
    @Override
    public void onChunkUnload() {
        if (addedToEnet &&
                Info.isIc2Available()) {
            MinecraftForge.EVENT_BUS.post(new EnergyTileUnloadEvent(this));

            addedToEnet = false;
        }
    }

    /**** Custom Methods ****/

    /**
     * Notification that the base TileEntity finished loading, for advanced uses.
     * Either updateEntity or onLoaded have to be used.
     */
    public void onLoaded() {
        if (!addedToEnet && !FMLCommonHandler.instance().getEffectiveSide().isClient() && Info.isIc2Available()) {
            MinecraftForge.EVENT_BUS.post(new EnergyTileLoadEvent(this));
            addedToEnet = true;
        }
    }

    /**** IEnergySource Methods ****/

    /**
     * Energy output provided by the source this tick.
     * This is typically Math.min(stored energy, max output/tick).
     * @return Energy offered this tick
     */
    @Override
    public double getOfferedEnergy() {
        if (linkedPort != null && isFormedOutput())
            return Math.min(energyBufferFilled, HexEnergyNode.parseEnergyPerTick(this.portType, this.portTier));
        else
            return 0;
    }

    /**
     * Draw energy from this source's buffer.
     * If the source doesn't have a buffer, this is a no-op.
     * @param amount amount of EU to draw, may be negative
     */
    @Override
    public void drawEnergy(double amount) {
        energyBufferFilled -= amount;
    }

    /**
     * Determine the tier of this energy source.
     * 1 = LV, 2 = MV, 3 = HV, 4 = EV etc.
     * @return tier of this energy source
     */
    @Override
    public int getSourceTier() {
        switch (portTier) {
            case 0: return HexConfig.cfgEnergyTransferTier1EU;
            case 1: return HexConfig.cfgEnergyTransferTier2EU;
            case 2: return HexConfig.cfgEnergyTransferTier3EU;
            case 3: return HexConfig.cfgEnergyTransferTier4EU;
            default: return 0;
        }
    }

    /**** IEnergyEmitter Methods ****/

    /**
     * Determine if this emitter can emit energy to an adjacent receiver.
     * The TileEntity in the receiver parameter is what was originally added to the energy net,
     * which may be normal in-world TileEntity, a delegate or an IMetaDelegate.
     * @param receiver receiver, may also be null or an IMetaDelegate
     * @param direction direction the receiver is from the emitter
     * @return Whether energy should be emitted
     */
    @Override
    public boolean emitsEnergyTo(TileEntity receiver, ForgeDirection direction) {
        return isFormedOutput();
    }

    /**** IEnergySink Methods ****/

    /**
     * Determine how much energy the sink accepts.
     * Make sure that injectEnergy() does accepts energy if demandsEnergy() returns anything > 0.
     * @return max accepted input in eu
     */
    @Override
    public double getDemandedEnergy() {
        if (linkedPort != null && isFormedInput() && (energyBufferTotal - energyBufferFilled) > HexEnergyNode.parseEnergyPerTick(this.portType, this.portTier))
            return Math.max(0, energyBufferTotal - energyBufferFilled);
        else
            return 0;
    }

    /**
     * Determine the tier of this energy sink.
     * 1 = LV, 2 = MV, 3 = HV, 4 = EV etc.
     * @return tier of this energy sink
     */
    @Override
    public int getSinkTier() {
        switch (portTier) {
            case 0: return HexConfig.cfgEnergyTransferTier1EU;
            case 1: return HexConfig.cfgEnergyTransferTier2EU;
            case 2: return HexConfig.cfgEnergyTransferTier3EU;
            case 3: return HexConfig.cfgEnergyTransferTier4EU;
            default: return 0;
        }
    }

    /**
     * Transfer energy to the sink.
     * It's highly recommended to accept all energy by letting the internal buffer overflow to
     * increase the performance and accuracy of the distribution simulation.
     * @param directionFrom direction from which the energy comes from
     * @param amount energy to be transferred
     * @return Energy not consumed (leftover)
     */
    @Override
    public double injectEnergy(ForgeDirection directionFrom, double amount, double voltage) {
        energyBufferFilled += amount;
        return 0;
    }

    /**** IEnergyAcceptor Methods ****/

    /**
     * Determine if this acceptor can accept current from an adjacent emitter in a direction.
     * The TileEntity in the emitter parameter is what was originally added to the energy net,
     * which may be normal in-world TileEntity, a delegate or an IMetaDelegate.
     * @param emitter energy emitter, may also be null or an IMetaDelegate
     * @param direction direction the energy is being received from
     */
    @Override
    public boolean acceptsEnergyFrom(TileEntity emitter, ForgeDirection direction) {
        return isFormedInput();
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
                System.out.println("[Energy Node Port: EU] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Ports received. n: " + this.energyPorts.size());
            else
                System.out.println("[Energy Node Port: EU] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Ports received. n: " + 0);
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

        switchedA = false;
        switchedB = false;
        MinecraftForge.EVENT_BUS.post(new EnergyTileUnloadEvent(this));
        MinecraftForge.EVENT_BUS.post(new EnergyTileLoadEvent(this));

        if (HexConfig.cfgEnergyNodeDebug)
            System.out.println("[Energy Node Port: EU] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Port tier set to: " + portTier);
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
                System.out.println("[Energy Node Port: EU] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Port conversion requested. r: " + amount + " d(f): " + amount + " f: " + energyBufferFilled);
            return amount;
        }
        else {
            float partial = energyBufferFilled;
            energyBufferFilled = 0;
            if (HexConfig.cfgEnergyNodeVerboseDebug && HexConfig.cfgEnergyNodeDebug)
                System.out.println("[Energy Node Port: EU] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Port conversion requested. r: " + amount + " d(p): " + partial + " f: " + energyBufferFilled);
            return partial;
        }
    }

    /**
     * Called by Hexorium Probe to display tile entity info to chat.
     * @param player Player to show the message to.
     */
    @Override
    public void displayInfoPort(EntityPlayer player) {
        HexEnergyNode.displayInfoPort("EU", player, energyPorts, linkedPort, worldObj, xCoord, yCoord, zCoord, portType, portTier, portEfficiency, energyBufferFilled, energyBufferTotal);
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
