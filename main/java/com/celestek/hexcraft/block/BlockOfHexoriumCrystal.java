package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.Random;

import static net.minecraftforge.common.util.ForgeDirection.*;
import static net.minecraftforge.common.util.ForgeDirection.DOWN;
import static net.minecraftforge.common.util.ForgeDirection.WEST;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-14
 */

public class BlockOfHexoriumCrystal extends HexBlock {

    // Set default block name.
    public static String UNLOCALISEDNAME = "blockOfHexoriumCrystal";

    // Used later for texture identification.
    private String blockName;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     */
    public BlockOfHexoriumCrystal(String blockName) {
        super(Material.glass);

        // Load the constructor parameters.
        this.blockName = blockName;

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.hexCraftTab);
        this.setHardness(5.0F);
        this.setStepSound(Block.soundTypeGlass);
        this.setHarvestLevel("pickaxe", 2);
    }

    /**
     * Called when a block is placed using its ItemBlock.
     */
    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta)
    {
        return side;
    }

    /**
     * Sets up items to drop. Fired the number of times dictated by quantityDropped.
     */
    @Override
    public Item getItemDropped(int metadata, Random random, int fortune) {
        // Return the block (because of Silk Touch).
        if (blockName.equals(UNLOCALISEDNAME + "Red"))
            return Item.getItemFromBlock(HexBlocks.blockOfHexoriumCrystalRed);
        else if (blockName.equals(UNLOCALISEDNAME + "Green"))
            return Item.getItemFromBlock(HexBlocks.blockOfHexoriumCrystalGreen);
        else if (blockName.equals(UNLOCALISEDNAME + "Blue"))
            return Item.getItemFromBlock(HexBlocks.blockOfHexoriumCrystalBlue);
        else if (blockName.equals(UNLOCALISEDNAME + "White"))
            return Item.getItemFromBlock(HexBlocks.blockOfHexoriumCrystalWhite);
        else if (blockName.equals(UNLOCALISEDNAME + "Black"))
            return Item.getItemFromBlock(HexBlocks.blockOfHexoriumCrystalBlack);
        else
            return null;
    }

    /// Prepare the icons.
    @SideOnly(Side.CLIENT)
    private IIcon icon[];

    /**
     * Registers the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        // Initialize the icons.
        icon = new IIcon[18];
        // Load the outer textures.
        for(int i = 0; i < 6; i++)
            icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + "transparent");
        // Load the inner textures.
        for(int i = 0; i < 12; i++)
            if(i < 9)
                icon[i + 6] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME + "/" + blockName + "0" + (i + 1));
            else
                icon[i + 6] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME + "/" + blockName + (i + 1));
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int i, int meta) {

        // If the requested icons are for the extra sides...
        if (i > 5) {
            // Return the icons based on meta (rotation) and side.
            if (meta == 0) {
                switch (i) {
                    case 6: return icon[6];
                    case 7: return icon[16];
                    case 8: return icon[10];
                    case 9: return icon[10];
                    case 10: return icon[14];
                    case 11: return icon[14];
                }
            } else if (meta == 1) {
                switch (i) {
                    case 6: return icon[16];
                    case 7: return icon[6];
                    case 8: return icon[8];
                    case 9: return icon[8];
                    case 10: return icon[12];
                    case 11: return icon[12];
                }
            } else if (meta == 2) {
                switch (i) {
                    case 6: return icon[12];
                    case 7: return icon[12];
                    case 8: return icon[7];
                    case 9: return icon[17];
                    case 10: return icon[11];
                    case 11: return icon[9];
                }
            } else if (meta == 3) {
                switch (i) {
                    case 6: return icon[14];
                    case 7: return icon[14];
                    case 8: return icon[17];
                    case 9: return icon[7];
                    case 10: return icon[9];
                    case 11: return icon[11];
                }
            } else if (meta == 4) {
                switch (i) {
                    case 6: return icon[15];
                    case 7: return icon[15];
                    case 8: return icon[9];
                    case 9: return icon[11];
                    case 10: return icon[7];
                    case 11: return icon[17];
                }
            } else if (meta == 5) {
                switch (i) {
                    case 6: return icon[13];
                    case 7: return icon[13];
                    case 8: return icon[11];
                    case 9: return icon[9];
                    case 10: return icon[17];
                    case 11: return icon[7];
                }
            }
            return icon[i];
        }
        else
            // Otherwise, just return first icons.
            return icon[i];
    }
}
