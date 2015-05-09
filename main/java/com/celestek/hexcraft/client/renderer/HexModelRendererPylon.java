package com.celestek.hexcraft.client.renderer;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.HexClientProxy;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-14
 */

public class HexModelRendererPylon implements ISimpleBlockRenderingHandler {

    // Variables
    private int renderID;
    private int renderBlockID;
    private int brightness;
    private float opacity;
    private float r = 1F;
    private float g = 1F;
    private float b = 1F;

    // Model constants.
    public static float yMonoBot = 0.125F;
    public static float yMonoTop = 0.875F;

    public static float xMonoA = 0.1874F;
    public static float xMonoB = 0.3437F;
    public static float xMonoC = 0.6563F;
    public static float xMonoD = 0.8126F;
    public static float xMonoE = 0.6563F;
    public static float xMonoF = 0.3437F;

    public static float zMonoA = 0.5F;
    public static float zMonoB = 0.7707F;
    public static float zMonoC = 0.7707F;
    public static float zMonoD = 0.5F;
    public static float zMonoE = 0.2292F;
    public static float zMonoF = 0.2292F;


    public static float yBaseBot = 0F;

    public static float xBaseMin = 0F;
    public static float xBaseMax = 1F;
    
    public static float zBaseMin = 0F;
    public static float zBaseMax = 1F;

    public static float xBaseMidMin = 0.125F;
    public static float xBaseMidMax = 0.875F;
    
    public static float zBaseMidMin = 0.125F;
    public static float zBaseMidMax = 0.875F;


    public static float yRingTop = 0.25F;

    public static float xRingA = 0.125F;
    public static float xRingB = 0.3125F;
    public static float xRingC = 0.6875F;
    public static float xRingD = 0.875F;
    public static float xRingE = 0.6875F;
    public static float xRingF = 0.3125F;

    public static float zRingA = 0.5F;
    public static float zRingB = 0.8248F;
    public static float zRingC = 0.8248F;
    public static float zRingD = 0.5F;
    public static float zRingE = 0.1752F;
    public static float zRingF = 0.1752F;
    

    private float uMonoTopA = 0.3F;
    private float vMonoTopA = 4.5F;
    private float uMonoTopB = 2.6F;
    private float vMonoTopB = 0.25F;
    private float uMonoTopC = 7.4F;
    private float vMonoTopC = 0.25F;
    private float uMonoTopD = 9.7F;
    private float vMonoTopD = 4.5F;
    private float uMonoTopE = 7.4F;
    private float vMonoTopE = 8.75F;
    private float uMonoTopF = 2.6F;
    private float vMonoTopF = 8.75F;

    private float uMonoSide = 11.25F;
    private float UMonoSide = 15.75F;
    private float vMonoSide = 0.25F;
    private float VMonoSide = 11.75F;



    private float uBaseTop = 2F;
    private float vBaseTop = 2F;
    private float UBaseTop = 14F;
    private float VBaseTop = 14F;

    private float uBaseA1 = 0F;
    private float vBaseA1 = 0F;
    private float uBaseA2 = 16F;
    private float vBaseA2 = 0F;
    private float uBaseA3 = 14F;
    private float vBaseA3 = 3F;
    private float uBaseA4 = 2F;
    private float vBaseA4 = 3F;

    private float uBaseB1 = 0F;
    private float vBaseB1 = 3F;
    private float uBaseB2 = 16F;
    private float vBaseB2 = 3F;
    private float uBaseB3 = 14F;
    private float vBaseB3 = 6F;
    private float uBaseB4 = 2F;
    private float vBaseB4 = 6F;


    private float uRingA1 = 0F;
    private float vRingA1 = 6.5F;
    private float uRingA2 = 6F;
    private float vRingA2 = 6.5F;
    private float uRingA3 = 5.5F;
    private float vRingA3 = 9F;
    private float uRingA4 = 0.5F;
    private float vRingA4 = 9F;

    private float uRingB1 = 8F;
    private float vRingB1 = 6.5F;
    private float uRingB2 = 14F;
    private float vRingB2 = 6.5F;
    private float uRingB3 = 13.5F;
    private float vRingB3 = 9F;
    private float uRingB4 = 8.5F;
    private float vRingB4 = 9F;

