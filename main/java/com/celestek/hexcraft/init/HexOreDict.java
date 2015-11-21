package com.celestek.hexcraft.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.8.0
 */

public class HexOreDict {

    /**
     * Adds all ores and monoliths to the OreDictionary.
     */
    public static void registerOres() {
        OreDictionary.registerOre("oreNetherHexoriumRed", new ItemStack(HexBlocks.blockHexoriumNetherOreRed));
        OreDictionary.registerOre("oreNetherHexoriumGreen", new ItemStack(HexBlocks.blockHexoriumNetherOreGreen));
        OreDictionary.registerOre("oreNetherHexoriumBlue", new ItemStack(HexBlocks.blockHexoriumNetherOreBlue));
        OreDictionary.registerOre("oreNetherHexoriumWhite", new ItemStack(HexBlocks.blockHexoriumNetherOreWhite));
        OreDictionary.registerOre("oreNetherHexoriumBlack", new ItemStack(HexBlocks.blockHexoriumNetherOreBlack));

        OreDictionary.registerOre("oreHexoriumRed", new ItemStack(HexBlocks.blockHexoriumOreRed));
        OreDictionary.registerOre("oreHexoriumGreen", new ItemStack(HexBlocks.blockHexoriumOreGreen));
        OreDictionary.registerOre("oreHexoriumBlue", new ItemStack(HexBlocks.blockHexoriumOreBlue));
        OreDictionary.registerOre("oreHexoriumWhite", new ItemStack(HexBlocks.blockHexoriumOreWhite));
        OreDictionary.registerOre("oreHexoriumBlack", new ItemStack(HexBlocks.blockHexoriumOreBlack));

        OreDictionary.registerOre("gemHexoriumRed", new ItemStack(HexItems.itemHexoriumCrystalRed));
        OreDictionary.registerOre("gemHexoriumGreen", new ItemStack(HexItems.itemHexoriumCrystalGreen));
        OreDictionary.registerOre("gemHexoriumBlue", new ItemStack(HexItems.itemHexoriumCrystalBlue));
        OreDictionary.registerOre("gemHexoriumWhite", new ItemStack(HexItems.itemHexoriumCrystalWhite));
        OreDictionary.registerOre("gemHexoriumBlack", new ItemStack(HexItems.itemHexoriumCrystalBlack));
    }
}
