package com.celestek.hexcraft.util;

import com.celestek.hexcraft.network.ChannelHandler;
import com.celestek.hexcraft.network.PacketClientSound;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class HexNetworkHelper {
    // Client
    public static void updateSoundProjector(int x, int y, int z, String soundName, int soundRange, int soundDistance, boolean soundLoop) {
        ChannelHandler.network.sendToServer(new PacketClientSound(x, y, z, soundName, soundRange, soundDistance, soundLoop));
    }
}