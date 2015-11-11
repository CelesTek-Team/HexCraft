package com.celestek.hexcraft.util;

import com.celestek.hexcraft.block.*;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.tileentity.*;
import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.7.0
 */

public class NetworkAnalyzer {

    // Prepare ArrayLists for machines and cables.
    private ArrayList<HexDevice> cables;
    private ArrayList<HexDevice> pylons;

    private ArrayList<HexDevice> energySources;
    private ArrayList<HexDevice> energyDrains;

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

        energySources = new ArrayList<HexDevice>() {
            @Override
            public boolean contains(Object o) {
                HexDevice energySource = (HexDevice) o;
                for (HexDevice entry : this) {
                    if ((entry.x == energySource.x) && (entry.y == energySource.y) && (entry.z == energySource.z) && (entry.block == energySource.block)) {
                        return true;
                    }
                }
                return false;
            }
        };

        energyDrains = new ArrayList<HexDevice>() {
            @Override
            public boolean contains(Object o) {
                HexDevice energyDrain = (HexDevice) o;
                for (HexDevice entry : this) {
                    if ((entry.x == energyDrain.x) && (entry.y == energyDrain.y) && (entry.z == energyDrain.z) && (entry.block == energyDrain.block)) {
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

        // Console spam for debugging analysis.
        if (HexConfig.cfgGeneralVerboseNetworkDebug && HexConfig.cfgGeneralNetworkDebug)
            System.out.println("Analyzing Network: (" + x + ", " + y + ", " + z + ") " + block.getUnlocalizedName());

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
            // Check if the current block is an energy source.
            else if (block instanceof IBlockHexEnergySource) {
                {
                    // Check if this energy source has already been added to the energySources ArrayList.
                    if (!energySources.contains(new HexDevice(x, y, z, block))) {
                        // If it hasn't, get the block's rotation.
                        int rotation = HexUtils.getMetaBitInt(HexBlocks.META_MACHINE_ROT_0, HexBlocks.META_MACHINE_ROT_1, world, x, y, z);
                        // Add the energy source to the ArrayList if the previous direction responds with the rotation of the energy source.
                        if ((rotation == 0 && direction == 2) || (rotation == 1 && direction == 5) || (rotation == 2 && direction == 3) || (rotation == 3 && direction == 4))
                            energySources.add(new HexDevice(x, y, z, block));
                        // Exit recursion.
                        return;
                    } else
                        // If the energy source is already in the energySources ArrayList, exit recursion.
                        return;
                }
            }
            // Check if the current block is an energy drain.
            else if (block instanceof IBlockHexEnergyDrain) {
                if (block == HexBlocks.blockPersonalTeleportationPad && direction == 1) {
                    if (!teleports.contains(new HexDevice(x, y, z, block)))
                        teleports.add(new HexDevice(x, y, z, block));
                    return;
                }
                else {
                    // Check if this energy drain has already been added to the energyDrains ArrayList.
                    if (!energyDrains.contains(new HexDevice(x, y, z, block))) {
                        // If it hasn't, get the block's rotation.
                        int rotation = HexUtils.getMetaBitInt(HexBlocks.META_MACHINE_ROT_0, HexBlocks.META_MACHINE_ROT_1, world, x, y, z);
                        // Add the energy drain to the ArrayList if the previous direction responds with the rotation of the energy drain.
                        if ((rotation == 0 && direction == 2) || (rotation == 1 && direction == 5) || (rotation == 2 && direction == 3) || (rotation == 3 && direction == 4))
                            energyDrains.add(new HexDevice(x, y, z, block));
                        // Exit recursion.
                        return;
                    } else
                        // If the energy drain is already in the energyDrains ArrayList, exit recursion.
                        return;
                }
            }
            else
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

        // Console spam for debugging analysis.
        if (HexConfig.cfgGeneralVerboseNetworkDebug && HexConfig.cfgGeneralNetworkDebug)
            System.out.println("Pylonizing: (" + x + ", " + y + ", " + z + ") " + block.getUnlocalizedName());

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
    public void analyzeMachines(World world, int x, int y, int z, int orientation)
    {
        // Strip away the texture states from meta.
        orientation = HexUtils.getBitInt(orientation, HexBlocks.META_MACHINE_ROT_0, HexBlocks.META_MACHINE_ROT_1);

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

        if (energyDrains.size() == 0 || energySources.size() == 0)
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
     * Pushes the results of scanning to sources and drains.
     * @param world The world that the network is in.
     */
    private void pushMachines(World world) {

        // Notify about pushing to sources.
        if (HexConfig.cfgGeneralNetworkDebug)
            System.out.println("Done! Pushing data to sources:");

        // Go through all energySources ArrayList entries.
        for (HexDevice entry : energySources) {
            // Notify about every source.
            if (HexConfig.cfgGeneralNetworkDebug)
                System.out.println(" > (" + entry.x + ", " + entry.y + ", " + entry.z + ") " + entry.block.getUnlocalizedName());

            ITileHexEnergySource energySource = (ITileHexEnergySource) world.getTileEntity(entry.x, entry.y, entry.z);
            energySource.setDrains(energyDrains);
        }

        // Notify about pushing to drains.
        if (HexConfig.cfgGeneralNetworkDebug)
            System.out.println("Pushing data to drains:");

        // Go through all energyDrains ArrayList entries.
        for (HexDevice entry : energyDrains) {
            // Notify about every drain.
            if (HexConfig.cfgGeneralNetworkDebug)
                System.out.println(" > (" + entry.x + ", " + entry.y + ", " + entry.z + ") " + entry.block.getUnlocalizedName());

            ITileHexEnergyDrain energyDrain = (ITileHexEnergyDrain) world.getTileEntity(entry.x, entry.y, entry.z);
            energyDrain.setSources(energySources);
        }
    }

    /**
     * Pushes the results of scanning to teleports.
     * @param world The world that the network is in.
     */
    private void pushTeleports(World world) {

        // Notify about pushing teleports.
        if (HexConfig.cfgGeneralNetworkDebug)
            System.out.println("Pushing data to teleports:");

        // Go through all teleports ArrayList entries.
        for (HexDevice entry : teleports) {
            // Notify about every teleport.
            if (HexConfig.cfgGeneralNetworkDebug)
                System.out.println(" > (" + entry.x + ", " + entry.y + ", " + entry.z + ") " + entry.block.getUnlocalizedName());

            TilePersonalTeleportationPad teleport = (TilePersonalTeleportationPad) world.getTileEntity(entry.x, entry.y, entry.z);
            if (teleport != null)
                teleport.injectTeleports(teleports);
        }
    }

    /**
     * Called by machine blocks to add themselves if the analyzing result contained no machines.
     * @param world The world that the machine is in.
     * @param x X coordinate of the machine.
     * @param y Y coordinate of the machine.
     * @param z Z coordinate of the machine.
     */
    private void add(World world, int x, int y, int z) {
        Block block = world.getBlock(x, y, z);
        if (block instanceof IBlockHexEnergySource)
            energySources.add(new HexDevice(x, y, z, block));
        else if (block instanceof IBlockHexEnergyDrain)
            energyDrains.add(new HexDevice(x, y, z, block));
    }
}
