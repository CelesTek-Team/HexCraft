package com.celestek.hexcraft.init;

import com.celestek.hexcraft.block.BlockHexoriumMonolith;
import com.celestek.hexcraft.block.BlockHexoriumNetherMonolith;
import com.celestek.hexcraft.block.BlockHexoriumNetherOre;
import com.celestek.hexcraft.block.BlockHexoriumOre;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * @author Thorinair   <celestek@openmailbox.org>
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

        // Overworld
        if (HexConfig.cfgOreGeneralShouldGenerate && HexConfig.cfgOreOverworldShouldGenerate) {
            oreHexoriumOreRed   = new HexGenOre(HexBlocks.getHexBlock(BlockHexoriumOre.ID + BlockHexoriumOre.Colors.RED.name),   Blocks.stone, HexConfig.cfgOverworldOreRedCountMin,   HexConfig.cfgOverworldOreRedCountMax);
            oreHexoriumOreGreen = new HexGenOre(HexBlocks.getHexBlock(BlockHexoriumOre.ID + BlockHexoriumOre.Colors.GREEN.name), Blocks.stone, HexConfig.cfgOverworldOreGreenCountMin, HexConfig.cfgOverworldOreGreenCountMax);
            oreHexoriumOreBlue  = new HexGenOre(HexBlocks.getHexBlock(BlockHexoriumOre.ID + BlockHexoriumOre.Colors.BLUE.name),  Blocks.stone, HexConfig.cfgOverworldOreBlueCountMin,  HexConfig.cfgOverworldOreBlueCountMax);
            oreHexoriumOreWhite = new HexGenOre(HexBlocks.getHexBlock(BlockHexoriumOre.ID + BlockHexoriumOre.Colors.WHITE.name), Blocks.stone, HexConfig.cfgOverworldOreWhiteCountMin, HexConfig.cfgOverworldOreWhiteCountMax);
            oreHexoriumOreBlack = new HexGenOre(HexBlocks.getHexBlock(BlockHexoriumOre.ID + BlockHexoriumOre.Colors.BLACK.name), Blocks.stone, HexConfig.cfgOverworldOreBlackCountMin, HexConfig.cfgOverworldOreBlackCountMax);
        }

        if (HexConfig.cfgMonolithGeneralShouldGenerate && HexConfig.cfgMonolithOverworldShouldGenerate) {
            oreHexoriumMonolithRed   = new HexGenMonolith(HexBlocks.getHexBlock(BlockHexoriumMonolith.ID + BlockHexoriumMonolith.Colors.RED.name),   Blocks.stone, HexConfig.cfgOverworldMonolithRedHeightMin,   HexConfig.cfgOverworldMonolithRedHeightMax,   HexConfig.cfgOverworldMonolithRedChance);
            oreHexoriumMonolithGreen = new HexGenMonolith(HexBlocks.getHexBlock(BlockHexoriumMonolith.ID + BlockHexoriumMonolith.Colors.GREEN.name), Blocks.stone, HexConfig.cfgOverworldMonolithGreenHeightMin, HexConfig.cfgOverworldMonolithGreenHeightMax, HexConfig.cfgOverworldMonolithGreenChance);
            oreHexoriumMonolithBlue  = new HexGenMonolith(HexBlocks.getHexBlock(BlockHexoriumMonolith.ID + BlockHexoriumMonolith.Colors.BLUE.name),  Blocks.stone, HexConfig.cfgOverworldMonolithBlueHeightMin,  HexConfig.cfgOverworldMonolithBlueHeightMax,  HexConfig.cfgOverworldMonolithBlueChance);
            oreHexoriumMonolithWhite = new HexGenMonolith(HexBlocks.getHexBlock(BlockHexoriumMonolith.ID + BlockHexoriumMonolith.Colors.WHITE.name), Blocks.stone, HexConfig.cfgOverworldMonolithWhiteHeightMin, HexConfig.cfgOverworldMonolithWhiteHeightMax, HexConfig.cfgOverworldMonolithWhiteChance);
            oreHexoriumMonolithBlack = new HexGenMonolith(HexBlocks.getHexBlock(BlockHexoriumMonolith.ID + BlockHexoriumMonolith.Colors.BLACK.name), Blocks.stone, HexConfig.cfgOverworldMonolithBlackHeightMin, HexConfig.cfgOverworldMonolithBlackHeightMax, HexConfig.cfgOverworldMonolithBlackChance);
        }

        // Nether
        if (HexConfig.cfgOreGeneralShouldGenerate && HexConfig.cfgOreNetherShouldGenerate) {
            oreHexoriumNetherOreRed   = new HexGenOre(HexBlocks.getHexBlock(BlockHexoriumNetherOre.ID + BlockHexoriumNetherOre.Colors.RED.name),   Blocks.netherrack, HexConfig.cfgNetherOreRedCountMin,   HexConfig.cfgNetherOreRedCountMax);
            oreHexoriumNetherOreGreen = new HexGenOre(HexBlocks.getHexBlock(BlockHexoriumNetherOre.ID + BlockHexoriumNetherOre.Colors.GREEN.name), Blocks.netherrack, HexConfig.cfgNetherOreGreenCountMin, HexConfig.cfgNetherOreGreenCountMax);
            oreHexoriumNetherOreBlue  = new HexGenOre(HexBlocks.getHexBlock(BlockHexoriumNetherOre.ID + BlockHexoriumNetherOre.Colors.BLUE.name),  Blocks.netherrack, HexConfig.cfgNetherOreBlueCountMin,  HexConfig.cfgNetherOreBlueCountMax);
            oreHexoriumNetherOreWhite = new HexGenOre(HexBlocks.getHexBlock(BlockHexoriumNetherOre.ID + BlockHexoriumNetherOre.Colors.WHITE.name), Blocks.netherrack, HexConfig.cfgNetherOreWhiteCountMin, HexConfig.cfgNetherOreWhiteCountMax);
            oreHexoriumNetherOreBlack = new HexGenOre(HexBlocks.getHexBlock(BlockHexoriumNetherOre.ID + BlockHexoriumNetherOre.Colors.BLACK.name), Blocks.netherrack, HexConfig.cfgNetherOreBlackCountMin, HexConfig.cfgNetherOreBlackCountMax);
        }

        if (HexConfig.cfgMonolithGeneralShouldGenerate && HexConfig.cfgMonolithNetherShouldGenerate) {
            oreHexoriumNetherMonolithRed   = new HexGenMonolith(HexBlocks.getHexBlock(BlockHexoriumNetherMonolith.ID + BlockHexoriumNetherMonolith.Colors.RED.name),   Blocks.netherrack, HexConfig.cfgNetherMonolithRedHeightMin,   HexConfig.cfgNetherMonolithRedHeightMax,   HexConfig.cfgNetherMonolithRedChance);
            oreHexoriumNetherMonolithGreen = new HexGenMonolith(HexBlocks.getHexBlock(BlockHexoriumNetherMonolith.ID + BlockHexoriumNetherMonolith.Colors.GREEN.name), Blocks.netherrack, HexConfig.cfgNetherMonolithGreenHeightMin, HexConfig.cfgNetherMonolithGreenHeightMax, HexConfig.cfgNetherMonolithGreenChance);
            oreHexoriumNetherMonolithBlue  = new HexGenMonolith(HexBlocks.getHexBlock(BlockHexoriumNetherMonolith.ID + BlockHexoriumNetherMonolith.Colors.BLUE.name),  Blocks.netherrack, HexConfig.cfgNetherMonolithBlueHeightMin,  HexConfig.cfgNetherMonolithBlueHeightMax,  HexConfig.cfgNetherMonolithBlueChance);
            oreHexoriumNetherMonolithWhite = new HexGenMonolith(HexBlocks.getHexBlock(BlockHexoriumNetherMonolith.ID + BlockHexoriumNetherMonolith.Colors.WHITE.name), Blocks.netherrack, HexConfig.cfgNetherMonolithWhiteHeightMin, HexConfig.cfgNetherMonolithWhiteHeightMax, HexConfig.cfgNetherMonolithWhiteChance);
            oreHexoriumNetherMonolithBlack = new HexGenMonolith(HexBlocks.getHexBlock(BlockHexoriumNetherMonolith.ID + BlockHexoriumNetherMonolith.Colors.BLACK.name), Blocks.netherrack, HexConfig.cfgNetherMonolithBlackHeightMin, HexConfig.cfgNetherMonolithBlackHeightMax, HexConfig.cfgNetherMonolithBlackChance);
        }

        // Other
        if (HexConfig.cfgOreGeneralShouldGenerate && HexConfig.cfgOreOtherShouldGenerate) {
            oreHexoriumOtherOreRed   = new HexGenOre(HexBlocks.getHexBlock(BlockHexoriumOre.ID + BlockHexoriumOre.Colors.RED.name),   Blocks.stone, HexConfig.cfgOtherOreRedCountMin,   HexConfig.cfgOtherOreRedCountMax);
            oreHexoriumOtherOreGreen = new HexGenOre(HexBlocks.getHexBlock(BlockHexoriumOre.ID + BlockHexoriumOre.Colors.GREEN.name), Blocks.stone, HexConfig.cfgOtherOreGreenCountMin, HexConfig.cfgOtherOreGreenCountMax);
            oreHexoriumOtherOreBlue  = new HexGenOre(HexBlocks.getHexBlock(BlockHexoriumOre.ID + BlockHexoriumOre.Colors.BLUE.name),  Blocks.stone, HexConfig.cfgOtherOreBlueCountMin,  HexConfig.cfgOtherOreBlueCountMax);
            oreHexoriumOtherOreWhite = new HexGenOre(HexBlocks.getHexBlock(BlockHexoriumOre.ID + BlockHexoriumOre.Colors.WHITE.name), Blocks.stone, HexConfig.cfgOtherOreWhiteCountMin, HexConfig.cfgOtherOreWhiteCountMax);
            oreHexoriumOtherOreBlack = new HexGenOre(HexBlocks.getHexBlock(BlockHexoriumOre.ID + BlockHexoriumOre.Colors.BLACK.name), Blocks.stone, HexConfig.cfgOtherOreBlackCountMin, HexConfig.cfgOtherOreBlackCountMax);
        }

        if (HexConfig.cfgMonolithGeneralShouldGenerate && HexConfig.cfgMonolithOtherShouldGenerate) {
            oreHexoriumOtherMonolithRed   = new HexGenMonolith(HexBlocks.getHexBlock(BlockHexoriumMonolith.ID + BlockHexoriumMonolith.Colors.RED.name),   Blocks.stone, HexConfig.cfgOtherMonolithRedHeightMin,   HexConfig.cfgOtherMonolithRedHeightMax,   HexConfig.cfgOtherMonolithRedChance);
            oreHexoriumOtherMonolithGreen = new HexGenMonolith(HexBlocks.getHexBlock(BlockHexoriumMonolith.ID + BlockHexoriumMonolith.Colors.GREEN.name), Blocks.stone, HexConfig.cfgOtherMonolithGreenHeightMin, HexConfig.cfgOtherMonolithGreenHeightMax, HexConfig.cfgOtherMonolithGreenChance);
            oreHexoriumOtherMonolithBlue  = new HexGenMonolith(HexBlocks.getHexBlock(BlockHexoriumMonolith.ID + BlockHexoriumMonolith.Colors.BLUE.name),  Blocks.stone, HexConfig.cfgOtherMonolithBlueHeightMin,  HexConfig.cfgOtherMonolithBlueHeightMax,  HexConfig.cfgOtherMonolithBlueChance);
            oreHexoriumOtherMonolithWhite = new HexGenMonolith(HexBlocks.getHexBlock(BlockHexoriumMonolith.ID + BlockHexoriumMonolith.Colors.WHITE.name), Blocks.stone, HexConfig.cfgOtherMonolithWhiteHeightMin, HexConfig.cfgOtherMonolithWhiteHeightMax, HexConfig.cfgOtherMonolithWhiteChance);
            oreHexoriumOtherMonolithBlack = new HexGenMonolith(HexBlocks.getHexBlock(BlockHexoriumMonolith.ID + BlockHexoriumMonolith.Colors.BLACK.name), Blocks.stone, HexConfig.cfgOtherMonolithBlackHeightMin, HexConfig.cfgOtherMonolithBlackHeightMax, HexConfig.cfgOtherMonolithBlackChance);
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

            // Overworld
            case 0:
                if (HexConfig.cfgOreGeneralShouldGenerate && HexConfig.cfgOreOverworldShouldGenerate) {
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumOreRed,   HexConfig.cfgOverworldOreRedVeins,   HexConfig.cfgOverworldOreRedHeightMin,   HexConfig.cfgOverworldOreRedHeightMax);
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumOreGreen, HexConfig.cfgOverworldOreGreenVeins, HexConfig.cfgOverworldOreGreenHeightMin, HexConfig.cfgOverworldOreGreenHeightMax);
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumOreBlue,  HexConfig.cfgOverworldOreBlueVeins,  HexConfig.cfgOverworldOreBlueHeightMin,  HexConfig.cfgOverworldOreBlueHeightMax);
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumOreWhite, HexConfig.cfgOverworldOreWhiteVeins, HexConfig.cfgOverworldOreWhiteHeightMin, HexConfig.cfgOverworldOreWhiteHeightMax);
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumOreBlack, HexConfig.cfgOverworldOreBlackVeins, HexConfig.cfgOverworldOreBlackHeightMin, HexConfig.cfgOverworldOreBlackHeightMax);
                }
                if (HexConfig.cfgMonolithGeneralShouldGenerate && HexConfig.cfgMonolithOverworldShouldGenerate) {
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumMonolithRed,   HexConfig.cfgOverworldMonolithRedCount,   HexConfig.cfgOverworldMonolithRedHeightMin,   HexConfig.cfgOverworldMonolithRedHeightMax);
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumMonolithGreen, HexConfig.cfgOverworldMonolithGreenCount, HexConfig.cfgOverworldMonolithGreenHeightMin, HexConfig.cfgOverworldMonolithGreenHeightMax);
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumMonolithBlue,  HexConfig.cfgOverworldMonolithBlueCount,  HexConfig.cfgOverworldMonolithBlueHeightMin,  HexConfig.cfgOverworldMonolithBlueHeightMax);
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumMonolithWhite, HexConfig.cfgOverworldMonolithWhiteCount, HexConfig.cfgOverworldMonolithWhiteHeightMin, HexConfig.cfgOverworldMonolithWhiteHeightMax);
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumMonolithBlack, HexConfig.cfgOverworldMonolithBlackCount, HexConfig.cfgOverworldMonolithBlackHeightMin, HexConfig.cfgOverworldMonolithBlackHeightMax);
                }
                break;

            // Nether
            case -1:
                if (HexConfig.cfgOreGeneralShouldGenerate && HexConfig.cfgOreNetherShouldGenerate) {
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumNetherOreRed,   HexConfig.cfgNetherOreRedVeins,   HexConfig.cfgNetherOreRedHeightMin,   HexConfig.cfgNetherOreRedHeightMax);
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumNetherOreGreen, HexConfig.cfgNetherOreGreenVeins, HexConfig.cfgNetherOreGreenHeightMin, HexConfig.cfgNetherOreGreenHeightMax);
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumNetherOreBlue,  HexConfig.cfgNetherOreBlueVeins,  HexConfig.cfgNetherOreBlueHeightMin,  HexConfig.cfgNetherOreBlueHeightMax);
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumNetherOreWhite, HexConfig.cfgNetherOreWhiteVeins, HexConfig.cfgNetherOreWhiteHeightMin, HexConfig.cfgNetherOreWhiteHeightMax);
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumNetherOreBlack, HexConfig.cfgNetherOreBlackVeins, HexConfig.cfgNetherOreBlackHeightMin, HexConfig.cfgNetherOreBlackHeightMax);
                }
                if (HexConfig.cfgMonolithGeneralShouldGenerate && HexConfig.cfgMonolithNetherShouldGenerate) {
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumNetherMonolithRed,   HexConfig.cfgNetherMonolithRedCount,   HexConfig.cfgNetherMonolithRedHeightMin,   HexConfig.cfgNetherMonolithRedHeightMax);
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumNetherMonolithGreen, HexConfig.cfgNetherMonolithGreenCount, HexConfig.cfgNetherMonolithGreenHeightMin, HexConfig.cfgNetherMonolithGreenHeightMax);
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumNetherMonolithBlue,  HexConfig.cfgNetherMonolithBlueCount,  HexConfig.cfgNetherMonolithBlueHeightMin,  HexConfig.cfgNetherMonolithBlueHeightMax);
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumNetherMonolithWhite, HexConfig.cfgNetherMonolithWhiteCount, HexConfig.cfgNetherMonolithWhiteHeightMin, HexConfig.cfgNetherMonolithWhiteHeightMax);
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumNetherMonolithBlack, HexConfig.cfgNetherMonolithBlackCount, HexConfig.cfgNetherMonolithBlackHeightMin, HexConfig.cfgNetherMonolithBlackHeightMax);
                }
                break;

            // End
            case 1:
                break;
            
            // Other
            default:
                if (HexConfig.cfgOreGeneralShouldGenerate && HexConfig.cfgOreOtherShouldGenerate) {
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumOtherOreRed,   HexConfig.cfgOtherOreRedVeins,   HexConfig.cfgOtherOreRedHeightMin,   HexConfig.cfgOtherOreRedHeightMax);
                    runGenerator(world, random, chunkX, chunkZ,oreHexoriumOtherOreGreen,  HexConfig.cfgOtherOreGreenVeins, HexConfig.cfgOtherOreGreenHeightMin, HexConfig.cfgOtherOreGreenHeightMax);
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumOtherOreBlue,  HexConfig.cfgOtherOreBlueVeins,  HexConfig.cfgOtherOreBlueHeightMin,  HexConfig.cfgOtherOreBlueHeightMax);
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumOtherOreWhite, HexConfig.cfgOtherOreWhiteVeins, HexConfig.cfgOtherOreWhiteHeightMin, HexConfig.cfgOtherOreWhiteHeightMax);
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumOtherOreBlack, HexConfig.cfgOtherOreBlackVeins, HexConfig.cfgOtherOreBlackHeightMin, HexConfig.cfgOtherOreBlackHeightMax);
                }
                if (HexConfig.cfgMonolithGeneralShouldGenerate && HexConfig.cfgMonolithOtherShouldGenerate) {
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumOtherMonolithRed,   HexConfig.cfgOtherMonolithRedCount,   HexConfig.cfgOtherMonolithRedHeightMin,   HexConfig.cfgOtherMonolithRedHeightMax);
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumOtherMonolithGreen, HexConfig.cfgOtherMonolithGreenCount, HexConfig.cfgOtherMonolithGreenHeightMin, HexConfig.cfgOtherMonolithGreenHeightMax);
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumOtherMonolithBlue,  HexConfig.cfgOtherMonolithBlueCount,  HexConfig.cfgOtherMonolithBlueHeightMin,  HexConfig.cfgOtherMonolithBlueHeightMax);
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumOtherMonolithWhite, HexConfig.cfgOtherMonolithWhiteCount, HexConfig.cfgOtherMonolithWhiteHeightMin, HexConfig.cfgOtherMonolithWhiteHeightMax);
                    runGenerator(world, random, chunkX, chunkZ, oreHexoriumOtherMonolithBlack, HexConfig.cfgOtherMonolithBlackCount, HexConfig.cfgOtherMonolithBlackHeightMin, HexConfig.cfgOtherMonolithBlackHeightMax);
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
    private void runGenerator(World world, Random random, int chunkX, int chunkZ, WorldGenerator generator, int veinCount, int heightMin, int heightMax) {
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
