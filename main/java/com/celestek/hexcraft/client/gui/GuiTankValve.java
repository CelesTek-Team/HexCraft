package com.celestek.hexcraft.client.gui;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.container.ContainerTankValve;
import com.celestek.hexcraft.tileentity.TileTankValve;
import com.celestek.hexcraft.util.HexUtils;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * @author CoffeePirate     <celestek@openmailbox.org>
 * @version 0.7.0
 */

public class GuiTankValve extends GuiContainer {

    // GUI Sizes
    private static final int GUI_SIZE_X = 176;
    private static final int GUI_SIZE_Y = 90;

    // GUI Strings
    private static final String GUI_STRING_F = "hexcraft.container.f";
    private static final String GUI_STRING_L = "hexcraft.container.l";
    private static final String GUI_STRING_M = "hexcraft.container.m";
    private static final String GUI_STRING_EMPTY = "hexcraft.container.empty";
    private static final String GUI_STRING_TANK_NOT_FORMED = "hexcraft.container.tankNotFormed";

    private TileTankValve tileTankValve;

    public GuiTankValve(TileTankValve tileTankValve) {
        super(new ContainerTankValve(tileTankValve));

        this.tileTankValve = tileTankValve;
    }

    @Override protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        super.drawGuiContainerForegroundLayer(par1, par2);

        // Draw the name
        String name = I18n.format(TileTankValve.MACHINE_NAME);
        fontRendererObj.drawString(name, GUI_SIZE_X / 2 - fontRendererObj.getStringWidth(name) / 2, 44, 0x404040);

        if (tileTankValve.getGuiFluidIns() == 1) {
            fontRendererObj.drawString(I18n.format(GUI_STRING_F) + ": " + I18n.format(GUI_STRING_EMPTY), 61, 93, 0x404040);
            fontRendererObj.drawString(I18n.format(GUI_STRING_L) + ": 0 mB", 61, 102, 0x404040);
            fontRendererObj.drawString(I18n.format(GUI_STRING_M) + ": " + HexUtils.formatFluids(tileTankValve.getGuiTankCapacity()), 61, 111, 0x404040);
        }
        else if (tileTankValve.getGuiFluidIns() == 2) {
                Fluid fluid = FluidRegistry.getFluid(tileTankValve.getGuiFluidID());
                if (fluid != null) {
                    fontRendererObj.drawString("F: " + fluid.getLocalizedName(null), 61, 93, 0x404040);
                    fontRendererObj.drawString("L: " + HexUtils.formatFluids(tileTankValve.getGuiFluidLevel()), 61, 102, 0x404040);
                    fontRendererObj.drawString("M: " + HexUtils.formatFluids(tileTankValve.getGuiTankCapacity()), 61, 111, 0x404040);
                }
            }
        else
            fontRendererObj.drawString(I18n.format(GUI_STRING_TANK_NOT_FORMED), 61, 93, 0xFF0000);

    }

    @Override protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_,
        int p_146976_3_) {
        // Bind the texture of the GUI.
        // Prepare x and y values (top left corner).
        int x = (width - GUI_SIZE_X) / 2;
        int y = (height - GUI_SIZE_Y) / 2;

        // Draw the background of GUI.
        mc.getTextureManager().bindTexture(new ResourceLocation(HexCraft.MODID, "textures/gui/guiTankValve.png"));
        drawTexturedModalRect(x, y, 0, 0, GUI_SIZE_X, GUI_SIZE_Y);

        if (tileTankValve.getGuiFluidIns() == 1 || tileTankValve.getGuiFluidIns() == 2) {
            Fluid fluid = FluidRegistry.getFluid(tileTankValve.getGuiFluidID());
            if (fluid != null) {
                mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
                IIcon c = fluid.getStillIcon();
                float fill = (float) tileTankValve.getGuiFluidLevel() / tileTankValve.getGuiTankCapacity();

                for (int i = 0; i < (int) (fill * 4); i++) {
                    drawTexturedModelRectFromIcon(x + 20, y + 66 - i * 16, c, 16, 16);
                    drawTexturedModelRectFromIcon(x + 36, y + 66 - i * 16, c, 16, 16);
                }
                drawTexturedModelRectFromIconPartial(x + 20, y + 82 - fill * 4 * 16, c, 16, (fill * 4 - (int) (fill * 4)) * 16, fill * 4 - (int) (fill * 4));
                drawTexturedModelRectFromIconPartial(x + 36, y + 82 - fill * 4 * 16, c, 16, (fill * 4 - (int) (fill * 4)) * 16, fill * 4 - (int) (fill * 4));

                mc.getTextureManager().bindTexture(new ResourceLocation(HexCraft.MODID, "textures/gui/guiTankValve.png"));
            }
        }

        drawTexturedModalRect(x + 20, y + 33, 176, 0, 9, 33);

    }

    public void drawTexturedModelRectFromIconPartial(int x, float y, IIcon c, int width, float height, float iconHeight)
    {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x, y + height, this.zLevel, c.getMinU(), c.getMaxV());
        tessellator.addVertexWithUV(x + width, y + height, this.zLevel, c.getMaxU(), c.getMaxV());
        tessellator.addVertexWithUV(x + width, y, this.zLevel, c.getMaxU(), c.getInterpolatedV(16 - iconHeight * 16));
        tessellator.addVertexWithUV(x, y, this.zLevel, c.getMinU(), c.getInterpolatedV(16 - iconHeight * 16));
        tessellator.draw();
    }
}
