package com.celestek.hexcraft.init;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.BlockEnergizedHexorium;
import com.celestek.hexcraft.block.BlockEngineeringBlock;
import com.celestek.hexcraft.block.BlockHexoriumNetherOre;
import com.celestek.hexcraft.block.BlockHexoriumOre;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

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
     * 4) Add an else if statement to getBlock(String unlocalisedName).
     * 5) Add the 2 required lines to HexClientProxy.setCustomRenderers() (Check other blocks).
     */

    public static int countBlocks = 30;

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

    /* Engineering Block */
    public static Block blockEngineeringBlockWhite;
    public static Block blockEngineeringBlockPurple;

    /**
     * Initializes all block and adds them to GameRegistry.
     */
    public static void initializeBlocks()
    {
        /* Prepare HexCraft's block ID counter. */
        HexCraft.idCounter = 0;

        /* Hexorium Nether NetherOre */
        blockHexoriumNetherOreRed = new BlockHexoriumNetherOre(BlockHexoriumNetherOre.UNLOCALISEDNAME + "Red");
        GameRegistry.registerBlock(blockHexoriumNetherOreRed, BlockHexoriumNetherOre.UNLOCALISEDNAME + "Red");
        blockHexoriumNetherOreGreen = new BlockHexoriumNetherOre(BlockHexoriumNetherOre.UNLOCALISEDNAME + "Green");
        GameRegistry.registerBlock(blockHexoriumNetherOreGreen, BlockHexoriumNetherOre.UNLOCALISEDNAME + "Green");
        blockHexoriumNetherOreBlue = new BlockHexoriumNetherOre(BlockHexoriumNetherOre.UNLOCALISEDNAME + "Blue");
        GameRegistry.registerBlock(blockHexoriumNetherOreBlue, BlockHexoriumNetherOre.UNLOCALISEDNAME + "Blue");
        blockHexoriumNetherOreWhite = new BlockHexoriumNetherOre(BlockHexoriumNetherOre.UNLOCALISEDNAME + "White");
        GameRegistry.registerBlock(blockHexoriumNetherOreWhite, BlockHexoriumNetherOre.UNLOCALISEDNAME + "White");
        blockHexoriumNetherOreBlack = new BlockHexoriumNetherOre(BlockHexoriumNetherOre.UNLOCALISEDNAME + "Black");
        GameRegistry.registerBlock(blockHexoriumNetherOreBlack, BlockHexoriumNetherOre.UNLOCALISEDNAME + "Black");

        /* Hexorium Ore */
        blockHexoriumOreRed = new BlockHexoriumOre(BlockHexoriumOre.UNLOCALISEDNAME + "Red");
        GameRegistry.registerBlock(blockHexoriumOreRed, BlockHexoriumOre.UNLOCALISEDNAME + "Red");
        blockHexoriumOreGreen = new BlockHexoriumOre(BlockHexoriumOre.UNLOCALISEDNAME + "Green");
        GameRegistry.registerBlock(blockHexoriumOreGreen, BlockHexoriumOre.UNLOCALISEDNAME + "Green");
        blockHexoriumOreBlue = new BlockHexoriumOre(BlockHexoriumOre.UNLOCALISEDNAME + "Blue");
        GameRegistry.registerBlock(blockHexoriumOreBlue, BlockHexoriumOre.UNLOCALISEDNAME + "Blue");
        blockHexoriumOreWhite = new BlockHexoriumOre(BlockHexoriumOre.UNLOCALISEDNAME + "White");
        GameRegistry.registerBlock(blockHexoriumOreWhite, BlockHexoriumOre.UNLOCALISEDNAME + "White");
        blockHexoriumOreBlack = new BlockHexoriumOre(BlockHexoriumOre.UNLOCALISEDNAME + "Black");
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

        /* Engineering Block */
        blockEngineeringBlockWhite = new BlockEngineeringBlock(BlockEngineeringBlock.UNLOCALISEDNAME + "White");
        GameRegistry.registerBlock(blockEngineeringBlockWhite, BlockEngineeringBlock.UNLOCALISEDNAME + "White");
        blockEngineeringBlockPurple = new BlockEngineeringBlock(BlockEngineeringBlock.UNLOCALISEDNAME + "Purple");
        GameRegistry.registerBlock(blockEngineeringBlockPurple, BlockEngineeringBlock.UNLOCALISEDNAME + "Purple");
    }

    /**
     * Returns the Block object based on unlocalized name.
     * @param unlocalisedName Unlocalized name of the block to retrieve.
     * @return Block object for use by the caller.
     */
    public static Block getBlock(String unlocalisedName)
    {
        /* Hexorium Nether Ore */
        if (unlocalisedName.equals(BlockHexoriumNetherOre.UNLOCALISEDNAME + "Red"))
            return blockHexoriumNetherOreRed;
        else if (unlocalisedName.equals(BlockHexoriumNetherOre.UNLOCALISEDNAME + "Green"))
            return blockHexoriumNetherOreGreen;
        else if (unlocalisedName.equals(BlockHexoriumNetherOre.UNLOCALISEDNAME + "Blue"))
            return blockHexoriumNetherOreBlue;
        else if (unlocalisedName.equals(BlockHexoriumNetherOre.UNLOCALISEDNAME + "White"))
            return blockHexoriumNetherOreWhite;
        else if (unlocalisedName.equals(BlockHexoriumNetherOre.UNLOCALISEDNAME + "Black"))
            return blockHexoriumNetherOreBlack;

        /* Hexorium Ore */
        else if (unlocalisedName.equals(BlockHexoriumOre.UNLOCALISEDNAME + "Red"))
            return blockHexoriumOreRed;
        else if (unlocalisedName.equals(BlockHexoriumOre.UNLOCALISEDNAME + "Green"))
            return blockHexoriumOreGreen;
        else if (unlocalisedName.equals(BlockHexoriumOre.UNLOCALISEDNAME + "Blue"))
            return blockHexoriumOreBlue;
        else if (unlocalisedName.equals(BlockHexoriumOre.UNLOCALISEDNAME + "White"))
            return blockHexoriumOreWhite;
        else if (unlocalisedName.equals(BlockHexoriumOre.UNLOCALISEDNAME + "Black"))
            return blockHexoriumOreBlack;
                
        /* Energized Hexorium */
        else if (unlocalisedName.equals(BlockEnergizedHexorium.UNLOCALISEDNAME + "Red"))
            return blockEnergizedHexoriumRed;
        else if (unlocalisedName.equals(BlockEnergizedHexorium.UNLOCALISEDNAME + "Orange"))
            return blockEnergizedHexoriumOrange;
        else if (unlocalisedName.equals(BlockEnergizedHexorium.UNLOCALISEDNAME + "Yellow"))
            return blockEnergizedHexoriumYellow;
        else if (unlocalisedName.equals(BlockEnergizedHexorium.UNLOCALISEDNAME + "Lime"))
            return blockEnergizedHexoriumLime;
        else if (unlocalisedName.equals(BlockEnergizedHexorium.UNLOCALISEDNAME + "Green"))
            return blockEnergizedHexoriumGreen;
        else if (unlocalisedName.equals(BlockEnergizedHexorium.UNLOCALISEDNAME + "Turquoise"))
            return blockEnergizedHexoriumTurquoise;
        else if (unlocalisedName.equals(BlockEnergizedHexorium.UNLOCALISEDNAME + "Cyan"))
            return blockEnergizedHexoriumCyan;
        else if (unlocalisedName.equals(BlockEnergizedHexorium.UNLOCALISEDNAME + "SkyBlue"))
            return blockEnergizedHexoriumSkyBlue;
        else if (unlocalisedName.equals(BlockEnergizedHexorium.UNLOCALISEDNAME + "Blue"))
            return blockEnergizedHexoriumBlue;
        else if (unlocalisedName.equals(BlockEnergizedHexorium.UNLOCALISEDNAME + "Purple"))
            return blockEnergizedHexoriumPurple;
        else if (unlocalisedName.equals(BlockEnergizedHexorium.UNLOCALISEDNAME + "Magenta"))
            return blockEnergizedHexoriumMagenta;
        else if (unlocalisedName.equals(BlockEnergizedHexorium.UNLOCALISEDNAME + "Pink"))
            return blockEnergizedHexoriumPink;
        
        else if (unlocalisedName.equals(BlockEnergizedHexorium.UNLOCALISEDNAME + "White"))
            return blockEnergizedHexoriumWhite;
        else if (unlocalisedName.equals(BlockEnergizedHexorium.UNLOCALISEDNAME + "LightGray"))
            return blockEnergizedHexoriumLightGray;
        else if (unlocalisedName.equals(BlockEnergizedHexorium.UNLOCALISEDNAME + "Gray"))
            return blockEnergizedHexoriumGray;
        else if (unlocalisedName.equals(BlockEnergizedHexorium.UNLOCALISEDNAME + "DarkGray"))
            return blockEnergizedHexoriumDarkGray;
        else if (unlocalisedName.equals(BlockEnergizedHexorium.UNLOCALISEDNAME + "Black"))
            return blockEnergizedHexoriumBlack;
        
        else if (unlocalisedName.equals(BlockEnergizedHexorium.UNLOCALISEDNAME + "Rainbow"))
            return blockEnergizedHexoriumRainbow;
                
        /* Engineering Block */
        else if (unlocalisedName.equals(BlockEngineeringBlock.UNLOCALISEDNAME + "White"))
            return blockEngineeringBlockWhite;
        else if (unlocalisedName.equals(BlockEngineeringBlock.UNLOCALISEDNAME + "Purple"))
            return blockEngineeringBlockPurple;
        else
            return Blocks.stone;
    }
}
