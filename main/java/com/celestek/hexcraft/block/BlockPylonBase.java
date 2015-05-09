package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-14
 */

public class BlockPylonBase extends Block {

    // Set default block name.
    public static String UNLOCALISEDNAME = "blockPylonBase";

    // Prepare an array of all possible situations.
    public static int[] textureRefByID = {
             0,  0,  6,  6,  0,  0,  6,  6,  3,  3, 19, 15,  3,  3, 19, 15,
             1,  1, 18, 18,  1,  1, 13, 13,  2,  2, 23, 31,  2,  2, 27, 14,
             0,  0,  6,  6,  0,  0,  6,  6,  3,  3, 19, 15,  3,  3, 19, 15,
             1,  1, 18, 18,  1,  1, 13, 13,  2,  2, 23, 31,  2,  2, 27, 14,
             4,  4,  5,  5,  4,  4,  5,  5, 17, 17, 22, 26, 17, 17, 22, 26,
            16, 16, 20, 20, 16, 16, 28, 28, 21, 21, 46, 42, 21, 21, 43, 38,
             4,  4,  5,  5,  4,  4,  5,  5,  9,  9, 30, 12,  9,  9, 30, 12,
            16, 16, 20, 20, 16, 16, 28, 28, 25, 25, 45, 37, 25, 25, 40, 32,
             0,  0,  6,  6,  0,  0,  6,  6,  3,  3, 19, 15,  3,  3, 19, 15,
             1,  1, 18, 18,  1,  1, 13, 13,  2,  2, 23, 31,  2,  2, 27, 14,
             0,  0,  6,  6,  0,  0,  6,  6,  3,  3, 19, 15,  3,  3, 19, 15,
             1,  1, 18, 18,  1,  1, 13, 13,  2,  2, 23, 31,  2,  2, 27, 14,
             4,  4,  5,  5,  4,  4,  5,  5, 17, 17, 22, 26, 17, 17, 22, 26,
             7,  7, 24, 24,  7,  7, 10, 10, 29, 29, 44, 41, 29, 29, 39, 33,
             4,  4,  5,  5,  4,  4,  5,  5,  9,  9, 30, 12,  9,  9, 30, 12,
             7,  7, 24, 24,  7,  7, 10, 10,  8,  8, 36, 35,  8,  8, 34, 11
    };

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block.
     */
    public BlockPylonBase(String blockName) {
        super(Material.glass);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.hexCraftTab);
        this.setHardness(1.5F);
        this.setStepSound(Block.soundTypeGlass);
        this.setHarvestLevel("pickaxe", 2);
        this.setLightOpacity(0);
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
        icon = new IIcon[48];

        // Load all the different icons.
        for(int i = 0; i < 48; i++) {
            if(i < 9)
                icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME + "/" + UNLOCALISEDNAME + "0" + (i + 1));
            else
                icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME + "/" + UNLOCALISEDNAME + (i + 1));
        }
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int i, int meta) {
        // Retrieve icon based on side.
        return icon[0];
    }


    /**
     * Retrieves the icons and sets the connected texture.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
        // Prepare a new 8-bit array.
        boolean[] bitMatrix = new boolean[8];

        // Analyze neighbouring blocks and set bits.
        if (side == 0 || side == 1) {
            bitMatrix[0] = world.getBlock(x - 1, y, z - 1) == this;
            bitMatrix[1] = world.getBlock(x, y, z - 1) == this;
            bitMatrix[2] = world.getBlock(x + 1, y, z - 1) == this;
            bitMatrix[3] = world.getBlock(x - 1, y, z) == this;
            bitMatrix[4] = world.getBlock(x + 1, y, z) == this;
            bitMatrix[5] = world.getBlock(x - 1, y, z + 1) == this;
            bitMatrix[6] = world.getBlock(x, y, z + 1) == this;
            bitMatrix[7] = world.getBlock(x + 1, y, z + 1) == this;
        } else if (side == 2 || side == 3) {
            bitMatrix[0] = world.getBlock(x + (side == 2 ? 1 : -1), y + 1, z) == this;
            bitMatrix[1] = world.getBlock(x, y + 1, z) == this;
            bitMatrix[2] = world.getBlock(x + (side == 3 ? 1 : -1), y + 1, z) == this;
            bitMatrix[3] = world.getBlock(x + (side == 2 ? 1 : -1), y, z) == this;
            bitMatrix[4] = world.getBlock(x + (side == 3 ? 1 : -1), y, z) == this;
            bitMatrix[5] = world.getBlock(x + (side == 2 ? 1 : -1), y - 1, z) == this;
            bitMatrix[6] = world.getBlock(x, y - 1, z) == this;
            bitMatrix[7] = world.getBlock(x + (side == 3 ? 1 : -1), y - 1, z) == this;
        } else if (side == 4 || side == 5) {
            bitMatrix[0] = world.getBlock(x, y + 1, z + (side == 5 ? 1 : -1)) == this;
            bitMatrix[1] = world.getBlock(x, y + 1, z) == this;
            bitMatrix[2] = world.getBlock(x, y + 1, z + (side == 4 ? 1 : -1)) == this;
            bitMatrix[3] = world.getBlock(x, y, z + (side == 5 ? 1 : -1)) == this;
            bitMatrix[4] = world.getBlock(x, y, z + (side == 4 ? 1 : -1)) == this;
            bitMatrix[5] = world.getBlock(x, y - 1, z + (side == 5 ? 1 : -1)) == this;
            bitMatrix[6] = world.getBlock(x, y - 1, z) == this;
            bitMatrix[7] = world.getBlock(x, y - 1, z + (side == 4 ? 1 : -1)) == this;
        }

        // Convert the bit array to a dec number.
        int idBuilder = 0;
        for (int i = 0; i < 8; i++)
            idBuilder = idBuilder + (bitMatrix[i] ? (i == 0 ? 1 : (i == 1 ? 2 : (i == 2 ? 4 : (i == 3 ? 8 : (i == 4 ? 16 : (i == 5 ? 32 : (i == 6 ? 64 : 128))))))) : 0);

        // Return the according texture.
        return icon[textureRefByID[idBuilder]];
    }

    /**
     * Hide the touching sides.
     */
    @Override
    @SideOnly(Side.CLIENT)
     public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side)
    {
        return world.getBlock(x, y, z) != this;
    }

    /**
     * Force rendering on second pass.
     */
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
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
     * Makes the block NOT interact with AO.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isBlockNormalCube()
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
     * Forces the block not to conduct Redstone.
     */
    @Override
    public boolean shouldCheckWeakPower(IBlockAccess world, int x, int y, int z, int side)
    {
        return false;
    }
}
