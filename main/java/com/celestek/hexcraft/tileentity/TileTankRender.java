package com.celestek.hexcraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
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

    public int maxVolume;
    public int currVolume;
    public String fluidName;

    public TileTankRender() {

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
}
