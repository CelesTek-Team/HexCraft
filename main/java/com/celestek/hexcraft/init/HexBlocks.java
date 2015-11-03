package com.celestek.hexcraft.init;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.world.World;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.6.2

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
    public static int countBlocks = 260;

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

    // Plated Hexorium Block
    public static Block blockPlatedHexoriumBlockRed;
    public static Block blockPlatedHexoriumBlockOrange;
    public static Block blockPlatedHexoriumBlockYellow;
    public static Block blockPlatedHexoriumBlockLime;
    public static Block blockPlatedHexoriumBlockGreen;
    public static Block blockPlatedHexoriumBlockTurquoise;
    public static Block blockPlatedHexoriumBlockCyan;
    public static Block blockPlatedHexoriumBlockSkyBlue;
    public static Block blockPlatedHexoriumBlockBlue;
    public static Block blockPlatedHexoriumBlockPurple;
    public static Block blockPlatedHexoriumBlockMagenta;
    public static Block blockPlatedHexoriumBlockPink;

    public static Block blockPlatedHexoriumBlockWhite;
    public static Block blockPlatedHexoriumBlockLightGray;
    public static Block blockPlatedHexoriumBlockGray;
    public static Block blockPlatedHexoriumBlockDarkGray;
    public static Block blockPlatedHexoriumBlockBlack;

    public static Block blockPlatedHexoriumBlockRainbow;

    // Concentric Hexorium Block
    public static Block blockConcentricHexoriumBlockRed;
    public static Block blockConcentricHexoriumBlockOrange;
    public static Block blockConcentricHexoriumBlockYellow;
    public static Block blockConcentricHexoriumBlockLime;
    public static Block blockConcentricHexoriumBlockGreen;
    public static Block blockConcentricHexoriumBlockTurquoise;
    public static Block blockConcentricHexoriumBlockCyan;
    public static Block blockConcentricHexoriumBlockSkyBlue;
    public static Block blockConcentricHexoriumBlockBlue;
    public static Block blockConcentricHexoriumBlockPurple;
    public static Block blockConcentricHexoriumBlockMagenta;
    public static Block blockConcentricHexoriumBlockPink;

    public static Block blockConcentricHexoriumBlockWhite;
    public static Block blockConcentricHexoriumBlockLightGray;
    public static Block blockConcentricHexoriumBlockGray;
    public static Block blockConcentricHexoriumBlockDarkGray;
    public static Block blockConcentricHexoriumBlockBlack;

    public static Block blockConcentricHexoriumBlockRainbow;

    // Glowing Hexorium Glass
    public static Block blockGlowingHexoriumGlassRed;
    public static Block blockGlowingHexoriumGlassOrange;
    public static Block blockGlowingHexoriumGlassYellow;
    public static Block blockGlowingHexoriumGlassLime;
    public static Block blockGlowingHexoriumGlassGreen;
    public static Block blockGlowingHexoriumGlassTurquoise;
    public static Block blockGlowingHexoriumGlassCyan;
    public static Block blockGlowingHexoriumGlassSkyBlue;
    public static Block blockGlowingHexoriumGlassBlue;
    public static Block blockGlowingHexoriumGlassPurple;
    public static Block blockGlowingHexoriumGlassMagenta;
    public static Block blockGlowingHexoriumGlassPink;

    public static Block blockGlowingHexoriumGlassWhite;
    public static Block blockGlowingHexoriumGlassLightGray;
    public static Block blockGlowingHexoriumGlassGray;
    public static Block blockGlowingHexoriumGlassDarkGray;
    public static Block blockGlowingHexoriumGlassBlack;

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
    public static Block blockHexoriumLampInvRed;
    public static Block blockHexoriumLampInvOrange;
    public static Block blockHexoriumLampInvYellow;
    public static Block blockHexoriumLampInvLime;
    public static Block blockHexoriumLampInvGreen;
    public static Block blockHexoriumLampInvTurquoise;
    public static Block blockHexoriumLampInvCyan;
    public static Block blockHexoriumLampInvSkyBlue;
    public static Block blockHexoriumLampInvBlue;
    public static Block blockHexoriumLampInvPurple;
    public static Block blockHexoriumLampInvMagenta;
    public static Block blockHexoriumLampInvPink;

    public static Block blockHexoriumLampInvWhite;
    public static Block blockHexoriumLampInvLightGray;
    public static Block blockHexoriumLampInvGray;
    public static Block blockHexoriumLampInvDarkGray;
    public static Block blockHexoriumLampInvBlack;

    public static Block blockHexoriumLampInvRainbow;

    // Hexorium Door
    public static Block blockHexoriumDoorRed;
    public static Block blockHexoriumDoorOrange;
    public static Block blockHexoriumDoorYellow;
    public static Block blockHexoriumDoorLime;
    public static Block blockHexoriumDoorGreen;
    public static Block blockHexoriumDoorTurquoise;
    public static Block blockHexoriumDoorCyan;
    public static Block blockHexoriumDoorSkyBlue;
    public static Block blockHexoriumDoorBlue;
    public static Block blockHexoriumDoorPurple;
    public static Block blockHexoriumDoorMagenta;
    public static Block blockHexoriumDoorPink;

    public static Block blockHexoriumDoorWhite;
    public static Block blockHexoriumDoorLightGray;
    public static Block blockHexoriumDoorGray;
    public static Block blockHexoriumDoorDarkGray;
    public static Block blockHexoriumDoorBlack;

    public static Block blockHexoriumDoorRainbow;

    // Hexorium Hatch
    public static Block blockHexoriumHatchRed;
    public static Block blockHexoriumHatchOrange;
    public static Block blockHexoriumHatchYellow;
    public static Block blockHexoriumHatchLime;
    public static Block blockHexoriumHatchGreen;
    public static Block blockHexoriumHatchTurquoise;
    public static Block blockHexoriumHatchCyan;
    public static Block blockHexoriumHatchSkyBlue;
    public static Block blockHexoriumHatchBlue;
    public static Block blockHexoriumHatchPurple;
    public static Block blockHexoriumHatchMagenta;
    public static Block blockHexoriumHatchPink;

    public static Block blockHexoriumHatchWhite;
    public static Block blockHexoriumHatchLightGray;
    public static Block blockHexoriumHatchGray;
    public static Block blockHexoriumHatchDarkGray;
    public static Block blockHexoriumHatchBlack;

    public static Block blockHexoriumHatchRainbow;

    // Machines
    public static Block blockHexoriumMachineBlock;

    public static Block blockHexoriumGenerator;
    public static Block blockHexoriumFurnace;
    public static Block blockCrystalSeparator;
    public static Block blockMatrixReconstructor;

    public static Block blockPersonalTeleportationPad;

    // Hexiroum Valve
    public static Block blockTankValve;
    public static Block blockTankRender;

    // Cables
    public static Block blockHexoriumCableRed;
    public static Block blockHexoriumCableOrange;
    public static Block blockHexoriumCableYellow;
    public static Block blockHexoriumCableLime;
    public static Block blockHexoriumCableGreen;
    public static Block blockHexoriumCableTurquoise;
    public static Block blockHexoriumCableCyan;
    public static Block blockHexoriumCableSkyBlue;
    public static Block blockHexoriumCableBlue;
    public static Block blockHexoriumCablePurple;
    public static Block blockHexoriumCableMagenta;
    public static Block blockHexoriumCablePink;

    public static Block blockHexoriumCableWhite;
    public static Block blockHexoriumCableLightGray;
    public static Block blockHexoriumCableGray;
    public static Block blockHexoriumCableDarkGray;
    public static Block blockHexoriumCableBlack;
    
    public static Block blockHexoriumCableRainbow;
    
    // Energy Pylon
    public static Block blockEnergyPylon;

    // Hexorium Switch
    public static Block blockHexoriumSwitchRedGreen;
    public static Block blockHexoriumSwitchRedBlue;
    public static Block blockHexoriumSwitchRedWhite;

    // Hexorium Button
    public static Block blockHexoriumButtonRed;
    public static Block blockHexoriumButtonGreen;
    public static Block blockHexoriumButtonBlue;
    public static Block blockHexoriumButtonWhite;

    // Hexorium Pressure Plate
    public static Block blockHexoriumPressurePlateRed;
    public static Block blockHexoriumPressurePlateGreen;
    public static Block blockHexoriumPressurePlateBlue;
    public static Block blockHexoriumPressurePlateWhite;

    // Regular Blocks
    public static Block blockTemperedHexoriumGlass;

    public static Block blockPylonBase51;
    public static Block blockPylonBase15;

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

        // Plated Hexorium Block
        blockPlatedHexoriumBlockRed = new BlockPlatedHexoriumBlock(BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Red");
        GameRegistry.registerBlock(blockPlatedHexoriumBlockRed, BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Red");
        blockPlatedHexoriumBlockOrange = new BlockPlatedHexoriumBlock(BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Orange");
        GameRegistry.registerBlock(blockPlatedHexoriumBlockOrange, BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Orange");
        blockPlatedHexoriumBlockYellow = new BlockPlatedHexoriumBlock(BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Yellow");
        GameRegistry.registerBlock(blockPlatedHexoriumBlockYellow, BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Yellow");
        blockPlatedHexoriumBlockLime = new BlockPlatedHexoriumBlock(BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Lime");
        GameRegistry.registerBlock(blockPlatedHexoriumBlockLime, BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Lime");
        blockPlatedHexoriumBlockGreen = new BlockPlatedHexoriumBlock(BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Green");
        GameRegistry.registerBlock(blockPlatedHexoriumBlockGreen, BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Green");
        blockPlatedHexoriumBlockTurquoise = new BlockPlatedHexoriumBlock(BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Turquoise");
        GameRegistry.registerBlock(blockPlatedHexoriumBlockTurquoise, BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Turquoise");
        blockPlatedHexoriumBlockCyan = new BlockPlatedHexoriumBlock(BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Cyan");
        GameRegistry.registerBlock(blockPlatedHexoriumBlockCyan, BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Cyan");
        blockPlatedHexoriumBlockSkyBlue = new BlockPlatedHexoriumBlock(BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "SkyBlue");
        GameRegistry.registerBlock(blockPlatedHexoriumBlockSkyBlue, BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "SkyBlue");
        blockPlatedHexoriumBlockBlue = new BlockPlatedHexoriumBlock(BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Blue");
        GameRegistry.registerBlock(blockPlatedHexoriumBlockBlue, BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Blue");
        blockPlatedHexoriumBlockPurple = new BlockPlatedHexoriumBlock(BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Purple");
        GameRegistry.registerBlock(blockPlatedHexoriumBlockPurple, BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Purple");
        blockPlatedHexoriumBlockMagenta = new BlockPlatedHexoriumBlock(BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Magenta");
        GameRegistry.registerBlock(blockPlatedHexoriumBlockMagenta, BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Magenta");
        blockPlatedHexoriumBlockPink = new BlockPlatedHexoriumBlock(BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Pink");
        GameRegistry.registerBlock(blockPlatedHexoriumBlockPink, BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Pink");

        blockPlatedHexoriumBlockWhite = new BlockPlatedHexoriumBlock(BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "White");
        GameRegistry.registerBlock(blockPlatedHexoriumBlockWhite, BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "White");
        blockPlatedHexoriumBlockLightGray = new BlockPlatedHexoriumBlock(BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "LightGray");
        GameRegistry.registerBlock(blockPlatedHexoriumBlockLightGray, BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "LightGray");
        blockPlatedHexoriumBlockGray = new BlockPlatedHexoriumBlock(BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Gray");
        GameRegistry.registerBlock(blockPlatedHexoriumBlockGray, BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Gray");
        blockPlatedHexoriumBlockDarkGray = new BlockPlatedHexoriumBlock(BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "DarkGray");
        GameRegistry.registerBlock(blockPlatedHexoriumBlockDarkGray, BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "DarkGray");
        blockPlatedHexoriumBlockBlack = new BlockPlatedHexoriumBlock(BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Black");
        GameRegistry.registerBlock(blockPlatedHexoriumBlockBlack, BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Black");

        blockPlatedHexoriumBlockRainbow = new BlockPlatedHexoriumBlock(BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Rainbow");
        GameRegistry.registerBlock(blockPlatedHexoriumBlockRainbow, BlockPlatedHexoriumBlock.UNLOCALISEDNAME + "Rainbow");

        // Concentric Hexorium Block
        blockConcentricHexoriumBlockRed = new BlockConcentricHexoriumBlock(BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Red");
        GameRegistry.registerBlock(blockConcentricHexoriumBlockRed, BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Red");
        blockConcentricHexoriumBlockOrange = new BlockConcentricHexoriumBlock(BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Orange");
        GameRegistry.registerBlock(blockConcentricHexoriumBlockOrange, BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Orange");
        blockConcentricHexoriumBlockYellow = new BlockConcentricHexoriumBlock(BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Yellow");
        GameRegistry.registerBlock(blockConcentricHexoriumBlockYellow, BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Yellow");
        blockConcentricHexoriumBlockLime = new BlockConcentricHexoriumBlock(BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Lime");
        GameRegistry.registerBlock(blockConcentricHexoriumBlockLime, BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Lime");
        blockConcentricHexoriumBlockGreen = new BlockConcentricHexoriumBlock(BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Green");
        GameRegistry.registerBlock(blockConcentricHexoriumBlockGreen, BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Green");
        blockConcentricHexoriumBlockTurquoise = new BlockConcentricHexoriumBlock(BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Turquoise");
        GameRegistry.registerBlock(blockConcentricHexoriumBlockTurquoise, BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Turquoise");
        blockConcentricHexoriumBlockCyan = new BlockConcentricHexoriumBlock(BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Cyan");
        GameRegistry.registerBlock(blockConcentricHexoriumBlockCyan, BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Cyan");
        blockConcentricHexoriumBlockSkyBlue = new BlockConcentricHexoriumBlock(BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "SkyBlue");
        GameRegistry.registerBlock(blockConcentricHexoriumBlockSkyBlue, BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "SkyBlue");
        blockConcentricHexoriumBlockBlue = new BlockConcentricHexoriumBlock(BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Blue");
        GameRegistry.registerBlock(blockConcentricHexoriumBlockBlue, BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Blue");
        blockConcentricHexoriumBlockPurple = new BlockConcentricHexoriumBlock(BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Purple");
        GameRegistry.registerBlock(blockConcentricHexoriumBlockPurple, BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Purple");
        blockConcentricHexoriumBlockMagenta = new BlockConcentricHexoriumBlock(BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Magenta");
        GameRegistry.registerBlock(blockConcentricHexoriumBlockMagenta, BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Magenta");
        blockConcentricHexoriumBlockPink = new BlockConcentricHexoriumBlock(BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Pink");
        GameRegistry.registerBlock(blockConcentricHexoriumBlockPink, BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Pink");

        blockConcentricHexoriumBlockWhite = new BlockConcentricHexoriumBlock(BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "White");
        GameRegistry.registerBlock(blockConcentricHexoriumBlockWhite, BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "White");
        blockConcentricHexoriumBlockLightGray = new BlockConcentricHexoriumBlock(BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "LightGray");
        GameRegistry.registerBlock(blockConcentricHexoriumBlockLightGray, BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "LightGray");
        blockConcentricHexoriumBlockGray = new BlockConcentricHexoriumBlock(BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Gray");
        GameRegistry.registerBlock(blockConcentricHexoriumBlockGray, BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Gray");
        blockConcentricHexoriumBlockDarkGray = new BlockConcentricHexoriumBlock(BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "DarkGray");
        GameRegistry.registerBlock(blockConcentricHexoriumBlockDarkGray, BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "DarkGray");
        blockConcentricHexoriumBlockBlack = new BlockConcentricHexoriumBlock(BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Black");
        GameRegistry.registerBlock(blockConcentricHexoriumBlockBlack, BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Black");

        blockConcentricHexoriumBlockRainbow = new BlockConcentricHexoriumBlock(BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Rainbow");
        GameRegistry.registerBlock(blockConcentricHexoriumBlockRainbow, BlockConcentricHexoriumBlock.UNLOCALISEDNAME + "Rainbow");

        // Glowing Hexorium Glass
        blockGlowingHexoriumGlassRed = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Red");
        GameRegistry.registerBlock(blockGlowingHexoriumGlassRed, BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Red");
        blockGlowingHexoriumGlassOrange = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Orange");
        GameRegistry.registerBlock(blockGlowingHexoriumGlassOrange, BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Orange");
        blockGlowingHexoriumGlassYellow = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Yellow");
        GameRegistry.registerBlock(blockGlowingHexoriumGlassYellow, BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Yellow");
        blockGlowingHexoriumGlassLime = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Lime");
        GameRegistry.registerBlock(blockGlowingHexoriumGlassLime, BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Lime");
        blockGlowingHexoriumGlassGreen = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Green");
        GameRegistry.registerBlock(blockGlowingHexoriumGlassGreen, BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Green");
        blockGlowingHexoriumGlassTurquoise = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Turquoise");
        GameRegistry.registerBlock(blockGlowingHexoriumGlassTurquoise, BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Turquoise");
        blockGlowingHexoriumGlassCyan = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Cyan");
        GameRegistry.registerBlock(blockGlowingHexoriumGlassCyan, BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Cyan");
        blockGlowingHexoriumGlassSkyBlue = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "SkyBlue");
        GameRegistry.registerBlock(blockGlowingHexoriumGlassSkyBlue, BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "SkyBlue");
        blockGlowingHexoriumGlassBlue = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Blue");
        GameRegistry.registerBlock(blockGlowingHexoriumGlassBlue, BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Blue");
        blockGlowingHexoriumGlassPurple = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Purple");
        GameRegistry.registerBlock(blockGlowingHexoriumGlassPurple, BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Purple");
        blockGlowingHexoriumGlassMagenta = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Magenta");
        GameRegistry.registerBlock(blockGlowingHexoriumGlassMagenta, BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Magenta");
        blockGlowingHexoriumGlassPink = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Pink");
        GameRegistry.registerBlock(blockGlowingHexoriumGlassPink, BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Pink");

        blockGlowingHexoriumGlassWhite = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "White");
        GameRegistry.registerBlock(blockGlowingHexoriumGlassWhite, BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "White");
        blockGlowingHexoriumGlassLightGray = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "LightGray");
        GameRegistry.registerBlock(blockGlowingHexoriumGlassLightGray, BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "LightGray");
        blockGlowingHexoriumGlassGray = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Gray");
        GameRegistry.registerBlock(blockGlowingHexoriumGlassGray, BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Gray");
        blockGlowingHexoriumGlassDarkGray = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "DarkGray");
        GameRegistry.registerBlock(blockGlowingHexoriumGlassDarkGray, BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "DarkGray");
        blockGlowingHexoriumGlassBlack = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Black");
        GameRegistry.registerBlock(blockGlowingHexoriumGlassBlack, BlockGlowingHexoriumGlass.UNLOCALISEDNAME + "Black");
        
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
        blockHexoriumLampRed = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Red");
        GameRegistry.registerBlock(blockHexoriumLampRed, BlockHexoriumLamp.UNLOCALISEDNAME + "Red");
        blockHexoriumLampOrange = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Orange");
        GameRegistry.registerBlock(blockHexoriumLampOrange, BlockHexoriumLamp.UNLOCALISEDNAME + "Orange");
        blockHexoriumLampYellow = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Yellow");
        GameRegistry.registerBlock(blockHexoriumLampYellow, BlockHexoriumLamp.UNLOCALISEDNAME + "Yellow");
        blockHexoriumLampLime = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Lime");
        GameRegistry.registerBlock(blockHexoriumLampLime, BlockHexoriumLamp.UNLOCALISEDNAME + "Lime");
        blockHexoriumLampGreen = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Green");
        GameRegistry.registerBlock(blockHexoriumLampGreen, BlockHexoriumLamp.UNLOCALISEDNAME + "Green");
        blockHexoriumLampTurquoise = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Turquoise");
        GameRegistry.registerBlock(blockHexoriumLampTurquoise, BlockHexoriumLamp.UNLOCALISEDNAME + "Turquoise");
        blockHexoriumLampCyan = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Cyan");
        GameRegistry.registerBlock(blockHexoriumLampCyan, BlockHexoriumLamp.UNLOCALISEDNAME + "Cyan");
        blockHexoriumLampSkyBlue = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "SkyBlue");
        GameRegistry.registerBlock(blockHexoriumLampSkyBlue, BlockHexoriumLamp.UNLOCALISEDNAME + "SkyBlue");
        blockHexoriumLampBlue = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Blue");
        GameRegistry.registerBlock(blockHexoriumLampBlue, BlockHexoriumLamp.UNLOCALISEDNAME + "Blue");
        blockHexoriumLampPurple = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Purple");
        GameRegistry.registerBlock(blockHexoriumLampPurple, BlockHexoriumLamp.UNLOCALISEDNAME + "Purple");
        blockHexoriumLampMagenta = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Magenta");
        GameRegistry.registerBlock(blockHexoriumLampMagenta, BlockHexoriumLamp.UNLOCALISEDNAME + "Magenta");
        blockHexoriumLampPink = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Pink");
        GameRegistry.registerBlock(blockHexoriumLampPink, BlockHexoriumLamp.UNLOCALISEDNAME + "Pink");

        blockHexoriumLampWhite = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "White");
        GameRegistry.registerBlock(blockHexoriumLampWhite, BlockHexoriumLamp.UNLOCALISEDNAME + "White");
        blockHexoriumLampLightGray = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "LightGray");
        GameRegistry.registerBlock(blockHexoriumLampLightGray, BlockHexoriumLamp.UNLOCALISEDNAME + "LightGray");
        blockHexoriumLampGray = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Gray");
        GameRegistry.registerBlock(blockHexoriumLampGray, BlockHexoriumLamp.UNLOCALISEDNAME + "Gray");
        blockHexoriumLampDarkGray = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "DarkGray");
        GameRegistry.registerBlock(blockHexoriumLampDarkGray, BlockHexoriumLamp.UNLOCALISEDNAME + "DarkGray");
        blockHexoriumLampBlack = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Black");
        GameRegistry.registerBlock(blockHexoriumLampBlack, BlockHexoriumLamp.UNLOCALISEDNAME + "Black");

        blockHexoriumLampRainbow = new BlockHexoriumLamp(BlockHexoriumLamp.UNLOCALISEDNAME + "Rainbow");
        GameRegistry.registerBlock(blockHexoriumLampRainbow, BlockHexoriumLamp.UNLOCALISEDNAME + "Rainbow");

        // Inverted Hexorium Lamp
        blockHexoriumLampInvRed = new BlockHexoriumLampInv(BlockHexoriumLampInv.UNLOCALISEDNAME + "Red");
        GameRegistry.registerBlock(blockHexoriumLampInvRed, BlockHexoriumLampInv.UNLOCALISEDNAME + "Red");
        blockHexoriumLampInvOrange = new BlockHexoriumLampInv(BlockHexoriumLampInv.UNLOCALISEDNAME + "Orange");
        GameRegistry.registerBlock(blockHexoriumLampInvOrange, BlockHexoriumLampInv.UNLOCALISEDNAME + "Orange");
        blockHexoriumLampInvYellow = new BlockHexoriumLampInv(BlockHexoriumLampInv.UNLOCALISEDNAME + "Yellow");
        GameRegistry.registerBlock(blockHexoriumLampInvYellow, BlockHexoriumLampInv.UNLOCALISEDNAME + "Yellow");
        blockHexoriumLampInvLime = new BlockHexoriumLampInv(BlockHexoriumLampInv.UNLOCALISEDNAME + "Lime");
        GameRegistry.registerBlock(blockHexoriumLampInvLime, BlockHexoriumLampInv.UNLOCALISEDNAME + "Lime");
        blockHexoriumLampInvGreen = new BlockHexoriumLampInv(BlockHexoriumLampInv.UNLOCALISEDNAME + "Green");
        GameRegistry.registerBlock(blockHexoriumLampInvGreen, BlockHexoriumLampInv.UNLOCALISEDNAME + "Green");
        blockHexoriumLampInvTurquoise = new BlockHexoriumLampInv(BlockHexoriumLampInv.UNLOCALISEDNAME + "Turquoise");
        GameRegistry.registerBlock(blockHexoriumLampInvTurquoise, BlockHexoriumLampInv.UNLOCALISEDNAME + "Turquoise");
        blockHexoriumLampInvCyan = new BlockHexoriumLampInv(BlockHexoriumLampInv.UNLOCALISEDNAME + "Cyan");
        GameRegistry.registerBlock(blockHexoriumLampInvCyan, BlockHexoriumLampInv.UNLOCALISEDNAME + "Cyan");
        blockHexoriumLampInvSkyBlue = new BlockHexoriumLampInv(BlockHexoriumLampInv.UNLOCALISEDNAME + "SkyBlue");
        GameRegistry.registerBlock(blockHexoriumLampInvSkyBlue, BlockHexoriumLampInv.UNLOCALISEDNAME + "SkyBlue");
        blockHexoriumLampInvBlue = new BlockHexoriumLampInv(BlockHexoriumLampInv.UNLOCALISEDNAME + "Blue");
        GameRegistry.registerBlock(blockHexoriumLampInvBlue, BlockHexoriumLampInv.UNLOCALISEDNAME + "Blue");
        blockHexoriumLampInvPurple = new BlockHexoriumLampInv(BlockHexoriumLampInv.UNLOCALISEDNAME + "Purple");
        GameRegistry.registerBlock(blockHexoriumLampInvPurple, BlockHexoriumLampInv.UNLOCALISEDNAME + "Purple");
        blockHexoriumLampInvMagenta = new BlockHexoriumLampInv(BlockHexoriumLampInv.UNLOCALISEDNAME + "Magenta");
        GameRegistry.registerBlock(blockHexoriumLampInvMagenta, BlockHexoriumLampInv.UNLOCALISEDNAME + "Magenta");
        blockHexoriumLampInvPink = new BlockHexoriumLampInv(BlockHexoriumLampInv.UNLOCALISEDNAME + "Pink");
        GameRegistry.registerBlock(blockHexoriumLampInvPink, BlockHexoriumLampInv.UNLOCALISEDNAME + "Pink");

        blockHexoriumLampInvWhite = new BlockHexoriumLampInv(BlockHexoriumLampInv.UNLOCALISEDNAME + "White");
        GameRegistry.registerBlock(blockHexoriumLampInvWhite, BlockHexoriumLampInv.UNLOCALISEDNAME + "White");
        blockHexoriumLampInvLightGray = new BlockHexoriumLampInv(BlockHexoriumLampInv.UNLOCALISEDNAME + "LightGray");
        GameRegistry.registerBlock(blockHexoriumLampInvLightGray, BlockHexoriumLampInv.UNLOCALISEDNAME + "LightGray");
        blockHexoriumLampInvGray = new BlockHexoriumLampInv(BlockHexoriumLampInv.UNLOCALISEDNAME + "Gray");
        GameRegistry.registerBlock(blockHexoriumLampInvGray, BlockHexoriumLampInv.UNLOCALISEDNAME + "Gray");
        blockHexoriumLampInvDarkGray = new BlockHexoriumLampInv(BlockHexoriumLampInv.UNLOCALISEDNAME + "DarkGray");
        GameRegistry.registerBlock(blockHexoriumLampInvDarkGray, BlockHexoriumLampInv.UNLOCALISEDNAME + "DarkGray");
        blockHexoriumLampInvBlack = new BlockHexoriumLampInv(BlockHexoriumLampInv.UNLOCALISEDNAME + "Black");
        GameRegistry.registerBlock(blockHexoriumLampInvBlack, BlockHexoriumLampInv.UNLOCALISEDNAME + "Black");

        blockHexoriumLampInvRainbow = new BlockHexoriumLampInv(BlockHexoriumLampInv.UNLOCALISEDNAME + "Rainbow");
        GameRegistry.registerBlock(blockHexoriumLampInvRainbow, BlockHexoriumLampInv.UNLOCALISEDNAME + "Rainbow");

        // Hexorium Door
        blockHexoriumDoorRed = new BlockHexoriumDoor(BlockHexoriumDoor.UNLOCALISEDNAME + "Red");
        GameRegistry.registerBlock(blockHexoriumDoorRed, BlockHexoriumDoor.UNLOCALISEDNAME + "Red");
        blockHexoriumDoorOrange = new BlockHexoriumDoor(BlockHexoriumDoor.UNLOCALISEDNAME + "Orange");
        GameRegistry.registerBlock(blockHexoriumDoorOrange, BlockHexoriumDoor.UNLOCALISEDNAME + "Orange");
        blockHexoriumDoorYellow = new BlockHexoriumDoor(BlockHexoriumDoor.UNLOCALISEDNAME + "Yellow");
        GameRegistry.registerBlock(blockHexoriumDoorYellow, BlockHexoriumDoor.UNLOCALISEDNAME + "Yellow");
        blockHexoriumDoorLime = new BlockHexoriumDoor(BlockHexoriumDoor.UNLOCALISEDNAME + "Lime");
        GameRegistry.registerBlock(blockHexoriumDoorLime, BlockHexoriumDoor.UNLOCALISEDNAME + "Lime");
        blockHexoriumDoorGreen = new BlockHexoriumDoor(BlockHexoriumDoor.UNLOCALISEDNAME + "Green");
        GameRegistry.registerBlock(blockHexoriumDoorGreen, BlockHexoriumDoor.UNLOCALISEDNAME + "Green");
        blockHexoriumDoorTurquoise = new BlockHexoriumDoor(BlockHexoriumDoor.UNLOCALISEDNAME + "Turquoise");
        GameRegistry.registerBlock(blockHexoriumDoorTurquoise, BlockHexoriumDoor.UNLOCALISEDNAME + "Turquoise");
        blockHexoriumDoorCyan = new BlockHexoriumDoor(BlockHexoriumDoor.UNLOCALISEDNAME + "Cyan");
        GameRegistry.registerBlock(blockHexoriumDoorCyan, BlockHexoriumDoor.UNLOCALISEDNAME + "Cyan");
        blockHexoriumDoorSkyBlue = new BlockHexoriumDoor(BlockHexoriumDoor.UNLOCALISEDNAME + "SkyBlue");
        GameRegistry.registerBlock(blockHexoriumDoorSkyBlue, BlockHexoriumDoor.UNLOCALISEDNAME + "SkyBlue");
        blockHexoriumDoorBlue = new BlockHexoriumDoor(BlockHexoriumDoor.UNLOCALISEDNAME + "Blue");
        GameRegistry.registerBlock(blockHexoriumDoorBlue, BlockHexoriumDoor.UNLOCALISEDNAME + "Blue");
        blockHexoriumDoorPurple = new BlockHexoriumDoor(BlockHexoriumDoor.UNLOCALISEDNAME + "Purple");
        GameRegistry.registerBlock(blockHexoriumDoorPurple, BlockHexoriumDoor.UNLOCALISEDNAME + "Purple");
        blockHexoriumDoorMagenta = new BlockHexoriumDoor(BlockHexoriumDoor.UNLOCALISEDNAME + "Magenta");
        GameRegistry.registerBlock(blockHexoriumDoorMagenta, BlockHexoriumDoor.UNLOCALISEDNAME + "Magenta");
        blockHexoriumDoorPink = new BlockHexoriumDoor(BlockHexoriumDoor.UNLOCALISEDNAME + "Pink");
        GameRegistry.registerBlock(blockHexoriumDoorPink, BlockHexoriumDoor.UNLOCALISEDNAME + "Pink");

        blockHexoriumDoorWhite = new BlockHexoriumDoor(BlockHexoriumDoor.UNLOCALISEDNAME + "White");
        GameRegistry.registerBlock(blockHexoriumDoorWhite, BlockHexoriumDoor.UNLOCALISEDNAME + "White");
        blockHexoriumDoorLightGray = new BlockHexoriumDoor(BlockHexoriumDoor.UNLOCALISEDNAME + "LightGray");
        GameRegistry.registerBlock(blockHexoriumDoorLightGray, BlockHexoriumDoor.UNLOCALISEDNAME + "LightGray");
        blockHexoriumDoorGray = new BlockHexoriumDoor(BlockHexoriumDoor.UNLOCALISEDNAME + "Gray");
        GameRegistry.registerBlock(blockHexoriumDoorGray, BlockHexoriumDoor.UNLOCALISEDNAME + "Gray");
        blockHexoriumDoorDarkGray = new BlockHexoriumDoor(BlockHexoriumDoor.UNLOCALISEDNAME + "DarkGray");
        GameRegistry.registerBlock(blockHexoriumDoorDarkGray, BlockHexoriumDoor.UNLOCALISEDNAME + "DarkGray");
        blockHexoriumDoorBlack = new BlockHexoriumDoor(BlockHexoriumDoor.UNLOCALISEDNAME + "Black");
        GameRegistry.registerBlock(blockHexoriumDoorBlack, BlockHexoriumDoor.UNLOCALISEDNAME + "Black");

        blockHexoriumDoorRainbow = new BlockHexoriumDoor(BlockHexoriumDoor.UNLOCALISEDNAME + "Rainbow");
        GameRegistry.registerBlock(blockHexoriumDoorRainbow, BlockHexoriumDoor.UNLOCALISEDNAME + "Rainbow");

        // Hexorium Hatch
        blockHexoriumHatchRed = new BlockHexoriumHatch(BlockHexoriumHatch.UNLOCALISEDNAME + "Red");
        GameRegistry.registerBlock(blockHexoriumHatchRed, BlockHexoriumHatch.UNLOCALISEDNAME + "Red");
        blockHexoriumHatchOrange = new BlockHexoriumHatch(BlockHexoriumHatch.UNLOCALISEDNAME + "Orange");
        GameRegistry.registerBlock(blockHexoriumHatchOrange, BlockHexoriumHatch.UNLOCALISEDNAME + "Orange");
        blockHexoriumHatchYellow = new BlockHexoriumHatch(BlockHexoriumHatch.UNLOCALISEDNAME + "Yellow");
        GameRegistry.registerBlock(blockHexoriumHatchYellow, BlockHexoriumHatch.UNLOCALISEDNAME + "Yellow");
        blockHexoriumHatchLime = new BlockHexoriumHatch(BlockHexoriumHatch.UNLOCALISEDNAME + "Lime");
        GameRegistry.registerBlock(blockHexoriumHatchLime, BlockHexoriumHatch.UNLOCALISEDNAME + "Lime");
        blockHexoriumHatchGreen = new BlockHexoriumHatch(BlockHexoriumHatch.UNLOCALISEDNAME + "Green");
        GameRegistry.registerBlock(blockHexoriumHatchGreen, BlockHexoriumHatch.UNLOCALISEDNAME + "Green");
        blockHexoriumHatchTurquoise = new BlockHexoriumHatch(BlockHexoriumHatch.UNLOCALISEDNAME + "Turquoise");
        GameRegistry.registerBlock(blockHexoriumHatchTurquoise, BlockHexoriumHatch.UNLOCALISEDNAME + "Turquoise");
        blockHexoriumHatchCyan = new BlockHexoriumHatch(BlockHexoriumHatch.UNLOCALISEDNAME + "Cyan");
        GameRegistry.registerBlock(blockHexoriumHatchCyan, BlockHexoriumHatch.UNLOCALISEDNAME + "Cyan");
        blockHexoriumHatchSkyBlue = new BlockHexoriumHatch(BlockHexoriumHatch.UNLOCALISEDNAME + "SkyBlue");
        GameRegistry.registerBlock(blockHexoriumHatchSkyBlue, BlockHexoriumHatch.UNLOCALISEDNAME + "SkyBlue");
        blockHexoriumHatchBlue = new BlockHexoriumHatch(BlockHexoriumHatch.UNLOCALISEDNAME + "Blue");
        GameRegistry.registerBlock(blockHexoriumHatchBlue, BlockHexoriumHatch.UNLOCALISEDNAME + "Blue");
        blockHexoriumHatchPurple = new BlockHexoriumHatch(BlockHexoriumHatch.UNLOCALISEDNAME + "Purple");
        GameRegistry.registerBlock(blockHexoriumHatchPurple, BlockHexoriumHatch.UNLOCALISEDNAME + "Purple");
        blockHexoriumHatchMagenta = new BlockHexoriumHatch(BlockHexoriumHatch.UNLOCALISEDNAME + "Magenta");
        GameRegistry.registerBlock(blockHexoriumHatchMagenta, BlockHexoriumHatch.UNLOCALISEDNAME + "Magenta");
        blockHexoriumHatchPink = new BlockHexoriumHatch(BlockHexoriumHatch.UNLOCALISEDNAME + "Pink");
        GameRegistry.registerBlock(blockHexoriumHatchPink, BlockHexoriumHatch.UNLOCALISEDNAME + "Pink");

        blockHexoriumHatchWhite = new BlockHexoriumHatch(BlockHexoriumHatch.UNLOCALISEDNAME + "White");
        GameRegistry.registerBlock(blockHexoriumHatchWhite, BlockHexoriumHatch.UNLOCALISEDNAME + "White");
        blockHexoriumHatchLightGray = new BlockHexoriumHatch(BlockHexoriumHatch.UNLOCALISEDNAME + "LightGray");
        GameRegistry.registerBlock(blockHexoriumHatchLightGray, BlockHexoriumHatch.UNLOCALISEDNAME + "LightGray");
        blockHexoriumHatchGray = new BlockHexoriumHatch(BlockHexoriumHatch.UNLOCALISEDNAME + "Gray");
        GameRegistry.registerBlock(blockHexoriumHatchGray, BlockHexoriumHatch.UNLOCALISEDNAME + "Gray");
        blockHexoriumHatchDarkGray = new BlockHexoriumHatch(BlockHexoriumHatch.UNLOCALISEDNAME + "DarkGray");
        GameRegistry.registerBlock(blockHexoriumHatchDarkGray, BlockHexoriumHatch.UNLOCALISEDNAME + "DarkGray");
        blockHexoriumHatchBlack = new BlockHexoriumHatch(BlockHexoriumHatch.UNLOCALISEDNAME + "Black");
        GameRegistry.registerBlock(blockHexoriumHatchBlack, BlockHexoriumHatch.UNLOCALISEDNAME + "Black");

        blockHexoriumHatchRainbow = new BlockHexoriumHatch(BlockHexoriumHatch.UNLOCALISEDNAME + "Rainbow");
        GameRegistry.registerBlock(blockHexoriumHatchRainbow, BlockHexoriumHatch.UNLOCALISEDNAME + "Rainbow");


        // Machines
        blockHexoriumMachineBlock = new BlockHexoriumMachineBlock(BlockHexoriumMachineBlock.UNLOCALISEDNAME);
        GameRegistry.registerBlock(blockHexoriumMachineBlock, BlockHexoriumMachineBlock.UNLOCALISEDNAME);

        blockHexoriumGenerator = new BlockHexoriumGenerator(BlockHexoriumGenerator.UNLOCALISEDNAME);
        GameRegistry.registerBlock(blockHexoriumGenerator, BlockHexoriumGenerator.UNLOCALISEDNAME);
        blockHexoriumFurnace = new BlockHexoriumFurnace(BlockHexoriumFurnace.UNLOCALISEDNAME);
        GameRegistry.registerBlock(blockHexoriumFurnace, BlockHexoriumFurnace.UNLOCALISEDNAME);
        blockCrystalSeparator = new BlockCrystalSeparator(BlockCrystalSeparator.UNLOCALISEDNAME);
        GameRegistry.registerBlock(blockCrystalSeparator, BlockCrystalSeparator.UNLOCALISEDNAME);
        blockMatrixReconstructor = new BlockMatrixReconstructor(BlockMatrixReconstructor.UNLOCALISEDNAME);
        GameRegistry.registerBlock(blockMatrixReconstructor, BlockMatrixReconstructor.UNLOCALISEDNAME);

        if (HexConfig.cfgTeleportEnable) {
            blockPersonalTeleportationPad = new BlockPersonalTeleportationPad(BlockPersonalTeleportationPad.UNLOCALISEDNAME);
            GameRegistry.registerBlock(blockPersonalTeleportationPad, BlockPersonalTeleportationPad.UNLOCALISEDNAME);
        }

        // Tank Valve
        blockTankValve = new BlockTankValve(BlockTankValve.UNLOCALISEDNAME);
        GameRegistry.registerBlock(blockTankValve, BlockTankValve.UNLOCALISEDNAME);
        blockTankRender = new BlockTankRender(BlockTankRender.UNLOCALISEDNAME);
        GameRegistry.registerBlock(blockTankRender, BlockTankRender.UNLOCALISEDNAME);

        // Cables
        blockHexoriumCableRed = new BlockHexoriumCable(BlockHexoriumCable.UNLOCALISEDNAME + "Red");
        GameRegistry.registerBlock(blockHexoriumCableRed, BlockHexoriumCable.UNLOCALISEDNAME + "Red");
        blockHexoriumCableOrange = new BlockHexoriumCable(BlockHexoriumCable.UNLOCALISEDNAME + "Orange");
        GameRegistry.registerBlock(blockHexoriumCableOrange, BlockHexoriumCable.UNLOCALISEDNAME + "Orange");
        blockHexoriumCableYellow = new BlockHexoriumCable(BlockHexoriumCable.UNLOCALISEDNAME + "Yellow");
        GameRegistry.registerBlock(blockHexoriumCableYellow, BlockHexoriumCable.UNLOCALISEDNAME + "Yellow");
        blockHexoriumCableLime = new BlockHexoriumCable(BlockHexoriumCable.UNLOCALISEDNAME + "Lime");
        GameRegistry.registerBlock(blockHexoriumCableLime, BlockHexoriumCable.UNLOCALISEDNAME + "Lime");
        blockHexoriumCableGreen = new BlockHexoriumCable(BlockHexoriumCable.UNLOCALISEDNAME + "Green");
        GameRegistry.registerBlock(blockHexoriumCableGreen, BlockHexoriumCable.UNLOCALISEDNAME + "Green");
        blockHexoriumCableTurquoise = new BlockHexoriumCable(BlockHexoriumCable.UNLOCALISEDNAME + "Turquoise");
        GameRegistry.registerBlock(blockHexoriumCableTurquoise, BlockHexoriumCable.UNLOCALISEDNAME + "Turquoise");
        blockHexoriumCableCyan = new BlockHexoriumCable(BlockHexoriumCable.UNLOCALISEDNAME + "Cyan");
        GameRegistry.registerBlock(blockHexoriumCableCyan, BlockHexoriumCable.UNLOCALISEDNAME + "Cyan");
        blockHexoriumCableSkyBlue = new BlockHexoriumCable(BlockHexoriumCable.UNLOCALISEDNAME + "SkyBlue");
        GameRegistry.registerBlock(blockHexoriumCableSkyBlue, BlockHexoriumCable.UNLOCALISEDNAME + "SkyBlue");
        blockHexoriumCableBlue = new BlockHexoriumCable(BlockHexoriumCable.UNLOCALISEDNAME + "Blue");
        GameRegistry.registerBlock(blockHexoriumCableBlue, BlockHexoriumCable.UNLOCALISEDNAME + "Blue");
        blockHexoriumCablePurple = new BlockHexoriumCable(BlockHexoriumCable.UNLOCALISEDNAME + "Purple");
        GameRegistry.registerBlock(blockHexoriumCablePurple, BlockHexoriumCable.UNLOCALISEDNAME + "Purple");
        blockHexoriumCableMagenta = new BlockHexoriumCable(BlockHexoriumCable.UNLOCALISEDNAME + "Magenta");
        GameRegistry.registerBlock(blockHexoriumCableMagenta, BlockHexoriumCable.UNLOCALISEDNAME + "Magenta");
        blockHexoriumCablePink = new BlockHexoriumCable(BlockHexoriumCable.UNLOCALISEDNAME + "Pink");
        GameRegistry.registerBlock(blockHexoriumCablePink, BlockHexoriumCable.UNLOCALISEDNAME + "Pink");
        
        blockHexoriumCableWhite = new BlockHexoriumCable(BlockHexoriumCable.UNLOCALISEDNAME + "White");
        GameRegistry.registerBlock(blockHexoriumCableWhite, BlockHexoriumCable.UNLOCALISEDNAME + "White");
        blockHexoriumCableLightGray = new BlockHexoriumCable(BlockHexoriumCable.UNLOCALISEDNAME + "LightGray");
        GameRegistry.registerBlock(blockHexoriumCableLightGray, BlockHexoriumCable.UNLOCALISEDNAME + "LightGray");
        blockHexoriumCableGray = new BlockHexoriumCable(BlockHexoriumCable.UNLOCALISEDNAME + "Gray");
        GameRegistry.registerBlock(blockHexoriumCableGray, BlockHexoriumCable.UNLOCALISEDNAME + "Gray");
        blockHexoriumCableDarkGray = new BlockHexoriumCable(BlockHexoriumCable.UNLOCALISEDNAME + "DarkGray");
        GameRegistry.registerBlock(blockHexoriumCableDarkGray, BlockHexoriumCable.UNLOCALISEDNAME + "DarkGray");
        blockHexoriumCableBlack = new BlockHexoriumCable(BlockHexoriumCable.UNLOCALISEDNAME + "Black");
        GameRegistry.registerBlock(blockHexoriumCableBlack, BlockHexoriumCable.UNLOCALISEDNAME + "Black");

        blockHexoriumCableRainbow = new BlockHexoriumCable(BlockHexoriumCable.UNLOCALISEDNAME + "Rainbow");
        GameRegistry.registerBlock(blockHexoriumCableRainbow, BlockHexoriumCable.UNLOCALISEDNAME + "Rainbow");
        
        // Energy Pylon
        blockEnergyPylon = new BlockEnergyPylon(BlockEnergyPylon.UNLOCALISEDNAME);
        GameRegistry.registerBlock(blockEnergyPylon, BlockEnergyPylon.UNLOCALISEDNAME);

        // Hexorium Switch
        blockHexoriumSwitchRedGreen = new BlockHexoriumSwitch(BlockHexoriumSwitch.UNLOCALISEDNAME + "RedGreen");
        GameRegistry.registerBlock(blockHexoriumSwitchRedGreen, BlockHexoriumSwitch.UNLOCALISEDNAME + "RedGreen");
        blockHexoriumSwitchRedBlue = new BlockHexoriumSwitch(BlockHexoriumSwitch.UNLOCALISEDNAME + "RedBlue");
        GameRegistry.registerBlock(blockHexoriumSwitchRedBlue, BlockHexoriumSwitch.UNLOCALISEDNAME + "RedBlue");
        blockHexoriumSwitchRedWhite = new BlockHexoriumSwitch(BlockHexoriumSwitch.UNLOCALISEDNAME + "RedWhite");
        GameRegistry.registerBlock(blockHexoriumSwitchRedWhite, BlockHexoriumSwitch.UNLOCALISEDNAME + "RedWhite");

        // Hexorium Button
        blockHexoriumButtonRed = new BlockHexoriumButton(BlockHexoriumButton.UNLOCALISEDNAME + "Red");
        GameRegistry.registerBlock(blockHexoriumButtonRed, BlockHexoriumButton.UNLOCALISEDNAME + "Red");
        blockHexoriumButtonGreen = new BlockHexoriumButton(BlockHexoriumButton.UNLOCALISEDNAME + "Green");
        GameRegistry.registerBlock(blockHexoriumButtonGreen, BlockHexoriumButton.UNLOCALISEDNAME + "Green");
        blockHexoriumButtonBlue = new BlockHexoriumButton(BlockHexoriumButton.UNLOCALISEDNAME + "Blue");
        GameRegistry.registerBlock(blockHexoriumButtonBlue, BlockHexoriumButton.UNLOCALISEDNAME + "Blue");
        blockHexoriumButtonWhite = new BlockHexoriumButton(BlockHexoriumButton.UNLOCALISEDNAME + "White");
        GameRegistry.registerBlock(blockHexoriumButtonWhite, BlockHexoriumButton.UNLOCALISEDNAME + "White");

        // Hexorium Pressure Plate
        blockHexoriumPressurePlateRed = new BlockHexoriumPressurePlate(BlockHexoriumPressurePlate.UNLOCALISEDNAME + "Red");
        GameRegistry.registerBlock(blockHexoriumPressurePlateRed, BlockHexoriumPressurePlate.UNLOCALISEDNAME + "Red");
        blockHexoriumPressurePlateGreen = new BlockHexoriumPressurePlate(BlockHexoriumPressurePlate.UNLOCALISEDNAME + "Green");
        GameRegistry.registerBlock(blockHexoriumPressurePlateGreen, BlockHexoriumPressurePlate.UNLOCALISEDNAME + "Green");
        blockHexoriumPressurePlateBlue = new BlockHexoriumPressurePlate(BlockHexoriumPressurePlate.UNLOCALISEDNAME + "Blue");
        GameRegistry.registerBlock(blockHexoriumPressurePlateBlue, BlockHexoriumPressurePlate.UNLOCALISEDNAME + "Blue");
        blockHexoriumPressurePlateWhite = new BlockHexoriumPressurePlate(BlockHexoriumPressurePlate.UNLOCALISEDNAME + "White");
        GameRegistry.registerBlock(blockHexoriumPressurePlateWhite, BlockHexoriumPressurePlate.UNLOCALISEDNAME + "White");

        // Regular Blocks
        blockTemperedHexoriumGlass = new BlockTemperedHexoriumGlass(BlockTemperedHexoriumGlass.UNLOCALISEDNAME);
        GameRegistry.registerBlock(blockTemperedHexoriumGlass, BlockTemperedHexoriumGlass.UNLOCALISEDNAME);

        blockPylonBase51 = new BlockPylonBase(BlockPylonBase.UNLOCALISEDNAME + "51", false);
        GameRegistry.registerBlock(blockPylonBase51, BlockPylonBase.UNLOCALISEDNAME + "51");
        blockPylonBase15 = new BlockPylonBase(BlockPylonBase.UNLOCALISEDNAME + "15", true);
        GameRegistry.registerBlock(blockPylonBase15, BlockPylonBase.UNLOCALISEDNAME + "15");
    }

    public static void updateMachineState(int status, World world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);

        if (status == 1 && meta < 4)
            meta = meta + 4;
        else if (status == 1 && meta >= 8)
            meta = meta - 4;
        else if (status == 0 && meta >= 4 && meta < 8)
            meta = meta - 4;
        else if (status == 0 && meta >= 8)
            meta = meta - 8;
        else if (status == 2 && meta < 4)
            meta = meta + 8;
        else if (status == 2 && meta >= 4 && meta < 8)
            meta = meta + 4;

        world.setBlockMetadataWithNotify(x, y, z, meta, 2);
    }
}
