package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-14
 */

public class BlockEngineeringBlock extends HexBlock {

    /* Set default block name. */
    public static String UNLOCALISEDNAME = "blockEngineeringBlock";

    /* Used later for texture identification. */
    private String blockName;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     */
    public BlockEngineeringBlock(String blockName) {
        super(Material.rock);

        this.blockName = blockName;
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.hexCraftTab);
        this.setHardness(1.5F);
        this.setHarvestLevel("pickaxe", 0);
        this.setStepSound(Block.soundTypeStone);
    }

    /* Prepare the icons. */
    @SideOnly(Side.CLIENT)
    private IIcon icon[] = new IIcon[7];

    /**
     * Registers the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        for(int i = 0; i < 6; i++)
            icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME);
        if(blockName.equals(UNLOCALISEDNAME + "Rainbow"))
            icon[6] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glowRainbow");
        else
            icon[6] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glow");
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2) {
        return icon[par1];
    }
}
