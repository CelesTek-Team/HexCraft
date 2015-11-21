package com.celestek.hexcraft.client.renderer;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.BlockHexoriumDoor;
import com.celestek.hexcraft.client.HexClientProxy;
import com.celestek.hexcraft.util.HexColors;
import com.celestek.hexcraft.util.HexUtils;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.common.Loader;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.8.0
 */

public class HexModelRendererDoor implements ISimpleBlockRenderingHandler {

    // Model constants.
    public static final float dThck = 0.1875F;

    private static final float dEdge = 0.03125F;
    private static final float dWidt = 0.125F;
    private static final float dOffs = 0.001F;

    // Variables
    private int renderID;
    private int renderBlockID;
    private int brightness;
    private float r = 1F;
    private float g = 1F;
    private float b = 1F;

    /**
     * Constructor for custom monolith rendering.
     * @param renderID Minecraft's internal ID of a certain block.
     * @param brightness Intensity of the monolith glow.
     * @param r Red component of the inner block layer color.
     * @param g Green component of the inner block layer color.
     * @param b Blue component of the inner block layer color.
     */
    public HexModelRendererDoor(int renderID, int brightness, float r, float g, float b) {
        // Save the current HexCraft block ID.
        this.renderBlockID = HexCraft.idCounter;

        // Load the constructor parameters.
        this.renderID = renderID;

        if (Loader.isModLoaded("coloredlightscore"))
            this.brightness = HexColors.BRIGHTNESS_CL;
        else
            this.brightness = brightness;

        this.r = r;
        this.g = g;
        this.b = b;

        // Increment block counter in HexCraft class.
        HexCraft.idCounter++;
    }

    /**
     * Render the container block icon.
     */
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
        // Prepare the Tessellator.
        Tessellator tessellator = Tessellator.instance;
        tessellator.addTranslation(-0.5F, -0.5F, -0.5F);

