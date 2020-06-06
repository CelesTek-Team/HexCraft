package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.block.*;
import com.celestek.hexcraft.init.HexAchievements;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.util.HexUtils;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.*;

public class TileTankValve extends TileFluidHandler {

    /**** Static Values ****/

    public static final String ID = "tileTankValve";

    public static final String MACHINE_NAME = "hexcraft.container.hexoriumTank";

    // NBT Names
    private static final String NBT_TANK_CAPACITY = "tank_capacity";
    private static final String NBT_FLUID_LEVEL = "fluid_level";
    private static final String NBT_FLUID_NAME = "fluid_name";

    private static final String NBT_IS_SETUP = "is_setup";
    private static final String NBT_IS_MASTER = "is_master";

    private static final String NBT_MASTER_X = "master_x";
    private static final String NBT_MASTER_Y = "master_y";
    private static final String NBT_MASTER_Z = "master_z";

    private static final String NBT_RENDER_X = "render_x";
    private static final String NBT_RENDER_Y = "render_y";
    private static final String NBT_RENDER_Z = "render_z";

    /**** Variables ****/

    // Prepare dimension and tank.
    private Dimension structureDimension;
    private FluidTank fluidTank;

    // Prepare fluid variables.
    private int tankCapacity;
    private int fluidLevel;
    private String fluidName;

    // Prepare GUI fluid variables.
    private int guiTankCapacity;
    private int guiFluidLevel;
    private int guiFluidID;
    private int guiFluidIns;

    // Prepare state variables.
    private boolean isSetup;
    private boolean isMaster;

    // Prepare master coordinates.
    private int masterX;
    private int masterY;
    private int masterZ;

    // Prepare render coordinates.
    private int renderX;
    private int renderY;
    private int renderZ;


    /**** Common TileEntity Methods ****/

    public TileTankValve() {
        this.structureDimension = new Dimension();
        this.fluidTank = new FluidTank(tankCapacity);

        this.tankCapacity = 0;
        this.fluidLevel = 0;
        this.fluidName = "";

        this.guiTankCapacity = 0;
        this.guiFluidLevel = 0;
        this.guiFluidID = 0;
        this.guiFluidIns = 0;

        this.isMaster = false;
        this.isSetup = false;

        this.masterX = xCoord;
        this.masterY = yCoord;
        this.masterZ = zCoord;

        this.renderX = 0;
        this.renderY = 0;
        this.renderZ = 0;
    }

    /**
     * Writes to NBT.
     */
    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        // Write the dimension.
        structureDimension.saveToNBT(nbtTagCompound);

        // Write the fluid variables.
        nbtTagCompound.setInteger(NBT_TANK_CAPACITY, tankCapacity);
        nbtTagCompound.setInteger(NBT_FLUID_LEVEL, fluidLevel);
        nbtTagCompound.setString(NBT_FLUID_NAME, fluidName);

        // Write the state variables.
        nbtTagCompound.setBoolean(NBT_IS_MASTER, isMaster);
        nbtTagCompound.setBoolean(NBT_IS_SETUP, isSetup);

        // Write the master coordinates.
        nbtTagCompound.setInteger(NBT_MASTER_X, masterX);
        nbtTagCompound.setInteger(NBT_MASTER_Y, masterY);
        nbtTagCompound.setInteger(NBT_MASTER_Z, masterZ);

