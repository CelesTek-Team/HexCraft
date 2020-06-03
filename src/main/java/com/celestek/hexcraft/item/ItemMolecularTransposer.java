package com.celestek.hexcraft.item;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.*;
import com.celestek.hexcraft.init.HexAchievements;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.init.HexGui;
import com.celestek.hexcraft.util.HexDamage;
import com.celestek.hexcraft.util.HexUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.*;
import net.minecraft.world.World;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class ItemMolecularTransposer extends Item {

    // Item ID
    public static final String ID = "toolMolecularTransposer";

    /**
     * Constructor for the item.
     * @param itemName Unlocalized name for the item.
     */
    public ItemMolecularTransposer(String itemName) {
        setUnlocalizedName(itemName);
        setCreativeTab(HexCraft.tabMachines);
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
            // Fired if the player is not sneaking.
            if (!player.isSneaking()) {
                ItemStack inventory = readNBT(stack);
                if (inventory != null) {
                    // If the block in container is Energized Hexorium...
                    if (Block.getBlockFromItem(inventory.getItem()) instanceof BlockEnergizedHexorium) {
                        Block block = world.getBlock(x, y, z);

                        // If the block is one of the fecorative blocks...
                        if (block instanceof BlockEngineeredHexoriumBlock ||
                                block instanceof BlockFramedHexoriumBlock ||
                                block instanceof BlockPlatedHexoriumBlock ||
                                block instanceof BlockConcentricHexoriumBlock ||
                                block instanceof BlockHexoriumStructureCasing ||
                                block instanceof BlockHexoriumLamp ||
                                block instanceof BlockHexoriumLampInv) {

                            if (!HexUtils.getMetaBit(HexBlocks.META_STRUCTURE_IS_PART, world, x, y, z)) {
                                // Get the block meta.
                                int meta = world.getBlockMetadata(x, y, z);

                                // Get required types
                                IBlockHexId blockId = (IBlockHexId) block;
                                IBlockHexColor blockColor = (IBlockHexColor) block;
                                IBlockHexVariant blockHexVariant = (IBlockHexVariant) block;

                                // Fetch Energized from tool.
                                Block blockInventory = Block.getBlockFromItem(inventory.getItem());
                                if (blockInventory instanceof BlockEnergizedHexorium) {
                                    // Check if the color is different.
                                    IBlockHexColor blockEnergized = (IBlockHexColor) blockInventory;
                                    if (blockEnergized.getColor() != blockColor.getColor()) {
                                        // Drop the old Energized.
                                        EntityItem entity = new EntityItem(world, player.posX, player.posY, player.posZ);
                                        entity.setEntityItemStack(new ItemStack(HexBlocks.getBlockByColor(BlockEnergizedHexorium.ID, blockColor.getColor()), 1));
                                        world.spawnEntityInWorld(entity);

                                        // Place the new block.
                                        world.setBlock(x, y, z, HexBlocks.getBlockByVariantColor(blockId.getID(), blockHexVariant.getVariant(), blockEnergized.getColor()));
                                    }
                                }

                                // Set the block meta.
                                world.setBlockMetadataWithNotify(x, y, z, meta, HexUtils.META_NOTIFY_UPDATE);

                                // Decrement the count of Energized Hexorium.
                                inventory.stackSize--;
                                if (inventory.stackSize == 0)
                                    inventory = null;

                                // Write the items.
                                NBTTagList tagsItems = new NBTTagList();
                                if (inventory != null) {
                                    NBTTagCompound tagCompoundLoop = new NBTTagCompound();
                                    inventory.writeToNBT(tagCompoundLoop);
                                    tagsItems.appendTag(tagCompoundLoop);
                                }
                                stack.stackTagCompound.setTag("items", tagsItems);
                                player.inventory.setInventorySlotContents(player.inventory.currentItem, stack);

                                // Grant player the achievement.
                                if (HexConfig.cfgGeneralUseAchievements)
                                    player.addStat(HexAchievements.achUseTransposer, 1);
                            }
                            else
                                player.addChatMessage(new ChatComponentTranslation("msg.cannotSwap.txt"));
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
        if (!world.isRemote)
            // Fired if the player is sneaking.
            if (player.isSneaking())
                // Open the GUI.
                player.openGui(HexCraft.instance, HexGui.GUI_ID_MOLECULAR_TRANSPOSER, world, (int) player.posX, (int) player.posY, (int) player.posZ);

        return stack;
    }

    /**
     * Returns true if the item can be used on the given entity, e.g. shears on sheep.
     */
    @Override
    public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity) {
        if (!entity.worldObj.isRemote)
            if (HexConfig.cfgGeneralTransposerAttack)
                if (!(entity instanceof EntityPlayer) || HexConfig.cfgGeneralTransposerAttackPlayers) {
                    ItemStack inventory = readNBT(itemstack);
                    if (inventory != null)
                        // If the block in container is Energized Hexorium...
                        if (Block.getBlockFromItem(inventory.getItem()) instanceof BlockEnergizedHexorium)
                            // Check if the target can be attacked.
                            if (entity.canAttackWithItem()) {
                                // If yes, deal damage.
                                entity.attackEntityFrom(HexDamage.transposer, 20);

                                // Decrement the count of Energized Hexorium.
                                inventory.stackSize--;
                                if (inventory.stackSize == 0)
                                    inventory = null;

                                // Write the items.
                                NBTTagList tagsItems = new NBTTagList();
                                if (inventory != null) {
                                    NBTTagCompound tagCompoundLoop = new NBTTagCompound();
                                    inventory.writeToNBT(tagCompoundLoop);
                                    tagsItems.appendTag(tagCompoundLoop);
                                }
                                itemstack.stackTagCompound.setTag("items", tagsItems);
                                player.inventory.setInventorySlotContents(player.inventory.currentItem, itemstack);

                                // Grant player the achievement.
                                if (HexConfig.cfgGeneralUseAchievements)
                                    player.addStat(HexAchievements.achAttackTransposer, 1);

                                return true;
                            }
                }

        return false;
    }

    /**
     * If the durability bar should be showed.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean showDurabilityBar(ItemStack stack) {
        ItemStack inventory = readNBT(stack);

        return (inventory != null);
    }

    /**
     * Renders the durability bar.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public double getDurabilityForDisplay(ItemStack stack) {
        ItemStack inventory = readNBT(stack);

        // Calculate bar.
        if (inventory != null)
            return 1 - (double)inventory.stackSize / (double)64;
        else
            return 1;
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
        icon = new IIcon[19];

        // Load the empty icon.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID);

        // Load all the different color icons.
        icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "Red");
        icon[2] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "Orange");
        icon[3] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "Yellow");
        icon[4] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "Lime");
        icon[5] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "Green");
        icon[6] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "Turquoise");
        icon[7] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "Cyan");
        icon[8] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "SkyBlue");
        icon[9] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "Blue");
        icon[10] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "Purple");
        icon[11] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "Magenta");
        icon[12] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "Pink");

        icon[13] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "White");
        icon[14] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "LightGray");
        icon[15] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "Gray");
        icon[16] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "DarkGray");
        icon[17] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "Black");

        icon[18] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "Rainbow");
    }

    /**
     * Gets an icon index based on player.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
        return getIconIndex(stack);
    }

    /**
     * Gets an icon index based on an item's damage value.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconIndex(ItemStack stack) {
        ItemStack inventory = readNBT(stack);

        // Get a different icon based on Energized Hexorium.
        if (inventory != null) {
            Block block = Block.getBlockFromItem(inventory.getItem());
            if (block == HexBlocks.blockEnergizedHexoriumRed)
                return icon[1];
            else if (block == HexBlocks.blockEnergizedHexoriumOrange)
                return icon[2];
            else if (block == HexBlocks.blockEnergizedHexoriumYellow)
                return icon[3];
            else if (block == HexBlocks.blockEnergizedHexoriumLime)
                return icon[4];
            else if (block == HexBlocks.blockEnergizedHexoriumGreen)
                return icon[5];
            else if (block == HexBlocks.blockEnergizedHexoriumTurquoise)
                return icon[6];
            else if (block == HexBlocks.blockEnergizedHexoriumCyan)
                return icon[7];
            else if (block == HexBlocks.blockEnergizedHexoriumSkyBlue)
                return icon[8];
            else if (block == HexBlocks.blockEnergizedHexoriumBlue)
                return icon[9];
            else if (block == HexBlocks.blockEnergizedHexoriumPurple)
                return icon[10];
            else if (block == HexBlocks.blockEnergizedHexoriumMagenta)
                return icon[11];
            else if (block == HexBlocks.blockEnergizedHexoriumPink)
                return icon[12];

            else if (block == HexBlocks.blockEnergizedHexoriumWhite)
                return icon[13];
            else if (block == HexBlocks.blockEnergizedHexoriumLightGray)
                return icon[14];
            else if (block == HexBlocks.blockEnergizedHexoriumGray)
                return icon[15];
            else if (block == HexBlocks.blockEnergizedHexoriumDarkGray)
                return icon[16];
            else if (block == HexBlocks.blockEnergizedHexoriumBlack)
                return icon[17];

            else if (block == HexBlocks.blockEnergizedHexoriumRainbow)
                return icon[18];
        }

        return icon[0];
    }

    /**
     * Reads the container.
     */
    private ItemStack readNBT(ItemStack device) {
        ItemStack inventory;

        if (device.stackTagCompound == null)
            device.stackTagCompound = new NBTTagCompound();

        NBTTagList tagsItems = device.stackTagCompound.getTagList("items", 10);
        NBTTagCompound tagCompound1 = tagsItems.getCompoundTagAt(0);
        inventory = ItemStack.loadItemStackFromNBT(tagCompound1);

        return inventory;
    }

}
