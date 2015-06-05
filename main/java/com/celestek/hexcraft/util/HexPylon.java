package com.celestek.hexcraft.util;

import com.celestek.hexcraft.tileentity.TileEnergyPylon;
import net.minecraft.block.Block;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.5.0
 * @since 2015-04-26
 */
public class HexPylon {
    public TileEnergyPylon pylon;
    public boolean master;

    public HexPylon(TileEnergyPylon pylon, boolean master) {
        this.pylon = pylon;
        this.master = master;
    }

    public HexPylon(TileEnergyPylon pylon, int master) {
        this.pylon = pylon;
        this.master = master == 1;
    }

    public int getMasterAsInt() {
        if (master)
            return 1;
        else
            return 0;
    }
}
