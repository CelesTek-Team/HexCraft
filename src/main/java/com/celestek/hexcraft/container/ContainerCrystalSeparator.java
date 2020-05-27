package com.celestek.hexcraft.container;

import com.celestek.hexcraft.init.HexProcessingCrystalSeparator;
import com.celestek.hexcraft.tileentity.TileCrystalSeparator;
import com.celestek.hexcraft.util.HexUtils;
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
 */

public class ContainerCrystalSeparator extends Container {

    // Crafter IDs
    private static final int GUI_ID_ENERGY_TOTAL_DONE_0 = 0;
    private static final int GUI_ID_ENERGY_TOTAL_DONE_1 = 1;
    private static final int GUI_ID_ENERGY_DRAINED = 2;

    private TileCrystalSeparator tileCrystalSeparator;

    private int lastEnergyTotalDone;
    private int lastEnergyDrained;

    /**
     * Constructor
     */
    public ContainerCrystalSeparator(InventoryPlayer player, TileCrystalSeparator tileCrystalSeparator) {
        // Save the Tile Entity.
        this.tileCrystalSeparator = tileCrystalSeparator;

        // Add the container slots.
        this.addSlotToContainer(new Slot(tileCrystalSeparator, 0, 48, 35));
        addSlotToContainer(new SlotFurnace(player.player, tileCrystalSeparator, 1, 116, 35));

        // Add container slots.
        int i;
        for(i = 0; i < 3; ++i){
            for(int j = 0; j < 9; ++j){
                this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        // Add action bar slots.
        for(i = 0; i < 9; ++i){
            this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
        }
    }

    /**
     * Register the progress bar updates.
     */
    @Override
    public void addCraftingToCrafters(ICrafting craft) {
        super.addCraftingToCrafters(craft);

        int energyTotalDone = tileCrystalSeparator.getGuiEnergyTotalDone();

        int[] mcEnergyTotalDone = HexUtils.intToMCInts(energyTotalDone);

        craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_TOTAL_DONE_0, mcEnergyTotalDone[0]);
        craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_TOTAL_DONE_1, mcEnergyTotalDone[1]);
        craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_DRAINED, tileCrystalSeparator.getGuiEnergyDrained());
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < crafters.size(); i++) {
            ICrafting craft = (ICrafting) crafters.get(i);

            if (lastEnergyTotalDone != tileCrystalSeparator.getGuiEnergyTotalDone()) {
                int energyTotalDone = tileCrystalSeparator.getGuiEnergyTotalDone();

                int[] mcEnergyTotalDone = HexUtils.intToMCInts(energyTotalDone);

                craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_TOTAL_DONE_0, mcEnergyTotalDone[0]);
                craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_TOTAL_DONE_1, mcEnergyTotalDone[1]);
            }

            if (lastEnergyDrained != tileCrystalSeparator.getGuiEnergyDrained()) {
                craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_DRAINED, tileCrystalSeparator.getGuiEnergyDrained());
            }
        }

        // Save the new values as last value.
        lastEnergyTotalDone = tileCrystalSeparator.getGuiEnergyTotalDone();
        lastEnergyDrained = tileCrystalSeparator.getGuiEnergyDrained();
    }

    /**
     * Called by the client to update the progress bars.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int value) {
        int[] mcEnergyTotalDone = HexUtils.intToMCInts(tileCrystalSeparator.getGuiEnergyTotalDone());

        switch (id) {
            case GUI_ID_ENERGY_TOTAL_DONE_0:
                mcEnergyTotalDone[0] = value;
                break;
            case GUI_ID_ENERGY_TOTAL_DONE_1:
                mcEnergyTotalDone[1] = value;
                break;
            case GUI_ID_ENERGY_DRAINED:
                tileCrystalSeparator.setGuiEnergyDrained(value);
                break;
        }

        int energyTotalDone = HexUtils.joinMCIntsToInt(mcEnergyTotalDone);

        tileCrystalSeparator.setGuiEnergyTotalDone(energyTotalDone);
    }

    /**
     * Check if the container can be interacted with by the player.
     */
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tileCrystalSeparator.isUseableByPlayer(player);
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
                if (HexProcessingCrystalSeparator.processing().getProcessingResult(itemStack1) != null) {
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
