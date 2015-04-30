package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.block.MachineHexoriumGenerator;
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
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-25
 */
public class TileEntityHexoriumGenerator extends TileEntity implements ISidedInventory {

    // Set machine name.
    private static String machineName = "Hexorium Generator";

    // Prepare machine list and arrays for coordinates.
    private ArrayList<TileEntityMatrixReconstructor> machinesMatrixReconstructor;
    private int[] machinesMatrixReconstructorX;
    private int[] machinesMatrixReconstructorY;
    private int[] machinesMatrixReconstructorZ;

    // Define sides and slots.
    private static final int[] slotsSide = new int[] { 0 };
    private static final int[] slotsBlank = new int[] { 1 };
    private ItemStack[] machineItemStacks = new ItemStack[2];

    // Prepare energy variables.
    private static int energyPerTick = 32;
    private float energyTotal;
    private float energy;

    // Prepare GUI variables.
    public int energyTotalGui;
    public int energyGui;

    // Prepare state variables.
    private boolean firstTick = false;
    public boolean canProvideEnergy = false;
    private float machinesPulling = 0;

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
        int meta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

        // Strip away the texture states from meta.
        if (meta >= 4 && meta < 8)
            meta -= 4;
        else if (meta >= 8)
            meta -= 8;

        // Make side slot available only from front.
        if (side == 2 && meta == 0)
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
        energyTotal = tagCompound.getFloat("EnergyTotal");
        energy = tagCompound.getFloat("Energy");

        // Read the GUI variables.
        energyTotalGui = tagCompound.getInteger("EnergyTotalGui");
        energyGui = tagCompound.getInteger("EnergyGui");

        // Read the state variables.
        machinesPulling = tagCompound.getFloat("MachinesPulling");
        canProvideEnergy = tagCompound.getBoolean("CanProvideEnergy");

        // Read the coordinate arrays.
        machinesMatrixReconstructorX = tagCompound.getIntArray("MachinesMatrixReconstructorX");
        machinesMatrixReconstructorY = tagCompound.getIntArray("MachinesMatrixReconstructorY");
        machinesMatrixReconstructorZ = tagCompound.getIntArray("MachinesMatrixReconstructorZ");
        // Prepare the ArrayList for machines.
        machinesMatrixReconstructor = new ArrayList<TileEntityMatrixReconstructor>();
        // Prime the updateEntity() for first-tick startup.
        firstTick = true;

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

        // Read the energy variables.
        tagCompound.setFloat("EnergyTotal", energyTotal);
        tagCompound.setFloat("Energy", energy);

        // Write the GUI variables.
        tagCompound.setInteger("EnergyTotalGui", energyTotalGui);
        tagCompound.setInteger("EnergyGui", energyGui);

        // Write the state variables.
        tagCompound.setFloat("MachinesPulling", machinesPulling);
        tagCompound.setBoolean("CanProvideEnergy", canProvideEnergy);

        // Check if machine list is not null.
        if (machinesMatrixReconstructor != null) {
            // Initialize the coordinate arrays.
            machinesMatrixReconstructorX = new int[machinesMatrixReconstructor.size()];
            machinesMatrixReconstructorY = new int[machinesMatrixReconstructor.size()];
            machinesMatrixReconstructorZ = new int[machinesMatrixReconstructor.size()];
            // Save the coordinates of machines to arrays.
            int i = 0;
            for (TileEntityMatrixReconstructor entry : machinesMatrixReconstructor) {
                machinesMatrixReconstructorX[i] = entry.xCoord;
                machinesMatrixReconstructorY[i] = entry.yCoord;
                machinesMatrixReconstructorZ[i] = entry.zCoord;
                i++;
            }
            // Write the coordinate arrays.
            tagCompound.setIntArray("MachinesMatrixReconstructorX", machinesMatrixReconstructorX);
            tagCompound.setIntArray("MachinesMatrixReconstructorY", machinesMatrixReconstructorY);
            tagCompound.setIntArray("MachinesMatrixReconstructorZ", machinesMatrixReconstructorZ);
        }
        // If it is null, write the coordinate arrays as empty.
        else {
            machinesMatrixReconstructorX = new int[0];
            machinesMatrixReconstructorY = new int[0];
            machinesMatrixReconstructorZ = new int[0];
            tagCompound.setIntArray("MachinesMatrixReconstructorX", machinesMatrixReconstructorX);
            tagCompound.setIntArray("MachinesMatrixReconstructorY", machinesMatrixReconstructorY);
            tagCompound.setIntArray("MachinesMatrixReconstructorZ", machinesMatrixReconstructorZ);
        }

