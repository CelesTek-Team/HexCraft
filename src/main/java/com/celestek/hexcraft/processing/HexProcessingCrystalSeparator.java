package com.celestek.hexcraft.processing;

import com.celestek.hexcraft.block.BlockHexoriumMonolith;
import com.celestek.hexcraft.block.BlockHexoriumNetherMonolith;
import com.celestek.hexcraft.block.BlockHexoriumNetherOre;
import com.celestek.hexcraft.block.BlockHexoriumOre;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.init.HexItems;
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

    private final HashMap<ItemStack, ItemStack> processingList = new HashMap<>();

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
            addGem("CertusQuartz");

            // Thaumcraft
            addGem("oreAmber");
            addShard("Air");
            addShard("Fire");
            addShard("Water");
            addShard("Earth");
            addShard("Order");
            addShard("Entropy");

            // Redpower
            addGem("Ruby");
            addGem("Sapphire");
            addGem("GreenSapphire");

            // GregTech
            addGem("OrangeSapphire");
            addGem("PurpleSapphire");
            addGem("BlueSapphire");
            addGem("YellowSapphire");

            // Forestry
            addGem("Apatite");

            // Erebus
            addGem("Jade");

            // ArsMagica
            addGem("BlueTopaz");

            // Biomes o Plenty
            addGem("Topaz");
            addGem("Amethyst");
            addGem("Peridot");

            // Misc
            addGem("Morganite");
            addGem("Goshenite");
            addGem("Maxixe");
            addGem("Bixbite");
            addGem("Aquamarine");
            addGem("Heliodor");

            // ChromatiCraft
            if (HexConfig.cfgSeparatorProcessChromatiCraft) {
                addChromaticraft("BlackCrystal");
                addChromaticraft("RedCrystal");
                addChromaticraft("GreenCrystal");
                addChromaticraft("BrownCrystal");
                addChromaticraft("BlueCrystal");
                addChromaticraft("PurpleCrystal");
                addChromaticraft("CyanCrystal");
                addChromaticraft("LightGrayCrystal");
                addChromaticraft("GrayCrystal");
                addChromaticraft("PinkCrystal");
                addChromaticraft("LimeCrystal");
                addChromaticraft("YellowCrystal");
                addChromaticraft("LightBlueCrystal");
                addChromaticraft("MagentaCrystal");
                addChromaticraft("OrangeCrystal");
                addChromaticraft("WhiteCrystal");
            }
        }
    }

    private void addGem(String name) {
        addRecipe(OreDictionary.getOres("ore" + name), OreDictionary.getOres("gem" + name), HexConfig.cfgSeparatorMultiNonHexcraft);
    }

    private void addShard(String name) {
        addRecipe(OreDictionary.getOres("oreInfused" + name), OreDictionary.getOres("shard" + name), HexConfig.cfgSeparatorMultiNonHexcraft);
    }

    private void addChromaticraft(String name) {
        addRecipe(OreDictionary.getOres("dye" + name), OreDictionary.getOres("dye" + name + "Shard"), HexConfig.cfgSeparatorMultiChromatiCraft);
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
            ItemStack output = ItemStack.copyItemStack(gem.get(0));
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

    public HashMap<ItemStack, ItemStack> getHashMap() {
        return processingList;
    }
}
