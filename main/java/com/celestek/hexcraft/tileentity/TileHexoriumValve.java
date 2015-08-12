package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.block.*;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import com.celestek.hexcraft.util.HexUtils;
import scala.xml.dtd.impl.Base;

/**
 * @Author CoffeePirate     <celestek@openmailbox.org>
 * @Version 0.1.0
 */
public class TileHexoriumValve extends TileEntity {

    // Set machine name.
    public static String ID = "tileHexoriumValve";
    private static String machineName = "Hexorium Valve";

    private int tankMaxSize = 16;

    public boolean setupMultiTank() {
        debug();

        return false;
    }

    private void debug() {
        WidthScanResult widthScanResult = scanWidth();
        if (widthScanResult != null) {
            BaseScanResult baseSearchResult = scanBase(widthScanResult);
            if (baseSearchResult != null ) {

                int height = scanHeight();
                boolean rings = scanRings(widthScanResult, baseSearchResult, height);
                boolean top = scanForTop(widthScanResult, baseSearchResult, height);

                switch (widthScanResult.getOrientation()) {
                    case WidthScanResult.ORIENT_X:
                        System.out.println("(DEBUG) Width: X");
                        break;

                    case WidthScanResult.ORIENT_Z:
                        System.out.println("(DEBUG) Width: Z");
                        break;

                    case -1:
                        System.out.println("(DEBUG) Width: Error");
                }


                switch (baseSearchResult.getOrientation()) {
                    case BaseScanResult.ORIENT_Z_N:
                        System.out.format("(DEBUG) Orientation: ZN\n");
                        break;
                    case BaseScanResult.ORIENT_Z_P:
                        System.out.format("(DEBUG) Orientation: ZP\n");
                        break;
                    case BaseScanResult.ORIENT_X_N:
                        System.out.format("(DEBUG) Orientation: XN\n");
                        break;
                    case BaseScanResult.ORIENT_X_P:
                        System.out.format("(DEBUG) Orientation: XP\n");
                        break;
                }

                System.out.format("(DEBUG) height: %s\n", height);
                System.out.format("(DEBUG) rings: %s\n", rings);
                System.out.format("(DEBUG) top: %s\n", top);

                setupStructure(widthScanResult, baseSearchResult, height);
            }
        }
    }

    private boolean isMultiTankBlock(Block block, int x, int y, int z) {
        boolean notNull = block != null;

        boolean isFree = false;
        if (notNull) {
            int blockMeta = worldObj.getBlockMetadata(x, y, z);
            isFree = !HexUtils.getBit(blockMeta, 1);
        }

        boolean correctBlock = (block instanceof BlockConcentricHexoriumBlock) ||
                (block instanceof BlockEngineeredHexoriumBlock) ||
                (block instanceof BlockFramedHexoriumBlock) ||
                (block instanceof BlockGlowingHexoriumGlass) ||
                (block instanceof BlockHexoriumMachineBlock) ||
                (block instanceof BlockPlatedHexoriumBlock) ||
                (block instanceof BlockTemperedHexoriumGlass) ||
                (block instanceof BlockHexoriumValve);

        return notNull && isFree && correctBlock;
    }

    private boolean isCorrectWidth(int counted, int negative, int positive) {
        return counted == (negative + positive + 1); // +1 to include the valve/block below it, fixable in scanWidth()
    }

    private void setIsPart(int x, int y, int z, boolean isPart) {
        int currentMeta = worldObj.getBlockMetadata(x,y,z);
        currentMeta = HexUtils.setBit(currentMeta, 1, isPart);
        worldObj.setBlockMetadataWithNotify(x,y,z,currentMeta, 2);
    }

