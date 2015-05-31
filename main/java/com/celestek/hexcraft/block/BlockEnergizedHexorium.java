package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexItems;
import com.celestek.hexcraft.item.ItemHexoriumManipulator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.3.0
 * @since 2015-04-14
 */

public class BlockEnergizedHexorium extends HexBlock {

    // Set default block name.
    public static String UNLOCALISEDNAME = "blockEnergizedHexorium";

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     */
    public BlockEnergizedHexorium(String blockName) {
        super(Material.glass);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.hexCraftTab);
        this.setHardness(0.3F);
        this.setStepSound(Block.soundTypeGlass);
    }

    /**
     * Sets up items to drop.
     */
    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        // Prepare a drop list.
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();

        // If the block wasn't destroyed using the Manipulator...
        if(fortune != HexCraft.hexFortune) {
            // Set the according crystal color combinations.
            if (this == HexBlocks.blockEnergizedHexoriumRed) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 8));
            } else if (this == HexBlocks.blockEnergizedHexoriumOrange) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 6));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 2));
            } else if (this == HexBlocks.blockEnergizedHexoriumYellow) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 4));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 4));
            } else if (this == HexBlocks.blockEnergizedHexoriumLime) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 2));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 6));
            } else if (this == HexBlocks.blockEnergizedHexoriumGreen) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 8));
            } else if (this == HexBlocks.blockEnergizedHexoriumTurquoise) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 6));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 2));
            } else if (this == HexBlocks.blockEnergizedHexoriumCyan) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 4));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 4));
            } else if (this == HexBlocks.blockEnergizedHexoriumSkyBlue) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 2));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 6));
            } else if (this == HexBlocks.blockEnergizedHexoriumBlue) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 8));
            } else if (this == HexBlocks.blockEnergizedHexoriumPurple) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 6));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 2));
            } else if (this == HexBlocks.blockEnergizedHexoriumMagenta) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 4));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 4));
            } else if (this == HexBlocks.blockEnergizedHexoriumPink) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 2));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 6));

            } else if (this == HexBlocks.blockEnergizedHexoriumWhite) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 8));
            } else if (this == HexBlocks.blockEnergizedHexoriumLightGray) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 6));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlack, 2));
            } else if (this == HexBlocks.blockEnergizedHexoriumGray) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 4));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlack, 4));
            } else if (this == HexBlocks.blockEnergizedHexoriumDarkGray) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 2));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlack, 6));
            } else if (this == HexBlocks.blockEnergizedHexoriumBlack) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlack, 8));

            } else if (this == HexBlocks.blockEnergizedHexoriumRainbow) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 2));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 2));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 2));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 2));
            }
        }
        else
            // Return the block (because of Manipulator).
            drops.add(new ItemStack(this, 1));

        // Return the created drop array.
        return drops;
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
        icon = new IIcon[7];
        // Load the outer textures.
        for(int i = 0; i < 6; i++)
            icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + "transparent");
        // Load the inner texture. Use special texture if it is a rainbow.
        if(this == HexBlocks.blockEnergizedHexoriumRainbow)
            icon[6] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glowRainbow");
        else
            icon[6] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glow");
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int i, int meta) {
        // Retrieve icon based on side.
        return icon[i];
    }

    /**
     * Forces the block not to accept torch placement on top.
     */
    @Override
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
        return false;
    }

    /**
     * Forces the block not to accept torch placement on sides.
     */
    @Override
    public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
        return false;
    }
}
