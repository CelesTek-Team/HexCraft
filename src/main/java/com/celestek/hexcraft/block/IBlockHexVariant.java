package com.celestek.hexcraft.block;

import com.celestek.hexcraft.util.HexEnums;

public interface IBlockHexVariant {
    /**
     * Returns the integer value corresponding to the variant ID of the block.
     */
    HexEnums.Variants getVariant();
}
