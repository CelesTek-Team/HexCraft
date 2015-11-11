package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.init.HexAchievements;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.util.HexDamage;
import com.celestek.hexcraft.util.HexDevice;
import com.celestek.hexcraft.util.HexUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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

public class TilePersonalTeleportationPad extends TileEntity implements ITileHexEnergyDrain {

    /**** Static Values ****/

    public static final String ID = "tilePersonalTeleportationPad";

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

    // Prepare sources list.
    private ArrayList<HexDevice> energySources;

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

    public TilePersonalTeleportationPad() {
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
            energyDrained = 0;

            // Check the situation in which the machine has available energy sources and items to process.
            if (canDrainSource() && (energyTotalDone < energyTotal * 2)) {
                // Attempt to start processing if it was inactive.
                if (!isActive)
                    isActive = usableSources > 0;

                // Check if the machine is now in its active state.
                if (isActive) {
                    // Drain from all sources.
                    drainFromSources();
                    energyTotalDone = energyTotalDone + energyDrained;
                }
            }
            // If the machine has no energy and/or there are no items to process, stop the processing.
            else
                stopProcessing();

            // If the teleporter is charging the teleport...
            if (isTeleporting) {
                if (teleportCounter >= teleportCountdown) {
                    // Perform the teleport.
                    teleport();
                    energyTotalDone = energyTotalDone - energyTotal;
                    if (energyTotalDone < 0)
                        energyTotalDone = 0;
                    isTeleporting = false;

                    // If there is still energy left, set the state to READY, otherwise DEAD.
                    if (energyTotalDone > 0)
                        HexBlocks.setMachineState(HexBlocks.MACHINE_STATE_READY, worldObj, xCoord, yCoord, zCoord);
                    else
                        HexBlocks.setMachineState(HexBlocks.MACHINE_STATE_DEAD, worldObj, xCoord, yCoord, zCoord);
                }
                else
                    teleportCounter++;
            }

            // Save the energy states to their GUI variables.
            guiEnergyTotalDone = Math.round(energyTotalDone);
            guiEnergyDrained = Math.round(energyDrained);
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
            System.out.println("[Personal Teleportation Pad] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Sources received. s: " + energySources.size());
        recheckSources();
    }

    /**
     * Called by sources to force drains to recheck them.
     */
    @Override
    public void recheckSources() {
        scanSources();
        if (HexConfig.cfgGeneralMachineNetworkDebug && HexConfig.cfgGeneralNetworkDebug)
            System.out.println("[Personal Teleportation Pad] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Recheck requested. s: " + usableSources);
    }

    /**** Custom Methods ****/

    private void scanSources() {
        boolean hasEnergy = canDrainSource();
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

        // Set the state to READY if the energy is now available, but wasn't previously.
        if (canDrainSource() && !hasEnergy && !isTeleporting)
            HexBlocks.setMachineState(HexBlocks.MACHINE_STATE_READY, worldObj, xCoord, yCoord, zCoord);

        // Otherwise, set the state to DEAD if the energy is now unavailable and there is no energy stored.
        else if (!canDrainSource() && hasEnergy && energyTotalDone <= 0 && !isTeleporting)
            HexBlocks.setMachineState(HexBlocks.MACHINE_STATE_DEAD, worldObj, xCoord, yCoord, zCoord);
    }

    /**** Custom Methods ****/

