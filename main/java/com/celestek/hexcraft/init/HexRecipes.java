package com.celestek.hexcraft.init;

import com.celestek.hexcraft.item.HexItem;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-15
 */
public class HexRecipes {

    /**
     * Initializes all recipes and adds them to GameRegistry.
     */
    public static void initializeRecipes()
    {
        ItemStack stackRedstoneDust_1 = new ItemStack(Items.redstone, 1);

        ItemStack stackHexoriumCrystalGreen_1 = new ItemStack(HexItems.itemHexoriumCrystalGreen, 1);

        ItemStack stackEnergizedHexoriumGreen_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumGreen);

        GameRegistry.addRecipe(stackEnergizedHexoriumGreen_1,
                "CCC",
                "CRC",
                "CCC",
                'R', stackRedstoneDust_1, 'C', stackHexoriumCrystalGreen_1);
    }
}
