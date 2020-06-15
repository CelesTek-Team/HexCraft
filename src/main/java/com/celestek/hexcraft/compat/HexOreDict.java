package com.celestek.hexcraft.compat;

import com.celestek.hexcraft.block.BlockHexoriumNetherOre;
import com.celestek.hexcraft.block.BlockHexoriumOre;
import com.celestek.hexcraft.init.HexItems;
import com.celestek.hexcraft.util.HexEnums;
import net.minecraftforge.oredict.OreDictionary;

public class HexOreDict {

    /**
     * Adds all ores and monoliths to the OreDictionary.
     */
    public static void registerOres() {
        // Ores
        BlockHexoriumOre.registerOres();
        BlockHexoriumNetherOre.registerOres();

        // Crystals
        for (HexEnums.Basics color : HexEnums.Basics.values()) {
            OreDictionary.registerOre("gemHexorium", HexItems.getHexItem(HexItems.ID_CRYSTAL + color.name));
            OreDictionary.registerOre("gemHexorium" + color.name, HexItems.getHexItem(HexItems.ID_CRYSTAL + color.name));
        }

        // Nuggets
        OreDictionary.registerOre("nuggetIron", HexItems.itemIronNugget);
    }
}
