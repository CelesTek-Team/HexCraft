package com.celestek.hexcraft.client;

import com.celestek.hexcraft.HexCommonProxy;
import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.renderer.*;
import com.celestek.hexcraft.util.HexColors;
import com.celestek.hexcraft.init.HexBlocks;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.7.0
 */

public class HexClientProxy extends HexCommonProxy {

    // Minecraft's internal ID of a certain block. Length controlled in HexBlocks.
    public static int renderID[] = new int[HexBlocks.countBlocks];

    // Render pass for every block. Length controlled in HexBlocks.
    public static int renderPass[] = new int[HexBlocks.countBlocks];

    /**
     * Handles preInit.
     */
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);

        // Set up custom rendering.
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
    public static void setCustomRenderers() {
        // Prepare HexCraft's block ID counter.
        HexCraft.idCounter = 0;

        // Hexorium Nether Ore
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));

        // Hexorium Ore
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));

        // Hexorium Monolith
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorGrayR, HexColors.colorGrayR, HexColors.colorGrayR, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorGrayR, HexColors.colorGrayR, HexColors.colorGrayR, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorGrayR, HexColors.colorGrayR, HexColors.colorGrayR, true));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorGrayR, HexColors.colorGrayR, HexColors.colorGrayR, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorGrayR, HexColors.colorGrayR, HexColors.colorGrayR, true));

        // Hexorium Nether Monolith
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorGrayR, HexColors.colorGrayR, HexColors.colorGrayR, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorGrayR, HexColors.colorGrayR, HexColors.colorGrayR, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorGrayR, HexColors.colorGrayR, HexColors.colorGrayR, true));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorGrayR, HexColors.colorGrayR, HexColors.colorGrayR, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorGrayR, HexColors.colorGrayR, HexColors.colorGrayR, true));

        // Block of Hexorium Crystal
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));

        // Energized Hexorium
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorRedR, HexColors.colorRedG, HexColors.colorRedB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorOrangeR, HexColors.colorOrangeG, HexColors.colorOrangeB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorYellowR, HexColors.colorYellowG, HexColors.colorYellowB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLimeR, HexColors.colorLimeG, HexColors.colorLimeB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGreenR, HexColors.colorGreenG, HexColors.colorGreenB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorTurquoiseR, HexColors.colorTurquoiseG, HexColors.colorTurquoiseB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorCyanR, HexColors.colorCyanG, HexColors.colorCyanB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorSkyBlueR, HexColors.colorSkyBlueG, HexColors.colorSkyBlueB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlueR, HexColors.colorBlueG, HexColors.colorBlueB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPurpleR, HexColors.colorPurpleG, HexColors.colorPurpleB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorMagentaR, HexColors.colorMagentaG, HexColors.colorMagentaB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPinkR, HexColors.colorPinkG, HexColors.colorPinkB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLightGrayR, HexColors.colorLightGrayG, HexColors.colorLightGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorDarkGrayR, HexColors.colorDarkGrayG, HexColors.colorDarkGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlackR, HexColors.colorBlackG, HexColors.colorBlackB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));

        // Engineered Hexorium Block
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorRedR, HexColors.colorRedG, HexColors.colorRedB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorOrangeR, HexColors.colorOrangeG, HexColors.colorOrangeB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorYellowR, HexColors.colorYellowG, HexColors.colorYellowB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLimeR, HexColors.colorLimeG, HexColors.colorLimeB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGreenR, HexColors.colorGreenG, HexColors.colorGreenB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorTurquoiseR, HexColors.colorTurquoiseG, HexColors.colorTurquoiseB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorCyanR, HexColors.colorCyanG, HexColors.colorCyanB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorSkyBlueR, HexColors.colorSkyBlueG, HexColors.colorSkyBlueB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlueR, HexColors.colorBlueG, HexColors.colorBlueB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPurpleR, HexColors.colorPurpleG, HexColors.colorPurpleB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorMagentaR, HexColors.colorMagentaG, HexColors.colorMagentaB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPinkR, HexColors.colorPinkG, HexColors.colorPinkB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLightGrayR, HexColors.colorLightGrayG, HexColors.colorLightGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorDarkGrayR, HexColors.colorDarkGrayG, HexColors.colorDarkGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlackR, HexColors.colorBlackG, HexColors.colorBlackB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));

        // Framed Hexorium Block
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorRedR, HexColors.colorRedG, HexColors.colorRedB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorOrangeR, HexColors.colorOrangeG, HexColors.colorOrangeB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorYellowR, HexColors.colorYellowG, HexColors.colorYellowB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLimeR, HexColors.colorLimeG, HexColors.colorLimeB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGreenR, HexColors.colorGreenG, HexColors.colorGreenB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorTurquoiseR, HexColors.colorTurquoiseG, HexColors.colorTurquoiseB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorCyanR, HexColors.colorCyanG, HexColors.colorCyanB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorSkyBlueR, HexColors.colorSkyBlueG, HexColors.colorSkyBlueB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlueR, HexColors.colorBlueG, HexColors.colorBlueB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPurpleR, HexColors.colorPurpleG, HexColors.colorPurpleB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorMagentaR, HexColors.colorMagentaG, HexColors.colorMagentaB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPinkR, HexColors.colorPinkG, HexColors.colorPinkB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLightGrayR, HexColors.colorLightGrayG, HexColors.colorLightGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorDarkGrayR, HexColors.colorDarkGrayG, HexColors.colorDarkGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlackR, HexColors.colorBlackG, HexColors.colorBlackB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));

        // Plated Hexorium Block
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorRedR, HexColors.colorRedG, HexColors.colorRedB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorOrangeR, HexColors.colorOrangeG, HexColors.colorOrangeB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorYellowR, HexColors.colorYellowG, HexColors.colorYellowB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLimeR, HexColors.colorLimeG, HexColors.colorLimeB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGreenR, HexColors.colorGreenG, HexColors.colorGreenB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorTurquoiseR, HexColors.colorTurquoiseG, HexColors.colorTurquoiseB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorCyanR, HexColors.colorCyanG, HexColors.colorCyanB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorSkyBlueR, HexColors.colorSkyBlueG, HexColors.colorSkyBlueB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlueR, HexColors.colorBlueG, HexColors.colorBlueB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPurpleR, HexColors.colorPurpleG, HexColors.colorPurpleB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorMagentaR, HexColors.colorMagentaG, HexColors.colorMagentaB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPinkR, HexColors.colorPinkG, HexColors.colorPinkB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLightGrayR, HexColors.colorLightGrayG, HexColors.colorLightGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorDarkGrayR, HexColors.colorDarkGrayG, HexColors.colorDarkGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlackR, HexColors.colorBlackG, HexColors.colorBlackB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));

        // Reinforced Hexorium Block
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorRedR, HexColors.colorRedG, HexColors.colorRedB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorOrangeR, HexColors.colorOrangeG, HexColors.colorOrangeB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorYellowR, HexColors.colorYellowG, HexColors.colorYellowB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLimeR, HexColors.colorLimeG, HexColors.colorLimeB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGreenR, HexColors.colorGreenG, HexColors.colorGreenB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorTurquoiseR, HexColors.colorTurquoiseG, HexColors.colorTurquoiseB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorCyanR, HexColors.colorCyanG, HexColors.colorCyanB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorSkyBlueR, HexColors.colorSkyBlueG, HexColors.colorSkyBlueB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlueR, HexColors.colorBlueG, HexColors.colorBlueB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPurpleR, HexColors.colorPurpleG, HexColors.colorPurpleB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorMagentaR, HexColors.colorMagentaG, HexColors.colorMagentaB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPinkR, HexColors.colorPinkG, HexColors.colorPinkB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLightGrayR, HexColors.colorLightGrayG, HexColors.colorLightGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorDarkGrayR, HexColors.colorDarkGrayG, HexColors.colorDarkGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlackR, HexColors.colorBlackG, HexColors.colorBlackB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));

        // Glowing Hexorium Glass
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorRedR, HexColors.colorRedG, HexColors.colorRedB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorOrangeR, HexColors.colorOrangeG, HexColors.colorOrangeB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorYellowR, HexColors.colorYellowG, HexColors.colorYellowB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLimeR, HexColors.colorLimeG, HexColors.colorLimeB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGreenR, HexColors.colorGreenG, HexColors.colorGreenB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorTurquoiseR, HexColors.colorTurquoiseG, HexColors.colorTurquoiseB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorCyanR, HexColors.colorCyanG, HexColors.colorCyanB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorSkyBlueR, HexColors.colorSkyBlueG, HexColors.colorSkyBlueB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlueR, HexColors.colorBlueG, HexColors.colorBlueB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPurpleR, HexColors.colorPurpleG, HexColors.colorPurpleB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorMagentaR, HexColors.colorMagentaG, HexColors.colorMagentaB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPinkR, HexColors.colorPinkG, HexColors.colorPinkB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLightGrayR, HexColors.colorLightGrayG, HexColors.colorLightGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorDarkGrayR, HexColors.colorDarkGrayG, HexColors.colorDarkGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlackR, HexColors.colorBlackG, HexColors.colorBlackB));

        // Energized Hexorium Monolith
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorRedR, HexColors.colorRedG, HexColors.colorRedB, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorOrangeR, HexColors.colorOrangeG, HexColors.colorOrangeB, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorYellowR, HexColors.colorYellowG, HexColors.colorYellowB, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorLimeR, HexColors.colorLimeG, HexColors.colorLimeB, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorGreenR, HexColors.colorGreenG, HexColors.colorGreenB, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorTurquoiseR, HexColors.colorTurquoiseG, HexColors.colorTurquoiseB, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorCyanR, HexColors.colorCyanG, HexColors.colorCyanB, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorSkyBlueR, HexColors.colorSkyBlueG, HexColors.colorSkyBlueB, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorBlueR, HexColors.colorBlueG, HexColors.colorBlueB, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorPurpleR, HexColors.colorPurpleG, HexColors.colorPurpleB, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorMagentaR, HexColors.colorMagentaG, HexColors.colorMagentaB, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorPinkR, HexColors.colorPinkG, HexColors.colorPinkB, false));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorLightGrayR, HexColors.colorLightGrayG, HexColors.colorLightGrayB, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorDarkGrayR, HexColors.colorDarkGrayG, HexColors.colorDarkGrayB, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorBlackR, HexColors.colorBlackG, HexColors.colorBlackB, false));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB, false));

        // Hexorium Lamp
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorRedR, HexColors.colorRedG, HexColors.colorRedB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorOrangeR, HexColors.colorOrangeG, HexColors.colorOrangeB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorYellowR, HexColors.colorYellowG, HexColors.colorYellowB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLimeR, HexColors.colorLimeG, HexColors.colorLimeB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGreenR, HexColors.colorGreenG, HexColors.colorGreenB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorTurquoiseR, HexColors.colorTurquoiseG, HexColors.colorTurquoiseB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorCyanR, HexColors.colorCyanG, HexColors.colorCyanB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorSkyBlueR, HexColors.colorSkyBlueG, HexColors.colorSkyBlueB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlueR, HexColors.colorBlueG, HexColors.colorBlueB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPurpleR, HexColors.colorPurpleG, HexColors.colorPurpleB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorMagentaR, HexColors.colorMagentaG, HexColors.colorMagentaB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPinkR, HexColors.colorPinkG, HexColors.colorPinkB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLightGrayR, HexColors.colorLightGrayG, HexColors.colorLightGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorDarkGrayR, HexColors.colorDarkGrayG, HexColors.colorDarkGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlackR, HexColors.colorBlackG, HexColors.colorBlackB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));

        // Inverted Hexorium Lamp
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorRedR, HexColors.colorRedG, HexColors.colorRedB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorOrangeR, HexColors.colorOrangeG, HexColors.colorOrangeB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorYellowR, HexColors.colorYellowG, HexColors.colorYellowB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLimeR, HexColors.colorLimeG, HexColors.colorLimeB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGreenR, HexColors.colorGreenG, HexColors.colorGreenB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorTurquoiseR, HexColors.colorTurquoiseG, HexColors.colorTurquoiseB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorCyanR, HexColors.colorCyanG, HexColors.colorCyanB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorSkyBlueR, HexColors.colorSkyBlueG, HexColors.colorSkyBlueB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlueR, HexColors.colorBlueG, HexColors.colorBlueB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPurpleR, HexColors.colorPurpleG, HexColors.colorPurpleB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorMagentaR, HexColors.colorMagentaG, HexColors.colorMagentaB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPinkR, HexColors.colorPinkG, HexColors.colorPinkB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLightGrayR, HexColors.colorLightGrayG, HexColors.colorLightGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorDarkGrayR, HexColors.colorDarkGrayG, HexColors.colorDarkGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlackR, HexColors.colorBlackG, HexColors.colorBlackB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));

        // Hexorium Door
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorRedR, HexColors.colorRedG, HexColors.colorRedB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorOrangeR, HexColors.colorOrangeG, HexColors.colorOrangeB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorYellowR, HexColors.colorYellowG, HexColors.colorYellowB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLimeR, HexColors.colorLimeG, HexColors.colorLimeB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGreenR, HexColors.colorGreenG, HexColors.colorGreenB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorTurquoiseR, HexColors.colorTurquoiseG, HexColors.colorTurquoiseB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorCyanR, HexColors.colorCyanG, HexColors.colorCyanB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorSkyBlueR, HexColors.colorSkyBlueG, HexColors.colorSkyBlueB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlueR, HexColors.colorBlueG, HexColors.colorBlueB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPurpleR, HexColors.colorPurpleG, HexColors.colorPurpleB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorMagentaR, HexColors.colorMagentaG, HexColors.colorMagentaB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPinkR, HexColors.colorPinkG, HexColors.colorPinkB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLightGrayR, HexColors.colorLightGrayG, HexColors.colorLightGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorDarkGrayR, HexColors.colorDarkGrayG, HexColors.colorDarkGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlackR, HexColors.colorBlackG, HexColors.colorBlackB));
        
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));

        // Hexorium Hatch
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorRedR, HexColors.colorRedG, HexColors.colorRedB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorOrangeR, HexColors.colorOrangeG, HexColors.colorOrangeB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorYellowR, HexColors.colorYellowG, HexColors.colorYellowB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLimeR, HexColors.colorLimeG, HexColors.colorLimeB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGreenR, HexColors.colorGreenG, HexColors.colorGreenB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorTurquoiseR, HexColors.colorTurquoiseG, HexColors.colorTurquoiseB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorCyanR, HexColors.colorCyanG, HexColors.colorCyanB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorSkyBlueR, HexColors.colorSkyBlueG, HexColors.colorSkyBlueB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlueR, HexColors.colorBlueG, HexColors.colorBlueB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPurpleR, HexColors.colorPurpleG, HexColors.colorPurpleB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorMagentaR, HexColors.colorMagentaG, HexColors.colorMagentaB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPinkR, HexColors.colorPinkG, HexColors.colorPinkB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLightGrayR, HexColors.colorLightGrayG, HexColors.colorLightGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorDarkGrayR, HexColors.colorDarkGrayG, HexColors.colorDarkGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlackR, HexColors.colorBlackG, HexColors.colorBlackB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));

        // Machines
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockTeleportationRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB, HexColors.colorCyanR, HexColors.colorCyanG, HexColors.colorCyanB));

        // Tank Valve
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexMultiRendererTank(renderID[HexCraft.idCounter]));

        // Cables
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorRedR, HexColors.colorRedG, HexColors.colorRedB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorOrangeR, HexColors.colorOrangeG, HexColors.colorOrangeB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorYellowR, HexColors.colorYellowG, HexColors.colorYellowB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLimeR, HexColors.colorLimeG, HexColors.colorLimeB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGreenR, HexColors.colorGreenG, HexColors.colorGreenB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorTurquoiseR, HexColors.colorTurquoiseG, HexColors.colorTurquoiseB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorCyanR, HexColors.colorCyanG, HexColors.colorCyanB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorSkyBlueR, HexColors.colorSkyBlueG, HexColors.colorSkyBlueB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlueR, HexColors.colorBlueG, HexColors.colorBlueB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPurpleR, HexColors.colorPurpleG, HexColors.colorPurpleB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorMagentaR, HexColors.colorMagentaG, HexColors.colorMagentaB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPinkR, HexColors.colorPinkG, HexColors.colorPinkB));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLightGrayR, HexColors.colorLightGrayG, HexColors.colorLightGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorDarkGrayR, HexColors.colorDarkGrayG, HexColors.colorDarkGrayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlackR, HexColors.colorBlackG, HexColors.colorBlackB));
        
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB));

        // Energy Pylon
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererPylon(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.opacitySlight));

        // Hexorium Switch
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererSwitchButton(renderID[HexCraft.idCounter],
                HexColors.brightnessBright));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererSwitchButton(renderID[HexCraft.idCounter],
                HexColors.brightnessBright));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererSwitchButton(renderID[HexCraft.idCounter],
                HexColors.brightnessBright));

        // Hexorium Button
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererSwitchButton(renderID[HexCraft.idCounter],
                HexColors.brightnessBright));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererSwitchButton(renderID[HexCraft.idCounter],
                HexColors.brightnessBright));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererSwitchButton(renderID[HexCraft.idCounter],
                HexColors.brightnessBright));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererSwitchButton(renderID[HexCraft.idCounter],
                HexColors.brightnessBright));

        // Hexorium Pressure Plate
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererPressurePlate(renderID[HexCraft.idCounter],
                HexColors.brightnessBright));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererPressurePlate(renderID[HexCraft.idCounter],
                HexColors.brightnessBright));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererPressurePlate(renderID[HexCraft.idCounter],
                HexColors.brightnessBright));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererPressurePlate(renderID[HexCraft.idCounter],
                HexColors.brightnessBright));
    }
}
