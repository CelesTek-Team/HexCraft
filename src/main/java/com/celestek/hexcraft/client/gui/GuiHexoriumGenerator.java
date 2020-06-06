package com.celestek.hexcraft.client.gui;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.container.ContainerHexoriumGenerator;
import com.celestek.hexcraft.tileentity.TileHexoriumGenerator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GuiHexoriumGenerator extends GuiContainer {

    // GUI Sizes
    private static final int GUI_SIZE_X = 176;
    private static final int GUI_SIZE_Y = 166;

    // GUI Strings
    private static final String GUI_STRING_INVENTORY = "container.inventory";
    private static final String GUI_STRING_OUT = "hexcraft.container.out";

    private TileHexoriumGenerator tileHexoriumGenerator;

    /**
     * Constructor for GuiMatrixReconstructor.
     */
    public GuiHexoriumGenerator(InventoryPlayer invPlayer, TileHexoriumGenerator tileHexoriumGenerator) {
        super(new ContainerHexoriumGenerator(invPlayer, tileHexoriumGenerator));

        // Save the Tile Entity.
        this.tileHexoriumGenerator = tileHexoriumGenerator;
    }

    /**
     * Draws strings of the GUI.
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2){

        // Check if the output energy of generator is smaller or equal to energyPerTick.
        if (tileHexoriumGenerator.getGuiEnergyDrained() <= tileHexoriumGenerator.getEnergyPerTick()) {
            // If yes, draw the output string normally.
            String out = tileHexoriumGenerator.getGuiEnergyDrained() + " HEX/t";
            fontRendererObj.drawString(out, 142 - fontRendererObj.getStringWidth(out) / 2, GUI_SIZE_Y - 94, 0x404040);
        }
        else {
            // If it is higher, draw the output string in red and capped to energyPerTick.
            String out = tileHexoriumGenerator.getEnergyPerTick() + " HEX/t";
            fontRendererObj.drawString(out, 142 - fontRendererObj.getStringWidth(out) / 2, GUI_SIZE_Y - 94, 0xFF0000);
        }

        // Draw the name string.
        String name = I18n.format(tileHexoriumGenerator.getInventoryName());
        fontRendererObj.drawString(name, GUI_SIZE_X / 2 - fontRendererObj.getStringWidth(name) / 2, 6, 0x404040);
        // Draw the player container string.
        fontRendererObj.drawString(I18n.format(GUI_STRING_INVENTORY), 8, GUI_SIZE_Y - 94, 4210752);
        // Draw the info box string.
        fontRendererObj.drawString(I18n.format(GUI_STRING_OUT) + ":", 111 - fontRendererObj.getStringWidth(I18n.format(GUI_STRING_OUT) + ":"), GUI_SIZE_Y - 94, 0x404040);
    }

    /**
     * Draws textures of the GUI.
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        // Bind the texture of the GUI.
        mc.getTextureManager().bindTexture(new ResourceLocation(HexCraft.MODID, "textures/gui/guiHexoriumGenerator.png"));
        // Prepare x and y values (top left corner).
        int x = (width - GUI_SIZE_X) / 2;
        int y = (height - GUI_SIZE_Y) / 2;

        // Draw the background of GUI.
        drawTexturedModalRect(x, y, 0, 0, GUI_SIZE_X, GUI_SIZE_Y);

        // Draw the progress bar.
        int i = tileHexoriumGenerator.getEnergyScaled(13);
        if (i > -1)
            drawTexturedModalRect(x + 80, y + 25 + 12 - i, 176, 12 - i, 14, i + 2);
    }
}
