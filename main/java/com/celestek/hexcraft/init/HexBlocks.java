package com.celestek.hexcraft.init;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-15
 */
public class HexBlocks {

    /**
     * ADDING NEW BLOCKS
     * To add a new block:
     * 1) Increment countBlocks.
     * 2) Add a public static Block.
     * 3) Add the 2 required lines to initializeBlocks() (Check other blocks).
     * 4) Add the 2 required lines to HexClientProxy.setCustomRenderers() (Check other blocks).
     */

    // Total count of blocks to add.
    public static int countBlocks = 156;

    // Hexorium Nether Ore
    public static Block blockHexoriumNetherOreRed;
    public static Block blockHexoriumNetherOreGreen;
    public static Block blockHexoriumNetherOreBlue;
    
    public static Block blockHexoriumNetherOreWhite;
    public static Block blockHexoriumNetherOreBlack;

    // Hexorium Ore
    public static Block blockHexoriumOreRed;
    public static Block blockHexoriumOreGreen;
    public static Block blockHexoriumOreBlue;
    
    public static Block blockHexoriumOreWhite;
    public static Block blockHexoriumOreBlack;

    // Hexorium Monolith
    public static Block blockHexoriumMonolithRed;
    public static Block blockHexoriumMonolithGreen;
    public static Block blockHexoriumMonolithBlue;

    public static Block blockHexoriumMonolithWhite;
    public static Block blockHexoriumMonolithBlack;

    // Hexorium Nether Monolith
    public static Block blockHexoriumNetherMonolithRed;
    public static Block blockHexoriumNetherMonolithGreen;
    public static Block blockHexoriumNetherMonolithBlue;

    public static Block blockHexoriumNetherMonolithWhite;
    public static Block blockHexoriumNetherMonolithBlack;

    // Block of Hexorium Crystal
    public static Block blockOfHexoriumCrystalRed;
    public static Block blockOfHexoriumCrystalGreen;
    public static Block blockOfHexoriumCrystalBlue;
    
    public static Block blockOfHexoriumCrystalWhite;
    public static Block blockOfHexoriumCrystalBlack;

    // Energized Hexorium
    public static Block blockEnergizedHexoriumRed;
    public static Block blockEnergizedHexoriumOrange;
    public static Block blockEnergizedHexoriumYellow;
    public static Block blockEnergizedHexoriumLime;
    public static Block blockEnergizedHexoriumGreen;
    public static Block blockEnergizedHexoriumTurquoise;
    public static Block blockEnergizedHexoriumCyan;
    public static Block blockEnergizedHexoriumSkyBlue;
    public static Block blockEnergizedHexoriumBlue;
    public static Block blockEnergizedHexoriumPurple;
    public static Block blockEnergizedHexoriumMagenta;
    public static Block blockEnergizedHexoriumPink;
    
    public static Block blockEnergizedHexoriumWhite;
    public static Block blockEnergizedHexoriumLightGray;
    public static Block blockEnergizedHexoriumGray;
    public static Block blockEnergizedHexoriumDarkGray;
    public static Block blockEnergizedHexoriumBlack;

    public static Block blockEnergizedHexoriumRainbow;

    // Engineered Hexorium Block
    public static Block blockEngineeredHexoriumBlockRed;
    public static Block blockEngineeredHexoriumBlockOrange;
    public static Block blockEngineeredHexoriumBlockYellow;
    public static Block blockEngineeredHexoriumBlockLime;
    public static Block blockEngineeredHexoriumBlockGreen;
    public static Block blockEngineeredHexoriumBlockTurquoise;
    public static Block blockEngineeredHexoriumBlockCyan;
    public static Block blockEngineeredHexoriumBlockSkyBlue;
    public static Block blockEngineeredHexoriumBlockBlue;
    public static Block blockEngineeredHexoriumBlockPurple;
    public static Block blockEngineeredHexoriumBlockMagenta;
    public static Block blockEngineeredHexoriumBlockPink;

    public static Block blockEngineeredHexoriumBlockWhite;
    public static Block blockEngineeredHexoriumBlockLightGray;
    public static Block blockEngineeredHexoriumBlockGray;
    public static Block blockEngineeredHexoriumBlockDarkGray;
    public static Block blockEngineeredHexoriumBlockBlack;

    public static Block blockEngineeredHexoriumBlockRainbow;

    // Framed Hexorium Block
    public static Block blockFramedHexoriumBlockRed;
    public static Block blockFramedHexoriumBlockOrange;
    public static Block blockFramedHexoriumBlockYellow;
    public static Block blockFramedHexoriumBlockLime;
    public static Block blockFramedHexoriumBlockGreen;
    public static Block blockFramedHexoriumBlockTurquoise;
    public static Block blockFramedHexoriumBlockCyan;
    public static Block blockFramedHexoriumBlockSkyBlue;
    public static Block blockFramedHexoriumBlockBlue;
    public static Block blockFramedHexoriumBlockPurple;
    public static Block blockFramedHexoriumBlockMagenta;
    public static Block blockFramedHexoriumBlockPink;

    public static Block blockFramedHexoriumBlockWhite;
    public static Block blockFramedHexoriumBlockLightGray;
    public static Block blockFramedHexoriumBlockGray;
    public static Block blockFramedHexoriumBlockDarkGray;
    public static Block blockFramedHexoriumBlockBlack;

    public static Block blockFramedHexoriumBlockRainbow;

    // Energized Hexorium Monolith
    public static Block blockEnergizedHexoriumMonolithRed;
    public static Block blockEnergizedHexoriumMonolithOrange;
    public static Block blockEnergizedHexoriumMonolithYellow;
    public static Block blockEnergizedHexoriumMonolithLime;
    public static Block blockEnergizedHexoriumMonolithGreen;
    public static Block blockEnergizedHexoriumMonolithTurquoise;
    public static Block blockEnergizedHexoriumMonolithCyan;
    public static Block blockEnergizedHexoriumMonolithSkyBlue;
    public static Block blockEnergizedHexoriumMonolithBlue;
    public static Block blockEnergizedHexoriumMonolithPurple;
    public static Block blockEnergizedHexoriumMonolithMagenta;
    public static Block blockEnergizedHexoriumMonolithPink;

