package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.util.HexDevice;

import java.util.ArrayList;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.7.0
 */
public interface ITileHexEnergyDrain {
    /**
     * Saves the ArrayList of energy sources.
     * @param energySources The ArrayList to save.
     */
    void setSources(ArrayList<HexDevice> energySources);

    /**
     * Called by sources to force drains to recheck them.
     */
    void recheckSources();
}
