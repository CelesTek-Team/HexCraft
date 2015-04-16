package com.celestek.hexcraft.init;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.BlockEnergizedHexorium;
import com.celestek.hexcraft.block.BlockEngineeringBlock;
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

    public static int countBlocks = 12;

    /* Hexorium Ore */
    public static Block blockHexoriumOreRed;
    public static Block blockHexoriumOreGreen;
    public static Block blockHexoriumOreBlue;
    public static Block blockHexoriumOreWhite;
    public static Block blockHexoriumOreBlack;

    /* Energized Hexorium */
    public static Block blockEnergizedHexoriumRed;
    public static Block blockEnergizedHexoriumGreen;
    public static Block blockEnergizedHexoriumBlue;
    public static Block blockEnergizedHexoriumWhite;
    public static Block blockEnergizedHexoriumBlack;

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
        blockEnergizedHexoriumGreen = new BlockEnergizedHexorium(BlockEnergizedHexorium.UNLOCALISEDNAME + "Green");
        GameRegistry.registerBlock(blockEnergizedHexoriumGreen, BlockEnergizedHexorium.UNLOCALISEDNAME + "Green");
        blockEnergizedHexoriumBlue = new BlockEnergizedHexorium(BlockEnergizedHexorium.UNLOCALISEDNAME + "Blue");
        GameRegistry.registerBlock(blockEnergizedHexoriumBlue, BlockEnergizedHexorium.UNLOCALISEDNAME + "Blue");
        blockEnergizedHexoriumWhite = new BlockEnergizedHexorium(BlockEnergizedHexorium.UNLOCALISEDNAME + "White");
        GameRegistry.registerBlock(blockEnergizedHexoriumWhite, BlockEnergizedHexorium.UNLOCALISEDNAME + "White");
        blockEnergizedHexoriumBlack = new BlockEnergizedHexorium(BlockEnergizedHexorium.UNLOCALISEDNAME + "Black");
        GameRegistry.registerBlock(blockEnergizedHexoriumBlack, BlockEnergizedHexorium.UNLOCALISEDNAME + "Black");

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
        /* Hexorium Ore */
        if (unlocalisedName.equals(BlockHexoriumOre.UNLOCALISEDNAME + "Red"))
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
        else if (unlocalisedName.equals(BlockEnergizedHexorium.UNLOCALISEDNAME + "Green"))
            return blockEnergizedHexoriumGreen;
        else if (unlocalisedName.equals(BlockEnergizedHexorium.UNLOCALISEDNAME + "Blue"))
            return blockEnergizedHexoriumBlue;
        else if (unlocalisedName.equals(BlockEnergizedHexorium.UNLOCALISEDNAME + "White"))
            return blockEnergizedHexoriumWhite;
        else if (unlocalisedName.equals(BlockEnergizedHexorium.UNLOCALISEDNAME + "Black"))
            return blockEnergizedHexoriumBlack;
        /* Engineering Block */
        else if (unlocalisedName.equals(BlockEngineeringBlock.UNLOCALISEDNAME + "White"))
            return blockEngineeringBlockWhite;
        else if (unlocalisedName.equals(BlockEngineeringBlock.UNLOCALISEDNAME + "Purple"))
            return blockEngineeringBlockPurple;
        else
            return Blocks.stone;
    }
}