        // Write the items.
        NBTTagList tagsItems = new NBTTagList();
        for (int i = 0; i < machineItemStacks.length; ++i) {
            if (machineItemStacks[i] != null) {
                NBTTagCompound tagCompound1 = new NBTTagCompound();
                tagCompound1.setByte("Slot", (byte) i);
                machineItemStacks[i].writeToNBT(tagCompound1);
                tagsItems.appendTag(tagCompound1);
            }
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
            // If this is the first tick...
            if (firstTick) {
                // Build the machine list using the coordinate arrays.
                for (int i = 0; i < machinesMatrixReconstructorX.length; i++) {
                    machinesMatrixReconstructor.add((TileEntityMatrixReconstructor)
                            worldObj.getTileEntity(machinesMatrixReconstructorX[i], machinesMatrixReconstructorY[i], machinesMatrixReconstructorZ[i]));
                }
                // Finalize first tick.
                firstTick = false;
            }
            // Otherwise continue normally.
            else {
                // Check if the energy is empty and if the item can burn. This is fired either if there is a new item present or current one has burned out.
                if (energy <= 0 && canBurn(machineItemStacks[0])) {

                    // Get the item burn time and multiply it with the energy. Save the results. The generator now has energy.
                    energyTotal = energy = getItemBurnTime(machineItemStacks[0]) * energyPerTick;

                    // If there are still items present, decrement the stack.
                    if (machineItemStacks[0] != null) {
                        machineItemStacks[0].stackSize--;

                        if (machineItemStacks[0].stackSize == 0)
                            machineItemStacks[0] = machineItemStacks[0].getItem().getContainerItem(machineItemStacks[0]);
                    }

                    // Check if there is any energy being pulled by machines.
                    if (machinesPulling > 0)
                        // If there is, set the ACTIVE texture.
                        MachineHexoriumGenerator.updateBlockState(1, worldObj, xCoord, yCoord, zCoord);
                    else
                        // Otherwise, set the READY texture.
                        MachineHexoriumGenerator.updateBlockState(0, worldObj, xCoord, yCoord, zCoord);

                    // Check if the generator can provide energy. If not, set it to true.
                    if (!canProvideEnergy) {
                        // Restart-stop all of the machines pulling the energy.
                        restartMachinesStop();
                        // Make the generator available after stopping.
                        canProvideEnergy = true;
                        // Restart-start them again. This will update their generator list and add this generator.
                        restartMachinesStart();
                    }
                }
                // Otherwise, check if the energy is empty and item can't burn. This is fired when all items have burned out.
                else if (energy <= 0 && !canBurn(machineItemStacks[0])) {
                    // Set total energy to 0.
                    energyTotal = 0;

                    // Check if the generator can provide energy. If yes, set it to false.
                    if(canProvideEnergy) {
                        // Restart-stop all of the machines pulling the energy.
                        restartMachinesStop();
                        // Make the generator unavailable after stopping.
                        canProvideEnergy = false;
                        // Restart-start them again. This will update their generator list and remove this generator.
                        restartMachinesStart();
                    }

                    // Set the DEAD texture.
                    MachineHexoriumGenerator.updateBlockState(2, worldObj, xCoord, yCoord, zCoord);
                }
            }
            // Divide the energy states with the energy per tick and save them to GUI variables. This will make sure they will fit in short int.
            energyGui = (int) energy / energyPerTick;
            energyTotalGui = (int) energyTotal / energyPerTick;
        }
    }

    /**
     * Called by machines to register themselves when they start using the generator.
     * @param requestedEnergy The announced amount of energy that the machine will be pulling.
     * @return Boolean if the registration to this generator was successful.
     */
    public boolean startPulling(float requestedEnergy) {
        // Check if the generator is able to provide energy.
        if(canProvideEnergy) {
            // During the first machine's registration, change the texture.
            if (machinesPulling <= 0)
                // Set the ACTIVE texture.
                MachineHexoriumGenerator.updateBlockState(1, worldObj, xCoord, yCoord, zCoord);

            // Check if the generator has enough energy left to provide requested energy. The 0.01 are added to mitigate possible float rounding errors.
            if (machinesPulling + requestedEnergy <= energyPerTick + 0.01) {
                // If there is enough energy left, add the energy to the machine pulling variable.
                machinesPulling = machinesPulling + requestedEnergy;
                // Tell the machine that the registration was successful.
                return true;
            }
            else
                // Tell the machine that the registration was unsuccessful.
                return false;
        }
        // If the generator cannot provide energy, tell the machine that the registration was unsuccessful.
        return false;
    }

    /**
     * Called by machines to pull energy from the generator.
     * @param requestedEnergy The amount of energy that the machine wants to pull.
     * @return The amount of energy successfully pulled.
     */
    public float pullEnergy(float requestedEnergy) {
        // Check if the generator is able to provide energy.
        if(canProvideEnergy) {
            // Decrease the amount of energy left in the generator by the amount of requested energy.
            energy = energy - requestedEnergy;
            // Return the energy to the machine.
            return requestedEnergy;
        } else
            // If the generator cannot provide energy, return ' energy to the machine.
            return  0;
    }

    /**
     * Called by machines when they stop pulling energy from the generator.
     * @param requestedEnergy The amount of energy that the machine will stop pulling.
     */
    public void stopPulling(float requestedEnergy) {
        // If there is energy being pulled by machines...
        if (machinesPulling > 0)
            // Decrease the energy being pulled by the requested energy.
            machinesPulling = machinesPulling - requestedEnergy;

        // If no energy is being pulled any more...
        if (machinesPulling <= 0) {
            // Correct possible negative value.
            machinesPulling = 0;
            // Set the READY texture.
            MachineHexoriumGenerator.updateBlockState(0, worldObj, xCoord, yCoord, zCoord);
        }
    }

    /**
     * Sends a restart-stop signal to all machines. Used when restarting.
     */
    private void restartMachinesStop() {
        // Make sure that the machine list is not null.
        if (machinesMatrixReconstructor != null)
            // Send a restart-stop signal to all machines in the list.
            for (TileEntityMatrixReconstructor entry : machinesMatrixReconstructor)
                if (entry != null)
                    entry.restartMachineStop();
    }

    /**
     * Sends a restart-start signal to all machines. Used when restarting.
     */
    private void restartMachinesStart() {
        // Make sure that the machine list is not null.
        if (machinesMatrixReconstructor != null)
            // Send a restart-start signal to all machines in the list.
            for (TileEntityMatrixReconstructor entry : machinesMatrixReconstructor)
                if (entry != null)
                    entry.restartMachineStart();
    }

    /**
     * Called by the CableAnalyzer class when exchanging data between machines.
     * @param incomingMachines The ArrayList of machines recieved.
     */
    public void injectMachines(ArrayList<TileEntityMatrixReconstructor> incomingMachines) {
        // Check if the size of the incoming list is larger then 0.
        if (incomingMachines.size() != 0)
            // If it is, save it to local list.
            machinesMatrixReconstructor = incomingMachines;
        else
            // Otherwise, set the local list to null.
            machinesMatrixReconstructor = null;
    }

    /**
     * Called to check if the item can be used as fuel.
     * @param itemStack ItemStack to analyze.
     * @return If the item can be used as fuel.
     */
    public static boolean canBurn(ItemStack itemStack) {
        // Check if the passed ItemStack is null. If it isn't, get the burn time and return true if it is bigger than 0.
        return itemStack != null && getItemBurnTime(itemStack) > 0;
    }

    /**
     * Returns the burn time for item.
     * @param itemStack ItemStack to analyze.
     * @return The item burn time.
     */
    public static int getItemBurnTime(ItemStack itemStack){
        // If the ItemStack is null, return 0 burn time.
        if (itemStack == null) {
            return 0;
        }
        else {
            // Otherwise, prepare a new item made out of ItemStack.
            Item item = itemStack.getItem();

            // Check if the item corresponds to different blocks.
            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
            {
                // Convert the item to block.
                Block block = Block.getBlockFromItem(item);

                // Return different burn times if it corresponds to any of these blocks.
                if (block == Blocks.wooden_slab)
                    return 150;

                if (block.getMaterial() == Material.wood)
                    return 300;

                if (block == Blocks.coal_block)
                    return 16000;
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
        if (energyTotalGui <= 0)
            // If it is, return -1. This way, bar will only be drawn while there is some energy.
            return -1;
        else
            // Otherwise return normally.
            return energyGui * length / energyTotalGui;
    }
}
