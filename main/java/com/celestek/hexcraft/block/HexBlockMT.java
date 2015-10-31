package com.celestek.hexcraft.block;

import com.celestek.hexcraft.tileentity.TileTankValve;
import com.celestek.hexcraft.util.HexUtils;
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
    public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbour) {

        if (neighbour instanceof HexBlockMT || neighbour instanceof BlockTemperedHexoriumGlass) {
            //notify(world, x, y, z);
            pingChange(world, x, y, z);
        }
        super.onNeighborBlockChange(world, x, y, z, neighbour);
    }

    protected void pingChange(World world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);

        boolean hasNotified = HexUtils.getBit(meta, TileTankValve.META_HAS_NOTIFIED);
        boolean isMultiBlock = HexUtils.getBit(meta, TileTankValve.META_IS_PART);

        if (!hasNotified && isMultiBlock) {
            System.out.format("[DEBUG] Glass notification: %s\n", System.currentTimeMillis()); // TODO: Remove before final merge
            meta = HexUtils.setBit(meta, TileTankValve.META_HAS_NOTIFIED, true);
            world.setBlockMetadataWithNotify(x, y, z, meta, 1);
        }
    }
}
