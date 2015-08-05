package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.util.NetworkAnalyzer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.6.0
 * @since 2015-04-14
 */

public class BlockPylonBase extends Block {

    // Set default block name.
    public static String UNLOCALISEDNAME = "blockPylonBase";

    // Used for identifying the type of base.
    private boolean type;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block.
     */
    public BlockPylonBase(String blockName, boolean type) {
        super(Material.iron);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.type = type;
        this.setCreativeTab(HexCraft.tabMachines);

        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(5F);
        this.setResistance(10F);

        this.setStepSound(Block.soundTypeMetal);
    }

    /**
     * Called when a block is placed by a player.
     */
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
        // Get the direction of the block.
        int direction;
        if (entity.rotationPitch > 60.0F)
            // If player is looking up.
            direction = 1;
        else if (entity.rotationPitch < -60.0F)
            // If player is looking down.
            direction = 0;
        else {
            direction = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
            // If player is looking towards NSWE.
            if (direction == 0)
                direction = 2;
            else if (direction == 1)
                direction = 5;
            else if (direction == 2)
                direction = 3;
            else if (direction == 3)
                direction = 4;
        }

        // Set the block's meta data according to direction.
        world.setBlockMetadataWithNotify(x, y, z, direction, 3);


        // Check if the code is executed on the server.
        if(!world.isRemote) {

            if (HexConfig.cfgGeneralNetworkDebug)
                System.out.println("Base placed, analyzing!");

            /* DO ANALYSIS */
            // Prepare the network analyzer.
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            // Call the analysis.
            analyzer.analyzeCable(world, x, y, z, this);
        }
    }

    /**
     * Called when a block near is changed.
     */
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {

        // Check if the changed block belongs to the energy system.
        if (block instanceof BlockHexoriumCable ||
                block instanceof BlockPylonBase ||
                block == HexBlocks.blockEnergyPylon ||
                block == HexBlocks.blockHexoriumGenerator ||
                block == HexBlocks.blockHexoriumFurnace ||
                block == HexBlocks.blockCrystalSeparator ||
                block == HexBlocks.blockMatrixReconstructor) {

            if (HexConfig.cfgGeneralNetworkDebug)
                System.out.println("Neighbour cable or machine destroyed, analyzing!");

            /* DO ANALYSIS */
            // Prepare the network analyzer.
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            // Call the analysis.
            analyzer.analyzeCable(world, x, y, z, this);
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
        icon = new IIcon[2];

        // Load all the different icons.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME + "A");
        icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME + "B");
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        int i0;
        int i1;

        // Set different icons depending on type of base.
        if (!type) {
            i0 = 1;
            i1 = 0;
        }
        else {
            i0 = 0;
            i1 = 1;
        }

        // Return only one icon depending on orientation.
        if (meta == side)
            return icon[i0];
        else
            return icon[i1];
    }
}
