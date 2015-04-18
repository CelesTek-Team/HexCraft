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

    /* Set default block name. */
    public static String UNLOCALISEDNAME = "blockEnergizedHexoriumMonolith";

    /* Used later for texture identification. */
    private String blockName;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     */
    public BlockEnergizedHexoriumMonolith(String blockName) {
        super(Material.glass);

        this.blockName = blockName;
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.hexCraftTab);
        this.setHardness(0.3F);
        //this.setHarvestLevel("pickaxe", 0);
        this.setStepSound(Block.soundTypeGlass);
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();

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

        return drops;
    }
    
    /**
     * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
     */
    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta)
    {
        int available = -1;

        if (side == 0 && world.isSideSolid(x, y + 1, z, DOWN)) 
            available = side;
        else if (side == 1 && world.isSideSolid(x, y - 1, z, UP)) 
            available = side;
        else if (side == 2 && world.isSideSolid(x, y, z + 1, NORTH)) 
            available = side;
        else if (side == 3 && world.isSideSolid(x, y, z - 1, SOUTH)) 
            available = side;
        else if (side == 4 && world.isSideSolid(x + 1, y, z, WEST)) 
            available = side;
        else if (side == 5 && world.isSideSolid(x - 1, y, z, EAST)) 
            available = side;
        else {
            if (world.isSideSolid(x, y - 1, z, UP)) 
                available = 1;
            else if (world.isSideSolid(x, y, z + 1, NORTH)) 
                available = 2;
            else if (world.isSideSolid(x - 1, y, z, EAST)) 
                available = 5;
            else if (world.isSideSolid(x, y, z - 1, SOUTH)) 
                available = 3;
            else if (world.isSideSolid(x + 1, y, z, WEST)) 
                available = 4;
            else if (world.isSideSolid(x, y + 1, z, DOWN)) 
                available = 0;
        }

        System.out.println("onBlockPlaced - Side: " + available + " Actual: " + side);

        return available;
    }

    @Override
    public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
        return false;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        return (world.isSideSolid(x, y - 1, z, UP)) ||
                (world.isSideSolid(x, y + 1, z, DOWN)) ||
                (world.isSideSolid(x, y, z + 1, NORTH)) ||
                (world.isSideSolid(x, y, z - 1, SOUTH)) ||
                (world.isSideSolid(x + 1, y, z, WEST)) ||
                (world.isSideSolid(x - 1, y, z, EAST));
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
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

    /* Prepare the icons. */
    @SideOnly(Side.CLIENT)
    private IIcon icon[];

    /**
     * Registers the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        icon = new IIcon[7];
        for(int i = 0; i < 6; i++)
            icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + "transparent");
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
    public IIcon getIcon(int par1, int par2) {
        return icon[par1];
    }
}
