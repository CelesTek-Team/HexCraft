package com.celestek.hexcraft.util;

import com.celestek.hexcraft.block.*;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.tileentity.*;
import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.5.0
 * @since 2015-04-26
 */
public class NetworkAnalyzer {

    // Prepare ArrayLists for machines and cables.
    private ArrayList<HexDevice> cables;
    private ArrayList<HexDevice> machines;
    private ArrayList<HexDevice> pylons;
    private ArrayList<HexDevice> teleports;

    /**
     * Constructor.
     */
    public NetworkAnalyzer() {
        cables = new ArrayList<HexDevice>() {
            @Override
            public boolean contains(Object o) {
                HexDevice cable = (HexDevice) o;
                for (HexDevice entry : this) {
                    if ((entry.x == cable.x) && (entry.y == cable.y) && (entry.z == cable.z) && (entry.block == cable.block)) {
                        return true;
                    }
                }
                return false;
            }
        };

        machines = new ArrayList<HexDevice>() {
            @Override
            public boolean contains(Object o) {
                HexDevice machine = (HexDevice) o;
                for (HexDevice entry : this) {
                    if ((entry.x == machine.x) && (entry.y == machine.y) && (entry.z == machine.z) && (entry.block == machine.block)) {
                        return true;
                    }
                }
                return false;
            }
        };

        pylons = new ArrayList<HexDevice>() {
            @Override
            public boolean contains(Object o) {
                HexDevice pylon = (HexDevice) o;
                for (HexDevice entry : this) {
                    if ((entry.x == pylon.x) && (entry.y == pylon.y) && (entry.z == pylon.z) && (entry.block == pylon.block)) {
                        return true;
                    }
                }
                return false;
            }
        };

        teleports = new ArrayList<HexDevice>() {
            @Override
            public boolean contains(Object o) {
                HexDevice teleport = (HexDevice) o;
                for (HexDevice entry : this) {
                    if ((entry.x == teleport.x) && (entry.y == teleport.y) && (entry.z == teleport.z) && (entry.block == teleport.block)) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    /**
     * Called recursively to analyze the energy network.
     * @param world The world that the block to analyze is in.
     * @param x X coordinate of the block to analyze.
     * @param y Y coordinate of the block to analyze.
     * @param z Z coordinate of the block to analyze.
     * @param blockPrev The previous block.
     * @param direction The direction of the previous move.
     */
    private void analyze(World world, int x, int y, int z, Block blockPrev, int direction)
    {
        // Save the current block.
        Block block = world.getBlock(x, y, z);

        // Console spam for debugging analysis. Uncomment to enable.
        // System.out.println("Analyzing: (" + x + ", " + y + ", " + z + ") " + block.getUnlocalizedName());

        // Check if the current block is not a pylon base.
        if (!(block instanceof BlockPylonBase)) {
            // Check if the current block is a cable.
            if (block instanceof BlockHexoriumCable) {
                // Check if this cable has already been added to the cables ArrayList.
                if (!cables.contains(new HexDevice(x, y, z, block))) {
                    // Check if one of the conditions are met:
                    // 1) The previous cable's color was Rainbow.
                    // 2) The current block's color is Rainbow.
                    // 3) The current block's color is same as previous.
                    if (blockPrev == HexBlocks.blockHexoriumCableRainbow || block == HexBlocks.blockHexoriumCableRainbow || blockPrev == block || blockPrev instanceof BlockPylonBase)
                        // If any condition is met, add the cable to the cables ArrayList. Do this to avoid loops.
                        cables.add(new HexDevice(x, y, z, block));
                    else
                        // Otherwise, exit recursion.
                        return;
                } else
                    // If the cable is already in the cables ArrayList, exit recursion.
                    return;
            }
            // Check if the current block is a machine.
            else if (block == HexBlocks.blockHexoriumGenerator ||
                    block == HexBlocks.blockHexoriumFurnace ||
                    block == HexBlocks.blockCrystalSeparator ||
                    block == HexBlocks.blockMatrixReconstructor ||
                    block == HexBlocks.blockPersonalTeleportationPad) {
                if (block == HexBlocks.blockPersonalTeleportationPad && direction == 1) {
                    if (!teleports.contains(new HexDevice(x, y, z, block)))
                        teleports.add(new HexDevice(x, y, z, block));
                    return;
                }
                else {
                    // Check if this machine has already been added to the machines ArrayList.
                    if (!machines.contains(new HexDevice(x, y, z, block))) {
                        // If it hasn't, prepare the block's meta.
                        int meta = world.getBlockMetadata(x, y, z);

                        // Strip away the texture states from meta.
                        if (meta >= 4 && meta < 8)
                            meta = meta - 4;
                        else if (meta >= 8)
                            meta = meta - 8;

                        // Add the machine to the ArrayList if the previous direction responds with the orientation of the machine.
                        if ((meta == 0 && direction == 2) || (meta == 1 && direction == 5) || (meta == 2 && direction == 3) || (meta == 3 && direction == 4))
                            machines.add(new HexDevice(x, y, z, block));

                        // Exit recursion.
                        return;
                    } else
                        // If the machine is already in the machines ArrayList, exit recursion.
                        return;
                }
            } else
                // Exit recursion if the block is not a cable or a machine.
                return;

            // Move in all 6 different directions, but avoid going backwards. Call this same function recursively for every direction.
            if (direction != 1)
                analyze(world, x, y - 1, z, block, 0);
            if (direction != 0)
                analyze(world, x, y + 1, z, block, 1);
            if (direction != 3)
                analyze(world, x, y, z - 1, block, 2);
            if (direction != 2)
                analyze(world, x, y, z + 1, block, 3);
            if (direction != 5)
                analyze(world, x - 1, y, z, block, 4);
            if (direction != 4)
                analyze(world, x + 1, y, z, block, 5);
        }
        // If this is a pylon base...
        else {
            // Determine it.
            determineBase(world, x, y, z, block, direction);
        }
    }

    /**
     * Called recursively to analyze the Energy Pylon network.
     * @param world The world that the block to analyze is in.
     * @param x X coordinate of the block to analyze.
     * @param y Y coordinate of the block to analyze.
     * @param z Z coordinate of the block to analyze.
     * @param blockPrev The previous block.
     * @param direction The direction of the previous move.
     */
    private void pylonize(World world, int x, int y, int z, Block blockPrev, int direction) {
        // Save the current block.
        Block block = world.getBlock(x, y, z);

        // Console spam for debugging analysis. Uncomment to enable.
        // System.out.println("Pylonizing: (" + x + ", " + y + ", " + z + ") " + block.getUnlocalizedName());

        // Check if the current block is an Energy Pylon.
        if (block == HexBlocks.blockEnergyPylon) {
            // Get the block meta.
            int meta = world.getBlockMetadata(x, y, z);

            // Analyze pylons only if the pylon is ON.
            if (meta < 6) {
                // Check if the direction is correct or if this is the entry point.
                if ((meta == direction) || direction == -1) {
                    // Check if the pylon is not already added.
                    if (!pylons.contains(new HexDevice(x, y, z, block))) {
                        // Add the pylon.
                        pylons.add(new HexDevice(x, y, z, block));
                        TileEnergyPylon pylon = (TileEnergyPylon) world.getTileEntity(x, y, z);

                        // Perform the analysis on all other pylons linked to this one.
                        if (pylon != null) {
                            if (pylon.pylons != null)
                                for (HexPylon entry : pylon.pylons)
                                    if (world.getBlockMetadata(entry.x, entry.y, entry.z) < 6)
                                        if (!pylons.contains(new HexDevice(entry.x, entry.y, entry.z, world.getBlock(entry.x, entry.y, entry.z))))
                                            pylonize(world, entry.x, entry.y, entry.z, block, -1);
                        } else
                            return;
                    } else
                        return;
                } else
                    return;
            }
            // Strip away the meta.
            if (meta >= 6)
                meta = meta - 6;

            // Check if the previous block was not a Pylon Base.
            if (!(blockPrev instanceof BlockPylonBase)) {
                // Continue outwards depending on orientation.
                if (meta == 1 &&
                        ((world.getBlock(x, y - 1, z) == HexBlocks.blockPylonBase51 && world.getBlockMetadata(x, y - 1, z) == 1) ||
                        (world.getBlock(x, y - 1, z) == HexBlocks.blockPylonBase15 && world.getBlockMetadata(x, y - 1, z) != 1)))
                    analyze(world, x, y - 1, z, block, -1);
                else if (meta == 0 &&
                        ((world.getBlock(x, y + 1, z) == HexBlocks.blockPylonBase51 && world.getBlockMetadata(x, y + 1, z) == 0) ||
                        (world.getBlock(x, y + 1, z) == HexBlocks.blockPylonBase15 && world.getBlockMetadata(x, y + 1, z) != 0)))
                    analyze(world, x, y + 1, z, block, -1);
                else if (meta == 3 &&
                        ((world.getBlock(x, y, z - 1) == HexBlocks.blockPylonBase51 && world.getBlockMetadata(x, y, z - 1) == 3) ||
                        (world.getBlock(x, y, z - 1) == HexBlocks.blockPylonBase15 && world.getBlockMetadata(x, y, z - 1) != 3)))
                    analyze(world, x, y, z - 1, block, -1);
                else if (meta == 2 &&
                        ((world.getBlock(x, y, z + 1) == HexBlocks.blockPylonBase51 && world.getBlockMetadata(x, y, z + 1) == 2) ||
                        (world.getBlock(x, y, z + 1) == HexBlocks.blockPylonBase15 && world.getBlockMetadata(x, y, z + 1) != 2)))
                    analyze(world, x, y, z + 1, block, -1);
                else if (meta == 5 &&
                        ((world.getBlock(x - 1, y, z) == HexBlocks.blockPylonBase51 && world.getBlockMetadata(x - 1, y, z) == 5) ||
                        (world.getBlock(x - 1, y, z) == HexBlocks.blockPylonBase15 && world.getBlockMetadata(x - 1, y, z) != 5)))
                    analyze(world, x - 1, y, z, block, -1);
                else if (meta == 4 &&
                        ((world.getBlock(x + 1, y, z) == HexBlocks.blockPylonBase51 && world.getBlockMetadata(x + 1, y, z) == 4) ||
                        (world.getBlock(x + 1, y, z) == HexBlocks.blockPylonBase15 && world.getBlockMetadata(x + 1, y, z) != 4)))
                    analyze(world, x + 1, y, z, block, -1);
            }
        }
    }

    /**
     * Determines the base orientation and type.
     * @param world The world that the block to analyze is in.
     * @param x X coordinate of the block to analyze.
     * @param y Y coordinate of the block to analyze.
     * @param z Z coordinate of the block to analyze.
     * @param direction The direction of the previous move.
     */
    private void determineBase(World world, int x, int y, int z, Block block, int direction) {
        // Get the block meta.
        int meta = world.getBlockMetadata(x, y, z);
        // If this is a 5-to-1 base...
        if (block == HexBlocks.blockPylonBase51) {
            // Check if orientation is correct.
            if ((meta == 0 && direction != 1) ||
                    (meta == 1 && direction != 0) ||
                    (meta == 2 && direction != 3) ||
                    (meta == 3 && direction != 2) ||
                    (meta == 4 && direction != 5) ||
                    (meta == 5 && direction != 4) ||
                    direction == -1) {
                // Check if the base is not already added (use cable list).
                if (!cables.contains(new HexDevice(x, y, z, block))) {
                    // Add the base.
                    cables.add(new HexDevice(x, y, z, block));

                    // Continue analysis.
                    if (meta == 0) {
                        pylonize(world, x, y - 1, z, block, 0);
                        if (direction != 0)
                            analyze(world, x, y + 1, z, block, 1);
                        if (direction != 3)
                            analyze(world, x, y, z - 1, block, 2);
                        if (direction != 2)
                            analyze(world, x, y, z + 1, block, 3);
                        if (direction != 5)
                            analyze(world, x - 1, y, z, block, 4);
                        if (direction != 4)
                            analyze(world, x + 1, y, z, block, 5);
                    } else if (meta == 1) {
                        if (direction != 1)
                            analyze(world, x, y - 1, z, block, 0);
                        pylonize(world, x, y + 1, z, block, 1);
                        if (direction != 3)
                            analyze(world, x, y, z - 1, block, 2);
                        if (direction != 2)
                            analyze(world, x, y, z + 1, block, 3);
                        if (direction != 5)
                            analyze(world, x - 1, y, z, block, 4);
                        if (direction != 4)
                            analyze(world, x + 1, y, z, block, 5);
                    } else if (meta == 2) {
                        if (direction != 1)
                            analyze(world, x, y - 1, z, block, 0);
                        if (direction != 0)
                            analyze(world, x, y + 1, z, block, 1);
                        pylonize(world, x, y, z - 1, block, 2);
                        if (direction != 2)
                            analyze(world, x, y, z + 1, block, 3);
                        if (direction != 5)
                            analyze(world, x - 1, y, z, block, 4);
                        if (direction != 4)
                            analyze(world, x + 1, y, z, block, 5);
                    } else if (meta == 3) {
                        if (direction != 1)
                            analyze(world, x, y - 1, z, block, 0);
                        if (direction != 0)
                            analyze(world, x, y + 1, z, block, 1);
                        if (direction != 3)
                            analyze(world, x, y, z - 1, block, 2);
                        pylonize(world, x, y, z + 1, block, 3);
                        if (direction != 5)
                            analyze(world, x - 1, y, z, block, 4);
                        if (direction != 4)
                            analyze(world, x + 1, y, z, block, 5);
                    } else if (meta == 4) {
                        if (direction != 1)
                            analyze(world, x, y - 1, z, block, 0);
                        if (direction != 0)
                            analyze(world, x, y + 1, z, block, 1);
                        if (direction != 3)
                            analyze(world, x, y, z - 1, block, 2);
                        if (direction != 2)
                            analyze(world, x, y, z + 1, block, 3);
                        pylonize(world, x - 1, y, z, block, 4);
                        if (direction != 4)
                            analyze(world, x + 1, y, z, block, 5);
                    } else {
                        if (direction != 1)
                            analyze(world, x, y - 1, z, block, 0);
                        if (direction != 0)
                            analyze(world, x, y + 1, z, block, 1);
                        if (direction != 3)
                            analyze(world, x, y, z - 1, block, 2);
                        if (direction != 2)
                            analyze(world, x, y, z + 1, block, 3);
                        if (direction != 5)
                            analyze(world, x - 1, y, z, block, 4);
                        pylonize(world, x + 1, y, z, block, 5);
                    }
                }
            }
        }
        // If this is a 1-to-5 base...
        else if (block == HexBlocks.blockPylonBase15) {
            // Check if orientation is correct.
            if ((meta == 0 && direction == 1) ||
                    (meta == 1 && direction == 0) ||
                    (meta == 2 && direction == 3) ||
                    (meta == 3 && direction == 2) ||
                    (meta == 4 && direction == 5) ||
                    (meta == 5 && direction == 4) ||
                    direction == -1) {
                // Check if the base is not already added (use cable list).
                if (!cables.contains(new HexDevice(x, y, z, block))) {
                    // Add the base.
                    cables.add(new HexDevice(x, y, z, block));

                    // Continue analysis.
                    if (meta == 0) {
                        if (direction == -1)
                            analyze(world, x, y - 1, z, block, 0);
                        pylonize(world, x, y + 1, z, block, 1);
                        pylonize(world, x, y, z - 1, block, 2);
                        pylonize(world, x, y, z + 1, block, 3);
                        pylonize(world, x - 1, y, z, block, 4);
                        pylonize(world, x + 1, y, z, block, 5);
                    } else if (meta == 1) {
                        pylonize(world, x, y - 1, z, block, 0);
                        if (direction == -1)
                            analyze(world, x, y + 1, z, block, 1);
                        pylonize(world, x, y, z - 1, block, 2);
                        pylonize(world, x, y, z + 1, block, 3);
                        pylonize(world, x - 1, y, z, block, 4);
                        pylonize(world, x + 1, y, z, block, 5);
                    } else if (meta == 2) {
                        pylonize(world, x, y - 1, z, block, 0);
                        pylonize(world, x, y + 1, z, block, 1);
                        if (direction == -1)
                            analyze(world, x, y, z - 1, block, 2);
                        pylonize(world, x, y, z + 1, block, 3);
                        pylonize(world, x - 1, y, z, block, 4);
                        pylonize(world, x + 1, y, z, block, 5);
                    } else if (meta == 3) {
                        pylonize(world, x, y - 1, z, block, 0);
                        pylonize(world, x, y + 1, z, block, 1);
                        pylonize(world, x, y, z - 1, block, 2);
                        if (direction == -1)
                            analyze(world, x, y, z + 1, block, 3);
                        pylonize(world, x - 1, y, z, block, 4);
                        pylonize(world, x + 1, y, z, block, 5);
                    } else if (meta == 4) {
                        pylonize(world, x, y - 1, z, block, 0);
                        pylonize(world, x, y + 1, z, block, 1);
                        pylonize(world, x, y, z - 1, block, 2);
                        pylonize(world, x, y, z + 1, block, 3);
                        if (direction == -1)
                            analyze(world, x - 1, y, z, block, 4);
                        pylonize(world, x + 1, y, z, block, 5);
                    } else {
                        pylonize(world, x, y - 1, z, block, 0);
                        pylonize(world, x, y + 1, z, block, 1);
                        pylonize(world, x, y, z - 1, block, 2);
                        pylonize(world, x, y, z + 1, block, 3);
                        pylonize(world, x - 1, y, z, block, 4);
                        if (direction == -1)
                            analyze(world, x + 1, y, z, block, 5);
                    }
                }
            }
        }
    }

    /**
     * Begins the analysis from a machine.
     * @param world The world that the block to analyze is in.
     * @param x X coordinate of the machine.
     * @param y Y coordinate of the machine.
     * @param z Z coordinate of the machine.
     * @param orientation The orientation of the machine.
     */
    public void analyzeMachine(World world, int x, int y, int z, int orientation)
    {
        // Strip away the texture states from meta.
        if (orientation >= 4 && orientation < 8)
            orientation -= 4;
        else if (orientation >= 8)
            orientation -= 8;

        // Proceed to side depending on orientation.
        if (orientation == 0 &&
                (world.getBlock(x, y, z + 1) instanceof BlockHexoriumCable ||
                        (world.getBlock(x, y, z + 1) == HexBlocks.blockPylonBase51 && world.getBlockMetadata(x, y, z + 1) != 2) ||
                        (world.getBlock(x, y, z + 1) == HexBlocks.blockPylonBase15 && world.getBlockMetadata(x, y, z + 1) == 2)))
            analyze(world, x, y, z + 1, world.getBlock(x, y, z + 1), -1);
        else if (orientation == 1 &&
                (world.getBlock(x - 1, y, z) instanceof BlockHexoriumCable ||
                        (world.getBlock(x - 1, y, z) == HexBlocks.blockPylonBase51 && world.getBlockMetadata(x - 1, y, z) != 5) ||
                        (world.getBlock(x - 1, y, z) == HexBlocks.blockPylonBase15 && world.getBlockMetadata(x - 1, y, z) == 5)))
            analyze(world, x - 1, y, z, world.getBlock(x - 1, y, z), -1);
        else if (orientation == 2 &&
                (world.getBlock(x, y, z - 1) instanceof BlockHexoriumCable ||
                        (world.getBlock(x, y, z - 1) == HexBlocks.blockPylonBase51 && world.getBlockMetadata(x, y, z - 1) != 3) ||
                        (world.getBlock(x, y, z - 1) == HexBlocks.blockPylonBase15 && world.getBlockMetadata(x, y, z - 1) == 3)))
            analyze(world, x, y, z - 1, world.getBlock(x, y, z - 1), -1);
        else if (orientation == 3 &&
                (world.getBlock(x + 1, y, z) instanceof BlockHexoriumCable ||
                        (world.getBlock(x + 1, y, z) == HexBlocks.blockPylonBase51 && world.getBlockMetadata(x + 1, y, z) != 4) ||
                        (world.getBlock(x + 1, y, z) == HexBlocks.blockPylonBase15 && world.getBlockMetadata(x + 1, y, z) == 4)))
            analyze(world, x + 1, y, z, world.getBlock(x + 1, y, z), -1);

        // If the created list has no entries, add self in.
        if(!size())
            add(world, x, y, z);

        // Push the results to all found machines.
        pushMachines(world);
        pushTeleports(world);
    }

    /**
     * Begins the analysis from the bottom of a teleport.
     * @param world The world that the block to analyze is in.
     * @param x X coordinate of the machine.
     * @param y Y coordinate of the machine.
     * @param z Z coordinate of the machine.
     */
    public void analyzeTeleport(World world, int x, int y, int z)
    {
        // Proceed to side depending on orientation.
        if ((world.getBlock(x, y - 1, z) instanceof BlockHexoriumCable ||
            (world.getBlock(x, y - 1, z) == HexBlocks.blockPylonBase51 && world.getBlockMetadata(x, y - 1, z) != 0) ||
            (world.getBlock(x, y - 1, z) == HexBlocks.blockPylonBase15 && world.getBlockMetadata(x, y - 1, z) == 0)))
            analyze(world, x, y - 1, z, world.getBlock(x, y - 1, z), -1);

        // Push the results to all found machines.
        pushMachines(world);
        pushTeleports(world);
    }

    /**
     * Begins the analysis from a cable.
     * @param world The world that the block to analyze is in.
     * @param x X coordinate of the cable.
     * @param y Y coordinate of the cable.
     * @param z Z coordinate of the cable.
     */
    public void analyzeCable(World world, int x, int y, int z, Block block)
    {
        // Call the analysis and wait for results.
        analyze(world, x, y, z, block, -1);
        // Push the results to all found machines.
        pushMachines(world);
        pushTeleports(world);
    }

    /**
     * Begins the analysis from a pylon.
     * @param world The world that the block to analyze is in.
     * @param x X coordinate of the pylon.
     * @param y Y coordinate of the pylon.
     * @param z Z coordinate of the pylon
     */
    public void analyzePylon(World world, int x, int y, int z, Block block)
    {
        // Call the analysis and wait for results.
        pylonize(world, x, y, z, block, -1);
        // Push the results to all found machines.
        pushMachines(world);
        pushTeleports(world);
    }

    /**
     * Called by machine blocks to check if the scan resulted in any machines.
     * @return  If the machines list contains machines.
     */
    private boolean size() {
        return machines.size() > 0;
    }

    /**
     * Called by machine blocks to add themselves if the analyzing result contained no machines.
     * @param world The world that the machine is in.
     * @param x X coordinate of the machine.
     * @param y Y coordinate of the machine.
     * @param z Z coordinate of the machine.
     */
    private void add(World world, int x, int y, int z) {
        // Add the machine to machines ArrayList.
        machines.add(new HexDevice(x, y, z, world.getBlock(x, y, z)));
    }

    /**
     * Called by teleports to add themselves if the analyzing result contained no teleports.
     * @param world The world that the machine is in.
     * @param x X coordinate of the machine.
     * @param y Y coordinate of the machine.
     * @param z Z coordinate of the machine.
     */
    private void addTeleport(World world, int x, int y, int z) {
        // Add the machine to machines ArrayList.
        teleports.add(new HexDevice(x, y, z, world.getBlock(x, y, z)));
    }

    /**
     * Pushes the results of scanning to machines.
     * @param world The world that the network is in.
     */
    private void pushMachines(World world) {

        // Notify about pushing machines.
         System.out.println("Done! Pushing data to machines:");

        // Prepare ArrayLists for different machine types.
        ArrayList<HexDevice> machinesHexoriumGenerator = new ArrayList<HexDevice>();
        ArrayList<HexDevice> machinesHexoriumFurnace = new ArrayList<HexDevice>();
        ArrayList<HexDevice> machinesCrystalSeparator = new ArrayList<HexDevice>();
        ArrayList<HexDevice> machinesMatrixReconstructor = new ArrayList<HexDevice>();
        ArrayList<HexDevice> machinesPersonalTeleportationPad = new ArrayList<HexDevice>();

        // Go through all machines ArrayList entries.
        for (HexDevice entry : machines) {
            // Notify about every machine.
             System.out.println(" > (" + entry.x + ", " + entry.y + ", " + entry.z + ") " + entry.block.getUnlocalizedName());

            // Add machines to their respective ArrayLists.
            if (entry.block == HexBlocks.blockHexoriumGenerator) {
                machinesHexoriumGenerator.add(entry);
            }
            if (entry.block == HexBlocks.blockHexoriumFurnace) {
                machinesHexoriumFurnace.add(entry);
            }
            if (entry.block == HexBlocks.blockCrystalSeparator) {
                machinesCrystalSeparator.add(entry);
            }
            if (entry.block == HexBlocks.blockMatrixReconstructor) {
                machinesMatrixReconstructor.add(entry);
            }
            if (entry.block == HexBlocks.blockPersonalTeleportationPad) {
                machinesPersonalTeleportationPad.add(entry);
            }
        }

        // Push data to all machines. Consumers to generators, generators to consumers.
        for (HexDevice entry : machinesHexoriumGenerator) {
            TileHexoriumGenerator machine = (TileHexoriumGenerator) world.getTileEntity(entry.x, entry.y, entry.z);
            machine.injectMachines(machinesHexoriumFurnace, machinesCrystalSeparator, machinesMatrixReconstructor, machinesPersonalTeleportationPad);
        }
        for (HexDevice entry : machinesHexoriumFurnace) {
            TileHexoriumFurnace machine = (TileHexoriumFurnace) world.getTileEntity(entry.x, entry.y, entry.z);
            machine.injectMachines(machinesHexoriumGenerator);
        }
        for (HexDevice entry : machinesCrystalSeparator) {
            TileCrystalSeparator machine = (TileCrystalSeparator) world.getTileEntity(entry.x, entry.y, entry.z);
            machine.injectMachines(machinesHexoriumGenerator);
        }
        for (HexDevice entry : machinesMatrixReconstructor) {
            TileMatrixReconstructor machine = (TileMatrixReconstructor) world.getTileEntity(entry.x, entry.y, entry.z);
            machine.injectMachines(machinesHexoriumGenerator);
        }
        for (HexDevice entry : machinesPersonalTeleportationPad) {
            TilePersonalTeleportationPad machine = (TilePersonalTeleportationPad) world.getTileEntity(entry.x, entry.y, entry.z);
            machine.injectMachines(machinesHexoriumGenerator);
        }
    }

    /**
     * Pushes the results of scanning to teleports.
     * @param world The world that the network is in.
     */
    private void pushTeleports(World world) {

        // Notify about pushing machines.
         System.out.println("Done! Pushing data to teleports:");

        // Prepare ArrayLists for different machine types.
        ArrayList<HexDevice> teleportsPersonalTeleportationPad = new ArrayList<HexDevice>();

        // Go through all machines ArrayList entries.
        for (HexDevice entry : teleports) {
            // Notify about every machine.
             System.out.println(" > (" + entry.x + ", " + entry.y + ", " + entry.z + ") " + entry.block.getUnlocalizedName());

            // Add teleports to their ArrayList.
            if (entry.block == HexBlocks.blockPersonalTeleportationPad) {
                teleportsPersonalTeleportationPad.add(entry);
            }
        }

        // Push data to all teleports.
        for (HexDevice entry : teleportsPersonalTeleportationPad) {
            TilePersonalTeleportationPad teleport = (TilePersonalTeleportationPad) world.getTileEntity(entry.x, entry.y, entry.z);
            teleport.injectTeleports(teleportsPersonalTeleportationPad);
        }
    }
}
