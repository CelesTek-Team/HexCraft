package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.6.0
 * @since 2015-04-14
 */

public class BlockEngineeredHexoriumBlock extends HexBlock {

    // Set default block name.
    public static String UNLOCALISEDNAME = "blockEngineeredHexoriumBlock";

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     */
    public BlockEngineeredHexoriumBlock(String blockName) {
        super(Material.rock);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.tabDecorative);

        this.setHarvestLevel("pickaxe", 2, 0);
        this.setHarvestLevel("pickaxe", 3, 1);

        this.setStepSound(Block.soundTypeStone);
    }

    /**
     * Returns the block hardness at a location. Args: world, x, y, z
     */
    @Override
    public float getBlockHardness(World world, int x, int y, int z)
    {
        // If this is a normal block, return normal hardness.
        if (world.getBlockMetadata(x, y, z) == 0)
            return 1.5F;
        // If this is a reinforced block, return obsidian hardness.
        else
            return 50F;
    }

    /**
     * Location sensitive version of getExplosionRestance
     */
    @Override
    public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ) {
        // If this is a normal block, return normal resistance.
        if (world.getBlockMetadata(x, y, z) == 0)
            return 30F / 5F;
        // If this is a reinforced block, return obsidian resistance.
        else
            return 6000F / 5F;
    }

    // Prepare the icons.
    @SideOnly(Side.CLIENT)
    private IIcon icon[];

    /**
     * Registers the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        // Initialize the icons.
        icon = new IIcon[3];
        // Load the outer normal texture.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME);
        // Load the outer reinforced texture.
        icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME + "Reinforced");
        // Load the inner texture. Use special texture if it is a rainbow.
        if(this == HexBlocks.blockEngineeredHexoriumBlockRainbow)
            icon[2] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glowRainbow");
        else
            icon[2] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glow");
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        // Retrieve icon based on side and meta.
        if (side < 6 && meta == 0)
            return icon[0];
        else if (side < 6 && meta == 1)
            return icon[1];
        else if (side == 6)
            return icon[2];
        else
            return icon[0];
    }
}
