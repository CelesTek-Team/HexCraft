package com.celestek.hexcraft.block;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */
public interface IBlockHexDyable {
    /**
     * Returns the integer value corresponding to the variant ID of the block.
     */
    int getVariant();

    /**
     * Returns the variant name of the block.
     */
    String getVariantName();

    /**
     * Translates a variant ID to the variant name for the block.
     * @param variant The decoration variant to use.
     */
    String getVariantName(int variant);
}