    public static Block blockEnergizedHexoriumMonolithWhite;
    public static Block blockEnergizedHexoriumMonolithLightGray;
    public static Block blockEnergizedHexoriumMonolithGray;
    public static Block blockEnergizedHexoriumMonolithDarkGray;
    public static Block blockEnergizedHexoriumMonolithBlack;

    public static Block blockEnergizedHexoriumMonolithRainbow;

    // Hexorium Lamp
    public static Block blockHexoriumLampRed;
    public static Block blockHexoriumLampOrange;
    public static Block blockHexoriumLampYellow;
    public static Block blockHexoriumLampLime;
    public static Block blockHexoriumLampGreen;
    public static Block blockHexoriumLampTurquoise;
    public static Block blockHexoriumLampCyan;
    public static Block blockHexoriumLampSkyBlue;
    public static Block blockHexoriumLampBlue;
    public static Block blockHexoriumLampPurple;
    public static Block blockHexoriumLampMagenta;
    public static Block blockHexoriumLampPink;

    public static Block blockHexoriumLampWhite;
    public static Block blockHexoriumLampLightGray;
    public static Block blockHexoriumLampGray;
    public static Block blockHexoriumLampDarkGray;
    public static Block blockHexoriumLampBlack;

    public static Block blockHexoriumLampRainbow;

    // Inverted Hexorium Lamp
    public static Block blockInvHexoriumLampRed;
    public static Block blockInvHexoriumLampOrange;
    public static Block blockInvHexoriumLampYellow;
    public static Block blockInvHexoriumLampLime;
    public static Block blockInvHexoriumLampGreen;
    public static Block blockInvHexoriumLampTurquoise;
    public static Block blockInvHexoriumLampCyan;
    public static Block blockInvHexoriumLampSkyBlue;
    public static Block blockInvHexoriumLampBlue;
    public static Block blockInvHexoriumLampPurple;
    public static Block blockInvHexoriumLampMagenta;
    public static Block blockInvHexoriumLampPink;

    public static Block blockInvHexoriumLampWhite;
    public static Block blockInvHexoriumLampLightGray;
    public static Block blockInvHexoriumLampGray;
    public static Block blockInvHexoriumLampDarkGray;
    public static Block blockInvHexoriumLampBlack;

    public static Block blockInvHexoriumLampRainbow;

    // Machines
    public static Block blockHexoriumMachineBlock;

    public static Block machineHexoriumGenerator;
    public static Block machineHexoriumFurnace;
    public static Block machineCrystalSeparator;
    public static Block machineMatrixReconstructor;

    // Cables
    public static Block cableHexoriumCableRed;
    public static Block cableHexoriumCableOrange;
    public static Block cableHexoriumCableYellow;
    public static Block cableHexoriumCableLime;
    public static Block cableHexoriumCableGreen;
    public static Block cableHexoriumCableTurquoise;
    public static Block cableHexoriumCableCyan;
    public static Block cableHexoriumCableSkyBlue;
    public static Block cableHexoriumCableBlue;
    public static Block cableHexoriumCablePurple;
    public static Block cableHexoriumCableMagenta;
    public static Block cableHexoriumCablePink;

    public static Block cableHexoriumCableWhite;
    public static Block cableHexoriumCableLightGray;
    public static Block cableHexoriumCableGray;
    public static Block cableHexoriumCableDarkGray;
    public static Block cableHexoriumCableBlack;
    
    public static Block cableHexoriumCableRainbow;

    // Regular Blocks
    public static Block blockTemperedHexoriumGlass;

