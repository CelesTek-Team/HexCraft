package com.celestek.hexcraft.client.renderer;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.*;
import com.celestek.hexcraft.client.HexClientProxy;
import com.celestek.hexcraft.util.HexEnums;
import com.celestek.hexcraft.util.HexUtils;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.common.Loader;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

public class HexMiniBlockRenderer implements ISimpleBlockRenderingHandler {

    // Model constants.
    public static final float o = 0.25F;

    // Variables
    private final int renderID;
    private final int renderBlockID;
    private final int brightness;
    private final float r;
    private final float g;
    private final float b;

    /**
     * Constructor for custom block rendering.
     * @param renderID Minecraft's internal ID of a certain block.
     * @param brightness Intensity of the inner layer glow.
     * @param color Inner layer color.
     */
    public HexMiniBlockRenderer(int renderID, HexEnums.Brightness brightness, HexEnums.Colors color) {
        // Save the current HexCraft block ID.
        this.renderBlockID = HexCraft.idCounter;

        // Load the constructor parameters.
        this.renderID = renderID;

        if (Loader.isModLoaded("coloredlightscore"))
            this.brightness = HexEnums.Brightness.CL.value;
        else
            this.brightness = brightness.value;

        this.r = color.r;
        this.g = color.g;
        this.b = color.b;

        /** Increment block counter in HexCraft class. */
        HexCraft.idCounter++;
    }

    /**
     * Render the container block icon.
     */
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
        // Create the Tessellator.
        Tessellator tessellator = Tessellator.instance;
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

