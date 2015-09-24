package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.util.HexDevice;
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
 * @version 0.6.2

 */
public class TileHexoriumGenerator extends TileEntity implements ISidedInventory {

    // Set machine name.
    private static String machineName = "Hexorium Generator";

    // Prepare machine lists.
    private ArrayList<HexDevice> machinesHexoriumFurnace;
    private ArrayList<HexDevice> machinesCrystalSeparator;
    private ArrayList<HexDevice> machinesMatrixReconstructor;
    private ArrayList<HexDevice> machinesPersonalTeleportationPad;

    // Define sides and slots.
    private static final int[] slotsSide = new int[] { 0 };
    private static final int[] slotsBlank = new int[] { 1 };
    private ItemStack[] machineItemStacks = new ItemStack[2];

    // Prepare energy variables.
    public static int energyPerTick = 32;
    private float energyTotal;
    private float energy;
    private float energyOut = 0;

    // Prepare GUI variables.
    public int energyTotalGui;
    public int energyGui;
    public int energyOutGui;

    // Prepare state variables.
    private boolean firstTick = false;
    public boolean canProvideEnergy = false;
    private float pulledThisTick = 0;

    // Float rounding epsilon.
    private float epsilon = 0.0001F;

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
        energyOut = tagCompound.getFloat("EnergyOut");

        // Read the GUI variables.
        energyTotalGui = tagCompound.getInteger("EnergyTotalGui");
        energyGui = tagCompound.getInteger("EnergyGui");
        energyOutGui = tagCompound.getInteger("EnergyOutGui");

        // Read the state variables.
        canProvideEnergy = tagCompound.getBoolean("CanProvideEnergy");

        // Prepare coordinate arrays.
        int machinesX[];
        int machinesY[];
        int machinesZ[];

        // Read the coordinate arrays.
        machinesX = tagCompound.getIntArray("MachinesHexoriumFurnaceX");
        machinesY = tagCompound.getIntArray("MachinesHexoriumFurnaceY");
        machinesZ = tagCompound.getIntArray("MachinesHexoriumFurnaceZ");
        // Prepare the ArrayList for machines.
        machinesHexoriumFurnace = new ArrayList<HexDevice>();
        // Build the machine list using the coordinate arrays.
        for (int i = 0; i < machinesX.length; i++)
            machinesHexoriumFurnace.add(new HexDevice(machinesX[i], machinesY[i], machinesZ[i], HexBlocks.blockHexoriumFurnace));

        // Read the coordinate arrays.
        machinesX = tagCompound.getIntArray("MachinesCrystalSeparatorX");
        machinesY = tagCompound.getIntArray("MachinesCrystalSeparatorY");
        machinesZ = tagCompound.getIntArray("MachinesCrystalSeparatorZ");
        // Prepare the ArrayList for machines.
        machinesCrystalSeparator = new ArrayList<HexDevice>();
        // Build the machine list using the coordinate arrays.
        for (int i = 0; i < machinesX.length; i++)
            machinesCrystalSeparator.add(new HexDevice(machinesX[i], machinesY[i], machinesZ[i], HexBlocks.blockCrystalSeparator));

        // Read the coordinate arrays.
        machinesX = tagCompound.getIntArray("MachinesMatrixReconstructorX");
        machinesY = tagCompound.getIntArray("MachinesMatrixReconstructorY");
        machinesZ = tagCompound.getIntArray("MachinesMatrixReconstructorZ");
        // Prepare the ArrayList for machines.
        machinesMatrixReconstructor = new ArrayList<HexDevice>();
        // Build the machine list using the coordinate arrays.
        for (int i = 0; i < machinesX.length; i++)
            machinesMatrixReconstructor.add(new HexDevice(machinesX[i], machinesY[i], machinesZ[i], HexBlocks.blockMatrixReconstructor));

        // Read the coordinate arrays.
        machinesX = tagCompound.getIntArray("MachinesPersonalTeleportationPadX");
        machinesY = tagCompound.getIntArray("MachinesPersonalTeleportationPadY");
        machinesZ = tagCompound.getIntArray("MachinesPersonalTeleportationPadZ");
        // Prepare the ArrayList for machines.
        machinesPersonalTeleportationPad = new ArrayList<HexDevice>();
        // Build the machine list using the coordinate arrays.
        for (int i = 0; i < machinesX.length; i++)
            machinesPersonalTeleportationPad.add(new HexDevice(machinesX[i], machinesY[i], machinesZ[i], HexBlocks.blockPersonalTeleportationPad));

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
        tagCompound.setFloat("EnergyOut", energyOut);

