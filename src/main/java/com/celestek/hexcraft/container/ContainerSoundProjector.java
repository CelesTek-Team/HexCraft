package com.celestek.hexcraft.container;

import com.celestek.hexcraft.tileentity.TileSoundProjector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.item.ItemStack;

public class ContainerSoundProjector extends Container {

    private final TileSoundProjector tileSoundProjector;

    public ContainerSoundProjector(TileSoundProjector tileSoundProjector) {
        this.tileSoundProjector = tileSoundProjector;
    }

    @Override public void addCraftingToCrafters(ICrafting craft) {
        super.addCraftingToCrafters(craft);
    }


    @Override public void detectAndSendChanges() {
        super.detectAndSendChanges();
    }

    @SideOnly(Side.CLIENT) @Override public void updateProgressBar(int id, int value) {
        super.updateProgressBar(id, value);
    }

    @Override public boolean canInteractWith(EntityPlayer player) {
        return tileSoundProjector.isUsableByPlayer(player);
    }

    @Override
    public void putStackInSlot(int slotID, ItemStack itemStack) {
        // Fix for a weird crash with some mods when flying and opening the UI.
        if (inventorySlots.size() > slotID)
            this.getSlot(slotID).putStack(itemStack);
    }
}
