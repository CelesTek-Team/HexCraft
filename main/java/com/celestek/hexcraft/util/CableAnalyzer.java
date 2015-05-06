package com.celestek.hexcraft.util;

import com.celestek.hexcraft.block.CableHexoriumCable;
import com.celestek.hexcraft.block.MachineHexoriumFurnace;
import com.celestek.hexcraft.block.MachineHexoriumGenerator;
import com.celestek.hexcraft.block.MachineMatrixReconstructor;
import com.celestek.hexcraft.tileentity.TileEntityHexoriumFurnace;
import com.celestek.hexcraft.tileentity.TileEntityHexoriumGenerator;
import com.celestek.hexcraft.tileentity.TileEntityMatrixReconstructor;
import net.minecraft.world.World;
import org.lwjgl.Sys;

import java.util.ArrayList;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-26
 */
public class CableAnalyzer {

    // Prepare ArrayLists for machines and cables.
    private ArrayList<HexCable> cables;
    private ArrayList<HexMachine> machines;

    /**
     * Constructor.
     */
    public CableAnalyzer() {
        cables = new ArrayList<HexCable>() {
            @Override
            public boolean contains(Object o) {
                HexCable cable = (HexCable) o;
                for (HexCable entry : this) {
                    if ((entry.x == cable.x) && (entry.y == cable.y) && (entry.z == cable.z) && (entry.name.equals(cable.name))) {
                        return true;
                    }
                }
                return false;
            }
        };

        machines = new ArrayList<HexMachine>() {
            @Override
            public boolean contains(Object o) {
                HexMachine machine = (HexMachine) o;
                for (HexMachine entry : this) {
                    if ((entry.x == machine.x) && (entry.y == machine.y) && (entry.z == machine.z) && (entry.name.equals(machine.name))) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    /**
     * Called from different blocks and recursively to analyze the energy network.
     * @param world The world that the block to analyze is in.
     * @param x X coordinate of the block to analyze.
     * @param y Y coordinate of the block to analyze.
     * @param z Z coordinate of the block to analyze.
     * @param name Unlocalized name of the previous block.
     * @param direction The direction of the previous move.
     */
    public void analyze(World world, int x, int y, int z, String name, int direction)
    {
        // Save the temporary name of the current block.
        String blockName = world.getBlock(x, y, z).getUnlocalizedName();

        // Console spam for debugging analysis. Uncomment to enable.
        // System.out.println("Analyzing: (" + x + ", " + y + ", " + z + ") " + blockName);

        // Check if the current block is a cable.
        if (blockName.contains(CableHexoriumCable.UNLOCALISEDNAME)) {
            // Check if this cable has already been added to the cables ArrayList.
            if (!cables.contains(new HexCable(x, y, z, blockName))) {
                // Check if one of the conditions are met:
                // 1) The previous cable's color was Rainbow.
                // 2) The current block's color is Rainbow.
                // 3) The current block's color is same as previous.
                if (name.contains("Rainbow") || blockName.contains("Rainbow") || name.equals(blockName))
                    // If any condition is met, add the cable to the cables ArrayList. Do this to avoid loops.
                    cables.add(new HexCable(x, y, z, name));
                else
                    // Otherwise, exit recursion.
                    return;
            }
            else
                // If the cable is already in the cables ArrayList, exit recursion.
                return;
        }
        // Check if the current block is a machine.
        else if(blockName.contains(MachineHexoriumGenerator.UNLOCALISEDNAME) ||
                blockName.contains(MachineHexoriumFurnace.UNLOCALISEDNAME) ||
                blockName.contains(MachineMatrixReconstructor.UNLOCALISEDNAME)) {
            // Check if this machine has already been added to the machines ArrayList.
            if (!machines.contains(new HexMachine(x, y, z, blockName))) {
                // If it hasn't, prepare the block's meta.
                int meta = world.getBlockMetadata(x, y, z);

                // Strip away the texture states from meta.
                if (meta >= 4 && meta < 8)
                    meta = meta - 4;
                else if (meta >= 8)
                    meta = meta - 8;

                // Add the machine to the ArrayList if the previous direction responds with the orientation of the machine.
                if ((meta == 0 && direction == 3) || (meta == 1 && direction == 2) || (meta == 2 && direction == 4) || (meta == 3 && direction == 1))
                    machines.add(new HexMachine(x, y, z, blockName));

                // Exit recursion.
                return;
            } else
                // If the machine is already in the machines ArrayList, exit recursion.
                return;
        }
        else
            // Exit recursion if the block is not a cable or a machine.
            return;

        // Move in all 6 different directions, but avoid going backwards. Call this same function recursively for every direction.
        if(direction != 2)
            analyze(world, x - 1, y, z, blockName, 1);
        if(direction != 1)
            analyze(world, x + 1, y, z, blockName, 2);
        if(direction != 4)
            analyze(world, x, y, z - 1, blockName, 3);
        if(direction != 3)
            analyze(world, x, y, z + 1, blockName, 4);
        if(direction != 6)
            analyze(world, x, y - 1, z, blockName, 5);
        if(direction != 5)
            analyze(world, x, y + 1, z, blockName, 6);
    }

    /**
     * Called by machine blocks to check if the scan resulted in any machines.
     * @return  If the machines list contains machines.
     */
    public boolean size() {
        return machines.size() > 0;
    }

    /**
     * Called by machine blocks to add themselves if the analyzing result contained no machines.
     * @param world The world that the machine is in.
     * @param x X coordinate of the machine.
     * @param y Y coordinate of the machine.
     * @param z Z coordinate of the machine.
     */
    public void add(World world, int x, int y, int z) {
        // Add the machine to machines ArrayList.
        machines.add(new HexMachine(x, y, z, world.getBlock(x, y, z).getUnlocalizedName()));
    }

    /**
     * Called by different blocks to push the results of scanning to machines.
     * @param world The world that the network is in.
     */
    public void push(World world) {

        // Notify about pushing machines.
        System.out.println("Done! Pushing data to machines:");

        // Prepare ArrayLists for different machine types.
        ArrayList<TileEntityHexoriumGenerator> machinesHexoriumGenerator = new ArrayList<TileEntityHexoriumGenerator>();
        ArrayList<TileEntityHexoriumFurnace> machinesHexoriumFurnace = new ArrayList<TileEntityHexoriumFurnace>();
        ArrayList<TileEntityMatrixReconstructor> machinesMatrixReconstructor = new ArrayList<TileEntityMatrixReconstructor>();

        // Go through all machines ArrayList entries.
        for (HexMachine entry : machines) {
            // Notify about every machine.
            System.out.println(" > (" + entry.x + ", " + entry.y + ", " + entry.z + ") " + entry.name);

            // Add machines to their respective ArrayLists.
            if (entry.name.contains(MachineHexoriumGenerator.UNLOCALISEDNAME)) {
                machinesHexoriumGenerator.add((TileEntityHexoriumGenerator) world.getTileEntity(entry.x, entry.y, entry.z));
            }
            if (entry.name.contains(MachineHexoriumFurnace.UNLOCALISEDNAME)) {
                machinesHexoriumFurnace.add((TileEntityHexoriumFurnace) world.getTileEntity(entry.x, entry.y, entry.z));
            }
            if (entry.name.contains(MachineMatrixReconstructor.UNLOCALISEDNAME)) {
                machinesMatrixReconstructor.add((TileEntityMatrixReconstructor) world.getTileEntity(entry.x, entry.y, entry.z));
            }
        }

        // Push data to all machines. Consumers to generators, generators to consumers.
        for (TileEntityHexoriumGenerator entry : machinesHexoriumGenerator) {
            TileEntityHexoriumGenerator machine = (TileEntityHexoriumGenerator) world.getTileEntity(entry.xCoord, entry.yCoord, entry.zCoord);
            machine.injectMachines(machinesMatrixReconstructor, machinesHexoriumFurnace);
        }
        for (TileEntityHexoriumFurnace entry : machinesHexoriumFurnace) {
            TileEntityHexoriumFurnace machine = (TileEntityHexoriumFurnace) world.getTileEntity(entry.xCoord, entry.yCoord, entry.zCoord);
            machine.injectMachines(machinesHexoriumGenerator);
        }
        for (TileEntityMatrixReconstructor entry : machinesMatrixReconstructor) {
            TileEntityMatrixReconstructor machine = (TileEntityMatrixReconstructor) world.getTileEntity(entry.xCoord, entry.yCoord, entry.zCoord);
            machine.injectMachines(machinesHexoriumGenerator);
        }
    }
}
