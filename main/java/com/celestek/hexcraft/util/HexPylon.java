package com.celestek.hexcraft.util;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.8.0
 */

public class HexPylon {
    public int x;
    public int y;
    public int z;
    public boolean master;

    public HexPylon(int x, int y, int z, boolean master) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.master = master;
    }

    public HexPylon(int x, int y, int z, int master) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.master = master == 1;
    }

    public int getMasterAsInt() {
        if (master)
            return 1;
        else
            return 0;
    }
}
