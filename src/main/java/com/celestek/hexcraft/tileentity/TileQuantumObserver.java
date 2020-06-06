package com.celestek.hexcraft.tileentity;

import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.util.ChunkManager;
import com.celestek.hexcraft.util.HexDevice;
import com.celestek.hexcraft.util.HexUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraftforge.common.ForgeChunkManager;

import java.util.ArrayList;
import java.util.Collection;

public class TileQuantumObserver extends TileEntity implements ITileHexEnergyDrain {

    /**** Static Values ****/

    public static final String ID = "tileQuantumObserver";

    private static final String INVENTORY_NAME = "hexcraft.container.quantumObserver";

    // NBT Names
    private static final String NBT_ENERGY_SOURCES = "energy_sources";

    private static final String NBT_ENERGY_DRAINED = "energy_drained";

    private static final String NBT_GUI_ENERGY_DRAINED = "gui_energy_drained";
    private static final String NBT_GUI_CHUNK_SIZE = "gui_chunk_size";

    private static final String NBT_IS_ACTIVE = "is_active";
    private static final String NBT_USABLE_SOURCES = "usable_sources";
    private static final String NBT_CHUNK_SIZE = "chunk_size";

    /**** Variables ****/

    // Prepare sources list.
    private ArrayList<HexDevice> energySources;

    // Prepare energy variables.
    private int energyPerTick;
    private float energyDrained;

    // Prepare GUI energy variables.
    private int guiEnergyDrained;
    private int guiEnergyPerTick;
    private int guiChunkSize;

    // Prepare state variables.
    private boolean isActive;
    private int usableSources;
    private boolean firstRun;

    // Prepare observer variables.
    private int chunkSize;
    private ForgeChunkManager.Ticket ticket0;
    private ForgeChunkManager.Ticket ticket1;
    private ForgeChunkManager.Ticket ticket2;
    private ForgeChunkManager.Ticket ticket3;
    private ForgeChunkManager.Ticket ticket4;


    /**** Common TileEntity Methods ****/

    public TileQuantumObserver() {
        this.energyDrained = 0;

        this.guiEnergyDrained = 0;
        this.guiChunkSize = 0;

        this.isActive = false;
        this.usableSources = 0;

        this.chunkSize = 0;
        adjustRequiredEnergy();

        this.firstRun = true;

        this.ticket0 = null;
        this.ticket1 = null;
        this.ticket2 = null;
        this.ticket3 = null;
        this.ticket4 = null;
    }