        // Write the GUI variables.
        tagCompound.setInteger("EnergyTotalGui", energyTotalGui);
        tagCompound.setInteger("EnergyGui", energyGui);
        tagCompound.setInteger("EnergyOutGui", energyOutGui);

        // Write the state variables.
        tagCompound.setBoolean("CanProvideEnergy", canProvideEnergy);

        // Prepare coordinate arrays.
        int machinesX[];
        int machinesY[];
        int machinesZ[];

        // Check if machine list is not null.
        if (machinesHexoriumFurnace != null) {
            // Initialize the coordinate arrays.
            machinesX = new int[machinesHexoriumFurnace.size()];
            machinesY = new int[machinesHexoriumFurnace.size()];
            machinesZ = new int[machinesHexoriumFurnace.size()];
            // Save the coordinates of machines to arrays.
            int i = 0;
            for (HexDevice entry : machinesHexoriumFurnace) {
                machinesX[i] = entry.x;
                machinesY[i] = entry.y;
                machinesZ[i] = entry.z;
                i++;
            }
            // Write the coordinate arrays.
            tagCompound.setIntArray("MachinesHexoriumFurnaceX", machinesX);
            tagCompound.setIntArray("MachinesHexoriumFurnaceY", machinesY);
            tagCompound.setIntArray("MachinesHexoriumFurnaceZ", machinesZ);
        }
        // If it is null, write the coordinate arrays as empty.
        else {
            machinesX = new int[0];
            machinesY = new int[0];
            machinesZ = new int[0];
            tagCompound.setIntArray("MachinesHexoriumFurnaceX", machinesX);
            tagCompound.setIntArray("MachinesHexoriumFurnaceY", machinesY);
            tagCompound.setIntArray("MachinesHexoriumFurnaceZ", machinesZ);
        }

        // Check if machine list is not null.
        if (machinesCrystalSeparator != null) {
            // Initialize the coordinate arrays.
            machinesX = new int[machinesCrystalSeparator.size()];
            machinesY = new int[machinesCrystalSeparator.size()];
            machinesZ = new int[machinesCrystalSeparator.size()];
            // Save the coordinates of machines to arrays.
            int i = 0;
            for (HexDevice entry : machinesCrystalSeparator) {
                machinesX[i] = entry.x;
                machinesY[i] = entry.y;
                machinesZ[i] = entry.z;
                i++;
            }
            // Write the coordinate arrays.
            tagCompound.setIntArray("MachinesCrystalSeparatorX", machinesX);
            tagCompound.setIntArray("MachinesCrystalSeparatorY", machinesY);
            tagCompound.setIntArray("MachinesCrystalSeparatorZ", machinesZ);
        }
        // If it is null, write the coordinate arrays as empty.
        else {
            machinesX = new int[0];
            machinesY = new int[0];
            machinesZ = new int[0];
            tagCompound.setIntArray("MachinesCrystalSeparatorX", machinesX);
            tagCompound.setIntArray("MachinesCrystalSeparatorY", machinesY);
            tagCompound.setIntArray("MachinesCrystalSeparatorZ", machinesZ);
        }

        // Check if machine list is not null.
        if (machinesMatrixReconstructor != null) {
            // Initialize the coordinate arrays.
            machinesX = new int[machinesMatrixReconstructor.size()];
            machinesY = new int[machinesMatrixReconstructor.size()];
            machinesZ = new int[machinesMatrixReconstructor.size()];
            // Save the coordinates of machines to arrays.
            int i = 0;
            for (HexDevice entry : machinesMatrixReconstructor) {
                machinesX[i] = entry.x;
                machinesY[i] = entry.y;
                machinesZ[i] = entry.z;
                i++;
            }
            // Write the coordinate arrays.
            tagCompound.setIntArray("MachinesMatrixReconstructorX", machinesX);
            tagCompound.setIntArray("MachinesMatrixReconstructorY", machinesY);
            tagCompound.setIntArray("MachinesMatrixReconstructorZ", machinesZ);
        }
        // If it is null, write the coordinate arrays as empty.
        else {
            machinesX = new int[0];
            machinesY = new int[0];
            machinesZ = new int[0];
            tagCompound.setIntArray("MachinesMatrixReconstructorX", machinesX);
            tagCompound.setIntArray("MachinesMatrixReconstructorY", machinesY);
            tagCompound.setIntArray("MachinesMatrixReconstructorZ", machinesZ);
        }

