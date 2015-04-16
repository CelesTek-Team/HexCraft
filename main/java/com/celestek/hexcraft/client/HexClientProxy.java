package com.celestek.hexcraft.client;

import com.celestek.hexcraft.HexCommonProxy;
import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.BlockEngineeringBlock;
import com.celestek.hexcraft.block.BlockEnergizedHexorium;
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

        /* Hexorium Ore */
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockHexoriumOre.UNLOCALISEDNAME + "Red",
                HexColors.brightnessBright, HexColors.grayR, HexColors.grayG, HexColors.grayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockHexoriumOre.UNLOCALISEDNAME + "Green",
                HexColors.brightnessBright, HexColors.grayR, HexColors.grayG, HexColors.grayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockHexoriumOre.UNLOCALISEDNAME + "Blue",
                HexColors.brightnessBright, HexColors.grayR, HexColors.grayG, HexColors.grayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockHexoriumOre.UNLOCALISEDNAME + "White",
                HexColors.brightnessBright, HexColors.grayR, HexColors.grayG, HexColors.grayB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockHexoriumOre.UNLOCALISEDNAME + "Black",
                HexColors.brightnessBright, HexColors.grayR, HexColors.grayG, HexColors.grayB));

        /* Energized Hexorium */
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEnergizedHexorium.UNLOCALISEDNAME + "Red",
                HexColors.brightnessBright, HexColors.redR, HexColors.redG, HexColors.redB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEnergizedHexorium.UNLOCALISEDNAME + "Green",
                HexColors.brightnessBright, HexColors.greenR, HexColors.greenG, HexColors.greenB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEnergizedHexorium.UNLOCALISEDNAME + "Blue",
                HexColors.brightnessBright, HexColors.blueR, HexColors.blueG, HexColors.blueB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEnergizedHexorium.UNLOCALISEDNAME + "White",
                HexColors.brightnessBright, HexColors.whiteR, HexColors.whiteG, HexColors.whiteB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEnergizedHexorium.UNLOCALISEDNAME + "Black",
                HexColors.brightnessBright, HexColors.blackR, HexColors.blackG, HexColors.blackB));

        /* Engineering Block */
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEngineeringBlock.UNLOCALISEDNAME + "White",
                HexColors.brightnessBright, HexColors.whiteR, HexColors.whiteG, HexColors.whiteB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEngineeringBlock.UNLOCALISEDNAME + "Purple",
                HexColors.brightnessBright, HexColors.purpleR, HexColors.purpleG, HexColors.purpleB));
    }
}
