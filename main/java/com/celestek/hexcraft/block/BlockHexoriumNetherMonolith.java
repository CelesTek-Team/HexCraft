package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.renderer.HexModelRendererMonolith;
import com.celestek.hexcraft.init.HexAchievements;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.init.HexItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

import static net.minecraftforge.common.util.ForgeDirection.*;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.6.1
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

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     * @param hexoriumDropMin Minimum amount of Hexorium Crystals dropped.
     * @param hexoriumDropMax Maximum amount of Hexorium Crystals dropped.
     */
    public BlockHexoriumNetherMonolith(String blockName, int hexoriumDropMin, int hexoriumDropMax) {
        super(Material.glass);

        // Load the constructor parameters.
        this.blockName = blockName;
        this.hexoriumDropMin = hexoriumDropMin;
        this.hexoriumDropMax = hexoriumDropMax;

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.tabComponents);

        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(3F);
        this.setResistance(5F);

        this.setStepSound(Block.soundTypeGlass);
        this.setLightOpacity(0);
    }

    /**
     * Return true if a player with Silk Touch can harvest this block directly, and not its normal drops.
     */
    protected boolean canSilkHarvest()
    {
        return true;
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
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
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
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        // Prepare block meta.
        int meta = world.getBlockMetadata(x, y, z);
        // Compare all neighbouring blocks, and if one of them correspond to the rotation, remove the monolith and drop the crystals.
        if(meta == 0) {
            if (!world.getBlock(x, y + 1, z).isSideSolid(world, x, y, z, DOWN)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(meta == 1) {
            if (!world.getBlock(x, y - 1, z).isSideSolid(world, x, y, z, UP)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(meta == 2) {
            if (!world.getBlock(x, y, z + 1).isSideSolid(world, x, y, z, NORTH)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(meta == 3) {
            if (!world.getBlock(x, y, z - 1).isSideSolid(world, x, y, z, SOUTH)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(meta == 4) {
            if (!world.getBlock(x + 1, y, z).isSideSolid(world, x, y, z, WEST)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(meta == 5) {
            if (!world.getBlock(x - 1, y, z).isSideSolid(world, x, y, z, EAST)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
    }

    /**
     * Checks if the player harvesting the monolith has Fortune enchant.
     */
    @Override
    public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
        // Reset the fortune and silk touch parameters.
        fortune = 0;
        // Check if the player has something in their hand.
        if(player.getCurrentEquippedItem() != null) {
            // Prepare a list of all enchants.
            NBTTagList list = player.getCurrentEquippedItem().getEnchantmentTagList();
            // If the list is not empty...
            if (list != null)
                // Go through all entries.
                for (int i = 0; i < list.tagCount(); i++)
                    // If Fortune (id 35) is found, set the level value.
                    if (list.getCompoundTagAt(i).getByte("id") == 35)
                        fortune = list.getCompoundTagAt(i).getByte("lvl");
        }
        // Grant player the achievement.
        if (HexConfig.cfgGeneralUseAchievements && !player.capabilities.isCreativeMode && this.canHarvestBlock(player, meta))
            player.addStat(HexAchievements.achMineHexMonolith, 1);
    }

    /**
     * Sets quantity of items to drop.
     */
    @Override
    public int quantityDropped(Random random) {
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

    /**
     * Sets up items to drop. Fired the number of times dictated by quantityDropped.
     */
    @Override
    public Item getItemDropped(int metadata, Random random, int fortune) {
        // Return the according crystal color.
        if (this == HexBlocks.blockHexoriumNetherMonolithRed)
            return HexItems.itemHexoriumCrystalRed;
        else if (this == HexBlocks.blockHexoriumNetherMonolithGreen)
            return HexItems.itemHexoriumCrystalGreen;
        else if (this == HexBlocks.blockHexoriumNetherMonolithBlue)
            return HexItems.itemHexoriumCrystalBlue;
        else if (this == HexBlocks.blockHexoriumNetherMonolithWhite)
            return HexItems.itemHexoriumCrystalWhite;
        else if (this == HexBlocks.blockHexoriumNetherMonolithBlack)
            return HexItems.itemHexoriumCrystalBlack;
        else
            return null;
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
    {
        // Get block meta data.
        int meta = world.getBlockMetadata(x, y, z);

        // Return bounding box depending on meta.
        switch (meta) {
            case 0: setBlockBounds(HexModelRendererMonolith.xA, 1 - HexModelRendererMonolith.yMax, HexModelRendererMonolith.zF,
                    HexModelRendererMonolith.xD, 1 - HexModelRendererMonolith.yMin, HexModelRendererMonolith.zB); break;
            case 1: setBlockBounds(HexModelRendererMonolith.xA, HexModelRendererMonolith.yMin, HexModelRendererMonolith.zF,
                    HexModelRendererMonolith.xD, HexModelRendererMonolith.yMax, HexModelRendererMonolith.zB); break;
            case 2: setBlockBounds(HexModelRendererMonolith.zF, HexModelRendererMonolith.xA, 1 - HexModelRendererMonolith.yMax,
                    HexModelRendererMonolith.zB, HexModelRendererMonolith.xD, 1 - HexModelRendererMonolith.yMin); break;
            case 3: setBlockBounds(HexModelRendererMonolith.zF, HexModelRendererMonolith.xA, HexModelRendererMonolith.yMin,
                    HexModelRendererMonolith.zB, HexModelRendererMonolith.xD, HexModelRendererMonolith.yMax); break;
            case 4: setBlockBounds(1 - HexModelRendererMonolith.yMax, HexModelRendererMonolith.xA, HexModelRendererMonolith.zF,
                    1 - HexModelRendererMonolith.yMin, HexModelRendererMonolith.xD, HexModelRendererMonolith.zB); break;
            case 5: setBlockBounds(HexModelRendererMonolith.yMin, HexModelRendererMonolith.xA, HexModelRendererMonolith.zF,
                    HexModelRendererMonolith.yMax, HexModelRendererMonolith.xD, HexModelRendererMonolith.zB); break;
        }
    }

    /**
     * Adds all intersecting collision boxes to a list. (Be sure to only add boxes to the list if they intersect the
     * mask.) Parameters: World, X, Y, Z, mask, list, colliding entity
     */
    @Override
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB aabb, List list, Entity entity)
    {
        this.setBlockBoundsBasedOnState(world, x, y, z);
        super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
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
        // Load the outer texture.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + "transparent");
        // Load the monolith texture from normal ore.
        icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + blockName.replaceAll("Nether", "") + "A");
        // Load the netherrack texture.
        icon[2] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME + "B");
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        // Retrieve icon based on side.
        if (side < 6)
            return icon[0];
        else if (side == 6)
            return icon[1];
        else if (side == 7)
            return icon[2];
        else
            return icon[0];
    }
}
