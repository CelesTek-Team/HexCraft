package com.celestek.hexcraft.block;

import com.celestek.hexcraft.tileentity.TileTankInfo;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;


public class BlockTankInfo extends HexBlockContainer {
    public static String UNLOCALISEDNAME = "blockTankInfo";

    /**
     * Constructor for the block.
     *
     * @param blockName Un
     */
    public BlockTankInfo(String blockName) {
        super(Material.air);
        // TODO: Fill this out

    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TileTankInfo();
    }
}