        // Check if machine list is not null.
        if (machinesPersonalTeleportationPad != null) {
            // Initialize the coordinate arrays.
            machinesX = new int[machinesPersonalTeleportationPad.size()];
            machinesY = new int[machinesPersonalTeleportationPad.size()];
            machinesZ = new int[machinesPersonalTeleportationPad.size()];
            // Save the coordinates of machines to arrays.
            int i = 0;
            for (HexDevice entry : machinesPersonalTeleportationPad) {
                machinesX[i] = entry.x;
                machinesY[i] = entry.y;
                machinesZ[i] = entry.z;
                i++;
            }
            // Write the coordinate arrays.
            tagCompound.setIntArray("MachinesPersonalTeleportationPadX", machinesX);
            tagCompound.setIntArray("MachinesPersonalTeleportationPadY", machinesY);
            tagCompound.setIntArray("MachinesPersonalTeleportationPadZ", machinesZ);
        }
        // If it is null, write the coordinate arrays as empty.
        else {
            machinesX = new int[0];
            machinesY = new int[0];
            machinesZ = new int[0];
            tagCompound.setIntArray("MachinesPersonalTeleportationPadX", machinesX);
            tagCompound.setIntArray("MachinesPersonalTeleportationPadY", machinesY);
            tagCompound.setIntArray("MachinesPersonalTeleportationPadZ", machinesZ);
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
            
            // Change the texture if energy started to be pulled or stopped to.
            if (pulledThisTick > 0 && canProvideEnergy &&
                    getBlockMetadata() < 4)
                HexBlocks.updateMachineState(1, worldObj, xCoord, yCoord, zCoord);
            else if (pulledThisTick == 0 && canProvideEnergy &&
                    (getBlockMetadata() >= 4 && getBlockMetadata() < 8))
                HexBlocks.updateMachineState(0, worldObj, xCoord, yCoord, zCoord);
            // Save the total energy out from previous tick.
            energyOut = pulledThisTick;
            // Reset the pulling per tick variable.
            pulledThisTick = 0;

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
                if (energyOut > 0)
                    // If there is, set the ACTIVE texture.
                    HexBlocks.updateMachineState(1, worldObj, xCoord, yCoord, zCoord);
                else
                    // Otherwise, set the READY texture.
                    HexBlocks.updateMachineState(0, worldObj, xCoord, yCoord, zCoord);

                // Check if the generator can provide energy. If not, set it to true.
                if (!canProvideEnergy) {
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
                    // Make the generator unavailable after stopping.
                    canProvideEnergy = false;
                    // Restart-start them again. This will update their generator list and remove this generator.
                    restartMachinesStart();
                }

                // Set the DEAD texture.
                HexBlocks.updateMachineState(2, worldObj, xCoord, yCoord, zCoord);
            }

