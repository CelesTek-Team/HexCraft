package com.celestek.hexcraft.util;

import com.celestek.hexcraft.HexCraft;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

/**
 * A collection of methods used for playing sounds.
 */
public class HexSound {
    public static final String SOUND_PREFIX = "sound";
    public static final String EFFECT_PREFIX = "effect";
    public static final float DEFAULT_RANGE = 16F;

    public static PositionedSoundRecord playSound(double x, double y, double z, String name, float volume) {
        float range = DEFAULT_RANGE;

        if (volume > 1.0F) {
            range *= volume;
        }

        Entity person = FMLClientHandler.instance().getClient().renderViewEntity;

        if (person != null && volume > 0 && person.getDistanceSq(x, y, z) < range * range) {
            ResourceLocation location = new ResourceLocation(HexCraft.MODID + ":" + SOUND_PREFIX + "-" + name);

            if (Minecraft.getMinecraft().getSoundHandler().getSound(location) != null) {
                PositionedSoundRecord sound = new PositionedSoundRecord( location, volume, 1.0F, (float) x, (float) y, (float) z);
                Minecraft.getMinecraft().getSoundHandler().playSound(sound);
                return sound;
            }
        }
        return null;
    }

    public static boolean isPlaying(PositionedSoundRecord sound) {
        return Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(sound);
    }

    public static void stopSound(PositionedSoundRecord sound) {
        Minecraft.getMinecraft().getSoundHandler().stopSound(sound);
    }
}
