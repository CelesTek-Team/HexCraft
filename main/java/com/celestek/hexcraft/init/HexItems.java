package com.celestek.hexcraft.init;

import com.celestek.hexcraft.item.HexItemComponent;
import com.celestek.hexcraft.item.ItemHexoriumManipulator;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-15
 */
public class HexItems {

    // Raw Materials
    public static Item itemHexoriumCrystalRed;
    public static Item itemHexoriumCrystalGreen;
    public static Item itemHexoriumCrystalBlue;
    public static Item itemHexoriumCrystalWhite;
    public static Item itemHexoriumCrystalBlack;

    // Components T1
    public static Item itemRainbowEnergizedGlobule;
    public static Item itemWhiteHexoriumWafer;
    public static Item itemBlackHexoriumWafer;

    // Components T2
    public static Item itemRainbowCore;
    public static Item itemHexoriumProcessor;
    public static Item itemHexoriumCoprocessor;
    
    // Tools
    public static Item itemHexoriumManipulator;

    /**
     * Initializes all items and adds them to GameRegistry.
     */
    public static void initializeItems()
    {
        // Raw Materials
        itemHexoriumCrystalRed = new HexItemComponent("itemHexoriumCrystalRed");
        GameRegistry.registerItem(itemHexoriumCrystalRed, "itemHexoriumCrystalRed");
        itemHexoriumCrystalGreen = new HexItemComponent("itemHexoriumCrystalGreen");
        GameRegistry.registerItem(itemHexoriumCrystalGreen, "itemHexoriumCrystalGreen");
        itemHexoriumCrystalBlue = new HexItemComponent("itemHexoriumCrystalBlue");
        GameRegistry.registerItem(itemHexoriumCrystalBlue, "itemHexoriumCrystalBlue");
        itemHexoriumCrystalWhite = new HexItemComponent("itemHexoriumCrystalWhite");
        GameRegistry.registerItem(itemHexoriumCrystalWhite, "itemHexoriumCrystalWhite");
        itemHexoriumCrystalBlack = new HexItemComponent("itemHexoriumCrystalBlack");
        GameRegistry.registerItem(itemHexoriumCrystalBlack, "itemHexoriumCrystalBlack");

        // Components T1
        itemRainbowEnergizedGlobule = new HexItemComponent("itemRainbowEnergizedGlobule");
        GameRegistry.registerItem(itemRainbowEnergizedGlobule, "itemRainbowEnergizedGlobule");
        itemWhiteHexoriumWafer = new HexItemComponent("itemWhiteHexoriumWafer");
        GameRegistry.registerItem(itemWhiteHexoriumWafer, "itemWhiteHexoriumWafer");
        itemBlackHexoriumWafer = new HexItemComponent("itemBlackHexoriumWafer");
        GameRegistry.registerItem(itemBlackHexoriumWafer, "itemBlackHexoriumWafer");

        // Components T2
        itemRainbowCore = new HexItemComponent("itemRainbowCore");
        GameRegistry.registerItem(itemRainbowCore, "itemRainbowCore");
        itemHexoriumProcessor = new HexItemComponent("itemHexoriumProcessor");
        GameRegistry.registerItem(itemHexoriumProcessor, "itemHexoriumProcessor");
        itemHexoriumCoprocessor = new HexItemComponent("itemHexoriumCoprocessor");
        GameRegistry.registerItem(itemHexoriumCoprocessor, "itemHexoriumCoprocessor");
        
        // Tools
        itemHexoriumManipulator = new ItemHexoriumManipulator("itemHexoriumManipulator");
        GameRegistry.registerItem(itemHexoriumManipulator, "itemHexoriumManipulator");
    }
}
