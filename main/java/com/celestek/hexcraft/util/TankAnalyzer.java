package com.celestek.hexcraft.util;

import com.celestek.hexcraft.block.BlockTankValve;
import com.celestek.hexcraft.block.HexBlockMT;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.tileentity.*;
import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.7.0
 */

public class TankAnalyzer {

    // Prepare ArrayLists for blocks and valves.
    private ArrayList<HexDevice> blocks;
    private ArrayList<HexDevice> valves;

    /**
     * Constructor.
     */
    public TankAnalyzer() {
        blocks = new ArrayList<HexDevice>() {
            @Override
            public boolean contains(Object o) {
                HexDevice block = (HexDevice) o;
                for (HexDevice entry : this) {
                    if ((entry.x == block.x) && (entry.y == block.y) && (entry.z == block.z) && (entry.block == block.block)) {
                        return true;
                    }
                }
                return false;
            }
        };

        valves = new ArrayList<HexDevice>() {
            @Override
            public boolean contains(Object o) {
                HexDevice valves = (HexDevice) o;
                for (HexDevice entry : this) {
                    if ((entry.x == valves.x) && (entry.y == valves.y) && (entry.z == valves.z) && (entry.block == valves.block)) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    /**
     * Called recursively to analyze a tank.
     *
     * @param world The world that the block to analyze is in.
     * @param x     X coordinate of the block to analyze.
     * @param y     Y coordinate of the block to analyze.
     * @param z     Z coordinate of the block to analyze.
     */
    private void analyze(World world, int x, int y, int z, int direction) {
        // Save the current block.
        Block block = world.getBlock(x, y, z);

        // Console spam for debugging analysis.
        if (HexConfig.cfgTankVerboseDebug && HexConfig.cfgTankDebug)
            System.out.println("[Tank Analyzer] Analyzing: (" + x + ", " + y + ", " + z + ") " + block.getUnlocalizedName());

        // Check if the current block is usable to build a tank.
        if (block instanceof HexBlockMT || block == HexBlocks.blockTemperedHexoriumGlass) {
            // Check if the current block is part of a tank.
            if (HexUtils.getMetaBit(BlockTankValve.META_IS_PART, world, x, y, z)) {
                // Check if this block has already been added to the blocks ArrayList.
                if (!blocks.contains(new HexDevice(x, y, z, block)))
                    blocks.add(new HexDevice(x, y, z, block));
                else
                    // If the block is already in the blocks ArrayList, exit recursion.
                    return;
            } else
                return;
        }
        // Check if the current block is a valve.
        else if (block == HexBlocks.blockTankValve) {
            // Check if the current valve is part of a tank.
            if (HexUtils.getMetaBit(BlockTankValve.META_IS_PART, world, x, y, z)) {
                // Check if this valve has already been added to the valves ArrayList.
                if (!valves.contains(new HexDevice(x, y, z, block)))
                    valves.add(new HexDevice(x, y, z, block));
                else
                    // If the valve is already in the valves ArrayList, exit recursion.
                    return;
            } else
                return;
        } else
            // Exit recursion if the block is not a tank block or valve.
            return;

        // Move in all 6 different directions, but avoid going backwards. Call this same function recursively for every direction.
        if (direction != 1)
            analyze(world, x, y - 1, z, 0);
        if (direction != 0)
            analyze(world, x, y + 1, z, 1);
        if (direction != 3)
            analyze(world, x, y, z - 1, 2);
        if (direction != 2)
            analyze(world, x, y, z + 1, 3);
        if (direction != 5)
            analyze(world, x - 1, y, z, 4);
        if (direction != 4)
            analyze(world, x + 1, y, z, 5);
    }

    /**
     * Begins the analysis from a block.
     *
     * @param world The world that the block to analyze is in.
     * @param x     X coordinate of the cable.
     * @param y     Y coordinate of the cable.
     * @param z     Z coordinate of the cable.
     */
    public void analyzeTank(World world, int x, int y, int z) {
        // Call the analysis and wait for results.
        analyze(world, x, y, z, -1);
        // Push the results to all found valves.
        pushValves(world);
    }

    /**
     * Pushes the results of scanning to valves.
     *
     * @param world The world that the tank is in.
     */
    private void pushValves(World world) {

        // Notify about pushing valves.
        if (HexConfig.cfgTankDebug)
            System.out.println("Done! Pushing data to valves:");

        // Go through all valves ArrayList entries.
        for (HexDevice entry : valves) {
            // Notify about every valve.
            if (HexConfig.cfgTankDebug)
                System.out.println(" > (" + entry.x + ", " + entry.y + ", " + entry.z + ") " + entry.block.getUnlocalizedName());

            TileTankValve valve = (TileTankValve) world.getTileEntity(entry.x, entry.y, entry.z);
            if (valve != null) {
                valve.notificationStructureReset();
            }
        }
    }
}