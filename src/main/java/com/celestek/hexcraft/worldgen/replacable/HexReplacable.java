package com.celestek.hexcraft.worldgen.replacable;

import cpw.mods.fml.common.Loader;
import net.minecraft.block.Block;

public class HexReplacable {
    public static boolean isReplacable(Block block, Block target) {
        //if (Loader.isModLoaded("gregapi"))
        return block == target;
    }
}
