package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexProcessingMatrixReconstructor;
import com.celestek.hexcraft.util.HexDevice;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.6.1
 * @since 2015-04-25
 */
public class TileMatrixReconstructor extends TileEntity implements ISidedInventory {

    // Set machine name.
    private static String machineName = "Matrix Reconstructor";

    // Prepare machine list.
    private ArrayList<HexDevice> machinesHexoriumGenerator;

    // Define sides and slots.
    private static final int[] slotsTop = new int[] { 0 };
    private static final int[] slotsSide = new int[] { 1 };
    private static final int[] slotsBlank = new int[] { 2 };
    private ItemStack[] machineItemStacks = new ItemStack[3];

    // Prepare energy variables.
    public static int energyPerTick = 64;
    private static float energyTotal = 25600;
    private float energy;
    private float energyIn;

    // Prepare GUI variables.
    private static int energyTotalGui = (int) energyTotal / energyPerTick;
    public int energyGui;
    public int energyInGui;

    // Prepare state variables.
    private boolean hasEnergy = false;
    public boolean isActive = false;
    private int usableGenerators = 0;

    /**
     * Fired when opening the inventory.
     */
    @Override
    public void openInventory() {

    }

    /**
     * Fired when closing the inventory.
     */
    @Override
    public void closeInventory() {

    }

