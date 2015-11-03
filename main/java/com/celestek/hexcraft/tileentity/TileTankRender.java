package com.celestek.hexcraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileTankRender extends TileEntity {
    
    private static final String NBT_START_X = "ctek_tti_start_x";
    private static final String NBT_START_Y = "ctek_tti_start_y";
    private static final String NBT_START_Z = "ctek_tti_start_z";

    private static final String NBT_END_X = "ctek_tti_end_x";
    private static final String NBT_END_Y = "ctek_tti_end_y";
    private static final String NBT_END_Z = "ctek_tti_end_z";

    private static final String NBT_MAX_VOL = "ctek_tti_max_vol";
    private static final String NBT_CURR_VOL = "ctek_tti_curr_vol";
    private static final String NBT_FLUID_NAME = "ctek_tti_fluid_name";

    public int startX;
    public int startY;
    public int startZ;

    public int endX;
    public int endY;
    public int endZ;

    public int currVolumeOld;
    public int maxVolumeOld;
    public String fluidNameOld;

    public int currVolume;
    public int maxVolume;
    public String fluidName;

    public boolean started;

    public TileTankRender() {
        this.startX = 0;
        this.startY = 0;
        this.startZ = 0;

        this.endX = 0;
        this.endY = 0;
        this.endZ = 0;

        this.currVolumeOld = 0;
        this.maxVolumeOld = 0;
        this.fluidNameOld = "";

        this.currVolume = 0;
        this.maxVolume = 0;
        this.fluidName = "";

        started = false;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);
        nbtTagCompound.setInteger(NBT_START_X, startX);
        nbtTagCompound.setInteger(NBT_START_Y, startY);
        nbtTagCompound.setInteger(NBT_START_Z, startZ);

        nbtTagCompound.setInteger(NBT_END_X, endX);
        nbtTagCompound.setInteger(NBT_END_Y, endY);
        nbtTagCompound.setInteger(NBT_END_Z, endZ);

        nbtTagCompound.setInteger(NBT_MAX_VOL, maxVolume);
        nbtTagCompound.setInteger(NBT_CURR_VOL, currVolume);

        nbtTagCompound.setString(NBT_FLUID_NAME, fluidName);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

        startX = nbtTagCompound.getInteger(NBT_START_X);
        startY = nbtTagCompound.getInteger(NBT_START_Y);
        startZ = nbtTagCompound.getInteger(NBT_START_Z);

        endX = nbtTagCompound.getInteger(NBT_END_X);
        endY = nbtTagCompound.getInteger(NBT_END_Y);
        endZ = nbtTagCompound.getInteger(NBT_END_Z);

        maxVolume = nbtTagCompound.getInteger(NBT_MAX_VOL);
        currVolume = nbtTagCompound.getInteger(NBT_CURR_VOL);

        fluidName = nbtTagCompound.getString(NBT_FLUID_NAME);
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
        if (currVolumeOld != currVolume || maxVolumeOld != maxVolume || !fluidNameOld.equals(fluidName)) {
            // System.out.println("Render: (" + startX + ", " + startY + ", " + startZ + ") (" + endX + ", " + endY + ", " + endZ + ") c: " + currVolume + " m: " + maxVolume + " n: " + fluidName);
            currVolumeOld = currVolume;
            maxVolumeOld = maxVolume;
            fluidNameOld = fluidName;
            // Prepare the block to update.
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        }
    }
}
