package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.tileentity.ITileHexEnergyPort;
import com.celestek.hexcraft.util.HexUtils;
import com.celestek.hexcraft.util.NetworkAnalyzer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.7.0
 */

public class BlockEnergyNodeCore extends HexBlock implements IBlockHexNode {

    // Block ID
    public static final String ID = "blockEnergyNodeCore";

    // Meta Bits
    public static final int META_MODE_0 = 2; // These are set on the ports, rather than this block.
    public static final int META_MODE_1 = 3; // These are set on the ports, rather than this block.

    /// Used later for texture identification.
    private String blockName;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block.
     */
    public BlockEnergyNodeCore(String blockName) {
        super(Material.iron);

        // Load the constructor parameters.
        this.blockName = blockName;

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.tabMachines);

        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(5F);
        this.setResistance(10F);

        this.setStepSound(Block.soundTypeMetal);
    }

    // Prepare the icons.
    @SideOnly(Side.CLIENT)
    private IIcon icon[];

    /**
     * Registers the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        // Initialize the icons.
        icon = new IIcon[2];
        // Load the outer textures.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + blockName);
        // Load the inner texture.
        icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glowRainbow");
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        // Retrieve icon based on side.
        if (side < 6)
            return icon[0];
        else
            return icon[1];
    }

    /**
     * Sets up the Energy Node.
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
                            Block block = world.getBlock(j, i, k);
                            if (block == HexBlocks.blockEnergyNodePortHEX
                                    || block == HexBlocks.blockEnergyNodePortRF
                                    || block == HexBlocks.blockEnergyNodePortEU) {
                                TileEntity tileEntity = world.getTileEntity(j, i, k);
                                if (tileEntity instanceof ITileHexEnergyPort) { //TODO: Clean this up.
                                    ITileHexEnergyPort port = (ITileHexEnergyPort) tileEntity;
                                    port.setCoreTier(world.getBlock(x, y, z));
                                }
                            }
                        }

                if (HexConfig.cfgGeneralNetworkDebug)
                    System.out.println("[Energy Node] (" + x + ", " + y + ", " + z + "): Energy Node formed, analyzing!");

                if (world.getBlock(x, y - 1, z) == HexBlocks.blockEnergyNodePortHEX
                        && HexUtils.getMetaBitBiInt(META_MODE_0, META_MODE_1, world, x, y - 1, z) == 2) {
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    analyzer.analyzeCable(world, x, y - 2, z, world.getBlock(x, y - 2, z));
                }

                if (world.getBlock(x, y + 1, z) == HexBlocks.blockEnergyNodePortHEX
                        && HexUtils.getMetaBitBiInt(META_MODE_0, META_MODE_1, world, x, y + 1, z) == 2) {
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    analyzer.analyzeCable(world, x, y + 2, z, world.getBlock(x, y + 2, z));
                }

                if (world.getBlock(x - 1, y, z) == HexBlocks.blockEnergyNodePortHEX
                        && HexUtils.getMetaBitBiInt(META_MODE_0, META_MODE_1, world, x - 1, y, z) == 2) {
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    analyzer.analyzeCable(world, x - 2, y, z, world.getBlock(x - 2, y, z));
                }

                if (world.getBlock(x + 1, y, z) == HexBlocks.blockEnergyNodePortHEX
                        && HexUtils.getMetaBitBiInt(META_MODE_0, META_MODE_1, world, x + 1, y, z) == 2) {
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    analyzer.analyzeCable(world, x + 2, y, z, world.getBlock(x + 2, y, z));
                }

                if (world.getBlock(x, y, z - 1) == HexBlocks.blockEnergyNodePortHEX
                        && HexUtils.getMetaBitBiInt(META_MODE_0, META_MODE_1, world, x, y, z - 1) == 2) {
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    analyzer.analyzeCable(world, x, y, z - 2, world.getBlock(x, y, z - 2));
                }

                if (world.getBlock(x, y, z + 1) == HexBlocks.blockEnergyNodePortHEX
                        && HexUtils.getMetaBitBiInt(META_MODE_0, META_MODE_1, world, x, y, z + 1) == 2) {
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
     */
    public static void resetEnergyNode(World world, int x, int y, int z) {
        for (int i = y - 1; i <= y + 1; i++)
            for (int j = x - 1; j <= x + 1; j++)
                for (int k = z - 1; k <= z + 1; k++)
                    HexUtils.setMetaBit(HexBlocks.META_STRUCTURE_IS_PART, false, HexUtils.META_NOTIFY_UPDATE, world, j, i, k);

        if (HexConfig.cfgGeneralNetworkDebug)
            System.out.println("[Energy Node] (" + x + ", " + y + ", " + z + "): Energy Node broken, analyzing!");
        
        //TODO: Clean this up.
        Block block = world.getBlock(x, y - 1, z);
        if (block instanceof IBlockHexEnergyPort) {
            TileEntity tileEntity = world.getTileEntity(x, y - 1, z);
            if (tileEntity instanceof ITileHexEnergyPort) {
                ITileHexEnergyPort port = (ITileHexEnergyPort) tileEntity;
                port.setPorts(null);
                if (block == HexBlocks.blockEnergyNodePortHEX) {
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    analyzer.analyzeCable(world, x, y - 2, z, world.getBlock(x, y - 2, z));
                }
            }
        }

        block = world.getBlock(x, y + 1, z);
        if (block instanceof IBlockHexEnergyPort) {
            TileEntity tileEntity = world.getTileEntity(x, y + 1, z);
            if (tileEntity instanceof ITileHexEnergyPort) {
                ITileHexEnergyPort port = (ITileHexEnergyPort) tileEntity;
                port.setPorts(null);
                if (block == HexBlocks.blockEnergyNodePortHEX) {
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    analyzer.analyzeCable(world, x, y + 2, z, world.getBlock(x, y + 2, z));
                }
            }
        }

        block = world.getBlock(x - 1, y, z);
        if (block instanceof IBlockHexEnergyPort) {
            TileEntity tileEntity = world.getTileEntity(x - 1, y, z);
            if (tileEntity instanceof ITileHexEnergyPort) {
                ITileHexEnergyPort port = (ITileHexEnergyPort) tileEntity;
                port.setPorts(null);
                if (block == HexBlocks.blockEnergyNodePortHEX) {
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    analyzer.analyzeCable(world, x - 2, y, z, world.getBlock(x - 2, y, z));
                }
            }
        }

        block = world.getBlock(x + 1, y, z);
        if (block instanceof IBlockHexEnergyPort) {
            TileEntity tileEntity = world.getTileEntity(x + 1, y, z);
            if (tileEntity instanceof ITileHexEnergyPort) {
                ITileHexEnergyPort port = (ITileHexEnergyPort) tileEntity;
                port.setPorts(null);
                if (block == HexBlocks.blockEnergyNodePortHEX) {
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    analyzer.analyzeCable(world, x + 2, y, z, world.getBlock(x + 2, y, z));
                }
            }
        }

        block = world.getBlock(x, y, z - 1);
        if (block instanceof IBlockHexEnergyPort) {
            TileEntity tileEntity = world.getTileEntity(x, y, z - 1);
            if (tileEntity instanceof ITileHexEnergyPort) {
                ITileHexEnergyPort port = (ITileHexEnergyPort) tileEntity;
                port.setPorts(null);
                if (block == HexBlocks.blockEnergyNodePortHEX) {
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    analyzer.analyzeCable(world, x, y, z - 2, world.getBlock(x, y, z - 2));
                }
            }
        }

        block = world.getBlock(x, y, z + 1);
        if (block instanceof IBlockHexEnergyPort) {
            TileEntity tileEntity = world.getTileEntity(x, y, z + 1);
            if (tileEntity instanceof ITileHexEnergyPort) {
                ITileHexEnergyPort port = (ITileHexEnergyPort) tileEntity;
                port.setPorts(null);
                if (block == HexBlocks.blockEnergyNodePortHEX) {
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    analyzer.analyzeCable(world, x, y, z + 2, world.getBlock(x, y, z + 2));
                }
            }
        }
    }

    /**
     * Checks if the Energy Node can be formed.
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
                        else
                            if (!(world.getBlock(j, i, k) == block))
                                return false;
                    }
                    // Situation when the block is center.
                    else if (k == z && j == x && i == y) {
                        System.out.println("Checking middle block: " + j + ", " + i + ", " + k);
                        if (checkPart && HexUtils.getMetaBit(HexBlocks.META_STRUCTURE_IS_PART, world, j, i, k))
                            return false;
                        else
                            if (!(world.getBlock(j, i, k) instanceof BlockEnergyNodeCore))
                                    return false;
                    }
                    // Situations when the block is one of the center faces.
                    else {
                        System.out.println("Checking face block: " + j + ", " + i + ", " + k);
                        if (checkPart && HexUtils.getMetaBit(HexBlocks.META_STRUCTURE_IS_PART, world, j, i, k))
                            return false;
                        else
                            if (!(world.getBlock(j, i, k) instanceof IBlockHexEnergyPort || world.getBlock(j, i, k) == block))
                                    return false;
                    }
                }

        return true;
    }
}
