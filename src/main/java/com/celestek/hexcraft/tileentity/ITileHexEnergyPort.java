package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.util.HexDevice;
import net.minecraft.entity.player.EntityPlayer;

import java.util.ArrayList;

public interface ITileHexEnergyPort {
    /**
     * Saves the ArrayList of energy ports.
     * @param energyPorts The ArrayList to save.
     */
    void setPorts(ArrayList<HexDevice> energyPorts);

    /**
     * Called when setting up an Energy Node to set the tier.
     * @param portTier Tier of the port.
     */
    void setPortTier(int portTier);

    /**
     * Called when retrieving the tier.
     * @return Tier integer.
     */
    int getPortTier();

    /**
     * Called when retrieving the type.
     * @return Tier integer.
     */
    int getPortType();

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
     * Breaks a link between two ports.
     */
    void breakPortLink();

    /**
     * Called when unlinking ports to set the link to null.
     */
    void unlinkPort();

    /**
     * Called to empty the buffer.
     */
    void emptyBuffer();

    /**
     * Called by output ports to determine the conversion multiplier.
     * @param typeOut The type of energy of output port.
     * @param tierOut The tier of core of output port.
     * @return The multiplier to use.
     */
    float getMultiplier(int typeOut, int tierOut);

    /**
     * Called by output ports to drain energy.
     * @param amount The amount of energy requested.
     * @return The amount of energy actually drained.
     */
    float drainPortEnergy(float amount);

    /**
     * Called by Hexorium Probe to display tile entity info to chat.
     * @param player Player to show the message to.
     */
    void displayInfoPort(EntityPlayer player);
}
