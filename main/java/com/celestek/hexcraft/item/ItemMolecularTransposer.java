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
 * @version 0.8.0
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

                                // Adjust the type of decorative block.
                                int blockType = 0;
                                if (block instanceof BlockFramedHexoriumBlock)
                                    blockType = 1;
                                else if (block instanceof BlockPlatedHexoriumBlock)
                                    blockType = 2;
                                else if (block instanceof BlockConcentricHexoriumBlock)
                                    blockType = 3;
                                else if (block instanceof BlockHexoriumStructureCasing)
                                    blockType = 4;
                                else if (block instanceof BlockHexoriumLamp)
                                    blockType = 5;
                                else if (block instanceof BlockHexoriumLampInv)
                                    blockType = 6;

                                // Drop Energized Hexorium.
                                // Red
                                if (block == HexBlocks.blockEngineeredHexoriumBlockRed ||
                                        block == HexBlocks.blockFramedHexoriumBlockRed ||
                                        block == HexBlocks.blockPlatedHexoriumBlockRed ||
                                        block == HexBlocks.blockConcentricHexoriumBlockRed ||
                                        block == HexBlocks.blockHexoriumStructureCasingRed ||
                                        block == HexBlocks.blockHexoriumLampRed ||
                                        block == HexBlocks.blockHexoriumLampInvRed) {
                                    EntityItem entity = new EntityItem(world, player.posX, player.posY, player.posZ);
                                    entity.setEntityItemStack(new ItemStack(HexBlocks.blockEnergizedHexoriumRed, 1));
                                    world.spawnEntityInWorld(entity);
                                }
                                // Orange
                                else if (block == HexBlocks.blockEngineeredHexoriumBlockOrange ||
                                        block == HexBlocks.blockFramedHexoriumBlockOrange ||
                                        block == HexBlocks.blockPlatedHexoriumBlockOrange ||
                                        block == HexBlocks.blockConcentricHexoriumBlockOrange ||
                                        block == HexBlocks.blockHexoriumStructureCasingOrange ||
                                        block == HexBlocks.blockHexoriumLampOrange ||
                                        block == HexBlocks.blockHexoriumLampInvOrange) {
                                    EntityItem entity = new EntityItem(world, player.posX, player.posY, player.posZ);
                                    entity.setEntityItemStack(new ItemStack(HexBlocks.blockEnergizedHexoriumOrange, 1));
                                    world.spawnEntityInWorld(entity);
                                }
                                // Yellow
                                else if (block == HexBlocks.blockEngineeredHexoriumBlockYellow ||
                                        block == HexBlocks.blockFramedHexoriumBlockYellow ||
                                        block == HexBlocks.blockPlatedHexoriumBlockYellow ||
                                        block == HexBlocks.blockConcentricHexoriumBlockYellow ||
                                        block == HexBlocks.blockHexoriumStructureCasingYellow ||
                                        block == HexBlocks.blockHexoriumLampYellow ||
                                        block == HexBlocks.blockHexoriumLampInvYellow) {
                                    EntityItem entity = new EntityItem(world, player.posX, player.posY, player.posZ);
                                    entity.setEntityItemStack(new ItemStack(HexBlocks.blockEnergizedHexoriumYellow, 1));
                                    world.spawnEntityInWorld(entity);
                                }
                                // Lime
                                else if (block == HexBlocks.blockEngineeredHexoriumBlockLime ||
                                        block == HexBlocks.blockFramedHexoriumBlockLime ||
                                        block == HexBlocks.blockPlatedHexoriumBlockLime ||
                                        block == HexBlocks.blockConcentricHexoriumBlockLime ||
                                        block == HexBlocks.blockHexoriumStructureCasingLime ||
                                        block == HexBlocks.blockHexoriumLampLime ||
                                        block == HexBlocks.blockHexoriumLampInvLime) {
                                    EntityItem entity = new EntityItem(world, player.posX, player.posY, player.posZ);
                                    entity.setEntityItemStack(new ItemStack(HexBlocks.blockEnergizedHexoriumLime, 1));
                                    world.spawnEntityInWorld(entity);
                                }
                                // Green
                                else if (block == HexBlocks.blockEngineeredHexoriumBlockGreen ||
                                        block == HexBlocks.blockFramedHexoriumBlockGreen ||
                                        block == HexBlocks.blockPlatedHexoriumBlockGreen ||
                                        block == HexBlocks.blockConcentricHexoriumBlockGreen ||
                                        block == HexBlocks.blockHexoriumStructureCasingGreen ||
                                        block == HexBlocks.blockHexoriumLampGreen ||
                                        block == HexBlocks.blockHexoriumLampInvGreen) {
                                    EntityItem entity = new EntityItem(world, player.posX, player.posY, player.posZ);
                                    entity.setEntityItemStack(new ItemStack(HexBlocks.blockEnergizedHexoriumGreen, 1));
                                    world.spawnEntityInWorld(entity);
                                }
                                // Turquoise
                                else if (block == HexBlocks.blockEngineeredHexoriumBlockTurquoise ||
                                        block == HexBlocks.blockFramedHexoriumBlockTurquoise ||
                                        block == HexBlocks.blockPlatedHexoriumBlockTurquoise ||
                                        block == HexBlocks.blockConcentricHexoriumBlockTurquoise ||
                                        block == HexBlocks.blockHexoriumStructureCasingTurquoise ||
                                        block == HexBlocks.blockHexoriumLampTurquoise ||
                                        block == HexBlocks.blockHexoriumLampInvTurquoise) {
                                    EntityItem entity = new EntityItem(world, player.posX, player.posY, player.posZ);
                                    entity.setEntityItemStack(new ItemStack(HexBlocks.blockEnergizedHexoriumTurquoise, 1));
                                    world.spawnEntityInWorld(entity);
                                }
                                // Cyan
                                else if (block == HexBlocks.blockEngineeredHexoriumBlockCyan ||
                                        block == HexBlocks.blockFramedHexoriumBlockCyan ||
                                        block == HexBlocks.blockPlatedHexoriumBlockCyan ||
                                        block == HexBlocks.blockConcentricHexoriumBlockCyan ||
                                        block == HexBlocks.blockHexoriumStructureCasingCyan ||
                                        block == HexBlocks.blockHexoriumLampCyan ||
                                        block == HexBlocks.blockHexoriumLampInvCyan) {
                                    EntityItem entity = new EntityItem(world, player.posX, player.posY, player.posZ);
                                    entity.setEntityItemStack(new ItemStack(HexBlocks.blockEnergizedHexoriumCyan, 1));
                                    world.spawnEntityInWorld(entity);
                                }
                                // Sky Blue
                                else if (block == HexBlocks.blockEngineeredHexoriumBlockSkyBlue ||
                                        block == HexBlocks.blockFramedHexoriumBlockSkyBlue ||
                                        block == HexBlocks.blockPlatedHexoriumBlockSkyBlue ||
                                        block == HexBlocks.blockConcentricHexoriumBlockSkyBlue ||
                                        block == HexBlocks.blockHexoriumStructureCasingSkyBlue ||
                                        block == HexBlocks.blockHexoriumLampSkyBlue ||
                                        block == HexBlocks.blockHexoriumLampInvSkyBlue) {
                                    EntityItem entity = new EntityItem(world, player.posX, player.posY, player.posZ);
                                    entity.setEntityItemStack(new ItemStack(HexBlocks.blockEnergizedHexoriumSkyBlue, 1));
                                    world.spawnEntityInWorld(entity);
                                }
                                // Blue
                                else if (block == HexBlocks.blockEngineeredHexoriumBlockBlue ||
                                        block == HexBlocks.blockFramedHexoriumBlockBlue ||
                                        block == HexBlocks.blockPlatedHexoriumBlockBlue ||
                                        block == HexBlocks.blockConcentricHexoriumBlockBlue ||
                                        block == HexBlocks.blockHexoriumStructureCasingBlue ||
                                        block == HexBlocks.blockHexoriumLampBlue ||
                                        block == HexBlocks.blockHexoriumLampInvBlue) {
                                    EntityItem entity = new EntityItem(world, player.posX, player.posY, player.posZ);
                                    entity.setEntityItemStack(new ItemStack(HexBlocks.blockEnergizedHexoriumBlue, 1));
                                    world.spawnEntityInWorld(entity);
                                }
                                // Purple
                                else if (block == HexBlocks.blockEngineeredHexoriumBlockPurple ||
                                        block == HexBlocks.blockFramedHexoriumBlockPurple ||
                                        block == HexBlocks.blockPlatedHexoriumBlockPurple ||
                                        block == HexBlocks.blockConcentricHexoriumBlockPurple ||
                                        block == HexBlocks.blockHexoriumStructureCasingPurple ||
                                        block == HexBlocks.blockHexoriumLampPurple ||
                                        block == HexBlocks.blockHexoriumLampInvPurple) {
                                    EntityItem entity = new EntityItem(world, player.posX, player.posY, player.posZ);
                                    entity.setEntityItemStack(new ItemStack(HexBlocks.blockEnergizedHexoriumPurple, 1));
                                    world.spawnEntityInWorld(entity);
                                }
                                // Magenta
                                else if (block == HexBlocks.blockEngineeredHexoriumBlockMagenta ||
                                        block == HexBlocks.blockFramedHexoriumBlockMagenta ||
                                        block == HexBlocks.blockPlatedHexoriumBlockMagenta ||
                                        block == HexBlocks.blockConcentricHexoriumBlockMagenta ||
                                        block == HexBlocks.blockHexoriumStructureCasingMagenta ||
                                        block == HexBlocks.blockHexoriumLampMagenta ||
                                        block == HexBlocks.blockHexoriumLampInvMagenta) {
                                    EntityItem entity = new EntityItem(world, player.posX, player.posY, player.posZ);
                                    entity.setEntityItemStack(new ItemStack(HexBlocks.blockEnergizedHexoriumMagenta, 1));
                                    world.spawnEntityInWorld(entity);
                                }
                                // Pink
                                else if (block == HexBlocks.blockEngineeredHexoriumBlockPink ||
                                        block == HexBlocks.blockFramedHexoriumBlockPink ||
                                        block == HexBlocks.blockPlatedHexoriumBlockPink ||
                                        block == HexBlocks.blockConcentricHexoriumBlockPink ||
                                        block == HexBlocks.blockHexoriumStructureCasingPink ||
                                        block == HexBlocks.blockHexoriumLampPink ||
                                        block == HexBlocks.blockHexoriumLampInvPink) {
                                    EntityItem entity = new EntityItem(world, player.posX, player.posY, player.posZ);
                                    entity.setEntityItemStack(new ItemStack(HexBlocks.blockEnergizedHexoriumPink, 1));
                                    world.spawnEntityInWorld(entity);
                                }

                                // White
                                else if (block == HexBlocks.blockEngineeredHexoriumBlockWhite ||
                                        block == HexBlocks.blockFramedHexoriumBlockWhite ||
                                        block == HexBlocks.blockPlatedHexoriumBlockWhite ||
                                        block == HexBlocks.blockConcentricHexoriumBlockWhite ||
                                        block == HexBlocks.blockHexoriumStructureCasingWhite ||
                                        block == HexBlocks.blockHexoriumLampWhite ||
                                        block == HexBlocks.blockHexoriumLampInvWhite) {
                                    EntityItem entity = new EntityItem(world, player.posX, player.posY, player.posZ);
                                    entity.setEntityItemStack(new ItemStack(HexBlocks.blockEnergizedHexoriumWhite, 1));
                                    world.spawnEntityInWorld(entity);
                                }
                                // Light Gray
                                else if (block == HexBlocks.blockEngineeredHexoriumBlockLightGray ||
                                        block == HexBlocks.blockFramedHexoriumBlockLightGray ||
                                        block == HexBlocks.blockPlatedHexoriumBlockLightGray ||
                                        block == HexBlocks.blockConcentricHexoriumBlockLightGray ||
                                        block == HexBlocks.blockHexoriumStructureCasingLightGray ||
                                        block == HexBlocks.blockHexoriumLampLightGray ||
                                        block == HexBlocks.blockHexoriumLampInvLightGray) {
                                    EntityItem entity = new EntityItem(world, player.posX, player.posY, player.posZ);
                                    entity.setEntityItemStack(new ItemStack(HexBlocks.blockEnergizedHexoriumLightGray, 1));
                                    world.spawnEntityInWorld(entity);
                                }
                                // Gray
                                else if (block == HexBlocks.blockEngineeredHexoriumBlockGray ||
                                        block == HexBlocks.blockFramedHexoriumBlockGray ||
                                        block == HexBlocks.blockPlatedHexoriumBlockGray ||
                                        block == HexBlocks.blockConcentricHexoriumBlockGray ||
                                        block == HexBlocks.blockHexoriumStructureCasingGray ||
                                        block == HexBlocks.blockHexoriumLampGray ||
                                        block == HexBlocks.blockHexoriumLampInvGray) {
                                    EntityItem entity = new EntityItem(world, player.posX, player.posY, player.posZ);
                                    entity.setEntityItemStack(new ItemStack(HexBlocks.blockEnergizedHexoriumGray, 1));
                                    world.spawnEntityInWorld(entity);
                                }
                                // Dark Gray
                                else if (block == HexBlocks.blockEngineeredHexoriumBlockDarkGray ||
                                        block == HexBlocks.blockFramedHexoriumBlockDarkGray ||
                                        block == HexBlocks.blockPlatedHexoriumBlockDarkGray ||
                                        block == HexBlocks.blockConcentricHexoriumBlockDarkGray ||
                                        block == HexBlocks.blockHexoriumStructureCasingDarkGray ||
                                        block == HexBlocks.blockHexoriumLampDarkGray ||
                                        block == HexBlocks.blockHexoriumLampInvDarkGray) {
                                    EntityItem entity = new EntityItem(world, player.posX, player.posY, player.posZ);
                                    entity.setEntityItemStack(new ItemStack(HexBlocks.blockEnergizedHexoriumDarkGray, 1));
                                    world.spawnEntityInWorld(entity);
                                }
                                // Black
                                else if (block == HexBlocks.blockEngineeredHexoriumBlockBlack ||
                                        block == HexBlocks.blockFramedHexoriumBlockBlack ||
                                        block == HexBlocks.blockPlatedHexoriumBlockBlack ||
                                        block == HexBlocks.blockConcentricHexoriumBlockBlack ||
                                        block == HexBlocks.blockHexoriumStructureCasingBlack ||
                                        block == HexBlocks.blockHexoriumLampBlack ||
                                        block == HexBlocks.blockHexoriumLampInvBlack) {
                                    EntityItem entity = new EntityItem(world, player.posX, player.posY, player.posZ);
                                    entity.setEntityItemStack(new ItemStack(HexBlocks.blockEnergizedHexoriumBlack, 1));
                                    world.spawnEntityInWorld(entity);
                                }

                                // Rainbow
                                else if (block == HexBlocks.blockEngineeredHexoriumBlockRainbow ||
                                        block == HexBlocks.blockFramedHexoriumBlockRainbow ||
                                        block == HexBlocks.blockPlatedHexoriumBlockRainbow ||
                                        block == HexBlocks.blockConcentricHexoriumBlockRainbow ||
                                        block == HexBlocks.blockHexoriumStructureCasingRainbow ||
                                        block == HexBlocks.blockHexoriumLampRainbow ||
                                        block == HexBlocks.blockHexoriumLampInvRainbow) {
                                    EntityItem entity = new EntityItem(world, player.posX, player.posY, player.posZ);
                                    entity.setEntityItemStack(new ItemStack(HexBlocks.blockEnergizedHexoriumRainbow, 1));
                                    world.spawnEntityInWorld(entity);
                                }


                                // Set new block.
                                // Red
                                if (Block.getBlockFromItem(inventory.getItem()) == HexBlocks.blockEnergizedHexoriumRed)
                                    switch (blockType) {
                                        case 0:
                                            world.setBlock(x, y, z, HexBlocks.blockEngineeredHexoriumBlockRed);
                                            break;
                                        case 1:
                                            world.setBlock(x, y, z, HexBlocks.blockFramedHexoriumBlockRed);
                                            break;
                                        case 2:
                                            world.setBlock(x, y, z, HexBlocks.blockPlatedHexoriumBlockRed);
                                            break;
                                        case 3:
                                            world.setBlock(x, y, z, HexBlocks.blockConcentricHexoriumBlockRed);
                                            break;
                                        case 4:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumStructureCasingRed);
                                            break;
                                        case 5:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampRed);
                                            break;
                                        case 6:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampInvRed);
                                            break;
                                    }
                                    // Orange
                                else if (Block.getBlockFromItem(inventory.getItem()) == HexBlocks.blockEnergizedHexoriumOrange)
                                    switch (blockType) {
                                        case 0:
                                            world.setBlock(x, y, z, HexBlocks.blockEngineeredHexoriumBlockOrange);
                                            break;
                                        case 1:
                                            world.setBlock(x, y, z, HexBlocks.blockFramedHexoriumBlockOrange);
                                            break;
                                        case 2:
                                            world.setBlock(x, y, z, HexBlocks.blockPlatedHexoriumBlockOrange);
                                            break;
                                        case 3:
                                            world.setBlock(x, y, z, HexBlocks.blockConcentricHexoriumBlockOrange);
                                            break;
                                        case 4:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumStructureCasingOrange);
                                            break;
                                        case 5:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampOrange);
                                            break;
                                        case 6:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampInvOrange);
                                            break;
                                    }
                                    // Yellow
                                else if (Block.getBlockFromItem(inventory.getItem()) == HexBlocks.blockEnergizedHexoriumYellow)
                                    switch (blockType) {
                                        case 0:
                                            world.setBlock(x, y, z, HexBlocks.blockEngineeredHexoriumBlockYellow);
                                            break;
                                        case 1:
                                            world.setBlock(x, y, z, HexBlocks.blockFramedHexoriumBlockYellow);
                                            break;
                                        case 2:
                                            world.setBlock(x, y, z, HexBlocks.blockPlatedHexoriumBlockYellow);
                                            break;
                                        case 3:
                                            world.setBlock(x, y, z, HexBlocks.blockConcentricHexoriumBlockYellow);
                                            break;
                                        case 4:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumStructureCasingYellow);
                                            break;
                                        case 5:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampYellow);
                                            break;
                                        case 6:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampInvYellow);
                                            break;
                                    }
                                    // Lime
                                else if (Block.getBlockFromItem(inventory.getItem()) == HexBlocks.blockEnergizedHexoriumLime)
                                    switch (blockType) {
                                        case 0:
                                            world.setBlock(x, y, z, HexBlocks.blockEngineeredHexoriumBlockLime);
                                            break;
                                        case 1:
                                            world.setBlock(x, y, z, HexBlocks.blockFramedHexoriumBlockLime);
                                            break;
                                        case 2:
                                            world.setBlock(x, y, z, HexBlocks.blockPlatedHexoriumBlockLime);
                                            break;
                                        case 3:
                                            world.setBlock(x, y, z, HexBlocks.blockConcentricHexoriumBlockLime);
                                            break;
                                        case 4:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumStructureCasingLime);
                                            break;
                                        case 5:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampLime);
                                            break;
                                        case 6:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampInvLime);
                                            break;
                                    }
                                    // Green
                                else if (Block.getBlockFromItem(inventory.getItem()) == HexBlocks.blockEnergizedHexoriumGreen)
                                    switch (blockType) {
                                        case 0:
                                            world.setBlock(x, y, z, HexBlocks.blockEngineeredHexoriumBlockGreen);
                                            break;
                                        case 1:
                                            world.setBlock(x, y, z, HexBlocks.blockFramedHexoriumBlockGreen);
                                            break;
                                        case 2:
                                            world.setBlock(x, y, z, HexBlocks.blockPlatedHexoriumBlockGreen);
                                            break;
                                        case 3:
                                            world.setBlock(x, y, z, HexBlocks.blockConcentricHexoriumBlockGreen);
                                            break;
                                        case 4:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumStructureCasingGreen);
                                            break;
                                        case 5:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampGreen);
                                            break;
                                        case 6:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampInvGreen);
                                            break;
                                    }
                                    // Turquoise
                                else if (Block.getBlockFromItem(inventory.getItem()) == HexBlocks.blockEnergizedHexoriumTurquoise)
                                    switch (blockType) {
                                        case 0:
                                            world.setBlock(x, y, z, HexBlocks.blockEngineeredHexoriumBlockTurquoise);
                                            break;
                                        case 1:
                                            world.setBlock(x, y, z, HexBlocks.blockFramedHexoriumBlockTurquoise);
                                            break;
                                        case 2:
                                            world.setBlock(x, y, z, HexBlocks.blockPlatedHexoriumBlockTurquoise);
                                            break;
                                        case 3:
                                            world.setBlock(x, y, z, HexBlocks.blockConcentricHexoriumBlockTurquoise);
                                            break;
                                        case 4:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumStructureCasingTurquoise);
                                            break;
                                        case 5:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampTurquoise);
                                            break;
                                        case 6:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampInvTurquoise);
                                            break;
                                    }
                                    // Cyan
                                else if (Block.getBlockFromItem(inventory.getItem()) == HexBlocks.blockEnergizedHexoriumCyan)
                                    switch (blockType) {
                                        case 0:
                                            world.setBlock(x, y, z, HexBlocks.blockEngineeredHexoriumBlockCyan);
                                            break;
                                        case 1:
                                            world.setBlock(x, y, z, HexBlocks.blockFramedHexoriumBlockCyan);
                                            break;
                                        case 2:
                                            world.setBlock(x, y, z, HexBlocks.blockPlatedHexoriumBlockCyan);
                                            break;
                                        case 3:
                                            world.setBlock(x, y, z, HexBlocks.blockConcentricHexoriumBlockCyan);
                                            break;
                                        case 4:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumStructureCasingCyan);
                                            break;
                                        case 5:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampCyan);
                                            break;
                                        case 6:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampInvCyan);
                                            break;
                                    }
                                    // Sky Blue
                                else if (Block.getBlockFromItem(inventory.getItem()) == HexBlocks.blockEnergizedHexoriumSkyBlue)
                                    switch (blockType) {
                                        case 0:
                                            world.setBlock(x, y, z, HexBlocks.blockEngineeredHexoriumBlockSkyBlue);
                                            break;
                                        case 1:
                                            world.setBlock(x, y, z, HexBlocks.blockFramedHexoriumBlockSkyBlue);
                                            break;
                                        case 2:
                                            world.setBlock(x, y, z, HexBlocks.blockPlatedHexoriumBlockSkyBlue);
                                            break;
                                        case 3:
                                            world.setBlock(x, y, z, HexBlocks.blockConcentricHexoriumBlockSkyBlue);
                                            break;
                                        case 4:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumStructureCasingSkyBlue);
                                            break;
                                        case 5:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampSkyBlue);
                                            break;
                                        case 6:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampInvSkyBlue);
                                            break;
                                    }
                                    // Blue
                                else if (Block.getBlockFromItem(inventory.getItem()) == HexBlocks.blockEnergizedHexoriumBlue)
                                    switch (blockType) {
                                        case 0:
                                            world.setBlock(x, y, z, HexBlocks.blockEngineeredHexoriumBlockBlue);
                                            break;
                                        case 1:
                                            world.setBlock(x, y, z, HexBlocks.blockFramedHexoriumBlockBlue);
                                            break;
                                        case 2:
                                            world.setBlock(x, y, z, HexBlocks.blockPlatedHexoriumBlockBlue);
                                            break;
                                        case 3:
                                            world.setBlock(x, y, z, HexBlocks.blockConcentricHexoriumBlockBlue);
                                            break;
                                        case 4:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumStructureCasingBlue);
                                            break;
                                        case 5:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampBlue);
                                            break;
                                        case 6:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampInvBlue);
                                            break;
                                    }
                                    // Purple
                                else if (Block.getBlockFromItem(inventory.getItem()) == HexBlocks.blockEnergizedHexoriumPurple)
                                    switch (blockType) {
                                        case 0:
                                            world.setBlock(x, y, z, HexBlocks.blockEngineeredHexoriumBlockPurple);
                                            break;
                                        case 1:
                                            world.setBlock(x, y, z, HexBlocks.blockFramedHexoriumBlockPurple);
                                            break;
                                        case 2:
                                            world.setBlock(x, y, z, HexBlocks.blockPlatedHexoriumBlockPurple);
                                            break;
                                        case 3:
                                            world.setBlock(x, y, z, HexBlocks.blockConcentricHexoriumBlockPurple);
                                            break;
                                        case 4:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumStructureCasingPurple);
                                            break;
                                        case 5:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampPurple);
                                            break;
                                        case 6:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampInvPurple);
                                            break;
                                    }
                                    // Magenta
                                else if (Block.getBlockFromItem(inventory.getItem()) == HexBlocks.blockEnergizedHexoriumMagenta)
                                    switch (blockType) {
                                        case 0:
                                            world.setBlock(x, y, z, HexBlocks.blockEngineeredHexoriumBlockMagenta);
                                            break;
                                        case 1:
                                            world.setBlock(x, y, z, HexBlocks.blockFramedHexoriumBlockMagenta);
                                            break;
                                        case 2:
                                            world.setBlock(x, y, z, HexBlocks.blockPlatedHexoriumBlockMagenta);
                                            break;
                                        case 3:
                                            world.setBlock(x, y, z, HexBlocks.blockConcentricHexoriumBlockMagenta);
                                            break;
                                        case 4:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumStructureCasingMagenta);
                                            break;
                                        case 5:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampMagenta);
                                            break;
                                        case 6:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampInvMagenta);
                                            break;
                                    }
                                    // Pink
                                else if (Block.getBlockFromItem(inventory.getItem()) == HexBlocks.blockEnergizedHexoriumPink)
                                    switch (blockType) {
                                        case 0:
                                            world.setBlock(x, y, z, HexBlocks.blockEngineeredHexoriumBlockPink);
                                            break;
                                        case 1:
                                            world.setBlock(x, y, z, HexBlocks.blockFramedHexoriumBlockPink);
                                            break;
                                        case 2:
                                            world.setBlock(x, y, z, HexBlocks.blockPlatedHexoriumBlockPink);
                                            break;
                                        case 3:
                                            world.setBlock(x, y, z, HexBlocks.blockConcentricHexoriumBlockPink);
                                            break;
                                        case 4:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumStructureCasingPink);
                                            break;
                                        case 5:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampPink);
                                            break;
                                        case 6:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampInvPink);
                                            break;
                                    }

                                    // white
                                else if (Block.getBlockFromItem(inventory.getItem()) == HexBlocks.blockEnergizedHexoriumWhite)
                                    switch (blockType) {
                                        case 0:
                                            world.setBlock(x, y, z, HexBlocks.blockEngineeredHexoriumBlockWhite);
                                            break;
                                        case 1:
                                            world.setBlock(x, y, z, HexBlocks.blockFramedHexoriumBlockWhite);
                                            break;
                                        case 2:
                                            world.setBlock(x, y, z, HexBlocks.blockPlatedHexoriumBlockWhite);
                                            break;
                                        case 3:
                                            world.setBlock(x, y, z, HexBlocks.blockConcentricHexoriumBlockWhite);
                                            break;
                                        case 4:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumStructureCasingWhite);
                                            break;
                                        case 5:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampWhite);
                                            break;
                                        case 6:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampInvWhite);
                                            break;
                                    }
                                    // Light Gray
                                else if (Block.getBlockFromItem(inventory.getItem()) == HexBlocks.blockEnergizedHexoriumLightGray)
                                    switch (blockType) {
                                        case 0:
                                            world.setBlock(x, y, z, HexBlocks.blockEngineeredHexoriumBlockLightGray);
                                            break;
                                        case 1:
                                            world.setBlock(x, y, z, HexBlocks.blockFramedHexoriumBlockLightGray);
                                            break;
                                        case 2:
                                            world.setBlock(x, y, z, HexBlocks.blockPlatedHexoriumBlockLightGray);
                                            break;
                                        case 3:
                                            world.setBlock(x, y, z, HexBlocks.blockConcentricHexoriumBlockLightGray);
                                            break;
                                        case 4:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumStructureCasingLightGray);
                                            break;
                                        case 5:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampLightGray);
                                            break;
                                        case 6:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampInvLightGray);
                                            break;
                                    }
                                    // Gray
                                else if (Block.getBlockFromItem(inventory.getItem()) == HexBlocks.blockEnergizedHexoriumGray)
                                    switch (blockType) {
                                        case 0:
                                            world.setBlock(x, y, z, HexBlocks.blockEngineeredHexoriumBlockGray);
                                            break;
                                        case 1:
                                            world.setBlock(x, y, z, HexBlocks.blockFramedHexoriumBlockGray);
                                            break;
                                        case 2:
                                            world.setBlock(x, y, z, HexBlocks.blockPlatedHexoriumBlockGray);
                                            break;
                                        case 3:
                                            world.setBlock(x, y, z, HexBlocks.blockConcentricHexoriumBlockGray);
                                            break;
                                        case 4:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumStructureCasingGray);
                                            break;
                                        case 5:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampGray);
                                            break;
                                        case 6:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampInvGray);
                                            break;
                                    }
                                    // Dark Gray
                                else if (Block.getBlockFromItem(inventory.getItem()) == HexBlocks.blockEnergizedHexoriumDarkGray)
                                    switch (blockType) {
                                        case 0:
                                            world.setBlock(x, y, z, HexBlocks.blockEngineeredHexoriumBlockDarkGray);
                                            break;
                                        case 1:
                                            world.setBlock(x, y, z, HexBlocks.blockFramedHexoriumBlockDarkGray);
                                            break;
                                        case 2:
                                            world.setBlock(x, y, z, HexBlocks.blockPlatedHexoriumBlockDarkGray);
                                            break;
                                        case 3:
                                            world.setBlock(x, y, z, HexBlocks.blockConcentricHexoriumBlockDarkGray);
                                            break;
                                        case 4:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumStructureCasingDarkGray);
                                            break;
                                        case 5:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampDarkGray);
                                            break;
                                        case 6:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampInvDarkGray);
                                            break;
                                    }
                                    // Black
                                else if (Block.getBlockFromItem(inventory.getItem()) == HexBlocks.blockEnergizedHexoriumBlack)
                                    switch (blockType) {
                                        case 0:
                                            world.setBlock(x, y, z, HexBlocks.blockEngineeredHexoriumBlockBlack);
                                            break;
                                        case 1:
                                            world.setBlock(x, y, z, HexBlocks.blockFramedHexoriumBlockBlack);
                                            break;
                                        case 2:
                                            world.setBlock(x, y, z, HexBlocks.blockPlatedHexoriumBlockBlack);
                                            break;
                                        case 3:
                                            world.setBlock(x, y, z, HexBlocks.blockConcentricHexoriumBlockBlack);
                                            break;
                                        case 4:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumStructureCasingBlack);
                                            break;
                                        case 5:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampBlack);
                                            break;
                                        case 6:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampInvBlack);
                                            break;
                                    }

                                    // Rainbow
                                else if (Block.getBlockFromItem(inventory.getItem()) == HexBlocks.blockEnergizedHexoriumRainbow)
                                    switch (blockType) {
                                        case 0:
                                            world.setBlock(x, y, z, HexBlocks.blockEngineeredHexoriumBlockRainbow);
                                            break;
                                        case 1:
                                            world.setBlock(x, y, z, HexBlocks.blockFramedHexoriumBlockRainbow);
                                            break;
                                        case 2:
                                            world.setBlock(x, y, z, HexBlocks.blockPlatedHexoriumBlockRainbow);
                                            break;
                                        case 3:
                                            world.setBlock(x, y, z, HexBlocks.blockConcentricHexoriumBlockRainbow);
                                            break;
                                        case 4:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumStructureCasingRainbow);
                                            break;
                                        case 5:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampRainbow);
                                            break;
                                        case 6:
                                            world.setBlock(x, y, z, HexBlocks.blockHexoriumLampInvRainbow);
                                            break;
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
