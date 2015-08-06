package com.celestek.hexcraft.init;

import net.minecraft.init.Blocks;
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
 * @version 0.6.0
 * @since 2015-04-25
 */
public class HexProcessingCrystalSeparator {

    private static final HexProcessingCrystalSeparator PROCESSING_BASE = new HexProcessingCrystalSeparator();

    private Map processingList = new HashMap();
    private Map experienceList = new HashMap();

    public static HexProcessingCrystalSeparator processing() {
        return PROCESSING_BASE;
    }

    private HexProcessingCrystalSeparator() {
        // Give 0 experience.
        float experience = 0F;

        /* Hexorium Recipes */

        // Nether Ores
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherOreRed), HexItems.itemHexoriumCrystalRed, 6, experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherOreGreen), HexItems.itemHexoriumCrystalGreen, 6, experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherOreBlue), HexItems.itemHexoriumCrystalBlue, 6, experience);
        
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherOreWhite), HexItems.itemHexoriumCrystalWhite, 8, experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherOreBlack), HexItems.itemHexoriumCrystalBlack, 8, experience);

        // Overworld Ores
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumOreRed), HexItems.itemHexoriumCrystalRed, 8, experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumOreGreen), HexItems.itemHexoriumCrystalGreen, 8, experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumOreBlue), HexItems.itemHexoriumCrystalBlue, 8, experience);

        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumOreWhite), HexItems.itemHexoriumCrystalWhite, 6, experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumOreBlack), HexItems.itemHexoriumCrystalBlack, 6, experience);
        
        // Nether Monoliths
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherMonolithRed), HexItems.itemHexoriumCrystalRed, 12, experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherMonolithGreen), HexItems.itemHexoriumCrystalGreen, 12, experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherMonolithBlue), HexItems.itemHexoriumCrystalBlue, 12, experience);

        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherMonolithWhite), HexItems.itemHexoriumCrystalWhite, 16, experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherMonolithBlack), HexItems.itemHexoriumCrystalBlack, 16, experience);

        //  Monoliths
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumMonolithRed), HexItems.itemHexoriumCrystalRed, 16, experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumMonolithGreen), HexItems.itemHexoriumCrystalGreen, 16, experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumMonolithBlue), HexItems.itemHexoriumCrystalBlue, 16, experience);

        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumMonolithWhite), HexItems.itemHexoriumCrystalWhite, 12, experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumMonolithBlack), HexItems.itemHexoriumCrystalBlack, 12, experience);

        /* Ore Dictionary Recipes */

        // Regular Ores
        addRecipe(OreDictionary.getOres("oreDiamond"), Items.diamond, 4, experience);
        addRecipe(OreDictionary.getOres("oreEmerald"), Items.emerald, 4, experience);
        addRecipe(OreDictionary.getOres("oreQuartz"), Items.quartz, 4, experience);

        // Dense Ores
        addRecipe(OreDictionary.getOres("denseoreDiamond"), Items.diamond, 16, experience);
        addRecipe(OreDictionary.getOres("denseoreEmerald"), Items.emerald, 16, experience);
        addRecipe(OreDictionary.getOres("denseoreQuartz"), Items.quartz, 16, experience);

        // Applied Energistics
        addRecipe(OreDictionary.getOres("oreCertusQuartz"), OreDictionary.getOres("crystalCertusQuartz"), 4, experience);

        // Thaumcraft
        addRecipe(OreDictionary.getOres("oreAmber"), OreDictionary.getOres("gemAmber"), 4, experience);
        addRecipe(OreDictionary.getOres("oreInfusedAir"), OreDictionary.getOres("shardAir"), 4, experience);
        addRecipe(OreDictionary.getOres("oreInfusedFire"), OreDictionary.getOres("shardFire"), 4, experience);
        addRecipe(OreDictionary.getOres("oreInfusedWater"), OreDictionary.getOres("shardWater"), 4, experience);
        addRecipe(OreDictionary.getOres("oreInfusedEarth"), OreDictionary.getOres("shardEarth"), 4, experience);
        addRecipe(OreDictionary.getOres("oreInfusedOrder"), OreDictionary.getOres("shardOrder"), 4, experience);
        addRecipe(OreDictionary.getOres("oreInfusedEntropy"), OreDictionary.getOres("shardEntropy"), 4, experience);

        // ProjectRed
        addRecipe(OreDictionary.getOres("oreRuby"), OreDictionary.getOres("gemRuby"), 4, experience);
        addRecipe(OreDictionary.getOres("oreSapphire"), OreDictionary.getOres("gemSapphire"), 4, experience);
        addRecipe(OreDictionary.getOres("orePeridot"), OreDictionary.getOres("gemPeridot"), 4, experience);

        // Forestry
        addRecipe(OreDictionary.getOres("oreApatite"), OreDictionary.getOres("gemApatite"), 4, experience);

        // Erebus
        addRecipe(OreDictionary.getOres("oreJade"), OreDictionary.getOres("gemJade"), 4, experience);

    }

    /**
     * Adds a processing recipe out of one Ore Dictionary entry and one item.
     */
    private void addRecipe(ArrayList<ItemStack> ore, Item gem, int count, float experience) {
        if (!ore.isEmpty()) {
            ItemStack output = new ItemStack(gem, count);
            for (ItemStack input : ore)
                putLists(input, output, experience);
        }
    }

    /**
     * Adds a processing recipe out of two Ore Dictionary entries.
     */
    private void addRecipe(ArrayList<ItemStack> ore, ArrayList<ItemStack> gem, int count, float experience) {
        if (!ore.isEmpty() && !gem.isEmpty()) {
            ItemStack output = gem.get(0);
            output.stackSize = count;
            for (ItemStack input : ore)
                putLists(input, output, experience);
        }
    }

    /**
     * Adds a processing recipe out of two items.
     */
    public void addRecipe(Item ore, Item gem, int count, float experience) {
        putLists(new ItemStack(ore, 1), new ItemStack(gem, count), experience);
    }

    /**
     * Inserts the recipe into lists.
     */
    public void putLists(ItemStack itemstack1, ItemStack itemstack2, float experience){
        processingList.put(itemstack1, itemstack2);
        experienceList.put(itemstack2, experience);
    }

    /**
     * Gets a result of certain processing.
     */
    public ItemStack getProcessingResult(ItemStack itemstack) {
        Iterator iterator = processingList.entrySet().iterator();
        Map.Entry entry;

        do {
            if (!iterator.hasNext()) {
                return null;
            }
            entry = (Map.Entry) iterator.next();
        } while (!OreDictionary.itemMatches(itemstack, (ItemStack) entry.getKey(), true));
        return (ItemStack) entry.getValue();
    }

    public float giveExperience(ItemStack itemstack){
        Iterator iterator = experienceList.entrySet().iterator();
        Map.Entry entry;

        do{
            if(!iterator.hasNext()){
                return 0.0f;
            }

            entry = (Map.Entry) iterator.next();
        }
        while(!OreDictionary.itemMatches(itemstack, (ItemStack) entry.getKey(), true));

        if(itemstack.getItem().getSmeltingExperience(itemstack) != -1){
            return itemstack.getItem().getSmeltingExperience(itemstack);
        }

        return (Float) entry.getValue();
    }
}
