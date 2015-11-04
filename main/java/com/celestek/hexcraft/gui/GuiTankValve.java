package com.celestek.hexcraft.gui;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.inventory.ContainerTankValve;
import com.celestek.hexcraft.tileentity.TileTankValve;
import com.celestek.hexcraft.util.HexUtils;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

/**
 * @Author CoffeePirate    <celestek@openmailbox.org>
 * @Version 0.1.0
 */

public class GuiTankValve extends GuiContainer {
    private TileTankValve tileTankValve;

    public GuiTankValve(TileTankValve tileTankValve) {
        super(new ContainerTankValve(tileTankValve));

        this.tileTankValve = tileTankValve;
    }

    @Override protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        super.drawGuiContainerForegroundLayer(par1, par2);

        String name = TileTankValve.MACHINE_NAME;

        // Draw the name
        fontRendererObj.drawString(name, 176 / 2 - fontRendererObj.getStringWidth(name) / 2, 44, 0x404040);

        if (tileTankValve.getGuiFluidInserted() == 1) {
            fontRendererObj.drawString("F: Empty", 81, 93, 0x404040);
            fontRendererObj.drawString("S: 0 mB", 81, 102, 0x404040);
            fontRendererObj.drawString("M: " + HexUtils.formatFluids(tileTankValve.getGuiTankCapacity()), 81, 111, 0x404040);
        }
        else if (tileTankValve.getGuiFluidInserted() == 2) {
                Fluid fluid = FluidRegistry.getFluid(tileTankValve.getGuiFluidID());
                if (fluid != null) {
                    fontRendererObj.drawString("F: " + fluid.getLocalizedName(null), 81, 93, 0x404040);
                    fontRendererObj.drawString("S: " + HexUtils.formatFluids(tileTankValve.getGuiTankFluidLevel()), 81, 102, 0x404040);
                    fontRendererObj.drawString("M: " + HexUtils.formatFluids(tileTankValve.getGuiTankCapacity()), 81, 111, 0x404040);
                }
            }
        else
            fontRendererObj.drawString("Tank not set up.", 81, 93, 0xFF0000);

    }

    @Override protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_,
        int p_146976_3_) {
        // Bind the texture of the GUI.
        // Prepare x and y values (top left corner).
        int x = (width - 176) / 2;
        int y = (height - 90) / 2;

        // Draw the background of GUI.
        mc.getTextureManager().bindTexture(new ResourceLocation(HexCraft.MODID, "textures/gui/guiTankValve.png"));
        drawTexturedModalRect(x, y, 0, 0, 176, 90);

        if (tileTankValve.getGuiFluidInserted() == 1) {
            Fluid fluid = FluidRegistry.getFluid(tileTankValve.getGuiFluidID());
            if (fluid != null) {
                mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
                IIcon c = fluid.getStillIcon();
                float fill = (float) tileTankValve.getGuiTankFluidLevel() / tileTankValve.getGuiTankCapacity();

                for (int i = 0; i < (int) (fill * 4); i++) {
                    drawTexturedModelRectFromIcon(x + 40, y + 65 - i * 16, c, 16, 16);
                    drawTexturedModelRectFromIcon(x + 56, y + 65 - i * 16, c, 16, 16);
                }
                drawTexturedModelRectFromIconPartial(x + 40, y + 81 - fill * 4 * 16, c, 16, (fill * 4 - (int) (fill * 4)) * 16, fill * 4 - (int) (fill * 4));
                drawTexturedModelRectFromIconPartial(x + 56, y + 81 - fill * 4 * 16, c, 16, (fill * 4 - (int) (fill * 4)) * 16, fill * 4 - (int) (fill * 4));

                mc.getTextureManager().bindTexture(new ResourceLocation(HexCraft.MODID, "textures/gui/guiTankValve.png"));
            }
        }

        drawTexturedModalRect(x + 40, y + 32, 176, 0, 9, 33);

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