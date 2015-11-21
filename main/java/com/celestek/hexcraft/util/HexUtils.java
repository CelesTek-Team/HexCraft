package com.celestek.hexcraft.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * @author CoffeePirate     <celestek@openmailbox.org>
 * @version 0.7.0
 */

/**
 * A collection of utility methods and values used throughout the mod.
 */
public class HexUtils {

    public static final int META_NOTIFY_NEIGHBOR = 1;
    public static final int META_NOTIFY_UPDATE = 2;
    public static final int META_NOTIFY_BOTH = 3;
    public static final int META_NOTIFY_NOTHING = 4;


    /**
     * Checks if a chunk is loaded.
     * @param world World of the block.
     * @param x X coordinate of block.
     * @param z Z coordinate of block.
     */
    public static boolean checkChunk(World world, int x, int z) {
        return world.getChunkProvider().chunkExists(x >> 4, z >> 4);
    }

    /**
     * Sets the rotation of block.
     * @param b0 First bit of rotation.
     * @param b1 Second bit of rotation.
     * @param direction Direction of rotation, true for upwards, false for downwards.
     * @param notify Notify parameter to use.
     * @param world World of the block.
     * @param x X coordinate of block.
     * @param y Y coordinate of block.
     * @param z Z coordinate of block.
     */
    public static void rotateBlock(int b0, int b1, boolean direction, int notify, World world, int x, int y, int z) {
        int rot = getMetaBitBiInt(b0, b1, world, x, y, z);
        if (direction) {
            rot++;
            if (rot > 3)
                rot = 0;
        }
        else {
            rot--;
            if (rot < 0)
                rot = 3;
        }
        setMetaBitBiInt(b0, b1, rot, notify, world, x, y, z);
    }

    /**
     * Sets the orientation of block.
     * @param b0 First bit of orientation.
     * @param b1 Second bit of orientation.
     * @param b2 Third bit of orientation.
     * @param direction Direction of rotation, true for upwards, false for downwards.
     * @param notify Notify parameter to use.
     * @param world World of the block.
     * @param x X coordinate of block.
     * @param y Y coordinate of block.
     * @param z Z coordinate of block.
     */
    public static void orientBlock(int b0, int b1, int b2, boolean direction, int notify, World world, int x, int y, int z) {
        int ori = getMetaBitTriInt(b0, b1, b2, world, x, y, z);
        if (direction) {
            ori++;
            if (ori > 5)
                ori = 0;
        }
        else {
            ori--;
            if (ori < 0)
                ori = 5;
        }
        setMetaBitTriInt(b0, b1, b2, ori, notify, world, x, y, z);
    }

    /**
     * Returns n-th bit from an integer
     * @param b0 which bit
     * @param number The integer in question
     * @return Returns the bit
     */
    public static boolean getBit(int b0, int number) {
        return ((number >> b0) & 1) == 1;
    }

    /**
     * Returns n-th bit from block meta.
     * @param b0 Which bit of meta.
     * @param world World of the block.
     * @param x X coordinate of block.
     * @param y Y coordinate of block.
     * @param z Z coordinate of block.
     * @return Returns the bool of bit.
     */
    public static boolean getMetaBit(int b0, World world, int x, int y, int z) {
        return getBit(b0, world.getBlockMetadata(x, y, z));
    }

    /**
     * Returns n-th bit from block meta.
     * @param b0 Which bit of meta.
     * @param world World of the block.
     * @param x X coordinate of block.
     * @param y Y coordinate of block.
     * @param z Z coordinate of block.
     * @return Returns the bool of bit.
     */
    public static boolean getMetaBit(int b0, IBlockAccess world, int x, int y, int z) {
        return getBit(b0, world.getBlockMetadata(x, y, z));
    }

    /**
     * Returns the int extracted from bits.
     * @param b0 First bit.
     * @param b1 Second bit.
     * @param number Number to process.
     * @return Returns 0-3 int.
     */
    public static int getBitBiInt(int b0, int b1, int number) {
        return (getBit(b0, number) ? 1 : 0) + (getBit(b1, number) ? 2 : 0);
    }

    /**
     * Returns the int extracted from meta.
     * @param b0 First bit.
     * @param b1 Second bit.
     * @param world World of the block.
     * @param x X coordinate of block.
     * @param y Y coordinate of block.
     * @param z Z coordinate of block.
     * @return Returns 0-3 int.
     */
    public static int getMetaBitBiInt(int b0, int b1, World world, int x, int y, int z) {
        return getBitBiInt(b0, b1, world.getBlockMetadata(x, y, z));
    }

