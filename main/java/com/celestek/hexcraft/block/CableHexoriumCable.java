package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexBlocks;
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
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

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
        super(Material.glass);

        // Load the constructor parameters.
        this.blockName = blockName;

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.hexCraftTab);
        this.setHardness(3F);
        this.setStepSound(Block.soundTypeGlass);
    }

    /**
     * Called when a block is placed using its ItemBlock.
     */
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
        if(!world.isRemote) {
            System.out.println("Cable placed, analyzing!");
            /* DO ANALYSIS */
            CableAnalyzer analyzer = new CableAnalyzer();
            analyzer.analyze(world, x, y, z, "tile." + blockName, 0);
            analyzer.push();
        }
    }

    /**
     * Called when a block near is changed.
     */
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        String blockName = block.getUnlocalizedName();
        if (blockName.contains(UNLOCALISEDNAME) ||
            blockName.contains(MachineMatrixReconstructor.UNLOCALISEDNAME)) {
            System.out.println("Neighbour cable or machine destroyed, analyzing!");
            /* DO ANALYSIS */
            CableAnalyzer analyzer = new CableAnalyzer();
            analyzer.analyze(world, x, y, z, this.getUnlocalizedName(), 0);
            analyzer.push();
        }
    }

    /*
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        
        float xMin = 0;
        float xMax = 1;
        float yMin = 0;
        float yMax = 1;
        float zMin = 0;
        float zMax = 1;

        boolean sides[] = processCableSides(world, x, y, z, this.getUnlocalizedName());
        boolean straight = false;

        if (sides[0] && sides[1] && !sides[2] && !sides[3] && !sides[4] && !sides[5])
            straight = true;
        else if (!sides[0] && !sides[1] && sides[2] && sides[3] && !sides[4] && !sides[5])
            straight = true;
        else if (!sides[0] && !sides[1] && !sides[2] && !sides[3] && sides[4] && sides[5])
            straight = true;

        System.out.println("States: " + sides[0] + sides[1] + sides[2] + sides[3] + sides[4] + sides[5]);

        if (straight) {

            if (sides[0] && sides[1] && !sides[2] && !sides[3] && !sides[4] && !sides[5]) {
                xMin = 0.4F;
                xMax = 0.6F;
                zMin = 0.4134F;
                zMax = 0.5866F;
            } else if (!sides[0] && !sides[1] && sides[2] && sides[3] && !sides[4] && !sides[5]) {
                yMin = 0.4F;
                yMax = 0.6F;
                zMin = 0.4134F;
                zMax = 0.5866F;
            } else if (!sides[0] && !sides[1] && !sides[2] && !sides[3] && sides[4] && sides[5]) {
                yMin = 0.4F;
                yMax = 0.6F;
                xMin = 0.4134F;
                xMax = 0.5866F;
            }
        } else {
            xMin = 0.35F;
            xMax = 0.65F;
            yMin = 0.35F;
            yMax = 0.65F;
            zMin = 0.35F;
            zMax = 0.65F;

            if(sides[0]) {
                yMin = 0;
            }
            if(sides[1]) {
                yMax = 1;
            }
            if(sides[2]) {
                xMin = 0;
            }
            if(sides[3]) {
                xMax = 1;
            }
            if(sides[4]) {
                zMin = 0;
            }
            if(sides[5]) {
                zMax = 1;
            }

        }
        this.setBlockBounds(xMin, yMin, zMin, xMax, yMax, zMax);
    }

    public static boolean[] processCableSides(IBlockAccess world, int x, int y, int z, String name)
    {
        boolean sides[] = new boolean[6];
        int metas[] = new int[4];
        boolean straight = false;

        // Look for machines.
        if (world.getBlock(x - 1, y, z).getUnlocalizedName().contains(MachineMatrixReconstructor.UNLOCALISEDNAME))
            metas[0] = world.getBlockMetadata(x - 1, y, z);
        else
            metas[0] = -1;
        if (world.getBlock(x + 1, y, z).getUnlocalizedName().contains(MachineMatrixReconstructor.UNLOCALISEDNAME))
            metas[1] = world.getBlockMetadata(x + 1, y, z);
        else
            metas[1] = -1;
        if (world.getBlock(x, y, z - 1).getUnlocalizedName().contains(MachineMatrixReconstructor.UNLOCALISEDNAME))
            metas[2] = world.getBlockMetadata(x, y, z - 1);
        else
            metas[2] = -1;
        if (world.getBlock(x, y, z + 1).getUnlocalizedName().contains(MachineMatrixReconstructor.UNLOCALISEDNAME))
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
    */

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
