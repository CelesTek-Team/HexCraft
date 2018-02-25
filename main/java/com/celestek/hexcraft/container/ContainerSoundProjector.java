package com.celestek.hexcraft.container;

import com.celestek.hexcraft.tileentity.TileSoundProjector;
import com.celestek.hexcraft.tileentity.TileTankValve;
import com.celestek.hexcraft.util.HexUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;

/**
 * @author CoffeePirate     <celestek@openmailbox.org>
 */

public class ContainerSoundProjector extends Container {

    // Crafter IDs
    private static final int GUI_ID_CAPACITY_0 = 0;
    private static final int GUI_ID_CAPACITY_1 = 1;
    private static final int GUI_ID_LEVEL_0 = 2;
    private static final int GUI_ID_LEVEL_1 = 3;
    private static final int GUI_ID_FLUID_ID = 4;
    private static final int GUI_ID_FLUID_INS = 5;

    private TileSoundProjector tileSoundProjector;

    private int lastTankCap;
    private int lastTankLevel;
    private int lastFluidID;
    private int lastFluidInserted;

    public ContainerSoundProjector(TileSoundProjector tileSoundProjector) {
        this.tileSoundProjector = tileSoundProjector;
    }

    @Override public void addCraftingToCrafters(ICrafting craft) {
        super.addCraftingToCrafters(craft);
    }


    @Override public void detectAndSendChanges() {
        super.detectAndSendChanges();
    }

    @SideOnly(Side.CLIENT) @Override public void updateProgressBar(int id, int value) {
        super.updateProgressBar(id, value);
    }

    @Override public boolean canInteractWith(EntityPlayer player) {
        return tileSoundProjector.isUsableByPlayer(player);
    }
}
