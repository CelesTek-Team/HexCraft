package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.block.BlockEnergizedHexoriumMonolith;
import com.celestek.hexcraft.block.BlockEnergyPylon;
import com.celestek.hexcraft.block.IBlockHexColor;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.util.HexUtils;
import com.celestek.hexcraft.util.NetworkAnalyzer;
import com.celestek.hexcraft.util.HexPylon;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Iterator;

public class TileEnergyPylon extends TileEntity {

    /**** Static Values ****/

    public static final String ID = "tileEnergyPylon";

    // NBT Names
    private static final String NBT_PYLONS = "pylons";
    private static final String NBT_MONOLITH = "monolith";

    /**** Variables ****/

    // Prepare pylon list.
    private ArrayList<HexPylon> pylons;

    // Prepare monolith ID.
    private int monolith;

    // Prepare the tick counter and tick trigger.
    private int tickCount;
    private boolean firstTickClient;

    /**** Common TileEntity Methods ****/

    public TileEnergyPylon() {
        this.monolith = 0;

        this.tickCount = 0;
        this.firstTickClient = false;
    }

    /**
     * Writes the tags to NBT.
     */
    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);

        // Write the pylon list.
        HexUtils.writeHexPylonsArrayToNBT(tagCompound, NBT_PYLONS, pylons);

        // Write the monolith ID.
        tagCompound.setInteger(NBT_MONOLITH, monolith);
    }

    /**
     * Reads the tags from NBT.
     */
    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);

        // Write the pylon list.
        pylons = HexUtils.readHexPylonsArrayFromNBT(tagCompound, NBT_PYLONS);

        // Read the monolith ID.
        monolith = tagCompound.getInteger(NBT_MONOLITH);
    }

    /**
     * Sends the data packet.
     */
    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    /**
     * Receives the data packet.
     */
    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
        readFromNBT(packet.func_148857_g());
        // Prime the updateEntity() for a list rebuild.
        firstTickClient = true;
    }

    /**
     * Fired on every tick. Main processing is done here.
     */
    @Override
    public void updateEntity() {
        if (!worldObj.isRemote) {
            // Re-trace pylons every second.
            tickCount++;
            if (tickCount >= 20) {
                tickCount = 0;
                if (!HexUtils.getMetaBit(BlockEnergyPylon.META_STATE, worldObj, xCoord, yCoord, zCoord))
                    retracePylons();
            }
        }
        else {
            // If the list should be rebuilt, do it.
            if (firstTickClient) {
                for (HexPylon entry : pylons) {
                    worldObj.markBlockForUpdate(entry.x, entry.y, entry.z);
                    TileEntity tileEntity = worldObj.getTileEntity(entry.x, entry.y, entry.z);
                    if (tileEntity != null) {
                        tileEntity.markDirty();
                    }
                }

                // Prepare the block to update.
                worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
                markDirty();
                firstTickClient = false;
            }
        }
    }

    /**** Custom Methods ****/

    /**
     * Inserts a monolith in to the pylon.
     * @param player Player performing the inserting.
     */
    public boolean insertMonolith(EntityPlayer player) {
        // Check if the item in player's hand is not null and if there is no monolith already inserted.
        if (player.getCurrentEquippedItem() != null && monolith == 0) {
            Block block = Block.getBlockFromItem(player.getCurrentEquippedItem().getItem());

            if (block instanceof BlockEnergizedHexoriumMonolith)
                monolith = ((IBlockHexColor) block).getColor().ordinal() + 1;

            // If the monolith has successfully been inserted, decrement it from the hand.
            if (monolith != 0) {
                ItemStack stack = player.getCurrentEquippedItem();

                stack.stackSize--;
                if (stack.stackSize == 0)
                    stack = null;

                player.inventory.setInventorySlotContents(player.inventory.currentItem, stack);

                // Prepare the block to update.
                worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
                worldObj.notifyBlockChange(xCoord, yCoord, zCoord, null);
                markDirty();
                return true;
            }
        }
        return false;
    }

    /**
     * Ejects the monolith from the pylon.
     */
    public void ejectMonolith() {
        if (!worldObj.isRemote && monolith != 0) {

            // Unset the monolith and unlink all pylons.
            monolith = 0;
            clearPylons();

            // Prepare the block to update.
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            worldObj.notifyBlockChange(xCoord, yCoord, zCoord, null);
            markDirty();

            if (HexConfig.cfgGeneralNetworkDebug)
                System.out.println("[Energy Pylon] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Monolith ejected, analyzing!");

            /* DO ANALYSIS */
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            analyzer.analyzePylon(worldObj, xCoord, yCoord, zCoord, HexBlocks.getHexBlock(BlockEnergyPylon.ID));
        }
    }

    /**
     * Adds a new pylon to the list of linked pylons.
     * @param x Coordinate x of the pylon to add.
     * @param y Coordinate y of the pylon to add.
     * @param z Coordinate z of the pylon to add.
     * @param master If this pylon should be the one to check the pylon to add in future.
     */
    public boolean addPylon(int x, int y, int z, boolean master) {
        TileEnergyPylon energyPylon = (TileEnergyPylon) worldObj.getTileEntity(x, y, z);

        if (energyPylon != null) {
            if (pylons == null)
                pylons = new ArrayList<HexPylon>();

            // Check if the pylon already exists.
            for (HexPylon entry : pylons)
                if (entry.x == x && entry.y == y && entry.z == z)
                    // If it does, return false.
                    return false;

            // Otherwise, continue and add it to the list.
            pylons.add(new HexPylon(x, y, z, master));

            // Prepare the block to update.
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            markDirty();

            return true;
        }
        return false;
    }

    /**
     * Removes a pylon from the list of linked pylons.
     * @param x Coordinate x of the pylon to remove.
     * @param y Coordinate y of the pylon to remove.
     * @param z Coordinate z of the pylon to remove.
     */
    public void removePylon(int x, int y, int z) {

        if (pylons != null) {
            // Iterate through the list, and remove the pylon if it exists.
            Iterator<HexPylon> iterator = pylons.iterator();
            while (iterator.hasNext()) {
                HexPylon entry = iterator.next();
                if (entry.x == x && entry.y == y && entry.z == z)
                    iterator.remove();
            }

            // If the list is empty, make it null.
            if (pylons.size() == 0)
                pylons = null;

            // Prepare the block to update.
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            markDirty();
        }

        if (HexConfig.cfgGeneralNetworkDebug)
            System.out.println("[Energy Pylon] (" + x + ", " + y + ", " + z + "): Pylon unlinked, analyzing!");

        /* DO ANALYSIS */
        NetworkAnalyzer analyzer = new NetworkAnalyzer();
        analyzer.analyzePylon(worldObj, xCoord, yCoord, zCoord, HexBlocks.getHexBlock(BlockEnergyPylon.ID));
    }

    /**
     * Clears the whole pylon list.
     */
    public void clearPylons() {
        if (pylons != null) {
            // Go through every entry in the list, and send an instruction to remove this pylon from their list.
            for (HexPylon entry : pylons) {
                TileEnergyPylon tileEnergyPylon = (TileEnergyPylon) worldObj.getTileEntity(entry.x, entry.y, entry.z);
                if (tileEnergyPylon != null)
                    tileEnergyPylon.removePylon(xCoord, yCoord, zCoord);
            }
            pylons = null;
            markDirty();
        }
    }

    /**
     * Retraces the pylons.
     */
    private void retracePylons() {
        if (pylons != null) {
            ArrayList<HexPylon> remove = new ArrayList<HexPylon>();

            // Do a raytrace to each entry, if it is no longer reachable, add it to the list of pylons to remove.
            for (HexPylon entry : pylons)
                if (entry.master)
                    if (!TileEnergyPylon.tracePylons(worldObj, xCoord, yCoord, zCoord, entry.x, entry.y, entry.z))
                        remove.add(entry);

            // Remove all pylons in the main list using the removal list.
            for (HexPylon entry : remove) {
                TileEnergyPylon tileEnergyPylon = (TileEnergyPylon) worldObj.getTileEntity(entry.x, entry.y, entry.z);
                tileEnergyPylon.removePylon(xCoord, yCoord, zCoord);
                removePylon(entry.x, entry.y, entry.z);
            }

            if (remove.size() != 0) {
                if (HexConfig.cfgGeneralNetworkDebug)
                    System.out.println("[Energy Pylon] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Link interrupted, analyzing!");

                /* DO ANALYSIS */
                NetworkAnalyzer analyzer = new NetworkAnalyzer();
                analyzer.analyzePylon(worldObj, xCoord, yCoord, zCoord, HexBlocks.getHexBlock(BlockEnergyPylon.ID));
            }
        }
    }

    /**
     * Ray traces the pylons.
     * x y z: Starting pylon.
     * tx ty tz: Target pylon.
     */
    public static boolean tracePylons(World world, int x, int y, int z, int tx, int ty, int tz) {
        // If this is not the same pylon.
        if (!(tx == x && ty == y && tz == z)) {
            // Create start and end vectors.
            Vec3 vec1 = Vec3.createVectorHelper(x + 0.5, y + 0.5, z + 0.5);
            Vec3 vec2 = Vec3.createVectorHelper(tx + 0.5, ty + 0.5, tz + 0.5);

            // Do 4 ray traces from different positions. This eliminates errors.
            MovingObjectPosition hit1 = world.rayTraceBlocks(vec1.addVector(-0.01, 0, -0.01), vec2.addVector(-0.01, 0, -0.01), true);
            MovingObjectPosition hit2 = world.rayTraceBlocks(vec1.addVector(0.01, 0, -0.01), vec2.addVector(0.01, 0, -0.01), true);
            MovingObjectPosition hit3 = world.rayTraceBlocks(vec1.addVector(0.01, 0, 0.01), vec2.addVector(0.01, 0, 0.01), true);
            MovingObjectPosition hit4 = world.rayTraceBlocks(vec1.addVector(-0.01, 0, 0.01), vec2.addVector(-0.01, 0, 0.01), true);

            // Return true if all of the results are null (didn't hit anything along the way).
            return hit1 == null && hit2 == null && hit3 == null && hit4 == null;
        }
        return false;
    }

    /**
     * Called by Hexorium Probe to display tile entity info to chat.
     * @param player Player to show the message to.
     */
    public void displayInfoPylon(EntityPlayer player) {
        HexUtils.addChatProbeTitle(player);
        // If player is not sneaking.
        if (!player.isSneaking()) {
            HexUtils.addChatProbeGenericInfo(player, worldObj, xCoord, yCoord, zCoord);
            player.addChatMessage(new ChatComponentTranslation("msg.probeTypePylon.txt"));
            if(HexUtils.getMetaBit(BlockEnergyPylon.META_STATE, worldObj, xCoord, yCoord, zCoord))
                player.addChatMessage(new ChatComponentTranslation("msg.probePylonStatusOff.txt"));
            else
                player.addChatMessage(new ChatComponentTranslation("msg.probePylonStatusOn.txt"));
            if(pylons != null && pylons.size() != 0)
                player.addChatMessage(new ChatComponentTranslation("msg.probeLinkedYes.txt"));
            else
                player.addChatMessage(new ChatComponentTranslation("msg.probeLinkedNo.txt"));
        }
        // If player is sneaking.
        else {
            player.addChatMessage(new ChatComponentTranslation("msg.probeConnectedPylons.txt"));
            HexUtils.addChatProbeConnectedPylons(player, pylons, worldObj, xCoord, yCoord, zCoord);
        }
    }

    /**** Getters and Setters ****/

    public int getMonolith() {
        return this.monolith;
    }

    public ArrayList<HexPylon> getPylons() {
        return this.pylons;
    }
}
