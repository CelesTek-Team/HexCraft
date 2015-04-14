package com.celestek.hexcraft.client;

import com.celestek.hexcraft.RenderCommonProxy;
import com.celestek.hexcraft.blocks.EnergizedHexoriumBlock;
import com.celestek.hexcraft.blocks.EngineeringBlock;
import com.celestek.hexcraft.client.renderer.BlockRenderer;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class RenderClientProxy extends RenderCommonProxy {
    public static int hexoriumBlock;
    public static int hexoriumBlockGreen;
    public static int engineeringBlock;
    public static int engineeringBlockPurple;

    public static void setCustomRenderers()
    {
        hexoriumBlock = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new BlockRenderer(hexoriumBlock, false, EnergizedHexoriumBlock.UNLOCALISEDNAME, 0xF000F0, 1F, 1F, 1F));

        hexoriumBlockGreen = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new BlockRenderer(hexoriumBlockGreen, false, EnergizedHexoriumBlock.UNLOCALISEDNAME, 0xF000F0, 0F, 1F, 0F));

        engineeringBlock = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new BlockRenderer(engineeringBlock, true, EnergizedHexoriumBlock.UNLOCALISEDNAME, EngineeringBlock.UNLOCALISEDNAME, 0xF000F0, 1F, 1F, 1F));

        engineeringBlockPurple = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new BlockRenderer(engineeringBlockPurple, true, EnergizedHexoriumBlock.UNLOCALISEDNAME, EngineeringBlock.UNLOCALISEDNAME, 0xF000F0, 0.5F, 0F, 1F));
    }
}
