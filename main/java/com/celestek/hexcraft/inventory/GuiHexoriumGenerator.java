package com.celestek.hexcraft.inventory;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.tileentity.TileEntityHexoriumGenerator;
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
public class GuiHexoriumGenerator extends GuiContainer {

    // Prepare a TileEntityHexoriumGenerator object.
    private TileEntityHexoriumGenerator tileEntity;

    /**
     * Constructor for GuiMatrixReconstructor.
     */
    public GuiHexoriumGenerator(InventoryPlayer invPlayer, TileEntityHexoriumGenerator tileEntity) {
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
        // Draw the name string.
        fontRendererObj.drawString(name, xSize / 2 - fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
        // Draw the player inventory string.
        fontRendererObj.drawString(I18n.format("container.inventory"), 8, ySize - 94, 4210752);
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