    /**
     * Initializes all block and adds them to GameRegistry.
     */
    public static void initializeBlocks()
    {
        // Prepare HexCraft's block ID counter.
        HexCraft.idCounter = 0;

        // Hexorium Nether NetherOre
        blockHexoriumNetherOreRed = new BlockHexoriumNetherOre(BlockHexoriumNetherOre.UNLOCALISEDNAME + "Red", 1, 2);
        GameRegistry.registerBlock(blockHexoriumNetherOreRed, BlockHexoriumNetherOre.UNLOCALISEDNAME + "Red");
        blockHexoriumNetherOreGreen = new BlockHexoriumNetherOre(BlockHexoriumNetherOre.UNLOCALISEDNAME + "Green", 1, 2);
        GameRegistry.registerBlock(blockHexoriumNetherOreGreen, BlockHexoriumNetherOre.UNLOCALISEDNAME + "Green");
        blockHexoriumNetherOreBlue = new BlockHexoriumNetherOre(BlockHexoriumNetherOre.UNLOCALISEDNAME + "Blue", 1, 2);
        GameRegistry.registerBlock(blockHexoriumNetherOreBlue, BlockHexoriumNetherOre.UNLOCALISEDNAME + "Blue");
        
        blockHexoriumNetherOreWhite = new BlockHexoriumNetherOre(BlockHexoriumNetherOre.UNLOCALISEDNAME + "White", 2, 4);
        GameRegistry.registerBlock(blockHexoriumNetherOreWhite, BlockHexoriumNetherOre.UNLOCALISEDNAME + "White");
        blockHexoriumNetherOreBlack = new BlockHexoriumNetherOre(BlockHexoriumNetherOre.UNLOCALISEDNAME + "Black", 2, 4);
        GameRegistry.registerBlock(blockHexoriumNetherOreBlack, BlockHexoriumNetherOre.UNLOCALISEDNAME + "Black");

        // Hexorium Ore
        blockHexoriumOreRed = new BlockHexoriumOre(BlockHexoriumOre.UNLOCALISEDNAME + "Red", 2, 4);
        GameRegistry.registerBlock(blockHexoriumOreRed, BlockHexoriumOre.UNLOCALISEDNAME + "Red");
        blockHexoriumOreGreen = new BlockHexoriumOre(BlockHexoriumOre.UNLOCALISEDNAME + "Green", 2, 4);
        GameRegistry.registerBlock(blockHexoriumOreGreen, BlockHexoriumOre.UNLOCALISEDNAME + "Green");
        blockHexoriumOreBlue = new BlockHexoriumOre(BlockHexoriumOre.UNLOCALISEDNAME + "Blue", 2, 4);
        GameRegistry.registerBlock(blockHexoriumOreBlue, BlockHexoriumOre.UNLOCALISEDNAME + "Blue");
        
        blockHexoriumOreWhite = new BlockHexoriumOre(BlockHexoriumOre.UNLOCALISEDNAME + "White", 1, 2);
        GameRegistry.registerBlock(blockHexoriumOreWhite, BlockHexoriumOre.UNLOCALISEDNAME + "White");
        blockHexoriumOreBlack = new BlockHexoriumOre(BlockHexoriumOre.UNLOCALISEDNAME + "Black", 1, 2);
        GameRegistry.registerBlock(blockHexoriumOreBlack, BlockHexoriumOre.UNLOCALISEDNAME + "Black");

        // Hexorium Monolith
        blockHexoriumMonolithRed = new BlockHexoriumMonolith(BlockHexoriumMonolith.UNLOCALISEDNAME + "Red", 6, 8);
        GameRegistry.registerBlock(blockHexoriumMonolithRed, BlockHexoriumMonolith.UNLOCALISEDNAME + "Red");
        blockHexoriumMonolithGreen = new BlockHexoriumMonolith(BlockHexoriumMonolith.UNLOCALISEDNAME + "Green", 6, 8);
        GameRegistry.registerBlock(blockHexoriumMonolithGreen, BlockHexoriumMonolith.UNLOCALISEDNAME + "Green");
        blockHexoriumMonolithBlue = new BlockHexoriumMonolith(BlockHexoriumMonolith.UNLOCALISEDNAME + "Blue", 6, 8);
        GameRegistry.registerBlock(blockHexoriumMonolithBlue, BlockHexoriumMonolith.UNLOCALISEDNAME + "Blue");

        blockHexoriumMonolithWhite = new BlockHexoriumMonolith(BlockHexoriumMonolith.UNLOCALISEDNAME + "White", 2, 4);
        GameRegistry.registerBlock(blockHexoriumMonolithWhite, BlockHexoriumMonolith.UNLOCALISEDNAME + "White");
        blockHexoriumMonolithBlack = new BlockHexoriumMonolith(BlockHexoriumMonolith.UNLOCALISEDNAME + "Black", 2, 4);
        GameRegistry.registerBlock(blockHexoriumMonolithBlack, BlockHexoriumMonolith.UNLOCALISEDNAME + "Black");
        
        // Hexorium Nether Monolith
        blockHexoriumNetherMonolithRed = new BlockHexoriumNetherMonolith(BlockHexoriumNetherMonolith.UNLOCALISEDNAME + "Red", 2, 4);
        GameRegistry.registerBlock(blockHexoriumNetherMonolithRed, BlockHexoriumNetherMonolith.UNLOCALISEDNAME + "Red");
        blockHexoriumNetherMonolithGreen = new BlockHexoriumNetherMonolith(BlockHexoriumNetherMonolith.UNLOCALISEDNAME + "Green", 2, 4);
        GameRegistry.registerBlock(blockHexoriumNetherMonolithGreen, BlockHexoriumNetherMonolith.UNLOCALISEDNAME + "Green");
        blockHexoriumNetherMonolithBlue = new BlockHexoriumNetherMonolith(BlockHexoriumNetherMonolith.UNLOCALISEDNAME + "Blue", 2, 4);
        GameRegistry.registerBlock(blockHexoriumNetherMonolithBlue, BlockHexoriumNetherMonolith.UNLOCALISEDNAME + "Blue");

        blockHexoriumNetherMonolithWhite = new BlockHexoriumNetherMonolith(BlockHexoriumNetherMonolith.UNLOCALISEDNAME + "White", 6, 8);
        GameRegistry.registerBlock(blockHexoriumNetherMonolithWhite, BlockHexoriumNetherMonolith.UNLOCALISEDNAME + "White");
        blockHexoriumNetherMonolithBlack = new BlockHexoriumNetherMonolith(BlockHexoriumNetherMonolith.UNLOCALISEDNAME + "Black", 6, 8);
        GameRegistry.registerBlock(blockHexoriumNetherMonolithBlack, BlockHexoriumNetherMonolith.UNLOCALISEDNAME + "Black");

        // Block of Hexorium Crystal
        blockOfHexoriumCrystalRed = new BlockOfHexoriumCrystal(BlockOfHexoriumCrystal.UNLOCALISEDNAME + "Red");
        GameRegistry.registerBlock(blockOfHexoriumCrystalRed, BlockOfHexoriumCrystal.UNLOCALISEDNAME + "Red");
        blockOfHexoriumCrystalGreen = new BlockOfHexoriumCrystal(BlockOfHexoriumCrystal.UNLOCALISEDNAME + "Green");
        GameRegistry.registerBlock(blockOfHexoriumCrystalGreen, BlockOfHexoriumCrystal.UNLOCALISEDNAME + "Green");
        blockOfHexoriumCrystalBlue = new BlockOfHexoriumCrystal(BlockOfHexoriumCrystal.UNLOCALISEDNAME + "Blue");
        GameRegistry.registerBlock(blockOfHexoriumCrystalBlue, BlockOfHexoriumCrystal.UNLOCALISEDNAME + "Blue");
        
        blockOfHexoriumCrystalWhite = new BlockOfHexoriumCrystal(BlockOfHexoriumCrystal.UNLOCALISEDNAME + "White");
        GameRegistry.registerBlock(blockOfHexoriumCrystalWhite, BlockOfHexoriumCrystal.UNLOCALISEDNAME + "White");
        blockOfHexoriumCrystalBlack = new BlockOfHexoriumCrystal(BlockOfHexoriumCrystal.UNLOCALISEDNAME + "Black");
        GameRegistry.registerBlock(blockOfHexoriumCrystalBlack, BlockOfHexoriumCrystal.UNLOCALISEDNAME + "Black");
        
        // Energized Hexorium
        blockEnergizedHexoriumRed = new BlockEnergizedHexorium(BlockEnergizedHexorium.UNLOCALISEDNAME + "Red");
        GameRegistry.registerBlock(blockEnergizedHexoriumRed, BlockEnergizedHexorium.UNLOCALISEDNAME + "Red");
        blockEnergizedHexoriumOrange = new BlockEnergizedHexorium(BlockEnergizedHexorium.UNLOCALISEDNAME + "Orange");
        GameRegistry.registerBlock(blockEnergizedHexoriumOrange, BlockEnergizedHexorium.UNLOCALISEDNAME + "Orange");
        blockEnergizedHexoriumYellow = new BlockEnergizedHexorium(BlockEnergizedHexorium.UNLOCALISEDNAME + "Yellow");
        GameRegistry.registerBlock(blockEnergizedHexoriumYellow, BlockEnergizedHexorium.UNLOCALISEDNAME + "Yellow");
        blockEnergizedHexoriumLime = new BlockEnergizedHexorium(BlockEnergizedHexorium.UNLOCALISEDNAME + "Lime");
        GameRegistry.registerBlock(blockEnergizedHexoriumLime, BlockEnergizedHexorium.UNLOCALISEDNAME + "Lime");
        blockEnergizedHexoriumGreen = new BlockEnergizedHexorium(BlockEnergizedHexorium.UNLOCALISEDNAME + "Green");
        GameRegistry.registerBlock(blockEnergizedHexoriumGreen, BlockEnergizedHexorium.UNLOCALISEDNAME + "Green");
        blockEnergizedHexoriumTurquoise = new BlockEnergizedHexorium(BlockEnergizedHexorium.UNLOCALISEDNAME + "Turquoise");
        GameRegistry.registerBlock(blockEnergizedHexoriumTurquoise, BlockEnergizedHexorium.UNLOCALISEDNAME + "Turquoise");
        blockEnergizedHexoriumCyan = new BlockEnergizedHexorium(BlockEnergizedHexorium.UNLOCALISEDNAME + "Cyan");
        GameRegistry.registerBlock(blockEnergizedHexoriumCyan, BlockEnergizedHexorium.UNLOCALISEDNAME + "Cyan");
        blockEnergizedHexoriumSkyBlue = new BlockEnergizedHexorium(BlockEnergizedHexorium.UNLOCALISEDNAME + "SkyBlue");
        GameRegistry.registerBlock(blockEnergizedHexoriumSkyBlue, BlockEnergizedHexorium.UNLOCALISEDNAME + "SkyBlue");
        blockEnergizedHexoriumBlue = new BlockEnergizedHexorium(BlockEnergizedHexorium.UNLOCALISEDNAME + "Blue");
        GameRegistry.registerBlock(blockEnergizedHexoriumBlue, BlockEnergizedHexorium.UNLOCALISEDNAME + "Blue");
        blockEnergizedHexoriumPurple = new BlockEnergizedHexorium(BlockEnergizedHexorium.UNLOCALISEDNAME + "Purple");
        GameRegistry.registerBlock(blockEnergizedHexoriumPurple, BlockEnergizedHexorium.UNLOCALISEDNAME + "Purple");
        blockEnergizedHexoriumMagenta = new BlockEnergizedHexorium(BlockEnergizedHexorium.UNLOCALISEDNAME + "Magenta");
        GameRegistry.registerBlock(blockEnergizedHexoriumMagenta, BlockEnergizedHexorium.UNLOCALISEDNAME + "Magenta");
        blockEnergizedHexoriumPink = new BlockEnergizedHexorium(BlockEnergizedHexorium.UNLOCALISEDNAME + "Pink");
        GameRegistry.registerBlock(blockEnergizedHexoriumPink, BlockEnergizedHexorium.UNLOCALISEDNAME + "Pink");
        
        blockEnergizedHexoriumWhite = new BlockEnergizedHexorium(BlockEnergizedHexorium.UNLOCALISEDNAME + "White");
        GameRegistry.registerBlock(blockEnergizedHexoriumWhite, BlockEnergizedHexorium.UNLOCALISEDNAME + "White");
        blockEnergizedHexoriumLightGray = new BlockEnergizedHexorium(BlockEnergizedHexorium.UNLOCALISEDNAME + "LightGray");
        GameRegistry.registerBlock(blockEnergizedHexoriumLightGray, BlockEnergizedHexorium.UNLOCALISEDNAME + "LightGray");
        blockEnergizedHexoriumGray = new BlockEnergizedHexorium(BlockEnergizedHexorium.UNLOCALISEDNAME + "Gray");
        GameRegistry.registerBlock(blockEnergizedHexoriumGray, BlockEnergizedHexorium.UNLOCALISEDNAME + "Gray");
        blockEnergizedHexoriumDarkGray = new BlockEnergizedHexorium(BlockEnergizedHexorium.UNLOCALISEDNAME + "DarkGray");
        GameRegistry.registerBlock(blockEnergizedHexoriumDarkGray, BlockEnergizedHexorium.UNLOCALISEDNAME + "DarkGray");
        blockEnergizedHexoriumBlack = new BlockEnergizedHexorium(BlockEnergizedHexorium.UNLOCALISEDNAME + "Black");
        GameRegistry.registerBlock(blockEnergizedHexoriumBlack, BlockEnergizedHexorium.UNLOCALISEDNAME + "Black");
        
        blockEnergizedHexoriumRainbow = new BlockEnergizedHexorium(BlockEnergizedHexorium.UNLOCALISEDNAME + "Rainbow");
        GameRegistry.registerBlock(blockEnergizedHexoriumRainbow, BlockEnergizedHexorium.UNLOCALISEDNAME + "Rainbow");

        // Engineered Hexorium Block
        blockEngineeredHexoriumBlockRed = new BlockEngineeredHexoriumBlock(BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Red");
        GameRegistry.registerBlock(blockEngineeredHexoriumBlockRed, BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Red");
        blockEngineeredHexoriumBlockOrange = new BlockEngineeredHexoriumBlock(BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Orange");
        GameRegistry.registerBlock(blockEngineeredHexoriumBlockOrange, BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Orange");
        blockEngineeredHexoriumBlockYellow = new BlockEngineeredHexoriumBlock(BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Yellow");
        GameRegistry.registerBlock(blockEngineeredHexoriumBlockYellow, BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Yellow");
        blockEngineeredHexoriumBlockLime = new BlockEngineeredHexoriumBlock(BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Lime");
        GameRegistry.registerBlock(blockEngineeredHexoriumBlockLime, BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Lime");
        blockEngineeredHexoriumBlockGreen = new BlockEngineeredHexoriumBlock(BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Green");
        GameRegistry.registerBlock(blockEngineeredHexoriumBlockGreen, BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Green");
        blockEngineeredHexoriumBlockTurquoise = new BlockEngineeredHexoriumBlock(BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Turquoise");
        GameRegistry.registerBlock(blockEngineeredHexoriumBlockTurquoise, BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Turquoise");
        blockEngineeredHexoriumBlockCyan = new BlockEngineeredHexoriumBlock(BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Cyan");
        GameRegistry.registerBlock(blockEngineeredHexoriumBlockCyan, BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Cyan");
        blockEngineeredHexoriumBlockSkyBlue = new BlockEngineeredHexoriumBlock(BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "SkyBlue");
        GameRegistry.registerBlock(blockEngineeredHexoriumBlockSkyBlue, BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "SkyBlue");
        blockEngineeredHexoriumBlockBlue = new BlockEngineeredHexoriumBlock(BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Blue");
        GameRegistry.registerBlock(blockEngineeredHexoriumBlockBlue, BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Blue");
        blockEngineeredHexoriumBlockPurple = new BlockEngineeredHexoriumBlock(BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Purple");
        GameRegistry.registerBlock(blockEngineeredHexoriumBlockPurple, BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Purple");
        blockEngineeredHexoriumBlockMagenta = new BlockEngineeredHexoriumBlock(BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Magenta");
        GameRegistry.registerBlock(blockEngineeredHexoriumBlockMagenta, BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Magenta");
        blockEngineeredHexoriumBlockPink = new BlockEngineeredHexoriumBlock(BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Pink");
        GameRegistry.registerBlock(blockEngineeredHexoriumBlockPink, BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Pink");
        
        blockEngineeredHexoriumBlockWhite = new BlockEngineeredHexoriumBlock(BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "White");
        GameRegistry.registerBlock(blockEngineeredHexoriumBlockWhite, BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "White");
        blockEngineeredHexoriumBlockLightGray = new BlockEngineeredHexoriumBlock(BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "LightGray");
        GameRegistry.registerBlock(blockEngineeredHexoriumBlockLightGray, BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "LightGray");
        blockEngineeredHexoriumBlockGray = new BlockEngineeredHexoriumBlock(BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Gray");
        GameRegistry.registerBlock(blockEngineeredHexoriumBlockGray, BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Gray");
        blockEngineeredHexoriumBlockDarkGray = new BlockEngineeredHexoriumBlock(BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "DarkGray");
        GameRegistry.registerBlock(blockEngineeredHexoriumBlockDarkGray, BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "DarkGray");
        blockEngineeredHexoriumBlockBlack = new BlockEngineeredHexoriumBlock(BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Black");
        GameRegistry.registerBlock(blockEngineeredHexoriumBlockBlack, BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Black");

        blockEngineeredHexoriumBlockRainbow = new BlockEngineeredHexoriumBlock(BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Rainbow");
        GameRegistry.registerBlock(blockEngineeredHexoriumBlockRainbow, BlockEngineeredHexoriumBlock.UNLOCALISEDNAME + "Rainbow");

        // Framed Hexorium Block
        blockFramedHexoriumBlockRed = new BlockFramedHexoriumBlock(BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Red");
        GameRegistry.registerBlock(blockFramedHexoriumBlockRed, BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Red");
        blockFramedHexoriumBlockOrange = new BlockFramedHexoriumBlock(BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Orange");
        GameRegistry.registerBlock(blockFramedHexoriumBlockOrange, BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Orange");
        blockFramedHexoriumBlockYellow = new BlockFramedHexoriumBlock(BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Yellow");
        GameRegistry.registerBlock(blockFramedHexoriumBlockYellow, BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Yellow");
        blockFramedHexoriumBlockLime = new BlockFramedHexoriumBlock(BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Lime");
        GameRegistry.registerBlock(blockFramedHexoriumBlockLime, BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Lime");
        blockFramedHexoriumBlockGreen = new BlockFramedHexoriumBlock(BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Green");
        GameRegistry.registerBlock(blockFramedHexoriumBlockGreen, BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Green");
        blockFramedHexoriumBlockTurquoise = new BlockFramedHexoriumBlock(BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Turquoise");
        GameRegistry.registerBlock(blockFramedHexoriumBlockTurquoise, BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Turquoise");
        blockFramedHexoriumBlockCyan = new BlockFramedHexoriumBlock(BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Cyan");
        GameRegistry.registerBlock(blockFramedHexoriumBlockCyan, BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Cyan");
        blockFramedHexoriumBlockSkyBlue = new BlockFramedHexoriumBlock(BlockFramedHexoriumBlock.UNLOCALISEDNAME + "SkyBlue");
        GameRegistry.registerBlock(blockFramedHexoriumBlockSkyBlue, BlockFramedHexoriumBlock.UNLOCALISEDNAME + "SkyBlue");
        blockFramedHexoriumBlockBlue = new BlockFramedHexoriumBlock(BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Blue");
        GameRegistry.registerBlock(blockFramedHexoriumBlockBlue, BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Blue");
        blockFramedHexoriumBlockPurple = new BlockFramedHexoriumBlock(BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Purple");
        GameRegistry.registerBlock(blockFramedHexoriumBlockPurple, BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Purple");
        blockFramedHexoriumBlockMagenta = new BlockFramedHexoriumBlock(BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Magenta");
        GameRegistry.registerBlock(blockFramedHexoriumBlockMagenta, BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Magenta");
        blockFramedHexoriumBlockPink = new BlockFramedHexoriumBlock(BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Pink");
        GameRegistry.registerBlock(blockFramedHexoriumBlockPink, BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Pink");

        blockFramedHexoriumBlockWhite = new BlockFramedHexoriumBlock(BlockFramedHexoriumBlock.UNLOCALISEDNAME + "White");
        GameRegistry.registerBlock(blockFramedHexoriumBlockWhite, BlockFramedHexoriumBlock.UNLOCALISEDNAME + "White");
        blockFramedHexoriumBlockLightGray = new BlockFramedHexoriumBlock(BlockFramedHexoriumBlock.UNLOCALISEDNAME + "LightGray");
        GameRegistry.registerBlock(blockFramedHexoriumBlockLightGray, BlockFramedHexoriumBlock.UNLOCALISEDNAME + "LightGray");
        blockFramedHexoriumBlockGray = new BlockFramedHexoriumBlock(BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Gray");
        GameRegistry.registerBlock(blockFramedHexoriumBlockGray, BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Gray");
        blockFramedHexoriumBlockDarkGray = new BlockFramedHexoriumBlock(BlockFramedHexoriumBlock.UNLOCALISEDNAME + "DarkGray");
        GameRegistry.registerBlock(blockFramedHexoriumBlockDarkGray, BlockFramedHexoriumBlock.UNLOCALISEDNAME + "DarkGray");
        blockFramedHexoriumBlockBlack = new BlockFramedHexoriumBlock(BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Black");
        GameRegistry.registerBlock(blockFramedHexoriumBlockBlack, BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Black");

        blockFramedHexoriumBlockRainbow = new BlockFramedHexoriumBlock(BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Rainbow");
        GameRegistry.registerBlock(blockFramedHexoriumBlockRainbow, BlockFramedHexoriumBlock.UNLOCALISEDNAME + "Rainbow");
        
        // Energized Hexorium Monolith
        blockEnergizedHexoriumMonolithRed = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Red");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithRed, BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Red");
        blockEnergizedHexoriumMonolithOrange = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Orange");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithOrange, BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Orange");
        blockEnergizedHexoriumMonolithYellow = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Yellow");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithYellow, BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Yellow");
        blockEnergizedHexoriumMonolithLime = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Lime");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithLime, BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Lime");
        blockEnergizedHexoriumMonolithGreen = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Green");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithGreen, BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Green");
        blockEnergizedHexoriumMonolithTurquoise = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Turquoise");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithTurquoise, BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Turquoise");
        blockEnergizedHexoriumMonolithCyan = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Cyan");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithCyan, BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Cyan");
        blockEnergizedHexoriumMonolithSkyBlue = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "SkyBlue");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithSkyBlue, BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "SkyBlue");
        blockEnergizedHexoriumMonolithBlue = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Blue");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithBlue, BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Blue");
        blockEnergizedHexoriumMonolithPurple = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Purple");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithPurple, BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Purple");
        blockEnergizedHexoriumMonolithMagenta = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Magenta");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithMagenta, BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Magenta");
        blockEnergizedHexoriumMonolithPink = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Pink");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithPink, BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Pink");

        blockEnergizedHexoriumMonolithWhite = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "White");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithWhite, BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "White");
        blockEnergizedHexoriumMonolithLightGray = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "LightGray");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithLightGray, BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "LightGray");
        blockEnergizedHexoriumMonolithGray = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Gray");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithGray, BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Gray");
        blockEnergizedHexoriumMonolithDarkGray = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "DarkGray");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithDarkGray, BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "DarkGray");
        blockEnergizedHexoriumMonolithBlack = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Black");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithBlack, BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Black");

        blockEnergizedHexoriumMonolithRainbow = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Rainbow");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithRainbow, BlockEnergizedHexoriumMonolith.UNLOCALISEDNAME + "Rainbow");

        // Hexorium Lamp
        blockHexoriumLampRed = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Red", false);
        GameRegistry.registerBlock(blockHexoriumLampRed, BlockHexoriumLamp.UNLOCALISEDNAME + "Red");
        blockHexoriumLampOrange = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Orange", false);
        GameRegistry.registerBlock(blockHexoriumLampOrange, BlockHexoriumLamp.UNLOCALISEDNAME + "Orange");
        blockHexoriumLampYellow = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Yellow", false);
        GameRegistry.registerBlock(blockHexoriumLampYellow, BlockHexoriumLamp.UNLOCALISEDNAME + "Yellow");
        blockHexoriumLampLime = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Lime", false);
        GameRegistry.registerBlock(blockHexoriumLampLime, BlockHexoriumLamp.UNLOCALISEDNAME + "Lime");
        blockHexoriumLampGreen = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Green", false);
        GameRegistry.registerBlock(blockHexoriumLampGreen, BlockHexoriumLamp.UNLOCALISEDNAME + "Green");
        blockHexoriumLampTurquoise = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Turquoise", false);
        GameRegistry.registerBlock(blockHexoriumLampTurquoise, BlockHexoriumLamp.UNLOCALISEDNAME + "Turquoise");
        blockHexoriumLampCyan = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Cyan", false);
        GameRegistry.registerBlock(blockHexoriumLampCyan, BlockHexoriumLamp.UNLOCALISEDNAME + "Cyan");
        blockHexoriumLampSkyBlue = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "SkyBlue", false);
        GameRegistry.registerBlock(blockHexoriumLampSkyBlue, BlockHexoriumLamp.UNLOCALISEDNAME + "SkyBlue");
        blockHexoriumLampBlue = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Blue", false);
        GameRegistry.registerBlock(blockHexoriumLampBlue, BlockHexoriumLamp.UNLOCALISEDNAME + "Blue");
        blockHexoriumLampPurple = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Purple", false);
        GameRegistry.registerBlock(blockHexoriumLampPurple, BlockHexoriumLamp.UNLOCALISEDNAME + "Purple");
        blockHexoriumLampMagenta = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Magenta", false);
        GameRegistry.registerBlock(blockHexoriumLampMagenta, BlockHexoriumLamp.UNLOCALISEDNAME + "Magenta");
        blockHexoriumLampPink = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Pink", false);
        GameRegistry.registerBlock(blockHexoriumLampPink, BlockHexoriumLamp.UNLOCALISEDNAME + "Pink");

        blockHexoriumLampWhite = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "White", false);
        GameRegistry.registerBlock(blockHexoriumLampWhite, BlockHexoriumLamp.UNLOCALISEDNAME + "White");
        blockHexoriumLampLightGray = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "LightGray", false);
        GameRegistry.registerBlock(blockHexoriumLampLightGray, BlockHexoriumLamp.UNLOCALISEDNAME + "LightGray");
        blockHexoriumLampGray = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Gray", false);
        GameRegistry.registerBlock(blockHexoriumLampGray, BlockHexoriumLamp.UNLOCALISEDNAME + "Gray");
        blockHexoriumLampDarkGray = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "DarkGray", false);
        GameRegistry.registerBlock(blockHexoriumLampDarkGray, BlockHexoriumLamp.UNLOCALISEDNAME + "DarkGray");
        blockHexoriumLampBlack = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Black", false);
        GameRegistry.registerBlock(blockHexoriumLampBlack, BlockHexoriumLamp.UNLOCALISEDNAME + "Black");

        blockHexoriumLampRainbow = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Rainbow", false);
        GameRegistry.registerBlock(blockHexoriumLampRainbow, BlockHexoriumLamp.UNLOCALISEDNAME + "Rainbow");

        // Inverted Hexorium Lamp
        blockInvHexoriumLampRed = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Red", true);
        GameRegistry.registerBlock(blockInvHexoriumLampRed, BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Red");
        blockInvHexoriumLampOrange = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Orange", true);
        GameRegistry.registerBlock(blockInvHexoriumLampOrange, BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Orange");
        blockInvHexoriumLampYellow = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Yellow", true);
        GameRegistry.registerBlock(blockInvHexoriumLampYellow, BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Yellow");
        blockInvHexoriumLampLime = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Lime", true);
        GameRegistry.registerBlock(blockInvHexoriumLampLime, BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Lime");
        blockInvHexoriumLampGreen = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Green", true);
        GameRegistry.registerBlock(blockInvHexoriumLampGreen, BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Green");
        blockInvHexoriumLampTurquoise = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Turquoise", true);
        GameRegistry.registerBlock(blockInvHexoriumLampTurquoise, BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Turquoise");
        blockInvHexoriumLampCyan = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Cyan", true);
        GameRegistry.registerBlock(blockInvHexoriumLampCyan, BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Cyan");
        blockInvHexoriumLampSkyBlue = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAMEINV + "SkyBlue", true);
        GameRegistry.registerBlock(blockInvHexoriumLampSkyBlue, BlockHexoriumLamp.UNLOCALISEDNAMEINV + "SkyBlue");
        blockInvHexoriumLampBlue = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Blue", true);
        GameRegistry.registerBlock(blockInvHexoriumLampBlue, BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Blue");
        blockInvHexoriumLampPurple = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Purple", true);
        GameRegistry.registerBlock(blockInvHexoriumLampPurple, BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Purple");
        blockInvHexoriumLampMagenta = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Magenta", true);
        GameRegistry.registerBlock(blockInvHexoriumLampMagenta, BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Magenta");
        blockInvHexoriumLampPink = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Pink", true);
        GameRegistry.registerBlock(blockInvHexoriumLampPink, BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Pink");

        blockInvHexoriumLampWhite = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAMEINV + "White", true);
        GameRegistry.registerBlock(blockInvHexoriumLampWhite, BlockHexoriumLamp.UNLOCALISEDNAMEINV + "White");
        blockInvHexoriumLampLightGray = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAMEINV + "LightGray", true);
        GameRegistry.registerBlock(blockInvHexoriumLampLightGray, BlockHexoriumLamp.UNLOCALISEDNAMEINV + "LightGray");
        blockInvHexoriumLampGray = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Gray", true);
        GameRegistry.registerBlock(blockInvHexoriumLampGray, BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Gray");
        blockInvHexoriumLampDarkGray = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAMEINV + "DarkGray", true);
        GameRegistry.registerBlock(blockInvHexoriumLampDarkGray, BlockHexoriumLamp.UNLOCALISEDNAMEINV + "DarkGray");
        blockInvHexoriumLampBlack = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Black", true);
        GameRegistry.registerBlock(blockInvHexoriumLampBlack, BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Black");

        blockInvHexoriumLampRainbow = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Rainbow", true);
        GameRegistry.registerBlock(blockInvHexoriumLampRainbow, BlockHexoriumLamp.UNLOCALISEDNAMEINV + "Rainbow");


        // Machines
        blockHexoriumMachineBlock = new BlockHexoriumMachineBlock(BlockHexoriumMachineBlock.UNLOCALISEDNAME);
        GameRegistry.registerBlock(blockHexoriumMachineBlock, BlockHexoriumMachineBlock.UNLOCALISEDNAME);

        machineHexoriumGenerator = new MachineHexoriumGenerator(MachineHexoriumGenerator.UNLOCALISEDNAME);
        GameRegistry.registerBlock(machineHexoriumGenerator, MachineHexoriumGenerator.UNLOCALISEDNAME);
        machineHexoriumFurnace = new MachineHexoriumFurnace(MachineHexoriumFurnace.UNLOCALISEDNAME);
        GameRegistry.registerBlock(machineHexoriumFurnace, MachineHexoriumFurnace.UNLOCALISEDNAME);
        machineCrystalSeparator = new MachineCrystalSeparator(MachineCrystalSeparator.UNLOCALISEDNAME);
        GameRegistry.registerBlock(machineCrystalSeparator, MachineCrystalSeparator.UNLOCALISEDNAME);
        machineMatrixReconstructor = new MachineMatrixReconstructor(MachineMatrixReconstructor.UNLOCALISEDNAME);
        GameRegistry.registerBlock(machineMatrixReconstructor, MachineMatrixReconstructor.UNLOCALISEDNAME);

        // Cables
        cableHexoriumCableRed = new CableHexoriumCable(CableHexoriumCable.UNLOCALISEDNAME + "Red");
        GameRegistry.registerBlock(cableHexoriumCableRed, CableHexoriumCable.UNLOCALISEDNAME + "Red");
        cableHexoriumCableOrange = new CableHexoriumCable(CableHexoriumCable.UNLOCALISEDNAME + "Orange");
        GameRegistry.registerBlock(cableHexoriumCableOrange, CableHexoriumCable.UNLOCALISEDNAME + "Orange");
        cableHexoriumCableYellow = new CableHexoriumCable(CableHexoriumCable.UNLOCALISEDNAME + "Yellow");
        GameRegistry.registerBlock(cableHexoriumCableYellow, CableHexoriumCable.UNLOCALISEDNAME + "Yellow");
        cableHexoriumCableLime = new CableHexoriumCable(CableHexoriumCable.UNLOCALISEDNAME + "Lime");
        GameRegistry.registerBlock(cableHexoriumCableLime, CableHexoriumCable.UNLOCALISEDNAME + "Lime");
        cableHexoriumCableGreen = new CableHexoriumCable(CableHexoriumCable.UNLOCALISEDNAME + "Green");
        GameRegistry.registerBlock(cableHexoriumCableGreen, CableHexoriumCable.UNLOCALISEDNAME + "Green");
        cableHexoriumCableTurquoise = new CableHexoriumCable(CableHexoriumCable.UNLOCALISEDNAME + "Turquoise");
        GameRegistry.registerBlock(cableHexoriumCableTurquoise, CableHexoriumCable.UNLOCALISEDNAME + "Turquoise");
        cableHexoriumCableCyan = new CableHexoriumCable(CableHexoriumCable.UNLOCALISEDNAME + "Cyan");
        GameRegistry.registerBlock(cableHexoriumCableCyan, CableHexoriumCable.UNLOCALISEDNAME + "Cyan");
        cableHexoriumCableSkyBlue = new CableHexoriumCable(CableHexoriumCable.UNLOCALISEDNAME + "SkyBlue");
        GameRegistry.registerBlock(cableHexoriumCableSkyBlue, CableHexoriumCable.UNLOCALISEDNAME + "SkyBlue");
        cableHexoriumCableBlue = new CableHexoriumCable(CableHexoriumCable.UNLOCALISEDNAME + "Blue");
        GameRegistry.registerBlock(cableHexoriumCableBlue, CableHexoriumCable.UNLOCALISEDNAME + "Blue");
        cableHexoriumCablePurple = new CableHexoriumCable(CableHexoriumCable.UNLOCALISEDNAME + "Purple");
        GameRegistry.registerBlock(cableHexoriumCablePurple, CableHexoriumCable.UNLOCALISEDNAME + "Purple");
        cableHexoriumCableMagenta = new CableHexoriumCable(CableHexoriumCable.UNLOCALISEDNAME + "Magenta");
        GameRegistry.registerBlock(cableHexoriumCableMagenta, CableHexoriumCable.UNLOCALISEDNAME + "Magenta");
        cableHexoriumCablePink = new CableHexoriumCable(CableHexoriumCable.UNLOCALISEDNAME + "Pink");
        GameRegistry.registerBlock(cableHexoriumCablePink, CableHexoriumCable.UNLOCALISEDNAME + "Pink");
        
        cableHexoriumCableWhite = new CableHexoriumCable(CableHexoriumCable.UNLOCALISEDNAME + "White");
        GameRegistry.registerBlock(cableHexoriumCableWhite, CableHexoriumCable.UNLOCALISEDNAME + "White");
        cableHexoriumCableLightGray = new CableHexoriumCable(CableHexoriumCable.UNLOCALISEDNAME + "LightGray");
        GameRegistry.registerBlock(cableHexoriumCableLightGray, CableHexoriumCable.UNLOCALISEDNAME + "LightGray");
        cableHexoriumCableGray = new CableHexoriumCable(CableHexoriumCable.UNLOCALISEDNAME + "Gray");
        GameRegistry.registerBlock(cableHexoriumCableGray, CableHexoriumCable.UNLOCALISEDNAME + "Gray");
        cableHexoriumCableDarkGray = new CableHexoriumCable(CableHexoriumCable.UNLOCALISEDNAME + "DarkGray");
        GameRegistry.registerBlock(cableHexoriumCableDarkGray, CableHexoriumCable.UNLOCALISEDNAME + "DarkGray");
        cableHexoriumCableBlack = new CableHexoriumCable(CableHexoriumCable.UNLOCALISEDNAME + "Black");
        GameRegistry.registerBlock(cableHexoriumCableBlack, CableHexoriumCable.UNLOCALISEDNAME + "Black");

        cableHexoriumCableRainbow = new CableHexoriumCable(CableHexoriumCable.UNLOCALISEDNAME + "Rainbow");
        GameRegistry.registerBlock(cableHexoriumCableRainbow, CableHexoriumCable.UNLOCALISEDNAME + "Rainbow");

        // Regular Blocks
        blockTemperedHexoriumGlass = new BlockTemperedHexoriumGlass(BlockTemperedHexoriumGlass.UNLOCALISEDNAME);
        GameRegistry.registerBlock(blockTemperedHexoriumGlass, BlockTemperedHexoriumGlass.UNLOCALISEDNAME);
    }
}
