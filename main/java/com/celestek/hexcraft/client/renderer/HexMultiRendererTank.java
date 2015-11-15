package com.celestek.hexcraft.client.renderer;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.tileentity.TileTankRender;
import com.celestek.hexcraft.util.HexColors;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.common.Loader;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import org.lwjgl.opengl.GL11;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.7.0
 */

public class HexMultiRendererTank implements ISimpleBlockRenderingHandler {

    // Variables
    private int renderID;

    /**
     * Constructor for custom monolith rendering.
     * @param renderID Minecraft's internal ID of a certain block.
     */
    public HexMultiRendererTank(int renderID) {
        // Load the constructor parameters.
        this.renderID = renderID;

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

        // Adjust the rendering bounds.
        renderer.setRenderBounds(0.25, 0.25, 0.25, 0.75, 0.75, 0.75);

        // Render the outer frame.
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, 0));
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
        TileTankRender tileTankRender = (TileTankRender) world.getTileEntity(x, y, z);
        if (tileTankRender != null) {
            int startX = tileTankRender.getStartX() + 1;
            int startY = tileTankRender.getStartY() + 1;
            int startZ = tileTankRender.getStartZ() + 1;

            int endX = tileTankRender.getEndX();
            int endY = tileTankRender.getEndY();
            int endZ = tileTankRender.getEndZ();

            float tankCapacity = tileTankRender.getTankCapacity();
            float fluidLevel = tileTankRender.getFluidLevel();
            String fluidName = tileTankRender.getFluidName();

            float level = (endY - startY) * (fluidLevel / tankCapacity);

            Fluid fluid = FluidRegistry.getFluid(fluidName);
            if (fluid != null) {
                // Prepare the Tessellator.
                Tessellator tessellator = Tessellator.instance;
                tessellator.addTranslation(x, y, z);

                boolean luminosity = fluid.getLuminosity() != 0;
                if (luminosity) {
                    if (Loader.isModLoaded("coloredlightscore"))
                        tessellator.setBrightness(HexColors.BRIGHTNESS_CL);
                    else
                        tessellator.setBrightness(HexColors.BRIGHTNESS_BRIGHT);
                }

                tessellator.setColorOpaque_F(HexColors.COLOR_WHITE_R, HexColors.COLOR_WHITE_G, HexColors.COLOR_WHITE_B);

                float exactY = startY - y + level;
                int cutY = (int) Math.floor(exactY);

                int k;

                // Upper face.
                IIcon c = fluid.getStillIcon();
                float minU = c.getMinU();
                float minV = c.getMinV();
                float maxU = c.getMaxU();
                float maxV = c.getMaxV();

                // Y-
                k = startY - y;
                for (int i = startX - x; i < endX - x; i++) {
                    for (int j = startZ - z; j < endZ - z; j++) {
                        if (!luminosity)
                            tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x + i, startY - 1, z + j));
                        tessellator.addVertexWithUV(i + 1, k, j, maxU, minV);
                        tessellator.addVertexWithUV(i + 1, k, j + 1, maxU, maxV);
                        tessellator.addVertexWithUV(i, k, j + 1, minU, maxV);
                        tessellator.addVertexWithUV(i, k, j, minU, minV);
                    }
                }

                // Y+
                for (int i = startX - x; i < endX - x; i++) {
                    for (int j = startZ - z; j < endZ - z; j++) {
                        if (!luminosity)
                            tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x + i, (int) (startY + level), z + j));
                        tessellator.addVertexWithUV(i, exactY, j, minU, minV);
                        tessellator.addVertexWithUV(i, exactY, j + 1, minU, maxV);
                        tessellator.addVertexWithUV(i + 1, exactY, j + 1, maxU, maxV);
                        tessellator.addVertexWithUV(i + 1, exactY, j, maxU, minV);
                    }
                }

                // Side faces.
                c = fluid.getFlowingIcon();
                minU = c.getMinU();
                maxU = c.getInterpolatedU(8);
                maxV = c.getInterpolatedV(8);

                // X-
                minV = c.getMinV();
                k = startX - x;
                for (int i = startY - y; i < cutY; i++) {
                    for (int j = startZ - z; j < endZ - z; j++) {
                        if (!luminosity)
                            tessellator.setBrightness(block.getMixedBrightnessForBlock(world, startX - 1, y + i, z + j));
                        tessellator.addVertexWithUV(k, i, j, minU, maxV);
                        tessellator.addVertexWithUV(k, i, j + 1, maxU, maxV);
                        tessellator.addVertexWithUV(k, i + 1, j + 1, maxU, minV);
                        tessellator.addVertexWithUV(k, i + 1, j, minU, minV);
                    }
                }
                minV = c.getInterpolatedV(8 - (exactY - cutY) * 8);
                for (int j = startZ - z; j < endZ - z; j++) {
                    if (!luminosity)
                        tessellator.setBrightness(block.getMixedBrightnessForBlock(world, startX - 1, y + cutY, z + j));
                    tessellator.addVertexWithUV(k, cutY, j, minU, maxV);
                    tessellator.addVertexWithUV(k, cutY, j + 1, maxU, maxV);
                    tessellator.addVertexWithUV(k, exactY, j + 1, maxU, minV);
                    tessellator.addVertexWithUV(k, exactY, j, minU, minV);
                }

                // X+
                minV = c.getMinV();
                k = endX - x;
                for (int i = startY - y; i < cutY; i++) {
                    for (int j = startZ - z; j < endZ - z; j++) {
                        if (!luminosity)
                            tessellator.setBrightness(block.getMixedBrightnessForBlock(world, endX, y + i, z + j));
                        tessellator.addVertexWithUV(k, i + 1, j, minU, minV);
                        tessellator.addVertexWithUV(k, i + 1, j + 1, maxU, minV);
                        tessellator.addVertexWithUV(k, i, j + 1, maxU, maxV);
                        tessellator.addVertexWithUV(k, i, j, minU, maxV);
                    }
                }
                minV = c.getInterpolatedV(8 - (exactY - cutY) * 8);
                for (int j = startZ - z; j < endZ - z; j++) {
                    if (!luminosity)
                        tessellator.setBrightness(block.getMixedBrightnessForBlock(world, endX, y + cutY, z + j));
                    tessellator.addVertexWithUV(k, exactY, j, minU, minV);
                    tessellator.addVertexWithUV(k, exactY, j + 1, maxU, minV);
                    tessellator.addVertexWithUV(k, cutY, j + 1, maxU, maxV);
                    tessellator.addVertexWithUV(k, cutY, j, minU, maxV);
                }

                // Z-
                minV = c.getMinV();
                k = startZ - z;
                for (int i = startY - y; i < cutY; i++) {
                    for (int j = startX - x; j < endX - x; j++) {
                        if (!luminosity)
                            tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x + j, y + i, startZ - 1));
                        tessellator.addVertexWithUV(j, i + 1, k, minU, minV);
                        tessellator.addVertexWithUV(j + 1, i + 1, k, maxU, minV);
                        tessellator.addVertexWithUV(j + 1, i, k, maxU, maxV);
                        tessellator.addVertexWithUV(j, i, k, minU, maxV);
                    }
                }
                minV = c.getInterpolatedV(8 - (exactY - cutY) * 8);
                for (int j = startX - x; j < endX - x; j++) {
                    if (!luminosity)
                        tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x + j, y + cutY, startZ - 1));
                    tessellator.addVertexWithUV(j, exactY, k, minU, minV);
                    tessellator.addVertexWithUV(j + 1, exactY, k, maxU, minV);
                    tessellator.addVertexWithUV(j + 1, cutY, k, maxU, maxV);
                    tessellator.addVertexWithUV(j, cutY, k, minU, maxV);
                }

                // Z+
                minV = c.getMinV();
                k = endZ - z;
                for (int i = startY - y; i < cutY; i++) {
                    for (int j = startX - x; j < endX - x; j++) {
                        if (!luminosity)
                            tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x + j, y + i, endZ));
                        tessellator.addVertexWithUV(j, i, k, minU, maxV);
                        tessellator.addVertexWithUV(j + 1, i, k, maxU, maxV);
                        tessellator.addVertexWithUV(j + 1, i + 1, k, maxU, minV);
                        tessellator.addVertexWithUV(j, i + 1, k, minU, minV);
                    }
                }
                minV = c.getInterpolatedV(8 - (exactY - cutY) * 8);
                for (int j = startX - x; j < endX - x; j++) {
                    if (!luminosity)
                        tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x + j, y + cutY, endZ));
                    tessellator.addVertexWithUV(j, cutY, k, minU, maxV);
                    tessellator.addVertexWithUV(j + 1, cutY, k, maxU, maxV);
                    tessellator.addVertexWithUV(j + 1, exactY, k, maxU, minV);
                    tessellator.addVertexWithUV(j, exactY, k, minU, minV);
                }

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

        // Render the test block.
        if (HexConfig.cfgTankRenderDebug)
            renderer.renderStandardBlock(block, x, y, z);

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
