package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.init.HexBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;

import java.util.ArrayList;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.5.0
 * @since 2015-05-06
 */
public class TilePersonalTeleportationPad extends TileEntity implements ISidedInventory {

    // Set machine name.
    private static String machineName = "Personal Teleportation Pad";

    // Prepare machine list and arrays for coordinates.
    private ArrayList<TileHexoriumGenerator> machinesHexoriumGenerator;
    private int[] machinesHexoriumGeneratorX;
    private int[] machinesHexoriumGeneratorY;
    private int[] machinesHexoriumGeneratorZ;

    // Prepare teleport list and arrays for coordinates.
    private ArrayList<TilePersonalTeleportationPad> teleportsPersonalTeleportationPad;
    private int[] teleportsPersonalTeleportationPadX;
    private int[] teleportsPersonalTeleportationPadY;
    private int[] teleportsPersonalTeleportationPadZ;

    // Prepare linked teleport state and coordinates.
    private boolean linkedTeleportExists;
    private int linkedTeleportX;
    private int linkedTeleportY;
    private int linkedTeleportZ;

    // Define sides and slots.
    private static final int[] slotsBlank = new int[] { 0 };
    private ItemStack[] machineItemStacks = new ItemStack[1];

    // Prepare energy variables.
    private static float energyTotal = 102400;
    private float energy;
    private float energyIn;

    // Prepare GUI variables.
    private static int energyTotalGui = (int) energyTotal / 128;
    public int energyGui;
    public int energyInGui;

    // Prepare state variables.
    private boolean firstTick = false;
    private boolean hasEnergy = false;
    public boolean isActive = false;
    private int usableGenerators = 0;