    /**
     * Default methods used for managing the item slots.
     */
    @Override
    public int getSizeInventory() {
        return machineItemStacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return machineItemStacks[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int count) {
        if (machineItemStacks[slot] != null) {
            ItemStack itemStack;
            if (machineItemStacks[slot].stackSize <= count) {
                itemStack = machineItemStacks[slot];
                machineItemStacks[slot] = null;
                return itemStack;
            } else {
                itemStack = machineItemStacks[slot].splitStack(count);

                if (machineItemStacks[slot].stackSize == 0) {
                    machineItemStacks[slot] = null;
                }
                return itemStack;
            }
        } else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        if (machineItemStacks[slot] != null) {
            ItemStack itemstack = machineItemStacks[slot];
            machineItemStacks[slot] = null;
            return itemstack;
        } else {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {
        machineItemStacks[slot] = itemStack;

        if (itemStack != null && itemStack.stackSize > getInventoryStackLimit()) {
            itemStack.stackSize = getInventoryStackLimit();
        }
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    /**
     * Return the item slots depending on side. Used for blocks like Hopper.
     */
    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        // Get the machine meta.
        int meta = blockMetadata;

        // Strip away the texture states from meta.
        if (meta >= 4 && meta < 8)
            meta -= 4;
        else if (meta >= 8)
            meta -= 8;

        // Make side slot available only from front, and top from top.
        if (side == 1)
            return slotsTop;
        else if (side == 2 && meta == 0)
            return slotsSide;
        else if (side == 3 && meta == 2)
            return slotsSide;
        else if (side == 4 && meta == 3)
            return slotsSide;
        else if (side == 5 && meta == 1)
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

    /**
     * Check if the item is valid for a certain slot.
     */
    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
        return slot == 0;
    }

    /**
     * Check if item can be extracted.
     */
    @Override
    public boolean canExtractItem(int par1, ItemStack itemstack, int par3) {
        return par3 != 0;
    }

    /**
     * Retrieves the machine name.
     */
    @Override
    public String getInventoryName() {
        return machineName;
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

    /**
     * Reads the tags from NBT.
     */
    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);

        // Read the energy variables.
        energy = tagCompound.getFloat("Energy");
        energyIn = tagCompound.getFloat("EnergyIn");

        // Read the GUI variables.
        energyGui = tagCompound.getInteger("EnergyGui");

        // Read the state variables.
        isActive = tagCompound.getBoolean("IsActive");
        hasEnergy = tagCompound.getBoolean("HasEnergy");
        usableGenerators = tagCompound.getInteger("UsableGenerators");

        // Read the coordinate arrays.
        int machinesX[] = tagCompound.getIntArray("MachinesHexoriumGeneratorX");
        int machinesY[] = tagCompound.getIntArray("MachinesHexoriumGeneratorY");
        int machinesZ[] = tagCompound.getIntArray("MachinesHexoriumGeneratorZ");
        // Prepare the ArrayList for machines.
        machinesHexoriumGenerator = new ArrayList<HexDevice>();
        // Build the machine list using the coordinate arrays.
        for (int i = 0; i < machinesX.length; i++)
            machinesHexoriumGenerator.add(new HexDevice(machinesX[i], machinesY[i], machinesZ[i], HexBlocks.blockHexoriumGenerator));

        // Read the items.
        machineItemStacks = new ItemStack[getSizeInventory()];
        NBTTagList tagsItems = tagCompound.getTagList("Items", 10);
        for (int i = 0; i < tagsItems.tagCount(); ++i) {
            NBTTagCompound tagCompound1 = tagsItems.getCompoundTagAt(i);
            byte byte0 = tagCompound1.getByte("Slot");

            if (byte0 >= 0 && byte0 < machineItemStacks.length) {
                machineItemStacks[byte0] = ItemStack.loadItemStackFromNBT(tagCompound1);
            }
        }
    }

    /**
     * Writes the tags to NBT.
     */
    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);

        // Write the energy variables.
        tagCompound.setFloat("Energy", energy);
        tagCompound.setFloat("EnergyIn", energyIn);

        // Write the GUI variables.
        tagCompound.setInteger("EnergyGui", energyGui);

        // Write the state variables.
        tagCompound.setBoolean("IsActive", isActive);
        tagCompound.setBoolean("HasEnergy", hasEnergy);
        tagCompound.setInteger("UsableGenerators", usableGenerators);

        // Prepare coordinate arrays.
        int machinesX[];
        int machinesY[];
        int machinesZ[];

        // Check if machine list is not null.
        if (machinesHexoriumGenerator != null) {
            // Initialize the coordinate arrays.
            machinesX = new int[machinesHexoriumGenerator.size()];
            machinesY = new int[machinesHexoriumGenerator.size()];
            machinesZ = new int[machinesHexoriumGenerator.size()];
            // Save the coordinates of machines to arrays.
            int i = 0;
            for (HexDevice entry : machinesHexoriumGenerator) {
                machinesX[i] = entry.x;
                machinesY[i] = entry.y;
                machinesZ[i] = entry.z;
                i++;
            }
            // Write the coordinate arrays.
            tagCompound.setIntArray("MachinesHexoriumGeneratorX", machinesX);
            tagCompound.setIntArray("MachinesHexoriumGeneratorY", machinesY);
            tagCompound.setIntArray("MachinesHexoriumGeneratorZ", machinesZ);
        }
        // If it is null, write the coordinate arrays as empty.
        else  {
            machinesX = new int[0];
            machinesY = new int[0];
            machinesZ = new int[0];
            tagCompound.setIntArray("MachinesHexoriumGeneratorX", machinesX);
            tagCompound.setIntArray("MachinesHexoriumGeneratorY", machinesY);
            tagCompound.setIntArray("MachinesHexoriumGeneratorZ", machinesZ);
        }

        // Write the items.
        NBTTagList tagsItems = new NBTTagList();
        for (int i = 0; i < machineItemStacks.length; i++)
            if (machineItemStacks[i] != null) {
                NBTTagCompound tagCompoundLoop = new NBTTagCompound();
                tagCompoundLoop.setByte("Slot", (byte) i);
                machineItemStacks[i].writeToNBT(tagCompoundLoop);
                tagsItems.appendTag(tagCompoundLoop);
            }
        tagCompound.setTag("Items", tagsItems);
    }

