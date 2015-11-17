package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.block.BlockEnergyNodeCore;
import com.celestek.hexcraft.init.HexAchievements;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.util.HexDamage;
import com.celestek.hexcraft.util.HexDevice;
import com.celestek.hexcraft.util.HexUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;

import java.util.ArrayList;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.7.0
 */

public class TileEnergyNodePortHEX extends TileEntity implements ITileHexEnergyPort {

    /**** Static Values ****/

    public static final String ID = "tileEnergyNodePortHEX";

    private static final String INVENTORY_NAME = "hexcraft.container.personalTeleportationPad";

    // NBT Names
    private static final String NBT_ENERGY_SOURCES = "energy_sources";

    private static final String NBT_ENERGY_TOTAL_DONE = "energy_total_done";
    private static final String NBT_ENERGY_DRAINED = "energy_drained";

    private static final String NBT_GUI_ENERGY_TOTAL_DONE = "gui_energy_total_done";
    private static final String NBT_GUI_ENERGY_DRAINED = "gui_energy_drained";

    private static final String NBT_IS_ACTIVE = "is_active";
    private static final String NBT_USABLE_SOURCES = "usable_sources";

    private static final String NBT_TELEPORTS = "teleports";
    private static final String NBT_LINKED_TELEPORT_EXISTS = "linked_teleport_exists";
    private static final String NBT_LINKED_TELEPORT = "linked_teleport";
    private static final String NBT_IS_TELEPORTING = "is_teleporting";
    private static final String NBT_TELEPORT_COUNTER = "teleport_counter";

    /**** Variables ****/

    // Perpare the port variables.
    private int portTier;

    // Prepare sources list.
    private ArrayList<HexDevice> energySources;
    private ArrayList<HexDevice> energyPorts;
    private HexDevice linkedPort;

    // Prepare energy variables.
    private float energyTotal;
    private float energyTotalDone;
    private float energyDrained;

    // Prepare GUI energy variables.
    private int guiEnergyTotalDone;
    private int guiEnergyDrained;

    // Prepare state variables.
    private boolean isActive;
    private int usableSources;

    // Prepare teleport variables.
    private ArrayList<HexDevice> teleports;
    private HexDevice linkedTeleport;
    private boolean isTeleporting;
    private int teleportCountdown;
    private int teleportCounter;


    /**** Common TileEntity Methods ****/

    public TileEnergyNodePortHEX() {
        this.portTier = 0;

        this.energyTotal = HexConfig.cfgTeleportUsageCost;
        this.isActive = false;
        this.usableSources = 0;
        this.isTeleporting = false;
        this.teleportCountdown = 80;
        this.teleportCounter = 0;
    }

    /**
     * Writes the tags to NBT.
     */
    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);

        // Write the drains.
        HexUtils.writeHexDevicesArrayToNBT(tagCompound, NBT_ENERGY_SOURCES, energySources);

        // Write the energy variables.
        tagCompound.setFloat(NBT_ENERGY_TOTAL_DONE, energyTotalDone);
        tagCompound.setFloat(NBT_ENERGY_DRAINED, energyDrained);

        // Write the GUI energy variables.
        tagCompound.setInteger(NBT_GUI_ENERGY_TOTAL_DONE, guiEnergyTotalDone);
        tagCompound.setInteger(NBT_GUI_ENERGY_DRAINED, guiEnergyDrained);

        // Write the state variables.
        tagCompound.setBoolean(NBT_IS_ACTIVE, isActive);
        tagCompound.setInteger(NBT_USABLE_SOURCES, usableSources);

        // Write the teleport variables.
        HexUtils.writeHexDevicesArrayToNBT(tagCompound, NBT_TELEPORTS, teleports);
        HexUtils.writeHexDeviceToNBT(tagCompound, NBT_LINKED_TELEPORT, linkedTeleport);
        tagCompound.setBoolean(NBT_LINKED_TELEPORT_EXISTS, linkedTeleport != null);
        tagCompound.setBoolean(NBT_IS_TELEPORTING, isTeleporting);
        tagCompound.setInteger(NBT_TELEPORT_COUNTER, teleportCounter);
    }

    /**
     * Reads the tags from NBT.
     */
    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);

        // Read the sources.
        energySources = HexUtils.readHexDevicesArrayFromNBT(tagCompound, NBT_ENERGY_SOURCES);

        // Read the energy variables.
        energyTotalDone = tagCompound.getFloat(NBT_ENERGY_TOTAL_DONE);
        energyDrained = tagCompound.getFloat(NBT_ENERGY_DRAINED);

        // Read the GUI energy variables.
        guiEnergyTotalDone = tagCompound.getInteger(NBT_GUI_ENERGY_TOTAL_DONE);
        guiEnergyDrained = tagCompound.getInteger(NBT_GUI_ENERGY_DRAINED);

        // Read the state variables.
        isActive = tagCompound.getBoolean(NBT_IS_ACTIVE);
        usableSources = tagCompound.getInteger(NBT_USABLE_SOURCES);

        // Read the teleport variables.
        teleports = HexUtils.readHexDevicesArrayFromNBT(tagCompound, NBT_TELEPORTS);
        if (tagCompound.getBoolean(NBT_LINKED_TELEPORT_EXISTS))
            linkedTeleport = HexUtils.readHexDeviceFromNBT(tagCompound, NBT_LINKED_TELEPORT);
        else
            linkedTeleport = null;
        isTeleporting = tagCompound.getBoolean(NBT_IS_TELEPORTING);
        teleportCounter = tagCompound.getInteger(NBT_TELEPORT_COUNTER);
    }

    /**
     * Fired on every tick. Main processing is done here.
     */
    @Override
    public void updateEntity() {
        // Confirm that this is server side.
        if (!worldObj.isRemote) {

        }
    }

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
                if (!checkLink)
                    unlinkPort();
            }
        }
        else {
            this.energyPorts = null;
            unlinkPort();
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
     * @param block The Energy Node Core.
     */
    @Override
    public void setCoreTier(Block block) {
        if (block == HexBlocks.blockEnergyNodeCoreT1)
            portTier = 0;
        else if (block == HexBlocks.blockEnergyNodeCoreT2)
            portTier = 1;
        else if (block == HexBlocks.blockEnergyNodeCoreT3)
            portTier = 2;
        else if (block == HexBlocks.blockEnergyNodeCoreT4)
            portTier = 3;

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
                if (old != null)
                    old.unlinkPort();
            }

            // Link the port with new target.
            linkedPort = new HexDevice(x, y, z, worldObj.getBlock(xCoord, yCoord, zCoord));
            return true;
        }
        return false;
    }

    /**
     * Called when unlinking ports.
     */
    @Override
    public void unlinkPort() {
        linkedPort = null;
    }

    /**
     * Called by output ports to determine the conversion multiplier.
     * @param typeOut The type of energy of output port.
     * @param tierOut The tier of core of output port.
     * @return The multiplier to use.
     */
    @Override
    public float getConversionMultiplier(String typeOut, int tierOut) {
        return 0;
    }

    /**
     * Called by output ports to drain energy.
     * @param amount The amount of energy requested.
     * @return The amount of energy actually drained.
     */
    @Override
    public float drainPortEnergy(float amount) {
        return 0;
    }
}
