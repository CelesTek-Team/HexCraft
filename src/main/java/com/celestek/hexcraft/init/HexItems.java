package com.celestek.hexcraft.init;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.item.*;
import com.celestek.hexcraft.util.HexEnums;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HexItems {

    public static String ID_CRYSTAL = "itemHexoriumCrystal";

    // Raw Materials
    public static Item itemHexoriumCrystalRed;
    public static Item itemHexoriumCrystalGreen;
    public static Item itemHexoriumCrystalBlue;
    public static Item itemHexoriumCrystalWhite;
    public static Item itemHexoriumCrystalBlack;

    // Components T1
    public static Item itemIronNugget;
    public static Item itemRainbowEnergizedGlobule;
    public static Item itemWhiteHexoriumWafer;
    public static Item itemBlackHexoriumWafer;
    public static Item itemSpatialProjector;
    public static Item itemOreActuator;
    public static Item itemPylonSocket;
    public static Item itemHexoriumGlassPackage;

    // Components T2
    public static Item itemRainbowCore;
    public static Item itemHexoriumProcessor;
    public static Item itemHexoriumCoprocessor;
    public static Item itemMineralAnalyzer;
    public static Item itemHexoriumEnergyConverter;
    public static Item itemEnergyInjector;
    public static Item itemMolecularRecoder;
    public static Item itemHexoriumRFAdapter;

    // Components MP
    public static Item itemMachineControlPanel;
    public static Item itemMachineEnergyRouter;
    public static Item itemHeatDissipator;
    public static Item itemHeatingArray;
    public static Item itemCrystalExtractionUnit;
    public static Item itemMatrixAdjuster;
    public static Item itemMaterialInteractionPlane;
    public static Item itemTeleportationFieldProjector;
    public static Item itemObservationalEye;
    public static Item itemDigitalSmartpipe;
    public static Item itemSoundEmissionModule;
    
    // Tools
    public static Item itemHexoriumManipulator;
    public static Item itemHexoriumProbe;
    public static Item itemMolecularTransposer;
    public static Item itemHexoriumReinforcer;
    public static Item itemMortarPestle;
    public static Item itemHexoriumSaw;

    // Dyes
    public static Item itemHexoriumDyeWhite;
    public static Item itemHexoriumDyeBlack;


    /**
     * Initializes all items and adds them to GameRegistry.
     */
    public static void initializeItems() {
        // Raw Materials
        itemHexoriumCrystalRed   = HexItemComponent.registerItem("itemHexoriumCrystalRed");
        itemHexoriumCrystalGreen = HexItemComponent.registerItem("itemHexoriumCrystalGreen");
        itemHexoriumCrystalBlue  = HexItemComponent.registerItem("itemHexoriumCrystalBlue");
        itemHexoriumCrystalWhite = HexItemComponent.registerItem("itemHexoriumCrystalWhite");
        itemHexoriumCrystalBlack = HexItemComponent.registerItem("itemHexoriumCrystalBlack");

        // Components T1
        itemIronNugget              = HexItemComponent.registerItem("itemIronNugget");
        itemRainbowEnergizedGlobule = HexItemComponent.registerItem("itemRainbowEnergizedGlobule");
        itemWhiteHexoriumWafer      = HexItemComponent.registerItem("itemWhiteHexoriumWafer");
        itemBlackHexoriumWafer      = HexItemComponent.registerItem("itemBlackHexoriumWafer");
        itemSpatialProjector        = HexItemComponent.registerItem("itemSpatialProjector");
        itemOreActuator             = HexItemComponent.registerItem("itemOreActuator", HexConfig.cfgSeparatorEnable);
        itemPylonSocket             = HexItemComponent.registerItem("itemPylonSocket");
        itemHexoriumGlassPackage    = HexItemComponent.registerItem("itemHexoriumGlassPackage");

        // Components T2
        itemRainbowCore             = HexItemComponent.registerItem("itemRainbowCore");
        itemHexoriumCoprocessor     = HexItemComponent.registerItem("itemHexoriumCoprocessor");
        itemHexoriumProcessor       = HexItemComponent.registerItem("itemHexoriumProcessor");
        itemMineralAnalyzer         = HexItemComponent.registerItem("itemMineralAnalyzer", HexConfig.cfgSeparatorEnable);
        itemHexoriumEnergyConverter = HexItemComponent.registerItem("itemHexoriumEnergyConverter");
        itemEnergyInjector          = HexItemComponent.registerItem("itemEnergyInjector");
        itemMolecularRecoder        = HexItemComponent.registerItem("itemMolecularRecoder", HexConfig.cfgTeleportEnable);
        itemHexoriumRFAdapter       = HexItemComponent.registerItem("itemHexoriumRFAdapter", HexConfig.cfgEnergyNodeEnable && HexConfig.cfgEnergyNodePortsRFEnable);

        // Components MP
        itemMachineControlPanel         = HexItemComponent.registerItem("itemMachineControlPanel");
        itemMachineEnergyRouter         = HexItemComponent.registerItem("itemMachineEnergyRouter");
        itemHeatDissipator              = HexItemComponent.registerItem("itemHeatDissipator");
        itemHeatingArray                = HexItemComponent.registerItem("itemHeatingArray", HexConfig.cfgFurnaceEnable);
        itemCrystalExtractionUnit       = HexItemComponent.registerItem("itemCrystalExtractionUnit", HexConfig.cfgSeparatorEnable);
        itemMatrixAdjuster              = HexItemComponent.registerItem("itemMatrixAdjuster");
        itemMaterialInteractionPlane    = HexItemComponent.registerItem("itemMaterialInteractionPlane", HexConfig.cfgTeleportEnable);
        itemTeleportationFieldProjector = HexItemComponent.registerItem("itemTeleportationFieldProjector", HexConfig.cfgTeleportEnable);
        itemObservationalEye            = HexItemComponent.registerItem("itemObservationalEye", HexConfig.cfgObserverEnable);
        itemDigitalSmartpipe            = HexItemComponent.registerItem("itemDigitalSmartpipe", HexConfig.cfgTankEnable);
        itemSoundEmissionModule         = HexItemComponent.registerItem("itemSoundEmissionModule");
        
        // Tools
        itemHexoriumManipulator = ItemHexoriumManipulator.registerItem();
        itemHexoriumProbe       = ItemHexoriumProbe.registerItem();
        itemMolecularTransposer = ItemMolecularTransposer.registerItem();
        itemHexoriumReinforcer  = ItemHexoriumReinforcer.registerItem();
        itemMortarPestle        = ItemMortarPestle.registerItem();
        itemHexoriumSaw         = ItemHexoriumSaw.registerItem();

        // Dyes
        ItemHexoriumDye.registerItem();
    }

    public static Item getHexItem(String id, HexEnums.Variants variant) {
        return GameRegistry.findItem(HexCraft.MODID, id + variant.name);
    }

    public static Item getHexItem(String id) {
        return GameRegistry.findItem(HexCraft.MODID, id);
    }

    public static ItemStack getHexItemStack(String id, HexEnums.Variants variant, int count) {
        return new ItemStack(getHexItem(id, variant), count);
    }

    public static ItemStack getHexItemStack(String id, int count) {
        return new ItemStack(getHexItem(id), count);
    }
}
