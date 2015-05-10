package com.celestek.hexcraft.util;

import com.celestek.hexcraft.tileentity.TileEnergyPylon;
import net.minecraft.block.Block;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-26
 */
public class HexPylon {
    public TileEnergyPylon pylon;
    public boolean beam;

    public HexPylon(TileEnergyPylon pylon, boolean beam) {
        this.pylon = pylon;
        this.beam = beam;
    }

    public HexPylon(TileEnergyPylon pylon, int beam) {
        this.pylon = pylon;
        this.beam = beam == 1;
    }

    public int getBeamAsInt() {
        if (beam)
            return 1;
        else
            return 0;
    }
}
