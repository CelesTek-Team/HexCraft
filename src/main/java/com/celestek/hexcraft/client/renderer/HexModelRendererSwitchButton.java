package com.celestek.hexcraft.client.renderer;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.BlockHexoriumButton;
import com.celestek.hexcraft.block.BlockHexoriumSwitch;
import com.celestek.hexcraft.client.HexClientProxy;
import com.celestek.hexcraft.init.HexBlocks;
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

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class HexModelRendererSwitchButton implements ISimpleBlockRenderingHandler {

    // Model constants.
    public static final float sbBack = 0.0F;
    public static final float sbFron = 0.125F;
    public static final float sbHori = 0.375F;
    public static final float sbVert = 0.375F;
    public static final float sbPixl = 0.0625F;

    private static final float sbOffs = 0.001F;

    // Variables
    private int renderID;
    private int renderBlockID;
    private int brightness;

    /**
     * Constructor for custom monolith rendering.
     * @param renderID Minecraft's internal ID of a certain block.
     * @param brightness Intensity of the monolith glow.
     */
    public HexModelRendererSwitchButton(int renderID, int brightness) {
        // Save the current HexCraft block ID.
        this.renderBlockID = HexCraft.idCounter;

        // Load the constructor parameters.
        this.renderID = renderID;

        if (Loader.isModLoaded("coloredlightscore"))
            this.brightness = HexEnums.BRIGHTNESS_CL;
        else
            this.brightness = brightness;

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
        renderer.setRenderBounds(sbHori, sbVert, sbHori + sbPixl, 1 - sbHori, 1 - sbVert, 1 - sbHori - sbPixl);

        // Render the outer frame.
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

        // Render glow.
        if (block instanceof BlockHexoriumSwitch) {
            tessellator.startDrawingQuads();

            // Set up brightness and color.
            tessellator.setBrightness(brightness);
            if (block == HexBlocks.blockHexoriumSwitchBlueGreen || block == HexBlocks.blockHexoriumSwitchWhiteBlueGreen)
                tessellator.setColorOpaque_F(0, 0, 1);
            else
                tessellator.setColorOpaque_F(1, 0, 0);
            tessellator.setNormal(0.0F, 0.0F, 1.0F);

            // Draw glow.
            tessellator.addVertexWithUV(sbHori, 1 - sbVert - sbPixl, 1 - sbHori - sbPixl + sbOffs, c.getInterpolatedU(6), c.getInterpolatedV(7));
            tessellator.addVertexWithUV(sbHori, sbVert + sbPixl, 1 - sbHori - sbPixl + sbOffs, c.getInterpolatedU(6), c.getInterpolatedV(9));
            tessellator.addVertexWithUV(sbHori + sbPixl, sbVert + sbPixl, 1 - sbHori - sbPixl + sbOffs, c.getInterpolatedU(7), c.getInterpolatedV(9));
            tessellator.addVertexWithUV(sbHori + sbPixl, 1 - sbVert - sbPixl, 1 - sbHori - sbPixl + sbOffs, c.getInterpolatedU(7), c.getInterpolatedV(7));

            // Set up color.
            if (block == HexBlocks.blockHexoriumSwitchRedGreen || block == HexBlocks.blockHexoriumSwitchWhiteRedGreen)
                tessellator.setColorOpaque_F(0, 1, 0);
            else if (block == HexBlocks.blockHexoriumSwitchRedBlue || block == HexBlocks.blockHexoriumSwitchWhiteRedBlue)
                tessellator.setColorOpaque_F(0, 0, 1);
            else if (block == HexBlocks.blockHexoriumSwitchRedWhite || block == HexBlocks.blockHexoriumSwitchWhiteRedWhite)
                tessellator.setColorOpaque_F(1, 1, 1);
            else if (block == HexBlocks.blockHexoriumSwitchBlueGreen || block == HexBlocks.blockHexoriumSwitchWhiteBlueGreen)
                tessellator.setColorOpaque_F(0, 1, 0);

            // Draw glow.
            tessellator.addVertexWithUV(1 - sbHori - sbPixl, 1 - sbVert - sbPixl, 1 - sbHori - sbPixl + sbOffs, c.getInterpolatedU(9), c.getInterpolatedV(7));
            tessellator.addVertexWithUV(1 - sbHori - sbPixl, sbVert + sbPixl, 1 - sbHori - sbPixl + sbOffs, c.getInterpolatedU(9), c.getInterpolatedV(9));
            tessellator.addVertexWithUV(1 - sbHori, sbVert + sbPixl, 1 - sbHori - sbPixl + sbOffs, c.getInterpolatedU(10), c.getInterpolatedV(9));
            tessellator.addVertexWithUV(1 - sbHori, 1 - sbVert - sbPixl, 1 - sbHori - sbPixl + sbOffs, c.getInterpolatedU(10), c.getInterpolatedV(7));

            tessellator.draw();
        }
        else if (block instanceof BlockHexoriumButton) {
            tessellator.startDrawingQuads();

            // Set up brightness and color.
            tessellator.setBrightness(brightness);
            tessellator.setNormal(0.0F, 0.0F, 1.0F);
            if (block == HexBlocks.blockHexoriumButtonRed || block == HexBlocks.blockHexoriumButtonWhiteRed)
                tessellator.setColorOpaque_F(1, 0, 0);
            else if (block == HexBlocks.blockHexoriumButtonGreen || block == HexBlocks.blockHexoriumButtonWhiteGreen)
                tessellator.setColorOpaque_F(0, 1, 0);
            else if (block == HexBlocks.blockHexoriumButtonBlue || block == HexBlocks.blockHexoriumButtonWhiteBlue)
                tessellator.setColorOpaque_F(0, 0, 1);
            else if (block == HexBlocks.blockHexoriumButtonWhite || block == HexBlocks.blockHexoriumButtonWhiteWhite)
                tessellator.setColorOpaque_F(1, 1, 1);

            // Draw glow.
            tessellator.addVertexWithUV(sbHori + sbPixl, 1 - sbVert - sbPixl, 1 - sbHori - sbPixl + sbOffs, c.getInterpolatedU(7), c.getInterpolatedV(7));
            tessellator.addVertexWithUV(sbHori + sbPixl, sbVert + sbPixl, 1 - sbHori - sbPixl + sbOffs, c.getInterpolatedU(7), c.getInterpolatedV(9));
            tessellator.addVertexWithUV(1 - sbHori - sbPixl, sbVert + sbPixl, 1 - sbHori - sbPixl + sbOffs, c.getInterpolatedU(9), c.getInterpolatedV(9));
            tessellator.addVertexWithUV(1 - sbHori - sbPixl, 1 - sbVert - sbPixl, 1 - sbHori - sbPixl + sbOffs, c.getInterpolatedU(9), c.getInterpolatedV(7));

            tessellator.draw();
        }

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
        int orientation = 0;
        if (block instanceof BlockHexoriumButton)
            orientation = HexUtils.getMetaBitTriInt(
                    BlockHexoriumButton.META_ORIENTATION_0,
                    BlockHexoriumButton.META_ORIENTATION_1,
                    BlockHexoriumButton.META_ORIENTATION_2, world, x, y, z);
        else if (block instanceof BlockHexoriumSwitch)
            orientation = HexUtils.getMetaBitTriInt(
                    BlockHexoriumSwitch.META_ORIENTATION_0,
                    BlockHexoriumSwitch.META_ORIENTATION_1,
                    BlockHexoriumSwitch.META_ORIENTATION_2, world, x, y, z);

        // Check if this is the first (opaque) render pass, if it is...
        if(HexClientProxy.renderPass[renderBlockID] == 0) {
            // Adjust the rendering bounds.
            if (block instanceof BlockHexoriumButton && HexUtils.getMetaBit(BlockHexoriumButton.META_STATE, world, x, y, z)) {
                if (orientation == 1)
                    renderer.setRenderBounds(sbHori, sbBack, sbVert, 1 - sbHori, sbPixl, 1 - sbVert);
                else if (orientation == 2)
                    renderer.setRenderBounds(sbHori, sbVert, 1 - sbPixl, 1 - sbHori, 1 - sbVert, 1 - sbBack);
                else if (orientation == 3)
                    renderer.setRenderBounds(sbHori, sbVert, sbBack, 1 - sbHori, 1 - sbVert, sbPixl);
                else if (orientation == 4)
                    renderer.setRenderBounds(1 - sbPixl, sbVert, sbHori, 1 - sbBack, 1 - sbVert, 1 - sbHori);
                else if (orientation == 5)
                    renderer.setRenderBounds(sbBack, sbVert, sbHori, sbPixl, 1 - sbVert, 1 - sbHori);
                else
                    renderer.setRenderBounds(sbHori, 1 - sbPixl, sbVert, 1 - sbHori, 1 - sbBack, 1 - sbVert);
            }
            else {
                if (orientation == 1)
                    renderer.setRenderBounds(sbHori, sbBack, sbVert, 1 - sbHori, sbFron, 1 - sbVert);
                else if (orientation == 7)
                    renderer.setRenderBounds(sbVert, sbBack, sbHori, 1 - sbVert, sbFron, 1 - sbHori);
                else if (orientation == 2)
                    renderer.setRenderBounds(sbHori, sbVert, 1 - sbFron, 1 - sbHori, 1 - sbVert, 1 - sbBack);
                else if (orientation == 3)
                    renderer.setRenderBounds(sbHori, sbVert, sbBack, 1 - sbHori, 1 - sbVert, sbFron);
                else if (orientation == 4)
                    renderer.setRenderBounds(1 - sbFron, sbVert, sbHori, 1 - sbBack, 1 - sbVert, 1 - sbHori);
                else if (orientation == 5)
                    renderer.setRenderBounds(sbBack, sbVert, sbHori, sbFron, 1 - sbVert, 1 - sbHori);
                else if (orientation == 6)
                    renderer.setRenderBounds(sbVert, 1 - sbFron, sbHori, 1 - sbVert, 1 - sbBack, 1 - sbHori);
                else
                    renderer.setRenderBounds(sbHori, 1 - sbFron, sbVert, 1 - sbHori, 1 - sbBack, 1 - sbVert);
            }

            // Render the outer frame.
            renderer.renderStandardBlock(block, x, y, z);
        }
        // If this is the second (transparent) render pass...
        else {
            // Prepare the Tessellator.
            Tessellator tessellator = Tessellator.instance;
            tessellator.addTranslation(x, y, z);

            // Prepare the icon.
            IIcon c = block.getIcon(6, 0);

            // Set up brightness.
            tessellator.setBrightness(brightness);

            // Draw switch glow.
            if (block instanceof BlockHexoriumSwitch) {
                float darken1;
                float darken2;
                if (HexUtils.getMetaBit(BlockHexoriumSwitch.META_STATE, world, x, y, z)) {
                    darken1 = HexEnums.MULTIPLIER_DARKEN;
                    darken2 = 1.0F;
                }
                else {
                    darken1 = 1.0F;
                    darken2 = HexEnums.MULTIPLIER_DARKEN;
                }
                if (block == HexBlocks.blockHexoriumSwitchBlueGreen || block == HexBlocks.blockHexoriumSwitchWhiteBlueGreen)
                    tessellator.setColorOpaque_F(0, 0, darken1);
                else
                    tessellator.setColorOpaque_F(darken1, 0, 0);

                if (orientation == 1) {
                    tessellator.addVertexWithUV(sbHori + sbPixl, sbFron + sbOffs, 1 - sbVert - sbPixl, c.getInterpolatedU(7), c.getInterpolatedV(7));
                    tessellator.addVertexWithUV(sbHori + sbPixl, sbFron + sbOffs, sbVert + sbPixl, c.getInterpolatedU(7), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(sbHori, sbFron + sbOffs, sbVert + sbPixl, c.getInterpolatedU(6), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(sbHori, sbFron + sbOffs, 1 - sbVert - sbPixl, c.getInterpolatedU(6), c.getInterpolatedV(7));
                }
                else if (orientation == 7) {
                    tessellator.addVertexWithUV(1 - sbVert - sbPixl, sbFron + sbOffs, sbHori, c.getInterpolatedU(6), c.getInterpolatedV(7));
                    tessellator.addVertexWithUV(sbVert + sbPixl, sbFron + sbOffs, sbHori, c.getInterpolatedU(6), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(sbVert + sbPixl, sbFron + sbOffs, sbHori + sbPixl, c.getInterpolatedU(7), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(1 - sbVert - sbPixl, sbFron + sbOffs, sbHori + sbPixl, c.getInterpolatedU(7), c.getInterpolatedV(7));
                }
                else if (orientation == 2) {
                    tessellator.addVertexWithUV(1 - sbHori, 1 - sbVert - sbPixl, 1 - sbFron - sbOffs, c.getInterpolatedU(6), c.getInterpolatedV(7));
                    tessellator.addVertexWithUV(1 - sbHori, sbVert + sbPixl, 1 - sbFron - sbOffs, c.getInterpolatedU(6), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(1 - sbHori - sbPixl, sbVert + sbPixl, 1 - sbFron - sbOffs, c.getInterpolatedU(7), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(1 - sbHori - sbPixl, 1 - sbVert - sbPixl, 1 - sbFron - sbOffs, c.getInterpolatedU(7), c.getInterpolatedV(7));
                }
                else if (orientation == 3) {
                    tessellator.addVertexWithUV(sbHori, 1 - sbVert - sbPixl, sbFron + sbOffs, c.getInterpolatedU(6), c.getInterpolatedV(7));
                    tessellator.addVertexWithUV(sbHori, sbVert + sbPixl, sbFron + sbOffs, c.getInterpolatedU(6), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(sbHori + sbPixl, sbVert + sbPixl, sbFron + sbOffs, c.getInterpolatedU(7), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(sbHori + sbPixl, 1 - sbVert - sbPixl, sbFron + sbOffs, c.getInterpolatedU(7), c.getInterpolatedV(7));
                }
                else if (orientation == 4) {
                    tessellator.addVertexWithUV(1 - sbFron - sbOffs, 1 - sbVert - sbPixl, sbHori, c.getInterpolatedU(6), c.getInterpolatedV(7));
                    tessellator.addVertexWithUV(1 - sbFron - sbOffs, sbVert + sbPixl, sbHori, c.getInterpolatedU(6), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(1 - sbFron - sbOffs, sbVert + sbPixl, sbHori + sbPixl, c.getInterpolatedU(7), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(1 - sbFron - sbOffs, 1 - sbVert - sbPixl, sbHori + sbPixl, c.getInterpolatedU(7), c.getInterpolatedV(7));
                }
                else if (orientation == 5) {
                    tessellator.addVertexWithUV(sbFron + sbOffs, 1 - sbVert - sbPixl, 1 - sbHori, c.getInterpolatedU(6), c.getInterpolatedV(7));
                    tessellator.addVertexWithUV(sbFron + sbOffs, sbVert + sbPixl, 1 - sbHori, c.getInterpolatedU(6), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(sbFron + sbOffs, sbVert + sbPixl, 1 - sbHori - sbPixl, c.getInterpolatedU(7), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(sbFron + sbOffs, 1 - sbVert - sbPixl, 1 - sbHori - sbPixl, c.getInterpolatedU(7), c.getInterpolatedV(7));
                }
                else if (orientation == 6) {
                    tessellator.addVertexWithUV(1 - sbVert - sbPixl, 1 - sbFron - sbOffs, sbHori + sbPixl, c.getInterpolatedU(7), c.getInterpolatedV(7));
                    tessellator.addVertexWithUV(sbVert + sbPixl, 1 - sbFron - sbOffs, sbHori + sbPixl, c.getInterpolatedU(7), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(sbVert + sbPixl, 1 - sbFron - sbOffs, sbHori, c.getInterpolatedU(6), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(1 - sbVert - sbPixl, 1 - sbFron - sbOffs, sbHori, c.getInterpolatedU(6), c.getInterpolatedV(7));
                }
                else {
                    tessellator.addVertexWithUV(sbHori, 1 - sbFron - sbOffs, 1 - sbVert - sbPixl, c.getInterpolatedU(6), c.getInterpolatedV(7));
                    tessellator.addVertexWithUV(sbHori, 1 - sbFron - sbOffs, sbVert + sbPixl, c.getInterpolatedU(6), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(sbHori + sbPixl, 1 - sbFron - sbOffs, sbVert + sbPixl, c.getInterpolatedU(7), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(sbHori + sbPixl, 1 - sbFron - sbOffs, 1 - sbVert - sbPixl, c.getInterpolatedU(7), c.getInterpolatedV(7));
                }

                if (block == HexBlocks.blockHexoriumSwitchRedGreen || block == HexBlocks.blockHexoriumSwitchWhiteRedGreen)
                    tessellator.setColorOpaque_F(0, darken2, 0);
                else if (block == HexBlocks.blockHexoriumSwitchRedBlue || block == HexBlocks.blockHexoriumSwitchWhiteRedBlue)
                    tessellator.setColorOpaque_F(0, 0, darken2);
                else if (block == HexBlocks.blockHexoriumSwitchRedWhite || block == HexBlocks.blockHexoriumSwitchWhiteRedWhite)
                    tessellator.setColorOpaque_F(darken2, darken2, darken2);
                else if (block == HexBlocks.blockHexoriumSwitchBlueGreen || block == HexBlocks.blockHexoriumSwitchWhiteBlueGreen)
                    tessellator.setColorOpaque_F(0, darken2, 0);

                if (orientation == 1) {
                    tessellator.addVertexWithUV(1 - sbHori, sbFron + sbOffs, 1 - sbVert - sbPixl, c.getInterpolatedU(10), c.getInterpolatedV(7));
                    tessellator.addVertexWithUV(1 - sbHori, sbFron + sbOffs, sbVert + sbPixl, c.getInterpolatedU(10), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(1 - sbHori - sbPixl, sbFron + sbOffs, sbVert + sbPixl, c.getInterpolatedU(9), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(1 - sbHori - sbPixl, sbFron + sbOffs, 1 - sbVert - sbPixl, c.getInterpolatedU(9), c.getInterpolatedV(7));
                }
                else if (orientation == 7) {
                    tessellator.addVertexWithUV(1 - sbVert - sbPixl, sbFron + sbOffs, 1 - sbHori - sbPixl, c.getInterpolatedU(9), c.getInterpolatedV(7));
                    tessellator.addVertexWithUV(sbVert + sbPixl, sbFron + sbOffs, 1 - sbHori - sbPixl, c.getInterpolatedU(9), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(sbVert + sbPixl, sbFron + sbOffs, 1 - sbHori, c.getInterpolatedU(10), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(1 - sbVert - sbPixl, sbFron + sbOffs, 1 - sbHori, c.getInterpolatedU(10), c.getInterpolatedV(7));
                }
                else if (orientation == 2) {
                    tessellator.addVertexWithUV(sbHori + sbPixl, 1 - sbVert - sbPixl, 1 - sbFron - sbOffs, c.getInterpolatedU(9), c.getInterpolatedV(7));
                    tessellator.addVertexWithUV(sbHori + sbPixl, sbVert + sbPixl, 1 - sbFron - sbOffs, c.getInterpolatedU(9), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(sbHori, sbVert + sbPixl, 1 - sbFron - sbOffs, c.getInterpolatedU(10), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(sbHori, 1 - sbVert - sbPixl, 1 - sbFron - sbOffs, c.getInterpolatedU(10), c.getInterpolatedV(7));
                }
                else if (orientation == 3) {
                    tessellator.addVertexWithUV(1 - sbHori - sbPixl, 1 - sbVert - sbPixl, sbFron + sbOffs, c.getInterpolatedU(9), c.getInterpolatedV(7));
                    tessellator.addVertexWithUV(1 - sbHori - sbPixl, sbVert + sbPixl, sbFron + sbOffs, c.getInterpolatedU(9), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(1 - sbHori, sbVert + sbPixl, sbFron + sbOffs, c.getInterpolatedU(10), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(1 - sbHori, 1 - sbVert - sbPixl, sbFron + sbOffs, c.getInterpolatedU(10), c.getInterpolatedV(7));
                }
                else if (orientation == 4) {
                    tessellator.addVertexWithUV(1 - sbFron - sbOffs, 1 - sbVert - sbPixl, 1 - sbHori - sbPixl, c.getInterpolatedU(9), c.getInterpolatedV(7));
                    tessellator.addVertexWithUV(1 - sbFron - sbOffs, sbVert + sbPixl, 1 - sbHori - sbPixl, c.getInterpolatedU(9), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(1 - sbFron - sbOffs, sbVert + sbPixl, 1 - sbHori, c.getInterpolatedU(10), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(1 - sbFron - sbOffs, 1 - sbVert - sbPixl, 1 - sbHori, c.getInterpolatedU(10), c.getInterpolatedV(7));
                }
                else if (orientation == 5) {
                    tessellator.addVertexWithUV(sbFron + sbOffs, 1 - sbVert - sbPixl, sbHori + sbPixl, c.getInterpolatedU(9), c.getInterpolatedV(7));
                    tessellator.addVertexWithUV(sbFron + sbOffs, sbVert + sbPixl, sbHori + sbPixl, c.getInterpolatedU(9), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(sbFron + sbOffs, sbVert + sbPixl, sbHori, c.getInterpolatedU(10), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(sbFron + sbOffs, 1 - sbVert - sbPixl, sbHori, c.getInterpolatedU(10), c.getInterpolatedV(7));
                }
                else if (orientation == 6) {
                    tessellator.addVertexWithUV(1 - sbVert - sbPixl, 1 - sbFron - sbOffs, 1 - sbHori, c.getInterpolatedU(10), c.getInterpolatedV(7));
                    tessellator.addVertexWithUV(sbVert + sbPixl, 1 - sbFron - sbOffs, 1 - sbHori, c.getInterpolatedU(10), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(sbVert + sbPixl, 1 - sbFron - sbOffs, 1 - sbHori - sbPixl, c.getInterpolatedU(9), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(1 - sbVert - sbPixl, 1 - sbFron - sbOffs, 1 - sbHori - sbPixl, c.getInterpolatedU(9), c.getInterpolatedV(7));
                }
                else {
                    tessellator.addVertexWithUV(1 - sbHori - sbPixl, 1 - sbFron - sbOffs, 1 - sbVert - sbPixl, c.getInterpolatedU(9), c.getInterpolatedV(7));
                    tessellator.addVertexWithUV(1 - sbHori - sbPixl, 1 - sbFron - sbOffs, sbVert + sbPixl, c.getInterpolatedU(9), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(1 - sbHori, 1 - sbFron - sbOffs, sbVert + sbPixl, c.getInterpolatedU(10), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(1 - sbHori, 1 - sbFron - sbOffs, 1 - sbVert - sbPixl, c.getInterpolatedU(10), c.getInterpolatedV(7));
                }
            }
            // Draw button glow.
            else if (block instanceof BlockHexoriumButton) {

                float push;
                float darken;
                if (HexUtils.getMetaBit(BlockHexoriumButton.META_STATE, world, x, y, z)) {
                    darken = HexEnums.MULTIPLIER_DARKEN;
                    push = sbPixl;
                }
                else {
                    darken = 1.0F;
                    push = sbFron;
                }

                if (block == HexBlocks.blockHexoriumButtonRed || block == HexBlocks.blockHexoriumButtonWhiteRed)
                    tessellator.setColorOpaque_F(darken, 0, 0);
                else if (block == HexBlocks.blockHexoriumButtonGreen || block == HexBlocks.blockHexoriumButtonWhiteGreen)
                    tessellator.setColorOpaque_F(0, darken, 0);
                else if (block == HexBlocks.blockHexoriumButtonBlue || block == HexBlocks.blockHexoriumButtonWhiteBlue)
                    tessellator.setColorOpaque_F(0, 0, darken);
                else if (block == HexBlocks.blockHexoriumButtonWhite || block == HexBlocks.blockHexoriumButtonWhiteWhite)
                    tessellator.setColorOpaque_F(darken, darken, darken);

                if (orientation == 1) {
                    tessellator.addVertexWithUV(1 - sbHori - sbPixl, push + sbOffs, 1 - sbVert - sbPixl, c.getInterpolatedU(9), c.getInterpolatedV(7));
                    tessellator.addVertexWithUV(1 - sbHori - sbPixl, push + sbOffs, sbVert + sbPixl, c.getInterpolatedU(9), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(sbHori + sbPixl, push + sbOffs, sbVert + sbPixl, c.getInterpolatedU(7), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(sbHori + sbPixl, push + sbOffs, 1 - sbVert - sbPixl, c.getInterpolatedU(7), c.getInterpolatedV(7));
                }
                else if (orientation == 2) {
                    tessellator.addVertexWithUV(1 - sbHori - sbPixl, 1 - sbVert - sbPixl, 1 - push - sbOffs, c.getInterpolatedU(7), c.getInterpolatedV(7));
                    tessellator.addVertexWithUV(1 - sbHori - sbPixl, sbVert + sbPixl, 1 - push - sbOffs, c.getInterpolatedU(7), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(sbHori + sbPixl, sbVert + sbPixl, 1 - push - sbOffs, c.getInterpolatedU(9), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(sbHori + sbPixl, 1 - sbVert - sbPixl, 1 - push - sbOffs, c.getInterpolatedU(7), c.getInterpolatedV(7));
                }
                else if (orientation == 3) {
                    tessellator.addVertexWithUV(sbHori + sbPixl, 1 - sbVert - sbPixl, push + sbOffs, c.getInterpolatedU(7), c.getInterpolatedV(7));
                    tessellator.addVertexWithUV(sbHori + sbPixl, sbVert + sbPixl, push + sbOffs, c.getInterpolatedU(7), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(1 - sbHori - sbPixl, sbVert + sbPixl, push + sbOffs, c.getInterpolatedU(9), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(1 - sbHori - sbPixl, 1 - sbVert - sbPixl, push + sbOffs, c.getInterpolatedU(9), c.getInterpolatedV(7));
                }
                else if (orientation == 4) {
                    tessellator.addVertexWithUV(1 - push - sbOffs, 1 - sbVert - sbPixl, sbHori + sbPixl, c.getInterpolatedU(7), c.getInterpolatedV(7));
                    tessellator.addVertexWithUV(1 - push - sbOffs, sbVert + sbPixl, sbHori + sbPixl, c.getInterpolatedU(7), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(1 - push - sbOffs, sbVert + sbPixl, 1 - sbHori - sbPixl, c.getInterpolatedU(9), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(1 - push - sbOffs, 1 - sbVert - sbPixl, 1 - sbHori - sbPixl, c.getInterpolatedU(9), c.getInterpolatedV(7));
                }
                else if (orientation == 5) {
                    tessellator.addVertexWithUV(push + sbOffs, 1 - sbVert - sbPixl, 1 - sbHori - sbPixl, c.getInterpolatedU(7), c.getInterpolatedV(7));
                    tessellator.addVertexWithUV(push + sbOffs, sbVert + sbPixl, 1 - sbHori - sbPixl, c.getInterpolatedU(7), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(push + sbOffs, sbVert + sbPixl, sbHori + sbPixl, c.getInterpolatedU(9), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(push + sbOffs, 1 - sbVert - sbPixl, sbHori + sbPixl, c.getInterpolatedU(9), c.getInterpolatedV(7));
                }
                else {
                    tessellator.addVertexWithUV(sbHori + sbPixl, 1 - push - sbOffs, 1 - sbVert - sbPixl, c.getInterpolatedU(7), c.getInterpolatedV(7));
                    tessellator.addVertexWithUV(sbHori + sbPixl, 1 - push - sbOffs, sbVert + sbPixl, c.getInterpolatedU(7), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(1 - sbHori - sbPixl, 1 - push - sbOffs, sbVert + sbPixl, c.getInterpolatedU(9), c.getInterpolatedV(9));
                    tessellator.addVertexWithUV(1 - sbHori - sbPixl, 1 - push - sbOffs, 1 - sbVert - sbPixl, c.getInterpolatedU(9), c.getInterpolatedV(7));
                }
            }

            tessellator.addTranslation(-x, -y, -z);
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
