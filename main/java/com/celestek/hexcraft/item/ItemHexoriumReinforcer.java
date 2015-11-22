package com.celestek.hexcraft.item;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.*;
import com.celestek.hexcraft.init.HexAchievements;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.util.HexUtils;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.8.0
 */

public class ItemHexoriumReinforcer extends Item {

    // Item ID
    public static final String ID = "itemHexoriumReinforcer";

    /**
     * Constructor for the item.
     * @param itemName Unlocalized name for the item.
     */
    public ItemHexoriumReinforcer(String itemName) {
        setUnlocalizedName(itemName);
        setCreativeTab(HexCraft.tabMachines);
        setTextureName(HexCraft.MODID + ":" + itemName);
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
            // If the block is one of the reinforcable ones, reinforce it.
            if (block instanceof BlockEngineeredHexoriumBlock
                    || block instanceof BlockFramedHexoriumBlock
                    || block instanceof BlockPlatedHexoriumBlock
                    || block instanceof BlockConcentricHexoriumBlock
                    || block instanceof BlockHexoriumStructureCasing)
                if (!HexUtils.getMetaBit(HexBlocks.META_DECORATIVE_REINFORCED, world, x, y, z)) {
                    HexUtils.setMetaBit(HexBlocks.META_DECORATIVE_REINFORCED, true, HexUtils.META_NOTIFY_UPDATE, world, x, y, z);

                    // Grant player the achievement.
                    if (HexConfig.cfgGeneralUseAchievements)
                        player.addStat(HexAchievements.achUseReinforcer, 1);

                    stack.stackSize--;
                    if (stack.stackSize == 0)
                        stack = null;
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, stack);
                }
        }

        return false;
    }
}