    private WidthScanResult scanWidth() {
        int countPositive = 0;
        int countNegative = 0;
        int orientation = -1;

        Block blockBelow = worldObj.getBlock(xCoord, yCoord - 1, zCoord);
        if (!isMultiTankBlock(blockBelow, xCoord, yCoord-1, zCoord)) {
            return null;
        }

        // Search on the X axis
        for (int i = 1; true; i++) {
            int xPositive = xCoord + i;
            int xNegative = xCoord - i;

            Block blockPositive = worldObj.getBlock(xPositive, yCoord, zCoord);
            Block blockNegative = worldObj.getBlock(xNegative, yCoord, zCoord);

            if (isMultiTankBlock(blockPositive, xPositive, yCoord, zCoord)) { countPositive++; }
            if (isMultiTankBlock(blockNegative, xNegative, yCoord, zCoord)) { countNegative++; }

            if (!isMultiTankBlock(blockPositive, xPositive, yCoord, zCoord) && !isMultiTankBlock(blockNegative, xNegative, yCoord, zCoord)) {
                orientation = WidthScanResult.ORIENT_X;
                break;
            }
        }

        // Search on the Z axis if no width was found on X axis
        if (countPositive == 0 && countNegative == 0) {
            countPositive = 0;
            countNegative = 0;
            for (int i = 1; true; i++) {
                int zPositive = zCoord + i;
                int zNegative = zCoord - i;
                Block blockPositive = worldObj.getBlock(xCoord, yCoord, zPositive);
                Block blockNegative = worldObj.getBlock(xCoord, yCoord, zNegative);

                if (isMultiTankBlock(blockPositive, xCoord, yCoord, zPositive)) { countPositive++; }
                if (isMultiTankBlock(blockNegative, xCoord, yCoord, zNegative)) { countNegative++; }

                // No more mutlitank building blocks
                if (!isMultiTankBlock(blockPositive, xCoord, yCoord, zPositive) && !isMultiTankBlock(blockNegative, xCoord, yCoord, zNegative)) { break; }
            }
            orientation = WidthScanResult.ORIENT_Z;
        }

        return new WidthScanResult(orientation, countNegative, countPositive);
    }

    private BaseScanResult scanBase(WidthScanResult widthScanResult) {
        int orientScan = widthScanResult.getOrientation();
        int wNegative = widthScanResult.getNegativeCount();
        int wPositive = widthScanResult.getPositiveCount();

        int orientation = 0;
        int depth = 0;

        if (orientScan == WidthScanResult.ORIENT_X) {
            // Scan pozitive depth growth on X axis
            for (int i = 0; true; i++) {
                int widthCounter = 0;

                for (int x = xCoord-wNegative; x <= xCoord+wPositive; x++) {
                    int y = yCoord - 1;
                    int z = zCoord + i;
                    Block block = worldObj.getBlock(x, y, z);

                    if(isMultiTankBlock(block, x, y, z)) { widthCounter++; }
                    else { break; }
                }

                if (isCorrectWidth(widthCounter, wNegative, wPositive)) {
                    depth++;
                    orientation = BaseScanResult.ORIENT_Z_P;
                }
                else { break; }
            }

            if (depth - 1 > 0) {
                return new BaseScanResult(orientation, depth);
            }

            depth = 0;

            // Scan negative depth growth on X axis
            for (int i = 0; true; i++) {
                int widthCounter = 0;

                for (int x = xCoord-wNegative; x <= xCoord+wPositive; x++) {
                    int y = yCoord - 1;
                    int z = zCoord - i;
                    Block block = worldObj.getBlock(x, y, z);

                    if(isMultiTankBlock(block, x, y, z)) { widthCounter++; }
                    else { break; }
                }

                if (widthCounter == (wNegative + wPositive + 1)) {
                    depth++;
                    orientation = BaseScanResult.ORIENT_Z_N;
                }
                else { break; }
            }
            if (depth - 1 > 0) {
                return new BaseScanResult(orientation, depth);
            }
            else {
                return null;
            }
        }
        else {
            for (int i = 0; true; i++) {
                int widthCounter = 0;

                for (int z = zCoord - wNegative; z <= zCoord + wPositive; z++) {
                    int x = xCoord + i;
                    int y = yCoord - 1;
                    Block block = worldObj.getBlock(xCoord + i, yCoord - 1, z);

                    if(isMultiTankBlock(block, x, y, z)) { widthCounter++; }
                    else { break; }
                }
                if (isCorrectWidth(widthCounter, wNegative, wPositive)) {
                    depth++;
                    orientation = BaseScanResult.ORIENT_X_P;
                }
                else { break; }
            }

            if (depth - 1 > 0) {
                return new BaseScanResult(orientation, depth);
            }

            depth = 0;

            for (int i = 0; true; i++) {
                int widthCounter = 0;

                for (int z = zCoord - wNegative; z <= zCoord + wPositive; z++) {
                    int x = xCoord - i;
                    int y = yCoord - 1;

                    Block block = worldObj.getBlock(xCoord - i, yCoord - 1, z);

                    if (isMultiTankBlock(block, x, y, z)) { widthCounter++; }
                    else { break; }
                }

                if (isCorrectWidth(widthCounter, wNegative, wPositive)) {
                    depth++;
                    orientation = BaseScanResult.ORIENT_X_N;
                }
                else { break; }
            }
            if (depth - 1 > 0) {
                return new BaseScanResult(orientation, depth);
            }
            else {
                return null;
            }
        }
    }

