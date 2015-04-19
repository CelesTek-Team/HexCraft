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

    /* Set default block name. */
    public static String UNLOCALISEDNAME = "blockHexoriumNetherMonolith";

    /* Used later for texture identification. */
    private String blockName;

    /** Used for drop rates. */
    private int hexoriumDropMin;
    private int hexoriumDropMax;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     */
    public BlockHexoriumNetherMonolith(String blockName, int hexoriumDropMin, int hexoriumDropMax) {
        super(Material.glass);

        this.blockName = blockName;
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.hexCraftTab);
        this.setHardness(3F);
        this.setHarvestLevel("pickaxe", 2);
        this.setStepSound(Block.soundTypeGlass);

        this.hexoriumDropMin = hexoriumDropMin;
        this.hexoriumDropMax = hexoriumDropMax;
    }

    /**
     * Sets up Hexorium Crystal drops dropping.
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
        /** If max and min drop rates are identical, drop only one value, otherwise, do a random calculation. */
        if(hexoriumDropMin == hexoriumDropMax)
            return hexoriumDropMin;
        else
            return hexoriumDropMin + random.nextInt(hexoriumDropMax - hexoriumDropMin + 1);
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
        icon = new IIcon[8];
        for(int i = 0; i < 6; i++)
            icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + "transparent");
        icon[6] = iconRegister.registerIcon(HexCraft.MODID + ":" + blockName.replaceAll("Nether", "") + "A");
        icon[7] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME + "B");
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
