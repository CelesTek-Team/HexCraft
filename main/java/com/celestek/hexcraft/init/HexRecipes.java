package com.celestek.hexcraft.init;

import com.celestek.hexcraft.item.HexItem;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
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
        /* Vanilla Blocks */
        ItemStack stackStone_1 = new ItemStack(Blocks.stone);

        /* Vanilla Items */
        ItemStack stackRedstoneDust_1 = new ItemStack(Items.redstone, 1);
        ItemStack stackIronIngot_1 = new ItemStack(Items.iron_ingot, 1);


        /* Hexorium Crystals */
        ItemStack stackHexoriumCrystalRed_1 = new ItemStack(HexItems.itemHexoriumCrystalRed, 1);
        ItemStack stackHexoriumCrystalGreen_1 = new ItemStack(HexItems.itemHexoriumCrystalGreen, 1);
        ItemStack stackHexoriumCrystalBlue_1 = new ItemStack(HexItems.itemHexoriumCrystalBlue, 1);
        ItemStack stackHexoriumCrystalWhite_1 = new ItemStack(HexItems.itemHexoriumCrystalWhite, 1);
        ItemStack stackHexoriumCrystalBlack_1 = new ItemStack(HexItems.itemHexoriumCrystalBlack, 1);

        
        /* Energized Hexorium */
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
        
        ItemStack stackEnergizedHexoriumRainbow_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumRainbow);

        
        /* Engineered Hexorium Block */
        ItemStack stackEngineeredHexoriumBlockRed_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockRed);
        ItemStack stackEngineeredHexoriumBlockOrange_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockOrange);
        ItemStack stackEngineeredHexoriumBlockYellow_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockYellow);
        ItemStack stackEngineeredHexoriumBlockLime_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockLime);
        ItemStack stackEngineeredHexoriumBlockGreen_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockGreen);
        ItemStack stackEngineeredHexoriumBlockTurquoise_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockTurquoise);
        ItemStack stackEngineeredHexoriumBlockCyan_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockCyan);
        ItemStack stackEngineeredHexoriumBlockSkyBlue_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockSkyBlue);
        ItemStack stackEngineeredHexoriumBlockBlue_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockBlue);
        ItemStack stackEngineeredHexoriumBlockPurple_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockPurple);
        ItemStack stackEngineeredHexoriumBlockMagenta_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockMagenta);
        ItemStack stackEngineeredHexoriumBlockPink_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockPink);

        ItemStack stackEngineeredHexoriumBlockWhite_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockWhite);
        ItemStack stackEngineeredHexoriumBlockLightGray_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockLightGray);
        ItemStack stackEngineeredHexoriumBlockGray_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockGray);
        ItemStack stackEngineeredHexoriumBlockDarkGray_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockDarkGray);
        ItemStack stackEngineeredHexoriumBlockBlack_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockBlack);

        ItemStack stackEngineeredHexoriumBlockRainbow_1 = new ItemStack(HexBlocks.blockEngineeredHexoriumBlockRainbow);

        
        /* Framed Hexorium Block */
        ItemStack stackFramedHexoriumBlockRed_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockRed);
        ItemStack stackFramedHexoriumBlockOrange_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockOrange);
        ItemStack stackFramedHexoriumBlockYellow_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockYellow);
        ItemStack stackFramedHexoriumBlockLime_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockLime);
        ItemStack stackFramedHexoriumBlockGreen_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockGreen);
        ItemStack stackFramedHexoriumBlockTurquoise_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockTurquoise);
        ItemStack stackFramedHexoriumBlockCyan_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockCyan);
        ItemStack stackFramedHexoriumBlockSkyBlue_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockSkyBlue);
        ItemStack stackFramedHexoriumBlockBlue_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockBlue);
        ItemStack stackFramedHexoriumBlockPurple_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockPurple);
        ItemStack stackFramedHexoriumBlockMagenta_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockMagenta);
        ItemStack stackFramedHexoriumBlockPink_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockPink);

        ItemStack stackFramedHexoriumBlockWhite_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockWhite);
        ItemStack stackFramedHexoriumBlockLightGray_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockLightGray);
        ItemStack stackFramedHexoriumBlockGray_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockGray);
        ItemStack stackFramedHexoriumBlockDarkGray_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockDarkGray);
        ItemStack stackFramedHexoriumBlockBlack_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockBlack);

        ItemStack stackFramedHexoriumBlockRainbow_1 = new ItemStack(HexBlocks.blockFramedHexoriumBlockRainbow);

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

        
        /* Rainbow */        
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


        /* Engineered Hexorium Block */
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


        /* Framed Hexorium Block */
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
    }
}
