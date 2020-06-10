package com.celestek.hexcraft.client;

import com.celestek.hexcraft.HexCommonProxy;
import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.*;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

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
        BlockHexoriumMachineBlock.registerRenders();
        BlockAdvancedRainbowCore.registerRenders();
        BlockHexoriumGenerator.registerRenders();
        BlockHexoriumFurnace.registerRenders();
        BlockCrystalSeparator.registerRenders();
        BlockMatrixReconstructor.registerRenders();
        BlockPersonalTeleportationPad.registerRenders();
        BlockQuantumObserver.registerRenders();
        BlockQuantumAnchor.registerRenders();

        // Tank
        BlockTankValve.registerRenders();
        BlockTankRender.registerRenders();

        // Energy Node
        BlockEnergyNodeCore.registerRenders();
        BlockEnergyNodePortHEX.registerRenders();
        BlockEnergyNodePortRF.registerRenders();
        if (Loader.isModLoaded("IC2"))
            BlockEnergyNodePortEU.registerRenders();

        // Cables
        BlockHexoriumCable.registerRenders();

        // Energy Pylon
        BlockEnergyPylon.registerRenders();

        // Redstone
        BlockHexoriumSwitch.registerRenders();
        BlockHexoriumButton.registerRenders();
        BlockHexoriumPressurePlate.registerRenders();
    }
}
