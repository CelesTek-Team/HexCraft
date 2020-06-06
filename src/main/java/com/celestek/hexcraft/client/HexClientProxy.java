package com.celestek.hexcraft.client;

import com.celestek.hexcraft.HexCommonProxy;
import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.*;
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

        // Ores
        BlockHexoriumOre.registerRenders();
        BlockHexoriumMonolith.registerRenders();
        BlockHexoriumNetherOre.registerRenders();
        BlockHexoriumNetherMonolith.registerRenders();

        // Block of Hexorium Crystal
        BlockOfHexoriumCrystal.registerRenders();

        // Decorative
        BlockEnergizedHexorium.registerRenders();
        BlockEngineeredHexoriumBlock.registerRenders();
        BlockFramedHexoriumBlock.registerRenders();
        BlockPlatedHexoriumBlock.registerRenders();
        BlockConcentricHexoriumBlock.registerRenders();
        BlockHexoriumStructureCasing.registerRenders();
        BlockGlowingHexoriumCoatedStone.registerRenders();
        BlockGlowingHexoriumGlass.registerRenders();
        BlockEnergizedHexoriumMonolith.registerRenders();
        BlockHexoriumLamp.registerRenders();
        BlockHexoriumLampInv.registerRenders();
        BlockHexoriumDoor.registerRenders();
        BlockHexoriumHatch.registerRenders();

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
        BlockEnergyNodeCore.registerRenders();

        if (HexConfig.cfgEnergyNodeEnable) {

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

        BlockHexoriumCable.registerRenders();

        // Energy Pylon
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexModelRendererPylon(renderID[HexCraft.idCounter],
                HexEnums.BRIGHTNESS_BRIGHT, HexEnums.OPACITY_SLIGHT));

        BlockHexoriumSwitch.registerRenders();
        BlockHexoriumButton.registerRenders();
        BlockHexoriumPressurePlate.registerRenders();
    }
}