    /**
     * Returns the int extracted from meta.
     * @param b0 First bit.
     * @param b1 Second bit.
     * @param world World of the block.
     * @param x X coordinate of block.
     * @param y Y coordinate of block.
     * @param z Z coordinate of block.
     * @return Returns 0-3 int.
     */
    public static int getMetaBitBiInt(int b0, int b1, IBlockAccess world, int x, int y, int z) {
        return getBitBiInt(b0, b1, world.getBlockMetadata(x, y, z));
    }

    /**
     * Returns the int extracted from bits.
     * @param b0 First bit.
     * @param b1 Second bit.
     * @param b2 Third bit.
     * @param number Number to process.
     * @return Returns 0-7 int.
     */
    public static int getBitTriInt(int b0, int b1, int b2, int number) {
        return (getBit(b0, number) ? 1 : 0) + (getBit(b1, number) ? 2 : 0) + (getBit(b2, number) ? 4 : 0);
    }

    /**
     * Returns the int extracted from meta.
     * @param b0 First bit.
     * @param b1 Second bit.
     * @param b2 Third bit.
     * @param world World of the block.
     * @param x X coordinate of block.
     * @param y Y coordinate of block.
     * @param z Z coordinate of block.
     * @return Returns 0-7 int.
     */
    public static int getMetaBitTriInt(int b0, int b1, int b2, World world, int x, int y, int z) {
        return getBitTriInt(b0, b1, b2, world.getBlockMetadata(x, y, z));
    }

    /**
     * Returns the int extracted from meta.
     * @param b0 First bit.
     * @param b1 Second bit.
     * @param b2 Third bit.
     * @param world World of the block.
     * @param x X coordinate of block.
     * @param y Y coordinate of block.
     * @param z Z coordinate of block.
     * @return Returns 0-7 int.
     */
    public static int getMetaBitTriInt(int b0, int b1, int b2, IBlockAccess world, int x, int y, int z) {
        return getBitTriInt(b0, b1, b2, world.getBlockMetadata(x, y, z));
    }

    /**
     * Sets n-th bit for the given integer
     * @param b0 Which bit, LSB is 0
     * @param value What to set it to
     * @param original The integer to set the bit for
     * @return Int with the n-th bit set
     */
    public static int setBit(int b0, boolean value, int original) {
        if (getBit(b0, original) != value) {
            int mask = (1 << b0);
            return original^mask;
        }
        return original;
    }

    /**
     * Sets n-th bit for meta of a block.
     * @param b0 Which bit of meta.
     * @param value Bool to set the bit to.
     * @param notify Notify parameter to use.
     * @param world World of the block.
     * @param x X coordinate of block.
     * @param y Y coordinate of block.
     * @param z Z coordinate of block.
     */
    public static void setMetaBit(int b0, boolean value, int notify, World world, int x, int y, int z) {
        world.setBlockMetadataWithNotify(x, y, z, setBit(b0, value, world.getBlockMetadata(x, y, z)), notify);
    }

    /**
     * Sets an int into another int.
     * @param b0 First bit.
     * @param b1 Second bit.
     * @param value 0-3 int.
     * @param original Original int to modify.
     * @return Modified int.
     */
    public static int setBitBiInt(int b0, int b1, int value, int original) {
        original = setBit(b0, getBit(0, value), original);
        original = setBit(b1, getBit(1, value), original);
        return original;
    }

    /**
     * Sets the int into meta.
     * @param b0 First bit.
     * @param b1 Second bit.
     * @param value 0-3 int.
     * @param notify Notify parameter to use.
     * @param world World of the block.
     * @param x X coordinate of block.
     * @param y Y coordinate of block.
     * @param z Z coordinate of block.
     */
    public static void setMetaBitBiInt(int b0, int b1, int value, int notify, World world, int x, int y, int z) {
        world.setBlockMetadataWithNotify(x, y, z, setBitBiInt(b0, b1, value, world.getBlockMetadata(x, y, z)), notify);
    }

    /**
     * Sets an int into another int.
     * @param b0 First bit.
     * @param b1 Second bit.
     * @param b2 Third bit.
     * @param value 0-7 int.
     * @param original Original int to modify.
     * @return Modified int.
     */
    public static int setBitTriInt(int b0, int b1, int b2, int value, int original) {
        original = setBit(b0, getBit(0, value), original);
        original = setBit(b1, getBit(1, value), original);
        original = setBit(b2, getBit(2, value), original);
        return original;
    }

