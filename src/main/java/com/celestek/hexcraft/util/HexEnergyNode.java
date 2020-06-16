package com.celestek.hexcraft.util;

import com.celestek.hexcraft.block.*;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.compat.HexEU;
import com.celestek.hexcraft.tileentity.ITileHexEnergyDrain;
import com.celestek.hexcraft.tileentity.ITileHexEnergyPort;
import com.celestek.hexcraft.tileentity.ITileHexEnergySource;
import ic2.api.energy.EnergyNet;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

import java.util.ArrayList;

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
    public static final int PORT_TYPE_LU = 3;

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
                int tier = parseTier(world.getBlock(x, y, z));
                int efficiency = 0;

                // Get the efficiency.
                for (int i = y - 1; i <= y + 1; i++)
                    for (int j = x - 1; j <= x + 1; j++)
                        for (int k = z - 1; k <= z + 1; k++) {
                            if (world.getBlock(j, i, k) instanceof BlockConversionComputer) {
                                BlockConversionComputer computer = (BlockConversionComputer) world.getBlock(j, i, k);
                                if (computer.getEfficiency() > efficiency)
                                    efficiency = computer.getEfficiency();
                            }
                        }

                // Setup ports.
                for (int i = y - 1; i <= y + 1; i++)
                    for (int j = x - 1; j <= x + 1; j++)
                        for (int k = z - 1; k <= z + 1; k++) {
                            HexUtils.setMetaBit(HexBlocks.META_STRUCTURE_IS_PART, true, HexUtils.META_NOTIFY_UPDATE, world, j, i, k);
                            if (world.getBlock(j, i, k) instanceof IBlockHexEnergyPort) {
                                ITileHexEnergyPort port = (ITileHexEnergyPort) world.getTileEntity(j, i, k);
                                port.setupPort(tier, efficiency);
                            }
                        }

                if (HexConfig.cfgGeneralNetworkDebug)
                    System.out.println("[Energy Node] (" + x + ", " + y + ", " + z + "): Energy Node formed, analyzing!");

                /* DO ANALYSIS */
                if (world.getBlock(x, y - 1, z) instanceof BlockEnergyNodePortHEX
                        && HexUtils.getMetaBitBiInt(META_MODE_0, META_MODE_1, world, x, y - 1, z) != PORT_MODE_INTERFACE) {
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    analyzer.analyzeCable(world, x, y - 2, z, world.getBlock(x, y - 2, z));
                }

                if (world.getBlock(x, y + 1, z) instanceof BlockEnergyNodePortHEX
                        && HexUtils.getMetaBitBiInt(META_MODE_0, META_MODE_1, world, x, y + 1, z) != PORT_MODE_INTERFACE) {
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    analyzer.analyzeCable(world, x, y + 2, z, world.getBlock(x, y + 2, z));
                }

                if (world.getBlock(x - 1, y, z) instanceof BlockEnergyNodePortHEX
                        && HexUtils.getMetaBitBiInt(META_MODE_0, META_MODE_1, world, x - 1, y, z) != PORT_MODE_INTERFACE) {
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    analyzer.analyzeCable(world, x - 2, y, z, world.getBlock(x - 2, y, z));
                }

                if (world.getBlock(x + 1, y, z) instanceof BlockEnergyNodePortHEX
                        && HexUtils.getMetaBitBiInt(META_MODE_0, META_MODE_1, world, x + 1, y, z) != PORT_MODE_INTERFACE) {
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    analyzer.analyzeCable(world, x + 2, y, z, world.getBlock(x + 2, y, z));
                }

                if (world.getBlock(x, y, z - 1) instanceof BlockEnergyNodePortHEX
                        && HexUtils.getMetaBitBiInt(META_MODE_0, META_MODE_1, world, x, y, z - 1) != PORT_MODE_INTERFACE) {
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    analyzer.analyzeCable(world, x, y, z - 2, world.getBlock(x, y, z - 2));
                }

                if (world.getBlock(x, y, z + 1) instanceof BlockEnergyNodePortHEX
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
            if (block instanceof BlockEnergyNodePortHEX) {
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
            if (block instanceof BlockEnergyNodePortHEX) {
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
            if (block instanceof BlockEnergyNodePortHEX) {
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
            if (block instanceof BlockEnergyNodePortHEX) {
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
            if (block instanceof BlockEnergyNodePortHEX) {
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
            if (block instanceof BlockEnergyNodePortHEX) {
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
                    Block currBlock = world.getBlock(j, i, k);
                    boolean isPart = HexUtils.getMetaBit(HexBlocks.META_STRUCTURE_IS_PART, world, j, i, k);
                    // Situations when the block is not one of the center faces, or center.
                    if (!((k == z && j == x && (i == y + 1 || i == y - 1))
                            || (i == y && j == x && (k == z + 1 || k == z - 1))
                            || (i == y && k == z && (j == x + 1 || j == x - 1))
                            || (k == z && j == x && i == y))) {
                        if (HexConfig.cfgEnergyNodeVerboseDebug && HexConfig.cfgEnergyNodeDebug)
                            System.out.println("Checking edge block: " + j + ", " + i + ", " + k);
                        if (checkPart && isPart)
                            return false;
                        else if (!(currBlock == block))
                            return false;
                    }
                    // Situation when the block is center.
                    else if (k == z && j == x && i == y) {
                        if (HexConfig.cfgEnergyNodeVerboseDebug && HexConfig.cfgEnergyNodeDebug)
                            System.out.println("Checking middle block: " + j + ", " + i + ", " + k);
                        if (checkPart && isPart)
                            return false;
                        else if (!(currBlock instanceof BlockEnergyNodeCore))
                            return false;
                    }
                    // Situations when the block is one of the center faces.
                    else {
                        if (HexConfig.cfgEnergyNodeVerboseDebug && HexConfig.cfgEnergyNodeDebug)
                            System.out.println("Checking face block: " + j + ", " + i + ", " + k);
                        if (checkPart && isPart)
                            return false;
                        else if (!(currBlock instanceof IBlockHexEnergyPort || currBlock instanceof BlockConversionComputer || currBlock == block))
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
        if (block instanceof BlockEnergyNodeCore)
            return ((BlockEnergyNodeCore) block).getTier().ordinal();
        else
            return 0;
    }

    /**
     * Parses the port tier to get efficiency.
     * @param efficiency Tier of efficiency.
     * @return Float percentage of efficiency.
     */
    public static float parseEfficiency(int efficiency) {
        if(efficiency == 0)
            return (float) HexConfig.cfgEnergyConversionEfficiencyNone / 100;
        else if(efficiency == 1)
            return (float) HexConfig.cfgEnergyConversionEfficiencyBasic / 100;
        else if(efficiency == 2)
            return (float) HexConfig.cfgEnergyConversionEfficiencyAdvanced / 100;

        return 0;
    }

    /**
     * Parses the both port tiers to get efficiency multiplier.
     * @param efficiencyIn Tier of the input port.
     * @param efficiencyOut Tier of the output port.
     * @return Float efficiency multiplier.
     */
    public static float parseEfficiencyMultiplier(int efficiencyIn, int efficiencyOut) {
        return (parseEfficiency(efficiencyIn) + parseEfficiency(efficiencyOut)) / 2;
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
                if (typeOut == PORT_TYPE_LU)
                    return HexConfig.cfgEnergyConversionRatioHEXtoLU;
            }
            else if (typeIn == PORT_TYPE_RF) {
                if (typeOut == PORT_TYPE_HEX)
                    return HexConfig.cfgEnergyConversionRatioRFtoHEX;
                if (typeOut == PORT_TYPE_EU)
                    return HexConfig.cfgEnergyConversionRatioRFtoEU;
                if (typeOut == PORT_TYPE_LU)
                    return HexConfig.cfgEnergyConversionRatioRFtoLU;
            }
            else if (typeIn == PORT_TYPE_EU) {
                if (typeOut == PORT_TYPE_HEX)
                    return HexConfig.cfgEnergyConversionRatioEUtoHEX;
                if (typeOut == PORT_TYPE_RF)
                    return HexConfig.cfgEnergyConversionRatioEUtoRF;
                if (typeOut == PORT_TYPE_LU)
                    return HexConfig.cfgEnergyConversionRatioEUtoLU;
            }
            else if (typeIn == PORT_TYPE_LU) {
                if (typeOut == PORT_TYPE_HEX)
                    return HexConfig.cfgEnergyConversionRatioLUtoHEX;
                if (typeOut == PORT_TYPE_RF)
                    return HexConfig.cfgEnergyConversionRatioLUtoRF;
                if (typeOut == PORT_TYPE_EU)
                    return HexConfig.cfgEnergyConversionRatioLUtoEU;
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
                case 0: return HexConfig.cfgEnergyTransferTier1HEX;
                case 1: return HexConfig.cfgEnergyTransferTier2HEX;
                case 2: return HexConfig.cfgEnergyTransferTier3HEX;
                case 3: return HexConfig.cfgEnergyTransferTier4HEX;
            }
        else if(type == PORT_TYPE_RF)
            switch (tier) {
                case 0: return HexConfig.cfgEnergyTransferTier1RF;
                case 1: return HexConfig.cfgEnergyTransferTier2RF;
                case 2: return HexConfig.cfgEnergyTransferTier3RF;
                case 3: return HexConfig.cfgEnergyTransferTier4RF;
            }
        else if(type == PORT_TYPE_EU) {
            switch (tier) {
                case 0: return HexEU.getTierPower(HexConfig.cfgEnergyTransferTier1EU);
                case 1: return HexEU.getTierPower(HexConfig.cfgEnergyTransferTier2EU);
                case 2: return HexEU.getTierPower(HexConfig.cfgEnergyTransferTier3EU);
                case 3: return HexEU.getTierPower(HexConfig.cfgEnergyTransferTier4EU);
            }
        }
        else if(type == PORT_TYPE_LU)
            switch (tier) {
                case 0: return HexConfig.cfgEnergyTransferTier1LU;
                case 1: return HexConfig.cfgEnergyTransferTier2LU;
                case 2: return HexConfig.cfgEnergyTransferTier3LU;
                case 3: return HexConfig.cfgEnergyTransferTier4LU;
            }

        return 0;
    }

    /**
     * Displays universal info of an Energy Node port to chat.
     * @param player The player.
     * @param energyPorts List of all available Energy Node Ports.
     * @param linkedPort Actual linked port.
     * @param worldObj World.
     * @param xCoord X location.
     * @param yCoord Y location.
     * @param zCoord Z location.
     * @param portType Type of the port.
     * @param portTier Tier of the port.
     * @param portEfficiency Efficiency of the port.
     * @param energyBufferFilled Energy stored in buffer.
     * @param energyBufferTotal Total buffer size.
     */
    public static void displayInfoPort(String energy, EntityPlayer player, ArrayList<HexDevice> energyPorts, HexDevice linkedPort, World worldObj, int xCoord, int yCoord, int zCoord, int portType, int portTier, int portEfficiency, float energyBufferFilled, float energyBufferTotal) {
        HexUtils.addChatProbeTitle(player);
        // If player is not sneaking.
        if (!player.isSneaking()) {
            HexUtils.addChatProbeGenericInfo(player, worldObj, xCoord, yCoord, zCoord);
            player.addChatMessage(new ChatComponentTranslation("msg.probeTypePort.txt"));
            boolean isPart = HexUtils.getMetaBit(HexBlocks.META_STRUCTURE_IS_PART, worldObj, xCoord, yCoord, zCoord);
            if (isPart) {
                int mode = HexUtils.getMetaBitBiInt(HexEnergyNode.META_MODE_0, HexEnergyNode.META_MODE_1, worldObj, xCoord, yCoord, zCoord);
                float efficiency = HexEnergyNode.parseEfficiency(portEfficiency)*100;
                player.addChatMessage(new ChatComponentTranslation("msg.probeFormedYes.txt"));
                player.addChatMessage(new ChatComponentTranslation("msg.probeTier.txt", (portTier + 1)));
                if (mode == 0 || mode == 1)
                    player.addChatMessage(new ChatComponentTranslation("msg.probePortMode" + (mode + 1) + ".txt", Math.round(HexEnergyNode.parseEnergyPerTick(portType, portTier)), energy));
                else
                    player.addChatMessage(new ChatComponentTranslation("msg.probePortMode" + (mode + 1) + ".txt"));
                if (linkedPort != null) {
                    ITileHexEnergyPort port = (ITileHexEnergyPort) worldObj.getTileEntity(linkedPort.x, linkedPort.y, linkedPort.z);
                    player.addChatMessage(new ChatComponentTranslation("msg.probeEfficiencyLinked.txt", Math.round(efficiency), (efficiency + HexEnergyNode.parseEfficiency(port.getPortEfficiency())*100) / 2));
                }
                else
                    player.addChatMessage(new ChatComponentTranslation("msg.probeEfficiency.txt", Math.round(efficiency)));
                player.addChatMessage(new ChatComponentTranslation("msg.probeEnergy.txt",  Math.round(energyBufferFilled), energy, Math.round(energyBufferTotal), energy));
            }
            else {
                player.addChatMessage(new ChatComponentTranslation("msg.probeFormedNo.txt"));
            }
            if (linkedPort != null) {
                player.addChatMessage(new ChatComponentTranslation("msg.probeLinkedYes.txt"));
                player.addChatMessage(new ChatComponentTranslation("msg.probeConnectedEntry.txt", linkedPort.x, linkedPort.y, linkedPort.z,
                        worldObj.getBlock(linkedPort.x, linkedPort.y, linkedPort.z).getLocalizedName()));
            }
            else {
                player.addChatMessage(new ChatComponentTranslation("msg.probeLinkedNo.txt"));
            }
        }
        // If player is sneaking.
        else {
            player.addChatMessage(new ChatComponentTranslation("msg.probeConnectedPorts.txt"));
            HexUtils.addChatProbeConnectedMachines(player, energyPorts, worldObj, xCoord, yCoord, zCoord);
        }
    }
}
