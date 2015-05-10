package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexItems;
import com.celestek.hexcraft.tileentity.TileEnergyPylon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.Random;

import static net.minecraftforge.common.util.ForgeDirection.*;
import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.WEST;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-05-06
 */

public class BlockEnergyPylon extends HexBlockContainer {

    // Set default block name.
    public static String UNLOCALISEDNAME = "blockEnergyPylon";

    private final Random random = new Random();

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block.
     */
    public BlockEnergyPylon(String blockName) {
        super(Material.iron);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.hexCraftTab);
        this.setHardness(1.5F);
        this.setStepSound(Block.soundTypeMetal);
        this.setHarvestLevel("pickaxe", 0);
    }

    /**
     * Returns a new instance of a block's TIle Entity class. Called on placing the block.
     */
    @Override
    public TileEntity createNewTileEntity(World world, int par2)
    {
        // Create the new TIle Entity.
        return new TileEnergyPylon();
    }

    /**
     * Fired when a player right clicks on the pylon.
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        if (!world.isRemote) {
            TileEnergyPylon tileEntity = (TileEnergyPylon) world.getTileEntity(x, y, z);
            return tileEntity.insertMonolith(player);
        }
        else
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
     * Sets up items to drop.
     */
    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        // Prepare a drop list.
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();

        TileEnergyPylon tileEntity = (TileEnergyPylon) world.getTileEntity(x, y, z);

        // If the block wasn't destroyed using the Manipulator...
        if(fortune != HexCraft.hexFortune) {
            // Set the according crystal color combinations.
            if (tileEntity != null) {
            }
            drops.add(new ItemStack(HexBlocks.blockEnergyPylon, 1));
        }
        else {
            // Return the monolith (because of Manipulator).
            if (tileEntity != null)
            {
                if(tileEntity.monolith == 1)
                    drops.add(new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithRed, 1));
                else if(tileEntity.monolith == 2)
                    drops.add(new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithOrange, 1));
                else if(tileEntity.monolith == 3)
                    drops.add(new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithYellow, 1));
                else if(tileEntity.monolith == 4)
                    drops.add(new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithLime, 1));
                else if(tileEntity.monolith == 5)
                    drops.add(new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithGreen, 1));
                else if(tileEntity.monolith == 6)
                    drops.add(new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithTurquoise, 1));
                else if(tileEntity.monolith == 7)
                    drops.add(new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithCyan, 1));
                else if(tileEntity.monolith == 8)
                    drops.add(new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithSkyBlue, 1));
                else if(tileEntity.monolith == 9)
                    drops.add(new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithBlue, 1));
                else if(tileEntity.monolith == 10)
                    drops.add(new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithPurple, 1));
                else if(tileEntity.monolith == 11)
                    drops.add(new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithMagenta, 1));
                else if(tileEntity.monolith == 12)
                    drops.add(new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithPink, 1));

                else if(tileEntity.monolith == 13)
                    drops.add(new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithWhite, 1));
                else if(tileEntity.monolith == 14)
                    drops.add(new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithLightGray, 1));
                else if(tileEntity.monolith == 15)
                    drops.add(new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithGray, 1));
                else if(tileEntity.monolith == 16)
                    drops.add(new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithDarkGray, 1));
                else if(tileEntity.monolith == 17)
                    drops.add(new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithBlack, 1));

                else if(tileEntity.monolith == 18)
                    drops.add(new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithRainbow, 1));

                tileEntity.ejectMonolith();
            }
        }

        // Return the created drop array.
        return drops;
    }

    /**
     * Called when the block is broken.
     */
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        // Get the Tile Entity.
        TileEnergyPylon tileEntity = (TileEnergyPylon) world.getTileEntity(x, y, z);

        // Check if it is not null.
        if (tileEntity != null) {

            ArrayList<ItemStack> drops = new ArrayList<ItemStack>();

            if (tileEntity.monolith == 1) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 8));
            } else if (tileEntity.monolith == 2) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 6));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 2));
            } else if (tileEntity.monolith == 3) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 4));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 4));
            } else if (tileEntity.monolith == 4) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 2));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 6));
            } else if (tileEntity.monolith == 5) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 8));
            } else if (tileEntity.monolith == 6) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 6));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 2));
            } else if (tileEntity.monolith == 7) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 4));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 4));
            } else if (tileEntity.monolith == 8) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 2));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 6));
            } else if (tileEntity.monolith == 9) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 8));
            } else if (tileEntity.monolith == 10) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 6));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 2));
            } else if (tileEntity.monolith == 11) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 4));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 4));
            } else if (tileEntity.monolith == 12) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 2));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 6));
            } else if (tileEntity.monolith == 13) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 8));
            } else if (tileEntity.monolith == 14) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 6));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlack, 2));
            } else if (tileEntity.monolith == 15) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 4));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlack, 4));
            } else if (tileEntity.monolith == 16) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 2));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlack, 6));
            } else if (tileEntity.monolith == 17) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlack, 8));
            } else if (tileEntity.monolith == 18) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 2));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 2));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 2));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 2));
            }

            // Drop items.
            for (ItemStack entry : drops) {

                if (entry != null) {
                    float f = random.nextFloat() * 0.6F + 0.1F;
                    float f1 = random.nextFloat() * 0.6F + 0.1F;
                    float f2 = random.nextFloat() * 0.6F + 0.1F;

                    while (entry.stackSize > 0) {
                        int j = random.nextInt(21) + 10;

                        if (j > entry.stackSize) {
                            j = entry.stackSize;
                        }

                        entry.stackSize -= j;
                        EntityItem entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(entry.getItem(), j, entry.getItemDamage()));

                        float f3 = 0.025F;
                        entityitem.motionX = (double) ((float) this.random.nextGaussian() * f3);
                        entityitem.motionY = (double) ((float) this.random.nextGaussian() * f3 + 0.1F);
                        entityitem.motionZ = (double) ((float) this.random.nextGaussian() * f3);
                        world.spawnEntityInWorld(entityitem);
                    }
                }
            }
            world.func_147453_f(x, y, z, block);
        }
        super.breakBlock(world, x, y, z, block, meta);
    }

    /**
     * Returns the item drop of the block.
     */
    @Override
    public Item getItemDropped(int par1, Random random, int par3) {
        return Item.getItemFromBlock(HexBlocks.blockEnergyPylon);
    }

    /**
     * Returns the item of the block.
     */
    @Override
    public Item getItem(World world, int par2, int par3, int par4) {
        return Item.getItemFromBlock(HexBlocks.blockEnergyPylon);
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
        icon = new IIcon[10];
        // Load the pylon base textures.
        for(int i = 0; i < 6; i++)
            icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME + "A");
        // Load the monolith textures.
        icon[6] = iconRegister.registerIcon(HexCraft.MODID + ":" + BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME);
        icon[7] = iconRegister.registerIcon(HexCraft.MODID + ":" + BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Rainbow");
        icon[8] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME + "B");
        icon[9] = iconRegister.registerIcon(HexCraft.MODID + ":" + BlockPylonBase.UNLOCALISEDNAME + "B");
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int i, int meta) {
        return icon[i];
    }

    /**
     * Makes the block noz interact with AO.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isBlockNormalCube()
    {
        return false;
    }

    /**
     * Forces the block not to hide faces of other blocks.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isOpaqueCube()
    {
        return false;
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

    /**
     * Forces the block not to conduct Redstone current.
     */
    @Override
    public boolean shouldCheckWeakPower(IBlockAccess world, int x, int y, int z, int side)
    {
        return false;
    }
}
