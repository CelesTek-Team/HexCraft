package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.init.HexGui;
import com.celestek.hexcraft.init.HexItems;
import com.celestek.hexcraft.tileentity.TileHexoriumFurnace;
import com.celestek.hexcraft.util.HexUtils;
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
 */

public class BlockHexoriumFurnace extends HexBlockContainer implements IBlockHexEnergyDrain {

    // Block ID
    public static final String ID = "blockHexoriumFurnace";

    private final Random random = new Random();

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block.
     */
    public BlockHexoriumFurnace(String blockName) {
        super(Material.iron);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.tabMachines);

        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(5F);
        this.setResistance(10F);

        this.setStepSound(Block.soundTypeMetal);
    }

    /**
     * Returns a new instance of a block's TIle Entity class. Called on placing the block.
     */
    @Override
    public TileEntity createNewTileEntity(World world, int par2) {
        return new TileHexoriumFurnace();
    }

    /**
     * Called when a block is placed by a player.
     */
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
        // Get the direction of the block and set the meta.
        int direction = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        int meta = HexUtils.setBitBiInt(HexBlocks.META_MACHINE_ROTATION_0, HexBlocks.META_MACHINE_ROTATION_1, direction, 0);
        meta = HexUtils.setBitBiInt(HexBlocks.META_MACHINE_STATUS_0, HexBlocks.META_MACHINE_STATUS_1, HexBlocks.MACHINE_STATE_DEAD, meta);
        world.setBlockMetadataWithNotify(x, y, z, meta, HexUtils.META_NOTIFY_UPDATE);

        if(!world.isRemote) {

            if (HexConfig.cfgGeneralNetworkDebug)
                System.out.println("[Hexorium Furnace] (" + x + ", " + y + ", " + z + "): Machine placed, analyzing!");

            /* DO ANALYSIS, BASED ON ORIENTATION */
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            analyzer.analyzeMachines(world, x, y, z, meta);
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
            if (itemStack.getItem() != HexItems.itemHexoriumManipulator && itemStack.getItem() != HexItems.itemHexoriumProbe)
                player.openGui(HexCraft.instance, HexGui.GUI_ID_HEXORIUM_FURNACE, world, x, y, z);
        }
        else
            player.openGui(HexCraft.instance, HexGui.GUI_ID_HEXORIUM_FURNACE, world, x, y, z);
        return true;
    }

    /**
     * Called when a block near is changed.
     */
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        // Check if the changed block is a cable.
        if (block instanceof BlockHexoriumCable
                || block instanceof BlockPylonBase
                || block instanceof BlockEnergyNodePortHEX) {

            if (HexConfig.cfgGeneralNetworkDebug)
                System.out.println("[Hexorium Furnace] (" + x + ", " + y + ", " + z + "): Neighbour cable destroyed, analyzing!");

            /* DO ANALYSIS, BASED ON ORIENTATION */
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            analyzer.analyzeMachines(world, x, y, z, world.getBlockMetadata(x, y, z));
        }
    }

    /**
     * Called when the block is broken.
     */
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        TileHexoriumFurnace tileHexoriumFurnace = (TileHexoriumFurnace) world.getTileEntity(x, y, z);

        if (tileHexoriumFurnace != null) {

            // Stop the machine processing.
            tileHexoriumFurnace.stopProcessing();

            // Drop items.
            for (int i = 0; i < tileHexoriumFurnace.getSizeInventory(); ++i) {
                ItemStack itemstack = tileHexoriumFurnace.getStackInSlot(i);

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
        // If the machine is active, make it emit light.
        if (HexUtils.getMetaBitBiInt(HexBlocks.META_MACHINE_STATUS_0,
                HexBlocks.META_MACHINE_STATUS_1, world, x, y, z) == HexBlocks.MACHINE_STATE_ACTIVE)
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
                icon[i + 1] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "0" + i);
            else
                icon[i + 1] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + i);
        // Load the inner texture
        icon[14] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glow");
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        int state1 = HexUtils.getBitBiInt(HexBlocks.META_MACHINE_STATUS_0, HexBlocks.META_MACHINE_STATUS_1, meta);
        int state2 = 0;
        if (state1 == HexBlocks.MACHINE_STATE_ACTIVE)
            state2 = 4;
        int rotation = HexUtils.getBitBiInt(HexBlocks.META_MACHINE_ROTATION_0, HexBlocks.META_MACHINE_ROTATION_1, meta);

        if (rotation == 0) {
            switch (side) {
                case 0: return icon[0];
                case 1: return icon[4 + state2];
                case 2: return icon[10 + state1];
                case 3: return icon[1];
                case 4: return icon[13];
                case 5: return icon[13];
                case 6: return icon[14];
            }
        }
        else if (rotation == 1) {
            switch (side) {
                case 0: return icon[0];
                case 1: return icon[5 + state2];
                case 2: return icon[13];
                case 3: return icon[13];
                case 4: return icon[1];
                case 5: return icon[10 + state1];
                case 6: return icon[14];
            }
        }
        else if (rotation == 2) {
            switch (side) {
                case 0: return icon[0];
                case 1: return icon[2 + state2];
                case 2: return icon[1];
                case 3: return icon[10 + state1];
                case 4: return icon[13];
                case 5: return icon[13];
                case 6: return icon[14];
            }
        }
        else if (rotation == 3) {
            switch (side) {
                case 0: return icon[0];
                case 1: return icon[3 + state2];
                case 2: return icon[13];
                case 3: return icon[13];
                case 4: return icon[10 + state1];
                case 5: return icon[1];
                case 6: return icon[14];
            }
        }
        return icon[side];
    }
}