        // Turn Mipmap OFF.
        int minFilter = GL11.glGetTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER);
        int magFilter = GL11.glGetTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

        // Set icon
        IIcon c = block.getIcon(10, 1);

        // Draw the inner glow.
        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        tessellator.addVertexWithUV(0.25 + dEdge / 2, 1, 0.5 + dThck / 4 - dOffs, c.getInterpolatedU(0.5), c.getInterpolatedV(0));
        tessellator.addVertexWithUV(0.25 + dEdge / 2, 0.5, 0.5 + dThck / 4 - dOffs, c.getInterpolatedU(0.5), c.getInterpolatedV(16));
        tessellator.addVertexWithUV(0.25 + dEdge / 2 + dWidt / 2, 0.5, 0.5 + dThck / 4 - dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(16));
        tessellator.addVertexWithUV(0.25 + dEdge / 2 + dWidt / 2, 1, 0.5 + dThck / 4 - dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        tessellator.addVertexWithUV(0.25 + dEdge / 2, 0.5, 0.5 + dThck / 4 - dOffs, c.getInterpolatedU(0.5), c.getInterpolatedV(0));
        tessellator.addVertexWithUV(0.25 + dEdge / 2, 0, 0.5 + dThck / 4 - dOffs, c.getInterpolatedU(0.5), c.getInterpolatedV(16));
        tessellator.addVertexWithUV(0.25 + dEdge / 2 + dWidt / 2, 0, 0.5 + dThck / 4 - dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(16));
        tessellator.addVertexWithUV(0.25 + dEdge / 2 + dWidt / 2, 0.5, 0.5 + dThck / 4 - dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        tessellator.addVertexWithUV(0.75 - dEdge / 2 - dWidt / 2, 1, 0.5 + dThck / 4 - dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(0));
        tessellator.addVertexWithUV(0.75 - dEdge / 2 - dWidt / 2, 0.5, 0.5 + dThck / 4 - dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(16));
        tessellator.addVertexWithUV(0.75 - dEdge / 2, 0.5, 0.5 + dThck / 4 - dOffs, c.getInterpolatedU(15.5), c.getInterpolatedV(16));
        tessellator.addVertexWithUV(0.75 - dEdge / 2, 1, 0.5 + dThck / 4 - dOffs, c.getInterpolatedU(15.5), c.getInterpolatedV(0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        tessellator.addVertexWithUV(0.75 - dEdge / 2 - dWidt / 2, 0.5, 0.5 + dThck / 4 - dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(0));
        tessellator.addVertexWithUV(0.75 - dEdge / 2 - dWidt / 2, 0, 0.5 + dThck / 4 - dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(16));
        tessellator.addVertexWithUV(0.75 - dEdge / 2, 0, 0.5 + dThck / 4 - dOffs, c.getInterpolatedU(15.5), c.getInterpolatedV(16));
        tessellator.addVertexWithUV(0.75 - dEdge / 2, 0.5, 0.5 + dThck / 4 - dOffs, c.getInterpolatedU(15.5), c.getInterpolatedV(0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        tessellator.addVertexWithUV(0.25 + dEdge / 2 + dWidt / 2, 1, 0.5 - dThck / 4 + dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(0));
        tessellator.addVertexWithUV(0.25 + dEdge / 2 + dWidt / 2, 0.5, 0.5 - dThck / 4 + dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(16));
        tessellator.addVertexWithUV(0.25 + dEdge / 2, 0.5, 0.5 - dThck / 4 + dOffs, c.getInterpolatedU(0.5), c.getInterpolatedV(16));
        tessellator.addVertexWithUV(0.25 + dEdge / 2, 1, 0.5 - dThck / 4 + dOffs, c.getInterpolatedU(0.5), c.getInterpolatedV(0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        tessellator.addVertexWithUV(0.25 + dEdge / 2 + dWidt / 2, 0.5, 0.5 - dThck / 4 + dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(0));
        tessellator.addVertexWithUV(0.25 + dEdge / 2 + dWidt / 2, 0, 0.5 - dThck / 4 + dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(16));
        tessellator.addVertexWithUV(0.25 + dEdge / 2, 0, 0.5 - dThck / 4 + dOffs, c.getInterpolatedU(0.5), c.getInterpolatedV(16));
        tessellator.addVertexWithUV(0.25 + dEdge / 2, 0.5, 0.5 - dThck / 4 + dOffs, c.getInterpolatedU(0.5), c.getInterpolatedV(0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        tessellator.addVertexWithUV(0.75 - dEdge / 2, 1, 0.5 - dThck / 4 + dOffs, c.getInterpolatedU(15.5), c.getInterpolatedV(0));
        tessellator.addVertexWithUV(0.75 - dEdge / 2, 0.5, 0.5 - dThck / 4 + dOffs, c.getInterpolatedU(15.5), c.getInterpolatedV(16));
        tessellator.addVertexWithUV(0.75 - dEdge / 2 - dWidt / 2, 0.5, 0.5 - dThck / 4 + dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(16));
        tessellator.addVertexWithUV(0.75 - dEdge / 2 - dWidt / 2, 1, 0.5 - dThck / 4 + dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        tessellator.addVertexWithUV(0.75 - dEdge / 2, 0.5, 0.5 - dThck / 4 + dOffs, c.getInterpolatedU(15.5), c.getInterpolatedV(0));
        tessellator.addVertexWithUV(0.75 - dEdge / 2, 0, 0.5 - dThck / 4 + dOffs, c.getInterpolatedU(15.5), c.getInterpolatedV(16));
        tessellator.addVertexWithUV(0.75 - dEdge / 2 - dWidt / 2, 0, 0.5 - dThck / 4 + dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(16));
        tessellator.addVertexWithUV(0.75 - dEdge / 2 - dWidt / 2, 0.5, 0.5 - dThck / 4 + dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        tessellator.addVertexWithUV(0.25 + dEdge / 2 + dWidt / 2, 1 - dEdge / 2, 0.5 + dThck / 4 - dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));
        tessellator.addVertexWithUV(0.25 + dEdge / 2 + dWidt / 2, 1 - dEdge / 2 - dWidt / 2, 0.5 + dThck / 4 - dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(2.5));
        tessellator.addVertexWithUV(0.75 - dEdge / 2 - dWidt / 2, 1 - dEdge / 2 - dWidt / 2, 0.5 + dThck / 4 - dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(2.5));
        tessellator.addVertexWithUV(0.75 - dEdge / 2 - dWidt / 2, 1 - dEdge / 2, 0.5 + dThck / 4 - dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        tessellator.addVertexWithUV(0.75 - dEdge / 2 - dWidt / 2, 1 - dEdge / 2, 0.5 - dThck / 4 + dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));
        tessellator.addVertexWithUV(0.75 - dEdge / 2 - dWidt / 2, 1 - dEdge / 2 - dWidt / 2, 0.5 - dThck / 4 + dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(2.5));
        tessellator.addVertexWithUV(0.25 + dEdge / 2 + dWidt / 2, 1 - dEdge / 2 - dWidt / 2, 0.5 - dThck / 4 + dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(2.5));
        tessellator.addVertexWithUV(0.25 + dEdge / 2 + dWidt / 2, 1 - dEdge / 2, 0.5 - dThck / 4 + dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        tessellator.addVertexWithUV(0.25 + dEdge / 2 + dWidt / 2, dEdge / 2 + dWidt / 2, 0.5 + dThck / 4 - dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));
        tessellator.addVertexWithUV(0.25 + dEdge / 2 + dWidt / 2, dEdge / 2, 0.5 + dThck / 4 - dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(2.5));
        tessellator.addVertexWithUV(0.75 - dEdge / 2 - dWidt / 2, dEdge / 2, 0.5 + dThck / 4 - dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(2.5));
        tessellator.addVertexWithUV(0.75 - dEdge / 2 - dWidt / 2, dEdge / 2 + dWidt / 2, 0.5 + dThck / 4 - dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        tessellator.addVertexWithUV(0.75 - dEdge / 2 - dWidt / 2, dEdge / 2 + dWidt / 2, 0.5 - dThck / 4 + dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));
        tessellator.addVertexWithUV(0.75 - dEdge / 2 - dWidt / 2, dEdge / 2, 0.5 - dThck / 4 + dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(2.5));
        tessellator.addVertexWithUV(0.25 + dEdge / 2 + dWidt / 2, dEdge / 2, 0.5 - dThck / 4 + dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(2.5));
        tessellator.addVertexWithUV(0.25 + dEdge / 2 + dWidt / 2, dEdge / 2 + dWidt / 2, 0.5 - dThck / 4 + dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));
        tessellator.draw();

        // Draw the outer frame.
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        c = block.getIcon(0, 1);
        tessellator.addVertexWithUV(0.25, 1, 0.5 + dThck / 4, c.getInterpolatedU(0), c.getInterpolatedV(0));
        tessellator.addVertexWithUV(0.25, 0.5, 0.5 + dThck / 4, c.getInterpolatedU(0), c.getInterpolatedV(16));
        tessellator.addVertexWithUV(0.75, 0.5, 0.5 + dThck / 4, c.getInterpolatedU(16), c.getInterpolatedV(16));
        tessellator.addVertexWithUV(0.75, 1, 0.5 + dThck / 4, c.getInterpolatedU(16), c.getInterpolatedV(0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        c = block.getIcon(1, 1);
        tessellator.addVertexWithUV(0.25, 0.5, 0.5 + dThck / 4, c.getInterpolatedU(0), c.getInterpolatedV(0));
        tessellator.addVertexWithUV(0.25, 0, 0.5 + dThck / 4, c.getInterpolatedU(0), c.getInterpolatedV(16));
        tessellator.addVertexWithUV(0.75, 0, 0.5 + dThck / 4, c.getInterpolatedU(16), c.getInterpolatedV(16));
        tessellator.addVertexWithUV(0.75, 0.5, 0.5 + dThck / 4, c.getInterpolatedU(16), c.getInterpolatedV(0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        c = block.getIcon(0, 1);
        tessellator.addVertexWithUV(0.75, 1, 0.5 - dThck / 4, c.getInterpolatedU(16), c.getInterpolatedV(0));
        tessellator.addVertexWithUV(0.75, 0.5, 0.5 - dThck / 4, c.getInterpolatedU(16), c.getInterpolatedV(16));
        tessellator.addVertexWithUV(0.25, 0.5, 0.5 - dThck / 4, c.getInterpolatedU(0), c.getInterpolatedV(16));
        tessellator.addVertexWithUV(0.25, 1, 0.5 - dThck / 4, c.getInterpolatedU(0), c.getInterpolatedV(0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        c = block.getIcon(1, 1);
        tessellator.addVertexWithUV(0.75, 0.5, 0.5 - dThck / 4, c.getInterpolatedU(16), c.getInterpolatedV(0));
        tessellator.addVertexWithUV(0.75, 0, 0.5 - dThck / 4, c.getInterpolatedU(16), c.getInterpolatedV(16));
        tessellator.addVertexWithUV(0.25, 0, 0.5 - dThck / 4, c.getInterpolatedU(0), c.getInterpolatedV(16));
        tessellator.addVertexWithUV(0.25, 0.5, 0.5 - dThck / 4, c.getInterpolatedU(0), c.getInterpolatedV(0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        c = block.getIcon(4, 1);
        tessellator.addVertexWithUV(0.75, 1, 0.5 + dThck / 4, c.getInterpolatedU(0), c.getInterpolatedV(0));
        tessellator.addVertexWithUV(0.75, 0.5, 0.5 + dThck / 4, c.getInterpolatedU(0), c.getInterpolatedV(3));
        tessellator.addVertexWithUV(0.75, 0.5, 0.5 - dThck / 4, c.getInterpolatedU(16), c.getInterpolatedV(3));
        tessellator.addVertexWithUV(0.75, 1, 0.5 - dThck / 4, c.getInterpolatedU(16), c.getInterpolatedV(0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        tessellator.addVertexWithUV(0.75, 0.5, 0.5 + dThck / 4, c.getInterpolatedU(0), c.getInterpolatedV(0));
        tessellator.addVertexWithUV(0.75, 0, 0.5 + dThck / 4, c.getInterpolatedU(0), c.getInterpolatedV(3));
        tessellator.addVertexWithUV(0.75, 0, 0.5 - dThck / 4, c.getInterpolatedU(16), c.getInterpolatedV(3));
        tessellator.addVertexWithUV(0.75, 0.5, 0.5 - dThck / 4, c.getInterpolatedU(16), c.getInterpolatedV(0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        tessellator.addVertexWithUV(0.25, 1, 0.5 - dThck / 4, c.getInterpolatedU(16), c.getInterpolatedV(0));
        tessellator.addVertexWithUV(0.25, 0.5, 0.5 - dThck / 4, c.getInterpolatedU(16), c.getInterpolatedV(3));
        tessellator.addVertexWithUV(0.25, 0.5, 0.5 + dThck / 4, c.getInterpolatedU(0), c.getInterpolatedV(3));
        tessellator.addVertexWithUV(0.25, 1, 0.5 + dThck / 4, c.getInterpolatedU(0), c.getInterpolatedV(0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        tessellator.addVertexWithUV(0.25, 0.5, 0.5 - dThck / 4, c.getInterpolatedU(16), c.getInterpolatedV(0));
        tessellator.addVertexWithUV(0.25, 0, 0.5 - dThck / 4, c.getInterpolatedU(16), c.getInterpolatedV(3));
        tessellator.addVertexWithUV(0.25, 0, 0.5 + dThck / 4, c.getInterpolatedU(0), c.getInterpolatedV(3));
        tessellator.addVertexWithUV(0.25, 0.5, 0.5 + dThck / 4, c.getInterpolatedU(0), c.getInterpolatedV(0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        tessellator.addVertexWithUV(0.25, 1, 0.5 - dThck / 4, c.getInterpolatedU(0), c.getInterpolatedV(0));
        tessellator.addVertexWithUV(0.25, 1, 0.5 + dThck / 4, c.getInterpolatedU(0), c.getInterpolatedV(3));
        tessellator.addVertexWithUV(0.75, 1, 0.5 + dThck / 4, c.getInterpolatedU(16), c.getInterpolatedV(3));
        tessellator.addVertexWithUV(0.75, 1, 0.5 - dThck / 4, c.getInterpolatedU(16), c.getInterpolatedV(0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        tessellator.addVertexWithUV(0.75, 0, 0.5 - dThck / 4, c.getInterpolatedU(16), c.getInterpolatedV(0));
        tessellator.addVertexWithUV(0.75, 0, 0.5 + dThck / 4, c.getInterpolatedU(16), c.getInterpolatedV(3));
        tessellator.addVertexWithUV(0.25, 0, 0.5 + dThck / 4, c.getInterpolatedU(0), c.getInterpolatedV(3));
        tessellator.addVertexWithUV(0.25, 0, 0.5 - dThck / 4, c.getInterpolatedU(0), c.getInterpolatedV(0));
        tessellator.draw();

        // Turn Mipmap ON.
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, minFilter);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, magFilter);

        tessellator.addTranslation(0.5F, 0.5F, 0.5F);
    }

    /**
     * Renders the block in world.
     */
    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        // Get block data.
        int rotation = 0;
        boolean flipped = false;
        boolean state = false;
        boolean upperDoor = false;
        if (world.getBlock(x, y - 1, z) == block) {
            rotation = HexUtils.getMetaBitBiInt(BlockHexoriumDoor.META_ROTATION_0, BlockHexoriumDoor.META_ROTATION_1, world, x, y - 1, z);
            state = HexUtils.getMetaBit(BlockHexoriumDoor.META_STATE, world, x, y - 1, z);
            flipped = HexUtils.getMetaBit(BlockHexoriumDoor.META_FLIPPED, world, x, y, z);
            upperDoor = true;
        }
        else if (world.getBlock(x, y + 1, z) == block) {
            rotation = HexUtils.getMetaBitBiInt(BlockHexoriumDoor.META_ROTATION_0, BlockHexoriumDoor.META_ROTATION_1, world, x, y, z);
            state = HexUtils.getMetaBit(BlockHexoriumDoor.META_STATE, world, x, y, z);
            flipped = HexUtils.getMetaBit(BlockHexoriumDoor.META_FLIPPED, world, x, y + 1, z);
        }

        // Check if this is the first (opaque) render pass, if it is...
        if(HexClientProxy.renderPass[renderBlockID] == 0) {
            // Prepare the Tessellator.
            Tessellator tessellator = Tessellator.instance;
            tessellator.addTranslation(x, y, z);

            // Prepare the icon.
            IIcon c = block.getIcon(10, 1);

            // Set up brightness and color.
            tessellator.setBrightness(brightness);
            tessellator.setColorOpaque_F(r, g, b);

            // Draw the inner glow.
            if ((rotation == 0 && !state) || (rotation == 3 && state && !flipped) || (rotation == 1 && state && flipped)) {
                tessellator.addVertexWithUV(1 - dEdge, 1, dOffs, c.getInterpolatedU(0.5), c.getInterpolatedV(0));
                tessellator.addVertexWithUV(1 - dEdge, 0, dOffs, c.getInterpolatedU(0.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(1 - dEdge - dWidt, 0, dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(1 - dEdge - dWidt, 1, dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(0));

                tessellator.addVertexWithUV(1 - dEdge - dWidt, 1, dThck - dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(0));
                tessellator.addVertexWithUV(1 - dEdge - dWidt, 0, dThck - dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(1 - dEdge, 0, dThck - dOffs, c.getInterpolatedU(0.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(1 - dEdge, 1, dThck - dOffs, c.getInterpolatedU(0.5), c.getInterpolatedV(0));

                tessellator.addVertexWithUV(dEdge + dWidt, 1, dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(0));
                tessellator.addVertexWithUV(dEdge + dWidt, 0, dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(dEdge, 0, dOffs, c.getInterpolatedU(15.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(dEdge, 1, dOffs, c.getInterpolatedU(15.5), c.getInterpolatedV(0));

                tessellator.addVertexWithUV(dEdge, 1, dThck - dOffs, c.getInterpolatedU(15.5), c.getInterpolatedV(0));
                tessellator.addVertexWithUV(dEdge, 0, dThck - dOffs, c.getInterpolatedU(15.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(dEdge + dWidt, 0, dThck - dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(dEdge + dWidt, 1, dThck - dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(0));

                if (upperDoor) {
                    tessellator.addVertexWithUV(1 - dEdge - dWidt, 1 - dEdge, dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));
                    tessellator.addVertexWithUV(1 - dEdge - dWidt, 1 - dEdge - dWidt, dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(2.5));
                    tessellator.addVertexWithUV(dEdge + dWidt, 1 - dEdge - dWidt, dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(2.5));
                    tessellator.addVertexWithUV(dEdge + dWidt, 1 - dEdge, dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));

                    tessellator.addVertexWithUV(dEdge + dWidt, 1 - dEdge, dThck - dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));
                    tessellator.addVertexWithUV(dEdge + dWidt, 1 - dEdge - dWidt, dThck - dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(2.5));
                    tessellator.addVertexWithUV(1 - dEdge - dWidt, 1 - dEdge - dWidt, dThck - dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(2.5));
                    tessellator.addVertexWithUV(1 - dEdge - dWidt, 1 - dEdge, dThck - dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));
                }
                else {
                    tessellator.addVertexWithUV(1 - dEdge - dWidt, dEdge + dWidt, dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(13.5));
                    tessellator.addVertexWithUV(1 - dEdge - dWidt, dEdge, dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                    tessellator.addVertexWithUV(dEdge + dWidt, dEdge, dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                    tessellator.addVertexWithUV(dEdge + dWidt, dEdge + dWidt, dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(13.5));

                    tessellator.addVertexWithUV(dEdge + dWidt, dEdge + dWidt, dThck - dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(13.5));
                    tessellator.addVertexWithUV(dEdge + dWidt, dEdge, dThck - dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                    tessellator.addVertexWithUV(1 - dEdge - dWidt, dEdge, dThck - dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                    tessellator.addVertexWithUV(1 - dEdge - dWidt, dEdge + dWidt, dThck - dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(13.5));
                }
            } else if ((rotation == 2 && !state) || (rotation == 1 && state) || (rotation == 3 && state)) {
                tessellator.addVertexWithUV(1 - dEdge, 1, 1 - dThck + dOffs, c.getInterpolatedU(0.5), c.getInterpolatedV(0));
                tessellator.addVertexWithUV(1 - dEdge, 0, 1 - dThck + dOffs, c.getInterpolatedU(0.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(1 - dEdge - dWidt, 0, 1 - dThck + dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(1 - dEdge - dWidt, 1, 1 - dThck + dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(0));

                tessellator.addVertexWithUV(1 - dEdge - dWidt, 1, 1 - dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(0));
                tessellator.addVertexWithUV(1 - dEdge - dWidt, 0, 1 - dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(1 - dEdge, 0, 1 - dOffs, c.getInterpolatedU(0.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(1 - dEdge, 1, 1 - dOffs, c.getInterpolatedU(0.5), c.getInterpolatedV(0));

                tessellator.addVertexWithUV(dEdge + dWidt, 1, 1 - dThck + dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(0));
                tessellator.addVertexWithUV(dEdge + dWidt, 0, 1 - dThck + dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(dEdge, 0, 1 - dThck + dOffs, c.getInterpolatedU(15.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(dEdge, 1, 1 - dThck + dOffs, c.getInterpolatedU(15.5), c.getInterpolatedV(0));

                tessellator.addVertexWithUV(dEdge, 1, 1 - dOffs, c.getInterpolatedU(15.5), c.getInterpolatedV(0));
                tessellator.addVertexWithUV(dEdge, 0, 1 - dOffs, c.getInterpolatedU(15.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(dEdge + dWidt, 0, 1 - dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(dEdge + dWidt, 1, 1 - dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(0));

                if (upperDoor) {
                    tessellator.addVertexWithUV(1 - dEdge - dWidt, 1 - dEdge, 1 - dThck + dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));
                    tessellator.addVertexWithUV(1 - dEdge - dWidt, 1 - dEdge - dWidt, 1 - dThck + dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(2.5));
                    tessellator.addVertexWithUV(dEdge + dWidt, 1 - dEdge - dWidt, 1 - dThck + dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(2.5));
                    tessellator.addVertexWithUV(dEdge + dWidt, 1 - dEdge, 1 - dThck + dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));

                    tessellator.addVertexWithUV(dEdge + dWidt, 1 - dEdge, 1 - dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));
                    tessellator.addVertexWithUV(dEdge + dWidt, 1 - dEdge - dWidt, 1 - dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(2.5));
                    tessellator.addVertexWithUV(1 - dEdge - dWidt, 1 - dEdge - dWidt, 1 - dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(2.5));
                    tessellator.addVertexWithUV(1 - dEdge - dWidt, 1 - dEdge, 1 - dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));
                }
                else {
                    tessellator.addVertexWithUV(1 - dEdge - dWidt, dEdge + dWidt, 1 - dThck + dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(13.5));
                    tessellator.addVertexWithUV(1 - dEdge - dWidt, dEdge, 1 - dThck + dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                    tessellator.addVertexWithUV(dEdge + dWidt, dEdge, 1 - dThck + dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                    tessellator.addVertexWithUV(dEdge + dWidt, dEdge + dWidt, 1 - dThck + dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(13.5));

                    tessellator.addVertexWithUV(dEdge + dWidt, dEdge + dWidt, 1 - dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(13.5));
                    tessellator.addVertexWithUV(dEdge + dWidt, dEdge, 1 - dOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                    tessellator.addVertexWithUV(1 - dEdge - dWidt, dEdge, 1 - dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                    tessellator.addVertexWithUV(1 - dEdge - dWidt, dEdge + dWidt, 1 - dOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(13.5));
                }
            }
            else if (rotation == 3 || (rotation == 2 && !flipped) || (rotation == 0 && flipped)) {
                tessellator.addVertexWithUV(dOffs, 1, 1 - dEdge - dWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(0));
                tessellator.addVertexWithUV(dOffs, 0, 1 - dEdge - dWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(dOffs, 0, 1 - dEdge, c.getInterpolatedU(0.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(dOffs, 1, 1 - dEdge, c.getInterpolatedU(0.5), c.getInterpolatedV(0));

                tessellator.addVertexWithUV(dThck - dOffs, 1, 1 - dEdge, c.getInterpolatedU(0.5), c.getInterpolatedV(0));
                tessellator.addVertexWithUV(dThck - dOffs, 0, 1 - dEdge, c.getInterpolatedU(0.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(dThck - dOffs, 0, 1 - dEdge - dWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(dThck - dOffs, 1, 1 - dEdge - dWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(0));

                tessellator.addVertexWithUV(dOffs, 1, dEdge, c.getInterpolatedU(15.5), c.getInterpolatedV(0));
                tessellator.addVertexWithUV(dOffs, 0, dEdge, c.getInterpolatedU(15.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(dOffs, 0, dEdge + dWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(dOffs, 1, dEdge + dWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(0));

                tessellator.addVertexWithUV(dThck - dOffs, 1, dEdge + dWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(0));
                tessellator.addVertexWithUV(dThck - dOffs, 0, dEdge + dWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(dThck - dOffs, 0, dEdge, c.getInterpolatedU(15.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(dThck - dOffs, 1, dEdge, c.getInterpolatedU(15.5), c.getInterpolatedV(0));

                if (upperDoor) {
                    tessellator.addVertexWithUV(dOffs, 1 - dEdge, dEdge + dWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));
                    tessellator.addVertexWithUV(dOffs, 1 - dEdge - dWidt, dEdge + dWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(2.5));
                    tessellator.addVertexWithUV(dOffs, 1 - dEdge - dWidt, 1 - dEdge - dWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(2.5));
                    tessellator.addVertexWithUV(dOffs, 1 - dEdge, 1 - dEdge - dWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));

                    tessellator.addVertexWithUV(dThck - dOffs, 1 - dEdge, 1 - dEdge - dWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));
                    tessellator.addVertexWithUV(dThck - dOffs, 1 - dEdge - dWidt, 1 - dEdge - dWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(2.5));
                    tessellator.addVertexWithUV(dThck - dOffs, 1 - dEdge - dWidt, dEdge + dWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(2.5));
                    tessellator.addVertexWithUV(dThck - dOffs, 1 - dEdge, dEdge + dWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));
                } else {
                    tessellator.addVertexWithUV(dOffs, dEdge + dWidt, dEdge + dWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(13.5));
                    tessellator.addVertexWithUV(dOffs, dEdge, dEdge + dWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                    tessellator.addVertexWithUV(dOffs, dEdge, 1 - dEdge - dWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                    tessellator.addVertexWithUV(dOffs, dEdge + dWidt, 1 - dEdge - dWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(13.5));

                    tessellator.addVertexWithUV(dThck - dOffs, dEdge + dWidt, 1 - dEdge - dWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(13.5));
                    tessellator.addVertexWithUV(dThck - dOffs, dEdge, 1 - dEdge - dWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                    tessellator.addVertexWithUV(dThck - dOffs, dEdge, dEdge + dWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                    tessellator.addVertexWithUV(dThck - dOffs, dEdge + dWidt, dEdge + dWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(13.5));
                }
            }
            else if (rotation == 1 || rotation == 2 || rotation == 0) {
                tessellator.addVertexWithUV(1 - dThck + dOffs, 1, 1 - dEdge - dWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(0));
                tessellator.addVertexWithUV(1 - dThck + dOffs, 0, 1 - dEdge - dWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(1 - dThck + dOffs, 0, 1 - dEdge, c.getInterpolatedU(0.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(1 - dThck + dOffs, 1, 1 - dEdge, c.getInterpolatedU(0.5), c.getInterpolatedV(0));

                tessellator.addVertexWithUV(1 - dOffs, 1, 1 - dEdge, c.getInterpolatedU(0.5), c.getInterpolatedV(0));
                tessellator.addVertexWithUV(1 - dOffs, 0, 1 - dEdge, c.getInterpolatedU(0.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(1 - dOffs, 0, 1 - dEdge - dWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(1 - dOffs, 1, 1 - dEdge - dWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(0));

                tessellator.addVertexWithUV(1 - dThck + dOffs, 1, dEdge, c.getInterpolatedU(15.5), c.getInterpolatedV(0));
                tessellator.addVertexWithUV(1 - dThck + dOffs, 0, dEdge, c.getInterpolatedU(15.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(1 - dThck + dOffs, 0, dEdge + dWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(1 - dThck + dOffs, 1, dEdge + dWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(0));

                tessellator.addVertexWithUV(1 - dOffs, 1, dEdge + dWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(0));
                tessellator.addVertexWithUV(1 - dOffs, 0, dEdge + dWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(1 - dOffs, 0, dEdge, c.getInterpolatedU(15.5), c.getInterpolatedV(16));
                tessellator.addVertexWithUV(1 - dOffs, 1, dEdge, c.getInterpolatedU(15.5), c.getInterpolatedV(0));

                if (upperDoor) {
                    tessellator.addVertexWithUV(1 - dThck + dOffs, 1 - dEdge, dEdge + dWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));
                    tessellator.addVertexWithUV(1 - dThck + dOffs, 1 - dEdge - dWidt, dEdge + dWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(2.5));
                    tessellator.addVertexWithUV(1 - dThck + dOffs, 1 - dEdge - dWidt, 1 - dEdge - dWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(2.5));
                    tessellator.addVertexWithUV(1 - dThck + dOffs, 1 - dEdge, 1 - dEdge - dWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));

                    tessellator.addVertexWithUV(1 - dOffs, 1 - dEdge, 1 - dEdge - dWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));
                    tessellator.addVertexWithUV(1 - dOffs, 1 - dEdge - dWidt, 1 - dEdge - dWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(2.5));
                    tessellator.addVertexWithUV(1 - dOffs, 1 - dEdge - dWidt, dEdge + dWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(2.5));
                    tessellator.addVertexWithUV(1 - dOffs, 1 - dEdge, dEdge + dWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));
                } else {
                    tessellator.addVertexWithUV(1 - dThck + dOffs, dEdge + dWidt, dEdge + dWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(13.5));
                    tessellator.addVertexWithUV(1 - dThck + dOffs, dEdge, dEdge + dWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                    tessellator.addVertexWithUV(1 - dThck + dOffs, dEdge, 1 - dEdge - dWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                    tessellator.addVertexWithUV(1 - dThck + dOffs, dEdge + dWidt, 1 - dEdge - dWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(13.5));

                    tessellator.addVertexWithUV(1 - dOffs, dEdge + dWidt, 1 - dEdge - dWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(13.5));
                    tessellator.addVertexWithUV(1 - dOffs, dEdge, 1 - dEdge - dWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                    tessellator.addVertexWithUV(1 - dOffs, dEdge, dEdge + dWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                    tessellator.addVertexWithUV(1 - dOffs, dEdge + dWidt, dEdge + dWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(13.5));
                }
            }

            tessellator.addTranslation(-x, -y, -z);
        }
        // If this is the second (transparent) render pass...
        else {
            // Adjust the rendering bounds.
            if (flipped) {
                if ((rotation == 0 && !state) || (rotation == 1 && state))
                    renderer.setRenderBounds(0, 0, 0, 1, 1, dThck);
                else if (rotation == 1 || (rotation == 2  && state))
                    renderer.setRenderBounds(1 - dThck, 0, 0, 1, 1, 1);
                else if (rotation == 2 || (rotation == 3 && state))
                    renderer.setRenderBounds(0, 0, 1 - dThck, 1, 1, 1);
                else if (rotation == 3 || rotation == 0)
                    renderer.setRenderBounds(0, 0, 0, dThck, 1, 1);
            }
            else {
                if ((rotation == 0 && !state) || (rotation == 3 && state))
                    renderer.setRenderBounds(0, 0, 0, 1, 1, dThck);
                else if ((rotation == 1 && !state) || rotation == 0)
                    renderer.setRenderBounds(1 - dThck, 0, 0, 1, 1, 1);
                else if ((rotation == 2 && !state) || rotation == 1)
                    renderer.setRenderBounds(0, 0, 1 - dThck, 1, 1, 1);
                else if (rotation == 3 || rotation == 2)
                    renderer.setRenderBounds(0, 0, 0, dThck, 1, 1);
            }

            // Render the outer frame.
            renderer.renderStandardBlock(block, x, y, z);
        }

        return true;
    }

    /**
     * Retrieves Minecraft's internal ID of a certain block.
     */
    @Override
    public int getRenderId() {
        return renderID;
    }

    /**
     * Makes the block render 3D in invenotry.
     */
    @Override
    public boolean shouldRender3DInInventory(int i) {
        return true;
    }
}
