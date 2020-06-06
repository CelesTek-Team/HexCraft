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

        // Vanilla Items
        ItemStack stackRedstone_1 = new ItemStack(Items.redstone, 1);
        ItemStack stackIronPickaxe_1 = new ItemStack(Items.iron_pickaxe, 1);
        ItemStack stackEnderEye_1 = new ItemStack(Items.ender_eye, 1);

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
        ItemStack stackHexoriumDyeBlack_16 = new ItemStack(HexItems.itemHexoriumDyeBlack, 16);
        ItemStack stackHexoriumDyeWhite_16 = new ItemStack(HexItems.itemHexoriumDyeWhite, 16);

        // Misc
        ItemStack stackEnergizedHexoriumMonolithBlack_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithBlack, 1);


        /* Recipe init */

        // Gem Blocks
        BlockOfHexoriumCrystal.registerRecipes();

        // Energized
        BlockEnergizedHexorium.registerRecipes();

        // Decorative
        BlockEngineeredHexoriumBlock.registerRecipes();
        BlockFramedHexoriumBlock.registerRecipes();
        BlockPlatedHexoriumBlock.registerRecipes();
        BlockConcentricHexoriumBlock.registerRecipes();
        BlockHexoriumStructureCasing.registerRecipes();
        BlockGlowingHexoriumCoatedStone.registerRecipes();
        BlockGlowingHexoriumGlass.registerRecipes();
        BlockHexoriumLamp.registerRecipes();
        BlockHexoriumLampInv.registerRecipes();
        BlockHexoriumDoor.registerRecipes();
        BlockHexoriumHatch.registerRecipes();

        // Machines
        BlockHexoriumMachineBlock.registerRecipes();
        BlockAdvancedRainbowCore.registerRecipes();
        BlockHexoriumGenerator.registerRecipes();
        BlockHexoriumFurnace.registerRecipes();
        BlockCrystalSeparator.registerRecipes();
        BlockMatrixReconstructor.registerRecipes();
        BlockPersonalTeleportationPad.registerRecipes();
        BlockQuantumObserver.registerRecipes();
        BlockQuantumAnchor.registerRecipes();

        // Tank
        BlockTankValve.registerRecipes();

        // Energy Node
        BlockEnergyNodeCore.registerRecipes();
        BlockEnergyNodePortHEX.registerRecipes();
        BlockEnergyNodePortRF.registerRecipes();
        BlockEnergyNodePortEU.registerRecipes();

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