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

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.7.0
 */

public class BlockHexoriumLampInv extends HexBlockMT {

    // Block ID
    public static final String ID = "blockHexoriumLampInv";

    // Meta Bits
    public static final int META_STATE = 0;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     */
    public BlockHexoriumLampInv(String blockName) {
        super(Material.glass);

        // Set all block parameters.
        this.setBlockName(blockName);
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
                    return CLApi.makeRGBLightValue(HexColors.colorRedR, HexColors.colorRedG, HexColors.colorRedB);
                else if (this == HexBlocks.blockHexoriumLampInvOrange)
                    return CLApi.makeRGBLightValue(HexColors.colorOrangeR, HexColors.colorOrangeG, HexColors.colorOrangeB);
                else if (this == HexBlocks.blockHexoriumLampInvYellow)
                    return CLApi.makeRGBLightValue(HexColors.colorYellowR, HexColors.colorYellowG, HexColors.colorYellowB);
                else if (this == HexBlocks.blockHexoriumLampInvLime)
                    return CLApi.makeRGBLightValue(HexColors.colorLimeR, HexColors.colorLimeG, HexColors.colorLimeB);
                else if (this == HexBlocks.blockHexoriumLampInvGreen)
                    return CLApi.makeRGBLightValue(HexColors.colorGreenR, HexColors.colorGreenG, HexColors.colorGreenB);
                else if (this == HexBlocks.blockHexoriumLampInvTurquoise)
                    return CLApi.makeRGBLightValue(HexColors.colorTurquoiseR, HexColors.colorTurquoiseG, HexColors.colorTurquoiseB);
                else if (this == HexBlocks.blockHexoriumLampInvCyan)
                    return CLApi.makeRGBLightValue(HexColors.colorCyanR, HexColors.colorCyanG, HexColors.colorCyanB);
                else if (this == HexBlocks.blockHexoriumLampInvSkyBlue)
                    return CLApi.makeRGBLightValue(HexColors.colorSkyBlueR, HexColors.colorSkyBlueG, HexColors.colorSkyBlueB);
                else if (this == HexBlocks.blockHexoriumLampInvBlue)
                    return CLApi.makeRGBLightValue(HexColors.colorBlueR, HexColors.colorBlueG, HexColors.colorBlueB);
                else if (this == HexBlocks.blockHexoriumLampInvPurple)
                    return CLApi.makeRGBLightValue(HexColors.colorPurpleR, HexColors.colorPurpleG, HexColors.colorPurpleB);
                else if (this == HexBlocks.blockHexoriumLampInvMagenta)
                    return CLApi.makeRGBLightValue(HexColors.colorMagentaR, HexColors.colorMagentaG, HexColors.colorMagentaB);
                else if (this == HexBlocks.blockHexoriumLampInvPink)
                    return CLApi.makeRGBLightValue(HexColors.colorPinkR, HexColors.colorPinkG, HexColors.colorPinkB);
                else
                    return CLApi.makeRGBLightValue(HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB);
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
        // Load the outer texture.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + BlockHexoriumLamp.ID);
        // Load the inner texture. Use special texture if it is a rainbow.
        if(this == HexBlocks.blockHexoriumLampInvRainbow)
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
