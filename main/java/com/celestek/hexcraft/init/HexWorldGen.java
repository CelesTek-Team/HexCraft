package com.celestek.hexcraft.init;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.4.0
 * @since 2015-04-16
 */
public class HexWorldGen implements IWorldGenerator {

    // Nether
    private WorldGenerator oreHexoriumNetherOreRed;
    private WorldGenerator oreHexoriumNetherOreGreen;
    private WorldGenerator oreHexoriumNetherOreBlue;
    private WorldGenerator oreHexoriumNetherOreWhite;
    private WorldGenerator oreHexoriumNetherOreBlack;

    private WorldGenerator oreHexoriumNetherMonolithRed;
    private WorldGenerator oreHexoriumNetherMonolithGreen;
    private WorldGenerator oreHexoriumNetherMonolithBlue;
    private WorldGenerator oreHexoriumNetherMonolithWhite;
    private WorldGenerator oreHexoriumNetherMonolithBlack;

    // Overworld
    private WorldGenerator oreHexoriumOreRed;
    private WorldGenerator oreHexoriumOreGreen;
    private WorldGenerator oreHexoriumOreBlue;
    private WorldGenerator oreHexoriumOreWhite;
    private WorldGenerator oreHexoriumOreBlack;
    
    private WorldGenerator oreHexoriumMonolithRed;
    private WorldGenerator oreHexoriumMonolithGreen;
    private WorldGenerator oreHexoriumMonolithBlue;
    private WorldGenerator oreHexoriumMonolithWhite;
    private WorldGenerator oreHexoriumMonolithBlack;

