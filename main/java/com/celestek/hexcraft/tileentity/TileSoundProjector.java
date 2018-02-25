package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.util.HexDevice;
import com.celestek.hexcraft.util.HexSound;
import com.celestek.hexcraft.util.HexUtils;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;

import java.util.ArrayList;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class TileSoundProjector extends TileEntity {

    /**** Static Values ****/

    public static final String ID = "tileSoundProjector";

    // NBT Names
    private static final String NBT_SOUND_NAME = "sound_name";
    private static final String NBT_SOUND_RANGE = "sound_range";
    private static final String NBT_SOUND_DISTANCE = "sound_distance";
    private static final String NBT_SOUND_LOOP = "sound_loop";

    private static final String NBT_POWERED = "powered";

    /**** Variables ****/

    // Prepare variables.
    private String soundName;
    private int soundRange;
    private int soundDistance;
    private boolean soundLoop;

    private boolean powered;

    private TileSound sound;

    private boolean firstTickClient;

    /**** Common TileEntity Methods ****/

    public TileSoundProjector() {

        this.soundName = "power";
        this.soundRange = 16;
        this.soundDistance = 0;
        this.soundLoop = true;

        this.powered = false;

        if (FMLCommonHandler.instance().getEffectiveSide().isClient()) {
            sound = new TileSound();
        }
    }

    /**
     * Writes the tags to NBT.
     */
    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);

        // Write the variables.
        tagCompound.setString(NBT_SOUND_NAME, soundName);
        tagCompound.setInteger(NBT_SOUND_RANGE, soundRange);
        tagCompound.setInteger(NBT_SOUND_DISTANCE, soundDistance);
        tagCompound.setBoolean(NBT_SOUND_LOOP, soundLoop);

        tagCompound.setBoolean(NBT_POWERED, powered);
    }

    /**
     * Reads the tags from NBT.
     */
    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);

        // Read the variables.
        soundName = tagCompound.getString(NBT_SOUND_NAME);
        soundRange = tagCompound.getInteger(NBT_SOUND_RANGE);
        soundDistance = tagCompound.getInteger(NBT_SOUND_DISTANCE);
        soundLoop = tagCompound.getBoolean(NBT_SOUND_LOOP);

        powered = tagCompound.getBoolean(NBT_POWERED);
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
        // Prime the updateEntity() for a list rebuild.
        firstTickClient = true;
    }

    /**
     * Fired on every tick. Main processing is done here.
     */
    @Override
    public void updateEntity() {
        if (worldObj.isRemote) {
            if (firstTickClient) {
                processSound();
                firstTickClient = false;
            }
            else {
                if (powered && !sound.isPlaying() && soundLoop) {
                    sound.playSound(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D, soundName, getNormalizedRange(), true);
                }
            }
        }
    }

    @Override
    public void invalidate() {
        if (worldObj.isRemote)
            sound.stopSound();

        super.invalidate();
    }

    public void processSound() {
        if (worldObj.isRemote) {
            if (powered) {
                sound.playSound(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D, soundName, getNormalizedRange(), false);
            }
            else {
                sound.stopSound();
            }
        }
    }

    private float getNormalizedRange() {
        if (worldObj.isRemote) {
            return Math.min(soundRange, HexSound.MAX_RANGE) / HexSound.DEFAULT_RANGE;
        }
        return soundRange / HexSound.DEFAULT_RANGE;
    }

    /**** Getters and Setters ****/

    public void setSoundName(String soundName) {
        this.soundName = soundName;
    }

    public String getSoundName() {
        return this.soundName;
    }

    public void setSoundRange(int soundRange) {
        this.soundRange = soundRange;
    }

    public int getSoundRange() {
        return this.soundRange;
    }

    public void setSoundDistance(int soundDistance) {
        this.soundDistance = soundDistance;
    }

    public int getSoundDistance() {
        return this.soundDistance;
    }

    public void getSoundLoop(boolean soundLoop) {
        this.soundLoop = soundLoop;
    }

    public boolean getSoundLoop() {
        return this.soundLoop;
    }

    public void setPowered(boolean powered) {
        this.powered = powered;
        processSound();
    }

    public boolean getPowered() {
        return this.powered;
    }
}
