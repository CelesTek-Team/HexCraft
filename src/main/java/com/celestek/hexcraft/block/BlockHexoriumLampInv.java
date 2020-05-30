package com.celestek.hexcraft.block;

import coloredlightscore.src.api.CLApi;
import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.util.HexColors;
import com.celestek.hexcraft.util.HexUtils;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import static com.celestek.hexcraft.init.HexBlocks.DECORATIVE_VARIANT_WHITE;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class BlockHexoriumLampInv extends HexBlockMT {

    // Block ID
    public static final String ID_BLACK = "blockHexoriumLampInv";
    public static final String ID_WHITE = "blockHexoriumLampInvWhite";

    // Meta Bits
    public static final int META_STATE = 0;

    // Used for identifying the decoration variant.
    private int variant;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     * @param variant The decoration variant to use.
     */
    public BlockHexoriumLampInv(String blockName, int variant) {
        super(Material.glass);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.variant = variant;
        this.setCreativeTab(HexCraft.tabDecorative);

        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(1.5F);
        this.setResistance(10F);

        this.setStepSound(Block.soundTypeGlass);
    }

    /**
     * Called whenever the block is added into the world.
     */
    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        processMeta(world, x, y, z);
    }

    /**
     * Called when a block near is changed.
     */
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        processMeta(world, x, y, z);
    }

    /**
     * Gets the light value according to meta.
     */
    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        if (!HexUtils.getMetaBit(META_STATE, world, x, y, z))
            if (Loader.isModLoaded("coloredlightscore"))
                if (this == HexBlocks.blockHexoriumLampInvRed)
                    return CLApi.makeRGBLightValue(HexColors.COLOR_RED_R, HexColors.COLOR_RED_G, HexColors.COLOR_RED_B);
                else if (this == HexBlocks.blockHexoriumLampInvOrange)
                    return CLApi.makeRGBLightValue(HexColors.COLOR_ORANGE_R, HexColors.COLOR_ORANGE_G, HexColors.COLOR_ORANGE_B);
                else if (this == HexBlocks.blockHexoriumLampInvYellow)
                    return CLApi.makeRGBLightValue(HexColors.COLOR_YELLOW_R, HexColors.COLOR_YELLOW_G, HexColors.COLOR_YELLOW_B);
                else if (this == HexBlocks.blockHexoriumLampInvLime)
                    return CLApi.makeRGBLightValue(HexColors.COLOR_LIME_R, HexColors.COLOR_LIME_G, HexColors.COLOR_LIME_B);
                else if (this == HexBlocks.blockHexoriumLampInvGreen)
                    return CLApi.makeRGBLightValue(HexColors.COLOR_GREEN_R, HexColors.COLOR_GREEN_G, HexColors.COLOR_GREEN_B);
                else if (this == HexBlocks.blockHexoriumLampInvTurquoise)
                    return CLApi.makeRGBLightValue(HexColors.COLOR_TORQUOISE_R, HexColors.COLOR_TORQUOISE_G, HexColors.COLOR_TORQUOISE_B);
                else if (this == HexBlocks.blockHexoriumLampInvCyan)
                    return CLApi.makeRGBLightValue(HexColors.COLOR_CYAN_R, HexColors.COLOR_CYAN_G, HexColors.COLOR_CYAN_B);
                else if (this == HexBlocks.blockHexoriumLampInvSkyBlue)
                    return CLApi.makeRGBLightValue(HexColors.COLOR_SKY_BLUE_R, HexColors.COLOR_SKY_BLUE_G, HexColors.COLOR_SKY_BLUE_B);
                else if (this == HexBlocks.blockHexoriumLampInvBlue)
                    return CLApi.makeRGBLightValue(HexColors.COLOR_BLUE_R, HexColors.COLOR_BLUE_G, HexColors.COLOR_BLUE_B);
                else if (this == HexBlocks.blockHexoriumLampInvPurple)
                    return CLApi.makeRGBLightValue(HexColors.COLOR_PURPLE_R, HexColors.COLOR_PURPLE_G, HexColors.COLOR_PURPLE_B);
                else if (this == HexBlocks.blockHexoriumLampInvMagenta)
                    return CLApi.makeRGBLightValue(HexColors.COLOR_MAGENTA_R, HexColors.COLOR_MAGENTA_G, HexColors.COLOR_MAGENTA_B);
                else if (this == HexBlocks.blockHexoriumLampInvPink)
                    return CLApi.makeRGBLightValue(HexColors.COLOR_PINK_R, HexColors.COLOR_PINK_G, HexColors.COLOR_PINK_B);
                else
                    return CLApi.makeRGBLightValue(HexColors.COLOR_WHITE_R, HexColors.COLOR_WHITE_G, HexColors.COLOR_WHITE_B);
            else
                return 15;
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
        icon = new IIcon[2];
        // Map decoration and variant.
        String id = BlockHexoriumLamp.ID_BLACK;
        if (this.variant == DECORATIVE_VARIANT_WHITE)
            id = BlockHexoriumLamp.ID_WHITE;
        // Load the outer texture.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + id);
        // Load the inner texture. Use special texture if it is a rainbow.
        if(this == HexBlocks.blockHexoriumLampInvRainbow || this == HexBlocks.blockHexoriumLampInvWhiteRainbow)
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

    /**
     * Processes the block meta to adjust light of the lamp.
     */
    private void processMeta(World world, int x, int y, int z) {
        if (!world.isRemote) {
            boolean state = HexUtils.getMetaBit(META_STATE, world, x, y, z);
            boolean powered = world.isBlockIndirectlyGettingPowered(x, y, z);
            // Set meta according to power.
            if (!state && powered)
                HexUtils.setMetaBit(META_STATE, true, HexUtils.META_NOTIFY_UPDATE, world, x, y, z);
            else if (state && !powered)
                HexUtils.setMetaBit(META_STATE, false, HexUtils.META_NOTIFY_UPDATE, world, x, y, z);
        }
    }
}
