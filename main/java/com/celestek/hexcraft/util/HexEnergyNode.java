package com.celestek.hexcraft.util;

import com.celestek.hexcraft.block.BlockEnergyNodeCore;
import com.celestek.hexcraft.block.BlockHexoriumStructureCasing;
import com.celestek.hexcraft.block.IBlockHexEnergyPort;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.tileentity.ITileHexEnergyDrain;
import com.celestek.hexcraft.tileentity.ITileHexEnergyPort;
import com.celestek.hexcraft.tileentity.ITileHexEnergySource;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.7.0
 */

/**
 * A collection of utility methods used for Energy Node.
 */
public class HexEnergyNode {

    // Meta Bits
    public static final int META_MODE_0 = 2;
    public static final int META_MODE_1 = 3;

    // Port Energy Types
    public static final int PORT_TYPE_HEX = 0;
    public static final int PORT_TYPE_RF = 1;
    public static final int PORT_TYPE_EU = 2;

    // Port Modes
    public static final int PORT_MODE_INPUT = 0;
    public static final int PORT_MODE_OUTPUT = 1;
    public static final int PORT_MODE_INTERFACE = 2;
    public static final int PORT_MODE_TUNNEL = 3;

    /**
     * Sets up the Energy Node from a port.
     * @param side Side that the Manipulator was used on.
     * @param world World of the port.
     * @param x X coordinate of the port.
     * @param y Y coordinate of the port.
     * @param z Z coordinate of the port.
     * @return Whether the setup was successful.
     */
    public static boolean setupEnergyNode(int side, World world, int x, int y, int z) {

        // Locate the Energy Node Core.
        switch (side) {
            case 0: y++; break;
            case 1: y--; break;
            case 2: z++; break;
            case 3: z--; break;
            case 4: x++; break;
            case 5: x--; break;
        }

        if (world.getBlock(x, y, z) instanceof BlockEnergyNodeCore)
            // Check if the structure can be formed.
            if (checkEnergyNode(true, world, x, y, z)) {
                for (int i = y - 1; i <= y + 1; i++)
                    for (int j = x - 1; j <= x + 1; j++)
                        for (int k = z - 1; k <= z + 1; k++) {
                            HexUtils.setMetaBit(HexBlocks.META_STRUCTURE_IS_PART, true, HexUtils.META_NOTIFY_UPDATE, world, j, i, k);
                            if (world.getBlock(j, i, k) instanceof IBlockHexEnergyPort) {
                                ITileHexEnergyPort port = (ITileHexEnergyPort) world.getTileEntity(j, i, k);
                                port.setPortTier(parseTier(world.getBlock(x, y, z)));
                            }
                        }

                if (HexConfig.cfgGeneralNetworkDebug)
                    System.out.println("[Energy Node] (" + x + ", " + y + ", " + z + "): Energy Node formed, analyzing!");

                /* DO ANALYSIS */
                if (world.getBlock(x, y - 1, z) == HexBlocks.blockEnergyNodePortHEX
                        && HexUtils.getMetaBitBiInt(META_MODE_0, META_MODE_1, world, x, y - 1, z) != PORT_MODE_INTERFACE) {
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    analyzer.analyzeCable(world, x, y - 2, z, world.getBlock(x, y - 2, z));
                }

                if (world.getBlock(x, y + 1, z) == HexBlocks.blockEnergyNodePortHEX
                        && HexUtils.getMetaBitBiInt(META_MODE_0, META_MODE_1, world, x, y + 1, z) != PORT_MODE_INTERFACE) {
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    analyzer.analyzeCable(world, x, y + 2, z, world.getBlock(x, y + 2, z));
                }

                if (world.getBlock(x - 1, y, z) == HexBlocks.blockEnergyNodePortHEX
                        && HexUtils.getMetaBitBiInt(META_MODE_0, META_MODE_1, world, x - 1, y, z) != PORT_MODE_INTERFACE) {
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    analyzer.analyzeCable(world, x - 2, y, z, world.getBlock(x - 2, y, z));
                }

                if (world.getBlock(x + 1, y, z) == HexBlocks.blockEnergyNodePortHEX
                        && HexUtils.getMetaBitBiInt(META_MODE_0, META_MODE_1, world, x + 1, y, z) != PORT_MODE_INTERFACE) {
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    analyzer.analyzeCable(world, x + 2, y, z, world.getBlock(x + 2, y, z));
                }

                if (world.getBlock(x, y, z - 1) == HexBlocks.blockEnergyNodePortHEX
                        && HexUtils.getMetaBitBiInt(META_MODE_0, META_MODE_1, world, x, y, z - 1) != PORT_MODE_INTERFACE) {
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    analyzer.analyzeCable(world, x, y, z - 2, world.getBlock(x, y, z - 2));
                }

                if (world.getBlock(x, y, z + 1) == HexBlocks.blockEnergyNodePortHEX
                        && HexUtils.getMetaBitBiInt(META_MODE_0, META_MODE_1, world, x, y, z + 1) != PORT_MODE_INTERFACE) {
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    analyzer.analyzeCable(world, x, y, z + 2, world.getBlock(x, y, z + 2));
                }

                NetworkAnalyzer analyzer = new NetworkAnalyzer();
                analyzer.analyzeCable(world, x, y, z, world.getBlock(x, y, z));

                return true;
            }

        return false;
    }

