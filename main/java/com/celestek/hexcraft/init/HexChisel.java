package com.celestek.hexcraft.init;

import com.cricketcraft.chisel.api.carving.CarvingUtils;
import com.cricketcraft.chisel.api.carving.ICarvingRegistry;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class HexChisel {

    /**
     * Registers all Chisel groups.
     */
    public static void initializeChisel() {
        // Get the instance of Chisel's registry.
        ICarvingRegistry chisel = CarvingUtils.getChiselRegistry();

        // Red
        chisel.addVariation("hexcraftDecorativeRed", HexBlocks.blockEngineeredHexoriumBlockRed, 0, 0);
        chisel.addVariation("hexcraftDecorativeRed", HexBlocks.blockFramedHexoriumBlockRed, 0, 1);
        chisel.addVariation("hexcraftDecorativeRed", HexBlocks.blockPlatedHexoriumBlockRed, 0, 2);
        chisel.addVariation("hexcraftDecorativeRed", HexBlocks.blockConcentricHexoriumBlockRed, 0, 3);
        // Orange
        chisel.addVariation("hexcraftDecorativeOrange", HexBlocks.blockEngineeredHexoriumBlockOrange, 0, 0);
        chisel.addVariation("hexcraftDecorativeOrange", HexBlocks.blockFramedHexoriumBlockOrange, 0, 1);
        chisel.addVariation("hexcraftDecorativeOrange", HexBlocks.blockPlatedHexoriumBlockOrange, 0, 2);
        chisel.addVariation("hexcraftDecorativeOrange", HexBlocks.blockConcentricHexoriumBlockOrange, 0, 3);
        // Yellow
        chisel.addVariation("hexcraftDecorativeYellow", HexBlocks.blockEngineeredHexoriumBlockYellow, 0, 0);
        chisel.addVariation("hexcraftDecorativeYellow", HexBlocks.blockFramedHexoriumBlockYellow, 0, 1);
        chisel.addVariation("hexcraftDecorativeYellow", HexBlocks.blockPlatedHexoriumBlockYellow, 0, 2);
        chisel.addVariation("hexcraftDecorativeYellow", HexBlocks.blockConcentricHexoriumBlockYellow, 0, 3);
        // Lime
        chisel.addVariation("hexcraftDecorativeLime", HexBlocks.blockEngineeredHexoriumBlockLime, 0, 0);
        chisel.addVariation("hexcraftDecorativeLime", HexBlocks.blockFramedHexoriumBlockLime, 0, 1);
        chisel.addVariation("hexcraftDecorativeLime", HexBlocks.blockPlatedHexoriumBlockLime, 0, 2);
        chisel.addVariation("hexcraftDecorativeLime", HexBlocks.blockConcentricHexoriumBlockLime, 0, 3);
        // Green
        chisel.addVariation("hexcraftDecorativeGreen", HexBlocks.blockEngineeredHexoriumBlockGreen, 0, 0);
        chisel.addVariation("hexcraftDecorativeGreen", HexBlocks.blockFramedHexoriumBlockGreen, 0, 1);
        chisel.addVariation("hexcraftDecorativeGreen", HexBlocks.blockPlatedHexoriumBlockGreen, 0, 2);
        chisel.addVariation("hexcraftDecorativeGreen", HexBlocks.blockConcentricHexoriumBlockGreen, 0, 3);
        // Turquoise
        chisel.addVariation("hexcraftDecorativeTurquoise", HexBlocks.blockEngineeredHexoriumBlockTurquoise, 0, 0);
        chisel.addVariation("hexcraftDecorativeTurquoise", HexBlocks.blockFramedHexoriumBlockTurquoise, 0, 1);
        chisel.addVariation("hexcraftDecorativeTurquoise", HexBlocks.blockPlatedHexoriumBlockTurquoise, 0, 2);
        chisel.addVariation("hexcraftDecorativeTurquoise", HexBlocks.blockConcentricHexoriumBlockTurquoise, 0, 3);
        // Cyan
        chisel.addVariation("hexcraftDecorativeCyan", HexBlocks.blockEngineeredHexoriumBlockCyan, 0, 0);
        chisel.addVariation("hexcraftDecorativeCyan", HexBlocks.blockFramedHexoriumBlockCyan, 0, 1);
        chisel.addVariation("hexcraftDecorativeCyan", HexBlocks.blockPlatedHexoriumBlockCyan, 0, 2);
        chisel.addVariation("hexcraftDecorativeCyan", HexBlocks.blockConcentricHexoriumBlockCyan, 0, 3);
        // Sky Blue
        chisel.addVariation("hexcraftDecorativeSkyBlue", HexBlocks.blockEngineeredHexoriumBlockSkyBlue, 0, 0);
        chisel.addVariation("hexcraftDecorativeSkyBlue", HexBlocks.blockFramedHexoriumBlockSkyBlue, 0, 1);
        chisel.addVariation("hexcraftDecorativeSkyBlue", HexBlocks.blockPlatedHexoriumBlockSkyBlue, 0, 2);
        chisel.addVariation("hexcraftDecorativeSkyBlue", HexBlocks.blockConcentricHexoriumBlockSkyBlue, 0, 3);
        // Blue
        chisel.addVariation("hexcraftDecorativeBlue", HexBlocks.blockEngineeredHexoriumBlockBlue, 0, 0);
        chisel.addVariation("hexcraftDecorativeBlue", HexBlocks.blockFramedHexoriumBlockBlue, 0, 1);
        chisel.addVariation("hexcraftDecorativeBlue", HexBlocks.blockPlatedHexoriumBlockBlue, 0, 2);
        chisel.addVariation("hexcraftDecorativeBlue", HexBlocks.blockConcentricHexoriumBlockBlue, 0, 3);
        // Purple
        chisel.addVariation("hexcraftDecorativePurple", HexBlocks.blockEngineeredHexoriumBlockPurple, 0, 0);
        chisel.addVariation("hexcraftDecorativePurple", HexBlocks.blockFramedHexoriumBlockPurple, 0, 1);
        chisel.addVariation("hexcraftDecorativePurple", HexBlocks.blockPlatedHexoriumBlockPurple, 0, 2);
        chisel.addVariation("hexcraftDecorativePurple", HexBlocks.blockConcentricHexoriumBlockPurple, 0, 3);
        // Magenta
        chisel.addVariation("hexcraftDecorativeMagenta", HexBlocks.blockEngineeredHexoriumBlockMagenta, 0, 0);
        chisel.addVariation("hexcraftDecorativeMagenta", HexBlocks.blockFramedHexoriumBlockMagenta, 0, 1);
        chisel.addVariation("hexcraftDecorativeMagenta", HexBlocks.blockPlatedHexoriumBlockMagenta, 0, 2);
        chisel.addVariation("hexcraftDecorativeMagenta", HexBlocks.blockConcentricHexoriumBlockMagenta, 0, 3);
        // Pink
        chisel.addVariation("hexcraftDecorativePink", HexBlocks.blockEngineeredHexoriumBlockPink, 0, 0);
        chisel.addVariation("hexcraftDecorativePink", HexBlocks.blockFramedHexoriumBlockPink, 0, 1);
        chisel.addVariation("hexcraftDecorativePink", HexBlocks.blockPlatedHexoriumBlockPink, 0, 2);
        chisel.addVariation("hexcraftDecorativePink", HexBlocks.blockConcentricHexoriumBlockPink, 0, 3);

        // White
        chisel.addVariation("hexcraftDecorativeWhite", HexBlocks.blockEngineeredHexoriumBlockWhite, 0, 0);
        chisel.addVariation("hexcraftDecorativeWhite", HexBlocks.blockFramedHexoriumBlockWhite, 0, 1);
        chisel.addVariation("hexcraftDecorativeWhite", HexBlocks.blockPlatedHexoriumBlockWhite, 0, 2);
        chisel.addVariation("hexcraftDecorativeWhite", HexBlocks.blockConcentricHexoriumBlockWhite, 0, 3);
        // Light Gray
        chisel.addVariation("hexcraftDecorativeLightGray", HexBlocks.blockEngineeredHexoriumBlockLightGray, 0, 0);
        chisel.addVariation("hexcraftDecorativeLightGray", HexBlocks.blockFramedHexoriumBlockLightGray, 0, 1);
        chisel.addVariation("hexcraftDecorativeLightGray", HexBlocks.blockPlatedHexoriumBlockLightGray, 0, 2);
        chisel.addVariation("hexcraftDecorativeLightGray", HexBlocks.blockConcentricHexoriumBlockLightGray, 0, 3);
        // Gray
        chisel.addVariation("hexcraftDecorativeGray", HexBlocks.blockEngineeredHexoriumBlockGray, 0, 0);
        chisel.addVariation("hexcraftDecorativeGray", HexBlocks.blockFramedHexoriumBlockGray, 0, 1);
        chisel.addVariation("hexcraftDecorativeGray", HexBlocks.blockPlatedHexoriumBlockGray, 0, 2);
        chisel.addVariation("hexcraftDecorativeGray", HexBlocks.blockConcentricHexoriumBlockGray, 0, 3);
        // Dark Gray
        chisel.addVariation("hexcraftDecorativeDarkGray", HexBlocks.blockEngineeredHexoriumBlockDarkGray, 0, 0);
        chisel.addVariation("hexcraftDecorativeDarkGray", HexBlocks.blockFramedHexoriumBlockDarkGray, 0, 1);
        chisel.addVariation("hexcraftDecorativeDarkGray", HexBlocks.blockPlatedHexoriumBlockDarkGray, 0, 2);
        chisel.addVariation("hexcraftDecorativeDarkGray", HexBlocks.blockConcentricHexoriumBlockDarkGray, 0, 3);
        // Black
        chisel.addVariation("hexcraftDecorativeBlack", HexBlocks.blockEngineeredHexoriumBlockBlack, 0, 0);
        chisel.addVariation("hexcraftDecorativeBlack", HexBlocks.blockFramedHexoriumBlockBlack, 0, 1);
        chisel.addVariation("hexcraftDecorativeBlack", HexBlocks.blockPlatedHexoriumBlockBlack, 0, 2);
        chisel.addVariation("hexcraftDecorativeBlack", HexBlocks.blockConcentricHexoriumBlockBlack, 0, 3);

        // Rainbow
        chisel.addVariation("hexcraftDecorativeRainbow", HexBlocks.blockEngineeredHexoriumBlockRainbow, 0, 0);
        chisel.addVariation("hexcraftDecorativeRainbow", HexBlocks.blockFramedHexoriumBlockRainbow, 0, 1);
        chisel.addVariation("hexcraftDecorativeRainbow", HexBlocks.blockPlatedHexoriumBlockRainbow, 0, 2);
        chisel.addVariation("hexcraftDecorativeRainbow", HexBlocks.blockConcentricHexoriumBlockRainbow, 0, 3);
    }
}
