package com.celestek.hexcraft.init;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.6.2

 */
public class HexGenMonolith extends WorldGenerator {

    // Used later for generation.
    private Block block;
    private Block target;
    int heightMin;
    int heightMax;
    int chance;

    /**
     * Constructor for the monolith generator class.
     * @param heightMin Minimum height to spawn the monolith in.
     * @param heightMax Maximum height to spawn the monolith in.
     */
    public HexGenMonolith(Block block, Block replace, int heightMin, int heightMax, int chance) {
        this(block, replace);

        // Load the constructor parameters.
        this.heightMin = heightMin;
        this.heightMax = heightMax;
        this.chance = chance;
    }

    public HexGenMonolith(Block block, Block target) {
        this(block, 0, target);
    }

    public HexGenMonolith(Block block, int meta, Block target) {
        this.block = block;
        this.target = target;
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
                                world.setBlock(x, y, z, block, 0, 2);
                                break;
                            } else
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
                                world.setBlock(x, y, z, block, 1, 2);
                                break;
                            } else
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
                                world.setBlock(x, y, z, block, 0, 2);
                                break;
                            } else
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
                                world.setBlock(x, y, z, block, 1, 2);
                                break;
                            } else
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
