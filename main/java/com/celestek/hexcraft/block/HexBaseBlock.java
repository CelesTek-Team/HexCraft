package com.celestek.hexcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

/**
 * @Author CoffeePirate     <celestek@openmailbox.org>
 * @Version 0.1.0
 */

public class HexBaseBlock extends Block {
    protected HexBaseBlock(Material p_i45394_1_) {
        super(p_i45394_1_);
    }

    /**
     * Notifies block that the multiblock structure has changed
     * @param world World
     * @param x Own X
     * @param y Own Y
     * @param z Own Z
     */
    public void notify(World world, int x, int y, int z) {

    }
}
