package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.renderer.HexModelRendererMonolith;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.Random;

import static net.minecraftforge.common.util.ForgeDirection.*;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-14
 */

public class BlockHexoriumMonolith extends HexBlockModel {

    // Set default block name.
    public static String UNLOCALISEDNAME = "blockHexoriumMonolith";

    // Used later for texture identification.
    private String blockName;

    // Used for drop rates.
    private int hexoriumDropMin;
    private int hexoriumDropMax;

    // Used for tool enchants.
    private int fortune = 0;
    private boolean silk = false;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     * @param hexoriumDropMin Minimum amount of Hexorium Crystals dropped.
     * @param hexoriumDropMax Maximum amount of Hexorium Crystals dropped.
     */
    public BlockHexoriumMonolith(String blockName, int hexoriumDropMin, int hexoriumDropMax) {
        super(Material.rock);

        // Load the constructor parameters.
        this.blockName = blockName;
        this.hexoriumDropMin = hexoriumDropMin;
        this.hexoriumDropMax = hexoriumDropMax;

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.hexCraftTab);
        this.setHardness(3F);
        this.setStepSound(Block.soundTypeGlass);
        this.setHarvestLevel("pickaxe", 2);
        this.setLightOpacity(0);
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
     * Called when a block is placed using its ItemBlock.
     */
    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta)
    {
        // Reset the fortune and silk touch parameters.
        fortune = 0;
        silk = false;

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

    /**
     * Checks if the player harvesting the monolith has Silk Touch enchant and/or Fortune enchant.
     */
    @Override
    public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
        // Check if the player has something in their hand.
        if(player.getCurrentEquippedItem() != null) {
            // Prepare a list of all enchants.
            NBTTagList list = player.getCurrentEquippedItem().getEnchantmentTagList();
            // If the list is not empty...
            if (list != null)
                // Go through all entries.
                for (int i = 0; i < list.tagCount(); i++) {
                    // If Silk Touch (id 33) is found, set it to true.
                    if (list.getCompoundTagAt(i).getByte("id") == 33)
                        silk = true;
                    // If Fortune (id 35) is found, set the level value.
                    if (list.getCompoundTagAt(i).getByte("id") == 35)
                        fortune = list.getCompoundTagAt(i).getByte("lvl");
                }
        }
    }

    /**
     * Sets quantity of items to drop.
     */
    @Override
    public int quantityDropped(Random random)
    {
        // Check if Silk Touch should be used. If not...
        if(!silk) {
            // Prepare the fortune extra drop count.
            int fortuneDrop = 0;

            // Set the according fortune extra drop count.
            if (fortune == 1)
                fortuneDrop = 2;
            else if (fortune == 2)
                fortuneDrop = 4;
            else if (fortune == 3)
                fortuneDrop = 6;

            // If max and min drop rates are identical, drop only one value, otherwise, do a random calculation.
            if (hexoriumDropMin == hexoriumDropMax)
                return hexoriumDropMin;
            else
                return fortuneDrop + hexoriumDropMin + random.nextInt(hexoriumDropMax - hexoriumDropMin + 1);
        }
        else
            // Return only 1 block (because of Silk Touch).
            return 1;
    }

    /**
     * Sets up items to drop. Fired the number of times dictated by quantityDropped.
     */
    @Override
    public Item getItemDropped(int metadata, Random random, int fortune) {
        // Check if Silk Touch should be used. If not...
        if(!silk) {
            // Return the according crystal color.
            if (blockName.equals(UNLOCALISEDNAME + "Red"))
                return HexItems.itemHexoriumCrystalRed;
            else if (blockName.equals(UNLOCALISEDNAME + "Green"))
                return HexItems.itemHexoriumCrystalGreen;
            else if (blockName.equals(UNLOCALISEDNAME + "Blue"))
                return HexItems.itemHexoriumCrystalBlue;
            else if (blockName.equals(UNLOCALISEDNAME + "White"))
                return HexItems.itemHexoriumCrystalWhite;
            else if (blockName.equals(UNLOCALISEDNAME + "Black"))
                return HexItems.itemHexoriumCrystalBlack;
            else
                return null;
        }
        else {
            // Return the block (because of Silk Touch).
            if (blockName.equals(UNLOCALISEDNAME + "Red"))
                return Item.getItemFromBlock(HexBlocks.blockHexoriumMonolithRed);
            else if (blockName.equals(UNLOCALISEDNAME + "Green"))
                return Item.getItemFromBlock(HexBlocks.blockHexoriumMonolithGreen);
            else if (blockName.equals(UNLOCALISEDNAME + "Blue"))
                return Item.getItemFromBlock(HexBlocks.blockHexoriumMonolithBlue);
            else if (blockName.equals(UNLOCALISEDNAME + "White"))
                return Item.getItemFromBlock(HexBlocks.blockHexoriumMonolithWhite);
            else if (blockName.equals(UNLOCALISEDNAME + "Black"))
                return Item.getItemFromBlock(HexBlocks.blockHexoriumMonolithBlack);
            else
                return null;
        }
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        // Get block meta data.
        int meta = world.getBlockMetadata(x, y, z);

        // Return bounding box depending on meta.
        switch (meta) {
            case 0:
                return AxisAlignedBB.getBoundingBox((double)x + HexModelRendererMonolith.xA, (double)y + 1 - HexModelRendererMonolith.yMax, (double)z + HexModelRendererMonolith.zF,
                        (double)x + HexModelRendererMonolith.xD, (double)y + 1 - HexModelRendererMonolith.yMin, (double)z + HexModelRendererMonolith.zB);
            case 1:
                return AxisAlignedBB.getBoundingBox((double)x + HexModelRendererMonolith.xA, (double)y + HexModelRendererMonolith.yMin, (double)z + HexModelRendererMonolith.zF,
                        (double)x + HexModelRendererMonolith.xD, (double)y + HexModelRendererMonolith.yMax, (double)z + HexModelRendererMonolith.zB);
            case 2:
                return AxisAlignedBB.getBoundingBox((double)x + HexModelRendererMonolith.zF, (double)y + HexModelRendererMonolith.xA, (double)z + 1 - HexModelRendererMonolith.yMax,
                        (double)x + HexModelRendererMonolith.zB, (double)y + HexModelRendererMonolith.xD, (double)z + 1 - HexModelRendererMonolith.yMin);
            case 3:
                return AxisAlignedBB.getBoundingBox((double)x + HexModelRendererMonolith.zF, (double)y + HexModelRendererMonolith.xA, (double)z + HexModelRendererMonolith.yMin,
                        (double)x + HexModelRendererMonolith.zB, (double)y + HexModelRendererMonolith.xD, (double)z + HexModelRendererMonolith.yMax);
            case 4:
                return AxisAlignedBB.getBoundingBox((double)x + 1 - HexModelRendererMonolith.yMax, (double)y + HexModelRendererMonolith.xA, (double)z + HexModelRendererMonolith.zF,
                        (double)x + 1 - HexModelRendererMonolith.yMin, (double)y + HexModelRendererMonolith.xD, (double)z + HexModelRendererMonolith.zB);
            case 5:
                return AxisAlignedBB.getBoundingBox((double)x + HexModelRendererMonolith.yMin, (double)y + HexModelRendererMonolith.xA, (double)z + HexModelRendererMonolith.zF,
                        (double)x + HexModelRendererMonolith.yMax, (double)y + HexModelRendererMonolith.xD, (double)z + HexModelRendererMonolith.zB);
            default:
                return AxisAlignedBB.getBoundingBox((double)x + 0, (double)y + 0, (double)z + 0, (double)x + 1, (double)y + 1, (double)z + 1);
        }
    }

    /**
     * Returns the bounding box of the wired rectangular prism to render.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
    {
        // Get block meta data.
        int meta = world.getBlockMetadata(x, y, z);

        // Return bounding box depending on meta.
        switch (meta) {
            case 0: setBlockBounds(HexModelRendererMonolith.xA, 1 - HexModelRendererMonolith.yMax, HexModelRendererMonolith.zF,
                    HexModelRendererMonolith.xD, 1 - HexModelRendererMonolith.yMin, HexModelRendererMonolith.zB);
                return AxisAlignedBB.getBoundingBox((double)x + HexModelRendererMonolith.xA, (double)y + 1 - HexModelRendererMonolith.yMax, (double)z + HexModelRendererMonolith.zF,
                        (double)x + HexModelRendererMonolith.xD, (double)y + 1 - HexModelRendererMonolith.yMin, (double)z + HexModelRendererMonolith.zB);
            case 1: setBlockBounds(HexModelRendererMonolith.xA, HexModelRendererMonolith.yMin, HexModelRendererMonolith.zF,
                    HexModelRendererMonolith.xD, HexModelRendererMonolith.yMax, HexModelRendererMonolith.zB);
                return AxisAlignedBB.getBoundingBox((double)x + HexModelRendererMonolith.xA, (double)y + HexModelRendererMonolith.yMin, (double)z + HexModelRendererMonolith.zF,
                        (double)x + HexModelRendererMonolith.xD, (double)y + HexModelRendererMonolith.yMax, (double)z + HexModelRendererMonolith.zB);
            case 2: setBlockBounds(HexModelRendererMonolith.zF, HexModelRendererMonolith.xA, 1 - HexModelRendererMonolith.yMax,
                    HexModelRendererMonolith.zB, HexModelRendererMonolith.xD, 1 - HexModelRendererMonolith.yMin);
                return AxisAlignedBB.getBoundingBox((double)x + HexModelRendererMonolith.zF, (double)y + HexModelRendererMonolith.xA, (double)z + 1 - HexModelRendererMonolith.yMax,
                        (double)x + HexModelRendererMonolith.zB, (double)y + HexModelRendererMonolith.xD, (double)z + 1 - HexModelRendererMonolith.yMin);
            case 3: setBlockBounds(HexModelRendererMonolith.zF, HexModelRendererMonolith.xA, HexModelRendererMonolith.yMin,
                    HexModelRendererMonolith.zB, HexModelRendererMonolith.xD, HexModelRendererMonolith.yMax);
                return AxisAlignedBB.getBoundingBox((double)x + HexModelRendererMonolith.zF, (double)y + HexModelRendererMonolith.xA, (double)z + HexModelRendererMonolith.yMin,
                        (double)x + HexModelRendererMonolith.zB, (double)y + HexModelRendererMonolith.xD, (double)z + HexModelRendererMonolith.yMax);
            case 4: setBlockBounds(1 - HexModelRendererMonolith.yMax, HexModelRendererMonolith.xA, HexModelRendererMonolith.zF,
                    1 - HexModelRendererMonolith.yMin, HexModelRendererMonolith.xD, HexModelRendererMonolith.zB);
                return AxisAlignedBB.getBoundingBox((double)x + 1 - HexModelRendererMonolith.yMax, (double)y + HexModelRendererMonolith.xA, (double)z + HexModelRendererMonolith.zF,
                        (double)x + 1 - HexModelRendererMonolith.yMin, (double)y + HexModelRendererMonolith.xD, (double)z + HexModelRendererMonolith.zB);
            case 5: setBlockBounds(HexModelRendererMonolith.yMin, HexModelRendererMonolith.xA, HexModelRendererMonolith.zF,
                    HexModelRendererMonolith.yMax, HexModelRendererMonolith.xD, HexModelRendererMonolith.zB);
                return AxisAlignedBB.getBoundingBox((double)x + HexModelRendererMonolith.yMin, (double)y + HexModelRendererMonolith.xA, (double)z + HexModelRendererMonolith.zF,
                        (double)x + HexModelRendererMonolith.yMax, (double)y + HexModelRendererMonolith.xD, (double)z + HexModelRendererMonolith.zB);
            default:
                return AxisAlignedBB.getBoundingBox((double)x + 0, (double)y + 0, (double)z + 0, (double)x + 1, (double)y + 1, (double)z + 1);
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
        icon = new IIcon[8];
        // Load the outer textures.
        for(int i = 0; i < 6; i++)
            icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + "transparent");
        // Load the monolith texture.
        icon[6] = iconRegister.registerIcon(HexCraft.MODID + ":" + blockName + "A");
        // Load the stone texture.
        icon[7] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME + "B");
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
