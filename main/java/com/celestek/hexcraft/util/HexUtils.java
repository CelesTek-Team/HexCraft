package com.celestek.hexcraft.util;

/**
 * @Author CoffeePirate     <celestek@openmailbox.org>
 * @Version 0.1.0
 */

/**
 * A simple utilities class which holds methods commonly used throughout the project
 */
public class HexUtils {

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
}