    private int scanHeight() {
        int height = 0;
        // Get the max Y size
        for (int y = yCoord; y < yCoord + tankMaxSize - 1; y++) {   // TODO: Potential bug here
            int x = xCoord;
            int z = zCoord;
            Block block = worldObj.getBlock(xCoord, y, zCoord);

            if (isMultiTankBlock(block, x, y, z)) {
                height++;
            } else {
                break;
            }
        }
        return height + 1; // Include the base
    }

    private boolean scanForTop(WidthScanResult widthScanResult, BaseScanResult baseScanResult, int height) {
        boolean hasTop = false;
        switch (baseScanResult.getOrientation()) {
            case BaseScanResult.ORIENT_X_P:
                hasTop = scanTopXP(widthScanResult, baseScanResult.getDept(), height);
                break;
            case BaseScanResult.ORIENT_X_N:
                hasTop = scanTopXN(widthScanResult, baseScanResult.getDept(), height);
                break;
            case BaseScanResult.ORIENT_Z_P:
                hasTop = scanTopZP(widthScanResult, baseScanResult.getDept(), height);
                break;
            case BaseScanResult.ORIENT_Z_N:
                hasTop = scanTopZN(widthScanResult, baseScanResult.getDept(), height);
                break;
        }
        return hasTop;
    }

    private boolean scanRings(WidthScanResult widthScanResult, BaseScanResult baseScanResult, int height) {
        boolean hasRings = false;
        int depth = baseScanResult.getDept();

        switch (baseScanResult.getOrientation()) {
            case BaseScanResult.ORIENT_X_P:
                hasRings = scanRingsXP(widthScanResult, depth, height);
                break;
            case BaseScanResult.ORIENT_X_N:
                hasRings = scanRingsXN(widthScanResult, depth, height);
                break;
            case BaseScanResult.ORIENT_Z_P:
                hasRings = scanRingsZP(widthScanResult, depth, height);
                break;
            case BaseScanResult.ORIENT_Z_N:
                hasRings = scanRingsZN(widthScanResult, depth, height);
                break;
        }

        return hasRings;
    }

    private void setupStructure(WidthScanResult widthScanResult, BaseScanResult baseScanResult, int height) {

        // Conditions for setting up the base:
        //      Base is always 1 block below the valve
        //      Base is a slab, so width-negative to width+negative from current block to depthMax

        // Conditions for setting up the rings:
        //      Start at same Y as the valve
        //      At Depths 0 to maxHeight - 1, and max go from one width+negative to width+positive
        //      At all other depths skip everything which isn't width+negative or width+positive

        // Conditions for setting up the top:
        //      Top is at the top, so max y: yCoord + height
        //      Top is a slab, so width-negative to width+positive from current block to depthMax

        int startX = 0;
        int endX = 0;

        int startY = yCoord - 1;
        int endY = yCoord + height;

        int startZ = 0;
        int endZ = 0;

        switch (baseScanResult.getOrientation()) {
            case BaseScanResult.ORIENT_X_N:
                startX = xCoord - baseScanResult.getDept();
                endX = xCoord;
                startZ = zCoord - widthScanResult.getNegativeCount();
                endZ = zCoord + widthScanResult.getPositiveCount();
                break;

            case BaseScanResult.ORIENT_X_P:
                startX = xCoord;
                endX = xCoord + baseScanResult.getDept();
                startZ = zCoord - widthScanResult.getNegativeCount();
                endZ = zCoord + widthScanResult.getPositiveCount();
                break;

            case BaseScanResult.ORIENT_Z_N:
                startX = xCoord - widthScanResult.getNegativeCount();
                endX = xCoord + widthScanResult.getPositiveCount();
                startZ = zCoord - baseScanResult.getDept();
                endZ = zCoord;
                break;

            case BaseScanResult.ORIENT_Z_P:
                startX = xCoord - widthScanResult.getNegativeCount();
                endX = xCoord + widthScanResult.getPositiveCount();
                startZ = zCoord;
                endZ = zCoord + baseScanResult.getDept();
                break;
        }

        System.out.format("(DEBUG) StartX: %s, EndX: %s\n", startX, endX);
        System.out.format("(DEBUG) StartY: %s, EndY: %s\n", startY, endY);
        System.out.format("(DEBUG) StartZ: %s, EndZ: %s\n", startZ, endZ);

        for (int y = startY; y < endY; y++) { // TODO: Check height scanning, could be it returns wrong value (check where it's height-2)
            for (int x = startX; x <= endX; x++) {
                for (int z = startZ; z <= endZ; z++) {
                    Block block = worldObj.getBlock(x,y,z);

                    if (y == startY) {      // Setup base
                        setIsPart(x,y,z,true);
                    } else if (y > startX && y < endY-1) {

                    }

                    if (isMultiTankBlock(block, x,y,z)) {
                        setIsPart(x,y,z,true);      // TODO: Optimise this with coordinate checking
                    }

                }
            }
        }

    }