    // Prepare teleportation variables.
    public boolean isTeleporting = false;
    private static int teleportCountdown = 80;
    private int teleportCounter = 0;

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
        return 0;
    }

    /**
     * Return the item slots depending on side. Used for blocks like Hopper.
     */
    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
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
        return false;
    }

    /**
     * Check if item can be extracted.
     */
    @Override
    public boolean canExtractItem(int par1, ItemStack itemstack, int par3) {
        return false;
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
        machinesHexoriumGeneratorX = tagCompound.getIntArray("MachinesHexoriumGeneratorX");
        machinesHexoriumGeneratorY = tagCompound.getIntArray("MachinesHexoriumGeneratorY");
        machinesHexoriumGeneratorZ = tagCompound.getIntArray("MachinesHexoriumGeneratorZ");
        // Prepare the ArrayList for machines.
        machinesHexoriumGenerator = new ArrayList<TileHexoriumGenerator>();

        // Read the coordinate arrays.
        teleportsPersonalTeleportationPadX = tagCompound.getIntArray("TeleportsPersonalTeleportationPadX");
        teleportsPersonalTeleportationPadY = tagCompound.getIntArray("TeleportsPersonalTeleportationPadY");
        teleportsPersonalTeleportationPadZ = tagCompound.getIntArray("TeleportsPersonalTeleportationPadZ");
        // Prepare the ArrayList for teleports.
        teleportsPersonalTeleportationPad = new ArrayList<TilePersonalTeleportationPad>();
        
        // Prime the updateEntity() for first-tick startup.
        firstTick = true;

        // Read the link state.
        linkedTeleportExists = tagCompound.getBoolean("LinkedTeleportExists");
        // Read the link coordinates.
        linkedTeleportX = tagCompound.getInteger("LinkedTeleportX");
        linkedTeleportY = tagCompound.getInteger("LinkedTeleportY");
        linkedTeleportZ = tagCompound.getInteger("LinkedTeleportZ");

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

        // Check if machine list is not null.
        if (machinesHexoriumGenerator != null) {
            // Initialize the coordinate arrays.
            machinesHexoriumGeneratorX = new int[machinesHexoriumGenerator.size()];
            machinesHexoriumGeneratorY = new int[machinesHexoriumGenerator.size()];
            machinesHexoriumGeneratorZ = new int[machinesHexoriumGenerator.size()];
            // Save the coordinates of machines to arrays.
            int i = 0;
            for (TileHexoriumGenerator entry : machinesHexoriumGenerator) {
                machinesHexoriumGeneratorX[i] = entry.xCoord;
                machinesHexoriumGeneratorY[i] = entry.yCoord;
                machinesHexoriumGeneratorZ[i] = entry.zCoord;
                i++;
            }
            // Write the coordinate arrays.
            tagCompound.setIntArray("MachinesHexoriumGeneratorX", machinesHexoriumGeneratorX);
            tagCompound.setIntArray("MachinesHexoriumGeneratorY", machinesHexoriumGeneratorY);
            tagCompound.setIntArray("MachinesHexoriumGeneratorZ", machinesHexoriumGeneratorZ);
        }
        // If it is null, write the coordinate arrays as empty.
        else  {
            machinesHexoriumGeneratorX = new int[0];
            machinesHexoriumGeneratorY = new int[0];
            machinesHexoriumGeneratorZ = new int[0];
            tagCompound.setIntArray("MachinesHexoriumGeneratorX", machinesHexoriumGeneratorX);
            tagCompound.setIntArray("MachinesHexoriumGeneratorY", machinesHexoriumGeneratorY);
            tagCompound.setIntArray("MachinesHexoriumGeneratorZ", machinesHexoriumGeneratorZ);
        }

        // Check if teleport list is not null.
        if (teleportsPersonalTeleportationPad != null) {
            // Initialize the coordinate arrays.
            teleportsPersonalTeleportationPadX = new int[teleportsPersonalTeleportationPad.size()];
            teleportsPersonalTeleportationPadY = new int[teleportsPersonalTeleportationPad.size()];
            teleportsPersonalTeleportationPadZ = new int[teleportsPersonalTeleportationPad.size()];
            // Save the coordinates of teleports to arrays.
            int i = 0;
            for (TilePersonalTeleportationPad entry : teleportsPersonalTeleportationPad) {
                teleportsPersonalTeleportationPadX[i] = entry.xCoord;
                teleportsPersonalTeleportationPadY[i] = entry.yCoord;
                teleportsPersonalTeleportationPadZ[i] = entry.zCoord;
                i++;
            }
            // Write the coordinate arrays.
            tagCompound.setIntArray("TeleportsPersonalTeleportationPadX", teleportsPersonalTeleportationPadX);
            tagCompound.setIntArray("TeleportsPersonalTeleportationPadY", teleportsPersonalTeleportationPadY);
            tagCompound.setIntArray("TeleportsPersonalTeleportationPadZ", teleportsPersonalTeleportationPadZ);
        }
        // If it is null, write the coordinate arrays as empty.
        else  {
            teleportsPersonalTeleportationPadX = new int[0];
            teleportsPersonalTeleportationPadY = new int[0];
            teleportsPersonalTeleportationPadZ = new int[0];
            tagCompound.setIntArray("TeleportsPersonalTeleportationPadX", teleportsPersonalTeleportationPadX);
            tagCompound.setIntArray("TeleportsPersonalTeleportationPadY", teleportsPersonalTeleportationPadY);
            tagCompound.setIntArray("TeleportsPersonalTeleportationPadZ", teleportsPersonalTeleportationPadZ);
        }

        // Save linking state.
        tagCompound.setBoolean("LinkedTeleportExists", linkedTeleportExists);
        // Check if the teleport is linked.
        if (linkedTeleportExists) {
            // If it is, save the coordinates normally.
            tagCompound.setInteger("LinkedTeleportX", linkedTeleportX);
            tagCompound.setInteger("LinkedTeleportY", linkedTeleportY);
            tagCompound.setInteger("LinkedTeleportZ", linkedTeleportZ);
        }
        else {
            // Otherwise, set coordinates to 0.
            tagCompound.setInteger("LinkedTeleportX", 0);
            tagCompound.setInteger("LinkedTeleportY", 0);
            tagCompound.setInteger("LinkedTeleportZ", 0);
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
            // If this is the first tick...
            if (firstTick) {
                // Build the machine list using the coordinate arrays.
                for (int i = 0; i < machinesHexoriumGeneratorX.length; i++) {
                    machinesHexoriumGenerator.add((TileHexoriumGenerator)
                            worldObj.getTileEntity(machinesHexoriumGeneratorX[i], machinesHexoriumGeneratorY[i], machinesHexoriumGeneratorZ[i]));
                }
                // Build the teleport list using the coordinate arrays.
                for (int i = 0; i < teleportsPersonalTeleportationPadX.length; i++) {
                    teleportsPersonalTeleportationPad.add((TilePersonalTeleportationPad)
                            worldObj.getTileEntity(teleportsPersonalTeleportationPadX[i], teleportsPersonalTeleportationPadY[i], teleportsPersonalTeleportationPadZ[i]));
                }
                // Finalize first tick.
                firstTick = false;
            }
            // Otherwise continue normally.
            else {
                // Run an energy check on every tick. This will make the texture appear as READY.
                if (!isTeleporting)
                    checkEnergy();
                // If the teleport has energy, and there is still space for energy...
                if (hasEnergy && energy < energyTotal * 2) {
                    // If the teleport was inactive...
                    if (!isActive) {
                        // Attempt to start it.
                        isActive = startMachine();
                    }

                    // If the teleport is active...
                    if (isActive) {
                        // Check if the generator list is not null.
                        if (machinesHexoriumGenerator != null)
                            // Pull energy from every generator.
                            for (TileHexoriumGenerator entry : machinesHexoriumGenerator)
                                if (entry != null)
                                    // Pull the maximum energy.
                                    if (energy + energyIn < energyTotal * 2) {
                                        if (energyTotal * 2 - energy - energyIn < TileHexoriumGenerator.energyPerTick)
                                            energyIn = energyIn + entry.pullEnergy((float) energyTotal * 2 - energy - energyIn);
                                        else
                                            energyIn = energyIn + entry.pullEnergy((float) TileHexoriumGenerator.energyPerTick);
                                    }

                        // Increase the stored energy.
                        energy = energy + energyIn;
                    }
                } else
                    // If the machine has no energy and/or there are no items to process, stop the processing.
                    stopProcessing();

                // If the teleporter is charging the teleport...
                if (isTeleporting) {
                    // And if the countdown is reached...
                    if (teleportCounter >= teleportCountdown) {
                        // Perform the teleport.
                        teleport();
                        // Deduct the energy used.
                        energy = energy - energyTotal;
                        if (energy < 0)
                            energy = 0;
                        // Reset variables
                        isTeleporting = false;
                        if (energy > 0)
                            HexBlocks.updateMachineState(0, worldObj, xCoord, yCoord, zCoord);
                        else {
                            HexBlocks.updateMachineState(2, worldObj, xCoord, yCoord, zCoord);
                            hasEnergy = false;
                        }
                    }
                    else
                        // Increment counter.
                        teleportCounter++;
                }
            }
            // Divide the energy states with the energy per tick and save them to GUI variables. This will make sure they will fit in short int.
            energyGui = (int) (energy / 128);
            energyInGui = (Math.round(energyIn));
        }
    }

    /**
     * Called to start the machine.
     * @return Boolean if the registration to generators was successful.
     */
    public boolean startMachine() {
        // Prepare a usable generator count.
        int usableGenerators1 = 0;
        // Check if the generator list is not null.
        if(machinesHexoriumGenerator != null)
            // Go through all generators and check how many of them can provide energy.
            for (TileHexoriumGenerator entry : machinesHexoriumGenerator)
                if (entry != null && entry.canProvideEnergy)
                    usableGenerators1++;
        // Save the usable generator count.
        usableGenerators = usableGenerators1;

        // Prepare a boolean for checking if the registration process is successful.
        boolean checkEnergy = false;
        // Check if the generator list is not null.
        if(machinesHexoriumGenerator != null)
            // Go through all generators and register self as one of the machines pulling the energy. Use the energy per tick divided by number of usable generators.
            for (TileHexoriumGenerator entry : machinesHexoriumGenerator)
                if (entry != null && entry.canProvideEnergy)
                    checkEnergy = entry.startPulling((float) TileHexoriumGenerator.energyPerTick);

        // Return the boolean if registration was successful.
        return checkEnergy;
    }

    /**
     * Called to stop the machine.
     */
    public void stopMachine() {
        // Check if the generator list is not null.
        if (machinesHexoriumGenerator != null)
            // Go through all generators and unregister self. Use the energy per tick divided by number of usable generators.
            for (TileHexoriumGenerator entry : machinesHexoriumGenerator)
                if (entry != null && entry.canProvideEnergy)
                    entry.stopPulling((float) TileHexoriumGenerator.energyPerTick);
    }

    /**
     * Called to restart-stop the machine.
     */
    public void restartMachineStop() {
        // Check if the machine is active.
        if (isActive)
            // If it is, stop it.
            stopMachine();
    }

    /**
     * Called to restart-start the machine.
     */
    public void restartMachineStart() {
        // Check if the machine is active.
        if (isActive) {
            // If it is, start the machine and save the result.
            isActive = startMachine();
            // If the machine should no longer be active...
            if (!isActive) {
                // Set the texture to READY.
                HexBlocks.updateMachineState(0, worldObj, xCoord, yCoord, zCoord);
            }
        }
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
            for (TileHexoriumGenerator entry : machinesHexoriumGenerator)
                if (entry != null && entry.canProvideEnergy)
                    checkEnergy = true;

        if (energy > 0)
            checkEnergy = true;

        // Check if the energy is now available, but wasn't previously.
        if (checkEnergy && !hasEnergy)
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
     * Called when the teleport should no longer be pulling energy.
     */
    public void stopProcessing() {
        // If the teleport is active...
        if (isActive) {
            // Make it inactive.
            isActive = false;
            // Stop the teleport.
            stopMachine();
        }
    }

    /**
     * Called by the NetworkAnalyzer class when exchanging data between machines.
     * @param incomingMachines The ArrayList of machines recieved.
     */
    public void injectMachines(ArrayList<TileHexoriumGenerator> incomingMachines) {

        // Restart-stop the machine.
        restartMachineStop();

        // Check if the size of the incoming list is larger then 0.
        if (incomingMachines.size() != 0)
            // If it is, save it to the local list.
            machinesHexoriumGenerator = incomingMachines;
        else
            // Otherwise, set the local list to null.
            machinesHexoriumGenerator = null;

        // Restart-start the machine.
        restartMachineStart();
    }

    /**
     * Called by the NetworkAnalyzer class when exchanging data between teleports.
     * @param incomingTeleports The ArrayList of teleports received.
     */
    public void injectTeleports(ArrayList<TilePersonalTeleportationPad> incomingTeleports) {

        // Check if the size of the incoming list is larger then 0.
        if (incomingTeleports.size() != 0) {
            // If it is, save it to the local list.
            teleportsPersonalTeleportationPad = incomingTeleports;

            // If the teleport is already linked...
            if (linkedTeleportExists) {
                // Analyze the incoming list and unling if necessary.
                boolean checkLink = false;
                for (TilePersonalTeleportationPad entry : teleportsPersonalTeleportationPad)
                    if (entry.xCoord == linkedTeleportX && entry.yCoord == linkedTeleportY && entry.zCoord == linkedTeleportZ)
                        checkLink = true;
                if (!checkLink) {
                    // System.out.println("Teleports unlinked!");
                    linkedTeleportExists = false;
                }
            }
        }
        else {
            // Otherwise, set the local list to null.
            teleportsPersonalTeleportationPad = null;
            linkedTeleportExists = false;
        }
    }

    /**
     * Begins teleportation.
     */
    public void beginTeleport() {
        // If the teleport is linked and has enough energy...
        if (linkedTeleportExists && energy >= energyTotal) {
            // Get the player and send the chat message.
            EntityPlayer player = worldObj.getClosestPlayer(xCoord + 0.5, yCoord + 1, zCoord + 0.5, 4);
            if (player != null)
                player.addChatMessage(new ChatComponentTranslation("msg.teleportProcess1.txt"));
            // Activate teleportation countdown.
            isTeleporting = true;
            teleportCounter = 0;
            // Set the texture to ACTIVE.
            HexBlocks.updateMachineState(1, worldObj, xCoord, yCoord, zCoord);
        }
    }

    /**
     * Performs the teleportation.
     */
    private void teleport() {
        // Get the player.
        EntityPlayer player = worldObj.getClosestPlayer(xCoord + 0.5, yCoord + 1, zCoord + 0.5, 1);
        // If player exists and the teleport is linked...
        if (player != null && linkedTeleportExists)
            // If the player is located on top of the teleport...
            if (player.posX >= xCoord && player.posX <= xCoord + 1 &&
                    player.posY >= yCoord && player.posY <= yCoord + 1 &&
                    player.posZ >= zCoord && player.posZ <= zCoord + 1) {
                // Send the chat message.
                player.addChatMessage(new ChatComponentTranslation("msg.teleportProcess2.txt"));
                // Teleport the player.
                player.setPositionAndUpdate(linkedTeleportX + 0.5, linkedTeleportY + 1, linkedTeleportZ + 0.5);
                // Apply confusion effect.
                player.addPotionEffect(new PotionEffect(Potion.confusion.getId(), 180, 100, false));
                // Hurt the player.
                player.attackEntityFrom(DamageSource.generic, 4F);
            }
    }

    /**
     * Checks if teleports are connected via network.
     * @param x Coordinate x of the target teleport.
     * @param y Coordinate y of the target teleport.
     * @param z Coordinate z of the target teleport.
     * @return Boolean whether the teleports are on same network.
     */
    public boolean checkConnectivity(int x, int y, int z) {
        // Get the target teleport.
        TilePersonalTeleportationPad tileEntity = (TilePersonalTeleportationPad) worldObj.getTileEntity(x, y, z);
        // Check if it is null.
        if (tileEntity != null) {
            // If the teleport exists, return true.
            for (TilePersonalTeleportationPad entry : teleportsPersonalTeleportationPad)
                if (entry.xCoord == x && entry.yCoord == y && entry.zCoord == z)
                    return true;
        }
        return false;
    }

    /**
     * Checks if teleports are already linked.
     * @param x Coordinate x of the target teleport.
     * @param y Coordinate y of the target teleport.
     * @param z Coordinate z of the target teleport.
     * @return Boolean whether the teleports are already linked.
     */
    public boolean checkLinked(int x, int y, int z) {
        // Return true if the teleport is already linked with target.
        return linkedTeleportExists && linkedTeleportX == x && linkedTeleportY == y && linkedTeleportZ == z;
    }

    /**
     * Links a teleport.
     * @param x Coordinate x of the target teleport.
     * @param y Coordinate y of the target teleport.
     * @param z Coordinate z of the target teleport.
     * @return Boolean whether the linking was successful.
     */
    public boolean linkTeleport(int x, int y, int z) {
        // System.out.println("Linking! " + "(" + xCoord + ", " + yCoord + ", " + zCoord + ")");
        // Get the target teleport.
        TilePersonalTeleportationPad tileEntity = (TilePersonalTeleportationPad) worldObj.getTileEntity(x, y, z);
        // Make sure it is not null.
        if (tileEntity != null) {
            // If the teleport is already linked, unlink it.
            if (linkedTeleportExists) {
                TilePersonalTeleportationPad old = (TilePersonalTeleportationPad) worldObj.getTileEntity(linkedTeleportX, linkedTeleportY, linkedTeleportZ);
                if (old != null)
                    old.unlinkTeleport();
            }
            // Link the teleport with new target.
            linkedTeleportExists = true;
            linkedTeleportX = x;
            linkedTeleportY = y;
            linkedTeleportZ = z;
            return true;
        }
        return false;
    }

    /**
     * Unlinks a teleport.
     */
    public void unlinkTeleport() {
        // System.out.println("Unlinking! " + "(" + xCoord + ", " + yCoord + ", " + zCoord + ")");
        // Unlink the teleport.
        linkedTeleportExists = false;
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
