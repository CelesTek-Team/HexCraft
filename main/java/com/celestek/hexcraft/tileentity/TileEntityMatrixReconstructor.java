package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.block.MachineMatrixReconstructor;
import com.celestek.hexcraft.init.RecipesMatrixReconstructor;
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
 * @version 0.1.0
 * @since 2015-04-25
 */
public class TileEntityMatrixReconstructor extends TileEntity implements ISidedInventory {

    // Set machine name.
    private static String machineName = "Matrix Reconstructor";

    // Prepare machine lists.
    private ArrayList<TileEntityHexoriumGenerator> machinesHexoriumGenerator;
    int[] machinesHexoriumGeneratorX;
    int[] machinesHexoriumGeneratorY;
    int[] machinesHexoriumGeneratorZ;
    private boolean firstTick = false;
    private int usableGenerators = 0;

    // Define sides and slots.
    private static final int[] slotsTop = new int[] { 0 };
    private static final int[] slotsSide = new int[] { 1 };
    private static final int[] slotsBlank = new int[] { 2 };
    private ItemStack[] machineItemStacks = new ItemStack[3];

    // Prepare energy variables.
    private static int energyPerTick = 32;
    private static float energyTotal = 2560;
    private float energy;
    private static int energyTotalGui = (int) energyTotal / energyPerTick;
    public int energyGui;

    // Prepare state variables.
    public boolean isActive = false;
    private boolean hasEnergy = false;

    // Used for 1 second timer.
    private int tickCount = 0;

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
        this.machineItemStacks[slot] = itemStack;

