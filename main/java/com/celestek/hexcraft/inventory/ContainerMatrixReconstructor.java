package com.celestek.hexcraft.inventory;

import com.celestek.hexcraft.init.RecipesMatrixReconstructor;
import com.celestek.hexcraft.tileentity.TileEntityMatrixReconstructor;
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

    private TileEntityMatrixReconstructor tileEntity;
    private int lastEnergy;

    public ContainerMatrixReconstructor(InventoryPlayer player, TileEntityMatrixReconstructor tileEntity){
        this.tileEntity = tileEntity;
        this.addSlotToContainer(new Slot(tileEntity, 0, 48, 35));
        this.addSlotToContainer(new SlotFurnace(player.player, tileEntity, 1, 116, 35));
        int i;

        for(i = 0; i < 3; ++i){
            for(int j = 0; j < 9; ++j){
                this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(i = 0; i < 9; ++i){
            this.addSlotToContainer(new Slot(player, i , 8 + i * 18 , 142));
        }
    }

    public void addCraftingToCrafters(ICrafting craft){
        super.addCraftingToCrafters(craft);
        craft.sendProgressBarUpdate(this, 0, tileEntity.energyGui);
    }

    public void detectAndSendChanges(){
        super.detectAndSendChanges();
        for(int i = 0; i < crafters.size(); ++i){
            ICrafting craft = (ICrafting) crafters.get(i);

            if(lastEnergy != tileEntity.energyGui){
                craft.sendProgressBarUpdate(this, 0, tileEntity.energyGui);
            }
        }

        lastEnergy = tileEntity.energyGui;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2){
        if(par1 == 0){
            tileEntity.energyGui = par2;
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tileEntity.isUseableByPlayer(player);
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int par2){
        ItemStack itemStack = null;
        Slot slot = (Slot) inventorySlots.get(par2);

        if(slot != null && slot.getHasStack()){
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();

            if (par2 == 1) {
                if (!mergeItemStack(itemStack1, 2, 38, true)) {
                    return null;
                }
                slot.onSlotChange(itemStack1, itemStack);
            } else if (par2 != 0) {
                if (RecipesMatrixReconstructor.smelting().getSmeltingResult(itemStack1) != null) {
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
