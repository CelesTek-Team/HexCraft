package com.celestek.hexcraft.client.renderer;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.blocks.EngineeringBlock;
import com.celestek.hexcraft.client.RenderClientProxy;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import org.apache.commons.codec.binary.Hex;
import org.lwjgl.opengl.GL11;

public class BlockRenderer implements ISimpleBlockRenderingHandler {

    private float r = 1F;
    private float g = 1F;
    private float b = 1F;
    private int renderType;
    private String renderBlockName;
    private boolean renderArmor;

    public BlockRenderer(boolean renderArmor, float r, float g, float b, int renderType, String renderBlockName)
    {
        this.renderArmor = renderArmor;
        this.r = r;
        this.g = g;
        this.b = b;
        this.renderType = renderType;
        this.renderBlockName = renderBlockName;
    }

    public BlockRenderer(boolean renderArmor, float r, float g, float b, int renderType)
    {
        this.renderArmor = renderArmor;
        this.r = r;
        this.g = g;
        this.b = b;
        this.renderType = renderType;
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
    {
        Tessellator tessellator = Tessellator.instance;
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

        tessellator.startDrawingQuads();
        tessellator.setBrightness(0xF000F0);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexCraft.hexoriumBlock, 0, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setBrightness(0xF000F0);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexCraft.hexoriumBlock, 1, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setBrightness(0xF000F0);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexCraft.hexoriumBlock, 2, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setBrightness(0xF000F0);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexCraft.hexoriumBlock, 3, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setBrightness(0xF000F0);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexCraft.hexoriumBlock, 4, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setBrightness(0xF000F0);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexCraft.hexoriumBlock, 5, metadata));
        tessellator.draw();

        if(renderArmor) {
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, -1.0F, 0.0F);
            renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexCraft.getBlock(renderBlockName), 0, metadata));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 1.0F, 0.0F);
            renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexCraft.getBlock(renderBlockName), 1, metadata));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 0.0F, -1.0F);
            renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexCraft.getBlock(renderBlockName), 2, metadata));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 0.0F, 1.0F);
            renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexCraft.getBlock(renderBlockName), 3, metadata));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(-1.0F, 0.0F, 0.0F);
            renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexCraft.getBlock(renderBlockName), 4, metadata));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(1.0F, 0.0F, 0.0F);
            renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(HexCraft.getBlock(renderBlockName), 5, metadata));
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

        IIcon c = HexCraft.hexoriumBlock.getIcon(0, 0);
        float u = c.getMinU();
        float v = c.getMinV();
        float U = c.getMaxU();
        float V = c.getMaxV();
        tessellator.setBrightness(0xF000F0);
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

        if(renderArmor)
            renderer.renderStandardBlockWithAmbientOcclusion(HexCraft.getBlock(renderBlockName), x, y, z, 1F, 1F, 1F);

        return true;
    }
}
