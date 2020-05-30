package com.celestek.hexcraft.init;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.item.IC2Items;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class HexRecipes {

    /**
     * Initializes all recipes and adds them to GameRegistry.
     */
    public static void initializeRecipes() {
        /* Stack init */

        // Vanilla Blocks
        ItemStack stackObsidian_1 = new ItemStack(Blocks.obsidian, 1);
        ItemStack stackStoneButton_1 = new ItemStack(Blocks.stone_button, 1);
        ItemStack stackHeavyWeightedPressurePlate_1 = new ItemStack(Blocks.heavy_weighted_pressure_plate, 1);
        ItemStack stackLever_1 = new ItemStack(Blocks.lever, 1);
        ItemStack stackRedstoneTorch_1 = new ItemStack(Blocks.redstone_torch, 1);
        ItemStack stackRedstoneBlock_1 = new ItemStack(Blocks.redstone_block, 1);
        ItemStack stackIronBars_1 = new ItemStack(Blocks.iron_bars, 1);

        // Vanilla Items
        ItemStack stackRedstone_1 = new ItemStack(Items.redstone, 1);
        ItemStack stackGlowstoneDust_1 = new ItemStack(Items.glowstone_dust, 1);
        ItemStack stackIronPickaxe_1 = new ItemStack(Items.iron_pickaxe, 1);
        ItemStack stackEnderEye_1 = new ItemStack(Items.ender_eye, 1);


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

        // Plated Hexorium Block
        ItemStack stackPlatedHexoriumBlockRed_1 = new ItemStack(HexBlocks.blockPlatedHexoriumBlockRed, 1);
        ItemStack stackPlatedHexoriumBlockOrange_1 = new ItemStack(HexBlocks.blockPlatedHexoriumBlockOrange, 1);
        ItemStack stackPlatedHexoriumBlockYellow_1 = new ItemStack(HexBlocks.blockPlatedHexoriumBlockYellow, 1);
        ItemStack stackPlatedHexoriumBlockLime_1 = new ItemStack(HexBlocks.blockPlatedHexoriumBlockLime, 1);
        ItemStack stackPlatedHexoriumBlockGreen_1 = new ItemStack(HexBlocks.blockPlatedHexoriumBlockGreen, 1);
        ItemStack stackPlatedHexoriumBlockTurquoise_1 = new ItemStack(HexBlocks.blockPlatedHexoriumBlockTurquoise, 1);
        ItemStack stackPlatedHexoriumBlockCyan_1 = new ItemStack(HexBlocks.blockPlatedHexoriumBlockCyan, 1);
        ItemStack stackPlatedHexoriumBlockSkyBlue_1 = new ItemStack(HexBlocks.blockPlatedHexoriumBlockSkyBlue, 1);
        ItemStack stackPlatedHexoriumBlockBlue_1 = new ItemStack(HexBlocks.blockPlatedHexoriumBlockBlue, 1);
        ItemStack stackPlatedHexoriumBlockPurple_1 = new ItemStack(HexBlocks.blockPlatedHexoriumBlockPurple, 1);
        ItemStack stackPlatedHexoriumBlockMagenta_1 = new ItemStack(HexBlocks.blockPlatedHexoriumBlockMagenta, 1);
        ItemStack stackPlatedHexoriumBlockPink_1 = new ItemStack(HexBlocks.blockPlatedHexoriumBlockPink, 1);

        ItemStack stackPlatedHexoriumBlockWhite_1 = new ItemStack(HexBlocks.blockPlatedHexoriumBlockWhite, 1);
        ItemStack stackPlatedHexoriumBlockLightGray_1 = new ItemStack(HexBlocks.blockPlatedHexoriumBlockLightGray, 1);
        ItemStack stackPlatedHexoriumBlockGray_1 = new ItemStack(HexBlocks.blockPlatedHexoriumBlockGray, 1);
        ItemStack stackPlatedHexoriumBlockDarkGray_1 = new ItemStack(HexBlocks.blockPlatedHexoriumBlockDarkGray, 1);
        ItemStack stackPlatedHexoriumBlockBlack_1 = new ItemStack(HexBlocks.blockPlatedHexoriumBlockBlack, 1);

        ItemStack stackPlatedHexoriumBlockRainbow_1 = new ItemStack(HexBlocks.blockPlatedHexoriumBlockRainbow, 1);

        // Concentric Hexorium Block
        ItemStack stackConcentricHexoriumBlockRed_1 = new ItemStack(HexBlocks.blockConcentricHexoriumBlockRed, 1);
        ItemStack stackConcentricHexoriumBlockOrange_1 = new ItemStack(HexBlocks.blockConcentricHexoriumBlockOrange, 1);
        ItemStack stackConcentricHexoriumBlockYellow_1 = new ItemStack(HexBlocks.blockConcentricHexoriumBlockYellow, 1);
        ItemStack stackConcentricHexoriumBlockLime_1 = new ItemStack(HexBlocks.blockConcentricHexoriumBlockLime, 1);
        ItemStack stackConcentricHexoriumBlockGreen_1 = new ItemStack(HexBlocks.blockConcentricHexoriumBlockGreen, 1);
        ItemStack stackConcentricHexoriumBlockTurquoise_1 = new ItemStack(HexBlocks.blockConcentricHexoriumBlockTurquoise, 1);
        ItemStack stackConcentricHexoriumBlockCyan_1 = new ItemStack(HexBlocks.blockConcentricHexoriumBlockCyan, 1);
        ItemStack stackConcentricHexoriumBlockSkyBlue_1 = new ItemStack(HexBlocks.blockConcentricHexoriumBlockSkyBlue, 1);
        ItemStack stackConcentricHexoriumBlockBlue_1 = new ItemStack(HexBlocks.blockConcentricHexoriumBlockBlue, 1);
        ItemStack stackConcentricHexoriumBlockPurple_1 = new ItemStack(HexBlocks.blockConcentricHexoriumBlockPurple, 1);
        ItemStack stackConcentricHexoriumBlockMagenta_1 = new ItemStack(HexBlocks.blockConcentricHexoriumBlockMagenta, 1);
        ItemStack stackConcentricHexoriumBlockPink_1 = new ItemStack(HexBlocks.blockConcentricHexoriumBlockPink, 1);

        ItemStack stackConcentricHexoriumBlockWhite_1 = new ItemStack(HexBlocks.blockConcentricHexoriumBlockWhite, 1);
        ItemStack stackConcentricHexoriumBlockLightGray_1 = new ItemStack(HexBlocks.blockConcentricHexoriumBlockLightGray, 1);
        ItemStack stackConcentricHexoriumBlockGray_1 = new ItemStack(HexBlocks.blockConcentricHexoriumBlockGray, 1);
        ItemStack stackConcentricHexoriumBlockDarkGray_1 = new ItemStack(HexBlocks.blockConcentricHexoriumBlockDarkGray, 1);
        ItemStack stackConcentricHexoriumBlockBlack_1 = new ItemStack(HexBlocks.blockConcentricHexoriumBlockBlack, 1);

        ItemStack stackConcentricHexoriumBlockRainbow_1 = new ItemStack(HexBlocks.blockConcentricHexoriumBlockRainbow, 1);

        // Hexorium Structure Casing
        ItemStack stackHexoriumStructureCasingRed_1 = new ItemStack(HexBlocks.blockHexoriumStructureCasingRed, 1);
        ItemStack stackHexoriumStructureCasingOrange_1 = new ItemStack(HexBlocks.blockHexoriumStructureCasingOrange, 1);
        ItemStack stackHexoriumStructureCasingYellow_1 = new ItemStack(HexBlocks.blockHexoriumStructureCasingYellow, 1);
        ItemStack stackHexoriumStructureCasingLime_1 = new ItemStack(HexBlocks.blockHexoriumStructureCasingLime, 1);
        ItemStack stackHexoriumStructureCasingGreen_1 = new ItemStack(HexBlocks.blockHexoriumStructureCasingGreen, 1);
        ItemStack stackHexoriumStructureCasingTurquoise_1 = new ItemStack(HexBlocks.blockHexoriumStructureCasingTurquoise, 1);
        ItemStack stackHexoriumStructureCasingCyan_1 = new ItemStack(HexBlocks.blockHexoriumStructureCasingCyan, 1);
        ItemStack stackHexoriumStructureCasingSkyBlue_1 = new ItemStack(HexBlocks.blockHexoriumStructureCasingSkyBlue, 1);
        ItemStack stackHexoriumStructureCasingBlue_1 = new ItemStack(HexBlocks.blockHexoriumStructureCasingBlue, 1);
        ItemStack stackHexoriumStructureCasingPurple_1 = new ItemStack(HexBlocks.blockHexoriumStructureCasingPurple, 1);
        ItemStack stackHexoriumStructureCasingMagenta_1 = new ItemStack(HexBlocks.blockHexoriumStructureCasingMagenta, 1);
        ItemStack stackHexoriumStructureCasingPink_1 = new ItemStack(HexBlocks.blockHexoriumStructureCasingPink, 1);

        ItemStack stackHexoriumStructureCasingWhite_1 = new ItemStack(HexBlocks.blockHexoriumStructureCasingWhite, 1);
        ItemStack stackHexoriumStructureCasingLightGray_1 = new ItemStack(HexBlocks.blockHexoriumStructureCasingLightGray, 1);
        ItemStack stackHexoriumStructureCasingGray_1 = new ItemStack(HexBlocks.blockHexoriumStructureCasingGray, 1);
        ItemStack stackHexoriumStructureCasingDarkGray_1 = new ItemStack(HexBlocks.blockHexoriumStructureCasingDarkGray, 1);
        ItemStack stackHexoriumStructureCasingBlack_1 = new ItemStack(HexBlocks.blockHexoriumStructureCasingBlack, 1);

        ItemStack stackHexoriumStructureCasingRainbow_1 = new ItemStack(HexBlocks.blockHexoriumStructureCasingRainbow, 1);

        // Glowing Hexorium-Coated Stone
        ItemStack stackGlowingHexoriumCoatedStoneRed_8 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneRed, 8);
        ItemStack stackGlowingHexoriumCoatedStoneOrange_8 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneOrange, 8);
        ItemStack stackGlowingHexoriumCoatedStoneYellow_8 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneYellow, 8);
        ItemStack stackGlowingHexoriumCoatedStoneLime_8 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneLime, 8);
        ItemStack stackGlowingHexoriumCoatedStoneGreen_8 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneGreen, 8);
        ItemStack stackGlowingHexoriumCoatedStoneTurquoise_8 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneTurquoise, 8);
        ItemStack stackGlowingHexoriumCoatedStoneCyan_8 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneCyan, 8);
        ItemStack stackGlowingHexoriumCoatedStoneSkyBlue_8 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneSkyBlue, 8);
        ItemStack stackGlowingHexoriumCoatedStoneBlue_8 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneBlue, 8);
        ItemStack stackGlowingHexoriumCoatedStonePurple_8 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStonePurple, 8);
        ItemStack stackGlowingHexoriumCoatedStoneMagenta_8 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneMagenta, 8);
        ItemStack stackGlowingHexoriumCoatedStonePink_8 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStonePink, 8);

        ItemStack stackGlowingHexoriumCoatedStoneWhite_8 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneWhite, 8);
        ItemStack stackGlowingHexoriumCoatedStoneLightGray_8 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneLightGray, 8);
        ItemStack stackGlowingHexoriumCoatedStoneGray_8 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneGray, 8);
        ItemStack stackGlowingHexoriumCoatedStoneDarkGray_8 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneDarkGray, 8);
        ItemStack stackGlowingHexoriumCoatedStoneBlack_8 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneBlack, 8);

        ItemStack stackGlowingHexoriumCoatedStoneRainbow_8 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneRainbow, 8);

        ItemStack stackGlowingHexoriumCoatedStoneRed_1 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneRed, 1);
        ItemStack stackGlowingHexoriumCoatedStoneOrange_1 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneOrange, 1);
        ItemStack stackGlowingHexoriumCoatedStoneYellow_1 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneYellow, 1);
        ItemStack stackGlowingHexoriumCoatedStoneLime_1 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneLime, 1);
        ItemStack stackGlowingHexoriumCoatedStoneGreen_1 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneGreen, 1);
        ItemStack stackGlowingHexoriumCoatedStoneTurquoise_1 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneTurquoise, 1);
        ItemStack stackGlowingHexoriumCoatedStoneCyan_1 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneCyan, 1);
        ItemStack stackGlowingHexoriumCoatedStoneSkyBlue_1 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneSkyBlue, 1);
        ItemStack stackGlowingHexoriumCoatedStoneBlue_1 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneBlue, 1);
        ItemStack stackGlowingHexoriumCoatedStonePurple_1 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStonePurple, 1);
        ItemStack stackGlowingHexoriumCoatedStoneMagenta_1 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneMagenta, 1);
        ItemStack stackGlowingHexoriumCoatedStonePink_1 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStonePink, 1);

        ItemStack stackGlowingHexoriumCoatedStoneWhite_1 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneWhite, 1);
        ItemStack stackGlowingHexoriumCoatedStoneLightGray_1 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneLightGray, 1);
        ItemStack stackGlowingHexoriumCoatedStoneGray_1 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneGray, 1);
        ItemStack stackGlowingHexoriumCoatedStoneDarkGray_1 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneDarkGray, 1);
        ItemStack stackGlowingHexoriumCoatedStoneBlack_1 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneBlack, 1);

        ItemStack stackGlowingHexoriumCoatedStoneRainbow_1 = new ItemStack(HexBlocks.blockGlowingHexoriumCoatedStoneRainbow, 1);

        // Glowing Hexorium Glass
        ItemStack stackGlowingHexoriumGlassRed_8 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassRed, 8);
        ItemStack stackGlowingHexoriumGlassOrange_8 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassOrange, 8);
        ItemStack stackGlowingHexoriumGlassYellow_8 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassYellow, 8);
        ItemStack stackGlowingHexoriumGlassLime_8 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassLime, 8);
        ItemStack stackGlowingHexoriumGlassGreen_8 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassGreen, 8);
        ItemStack stackGlowingHexoriumGlassTurquoise_8 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassTurquoise, 8);
        ItemStack stackGlowingHexoriumGlassCyan_8 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassCyan, 8);
        ItemStack stackGlowingHexoriumGlassSkyBlue_8 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassSkyBlue, 8);
        ItemStack stackGlowingHexoriumGlassBlue_8 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassBlue, 8);
        ItemStack stackGlowingHexoriumGlassPurple_8 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassPurple, 8);
        ItemStack stackGlowingHexoriumGlassMagenta_8 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassMagenta, 8);
        ItemStack stackGlowingHexoriumGlassPink_8 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassPink, 8);

        ItemStack stackGlowingHexoriumGlassWhite_8 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassWhite, 8);
        ItemStack stackGlowingHexoriumGlassLightGray_8 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassLightGray, 8);
        ItemStack stackGlowingHexoriumGlassGray_8 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassGray, 8);
        ItemStack stackGlowingHexoriumGlassDarkGray_8 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassDarkGray, 8);
        ItemStack stackGlowingHexoriumGlassBlack_8 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassBlack, 8);

        ItemStack stackGlowingHexoriumGlassRed_1 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassRed, 1);
        ItemStack stackGlowingHexoriumGlassOrange_1 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassOrange, 1);
        ItemStack stackGlowingHexoriumGlassYellow_1 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassYellow, 1);
        ItemStack stackGlowingHexoriumGlassLime_1 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassLime, 1);
        ItemStack stackGlowingHexoriumGlassGreen_1 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassGreen, 1);
        ItemStack stackGlowingHexoriumGlassTurquoise_1 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassTurquoise, 1);
        ItemStack stackGlowingHexoriumGlassCyan_1 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassCyan, 1);
        ItemStack stackGlowingHexoriumGlassSkyBlue_1 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassSkyBlue, 1);
        ItemStack stackGlowingHexoriumGlassBlue_1 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassBlue, 1);
        ItemStack stackGlowingHexoriumGlassPurple_1 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassPurple, 1);
        ItemStack stackGlowingHexoriumGlassMagenta_1 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassMagenta, 1);
        ItemStack stackGlowingHexoriumGlassPink_1 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassPink, 1);

        ItemStack stackGlowingHexoriumGlassWhite_1 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassWhite, 1);
        ItemStack stackGlowingHexoriumGlassLightGray_1 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassLightGray, 1);
        ItemStack stackGlowingHexoriumGlassGray_1 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassGray, 1);
        ItemStack stackGlowingHexoriumGlassDarkGray_1 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassDarkGray, 1);
        ItemStack stackGlowingHexoriumGlassBlack_1 = new ItemStack(HexBlocks.blockGlowingHexoriumGlassBlack, 1);

        // Hexorium Lamp
        ItemStack stackHexoriumLampRed_1 = new ItemStack(HexBlocks.blockHexoriumLampRed, 1);
        ItemStack stackHexoriumLampOrange_1 = new ItemStack(HexBlocks.blockHexoriumLampOrange, 1);
        ItemStack stackHexoriumLampYellow_1 = new ItemStack(HexBlocks.blockHexoriumLampYellow, 1);
        ItemStack stackHexoriumLampLime_1 = new ItemStack(HexBlocks.blockHexoriumLampLime, 1);
        ItemStack stackHexoriumLampGreen_1 = new ItemStack(HexBlocks.blockHexoriumLampGreen, 1);
        ItemStack stackHexoriumLampTurquoise_1 = new ItemStack(HexBlocks.blockHexoriumLampTurquoise, 1);
        ItemStack stackHexoriumLampCyan_1 = new ItemStack(HexBlocks.blockHexoriumLampCyan, 1);
        ItemStack stackHexoriumLampSkyBlue_1 = new ItemStack(HexBlocks.blockHexoriumLampSkyBlue, 1);
        ItemStack stackHexoriumLampBlue_1 = new ItemStack(HexBlocks.blockHexoriumLampBlue, 1);
        ItemStack stackHexoriumLampPurple_1 = new ItemStack(HexBlocks.blockHexoriumLampPurple, 1);
        ItemStack stackHexoriumLampMagenta_1 = new ItemStack(HexBlocks.blockHexoriumLampMagenta, 1);
        ItemStack stackHexoriumLampPink_1 = new ItemStack(HexBlocks.blockHexoriumLampPink, 1);

        ItemStack stackHexoriumLampWhite_1 = new ItemStack(HexBlocks.blockHexoriumLampWhite, 1);
        ItemStack stackHexoriumLampLightGray_1 = new ItemStack(HexBlocks.blockHexoriumLampLightGray, 1);
        ItemStack stackHexoriumLampGray_1 = new ItemStack(HexBlocks.blockHexoriumLampGray, 1);
        ItemStack stackHexoriumLampDarkGray_1 = new ItemStack(HexBlocks.blockHexoriumLampDarkGray, 1);
        ItemStack stackHexoriumLampBlack_1 = new ItemStack(HexBlocks.blockHexoriumLampBlack, 1);

        ItemStack stackHexoriumLampRainbow_1 = new ItemStack(HexBlocks.blockHexoriumLampRainbow, 1);

        // Inverted Hexorium Lamp
        ItemStack stackHexoriumLampInvRed_1 = new ItemStack(HexBlocks.blockHexoriumLampInvRed, 1);
        ItemStack stackHexoriumLampInvOrange_1 = new ItemStack(HexBlocks.blockHexoriumLampInvOrange, 1);
        ItemStack stackHexoriumLampInvYellow_1 = new ItemStack(HexBlocks.blockHexoriumLampInvYellow, 1);
        ItemStack stackHexoriumLampInvLime_1 = new ItemStack(HexBlocks.blockHexoriumLampInvLime, 1);
        ItemStack stackHexoriumLampInvGreen_1 = new ItemStack(HexBlocks.blockHexoriumLampInvGreen, 1);
        ItemStack stackHexoriumLampInvTurquoise_1 = new ItemStack(HexBlocks.blockHexoriumLampInvTurquoise, 1);
        ItemStack stackHexoriumLampInvCyan_1 = new ItemStack(HexBlocks.blockHexoriumLampInvCyan, 1);
        ItemStack stackHexoriumLampInvSkyBlue_1 = new ItemStack(HexBlocks.blockHexoriumLampInvSkyBlue, 1);
        ItemStack stackHexoriumLampInvBlue_1 = new ItemStack(HexBlocks.blockHexoriumLampInvBlue, 1);
        ItemStack stackHexoriumLampInvPurple_1 = new ItemStack(HexBlocks.blockHexoriumLampInvPurple, 1);
        ItemStack stackHexoriumLampInvMagenta_1 = new ItemStack(HexBlocks.blockHexoriumLampInvMagenta, 1);
        ItemStack stackHexoriumLampInvPink_1 = new ItemStack(HexBlocks.blockHexoriumLampInvPink, 1);

        ItemStack stackHexoriumLampInvWhite_1 = new ItemStack(HexBlocks.blockHexoriumLampInvWhite, 1);
        ItemStack stackHexoriumLampInvLightGray_1 = new ItemStack(HexBlocks.blockHexoriumLampInvLightGray, 1);
        ItemStack stackHexoriumLampInvGray_1 = new ItemStack(HexBlocks.blockHexoriumLampInvGray, 1);
        ItemStack stackHexoriumLampInvDarkGray_1 = new ItemStack(HexBlocks.blockHexoriumLampInvDarkGray, 1);
        ItemStack stackHexoriumLampInvBlack_1 = new ItemStack(HexBlocks.blockHexoriumLampInvBlack, 1);

        ItemStack stackHexoriumLampInvRainbow_1 = new ItemStack(HexBlocks.blockHexoriumLampInvRainbow, 1);

        // Hexorium Door
        ItemStack stackHexoriumDoorRed_1 = new ItemStack(HexBlocks.blockHexoriumDoorRed, 1);
        ItemStack stackHexoriumDoorOrange_1 = new ItemStack(HexBlocks.blockHexoriumDoorOrange, 1);
        ItemStack stackHexoriumDoorYellow_1 = new ItemStack(HexBlocks.blockHexoriumDoorYellow, 1);
        ItemStack stackHexoriumDoorLime_1 = new ItemStack(HexBlocks.blockHexoriumDoorLime, 1);
        ItemStack stackHexoriumDoorGreen_1 = new ItemStack(HexBlocks.blockHexoriumDoorGreen, 1);
        ItemStack stackHexoriumDoorTurquoise_1 = new ItemStack(HexBlocks.blockHexoriumDoorTurquoise, 1);
        ItemStack stackHexoriumDoorCyan_1 = new ItemStack(HexBlocks.blockHexoriumDoorCyan, 1);
        ItemStack stackHexoriumDoorSkyBlue_1 = new ItemStack(HexBlocks.blockHexoriumDoorSkyBlue, 1);
        ItemStack stackHexoriumDoorBlue_1 = new ItemStack(HexBlocks.blockHexoriumDoorBlue, 1);
        ItemStack stackHexoriumDoorPurple_1 = new ItemStack(HexBlocks.blockHexoriumDoorPurple, 1);
        ItemStack stackHexoriumDoorMagenta_1 = new ItemStack(HexBlocks.blockHexoriumDoorMagenta, 1);
        ItemStack stackHexoriumDoorPink_1 = new ItemStack(HexBlocks.blockHexoriumDoorPink, 1);

        ItemStack stackHexoriumDoorWhite_1 = new ItemStack(HexBlocks.blockHexoriumDoorWhite, 1);
        ItemStack stackHexoriumDoorLightGray_1 = new ItemStack(HexBlocks.blockHexoriumDoorLightGray, 1);
        ItemStack stackHexoriumDoorGray_1 = new ItemStack(HexBlocks.blockHexoriumDoorGray, 1);
        ItemStack stackHexoriumDoorDarkGray_1 = new ItemStack(HexBlocks.blockHexoriumDoorDarkGray, 1);
        ItemStack stackHexoriumDoorBlack_1 = new ItemStack(HexBlocks.blockHexoriumDoorBlack, 1);

        ItemStack stackHexoriumDoorRainbow_1 = new ItemStack(HexBlocks.blockHexoriumDoorRainbow, 1);

        // Hexorium Hatch
        ItemStack stackHexoriumHatchRed_2 = new ItemStack(HexBlocks.blockHexoriumHatchRed, 2);
        ItemStack stackHexoriumHatchOrange_2 = new ItemStack(HexBlocks.blockHexoriumHatchOrange, 2);
        ItemStack stackHexoriumHatchYellow_2 = new ItemStack(HexBlocks.blockHexoriumHatchYellow, 2);
        ItemStack stackHexoriumHatchLime_2 = new ItemStack(HexBlocks.blockHexoriumHatchLime, 2);
        ItemStack stackHexoriumHatchGreen_2 = new ItemStack(HexBlocks.blockHexoriumHatchGreen, 2);
        ItemStack stackHexoriumHatchTurquoise_2 = new ItemStack(HexBlocks.blockHexoriumHatchTurquoise, 2);
        ItemStack stackHexoriumHatchCyan_2 = new ItemStack(HexBlocks.blockHexoriumHatchCyan, 2);
        ItemStack stackHexoriumHatchSkyBlue_2 = new ItemStack(HexBlocks.blockHexoriumHatchSkyBlue, 2);
        ItemStack stackHexoriumHatchBlue_2 = new ItemStack(HexBlocks.blockHexoriumHatchBlue, 2);
        ItemStack stackHexoriumHatchPurple_2 = new ItemStack(HexBlocks.blockHexoriumHatchPurple, 2);
        ItemStack stackHexoriumHatchMagenta_2 = new ItemStack(HexBlocks.blockHexoriumHatchMagenta, 2);
        ItemStack stackHexoriumHatchPink_2 = new ItemStack(HexBlocks.blockHexoriumHatchPink, 2);

        ItemStack stackHexoriumHatchWhite_2 = new ItemStack(HexBlocks.blockHexoriumHatchWhite, 2);
        ItemStack stackHexoriumHatchLightGray_2 = new ItemStack(HexBlocks.blockHexoriumHatchLightGray, 2);
        ItemStack stackHexoriumHatchGray_2 = new ItemStack(HexBlocks.blockHexoriumHatchGray, 2);
        ItemStack stackHexoriumHatchDarkGray_2 = new ItemStack(HexBlocks.blockHexoriumHatchDarkGray, 2);
        ItemStack stackHexoriumHatchBlack_2 = new ItemStack(HexBlocks.blockHexoriumHatchBlack, 2);

        ItemStack stackHexoriumHatchRainbow_2 = new ItemStack(HexBlocks.blockHexoriumHatchRainbow, 2);

        // Machines
        ItemStack stackHexoriumMachineBlock_1 = new ItemStack(HexBlocks.blockHexoriumMachineBlock, 1);
        ItemStack stackAdvancedRainbowCore_1 = new ItemStack(HexBlocks.blockAdvancedRainbowCore, 1);

        ItemStack stackHexoriumGenerator_1 = new ItemStack(HexBlocks.blockHexoriumGenerator, 1);
        ItemStack stackHexoriumFurnace_1 = new ItemStack(HexBlocks.blockHexoriumFurnace, 1);
        ItemStack stackCrystalSeparator_1 = new ItemStack(HexBlocks.blockCrystalSeparator, 1);
        ItemStack stackMatrixReconstructor_1 = new ItemStack(HexBlocks.blockMatrixReconstructor, 1);

        ItemStack stackPersonalTeleportationPad_1 = new ItemStack(HexBlocks.blockPersonalTeleportationPad, 1);

        ItemStack stackQuantumObserver_1 = new ItemStack(HexBlocks.blockQuantumObserver, 1);
        ItemStack stackQuantumAnchor_1 = new ItemStack(HexBlocks.blockQuantumAnchor, 1);

        // Tank Valve
        ItemStack stackTankValve_1 = new ItemStack(HexBlocks.blockTankValve, 1);

        // Energy Node
        ItemStack stackEnergyNodeCoreT1_1 = new ItemStack(HexBlocks.blockEnergyNodeCoreT1, 1);
        ItemStack stackEnergyNodeCoreT2_1 = new ItemStack(HexBlocks.blockEnergyNodeCoreT2, 1);
        ItemStack stackEnergyNodeCoreT3_1 = new ItemStack(HexBlocks.blockEnergyNodeCoreT3, 1);
        ItemStack stackEnergyNodeCoreT4_1 = new ItemStack(HexBlocks.blockEnergyNodeCoreT4, 1);

        ItemStack stackEnergyNodePortHEX_1 = new ItemStack(HexBlocks.blockEnergyNodePortHEX, 1);
        ItemStack stackEnergyNodePortRF_1 = new ItemStack(HexBlocks.blockEnergyNodePortRF, 1);
        ItemStack stackEnergyNodePortEU_1 = new ItemStack(HexBlocks.blockEnergyNodePortEU, 1);

        // Cables
        ItemStack stackHexoriumCableRed_4 = new ItemStack(HexBlocks.blockHexoriumCableRed, 4);
        ItemStack stackHexoriumCableOrange_4 = new ItemStack(HexBlocks.blockHexoriumCableOrange, 4);
        ItemStack stackHexoriumCableYellow_4 = new ItemStack(HexBlocks.blockHexoriumCableYellow, 4);
        ItemStack stackHexoriumCableLime_4 = new ItemStack(HexBlocks.blockHexoriumCableLime, 4);
        ItemStack stackHexoriumCableGreen_4 = new ItemStack(HexBlocks.blockHexoriumCableGreen, 4);
        ItemStack stackHexoriumCableTurquoise_4 = new ItemStack(HexBlocks.blockHexoriumCableTurquoise, 4);
        ItemStack stackHexoriumCableCyan_4 = new ItemStack(HexBlocks.blockHexoriumCableCyan, 4);
        ItemStack stackHexoriumCableSkyBlue_4 = new ItemStack(HexBlocks.blockHexoriumCableSkyBlue, 4);
        ItemStack stackHexoriumCableBlue_4 = new ItemStack(HexBlocks.blockHexoriumCableBlue, 4);
        ItemStack stackHexoriumCablePurple_4 = new ItemStack(HexBlocks.blockHexoriumCablePurple, 4);
        ItemStack stackHexoriumCableMagenta_4 = new ItemStack(HexBlocks.blockHexoriumCableMagenta, 4);
        ItemStack stackHexoriumCablePink_4 = new ItemStack(HexBlocks.blockHexoriumCablePink, 4);

        ItemStack stackHexoriumCableWhite_4 = new ItemStack(HexBlocks.blockHexoriumCableWhite, 4);
        ItemStack stackHexoriumCableLightGray_4 = new ItemStack(HexBlocks.blockHexoriumCableLightGray, 4);
        ItemStack stackHexoriumCableGray_4 = new ItemStack(HexBlocks.blockHexoriumCableGray, 4);
        ItemStack stackHexoriumCableDarkGray_4 = new ItemStack(HexBlocks.blockHexoriumCableDarkGray, 4);
        ItemStack stackHexoriumCableBlack_4 = new ItemStack(HexBlocks.blockHexoriumCableBlack, 4);

        ItemStack stackHexoriumCableRainbow_1 = new ItemStack(HexBlocks.blockHexoriumCableRainbow, 1);
        ItemStack stackHexoriumCableRainbow_4 = new ItemStack(HexBlocks.blockHexoriumCableRainbow, 4);

        // Energy Pylon
        ItemStack stackEnergyPylon_1 = new ItemStack(HexBlocks.blockEnergyPylon, 1);

        // Hexorium Switch
        ItemStack stackHexoriumSwitchRedGreen_1 = new ItemStack(HexBlocks.blockHexoriumSwitchRedGreen, 1);
        ItemStack stackHexoriumSwitchRedBlue_1 = new ItemStack(HexBlocks.blockHexoriumSwitchRedBlue, 1);
        ItemStack stackHexoriumSwitchRedWhite_1 = new ItemStack(HexBlocks.blockHexoriumSwitchRedWhite, 1);

        // Hexorium Button
        ItemStack stackHexoriumButtonRed_1 = new ItemStack(HexBlocks.blockHexoriumButtonRed, 1);
        ItemStack stackHexoriumButtonGreen_1 = new ItemStack(HexBlocks.blockHexoriumButtonGreen, 1);
        ItemStack stackHexoriumButtonBlue_1 = new ItemStack(HexBlocks.blockHexoriumButtonBlue, 1);
        ItemStack stackHexoriumButtonWhite_1 = new ItemStack(HexBlocks.blockHexoriumButtonWhite, 1);

        // Hexorium Pressure Plate
        ItemStack stackHexoriumPressurePlateRed_1 = new ItemStack(HexBlocks.blockHexoriumPressurePlateRed, 1);
        ItemStack stackHexoriumPressurePlateGreen_1 = new ItemStack(HexBlocks.blockHexoriumPressurePlateGreen, 1);
        ItemStack stackHexoriumPressurePlateBlue_1 = new ItemStack(HexBlocks.blockHexoriumPressurePlateBlue, 1);
        ItemStack stackHexoriumPressurePlateWhite_1 = new ItemStack(HexBlocks.blockHexoriumPressurePlateWhite, 1);

        // Regular Blocks
        ItemStack stackTemperedHexoriumGlass_1 = new ItemStack(HexBlocks.blockTemperedHexoriumGlass, 1);
        ItemStack stackTemperedHexoriumGlass_4 = new ItemStack(HexBlocks.blockTemperedHexoriumGlass, 4);
        ItemStack stackHexoriumCoatedStone_8 = new ItemStack(HexBlocks.blockHexoriumCoatedStone, 8);
        ItemStack stackHexoriumCoatedStone_1 = new ItemStack(HexBlocks.blockHexoriumCoatedStone, 1);

        ItemStack stackPylonBase51_1 = new ItemStack(HexBlocks.blockPylonBase51, 1);
        ItemStack stackPylonBase15_1 = new ItemStack(HexBlocks.blockPylonBase15, 1);

        ItemStack stackSoundProjector_1 = new ItemStack(HexBlocks.blockSoundProjector, 1);

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
        ItemStack stackIronNugget_9 = new ItemStack(HexItems.itemIronNugget, 9);
        ItemStack stackRainbowEnergizedGlobule_1 = new ItemStack(HexItems.itemRainbowEnergizedGlobule, 1);
        ItemStack stackWhiteHexoriumWafer_1 = new ItemStack(HexItems.itemWhiteHexoriumWafer, 1);
        ItemStack stackBlackHexoriumWafer_1 = new ItemStack(HexItems.itemBlackHexoriumWafer, 1);
        ItemStack stackSpatialProjector_1 = new ItemStack(HexItems.itemSpatialProjector, 1);
        ItemStack stackOreActuator_1 = new ItemStack(HexItems.itemOreActuator, 1);
        ItemStack stackPylonSocket_1 = new ItemStack(HexItems.itemPylonSocket, 1);
        ItemStack stackHexoriumGlassPackage_1 = new ItemStack(HexItems.itemHexoriumGlassPackage, 1);

        // Components T2
        ItemStack stackRainbowCore_1 = new ItemStack(HexItems.itemRainbowCore, 1);
        ItemStack stackHexoriumCoprocessor_1 = new ItemStack(HexItems.itemHexoriumCoprocessor, 1);
        ItemStack stackHexoriumProcessor_1 = new ItemStack(HexItems.itemHexoriumProcessor, 1);
        ItemStack stackMineralAnalyzer_1 = new ItemStack(HexItems.itemMineralAnalyzer, 1);
        ItemStack stackHexoriumEnergyConverter_1 = new ItemStack(HexItems.itemHexoriumEnergyConverter, 1);
        ItemStack stackEnergyInjector_1 = new ItemStack(HexItems.itemEnergyInjector, 1);
        ItemStack stackMolecularRecoder_1 = new ItemStack(HexItems.itemMolecularRecoder, 1);
        ItemStack stackHexoriumRFAdapter_1 = new ItemStack(HexItems.itemHexoriumRFAdapter, 1);

        // Components MP
        ItemStack stackMachineControlPanel_1 = new ItemStack(HexItems.itemMachineControlPanel, 1);
        ItemStack stackMachineEnergyRouter_1 = new ItemStack(HexItems.itemMachineEnergyRouter, 1);
        ItemStack stackHeatDissipator_1 = new ItemStack(HexItems.itemHeatDissipator, 1);
        ItemStack stackHeatingArray_1 = new ItemStack(HexItems.itemHeatingArray, 1);
        ItemStack stackCrystalExtractionUnit_1 = new ItemStack(HexItems.itemCrystalExtractionUnit, 1);
        ItemStack stackMatrixAdjuster_1 = new ItemStack(HexItems.itemMatrixAdjuster, 1);
        ItemStack stackMaterialInteractionPlane_1 = new ItemStack(HexItems.itemMaterialInteractionPlane, 1);
        ItemStack stackTeleportationFieldProjector_1 = new ItemStack(HexItems.itemTeleportationFieldProjector, 1);
        ItemStack stackObservationalEye_1 = new ItemStack(HexItems.itemObservationalEye, 1);
        ItemStack stackDigitalSmartpipe_1 = new ItemStack(HexItems.itemDigitalSmartpipe, 1);
        ItemStack stackSoundEmissionModule_1 = new ItemStack(HexItems.itemSoundEmissionModule, 1);

        // Tools
        ItemStack stackHexoriumManipulator_1 = new ItemStack(HexItems.itemHexoriumManipulator, 1);
        ItemStack stackHexoriumProbe_1 = new ItemStack(HexItems.itemHexoriumProbe, 1);
        ItemStack stackMolecularTransposer_1 = new ItemStack(HexItems.itemMolecularTransposer, 1);
        ItemStack stackHexoriumReinforcer_12 = new ItemStack(HexItems.itemHexoriumReinforcer, 12);

        // Misc
        ItemStack stackEnergizedHexoriumMonolithBlack_1 = new ItemStack(HexBlocks.blockEnergizedHexoriumMonolithBlack, 1);


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
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1);

        // Orange
        GameRegistry.addRecipe(stackEnergizedHexoriumOrange_1,
                "ABA",
                "ARA",
                "ABA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumOrange_1,
                "AAA",
                "BRB",
                "AAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumOrange_1,
                "BAA",
                "ARA",
                "AAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumOrange_1,
                "AAB",
                "ARA",
                "BAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1);

        // Yellow
        GameRegistry.addRecipe(stackEnergizedHexoriumYellow_1,
                "ABA",
                "BRB",
                "ABA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumYellow_1,
                "BAB",
                "ARA",
                "BAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1);

        // Lime
        GameRegistry.addRecipe(stackEnergizedHexoriumLime_1,
                "ABA",
                "ARA",
                "ABA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumLime_1,
                "AAA",
                "BRB",
                "AAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumLime_1,
                "BAA",
                "ARA",
                "AAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumLime_1,
                "AAB",
                "ARA",
                "BAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1);

        // Green
        GameRegistry.addRecipe(stackEnergizedHexoriumGreen_1,
                "AAA",
                "ARA",
                "AAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1);

        // Turquoise
        GameRegistry.addRecipe(stackEnergizedHexoriumTurquoise_1,
                "ABA",
                "ARA",
                "ABA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumTurquoise_1,
                "AAA",
                "BRB",
                "AAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumTurquoise_1,
                "BAA",
                "ARA",
                "AAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumTurquoise_1,
                "AAB",
                "ARA",
                "BAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1);

        // Cyan
        GameRegistry.addRecipe(stackEnergizedHexoriumCyan_1,
                "ABA",
                "BRB",
                "ABA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumCyan_1,
                "BAB",
                "ARA",
                "BAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1);

        // SkyBlue
        GameRegistry.addRecipe(stackEnergizedHexoriumSkyBlue_1,
                "ABA",
                "ARA",
                "ABA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumSkyBlue_1,
                "AAA",
                "BRB",
                "AAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumSkyBlue_1,
                "BAA",
                "ARA",
                "AAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumSkyBlue_1,
                "AAB",
                "ARA",
                "BAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1);
        
        // Blue
        GameRegistry.addRecipe(stackEnergizedHexoriumBlue_1,
                "AAA",
                "ARA",
                "AAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1);

        // Purple
        GameRegistry.addRecipe(stackEnergizedHexoriumPurple_1,
                "ABA",
                "ARA",
                "ABA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumPurple_1,
                "AAA",
                "BRB",
                "AAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumPurple_1,
                "BAA",
                "ARA",
                "AAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumPurple_1,
                "AAB",
                "ARA",
                "BAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1);

        // Magenta
        GameRegistry.addRecipe(stackEnergizedHexoriumMagenta_1,
                "ABA",
                "BRB",
                "ABA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumMagenta_1,
                "BAB",
                "ARA",
                "BAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1);

        // Pink
        GameRegistry.addRecipe(stackEnergizedHexoriumPink_1,
                "ABA",
                "ARA",
                "ABA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumPink_1,
                "AAA",
                "BRB",
                "AAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumPink_1,
                "BAA",
                "ARA",
                "AAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumPink_1,
                "AAB",
                "ARA",
                "BAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1);
        
        
        // White
        GameRegistry.addRecipe(stackEnergizedHexoriumWhite_1,
                "AAA",
                "ARA",
                "AAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1);

        // LightGray
        GameRegistry.addRecipe(stackEnergizedHexoriumLightGray_1,
                "ABA",
                "ARA",
                "ABA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumLightGray_1,
                "AAA",
                "BRB",
                "AAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumLightGray_1,
                "BAA",
                "ARA",
                "AAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumLightGray_1,
                "AAB",
                "ARA",
                "BAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1);

        // Gray
        GameRegistry.addRecipe(stackEnergizedHexoriumGray_1,
                "ABA",
                "BRB",
                "ABA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumGray_1,
                "BAB",
                "ARA",
                "BAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1);

        // DarkGray
        GameRegistry.addRecipe(stackEnergizedHexoriumDarkGray_1,
                "ABA",
                "ARA",
                "ABA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumDarkGray_1,
                "AAA",
                "BRB",
                "AAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumDarkGray_1,
                "BAA",
                "ARA",
                "AAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumDarkGray_1,
                "AAB",
                "ARA",
                "BAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1);
        
        // Black
        GameRegistry.addRecipe(stackEnergizedHexoriumBlack_1,
                "AAA",
                "ARA",
                "AAA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1);

        
        // Rainbow        
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "ABC",
                "DRD",
                "CBA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "ABD",
                "CRC",
                "DBA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "ACB",
                "DRD",
                "BCA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "ACD",
                "BRB",
                "DCA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "ADB",
                "CRC",
                "BDA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "ADC",
                "BRB",
                "CDA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "BAC",
                "DRD",
                "CAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "BAD",
                "CRC",
                "DAB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "BCA",
                "DRD",
                "ACB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "BCD",
                "ARA",
                "DCB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "BDA",
                "CRC",
                "ADB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "BDC",
                "ARA",
                "CDB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "CAB",
                "DRD",
                "BAC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "CAD",
                "BRB",
                "DAC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "CBA",
                "DRD",
                "ABC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "CBD",
                "ARA",
                "DBC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "CDA",
                "BRB",
                "ADC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "CDB",
                "ARA",
                "BDC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "DAB",
                "CRC",
                "BAD",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "DAC",
                "BRB",
                "CAD",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "DBA",
                "CRC",
                "ABD",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "DBC",
                "ARA",
                "CBD",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "DCA",
                "BRB",
                "ACD",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackEnergizedHexoriumRainbow_1,
                "DCB",
                "ARA",
                "BCD",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);


        // Engineered Hexorium Block
        GameRegistry.addRecipe(new ShapedOreRecipe(stackEngineeredHexoriumBlockRed_1,
                "A",
                "H",
                "B",
                'H', stackEnergizedHexoriumRed_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackEngineeredHexoriumBlockOrange_1,
                "A",
                "H",
                "B",
                'H', stackEnergizedHexoriumOrange_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackEngineeredHexoriumBlockYellow_1,
                "A",
                "H",
                "B",
                'H', stackEnergizedHexoriumYellow_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackEngineeredHexoriumBlockLime_1,
                "A",
                "H",
                "B",
                'H', stackEnergizedHexoriumLime_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackEngineeredHexoriumBlockGreen_1,
                "A",
                "H",
                "B",
                'H', stackEnergizedHexoriumGreen_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackEngineeredHexoriumBlockTurquoise_1,
                "A",
                "H",
                "B",
                'H', stackEnergizedHexoriumTurquoise_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackEngineeredHexoriumBlockCyan_1,
                "A",
                "H",
                "B",
                'H', stackEnergizedHexoriumCyan_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackEngineeredHexoriumBlockSkyBlue_1,
                "A",
                "H",
                "B",
                'H', stackEnergizedHexoriumSkyBlue_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackEngineeredHexoriumBlockBlue_1,
                "A",
                "H",
                "B",
                'H', stackEnergizedHexoriumBlue_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackEngineeredHexoriumBlockPurple_1,
                "A",
                "H",
                "B",
                'H', stackEnergizedHexoriumPurple_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackEngineeredHexoriumBlockMagenta_1,
                "A",
                "H",
                "B",
                'H', stackEnergizedHexoriumMagenta_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackEngineeredHexoriumBlockPink_1,
                "A",
                "H",
                "B",
                'H', stackEnergizedHexoriumPink_1, 'A', "nuggetIron", 'B', "stone"));
        
        GameRegistry.addRecipe(new ShapedOreRecipe(stackEngineeredHexoriumBlockWhite_1,
                "A",
                "H",
                "B",
                'H', stackEnergizedHexoriumWhite_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackEngineeredHexoriumBlockLightGray_1,
                "A",
                "H",
                "B",
                'H', stackEnergizedHexoriumLightGray_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackEngineeredHexoriumBlockGray_1,
                "A",
                "H",
                "B",
                'H', stackEnergizedHexoriumGray_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackEngineeredHexoriumBlockDarkGray_1,
                "A",
                "H",
                "B",
                'H', stackEnergizedHexoriumDarkGray_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackEngineeredHexoriumBlockBlack_1,
                "A",
                "H",
                "B",
                'H', stackEnergizedHexoriumBlack_1, 'A', "nuggetIron", 'B', "stone"));
        
        GameRegistry.addRecipe(new ShapedOreRecipe(stackEngineeredHexoriumBlockRainbow_1,
                "A",
                "H",
                "B",
                'H', stackEnergizedHexoriumRainbow_1, 'A', "nuggetIron", 'B', "stone"));


        // Framed Hexorium Block
        GameRegistry.addRecipe(new ShapedOreRecipe(stackFramedHexoriumBlockRed_1,
                "  A",
                " H ",
                "B  ",
                'H', stackEnergizedHexoriumRed_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackFramedHexoriumBlockOrange_1,
                "  A",
                " H ",
                "B  ",
                'H', stackEnergizedHexoriumOrange_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackFramedHexoriumBlockYellow_1,
                "  A",
                " H ",
                "B  ",
                'H', stackEnergizedHexoriumYellow_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackFramedHexoriumBlockLime_1,
                "  A",
                " H ",
                "B  ",
                'H', stackEnergizedHexoriumLime_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackFramedHexoriumBlockGreen_1,
                "  A",
                " H ",
                "B  ",
                'H', stackEnergizedHexoriumGreen_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackFramedHexoriumBlockTurquoise_1,
                "  A",
                " H ",
                "B  ",
                'H', stackEnergizedHexoriumTurquoise_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackFramedHexoriumBlockCyan_1,
                "  A",
                " H ",
                "B  ",
                'H', stackEnergizedHexoriumCyan_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackFramedHexoriumBlockSkyBlue_1,
                "  A",
                " H ",
                "B  ",
                'H', stackEnergizedHexoriumSkyBlue_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackFramedHexoriumBlockBlue_1,
                "  A",
                " H ",
                "B  ",
                'H', stackEnergizedHexoriumBlue_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackFramedHexoriumBlockPurple_1,
                "  A",
                " H ",
                "B  ",
                'H', stackEnergizedHexoriumPurple_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackFramedHexoriumBlockMagenta_1,
                "  A",
                " H ",
                "B  ",
                'H', stackEnergizedHexoriumMagenta_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackFramedHexoriumBlockPink_1,
                "  A",
                " H ",
                "B  ",
                'H', stackEnergizedHexoriumPink_1, 'A', "nuggetIron", 'B', "stone"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackFramedHexoriumBlockWhite_1,
                "  A",
                " H ",
                "B  ",
                'H', stackEnergizedHexoriumWhite_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackFramedHexoriumBlockLightGray_1,
                "  A",
                " H ",
                "B  ",
                'H', stackEnergizedHexoriumLightGray_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackFramedHexoriumBlockGray_1,
                "  A",
                " H ",
                "B  ",
                'H', stackEnergizedHexoriumGray_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackFramedHexoriumBlockDarkGray_1,
                "  A",
                " H ",
                "B  ",
                'H', stackEnergizedHexoriumDarkGray_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackFramedHexoriumBlockBlack_1,
                "  A",
                " H ",
                "B  ",
                'H', stackEnergizedHexoriumBlack_1, 'A', "nuggetIron", 'B', "stone"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackFramedHexoriumBlockRainbow_1,
                "  A",
                " H ",
                "B  ",
                'H', stackEnergizedHexoriumRainbow_1, 'A', "nuggetIron", 'B', "stone"));


        // Plated Hexorium Block
        GameRegistry.addRecipe(new ShapedOreRecipe(stackPlatedHexoriumBlockRed_1,
                "BHA",
                'H', stackEnergizedHexoriumRed_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackPlatedHexoriumBlockOrange_1,
                "BHA",
                'H', stackEnergizedHexoriumOrange_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackPlatedHexoriumBlockYellow_1,
                "BHA",
                'H', stackEnergizedHexoriumYellow_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackPlatedHexoriumBlockLime_1,
                "BHA",
                'H', stackEnergizedHexoriumLime_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackPlatedHexoriumBlockGreen_1,
                "BHA",
                'H', stackEnergizedHexoriumGreen_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackPlatedHexoriumBlockTurquoise_1,
                "BHA",
                'H', stackEnergizedHexoriumTurquoise_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackPlatedHexoriumBlockCyan_1,
                "BHA",
                'H', stackEnergizedHexoriumCyan_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackPlatedHexoriumBlockSkyBlue_1,
                "BHA",
                'H', stackEnergizedHexoriumSkyBlue_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackPlatedHexoriumBlockBlue_1,
                "BHA",
                'H', stackEnergizedHexoriumBlue_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackPlatedHexoriumBlockPurple_1,
                "BHA",
                'H', stackEnergizedHexoriumPurple_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackPlatedHexoriumBlockMagenta_1,
                "BHA",
                'H', stackEnergizedHexoriumMagenta_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackPlatedHexoriumBlockPink_1,
                "BHA",
                'H', stackEnergizedHexoriumPink_1, 'A', "nuggetIron", 'B', "stone"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackPlatedHexoriumBlockWhite_1,
                "BHA",
                'H', stackEnergizedHexoriumWhite_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackPlatedHexoriumBlockLightGray_1,
                "BHA",
                'H', stackEnergizedHexoriumLightGray_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackPlatedHexoriumBlockGray_1,
                "BHA",
                'H', stackEnergizedHexoriumGray_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackPlatedHexoriumBlockDarkGray_1,
                "BHA",
                'H', stackEnergizedHexoriumDarkGray_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackPlatedHexoriumBlockBlack_1,
                "BHA",
                'H', stackEnergizedHexoriumBlack_1, 'A', "nuggetIron", 'B', "stone"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackPlatedHexoriumBlockRainbow_1,
                "BHA",
                'H', stackEnergizedHexoriumRainbow_1, 'A', "nuggetIron", 'B', "stone"));


        // Concentric Hexorium Block
        GameRegistry.addRecipe(new ShapedOreRecipe(stackConcentricHexoriumBlockRed_1,
                "B  ",
                " H ",
                "  A",
                'H', stackEnergizedHexoriumRed_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackConcentricHexoriumBlockOrange_1,
                "B  ",
                " H ",
                "  A",
                'H', stackEnergizedHexoriumOrange_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackConcentricHexoriumBlockYellow_1,
                "B  ",
                " H ",
                "  A",
                'H', stackEnergizedHexoriumYellow_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackConcentricHexoriumBlockLime_1,
                "B  ",
                " H ",
                "  A",
                'H', stackEnergizedHexoriumLime_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackConcentricHexoriumBlockGreen_1,
                "B  ",
                " H ",
                "  A",
                'H', stackEnergizedHexoriumGreen_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackConcentricHexoriumBlockTurquoise_1,
                "B  ",
                " H ",
                "  A",
                'H', stackEnergizedHexoriumTurquoise_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackConcentricHexoriumBlockCyan_1,
                "B  ",
                " H ",
                "  A",
                'H', stackEnergizedHexoriumCyan_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackConcentricHexoriumBlockSkyBlue_1,
                "B  ",
                " H ",
                "  A",
                'H', stackEnergizedHexoriumSkyBlue_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackConcentricHexoriumBlockBlue_1,
                "B  ",
                " H ",
                "  A",
                'H', stackEnergizedHexoriumBlue_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackConcentricHexoriumBlockPurple_1,
                "B  ",
                " H ",
                "  A",
                'H', stackEnergizedHexoriumPurple_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackConcentricHexoriumBlockMagenta_1,
                "B  ",
                " H ",
                "  A",
                'H', stackEnergizedHexoriumMagenta_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackConcentricHexoriumBlockPink_1,
                "B  ",
                " H ",
                "  A",
                'H', stackEnergizedHexoriumPink_1, 'A', "nuggetIron", 'B', "stone"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackConcentricHexoriumBlockWhite_1,
                "B  ",
                " H ",
                "  A",
                'H', stackEnergizedHexoriumWhite_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackConcentricHexoriumBlockLightGray_1,
                "B  ",
                " H ",
                "  A",
                'H', stackEnergizedHexoriumLightGray_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackConcentricHexoriumBlockGray_1,
                "B  ",
                " H ",
                "  A",
                'H', stackEnergizedHexoriumGray_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackConcentricHexoriumBlockDarkGray_1,
                "B  ",
                " H ",
                "  A",
                'H', stackEnergizedHexoriumDarkGray_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackConcentricHexoriumBlockBlack_1,
                "B  ",
                " H ",
                "  A",
                'H', stackEnergizedHexoriumBlack_1, 'A', "nuggetIron", 'B', "stone"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackConcentricHexoriumBlockRainbow_1,
                "B  ",
                " H ",
                "  A",
                'H', stackEnergizedHexoriumRainbow_1, 'A', "nuggetIron", 'B', "stone"));


        // Hexorium Structure Casing
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumStructureCasingRed_1,
                " A ",
                "RHR",
                " B ",
                'R', stackRedstone_1, 'H', stackEnergizedHexoriumRed_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumStructureCasingOrange_1,
                " A ",
                "RHR",
                " B ",
                'R', stackRedstone_1, 'H', stackEnergizedHexoriumOrange_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumStructureCasingYellow_1,
                " A ",
                "RHR",
                " B ",
                'R', stackRedstone_1, 'H', stackEnergizedHexoriumYellow_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumStructureCasingLime_1,
                " A ",
                "RHR",
                " B ",
                'R', stackRedstone_1, 'H', stackEnergizedHexoriumLime_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumStructureCasingGreen_1,
                " A ",
                "RHR",
                " B ",
                'R', stackRedstone_1, 'H', stackEnergizedHexoriumGreen_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumStructureCasingTurquoise_1,
                " A ",
                "RHR",
                " B ",
                'R', stackRedstone_1, 'H', stackEnergizedHexoriumTurquoise_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumStructureCasingCyan_1,
                " A ",
                "RHR",
                " B ",
                'R', stackRedstone_1, 'H', stackEnergizedHexoriumCyan_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumStructureCasingSkyBlue_1,
                " A ",
                "RHR",
                " B ",
                'R', stackRedstone_1, 'H', stackEnergizedHexoriumSkyBlue_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumStructureCasingBlue_1,
                " A ",
                "RHR",
                " B ",
                'R', stackRedstone_1, 'H', stackEnergizedHexoriumBlue_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumStructureCasingPurple_1,
                " A ",
                "RHR",
                " B ",
                'R', stackRedstone_1, 'H', stackEnergizedHexoriumPurple_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumStructureCasingMagenta_1,
                " A ",
                "RHR",
                " B ",
                'R', stackRedstone_1, 'H', stackEnergizedHexoriumMagenta_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumStructureCasingPink_1,
                " A ",
                "RHR",
                " B ",
                'R', stackRedstone_1, 'H', stackEnergizedHexoriumPink_1, 'A', "nuggetIron", 'B', "stone"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumStructureCasingWhite_1,
                " A ",
                "RHR",
                " B ",
                'R', stackRedstone_1, 'H', stackEnergizedHexoriumWhite_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumStructureCasingLightGray_1,
                " A ",
                "RHR",
                " B ",
                'R', stackRedstone_1, 'H', stackEnergizedHexoriumLightGray_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumStructureCasingGray_1,
                " A ",
                "RHR",
                " B ",
                'R', stackRedstone_1, 'H', stackEnergizedHexoriumGray_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumStructureCasingDarkGray_1,
                " A ",
                "RHR",
                " B ",
                'R', stackRedstone_1, 'H', stackEnergizedHexoriumDarkGray_1, 'A', "nuggetIron", 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumStructureCasingBlack_1,
                " A ",
                "RHR",
                " B ",
                'R', stackRedstone_1, 'H', stackEnergizedHexoriumBlack_1, 'A', "nuggetIron", 'B', "stone"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumStructureCasingRainbow_1,
                " A ",
                "RHR",
                " B ",
                'R', stackRedstone_1, 'H', stackEnergizedHexoriumRainbow_1, 'A', "nuggetIron", 'B', "stone"));


        // Glowing Hexorium-Coated Stone
        GameRegistry.addRecipe(stackGlowingHexoriumCoatedStoneRed_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumRed_1, 'A', stackHexoriumCoatedStone_1);
        GameRegistry.addRecipe(stackGlowingHexoriumCoatedStoneOrange_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumOrange_1, 'A', stackHexoriumCoatedStone_1);
        GameRegistry.addRecipe(stackGlowingHexoriumCoatedStoneYellow_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumYellow_1, 'A', stackHexoriumCoatedStone_1);
        GameRegistry.addRecipe(stackGlowingHexoriumCoatedStoneLime_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumLime_1, 'A', stackHexoriumCoatedStone_1);
        GameRegistry.addRecipe(stackGlowingHexoriumCoatedStoneGreen_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumGreen_1, 'A', stackHexoriumCoatedStone_1);
        GameRegistry.addRecipe(stackGlowingHexoriumCoatedStoneTurquoise_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumTurquoise_1, 'A', stackHexoriumCoatedStone_1);
        GameRegistry.addRecipe(stackGlowingHexoriumCoatedStoneCyan_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumCyan_1, 'A', stackHexoriumCoatedStone_1);
        GameRegistry.addRecipe(stackGlowingHexoriumCoatedStoneSkyBlue_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumSkyBlue_1, 'A', stackHexoriumCoatedStone_1);
        GameRegistry.addRecipe(stackGlowingHexoriumCoatedStoneBlue_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumBlue_1, 'A', stackHexoriumCoatedStone_1);
        GameRegistry.addRecipe(stackGlowingHexoriumCoatedStonePurple_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumPurple_1, 'A', stackHexoriumCoatedStone_1);
        GameRegistry.addRecipe(stackGlowingHexoriumCoatedStoneMagenta_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumMagenta_1, 'A', stackHexoriumCoatedStone_1);
        GameRegistry.addRecipe(stackGlowingHexoriumCoatedStonePink_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumPink_1, 'A', stackHexoriumCoatedStone_1);

        GameRegistry.addRecipe(stackGlowingHexoriumCoatedStoneWhite_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumWhite_1, 'A', stackHexoriumCoatedStone_1);
        GameRegistry.addRecipe(stackGlowingHexoriumCoatedStoneLightGray_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumLightGray_1, 'A', stackHexoriumCoatedStone_1);
        GameRegistry.addRecipe(stackGlowingHexoriumCoatedStoneGray_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumGray_1, 'A', stackHexoriumCoatedStone_1);
        GameRegistry.addRecipe(stackGlowingHexoriumCoatedStoneDarkGray_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumDarkGray_1, 'A', stackHexoriumCoatedStone_1);
        GameRegistry.addRecipe(stackGlowingHexoriumCoatedStoneBlack_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumBlack_1, 'A', stackHexoriumCoatedStone_1);

        GameRegistry.addRecipe(stackGlowingHexoriumCoatedStoneRainbow_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumRainbow_1, 'A', stackHexoriumCoatedStone_1);

        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumRed_1,
                stackGlowingHexoriumCoatedStoneRed_1,
                stackGlowingHexoriumCoatedStoneRed_1,
                stackGlowingHexoriumCoatedStoneRed_1,
                stackGlowingHexoriumCoatedStoneRed_1,
                stackGlowingHexoriumCoatedStoneRed_1,
                stackGlowingHexoriumCoatedStoneRed_1,
                stackGlowingHexoriumCoatedStoneRed_1,
                stackGlowingHexoriumCoatedStoneRed_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumOrange_1,
                stackGlowingHexoriumCoatedStoneOrange_1,
                stackGlowingHexoriumCoatedStoneOrange_1,
                stackGlowingHexoriumCoatedStoneOrange_1,
                stackGlowingHexoriumCoatedStoneOrange_1,
                stackGlowingHexoriumCoatedStoneOrange_1,
                stackGlowingHexoriumCoatedStoneOrange_1,
                stackGlowingHexoriumCoatedStoneOrange_1,
                stackGlowingHexoriumCoatedStoneOrange_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumYellow_1,
                stackGlowingHexoriumCoatedStoneYellow_1,
                stackGlowingHexoriumCoatedStoneYellow_1,
                stackGlowingHexoriumCoatedStoneYellow_1,
                stackGlowingHexoriumCoatedStoneYellow_1,
                stackGlowingHexoriumCoatedStoneYellow_1,
                stackGlowingHexoriumCoatedStoneYellow_1,
                stackGlowingHexoriumCoatedStoneYellow_1,
                stackGlowingHexoriumCoatedStoneYellow_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumLime_1,
                stackGlowingHexoriumCoatedStoneLime_1,
                stackGlowingHexoriumCoatedStoneLime_1,
                stackGlowingHexoriumCoatedStoneLime_1,
                stackGlowingHexoriumCoatedStoneLime_1,
                stackGlowingHexoriumCoatedStoneLime_1,
                stackGlowingHexoriumCoatedStoneLime_1,
                stackGlowingHexoriumCoatedStoneLime_1,
                stackGlowingHexoriumCoatedStoneLime_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumGreen_1,
                stackGlowingHexoriumCoatedStoneGreen_1,
                stackGlowingHexoriumCoatedStoneGreen_1,
                stackGlowingHexoriumCoatedStoneGreen_1,
                stackGlowingHexoriumCoatedStoneGreen_1,
                stackGlowingHexoriumCoatedStoneGreen_1,
                stackGlowingHexoriumCoatedStoneGreen_1,
                stackGlowingHexoriumCoatedStoneGreen_1,
                stackGlowingHexoriumCoatedStoneGreen_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumTurquoise_1,
                stackGlowingHexoriumCoatedStoneTurquoise_1,
                stackGlowingHexoriumCoatedStoneTurquoise_1,
                stackGlowingHexoriumCoatedStoneTurquoise_1,
                stackGlowingHexoriumCoatedStoneTurquoise_1,
                stackGlowingHexoriumCoatedStoneTurquoise_1,
                stackGlowingHexoriumCoatedStoneTurquoise_1,
                stackGlowingHexoriumCoatedStoneTurquoise_1,
                stackGlowingHexoriumCoatedStoneTurquoise_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumCyan_1,
                stackGlowingHexoriumCoatedStoneCyan_1,
                stackGlowingHexoriumCoatedStoneCyan_1,
                stackGlowingHexoriumCoatedStoneCyan_1,
                stackGlowingHexoriumCoatedStoneCyan_1,
                stackGlowingHexoriumCoatedStoneCyan_1,
                stackGlowingHexoriumCoatedStoneCyan_1,
                stackGlowingHexoriumCoatedStoneCyan_1,
                stackGlowingHexoriumCoatedStoneCyan_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumSkyBlue_1,
                stackGlowingHexoriumCoatedStoneSkyBlue_1,
                stackGlowingHexoriumCoatedStoneSkyBlue_1,
                stackGlowingHexoriumCoatedStoneSkyBlue_1,
                stackGlowingHexoriumCoatedStoneSkyBlue_1,
                stackGlowingHexoriumCoatedStoneSkyBlue_1,
                stackGlowingHexoriumCoatedStoneSkyBlue_1,
                stackGlowingHexoriumCoatedStoneSkyBlue_1,
                stackGlowingHexoriumCoatedStoneSkyBlue_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumBlue_1,
                stackGlowingHexoriumCoatedStoneBlue_1,
                stackGlowingHexoriumCoatedStoneBlue_1,
                stackGlowingHexoriumCoatedStoneBlue_1,
                stackGlowingHexoriumCoatedStoneBlue_1,
                stackGlowingHexoriumCoatedStoneBlue_1,
                stackGlowingHexoriumCoatedStoneBlue_1,
                stackGlowingHexoriumCoatedStoneBlue_1,
                stackGlowingHexoriumCoatedStoneBlue_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumPurple_1,
                stackGlowingHexoriumCoatedStonePurple_1,
                stackGlowingHexoriumCoatedStonePurple_1,
                stackGlowingHexoriumCoatedStonePurple_1,
                stackGlowingHexoriumCoatedStonePurple_1,
                stackGlowingHexoriumCoatedStonePurple_1,
                stackGlowingHexoriumCoatedStonePurple_1,
                stackGlowingHexoriumCoatedStonePurple_1,
                stackGlowingHexoriumCoatedStonePurple_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumMagenta_1,
                stackGlowingHexoriumCoatedStoneMagenta_1,
                stackGlowingHexoriumCoatedStoneMagenta_1,
                stackGlowingHexoriumCoatedStoneMagenta_1,
                stackGlowingHexoriumCoatedStoneMagenta_1,
                stackGlowingHexoriumCoatedStoneMagenta_1,
                stackGlowingHexoriumCoatedStoneMagenta_1,
                stackGlowingHexoriumCoatedStoneMagenta_1,
                stackGlowingHexoriumCoatedStoneMagenta_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumPink_1,
                stackGlowingHexoriumCoatedStonePink_1,
                stackGlowingHexoriumCoatedStonePink_1,
                stackGlowingHexoriumCoatedStonePink_1,
                stackGlowingHexoriumCoatedStonePink_1,
                stackGlowingHexoriumCoatedStonePink_1,
                stackGlowingHexoriumCoatedStonePink_1,
                stackGlowingHexoriumCoatedStonePink_1,
                stackGlowingHexoriumCoatedStonePink_1);

        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumWhite_1,
                stackGlowingHexoriumCoatedStoneWhite_1,
                stackGlowingHexoriumCoatedStoneWhite_1,
                stackGlowingHexoriumCoatedStoneWhite_1,
                stackGlowingHexoriumCoatedStoneWhite_1,
                stackGlowingHexoriumCoatedStoneWhite_1,
                stackGlowingHexoriumCoatedStoneWhite_1,
                stackGlowingHexoriumCoatedStoneWhite_1,
                stackGlowingHexoriumCoatedStoneWhite_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumLightGray_1,
                stackGlowingHexoriumCoatedStoneLightGray_1,
                stackGlowingHexoriumCoatedStoneLightGray_1,
                stackGlowingHexoriumCoatedStoneLightGray_1,
                stackGlowingHexoriumCoatedStoneLightGray_1,
                stackGlowingHexoriumCoatedStoneLightGray_1,
                stackGlowingHexoriumCoatedStoneLightGray_1,
                stackGlowingHexoriumCoatedStoneLightGray_1,
                stackGlowingHexoriumCoatedStoneLightGray_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumGray_1,
                stackGlowingHexoriumCoatedStoneGray_1,
                stackGlowingHexoriumCoatedStoneGray_1,
                stackGlowingHexoriumCoatedStoneGray_1,
                stackGlowingHexoriumCoatedStoneGray_1,
                stackGlowingHexoriumCoatedStoneGray_1,
                stackGlowingHexoriumCoatedStoneGray_1,
                stackGlowingHexoriumCoatedStoneGray_1,
                stackGlowingHexoriumCoatedStoneGray_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumDarkGray_1,
                stackGlowingHexoriumCoatedStoneDarkGray_1,
                stackGlowingHexoriumCoatedStoneDarkGray_1,
                stackGlowingHexoriumCoatedStoneDarkGray_1,
                stackGlowingHexoriumCoatedStoneDarkGray_1,
                stackGlowingHexoriumCoatedStoneDarkGray_1,
                stackGlowingHexoriumCoatedStoneDarkGray_1,
                stackGlowingHexoriumCoatedStoneDarkGray_1,
                stackGlowingHexoriumCoatedStoneDarkGray_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumBlack_1,
                stackGlowingHexoriumCoatedStoneBlack_1,
                stackGlowingHexoriumCoatedStoneBlack_1,
                stackGlowingHexoriumCoatedStoneBlack_1,
                stackGlowingHexoriumCoatedStoneBlack_1,
                stackGlowingHexoriumCoatedStoneBlack_1,
                stackGlowingHexoriumCoatedStoneBlack_1,
                stackGlowingHexoriumCoatedStoneBlack_1,
                stackGlowingHexoriumCoatedStoneBlack_1);

        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumRainbow_1,
                stackGlowingHexoriumCoatedStoneRainbow_1,
                stackGlowingHexoriumCoatedStoneRainbow_1,
                stackGlowingHexoriumCoatedStoneRainbow_1,
                stackGlowingHexoriumCoatedStoneRainbow_1,
                stackGlowingHexoriumCoatedStoneRainbow_1,
                stackGlowingHexoriumCoatedStoneRainbow_1,
                stackGlowingHexoriumCoatedStoneRainbow_1,
                stackGlowingHexoriumCoatedStoneRainbow_1);

        // Glowing Hexorium Glass
        GameRegistry.addRecipe(stackGlowingHexoriumGlassRed_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumRed_1, 'A', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassOrange_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumOrange_1, 'A', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassYellow_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumYellow_1, 'A', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassLime_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumLime_1, 'A', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassGreen_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumGreen_1, 'A', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassTurquoise_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumTurquoise_1, 'A', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassCyan_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumCyan_1, 'A', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassSkyBlue_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumSkyBlue_1, 'A', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassBlue_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumBlue_1, 'A', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassPurple_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumPurple_1, 'A', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassMagenta_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumMagenta_1, 'A', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassPink_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumPink_1, 'A', stackTemperedHexoriumGlass_1);

        GameRegistry.addRecipe(stackGlowingHexoriumGlassWhite_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumWhite_1, 'A', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassLightGray_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumLightGray_1, 'A', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassGray_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumGray_1, 'A', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassDarkGray_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumDarkGray_1, 'A', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassBlack_8,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumBlack_1, 'A', stackTemperedHexoriumGlass_1);

        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumRed_1,
                stackGlowingHexoriumGlassRed_1,
                stackGlowingHexoriumGlassRed_1,
                stackGlowingHexoriumGlassRed_1,
                stackGlowingHexoriumGlassRed_1,
                stackGlowingHexoriumGlassRed_1,
                stackGlowingHexoriumGlassRed_1,
                stackGlowingHexoriumGlassRed_1,
                stackGlowingHexoriumGlassRed_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumOrange_1,
                stackGlowingHexoriumGlassOrange_1,
                stackGlowingHexoriumGlassOrange_1,
                stackGlowingHexoriumGlassOrange_1,
                stackGlowingHexoriumGlassOrange_1,
                stackGlowingHexoriumGlassOrange_1,
                stackGlowingHexoriumGlassOrange_1,
                stackGlowingHexoriumGlassOrange_1,
                stackGlowingHexoriumGlassOrange_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumYellow_1,
                stackGlowingHexoriumGlassYellow_1,
                stackGlowingHexoriumGlassYellow_1,
                stackGlowingHexoriumGlassYellow_1,
                stackGlowingHexoriumGlassYellow_1,
                stackGlowingHexoriumGlassYellow_1,
                stackGlowingHexoriumGlassYellow_1,
                stackGlowingHexoriumGlassYellow_1,
                stackGlowingHexoriumGlassYellow_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumLime_1,
                stackGlowingHexoriumGlassLime_1,
                stackGlowingHexoriumGlassLime_1,
                stackGlowingHexoriumGlassLime_1,
                stackGlowingHexoriumGlassLime_1,
                stackGlowingHexoriumGlassLime_1,
                stackGlowingHexoriumGlassLime_1,
                stackGlowingHexoriumGlassLime_1,
                stackGlowingHexoriumGlassLime_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumGreen_1,
                stackGlowingHexoriumGlassGreen_1,
                stackGlowingHexoriumGlassGreen_1,
                stackGlowingHexoriumGlassGreen_1,
                stackGlowingHexoriumGlassGreen_1,
                stackGlowingHexoriumGlassGreen_1,
                stackGlowingHexoriumGlassGreen_1,
                stackGlowingHexoriumGlassGreen_1,
                stackGlowingHexoriumGlassGreen_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumTurquoise_1,
                stackGlowingHexoriumGlassTurquoise_1,
                stackGlowingHexoriumGlassTurquoise_1,
                stackGlowingHexoriumGlassTurquoise_1,
                stackGlowingHexoriumGlassTurquoise_1,
                stackGlowingHexoriumGlassTurquoise_1,
                stackGlowingHexoriumGlassTurquoise_1,
                stackGlowingHexoriumGlassTurquoise_1,
                stackGlowingHexoriumGlassTurquoise_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumCyan_1,
                stackGlowingHexoriumGlassCyan_1,
                stackGlowingHexoriumGlassCyan_1,
                stackGlowingHexoriumGlassCyan_1,
                stackGlowingHexoriumGlassCyan_1,
                stackGlowingHexoriumGlassCyan_1,
                stackGlowingHexoriumGlassCyan_1,
                stackGlowingHexoriumGlassCyan_1,
                stackGlowingHexoriumGlassCyan_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumSkyBlue_1,
                stackGlowingHexoriumGlassSkyBlue_1,
                stackGlowingHexoriumGlassSkyBlue_1,
                stackGlowingHexoriumGlassSkyBlue_1,
                stackGlowingHexoriumGlassSkyBlue_1,
                stackGlowingHexoriumGlassSkyBlue_1,
                stackGlowingHexoriumGlassSkyBlue_1,
                stackGlowingHexoriumGlassSkyBlue_1,
                stackGlowingHexoriumGlassSkyBlue_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumBlue_1,
                stackGlowingHexoriumGlassBlue_1,
                stackGlowingHexoriumGlassBlue_1,
                stackGlowingHexoriumGlassBlue_1,
                stackGlowingHexoriumGlassBlue_1,
                stackGlowingHexoriumGlassBlue_1,
                stackGlowingHexoriumGlassBlue_1,
                stackGlowingHexoriumGlassBlue_1,
                stackGlowingHexoriumGlassBlue_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumPurple_1,
                stackGlowingHexoriumGlassPurple_1,
                stackGlowingHexoriumGlassPurple_1,
                stackGlowingHexoriumGlassPurple_1,
                stackGlowingHexoriumGlassPurple_1,
                stackGlowingHexoriumGlassPurple_1,
                stackGlowingHexoriumGlassPurple_1,
                stackGlowingHexoriumGlassPurple_1,
                stackGlowingHexoriumGlassPurple_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumMagenta_1,
                stackGlowingHexoriumGlassMagenta_1,
                stackGlowingHexoriumGlassMagenta_1,
                stackGlowingHexoriumGlassMagenta_1,
                stackGlowingHexoriumGlassMagenta_1,
                stackGlowingHexoriumGlassMagenta_1,
                stackGlowingHexoriumGlassMagenta_1,
                stackGlowingHexoriumGlassMagenta_1,
                stackGlowingHexoriumGlassMagenta_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumPink_1,
                stackGlowingHexoriumGlassPink_1,
                stackGlowingHexoriumGlassPink_1,
                stackGlowingHexoriumGlassPink_1,
                stackGlowingHexoriumGlassPink_1,
                stackGlowingHexoriumGlassPink_1,
                stackGlowingHexoriumGlassPink_1,
                stackGlowingHexoriumGlassPink_1,
                stackGlowingHexoriumGlassPink_1);

        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumWhite_1,
                stackGlowingHexoriumGlassWhite_1,
                stackGlowingHexoriumGlassWhite_1,
                stackGlowingHexoriumGlassWhite_1,
                stackGlowingHexoriumGlassWhite_1,
                stackGlowingHexoriumGlassWhite_1,
                stackGlowingHexoriumGlassWhite_1,
                stackGlowingHexoriumGlassWhite_1,
                stackGlowingHexoriumGlassWhite_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumLightGray_1,
                stackGlowingHexoriumGlassLightGray_1,
                stackGlowingHexoriumGlassLightGray_1,
                stackGlowingHexoriumGlassLightGray_1,
                stackGlowingHexoriumGlassLightGray_1,
                stackGlowingHexoriumGlassLightGray_1,
                stackGlowingHexoriumGlassLightGray_1,
                stackGlowingHexoriumGlassLightGray_1,
                stackGlowingHexoriumGlassLightGray_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumGray_1,
                stackGlowingHexoriumGlassGray_1,
                stackGlowingHexoriumGlassGray_1,
                stackGlowingHexoriumGlassGray_1,
                stackGlowingHexoriumGlassGray_1,
                stackGlowingHexoriumGlassGray_1,
                stackGlowingHexoriumGlassGray_1,
                stackGlowingHexoriumGlassGray_1,
                stackGlowingHexoriumGlassGray_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumDarkGray_1,
                stackGlowingHexoriumGlassDarkGray_1,
                stackGlowingHexoriumGlassDarkGray_1,
                stackGlowingHexoriumGlassDarkGray_1,
                stackGlowingHexoriumGlassDarkGray_1,
                stackGlowingHexoriumGlassDarkGray_1,
                stackGlowingHexoriumGlassDarkGray_1,
                stackGlowingHexoriumGlassDarkGray_1,
                stackGlowingHexoriumGlassDarkGray_1);
        GameRegistry.addShapelessRecipe(stackEnergizedHexoriumBlack_1,
                stackGlowingHexoriumGlassBlack_1,
                stackGlowingHexoriumGlassBlack_1,
                stackGlowingHexoriumGlassBlack_1,
                stackGlowingHexoriumGlassBlack_1,
                stackGlowingHexoriumGlassBlack_1,
                stackGlowingHexoriumGlassBlack_1,
                stackGlowingHexoriumGlassBlack_1,
                stackGlowingHexoriumGlassBlack_1);


        // Hexorium Lamp
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampRed_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumRed_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstone_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampOrange_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumOrange_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstone_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampYellow_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumYellow_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstone_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampLime_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumLime_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstone_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampGreen_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumGreen_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstone_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampTurquoise_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumTurquoise_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstone_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampCyan_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumCyan_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstone_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampSkyBlue_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumSkyBlue_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstone_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampBlue_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumBlue_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstone_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampPurple_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumPurple_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstone_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampMagenta_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumMagenta_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstone_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampPink_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumPink_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstone_1, 'D', stackGlowstoneDust_1));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampWhite_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumWhite_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstone_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampLightGray_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumLightGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstone_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampGray_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstone_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampDarkGray_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumDarkGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstone_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampBlack_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumBlack_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstone_1, 'D', stackGlowstoneDust_1));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampRainbow_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumRainbow_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstone_1, 'D', stackGlowstoneDust_1));

        // Hexorium Lamp (Swap)
        GameRegistry.addRecipe(stackHexoriumLampRed_1,
                "A",
                "B",
                'A', stackHexoriumLampInvRed_1, 'B', stackRedstone_1);
        GameRegistry.addRecipe(stackHexoriumLampOrange_1,
                "A",
                "B",
                'A', stackHexoriumLampInvOrange_1, 'B', stackRedstone_1);
        GameRegistry.addRecipe(stackHexoriumLampYellow_1,
                "A",
                "B",
                'A', stackHexoriumLampInvYellow_1, 'B', stackRedstone_1);
        GameRegistry.addRecipe(stackHexoriumLampLime_1,
                "A",
                "B",
                'A', stackHexoriumLampInvLime_1, 'B', stackRedstone_1);
        GameRegistry.addRecipe(stackHexoriumLampGreen_1,
                "A",
                "B",
                'A', stackHexoriumLampInvGreen_1, 'B', stackRedstone_1);
        GameRegistry.addRecipe(stackHexoriumLampTurquoise_1,
                "A",
                "B",
                'A', stackHexoriumLampInvTurquoise_1, 'B', stackRedstone_1);
        GameRegistry.addRecipe(stackHexoriumLampCyan_1,
                "A",
                "B",
                'A', stackHexoriumLampInvCyan_1, 'B', stackRedstone_1);
        GameRegistry.addRecipe(stackHexoriumLampSkyBlue_1,
                "A",
                "B",
                'A', stackHexoriumLampInvSkyBlue_1, 'B', stackRedstone_1);
        GameRegistry.addRecipe(stackHexoriumLampBlue_1,
                "A",
                "B",
                'A', stackHexoriumLampInvBlue_1, 'B', stackRedstone_1);
        GameRegistry.addRecipe(stackHexoriumLampPurple_1,
                "A",
                "B",
                'A', stackHexoriumLampInvPurple_1, 'B', stackRedstone_1);
        GameRegistry.addRecipe(stackHexoriumLampMagenta_1,
                "A",
                "B",
                'A', stackHexoriumLampInvMagenta_1, 'B', stackRedstone_1);
        GameRegistry.addRecipe(stackHexoriumLampPink_1,
                "A",
                "B",
                'A', stackHexoriumLampInvPink_1, 'B', stackRedstone_1);

        GameRegistry.addRecipe(stackHexoriumLampWhite_1,
                "A",
                "B",
                'A', stackHexoriumLampInvWhite_1, 'B', stackRedstone_1);
        GameRegistry.addRecipe(stackHexoriumLampLightGray_1,
                "A",
                "B",
                'A', stackHexoriumLampInvLightGray_1, 'B', stackRedstone_1);
        GameRegistry.addRecipe(stackHexoriumLampGray_1,
                "A",
                "B",
                'A', stackHexoriumLampInvGray_1, 'B', stackRedstone_1);
        GameRegistry.addRecipe(stackHexoriumLampDarkGray_1,
                "A",
                "B",
                'A', stackHexoriumLampInvDarkGray_1, 'B', stackRedstone_1);
        GameRegistry.addRecipe(stackHexoriumLampBlack_1,
                "A",
                "B",
                'A', stackHexoriumLampInvBlack_1, 'B', stackRedstone_1);

        GameRegistry.addRecipe(stackHexoriumLampRainbow_1,
                "A",
                "B",
                'A', stackHexoriumLampInvRainbow_1, 'B', stackRedstone_1);

        // Inverted Hexorium Lamp
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampInvRed_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumRed_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampInvOrange_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumOrange_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampInvYellow_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumYellow_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampInvLime_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumLime_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampInvGreen_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumGreen_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampInvTurquoise_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumTurquoise_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampInvCyan_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumCyan_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampInvSkyBlue_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumSkyBlue_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampInvBlue_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumBlue_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampInvPurple_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumPurple_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampInvMagenta_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumMagenta_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampInvPink_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumPink_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampInvWhite_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumWhite_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampInvLightGray_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumLightGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampInvGray_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampInvDarkGray_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumDarkGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampInvBlack_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumBlack_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumLampInvRainbow_1,
                "DAD",
                "BHB",
                "DCD",
                'H', stackEnergizedHexoriumRainbow_1, 'A', stackTemperedHexoriumGlass_1, 'B', "nuggetIron", 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1));

        // Inverted Hexorium Lamp (Swap)
        GameRegistry.addRecipe(stackHexoriumLampInvRed_1,
                "A",
                "B",
                'A', stackHexoriumLampRed_1, 'B', stackRedstoneTorch_1);
        GameRegistry.addRecipe(stackHexoriumLampInvOrange_1,
                "A",
                "B",
                'A', stackHexoriumLampOrange_1, 'B', stackRedstoneTorch_1);
        GameRegistry.addRecipe(stackHexoriumLampInvYellow_1,
                "A",
                "B",
                'A', stackHexoriumLampYellow_1, 'B', stackRedstoneTorch_1);
        GameRegistry.addRecipe(stackHexoriumLampInvLime_1,
                "A",
                "B",
                'A', stackHexoriumLampLime_1, 'B', stackRedstoneTorch_1);
        GameRegistry.addRecipe(stackHexoriumLampInvGreen_1,
                "A",
                "B",
                'A', stackHexoriumLampGreen_1, 'B', stackRedstoneTorch_1);
        GameRegistry.addRecipe(stackHexoriumLampInvTurquoise_1,
                "A",
                "B",
                'A', stackHexoriumLampTurquoise_1, 'B', stackRedstoneTorch_1);
        GameRegistry.addRecipe(stackHexoriumLampInvCyan_1,
                "A",
                "B",
                'A', stackHexoriumLampCyan_1, 'B', stackRedstoneTorch_1);
        GameRegistry.addRecipe(stackHexoriumLampInvSkyBlue_1,
                "A",
                "B",
                'A', stackHexoriumLampSkyBlue_1, 'B', stackRedstoneTorch_1);
        GameRegistry.addRecipe(stackHexoriumLampInvBlue_1,
                "A",
                "B",
                'A', stackHexoriumLampBlue_1, 'B', stackRedstoneTorch_1);
        GameRegistry.addRecipe(stackHexoriumLampInvPurple_1,
                "A",
                "B",
                'A', stackHexoriumLampPurple_1, 'B', stackRedstoneTorch_1);
        GameRegistry.addRecipe(stackHexoriumLampInvMagenta_1,
                "A",
                "B",
                'A', stackHexoriumLampMagenta_1, 'B', stackRedstoneTorch_1);
        GameRegistry.addRecipe(stackHexoriumLampInvPink_1,
                "A",
                "B",
                'A', stackHexoriumLampPink_1, 'B', stackRedstoneTorch_1);

        GameRegistry.addRecipe(stackHexoriumLampInvWhite_1,
                "A",
                "B",
                'A', stackHexoriumLampWhite_1, 'B', stackRedstoneTorch_1);
        GameRegistry.addRecipe(stackHexoriumLampInvLightGray_1,
                "A",
                "B",
                'A', stackHexoriumLampLightGray_1, 'B', stackRedstoneTorch_1);
        GameRegistry.addRecipe(stackHexoriumLampInvGray_1,
                "A",
                "B",
                'A', stackHexoriumLampGray_1, 'B', stackRedstoneTorch_1);
        GameRegistry.addRecipe(stackHexoriumLampInvDarkGray_1,
                "A",
                "B",
                'A', stackHexoriumLampDarkGray_1, 'B', stackRedstoneTorch_1);
        GameRegistry.addRecipe(stackHexoriumLampInvBlack_1,
                "A",
                "B",
                'A', stackHexoriumLampBlack_1, 'B', stackRedstoneTorch_1);

        GameRegistry.addRecipe(stackHexoriumLampInvRainbow_1,
                "A",
                "B",
                'A', stackHexoriumLampRainbow_1, 'B', stackRedstoneTorch_1);

        // Hexorium Door
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorRed_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumRed_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorOrange_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumOrange_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorYellow_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumYellow_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorLime_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumLime_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorGreen_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumGreen_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorTurquoise_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumTurquoise_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorCyan_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumCyan_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorSkyBlue_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumSkyBlue_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorBlue_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumBlue_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorPurple_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumPurple_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorMagenta_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumMagenta_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorPink_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumPink_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorWhite_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumWhite_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorLightGray_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumLightGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorGray_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorDarkGray_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumDarkGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorBlack_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumBlack_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumDoorRainbow_1,
                "BB",
                "HA",
                "BB",
                'H', stackEnergizedHexoriumRainbow_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));

        // Hexorium Hatch
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchRed_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumRed_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchOrange_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumOrange_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchYellow_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumYellow_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchLime_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumLime_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchGreen_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumGreen_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchTurquoise_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumTurquoise_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchCyan_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumCyan_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchSkyBlue_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumSkyBlue_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchBlue_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumBlue_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchPurple_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumPurple_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchMagenta_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumMagenta_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchPink_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumPink_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchWhite_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumWhite_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchLightGray_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumLightGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchGray_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchDarkGray_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumDarkGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchBlack_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumBlack_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumHatchRainbow_2,
                "BAB",
                "BHB",
                'H', stackEnergizedHexoriumRainbow_1, 'A', stackTemperedHexoriumGlass_1, 'B', "ingotIron"));

        // Machines
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumMachineBlock_1,
                "C C",
                "RAR",
                "CBC",
                'R', stackRedstone_1, 'A', stackEnergizedHexoriumWhite_1, 'B', stackSpatialProjector_1, 'C', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackAdvancedRainbowCore_1,
                "BRB",
                "RAR",
                "BRB",
                'R', stackRedstone_1, 'A', stackEnergizedHexoriumRainbow_1, 'B', "ingotGold"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumGenerator_1,
                "EBE",
                "DAD",
                "ECE",
                'A', stackHexoriumMachineBlock_1, 'B', stackMachineControlPanel_1, 'C', stackMachineEnergyRouter_1, 'D', stackHeatDissipator_1, 'E', "ingotIron"));

        if (HexConfig.cfgFurnaceEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumFurnace_1,
                    "EBE",
                    "DAD",
                    "ECE",
                    'A', stackHexoriumMachineBlock_1, 'B', stackMachineControlPanel_1, 'C', stackMachineEnergyRouter_1, 'D', stackHeatingArray_1, 'E', "ingotIron"));
        }

        if (HexConfig.cfgSeparatorEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackCrystalSeparator_1,
                    "EBE",
                    "DAD",
                    "ECE",
                    'A', stackHexoriumMachineBlock_1, 'B', stackMachineControlPanel_1, 'C', stackMachineEnergyRouter_1, 'D', stackCrystalExtractionUnit_1, 'E', "ingotIron"));
        }

        GameRegistry.addRecipe(new ShapedOreRecipe(stackMatrixReconstructor_1,
                "EBE",
                "DAD",
                "ECE",
                'A', stackHexoriumMachineBlock_1, 'B', stackMachineControlPanel_1, 'C', stackMachineEnergyRouter_1, 'D', stackMatrixAdjuster_1, 'E', "ingotIron"));

        if (HexConfig.cfgTeleportEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackPersonalTeleportationPad_1,
                    "DED",
                    "BAC",
                    "FCF",
                    'A', stackHexoriumMachineBlock_1, 'B', stackMolecularRecoder_1, 'C', stackMachineEnergyRouter_1, 'D', stackTeleportationFieldProjector_1,
                    'E', stackMaterialInteractionPlane_1, 'F', "ingotIron"));
        }

        if (HexConfig.cfgObserverEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackQuantumObserver_1,
                    "CBF",
                    "FAF",
                    "EDE",
                    'A', stackObservationalEye_1, 'B', stackMachineEnergyRouter_1, 'C', stackMachineControlPanel_1, 'D', stackEnergizedHexoriumBlack_1,
                    'E', stackIronBars_1, 'F', "ingotIron"));
            GameRegistry.addRecipe(new ShapedOreRecipe(stackQuantumAnchor_1,
                    "B B",
                    "BAB",
                    "B B",
                    'A', stackEnergizedHexoriumBlack_1, 'B', stackIronBars_1));
        }

        // Tank Valve
        if (HexConfig.cfgTankEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackTankValve_1,
                    "ECE",
                    "BAB",
                    "EDE",
                    'A', stackHexoriumMachineBlock_1, 'B', stackDigitalSmartpipe_1, 'C', stackMachineControlPanel_1, 'D', stackRainbowCore_1,
                    'E', "ingotIron"));
        }

        // Energy Node
        if (HexConfig.cfgEnergyNodeEnable) {
            GameRegistry.addRecipe(stackEnergyNodeCoreT1_1,
                    "RBR",
                    "BAB",
                    "RBR",
                    'R', stackRedstoneBlock_1, 'A', stackAdvancedRainbowCore_1, 'B', stackHexoriumProcessor_1);
            GameRegistry.addRecipe(new ShapedOreRecipe(stackEnergyNodeCoreT2_1,
                    "RBR",
                    "BAB",
                    "RBR",
                    'R', stackRedstoneBlock_1, 'A', stackEnergyNodeCoreT1_1, 'B', "ingotIron"));
            GameRegistry.addRecipe(new ShapedOreRecipe(stackEnergyNodeCoreT3_1,
                    "RBR",
                    "BAB",
                    "RBR",
                    'R', stackRedstoneBlock_1, 'A', stackEnergyNodeCoreT2_1, 'B', "ingotGold"));
            GameRegistry.addRecipe(new ShapedOreRecipe(stackEnergyNodeCoreT4_1,
                    "RBR",
                    "BAB",
                    "RBR",
                    'R', stackRedstoneBlock_1, 'A', stackEnergyNodeCoreT3_1, 'B', "gemDiamond"));

            GameRegistry.addRecipe(new ShapedOreRecipe(stackEnergyNodePortHEX_1,
                    "EBE",
                    "DAR",
                    "ECE",
                    'R', stackRedstoneBlock_1, 'A', stackEnergizedHexoriumRainbow_1, 'B', stackMachineControlPanel_1,
                    'C', stackHexoriumEnergyConverter_1, 'D', stackHexoriumCableRainbow_1, 'E', "ingotIron"));
            if (HexConfig.cfgEnergyNodePortsRFEnable) {
                GameRegistry.addRecipe(new ShapedOreRecipe(stackEnergyNodePortRF_1,
                        "EBE",
                        "DAR",
                        "ECE",
                        'R', stackRedstoneBlock_1, 'A', stackEnergizedHexoriumRainbow_1, 'B', stackMachineControlPanel_1,
                        'C', stackHexoriumRFAdapter_1, 'D', "ingotGold", 'E', "ingotIron"));
            }
            if (Loader.isModLoaded("IC2") && HexConfig.cfgEnergyNodePortsEUEnable) {
                ItemStack stackAdvancedCircuit_1 = IC2Items.getItem("advancedCircuit");
                ItemStack stackInsulatedGoldCable_1 = IC2Items.getItem("insulatedGoldCableItem");
                if (stackAdvancedCircuit_1 != null && stackInsulatedGoldCable_1 != null)
                    GameRegistry.addRecipe(new ShapedOreRecipe(stackEnergyNodePortEU_1,
                            "EBE",
                            "DAR",
                            "ECE",
                            'R', stackRedstoneBlock_1, 'A', stackEnergizedHexoriumRainbow_1, 'B', stackMachineControlPanel_1,
                            'C', stackAdvancedCircuit_1, 'D', stackInsulatedGoldCable_1, 'E', "ingotIron"));
            }
        }

        // Cables
        // Red
        GameRegistry.addRecipe(stackHexoriumCableRed_4,
                " R ",
                "AEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);

        // Orange
        GameRegistry.addRecipe(stackHexoriumCableOrange_4,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableOrange_4,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableOrange_4,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableOrange_4,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);

        // Yellow
        GameRegistry.addRecipe(stackHexoriumCableYellow_4,
                " R ",
                "BEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableYellow_4,
                " R ",
                "AEB",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);

        // Lime
        GameRegistry.addRecipe(stackHexoriumCableLime_4,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableLime_4,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableLime_4,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableLime_4,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);

        // Green
        GameRegistry.addRecipe(stackHexoriumCableGreen_4,
                " R ",
                "AEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);

        // Turquoise
        GameRegistry.addRecipe(stackHexoriumCableTurquoise_4,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableTurquoise_4,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableTurquoise_4,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableTurquoise_4,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);

        // Cyan
        GameRegistry.addRecipe(stackHexoriumCableCyan_4,
                " R ",
                "BEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableCyan_4,
                " R ",
                "AEB",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);

        // SkyBlue
        GameRegistry.addRecipe(stackHexoriumCableSkyBlue_4,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableSkyBlue_4,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableSkyBlue_4,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableSkyBlue_4,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);

        // Blue
        GameRegistry.addRecipe(stackHexoriumCableBlue_4,
                " R ",
                "AEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);

        // Purple
        GameRegistry.addRecipe(stackHexoriumCablePurple_4,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCablePurple_4,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCablePurple_4,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCablePurple_4,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);

        // Magenta
        GameRegistry.addRecipe(stackHexoriumCableMagenta_4,
                " R ",
                "BEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableMagenta_4,
                " R ",
                "AEB",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);

        // Pink
        GameRegistry.addRecipe(stackHexoriumCablePink_4,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCablePink_4,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCablePink_4,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCablePink_4,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);

        // White
        GameRegistry.addRecipe(stackHexoriumCableWhite_4,
                " R ",
                "AEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'E', stackTemperedHexoriumGlass_1);

        // LightGray
        GameRegistry.addRecipe(stackHexoriumCableLightGray_4,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableLightGray_4,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableLightGray_4,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableLightGray_4,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);

        // Gray
        GameRegistry.addRecipe(stackHexoriumCableGray_4,
                " R ",
                "BEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableGray_4,
                " R ",
                "AEB",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);

        // DarkGray
        GameRegistry.addRecipe(stackHexoriumCableDarkGray_4,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableDarkGray_4,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableDarkGray_4,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableDarkGray_4,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1, 'E', stackTemperedHexoriumGlass_1);

        // Black
        GameRegistry.addRecipe(stackHexoriumCableBlack_4,
                " R ",
                "AEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);
        
        // Rainbow
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "AEB",
                "CED",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "AEB",
                "DEC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "AEC",
                "BED",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "AEC",
                "DEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "AED",
                "BEC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "AED",
                "CEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "BEA",
                "CED",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "BEA",
                "DEC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "BEC",
                "AED",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "BEC",
                "DEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "BED",
                "AEC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "BED",
                "CEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "CEA",
                "BED",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "CEA",
                "DEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "CEB",
                "AED",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "CEB",
                "DEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "CED",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "CED",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "DEA",
                "BEC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "DEA",
                "CEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "DEB",
                "AEC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "DEB",
                "CEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "DEC",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_4,
                " R ",
                "DEC",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);

        // Energy Pylon
        GameRegistry.addRecipe(new ShapedOreRecipe(stackEnergyPylon_1,
                "   ",
                "RBR",
                "CAC",
                'R', stackRedstone_1, 'A', stackPylonSocket_1, 'B', stackEnergyInjector_1, 'C', "ingotIron"));

        // Hexorium Switch
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumSwitchRedGreen_1,
                "ARB",
                "CDC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', "nuggetIron", 'D', stackLever_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumSwitchRedBlue_1,
                "ARB",
                "CDC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1, 'C', "nuggetIron", 'D', stackLever_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumSwitchRedWhite_1,
                "ARB",
                "CDC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalWhite_1, 'C', "nuggetIron", 'D', stackLever_1));

        // Hexorium Button
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumButtonRed_1,
                " A ",
                "BRB",
                " C ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', "nuggetIron", 'C', stackStoneButton_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumButtonGreen_1,
                " A ",
                "BRB",
                " C ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', "nuggetIron", 'C', stackStoneButton_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumButtonBlue_1,
                " A ",
                "BRB",
                " C ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', "nuggetIron", 'C', stackStoneButton_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumButtonWhite_1,
                " A ",
                "BRB",
                " C ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', "nuggetIron", 'C', stackStoneButton_1));

        // Hexorium Pressure Plate
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumPressurePlateRed_1,
                "ARA",
                "BCB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', "nuggetIron", 'C', stackHeavyWeightedPressurePlate_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumPressurePlateGreen_1,
                "ARA",
                "BCB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', "nuggetIron", 'C', stackHeavyWeightedPressurePlate_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumPressurePlateBlue_1,
                "ARA",
                "BCB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', "nuggetIron", 'C', stackHeavyWeightedPressurePlate_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumPressurePlateWhite_1,
                "ARA",
                "BCB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', "nuggetIron", 'C', stackHeavyWeightedPressurePlate_1));

        // Regular Blocks
        GameRegistry.addSmelting(stackHexoriumGlassPackage_1, stackTemperedHexoriumGlass_4, 0F);

        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumCoatedStone_8,
                "BBB",
                "BAB",
                "BBB",
                'A', stackHexoriumCrystalRed_1, 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumCoatedStone_8,
                "BBB",
                "BAB",
                "BBB",
                'A', stackHexoriumCrystalGreen_1, 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumCoatedStone_8,
                "BBB",
                "BAB",
                "BBB",
                'A', stackHexoriumCrystalBlue_1, 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumCoatedStone_8,
                "BBB",
                "BAB",
                "BBB",
                'A', stackHexoriumCrystalWhite_1, 'B', "stone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumCoatedStone_8,
                "BBB",
                "BAB",
                "BBB",
                'A', stackHexoriumCrystalBlack_1, 'B', "stone"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackPylonBase51_1,
                "DAD",
                "ABA",
                "DCD",
                'A', stackHexoriumCableRainbow_1, 'B', stackHexoriumEnergyConverter_1, 'C', stackPylonSocket_1, 'D', "ingotIron"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackPylonBase15_1,
                "DCD",
                "CBC",
                "DAD",
                'A', stackHexoriumCableRainbow_1, 'B', stackHexoriumEnergyConverter_1, 'C', stackPylonSocket_1, 'D', "ingotIron"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackSoundProjector_1,
                "DRD",
                "ABC",
                "DRD",
                'R', stackRedstone_1, 'A', stackMachineControlPanel_1, 'B', stackRainbowCore_1, 'C', stackSoundEmissionModule_1, 'D', "ingotIron"));

        // Hex Items
        // Components T1
        GameRegistry.addRecipe(new ShapedOreRecipe(Items.iron_ingot,
                "NNN",
                "NNN",
                "NNN",
                'N', "nuggetIron"));

        GameRegistry.addRecipe(new ShapelessOreRecipe(stackIronNugget_9,
                "ingotIron"));

        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " B ",
                "ARC",
                " D ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " B ",
                "ARD",
                " C ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " C ",
                "ARB",
                " D ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " C ",
                "ARD",
                " B ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " D ",
                "ARB",
                " C ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " D ",
                "ARC",
                " B ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " A ",
                "BRC",
                " D ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " A ",
                "BRD",
                " C ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " C ",
                "BRA",
                " D ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " C ",
                "BRD",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " D ",
                "BRA",
                " C ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " D ",
                "BRC",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " A ",
                "CRB",
                " D ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " A ",
                "CRD",
                " B ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " B ",
                "CRA",
                " D ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " B ",
                "CRD",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " D ",
                "CRA",
                " B ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " D ",
                "CRB",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " A ",
                "DRB",
                " C ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " A ",
                "DRC",
                " B ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " B ",
                "DRA",
                " C ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " B ",
                "DRC",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " C ",
                "DRA",
                " B ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);
        GameRegistry.addRecipe(stackRainbowEnergizedGlobule_1,
                " C ",
                "DRB",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1);

        GameRegistry.addSmelting(stackHexoriumCrystalWhite_1, stackWhiteHexoriumWafer_1, 0F);
        GameRegistry.addSmelting(stackHexoriumCrystalBlack_1, stackBlackHexoriumWafer_1, 0F);
        GameRegistry.addRecipe(new ShapedOreRecipe(stackSpatialProjector_1,
                "BAB",
                " B ",
                " R ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', "nuggetIron"));
        if (HexConfig.cfgSeparatorEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackOreActuator_1,
                    "B  ",
                    "ABR",
                    "B  ",
                    'R', stackRedstone_1, 'A', stackIronPickaxe_1, 'B', "nuggetIron"));
        }
        GameRegistry.addRecipe(new ShapedOreRecipe(stackPylonSocket_1,
                "BAB",
                "RRR",
                'R', stackRedstone_1, 'A', stackHexoriumCableRainbow_1, 'B', "nuggetIron"));

        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumGlassPackage_1,
                "BCB",
                "CAC",
                "BCB",
                'A', stackHexoriumCrystalRed_1, 'B', "nuggetIron", 'C', "glass"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumGlassPackage_1,
                "BCB",
                "CAC",
                "BCB",
                'A', stackHexoriumCrystalGreen_1, 'B', "nuggetIron", 'C', "glass"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumGlassPackage_1,
                "BCB",
                "CAC",
                "BCB",
                'A', stackHexoriumCrystalBlue_1, 'B', "nuggetIron", 'C', "glass"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumGlassPackage_1,
                "BCB",
                "CAC",
                "BCB",
                'A', stackHexoriumCrystalWhite_1, 'B', "nuggetIron", 'C', "glass"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumGlassPackage_1,
                "BCB",
                "CAC",
                "BCB",
                'A', stackHexoriumCrystalBlack_1, 'B', "nuggetIron", 'C', "glass"));

        // Components T2
        GameRegistry.addRecipe(new ShapedOreRecipe(stackRainbowCore_1,
                " R ",
                "BAB",
                " R ",
                'R', stackRedstone_1, 'A', stackRainbowEnergizedGlobule_1, 'B', "nuggetGold"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumCoprocessor_1,
                " R ",
                "RAR",
                "BBB",
                'R', stackRedstone_1, 'A', stackWhiteHexoriumWafer_1, 'B', "nuggetIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumProcessor_1,
                " R ",
                "RAR",
                "BBB",
                'R', stackRedstone_1, 'A', stackBlackHexoriumWafer_1, 'B', "nuggetGold"));
        if (HexConfig.cfgSeparatorEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackMineralAnalyzer_1,
                    "BCD",
                    "FEA",
                    " R ",
                    'R', stackRedstone_1, 'A', stackHexoriumCoprocessor_1, 'B', stackHexoriumCrystalRed_1, 'C', stackHexoriumCrystalGreen_1, 'D', stackHexoriumCrystalBlue_1,
                    'E', "gemDiamond", 'F', "ingotGold"));
        }
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumEnergyConverter_1,
                "EAE",
                "CBD",
                "AEA",
                'A', stackHexoriumCableRainbow_1, 'B', stackRainbowCore_1, 'C', stackHexoriumProcessor_1, 'D', stackHexoriumCoprocessor_1, 'E', "nuggetIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackEnergyInjector_1,
                "CDE",
                "FBF",
                " A ",
                'A', stackHexoriumCableRainbow_1, 'B', stackSpatialProjector_1, 'C', stackHexoriumCrystalRed_1, 'D', stackHexoriumCrystalGreen_1, 'E', stackHexoriumCrystalBlue_1,
                'F', "nuggetGold"));
        if (HexConfig.cfgTeleportEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackMolecularRecoder_1,
                    "DRD",
                    "CBC",
                    "DAD",
                    'R', stackRedstone_1, 'A', stackHexoriumCableRainbow_1, 'B', stackHexoriumProcessor_1, 'C', stackRainbowCore_1, 'D', "nuggetIron"));
        }
        if (HexConfig.cfgEnergyNodeEnable && HexConfig.cfgEnergyNodePortsRFEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumRFAdapter_1,
                    "RBR",
                    "RAR",
                    "RBR",
                    'R', stackRedstone_1, 'A', stackRainbowCore_1, 'B', "nuggetGold"));
        }

        // Components MP
        GameRegistry.addRecipe(new ShapedOreRecipe(stackMachineControlPanel_1,
                "CB ",
                "CAR",
                "CB ",
                'R', stackRedstone_1, 'A', stackHexoriumProcessor_1, 'B', "nuggetGold", 'C', stackStoneButton_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackMachineEnergyRouter_1,
                "DB",
                "AR",
                "DC",
                'R', stackRedstone_1, 'A', stackHexoriumCableRainbow_1, 'B', stackHexoriumCoprocessor_1, 'C', "nuggetGold", 'D', "nuggetIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHeatDissipator_1,
                "BBR",
                "BBA",
                "BBR",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', "nuggetIron"));
        if (HexConfig.cfgFurnaceEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackHeatingArray_1,
                    "RRB",
                    "RAB",
                    "RRB",
                    'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', "nuggetIron"));
        }
        if (HexConfig.cfgSeparatorEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackCrystalExtractionUnit_1,
                    " BD",
                    "CAD",
                    " RD",
                    'R', stackRedstone_1, 'A', stackHexoriumCoprocessor_1, 'B', stackMineralAnalyzer_1, 'C', stackOreActuator_1, 'D', "nuggetIron"));
        }
        GameRegistry.addRecipe(new ShapedOreRecipe(stackMatrixAdjuster_1,
                " ED",
                "CBA",
                " RD",
                'R', stackRedstone_1, 'A', stackHexoriumCoprocessor_1, 'B', stackRainbowCore_1, 'C', stackSpatialProjector_1, 'D', "nuggetIron", 'E', "gemDiamond"));
        if (HexConfig.cfgTeleportEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackMaterialInteractionPlane_1,
                    "AAA",
                    "ARA",
                    "CBC",
                    'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumProcessor_1, 'C', "nuggetGold"));
            GameRegistry.addRecipe(new ShapedOreRecipe(stackTeleportationFieldProjector_1,
                    "ADA",
                    "BCB",
                    "ERE",
                    'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCoprocessor_1, 'C', stackSpatialProjector_1, 'D', "gemDiamond", 'E', "nuggetGold"));
        }
        if (HexConfig.cfgObserverEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackObservationalEye_1,
                    " A ",
                    " C ",
                    " B ",
                    'A', stackEnergizedHexoriumMonolithBlack_1, 'B', stackHexoriumProcessor_1, 'C', stackEnderEye_1));
        }
        if (HexConfig.cfgTankEnable) {
            GameRegistry.addRecipe(new ShapedOreRecipe(stackDigitalSmartpipe_1,
                    "ARR",
                    " DD",
                    "BCR",
                    'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCoprocessor_1, 'D', "nuggetIron"));
        }
        GameRegistry.addRecipe(new ShapedOreRecipe(stackSoundEmissionModule_1,
                "AEB",
                "RDR",
                "FCF",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1, 'C', stackHexoriumCrystalGreen_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackRainbowEnergizedGlobule_1, 'F', "nuggetIron"));

        // Tools
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumManipulator_1,
                "AEF",
                "EBC",
                " DE",
                'A', stackHexoriumCrystalBlack_1, 'B', stackRainbowCore_1, 'C', stackHexoriumProcessor_1, 'D', stackHexoriumCoprocessor_1, 'E', "ingotIron", 'F', stackStoneButton_1));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackHexoriumProbe_1,
                "A  ",
                " DB",
                " CD",
                'A', stackHexoriumCrystalWhite_1, 'B', stackMachineControlPanel_1, 'C', stackHexoriumCoprocessor_1, 'D', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(stackMolecularTransposer_1,
                "E  ",
                " CB",
                " DA",
                'A', stackHexoriumManipulator_1, 'B', stackMachineControlPanel_1, 'C', stackSpatialProjector_1, 'D', "chestWood", 'E', "ingotIron"));
        GameRegistry.addRecipe(stackHexoriumReinforcer_12,
                " A ",
                "BBB",
                "BBB",
                'A', stackHexoriumCrystalBlack_1, 'B', stackObsidian_1);
    }
}

// ABCD ABDC ACBD ACDB ADBC ADCB BACD BADC BCAD BCDA BDAC BDCA CABD CADB CBAD CBDA CDAB CDBA DABC DACB DBAC DBCA DCAB DCBA