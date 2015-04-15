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
     * 4) Add an else if statement to getBlock(String unlocalisedName) if needed.
     * 5) Add the 2 required lines to HexClientProxy.setCustomRenderers() (Check other blocks).
     */

    public static int countBlocks = 8;

    /* Hexorium Ore */
    public static Block blockHexoriumOreRed;
    public static Block blockHexoriumOreGreen;
    public static Block blockHexoriumOreBlue;
    public static Block blockHexoriumOreWhite;

    /* Energized Hexorium */
    public static Block blockEnergizedHexorium;
    public static Block blockEnergizedHexoriumGreen;

    /* Engineering Block */
    public static Block blockEngineeringBlock;
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

        /* Energized Hexorium */
        blockEnergizedHexorium = new BlockEnergizedHexorium(BlockEnergizedHexorium.UNLOCALISEDNAME);
        GameRegistry.registerBlock(blockEnergizedHexorium, BlockEnergizedHexorium.UNLOCALISEDNAME);
        blockEnergizedHexoriumGreen = new BlockEnergizedHexorium(BlockEnergizedHexorium.UNLOCALISEDNAME + "Green");
        GameRegistry.registerBlock(blockEnergizedHexoriumGreen, BlockEnergizedHexorium.UNLOCALISEDNAME + "Green");

        /* Engineering Block */
        blockEngineeringBlock = new BlockEngineeringBlock(BlockEngineeringBlock.UNLOCALISEDNAME);
        GameRegistry.registerBlock(blockEngineeringBlock, BlockEngineeringBlock.UNLOCALISEDNAME);
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
        if (unlocalisedName.equals(BlockHexoriumOre.UNLOCALISEDNAME + "Red")) {
            return blockHexoriumOreRed;
        }
        else if (unlocalisedName.equals(BlockHexoriumOre.UNLOCALISEDNAME + "Green")) {
            return blockHexoriumOreGreen;
        }
        else if (unlocalisedName.equals(BlockHexoriumOre.UNLOCALISEDNAME + "Blue")) {
            return blockHexoriumOreBlue;
        }
        else if (unlocalisedName.equals(BlockHexoriumOre.UNLOCALISEDNAME + "White")) {
            return blockHexoriumOreWhite;
        }
        else if (unlocalisedName.equals(BlockEnergizedHexorium.UNLOCALISEDNAME)) {
            return blockEnergizedHexorium;
        }
        else if (unlocalisedName.equals(BlockEngineeringBlock.UNLOCALISEDNAME)) {
            return blockEngineeringBlock;
        }
        else {
            return Blocks.stone;
        }
    }
}
