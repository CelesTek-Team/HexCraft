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

import static com.celestek.hexcraft.block.BlockSoundProjector.META_ORIENTATION_0;
import static com.celestek.hexcraft.block.BlockSoundProjector.META_ORIENTATION_1;
import static com.celestek.hexcraft.block.BlockSoundProjector.META_ORIENTATION_2;


/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class TileSoundProjector extends TileEntity {

    /**** Static Values ****/

    public static final String ID = "tileSoundProjector";

    public static final String MACHINE_NAME = "hexcraft.container.soundProjector";

    // NBT Names
    private static final String NBT_SOUND_NAME = "sound_name";
    private static final String NBT_SOUND_RANGE = "sound_range";
    private static final String NBT_SOUND_DISTANCE = "sound_distance";
    private static final String NBT_SOUND_LOOP = "sound_loop";

    private static final String NBT_POWERED = "powered";

    public static final int SOUND_RANGE_MIN = 0;
    public static final int SOUND_RANGE_MAX = 128;
    public static final int SOUND_DISTANCE_MIN = 0;
    public static final int SOUND_DISTANCE_MAX = 128;

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

        this.soundName = "";
        this.soundRange = 16;
        this.soundDistance = 8;
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
                if (powered && !sound.isPlaying() && soundLoop)
                    playSoundInDirection(true);
            }
        }
    }

    @Override
    public void invalidate() {
        if (worldObj.isRemote)
            sound.stopSound();

        super.invalidate();
    }

    private void processSound() {
        if (worldObj.isRemote) {
            if (powered)
                playSoundInDirection(false);
            else
                sound.stopSound();
        }
    }

    private void playSoundInDirection(boolean skipCheck) {
        int orientation = HexUtils.getBitTriInt(META_ORIENTATION_0, META_ORIENTATION_1, META_ORIENTATION_2, blockMetadata);
        switch (orientation) {
            case 0: sound.playSound(xCoord + 0.5D, yCoord + 0.5D - soundDistance, zCoord + 0.5D, soundName, getNormalizedRange(), skipCheck); break;
            case 1: sound.playSound(xCoord + 0.5D, yCoord + 0.5D + soundDistance, zCoord + 0.5D, soundName, getNormalizedRange(), skipCheck); break;
            case 2: sound.playSound(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D - soundDistance, soundName, getNormalizedRange(), skipCheck); break;
            case 3: sound.playSound(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D + soundDistance, soundName, getNormalizedRange(), skipCheck); break;
            case 4: sound.playSound(xCoord + 0.5D - soundDistance, yCoord + 0.5D, zCoord + 0.5D, soundName, getNormalizedRange(), skipCheck); break;
            case 5: sound.playSound(xCoord + 0.5D + soundDistance, yCoord + 0.5D, zCoord + 0.5D, soundName, getNormalizedRange(), skipCheck); break;
        }
    }

    private float getNormalizedRange() {
        if (worldObj.isRemote) {
            return Math.min(soundRange, SOUND_RANGE_MAX) / HexSound.DEFAULT_RANGE;
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

    public void setSoundLoop(boolean soundLoop) {
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

    /**
     * Check if the TIle Entity can be used by the player.
     */
    public boolean isUsableByPlayer(EntityPlayer player) {
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64.0D;
    }
}