    /**
     * Called to check if there are any usable sources available.
     */
    private void drainFromSources() {
        if (energySources != null)
            // Parse the whole energySources ArrayList and attempt to drain energy from every source.
            for (HexDevice entry : energySources)
                if (HexUtils.checkChunk(worldObj, entry.x, entry.z)) {
                    ITileHexEnergySource energySource = (ITileHexEnergySource) worldObj.getTileEntity(entry.x, entry.y, entry.z);
                    if (energySource != null)
                        if (energySource.canDrainEnergy())
                            if (energyTotalDone + energyDrained < energyTotal * 2) {
                                if (energyTotal * 2 - energyTotalDone - energyDrained < energySource.getEnergyPerTick())
                                    energyDrained = energyDrained + energySource.drainEnergy(energyTotal * 2 - energyTotalDone - energyDrained);
                                else
                                    energyDrained = energyDrained + energySource.drainEnergy(energySource.getEnergyPerTick());
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

    /**
     * Called when the machine should no longer be processing the item.
     */
    public void stopProcessing() {
        if (isActive)
            isActive = false;
    }

    /**
     * Called by the NetworkAnalyzer class when exchanging data between teleports.
     * @param incomingTeleports The ArrayList of teleports received.
     */
    public void setTeleports(ArrayList<HexDevice> incomingTeleports) {

        if (incomingTeleports.size() != 0) {
            teleports = incomingTeleports;

            // If the teleport is already linked, analyze the incoming list and unlink if necessary.
            if (linkedTeleport != null) {
                boolean checkLink = false;
                for (HexDevice entry : teleports)
                    if (entry.x == linkedTeleport.x && entry.y == linkedTeleport.y && entry.z == linkedTeleport.z)
                        checkLink = true;
                if (!checkLink)
                    linkedTeleport = null;
            }
        }
        else {
            teleports = null;
            linkedTeleport = null;
        }
        if (HexConfig.cfgGeneralMachineNetworkDebug && HexConfig.cfgGeneralNetworkDebug) {
            if (teleports != null)
                System.out.println("[Personal Teleportation Pad] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Teleports received. t: " + teleports.size());
            else
                System.out.println("[Personal Teleportation Pad] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Teleports received. t: " + 0);
        }
    }

    /**
     * Begins teleportation.
     */
    public void beginTeleport() {
        // If the teleport is linked and has enough energy, get the player,
        // send the chat message and activate the countdown.
        if (linkedTeleport != null && energyTotalDone >= energyTotal) {
            EntityPlayer player = worldObj.getClosestPlayer(xCoord + 0.5, yCoord + 1, zCoord + 0.5, 4);

            if (player != null)
                player.addChatMessage(new ChatComponentTranslation("msg.teleportProcess1.txt"));
            isTeleporting = true;
            teleportCounter = 0;

            // Set the texture to ACTIVE.
            HexBlocks.setMachineState(HexBlocks.MACHINE_STATE_ACTIVE, worldObj, xCoord, yCoord, zCoord);
        }
    }

    /**
     * Performs the teleportation.
     */
    private void teleport() {
        EntityPlayer player = worldObj.getClosestPlayer(xCoord + 0.5, yCoord + 1, zCoord + 0.5, 1);

        if (player != null && linkedTeleport != null)

            // Check if the player is located on top of the teleport.
            if (player.posX >= xCoord && player.posX <= xCoord + 1 &&
                    player.posY >= yCoord && player.posY <= yCoord + 1 &&
                    player.posZ >= zCoord && player.posZ <= zCoord + 1) {

                // Send the chat message and teleport the player, while hurting and confusing them.
                player.addChatMessage(new ChatComponentTranslation("msg.teleportProcess2.txt"));
                player.setPositionAndUpdate(linkedTeleport.x + 0.5, linkedTeleport.y + 1, linkedTeleport.z + 0.5);
                if (HexConfig.cfgTeleportShouldDamagePlayers) {
                    player.addPotionEffect(new PotionEffect(Potion.confusion.getId(), 180, 100, false));
                    player.attackEntityFrom(HexDamage.teleport, HexConfig.cfgTeleportDamageAmount);
                }

                // Grant player the achievement.
                if (HexConfig.cfgGeneralUseAchievements)
                    player.addStat(HexAchievements.achUseTeleport, 1);
            }
    }

    /**
     * Checks if teleports are connected via network.
     * @param x Coordinate x of the target teleport.
     * @param y Coordinate y of the target teleport.
     * @param z Coordinate z of the target teleport.
     * @return Boolean whether the teleports are on same network.
     */
    public boolean checkConnectivity(int x, int y, int z) {
        // Return true if the teleport exists in the list.
        if (worldObj.getBlock(x, y, z) == HexBlocks.blockPersonalTeleportationPad)
            if (teleports != null)
                for (HexDevice entry : teleports)
                    if (entry.x == x && entry.y == y && entry.z == z)
                        return true;

        return false;
    }

    /**
     * Checks if teleports are already linked.
     * @param x Coordinate x of the target teleport.
     * @param y Coordinate y of the target teleport.
     * @param z Coordinate z of the target teleport.
     * @return Boolean whether the teleports are already linked.
     */
    public boolean checkLinked(int x, int y, int z) {
        // Return true if the teleport is already linked with target.
        return linkedTeleport != null && linkedTeleport.x == x && linkedTeleport.y == y && linkedTeleport.z == z;
    }

    /**
     * Links a teleport.
     * @param x Coordinate x of the target teleport.
     * @param y Coordinate y of the target teleport.
     * @param z Coordinate z of the target teleport.
     * @return Boolean whether the linking was successful.
     */
    public boolean linkTeleport(int x, int y, int z) {
        TilePersonalTeleportationPad tileEntity = (TilePersonalTeleportationPad) worldObj.getTileEntity(x, y, z);

        if (tileEntity != null) {

            // If the teleport is already linked, unlink it.
            if (linkedTeleport != null) {
                TilePersonalTeleportationPad old = (TilePersonalTeleportationPad) worldObj.getTileEntity(linkedTeleport.x, linkedTeleport.y, linkedTeleport.z);
                if (old != null)
                    old.unlinkTeleport();
            }

            // Link the teleport with new target.
            linkedTeleport = new HexDevice(x, y, z, HexBlocks.blockPersonalTeleportationPad);
            return true;
        }
        return false;
    }

    /**
     * Unlinks a teleport.
     */
    public void unlinkTeleport() {
        linkedTeleport = null;
    }

    /**
     * Check if the TIle Entity can be used by the player.
     */
    public boolean isUseableByPlayer(EntityPlayer player) {
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64.0D;
    }

    /**
     * Returns the scaled progress.
     * @param length Corresponds with the length of the progress bar.
     */
    @SideOnly(Side.CLIENT)
    public int getEnergyScaled(int length) {
        return guiEnergyTotalDone * length / (int) energyTotal;
    }

    /**** Getters and Setters ****/

    /**** Getters and Setters ****/

    /**
     * Retrieves the machine name.
     */
    public String getInventoryName() {
        return INVENTORY_NAME;
    }

    public void setGuiEnergyTotalDone(int guiEnergyTotalDone) {
        this.guiEnergyTotalDone = guiEnergyTotalDone;
    }

    public int getGuiEnergyTotalDone() {
        return this.guiEnergyTotalDone;
    }

    public void setGuiEnergyDrained(int guiEnergyDrained) {
        this.guiEnergyDrained = guiEnergyDrained;
    }

    public int getGuiEnergyDrained() {
        return this.guiEnergyDrained;
    }
}
