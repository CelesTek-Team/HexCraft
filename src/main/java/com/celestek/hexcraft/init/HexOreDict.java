package com.celestek.hexcraft.init;

import com.celestek.hexcraft.block.BlockHexoriumNetherOre;
import com.celestek.hexcraft.block.BlockHexoriumOre;
import com.celestek.hexcraft.util.HexEnums;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class HexOreDict {

    /**
     * Adds all ores and monoliths to the OreDictionary.
     */
    public static void registerOres() {
        // Ores
        BlockHexoriumOre.registerOres();
        BlockHexoriumNetherOre.registerOres();

        // Crystals
        for (HexEnums.Basics color : HexEnums.Basics.values())
            OreDictionary.registerOre("gemHexoriumRed", HexItems.getHexItem(HexItems.ID_CRYSTAL + color.name));

        // Nuggets
        OreDictionary.registerOre("nuggetIron", HexItems.itemIronNugget);
    }
}