    /**
     * Sets the int into meta.
     * @param b0 First bit.
     * @param b1 Second bit.
     * @param b2 Third bit.
     * @param value 0-7 int.
     * @param notify Notify parameter to use.
     * @param world World of the block.
     * @param x X coordinate of block.
     * @param y Y coordinate of block.
     * @param z Z coordinate of block.
     */
    public static void setMetaBitTriInt(int b0, int b1, int b2, int value, int notify, World world, int x, int y, int z) {
        world.setBlockMetadataWithNotify(x, y, z, setBitTriInt(b0, b1, b2, value, world.getBlockMetadata(x, y, z)), notify);
    }

    /**
     * Flips n-th bit for meta of a block.
     * @param b0 Which bit of meta.
     * @param notify Notify parameter to use.
     * @param world World of the block.
     * @param x X coordinate of block.
     * @param y Y coordinate of block.
     * @param z Z coordinate of block.
     */
    public static void flipMetaBit(int b0, int notify, World world, int x, int y, int z) {
        world.setBlockMetadataWithNotify(x, y, z, setBit(b0, !getMetaBit(b0, world, x, y, z), world.getBlockMetadata(x, y, z)), notify);
    }

    /**
     * Spilts an int into 4 bytes
     * @param i Integer to split
     * @return 4-byte array, 0th byte being the first byte in an integer
     */
    private static byte[] intToBytes(int i) {
        return new byte[] {
            (byte) (i >> 24),
            (byte) (i >> 16),
            (byte) (i >> 8),
            (byte) i};
    }

    /**
     * Spilts a Java int into a so-called Minecraft int - iCrafting.sendProgressBarUpdate truncates
     * to short. You end up being able to send 16 bits instead of full 32.
     *
     * @param i Integer to convert to two MC integers
     * @return Array of two minecraft integers, 0th int holding first 16 bits
     */
    public static int[] intToMCInts(int i) {
        byte[] bytes = intToBytes(i);

        int[] mcInts = new int[] {
            (int) (bytes[0] << 8 | (bytes[1] & 0xFF)),
            (int) (bytes[2] << 8 | (bytes[3] & 0xFF))
        };

        return mcInts;
    }

    /**
     * Joins an array of two so-called "Minecraft Integers" into a standard Java integer
     * @param mcInts Array holding two Minecraft Integers
     * @return Java integer
     */
    public static int joinMCIntsToInt(int[] mcInts) {
        return mcInts[0] << 16 | (mcInts[1] & 0xFFFF);
    }

    /**
     * Formats a fluid input by adding a unit and changing it depending on amount.
     * @param amount The amount of fluid.
     * @return Formatted string.
     */
    public static String formatFluids(int amount) {
        if (amount >= 1000 && amount < 1000000)
            return String.format("%.3f B", (float) amount / 1000);
        else if (amount >= 1000000 && amount < 1000000000)
            return String.format("%.3f KB", (float) amount / 1000000);
        else if (amount >= 1000000000)
            return String.format("%.3f MB", (float) amount / 1000000000);
        else
            return String.format("%d mB", amount);
    }

    /**
     * Writes an ArrayList of HexDevice objects to NBT.
     * @param tagCompound NBTTagCompound to write to.
     * @param name Name to use for writing to NBT.
     * @param devices The ArrayList of HexDevice objects.
     */
    public static void writeHexDevicesArrayToNBT(NBTTagCompound tagCompound, String name, ArrayList<HexDevice> devices) {
        int devicesX[];
        int devicesY[];
        int devicesZ[];

        if (devices != null) {
            // Initialize the coordinate arrays.
            devicesX = new int[devices.size()];
            devicesY = new int[devices.size()];
            devicesZ = new int[devices.size()];
            // Save the coordinates of devices to arrays.
            int i = 0;
            for (HexDevice entry : devices) {
                devicesX[i] = entry.x;
                devicesY[i] = entry.y;
                devicesZ[i] = entry.z;
                i++;
            }
        }
        // If it is null, write the coordinate arrays as empty.
        else {
            devicesX = new int[0];
            devicesY = new int[0];
            devicesZ = new int[0];
        }
        // Write the coordinate arrays.
        tagCompound.setIntArray(name + "_x", devicesX);
        tagCompound.setIntArray(name + "_y", devicesY);
        tagCompound.setIntArray(name + "_z", devicesZ);
    }

