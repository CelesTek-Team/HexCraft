package com.celestek.hexcraft.util;

import com.celestek.hexcraft.init.HexBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * @author CoffeePirate     <celestek@openmailbox.org>
 * @version 0.7.0
 */

/**
 * A simple utilities class which holds methods commonly used throughout the project
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
     * @param dir Direction of rotation, true for upwards, false for downwards.
     * @param n1 First bit of rotation.
     * @param n2 Second bit of rotation.
     * @param world World of the block.
     * @param x X coordinate of block.
     * @param y Y coordinate of block.
     * @param z Z coordinate of block.
     * @param notify Notify parameter to use.
     */
    public static void rotateBlock(boolean dir, int n1, int n2, World world, int x, int y, int z, int notify) {
        int rot = getMetaBitInt(n1, n2, world, x, y, z);
        if (dir) {
            rot++;
            if (rot > 3)
                rot = 0;
        }
        else {
            rot--;
            if (rot < 0)
                rot = 3;
        }
        setMetaBitInt(rot, n1, n2, world, x, y, z, notify);
    }

    /**
     * Returns n-th bit from an integer
     * @param num The integer in question
     * @param n which bit
     * @return Returns the bit
     */
    public static boolean getBit(int num, int n) {
        return ((num >> n) & 1) == 1;
    }

    /**
     * Returns n-th bit from block meta.
     * @param n Which bit of meta.
     * @param world World of the block.
     * @param x X coordinate of block.
     * @param y Y coordinate of block.
     * @param z Z coordinate of block.
     * @return Returns the bool of bit.
     */
    public static boolean getMetaBit(int n, World world, int x, int y, int z) {
        return getBit(world.getBlockMetadata(x, y, z), n);
    }

    /**
     * Returns the int extracted from bits.
     * @param num Number to process.
     * @param n1 First bit.
     * @param n2 Second bit.
     * @return Returns 0-3 int.
     */
    public static int getBitInt(int num, int n1, int n2) {
        return (getBit(num, n1) ? 1 : 0) + (getBit(num, n2) ? 2 : 0);
    }

    /**
     * Returns the int extracted from meta.
     * @param n1 First bit.
     * @param n2 Second bit.
     * @param world World of the block.
     * @param x X coordinate of block.
     * @param y Y coordinate of block.
     * @param z Z coordinate of block.
     * @return Returns 0-3 int.
     */
    public static int getMetaBitInt(int n1, int n2, World world, int x, int y, int z) {
        return getBitInt(world.getBlockMetadata(x, y, z), n1, n2);
    }

    /**
     * Returns the int extracted from meta.
     * @param n1 First bit.
     * @param n2 Second bit.
     * @param world World of the block.
     * @param x X coordinate of block.
     * @param y Y coordinate of block.
     * @param z Z coordinate of block.
     * @return Returns 0-3 int.
     */
    public static int getMetaBitInt(int n1, int n2, IBlockAccess world, int x, int y, int z) {
        return getBitInt(world.getBlockMetadata(x, y, z), n1, n2);
    }

    /**
     * Sets n-th bit for the given integer
     * @param num The integer to set the bit for
     * @param n Which bit, LSB is 0
     * @param val What to set it to
     * @return Int with the n-th bit set
     */
    public static int setBit(int num, int n, boolean val) {
        if (getBit(num, n) != val) {
            int mask = (1 << n);
            return num^mask;
        }
        return num;
    }

    /**
     * Sets n-th bit for meta of a block.
     * @param n Which bit of meta.
     * @param val Bool to set the bit to.
     * @param world World of the block.
     * @param x X coordinate of block.
     * @param y Y coordinate of block.
     * @param z Z coordinate of block.
     * @param notify Notify parameter to use.
     */
    public static void setMetaBit(int n, boolean val, World world, int x, int y, int z, int notify) {
        world.setBlockMetadataWithNotify(x, y, z, setBit(world.getBlockMetadata(x, y, z), n, val), notify);
    }

    /**
     * Sets an int into another int.
     * @param orig Original int to modify.
     * @param num 0-3 int.
     * @param n1 First bit.
     * @param n2 Second bit.
     * @return Modified int.
     */
    public static int setBitInt(int orig, int num, int n1, int n2) {
        orig = setBit(orig, n1, getBit(num, 0));
        orig = setBit(orig, n2, getBit(num, 1));
        return orig;
    }

    /**
     * Sets the int into meta.
     * @param num 0-3 int.
     * @param n1 First bit.
     * @param n2 Second bit.
     * @param world World of the block.
     * @param x X coordinate of block.
     * @param y Y coordinate of block.
     * @param z Z coordinate of block.
     * @param notify Notify parameter to use.
     */
    public static void setMetaBitInt(int num, int n1, int n2, World world, int x, int y, int z, int notify) {
        world.setBlockMetadataWithNotify(x, y, z, setBitInt(world.getBlockMetadata(x, y, z), num, n1, n2), notify);
    }

    /**
     * Flips n-th bit for meta of a block.
     * @param n Which bit of meta.
     * @param world World of the block.
     * @param x X coordinate of block.
     * @param y Y coordinate of block.
     * @param z Z coordinate of block.
     * @param notify Notify parameter to use.
     */
    public static void flipMetaBit(int n, World world, int x, int y, int z, int notify) {
        world.setBlockMetadataWithNotify(x, y, z, setBit(world.getBlockMetadata(x, y, z), n, !getMetaBit(n, world, x, y, z)), notify);
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
}
