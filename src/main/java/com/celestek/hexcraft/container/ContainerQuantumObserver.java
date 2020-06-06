package com.celestek.hexcraft.container;

import com.celestek.hexcraft.tileentity.TileQuantumObserver;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.item.ItemStack;

public class ContainerQuantumObserver extends Container {

    // Crafter IDs
    private static final int GUI_ID_ENERGY_DRAINED = 0;
    private static final int GUI_ID_ENERGY_PER_TICK = 1;
    private static final int GUI_ID_CHUNK_SIZE = 2;

    private final TileQuantumObserver tileQuantumObserver;

    private int lastEnergyDrained;
    private int lastEnergyPerTick;
    private int lastChunkSize;

    /**
     * Constructor
     */
    public ContainerQuantumObserver(TileQuantumObserver tileQuantumObserver) {
        // Save the Tile Entity.
        this.tileQuantumObserver = tileQuantumObserver;
    }

    /**
     * Register the progress bar updates.
     */
    @Override
    public void addCraftingToCrafters(ICrafting craft) {
        super.addCraftingToCrafters(craft);

        craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_DRAINED, tileQuantumObserver.getGuiEnergyDrained());
        craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_PER_TICK, tileQuantumObserver.getGuiEnergyPerTick());
        craft.sendProgressBarUpdate(this, GUI_ID_CHUNK_SIZE, tileQuantumObserver.getGuiChunkSize());
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < crafters.size(); i++) {
            ICrafting craft = (ICrafting) crafters.get(i);

            if (lastEnergyDrained != tileQuantumObserver.getGuiEnergyDrained()) {
                craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_DRAINED, tileQuantumObserver.getGuiEnergyDrained());
            }

            if (lastEnergyPerTick != tileQuantumObserver.getGuiEnergyPerTick()) {
                craft.sendProgressBarUpdate(this, GUI_ID_ENERGY_PER_TICK, tileQuantumObserver.getGuiEnergyPerTick());
            }

            if (lastChunkSize != tileQuantumObserver.getGuiChunkSize()) {
                craft.sendProgressBarUpdate(this, GUI_ID_CHUNK_SIZE, tileQuantumObserver.getGuiChunkSize());
            }
        }

        // Save the new values as last value.
        lastEnergyDrained = tileQuantumObserver.getGuiEnergyDrained();
        lastEnergyPerTick = tileQuantumObserver.getGuiEnergyPerTick();
        lastChunkSize = tileQuantumObserver.getGuiChunkSize();
    }

    /**
     * Called by the client to update the progress bars.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int value) {
        switch (id) {
            case GUI_ID_ENERGY_DRAINED:
                tileQuantumObserver.setGuiEnergyDrained(value);
                break;
            case GUI_ID_ENERGY_PER_TICK:
                tileQuantumObserver.setGuiEnergyPerTick(value);
                break;
            case GUI_ID_CHUNK_SIZE:
                tileQuantumObserver.setGuiChunkSize(value);
                break;
        }
    }

    /**
     * Check if the container can be interacted with by the player.
     */
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tileQuantumObserver.isUsableByPlayer(player);
    }

    @Override
    public void putStackInSlot(int slotID, ItemStack itemStack) {
        // Fix for a weird crash with some mods when flying and opening the UI.
        if (inventorySlots.size() > slotID)
            this.getSlot(slotID).putStack(itemStack);
    }
}
