package com.celestek.hexcraft.network;

import com.celestek.hexcraft.tileentity.TileSoundProjector;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

public class PacketClientSound implements IMessage, IMessageHandler<PacketClientSound, IMessage> {

    private int x;
    private int y;
    private int z;

    private String soundName;
    private int soundRange;
    private int soundDistance;
    private boolean soundLoop;

    public PacketClientSound() {
    }

    public PacketClientSound(int x, int y, int z, String soundName, int soundRange, int soundDistance, boolean soundLoop) {
        this.x = x;
        this.y = y;
        this.z = z;

        this.soundName = soundName;
        this.soundRange = soundRange;
        this.soundDistance = soundDistance;
        this.soundLoop = soundLoop;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        x = buf.readInt();
        y = buf.readInt();
        z = buf.readInt();

        soundName = ByteBufUtils.readUTF8String(buf);
        soundRange = buf.readInt();
        soundDistance = buf.readInt();
        soundLoop = buf.readBoolean();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);

        ByteBufUtils.writeUTF8String(buf, soundName);
        buf.writeInt(soundRange);
        buf.writeInt(soundDistance);
        buf.writeBoolean(soundLoop);
    }

    @Override
    public IMessage onMessage(PacketClientSound message, MessageContext ctx) {
        TileEntity tileEntity = ctx.getServerHandler().playerEntity.worldObj.getTileEntity(message.x, message.y, message.z);
        if (tileEntity instanceof TileSoundProjector) {
            TileSoundProjector tileSoundProjector = (TileSoundProjector) tileEntity;
            tileSoundProjector.setSoundName(message.soundName);
            tileSoundProjector.setSoundRange(message.soundRange);
            tileSoundProjector.setSoundDistance(message.soundDistance);
            tileSoundProjector.setSoundLoop(message.soundLoop);
            tileSoundProjector.getWorldObj().markBlockForUpdate(message.x, message.y, message.z);
        }
        return null;
    }
}
