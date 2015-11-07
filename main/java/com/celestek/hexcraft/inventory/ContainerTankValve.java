package com.celestek.hexcraft.inventory;

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

    private TileTankValve tileTankValve;

    private static final int TANK_CAP_MC_INT_0 = 0;
    private static final int TANK_CAP_MC_INT_1 = 1;
    private static final int TANK_LVL_MC_INT_0 = 2;
    private static final int TANK_LVL_MC_INT_1 = 3;

    private int lastTankCap;
    private int lastTankLevel;
    private int lastFluidID;
    private int lastFluidInserted;

    public ContainerTankValve(TileTankValve tileHexoriumValve) {
        this.tileTankValve = tileHexoriumValve;
    }

    @Override public void addCraftingToCrafters(ICrafting crafting) {
        super.addCraftingToCrafters(crafting);

        int tankCap = tileTankValve.getTankCapacity();
        int tankLevel = tileTankValve.getFluidLevel();

        int[] mcTankCap = HexUtils.intToMCInts(tankCap);
        int[] mcTankLevel = HexUtils.intToMCInts(tankLevel);

        crafting.sendProgressBarUpdate(this, TANK_CAP_MC_INT_0, mcTankCap[0]);
        crafting.sendProgressBarUpdate(this, TANK_CAP_MC_INT_1, mcTankCap[1]);

        crafting.sendProgressBarUpdate(this, TANK_LVL_MC_INT_0, mcTankLevel[0]);
        crafting.sendProgressBarUpdate(this, TANK_LVL_MC_INT_1, mcTankLevel[1]);

        crafting.sendProgressBarUpdate(this, 4, tileTankValve.getFluidID());
        crafting.sendProgressBarUpdate(this, 5, tileTankValve.getFluidIns());
    }


    @Override public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < crafters.size(); i++) {
            ICrafting craft = (ICrafting) crafters.get(i);

            if (lastTankCap != tileTankValve.getTankCapacity()) {
                int tankCap = tileTankValve.getTankCapacity();

                int[] mcTankCap = HexUtils.intToMCInts(tankCap);

                craft.sendProgressBarUpdate(this, TANK_CAP_MC_INT_0, mcTankCap[0]);
                craft.sendProgressBarUpdate(this, TANK_CAP_MC_INT_1, mcTankCap[1]);
            }

            if (lastTankLevel != tileTankValve.getFluidLevel()) {
                int tankLevel = tileTankValve.getFluidLevel();

                int[] mcTankLevel = HexUtils.intToMCInts(tankLevel);

                craft.sendProgressBarUpdate(this, TANK_LVL_MC_INT_0, mcTankLevel[0]);
                craft.sendProgressBarUpdate(this, TANK_LVL_MC_INT_1, mcTankLevel[1]);
            }

            if (lastFluidID != tileTankValve.getFluidID()) {
                craft.sendProgressBarUpdate(this, 4, tileTankValve.getFluidID());
            }

            if (lastFluidInserted != tileTankValve.getFluidIns()) {
                craft.sendProgressBarUpdate(this, 5, tileTankValve.getFluidIns());
            }
        }

        lastTankCap = tileTankValve.getTankCapacity();
        lastTankLevel = tileTankValve.getFluidLevel();

        lastFluidID = tileTankValve.getFluidID();
        lastFluidInserted = tileTankValve.getFluidIns();
    }

    @SideOnly(Side.CLIENT) @Override public void updateProgressBar(int varID, int value) {
        super.updateProgressBar(varID, value);
        int[] mcTankCap = HexUtils.intToMCInts(tileTankValve.getGuiTankCapacity());
        int[] mcTankLevel = HexUtils.intToMCInts(tileTankValve.getGuiFluidLevel());

        switch (varID) {
            case TANK_CAP_MC_INT_0:
                mcTankCap[0] = value;
                break;
            case TANK_CAP_MC_INT_1:
                mcTankCap[1] = value;
                break;
            case TANK_LVL_MC_INT_0:
                mcTankLevel[0] = value;
                break;
            case TANK_LVL_MC_INT_1:
                mcTankLevel[1] = value;
                break;
            case 4:
                tileTankValve.setGuiFluidID(value);
                break;
            case 5:
                tileTankValve.setGuiFluidIns(value);
                break;
        }

        int tankCap = HexUtils.joinMCIntsToInt(mcTankCap);
        int tankLevel = HexUtils.joinMCIntsToInt(mcTankLevel);

        tileTankValve.setGuiTankCapacity(tankCap);
        tileTankValve.setGuiFluidLevel(tankLevel);
    }

    @Override public boolean canInteractWith(EntityPlayer player) {
        return tileTankValve.isUseableByPlayer(player);
    }


}
