package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.init.HexItems;
import com.celestek.hexcraft.tileentity.TilePersonalTeleportationPad;
import com.celestek.hexcraft.util.NetworkAnalyzer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.7.0
 */

public class BlockPersonalTeleportationPad extends HexBlockContainer {

    // Set default block name.
    public static String UNLOCALISEDNAME = "blockPersonalTeleportationPad";

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block.
     */
    public BlockPersonalTeleportationPad(String blockName) {
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
    public TileEntity createNewTileEntity(World world, int par2)
    {
        // Create the new TIle Entity.
        return new TilePersonalTeleportationPad();
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

            if (HexConfig.cfgGeneralNetworkDebug)
                System.out.println("Teleport placed, analyzing!");

            /* DO ANALYSIS, BASED ON ORIENTATION */
            // Prepare the network analyzer.
            NetworkAnalyzer analyzer1 = new NetworkAnalyzer();
            // Call the analysis in the direction the machine is rotated.
            analyzer1.analyzeMachine(world, x, y, z, direction);

            // Prepare the network analyzer.
            NetworkAnalyzer analyzer2 = new NetworkAnalyzer();
            // Call the analysis below the teleportation pad.
            analyzer2.analyzeTeleport(world, x, y, z);
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
                player.openGui(HexCraft.instance, 4, world, x, y, z);
        }
        else
            // Open the GUI.
            player.openGui(HexCraft.instance, 4, world, x, y, z);
        return true;
    }

    /**
     * Called when a block near is changed.
     */
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {

        // Check if the changed block is a cable.
        if (block instanceof BlockHexoriumCable ||
                block instanceof BlockPylonBase) {

            // Prepare the block meta.
            int meta = world.getBlockMetadata(x, y, z);

            if (HexConfig.cfgGeneralNetworkDebug)
                System.out.println("Neighbour cable destroyed, analyzing!");

            /* DO ANALYSIS, BASED ON ORIENTATION */
            // Prepare the network analyzer.
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            // Call the analysis in the direction the machine is rotated.
            analyzer.analyzeMachine(world, x, y, z, meta);

            // Prepare the network analyzer.
            NetworkAnalyzer analyzer2 = new NetworkAnalyzer();
            // Call the analysis below the teleportation pad.
            analyzer2.analyzeTeleport(world, x, y, z);
        }

        if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
            int meta = world.getBlockMetadata(x, y, z);
            if (meta < 4) {
                TilePersonalTeleportationPad tileEntity = (TilePersonalTeleportationPad) world.getTileEntity(x, y, z);
                tileEntity.beginTeleport();
            }
        }
    }

    /**
     * Called when the block is broken.
     */
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        // Get the Tile Entity.
        TilePersonalTeleportationPad tileEntity = (TilePersonalTeleportationPad) world.getTileEntity(x, y, z);

        // Check if it is not null.
        if (tileEntity != null) {

            // Stop the machine processing.
            tileEntity.stopProcessing();

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
            return 8;
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
        icon = new IIcon[7];
        // Load the outer textures.
        for (int i = 0; i < 6; i++)
            icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME + "/" + UNLOCALISEDNAME + "0" + (i + 1));
        // Load the inner texture
        icon[6] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glow");
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        // System.out.println("Sides requested!");
        if (meta == 0) {
            switch (side) {
                case 0: return icon[0];
                case 1: return icon[2];
                case 2: return icon[4];
                case 3: return icon[3];
                case 4: return icon[4];
                case 5: return icon[4];
                case 6: return icon[6];
                case 7: return icon[5];
            }
        } else if (meta == 1) {
            switch (side) {
                case 0: return icon[0];
                case 1: return icon[2];
                case 2: return icon[4];
                case 3: return icon[4];
                case 4: return icon[3];
                case 5: return icon[4];
                case 6: return icon[6];
                case 7: return icon[5];
            }
        } else if (meta == 2) {
            switch (side) {
                case 0: return icon[0];
                case 1: return icon[2];
                case 2: return icon[3];
                case 3: return icon[4];
                case 4: return icon[4];
                case 5: return icon[4];
                case 6: return icon[6];
                case 7: return icon[5];
            }
        } else if (meta == 3) {
            switch (side) {
                case 0: return icon[0];
                case 1: return icon[2];
                case 2: return icon[4];
                case 3: return icon[4];
                case 4: return icon[4];
                case 5: return icon[3];
                case 6: return icon[6];
                case 7: return icon[5];
            }
        } else if (meta == 4) {
            switch (side) {
                case 0: return icon[0];
                case 1: return icon[2];
                case 2: return icon[4];
                case 3: return icon[3];
                case 4: return icon[4];
                case 5: return icon[4];
                case 6: return icon[6];
                case 7: return icon[5];
            }
        } else if (meta == 5) {
            switch (side) {
                case 0: return icon[0];
                case 1: return icon[2];
                case 2: return icon[4];
                case 3: return icon[4];
                case 4: return icon[3];
                case 5: return icon[4];
                case 6: return icon[6];
                case 7: return icon[5];
            }
        } else if (meta == 6) {
            switch (side) {
                case 0: return icon[0];
                case 1: return icon[2];
                case 2: return icon[3];
                case 3: return icon[4];
                case 4: return icon[4];
                case 5: return icon[4];
                case 6: return icon[6];
                case 7: return icon[5];
            }
        } else if (meta == 7) {
            switch (side) {
                case 0: return icon[0];
                case 1: return icon[2];
                case 2: return icon[4];
                case 3: return icon[4];
                case 4: return icon[4];
                case 5: return icon[3];
                case 6: return icon[6];
                case 7: return icon[5];
            }
        } else if (meta == 8) {
            switch (side) {
                case 0: return icon[0];
                case 1: return icon[1];
                case 2: return icon[4];
                case 3: return icon[3];
                case 4: return icon[4];
                case 5: return icon[4];
                case 6: return icon[6];
                case 7: return icon[5];
            }
        } else if (meta == 9) {
            switch (side) {
                case 0: return icon[0];
                case 1: return icon[1];
                case 2: return icon[4];
                case 3: return icon[4];
                case 4: return icon[3];
                case 5: return icon[4];
                case 6: return icon[6];
                case 7: return icon[5];
            }
        } else if (meta == 10) {
            switch (side) {
                case 0: return icon[0];
                case 1: return icon[1];
                case 2: return icon[3];
                case 3: return icon[4];
                case 4: return icon[4];
                case 5: return icon[4];
                case 6: return icon[6];
                case 7: return icon[5];
            }
        } else if (meta == 11) {
            switch (side) {
                case 0: return icon[0];
                case 1: return icon[1];
                case 2: return icon[4];
                case 3: return icon[4];
                case 4: return icon[4];
                case 5: return icon[3];
                case 6: return icon[6];
                case 7: return icon[5];
            }
        }
        return icon[side];
    }
}
