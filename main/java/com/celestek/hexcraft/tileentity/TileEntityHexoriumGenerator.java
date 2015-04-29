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

    private ArrayList<TileEntityMatrixReconstructor> machinesMatrixReconstructor;
    int[] machinesMatrixReconstructorX;
    int[] machinesMatrixReconstructorY;
    int[] machinesMatrixReconstructorZ;
    private boolean firstTick = false;

    // Define sides and slots.
    private static final int[] slotsSide = new int[] { 0 };
    private static final int[] slotsBlank = new int[] { 1 };
    private ItemStack[] machineItemStacks = new ItemStack[2];

    private static int energyPerTick = 32;
    public int energyTotal;
    private float energy;
    public int energyGui;

    private float machinesPulling = 0;
    public boolean canProvideEnergy = false;

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

        energyTotal = tagCompound.getInteger("EnergyTotal");
        energy = tagCompound.getFloat("Energy");
        energyGui = tagCompound.getInteger("EnergyGui");

        machinesPulling = tagCompound.getFloat("MachinesPulling");
        canProvideEnergy = tagCompound.getBoolean("CanProvideEnergy");

        machinesMatrixReconstructorX = tagCompound.getIntArray("MachinesMatrixReconstructorX");
        machinesMatrixReconstructorY = tagCompound.getIntArray("MachinesMatrixReconstructorY");
        machinesMatrixReconstructorZ = tagCompound.getIntArray("MachinesMatrixReconstructorZ");
        machinesMatrixReconstructor = new ArrayList<TileEntityMatrixReconstructor>();
        firstTick = true;

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

        tagCompound.setInteger("EnergyTotal", energyTotal);
        tagCompound.setFloat("Energy", energy);
        tagCompound.setInteger("EnergyGui", energyGui);

        tagCompound.setFloat("MachinesPulling", machinesPulling);
        tagCompound.setBoolean("CanProvideEnergy", canProvideEnergy);

        if (machinesMatrixReconstructor != null) {
            machinesMatrixReconstructorX = new int[machinesMatrixReconstructor.size()];
            machinesMatrixReconstructorY = new int[machinesMatrixReconstructor.size()];
            machinesMatrixReconstructorZ = new int[machinesMatrixReconstructor.size()];
            int i = 0;
            for (TileEntityMatrixReconstructor entry : machinesMatrixReconstructor) {
                machinesMatrixReconstructorX[i] = entry.xCoord;
                machinesMatrixReconstructorY[i] = entry.yCoord;
                machinesMatrixReconstructorZ[i] = entry.zCoord;
                i++;
            }
            tagCompound.setIntArray("MachinesMatrixReconstructorX", machinesMatrixReconstructorX);
            tagCompound.setIntArray("MachinesMatrixReconstructorY", machinesMatrixReconstructorY);
            tagCompound.setIntArray("MachinesMatrixReconstructorZ", machinesMatrixReconstructorZ);
        }
        else {
            machinesMatrixReconstructorX = new int[0];
            machinesMatrixReconstructorY = new int[0];
            machinesMatrixReconstructorZ = new int[0];
            tagCompound.setIntArray("MachinesMatrixReconstructorX", machinesMatrixReconstructorX);
            tagCompound.setIntArray("MachinesMatrixReconstructorY", machinesMatrixReconstructorY);
            tagCompound.setIntArray("MachinesMatrixReconstructorZ", machinesMatrixReconstructorZ);
        }

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
     * Returns the scaled progress of matrix reconstruction.
     * @param div Division which corresponds to the length of the progress bar.
     */
    @SideOnly(Side.CLIENT)
    public int getEnergyScaled(int div) {
        if (energyTotal == 0)
            return 0;
        else
            return (energyGui * div / energyTotal);
    }

    public float pullEnergy(float requestedEnergy) {
        if(energyTotal > 0) {
            if (machinesPulling > 0) {
                // System.out.println("PULLED: " + requestedEnergy);
                energy = energy - requestedEnergy;
                return requestedEnergy;
            }
            else {
                return 0;
            }
        } else
            return  0;
    }

    public boolean startPulling(float requestedEnergy) {
        if(canProvideEnergy) {
            // System.out.println("Start pulling: " + requestedEnergy + " z: " + zCoord);
            if (machinesPulling <= 0)
                MachineHexoriumGenerator.updateBlockState(1, worldObj, xCoord, yCoord, zCoord);

            if (machinesPulling + requestedEnergy <= energyPerTick + 0.01) {
                machinesPulling = machinesPulling + requestedEnergy;
                // System.out.println("Accepted! Now pulling: " + machinesPulling + " z: " + zCoord);
                return true;
            }
            else {
                // System.out.println("Rejected! Now pulling: " + machinesPulling + " z: " + zCoord);
                return false;
            }
        }
        return false;
    }

    public void stopPulling(float requestedEnergy) {
         System.out.println("Stop pulling: " + requestedEnergy + " z: " + zCoord);
        if (machinesPulling > 0)
            machinesPulling = machinesPulling - requestedEnergy;

        if (machinesPulling <= 0) {
            machinesPulling = 0;
            MachineHexoriumGenerator.updateBlockState(0, worldObj, xCoord, yCoord, zCoord);
        }
         System.out.println("Now pulling: " + machinesPulling + " z: " + zCoord);
    }

    public void updateEntity() {
        if (!worldObj.isRemote) {
            if (firstTick) {
                for (int i = 0; i < machinesMatrixReconstructorX.length; i++) {
                    machinesMatrixReconstructor.add((TileEntityMatrixReconstructor)
                            worldObj.getTileEntity(machinesMatrixReconstructorX[i], machinesMatrixReconstructorY[i], machinesMatrixReconstructorZ[i]));
                }
                firstTick = false;
            }
            else {
                if (energy <= 0 && canBurn()) {
                    energy = getItemBurnTime(machineItemStacks[0]) * energyPerTick;
                    energyTotal = (int) energy;

                    if (machineItemStacks[0] != null) {
                        machineItemStacks[0].stackSize--;

                        if (machineItemStacks[0].stackSize == 0)
                            machineItemStacks[0] = machineItemStacks[0].getItem().getContainerItem(machineItemStacks[0]);
                    }

                    if (machinesPulling > 0)
                        MachineHexoriumGenerator.updateBlockState(1, worldObj, xCoord, yCoord, zCoord);
                    else
                        MachineHexoriumGenerator.updateBlockState(0, worldObj, xCoord, yCoord, zCoord);

                    if (!canProvideEnergy) {
                        restartMachinesStop();
                        canProvideEnergy = true;
                        restartMachinesStart();
                    }
                } else if (energy <= 0 && !canBurn()) {
                    energyTotal = 0;
                    machinesPulling = 0;
                    MachineHexoriumGenerator.updateBlockState(2, worldObj, xCoord, yCoord, zCoord);
                    if(canProvideEnergy) {
                        canProvideEnergy = false;
                        restartMachinesStop();
                        restartMachinesStart();
                    }
                }
            }
            energyGui = (int) energy;
        }
    }

    private void restartMachinesStop() {
        if (machinesMatrixReconstructor != null) {
            for (TileEntityMatrixReconstructor entry : machinesMatrixReconstructor) {
                if (entry != null) {
                    entry.restartMachineStop();
                }
            }
        }
    }

    private void restartMachinesStart() {
        if (machinesMatrixReconstructor != null) {
            for (TileEntityMatrixReconstructor entry : machinesMatrixReconstructor) {
                if (entry != null) {
                    entry.restartMachineStart();
                }
            }
        }
    }

    private boolean canBurn() {
        if (this.machineItemStacks[0] == null)
            return false;
        else
            return getItemBurnTime(machineItemStacks[0]) > 0;
    }

    public static int getItemBurnTime(ItemStack itemstack){
        if (itemstack == null) {
            return 0;
        }
        else {
            Item item = itemstack.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
            {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.wooden_slab)
                    return 150;

                if (block.getMaterial() == Material.wood)
                    return 300;

                if (block == Blocks.coal_block)
                    return 16000;
            }

            if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item == Items.stick) return 100;
            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (item == Items.blaze_rod) return 2400;
            return GameRegistry.getFuelValue(itemstack);
        }
    }

    public static boolean isItemFuel(ItemStack itemstack){
        return getItemBurnTime(itemstack) > 0;
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

    @Override
    public boolean canInsertItem(int slot, ItemStack itemstack, int par3) {
        return isItemValidForSlot(slot, itemstack);
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
        return slot == 0;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack itemstack, int par3) {
        return par3 != 0 || slot != 0 || itemstack.getItem() == Items.bucket;
    }

    public void injectMachines(ArrayList<TileEntityMatrixReconstructor> incomingMachines) {
        if (incomingMachines.size() != 0) {
            machinesMatrixReconstructor = incomingMachines;
        }
        else {
            machinesMatrixReconstructor = null;
        }
    }
}
