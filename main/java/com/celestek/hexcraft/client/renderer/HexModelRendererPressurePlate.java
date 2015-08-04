package com.celestek.hexcraft.client.renderer;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.BlockHexoriumButton;
import com.celestek.hexcraft.block.BlockHexoriumSwitch;
import com.celestek.hexcraft.client.HexClientProxy;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.util.HexColors;
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
 * @version 0.6.0
 * @since 2015-04-14
 */

public class HexModelRendererPressurePlate implements ISimpleBlockRenderingHandler {

    // Brightness when light is OFF.
    private static float darkLight = 0.15F;

    // Variables
    private int renderID;
    private int renderBlockID;
    private int brightness;

    // Model constants.
    public static float pThck = 0.0625F;
    public static float pSide = 0.0625F;
    public static float pEdge = 0.0625F;
    public static float pWidt = 0.0625F;
    public static float pLeng = 0.25F;
    public static float pOffs = 0.001F;

    /**
     * Constructor for custom monolith rendering.
     * @param renderID Minecraft's internal ID of a certain block.
     * @param brightness Intensity of the monolith glow.
     */
    public HexModelRendererPressurePlate(int renderID, int brightness)
    {
        // Save the current HexCraft block ID.
        this.renderBlockID = HexCraft.idCounter;

        // Load the constructor parameters.
        this.renderID = renderID;

        if (Loader.isModLoaded("coloredlightscore"))
            this.brightness = HexColors.brightnessCL;
        else
            this.brightness = brightness;

        // Increment block counter in HexCraft class.
        HexCraft.idCounter++;
    }

    /**
     * Render the inventory block icon.
     */
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
    {
        // Turn Mipmap OFF.
        int minFilter = GL11.glGetTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER);
        int magFilter = GL11.glGetTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

        // Adjust the rendering bounds.
        renderer.setRenderBounds(pSide, 0.5 - pThck / 2, pSide, 1 - pSide, 0.5 + pThck / 2, 1 - pSide);

        // Prepare the Tessellator.
        Tessellator tessellator = Tessellator.instance;
        tessellator.addTranslation(-0.5F, -0.5F, -0.5F);

