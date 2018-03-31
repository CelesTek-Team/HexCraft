package com.celestek.hexcraft.client.gui;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.container.ContainerPersonalTeleportationPad;
import com.celestek.hexcraft.container.ContainerQuantumObserver;
import com.celestek.hexcraft.tileentity.TilePersonalTeleportationPad;
import com.celestek.hexcraft.tileentity.TileQuantumObserver;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

@SideOnly(Side.CLIENT)
public class GuiQuantumObserver extends GuiContainer {

    // GUI Sizes
    private static final int GUI_SIZE_X = 176;
    private static final int GUI_SIZE_Y = 88;

    // GUI Strings
    private static final String GUI_STRING_CHUNK_AREA = "hexcraft.container.chunk_area";
    private static final String GUI_STRING_ENERGY_USAGE = "hexcraft.container.energy_usage";
    private static final String GUI_STRING_IN = "hexcraft.container.in";

    private TileQuantumObserver tileQuantumObserver;

    /**
     * Constructor for GuiPersonalTeleportationPad.
     */
    public GuiQuantumObserver(TileQuantumObserver tileQuantumObserver) {
        super(new ContainerQuantumObserver(tileQuantumObserver));

        // Save the Tile Entity.
        this.tileQuantumObserver = tileQuantumObserver;
    }

    /**
     * Draws strings of the GUI.
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2){

        // Check if the input energy of machine is between 0 and energyPerTick (non-inclusive). If yes, draw the input string in red.
        if (tileQuantumObserver.getGuiEnergyDrained() > 0 && tileQuantumObserver.getGuiEnergyDrained() < tileQuantumObserver.getGuiEnergyPerTick()) {
            String out = tileQuantumObserver.getGuiEnergyDrained() + " HEX/t";
            fontRendererObj.drawString(out, 142 - fontRendererObj.getStringWidth(out) / 2, 205 - 94, 0xFF0000);
        }
        // Otherwise, check if the input energy of machine is equal to -1. If yes, draw the input string in red and make it always show 0.
        else if (tileQuantumObserver.getGuiEnergyDrained() == -1) {
            String out = "0 HEX/t";
            fontRendererObj.drawString(out, 142 - fontRendererObj.getStringWidth(out) / 2, 205 - 94, 0xFF0000);
        }
        // Otherwise, check if the input energy of machine is equal to energyPerTick. If yes, draw the input string in green.
        else if (tileQuantumObserver.getGuiEnergyDrained() == tileQuantumObserver.getGuiEnergyPerTick()) {
            String out = tileQuantumObserver.getGuiEnergyDrained() + " HEX/t";
            fontRendererObj.drawString(out, 142 - fontRendererObj.getStringWidth(out) / 2, 205 - 94, 0x00FF00);
        }
        // In all other situations, draw the string normally.
        else {
            String out = tileQuantumObserver.getGuiEnergyDrained() + " HEX/t";
            fontRendererObj.drawString(out, 142 - fontRendererObj.getStringWidth(out) / 2, 205 - 94, 0x404040);
        }

        // Draw the name string.
        String name = I18n.format(tileQuantumObserver.getInventoryName());
        fontRendererObj.drawString(name, GUI_SIZE_X / 2 - fontRendererObj.getStringWidth(name) / 2, 45, 0x404040);

        // Draw the chunk area string.
        fontRendererObj.drawString(I18n.format(GUI_STRING_CHUNK_AREA) + ": ", 88, 60, 0x404040);
        String chunkArea = "";
        switch (tileQuantumObserver.getGuiChunkSize()) {
            case 0: chunkArea = "N/A"; break;
            case 1: chunkArea = "1x1"; break;
            case 2: chunkArea = "3x3"; break;
            case 3: chunkArea = "5x5"; break;
            case 4: chunkArea = "7x7"; break;
            case 5: chunkArea = "9x9"; break;
            case 6: chunkArea = "11x11"; break;
        }
        fontRendererObj.drawString(chunkArea, 88, 70, 0x404040);

        // Draw the energy usage string.
        fontRendererObj.drawString(I18n.format(GUI_STRING_ENERGY_USAGE) + ": ", 88, 84, 0x404040);
        String energyUsage = tileQuantumObserver.getGuiEnergyPerTick() + " HEX/t";
        fontRendererObj.drawString(energyUsage, 88, 94, 0x404040);

        // Draw the info box string.
        fontRendererObj.drawString(I18n.format(GUI_STRING_IN) + ":", 111 - fontRendererObj.getStringWidth(I18n.format(GUI_STRING_IN) + ":"), 205 - 94, 0x404040);
    }

    /**
     * Draws textures of the GUI.
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        // Bind the texture of the GUI.
        mc.getTextureManager().bindTexture(new ResourceLocation(HexCraft.MODID, "textures/gui/guiQuantumObserver.png"));
        // Prepare x and y values (top left corner).
        int x = (width - GUI_SIZE_X) / 2;
        int y = (height - GUI_SIZE_Y) / 2;

        // Draw the background of GUI.
        drawTexturedModalRect(x, y, 0, 0, GUI_SIZE_X, GUI_SIZE_Y);

        // Draw the chunk visualiser.
        int mod = tileQuantumObserver.getGuiChunkSize();
        if (mod > 0) {
            mod = (mod - 1) * 5;
            drawTexturedModalRect(x + 53 - mod, y + 47 - mod, 25 - mod, 113 - mod, 4 + mod * 2, 4 + mod * 2);
        }
    }
}
