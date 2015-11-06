package com.celestek.hexcraft.util;

/**
 * @Author CoffeePirate     <celestek@openmailbox.org>
 * @Version 0.1.0
 */

import net.minecraft.world.World;

/**
 * A simple utilities class which holds methods commonly used throughout the project
 */
public class HexUtils {
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

    public static String formatFluids(int value) {
        if (value >= 1000 && value < 1000000)
            return String.format("%.3f B", (float) value / 1000);
        else if (value >= 1000000 && value < 1000000000)
            return String.format("%.3f KB", (float) value / 1000000);
        else if (value >= 1000000000)
            return String.format("%.3f MB", (float) value / 1000000000);
        else
            return String.format("%d mB", value);
    }
}
