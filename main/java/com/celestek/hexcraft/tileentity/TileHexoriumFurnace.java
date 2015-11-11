package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.util.HexDevice;
import com.celestek.hexcraft.util.HexUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.7.0
 */

public class TileHexoriumFurnace extends TileEntity implements ISidedInventory, ITileHexEnergyDrain {

    /**** Static Values ****/

    public static final String ID = "tileHexoriumFurnace";

    private static final String INVENTORY_NAME = "hexcraft.container.hexoriumFurnace";

    // NBT Names
    private static final String NBT_ENERGY_SOURCES = "energy_sources";

    private static final String NBT_ENERGY_TOTAL_DONE = "energy_total_done";
    private static final String NBT_ENERGY_DRAINED = "energy_drained";

    private static final String NBT_GUI_ENERGY_TOTAL_DONE = "gui_energy_total_done";
    private static final String NBT_GUI_ENERGY_DRAINED = "gui_energy_drained";

    private static final String NBT_IS_ACTIVE = "is_active";
    private static final String NBT_USABLE_SOURCES = "usable_sources";

    /**** Variables ****/

    // Prepare sources list.
    private ArrayList<HexDevice> energySources;

    // Prepare energy variables.
    private int energyPerTick;
    private float energyTotal;
    private float energyTotalDone;
    private float energyDrained;

    // Prepare GUI energy variables.
    private int guiEnergyTotalDone;
    private int guiEnergyDrained;

    // Prepare state variables.
    private boolean isActive;
    private int usableSources;

    // Define sides and slots.
    private static final int[] slotsTop = new int[] { 0 };
    private static final int[] slotsSide = new int[] { 1 };
    private static final int[] slotsBlank = new int[] { 2 };
    private ItemStack[] inventory;

    /**** Common TileEntity Methods ****/

    public TileHexoriumFurnace() {
        this.inventory = new ItemStack[3];
        this.energyTotal = 3200;
        this.energyPerTick = 32;
        this.isActive = false;
        this.usableSources = 0;
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

        // Write the container.
        HexUtils.writeInventoryToNBT(tagCompound, inventory);
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

        // Read the container.
        inventory = HexUtils.readInventoryFromNBT(tagCompound, getSizeInventory());
    }

