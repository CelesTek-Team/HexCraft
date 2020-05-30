package com.celestek.hexcraft.init;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class HexProcessingCrystalSeparator {

    private static final HexProcessingCrystalSeparator PROCESSING_BASE = new HexProcessingCrystalSeparator();

    private Map processingList = new HashMap();

    public static HexProcessingCrystalSeparator processing() {
        return PROCESSING_BASE;
    }

    private HexProcessingCrystalSeparator() {
        
        /* Hexorium Recipes */

        // Nether Ores
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherOreRed), HexItems.itemHexoriumCrystalRed, 6);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherOreGreen), HexItems.itemHexoriumCrystalGreen, 6);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherOreBlue), HexItems.itemHexoriumCrystalBlue, 6);
        
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherOreWhite), HexItems.itemHexoriumCrystalWhite, 8);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherOreBlack), HexItems.itemHexoriumCrystalBlack, 8);

        // Overworld Ores
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumOreRed), HexItems.itemHexoriumCrystalRed, 8);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumOreGreen), HexItems.itemHexoriumCrystalGreen, 8);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumOreBlue), HexItems.itemHexoriumCrystalBlue, 8);

        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumOreWhite), HexItems.itemHexoriumCrystalWhite, 6);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumOreBlack), HexItems.itemHexoriumCrystalBlack, 6);
        
        // Nether Monoliths
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherMonolithRed), HexItems.itemHexoriumCrystalRed, 12);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherMonolithGreen), HexItems.itemHexoriumCrystalGreen, 12);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherMonolithBlue), HexItems.itemHexoriumCrystalBlue, 12);

        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherMonolithWhite), HexItems.itemHexoriumCrystalWhite, 16);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherMonolithBlack), HexItems.itemHexoriumCrystalBlack, 16);

        //  Monoliths
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumMonolithRed), HexItems.itemHexoriumCrystalRed, 16);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumMonolithGreen), HexItems.itemHexoriumCrystalGreen, 16);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumMonolithBlue), HexItems.itemHexoriumCrystalBlue, 16);

        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumMonolithWhite), HexItems.itemHexoriumCrystalWhite, 12);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumMonolithBlack), HexItems.itemHexoriumCrystalBlack, 12);

        /* Ore Dictionary Recipes */

        if (HexConfig.cfgSeparatorProcessNonHexcraft) {
            // Regular Ores
            addRecipe(OreDictionary.getOres("oreDiamond"), Items.diamond, HexConfig.cfgSeparatorMultiNonHexcraft);
            addRecipe(OreDictionary.getOres("oreEmerald"), Items.emerald, HexConfig.cfgSeparatorMultiNonHexcraft);
            addRecipe(OreDictionary.getOres("oreQuartz"), Items.quartz, HexConfig.cfgSeparatorMultiNonHexcraft);

            // Dense Ores
            addRecipe(OreDictionary.getOres("denseoreDiamond"), Items.diamond, HexConfig.cfgSeparatorMultiNonHexcraft * 4);
            addRecipe(OreDictionary.getOres("denseoreEmerald"), Items.emerald, HexConfig.cfgSeparatorMultiNonHexcraft * 4);
            addRecipe(OreDictionary.getOres("denseoreQuartz"), Items.quartz, HexConfig.cfgSeparatorMultiNonHexcraft * 4);

            // Applied Energistics
            addRecipe(OreDictionary.getOres("oreCertusQuartz"), OreDictionary.getOres("crystalCertusQuartz"), HexConfig.cfgSeparatorMultiNonHexcraft);

            // Thaumcraft
            addRecipe(OreDictionary.getOres("oreAmber"), OreDictionary.getOres("gemAmber"), HexConfig.cfgSeparatorMultiNonHexcraft);
            addRecipe(OreDictionary.getOres("oreInfusedAir"), OreDictionary.getOres("shardAir"), HexConfig.cfgSeparatorMultiNonHexcraft);
            addRecipe(OreDictionary.getOres("oreInfusedFire"), OreDictionary.getOres("shardFire"), HexConfig.cfgSeparatorMultiNonHexcraft);
            addRecipe(OreDictionary.getOres("oreInfusedWater"), OreDictionary.getOres("shardWater"), HexConfig.cfgSeparatorMultiNonHexcraft);
            addRecipe(OreDictionary.getOres("oreInfusedEarth"), OreDictionary.getOres("shardEarth"), HexConfig.cfgSeparatorMultiNonHexcraft);
            addRecipe(OreDictionary.getOres("oreInfusedOrder"), OreDictionary.getOres("shardOrder"), HexConfig.cfgSeparatorMultiNonHexcraft);
            addRecipe(OreDictionary.getOres("oreInfusedEntropy"), OreDictionary.getOres("shardEntropy"), HexConfig.cfgSeparatorMultiNonHexcraft);

            // ProjectRed
            addRecipe(OreDictionary.getOres("oreRuby"), OreDictionary.getOres("gemRuby"), HexConfig.cfgSeparatorMultiNonHexcraft);
            addRecipe(OreDictionary.getOres("oreSapphire"), OreDictionary.getOres("gemSapphire"), HexConfig.cfgSeparatorMultiNonHexcraft);
            addRecipe(OreDictionary.getOres("orePeridot"), OreDictionary.getOres("gemPeridot"), HexConfig.cfgSeparatorMultiNonHexcraft);

            // Forestry
            addRecipe(OreDictionary.getOres("oreApatite"), OreDictionary.getOres("gemApatite"), HexConfig.cfgSeparatorMultiNonHexcraft);

            // Erebus
            addRecipe(OreDictionary.getOres("oreJade"), OreDictionary.getOres("gemJade"), HexConfig.cfgSeparatorMultiNonHexcraft);

            // ChromatiCraft
            if (HexConfig.cfgSeparatorProcessChromatiCraft) {
                addRecipe(OreDictionary.getOres("dyeBlackCrystal"), OreDictionary.getOres("dyeBlackCrystalShard"), HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeRedCrystal"), OreDictionary.getOres("dyeRedCrystalShard"), HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeGreenCrystal"), OreDictionary.getOres("dyeGreenCrystalShard"), HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeBrownCrystal"), OreDictionary.getOres("dyeBrownCrystalShard"), HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeBlueCrystal"), OreDictionary.getOres("dyeBlueCrystalShard"), HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyePurpleCrystal"), OreDictionary.getOres("dyePurpleCrystalShard"), HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeCyanCrystal"), OreDictionary.getOres("dyeCyanCrystalShard"), HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeLightGrayCrystal"), OreDictionary.getOres("dyeLightGrayCrystalShard"), HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeGrayCrystal"), OreDictionary.getOres("dyeGrayCrystalShard"), HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyePinkCrystal"), OreDictionary.getOres("dyePinkCrystalShard"), HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeLimeCrystal"), OreDictionary.getOres("dyeLimeCrystalShard"), HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeYellowCrystal"), OreDictionary.getOres("dyeYellowCrystalShard"), HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeLightBlueCrystal"), OreDictionary.getOres("dyeLightBlueCrystalShard"), HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeMagentaCrystal"), OreDictionary.getOres("dyeMagentaCrystalShard"), HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeOrangeCrystal"), OreDictionary.getOres("dyeOrangeCrystalShard"), HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeWhiteCrystal"), OreDictionary.getOres("dyeWhiteCrystalShard"), HexConfig.cfgSeparatorMultiChromatiCraft);
            }
        }
    }

    /**
     * Adds a processing recipe out of one Ore Dictionary entry and one item.
     */
    private void addRecipe(ArrayList<ItemStack> ore, Item gem, int count) {
        if (!ore.isEmpty()) {
            ItemStack output = new ItemStack(gem, count);
            for (ItemStack input : ore)
                putLists(input, output);
        }
    }

    /**
     * Adds a processing recipe out of two Ore Dictionary entries.
     */
    private void addRecipe(ArrayList<ItemStack> ore, ArrayList<ItemStack> gem, int count) {
        if (!ore.isEmpty() && !gem.isEmpty()) {
            ItemStack output = gem.get(0);
            output.stackSize = count;
            for (ItemStack input : ore)
                putLists(input, output);
        }
    }

    /**
     * Adds a processing recipe out of two items.
     */
    public void addRecipe(Item ore, Item gem, int count) {
        putLists(new ItemStack(ore, 1), new ItemStack(gem, count));
    }

    /**
     * Inserts the recipe into lists.
     */
    public void putLists(ItemStack itemstack1, ItemStack itemstack2) {
        processingList.put(itemstack1, itemstack2);
    }

    /**
     * Gets a result of certain processing.
     */
    public ItemStack getProcessingResult(ItemStack itemstack) {
        Iterator iterator = processingList.entrySet().iterator();
        Map.Entry entry;

        do {
            if (!iterator.hasNext())
                return null;
            entry = (Map.Entry) iterator.next();
        } while (!OreDictionary.itemMatches(itemstack, (ItemStack) entry.getKey(), true));

        return (ItemStack) entry.getValue();
    }
}
