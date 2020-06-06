package com.celestek.hexcraft.init;

import com.celestek.hexcraft.block.BlockHexoriumMonolith;
import com.celestek.hexcraft.block.BlockHexoriumNetherMonolith;
import com.celestek.hexcraft.util.HexUtils;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class HexGenMonolith extends WorldGenerator {

    // Used later for generation.
    private final Block block;
    private final Block target;
    int heightMin;
    int heightMax;
    int chance;

    /**
     * Constructor for the monolith generator class.
     * @param heightMin Minimum height to spawn the monolith in.
     * @param heightMax Maximum height to spawn the monolith in.
     */
    public HexGenMonolith(Block block, Block target, int heightMin, int heightMax, int chance) {

        // Load the constructor parameters.
        this.block = block;
        this.target = target;
        this.heightMin = heightMin;
        this.heightMax = heightMax;
        this.chance = chance;
    }

    /**
     * Method used for the generation of monoliths.
     */
    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {

        // Prepare direction of moving, side of placement and chance of spawning a monolith.
        int direction = random.nextInt(2);
        int side = random.nextInt(2);
        int skip = random.nextInt(101);

        int metaDown = 0;
        if (block instanceof BlockHexoriumMonolith)
            metaDown = HexUtils.setBitTriInt(
                    BlockHexoriumMonolith.META_ORIENTATION_0,
                    BlockHexoriumMonolith.META_ORIENTATION_1,
                    BlockHexoriumMonolith.META_ORIENTATION_2, 0, 0);
        else if (block instanceof BlockHexoriumNetherMonolith)
            metaDown = HexUtils.setBitTriInt(
                    BlockHexoriumNetherMonolith.META_ORIENTATION_0,
                    BlockHexoriumNetherMonolith.META_ORIENTATION_1,
                    BlockHexoriumNetherMonolith.META_ORIENTATION_2, 0, 0);

        int metaUp = 0;
        if (block instanceof BlockHexoriumMonolith)
            metaUp = HexUtils.setBitTriInt(
                    BlockHexoriumMonolith.META_ORIENTATION_0,
                    BlockHexoriumMonolith.META_ORIENTATION_1,
                    BlockHexoriumMonolith.META_ORIENTATION_2, 1, 0);
        else if (block instanceof BlockHexoriumNetherMonolith)
            metaUp = HexUtils.setBitTriInt(
                    BlockHexoriumNetherMonolith.META_ORIENTATION_0,
                    BlockHexoriumNetherMonolith.META_ORIENTATION_1,
                    BlockHexoriumNetherMonolith.META_ORIENTATION_2, 1, 0);


        // Proceed only if the result is within the chance threshold.
        if (skip <= chance) {
            // If it should move downwards...
            if (direction == 0) {
                do {
                    // And if it should be placed upside-down...
                    if (side == 0) {
                        // Check if the current spot is fitting.
                        if (world.blockExists(x, y, z)) {
                            if (world.isAirBlock(x, y, z) && world.getBlock(x, y + 1, z).isReplaceableOreGen(world, x, y, z, target)) {
                                // If yes, place monolith.
                                world.setBlock(x, y, z, block, metaDown, 2);
                                break;
                            }
                            else
                                // Otherwise, move downwards.
                                y--;
                        }
                    }
                    // And if it should be placed upwards...
                    else {
                        // Check if the current spot is fitting.
                        if (world.blockExists(x, y, z)) {
                            if (world.isAirBlock(x, y, z) && world.getBlock(x, y - 1, z).isReplaceableOreGen(world, x, y, z, target)) {
                                // If yes, place monolith.
                                world.setBlock(x, y, z, block, metaUp, 2);
                                break;
                            }
                            else
                                // Otherwise, move downwards.
                                y--;
                        }
                    }
                } while (y >= heightMin);
            }
            // If it should move upwards...
            else {
                do {
                    // And if it should be placed upside-down...
                    if (side == 0) {
                        // Check if the current spot is fitting.
                        if (world.blockExists(x, y, z)) {
                            if (world.isAirBlock(x, y, z) && world.getBlock(x, y + 1, z).isReplaceableOreGen(world, x, y, z, target)) {
                                // If yes, place monolith.
                                world.setBlock(x, y, z, block, metaDown, 2);
                                break;
                            }
                            else
                                // Otherwise, move upwards.
                                y++;
                        }
                    }
                    // And if it should be placed upwards...
                    else {
                        // Check if the current spot is fitting.
                        if (world.blockExists(x, y, z)) {
                            if (world.isAirBlock(x, y, z) && world.getBlock(x, y - 1, z).isReplaceableOreGen(world, x, y, z, target)) {
                                // If yes, place monolith.
                                world.setBlock(x, y, z, block, metaUp, 2);
                                break;
                            }
                            else
                                // Otherwise, move upwards.
                                y++;
                        }
                    }
                } while (y <= heightMax);
            }
        }

        return true;
    }
}