    /**
     * Fired on every tick. Main processing is done here.
     */
    @Override
    public void updateEntity() {
        if (!worldObj.isRemote) {
            energyDrained = 0;

            // Check the situation in which the machine has available energy sources and items to process.
            if (canDrainSource() && canProcess()) {
                // Attempt to start processing if it was inactive and set the state to ACTIVE if so.
                if (!isActive) {
                    isActive = usableSources > 0;
                    if (isActive)
                        HexBlocks.setMachineState(HexBlocks.MACHINE_STATE_ACTIVE, worldObj, xCoord, yCoord, zCoord);
                    else
                        energyDrained = -1;
                }

                // Check if the machine is now in its active state.
                if (isActive) {
                    // Drain from all sources.
                    drainFromSources();

                    // If the total energy drained is 0, stop processing. Otherwise increment the progress by the amount drained.
                    if (energyDrained == 0)
                        stopProcessing();
                    else
                        energyTotalDone = energyTotalDone + energyDrained;

                    // If the energy has reached required energy for the process, set it back to 0 and process the item.
                    if (energyTotalDone >= energyTotal) {
                        energyTotalDone = 0;
                        processItem();
                    }
                }
            }
            // If the machine has no energy and/or there are no items to process, stop the processing.
            else
                stopProcessing();

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
            System.out.println("[Hexorium Furnace] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Sources received. s: " + energySources.size());
        recheckSources();
    }

    /**
     * Called by sources to force drains to recheck them.
     */
    @Override
    public void recheckSources() {
        scanSources();
        if (HexConfig.cfgGeneralMachineNetworkDebug && HexConfig.cfgGeneralNetworkDebug)
            System.out.println("[Hexorium Furnace] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Recheck requested. s: " + usableSources);
    }

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

        // Set the state to READY if the energy is now available, but wasn't previously, or if the machine was active, but no longer should be.
        if ((canDrainSource() && !hasEnergy) || (HexBlocks.getMachineState(worldObj, xCoord, yCoord, zCoord) == HexBlocks.MACHINE_STATE_ACTIVE && !isActive))
            HexBlocks.setMachineState(HexBlocks.MACHINE_STATE_READY, worldObj, xCoord, yCoord, zCoord);

            // Otherwise, set the state to DEAD if the energy is now unavailable, but was previously.
        else if (!canDrainSource() && hasEnergy)
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
                            if (energyTotalDone + energyDrained < energyTotal) {
                                if (energyTotal - energyTotalDone - energyDrained < energyPerTick / usableSources)
                                    energyDrained = energyDrained + energySource.drainEnergy(energyTotal - energyTotalDone - energyDrained);
                                else
                                    energyDrained = energyDrained + energySource.drainEnergy((float) energyPerTick / usableSources);
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
        energyTotalDone = 0;
        // If the machine is active, make it inactive and recheck the sources.
        if (isActive) {
            isActive = false;
            scanSources();
        }

        if (!canDrainSource()) {
            HexBlocks.setMachineState(HexBlocks.MACHINE_STATE_DEAD, worldObj, xCoord, yCoord, zCoord);
        }
    }

    /**
     * Called to check if the machine can process a certain item.
     * @return If the item can be processed.
     */
    private boolean canProcess() {
        if (this.inventory[0] == null)
            // Return false if a stack does not exist. Machine cannot process it.
            return false;
        else {
            ItemStack itemStack = FurnaceRecipes.smelting().getSmeltingResult(inventory[0]);
            if (itemStack == null)
                // Return false if the result of processing would result in no item.
                return false;
            if (inventory[1] == null)
                // Return true if there is space in the results slot.
                return true;
            if (!inventory[1].isItemEqual(itemStack))
                // Return false if the item in results slot is not the same one as processing result.
                return false;
            int result = inventory[1].stackSize + itemStack.stackSize;
            // Return true or false depending if the result can fit in the results slot.
            return result <= getInventoryStackLimit() && result <= inventory[1].getMaxStackSize();
        }
    }

    /**
     * Called to execute the item processing.
     */
    private void processItem() {
        if (canProcess()) {
            ItemStack itemStack = FurnaceRecipes.smelting().getSmeltingResult(inventory[0]);

            if (inventory[1] == null)
                inventory[1] = itemStack.copy();
            else if (inventory[1].getItem() == itemStack.getItem())
                inventory[1].stackSize += itemStack.stackSize;

            inventory[0].stackSize--;
            if (inventory[0].stackSize == 0)
                inventory[0] = null;
        }
    }

    /**
     * Returns the scaled progress.
     * @param length Corresponds with the length of the progress bar.
     */
    @SideOnly(Side.CLIENT)
    public int getEnergyScaled(int length) {
        return guiEnergyTotalDone * length / (int) energyTotal;
    }

    /**** ISidedInventory Methods ****/

    /**
     * Return the item slots depending on side. Used for blocks like Hopper.
     */
    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        // Get the machine meta.
        int meta = blockMetadata;

        // Strip away the texture states from meta.
        if (meta >= 4 && meta < 8)
            meta -= 4;
        else if (meta >= 8)
            meta -= 8;

        // Make side slot available only from front, and top from top.
        if (side == 1)
            return slotsTop;
        else if (side == 2 && meta == 0)
            return slotsSide;
        else if (side == 3 && meta == 2)
            return slotsSide;
        else if (side == 4 && meta == 3)
            return slotsSide;
        else if (side == 5 && meta == 1)
            return slotsSide;
        else
            return slotsBlank;
    }

    /**
     * Check if item can be inserted.
     */
    @Override
    public boolean canInsertItem(int slot, ItemStack itemstack, int par3) {
        return isItemValidForSlot(slot, itemstack);
    }

    /**** IInventory Methods ****/

    /**
     * Fired when opening the container.
     */
    @Override
    public void openInventory() {

    }

    /**
     * Fired when closing the container.
     */
    @Override
    public void closeInventory() {

    }

    /**
     * Default methods used for managing the item slots.
     */
    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int count) {
        if (inventory[slot] != null) {
            ItemStack itemStack;
            if (inventory[slot].stackSize <= count) {
                itemStack = inventory[slot];
                inventory[slot] = null;
                return itemStack;
            } else {
                itemStack = inventory[slot].splitStack(count);

                if (inventory[slot].stackSize == 0) {
                    inventory[slot] = null;
                }
                return itemStack;
            }
        } else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        if (inventory[slot] != null) {
            ItemStack itemstack = inventory[slot];
            inventory[slot] = null;
            return itemstack;
        } else {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {
        inventory[slot] = itemStack;

        if (itemStack != null && itemStack.stackSize > getInventoryStackLimit()) {
            itemStack.stackSize = getInventoryStackLimit();
        }
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    /**
     * Check if the item is valid for a certain slot.
     */
    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
        return slot == 0;
    }

    /**
     * Check if item can be extracted.
     */
    @Override
    public boolean canExtractItem(int par1, ItemStack itemstack, int par3) {
        return par3 != 0;
    }

    /**
     * Retrieves the machine name.
     */
    @Override
    public String getInventoryName() {
        return INVENTORY_NAME;
    }

    /**
     * Confirms that the machine has custom name.
     */
    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }

    /**
     * Check if the TIle Entity can be used by the player.
     */
    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64.0D;
    }

    /**** Getters and Setters ****/

    public int getEnergyPerTick() {
        return this.energyPerTick;
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
