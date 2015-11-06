package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.init.HexAchievements;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.util.HexDamage;
import com.celestek.hexcraft.util.HexDevice;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
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
 * @version 0.6.2

 */
public class TilePersonalTeleportationPad extends TileEntity {

    // Set machine name.
    private static String machineName = "Personal Teleportation Pad";

    // Prepare machine list.
    private ArrayList<HexDevice> machinesHexoriumGenerator;

    // Prepare teleport list.
    private ArrayList<HexDevice> teleportsPersonalTeleportationPad;

    // Prepare linked teleport.
    private HexDevice linkedTeleport;

    // Define sides and slots.
    private static final int[] slotsBlank = new int[] { 0 };
    private ItemStack[] machineItemStacks = new ItemStack[1];

    // Prepare energy variables.
    private static float energyTotal = HexConfig.cfgTeleportUsageCost;
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
     * Retrieves the machine name.
     */
    public String getInventoryName() {
        return machineName;
    }

    /**
     * Confirms that the machine has custom name.
     */
    public boolean hasCustomInventoryName() {
        return true;
    }

    /**
     * Check if the TIle Entity can be used by the player.
     */
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

        // Prepare coordinate arrays.
        int machinesX[];
        int machinesY[];
        int machinesZ[];

        // Read the coordinate arrays.
        machinesX = tagCompound.getIntArray("MachinesHexoriumGeneratorX");
        machinesY = tagCompound.getIntArray("MachinesHexoriumGeneratorY");
        machinesZ = tagCompound.getIntArray("MachinesHexoriumGeneratorZ");
        // Prepare the ArrayList for machines.
        machinesHexoriumGenerator = new ArrayList<HexDevice>();
        // Build the machine list using the coordinate arrays.
        for (int i = 0; i < machinesX.length; i++)
            machinesHexoriumGenerator.add(new HexDevice(machinesX[i], machinesY[i], machinesZ[i], HexBlocks.blockHexoriumGenerator));

        // Read the coordinate arrays.
        machinesX = tagCompound.getIntArray("TeleportsPersonalTeleportationPadX");
        machinesY = tagCompound.getIntArray("TeleportsPersonalTeleportationPadY");
        machinesZ = tagCompound.getIntArray("TeleportsPersonalTeleportationPadZ");
        // Prepare the ArrayList for teleports.
        teleportsPersonalTeleportationPad = new ArrayList<HexDevice>();
        // Build the machine list using the coordinate arrays.
        for (int i = 0; i < machinesX.length; i++)
            teleportsPersonalTeleportationPad.add(new HexDevice(machinesX[i], machinesY[i], machinesZ[i], HexBlocks.blockPersonalTeleportationPad));

        // Read the link state.
        boolean linkedTeleportExists = tagCompound.getBoolean("LinkedTeleportExists");
        // Read the link coordinates.
        int linkedTeleportX = tagCompound.getInteger("LinkedTeleportX");
        int linkedTeleportY = tagCompound.getInteger("LinkedTeleportY");
        int linkedTeleportZ = tagCompound.getInteger("LinkedTeleportZ");

        // Create the linked teleport object.
        if(linkedTeleportExists)
            linkedTeleport = new HexDevice(linkedTeleportX, linkedTeleportY, linkedTeleportZ, HexBlocks.blockPersonalTeleportationPad);
        else
            linkedTeleport = null;
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

        // Check if teleport list is not null.
        if (teleportsPersonalTeleportationPad != null) {
            // Initialize the coordinate arrays.
            machinesX = new int[teleportsPersonalTeleportationPad.size()];
            machinesY = new int[teleportsPersonalTeleportationPad.size()];
            machinesZ = new int[teleportsPersonalTeleportationPad.size()];
            // Save the coordinates of teleports to arrays.
            int i = 0;
            for (HexDevice entry : teleportsPersonalTeleportationPad) {
                machinesX[i] = entry.x;
                machinesY[i] = entry.y;
                machinesZ[i] = entry.z;
                i++;
            }
            // Write the coordinate arrays.
            tagCompound.setIntArray("TeleportsPersonalTeleportationPadX", machinesX);
            tagCompound.setIntArray("TeleportsPersonalTeleportationPadY", machinesY);
            tagCompound.setIntArray("TeleportsPersonalTeleportationPadZ", machinesZ);
        }
        // If it is null, write the coordinate arrays as empty.
        else  {
            machinesX = new int[0];
            machinesY = new int[0];
            machinesZ = new int[0];
            tagCompound.setIntArray("TeleportsPersonalTeleportationPadX", machinesX);
            tagCompound.setIntArray("TeleportsPersonalTeleportationPadY", machinesY);
            tagCompound.setIntArray("TeleportsPersonalTeleportationPadZ", machinesZ);
        }

