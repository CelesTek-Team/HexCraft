package com.celestek.hexcraft.gui;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.container.ContainerPersonalTeleportationPad;
import com.celestek.hexcraft.tileentity.TilePersonalTeleportationPad;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.7.0
 */

@SideOnly(Side.CLIENT)
public class GuiPersonalTeleportationPad extends GuiContainer {

    // GUI Sizes
    private static final int GUI_SIZE_X = 176;
    private static final int GUI_SIZE_Y = 88;

    private TilePersonalTeleportationPad tilePersonalTeleportationPad;

    /**
     * Constructor for GuiPersonalTeleportationPad.
     */
    public GuiPersonalTeleportationPad(TilePersonalTeleportationPad tilePersonalTeleportationPad) {
        super(new ContainerPersonalTeleportationPad(tilePersonalTeleportationPad));

        // Save the Tile Entity.
        this.tilePersonalTeleportationPad = tilePersonalTeleportationPad;
    }

    /**
     * Draws strings of the GUI.
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2){

        // Draw the input string.
        String out = tilePersonalTeleportationPad.getGuiEnergyDrained() + " HEX/t";
        fontRendererObj.drawString(out, 142 - fontRendererObj.getStringWidth(out) / 2, 205 - 94, 0x404040);

        // Draw the name string.
        String name = I18n.format(tilePersonalTeleportationPad.getInventoryName());
        fontRendererObj.drawString(name, GUI_SIZE_X / 2 - fontRendererObj.getStringWidth(name) / 2, 45, 0x404040);

        // Draw the charge string.
        String charge = I18n.format("hexcraft.container.charge") + ": " + tilePersonalTeleportationPad.getEnergyScaled(100) + "%";
        fontRendererObj.drawString(charge, 24, 90, 0x404040);

        // Draw the number strings.
        fontRendererObj.drawString("1", 91 - fontRendererObj.getStringWidth("1"), 68, 0x404040);
        fontRendererObj.drawString("2", 155 - fontRendererObj.getStringWidth("2"), 68, 0x404040);

        // Draw the info box string.
        fontRendererObj.drawString("In:", 111 - fontRendererObj.getStringWidth("In:"), 205 - 94, 0x404040);
    }

    /**
     * Draws textures of the GUI.
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        // Bind the texture of the GUI.
        mc.getTextureManager().bindTexture(new ResourceLocation(HexCraft.MODID, "textures/gui/guiPersonalTeleportationPad.png"));
        // Prepare x and y values (top left corner).
        int x = (width - GUI_SIZE_X) / 2;
        int y = (height - GUI_SIZE_Y) / 2;

        // Draw the background of GUI.
        drawTexturedModalRect(x, y, 0, 0, GUI_SIZE_X, GUI_SIZE_Y);

        // Draw the progress bar.
        int i = tilePersonalTeleportationPad.getEnergyScaled(64);
        // If the bar exceeds total length, trim it.
        if (i > 128)
            i = 128;
        drawTexturedModalRect(x + 23, y + 37, 0, 88, i + 1, 12);
    }
}
