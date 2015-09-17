package com.celestek.hexcraft.inventory;

import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.tileentity.TileHexoriumValve;
import com.celestek.hexcraft.util.HexUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;

/**
 * @Author CoffeePirate    <celestek@openmailbox.org>
 * @Version 0.1.0
 */
public class ContainerHexoriumValve extends Container {

    private TileHexoriumValve tileHexoriumValve;

    private static final int TANK_CAP_MC_INT_0 = 0;
    private static final int TANK_CAP_MC_INT_1 = 1;
    private static final int TANK_LVL_MC_INT_0 = 2;
    private static final int TANK_LVL_MC_INT_1 = 3;

    private int lastTankCap;
    private int lastTankLevel;

    public ContainerHexoriumValve(TileHexoriumValve tileHexoriumValve) {
        this.tileHexoriumValve = tileHexoriumValve;
    }

    @Override public void addCraftingToCrafters(ICrafting crafting) {
        super.addCraftingToCrafters(crafting);

        int tankCap = tileHexoriumValve.getTankCapacity();
        int tankLevel = tileHexoriumValve.getTankFluidLevel();

        int[] mcTankCap = HexUtils.intToMCInts(tankCap);
        int[] mcTankLevel = HexUtils.intToMCInts(tankLevel);

        crafting.sendProgressBarUpdate(this, TANK_CAP_MC_INT_0, mcTankCap[0]);
        crafting.sendProgressBarUpdate(this, TANK_CAP_MC_INT_1, mcTankCap[1]);

        crafting.sendProgressBarUpdate(this, TANK_LVL_MC_INT_0, mcTankLevel[0]);
        crafting.sendProgressBarUpdate(this, TANK_LVL_MC_INT_1, mcTankLevel[1]);
    }


    @Override public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < crafters.size(); i++) {
            ICrafting craft = (ICrafting) crafters.get(i);

            if (lastTankCap != tileHexoriumValve.getTankCapacity()) {
                int tankCap = tileHexoriumValve.getTankCapacity();

                int[] mcTankCap = HexUtils.intToMCInts(tankCap);

                craft.sendProgressBarUpdate(this, TANK_CAP_MC_INT_0, mcTankCap[0]);
                craft.sendProgressBarUpdate(this, TANK_CAP_MC_INT_1, mcTankCap[1]);
            }

            if (lastTankLevel != tileHexoriumValve.getTankFluidLevel()) {
                int tankLevel = tileHexoriumValve.getTankFluidLevel();

                int[] mcTankLevel = HexUtils.intToMCInts(tankLevel);

                craft.sendProgressBarUpdate(this, TANK_LVL_MC_INT_0, mcTankLevel[0]);
                craft.sendProgressBarUpdate(this, TANK_LVL_MC_INT_1, mcTankLevel[1]);
            }
        }

        lastTankCap = tileHexoriumValve.getTankCapacity();
        lastTankLevel = tileHexoriumValve.getTankFluidLevel();
    }

    @SideOnly(Side.CLIENT) @Override public void updateProgressBar(int varID, int value) {
        super.updateProgressBar(varID, value);
        int[] mcTankCap = HexUtils.intToMCInts(tileHexoriumValve.getTankCapacity());
        int[] mcTankLevel = HexUtils.intToMCInts(tileHexoriumValve.getTankFluidLevel());

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
                mcTankLevel[0] = value;
                break;
        }

        int tankCap = HexUtils.joinMCIntsToInt(mcTankCap);
        int tankLevel = HexUtils.joinMCIntsToInt(mcTankLevel);

        tileHexoriumValve.setTankCapacity(tankCap);
        tileHexoriumValve.setTankFluidLevel(tankLevel);
    }

    @Override public boolean canInteractWith(EntityPlayer player) {
        return tileHexoriumValve.isUseableByPlayer(player);
    }


}
