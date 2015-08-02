package com.celestek.hexcraft.client.renderer;

import com.celestek.hexcraft.HexCraft;
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
 * @version 0.5.1
 * @since 2015-04-14
 */

public class HexModelRendererSwitch implements ISimpleBlockRenderingHandler {

    // Brightness when light is OFF.
    private static float darkLight = 0.1F;

    // Variables
    private int renderID;
    private int renderBlockID;
    private int brightness;

    // Model constants.
    public static float switchBack = 0.0F;
    public static float switchFron = 0.125F;
    public static float switchHori = 0.375F;
    public static float switchVert = 0.375F;
    public static float switchPixl = 0.0625F;
    public static float switchOffs = 0.001F;

    private float topAu = 0.3F;
    private float topAv = 4.5F;
    private float topBu = 2.6F;
    private float topBv = 0.25F;
    private float topCu = 7.4F;
    private float topCv = 0.25F;
    private float topDu = 9.7F;
    private float topDv = 4.5F;
    private float topEu = 7.4F;
    private float topEv = 8.75F;
    private float topFu = 2.6F;
    private float topFv = 8.75F;

    private float sideu = 11.25F;
    private float sideU = 15.75F;
    private float sidev = 0.25F;
    private float sideV = 11.75F;

    private float off = 0.01F;

    /**
     * Constructor for custom monolith rendering.
     * @param renderID Minecraft's internal ID of a certain block.
     * @param brightness Intensity of the monolith glow.
     */
    public HexModelRendererSwitch(int renderID, int brightness)
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
        // Prepare the Tessellator.
        Tessellator tessellator = Tessellator.instance;
        tessellator.addTranslation(-0.5F, -0.5F, -0.5F);

