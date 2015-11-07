package com.celestek.hexcraft.item;

import com.celestek.hexcraft.HexCraft;
import net.minecraft.item.Item;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.7.0
 */

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
}
