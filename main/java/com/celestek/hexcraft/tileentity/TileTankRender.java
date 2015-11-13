package com.celestek.hexcraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

/**
 * @author CoffeePirate     <celestek@openmailbox.org>
 * @version 0.7.0
 */

public class TileTankRender extends TileEntity {

    /**** Static Values ****/

    public static final String ID = "tileTankRender";

    // NBT Names
    private static final String NBT_TANK_CAPACITY = "tank_capacity";
    private static final String NBT_FLUID_LEVEL = "fluid_level";
    private static final String NBT_FLUID_NAME = "fluid_name";

    private static final String NBT_START_X = "start_x";
    private static final String NBT_START_Y = "start_y";
    private static final String NBT_START_Z = "start_z";

    private static final String NBT_END_X = "end_x";
    private static final String NBT_END_Y = "end_y";
    private static final String NBT_END_Z = "end_z";

    /**** Variables ****/

    // Prepare fluid variables.
    private int tankCapacity;
    private int fluidLevel;
    private String fluidName;

    // Prepare old fluid variables.
    private int tankCapacityOld;
    private int fluidLevelOld;
    private String fluidNameOld;

    // Prepare tank start coordinates.
    private int startX;
    private int startY;
    private int startZ;

    // Prepare tank end coordinates.
    private int endX;
    private int endY;
    private int endZ;


    /**** Common TileEntity Methods ****/

    public TileTankRender() {
        this.tankCapacity = 0;
        this.fluidLevel = 0;
        this.fluidName = "";

        this.tankCapacityOld = 0;
        this.fluidLevelOld = 0;
        this.fluidNameOld = "";

        this.startX = 0;
        this.startY = 0;
        this.startZ = 0;

        this.endX = 0;
        this.endY = 0;
        this.endZ = 0;
    }

    /**
     * Writes to NBT.
     */
    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        // Write the fluid variables.
        nbtTagCompound.setInteger(NBT_TANK_CAPACITY, tankCapacity);
        nbtTagCompound.setInteger(NBT_FLUID_LEVEL, fluidLevel);
        nbtTagCompound.setString(NBT_FLUID_NAME, fluidName);

        // Write the tank start coordinates.
        nbtTagCompound.setInteger(NBT_START_X, startX);
        nbtTagCompound.setInteger(NBT_START_Y, startY);
        nbtTagCompound.setInteger(NBT_START_Z, startZ);

        // Write the tank end coordinates.
        nbtTagCompound.setInteger(NBT_END_X, endX);
        nbtTagCompound.setInteger(NBT_END_Y, endY);
        nbtTagCompound.setInteger(NBT_END_Z, endZ);
    }

    /**
     * Reads from NBT.
     */
    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

        // Read the fluid variables.
        tankCapacity = nbtTagCompound.getInteger(NBT_TANK_CAPACITY);
        fluidLevel = nbtTagCompound.getInteger(NBT_FLUID_LEVEL);
        fluidName = nbtTagCompound.getString(NBT_FLUID_NAME);

        // Read the tank start coordinates.
        startX = nbtTagCompound.getInteger(NBT_START_X);
        startY = nbtTagCompound.getInteger(NBT_START_Y);
        startZ = nbtTagCompound.getInteger(NBT_START_Z);

        // Read the tank end coordinates.
        endX = nbtTagCompound.getInteger(NBT_END_X);
        endY = nbtTagCompound.getInteger(NBT_END_Y);
        endZ = nbtTagCompound.getInteger(NBT_END_Z);
    }

    /**
     * Sends the data packet.
     */
    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    /**
     * Receives the data packet.
     */
    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
        readFromNBT(packet.func_148857_g());
    }

    /**
     * Fired on every tick. Main processing is done here.
     */
    @Override
    public void updateEntity() {
        if (tankCapacityOld != tankCapacity || fluidLevelOld != fluidLevel || !fluidNameOld.equals(fluidName)) {
            tankCapacityOld = tankCapacity;
            fluidLevelOld = fluidLevel;
            fluidNameOld = fluidName;
            // Prepare the block to update.
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        }
    }

    /**** Getters and Setters ****/

    // Fluid Variables
    public void setTankCapacity(int tankCapacity) {
        this.tankCapacity = tankCapacity;
    }
    
    public int getTankCapacity() {
        return this.tankCapacity;
    }

    public void setFluidLevel(int fluidLevel) {
        this.fluidLevel = fluidLevel;
    }

    public int getFluidLevel() {
        return this.fluidLevel;
    }

    public void setFluidName(String fluidName) {
        this.fluidName = fluidName;
    }

    public String getFluidName() {
        return this.fluidName;
    }
    
    // Tank Start
    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartX() {
        return this.startX;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getStartY() {
        return this.startY;
    }

    public void setStartZ(int startZ) {
        this.startZ = startZ;
    }

    public int getStartZ() {
        return this.startZ;
    }

    // Tank End
    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndX() {
        return this.endX;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public int getEndY() {
        return this.endY;
    }

    public void setEndZ(int endZ) {
        this.endZ = endZ;
    }

    public int getEndZ() {
        return this.endZ;
    }
}
