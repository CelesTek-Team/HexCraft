package com.celestek.hexcraft.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class ChannelHandler {
    public static SimpleNetworkWrapper network = NetworkRegistry.INSTANCE.newSimpleChannel("HEXCraft");

    public static void init() {
        network.registerMessage(PacketClientSound.class, PacketClientSound.class, 7, Side.SERVER);
    }
}