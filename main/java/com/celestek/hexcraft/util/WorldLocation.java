package com.celestek.hexcraft.util;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

import java.lang.ref.WeakReference;
import java.util.Random;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */
public class WorldLocation {

    public final int xCoord;
    public final int yCoord;
    public final int zCoord;
    public final int dimensionID;

    private boolean isRemote = false;

    private WeakReference<World> clientWorld;

    public WorldLocation(World world, int x, int y, int z) {
        this(world.provider.dimensionId, x, y, z);

        if (world.isRemote) {
            isRemote = true;
            clientWorld = new WeakReference(world);
        }
    }

    public WorldLocation(int dim, int x, int y, int z) {
        xCoord = x;
        yCoord = y;
        zCoord = z;
        dimensionID = dim;
    }

    public WorldLocation(TileEntity te) {
        this(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord);
    }

    public World getWorld() {
        return isRemote && clientWorld.get() != null ? clientWorld.get() : DimensionManager.getWorld(dimensionID);
    }

    @Override
    public String toString() {
        return xCoord+", "+yCoord+", "+zCoord+" in DIM"+dimensionID;
    }

    @Override
    public int hashCode() {
        return xCoord + (zCoord << 8) + (yCoord << 16) + (dimensionID << 24);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof WorldLocation) {
            WorldLocation w = (WorldLocation) object;
            return this.equals(w.dimensionID, w.xCoord, w.yCoord, w.zCoord);
        }
        return false;
    }

    private boolean equals(int dim, int x, int y, int z) {
        return dim == dimensionID && x == xCoord && y == yCoord && z == zCoord;
    }
}
