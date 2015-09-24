package com.celestek.hexcraft.item;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.*;
import com.celestek.hexcraft.init.HexAchievements;
import com.celestek.hexcraft.init.HexConfig;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.6.2

 */

public class ItemHexoriumReinforcer extends Item {

    // Set default item name.
    public static String UNLOCALISEDNAME = "itemHexoriumReinforcer";

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
        // Get the block.
        Block block = world.getBlock(x, y, z);

        // Check if this is the server thread.
        if (!world.isRemote) {
            if (block instanceof BlockEngineeredHexoriumBlock ||
                    block instanceof BlockFramedHexoriumBlock ||
                    block instanceof BlockPlatedHexoriumBlock ||
                    block instanceof BlockConcentricHexoriumBlock) {
                if (world.getBlockMetadata(x, y, z) == 0) {
                    world.setBlockMetadataWithNotify(x, y, z, 1, 2);

                    // Grant player the achievement.
                    if (HexConfig.cfgGeneralUseAchievements)
                        player.addStat(HexAchievements.achUseReinforcer, 1);

                    stack.stackSize--;
                    if (stack.stackSize == 0)
                        stack = null;
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, stack);
                }
            }
        }
        return false;
    }
}
