package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.util.HexDevice;
import net.minecraft.block.Block;

import java.util.ArrayList;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.7.0
 */
public interface ITileHexEnergyPort {
    /**
     * Saves the ArrayList of energy ports.
     * @param energyPorts The ArrayList to save.
     */
    void setPorts(ArrayList<HexDevice> energyPorts);

    /**
     * Called when setting up an Energy Node to set the tier.
     * @param block The Energy Node Core.
     */
    void setCoreTier(Block block);

    /**
     * Checks if ports are connected via network.
     * @param x X coordinate of the target port.
     * @param y Y coordinate of the target port.
     * @param z Z coordinate of the target port.
     * @return Boolean whether the port are on same network.
     */
    boolean checkPortConnectivity(int x, int y, int z);

    /**
     * Checks if ports are already linked.
     * @param x X coordinate of the target port.
     * @param y Y coordinate of the target port.
     * @param z Z coordinate of the target port.
     * @return Boolean whether the ports are already linked.
     */
    boolean checkPortLinked(int x, int y, int z);

    /**
     * Called when linking ports.
     * @param x X coordinate of the calling port.
     * @param y Y coordinate of the calling port.
     * @param z Z coordinate of the calling port.
     * @return Whether the linking was successful.
     */
    boolean linkPort(int x, int y, int z);

    /**
     * Called when unlinking ports.
     */
    void unlinkPort();

    /**
     * Called by output ports to determine the conversion multiplier.
     * @param typeOut The type of energy of output port.
     * @param tierOut The tier of core of output port.
     * @return The multiplier to use.
     */
    float getConversionMultiplier(String typeOut, int tierOut);

    /**
     * Called by output ports to drain energy.
     * @param amount The amount of energy requested.
     * @return The amount of energy actually drained.
     */
    float drainPortEnergy(float amount);
}
