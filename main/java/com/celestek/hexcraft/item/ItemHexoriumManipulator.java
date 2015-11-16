package com.celestek.hexcraft.item;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.*;
import com.celestek.hexcraft.init.HexAchievements;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.tileentity.TileEnergyPylon;
import com.celestek.hexcraft.tileentity.TileTankValve;
import com.celestek.hexcraft.tileentity.TilePersonalTeleportationPad;
import com.celestek.hexcraft.util.HexUtils;
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
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.7.0
 */

public class ItemHexoriumManipulator extends Item {

    // Item ID
    public static final String ID = "itemHexoriumManipulator";

    // NBT Names
    private static final String NBT_TELEPORT_LINKING = "teleport_linking";
    private static final String NBT_TELEPORT_X = "teleport_x";
    private static final String NBT_TELEPORT_Y = "teleport_y";
    private static final String NBT_TELEPORT_Z = "teleport_z";

    private static final String NBT_PYLON_LINKING = "pylon_linking";
    private static final String NBT_PYLON_X = "pylon_x";
    private static final String NBT_PYLON_Y = "pylon_y";
    private static final String NBT_PYLON_Z = "pylon_z";

    /**
     * Constructor for the item.
     * @param itemName Unlocalized name for the item.
     */
    public ItemHexoriumManipulator(String itemName) {
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
            Block block = world.getBlock(x, y, z);

            // Fired if the player is sneaking.
            if (player.isSneaking()) {

                // Dismantle Energized Hexorium and Energized Hexorium Monoliths.
                if (block instanceof BlockEnergizedHexorium || block instanceof BlockEnergizedHexoriumMonolith) {
                    block.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), HexCraft.hexFortune);
                    world.setBlockToAir(x, y, z);
                }

