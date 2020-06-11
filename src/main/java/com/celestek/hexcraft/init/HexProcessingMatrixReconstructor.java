package com.celestek.hexcraft.init;

import com.celestek.hexcraft.block.BlockEnergizedHexorium;
import com.celestek.hexcraft.block.BlockEnergizedHexoriumMonolith;
import com.celestek.hexcraft.util.HexEnums;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HexProcessingMatrixReconstructor {

    private static final HexProcessingMatrixReconstructor PROCESSING_BASE = new HexProcessingMatrixReconstructor();

    private final HashMap<ItemStack, ItemStack> processingList = new HashMap<>();

    public static HexProcessingMatrixReconstructor processing() {
        return PROCESSING_BASE;
    }

    private HexProcessingMatrixReconstructor() {
        // Energized Hexorium Monolith

        for (HexEnums.Colors color : HexEnums.Colors.values())
            addRecipe(Item.getItemFromBlock(HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, color)), new ItemStack(HexBlocks.getHexBlock(BlockEnergizedHexoriumMonolith.ID, color)));
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
