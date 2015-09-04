package com.celestek.hexcraft.inventory;

import com.celestek.hexcraft.block.BlockEnergizedHexorium;
import ibxm.Player;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-09-04
 */
public class InventoryMolecularTransposer implements IInventory {

    private final ItemStack device;
    private final EntityPlayer player;
    private ItemStack[] theInventory = new ItemStack[1];
    public static String name = "Molecular Tranposer";

    public InventoryMolecularTransposer(EntityPlayer player, ItemStack device)
    {
        this.player = player;
        this.device = device;

        // Read the items.
        this.theInventory = new ItemStack[getSizeInventory()];
        if (device.stackTagCompound == null)
            device.stackTagCompound = new NBTTagCompound();
        NBTTagList tagsItems = device.stackTagCompound.getTagList("Items", 10);
        for (int i = 0; i < tagsItems.tagCount(); ++i) {
            NBTTagCompound tagCompound1 = tagsItems.getCompoundTagAt(i);
            byte byte0 = tagCompound1.getByte("Slot");

            if (byte0 >= 0 && byte0 < theInventory.length) {
                theInventory[byte0] = ItemStack.loadItemStackFromNBT(tagCompound1);
            }
        }
    }

    /**
     * Returns the number of slots in the inventory.
     */
    @Override
    public int getSizeInventory()
    {
        return this.theInventory.length;
    }

    /**
     * Returns the stack in slot i
     */
    @Override
    public ItemStack getStackInSlot(int slot)
    {
        return this.theInventory[slot];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    @Override
    public ItemStack decrStackSize(int slot, int toDecr)
    {
        if (this.theInventory[slot] != null)
        {
            ItemStack itemstack;

            if (slot == 2)
            {
                itemstack = this.theInventory[slot];
                this.theInventory[slot] = null;
                return itemstack;
            }
            else if (this.theInventory[slot].stackSize <= toDecr)
            {
                itemstack = this.theInventory[slot];
                this.theInventory[slot] = null;

                return itemstack;
            }
            else
            {
                itemstack = this.theInventory[slot].splitStack(toDecr);

                if (this.theInventory[slot].stackSize == 0)
                {
                    this.theInventory[slot] = null;
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
        return null;
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    @Override
    public void setInventorySlotContents(int slot, ItemStack stack)
    {
        this.theInventory[slot] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }

        // Write the items.
        NBTTagList tagsItems = new NBTTagList();
        for (int i = 0; i < theInventory.length; i++)
            if (theInventory[i] != null) {
                NBTTagCompound tagCompoundLoop = new NBTTagCompound();
                tagCompoundLoop.setByte("Slot", (byte) i);
                theInventory[i].writeToNBT(tagCompoundLoop);
                tagsItems.appendTag(tagCompoundLoop);
            }
        device.stackTagCompound.setTag("Items", tagsItems);
        player.inventory.setInventorySlotContents(player.inventory.currentItem, device);
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
}
