package com.celestek.hexcraft.init;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.item.*;
import com.celestek.hexcraft.util.HexEnums;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

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

    // Dyes
    public static Item itemHexoriumDyeWhite;
    public static Item itemHexoriumDyeBlack;


    /**
     * Initializes all items and adds them to GameRegistry.
     */
    public static void initializeItems() {
        // Raw Materials
        itemHexoriumCrystalRed   = registerItem("itemHexoriumCrystalRed");
        itemHexoriumCrystalGreen = registerItem("itemHexoriumCrystalGreen");
        itemHexoriumCrystalBlue  = registerItem("itemHexoriumCrystalBlue");
        itemHexoriumCrystalWhite = registerItem("itemHexoriumCrystalWhite");
        itemHexoriumCrystalBlack = registerItem("itemHexoriumCrystalBlack");

        // Components T1
        itemIronNugget              = registerItem("itemIronNugget");
        itemRainbowEnergizedGlobule = registerItem("itemRainbowEnergizedGlobule");
        itemWhiteHexoriumWafer      = registerItem("itemWhiteHexoriumWafer");
        itemBlackHexoriumWafer      = registerItem("itemBlackHexoriumWafer");
        itemSpatialProjector        = registerItem("itemSpatialProjector");
        itemOreActuator             = registerItem("itemOreActuator", HexConfig.cfgSeparatorEnable);
        itemPylonSocket             = registerItem("itemPylonSocket");
        itemHexoriumGlassPackage    = registerItem("itemHexoriumGlassPackage");

        // Components T2
        itemRainbowCore             = registerItem("itemRainbowCore");
        itemHexoriumCoprocessor     = registerItem("itemHexoriumCoprocessor");
        itemHexoriumProcessor       = registerItem("itemHexoriumProcessor");
        itemMineralAnalyzer         = registerItem("itemMineralAnalyzer", HexConfig.cfgSeparatorEnable);
        itemHexoriumEnergyConverter = registerItem("itemHexoriumEnergyConverter");
        itemEnergyInjector          = registerItem("itemEnergyInjector");
        itemMolecularRecoder        = registerItem("itemMolecularRecoder", HexConfig.cfgTeleportEnable);
        itemHexoriumRFAdapter       = registerItem("itemHexoriumRFAdapter", HexConfig.cfgEnergyNodeEnable && HexConfig.cfgEnergyNodePortsRFEnable);

        // Components MP
        itemMachineControlPanel         = registerItem("itemMachineControlPanel");
        itemMachineEnergyRouter         = registerItem("itemMachineEnergyRouter");
        itemHeatDissipator              = registerItem("itemHeatDissipator");
        itemHeatingArray                = registerItem("itemHeatingArray", HexConfig.cfgFurnaceEnable);
        itemCrystalExtractionUnit       = registerItem("itemCrystalExtractionUnit", HexConfig.cfgSeparatorEnable);
        itemMatrixAdjuster              = registerItem("itemMatrixAdjuster");
        itemMaterialInteractionPlane    = registerItem("itemMaterialInteractionPlane", HexConfig.cfgTeleportEnable);
        itemTeleportationFieldProjector = registerItem("itemTeleportationFieldProjector", HexConfig.cfgTeleportEnable);
        itemObservationalEye            = registerItem("itemObservationalEye", HexConfig.cfgObserverEnable);
        itemDigitalSmartpipe            = registerItem("itemDigitalSmartpipe", HexConfig.cfgTankEnable);
        itemSoundEmissionModule         = registerItem("itemSoundEmissionModule");
        
        // Tools
        itemHexoriumManipulator = ItemHexoriumManipulator.registerItem();
        itemHexoriumProbe = ItemHexoriumProbe.registerItem();
        itemMolecularTransposer = ItemMolecularTransposer.registerItem();
        itemHexoriumReinforcer = ItemHexoriumReinforcer.registerItem();
        itemMortarPestle = ItemMortarPestle.registerItem();

        // Dyes
        ItemHexoriumDye.registerItem();
    }

    private static Item registerItem(String name, boolean enabled) {
        if (enabled)
            return registerItem(name);
        else
            return null;
    }

    private static Item registerItem(String name) {
        Item item = new HexItemComponent(name);
        GameRegistry.registerItem(item, name);
        return item;
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
