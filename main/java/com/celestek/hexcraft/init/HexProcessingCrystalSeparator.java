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
 * @version 0.8.1
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

        // Regular Ores
        addRecipe(OreDictionary.getOres("oreDiamond"), Items.diamond, 4);
        addRecipe(OreDictionary.getOres("oreEmerald"), Items.emerald, 4);
        addRecipe(OreDictionary.getOres("oreQuartz"), Items.quartz, 4);

        // Dense Ores
        addRecipe(OreDictionary.getOres("denseoreDiamond"), Items.diamond, 16);
        addRecipe(OreDictionary.getOres("denseoreEmerald"), Items.emerald, 16);
        addRecipe(OreDictionary.getOres("denseoreQuartz"), Items.quartz, 16);

        // Applied Energistics
        addRecipe(OreDictionary.getOres("oreCertusQuartz"), OreDictionary.getOres("crystalCertusQuartz"), 4);

        // Thaumcraft
        addRecipe(OreDictionary.getOres("oreAmber"), OreDictionary.getOres("gemAmber"), 4);
        addRecipe(OreDictionary.getOres("oreInfusedAir"), OreDictionary.getOres("shardAir"), 4);
        addRecipe(OreDictionary.getOres("oreInfusedFire"), OreDictionary.getOres("shardFire"), 4);
        addRecipe(OreDictionary.getOres("oreInfusedWater"), OreDictionary.getOres("shardWater"), 4);
        addRecipe(OreDictionary.getOres("oreInfusedEarth"), OreDictionary.getOres("shardEarth"), 4);
        addRecipe(OreDictionary.getOres("oreInfusedOrder"), OreDictionary.getOres("shardOrder"), 4);
        addRecipe(OreDictionary.getOres("oreInfusedEntropy"), OreDictionary.getOres("shardEntropy"), 4);

        // ProjectRed
        addRecipe(OreDictionary.getOres("oreRuby"), OreDictionary.getOres("gemRuby"), 4);
        addRecipe(OreDictionary.getOres("oreSapphire"), OreDictionary.getOres("gemSapphire"), 4);
        addRecipe(OreDictionary.getOres("orePeridot"), OreDictionary.getOres("gemPeridot"), 4);

        // Forestry
        addRecipe(OreDictionary.getOres("oreApatite"), OreDictionary.getOres("gemApatite"), 4);

        // Erebus
        addRecipe(OreDictionary.getOres("oreJade"), OreDictionary.getOres("gemJade"), 4);

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
