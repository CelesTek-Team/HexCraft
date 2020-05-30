package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.util.EnergyNodeAnalyzer;
import com.celestek.hexcraft.util.HexUtils;
import com.celestek.hexcraft.util.TankAnalyzer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import static com.celestek.hexcraft.init.HexBlocks.DECORATIVE_VARIANT_WHITE;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class BlockGlowingHexoriumCoatedStone extends HexBlockMT {

    // Block ID
    public static final String ID_BLACK = "blockGlowingHexoriumCoatedStone";
    public static final String ID_WHITE = "blockGlowingHexoriumCoatedStoneWhite";

    // Used for identifying the decoration variant.
    private int variant;

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
     * @param variant The decoration variant to use.
     */
    public BlockGlowingHexoriumCoatedStone(String blockName, int variant) {
        super(Material.rock);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.variant = variant;
        this.setCreativeTab(HexCraft.tabDecorative);

        // Assign harvest levels to all metas.
        for (int i = 0; i < 16; i++)
            if (HexUtils.getBit(HexBlocks.META_DECORATIVE_REINFORCED, i))
                this.setHarvestLevel("pickaxe", 3, i);
            else
                this.setHarvestLevel("pickaxe", 2, i);

        this.setStepSound(Block.soundTypePiston);
    }

    /**
     * Returns the block hardness at a location. Args: world, x, y, z
     */
    @Override
    public float getBlockHardness(World world, int x, int y, int z) {
        // If this is a normal block, return normal hardness. Otherwise, return obsidian hardness.
        if (!HexUtils.getMetaBit(HexBlocks.META_DECORATIVE_REINFORCED, world, x, y, z))
            return 1.5F;
        else
            return 50F;
    }

    /**
     * Location sensitive version of getExplosionRestance
     */
    @Override
    public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ) {
        // If this is a normal block, return normal resistance. Otherwise, return obsidian resistance.
        if (!HexUtils.getMetaBit(HexBlocks.META_DECORATIVE_REINFORCED, world, x, y, z))
            return 30F / 5F;
        else
            return 6000F / 5F;
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
        icon = new IIcon[97];
        // Map decoration and variant.
        String id = ID_BLACK;
        if (this.variant == DECORATIVE_VARIANT_WHITE)
            id = ID_WHITE;

        // Load all the different outer icons.
        for(int i = 0; i < 48; i++) {
            if(i < 9)
                icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID_BLACK + "/" + id + "0" + (i + 1));
            else
                icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID_BLACK + "/" + id + (i + 1));
        }
        for(int i = 0; i < 48; i++) {
            if(i < 9)
                icon[i + 48] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID_BLACK + "/" + ID_BLACK + "Reinforced" + "0" + (i + 1));
            else
                icon[i + 48] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID_BLACK + "/" + ID_BLACK + "Reinforced" + (i + 1));
        }

        // Load the inner texture. Use special texture if it is a rainbow.
        if(this == HexBlocks.blockGlowingHexoriumCoatedStoneRainbow || this == HexBlocks.blockGlowingHexoriumCoatedStoneWhiteRainbow)
            icon[96] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glowRainbow");
        else
            icon[96] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glow");
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
            return icon[96];
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
                bitMatrix[0] = world.getBlock(x - 1, y, z - 1) == this;
                bitMatrix[1] = world.getBlock(x, y, z - 1) == this;
                bitMatrix[2] = world.getBlock(x + 1, y, z - 1) == this;
                bitMatrix[3] = world.getBlock(x - 1, y, z) == this;
                bitMatrix[4] = world.getBlock(x + 1, y, z) == this;
                bitMatrix[5] = world.getBlock(x - 1, y, z + 1) == this;
                bitMatrix[6] = world.getBlock(x, y, z + 1) == this;
                bitMatrix[7] = world.getBlock(x + 1, y, z + 1) == this;
            }
            else if (side == 2 || side == 3) {
                bitMatrix[0] = world.getBlock(x + (side == 2 ? 1 : -1), y + 1, z) == this;
                bitMatrix[1] = world.getBlock(x, y + 1, z) == this;
                bitMatrix[2] = world.getBlock(x + (side == 3 ? 1 : -1), y + 1, z) == this;
                bitMatrix[3] = world.getBlock(x + (side == 2 ? 1 : -1), y, z) == this;
                bitMatrix[4] = world.getBlock(x + (side == 3 ? 1 : -1), y, z) == this;
                bitMatrix[5] = world.getBlock(x + (side == 2 ? 1 : -1), y - 1, z) == this;
                bitMatrix[6] = world.getBlock(x, y - 1, z) == this;
                bitMatrix[7] = world.getBlock(x + (side == 3 ? 1 : -1), y - 1, z) == this;
            }
            else if (side == 4 || side == 5) {
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
            if (!HexUtils.getMetaBit(HexBlocks.META_DECORATIVE_REINFORCED, world, x, y, z))
                return icon[textureRefByID[idBuilder]];
            else
                return icon[textureRefByID[idBuilder] + 48];
        }
        else
            return icon[96];

    }
}
