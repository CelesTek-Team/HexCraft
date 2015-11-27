package com.celestek.hexcraft.init;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.8.1
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

    // Other
    private WorldGenerator oreHexoriumOtherOreRed;
    private WorldGenerator oreHexoriumOtherOreGreen;
    private WorldGenerator oreHexoriumOtherOreBlue;
    private WorldGenerator oreHexoriumOtherOreWhite;
    private WorldGenerator oreHexoriumOtherOreBlack;

    private WorldGenerator oreHexoriumOtherMonolithRed;
    private WorldGenerator oreHexoriumOtherMonolithGreen;
    private WorldGenerator oreHexoriumOtherMonolithBlue;
    private WorldGenerator oreHexoriumOtherMonolithWhite;
    private WorldGenerator oreHexoriumOtherMonolithBlack;

    /**
     * Constructor for the class.
     */
    public HexWorldGen() {
        /**
         * Numbers in vein spawning control the number of ores per vein.
         * First number: Minimum ore blocks.
         * Second number: Maximum ore blocks.
         * Numbers in monolith spawning control the spawning height.
         * First number: Minimum height.
         * Second number: Maximum height.
         * Third number: Chance to spawn a monolith, 0-100.
         */

        // Nether
        if (HexConfig.cfgOreGeneralShouldGenerate && HexConfig.cfgOreNetherShouldGenerate) {
            oreHexoriumNetherOreRed = new HexGenOre(HexBlocks.blockHexoriumNetherOreRed, Blocks.netherrack, 
                    HexConfig.cfgNetherOreRedCountMin, HexConfig.cfgNetherOreRedCountMax);
            oreHexoriumNetherOreGreen = new HexGenOre(HexBlocks.blockHexoriumNetherOreGreen, Blocks.netherrack, 
                    HexConfig.cfgNetherOreGreenCountMin, HexConfig.cfgNetherOreGreenCountMax);
            oreHexoriumNetherOreBlue = new HexGenOre(HexBlocks.blockHexoriumNetherOreBlue, Blocks.netherrack, 
                    HexConfig.cfgNetherOreBlueCountMin, HexConfig.cfgNetherOreBlueCountMax);
            oreHexoriumNetherOreWhite = new HexGenOre(HexBlocks.blockHexoriumNetherOreWhite, Blocks.netherrack, 
                    HexConfig.cfgNetherOreWhiteCountMin, HexConfig.cfgNetherOreWhiteCountMax);
            oreHexoriumNetherOreBlack = new HexGenOre(HexBlocks.blockHexoriumNetherOreBlack, Blocks.netherrack, 
                    HexConfig.cfgNetherOreBlackCountMin, HexConfig.cfgNetherOreBlackCountMax);
        }

        if (HexConfig.cfgMonolithGeneralShouldGenerate && HexConfig.cfgMonolithNetherShouldGenerate) {
            oreHexoriumNetherMonolithRed = new HexGenMonolith(HexBlocks.blockHexoriumNetherMonolithRed, Blocks.netherrack,
                    HexConfig.cfgNetherMonolithRedHeightMin, HexConfig.cfgNetherMonolithRedHeightMax, HexConfig.cfgNetherMonolithRedChance);
            oreHexoriumNetherMonolithGreen = new HexGenMonolith(HexBlocks.blockHexoriumNetherMonolithGreen, Blocks.netherrack,
                    HexConfig.cfgNetherMonolithGreenHeightMin, HexConfig.cfgNetherMonolithGreenHeightMax, HexConfig.cfgNetherMonolithGreenChance);
            oreHexoriumNetherMonolithBlue = new HexGenMonolith(HexBlocks.blockHexoriumNetherMonolithBlue, Blocks.netherrack,
                    HexConfig.cfgNetherMonolithBlueHeightMin, HexConfig.cfgNetherMonolithBlueHeightMax, HexConfig.cfgNetherMonolithBlueChance);
            oreHexoriumNetherMonolithWhite = new HexGenMonolith(HexBlocks.blockHexoriumNetherMonolithWhite, Blocks.netherrack,
                    HexConfig.cfgNetherMonolithWhiteHeightMin, HexConfig.cfgNetherMonolithWhiteHeightMax, HexConfig.cfgNetherMonolithWhiteChance);
            oreHexoriumNetherMonolithBlack = new HexGenMonolith(HexBlocks.blockHexoriumNetherMonolithBlack, Blocks.netherrack,
                    HexConfig.cfgNetherMonolithBlackHeightMin, HexConfig.cfgNetherMonolithBlackHeightMax, HexConfig.cfgNetherMonolithBlackChance);
        }

        // Overworld
        if (HexConfig.cfgOreGeneralShouldGenerate && HexConfig.cfgOreOverworldShouldGenerate) {
            oreHexoriumOreRed = new HexGenOre(HexBlocks.blockHexoriumOreRed, Blocks.stone, 
                    HexConfig.cfgOverworldOreRedCountMin, HexConfig.cfgOverworldOreRedCountMax);
            oreHexoriumOreGreen = new HexGenOre(HexBlocks.blockHexoriumOreGreen, Blocks.stone, 
                    HexConfig.cfgOverworldOreGreenCountMin, HexConfig.cfgOverworldOreGreenCountMax);
            oreHexoriumOreBlue = new HexGenOre(HexBlocks.blockHexoriumOreBlue, Blocks.stone, 
                    HexConfig.cfgOverworldOreBlueCountMin, HexConfig.cfgOverworldOreBlueCountMax);
            oreHexoriumOreWhite = new HexGenOre(HexBlocks.blockHexoriumOreWhite, Blocks.stone, 
                    HexConfig.cfgOverworldOreWhiteCountMin, HexConfig.cfgOverworldOreWhiteCountMax);
            oreHexoriumOreBlack = new HexGenOre(HexBlocks.blockHexoriumOreBlack, Blocks.stone, 
                    HexConfig.cfgOverworldOreBlackCountMin, HexConfig.cfgOverworldOreBlackCountMax);
        }

        if (HexConfig.cfgMonolithGeneralShouldGenerate && HexConfig.cfgMonolithOverworldShouldGenerate) {
            oreHexoriumMonolithRed = new HexGenMonolith(HexBlocks.blockHexoriumMonolithRed, Blocks.stone,
                    HexConfig.cfgOverworldMonolithRedHeightMin, HexConfig.cfgOverworldMonolithRedHeightMax, HexConfig.cfgOverworldMonolithRedChance);
            oreHexoriumMonolithGreen = new HexGenMonolith(HexBlocks.blockHexoriumMonolithGreen, Blocks.stone,
                    HexConfig.cfgOverworldMonolithGreenHeightMin, HexConfig.cfgOverworldMonolithGreenHeightMax, HexConfig.cfgOverworldMonolithGreenChance);
            oreHexoriumMonolithBlue = new HexGenMonolith(HexBlocks.blockHexoriumMonolithBlue, Blocks.stone,
                    HexConfig.cfgOverworldMonolithBlueHeightMin, HexConfig.cfgOverworldMonolithBlueHeightMax, HexConfig.cfgOverworldMonolithBlueChance);
            oreHexoriumMonolithWhite = new HexGenMonolith(HexBlocks.blockHexoriumMonolithWhite, Blocks.stone,
                    HexConfig.cfgOverworldMonolithWhiteHeightMin, HexConfig.cfgOverworldMonolithWhiteHeightMax, HexConfig.cfgOverworldMonolithWhiteChance);
            oreHexoriumMonolithBlack = new HexGenMonolith(HexBlocks.blockHexoriumMonolithBlack, Blocks.stone,
                    HexConfig.cfgOverworldMonolithBlackHeightMin, HexConfig.cfgOverworldMonolithBlackHeightMax, HexConfig.cfgOverworldMonolithBlackChance);
        }

        // Other
        if (HexConfig.cfgOreGeneralShouldGenerate && HexConfig.cfgOreOtherShouldGenerate) {
            oreHexoriumOtherOreRed = new HexGenOre(HexBlocks.blockHexoriumOreRed, Blocks.stone,
                    HexConfig.cfgOtherOreRedCountMin, HexConfig.cfgOtherOreRedCountMax);
            oreHexoriumOtherOreGreen = new HexGenOre(HexBlocks.blockHexoriumOreGreen, Blocks.stone,
                    HexConfig.cfgOtherOreGreenCountMin, HexConfig.cfgOtherOreGreenCountMax);
            oreHexoriumOtherOreBlue = new HexGenOre(HexBlocks.blockHexoriumOreBlue, Blocks.stone,
                    HexConfig.cfgOtherOreBlueCountMin, HexConfig.cfgOtherOreBlueCountMax);
            oreHexoriumOtherOreWhite = new HexGenOre(HexBlocks.blockHexoriumOreWhite, Blocks.stone,
                    HexConfig.cfgOtherOreWhiteCountMin, HexConfig.cfgOtherOreWhiteCountMax);
            oreHexoriumOtherOreBlack = new HexGenOre(HexBlocks.blockHexoriumOreBlack, Blocks.stone,
                    HexConfig.cfgOtherOreBlackCountMin, HexConfig.cfgOtherOreBlackCountMax);
        }

        if (HexConfig.cfgMonolithGeneralShouldGenerate && HexConfig.cfgMonolithOtherShouldGenerate) {
            oreHexoriumOtherMonolithRed = new HexGenMonolith(HexBlocks.blockHexoriumMonolithRed, Blocks.stone,
                    HexConfig.cfgOtherMonolithRedHeightMin, HexConfig.cfgOtherMonolithRedHeightMax, HexConfig.cfgOtherMonolithRedChance);
            oreHexoriumOtherMonolithGreen = new HexGenMonolith(HexBlocks.blockHexoriumMonolithGreen, Blocks.stone,
                    HexConfig.cfgOtherMonolithGreenHeightMin, HexConfig.cfgOtherMonolithGreenHeightMax, HexConfig.cfgOtherMonolithGreenChance);
            oreHexoriumOtherMonolithBlue = new HexGenMonolith(HexBlocks.blockHexoriumMonolithBlue, Blocks.stone,
                    HexConfig.cfgOtherMonolithBlueHeightMin, HexConfig.cfgOtherMonolithBlueHeightMax, HexConfig.cfgOtherMonolithBlueChance);
            oreHexoriumOtherMonolithWhite = new HexGenMonolith(HexBlocks.blockHexoriumMonolithWhite, Blocks.stone,
                    HexConfig.cfgOtherMonolithWhiteHeightMin, HexConfig.cfgOtherMonolithWhiteHeightMax, HexConfig.cfgOtherMonolithWhiteChance);
            oreHexoriumOtherMonolithBlack = new HexGenMonolith(HexBlocks.blockHexoriumMonolithBlack, Blocks.stone,
                    HexConfig.cfgOtherMonolithBlackHeightMin, HexConfig.cfgOtherMonolithBlackHeightMax, HexConfig.cfgOtherMonolithBlackChance);
        }
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
                if (HexConfig.cfgOreGeneralShouldGenerate && HexConfig.cfgOreNetherShouldGenerate) {
                    runGenerator(oreHexoriumNetherOreRed, world, random, chunkX, chunkZ, 
                            HexConfig.cfgNetherOreRedVeins, HexConfig.cfgNetherOreRedHeightMin, HexConfig.cfgNetherOreRedHeightMax);
                    runGenerator(oreHexoriumNetherOreGreen, world, random, chunkX, chunkZ, 
                            HexConfig.cfgNetherOreGreenVeins, HexConfig.cfgNetherOreGreenHeightMin, HexConfig.cfgNetherOreGreenHeightMax);
                    runGenerator(oreHexoriumNetherOreBlue, world, random, chunkX, chunkZ, 
                            HexConfig.cfgNetherOreBlueVeins, HexConfig.cfgNetherOreBlueHeightMin, HexConfig.cfgNetherOreBlueHeightMax);
                    runGenerator(oreHexoriumNetherOreWhite, world, random, chunkX, chunkZ, 
                            HexConfig.cfgNetherOreWhiteVeins, HexConfig.cfgNetherOreWhiteHeightMin, HexConfig.cfgNetherOreWhiteHeightMax);
                    runGenerator(oreHexoriumNetherOreBlack, world, random, chunkX, chunkZ, 
                            HexConfig.cfgNetherOreBlackVeins, HexConfig.cfgNetherOreBlackHeightMin, HexConfig.cfgNetherOreBlackHeightMax);
                }

                if (HexConfig.cfgMonolithGeneralShouldGenerate && HexConfig.cfgMonolithNetherShouldGenerate) {
                    runGenerator(oreHexoriumNetherMonolithRed, world, random, chunkX, chunkZ,
                            HexConfig.cfgNetherMonolithRedCount, HexConfig.cfgNetherMonolithRedHeightMin, HexConfig.cfgNetherMonolithRedHeightMax);
                    runGenerator(oreHexoriumNetherMonolithGreen, world, random, chunkX, chunkZ,
                            HexConfig.cfgNetherMonolithGreenCount, HexConfig.cfgNetherMonolithGreenHeightMin, HexConfig.cfgNetherMonolithGreenHeightMax);
                    runGenerator(oreHexoriumNetherMonolithBlue, world, random, chunkX, chunkZ,
                            HexConfig.cfgNetherMonolithBlueCount, HexConfig.cfgNetherMonolithBlueHeightMin, HexConfig.cfgNetherMonolithBlueHeightMax);
                    runGenerator(oreHexoriumNetherMonolithWhite, world, random, chunkX, chunkZ,
                            HexConfig.cfgNetherMonolithWhiteCount, HexConfig.cfgNetherMonolithWhiteHeightMin, HexConfig.cfgNetherMonolithWhiteHeightMax);
                    runGenerator(oreHexoriumNetherMonolithBlack, world, random, chunkX, chunkZ,
                            HexConfig.cfgNetherMonolithBlackCount, HexConfig.cfgNetherMonolithBlackHeightMin, HexConfig.cfgNetherMonolithBlackHeightMax);
                }
                break;

            // Overworld
            case 0:
                if (HexConfig.cfgOreGeneralShouldGenerate && HexConfig.cfgOreOverworldShouldGenerate) {
                    runGenerator(oreHexoriumOreRed, world, random, chunkX, chunkZ, 
                            HexConfig.cfgOverworldOreRedVeins, HexConfig.cfgOverworldOreRedHeightMin, HexConfig.cfgOverworldOreRedHeightMax);
                    runGenerator(oreHexoriumOreGreen, world, random, chunkX, chunkZ, 
                            HexConfig.cfgOverworldOreGreenVeins, HexConfig.cfgOverworldOreGreenHeightMin, HexConfig.cfgOverworldOreGreenHeightMax);
                    runGenerator(oreHexoriumOreBlue, world, random, chunkX, chunkZ, 
                            HexConfig.cfgOverworldOreBlueVeins, HexConfig.cfgOverworldOreBlueHeightMin, HexConfig.cfgOverworldOreBlueHeightMax);
                    runGenerator(oreHexoriumOreWhite, world, random, chunkX, chunkZ, 
                            HexConfig.cfgOverworldOreWhiteVeins, HexConfig.cfgOverworldOreWhiteHeightMin, HexConfig.cfgOverworldOreWhiteHeightMax);
                    runGenerator(oreHexoriumOreBlack, world, random, chunkX, chunkZ, 
                            HexConfig.cfgOverworldOreBlackVeins, HexConfig.cfgOverworldOreBlackHeightMin, HexConfig.cfgOverworldOreBlackHeightMax);
                }

                if (HexConfig.cfgMonolithGeneralShouldGenerate && HexConfig.cfgMonolithOverworldShouldGenerate) {
                    runGenerator(oreHexoriumMonolithRed, world, random, chunkX, chunkZ,
                            HexConfig.cfgOverworldMonolithRedCount, HexConfig.cfgOverworldMonolithRedHeightMin, HexConfig.cfgOverworldMonolithRedHeightMax);
                    runGenerator(oreHexoriumMonolithGreen, world, random, chunkX, chunkZ,
                            HexConfig.cfgOverworldMonolithGreenCount, HexConfig.cfgOverworldMonolithGreenHeightMin, HexConfig.cfgOverworldMonolithGreenHeightMax);
                    runGenerator(oreHexoriumMonolithBlue, world, random, chunkX, chunkZ,
                            HexConfig.cfgOverworldMonolithBlueCount, HexConfig.cfgOverworldMonolithBlueHeightMin, HexConfig.cfgOverworldMonolithBlueHeightMax);
                    runGenerator(oreHexoriumMonolithWhite, world, random, chunkX, chunkZ,
                            HexConfig.cfgOverworldMonolithWhiteCount, HexConfig.cfgOverworldMonolithWhiteHeightMin, HexConfig.cfgOverworldMonolithWhiteHeightMax);
                    runGenerator(oreHexoriumMonolithBlack, world, random, chunkX, chunkZ,
                            HexConfig.cfgOverworldMonolithBlackCount, HexConfig.cfgOverworldMonolithBlackHeightMin, HexConfig.cfgOverworldMonolithBlackHeightMax);
                }
                break;

            // End
            case 1:
                break;
            
            // Other
            default:
                if (HexConfig.cfgOreGeneralShouldGenerate && HexConfig.cfgOreOtherShouldGenerate) {
                    runGenerator(oreHexoriumOtherOreRed, world, random, chunkX, chunkZ,
                            HexConfig.cfgOtherOreRedVeins, HexConfig.cfgOtherOreRedHeightMin, HexConfig.cfgOtherOreRedHeightMax);
                    runGenerator(oreHexoriumOtherOreGreen, world, random, chunkX, chunkZ,
                            HexConfig.cfgOtherOreGreenVeins, HexConfig.cfgOtherOreGreenHeightMin, HexConfig.cfgOtherOreGreenHeightMax);
                    runGenerator(oreHexoriumOtherOreBlue, world, random, chunkX, chunkZ,
                            HexConfig.cfgOtherOreBlueVeins, HexConfig.cfgOtherOreBlueHeightMin, HexConfig.cfgOtherOreBlueHeightMax);
                    runGenerator(oreHexoriumOtherOreWhite, world, random, chunkX, chunkZ,
                            HexConfig.cfgOtherOreWhiteVeins, HexConfig.cfgOtherOreWhiteHeightMin, HexConfig.cfgOtherOreWhiteHeightMax);
                    runGenerator(oreHexoriumOtherOreBlack, world, random, chunkX, chunkZ,
                            HexConfig.cfgOtherOreBlackVeins, HexConfig.cfgOtherOreBlackHeightMin, HexConfig.cfgOtherOreBlackHeightMax);
                }

                if (HexConfig.cfgMonolithGeneralShouldGenerate && HexConfig.cfgMonolithOtherShouldGenerate) {
                    runGenerator(oreHexoriumOtherMonolithRed, world, random, chunkX, chunkZ,
                            HexConfig.cfgOtherMonolithRedCount, HexConfig.cfgOtherMonolithRedHeightMin, HexConfig.cfgOtherMonolithRedHeightMax);
                    runGenerator(oreHexoriumOtherMonolithGreen, world, random, chunkX, chunkZ,
                            HexConfig.cfgOtherMonolithGreenCount, HexConfig.cfgOtherMonolithGreenHeightMin, HexConfig.cfgOtherMonolithGreenHeightMax);
                    runGenerator(oreHexoriumOtherMonolithBlue, world, random, chunkX, chunkZ,
                            HexConfig.cfgOtherMonolithBlueCount, HexConfig.cfgOtherMonolithBlueHeightMin, HexConfig.cfgOtherMonolithBlueHeightMax);
                    runGenerator(oreHexoriumOtherMonolithWhite, world, random, chunkX, chunkZ,
                            HexConfig.cfgOtherMonolithWhiteCount, HexConfig.cfgOtherMonolithWhiteHeightMin, HexConfig.cfgOtherMonolithWhiteHeightMax);
                    runGenerator(oreHexoriumOtherMonolithBlack, world, random, chunkX, chunkZ,
                            HexConfig.cfgOtherMonolithBlackCount, HexConfig.cfgOtherMonolithBlackHeightMin, HexConfig.cfgOtherMonolithBlackHeightMax);
                }
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
