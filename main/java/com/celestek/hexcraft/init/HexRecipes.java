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
        ItemStack stackEnergizedHexoriumOrange_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumOrange);
        ItemStack stackEnergizedHexoriumYellow_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumYellow);
        ItemStack stackEnergizedHexoriumLime_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumLime);
        ItemStack stackEnergizedHexoriumGreen_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumGreen);
        ItemStack stackEnergizedHexoriumTurquoise_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumTurquoise);
        ItemStack stackEnergizedHexoriumCyan_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumCyan);
        ItemStack stackEnergizedHexoriumSkyBlue_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumSkyBlue);
        ItemStack stackEnergizedHexoriumBlue_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumBlue);
        ItemStack stackEnergizedHexoriumPurple_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumPurple);
        ItemStack stackEnergizedHexoriumMagenta_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumMagenta);
        ItemStack stackEnergizedHexoriumPink_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumPink);
        
        ItemStack stackEnergizedHexoriumWhite_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumWhite);
        ItemStack stackEnergizedHexoriumLightGray_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumLightGray);
        ItemStack stackEnergizedHexoriumGray_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumGray);
        ItemStack stackEnergizedHexoriumDarkGray_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumDarkGray);
        ItemStack stackEnergizedHexoriumBlack_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumBlack);

        /* Energized Hexorium */
        /* Red */
        GameRegistry.addRecipe(stackEnergizedHexoriumRed_1,
                "AAA",
                "ARA",
                "AAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1);

        /* Orange */
        GameRegistry.addRecipe(stackEnergizedHexoriumOrange_1,
                "ABA",
                "ARA",
                "ABA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumOrange_1,
                "AAA",
                "BRB",
                "AAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumOrange_1,
                "BAA",
                "ARA",
                "AAB",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumOrange_1,
                "AAB",
                "ARA",
                "BAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1);

        /* Yellow */
        GameRegistry.addRecipe(stackEnergizedHexoriumYellow_1,
                "ABA",
                "BRB",
                "ABA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumYellow_1,
                "BAB",
                "ARA",
                "BAB",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1);

        /* Lime */
        GameRegistry.addRecipe(stackEnergizedHexoriumLime_1,
                "ABA",
                "ARA",
                "ABA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumLime_1,
                "AAA",
                "BRB",
                "AAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumLime_1,
                "BAA",
                "ARA",
                "AAB",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumLime_1,
                "AAB",
                "ARA",
                "BAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1);

        /* Green */
        GameRegistry.addRecipe(stackEnergizedHexoriumGreen_1,
                "AAA",
                "ARA",
                "AAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalGreen_1);

        /* Turquoise */
        GameRegistry.addRecipe(stackEnergizedHexoriumTurquoise_1,
                "ABA",
                "ARA",
                "ABA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumTurquoise_1,
                "AAA",
                "BRB",
                "AAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumTurquoise_1,
                "BAA",
                "ARA",
                "AAB",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumTurquoise_1,
                "AAB",
                "ARA",
                "BAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1);

        /* Cyan */
        GameRegistry.addRecipe(stackEnergizedHexoriumCyan_1,
                "ABA",
                "BRB",
                "ABA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumCyan_1,
                "BAB",
                "ARA",
                "BAB",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1);

        /* SkyBlue */
        GameRegistry.addRecipe(stackEnergizedHexoriumSkyBlue_1,
                "ABA",
                "ARA",
                "ABA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumSkyBlue_1,
                "AAA",
                "BRB",
                "AAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumSkyBlue_1,
                "BAA",
                "ARA",
                "AAB",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumSkyBlue_1,
                "AAB",
                "ARA",
                "BAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1);
        
        /* Blue */
        GameRegistry.addRecipe(stackEnergizedHexoriumBlue_1,
                "AAA",
                "ARA",
                "AAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalBlue_1);

        /* Purple */
        GameRegistry.addRecipe(stackEnergizedHexoriumPurple_1,
                "ABA",
                "ARA",
                "ABA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumPurple_1,
                "AAA",
                "BRB",
                "AAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumPurple_1,
                "BAA",
                "ARA",
                "AAB",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumPurple_1,
                "AAB",
                "ARA",
                "BAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1);

        /* Magenta */
        GameRegistry.addRecipe(stackEnergizedHexoriumMagenta_1,
                "ABA",
                "BRB",
                "ABA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumMagenta_1,
                "BAB",
                "ARA",
                "BAB",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1);

        /* Pink */
        GameRegistry.addRecipe(stackEnergizedHexoriumPink_1,
                "ABA",
                "ARA",
                "ABA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumPink_1,
                "AAA",
                "BRB",
                "AAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumPink_1,
                "BAA",
                "ARA",
                "AAB",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumPink_1,
                "AAB",
                "ARA",
                "BAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1);
        
        
        /* White */
        GameRegistry.addRecipe(stackEnergizedHexoriumWhite_1,
                "AAA",
                "ARA",
                "AAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalWhite_1);

        /* LightGray */
        GameRegistry.addRecipe(stackEnergizedHexoriumLightGray_1,
                "ABA",
                "ARA",
                "ABA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumLightGray_1,
                "AAA",
                "BRB",
                "AAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumLightGray_1,
                "BAA",
                "ARA",
                "AAB",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumLightGray_1,
                "AAB",
                "ARA",
                "BAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1);

        /* Gray */
        GameRegistry.addRecipe(stackEnergizedHexoriumGray_1,
                "ABA",
                "BRB",
                "ABA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumGray_1,
                "BAB",
                "ARA",
                "BAB",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1);

        /* DarkGray */
        GameRegistry.addRecipe(stackEnergizedHexoriumDarkGray_1,
                "ABA",
                "ARA",
                "ABA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumDarkGray_1,
                "AAA",
                "BRB",
                "AAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumDarkGray_1,
                "BAA",
                "ARA",
                "AAB",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumDarkGray_1,
                "AAB",
                "ARA",
                "BAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1);
        
        /* Black */
        GameRegistry.addRecipe(stackEnergizedHexoriumBlack_1,
                "AAA",
                "ARA",
                "AAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalBlack_1);
    }
}
