package com.celestek.hexcraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-15
 */
public class HexRecipes {

    /**
     * Initializes all recipes and adds them to GameRegistry.
     */
    public static void initializeRecipes()
    {
        /* Stack init */

        // Vanilla Blocks
        ItemStack stackStone_1 = new ItemStack(Blocks.stone, 1);
        ItemStack stackGlass_1 = new ItemStack(Blocks.glass, 1);
        ItemStack stackStoneButton_1 = new ItemStack(Blocks.stone_button, 1);
        ItemStack stackRedstoneTorch_1 = new ItemStack(Blocks.redstone_torch, 1);

        // Vanilla Items
        ItemStack stackRedstone_1 = new ItemStack(Items.redstone, 1);
        ItemStack stackGlowstoneDust_1 = new ItemStack(Items.glowstone_dust, 1);
        ItemStack stackIronIngot_1 = new ItemStack(Items.iron_ingot, 1);
        ItemStack stackGoldIngot_1 = new ItemStack(Items.gold_ingot, 1);
        ItemStack stackDiamond_1 = new ItemStack(Items.diamond, 1);
        ItemStack stackIronPickaxe_1 = new ItemStack(Items.iron_pickaxe, 1);


        // Hex Blocks
        // Block of Hexorium Crystal
        ItemStack stackBlockOfHexoriumCrystalRed_1 = new ItemStack(HexBlocks.blockOfHexoriumCrystalRed, 1);
        ItemStack stackBlockOfHexoriumCrystalGreen_1 = new ItemStack(HexBlocks.blockOfHexoriumCrystalGreen, 1);
        ItemStack stackBlockOfHexoriumCrystalBlue_1 = new ItemStack(HexBlocks.blockOfHexoriumCrystalBlue, 1);
        ItemStack stackBlockOfHexoriumCrystalWhite_1 = new ItemStack(HexBlocks.blockOfHexoriumCrystalWhite, 1);
        ItemStack stackBlockOfHexoriumCrystalBlack_1 = new ItemStack(HexBlocks.blockOfHexoriumCrystalBlack, 1);
        
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

        // Engineered Hexorium Block
        ItemStack stackEngineeredHexoriumBlockRed_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockRed, 1);
        ItemStack stackEngineeredHexoriumBlockOrange_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockOrange, 1);
        ItemStack stackEngineeredHexoriumBlockYellow_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockYellow, 1);
        ItemStack stackEngineeredHexoriumBlockLime_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockLime, 1);
        ItemStack stackEngineeredHexoriumBlockGreen_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockGreen, 1);
        ItemStack stackEngineeredHexoriumBlockTurquoise_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockTurquoise, 1);
        ItemStack stackEngineeredHexoriumBlockCyan_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockCyan, 1);
        ItemStack stackEngineeredHexoriumBlockSkyBlue_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockSkyBlue, 1);
        ItemStack stackEngineeredHexoriumBlockBlue_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockBlue, 1);
        ItemStack stackEngineeredHexoriumBlockPurple_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockPurple, 1);
        ItemStack stackEngineeredHexoriumBlockMagenta_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockMagenta, 1);
        ItemStack stackEngineeredHexoriumBlockPink_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockPink, 1);

        ItemStack stackEngineeredHexoriumBlockWhite_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockWhite, 1);
        ItemStack stackEngineeredHexoriumBlockLightGray_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockLightGray, 1);
        ItemStack stackEngineeredHexoriumBlockGray_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockGray, 1);
        ItemStack stackEngineeredHexoriumBlockDarkGray_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockDarkGray, 1);
        ItemStack stackEngineeredHexoriumBlockBlack_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockBlack, 1);

        ItemStack stackEngineeredHexoriumBlockRainbow_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockRainbow, 1);

        // Framed Hexorium Block
        ItemStack stackFramedHexoriumBlockRed_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockRed, 1);
        ItemStack stackFramedHexoriumBlockOrange_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockOrange, 1);
        ItemStack stackFramedHexoriumBlockYellow_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockYellow, 1);
        ItemStack stackFramedHexoriumBlockLime_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockLime, 1);
        ItemStack stackFramedHexoriumBlockGreen_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockGreen, 1);
        ItemStack stackFramedHexoriumBlockTurquoise_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockTurquoise, 1);
        ItemStack stackFramedHexoriumBlockCyan_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockCyan, 1);
        ItemStack stackFramedHexoriumBlockSkyBlue_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockSkyBlue, 1);
        ItemStack stackFramedHexoriumBlockBlue_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockBlue, 1);
        ItemStack stackFramedHexoriumBlockPurple_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockPurple, 1);
        ItemStack stackFramedHexoriumBlockMagenta_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockMagenta, 1);
        ItemStack stackFramedHexoriumBlockPink_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockPink, 1);

        ItemStack stackFramedHexoriumBlockWhite_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockWhite, 1);
        ItemStack stackFramedHexoriumBlockLightGray_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockLightGray, 1);
        ItemStack stackFramedHexoriumBlockGray_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockGray, 1);
        ItemStack stackFramedHexoriumBlockDarkGray_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockDarkGray, 1);
        ItemStack stackFramedHexoriumBlockBlack_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockBlack, 1);

        ItemStack stackFramedHexoriumBlockRainbow_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockRainbow, 1);

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
        ItemStack stackInvHexoriumLampRed_1 = new ItemStack(HexBlocks.blockInvHexoriumLampRed, 1);
        ItemStack stackInvHexoriumLampOrange_1 = new ItemStack(HexBlocks.blockInvHexoriumLampOrange, 1);
        ItemStack stackInvHexoriumLampYellow_1 = new ItemStack(HexBlocks.blockInvHexoriumLampYellow, 1);
        ItemStack stackInvHexoriumLampLime_1 = new ItemStack(HexBlocks.blockInvHexoriumLampLime, 1);
        ItemStack stackInvHexoriumLampGreen_1 = new ItemStack(HexBlocks.blockInvHexoriumLampGreen, 1);
        ItemStack stackInvHexoriumLampTurquoise_1 = new ItemStack(HexBlocks.blockInvHexoriumLampTurquoise, 1);
        ItemStack stackInvHexoriumLampCyan_1 = new ItemStack(HexBlocks.blockInvHexoriumLampCyan, 1);
        ItemStack stackInvHexoriumLampSkyBlue_1 = new ItemStack(HexBlocks.blockInvHexoriumLampSkyBlue, 1);
        ItemStack stackInvHexoriumLampBlue_1 = new ItemStack(HexBlocks.blockInvHexoriumLampBlue, 1);
        ItemStack stackInvHexoriumLampPurple_1 = new ItemStack(HexBlocks.blockInvHexoriumLampPurple, 1);
        ItemStack stackInvHexoriumLampMagenta_1 = new ItemStack(HexBlocks.blockInvHexoriumLampMagenta, 1);
        ItemStack stackInvHexoriumLampPink_1 = new ItemStack(HexBlocks.blockInvHexoriumLampPink, 1);

        ItemStack stackInvHexoriumLampWhite_1 = new ItemStack(HexBlocks.blockInvHexoriumLampWhite, 1);
        ItemStack stackInvHexoriumLampLightGray_1 = new ItemStack(HexBlocks.blockInvHexoriumLampLightGray, 1);
        ItemStack stackInvHexoriumLampGray_1 = new ItemStack(HexBlocks.blockInvHexoriumLampGray, 1);
        ItemStack stackInvHexoriumLampDarkGray_1 = new ItemStack(HexBlocks.blockInvHexoriumLampDarkGray, 1);
        ItemStack stackInvHexoriumLampBlack_1 = new ItemStack(HexBlocks.blockInvHexoriumLampBlack, 1);

        ItemStack stackInvHexoriumLampRainbow_1 = new ItemStack(HexBlocks.blockInvHexoriumLampRainbow, 1);

        // Machines
        ItemStack stackHexoriumMachineBlock_1 = new ItemStack(HexBlocks.blockHexoriumMachineBlock, 1);

        ItemStack stackHexoriumGenerator_1 = new ItemStack(HexBlocks.machineHexoriumGenerator, 1);
        ItemStack stackHexoriumFurnace_1 = new ItemStack(HexBlocks.machineHexoriumFurnace, 1);
        ItemStack stackCrystalSeparator_1 = new ItemStack(HexBlocks.machineCrystalSeparator, 1);
        ItemStack stackMatrixReconstructor_1 = new ItemStack(HexBlocks.machineMatrixReconstructor, 1);

        // Cables
        ItemStack stackHexoriumCableRed_2 = new ItemStack(HexBlocks.cableHexoriumCableRed, 2);
        ItemStack stackHexoriumCableOrange_2 = new ItemStack(HexBlocks.cableHexoriumCableOrange, 2);
        ItemStack stackHexoriumCableYellow_2 = new ItemStack(HexBlocks.cableHexoriumCableYellow, 2);
        ItemStack stackHexoriumCableLime_2 = new ItemStack(HexBlocks.cableHexoriumCableLime, 2);
        ItemStack stackHexoriumCableGreen_2 = new ItemStack(HexBlocks.cableHexoriumCableGreen, 2);
        ItemStack stackHexoriumCableTurquoise_2 = new ItemStack(HexBlocks.cableHexoriumCableTurquoise, 2);
        ItemStack stackHexoriumCableCyan_2 = new ItemStack(HexBlocks.cableHexoriumCableCyan, 2);
        ItemStack stackHexoriumCableSkyBlue_2 = new ItemStack(HexBlocks.cableHexoriumCableSkyBlue, 2);
        ItemStack stackHexoriumCableBlue_2 = new ItemStack(HexBlocks.cableHexoriumCableBlue, 2);
        ItemStack stackHexoriumCablePurple_2 = new ItemStack(HexBlocks.cableHexoriumCablePurple, 2);
        ItemStack stackHexoriumCableMagenta_2 = new ItemStack(HexBlocks.cableHexoriumCableMagenta, 2);
        ItemStack stackHexoriumCablePink_2 = new ItemStack(HexBlocks.cableHexoriumCablePink, 2);

        ItemStack stackHexoriumCableWhite_2 = new ItemStack(HexBlocks.cableHexoriumCableWhite, 2);
        ItemStack stackHexoriumCableLightGray_2 = new ItemStack(HexBlocks.cableHexoriumCableLightGray, 2);
        ItemStack stackHexoriumCableGray_2 = new ItemStack(HexBlocks.cableHexoriumCableGray, 2);
        ItemStack stackHexoriumCableDarkGray_2 = new ItemStack(HexBlocks.cableHexoriumCableDarkGray, 2);
        ItemStack stackHexoriumCableBlack_2 = new ItemStack(HexBlocks.cableHexoriumCableBlack, 2);

        ItemStack stackHexoriumCableRainbow_1 = new ItemStack(HexBlocks.cableHexoriumCableRainbow, 1);
        ItemStack stackHexoriumCableRainbow_2 = new ItemStack(HexBlocks.cableHexoriumCableRainbow, 2);

        // Regular Blocks
        ItemStack stackTemperedHexoriumGlass_1 = new ItemStack(HexBlocks.blockTemperedHexoriumGlass, 1);
        ItemStack stackTemperedHexoriumGlass_4 = new ItemStack(HexBlocks.blockTemperedHexoriumGlass, 4);

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
        ItemStack stackRainbowEnergizedGlobule_1 = new ItemStack(HexItems.itemRainbowEnergizedGlobule, 1);
        ItemStack stackWhiteHexoriumWafer_1 = new ItemStack(HexItems.itemWhiteHexoriumWafer, 1);
        ItemStack stackBlackHexoriumWafer_1 = new ItemStack(HexItems.itemBlackHexoriumWafer, 1);
        ItemStack stackSpatialProjector_1 = new ItemStack(HexItems.itemSpatialProjector, 1);
        ItemStack stackOreActuator_1 = new ItemStack(HexItems.itemOreActuator, 1);
        ItemStack stackHexoriumGlassPackage_1 = new ItemStack(HexItems.itemHexoriumGlassPackage, 1);

        // Components T2
        ItemStack stackRainbowCore_1 = new ItemStack(HexItems.itemRainbowCore, 1);
        ItemStack stackHexoriumCoprocessor_1 = new ItemStack(HexItems.itemHexoriumCoprocessor, 1);
        ItemStack stackHexoriumProcessor_1 = new ItemStack(HexItems.itemHexoriumProcessor, 1);
        ItemStack stackMineralAnalyzer_1 = new ItemStack(HexItems.itemMineralAnalyzer, 1);

        // Components MP
        ItemStack stackMachineControlPanel_1 = new ItemStack(HexItems.itemMachineControlPanel, 1);
        ItemStack stackMachinePowerRouter_1 = new ItemStack(HexItems.itemMachinePowerRouter, 1);
        ItemStack stackHeatDissipator_1 = new ItemStack(HexItems.itemHeatDissipator, 1);
        ItemStack stackHeatingArray_1 = new ItemStack(HexItems.itemHeatingArray, 1);
        ItemStack stackCrystalExtractionUnit_1 = new ItemStack(HexItems.itemCrystalExtractionUnit, 1);
        ItemStack stackMatrixAdjuster_1 = new ItemStack(HexItems.itemMatrixAdjuster, 1);

        // Tools
        ItemStack stackHexoriumManipulator_1 = new ItemStack(HexItems.itemHexoriumManipulator, 1);


        /* Recipe init */

        // Hex Blocks
        // Block of Hexorium Crystal
        GameRegistry.addRecipe(stackBlockOfHexoriumCrystalRed_1,
                "AAA",
                "AAA",
                "AAA",
                'A', stackHexoriumCrystalRed_1);
        GameRegistry.addShapelessRecipe(stackHexoriumCrystalRed_9, stackBlockOfHexoriumCrystalRed_1);
        GameRegistry.addRecipe(stackBlockOfHexoriumCrystalGreen_1,
                "AAA",
                "AAA",
                "AAA",
                'A', stackHexoriumCrystalGreen_1);
        GameRegistry.addShapelessRecipe(stackHexoriumCrystalGreen_9, stackBlockOfHexoriumCrystalGreen_1);
        GameRegistry.addRecipe(stackBlockOfHexoriumCrystalBlue_1,
                "AAA",
                "AAA",
                "AAA",
                'A', stackHexoriumCrystalBlue_1);
        GameRegistry.addShapelessRecipe(stackHexoriumCrystalBlue_9, stackBlockOfHexoriumCrystalBlue_1);
        GameRegistry.addRecipe(stackBlockOfHexoriumCrystalWhite_1,
                "AAA",
                "AAA",
                "AAA",
                'A', stackHexoriumCrystalWhite_1);
        GameRegistry.addShapelessRecipe(stackHexoriumCrystalWhite_9, stackBlockOfHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackBlockOfHexoriumCrystalBlack_1,
                "AAA",
                "AAA",
                "AAA",
                'A', stackHexoriumCrystalBlack_1);
        GameRegistry.addShapelessRecipe(stackHexoriumCrystalBlack_9, stackBlockOfHexoriumCrystalBlack_1);
        
        // Energized Hexorium
        // Red
        GameRegistry.addRecipe(stackEnergizedHexoriumRed_1,
                "AAA",
                "ARA",
                "AAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1);

        // Orange
        GameRegistry.addRecipe(stackEnergizedHexoriumOrange_1,
                "ABA",
                "ARA",
                "ABA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumOrange_1,
                "AAA",
                "BRB",
                "AAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumOrange_1,
                "BAA",
                "ARA",
                "AAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumOrange_1,
                "AAB",
                "ARA",
                "BAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1);

        // Yellow
        GameRegistry.addRecipe(stackEnergizedHexoriumYellow_1,
                "ABA",
                "BRB",
                "ABA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumYellow_1,
                "BAB",
                "ARA",
                "BAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1);

        // Lime
        GameRegistry.addRecipe(stackEnergizedHexoriumLime_1,
                "ABA",
                "ARA",
                "ABA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumLime_1,
                "AAA",
                "BRB",
                "AAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumLime_1,
                "BAA",
                "ARA",
                "AAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumLime_1,
                "AAB",
                "ARA",
                "BAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1);

        // Green
        GameRegistry.addRecipe(stackEnergizedHexoriumGreen_1,
                "AAA",
                "ARA",
                "AAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1);

        // Turquoise
        GameRegistry.addRecipe(stackEnergizedHexoriumTurquoise_1,
                "ABA",
                "ARA",
                "ABA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumTurquoise_1,
                "AAA",
                "BRB",
                "AAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumTurquoise_1,
                "BAA",
                "ARA",
                "AAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumTurquoise_1,
                "AAB",
                "ARA",
                "BAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1);

        // Cyan
        GameRegistry.addRecipe(stackEnergizedHexoriumCyan_1,
                "ABA",
                "BRB",
                "ABA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumCyan_1,
                "BAB",
                "ARA",
                "BAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1);

        // SkyBlue
        GameRegistry.addRecipe(stackEnergizedHexoriumSkyBlue_1,
                "ABA",
                "ARA",
                "ABA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumSkyBlue_1,
                "AAA",
                "BRB",
                "AAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumSkyBlue_1,
                "BAA",
                "ARA",
                "AAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumSkyBlue_1,
                "AAB",
                "ARA",
                "BAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1);
        
        // Blue
        GameRegistry.addRecipe(stackEnergizedHexoriumBlue_1,
                "AAA",
                "ARA",
                "AAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1);

        // Purple
        GameRegistry.addRecipe(stackEnergizedHexoriumPurple_1,
                "ABA",
                "ARA",
                "ABA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumPurple_1,
                "AAA",
                "BRB",
                "AAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumPurple_1,
                "BAA",
                "ARA",
                "AAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumPurple_1,
                "AAB",
                "ARA",
                "BAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1);

        // Magenta
        GameRegistry.addRecipe(stackEnergizedHexoriumMagenta_1,
                "ABA",
                "BRB",
                "ABA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumMagenta_1,
                "BAB",
                "ARA",
                "BAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1);

        // Pink
        GameRegistry.addRecipe(stackEnergizedHexoriumPink_1,
                "ABA",
                "ARA",
                "ABA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumPink_1,
                "AAA",
                "BRB",
                "AAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumPink_1,
                "BAA",
                "ARA",
                "AAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumPink_1,
                "AAB",
                "ARA",
                "BAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1);
        
        
        // White
        GameRegistry.addRecipe(stackEnergizedHexoriumWhite_1,
                "AAA",
                "ARA",
                "AAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1);

        // LightGray
        GameRegistry.addRecipe(stackEnergizedHexoriumLightGray_1,
                "ABA",
                "ARA",
                "ABA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumLightGray_1,
                "AAA",
                "BRB",
                "AAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumLightGray_1,
                "BAA",
                "ARA",
                "AAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumLightGray_1,
                "AAB",
                "ARA",
                "BAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1);

        // Gray
        GameRegistry.addRecipe(stackEnergizedHexoriumGray_1,
                "ABA",
                "BRB",
                "ABA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumGray_1,
                "BAB",
                "ARA",
                "BAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1);

        // DarkGray
        GameRegistry.addRecipe(stackEnergizedHexoriumDarkGray_1,
                "ABA",
                "ARA",
                "ABA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumDarkGray_1,
                "AAA",
                "BRB",
                "AAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumDarkGray_1,
                "BAA",
                "ARA",
                "AAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumDarkGray_1,
                "AAB",
                "ARA",
                "BAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1);
        
        // Black
        GameRegistry.addRecipe(stackEnergizedHexoriumBlack_1,
                "AAA",
                "ARA",
                "AAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1);

        
        // Rainbow        
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "ABC",
                "DRD",
                "CBA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "ABD",
                "CRC",
                "DBA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "ACB",
                "DRD",
                "BCA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "ACD",
                "BRB",
                "DCA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "ADB",
                "CRC",
                "BDA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "ADC",
                "BRB",
                "CDA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "BAC",
                "DRD",
                "CAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "BAD",
                "CRC",
                "DAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "BCA",
                "DRD",
                "ACB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "BCD",
                "ARA",
                "DCB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "BDA",
                "CRC",
                "ADB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "BDC",
                "ARA",
                "CDB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "CAB",
                "DRD",
                "BAC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "CAD",
                "BRB",
                "DAC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "CBA",
                "DRD",
                "ABC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "CBD",
                "ARA",
                "DBC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "CDA",
                "BRB",
                "ADC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "CDB",
                "ARA",
                "BDC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "DAB",
                "CRC",
                "BAD",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "DAC",
                "BRB",
                "CAD",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "DBA",
                "CRC",
                "ABD",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "DBC",
                "ARA",
                "CBD",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "DCA",
                "BRB",
                "ACD",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "DCB",
                "ARA",
                "BCD",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);


        // Engineered Hexorium Block
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockRed_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumRed_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockOrange_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumOrange_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockYellow_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumYellow_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockLime_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumLime_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockGreen_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumGreen_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockTurquoise_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumTurquoise_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockCyan_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumCyan_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockSkyBlue_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumSkyBlue_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockBlue_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumBlue_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockPurple_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumPurple_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockMagenta_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumMagenta_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockPink_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumPink_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockWhite_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumWhite_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockLightGray_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumLightGray_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockGray_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumGray_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockDarkGray_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumDarkGray_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockBlack_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumBlack_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockRainbow_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumRainbow_1, 'A', stackIronIngot_1, 'B', stackStone_1);


        // Framed Hexorium Block
        GameRegistry.addRecipe(stackFramedHexoriumBlockRed_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumRed_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockOrange_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumOrange_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockYellow_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumYellow_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockLime_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumLime_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockGreen_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumGreen_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockTurquoise_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumTurquoise_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockCyan_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumCyan_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockSkyBlue_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumSkyBlue_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockBlue_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumBlue_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockPurple_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumPurple_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockMagenta_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumMagenta_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockPink_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumPink_1, 'A', stackIronIngot_1);

        GameRegistry.addRecipe(stackFramedHexoriumBlockWhite_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumWhite_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockLightGray_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumLightGray_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockGray_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumGray_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockDarkGray_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumDarkGray_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockBlack_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumBlack_1, 'A', stackIronIngot_1);

        GameRegistry.addRecipe(stackFramedHexoriumBlockRainbow_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumRainbow_1, 'A', stackIronIngot_1);

        // Hexorium Lamp
        GameRegistry.addRecipe(stackHexoriumLampRed_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumRed_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampOrange_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumOrange_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampYellow_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumYellow_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampLime_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumLime_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampGreen_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumGreen_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampTurquoise_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumTurquoise_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampCyan_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumCyan_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampSkyBlue_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumSkyBlue_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampBlue_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumBlue_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampPurple_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumPurple_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampMagenta_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumMagenta_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampPink_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumPink_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);

        GameRegistry.addRecipe(stackHexoriumLampWhite_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumWhite_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampLightGray_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumLightGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampGray_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampDarkGray_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumDarkGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampBlack_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumBlack_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);

        GameRegistry.addRecipe(stackHexoriumLampRainbow_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumRainbow_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);

        // Inverted Hexorium Lamp
        GameRegistry.addRecipe(stackInvHexoriumLampRed_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumRed_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackInvHexoriumLampOrange_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumOrange_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackInvHexoriumLampYellow_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumYellow_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackInvHexoriumLampLime_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumLime_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackInvHexoriumLampGreen_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumGreen_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackInvHexoriumLampTurquoise_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumTurquoise_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackInvHexoriumLampCyan_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumCyan_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackInvHexoriumLampSkyBlue_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumSkyBlue_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackInvHexoriumLampBlue_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumBlue_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackInvHexoriumLampPurple_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumPurple_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackInvHexoriumLampMagenta_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumMagenta_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackInvHexoriumLampPink_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumPink_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);

        GameRegistry.addRecipe(stackInvHexoriumLampWhite_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumWhite_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackInvHexoriumLampLightGray_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumLightGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackInvHexoriumLampGray_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackInvHexoriumLampDarkGray_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumDarkGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackInvHexoriumLampBlack_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumBlack_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);

        GameRegistry.addRecipe(stackInvHexoriumLampRainbow_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumRainbow_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);

        // Machines
        GameRegistry.addRecipe(stackHexoriumMachineBlock_1,
                "C C",
                "RAR",
                "CBC",
                'R', stackRedstone_1, 'A', stackEnergizedHexoriumWhite_1, 'B', stackSpatialProjector_1, 'C', stackIronIngot_1);

        GameRegistry.addRecipe(stackHexoriumGenerator_1,
                "EBE",
                "DAD",
                "ECE",
                'A', stackHexoriumMachineBlock_1, 'B', stackMachineControlPanel_1, 'C', stackMachinePowerRouter_1, 'D', stackHeatDissipator_1, 'E', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumFurnace_1,
                "EBE",
                "DAD",
                "ECE",
                'A', stackHexoriumMachineBlock_1, 'B', stackMachineControlPanel_1, 'C', stackMachinePowerRouter_1, 'D', stackHeatingArray_1, 'E', stackIronIngot_1);
        GameRegistry.addRecipe(stackCrystalSeparator_1,
                "EBE",
                "DAD",
                "ECE",
                'A', stackHexoriumMachineBlock_1, 'B', stackMachineControlPanel_1, 'C', stackMachinePowerRouter_1, 'D', stackCrystalExtractionUnit_1, 'E', stackIronIngot_1);
        GameRegistry.addRecipe(stackMatrixReconstructor_1,
                "EBE",
                "DAD",
                "ECE",
                'A', stackHexoriumMachineBlock_1, 'B', stackMachineControlPanel_1, 'C', stackMachinePowerRouter_1, 'D', stackMatrixAdjuster_1, 'E', stackIronIngot_1);

        // Cables
        // Red
        GameRegistry.addRecipe(stackHexoriumCableRed_2,
                " R ",
                "AEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);

        // Orange
        GameRegistry.addRecipe(stackHexoriumCableOrange_2,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableOrange_2,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableOrange_2,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableOrange_2,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);

        // Yellow
        GameRegistry.addRecipe(stackHexoriumCableYellow_2,
                " R ",
                "BEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableYellow_2,
                " R ",
                "AEB",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);

        // Lime
        GameRegistry.addRecipe(stackHexoriumCableLime_2,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableLime_2,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableLime_2,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableLime_2,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);

        // Green
        GameRegistry.addRecipe(stackHexoriumCableGreen_2,
                " R ",
                "AEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);

        // Turquoise
        GameRegistry.addRecipe(stackHexoriumCableTurquoise_2,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableTurquoise_2,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableTurquoise_2,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableTurquoise_2,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);

        // Cyan
        GameRegistry.addRecipe(stackHexoriumCableCyan_2,
                " R ",
                "BEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableCyan_2,
                " R ",
                "AEB",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);

        // SkyBlue
        GameRegistry.addRecipe(stackHexoriumCableSkyBlue_2,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableSkyBlue_2,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableSkyBlue_2,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableSkyBlue_2,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);

        // Blue
        GameRegistry.addRecipe(stackHexoriumCableBlue_2,
                " R ",
                "AEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);

        // Purple
        GameRegistry.addRecipe(stackHexoriumCablePurple_2,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCablePurple_2,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCablePurple_2,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCablePurple_2,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);

        // Magenta
        GameRegistry.addRecipe(stackHexoriumCableMagenta_2,
                " R ",
                "BEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableMagenta_2,
                " R ",
                "AEB",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);

        // Pink
        GameRegistry.addRecipe(stackHexoriumCablePink_2,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCablePink_2,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCablePink_2,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCablePink_2,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);

        // White
        GameRegistry.addRecipe(stackHexoriumCableWhite_2,
                " R ",
                "AEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'E', stackTemperedHexoriumGlass_1);

        // LightGray
        GameRegistry.addRecipe(stackHexoriumCableLightGray_2,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableLightGray_2,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableLightGray_2,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableLightGray_2,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);

        // Gray
        GameRegistry.addRecipe(stackHexoriumCableGray_2,
                " R ",
                "BEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableGray_2,
                " R ",
                "AEB",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);

        // DarkGray
        GameRegistry.addRecipe(stackHexoriumCableDarkGray_2,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableDarkGray_2,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableDarkGray_2,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableDarkGray_2,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1, 'E', stackTemperedHexoriumGlass_1);

        // Black
        GameRegistry.addRecipe(stackHexoriumCableBlack_2,
                " R ",
                "AEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);
        
        // Rainbow
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "AEB",
                "CED",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "AEB",
                "DEC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "AEC",
                "BED",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "AEC",
                "DEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "AED",
                "BEC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "AED",
                "CEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "BEA",
                "CED",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "BEA",
                "DEC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "BEC",
                "AED",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "BEC",
                "DEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "BED",
                "AEC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "BED",
                "CEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "CEA",
                "BED",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "CEA",
                "DEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "CEB",
                "AED",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "CEB",
                "DEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "CED",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "CED",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "DEA",
                "BEC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "DEA",
                "CEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "DEB",
                "AEC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "DEB",
                "CEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "DEC",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "DEC",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);

        // Regular Blocks
        GameRegistry.addSmelting(stackHexoriumGlassPackage_1, stackTemperedHexoriumGlass_4, 0F);

        // Hex Items
        // Components T1
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
        GameRegistry.addRecipe(stackSpatialProjector_1,
                "BAB",
                "BBB",
                " R ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackOreActuator_1,
                "BB ",
                "ARR",
                "BB ",
                'R', stackRedstone_1, 'A', stackIronPickaxe_1, 'B', stackIronIngot_1);

        GameRegistry.addRecipe(stackHexoriumGlassPackage_1,
                "BCB",
                "CAC",
                "BCB",
                'A', stackHexoriumCrystalRed_1, 'B', stackIronIngot_1, 'C', stackGlass_1);
        GameRegistry.addRecipe(stackHexoriumGlassPackage_1,
                "BCB",
                "CAC",
                "BCB",
                'A', stackHexoriumCrystalGreen_1, 'B', stackIronIngot_1, 'C', stackGlass_1);
        GameRegistry.addRecipe(stackHexoriumGlassPackage_1,
                "BCB",
                "CAC",
                "BCB",
                'A', stackHexoriumCrystalBlue_1, 'B', stackIronIngot_1, 'C', stackGlass_1);

        // Components T2
        GameRegistry.addRecipe(stackRainbowCore_1,
                "BRB",
                "CAC",
                "BRB",
                'R', stackRedstone_1, 'A', stackRainbowEnergizedGlobule_1, 'B', stackIronIngot_1, 'C', stackGoldIngot_1);
        GameRegistry.addRecipe(stackHexoriumCoprocessor_1,
                " R ",
                "RAR",
                " B ",
                'R', stackRedstone_1, 'A', stackWhiteHexoriumWafer_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumProcessor_1,
                " R ",
                "RAR",
                " B ",
                'R', stackRedstone_1, 'A', stackBlackHexoriumWafer_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackMineralAnalyzer_1,
                "BCD",
                "FEA",
                "GRG",
                'R', stackRedstone_1, 'A', stackHexoriumCoprocessor_1, 'B', stackHexoriumCrystalRed_1, 'C', stackHexoriumCrystalGreen_1, 'D', stackHexoriumCrystalBlue_1,
                'E', stackDiamond_1, 'F', stackGoldIngot_1, 'G', stackIronIngot_1);

        // Components MP
        GameRegistry.addRecipe(stackMachineControlPanel_1,
                "DDD",
                "CAC",
                "RBR",
                'R', stackRedstone_1, 'A', stackHexoriumProcessor_1, 'B', stackHexoriumCoprocessor_1, 'C', stackGoldIngot_1, 'D', stackStoneButton_1);
        GameRegistry.addRecipe(stackMachinePowerRouter_1,
                "CRC",
                "BAB",
                "DAD",
                'R', stackRedstone_1, 'A', stackHexoriumCableRainbow_1, 'B', stackHexoriumCoprocessor_1, 'C', stackGoldIngot_1, 'D', stackIronIngot_1);
        GameRegistry.addRecipe(stackHeatDissipator_1,
                "BBR",
                "BBA",
                "BBR",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHeatingArray_1,
                "RRB",
                "RAB",
                "RRB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackCrystalExtractionUnit_1,
                "BRD",
                "CAD",
                " RD",
                'R', stackRedstone_1, 'A', stackHexoriumCoprocessor_1, 'B', stackMineralAnalyzer_1, 'C', stackOreActuator_1, 'D', stackIronIngot_1);
        GameRegistry.addRecipe(stackMatrixAdjuster_1,
                " ED",
                "CBA",
                " RD",
                'R', stackRedstone_1, 'A', stackHexoriumCoprocessor_1, 'B', stackRainbowCore_1, 'C', stackSpatialProjector_1, 'D', stackIronIngot_1, 'E', stackDiamond_1);

        // Tools
        GameRegistry.addRecipe(stackHexoriumManipulator_1,
                "EAE",
                "CBD",
                " EF",
                'A', stackHexoriumCrystalBlack_1, 'B', stackRainbowCore_1, 'C', stackHexoriumProcessor_1, 'D', stackHexoriumCoprocessor_1, 'E', stackIronIngot_1, 'F', stackStoneButton_1);
    }
}

// ABCD ABDC ACBD ACDB ADBC ADCB BACD BADC BCAD BCDA BDAC BDCA CABD CADB CBAD CBDA CDAB CDBA DABC DACB DBAC DBCA DCAB DCBA