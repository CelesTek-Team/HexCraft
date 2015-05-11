package com.celestek.hexcraft.item;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.BlockEnergizedHexorium;
import com.celestek.hexcraft.block.BlockEnergizedHexoriumMonolith;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.tileentity.TileEnergyPylon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-15
 */

public class ItemHexoriumManipulator extends Item {

    // Set default item name.
    public static String UNLOCALISEDNAME = "itemHexoriumManipulator";

    int prevX = 0;
    int prevY = 0;
    int prevZ = 0;

    /**
     * Constructor for the item.
     * @param itemName Unlocalized name for the item.
     */
    public ItemHexoriumManipulator(String itemName) {
        setUnlocalizedName(itemName);
        setCreativeTab(HexCraft.hexCraftTab);
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

            if (player.isSneaking()) {
                if (block instanceof BlockEnergizedHexorium || block instanceof BlockEnergizedHexoriumMonolith) {
                    block.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), HexCraft.hexFortune);
                    world.setBlockToAir(x, y, z);
                } else if (block == HexBlocks.blockEnergyPylon)
                    block.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), HexCraft.hexFortune);
            }
            else {
                if (block == HexBlocks.blockEnergyPylon) {
                    if (stack.stackTagCompound == null)
                        stack.stackTagCompound = new NBTTagCompound();

                    if (!stack.stackTagCompound.getBoolean("Linking")) {
                        stack.stackTagCompound.setInteger("X", x);
                        stack.stackTagCompound.setInteger("Y", y);
                        stack.stackTagCompound.setInteger("Z", z);
                        stack.stackTagCompound.setBoolean("Linking", true);
                        stack.setItemDamage(1);
                    }
                    else {
                        int tx = stack.stackTagCompound.getInteger("X");
                        int ty = stack.stackTagCompound.getInteger("Y");
                        int tz = stack.stackTagCompound.getInteger("Z");

                        if (TileEnergyPylon.tracePylons(world, x, y, z, tx, ty, tz)) {
                            System.out.println("Beam can be formed!");

                            TileEnergyPylon pylonA = (TileEnergyPylon) world.getTileEntity(x, y, z);
                            TileEnergyPylon pylonB = (TileEnergyPylon) world.getTileEntity(tx, ty, tz);
                            if (pylonA != null && pylonB != null) {
                                if (pylonA.monolith == 18 || pylonB.monolith == 18 || pylonA.monolith == pylonB.monolith) {
                                    if (pylonA.addPylon(tx, ty, tz, false) && pylonB.addPylon(x, y, z, true))
                                        System.out.println("Linked!");
                                    else {
                                        pylonA.removePylon(tx, ty, tz);
                                        pylonB.removePylon(x, y, z);
                                        System.out.println("Linking failed.");
                                    }

                                }
                            }
                        }

                        stack.stackTagCompound.setBoolean("Linking", false);
                        stack.setItemDamage(0);
                    }
                    // System.out.println("Block: (" + x + ", " + y + ", " + z + "), Linking: " + stack.stackTagCompound.getBoolean("linking"));
                }
            }
        }
        return false;
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
        icon = new IIcon[2];

        // Load all the different icons.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME + "A");
        icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME + "B");
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int damage) {
        if (damage == 0)
            return icon[0];
        else
            return icon[1];
    }
}
