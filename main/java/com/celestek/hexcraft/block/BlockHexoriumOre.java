package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import java.util.Random;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-14
 */

public class BlockHexoriumOre extends HexBlock {

    /* Set default block name. */
    public static String UNLOCALISEDNAME = "blockHexoriumOre";

    /* Used later for texture identification. */
    private String blockName;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     */
    public BlockHexoriumOre(String blockName) {
        super(Material.rock);
        this.blockName = blockName;

        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.hexCraftTab);
        this.setHardness(3F);
        this.setHarvestLevel("pickaxe", 2);
        this.setStepSound(Block.soundTypeStone);
    }

    /**
     * Sets up item dropping.
     */
    @Override
    public Item getItemDropped(int metadata, Random random, int fortune) {
        if(blockName.equals(UNLOCALISEDNAME + "Red"))
            return HexItems.itemHexoriumCrystalRed;
        else if(blockName.equals(UNLOCALISEDNAME + "Green"))
            return HexItems.itemHexoriumCrystalGreen;
        else if(blockName.equals(UNLOCALISEDNAME + "Blue"))
            return HexItems.itemHexoriumCrystalBlue;
        else if(blockName.equals(UNLOCALISEDNAME + "White"))
            return HexItems.itemHexoriumCrystalWhite;
        else if(blockName.equals(UNLOCALISEDNAME + "Black"))
            return HexItems.itemHexoriumCrystalBlack;
        else
            return HexItems.itemHexoriumCrystalWhite;
    }

    /**
     * Sets quantity of items to drop.
     */
    @Override
    public int quantityDropped(Random random)
    {
        int hexoriumDropMin = 4;
        int hexoriumDropMax = 8;

        return hexoriumDropMin + random.nextInt(hexoriumDropMax - hexoriumDropMin);
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
            icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + blockName + "B");
        icon[6] = iconRegister.registerIcon(HexCraft.MODID + ":" + blockName + "A");
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
