package com.celestek.hexcraft.client;

import com.celestek.hexcraft.HexCommonProxy;
import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.BlockConcentricHexoriumBlock;
import com.celestek.hexcraft.block.BlockEngineeredHexoriumBlock;
import com.celestek.hexcraft.block.BlockFramedHexoriumBlock;
import com.celestek.hexcraft.block.BlockPlatedHexoriumBlock;
import com.celestek.hexcraft.client.renderer.*;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.util.HexEnums;
import com.celestek.hexcraft.init.HexBlocks;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * @author Thorinair   <celestek@openmailbox.org>
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
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));

        // Hexorium Ore
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));

        // Hexorium Monolith
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_R, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_R, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_R, true));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_R, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_R, true));

        // Hexorium Nether Monolith
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_R, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_R, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_R, true));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_R, true));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_R, true));

        // Block of Hexorium Crystal
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));

        // Energized Hexorium
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RED_R, HexEnums.COLOR_RED_G, HexEnums.COLOR_RED_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_ORANGE_R, HexEnums.COLOR_ORANGE_G, HexEnums.COLOR_ORANGE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_YELLOW_R, HexEnums.COLOR_YELLOW_G, HexEnums.COLOR_YELLOW_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIME_R, HexEnums.COLOR_LIME_G, HexEnums.COLOR_LIME_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GREEN_R, HexEnums.COLOR_GREEN_G, HexEnums.COLOR_GREEN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_TORQUOISE_R, HexEnums.COLOR_TORQUOISE_G, HexEnums.COLOR_TORQUOISE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_CYAN_R, HexEnums.COLOR_CYAN_G, HexEnums.COLOR_CYAN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_SKY_BLUE_R, HexEnums.COLOR_SKY_BLUE_G, HexEnums.COLOR_SKY_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLUE_R, HexEnums.COLOR_BLUE_G, HexEnums.COLOR_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PURPLE_R, HexEnums.COLOR_PURPLE_G, HexEnums.COLOR_PURPLE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_MAGENTA_R, HexEnums.COLOR_MAGENTA_G, HexEnums.COLOR_MAGENTA_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PINK_R, HexEnums.COLOR_PINK_G, HexEnums.COLOR_PINK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_WHITE_R, HexEnums.COLOR_WHITE_G, HexEnums.COLOR_WHITE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIGHT_GRAY_R, HexEnums.COLOR_LIGHT_GRAY_G, HexEnums.COLOR_LIGHT_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_DARK_GRAY_R, HexEnums.COLOR_DARK_GRAY_G, HexEnums.COLOR_DARK_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLACK_R, HexEnums.COLOR_BLACK_G, HexEnums.COLOR_BLACK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RAINBOW_R, HexEnums.COLOR_RAINBOW_G, HexEnums.COLOR_RAINBOW_B));

        BlockEngineeredHexoriumBlock.registerRenders();
        BlockFramedHexoriumBlock.registerRenders();
        BlockPlatedHexoriumBlock.registerRenders();
        BlockConcentricHexoriumBlock.registerRenders();

        // Hexorium Structure Casing
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RED_R, HexEnums.COLOR_RED_G, HexEnums.COLOR_RED_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_ORANGE_R, HexEnums.COLOR_ORANGE_G, HexEnums.COLOR_ORANGE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_YELLOW_R, HexEnums.COLOR_YELLOW_G, HexEnums.COLOR_YELLOW_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIME_R, HexEnums.COLOR_LIME_G, HexEnums.COLOR_LIME_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GREEN_R, HexEnums.COLOR_GREEN_G, HexEnums.COLOR_GREEN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_TORQUOISE_R, HexEnums.COLOR_TORQUOISE_G, HexEnums.COLOR_TORQUOISE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_CYAN_R, HexEnums.COLOR_CYAN_G, HexEnums.COLOR_CYAN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_SKY_BLUE_R, HexEnums.COLOR_SKY_BLUE_G, HexEnums.COLOR_SKY_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLUE_R, HexEnums.COLOR_BLUE_G, HexEnums.COLOR_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PURPLE_R, HexEnums.COLOR_PURPLE_G, HexEnums.COLOR_PURPLE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_MAGENTA_R, HexEnums.COLOR_MAGENTA_G, HexEnums.COLOR_MAGENTA_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PINK_R, HexEnums.COLOR_PINK_G, HexEnums.COLOR_PINK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_WHITE_R, HexEnums.COLOR_WHITE_G, HexEnums.COLOR_WHITE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIGHT_GRAY_R, HexEnums.COLOR_LIGHT_GRAY_G, HexEnums.COLOR_LIGHT_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_DARK_GRAY_R, HexEnums.COLOR_DARK_GRAY_G, HexEnums.COLOR_DARK_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLACK_R, HexEnums.COLOR_BLACK_G, HexEnums.COLOR_BLACK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RAINBOW_R, HexEnums.COLOR_RAINBOW_G, HexEnums.COLOR_RAINBOW_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RED_R, HexEnums.COLOR_RED_G, HexEnums.COLOR_RED_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_ORANGE_R, HexEnums.COLOR_ORANGE_G, HexEnums.COLOR_ORANGE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_YELLOW_R, HexEnums.COLOR_YELLOW_G, HexEnums.COLOR_YELLOW_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIME_R, HexEnums.COLOR_LIME_G, HexEnums.COLOR_LIME_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GREEN_R, HexEnums.COLOR_GREEN_G, HexEnums.COLOR_GREEN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_TORQUOISE_R, HexEnums.COLOR_TORQUOISE_G, HexEnums.COLOR_TORQUOISE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_CYAN_R, HexEnums.COLOR_CYAN_G, HexEnums.COLOR_CYAN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_SKY_BLUE_R, HexEnums.COLOR_SKY_BLUE_G, HexEnums.COLOR_SKY_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLUE_R, HexEnums.COLOR_BLUE_G, HexEnums.COLOR_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PURPLE_R, HexEnums.COLOR_PURPLE_G, HexEnums.COLOR_PURPLE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_MAGENTA_R, HexEnums.COLOR_MAGENTA_G, HexEnums.COLOR_MAGENTA_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PINK_R, HexEnums.COLOR_PINK_G, HexEnums.COLOR_PINK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_WHITE_R, HexEnums.COLOR_WHITE_G, HexEnums.COLOR_WHITE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIGHT_GRAY_R, HexEnums.COLOR_LIGHT_GRAY_G, HexEnums.COLOR_LIGHT_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_DARK_GRAY_R, HexEnums.COLOR_DARK_GRAY_G, HexEnums.COLOR_DARK_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLACK_R, HexEnums.COLOR_BLACK_G, HexEnums.COLOR_BLACK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RAINBOW_R, HexEnums.COLOR_RAINBOW_G, HexEnums.COLOR_RAINBOW_B));

        // Glowing Hexorium-Coated Stone
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RED_R, HexEnums.COLOR_RED_G, HexEnums.COLOR_RED_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_ORANGE_R, HexEnums.COLOR_ORANGE_G, HexEnums.COLOR_ORANGE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_YELLOW_R, HexEnums.COLOR_YELLOW_G, HexEnums.COLOR_YELLOW_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIME_R, HexEnums.COLOR_LIME_G, HexEnums.COLOR_LIME_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GREEN_R, HexEnums.COLOR_GREEN_G, HexEnums.COLOR_GREEN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_TORQUOISE_R, HexEnums.COLOR_TORQUOISE_G, HexEnums.COLOR_TORQUOISE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_CYAN_R, HexEnums.COLOR_CYAN_G, HexEnums.COLOR_CYAN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_SKY_BLUE_R, HexEnums.COLOR_SKY_BLUE_G, HexEnums.COLOR_SKY_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLUE_R, HexEnums.COLOR_BLUE_G, HexEnums.COLOR_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PURPLE_R, HexEnums.COLOR_PURPLE_G, HexEnums.COLOR_PURPLE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_MAGENTA_R, HexEnums.COLOR_MAGENTA_G, HexEnums.COLOR_MAGENTA_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PINK_R, HexEnums.COLOR_PINK_G, HexEnums.COLOR_PINK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_WHITE_R, HexEnums.COLOR_WHITE_G, HexEnums.COLOR_WHITE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIGHT_GRAY_R, HexEnums.COLOR_LIGHT_GRAY_G, HexEnums.COLOR_LIGHT_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_DARK_GRAY_R, HexEnums.COLOR_DARK_GRAY_G, HexEnums.COLOR_DARK_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLACK_R, HexEnums.COLOR_BLACK_G, HexEnums.COLOR_BLACK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RAINBOW_R, HexEnums.COLOR_RAINBOW_G, HexEnums.COLOR_RAINBOW_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RED_R, HexEnums.COLOR_RED_G, HexEnums.COLOR_RED_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_ORANGE_R, HexEnums.COLOR_ORANGE_G, HexEnums.COLOR_ORANGE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_YELLOW_R, HexEnums.COLOR_YELLOW_G, HexEnums.COLOR_YELLOW_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIME_R, HexEnums.COLOR_LIME_G, HexEnums.COLOR_LIME_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GREEN_R, HexEnums.COLOR_GREEN_G, HexEnums.COLOR_GREEN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_TORQUOISE_R, HexEnums.COLOR_TORQUOISE_G, HexEnums.COLOR_TORQUOISE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_CYAN_R, HexEnums.COLOR_CYAN_G, HexEnums.COLOR_CYAN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_SKY_BLUE_R, HexEnums.COLOR_SKY_BLUE_G, HexEnums.COLOR_SKY_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLUE_R, HexEnums.COLOR_BLUE_G, HexEnums.COLOR_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PURPLE_R, HexEnums.COLOR_PURPLE_G, HexEnums.COLOR_PURPLE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_MAGENTA_R, HexEnums.COLOR_MAGENTA_G, HexEnums.COLOR_MAGENTA_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PINK_R, HexEnums.COLOR_PINK_G, HexEnums.COLOR_PINK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_WHITE_R, HexEnums.COLOR_WHITE_G, HexEnums.COLOR_WHITE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIGHT_GRAY_R, HexEnums.COLOR_LIGHT_GRAY_G, HexEnums.COLOR_LIGHT_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_DARK_GRAY_R, HexEnums.COLOR_DARK_GRAY_G, HexEnums.COLOR_DARK_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLACK_R, HexEnums.COLOR_BLACK_G, HexEnums.COLOR_BLACK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RAINBOW_R, HexEnums.COLOR_RAINBOW_G, HexEnums.COLOR_RAINBOW_B));

        // Glowing Hexorium Glass
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RED_R, HexEnums.COLOR_RED_G, HexEnums.COLOR_RED_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_ORANGE_R, HexEnums.COLOR_ORANGE_G, HexEnums.COLOR_ORANGE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_YELLOW_R, HexEnums.COLOR_YELLOW_G, HexEnums.COLOR_YELLOW_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIME_R, HexEnums.COLOR_LIME_G, HexEnums.COLOR_LIME_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GREEN_R, HexEnums.COLOR_GREEN_G, HexEnums.COLOR_GREEN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_TORQUOISE_R, HexEnums.COLOR_TORQUOISE_G, HexEnums.COLOR_TORQUOISE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_CYAN_R, HexEnums.COLOR_CYAN_G, HexEnums.COLOR_CYAN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_SKY_BLUE_R, HexEnums.COLOR_SKY_BLUE_G, HexEnums.COLOR_SKY_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLUE_R, HexEnums.COLOR_BLUE_G, HexEnums.COLOR_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PURPLE_R, HexEnums.COLOR_PURPLE_G, HexEnums.COLOR_PURPLE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_MAGENTA_R, HexEnums.COLOR_MAGENTA_G, HexEnums.COLOR_MAGENTA_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PINK_R, HexEnums.COLOR_PINK_G, HexEnums.COLOR_PINK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_WHITE_R, HexEnums.COLOR_WHITE_G, HexEnums.COLOR_WHITE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIGHT_GRAY_R, HexEnums.COLOR_LIGHT_GRAY_G, HexEnums.COLOR_LIGHT_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_DARK_GRAY_R, HexEnums.COLOR_DARK_GRAY_G, HexEnums.COLOR_DARK_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLACK_R, HexEnums.COLOR_BLACK_G, HexEnums.COLOR_BLACK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RED_R, HexEnums.COLOR_RED_G, HexEnums.COLOR_RED_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_ORANGE_R, HexEnums.COLOR_ORANGE_G, HexEnums.COLOR_ORANGE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_YELLOW_R, HexEnums.COLOR_YELLOW_G, HexEnums.COLOR_YELLOW_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIME_R, HexEnums.COLOR_LIME_G, HexEnums.COLOR_LIME_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GREEN_R, HexEnums.COLOR_GREEN_G, HexEnums.COLOR_GREEN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_TORQUOISE_R, HexEnums.COLOR_TORQUOISE_G, HexEnums.COLOR_TORQUOISE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_CYAN_R, HexEnums.COLOR_CYAN_G, HexEnums.COLOR_CYAN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_SKY_BLUE_R, HexEnums.COLOR_SKY_BLUE_G, HexEnums.COLOR_SKY_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLUE_R, HexEnums.COLOR_BLUE_G, HexEnums.COLOR_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PURPLE_R, HexEnums.COLOR_PURPLE_G, HexEnums.COLOR_PURPLE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_MAGENTA_R, HexEnums.COLOR_MAGENTA_G, HexEnums.COLOR_MAGENTA_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PINK_R, HexEnums.COLOR_PINK_G, HexEnums.COLOR_PINK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_WHITE_R, HexEnums.COLOR_WHITE_G, HexEnums.COLOR_WHITE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIGHT_GRAY_R, HexEnums.COLOR_LIGHT_GRAY_G, HexEnums.COLOR_LIGHT_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_DARK_GRAY_R, HexEnums.COLOR_DARK_GRAY_G, HexEnums.COLOR_DARK_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLACK_R, HexEnums.COLOR_BLACK_G, HexEnums.COLOR_BLACK_B));

        // Energized Hexorium Monolith
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_RED_R, HexEnums.COLOR_RED_G, HexEnums.COLOR_RED_B, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_ORANGE_R, HexEnums.COLOR_ORANGE_G, HexEnums.COLOR_ORANGE_B, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_YELLOW_R, HexEnums.COLOR_YELLOW_G, HexEnums.COLOR_YELLOW_B, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_LIME_R, HexEnums.COLOR_LIME_G, HexEnums.COLOR_LIME_B, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_GREEN_R, HexEnums.COLOR_GREEN_G, HexEnums.COLOR_GREEN_B, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_TORQUOISE_R, HexEnums.COLOR_TORQUOISE_G, HexEnums.COLOR_TORQUOISE_B, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_CYAN_R, HexEnums.COLOR_CYAN_G, HexEnums.COLOR_CYAN_B, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_SKY_BLUE_R, HexEnums.COLOR_SKY_BLUE_G, HexEnums.COLOR_SKY_BLUE_B, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_BLUE_R, HexEnums.COLOR_BLUE_G, HexEnums.COLOR_BLUE_B, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_PURPLE_R, HexEnums.COLOR_PURPLE_G, HexEnums.COLOR_PURPLE_B, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_MAGENTA_R, HexEnums.COLOR_MAGENTA_G, HexEnums.COLOR_MAGENTA_B, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_PINK_R, HexEnums.COLOR_PINK_G, HexEnums.COLOR_PINK_B, false));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_WHITE_R, HexEnums.COLOR_WHITE_G, HexEnums.COLOR_WHITE_B, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_LIGHT_GRAY_R, HexEnums.COLOR_LIGHT_GRAY_G, HexEnums.COLOR_LIGHT_GRAY_B, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_DARK_GRAY_R, HexEnums.COLOR_DARK_GRAY_G, HexEnums.COLOR_DARK_GRAY_B, false));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_BLACK_R, HexEnums.COLOR_BLACK_G, HexEnums.COLOR_BLACK_B, false));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT, HexEnums.COLOR_RAINBOW_R, HexEnums.COLOR_RAINBOW_G, HexEnums.COLOR_RAINBOW_B, false));

        // Hexorium Lamp
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RED_R, HexEnums.COLOR_RED_G, HexEnums.COLOR_RED_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_ORANGE_R, HexEnums.COLOR_ORANGE_G, HexEnums.COLOR_ORANGE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_YELLOW_R, HexEnums.COLOR_YELLOW_G, HexEnums.COLOR_YELLOW_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIME_R, HexEnums.COLOR_LIME_G, HexEnums.COLOR_LIME_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GREEN_R, HexEnums.COLOR_GREEN_G, HexEnums.COLOR_GREEN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_TORQUOISE_R, HexEnums.COLOR_TORQUOISE_G, HexEnums.COLOR_TORQUOISE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_CYAN_R, HexEnums.COLOR_CYAN_G, HexEnums.COLOR_CYAN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_SKY_BLUE_R, HexEnums.COLOR_SKY_BLUE_G, HexEnums.COLOR_SKY_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLUE_R, HexEnums.COLOR_BLUE_G, HexEnums.COLOR_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PURPLE_R, HexEnums.COLOR_PURPLE_G, HexEnums.COLOR_PURPLE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_MAGENTA_R, HexEnums.COLOR_MAGENTA_G, HexEnums.COLOR_MAGENTA_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PINK_R, HexEnums.COLOR_PINK_G, HexEnums.COLOR_PINK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_WHITE_R, HexEnums.COLOR_WHITE_G, HexEnums.COLOR_WHITE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIGHT_GRAY_R, HexEnums.COLOR_LIGHT_GRAY_G, HexEnums.COLOR_LIGHT_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_DARK_GRAY_R, HexEnums.COLOR_DARK_GRAY_G, HexEnums.COLOR_DARK_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLACK_R, HexEnums.COLOR_BLACK_G, HexEnums.COLOR_BLACK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RAINBOW_R, HexEnums.COLOR_RAINBOW_G, HexEnums.COLOR_RAINBOW_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RED_R, HexEnums.COLOR_RED_G, HexEnums.COLOR_RED_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_ORANGE_R, HexEnums.COLOR_ORANGE_G, HexEnums.COLOR_ORANGE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_YELLOW_R, HexEnums.COLOR_YELLOW_G, HexEnums.COLOR_YELLOW_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIME_R, HexEnums.COLOR_LIME_G, HexEnums.COLOR_LIME_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GREEN_R, HexEnums.COLOR_GREEN_G, HexEnums.COLOR_GREEN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_TORQUOISE_R, HexEnums.COLOR_TORQUOISE_G, HexEnums.COLOR_TORQUOISE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_CYAN_R, HexEnums.COLOR_CYAN_G, HexEnums.COLOR_CYAN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_SKY_BLUE_R, HexEnums.COLOR_SKY_BLUE_G, HexEnums.COLOR_SKY_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLUE_R, HexEnums.COLOR_BLUE_G, HexEnums.COLOR_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PURPLE_R, HexEnums.COLOR_PURPLE_G, HexEnums.COLOR_PURPLE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_MAGENTA_R, HexEnums.COLOR_MAGENTA_G, HexEnums.COLOR_MAGENTA_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PINK_R, HexEnums.COLOR_PINK_G, HexEnums.COLOR_PINK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_WHITE_R, HexEnums.COLOR_WHITE_G, HexEnums.COLOR_WHITE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIGHT_GRAY_R, HexEnums.COLOR_LIGHT_GRAY_G, HexEnums.COLOR_LIGHT_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_DARK_GRAY_R, HexEnums.COLOR_DARK_GRAY_G, HexEnums.COLOR_DARK_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLACK_R, HexEnums.COLOR_BLACK_G, HexEnums.COLOR_BLACK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RAINBOW_R, HexEnums.COLOR_RAINBOW_G, HexEnums.COLOR_RAINBOW_B));

        // Inverted Hexorium Lamp
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RED_R, HexEnums.COLOR_RED_G, HexEnums.COLOR_RED_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_ORANGE_R, HexEnums.COLOR_ORANGE_G, HexEnums.COLOR_ORANGE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_YELLOW_R, HexEnums.COLOR_YELLOW_G, HexEnums.COLOR_YELLOW_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIME_R, HexEnums.COLOR_LIME_G, HexEnums.COLOR_LIME_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GREEN_R, HexEnums.COLOR_GREEN_G, HexEnums.COLOR_GREEN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_TORQUOISE_R, HexEnums.COLOR_TORQUOISE_G, HexEnums.COLOR_TORQUOISE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_CYAN_R, HexEnums.COLOR_CYAN_G, HexEnums.COLOR_CYAN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_SKY_BLUE_R, HexEnums.COLOR_SKY_BLUE_G, HexEnums.COLOR_SKY_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLUE_R, HexEnums.COLOR_BLUE_G, HexEnums.COLOR_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PURPLE_R, HexEnums.COLOR_PURPLE_G, HexEnums.COLOR_PURPLE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_MAGENTA_R, HexEnums.COLOR_MAGENTA_G, HexEnums.COLOR_MAGENTA_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PINK_R, HexEnums.COLOR_PINK_G, HexEnums.COLOR_PINK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_WHITE_R, HexEnums.COLOR_WHITE_G, HexEnums.COLOR_WHITE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIGHT_GRAY_R, HexEnums.COLOR_LIGHT_GRAY_G, HexEnums.COLOR_LIGHT_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_DARK_GRAY_R, HexEnums.COLOR_DARK_GRAY_G, HexEnums.COLOR_DARK_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLACK_R, HexEnums.COLOR_BLACK_G, HexEnums.COLOR_BLACK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RAINBOW_R, HexEnums.COLOR_RAINBOW_G, HexEnums.COLOR_RAINBOW_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RED_R, HexEnums.COLOR_RED_G, HexEnums.COLOR_RED_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_ORANGE_R, HexEnums.COLOR_ORANGE_G, HexEnums.COLOR_ORANGE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_YELLOW_R, HexEnums.COLOR_YELLOW_G, HexEnums.COLOR_YELLOW_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIME_R, HexEnums.COLOR_LIME_G, HexEnums.COLOR_LIME_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GREEN_R, HexEnums.COLOR_GREEN_G, HexEnums.COLOR_GREEN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_TORQUOISE_R, HexEnums.COLOR_TORQUOISE_G, HexEnums.COLOR_TORQUOISE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_CYAN_R, HexEnums.COLOR_CYAN_G, HexEnums.COLOR_CYAN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_SKY_BLUE_R, HexEnums.COLOR_SKY_BLUE_G, HexEnums.COLOR_SKY_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLUE_R, HexEnums.COLOR_BLUE_G, HexEnums.COLOR_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PURPLE_R, HexEnums.COLOR_PURPLE_G, HexEnums.COLOR_PURPLE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_MAGENTA_R, HexEnums.COLOR_MAGENTA_G, HexEnums.COLOR_MAGENTA_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PINK_R, HexEnums.COLOR_PINK_G, HexEnums.COLOR_PINK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_WHITE_R, HexEnums.COLOR_WHITE_G, HexEnums.COLOR_WHITE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIGHT_GRAY_R, HexEnums.COLOR_LIGHT_GRAY_G, HexEnums.COLOR_LIGHT_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_DARK_GRAY_R, HexEnums.COLOR_DARK_GRAY_G, HexEnums.COLOR_DARK_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLACK_R, HexEnums.COLOR_BLACK_G, HexEnums.COLOR_BLACK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RAINBOW_R, HexEnums.COLOR_RAINBOW_G, HexEnums.COLOR_RAINBOW_B));

        // Hexorium Door
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RED_R, HexEnums.COLOR_RED_G, HexEnums.COLOR_RED_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_ORANGE_R, HexEnums.COLOR_ORANGE_G, HexEnums.COLOR_ORANGE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_YELLOW_R, HexEnums.COLOR_YELLOW_G, HexEnums.COLOR_YELLOW_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIME_R, HexEnums.COLOR_LIME_G, HexEnums.COLOR_LIME_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GREEN_R, HexEnums.COLOR_GREEN_G, HexEnums.COLOR_GREEN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_TORQUOISE_R, HexEnums.COLOR_TORQUOISE_G, HexEnums.COLOR_TORQUOISE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_CYAN_R, HexEnums.COLOR_CYAN_G, HexEnums.COLOR_CYAN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_SKY_BLUE_R, HexEnums.COLOR_SKY_BLUE_G, HexEnums.COLOR_SKY_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLUE_R, HexEnums.COLOR_BLUE_G, HexEnums.COLOR_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PURPLE_R, HexEnums.COLOR_PURPLE_G, HexEnums.COLOR_PURPLE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_MAGENTA_R, HexEnums.COLOR_MAGENTA_G, HexEnums.COLOR_MAGENTA_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PINK_R, HexEnums.COLOR_PINK_G, HexEnums.COLOR_PINK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_WHITE_R, HexEnums.COLOR_WHITE_G, HexEnums.COLOR_WHITE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIGHT_GRAY_R, HexEnums.COLOR_LIGHT_GRAY_G, HexEnums.COLOR_LIGHT_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_DARK_GRAY_R, HexEnums.COLOR_DARK_GRAY_G, HexEnums.COLOR_DARK_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLACK_R, HexEnums.COLOR_BLACK_G, HexEnums.COLOR_BLACK_B));
        
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RAINBOW_R, HexEnums.COLOR_RAINBOW_G, HexEnums.COLOR_RAINBOW_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RED_R, HexEnums.COLOR_RED_G, HexEnums.COLOR_RED_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_ORANGE_R, HexEnums.COLOR_ORANGE_G, HexEnums.COLOR_ORANGE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_YELLOW_R, HexEnums.COLOR_YELLOW_G, HexEnums.COLOR_YELLOW_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIME_R, HexEnums.COLOR_LIME_G, HexEnums.COLOR_LIME_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GREEN_R, HexEnums.COLOR_GREEN_G, HexEnums.COLOR_GREEN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_TORQUOISE_R, HexEnums.COLOR_TORQUOISE_G, HexEnums.COLOR_TORQUOISE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_CYAN_R, HexEnums.COLOR_CYAN_G, HexEnums.COLOR_CYAN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_SKY_BLUE_R, HexEnums.COLOR_SKY_BLUE_G, HexEnums.COLOR_SKY_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLUE_R, HexEnums.COLOR_BLUE_G, HexEnums.COLOR_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PURPLE_R, HexEnums.COLOR_PURPLE_G, HexEnums.COLOR_PURPLE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_MAGENTA_R, HexEnums.COLOR_MAGENTA_G, HexEnums.COLOR_MAGENTA_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PINK_R, HexEnums.COLOR_PINK_G, HexEnums.COLOR_PINK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_WHITE_R, HexEnums.COLOR_WHITE_G, HexEnums.COLOR_WHITE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIGHT_GRAY_R, HexEnums.COLOR_LIGHT_GRAY_G, HexEnums.COLOR_LIGHT_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_DARK_GRAY_R, HexEnums.COLOR_DARK_GRAY_G, HexEnums.COLOR_DARK_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLACK_R, HexEnums.COLOR_BLACK_G, HexEnums.COLOR_BLACK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RAINBOW_R, HexEnums.COLOR_RAINBOW_G, HexEnums.COLOR_RAINBOW_B));

        // Hexorium Hatch
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RED_R, HexEnums.COLOR_RED_G, HexEnums.COLOR_RED_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_ORANGE_R, HexEnums.COLOR_ORANGE_G, HexEnums.COLOR_ORANGE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_YELLOW_R, HexEnums.COLOR_YELLOW_G, HexEnums.COLOR_YELLOW_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIME_R, HexEnums.COLOR_LIME_G, HexEnums.COLOR_LIME_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GREEN_R, HexEnums.COLOR_GREEN_G, HexEnums.COLOR_GREEN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_TORQUOISE_R, HexEnums.COLOR_TORQUOISE_G, HexEnums.COLOR_TORQUOISE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_CYAN_R, HexEnums.COLOR_CYAN_G, HexEnums.COLOR_CYAN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_SKY_BLUE_R, HexEnums.COLOR_SKY_BLUE_G, HexEnums.COLOR_SKY_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLUE_R, HexEnums.COLOR_BLUE_G, HexEnums.COLOR_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PURPLE_R, HexEnums.COLOR_PURPLE_G, HexEnums.COLOR_PURPLE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_MAGENTA_R, HexEnums.COLOR_MAGENTA_G, HexEnums.COLOR_MAGENTA_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PINK_R, HexEnums.COLOR_PINK_G, HexEnums.COLOR_PINK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_WHITE_R, HexEnums.COLOR_WHITE_G, HexEnums.COLOR_WHITE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIGHT_GRAY_R, HexEnums.COLOR_LIGHT_GRAY_G, HexEnums.COLOR_LIGHT_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_DARK_GRAY_R, HexEnums.COLOR_DARK_GRAY_G, HexEnums.COLOR_DARK_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLACK_R, HexEnums.COLOR_BLACK_G, HexEnums.COLOR_BLACK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RAINBOW_R, HexEnums.COLOR_RAINBOW_G, HexEnums.COLOR_RAINBOW_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RED_R, HexEnums.COLOR_RED_G, HexEnums.COLOR_RED_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_ORANGE_R, HexEnums.COLOR_ORANGE_G, HexEnums.COLOR_ORANGE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_YELLOW_R, HexEnums.COLOR_YELLOW_G, HexEnums.COLOR_YELLOW_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIME_R, HexEnums.COLOR_LIME_G, HexEnums.COLOR_LIME_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GREEN_R, HexEnums.COLOR_GREEN_G, HexEnums.COLOR_GREEN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_TORQUOISE_R, HexEnums.COLOR_TORQUOISE_G, HexEnums.COLOR_TORQUOISE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_CYAN_R, HexEnums.COLOR_CYAN_G, HexEnums.COLOR_CYAN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_SKY_BLUE_R, HexEnums.COLOR_SKY_BLUE_G, HexEnums.COLOR_SKY_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLUE_R, HexEnums.COLOR_BLUE_G, HexEnums.COLOR_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PURPLE_R, HexEnums.COLOR_PURPLE_G, HexEnums.COLOR_PURPLE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_MAGENTA_R, HexEnums.COLOR_MAGENTA_G, HexEnums.COLOR_MAGENTA_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PINK_R, HexEnums.COLOR_PINK_G, HexEnums.COLOR_PINK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_WHITE_R, HexEnums.COLOR_WHITE_G, HexEnums.COLOR_WHITE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIGHT_GRAY_R, HexEnums.COLOR_LIGHT_GRAY_G, HexEnums.COLOR_LIGHT_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_DARK_GRAY_R, HexEnums.COLOR_DARK_GRAY_G, HexEnums.COLOR_DARK_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLACK_R, HexEnums.COLOR_BLACK_G, HexEnums.COLOR_BLACK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RAINBOW_R, HexEnums.COLOR_RAINBOW_G, HexEnums.COLOR_RAINBOW_B));

        // Machines
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_WHITE_R, HexEnums.COLOR_WHITE_G, HexEnums.COLOR_WHITE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RAINBOW_R, HexEnums.COLOR_RAINBOW_G, HexEnums.COLOR_RAINBOW_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_WHITE_R, HexEnums.COLOR_WHITE_G, HexEnums.COLOR_WHITE_B));

        if (HexConfig.cfgFurnaceEnable) {
            renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                    HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_WHITE_R, HexEnums.COLOR_WHITE_G, HexEnums.COLOR_WHITE_B));
        }

        if (HexConfig.cfgSeparatorEnable) {
            renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                    HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_WHITE_R, HexEnums.COLOR_WHITE_G, HexEnums.COLOR_WHITE_B));
        }

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_WHITE_R, HexEnums.COLOR_WHITE_G, HexEnums.COLOR_WHITE_B));

        if (HexConfig.cfgTeleportEnable) {
            renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(new HexBlockTeleportationRenderer(renderID[HexCraft.idCounter],
                    HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_WHITE_R, HexEnums.COLOR_WHITE_G, HexEnums.COLOR_WHITE_B,
                    HexEnums.COLOR_CYAN_R, HexEnums.COLOR_CYAN_G, HexEnums.COLOR_CYAN_B));
        }

        if (HexConfig.cfgObserverEnable) {
            renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                    HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLACK_R, HexEnums.COLOR_BLACK_G, HexEnums.COLOR_BLACK_B));
            renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                    HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLACK_R, HexEnums.COLOR_BLACK_G, HexEnums.COLOR_BLACK_B));
        }

        // Tank Valve
        if (HexConfig.cfgTankEnable) {
            renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                    HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_WHITE_R, HexEnums.COLOR_WHITE_G, HexEnums.COLOR_WHITE_B));
            renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(new HexMultiRendererTank(renderID[HexCraft.idCounter]));
        }

        // Energy Node
        if (HexConfig.cfgEnergyNodeEnable) {
            renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                    HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RAINBOW_R, HexEnums.COLOR_RAINBOW_G, HexEnums.COLOR_RAINBOW_B));
            renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                    HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RAINBOW_R, HexEnums.COLOR_RAINBOW_G, HexEnums.COLOR_RAINBOW_B));
            renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                    HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RAINBOW_R, HexEnums.COLOR_RAINBOW_G, HexEnums.COLOR_RAINBOW_B));
            renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                    HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RAINBOW_R, HexEnums.COLOR_RAINBOW_G, HexEnums.COLOR_RAINBOW_B));

            renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                    HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RAINBOW_R, HexEnums.COLOR_RAINBOW_G, HexEnums.COLOR_RAINBOW_B));
            if (HexConfig.cfgEnergyNodePortsRFEnable) {
                renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
                RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                        HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RAINBOW_R, HexEnums.COLOR_RAINBOW_G, HexEnums.COLOR_RAINBOW_B));
            }
            if (Loader.isModLoaded("IC2") && HexConfig.cfgEnergyNodePortsEUEnable) {
                renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
                RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                        HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RAINBOW_R, HexEnums.COLOR_RAINBOW_G, HexEnums.COLOR_RAINBOW_B));
            }
        }

        // Cables
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RED_R, HexEnums.COLOR_RED_G, HexEnums.COLOR_RED_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_ORANGE_R, HexEnums.COLOR_ORANGE_G, HexEnums.COLOR_ORANGE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_YELLOW_R, HexEnums.COLOR_YELLOW_G, HexEnums.COLOR_YELLOW_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIME_R, HexEnums.COLOR_LIME_G, HexEnums.COLOR_LIME_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GREEN_R, HexEnums.COLOR_GREEN_G, HexEnums.COLOR_GREEN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_TORQUOISE_R, HexEnums.COLOR_TORQUOISE_G, HexEnums.COLOR_TORQUOISE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_CYAN_R, HexEnums.COLOR_CYAN_G, HexEnums.COLOR_CYAN_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_SKY_BLUE_R, HexEnums.COLOR_SKY_BLUE_G, HexEnums.COLOR_SKY_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLUE_R, HexEnums.COLOR_BLUE_G, HexEnums.COLOR_BLUE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PURPLE_R, HexEnums.COLOR_PURPLE_G, HexEnums.COLOR_PURPLE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_MAGENTA_R, HexEnums.COLOR_MAGENTA_G, HexEnums.COLOR_MAGENTA_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_PINK_R, HexEnums.COLOR_PINK_G, HexEnums.COLOR_PINK_B));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_WHITE_R, HexEnums.COLOR_WHITE_G, HexEnums.COLOR_WHITE_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_LIGHT_GRAY_R, HexEnums.COLOR_LIGHT_GRAY_G, HexEnums.COLOR_LIGHT_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_GRAY_R, HexEnums.COLOR_GRAY_G, HexEnums.COLOR_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_DARK_GRAY_R, HexEnums.COLOR_DARK_GRAY_G, HexEnums.COLOR_DARK_GRAY_B));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_BLACK_R, HexEnums.COLOR_BLACK_G, HexEnums.COLOR_BLACK_B));
        
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererCable(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.COLOR_RAINBOW_R, HexEnums.COLOR_RAINBOW_G, HexEnums.COLOR_RAINBOW_B));

        // Energy Pylon
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererPylon(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT));

        // Hexorium Switch
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererSwitchButton(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererSwitchButton(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererSwitchButton(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererSwitchButton(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererSwitchButton(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererSwitchButton(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererSwitchButton(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererSwitchButton(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT));

        // Hexorium Button
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererSwitchButton(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererSwitchButton(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererSwitchButton(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererSwitchButton(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererSwitchButton(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererSwitchButton(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererSwitchButton(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererSwitchButton(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT));

        // Hexorium Pressure Plate
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererPressurePlate(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererPressurePlate(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererPressurePlate(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererPressurePlate(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT));

        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererPressurePlate(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererPressurePlate(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererPressurePlate(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererPressurePlate(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT));
    }
}
