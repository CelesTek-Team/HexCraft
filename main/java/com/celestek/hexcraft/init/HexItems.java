package com.celestek.hexcraft.init;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.BlockEnergizedHexorium;
import com.celestek.hexcraft.block.BlockEngineeringBlock;
import com.celestek.hexcraft.block.BlockHexoriumOre;
import com.celestek.hexcraft.item.HexItem;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-15
 */
public class HexItems {

    /* Hexorium Crystal */
    public static Item itemHexoriumCrystalGreen; //TODO: Change the texture!

    /**
     * Initializes all items and adds them to GameRegistry.
     */
    public static void initializeItems()
    {
        /* Hexorium Crystal */
        itemHexoriumCrystalGreen = new HexItem("itemHexoriumCrystalGreen");
        GameRegistry.registerItem(itemHexoriumCrystalGreen, "itemHexoriumCrystalGreen");
    }
}
