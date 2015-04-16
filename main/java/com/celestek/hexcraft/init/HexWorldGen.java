package com.celestek.hexcraft.init;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-16
 */
public class HexWorldGen implements IWorldGenerator {

    /** Nether */
    private WorldGenerator oreHexoriumNetherOreRedOverworld;
    private WorldGenerator oreHexoriumNetherOreGreenOverworld;
    private WorldGenerator oreHexoriumNetherOreBlueOverworld;
    private WorldGenerator oreHexoriumNetherOreWhiteOverworld;
    private WorldGenerator oreHexoriumNetherOreBlackOverworld;

    /** Overworld */
    private WorldGenerator oreHexoriumOreRedOverworld;
    private WorldGenerator oreHexoriumOreGreenOverworld;
    private WorldGenerator oreHexoriumOreBlueOverworld;
    private WorldGenerator oreHexoriumOreWhiteOverworld;
    private WorldGenerator oreHexoriumOreBlackOverworld;

    /**
     * Constructor for the class.
     */
    public HexWorldGen()
    {
        /** The number controls the number of ores per vein. */

        /** Nether */
        oreHexoriumNetherOreRedOverworld = new WorldGenMinable(HexBlocks.blockHexoriumNetherOreRed, 8, Blocks.netherrack);
        oreHexoriumNetherOreGreenOverworld = new WorldGenMinable(HexBlocks.blockHexoriumNetherOreGreen, 8, Blocks.netherrack);
        oreHexoriumNetherOreBlueOverworld = new WorldGenMinable(HexBlocks.blockHexoriumNetherOreBlue, 8, Blocks.netherrack);
        oreHexoriumNetherOreWhiteOverworld = new WorldGenMinable(HexBlocks.blockHexoriumNetherOreWhite, 8, Blocks.netherrack);
        oreHexoriumNetherOreBlackOverworld = new WorldGenMinable(HexBlocks.blockHexoriumNetherOreBlack, 8, Blocks.netherrack);

        /** Overworld */
        oreHexoriumOreRedOverworld = new WorldGenMinable(HexBlocks.blockHexoriumOreRed, 8);
        oreHexoriumOreGreenOverworld = new WorldGenMinable(HexBlocks.blockHexoriumOreGreen, 8);
        oreHexoriumOreBlueOverworld = new WorldGenMinable(HexBlocks.blockHexoriumOreBlue, 8);
        oreHexoriumOreWhiteOverworld = new WorldGenMinable(HexBlocks.blockHexoriumOreWhite, 8);
        oreHexoriumOreBlackOverworld = new WorldGenMinable(HexBlocks.blockHexoriumOreBlack, 8);
    }

    /**
     * Runs generators.
     */
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        /** Check the runGenerator method for parameter explanation! */
        switch(world.provider.dimensionId){
            case -1:
                runGenerator(oreHexoriumNetherOreRedOverworld, world, random, chunkX, chunkZ, 20, 0, 64);
                runGenerator(oreHexoriumNetherOreGreenOverworld, world, random, chunkX, chunkZ, 20, 0, 64);
                runGenerator(oreHexoriumNetherOreBlueOverworld, world, random, chunkX, chunkZ, 20, 0, 64);
                runGenerator(oreHexoriumNetherOreWhiteOverworld, world, random, chunkX, chunkZ, 20, 0, 64);
                runGenerator(oreHexoriumNetherOreBlackOverworld, world, random, chunkX, chunkZ, 20, 0, 64);
                break;
            case 0:
                runGenerator(oreHexoriumOreRedOverworld, world, random, chunkX, chunkZ, 20, 0, 64);
                runGenerator(oreHexoriumOreGreenOverworld, world, random, chunkX, chunkZ, 20, 0, 64);
                runGenerator(oreHexoriumOreBlueOverworld, world, random, chunkX, chunkZ, 20, 0, 64);
                runGenerator(oreHexoriumOreWhiteOverworld, world, random, chunkX, chunkZ, 20, 0, 64);
                runGenerator(oreHexoriumOreBlackOverworld, world, random, chunkX, chunkZ, 20, 0, 64);
                break;
            case 1:
                break;
        }
    }

    /**
     * Generates ores based on input parameters.
     * @param generator Ore to spawn.
     * @param chanceToSpawn Maximum number of ore veins to spawn.
     * @param minHeight Minimal height for the ore to spawn.
     * @param maxHeight Maximum height for the ore to spawn.
     */
    private void runGenerator(WorldGenerator generator, World world, Random rand, int chunkX, int chunkZ, int chanceToSpawn, int minHeight, int maxHeight) {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
            throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chanceToSpawn; i ++) {
            int x = chunkX * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunkZ * 16 + rand.nextInt(16);
            generator.generate(world, rand, x, y, z);
        }
    }
}
