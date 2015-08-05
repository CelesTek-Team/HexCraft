package com.celestek.hexcraft.item;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.*;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.tileentity.TileEnergyPylon;
import com.celestek.hexcraft.tileentity.TilePersonalTeleportationPad;
import com.celestek.hexcraft.util.NetworkAnalyzer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IIcon;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.6.0
 * @since 2015-04-15
 */

public class ItemHexoriumManipulator extends Item {

    // Set default item name.
    public static String UNLOCALISEDNAME = "itemHexoriumManipulator";

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
        // Check if this is the server thread.
        if (!world.isRemote) {
            // Get the block.
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
                    // Get meta.
                    int meta = world.getBlockMetadata(x, y, z);
                    int metaOld = world.getBlockMetadata(x, y, z);

                    // Rotate meta
                    if (meta < 4) {
                        meta++;
                        if (meta == 4)
                            meta = 0;
                    }
                    else if (meta >= 4 && meta < 8) {
                        meta++;
                        if (meta == 8)
                            meta = 4;
                    }
                    else if (meta >= 8) {
                        meta++;
                        if (meta == 12)
                            meta = 8;
                    }

                    // Push meta to block.
                    world.setBlockMetadataWithNotify(x, y, z, meta, 2);

                    // System.out.println("Teleport rotated, analyzing!");

                    /* DO ANALYSIS */
                    // Prepare the network analyzers.
                    NetworkAnalyzer analyzerOld = new NetworkAnalyzer();
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    NetworkAnalyzer analyzerDown = new NetworkAnalyzer();
                    // Call the analysis in original and new direction.
                    analyzerOld.analyzeMachine(world, x, y, z, metaOld);
                    analyzer.analyzeMachine(world, x, y, z, meta);
                    analyzerDown.analyzeTeleport(world, x, y, z);
                }
                // Change Pressure Plate mode.
                else if (block instanceof BlockHexoriumPressurePlate) {
                    // Get block meta and normalize it.
                    int meta = world.getBlockMetadata(x, y, z);
                    int meta1;
                    if (meta > 3)
                        meta1 = meta - 4;
                    else
                        meta1 = meta;

                    // Change meta accordingly.
                    if (meta1 < 3)
                        world.setBlockMetadataWithNotify(x, y, z, meta + 1, 3);
                    else
                        world.setBlockMetadataWithNotify(x, y, z, meta - 3, 3);

                    // Print message about change.
                    if (meta1 == 0)
                        player.addChatMessage(new ChatComponentTranslation("msg.pressurePlateChange2.txt"));
                    if (meta1 == 1)
                        player.addChatMessage(new ChatComponentTranslation("msg.pressurePlateChange3.txt"));
                    if (meta1 == 2)
                        player.addChatMessage(new ChatComponentTranslation("msg.pressurePlateChange4.txt"));
                    if (meta1 == 3)
                        player.addChatMessage(new ChatComponentTranslation("msg.pressurePlateChange1.txt"));
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
                    if (stack.stackTagCompound.getBoolean("TeleportLinking")) {
                        stack.stackTagCompound.setBoolean("TeleportLinking", false);
                        stack.setItemDamage(0);
                        player.addChatMessage(new ChatComponentTranslation("msg.teleportLinkCancel.txt"));
                    }
                    // If this is the first use, just save the pylon location.
                    if (!stack.stackTagCompound.getBoolean("PylonLinking")) {
                        stack.stackTagCompound.setInteger("PylonX", x);
                        stack.stackTagCompound.setInteger("PylonY", y);
                        stack.stackTagCompound.setInteger("PylonZ", z);
                        stack.stackTagCompound.setBoolean("PylonLinking", true);
                        stack.setItemDamage(1);
                        player.addChatMessage(new ChatComponentTranslation("msg.pylonLinkStart.txt"));
                    }
                    // If this is the second use, perform linking.
                    else {
                        // Retrieve previous pylon.
                        int tx = stack.stackTagCompound.getInteger("PylonX");
                        int ty = stack.stackTagCompound.getInteger("PylonY");
                        int tz = stack.stackTagCompound.getInteger("PylonZ");

                        if (!(tx == x && ty == y && tz == z)) {
                            // Determine length of the link.
                            double len = Vec3.createVectorHelper(tx, ty, tz).subtract(Vec3.createVectorHelper(x, y, z)).lengthVector();

                            // Perform ray tracing, if success, proceed.
                            if (TileEnergyPylon.tracePylons(world, x, y, z, tx, ty, tz)) {

                                // Check if pylons are within reach.
                                if (len <= 32) {

                                    // Fetch tile entities of pylons.
                                    TileEnergyPylon pylonA = (TileEnergyPylon) world.getTileEntity(x, y, z);
                                    TileEnergyPylon pylonB = (TileEnergyPylon) world.getTileEntity(tx, ty, tz);

                                    // Make sure they are not null.
                                    if (pylonA != null && pylonB != null) {

                                        // Check if the color combinations are okay.
                                        if ((pylonA.monolith != 0 && pylonB.monolith != 0) && (pylonA.monolith == 18 || pylonB.monolith == 18 || pylonA.monolith == pylonB.monolith)) {

                                            // Try to add pylons.
                                            if (pylonA.addPylon(tx, ty, tz, false) && pylonB.addPylon(x, y, z, true)) {
                                                // If the pylons are not added yet, link them.
                                                player.addChatMessage(new ChatComponentTranslation("msg.pylonLinkSuccess.txt"));

                                                // System.out.println("Pylons linked, analyzing!");

                                             /* DO ANALYSIS */
                                                // Prepare the network analyzer.
                                                NetworkAnalyzer analyzer = new NetworkAnalyzer();
                                                // Call the analysis.
                                                analyzer.analyzePylon(world, tx, ty, tz, HexBlocks.blockEnergyPylon);
                                            } else {
                                                // If the pylons were already added, unlink them.
                                                pylonA.removePylon(tx, ty, tz);
                                                pylonB.removePylon(x, y, z);
                                                player.addChatMessage(new ChatComponentTranslation("msg.pylonLinkBreak.txt"));
                                            }
                                            // Error messages for all situations.
                                        } else
                                            player.addChatMessage(new ChatComponentTranslation("msg.pylonLinkFail1.txt"));
                                    } else
                                        player.addChatMessage(new ChatComponentTranslation("msg.pylonLinkFail2.txt"));
                                } else
                                    player.addChatMessage(new ChatComponentTranslation("msg.pylonLinkFail3.txt"));
                            } else
                                player.addChatMessage(new ChatComponentTranslation("msg.pylonLinkFail4.txt"));

                            stack.stackTagCompound.setBoolean("PylonLinking", false);
                            stack.setItemDamage(0);
                        }
                        else {
                            player.addChatMessage(new ChatComponentTranslation("msg.pylonLinkCancel.txt"));
                            stack.stackTagCompound.setBoolean("PylonLinking", false);
                            stack.setItemDamage(0);
                        }
                    }

                    // System.out.println("Block: (" + x + ", " + y + ", " + z + "), Linking: " + stack.stackTagCompound.getBoolean("linking"));
                }
                // Link Teleports.
                else if (block == HexBlocks.blockPersonalTeleportationPad) {
                    // Create a new tag compound for the manipulator if it doesn't exist.
                    if (stack.stackTagCompound == null)
                        stack.stackTagCompound = new NBTTagCompound();

                    // Cancel linking.
                    if (stack.stackTagCompound.getBoolean("PylonLinking")) {
                        stack.stackTagCompound.setBoolean("PylonLinking", false);
                        stack.setItemDamage(0);
                        player.addChatMessage(new ChatComponentTranslation("msg.pylonLinkCancel.txt"));
                    }

                    // If this is the first use, just save the teleport location.
                    if (!stack.stackTagCompound.getBoolean("TeleportLinking")) {
                        stack.stackTagCompound.setInteger("TeleportX", x);
                        stack.stackTagCompound.setInteger("TeleportY", y);
                        stack.stackTagCompound.setInteger("TeleportZ", z);
                        stack.stackTagCompound.setBoolean("TeleportLinking", true);
                        stack.setItemDamage(1);
                        player.addChatMessage(new ChatComponentTranslation("msg.teleportLinkStart.txt"));
                    }
                    // If this is the second use, perform linking.
                    else {
                        // Retrieve previous teleport.
                        int tx = stack.stackTagCompound.getInteger("TeleportX");
                        int ty = stack.stackTagCompound.getInteger("TeleportY");
                        int tz = stack.stackTagCompound.getInteger("TeleportZ");

                        if (!(tx == x && ty == y && tz == z)) {
                            // Fetch tile entities of teleports.
                            TilePersonalTeleportationPad teleportA = (TilePersonalTeleportationPad) world.getTileEntity(x, y, z);
                            TilePersonalTeleportationPad teleportB = (TilePersonalTeleportationPad) world.getTileEntity(tx, ty, tz);

                            if (!(teleportA.checkLinked(tx, ty, tz) && teleportB.checkLinked(x, y, z))) {
                                if (teleportA.checkConnectivity(tx, ty, tz) && teleportB.checkConnectivity(x, y, z)) {
                                    if (teleportA.linkTeleport(tx, ty, tz) && teleportB.linkTeleport(x, y, z))
                                        player.addChatMessage(new ChatComponentTranslation("msg.teleportLinkSuccess.txt"));
                                    else
                                        player.addChatMessage(new ChatComponentTranslation("msg.teleportLinkFail1.txt"));
                                } else
                                    player.addChatMessage(new ChatComponentTranslation("msg.teleportLinkFail2.txt"));
                            } else {
                                player.addChatMessage(new ChatComponentTranslation("msg.teleportLinkBreak.txt"));
                                teleportA.unlinkTeleport();
                                teleportB.unlinkTeleport();
                            }

                            stack.stackTagCompound.setBoolean("TeleportLinking", false);
                            stack.setItemDamage(0);
                        }
                        else {
                            player.addChatMessage(new ChatComponentTranslation("msg.teleportLinkCancel.txt"));
                            stack.stackTagCompound.setBoolean("TeleportLinking", false);
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
                    int meta = world.getBlockMetadata(x, y, z);
                    int metaOld = world.getBlockMetadata(x, y, z);

                    // Rotate meta
                    if (meta < 4) {
                        meta++;
                        if (meta == 4)
                            meta = 0;
                    }
                    else if (meta >= 4 && meta < 8) {
                        meta++;
                        if (meta == 8)
                            meta = 4;
                    }
                    else if (meta >= 8) {
                        meta++;
                        if (meta == 12)
                            meta = 8;
                    }

                    // Push meta to block.
                    world.setBlockMetadataWithNotify(x, y, z, meta, 2);

                    // System.out.println("Machine rotated, analyzing!");

                    /* DO ANALYSIS */
                    // Prepare the network analyzers.
                    NetworkAnalyzer analyzerOld = new NetworkAnalyzer();
                    NetworkAnalyzer analyzer = new NetworkAnalyzer();
                    // Call the analysis in original and new direction.
                    analyzerOld.analyzeMachine(world, x, y, z, metaOld);
                    analyzer.analyzeMachine(world, x, y, z, meta);
                }
                // Show Pressure Plate mode.
                else if (block instanceof BlockHexoriumPressurePlate) {
                    // Get block meta and normalize it.
                    int meta = world.getBlockMetadata(x, y, z);
                    if (meta > 3)
                        meta = meta - 4;

                    // Print message about mode.
                    if (meta == 0)
                        player.addChatMessage(new ChatComponentTranslation("msg.pressurePlateState1.txt"));
                    if (meta == 1)
                        player.addChatMessage(new ChatComponentTranslation("msg.pressurePlateState2.txt"));
                    if (meta == 2)
                        player.addChatMessage(new ChatComponentTranslation("msg.pressurePlateState3.txt"));
                    if (meta == 3)
                        player.addChatMessage(new ChatComponentTranslation("msg.pressurePlateState4.txt"));
                    player.addChatMessage(new ChatComponentTranslation("msg.pressurePlateSneak.txt"));
                }
                // Rotate Pylon Vase.
                else if (block instanceof BlockPylonBase) {
                    // Get meta.
                    int meta = world.getBlockMetadata(x, y, z);

                    // Rotate meta
                    if (meta < 6) {
                        meta++;
                        if (meta == 6)
                            meta = 0;
                    }

                    world.setBlockMetadataWithNotify(x, y, z, meta, 2);

                    // System.out.println("Base rotated, analyzing!");

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
                        analyzer.analyzeMachine(world, x, y - 1, z, world.getBlockMetadata(x, y - 1, z));
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
                        analyzer.analyzeMachine(world, x, y + 1, z, world.getBlockMetadata(x, y + 1, z));
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
                        analyzer.analyzeMachine(world, x - 1, y, z, world.getBlockMetadata(x - 1, y, z));
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
                        analyzer.analyzeMachine(world, x + 1, y, z, world.getBlockMetadata(x + 1, y, z));
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
                        analyzer.analyzeMachine(world, x, y, z - 1, world.getBlockMetadata(x, y, z - 1));
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
                        analyzer.analyzeMachine(world, x, y, z + 1, world.getBlockMetadata(x, y, z + 1));
                    }
                    else if (blockSurr == HexBlocks.blockEnergyPylon) {
                        NetworkAnalyzer analyzer = new NetworkAnalyzer();
                        analyzer.analyzePylon(world, x, y, z + 1, blockSurr);
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
                // Cancel all linking.
                if (stack.stackTagCompound.getBoolean("TeleportLinking")) {
                    stack.stackTagCompound.setBoolean("TeleportLinking", false);
                    stack.setItemDamage(0);
                    player.addChatMessage(new ChatComponentTranslation("msg.teleportLinkCancel.txt"));
                }
                if (stack.stackTagCompound.getBoolean("PylonLinking")) {
                    stack.stackTagCompound.setBoolean("PylonLinking", false);
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
