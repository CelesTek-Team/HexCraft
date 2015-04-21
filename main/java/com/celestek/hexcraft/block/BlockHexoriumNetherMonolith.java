package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

import static net.minecraftforge.common.util.ForgeDirection.*;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-14
 */

public class BlockHexoriumNetherMonolith extends HexBlockModel {

    // Set default block name.
    public static String UNLOCALISEDNAME = "blockHexoriumNetherMonolith";

    // Used later for texture identification.
    private String blockName;

    // Used for drop rates.
    private int hexoriumDropMin;
    private int hexoriumDropMax;

    // Used for tool enchants.
    private int fortune = 0;
    private boolean silk = false;
    private Item dropItem;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     * @param hexoriumDropMin Minimum amount of Hexorium Crystals dropped.
     * @param hexoriumDropMax Maximum amount of Hexorium Crystals dropped.
     */
    public BlockHexoriumNetherMonolith(String blockName, int hexoriumDropMin, int hexoriumDropMax) {
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
                    if (list.getCompoundTagAt(i).getByte("id") == 33) {
                        silk = true;
                        dropItem = this.getItem(world, x, y, z);
                    }
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
                fortuneDrop = 8;

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
                return HexItems.itemHexoriumCrystalWhite;
        }
        else
            // Return the block (because of Silk Touch).
            return dropItem;
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
        icon = new IIcon[8];
        // Load the outer textures.
        for(int i = 0; i < 6; i++)
            icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + "transparent");
        // Load the monolith texture from normal ore.
        icon[6] = iconRegister.registerIcon(HexCraft.MODID + ":" + blockName.replaceAll("Nether", "") + "A");
        // Load the netherrack texture.
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
