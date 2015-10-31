package com.celestek.hexcraft.block;

import com.celestek.hexcraft.tileentity.TileTankRender;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;


public class BlockTankRender extends HexBlockContainer {
    public static String UNLOCALISEDNAME = "blockTankRender";

    /**
     * Constructor for the block.
     *
     * @param blockName Un
     */
    public BlockTankRender(String blockName) {
        super(Material.air);

        // Set all block parameters.
        this.setBlockName(blockName);

        this.setBlockUnbreakable();
        this.setResistance(6000000.0F);

        this.setStepSound(Block.soundTypeMetal);
        this.setLightOpacity(0);
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TileTankRender();
    }
}
