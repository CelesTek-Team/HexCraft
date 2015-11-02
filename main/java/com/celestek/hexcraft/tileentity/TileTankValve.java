package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.block.BlockTankRender;
import com.celestek.hexcraft.block.BlockTankValve;
import com.celestek.hexcraft.block.BlockTemperedHexoriumGlass;
import com.celestek.hexcraft.block.HexBlockMT;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.util.HexUtils;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.*;

/**
 * @Author CoffeePirate     <celestek@openmailbox.org>
 * @Version 0.1.0
 */
public class TileTankValve extends TileEntity implements IFluidHandler {

    /**
     * Meta bit for identifying blocks which are already part of a multitank
     */
    public static final int META_IS_PART = 1;
    /**
     * Meta bit for identifying which blocks have tried to "contact" the valve block
     */
    public static final int META_HAS_NOTIFIED = 2;
    /**
     * Meta bit for setting the valve texture orientation
     */
    public static final int META_ROTATION = 3;

    // Set machine name.
    public static final String ID = "tileHexoriumValve";
    public static final String MACHINE_NAME = "Hexorium Valve";
    private static final String NBT_IS_SETUP = "ctek_mt_issetup";
    private static final String NBT_IS_MASTER = "ctek_mt_ismaster";
    private static final String NBT_MASTER_X = "ctek_mt_master_x";
    private static final String NBT_MASTER_Y = "ctek_mt_master_y";
    private static final String NBT_MASTER_Z = "ctek_mt_master_z";
    private static final String NBT_TANK_CAPACITY = "ctek_mt_capacity";
    private static final String NBT_INFOBLOCK_X = "ctek_mt_infoblock_x";
    private static final String NBT_INFOBLOCK_Y = "ctek_mt_infoblock_y";
    private static final String NBT_INFOBLOCK_Z = "ctek_mt_infoblock_z";
    private static final int TANK_MAX_DIMENSION = HexConfig.cfgMultiblockTankMaxDimension;
    private static final int TANK_CAPACITY_MULTIPLIER =
        HexConfig.cfgMultiblockTankCapacityMultiplier;
    private int notifyCounter = 0;

    private Dimension structureDimension;
    private FluidTank fluidTank;

    private int masterX;
    private int masterY;
    private int masterZ;

    private int infoBlockX;
    private int infoBlockY;
    private int infoBlockZ;

    private boolean isMaster;
    private boolean isSetup;

    private int tankCapacity = 0;
    private int tankFluidLevel = 0;

    public TileTankValve() {
        this.tankCapacity = 0;
        this.tankFluidLevel = 0;
        this.structureDimension = new Dimension();
        this.fluidTank = new FluidTank(0);

        this.notifyCounter = 0;

        this.isMaster = false;
        this.isSetup = false;

        this.masterX = xCoord;
        this.masterY = yCoord;
        this.masterZ = zCoord;

    }