    /**
     * Resets the Energy Node.
     * @param world World of the core.
     * @param x X coordinate of the core.
     * @param y Y coordinate of the core.
     * @param z Z coordinate of the core.
     */
    public static void resetEnergyNode(World world, int x, int y, int z) {
        for (int i = y - 1; i <= y + 1; i++)
            for (int j = x - 1; j <= x + 1; j++)
                for (int k = z - 1; k <= z + 1; k++)
                    HexUtils.setMetaBit(HexBlocks.META_STRUCTURE_IS_PART, false, HexUtils.META_NOTIFY_UPDATE, world, j, i, k);

        if (HexConfig.cfgGeneralNetworkDebug)
            System.out.println("[Energy Node] (" + x + ", " + y + ", " + z + "): Energy Node broken, analyzing!");

        /* DO ANALYSIS */
        Block block = world.getBlock(x, y - 1, z);
        if (block instanceof IBlockHexEnergyPort) {
            ITileHexEnergyPort port = (ITileHexEnergyPort) world.getTileEntity(x, y - 1, z);
            port.setPorts(null);
            port.emptyBuffer();
            if (block == HexBlocks.blockEnergyNodePortHEX) {
                ITileHexEnergySource source = (ITileHexEnergySource) world.getTileEntity(x, y - 1, z);
                source.setDrains(new ArrayList<HexDevice>());
                ITileHexEnergyDrain drain = (ITileHexEnergyDrain) world.getTileEntity(x, y - 1, z);
                drain.setSources(new ArrayList<HexDevice>());
                NetworkAnalyzer analyzer = new NetworkAnalyzer();
                analyzer.analyzeCable(world, x, y - 2, z, world.getBlock(x, y - 2, z));
            }
        }

        block = world.getBlock(x, y + 1, z);
        if (block instanceof IBlockHexEnergyPort) {
            ITileHexEnergyPort port = (ITileHexEnergyPort) world.getTileEntity(x, y + 1, z);
            port.setPorts(null);
            port.emptyBuffer();
            if (block == HexBlocks.blockEnergyNodePortHEX) {
                ITileHexEnergySource source = (ITileHexEnergySource) world.getTileEntity(x, y + 1, z);
                source.setDrains(new ArrayList<HexDevice>());
                ITileHexEnergyDrain drain = (ITileHexEnergyDrain) world.getTileEntity(x, y + 1, z);
                drain.setSources(new ArrayList<HexDevice>());
                NetworkAnalyzer analyzer = new NetworkAnalyzer();
                analyzer.analyzeCable(world, x, y + 2, z, world.getBlock(x, y + 2, z));
            }
        }

        block = world.getBlock(x - 1, y, z);
        if (block instanceof IBlockHexEnergyPort) {
            ITileHexEnergyPort port = (ITileHexEnergyPort) world.getTileEntity(x - 1, y, z);
            port.setPorts(null);
            port.emptyBuffer();
            if (block == HexBlocks.blockEnergyNodePortHEX) {
                ITileHexEnergySource source = (ITileHexEnergySource) world.getTileEntity(x - 1, y, z);
                source.setDrains(new ArrayList<HexDevice>());
                ITileHexEnergyDrain drain = (ITileHexEnergyDrain) world.getTileEntity(x - 1, y, z);
                drain.setSources(new ArrayList<HexDevice>());
                NetworkAnalyzer analyzer = new NetworkAnalyzer();
                analyzer.analyzeCable(world, x - 2, y, z, world.getBlock(x - 2, y, z));
            }
        }

        block = world.getBlock(x + 1, y, z);
        if (block instanceof IBlockHexEnergyPort) {
            ITileHexEnergyPort port = (ITileHexEnergyPort) world.getTileEntity(x + 1, y, z);
            port.setPorts(null);
            port.emptyBuffer();
            if (block == HexBlocks.blockEnergyNodePortHEX) {
                ITileHexEnergySource source = (ITileHexEnergySource) world.getTileEntity(x + 1, y, z);
                source.setDrains(new ArrayList<HexDevice>());
                ITileHexEnergyDrain drain = (ITileHexEnergyDrain) world.getTileEntity(x + 1, y, z);
                drain.setSources(new ArrayList<HexDevice>());
                NetworkAnalyzer analyzer = new NetworkAnalyzer();
                analyzer.analyzeCable(world, x + 2, y, z, world.getBlock(x + 2, y, z));
            }
        }

        block = world.getBlock(x, y, z - 1);
        if (block instanceof IBlockHexEnergyPort) {
            ITileHexEnergyPort port = (ITileHexEnergyPort) world.getTileEntity(x, y, z - 1);
            port.setPorts(null);
            port.emptyBuffer();
            if (block == HexBlocks.blockEnergyNodePortHEX) {
                ITileHexEnergySource source = (ITileHexEnergySource) world.getTileEntity(x, y, z - 1);
                source.setDrains(new ArrayList<HexDevice>());
                ITileHexEnergyDrain drain = (ITileHexEnergyDrain) world.getTileEntity(x, y, z - 1);
                drain.setSources(new ArrayList<HexDevice>());
                NetworkAnalyzer analyzer = new NetworkAnalyzer();
                analyzer.analyzeCable(world, x, y, z - 2, world.getBlock(x, y, z - 2));
            }
        }

        block = world.getBlock(x, y, z + 1);
        if (block instanceof IBlockHexEnergyPort) {
            ITileHexEnergyPort port = (ITileHexEnergyPort) world.getTileEntity(x, y, z + 1);
            port.setPorts(null);
            port.emptyBuffer();
            if (block == HexBlocks.blockEnergyNodePortHEX) {
                ITileHexEnergySource source = (ITileHexEnergySource) world.getTileEntity(x, y, z + 1);
                source.setDrains(new ArrayList<HexDevice>());
                ITileHexEnergyDrain drain = (ITileHexEnergyDrain) world.getTileEntity(x, y, z + 1);
                drain.setSources(new ArrayList<HexDevice>());
                NetworkAnalyzer analyzer = new NetworkAnalyzer();
                analyzer.analyzeCable(world, x, y, z + 2, world.getBlock(x, y, z + 2));
            }
        }
    }

