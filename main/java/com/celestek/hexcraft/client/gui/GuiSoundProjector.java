package com.celestek.hexcraft.client.gui;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.container.ContainerSoundProjector;
import com.celestek.hexcraft.container.ContainerTankValve;
import com.celestek.hexcraft.tileentity.TileSoundProjector;
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
 */

public class GuiSoundProjector extends GuiContainer {

    // GUI Sizes
    private static final int GUI_SIZE_X = 176;
    private static final int GUI_SIZE_Y = 90;

    // GUI Strings
    private static final String GUI_STRING_F = "hexcraft.container.f";
    private static final String GUI_STRING_L = "hexcraft.container.l";
    private static final String GUI_STRING_M = "hexcraft.container.m";
    private static final String GUI_STRING_EMPTY = "hexcraft.container.empty";
    private static final String GUI_STRING_TANK_NOT_FORMED = "hexcraft.container.tankNotFormed";

    private TileSoundProjector tileSoundProjector;

    public GuiSoundProjector(TileSoundProjector tileSoundProjector) {
        super(new ContainerSoundProjector(tileSoundProjector));

        this.tileSoundProjector = tileSoundProjector;
    }

    @Override protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        super.drawGuiContainerForegroundLayer(par1, par2);

        // Draw the name
        String name = I18n.format(TileSoundProjector.MACHINE_NAME);
        fontRendererObj.drawString(name, GUI_SIZE_X / 2 - fontRendererObj.getStringWidth(name) / 2, 44, 0x404040);

        // Draw labels
        String labelSoundName = I18n.format("hexcraft.container.soundProjector.labelSoundName");
        fontRendererObj.drawString(labelSoundName, GUI_SIZE_X / 2 - 80, 62, 0x404040);

        String labelSoundRange = I18n.format("hexcraft.container.soundProjector.labelSoundRange");
        fontRendererObj.drawString(labelSoundRange, GUI_SIZE_X / 2 - 80, 78, 0x404040);

        String labelSoundDistance = I18n.format("hexcraft.container.soundProjector.labelSoundDistance");
        fontRendererObj.drawString(labelSoundDistance, GUI_SIZE_X / 2 - 80, 94, 0x404040);

        String labelSoundLoop = I18n.format("hexcraft.container.soundProjector.labelSoundLoop");
        fontRendererObj.drawString(labelSoundLoop, GUI_SIZE_X / 2 - 80, 110, 0x404040);

    }

    @Override protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_,
        int p_146976_3_) {
        // Bind the texture of the GUI.
        // Prepare x and y values (top left corner).
        int x = (width - GUI_SIZE_X) / 2;
        int y = (height - GUI_SIZE_Y) / 2;

        // Draw the background of GUI.
        mc.getTextureManager().bindTexture(new ResourceLocation(HexCraft.MODID, "textures/gui/guiSoundProjector.png"));
        drawTexturedModalRect(x, y, 0, 0, GUI_SIZE_X, GUI_SIZE_Y);
    }
}