    /**
     * Fired on every tick. Main processing is done here.
     */
    @Override
    public void updateEntity() {
        // Confirm that this is server side.
        if (!worldObj.isRemote) {
            // Reset the energy input variable.
            energyIn = 0;

            // Run an energy check on every tick. This will make the texture appear as READY.
            checkEnergy();
            // If the machine has energy, and there are items to process...
            if (hasEnergy && canProcess()) {
                // If the machine was inactive...
                if (!isActive) {
                    // Attempt to start it.
                    isActive = countGenerators();
                    // If the machine was successfully started, set the texture to ACTIVE.
                    if (isActive)
                        HexBlocks.updateMachineState(1, worldObj, xCoord, yCoord, zCoord);
                    else
                        // Set the pulled energy to -1. This is used for GUI rendering.
                        energyIn = -1;
                }

                // If the machine is active...
                if (isActive) {

                    // Reset the energy input variable.
                    energyIn = 0;
                    // Check if the generator list is not null.
                    if (machinesHexoriumGenerator != null)
                        // Pull energy from every generator.
                        for (HexDevice entry : machinesHexoriumGenerator) {
                            if (worldObj.getChunkProvider().chunkExists(entry.x >> 4, entry.z >> 4)) {
                                TileHexoriumGenerator generator = (TileHexoriumGenerator) worldObj.getTileEntity(entry.x, entry.y, entry.z);
                                if (generator != null)
                                    // Pull the according energy.
                                    if (energy + energyIn < energyTotal) {
                                        if (energyTotal - energy - energyIn < energyPerTick / usableGenerators)
                                            energyIn = energyIn + generator.pullEnergy(energyTotal - energy - energyIn);
                                        else
                                            energyIn = energyIn + generator.pullEnergy((float) energyPerTick / usableGenerators);
                                    }
                            }
                        }

                    // If the total energy pulled is 0...
                    if (energyIn == 0)
                        // Stop the processing.
                        stopProcessing();
                    else
                        // Otherwise, increase the progress.
                        energy = energy + energyIn;

                    // If the energy has reached required energy for the process...
                    if (energy >= energyTotal) {
                        // Set the energy back to 0.
                        energy = 0;
                        // Execute the item processing.
                        processItem();
                    }
                }
            } else
                // If the machine has no energy and/or there are no items to process, stop the processing.
                stopProcessing();

            // Divide the energy states with the energy per tick and save them to GUI variables. This will make sure they will fit in short int.
            energyGui = (int) (energy / energyPerTick);
            energyInGui = (Math.round(energyIn));
        }
    }

    /**
     * Called to count the generators.
     * @return Boolean if any generators were found.
     */
    public boolean countGenerators() {
        // Prepare a usable generator count.
        int usableGenerators1 = 0;
        // Check if the generator list is not null.
        if(machinesHexoriumGenerator != null)
            // Go through all generators and check how many of them can provide energy.
            for (HexDevice entry : machinesHexoriumGenerator) {
                if (worldObj.getChunkProvider().chunkExists(entry.x >> 4, entry.z >> 4)) {
                    TileHexoriumGenerator generator = (TileHexoriumGenerator) worldObj.getTileEntity(entry.x, entry.y, entry.z);
                    if (generator != null)
                        if (generator.canProvideEnergy)
                            usableGenerators1++;
                }
            }
        // Save the usable generator count.
        usableGenerators = usableGenerators1;

        // Return true of there are any generators.
        return usableGenerators != 0;
    }