    private float uRingC1 = 0F;
    private float vRingC1 = 11F;
    private float uRingC2 = 6F;
    private float vRingC2 = 11F;
    private float uRingC3 = 5.5F;
    private float vRingC3 = 13.5F;
    private float uRingC4 = 0.5F;
    private float vRingC4 = 13.5F;

    private float uRingD1 = 0.5F;
    private float vRingD1 = 9F;
    private float uRingD2 = 5.5F;
    private float vRingD2 = 9F;
    private float uRingD3 = 5.5F;
    private float vRingD3 = 11F;
    private float uRingD4 = 0.5F;
    private float vRingD4 = 11F;

    private float uRingE1 = 8.5F;
    private float vRingE1 = 9F;
    private float uRingE2 = 13.5F;
    private float vRingE2 = 9F;
    private float uRingE3 = 13.5F;
    private float vRingE3 = 11F;
    private float uRingE4 = 8.5F;
    private float vRingE4 = 11F;

    private float uRingF1 = 0.5F;
    private float vRingF1 = 13.5F;
    private float uRingF2 = 5.5F;
    private float vRingF2 = 13.5F;
    private float uRingF3 = 5.5F;
    private float vRingF3 = 15.5F;
    private float uRingF4 = 0.5F;
    private float vRingF4 = 15.5F;

    private float off = 0.01F;

