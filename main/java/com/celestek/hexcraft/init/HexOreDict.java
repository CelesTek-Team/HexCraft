package com.celestek.hexcraft.init;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.6.1
 * @since 2015-04-15
 */
public class HexOreDict {

    /**
     * Adds all ores and monoliths to the OreDictionary.
     */
    public static void registerOres()
    {
        OreDictionary.registerOre("oreHexoriumRed", new ItemStack(HexBlocks.blockHexoriumNetherOreRed));
        OreDictionary.registerOre("oreHexoriumRed", new ItemStack(HexBlocks.blockHexoriumNetherMonolithRed));
        OreDictionary.registerOre("oreHexoriumRed", new ItemStack(HexBlocks.blockHexoriumOreRed));
        OreDictionary.registerOre("oreHexoriumRed", new ItemStack(HexBlocks.blockHexoriumMonolithRed));
        OreDictionary.registerOre("gemHexoriumRed", new ItemStack(HexItems.itemHexoriumCrystalRed));

        OreDictionary.registerOre("oreHexoriumGreen", new ItemStack(HexBlocks.blockHexoriumNetherOreGreen));
        OreDictionary.registerOre("oreHexoriumGreen", new ItemStack(HexBlocks.blockHexoriumNetherMonolithGreen));
        OreDictionary.registerOre("oreHexoriumGreen", new ItemStack(HexBlocks.blockHexoriumOreGreen));
        OreDictionary.registerOre("oreHexoriumGreen", new ItemStack(HexBlocks.blockHexoriumMonolithGreen));
        OreDictionary.registerOre("gemHexoriumGreen", new ItemStack(HexItems.itemHexoriumCrystalGreen));

        OreDictionary.registerOre("oreHexoriumBlue", new ItemStack(HexBlocks.blockHexoriumNetherOreBlue));
        OreDictionary.registerOre("oreHexoriumBlue", new ItemStack(HexBlocks.blockHexoriumNetherMonolithBlue));
        OreDictionary.registerOre("oreHexoriumBlue", new ItemStack(HexBlocks.blockHexoriumOreBlue));
        OreDictionary.registerOre("oreHexoriumBlue", new ItemStack(HexBlocks.blockHexoriumMonolithBlue));
        OreDictionary.registerOre("gemHexoriumBlue", new ItemStack(HexItems.itemHexoriumCrystalBlue));

        OreDictionary.registerOre("oreHexoriumWhite", new ItemStack(HexBlocks.blockHexoriumNetherOreWhite));
        OreDictionary.registerOre("oreHexoriumWhite", new ItemStack(HexBlocks.blockHexoriumNetherMonolithWhite));
        OreDictionary.registerOre("oreHexoriumWhite", new ItemStack(HexBlocks.blockHexoriumOreWhite));
        OreDictionary.registerOre("oreHexoriumWhite", new ItemStack(HexBlocks.blockHexoriumMonolithWhite));
        OreDictionary.registerOre("gemHexoriumWhite", new ItemStack(HexItems.itemHexoriumCrystalWhite));

        OreDictionary.registerOre("oreHexoriumBlack", new ItemStack(HexBlocks.blockHexoriumNetherOreBlack));
        OreDictionary.registerOre("oreHexoriumBlack", new ItemStack(HexBlocks.blockHexoriumNetherMonolithBlack));
        OreDictionary.registerOre("oreHexoriumBlack", new ItemStack(HexBlocks.blockHexoriumOreBlack));
        OreDictionary.registerOre("oreHexoriumBlack", new ItemStack(HexBlocks.blockHexoriumMonolithBlack));
        OreDictionary.registerOre("gemHexoriumBlack", new ItemStack(HexItems.itemHexoriumCrystalBlack));
    }
}
