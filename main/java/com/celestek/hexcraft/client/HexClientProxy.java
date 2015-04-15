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
     * Registers renderers for all block.
     */
    public static void setCustomRenderers()
    {
        /* Prepare HexCraft's block ID counter. */
        HexCraft.idCounter = 0;

        /* Hexorium Ore */
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockHexoriumOre.UNLOCALISEDNAME + "Red",
                HexColors.brightnessFaint, HexColors.whiteR, HexColors.whiteG, HexColors.whiteB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockHexoriumOre.UNLOCALISEDNAME + "Green",
                HexColors.brightnessFaint, HexColors.whiteR, HexColors.whiteG, HexColors.whiteB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockHexoriumOre.UNLOCALISEDNAME + "Blue",
                HexColors.brightnessFaint, HexColors.whiteR, HexColors.whiteG, HexColors.whiteB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockHexoriumOre.UNLOCALISEDNAME + "White",
                HexColors.brightnessFaint, HexColors.whiteR, HexColors.whiteG, HexColors.whiteB));

        /* Energized Hexorium */
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEnergizedHexorium.UNLOCALISEDNAME,
                HexColors.brightnessBright, HexColors.whiteR, HexColors.whiteG, HexColors.whiteB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEnergizedHexorium.UNLOCALISEDNAME,
                HexColors.brightnessBright, HexColors.greenR, HexColors.greenG, HexColors.greenB));

        /* Engineering Block */
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEngineeringBlock.UNLOCALISEDNAME,
                HexColors.brightnessBright, HexColors.whiteR, HexColors.whiteG, HexColors.whiteB));
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter], BlockEngineeringBlock.UNLOCALISEDNAME,
                HexColors.brightnessBright, HexColors.purpleR, HexColors.purpleG, HexColors.purpleB));
    }
}