    /**
     * Constructor for the class.
     */
    public HexWorldGen() {
        /**
         * Numbers in vein spawning control the number of ores per vein.
         * First number: Minimum ore blocks.
         * Second number: Maximum ore blocks.
         * Numbers in monolith spawning control the number of ores per vein.
         * First number: Minimum height.
         * Second number: Maximum height.
         * Third number: Chance to spawn a monolith, 0-100.
         */

        // Nether
        oreHexoriumNetherOreRed = new HexGenOre(HexBlocks.blockHexoriumNetherOreRed, Blocks.netherrack, 1, 3);
        oreHexoriumNetherOreGreen = new HexGenOre(HexBlocks.blockHexoriumNetherOreGreen, Blocks.netherrack, 1, 3);
        oreHexoriumNetherOreBlue = new HexGenOre(HexBlocks.blockHexoriumNetherOreBlue, Blocks.netherrack, 1, 3);
        oreHexoriumNetherOreWhite = new HexGenOre(HexBlocks.blockHexoriumNetherOreWhite, Blocks.netherrack, 2, 6);
        oreHexoriumNetherOreBlack = new HexGenOre(HexBlocks.blockHexoriumNetherOreBlack, Blocks.netherrack, 2, 6);

        oreHexoriumNetherMonolithRed = new HexGenMonolith(HexBlocks.blockHexoriumNetherMonolithRed, Blocks.netherrack, 0, 128, 10);
        oreHexoriumNetherMonolithGreen = new HexGenMonolith(HexBlocks.blockHexoriumNetherMonolithGreen, Blocks.netherrack, 0, 128, 10);
        oreHexoriumNetherMonolithBlue = new HexGenMonolith(HexBlocks.blockHexoriumNetherMonolithBlue, Blocks.netherrack, 0, 128, 10);
        oreHexoriumNetherMonolithWhite = new HexGenMonolith(HexBlocks.blockHexoriumNetherMonolithWhite, Blocks.netherrack, 0, 128, 50);
        oreHexoriumNetherMonolithBlack = new HexGenMonolith(HexBlocks.blockHexoriumNetherMonolithBlack, Blocks.netherrack, 0, 128, 50);

        // Overworld
        oreHexoriumOreRed = new HexGenOre(HexBlocks.blockHexoriumOreRed, Blocks.stone, 2, 6);
        oreHexoriumOreGreen = new HexGenOre(HexBlocks.blockHexoriumOreGreen, Blocks.stone, 2, 6);
        oreHexoriumOreBlue = new HexGenOre(HexBlocks.blockHexoriumOreBlue, Blocks.stone, 2, 6);
        oreHexoriumOreWhite = new HexGenOre(HexBlocks.blockHexoriumOreWhite, Blocks.stone, 1, 3);
        oreHexoriumOreBlack = new HexGenOre(HexBlocks.blockHexoriumOreBlack, Blocks.stone, 1, 3);
        
        oreHexoriumMonolithRed = new HexGenMonolith(HexBlocks.blockHexoriumMonolithRed, Blocks.stone, 0, 60, 100);
        oreHexoriumMonolithGreen = new HexGenMonolith(HexBlocks.blockHexoriumMonolithGreen, Blocks.stone, 0, 60, 100);
        oreHexoriumMonolithBlue = new HexGenMonolith(HexBlocks.blockHexoriumMonolithBlue, Blocks.stone, 0, 60, 100);
        oreHexoriumMonolithWhite = new HexGenMonolith(HexBlocks.blockHexoriumMonolithWhite, Blocks.stone, 0, 20, 10);
        oreHexoriumMonolithBlack = new HexGenMonolith(HexBlocks.blockHexoriumMonolithBlack, Blocks.stone, 0, 20, 10);
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

            // Nether
            case -1:
                runGenerator(oreHexoriumNetherOreRed, world, random, chunkX, chunkZ, 5, 0, 128);
                runGenerator(oreHexoriumNetherOreGreen, world, random, chunkX, chunkZ, 5, 0, 128);
                runGenerator(oreHexoriumNetherOreBlue, world, random, chunkX, chunkZ, 5, 0, 128);
                runGenerator(oreHexoriumNetherOreWhite, world, random, chunkX, chunkZ, 10, 0, 128);
                runGenerator(oreHexoriumNetherOreBlack, world, random, chunkX, chunkZ, 10, 0, 128);

                runGenerator(oreHexoriumNetherMonolithRed, world, random, chunkX, chunkZ, 1, 0, 128);
                runGenerator(oreHexoriumNetherMonolithGreen, world, random, chunkX, chunkZ, 1, 0, 128);
                runGenerator(oreHexoriumNetherMonolithBlue, world, random, chunkX, chunkZ, 1, 0, 128);
                runGenerator(oreHexoriumNetherMonolithWhite, world, random, chunkX, chunkZ, 1, 0, 128);
                runGenerator(oreHexoriumNetherMonolithBlack, world, random, chunkX, chunkZ, 1, 0, 128);
                break;

            // Overworld
            case 0:
                runGenerator(oreHexoriumOreRed, world, random, chunkX, chunkZ, 10, 0, 64);
                runGenerator(oreHexoriumOreGreen, world, random, chunkX, chunkZ, 10, 0, 64);
                runGenerator(oreHexoriumOreBlue, world, random, chunkX, chunkZ, 10, 0, 64);
                runGenerator(oreHexoriumOreWhite, world, random, chunkX, chunkZ, 5, 0, 20);
                runGenerator(oreHexoriumOreBlack, world, random, chunkX, chunkZ, 5, 0, 20);

                runGenerator(oreHexoriumMonolithRed, world, random, chunkX, chunkZ, 1, 0, 60);
                runGenerator(oreHexoriumMonolithGreen, world, random, chunkX, chunkZ, 1, 0, 60);
                runGenerator(oreHexoriumMonolithBlue, world, random, chunkX, chunkZ, 1, 0, 60);
                runGenerator(oreHexoriumMonolithWhite, world, random, chunkX, chunkZ, 1, 0, 20);
                runGenerator(oreHexoriumMonolithBlack, world, random, chunkX, chunkZ, 1, 0, 20);
                break;

            // End
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
        // Loop the spawning script veinCount times.
        for (int i = 0; i < veinCount; i ++) {
            // Prepare the randomly generated coordinates for the first vein block.
            int x = chunkX * 16 + random.nextInt(16);
            int y = heightMin + random.nextInt(heightMax - heightMin + 1);
            int z = chunkZ * 16 + random.nextInt(16);
            // Start spawning vein.
            generator.generate(world, random, x, y, z);
        }
    }
}
