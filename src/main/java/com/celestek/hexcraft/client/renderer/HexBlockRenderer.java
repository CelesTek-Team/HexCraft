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

import static com.celestek.hexcraft.init.HexConfig.cfgGeneralFlickerFix;

public class HexBlockRenderer implements ISimpleBlockRenderingHandler {

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
    public HexBlockRenderer(int renderID, HexEnums.Brightness brightness, HexEnums.Colors color) {
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

    public HexBlockRenderer(int renderID, int brightness, float r, float g, float b) {
        // Save the current HexCraft block ID.
        this.renderBlockID = HexCraft.idCounter;

        // Load the constructor parameters.
        this.renderID = renderID;

        if (Loader.isModLoaded("coloredlightscore"))
            this.brightness = HexEnums.Brightness.CL.value;
        else
            this.brightness = brightness;

        this.r = r;
        this.g = g;
        this.b = b;

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

        int meta;
        if (block instanceof BlockTankValve)
            meta = HexUtils.setBit(BlockTankValve.META_ROTATION, true, 0);
        else
            meta = 2;

        float darken;
        if (block instanceof BlockHexoriumLamp)
            darken = HexEnums.MULTIPLIER_DARKEN;
        else
            darken = 1.0F;

        // Start drawing inner layer of the block.
        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r * darken, g * darken, b * darken);
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 1));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r * darken, g * darken, b * darken);
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        // If special faces should be drawn, use those textures instead.
        if(block instanceof BlockOfHexoriumCrystal)
            renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(7, 1));
        else
            renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 1));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r * darken, g * darken, b * darken);
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        if(block instanceof BlockOfHexoriumCrystal)
            renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(8, 1));
        else
            renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 1));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r * darken, g * darken, b * darken);
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        if(block instanceof BlockOfHexoriumCrystal)
            renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(9, 1));
        else
            renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 1));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r * darken, g * darken, b * darken);
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        if(block instanceof BlockOfHexoriumCrystal)
            renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(10, 1));
        else
            renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 1));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r * darken, g * darken, b * darken);
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        if(block instanceof BlockOfHexoriumCrystal)
            renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(11, 1));
        else
            renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 1));
        tessellator.draw();

        // Start drawing outer layer of the block.
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, meta));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(1, meta));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(2, meta));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(3, meta));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(4, meta));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(5, meta));
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
        int meta = world.getBlockMetadata(x, y, z);

        // Check if this is the first (opaque) render pass, if it is...
        if(HexClientProxy.renderPass[renderBlockID] == 0) {
            boolean doInner =
                    !(block instanceof BlockHexoriumNetherOre
                    || block instanceof BlockHexoriumOre
                    || block instanceof BlockHexoriumStructureCasing
                    || block instanceof BlockHexoriumLamp
                    || block instanceof BlockHexoriumLampInv);
            boolean doOffset =
                    block instanceof BlockEnergizedHexorium
                    || block instanceof BlockOfHexoriumCrystal
                    || block instanceof BlockGlowingHexoriumGlass;
            float o = cfgGeneralFlickerFix;
            if (doOffset)
                o = 0.000F;

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
            float darken = 1.0F;
            if ((block instanceof BlockHexoriumLamp && !HexUtils.getMetaBit(BlockHexoriumLamp.META_STATE, world, x, y, z))
                    || (block instanceof BlockHexoriumLampInv && HexUtils.getMetaBit(BlockHexoriumLamp.META_STATE, world, x, y, z)))
                darken = HexEnums.MULTIPLIER_DARKEN;
            tessellator.setColorOpaque_F(r * darken, g * darken, b * darken);

            // DOWN
            // Check if the block face should be visible. If yes draw it.
            if(block.shouldSideBeRendered(world, x, y - 1, z, 0)) {
                // If special faces should be drawn, use those textures instead.
                if (block instanceof BlockOfHexoriumCrystal) {
                    c = block.getIcon(6, meta);
                    u = c.getMinU();
                    v = c.getMinV();
                    U = c.getMaxU();
                    V = c.getMaxV();
                }
                else if (block instanceof BlockGlowingHexoriumGlass) {
                    c = block.getIcon(world, x, y, z, 6);
                    u = c.getMinU();
                    v = c.getMinV();
                    U = c.getMaxU();
                    V = c.getMaxV();
                }
                tessellator.addVertexWithUV(0, 0+o, 1, u, V);
                tessellator.addVertexWithUV(0, 0+o, 0, u, v);
                tessellator.addVertexWithUV(1, 0+o, 0, U, v);
                tessellator.addVertexWithUV(1, 0+o, 1, U, V);
            }
            else if (o > 0 && doInner) {
                tessellator.addVertexWithUV(1, 0, 1, U, V);
                tessellator.addVertexWithUV(1, 0, 0, U, v);
                tessellator.addVertexWithUV(0, 0, 0, u, v);
                tessellator.addVertexWithUV(0, 0, 1, u, V);
            }

            // UP
            if(block.shouldSideBeRendered(world, x, y + 1, z, 1)) {
                if (block instanceof BlockOfHexoriumCrystal) {
                    c = block.getIcon(7, meta);
                    u = c.getMinU();
                    v = c.getMinV();
                    U = c.getMaxU();
                    V = c.getMaxV();
                }
                else if (block instanceof BlockGlowingHexoriumGlass) {
                    c = block.getIcon(world, x, y, z, 7);
                    u = c.getMinU();
                    v = c.getMinV();
                    U = c.getMaxU();
                    V = c.getMaxV();
                }
                tessellator.addVertexWithUV(0, 1-o, 0, u, v);
                tessellator.addVertexWithUV(0, 1-o, 1, u, V);
                tessellator.addVertexWithUV(1, 1-o, 1, U, V);
                tessellator.addVertexWithUV(1, 1-o, 0, U, v);
            }
            else if (o > 0 && doInner) {
                tessellator.addVertexWithUV(1, 1, 0, U, v);
                tessellator.addVertexWithUV(1, 1, 1, U, V);
                tessellator.addVertexWithUV(0, 1, 1, u, V);
                tessellator.addVertexWithUV(0, 1, 0, u, v);
            }

            // NORTH
            if(block.shouldSideBeRendered(world, x, y, z - 1, 2)) {
                if (block instanceof BlockOfHexoriumCrystal) {
                    c = block.getIcon(8, meta);
                    u = c.getMinU();
                    v = c.getMinV();
                    U = c.getMaxU();
                    V = c.getMaxV();
                }
                else if (block instanceof BlockGlowingHexoriumGlass) {
                    c = block.getIcon(world, x, y, z, 8);
                    u = c.getMinU();
                    v = c.getMinV();
                    U = c.getMaxU();
                    V = c.getMaxV();
                }
                tessellator.addVertexWithUV(1, 0, 0+o, u, V);
                tessellator.addVertexWithUV(0, 0, 0+o, U, V);
                tessellator.addVertexWithUV(0, 1, 0+o, U, v);
                tessellator.addVertexWithUV(1, 1, 0+o, u, v);
            }
            else if (o > 0 && doInner) {
                tessellator.addVertexWithUV(1, 1, 0, u, v);
                tessellator.addVertexWithUV(0, 1, 0, U, v);
                tessellator.addVertexWithUV(0, 0, 0, U, V);
                tessellator.addVertexWithUV(1, 0, 0, u, V);
            }

            // SOUTH
            if(block.shouldSideBeRendered(world, x, y, z + 1, 3)) {
                if (block instanceof BlockOfHexoriumCrystal) {
                    c = block.getIcon(9, meta);
                    u = c.getMinU();
                    v = c.getMinV();
                    U = c.getMaxU();
                    V = c.getMaxV();
                }
                else if (block instanceof BlockGlowingHexoriumGlass) {
                    c = block.getIcon(world, x, y, z, 9);
                    u = c.getMinU();
                    v = c.getMinV();
                    U = c.getMaxU();
                    V = c.getMaxV();
                }
                tessellator.addVertexWithUV(0, 1, 1-o, u, v);
                tessellator.addVertexWithUV(0, 0, 1-o, u, V);
                tessellator.addVertexWithUV(1, 0, 1-o, U, V);
                tessellator.addVertexWithUV(1, 1, 1-o, U, v);
            }
            else if (o > 0 && doInner) {
                tessellator.addVertexWithUV(1, 1, 1, U, v);
                tessellator.addVertexWithUV(1, 0, 1, U, V);
                tessellator.addVertexWithUV(0, 0, 1, u, V);
                tessellator.addVertexWithUV(0, 1, 1, u, v);
            }

            // WEST
            if(block.shouldSideBeRendered(world, x - 1, y, z, 4)) {
                if (block instanceof BlockOfHexoriumCrystal) {
                    c = block.getIcon(10, meta);
                    u = c.getMinU();
                    v = c.getMinV();
                    U = c.getMaxU();
                    V = c.getMaxV();
                }
                else if (block instanceof BlockGlowingHexoriumGlass) {
                    c = block.getIcon(world, x, y, z, 10);
                    u = c.getMinU();
                    v = c.getMinV();
                    U = c.getMaxU();
                    V = c.getMaxV();
                }
                tessellator.addVertexWithUV(0+o, 0, 0, u, V);
                tessellator.addVertexWithUV(0+o, 0, 1, U, V);
                tessellator.addVertexWithUV(0+o, 1, 1, U, v);
                tessellator.addVertexWithUV(0+o, 1, 0, u, v);
            }
            else if (o > 0 && doInner) {
                tessellator.addVertexWithUV(0, 1, 0, u, v);
                tessellator.addVertexWithUV(0, 1, 1, U, v);
                tessellator.addVertexWithUV(0, 0, 1, U, V);
                tessellator.addVertexWithUV(0, 0, 0, u, V);
            }

            // EAST
            if(block.shouldSideBeRendered(world, x + 1, y, z, 5)) {
                if (block instanceof BlockOfHexoriumCrystal) {
                    c = block.getIcon(11, meta);
                    u = c.getMinU();
                    v = c.getMinV();
                    U = c.getMaxU();
                    V = c.getMaxV();
                }
                else if (block instanceof BlockGlowingHexoriumGlass) {
                    c = block.getIcon(world, x, y, z, 11);
                    u = c.getMinU();
                    v = c.getMinV();
                    U = c.getMaxU();
                    V = c.getMaxV();
                }
                tessellator.addVertexWithUV(1-o, 0, 1, u, V);
                tessellator.addVertexWithUV(1-o, 0, 0, U, V);
                tessellator.addVertexWithUV(1-o, 1, 0, U, v);
                tessellator.addVertexWithUV(1-o, 1, 1, u, v);
            }
            else if (o > 0 && doInner) {
                tessellator.addVertexWithUV(1, 1, 1, u, v);
                tessellator.addVertexWithUV(1, 1, 0, U, v);
                tessellator.addVertexWithUV(1, 0, 0, U, V);
                tessellator.addVertexWithUV(1, 0, 1, u, V);
            }

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

            // Draw the outer layer of the block.
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
