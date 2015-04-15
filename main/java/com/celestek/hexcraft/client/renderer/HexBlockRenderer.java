package com.celestek.hexcraft.client.renderer;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.HexClientProxy;
import com.celestek.hexcraft.init.HexBlocks;
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

    /* Variables */
    private int renderID;
    private int renderBlockID;
    private String renderBlockName;
    private int brightness;
    private float r = 1F;
    private float g = 1F;
    private float b = 1F;

    /**
     * Constructor for custom rendering.
     * @param renderID Minecraft's internal ID of a certain block.
     * @param renderBlockName Unlocalized name of the block to render. Used for retrieval of icons.
     * @param brightness Intensity of the inner block layer glow.
     * @param r Red component of the inner block layer color.
     * @param g Green component of the inner block layer color.
     * @param b Blue component of the inner block layer color.
     */
    public HexBlockRenderer(int renderID, String renderBlockName, int brightness, float r, float g, float b)
    {
        /* Save the current HexCraft block ID. */
        this.renderBlockID = HexCraft.idCounter;

        this.renderID = renderID;
        this.renderBlockName = renderBlockName;
        this.brightness = brightness;
        this.r = r;
        this.g = g;
        this.b = b;

        /* Increment block counter in HexCraft class. */
        HexCraft.idCounter++;
    }

    /**
     * Render the inventory block icon.
     */
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
    {
        /* Create the Tessellator and prepare OpenGL. */
        Tessellator tessellator = Tessellator.instance;
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        GL11.glEnable(GL11.GL_BLEND);

        /* Draw the inner layer of the block. */
        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, HexBlocks.getBlock(renderBlockName).getIcon(6, 0));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, HexBlocks.getBlock(renderBlockName).getIcon(6, 0));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, HexBlocks.getBlock(renderBlockName).getIcon(6, 0));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, HexBlocks.getBlock(renderBlockName).getIcon(6, 0));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, HexBlocks.getBlock(renderBlockName).getIcon(6, 0));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, HexBlocks.getBlock(renderBlockName).getIcon(6, 0));
        tessellator.draw();

        /* Draw the outer layer of the block. */
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexBlocks.getBlock(renderBlockName), 0, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexBlocks.getBlock(renderBlockName), 1, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexBlocks.getBlock(renderBlockName), 2, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexBlocks.getBlock(renderBlockName), 3, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexBlocks.getBlock(renderBlockName), 4, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexBlocks.getBlock(renderBlockName), 5, metadata));
        tessellator.draw();

        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
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

    /**
     * Renders the block in world.
     */
    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        /* Prepare the Tessellator */
        Tessellator tessellator = Tessellator.instance;

        /* Check if this is the first (opaque) render pass, if it is... */
        if(HexClientProxy.renderPass[renderBlockID] == 0) {
            /* Prepare the inner block texture. */
            IIcon c = HexBlocks.getBlock(renderBlockName).getIcon(6, 0);
            float u = c.getMinU();
            float v = c.getMinV();
            float U = c.getMaxU();
            float V = c.getMaxV();

            /* Draw the inner layer of the block. */
            tessellator.addTranslation(x, y, z);

            tessellator.setBrightness(brightness);
            tessellator.setColorOpaque_F(r, g, b);

            tessellator.addVertexWithUV(0, 1, 0, u, v);
            tessellator.addVertexWithUV(0, 1, 1, u, V);
            tessellator.addVertexWithUV(1, 1, 1, U, V);
            tessellator.addVertexWithUV(1, 1, 0, U, v);

            tessellator.addVertexWithUV(0, 1, 1, u, v);
            tessellator.addVertexWithUV(0, 0, 1, u, V);
            tessellator.addVertexWithUV(1, 0, 1, U, V);
            tessellator.addVertexWithUV(1, 1, 1, U, v);

            tessellator.addVertexWithUV(0, 0, 0, u, V);
            tessellator.addVertexWithUV(0, 0, 1, U, V);
            tessellator.addVertexWithUV(0, 1, 1, U, v);
            tessellator.addVertexWithUV(0, 1, 0, u, v);

            tessellator.addVertexWithUV(1, 0, 0, u, V);
            tessellator.addVertexWithUV(0, 0, 0, U, V);
            tessellator.addVertexWithUV(0, 1, 0, U, v);
            tessellator.addVertexWithUV(1, 1, 0, u, v);

            tessellator.addVertexWithUV(1, 0, 1, u, V);
            tessellator.addVertexWithUV(1, 0, 0, U, V);
            tessellator.addVertexWithUV(1, 1, 0, U, v);
            tessellator.addVertexWithUV(1, 1, 1, u, v);

            tessellator.addVertexWithUV(0, 0, 1, u, V);
            tessellator.addVertexWithUV(0, 0, 0, u, v);
            tessellator.addVertexWithUV(1, 0, 0, U, v);
            tessellator.addVertexWithUV(1, 0, 1, U, V);

            tessellator.addTranslation(-x, -y, -z);
        }
        /* If this is the second (transparent) render pass... */
        else {
            /* If Tessellator doesn't do anything, it will crash, so let's make a dummy quad. */
            tessellator.addVertex(0, 0, 0);
            tessellator.addVertex(0, 0, 0);
            tessellator.addVertex(0, 0, 0);
            tessellator.addVertex(0, 0, 0);

            /* Draw the outer layer of the block. */
            renderer.renderStandardBlock(HexBlocks.getBlock(renderBlockName), x, y, z);
        }

        return true;
    }
}
