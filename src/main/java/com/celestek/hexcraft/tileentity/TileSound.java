package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.util.HexSound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.tileentity.TileEntity;

public class TileSound extends TileEntity {

    /**** Variables ****/

    // Prepare variables.
    private PositionedSoundRecord sound;

    /**** Common TileEntity Methods ****/

    public TileSound() {
    }

    public void stopSound() {
        if (sound != null) {
            HexSound.stopSound(sound);
            sound = null;
        }
    }

    public void playSound(double x, double y, double z, String soundName, float range, boolean skipCheck) {
        if (sound == null || skipCheck) {
            sound = HexSound.playSound(x, y, z, soundName, range);
        }
    }

    public boolean isPlaying() {
        if (sound == null) {
            return false;
        }
        return HexSound.isPlaying(sound);
    }
}