    /**
     * Checks if the structure of the Energy Node is correct.
     * @param checkPart Makes the method check if blocks are already part of a structure.
     * @param world World of the core.
     * @param x X coordinate of the core.
     * @param y Y coordinate of the core.
     * @param z Z coordinate of the core.
     * @return Whether the structure is correct.
     */
    public static boolean checkEnergyNode(boolean checkPart, World world, int x, int y, int z) {
        // Make sure that all casing blocks are of the same color.
        Block block;
        if (world.getBlock(x - 1, y - 1, z - 1) instanceof BlockHexoriumStructureCasing)
            block = world.getBlock(x - 1, y - 1, z - 1);
        else
            return false;

        for (int i = y - 1; i <= y + 1; i++)
            for (int j = x - 1; j <= x + 1; j++)
                for (int k = z - 1; k <= z + 1; k++) {
                    // Situations when the block is not one of the center faces, or center.
                    if (!((k == z && j == x && (i == y + 1 || i == y - 1))
                            || (i == y && j == x && (k == z + 1 || k == z - 1))
                            || (i == y && k == z && (j == x + 1 || j == x - 1))
                            || (k == z && j == x && i == y))) {
                        System.out.println("Checking edge block: " + j + ", " + i + ", " + k);
                        if (checkPart && HexUtils.getMetaBit(HexBlocks.META_STRUCTURE_IS_PART, world, j, i, k))
                            return false;
                        else if (!(world.getBlock(j, i, k) == block))
                            return false;
                    }
                    // Situation when the block is center.
                    else if (k == z && j == x && i == y) {
                        System.out.println("Checking middle block: " + j + ", " + i + ", " + k);
                        if (checkPart && HexUtils.getMetaBit(HexBlocks.META_STRUCTURE_IS_PART, world, j, i, k))
                            return false;
                        else if (!(world.getBlock(j, i, k) instanceof BlockEnergyNodeCore))
                            return false;
                    }
                    // Situations when the block is one of the center faces.
                    else {
                        System.out.println("Checking face block: " + j + ", " + i + ", " + k);
                        if (checkPart && HexUtils.getMetaBit(HexBlocks.META_STRUCTURE_IS_PART, world, j, i, k))
                            return false;
                        else if (!(world.getBlock(j, i, k) instanceof IBlockHexEnergyPort || world.getBlock(j, i, k) == block))
                            return false;
                    }
                }

        return true;
    }

