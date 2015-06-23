package com.celestek.hexcraft.inventory;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.tileentity.TileHexoriumGenerator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.5.1
 * @since 2015-04-25
 */

@SideOnly(Side.CLIENT)
public class GuiHexoriumGenerator extends GuiContainer {

    // Prepare a TileHexoriumGenerator object.
    private TileHexoriumGenerator tileEntity;

    /**
     * Constructor for GuiMatrixReconstructor.
     */
    public GuiHexoriumGenerator(InventoryPlayer invPlayer, TileHexoriumGenerator tileEntity) {
        super(new ContainerHexoriumGenerator(invPlayer, tileEntity));

        // Save the Tile Entity.
        this.tileEntity = tileEntity;
    }

    /**
     * Draws strings of the GUI.
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2){
        // Get the name string.
        String name = tileEntity.hasCustomInventoryName() ? tileEntity.getInventoryName() : I18n.format(tileEntity.getInventoryName());

        // Check if the output energy of generator is smaller or equal to energyPerTick.
        if (tileEntity.energyOutGui <= TileHexoriumGenerator.energyPerTick) {
            // If yes, draw the output string normally.
            String out = tileEntity.energyOutGui + " HEX/t";
            fontRendererObj.drawString(out, 142 - fontRendererObj.getStringWidth(out) / 2, ySize - 94, 0x404040);
        }
        else {
            // If it is higher, draw the output string in red and capped to energyPerTick.
            String out = TileHexoriumGenerator.energyPerTick + " HEX/t";
            fontRendererObj.drawString(out, 142 - fontRendererObj.getStringWidth(out) / 2, ySize - 94, 0xFF0000);
        }

        // Draw the name string.
        fontRendererObj.drawString(name, xSize / 2 - fontRendererObj.getStringWidth(name) / 2, 6, 0x404040);
        // Draw the player inventory string.
        fontRendererObj.drawString(I18n.format("container.inventory"), 8, ySize - 94, 4210752);
        // Draw the info box string.
        fontRendererObj.drawString("Out:", 111 - fontRendererObj.getStringWidth("Out:"), ySize - 94, 0x404040);
    }

    /**
     * Draws textures of the GUI.
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        // Bind the texture of the GUI.
        mc.getTextureManager().bindTexture(new ResourceLocation(HexCraft.MODID, "textures/gui/guiHexoriumGenerator.png"));
        // Prepare x and y values (top left corner).
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;

        // Draw the background of GUI.
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

        // Draw the progress bar.
        int i = tileEntity.getEnergyScaled(13);
        if (i > -1)
            drawTexturedModalRect(x + 80, y + 25 + 12 - i, 176, 12 - i, 14, i + 2);
    }
}
