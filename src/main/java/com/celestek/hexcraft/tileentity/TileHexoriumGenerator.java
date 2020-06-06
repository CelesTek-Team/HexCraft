package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.util.HexDevice;
import com.celestek.hexcraft.util.HexUtils;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;

import java.util.ArrayList;

public class TileHexoriumGenerator extends TileEntity implements ISidedInventory, ITileHexEnergySource {

    /**** Static Values ****/

    public static final String ID = "tileHexoriumGenerator";

    private static final String INVENTORY_NAME = "hexcraft.container.hexoriumGenerator";

    // NBT Names
    private static final String NBT_ENERGY_DRAINS = "energy_drains";

    private static final String NBT_ENERGY_TOTAL = "energy_total";
    private static final String NBT_ENERGY_TOTAL_LEFT = "energy_total_left";
    private static final String NBT_ENERGY_DRAINED = "energy_drained";

    private static final String NBT_GUI_ENERGY_TOTAL = "gui_energy_total";
    private static final String NBT_GUI_ENERGY_TOTAL_LEFT = "gui_energy_total_left";
    private static final String NBT_GUI_ENERGY_DRAINED = "gui_energy_drained";

    /**** Variables ****/

    // Float rounding epsilon.
    private static final float epsilon = 0.0001F;

    // Prepare sources list.
    private ArrayList<HexDevice> energyDrains;

    // Prepare energy variables.
    private final int energyPerTick;
    private float energyTotal;
    private float energyTotalLeft;
    private float energyDrained;

    // Prepare GUI energy variables.
    private int guiEnergyTotal;
    private int guiEnergyTotalLeft;
    private int guiEnergyDrained;

    // Define sides and slots.
    private static final int[] slotsSide = new int[] { 0 };
    private static final int[] slotsBlank = new int[] { 1 };
    private ItemStack[] inventory;

    /**** Common TileEntity Methods ****/

    public TileHexoriumGenerator() {

        this.energyPerTick = 32;
        this.energyTotal = 0;
        this.energyTotalLeft = 0;
        this.energyDrained = 0;

        this.guiEnergyTotal = 0;
        this.guiEnergyTotalLeft = 0;
        this.guiEnergyDrained = 0;

        this.inventory = new ItemStack[2];
    }