            // Divide the energy states with the energy per tick and save them to GUI variables. This will make sure they will fit in short int.
            energyGui = (int) (energy / energyPerTick);
            energyTotalGui = (int) (energyTotal / energyPerTick);
            energyOutGui = (Math.round(energyOut));
        }
    }

    /**
     * Called by machines to pull energy from the generator.
     * @param requestedEnergy The amount of energy that the machine wants to pull.
     * @return The amount of energy successfully pulled.
     */
    public float pullEnergy(float requestedEnergy) {
        // Check if the generator is able to provide energy.
        if (canProvideEnergy) {
            // Check if there is still full requested energy available this tick. The epsilon is deducted to mitigate possible float rounding errors.
            if (pulledThisTick + requestedEnergy < energyPerTick - epsilon) {
                // Decrease the amount of energy left in the generator by the amount of requested energy.
                energy = energy - requestedEnergy;
                // Increase the amount of energy pulled this tick.
                pulledThisTick = pulledThisTick + requestedEnergy;
                // Return the energy to the machine.
                return requestedEnergy;
            }
            else {
                // Otherwise, save the energy pulled to a variable as remaining energy.
                float pull = energyPerTick - pulledThisTick;
                // Decrease the amount of energy left in the generator.
                energy = energy - pull;
                // Increase the amount of energy pulled this tick.
                pulledThisTick = energyPerTick;
                // Return the energy to the machine.
                return pull;
            }
        } else
            // If the generator cannot provide energy, return ' energy to the machine.
            return  0;
    }

    /**
     * Sends a recount signal to all machines.
     */
    private void restartMachinesStart() {
        // Make sure that the machine list is not null.
        if (machinesHexoriumFurnace != null)
            // Send a restart-start signal to all machines in the list.
            for (HexDevice entry : machinesHexoriumFurnace) {
                if (worldObj.getChunkProvider().chunkExists(entry.x >> 4, entry.z >> 4)) {
                    TileHexoriumFurnace tileEntity = (TileHexoriumFurnace) worldObj.getTileEntity(entry.x, entry.y, entry.z);
                    if (tileEntity != null)
                        tileEntity.countGenerators();
                }
            }

        // Make sure that the machine list is not null.
        if (machinesCrystalSeparator != null)
            // Send a restart-start signal to all machines in the list.
            for (HexDevice entry : machinesCrystalSeparator) {
                if (worldObj.getChunkProvider().chunkExists(entry.x >> 4, entry.z >> 4)) {
                    TileCrystalSeparator tileEntity = (TileCrystalSeparator) worldObj.getTileEntity(entry.x, entry.y, entry.z);
                    if (tileEntity != null)
                        tileEntity.countGenerators();
                }
            }

        // Make sure that the machine list is not null.
        if (machinesMatrixReconstructor != null)
            // Send a restart-start signal to all machines in the list.
            for (HexDevice entry : machinesMatrixReconstructor) {
                if (worldObj.getChunkProvider().chunkExists(entry.x >> 4, entry.z >> 4)) {
                    TileMatrixReconstructor tileEntity = (TileMatrixReconstructor) worldObj.getTileEntity(entry.x, entry.y, entry.z);
                    if (tileEntity != null)
                        tileEntity.countGenerators();
                }
            }

        // Make sure that the machine list is not null.
        if (machinesPersonalTeleportationPad != null)
            // Send a restart-start signal to all machines in the list.
            for (HexDevice entry : machinesPersonalTeleportationPad) {
                if (worldObj.getChunkProvider().chunkExists(entry.x >> 4, entry.z >> 4)) {
                    TilePersonalTeleportationPad tileEntity = (TilePersonalTeleportationPad) worldObj.getTileEntity(entry.x, entry.y, entry.z);
                    if (tileEntity != null)
                        tileEntity.countGenerators();
                }
            }
    }

    /**
     * Called by the NetworkAnalyzer class when exchanging data between machines.
     * @param incomingHexoriumFurnace The ArrayList of machines received.
     * @param incomingCrystalSeparator The ArrayList of machines received.
     * @param incomingMatrixReconstructor The ArrayList of machines received.
     * @param incomingPersonalTeleportationPad The ArrayList of machines received.
     */
    public void injectMachines(ArrayList<HexDevice> incomingHexoriumFurnace,
                               ArrayList<HexDevice> incomingCrystalSeparator,
                               ArrayList<HexDevice> incomingMatrixReconstructor,
                               ArrayList<HexDevice> incomingPersonalTeleportationPad) {

        // Check if the size of the incoming list is larger then 0.
        if (incomingHexoriumFurnace.size() != 0)
            // If it is, save it to local list.
            machinesHexoriumFurnace = incomingHexoriumFurnace;
        else
            // Otherwise, set the local list to null.
            machinesHexoriumFurnace = null;
        
        // Check if the size of the incoming list is larger then 0.
        if (incomingCrystalSeparator.size() != 0)
            // If it is, save it to local list.
            machinesCrystalSeparator = incomingCrystalSeparator;
        else
            // Otherwise, set the local list to null.
            machinesCrystalSeparator = null;
        
        // Check if the size of the incoming list is larger then 0.
        if (incomingMatrixReconstructor.size() != 0)
            // If it is, save it to local list.
            machinesMatrixReconstructor = incomingMatrixReconstructor;
        else
            // Otherwise, set the local list to null.
            machinesMatrixReconstructor = null;

        // Check if the size of the incoming list is larger then 0.
        if (incomingPersonalTeleportationPad.size() != 0)
            // If it is, save it to local list.
            machinesPersonalTeleportationPad = incomingPersonalTeleportationPad;
        else
            // Otherwise, set the local list to null.
            machinesPersonalTeleportationPad = null;
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