    /**
     * Called to check if there is at least one generator with energy available.
     */
    private void checkEnergy() {
        // Prepare a boolean for checking.
        boolean checkEnergy = false;

        // Check if the generator list is not null.
        if (machinesHexoriumGenerator != null)
            // Go through all generators and check if any of them can provide energy.
            for (HexDevice entry : machinesHexoriumGenerator) {
                if (worldObj.getChunkProvider().chunkExists(entry.x >> 4, entry.z >> 4)) {
                    TileHexoriumGenerator generator = (TileHexoriumGenerator) worldObj.getTileEntity(entry.x, entry.y, entry.z);
                    if (generator != null)
                        if (generator.canProvideEnergy)
                            checkEnergy = true;
                }
            }

        // Check if the energy is now available, but wasn't previously, or if the machine was active, but no longer should be.
        if ((checkEnergy && !hasEnergy) || (blockMetadata >= 4 && blockMetadata < 8 && !isActive))
            // If yes, set the texture to READY.
            HexBlocks.updateMachineState(0, worldObj, xCoord, yCoord, zCoord);
        // Otherwise, check if the energy is now unavailable, but was previously.
        else if (!checkEnergy && hasEnergy)
            // If yes, set the texture to DEAD.
            HexBlocks.updateMachineState(2, worldObj, xCoord, yCoord, zCoord);

        // Save the result.
        hasEnergy = checkEnergy;
    }

    /**
     * Called when the machine should no longer be processing the item.
     */
    public void stopProcessing() {
        // Set the energy back to 0.
        energy = 0;
        // If the machine is active...
        if (isActive) {
            // Make it inactive.
            isActive = false;
            // Reload the texture.
            checkEnergy();
        }
    }

    /**
     * Called by the NetworkAnalyzer class when exchanging data between machines.
     * @param incomingMachines The ArrayList of machines received.
     */
    public void injectMachines(ArrayList<HexDevice> incomingMachines) {

        // Check if the size of the incoming list is larger then 0.
        if (incomingMachines.size() != 0)
            // If it is, save it to the local list.
            machinesHexoriumGenerator = incomingMachines;
        else
            // Otherwise, set the local list to null.
            machinesHexoriumGenerator = null;

        // Recount the generators.
        countGenerators();
    }

    /**
     * Called to check if the machine can process a certain item.
     * @return If the item can be processed.
     */
    private boolean canProcess() {
        // Check if the item stack in input is null. If yes, it cannot be processed.
        if (this.machineItemStacks[0] == null)
            return false;
        // Otherwise...
        else {
            // Save the result of processing to ItemStack.
            ItemStack itemStack = HexProcessingMatrixReconstructor.processing().getProcessingResult(machineItemStacks[0]);
            // If the result is null, it cannot be processed.
            if (itemStack == null)
                return false;
            // If there are no items in output slot, it can be processed.
            if (machineItemStacks[1] == null)
                return true;
            // If there are items in output slot, but are not same as result, it cannot be processed.
            if (!machineItemStacks[1].isItemEqual(itemStack))
                return false;
            // Check if more items can fit in the output. If yes, it can be processed.
            int result = machineItemStacks[1].stackSize + itemStack.stackSize;
            return result <= getInventoryStackLimit() && result <= machineItemStacks[1].getMaxStackSize();
        }
    }

    /**
     * Called to execute the item processing.
     */
    public void processItem() {
        // If the item can be processed...
        if (canProcess()) {
            // Prepare a new ItemStack that is the result of processing.
            ItemStack itemStack = HexProcessingMatrixReconstructor.processing().getProcessingResult(machineItemStacks[0]);

            // If there are no items in the output, put the result in.
            if (machineItemStacks[1] == null)
                machineItemStacks[1] = itemStack.copy();
            // If there are items, but are of same type, increment the stack.
            else if (machineItemStacks[1].getItem() == itemStack.getItem())
                machineItemStacks[1].stackSize += itemStack.stackSize;

            // Reduce the number of items in the input.
            machineItemStacks[0].stackSize--;

            // If the amount of items in input is 0, remove the items.
            if (machineItemStacks[0].stackSize == 0)
                machineItemStacks[0] = null;
        }
    }

    /**
     * Returns the scaled progress.
     * @param length Corresponds with the length of the progress bar.
     */
    @SideOnly(Side.CLIENT)
    public int getEnergyScaled(int length) {
        return energyGui * length / energyTotalGui;
    }
}
