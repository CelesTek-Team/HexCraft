package com.celestek.hexcraft.client;

import com.celestek.hexcraft.HexCommonProxy;
import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.renderer.HexBlockRenderer;
import com.celestek.hexcraft.util.HexColors;
import com.celestek.hexcraft.client.renderer.HexModelRendererCable;
import com.celestek.hexcraft.client.renderer.HexModelRendererMonolith;
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
    public static void setCustomRenderers()
    {
        // Prepare HexCraft's block ID counter.
        HexCraft.idCounter = 0;

        // Hexorium Nether Ore
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB, false, false));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB, false, false));

        // Hexorium Ore
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB, false, false));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB, false, false));

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
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB, true, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB, true, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB, true, false));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB, true, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB, true, false));

        // Energized Hexorium
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorRedR, HexColors.colorRedG, HexColors.colorRedB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorOrangeR, HexColors.colorOrangeG, HexColors.colorOrangeB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorYellowR, HexColors.colorYellowG, HexColors.colorYellowB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLimeR, HexColors.colorLimeG, HexColors.colorLimeB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGreenR, HexColors.colorGreenG, HexColors.colorGreenB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorTurquoiseR, HexColors.colorTurquoiseG, HexColors.colorTurquoiseB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorCyanR, HexColors.colorCyanG, HexColors.colorCyanB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorSkyBlueR, HexColors.colorSkyBlueG, HexColors.colorSkyBlueB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlueR, HexColors.colorBlueG, HexColors.colorBlueB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPurpleR, HexColors.colorPurpleG, HexColors.colorPurpleB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorMagentaR, HexColors.colorMagentaG, HexColors.colorMagentaB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPinkR, HexColors.colorPinkG, HexColors.colorPinkB, false, false));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLightGrayR, HexColors.colorLightGrayG, HexColors.colorLightGrayB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorDarkGrayR, HexColors.colorDarkGrayG, HexColors.colorDarkGrayB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlackR, HexColors.colorBlackG, HexColors.colorBlackB, false, false));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB, false, false));

        // Engineered Hexorium Block
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorRedR, HexColors.colorRedG, HexColors.colorRedB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorOrangeR, HexColors.colorOrangeG, HexColors.colorOrangeB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorYellowR, HexColors.colorYellowG, HexColors.colorYellowB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLimeR, HexColors.colorLimeG, HexColors.colorLimeB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGreenR, HexColors.colorGreenG, HexColors.colorGreenB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorTurquoiseR, HexColors.colorTurquoiseG, HexColors.colorTurquoiseB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorCyanR, HexColors.colorCyanG, HexColors.colorCyanB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorSkyBlueR, HexColors.colorSkyBlueG, HexColors.colorSkyBlueB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlueR, HexColors.colorBlueG, HexColors.colorBlueB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPurpleR, HexColors.colorPurpleG, HexColors.colorPurpleB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorMagentaR, HexColors.colorMagentaG, HexColors.colorMagentaB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPinkR, HexColors.colorPinkG, HexColors.colorPinkB, false, false));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLightGrayR, HexColors.colorLightGrayG, HexColors.colorLightGrayB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorDarkGrayR, HexColors.colorDarkGrayG, HexColors.colorDarkGrayB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlackR, HexColors.colorBlackG, HexColors.colorBlackB, false, false));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB, false, false));

        // Framed Hexorium Block
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorRedR, HexColors.colorRedG, HexColors.colorRedB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorOrangeR, HexColors.colorOrangeG, HexColors.colorOrangeB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorYellowR, HexColors.colorYellowG, HexColors.colorYellowB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLimeR, HexColors.colorLimeG, HexColors.colorLimeB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGreenR, HexColors.colorGreenG, HexColors.colorGreenB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorTurquoiseR, HexColors.colorTurquoiseG, HexColors.colorTurquoiseB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorCyanR, HexColors.colorCyanG, HexColors.colorCyanB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorSkyBlueR, HexColors.colorSkyBlueG, HexColors.colorSkyBlueB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlueR, HexColors.colorBlueG, HexColors.colorBlueB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPurpleR, HexColors.colorPurpleG, HexColors.colorPurpleB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorMagentaR, HexColors.colorMagentaG, HexColors.colorMagentaB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPinkR, HexColors.colorPinkG, HexColors.colorPinkB, false, false));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLightGrayR, HexColors.colorLightGrayG, HexColors.colorLightGrayB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorDarkGrayR, HexColors.colorDarkGrayG, HexColors.colorDarkGrayB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlackR, HexColors.colorBlackG, HexColors.colorBlackB, false, false));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB, false, false));

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
                HexColors.brightnessBright, HexColors.colorRedR, HexColors.colorRedG, HexColors.colorRedB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorOrangeR, HexColors.colorOrangeG, HexColors.colorOrangeB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorYellowR, HexColors.colorYellowG, HexColors.colorYellowB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLimeR, HexColors.colorLimeG, HexColors.colorLimeB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGreenR, HexColors.colorGreenG, HexColors.colorGreenB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorTurquoiseR, HexColors.colorTurquoiseG, HexColors.colorTurquoiseB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorCyanR, HexColors.colorCyanG, HexColors.colorCyanB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorSkyBlueR, HexColors.colorSkyBlueG, HexColors.colorSkyBlueB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlueR, HexColors.colorBlueG, HexColors.colorBlueB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPurpleR, HexColors.colorPurpleG, HexColors.colorPurpleB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorMagentaR, HexColors.colorMagentaG, HexColors.colorMagentaB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPinkR, HexColors.colorPinkG, HexColors.colorPinkB, false, true));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLightGrayR, HexColors.colorLightGrayG, HexColors.colorLightGrayB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorDarkGrayR, HexColors.colorDarkGrayG, HexColors.colorDarkGrayB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlackR, HexColors.colorBlackG, HexColors.colorBlackB, false, true));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB, false, true));

        // Inverted Hexorium Lamp
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorRedR, HexColors.colorRedG, HexColors.colorRedB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorOrangeR, HexColors.colorOrangeG, HexColors.colorOrangeB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorYellowR, HexColors.colorYellowG, HexColors.colorYellowB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLimeR, HexColors.colorLimeG, HexColors.colorLimeB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGreenR, HexColors.colorGreenG, HexColors.colorGreenB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorTurquoiseR, HexColors.colorTurquoiseG, HexColors.colorTurquoiseB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorCyanR, HexColors.colorCyanG, HexColors.colorCyanB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorSkyBlueR, HexColors.colorSkyBlueG, HexColors.colorSkyBlueB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlueR, HexColors.colorBlueG, HexColors.colorBlueB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPurpleR, HexColors.colorPurpleG, HexColors.colorPurpleB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorMagentaR, HexColors.colorMagentaG, HexColors.colorMagentaB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPinkR, HexColors.colorPinkG, HexColors.colorPinkB, false, true));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLightGrayR, HexColors.colorLightGrayG, HexColors.colorLightGrayB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorDarkGrayR, HexColors.colorDarkGrayG, HexColors.colorDarkGrayB, false, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlackR, HexColors.colorBlackG, HexColors.colorBlackB, false, true));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB, false, true));

        // Machines
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB, false, false));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB, false, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB, false, false));

        // Cables
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorRedR, HexColors.colorRedG, HexColors.colorRedB, HexBlocks.cableHexoriumCableRed.getUnlocalizedName()));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorOrangeR, HexColors.colorOrangeG, HexColors.colorOrangeB, HexBlocks.cableHexoriumCableOrange.getUnlocalizedName()));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorYellowR, HexColors.colorYellowG, HexColors.colorYellowB, HexBlocks.cableHexoriumCableYellow.getUnlocalizedName()));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLimeR, HexColors.colorLimeG, HexColors.colorLimeB, HexBlocks.cableHexoriumCableLime.getUnlocalizedName()));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGreenR, HexColors.colorGreenG, HexColors.colorGreenB, HexBlocks.cableHexoriumCableGreen.getUnlocalizedName()));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorTurquoiseR, HexColors.colorTurquoiseG, HexColors.colorTurquoiseB, HexBlocks.cableHexoriumCableTurquoise.getUnlocalizedName()));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorCyanR, HexColors.colorCyanG, HexColors.colorCyanB, HexBlocks.cableHexoriumCableCyan.getUnlocalizedName()));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorSkyBlueR, HexColors.colorSkyBlueG, HexColors.colorSkyBlueB, HexBlocks.cableHexoriumCableSkyBlue.getUnlocalizedName()));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlueR, HexColors.colorBlueG, HexColors.colorBlueB, HexBlocks.cableHexoriumCableBlue.getUnlocalizedName()));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPurpleR, HexColors.colorPurpleG, HexColors.colorPurpleB, HexBlocks.cableHexoriumCablePurple.getUnlocalizedName()));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorMagentaR, HexColors.colorMagentaG, HexColors.colorMagentaB, HexBlocks.cableHexoriumCableMagenta.getUnlocalizedName()));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorPinkR, HexColors.colorPinkG, HexColors.colorPinkB, HexBlocks.cableHexoriumCablePink.getUnlocalizedName()));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB, HexBlocks.cableHexoriumCableWhite.getUnlocalizedName()));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorLightGrayR, HexColors.colorLightGrayG, HexColors.colorLightGrayB, HexBlocks.cableHexoriumCableLightGray.getUnlocalizedName()));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorGrayR, HexColors.colorGrayG, HexColors.colorGrayB, HexBlocks.cableHexoriumCableGray.getUnlocalizedName()));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorDarkGrayR, HexColors.colorDarkGrayG, HexColors.colorDarkGrayB, HexBlocks.cableHexoriumCableDarkGray.getUnlocalizedName()));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorBlackR, HexColors.colorBlackG, HexColors.colorBlackB, HexBlocks.cableHexoriumCableBlack.getUnlocalizedName()));
        
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexColors.brightnessBright, HexColors.colorWhiteR, HexColors.colorWhiteG, HexColors.colorWhiteB, HexBlocks.cableHexoriumCableRainbow.getUnlocalizedName()));
    }
}
