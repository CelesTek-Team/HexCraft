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
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;

import static net.minecraftforge.common.util.ForgeDirection.*;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.3.0
 * @since 2015-04-14
 */

public class BlockEnergizedHexoriumMonolith extends HexBlockModel {

    // Set default block name.
    public static String UNLOCALISEDNAME = "blockEnergizedHexoriumMonolith";

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     */
    public BlockEnergizedHexoriumMonolith(String blockName) {
        super(Material.glass);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.hexCraftTab);
        this.setHardness(0.3F);
        this.setStepSound(Block.soundTypeGlass);
        this.setLightOpacity(0);
    }

    /**
     * Called when a player tries to place the monolith.
     */
    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
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
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) { // TODO: Fix dropping!
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
     * Sets up items to drop.
     */
    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        // Prepare a drop list.
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();

        // If the block wasn't destroyed using the Manipulator...
        if(fortune != HexCraft.hexFortune) {
            // Set the according crystal color combinations.
            if (this == HexBlocks.blockEnergizedHexoriumMonolithRed) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 8));
            } else if (this == HexBlocks.blockEnergizedHexoriumMonolithOrange) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 6));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 2));
            } else if (this == HexBlocks.blockEnergizedHexoriumMonolithYellow) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 4));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 4));
            } else if (this == HexBlocks.blockEnergizedHexoriumMonolithLime) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 2));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 6));
            } else if (this == HexBlocks.blockEnergizedHexoriumMonolithGreen) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 8));
            } else if (this == HexBlocks.blockEnergizedHexoriumMonolithTurquoise) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 6));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 2));
            } else if (this == HexBlocks.blockEnergizedHexoriumMonolithCyan) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 4));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 4));
            } else if (this == HexBlocks.blockEnergizedHexoriumMonolithSkyBlue) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 2));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 6));
            } else if (this == HexBlocks.blockEnergizedHexoriumMonolithBlue) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 8));
            } else if (this == HexBlocks.blockEnergizedHexoriumMonolithPurple) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 6));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 2));
            } else if (this == HexBlocks.blockEnergizedHexoriumMonolithMagenta) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 4));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 4));
            } else if (this == HexBlocks.blockEnergizedHexoriumMonolithPink) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 2));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 6));

            } else if (this == HexBlocks.blockEnergizedHexoriumMonolithWhite) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 8));
            } else if (this == HexBlocks.blockEnergizedHexoriumMonolithLightGray) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 6));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlack, 2));
            } else if (this == HexBlocks.blockEnergizedHexoriumMonolithGray) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 4));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlack, 4));
            } else if (this == HexBlocks.blockEnergizedHexoriumMonolithDarkGray) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 2));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlack, 6));
            } else if (this == HexBlocks.blockEnergizedHexoriumMonolithBlack) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlack, 8));

            } else if (this == HexBlocks.blockEnergizedHexoriumMonolithRainbow) {
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

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
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
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
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
        icon = new IIcon[7];
        // Load the outer textures.
        for(int i = 0; i < 6; i++)
            icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + "transparent");
        // Load the monolith texture. Use special texture if it is a rainbow.
        if(this == HexBlocks.blockEnergizedHexoriumMonolithRainbow)
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
