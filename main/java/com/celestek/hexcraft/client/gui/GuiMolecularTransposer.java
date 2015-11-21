package com.celestek.hexcraft.client.gui;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.container.ContainerMolecularTransposer;
import com.celestek.hexcraft.container.InventoryMolecularTransposer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.8.0
 */

@SideOnly(Side.CLIENT)
public class GuiMolecularTransposer extends GuiContainer {

    // GUI Sizes
    private static final int GUI_SIZE_X = 176;
    private static final int GUI_SIZE_Y = 166;

    // Prepare the inventory.
    InventoryMolecularTransposer inventory;

    /**
     * Constructor for GuiMolecularTransposer.
     */
    public GuiMolecularTransposer(EntityPlayer player, InventoryPlayer invPlayer, ItemStack device) {
        super(new ContainerMolecularTransposer(player, invPlayer, device));

        inventory = new InventoryMolecularTransposer(player, device);
    }

    /**
     * Draws strings of the GUI.
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        // Draw the name string.
        String name = I18n.format(inventory.getInventoryName());
        fontRendererObj.drawString(name, GUI_SIZE_X / 2 - fontRendererObj.getStringWidth(name) / 2, 6, 0x404040);
        // Draw the player container string.
        fontRendererObj.drawString(I18n.format("container.inventory"), 8, GUI_SIZE_Y - 94, 4210752);
    }

    /**
     * Draws textures of the GUI.
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        // Bind the texture of the GUI.
        mc.getTextureManager().bindTexture(new ResourceLocation(HexCraft.MODID, "textures/gui/guiMolecularTransposer.png"));
        // Prepare x and y values (top left corner).
        int x = (width - GUI_SIZE_X) / 2;
        int y = (height - GUI_SIZE_Y) / 2;

        // Draw the background of GUI.
        drawTexturedModalRect(x, y, 0, 0, GUI_SIZE_X, GUI_SIZE_Y);
    }
}