    /**
     * Constructor for custom monolith rendering.
     * @param renderID Minecraft's internal ID of a certain block.
     * @param brightness Intensity of the monolith glow.
     * @param opacity Opacity of the monolith.
     */
    public HexModelRendererPylon(int renderID, int brightness, float opacity)
    {
        // Save the current HexCraft block ID.
        this.renderBlockID = HexCraft.idCounter;

        // Load the constructor parameters.
        this.renderID = renderID;
        this.brightness = brightness;
        this.opacity = opacity;

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
        tessellator.startDrawingQuads();

        // Set up brightness and color.
        tessellator.setBrightness(brightness);
        tessellator.setColorRGBA_F(r, g, b, opacity);

        // Prepare the icon.
        IIcon c = block.getIcon(6, 0);
        double u = c.getInterpolatedU(uMonoSide);
        double U = c.getInterpolatedU(UMonoSide);
        double v = c.getInterpolatedV(vMonoSide);
        double V = c.getInterpolatedV(VMonoSide);

        // Top Face
        tessellator.setNormal(xMonoB, yMonoTop, zMonoB);
        tessellator.addVertexWithUV(xMonoB, yMonoTop, zMonoB, c.getInterpolatedU(uMonoTopB), c.getInterpolatedV(vMonoTopB)); // B
        tessellator.addVertexWithUV(xMonoC, yMonoTop, zMonoC, c.getInterpolatedU(uMonoTopC), c.getInterpolatedV(vMonoTopC)); // C
        tessellator.addVertexWithUV(xMonoD, yMonoTop, zMonoD, c.getInterpolatedU(uMonoTopD), c.getInterpolatedV(vMonoTopD)); // D
        tessellator.addVertexWithUV(xMonoA, yMonoTop, zMonoA, c.getInterpolatedU(uMonoTopA), c.getInterpolatedV(vMonoTopA)); // A

        tessellator.addVertexWithUV(xMonoA, yMonoTop, zMonoA, c.getInterpolatedU(uMonoTopA), c.getInterpolatedV(vMonoTopA)); // A
        tessellator.addVertexWithUV(xMonoD, yMonoTop, zMonoD, c.getInterpolatedU(uMonoTopD), c.getInterpolatedV(vMonoTopD)); // D
        tessellator.addVertexWithUV(xMonoE, yMonoTop, zMonoE, c.getInterpolatedU(uMonoTopE), c.getInterpolatedV(vMonoTopE)); // E
        tessellator.addVertexWithUV(xMonoF, yMonoTop, zMonoF, c.getInterpolatedU(uMonoTopF), c.getInterpolatedV(vMonoTopF)); // F

        // Side Faces
        tessellator.addVertexWithUV(xMonoF, yMonoTop, zMonoF, u, v); // F
        tessellator.addVertexWithUV(xMonoE, yMonoTop, zMonoE, U, v); // E
        tessellator.addVertexWithUV(xMonoE, yMonoBot, zMonoE, U, V); // E'
        tessellator.addVertexWithUV(xMonoF, yMonoBot, zMonoF, u, V); // F'

        tessellator.addVertexWithUV(xMonoE, yMonoTop, zMonoE, u, v); // E
        tessellator.addVertexWithUV(xMonoD, yMonoTop, zMonoD, U, v); // D
        tessellator.addVertexWithUV(xMonoD, yMonoBot, zMonoD, U, V); // D'
        tessellator.addVertexWithUV(xMonoE, yMonoBot, zMonoE, u, V); // E'

        tessellator.addVertexWithUV(xMonoD, yMonoTop, zMonoD, u, v); // D
        tessellator.addVertexWithUV(xMonoC, yMonoTop, zMonoC, U, v); // C
        tessellator.addVertexWithUV(xMonoC, yMonoBot, zMonoC, U, V); // C'
        tessellator.addVertexWithUV(xMonoD, yMonoBot, zMonoD, u, V); // D'

        tessellator.addVertexWithUV(xMonoC, yMonoTop, zMonoC, u, v); // C
        tessellator.addVertexWithUV(xMonoB, yMonoTop, zMonoB, U, v); // B
        tessellator.addVertexWithUV(xMonoB, yMonoBot, zMonoB, U, V); // B'
        tessellator.addVertexWithUV(xMonoC, yMonoBot, zMonoC, u, V); // C'

        tessellator.addVertexWithUV(xMonoB, yMonoTop, zMonoB, u, v); // B
        tessellator.addVertexWithUV(xMonoA, yMonoTop, zMonoA, U, v); // A
        tessellator.addVertexWithUV(xMonoA, yMonoBot, zMonoA, U, V); // A'
        tessellator.addVertexWithUV(xMonoB, yMonoBot, zMonoB, u, V); // B'

        tessellator.addVertexWithUV(xMonoA, yMonoTop, zMonoA, u, v); // A
        tessellator.addVertexWithUV(xMonoF, yMonoTop, zMonoF, U, v); // F
        tessellator.addVertexWithUV(xMonoF, yMonoBot, zMonoF, U, V); // F'
        tessellator.addVertexWithUV(xMonoA, yMonoBot, zMonoA, u, V); // A'

        // Finish drawing.
        tessellator.draw();
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

        // Prepare the Tessellator.
        Tessellator tessellator = Tessellator.instance;

        // Check if this is the second (transparent) render pass, if it is...
        if(HexClientProxy.renderPass[renderBlockID] == 1) {

            // More tessellator preparation.
            tessellator.addTranslation(x, y, z);

            /* Monolith */
            // Set up brightness and color.
            tessellator.setBrightness(brightness);
            tessellator.setColorRGBA_F(r, g, b, opacity);

            // Prepare the icon.
            IIcon c = block.getIcon(6, 0);
            double u = c.getInterpolatedU(uMonoSide);
            double U = c.getInterpolatedU(UMonoSide);
            double v = c.getInterpolatedV(vMonoSide);
            double V = c.getInterpolatedV(VMonoSide);

            // Top Face
            tessellator.addVertexWithUV(xMonoB, yMonoTop, zMonoB, c.getInterpolatedU(uMonoTopB), c.getInterpolatedV(vMonoTopB)); // B
            tessellator.addVertexWithUV(xMonoC, yMonoTop, zMonoC, c.getInterpolatedU(uMonoTopC), c.getInterpolatedV(vMonoTopC)); // C
            tessellator.addVertexWithUV(xMonoD, yMonoTop, zMonoD, c.getInterpolatedU(uMonoTopD), c.getInterpolatedV(vMonoTopD)); // D
            tessellator.addVertexWithUV(xMonoA, yMonoTop, zMonoA, c.getInterpolatedU(uMonoTopA), c.getInterpolatedV(vMonoTopA)); // A

            tessellator.addVertexWithUV(xMonoA, yMonoTop, zMonoA, c.getInterpolatedU(uMonoTopA), c.getInterpolatedV(vMonoTopA)); // A
            tessellator.addVertexWithUV(xMonoD, yMonoTop, zMonoD, c.getInterpolatedU(uMonoTopD), c.getInterpolatedV(vMonoTopD)); // D
            tessellator.addVertexWithUV(xMonoE, yMonoTop, zMonoE, c.getInterpolatedU(uMonoTopE), c.getInterpolatedV(vMonoTopE)); // E
            tessellator.addVertexWithUV(xMonoF, yMonoTop, zMonoF, c.getInterpolatedU(uMonoTopF), c.getInterpolatedV(vMonoTopF)); // F

            // Side Faces
            tessellator.addVertexWithUV(xMonoF, yMonoTop, zMonoF, u, v); // F
            tessellator.addVertexWithUV(xMonoE, yMonoTop, zMonoE, U, v); // E
            tessellator.addVertexWithUV(xMonoE, yMonoBot, zMonoE, U, V); // E'
            tessellator.addVertexWithUV(xMonoF, yMonoBot, zMonoF, u, V); // F'

            tessellator.addVertexWithUV(xMonoE, yMonoTop, zMonoE, u, v); // E
            tessellator.addVertexWithUV(xMonoD, yMonoTop, zMonoD, U, v); // D
            tessellator.addVertexWithUV(xMonoD, yMonoBot, zMonoD, U, V); // D'
            tessellator.addVertexWithUV(xMonoE, yMonoBot, zMonoE, u, V); // E'

            tessellator.addVertexWithUV(xMonoD, yMonoTop, zMonoD, u, v); // D
            tessellator.addVertexWithUV(xMonoC, yMonoTop, zMonoC, U, v); // C
            tessellator.addVertexWithUV(xMonoC, yMonoBot, zMonoC, U, V); // C'
            tessellator.addVertexWithUV(xMonoD, yMonoBot, zMonoD, u, V); // D'

            tessellator.addVertexWithUV(xMonoC, yMonoTop, zMonoC, u, v); // C
            tessellator.addVertexWithUV(xMonoB, yMonoTop, zMonoB, U, v); // B
            tessellator.addVertexWithUV(xMonoB, yMonoBot, zMonoB, U, V); // B'
            tessellator.addVertexWithUV(xMonoC, yMonoBot, zMonoC, u, V); // C'

            tessellator.addVertexWithUV(xMonoB, yMonoTop, zMonoB, u, v); // B
            tessellator.addVertexWithUV(xMonoA, yMonoTop, zMonoA, U, v); // A
            tessellator.addVertexWithUV(xMonoA, yMonoBot, zMonoA, U, V); // A'
            tessellator.addVertexWithUV(xMonoB, yMonoBot, zMonoB, u, V); // B'

            tessellator.addVertexWithUV(xMonoA, yMonoTop, zMonoA, u, v); // A
            tessellator.addVertexWithUV(xMonoF, yMonoTop, zMonoF, U, v); // F
            tessellator.addVertexWithUV(xMonoF, yMonoBot, zMonoF, U, V); // F'
            tessellator.addVertexWithUV(xMonoA, yMonoBot, zMonoA, u, V); // A'


            tessellator.addTranslation(-x, -y, -z);
        }
        // If this is the first (opaque) render pass...
        else {
            // More tessellator preparation.
            tessellator.addTranslation(x, y, z);

            /* Base */
            // Set up brightness and color.
            tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
            tessellator.setColorOpaque_F(1, 1, 1);

            // Prepare the icon.
            IIcon c = block.getIcon(0, 0);

            // Base Faces
            tessellator.addVertexWithUV(xBaseMin,    yBaseBot, zBaseMax,    c.getInterpolatedU(uBaseA1), c.getInterpolatedV(vBaseA1)); // A
            tessellator.addVertexWithUV(xBaseMax,    yBaseBot, zBaseMax,    c.getInterpolatedU(uBaseA2), c.getInterpolatedV(vBaseA2)); // B
            tessellator.addVertexWithUV(xBaseMidMax, yMonoBot, zBaseMidMax, c.getInterpolatedU(uBaseA3), c.getInterpolatedV(vBaseA3)); // B'
            tessellator.addVertexWithUV(xBaseMidMin, yMonoBot, zBaseMidMax, c.getInterpolatedU(uBaseA4), c.getInterpolatedV(vBaseA4)); // A'

            tessellator.addVertexWithUV(xBaseMax,    yBaseBot, zBaseMax,    c.getInterpolatedU(uBaseB1), c.getInterpolatedV(vBaseB1)); // B
            tessellator.addVertexWithUV(xBaseMax,    yBaseBot, zBaseMin,    c.getInterpolatedU(uBaseB2), c.getInterpolatedV(vBaseB2)); // C
            tessellator.addVertexWithUV(xBaseMidMax, yMonoBot, zBaseMidMin, c.getInterpolatedU(uBaseB3), c.getInterpolatedV(vBaseB3)); // C'
            tessellator.addVertexWithUV(xBaseMidMax, yMonoBot, zBaseMidMax, c.getInterpolatedU(uBaseB4), c.getInterpolatedV(vBaseB4)); // B'

            tessellator.addVertexWithUV(xBaseMax,    yBaseBot, zBaseMin,    c.getInterpolatedU(uBaseA1), c.getInterpolatedV(vBaseA1)); // C
            tessellator.addVertexWithUV(xBaseMin,    yBaseBot, zBaseMin,    c.getInterpolatedU(uBaseA2), c.getInterpolatedV(vBaseA2)); // D
            tessellator.addVertexWithUV(xBaseMidMin, yMonoBot, zBaseMidMin, c.getInterpolatedU(uBaseA3), c.getInterpolatedV(vBaseA3)); // D'
            tessellator.addVertexWithUV(xBaseMidMax, yMonoBot, zBaseMidMin, c.getInterpolatedU(uBaseA4), c.getInterpolatedV(vBaseA4)); // C'

            tessellator.addVertexWithUV(xBaseMin,    yBaseBot, zBaseMin,    c.getInterpolatedU(uBaseB1), c.getInterpolatedV(vBaseB1)); // D
            tessellator.addVertexWithUV(xBaseMin,    yBaseBot, zBaseMax,    c.getInterpolatedU(uBaseB2), c.getInterpolatedV(vBaseB2)); // A
            tessellator.addVertexWithUV(xBaseMidMin, yMonoBot, zBaseMidMax, c.getInterpolatedU(uBaseB3), c.getInterpolatedV(vBaseB3)); // A'
            tessellator.addVertexWithUV(xBaseMidMin, yMonoBot, zBaseMidMin, c.getInterpolatedU(uBaseB4), c.getInterpolatedV(vBaseB4)); // D'

            // Ring Outer Faces
            tessellator.addVertexWithUV(xRingA, yMonoBot, zRingA, c.getInterpolatedU(uRingA1), c.getInterpolatedV(vRingA1)); // A
            tessellator.addVertexWithUV(xRingB, yMonoBot, zRingB, c.getInterpolatedU(uRingA2), c.getInterpolatedV(vRingA2)); // B
            tessellator.addVertexWithUV(xMonoB, yRingTop, zMonoB, c.getInterpolatedU(uRingA3), c.getInterpolatedV(vRingA3)); // B'
            tessellator.addVertexWithUV(xMonoA, yRingTop, zMonoA, c.getInterpolatedU(uRingA4), c.getInterpolatedV(vRingA4)); // A'

            tessellator.addVertexWithUV(xRingB, yMonoBot, zRingB, c.getInterpolatedU(uRingB1), c.getInterpolatedV(vRingB1)); // B
            tessellator.addVertexWithUV(xRingC, yMonoBot, zRingC, c.getInterpolatedU(uRingB2), c.getInterpolatedV(vRingB2)); // C
            tessellator.addVertexWithUV(xMonoC, yRingTop, zMonoC, c.getInterpolatedU(uRingB3), c.getInterpolatedV(vRingB3)); // C'
            tessellator.addVertexWithUV(xMonoB, yRingTop, zMonoB, c.getInterpolatedU(uRingB4), c.getInterpolatedV(vRingB4)); // B'

            tessellator.addVertexWithUV(xRingC, yMonoBot, zRingC, c.getInterpolatedU(uRingC1), c.getInterpolatedV(vRingC1)); // C
            tessellator.addVertexWithUV(xRingD, yMonoBot, zRingD, c.getInterpolatedU(uRingC2), c.getInterpolatedV(vRingC2)); // D
            tessellator.addVertexWithUV(xMonoD, yRingTop, zMonoD, c.getInterpolatedU(uRingC3), c.getInterpolatedV(vRingC3)); // D'
            tessellator.addVertexWithUV(xMonoC, yRingTop, zMonoC, c.getInterpolatedU(uRingC4), c.getInterpolatedV(vRingC4)); // C'

            tessellator.addVertexWithUV(xRingD, yMonoBot, zRingD, c.getInterpolatedU(uRingA1), c.getInterpolatedV(vRingA1)); // D
            tessellator.addVertexWithUV(xRingE, yMonoBot, zRingE, c.getInterpolatedU(uRingA2), c.getInterpolatedV(vRingA2)); // E
            tessellator.addVertexWithUV(xMonoE, yRingTop, zMonoE, c.getInterpolatedU(uRingA3), c.getInterpolatedV(vRingA3)); // E'
            tessellator.addVertexWithUV(xMonoD, yRingTop, zMonoD, c.getInterpolatedU(uRingA4), c.getInterpolatedV(vRingA4)); // D'

            tessellator.addVertexWithUV(xRingE, yMonoBot, zRingE, c.getInterpolatedU(uRingB1), c.getInterpolatedV(vRingB1)); // E
            tessellator.addVertexWithUV(xRingF, yMonoBot, zRingF, c.getInterpolatedU(uRingB2), c.getInterpolatedV(vRingB2)); // F
            tessellator.addVertexWithUV(xMonoF, yRingTop, zMonoF, c.getInterpolatedU(uRingB3), c.getInterpolatedV(vRingB3)); // F'
            tessellator.addVertexWithUV(xMonoE, yRingTop, zMonoE, c.getInterpolatedU(uRingB4), c.getInterpolatedV(vRingB4)); // E'

            tessellator.addVertexWithUV(xRingF, yMonoBot, zRingF, c.getInterpolatedU(uRingC1), c.getInterpolatedV(vRingC1)); // F
            tessellator.addVertexWithUV(xRingA, yMonoBot, zRingA, c.getInterpolatedU(uRingC2), c.getInterpolatedV(vRingC2)); // A
            tessellator.addVertexWithUV(xMonoA, yRingTop, zMonoA, c.getInterpolatedU(uRingC3), c.getInterpolatedV(vRingC3)); // A'
            tessellator.addVertexWithUV(xMonoF, yRingTop, zMonoF, c.getInterpolatedU(uRingC4), c.getInterpolatedV(vRingC4)); // F'

            // Ring Inner Faces
            tessellator.addVertexWithUV(xMonoA, yRingTop, zMonoA, c.getInterpolatedU(uRingD1), c.getInterpolatedV(vRingD1)); // A'
            tessellator.addVertexWithUV(xMonoB, yRingTop, zMonoB, c.getInterpolatedU(uRingD2), c.getInterpolatedV(vRingD2)); // B'
            tessellator.addVertexWithUV(xMonoB, yMonoBot, zMonoB, c.getInterpolatedU(uRingD3), c.getInterpolatedV(vRingD3)); // B''
            tessellator.addVertexWithUV(xMonoA, yMonoBot, zMonoA, c.getInterpolatedU(uRingD4), c.getInterpolatedV(vRingD4)); // A''

            tessellator.addVertexWithUV(xMonoB, yRingTop, zMonoB, c.getInterpolatedU(uRingE1), c.getInterpolatedV(vRingE1)); // B'
            tessellator.addVertexWithUV(xMonoC, yRingTop, zMonoC, c.getInterpolatedU(uRingE2), c.getInterpolatedV(vRingE2)); // C'
            tessellator.addVertexWithUV(xMonoC, yMonoBot, zMonoC, c.getInterpolatedU(uRingE3), c.getInterpolatedV(vRingE3)); // C''
            tessellator.addVertexWithUV(xMonoB, yMonoBot, zMonoB, c.getInterpolatedU(uRingE4), c.getInterpolatedV(vRingE4)); // B''

            tessellator.addVertexWithUV(xMonoC, yRingTop, zMonoC, c.getInterpolatedU(uRingF1), c.getInterpolatedV(vRingF1)); // C'
            tessellator.addVertexWithUV(xMonoD, yRingTop, zMonoD, c.getInterpolatedU(uRingF2), c.getInterpolatedV(vRingF2)); // D'
            tessellator.addVertexWithUV(xMonoD, yMonoBot, zMonoD, c.getInterpolatedU(uRingF3), c.getInterpolatedV(vRingF3)); // D''
            tessellator.addVertexWithUV(xMonoC, yMonoBot, zMonoC, c.getInterpolatedU(uRingF4), c.getInterpolatedV(vRingF4)); // C''

            tessellator.addVertexWithUV(xMonoD, yRingTop, zMonoD, c.getInterpolatedU(uRingD1), c.getInterpolatedV(vRingD1)); // D'
            tessellator.addVertexWithUV(xMonoE, yRingTop, zMonoE, c.getInterpolatedU(uRingD2), c.getInterpolatedV(vRingD2)); // E'
            tessellator.addVertexWithUV(xMonoE, yMonoBot, zMonoE, c.getInterpolatedU(uRingD3), c.getInterpolatedV(vRingD3)); // E''
            tessellator.addVertexWithUV(xMonoD, yMonoBot, zMonoD, c.getInterpolatedU(uRingD4), c.getInterpolatedV(vRingD4)); // D''

            tessellator.addVertexWithUV(xMonoE, yRingTop, zMonoE, c.getInterpolatedU(uRingE1), c.getInterpolatedV(vRingE1)); // E'
            tessellator.addVertexWithUV(xMonoF, yRingTop, zMonoF, c.getInterpolatedU(uRingE2), c.getInterpolatedV(vRingE2)); // F'
            tessellator.addVertexWithUV(xMonoF, yMonoBot, zMonoF, c.getInterpolatedU(uRingE3), c.getInterpolatedV(vRingE3)); // F''
            tessellator.addVertexWithUV(xMonoE, yMonoBot, zMonoE, c.getInterpolatedU(uRingE4), c.getInterpolatedV(vRingE4)); // E''

            tessellator.addVertexWithUV(xMonoF, yRingTop, zMonoF, c.getInterpolatedU(uRingF1), c.getInterpolatedV(vRingF1)); // F'
            tessellator.addVertexWithUV(xMonoA, yRingTop, zMonoA, c.getInterpolatedU(uRingF2), c.getInterpolatedV(vRingF2)); // A'
            tessellator.addVertexWithUV(xMonoA, yMonoBot, zMonoA, c.getInterpolatedU(uRingF3), c.getInterpolatedV(vRingF3)); // A''
            tessellator.addVertexWithUV(xMonoF, yMonoBot, zMonoF, c.getInterpolatedU(uRingF4), c.getInterpolatedV(vRingF4)); // F''

            c = block.getIcon(8, 0);
            double u = c.getInterpolatedU(uBaseTop);
            double U = c.getInterpolatedU(UBaseTop);
            double v = c.getInterpolatedV(vBaseTop);
            double V = c.getInterpolatedV(VBaseTop);

            tessellator.addVertexWithUV(xBaseMidMin, yMonoBot, zBaseMidMax, u, v); // A'
            tessellator.addVertexWithUV(xBaseMidMax, yMonoBot, zBaseMidMax, U, v); // B'
            tessellator.addVertexWithUV(xBaseMidMax, yMonoBot, zBaseMidMin, U, V); // C'
            tessellator.addVertexWithUV(xBaseMidMin, yMonoBot, zBaseMidMin, u, V); // D'



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
