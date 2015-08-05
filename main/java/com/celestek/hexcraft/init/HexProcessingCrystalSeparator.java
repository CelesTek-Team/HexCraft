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

        // Nether Ores
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherOreRed), new ItemStack(HexItems.itemHexoriumCrystalRed, 6), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherOreGreen), new ItemStack(HexItems.itemHexoriumCrystalGreen, 6), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherOreBlue), new ItemStack(HexItems.itemHexoriumCrystalBlue, 6), experience);
        
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherOreWhite), new ItemStack(HexItems.itemHexoriumCrystalWhite, 8), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherOreBlack), new ItemStack(HexItems.itemHexoriumCrystalBlack, 8), experience);

        // Overworld Ores
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumOreRed), new ItemStack(HexItems.itemHexoriumCrystalRed, 8), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumOreGreen), new ItemStack(HexItems.itemHexoriumCrystalGreen, 8), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumOreBlue), new ItemStack(HexItems.itemHexoriumCrystalBlue, 8), experience);

        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumOreWhite), new ItemStack(HexItems.itemHexoriumCrystalWhite, 6), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumOreBlack), new ItemStack(HexItems.itemHexoriumCrystalBlack, 6), experience);
        
        // Nether Monoliths
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherMonolithRed), new ItemStack(HexItems.itemHexoriumCrystalRed, 12), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherMonolithGreen), new ItemStack(HexItems.itemHexoriumCrystalGreen, 12), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherMonolithBlue), new ItemStack(HexItems.itemHexoriumCrystalBlue, 12), experience);

        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherMonolithWhite), new ItemStack(HexItems.itemHexoriumCrystalWhite, 16), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumNetherMonolithBlack), new ItemStack(HexItems.itemHexoriumCrystalBlack, 16), experience);

        //  Monoliths
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumMonolithRed), new ItemStack(HexItems.itemHexoriumCrystalRed, 16), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumMonolithGreen), new ItemStack(HexItems.itemHexoriumCrystalGreen, 16), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumMonolithBlue), new ItemStack(HexItems.itemHexoriumCrystalBlue, 16), experience);

        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumMonolithWhite), new ItemStack(HexItems.itemHexoriumCrystalWhite, 12), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockHexoriumMonolithBlack), new ItemStack(HexItems.itemHexoriumCrystalBlack, 12), experience);

        /* Ore Dictionary recipes */
        ArrayList<ItemStack> ore;
        ArrayList<ItemStack> gem;
        ItemStack output;

        // Regular Ores
        ore = OreDictionary.getOres("oreDiamond");
        for (ItemStack input : ore) {
            addRecipe(input.getItem(), new ItemStack(Items.diamond, 4), experience);
        }
        ore = OreDictionary.getOres("oreEmerald");
        for (ItemStack input : ore) {
            addRecipe(input.getItem(), new ItemStack(Items.emerald, 4), experience);
        }
        ore = OreDictionary.getOres("oreQuartz");
        for (ItemStack input : ore) {
            addRecipe(input.getItem(), new ItemStack(Items.quartz, 4), experience);
        }

        // Applied Energistics
        ore = OreDictionary.getOres("oreCertusQuartz");
        gem = OreDictionary.getOres("crystalCertusQuartz");
        if (!ore.isEmpty() && !gem.isEmpty()) {
            output = gem.get(0);
            output.stackSize = 4;
            for (ItemStack input : ore) {
                addRecipe(input.getItem(), output, experience);
            }
        }

        // Thaumcraft
        ore = OreDictionary.getOres("oreAmber");
        gem = OreDictionary.getOres("gemAmber");
        if (!ore.isEmpty() && !gem.isEmpty()) {
            output = gem.get(0);
            output.stackSize = 4;
            for (ItemStack input : ore) {
                addRecipe(input, output, experience);
            }
        }
        ore = OreDictionary.getOres("oreInfusedAir");
        gem = OreDictionary.getOres("shardAir");
        if (!ore.isEmpty() && !gem.isEmpty()) {
            output = gem.get(0);
            output.stackSize = 4;
            for (ItemStack input : ore) {
                addRecipe(input.getItem(), output, experience);
            }
        }
        ore = OreDictionary.getOres("oreInfusedFire");
        gem = OreDictionary.getOres("shardFire");
        if (!ore.isEmpty() && !gem.isEmpty()) {
            output = gem.get(0);
            output.stackSize = 4;
            for (ItemStack input : ore) {
                addRecipe(input.getItem(), output, experience);
            }
        }
        ore = OreDictionary.getOres("oreInfusedWater");
        gem = OreDictionary.getOres("shardWater");
        if (!ore.isEmpty() && !gem.isEmpty()) {
            output = gem.get(0);
            output.stackSize = 4;
            for (ItemStack input : ore) {
                addRecipe(input.getItem(), output, experience);
            }
        }
        ore = OreDictionary.getOres("oreInfusedEarth");
        gem = OreDictionary.getOres("shardEarth");
        if (!ore.isEmpty() && !gem.isEmpty()) {
            output = gem.get(0);
            output.stackSize = 4;
            for (ItemStack input : ore) {
                addRecipe(input.getItem(), output, experience);
            }
        }
        ore = OreDictionary.getOres("oreInfusedOrder");
        gem = OreDictionary.getOres("shardOrder");
        if (!ore.isEmpty() && !gem.isEmpty()) {
            output = gem.get(0);
            output.stackSize = 4;
            for (ItemStack input : ore) {
                addRecipe(input.getItem(), output, experience);
            }
        }
        ore = OreDictionary.getOres("oreInfusedEntropy");
        gem = OreDictionary.getOres("shardEntropy");
        if (!ore.isEmpty() && !gem.isEmpty()) {
            output = gem.get(0);
            output.stackSize = 4;
            for (ItemStack input : ore) {
                addRecipe(input.getItem(), output, experience);
            }
        }

        // ProjectRed
        ore = OreDictionary.getOres("oreRuby");
        gem = OreDictionary.getOres("gemRuby");
        if (!ore.isEmpty() && !gem.isEmpty()) {
            output = gem.get(0);
            output.stackSize = 4;
            for (ItemStack input : ore) {
                addRecipe(input.getItem(), output, experience);
            }
        }
        ore = OreDictionary.getOres("oreSapphire");
        gem = OreDictionary.getOres("gemSapphire");
        if (!ore.isEmpty() && !gem.isEmpty()) {
            output = gem.get(0);
            output.stackSize = 4;
            for (ItemStack input : ore) {
                addRecipe(input.getItem(), output, experience);
            }
        }
        ore = OreDictionary.getOres("orePeridot");
        gem = OreDictionary.getOres("gemPeridot");
        if (!ore.isEmpty() && !gem.isEmpty()) {
            output = gem.get(0);
            output.stackSize = 4;
            for (ItemStack input : ore) {
                addRecipe(input.getItem(), output, experience);
            }
        }

        // Forestry
        ore = OreDictionary.getOres("oreApatite");
        gem = OreDictionary.getOres("gemApatite");
        if (!ore.isEmpty() && !gem.isEmpty()) {
            output = gem.get(0);
            output.stackSize = 4;
            for (ItemStack input : ore) {
                addRecipe(input.getItem(), output, experience);
            }
        }

        // Erebus
        ore = OreDictionary.getOres("oreJade");
        gem = OreDictionary.getOres("gemJade");
        if (!ore.isEmpty() && !gem.isEmpty()) {
            output = gem.get(0);
            output.stackSize = 4;
            for (ItemStack input : ore) {
                addRecipe(input.getItem(), output, experience);
            }
        }

    }

    public void addRecipe(ItemStack itemstack1, ItemStack itemstack2, float experience){
        putLists(itemstack1, itemstack2, experience);
    }

    public void addRecipe(Item item, ItemStack itemstack, float experience){
        addLists(item, itemstack, experience);
    }

    public void addLists(Item item, ItemStack itemstack, float experience){
        putLists(new ItemStack(item, 1, 32767), itemstack, experience);
    }

    public void putLists(ItemStack itemstack1, ItemStack itemstack2, float experience){
        processingList.put(itemstack1, itemstack2);
        experienceList.put(itemstack2, experience);
    }

    public ItemStack getProcessingResult(ItemStack itemstack) {
        Iterator iterator = processingList.entrySet().iterator();
        Map.Entry entry;

        do {
            if (!iterator.hasNext()) {
                return null;
            }
            entry = (Map.Entry) iterator.next();
        } while (!canBeSmelted(itemstack, (ItemStack) entry.getKey()));
        return (ItemStack) entry.getValue();
    }

    private boolean canBeSmelted(ItemStack itemstack1, ItemStack itemstack2) {
        return OreDictionary.itemMatches(itemstack1, itemstack2, true) || (itemstack2.getItem() == itemstack1.getItem() && (itemstack2.getItemDamage() == 32767 || itemstack2.getItemDamage() == itemstack1.getItemDamage()));
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
        while(!canBeSmelted(itemstack, (ItemStack) entry.getKey()));

        if(itemstack.getItem().getSmeltingExperience(itemstack) != -1){
            return itemstack.getItem().getSmeltingExperience(itemstack);
        }

        return (Float) entry.getValue();
    }
}
