package com.celestek.hexcraft.client.renderer;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.HexClientProxy;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.util.HexEnums;
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
 */

public class HexBlockTeleportationRenderer implements ISimpleBlockRenderingHandler {

    // Static Values
    private static final float teleportOffset = 0.015625F;

    // Variables
    private int renderID;
    private int renderBlockID;
    private int brightness;
    private float r = 1F;
    private float g = 1F;
    private float b = 1F;
    private float tr = 1F;
    private float tg = 1F;
    private float tb = 1F;

    /**
     * Constructor for custom block rendering.
     * @param renderID Minecraft's internal ID of a certain block.
     * @param brightness Intensity of the inner block layer glow.
     * @param r Red component of the inner block layer color.
     * @param g Green component of the inner block layer color.
     * @param b Blue component of the inner block layer color.
     * @param tr Red component of the field color.
     * @param tg Green component of the field color.
     * @param tb Blue component of the field color.
     */
    public HexBlockTeleportationRenderer(int renderID, int brightness, float r, float g, float b, float tr, float tg, float tb) {
        // Save the current HexCraft block ID.
        this.renderBlockID = HexCraft.idCounter;

        // Load the constructor parameters.
        this.renderID = renderID;

        if (Loader.isModLoaded("coloredlightscore"))
            this.brightness = HexEnums.BRIGHTNESS_CL;
        else
            this.brightness = brightness;

        this.r = r;
        this.g = g;
        this.b = b;

        this.tr = tr;
        this.tg = tg;
        this.tb = tb;

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

        // Start drawing inner layer of the block.
        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 1));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(HexEnums.COLOR_BLACK_R, HexEnums.COLOR_BLACK_G, HexEnums.COLOR_BLACK_B);
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 1));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 1));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 1));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 1));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 1));
        tessellator.draw();

        // Start drawing outer layer of the block.
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
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(2, 2));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(3, 2));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(4, 2));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(5, 2));
        tessellator.draw();

        // Turn Mipmap ON.
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, minFilter);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, magFilter);

        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    /**
     * Renders the block in world.
     */
    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        // Check if this is the first (opaque) render pass, if it is...
        if(HexClientProxy.renderPass[renderBlockID] == 0) {
            // Prepare the Tessellator.
            Tessellator tessellator = Tessellator.instance;
            tessellator.addTranslation(x, y, z);

            // Prepare the inner block texture.
            IIcon c = block.getIcon(6, 0);
            float u = c.getMinU();
            float v = c.getMinV();
            float U = c.getMaxU();
            float V = c.getMaxV();

            // Set up brightness and color.
            tessellator.setBrightness(brightness);
            tessellator.setColorOpaque_F(r, g, b);

            // DOWN
            // Check if the block face should be visible. If yes draw it.
            if(!world.getBlock(x, y - 1, z).isOpaqueCube()) {
                tessellator.addVertexWithUV(0, 0, 1, u, V);
                tessellator.addVertexWithUV(0, 0, 0, u, v);
                tessellator.addVertexWithUV(1, 0, 0, U, v);
                tessellator.addVertexWithUV(1, 0, 1, U, V);
            }

            // UP (Teleportation Pad)
            if(!world.getBlock(x, y + 1, z).isOpaqueCube()) {
                tessellator.setColorOpaque_F(HexEnums.COLOR_BLACK_R, HexEnums.COLOR_BLACK_G, HexEnums.COLOR_BLACK_B);
                tessellator.addVertexWithUV(0, 1, 0, u, v);
                tessellator.addVertexWithUV(0, 1, 1, u, V);
                tessellator.addVertexWithUV(1, 1, 1, U, V);
                tessellator.addVertexWithUV(1, 1, 0, U, v);
                tessellator.setColorOpaque_F(r, g, b);
            }

            // NORTH
            if(!world.getBlock(x, y, z - 1).isOpaqueCube()) {
                tessellator.addVertexWithUV(1, 0, 0, u, V);
                tessellator.addVertexWithUV(0, 0, 0, U, V);
                tessellator.addVertexWithUV(0, 1, 0, U, v);
                tessellator.addVertexWithUV(1, 1, 0, u, v);
            }

            // SOUTH
            if(!world.getBlock(x, y, z +1 ).isOpaqueCube()) {
                tessellator.addVertexWithUV(0, 1, 1, u, v);
                tessellator.addVertexWithUV(0, 0, 1, u, V);
                tessellator.addVertexWithUV(1, 0, 1, U, V);
                tessellator.addVertexWithUV(1, 1, 1, U, v);
            }

            // WEST
            if(!world.getBlock(x - 1, y, z).isOpaqueCube()) {
                tessellator.addVertexWithUV(0, 0, 0, u, V);
                tessellator.addVertexWithUV(0, 0, 1, U, V);
                tessellator.addVertexWithUV(0, 1, 1, U, v);
                tessellator.addVertexWithUV(0, 1, 0, u, v);
            }

            // EAST
            if(!world.getBlock(x + 1, y, z).isOpaqueCube()) {
                tessellator.addVertexWithUV(1, 0, 1, u, V);
                tessellator.addVertexWithUV(1, 0, 0, U, V);
                tessellator.addVertexWithUV(1, 1, 0, U, v);
                tessellator.addVertexWithUV(1, 1, 1, u, v);
            }

            tessellator.addTranslation(-x, -y, -z);
        }
        // If this is the second (transparent) render pass...
        else {
            // Draw the outer layer of the block.
            renderer.renderStandardBlock(block, x, y, z);

            // If the field is active...
            if (HexBlocks.getMachineState(world, x, y, z) == HexBlocks.MACHINE_STATE_ACTIVE) {
                // Prepare the Tessellator.
                Tessellator tessellator = Tessellator.instance;
                tessellator.addTranslation(x, y, z);

                // Prepare the inner block texture.
                IIcon c = block.getIcon(7, 0);
                float u = c.getInterpolatedU(0);
                float v = c.getInterpolatedV(0);
                float U = c.getInterpolatedU(8);
                float V = c.getInterpolatedV(16);

                // Set up brightness and color.
                tessellator.setBrightness(brightness);
                tessellator.setColorOpaque_F(tr, tg, tb);

                // NORTH
                tessellator.addVertexWithUV(1 - teleportOffset, 1, 0 + teleportOffset, u, V);
                tessellator.addVertexWithUV(0 + teleportOffset, 1, 0 + teleportOffset, U, V);
                tessellator.addVertexWithUV(0 + teleportOffset, 3, 0 + teleportOffset, U, v);
                tessellator.addVertexWithUV(1 - teleportOffset, 3, 0 + teleportOffset, u, v);

                tessellator.addVertexWithUV(1 - teleportOffset, 3, 0 + teleportOffset, u, v);
                tessellator.addVertexWithUV(0 + teleportOffset, 3, 0 + teleportOffset, U, v);
                tessellator.addVertexWithUV(0 + teleportOffset, 1, 0 + teleportOffset, U, V);
                tessellator.addVertexWithUV(1 - teleportOffset, 1, 0 + teleportOffset, u, V);

                // SOUTH
                tessellator.addVertexWithUV(0 + teleportOffset, 3, 1 - teleportOffset, u, v);
                tessellator.addVertexWithUV(0 + teleportOffset, 1, 1 - teleportOffset, u, V);
                tessellator.addVertexWithUV(1 - teleportOffset, 1, 1 - teleportOffset, U, V);
                tessellator.addVertexWithUV(1 - teleportOffset, 3, 1 - teleportOffset, U, v);

                tessellator.addVertexWithUV(1 - teleportOffset, 3, 1 - teleportOffset, U, v);
                tessellator.addVertexWithUV(1 - teleportOffset, 1, 1 - teleportOffset, U, V);
                tessellator.addVertexWithUV(0 + teleportOffset, 1, 1 - teleportOffset, u, V);
                tessellator.addVertexWithUV(0 + teleportOffset, 3, 1 - teleportOffset, u, v);

                // WEST
                tessellator.addVertexWithUV(0 + teleportOffset, 1, 0 + teleportOffset, u, V);
                tessellator.addVertexWithUV(0 + teleportOffset, 1, 1, U, V);
                tessellator.addVertexWithUV(0 + teleportOffset, 3, 1, U, v);
                tessellator.addVertexWithUV(0 + teleportOffset, 3, 0 + teleportOffset, u, v);

                tessellator.addVertexWithUV(0 + teleportOffset, 3, 0 + teleportOffset, u, v);
                tessellator.addVertexWithUV(0 + teleportOffset, 3, 1 - teleportOffset, U, v);
                tessellator.addVertexWithUV(0 + teleportOffset, 1, 1 - teleportOffset, U, V);
                tessellator.addVertexWithUV(0 + teleportOffset, 1, 0 + teleportOffset, u, V);

                // EAST
                tessellator.addVertexWithUV(1 - teleportOffset, 1, 1 - teleportOffset, u, V);
                tessellator.addVertexWithUV(1 - teleportOffset, 1, 0 + teleportOffset, U, V);
                tessellator.addVertexWithUV(1 - teleportOffset, 3, 0 + teleportOffset, U, v);
                tessellator.addVertexWithUV(1 - teleportOffset, 3, 1 - teleportOffset, u, v);

                tessellator.addVertexWithUV(1 - teleportOffset, 3, 1 - teleportOffset, u, v);
                tessellator.addVertexWithUV(1 - teleportOffset, 3, 0 + teleportOffset, U, v);
                tessellator.addVertexWithUV(1 - teleportOffset, 1, 0 + teleportOffset, U, V);
                tessellator.addVertexWithUV(1 - teleportOffset, 1, 1 - teleportOffset, u, V);

                tessellator.addTranslation(-x, -y, -z);
            }
            else {
                // Fix for PriorityQueue crash.
                Tessellator tessellator = Tessellator.instance;
                tessellator.addVertex(0, 0, 0);
                tessellator.addVertex(0, 0, 0);
                tessellator.addVertex(0, 0, 0);
                tessellator.addVertex(0, 0, 0);
            }
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
