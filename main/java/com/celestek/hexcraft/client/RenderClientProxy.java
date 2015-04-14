package com.celestek.hexcraft.client;

import com.celestek.hexcraft.RenderCommonProxy;
import com.celestek.hexcraft.blocks.EngineeringBlock;
import com.celestek.hexcraft.blocks.HexoriumBlock;
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
        RenderingRegistry.registerBlockHandler(new BlockRenderer(false, 1F, 1F, 1F, hexoriumBlock, HexoriumBlock.UNLOCALISEDNAME));

        hexoriumBlockGreen = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new BlockRenderer(false, 0F, 1F, 0F, hexoriumBlockGreen, HexoriumBlock.UNLOCALISEDNAME));

        engineeringBlock = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new BlockRenderer(true, 1F, 1F, 1F, engineeringBlock, EngineeringBlock.UNLOCALISEDNAME));

        engineeringBlockPurple = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new BlockRenderer(true, 0.5F, 0F, 1F, engineeringBlockPurple, EngineeringBlock.UNLOCALISEDNAME));
    }
}
