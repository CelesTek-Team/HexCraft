package com.celestek.hexcraft.client.renderer;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.HexClientProxy;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-14
 */

public class HexBlockRenderer implements ISimpleBlockRenderingHandler {

    // Variables
    private int renderID;
    private int renderBlockID;
    private int brightness;
    private float r = 1F;
    private float g = 1F;
    private float b = 1F;
    private boolean renderExtra;

    /**
     * Constructor for custom block rendering.
     * @param renderID Minecraft's internal ID of a certain block.
     * @param brightness Intensity of the inner block layer glow.
     * @param r Red component of the inner block layer color.
     * @param g Green component of the inner block layer color.
     * @param b Blue component of the inner block layer color.
     */
    public HexBlockRenderer(int renderID, int brightness, float r, float g, float b, boolean renderExtra)
    {
        // Save the current HexCraft block ID.
        this.renderBlockID = HexCraft.idCounter;

        // Load the constructor parameters.
        this.renderID = renderID;
        this.brightness = brightness;
        this.r = r;
        this.g = g;
        this.b = b;
        this.renderExtra = renderExtra;

        /** Increment block counter in HexCraft class. */
        HexCraft.idCounter++;
    }

    /**
     * Render the inventory block icon.
     */
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
    {
        // Create the Tessellator and prepare OpenGL.
        Tessellator tessellator = Tessellator.instance;
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        GL11.glEnable(GL11.GL_BLEND);

        // Start drawing inner layer of the block.
        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
            renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        // If special faces should be drawn, use those textures instead.
        if(!renderExtra)
            renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 0));
        else
            renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(7, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        if(!renderExtra)
            renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 0));
        else
            renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(8, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        if(!renderExtra)
            renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 0));
        else
            renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(9, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        if(!renderExtra)
            renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 0));
        else
            renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(10, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        if (!renderExtra)
            renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 0));
        else
            renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(11, 0));
        tessellator.draw();

        // Start drawing outer layer of the block.
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 1, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 2, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 3, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 4, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 5, metadata));
        tessellator.draw();

        // Finish drawing.
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    /**
     * Renders the block in world.
     */
    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        // Prepare the Tessellator.
        Tessellator tessellator = Tessellator.instance;

        // Check if this is the first (opaque) render pass, if it is...
        if(HexClientProxy.renderPass[renderBlockID] == 0) {
            // Prepare the inner block texture.
            IIcon c = block.getIcon(6, 0);
            float u = c.getMinU();
            float v = c.getMinV();
            float U = c.getMaxU();
            float V = c.getMaxV();

            // More tessellator preparation.
            tessellator.addTranslation(x, y, z);

            // Set up brightness and color.
            tessellator.setBrightness(brightness);
            tessellator.setColorOpaque_F(r, g, b);

            // DOWN
            // Check if the block face should be visible. If yes draw it.
            if(!world.getBlock(x, y-1, z).isOpaqueCube()) {
                if(renderExtra) {
                    // If special faces should be drawn, use those textures instead.
                    c = block.getIcon(6, 0);
                    u = c.getMinU();
                    v = c.getMinV();
                    U = c.getMaxU();
                    V = c.getMaxV();
                }
                tessellator.addVertexWithUV(0, 0, 1, u, V);
                tessellator.addVertexWithUV(0, 0, 0, u, v);
                tessellator.addVertexWithUV(1, 0, 0, U, v);
                tessellator.addVertexWithUV(1, 0, 1, U, V);
            }

            // UP
            if(!world.getBlock(x, y+1, z).isOpaqueCube()) {
                if(renderExtra) {
                    c = block.getIcon(7, 0);
                    u = c.getMinU();
                    v = c.getMinV();
                    U = c.getMaxU();
                    V = c.getMaxV();
                }
                tessellator.addVertexWithUV(0, 1, 0, u, v);
                tessellator.addVertexWithUV(0, 1, 1, u, V);
                tessellator.addVertexWithUV(1, 1, 1, U, V);
                tessellator.addVertexWithUV(1, 1, 0, U, v);
            }

            // NORTH
            if(!world.getBlock(x, y, z-1).isOpaqueCube()) {
                if(renderExtra) {
                    c = block.getIcon(8, 0);
                    u = c.getMinU();
                    v = c.getMinV();
                    U = c.getMaxU();
                    V = c.getMaxV();
                }
                tessellator.addVertexWithUV(1, 0, 0, u, V);
                tessellator.addVertexWithUV(0, 0, 0, U, V);
                tessellator.addVertexWithUV(0, 1, 0, U, v);
                tessellator.addVertexWithUV(1, 1, 0, u, v);
            }

            // SOUTH
            if(!world.getBlock(x, y, z+1).isOpaqueCube()) {
                if(renderExtra) {
                    c = block.getIcon(9, 0);
                    u = c.getMinU();
                    v = c.getMinV();
                    U = c.getMaxU();
                    V = c.getMaxV();
                }
                tessellator.addVertexWithUV(0, 1, 1, u, v);
                tessellator.addVertexWithUV(0, 0, 1, u, V);
                tessellator.addVertexWithUV(1, 0, 1, U, V);
                tessellator.addVertexWithUV(1, 1, 1, U, v);
            }

            // WEST
            if(!world.getBlock(x-1, y, z).isOpaqueCube()) {
                if(renderExtra) {
                    c = block.getIcon(10, 0);
                    u = c.getMinU();
                    v = c.getMinV();
                    U = c.getMaxU();
                    V = c.getMaxV();
                }
                tessellator.addVertexWithUV(0, 0, 0, u, V);
                tessellator.addVertexWithUV(0, 0, 1, U, V);
                tessellator.addVertexWithUV(0, 1, 1, U, v);
                tessellator.addVertexWithUV(0, 1, 0, u, v);
            }

            // EAST
            if(!world.getBlock(x + 1, y, z).isOpaqueCube()) {
                if (renderExtra) {
                    c = block.getIcon(11, 0);
                    u = c.getMinU();
                    v = c.getMinV();
                    U = c.getMaxU();
                    V = c.getMaxV();
                }
                tessellator.addVertexWithUV(1, 0, 1, u, V);
                tessellator.addVertexWithUV(1, 0, 0, U, V);
                tessellator.addVertexWithUV(1, 1, 0, U, v);
                tessellator.addVertexWithUV(1, 1, 1, u, v);
            }
            tessellator.addTranslation(-x, -y, -z);
        }
        // If this is the second (transparent) render pass...
        else {
            // If Tessellator doesn't do anything, it will crash, so make a dummy quad.
            tessellator.addVertex(0, 0, 0);
            tessellator.addVertex(0, 0, 0);
            tessellator.addVertex(0, 0, 0);
            tessellator.addVertex(0, 0, 0);

            // Draw the outer layer of the block.
            renderer.renderStandardBlock(block, x, y, z);
        }

        return true;
    }

    /**
     * Retrieves Minecraft's internal ID of a certain block.
     */
    @Override
    public int getRenderId()
    {
        return renderID;
    }

    /**
     * Makes the block render 3D in invenotry.
     */
    @Override
    public boolean shouldRender3DInInventory(int i)
    {
        return true;
    }
}
