package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexItems;
import com.celestek.hexcraft.tileentity.TileHexoriumGenerator;
import com.celestek.hexcraft.util.NetworkAnalyzer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.4.0
 * @since 2015-04-14
 */

public class BlockHexoriumGenerator extends HexBlockContainer {

    // Set default block name.
    public static String UNLOCALISEDNAME = "blockHexoriumGenerator";

    private final Random random = new Random();

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block.
     */
    public BlockHexoriumGenerator(String blockName) {
        super(Material.iron);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.hexCraftTab);

        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(5F);
        this.setResistance(30F);

        this.setStepSound(Block.soundTypeMetal);
    }

    /**
     * Returns a new instance of a block's TIle Entity class. Called on placing the block.
     */
    @Override
    public TileEntity createNewTileEntity(World world, int par2)
    {
        // Create the new TIle Entity.
        return new TileHexoriumGenerator();
    }

    /**
     * Called when a block is placed by a player.
     */
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
        // Get the direction of the block.
        int direction = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        // Set the block's meta data according to direction.
        world.setBlockMetadataWithNotify(x, y, z, direction + 8, 2);

        // Check if the code is executed on the server.
        if(!world.isRemote) {

            // System.out.println("Machine placed, analyzing!");

            /* DO ANALYSIS, BASED ON ORIENTATION */
            // Prepare the network analyzer.
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            // Call the analysis in the direction the machine is rotated.
            analyzer.analyzeMachine(world, x, y, z, direction);
        }
    }

    /**
     * Fired when a player right clicks on the machine.
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        // Check if the equipped item is not a Hexorium Manipulator.
        ItemStack itemStack = player.getCurrentEquippedItem();
        if (itemStack != null) {
            if (itemStack.getItem() != HexItems.itemHexoriumManipulator)
                // Open the GUI.
                player.openGui(HexCraft.instance, 0, world, x, y, z);
        }
        else
            // Open the GUI.
            player.openGui(HexCraft.instance, 0, world, x, y, z);
        return true;
    }

    /**
     * Called when a block near is changed.
     */
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        // Prepare the name string of the broken block.
        String blockName = block.getUnlocalizedName();

        // Check if the changed block is a cable.
        if (block instanceof BlockHexoriumCable ||
                block instanceof BlockPylonBase) {

            // Prepare the block meta.
            int meta = world.getBlockMetadata(x, y, z);

            // System.out.println("Neighbour cable destroyed, analyzing!");

            /* DO ANALYSIS, BASED ON ORIENTATION */
            // Prepare the network analyzer.
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            // Call the analysis in the direction the machine is rotated.
            analyzer.analyzeMachine(world, x, y, z, meta);
        }
    }

    /**
     * Called when the block is broken.
     */
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        // Get the Tile Entity.
        TileHexoriumGenerator tileEntity = (TileHexoriumGenerator) world.getTileEntity(x, y, z);

        // Check if it is not null.
        if (tileEntity != null) {

            // Drop items.
            for (int i = 0; i < tileEntity.getSizeInventory(); ++i) {
                ItemStack itemstack = tileEntity.getStackInSlot(i);

                if (itemstack != null) {
                    float f = random.nextFloat() * 0.6F + 0.1F;
                    float f1 = random.nextFloat() * 0.6F + 0.1F;
                    float f2 = random.nextFloat() * 0.6F + 0.1F;

                    while (itemstack.stackSize > 0) {
                        int j = random.nextInt(21) + 10;

                        if (j > itemstack.stackSize) {
                            j = itemstack.stackSize;
                        }

                        itemstack.stackSize -= j;
                        EntityItem entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));

                        if (itemstack.hasTagCompound()) {
                            entityitem.getEntityItem().setTagCompound(((NBTTagCompound) itemstack.getTagCompound().copy()));
                        }

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
     * Gets the light value according to meta.
     */
    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        // Get the block meta.
        Block block = world.getBlock(x, y, z);
        int meta = world.getBlockMetadata(x, y, z);
        // If the machine is active, make it emit light.
        if (block == this && meta >= 4 && meta < 8)
            return 12;
        else
            return 0;
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
        icon = new IIcon[15];
        // Load the outer textures.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + "machineBottom");
        icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + "machineBack");
        for (int i = 1; i < 13; i++)
            if (i < 10)
                icon[i + 1] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME + "/" + UNLOCALISEDNAME + "0" + i);
            else
                icon[i + 1] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME + "/" + UNLOCALISEDNAME + i);
        // Load the inner texture
        icon[14] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glow");
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int i, int meta) {
        // System.out.println("Sides requested!");
        if (meta == 0) {
            switch (i) {
                case 0: return icon[0];
                case 1: return icon[4];
                case 2: return icon[10];
                case 3: return icon[1];
                case 4: return icon[13];
                case 5: return icon[13];
                case 6: return icon[14];
            }
        } else if (meta == 1) {
            switch (i) {
                case 0: return icon[0];
                case 1: return icon[5];
                case 2: return icon[13];
                case 3: return icon[13];
                case 4: return icon[1];
                case 5: return icon[10];
                case 6: return icon[14];
            }
        } else if (meta == 2) {
            switch (i) {
                case 0: return icon[0];
                case 1: return icon[2];
                case 2: return icon[1];
                case 3: return icon[10];
                case 4: return icon[13];
                case 5: return icon[13];
                case 6: return icon[14];
            }
        } else if (meta == 3) {
            switch (i) {
                case 0: return icon[0];
                case 1: return icon[3];
                case 2: return icon[13];
                case 3: return icon[13];
                case 4: return icon[10];
                case 5: return icon[1];
                case 6: return icon[14];
            }
        } else if (meta == 4) {
            switch (i) {
                case 0: return icon[0];
                case 1: return icon[8];
                case 2: return icon[11];
                case 3: return icon[1];
                case 4: return icon[13];
                case 5: return icon[13];
                case 6: return icon[14];
            }
        } else if (meta == 5) {
            switch (i) {
                case 0: return icon[0];
                case 1: return icon[9];
                case 2: return icon[13];
                case 3: return icon[13];
                case 4: return icon[1];
                case 5: return icon[11];
                case 6: return icon[14];
            }
        } else if (meta == 6) {
            switch (i) {
                case 0: return icon[0];
                case 1: return icon[6];
                case 2: return icon[1];
                case 3: return icon[11];
                case 4: return icon[13];
                case 5: return icon[13];
                case 6: return icon[14];
            }
        } else if (meta == 7) {
            switch (i) {
                case 0: return icon[0];
                case 1: return icon[7];
                case 2: return icon[13];
                case 3: return icon[13];
                case 4: return icon[11];
                case 5: return icon[1];
                case 6: return icon[14];
            }
        } else if (meta == 8) {
            switch (i) {
                case 0: return icon[0];
                case 1: return icon[4];
                case 2: return icon[12];
                case 3: return icon[1];
                case 4: return icon[13];
                case 5: return icon[13];
                case 6: return icon[14];
            }
        } else if (meta == 9) {
            switch (i) {
                case 0: return icon[0];
                case 1: return icon[5];
                case 2: return icon[13];
                case 3: return icon[13];
                case 4: return icon[1];
                case 5: return icon[12];
                case 6: return icon[14];
            }
        } else if (meta == 10) {
            switch (i) {
                case 0: return icon[0];
                case 1: return icon[2];
                case 2: return icon[1];
                case 3: return icon[12];
                case 4: return icon[13];
                case 5: return icon[13];
                case 6: return icon[14];
            }
        } else if (meta == 11) {
            switch (i) {
                case 0: return icon[0];
                case 1: return icon[3];
                case 2: return icon[13];
                case 3: return icon[13];
                case 4: return icon[12];
                case 5: return icon[1];
                case 6: return icon[14];
            }
        }
        return icon[i];
    }
}
