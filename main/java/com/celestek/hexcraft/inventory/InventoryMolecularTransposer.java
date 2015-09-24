package com.celestek.hexcraft.inventory;

import com.celestek.hexcraft.block.BlockEnergizedHexorium;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.6.2

 */
public class InventoryMolecularTransposer implements IInventory {

    private final ItemStack device;
    private final EntityPlayer player;
    private ItemStack[] inventory = new ItemStack[1];
    public static String name = "Molecular Transposer";

    public InventoryMolecularTransposer(EntityPlayer player, ItemStack device)
    {
        this.player = player;
        this.device = device;

        readNBT();
    }

    /**
     * Returns the number of slots in the inventory.
     */
    @Override
    public int getSizeInventory()
    {
        return this.inventory.length;
    }

    /**
     * Returns the stack in slot i
     */
    @Override
    public ItemStack getStackInSlot(int slot)
    {
        return this.inventory[slot];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    @Override
    public ItemStack decrStackSize(int slot, int toDecr)
    {
        if (this.inventory[slot] != null)
        {
            ItemStack itemstack;

            if (slot == 2)
            {
                itemstack = this.inventory[slot];
                this.inventory[slot] = null;

                return itemstack;
            }
            else if (this.inventory[slot].stackSize <= toDecr)
            {
                itemstack = this.inventory[slot];
                this.inventory[slot] = null;

                return itemstack;
            }
            else
            {
                itemstack = this.inventory[slot].splitStack(toDecr);

                if (this.inventory[slot].stackSize == 0)
                {
                    this.inventory[slot] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        if (inventory[0] != null)
            if (!(Block.getBlockFromItem(inventory[0].getItem()) instanceof BlockEnergizedHexorium)) {
                player.dropPlayerItemWithRandomChoice(inventory[0], false);
                inventory[0] = null;
            }
        writeNBT();
        return null;
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    @Override
    public void setInventorySlotContents(int slot, ItemStack stack)
    {
        this.inventory[slot] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }
    }

    /**
     * Returns the name of the inventory
     */
    @Override
    public String getInventoryName()
    {
        return name;
    }

    /**
     * Returns if the inventory is named
     */
    @Override
    public boolean hasCustomInventoryName()
    {
        return false;
    }

    /**
     * Returns the maximum stack size for a inventory slot.
     */
    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    @Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return true;
    }

    @Override
    public void openInventory() {
    }

    @Override
    public void closeInventory() {
    }

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack)
    {
        return Block.getBlockFromItem(stack.getItem()) instanceof BlockEnergizedHexorium;
    }

    /**
     * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think it
     * hasn't changed and skip it.
     */
    @Override
    public void markDirty()
    {
    }

    /**
     * Writes the inventory.
     */
    private void writeNBT() {
        // Write the items.
        NBTTagList tagsItems = new NBTTagList();
        if (inventory[0] != null) {
            NBTTagCompound tagCompoundLoop = new NBTTagCompound();
            inventory[0].writeToNBT(tagCompoundLoop);
            tagsItems.appendTag(tagCompoundLoop);
        }
        device.stackTagCompound.setTag("Items", tagsItems);
        player.inventory.setInventorySlotContents(player.inventory.currentItem, device);
    }

    /**
     * Reads the inventory.
     */
    private void readNBT() {
        this.inventory = new ItemStack[getSizeInventory()];

        if (device.stackTagCompound == null)
            device.stackTagCompound = new NBTTagCompound();

        NBTTagList tagsItems = device.stackTagCompound.getTagList("Items", 10);
        NBTTagCompound tagCompound1 = tagsItems.getCompoundTagAt(0);
        inventory[0] = ItemStack.loadItemStackFromNBT(tagCompound1);
    }
}