    /**
     * Reads an ArrayList of HexDevice objects from NBT.
     * @param tagCompound NBTTagCompound to read from.
     * @param name Name to use for reading from NBT.
     * @return The ArrayList of HexDevice objects.
     */
    public static ArrayList<HexDevice> readHexDevicesArrayFromNBT(NBTTagCompound tagCompound, String name) {
        ArrayList<HexDevice> devices = new ArrayList<HexDevice>();
        int devicesX[];
        int devicesY[];
        int devicesZ[];

        // Read the coordinate arrays.
        devicesX = tagCompound.getIntArray(name + "_x");
        devicesY = tagCompound.getIntArray(name + "_y");
        devicesZ = tagCompound.getIntArray(name + "_z");
        // Build the device list using the coordinate arrays. Use null for block.
        for (int i = 0; i < devicesX.length; i++)
            devices.add(new HexDevice(devicesX[i], devicesY[i], devicesZ[i], null));

        return devices;
    }

    /**
     * Writes a HexDevice object to NBT.
     * @param tagCompound NBTTagCompound to write to.
     * @param name Name to use for writing to NBT.
     * @param device The HexDevice object.
     */
    public static void writeHexDeviceToNBT(NBTTagCompound tagCompound, String name, HexDevice device) {
        if (device != null) {
            tagCompound.setInteger(name + "_x", device.x);
            tagCompound.setInteger(name + "_y", device.y);
            tagCompound.setInteger(name + "_z", device.z);
        }
        else {
            tagCompound.setInteger(name + "_x", 0);
            tagCompound.setInteger(name + "_y", 0);
            tagCompound.setInteger(name + "_z", 0);
        }
    }

    /**
     * Reads a HexDevice object from NBT.
     * @param tagCompound NBTTagCompound to read from.
     * @param name Name to use for reading from NBT.
     * @return The HexDevice object.
     */
    public static HexDevice readHexDeviceFromNBT(NBTTagCompound tagCompound, String name) {
        return new HexDevice(
                tagCompound.getInteger(name + "_x"),
                tagCompound.getInteger(name + "_y"),
                tagCompound.getInteger(name + "_z"), null);
    }

    /**
     * Writes an ArrayList of HexPylon objects to NBT.
     * @param tagCompound NBTTagCompound to write to.
     * @param name Name to use for writing to NBT.
     * @param pylons The ArrayList of HexPylon objects.
     */
    public static void writeHexPylonsArrayToNBT(NBTTagCompound tagCompound, String name, ArrayList<HexPylon> pylons) {
        int pylonsX[];
        int pylonsY[];
        int pylonsZ[];
        int pylonsMaster[];

        if (pylons != null) {
            // Initialize the coordinate arrays.
            pylonsX = new int[pylons.size()];
            pylonsY = new int[pylons.size()];
            pylonsZ = new int[pylons.size()];
            pylonsMaster = new int[pylons.size()];
            // Save the coordinates of devices to arrays.
            int i = 0;
            for (HexPylon entry : pylons) {
                pylonsX[i] = entry.x;
                pylonsY[i] = entry.y;
                pylonsZ[i] = entry.z;
                pylonsMaster[i] = entry.getMasterAsInt();
                i++;
            }
        }
        // If it is null, write the coordinate arrays as empty.
        else {
            pylonsX = new int[0];
            pylonsY = new int[0];
            pylonsZ = new int[0];
            pylonsMaster = new int[0];
        }
        // Write the coordinate arrays.
        tagCompound.setIntArray(name + "_x", pylonsX);
        tagCompound.setIntArray(name + "_y", pylonsY);
        tagCompound.setIntArray(name + "_z", pylonsZ);
        tagCompound.setIntArray(name + "_master", pylonsMaster);
    }

    /**
     * Reads an ArrayList of HexPylon objects from NBT.
     * @param tagCompound NBTTagCompound to read from.
     * @param name Name to use for reading from NBT.
     * @return The ArrayList of HexPylon objects.
     */
    public static ArrayList<HexPylon> readHexPylonsArrayFromNBT(NBTTagCompound tagCompound, String name) {
        ArrayList<HexPylon> pylons = new ArrayList<HexPylon>();
        int pylonsX[];
        int pylonsY[];
        int pylonsZ[];
        int pylonsMaster[];

        // Read the coordinate arrays.
        pylonsX = tagCompound.getIntArray(name + "_x");
        pylonsY = tagCompound.getIntArray(name + "_y");
        pylonsZ = tagCompound.getIntArray(name + "_z");
        pylonsMaster = tagCompound.getIntArray(name + "_master");
        // Build the device list using the coordinate arrays. Use null for block.
        for (int i = 0; i < pylonsX.length; i++)
            pylons.add(new HexPylon(pylonsX[i], pylonsY[i], pylonsZ[i], pylonsMaster[i]));

        return pylons;
    }