        // Turn Mipmap OFF.
        int minFilter = GL11.glGetTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER);
        int magFilter = GL11.glGetTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

        renderer.setRenderBounds(switchHori, switchVert, switchHori + switchPixl, 1 - switchHori, 1 - switchVert, 1 - switchHori - switchPixl);

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

        tessellator.startDrawingQuads();
        // Set up brightness.
        tessellator.setBrightness(brightness);
        tessellator.setNormal(0F, 1F, 0F);
        IIcon c = block.getIcon(6, 0);

        if (block == HexBlocks.blockHexoriumSwitchRedGreen)
            tessellator.setColorOpaque_F(0, 1, 0);
        else if (block == HexBlocks.blockHexoriumSwitchRedBlue)
            tessellator.setColorOpaque_F(0, 0, 1);

        tessellator.addVertexWithUV(1 - switchHori - switchPixl, 1 - switchVert - switchPixl, 1 - switchHori - switchPixl + switchOffs, c.getInterpolatedU(9), c.getInterpolatedV(6));
        tessellator.addVertexWithUV(1 - switchHori - switchPixl, switchVert + switchPixl, 1 - switchHori - switchPixl + switchOffs, c.getInterpolatedU(9), c.getInterpolatedV(7));
        tessellator.addVertexWithUV(1 - switchHori, switchVert + switchPixl, 1 - switchHori - switchPixl + switchOffs, c.getInterpolatedU(10), c.getInterpolatedV(7));
        tessellator.addVertexWithUV(1 - switchHori, 1 - switchVert - switchPixl, 1 - switchHori - switchPixl +  switchOffs, c.getInterpolatedU(10), c.getInterpolatedV(6));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setColorOpaque_F(1, 0, 0);
        tessellator.addVertexWithUV(switchHori, 1 - switchVert - switchPixl, 1 - switchHori - switchPixl + switchOffs, c.getInterpolatedU(4) , c.getInterpolatedV(6));
        tessellator.addVertexWithUV(switchHori, switchVert + switchPixl, 1 - switchHori - switchPixl + switchOffs, c.getInterpolatedU(4) , c.getInterpolatedV(7));
        tessellator.addVertexWithUV(switchHori + switchPixl, switchVert + switchPixl, 1 - switchHori - switchPixl + switchOffs, c.getInterpolatedU(5), c.getInterpolatedV(7));
        tessellator.addVertexWithUV(switchHori + switchPixl, 1 - switchVert - switchPixl, 1 - switchHori - switchPixl + switchOffs, c.getInterpolatedU(5), c.getInterpolatedV(6));
        tessellator.draw();

        // Finish drawing.

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
        // Fetch block data.
        int meta = world.getBlockMetadata(x, y, z);

        int meta1;
        if (meta > 7)
            meta1 = meta - 8;
        else
            meta1 = meta;

        // Prepare the Tessellator.
        Tessellator tessellator = Tessellator.instance;

        // Check if this is the first (opaque) render pass, if it is...
        if(HexClientProxy.renderPass[renderBlockID] == 0) {

            // If Tessellator doesn't do anything, it will crash, so make a dummy quad.
            tessellator.addVertex(0, 0, 0);
            tessellator.addVertex(0, 0, 0);
            tessellator.addVertex(0, 0, 0);
            tessellator.addVertex(0, 0, 0);

            if (meta1 == 1)
                renderer.setRenderBounds(switchHori, switchBack, switchVert, 1 - switchHori, switchFron, 1 - switchVert);
            else if (meta1 == 7)
                renderer.setRenderBounds(switchVert, switchBack, switchHori, 1 - switchVert, switchFron, 1 - switchHori);
            else if (meta1 == 2)
                renderer.setRenderBounds(switchHori, switchVert, 1 - switchFron, 1 - switchHori, 1 - switchVert, 1 - switchBack);
            else if (meta1 == 3)
                renderer.setRenderBounds(switchHori, switchVert, switchBack, 1 - switchHori, 1 - switchVert, switchFron);
            else if (meta1 == 4)
                renderer.setRenderBounds(1 - switchFron, switchVert, switchHori, 1 - switchBack, 1 - switchVert, 1 - switchHori);
            else if (meta1 == 5)
                renderer.setRenderBounds(switchBack, switchVert, switchHori, switchFron, 1 - switchVert, 1 - switchHori);
            else if (meta1 == 6)
                renderer.setRenderBounds(switchVert, 1 - switchFron, switchHori, 1 - switchVert, 1 - switchBack, 1 - switchHori);
            else
                renderer.setRenderBounds(switchHori, 1 - switchFron, switchVert, 1 - switchHori, 1 - switchBack, 1 - switchVert);

            renderer.renderStandardBlock(block, x, y, z);
        }
        else {
            tessellator.addTranslation(x, y, z);

            tessellator.setBrightness(brightness);
            IIcon c = block.getIcon(6, 0);

            if (meta > 7) {
                if (block == HexBlocks.blockHexoriumSwitchRedGreen)
                    tessellator.setColorOpaque_F(0, 1, 0);
                else if (block == HexBlocks.blockHexoriumSwitchRedBlue)
                    tessellator.setColorOpaque_F(0, 0, 1);
                else if (block == HexBlocks.blockHexoriumSwitchRedWhite)
                    tessellator.setColorOpaque_F(1, 1, 1);
            }
            else {
                if (block == HexBlocks.blockHexoriumSwitchRedGreen)
                    tessellator.setColorOpaque_F(0, darkLight, 0);
                else if (block == HexBlocks.blockHexoriumSwitchRedBlue)
                    tessellator.setColorOpaque_F(0, 0, darkLight);
                else if (block == HexBlocks.blockHexoriumSwitchRedWhite)
                    tessellator.setColorOpaque_F(darkLight, darkLight, darkLight);
            }

            if (meta1 == 1) {
                tessellator.addVertexWithUV(1 - switchHori, switchFron + switchOffs, 1 - switchVert - switchPixl, c.getInterpolatedU(10), c.getInterpolatedV(6));
                tessellator.addVertexWithUV(1 - switchHori, switchFron + switchOffs, switchVert + switchPixl, c.getInterpolatedU(10), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(1 - switchHori - switchPixl, switchFron + switchOffs, switchVert + switchPixl, c.getInterpolatedU(9), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(1 - switchHori - switchPixl, switchFron + switchOffs, 1 - switchVert - switchPixl, c.getInterpolatedU(9), c.getInterpolatedV(6));
            }
            else if (meta1 == 7) {
                tessellator.addVertexWithUV(1 - switchVert - switchPixl, switchFron + switchOffs, 1 - switchHori - switchPixl, c.getInterpolatedU(9), c.getInterpolatedV(6));
                tessellator.addVertexWithUV(switchVert + switchPixl, switchFron + switchOffs, 1 - switchHori - switchPixl, c.getInterpolatedU(9), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(switchVert + switchPixl, switchFron + switchOffs, 1 - switchHori, c.getInterpolatedU(10), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(1 - switchVert - switchPixl, switchFron + switchOffs, 1 - switchHori, c.getInterpolatedU(10), c.getInterpolatedV(6));
            }
            else if (meta1 == 2) {
                tessellator.addVertexWithUV(switchHori + switchPixl, 1 - switchVert - switchPixl, 1 - switchFron - switchOffs, c.getInterpolatedU(9), c.getInterpolatedV(6));
                tessellator.addVertexWithUV(switchHori + switchPixl, switchVert + switchPixl, 1 - switchFron - switchOffs, c.getInterpolatedU(9), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(switchHori, switchVert + switchPixl, 1 - switchFron - switchOffs, c.getInterpolatedU(10), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(switchHori, 1 - switchVert - switchPixl, 1 - switchFron - switchOffs, c.getInterpolatedU(10), c.getInterpolatedV(6));
            }
            else if (meta1 == 3) {
                tessellator.addVertexWithUV(1 - switchHori - switchPixl, 1 - switchVert - switchPixl, switchFron + switchOffs, c.getInterpolatedU(9), c.getInterpolatedV(6));
                tessellator.addVertexWithUV(1 - switchHori - switchPixl, switchVert + switchPixl, switchFron + switchOffs, c.getInterpolatedU(9), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(1 - switchHori, switchVert + switchPixl, switchFron + switchOffs, c.getInterpolatedU(10), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(1 - switchHori, 1 - switchVert - switchPixl, switchFron + switchOffs, c.getInterpolatedU(10), c.getInterpolatedV(6));
            }
            else if (meta1 == 4) {
                tessellator.addVertexWithUV(1 - switchFron - switchOffs, 1 - switchVert - switchPixl, 1 - switchHori - switchPixl, c.getInterpolatedU(9), c.getInterpolatedV(6));
                tessellator.addVertexWithUV(1 - switchFron - switchOffs, switchVert + switchPixl, 1 - switchHori - switchPixl, c.getInterpolatedU(9), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(1 - switchFron - switchOffs, switchVert + switchPixl, 1 - switchHori, c.getInterpolatedU(10), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(1 - switchFron - switchOffs, 1 - switchVert - switchPixl, 1 - switchHori, c.getInterpolatedU(10), c.getInterpolatedV(6));
            }
            else if (meta1 == 5) {
                tessellator.addVertexWithUV(switchFron + switchOffs, 1 - switchVert - switchPixl, switchHori + switchPixl, c.getInterpolatedU(9), c.getInterpolatedV(6));
                tessellator.addVertexWithUV(switchFron + switchOffs, switchVert + switchPixl, switchHori + switchPixl, c.getInterpolatedU(9), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(switchFron + switchOffs, switchVert + switchPixl, switchHori, c.getInterpolatedU(10), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(switchFron + switchOffs, 1 - switchVert - switchPixl, switchHori, c.getInterpolatedU(10), c.getInterpolatedV(6));

            }
            else if (meta1 == 6) {
                tessellator.addVertexWithUV(1 - switchVert - switchPixl, 1 - switchFron - switchOffs, 1 - switchHori, c.getInterpolatedU(10), c.getInterpolatedV(6));
                tessellator.addVertexWithUV(switchVert + switchPixl, 1 - switchFron - switchOffs, 1 - switchHori, c.getInterpolatedU(10), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(switchVert + switchPixl, 1 - switchFron - switchOffs, 1 - switchHori - switchPixl, c.getInterpolatedU(9), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(1 - switchVert - switchPixl, 1 - switchFron - switchOffs, 1 - switchHori - switchPixl, c.getInterpolatedU(9), c.getInterpolatedV(6));

            }
            else {
                tessellator.addVertexWithUV(1 - switchHori - switchPixl, 1 - switchFron - switchOffs, 1 - switchVert - switchPixl, c.getInterpolatedU(9), c.getInterpolatedV(6));
                tessellator.addVertexWithUV(1 - switchHori - switchPixl, 1 - switchFron - switchOffs, switchVert + switchPixl, c.getInterpolatedU(9), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(1 - switchHori, 1 - switchFron - switchOffs, switchVert + switchPixl, c.getInterpolatedU(10), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(1 - switchHori, 1 - switchFron - switchOffs, 1 - switchVert - switchPixl, c.getInterpolatedU(10), c.getInterpolatedV(6));
            }

            if (meta > 7)
                tessellator.setColorOpaque_F(darkLight, 0, 0);
            else
                tessellator.setColorOpaque_F(1, 0, 0);

            if (meta1 == 1) {
                tessellator.addVertexWithUV(switchHori + switchPixl, switchFron + switchOffs, 1 - switchVert - switchPixl, c.getInterpolatedU(5), c.getInterpolatedV(6));
                tessellator.addVertexWithUV(switchHori + switchPixl, switchFron + switchOffs, switchVert + switchPixl, c.getInterpolatedU(5), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(switchHori, switchFron + switchOffs, switchVert + switchPixl, c.getInterpolatedU(4), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(switchHori, switchFron + switchOffs, 1 - switchVert - switchPixl, c.getInterpolatedU(4), c.getInterpolatedV(6));
            }
            else if (meta1 == 7) {
                tessellator.addVertexWithUV(1 - switchVert - switchPixl, switchFron + switchOffs, switchHori, c.getInterpolatedU(4), c.getInterpolatedV(6));
                tessellator.addVertexWithUV(switchVert + switchPixl, switchFron + switchOffs, switchHori, c.getInterpolatedU(4), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(switchVert + switchPixl, switchFron + switchOffs, switchHori + switchPixl, c.getInterpolatedU(5), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(1 - switchVert - switchPixl, switchFron + switchOffs, switchHori + switchPixl, c.getInterpolatedU(5), c.getInterpolatedV(6));
            }
            else if (meta1 == 2) {
                tessellator.addVertexWithUV(1 - switchHori, 1 - switchVert - switchPixl, 1 - switchFron - switchOffs, c.getInterpolatedU(4), c.getInterpolatedV(6));
                tessellator.addVertexWithUV(1 - switchHori, switchVert + switchPixl, 1 - switchFron - switchOffs, c.getInterpolatedU(4), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(1 - switchHori - switchPixl, switchVert + switchPixl, 1 - switchFron - switchOffs, c.getInterpolatedU(5), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(1 - switchHori - switchPixl, 1 - switchVert - switchPixl, 1 - switchFron - switchOffs, c.getInterpolatedU(5), c.getInterpolatedV(6));
            }
            else if (meta1 == 3) {
                tessellator.addVertexWithUV(switchHori, 1 - switchVert - switchPixl, switchFron + switchOffs, c.getInterpolatedU(4), c.getInterpolatedV(6));
                tessellator.addVertexWithUV(switchHori, switchVert + switchPixl, switchFron + switchOffs, c.getInterpolatedU(4), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(switchHori + switchPixl, switchVert + switchPixl, switchFron + switchOffs, c.getInterpolatedU(5), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(switchHori + switchPixl, 1 - switchVert - switchPixl, switchFron + switchOffs, c.getInterpolatedU(5), c.getInterpolatedV(6));
            }
            else if (meta1 == 4) {
                tessellator.addVertexWithUV(1 - switchFron - switchOffs, 1 - switchVert - switchPixl, switchHori, c.getInterpolatedU(4), c.getInterpolatedV(6));
                tessellator.addVertexWithUV(1 - switchFron - switchOffs, switchVert + switchPixl, switchHori, c.getInterpolatedU(4), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(1 - switchFron - switchOffs, switchVert + switchPixl, switchHori + switchPixl, c.getInterpolatedU(5), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(1 - switchFron - switchOffs, 1 - switchVert - switchPixl, switchHori + switchPixl, c.getInterpolatedU(5), c.getInterpolatedV(6));
            }
            else if (meta1 == 5) {
                tessellator.addVertexWithUV(switchFron + switchOffs, 1 - switchVert - switchPixl, 1 - switchHori, c.getInterpolatedU(4), c.getInterpolatedV(6));
                tessellator.addVertexWithUV(switchFron + switchOffs, switchVert + switchPixl, 1 - switchHori, c.getInterpolatedU(4), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(switchFron + switchOffs, switchVert + switchPixl, 1 - switchHori - switchPixl, c.getInterpolatedU(5), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(switchFron + switchOffs, 1 - switchVert - switchPixl, 1 - switchHori - switchPixl, c.getInterpolatedU(5), c.getInterpolatedV(6));

            }
            else if (meta1 == 6) {
                tessellator.addVertexWithUV(1 - switchVert - switchPixl, 1 - switchFron - switchOffs, switchHori + switchPixl, c.getInterpolatedU(5), c.getInterpolatedV(6));
                tessellator.addVertexWithUV(switchVert + switchPixl, 1 - switchFron - switchOffs, switchHori + switchPixl, c.getInterpolatedU(5), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(switchVert + switchPixl, 1 - switchFron - switchOffs, switchHori, c.getInterpolatedU(4), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(1 - switchVert - switchPixl, 1 - switchFron - switchOffs, switchHori, c.getInterpolatedU(4), c.getInterpolatedV(6));

            }
            else {
                tessellator.addVertexWithUV(switchHori, 1 - switchFron - switchOffs, 1 - switchVert - switchPixl, c.getInterpolatedU(4), c.getInterpolatedV(6));
                tessellator.addVertexWithUV(switchHori, 1 - switchFron - switchOffs, switchVert + switchPixl, c.getInterpolatedU(4), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(switchHori + switchPixl, 1 - switchFron - switchOffs, switchVert + switchPixl, c.getInterpolatedU(5), c.getInterpolatedV(7));
                tessellator.addVertexWithUV(switchHori + switchPixl, 1 - switchFron - switchOffs, 1 - switchVert - switchPixl, c.getInterpolatedU(5), c.getInterpolatedV(6));
            }

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
