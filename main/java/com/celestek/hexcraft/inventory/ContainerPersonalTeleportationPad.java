package com.celestek.hexcraft.inventory;

import com.celestek.hexcraft.tileentity.TileHexoriumFurnace;
import com.celestek.hexcraft.tileentity.TilePersonalTeleportationPad;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.3.0
 * @since 2015-05-06
 */
public class ContainerPersonalTeleportationPad extends Container {

    // Prepare the Tile Entity.
    private TilePersonalTeleportationPad tileEntity;

    // Prepare the variables to store GUI data.
    private int lastEnergy;
    private int lastEnergyIn;

    /**
     * Constructor
     */
    public ContainerPersonalTeleportationPad(InventoryPlayer player, TilePersonalTeleportationPad tileEntity){
        // Save the Tile Entity.
        this.tileEntity = tileEntity;

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

            if(par2 >= 0 && par2 < 27 && !mergeItemStack(itemStack1, 27, 36, false)) {
                return null;
            } else if(par2 >= 27 && par2 < 37 && !mergeItemStack(itemStack1, 0, 27, false)) {
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
