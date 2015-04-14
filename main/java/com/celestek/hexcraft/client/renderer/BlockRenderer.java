package com.celestek.hexcraft.client.renderer;

import com.celestek.hexcraft.HexCraft;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

public class BlockRenderer implements ISimpleBlockRenderingHandler {

    private int renderType;
    private boolean renderOuterLayer;
    private String renderInnerLayerBlockName;
    private String renderOuterLayerBlockName;
    private int renderBrightness;
    private float r = 1F;
    private float g = 1F;
    private float b = 1F;
    
    public BlockRenderer(int renderType, boolean renderOuterLayer, String renderInnerLayerBlockName, String renderOuterLayerBlockName, int renderBrightness, float r, float g, float b)
    {
        this.renderType = renderType;
        this.renderOuterLayer = renderOuterLayer;
        this.renderInnerLayerBlockName = renderInnerLayerBlockName;
        this.renderOuterLayerBlockName = renderOuterLayerBlockName;
        this.renderBrightness = renderBrightness;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public BlockRenderer(int renderType, boolean renderOuterLayer, String renderInnerLayerBlockName, int renderBrightness, float r, float g, float b)
    {
        this.renderType = renderType;
        this.renderOuterLayer = renderOuterLayer;
        this.renderInnerLayerBlockName = renderInnerLayerBlockName;
        this.renderBrightness = renderBrightness;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
    {
        Tessellator tessellator = Tessellator.instance;
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

        tessellator.startDrawingQuads();
        tessellator.setBrightness(renderBrightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexCraft.getBlock(renderInnerLayerBlockName), 0, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setBrightness(renderBrightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexCraft.getBlock(renderInnerLayerBlockName), 1, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setBrightness(renderBrightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexCraft.getBlock(renderInnerLayerBlockName), 2, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setBrightness(renderBrightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexCraft.getBlock(renderInnerLayerBlockName), 3, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setBrightness(renderBrightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexCraft.getBlock(renderInnerLayerBlockName), 4, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setBrightness(renderBrightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexCraft.getBlock(renderInnerLayerBlockName), 5, metadata));
        tessellator.draw();

        if(renderOuterLayer) {
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, -1.0F, 0.0F);
            renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexCraft.getBlock(renderOuterLayerBlockName), 0, metadata));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 1.0F, 0.0F);
            renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexCraft.getBlock(renderOuterLayerBlockName), 1, metadata));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 0.0F, -1.0F);
            renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexCraft.getBlock(renderOuterLayerBlockName), 2, metadata));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 0.0F, 1.0F);
            renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexCraft.getBlock(renderOuterLayerBlockName), 3, metadata));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(-1.0F, 0.0F, 0.0F);
            renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexCraft.getBlock(renderOuterLayerBlockName), 4, metadata));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(1.0F, 0.0F, 0.0F);
            renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexCraft.getBlock(renderOuterLayerBlockName), 5, metadata));
            tessellator.draw();
        }

        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    @Override
    public int getRenderId()
    {
        return renderType;
    }

    @Override
    public boolean shouldRender3DInInventory(int i)
    {
        return true;
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        Tessellator tessellator = Tessellator.instance;

        tessellator.addTranslation(x, y, z);

        IIcon c = HexCraft.getBlock(renderInnerLayerBlockName).getIcon(0, 0);
        float u = c.getMinU();
        float v = c.getMinV();
        float U = c.getMaxU();
        float V = c.getMaxV();
        tessellator.setBrightness(renderBrightness);
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
        tessellator.addVertexWithUV(0, 0, 0, U, V);
        tessellator.addVertexWithUV(1, 0, 0, U, v);
        tessellator.addVertexWithUV(1, 0, 1, u, v);

        tessellator.addTranslation(-x, -y, -z);

        if(renderOuterLayer)
            renderer.renderStandardBlockWithAmbientOcclusion(HexCraft.getBlock(renderOuterLayerBlockName), x, y, z, 1F, 1F, 1F);

        return true;
    }
}
