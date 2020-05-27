package com.celestek.hexcraft.client.gui;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.container.ContainerSoundProjector;
import com.celestek.hexcraft.container.ContainerTankValve;
import com.celestek.hexcraft.tileentity.TileSoundProjector;
import com.celestek.hexcraft.tileentity.TileTankValve;
import com.celestek.hexcraft.util.HexNetworkHelper;
import com.celestek.hexcraft.util.HexUtils;
import net.java.games.input.Component;
import net.java.games.input.Keyboard;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiControls;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import java.awt.event.KeyEvent;

import static com.celestek.hexcraft.tileentity.TileSoundProjector.*;
import static sun.audio.AudioPlayer.player;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class GuiSoundProjector extends GuiContainer {

    // GUI Sizes
    private static final int GUI_SIZE_X = 176;
    private static final int GUI_SIZE_Y = 90;

    // GUI Strings
    private static final String GUI_STRING_SOUND_NAME = "hexcraft.container.soundProjector.labelSoundName";
    private static final String GUI_STRING_SOUND_RANGE = "hexcraft.container.soundProjector.labelSoundRange";
    private static final String GUI_STRING_SOUND_DISTANCE = "hexcraft.container.soundProjector.labelSoundDistance";
    private static final String GUI_STRING_SOUND_LOOP = "hexcraft.container.soundProjector.labelSoundLoop";

    private TileSoundProjector tileSoundProjector;

    private GuiTextField textSoundName;
    private GuiTextField textSoundRange;
    private GuiTextField textSoundDistance;

    public GuiSoundProjector(TileSoundProjector tileSoundProjector) {
        super(new ContainerSoundProjector(tileSoundProjector));

        this.tileSoundProjector = tileSoundProjector;
    }

    @Override
    public void initGui() {
        super.initGui();

        textSoundName = new GuiTextField(this.fontRendererObj, width / 2 - GUI_SIZE_X / 2 + 70, height / 2 - GUI_SIZE_Y / 2 + 22, 98, 12);
        textSoundName.setMaxStringLength(24);
        textSoundName.setTextColor(0xFFFFFF);
        textSoundName.setText(tileSoundProjector.getSoundName());

        textSoundRange = new GuiTextField(this.fontRendererObj, width / 2 - GUI_SIZE_X / 2 + 70, height / 2 - GUI_SIZE_Y / 2 + 38, 27, 12);
        textSoundRange.setMaxStringLength(3);
        textSoundRange.setTextColor(0xFFFFFF);
        textSoundRange.setText(Integer.toString(tileSoundProjector.getSoundRange()));

        textSoundDistance = new GuiTextField(this.fontRendererObj, width / 2 - GUI_SIZE_X / 2 + 70, height / 2 - GUI_SIZE_Y / 2 + 54, 27, 12);
        textSoundDistance.setMaxStringLength(3);
        textSoundDistance.setTextColor(0xFFFFFF);
        textSoundDistance.setText(Integer.toString(tileSoundProjector.getSoundDistance()));

        textSoundName.setFocused(true);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        super.drawGuiContainerForegroundLayer(par1, par2);
        // Draw the name
        String name = I18n.format(TileSoundProjector.MACHINE_NAME);
        fontRendererObj.drawString(name, GUI_SIZE_X / 2 - fontRendererObj.getStringWidth(name) / 2, 44, 0x404040);

        // Draw labels
        String labelSoundName = I18n.format(GUI_STRING_SOUND_NAME);
        fontRendererObj.drawString(labelSoundName, GUI_SIZE_X / 2 - 80, 62, 0x404040);

        String labelSoundRange = I18n.format(GUI_STRING_SOUND_RANGE);
        fontRendererObj.drawString(labelSoundRange, GUI_SIZE_X / 2 - 80, 78, 0x404040);

        String labelSoundDistance = I18n.format(GUI_STRING_SOUND_DISTANCE);
        fontRendererObj.drawString(labelSoundDistance, GUI_SIZE_X / 2 - 80, 94, 0x404040);

        String labelSoundLoop = I18n.format(GUI_STRING_SOUND_LOOP);
        fontRendererObj.drawString(labelSoundLoop, GUI_SIZE_X / 2 - 80, 110, 0x404040);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_,
        int p_146976_3_) {
        // Bind the texture of the GUI.
        // Prepare x and y values (top left corner).
        int x = (width - GUI_SIZE_X) / 2;
        int y = (height - GUI_SIZE_Y) / 2;

        // Draw the background of GUI.
        mc.getTextureManager().bindTexture(new ResourceLocation(HexCraft.MODID, "textures/gui/guiSoundProjector.png"));
        drawTexturedModalRect(x, y, 0, 0, GUI_SIZE_X, GUI_SIZE_Y);

        if (tileSoundProjector.getSoundLoop())
            drawTexturedModalRect(x + 73, y + 73, GUI_SIZE_X, 0, 6, 6);
    }

    @Override
    protected void keyTyped(char c, int key) {
        if (key == 1) {
            processTextSoundRange();
            processTextSoundDistance();
            super.keyTyped(c, key);
        }

        if (textSoundName.isFocused()) {
            textSoundName.textboxKeyTyped(c, key);
            tileSoundProjector.setSoundName(textSoundName.getText());
            updateSoundProjector();
        }
        else if (textSoundRange.isFocused()) {
            if (!Character.isLetter(c))
                textSoundRange.textboxKeyTyped(c, key);
        }
        else if (textSoundDistance.isFocused()) {
            if (!Character.isLetter(c))
                textSoundDistance.textboxKeyTyped(c, key);
        }
        else {
            super.keyTyped(c, key);
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        textSoundName.updateCursorCounter();
        textSoundRange.updateCursorCounter();
        textSoundDistance.updateCursorCounter();
    }

    @Override
    public void drawScreen(int par1, int par2, float par3) {
        super.drawScreen(par1, par2, par3);
        textSoundName.drawTextBox();
        textSoundRange.drawTextBox();
        textSoundDistance.drawTextBox();
    }

    @Override
    protected void mouseClicked(int x, int y, int btn) {
        super.mouseClicked(x, y, btn);

        textSoundName.mouseClicked(x, y, btn);
        textSoundRange.mouseClicked(x, y, btn);
        textSoundDistance.mouseClicked(x, y, btn);

        if (x > (width - GUI_SIZE_X) / 2 + 69 &&
            x < (width - GUI_SIZE_X) / 2 + 82 &&
            y > (height - GUI_SIZE_Y) / 2 + 69 &&
            y < (height - GUI_SIZE_Y) / 2 + 82) {
            if (tileSoundProjector.getSoundLoop())
                tileSoundProjector.setSoundLoop(false);
            else
                tileSoundProjector.setSoundLoop(true);
        }

        if (!textSoundRange.isFocused())
            processTextSoundRange();
        if (!textSoundRange.isFocused())
            processTextSoundDistance();
    }

    private void processTextSoundRange() {
        int soundRange = 0;

        if (!textSoundRange.getText().equals(""))
            soundRange = Integer.parseInt(textSoundRange.getText());

        if (soundRange > SOUND_RANGE_MAX)
            soundRange = SOUND_RANGE_MAX;
        else if (soundRange < SOUND_RANGE_MIN)
            soundRange = SOUND_RANGE_MIN;

        textSoundRange.setText(Integer.toString(soundRange));
        tileSoundProjector.setSoundRange(soundRange);
        updateSoundProjector();
    }

    private void processTextSoundDistance() {
        int soundDistance = 0;

        if (!textSoundDistance.getText().equals(""))
            soundDistance = Integer.parseInt(textSoundDistance.getText());

        if (soundDistance > SOUND_DISTANCE_MAX)
            soundDistance = SOUND_DISTANCE_MAX;
        else if (soundDistance < SOUND_DISTANCE_MIN)
            soundDistance = SOUND_DISTANCE_MIN;

        textSoundDistance.setText(Integer.toString(soundDistance));
        tileSoundProjector.setSoundDistance(soundDistance);
        updateSoundProjector();
    }

    private void updateSoundProjector() {
        HexNetworkHelper.updateSoundProjector(
                tileSoundProjector.xCoord, tileSoundProjector.yCoord, tileSoundProjector.zCoord,
                tileSoundProjector.getSoundName(), tileSoundProjector.getSoundRange(), tileSoundProjector.getSoundDistance(), tileSoundProjector.getSoundLoop()
        );
    }
}
