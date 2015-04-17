package com.celestek.hexcraft.init;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
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
    public HexWorldGen() {
        /**
         * Numbers control the number of ores per vein.
         * First number: Minimum ore blocks.
         * Second number: Maximum ore blocks.
         */

        /** Nether */
        oreHexoriumNetherOreRedOverworld = new HexOreGen(HexBlocks.blockHexoriumNetherOreRed, Blocks.netherrack, 1, 3);
        oreHexoriumNetherOreGreenOverworld = new HexOreGen(HexBlocks.blockHexoriumNetherOreGreen, Blocks.netherrack, 1, 3);
        oreHexoriumNetherOreBlueOverworld = new HexOreGen(HexBlocks.blockHexoriumNetherOreBlue, Blocks.netherrack, 1, 3);
        oreHexoriumNetherOreWhiteOverworld = new HexOreGen(HexBlocks.blockHexoriumNetherOreWhite, Blocks.netherrack, 2, 6);
        oreHexoriumNetherOreBlackOverworld = new HexOreGen(HexBlocks.blockHexoriumNetherOreBlack, Blocks.netherrack, 2, 6);

        /** Overworld */
        oreHexoriumOreRedOverworld = new HexOreGen(HexBlocks.blockHexoriumOreRed, Blocks.stone, 2, 6);
        oreHexoriumOreGreenOverworld = new HexOreGen(HexBlocks.blockHexoriumOreGreen, Blocks.stone, 2, 6);
        oreHexoriumOreBlueOverworld = new HexOreGen(HexBlocks.blockHexoriumOreBlue, Blocks.stone, 2, 6);
        oreHexoriumOreWhiteOverworld = new HexOreGen(HexBlocks.blockHexoriumOreWhite, Blocks.stone, 1, 3);
        oreHexoriumOreBlackOverworld = new HexOreGen(HexBlocks.blockHexoriumOreBlack, Blocks.stone, 1, 1);
    }

    /**
     * Runs generators.
     */
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        /**
         * Numbers control the spawning heights and vein counts.
         * First number: Number of veins to spawn per chunk.
         * Second number: Minimum height to spawn a vein in.
         * Third number: Maximum height to spawn a vein in.
         */
        switch(world.provider.dimensionId){

            /** Nether */
            case -1:
                runGenerator(oreHexoriumNetherOreRedOverworld, world, random, chunkX, chunkZ, 5, 0, 128);
                runGenerator(oreHexoriumNetherOreGreenOverworld, world, random, chunkX, chunkZ, 5, 0, 128);
                runGenerator(oreHexoriumNetherOreBlueOverworld, world, random, chunkX, chunkZ, 5, 0, 128);
                runGenerator(oreHexoriumNetherOreWhiteOverworld, world, random, chunkX, chunkZ, 10, 0, 128);
                runGenerator(oreHexoriumNetherOreBlackOverworld, world, random, chunkX, chunkZ, 10, 0, 128);
                break;

            /** Overworld */
            case 0:
                runGenerator(oreHexoriumOreRedOverworld, world, random, chunkX, chunkZ, 10, 0, 64);
                runGenerator(oreHexoriumOreGreenOverworld, world, random, chunkX, chunkZ, 10, 0, 64);
                runGenerator(oreHexoriumOreBlueOverworld, world, random, chunkX, chunkZ, 10, 0, 64);
                runGenerator(oreHexoriumOreWhiteOverworld, world, random, chunkX, chunkZ, 5, 0, 20);
                runGenerator(oreHexoriumOreBlackOverworld, world, random, chunkX, chunkZ, 5, 0, 20);
                break;

            /** End */
            case 1:
                break;
        }
    }

    /**
     * Generates veins based on input parameters.
     * @param generator Ore to spawn.
     * @param veinCount Maximum number of ore veins to spawn.
     * @param heightMin Minimal height for the ore to spawn.
     * @param heightMax Maximum height for the ore to spawn.
     */
    private void runGenerator(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int veinCount, int heightMin, int heightMax) {
        /** Loop the spawning script veinCount times. */
        for (int i = 0; i < veinCount; i ++) {
            /** Prepare the randomly generated coordinates for the first vein block. */
            int x = chunkX * 16 + random.nextInt(16);
            int y = heightMin + random.nextInt(heightMax - heightMin + 1);
            int z = chunkZ * 16 + random.nextInt(16);
            /** Start spawning vein. */
            generator.generate(world, random, x, y, z);
        }
    }
}
