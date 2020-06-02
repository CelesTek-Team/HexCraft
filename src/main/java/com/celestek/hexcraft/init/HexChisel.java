package com.celestek.hexcraft.init;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.BlockConcentricHexoriumBlock;
import com.celestek.hexcraft.block.BlockEngineeredHexoriumBlock;
import com.celestek.hexcraft.block.BlockFramedHexoriumBlock;
import com.celestek.hexcraft.block.BlockPlatedHexoriumBlock;
import com.celestek.hexcraft.client.renderer.HexModelRendererHatch;
import com.celestek.hexcraft.util.HexEnums;
import com.cricketcraft.chisel.api.carving.CarvingUtils;
import com.cricketcraft.chisel.api.carving.ICarvingRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;

import static com.celestek.hexcraft.client.HexClientProxy.renderID;

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

        for (HexEnums.Variants variant : HexEnums.Variants.values()) {
            for (HexEnums.Colors color : HexEnums.Colors.values()) {
                chisel.addVariation("hexcraftDecorative" + variant.name + color.name, HexBlocks.getBlockByVariantColor(BlockEngineeredHexoriumBlock.ID, variant, color), 0, 0);
                chisel.addVariation("hexcraftDecorative" + variant.name + color.name, HexBlocks.getBlockByVariantColor(BlockFramedHexoriumBlock.ID, variant, color), 0, 0);
                chisel.addVariation("hexcraftDecorative" + variant.name + color.name, HexBlocks.getBlockByVariantColor(BlockPlatedHexoriumBlock.ID, variant, color), 0, 0);
                chisel.addVariation("hexcraftDecorative" + variant.name + color.name, HexBlocks.getBlockByVariantColor(BlockConcentricHexoriumBlock.ID, variant, color), 0, 0);
            }
        }
    }
}
