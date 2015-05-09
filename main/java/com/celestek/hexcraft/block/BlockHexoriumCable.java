package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.renderer.HexModelRendererCable;
import com.celestek.hexcraft.util.CableAnalyzer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-14
 */

public class BlockHexoriumCable extends HexBlockModel {

    // Set default block name.
    public static String UNLOCALISEDNAME = "blockHexoriumCable";

    // Used later for texture identification.
    private String blockName;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     */
    public BlockHexoriumCable(String blockName) {
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
                blockName.contains(BlockHexoriumGenerator.UNLOCALISEDNAME) ||
                blockName.contains(BlockMatrixReconstructor.UNLOCALISEDNAME)) {

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
        boolean sides[] = HexModelRendererCable.processCableSides(world, x, y, z, this.getUnlocalizedName());

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
        boolean sides[] = HexModelRendererCable.processCableSides(world, x, y, z, this.getUnlocalizedName());

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
}