    private boolean scanRingsXP(WidthScanResult widthScanResult, int depth, int height) {
        int width = widthScanResult.getNegativeCount() + widthScanResult.getPositiveCount() + 1;

        int ringBlocksCounter = 0;
        int emptyBlocksCounter = 0;
        int ringBlocksTarget = (((2*width) + (2*depth)) - 4) * (height - 2);
        int emptyBlocksTarget = ((width * depth) * (height - 2)) - ringBlocksTarget;

        int zCoordMin = zCoord - widthScanResult.getNegativeCount();
        int zCoordMax = zCoord + widthScanResult.getPositiveCount();

        boolean correctBlocks = true;

        boolean hasRings = false;
        boolean hasEmpty = false;

        // Sanity Check
        if (ringBlocksTarget > 0 && emptyBlocksTarget > 0) {

            for (int y = yCoord; y < (yCoord + height - 2); y++) {
                if (!correctBlocks) {
                    break;
                }
                for (int x = xCoord; x < xCoord + depth; x++) {
                    if (!correctBlocks) {
                        break;
                    }
                    for (int z = zCoordMin; z <= zCoordMax; z++) {
                        if ((x > xCoord) && (z > zCoordMin) && (x < xCoord + (depth - 1)) && (z < zCoordMax)) {
                            if (worldObj.isAirBlock(x,y,z)) {
                                emptyBlocksCounter++;
                            } else {
                                correctBlocks = false;
                                break;
                            }
                        } else {
                            Block block = worldObj.getBlock(x, y, z);

                            if (isMultiTankBlock(block, x, y, z)) {
                                ringBlocksCounter++;
                            } else {
                                correctBlocks = false;
                                break;
                            }
                        }
                    }
                }
            }
            hasRings = (ringBlocksCounter == ringBlocksTarget);
            hasEmpty = (emptyBlocksCounter == emptyBlocksTarget);
        }

        return hasRings && hasEmpty;
    }

    private boolean scanRingsXN(WidthScanResult widthScanResult, int depth, int height) {
        int width = widthScanResult.getNegativeCount() + widthScanResult.getPositiveCount() + 1;

        int ringBlocksCounter = 0;
        int emptyBlocksCounter = 0;
        int ringBlocksTarget = (((2*width) + (2*depth)) - 4) * (height - 2);
        int emptyBlocksTarget = ((width * depth) * (height - 2)) - ringBlocksTarget;

        int zCoordMin = zCoord - widthScanResult.getNegativeCount();
        int zCoordMax = zCoord + widthScanResult.getPositiveCount();

        boolean correctBlocks = true;

        boolean hasRings = false;
        boolean hasEmpty = false;

        // Sanity Check
        if (ringBlocksTarget > 0 && emptyBlocksTarget > 0) {

            for (int y = yCoord; y < (yCoord + height - 2); y++) {
                if (!correctBlocks) {
                    break;
                }
                for (int x = xCoord; x > xCoord - depth; x--) {
                    if (!correctBlocks) {
                        break;
                    }
                    for (int z = zCoordMin; z <= zCoordMax; z++) {
                        if ((x < xCoord) && (z > zCoordMin) && (x > xCoord - (depth - 1)) && (z < zCoordMax)) {
                            if (worldObj.isAirBlock(x,y,z)) {
                                emptyBlocksCounter++;
                            } else {
                                correctBlocks = false;
                                break;
                            }
                        } else {
                            Block block = worldObj.getBlock(x, y, z);

                            if (isMultiTankBlock(block, x, y, z)) {
                                ringBlocksCounter++;
                            } else {
                                correctBlocks = false;
                                break;
                            }
                        }
                    }
                }
            }
            hasRings = (ringBlocksCounter == ringBlocksTarget);
            hasEmpty = (emptyBlocksCounter == emptyBlocksTarget);
        }

        return hasRings && hasEmpty;
    }

