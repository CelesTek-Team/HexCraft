package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.util.NetworkAnalyzer;
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
 * @version 0.5.0
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

    // Prepare the tick counter and tick triggers.
    int tickCount = 0;
    boolean firstTickServer = false;
    boolean firstTickClient = false;

    /**
     * Reads the tags from NBT.
     */
    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);

        // Read the monolith ID.
        monolith = tagCompound.getInteger("Monolith");

        // Read the coordinate arrays.
        pylonsX = tagCompound.getIntArray("PylonsX");
        pylonsY = tagCompound.getIntArray("PylonsY");
        pylonsZ = tagCompound.getIntArray("PylonsZ");
        pylonsMaster = tagCompound.getIntArray("PylonsMaster");
        // Prime the updateEntity() for a list rebuild.
        firstTickServer = true;
    }

    /**
     * Writes the tags to NBT.
     */
    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);

        // Write the monolith ID.
        tagCompound.setInteger("Monolith", monolith);

        // Check if pylon list is not null.
        if (pylons != null) {
            // Initialize the coordinate arrays.
            pylonsX = new int[pylons.size()];
            pylonsY = new int[pylons.size()];
            pylonsZ = new int[pylons.size()];
            pylonsMaster = new int[pylons.size()];
            // Save the coordinates of pylon to arrays.
            int i = 0;
            for (HexPylon entry : pylons) {
                if (entry.pylon != null) {
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
        // Confirm that this is server side.
        if (!worldObj.isRemote) {
            // If the list should be rebuilt, do it.
            if (firstTickServer) {
                firstTickServer = false;
                pylons = new ArrayList<HexPylon>();
                for (int i = 0; i < pylonsX.length; i++) {
                    if (i < pylonsMaster.length)
                        pylons.add(new HexPylon((TileEnergyPylon) worldObj.getTileEntity(pylonsX[i], pylonsY[i], pylonsZ[i]), pylonsMaster[i]));
                        // System.out.println("Pylon at (" + xCoord + ", " + yCoord + ", " + zCoord + ") loaded pylon at (" + pylonsX[i] + ", " + pylonsY[i] + ", " + pylonsZ[i] + ")");
                    else
                        pylons.add(new HexPylon((TileEnergyPylon) worldObj.getTileEntity(pylonsX[i], pylonsY[i], pylonsZ[i]), false));
                }
            }
            // Re-trace pylons every second.
            tickCount++;
            if (tickCount >= 20) {
                tickCount = 0;
                retracePylons();
            }
        }
        else {
            // If the list should be rebuilt, do it.
            if (firstTickClient) {
                pylons = new ArrayList<HexPylon>();
                for (int i = 0; i < pylonsX.length; i++) {
                    if (i < pylonsMaster.length)
                        pylons.add(new HexPylon((TileEnergyPylon) worldObj.getTileEntity(pylonsX[i], pylonsY[i], pylonsZ[i]), pylonsMaster[i]));
                    // System.out.println("Pylon at (" + xCoord + ", " + yCoord + ", " + zCoord + ") reloaded pylon at (" + pylonsX[i] + ", " + pylonsY[i] + ", " + pylonsZ[i] + ")");
                    else
                        pylons.add(new HexPylon((TileEnergyPylon) worldObj.getTileEntity(pylonsX[i], pylonsY[i], pylonsZ[i]), false));
                }

                // Prepare the block to update.
                worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
                firstTickClient = false;
            }
        }
    }

    /**
     * Inserts a monolith in to the pylon.
     * @param player Player performing the inserting.
     */
    public boolean insertMonolith(EntityPlayer player) {
        // Check if the item in player's hand is not null and if there is no monolith already inserted.
        if (player.getCurrentEquippedItem() != null && monolith == 0) {
            // Get the block from item.
            Block block = Block.getBlockFromItem(player.getCurrentEquippedItem().getItem());

            // Set the monolith according to the block.
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

            // If the result is an inserted monolith...
            if (monolith != 0) {

                // Decrement it from player's hand.
                ItemStack stack = player.getCurrentEquippedItem();
                stack.stackSize--;

                // If there are zero left, make it null.
                if (stack.stackSize == 0)
                    stack = null;

                // Push the stack back to player.
                player.inventory.setInventorySlotContents(player.inventory.currentItem, stack);

                // Change the pylon meta.
                // worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, worldObj.getBlockMetadata(xCoord, yCoord, zCoord) + 6, 2);

                // Prepare the block to update.
                worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);

                // Inserted.
                return true;
            }
        }

        // Not inserted.
        return false;
    }

    /**
     * Ejects the monolith from the pylon.
     */
    public void ejectMonolith() {
        // Check if this is on the server, and if there is an inserted monolith.
        if (!worldObj.isRemote && monolith != 0) {

            // Unset the monolith.
            monolith = 0;

            // Unlink all pylons.
            clearPylons();

            // Change the pylon meta.
            // worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, worldObj.getBlockMetadata(xCoord, yCoord, zCoord) - 6, 2);

            // Prepare the block to update.
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        }
    }

    /**
     * Adds a new pylon to the list of linked pylons.
     * @param x Coordinate x of the pylon to add.
     * @param y Coordinate y of the pylon to add.
     * @param z Coordinate z of the pylon to add.
     * @param master If this pylon should be the one to check the pylon to add in future.
     */
    public boolean addPylon(int x, int y, int z, boolean master) {
        // Get the pylon at coordinates.
        TileEnergyPylon pylon = (TileEnergyPylon) worldObj.getTileEntity(x, y, z);

        // Make sure it exists.
        if (pylon != null) {
            // If the list doesn't exist, create it.
            if (pylons == null)
                pylons = new ArrayList<HexPylon>();

            // Check if the pylon already exists.
            for (HexPylon entry : pylons) {
                if (entry.pylon != null)
                    if (entry.pylon.xCoord == x && entry.pylon.yCoord == y && entry.pylon.zCoord == z) {
                        // System.out.println("Pylon at (" + xCoord + ", " + yCoord + ", " + zCoord + ") reported that pylon at (" + x + ", " + y + ", " + z + ") already exists");
                        // If it does, return false.
                        return false;
                    }
            }

            // Otherwise, continue and add it to the list.
            pylons.add(new HexPylon(pylon, master));
            // System.out.println("Pylon at (" + xCoord + ", " + yCoord + ", " + zCoord + ") added pylon at (" + x + ", " + y + ", " + z + ")");

            // Prepare the block to update.
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);

            // Success.
            return true;
        }
        // Return false if pylon to add doesn't exist.
        return false;
    }

    /**
     * Removes a pylon from the list of linked pylons.
     * @param x Coordinate x of the pylon to remove.
     * @param y Coordinate y of the pylon to remove.
     * @param z Coordinate z of the pylon to remove.
     */
    public void removePylon(int x, int y, int z) {
        // Make sure the list exists.
        if (pylons != null) {
            // Iterate through the list, and remove the pylon if it exists.
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

            // If the list is empty, make it null.
            if (pylons.size() == 0)
                pylons = null;

            // Prepare the block to update.
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        }

        // System.out.println("Pylon unlinked, analyzing!");

        /* DO ANALYSIS */
        // Prepare the network analyzer.
        NetworkAnalyzer analyzer = new NetworkAnalyzer();
        // Call the analysis.
        analyzer.analyzePylon(worldObj, xCoord, yCoord, zCoord, HexBlocks.blockEnergyPylon);
    }

    /**
     * Clears the whole pylon list.
     */
    public void clearPylons() {
        // Make sure the list exists.
        if (pylons != null) {
            // Go through every entry in the list, and send an instruction to remove this pylon from their list.
            for (HexPylon entry : pylons) {
                if (entry.pylon != null)
                    entry.pylon.removePylon(xCoord, yCoord, zCoord);
            }
            // Set the list to null.
            pylons = null;
        }
    }

    /**
     * Retraces the pylons.
     */
    private void retracePylons() {
        // Make sure the list exists.
        if (pylons != null) {
            // Create a list of pylons to remove.
            ArrayList<HexPylon> remove = new ArrayList<HexPylon>();
            // Do a raytrace to each entry, if it is no longer reachable, add it to the list of pylons to remove.
            for (HexPylon entry : pylons) {
                if (entry.pylon != null && entry.master)
                    if(!TileEnergyPylon.tracePylons(worldObj, xCoord, yCoord, zCoord, entry.pylon.xCoord, entry.pylon.yCoord, entry.pylon.zCoord)) {
                        remove.add(entry);
                        // System.out.println("Pylon at (" + xCoord + ", " + yCoord + ", " + zCoord + ") reported that it can no longer see pylon at (" + entry.xCoord + ", " + entry.yCoord + ", " + entry.zCoord + ")");
                    }
            }
            // Remove all pylons in the main list using the removal list.
            for (HexPylon entry : remove) {
                if (entry.pylon != null) {
                    removePylon(entry.pylon.xCoord, entry.pylon.yCoord, entry.pylon.zCoord);
                    entry.pylon.removePylon(xCoord, yCoord, zCoord);
                }
            }
        }
    }

    /**
     * Ray traces the pylons.
     * x y z: Starting pylon.
     * tx ty tz: Target pylon.
     */
    public static boolean tracePylons(World world, int x, int y, int z, int tx, int ty, int tz) {
        // If this is not the same pylon.
        if (!(tx == x && ty == y && tz == z)) {
            // Create start and end vectors.
            Vec3 vec1 = Vec3.createVectorHelper(x + 0.5, y + 0.5, z + 0.5);
            Vec3 vec2 = Vec3.createVectorHelper(tx + 0.5, ty + 0.5, tz + 0.5);

            // System.out.println("vec1: (" + vec1.xCoord + ", " + vec1.yCoord + ", " + vec1.zCoord + ")");

            // Do 4 ray traces from different positions. This eliminates errors.
            MovingObjectPosition hit1 = world.rayTraceBlocks(vec1.addVector(-0.01, 0, -0.01), vec2.addVector(-0.01, 0, -0.01), true);
            MovingObjectPosition hit2 = world.rayTraceBlocks(vec1.addVector(0.01, 0, -0.01), vec2.addVector(0.01, 0, -0.01), true);
            MovingObjectPosition hit3 = world.rayTraceBlocks(vec1.addVector(0.01, 0, 0.01), vec2.addVector(0.01, 0, 0.01), true);
            MovingObjectPosition hit4 = world.rayTraceBlocks(vec1.addVector(-0.01, 0, 0.01), vec2.addVector(-0.01, 0, 0.01), true);

            // Return true if all of the results are null (didn't hit anything along the way).
            return hit1 == null && hit2 == null && hit3 == null && hit4 == null;
        }
        return false;
    }
}
