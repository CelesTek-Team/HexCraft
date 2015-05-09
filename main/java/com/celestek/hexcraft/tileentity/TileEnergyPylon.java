package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.block.BlockEnergyPylon;
import com.celestek.hexcraft.init.HexBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-25
 */
public class TileEnergyPylon extends TileEntity {

    public int monolith = 0;

    /**
     * Reads the tags from NBT.
     */
    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);

        monolith = tagCompound.getInteger("Monolith");
    }

    /**
     * Writes the tags to NBT.
     */
    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);

        tagCompound.setInteger("Monolith", monolith);
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        this.writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
        readFromNBT(packet.func_148857_g());
    }

    /**
     * Fired on every tick. Main processing is done here.
     */
    @Override
    public void updateEntity() {
        // Confirm that this is server side.
        if (!worldObj.isRemote) {
        }
    }

    public boolean insertMonolith(EntityPlayer player) {
        if (player.getCurrentEquippedItem() != null && monolith == 0) {
            Block block = Block.getBlockFromItem(player.getCurrentEquippedItem().getItem());

            if (block == HexBlocks.blockEnergizedHexoriumMonolithRed)
                monolith = 1;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithOrange)
                monolith = 2;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithYellow)
                monolith = 3;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithLime)
                monolith = 4;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithGreen)
                monolith = 5;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithTurquoise)
                monolith = 6;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithCyan)
                monolith = 7;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithSkyBlue)
                monolith = 8;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithBlue)
                monolith = 9;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithPurple)
                monolith = 10;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithMagenta)
                monolith = 11;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithPink)
                monolith = 12;

            else if (block == HexBlocks.blockEnergizedHexoriumMonolithWhite)
                monolith = 13;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithLightGray)
                monolith = 14;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithGray)
                monolith = 15;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithDarkGray)
                monolith = 16;
            else if (block == HexBlocks.blockEnergizedHexoriumMonolithBlack)
                monolith = 17;

            else if (block == HexBlocks.blockEnergizedHexoriumMonolithRainbow)
                monolith = 18;

            if (monolith != 0) {

                ItemStack stack = player.getCurrentEquippedItem();
                stack.stackSize--;

                if (stack.stackSize == 0)
                    stack = null;

                player.inventory.setInventorySlotContents(player.inventory.currentItem, stack);

                worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);

                return true;
            }
        }

        return false;
    }
}
