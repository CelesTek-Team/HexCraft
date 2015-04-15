package com.celestek.hexcraft.item;

import com.celestek.hexcraft.HexCraft;
import net.minecraft.item.Item;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-15
 */

public class HexItem extends Item {

    /**
     * Constructor for the item.
     * @param itemName Unlocalized name for the item.
     */
    public HexItem(String itemName) {
        setUnlocalizedName(itemName);
        setCreativeTab(HexCraft.hexCraftTab);
        setMaxStackSize(64);
        setTextureName(HexCraft.MODID + ":" + itemName);
    }
}
