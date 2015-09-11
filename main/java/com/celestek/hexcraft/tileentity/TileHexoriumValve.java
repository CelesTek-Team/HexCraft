package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.block.BlockHexoriumValve;
import com.celestek.hexcraft.block.BlockTemperedHexoriumGlass;
import com.celestek.hexcraft.block.HexBlockMT;
import com.celestek.hexcraft.util.HexUtils;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * @Author CoffeePirate     <celestek@openmailbox.org>
 * @Version 0.1.0
 */
public class TileHexoriumValve extends TileEntity {

    // Set machine name.
    public static String ID = "tileHexoriumValve";
    private static String machineName = "Hexorium Valve";

    /**
     * Meta bit for identifying blocks which are already part of a multitank
     */
    public static final int META_IS_PART = 1;
    /**
     * Meta bit for identifying which blocks have tried to "contact" the valve block
     */
    public static final int META_HAS_NOTIFIED = 2;

    private static final String NBT_IS_SETUP = "ctek_mt_issetup";
    private static final String NBT_IS_MASTER = "ctek_mt_ismaster";
    private static final String NBT_MASTER_X = "ctek_mt_master_x";
    private static final String NBT_MASTER_Y = "ctek_mt_master_y";
    private static final String NBT_MASTER_Z = "ctek_mt_master_z";


    private static final int mTankMaxSize = 16;
    private int notifyCounter = 0;

    private Dimension mDimension;


    private int masterX;
    private int masterY;
    private int masterZ;

    private boolean isMaster;
    private boolean isSetup;

    public TileHexoriumValve() {
        mDimension = new Dimension();

        this.notifyCounter = 0;

        this.isMaster = false;
        this.isSetup = false;

        this.masterX = xCoord;
        this.masterY = yCoord;
        this.masterZ = zCoord;

    }

    @Override public void writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        mDimension.saveToNBT(data);

        data.setBoolean(this.NBT_IS_MASTER, isMaster());
        data.setBoolean(this.NBT_IS_SETUP, isSetup());

        data.setInteger(this.NBT_MASTER_X, getMasterX());
        data.setInteger(this.NBT_MASTER_Y, getMasterY());
        data.setInteger(this.NBT_MASTER_Z, getMasterZ());