        // Check if the teleport is linked.
        if (linkedTeleport != null) {
            tagCompound.setBoolean("LinkedTeleportExists", true);
            // If it is, save the coordinates normally.
            tagCompound.setInteger("LinkedTeleportX", linkedTeleport.x);
            tagCompound.setInteger("LinkedTeleportY", linkedTeleport.y);
            tagCompound.setInteger("LinkedTeleportZ", linkedTeleport.z);
        }
        else {
            tagCompound.setBoolean("LinkedTeleportExists", false);
            // Otherwise, set coordinates to 0.
            tagCompound.setInteger("LinkedTeleportX", 0);
            tagCompound.setInteger("LinkedTeleportY", 0);
            tagCompound.setInteger("LinkedTeleportZ", 0);
        }
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
            if (!isTeleporting)
                checkEnergy();
            // If the teleport has energy, and there is still space for energy...
            if (hasEnergy && energy < energyTotal * 2) {
                // If the teleport was inactive...
                if (!isActive) {
                    // Attempt to start it.
                    isActive = countGenerators();
                }

                // If the teleport is active...
                if (isActive) {
                    // Check if the generator list is not null.
                    if (machinesHexoriumGenerator != null)
                        // Pull energy from every generator.
                        for (HexDevice entry : machinesHexoriumGenerator) {
                            if (worldObj.getChunkProvider().chunkExists(entry.x >> 4, entry.z >> 4)) {
                                TileHexoriumGenerator generator = (TileHexoriumGenerator) worldObj.getTileEntity(entry.x, entry.y, entry.z);
                                if (generator != null)
                                    // Pull the maximum energy.
                                    if (energy + energyIn < energyTotal * 2) {
                                        if (energyTotal * 2 - energy - energyIn < TileHexoriumGenerator.energyPerTick)
                                            energyIn = energyIn + generator.pullEnergy((float) energyTotal * 2 - energy - energyIn);
                                        else
                                            energyIn = energyIn + generator.pullEnergy((float) TileHexoriumGenerator.energyPerTick);
                                    }
                            }
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
            // Divide the energy states with the energy per tick and save them to GUI variables. This will make sure they will fit in short int.
            energyGui = (int) (energy / 128);
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
        }
    }

    /**
     * Called by the NetworkAnalyzer class when exchanging data between machines.
     * @param incomingMachines The ArrayList of machines recieved.
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
     * Called by the NetworkAnalyzer class when exchanging data between teleports.
     * @param incomingTeleports The ArrayList of teleports received.
     */
    public void injectTeleports(ArrayList<HexDevice> incomingTeleports) {

        // Check if the size of the incoming list is larger then 0.
        if (incomingTeleports.size() != 0) {
            // If it is, save it to the local list.
            teleportsPersonalTeleportationPad = incomingTeleports;

            // If the teleport is already linked...
            if (linkedTeleport != null) {
                // Analyze the incoming list and unlink if necessary.
                boolean checkLink = false;
                for (HexDevice entry : teleportsPersonalTeleportationPad)
                    if (entry.x == linkedTeleport.x && entry.y == linkedTeleport.y && entry.z == linkedTeleport.z)
                        checkLink = true;
                if (!checkLink) {
                    // System.out.println("Teleports unlinked!");
                    linkedTeleport = null;
                }
            }
        }
        else {
            // Otherwise, set the local list to null.
            teleportsPersonalTeleportationPad = null;
            linkedTeleport = null;
        }
    }

    /**
     * Begins teleportation.
     */
    public void beginTeleport() {
        // If the teleport is linked and has enough energy...
        if (linkedTeleport != null && energy >= energyTotal) {
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
        if (player != null && linkedTeleport != null)
            // If the player is located on top of the teleport...
            if (player.posX >= xCoord && player.posX <= xCoord + 1 &&
                    player.posY >= yCoord && player.posY <= yCoord + 1 &&
                    player.posZ >= zCoord && player.posZ <= zCoord + 1) {
                // Send the chat message.
                player.addChatMessage(new ChatComponentTranslation("msg.teleportProcess2.txt"));
                // Teleport the player.
                player.setPositionAndUpdate(linkedTeleport.x + 0.5, linkedTeleport.y + 1, linkedTeleport.z + 0.5);
                if (HexConfig.cfgTeleportShouldDamagePlayers) {
                    // Apply confusion effect.
                    player.addPotionEffect(new PotionEffect(Potion.confusion.getId(), 180, 100, false));
                    // Hurt the player.
                    player.attackEntityFrom(HexDamage.teleport, HexConfig.cfgTeleportDamageAmount);
                }

                // Grant player the achievement.
                if (HexConfig.cfgGeneralUseAchievements)
                    player.addStat(HexAchievements.achUseTeleport, 1);
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
        // Check if it is null.
        if (worldObj.getBlock(x, y, z) == HexBlocks.blockPersonalTeleportationPad) {
            // If the teleport exists, return true.
            if (teleportsPersonalTeleportationPad != null) {
                for (HexDevice entry : teleportsPersonalTeleportationPad)
                    if (entry.x == x && entry.y == y && entry.z == z)
                        return true;
            }
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
        return linkedTeleport != null && linkedTeleport.x == x && linkedTeleport.y == y && linkedTeleport.z == z;
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
            if (linkedTeleport != null) {
                TilePersonalTeleportationPad old = (TilePersonalTeleportationPad) worldObj.getTileEntity(linkedTeleport.x, linkedTeleport.y, linkedTeleport.z);
                if (old != null)
                    old.unlinkTeleport();
            }
            // Link the teleport with new target.
            linkedTeleport = new HexDevice(x, y, z, HexBlocks.blockPersonalTeleportationPad);
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
        linkedTeleport = null;
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
