package com.celestek.hexcraft.container;

import com.celestek.hexcraft.tileentity.TileTankValve;
import com.celestek.hexcraft.util.HexUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;

/**
 * @author CoffeePirate     <celestek@openmailbox.org>
 * @version 0.7.0
 */

public class ContainerTankValve extends Container {

    // Crafter IDs
    private static final int GUI_ID_CAPACITY_0 = 0;
    private static final int GUI_ID_CAPACITY_1 = 1;
    private static final int GUI_ID_LEVEL_0 = 2;
    private static final int GUI_ID_LEVEL_1 = 3;
    private static final int GUI_ID_FLUID_ID = 4;
    private static final int GUI_ID_FLUID_INS = 5;

    private TileTankValve tileTankValve;

    private int lastTankCap;
    private int lastTankLevel;
    private int lastFluidID;
    private int lastFluidInserted;

    public ContainerTankValve(TileTankValve tileHexoriumValve) {
        this.tileTankValve = tileHexoriumValve;
    }

    @Override public void addCraftingToCrafters(ICrafting craft) {
        super.addCraftingToCrafters(craft);

        int tankCap = tileTankValve.getTankCapacity();
        int tankLevel = tileTankValve.getFluidLevel();

        int[] mcTankCap = HexUtils.intToMCInts(tankCap);
        int[] mcTankLevel = HexUtils.intToMCInts(tankLevel);

        craft.sendProgressBarUpdate(this, GUI_ID_CAPACITY_0, mcTankCap[0]);
        craft.sendProgressBarUpdate(this, GUI_ID_CAPACITY_1, mcTankCap[1]);
        craft.sendProgressBarUpdate(this, GUI_ID_LEVEL_0, mcTankLevel[0]);
        craft.sendProgressBarUpdate(this, GUI_ID_LEVEL_1, mcTankLevel[1]);
        craft.sendProgressBarUpdate(this, GUI_ID_FLUID_ID, tileTankValve.getFluidID());
        craft.sendProgressBarUpdate(this, GUI_ID_FLUID_INS, tileTankValve.getFluidIns());
    }


    @Override public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < crafters.size(); i++) {
            ICrafting craft = (ICrafting) crafters.get(i);

            if (lastTankCap != tileTankValve.getTankCapacity()) {
                int tankCap = tileTankValve.getTankCapacity();

                int[] mcTankCap = HexUtils.intToMCInts(tankCap);

                craft.sendProgressBarUpdate(this, GUI_ID_CAPACITY_0, mcTankCap[0]);
                craft.sendProgressBarUpdate(this, GUI_ID_CAPACITY_1, mcTankCap[1]);
            }

            if (lastTankLevel != tileTankValve.getFluidLevel()) {
                int tankLevel = tileTankValve.getFluidLevel();

                int[] mcTankLevel = HexUtils.intToMCInts(tankLevel);

                craft.sendProgressBarUpdate(this, GUI_ID_LEVEL_0, mcTankLevel[0]);
                craft.sendProgressBarUpdate(this, GUI_ID_LEVEL_1, mcTankLevel[1]);
            }

            if (lastFluidID != tileTankValve.getFluidID()) {
                craft.sendProgressBarUpdate(this, GUI_ID_FLUID_ID, tileTankValve.getFluidID());
            }

            if (lastFluidInserted != tileTankValve.getFluidIns()) {
                craft.sendProgressBarUpdate(this, GUI_ID_FLUID_INS, tileTankValve.getFluidIns());
            }
        }

        lastTankCap = tileTankValve.getTankCapacity();
        lastTankLevel = tileTankValve.getFluidLevel();

        lastFluidID = tileTankValve.getFluidID();
        lastFluidInserted = tileTankValve.getFluidIns();
    }

    @SideOnly(Side.CLIENT) @Override public void updateProgressBar(int id, int value) {
        super.updateProgressBar(id, value);
        int[] mcTankCap = HexUtils.intToMCInts(tileTankValve.getGuiTankCapacity());
        int[] mcTankLevel = HexUtils.intToMCInts(tileTankValve.getGuiFluidLevel());

        switch (id) {
            case GUI_ID_CAPACITY_0:
                mcTankCap[0] = value;
                break;
            case GUI_ID_CAPACITY_1:
                mcTankCap[1] = value;
                break;
            case GUI_ID_LEVEL_0:
                mcTankLevel[0] = value;
                break;
            case GUI_ID_LEVEL_1:
                mcTankLevel[1] = value;
                break;
            case GUI_ID_FLUID_ID:
                tileTankValve.setGuiFluidID(value);
                break;
            case GUI_ID_FLUID_INS:
                tileTankValve.setGuiFluidIns(value);
                break;
        }

        int tankCap = HexUtils.joinMCIntsToInt(mcTankCap);
        int tankLevel = HexUtils.joinMCIntsToInt(mcTankLevel);

        tileTankValve.setGuiTankCapacity(tankCap);
        tileTankValve.setGuiFluidLevel(tankLevel);
    }

    @Override public boolean canInteractWith(EntityPlayer player) {
        return tileTankValve.isUsableByPlayer(player);
    }


}
