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

        ItemStack stackHexoriumCrystalRed_1 = new ItemStack(HexItems.itemHexoriumCrystalRed, 1);
        ItemStack stackHexoriumCrystalGreen_1 = new ItemStack(HexItems.itemHexoriumCrystalGreen, 1);
        ItemStack stackHexoriumCrystalBlue_1 = new ItemStack(HexItems.itemHexoriumCrystalBlue, 1);
        ItemStack stackHexoriumCrystalWhite_1 = new ItemStack(HexItems.itemHexoriumCrystalWhite, 1);
        ItemStack stackHexoriumCrystalBlack_1 = new ItemStack(HexItems.itemHexoriumCrystalBlack, 1);

        ItemStack stackEnergizedHexoriumRed_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumRed);
        ItemStack stackEnergizedHexoriumGreen_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumGreen);
        ItemStack stackEnergizedHexoriumBlue_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumBlue);
        ItemStack stackEnergizedHexoriumWhite_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumWhite);
        ItemStack stackEnergizedHexoriumBlack_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumBlack);

        /* Energized Hexorium */
        /* Red */
        GameRegistry.addRecipe(stackEnergizedHexoriumRed_1,
                "AAA",
                "ARA",
                "AAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1);
        /* Green */
        GameRegistry.addRecipe(stackEnergizedHexoriumGreen_1,
                "AAA",
                "ARA",
                "AAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalGreen_1);
        /* Blue */
        GameRegistry.addRecipe(stackEnergizedHexoriumBlue_1,
                "AAA",
                "ARA",
                "AAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalBlue_1);
        /* White */
        GameRegistry.addRecipe(stackEnergizedHexoriumWhite_1,
                "AAA",
                "ARA",
                "AAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalWhite_1);
        /* Black */
        GameRegistry.addRecipe(stackEnergizedHexoriumBlack_1,
                "AAA",
                "ARA",
                "AAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalBlack_1);
    }
}
