package com.celestek.hexcraft.client;

import com.celestek.hexcraft.HexCommonProxy;
import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.BlockEngineeringBlock;
import com.celestek.hexcraft.block.BlockEnergizedHexorium;
import com.celestek.hexcraft.block.BlockHexoriumNetherOre;
import com.celestek.hexcraft.block.BlockHexoriumOre;
import com.celestek.hexcraft.client.renderer.HexBlockRenderer;
import com.celestek.hexcraft.client.renderer.HexColors;
import com.celestek.hexcraft.init.HexBlocks;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-14
 */

public class HexClientProxy extends HexCommonProxy {

    /* Minecraft's internal ID of a certain block. Length controlled in HexBlocks. */
    public static int renderID[] = new int[HexBlocks.countBlocks];

    /* Render pass for every block. Length controlled in HexBlocks. */
    public static int renderPass[] = new int[HexBlocks.countBlocks];

    /**
     * Handles preInit.
     */
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);

        /* Set up custom rendering. */
        setCustomRenderers();
    }

    /**
     * Handles init.
     */
    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
    }

    /**
     * Handles postInit.
     */
    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }

    /**
     * Registers renderers for all block.
     */
    public static void setCustomRenderers()
    {
        /* Prepare HexCraft's block ID counter. */
        HexCraft.idCounter = 0;

        /* Hexorium Nether Ore */
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockHexoriumNetherOre.UNLOCALISEDNAME + "Red",
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockHexoriumNetherOre.UNLOCALISEDNAME + "Green",
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockHexoriumNetherOre.UNLOCALISEDNAME + "Blue",
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockHexoriumNetherOre.UNLOCALISEDNAME + "White",
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockHexoriumNetherOre.UNLOCALISEDNAME + "Black",
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));

        /* Hexorium Ore */
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockHexoriumOre.UNLOCALISEDNAME + "Red",
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockHexoriumOre.UNLOCALISEDNAME + "Green",
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockHexoriumOre.UNLOCALISEDNAME + "Blue",
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockHexoriumOre.UNLOCALISEDNAME + "White",
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockHexoriumOre.UNLOCALISEDNAME + "Black",
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));

        /* Energized Hexorium */
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEnergizedHexorium.UNLOCALISEDNAME + "Red",
                HexColors.brightnessBright, HexColors.colorRedR, HexColors.colorRedG, HexColors.colorRedB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEnergizedHexorium.UNLOCALISEDNAME + "Orange",
                HexColors.brightnessBright, HexColors.colorOrangeR, HexColors.colorOrangeG, HexColors.colorOrangeB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEnergizedHexorium.UNLOCALISEDNAME + "Yellow",
                HexColors.brightnessBright, HexColors.colorYellowR, HexColors.colorYellowG, HexColors.colorYellowB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEnergizedHexorium.UNLOCALISEDNAME + "Lime",
                HexColors.brightnessBright, HexColors.colorLimeR, HexColors.colorLimeG, HexColors.colorLimeB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEnergizedHexorium.UNLOCALISEDNAME + "Green",
                HexColors.brightnessBright, HexColors.colorGreenR, HexColors.colorGreenG, HexColors.colorGreenB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEnergizedHexorium.UNLOCALISEDNAME + "Turquoise",
                HexColors.brightnessBright, HexColors.colorTurquoiseR, HexColors.colorTurquoiseG, HexColors.colorTurquoiseB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEnergizedHexorium.UNLOCALISEDNAME + "Cyan",
                HexColors.brightnessBright, HexColors.colorCyanR, HexColors.colorCyanG, HexColors.colorCyanB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEnergizedHexorium.UNLOCALISEDNAME + "SkyBlue",
                HexColors.brightnessBright, HexColors.colorSkyBlueR, HexColors.colorSkyBlueG, HexColors.colorSkyBlueB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEnergizedHexorium.UNLOCALISEDNAME + "Blue",
                HexColors.brightnessBright, HexColors.colorBlueR, HexColors.colorBlueG, HexColors.colorBlueB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEnergizedHexorium.UNLOCALISEDNAME + "Purple",
                HexColors.brightnessBright, HexColors.colorPurpleR, HexColors.colorPurpleG, HexColors.colorPurpleB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEnergizedHexorium.UNLOCALISEDNAME + "Magenta",
                HexColors.brightnessBright, HexColors.colorMagentaR, HexColors.colorMagentaG, HexColors.colorMagentaB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEnergizedHexorium.UNLOCALISEDNAME + "Pink",
                HexColors.brightnessBright, HexColors.colorPinkR, HexColors.colorPinkG, HexColors.colorPinkB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEnergizedHexorium.UNLOCALISEDNAME + "White",
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEnergizedHexorium.UNLOCALISEDNAME + "LightGray",
                HexColors.brightnessBright, HexColors.colorLightGrayR, HexColors.colorLightGrayG, HexColors.colorLightGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEnergizedHexorium.UNLOCALISEDNAME + "Gray",
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEnergizedHexorium.UNLOCALISEDNAME + "DarkGray",
                HexColors.brightnessBright, HexColors.colorDarkGrayR, HexColors.colorDarkGrayG, HexColors.colorDarkGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEnergizedHexorium.UNLOCALISEDNAME + "Black",
                HexColors.brightnessBright, HexColors.colorBlackR, HexColors.colorBlackG, HexColors.colorBlackB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEnergizedHexorium.UNLOCALISEDNAME + "Rainbow",
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));

        /* Engineering Block */
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEngineeringBlock.UNLOCALISEDNAME + "White",
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEngineeringBlock.UNLOCALISEDNAME + "Purple",
                HexColors.brightnessBright, HexColors.colorPurpleR, HexColors.colorPurpleG, HexColors.colorPurpleB));
    }
}
