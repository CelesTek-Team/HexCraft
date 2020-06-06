package com.celestek.hexcraft.item;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.*;
import com.celestek.hexcraft.init.HexAchievements;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.tileentity.*;
import com.celestek.hexcraft.util.HexUtils;
import com.celestek.hexcraft.util.NetworkAnalyzer;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class ItemHexoriumProbe extends Item {

    // Item ID
    public static final String ID = "toolHexoriumProbe";

    /**
     * Constructor for the item.
     * @param itemName Unlocalized name for the item.
     */
    public ItemHexoriumProbe(String itemName) {
        setUnlocalizedName(itemName);
        setCreativeTab(HexCraft.tabMachines);
        setTextureName(HexCraft.MODID + ":" + itemName);
        setMaxStackSize(1);
    }

    /**
     * This is called when the item is used, before the block is activated.
     * @param stack The Item Stack
     * @param player The Player that used the item
     * @param world The Current World
     * @param x Target X Position
     * @param y Target Y Position
     * @param z Target Z Position
     * @param side The side of the target hit
     * @return Return true to prevent any further processing.
     */
    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            Block block = world.getBlock(x, y, z);

            // Display Port info.
            if (block instanceof IBlockHexEnergyPort) {
                ITileHexEnergyPort port = (ITileHexEnergyPort) world.getTileEntity(x, y, z);
                port.displayInfoPort(player);

                if (HexConfig.cfgGeneralUseAchievements)
                    player.addStat(HexAchievements.achUseProbeMachine, 1);
            }

            // Display Source info.
            else if (block instanceof IBlockHexEnergySource) {
                ITileHexEnergySource source = (ITileHexEnergySource) world.getTileEntity(x, y, z);
                source.displayInfoSource(player);

                if (HexConfig.cfgGeneralUseAchievements)
                    player.addStat(HexAchievements.achUseProbeMachine, 1);
            }

            // Display Drain info.
            else if (block instanceof IBlockHexEnergyDrain) {
                ITileHexEnergyDrain drain = (ITileHexEnergyDrain) world.getTileEntity(x, y, z);
                drain.displayInfoDrain(player);

                if (HexConfig.cfgGeneralUseAchievements)
                    player.addStat(HexAchievements.achUseProbeMachine, 1);
            }

            // Display Pylon info.
            else if (block instanceof BlockEnergyPylon) {
                TileEnergyPylon pylon = (TileEnergyPylon) world.getTileEntity(x, y, z);
                pylon.displayInfoPylon(player);

                if (HexConfig.cfgGeneralUseAchievements)
                    player.addStat(HexAchievements.achUseProbeMachine, 1);
            }

            // Display Valve info.
            else if (block instanceof BlockTankValve) {
                TileTankValve valve = (TileTankValve) world.getTileEntity(x, y, z);
                valve.displayInfoValve(player);
            }

            // Display Pressure Plate info.
            else if (block instanceof BlockHexoriumPressurePlate) {
                if (!player.isSneaking()) {
                    HexUtils.addChatProbeTitle(player);
                    HexUtils.addChatProbeGenericInfo(player, world, x, y, z);
                    player.addChatMessage(new ChatComponentTranslation("msg.probeTypePressure.txt"));
                    int mode = HexUtils.getMetaBitBiInt(BlockHexoriumPressurePlate.META_SETTING_0, BlockHexoriumPressurePlate.META_SETTING_1, world, x, y, z);
                    player.addChatMessage(new ChatComponentTranslation("msg.probePressureMode" + (mode + 1) + ".txt"));
                    if (HexUtils.getMetaBit(BlockHexoriumPressurePlate.META_STATE, world, x, y, z))
                        player.addChatMessage(new ChatComponentTranslation("msg.probePressedYes.txt"));
                    else
                        player.addChatMessage(new ChatComponentTranslation("msg.probePressedNo.txt"));

                    if (HexConfig.cfgGeneralUseAchievements)
                        player.addStat(HexAchievements.achUseProbeMachine, 1);
                }
            }

            // Display structure block info.
            else if (block instanceof HexBlockMT
                    || block == HexBlocks.blockTemperedHexoriumGlass
                    || block == HexBlocks.blockHexoriumCoatedStone
                    || block instanceof BlockEnergyNodeCore) {
                if (!player.isSneaking()) {
                    HexUtils.addChatProbeTitle(player);
                    HexUtils.addChatProbeGenericInfo(player, world, x, y, z);
                    player.addChatMessage(new ChatComponentTranslation("msg.probeTypeBlock.txt"));
                    if (HexUtils.getMetaBit(HexBlocks.META_STRUCTURE_IS_PART, world, x, y, z))
                        player.addChatMessage(new ChatComponentTranslation("msg.probeFormedYes.txt"));
                    else
                        player.addChatMessage(new ChatComponentTranslation("msg.probeFormedNo.txt"));

                    if (HexConfig.cfgGeneralUseAchievements)
                        player.addStat(HexAchievements.achUseProbeMachine, 1);
                }
            }

            // Do a test analysis.
            else if (block instanceof BlockHexoriumCable || block instanceof BlockPylonBase) {
                if (player.isSneaking()) {
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    analyzer.analyzeProbe(world, x, y, z, block, player);

                    if (HexConfig.cfgGeneralUseAchievements)
                        player.addStat(HexAchievements.achUseProbeNetwork, 1);
                }
            }
        }

        return false;
    }

    public static Item registerItem() {
        Item item = new ItemHexoriumProbe(ID);
        GameRegistry.registerItem(item, ID);
        return item;
    }
}
