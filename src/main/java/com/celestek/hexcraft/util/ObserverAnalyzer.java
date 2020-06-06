package com.celestek.hexcraft.util;

import com.celestek.hexcraft.block.BlockQuantumAnchor;
import com.celestek.hexcraft.block.BlockQuantumObserver;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.tileentity.TileQuantumObserver;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.ArrayList;

import static net.minecraftforge.common.util.ForgeDirection.*;

public class ObserverAnalyzer {

    // Maximum chunk size
    public static final int MAX_CHUNK_SIZE = 6;

    // Prepare ArrayLists for blocks and valves.
    private TileQuantumObserver tileQuantumObserver;
    private int chunkSize;

    /**
     * Constructor.
     */
    public ObserverAnalyzer() {
        this.tileQuantumObserver = null;
        this.chunkSize = 0;
    }

    /**
     * Called recursively to analyze a Quantum Observer structure.
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
        if (HexConfig.cfgObserverVerboseDebug && HexConfig.cfgObserverDebug)
            System.out.println("[Observer Analyzer] Analyzing: (" + x + ", " + y + ", " + z + ") " + block.getUnlocalizedName());

        // Check if the current block is the observer.
        if (block instanceof BlockQuantumObserver) {
            TileEntity tileEntity = world.getTileEntity(x, y, z);
            if (tileEntity != null)
                if (tileEntity instanceof TileQuantumObserver)
                    tileQuantumObserver = (TileQuantumObserver) tileEntity;
        }
        // Check if the current block is an anchor.
        else if (block instanceof BlockQuantumAnchor) {
            // Verify that it is surrounded by solid faces.
            if (world.isSideSolid(x, y, z + 1, NORTH) &&
                    world.isSideSolid(x, y, z - 1, SOUTH) &&
                    world.isSideSolid(x + 1, y, z, WEST) &&
                    world.isSideSolid(x - 1, y, z, EAST))
                chunkSize++;

            // Move up and down, but avoid going backwards. Call this same function recursively for every direction.
            if (direction != 1)
                analyze(world, x, y - 1, z, 0);
            if (direction != 0)
                analyze(world, x, y + 1, z, 1);
        }
    }

    /**
     * Begins the analysis from a block.
     *
     * @param world The world that the block to analyze is in.
     * @param x     X coordinate of the cable.
     * @param y     Y coordinate of the cable.
     * @param z     Z coordinate of the cable.
     */
    public void analyzeObserver(World world, int x, int y, int z) {
        // Call the analysis and wait for results.
        analyze(world, x, y, z, -1);
        // Push the results to the observer
        if (tileQuantumObserver != null) {
            if (HexConfig.cfgObserverVerboseDebug && HexConfig.cfgObserverDebug)
                System.out.println("[Observer Analyzer] Analysis done! Quantum Observer found along with " + chunkSize + " usable Quantum Anchors.");
            if (chunkSize > MAX_CHUNK_SIZE)
                chunkSize = MAX_CHUNK_SIZE;
            tileQuantumObserver.setChunkSize(chunkSize);
        }
        else {
            if (HexConfig.cfgObserverVerboseDebug && HexConfig.cfgObserverDebug)
                System.out.println("[Observer Analyzer] Analysis done! Quantum Observer NOT found. Cancelling.");
        }
    }
}