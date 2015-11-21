package com.celestek.hexcraft.container;

import com.celestek.hexcraft.tileentity.TilePersonalTeleportationPad;
import com.celestek.hexcraft.util.HexUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.7.0
 */

public class ContainerPersonalTeleportationPad extends Container {

    // Crafter IDs
    private static final int GUI_ID_ENERGY_TOTAL_DONE_0 = 0;
    private static final int GUI_ID_ENERGY_TOTAL_DONE_1 = 1;
    private static final int GUI_ID_ENERGY_DRAINED = 2;

    private TilePersonalTeleportationPad tilePersonalTeleportationPad;

    private int lastEnergyTotalDone;
    private int lastEnergyDrained;

    /**
     * Constructor
     */
    public ContainerPersonalTeleportationPad(TilePersonalTeleportationPad tilePersonalTeleportationPad) {
        // Save the Tile Entity.
        this.tilePersonalTeleportationPad = tilePersonalTeleportationPad;
    }

    /**
     * Register the progress bar updates.
     */
    @Override
    public void addCraftingToCrafters(ICrafting craft) {
        super.addCraftingToCrafters(craft);

        int energyTotalDone = tilePersonalTeleportationPad.getGuiEnergyTotalDone();

        int[] mcEnergyTotalDone = HexUtils.intToMCInts(energyTotalDone);

        craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_TOTAL_DONE_0, mcEnergyTotalDone[0]);
        craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_TOTAL_DONE_1, mcEnergyTotalDone[1]);
        craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_DRAINED, tilePersonalTeleportationPad.getGuiEnergyDrained());
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < crafters.size(); i++) {
            ICrafting craft = (ICrafting) crafters.get(i);

            if (lastEnergyTotalDone != tilePersonalTeleportationPad.getGuiEnergyTotalDone()) {
                int energyTotalDone = tilePersonalTeleportationPad.getGuiEnergyTotalDone();

                int[] mcEnergyTotalDone = HexUtils.intToMCInts(energyTotalDone);

                craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_TOTAL_DONE_0, mcEnergyTotalDone[0]);
                craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_TOTAL_DONE_1, mcEnergyTotalDone[1]);
            }

            if (lastEnergyDrained != tilePersonalTeleportationPad.getGuiEnergyDrained()) {
                craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_DRAINED, tilePersonalTeleportationPad.getGuiEnergyDrained());
            }
        }

        // Save the new values as last value.
        lastEnergyTotalDone = tilePersonalTeleportationPad.getGuiEnergyTotalDone();
        lastEnergyDrained = tilePersonalTeleportationPad.getGuiEnergyDrained();
    }

    /**
     * Called by the client to update the progress bars.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int value) {
        int[] mcEnergyTotalDone = HexUtils.intToMCInts(tilePersonalTeleportationPad.getGuiEnergyTotalDone());

        switch (id) {
            case GUI_ID_ENERGY_TOTAL_DONE_0:
                mcEnergyTotalDone[0] = value;
                break;
            case GUI_ID_ENERGY_TOTAL_DONE_1:
                mcEnergyTotalDone[1] = value;
                break;
            case GUI_ID_ENERGY_DRAINED:
                tilePersonalTeleportationPad.setGuiEnergyDrained(value);
                break;
        }

        int energyTotalDone = HexUtils.joinMCIntsToInt(mcEnergyTotalDone);

        tilePersonalTeleportationPad.setGuiEnergyTotalDone(energyTotalDone);
    }

    /**
     * Check if the container can be interacted with by the player.
     */
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tilePersonalTeleportationPad.isUsableByPlayer(player);
    }
}
