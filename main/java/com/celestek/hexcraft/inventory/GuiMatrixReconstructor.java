package com.celestek.hexcraft.inventory;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.tileentity.TileMatrixReconstructor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-25
 */

@SideOnly(Side.CLIENT)
public class GuiMatrixReconstructor extends GuiContainer {

    // Prepare a TileMatrixReconstructor object.
    private TileMatrixReconstructor tileEntity;

    /**
     * Constructor for GuiMatrixReconstructor.
     */
    public GuiMatrixReconstructor(InventoryPlayer invPlayer, TileMatrixReconstructor tileEntity) {
        super(new ContainerMatrixReconstructor(invPlayer, tileEntity));

        // Save the Tile Entity.
        this.tileEntity = tileEntity;
    }

    /**
     * Draws strings of the GUI.
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2){
        // Get the name string.
        String name = tileEntity.hasCustomInventoryName() ? tileEntity.getInventoryName() : I18n.format(tileEntity.getInventoryName());

        // Check if the input energy of machine is between 0 and 64 (non-inclusive). If yes, draw the input string in red.
        if (tileEntity.energyInGui > 0 && tileEntity.energyInGui < 64) {
            String out = tileEntity.energyInGui + " HEX/t";
            fontRendererObj.drawString(out, 142 - fontRendererObj.getStringWidth(out) / 2, ySize - 94, 0xFF0000);
        }
        // Otherwise, check if the input energy of machine is equal to -1. If yes, draw the input string in red and make it always show 0.
        else if (tileEntity.energyInGui == -1) {
            String out = "0 HEX/t";
            fontRendererObj.drawString(out, 142 - fontRendererObj.getStringWidth(out) / 2, ySize - 94, 0xFF0000);
        }
        // Otherwise, check if the input energy of machine is equal to 64. If yes, draw the input string in green.
        else if (tileEntity.energyInGui == 64) {
            String out = tileEntity.energyInGui + " HEX/t";
            fontRendererObj.drawString(out, 142 - fontRendererObj.getStringWidth(out) / 2, ySize - 94, 0x00FF00);
        }
        // In all other situations, draw the string normally.
        else {
            String out = tileEntity.energyInGui + " HEX/t";
            fontRendererObj.drawString(out, 142 - fontRendererObj.getStringWidth(out) / 2, ySize - 94, 0x404040);
        }

        // Draw the name string.
        fontRendererObj.drawString(name, xSize / 2 - fontRendererObj.getStringWidth(name) / 2, 6, 0x404040);
        // Draw the player inventory string.
        fontRendererObj.drawString(I18n.format("container.inventory"), 8, ySize - 94, 0x404040);
        // Draw the info box string.
        fontRendererObj.drawString("In:", 111 - fontRendererObj.getStringWidth("In:"), ySize - 94, 0x404040);
    }

    /**
     * Draws textures of the GUI.
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        // Bind the texture of the GUI.
        mc.getTextureManager().bindTexture(new ResourceLocation(HexCraft.MODID, "textures/gui/guiMatrixReconstructor.png"));
        // Prepare x and y values (top left corner).
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;

        // Draw the background of GUI.
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

        // Draw the progress bar.
        int i = tileEntity.getEnergyScaled(35);
        drawTexturedModalRect(x + 70, y + 30, 176, 0, i + 1, 26);
    }
}
