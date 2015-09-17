package com.celestek.hexcraft.gui;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.inventory.ContainerHexoriumValve;
import com.celestek.hexcraft.tileentity.TileHexoriumValve;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

/**
 * @Author CoffeePirate    <celestek@openmailbox.org>
 * @Version 0.1.0
 */

public class GuiHexoriumValve extends GuiContainer {
    private TileHexoriumValve tileHexoriumValve;

    public GuiHexoriumValve(TileHexoriumValve tileHexoriumValve) {
        super(new ContainerHexoriumValve(tileHexoriumValve));

        this.tileHexoriumValve = tileHexoriumValve;
    }

    @Override protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        super.drawGuiContainerForegroundLayer(par1, par2);

        String name = TileHexoriumValve.MACHINE_NAME;

        String tankCap = "Capacity: " + tileHexoriumValve.getTankCapacity() + "mB";
        String tankFluidLevel = "Current: " + tileHexoriumValve.getTankFluidLevel() + "mB";

        System.out.println(tankCap);
        System.out.println(tankFluidLevel);


        // Draw the name
        fontRendererObj.drawString(name, xSize / 2 - fontRendererObj.getStringWidth(name) / 2, 6,
            0x404040);
    }

    @Override protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_,
        int p_146976_3_) {
        // Bind the texture of the GUI.
        mc.getTextureManager().bindTexture(new ResourceLocation(HexCraft.MODID, "textures/gui/guiPersonalTeleportationPad.png"));
        // Prepare x and y values (top left corner).
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;

        // Draw the background of GUI.
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

    }
}
