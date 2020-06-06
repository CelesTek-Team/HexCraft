package com.celestek.hexcraft.item;

import com.celestek.hexcraft.HexCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemMortarPestle extends Item {

    // Item ID
    public static final String ID = "itemMortarPestle";

    /**
     * Constructor for the item.
     * @param itemName Unlocalized name for the item.
     */
    public ItemMortarPestle(String itemName) {
        setUnlocalizedName(itemName);
        setCreativeTab(HexCraft.tabMachines);
        setMaxStackSize(1);
        setTextureName(HexCraft.MODID + ":" + itemName);
    }

    @Override
    public boolean hasContainerItem(ItemStack itemStack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        return itemStack;
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack) {
        return false;
    }

    public static Item registerItem() {
        Item item = new ItemMortarPestle(ID);
        GameRegistry.registerItem(item, ID);
        return item;
    }
}
