package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.block.BlockHexoriumValve;
import com.celestek.hexcraft.block.BlockTemperedHexoriumGlass;
import com.celestek.hexcraft.block.HexBlockMT;
import com.celestek.hexcraft.util.HexUtils;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

/**
 * @Author CoffeePirate     <celestek@openmailbox.org>
 * @Version 0.1.0
 */
public class TileHexoriumValve extends TileEntity {

    /**
     * Meta bit for identifying blocks which are already part of a multitank
     */
    public static final int META_IS_PART = 1;
    /**
     * Meta bit for identifying which blocks have tried to "contact" the valve block
     */
    public static final int META_HAS_NOTIFIED = 2;

    // Set machine name.
    public static String ID = "tileHexoriumValve";
    private static String machineName = "Hexorium Valve";

    private Dimension mDimension;
    private int mTankMaxSize = 16;
    private int notifyCounter = 0;


    private boolean mIsSetup;

    private int mMasterX;
    private int mMasterY;
    private int mMasterZ;
    private boolean mIsMaster;

    public TileHexoriumValve() {
        mIsMaster = false;
        mIsSetup = false;
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

                    tileHexoriumValve.setmMasterX(xCoord);
                    tileHexoriumValve.setmMasterY(yCoord);
                    tileHexoriumValve.setmMasterZ(zCoord);

                    tileHexoriumValve.setmIsMaster(false);
                    tileHexoriumValve.setmIsSetup(false);
                }
            } else {
                TileEntity tileEntity = worldObj.getTileEntity(x, y, z);
                if (tileEntity instanceof TileHexoriumValve) {
                    TileHexoriumValve tileHexoriumValve = (TileHexoriumValve) tileEntity;

                    tileHexoriumValve.setmMasterX(xCoord);
                    tileHexoriumValve.setmMasterY(yCoord);
                    tileHexoriumValve.setmMasterZ(zCoord);

                    tileHexoriumValve.setmIsMaster(false);
                    tileHexoriumValve.setmIsSetup(false);
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
        // Conditions for setting up the base:
        //      Base is always 1 block below the valve
        //      Base is a slab, so width-negative to width+negative from current block to depthMax

        // Conditions for setting up the rings:
        //      Start at same Y as the valve
        //      At Depths 0 to maxHeight - 1, and max go from one width+negative to width+positive
        //      At all other depths skip everything which isn't width+negative or width+positive

        // Conditions for setting up the top:
        //      Top is at the top, so max y: yCoord + mHeight
        //      Top is a slab, so width-negative to width+positive from current block to depthMax

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

            mIsMaster = true;
            mIsSetup = true;
            mDimension = dimension;

            mMasterX = xCoord;
            mMasterY = yCoord;
            mMasterZ = zCoord;
        }

        System.out.format("[DEBUG] Dimensions: o:%s, nW:%s, pW:%s, w:%s, h:%s, d:%s\n",
            dimension.getOrientation(), dimension.getNegativeWidth(), dimension.getPositiveWidth(),
            dimension.getWidth(), dimension.getHeight(), dimension.getDepth());
    }

    /**
     * Receives notification that the structure has been modified in a way.
     * The master valve will always recieve 4 notifications, that way we know that every block has
     * fired a notification.
     */
    public void notifyChange() {
        notifyCounter++;

        if (notifyCounter > 3) {
            System.out.format("[DEBUG] Re-checking structure\n");
            if (mIsSetup && mIsMaster) {
                if (checkStructure(mDimension, false)) {
                    resetNotify(mDimension);
                } else {
                    resetStructure(mDimension);
                }
            }
            notifyCounter = 0;
        }
    }

    // TODO: JavaDoc
    public boolean ismIsSetup() {
        return mIsSetup;
    }

    public void setmIsSetup(boolean mIsSetup) {
        this.mIsSetup = mIsSetup;
    }

    public int getmMasterX() {
        return mMasterX;
    }

    public void setmMasterX(int mMasterX) {
        this.mMasterX = mMasterX;
    }

    public int getmMasterY() {
        return mMasterY;
    }

    public void setmMasterY(int mMasterY) {
        this.mMasterY = mMasterY;
    }

    public int getmMasterZ() {
        return mMasterZ;
    }

    public void setmMasterZ(int mMasterZ) {
        this.mMasterZ = mMasterZ;
    }

    public boolean ismIsMaster() {
        return mIsMaster;
    }

    public void setmIsMaster(boolean mIsMaster) {
        this.mIsMaster = mIsMaster;
    }

    /**
     * Data holder class which holds relevant data needed for operation of the multitank
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

        private int orientation;
        private int negativeWidth;
        private int positiveWidth;
        private int width;
        private int depth;
        private int height;

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

        public CoordRange() {
        }

        public CoordRange(int startX, int endX, int startY, int endY, int startZ, int endZ) {
            this.startX = startX;
            this.endX = endX;
            this.startY = startY;
            this.endY = endY;
            this.startZ = startZ;
            this.endZ = endZ;

        }

        public int getEndZ() {
            return endZ;
        }

        public void setEndZ(int endZ) {
            this.endZ = endZ;
        }

        public int getStartX() {
            return startX;
        }

        public void setStartX(int startX) {
            this.startX = startX;
        }

        public int getEndX() {
            return endX;
        }

        public void setEndX(int endX) {
            this.endX = endX;
        }

        public int getStartY() {
            return startY;
        }

        public void setStartY(int startY) {
            this.startY = startY;
        }

        public int getEndY() {
            return endY;
        }

        public void setEndY(int endY) {
            this.endY = endY;
        }

        public int getStartZ() {
            return startZ;
        }

        public void setStartZ(int startZ) {
            this.startZ = startZ;
        }
    }
}
