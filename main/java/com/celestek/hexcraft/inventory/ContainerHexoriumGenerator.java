package com.celestek.hexcraft.inventory;

import com.celestek.hexcraft.tileentity.TileHexoriumGenerator;
import com.celestek.hexcraft.util.HexUtils;
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
 * @version 0.7.0
 */

public class ContainerHexoriumGenerator extends Container {

    // Crafter IDs
    private static final int GUI_ID_ENERGY_TOTAL_0 = 0;
    private static final int GUI_ID_ENERGY_TOTAL_1 = 1;
    private static final int GUI_ID_ENERGY_TOTAL_LEFT_0 = 2;
    private static final int GUI_ID_ENERGY_TOTAL_LEFT_1 = 3;
    private static final int GUI_ID_ENERGY_DRAINED = 4;

    private TileHexoriumGenerator tileHexoriumGenerator;

    private int lastEnergyTotal;
    private int lastEnergyTotalLeft;
    private int lastEnergyDrained;

    /**
     * Constructor
     */
    public ContainerHexoriumGenerator(InventoryPlayer player, TileHexoriumGenerator tileHexoriumGenerator) {
        // Save the Tile Entity.
        this.tileHexoriumGenerator = tileHexoriumGenerator;

        // Add the container slots.
        this.addSlotToContainer(new Slot(tileHexoriumGenerator, 0, 80, 42));

        // Add inventory slots.
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

        int energyTotal = tileHexoriumGenerator.getGuiEnergyTotal();
        int energyTotalLeft = tileHexoriumGenerator.getGuiEnergyTotalLeft();

        int[] mcEnergyTotal = HexUtils.intToMCInts(energyTotal);
        int[] mcEnergyTotalLeft = HexUtils.intToMCInts(energyTotalLeft);

        craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_TOTAL_0, mcEnergyTotal[0]);
        craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_TOTAL_1, mcEnergyTotal[1]);
        craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_TOTAL_LEFT_0, mcEnergyTotalLeft[0]);
        craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_TOTAL_LEFT_1, mcEnergyTotalLeft[1]);
        craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_DRAINED, tileHexoriumGenerator.getGuiEnergyDrained());
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < crafters.size(); i++) {
            ICrafting craft = (ICrafting) crafters.get(i);

            if (lastEnergyTotal != tileHexoriumGenerator.getGuiEnergyTotal()) {
                int energyTotal = tileHexoriumGenerator.getGuiEnergyTotal();

                int[] mcEnergyTotal = HexUtils.intToMCInts(energyTotal);

                craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_TOTAL_0, mcEnergyTotal[0]);
                craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_TOTAL_1, mcEnergyTotal[1]);
            }

            if (lastEnergyTotalLeft != tileHexoriumGenerator.getGuiEnergyTotalLeft()) {
                int energyTotalLeft = tileHexoriumGenerator.getGuiEnergyTotalLeft();

                int[] mcEnergyTotalLeft = HexUtils.intToMCInts(energyTotalLeft);

                craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_TOTAL_LEFT_0, mcEnergyTotalLeft[0]);
                craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_TOTAL_LEFT_1, mcEnergyTotalLeft[1]);
            }

            if (lastEnergyDrained != tileHexoriumGenerator.getGuiEnergyDrained()) {
                craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_DRAINED, tileHexoriumGenerator.getGuiEnergyDrained());
            }
        }

        // Save the new values as last value.
        lastEnergyTotal = tileHexoriumGenerator.getGuiEnergyTotal();
        lastEnergyTotalLeft = tileHexoriumGenerator.getGuiEnergyTotalLeft();
        lastEnergyDrained = tileHexoriumGenerator.getGuiEnergyDrained();
    }

    /**
     * Called by the client to update the progress bars.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int value) {
        int[] mcEnergyTotal = HexUtils.intToMCInts(tileHexoriumGenerator.getGuiEnergyTotal());
        int[] mcEnergyTotalLeft = HexUtils.intToMCInts(tileHexoriumGenerator.getGuiEnergyTotalLeft());

        switch (id) {
            case GUI_ID_ENERGY_TOTAL_0:
                mcEnergyTotal[0] = value;
                break;
            case GUI_ID_ENERGY_TOTAL_1:
                mcEnergyTotal[1] = value;
                break;
            case GUI_ID_ENERGY_TOTAL_LEFT_0:
                mcEnergyTotalLeft[0] = value;
                break;
            case GUI_ID_ENERGY_TOTAL_LEFT_1:
                mcEnergyTotalLeft[1] = value;
                break;
            case GUI_ID_ENERGY_DRAINED:
                tileHexoriumGenerator.setGuiEnergyDrained(value);
                break;
        }

        int energyTotal = HexUtils.joinMCIntsToInt(mcEnergyTotal);
        int energyTotalLeft = HexUtils.joinMCIntsToInt(mcEnergyTotalLeft);

        tileHexoriumGenerator.setGuiEnergyTotal(energyTotal);
        tileHexoriumGenerator.setGuiEnergyTotalLeft(energyTotalLeft);
    }

    /**
     * Check if the container can be interacted with by the player.
     */
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tileHexoriumGenerator.isUseableByPlayer(player);
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
