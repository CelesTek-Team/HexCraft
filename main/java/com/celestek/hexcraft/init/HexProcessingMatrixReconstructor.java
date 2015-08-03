package com.celestek.hexcraft.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.6.0
 * @since 2015-04-25
 */
public class HexProcessingMatrixReconstructor {

    private static final HexProcessingMatrixReconstructor PROCESSING_BASE = new HexProcessingMatrixReconstructor();

    private Map processingList = new HashMap();
    private Map experienceList = new HashMap();

    public static HexProcessingMatrixReconstructor processing() {
        return PROCESSING_BASE;
    }

    private HexProcessingMatrixReconstructor() {
        // Give 0 experience.
        float experience = 0F;

        // Energized Hexorium Monolith
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumRed), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithRed), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumOrange), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithOrange), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumYellow), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithYellow), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumLime), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithLime), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumGreen), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithGreen), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumTurquoise), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithTurquoise), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumCyan), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithCyan), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumSkyBlue), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithSkyBlue), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumBlue), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithBlue), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumPurple), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithPurple), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumMagenta), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithMagenta), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumPink), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithPink), experience);

        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumWhite), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithWhite), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumLightGray), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithLightGray), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumGray), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithGray), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumDarkGray), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithDarkGray), experience);
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumBlack), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithBlack), experience);

        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumRainbow), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithRainbow), experience);
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
        return itemstack2.getItem() == itemstack1.getItem() && (itemstack2.getItemDamage() == 32767 || itemstack2.getItemDamage() == itemstack1.getItemDamage());
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