    /**
     * Parses the core type and returns an int of the tier.
     * @param block Core block to parse.
     * @return Integer tier of the core.
     */
    private static int parseTier(Block block) {
        if(block == HexBlocks.blockEnergyNodeCoreT1)
            return 0;
        else if(block == HexBlocks.blockEnergyNodeCoreT2)
            return 1;
        else if(block == HexBlocks.blockEnergyNodeCoreT3)
            return 2;
        else if(block == HexBlocks.blockEnergyNodeCoreT4)
            return 3;

        return 0;
    }

    /**
     * Parses the port tier to get efficiency.
     * @param tier Tier of the port.
     * @return Float percentage of efficiency.
     */
    public static float parseEfficiency(int tier) {
        if(tier == 0)
            return (float) HexConfig.cfgEnergyConversionEfficiencyTier1 / 100;
        else if(tier == 1)
            return (float) HexConfig.cfgEnergyConversionEfficiencyTier2 / 100;
        else if(tier == 2)
            return (float) HexConfig.cfgEnergyConversionEfficiencyTier3 / 100;
        else if(tier == 3)
            return (float) HexConfig.cfgEnergyConversionEfficiencyTier4 / 100;

        return 0;
    }

    /**
     * Parses the both port tiers to get efficiency multiplier.
     * @param tierIn Tier of the input port.
     * @param tierOut Tier of the output port.
     * @return Float efficiency multiplier.
     */
    public static float parseEfficiencyMultiplier(int tierIn, int tierOut) {
        return (parseEfficiency(tierIn) + parseEfficiency(tierOut)) / 2;
    }

    /**
     * Parses the both port types to get conversion multiplier.
     * @param typeIn Type of the input port.
     * @param typeOut Type of the output port.
     * @return Float conversion multiplier.
     */
    public static float parseConversionMultiplier(int typeIn, int typeOut) {
        if (typeIn == typeOut)
            return 1;
        else {
            if (typeIn == PORT_TYPE_HEX) {
                if (typeOut == PORT_TYPE_RF)
                    return HexConfig.cfgEnergyConversionRatioHEXtoRF;
                if (typeOut == PORT_TYPE_EU)
                    return HexConfig.cfgEnergyConversionRatioHEXtoEU;
            }
            else if (typeIn == PORT_TYPE_RF) {
                if (typeOut == PORT_TYPE_HEX)
                    return HexConfig.cfgEnergyConversionRatioRFtoHEX;
                if (typeOut == PORT_TYPE_EU)
                    return HexConfig.cfgEnergyConversionRatioRFtoEU;
            }
            else if (typeIn == PORT_TYPE_EU) {
                if (typeOut == PORT_TYPE_HEX)
                    return HexConfig.cfgEnergyConversionRatioEUtoHEX;
                if (typeOut == PORT_TYPE_RF)
                    return HexConfig.cfgEnergyConversionRatioEUtoRF;
            }
        }

        return 0;
    }

    /**
     * Parses the port type and tier to get energy per tick for that port.
     * @param type Type of the port.
     * @param tier Tier of the port.
     * @return Float energy per tick.
     */
    public static float parseEnergyPerTick(int type, int tier) {
        if(type == PORT_TYPE_HEX)
            switch (tier) {
                case 0: return 64;
                case 1: return 256;
                case 2: return 1024;
                case 3: return 4096;
            }
        else if(type == PORT_TYPE_RF)
            switch (tier) {
                case 0: return 200;
                case 1: return 800;
                case 2: return 8000;
                case 3: return 32000;
            }
        else if(type == PORT_TYPE_EU)
            switch (tier) {
                case 0: return 32;
                case 1: return 128;
                case 2: return 512;
                case 3: return 2048;
            }

        return 0;
    }
}
