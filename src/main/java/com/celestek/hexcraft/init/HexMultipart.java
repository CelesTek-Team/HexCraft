package com.celestek.hexcraft.init;

import codechicken.microblock.BlockMicroMaterial;
import codechicken.microblock.MicroMaterialRegistry;
import com.celestek.hexcraft.block.BlockHexoriumCoatedStone;
import com.celestek.hexcraft.block.BlockTemperedHexoriumGlass;
import com.celestek.hexcraft.util.HexEnums;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class HexMultipart {

    /**
     * Registers all Microblocks.
     */
    public static void initializeMicroblocks() {
        for (HexEnums.Variants variant : HexEnums.Variants.values()) {
            Block block = HexBlocks.getHexBlock(BlockHexoriumCoatedStone.ID, variant);
            MicroMaterialRegistry.registerMaterial(new BlockMicroMaterial(block, 0), BlockMicroMaterial.materialKey(block));
        }
    }
}
