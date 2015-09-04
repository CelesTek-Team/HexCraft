package com.celestek.hexcraft.item;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.*;
import com.celestek.hexcraft.init.HexAchievements;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.inventory.ContainerMolecularTransposer;
import com.celestek.hexcraft.tileentity.TileEnergyPylon;
import com.celestek.hexcraft.tileentity.TilePersonalTeleportationPad;
import com.celestek.hexcraft.util.NetworkAnalyzer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.6.1
 * @since 2015-04-15
 */

public class ItemMolecularTransposer extends Item {

    // Set default item name.
    public static String UNLOCALISEDNAME = "itemMolecularTransposer";

    /**
     * Constructor for the item.
     * @param itemName Unlocalized name for the item.
     */
    public ItemMolecularTransposer(String itemName) {
        setUnlocalizedName(itemName);
        setCreativeTab(HexCraft.tabMachines);
        setMaxStackSize(1);
    }

    @Override
    public boolean onDroppedByPlayer(ItemStack itemstack, EntityPlayer player) {
        if (itemstack != null &&
                player instanceof EntityPlayerMP &&
                player.openContainer instanceof ContainerMolecularTransposer) {
            player.closeScreen();
        }

        return super.onDroppedByPlayer(itemstack, player);
    }

    @Override
    public boolean getShareTag() {
        return true;
    }

    /**
     * This is called when the item is used, before the block is activated.
     * @param device The Item Stack
     * @param player The Player that used the item
     * @param world The Current World
     * @param x Target X Position
     * @param y Target Y Position
     * @param z Target Z Position
     * @param side The side of the target hit
     * @return Return true to prevent any further processing.
     */
    @Override
    public boolean onItemUseFirst(ItemStack device, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        // Check if this is the server thread.
        if (!world.isRemote) {
            // Fired if the player is sneaking.
            if (!player.isSneaking()) {
                // Read the items.
                ItemStack[] inventory = new ItemStack[1];
                if (device.stackTagCompound == null)
                    device.stackTagCompound = new NBTTagCompound();
                NBTTagList tagsItems = device.stackTagCompound.getTagList("Items", 10);
                for (int i = 0; i < tagsItems.tagCount(); ++i) {
                    NBTTagCompound tagCompound1 = tagsItems.getCompoundTagAt(i);
                    byte byte0 = tagCompound1.getByte("Slot");

                    if (byte0 >= 0 && byte0 < inventory.length) {
                        inventory[byte0] = ItemStack.loadItemStackFromNBT(tagCompound1);
                    }
                }

                if (inventory[0] != null) {
                    if (Block.getBlockFromItem(inventory[0].getItem()) instanceof BlockEnergizedHexorium) {
                        Block block = world.getBlock(x, y, z);
                        int meta = world.getBlockMetadata(x, y, z);
                        if (block instanceof BlockEngineeredHexoriumBlock ||
                                block instanceof BlockFramedHexoriumBlock ||
                                block instanceof BlockPlatedHexoriumBlock ||
                                block instanceof BlockConcentricHexoriumBlock) {
                            
                            int blockType = 0;
                            if (block instanceof BlockFramedHexoriumBlock)
                                blockType = 1;
                            else if (block instanceof BlockPlatedHexoriumBlock)
                                blockType = 2;
                            else if (block instanceof BlockConcentricHexoriumBlock)
                                blockType = 3;
                            
                            
                            
                            if (block == HexBlocks.blockEngineeredHexoriumBlockRed ||
                                    block == HexBlocks.blockFramedHexoriumBlockRed ||
                                    block == HexBlocks.blockPlatedHexoriumBlockRed ||
                                    block == HexBlocks.blockConcentricHexoriumBlockRed)
                                player.inventory.addItemStackToInventory(new ItemStack(HexBlocks.blockEnergizedHexoriumRed, 1));
                               
                            
                            if (Block.getBlockFromItem(inventory[0].getItem()) == HexBlocks.blockEnergizedHexoriumGreen)
                                switch(blockType) {
                                    case 0: world.setBlock(x, y, z, HexBlocks.blockEngineeredHexoriumBlockGreen); break;
                                    case 1: world.setBlock(x, y, z, HexBlocks.blockFramedHexoriumBlockGreen); break;
                                    case 2: world.setBlock(x, y, z, HexBlocks.blockPlatedHexoriumBlockGreen); break;
                                    case 3: world.setBlock(x, y, z, HexBlocks.blockConcentricHexoriumBlockGreen); break;
                                }

                            inventory[0].stackSize--;
                            if (inventory[0].stackSize == 0)
                                inventory[0] = null;

                            // Write the items.
                            tagsItems = new NBTTagList();
                            for (int i = 0; i < inventory.length; i++)
                                if (inventory[i] != null) {
                                    NBTTagCompound tagCompoundLoop = new NBTTagCompound();
                                    tagCompoundLoop.setByte("Slot", (byte) i);
                                    inventory[i].writeToNBT(tagCompoundLoop);
                                    tagsItems.appendTag(tagCompoundLoop);
                                }
                            device.stackTagCompound.setTag("Items", tagsItems);
                            player.inventory.setInventorySlotContents(player.inventory.currentItem, device);

                            world.setBlockMetadataWithNotify(x, y, z, meta, 2);
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            if (player.isSneaking()) {
                player.openGui(HexCraft.instance, 5, world, (int) player.posX, (int) player.posY, (int) player.posZ);
            }
        }
        return stack;
    }

    // Prepare the icons.
    @SideOnly(Side.CLIENT)
    private IIcon icon[];

    /**
     * Registers the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        // Initialize the icons.
        icon = new IIcon[1];

        // Load all the different icons.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME);
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int damage) {
        return icon[0];
    }
}
