package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.util.HexDevice;
import net.minecraft.entity.player.EntityPlayer;

import java.util.ArrayList;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.8.2
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

    /**
     * Called by Hexorium Probe to display tile entity info to chat.
     * @param player Player to show the message to.
     */
    void displayInfoDrain(EntityPlayer player);
}
