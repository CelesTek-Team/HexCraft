package com.celestek.hexcraft.inventory;

import com.celestek.hexcraft.tileentity.TileHexoriumGenerator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.6.0
 * @since 2015-04-25
 */
public class ContainerHexoriumGenerator extends Container {

    // Prepare the Tile Entity.
    private TileHexoriumGenerator tileEntity;

    // Prepare the variables to store GUI data.
    private int lastEnergy;
    private int lastEnergyTotal;
    private int lastEnergyOut;

    /**
     * Constructor
     */
    public ContainerHexoriumGenerator(InventoryPlayer player, TileHexoriumGenerator tileEntity){
        // Save the Tile Entity.
        this.tileEntity = tileEntity;

        // Add the container slots.
        addSlotToContainer(new Slot(tileEntity, 0, 80, 42));

        // Add inventory slots.
        int i;
        for(i = 0; i < 3; ++i){
            for(int j = 0; j < 9; ++j){
                addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        // Add action bar slots.
        for(i = 0; i < 9; ++i){
            addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
        }
    }

    /**
     * Register the progress bar updates.
     */
    @Override
    public void addCraftingToCrafters(ICrafting craft) {
        super.addCraftingToCrafters(craft);
        craft.sendProgressBarUpdate(this, 0, tileEntity.energyGui);
        craft.sendProgressBarUpdate(this, 1, tileEntity.energyTotalGui);
        craft.sendProgressBarUpdate(this, 2, tileEntity.energyOutGui);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        // Loop through all crafters.
        for (int i = 0; i < crafters.size(); ++i) {
            ICrafting craft = (ICrafting) crafters.get(i);

            // Compare if the value has changed, if it has, send the change.
            if( lastEnergy != tileEntity.energyGui)
                craft.sendProgressBarUpdate(this, 0, tileEntity.energyGui);
            if (lastEnergyTotal != tileEntity.energyTotalGui)
                craft.sendProgressBarUpdate(this, 1, tileEntity.energyTotalGui);
            if (lastEnergyOut != tileEntity.energyOutGui)
                craft.sendProgressBarUpdate(this, 2, tileEntity.energyOutGui);
        }

        // Save the new values as last value.
        lastEnergy = tileEntity.energyGui;
        lastEnergyTotal = tileEntity.energyTotalGui;
        lastEnergyOut = tileEntity.energyOutGui;
    }

    /**
     * Called by the client to update the progress bars.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int value) {
        // Save the client-side value depending on ID.
        if (id == 0)
            tileEntity.energyGui = value;
        if (id == 1)
            tileEntity.energyTotalGui = value;
        if (id == 2)
            tileEntity.energyOutGui = value;
    }

    /**
     * Check if the container can be interacted with by the player.
     */
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tileEntity.isUseableByPlayer(player);
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
                if (TileHexoriumGenerator.canBurn(itemStack1)) {
                    if (!mergeItemStack(itemStack1, 0, 1, false)) {
                        return null;
                    }
                } else if(par2 >= 1 && par2 < 28) {
                    if (!mergeItemStack(itemStack1, 28, 37, false)) {
                        return null;
                    }
                } else if( par2 >= 28 && par2 < 38 && !mergeItemStack(itemStack1, 1, 28, false)) {
                    return null;
                }
            } else if(!mergeItemStack(itemStack1, 1, 37, false)) {
                return null;
            }

            if (itemStack1.stackSize == 0)
                slot.putStack(null);
            else
                slot.onSlotChanged();

            if(itemStack1.stackSize == itemStack.stackSize)
                return null;

            slot.onPickupFromSlot(player, itemStack1);
        }
        return itemStack;
    }
}
