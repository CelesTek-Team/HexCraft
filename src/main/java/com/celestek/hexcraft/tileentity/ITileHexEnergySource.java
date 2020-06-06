package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.util.HexDevice;
import net.minecraft.entity.player.EntityPlayer;

import java.util.ArrayList;

public interface ITileHexEnergySource {
    /**
     * Saves the ArrayList of energy drains.
     * @param energyDrains The ArrayList to save.
     */
    void setDrains(ArrayList<HexDevice> energyDrains);

    /**
     * Called by drains to check if they can drain energy.
     * @return Boolean if energy can be drained.
     */
    boolean canDrainEnergy();

    /**
     * Called by drains to drain energy.
     * @param amount The amount of energy requested.
     * @return The amount of energy actually drained.
     */
    float drainEnergy(float amount);

    /**
     * Called by drains to determine the amount of energy available per tick.
     * @return The amount of energy available per tick.
     */
    float getEnergyPerTick();

    /**
     * Called by Hexorium Probe to display tile entity info to chat.
     * @param player Player to show the message to.
     */
    void displayInfoSource(EntityPlayer player);
}
