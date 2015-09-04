package com.celestek.hexcraft.inventory;

import com.celestek.hexcraft.block.BlockEnergizedHexorium;
import com.celestek.hexcraft.tileentity.TileHexoriumGenerator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ibxm.Player;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.6.1
 * @since 2015-04-25
 */
public class ContainerMolecularTransposer extends Container {

    // Prepare the Tile Entity.
    private ItemStack device;
    InventoryMolecularTransposer inventory;

    // Prepare the variables to store GUI data.
    private int lastEnergy;
    private int lastEnergyTotal;
    private int lastEnergyOut;

    /**
     * Constructor
     */
    public ContainerMolecularTransposer(EntityPlayer player, InventoryPlayer playerInv, ItemStack device){
        // Save the Tile Entity.
        this.device = device;

        // Add the container slots.
        inventory = new InventoryMolecularTransposer(player, device);
        addSlotToContainer(new Slot(inventory, 0, 80, 36));

        // Add inventory slots.
        int i;
        for(i = 0; i < 3; ++i){
            for(int j = 0; j < 9; ++j){
                addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        // Add action bar slots.
        for(i = 0; i < 9; ++i){
            if (playerInv.getStackInSlot(i) == playerInv.getCurrentItem())
                addSlotToContainer(new SlotLocked(playerInv, i, 8 + i * 18, 142));
            else
                addSlotToContainer(new Slot(playerInv, i, 8 + i * 18, 142));
        }
    }

    /**
     * Check if the container can be interacted with by the player.
     */
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    /**
     * Called when the container is closed.
     */
    @Override
    public void onContainerClosed(EntityPlayer player)
    {
        super.onContainerClosed(player);

        if (!player.worldObj.isRemote)
            inventory.getStackInSlotOnClosing(0);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int par2){
        ItemStack itemStack = null;
        Slot slot = (Slot) inventorySlots.get(par2);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();

            if (par2 != 0) {
                if (Block.getBlockFromItem(itemStack1.getItem()) instanceof BlockEnergizedHexorium) {
                    if (!mergeItemStack(itemStack1, 0, 1, false)) {
                        //writeNBT(player, itemStack1);
                        return null;
                    }
                } else if(par2 >= 1 && par2 < 28) {
                    if (!mergeItemStack(itemStack1, 28, 37, false)) {
                        //writeNBT(player, itemStack1);
                        return null;
                    }
                } else if( par2 >= 28 && par2 < 38 && !mergeItemStack(itemStack1, 1, 28, false)) {
                    //writeNBT(player, itemStack1);
                    return null;
                }
            } else if(!mergeItemStack(itemStack1, 1, 37, false)) {
                //writeNBT(player, itemStack1);
                return null;
            }

            if (itemStack1.stackSize == 0)
                slot.putStack(null);
            else
                slot.onSlotChanged();

            if(itemStack1.stackSize == itemStack.stackSize) {
                //writeNBT(player, itemStack1);
                return null;
            }

            slot.onPickupFromSlot(player, itemStack1);
            //writeNBT(player, itemStack1);
        }

        return itemStack;
    }

    private void writeNBT(EntityPlayer player, ItemStack stack) {
        // Write the items.
        NBTTagList tagsItems = new NBTTagList();

        if (stack != null) {
            NBTTagCompound tagCompoundLoop = new NBTTagCompound();
            tagCompoundLoop.setByte("Slot", (byte) 0);
            stack.writeToNBT(tagCompoundLoop);
            tagsItems.appendTag(tagCompoundLoop);
        }

        device.stackTagCompound.setTag("Items", tagsItems);
        player.inventory.setInventorySlotContents(player.inventory.currentItem, device);

        System.out.println("Stacked");
    }
}
