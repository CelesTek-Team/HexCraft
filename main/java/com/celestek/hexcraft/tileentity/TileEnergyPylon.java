package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.util.HexPylon;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-25
 */
public class TileEnergyPylon extends TileEntity {

    // Prepare pylon list and arrays for coordinates.
    public ArrayList<HexPylon> pylons;
    private int[] pylonsX;
    private int[] pylonsY;
    private int[] pylonsZ;
    private int[] pylonsMaster;

    // ID of the monolith inserted.
    public int monolith = 0;

    boolean firstTickServer = false;
    boolean firstTickClient = false;

    int tickCount = 0;

    /**
     * Reads the tags from NBT.
     */
    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);

        monolith = tagCompound.getInteger("Monolith");

        // Read the coordinate arrays.
        pylonsX = tagCompound.getIntArray("PylonsX");
        pylonsY = tagCompound.getIntArray("PylonsY");
        pylonsZ = tagCompound.getIntArray("PylonsZ");
        pylonsMaster = tagCompound.getIntArray("PylonsMaster");
        // Prime the updateEntity() for first-tick startup.
        firstTickServer = true;
    }

    /**
     * Writes the tags to NBT.
     */
    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);

        tagCompound.setInteger("Monolith", monolith);

        // Check if machine list is not null.
        if (pylons != null) {
            // Initialize the coordinate arrays.
            pylonsX = new int[pylons.size()];
            pylonsY = new int[pylons.size()];
            pylonsZ = new int[pylons.size()];
            pylonsMaster = new int[pylons.size()];
            // Save the coordinates of machines to arrays.
            int i = 0;
            for (HexPylon entry : pylons) {
                if (entry != null) {
                    pylonsX[i] = entry.pylon.xCoord;
                    pylonsY[i] = entry.pylon.yCoord;
                    pylonsZ[i] = entry.pylon.zCoord;
                    pylonsMaster[i] = entry.getMasterAsInt();
                    i++;
                }
            }
            // Write the coordinate arrays.
            tagCompound.setIntArray("PylonsX", pylonsX);
            tagCompound.setIntArray("PylonsY", pylonsY);
            tagCompound.setIntArray("PylonsZ", pylonsZ);
            tagCompound.setIntArray("PylonsMaster", pylonsMaster);
        }
        // If it is null, write the coordinate arrays as empty.
        else  {
            pylonsX = new int[0];
            pylonsY = new int[0];
            pylonsZ = new int[0];
            pylonsMaster = new int[0];
            tagCompound.setIntArray("PylonsX", pylonsX);
            tagCompound.setIntArray("PylonsY", pylonsY);
            tagCompound.setIntArray("PylonsZ", pylonsZ);
            tagCompound.setIntArray("PylonsMaster", pylonsMaster);
        }
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
        readFromNBT(packet.func_148857_g());
        // Prime the updateEntity() for first-tick startup.
        firstTickClient = true;
    }

    /**
     * Fired on every tick. Main processing is done here.
     */
    @Override
    public void updateEntity() {
        // Confirm that this is server side.
        if (!worldObj.isRemote) {
            if (firstTickServer) {
                pylons = new ArrayList<HexPylon>();
                for (int i = 0; i < pylonsX.length; i++) {
                    if (i < pylonsMaster.length)
                        pylons.add(new HexPylon((TileEnergyPylon) worldObj.getTileEntity(pylonsX[i], pylonsY[i], pylonsZ[i]), pylonsMaster[i]));
                    // System.out.println("Pylon at (" + xCoord + ", " + yCoord + ", " + zCoord + ") loaded pylon at (" + pylonsX[i] + ", " + pylonsY[i] + ", " + pylonsZ[i] + ")");
                    else
                        pylons.add(new HexPylon((TileEnergyPylon) worldObj.getTileEntity(pylonsX[i], pylonsY[i], pylonsZ[i]), false));
                }
                firstTickServer = false;
            }
            tickCount++;
            if (tickCount >= 20) {
                tickCount = 0;
                retracePylons();
            }
        }
        else {
            if (firstTickClient) {
                pylons = new ArrayList<HexPylon>();
                for (int i = 0; i < pylonsX.length; i++) {
                    if (i < pylonsMaster.length)
                        pylons.add(new HexPylon((TileEnergyPylon) worldObj.getTileEntity(pylonsX[i], pylonsY[i], pylonsZ[i]), pylonsMaster[i]));
                    // System.out.println("Pylon at (" + xCoord + ", " + yCoord + ", " + zCoord + ") reloaded pylon at (" + pylonsX[i] + ", " + pylonsY[i] + ", " + pylonsZ[i] + ")");
                    else
                        pylons.add(new HexPylon((TileEnergyPylon) worldObj.getTileEntity(pylonsX[i], pylonsY[i], pylonsZ[i]), false));
                }

                worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
                firstTickClient = false;
            }
        }
    }

    public boolean insertMonolith(EntityPlayer player) {
        if (player.getCurrentEquippedItem() != null && monolith == 0) {
            Block block = Block.getBlockFromItem(player.getCurrentEquippedItem().getItem());

            if (block == HexBlocks.blockEnergizedHexoriumMonolithRed)
                monolith = 1;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithOrange)
                monolith = 2;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithYellow)
                monolith = 3;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithLime)
                monolith = 4;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithGreen)
                monolith = 5;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithTurquoise)
                monolith = 6;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithCyan)
                monolith = 7;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithSkyBlue)
                monolith = 8;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithBlue)
                monolith = 9;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithPurple)
                monolith = 10;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithMagenta)
                monolith = 11;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithPink)
                monolith = 12;

            else if (block == HexBlocks.blockEnergizedHexoriumMonolithWhite)
                monolith = 13;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithLightGray)
                monolith = 14;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithGray)
                monolith = 15;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithDarkGray)
                monolith = 16;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithBlack)
                monolith = 17;

            else if (block == HexBlocks.blockEnergizedHexoriumMonolithRainbow)
                monolith = 18;

            if (monolith != 0) {

                ItemStack stack = player.getCurrentEquippedItem();
                stack.stackSize--;

                if (stack.stackSize == 0)
                    stack = null;

                player.inventory.setInventorySlotContents(player.inventory.currentItem, stack);

                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, worldObj.getBlockMetadata(xCoord, yCoord, zCoord) + 6, 2);
                worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
                // markDirty();

                return true;
            }
        }

        return false;
    }

    public void ejectMonolith() {
        if (!worldObj.isRemote && monolith != 0) {
            monolith = 0;
            clearPylons();

            worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, worldObj.getBlockMetadata(xCoord, yCoord, zCoord) - 6, 2);
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            // markDirty();
        }
    }

    public boolean addPylon(int x, int y, int z, boolean master) {
        TileEnergyPylon pylon = (TileEnergyPylon) worldObj.getTileEntity(x, y, z);
        if (pylon != null) {
            if (pylons == null)
                pylons = new ArrayList<HexPylon>();

            for (HexPylon entry : pylons) {
                if (entry.pylon != null)
                    if (entry.pylon.xCoord == x && entry.pylon.yCoord == y && entry.pylon.zCoord == z) {
                        // System.out.println("Pylon at (" + xCoord + ", " + yCoord + ", " + zCoord + ") reported that pylon at (" + x + ", " + y + ", " + z + ") already exists");
                        return false;
                    }
            }

            pylons.add(new HexPylon(pylon, master));
            // System.out.println("Pylon at (" + xCoord + ", " + yCoord + ", " + zCoord + ") added pylon at (" + x + ", " + y + ", " + z + ")");

            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            // markDirty();

            return true;
        }
        return false;
    }

    public void removePylon(int x, int y, int z) {
        if (pylons != null) {

            Iterator<HexPylon> iterator = pylons.iterator();

            while (iterator.hasNext()) {
                HexPylon entry = iterator.next();
                    if (entry.pylon != null) {
                        if (entry.pylon.xCoord == x && entry.pylon.yCoord == y && entry.pylon.zCoord == z) {
                            iterator.remove();
                            // System.out.println("Pylon at (" + xCoord + ", " + yCoord + ", " + zCoord + ") removing pylon at (" + x + ", " + y + ", " + z + ")");
                        }
                    } else
                        iterator.remove();
            }

            if (pylons.size() == 0)
                pylons = null;
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            // markDirty();
        }
    }

    public void clearPylons() {
        if (pylons != null) {
            for (HexPylon entry : pylons) {
                if (entry.pylon != null)
                    entry.pylon.removePylon(xCoord, yCoord, zCoord);
            }
            pylons = null;
        }
    }

    private void retracePylons() {
        if (pylons != null) {
            ArrayList<HexPylon> remove = new ArrayList<HexPylon>();
            for (HexPylon entry : pylons) {
                if (entry.pylon != null && entry.master)
                    if(!TileEnergyPylon.tracePylons(worldObj, xCoord, yCoord, zCoord, entry.pylon.xCoord, entry.pylon.yCoord, entry.pylon.zCoord)) {
                        remove.add(entry);
                        // System.out.println("Pylon at (" + xCoord + ", " + yCoord + ", " + zCoord + ") reported that it can no longer see pylon at (" + entry.xCoord + ", " + entry.yCoord + ", " + entry.zCoord + ")");
                    }
            }
            for (HexPylon entry : remove) {
                if (entry.pylon != null) {
                    removePylon(entry.pylon.xCoord, entry.pylon.yCoord, entry.pylon.zCoord);
                    entry.pylon.removePylon(xCoord, yCoord, zCoord);
                }
            }
        }
    }

    public static boolean tracePylons(World world, int x, int y, int z, int tx, int ty, int tz) {
        if (!(tx == x && ty == y && tz == z)) {
            Vec3 vec1 = Vec3.createVectorHelper(x + 0.5, y + 0.5, z + 0.5);
            Vec3 vec2 = Vec3.createVectorHelper(tx + 0.5, ty + 0.5, tz + 0.5);

            // System.out.println("vec1: (" + vec1.xCoord + ", " + vec1.yCoord + ", " + vec1.zCoord + ")");

            MovingObjectPosition hit1 = world.rayTraceBlocks(vec1.addVector(-0.01, 0, -0.01), vec2.addVector(-0.01, 0, -0.01), true);
            MovingObjectPosition hit2 = world.rayTraceBlocks(vec1.addVector(0.01, 0, -0.01), vec2.addVector(0.01, 0, -0.01), true);
            MovingObjectPosition hit3 = world.rayTraceBlocks(vec1.addVector(0.01, 0, 0.01), vec2.addVector(0.01, 0, 0.01), true);
            MovingObjectPosition hit4 = world.rayTraceBlocks(vec1.addVector(-0.01, 0, 0.01), vec2.addVector(-0.01, 0, 0.01), true);

            // System.out.println(hit1);
            // System.out.println(hit2);
            // System.out.println(hit3);
            // System.out.println(hit4);

            return hit1 == null && hit2 == null && hit3 == null && hit4 == null;
        }
        return false;
    }



}