        // Turn Mipmap OFF.
        int minFilter = GL11.glGetTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER);
        int magFilter = GL11.glGetTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

        // Prepare the inner block texture.
        IIcon i = block.getIcon(6, 0);
        float u = i.getInterpolatedU(16 * o);
        float v = i.getInterpolatedV(16 * o);
        float U = i.getInterpolatedU(16 - 16 * o);
        float V = i.getInterpolatedV(16 - 16 * o);

        // Set up brightness and color.
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);

         float a = 0 + o;
         float c = 1 - o;

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        tessellator.addVertexWithUV(a, a, c, u, V);
        tessellator.addVertexWithUV(a, a, a, u, v);
        tessellator.addVertexWithUV(c, a, a, U, v);
        tessellator.addVertexWithUV(c, a, c, U, V);
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        tessellator.addVertexWithUV(a, c, a, u, v);
        tessellator.addVertexWithUV(a, c, c, u, V);
        tessellator.addVertexWithUV(c, c, c, U, V);
        tessellator.addVertexWithUV(c, c, a, U, v);
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        tessellator.addVertexWithUV(c, a, a, u, V);
        tessellator.addVertexWithUV(a, a, a, U, V);
        tessellator.addVertexWithUV(a, c, a, U, v);
        tessellator.addVertexWithUV(c, c, a, u, v);
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        tessellator.addVertexWithUV(a, c, c, u, v);
        tessellator.addVertexWithUV(a, a, c, u, V);
        tessellator.addVertexWithUV(c, a, c, U, V);
        tessellator.addVertexWithUV(c, c, c, U, v);
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        tessellator.addVertexWithUV(a, a, a, u, V);
        tessellator.addVertexWithUV(a, a, c, U, V);
        tessellator.addVertexWithUV(a, c, c, U, v);
        tessellator.addVertexWithUV(a, c, a, u, v);
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        tessellator.addVertexWithUV(c, a, c, u, V);
        tessellator.addVertexWithUV(c, a, a, U, V);
        tessellator.addVertexWithUV(c, c, a, U, v);
        tessellator.addVertexWithUV(c, c, c, u, v);
        tessellator.draw();

        // Turn Mipmap ON.
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, minFilter);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, magFilter);

        // Finish drawing.
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    /**
     * Renders the block in world.
     */
    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        int orientation = HexUtils.getMetaBitTriInt(
            BlockHexoriumMonolith.META_ORIENTATION_0,
            BlockHexoriumMonolith.META_ORIENTATION_1,
            BlockHexoriumMonolith.META_ORIENTATION_2, world, x, y, z);

        // Check if this is the first (opaque) render pass, if it is...
        if(HexClientProxy.renderPass[renderBlockID] == 0) {

            // Prepare the Tessellator.
            Tessellator tessellator = Tessellator.instance;
            tessellator.addTranslation(x, y, z);

            // Prepare the inner block texture.
            IIcon i = block.getIcon(6, 0);
            float u = i.getInterpolatedU(16 * o);
            float v = i.getInterpolatedV(16 * o);
            float U = i.getInterpolatedU(16 - 16 * o);
            float V = i.getInterpolatedV(16 - 16 * o);

            // Set up brightness and color.
            tessellator.setBrightness(brightness);
            tessellator.setColorOpaque_F(r, g, b);

            float a = 0;
            float b = 0;
            float c = 0;
            float d = 0;
            float e = 0;
            float f = 0;

            // UP
            if (orientation == 0) {
                a = 0 + o;
                b = 1 - o;
                c = 0 + o * 2;
                d = 1;
                e = 0 + o;
                f = 1 - o;
            }
            // DOWN
            else if (orientation == 1) {
                a = 0 + o;
                b = 1 - o;
                c = 0;
                d = 1 - o * 2;
                e = 0 + o;
                f = 1 - o;
            }
            // SOUTH
            else if (orientation == 2) {
                a = 0 + o;
                b = 1 - o;
                c = 0 + o;
                d = 1 - o;
                e = 0 + o * 2;
                f = 1;
            }
            // NORTH
            else if (orientation == 3) {
                a = 0 + o;
                b = 1 - o;
                c = 0 + o;
                d = 1 - o;
                e = 0;
                f = 1 - o * 2;
            }
            // EAST
            else if (orientation == 4) {
                a = 0 + o * 2;
                b = 1;
                c = 0 + o;
                d = 1 - o;
                e = 0 + o;
                f = 1 - o;
            }
            // WEST
            else if (orientation == 5) {
                a = 0;
                b = 1 - o * 2;
                c = 0 + o;
                d = 1 - o;
                e = 0 + o;
                f = 1 - o;
            }

            tessellator.addVertexWithUV(a, c, f, u, V);
            tessellator.addVertexWithUV(a, c, e, u, v);
            tessellator.addVertexWithUV(b, c, e, U, v);
            tessellator.addVertexWithUV(b, c, f, U, V);

            tessellator.addVertexWithUV(a, d, e, u, v);
            tessellator.addVertexWithUV(a, d, f, u, V);
            tessellator.addVertexWithUV(b, d, f, U, V);
            tessellator.addVertexWithUV(b, d, e, U, v);

            tessellator.addVertexWithUV(b, c, e, u, V);
            tessellator.addVertexWithUV(a, c, e, U, V);
            tessellator.addVertexWithUV(a, d, e, U, v);
            tessellator.addVertexWithUV(b, d, e, u, v);

            tessellator.addVertexWithUV(a, d, f, u, v);
            tessellator.addVertexWithUV(a, c, f, u, V);
            tessellator.addVertexWithUV(b, c, f, U, V);
            tessellator.addVertexWithUV(b, d, f, U, v);

            tessellator.addVertexWithUV(a, c, e, u, V);
            tessellator.addVertexWithUV(a, c, f, U, V);
            tessellator.addVertexWithUV(a, d, f, U, v);
            tessellator.addVertexWithUV(a, d, e, u, v);

            tessellator.addVertexWithUV(b, c, f, u, V);
            tessellator.addVertexWithUV(b, c, e, U, V);
            tessellator.addVertexWithUV(b, d, e, U, v);
            tessellator.addVertexWithUV(b, d, f, u, v);

            tessellator.addTranslation(-x, -y, -z);
        }
        // If this is the second (transparent) render pass...
        else {
            // Fix for PriorityQueue crash.
            Tessellator tessellator = Tessellator.instance;
            tessellator.addVertex(0, 0, 0);
            tessellator.addVertex(0, 0, 0);
            tessellator.addVertex(0, 0, 0);
            tessellator.addVertex(0, 0, 0);
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
