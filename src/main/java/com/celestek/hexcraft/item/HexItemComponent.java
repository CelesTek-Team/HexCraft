package com.celestek.hexcraft.item;

import com.celestek.hexcraft.HexCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class HexItemComponent extends Item {

    /**
     * Constructor for the item.
     * @param itemName Unlocalized name for the item.
     */
    public HexItemComponent(String itemName) {
        setUnlocalizedName(itemName);
        setCreativeTab(HexCraft.tabComponents);
        setMaxStackSize(64);
        setTextureName(HexCraft.MODID + ":" + itemName);
    }

    public static Item registerItem(String name, boolean enabled) {
        if (enabled)
            return registerItem(name);
        else
            return null;
    }

    public static Item registerItem(String name) {
        Item item = new HexItemComponent(name);
        GameRegistry.registerItem(item, name);
        return item;
    }
}