    private boolean scanRingsZP(WidthScanResult widthScanResult, int depth, int height) {
        int width = widthScanResult.getNegativeCount() + widthScanResult.getPositiveCount() + 1;

        int ringBlocksCounter = 0;
        int emptyBlocksCounter = 0;
        int ringBlocksTarget = (((2*width) + (2*depth)) - 4) * (height - 2);
        int emptyBlocksTarget = ((width * depth) * (height - 2)) - ringBlocksTarget;

        int xCoordMin = xCoord - widthScanResult.getNegativeCount();
        int xCoordMax = xCoord + widthScanResult.getPositiveCount();

        boolean correctBlocks = true;

        boolean hasRings = false;
        boolean hasEmpty = false;

        // Sanity Check
        if (ringBlocksTarget > 0 && emptyBlocksTarget > 0) {

            for (int y = yCoord; y < (yCoord + height - 2); y++) {
                if (!correctBlocks) {
                    break;
                }
                for (int z = zCoord; z < zCoord + depth; z++) {
                    if (!correctBlocks) {
                        break;
                    }

                    for (int x = xCoordMin; x <= xCoordMax; x++) {
                        if ((z > zCoord) && (x > xCoordMin) && (z < zCoord + (depth - 1)) && (x < xCoordMax)) {
                            if (worldObj.isAirBlock(x,y,z)) {
                                emptyBlocksCounter++;
                            } else {
                                correctBlocks = false;
                                break;
                            }
                        } else {
                            Block block = worldObj.getBlock(x, y, z);

                            if (isMultiTankBlock(block, x, y, z)) {
                                ringBlocksCounter++;
                            } else {
                                correctBlocks = false;
                                break;
                            }
                        }
                    }
                }
            }
            hasRings = (ringBlocksCounter == ringBlocksTarget);
            hasEmpty = (emptyBlocksCounter == emptyBlocksTarget);
        }

        return hasRings && hasEmpty;
    }

    private boolean scanRingsZN(WidthScanResult widthScanResult, int depth, int height) {
        int width = widthScanResult.getNegativeCount() + widthScanResult.getPositiveCount() + 1;

        int ringBlocksCounter = 0;
        int emptyBlocksCounter = 0;
        int ringBlocksTarget = (((2*width) + (2*depth)) - 4) * (height - 2);
        int emptyBlocksTarget = ((width * depth) * (height - 2)) - ringBlocksTarget;

        int xCoordMin = xCoord - widthScanResult.getNegativeCount();
        int xCoordMax = xCoord + widthScanResult.getPositiveCount();

        boolean correctBlocks = true;

        boolean hasRings = false;
        boolean hasEmpty = false;

        // Sanity Check
        if (ringBlocksTarget > 0 && emptyBlocksTarget > 0) {

            for (int y = yCoord; y < (yCoord + height - 2); y++) {
                if (!correctBlocks) {
                    break;
                }
                for (int z = zCoord; z > zCoord - depth; z--) {
                    if(!correctBlocks) {
                        break;
                    }

                    for (int x = xCoordMin; x <= xCoordMax; x++) {
                        if ((z < zCoord) && (x > xCoordMin) && (z > zCoord - (depth - 1)) && (x < xCoordMax)) {
                            if (worldObj.isAirBlock(x,y,z)) {
                                emptyBlocksCounter++;
                            } else {
                                correctBlocks = false;
                                break;
                            }
                        } else {
                            Block block = worldObj.getBlock(x, y, z);

                            if (isMultiTankBlock(block, x, y, z)) {
                                ringBlocksCounter++;
                            } else {
                                correctBlocks = false;
                                break;
                            }
                        }
                    }
                }
            }
            hasRings = (ringBlocksCounter == ringBlocksTarget);
            hasEmpty = (emptyBlocksCounter == emptyBlocksTarget);
        }


        return hasRings && hasEmpty;
    }

    private boolean scanTopXP(WidthScanResult widthScanResult, int depthTarget, int height) {
        int wNegative = widthScanResult.getNegativeCount();
        int wPositive = widthScanResult.getPositiveCount();

        int depth = 0;

        int elev = yCoord + height - 2;

        for (int i = 0; true; i++) {
            int widthCounter = 0;
            for (int z = zCoord - wNegative; z <= zCoord + wPositive; z++) {
                int x  = xCoord + i;
                int y = elev;

                Block block = worldObj.getBlock(xCoord + i, elev, z);

                if(isMultiTankBlock(block, x, y, z)) {
                    widthCounter++;
                } else {
                    break;
                }
            }
            if (isCorrectWidth(widthCounter, wNegative, wPositive)) {
                depth++;
            } else {
                break;
            }
        }

        return depth == depthTarget;
    }

