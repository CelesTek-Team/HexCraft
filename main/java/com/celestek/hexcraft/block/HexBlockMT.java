package com.celestek.hexcraft.block;

import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.tileentity.TileTankValve;
import com.celestek.hexcraft.util.HexUtils;
import com.celestek.hexcraft.util.TankAnalyzer;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

/**
 * @Author CoffeePirate     <celestek@openmailbox.org>
 * @Version 0.1.0
 */

public class HexBlockMT extends HexBlock {

    /**
     * Constructor for the block.
     *
     * @param material Default material to use.
     */
    public HexBlockMT(Material material) {
        super(material);
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if (block instanceof HexBlockMT || block == HexBlocks.blockTemperedHexoriumGlass || block == HexBlocks.blockTankValve) {
            TankAnalyzer analyzer = new TankAnalyzer();
            analyzer.analyzeCable(world, x, y, z, block);
        }
    }
}