                // Eject monolith from Energy Pylon.
                else if (block == HexBlocks.blockEnergyPylon) {
                    block.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), HexCraft.hexFortune);
                }

                // Rotate teleport.
                else if (block == HexBlocks.blockPersonalTeleportationPad) {
                    int metaOld = world.getBlockMetadata(x, y, z);

                    // Rotate meta
                    HexUtils.rotateBlock(HexBlocks.META_MACHINE_ROTATION_0, HexBlocks.META_MACHINE_ROTATION_1, true,
                            HexUtils.META_NOTIFY_UPDATE, world, x, y, z);

                    if (HexConfig.cfgGeneralNetworkDebug)
                        System.out.println("[Hexorium Manipulator]: Teleport rotated, analyzing!");

                    /* DO ANALYSIS */
                    // Prepare the network analyzers.
                    NetworkAnalyzer analyzerOld = new NetworkAnalyzer();
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    NetworkAnalyzer analyzerDown = new NetworkAnalyzer();
                    // Call the analysis in original and new direction.
                    analyzerOld.analyzeMachines(world, x, y, z, metaOld);
                    analyzer.analyzeMachines(world, x, y, z, world.getBlockMetadata(x, y, z));
                    analyzerDown.analyzeTeleport(world, x, y, z);
                }
                
                // Change Pressure Plate mode.
                else if (block instanceof BlockHexoriumPressurePlate) {

                    // Change meta accordingly.
                    HexUtils.rotateBlock(
                            BlockHexoriumPressurePlate.META_SETTING_0, 
                            BlockHexoriumPressurePlate.META_SETTING_1, 
                            true, HexUtils.META_NOTIFY_UPDATE, world, x, y, z);
                    int setting = HexUtils.getMetaBitBiInt(
                            BlockHexoriumPressurePlate.META_SETTING_0, 
                            BlockHexoriumPressurePlate.META_SETTING_1, world, x, y, z);

                    // Print message about change.
                    if (setting == 0)
                        player.addChatMessage(new ChatComponentTranslation("msg.pressurePlateChange1.txt"));
                    if (setting == 1)
                        player.addChatMessage(new ChatComponentTranslation("msg.pressurePlateChange2.txt"));
                    if (setting == 2)
                        player.addChatMessage(new ChatComponentTranslation("msg.pressurePlateChange3.txt"));
                    if (setting == 3)
                        player.addChatMessage(new ChatComponentTranslation("msg.pressurePlateChange4.txt"));
                }
                
                // Rotate Pylon Base away from player.
                else if (block instanceof BlockPylonBase) {
                    // Rotate meta
                    int orientation;
                    if (player.rotationPitch > 60.0F)
                        // If player is looking up.
                        orientation = 0;
                    else if (player.rotationPitch < -60.0F)
                        // If player is looking down.
                        orientation = 1;
                    else {
                        orientation = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
                        // If player is looking towards NSWE.
                        if (orientation == 0)
                            orientation = 3;
                        else if (orientation == 1)
                            orientation = 4;
                        else if (orientation == 2)
                            orientation = 2;
                        else if (orientation == 3)
                            orientation = 5;
                    }

                    HexUtils.setMetaBitTriInt(
                            BlockPylonBase.META_ORIENTATION_0,
                            BlockPylonBase.META_ORIENTATION_1,
                            BlockPylonBase.META_ORIENTATION_2,
                            orientation, HexUtils.META_NOTIFY_UPDATE, world, x, y, z);

                    analyzePylonBase(world, x, y, z);
                }
                
                // Check if block is part of tank.
                else if (block instanceof HexBlockMT || block == HexBlocks.blockTemperedHexoriumGlass) {
                    if (HexUtils.getMetaBit(BlockTankValve.META_IS_PART, world, x, y, z))
                        player.addChatMessage(new ChatComponentTranslation("msg.tankIsPart.txt"));
                }

                // Rotate Tank Valve.
                else if (block == HexBlocks.blockTankValve) {
                    if (!HexUtils.getMetaBit(BlockTankValve.META_IS_PART, world, x, y, z))
                        HexUtils.flipMetaBit(BlockTankValve.META_ROTATION, HexUtils.META_NOTIFY_UPDATE, world, x, y, z);
                    else
                        player.addChatMessage(new ChatComponentTranslation("msg.tankValveRotationFail.txt"));
                }
            }
            
            // Fired on normal use.
            else {

                // Link Energy Pylons.
                if (block == HexBlocks.blockEnergyPylon) {
                    // Create a new tag compound for the manipulator if it doesn't exist.
                    if (stack.stackTagCompound == null)
                        stack.stackTagCompound = new NBTTagCompound();

                    // Cancel linking.
                    if (stack.stackTagCompound.getBoolean(NBT_TELEPORT_LINKING)) {
                        stack.stackTagCompound.setBoolean(NBT_TELEPORT_LINKING, false);
                        stack.setItemDamage(0);
                        player.addChatMessage(new ChatComponentTranslation("msg.teleportLinkCancel.txt"));
                    }
                    // If this is the first use, just save the pylon location.
                    if (!stack.stackTagCompound.getBoolean(NBT_PYLON_LINKING)) {
                        stack.stackTagCompound.setInteger(NBT_PYLON_X, x);
                        stack.stackTagCompound.setInteger(NBT_PYLON_Y, y);
                        stack.stackTagCompound.setInteger(NBT_PYLON_Z, z);
                        stack.stackTagCompound.setBoolean(NBT_PYLON_LINKING, true);
                        stack.setItemDamage(1);
                        player.addChatMessage(new ChatComponentTranslation("msg.pylonLinkStart.txt"));
                    }
                    // If this is the second use, perform linking.
                    else {
                        // Retrieve previous pylon.
                        int tx = stack.stackTagCompound.getInteger(NBT_PYLON_X);
                        int ty = stack.stackTagCompound.getInteger(NBT_PYLON_Y);
                        int tz = stack.stackTagCompound.getInteger(NBT_PYLON_Z);

                        if (!(tx == x && ty == y && tz == z)) {
                            // Determine length of the link.
                            double len = Vec3.createVectorHelper(tx, ty, tz).subtract(Vec3.createVectorHelper(x, y, z)).lengthVector();

                            // Perform ray tracing, if success, proceed.
                            if (TileEnergyPylon.tracePylons(world, x, y, z, tx, ty, tz)) {

                                // Check if pylons are within reach.
                                if (len <= HexConfig.cfgGeneralPylonRange) {

                                    // Fetch tile entities of pylons.
                                    TileEnergyPylon pylonA = (TileEnergyPylon) world.getTileEntity(x, y, z);
                                    TileEnergyPylon pylonB = (TileEnergyPylon) world.getTileEntity(tx, ty, tz);

                                    // Make sure they are not null.
                                    if (pylonA != null && pylonB != null) {

                                        // Check if the color combinations are okay.
                                        int monolithA = pylonA.getMonolith();
                                        int monolithB = pylonB.getMonolith();
                                        if ((monolithA != 0 && monolithB != 0) && (monolithA == 18 || monolithB == 18 || monolithA == monolithB)) {

                                            // Try to add pylons.
                                            if (pylonA.addPylon(tx, ty, tz, false) && pylonB.addPylon(x, y, z, true)) {
                                                // If the pylons are not added yet, link them.
                                                player.addChatMessage(new ChatComponentTranslation("msg.pylonLinkSuccess.txt"));

                                                // Grant player the achievement.
                                                if (HexConfig.cfgGeneralUseAchievements && player instanceof EntityPlayerMP) {
                                                    EntityPlayerMP playerMP = (EntityPlayerMP) player;
                                                    if (playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftManipulator))
                                                        player.addStat(HexAchievements.achLinkPylon, 1);
                                                }

                                                if (HexConfig.cfgGeneralNetworkDebug)
                                                    System.out.println("[Hexorium Manipulator]: Pylons linked, analyzing!");

                                                /* DO ANALYSIS */
                                                // Prepare the network analyzer.
                                                NetworkAnalyzer analyzer = new NetworkAnalyzer();
                                                // Call the analysis.
                                                analyzer.analyzePylon(world, tx, ty, tz, HexBlocks.blockEnergyPylon);
                                            }
                                            else {
                                                // If the pylons were already added, unlink them.
                                                pylonA.removePylon(tx, ty, tz);
                                                pylonB.removePylon(x, y, z);
                                                player.addChatMessage(new ChatComponentTranslation("msg.pylonLinkBreak.txt"));
                                            }
                                            // Error messages for all situations.
                                        }
                                        else
                                            player.addChatMessage(new ChatComponentTranslation("msg.pylonLinkFail1.txt"));
                                    }
                                    else
                                        player.addChatMessage(new ChatComponentTranslation("msg.pylonLinkFail2.txt"));
                                }
                                else
                                    player.addChatMessage(new ChatComponentTranslation("msg.pylonLinkFail3.txt"));
                            }
                            else
                                player.addChatMessage(new ChatComponentTranslation("msg.pylonLinkFail4.txt"));

                            stack.stackTagCompound.setBoolean(NBT_PYLON_LINKING, false);
                            stack.setItemDamage(0);
                        }
                        else {
                            player.addChatMessage(new ChatComponentTranslation("msg.pylonLinkCancel.txt"));
                            stack.stackTagCompound.setBoolean(NBT_PYLON_LINKING, false);
                            stack.setItemDamage(0);
                        }
                    }
                }

                // Link Teleports.
                else if (block == HexBlocks.blockPersonalTeleportationPad) {
                    // Create a new tag compound for the manipulator if it doesn't exist.
                    if (stack.stackTagCompound == null)
                        stack.stackTagCompound = new NBTTagCompound();

                    // Cancel linking.
                    if (stack.stackTagCompound.getBoolean(NBT_PYLON_LINKING)) {
                        stack.stackTagCompound.setBoolean(NBT_PYLON_LINKING, false);
                        stack.setItemDamage(0);
                        player.addChatMessage(new ChatComponentTranslation("msg.pylonLinkCancel.txt"));
                    }

                    // If this is the first use, just save the teleport location.
                    if (!stack.stackTagCompound.getBoolean(NBT_TELEPORT_LINKING)) {
                        stack.stackTagCompound.setInteger(NBT_TELEPORT_X, x);
                        stack.stackTagCompound.setInteger(NBT_TELEPORT_Y, y);
                        stack.stackTagCompound.setInteger(NBT_TELEPORT_Z, z);
                        stack.stackTagCompound.setBoolean(NBT_TELEPORT_LINKING, true);
                        stack.setItemDamage(1);
                        player.addChatMessage(new ChatComponentTranslation("msg.teleportLinkStart.txt"));
                    }
                    // If this is the second use, perform linking.
                    else {
                        // Retrieve previous teleport.
                        int tx = stack.stackTagCompound.getInteger(NBT_TELEPORT_X);
                        int ty = stack.stackTagCompound.getInteger(NBT_TELEPORT_Y);
                        int tz = stack.stackTagCompound.getInteger(NBT_TELEPORT_Z);

                        if (!(tx == x && ty == y && tz == z)) {
                            // Fetch tile entities of teleports.
                            TilePersonalTeleportationPad teleportA = (TilePersonalTeleportationPad) world.getTileEntity(x, y, z);
                            TilePersonalTeleportationPad teleportB = (TilePersonalTeleportationPad) world.getTileEntity(tx, ty, tz);

                            if (!(teleportA.checkLinked(tx, ty, tz) && teleportB.checkLinked(x, y, z))) {
                                if (teleportA.checkConnectivity(tx, ty, tz) && teleportB.checkConnectivity(x, y, z)) {
                                    if (teleportA.linkTeleport(tx, ty, tz) && teleportB.linkTeleport(x, y, z)) {
                                        player.addChatMessage(new ChatComponentTranslation("msg.teleportLinkSuccess.txt"));

                                        // Grant player the achievement.
                                        if (HexConfig.cfgGeneralUseAchievements && player instanceof EntityPlayerMP) {
                                            EntityPlayerMP playerMP = (EntityPlayerMP) player;
                                            if (playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftManipulator) && HexConfig.cfgTeleportEnable)
                                                player.addStat(HexAchievements.achLinkTeleport, 1);
                                        }
                                    }
                                    else
                                        player.addChatMessage(new ChatComponentTranslation("msg.teleportLinkFail1.txt"));
                                }
                                else
                                    player.addChatMessage(new ChatComponentTranslation("msg.teleportLinkFail2.txt"));
                            }
                            else {
                                player.addChatMessage(new ChatComponentTranslation("msg.teleportLinkBreak.txt"));
                                teleportA.unlinkTeleport();
                                teleportB.unlinkTeleport();
                            }

                            stack.stackTagCompound.setBoolean(NBT_TELEPORT_LINKING, false);
                            stack.setItemDamage(0);
                        }
                        else {
                            player.addChatMessage(new ChatComponentTranslation("msg.teleportLinkCancel.txt"));
                            stack.stackTagCompound.setBoolean(NBT_TELEPORT_LINKING, false);
                            stack.setItemDamage(0);
                        }
                    }
                }

                // Rotate machines.
                else if (block == HexBlocks.blockHexoriumGenerator ||
                        block == HexBlocks.blockHexoriumFurnace ||
                        block == HexBlocks.blockCrystalSeparator ||
                        block == HexBlocks.blockMatrixReconstructor) {
                    // Get meta.
                    int metaOld = world.getBlockMetadata(x, y, z);

                    // Rotate meta
                    HexUtils.rotateBlock(HexBlocks.META_MACHINE_ROTATION_0, HexBlocks.META_MACHINE_ROTATION_1, true,
                            HexUtils.META_NOTIFY_UPDATE, world, x, y, z);

                    if (HexConfig.cfgGeneralNetworkDebug)
                        System.out.println("[Hexorium Manipulator]: Machine rotated, analyzing!");

                    /* DO ANALYSIS */
                    // Prepare the network analyzers.
                    NetworkAnalyzer analyzerOld = new NetworkAnalyzer();
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    // Call the analysis in original and new direction.
                    analyzerOld.analyzeMachines(world, x, y, z, metaOld);
                    analyzer.analyzeMachines(world, x, y, z, world.getBlockMetadata(x, y, z));
                }

                // Show Pressure Plate mode.
                else if (block instanceof BlockHexoriumPressurePlate) {
                    // Get block meta and normalize it.
                    int setting = HexUtils.getMetaBitBiInt(
                            BlockHexoriumPressurePlate.META_SETTING_0,
                            BlockHexoriumPressurePlate.META_SETTING_1, world, x, y, z);

                    // Print message about mode.
                    if (setting == 0)
                        player.addChatMessage(new ChatComponentTranslation("msg.pressurePlateState1.txt"));
                    if (setting == 1)
                        player.addChatMessage(new ChatComponentTranslation("msg.pressurePlateState2.txt"));
                    if (setting == 2)
                        player.addChatMessage(new ChatComponentTranslation("msg.pressurePlateState3.txt"));
                    if (setting == 3)
                        player.addChatMessage(new ChatComponentTranslation("msg.pressurePlateState4.txt"));
                    player.addChatMessage(new ChatComponentTranslation("msg.pressurePlateSneak.txt"));
                }

                // Rotate Pylon Base.
                else if (block instanceof BlockPylonBase) {
                    // Rotate meta
                    int orientation;
                    if (player.rotationPitch > 60.0F)
                        // If player is looking up.
                        orientation = 1;
                    else if (player.rotationPitch < -60.0F)
                        // If player is looking down.
                        orientation = 0;
                    else {
                        orientation = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
                        // If player is looking towards NSWE.
                        if (orientation == 0)
                            orientation = 2;
                        else if (orientation == 1)
                            orientation = 5;
                        else if (orientation == 2)
                            orientation = 3;
                        else if (orientation == 3)
                            orientation = 4;
                    }

                    HexUtils.setMetaBitTriInt(
                            BlockPylonBase.META_ORIENTATION_0,
                            BlockPylonBase.META_ORIENTATION_1,
                            BlockPylonBase.META_ORIENTATION_2,
                            orientation, HexUtils.META_NOTIFY_UPDATE, world, x, y, z);

                    analyzePylonBase(world, x, y, z);
                }

                // Form Hexorium Tank.
                else if (block == HexBlocks.blockTankValve) {
                    if (!HexUtils.getMetaBit(BlockTankValve.META_IS_PART, world, x, y, z)) {
                        TileTankValve tileTankValve = (TileTankValve) world.getTileEntity(x, y, z);
                        if (tileTankValve != null) {
                            if (tileTankValve.setupMultiTank(side)) {
                                player.addChatMessage(new ChatComponentTranslation("msg.tankFormSuccess.txt"));
                                // Grant player the achievement.
                                if (HexConfig.cfgGeneralUseAchievements && player instanceof EntityPlayerMP) {
                                    EntityPlayerMP playerMP = (EntityPlayerMP) player;
                                    if (playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftManipulator) && HexConfig.cfgTankEnable)
                                        player.addStat(HexAchievements.achFormHexoriumTank, 1);
                                }
                            }
                            else
                                player.addChatMessage(new ChatComponentTranslation("msg.tankFormFail1.txt"));
                        }
                    }
                    else
                        player.addChatMessage(new ChatComponentTranslation("msg.tankFormFail2.txt"));
                }

                // Form Energy Node.
                else if (block instanceof IBlockHexEnergyPort) {
                    if (!HexUtils.getMetaBit(BlockEnergyNodeCore.META_IS_PART, world, x, y, z)) {
                        if (BlockEnergyNodeCore.setupEnergyNode(side, world, x, y, z))
                            player.addChatMessage(new ChatComponentTranslation("msg.energyNodeFormSuccess.txt"));
                        else
                            player.addChatMessage(new ChatComponentTranslation("msg.energyNodeFormFail1.txt"));
                    }
                    else
                        player.addChatMessage(new ChatComponentTranslation("msg.energyNodeFormFail2.txt"));
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
                // Create a new tag compound for the manipulator if it doesn't exist.
                if (stack.stackTagCompound == null)
                    stack.stackTagCompound = new NBTTagCompound();
                // Cancel all linking.
                if (stack.stackTagCompound.getBoolean(NBT_TELEPORT_LINKING)) {
                    stack.stackTagCompound.setBoolean(NBT_TELEPORT_LINKING, false);
                    stack.setItemDamage(0);
                    player.addChatMessage(new ChatComponentTranslation("msg.teleportLinkCancel.txt"));
                }
                if (stack.stackTagCompound.getBoolean(NBT_PYLON_LINKING)) {
                    stack.stackTagCompound.setBoolean(NBT_PYLON_LINKING, false);
                    stack.setItemDamage(0);
                    player.addChatMessage(new ChatComponentTranslation("msg.pylonLinkCancel.txt"));
                }
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
        icon = new IIcon[2];

        // Load all the different icons.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "A");
        icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "B");
    }

    /**
     * Gets an icon index based on an item's damage value.
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int damage) {
        if (damage == 0)
            return icon[0];
        else
            return icon[1];
    }

    /**
     * Called to analyze blocks around a Pylon Base.
     */
    private void analyzePylonBase(World world, int x, int y, int z) {

        if (HexConfig.cfgGeneralNetworkDebug)
            System.out.println("[Hexorium Manipulator]: Base rotated, analyzing!");

        /* DO ANALYSIS */

        // Perform an analysis in all directions around the base.
        Block blockSurr = world.getBlock(x, y - 1, z);
        if (blockSurr instanceof BlockHexoriumCable ||
                blockSurr instanceof BlockPylonBase) {
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            analyzer.analyzeCable(world, x, y - 1, z, blockSurr);
        }
        else if (blockSurr == HexBlocks.blockHexoriumGenerator ||
                blockSurr == HexBlocks.blockHexoriumFurnace ||
                blockSurr == HexBlocks.blockCrystalSeparator ||
                blockSurr == HexBlocks.blockMatrixReconstructor) {
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            analyzer.analyzeMachines(world, x, y - 1, z, world.getBlockMetadata(x, y - 1, z));
        }
        else if (blockSurr == HexBlocks.blockEnergyPylon) {
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            analyzer.analyzePylon(world, x, y - 1, z, blockSurr);
        }

        blockSurr = world.getBlock(x, y + 1, z);
        if (blockSurr instanceof BlockHexoriumCable ||
                blockSurr instanceof BlockPylonBase) {
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            analyzer.analyzeCable(world, x, y + 1, z, blockSurr);
        }
        else if (blockSurr == HexBlocks.blockHexoriumGenerator ||
                blockSurr == HexBlocks.blockHexoriumFurnace ||
                blockSurr == HexBlocks.blockCrystalSeparator ||
                blockSurr == HexBlocks.blockMatrixReconstructor) {
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            analyzer.analyzeMachines(world, x, y + 1, z, world.getBlockMetadata(x, y + 1, z));
        }
        else if (blockSurr == HexBlocks.blockEnergyPylon) {
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            analyzer.analyzePylon(world, x, y + 1, z, blockSurr);
        }

        blockSurr = world.getBlock(x - 1, y, z);
        if (blockSurr instanceof BlockHexoriumCable ||
                blockSurr instanceof BlockPylonBase) {
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            analyzer.analyzeCable(world, x - 1, y, z, blockSurr);
        }
        else if (blockSurr == HexBlocks.blockHexoriumGenerator ||
                blockSurr == HexBlocks.blockHexoriumFurnace ||
                blockSurr == HexBlocks.blockCrystalSeparator ||
                blockSurr == HexBlocks.blockMatrixReconstructor) {
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            analyzer.analyzeMachines(world, x - 1, y, z, world.getBlockMetadata(x - 1, y, z));
        }
        else if (blockSurr == HexBlocks.blockEnergyPylon) {
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            analyzer.analyzePylon(world, x - 1, y, z, blockSurr);
        }

        blockSurr = world.getBlock(x + 1, y, z);
        if (blockSurr instanceof BlockHexoriumCable ||
                blockSurr instanceof BlockPylonBase) {
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            analyzer.analyzeCable(world, x + 1, y, z, blockSurr);
        }
        else if (blockSurr == HexBlocks.blockHexoriumGenerator ||
                blockSurr == HexBlocks.blockHexoriumFurnace ||
                blockSurr == HexBlocks.blockCrystalSeparator ||
                blockSurr == HexBlocks.blockMatrixReconstructor) {
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            analyzer.analyzeMachines(world, x + 1, y, z, world.getBlockMetadata(x + 1, y, z));
        }
        else if (blockSurr == HexBlocks.blockEnergyPylon) {
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            analyzer.analyzePylon(world, x + 1, y, z, blockSurr);
        }

        blockSurr = world.getBlock(x, y, z - 1);
        if (blockSurr instanceof BlockHexoriumCable ||
                blockSurr instanceof BlockPylonBase) {
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            analyzer.analyzeCable(world, x, y, z - 1, blockSurr);
        }
        else if (blockSurr == HexBlocks.blockHexoriumGenerator ||
                blockSurr == HexBlocks.blockHexoriumFurnace ||
                blockSurr == HexBlocks.blockCrystalSeparator ||
                blockSurr == HexBlocks.blockMatrixReconstructor) {
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            analyzer.analyzeMachines(world, x, y, z - 1, world.getBlockMetadata(x, y, z - 1));
        }
        else if (blockSurr == HexBlocks.blockEnergyPylon) {
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            analyzer.analyzePylon(world, x, y, z - 1, blockSurr);
        }

        blockSurr = world.getBlock(x, y, z + 1);
        if (blockSurr instanceof BlockHexoriumCable ||
                blockSurr instanceof BlockPylonBase) {
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            analyzer.analyzeCable(world, x, y, z + 1, blockSurr);
        }
        else if (blockSurr == HexBlocks.blockHexoriumGenerator ||
                blockSurr == HexBlocks.blockHexoriumFurnace ||
                blockSurr == HexBlocks.blockCrystalSeparator ||
                blockSurr == HexBlocks.blockMatrixReconstructor) {
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            analyzer.analyzeMachines(world, x, y, z + 1, world.getBlockMetadata(x, y, z + 1));
        }
        else if (blockSurr == HexBlocks.blockEnergyPylon) {
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            analyzer.analyzePylon(world, x, y, z + 1, blockSurr);
        }
    }
}
