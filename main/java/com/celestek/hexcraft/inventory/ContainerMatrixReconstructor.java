package com.celestek.hexcraft.inventory;

import com.celestek.hexcraft.init.HexProcessingMatrixReconstructor;
import com.celestek.hexcraft.tileentity.TileMatrixReconstructor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-25
 */
public class ContainerMatrixReconstructor extends Container {

    // Prepare the Tile Entity.
    private TileMatrixReconstructor tileEntity;

    // Prepare the variables to store GUI data.
    private int lastEnergy;
    private int lastEnergyIn;

    /**
     * Constructor
     */
    public ContainerMatrixReconstructor(InventoryPlayer player, TileMatrixReconstructor tileEntity){
        // Save the Tile Entity.
        this.tileEntity = tileEntity;

        // Add the container slots.
        addSlotToContainer(new Slot(tileEntity, 0, 48, 35));
        addSlotToContainer(new SlotFurnace(player.player, tileEntity, 1, 116, 35));

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
    public void addCraftingToCrafters(ICrafting craft){
        super.addCraftingToCrafters(craft);
        craft.sendProgressBarUpdate(this, 0, tileEntity.energyGui);
        craft.sendProgressBarUpdate(this, 1, tileEntity.energyInGui);
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
            if (lastEnergy != tileEntity.energyGui)
                craft.sendProgressBarUpdate(this, 0, tileEntity.energyGui);
            if (lastEnergyIn != tileEntity.energyInGui)
                craft.sendProgressBarUpdate(this, 1, tileEntity.energyInGui);
        }

        // Save the new values as last value.
        lastEnergy = tileEntity.energyGui;
        lastEnergyIn = tileEntity.energyInGui;
    }

    /**
     * Called by the client to update the progress bars.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2) {
        // Save the client-side value depending on ID.
        if(par1 == 0)
            tileEntity.energyGui = par2;
        if(par1 == 1)
            tileEntity.energyInGui = par2;
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
    public ItemStack transferStackInSlot(EntityPlayer player, int par2) {
        ItemStack itemStack = null;
        Slot slot = (Slot) inventorySlots.get(par2);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();

            if (par2 == 1) {
                if (!mergeItemStack(itemStack1, 2, 38, true)) {
                    return null;
                }
                slot.onSlotChange(itemStack1, itemStack);
            } else if (par2 != 0) {
                if (HexProcessingMatrixReconstructor.processing().getProcessingResult(itemStack1) != null) {
                    if (!mergeItemStack(itemStack1, 0, 1, false)) {
                        return null;
                    }
                } else if(par2 >= 2 && par2 < 29) {
                    if (!mergeItemStack(itemStack1, 29, 38, false)) {
                        return null;
                    }
                } else if( par2 >= 29 && par2 < 39 && !mergeItemStack(itemStack1, 2, 29, false)) {
                    return null;
                }
            } else if(!mergeItemStack(itemStack1, 2, 38, false)) {
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
