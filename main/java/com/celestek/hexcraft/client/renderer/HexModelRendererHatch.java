package com.celestek.hexcraft.client.renderer;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.BlockHexoriumHatch;
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
 * @version 0.7.0
 */

public class HexModelRendererHatch implements ISimpleBlockRenderingHandler {

    // Model constants.
    public static final float hThck = 0.1875F;

    private static final float hEdge = 0.03125F;
    private static final float hWidt = 0.125F;
    private static final float hOffs = 0.001F;

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
    public HexModelRendererHatch(int renderID, int brightness, float r, float g, float b) {
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
        IIcon c = block.getIcon(6, 0);

        // Draw the inner glow.
        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        tessellator.addVertexWithUV(hEdge + hWidt, 0.5 + hThck / 2 - hOffs, 1 - hEdge, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));
        tessellator.addVertexWithUV(hEdge + hWidt, 0.5 + hThck / 2 - hOffs, hEdge, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
        tessellator.addVertexWithUV(hEdge, 0.5 + hThck / 2 - hOffs, hEdge, c.getInterpolatedU(0.5), c.getInterpolatedV(15.5));
        tessellator.addVertexWithUV(hEdge, 0.5 + hThck / 2 - hOffs, 1 - hEdge, c.getInterpolatedU(0.5), c.getInterpolatedV(0.5));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        tessellator.addVertexWithUV(hEdge, 0.5 - hThck / 2 + hOffs, 1 - hEdge, c.getInterpolatedU(0.5), c.getInterpolatedV(0.5));
        tessellator.addVertexWithUV(hEdge, 0.5 - hThck / 2 + hOffs, hEdge, c.getInterpolatedU(0.5), c.getInterpolatedV(15.5));
        tessellator.addVertexWithUV(hEdge + hWidt, 0.5 - hThck / 2 + hOffs, hEdge, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
        tessellator.addVertexWithUV(hEdge + hWidt, 0.5 - hThck / 2 + hOffs, 1 - hEdge, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        tessellator.addVertexWithUV(1 - hEdge, 0.5 + hThck / 2 - hOffs, 1 - hEdge, c.getInterpolatedU(15.5), c.getInterpolatedV(0.5));
        tessellator.addVertexWithUV(1 - hEdge, 0.5 + hThck / 2 - hOffs, hEdge, c.getInterpolatedU(15.5), c.getInterpolatedV(15.5));
        tessellator.addVertexWithUV(1 - hEdge - hWidt, 0.5 + hThck / 2 - hOffs, hEdge, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
        tessellator.addVertexWithUV(1 - hEdge - hWidt, 0.5 + hThck / 2 - hOffs, 1 - hEdge, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        tessellator.addVertexWithUV(1 - hEdge - hWidt, 0.5 - hThck / 2 + hOffs, 1 - hEdge, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));
        tessellator.addVertexWithUV(1 - hEdge - hWidt, 0.5 - hThck / 2 + hOffs, hEdge, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
        tessellator.addVertexWithUV(1 - hEdge, 0.5 - hThck / 2 + hOffs, hEdge, c.getInterpolatedU(15.5), c.getInterpolatedV(15.5));
        tessellator.addVertexWithUV(1 - hEdge, 0.5 - hThck / 2 + hOffs, 1 - hEdge, c.getInterpolatedU(15.5), c.getInterpolatedV(0.5));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        tessellator.addVertexWithUV(1 - hEdge - hWidt, 0.5 + hThck / 2 - hOffs, 1 - hEdge, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));
        tessellator.addVertexWithUV(1 - hEdge - hWidt, 0.5 + hThck / 2 - hOffs, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(2.5));
        tessellator.addVertexWithUV(hEdge + hWidt, 0.5 + hThck / 2 - hOffs, 1 - hEdge - hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(2.5));
        tessellator.addVertexWithUV(hEdge + hWidt, 0.5 + hThck / 2 - hOffs, 1 - hEdge, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        tessellator.addVertexWithUV(hEdge + hWidt, 0.5 - hThck / 2 + hOffs, 1 - hEdge, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));
        tessellator.addVertexWithUV(hEdge + hWidt, 0.5 - hThck / 2 + hOffs, 1 - hEdge - hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(2.5));
        tessellator.addVertexWithUV(1 - hEdge - hWidt, 0.5 - hThck / 2 + hOffs, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(2.5));
        tessellator.addVertexWithUV(1 - hEdge - hWidt, 0.5 - hThck / 2 + hOffs, 1 - hEdge, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        tessellator.addVertexWithUV(1 - hEdge - hWidt, 0.5 + hThck / 2 - hOffs, hEdge + hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(13.5));
        tessellator.addVertexWithUV(1 - hEdge - hWidt, 0.5 + hThck / 2 - hOffs, hEdge, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
        tessellator.addVertexWithUV(hEdge + hWidt, 0.5 + hThck / 2 - hOffs, hEdge, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
        tessellator.addVertexWithUV(hEdge + hWidt, 0.5 + hThck / 2 - hOffs, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(13.5));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        tessellator.addVertexWithUV(hEdge + hWidt, 0.5 - hThck / 2 + hOffs, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(13.5));
        tessellator.addVertexWithUV(hEdge + hWidt, 0.5 - hThck / 2 + hOffs, hEdge, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
        tessellator.addVertexWithUV(1 - hEdge - hWidt, 0.5 - hThck / 2 + hOffs, hEdge, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
        tessellator.addVertexWithUV(1 - hEdge - hWidt, 0.5 - hThck / 2 + hOffs, hEdge + hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(13.5));
        tessellator.draw();

        // Adjust the rendering bounds.
        renderer.setRenderBounds(0, 0.5 - hThck / 2, 0, 1, 0.5 + hThck / 2, 1);

        // Render the outer frame.
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, 2));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(1, 2));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(7, 2));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(7, 2));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(7, 2));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(7, 2));
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
        int rotation = HexUtils.getMetaBitBiInt(BlockHexoriumHatch.META_ROTATION_0, BlockHexoriumHatch.META_ROTATION_1, world, x, y, z);
        boolean state = HexUtils.getMetaBit(BlockHexoriumHatch.META_STATE, world, x, y, z);

        // Check if this is the first (opaque) render pass, if it is...
        if(HexClientProxy.renderPass[renderBlockID] == 0) {
            // Prepare the Tessellator.
            Tessellator tessellator = Tessellator.instance;
            tessellator.addTranslation(x, y, z);

            // Prepare the icon.
            IIcon c = block.getIcon(6, 0);

            // Set up brightness and color.
            tessellator.setBrightness(brightness);
            tessellator.setColorOpaque_F(r, g, b);

            // Draw the inner glow.
            if ((rotation == 0 || rotation == 1 || rotation == 2 || rotation == 3) && !state) {
                tessellator.addVertexWithUV(hEdge + hWidt, hThck - hOffs, 1 - hEdge, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(hEdge + hWidt, hThck - hOffs, hEdge, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hEdge, hThck - hOffs, hEdge, c.getInterpolatedU(0.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hEdge, hThck - hOffs, 1 - hEdge, c.getInterpolatedU(0.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(hEdge, hOffs, 1 - hEdge, c.getInterpolatedU(0.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(hEdge, hOffs, hEdge, c.getInterpolatedU(0.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hEdge + hWidt, hOffs, hEdge, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hEdge + hWidt, hOffs, 1 - hEdge, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(1 - hEdge, hThck - hOffs, 1 - hEdge, c.getInterpolatedU(15.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(1 - hEdge, hThck - hOffs, hEdge, c.getInterpolatedU(15.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, hThck - hOffs, hEdge, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, hThck - hOffs, 1 - hEdge, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(1 - hEdge - hWidt, hOffs, 1 - hEdge, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, hOffs, hEdge, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hEdge, hOffs, hEdge, c.getInterpolatedU(15.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hEdge, hOffs, 1 - hEdge, c.getInterpolatedU(15.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(1 - hEdge - hWidt, hThck - hOffs, 1 - hEdge, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, hThck - hOffs, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(2.5));
                tessellator.addVertexWithUV(hEdge + hWidt, hThck - hOffs, 1 - hEdge - hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(2.5));
                tessellator.addVertexWithUV(hEdge + hWidt, hThck - hOffs, 1 - hEdge, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(hEdge + hWidt, hOffs, 1 - hEdge, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(hEdge + hWidt, hOffs, 1 - hEdge - hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(2.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, hOffs, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(2.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, hOffs, 1 - hEdge, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(1 - hEdge - hWidt, hThck - hOffs, hEdge + hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(13.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, hThck - hOffs, hEdge, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hEdge + hWidt, hThck - hOffs, hEdge, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hEdge + hWidt, hThck - hOffs, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(13.5));

                tessellator.addVertexWithUV(hEdge + hWidt, hOffs, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(13.5));
                tessellator.addVertexWithUV(hEdge + hWidt, hOffs, hEdge, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, hOffs, hEdge, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, hOffs, hEdge + hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(13.5));
            }
            else if (rotation == 0) {
                tessellator.addVertexWithUV(hEdge + hWidt, 1 - hEdge, 1 - hThck + hOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(hEdge + hWidt, hEdge, 1 - hThck + hOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hEdge, hEdge, 1 - hThck + hOffs, c.getInterpolatedU(0.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hEdge, 1 - hEdge, 1 - hThck + hOffs, c.getInterpolatedU(0.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(hEdge, 1 - hEdge, 1 - hOffs, c.getInterpolatedU(0.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(hEdge, hEdge, 1 - hOffs, c.getInterpolatedU(0.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hEdge + hWidt, hEdge, 1 - hOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hEdge + hWidt, 1 - hEdge, 1 - hOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(1 - hEdge, 1 - hEdge, 1 - hThck + hOffs, c.getInterpolatedU(15.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(1 - hEdge, hEdge, 1 - hThck + hOffs, c.getInterpolatedU(15.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, hEdge, 1 - hThck + hOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, 1 - hEdge, 1 - hThck + hOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(1 - hEdge - hWidt, 1 - hEdge, 1 - hOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, hEdge, 1 - hOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hEdge, hEdge, 1 - hOffs, c.getInterpolatedU(15.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hEdge, 1 - hEdge, 1 - hOffs, c.getInterpolatedU(15.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(1 - hEdge - hWidt, 1 - hEdge, 1 - hThck + hOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, 1 - hEdge - hWidt, 1 - hThck + hOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(2.5));
                tessellator.addVertexWithUV(hEdge + hWidt, 1 - hEdge - hWidt, 1 - hThck + hOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(2.5));
                tessellator.addVertexWithUV(hEdge + hWidt, 1 - hEdge, 1 - hThck + hOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(hEdge + hWidt, 1 - hEdge, 1 - hOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(hEdge + hWidt, 1 - hEdge - hWidt, 1 - hOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(2.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, 1 - hEdge - hWidt, 1 - hOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(2.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, 1 - hEdge, 1 - hOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(1 - hEdge - hWidt, hEdge + hWidt, 1 - hThck + hOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(13.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, hEdge, 1 - hThck + hOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hEdge + hWidt, hEdge, 1 - hThck + hOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hEdge + hWidt, hEdge + hWidt, 1 - hThck + hOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(13.5));

                tessellator.addVertexWithUV(hEdge + hWidt, hEdge + hWidt, 1 - hOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(13.5));
                tessellator.addVertexWithUV(hEdge + hWidt, hEdge, 1 - hOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, hEdge, 1 - hOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, hEdge + hWidt, 1 - hOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(13.5));
            }
            else if (rotation == 1) {
                tessellator.addVertexWithUV(hThck - hOffs, 1 - hEdge, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(hThck - hOffs, hEdge, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hThck - hOffs, hEdge, hEdge, c.getInterpolatedU(0.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hThck - hOffs, 1 - hEdge, hEdge, c.getInterpolatedU(0.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(hOffs, 1 - hEdge, hEdge, c.getInterpolatedU(0.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(hOffs, hEdge, hEdge, c.getInterpolatedU(0.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hOffs, hEdge, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hOffs, 1 - hEdge, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(hThck - hOffs, 1 - hEdge, 1 - hEdge, c.getInterpolatedU(15.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(hThck - hOffs, hEdge, 1 - hEdge, c.getInterpolatedU(15.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hThck - hOffs, hEdge, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hThck - hOffs, 1 - hEdge, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(hOffs, 1 - hEdge, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(hOffs, hEdge, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hOffs, hEdge, 1 - hEdge, c.getInterpolatedU(15.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hOffs, 1 - hEdge, 1 - hEdge, c.getInterpolatedU(15.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(hThck - hOffs, 1 - hEdge, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(hThck - hOffs, 1 - hEdge - hWidt, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(2.5));
                tessellator.addVertexWithUV(hThck - hOffs, 1 - hEdge - hWidt, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(2.5));
                tessellator.addVertexWithUV(hThck - hOffs, 1 - hEdge, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(hOffs, 1 - hEdge, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(hOffs, 1 - hEdge - hWidt, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(2.5));
                tessellator.addVertexWithUV(hOffs, 1 - hEdge - hWidt, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(2.5));
                tessellator.addVertexWithUV(hOffs, 1 - hEdge, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(hThck - hOffs, hEdge + hWidt, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(13.5));
                tessellator.addVertexWithUV(hThck - hOffs, hEdge, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hThck - hOffs, hEdge, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hThck - hOffs, hEdge + hWidt, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(13.5));

                tessellator.addVertexWithUV(hOffs, hEdge + hWidt, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(13.5));
                tessellator.addVertexWithUV(hOffs, hEdge, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hOffs, hEdge, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hOffs, hEdge + hWidt, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(13.5));
            }
            else if (rotation == 2) {
                tessellator.addVertexWithUV(hEdge + hWidt, 1 - hEdge, hOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(hEdge + hWidt, hEdge, hOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hEdge, hEdge, hOffs, c.getInterpolatedU(0.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hEdge, 1 - hEdge, hOffs, c.getInterpolatedU(0.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(hEdge, 1 - hEdge, hThck - hOffs, c.getInterpolatedU(0.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(hEdge, hEdge, hThck - hOffs, c.getInterpolatedU(0.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hEdge + hWidt, hEdge, hThck - hOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hEdge + hWidt, 1 - hEdge, hThck - hOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(1 - hEdge, 1 - hEdge, hOffs, c.getInterpolatedU(15.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(1 - hEdge, hEdge, hOffs, c.getInterpolatedU(15.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, hEdge, hOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, 1 - hEdge, hOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(1 - hEdge - hWidt, 1 - hEdge, hThck - hOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, hEdge, hThck - hOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hEdge, hEdge, hThck - hOffs, c.getInterpolatedU(15.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hEdge, 1 - hEdge, hThck - hOffs, c.getInterpolatedU(15.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(1 - hEdge - hWidt, 1 - hEdge, hOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, 1 - hEdge - hWidt, hOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(2.5));
                tessellator.addVertexWithUV(hEdge + hWidt, 1 - hEdge - hWidt, hOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(2.5));
                tessellator.addVertexWithUV(hEdge + hWidt, 1 - hEdge, hOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(hEdge + hWidt, 1 - hEdge, hThck - hOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(hEdge + hWidt, 1 - hEdge - hWidt, hThck - hOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(2.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, 1 - hEdge - hWidt, hThck - hOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(2.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, 1 - hEdge, hThck - hOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(1 - hEdge - hWidt, hEdge + hWidt, hOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(13.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, hEdge, hOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hEdge + hWidt, hEdge, hOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(hEdge + hWidt, hEdge + hWidt, hOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(13.5));

                tessellator.addVertexWithUV(hEdge + hWidt, hEdge + hWidt, hThck - hOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(13.5));
                tessellator.addVertexWithUV(hEdge + hWidt, hEdge, hThck - hOffs, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, hEdge, hThck - hOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hEdge - hWidt, hEdge + hWidt, hThck - hOffs, c.getInterpolatedU(13.5), c.getInterpolatedV(13.5));
            }
            else if (rotation == 3) {
                tessellator.addVertexWithUV(1 - hOffs, 1 - hEdge, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(1 - hOffs, hEdge, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hOffs, hEdge, hEdge, c.getInterpolatedU(0.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hOffs, 1 - hEdge, hEdge, c.getInterpolatedU(0.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(1 - hThck + hOffs, 1 - hEdge, hEdge, c.getInterpolatedU(0.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(1 - hThck + hOffs, hEdge, hEdge, c.getInterpolatedU(0.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hThck + hOffs, hEdge, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hThck + hOffs, 1 - hEdge, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(1 - hOffs, 1 - hEdge, 1 - hEdge, c.getInterpolatedU(15.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(1 - hOffs, hEdge, 1 - hEdge, c.getInterpolatedU(15.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hOffs, hEdge, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hOffs, 1 - hEdge, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(1 - hThck + hOffs, 1 - hEdge, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(1 - hThck + hOffs, hEdge, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hThck + hOffs, hEdge, 1 - hEdge, c.getInterpolatedU(15.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hThck + hOffs, 1 - hEdge, 1 - hEdge, c.getInterpolatedU(15.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(1 - hOffs, 1 - hEdge, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(1 - hOffs, 1 - hEdge - hWidt, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(2.5));
                tessellator.addVertexWithUV(1 - hOffs, 1 - hEdge - hWidt, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(2.5));
                tessellator.addVertexWithUV(1 - hOffs, 1 - hEdge, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(1 - hThck + hOffs, 1 - hEdge, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(0.5));
                tessellator.addVertexWithUV(1 - hThck + hOffs, 1 - hEdge - hWidt, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(2.5));
                tessellator.addVertexWithUV(1 - hThck + hOffs, 1 - hEdge - hWidt, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(2.5));
                tessellator.addVertexWithUV(1 - hThck + hOffs, 1 - hEdge, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(0.5));

                tessellator.addVertexWithUV(1 - hOffs, hEdge + hWidt, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(13.5));
                tessellator.addVertexWithUV(1 - hOffs, hEdge, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hOffs, hEdge, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hOffs, hEdge + hWidt, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(13.5));

                tessellator.addVertexWithUV(1 - hThck + hOffs, hEdge + hWidt, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(13.5));
                tessellator.addVertexWithUV(1 - hThck + hOffs, hEdge, hEdge + hWidt, c.getInterpolatedU(2.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hThck + hOffs, hEdge, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(15.5));
                tessellator.addVertexWithUV(1 - hThck + hOffs, hEdge + hWidt, 1 - hEdge - hWidt, c.getInterpolatedU(13.5), c.getInterpolatedV(13.5));
            }

            tessellator.addTranslation(-x, -y, -z);
        }
        // If this is the second (transparent) render pass...
        else {
            // Adjust the rendering bounds.
            if ((rotation == 0 || rotation == 1 || rotation == 2 || rotation == 3) && !state)
                renderer.setRenderBounds(0, 0, 0, 1, hThck, 1);
            else if (rotation == 0)
                renderer.setRenderBounds(0, 0, 1 - hThck, 1, 1, 1);
            else if (rotation == 1)
                renderer.setRenderBounds(0, 0, 0, hThck, 1, 1);
            else if (rotation == 2)
                renderer.setRenderBounds(0, 0, 0, 1, 1, hThck);
            else if (rotation == 3)
                renderer.setRenderBounds(1 - hThck, 0, 0, 1, 1, 1);

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
