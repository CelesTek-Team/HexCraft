package com.celestek.hexcraft.item;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.*;
import com.celestek.hexcraft.init.HexAchievements;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.util.HexEnums;
import com.celestek.hexcraft.util.HexUtils;
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

public class ItemHexoriumDye extends Item {

    // Item ID
    public static final String ID = "itemHexoriumDye";

    // Variant
    private final HexEnums.Variants variant;

    /**
     * Constructor for the item.
     * @param itemName Unlocalized name for the item.
     * @param variant The decoration variant to use.
     */
    public ItemHexoriumDye(String itemName, HexEnums.Variants variant) {
        setUnlocalizedName(itemName);
        this.variant = variant;
        setCreativeTab(HexCraft.tabDecorative);
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

            if (block instanceof IBlockHexVariant) {
                IBlockHexVariant blockVariant = (IBlockHexVariant) block;

                if (blockVariant.getVariant() != this.variant) {
                    if ((block instanceof IBlockMultiBlock) && HexUtils.getMetaBit(HexBlocks.META_STRUCTURE_IS_PART, world, x, y, z)) {
                        player.addChatMessage(new ChatComponentTranslation("msg.cannotDye.txt"));
                        return false;
                    }

                    IBlockHexID blockID = (IBlockHexID) block;
                    Block blockNew = HexBlocks.getHexBlock(blockID.getID(), this.variant, block.getUnlocalizedName().replace("tile." + blockID.getID() + blockVariant.getVariant().name, ""));
                    if (block instanceof  IBlockHexColor) {
                        IBlockHexColor blockColor = (IBlockHexColor) block;
                        blockNew = HexBlocks.getHexBlock(blockID.getID(), this.variant, blockColor.getColor());
                    }
                    
                    if (block instanceof BlockHexoriumDoor) {
                        if (world.getBlock(x, y - 1, z) instanceof BlockHexoriumDoor) {
                            int meta1 = world.getBlockMetadata(x, y - 1, z);
                            int meta2 = world.getBlockMetadata(x, y, z);
                            world.setBlockToAir(x, y - 1, z);
                            world.setBlockToAir(x, y, z);
                            world.setBlock(x, y - 1, z, blockNew);
                            world.setBlock(x, y, z, blockNew);
                            world.setBlockMetadataWithNotify(x, y - 1, z, meta1, HexUtils.META_NOTIFY_NOTHING);
                            world.setBlockMetadataWithNotify(x, y, z, meta2, HexUtils.META_NOTIFY_UPDATE);
                        }
                        else {
                            int meta1 = world.getBlockMetadata(x, y, z);
                            int meta2 = world.getBlockMetadata(x, y + 1, z);
                            world.setBlockToAir(x, y, z);
                            world.setBlockToAir(x, y + 1, z);
                            world.setBlock(x, y, z, blockNew);
                            world.setBlock(x, y + 1, z, blockNew);
                            world.setBlockMetadataWithNotify(x, y, z, meta1, HexUtils.META_NOTIFY_NOTHING);
                            world.setBlockMetadataWithNotify(x, y + 1, z, meta2, HexUtils.META_NOTIFY_UPDATE);
                        }
                    }
                    else {
                        int meta = world.getBlockMetadata(x, y, z);
                        world.setBlock(x, y, z, blockNew);
                        world.setBlockMetadataWithNotify(x, y, z, meta, HexUtils.META_NOTIFY_UPDATE);
                    }

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

    public static void registerItems() {
        for (HexEnums.Variants variant : HexEnums.Variants.values()) {
            String name = ID + variant.name;
            ItemHexoriumDye item = new ItemHexoriumDye(name, variant);
            GameRegistry.registerItem(item, name);
        }
    }
}
