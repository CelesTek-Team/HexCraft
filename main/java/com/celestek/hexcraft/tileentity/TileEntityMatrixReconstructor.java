package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.block.MachineHexoriumGenerator;
import com.celestek.hexcraft.block.MachineMatrixReconstructor;
import com.celestek.hexcraft.init.RecipesMatrixReconstructor;
import com.celestek.hexcraft.util.HexMachine;
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

    private static String machineName = "Matrix Reconstructor";

    private static int energyInputPerTick = 32;

    private ArrayList<TileEntityHexoriumGenerator> generatorList;
    private int[][] generators;

    private static final int[] slotsTop = new int[] { 0 };
    private static final int[] slotsSides = new int[] { 1 };

    private ItemStack[] machineItemStacks = new ItemStack[2];

    public int progressTime;

    public boolean isActive = false;
    public boolean hasEnergy = false;
    public int usableGenerators = 0;

    private static int progressDuration = 2560;

    private int tickCount = 0;

    // private String furnaceName;

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

        machineItemStacks = new ItemStack[getSizeInventory()];

        progressTime = tagCompound.getShort("ProgressTime");
        isActive = tagCompound.getBoolean("IsActive");
        hasEnergy = tagCompound.getBoolean("HasEnergy");

        NBTTagList tagList = tagCompound.getTagList("Items", 10);
        for (int i = 0; i < tagList.tagCount(); ++i) {
            NBTTagCompound tagCompound1 = tagList.getCompoundTagAt(i);
            byte byte0 = tagCompound1.getByte("Slot");

            if (byte0 >= 0 && byte0 < machineItemStacks.length) {
                machineItemStacks[byte0] = ItemStack.loadItemStackFromNBT(tagCompound1);
            }
        }

        generatorList = new ArrayList<TileEntityHexoriumGenerator>();
    }

    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);

        tagCompound.setShort("ProgressTime", (short) progressTime);
        tagCompound.setBoolean("IsActive", isActive);
        tagCompound.setBoolean("HasEnergy", hasEnergy);

        NBTTagList tagList = new NBTTagList();
        for (int i = 0; i < machineItemStacks.length; ++i) {
            if (machineItemStacks[i] != null) {
                NBTTagCompound tagCompound1 = new NBTTagCompound();
                tagCompound1.setByte("Slot", (byte) i);
                machineItemStacks[i].writeToNBT(tagCompound1);
                tagList.appendTag(tagCompound1);
            }
        }

        tagCompound.setTag("Items", tagList);
    }

    /**
     * Returns the scaled progress of matrix reconstruction.
     * @param div Division which corresponds to the length of the progress bar.
     */
    @SideOnly(Side.CLIENT)
    public int getProgressScaled(int div) {
        return progressTime * div / progressDuration;
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
            if (tickCount % 20 == 0)
            {
                tickCount = 0;

                boolean checkEnergy = false;

                if(generatorList.size() != 0) {
                    for (TileEntityHexoriumGenerator entry : generatorList) {
                        if (entry != null)
                            if (entry.totalBurnEnergy > 0)
                                checkEnergy = true;
                    }
                }

                if (checkEnergy && !hasEnergy)
                    MachineMatrixReconstructor.updateBlockState(0, worldObj, xCoord, yCoord, zCoord);
                else if (!checkEnergy && hasEnergy)
                    MachineMatrixReconstructor.updateBlockState(2, worldObj, xCoord, yCoord, zCoord);

                hasEnergy = checkEnergy;
            }
            if (hasEnergy) {
                if (canSmelt()) {
                    if (!isActive) {
                        isActive = startGenerators();
                        if (isActive)
                            MachineMatrixReconstructor.updateBlockState(1, worldObj, xCoord, yCoord, zCoord);
                    }

                    if(isActive) {

                        if (generatorList.size() != 0) {
                            for (TileEntityHexoriumGenerator entry : generatorList) {
                                if (entry != null)
                                    progressTime = progressTime - entry.pullEnergy(energyInputPerTick / generatorList.size());
                            }
                        }

                        if (progressTime == progressDuration) {
                            progressTime = 0;
                            smeltItem();
                        }
                    }
                } else {
                    progressTime = 0;
                    if (isActive) {
                        isActive = false;
                        MachineMatrixReconstructor.updateBlockState(0, worldObj, xCoord, yCoord, zCoord);
                        stopGenerators();
                    }
                }
            }
            else {
                progressTime = 0;
                if (isActive) {
                    isActive = false;
                    MachineMatrixReconstructor.updateBlockState(0, worldObj, xCoord, yCoord, zCoord);
                    stopGenerators();
                }
            }
        }
    }

    private boolean startGenerators() {
        int usableGenerators1 = 0;
        if(generatorList.size() != 0) {
            for (TileEntityHexoriumGenerator entry : generatorList) {
                if (entry != null && entry.totalBurnEnergy > 0) {
                    usableGenerators1++;
                }
            }
        }
        usableGenerators = usableGenerators1;

        boolean checkEnergy = false;
        if(generatorList.size() != 0) {
            for (TileEntityHexoriumGenerator entry : generatorList) {
                if (entry != null && entry.totalBurnEnergy > 0) {
                    checkEnergy = entry.startPulling(energyInputPerTick / usableGenerators);
                }
            }
        }
        return checkEnergy;
    }

    private void stopGenerators() {
        if (generatorList.size() != 0) {
            for (TileEntityHexoriumGenerator entry : generatorList) {
                if (entry != null)
                    entry.stopPulling(energyInputPerTick / usableGenerators);
            }
        }
    }

    private boolean canSmelt() {
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

    public void smeltItem() {
        if (canSmelt()) {
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
    public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
        return slot != 1;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int slot) {
        return slot == 0 ? slotsTop : slotsSides;
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack itemstack, int par3) {
        return isItemValidForSlot(slot, itemstack);
    }

    @Override
    public boolean canExtractItem(int par1, ItemStack itemstack, int par3) {
        return par3 != 0 || par1 != 1;
    }

    public void injectMachines(ArrayList<HexMachine> incomingMachines) {
        if (incomingMachines != null) {
            int size = 0;
            for (HexMachine entry : incomingMachines) {
                if (entry.name.contains(MachineHexoriumGenerator.UNLOCALISEDNAME)) {
                    size++;
                }
            }

            if (isActive) {
                if (generatorList.size() != 0) {
                    for (TileEntityHexoriumGenerator entry : generatorList) {
                        if (entry != null)
                            entry.stopPulling(energyInputPerTick / generatorList.size());
                    }
                }
            }

            generators = new int[size][3];
            generatorList = new ArrayList<TileEntityHexoriumGenerator>();
            int i = 0;
            for (HexMachine entry : incomingMachines) {
                if (entry.name.contains(MachineHexoriumGenerator.UNLOCALISEDNAME)) {
                    generatorList.add((TileEntityHexoriumGenerator) worldObj.getTileEntity(entry.x, entry.y, entry.z));
                    generators[i][0] = entry.x;
                    generators[i][1] = entry.y;
                    generators[i][2] = entry.z;
                    i++;
                }
            }

            if (isActive) {
                isActive = startGenerators();
            }
        }
        else {
            generators = null;
            generatorList = null;
        }
    }
}
