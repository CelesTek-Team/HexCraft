package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.renderer.HexModelRendererCable;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.util.NetworkAnalyzer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.6.1
 * @since 2015-04-14
 */

public class BlockHexoriumCable extends HexBlockModel {

    // Set default block name.
    public static String UNLOCALISEDNAME = "blockHexoriumCable";

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     */
    public BlockHexoriumCable(String blockName) {
        super(Material.glass);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.tabMachines);

        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(1.5F);
        this.setResistance(10F);

        this.setStepSound(Block.soundTypeGlass);
        this.setLightOpacity(0);
    }

    /**
     * Called when a block is placed by a player.
     */
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
        // Check if the code is executed on the server.
        if(!world.isRemote) {

            if (HexConfig.cfgGeneralNetworkDebug)
                System.out.println("Cable placed, analyzing!");

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
                block == HexBlocks.blockHexoriumGenerator ||
                block == HexBlocks.blockHexoriumFurnace ||
                block == HexBlocks.blockCrystalSeparator ||
                block == HexBlocks.blockMatrixReconstructor ||
                block == HexBlocks.blockPersonalTeleportationPad) {

            if (HexConfig.cfgGeneralNetworkDebug)
                System.out.println("Neighbour cable or machine destroyed, analyzing!");

            /* DO ANALYSIS */
            // Prepare the network analyzer.
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            // Call the analysis.
            analyzer.analyzeCable(world, x, y, z, this);
        }
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
    {
        // Process the sides.
        boolean sides[] = HexModelRendererCable.processCableSides(world, x, y, z, this);

        // Prepare the default values of the bounding box.
        float xMin = HexModelRendererCable.cMin;
        float xMax = HexModelRendererCable.cMax;
        float yMin = HexModelRendererCable.cMin;
        float yMax = HexModelRendererCable.cMax;
        float zMin = HexModelRendererCable.cMin;
        float zMax = HexModelRendererCable.cMax;

        // Depending on sides, increase the box size.
        if(sides[0])
            yMin = 0;
        if(sides[1])
            yMax = 1;
        if(sides[2])
            xMin = 0;
        if(sides[3])
            xMax = 1;
        if(sides[4])
            zMin = 0;
        if(sides[5])
            zMax = 1;

        // Set the block bounds, used for client-side rendering.
        setBlockBounds(xMin, yMin, zMin, xMax, yMax, zMax);
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
        icon = new IIcon[2];
        // Load the outer texture.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME);
        // Load the monolith texture. Use special texture if it is a rainbow.
        if(this == HexBlocks.blockHexoriumCableRainbow)
            icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glowRainbow");
        else
            icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glow");
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
        else
            return icon[1];
    }
}
