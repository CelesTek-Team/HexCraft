package com.celestek.hexcraft.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.8.1
 */

public class HexProcessingMatrixReconstructor {

    private static final HexProcessingMatrixReconstructor PROCESSING_BASE = new HexProcessingMatrixReconstructor();

    private Map processingList = new HashMap();

    public static HexProcessingMatrixReconstructor processing() {
        return PROCESSING_BASE;
    }

    private HexProcessingMatrixReconstructor() {
        // Energized Hexorium Monolith
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumRed), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithRed));
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumOrange), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithOrange));
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumYellow), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithYellow));
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumLime), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithLime));
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumGreen), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithGreen));
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumTurquoise), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithTurquoise));
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumCyan), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithCyan));
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumSkyBlue), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithSkyBlue));
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumBlue), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithBlue));
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumPurple), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithPurple));
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumMagenta), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithMagenta));
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumPink), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithPink));

        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumWhite), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithWhite));
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumLightGray), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithLightGray));
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumGray), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithGray));
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumDarkGray), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithDarkGray));
        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumBlack), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithBlack));

        addRecipe(Item.getItemFromBlock(HexBlocks.blockEnergizedHexoriumRainbow), new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithRainbow));
    }

    public void addRecipe(Item item, ItemStack itemstack){
        addLists(item, itemstack);
    }

    public void addLists(Item item, ItemStack itemstack){
        putLists(new ItemStack(item, 1, 32767), itemstack);
    }

    public void putLists(ItemStack itemstack1, ItemStack itemstack2){
        processingList.put(itemstack1, itemstack2);
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
}