        if (isMaster() && isSetup()) {

        }
    }

    @Override public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        mDimension.loadFromNBT(data);

        setSetup(data.getBoolean(this.NBT_IS_SETUP));
        setMaster(data.getBoolean(this.NBT_IS_MASTER));

        setMasterX(data.getInteger(this.NBT_MASTER_X));
        setMasterY(data.getInteger(this.NBT_MASTER_Y));
        setMasterZ(data.getInteger(this.NBT_MASTER_Z));

        if (isMaster() && isSetup()) {

        }
    }

    /**
     * Calculates coordinate ranges based on given coordinates and dimensions
     *
     * @param x         X coordinate
     * @param y         Y coordinate
     * @param z         Z coordinate
     * @param dimension MultiTank dimensions
     * @return Coordinate ranges needed to properly traverse the multitank structure
     */
    private CoordRange getCoordRanges(int x, int y, int z, Dimension dimension) {
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
        return new CoordRange(startX, endX, startY, endY, startZ, endZ);
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
    private boolean isMultiTankBlock(int x, int y, int z, boolean checkMeta) {
        Block block = worldObj.getBlock(x, y, z);

        boolean notNull = block != null;
        boolean blockType = block instanceof HexBlockMT || block instanceof BlockHexoriumValve
            || block instanceof BlockTemperedHexoriumGlass;
        boolean isFree = false;

        if (notNull) {
            int meta = worldObj.getBlockMetadata(x, y, z);
            isFree = !HexUtils.getBit(meta, META_IS_PART);
        }

        if (checkMeta) {
            return notNull && blockType && isFree;
        } else {
            return notNull && blockType;
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
        return worldObj.isAirBlock(x, y, z);
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
        worldObj.setBlockMetadataWithNotify(x, y, z, meta, 4);

        if (x != xCoord && y != yCoord && z != zCoord) {
            if (isPart) {
                TileEntity tileEntity = worldObj.getTileEntity(x, y, z);
                if (tileEntity instanceof TileHexoriumValve) {
                    TileHexoriumValve tileHexoriumValve = (TileHexoriumValve) tileEntity;

                    tileHexoriumValve.setMasterX(xCoord);
                    tileHexoriumValve.setMasterY(yCoord);
                    tileHexoriumValve.setMasterZ(zCoord);

                    tileHexoriumValve.setMaster(false);
                    tileHexoriumValve.setSetup(false);
                }
            } else {
                TileEntity tileEntity = worldObj.getTileEntity(x, y, z);
                if (tileEntity instanceof TileHexoriumValve) {
                    TileHexoriumValve tileHexoriumValve = (TileHexoriumValve) tileEntity;

                    tileHexoriumValve.setMasterX(xCoord);
                    tileHexoriumValve.setMasterY(yCoord);
                    tileHexoriumValve.setMasterZ(zCoord);

                    tileHexoriumValve.setMaster(false);
                    tileHexoriumValve.setSetup(false);
                }
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

                for (int i = 1; i <= mTankMaxSize - 2; i++) {
                    if (isClear(xCoord - i, yCoord, zCoord + 1)) {
                        widthNegative++;
                    } else {
                        break;
                    }
                }

                for (int i = 1; i <= mTankMaxSize - 2; i++) {
                    if (isClear(xCoord + i, yCoord, zCoord + 1)) {
                        widthPositive++;
                    } else {
                        break;
                    }
                }

                for (int i = 1; i <= mTankMaxSize - 2; i++) {
                    if (isClear(xCoord, yCoord, zCoord + i)) {
                        depth++;
                    } else {
                        break;
                    }
                }

                for (int i = 0; i <= mTankMaxSize - 2; i++) {
                    if (isClear(xCoord, yCoord + i, zCoord + 1)) {
                        height++;
                    } else {
                        break;
                    }
                }
                break;

            case 3:
                orientation = Dimension.ORIENT_Z_N;

                for (int i = 1; i <= mTankMaxSize - 2; i++) {
                    if (isClear(xCoord - i, yCoord, zCoord - 1)) {
                        widthNegative++;
                    } else {
                        break;
                    }
                }

                for (int i = 1; i <= mTankMaxSize - 2; i++) {
                    if (isClear(xCoord + i, yCoord, zCoord - 1)) {
                        widthPositive++;
                    } else {
                        break;
                    }
                }

                for (int i = 1; i <= mTankMaxSize - 2; i++) {
                    if (isClear(xCoord, yCoord, zCoord - i)) {
                        depth++;
                    } else {
                        break;
                    }
                }

                for (int i = 0; i <= mTankMaxSize - 2; i++) {
                    if (isClear(xCoord, yCoord + i, zCoord - 1)) {
                        height++;
                    } else {
                        break;
                    }
                }
                break;

            case 4:
                orientation = Dimension.ORIENT_X_P;

                for (int i = 1; i <= mTankMaxSize - 2; i++) {
                    if (isClear(xCoord + 1, yCoord, zCoord - i)) {
                        widthNegative++;
                    } else {
                        break;
                    }
                }

                for (int i = 1; i <= mTankMaxSize - 2; i++) {
                    if (isClear(xCoord + 1, yCoord, zCoord - i)) {
                        widthPositive++;
                    } else {
                        break;
                    }
                }

                for (int i = 1; i <= mTankMaxSize - 2; i++) {
                    if (isClear(xCoord + i, yCoord, zCoord)) {
                        depth++;
                    } else {
                        break;
                    }
                }

                for (int i = 0; i <= mTankMaxSize - 2; i++) {
                    if (isClear(xCoord + 1, yCoord + i, zCoord)) {
                        height++;
                    } else {
                        break;
                    }
                }
                break;

            case 5:
                orientation = Dimension.ORIENT_X_N;

                for (int i = 1; i <= mTankMaxSize - 2; i++) {
                    if (isClear(xCoord - 1, yCoord, zCoord - i)) {
                        widthNegative++;
                    } else {
                        break;
                    }
                }

                for (int i = 1; i <= mTankMaxSize - 2; i++) {
                    if (isClear(xCoord - 1, yCoord, zCoord - i)) {
                        widthPositive++;
                    } else {
                        break;
                    }
                }

                for (int i = 1; i <= mTankMaxSize - 2; i++) {
                    if (isClear(xCoord - i, yCoord, zCoord)) {
                        depth++;
                    } else {
                        break;
                    }
                }

                for (int i = 0; i <= mTankMaxSize - 2; i++) {
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
        CoordRange coordRange = getCoordRanges(xCoord, yCoord, zCoord, dimension);

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
                            if (!isMultiTankBlock(x, y, z, metaFlag)) {
                                return false;
                            }
                        } else {
                            if (!isClear(x, y, z)) {
                                return false;
                            }
                        }
                        // Base and Top
                    } else {
                        if (!isMultiTankBlock(x, y, z, metaFlag)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * Sets up the structure, marking appropriate blocks and setting them relevant data.
     *
     * @param dimension The dimensions of the relevant MultiTank structure
     */
    private void setupStructure(Dimension dimension) {
        CoordRange coordRange = getCoordRanges(xCoord, yCoord, zCoord, dimension);

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
        CoordRange coordRange = getCoordRanges(xCoord, yCoord, zCoord, dimension);

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
    }

    /**
     * Resets the notify meta in the relevant blocks, allowing the structure to report changes.
     *
     * @param dimension The dimensions of the relevant MultiTank structure
     */
    public void resetNotify(Dimension dimension) {
        CoordRange coordRange = getCoordRanges(xCoord, yCoord, zCoord, dimension);

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

    /**
     * Runs through necessary checks and sets up the structure.
     *
     * @param side Side that the manipulator was used on
     */

    public void setupMultiTank(int side) {
        Dimension dimension = scanDimensions(side);

        if (checkStructure(dimension, true)) {
            setupStructure(dimension);

            isMaster = true;
            isSetup = true;
            mDimension = dimension;

            masterX = xCoord;
            masterY = yCoord;
            masterZ = zCoord;
        }
    }

    /**
     * Receives notification that the structure has been modified in a way.
     * The master valve will always recieve 4 notifications, that way we know that every block has
     * fired a notification.
     */
    public void notifyChange() {
        notifyCounter++;

        if (notifyCounter > 3) {
            if (isSetup && isMaster) {
                if (checkStructure(mDimension, false)) {
                    resetNotify(mDimension);
                } else {
                    resetStructure(mDimension);
                }
            }
            notifyCounter = 0;
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