        // Write the render coordinates.
        nbtTagCompound.setInteger(NBT_RENDER_X, renderX);
        nbtTagCompound.setInteger(NBT_RENDER_Y, renderY);
        nbtTagCompound.setInteger(NBT_RENDER_Z, renderZ);
    }

    /**
     * Reads from NBT.
     */
    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

        // Read the dimension.
        structureDimension.loadFromNBT(nbtTagCompound);

        // Read the fluid variables.
        tankCapacity = nbtTagCompound.getInteger(NBT_TANK_CAPACITY);
        fluidLevel = nbtTagCompound.getInteger(NBT_FLUID_LEVEL);
        fluidName = nbtTagCompound.getString(NBT_FLUID_NAME);

        // Generate the tank out of fluid variables.
        fluidTank = new FluidTank(tankCapacity);
        Fluid fluid = FluidRegistry.getFluid(fluidName);
        if (fluid != null)
            fluidTank.setFluid(new FluidStack(fluid, fluidLevel));

        // Read the state variables.
        isMaster = nbtTagCompound.getBoolean(NBT_IS_MASTER);
        isSetup = nbtTagCompound.getBoolean(NBT_IS_SETUP);

        // Read the master coordinates.
        masterX = nbtTagCompound.getInteger(NBT_MASTER_X);
        masterY = nbtTagCompound.getInteger(NBT_MASTER_Y);
        masterZ = nbtTagCompound.getInteger(NBT_MASTER_Z);

        // Read the render coordinates.
        renderX = nbtTagCompound.getInteger(NBT_RENDER_X);
        renderY = nbtTagCompound.getInteger(NBT_RENDER_Y);
        renderZ = nbtTagCompound.getInteger(NBT_RENDER_Z);
    }

    /**** Custom Methods ****/

    /**
     * Checks if block at given coordinates is a valid MultiTank building block.
     *
     * @param x         X coordinate
     * @param y         Y coordinate
     * @param z         Z coordinate
     * @param checkMeta switch whether or not to check the block's meta as well.
     *                  Used when re-checking a structure
     * @return is block at given coordinates valid
     */
    private boolean isValidBlock(int x, int y, int z, Dimension dimension, boolean checkMeta, boolean allowValve) {
        Block block = worldObj.getBlock(x, y, z);

        boolean blockType = block instanceof HexBlockMT
                || (block instanceof BlockTankValve && allowValve)
                || block instanceof BlockTemperedHexoriumGlass
                || block instanceof BlockHexoriumCoatedStone;
        boolean rotation = true;

        if (block instanceof BlockTankValve) {
            rotation = checkValveRotation(x, y, z, dimension);
            if (HexConfig.cfgTankDebug && HexConfig.cfgTankVerboseDebug)
                System.out.println("[Tank Valve] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Checking valve rotation: " + rotation);
        }

        if (checkMeta)
            return blockType && !HexUtils.getMetaBit(HexBlocks.META_STRUCTURE_IS_PART, worldObj, x, y, z) && rotation;
        else
            return blockType && rotation;
    }

    /**
     * Checks if given coordinates are clear
     *
     * @param x X coordinate
     * @param y Y coordinate
     * @param z Z coordinate
     * @return are the coordinates clear
     */
    private boolean isClear(int x, int y, int z) {
        boolean isClear = worldObj.isAirBlock(x, y, z) || worldObj.getBlock(x, y, z) instanceof BlockTankRender;

        if (HexConfig.cfgTankDebug && HexConfig.cfgTankVerboseDebug)
            System.out.println(String.format("[Tank Valve] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Is block at %s, %s, %s clear: %s", x, y, z, isClear));

        return isClear;
    }

    /**
     * Marks the block as part of a MultiTank and sets relevant data
     *
     * @param x      X coordinate
     * @param y      Y coordinate
     * @param z      Z coordinate
     * @param isPart is or isn't part
     */
    private void setIsPart(int x, int y, int z, Dimension dimension, boolean isPart) {

        HexUtils.setMetaBit(HexBlocks.META_STRUCTURE_IS_PART, isPart, HexUtils.META_NOTIFY_UPDATE, worldObj, x, y, z);

        if (worldObj.getBlock(x, y, z) instanceof BlockTankValve) {
            TileTankValve tileTankValve = (TileTankValve) worldObj.getTileEntity(x, y, z);
            if (tileTankValve != null) {
                if (isPart) {
                    if (!(x == xCoord && y == yCoord && z == zCoord)) {
                        FluidStack fluid = tileTankValve.getMasterTank().getFluid();
                        if (fluid != null) {
                            fluid.amount = (int) (fluid.amount * ((float) HexConfig.cfgTankKeepFluid / 100));
                            fluidTank.fill(fluid, true);
                        }
                        tileTankValve.emptyTank();

                        tileTankValve.setMasterX(xCoord);
                        tileTankValve.setMasterY(yCoord);
                        tileTankValve.setMasterZ(zCoord);

                        tileTankValve.setMaster(false);
                        tileTankValve.setSetup(true);

                        int deltaY = y - yCoord;

                        int slaveToBot = dimension.getToBottom() + deltaY;
                        int slaveToTop = dimension.getToTop() - deltaY;

                        tileTankValve.setValveElevData(slaveToBot, slaveToTop);
                    }
                }
                else {
                    tileTankValve.setMaster(false);
                    tileTankValve.setSetup(false);
                }
            }
        }
    }

    /**
     * Empties the tank and sets the capacity to 0.
     */
    public void emptyTank() {
        tankCapacity = 0;
        fluidTank = new FluidTank(tankCapacity);
        markDirty();
    }

    /**
     * Determines the dimensions and orientation of the MultiTank structure
     *
     * @param side Side that the manipulator was used on
     * @return The dimensions and orientation
     */
    private Dimension scanDimensions(int side) {
        // Sides:
        // 0 - Bottom (-Y)
        // 1 - Top (+Y)
        // 2 - North (-Z)
        // 3 - South (+Z)
        // 4 - West (-X)
        // 5 - East (+X)

        int maxSize = HexConfig.cfgTankMaxDimension;

        int depth = 0;
        int widthPositive = 0;
        int widthNegative = 0;
        int toTop = 0;
        int toBottom = 0;
        int orientation = 0;

        switch (side) {
            case 2:
                orientation = Dimension.ORIENT_Z_P;

                for (int i = 1; i <= maxSize - 2; i++)
                    if (isClear(xCoord - i, yCoord, zCoord + 1))
                        widthNegative++;
                    else
                        break;

                for (int i = 1; i <= maxSize - 2; i++)
                    if (isClear(xCoord + i, yCoord, zCoord + 1))
                        widthPositive++;
                    else
                        break;

                for (int i = 1; i <= maxSize - 2; i++)
                    if (isClear(xCoord, yCoord, zCoord + i))
                        depth++;
                    else
                        break;

                for (int i = 0; i <= maxSize - 2; i++)
                    if (isClear(xCoord, yCoord + i, zCoord + 1))
                        toTop++;
                    else
                        break;

                for (int i = 1; i <= maxSize - 2; i++)
                    if (isClear(xCoord, yCoord - i, zCoord + 1))
                        toBottom++;
                    else
                        break;

                break;

            case 3:
                orientation = Dimension.ORIENT_Z_N;

                for (int i = 1; i <= maxSize - 2; i++)
                    if (isClear(xCoord - i, yCoord, zCoord - 1))
                        widthNegative++;
                    else
                        break;

                for (int i = 1; i <= maxSize - 2; i++)
                    if (isClear(xCoord + i, yCoord, zCoord - 1))
                        widthPositive++;
                    else
                        break;

                for (int i = 1; i <= maxSize - 2; i++)
                    if (isClear(xCoord, yCoord, zCoord - i))
                        depth++;
                    else
                        break;

                for (int i = 0; i <= maxSize - 2; i++)
                    if (isClear(xCoord, yCoord + i, zCoord - 1))
                        toTop++;
                    else
                        break;

                for (int i = 1; i <= maxSize - 2; i++)
                    if (isClear(xCoord, yCoord - i, zCoord - 1))
                        toBottom++;
                    else
                        break;

                break;

            case 4:
                orientation = Dimension.ORIENT_X_P;

                for (int i = 1; i <= maxSize - 2; i++)
                    if (isClear(xCoord + 1, yCoord, zCoord - i))
                        widthNegative++;
                    else
                        break;

                for (int i = 1; i <= maxSize - 2; i++)
                    if (isClear(xCoord + 1, yCoord, zCoord + i))
                        widthPositive++;
                    else
                        break;

                for (int i = 1; i <= maxSize - 2; i++)
                    if (isClear(xCoord + i, yCoord, zCoord))
                        depth++;
                    else
                        break;

                for (int i = 0; i <= maxSize - 2; i++)
                    if (isClear(xCoord + 1, yCoord + i, zCoord))
                        toTop++;
                    else
                        break;

                for (int i = 1; i <= maxSize - 2; i++)
                    if (isClear(xCoord + 1, yCoord - i, zCoord))
                        toBottom++;
                    else
                        break;

                break;

            case 5:
                orientation = Dimension.ORIENT_X_N;

                for (int i = 1; i <= maxSize - 2; i++)
                    if (isClear(xCoord - 1, yCoord, zCoord - i))
                        widthNegative++;
                    else
                        break;

                for (int i = 1; i <= maxSize - 2; i++)
                    if (isClear(xCoord - 1, yCoord, zCoord + i))
                        widthPositive++;
                    else
                        break;

                for (int i = 1; i <= maxSize - 2; i++)
                    if (isClear(xCoord - i, yCoord, zCoord))
                        depth++;
                    else
                        break;

                for (int i = 0; i <= maxSize - 2; i++)
                    if (isClear(xCoord - 1, yCoord + i, zCoord))
                        toTop++;
                    else
                        break;

                for (int i = 1; i <= maxSize - 2; i++)
                    if (isClear(xCoord - 1, yCoord - i, zCoord))
                        toBottom++;
                    else
                        break;

                break;
        }

        // Increment by one or two if greater than zero, we're counting empty blocks, have to include walls.
        widthNegative = widthNegative + 1;
        widthPositive = widthPositive + 1;
        depth = (depth > 0) ? depth + 2 : 0;
        toTop = toTop + 1;
        toBottom = toBottom + 1;

        if (HexConfig.cfgTankDebug)
            System.out.println("[Tank Valve] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Valve elevation: " + toBottom);

        return new Dimension(orientation, widthNegative, widthPositive, depth, toTop, toBottom);
    }

    /**
     * Checks if the MultiTank is built properly: Base, rings and top
     *
     * @param dimension Dimensions of the MultiTank
     * @param metaFlag  switch whether or not to check the block's meta as well.
     *                  Used when re-checking a structure
     * @return is the structure correct
     */
    private boolean checkStructure(Dimension dimension, boolean metaFlag) {
        CoordRange coordRange = new CoordRange(xCoord, yCoord, zCoord, dimension);

        int startX = coordRange.getStartX();
        int endX = coordRange.getEndX();
        int startY = coordRange.getStartY();
        int endY = coordRange.getEndY();
        int startZ = coordRange.getStartZ();
        int endZ = coordRange.getEndZ();

        if (HexConfig.cfgTankDebug)
            System.out.println(String.format("[Tank Valve] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Structure dimensions: SX: %s, SY: %s, SZ:  %s, EX: %s, EY: %s, EZ: %s\n",
                startX, startY, startZ, endX, endY, endZ));

        boolean selfRotation = checkSelfValveRotation(xCoord, yCoord, zCoord, dimension);

        boolean goodSize = dimension.getWidth() > 2 && dimension.getHeight() > 2 && dimension.getDepth() > 2;

        if (HexConfig.cfgTankDebug)
            System.out.println("[Tank Valve] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Is the size okay: " + goodSize);

        if (!goodSize)
            return false;


        for (int y = startY; y <= endY; y++)
            for (int x = startX; x <= endX; x++)
                for (int z = startZ; z <= endZ; z++) {
                    // Corners
                    if ((x == startX && z==startZ) || (x == startX && z == endZ) || (x == endX && z == startZ) || (x == endX && z == endZ))
                        if (worldObj.getBlock(x, y, z) instanceof BlockTankValve)
                            return false;

                    // Rings
                    if (y > startY && y < endY) {
                        if ((x == startX || x == endX) || (z == startZ || z == endZ)) {
                            if (!isValidBlock(x, y, z, dimension, metaFlag, true))
                                return false;
                        }
                        else
                            if (!isClear(x, y, z))
                                return false;
                    }
                    // Base and Top
                    else
                        if (!isValidBlock(x, y, z, dimension, metaFlag, false))
                            return false;
                }

        return selfRotation;
    }

    /**
     * Sets up the structure, marking appropriate blocks and setting them relevant data.
     *
     * @param dimension The dimensions of the relevant MultiTank structure
     */
    private void setupStructure(Dimension dimension) {
        CoordRange coordRange = new CoordRange(xCoord, yCoord, zCoord, dimension);

        int startX = coordRange.getStartX();
        int endX = coordRange.getEndX();
        int startY = coordRange.getStartY();
        int endY = coordRange.getEndY();
        int startZ = coordRange.getStartZ();
        int endZ = coordRange.getEndZ();

        for (int y = startY; y <= endY; y++)
            for (int x = startX; x <= endX; x++)
                for (int z = startZ; z <= endZ; z++) {
                    // Rings
                    if (y > startY && y < endY) {
                        if ((x == startX || x == endX) || (z == startZ || z == endZ))
                            setIsPart(x, y, z, dimension, true);
                    }
                    // Base and Top
                    else
                        setIsPart(x, y, z, dimension, true);

                    // Remove any pre-existing render blocks
                    if (worldObj.getBlock(x, y, z) instanceof BlockTankRender)
                        worldObj.setBlock(x, y, z, Blocks.air);
                }
    }

    /**
     * Resets the data in the relevant blocks, freeing them up to be used in another structure.
     *
     * @param dimension The dimensions of the relevant MultiTank structure
     */
    private void resetStructure(Dimension dimension) {
        CoordRange coordRange = new CoordRange(xCoord, yCoord, zCoord, dimension);

        int startX = coordRange.getStartX();
        int endX = coordRange.getEndX();
        int startY = coordRange.getStartY();
        int endY = coordRange.getEndY();
        int startZ = coordRange.getStartZ();
        int endZ = coordRange.getEndZ();

        for (int y = startY; y <= endY; y++)
            for (int x = startX; x <= endX; x++)
                for (int z = startZ; z <= endZ; z++) {
                    // Rings
                    if (y > startY && y < endY) {
                        if ((x == startX || x == endX) || (z == startZ || z == endZ))
                            setIsPart(x, y, z, dimension, false);
                    }
                    // Base and Top
                    else
                        setIsPart(x, y, z, dimension, false);
                }

        destroyRenderBlock(renderX, renderY, renderZ);
        markDirty();
    }

    /**
     * Calculates the capacity of the fluid tank.
     */
    private int calculateTankCapacity(Dimension dimension) {
        return (HexConfig.cfgTankCapacityMultiplier * FluidContainerRegistry.BUCKET_VOLUME) *
            (dimension.getWidth() - 2) * (dimension.getHeight() - 2) * (dimension.getDepth() - 2);
    }

    /**
     * Gets the fluid tank from master block, even if used on slave.
     */
    private FluidTank getMasterTank() {
        if (!worldObj.isRemote) {
            if (!isMaster && isSetup) {
                TileTankValve tileTankValve = (TileTankValve) worldObj.getTileEntity(masterX, masterY, masterZ);
                if (tileTankValve != null)
                    return tileTankValve.getTank();
            }
        }
        return fluidTank;
    }

    /**
     * Updates the render block.
     */
    private void updateRenderBlock(int x, int y, int z, int level, int capacity, String fluidName) {
        TileTankRender tileTankRender = (TileTankRender) worldObj.getTileEntity(x, y, z);
        if (tileTankRender != null) {
            tileTankRender.setFluidLevel(level);
            tileTankRender.setTankCapacity(capacity);
            tileTankRender.setFluidName(fluidName);
        }
    }

    /**
     * Updates the valve.
     */
    public void updateValveStatus() {
        if (isMaster) {
            FluidTank fTank = getMasterTank();
            tankCapacity = fTank.getCapacity();
            fluidLevel = fTank.getFluidAmount();
            fluidName = "";
            if (fTank.getFluid() != null) {
                fluidName = FluidRegistry.getFluidName(fTank.getFluid());
            }

            updateRenderBlock(renderX, renderY, renderZ, fluidLevel, tankCapacity, fluidName);
        }
        else
        {
            TileTankValve tileTankValve = (TileTankValve) worldObj.getTileEntity(masterX, masterY, masterZ);
            if (tileTankValve != null)
                tileTankValve.updateValveStatus();
        }
    }

    /**
     * Spawns the block used for rendering.
     */
    private void spawnRenderBlock(int x, int y, int z, CoordRange coordRange) {

        if (HexConfig.cfgTankDebug)
            System.out.print("[Tank Valve] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Render spawned: " + x + ", " + y + ", " + z);

        worldObj.setBlock(x,y,z, HexBlocks.getHexBlock(BlockTankRender.ID));

        TileTankRender tileTankRender = (TileTankRender) worldObj.getTileEntity(x,y,z);

        if (tileTankRender != null) {
            tileTankRender.setStartX(coordRange.getStartX());
            tileTankRender.setStartY(coordRange.getStartY());
            tileTankRender.setStartZ(coordRange.getStartZ());

            tileTankRender.setEndX(coordRange.getEndX());
            tileTankRender.setEndY(coordRange.getEndY());
            tileTankRender.setEndZ(coordRange.getEndZ());

            tileTankRender.setFluidName("");
        }
    }

    /**
     * Destroys the block used for rendering.
     */
    private void destroyRenderBlock(int x, int y, int z) {

        if (HexConfig.cfgTankDebug)
            System.out.print("[Tank Valve] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Render destroyed: " + x + ", " + y + ", " + z);

        worldObj.setBlock(x, y, z, Blocks.air);
    }

    /**
     * Gets the tank.
     */
    public FluidTank getTank() {
        return fluidTank;
    }

    /**
     * Prints debug data.
     */
    public void printDebug() {
        if (HexConfig.cfgTankDebug)
            System.out.println(String.format("[Tank Valve] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Valve data:\nX:%s\nY:%s\nZ:%s\nisMaster:%s\nisSetup:%s\nMasterX:%s\nMasterY:%s\nMasterZ:%s",
                    xCoord, yCoord, zCoord, isMaster, isSetup, masterX, masterY, masterZ));
    }

    /**
     * Used to check the rotation of a valve.
     */
    private boolean checkValveRotation(int x, int y, int z, Dimension dimension) {

        // Use dimension and orientation info to derive sides, check valve orientation there, return if valve is properly turned around.
        int side1;
        int side2;

        switch (dimension.getOrientation()) {
            case Dimension.ORIENT_X_P:
                side1 = zCoord - dimension.getNegativeWidth();
                side2 = zCoord + dimension.getPositiveWidth();
                return !(z == side1 || z == side2) ||
                    HexUtils.getMetaBit(BlockTankValve.META_ROTATION, worldObj, x, y, z);

            case Dimension.ORIENT_X_N:
                side1 = zCoord - dimension.getNegativeWidth();
                side2 = zCoord + dimension.getPositiveWidth();
                return !(z == side1 || z == side2) ||
                     HexUtils.getMetaBit(BlockTankValve.META_ROTATION, worldObj, x, y, z);

            case Dimension.ORIENT_Z_P:
                side1 = xCoord - dimension.getNegativeWidth();
                side2 = xCoord + dimension.getPositiveWidth();
                return !(x == side1 || x == side2) ||
                    !HexUtils.getMetaBit(BlockTankValve.META_ROTATION, worldObj, x, y, z);

            case Dimension.ORIENT_Z_N:
                side1 = xCoord - dimension.getNegativeWidth();
                side2 = xCoord + dimension.getPositiveWidth();
                return !(x == side1 || x == side2) ||
                    !HexUtils.getMetaBit(BlockTankValve.META_ROTATION, worldObj, x, y, z);
        }
        return false;
    }

    /**
     * Used to check the rotation of the valve by itself.
     */
    private boolean checkSelfValveRotation(int x, int y, int z, Dimension dimension) {

        // Use dimension and orientation info to derive sides, check valve orientation there, return if valve is properly turned around.
        switch (dimension.getOrientation()) {
            case Dimension.ORIENT_X_P:
                return !HexUtils.getMetaBit(BlockTankValve.META_ROTATION, worldObj, x, y, z);
            case Dimension.ORIENT_X_N:
                return !HexUtils.getMetaBit(BlockTankValve.META_ROTATION, worldObj, x, y, z);
            case Dimension.ORIENT_Z_P:
                return HexUtils.getMetaBit(BlockTankValve.META_ROTATION, worldObj, x, y, z);
            case Dimension.ORIENT_Z_N:
                return HexUtils.getMetaBit(BlockTankValve.META_ROTATION, worldObj, x, y, z);
        }
        return false;
    }

    /**
     * Sets the data of valve elevation within the structure.
     */
    public void setValveElevData(int toBottom, int toTop) {
        structureDimension.setToBottom(toBottom);
        structureDimension.setToTop(toTop);
        structureDimension.setHeight(toTop + toBottom);
        markDirty();
    }

    /**
     * Receives notification that the structure has been modified in a way.
     */
    public void notificationStructureReset() {
        if (isSetup && isMaster) {
            if (checkStructure(structureDimension, false)) {
                if (HexConfig.cfgTankDebug)
                    System.out.println("[Tank Valve] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Hexorium Tank structure: GOOD");
            }
            else {
                if (HexConfig.cfgTankDebug)
                    System.out.println("[Tank Valve] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Hexorium Tank structure: BAD");

                resetStructure(structureDimension);

                if (HexConfig.cfgTankDebug)
                    System.out.println("[Tank Valve] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Hexorium Tank structure has been reset.");
            }
        }
    }

    /**
     * Fired when the valve is destroyed.
     */
    public void valveDestroyedStructureReset() {
        if (isSetup && isMaster) {
            if (HexConfig.cfgTankDebug)
                System.out.println("[Tank Valve] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Tank Valve destroyed!");

            resetStructure(structureDimension);

            if (HexConfig.cfgTankDebug)
                System.out.println("[Tank Valve] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Hexorium Tank structure has been reset.");
        }
    }

    /**
     * Runs through necessary checks and sets up the structure.
     *
     * @param side Side that the manipulator was used on.
     */

    public boolean setupMultiTank(int side) {
        Dimension dimension = scanDimensions(side);

        if (checkStructure(dimension, true)) {
            // Setup internal tank
            FluidStack fluid = fluidTank.getFluid();
            tankCapacity = calculateTankCapacity(dimension);
            fluidTank = new FluidTank(tankCapacity);
            if (fluid != null) {
                fluid.amount = (int) (fluid.amount * ((float) HexConfig.cfgTankKeepFluid / 100));
                fluidTank.fill(fluid, true);
            }
            fluidLevel = fluidTank.getFluidAmount();

            structureDimension = dimension;
            setupStructure(dimension); // Must be run before spawnRenderBlock because it removes pre-existing render blocks

            isSetup = true;
            isMaster = true;

            masterX = xCoord;
            masterY = yCoord;
            masterZ = zCoord;

            CoordRange coordRange = new CoordRange(xCoord, yCoord, zCoord, dimension);

            // Spawn info block with necessary info for custom tank rendering
            renderX = coordRange.getStartX() + dimension.getCenterOffsetX();
            renderY = (coordRange.getStartY() + coordRange.getEndY()) / 2;
            renderZ = coordRange.getStartZ() + dimension.getCenterOffsetZ();

            spawnRenderBlock(renderX, renderY, renderZ, coordRange);
            updateValveStatus();

            printDebug();
            markDirty();
            return true;
        }
        markDirty();
        return false;
    }

    /**
     * Fired when a player uses an item on the tank.
     */
    public void playerUseValve(EntityPlayer player) {
        if (isSetup) {
            ItemStack itemStack = player.getCurrentEquippedItem();
            FluidTank fTank = getMasterTank();

            if (!FluidContainerRegistry.isEmptyContainer(itemStack)) {
                FluidStack fluid = FluidContainerRegistry.getFluidForFilledItem(itemStack);
                if (fTank.fill(fluid, false) == fluid.amount) {
                    fTank.fill(fluid, true);
                    updateValveStatus();
                    player.inventory.setInventorySlotContents(player.inventory.currentItem,
                            FluidContainerRegistry.drainFluidContainer(itemStack));
                }
            }
            else {
                FluidStack fluid = fTank.getFluid();
                if (fluid != null)
                    if ((int) ((structureDimension.getHeight() - 2) * ((float) fluid.amount / fTank.getCapacity())) >= structureDimension.getToBottom() - 1) {
                        int capacity = FluidContainerRegistry.getContainerCapacity(fluid, itemStack);
                        if (fTank.drain(capacity, false).amount == capacity) {
                            fluid = fTank.drain(capacity, true);
                            updateValveStatus();
                            player.inventory.setInventorySlotContents(player.inventory.currentItem,
                                    FluidContainerRegistry.fillFluidContainer(fluid, itemStack));

                        }
                    }
            }
        }
    }

    /**
     * Check if the TIle Entity can be used by the player.
     */
    public boolean isUsableByPlayer(EntityPlayer player) {
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player
                .getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D)
                <= 64.0D;
    }

    /**** TileFluidHandler Methods ****/

    /**
     * Fills fluid into internal tanks, distribution is left entirely to the IFluidHandler.
     *
     * @param from Orientation the Fluid is pumped in from.
     * @param fluidStack FluidStack representing the Fluid and maximum amount of fluid to be filled.
     * @param doFill If false, fill will only be simulated.
     * @return Amount of resource that was (or would have been, if simulated) filled.
     */
    @Override
    public int fill(ForgeDirection from, FluidStack fluidStack, boolean doFill) {
        if (isSetup
            && (((from == ForgeDirection.SOUTH || from == ForgeDirection.NORTH) && HexUtils.getBit(BlockTankValve.META_ROTATION, getBlockMetadata()))
            || ((from == ForgeDirection.WEST || from == ForgeDirection.EAST) && !HexUtils.getBit(BlockTankValve.META_ROTATION, getBlockMetadata())))) {

            int fill = getMasterTank().fill(fluidStack, doFill);
            if (doFill) {
                updateValveStatus();
            }
            return fill;
        }
        return 0;
    }

    /**
     * Drains fluid out of internal tanks, distribution is left entirely to the IFluidHandler.
     *
     * @param from     Orientation the Fluid is drained to.
     * @param resource FluidStack representing the Fluid and maximum amount of fluid to be drained.
     * @param doDrain  If false, drain will only be simulated.
     * @return FluidStack representing the Fluid and amount that was (or would have been, if
     * simulated) drained.
     */
    @Override
    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
        if (isSetup
            && (((from == ForgeDirection.SOUTH || from == ForgeDirection.NORTH) && HexUtils.getBit(BlockTankValve.META_ROTATION, getBlockMetadata()))
            || ((from == ForgeDirection.WEST || from == ForgeDirection.EAST) && !HexUtils.getBit(BlockTankValve.META_ROTATION, getBlockMetadata())))) {

            FluidTank fTank = getMasterTank();
            FluidStack fluidStack = fTank.getFluid();
            if (fluidStack != null)
                if ((int) ((structureDimension.getHeight() - 2) * ((float) fluidStack.amount / fTank.getCapacity())) >= structureDimension.getToBottom() - 1) {
                    FluidStack drained = fTank.drain(fTank.getCapacity(), doDrain);
                    updateValveStatus();
                    return drained;
                }
        }
        return null;
    }

    /**
     * Drains fluid out of internal tanks, distribution is left entirely to the IFluidHandler.
     * This method is not Fluid-sensitive.
     *
     * @param from     Orientation the fluid is drained to.
     * @param maxDrain Maximum amount of fluid to drain.
     * @param doDrain  If false, drain will only be simulated.
     * @return FluidStack representing the Fluid and amount that was (or would have been, if
     * simulated) drained.
     */
    @Override
    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
        if (isSetup
            && (((from == ForgeDirection.SOUTH || from == ForgeDirection.NORTH) && HexUtils.getBit(BlockTankValve.META_ROTATION, getBlockMetadata()))
            || ((from == ForgeDirection.WEST || from == ForgeDirection.EAST) && !HexUtils.getBit(BlockTankValve.META_ROTATION, getBlockMetadata())))) {

            FluidTank fTank = getMasterTank();
            FluidStack fluidStack = fTank.getFluid();
            if (fluidStack != null) {
                if ((int) ((structureDimension.getHeight() - 2) * ((float) fluidStack.amount / fTank.getCapacity())) >= structureDimension.getToBottom() - 1) {
                    FluidStack drained = fTank.drain(maxDrain, doDrain);
                    updateValveStatus();
                    return drained;
                }
            }
        }
        return null;
    }

    /**
     * Returns true if the given fluid can be inserted into the given direction.
     * More formally, this should return true if fluid is able to enter from the given direction.
     *
     * @param from Orientation determining which tanks should be queried.
     * @param fluid Fluid to be drained.
     */
    @Override
    public boolean canFill(ForgeDirection from, Fluid fluid) {
        return isSetup && (((from == ForgeDirection.SOUTH || from == ForgeDirection.NORTH) && HexUtils.getBit(BlockTankValve.META_ROTATION, getBlockMetadata())) ||
                ((from == ForgeDirection.WEST || from == ForgeDirection.EAST) && !HexUtils.getBit(BlockTankValve.META_ROTATION, getBlockMetadata())));
    }

    /**
     * Returns true if the given fluid can be extracted from the given direction.
     * More formally, this should return true if fluid is able to leave from the given direction.
     *
     * @param from Orientation determining which tanks should be queried.
     * @param fluid Fluid to be drained.
     */
    @Override
    public boolean canDrain(ForgeDirection from, Fluid fluid) {
        if (isSetup
            && (((from == ForgeDirection.SOUTH || from == ForgeDirection.NORTH) && HexUtils.getBit(BlockTankValve.META_ROTATION, getBlockMetadata()))
            || ((from == ForgeDirection.WEST || from == ForgeDirection.EAST) && !HexUtils.getBit(BlockTankValve.META_ROTATION, getBlockMetadata())))) {

            FluidTank fTank = getMasterTank();
            FluidStack fluidStack = fTank.getFluid();
            if (fluidStack != null) {
                if ((int) ((structureDimension.getHeight() - 2) * ((float) fluidStack.amount / fTank.getCapacity())) >= structureDimension.getToBottom() - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns an array of objects which represent the internal tanks. These objects cannot be used
     * to manipulate the internal tanks. See {@link FluidTankInfo}.
     *
     * @param from Orientation determining which tanks should be queried.
     * @return Info for the relevant internal tanks.
     */
    @Override
    public FluidTankInfo[] getTankInfo(ForgeDirection from) {
        if (isSetup
            && (((from == ForgeDirection.SOUTH || from == ForgeDirection.NORTH) && HexUtils.getBit(BlockTankValve.META_ROTATION, getBlockMetadata()))
            || ((from == ForgeDirection.WEST || from == ForgeDirection.EAST) && !HexUtils.getBit(BlockTankValve.META_ROTATION, getBlockMetadata())))) {

            FluidTankInfo[] fluidTankInfos = new FluidTankInfo[1];
            fluidTankInfos[0] = new FluidTankInfo(getMasterTank());

            return fluidTankInfos;
        }

        return null;
    }

    /**
     * Called by Hexorium Probe to display tile entity info to chat.
     * @param player Player to show the message to.
     */
    public void displayInfoValve(EntityPlayer player) {
        // If player is not sneaking.
        if (!player.isSneaking()) {
            HexUtils.addChatProbeTitle(player);
            HexUtils.addChatProbeGenericInfo(player, worldObj, xCoord, yCoord, zCoord);
            player.addChatMessage(new ChatComponentTranslation("msg.probeTypeValve.txt"));
            if (!HexUtils.getMetaBit(HexBlocks.META_STRUCTURE_IS_PART, worldObj, xCoord, yCoord, zCoord))
                player.addChatMessage(new ChatComponentTranslation("msg.probeFluidNotFormed.txt"));
            else if(getMasterTank().getFluid() == null || getMasterTank().getFluidAmount() == 0)
                player.addChatMessage(new ChatComponentTranslation("msg.probeFluidEmpty.txt",  HexUtils.formatFluids(0), HexUtils.formatFluids(getMasterTank().getCapacity())));
            else
                player.addChatMessage(new ChatComponentTranslation("msg.probeFluid.txt", getMasterTank().getFluid().getLocalizedName(),
                        HexUtils.formatFluids(getMasterTank().getFluidAmount()), HexUtils.formatFluids(getMasterTank().getCapacity())));
            if (isMaster)
                player.addChatMessage(new ChatComponentTranslation("msg.probeMasterYes.txt"));
            else
                player.addChatMessage(new ChatComponentTranslation("msg.probeMasterNo.txt"));
            if (HexUtils.getMetaBit(HexBlocks.META_STRUCTURE_IS_PART, worldObj, xCoord, yCoord, zCoord))
                player.addChatMessage(new ChatComponentTranslation("msg.probeFormedYes.txt"));
            else
                player.addChatMessage(new ChatComponentTranslation("msg.probeFormedNo.txt"));

            if (HexConfig.cfgGeneralUseAchievements)
                player.addStat(HexAchievements.achUseProbeMachine, 1);
        }
    }

    /**** Getters and Setters ****/

    /**
     * @param isSetup Is the multi tank set up.
     */
    public void setSetup(boolean isSetup) {
        this.isSetup = isSetup;
        markDirty();
    }

    /**
     * @param isMaster Is the valve master.
     */
    public void setMaster(boolean isMaster) {
        this.isMaster = isMaster;
        markDirty();
    }

    /**
     * @param masterX X coordinate of the master valve.
     */
    public void setMasterX(int masterX) {
        this.masterX = masterX;
        markDirty();
    }

    /**
     * @param masterY Y coordinate of the master valve.
     */
    public void setMasterY(int masterY) {
        this.masterY = masterY;
        markDirty();
    }

    /**
     * @param masterZ Z coordinate of the master valve.
     */
    public void setMasterZ(int masterZ) {
        this.masterZ = masterZ;
        markDirty();
    }

    // Tank Capacity
    public int getTankCapacity() {
        return this.getMasterTank().getCapacity();
    }

    public void setGuiTankCapacity(int guiTankCapacity) {
        this.guiTankCapacity = guiTankCapacity;
    }

    public int getGuiTankCapacity() {
        return this.guiTankCapacity;
    }

    // Fluid Level
    public int getFluidLevel() {
        return this.getMasterTank().getFluidAmount();
    }

    public void setGuiFluidLevel(int guiFluidLevel) {
        this.guiFluidLevel = guiFluidLevel;
    }

    public int getGuiFluidLevel() {
        return this.guiFluidLevel;
    }

    // Fluid ID
    public int getFluidID() {
        FluidStack fluidStack = this.getMasterTank().getFluid();
        if (fluidStack != null)
            return FluidRegistry.getFluidID(fluidStack.getFluid());
        return 0;
    }

    public void setGuiFluidID(int guiFluidID) {
        this.guiFluidID = guiFluidID;
    }

    public int getGuiFluidID() {
        return this.guiFluidID;
    }

    // Fluid Inserted
    public int getFluidIns() {
        if (!isSetup)
            return 0;
        else {
            FluidStack fluidStack = getMasterTank().getFluid();
            if (fluidStack != null)
                return 2;
            else
                return 1;
        }
    }

    public void setGuiFluidIns(int fluidIns) {
        this.guiFluidIns = fluidIns;
    }

    public int getGuiFluidIns() {
        return this.guiFluidIns;
    }

    /**
     * Data holder class which holds relevant data needed for operation of the MultiTank
     */
    private class Dimension {
        /**
         * Depth grows on X axis, positive direction
         */
        private static final int ORIENT_X_P = 0;
        /**
         * Depth grows on X axis, negative direction
         */
        private static final int ORIENT_X_N = 1;
        /**
         * Depth grows on Z axis, positive direction
         */
        private static final int ORIENT_Z_P = 2;
        /**
         * Depth grows on Z axis, negative direction
         */
        private static final int ORIENT_Z_N = 3;

        private static final String ORIENT = "orientation";
        private static final String NEGATIVE_WIDTH = "negative_width";
        private static final String POSITIVE_WIDTH = "positive_width";
        private static final String WIDTH = "width";
        private static final String DEPTH = "depth";
        private static final String HEIGHT = "height";
        private static final String TO_TOP = "to_top";
        private static final String TO_BOTTOM = "to_bottom";

        private int orientation;
        private int negativeWidth;
        private int positiveWidth;
        private int width;
        private int depth;
        private int height;
        private int toTop;
        private int toBottom;

        public Dimension() {
            this.orientation = -1;
            this.negativeWidth = -1;
            this.positiveWidth = -1;
            this.width = -1;
            this.depth = -1;
            this.height = -1;
            this.toTop = -1;
            this.toBottom = -1;
        }

        /**
         * Constructor
         *
         * @param orientation   How the structure is oriented
         * @param negativeWidth Amount of blocks on the negative side
         * @param positiveWidth Amount of blocks on the positive side
         * @param depth         Depth
         * @param toTop        # of blocks to toTop coordinate
         * @param toBottom      # of blocks to bottom coordinate
         */
        public Dimension(int orientation, int negativeWidth, int positiveWidth, int depth,
            int toTop, int toBottom) {
            this.orientation = orientation;
            this.negativeWidth = negativeWidth;
            this.positiveWidth = positiveWidth;
            this.depth = depth;
            this.width = negativeWidth + positiveWidth + 1;
            this.toTop = toTop;
            this.toBottom = toBottom;
            this.height = toTop + toBottom;
        }

        /**
         * Saves contained data into NBTTag
         *
         * @param data NBTTag
         */
        public void saveToNBT(NBTTagCompound data) {
            data.setInteger(ORIENT, this.orientation);
            data.setInteger(NEGATIVE_WIDTH, this.negativeWidth);
            data.setInteger(POSITIVE_WIDTH, this.positiveWidth);
            data.setInteger(WIDTH, this.width);
            data.setInteger(DEPTH, this.depth);
            data.setInteger(HEIGHT, this.height);
            data.setInteger(TO_TOP, this.toTop);
            data.setInteger(TO_BOTTOM, this.toBottom);
        }

        /**
         * Loads data from NBTTag into itself
         *
         * @param data NBTTag
         */
        public void loadFromNBT(NBTTagCompound data) {
            this.orientation = data.getInteger(ORIENT);
            this.negativeWidth = data.getInteger(NEGATIVE_WIDTH);
            this.positiveWidth = data.getInteger(POSITIVE_WIDTH);
            this.width = data.getInteger(WIDTH);
            this.depth = data.getInteger(DEPTH);
            this.height = data.getInteger(HEIGHT);
            this.toTop = data.getInteger(TO_TOP);
            this.toBottom = data.getInteger(TO_BOTTOM);
        }

        /**
         * Calculates the offset for the center of the multiblock
         * @return offset for X
         */
        public int getCenterOffsetX() {
            int side = 0;

            switch (orientation) {
                case ORIENT_X_N:
                    side = depth;
                    break;
                case ORIENT_X_P:
                    side = depth;
                    break;
                case ORIENT_Z_P:
                    side = width;
                    break;
                case ORIENT_Z_N:
                    side = width;
                    break;
            }
            return (int) Math.floor(side/ 2d);
        }

        /**
         * Calculates the offset for the center of the multiblock
         * @return offset for Z
         */
        public int getCenterOffsetZ() {
            int side = 0;

            switch (orientation) {
                case ORIENT_X_N:
                    side = width;
                    break;
                case ORIENT_X_P:
                    side = width;
                    break;
                case ORIENT_Z_P:
                    side = depth;
                    break;
                case ORIENT_Z_N:
                    side = depth;
                    break;
            }
            return (int) Math.floor(side/ 2d);
        }

        public int getToTop() {
            return this.toTop;
        }

        public void setToTop(int toTop) {
            this.toTop = toTop;
        }

        public int getToBottom() {
            return this.toBottom;
        }

        public void setToBottom(int toBottom) {
            this.toBottom = toBottom;
        }

        /**
         * @return structure orientation
         */
        public int getOrientation() {
            return this.orientation;
        }

        /**
         * @param orientation structure orientation
         */
        public void setOrientation(int orientation) {
            this.orientation = orientation;
        }

        /**
         * @return Amount of blocks on the negative side
         */
        public int getNegativeWidth() {
            return this.negativeWidth;
        }

        /**
         * @return Amount of blocks on the positive side
         */
        public int getPositiveWidth() {
            return this.positiveWidth;
        }

        /**
         * @return Total width of the structure
         */
        public int getWidth() {
            return this.width;
        }

        /**
         * @param width Total width of the structure
         */
        public void setWidth(int width) {
            this.width = width;
        }

        /**
         * @return Depth of the structure
         */
        public int getDepth() {
            return this.depth;
        }

        /**
         * @return Height of the structure
         */
        public int getHeight() {
            return this.height;
        }

        /**
         * @param height Height of the structure
         */
        public void setHeight(int height) {
            this.height = height;
        }
    }


    /**
     * Data holder for coordinate ranges used in traversing the structure
     */
    private class CoordRange {
        private int startX;
        private int endX;
        private int startY;
        private int endY;
        private int startZ;
        private int endZ;

        /**
         * Constructor which calculates coordinate ranges based on given coordinates and dimensions
         * along the way
         *
         * @param x         X coordinate
         * @param y         Y coordinate
         * @param z         Z coordinate
         * @param dimension MultiTank dimensions
         */
        public CoordRange(int x, int y, int z, Dimension dimension) {
            int startX = 0;
            int endX = 0;

            int startY = y - dimension.getToBottom();
            int endY = y + (dimension.getToTop() - 1);

            int startZ = 0;
            int endZ = 0;

            switch (dimension.getOrientation()) {
                case Dimension.ORIENT_X_N:
                    startX = x - dimension.getDepth() + 1;
                    endX = x;
                    startZ = z - dimension.getNegativeWidth();
                    endZ = z + dimension.getPositiveWidth();
                    break;

                case Dimension.ORIENT_X_P:
                    startX = x;
                    endX = x + dimension.getDepth() - 1;
                    startZ = z - dimension.getNegativeWidth();
                    endZ = z + dimension.getPositiveWidth();
                    break;

                case Dimension.ORIENT_Z_N:
                    startX = x - dimension.getNegativeWidth();
                    endX = x + dimension.getPositiveWidth();
                    startZ = z - dimension.getDepth() + 1;
                    endZ = z;
                    break;

                case Dimension.ORIENT_Z_P:
                    startX = x - dimension.getNegativeWidth();
                    endX = x + dimension.getPositiveWidth();
                    startZ = z;
                    endZ = z + dimension.getDepth() - 1;
                    break;
            }

            this.startX = startX;
            this.endX = endX;
            this.startY = startY;
            this.endY = endY;
            this.startZ = startZ;
            this.endZ = endZ;
        }

        /**
         * @return Start X coordinate
         */
        public int getStartX() {
            return this.startX;
        }

        /**
         * @return End X coordinate
         */
        public int getEndX() {
            return this.endX;
        }

        /**
         * @return Start Y coordinate
         */
        public int getStartY() {
            return this.startY;
        }

        /**
         * @return End Y coordinate
         */
        public int getEndY() {
            return this.endY;
        }

        /**
         * @return Start Z coordinate
         */
        public int getStartZ() {
            return this.startZ;
        }

        /**
         * @return End Z coordinate
         */
        public int getEndZ() {
            return this.endZ;
        }
    }
}
