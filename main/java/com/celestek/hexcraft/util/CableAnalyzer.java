package com.celestek.hexcraft.util;

import com.celestek.hexcraft.block.CableHexoriumCable;
import com.celestek.hexcraft.block.MachineHexoriumGenerator;
import com.celestek.hexcraft.block.MachineMatrixReconstructor;
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
    private ArrayList<HexCable> cables;
    private ArrayList<HexMachine> machines;

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

    public void analyze(World world, int x, int y, int z, String name, int direction)
    {
        // Start
        String blockName = world.getBlock(x, y, z).getUnlocalizedName();

        //System.out.println("Analyzing: (" + x + ", " + y + ", " + z + ") " + blockName);

        if (blockName.contains(CableHexoriumCable.UNLOCALISEDNAME)) {
            if (!cables.contains(new HexCable(x, y, z, blockName))) {
                //System.out.println("Adding Cable.");
                if (name.contains("Rainbow") || blockName.contains("Rainbow") || name.equals(blockName))
                    cables.add(new HexCable(x, y, z, name));
                else
                    //System.out.println("Skipping. Cable incompatible.");
                    return;
            }
            else {
                //System.out.println("Skipping. Cable already in list.");
                return;
            }
        }
        else if(blockName.contains(MachineMatrixReconstructor.UNLOCALISEDNAME) ||
                blockName.contains(MachineHexoriumGenerator.UNLOCALISEDNAME)) {
            if (!machines.contains(new HexMachine(x, y, z, blockName))) {
                int meta = world.getBlockMetadata(x, y, z);

                if (meta >= 4 && meta < 8)
                    meta = meta - 4;
                else if (meta >= 8)
                    meta = meta - 8;

                if ((meta == 0 && direction == 3) || (meta == 1 && direction == 2) || (meta == 2 && direction == 4) || (meta == 3 && direction == 1)) {
                    machines.add(new HexMachine(x, y, z, blockName));
                    //System.out.println("Adding Machine.");
                }
                else {
                    //System.out.println("Skipping. Machine on wrong side.");
                    return;
                }

                return;
            } else {
                //System.out.println("Skipping. Machine already in list.");
                return;
            }
        }
        else
            return;

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

    public boolean size() {
        return machines.size() > 0;
    }

    public void add(World world, int x, int y, int z) {
        machines.add(new HexMachine(x, y, z, world.getBlock(x, y, z).getUnlocalizedName()));
    }

    public void push(World world) {
        System.out.println("Done! Pushing data to machines:");

        ArrayList<TileEntityHexoriumGenerator> machinesHexoriumGenerator = new ArrayList<TileEntityHexoriumGenerator>();
        ArrayList<TileEntityMatrixReconstructor> machinesMatrixReconstructor = new ArrayList<TileEntityMatrixReconstructor>();

        for (HexMachine entry : machines) {
            System.out.println(" > (" + entry.x + ", " + entry.y + ", " + entry.z + ") " + entry.name);

            if (entry.name.contains(MachineHexoriumGenerator.UNLOCALISEDNAME)) {
                machinesHexoriumGenerator.add((TileEntityHexoriumGenerator) world.getTileEntity(entry.x, entry.y, entry.z));
            }
            if (entry.name.contains(MachineMatrixReconstructor.UNLOCALISEDNAME)) {
                machinesMatrixReconstructor.add((TileEntityMatrixReconstructor) world.getTileEntity(entry.x, entry.y, entry.z));
            }
        }

        for (TileEntityHexoriumGenerator entry : machinesHexoriumGenerator) {
            TileEntityHexoriumGenerator machine = (TileEntityHexoriumGenerator) world.getTileEntity(entry.xCoord, entry.yCoord, entry.zCoord);
            machine.injectMachines(machinesMatrixReconstructor);
        }
        for (TileEntityMatrixReconstructor entry : machinesMatrixReconstructor) {
            TileEntityMatrixReconstructor machine = (TileEntityMatrixReconstructor) world.getTileEntity(entry.xCoord, entry.yCoord, entry.zCoord);
            machine.injectMachines(machinesHexoriumGenerator);
        }
    }
}