    private boolean scanTopXN(WidthScanResult widthScanResult, int depthTarget, int height) {
        int wNegative = widthScanResult.getNegativeCount();
        int wPositive = widthScanResult.getPositiveCount();

        int depth = 0;

        int elev = yCoord + height - 2;

        for (int i = 0; true; i++) {
            int widthCounter = 0;
            for (int z = zCoord - wNegative; z <= zCoord + wPositive; z++) {
                int x  = xCoord - i;
                int y = elev;

                Block block = worldObj.getBlock(xCoord - i, elev, z);

                if(isMultiTankBlock(block, x, y, z)) {
                    widthCounter++;
                } else {
                    break;
                }
            }

            if (isCorrectWidth(widthCounter, wNegative, wPositive)) {
                depth++;
            } else {
                break;
            }
        }

        return depth == depthTarget;
    }

    private boolean scanTopZP(WidthScanResult widthScanResult, int depthTarget, int height) {
        int wNegative = widthScanResult.getNegativeCount();
        int wPositive = widthScanResult.getPositiveCount();

        int depth = 0;

        int elev = yCoord + height - 2;


        for (int i = 0; true; i++) {
            int widthCounter = 0;

            for (int x = xCoord-wNegative; x <= xCoord+wPositive; x++) {
                int y = elev;
                int z = zCoord+i;
                Block block = worldObj.getBlock(x, elev, zCoord + i);

                if(isMultiTankBlock(block, x, y, z)) {
                    widthCounter++;
                } else {
                    break;
                }
            }

            if (isCorrectWidth(widthCounter, wNegative, wPositive)) {
                depth++;
            } else {
                break;
            }
        }

        return depth == depthTarget;
    }

    private boolean scanTopZN(WidthScanResult widthScanResult, int depthTarget, int height) {
        int wNegative = widthScanResult.getNegativeCount();
        int wPositive = widthScanResult.getPositiveCount();

        int depth = 0;

        int elev = yCoord + height - 2;

        for (int i = 0; true; i++) {
            int widthCounter = 0;

            for (int x = xCoord-wNegative; x <= xCoord+wPositive; x++) {
                int y = elev;
                int z = zCoord - i;

                Block block = worldObj.getBlock(x, elev, zCoord - i);

                if(isMultiTankBlock(block, x, y, z)) {
                    widthCounter++;
                } else {
                    break;
                }
            }

            if (isCorrectWidth(widthCounter, wNegative, wPositive)) {
                depth++;
            } else {
                break;
            }
        }

        return depth == depthTarget;
    }

    private class WidthScanResult {
        /** The width expands along the X axis */
        public static final int ORIENT_X=0;
        /** The width expands along the Z axis */
        public static final int ORIENT_Z=1;

        private int orientation;
        private int negativeCount;
        private int positiveCount;

        /**
         * Constructor
         * @param orientation Orientation identifier
         * @param negativeCount Block count in the negative direction
         * @param positiveCount Block count in the positive direction
         */
        public WidthScanResult(int orientation, int negativeCount, int positiveCount) {
            this.orientation = orientation;
            this.negativeCount = negativeCount;
            this.positiveCount = positiveCount;
        }

        /**
         * Returns the orientation
         * @return orientation
         */
        public int getOrientation() {
            return orientation;
        }

        /**
         * Sets orientation
         * @param orientation orientation
         */
        public void setOrientation(int orientation) {
            this.orientation = orientation;
        }

        public int getNegativeCount() {
            return negativeCount;
        }

        public void setNegativeCount(int negativeCount) {
            this.negativeCount = negativeCount;
        }

        public int getPositiveCount() {
            return positiveCount;
        }

        public void setPositiveCount(int positiveCount) {
            this.positiveCount = positiveCount;
        }
    }

    private class BaseScanResult {
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
        private int dept;

        public BaseScanResult(int orientation, int dept) {
            this.orientation = orientation;
            this.dept = dept;
        }

        public int getOrientation() {
            return orientation;
        }

        public void setOrientation(int orientation) {
            this.orientation = orientation;
        }

        public int getDept() {
            return dept;
        }

        public void setDept(int dept) {
            this.dept = dept;
        }

    }
}
