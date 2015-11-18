package com.celestek.hexcraft.util;

import com.celestek.hexcraft.block.*;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.7.0
 */

public class EnergyNodeAnalyzer {

    // Prepare ArrayLists for blocks and cores.
    private ArrayList<HexDevice> blocks;
    private ArrayList<HexDevice> cores;

    /**
     * Constructor.
     */
    public EnergyNodeAnalyzer() {
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

        cores = new ArrayList<HexDevice>() {
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
     * Called recursively to analyze an Energy Node.
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
        if (HexConfig.cfgEnergyNodeVerboseDebug && HexConfig.cfgEnergyNodeDebug)
            System.out.println("[Energy Node Analyzer] Analyzing: (" + x + ", " + y + ", " + z + ") " + block.getUnlocalizedName());

        // Check if the current block is usable to build an Energy Node.
        if (block instanceof BlockHexoriumStructureCasing || block instanceof IBlockHexEnergyPort) {
            // Check if the current block is part of an Energy Node.
            if (HexUtils.getMetaBit(HexBlocks.META_STRUCTURE_IS_PART, world, x, y, z)) {
                // Check if this block has already been added to the blocks ArrayList.
                if (!blocks.contains(new HexDevice(x, y, z, block)))
                    blocks.add(new HexDevice(x, y, z, block));
                else
                    // If the block is already in the blocks ArrayList, exit recursion.
                    return;
            }
            else
                return;
        }
        // Check if the current block is a core.
        else if (block instanceof BlockEnergyNodeCore) {
            // Check if the current core is part of an Energy Node.
            if (HexUtils.getMetaBit(HexBlocks.META_STRUCTURE_IS_PART, world, x, y, z)) {
                // Check if this core has already been added to the cores ArrayList.
                if (!cores.contains(new HexDevice(x, y, z, block)))
                    cores.add(new HexDevice(x, y, z, block));
                else
                    // If the core is already in the cores ArrayList, exit recursion.
                    return;
            }
            else
                return;
        }
        else
            // Exit recursion if the block is not an Energy Node block or core.
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
    public void analyzeEnergyNode(World world, int x, int y, int z) {
        // Call the analysis and wait for results.
        analyze(world, x, y, z, -1);
        // Push the results to all found cores.
        pushCores(world);
    }

    /**
     * Pushes the results of scanning to valves.
     *
     * @param world The world that the tank is in.
     */
    private void pushCores(World world) {

        // Notify about pushing valves.
        if (HexConfig.cfgEnergyNodeDebug)
            System.out.println("Done! Pushing data to cores:");

        // Go through all cores ArrayList entries.
        for (HexDevice entry : cores) {
            // Notify about every core.
            if (HexConfig.cfgEnergyNodeDebug)
                System.out.println(" > (" + entry.x + ", " + entry.y + ", " + entry.z + ") " + entry.block.getUnlocalizedName());

            if(!HexEnergyNode.checkEnergyNode(false, world, entry.x, entry.y, entry.z)) {
                HexEnergyNode.resetEnergyNode(world, entry.x, entry.y, entry.z);
            }
        }
    }
}