    /**
     * Writes the tags to NBT.
     */
    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);

        // Write the drains.
        HexUtils.writeHexDevicesArrayToNBT(tagCompound, NBT_ENERGY_SOURCES, energySources);

        // Write the energy variables.
        tagCompound.setFloat(NBT_ENERGY_DRAINED, energyDrained);

        // Write the GUI energy variables.
        tagCompound.setInteger(NBT_GUI_ENERGY_DRAINED, guiEnergyDrained);
        tagCompound.setInteger(NBT_GUI_CHUNK_SIZE, guiChunkSize);

        // Write the state variables.
        tagCompound.setBoolean(NBT_IS_ACTIVE, isActive);
        tagCompound.setInteger(NBT_USABLE_SOURCES, usableSources);

        // Write the observer variables.
        tagCompound.setInteger(NBT_CHUNK_SIZE, chunkSize);
    }

    /**
     * Reads the tags from NBT.
     */
    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);

        // Read the sources.
        energySources = HexUtils.readHexDevicesArrayFromNBT(tagCompound, NBT_ENERGY_SOURCES);

        // Read the energy variables.
        energyDrained = tagCompound.getFloat(NBT_ENERGY_DRAINED);

        // Read the GUI energy variables.
        guiEnergyDrained = tagCompound.getInteger(NBT_GUI_ENERGY_DRAINED);
        guiChunkSize = tagCompound.getInteger(NBT_GUI_CHUNK_SIZE);

        // Read the state variables.
        isActive = tagCompound.getBoolean(NBT_IS_ACTIVE);
        usableSources = tagCompound.getInteger(NBT_USABLE_SOURCES);

        // Read the observer variables.
        chunkSize = tagCompound.getInteger(NBT_CHUNK_SIZE);
        adjustRequiredEnergy();
    }

    /**
     * Fired on every tick. Main processing is done here.
     */
    @Override
    public void updateEntity() {
        // Confirm that this is server side.
        if (!worldObj.isRemote) {

            if (firstRun) {
                firstRun = false;
                if (isActive)
                    startChunkLoading();
            }

            energyDrained = 0;
            boolean wasActive = isActive;

            // Check the situation in which the machine has available energy sources and is powered by redstone.
            if (canDrainSource() && worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord) && chunkSize > 0) {
                // Attempt to start processing if it was inactive and set the state to ACTIVE if so.
                if (!isActive) {
                    isActive = usableSources > 0;
                    if (isActive) {
                        HexBlocks.setMachineState(HexBlocks.MACHINE_STATE_ACTIVE, worldObj, xCoord, yCoord, zCoord);

                    }
                    else
                        energyDrained = -1;
                }

                // Check if the machine is now in its active state.
                if (isActive) {
                    // Drain from all sources.
                    drainFromSources();

                    // If the total energy drained is 0, stop processing. Otherwise increment the progress by the amount drained.
                    if (energyDrained < energyPerTick) {
                        if (isActive) {
                            isActive = false;
                            scanSources();
                        }
                        if (!canDrainSource()) {
                            HexBlocks.setMachineState(HexBlocks.MACHINE_STATE_DEAD, worldObj, xCoord, yCoord, zCoord);
                        }
                    }

                }
            }
            // If the machine has no energy and/or is not powered by redstone, stop loading chunks.
            else {
                if (isActive) {
                    isActive = false;
                    scanSources();
                }
                if (!canDrainSource()) {
                    HexBlocks.setMachineState(HexBlocks.MACHINE_STATE_DEAD, worldObj, xCoord, yCoord, zCoord);
                }
            }

            if (!wasActive && isActive) {
                startChunkLoading();
            }
            else if (wasActive && !isActive) {
                stopChunkLoading();
            }

            // Save the energy states to their GUI variables.
            guiEnergyDrained = Math.round(energyDrained);
        }
    }

    /**** ITileHexEnergyDrain Methods ****/

    /**
     * Saves the ArrayList of energy sources.
     * @param energySources The ArrayList to save.
     */
    @Override
    public void setSources(ArrayList<HexDevice> energySources) {
        this.energySources = energySources;
        if (HexConfig.cfgGeneralMachineNetworkDebug && HexConfig.cfgGeneralNetworkDebug)
            System.out.println("[Quantum Observer] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Sources received. s: " + energySources.size());
        recheckSources();
    }

    /**
     * Called by sources to force drains to recheck them.
     */
    @Override
    public void recheckSources() {
        scanSources();
        if (HexConfig.cfgGeneralMachineNetworkDebug && HexConfig.cfgGeneralNetworkDebug)
            System.out.println("[Quantum Observer] (" + xCoord + ", " + yCoord + ", " + zCoord + "): Recheck requested. s: " + usableSources);
    }

    /**
     * Called by Hexorium Probe to display tile entity info to chat.
     * @param player Player to show the message to.
     */
    @Override
    public void displayInfoDrain(EntityPlayer player) {
        HexUtils.addChatProbeTitle(player);
        // If player is not sneaking.
        if (!player.isSneaking()) {
            HexUtils.addChatProbeGenericInfo(player, worldObj, xCoord, yCoord, zCoord);
            player.addChatMessage(new ChatComponentTranslation("msg.probeTypeDrain.txt"));
            String chunkArea = "";
            switch (chunkSize) {
                case 0: chunkArea = "N/A"; break;
                case 1: chunkArea = "1x1"; break;
                case 2: chunkArea = "3x3"; break;
                case 3: chunkArea = "5x5"; break;
                case 4: chunkArea = "7x7"; break;
                case 5: chunkArea = "9x9"; break;
                case 6: chunkArea = "11x11"; break;
            }
            player.addChatMessage(new ChatComponentTranslation("msg.probeChunkArea.txt", chunkArea));
            player.addChatMessage(new ChatComponentTranslation("msg.probeEnergyUsage.txt", energyPerTick));
            int mode = HexUtils.getMetaBitBiInt(HexBlocks.META_MACHINE_STATUS_0, HexBlocks.META_MACHINE_STATUS_1, worldObj, xCoord, yCoord, zCoord);
            player.addChatMessage(new ChatComponentTranslation("msg.probeMachineStatus" + (mode + 1) + ".txt"));
        }
        // If player is sneaking.
        else {
            player.addChatMessage(new ChatComponentTranslation("msg.probeConnectedSources.txt"));
            HexUtils.addChatProbeConnectedMachines(player, energySources, worldObj, xCoord, yCoord, zCoord);
        }
    }

    /**** Custom Methods ****/

    /**
     * Called to check if there are any usable sources available.
     */
    private void scanSources() {
        boolean hasEnergy = canDrainSource();
        usableSources = 0;

        if(energySources != null)
            // Parse the whole energySources ArrayList and call canDrainSource() on each of them.
            for (HexDevice entry : energySources)
                if (HexUtils.checkChunk(worldObj, entry.x, entry.z)) {
                    ITileHexEnergySource energySource = (ITileHexEnergySource) worldObj.getTileEntity(entry.x, entry.y, entry.z);
                    if (energySource != null)
                        if (energySource.canDrainEnergy())
                            usableSources++;
                }

        // Set the state to READY if the energy is now available, but wasn't previously, or if the machine was active, but no longer should be.
        if ((canDrainSource() && !hasEnergy) || (HexBlocks.getMachineState(worldObj, xCoord, yCoord, zCoord) == HexBlocks.MACHINE_STATE_ACTIVE && !isActive))
            HexBlocks.setMachineState(HexBlocks.MACHINE_STATE_READY, worldObj, xCoord, yCoord, zCoord);

        // Otherwise, set the state to DEAD if the energy is now unavailable, but was previously.
        else if (!canDrainSource() && hasEnergy)
            HexBlocks.setMachineState(HexBlocks.MACHINE_STATE_DEAD, worldObj, xCoord, yCoord, zCoord);
        markDirty();
    }

    /**
     * Called to drain from all sources.
     */
    private void drainFromSources() {
        if (energySources != null)
            // Parse the whole energySources ArrayList and attempt to drain energy from every source.
            for (HexDevice entry : energySources)
                if (HexUtils.checkChunk(worldObj, entry.x, entry.z)) {
                    ITileHexEnergySource energySource = (ITileHexEnergySource) worldObj.getTileEntity(entry.x, entry.y, entry.z);
                    if (energySource != null)
                        if (energySource.canDrainEnergy())
                            if (energyDrained < energyPerTick) {
                                if (energyPerTick - energyDrained < energyPerTick / usableSources)
                                    energyDrained = energyDrained + energySource.drainEnergy(energyPerTick - energyDrained);
                                else
                                    energyDrained = energyDrained + energySource.drainEnergy((float) energyPerTick / usableSources);
                            }
                }
    }

    /**
     * Called to check if there are any usable sources available.
     * @return If there are any usable sources.
     */
    private boolean canDrainSource() {
        return usableSources > 0;
    }

    /**
     * Called to adjust the required energy based on chunk loading size.
     */
    public void adjustRequiredEnergy() {
        switch (chunkSize) {
            case 0: energyPerTick = 0; break;
            case 1: energyPerTick = HexConfig.cfgObserverSize1; break;
            case 2: energyPerTick = HexConfig.cfgObserverSize2; break;
            case 3: energyPerTick = HexConfig.cfgObserverSize3; break;
            case 4: energyPerTick = HexConfig.cfgObserverSize4; break;
            case 5: energyPerTick = HexConfig.cfgObserverSize5; break;
            case 6: energyPerTick = HexConfig.cfgObserverSize6; break;
        }
        guiEnergyPerTick = energyPerTick;
    }

    /**
     * Called when the machine should start loading the chunks.
     */
    private void startChunkLoading() {
        if (chunkSize > 0) {
            if (HexConfig.cfgObserverDebug)
                System.out.println("[Quantum Observer] Chunks are now being loaded.");

            ChunkManager.instance.loadChunks(this);
        }
    }

    /**
     * Called when the machine should no longer be loading the chunks.
     */
    public void stopChunkLoading() {
        if (HexConfig.cfgObserverDebug)
            System.out.println("[Quantum Observer] Chunks are no longer being loaded.");

        ChunkManager.instance.unloadChunks(this);
    }

    public Collection<ChunkCoordIntPair> getChunksToLoad() {
        return ChunkManager.getChunkSquare(xCoord, zCoord, chunkSize-1);
    }

    /**
     * Check if the TIle Entity can be used by the player.
     */
    public boolean isUsableByPlayer(EntityPlayer player) {
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64.0D;
    }

    /**** Getters and Setters ****/

    /**
     * Retrieves the machine name.
     */
    public String getInventoryName() {
        return INVENTORY_NAME;
    }

    public void setChunkSize(int chunkSize) {
        int oldChunkSize = this.chunkSize;

        this.chunkSize = chunkSize;
        this.guiChunkSize = chunkSize;
        adjustRequiredEnergy();

        if (oldChunkSize != this.chunkSize && isActive) {
            stopChunkLoading();
            startChunkLoading();
        }
    }

    public void setGuiEnergyDrained(int guiEnergyDrained) {
        this.guiEnergyDrained = guiEnergyDrained;
    }

    public int getGuiEnergyDrained() {
        return this.guiEnergyDrained;
    }

    public void setGuiEnergyPerTick(int guiEnergyPerTick) {
        this.guiEnergyPerTick = guiEnergyPerTick;
    }

    public int getGuiEnergyPerTick() {
        return this.guiEnergyPerTick;
    }

    public void setGuiChunkSize(int guiChunkSize) {
        this.guiChunkSize = guiChunkSize;
    }

    public int getGuiChunkSize() {
        return this.guiChunkSize;
    }
}
