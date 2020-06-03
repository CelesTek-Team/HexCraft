package com.celestek.hexcraft.init;

import com.celestek.hexcraft.block.*;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.item.IC2Items;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class HexRecipes {

    /**
     * Initializes all recipes and adds them to GameRegistry.
     */
    public static void initializeRecipes() {
        /* Stack init */

        // Vanilla Blocks
        ItemStack stackObsidian_1 = new ItemStack(Blocks.obsidian, 1);
        ItemStack stackStoneButton_1 = new ItemStack(Blocks.stone_button, 1);
        ItemStack stackHeavyWeightedPressurePlate_1 = new ItemStack(Blocks.heavy_weighted_pressure_plate, 1);
        ItemStack stackLever_1 = new ItemStack(Blocks.lever, 1);
        ItemStack stackRedstoneTorch_1 = new ItemStack(Blocks.redstone_torch, 1);
        ItemStack stackRedstoneBlock_1 = new ItemStack(Blocks.redstone_block, 1);
        ItemStack stackIronBars_1 = new ItemStack(Blocks.iron_bars, 1);

        // Vanilla Items
        ItemStack stackRedstone_1 = new ItemStack(Items.redstone, 1);
        ItemStack stackGlowstoneDust_1 = new ItemStack(Items.glowstone_dust, 1);
        ItemStack stackIronPickaxe_1 = new ItemStack(Items.iron_pickaxe, 1);
        ItemStack stackEnderEye_1 = new ItemStack(Items.ender_eye, 1);
        
        // Energized Hexorium
        ItemStack stackEnergizedHexoriumRed_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumRed, 1);
        ItemStack stackEnergizedHexoriumOrange_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumOrange, 1);
        ItemStack stackEnergizedHexoriumYellow_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumYellow, 1);
        ItemStack stackEnergizedHexoriumLime_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumLime, 1);
        ItemStack stackEnergizedHexoriumGreen_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumGreen, 1);
        ItemStack stackEnergizedHexoriumTurquoise_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumTurquoise, 1);
        ItemStack stackEnergizedHexoriumCyan_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumCyan, 1);
        ItemStack stackEnergizedHexoriumSkyBlue_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumSkyBlue, 1);
        ItemStack stackEnergizedHexoriumBlue_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumBlue, 1);
        ItemStack stackEnergizedHexoriumPurple_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumPurple, 1);
        ItemStack stackEnergizedHexoriumMagenta_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumMagenta, 1);
        ItemStack stackEnergizedHexoriumPink_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumPink, 1);
        
        ItemStack stackEnergizedHexoriumWhite_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumWhite, 1);
        ItemStack stackEnergizedHexoriumLightGray_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumLightGray, 1);
        ItemStack stackEnergizedHexoriumGray_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumGray, 1);
        ItemStack stackEnergizedHexoriumDarkGray_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumDarkGray, 1);
        ItemStack stackEnergizedHexoriumBlack_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumBlack, 1);
        
        ItemStack stackEnergizedHexoriumRainbow_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumRainbow, 1);

        // Hexorium Lamp
        ItemStack stackHexoriumLampRed_1 = new ItemStack(HexBlocks.blockHexoriumLampRed, 1);
        ItemStack stackHexoriumLampOrange_1 = new ItemStack(HexBlocks.blockHexoriumLampOrange, 1);
        ItemStack stackHexoriumLampYellow_1 = new ItemStack(HexBlocks.blockHexoriumLampYellow, 1);
        ItemStack stackHexoriumLampLime_1 = new ItemStack(HexBlocks.blockHexoriumLampLime, 1);
        ItemStack stackHexoriumLampGreen_1 = new ItemStack(HexBlocks.blockHexoriumLampGreen, 1);
        ItemStack stackHexoriumLampTurquoise_1 = new ItemStack(HexBlocks.blockHexoriumLampTurquoise, 1);
        ItemStack stackHexoriumLampCyan_1 = new ItemStack(HexBlocks.blockHexoriumLampCyan, 1);
        ItemStack stackHexoriumLampSkyBlue_1 = new ItemStack(HexBlocks.blockHexoriumLampSkyBlue, 1);
        ItemStack stackHexoriumLampBlue_1 = new ItemStack(HexBlocks.blockHexoriumLampBlue, 1);
        ItemStack stackHexoriumLampPurple_1 = new ItemStack(HexBlocks.blockHexoriumLampPurple, 1);
        ItemStack stackHexoriumLampMagenta_1 = new ItemStack(HexBlocks.blockHexoriumLampMagenta, 1);
        ItemStack stackHexoriumLampPink_1 = new ItemStack(HexBlocks.blockHexoriumLampPink, 1);

        ItemStack stackHexoriumLampWhite_1 = new ItemStack(HexBlocks.blockHexoriumLampWhite, 1);
        ItemStack stackHexoriumLampLightGray_1 = new ItemStack(HexBlocks.blockHexoriumLampLightGray, 1);
        ItemStack stackHexoriumLampGray_1 = new ItemStack(HexBlocks.blockHexoriumLampGray, 1);
        ItemStack stackHexoriumLampDarkGray_1 = new ItemStack(HexBlocks.blockHexoriumLampDarkGray, 1);
        ItemStack stackHexoriumLampBlack_1 = new ItemStack(HexBlocks.blockHexoriumLampBlack, 1);

        ItemStack stackHexoriumLampRainbow_1 = new ItemStack(HexBlocks.blockHexoriumLampRainbow, 1);

        // Inverted Hexorium Lamp
        ItemStack stackHexoriumLampInvRed_1 = new ItemStack(HexBlocks.blockHexoriumLampInvRed, 1);
        ItemStack stackHexoriumLampInvOrange_1 = new ItemStack(HexBlocks.blockHexoriumLampInvOrange, 1);
        ItemStack stackHexoriumLampInvYellow_1 = new ItemStack(HexBlocks.blockHexoriumLampInvYellow, 1);
        ItemStack stackHexoriumLampInvLime_1 = new ItemStack(HexBlocks.blockHexoriumLampInvLime, 1);
        ItemStack stackHexoriumLampInvGreen_1 = new ItemStack(HexBlocks.blockHexoriumLampInvGreen, 1);
        ItemStack stackHexoriumLampInvTurquoise_1 = new ItemStack(HexBlocks.blockHexoriumLampInvTurquoise, 1);
        ItemStack stackHexoriumLampInvCyan_1 = new ItemStack(HexBlocks.blockHexoriumLampInvCyan, 1);
        ItemStack stackHexoriumLampInvSkyBlue_1 = new ItemStack(HexBlocks.blockHexoriumLampInvSkyBlue, 1);
        ItemStack stackHexoriumLampInvBlue_1 = new ItemStack(HexBlocks.blockHexoriumLampInvBlue, 1);
        ItemStack stackHexoriumLampInvPurple_1 = new ItemStack(HexBlocks.blockHexoriumLampInvPurple, 1);
        ItemStack stackHexoriumLampInvMagenta_1 = new ItemStack(HexBlocks.blockHexoriumLampInvMagenta, 1);
        ItemStack stackHexoriumLampInvPink_1 = new ItemStack(HexBlocks.blockHexoriumLampInvPink, 1);

        ItemStack stackHexoriumLampInvWhite_1 = new ItemStack(HexBlocks.blockHexoriumLampInvWhite, 1);
        ItemStack stackHexoriumLampInvLightGray_1 = new ItemStack(HexBlocks.blockHexoriumLampInvLightGray, 1);
        ItemStack stackHexoriumLampInvGray_1 = new ItemStack(HexBlocks.blockHexoriumLampInvGray, 1);
        ItemStack stackHexoriumLampInvDarkGray_1 = new ItemStack(HexBlocks.blockHexoriumLampInvDarkGray, 1);
        ItemStack stackHexoriumLampInvBlack_1 = new ItemStack(HexBlocks.blockHexoriumLampInvBlack, 1);

        ItemStack stackHexoriumLampInvRainbow_1 = new ItemStack(HexBlocks.blockHexoriumLampInvRainbow, 1);

        // Hexorium Door
        ItemStack stackHexoriumDoorRed_1 = new ItemStack(HexBlocks.blockHexoriumDoorRed, 1);
        ItemStack stackHexoriumDoorOrange_1 = new ItemStack(HexBlocks.blockHexoriumDoorOrange, 1);
        ItemStack stackHexoriumDoorYellow_1 = new ItemStack(HexBlocks.blockHexoriumDoorYellow, 1);
        ItemStack stackHexoriumDoorLime_1 = new ItemStack(HexBlocks.blockHexoriumDoorLime, 1);
        ItemStack stackHexoriumDoorGreen_1 = new ItemStack(HexBlocks.blockHexoriumDoorGreen, 1);
        ItemStack stackHexoriumDoorTurquoise_1 = new ItemStack(HexBlocks.blockHexoriumDoorTurquoise, 1);
        ItemStack stackHexoriumDoorCyan_1 = new ItemStack(HexBlocks.blockHexoriumDoorCyan, 1);
        ItemStack stackHexoriumDoorSkyBlue_1 = new ItemStack(HexBlocks.blockHexoriumDoorSkyBlue, 1);
        ItemStack stackHexoriumDoorBlue_1 = new ItemStack(HexBlocks.blockHexoriumDoorBlue, 1);
        ItemStack stackHexoriumDoorPurple_1 = new ItemStack(HexBlocks.blockHexoriumDoorPurple, 1);
        ItemStack stackHexoriumDoorMagenta_1 = new ItemStack(HexBlocks.blockHexoriumDoorMagenta, 1);
        ItemStack stackHexoriumDoorPink_1 = new ItemStack(HexBlocks.blockHexoriumDoorPink, 1);

        ItemStack stackHexoriumDoorWhite_1 = new ItemStack(HexBlocks.blockHexoriumDoorWhite, 1);
        ItemStack stackHexoriumDoorLightGray_1 = new ItemStack(HexBlocks.blockHexoriumDoorLightGray, 1);
        ItemStack stackHexoriumDoorGray_1 = new ItemStack(HexBlocks.blockHexoriumDoorGray, 1);
        ItemStack stackHexoriumDoorDarkGray_1 = new ItemStack(HexBlocks.blockHexoriumDoorDarkGray, 1);
        ItemStack stackHexoriumDoorBlack_1 = new ItemStack(HexBlocks.blockHexoriumDoorBlack, 1);

        ItemStack stackHexoriumDoorRainbow_1 = new ItemStack(HexBlocks.blockHexoriumDoorRainbow, 1);

        // Hexorium Hatch
        ItemStack stackHexoriumHatchRed_2 = new ItemStack(HexBlocks.blockHexoriumHatchRed, 2);
        ItemStack stackHexoriumHatchOrange_2 = new ItemStack(HexBlocks.blockHexoriumHatchOrange, 2);
        ItemStack stackHexoriumHatchYellow_2 = new ItemStack(HexBlocks.blockHexoriumHatchYellow, 2);
        ItemStack stackHexoriumHatchLime_2 = new ItemStack(HexBlocks.blockHexoriumHatchLime, 2);
        ItemStack stackHexoriumHatchGreen_2 = new ItemStack(HexBlocks.blockHexoriumHatchGreen, 2);
        ItemStack stackHexoriumHatchTurquoise_2 = new ItemStack(HexBlocks.blockHexoriumHatchTurquoise, 2);
        ItemStack stackHexoriumHatchCyan_2 = new ItemStack(HexBlocks.blockHexoriumHatchCyan, 2);
        ItemStack stackHexoriumHatchSkyBlue_2 = new ItemStack(HexBlocks.blockHexoriumHatchSkyBlue, 2);
        ItemStack stackHexoriumHatchBlue_2 = new ItemStack(HexBlocks.blockHexoriumHatchBlue, 2);
        ItemStack stackHexoriumHatchPurple_2 = new ItemStack(HexBlocks.blockHexoriumHatchPurple, 2);
        ItemStack stackHexoriumHatchMagenta_2 = new ItemStack(HexBlocks.blockHexoriumHatchMagenta, 2);
        ItemStack stackHexoriumHatchPink_2 = new ItemStack(HexBlocks.blockHexoriumHatchPink, 2);

        ItemStack stackHexoriumHatchWhite_2 = new ItemStack(HexBlocks.blockHexoriumHatchWhite, 2);
        ItemStack stackHexoriumHatchLightGray_2 = new ItemStack(HexBlocks.blockHexoriumHatchLightGray, 2);
        ItemStack stackHexoriumHatchGray_2 = new ItemStack(HexBlocks.blockHexoriumHatchGray, 2);
        ItemStack stackHexoriumHatchDarkGray_2 = new ItemStack(HexBlocks.blockHexoriumHatchDarkGray, 2);
        ItemStack stackHexoriumHatchBlack_2 = new ItemStack(HexBlocks.blockHexoriumHatchBlack, 2);

        ItemStack stackHexoriumHatchRainbow_2 = new ItemStack(HexBlocks.blockHexoriumHatchRainbow, 2);

        // Machines
        ItemStack stackHexoriumMachineBlock_1 = new ItemStack(HexBlocks.blockHexoriumMachineBlock, 1);
        ItemStack stackAdvancedRainbowCore_1 = new ItemStack(HexBlocks.blockAdvancedRainbowCore, 1);

        ItemStack stackHexoriumGenerator_1 = new ItemStack(HexBlocks.blockHexoriumGenerator, 1);
        ItemStack stackHexoriumFurnace_1 = new ItemStack(HexBlocks.blockHexoriumFurnace, 1);
        ItemStack stackCrystalSeparator_1 = new ItemStack(HexBlocks.blockCrystalSeparator, 1);
        ItemStack stackMatrixReconstructor_1 = new ItemStack(HexBlocks.blockMatrixReconstructor, 1);

        ItemStack stackPersonalTeleportationPad_1 = new ItemStack(HexBlocks.blockPersonalTeleportationPad, 1);

        ItemStack stackQuantumObserver_1 = new ItemStack(HexBlocks.blockQuantumObserver, 1);
        ItemStack stackQuantumAnchor_1 = new ItemStack(HexBlocks.blockQuantumAnchor, 1);

        // Tank Valve
        ItemStack stackTankValve_1 = new ItemStack(HexBlocks.blockTankValve, 1);

        // Energy Node
        ItemStack stackEnergyNodeCoreT1_1 = new ItemStack(HexBlocks.blockEnergyNodeCoreT1, 1);
        ItemStack stackEnergyNodeCoreT2_1 = new ItemStack(HexBlocks.blockEnergyNodeCoreT2, 1);
        ItemStack stackEnergyNodeCoreT3_1 = new ItemStack(HexBlocks.blockEnergyNodeCoreT3, 1);
        ItemStack stackEnergyNodeCoreT4_1 = new ItemStack(HexBlocks.blockEnergyNodeCoreT4, 1);

        ItemStack stackEnergyNodePortHEX_1 = new ItemStack(HexBlocks.blockEnergyNodePortHEX, 1);
        ItemStack stackEnergyNodePortRF_1 = new ItemStack(HexBlocks.blockEnergyNodePortRF, 1);
        ItemStack stackEnergyNodePortEU_1 = new ItemStack(HexBlocks.blockEnergyNodePortEU, 1);

        // Cables
        ItemStack stackHexoriumCableRed_4 = new ItemStack(HexBlocks.blockHexoriumCableRed, 4);
        ItemStack stackHexoriumCableOrange_4 = new ItemStack(HexBlocks.blockHexoriumCableOrange, 4);
        ItemStack stackHexoriumCableYellow_4 = new ItemStack(HexBlocks.blockHexoriumCableYellow, 4);
        ItemStack stackHexoriumCableLime_4 = new ItemStack(HexBlocks.blockHexoriumCableLime, 4);
        ItemStack stackHexoriumCableGreen_4 = new ItemStack(HexBlocks.blockHexoriumCableGreen, 4);
        ItemStack stackHexoriumCableTurquoise_4 = new ItemStack(HexBlocks.blockHexoriumCableTurquoise, 4);
        ItemStack stackHexoriumCableCyan_4 = new ItemStack(HexBlocks.blockHexoriumCableCyan, 4);
        ItemStack stackHexoriumCableSkyBlue_4 = new ItemStack(HexBlocks.blockHexoriumCableSkyBlue, 4);
        ItemStack stackHexoriumCableBlue_4 = new ItemStack(HexBlocks.blockHexoriumCableBlue, 4);
        ItemStack stackHexoriumCablePurple_4 = new ItemStack(HexBlocks.blockHexoriumCablePurple, 4);
        ItemStack stackHexoriumCableMagenta_4 = new ItemStack(HexBlocks.blockHexoriumCableMagenta, 4);
        ItemStack stackHexoriumCablePink_4 = new ItemStack(HexBlocks.blockHexoriumCablePink, 4);

        ItemStack stackHexoriumCableWhite_4 = new ItemStack(HexBlocks.blockHexoriumCableWhite, 4);
        ItemStack stackHexoriumCableLightGray_4 = new ItemStack(HexBlocks.blockHexoriumCableLightGray, 4);
        ItemStack stackHexoriumCableGray_4 = new ItemStack(HexBlocks.blockHexoriumCableGray, 4);
        ItemStack stackHexoriumCableDarkGray_4 = new ItemStack(HexBlocks.blockHexoriumCableDarkGray, 4);
        ItemStack stackHexoriumCableBlack_4 = new ItemStack(HexBlocks.blockHexoriumCableBlack, 4);

        ItemStack stackHexoriumCableRainbow_1 = new ItemStack(HexBlocks.blockHexoriumCableRainbow, 1);
        ItemStack stackHexoriumCableRainbow_4 = new ItemStack(HexBlocks.blockHexoriumCableRainbow, 4);

        // Energy Pylon
        ItemStack stackEnergyPylon_1 = new ItemStack(HexBlocks.blockEnergyPylon, 1);

        // Hexorium Switch
        ItemStack stackHexoriumSwitchRedGreen_1 = new ItemStack(HexBlocks.blockHexoriumSwitchRedGreen, 1);
        ItemStack stackHexoriumSwitchRedBlue_1 = new ItemStack(HexBlocks.blockHexoriumSwitchRedBlue, 1);
        ItemStack stackHexoriumSwitchRedWhite_1 = new ItemStack(HexBlocks.blockHexoriumSwitchRedWhite, 1);
        ItemStack stackHexoriumSwitchBlueGreen_1 = new ItemStack(HexBlocks.blockHexoriumSwitchBlueGreen, 1);

        // Hexorium Button
        ItemStack stackHexoriumButtonRed_1 = new ItemStack(HexBlocks.blockHexoriumButtonRed, 1);
        ItemStack stackHexoriumButtonGreen_1 = new ItemStack(HexBlocks.blockHexoriumButtonGreen, 1);
        ItemStack stackHexoriumButtonBlue_1 = new ItemStack(HexBlocks.blockHexoriumButtonBlue, 1);
        ItemStack stackHexoriumButtonWhite_1 = new ItemStack(HexBlocks.blockHexoriumButtonWhite, 1);

        // Hexorium Pressure Plate
        ItemStack stackHexoriumPressurePlateRed_1 = new ItemStack(HexBlocks.blockHexoriumPressurePlateRed, 1);
        ItemStack stackHexoriumPressurePlateGreen_1 = new ItemStack(HexBlocks.blockHexoriumPressurePlateGreen, 1);
        ItemStack stackHexoriumPressurePlateBlue_1 = new ItemStack(HexBlocks.blockHexoriumPressurePlateBlue, 1);
        ItemStack stackHexoriumPressurePlateWhite_1 = new ItemStack(HexBlocks.blockHexoriumPressurePlateWhite, 1);

        // Regular Blocks
        ItemStack stackTemperedHexoriumGlass_1 = new ItemStack(HexBlocks.blockTemperedHexoriumGlass, 1);
        ItemStack stackTemperedHexoriumGlass_4 = new ItemStack(HexBlocks.blockTemperedHexoriumGlass, 4);
        ItemStack stackHexoriumCoatedStone_8 = new ItemStack(HexBlocks.blockHexoriumCoatedStone, 8);
        ItemStack stackHexoriumCoatedStone_1 = new ItemStack(HexBlocks.blockHexoriumCoatedStone, 1);

        ItemStack stackPylonBase51_1 = new ItemStack(HexBlocks.blockPylonBase51, 1);
        ItemStack stackPylonBase15_1 = new ItemStack(HexBlocks.blockPylonBase15, 1);

        ItemStack stackSoundProjector_1 = new ItemStack(HexBlocks.blockSoundProjector, 1);

        // Hex Items
        // Raw Materials
        ItemStack stackHexoriumCrystalRed_1 = new ItemStack(HexItems.itemHexoriumCrystalRed, 1);
        ItemStack stackHexoriumCrystalGreen_1 = new ItemStack(HexItems.itemHexoriumCrystalGreen, 1);
        ItemStack stackHexoriumCrystalBlue_1 = new ItemStack(HexItems.itemHexoriumCrystalBlue, 1);
        ItemStack stackHexoriumCrystalWhite_1 = new ItemStack(HexItems.itemHexoriumCrystalWhite, 1);
        ItemStack stackHexoriumCrystalBlack_1 = new ItemStack(HexItems.itemHexoriumCrystalBlack, 1);
        ItemStack stackHexoriumCrystalRed_9 = new ItemStack(HexItems.itemHexoriumCrystalRed, 9);
        ItemStack stackHexoriumCrystalGreen_9 = new ItemStack(HexItems.itemHexoriumCrystalGreen, 9);
        ItemStack stackHexoriumCrystalBlue_9 = new ItemStack(HexItems.itemHexoriumCrystalBlue, 9);
        ItemStack stackHexoriumCrystalWhite_9 = new ItemStack(HexItems.itemHexoriumCrystalWhite, 9);
        ItemStack stackHexoriumCrystalBlack_9 = new ItemStack(HexItems.itemHexoriumCrystalBlack, 9);

        // Components T1
        ItemStack stackIronNugget_9 = new ItemStack(HexItems.itemIronNugget, 9);
        ItemStack stackRainbowEnergizedGlobule_1 = new ItemStack(HexItems.itemRainbowEnergizedGlobule, 1);
        ItemStack stackWhiteHexoriumWafer_1 = new ItemStack(HexItems.itemWhiteHexoriumWafer, 1);
        ItemStack stackBlackHexoriumWafer_1 = new ItemStack(HexItems.itemBlackHexoriumWafer, 1);
        ItemStack stackSpatialProjector_1 = new ItemStack(HexItems.itemSpatialProjector, 1);
        ItemStack stackOreActuator_1 = new ItemStack(HexItems.itemOreActuator, 1);
        ItemStack stackPylonSocket_1 = new ItemStack(HexItems.itemPylonSocket, 1);
        ItemStack stackHexoriumGlassPackage_1 = new ItemStack(HexItems.itemHexoriumGlassPackage, 1);

        // Components T2
        ItemStack stackRainbowCore_1 = new ItemStack(HexItems.itemRainbowCore, 1);
        ItemStack stackHexoriumCoprocessor_1 = new ItemStack(HexItems.itemHexoriumCoprocessor, 1);
        ItemStack stackHexoriumProcessor_1 = new ItemStack(HexItems.itemHexoriumProcessor, 1);
        ItemStack stackMineralAnalyzer_1 = new ItemStack(HexItems.itemMineralAnalyzer, 1);
        ItemStack stackHexoriumEnergyConverter_1 = new ItemStack(HexItems.itemHexoriumEnergyConverter, 1);
        ItemStack stackEnergyInjector_1 = new ItemStack(HexItems.itemEnergyInjector, 1);
        ItemStack stackMolecularRecoder_1 = new ItemStack(HexItems.itemMolecularRecoder, 1);
        ItemStack stackHexoriumRFAdapter_1 = new ItemStack(HexItems.itemHexoriumRFAdapter, 1);

        // Components MP
        ItemStack stackMachineControlPanel_1 = new ItemStack(HexItems.itemMachineControlPanel, 1);
        ItemStack stackMachineEnergyRouter_1 = new ItemStack(HexItems.itemMachineEnergyRouter, 1);
        ItemStack stackHeatDissipator_1 = new ItemStack(HexItems.itemHeatDissipator, 1);
        ItemStack stackHeatingArray_1 = new ItemStack(HexItems.itemHeatingArray, 1);
        ItemStack stackCrystalExtractionUnit_1 = new ItemStack(HexItems.itemCrystalExtractionUnit, 1);
        ItemStack stackMatrixAdjuster_1 = new ItemStack(HexItems.itemMatrixAdjuster, 1);
        ItemStack stackMaterialInteractionPlane_1 = new ItemStack(HexItems.itemMaterialInteractionPlane, 1);
        ItemStack stackTeleportationFieldProjector_1 = new ItemStack(HexItems.itemTeleportationFieldProjector, 1);
        ItemStack stackObservationalEye_1 = new ItemStack(HexItems.itemObservationalEye, 1);
        ItemStack stackDigitalSmartpipe_1 = new ItemStack(HexItems.itemDigitalSmartpipe, 1);
        ItemStack stackSoundEmissionModule_1 = new ItemStack(HexItems.itemSoundEmissionModule, 1);

        // Tools
        ItemStack stackHexoriumManipulator_1 = new ItemStack(HexItems.itemHexoriumManipulator, 1);
        ItemStack stackHexoriumProbe_1 = new ItemStack(HexItems.itemHexoriumProbe, 1);
        ItemStack stackMolecularTransposer_1 = new ItemStack(HexItems.itemMolecularTransposer, 1);
        ItemStack stackHexoriumReinforcer_12 = new ItemStack(HexItems.itemHexoriumReinforcer, 12);
        ItemStack stackMortarPestle_1 = new ItemStack(HexItems.itemMortarPestle, 1);
        
        // Dyes
        ItemStack stackHexoriumDyeBlack_1 = new ItemStack(HexItems.itemHexoriumDyeBlack, 1);
        ItemStack stackHexoriumDyeBlack_16 = new ItemStack(HexItems.itemHexoriumDyeBlack, 16);
        ItemStack stackHexoriumDyeWhite_1 = new ItemStack(HexItems.itemHexoriumDyeWhite, 1);
        ItemStack stackHexoriumDyeWhite_16 = new ItemStack(HexItems.itemHexoriumDyeWhite, 16);

        // Misc
        ItemStack stackEnergizedHexoriumMonolithBlack_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithBlack, 1);


        /* Recipe init */

        // Hex Blocks
        BlockOfHexoriumCrystal.registerRecipes();

        BlockEnergizedHexorium.registerRecipes();

        BlockEngineeredHexoriumBlock.registerRecipes();
        BlockFramedHexoriumBlock.registerRecipes();
        BlockPlatedHexoriumBlock.registerRecipes();
        BlockConcentricHexoriumBlock.registerRecipes();
        BlockHexoriumStructureCasing.registerRecipes();
        BlockGlowingHexoriumCoatedStone.registerRecipes();
        BlockGlowingHexoriumGlass.registerRecipes();
        BlockHexoriumLamp.registerRecipes();
        BlockHexoriumLampInv.registerRecipes();

        // Hexorium Door
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorRed_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumRed_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorOrange_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumOrange_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorYellow_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumYellow_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorLime_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumLime_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorGreen_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumGreen_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorTurquoise_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumTurquoise_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorCyan_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumCyan_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorSkyBlue_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumSkyBlue_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorBlue_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumBlue_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorPurple_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumPurple_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorMagenta_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumMagenta_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorPink_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumPink_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorWhite_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumWhite_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorLightGray_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumLightGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorGray_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorDarkGray_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumDarkGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorBlack_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumBlack_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorRainbow_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumRainbow_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));

        // Hexorium Hatch
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchRed_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumRed_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchOrange_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumOrange_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchYellow_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumYellow_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchLime_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumLime_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchGreen_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumGreen_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchTurquoise_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumTurquoise_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchCyan_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumCyan_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchSkyBlue_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumSkyBlue_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchBlue_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumBlue_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchPurple_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumPurple_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchMagenta_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumMagenta_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchPink_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumPink_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchWhite_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumWhite_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchLightGray_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumLightGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchGray_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchDarkGray_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumDarkGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchBlack_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumBlack_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchRainbow_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumRainbow_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));

        // Machines
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumMachineBlock_1,
                "C C",
                "RAR",
                "CBC",
                'R', stackRedstone_1, 'A', stackEnergizedHexoriumWhite_1, 'B', stackSpatialProjector_1, 'C', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackAdvancedRainbowCore_1,
                "BRB",
                "RAR",
                "BRB",
                'R', stackRedstone_1, 'A', stackEnergizedHexoriumRainbow_1, 'B', "ingotGold"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumGenerator_1,
                "EBE",
                "DAD",
                "ECE",
                'A', stackHexoriumMachineBlock_1, 'B', stackMachineControlPanel_1, 'C', stackMachineEnergyRouter_1, 'D', stackHeatDissipator_1, 'E', "ingotIron"));

        if (HexConfig.cfgFurnaceEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumFurnace_1,
                    "EBE",
                    "DAD",
                    "ECE",
                    'A', stackHexoriumMachineBlock_1, 'B', stackMachineControlPanel_1, 'C', stackMachineEnergyRouter_1, 'D', stackHeatingArray_1, 'E', "ingotIron"));
        }

        if (HexConfig.cfgSeparatorEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackCrystalSeparator_1,
                    "EBE",
                    "DAD",
                    "ECE",
                    'A', stackHexoriumMachineBlock_1, 'B', stackMachineControlPanel_1, 'C', stackMachineEnergyRouter_1, 'D', stackCrystalExtractionUnit_1, 'E', "ingotIron"));
        }

        GameRegistry.addRecipe(new ShapedOreRecipe(stackMatrixReconstructor_1,
                "EBE",
                "DAD",
                "ECE",
                'A', stackHexoriumMachineBlock_1, 'B', stackMachineControlPanel_1, 'C', stackMachineEnergyRouter_1, 'D', stackMatrixAdjuster_1, 'E', "ingotIron"));

        if (HexConfig.cfgTeleportEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackPersonalTeleportationPad_1,
                    "DED",
                    "BAC",
                    "FCF",
                    'A', stackHexoriumMachineBlock_1, 'B', stackMolecularRecoder_1, 'C', stackMachineEnergyRouter_1, 'D', stackTeleportationFieldProjector_1,
                    'E', stackMaterialInteractionPlane_1, 'F', "ingotIron"));
        }

        if (HexConfig.cfgObserverEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackQuantumObserver_1,
                    "CBF",
                    "FAF",
                    "EDE",
                    'A', stackObservationalEye_1, 'B', stackMachineEnergyRouter_1, 'C', stackMachineControlPanel_1, 'D', stackEnergizedHexoriumBlack_1,
                    'E', stackIronBars_1, 'F', "ingotIron"));
            GameRegistry.addRecipe(new ShapedOreRecipe(stackQuantumAnchor_1,
                    "B B",
                    "BAB",
                    "B B",
                    'A', stackEnergizedHexoriumBlack_1, 'B', stackIronBars_1));
        }

        // Tank Valve
        if (HexConfig.cfgTankEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackTankValve_1,
                    "ECE",
                    "BAB",
                    "EDE",
                    'A', stackHexoriumMachineBlock_1, 'B', stackDigitalSmartpipe_1, 'C', stackMachineControlPanel_1, 'D', stackRainbowCore_1,
                    'E', "ingotIron"));
        }

        // Energy Node
        if (HexConfig.cfgEnergyNodeEnable) {
            GameRegistry.addRecipe(stackEnergyNodeCoreT1_1,
                    "RBR",
                    "BAB",
                    "RBR",
                    'R', stackRedstoneBlock_1, 'A', stackAdvancedRainbowCore_1, 'B', stackHexoriumProcessor_1);
            GameRegistry.addRecipe(new ShapedOreRecipe(stackEnergyNodeCoreT2_1,
                    "RBR",
                    "BAB",
                    "RBR",
                    'R', stackRedstoneBlock_1, 'A', stackEnergyNodeCoreT1_1, 'B', "ingotIron"));
            GameRegistry.addRecipe(new ShapedOreRecipe(stackEnergyNodeCoreT3_1,
                    "RBR",
                    "BAB",
                    "RBR",
                    'R', stackRedstoneBlock_1, 'A', stackEnergyNodeCoreT2_1, 'B', "ingotGold"));
            GameRegistry.addRecipe(new ShapedOreRecipe(stackEnergyNodeCoreT4_1,
                    "RBR",
                    "BAB",
                    "RBR",
                    'R', stackRedstoneBlock_1, 'A', stackEnergyNodeCoreT3_1, 'B', "gemDiamond"));

            GameRegistry.addRecipe(new ShapedOreRecipe(stackEnergyNodePortHEX_1,
                    "EBE",
                    "DAR",
                    "ECE",
                    'R', stackRedstoneBlock_1, 'A', stackEnergizedHexoriumRainbow_1, 'B', stackMachineControlPanel_1,
                    'C', stackHexoriumEnergyConverter_1, 'D', stackHexoriumCableRainbow_1, 'E', "ingotIron"));
            if (HexConfig.cfgEnergyNodePortsRFEnable) {
                GameRegistry.addRecipe(new ShapedOreRecipe(stackEnergyNodePortRF_1,
                        "EBE",
                        "DAR",
                        "ECE",
                        'R', stackRedstoneBlock_1, 'A', stackEnergizedHexoriumRainbow_1, 'B', stackMachineControlPanel_1,
                        'C', stackHexoriumRFAdapter_1, 'D', "ingotGold", 'E', "ingotIron"));
            }
            if (Loader.isModLoaded("IC2") && HexConfig.cfgEnergyNodePortsEUEnable) {
                ItemStack stackAdvancedCircuit_1 = IC2Items.getItem("advancedCircuit");
                ItemStack stackInsulatedGoldCable_1 = IC2Items.getItem("insulatedGoldCableItem");
                if (stackAdvancedCircuit_1 != null && stackInsulatedGoldCable_1 != null)
                    GameRegistry.addRecipe(new ShapedOreRecipe(stackEnergyNodePortEU_1,
                            "EBE",
                            "DAR",
                            "ECE",
                            'R', stackRedstoneBlock_1, 'A', stackEnergizedHexoriumRainbow_1, 'B', stackMachineControlPanel_1,
                            'C', stackAdvancedCircuit_1, 'D', stackInsulatedGoldCable_1, 'E', "ingotIron"));
            }
        }

        // Cables
        // Red
        GameRegistry.addRecipe(stackHexoriumCableRed_4,
                " R ",
                "AEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);

        // Orange
        GameRegistry.addRecipe(stackHexoriumCableOrange_4,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableOrange_4,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableOrange_4,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableOrange_4,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);

        // Yellow
        GameRegistry.addRecipe(stackHexoriumCableYellow_4,
                " R ",
                "BEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableYellow_4,
                " R ",
                "AEB",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);

        // Lime
        GameRegistry.addRecipe(stackHexoriumCableLime_4,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableLime_4,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableLime_4,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableLime_4,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);

        // Green
        GameRegistry.addRecipe(stackHexoriumCableGreen_4,
                " R ",
                "AEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);

        // Turquoise
        GameRegistry.addRecipe(stackHexoriumCableTurquoise_4,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableTurquoise_4,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableTurquoise_4,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableTurquoise_4,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);

        // Cyan
        GameRegistry.addRecipe(stackHexoriumCableCyan_4,
                " R ",
                "BEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableCyan_4,
                " R ",
                "AEB",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);

        // SkyBlue
        GameRegistry.addRecipe(stackHexoriumCableSkyBlue_4,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableSkyBlue_4,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableSkyBlue_4,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableSkyBlue_4,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);

        // Blue
        GameRegistry.addRecipe(stackHexoriumCableBlue_4,
                " R ",
                "AEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);

        // Purple
        GameRegistry.addRecipe(stackHexoriumCablePurple_4,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCablePurple_4,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCablePurple_4,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCablePurple_4,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);

        // Magenta
        GameRegistry.addRecipe(stackHexoriumCableMagenta_4,
                " R ",
                "BEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableMagenta_4,
                " R ",
                "AEB",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);

        // Pink
        GameRegistry.addRecipe(stackHexoriumCablePink_4,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCablePink_4,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCablePink_4,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCablePink_4,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);

        // White
        GameRegistry.addRecipe(stackHexoriumCableWhite_4,
                " R ",
                "AEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'E', stackTemperedHexoriumGlass_1);

        // LightGray
        GameRegistry.addRecipe(stackHexoriumCableLightGray_4,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableLightGray_4,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableLightGray_4,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableLightGray_4,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);

        // Gray
        GameRegistry.addRecipe(stackHexoriumCableGray_4,
                " R ",
                "BEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableGray_4,
                " R ",
                "AEB",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);

        // DarkGray
        GameRegistry.addRecipe(stackHexoriumCableDarkGray_4,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableDarkGray_4,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableDarkGray_4,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableDarkGray_4,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1, 'E', stackTemperedHexoriumGlass_1);

        // Black
        GameRegistry.addRecipe(stackHexoriumCableBlack_4,
                " R ",
                "AEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);
        
        // Rainbow
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "AEB",
                "CED",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "AEB",
                "DEC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "AEC",
                "BED",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "AEC",
                "DEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "AED",
                "BEC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "AED",
                "CEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "BEA",
                "CED",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "BEA",
                "DEC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "BEC",
                "AED",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "BEC",
                "DEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "BED",
                "AEC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "BED",
                "CEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "CEA",
                "BED",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "CEA",
                "DEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "CEB",
                "AED",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "CEB",
                "DEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "CED",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "CED",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "DEA",
                "BEC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "DEA",
                "CEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "DEB",
                "AEC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "DEB",
                "CEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "DEC",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "DEC",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);

        // Energy Pylon
        GameRegistry.addRecipe(new ShapedOreRecipe(stackEnergyPylon_1,
                "   ",
                "RBR",
                "CAC",
                'R', stackRedstone_1, 'A', stackPylonSocket_1, 'B', stackEnergyInjector_1, 'C', "ingotIron"));

        // Hexorium Switch
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumSwitchRedGreen_1,
                "ARB",
                "CDC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', "nuggetIron", 'D', stackLever_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumSwitchRedBlue_1,
                "ARB",
                "CDC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1, 'C', "nuggetIron", 'D', stackLever_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumSwitchRedWhite_1,
                "ARB",
                "CDC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalWhite_1, 'C', "nuggetIron", 'D', stackLever_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumSwitchBlueGreen_1,
                "ARB",
                "CDC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1, 'C', "nuggetIron", 'D', stackLever_1));

        // Hexorium Button
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumButtonRed_1,
                " A ",
                "BRB",
                " C ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', "nuggetIron", 'C', stackStoneButton_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumButtonGreen_1,
                " A ",
                "BRB",
                " C ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', "nuggetIron", 'C', stackStoneButton_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumButtonBlue_1,
                " A ",
                "BRB",
                " C ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', "nuggetIron", 'C', stackStoneButton_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumButtonWhite_1,
                " A ",
                "BRB",
                " C ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', "nuggetIron", 'C', stackStoneButton_1));

        // Hexorium Pressure Plate
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumPressurePlateRed_1,
                "ARA",
                "BCB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', "nuggetIron", 'C', stackHeavyWeightedPressurePlate_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumPressurePlateGreen_1,
                "ARA",
                "BCB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', "nuggetIron", 'C', stackHeavyWeightedPressurePlate_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumPressurePlateBlue_1,
                "ARA",
                "BCB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', "nuggetIron", 'C', stackHeavyWeightedPressurePlate_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumPressurePlateWhite_1,
                "ARA",
                "BCB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', "nuggetIron", 'C', stackHeavyWeightedPressurePlate_1));

        // Regular Blocks
        GameRegistry.addSmelting(stackHexoriumGlassPackage_1, stackTemperedHexoriumGlass_4, 0F);

        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumCoatedStone_8,
                "BBB",
                "BAB",
                "BBB",
                'A', stackHexoriumCrystalRed_1, 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumCoatedStone_8,
                "BBB",
                "BAB",
                "BBB",
                'A', stackHexoriumCrystalGreen_1, 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumCoatedStone_8,
                "BBB",
                "BAB",
                "BBB",
                'A', stackHexoriumCrystalBlue_1, 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumCoatedStone_8,
                "BBB",
                "BAB",
                "BBB",
                'A', stackHexoriumCrystalWhite_1, 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumCoatedStone_8,
                "BBB",
                "BAB",
                "BBB",
                'A', stackHexoriumCrystalBlack_1, 'B', "stone"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackPylonBase51_1,
                "DAD",
                "ABA",
                "DCD",
                'A', stackHexoriumCableRainbow_1, 'B', stackHexoriumEnergyConverter_1, 'C', stackPylonSocket_1, 'D', "ingotIron"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackPylonBase15_1,
                "DCD",
                "CBC",
                "DAD",
                'A', stackHexoriumCableRainbow_1, 'B', stackHexoriumEnergyConverter_1, 'C', stackPylonSocket_1, 'D', "ingotIron"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackSoundProjector_1,
                "DRD",
                "ABC",
                "DRD",
                'R', stackRedstone_1, 'A', stackMachineControlPanel_1, 'B', stackRainbowCore_1, 'C', stackSoundEmissionModule_1, 'D', "ingotIron"));

        // Hex Items
        // Components T1
        GameRegistry.addRecipe(new ShapedOreRecipe(Items.iron_ingot,
                "NNN",
                "NNN",
                "NNN",
                'N', "nuggetIron"));

        GameRegistry.addRecipe(new ShapelessOreRecipe(stackIronNugget_9,
                "ingotIron"));

        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " B ",
                "ARC",
                " D ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " B ",
                "ARD",
                " C ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " C ",
                "ARB",
                " D ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " C ",
                "ARD",
                " B ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " D ",
                "ARB",
                " C ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " D ",
                "ARC",
                " B ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " A ",
                "BRC",
                " D ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " A ",
                "BRD",
                " C ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " C ",
                "BRA",
                " D ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " C ",
                "BRD",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " D ",
                "BRA",
                " C ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " D ",
                "BRC",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " A ",
                "CRB",
                " D ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " A ",
                "CRD",
                " B ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " B ",
                "CRA",
                " D ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " B ",
                "CRD",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " D ",
                "CRA",
                " B ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " D ",
                "CRB",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " A ",
                "DRB",
                " C ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " A ",
                "DRC",
                " B ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " B ",
                "DRA",
                " C ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " B ",
                "DRC",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " C ",
                "DRA",
                " B ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " C ",
                "DRB",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);

        GameRegistry.addSmelting(stackHexoriumCrystalWhite_1, stackWhiteHexoriumWafer_1, 0F);
        GameRegistry.addSmelting(stackHexoriumCrystalBlack_1, stackBlackHexoriumWafer_1, 0F);
        GameRegistry.addRecipe(new ShapedOreRecipe(stackSpatialProjector_1,
                "BAB",
                " B ",
                " R ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', "nuggetIron"));
        if (HexConfig.cfgSeparatorEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackOreActuator_1,
                    "B  ",
                    "ABR",
                    "B  ",
                    'R', stackRedstone_1, 'A', stackIronPickaxe_1, 'B', "nuggetIron"));
        }
        GameRegistry.addRecipe(new ShapedOreRecipe(stackPylonSocket_1,
                "BAB",
                "RRR",
                'R', stackRedstone_1, 'A', stackHexoriumCableRainbow_1, 'B', "nuggetIron"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumGlassPackage_1,
                "BCB",
                "CAC",
                "BCB",
                'A', stackHexoriumCrystalRed_1, 'B', "nuggetIron", 'C', "glass"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumGlassPackage_1,
                "BCB",
                "CAC",
                "BCB",
                'A', stackHexoriumCrystalGreen_1, 'B', "nuggetIron", 'C', "glass"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumGlassPackage_1,
                "BCB",
                "CAC",
                "BCB",
                'A', stackHexoriumCrystalBlue_1, 'B', "nuggetIron", 'C', "glass"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumGlassPackage_1,
                "BCB",
                "CAC",
                "BCB",
                'A', stackHexoriumCrystalWhite_1, 'B', "nuggetIron", 'C', "glass"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumGlassPackage_1,
                "BCB",
                "CAC",
                "BCB",
                'A', stackHexoriumCrystalBlack_1, 'B', "nuggetIron", 'C', "glass"));

        // Components T2
        GameRegistry.addRecipe(new ShapedOreRecipe(stackRainbowCore_1,
                " R ",
                "BAB",
                " R ",
                'R', stackRedstone_1, 'A', stackRainbowEnergizedGlobule_1, 'B', "nuggetGold"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumCoprocessor_1,
                " R ",
                "RAR",
                "BBB",
                'R', stackRedstone_1, 'A', stackWhiteHexoriumWafer_1, 'B', "nuggetIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumProcessor_1,
                " R ",
                "RAR",
                "BBB",
                'R', stackRedstone_1, 'A', stackBlackHexoriumWafer_1, 'B', "nuggetGold"));
        if (HexConfig.cfgSeparatorEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackMineralAnalyzer_1,
                    "BCD",
                    "FEA",
                    " R ",
                    'R', stackRedstone_1, 'A', stackHexoriumCoprocessor_1, 'B', stackHexoriumCrystalRed_1, 'C', stackHexoriumCrystalGreen_1, 'D', stackHexoriumCrystalBlue_1,
                    'E', "gemDiamond", 'F', "ingotGold"));
        }
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumEnergyConverter_1,
                "EAE",
                "CBD",
                "AEA",
                'A', stackHexoriumCableRainbow_1, 'B', stackRainbowCore_1, 'C', stackHexoriumProcessor_1, 'D', stackHexoriumCoprocessor_1, 'E', "nuggetIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackEnergyInjector_1,
                "CDE",
                "FBF",
                " A ",
                'A', stackHexoriumCableRainbow_1, 'B', stackSpatialProjector_1, 'C', stackHexoriumCrystalRed_1, 'D', stackHexoriumCrystalGreen_1, 'E', stackHexoriumCrystalBlue_1,
                'F', "nuggetGold"));
        if (HexConfig.cfgTeleportEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackMolecularRecoder_1,
                    "DRD",
                    "CBC",
                    "DAD",
                    'R', stackRedstone_1, 'A', stackHexoriumCableRainbow_1, 'B', stackHexoriumProcessor_1, 'C', stackRainbowCore_1, 'D', "nuggetIron"));
        }
        if (HexConfig.cfgEnergyNodeEnable && HexConfig.cfgEnergyNodePortsRFEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumRFAdapter_1,
                    "RBR",
                    "RAR",
                    "RBR",
                    'R', stackRedstone_1, 'A', stackRainbowCore_1, 'B', "nuggetGold"));
        }

        // Components MP
        GameRegistry.addRecipe(new ShapedOreRecipe(stackMachineControlPanel_1,
                "CB ",
                "CAR",
                "CB ",
                'R', stackRedstone_1, 'A', stackHexoriumProcessor_1, 'B', "nuggetGold", 'C', stackStoneButton_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackMachineEnergyRouter_1,
                "DB",
                "AR",
                "DC",
                'R', stackRedstone_1, 'A', stackHexoriumCableRainbow_1, 'B', stackHexoriumCoprocessor_1, 'C', "nuggetGold", 'D', "nuggetIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHeatDissipator_1,
                "BBR",
                "BBA",
                "BBR",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', "nuggetIron"));
        if (HexConfig.cfgFurnaceEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackHeatingArray_1,
                    "RRB",
                    "RAB",
                    "RRB",
                    'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', "nuggetIron"));
        }
        if (HexConfig.cfgSeparatorEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackCrystalExtractionUnit_1,
                    " BD",
                    "CAD",
                    " RD",
                    'R', stackRedstone_1, 'A', stackHexoriumCoprocessor_1, 'B', stackMineralAnalyzer_1, 'C', stackOreActuator_1, 'D', "nuggetIron"));
        }
        GameRegistry.addRecipe(new ShapedOreRecipe(stackMatrixAdjuster_1,
                " ED",
                "CBA",
                " RD",
                'R', stackRedstone_1, 'A', stackHexoriumCoprocessor_1, 'B', stackRainbowCore_1, 'C', stackSpatialProjector_1, 'D', "nuggetIron", 'E', "gemDiamond"));
        if (HexConfig.cfgTeleportEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackMaterialInteractionPlane_1,
                    "AAA",
                    "ARA",
                    "CBC",
                    'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumProcessor_1, 'C', "nuggetGold"));
            GameRegistry.addRecipe(new ShapedOreRecipe(stackTeleportationFieldProjector_1,
                    "ADA",
                    "BCB",
                    "ERE",
                    'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCoprocessor_1, 'C', stackSpatialProjector_1, 'D', "gemDiamond", 'E', "nuggetGold"));
        }
        if (HexConfig.cfgObserverEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackObservationalEye_1,
                    " A ",
                    " C ",
                    " B ",
                    'A', stackEnergizedHexoriumMonolithBlack_1, 'B', stackHexoriumProcessor_1, 'C', stackEnderEye_1));
        }
        if (HexConfig.cfgTankEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackDigitalSmartpipe_1,
                    "ARR",
                    " DD",
                    "BCR",
                    'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCoprocessor_1, 'D', "nuggetIron"));
        }
        GameRegistry.addRecipe(new ShapedOreRecipe(stackSoundEmissionModule_1,
                "AEB",
                "RDR",
                "FCF",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1, 'C', stackHexoriumCrystalGreen_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackRainbowEnergizedGlobule_1, 'F', "nuggetIron"));

        // Tools
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumManipulator_1,
                "AEF",
                "EBC",
                " DE",
                'A', stackHexoriumCrystalBlack_1, 'B', stackRainbowCore_1, 'C', stackHexoriumProcessor_1, 'D', stackHexoriumCoprocessor_1, 'E', "ingotIron", 'F', stackStoneButton_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumProbe_1,
                "A  ",
                " DB",
                " CD",
                'A', stackHexoriumCrystalWhite_1, 'B', stackMachineControlPanel_1, 'C', stackHexoriumCoprocessor_1, 'D', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackMolecularTransposer_1,
                "E  ",
                " CB",
                " DA",
                'A', stackHexoriumManipulator_1, 'B', stackMachineControlPanel_1, 'C', stackSpatialProjector_1, 'D', "chestWood", 'E', "ingotIron"));
        GameRegistry.addRecipe(stackHexoriumReinforcer_12,
                " A ",
                "BBB",
                "BBB",
                'A', stackHexoriumCrystalBlack_1, 'B', stackObsidian_1);
        GameRegistry.addRecipe(new ShapedOreRecipe(stackMortarPestle_1,
                "  S",
                "CDC",
                " C ",
                'C', stackHexoriumCoatedStone_1, 'D', "gemDiamond", 'S', "stickWood"));

        // Dyes
        GameRegistry.addRecipe(new ShapelessOreRecipe(stackHexoriumDyeBlack_16, stackMortarPestle_1, stackHexoriumCrystalBlack_1, "dyeBlack"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(stackHexoriumDyeWhite_16, stackMortarPestle_1, stackHexoriumCrystalWhite_1, "dyeWhite"));

    }
}

// ABCD ABDC ACBD ACDB ADBC ADCB BACD BADC BCAD BCDA BDAC BDCA CABD CADB CBAD CBDA CDAB CDBA DABC DACB DBAC DBCA DCAB DCBA