        if (itemStack != null && itemStack.stackSize > getInventoryStackLimit()) {
            itemStack.stackSize = getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName() {
        return machineName;
    }


    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }


    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);

        energy = tagCompound.getFloat("Energy");
        energyGui = tagCompound.getInteger("EnergyGui");

        isActive = tagCompound.getBoolean("IsActive");
        hasEnergy = tagCompound.getBoolean("HasEnergy");

        machinesHexoriumGeneratorX = tagCompound.getIntArray("MachinesHexoriumGeneratorX");
        machinesHexoriumGeneratorY = tagCompound.getIntArray("MachinesHexoriumGeneratorY");
        machinesHexoriumGeneratorZ = tagCompound.getIntArray("MachinesHexoriumGeneratorZ");
        machinesHexoriumGenerator = new ArrayList<TileEntityHexoriumGenerator>();
        firstTick = true;

        usableGenerators = tagCompound.getInteger("UsableGenerators");

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

    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);

        tagCompound.setFloat("Energy", energy);
        tagCompound.setInteger("EnergyGui", energyGui);

        tagCompound.setBoolean("IsActive", isActive);
        tagCompound.setBoolean("HasEnergy", hasEnergy);

        if (machinesHexoriumGenerator != null) {
            machinesHexoriumGeneratorX = new int[machinesHexoriumGenerator.size()];
            machinesHexoriumGeneratorY = new int[machinesHexoriumGenerator.size()];
            machinesHexoriumGeneratorZ = new int[machinesHexoriumGenerator.size()];
            int i = 0;
            for (TileEntityHexoriumGenerator entry : machinesHexoriumGenerator) {
                machinesHexoriumGeneratorX[i] = entry.xCoord;
                machinesHexoriumGeneratorY[i] = entry.yCoord;
                machinesHexoriumGeneratorZ[i] = entry.zCoord;
                i++;
            }
            tagCompound.setIntArray("MachinesHexoriumGeneratorX", machinesHexoriumGeneratorX);
            tagCompound.setIntArray("MachinesHexoriumGeneratorY", machinesHexoriumGeneratorY);
            tagCompound.setIntArray("MachinesHexoriumGeneratorZ", machinesHexoriumGeneratorZ);
        }
        else  {
            machinesHexoriumGeneratorX = new int[0];
            machinesHexoriumGeneratorY = new int[0];
            machinesHexoriumGeneratorZ = new int[0];
            tagCompound.setIntArray("MachinesHexoriumGeneratorX", machinesHexoriumGeneratorX);
            tagCompound.setIntArray("MachinesHexoriumGeneratorY", machinesHexoriumGeneratorY);
            tagCompound.setIntArray("MachinesHexoriumGeneratorZ", machinesHexoriumGeneratorZ);
        }

        tagCompound.setInteger("UsableGenerators", usableGenerators);

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
     * Returns the scaled progress of matrix reconstruction.
     * @param div Division which corresponds to the length of the progress bar.
     */
    @SideOnly(Side.CLIENT)
    public int getEnergyScaled(int div) {
        return energyGui * div / energyTotalGui;
    }

    /**
     * Returns the activity state.
     */
    public boolean getState() {
        return isActive;
    }

    /**
     * Sets the activity state.
     */
    public void setState(boolean state) {
        isActive = state;
    }

    public void updateEntity() {

        if (!worldObj.isRemote) {
            tickCount++;
            if (firstTick) {
                for (int i = 0; i < machinesHexoriumGeneratorX.length; i++) {
                    machinesHexoriumGenerator.add((TileEntityHexoriumGenerator)
                            worldObj.getTileEntity(machinesHexoriumGeneratorX[i], machinesHexoriumGeneratorY[i], machinesHexoriumGeneratorZ[i]));
                }
                firstTick = false;
            }
            else {
                checkEnergy();
                if (hasEnergy) {
                    if (canProcess()) {
                        if (!isActive) {
                            isActive = startMachine();
                            if (isActive)
                                MachineMatrixReconstructor.updateBlockState(1, worldObj, xCoord, yCoord, zCoord);
                        }

                        if (isActive) {

                            if (machinesHexoriumGenerator != null) {
                                for (TileEntityHexoriumGenerator entry : machinesHexoriumGenerator) {
                                    if (entry != null) {
                                        energy = energy + entry.pullEnergy((float) energyPerTick / usableGenerators);
                                    }
                                }
                            }

                            if (energy >= energyTotal) {
                                energy = 0;
                                processItem();
                            }
                        }
                    } else {
                        stopProcessing();
                    }
                } else {
                    stopProcessing();
                }
            }
            energyGui = (int) energy / energyPerTick;
        }
    }

    private void checkEnergy() {
        boolean checkEnergy = false;

        if (machinesHexoriumGenerator != null) {
            for (TileEntityHexoriumGenerator entry : machinesHexoriumGenerator) {
                if (entry != null && entry.canProvideEnergy)
                    checkEnergy = true;
            }
        }

        if (checkEnergy && !hasEnergy)
            MachineMatrixReconstructor.updateBlockState(0, worldObj, xCoord, yCoord, zCoord);
        else if (!checkEnergy && hasEnergy)
            MachineMatrixReconstructor.updateBlockState(2, worldObj, xCoord, yCoord, zCoord);

        hasEnergy = checkEnergy;
    }

    public boolean startMachine() {
        int usableGenerators1 = 0;
        if(machinesHexoriumGenerator != null) {
            for (TileEntityHexoriumGenerator entry : machinesHexoriumGenerator) {
                if (entry != null && entry.canProvideEnergy) {
                    usableGenerators1++;
                }
            }
        }
        usableGenerators = usableGenerators1;

        boolean checkEnergy = false;
        if(machinesHexoriumGenerator != null) {
            for (TileEntityHexoriumGenerator entry : machinesHexoriumGenerator) {
                if (entry != null && entry.canProvideEnergy) {
                    checkEnergy = entry.startPulling((float) energyPerTick / usableGenerators);
                }
            }
        }
        return checkEnergy;
    }

    public void stopMachine() {
        if (machinesHexoriumGenerator != null) {
            for (TileEntityHexoriumGenerator entry : machinesHexoriumGenerator) {
                if (entry != null && entry.canProvideEnergy) {
                    entry.stopPulling((float) energyPerTick / usableGenerators);
                }
            }
        }
    }

    public void restartMachineStart() {
        if (isActive) {
            isActive = startMachine();
            if (!isActive) {
                energy = 0;
                MachineMatrixReconstructor.updateBlockState(0, worldObj, xCoord, yCoord, zCoord);
            }
        }
    }

    public void restartMachineStop() {
        if (isActive) {
            stopMachine();
        }
    }

    private void stopProcessing() {
        energy = 0;
        if (isActive) {
            isActive = false;
            MachineMatrixReconstructor.updateBlockState(0, worldObj, xCoord, yCoord, zCoord);
            stopMachine();
        }
    }

    private boolean canProcess() {
        if (this.machineItemStacks[0] == null) {
            return false;
        } else {
            ItemStack itemStack = RecipesMatrixReconstructor.smelting().getSmeltingResult(machineItemStacks[0]);
            if (itemStack == null)
                return false;
            if (machineItemStacks[1] == null)
                return true;
            if (!machineItemStacks[1].isItemEqual(itemStack))
                return false;
            int result = machineItemStacks[1].stackSize + itemStack.stackSize;
            return result <= getInventoryStackLimit() && result <= machineItemStacks[1].getMaxStackSize();
        }
    }

    public void processItem() {
        if (canProcess()) {
            ItemStack itemStack = RecipesMatrixReconstructor.smelting().getSmeltingResult(machineItemStacks[0]);

            if (machineItemStacks[1] == null) {
                machineItemStacks[1] = itemStack.copy();
            } else if (machineItemStacks[1].getItem() == itemStack.getItem()) {
                machineItemStacks[1].stackSize += itemStack.stackSize;
            }

            --machineItemStacks[0].stackSize;

            if(machineItemStacks[0].stackSize == 0){
                machineItemStacks[0] = null;
            }
        }
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        int meta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

        if (meta >= 4 && meta < 8)
            meta -= 4;
        else if (meta >= 8)
            meta -= 8;

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

    @Override
    public boolean canInsertItem(int slot, ItemStack itemstack, int par3) {
        return isItemValidForSlot(slot, itemstack);
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
        return slot == 0;
    }

    @Override
    public boolean canExtractItem(int par1, ItemStack itemstack, int par3) {
        return par3 != 0;
    }

    public void injectMachines(ArrayList<TileEntityHexoriumGenerator> incomingMachines) {
        if (incomingMachines.size() != 0) {

            if(machinesHexoriumGenerator == null)
                machinesHexoriumGenerator = new ArrayList<TileEntityHexoriumGenerator>();

            restartMachineStop();

            machinesHexoriumGenerator = incomingMachines;

            restartMachineStart();
        }
        else {
            restartMachineStop();

            machinesHexoriumGenerator = null;

            restartMachineStart();
        }
    }
}
