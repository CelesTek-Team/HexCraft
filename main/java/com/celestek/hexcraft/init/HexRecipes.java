package com.celestek.hexcraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.6.0
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
        ItemStack stackGlass_1 = new ItemStack(Blocks.glass, 1);
        ItemStack stackObsidian_1 = new ItemStack(Blocks.obsidian, 1);
        ItemStack stackStoneButton_1 = new ItemStack(Blocks.stone_button, 1);
        ItemStack stackLever_1 = new ItemStack(Blocks.lever, 1);
        ItemStack stackRedstoneTorch_1 = new ItemStack(Blocks.redstone_torch, 1);

        // Vanilla Items
        ItemStack stackRedstone_1 = new ItemStack(Items.redstone, 1);
        ItemStack stackGlowstoneDust_1 = new ItemStack(Items.glowstone_dust, 1);
        ItemStack stackIronIngot_1 = new ItemStack(Items.iron_ingot, 1);
        ItemStack stackGoldIngot_1 = new ItemStack(Items.gold_ingot, 1);
        ItemStack stackDiamond_1 = new ItemStack(Items.diamond, 1);
        ItemStack stackIronPickaxe_1 = new ItemStack(Items.iron_pickaxe, 1);


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

        // Glowing Hexorium Glass
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
        ItemStack stackHexoriumHatchRed_2 = new ItemStack(HexBlocks.blockHexoriumHatchRed, 1);
        ItemStack stackHexoriumHatchOrange_2 = new ItemStack(HexBlocks.blockHexoriumHatchOrange, 1);
        ItemStack stackHexoriumHatchYellow_2 = new ItemStack(HexBlocks.blockHexoriumHatchYellow, 1);
        ItemStack stackHexoriumHatchLime_2 = new ItemStack(HexBlocks.blockHexoriumHatchLime, 1);
        ItemStack stackHexoriumHatchGreen_2 = new ItemStack(HexBlocks.blockHexoriumHatchGreen, 1);
        ItemStack stackHexoriumHatchTurquoise_2 = new ItemStack(HexBlocks.blockHexoriumHatchTurquoise, 1);
        ItemStack stackHexoriumHatchCyan_2 = new ItemStack(HexBlocks.blockHexoriumHatchCyan, 1);
        ItemStack stackHexoriumHatchSkyBlue_2 = new ItemStack(HexBlocks.blockHexoriumHatchSkyBlue, 1);
        ItemStack stackHexoriumHatchBlue_2 = new ItemStack(HexBlocks.blockHexoriumHatchBlue, 1);
        ItemStack stackHexoriumHatchPurple_2 = new ItemStack(HexBlocks.blockHexoriumHatchPurple, 1);
        ItemStack stackHexoriumHatchMagenta_2 = new ItemStack(HexBlocks.blockHexoriumHatchMagenta, 1);
        ItemStack stackHexoriumHatchPink_2 = new ItemStack(HexBlocks.blockHexoriumHatchPink, 1);

        ItemStack stackHexoriumHatchWhite_2 = new ItemStack(HexBlocks.blockHexoriumHatchWhite, 1);
        ItemStack stackHexoriumHatchLightGray_2 = new ItemStack(HexBlocks.blockHexoriumHatchLightGray, 1);
        ItemStack stackHexoriumHatchGray_2 = new ItemStack(HexBlocks.blockHexoriumHatchGray, 1);
        ItemStack stackHexoriumHatchDarkGray_2 = new ItemStack(HexBlocks.blockHexoriumHatchDarkGray, 1);
        ItemStack stackHexoriumHatchBlack_2 = new ItemStack(HexBlocks.blockHexoriumHatchBlack, 1);

        ItemStack stackHexoriumHatchRainbow_2 = new ItemStack(HexBlocks.blockHexoriumHatchRainbow, 1);

        // Machines
        ItemStack stackHexoriumMachineBlock_1 = new ItemStack(HexBlocks.blockHexoriumMachineBlock, 1);

        ItemStack stackHexoriumGenerator_1 = new ItemStack(HexBlocks.blockHexoriumGenerator, 1);
        ItemStack stackHexoriumFurnace_1 = new ItemStack(HexBlocks.blockHexoriumFurnace, 1);
        ItemStack stackCrystalSeparator_1 = new ItemStack(HexBlocks.blockCrystalSeparator, 1);
        ItemStack stackMatrixReconstructor_1 = new ItemStack(HexBlocks.blockMatrixReconstructor, 1);

        ItemStack stackPersonalTeleportationPad_1 = new ItemStack(HexBlocks.blockPersonalTeleportationPad, 1);

        // Cables
        ItemStack stackHexoriumCableRed_2 = new ItemStack(HexBlocks.blockHexoriumCableRed, 2);
        ItemStack stackHexoriumCableOrange_2 = new ItemStack(HexBlocks.blockHexoriumCableOrange, 2);
        ItemStack stackHexoriumCableYellow_2 = new ItemStack(HexBlocks.blockHexoriumCableYellow, 2);
        ItemStack stackHexoriumCableLime_2 = new ItemStack(HexBlocks.blockHexoriumCableLime, 2);
        ItemStack stackHexoriumCableGreen_2 = new ItemStack(HexBlocks.blockHexoriumCableGreen, 2);
        ItemStack stackHexoriumCableTurquoise_2 = new ItemStack(HexBlocks.blockHexoriumCableTurquoise, 2);
        ItemStack stackHexoriumCableCyan_2 = new ItemStack(HexBlocks.blockHexoriumCableCyan, 2);
        ItemStack stackHexoriumCableSkyBlue_2 = new ItemStack(HexBlocks.blockHexoriumCableSkyBlue, 2);
        ItemStack stackHexoriumCableBlue_2 = new ItemStack(HexBlocks.blockHexoriumCableBlue, 2);
        ItemStack stackHexoriumCablePurple_2 = new ItemStack(HexBlocks.blockHexoriumCablePurple, 2);
        ItemStack stackHexoriumCableMagenta_2 = new ItemStack(HexBlocks.blockHexoriumCableMagenta, 2);
        ItemStack stackHexoriumCablePink_2 = new ItemStack(HexBlocks.blockHexoriumCablePink, 2);

        ItemStack stackHexoriumCableWhite_2 = new ItemStack(HexBlocks.blockHexoriumCableWhite, 2);
        ItemStack stackHexoriumCableLightGray_2 = new ItemStack(HexBlocks.blockHexoriumCableLightGray, 2);
        ItemStack stackHexoriumCableGray_2 = new ItemStack(HexBlocks.blockHexoriumCableGray, 2);
        ItemStack stackHexoriumCableDarkGray_2 = new ItemStack(HexBlocks.blockHexoriumCableDarkGray, 2);
        ItemStack stackHexoriumCableBlack_2 = new ItemStack(HexBlocks.blockHexoriumCableBlack, 2);

        ItemStack stackHexoriumCableRainbow_1 = new ItemStack(HexBlocks.blockHexoriumCableRainbow, 1);
        ItemStack stackHexoriumCableRainbow_2 = new ItemStack(HexBlocks.blockHexoriumCableRainbow, 2);

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

        // Regular Blocks
        ItemStack stackTemperedHexoriumGlass_1 = new ItemStack(HexBlocks.blockTemperedHexoriumGlass, 1);
        ItemStack stackTemperedHexoriumGlass_4 = new ItemStack(HexBlocks.blockTemperedHexoriumGlass, 4);

        ItemStack stackPylonBase51_1 = new ItemStack(HexBlocks.blockPylonBase51, 1);
        ItemStack stackPylonBase15_1 = new ItemStack(HexBlocks.blockPylonBase15, 1);

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
        ItemStack stackSpatialProjector_1 = new ItemStack(HexItems.itemSpatialProjector, 1);
        ItemStack stackOreActuator_1 = new ItemStack(HexItems.itemOreActuator, 1);
        ItemStack stackPylonSocket_1 = new ItemStack(HexItems.itemPylonSocket, 1);
        ItemStack stackHexoriumGlassPackage_1 = new ItemStack(HexItems.itemHexoriumGlassPackage, 1);

        // Components T2
        ItemStack stackRainbowCore_1 = new ItemStack(HexItems.itemRainbowCore, 1);
        ItemStack stackHexoriumCoprocessor_1 = new ItemStack(HexItems.itemHexoriumCoprocessor, 1);
        ItemStack stackHexoriumProcessor_1 = new ItemStack(HexItems.itemHexoriumProcessor, 1);
        ItemStack stackMineralAnalyzer_1 = new ItemStack(HexItems.itemMineralAnalyzer, 1);
        ItemStack stackPylonEnergyConverter_1 = new ItemStack(HexItems.itemPylonEnergyConverter, 1);
        ItemStack stackEnergyInjector_1 = new ItemStack(HexItems.itemEnergyInjector, 1);
        ItemStack stackMolecularRecoder_1 = new ItemStack(HexItems.itemMolecularRecoder, 1);

        // Components MP
        ItemStack stackMachineControlPanel_1 = new ItemStack(HexItems.itemMachineControlPanel, 1);
        ItemStack stackMachineEnergyRouter_1 = new ItemStack(HexItems.itemMachineEnergyRouter, 1);
        ItemStack stackHeatDissipator_1 = new ItemStack(HexItems.itemHeatDissipator, 1);
        ItemStack stackHeatingArray_1 = new ItemStack(HexItems.itemHeatingArray, 1);
        ItemStack stackCrystalExtractionUnit_1 = new ItemStack(HexItems.itemCrystalExtractionUnit, 1);
        ItemStack stackMatrixAdjuster_1 = new ItemStack(HexItems.itemMatrixAdjuster, 1);
        ItemStack stackMaterialInteractionPlane_1 = new ItemStack(HexItems.itemMaterialInteractionPlane, 1);
        ItemStack stackTeleportationFieldProjector_1 = new ItemStack(HexItems.itemTeleportationFieldProjector, 1);

        // Tools
        ItemStack stackHexoriumManipulator_1 = new ItemStack(HexItems.itemHexoriumManipulator, 1);
        ItemStack stackHexoriumReinforcer_6 = new ItemStack(HexItems.itemHexoriumReinforcer, 6);


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


        // Plated Hexorium Block
        GameRegistry.addRecipe(stackPlatedHexoriumBlockRed_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumRed_1, 'A', stackStone_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackPlatedHexoriumBlockOrange_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumOrange_1, 'A', stackStone_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackPlatedHexoriumBlockYellow_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumYellow_1, 'A', stackStone_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackPlatedHexoriumBlockLime_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumLime_1, 'A', stackStone_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackPlatedHexoriumBlockGreen_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumGreen_1, 'A', stackStone_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackPlatedHexoriumBlockTurquoise_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumTurquoise_1, 'A', stackStone_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackPlatedHexoriumBlockCyan_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumCyan_1, 'A', stackStone_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackPlatedHexoriumBlockSkyBlue_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumSkyBlue_1, 'A', stackStone_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackPlatedHexoriumBlockBlue_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumBlue_1, 'A', stackStone_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackPlatedHexoriumBlockPurple_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumPurple_1, 'A', stackStone_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackPlatedHexoriumBlockMagenta_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumMagenta_1, 'A', stackStone_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackPlatedHexoriumBlockPink_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumPink_1, 'A', stackStone_1, 'B', stackIronIngot_1);

        GameRegistry.addRecipe(stackPlatedHexoriumBlockWhite_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumWhite_1, 'A', stackStone_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackPlatedHexoriumBlockLightGray_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumLightGray_1, 'A', stackStone_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackPlatedHexoriumBlockGray_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumGray_1, 'A', stackStone_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackPlatedHexoriumBlockDarkGray_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumDarkGray_1, 'A', stackStone_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackPlatedHexoriumBlockBlack_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumBlack_1, 'A', stackStone_1, 'B', stackIronIngot_1);

        GameRegistry.addRecipe(stackPlatedHexoriumBlockRainbow_1,
                "ABA",
                "BHB",
                "ABA",
                'H', stackEnergizedHexoriumRainbow_1, 'A', stackStone_1, 'B', stackIronIngot_1);


        // Concentric Hexorium Block
        GameRegistry.addRecipe(stackConcentricHexoriumBlockRed_1,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumRed_1, 'A', stackStone_1);
        GameRegistry.addRecipe(stackConcentricHexoriumBlockOrange_1,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumOrange_1, 'A', stackStone_1);
        GameRegistry.addRecipe(stackConcentricHexoriumBlockYellow_1,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumYellow_1, 'A', stackStone_1);
        GameRegistry.addRecipe(stackConcentricHexoriumBlockLime_1,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumLime_1, 'A', stackStone_1);
        GameRegistry.addRecipe(stackConcentricHexoriumBlockGreen_1,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumGreen_1, 'A', stackStone_1);
        GameRegistry.addRecipe(stackConcentricHexoriumBlockTurquoise_1,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumTurquoise_1, 'A', stackStone_1);
        GameRegistry.addRecipe(stackConcentricHexoriumBlockCyan_1,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumCyan_1, 'A', stackStone_1);
        GameRegistry.addRecipe(stackConcentricHexoriumBlockSkyBlue_1,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumSkyBlue_1, 'A', stackStone_1);
        GameRegistry.addRecipe(stackConcentricHexoriumBlockBlue_1,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumBlue_1, 'A', stackStone_1);
        GameRegistry.addRecipe(stackConcentricHexoriumBlockPurple_1,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumPurple_1, 'A', stackStone_1);
        GameRegistry.addRecipe(stackConcentricHexoriumBlockMagenta_1,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumMagenta_1, 'A', stackStone_1);
        GameRegistry.addRecipe(stackConcentricHexoriumBlockPink_1,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumPink_1, 'A', stackStone_1);

        GameRegistry.addRecipe(stackConcentricHexoriumBlockWhite_1,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumWhite_1, 'A', stackStone_1);
        GameRegistry.addRecipe(stackConcentricHexoriumBlockLightGray_1,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumLightGray_1, 'A', stackStone_1);
        GameRegistry.addRecipe(stackConcentricHexoriumBlockGray_1,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumGray_1, 'A', stackStone_1);
        GameRegistry.addRecipe(stackConcentricHexoriumBlockDarkGray_1,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumDarkGray_1, 'A', stackStone_1);
        GameRegistry.addRecipe(stackConcentricHexoriumBlockBlack_1,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumBlack_1, 'A', stackStone_1);

        GameRegistry.addRecipe(stackConcentricHexoriumBlockRainbow_1,
                "AAA",
                "AHA",
                "AAA",
                'H', stackEnergizedHexoriumRainbow_1, 'A', stackStone_1);

        // Glowing Hexorium Glass
        // Red
        GameRegistry.addRecipe(stackGlowingHexoriumGlassRed_1,
                "RA ",
                "ACA",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'C', stackTemperedHexoriumGlass_1);

        // Orange
        GameRegistry.addRecipe(stackGlowingHexoriumGlassOrange_1,
                "RB ",
                "ACA",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassOrange_1,
                "RA ",
                "ACB",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassOrange_1,
                "RA ",
                "ACA",
                " B ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassOrange_1,
                "RA ",
                "BCA",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackTemperedHexoriumGlass_1);

        // Yellow
        GameRegistry.addRecipe(stackGlowingHexoriumGlassYellow_1,
                "RB ",
                "ACA",
                " B ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassYellow_1,
                "RA ",
                "BCB",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackTemperedHexoriumGlass_1);

        // Lime
        GameRegistry.addRecipe(stackGlowingHexoriumGlassLime_1,
                "RB ",
                "ACA",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassLime_1,
                "RA ",
                "ACB",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassLime_1,
                "RA ",
                "ACA",
                " B ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassLime_1,
                "RA ",
                "BCA",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1, 'C', stackTemperedHexoriumGlass_1);

        // Green
        GameRegistry.addRecipe(stackGlowingHexoriumGlassGreen_1,
                "RA ",
                "ACA",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'C', stackTemperedHexoriumGlass_1);

        // Turquoise
        GameRegistry.addRecipe(stackGlowingHexoriumGlassTurquoise_1,
                "RB ",
                "ACA",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassTurquoise_1,
                "RA ",
                "ACB",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassTurquoise_1,
                "RA ",
                "ACA",
                " B ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassTurquoise_1,
                "RA ",
                "BCA",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'C', stackTemperedHexoriumGlass_1);

        // Cyan
        GameRegistry.addRecipe(stackGlowingHexoriumGlassCyan_1,
                "RB ",
                "ACA",
                " B ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassCyan_1,
                "RA ",
                "BCB",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'C', stackTemperedHexoriumGlass_1);

        // SkyBlue
        GameRegistry.addRecipe(stackGlowingHexoriumGlassSkyBlue_1,
                "RB ",
                "ACA",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassSkyBlue_1,
                "RA ",
                "ACB",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassSkyBlue_1,
                "RA ",
                "ACA",
                " B ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassSkyBlue_1,
                "RA ",
                "BCA",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackTemperedHexoriumGlass_1);

        // Blue
        GameRegistry.addRecipe(stackGlowingHexoriumGlassBlue_1,
                "RA ",
                "ACA",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'C', stackTemperedHexoriumGlass_1);

        // Purple
        GameRegistry.addRecipe(stackGlowingHexoriumGlassPurple_1,
                "RB ",
                "ACA",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassPurple_1,
                "RA ",
                "ACB",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassPurple_1,
                "RA ",
                "ACA",
                " B ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassPurple_1,
                "RA ",
                "BCA",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'C', stackTemperedHexoriumGlass_1);

        // Magenta
        GameRegistry.addRecipe(stackGlowingHexoriumGlassMagenta_1,
                "RB ",
                "ACA",
                " B ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassMagenta_1,
                "RA ",
                "BCB",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'C', stackTemperedHexoriumGlass_1);

        // Pink
        GameRegistry.addRecipe(stackGlowingHexoriumGlassPink_1,
                "RB ",
                "ACA",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassPink_1,
                "RA ",
                "ACB",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassPink_1,
                "RA ",
                "ACA",
                " B ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassPink_1,
                "RA ",
                "BCA",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1, 'C', stackTemperedHexoriumGlass_1);


        // White
        GameRegistry.addRecipe(stackGlowingHexoriumGlassWhite_1,
                "RA ",
                "ACA",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'C', stackTemperedHexoriumGlass_1);

        // LightGray
        GameRegistry.addRecipe(stackGlowingHexoriumGlassLightGray_1,
                "RB ",
                "ACA",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassLightGray_1,
                "RA ",
                "ACB",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassLightGray_1,
                "RA ",
                "ACA",
                " B ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassLightGray_1,
                "RA ",
                "BCA",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'C', stackTemperedHexoriumGlass_1);

        // Gray
        GameRegistry.addRecipe(stackGlowingHexoriumGlassGray_1,
                "RB ",
                "ACA",
                " B ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassGray_1,
                "RA ",
                "BCB",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'C', stackTemperedHexoriumGlass_1);

        // DarkGray
        GameRegistry.addRecipe(stackGlowingHexoriumGlassDarkGray_1,
                "RB ",
                "ACA",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassDarkGray_1,
                "RA ",
                "ACB",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassDarkGray_1,
                "RA ",
                "ACA",
                " B ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1, 'C', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackGlowingHexoriumGlassDarkGray_1,
                "RA ",
                "BCA",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1, 'C', stackTemperedHexoriumGlass_1);

        // Black
        GameRegistry.addRecipe(stackGlowingHexoriumGlassBlack_1,
                "RA ",
                "ACA",
                " A ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'C', stackTemperedHexoriumGlass_1);


        // Hexorium Lamp
        GameRegistry.addRecipe(stackHexoriumLampRed_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumRed_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampOrange_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumOrange_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampYellow_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumYellow_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampLime_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumLime_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampGreen_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumGreen_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampTurquoise_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumTurquoise_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampCyan_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumCyan_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampSkyBlue_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumSkyBlue_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampBlue_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumBlue_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampPurple_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumPurple_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampMagenta_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumMagenta_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampPink_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumPink_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);

        GameRegistry.addRecipe(stackHexoriumLampWhite_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumWhite_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampLightGray_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumLightGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampGray_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampDarkGray_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumDarkGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampBlack_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumBlack_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);

        GameRegistry.addRecipe(stackHexoriumLampRainbow_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumRainbow_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstone_1, 'D', stackGlowstoneDust_1);

        // Inverted Hexorium Lamp
        GameRegistry.addRecipe(stackHexoriumLampInvRed_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumRed_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampInvOrange_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumOrange_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampInvYellow_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumYellow_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampInvLime_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumLime_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampInvGreen_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumGreen_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampInvTurquoise_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumTurquoise_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampInvCyan_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumCyan_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampInvSkyBlue_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumSkyBlue_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampInvBlue_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumBlue_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampInvPurple_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumPurple_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampInvMagenta_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumMagenta_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampInvPink_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumPink_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);

        GameRegistry.addRecipe(stackHexoriumLampInvWhite_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumWhite_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampInvLightGray_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumLightGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampInvGray_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampInvDarkGray_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumDarkGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);
        GameRegistry.addRecipe(stackHexoriumLampInvBlack_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumBlack_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);

        GameRegistry.addRecipe(stackHexoriumLampInvRainbow_1,
                "BDB",
                "AHA",
                "BCB",
                'H', stackEnergizedHexoriumRainbow_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1, 'C', stackRedstoneTorch_1, 'D', stackGlowstoneDust_1);

        // Hexorium Door
        GameRegistry.addRecipe(stackHexoriumDoorRed_1,
                "BB ",
                "HA ",
                "BB ",
                'H', stackEnergizedHexoriumRed_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumDoorOrange_1,
                "BB ",
                "HA ",
                "BB ",
                'H', stackEnergizedHexoriumOrange_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumDoorYellow_1,
                "BB ",
                "HA ",
                "BB ",
                'H', stackEnergizedHexoriumYellow_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumDoorLime_1,
                "BB ",
                "HA ",
                "BB ",
                'H', stackEnergizedHexoriumLime_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumDoorGreen_1,
                "BB ",
                "HA ",
                "BB ",
                'H', stackEnergizedHexoriumGreen_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumDoorTurquoise_1,
                "BB ",
                "HA ",
                "BB ",
                'H', stackEnergizedHexoriumTurquoise_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumDoorCyan_1,
                "BB ",
                "HA ",
                "BB ",
                'H', stackEnergizedHexoriumCyan_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumDoorSkyBlue_1,
                "BB ",
                "HA ",
                "BB ",
                'H', stackEnergizedHexoriumSkyBlue_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumDoorBlue_1,
                "BB ",
                "HA ",
                "BB ",
                'H', stackEnergizedHexoriumBlue_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumDoorPurple_1,
                "BB ",
                "HA ",
                "BB ",
                'H', stackEnergizedHexoriumPurple_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumDoorMagenta_1,
                "BB ",
                "HA ",
                "BB ",
                'H', stackEnergizedHexoriumMagenta_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumDoorPink_1,
                "BB ",
                "HA ",
                "BB ",
                'H', stackEnergizedHexoriumPink_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);

        GameRegistry.addRecipe(stackHexoriumDoorWhite_1,
                "BB ",
                "HA ",
                "BB ",
                'H', stackEnergizedHexoriumWhite_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumDoorLightGray_1,
                "BB ",
                "HA ",
                "BB ",
                'H', stackEnergizedHexoriumLightGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumDoorGray_1,
                "BB ",
                "HA ",
                "BB ",
                'H', stackEnergizedHexoriumGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumDoorDarkGray_1,
                "BB ",
                "HA ",
                "BB ",
                'H', stackEnergizedHexoriumDarkGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumDoorBlack_1,
                "BB ",
                "HA ",
                "BB ",
                'H', stackEnergizedHexoriumBlack_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);

        GameRegistry.addRecipe(stackHexoriumDoorRainbow_1,
                "BB ",
                "HA ",
                "BB ",
                'H', stackEnergizedHexoriumRainbow_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);

        // Hexorium Hatch
        GameRegistry.addRecipe(stackHexoriumHatchRed_2,
                "BAB",
                "BHB",
                "   ",
                'H', stackEnergizedHexoriumRed_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumHatchOrange_2,
                "BAB",
                "BHB",
                "   ",
                'H', stackEnergizedHexoriumOrange_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumHatchYellow_2,
                "BAB",
                "BHB",
                "   ",
                'H', stackEnergizedHexoriumYellow_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumHatchLime_2,
                "BAB",
                "BHB",
                "   ",
                'H', stackEnergizedHexoriumLime_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumHatchGreen_2,
                "BAB",
                "BHB",
                "   ",
                'H', stackEnergizedHexoriumGreen_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumHatchTurquoise_2,
                "BAB",
                "BHB",
                "   ",
                'H', stackEnergizedHexoriumTurquoise_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumHatchCyan_2,
                "BAB",
                "BHB",
                "   ",
                'H', stackEnergizedHexoriumCyan_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumHatchSkyBlue_2,
                "BAB",
                "BHB",
                "   ",
                'H', stackEnergizedHexoriumSkyBlue_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumHatchBlue_2,
                "BAB",
                "BHB",
                "   ",
                'H', stackEnergizedHexoriumBlue_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumHatchPurple_2,
                "BAB",
                "BHB",
                "   ",
                'H', stackEnergizedHexoriumPurple_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumHatchMagenta_2,
                "BAB",
                "BHB",
                "   ",
                'H', stackEnergizedHexoriumMagenta_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumHatchPink_2,
                "BAB",
                "BHB",
                "   ",
                'H', stackEnergizedHexoriumPink_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);

        GameRegistry.addRecipe(stackHexoriumHatchWhite_2,
                "BAB",
                "BHB",
                "   ",
                'H', stackEnergizedHexoriumWhite_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumHatchLightGray_2,
                "BAB",
                "BHB",
                "   ",
                'H', stackEnergizedHexoriumLightGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumHatchGray_2,
                "BAB",
                "BHB",
                "   ",
                'H', stackEnergizedHexoriumGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumHatchDarkGray_2,
                "BAB",
                "BHB",
                "   ",
                'H', stackEnergizedHexoriumDarkGray_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumHatchBlack_2,
                "BAB",
                "BHB",
                "   ",
                'H', stackEnergizedHexoriumBlack_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);

        GameRegistry.addRecipe(stackHexoriumHatchRainbow_2,
                "BAB",
                "BHB",
                "   ",
                'H', stackEnergizedHexoriumRainbow_1, 'A', stackTemperedHexoriumGlass_1, 'B', stackIronIngot_1);

        // Machines
        GameRegistry.addRecipe(stackHexoriumMachineBlock_1,
                "C C",
                "RAR",
                "CBC",
                'R', stackRedstone_1, 'A', stackEnergizedHexoriumWhite_1, 'B', stackSpatialProjector_1, 'C', stackIronIngot_1);

        GameRegistry.addRecipe(stackHexoriumGenerator_1,
                "EBE",
                "DAD",
                "ECE",
                'A', stackHexoriumMachineBlock_1, 'B', stackMachineControlPanel_1, 'C', stackMachineEnergyRouter_1, 'D', stackHeatDissipator_1, 'E', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumFurnace_1,
                "EBE",
                "DAD",
                "ECE",
                'A', stackHexoriumMachineBlock_1, 'B', stackMachineControlPanel_1, 'C', stackMachineEnergyRouter_1, 'D', stackHeatingArray_1, 'E', stackIronIngot_1);
        GameRegistry.addRecipe(stackCrystalSeparator_1,
                "EBE",
                "DAD",
                "ECE",
                'A', stackHexoriumMachineBlock_1, 'B', stackMachineControlPanel_1, 'C', stackMachineEnergyRouter_1, 'D', stackCrystalExtractionUnit_1, 'E', stackIronIngot_1);
        GameRegistry.addRecipe(stackMatrixReconstructor_1,
                "EBE",
                "DAD",
                "ECE",
                'A', stackHexoriumMachineBlock_1, 'B', stackMachineControlPanel_1, 'C', stackMachineEnergyRouter_1, 'D', stackMatrixAdjuster_1, 'E', stackIronIngot_1);

        GameRegistry.addRecipe(stackPersonalTeleportationPad_1,
                "DED",
                "BAC",
                "FCF",
                'A', stackHexoriumMachineBlock_1, 'B', stackMolecularRecoder_1, 'C', stackMachineEnergyRouter_1, 'D', stackTeleportationFieldProjector_1,
                'E', stackMaterialInteractionPlane_1, 'F', stackIronIngot_1);

        // Cables
        // Red
        GameRegistry.addRecipe(stackHexoriumCableRed_2,
                " R ",
                "AEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);

        // Orange
        GameRegistry.addRecipe(stackHexoriumCableOrange_2,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableOrange_2,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableOrange_2,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableOrange_2,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);

        // Yellow
        GameRegistry.addRecipe(stackHexoriumCableYellow_2,
                " R ",
                "BEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableYellow_2,
                " R ",
                "AEB",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);

        // Lime
        GameRegistry.addRecipe(stackHexoriumCableLime_2,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableLime_2,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableLime_2,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableLime_2,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);

        // Green
        GameRegistry.addRecipe(stackHexoriumCableGreen_2,
                " R ",
                "AEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);

        // Turquoise
        GameRegistry.addRecipe(stackHexoriumCableTurquoise_2,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableTurquoise_2,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableTurquoise_2,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableTurquoise_2,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);

        // Cyan
        GameRegistry.addRecipe(stackHexoriumCableCyan_2,
                " R ",
                "BEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableCyan_2,
                " R ",
                "AEB",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);

        // SkyBlue
        GameRegistry.addRecipe(stackHexoriumCableSkyBlue_2,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableSkyBlue_2,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableSkyBlue_2,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableSkyBlue_2,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalGreen_1, 'E', stackTemperedHexoriumGlass_1);

        // Blue
        GameRegistry.addRecipe(stackHexoriumCableBlue_2,
                " R ",
                "AEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);

        // Purple
        GameRegistry.addRecipe(stackHexoriumCablePurple_2,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCablePurple_2,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCablePurple_2,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCablePurple_2,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);

        // Magenta
        GameRegistry.addRecipe(stackHexoriumCableMagenta_2,
                " R ",
                "BEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableMagenta_2,
                " R ",
                "AEB",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackHexoriumCrystalRed_1, 'E', stackTemperedHexoriumGlass_1);

        // Pink
        GameRegistry.addRecipe(stackHexoriumCablePink_2,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCablePink_2,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCablePink_2,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCablePink_2,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1, 'E', stackTemperedHexoriumGlass_1);

        // White
        GameRegistry.addRecipe(stackHexoriumCableWhite_2,
                " R ",
                "AEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'E', stackTemperedHexoriumGlass_1);

        // LightGray
        GameRegistry.addRecipe(stackHexoriumCableLightGray_2,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableLightGray_2,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableLightGray_2,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableLightGray_2,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);

        // Gray
        GameRegistry.addRecipe(stackHexoriumCableGray_2,
                " R ",
                "BEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableGray_2,
                " R ",
                "AEB",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);

        // DarkGray
        GameRegistry.addRecipe(stackHexoriumCableDarkGray_2,
                " R ",
                "BEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableDarkGray_2,
                " R ",
                "AEB",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableDarkGray_2,
                " R ",
                "AEA",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1, 'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableDarkGray_2,
                " R ",
                "AEA",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumCrystalWhite_1, 'E', stackTemperedHexoriumGlass_1);

        // Black
        GameRegistry.addRecipe(stackHexoriumCableBlack_2,
                " R ",
                "AEA",
                "AEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'E', stackTemperedHexoriumGlass_1);
        
        // Rainbow
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "AEB",
                "CED",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "AEB",
                "DEC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "AEC",
                "BED",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "AEC",
                "DEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "AED",
                "BEC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "AED",
                "CEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "BEA",
                "CED",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "BEA",
                "DEC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "BEC",
                "AED",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "BEC",
                "DEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "BED",
                "AEC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "BED",
                "CEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "CEA",
                "BED",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "CEA",
                "DEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "CEB",
                "AED",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "CEB",
                "DEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "CED",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "CED",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "DEA",
                "BEC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "DEA",
                "CEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "DEB",
                "AEC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "DEB",
                "CEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "DEC",
                "AEB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);
        GameRegistry.addRecipe(stackHexoriumCableRainbow_2,
                " R ",
                "DEC",
                "BEA",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackHexoriumCrystalBlue_1, 'D', stackHexoriumCrystalWhite_1,
                'E', stackTemperedHexoriumGlass_1);

        // Energy Pylon
        GameRegistry.addRecipe(stackEnergyPylon_1,
                "C C",
                "RBR",
                "CAC",
                'R', stackRedstone_1, 'A', stackPylonSocket_1, 'B', stackEnergyInjector_1, 'C', stackIronIngot_1);

        // Hexorium Switch
        GameRegistry.addRecipe(stackHexoriumSwitchRedGreen_1,
                "ARB",
                "CDC",
                "   ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalGreen_1, 'C', stackIronIngot_1, 'D', stackLever_1);
        GameRegistry.addRecipe(stackHexoriumSwitchRedBlue_1,
                "ARB",
                "CDC",
                "   ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalBlue_1, 'C', stackIronIngot_1, 'D', stackLever_1);
        GameRegistry.addRecipe(stackHexoriumSwitchRedWhite_1,
                "ARB",
                "CDC",
                "   ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackHexoriumCrystalWhite_1, 'C', stackIronIngot_1, 'D', stackLever_1);

        // Hexorium Button
        GameRegistry.addRecipe(stackHexoriumButtonRed_1,
                " A ",
                "BRB",
                " C ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalRed_1, 'B', stackIronIngot_1, 'C', stackStoneButton_1);
        GameRegistry.addRecipe(stackHexoriumButtonGreen_1,
                " A ",
                "BRB",
                " C ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalGreen_1, 'B', stackIronIngot_1, 'C', stackStoneButton_1);
        GameRegistry.addRecipe(stackHexoriumButtonBlue_1,
                " A ",
                "BRB",
                " C ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlue_1, 'B', stackIronIngot_1, 'C', stackStoneButton_1);
        GameRegistry.addRecipe(stackHexoriumButtonWhite_1,
                " A ",
                "BRB",
                " C ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackIronIngot_1, 'C', stackStoneButton_1);

        // Regular Blocks
        GameRegistry.addSmelting(stackHexoriumGlassPackage_1, stackTemperedHexoriumGlass_4, 0F);

        GameRegistry.addRecipe(stackPylonBase51_1,
                "DAD",
                "ABA",
                "DCD",
                'A', stackHexoriumCableRainbow_1, 'B', stackPylonEnergyConverter_1, 'C', stackPylonSocket_1, 'D', stackIronIngot_1);

        GameRegistry.addRecipe(stackPylonBase15_1,
                "DCD",
                "CBC",
                "DAD",
                'A', stackHexoriumCableRainbow_1, 'B', stackPylonEnergyConverter_1, 'C', stackPylonSocket_1, 'D', stackIronIngot_1);

        // Hex Items
        // Components T1
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
        GameRegistry.addRecipe(stackSpatialProjector_1,
                "BAB",
                " B ",
                " R ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackOreActuator_1,
                "B  ",
                "ABR",
                "B  ",
                'R', stackRedstone_1, 'A', stackIronPickaxe_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackPylonSocket_1,
                "BAB",
                "RRR",
                "   ",
                'R', stackRedstone_1, 'A', stackHexoriumCableRainbow_1, 'B', stackIronIngot_1);

        GameRegistry.addRecipe(stackHexoriumGlassPackage_1,
                "BCB",
                "CAC",
                "BCB",
                'A', stackHexoriumCrystalRed_1, 'B', stackIronIngot_1, 'C', stackGlass_1);
        GameRegistry.addRecipe(stackHexoriumGlassPackage_1,
                "BCB",
                "CAC",
                "BCB",
                'A', stackHexoriumCrystalGreen_1, 'B', stackIronIngot_1, 'C', stackGlass_1);
        GameRegistry.addRecipe(stackHexoriumGlassPackage_1,
                "BCB",
                "CAC",
                "BCB",
                'A', stackHexoriumCrystalBlue_1, 'B', stackIronIngot_1, 'C', stackGlass_1);

        // Components T2
        GameRegistry.addRecipe(stackRainbowCore_1,
                " R ",
                "BAB",
                " R ",
                'R', stackRedstone_1, 'A', stackRainbowEnergizedGlobule_1, 'B', stackGoldIngot_1);
        GameRegistry.addRecipe(stackHexoriumCoprocessor_1,
                " R ",
                "RAR",
                " B ",
                'R', stackRedstone_1, 'A', stackWhiteHexoriumWafer_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHexoriumProcessor_1,
                " R ",
                "RAR",
                " B ",
                'R', stackRedstone_1, 'A', stackBlackHexoriumWafer_1, 'B', stackGoldIngot_1);
        GameRegistry.addRecipe(stackMineralAnalyzer_1,
                "BCD",
                "FEA",
                " R ",
                'R', stackRedstone_1, 'A', stackHexoriumCoprocessor_1, 'B', stackHexoriumCrystalRed_1, 'C', stackHexoriumCrystalGreen_1, 'D', stackHexoriumCrystalBlue_1,
                'E', stackDiamond_1, 'F', stackGoldIngot_1);
        GameRegistry.addRecipe(stackPylonEnergyConverter_1,
                "EAE",
                "CBD",
                "AEA",
                'A', stackHexoriumCableRainbow_1, 'B', stackRainbowCore_1, 'C', stackHexoriumProcessor_1, 'D', stackHexoriumCoprocessor_1, 'E', stackIronIngot_1);
        GameRegistry.addRecipe(stackEnergyInjector_1,
                "CDE",
                "FBF",
                " A ",
                'A', stackHexoriumCableRainbow_1, 'B', stackSpatialProjector_1, 'C', stackHexoriumCrystalRed_1, 'D', stackHexoriumCrystalGreen_1, 'E', stackHexoriumCrystalBlue_1,
                'F', stackGoldIngot_1);
        GameRegistry.addRecipe(stackMolecularRecoder_1,
                "DRD",
                "CBC",
                "DAD",
                'R', stackRedstone_1, 'A', stackHexoriumCableRainbow_1, 'B', stackHexoriumProcessor_1, 'C', stackRainbowCore_1, 'D', stackIronIngot_1);

        // Components MP
        GameRegistry.addRecipe(stackMachineControlPanel_1,
                "CB ",
                "CAR",
                "CB ",
                'R', stackRedstone_1, 'A', stackHexoriumProcessor_1, 'B', stackGoldIngot_1, 'C', stackStoneButton_1);
        GameRegistry.addRecipe(stackMachineEnergyRouter_1,
                "DB ",
                "AR ",
                "DC ",
                'R', stackRedstone_1, 'A', stackHexoriumCableRainbow_1, 'B', stackHexoriumCoprocessor_1, 'C', stackGoldIngot_1, 'D', stackIronIngot_1);
        GameRegistry.addRecipe(stackHeatDissipator_1,
                "BR ",
                "BA ",
                "BR ",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackHeatingArray_1,
                "RRB",
                "RAB",
                "RRB",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackIronIngot_1);
        GameRegistry.addRecipe(stackCrystalExtractionUnit_1,
                " BD",
                "CAD",
                " RD",
                'R', stackRedstone_1, 'A', stackHexoriumCoprocessor_1, 'B', stackMineralAnalyzer_1, 'C', stackOreActuator_1, 'D', stackIronIngot_1);
        GameRegistry.addRecipe(stackMatrixAdjuster_1,
                " ED",
                "CBA",
                " RD",
                'R', stackRedstone_1, 'A', stackHexoriumCoprocessor_1, 'B', stackRainbowCore_1, 'C', stackSpatialProjector_1, 'D', stackIronIngot_1, 'E', stackDiamond_1);
        GameRegistry.addRecipe(stackMaterialInteractionPlane_1,
                "AAA",
                "ARA",
                "CBC",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalBlack_1, 'B', stackHexoriumProcessor_1, 'C', stackGoldIngot_1);
        GameRegistry.addRecipe(stackTeleportationFieldProjector_1,
                "ADA",
                "BCB",
                "ERE",
                'R', stackRedstone_1, 'A', stackHexoriumCrystalWhite_1, 'B', stackHexoriumCoprocessor_1, 'C', stackSpatialProjector_1, 'D', stackDiamond_1, 'E', stackGoldIngot_1);

        // Tools
        GameRegistry.addRecipe(stackHexoriumManipulator_1,
                "EAE",
                "CBD",
                " EF",
                'A', stackHexoriumCrystalBlack_1, 'B', stackRainbowCore_1, 'C', stackHexoriumProcessor_1, 'D', stackHexoriumCoprocessor_1, 'E', stackIronIngot_1, 'F', stackStoneButton_1);
        GameRegistry.addRecipe(stackHexoriumReinforcer_6,
                " A ",
                "BBB",
                "BBB",
                'A', stackHexoriumCrystalBlack_1, 'B', stackObsidian_1);
    }
}

// ABCD ABDC ACBD ACDB ADBC ADCB BACD BADC BCAD BCDA BDAC BDCA CABD CADB CBAD CBDA CDAB CDBA DABC DACB DBAC DBCA DCAB DCBA