    /**
     * Writes the tags to NBT.
     */
    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);

        // Write the drains.
        HexUtils.writeHexDevicesArrayToNBT(tagCompound, NBT_ENERGY_DRAINS, energyDrains);

        // Write the energy variables.
        tagCompound.setFloat(NBT_ENERGY_TOTAL, energyTotal);
        tagCompound.setFloat(NBT_ENERGY_TOTAL_LEFT, energyTotalLeft);
        tagCompound.setFloat(NBT_ENERGY_DRAINED, energyDrained);

        // Write the GUI energy variables.
        tagCompound.setInteger(NBT_GUI_ENERGY_TOTAL, guiEnergyTotal);
        tagCompound.setInteger(NBT_GUI_ENERGY_TOTAL_LEFT, guiEnergyTotalLeft);
        tagCompound.setInteger(NBT_GUI_ENERGY_DRAINED, guiEnergyDrained);

        // Write the container.
        HexUtils.writeInventoryToNBT(tagCompound, inventory);
    }

    /**
     * Reads the tags from NBT.
     */
    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);

        // Read the drains.
        energyDrains = HexUtils.readHexDevicesArrayFromNBT(tagCompound, NBT_ENERGY_DRAINS);

        // Read the energy variables.
        energyTotal = tagCompound.getFloat(NBT_ENERGY_TOTAL);
        energyTotalLeft = tagCompound.getFloat(NBT_ENERGY_TOTAL_LEFT);
        energyDrained = tagCompound.getFloat(NBT_ENERGY_DRAINED);

        // Read the GUI energy variables.
        guiEnergyTotal = tagCompound.getInteger(NBT_GUI_ENERGY_TOTAL);
        guiEnergyTotalLeft = tagCompound.getInteger(NBT_GUI_ENERGY_TOTAL_LEFT);
        guiEnergyDrained = tagCompound.getInteger(NBT_GUI_ENERGY_DRAINED);

        // Read the container.
        inventory = HexUtils.readInventoryFromNBT(tagCompound, getSizeInventory());
    }

    /**
     * Fired on every tick. Main processing is done here.
     */
    @Override
    public void updateEntity() {
        if (!worldObj.isRemote) {
            // Will be set to true if there was no energy available on previous tick. This is used to call a source rescan.
            boolean recheck = energyTotal == 0;

            // Change the state to ACTIVE if energy started to be drained the previous tick.
            if (energyDrained > 0 && canDrainEnergy()
                    && HexBlocks.getMachineState(worldObj, xCoord, yCoord, zCoord) == HexBlocks.MACHINE_STATE_READY)
                HexBlocks.setMachineState(HexBlocks.MACHINE_STATE_ACTIVE, worldObj, xCoord, yCoord, zCoord);

            // Change the state to READY if energy was no longer being drained the previous tick, but still can be drained.
            else if (energyDrained == 0 && canDrainEnergy()
                    && HexBlocks.getMachineState(worldObj, xCoord, yCoord, zCoord) == HexBlocks.MACHINE_STATE_ACTIVE)
                HexBlocks.setMachineState(HexBlocks.MACHINE_STATE_READY, worldObj, xCoord, yCoord, zCoord);

            // Check if the energy is empty and if energy can be drained from the item.
            // This is fired either if there is a new item present or current one has burned out.
            if (energyTotalLeft <= 0 && canBurn(inventory[0])) {

                // Get the item burn time and multiply it with the energy. Save the results. The generator now has energy.
                energyTotal = energyTotalLeft = getItemBurnTime(inventory[0]) * energyPerTick;

                // If there are still items present, decrement the stack.
                consumeItem();

                // Change the state to ACTIVE if there was any energy drained previous tick and change the states appropriately.
                if (energyDrained > 0)
                    HexBlocks.setMachineState(HexBlocks.MACHINE_STATE_ACTIVE, worldObj, xCoord, yCoord, zCoord);
                // Change the state to READY otherwise.
                else
                    HexBlocks.setMachineState(HexBlocks.MACHINE_STATE_READY, worldObj, xCoord, yCoord, zCoord);

                // Send a recheck to all drains to update their sources count.
                if (recheck)
                    sendRecheck();
            }

            // Otherwise, check if the energy is empty and item can't burn.
            // This is fired when all items have burned out.
            else if (energyTotalLeft <= 0 && energyTotal > 0 && !canBurn(inventory[0])) {
                energyTotal = 0;
                // Set the DEAD state and send a recheck.
                HexBlocks.setMachineState(HexBlocks.MACHINE_STATE_DEAD, worldObj, xCoord, yCoord, zCoord);
                sendRecheck();
            }

            // Save the energy states to their GUI variables.
            guiEnergyTotal = Math.round(energyTotal);
            guiEnergyTotalLeft = Math.round(energyTotalLeft);
            guiEnergyDrained = Math.round(energyDrained);
            energyDrained = 0;
        }
    }

    /**** ITileHexEnergySource Methods ****/

    /**
     * Saves the ArrayList of energy drains.
     * @param energyDrains The ArrayList to save.
     */
    @Override
    public void setDrains(ArrayList<HexDevice> energyDrains) {
        this.energyDrains = energyDrains;
        if (HexConfig.cfgGeneralMachineNetworkDebug && HexConfig.cfgGeneralNetworkDebug)
            System.out.println("[Hexorium Generator] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Drains received. d: " + energyDrains.size());
        markDirty();
    }

    /**
     * Called by drains to check if they can drain energy.
     * @return Boolean if energy can be drained.
     */
    @Override
    public boolean canDrainEnergy() {
        return energyTotalLeft > 0;
    }

    /**
     * Called by drains to drain energy.
     * @param amount The amount of energy requested.
     * @return The amount of energy actually drained.
     */
    @Override
    public float drainEnergy(float amount) {
        if (canDrainEnergy()) {
            // If there is enough energy left this tick, return full requested energy to drain.
            if (energyDrained + amount < energyPerTick - epsilon) {
                energyTotalLeft = energyTotalLeft - amount;
                energyDrained = energyDrained + amount;
                if (HexConfig.cfgGeneralMachineNetworkDebug && HexConfig.cfgGeneralNetworkDebug)
                    System.out.println("[Hexorium Generator] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Drain requested. r: " + amount + " d(f): " + amount + " t: " + energyDrained);
                return amount;
            }
            // Otherwise, return only the remaining energy.
            else {
                float partial = energyPerTick - energyDrained;
                energyTotalLeft = energyTotalLeft - partial;
                energyDrained = energyPerTick;
                if (HexConfig.cfgGeneralMachineNetworkDebug && HexConfig.cfgGeneralNetworkDebug)
                    System.out.println("[Hexorium Generator] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Drain requested. r: " + amount + " d(p): " + partial + " t: " + energyDrained);
                return partial;
            }
        }
        // If the source cannot provide energy, return 0.
        else {
            if (HexConfig.cfgGeneralMachineNetworkDebug && HexConfig.cfgGeneralNetworkDebug)
                System.out.println("[Hexorium Generator] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Drain requested. r: " + amount + " d(n): " + 0 + " t: " + energyDrained);
            return 0;
        }
    }

    /**
     * Called by drains to determine the amount of energy available per tick.
     * @return The amount of energy available per tick.
     */
    @Override
    public float getEnergyPerTick() {
        return energyPerTick;
    }

    /**
     * Called by Hexorium Probe to display tile entity info to chat.
     * @param player Player to show the message to.
     */
    @Override
    public void displayInfoSource(EntityPlayer player) {
        HexUtils.addChatProbeTitle(player);
        // If player is not sneaking.
        if (!player.isSneaking()) {
            HexUtils.addChatProbeGenericInfo(player, worldObj, xCoord, yCoord, zCoord);
            player.addChatMessage(new ChatComponentTranslation("msg.probeTypeSource.txt"));
            int mode = HexUtils.getMetaBitBiInt(HexBlocks.META_MACHINE_STATUS_0, HexBlocks.META_MACHINE_STATUS_1, worldObj, xCoord, yCoord, zCoord);
            player.addChatMessage(new ChatComponentTranslation("msg.probeMachineStatus" + (mode + 1) + ".txt"));
            player.addChatMessage(new ChatComponentTranslation("msg.probeEnergy.txt", Math.round(energyTotalLeft), "HEX", Math.round(energyTotal), "HEX"));
        }
        // If player is sneaking.
        else {
            player.addChatMessage(new ChatComponentTranslation("msg.probeConnectedDrains.txt"));
            HexUtils.addChatProbeConnectedMachines(player, energyDrains, worldObj, xCoord, yCoord, zCoord);
        }
    }

    /**** Custom Methods ****/

    /**
     * Sends a recheck request to all drains.
     */
    private void sendRecheck() {
        if (HexConfig.cfgGeneralMachineNetworkDebug && HexConfig.cfgGeneralNetworkDebug)
            System.out.println("[Hexorium Generator] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Requesting recheck.");
        if (energyDrains != null)
            // Parse the whole energyDrains ArrayList and call recheckSources() on each of them.
            for (HexDevice entry : energyDrains)
                if (HexUtils.checkChunk(worldObj, entry.x, entry.z)) {
                    ITileHexEnergyDrain energyDrain = (ITileHexEnergyDrain) worldObj.getTileEntity(entry.x, entry.y, entry.z);
                    if (energyDrain != null)
                        energyDrain.recheckSources();
                }
    }

    /**
     * Decreases the stack in generator size by 1.
     */
    private void consumeItem() {
        if (inventory[0] != null) {
            inventory[0].stackSize--;

            if (inventory[0].stackSize == 0)
                inventory[0] = inventory[0].getItem().getContainerItem(inventory[0]);
        }
    }

    /**
     * Called to check if the item can be used as fuel.
     * @return If the item can be used as fuel.
     */
    public static boolean canBurn(ItemStack itemStack) {
        return getItemBurnTime(itemStack) > 0;
    }

    /**
     * Returns the burn time for item.
     * @return The item burn time.
     */
    private static int getItemBurnTime(ItemStack itemStack){
        if (itemStack == null)
            // Return a burn time of 0 if there is nothing inserted.
            return 0;
        else {
            Item item = itemStack.getItem();

            // Check if the item corresponds to different blocks and return burn time if so.
            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
            {
                Block block = Block.getBlockFromItem(item);
                if (block == Blocks.wooden_slab) return 150;
                if (block.getMaterial() == Material.wood) return 300;
                if (block == Blocks.coal_block) return 16000;
            }

            // Return different burn times if the item corresponds to any of these items.
            if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item == Items.stick) return 100;
            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (item == Items.blaze_rod) return 2400;

            return GameRegistry.getFuelValue(itemStack);
        }
    }

    /**
     * Returns the scaled progress.
     * @param length Corresponds with the length of the progress bar.
     * @return Length of the progress bar.
     */
    @SideOnly(Side.CLIENT)
    public int getEnergyScaled(int length) {
        // Check if the GUI energy is lower or equal to zero.
        if (guiEnergyTotalLeft <= 0)
            // If it is, return -1. This way, bar will only be drawn while there is some energy.
            return -1;
        else
            // Otherwise return normally.
            return guiEnergyTotalLeft * length / guiEnergyTotal;
    }

    /**** ISidedInventory Methods ****/

    /**
     * Return the item slots depending on side. Used for blocks like Hopper.
     */
    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        // Get the machine rotation.
        int rotation = HexUtils.getBitBiInt(HexBlocks.META_MACHINE_ROTATION_0, HexBlocks.META_MACHINE_ROTATION_1, blockMetadata);

        // Make side slot available only from front.
        if (side == 2 && rotation == 0)
            return slotsSide;
        else if (side == 3 && rotation == 2)
            return slotsSide;
        else if (side == 4 && rotation == 3)
            return slotsSide;
        else if (side == 5 && rotation == 1)
            return slotsSide;
        else
            return slotsBlank;
    }

    /**
     * Check if item can be inserted.
     */
    @Override
    public boolean canInsertItem(int slot, ItemStack itemstack, int par3) {
        return isItemValidForSlot(slot, itemstack);
    }

    /**** IInventory Methods ****/

    /**
     * Fired when opening the container.
     */
    @Override
    public void openInventory() {

    }

    /**
     * Fired when closing the container.
     */
    @Override
    public void closeInventory() {

    }

    /**
     * Default methods used for managing the item slots.
     */
    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int count) {
        if (inventory[slot] != null) {
            ItemStack itemStack;
            if (inventory[slot].stackSize <= count) {
                itemStack = inventory[slot];
                inventory[slot] = null;
                return itemStack;
            } else {
                itemStack = inventory[slot].splitStack(count);

                if (inventory[slot].stackSize == 0) {
                    inventory[slot] = null;
                }
                return itemStack;
            }
        } else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        if (inventory[slot] != null) {
            ItemStack itemstack = inventory[slot];
            inventory[slot] = null;
            return itemstack;
        } else {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {
        inventory[slot] = itemStack;

        if (itemStack != null && itemStack.stackSize > getInventoryStackLimit()) {
            itemStack.stackSize = getInventoryStackLimit();
        }
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    /**
     * Check if the item is valid for a certain slot.
     */
    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
        // Make items valid only for slot 0.
        return slot == 0;
    }

    /**
     * Check if item can be extracted.
     */
    @Override
    public boolean canExtractItem(int slot, ItemStack itemstack, int par3) {
        return par3 != 0 || slot != 0 || itemstack.getItem() == Items.bucket;
    }

    /**
     * Retrieves the machine name.
     */
    @Override
    public String getInventoryName() {
        return INVENTORY_NAME;
    }

    /**
     * Confirms that the machine has custom name.
     */
    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }

    /**
     * Check if the TIle Entity can be used by the player.
     */
    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64.0D;
    }

    /**** Getters and Setters ****/

    public void setGuiEnergyTotal(int guiEnergyTotal) {
        this.guiEnergyTotal = guiEnergyTotal;
    }

    public int getGuiEnergyTotal() {
        return this.guiEnergyTotal;
    }

    public void setGuiEnergyTotalLeft(int guiEnergyTotalLeft) {
        this.guiEnergyTotalLeft = guiEnergyTotalLeft;
    }

    public int getGuiEnergyTotalLeft() {
        return this.guiEnergyTotalLeft;
    }

    public void setGuiEnergyDrained(int guiEnergyDrained) {
        this.guiEnergyDrained = guiEnergyDrained;
    }

    public int getGuiEnergyDrained() {
        return this.guiEnergyDrained;
    }
}