        // Render the pressure plate base.
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(1, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(2, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(3, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(4, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(5, 0));
        tessellator.draw();

        // Set up brightness and icon.
        IIcon c = block.getIcon(6, 0);

        // Draw pressure plate glow.
        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        if (block == HexBlocks.blockHexoriumPressurePlateRed)
            tessellator.setColorOpaque_F(1, 0, 0);
        else if (block == HexBlocks.blockHexoriumPressurePlateGreen)
            tessellator.setColorOpaque_F(0, 1, 0);
        else if (block == HexBlocks.blockHexoriumPressurePlateBlue)
            tessellator.setColorOpaque_F(0, 0, 1);
        else if (block == HexBlocks.blockHexoriumPressurePlateWhite)
            tessellator.setColorOpaque_F(1, 1, 1);

        tessellator.addVertexWithUV(pSide + pEdge, 0.5 + pWidt / 2 + pOffs, pSide + pEdge, c.getInterpolatedU(2), c.getInterpolatedV(2));
        tessellator.addVertexWithUV(pSide + pEdge, 0.5 + pWidt / 2 + pOffs, pSide + pEdge + pLeng, c.getInterpolatedU(2), c.getInterpolatedV(6));
        tessellator.addVertexWithUV(pSide + pEdge + pWidt, 0.5 + pWidt / 2 + pOffs, pSide + pEdge + pLeng, c.getInterpolatedU(3), c.getInterpolatedV(6));
        tessellator.addVertexWithUV(pSide + pEdge + pWidt, 0.5 + pWidt / 2 + pOffs, pSide + pEdge, c.getInterpolatedU(3), c.getInterpolatedV(2));

        tessellator.addVertexWithUV(pSide + pEdge, 0.5 + pWidt / 2 + pOffs, 1 - pSide - pEdge - pLeng, c.getInterpolatedU(2), c.getInterpolatedV(10));
        tessellator.addVertexWithUV(pSide + pEdge, 0.5 + pWidt / 2 + pOffs, 1 - pSide - pEdge, c.getInterpolatedU(2), c.getInterpolatedV(14));
        tessellator.addVertexWithUV(pSide + pEdge + pWidt, 0.5 + pWidt / 2 + pOffs, 1 - pSide - pEdge, c.getInterpolatedU(3), c.getInterpolatedV(14));
        tessellator.addVertexWithUV(pSide + pEdge + pWidt, 0.5 + pWidt / 2 + pOffs, 1 - pSide - pEdge - pLeng, c.getInterpolatedU(3), c.getInterpolatedV(10));

        tessellator.addVertexWithUV(1 - pSide - pEdge - pWidt, 0.5 + pWidt / 2 + pOffs, pSide + pEdge, c.getInterpolatedU(13), c.getInterpolatedV(2));
        tessellator.addVertexWithUV(1 - pSide - pEdge - pWidt, 0.5 + pWidt / 2 + pOffs, pSide + pEdge + pLeng, c.getInterpolatedU(13), c.getInterpolatedV(6));
        tessellator.addVertexWithUV(1 - pSide - pEdge, 0.5 + pWidt / 2 + pOffs, pSide + pEdge + pLeng, c.getInterpolatedU(14), c.getInterpolatedV(6));
        tessellator.addVertexWithUV(1 - pSide - pEdge, 0.5 + pWidt / 2 + pOffs, pSide + pEdge, c.getInterpolatedU(14), c.getInterpolatedV(2));

        tessellator.addVertexWithUV(1 - pSide - pEdge - pWidt, 0.5 + pWidt / 2 + pOffs, 1 - pSide - pEdge - pLeng, c.getInterpolatedU(13), c.getInterpolatedV(10));
        tessellator.addVertexWithUV(1 - pSide - pEdge - pWidt, 0.5 + pWidt / 2 + pOffs, 1 - pSide - pEdge, c.getInterpolatedU(13), c.getInterpolatedV(14));
        tessellator.addVertexWithUV(1 - pSide - pEdge, 0.5 + pWidt / 2 + pOffs, 1 - pSide - pEdge, c.getInterpolatedU(14), c.getInterpolatedV(14));
        tessellator.addVertexWithUV(1 - pSide - pEdge, 0.5 + pWidt / 2 + pOffs, 1 - pSide - pEdge - pLeng, c.getInterpolatedU(14), c.getInterpolatedV(10));

        tessellator.addVertexWithUV(pSide + pEdge + pWidt, 0.5 + pWidt / 2 + pOffs, pSide + pEdge, c.getInterpolatedU(3), c.getInterpolatedV(2));
        tessellator.addVertexWithUV(pSide + pEdge + pWidt, 0.5 + pWidt / 2 + pOffs, pSide + pEdge + pWidt, c.getInterpolatedU(3), c.getInterpolatedV(3));
        tessellator.addVertexWithUV(pSide + pEdge + pLeng, 0.5 + pWidt / 2 + pOffs, pSide + pEdge + pWidt, c.getInterpolatedU(6), c.getInterpolatedV(3));
        tessellator.addVertexWithUV(pSide + pEdge + pLeng, 0.5 + pWidt / 2 + pOffs, pSide + pEdge, c.getInterpolatedU(6), c.getInterpolatedV(2));

        tessellator.addVertexWithUV(pSide + pEdge + pWidt, 0.5 + pWidt / 2 + pOffs, 1 - pSide - pEdge - pWidt, c.getInterpolatedU(3), c.getInterpolatedV(13));
        tessellator.addVertexWithUV(pSide + pEdge + pWidt, 0.5 + pWidt / 2 + pOffs, 1 - pSide - pEdge, c.getInterpolatedU(3), c.getInterpolatedV(14));
        tessellator.addVertexWithUV(pSide + pEdge + pLeng, 0.5 + pWidt / 2 + pOffs, 1 - pSide - pEdge, c.getInterpolatedU(6), c.getInterpolatedV(14));
        tessellator.addVertexWithUV(pSide + pEdge + pLeng, 0.5 + pWidt / 2 + pOffs, 1 - pSide - pEdge - pWidt, c.getInterpolatedU(6), c.getInterpolatedV(13));

        tessellator.addVertexWithUV(1 - pSide - pEdge - pLeng, 0.5 + pWidt / 2 + pOffs, pSide + pEdge, c.getInterpolatedU(10), c.getInterpolatedV(2));
        tessellator.addVertexWithUV(1 - pSide - pEdge - pLeng, 0.5 + pWidt / 2 + pOffs, pSide + pEdge + pWidt, c.getInterpolatedU(10), c.getInterpolatedV(3));
        tessellator.addVertexWithUV(1 - pSide - pEdge - pWidt, 0.5 + pWidt / 2 + pOffs, pSide + pEdge + pWidt, c.getInterpolatedU(13), c.getInterpolatedV(3));
        tessellator.addVertexWithUV(1 - pSide - pEdge - pWidt, 0.5 + pWidt / 2 + pOffs, pSide + pEdge, c.getInterpolatedU(13), c.getInterpolatedV(2));

        tessellator.addVertexWithUV(1 - pSide - pEdge - pLeng, 0.5 + pWidt / 2 + pOffs, 1 - pSide - pEdge - pWidt, c.getInterpolatedU(10), c.getInterpolatedV(13));
        tessellator.addVertexWithUV(1 - pSide - pEdge - pLeng, 0.5 + pWidt / 2 + pOffs, 1 - pSide - pEdge, c.getInterpolatedU(10), c.getInterpolatedV(14));
        tessellator.addVertexWithUV(1 - pSide - pEdge - pWidt, 0.5 + pWidt / 2 + pOffs, 1 - pSide - pEdge, c.getInterpolatedU(13), c.getInterpolatedV(14));
        tessellator.addVertexWithUV(1 - pSide - pEdge - pWidt, 0.5 + pWidt / 2 + pOffs, 1 - pSide - pEdge - pWidt, c.getInterpolatedU(13), c.getInterpolatedV(13));
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
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        // Get block meta and normalize it.
        int meta = world.getBlockMetadata(x, y, z);

        // Check if this is the first (opaque) render pass, if it is...
        if(HexClientProxy.renderPass[renderBlockID] == 0) {
            // Adjust the rendering bounds.
            if (meta < 4)
                renderer.setRenderBounds(pSide, 0, pSide, 1 - pSide, pThck, 1 - pSide);
            else
                renderer.setRenderBounds(pSide, 0, pSide, 1 - pSide, pThck / 2, 1 - pSide);

            // Render the pressure plate base.
            renderer.renderStandardBlock(block, x, y, z);
        }
        // If this is the second (transparent) render pass...
        else {
            // Prepare the Tessellator.
            Tessellator tessellator = Tessellator.instance;
            tessellator.addTranslation(x, y, z);

            // Set up brightness and icon.
            tessellator.setBrightness(brightness);
            IIcon c = block.getIcon(6, 0);

            // Adjust parameters.
            float push;
            float color;
            if (meta < 4) {
                color = 1;
                push = pThck;
            }
            else {
                color = darkLight;
                push = pThck / 2;
            }

            // Get Colors.
            if (block == HexBlocks.blockHexoriumPressurePlateRed)
                tessellator.setColorOpaque_F(color, 0, 0);
            else if (block == HexBlocks.blockHexoriumPressurePlateGreen)
                tessellator.setColorOpaque_F(0, color, 0);
            else if (block == HexBlocks.blockHexoriumPressurePlateBlue)
                tessellator.setColorOpaque_F(0, 0, color);
            else if (block == HexBlocks.blockHexoriumPressurePlateWhite)
                tessellator.setColorOpaque_F(color, color, color);

            // Draw pressure plate glow.
            tessellator.addVertexWithUV(pSide + pEdge, push + pOffs, pSide + pEdge, c.getInterpolatedU(2), c.getInterpolatedV(2));
            tessellator.addVertexWithUV(pSide + pEdge, push + pOffs, pSide + pEdge + pLeng, c.getInterpolatedU(2), c.getInterpolatedV(6));
            tessellator.addVertexWithUV(pSide + pEdge + pWidt, push + pOffs, pSide + pEdge + pLeng, c.getInterpolatedU(3), c.getInterpolatedV(6));
            tessellator.addVertexWithUV(pSide + pEdge + pWidt, push + pOffs, pSide + pEdge, c.getInterpolatedU(3), c.getInterpolatedV(2));

            tessellator.addVertexWithUV(pSide + pEdge, push + pOffs, 1 - pSide - pEdge - pLeng, c.getInterpolatedU(2), c.getInterpolatedV(10));
            tessellator.addVertexWithUV(pSide + pEdge, push + pOffs, 1 - pSide - pEdge, c.getInterpolatedU(2), c.getInterpolatedV(14));
            tessellator.addVertexWithUV(pSide + pEdge + pWidt, push + pOffs, 1 - pSide - pEdge, c.getInterpolatedU(3), c.getInterpolatedV(14));
            tessellator.addVertexWithUV(pSide + pEdge + pWidt, push + pOffs, 1 - pSide - pEdge - pLeng, c.getInterpolatedU(3), c.getInterpolatedV(10));

            tessellator.addVertexWithUV(1 - pSide - pEdge - pWidt, push + pOffs, pSide + pEdge, c.getInterpolatedU(13), c.getInterpolatedV(2));
            tessellator.addVertexWithUV(1 - pSide - pEdge - pWidt, push + pOffs, pSide + pEdge + pLeng, c.getInterpolatedU(13), c.getInterpolatedV(6));
            tessellator.addVertexWithUV(1 - pSide - pEdge, push + pOffs, pSide + pEdge + pLeng, c.getInterpolatedU(14), c.getInterpolatedV(6));
            tessellator.addVertexWithUV(1 - pSide - pEdge, push + pOffs, pSide + pEdge, c.getInterpolatedU(14), c.getInterpolatedV(2));

            tessellator.addVertexWithUV(1 - pSide - pEdge - pWidt, push + pOffs, 1 - pSide - pEdge - pLeng, c.getInterpolatedU(13), c.getInterpolatedV(10));
            tessellator.addVertexWithUV(1 - pSide - pEdge - pWidt, push + pOffs, 1 - pSide - pEdge, c.getInterpolatedU(13), c.getInterpolatedV(14));
            tessellator.addVertexWithUV(1 - pSide - pEdge, push + pOffs, 1 - pSide - pEdge, c.getInterpolatedU(14), c.getInterpolatedV(14));
            tessellator.addVertexWithUV(1 - pSide - pEdge, push + pOffs, 1 - pSide - pEdge - pLeng, c.getInterpolatedU(14), c.getInterpolatedV(10));

            tessellator.addVertexWithUV(pSide + pEdge + pWidt, push + pOffs, pSide + pEdge, c.getInterpolatedU(3), c.getInterpolatedV(2));
            tessellator.addVertexWithUV(pSide + pEdge + pWidt, push + pOffs, pSide + pEdge + pWidt, c.getInterpolatedU(3), c.getInterpolatedV(3));
            tessellator.addVertexWithUV(pSide + pEdge + pLeng, push + pOffs, pSide + pEdge + pWidt, c.getInterpolatedU(6), c.getInterpolatedV(3));
            tessellator.addVertexWithUV(pSide + pEdge + pLeng, push + pOffs, pSide + pEdge, c.getInterpolatedU(6), c.getInterpolatedV(2));

            tessellator.addVertexWithUV(pSide + pEdge + pWidt, push + pOffs, 1 - pSide - pEdge - pWidt, c.getInterpolatedU(3), c.getInterpolatedV(13));
            tessellator.addVertexWithUV(pSide + pEdge + pWidt, push + pOffs, 1 - pSide - pEdge, c.getInterpolatedU(3), c.getInterpolatedV(14));
            tessellator.addVertexWithUV(pSide + pEdge + pLeng, push + pOffs, 1 - pSide - pEdge, c.getInterpolatedU(6), c.getInterpolatedV(14));
            tessellator.addVertexWithUV(pSide + pEdge + pLeng, push + pOffs, 1 - pSide - pEdge - pWidt, c.getInterpolatedU(6), c.getInterpolatedV(13));

            tessellator.addVertexWithUV(1 - pSide - pEdge - pLeng, push + pOffs, pSide + pEdge, c.getInterpolatedU(10), c.getInterpolatedV(2));
            tessellator.addVertexWithUV(1 - pSide - pEdge - pLeng, push + pOffs, pSide + pEdge + pWidt, c.getInterpolatedU(10), c.getInterpolatedV(3));
            tessellator.addVertexWithUV(1 - pSide - pEdge - pWidt, push + pOffs, pSide + pEdge + pWidt, c.getInterpolatedU(13), c.getInterpolatedV(3));
            tessellator.addVertexWithUV(1 - pSide - pEdge - pWidt, push + pOffs, pSide + pEdge, c.getInterpolatedU(13), c.getInterpolatedV(2));

            tessellator.addVertexWithUV(1 - pSide - pEdge - pLeng, push + pOffs, 1 - pSide - pEdge - pWidt, c.getInterpolatedU(10), c.getInterpolatedV(13));
            tessellator.addVertexWithUV(1 - pSide - pEdge - pLeng, push + pOffs, 1 - pSide - pEdge, c.getInterpolatedU(10), c.getInterpolatedV(14));
            tessellator.addVertexWithUV(1 - pSide - pEdge - pWidt, push + pOffs, 1 - pSide - pEdge, c.getInterpolatedU(13), c.getInterpolatedV(14));
            tessellator.addVertexWithUV(1 - pSide - pEdge - pWidt, push + pOffs, 1 - pSide - pEdge - pWidt, c.getInterpolatedU(13), c.getInterpolatedV(13));

            tessellator.addTranslation(-x, -y, -z);
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
