package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.renderer.HexModelRendererCable;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.util.CableAnalyzer;
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
 * @version 0.1.0
 * @since 2015-04-14
 */

public class CableHexoriumCable extends HexBlockModel {

    // Set default block name.
    public static String UNLOCALISEDNAME = "cableHexoriumCable";

    // Used later for texture identification.
    private String blockName;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     */
    public CableHexoriumCable(String blockName) {
        super(Material.rock);

        // Load the constructor parameters.
        this.blockName = blockName;

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.hexCraftTab);
        this.setHardness(3F);
        this.setStepSound(Block.soundTypeGlass);
        this.setHarvestLevel("pickaxe", 2);
        this.setLightOpacity(0);
    }

    /**
     * Called when a block is placed by a player.
     */
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
        // Check if the code is executed on the server.
        if(!world.isRemote) {

            System.out.println("Cable placed, analyzing!");

            /* DO ANALYSIS */
            // Prepare the network analyzer.
            CableAnalyzer analyzer = new CableAnalyzer();
            // Call the analysis and wait for results.
            analyzer.analyze(world, x, y, z, "tile." + blockName, 0);
            // Push the results to all found machines.
            analyzer.push(world);
        }
    }

    /**
     * Called when a block near is changed.
     */
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        // Prepare the name string of the broken block.
        String blockName = block.getUnlocalizedName();

        // Check if the changed block belongs to the energy system.
        if (blockName.contains(UNLOCALISEDNAME) ||
                blockName.contains(MachineHexoriumGenerator.UNLOCALISEDNAME) ||
                blockName.contains(MachineMatrixReconstructor.UNLOCALISEDNAME)) {

            System.out.println("Neighbour cable or machine destroyed, analyzing!");

            /* DO ANALYSIS */
            // Prepare the network analyzer.
            CableAnalyzer analyzer = new CableAnalyzer();
            // Call the analysis and wait for results.
            analyzer.analyze(world, x, y, z, this.getUnlocalizedName(), 0);
            // Push the results to all found machines.
            analyzer.push(world);
        }
    }

    /**
     * Returns the bounding box of the wired rectangular prism to render.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
    {
        // Process the sides.
        boolean sides[] = processCableSides(world, x, y, z, this.getUnlocalizedName());

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

        // Return the bounding box.
        return AxisAlignedBB.getBoundingBox((double)x + xMin, (double)y + yMin, (double)z + zMin, (double)x + xMax, (double)y + yMax, (double)z + zMax);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        // Process the sides.
        boolean sides[] = processCableSides(world, x, y, z, this.getUnlocalizedName());

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

        // Return the bounding box.
        return AxisAlignedBB.getBoundingBox((double)x + xMin, (double)y + yMin, (double)z + zMin, (double)x + xMax, (double)y + yMax, (double)z + zMax);
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
            icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME);
        // Load the monolith texture. Use special texture if it is a rainbow.
        if(blockName.equals(UNLOCALISEDNAME + "Rainbow"))
            icon[6] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glowRainbow");
        else
            icon[6] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glow");
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

    /**
     * Processes the block sides and returns them as an array.
     * @param name Unlocalized name of the block to process.
     */
    public static boolean[] processCableSides(IBlockAccess world, int x, int y, int z, String name)
    {
        // Prepare side and meta int arrays.
        boolean sides[] = new boolean[6];
        int metas[] = new int[4];

        // Look for machines.
        if (world.getBlock(x - 1, y, z).getUnlocalizedName().contains(MachineMatrixReconstructor.UNLOCALISEDNAME) ||
                world.getBlock(x - 1, y, z).getUnlocalizedName().contains(MachineHexoriumGenerator.UNLOCALISEDNAME))
            metas[0] = world.getBlockMetadata(x - 1, y, z);
        else
            metas[0] = -1;
        if (world.getBlock(x + 1, y, z).getUnlocalizedName().contains(MachineMatrixReconstructor.UNLOCALISEDNAME) ||
                world.getBlock(x + 1, y, z).getUnlocalizedName().contains(MachineHexoriumGenerator.UNLOCALISEDNAME))
            metas[1] = world.getBlockMetadata(x + 1, y, z);
        else
            metas[1] = -1;
        if (world.getBlock(x, y, z - 1).getUnlocalizedName().contains(MachineMatrixReconstructor.UNLOCALISEDNAME) ||
                world.getBlock(x, y, z - 1).getUnlocalizedName().contains(MachineHexoriumGenerator.UNLOCALISEDNAME))
            metas[2] = world.getBlockMetadata(x, y, z - 1);
        else
            metas[2] = -1;
        if (world.getBlock(x, y, z + 1).getUnlocalizedName().contains(MachineMatrixReconstructor.UNLOCALISEDNAME) ||
                world.getBlock(x, y, z + 1).getUnlocalizedName().contains(MachineHexoriumGenerator.UNLOCALISEDNAME))
            metas[3] = world.getBlockMetadata(x, y, z + 1);
        else
            metas[3] = -1;

        for(int i = 0; i < 4; i++) {
            if (metas[i] >= 4 && metas[i] < 8)
                metas[i] = metas[i] - 4;
            else if (metas[i] >= 8)
                metas[i] = metas[i] - 8;
        }

        // Count Sides
        if (name.equals(HexBlocks.cableHexoriumCableRainbow.getUnlocalizedName()) && world.getBlock(x, y - 1, z).getUnlocalizedName().contains(CableHexoriumCable.UNLOCALISEDNAME) ||
                name.equals(world.getBlock(x, y - 1, z).getUnlocalizedName()) ||
                world.getBlock(x, y - 1, z).getUnlocalizedName().equals(HexBlocks.cableHexoriumCableRainbow.getUnlocalizedName()))
            sides[0] = true;
        if (name.equals(HexBlocks.cableHexoriumCableRainbow.getUnlocalizedName()) && world.getBlock(x, y + 1, z).getUnlocalizedName().contains(CableHexoriumCable.UNLOCALISEDNAME) ||
                name.equals(world.getBlock(x, y + 1, z).getUnlocalizedName()) ||
                world.getBlock(x, y + 1, z).getUnlocalizedName().equals(HexBlocks.cableHexoriumCableRainbow.getUnlocalizedName()))
            sides[1] = true;
        if (name.equals(HexBlocks.cableHexoriumCableRainbow.getUnlocalizedName()) && world.getBlock(x - 1, y, z).getUnlocalizedName().contains(CableHexoriumCable.UNLOCALISEDNAME) ||
                name.equals(world.getBlock(x - 1, y, z).getUnlocalizedName()) ||
                world.getBlock(x - 1, y, z).getUnlocalizedName().equals(HexBlocks.cableHexoriumCableRainbow.getUnlocalizedName()) ||
                metas[0] == 3)
            sides[2] = true;
        if (name.equals(HexBlocks.cableHexoriumCableRainbow.getUnlocalizedName()) && world.getBlock(x + 1, y, z).getUnlocalizedName().contains(CableHexoriumCable.UNLOCALISEDNAME) ||
                name.equals(world.getBlock(x + 1, y, z).getUnlocalizedName()) ||
                world.getBlock(x + 1, y, z).getUnlocalizedName().equals(HexBlocks.cableHexoriumCableRainbow.getUnlocalizedName()) ||
                metas[1] == 1)
            sides[3] = true;
        if (name.equals(HexBlocks.cableHexoriumCableRainbow.getUnlocalizedName()) && world.getBlock(x, y, z - 1).getUnlocalizedName().contains(CableHexoriumCable.UNLOCALISEDNAME) ||
                name.equals(world.getBlock(x, y, z - 1).getUnlocalizedName()) ||
                world.getBlock(x, y, z - 1).getUnlocalizedName().equals(HexBlocks.cableHexoriumCableRainbow.getUnlocalizedName()) ||
                metas[2] == 0)
            sides[4] = true;
        if (name.equals(HexBlocks.cableHexoriumCableRainbow.getUnlocalizedName()) && world.getBlock(x, y, z + 1).getUnlocalizedName().contains(CableHexoriumCable.UNLOCALISEDNAME) ||
                name.equals(world.getBlock(x, y, z + 1).getUnlocalizedName()) ||
                world.getBlock(x, y, z + 1).getUnlocalizedName().equals(HexBlocks.cableHexoriumCableRainbow.getUnlocalizedName()) ||
                metas[3] == 2)
            sides[5] = true;

        return sides;
    }
}
