package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;

import static net.minecraftforge.common.util.ForgeDirection.*;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-14
 */

public class BlockEnergizedHexoriumMonolith extends HexBlockModel {

    // Set default block name.
    public static String UNLOCALISEDNAME = "blockEnergizedHexoriumMonolith";

    // Used later for texture identification.
    private String blockName;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     */
    public BlockEnergizedHexoriumMonolith(String blockName) {
        super(Material.glass);

        // Load the constructor parameters.
        this.blockName = blockName;

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

        // Set the according crystal color combinations.
        if(blockName.equals(UNLOCALISEDNAME + "Red")) {
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 8));
        }
        else if(blockName.equals(UNLOCALISEDNAME + "Orange")) {
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 6));
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 2));
        }
        else if(blockName.equals(UNLOCALISEDNAME + "Yellow")) {
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 4));
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 4));
        }
        else if(blockName.equals(UNLOCALISEDNAME + "Lime")) {
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 2));
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 6));
        }
        else if(blockName.equals(UNLOCALISEDNAME + "Green")) {
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 8));
        }
        else if(blockName.equals(UNLOCALISEDNAME + "Turquoise")) {
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 6));
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 2));
        }
        else if(blockName.equals(UNLOCALISEDNAME + "Cyan")) {
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 4));
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 4));
        }
        else if(blockName.equals(UNLOCALISEDNAME + "SkyBlue")) {
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 2));
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 6));
        }
        else if(blockName.equals(UNLOCALISEDNAME + "Blue")) {
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 8));
        }
        else if(blockName.equals(UNLOCALISEDNAME + "Purple")) {
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 6));
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 2));
        }
        else if(blockName.equals(UNLOCALISEDNAME + "Magenta")) {
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 4));
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 4));
        }
        else if(blockName.equals(UNLOCALISEDNAME + "Pink")) {
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 2));
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 6));
        }

        else if(blockName.equals(UNLOCALISEDNAME + "White")) {
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 8));
        }
        else if(blockName.equals(UNLOCALISEDNAME + "LightGray")) {
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 6));
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlack, 2));
        }
        else if(blockName.equals(UNLOCALISEDNAME + "Gray")) {
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 4));
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlack, 4));
        }
        else if(blockName.equals(UNLOCALISEDNAME + "DarkGray")) {
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 2));
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlack, 6));
        }
        else if(blockName.equals(UNLOCALISEDNAME + "Black")) {
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlack, 8));
        }

        else if(blockName.equals(UNLOCALISEDNAME + "Rainbow")) {
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 2));
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 2));
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 2));
            drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 2));
        }

        // Return the created drop array.
        return drops;
    }

    /**
     * Called when a block is placed using its ItemBlock.
     */
    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta)
    {
        // Prepare the orientation.
        int orientation = -1;

        // First check if the side it was placed on can accept it. If it can, place it there.
        if (side == 0 && world.isSideSolid(x, y + 1, z, DOWN))
            orientation = side;
        else if (side == 1 && world.isSideSolid(x, y - 1, z, UP))
            orientation = side;
        else if (side == 2 && world.isSideSolid(x, y, z + 1, NORTH))
            orientation = side;
        else if (side == 3 && world.isSideSolid(x, y, z - 1, SOUTH))
            orientation = side;
        else if (side == 4 && world.isSideSolid(x + 1, y, z, WEST))
            orientation = side;
        else if (side == 5 && world.isSideSolid(x - 1, y, z, EAST))
            orientation = side;
            // If the side it was placed on cannot accept it, place it on closest possible other side.
        else {
            if (world.isSideSolid(x, y - 1, z, UP))
                orientation = 1;
            else if (world.isSideSolid(x, y, z + 1, NORTH))
                orientation = 2;
            else if (world.isSideSolid(x - 1, y, z, EAST))
                orientation = 5;
            else if (world.isSideSolid(x, y, z - 1, SOUTH))
                orientation = 3;
            else if (world.isSideSolid(x + 1, y, z, WEST))
                orientation = 4;
            else if (world.isSideSolid(x, y + 1, z, DOWN))
                orientation = 0;
        }

        // Return the new orientation as meta.
        return orientation;
    }

    /**
     * Called when a player tries to place the monolith.
     */
    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        // Check if any of the sides around the block are solid, if yes, it means it can be placed.
        return (world.isSideSolid(x, y - 1, z, UP)) ||
                (world.isSideSolid(x, y + 1, z, DOWN)) ||
                (world.isSideSolid(x, y, z + 1, NORTH)) ||
                (world.isSideSolid(x, y, z - 1, SOUTH)) ||
                (world.isSideSolid(x + 1, y, z, WEST)) ||
                (world.isSideSolid(x - 1, y, z, EAST));
    }

    /**
     * Called when a block near is changed.
     */
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        // Compare all neighbouring blocks, and if one of them correspond to the rotation, remove the monolith and drop the crystals.
        if(world.getBlockMetadata(x, y, z) == 0) {
            if (!world.getBlock(x, y + 1, z).isSideSolid(world, x, y, z, DOWN)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(world.getBlockMetadata(x, y, z) == 1) {
            if (!world.getBlock(x, y - 1, z).isSideSolid(world, x, y, z, UP)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(world.getBlockMetadata(x, y, z) == 2) {
            if (!world.getBlock(x, y, z + 1).isSideSolid(world, x, y, z, NORTH)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(world.getBlockMetadata(x, y, z) == 3) {
            if (!world.getBlock(x, y, z - 1).isSideSolid(world, x, y, z, SOUTH)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(world.getBlockMetadata(x, y, z) == 4) {
            if (!world.getBlock(x + 1, y, z).isSideSolid(world, x, y, z, WEST)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(world.getBlockMetadata(x, y, z) == 5) {
            if (!world.getBlock(x - 1, y, z).isSideSolid(world, x, y, z, EAST)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
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
        // Load the monolith texture. Use special texture if it is a rainbow.
        if(blockName.equals(UNLOCALISEDNAME + "Rainbow"))
            icon[6] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME + "Rainbow");
        else
            icon[6] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME);
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
}
