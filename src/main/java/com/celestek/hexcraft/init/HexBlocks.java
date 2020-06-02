package com.celestek.hexcraft.init;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.*;
import com.celestek.hexcraft.util.HexEnums;
import com.celestek.hexcraft.util.HexUtils;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class HexBlocks {

    // Meta Bits
    public static final int META_MACHINE_ROTATION_0 = 0;
    public static final int META_MACHINE_ROTATION_1 = 1;
    public static final int META_MACHINE_STATUS_0 = 2;
    public static final int META_MACHINE_STATUS_1 = 3;
    public static final int META_DECORATIVE_REINFORCED = 0;
    public static final int META_STRUCTURE_IS_PART = 1;

    // Machine States
    public static final int MACHINE_STATE_READY = 0;
    public static final int MACHINE_STATE_ACTIVE = 1;
    public static final int MACHINE_STATE_DEAD = 2;

    // Decorative Variants
    public static final int DECORATIVE_VARIANT_BLACK = 0;
    public static final int DECORATIVE_VARIANT_WHITE = 1;

    /**
     * ADDING NEW BLOCKS
     * To add a new block:
     * 1) Increment countBlocks.
     * 2) Add a public static Block.
     * 3) Add the 2 required lines to initializeBlocks() (Check other blocks).
     * 4) Add the 2 required lines to HexClientProxy.setCustomRenderers() (Check other blocks).
     */

    // Total count of blocks to add.
    public static final int countBlocks = 517;

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

    public static Block blockFramedHexoriumBlockWhiteRed;
    public static Block blockFramedHexoriumBlockWhiteOrange;
    public static Block blockFramedHexoriumBlockWhiteYellow;
    public static Block blockFramedHexoriumBlockWhiteLime;
    public static Block blockFramedHexoriumBlockWhiteGreen;
    public static Block blockFramedHexoriumBlockWhiteTurquoise;
    public static Block blockFramedHexoriumBlockWhiteCyan;
    public static Block blockFramedHexoriumBlockWhiteSkyBlue;
    public static Block blockFramedHexoriumBlockWhiteBlue;
    public static Block blockFramedHexoriumBlockWhitePurple;
    public static Block blockFramedHexoriumBlockWhiteMagenta;
    public static Block blockFramedHexoriumBlockWhitePink;

    public static Block blockFramedHexoriumBlockWhiteWhite;
    public static Block blockFramedHexoriumBlockWhiteLightGray;
    public static Block blockFramedHexoriumBlockWhiteGray;
    public static Block blockFramedHexoriumBlockWhiteDarkGray;
    public static Block blockFramedHexoriumBlockWhiteBlack;

    public static Block blockFramedHexoriumBlockWhiteRainbow;

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

    public static Block blockPlatedHexoriumBlockWhiteRed;
    public static Block blockPlatedHexoriumBlockWhiteOrange;
    public static Block blockPlatedHexoriumBlockWhiteYellow;
    public static Block blockPlatedHexoriumBlockWhiteLime;
    public static Block blockPlatedHexoriumBlockWhiteGreen;
    public static Block blockPlatedHexoriumBlockWhiteTurquoise;
    public static Block blockPlatedHexoriumBlockWhiteCyan;
    public static Block blockPlatedHexoriumBlockWhiteSkyBlue;
    public static Block blockPlatedHexoriumBlockWhiteBlue;
    public static Block blockPlatedHexoriumBlockWhitePurple;
    public static Block blockPlatedHexoriumBlockWhiteMagenta;
    public static Block blockPlatedHexoriumBlockWhitePink;

    public static Block blockPlatedHexoriumBlockWhiteWhite;
    public static Block blockPlatedHexoriumBlockWhiteLightGray;
    public static Block blockPlatedHexoriumBlockWhiteGray;
    public static Block blockPlatedHexoriumBlockWhiteDarkGray;
    public static Block blockPlatedHexoriumBlockWhiteBlack;

    public static Block blockPlatedHexoriumBlockWhiteRainbow;

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

    public static Block blockConcentricHexoriumBlockWhiteRed;
    public static Block blockConcentricHexoriumBlockWhiteOrange;
    public static Block blockConcentricHexoriumBlockWhiteYellow;
    public static Block blockConcentricHexoriumBlockWhiteLime;
    public static Block blockConcentricHexoriumBlockWhiteGreen;
    public static Block blockConcentricHexoriumBlockWhiteTurquoise;
    public static Block blockConcentricHexoriumBlockWhiteCyan;
    public static Block blockConcentricHexoriumBlockWhiteSkyBlue;
    public static Block blockConcentricHexoriumBlockWhiteBlue;
    public static Block blockConcentricHexoriumBlockWhitePurple;
    public static Block blockConcentricHexoriumBlockWhiteMagenta;
    public static Block blockConcentricHexoriumBlockWhitePink;

    public static Block blockConcentricHexoriumBlockWhiteWhite;
    public static Block blockConcentricHexoriumBlockWhiteLightGray;
    public static Block blockConcentricHexoriumBlockWhiteGray;
    public static Block blockConcentricHexoriumBlockWhiteDarkGray;
    public static Block blockConcentricHexoriumBlockWhiteBlack;

    public static Block blockConcentricHexoriumBlockWhiteRainbow;

    // Hexorium Structure Casing
    public static Block blockHexoriumStructureCasingRed;
    public static Block blockHexoriumStructureCasingOrange;
    public static Block blockHexoriumStructureCasingYellow;
    public static Block blockHexoriumStructureCasingLime;
    public static Block blockHexoriumStructureCasingGreen;
    public static Block blockHexoriumStructureCasingTurquoise;
    public static Block blockHexoriumStructureCasingCyan;
    public static Block blockHexoriumStructureCasingSkyBlue;
    public static Block blockHexoriumStructureCasingBlue;
    public static Block blockHexoriumStructureCasingPurple;
    public static Block blockHexoriumStructureCasingMagenta;
    public static Block blockHexoriumStructureCasingPink;

    public static Block blockHexoriumStructureCasingWhite;
    public static Block blockHexoriumStructureCasingLightGray;
    public static Block blockHexoriumStructureCasingGray;
    public static Block blockHexoriumStructureCasingDarkGray;
    public static Block blockHexoriumStructureCasingBlack;

    public static Block blockHexoriumStructureCasingRainbow;

    public static Block blockHexoriumStructureCasingWhiteRed;
    public static Block blockHexoriumStructureCasingWhiteOrange;
    public static Block blockHexoriumStructureCasingWhiteYellow;
    public static Block blockHexoriumStructureCasingWhiteLime;
    public static Block blockHexoriumStructureCasingWhiteGreen;
    public static Block blockHexoriumStructureCasingWhiteTurquoise;
    public static Block blockHexoriumStructureCasingWhiteCyan;
    public static Block blockHexoriumStructureCasingWhiteSkyBlue;
    public static Block blockHexoriumStructureCasingWhiteBlue;
    public static Block blockHexoriumStructureCasingWhitePurple;
    public static Block blockHexoriumStructureCasingWhiteMagenta;
    public static Block blockHexoriumStructureCasingWhitePink;

    public static Block blockHexoriumStructureCasingWhiteWhite;
    public static Block blockHexoriumStructureCasingWhiteLightGray;
    public static Block blockHexoriumStructureCasingWhiteGray;
    public static Block blockHexoriumStructureCasingWhiteDarkGray;
    public static Block blockHexoriumStructureCasingWhiteBlack;

    public static Block blockHexoriumStructureCasingWhiteRainbow;

    // Glowing Hexorium-Coated Stone
    public static Block blockGlowingHexoriumCoatedStoneRed;
    public static Block blockGlowingHexoriumCoatedStoneOrange;
    public static Block blockGlowingHexoriumCoatedStoneYellow;
    public static Block blockGlowingHexoriumCoatedStoneLime;
    public static Block blockGlowingHexoriumCoatedStoneGreen;
    public static Block blockGlowingHexoriumCoatedStoneTurquoise;
    public static Block blockGlowingHexoriumCoatedStoneCyan;
    public static Block blockGlowingHexoriumCoatedStoneSkyBlue;
    public static Block blockGlowingHexoriumCoatedStoneBlue;
    public static Block blockGlowingHexoriumCoatedStonePurple;
    public static Block blockGlowingHexoriumCoatedStoneMagenta;
    public static Block blockGlowingHexoriumCoatedStonePink;

    public static Block blockGlowingHexoriumCoatedStoneWhite;
    public static Block blockGlowingHexoriumCoatedStoneLightGray;
    public static Block blockGlowingHexoriumCoatedStoneGray;
    public static Block blockGlowingHexoriumCoatedStoneDarkGray;
    public static Block blockGlowingHexoriumCoatedStoneBlack;

    public static Block blockGlowingHexoriumCoatedStoneRainbow;

    public static Block blockGlowingHexoriumCoatedStoneWhiteRed;
    public static Block blockGlowingHexoriumCoatedStoneWhiteOrange;
    public static Block blockGlowingHexoriumCoatedStoneWhiteYellow;
    public static Block blockGlowingHexoriumCoatedStoneWhiteLime;
    public static Block blockGlowingHexoriumCoatedStoneWhiteGreen;
    public static Block blockGlowingHexoriumCoatedStoneWhiteTurquoise;
    public static Block blockGlowingHexoriumCoatedStoneWhiteCyan;
    public static Block blockGlowingHexoriumCoatedStoneWhiteSkyBlue;
    public static Block blockGlowingHexoriumCoatedStoneWhiteBlue;
    public static Block blockGlowingHexoriumCoatedStoneWhitePurple;
    public static Block blockGlowingHexoriumCoatedStoneWhiteMagenta;
    public static Block blockGlowingHexoriumCoatedStoneWhitePink;

    public static Block blockGlowingHexoriumCoatedStoneWhiteWhite;
    public static Block blockGlowingHexoriumCoatedStoneWhiteLightGray;
    public static Block blockGlowingHexoriumCoatedStoneWhiteGray;
    public static Block blockGlowingHexoriumCoatedStoneWhiteDarkGray;
    public static Block blockGlowingHexoriumCoatedStoneWhiteBlack;

    public static Block blockGlowingHexoriumCoatedStoneWhiteRainbow;

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

    public static Block blockGlowingHexoriumGlassWhiteRed;
    public static Block blockGlowingHexoriumGlassWhiteOrange;
    public static Block blockGlowingHexoriumGlassWhiteYellow;
    public static Block blockGlowingHexoriumGlassWhiteLime;
    public static Block blockGlowingHexoriumGlassWhiteGreen;
    public static Block blockGlowingHexoriumGlassWhiteTurquoise;
    public static Block blockGlowingHexoriumGlassWhiteCyan;
    public static Block blockGlowingHexoriumGlassWhiteSkyBlue;
    public static Block blockGlowingHexoriumGlassWhiteBlue;
    public static Block blockGlowingHexoriumGlassWhitePurple;
    public static Block blockGlowingHexoriumGlassWhiteMagenta;
    public static Block blockGlowingHexoriumGlassWhitePink;

    public static Block blockGlowingHexoriumGlassWhiteWhite;
    public static Block blockGlowingHexoriumGlassWhiteLightGray;
    public static Block blockGlowingHexoriumGlassWhiteGray;
    public static Block blockGlowingHexoriumGlassWhiteDarkGray;
    public static Block blockGlowingHexoriumGlassWhiteBlack;

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

    public static Block blockHexoriumLampWhiteRed;
    public static Block blockHexoriumLampWhiteOrange;
    public static Block blockHexoriumLampWhiteYellow;
    public static Block blockHexoriumLampWhiteLime;
    public static Block blockHexoriumLampWhiteGreen;
    public static Block blockHexoriumLampWhiteTurquoise;
    public static Block blockHexoriumLampWhiteCyan;
    public static Block blockHexoriumLampWhiteSkyBlue;
    public static Block blockHexoriumLampWhiteBlue;
    public static Block blockHexoriumLampWhitePurple;
    public static Block blockHexoriumLampWhiteMagenta;
    public static Block blockHexoriumLampWhitePink;

    public static Block blockHexoriumLampWhiteWhite;
    public static Block blockHexoriumLampWhiteLightGray;
    public static Block blockHexoriumLampWhiteGray;
    public static Block blockHexoriumLampWhiteDarkGray;
    public static Block blockHexoriumLampWhiteBlack;

    public static Block blockHexoriumLampWhiteRainbow;

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

    public static Block blockHexoriumLampInvWhiteRed;
    public static Block blockHexoriumLampInvWhiteOrange;
    public static Block blockHexoriumLampInvWhiteYellow;
    public static Block blockHexoriumLampInvWhiteLime;
    public static Block blockHexoriumLampInvWhiteGreen;
    public static Block blockHexoriumLampInvWhiteTurquoise;
    public static Block blockHexoriumLampInvWhiteCyan;
    public static Block blockHexoriumLampInvWhiteSkyBlue;
    public static Block blockHexoriumLampInvWhiteBlue;
    public static Block blockHexoriumLampInvWhitePurple;
    public static Block blockHexoriumLampInvWhiteMagenta;
    public static Block blockHexoriumLampInvWhitePink;

    public static Block blockHexoriumLampInvWhiteWhite;
    public static Block blockHexoriumLampInvWhiteLightGray;
    public static Block blockHexoriumLampInvWhiteGray;
    public static Block blockHexoriumLampInvWhiteDarkGray;
    public static Block blockHexoriumLampInvWhiteBlack;

    public static Block blockHexoriumLampInvWhiteRainbow;

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

    public static Block blockHexoriumDoorWhiteRed;
    public static Block blockHexoriumDoorWhiteOrange;
    public static Block blockHexoriumDoorWhiteYellow;
    public static Block blockHexoriumDoorWhiteLime;
    public static Block blockHexoriumDoorWhiteGreen;
    public static Block blockHexoriumDoorWhiteTurquoise;
    public static Block blockHexoriumDoorWhiteCyan;
    public static Block blockHexoriumDoorWhiteSkyBlue;
    public static Block blockHexoriumDoorWhiteBlue;
    public static Block blockHexoriumDoorWhitePurple;
    public static Block blockHexoriumDoorWhiteMagenta;
    public static Block blockHexoriumDoorWhitePink;

    public static Block blockHexoriumDoorWhiteWhite;
    public static Block blockHexoriumDoorWhiteLightGray;
    public static Block blockHexoriumDoorWhiteGray;
    public static Block blockHexoriumDoorWhiteDarkGray;
    public static Block blockHexoriumDoorWhiteBlack;

    public static Block blockHexoriumDoorWhiteRainbow;

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

    public static Block blockHexoriumHatchWhiteRed;
    public static Block blockHexoriumHatchWhiteOrange;
    public static Block blockHexoriumHatchWhiteYellow;
    public static Block blockHexoriumHatchWhiteLime;
    public static Block blockHexoriumHatchWhiteGreen;
    public static Block blockHexoriumHatchWhiteTurquoise;
    public static Block blockHexoriumHatchWhiteCyan;
    public static Block blockHexoriumHatchWhiteSkyBlue;
    public static Block blockHexoriumHatchWhiteBlue;
    public static Block blockHexoriumHatchWhitePurple;
    public static Block blockHexoriumHatchWhiteMagenta;
    public static Block blockHexoriumHatchWhitePink;

    public static Block blockHexoriumHatchWhiteWhite;
    public static Block blockHexoriumHatchWhiteLightGray;
    public static Block blockHexoriumHatchWhiteGray;
    public static Block blockHexoriumHatchWhiteDarkGray;
    public static Block blockHexoriumHatchWhiteBlack;

    public static Block blockHexoriumHatchWhiteRainbow;

    // Machines
    public static Block blockHexoriumMachineBlock;
    public static Block blockAdvancedRainbowCore;

    public static Block blockHexoriumGenerator;
    public static Block blockHexoriumFurnace;
    public static Block blockCrystalSeparator;
    public static Block blockMatrixReconstructor;

    public static Block blockPersonalTeleportationPad;

    public static Block blockQuantumObserver;
    public static Block blockQuantumAnchor;

    // Hexiroum Valve
    public static Block blockTankValve;
    public static Block blockTankRender;
    
    // Energy Node
    public static Block blockEnergyNodeCoreT1;
    public static Block blockEnergyNodeCoreT2;
    public static Block blockEnergyNodeCoreT3;
    public static Block blockEnergyNodeCoreT4;

    public static Block blockEnergyNodePortHEX;
    public static Block blockEnergyNodePortRF;
    public static Block blockEnergyNodePortEU;

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
    public static Block blockHexoriumSwitchBlueGreen;

    public static Block blockHexoriumSwitchWhiteRedGreen;
    public static Block blockHexoriumSwitchWhiteRedBlue;
    public static Block blockHexoriumSwitchWhiteRedWhite;
    public static Block blockHexoriumSwitchWhiteBlueGreen;

    // Hexorium Button
    public static Block blockHexoriumButtonRed;
    public static Block blockHexoriumButtonGreen;
    public static Block blockHexoriumButtonBlue;
    public static Block blockHexoriumButtonWhite;

    public static Block blockHexoriumButtonWhiteRed;
    public static Block blockHexoriumButtonWhiteGreen;
    public static Block blockHexoriumButtonWhiteBlue;
    public static Block blockHexoriumButtonWhiteWhite;

    // Hexorium Pressure Plate
    public static Block blockHexoriumPressurePlateRed;
    public static Block blockHexoriumPressurePlateGreen;
    public static Block blockHexoriumPressurePlateBlue;
    public static Block blockHexoriumPressurePlateWhite;

    public static Block blockHexoriumPressurePlateWhiteRed;
    public static Block blockHexoriumPressurePlateWhiteGreen;
    public static Block blockHexoriumPressurePlateWhiteBlue;
    public static Block blockHexoriumPressurePlateWhiteWhite;

    // Regular Blocks
    public static Block blockTemperedHexoriumGlass;
    public static Block blockTemperedHexoriumGlassWhite;
    public static Block blockHexoriumCoatedStone;
    public static Block blockHexoriumCoatedStoneWhite;

    public static Block blockPylonBase51;
    public static Block blockPylonBase15;

    public static Block blockSoundProjector;

    /**
     * Initializes all block and adds them to GameRegistry.
     */
    public static void initializeBlocks() {
        // Prepare HexCraft's block ID counter.
        HexCraft.idCounter = 0;

        // Hexorium Nether NetherOre
        blockHexoriumNetherOreRed = new BlockHexoriumNetherOre(BlockHexoriumNetherOre.ID + "Red", 1, 2);
        GameRegistry.registerBlock(blockHexoriumNetherOreRed, BlockHexoriumNetherOre.ID + "Red");
        blockHexoriumNetherOreGreen = new BlockHexoriumNetherOre(BlockHexoriumNetherOre.ID + "Green", 1, 2);
        GameRegistry.registerBlock(blockHexoriumNetherOreGreen, BlockHexoriumNetherOre.ID + "Green");
        blockHexoriumNetherOreBlue = new BlockHexoriumNetherOre(BlockHexoriumNetherOre.ID + "Blue", 1, 2);
        GameRegistry.registerBlock(blockHexoriumNetherOreBlue, BlockHexoriumNetherOre.ID + "Blue");
        
        blockHexoriumNetherOreWhite = new BlockHexoriumNetherOre(BlockHexoriumNetherOre.ID + "White", 2, 4);
        GameRegistry.registerBlock(blockHexoriumNetherOreWhite, BlockHexoriumNetherOre.ID + "White");
        blockHexoriumNetherOreBlack = new BlockHexoriumNetherOre(BlockHexoriumNetherOre.ID + "Black", 2, 4);
        GameRegistry.registerBlock(blockHexoriumNetherOreBlack, BlockHexoriumNetherOre.ID + "Black");

        // Hexorium Ore
        blockHexoriumOreRed = new BlockHexoriumOre(BlockHexoriumOre.ID + "Red", 2, 4);
        GameRegistry.registerBlock(blockHexoriumOreRed, BlockHexoriumOre.ID + "Red");
        blockHexoriumOreGreen = new BlockHexoriumOre(BlockHexoriumOre.ID + "Green", 2, 4);
        GameRegistry.registerBlock(blockHexoriumOreGreen, BlockHexoriumOre.ID + "Green");
        blockHexoriumOreBlue = new BlockHexoriumOre(BlockHexoriumOre.ID + "Blue", 2, 4);
        GameRegistry.registerBlock(blockHexoriumOreBlue, BlockHexoriumOre.ID + "Blue");
        
        blockHexoriumOreWhite = new BlockHexoriumOre(BlockHexoriumOre.ID + "White", 1, 2);
        GameRegistry.registerBlock(blockHexoriumOreWhite, BlockHexoriumOre.ID + "White");
        blockHexoriumOreBlack = new BlockHexoriumOre(BlockHexoriumOre.ID + "Black", 1, 2);
        GameRegistry.registerBlock(blockHexoriumOreBlack, BlockHexoriumOre.ID + "Black");

        // Hexorium Monolith
        blockHexoriumMonolithRed = new BlockHexoriumMonolith(BlockHexoriumMonolith.ID + "Red", 6, 8);
        GameRegistry.registerBlock(blockHexoriumMonolithRed, BlockHexoriumMonolith.ID + "Red");
        blockHexoriumMonolithGreen = new BlockHexoriumMonolith(BlockHexoriumMonolith.ID + "Green", 6, 8);
        GameRegistry.registerBlock(blockHexoriumMonolithGreen, BlockHexoriumMonolith.ID + "Green");
        blockHexoriumMonolithBlue = new BlockHexoriumMonolith(BlockHexoriumMonolith.ID + "Blue", 6, 8);
        GameRegistry.registerBlock(blockHexoriumMonolithBlue, BlockHexoriumMonolith.ID + "Blue");

        blockHexoriumMonolithWhite = new BlockHexoriumMonolith(BlockHexoriumMonolith.ID + "White", 2, 4);
        GameRegistry.registerBlock(blockHexoriumMonolithWhite, BlockHexoriumMonolith.ID + "White");
        blockHexoriumMonolithBlack = new BlockHexoriumMonolith(BlockHexoriumMonolith.ID + "Black", 2, 4);
        GameRegistry.registerBlock(blockHexoriumMonolithBlack, BlockHexoriumMonolith.ID + "Black");
        
        // Hexorium Nether Monolith
        blockHexoriumNetherMonolithRed = new BlockHexoriumNetherMonolith(BlockHexoriumNetherMonolith.ID + "Red", 2, 4);
        GameRegistry.registerBlock(blockHexoriumNetherMonolithRed, BlockHexoriumNetherMonolith.ID + "Red");
        blockHexoriumNetherMonolithGreen = new BlockHexoriumNetherMonolith(BlockHexoriumNetherMonolith.ID + "Green", 2, 4);
        GameRegistry.registerBlock(blockHexoriumNetherMonolithGreen, BlockHexoriumNetherMonolith.ID + "Green");
        blockHexoriumNetherMonolithBlue = new BlockHexoriumNetherMonolith(BlockHexoriumNetherMonolith.ID + "Blue", 2, 4);
        GameRegistry.registerBlock(blockHexoriumNetherMonolithBlue, BlockHexoriumNetherMonolith.ID + "Blue");

        blockHexoriumNetherMonolithWhite = new BlockHexoriumNetherMonolith(BlockHexoriumNetherMonolith.ID + "White", 6, 8);
        GameRegistry.registerBlock(blockHexoriumNetherMonolithWhite, BlockHexoriumNetherMonolith.ID + "White");
        blockHexoriumNetherMonolithBlack = new BlockHexoriumNetherMonolith(BlockHexoriumNetherMonolith.ID + "Black", 6, 8);
        GameRegistry.registerBlock(blockHexoriumNetherMonolithBlack, BlockHexoriumNetherMonolith.ID + "Black");

        // Block of Hexorium Crystal
        blockOfHexoriumCrystalRed = new BlockOfHexoriumCrystal(BlockOfHexoriumCrystal.ID + "Red");
        GameRegistry.registerBlock(blockOfHexoriumCrystalRed, BlockOfHexoriumCrystal.ID + "Red");
        blockOfHexoriumCrystalGreen = new BlockOfHexoriumCrystal(BlockOfHexoriumCrystal.ID + "Green");
        GameRegistry.registerBlock(blockOfHexoriumCrystalGreen, BlockOfHexoriumCrystal.ID + "Green");
        blockOfHexoriumCrystalBlue = new BlockOfHexoriumCrystal(BlockOfHexoriumCrystal.ID + "Blue");
        GameRegistry.registerBlock(blockOfHexoriumCrystalBlue, BlockOfHexoriumCrystal.ID + "Blue");
        
        blockOfHexoriumCrystalWhite = new BlockOfHexoriumCrystal(BlockOfHexoriumCrystal.ID + "White");
        GameRegistry.registerBlock(blockOfHexoriumCrystalWhite, BlockOfHexoriumCrystal.ID + "White");
        blockOfHexoriumCrystalBlack = new BlockOfHexoriumCrystal(BlockOfHexoriumCrystal.ID + "Black");
        GameRegistry.registerBlock(blockOfHexoriumCrystalBlack, BlockOfHexoriumCrystal.ID + "Black");
        
        // Energized Hexorium
        blockEnergizedHexoriumRed = new BlockEnergizedHexorium(BlockEnergizedHexorium.ID + "Red");
        GameRegistry.registerBlock(blockEnergizedHexoriumRed, BlockEnergizedHexorium.ID + "Red");
        blockEnergizedHexoriumOrange = new BlockEnergizedHexorium(BlockEnergizedHexorium.ID + "Orange");
        GameRegistry.registerBlock(blockEnergizedHexoriumOrange, BlockEnergizedHexorium.ID + "Orange");
        blockEnergizedHexoriumYellow = new BlockEnergizedHexorium(BlockEnergizedHexorium.ID + "Yellow");
        GameRegistry.registerBlock(blockEnergizedHexoriumYellow, BlockEnergizedHexorium.ID + "Yellow");
        blockEnergizedHexoriumLime = new BlockEnergizedHexorium(BlockEnergizedHexorium.ID + "Lime");
        GameRegistry.registerBlock(blockEnergizedHexoriumLime, BlockEnergizedHexorium.ID + "Lime");
        blockEnergizedHexoriumGreen = new BlockEnergizedHexorium(BlockEnergizedHexorium.ID + "Green");
        GameRegistry.registerBlock(blockEnergizedHexoriumGreen, BlockEnergizedHexorium.ID + "Green");
        blockEnergizedHexoriumTurquoise = new BlockEnergizedHexorium(BlockEnergizedHexorium.ID + "Turquoise");
        GameRegistry.registerBlock(blockEnergizedHexoriumTurquoise, BlockEnergizedHexorium.ID + "Turquoise");
        blockEnergizedHexoriumCyan = new BlockEnergizedHexorium(BlockEnergizedHexorium.ID + "Cyan");
        GameRegistry.registerBlock(blockEnergizedHexoriumCyan, BlockEnergizedHexorium.ID + "Cyan");
        blockEnergizedHexoriumSkyBlue = new BlockEnergizedHexorium(BlockEnergizedHexorium.ID + "SkyBlue");
        GameRegistry.registerBlock(blockEnergizedHexoriumSkyBlue, BlockEnergizedHexorium.ID + "SkyBlue");
        blockEnergizedHexoriumBlue = new BlockEnergizedHexorium(BlockEnergizedHexorium.ID + "Blue");
        GameRegistry.registerBlock(blockEnergizedHexoriumBlue, BlockEnergizedHexorium.ID + "Blue");
        blockEnergizedHexoriumPurple = new BlockEnergizedHexorium(BlockEnergizedHexorium.ID + "Purple");
        GameRegistry.registerBlock(blockEnergizedHexoriumPurple, BlockEnergizedHexorium.ID + "Purple");
        blockEnergizedHexoriumMagenta = new BlockEnergizedHexorium(BlockEnergizedHexorium.ID + "Magenta");
        GameRegistry.registerBlock(blockEnergizedHexoriumMagenta, BlockEnergizedHexorium.ID + "Magenta");
        blockEnergizedHexoriumPink = new BlockEnergizedHexorium(BlockEnergizedHexorium.ID + "Pink");
        GameRegistry.registerBlock(blockEnergizedHexoriumPink, BlockEnergizedHexorium.ID + "Pink");
        
        blockEnergizedHexoriumWhite = new BlockEnergizedHexorium(BlockEnergizedHexorium.ID + "White");
        GameRegistry.registerBlock(blockEnergizedHexoriumWhite, BlockEnergizedHexorium.ID + "White");
        blockEnergizedHexoriumLightGray = new BlockEnergizedHexorium(BlockEnergizedHexorium.ID + "LightGray");
        GameRegistry.registerBlock(blockEnergizedHexoriumLightGray, BlockEnergizedHexorium.ID + "LightGray");
        blockEnergizedHexoriumGray = new BlockEnergizedHexorium(BlockEnergizedHexorium.ID + "Gray");
        GameRegistry.registerBlock(blockEnergizedHexoriumGray, BlockEnergizedHexorium.ID + "Gray");
        blockEnergizedHexoriumDarkGray = new BlockEnergizedHexorium(BlockEnergizedHexorium.ID + "DarkGray");
        GameRegistry.registerBlock(blockEnergizedHexoriumDarkGray, BlockEnergizedHexorium.ID + "DarkGray");
        blockEnergizedHexoriumBlack = new BlockEnergizedHexorium(BlockEnergizedHexorium.ID + "Black");
        GameRegistry.registerBlock(blockEnergizedHexoriumBlack, BlockEnergizedHexorium.ID + "Black");
        
        blockEnergizedHexoriumRainbow = new BlockEnergizedHexorium(BlockEnergizedHexorium.ID + "Rainbow");
        GameRegistry.registerBlock(blockEnergizedHexoriumRainbow, BlockEnergizedHexorium.ID + "Rainbow");

        BlockEngineeredHexoriumBlock.registerBlocks();
        BlockFramedHexoriumBlock.registerBlocks();
        BlockPlatedHexoriumBlock.registerBlocks();
        BlockConcentricHexoriumBlock.registerBlocks();

        // Hexorium Structure Casing
        blockHexoriumStructureCasingRed = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_BLACK + "Red", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumStructureCasingRed, BlockHexoriumStructureCasing.ID_BLACK + "Red");
        blockHexoriumStructureCasingOrange = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_BLACK + "Orange", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumStructureCasingOrange, BlockHexoriumStructureCasing.ID_BLACK + "Orange");
        blockHexoriumStructureCasingYellow = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_BLACK + "Yellow", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumStructureCasingYellow, BlockHexoriumStructureCasing.ID_BLACK + "Yellow");
        blockHexoriumStructureCasingLime = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_BLACK + "Lime", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumStructureCasingLime, BlockHexoriumStructureCasing.ID_BLACK + "Lime");
        blockHexoriumStructureCasingGreen = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_BLACK + "Green", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumStructureCasingGreen, BlockHexoriumStructureCasing.ID_BLACK + "Green");
        blockHexoriumStructureCasingTurquoise = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_BLACK + "Turquoise", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumStructureCasingTurquoise, BlockHexoriumStructureCasing.ID_BLACK + "Turquoise");
        blockHexoriumStructureCasingCyan = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_BLACK + "Cyan", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumStructureCasingCyan, BlockHexoriumStructureCasing.ID_BLACK + "Cyan");
        blockHexoriumStructureCasingSkyBlue = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_BLACK + "SkyBlue", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumStructureCasingSkyBlue, BlockHexoriumStructureCasing.ID_BLACK + "SkyBlue");
        blockHexoriumStructureCasingBlue = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_BLACK + "Blue", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumStructureCasingBlue, BlockHexoriumStructureCasing.ID_BLACK + "Blue");
        blockHexoriumStructureCasingPurple = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_BLACK + "Purple", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumStructureCasingPurple, BlockHexoriumStructureCasing.ID_BLACK + "Purple");
        blockHexoriumStructureCasingMagenta = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_BLACK + "Magenta", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumStructureCasingMagenta, BlockHexoriumStructureCasing.ID_BLACK + "Magenta");
        blockHexoriumStructureCasingPink = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_BLACK + "Pink", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumStructureCasingPink, BlockHexoriumStructureCasing.ID_BLACK + "Pink");

        blockHexoriumStructureCasingWhite = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_BLACK + "White", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumStructureCasingWhite, BlockHexoriumStructureCasing.ID_BLACK + "White");
        blockHexoriumStructureCasingLightGray = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_BLACK + "LightGray", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumStructureCasingLightGray, BlockHexoriumStructureCasing.ID_BLACK + "LightGray");
        blockHexoriumStructureCasingGray = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_BLACK + "Gray", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumStructureCasingGray, BlockHexoriumStructureCasing.ID_BLACK + "Gray");
        blockHexoriumStructureCasingDarkGray = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_BLACK + "DarkGray", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumStructureCasingDarkGray, BlockHexoriumStructureCasing.ID_BLACK + "DarkGray");
        blockHexoriumStructureCasingBlack = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_BLACK + "Black", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumStructureCasingBlack, BlockHexoriumStructureCasing.ID_BLACK + "Black");

        blockHexoriumStructureCasingRainbow = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_BLACK + "Rainbow", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumStructureCasingRainbow, BlockHexoriumStructureCasing.ID_BLACK + "Rainbow");

        blockHexoriumStructureCasingWhiteRed = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_WHITE + "Red", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumStructureCasingWhiteRed, BlockHexoriumStructureCasing.ID_WHITE + "Red");
        blockHexoriumStructureCasingWhiteOrange = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_WHITE + "Orange", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumStructureCasingWhiteOrange, BlockHexoriumStructureCasing.ID_WHITE + "Orange");
        blockHexoriumStructureCasingWhiteYellow = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_WHITE + "Yellow", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumStructureCasingWhiteYellow, BlockHexoriumStructureCasing.ID_WHITE + "Yellow");
        blockHexoriumStructureCasingWhiteLime = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_WHITE + "Lime", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumStructureCasingWhiteLime, BlockHexoriumStructureCasing.ID_WHITE + "Lime");
        blockHexoriumStructureCasingWhiteGreen = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_WHITE + "Green", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumStructureCasingWhiteGreen, BlockHexoriumStructureCasing.ID_WHITE + "Green");
        blockHexoriumStructureCasingWhiteTurquoise = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_WHITE + "Turquoise", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumStructureCasingWhiteTurquoise, BlockHexoriumStructureCasing.ID_WHITE + "Turquoise");
        blockHexoriumStructureCasingWhiteCyan = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_WHITE + "Cyan", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumStructureCasingWhiteCyan, BlockHexoriumStructureCasing.ID_WHITE + "Cyan");
        blockHexoriumStructureCasingWhiteSkyBlue = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_WHITE + "SkyBlue", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumStructureCasingWhiteSkyBlue, BlockHexoriumStructureCasing.ID_WHITE + "SkyBlue");
        blockHexoriumStructureCasingWhiteBlue = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_WHITE + "Blue", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumStructureCasingWhiteBlue, BlockHexoriumStructureCasing.ID_WHITE + "Blue");
        blockHexoriumStructureCasingWhitePurple = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_WHITE + "Purple", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumStructureCasingWhitePurple, BlockHexoriumStructureCasing.ID_WHITE + "Purple");
        blockHexoriumStructureCasingWhiteMagenta = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_WHITE + "Magenta", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumStructureCasingWhiteMagenta, BlockHexoriumStructureCasing.ID_WHITE + "Magenta");
        blockHexoriumStructureCasingWhitePink = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_WHITE + "Pink", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumStructureCasingWhitePink, BlockHexoriumStructureCasing.ID_WHITE + "Pink");

        blockHexoriumStructureCasingWhiteWhite = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_WHITE + "White", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumStructureCasingWhiteWhite, BlockHexoriumStructureCasing.ID_WHITE + "White");
        blockHexoriumStructureCasingWhiteLightGray = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_WHITE + "LightGray", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumStructureCasingWhiteLightGray, BlockHexoriumStructureCasing.ID_WHITE + "LightGray");
        blockHexoriumStructureCasingWhiteGray = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_WHITE + "Gray", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumStructureCasingWhiteGray, BlockHexoriumStructureCasing.ID_WHITE + "Gray");
        blockHexoriumStructureCasingWhiteDarkGray = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_WHITE + "DarkGray", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumStructureCasingWhiteDarkGray, BlockHexoriumStructureCasing.ID_WHITE + "DarkGray");
        blockHexoriumStructureCasingWhiteBlack = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_WHITE + "Black", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumStructureCasingWhiteBlack, BlockHexoriumStructureCasing.ID_WHITE + "Black");

        blockHexoriumStructureCasingWhiteRainbow = new BlockHexoriumStructureCasing(BlockHexoriumStructureCasing.ID_WHITE + "Rainbow", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumStructureCasingWhiteRainbow, BlockHexoriumStructureCasing.ID_WHITE + "Rainbow");

        // Glowing Hexorium-Coated Stone
        blockGlowingHexoriumCoatedStoneRed = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_BLACK + "Red", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneRed, BlockGlowingHexoriumCoatedStone.ID_BLACK + "Red");
        blockGlowingHexoriumCoatedStoneOrange = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_BLACK + "Orange", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneOrange, BlockGlowingHexoriumCoatedStone.ID_BLACK + "Orange");
        blockGlowingHexoriumCoatedStoneYellow = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_BLACK + "Yellow", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneYellow, BlockGlowingHexoriumCoatedStone.ID_BLACK + "Yellow");
        blockGlowingHexoriumCoatedStoneLime = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_BLACK + "Lime", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneLime, BlockGlowingHexoriumCoatedStone.ID_BLACK + "Lime");
        blockGlowingHexoriumCoatedStoneGreen = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_BLACK + "Green", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneGreen, BlockGlowingHexoriumCoatedStone.ID_BLACK + "Green");
        blockGlowingHexoriumCoatedStoneTurquoise = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_BLACK + "Turquoise", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneTurquoise, BlockGlowingHexoriumCoatedStone.ID_BLACK + "Turquoise");
        blockGlowingHexoriumCoatedStoneCyan = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_BLACK + "Cyan", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneCyan, BlockGlowingHexoriumCoatedStone.ID_BLACK + "Cyan");
        blockGlowingHexoriumCoatedStoneSkyBlue = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_BLACK + "SkyBlue", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneSkyBlue, BlockGlowingHexoriumCoatedStone.ID_BLACK + "SkyBlue");
        blockGlowingHexoriumCoatedStoneBlue = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_BLACK + "Blue", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneBlue, BlockGlowingHexoriumCoatedStone.ID_BLACK + "Blue");
        blockGlowingHexoriumCoatedStonePurple = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_BLACK + "Purple", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStonePurple, BlockGlowingHexoriumCoatedStone.ID_BLACK + "Purple");
        blockGlowingHexoriumCoatedStoneMagenta = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_BLACK + "Magenta", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneMagenta, BlockGlowingHexoriumCoatedStone.ID_BLACK + "Magenta");
        blockGlowingHexoriumCoatedStonePink = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_BLACK + "Pink", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStonePink, BlockGlowingHexoriumCoatedStone.ID_BLACK + "Pink");

        blockGlowingHexoriumCoatedStoneWhite = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_BLACK + "White", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneWhite, BlockGlowingHexoriumCoatedStone.ID_BLACK + "White");
        blockGlowingHexoriumCoatedStoneLightGray = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_BLACK + "LightGray", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneLightGray, BlockGlowingHexoriumCoatedStone.ID_BLACK + "LightGray");
        blockGlowingHexoriumCoatedStoneGray = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_BLACK + "Gray", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneGray, BlockGlowingHexoriumCoatedStone.ID_BLACK + "Gray");
        blockGlowingHexoriumCoatedStoneDarkGray = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_BLACK + "DarkGray", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneDarkGray, BlockGlowingHexoriumCoatedStone.ID_BLACK + "DarkGray");
        blockGlowingHexoriumCoatedStoneBlack = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_BLACK + "Black", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneBlack, BlockGlowingHexoriumCoatedStone.ID_BLACK + "Black");

        blockGlowingHexoriumCoatedStoneRainbow = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_BLACK + "Rainbow", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneRainbow, BlockGlowingHexoriumCoatedStone.ID_BLACK + "Rainbow");

        blockGlowingHexoriumCoatedStoneWhiteRed = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_WHITE + "Red", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneWhiteRed, BlockGlowingHexoriumCoatedStone.ID_WHITE + "Red");
        blockGlowingHexoriumCoatedStoneWhiteOrange = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_WHITE + "Orange", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneWhiteOrange, BlockGlowingHexoriumCoatedStone.ID_WHITE + "Orange");
        blockGlowingHexoriumCoatedStoneWhiteYellow = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_WHITE + "Yellow", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneWhiteYellow, BlockGlowingHexoriumCoatedStone.ID_WHITE + "Yellow");
        blockGlowingHexoriumCoatedStoneWhiteLime = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_WHITE + "Lime", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneWhiteLime, BlockGlowingHexoriumCoatedStone.ID_WHITE + "Lime");
        blockGlowingHexoriumCoatedStoneWhiteGreen = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_WHITE + "Green", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneWhiteGreen, BlockGlowingHexoriumCoatedStone.ID_WHITE + "Green");
        blockGlowingHexoriumCoatedStoneWhiteTurquoise = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_WHITE + "Turquoise", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneWhiteTurquoise, BlockGlowingHexoriumCoatedStone.ID_WHITE + "Turquoise");
        blockGlowingHexoriumCoatedStoneWhiteCyan = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_WHITE + "Cyan", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneWhiteCyan, BlockGlowingHexoriumCoatedStone.ID_WHITE + "Cyan");
        blockGlowingHexoriumCoatedStoneWhiteSkyBlue = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_WHITE + "SkyBlue", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneWhiteSkyBlue, BlockGlowingHexoriumCoatedStone.ID_WHITE + "SkyBlue");
        blockGlowingHexoriumCoatedStoneWhiteBlue = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_WHITE + "Blue", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneWhiteBlue, BlockGlowingHexoriumCoatedStone.ID_WHITE + "Blue");
        blockGlowingHexoriumCoatedStoneWhitePurple = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_WHITE + "Purple", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneWhitePurple, BlockGlowingHexoriumCoatedStone.ID_WHITE + "Purple");
        blockGlowingHexoriumCoatedStoneWhiteMagenta = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_WHITE + "Magenta", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneWhiteMagenta, BlockGlowingHexoriumCoatedStone.ID_WHITE + "Magenta");
        blockGlowingHexoriumCoatedStoneWhitePink = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_WHITE + "Pink", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneWhitePink, BlockGlowingHexoriumCoatedStone.ID_WHITE + "Pink");

        blockGlowingHexoriumCoatedStoneWhiteWhite = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_WHITE + "White", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneWhiteWhite, BlockGlowingHexoriumCoatedStone.ID_WHITE + "White");
        blockGlowingHexoriumCoatedStoneWhiteLightGray = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_WHITE + "LightGray", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneWhiteLightGray, BlockGlowingHexoriumCoatedStone.ID_WHITE + "LightGray");
        blockGlowingHexoriumCoatedStoneWhiteGray = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_WHITE + "Gray", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneWhiteGray, BlockGlowingHexoriumCoatedStone.ID_WHITE + "Gray");
        blockGlowingHexoriumCoatedStoneWhiteDarkGray = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_WHITE + "DarkGray", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneWhiteDarkGray, BlockGlowingHexoriumCoatedStone.ID_WHITE + "DarkGray");
        blockGlowingHexoriumCoatedStoneWhiteBlack = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_WHITE + "Black", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneWhiteBlack, BlockGlowingHexoriumCoatedStone.ID_WHITE + "Black");

        blockGlowingHexoriumCoatedStoneWhiteRainbow = new BlockGlowingHexoriumCoatedStone(BlockGlowingHexoriumCoatedStone.ID_WHITE + "Rainbow", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumCoatedStoneWhiteRainbow, BlockGlowingHexoriumCoatedStone.ID_WHITE + "Rainbow");

        // Glowing Hexorium Glass
        blockGlowingHexoriumGlassRed = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_BLACK + "Red", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassRed, BlockGlowingHexoriumGlass.ID_BLACK + "Red");
        blockGlowingHexoriumGlassOrange = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_BLACK + "Orange", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassOrange, BlockGlowingHexoriumGlass.ID_BLACK + "Orange");
        blockGlowingHexoriumGlassYellow = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_BLACK + "Yellow", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassYellow, BlockGlowingHexoriumGlass.ID_BLACK + "Yellow");
        blockGlowingHexoriumGlassLime = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_BLACK + "Lime", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassLime, BlockGlowingHexoriumGlass.ID_BLACK + "Lime");
        blockGlowingHexoriumGlassGreen = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_BLACK + "Green", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassGreen, BlockGlowingHexoriumGlass.ID_BLACK + "Green");
        blockGlowingHexoriumGlassTurquoise = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_BLACK + "Turquoise", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassTurquoise, BlockGlowingHexoriumGlass.ID_BLACK + "Turquoise");
        blockGlowingHexoriumGlassCyan = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_BLACK + "Cyan", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassCyan, BlockGlowingHexoriumGlass.ID_BLACK + "Cyan");
        blockGlowingHexoriumGlassSkyBlue = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_BLACK + "SkyBlue", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassSkyBlue, BlockGlowingHexoriumGlass.ID_BLACK + "SkyBlue");
        blockGlowingHexoriumGlassBlue = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_BLACK + "Blue", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassBlue, BlockGlowingHexoriumGlass.ID_BLACK + "Blue");
        blockGlowingHexoriumGlassPurple = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_BLACK + "Purple", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassPurple, BlockGlowingHexoriumGlass.ID_BLACK + "Purple");
        blockGlowingHexoriumGlassMagenta = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_BLACK + "Magenta", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassMagenta, BlockGlowingHexoriumGlass.ID_BLACK + "Magenta");
        blockGlowingHexoriumGlassPink = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_BLACK + "Pink", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassPink, BlockGlowingHexoriumGlass.ID_BLACK + "Pink");

        blockGlowingHexoriumGlassWhite = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_BLACK + "White", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassWhite, BlockGlowingHexoriumGlass.ID_BLACK + "White");
        blockGlowingHexoriumGlassLightGray = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_BLACK + "LightGray", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassLightGray, BlockGlowingHexoriumGlass.ID_BLACK + "LightGray");
        blockGlowingHexoriumGlassGray = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_BLACK + "Gray", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassGray, BlockGlowingHexoriumGlass.ID_BLACK + "Gray");
        blockGlowingHexoriumGlassDarkGray = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_BLACK + "DarkGray", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassDarkGray, BlockGlowingHexoriumGlass.ID_BLACK + "DarkGray");
        blockGlowingHexoriumGlassBlack = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_BLACK + "Black", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassBlack, BlockGlowingHexoriumGlass.ID_BLACK + "Black");

        blockGlowingHexoriumGlassWhiteRed = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_WHITE + "Red", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassWhiteRed, BlockGlowingHexoriumGlass.ID_WHITE + "Red");
        blockGlowingHexoriumGlassWhiteOrange = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_WHITE + "Orange", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassWhiteOrange, BlockGlowingHexoriumGlass.ID_WHITE + "Orange");
        blockGlowingHexoriumGlassWhiteYellow = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_WHITE + "Yellow", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassWhiteYellow, BlockGlowingHexoriumGlass.ID_WHITE + "Yellow");
        blockGlowingHexoriumGlassWhiteLime = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_WHITE + "Lime", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassWhiteLime, BlockGlowingHexoriumGlass.ID_WHITE + "Lime");
        blockGlowingHexoriumGlassWhiteGreen = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_WHITE + "Green", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassWhiteGreen, BlockGlowingHexoriumGlass.ID_WHITE + "Green");
        blockGlowingHexoriumGlassWhiteTurquoise = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_WHITE + "Turquoise", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassWhiteTurquoise, BlockGlowingHexoriumGlass.ID_WHITE + "Turquoise");
        blockGlowingHexoriumGlassWhiteCyan = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_WHITE + "Cyan", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassWhiteCyan, BlockGlowingHexoriumGlass.ID_WHITE + "Cyan");
        blockGlowingHexoriumGlassWhiteSkyBlue = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_WHITE + "SkyBlue", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassWhiteSkyBlue, BlockGlowingHexoriumGlass.ID_WHITE + "SkyBlue");
        blockGlowingHexoriumGlassWhiteBlue = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_WHITE + "Blue", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassWhiteBlue, BlockGlowingHexoriumGlass.ID_WHITE + "Blue");
        blockGlowingHexoriumGlassWhitePurple = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_WHITE + "Purple", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassWhitePurple, BlockGlowingHexoriumGlass.ID_WHITE + "Purple");
        blockGlowingHexoriumGlassWhiteMagenta = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_WHITE + "Magenta", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassWhiteMagenta, BlockGlowingHexoriumGlass.ID_WHITE + "Magenta");
        blockGlowingHexoriumGlassWhitePink = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_WHITE + "Pink", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassWhitePink, BlockGlowingHexoriumGlass.ID_WHITE + "Pink");

        blockGlowingHexoriumGlassWhiteWhite = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_WHITE + "White", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassWhiteWhite, BlockGlowingHexoriumGlass.ID_WHITE + "White");
        blockGlowingHexoriumGlassWhiteLightGray = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_WHITE + "LightGray", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassWhiteLightGray, BlockGlowingHexoriumGlass.ID_WHITE + "LightGray");
        blockGlowingHexoriumGlassWhiteGray = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_WHITE + "Gray", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassWhiteGray, BlockGlowingHexoriumGlass.ID_WHITE + "Gray");
        blockGlowingHexoriumGlassWhiteDarkGray = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_WHITE + "DarkGray", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassWhiteDarkGray, BlockGlowingHexoriumGlass.ID_WHITE + "DarkGray");
        blockGlowingHexoriumGlassWhiteBlack = new BlockGlowingHexoriumGlass(BlockGlowingHexoriumGlass.ID_WHITE + "Black", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockGlowingHexoriumGlassWhiteBlack, BlockGlowingHexoriumGlass.ID_WHITE + "Black");
        
        // Energized Hexorium Monolith
        blockEnergizedHexoriumMonolithRed = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.ID + "Red");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithRed, BlockEnergizedHexoriumMonolith.ID + "Red");
        blockEnergizedHexoriumMonolithOrange = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.ID + "Orange");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithOrange, BlockEnergizedHexoriumMonolith.ID + "Orange");
        blockEnergizedHexoriumMonolithYellow = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.ID + "Yellow");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithYellow, BlockEnergizedHexoriumMonolith.ID + "Yellow");
        blockEnergizedHexoriumMonolithLime = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.ID + "Lime");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithLime, BlockEnergizedHexoriumMonolith.ID + "Lime");
        blockEnergizedHexoriumMonolithGreen = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.ID + "Green");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithGreen, BlockEnergizedHexoriumMonolith.ID + "Green");
        blockEnergizedHexoriumMonolithTurquoise = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.ID + "Turquoise");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithTurquoise, BlockEnergizedHexoriumMonolith.ID + "Turquoise");
        blockEnergizedHexoriumMonolithCyan = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.ID + "Cyan");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithCyan, BlockEnergizedHexoriumMonolith.ID + "Cyan");
        blockEnergizedHexoriumMonolithSkyBlue = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.ID + "SkyBlue");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithSkyBlue, BlockEnergizedHexoriumMonolith.ID + "SkyBlue");
        blockEnergizedHexoriumMonolithBlue = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.ID + "Blue");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithBlue, BlockEnergizedHexoriumMonolith.ID + "Blue");
        blockEnergizedHexoriumMonolithPurple = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.ID + "Purple");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithPurple, BlockEnergizedHexoriumMonolith.ID + "Purple");
        blockEnergizedHexoriumMonolithMagenta = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.ID + "Magenta");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithMagenta, BlockEnergizedHexoriumMonolith.ID + "Magenta");
        blockEnergizedHexoriumMonolithPink = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.ID + "Pink");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithPink, BlockEnergizedHexoriumMonolith.ID + "Pink");

        blockEnergizedHexoriumMonolithWhite = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.ID + "White");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithWhite, BlockEnergizedHexoriumMonolith.ID + "White");
        blockEnergizedHexoriumMonolithLightGray = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.ID + "LightGray");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithLightGray, BlockEnergizedHexoriumMonolith.ID + "LightGray");
        blockEnergizedHexoriumMonolithGray = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.ID + "Gray");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithGray, BlockEnergizedHexoriumMonolith.ID + "Gray");
        blockEnergizedHexoriumMonolithDarkGray = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.ID + "DarkGray");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithDarkGray, BlockEnergizedHexoriumMonolith.ID + "DarkGray");
        blockEnergizedHexoriumMonolithBlack = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.ID + "Black");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithBlack, BlockEnergizedHexoriumMonolith.ID + "Black");

        blockEnergizedHexoriumMonolithRainbow = new BlockEnergizedHexoriumMonolith(BlockEnergizedHexoriumMonolith.ID + "Rainbow");
        GameRegistry.registerBlock(blockEnergizedHexoriumMonolithRainbow, BlockEnergizedHexoriumMonolith.ID + "Rainbow");

        // Hexorium Lamp
        blockHexoriumLampRed = new BlockHexoriumLamp(BlockHexoriumLamp.ID_BLACK + "Red", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampRed, BlockHexoriumLamp.ID_BLACK + "Red");
        blockHexoriumLampOrange = new BlockHexoriumLamp(BlockHexoriumLamp.ID_BLACK + "Orange", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampOrange, BlockHexoriumLamp.ID_BLACK + "Orange");
        blockHexoriumLampYellow = new BlockHexoriumLamp(BlockHexoriumLamp.ID_BLACK + "Yellow", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampYellow, BlockHexoriumLamp.ID_BLACK + "Yellow");
        blockHexoriumLampLime = new BlockHexoriumLamp(BlockHexoriumLamp.ID_BLACK + "Lime", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampLime, BlockHexoriumLamp.ID_BLACK + "Lime");
        blockHexoriumLampGreen = new BlockHexoriumLamp(BlockHexoriumLamp.ID_BLACK + "Green", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampGreen, BlockHexoriumLamp.ID_BLACK + "Green");
        blockHexoriumLampTurquoise = new BlockHexoriumLamp(BlockHexoriumLamp.ID_BLACK + "Turquoise", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampTurquoise, BlockHexoriumLamp.ID_BLACK + "Turquoise");
        blockHexoriumLampCyan = new BlockHexoriumLamp(BlockHexoriumLamp.ID_BLACK + "Cyan", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampCyan, BlockHexoriumLamp.ID_BLACK + "Cyan");
        blockHexoriumLampSkyBlue = new BlockHexoriumLamp(BlockHexoriumLamp.ID_BLACK + "SkyBlue", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampSkyBlue, BlockHexoriumLamp.ID_BLACK + "SkyBlue");
        blockHexoriumLampBlue = new BlockHexoriumLamp(BlockHexoriumLamp.ID_BLACK + "Blue", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampBlue, BlockHexoriumLamp.ID_BLACK + "Blue");
        blockHexoriumLampPurple = new BlockHexoriumLamp(BlockHexoriumLamp.ID_BLACK + "Purple", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampPurple, BlockHexoriumLamp.ID_BLACK + "Purple");
        blockHexoriumLampMagenta = new BlockHexoriumLamp(BlockHexoriumLamp.ID_BLACK + "Magenta", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampMagenta, BlockHexoriumLamp.ID_BLACK + "Magenta");
        blockHexoriumLampPink = new BlockHexoriumLamp(BlockHexoriumLamp.ID_BLACK + "Pink", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampPink, BlockHexoriumLamp.ID_BLACK + "Pink");

        blockHexoriumLampWhite = new BlockHexoriumLamp(BlockHexoriumLamp.ID_BLACK + "White", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampWhite, BlockHexoriumLamp.ID_BLACK + "White");
        blockHexoriumLampLightGray = new BlockHexoriumLamp(BlockHexoriumLamp.ID_BLACK + "LightGray", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampLightGray, BlockHexoriumLamp.ID_BLACK + "LightGray");
        blockHexoriumLampGray = new BlockHexoriumLamp(BlockHexoriumLamp.ID_BLACK + "Gray", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampGray, BlockHexoriumLamp.ID_BLACK + "Gray");
        blockHexoriumLampDarkGray = new BlockHexoriumLamp(BlockHexoriumLamp.ID_BLACK + "DarkGray", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampDarkGray, BlockHexoriumLamp.ID_BLACK + "DarkGray");
        blockHexoriumLampBlack = new BlockHexoriumLamp(BlockHexoriumLamp.ID_BLACK + "Black", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampBlack, BlockHexoriumLamp.ID_BLACK + "Black");

        blockHexoriumLampRainbow = new BlockHexoriumLamp(BlockHexoriumLamp.ID_BLACK + "Rainbow", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampRainbow, BlockHexoriumLamp.ID_BLACK + "Rainbow");

        blockHexoriumLampWhiteRed = new BlockHexoriumLamp(BlockHexoriumLamp.ID_WHITE + "Red", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampWhiteRed, BlockHexoriumLamp.ID_WHITE + "Red");
        blockHexoriumLampWhiteOrange = new BlockHexoriumLamp(BlockHexoriumLamp.ID_WHITE + "Orange", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampWhiteOrange, BlockHexoriumLamp.ID_WHITE + "Orange");
        blockHexoriumLampWhiteYellow = new BlockHexoriumLamp(BlockHexoriumLamp.ID_WHITE + "Yellow", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampWhiteYellow, BlockHexoriumLamp.ID_WHITE + "Yellow");
        blockHexoriumLampWhiteLime = new BlockHexoriumLamp(BlockHexoriumLamp.ID_WHITE + "Lime", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampWhiteLime, BlockHexoriumLamp.ID_WHITE + "Lime");
        blockHexoriumLampWhiteGreen = new BlockHexoriumLamp(BlockHexoriumLamp.ID_WHITE + "Green", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampWhiteGreen, BlockHexoriumLamp.ID_WHITE + "Green");
        blockHexoriumLampWhiteTurquoise = new BlockHexoriumLamp(BlockHexoriumLamp.ID_WHITE + "Turquoise", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampWhiteTurquoise, BlockHexoriumLamp.ID_WHITE + "Turquoise");
        blockHexoriumLampWhiteCyan = new BlockHexoriumLamp(BlockHexoriumLamp.ID_WHITE + "Cyan", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampWhiteCyan, BlockHexoriumLamp.ID_WHITE + "Cyan");
        blockHexoriumLampWhiteSkyBlue = new BlockHexoriumLamp(BlockHexoriumLamp.ID_WHITE + "SkyBlue", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampWhiteSkyBlue, BlockHexoriumLamp.ID_WHITE + "SkyBlue");
        blockHexoriumLampWhiteBlue = new BlockHexoriumLamp(BlockHexoriumLamp.ID_WHITE + "Blue", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampWhiteBlue, BlockHexoriumLamp.ID_WHITE + "Blue");
        blockHexoriumLampWhitePurple = new BlockHexoriumLamp(BlockHexoriumLamp.ID_WHITE + "Purple", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampWhitePurple, BlockHexoriumLamp.ID_WHITE + "Purple");
        blockHexoriumLampWhiteMagenta = new BlockHexoriumLamp(BlockHexoriumLamp.ID_WHITE + "Magenta", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampWhiteMagenta, BlockHexoriumLamp.ID_WHITE + "Magenta");
        blockHexoriumLampWhitePink = new BlockHexoriumLamp(BlockHexoriumLamp.ID_WHITE + "Pink", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampWhitePink, BlockHexoriumLamp.ID_WHITE + "Pink");

        blockHexoriumLampWhiteWhite = new BlockHexoriumLamp(BlockHexoriumLamp.ID_WHITE + "White", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampWhiteWhite, BlockHexoriumLamp.ID_WHITE + "White");
        blockHexoriumLampWhiteLightGray = new BlockHexoriumLamp(BlockHexoriumLamp.ID_WHITE + "LightGray", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampWhiteLightGray, BlockHexoriumLamp.ID_WHITE + "LightGray");
        blockHexoriumLampWhiteGray = new BlockHexoriumLamp(BlockHexoriumLamp.ID_WHITE + "Gray", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampWhiteGray, BlockHexoriumLamp.ID_WHITE + "Gray");
        blockHexoriumLampWhiteDarkGray = new BlockHexoriumLamp(BlockHexoriumLamp.ID_WHITE + "DarkGray", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampWhiteDarkGray, BlockHexoriumLamp.ID_WHITE + "DarkGray");
        blockHexoriumLampWhiteBlack = new BlockHexoriumLamp(BlockHexoriumLamp.ID_WHITE + "Black", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampWhiteBlack, BlockHexoriumLamp.ID_WHITE + "Black");

        blockHexoriumLampWhiteRainbow = new BlockHexoriumLamp(BlockHexoriumLamp.ID_WHITE + "Rainbow", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampWhiteRainbow, BlockHexoriumLamp.ID_WHITE + "Rainbow");

        // Inverted Hexorium Lamp
        blockHexoriumLampInvRed = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_BLACK + "Red", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampInvRed, BlockHexoriumLampInv.ID_BLACK + "Red");
        blockHexoriumLampInvOrange = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_BLACK + "Orange", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampInvOrange, BlockHexoriumLampInv.ID_BLACK + "Orange");
        blockHexoriumLampInvYellow = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_BLACK + "Yellow", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampInvYellow, BlockHexoriumLampInv.ID_BLACK + "Yellow");
        blockHexoriumLampInvLime = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_BLACK + "Lime", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampInvLime, BlockHexoriumLampInv.ID_BLACK + "Lime");
        blockHexoriumLampInvGreen = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_BLACK + "Green", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampInvGreen, BlockHexoriumLampInv.ID_BLACK + "Green");
        blockHexoriumLampInvTurquoise = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_BLACK + "Turquoise", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampInvTurquoise, BlockHexoriumLampInv.ID_BLACK + "Turquoise");
        blockHexoriumLampInvCyan = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_BLACK + "Cyan", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampInvCyan, BlockHexoriumLampInv.ID_BLACK + "Cyan");
        blockHexoriumLampInvSkyBlue = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_BLACK + "SkyBlue", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampInvSkyBlue, BlockHexoriumLampInv.ID_BLACK + "SkyBlue");
        blockHexoriumLampInvBlue = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_BLACK + "Blue", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampInvBlue, BlockHexoriumLampInv.ID_BLACK + "Blue");
        blockHexoriumLampInvPurple = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_BLACK + "Purple", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampInvPurple, BlockHexoriumLampInv.ID_BLACK + "Purple");
        blockHexoriumLampInvMagenta = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_BLACK + "Magenta", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampInvMagenta, BlockHexoriumLampInv.ID_BLACK + "Magenta");
        blockHexoriumLampInvPink = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_BLACK + "Pink", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampInvPink, BlockHexoriumLampInv.ID_BLACK + "Pink");

        blockHexoriumLampInvWhite = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_BLACK + "White", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampInvWhite, BlockHexoriumLampInv.ID_BLACK + "White");
        blockHexoriumLampInvLightGray = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_BLACK + "LightGray", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampInvLightGray, BlockHexoriumLampInv.ID_BLACK + "LightGray");
        blockHexoriumLampInvGray = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_BLACK + "Gray", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampInvGray, BlockHexoriumLampInv.ID_BLACK + "Gray");
        blockHexoriumLampInvDarkGray = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_BLACK + "DarkGray", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampInvDarkGray, BlockHexoriumLampInv.ID_BLACK + "DarkGray");
        blockHexoriumLampInvBlack = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_BLACK + "Black", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampInvBlack, BlockHexoriumLampInv.ID_BLACK + "Black");

        blockHexoriumLampInvRainbow = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_BLACK + "Rainbow", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumLampInvRainbow, BlockHexoriumLampInv.ID_BLACK + "Rainbow");

        blockHexoriumLampInvWhiteRed = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_WHITE + "Red", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampInvWhiteRed, BlockHexoriumLampInv.ID_WHITE + "Red");
        blockHexoriumLampInvWhiteOrange = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_WHITE + "Orange", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampInvWhiteOrange, BlockHexoriumLampInv.ID_WHITE + "Orange");
        blockHexoriumLampInvWhiteYellow = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_WHITE + "Yellow", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampInvWhiteYellow, BlockHexoriumLampInv.ID_WHITE + "Yellow");
        blockHexoriumLampInvWhiteLime = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_WHITE + "Lime", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampInvWhiteLime, BlockHexoriumLampInv.ID_WHITE + "Lime");
        blockHexoriumLampInvWhiteGreen = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_WHITE + "Green", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampInvWhiteGreen, BlockHexoriumLampInv.ID_WHITE + "Green");
        blockHexoriumLampInvWhiteTurquoise = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_WHITE + "Turquoise", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampInvWhiteTurquoise, BlockHexoriumLampInv.ID_WHITE + "Turquoise");
        blockHexoriumLampInvWhiteCyan = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_WHITE + "Cyan", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampInvWhiteCyan, BlockHexoriumLampInv.ID_WHITE + "Cyan");
        blockHexoriumLampInvWhiteSkyBlue = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_WHITE + "SkyBlue", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampInvWhiteSkyBlue, BlockHexoriumLampInv.ID_WHITE + "SkyBlue");
        blockHexoriumLampInvWhiteBlue = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_WHITE + "Blue", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampInvWhiteBlue, BlockHexoriumLampInv.ID_WHITE + "Blue");
        blockHexoriumLampInvWhitePurple = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_WHITE + "Purple", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampInvWhitePurple, BlockHexoriumLampInv.ID_WHITE + "Purple");
        blockHexoriumLampInvWhiteMagenta = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_WHITE + "Magenta", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampInvWhiteMagenta, BlockHexoriumLampInv.ID_WHITE + "Magenta");
        blockHexoriumLampInvWhitePink = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_WHITE + "Pink", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampInvWhitePink, BlockHexoriumLampInv.ID_WHITE + "Pink");

        blockHexoriumLampInvWhiteWhite = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_WHITE + "White", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampInvWhiteWhite, BlockHexoriumLampInv.ID_WHITE + "White");
        blockHexoriumLampInvWhiteLightGray = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_WHITE + "LightGray", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampInvWhiteLightGray, BlockHexoriumLampInv.ID_WHITE + "LightGray");
        blockHexoriumLampInvWhiteGray = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_WHITE + "Gray", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampInvWhiteGray, BlockHexoriumLampInv.ID_WHITE + "Gray");
        blockHexoriumLampInvWhiteDarkGray = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_WHITE + "DarkGray", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampInvWhiteDarkGray, BlockHexoriumLampInv.ID_WHITE + "DarkGray");
        blockHexoriumLampInvWhiteBlack = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_WHITE + "Black", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampInvWhiteBlack, BlockHexoriumLampInv.ID_WHITE + "Black");

        blockHexoriumLampInvWhiteRainbow = new BlockHexoriumLampInv(BlockHexoriumLampInv.ID_WHITE + "Rainbow", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumLampInvWhiteRainbow, BlockHexoriumLampInv.ID_WHITE + "Rainbow");

        // Hexorium Door
        blockHexoriumDoorRed = new BlockHexoriumDoor(BlockHexoriumDoor.ID_BLACK + "Red", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumDoorRed, BlockHexoriumDoor.ID_BLACK + "Red");
        blockHexoriumDoorOrange = new BlockHexoriumDoor(BlockHexoriumDoor.ID_BLACK + "Orange", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumDoorOrange, BlockHexoriumDoor.ID_BLACK + "Orange");
        blockHexoriumDoorYellow = new BlockHexoriumDoor(BlockHexoriumDoor.ID_BLACK + "Yellow", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumDoorYellow, BlockHexoriumDoor.ID_BLACK + "Yellow");
        blockHexoriumDoorLime = new BlockHexoriumDoor(BlockHexoriumDoor.ID_BLACK + "Lime", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumDoorLime, BlockHexoriumDoor.ID_BLACK + "Lime");
        blockHexoriumDoorGreen = new BlockHexoriumDoor(BlockHexoriumDoor.ID_BLACK + "Green", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumDoorGreen, BlockHexoriumDoor.ID_BLACK + "Green");
        blockHexoriumDoorTurquoise = new BlockHexoriumDoor(BlockHexoriumDoor.ID_BLACK + "Turquoise", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumDoorTurquoise, BlockHexoriumDoor.ID_BLACK + "Turquoise");
        blockHexoriumDoorCyan = new BlockHexoriumDoor(BlockHexoriumDoor.ID_BLACK + "Cyan", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumDoorCyan, BlockHexoriumDoor.ID_BLACK + "Cyan");
        blockHexoriumDoorSkyBlue = new BlockHexoriumDoor(BlockHexoriumDoor.ID_BLACK + "SkyBlue", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumDoorSkyBlue, BlockHexoriumDoor.ID_BLACK + "SkyBlue");
        blockHexoriumDoorBlue = new BlockHexoriumDoor(BlockHexoriumDoor.ID_BLACK + "Blue", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumDoorBlue, BlockHexoriumDoor.ID_BLACK + "Blue");
        blockHexoriumDoorPurple = new BlockHexoriumDoor(BlockHexoriumDoor.ID_BLACK + "Purple", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumDoorPurple, BlockHexoriumDoor.ID_BLACK + "Purple");
        blockHexoriumDoorMagenta = new BlockHexoriumDoor(BlockHexoriumDoor.ID_BLACK + "Magenta", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumDoorMagenta, BlockHexoriumDoor.ID_BLACK + "Magenta");
        blockHexoriumDoorPink = new BlockHexoriumDoor(BlockHexoriumDoor.ID_BLACK + "Pink", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumDoorPink, BlockHexoriumDoor.ID_BLACK + "Pink");

        blockHexoriumDoorWhite = new BlockHexoriumDoor(BlockHexoriumDoor.ID_BLACK + "White", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumDoorWhite, BlockHexoriumDoor.ID_BLACK + "White");
        blockHexoriumDoorLightGray = new BlockHexoriumDoor(BlockHexoriumDoor.ID_BLACK + "LightGray", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumDoorLightGray, BlockHexoriumDoor.ID_BLACK + "LightGray");
        blockHexoriumDoorGray = new BlockHexoriumDoor(BlockHexoriumDoor.ID_BLACK + "Gray", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumDoorGray, BlockHexoriumDoor.ID_BLACK + "Gray");
        blockHexoriumDoorDarkGray = new BlockHexoriumDoor(BlockHexoriumDoor.ID_BLACK + "DarkGray", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumDoorDarkGray, BlockHexoriumDoor.ID_BLACK + "DarkGray");
        blockHexoriumDoorBlack = new BlockHexoriumDoor(BlockHexoriumDoor.ID_BLACK + "Black", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumDoorBlack, BlockHexoriumDoor.ID_BLACK + "Black");

        blockHexoriumDoorRainbow = new BlockHexoriumDoor(BlockHexoriumDoor.ID_BLACK + "Rainbow", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumDoorRainbow, BlockHexoriumDoor.ID_BLACK + "Rainbow");

        blockHexoriumDoorWhiteRed = new BlockHexoriumDoor(BlockHexoriumDoor.ID_WHITE + "Red", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumDoorWhiteRed, BlockHexoriumDoor.ID_WHITE + "Red");
        blockHexoriumDoorWhiteOrange = new BlockHexoriumDoor(BlockHexoriumDoor.ID_WHITE + "Orange", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumDoorWhiteOrange, BlockHexoriumDoor.ID_WHITE + "Orange");
        blockHexoriumDoorWhiteYellow = new BlockHexoriumDoor(BlockHexoriumDoor.ID_WHITE + "Yellow", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumDoorWhiteYellow, BlockHexoriumDoor.ID_WHITE + "Yellow");
        blockHexoriumDoorWhiteLime = new BlockHexoriumDoor(BlockHexoriumDoor.ID_WHITE + "Lime", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumDoorWhiteLime, BlockHexoriumDoor.ID_WHITE + "Lime");
        blockHexoriumDoorWhiteGreen = new BlockHexoriumDoor(BlockHexoriumDoor.ID_WHITE + "Green", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumDoorWhiteGreen, BlockHexoriumDoor.ID_WHITE + "Green");
        blockHexoriumDoorWhiteTurquoise = new BlockHexoriumDoor(BlockHexoriumDoor.ID_WHITE + "Turquoise", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumDoorWhiteTurquoise, BlockHexoriumDoor.ID_WHITE + "Turquoise");
        blockHexoriumDoorWhiteCyan = new BlockHexoriumDoor(BlockHexoriumDoor.ID_WHITE + "Cyan", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumDoorWhiteCyan, BlockHexoriumDoor.ID_WHITE + "Cyan");
        blockHexoriumDoorWhiteSkyBlue = new BlockHexoriumDoor(BlockHexoriumDoor.ID_WHITE + "SkyBlue", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumDoorWhiteSkyBlue, BlockHexoriumDoor.ID_WHITE + "SkyBlue");
        blockHexoriumDoorWhiteBlue = new BlockHexoriumDoor(BlockHexoriumDoor.ID_WHITE + "Blue", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumDoorWhiteBlue, BlockHexoriumDoor.ID_WHITE + "Blue");
        blockHexoriumDoorWhitePurple = new BlockHexoriumDoor(BlockHexoriumDoor.ID_WHITE + "Purple", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumDoorWhitePurple, BlockHexoriumDoor.ID_WHITE + "Purple");
        blockHexoriumDoorWhiteMagenta = new BlockHexoriumDoor(BlockHexoriumDoor.ID_WHITE + "Magenta", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumDoorWhiteMagenta, BlockHexoriumDoor.ID_WHITE + "Magenta");
        blockHexoriumDoorWhitePink = new BlockHexoriumDoor(BlockHexoriumDoor.ID_WHITE + "Pink", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumDoorWhitePink, BlockHexoriumDoor.ID_WHITE + "Pink");

        blockHexoriumDoorWhiteWhite = new BlockHexoriumDoor(BlockHexoriumDoor.ID_WHITE + "White", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumDoorWhiteWhite, BlockHexoriumDoor.ID_WHITE + "White");
        blockHexoriumDoorWhiteLightGray = new BlockHexoriumDoor(BlockHexoriumDoor.ID_WHITE + "LightGray", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumDoorWhiteLightGray, BlockHexoriumDoor.ID_WHITE + "LightGray");
        blockHexoriumDoorWhiteGray = new BlockHexoriumDoor(BlockHexoriumDoor.ID_WHITE + "Gray", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumDoorWhiteGray, BlockHexoriumDoor.ID_WHITE + "Gray");
        blockHexoriumDoorWhiteDarkGray = new BlockHexoriumDoor(BlockHexoriumDoor.ID_WHITE + "DarkGray", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumDoorWhiteDarkGray, BlockHexoriumDoor.ID_WHITE + "DarkGray");
        blockHexoriumDoorWhiteBlack = new BlockHexoriumDoor(BlockHexoriumDoor.ID_WHITE + "Black", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumDoorWhiteBlack, BlockHexoriumDoor.ID_WHITE + "Black");

        blockHexoriumDoorWhiteRainbow = new BlockHexoriumDoor(BlockHexoriumDoor.ID_WHITE + "Rainbow", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumDoorWhiteRainbow, BlockHexoriumDoor.ID_WHITE + "Rainbow");

        // Hexorium Hatch
        blockHexoriumHatchRed = new BlockHexoriumHatch(BlockHexoriumHatch.ID_BLACK + "Red", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumHatchRed, BlockHexoriumHatch.ID_BLACK + "Red");
        blockHexoriumHatchOrange = new BlockHexoriumHatch(BlockHexoriumHatch.ID_BLACK + "Orange", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumHatchOrange, BlockHexoriumHatch.ID_BLACK + "Orange");
        blockHexoriumHatchYellow = new BlockHexoriumHatch(BlockHexoriumHatch.ID_BLACK + "Yellow", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumHatchYellow, BlockHexoriumHatch.ID_BLACK + "Yellow");
        blockHexoriumHatchLime = new BlockHexoriumHatch(BlockHexoriumHatch.ID_BLACK + "Lime", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumHatchLime, BlockHexoriumHatch.ID_BLACK + "Lime");
        blockHexoriumHatchGreen = new BlockHexoriumHatch(BlockHexoriumHatch.ID_BLACK + "Green", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumHatchGreen, BlockHexoriumHatch.ID_BLACK + "Green");
        blockHexoriumHatchTurquoise = new BlockHexoriumHatch(BlockHexoriumHatch.ID_BLACK + "Turquoise", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumHatchTurquoise, BlockHexoriumHatch.ID_BLACK + "Turquoise");
        blockHexoriumHatchCyan = new BlockHexoriumHatch(BlockHexoriumHatch.ID_BLACK + "Cyan", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumHatchCyan, BlockHexoriumHatch.ID_BLACK + "Cyan");
        blockHexoriumHatchSkyBlue = new BlockHexoriumHatch(BlockHexoriumHatch.ID_BLACK + "SkyBlue", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumHatchSkyBlue, BlockHexoriumHatch.ID_BLACK + "SkyBlue");
        blockHexoriumHatchBlue = new BlockHexoriumHatch(BlockHexoriumHatch.ID_BLACK + "Blue", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumHatchBlue, BlockHexoriumHatch.ID_BLACK + "Blue");
        blockHexoriumHatchPurple = new BlockHexoriumHatch(BlockHexoriumHatch.ID_BLACK + "Purple", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumHatchPurple, BlockHexoriumHatch.ID_BLACK + "Purple");
        blockHexoriumHatchMagenta = new BlockHexoriumHatch(BlockHexoriumHatch.ID_BLACK + "Magenta", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumHatchMagenta, BlockHexoriumHatch.ID_BLACK + "Magenta");
        blockHexoriumHatchPink = new BlockHexoriumHatch(BlockHexoriumHatch.ID_BLACK + "Pink", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumHatchPink, BlockHexoriumHatch.ID_BLACK + "Pink");

        blockHexoriumHatchWhite = new BlockHexoriumHatch(BlockHexoriumHatch.ID_BLACK + "White", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumHatchWhite, BlockHexoriumHatch.ID_BLACK + "White");
        blockHexoriumHatchLightGray = new BlockHexoriumHatch(BlockHexoriumHatch.ID_BLACK + "LightGray", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumHatchLightGray, BlockHexoriumHatch.ID_BLACK + "LightGray");
        blockHexoriumHatchGray = new BlockHexoriumHatch(BlockHexoriumHatch.ID_BLACK + "Gray", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumHatchGray, BlockHexoriumHatch.ID_BLACK + "Gray");
        blockHexoriumHatchDarkGray = new BlockHexoriumHatch(BlockHexoriumHatch.ID_BLACK + "DarkGray", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumHatchDarkGray, BlockHexoriumHatch.ID_BLACK + "DarkGray");
        blockHexoriumHatchBlack = new BlockHexoriumHatch(BlockHexoriumHatch.ID_BLACK + "Black", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumHatchBlack, BlockHexoriumHatch.ID_BLACK + "Black");

        blockHexoriumHatchRainbow = new BlockHexoriumHatch(BlockHexoriumHatch.ID_BLACK + "Rainbow", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumHatchRainbow, BlockHexoriumHatch.ID_BLACK + "Rainbow");

        blockHexoriumHatchWhiteRed = new BlockHexoriumHatch(BlockHexoriumHatch.ID_WHITE + "Red", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumHatchWhiteRed, BlockHexoriumHatch.ID_WHITE + "Red");
        blockHexoriumHatchWhiteOrange = new BlockHexoriumHatch(BlockHexoriumHatch.ID_WHITE + "Orange", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumHatchWhiteOrange, BlockHexoriumHatch.ID_WHITE + "Orange");
        blockHexoriumHatchWhiteYellow = new BlockHexoriumHatch(BlockHexoriumHatch.ID_WHITE + "Yellow", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumHatchWhiteYellow, BlockHexoriumHatch.ID_WHITE + "Yellow");
        blockHexoriumHatchWhiteLime = new BlockHexoriumHatch(BlockHexoriumHatch.ID_WHITE + "Lime", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumHatchWhiteLime, BlockHexoriumHatch.ID_WHITE + "Lime");
        blockHexoriumHatchWhiteGreen = new BlockHexoriumHatch(BlockHexoriumHatch.ID_WHITE + "Green", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumHatchWhiteGreen, BlockHexoriumHatch.ID_WHITE + "Green");
        blockHexoriumHatchWhiteTurquoise = new BlockHexoriumHatch(BlockHexoriumHatch.ID_WHITE + "Turquoise", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumHatchWhiteTurquoise, BlockHexoriumHatch.ID_WHITE + "Turquoise");
        blockHexoriumHatchWhiteCyan = new BlockHexoriumHatch(BlockHexoriumHatch.ID_WHITE + "Cyan", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumHatchWhiteCyan, BlockHexoriumHatch.ID_WHITE + "Cyan");
        blockHexoriumHatchWhiteSkyBlue = new BlockHexoriumHatch(BlockHexoriumHatch.ID_WHITE + "SkyBlue", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumHatchWhiteSkyBlue, BlockHexoriumHatch.ID_WHITE + "SkyBlue");
        blockHexoriumHatchWhiteBlue = new BlockHexoriumHatch(BlockHexoriumHatch.ID_WHITE + "Blue", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumHatchWhiteBlue, BlockHexoriumHatch.ID_WHITE + "Blue");
        blockHexoriumHatchWhitePurple = new BlockHexoriumHatch(BlockHexoriumHatch.ID_WHITE + "Purple", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumHatchWhitePurple, BlockHexoriumHatch.ID_WHITE + "Purple");
        blockHexoriumHatchWhiteMagenta = new BlockHexoriumHatch(BlockHexoriumHatch.ID_WHITE + "Magenta", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumHatchWhiteMagenta, BlockHexoriumHatch.ID_WHITE + "Magenta");
        blockHexoriumHatchWhitePink = new BlockHexoriumHatch(BlockHexoriumHatch.ID_WHITE + "Pink", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumHatchWhitePink, BlockHexoriumHatch.ID_WHITE + "Pink");

        blockHexoriumHatchWhiteWhite = new BlockHexoriumHatch(BlockHexoriumHatch.ID_WHITE + "White", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumHatchWhiteWhite, BlockHexoriumHatch.ID_WHITE + "White");
        blockHexoriumHatchWhiteLightGray = new BlockHexoriumHatch(BlockHexoriumHatch.ID_WHITE + "LightGray", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumHatchWhiteLightGray, BlockHexoriumHatch.ID_WHITE + "LightGray");
        blockHexoriumHatchWhiteGray = new BlockHexoriumHatch(BlockHexoriumHatch.ID_WHITE + "Gray", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumHatchWhiteGray, BlockHexoriumHatch.ID_WHITE + "Gray");
        blockHexoriumHatchWhiteDarkGray = new BlockHexoriumHatch(BlockHexoriumHatch.ID_WHITE + "DarkGray", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumHatchWhiteDarkGray, BlockHexoriumHatch.ID_WHITE + "DarkGray");
        blockHexoriumHatchWhiteBlack = new BlockHexoriumHatch(BlockHexoriumHatch.ID_WHITE + "Black", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumHatchWhiteBlack, BlockHexoriumHatch.ID_WHITE + "Black");

        blockHexoriumHatchWhiteRainbow = new BlockHexoriumHatch(BlockHexoriumHatch.ID_WHITE + "Rainbow", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumHatchWhiteRainbow, BlockHexoriumHatch.ID_WHITE + "Rainbow");


        // Machines
        blockHexoriumMachineBlock = new BlockHexoriumMachineBlock(BlockHexoriumMachineBlock.ID);
        GameRegistry.registerBlock(blockHexoriumMachineBlock, BlockHexoriumMachineBlock.ID);
        blockAdvancedRainbowCore = new BlockAdvancedRainbowCore(BlockAdvancedRainbowCore.ID);
        GameRegistry.registerBlock(blockAdvancedRainbowCore, BlockAdvancedRainbowCore.ID);

        blockHexoriumGenerator = new BlockHexoriumGenerator(BlockHexoriumGenerator.ID);
        GameRegistry.registerBlock(blockHexoriumGenerator, BlockHexoriumGenerator.ID);

        if (HexConfig.cfgFurnaceEnable) {
            blockHexoriumFurnace = new BlockHexoriumFurnace(BlockHexoriumFurnace.ID);
            GameRegistry.registerBlock(blockHexoriumFurnace, BlockHexoriumFurnace.ID);
        }

        if (HexConfig.cfgSeparatorEnable) {
            blockCrystalSeparator = new BlockCrystalSeparator(BlockCrystalSeparator.ID);
            GameRegistry.registerBlock(blockCrystalSeparator, BlockCrystalSeparator.ID);
        }

        blockMatrixReconstructor = new BlockMatrixReconstructor(BlockMatrixReconstructor.ID);
        GameRegistry.registerBlock(blockMatrixReconstructor, BlockMatrixReconstructor.ID);

        if (HexConfig.cfgTeleportEnable) {
            blockPersonalTeleportationPad = new BlockPersonalTeleportationPad(BlockPersonalTeleportationPad.ID);
            GameRegistry.registerBlock(blockPersonalTeleportationPad, BlockPersonalTeleportationPad.ID);
        }

        if (HexConfig.cfgObserverEnable) {
            blockQuantumObserver = new BlockQuantumObserver(BlockQuantumObserver.ID);
            GameRegistry.registerBlock(blockQuantumObserver, BlockQuantumObserver.ID);
            blockQuantumAnchor = new BlockQuantumAnchor(BlockQuantumAnchor.ID);
            GameRegistry.registerBlock(blockQuantumAnchor, BlockQuantumAnchor.ID);
        }


        // Tank Valve
        if (HexConfig.cfgTankEnable) {
            blockTankValve = new BlockTankValve(BlockTankValve.ID);
            GameRegistry.registerBlock(blockTankValve, BlockTankValve.ID);
            blockTankRender = new BlockTankRender(BlockTankRender.ID);
            GameRegistry.registerBlock(blockTankRender, BlockTankRender.ID);
        }
        
        // Energy Node
        if (HexConfig.cfgEnergyNodeEnable) {
            blockEnergyNodeCoreT1 = new BlockEnergyNodeCore(BlockEnergyNodeCore.ID + "T1");
            GameRegistry.registerBlock(blockEnergyNodeCoreT1, BlockEnergyNodeCore.ID + "T1");
            blockEnergyNodeCoreT2 = new BlockEnergyNodeCore(BlockEnergyNodeCore.ID + "T2");
            GameRegistry.registerBlock(blockEnergyNodeCoreT2, BlockEnergyNodeCore.ID + "T2");
            blockEnergyNodeCoreT3 = new BlockEnergyNodeCore(BlockEnergyNodeCore.ID + "T3");
            GameRegistry.registerBlock(blockEnergyNodeCoreT3, BlockEnergyNodeCore.ID + "T3");
            blockEnergyNodeCoreT4 = new BlockEnergyNodeCore(BlockEnergyNodeCore.ID + "T4");
            GameRegistry.registerBlock(blockEnergyNodeCoreT4, BlockEnergyNodeCore.ID + "T4");

            blockEnergyNodePortHEX = new BlockEnergyNodePortHEX(BlockEnergyNodePortHEX.ID);
            GameRegistry.registerBlock(blockEnergyNodePortHEX, BlockEnergyNodePortHEX.ID);
            if (HexConfig.cfgEnergyNodePortsRFEnable) {
                blockEnergyNodePortRF = new BlockEnergyNodePortRF(BlockEnergyNodePortRF.ID);
                GameRegistry.registerBlock(blockEnergyNodePortRF, BlockEnergyNodePortRF.ID);
            }
            if (Loader.isModLoaded("IC2") && HexConfig.cfgEnergyNodePortsEUEnable) {
                blockEnergyNodePortEU = new BlockEnergyNodePortEU(BlockEnergyNodePortEU.ID);
                GameRegistry.registerBlock(blockEnergyNodePortEU, BlockEnergyNodePortEU.ID);
            }
        }

        // Cables
        blockHexoriumCableRed = new BlockHexoriumCable(BlockHexoriumCable.ID + "Red");
        GameRegistry.registerBlock(blockHexoriumCableRed, BlockHexoriumCable.ID + "Red");
        blockHexoriumCableOrange = new BlockHexoriumCable(BlockHexoriumCable.ID + "Orange");
        GameRegistry.registerBlock(blockHexoriumCableOrange, BlockHexoriumCable.ID + "Orange");
        blockHexoriumCableYellow = new BlockHexoriumCable(BlockHexoriumCable.ID + "Yellow");
        GameRegistry.registerBlock(blockHexoriumCableYellow, BlockHexoriumCable.ID + "Yellow");
        blockHexoriumCableLime = new BlockHexoriumCable(BlockHexoriumCable.ID + "Lime");
        GameRegistry.registerBlock(blockHexoriumCableLime, BlockHexoriumCable.ID + "Lime");
        blockHexoriumCableGreen = new BlockHexoriumCable(BlockHexoriumCable.ID + "Green");
        GameRegistry.registerBlock(blockHexoriumCableGreen, BlockHexoriumCable.ID + "Green");
        blockHexoriumCableTurquoise = new BlockHexoriumCable(BlockHexoriumCable.ID + "Turquoise");
        GameRegistry.registerBlock(blockHexoriumCableTurquoise, BlockHexoriumCable.ID + "Turquoise");
        blockHexoriumCableCyan = new BlockHexoriumCable(BlockHexoriumCable.ID + "Cyan");
        GameRegistry.registerBlock(blockHexoriumCableCyan, BlockHexoriumCable.ID + "Cyan");
        blockHexoriumCableSkyBlue = new BlockHexoriumCable(BlockHexoriumCable.ID + "SkyBlue");
        GameRegistry.registerBlock(blockHexoriumCableSkyBlue, BlockHexoriumCable.ID + "SkyBlue");
        blockHexoriumCableBlue = new BlockHexoriumCable(BlockHexoriumCable.ID + "Blue");
        GameRegistry.registerBlock(blockHexoriumCableBlue, BlockHexoriumCable.ID + "Blue");
        blockHexoriumCablePurple = new BlockHexoriumCable(BlockHexoriumCable.ID + "Purple");
        GameRegistry.registerBlock(blockHexoriumCablePurple, BlockHexoriumCable.ID + "Purple");
        blockHexoriumCableMagenta = new BlockHexoriumCable(BlockHexoriumCable.ID + "Magenta");
        GameRegistry.registerBlock(blockHexoriumCableMagenta, BlockHexoriumCable.ID + "Magenta");
        blockHexoriumCablePink = new BlockHexoriumCable(BlockHexoriumCable.ID + "Pink");
        GameRegistry.registerBlock(blockHexoriumCablePink, BlockHexoriumCable.ID + "Pink");
        
        blockHexoriumCableWhite = new BlockHexoriumCable(BlockHexoriumCable.ID + "White");
        GameRegistry.registerBlock(blockHexoriumCableWhite, BlockHexoriumCable.ID + "White");
        blockHexoriumCableLightGray = new BlockHexoriumCable(BlockHexoriumCable.ID + "LightGray");
        GameRegistry.registerBlock(blockHexoriumCableLightGray, BlockHexoriumCable.ID + "LightGray");
        blockHexoriumCableGray = new BlockHexoriumCable(BlockHexoriumCable.ID + "Gray");
        GameRegistry.registerBlock(blockHexoriumCableGray, BlockHexoriumCable.ID + "Gray");
        blockHexoriumCableDarkGray = new BlockHexoriumCable(BlockHexoriumCable.ID + "DarkGray");
        GameRegistry.registerBlock(blockHexoriumCableDarkGray, BlockHexoriumCable.ID + "DarkGray");
        blockHexoriumCableBlack = new BlockHexoriumCable(BlockHexoriumCable.ID + "Black");
        GameRegistry.registerBlock(blockHexoriumCableBlack, BlockHexoriumCable.ID + "Black");

        blockHexoriumCableRainbow = new BlockHexoriumCable(BlockHexoriumCable.ID + "Rainbow");
        GameRegistry.registerBlock(blockHexoriumCableRainbow, BlockHexoriumCable.ID + "Rainbow");
        
        // Energy Pylon
        blockEnergyPylon = new BlockEnergyPylon(BlockEnergyPylon.ID);
        GameRegistry.registerBlock(blockEnergyPylon, BlockEnergyPylon.ID);

        // Hexorium Switch
        blockHexoriumSwitchRedGreen = new BlockHexoriumSwitch(BlockHexoriumSwitch.ID_BLACK + "RedGreen", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumSwitchRedGreen, BlockHexoriumSwitch.ID_BLACK + "RedGreen");
        blockHexoriumSwitchRedBlue = new BlockHexoriumSwitch(BlockHexoriumSwitch.ID_BLACK + "RedBlue", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumSwitchRedBlue, BlockHexoriumSwitch.ID_BLACK + "RedBlue");
        blockHexoriumSwitchRedWhite = new BlockHexoriumSwitch(BlockHexoriumSwitch.ID_BLACK + "RedWhite", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumSwitchRedWhite, BlockHexoriumSwitch.ID_BLACK + "RedWhite");
        blockHexoriumSwitchBlueGreen = new BlockHexoriumSwitch(BlockHexoriumSwitch.ID_BLACK + "BlueGreen", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumSwitchBlueGreen, BlockHexoriumSwitch.ID_BLACK + "BlueGreen");

        blockHexoriumSwitchWhiteRedGreen = new BlockHexoriumSwitch(BlockHexoriumSwitch.ID_WHITE + "RedGreen", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumSwitchWhiteRedGreen, BlockHexoriumSwitch.ID_WHITE + "RedGreen");
        blockHexoriumSwitchWhiteRedBlue = new BlockHexoriumSwitch(BlockHexoriumSwitch.ID_WHITE + "RedBlue", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumSwitchWhiteRedBlue, BlockHexoriumSwitch.ID_WHITE + "RedBlue");
        blockHexoriumSwitchWhiteRedWhite = new BlockHexoriumSwitch(BlockHexoriumSwitch.ID_WHITE + "RedWhite", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumSwitchWhiteRedWhite, BlockHexoriumSwitch.ID_WHITE + "RedWhite");
        blockHexoriumSwitchWhiteBlueGreen = new BlockHexoriumSwitch(BlockHexoriumSwitch.ID_WHITE + "BlueGreen", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumSwitchWhiteBlueGreen, BlockHexoriumSwitch.ID_WHITE + "BlueGreen");

        // Hexorium Button
        blockHexoriumButtonRed = new BlockHexoriumButton(BlockHexoriumButton.ID_BLACK + "Red", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumButtonRed, BlockHexoriumButton.ID_BLACK + "Red");
        blockHexoriumButtonGreen = new BlockHexoriumButton(BlockHexoriumButton.ID_BLACK + "Green", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumButtonGreen, BlockHexoriumButton.ID_BLACK + "Green");
        blockHexoriumButtonBlue = new BlockHexoriumButton(BlockHexoriumButton.ID_BLACK + "Blue", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumButtonBlue, BlockHexoriumButton.ID_BLACK + "Blue");
        blockHexoriumButtonWhite = new BlockHexoriumButton(BlockHexoriumButton.ID_BLACK + "White", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumButtonWhite, BlockHexoriumButton.ID_BLACK + "White");

        blockHexoriumButtonWhiteRed = new BlockHexoriumButton(BlockHexoriumButton.ID_WHITE + "Red", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumButtonWhiteRed, BlockHexoriumButton.ID_WHITE + "Red");
        blockHexoriumButtonWhiteGreen = new BlockHexoriumButton(BlockHexoriumButton.ID_WHITE + "Green", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumButtonWhiteGreen, BlockHexoriumButton.ID_WHITE + "Green");
        blockHexoriumButtonWhiteBlue = new BlockHexoriumButton(BlockHexoriumButton.ID_WHITE + "Blue", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumButtonWhiteBlue, BlockHexoriumButton.ID_WHITE + "Blue");
        blockHexoriumButtonWhiteWhite = new BlockHexoriumButton(BlockHexoriumButton.ID_WHITE + "White", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumButtonWhiteWhite, BlockHexoriumButton.ID_WHITE + "White");

        // Hexorium Pressure Plate
        blockHexoriumPressurePlateRed = new BlockHexoriumPressurePlate(BlockHexoriumPressurePlate.ID_BLACK + "Red", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumPressurePlateRed, BlockHexoriumPressurePlate.ID_BLACK + "Red");
        blockHexoriumPressurePlateGreen = new BlockHexoriumPressurePlate(BlockHexoriumPressurePlate.ID_BLACK + "Green", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumPressurePlateGreen, BlockHexoriumPressurePlate.ID_BLACK + "Green");
        blockHexoriumPressurePlateBlue = new BlockHexoriumPressurePlate(BlockHexoriumPressurePlate.ID_BLACK + "Blue", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumPressurePlateBlue, BlockHexoriumPressurePlate.ID_BLACK + "Blue");
        blockHexoriumPressurePlateWhite = new BlockHexoriumPressurePlate(BlockHexoriumPressurePlate.ID_BLACK + "White", DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumPressurePlateWhite, BlockHexoriumPressurePlate.ID_BLACK + "White");

        blockHexoriumPressurePlateWhiteRed = new BlockHexoriumPressurePlate(BlockHexoriumPressurePlate.ID_WHITE + "Red", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumPressurePlateWhiteRed, BlockHexoriumPressurePlate.ID_WHITE + "Red");
        blockHexoriumPressurePlateWhiteGreen = new BlockHexoriumPressurePlate(BlockHexoriumPressurePlate.ID_WHITE + "Green", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumPressurePlateWhiteGreen, BlockHexoriumPressurePlate.ID_WHITE + "Green");
        blockHexoriumPressurePlateWhiteBlue = new BlockHexoriumPressurePlate(BlockHexoriumPressurePlate.ID_WHITE + "Blue", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumPressurePlateWhiteBlue, BlockHexoriumPressurePlate.ID_WHITE + "Blue");
        blockHexoriumPressurePlateWhiteWhite = new BlockHexoriumPressurePlate(BlockHexoriumPressurePlate.ID_WHITE + "White", DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumPressurePlateWhiteWhite, BlockHexoriumPressurePlate.ID_WHITE + "White");

        // Regular Blocks
        blockTemperedHexoriumGlass = new BlockTemperedHexoriumGlass(BlockTemperedHexoriumGlass.ID_BLACK, DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockTemperedHexoriumGlass, BlockTemperedHexoriumGlass.ID_BLACK);
        blockTemperedHexoriumGlassWhite = new BlockTemperedHexoriumGlass(BlockTemperedHexoriumGlass.ID_WHITE, DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockTemperedHexoriumGlassWhite, BlockTemperedHexoriumGlass.ID_WHITE);
        blockHexoriumCoatedStone = new BlockHexoriumCoatedStone(BlockHexoriumCoatedStone.ID_BLACK, DECORATIVE_VARIANT_BLACK);
        GameRegistry.registerBlock(blockHexoriumCoatedStone, BlockHexoriumCoatedStone.ID_BLACK);
        blockHexoriumCoatedStoneWhite = new BlockHexoriumCoatedStone(BlockHexoriumCoatedStone.ID_WHITE, DECORATIVE_VARIANT_WHITE);
        GameRegistry.registerBlock(blockHexoriumCoatedStoneWhite, BlockHexoriumCoatedStone.ID_WHITE);

        blockPylonBase51 = new BlockPylonBase(BlockPylonBase.ID + "51", false);
        GameRegistry.registerBlock(blockPylonBase51, BlockPylonBase.ID + "51");
        blockPylonBase15 = new BlockPylonBase(BlockPylonBase.ID + "15", true);
        GameRegistry.registerBlock(blockPylonBase15, BlockPylonBase.ID + "15");

        blockSoundProjector = new BlockSoundProjector(BlockSoundProjector.ID);
        GameRegistry.registerBlock(blockSoundProjector, BlockSoundProjector.ID);
    }

    public static int getMachineState(World world, int x, int y, int z) {
        return HexUtils.getMetaBitBiInt(
                META_MACHINE_STATUS_0,
                META_MACHINE_STATUS_1,
                world, x, y, z);
    }

    public static int getMachineState(IBlockAccess world, int x, int y, int z) {
        return HexUtils.getMetaBitBiInt(
                META_MACHINE_STATUS_0,
                META_MACHINE_STATUS_1,
                world, x, y, z);
    }

    public static void setMachineState(int state, World world, int x, int y, int z) {
        HexUtils.setMetaBitBiInt(
                META_MACHINE_STATUS_0,
                META_MACHINE_STATUS_1,
                state, HexUtils.META_NOTIFY_UPDATE, world, x, y, z);
    }

    public static Block getBlockByVariantColor(Block block, int variant, HexEnums.Colors color) {
        if (block instanceof IBlockHexVariant) {
            IBlockHexVariant dyable = (IBlockHexVariant) block;
            return Block.getBlockFromName(HexCraft.MODID + ":" + dyable.getVariantName(variant) + color.name);
        }
        else {
            return null;
        }
    }
}
