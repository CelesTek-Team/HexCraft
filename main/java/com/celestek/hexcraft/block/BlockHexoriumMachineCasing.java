package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexBlocks;
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
 * @version 0.7.0
 */

public class BlockHexoriumMachineCasing extends HexBlockMT implements IBlockHexNode {

    // Block ID
    public static final String ID = "blockHexoriumMachineCasing";

    // Prepare an array of all possible situations.
    private static final int[] textureRefByID = {
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
    public BlockHexoriumMachineCasing(String blockName) {
        super(Material.iron);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.tabDecorative);

        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(1.5F);
        this.setResistance(10F);

        this.setStepSound(Block.soundTypeMetal);
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
        icon = new IIcon[49];

        // Load all the different outer icons.
        for(int i = 0; i < 48; i++) {
            if(i < 9)
                icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "0" + (i + 1));
            else
                icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + (i + 1));
        }

        // Load the inner texture. Use special texture if it is a rainbow.
        if(this == HexBlocks.blockHexoriumMachineCasingRainbow)
            icon[48] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glowRainbow");
        else
            icon[48] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glow");
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
            return icon[48];
    }


    /**
     * Retrieves the icons and sets the connected texture.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {

        if (side < 6) {
            // Prepare a new 8-bit array.
            boolean[] bitMatrix = new boolean[8];

            // Analyze neighbouring blocks and set bits.
            if (side == 0 || side == 1) {
                bitMatrix[0] = world.getBlock(x - 1, y, z - 1) instanceof BlockHexoriumMachineCasing;
                bitMatrix[1] = world.getBlock(x, y, z - 1) instanceof BlockHexoriumMachineCasing;
                bitMatrix[2] = world.getBlock(x + 1, y, z - 1) instanceof BlockHexoriumMachineCasing;
                bitMatrix[3] = world.getBlock(x - 1, y, z) instanceof BlockHexoriumMachineCasing;
                bitMatrix[4] = world.getBlock(x + 1, y, z) instanceof BlockHexoriumMachineCasing;
                bitMatrix[5] = world.getBlock(x - 1, y, z + 1) instanceof BlockHexoriumMachineCasing;
                bitMatrix[6] = world.getBlock(x, y, z + 1) instanceof BlockHexoriumMachineCasing;
                bitMatrix[7] = world.getBlock(x + 1, y, z + 1) instanceof BlockHexoriumMachineCasing;
            }
            else if (side == 2 || side == 3) {
                bitMatrix[0] = world.getBlock(x + (side == 2 ? 1 : -1), y + 1, z) instanceof BlockHexoriumMachineCasing;
                bitMatrix[1] = world.getBlock(x, y + 1, z) instanceof BlockHexoriumMachineCasing;
                bitMatrix[2] = world.getBlock(x + (side == 3 ? 1 : -1), y + 1, z) instanceof BlockHexoriumMachineCasing;
                bitMatrix[3] = world.getBlock(x + (side == 2 ? 1 : -1), y, z) instanceof BlockHexoriumMachineCasing;
                bitMatrix[4] = world.getBlock(x + (side == 3 ? 1 : -1), y, z) instanceof BlockHexoriumMachineCasing;
                bitMatrix[5] = world.getBlock(x + (side == 2 ? 1 : -1), y - 1, z) instanceof BlockHexoriumMachineCasing;
                bitMatrix[6] = world.getBlock(x, y - 1, z) instanceof BlockHexoriumMachineCasing;
                bitMatrix[7] = world.getBlock(x + (side == 3 ? 1 : -1), y - 1, z) instanceof BlockHexoriumMachineCasing;
            }
            else if (side == 4 || side == 5) {
                bitMatrix[0] = world.getBlock(x, y + 1, z + (side == 5 ? 1 : -1)) instanceof BlockHexoriumMachineCasing;
                bitMatrix[1] = world.getBlock(x, y + 1, z) instanceof BlockHexoriumMachineCasing;
                bitMatrix[2] = world.getBlock(x, y + 1, z + (side == 4 ? 1 : -1)) instanceof BlockHexoriumMachineCasing;
                bitMatrix[3] = world.getBlock(x, y, z + (side == 5 ? 1 : -1)) instanceof BlockHexoriumMachineCasing;
                bitMatrix[4] = world.getBlock(x, y, z + (side == 4 ? 1 : -1)) instanceof BlockHexoriumMachineCasing;
                bitMatrix[5] = world.getBlock(x, y - 1, z + (side == 5 ? 1 : -1)) instanceof BlockHexoriumMachineCasing;
                bitMatrix[6] = world.getBlock(x, y - 1, z) instanceof BlockHexoriumMachineCasing;
                bitMatrix[7] = world.getBlock(x, y - 1, z + (side == 4 ? 1 : -1)) instanceof BlockHexoriumMachineCasing;
            }

            // Convert the bit array to a dec number.
            int idBuilder = 0;
            for (int i = 0; i < 8; i++)
                idBuilder = idBuilder + (bitMatrix[i] ? (i == 0 ? 1 : (i == 1 ? 2 : (i == 2 ? 4 : (i == 3 ? 8 : (i == 4 ? 16 : (i == 5 ? 32 : (i == 6 ? 64 : 128))))))) : 0);

            // Return the according texture.
            return icon[textureRefByID[idBuilder]];
        }
        else
            return icon[48];

    }
}