    @Override public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);
        structureDimension.saveToNBT(nbtTagCompound);

        nbtTagCompound.setBoolean(this.NBT_IS_MASTER, isMaster());
        nbtTagCompound.setBoolean(this.NBT_IS_SETUP, isSetup());

        nbtTagCompound.setInteger(this.NBT_MASTER_X, getMasterX());
        nbtTagCompound.setInteger(this.NBT_MASTER_Y, getMasterY());
        nbtTagCompound.setInteger(this.NBT_MASTER_Z, getMasterZ());

        nbtTagCompound.setInteger(this.NBT_TANK_CAPACITY, tankCapacity);

        fluidTank.writeToNBT(nbtTagCompound);
    }

    @Override public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);
        structureDimension.loadFromNBT(nbtTagCompound);

        setSetup(nbtTagCompound.getBoolean(this.NBT_IS_SETUP));
        setMaster(nbtTagCompound.getBoolean(this.NBT_IS_MASTER));

        setMasterX(nbtTagCompound.getInteger(this.NBT_MASTER_X));
        setMasterY(nbtTagCompound.getInteger(this.NBT_MASTER_Y));
        setMasterZ(nbtTagCompound.getInteger(this.NBT_MASTER_Z));

        tankCapacity = nbtTagCompound.getInteger(this.NBT_TANK_CAPACITY);

        fluidTank = new FluidTank(tankCapacity);

        fluidTank.readFromNBT(nbtTagCompound);

        infoBlockX = nbtTagCompound.getInteger(NBT_INFOBLOCK_X);
        infoBlockY = nbtTagCompound.getInteger(NBT_INFOBLOCK_Y);
        infoBlockZ = nbtTagCompound.getInteger(NBT_INFOBLOCK_Z);
    }

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
    private boolean isMultiTankBlock(int x, int y, int z, Dimension dimension, boolean checkMeta) { // TODO: Rename method maybe?
        Block block = worldObj.getBlock(x, y, z);

        boolean notNull = block != null;
        boolean blockType = block instanceof HexBlockMT
                || block == HexBlocks.blockTankValve
                || block == HexBlocks.blockTemperedHexoriumGlass;
        boolean isFree = false;
        boolean rotation = true;

        if (notNull) {
            int meta = worldObj.getBlockMetadata(x, y, z);
            isFree = !HexUtils.getBit(meta, META_IS_PART);
        }

        if (block instanceof BlockTankValve) {
            rotation = checkValveRotation(x,y,z, dimension);
            System.out.println("[DEBUG] CHECKING VALVE ROTATION" + rotation);
        }

        if (checkMeta) {
            return notNull && blockType && isFree && rotation;
        } else {
            return notNull && blockType && rotation;
        }



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
        return worldObj.isAirBlock(x, y, z) || worldObj.getBlock(x, y, z) == HexBlocks.blockTankRender;
    }

    /**
     * Marks the block as part of a MultiTank and sets relevant data
     *
     * @param x      X coordinate
     * @param y      Y coordinate
     * @param z      Z coordinate
     * @param isPart is or isn't part
     */
    private void setIsPart(int x, int y, int z, boolean isPart) {
        int meta = worldObj.getBlockMetadata(x, y, z);
        meta = HexUtils.setBit(meta, META_IS_PART, isPart);
        worldObj.setBlockMetadataWithNotify(x, y, z, meta, 2);


        TileEntity tileEntity = worldObj.getTileEntity(x, y, z);
        if (tileEntity instanceof TileTankValve) {
            if (!(x == xCoord && y == yCoord && z == zCoord)) {
                TileTankValve tileHexoriumValve = (TileTankValve) tileEntity;

                tileHexoriumValve.setMasterX(xCoord);
                tileHexoriumValve.setMasterY(yCoord);
                tileHexoriumValve.setMasterZ(zCoord);

                tileHexoriumValve.setMaster(false);
                tileHexoriumValve.setSetup(isPart);
            }
        }
    }

    /**
     * Sets whether or not the block has notified surrounding blocks of a change
     *
     * @param x           X coordinate
     * @param y           Y coordinate
     * @param z           Z coordinate
     * @param hasNotified has or hasn't fired a notification
     */
    private void setHasNotified(int x, int y, int z, boolean hasNotified) {
        int meta = worldObj.getBlockMetadata(x, y, z);
        meta = HexUtils.setBit(meta, META_HAS_NOTIFIED, hasNotified);
        worldObj.setBlockMetadataWithNotify(x, y, z, meta, 4);
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

        int depth = 0;
        int widthPositive = 0;
        int widthNegative = 0;
        int height = 0;
        int orientation = 0;

        switch (side) {
            case 2:
                orientation = Dimension.ORIENT_Z_P;

                for (int i = 1; i <= TANK_MAX_DIMENSION - 2; i++) {
                    if (isClear(xCoord - i, yCoord, zCoord + 1)) {
                        widthNegative++;
                    } else {
                        break;
                    }
                }

                for (int i = 1; i <= TANK_MAX_DIMENSION - 2; i++) {
                    if (isClear(xCoord + i, yCoord, zCoord + 1)) {
                        widthPositive++;
                    } else {
                        break;
                    }
                }

                for (int i = 1; i <= TANK_MAX_DIMENSION - 2; i++) {
                    if (isClear(xCoord, yCoord, zCoord + i)) {
                        depth++;
                    } else {
                        break;
                    }
                }

                for (int i = 0; i <= TANK_MAX_DIMENSION - 2; i++) {
                    if (isClear(xCoord, yCoord + i, zCoord + 1)) {
                        height++;
                    } else {
                        break;
                    }
                }
                break;

            case 3:
                orientation = Dimension.ORIENT_Z_N;

                for (int i = 1; i <= TANK_MAX_DIMENSION - 2; i++) {
                    if (isClear(xCoord - i, yCoord, zCoord - 1)) {
                        widthNegative++;
                    } else {
                        break;
                    }
                }

                for (int i = 1; i <= TANK_MAX_DIMENSION - 2; i++) {
                    if (isClear(xCoord + i, yCoord, zCoord - 1)) {
                        widthPositive++;
                    } else {
                        break;
                    }
                }

                for (int i = 1; i <= TANK_MAX_DIMENSION - 2; i++) {
                    if (isClear(xCoord, yCoord, zCoord - i)) {
                        depth++;
                    } else {
                        break;
                    }
                }

                for (int i = 0; i <= TANK_MAX_DIMENSION - 2; i++) {
                    if (isClear(xCoord, yCoord + i, zCoord - 1)) {
                        height++;
                    } else {
                        break;
                    }
                }
                break;

            case 4:
                orientation = Dimension.ORIENT_X_P;

                for (int i = 1; i <= TANK_MAX_DIMENSION - 2; i++) {
                    if (isClear(xCoord + 1, yCoord, zCoord - i)) {
                        widthNegative++;
                    } else {
                        break;
                    }
                }

                for (int i = 1; i <= TANK_MAX_DIMENSION - 2; i++) {
                    if (isClear(xCoord + 1, yCoord, zCoord + i)) {
                        widthPositive++;
                    } else {
                        break;
                    }
                }

                for (int i = 1; i <= TANK_MAX_DIMENSION - 2; i++) {
                    if (isClear(xCoord + i, yCoord, zCoord)) {
                        depth++;
                    } else {
                        break;
                    }
                }

                for (int i = 0; i <= TANK_MAX_DIMENSION - 2; i++) {
                    if (isClear(xCoord + 1, yCoord + i, zCoord)) {
                        height++;
                    } else {
                        break;
                    }
                }
                break;

            case 5:
                orientation = Dimension.ORIENT_X_N;

                for (int i = 1; i <= TANK_MAX_DIMENSION - 2; i++) {
                    if (isClear(xCoord - 1, yCoord, zCoord - i)) {
                        widthNegative++;
                    } else {
                        break;
                    }
                }

                for (int i = 1; i <= TANK_MAX_DIMENSION - 2; i++) {
                    if (isClear(xCoord - 1, yCoord, zCoord + i)) {
                        widthPositive++;
                    } else {
                        break;
                    }
                }

                for (int i = 1; i <= TANK_MAX_DIMENSION - 2; i++) {
                    if (isClear(xCoord - i, yCoord, zCoord)) {
                        depth++;
                    } else {
                        break;
                    }
                }

                for (int i = 0; i <= TANK_MAX_DIMENSION - 2; i++) {
                    if (isClear(xCoord - 1, yCoord + i, zCoord)) {
                        height++;
                    } else {
                        break;
                    }
                }
                break;
        }

        // Increment by one or two if greater than zero, we're counting empty blocks, have to include walls
        widthNegative = widthNegative + 1;
        widthPositive = widthPositive + 1;
        depth = (depth > 0) ? depth + 2 : 0;
        height = (height > 0) ? height + 2 : 0;


        return new Dimension(orientation, widthNegative, widthPositive, depth, height);
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

        boolean selfRotation = checkSelfeValveRotation(xCoord, yCoord, zCoord, dimension);

        int startX = coordRange.getStartX();
        int endX = coordRange.getEndX();
        int startY = coordRange.getStartY();
        int endY = coordRange.getEndY();
        int startZ = coordRange.getStartZ();
        int endZ = coordRange.getEndZ();

        for (int y = startY; y <= endY; y++) {
            for (int x = startX; x <= endX; x++) {
                for (int z = startZ; z <= endZ; z++) {
                    // RINGS
                    if (y > startY && y < endY) {
                        boolean check = (x == startX || x == endX) || (z == startZ || z == endZ);
                        if (check) {
                            if (!isMultiTankBlock(x, y, z, dimension, metaFlag)) {
                                return false && selfRotation;
                            }
                        } else {
                            if (!isClear(x, y, z)) {
                                return false && selfRotation;
                            }
                        }
                        // Base and Top
                    } else {
                        if (!isMultiTankBlock(x, y, z, dimension ,metaFlag)) {
                            return false && selfRotation;
                        }
                    }
                }
            }
        }
        return true && selfRotation;
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

        for (int y = startY; y <= endY; y++) {
            for (int x = startX; x <= endX; x++) {
                for (int z = startZ; z <= endZ; z++) {
                    // RINGS
                    if (y > startY && y < endY) {
                        boolean check = (x == startX || x == endX) || (z == startZ || z == endZ);
                        if (check) {
                            setIsPart(x, y, z, true);
                        }
                        // Base and Top
                    } else {
                        setIsPart(x, y, z, true);
                    }

                    Block block = worldObj.getBlock(x,y,z);

                    // Remove any pre-existing render blocks
                    if (block == HexBlocks.blockTankRender) {
                        worldObj.setBlock(x, y, z, Blocks.air);
                    }
                }
            }
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

        for (int y = startY; y <= endY; y++) {
            for (int x = startX; x <= endX; x++) {
                for (int z = startZ; z <= endZ; z++) {
                    // RINGS
                    if (y > startY && y < endY) {
                        boolean check = (x == startX || x == endX) || (z == startZ || z == endZ);
                        if (check) {
                            setIsPart(x, y, z, false);
                            setHasNotified(x, y, z, false);
                        }
                        // Base and Top
                    } else {
                        setIsPart(x, y, z, false);
                        setHasNotified(x, y, z, false);
                    }
                }
            }
        }

        destroyRenderBlock(infoBlockX, infoBlockY, infoBlockZ);
    }

    private int calculateTankSize(Dimension dimension) {

        long tankMul = (long) TANK_CAPACITY_MULTIPLIER;
        long bVol = (long) FluidContainerRegistry.BUCKET_VOLUME;
        long wid = (long) dimension.getWidth() - 2;
        long hei = (long) dimension.getHeight() - 2;
        long dep = (long) dimension.getDepth() - 2;
        long overflow = tankMul * bVol * wid * hei * dep;

        if (overflow > Integer.MAX_VALUE) {
            System.out.println("[ERR] Int Overflow!:" + overflow);
        }

        return (TANK_CAPACITY_MULTIPLIER * FluidContainerRegistry.BUCKET_VOLUME) *
            (dimension.getWidth() - 2) * (dimension.getHeight() - 2) * (dimension.getDepth() - 2);
    }

    /**
     * Resets the notify meta in the relevant blocks, allowing the structure to report changes.
     *
     * @param dimension The dimensions of the relevant MultiTank structure
     */
    private void resetNotify(Dimension dimension) {
        CoordRange coordRange = new CoordRange(xCoord, yCoord, zCoord, dimension);

        int startX = coordRange.getStartX();
        int endX = coordRange.getEndX();
        int startY = coordRange.getStartY();
        int endY = coordRange.getEndY();
        int startZ = coordRange.getStartZ();
        int endZ = coordRange.getEndZ();

        for (int y = startY; y <= endY; y++) {
            for (int x = startX; x <= endX; x++) {
                for (int z = startZ; z <= endZ; z++) {
                    // RINGS
                    if (y > startY && y < endY) {
                        boolean check = (x == startX || x == endX) || (z == startZ || z == endZ);
                        if (check) {
                            setHasNotified(x, y, z, false);
                        }
                        // Base and Top
                    } else {
                        setHasNotified(x, y, z, false);
                    }
                }
            }
        }
    }

    public void valveInducedStructureReset() {
        if (isSetup && isMaster) {
            System.out.println("[DEBUG] valve destroyed");
            resetStructure(structureDimension);
            System.out.println("[DEBUG] structure reset");
            fluidTank = null;
        }
    }

    private FluidTank getFluidTank() {
        if (!worldObj.isRemote) {
            if (isMaster && isSetup) {
                return fluidTank;
            } else if (!isMaster() && isSetup()) {
                TileTankValve tileTankValve =
                    (TileTankValve) worldObj.getTileEntity(masterX, masterY, masterZ);

                return tileTankValve.getTank();
            }
        }
        return null;
    }

    private void updateRenderBlock(int x, int y, int z, int capacity, int level, String fluidName) {
        TileTankRender ttInfo = (TileTankRender) worldObj.getTileEntity(x,y,z);

        ttInfo.currVolume = level;
        ttInfo.maxVolume = capacity;
        ttInfo.fluidName = fluidName;
    }

    private void updateTankStatus() {
        tankCapacity = getFluidTank().getCapacity();
        tankFluidLevel = getFluidTank().getFluidAmount();
        String fluidName = getFluidTank().getInfo().fluid.getFluidID() + "";

        System.out.format("[DEBUG] UpdateTankStatus: TankCap: %s FluidLevl: %s, FluidName: %s \n", tankCapacity, tankFluidLevel, fluidName);

        updateRenderBlock(infoBlockX, infoBlockY, infoBlockZ, tankCapacity, tankFluidLevel, fluidName);
    }

    private void spawnRenderBlock(int x, int y, int z, CoordRange coordRange) {
        System.out.print("Render spawned: " + x + ", " + y + ", " + z);
        worldObj.setBlock(x,y,z, HexBlocks.blockTankRender);

        TileTankRender ttInfo = (TileTankRender) worldObj.getTileEntity(x,y,z);

        ttInfo.startX = coordRange.getStartX();
        ttInfo.startY = coordRange.getStartY();
        ttInfo.startZ = coordRange.getStartZ();

        ttInfo.endX = coordRange.getEndX();
        ttInfo.endY = coordRange.getEndY();
        ttInfo.endZ = coordRange.getEndZ();

        ttInfo.fluidName = "";
    }

    private void destroyRenderBlock(int x, int y, int z) {
        System.out.print("Render destroyed: " + x + ", " + y + ", " + z);
        worldObj.setBlock(x,y,z, Blocks.air);
    }

    /**
     * How should the texture be oriented depending on what axis the wall is
     *
     * If set to true the wall is on Z axis, if set to false the wall is on X axis
     *
     * @param x
     * @param y
     * @param z
     * @param rotation
     */
    private void setTextureOrientation(int x, int y, int z, boolean rotation) {
        int meta = worldObj.getBlockMetadata(x, y, z);
        meta = HexUtils.setBit(meta, META_ROTATION, rotation);
        worldObj.setBlockMetadataWithNotify(x, y, z, meta, 4);
    }

    public FluidTank getTank() {
        return fluidTank;
    }

    public void printDebug() {  // TODO: Remove this before push

        System.out.format(
            "[DEBUG] X:%s\nY:%s\nZ:%s\nisMaster:%s\nisSetup:%s\nMasterX:%s\nMasterY:%s\nMasterZ:%s\n",
            xCoord, yCoord, zCoord, isMaster, isSetup, masterX, masterY, masterZ);
    }

    private boolean checkValveRotation(int x, int y, int z, Dimension dimension) {
        // Use dimension and orientation info to derrive sides, check valve orientation there, return if valve is properly turned around

        int side1 = 0;
        int side2 = 0;

        boolean result = false;

        switch (dimension.getOrientation()) {

            case Dimension.ORIENT_X_P:
                side1 = zCoord - dimension.getNegativeWidth();
                side2 = zCoord + dimension.getPositiveWidth();

                if (z == side1 || z == side2) {
                    result =  HexUtils.getMetaBit(TileTankValve.META_ROTATION, worldObj, x,y,z); // instead of metaBit == true
                } else {
                    result =  true;
                }
                break;
            case Dimension.ORIENT_X_N:
                side1 = zCoord - dimension.getNegativeWidth();
                side2 = zCoord + dimension.getPositiveWidth();

                if (z == side1 || z == side2) {
                    result =  HexUtils.getMetaBit(TileTankValve.META_ROTATION, worldObj, x,y,z);
                } else {
                    result =  true;
                }
                break;
            case Dimension.ORIENT_Z_P:
                side1 = xCoord - dimension.getNegativeWidth();
                side2 = xCoord + dimension.getPositiveWidth();

                if (x == side1 || x == side2) {
                    result =  !HexUtils.getMetaBit(TileTankValve.META_ROTATION, worldObj, x,y,z);
                } else {
                    result =  true;
                }
                break;
            case Dimension.ORIENT_Z_N:
                side1 = xCoord - dimension.getNegativeWidth();
                side2 = xCoord + dimension.getPositiveWidth();

                if (x == side1 || x == side2) {
                    result =  !HexUtils.getMetaBit(TileTankValve.META_ROTATION, worldObj, x,y,z);
                } else {
                    result =  true;
                }
                break;
        }

        return result;
    }

    private boolean checkSelfeValveRotation(int x, int y, int z, Dimension dimension) {
        // Use dimension and orientation info to derrive sides, check valve orientation there, return if valve is properly turned around

        boolean result = false;

        switch (dimension.getOrientation()) {

            case Dimension.ORIENT_X_P:
                result =  !HexUtils.getMetaBit(TileTankValve.META_ROTATION, worldObj, x,y,z); // instead of metaBit == true
                break;
            case Dimension.ORIENT_X_N:
                result =  !HexUtils.getMetaBit(TileTankValve.META_ROTATION, worldObj, x,y,z);
                break;
            case Dimension.ORIENT_Z_P:
                result =  HexUtils.getMetaBit(TileTankValve.META_ROTATION, worldObj, x,y,z);
                break;
            case Dimension.ORIENT_Z_N:
                result =  HexUtils.getMetaBit(TileTankValve.META_ROTATION, worldObj, x,y,z);
                break;
        }

        return result;

    }

    /**
     * Runs through necessary checks and sets up the structure.
     *
     * @param side Side that the manipulator was used on
     */

    public void setupMultiTank(int side) {
        Dimension dimension = scanDimensions(side);

        if (checkStructure(dimension, true)) {
            setupStructure(dimension); // Must be run before spawnRenderBlock because it removes pre-existing render blocks

            isMaster = true;
            isSetup = true;
            structureDimension = dimension;

            masterX = xCoord;
            masterY = yCoord;
            masterZ = zCoord;

            CoordRange coordRange = new CoordRange(xCoord, yCoord, zCoord, dimension);

            // Spawn info block with necessary info for custom tank rendering
            infoBlockX = coordRange.getStartX() + dimension.getCenterOffsetX();
            infoBlockY = coordRange.getStartY() + 1;
            infoBlockZ = coordRange.getStartZ() + dimension.getCenterOffsetZ();
            spawnRenderBlock(infoBlockX, infoBlockY, infoBlockZ, coordRange);


            // Setup internal tank
            tankCapacity = calculateTankSize(dimension);
            fluidTank = new FluidTank(tankCapacity);
            tankFluidLevel = fluidTank.getFluidAmount();

            //
            /*switch (dimension.getOrientation()) {
                case Dimension.ORIENT_X_N:
                    setTextureOrientation(masterX, masterY, masterZ, false);
                    break;

                case Dimension.ORIENT_X_P:
                    setTextureOrientation(masterX, masterY, masterZ, false);
                    break;

                case Dimension.ORIENT_Z_N:
                    setTextureOrientation(masterX, masterY, masterZ, true);
                    break;

                case Dimension.ORIENT_Z_P:
                    setTextureOrientation(masterX, masterY, masterZ, true);
                    break;
            }*/


            printDebug();
        }
    }

    /**
     * Receives notification that the structure has been modified in a way.
     * The master valve will always recieve 4 notifications, that way we know that every block has
     * fired a notification.
     */
    public void notifyChange() {
        System.out.println("[DEBUG] Got notification");
        notifyCounter++;

        if (notifyCounter > 3) {
            if (isSetup && isMaster) {
                System.out.println("[DEBUG] Is setup and is master");
                if (checkStructure(structureDimension, false)) {
                    System.out.println("[DEBUG] structure is good");
                    resetNotify(structureDimension);
                } else {
                    System.out.println("[DEBUG] structure is bad");
                    resetStructure(structureDimension);
                    System.out.println("[DEBUG] structure reset");
                    fluidTank = null;
                }
            }
            notifyCounter = 0;
        }
    }

    public void interactedWithTank(EntityPlayer player) {
        ItemStack item = player.getCurrentEquippedItem();

        if (FluidContainerRegistry.isContainer(item)) {
            if (!FluidContainerRegistry.isEmptyContainer(item)) {
                FluidStack fluidStack = FluidContainerRegistry.getFluidForFilledItem(item);

                FluidTank fTank = getFluidTank();
                if (fTank != null) {
                    if (fTank.fill(fluidStack, true) > 0) {
                        ItemStack emptyFluidContainer =
                            FluidContainerRegistry.drainFluidContainer(item);
                        player.inventory.setInventorySlotContents(player.inventory.currentItem,
                            emptyFluidContainer);
                    }
                }
            }
        }
    }


    /**
     * @return is the multi tank set up
     */
    public boolean isSetup() {
        return isSetup;
    }

    /**
     * @param setup is the multi tank set up
     */
    public void setSetup(boolean setup) {
        this.isSetup = setup;
    }

    /**
     * @return X coordinate of the master valve
     */
    public int getMasterX() {
        return masterX;
    }

    /**
     * @param masterX X coordinate of the master valve
     */
    public void setMasterX(int masterX) {
        this.masterX = masterX;
    }

    /**
     * @return Y coordinate of the master valve
     */
    public int getMasterY() {
        return masterY;
    }

    /**
     * @param masterY Y coordinate of the master valve
     */
    public void setMasterY(int masterY) {
        this.masterY = masterY;
    }

    /**
     * @return Z coordinate of the master valve
     */
    public int getMasterZ() {
        return masterZ;
    }

    /**
     * @param masterZ Z coordinate of the master valve
     */
    public void setMasterZ(int masterZ) {
        this.masterZ = masterZ;
    }

    /**
     * @return Is the valve master
     */
    public boolean isMaster() {
        return isMaster;
    }

    /**
     * @param master Is the valve master
     */
    public void setMaster(boolean master) {
        this.isMaster = master;
    }

    /**
     * Fills fluid into internal tanks, distribution is left entirely to the IFluidHandler.
     *
     * @param from     Orientation the Fluid is pumped in from.
     * @param resource FluidStack representing the Fluid and maximum amount of fluid to be filled.
     * @param doFill   If false, fill will only be simulated.
     * @return Amount of resource that was (or would have been, if simulated) filled.
     */
    @Override public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
        int fill = getFluidTank().fill(resource, doFill);
        updateTankStatus();
        return fill;
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
    @Override public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
        FluidStack drained = getFluidTank().drain(calculateTankSize(structureDimension), doDrain);
        updateTankStatus();
        return drained;
    }

    /**
     * Drains fluid out of internal tanks, distribution is left entirely to the IFluidHandler.
     * <p/>
     * This method is not Fluid-sensitive.
     *
     * @param from     Orientation the fluid is drained to.
     * @param maxDrain Maximum amount of fluid to drain.
     * @param doDrain  If false, drain will only be simulated.
     * @return FluidStack representing the Fluid and amount that was (or would have been, if
     * simulated) drained.
     */
    @Override public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
        FluidStack drained = getFluidTank().drain(maxDrain, doDrain);
        updateTankStatus();
        return drained;
    }

    /**
     * Returns true if the given fluid can be inserted into the given direction.
     * <p/>
     * More formally, this should return true if fluid is able to enter from the given direction.
     *
     * @param from
     * @param fluid
     */
    @Override public boolean canFill(ForgeDirection from, Fluid fluid) {
        return true;
    }

    /**
     * Returns true if the given fluid can be extracted from the given direction.
     * <p/>
     * More formally, this should return true if fluid is able to leave from the given direction.
     *
     * @param from
     * @param fluid
     */
    @Override public boolean canDrain(ForgeDirection from, Fluid fluid) {

        int topY = masterY + (structureDimension.getHeight() - 2);
        int botY = masterY - 1;

        boolean canDrain = false;
        boolean isInRings = yCoord > botY && yCoord < topY;

        if (yCoord >= masterY) {
            int deltaHeight = yCoord - masterY;
            int minLvl = deltaHeight * structureDimension.getWidth() * structureDimension.getDepth()
                * TANK_CAPACITY_MULTIPLIER;
            canDrain = fluidTank.getFluidAmount() >= minLvl;
        }

        return canDrain && isInRings;
    }

    /**
     * Returns an array of objects which represent the internal tanks. These objects cannot be used
     * to manipulate the internal tanks. See {@link FluidTankInfo}.
     *
     * @param from Orientation determining which tanks should be queried.
     * @return Info for the relevant internal tanks.
     */
    @Override public FluidTankInfo[] getTankInfo(ForgeDirection from) {
        FluidTankInfo[] fluidTankInfos = new FluidTankInfo[0];
        fluidTankInfos[0] = new FluidTankInfo(getFluidTank());

        return fluidTankInfos;
    }

    /**
     * Check if the TIle Entity can be used by the player.
     */
    public boolean isUseableByPlayer(EntityPlayer player) {
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player
            .getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D)
            <= 64.0D;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(int tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public int getTankFluidLevel() {
        return tankFluidLevel;
    }

    public void setTankFluidLevel(int tankFluidLevel) {
        this.tankFluidLevel = tankFluidLevel;
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

        private static final String ORIENT = "ctek_mt_orientation";
        private static final String N_WIDTH = "ctek_mt_negative_width";
        private static final String P_WIDTH = "ctek_mt_positive_width";
        private static final String WIDTH = "ctek_mt_width";
        private static final String DEPTH = "ctek_mt_depth";
        private static final String HEIGHT = "ctek_mt_height";

        private int orientation;
        private int negativeWidth;
        private int positiveWidth;
        private int width;
        private int depth;
        private int height;

        public Dimension() {
            this.orientation = -1;
            this.negativeWidth = -1;
            this.positiveWidth = -1;
            this.width = -1;
            this.depth = -1;
            this.height = -1;
        }

        /**
         * Constructor
         *
         * @param orientation   How the structure is oriented
         * @param negativeWidth Amount of blocks on the negative side
         * @param positiveWidth Amount of blocks on the positive side
         * @param depth         Depth
         * @param height        Height
         */
        public Dimension(int orientation, int negativeWidth, int positiveWidth, int depth,
            int height) {
            this.orientation = orientation;
            this.negativeWidth = negativeWidth;
            this.positiveWidth = positiveWidth;
            this.depth = depth;
            this.width = negativeWidth + positiveWidth + 1;
            this.height = height;
        }

        /**
         * Saves contained data into NBTTag
         *
         * @param data NBTTag
         */
        public void saveToNBT(NBTTagCompound data) {
            data.setInteger(this.ORIENT, this.orientation);
            data.setInteger(this.N_WIDTH, this.negativeWidth);
            data.setInteger(this.P_WIDTH, this.positiveWidth);
            data.setInteger(this.WIDTH, this.width);
            data.setInteger(this.DEPTH, this.depth);
            data.setInteger(this.HEIGHT, this.height);
        }

        /**
         * Loads data from NBTTag into itself
         *
         * @param data NBTTag
         */
        public void loadFromNBT(NBTTagCompound data) {
            this.orientation = data.getInteger(this.ORIENT);
            this.negativeWidth = data.getInteger(this.N_WIDTH);
            this.positiveWidth = data.getInteger(this.P_WIDTH);
            this.width = data.getInteger(this.WIDTH);
            this.depth = data.getInteger(this.DEPTH);
            this.height = data.getInteger(this.HEIGHT);
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

        /**
         * @return structure orientation
         */
        public int getOrientation() {
            return orientation;
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
            return negativeWidth;
        }

        /**
         * @param negativeWidth Amount of blocks on the negative side
         */
        public void setNegativeWidth(int negativeWidth) {
            this.negativeWidth = negativeWidth;
        }

        /**
         * @return Amount of blocks on the positive side
         */
        public int getPositiveWidth() {
            return positiveWidth;
        }

        /**
         * @param positiveWidth Amount of blocks on the positive side
         */
        public void setPositiveWidth(int positiveWidth) {
            this.positiveWidth = positiveWidth;
        }

        /**
         * @return Total width of the structure
         */
        public int getWidth() {
            return width;
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
            return depth;
        }

        /**
         * @param depth Depth of the structure
         */
        public void setDepth(int depth) {
            this.depth = depth;
        }

        /**
         * @return Height of the structure
         */
        public int getHeight() {
            return height;
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
    private class CoordRange { // TODO: Finish JavaDoc
        private int startX;
        private int endX;
        private int startY;
        private int endY;
        private int startZ;
        private int endZ;

        /**
         * Data holder for coordinate ranges used in traversing the structure
         */
        public CoordRange() {
        }

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

            int startY = y - 1;
            int endY = startY + (dimension.getHeight() - 1);

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
         * Data holder for coordinate ranges used in traversing the structure
         *
         * @param startX Start X coordinate
         * @param endX   End X coordinate
         * @param startY Start Y coordinate
         * @param endY   End Y coordinate
         * @param startZ Start Z coordinate
         * @param endZ   End Z coordinate
         */
        public CoordRange(int startX, int endX, int startY, int endY, int startZ, int endZ) {
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
            return startX;
        }

        /**
         * @param startX Start X coordinate
         */
        public void setStartX(int startX) {
            this.startX = startX;
        }

        /**
         * @return End X coordinate
         */
        public int getEndX() {
            return endX;
        }

        /**
         * @param endX End X coordinate
         */
        public void setEndX(int endX) {
            this.endX = endX;
        }

        /**
         * @return Start Y coordinate
         */
        public int getStartY() {
            return startY;
        }

        /**
         * @param startY Start Y coordinate
         */
        public void setStartY(int startY) {
            this.startY = startY;
        }

        /**
         * @return End Y coordinate
         */
        public int getEndY() {
            return endY;
        }

        /**
         * @param endY End Y coordinate
         */
        public void setEndY(int endY) {
            this.endY = endY;
        }

        /**
         * @return Start Z coordinate
         */
        public int getStartZ() {
            return startZ;
        }

        /**
         * @param startZ End Z coordinate
         */
        public void setStartZ(int startZ) {
            this.startZ = startZ;
        }

        /**
         * @return End Z coordinate
         */
        public int getEndZ() {
            return endZ;
        }

        /**
         * @param endZ End Z coordinate
         */
        public void setEndZ(int endZ) {
            this.endZ = endZ;
        }
    }
}
