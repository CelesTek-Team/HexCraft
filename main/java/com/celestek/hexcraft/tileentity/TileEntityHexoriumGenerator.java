package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.block.MachineHexoriumGenerator;
import com.celestek.hexcraft.block.MachineMatrixReconstructor;
import com.celestek.hexcraft.util.HexMachine;
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

    private static String machineName = "Hexorium Generator";

    private static int energyOutputPerTick = 32;

    private ArrayList<TileEntityMatrixReconstructor> machinesMatrixReconstructor;

    private static final int[] slotsSide = new int[] { 0 };

    private ItemStack[] machineItemStacks = new ItemStack[1];

    public int burnEnergy;
    public int totalBurnEnergy;
    private int machinesPulling = 0;
    public boolean canProvideEnergy = true;

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

        machineItemStacks = new ItemStack[getSizeInventory()];

        burnEnergy = tagCompound.getInteger("BurnEnergy");
        totalBurnEnergy = tagCompound.getInteger("TotalBurnEnergy");
        machinesPulling = tagCompound.getInteger("MachinesPulling");

        NBTTagList tagList = tagCompound.getTagList("Items", 10);
        for (int i = 0; i < tagList.tagCount(); ++i) {
            NBTTagCompound tagCompound1 = tagList.getCompoundTagAt(i);
            byte byte0 = tagCompound1.getByte("Slot");

            if (byte0 >= 0 && byte0 < machineItemStacks.length) {
                machineItemStacks[byte0] = ItemStack.loadItemStackFromNBT(tagCompound1);
            }
        }

        machinesMatrixReconstructor = new ArrayList<TileEntityMatrixReconstructor>();
    }

    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);

        tagCompound.setInteger("BurnEnergy", burnEnergy);
        tagCompound.setInteger("TotalBurnEnergy", totalBurnEnergy);
        tagCompound.setInteger("MachinesPulling", machinesPulling);

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
    public int getBurnScaled(int div) {
        if (totalBurnEnergy == 0)
            return 0;
        else
            return (burnEnergy * div / totalBurnEnergy);
    }

    public int pullEnergy(int requestedEnergy) {
        if(totalBurnEnergy > 0) {
            if (machinesPulling > 0) {
                System.out.println("PULLED: " + requestedEnergy);
                burnEnergy = burnEnergy - requestedEnergy;
                return requestedEnergy;
            }
            else {
                return 0;
            }
        } else
            return  0;
    }

    public boolean startPulling(int requestedEnergy) {
        if(canProvideEnergy) {
            System.out.println("Start pulling: " + requestedEnergy);
            if (machinesPulling <= 0)
                MachineHexoriumGenerator.updateBlockState(1, worldObj, xCoord, yCoord, zCoord);

            if (machinesPulling + requestedEnergy <= energyOutputPerTick) {
                machinesPulling = machinesPulling + requestedEnergy;
                System.out.println("Now pulling: " + machinesPulling);
                return true;
            }
            else
                return false;
        }
        return false;
    }

    public void stopPulling(int requestedEnergy) {
        System.out.println("Stop pulling: " + requestedEnergy);
        if (machinesPulling > 0)
            machinesPulling = machinesPulling - requestedEnergy;

        if (machinesPulling <= 0)
            MachineHexoriumGenerator.updateBlockState(0, worldObj, xCoord, yCoord, zCoord);
        System.out.println("Now pulling: " + machinesPulling);
    }

    public void updateEntity() {
        if (!worldObj.isRemote) {
            if (burnEnergy <= 0 && canBurn()) {
                totalBurnEnergy = burnEnergy = getItemBurnTime(machineItemStacks[0]) * energyOutputPerTick;

                if (burnEnergy > 0) {
                    MachineHexoriumGenerator.updateBlockState(0, worldObj, xCoord, yCoord, zCoord);
                    if (machineItemStacks[0] != null) {
                        --machineItemStacks[0].stackSize;

                        if (machineItemStacks[0].stackSize == 0)
                            machineItemStacks[0] = machineItemStacks[0].getItem().getContainerItem(machineItemStacks[0]);
                    }
                }

                if (!canProvideEnergy) {
                    canProvideEnergy = true;
                    restartMachines();
                }
            } else if (burnEnergy <= 0 && canProvideEnergy && !canBurn()) {
                totalBurnEnergy = 0;
                machinesPulling = 0;
                MachineHexoriumGenerator.updateBlockState(2, worldObj, xCoord, yCoord, zCoord);
                canProvideEnergy = false;
                restartMachines();
                if(canProvideEnergy) {
                }
            }
        }
    }

    private void restartMachines() {
        if (machinesMatrixReconstructor == null)
            machinesMatrixReconstructor = new ArrayList<TileEntityMatrixReconstructor>();
        if (machinesMatrixReconstructor.size() != 0) {
            for (TileEntityMatrixReconstructor entry : machinesMatrixReconstructor) {
                if (entry != null)
                    entry.restartMachine();
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
    public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
        return slot != 1;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int slot) {
        return slot == 0 ? null : slotsSide;
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack itemstack, int par3) {
        return isItemValidForSlot(slot, itemstack);
    }

    @Override
    public boolean canExtractItem(int par1, ItemStack itemstack, int par3) {
        return par3 != 0 || par1 != 1 || itemstack.getItem() == Items.bucket;
    }

    public void injectMachines(ArrayList<HexMachine> incomingMachines) {
        if (incomingMachines != null) {
            machinesMatrixReconstructor = new ArrayList<TileEntityMatrixReconstructor>();
            for (HexMachine entry : incomingMachines) {
                if (entry.name.contains(MachineMatrixReconstructor.UNLOCALISEDNAME)) {
                    machinesMatrixReconstructor.add((TileEntityMatrixReconstructor) worldObj.getTileEntity(entry.x, entry.y, entry.z));
                }
            }
        }
        else {
            machinesMatrixReconstructor = new ArrayList<TileEntityMatrixReconstructor>();
        }
    }
}
