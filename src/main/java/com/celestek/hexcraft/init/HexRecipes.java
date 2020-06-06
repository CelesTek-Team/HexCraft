package com.celestek.hexcraft.init;

import com.celestek.hexcraft.block.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class HexRecipes {

    /**
     * Initializes all recipes and adds them to GameRegistry.
     */
    public static void initializeRecipes() {
        /* Stack init */

        // Vanilla Blocks
        ItemStack stackObsidian_1 = new ItemStack(Blocks.obsidian, 1);
        ItemStack stackStoneButton_1 = new ItemStack(Blocks.stone_button, 1);

        // Vanilla Items
        ItemStack stackRedstone_1 = new ItemStack(Items.redstone, 1);
        ItemStack stackIronPickaxe_1 = new ItemStack(Items.iron_pickaxe, 1);
        ItemStack stackEnderEye_1 = new ItemStack(Items.ender_eye, 1);

        // Cables
        ItemStack stackHexoriumCableRainbow_1 = new ItemStack(HexBlocks.blockHexoriumCableRainbow, 1);

        // Regular Blocks
        ItemStack stackHexoriumCoatedStone_1 = new ItemStack(HexBlocks.blockHexoriumCoatedStone, 1);

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
        BlockHexoriumCable.registerRecipes();

        // Energy Pylon
        BlockEnergyPylon.registerRecipes();

        // Redstone
        BlockHexoriumSwitch.registerRecipes();
        BlockHexoriumButton.registerRecipes();
        BlockHexoriumPressurePlate.registerRecipes();

        // Regular Blocks
        BlockTemperedHexoriumGlass.registerRecipes();
        BlockHexoriumCoatedStone.registerRecipes();
        BlockPylonBase.registerRecipes();
        BlockSoundProjector.registerRecipes();



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