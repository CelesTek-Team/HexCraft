package com.celestek.hexcraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
        /* Stack init */

        // Vanilla Blocks
        ItemStack stackStone_1 = new ItemStack(Blocks.stone, 1);
        ItemStack stackStoneButton_1 = new ItemStack(Blocks.stone_button, 1);

        // Vanilla Items
        ItemStack stackRedstoneDust_1 = new ItemStack(Items.redstone, 1);
        ItemStack stackIronIngot_1 = new ItemStack(Items.iron_ingot, 1);
        ItemStack stackGoldIngot_1 = new ItemStack(Items.gold_ingot, 1);


        // Hex Blocks
        // Block of Hexorium Crystal
        ItemStack stackBlockOfHexoriumCrystalRed_1 = new ItemStack(HexBlocks.blockOfHexoriumCrystalRed, 1);
        ItemStack stackBlockOfHexoriumCrystalGreen_1 = new ItemStack(HexBlocks.blockOfHexoriumCrystalGreen, 1);
        ItemStack stackBlockOfHexoriumCrystalBlue_1 = new ItemStack(HexBlocks.blockOfHexoriumCrystalBlue, 1);
        ItemStack stackBlockOfHexoriumCrystalWhite_1 = new ItemStack(HexBlocks.blockOfHexoriumCrystalWhite, 1);
        ItemStack stackBlockOfHexoriumCrystalBlack_1 = new ItemStack(HexBlocks.blockOfHexoriumCrystalBlack, 1);
        
        // Energized Hexorium
        ItemStack stackEnergizedHexoriumRed_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumRed, 1);
        ItemStack stackEnergizedHexoriumOrange_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumOrange, 1);
        ItemStack stackEnergizedHexoriumYellow_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumYellow, 1);
        ItemStack stackEnergizedHexoriumLime_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumLime, 1);
        ItemStack stackEnergizedHexoriumGreen_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumGreen, 1);
        ItemStack stackEnergizedHexoriumTurquoise_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumTurquoise, 1);
        ItemStack stackEnergizedHexoriumCyan_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumCyan, 1);
        ItemStack stackEnergizedHexoriumSkyBlue_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumSkyBlue, 1);
        ItemStack stackEnergizedHexoriumBlue_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumBlue, 1);
        ItemStack stackEnergizedHexoriumPurple_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumPurple, 1);
        ItemStack stackEnergizedHexoriumMagenta_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumMagenta, 1);
        ItemStack stackEnergizedHexoriumPink_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumPink, 1);
        
        ItemStack stackEnergizedHexoriumWhite_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumWhite, 1);
        ItemStack stackEnergizedHexoriumLightGray_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumLightGray, 1);
        ItemStack stackEnergizedHexoriumGray_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumGray, 1);
        ItemStack stackEnergizedHexoriumDarkGray_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumDarkGray, 1);
        ItemStack stackEnergizedHexoriumBlack_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumBlack, 1);
        
        ItemStack stackEnergizedHexoriumRainbow_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumRainbow, 1);

        // Engineered Hexorium Block
        ItemStack stackEngineeredHexoriumBlockRed_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockRed, 1);
        ItemStack stackEngineeredHexoriumBlockOrange_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockOrange, 1);
        ItemStack stackEngineeredHexoriumBlockYellow_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockYellow, 1);
        ItemStack stackEngineeredHexoriumBlockLime_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockLime, 1);
        ItemStack stackEngineeredHexoriumBlockGreen_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockGreen, 1);
        ItemStack stackEngineeredHexoriumBlockTurquoise_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockTurquoise, 1);
        ItemStack stackEngineeredHexoriumBlockCyan_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockCyan, 1);
        ItemStack stackEngineeredHexoriumBlockSkyBlue_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockSkyBlue, 1);
        ItemStack stackEngineeredHexoriumBlockBlue_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockBlue, 1);
        ItemStack stackEngineeredHexoriumBlockPurple_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockPurple, 1);
        ItemStack stackEngineeredHexoriumBlockMagenta_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockMagenta, 1);
        ItemStack stackEngineeredHexoriumBlockPink_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockPink, 1);

        ItemStack stackEngineeredHexoriumBlockWhite_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockWhite, 1);
        ItemStack stackEngineeredHexoriumBlockLightGray_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockLightGray, 1);
        ItemStack stackEngineeredHexoriumBlockGray_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockGray, 1);
        ItemStack stackEngineeredHexoriumBlockDarkGray_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockDarkGray, 1);
        ItemStack stackEngineeredHexoriumBlockBlack_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockBlack, 1);

        ItemStack stackEngineeredHexoriumBlockRainbow_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockRainbow, 1);

        // Framed Hexorium Block
        ItemStack stackFramedHexoriumBlockRed_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockRed, 1);
        ItemStack stackFramedHexoriumBlockOrange_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockOrange, 1);
        ItemStack stackFramedHexoriumBlockYellow_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockYellow, 1);
        ItemStack stackFramedHexoriumBlockLime_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockLime, 1);
        ItemStack stackFramedHexoriumBlockGreen_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockGreen, 1);
        ItemStack stackFramedHexoriumBlockTurquoise_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockTurquoise, 1);
        ItemStack stackFramedHexoriumBlockCyan_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockCyan, 1);
        ItemStack stackFramedHexoriumBlockSkyBlue_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockSkyBlue, 1);
        ItemStack stackFramedHexoriumBlockBlue_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockBlue, 1);
        ItemStack stackFramedHexoriumBlockPurple_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockPurple, 1);
        ItemStack stackFramedHexoriumBlockMagenta_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockMagenta, 1);
        ItemStack stackFramedHexoriumBlockPink_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockPink, 1);

        ItemStack stackFramedHexoriumBlockWhite_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockWhite, 1);
        ItemStack stackFramedHexoriumBlockLightGray_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockLightGray, 1);
        ItemStack stackFramedHexoriumBlockGray_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockGray, 1);
        ItemStack stackFramedHexoriumBlockDarkGray_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockDarkGray, 1);
        ItemStack stackFramedHexoriumBlockBlack_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockBlack, 1);

        ItemStack stackFramedHexoriumBlockRainbow_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockRainbow, 1);


        // Hex Items
        // Raw Materials
        ItemStack stackHexoriumCrystalRed_1 = new ItemStack(HexItems.itemHexoriumCrystalRed, 1);
        ItemStack stackHexoriumCrystalGreen_1 = new ItemStack(HexItems.itemHexoriumCrystalGreen, 1);
        ItemStack stackHexoriumCrystalBlue_1 = new ItemStack(HexItems.itemHexoriumCrystalBlue, 1);
        ItemStack stackHexoriumCrystalWhite_1 = new ItemStack(HexItems.itemHexoriumCrystalWhite, 1);
        ItemStack stackHexoriumCrystalBlack_1 = new ItemStack(HexItems.itemHexoriumCrystalBlack, 1);
        ItemStack stackHexoriumCrystalRed_9 = new ItemStack(HexItems.itemHexoriumCrystalRed, 9);
        ItemStack stackHexoriumCrystalGreen_9 = new ItemStack(HexItems.itemHexoriumCrystalGreen, 9);
        ItemStack stackHexoriumCrystalBlue_9 = new ItemStack(HexItems.itemHexoriumCrystalBlue, 9);
        ItemStack stackHexoriumCrystalWhite_9 = new ItemStack(HexItems.itemHexoriumCrystalWhite, 9);
        ItemStack stackHexoriumCrystalBlack_9 = new ItemStack(HexItems.itemHexoriumCrystalBlack, 9);

        // Components T1
        ItemStack stackRainbowEnergizedGlobule_1 = new ItemStack(HexItems.itemRainbowEnergizedGlobule, 1);
        ItemStack stackWhiteHexoriumWafer_1 = new ItemStack(HexItems.itemWhiteHexoriumWafer, 1);
        ItemStack stackBlackHexoriumWafer_1 = new ItemStack(HexItems.itemBlackHexoriumWafer, 1);

        // Components T2
        ItemStack stackRainbowCore_1 = new ItemStack(HexItems.itemRainbowCore, 1);
        ItemStack stackHexoriumCoprocessor_1 = new ItemStack(HexItems.itemHexoriumCoprocessor, 1);
        ItemStack stackHexoriumProcessor_1 = new ItemStack(HexItems.itemHexoriumProcessor, 1);

        // Tools
        ItemStack stackHexoriumManipulator_1 = new ItemStack(HexItems.itemHexoriumManipulator, 1);


        /* Recipe init */

        // Hex Blocks
        // Block of Hexorium Crystal
        GameRegistry.addRecipe(stackBlockOfHexoriumCrystalRed_1,
                "AAA",
                "AAA",
                "AAA",
                'A', stackHexoriumCrystalRed_1);
        GameRegistry.addShapelessRecipe(stackHexoriumCrystalRed_9, stackBlockOfHexoriumCrystalRed_1);
        GameRegistry.addRecipe(stackBlockOfHexoriumCrystalGreen_1,
                "AAA",
                "AAA",
                "AAA",
                'A', stackHexoriumCrystalGreen_1);
        GameRegistry.addShapelessRecipe(stackHexoriumCrystalGreen_9, stackBlockOfHexoriumCrystalGreen_1);
        GameRegistry.addRecipe(stackBlockOfHexoriumCrystalBlue_1,
                "AAA",
                "AAA",
                "AAA",
                'A', stackHexoriumCrystalBlue_1);
        GameRegistry.addShapelessRecipe(stackHexoriumCrystalBlue_9, stackBlockOfHexoriumCrystalBlue_1);
        GameRegistry.addRecipe(stackBlockOfHexoriumCrystalWhite_1,
                "AAA",
                "AAA",
                "AAA",
                'A', stackHexoriumCrystalWhite_1);
        GameRegistry.addShapelessRecipe(stackHexoriumCrystalWhite_9, stackBlockOfHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackBlockOfHexoriumCrystalBlack_1,
                "AAA",
                "AAA",
                "AAA",
                'A', stackHexoriumCrystalBlack_1);
        GameRegistry.addShapelessRecipe(stackHexoriumCrystalBlack_9, stackBlockOfHexoriumCrystalBlack_1);
        
        // Energized Hexorium
        // Red
        GameRegistry.addRecipe(stackEnergizedHexoriumRed_1,
                "AAA",
                "ARA",
                "AAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1);

        // Orange
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

        // Yellow
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

        // Lime
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

        // Green
        GameRegistry.addRecipe(stackEnergizedHexoriumGreen_1,
                "AAA",
                "ARA",
                "AAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalGreen_1);

        // Turquoise
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

        // Cyan
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

        // SkyBlue
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
        
        // Blue
        GameRegistry.addRecipe(stackEnergizedHexoriumBlue_1,
                "AAA",
                "ARA",
                "AAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalBlue_1);

        // Purple
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

        // Magenta
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

        // Pink
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
        
        
        // White
        GameRegistry.addRecipe(stackEnergizedHexoriumWhite_1,
                "AAA",
                "ARA",
                "AAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalWhite_1);

        // LightGray
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

        // Gray
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

        // DarkGray
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
        
        // Black
        GameRegistry.addRecipe(stackEnergizedHexoriumBlack_1,
                "AAA",
                "ARA",
                "AAA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalBlack_1);

        
        // Rainbow        
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "ABC",
                "DRD",
                "CBA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "ABD",
                "CRC",
                "DBA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "ACB",
                "DRD",
                "BCA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "ACD",
                "BRB",
                "DCA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "ADB",
                "CRC",
                "BDA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "ADC",
                "BRB",
                "CDA",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "BAC",
                "DRD",
                "CAB",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "BAD",
                "CRC",
                "DAB",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "BCA",
                "DRD",
                "ACB",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "BCD",
                "ARA",
                "DCB",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "BDA",
                "CRC",
                "ADB",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "BDC",
                "ARA",
                "CDB",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "CAB",
                "DRD",
                "BAC",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "CAD",
                "BRB",
                "DAC",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "CBA",
                "DRD",
                "ABC",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "CBD",
                "ARA",
                "DBC",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "CDA",
                "BRB",
                "ADC",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "CDB",
                "ARA",
                "BDC",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "DAB",
                "CRC",
                "BAD",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "DAC",
                "BRB",
                "CAD",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "DBA",
                "CRC",
                "ABD",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "DBC",
                "ARA",
                "CBD",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "DCA",
                "BRB",
                "ACD",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "DCB",
                "ARA",
                "BCD",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);


        // Engineered Hexorium Block
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockRed_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumRed_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockOrange_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumOrange_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockYellow_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumYellow_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockLime_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumLime_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockGreen_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumGreen_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockTurquoise_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumTurquoise_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockCyan_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumCyan_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockSkyBlue_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumSkyBlue_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockBlue_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumBlue_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockPurple_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumPurple_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockMagenta_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumMagenta_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockPink_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumPink_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockWhite_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumWhite_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockLightGray_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumLightGray_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockGray_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumGray_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockDarkGray_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumDarkGray_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockBlack_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumBlack_1, 'A', stackIronIngot_1, 'B', stackStone_1);
        
        GameRegistry.addRecipe(stackEngineeredHexoriumBlockRainbow_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumRainbow_1, 'A', stackIronIngot_1, 'B', stackStone_1);


        // Framed Hexorium Block
        GameRegistry.addRecipe(stackFramedHexoriumBlockRed_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumRed_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockOrange_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumOrange_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockYellow_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumYellow_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockLime_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumLime_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockGreen_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumGreen_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockTurquoise_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumTurquoise_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockCyan_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumCyan_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockSkyBlue_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumSkyBlue_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockBlue_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumBlue_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockPurple_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumPurple_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockMagenta_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumMagenta_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockPink_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumPink_1, 'A', stackIronIngot_1);

        GameRegistry.addRecipe(stackFramedHexoriumBlockWhite_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumWhite_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockLightGray_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumLightGray_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockGray_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumGray_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockDarkGray_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumDarkGray_1, 'A', stackIronIngot_1);
        GameRegistry.addRecipe(stackFramedHexoriumBlockBlack_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumBlack_1, 'A', stackIronIngot_1);

        GameRegistry.addRecipe(stackFramedHexoriumBlockRainbow_1,
                "A A",
                " H ",
                "A A",
                'H', stackEnergizedHexoriumRainbow_1, 'A', stackIronIngot_1);


        // Hex Items
        // Components T1
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " B ",
                "ARC",
                " D ",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " B ",
                "ARD",
                " C ",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " C ",
                "ARB",
                " D ",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " C ",
                "ARD",
                " B ",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " D ",
                "ARB",
                " C ",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " D ",
                "ARC",
                " B ",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " A ",
                "BRC",
                " D ",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " A ",
                "BRD",
                " C ",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " C ",
                "BRA",
                " D ",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " C ",
                "BRD",
                " A ",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " D ",
                "BRA",
                " C ",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " D ",
                "BRC",
                " A ",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " A ",
                "CRB",
                " D ",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " A ",
                "CRD",
                " B ",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " B ",
                "CRA",
                " D ",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " B ",
                "CRD",
                " A ",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " D ",
                "CRA",
                " B ",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " D ",
                "CRB",
                " A ",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " A ",
                "DRB",
                " C ",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " A ",
                "DRC",
                " B ",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " B ",
                "DRA",
                " C ",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " B ",
                "DRC",
                " A ",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " C ",
                "DRA",
                " B ",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " C ",
                "DRB",
                " A ",
                'R', stackRedstoneDust_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);

        GameRegistry.addSmelting(stackHexoriumCrystalWhite_1, stackWhiteHexoriumWafer_1, 0F);
        GameRegistry.addSmelting(stackHexoriumCrystalBlack_1, stackBlackHexoriumWafer_1, 0F);

        // Components T2
        GameRegistry.addRecipe(stackRainbowCore_1,
                "BRB",
                "CAC",
                "BRB",
                'R', stackRedstoneDust_1, 'A', stackRainbowEnergizedGlobule_1, 'B', stackIronIngot_1, 'C', stackGoldIngot_1);
        GameRegistry.addRecipe(stackHexoriumCoprocessor_1,
                " R ",
                "RAR",
                " B ",
                'R', stackRedstoneDust_1, 'A', stackWhiteHexoriumWafer_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumProcessor_1,
                " R ",
                "RAR",
                " B ",
                'R', stackRedstoneDust_1, 'A', stackBlackHexoriumWafer_1, 'B', stackIronIngot_1);

        // Tools
        GameRegistry.addRecipe(stackHexoriumManipulator_1,
                "EAE",
                "CBD",
                " EF",
                'A', stackHexoriumCrystalBlack_1, 'B', stackRainbowCore_1, 'C', stackHexoriumProcessor_1, 'D', stackHexoriumCoprocessor_1, 'E', stackIronIngot_1, 'F', stackStoneButton_1);
    }
}
