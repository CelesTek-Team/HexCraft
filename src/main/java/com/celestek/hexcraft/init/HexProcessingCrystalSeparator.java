package com.celestek.hexcraft.init;

import com.celestek.hexcraft.block.BlockHexoriumMonolith;
import com.celestek.hexcraft.block.BlockHexoriumNetherMonolith;
import com.celestek.hexcraft.block.BlockHexoriumNetherOre;
import com.celestek.hexcraft.block.BlockHexoriumOre;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HexProcessingCrystalSeparator {

    private static final HexProcessingCrystalSeparator PROCESSING_BASE = new HexProcessingCrystalSeparator();

    private final Map processingList = new HashMap();

    public static HexProcessingCrystalSeparator processing() {
        return PROCESSING_BASE;
    }

    private HexProcessingCrystalSeparator() {
        
        /* Hexorium Recipes */
        for (BlockHexoriumOre.Colors color : BlockHexoriumOre.Colors.values())
            addRecipe(Item.getItemFromBlock(HexBlocks.getHexBlock(BlockHexoriumOre.ID + color.name)),            HexItems.getHexItem(HexItems.ID_CRYSTAL + color.name), color.proc);
        for (BlockHexoriumMonolith.Colors color : BlockHexoriumMonolith.Colors.values())
            addRecipe(Item.getItemFromBlock(HexBlocks.getHexBlock(BlockHexoriumMonolith.ID + color.name)),       HexItems.getHexItem(HexItems.ID_CRYSTAL + color.name), color.proc);
        for (BlockHexoriumNetherOre.Colors color : BlockHexoriumNetherOre.Colors.values())
            addRecipe(Item.getItemFromBlock(HexBlocks.getHexBlock(BlockHexoriumNetherOre.ID + color.name)),      HexItems.getHexItem(HexItems.ID_CRYSTAL + color.name), color.proc);
        for (BlockHexoriumNetherMonolith.Colors color : BlockHexoriumNetherMonolith.Colors.values())
            addRecipe(Item.getItemFromBlock(HexBlocks.getHexBlock(BlockHexoriumNetherMonolith.ID + color.name)), HexItems.getHexItem(HexItems.ID_CRYSTAL + color.name), color.proc);

        /* Ore Dictionary Recipes */
        if (HexConfig.cfgSeparatorProcessNonHexcraft) {
            // Regular Ores
            addRecipe(OreDictionary.getOres("oreDiamond"), Items.diamond, HexConfig.cfgSeparatorMultiNonHexcraft);
            addRecipe(OreDictionary.getOres("oreEmerald"), Items.emerald, HexConfig.cfgSeparatorMultiNonHexcraft);
            addRecipe(OreDictionary.getOres("oreQuartz"),  Items.quartz,  HexConfig.cfgSeparatorMultiNonHexcraft);

            // Dense Ores
            addRecipe(OreDictionary.getOres("denseoreDiamond"), Items.diamond, HexConfig.cfgSeparatorMultiNonHexcraft * 4);
            addRecipe(OreDictionary.getOres("denseoreEmerald"), Items.emerald, HexConfig.cfgSeparatorMultiNonHexcraft * 4);
            addRecipe(OreDictionary.getOres("denseoreQuartz"),  Items.quartz,  HexConfig.cfgSeparatorMultiNonHexcraft * 4);

            // Applied Energistics
            addRecipe(OreDictionary.getOres("oreCertusQuartz"), OreDictionary.getOres("crystalCertusQuartz"), HexConfig.cfgSeparatorMultiNonHexcraft);

            // Thaumcraft
            addRecipe(OreDictionary.getOres("oreAmber"),          OreDictionary.getOres("gemAmber"),     HexConfig.cfgSeparatorMultiNonHexcraft);
            addRecipe(OreDictionary.getOres("oreInfusedAir"),     OreDictionary.getOres("shardAir"),     HexConfig.cfgSeparatorMultiNonHexcraft);
            addRecipe(OreDictionary.getOres("oreInfusedFire"),    OreDictionary.getOres("shardFire"),    HexConfig.cfgSeparatorMultiNonHexcraft);
            addRecipe(OreDictionary.getOres("oreInfusedWater"),   OreDictionary.getOres("shardWater"),   HexConfig.cfgSeparatorMultiNonHexcraft);
            addRecipe(OreDictionary.getOres("oreInfusedEarth"),   OreDictionary.getOres("shardEarth"),   HexConfig.cfgSeparatorMultiNonHexcraft);
            addRecipe(OreDictionary.getOres("oreInfusedOrder"),   OreDictionary.getOres("shardOrder"),   HexConfig.cfgSeparatorMultiNonHexcraft);
            addRecipe(OreDictionary.getOres("oreInfusedEntropy"), OreDictionary.getOres("shardEntropy"), HexConfig.cfgSeparatorMultiNonHexcraft);

            // ProjectRed
            addRecipe(OreDictionary.getOres("oreRuby"),     OreDictionary.getOres("gemRuby"),     HexConfig.cfgSeparatorMultiNonHexcraft);
            addRecipe(OreDictionary.getOres("oreSapphire"), OreDictionary.getOres("gemSapphire"), HexConfig.cfgSeparatorMultiNonHexcraft);
            addRecipe(OreDictionary.getOres("orePeridot"),  OreDictionary.getOres("gemPeridot"),  HexConfig.cfgSeparatorMultiNonHexcraft);

            // Forestry
            addRecipe(OreDictionary.getOres("oreApatite"), OreDictionary.getOres("gemApatite"), HexConfig.cfgSeparatorMultiNonHexcraft);

            // Erebus
            addRecipe(OreDictionary.getOres("oreJade"), OreDictionary.getOres("gemJade"), HexConfig.cfgSeparatorMultiNonHexcraft);

            // ChromatiCraft
            if (HexConfig.cfgSeparatorProcessChromatiCraft) {
                addRecipe(OreDictionary.getOres("dyeBlackCrystal"),     OreDictionary.getOres("dyeBlackCrystalShard"),     HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeRedCrystal"),       OreDictionary.getOres("dyeRedCrystalShard"),       HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeGreenCrystal"),     OreDictionary.getOres("dyeGreenCrystalShard"),     HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeBrownCrystal"),     OreDictionary.getOres("dyeBrownCrystalShard"),     HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeBlueCrystal"),      OreDictionary.getOres("dyeBlueCrystalShard"),      HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyePurpleCrystal"),    OreDictionary.getOres("dyePurpleCrystalShard"),    HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeCyanCrystal"),      OreDictionary.getOres("dyeCyanCrystalShard"),      HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeLightGrayCrystal"), OreDictionary.getOres("dyeLightGrayCrystalShard"), HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeGrayCrystal"),      OreDictionary.getOres("dyeGrayCrystalShard"),      HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyePinkCrystal"),      OreDictionary.getOres("dyePinkCrystalShard"),      HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeLimeCrystal"),      OreDictionary.getOres("dyeLimeCrystalShard"),      HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeYellowCrystal"),    OreDictionary.getOres("dyeYellowCrystalShard"),    HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeLightBlueCrystal"), OreDictionary.getOres("dyeLightBlueCrystalShard"), HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeMagentaCrystal"),   OreDictionary.getOres("dyeMagentaCrystalShard"),   HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeOrangeCrystal"),    OreDictionary.getOres("dyeOrangeCrystalShard"),    HexConfig.cfgSeparatorMultiChromatiCraft);
                addRecipe(OreDictionary.getOres("dyeWhiteCrystal"),     OreDictionary.getOres("dyeWhiteCrystalShard"),     HexConfig.cfgSeparatorMultiChromatiCraft);
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
