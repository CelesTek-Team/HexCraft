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

    public static int countBlocks = 82;

    /* Hexorium Nether Ore */
    public static Block blockHexoriumNetherOreRed;
    public static Block blockHexoriumNetherOreGreen;
    public static Block blockHexoriumNetherOreBlue;
    
    public static Block blockHexoriumNetherOreWhite;
    public static Block blockHexoriumNetherOreBlack;

    /* Hexorium Ore */
    public static Block blockHexoriumOreRed;
    public static Block blockHexoriumOreGreen;
    public static Block blockHexoriumOreBlue;
    
    public static Block blockHexoriumOreWhite;
    public static Block blockHexoriumOreBlack;

    /* Energized Hexorium */
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

    /* Engineered Hexorium Block */
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

    /* Framed Hexorium Block */
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

    /* Recombined Hexorium Monolith */
    public static Block blockRecombinedHexoriumMonolithRed;
    public static Block blockRecombinedHexoriumMonolithOrange;
    public static Block blockRecombinedHexoriumMonolithYellow;
    public static Block blockRecombinedHexoriumMonolithLime;
    public static Block blockRecombinedHexoriumMonolithGreen;
    public static Block blockRecombinedHexoriumMonolithTurquoise;
    public static Block blockRecombinedHexoriumMonolithCyan;
    public static Block blockRecombinedHexoriumMonolithSkyBlue;
    public static Block blockRecombinedHexoriumMonolithBlue;
    public static Block blockRecombinedHexoriumMonolithPurple;
    public static Block blockRecombinedHexoriumMonolithMagenta;
    public static Block blockRecombinedHexoriumMonolithPink;

    public static Block blockRecombinedHexoriumMonolithWhite;
    public static Block blockRecombinedHexoriumMonolithLightGray;
    public static Block blockRecombinedHexoriumMonolithGray;
    public static Block blockRecombinedHexoriumMonolithDarkGray;
    public static Block blockRecombinedHexoriumMonolithBlack;

    public static Block blockRecombinedHexoriumMonolithRainbow;

    /**
     * Initializes all block and adds them to GameRegistry.
     */
    public static void initializeBlocks()
    {
        /* Prepare HexCraft's block ID counter. */
        HexCraft.idCounter = 0;

        /* Hexorium Nether NetherOre */
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

        /* Hexorium Ore */
        blockHexoriumOreRed = new BlockHexoriumOre(BlockHexoriumOre.UNLOCALISEDNAME + "Red", 2, 4);
        GameRegistry.registerBlock(blockHexoriumOreRed, BlockHexoriumOre.UNLOCALISEDNAME + "Red");
        blockHexoriumOreGreen = new BlockHexoriumOre(BlockHexoriumOre.UNLOCALISEDNAME + "Green", 2, 4);
        GameRegistry.registerBlock(blockHexoriumOreGreen, BlockHexoriumOre.UNLOCALISEDNAME + "Green");
        blockHexoriumOreBlue = new BlockHexoriumOre(BlockHexoriumOre.UNLOCALISEDNAME + "Blue", 2, 4);
        GameRegistry.registerBlock(blockHexoriumOreBlue, BlockHexoriumOre.UNLOCALISEDNAME + "Blue");
        blockHexoriumOreWhite = new BlockHexoriumOre(BlockHexoriumOre.UNLOCALISEDNAME + "White", 1, 2);
        GameRegistry.registerBlock(blockHexoriumOreWhite, BlockHexoriumOre.UNLOCALISEDNAME + "White");
        blockHexoriumOreBlack = new BlockHexoriumOre(BlockHexoriumOre.UNLOCALISEDNAME + "Black", 1, 1);
        GameRegistry.registerBlock(blockHexoriumOreBlack, BlockHexoriumOre.UNLOCALISEDNAME + "Black");

        /* Energized Hexorium */
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

        /* Engineered Hexorium Block */
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

        /* Framed Hexorium Block */
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
        
        /* Recombined Hexorium Monolith */
        blockRecombinedHexoriumMonolithRed = new BlockRecombinedHexoriumMonolith(BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Red");
        GameRegistry.registerBlock(blockRecombinedHexoriumMonolithRed, BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Red");
        blockRecombinedHexoriumMonolithOrange = new BlockRecombinedHexoriumMonolith(BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Orange");
        GameRegistry.registerBlock(blockRecombinedHexoriumMonolithOrange, BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Orange");
        blockRecombinedHexoriumMonolithYellow = new BlockRecombinedHexoriumMonolith(BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Yellow");
        GameRegistry.registerBlock(blockRecombinedHexoriumMonolithYellow, BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Yellow");
        blockRecombinedHexoriumMonolithLime = new BlockRecombinedHexoriumMonolith(BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Lime");
        GameRegistry.registerBlock(blockRecombinedHexoriumMonolithLime, BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Lime");
        blockRecombinedHexoriumMonolithGreen = new BlockRecombinedHexoriumMonolith(BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Green");
        GameRegistry.registerBlock(blockRecombinedHexoriumMonolithGreen, BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Green");
        blockRecombinedHexoriumMonolithTurquoise = new BlockRecombinedHexoriumMonolith(BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Turquoise");
        GameRegistry.registerBlock(blockRecombinedHexoriumMonolithTurquoise, BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Turquoise");
        blockRecombinedHexoriumMonolithCyan = new BlockRecombinedHexoriumMonolith(BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Cyan");
        GameRegistry.registerBlock(blockRecombinedHexoriumMonolithCyan, BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Cyan");
        blockRecombinedHexoriumMonolithSkyBlue = new BlockRecombinedHexoriumMonolith(BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "SkyBlue");
        GameRegistry.registerBlock(blockRecombinedHexoriumMonolithSkyBlue, BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "SkyBlue");
        blockRecombinedHexoriumMonolithBlue = new BlockRecombinedHexoriumMonolith(BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Blue");
        GameRegistry.registerBlock(blockRecombinedHexoriumMonolithBlue, BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Blue");
        blockRecombinedHexoriumMonolithPurple = new BlockRecombinedHexoriumMonolith(BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Purple");
        GameRegistry.registerBlock(blockRecombinedHexoriumMonolithPurple, BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Purple");
        blockRecombinedHexoriumMonolithMagenta = new BlockRecombinedHexoriumMonolith(BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Magenta");
        GameRegistry.registerBlock(blockRecombinedHexoriumMonolithMagenta, BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Magenta");
        blockRecombinedHexoriumMonolithPink = new BlockRecombinedHexoriumMonolith(BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Pink");
        GameRegistry.registerBlock(blockRecombinedHexoriumMonolithPink, BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Pink");

        blockRecombinedHexoriumMonolithWhite = new BlockRecombinedHexoriumMonolith(BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "White");
        GameRegistry.registerBlock(blockRecombinedHexoriumMonolithWhite, BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "White");
        blockRecombinedHexoriumMonolithLightGray = new BlockRecombinedHexoriumMonolith(BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "LightGray");
        GameRegistry.registerBlock(blockRecombinedHexoriumMonolithLightGray, BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "LightGray");
        blockRecombinedHexoriumMonolithGray = new BlockRecombinedHexoriumMonolith(BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Gray");
        GameRegistry.registerBlock(blockRecombinedHexoriumMonolithGray, BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Gray");
        blockRecombinedHexoriumMonolithDarkGray = new BlockRecombinedHexoriumMonolith(BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "DarkGray");
        GameRegistry.registerBlock(blockRecombinedHexoriumMonolithDarkGray, BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "DarkGray");
        blockRecombinedHexoriumMonolithBlack = new BlockRecombinedHexoriumMonolith(BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Black");
        GameRegistry.registerBlock(blockRecombinedHexoriumMonolithBlack, BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Black");

        blockRecombinedHexoriumMonolithRainbow = new BlockRecombinedHexoriumMonolith(BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Rainbow");
        GameRegistry.registerBlock(blockRecombinedHexoriumMonolithRainbow, BlockRecombinedHexoriumMonolith.UNLOCALISEDNAME + "Rainbow");
    }
}