    /**
     * Writes an container to NBT.
     * @param tagCompound NBTTagCompound to write to.
     * @param inventory The container to write to NBT.
     */
    public static void writeInventoryToNBT(NBTTagCompound tagCompound, ItemStack[] inventory) {
        NBTTagList tagsItems = new NBTTagList();

        for (int i = 0; i < inventory.length; ++i) {
            if (inventory[i] != null) {
                NBTTagCompound tagCompound1 = new NBTTagCompound();
                tagCompound1.setByte("slot", (byte) i);
                inventory[i].writeToNBT(tagCompound1);
                tagsItems.appendTag(tagCompound1);
            }
        }
        tagCompound.setTag("items", tagsItems);
    }

    /**
     * Reads an container from NBT.
     * @param tagCompound NBTTagCompound to read from.
     * @param invSize Size of the container.
     * @return The ItemStack array.
     */
    public static ItemStack[] readInventoryFromNBT(NBTTagCompound tagCompound, int invSize) {
        ItemStack inventory[] = new ItemStack[invSize];

        NBTTagList tagsItems = tagCompound.getTagList("items", 10);
        for (int i = 0; i < tagsItems.tagCount(); ++i) {
            NBTTagCompound tagCompound1 = tagsItems.getCompoundTagAt(i);
            byte byte0 = tagCompound1.getByte("slot");

            if (byte0 >= 0 && byte0 < inventory.length) {
                inventory[byte0] = ItemStack.loadItemStackFromNBT(tagCompound1);
            }
        }

        return inventory;
    }

    public static void addChatProbeTitle(EntityPlayer player) {
        player.addChatMessage(new ChatComponentTranslation(""));
        player.addChatMessage(new ChatComponentTranslation("msg.probeTitle.txt"));
    }

    public static void addChatProbeGenericInfo(EntityPlayer player, World world, int x, int y, int z) {
        player.addChatMessage(new ChatComponentTranslation("msg.probeName.txt", world.getBlock(x, y, z).getLocalizedName()));
        player.addChatMessage(new ChatComponentTranslation("msg.probeCoords.txt", x, y, z));
    }

    public static void addChatProbeConnectedMachines(EntityPlayer player, ArrayList<HexDevice> machines, World world, int x, int y, int z) {
        if (machines != null && machines.size() != 0) {
            if (!(machines.size() == 1 && machines.get(0).x == x && machines.get(0).y == y && machines.get(0).z == z)) {
                for (HexDevice entry : machines)
                    if (!(entry.x == x && entry.y == y && entry.z == z))
                        player.addChatMessage(new ChatComponentTranslation("msg.probeConnectedEntry.txt", entry.x, entry.y, entry.z,
                                world.getBlock(entry.x, entry.y, entry.z).getLocalizedName()));
            }
            else
                player.addChatMessage(new ChatComponentTranslation("msg.probeConnectedNone.txt"));
        }
        else
            player.addChatMessage(new ChatComponentTranslation("msg.probeConnectedNone.txt"));
    }

    public static void addChatProbeConnectedPylons(EntityPlayer player, ArrayList<HexPylon> pylons, World world, int x, int y, int z) {
        if (pylons != null && pylons.size() != 0) {
            if (!(pylons.size() == 1 && pylons.get(0).x == x && pylons.get(0).y == y && pylons.get(0).z == z)) {
                for (HexPylon entry : pylons)
                    if (!(entry.x == x && entry.y == y && entry.z == z))
                        player.addChatMessage(new ChatComponentTranslation("msg.probeConnectedEntry.txt", entry.x, entry.y, entry.z,
                                world.getBlock(entry.x, entry.y, entry.z).getLocalizedName()));
            }
            else
                player.addChatMessage(new ChatComponentTranslation("msg.probeConnectedNone.txt"));
        }
        else
            player.addChatMessage(new ChatComponentTranslation("msg.probeConnectedNone.txt"));
    }
}
