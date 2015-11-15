package com.celestek.hexcraft.client.renderer;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.BlockEnergyPylon;
import com.celestek.hexcraft.client.HexClientProxy;
import com.celestek.hexcraft.tileentity.TileEnergyPylon;
import com.celestek.hexcraft.util.HexColors;
import com.celestek.hexcraft.util.HexPylon;
import com.celestek.hexcraft.util.HexUtils;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.common.Loader;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.7.0
 */

public class HexModelRendererPylon implements ISimpleBlockRenderingHandler {

    // Model constants.
    public static final float yMonoBot = 0.125F;
    public static final float yMonoTop = 0.875F;
    
    public static final float yBaseBot = 0F;

    public static final float xBaseMin = 0F;
    public static final float xBaseMax = 1F;

    public static final float zBaseMin = 0F;
    public static final float zBaseMax = 1F;
    
    private static final float beamRadius = 0.05F;

    private static final float invOffset = 0.4F;

    private static final float xMonoA = 0.1874F;
    private static final float xMonoB = 0.3437F;
    private static final float xMonoC = 0.6563F;
    private static final float xMonoD = 0.8126F;
    private static final float xMonoE = 0.6563F;
    private static final float xMonoF = 0.3437F;

    private static final float zMonoA = 0.5F;
    private static final float zMonoB = 0.7707F;
    private static final float zMonoC = 0.7707F;
    private static final float zMonoD = 0.5F;
    private static final float zMonoE = 0.2292F;
    private static final float zMonoF = 0.2292F;

    private static final float xPlatMin = 0.125F;
    private static final float xPlatMax = 0.875F;

    private static final float zPlatMin = 0.125F;
    private static final float zPlatMax = 0.875F;

    private static final float yRingTop = 0.25F;

    private static final float xRingA = 0.125F;
    private static final float xRingB = 0.3125F;
    private static final float xRingC = 0.6875F;
    private static final float xRingD = 0.875F;
    private static final float xRingE = 0.6875F;
    private static final float xRingF = 0.3125F;

    private static final float zRingA = 0.5F;
    private static final float zRingB = 0.8248F;
    private static final float zRingC = 0.8248F;
    private static final float zRingD = 0.5F;
    private static final float zRingE = 0.1752F;
    private static final float zRingF = 0.1752F;

    private static final float uMonoTopA = 0.3F;
    private static final float vMonoTopA = 4.5F;
    private static final float uMonoTopB = 2.6F;
    private static final float vMonoTopB = 0.25F;
    private static final float uMonoTopC = 7.4F;
    private static final float vMonoTopC = 0.25F;
    private static final float uMonoTopD = 9.7F;
    private static final float vMonoTopD = 4.5F;
    private static final float uMonoTopE = 7.4F;
    private static final float vMonoTopE = 8.75F;
    private static final float uMonoTopF = 2.6F;
    private static final float vMonoTopF = 8.75F;

    private static final float uMonoSide = 11.25F;
    private static final float UMonoSide = 15.75F;
    private static final float vMonoSide = 0.25F;
    private static final float VMonoSide = 11.75F;

    private static final float uBaseTop = 2F;
    private static final float vBaseTop = 2F;
    private static final float UBaseTop = 14F;
    private static final float VBaseTop = 14F;

    private static final float uBaseA1 = 0F;
    private static final float vBaseA1 = 0F;
    private static final float uBaseA2 = 16F;
    private static final float vBaseA2 = 0F;
    private static final float uBaseA3 = 14F;
    private static final float vBaseA3 = 3F;
    private static final float uBaseA4 = 2F;
    private static final float vBaseA4 = 3F;

    private static final float uBaseB1 = 0F;
    private static final float vBaseB1 = 3F;
    private static final float uBaseB2 = 16F;
    private static final float vBaseB2 = 3F;
    private static final float uBaseB3 = 14F;
    private static final float vBaseB3 = 6F;
    private static final float uBaseB4 = 2F;
    private static final float vBaseB4 = 6F;

    private static final float uRingA1 = 0F;
    private static final float vRingA1 = 6.5F;
    private static final float uRingA2 = 6F;
    private static final float vRingA2 = 6.5F;
    private static final float uRingA3 = 5.5F;
    private static final float vRingA3 = 9F;
    private static final float uRingA4 = 0.5F;
    private static final float vRingA4 = 9F;

    private static final float uRingB1 = 8F;
    private static final float vRingB1 = 6.5F;
    private static final float uRingB2 = 14F;
    private static final float vRingB2 = 6.5F;
    private static final float uRingB3 = 13.5F;
    private static final float vRingB3 = 9F;
    private static final float uRingB4 = 8.5F;
    private static final float vRingB4 = 9F;

    private static final float uRingC1 = 0F;
    private static final float vRingC1 = 11F;
    private static final float uRingC2 = 6F;
    private static final float vRingC2 = 11F;
    private static final float uRingC3 = 5.5F;
    private static final float vRingC3 = 13.5F;
    private static final float uRingC4 = 0.5F;
    private static final float vRingC4 = 13.5F;

    private static final float uRingD1 = 0.5F;
    private static final float vRingD1 = 9F;
    private static final float uRingD2 = 5.5F;
    private static final float vRingD2 = 9F;
    private static final float uRingD3 = 5.5F;
    private static final float vRingD3 = 11F;
    private static final float uRingD4 = 0.5F;
    private static final float vRingD4 = 11F;

    private static final float uRingE1 = 8.5F;
    private static final float vRingE1 = 9F;
    private static final float uRingE2 = 13.5F;
    private static final float vRingE2 = 9F;
    private static final float uRingE3 = 13.5F;
    private static final float vRingE3 = 11F;
    private static final float uRingE4 = 8.5F;
    private static final float vRingE4 = 11F;

    private static final float uRingF1 = 0.5F;
    private static final float vRingF1 = 13.5F;
    private static final float uRingF2 = 5.5F;
    private static final float vRingF2 = 13.5F;
    private static final float uRingF3 = 5.5F;
    private static final float vRingF3 = 15.5F;
    private static final float uRingF4 = 0.5F;
    private static final float vRingF4 = 15.5F;

    private static final float yBallTop = 0.5975F;
    private static final float yBallMid = 0.5F;
    private static final float yBallBot = 0.4025F;

    private static final float xBallA1 = 0.37F;
    private static final float xBallB1 = 0.435F;
    private static final float xBallC1 = 0.565F;
    private static final float xBallD1 = 0.63F;
    private static final float xBallE1 = 0.565F;
    private static final float xBallF1 = 0.435F;

    private static final float xBallA2 = 0.435F;
    private static final float xBallB2 = 0.4675F;
    private static final float xBallC2 = 0.5325F;
    private static final float xBallD2 = 0.565F;
    private static final float xBallE2 = 0.5325F;
    private static final float xBallF2 = 0.4675F;

    private static final float zBallA1 = 0.5F;
    private static final float zBallB1 = 0.6126F;
    private static final float zBallC1 = 0.6126F;
    private static final float zBallD1 = 0.5F;
    private static final float zBallE1 = 0.3874F;
    private static final float zBallF1 = 0.3874F;

    private static final float zBallA2 = 0.5F;
    private static final float zBallB2 = 0.5563F;
    private static final float zBallC2 = 0.5563F;
    private static final float zBallD2 = 0.5F;
    private static final float zBallE2 = 0.4437F;
    private static final float zBallF2 = 0.4437F;

    private static final float uBallA = 0F;
    private static final float uBallB = 0.75F;
    private static final float uBallC = 2.25F;
    private static final float uBallD = 4F;
    private static final float uBallE = 2.25F;
    private static final float uBallF = 0.75F;

    private static final float vBallA = 14F;
    private static final float vBallB = 12.25F;
    private static final float vBallC = 12.25F;
    private static final float vBallD = 14F;
    private static final float vBallE = 15.75F;
    private static final float vBallF = 15.75F;

    private static final float uBallG = 4F;
    private static final float uBallH = 8F;
    private static final float uBallI = 7F;
    private static final float uBallJ = 5F;

    private static final float vBallG = 12.25F;
    private static final float vBallH = 12.25F;
    private static final float vBallI = 15.75F;
    private static final float vBallJ = 15.75F;

    // Brightness when pylon is OFF.
    private static final float darkMonolith = 0.25F;

    // Variables
    private int renderID;
    private int renderBlockID;
    private int brightness;
    private float opacity;

    /**
     * Constructor for custom monolith rendering.
     * @param renderID Minecraft's internal ID of a certain block.
     * @param brightness Intensity of the monolith glow.
     * @param opacity Opacity of the monolith.
     */
    public HexModelRendererPylon(int renderID, int brightness, float opacity) {
        // Save the current HexCraft block ID.
        this.renderBlockID = HexCraft.idCounter;

        // Load the constructor parameters.
        this.renderID = renderID;

        if (Loader.isModLoaded("coloredlightscore"))
            this.brightness = HexColors.BRIGHTNESS_CL;
        else
            this.brightness = brightness;

        this.opacity = opacity;

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

        // Start drawing.
        tessellator.startDrawingQuads();

        // Prepare the icon.
        IIcon c = block.getIcon(0, 0);

        // Set up brightness.
        tessellator.setNormal(0F, 1F, 0F);

        // Base Faces
        tessellator.addVertexWithUV(xBaseMin, invOffset+yBaseBot, zBaseMax, c.getInterpolatedU(uBaseA1), c.getInterpolatedV(vBaseA1)); // A
        tessellator.addVertexWithUV(xBaseMax, invOffset+yBaseBot, zBaseMax, c.getInterpolatedU(uBaseA2), c.getInterpolatedV(vBaseA2)); // B
        tessellator.addVertexWithUV(xPlatMax, invOffset+yMonoBot, zPlatMax, c.getInterpolatedU(uBaseA3), c.getInterpolatedV(vBaseA3)); // B'
        tessellator.addVertexWithUV(xPlatMin, invOffset+yMonoBot, zPlatMax, c.getInterpolatedU(uBaseA4), c.getInterpolatedV(vBaseA4)); // A'

        tessellator.addVertexWithUV(xBaseMax, invOffset+yBaseBot, zBaseMax, c.getInterpolatedU(uBaseB1), c.getInterpolatedV(vBaseB1)); // B
        tessellator.addVertexWithUV(xBaseMax, invOffset+yBaseBot, zBaseMin, c.getInterpolatedU(uBaseB2), c.getInterpolatedV(vBaseB2)); // C
        tessellator.addVertexWithUV(xPlatMax, invOffset+yMonoBot, zPlatMin, c.getInterpolatedU(uBaseB3), c.getInterpolatedV(vBaseB3)); // C'
        tessellator.addVertexWithUV(xPlatMax, invOffset+yMonoBot, zPlatMax, c.getInterpolatedU(uBaseB4), c.getInterpolatedV(vBaseB4)); // B'

        tessellator.addVertexWithUV(xBaseMax, invOffset+yBaseBot, zBaseMin, c.getInterpolatedU(uBaseA1), c.getInterpolatedV(vBaseA1)); // C
        tessellator.addVertexWithUV(xBaseMin, invOffset+yBaseBot, zBaseMin, c.getInterpolatedU(uBaseA2), c.getInterpolatedV(vBaseA2)); // D
        tessellator.addVertexWithUV(xPlatMin, invOffset+yMonoBot, zPlatMin, c.getInterpolatedU(uBaseA3), c.getInterpolatedV(vBaseA3)); // D'
        tessellator.addVertexWithUV(xPlatMax, invOffset+yMonoBot, zPlatMin, c.getInterpolatedU(uBaseA4), c.getInterpolatedV(vBaseA4)); // C'

        tessellator.addVertexWithUV(xBaseMin, invOffset+yBaseBot, zBaseMin, c.getInterpolatedU(uBaseB1), c.getInterpolatedV(vBaseB1)); // D
        tessellator.addVertexWithUV(xBaseMin, invOffset+yBaseBot, zBaseMax, c.getInterpolatedU(uBaseB2), c.getInterpolatedV(vBaseB2)); // A
        tessellator.addVertexWithUV(xPlatMin, invOffset+yMonoBot, zPlatMax, c.getInterpolatedU(uBaseB3), c.getInterpolatedV(vBaseB3)); // A'
        tessellator.addVertexWithUV(xPlatMin, invOffset+yMonoBot, zPlatMin, c.getInterpolatedU(uBaseB4), c.getInterpolatedV(vBaseB4)); // D'

        c = block.getIcon(8, 0);
        double u = c.getInterpolatedU(uBaseTop);
        double U = c.getInterpolatedU(UBaseTop);
        double v = c.getInterpolatedV(vBaseTop);
        double V = c.getInterpolatedV(VBaseTop);

        tessellator.addVertexWithUV(xPlatMin, invOffset+yMonoBot, zPlatMax, u, v); // A'
        tessellator.addVertexWithUV(xPlatMax, invOffset+yMonoBot, zPlatMax, U, v); // B'
        tessellator.addVertexWithUV(xPlatMax, invOffset+yMonoBot, zPlatMin, U, V); // C'
        tessellator.addVertexWithUV(xPlatMin, invOffset+yMonoBot, zPlatMin, u, V); // D'

        c = block.getIcon(9, 0);
        u = c.getMinU();
        U = c.getMaxU();
        v = c.getMinV();
        V = c.getMaxV();

        tessellator.addVertexWithUV(xBaseMin, invOffset+yBaseBot, zBaseMin, u, V); // D'
        tessellator.addVertexWithUV(xBaseMax, invOffset+yBaseBot, zBaseMin, U, V); // C'
        tessellator.addVertexWithUV(xBaseMax, invOffset+yBaseBot, zBaseMax, U, v); // B'
        tessellator.addVertexWithUV(xBaseMin, invOffset+yBaseBot, zBaseMax, u, v); // A'

        c = block.getIcon(0, 0);

        // Ring Inner Faces
        tessellator.addVertexWithUV(xMonoA, invOffset+yRingTop, zMonoA, c.getInterpolatedU(uRingD1), c.getInterpolatedV(vRingD1)); // A'
        tessellator.addVertexWithUV(xMonoB, invOffset+yRingTop, zMonoB, c.getInterpolatedU(uRingD2), c.getInterpolatedV(vRingD2)); // B'
        tessellator.addVertexWithUV(xMonoB, invOffset+yMonoBot, zMonoB, c.getInterpolatedU(uRingD3), c.getInterpolatedV(vRingD3)); // B''
        tessellator.addVertexWithUV(xMonoA, invOffset+yMonoBot, zMonoA, c.getInterpolatedU(uRingD4), c.getInterpolatedV(vRingD4)); // A''

        tessellator.addVertexWithUV(xMonoB, invOffset+yRingTop, zMonoB, c.getInterpolatedU(uRingE1), c.getInterpolatedV(vRingE1)); // B'
        tessellator.addVertexWithUV(xMonoC, invOffset+yRingTop, zMonoC, c.getInterpolatedU(uRingE2), c.getInterpolatedV(vRingE2)); // C'
        tessellator.addVertexWithUV(xMonoC, invOffset+yMonoBot, zMonoC, c.getInterpolatedU(uRingE3), c.getInterpolatedV(vRingE3)); // C''
        tessellator.addVertexWithUV(xMonoB, invOffset+yMonoBot, zMonoB, c.getInterpolatedU(uRingE4), c.getInterpolatedV(vRingE4)); // B''

        tessellator.addVertexWithUV(xMonoC, invOffset+yRingTop, zMonoC, c.getInterpolatedU(uRingF1), c.getInterpolatedV(vRingF1)); // C'
        tessellator.addVertexWithUV(xMonoD, invOffset+yRingTop, zMonoD, c.getInterpolatedU(uRingF2), c.getInterpolatedV(vRingF2)); // D'
        tessellator.addVertexWithUV(xMonoD, invOffset+yMonoBot, zMonoD, c.getInterpolatedU(uRingF3), c.getInterpolatedV(vRingF3)); // D''
        tessellator.addVertexWithUV(xMonoC, invOffset+yMonoBot, zMonoC, c.getInterpolatedU(uRingF4), c.getInterpolatedV(vRingF4)); // C''

        tessellator.addVertexWithUV(xMonoD, invOffset+yRingTop, zMonoD, c.getInterpolatedU(uRingD1), c.getInterpolatedV(vRingD1)); // D'
        tessellator.addVertexWithUV(xMonoE, invOffset+yRingTop, zMonoE, c.getInterpolatedU(uRingD2), c.getInterpolatedV(vRingD2)); // E'
        tessellator.addVertexWithUV(xMonoE, invOffset+yMonoBot, zMonoE, c.getInterpolatedU(uRingD3), c.getInterpolatedV(vRingD3)); // E''
        tessellator.addVertexWithUV(xMonoD, invOffset+yMonoBot, zMonoD, c.getInterpolatedU(uRingD4), c.getInterpolatedV(vRingD4)); // D''

        tessellator.addVertexWithUV(xMonoE, invOffset+yRingTop, zMonoE, c.getInterpolatedU(uRingE1), c.getInterpolatedV(vRingE1)); // E'
        tessellator.addVertexWithUV(xMonoF, invOffset+yRingTop, zMonoF, c.getInterpolatedU(uRingE2), c.getInterpolatedV(vRingE2)); // F'
        tessellator.addVertexWithUV(xMonoF, invOffset+yMonoBot, zMonoF, c.getInterpolatedU(uRingE3), c.getInterpolatedV(vRingE3)); // F''
        tessellator.addVertexWithUV(xMonoE, invOffset+yMonoBot, zMonoE, c.getInterpolatedU(uRingE4), c.getInterpolatedV(vRingE4)); // E''

        tessellator.addVertexWithUV(xMonoF, invOffset+yRingTop, zMonoF, c.getInterpolatedU(uRingF1), c.getInterpolatedV(vRingF1)); // F'
        tessellator.addVertexWithUV(xMonoA, invOffset+yRingTop, zMonoA, c.getInterpolatedU(uRingF2), c.getInterpolatedV(vRingF2)); // A'
        tessellator.addVertexWithUV(xMonoA, invOffset+yMonoBot, zMonoA, c.getInterpolatedU(uRingF3), c.getInterpolatedV(vRingF3)); // A''
        tessellator.addVertexWithUV(xMonoF, invOffset+yMonoBot, zMonoF, c.getInterpolatedU(uRingF4), c.getInterpolatedV(vRingF4)); // F''

        // Ring Outer Faces
        tessellator.addVertexWithUV(xRingA, invOffset+yMonoBot, zRingA, c.getInterpolatedU(uRingA1), c.getInterpolatedV(vRingA1)); // A
        tessellator.addVertexWithUV(xRingB, invOffset+yMonoBot, zRingB, c.getInterpolatedU(uRingA2), c.getInterpolatedV(vRingA2)); // B
        tessellator.addVertexWithUV(xMonoB, invOffset+yRingTop, zMonoB, c.getInterpolatedU(uRingA3), c.getInterpolatedV(vRingA3)); // B'
        tessellator.addVertexWithUV(xMonoA, invOffset+yRingTop, zMonoA, c.getInterpolatedU(uRingA4), c.getInterpolatedV(vRingA4)); // A'

        tessellator.addVertexWithUV(xRingB, invOffset+yMonoBot, zRingB, c.getInterpolatedU(uRingB1), c.getInterpolatedV(vRingB1)); // B
        tessellator.addVertexWithUV(xRingC, invOffset+yMonoBot, zRingC, c.getInterpolatedU(uRingB2), c.getInterpolatedV(vRingB2)); // C
        tessellator.addVertexWithUV(xMonoC, invOffset+yRingTop, zMonoC, c.getInterpolatedU(uRingB3), c.getInterpolatedV(vRingB3)); // C'
        tessellator.addVertexWithUV(xMonoB, invOffset+yRingTop, zMonoB, c.getInterpolatedU(uRingB4), c.getInterpolatedV(vRingB4)); // B'

        tessellator.addVertexWithUV(xRingC, invOffset+yMonoBot, zRingC, c.getInterpolatedU(uRingC1), c.getInterpolatedV(vRingC1)); // C
        tessellator.addVertexWithUV(xRingD, invOffset+yMonoBot, zRingD, c.getInterpolatedU(uRingC2), c.getInterpolatedV(vRingC2)); // D
        tessellator.addVertexWithUV(xMonoD, invOffset+yRingTop, zMonoD, c.getInterpolatedU(uRingC3), c.getInterpolatedV(vRingC3)); // D'
        tessellator.addVertexWithUV(xMonoC, invOffset+yRingTop, zMonoC, c.getInterpolatedU(uRingC4), c.getInterpolatedV(vRingC4)); // C'

        tessellator.addVertexWithUV(xRingD, invOffset+yMonoBot, zRingD, c.getInterpolatedU(uRingA1), c.getInterpolatedV(vRingA1)); // D
        tessellator.addVertexWithUV(xRingE, invOffset+yMonoBot, zRingE, c.getInterpolatedU(uRingA2), c.getInterpolatedV(vRingA2)); // E
        tessellator.addVertexWithUV(xMonoE, invOffset+yRingTop, zMonoE, c.getInterpolatedU(uRingA3), c.getInterpolatedV(vRingA3)); // E'
        tessellator.addVertexWithUV(xMonoD, invOffset+yRingTop, zMonoD, c.getInterpolatedU(uRingA4), c.getInterpolatedV(vRingA4)); // D'

        tessellator.addVertexWithUV(xRingE, invOffset+yMonoBot, zRingE, c.getInterpolatedU(uRingB1), c.getInterpolatedV(vRingB1)); // E
        tessellator.addVertexWithUV(xRingF, invOffset+yMonoBot, zRingF, c.getInterpolatedU(uRingB2), c.getInterpolatedV(vRingB2)); // F
        tessellator.addVertexWithUV(xMonoF, invOffset+yRingTop, zMonoF, c.getInterpolatedU(uRingB3), c.getInterpolatedV(vRingB3)); // F'
        tessellator.addVertexWithUV(xMonoE, invOffset+yRingTop, zMonoE, c.getInterpolatedU(uRingB4), c.getInterpolatedV(vRingB4)); // E'

        tessellator.addVertexWithUV(xRingF, invOffset+yMonoBot, zRingF, c.getInterpolatedU(uRingC1), c.getInterpolatedV(vRingC1)); // F
        tessellator.addVertexWithUV(xRingA, invOffset+yMonoBot, zRingA, c.getInterpolatedU(uRingC2), c.getInterpolatedV(vRingC2)); // A
        tessellator.addVertexWithUV(xMonoA, invOffset+yRingTop, zMonoA, c.getInterpolatedU(uRingC3), c.getInterpolatedV(vRingC3)); // A'
        tessellator.addVertexWithUV(xMonoF, invOffset + yRingTop, zMonoF, c.getInterpolatedU(uRingC4), c.getInterpolatedV(vRingC4)); // F'

        // Finish drawing.
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
        int orientation = HexUtils.getMetaBitTriInt(
                BlockEnergyPylon.META_ORIENTATION_0,
                BlockEnergyPylon.META_ORIENTATION_1,
                BlockEnergyPylon.META_ORIENTATION_2, 
                world, x, y, z);
        boolean state = !HexUtils.getMetaBit(BlockEnergyPylon.META_STATE, world, x, y, z);
        
        float r = HexColors.COLOR_WHITE_R;
        float g = HexColors.COLOR_WHITE_G;
        float b = HexColors.COLOR_WHITE_B;
        IIcon c = block.getIcon(6, 0);
        
        // Check if there is a monolith inserted.
        TileEnergyPylon tileEnergyPylon = (TileEnergyPylon) world.getTileEntity(x, y, z);
        int monolith = 0;
        if (tileEnergyPylon != null)
            monolith = tileEnergyPylon.getMonolith();

        // If there is a monolith, set the according color.
        if (monolith != 0) {
            if (monolith == 1) {
                r = HexColors.COLOR_RED_R;
                g = HexColors.COLOR_RED_G;
                b = HexColors.COLOR_RED_B;
            }
            else if (monolith == 2) {
                r = HexColors.COLOR_ORANGE_R;
                g = HexColors.COLOR_ORANGE_G;
                b = HexColors.COLOR_ORANGE_B;
            }
            else if (monolith == 3) {
                r = HexColors.COLOR_YELLOW_R;
                g = HexColors.COLOR_YELLOW_G;
                b = HexColors.COLOR_YELLOW_B;
            }
            else if (monolith == 4) {
                r = HexColors.COLOR_LIME_R;
                g = HexColors.COLOR_LIME_G;
                b = HexColors.COLOR_LIME_B;
            }
            else if (monolith == 5) {
                r = HexColors.COLOR_GREEN_R;
                g = HexColors.COLOR_GREEN_G;
                b = HexColors.COLOR_GREEN_B;
            }
            else if (monolith == 6) {
                r = HexColors.COLOR_TORQUOISE_R;
                g = HexColors.COLOR_TORQUOISE_G;
                b = HexColors.COLOR_TORQUOISE_B;
            }
            else if (monolith == 7) {
                r = HexColors.COLOR_CYAN_R;
                g = HexColors.COLOR_CYAN_G;
                b = HexColors.COLOR_CYAN_B;
            }
            else if (monolith == 8) {
                r = HexColors.COLOR_SKY_BLUE_R;
                g = HexColors.COLOR_SKY_BLUE_G;
                b = HexColors.COLOR_SKY_BLUE_B;
            }
            else if (monolith == 9) {
                r = HexColors.COLOR_BLUE_R;
                g = HexColors.COLOR_BLUE_G;
                b = HexColors.COLOR_BLUE_B;
            }
            else if (monolith == 10) {
                r = HexColors.COLOR_PURPLE_R;
                g = HexColors.COLOR_PURPLE_G;
                b = HexColors.COLOR_PURPLE_B;
            }
            else if (monolith == 11) {
                r = HexColors.COLOR_MAGENTA_R;
                g = HexColors.COLOR_MAGENTA_G;
                b = HexColors.COLOR_MAGENTA_B;
            }
            else if (monolith == 12) {
                r = HexColors.COLOR_PINK_R;
                g = HexColors.COLOR_PINK_G;
                b = HexColors.COLOR_PINK_B;
            }
            else if (monolith == 13) {
                r = HexColors.COLOR_WHITE_R;
                g = HexColors.COLOR_WHITE_G;
                b = HexColors.COLOR_WHITE_B;
            }
            else if (monolith == 14) {
                r = HexColors.COLOR_LIGHT_GRAY_R;
                g = HexColors.COLOR_LIGHT_GRAY_G;
                b = HexColors.COLOR_LIGHT_GRAY_B;
            }
            else if (monolith == 15) {
                r = HexColors.COLOR_GRAY_R;
                g = HexColors.COLOR_GRAY_G;
                b = HexColors.COLOR_GRAY_B;
            }
            else if (monolith == 16) {
                r = HexColors.COLOR_DARK_GRAY_R;
                g = HexColors.COLOR_DARK_GRAY_G;
                b = HexColors.COLOR_DARK_GRAY_B;
            }
            else if (monolith == 17) {
                r = HexColors.COLOR_BLACK_R;
                g = HexColors.COLOR_BLACK_G;
                b = HexColors.COLOR_BLACK_B;
            }
            else if (monolith == 18) {
                // If it's rainbow, set a different texture.
                c = block.getIcon(7, 0);
            }
        }

        // Check if this is the first (opaque) render pass, if it is...
        if(HexClientProxy.renderPass[renderBlockID] == 0) {
            // Prepare the Tessellator.
            Tessellator tessellator = Tessellator.instance;
            tessellator.addTranslation(x, y, z);

            // If there is a monolith...
            if (monolith != 0) {
                /* Ball */
                // Set up brightness and color.
                tessellator.setBrightness(brightness);
                if (state)
                    tessellator.setColorOpaque_F(r, g, b);
                else
                    tessellator.setColorOpaque_F(r * darkMonolith, g * darkMonolith, b * darkMonolith);

                // Render the ball.
                if (orientation == 0) {
                    // Top Face
                    tessellator.addVertexWithUV(xBallA2, 1 - yBallTop, zBallA2, c.getInterpolatedU(uBallA), c.getInterpolatedV(vBallA)); // A
                    tessellator.addVertexWithUV(xBallD2, 1 - yBallTop, zBallD2, c.getInterpolatedU(uBallD), c.getInterpolatedV(vBallD)); // D
                    tessellator.addVertexWithUV(xBallC2, 1 - yBallTop, zBallC2, c.getInterpolatedU(uBallC), c.getInterpolatedV(vBallC)); // C
                    tessellator.addVertexWithUV(xBallB2, 1 - yBallTop, zBallB2, c.getInterpolatedU(uBallB), c.getInterpolatedV(vBallB)); // B

                    tessellator.addVertexWithUV(xBallF2, 1 - yBallTop, zBallF2, c.getInterpolatedU(uBallF), c.getInterpolatedV(vBallF)); // F
                    tessellator.addVertexWithUV(xBallE2, 1 - yBallTop, zBallE2, c.getInterpolatedU(uBallE), c.getInterpolatedV(vBallE)); // E
                    tessellator.addVertexWithUV(xBallD2, 1 - yBallTop, zBallD2, c.getInterpolatedU(uBallD), c.getInterpolatedV(vBallD)); // D
                    tessellator.addVertexWithUV(xBallA2, 1 - yBallTop, zBallA2, c.getInterpolatedU(uBallA), c.getInterpolatedV(vBallA)); // A

                    // Side Faces
                    tessellator.addVertexWithUV(xBallF1, 1 - yBallMid, zBallF1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // F'
                    tessellator.addVertexWithUV(xBallE1, 1 - yBallMid, zBallE1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // E'
                    tessellator.addVertexWithUV(xBallE2, 1 - yBallTop, zBallE2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // E
                    tessellator.addVertexWithUV(xBallF2, 1 - yBallTop, zBallF2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // F

                    tessellator.addVertexWithUV(xBallE1, 1 - yBallMid, zBallE1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // E'
                    tessellator.addVertexWithUV(xBallD1, 1 - yBallMid, zBallD1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // D'
                    tessellator.addVertexWithUV(xBallD2, 1 - yBallTop, zBallD2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // D
                    tessellator.addVertexWithUV(xBallE2, 1 - yBallTop, zBallE2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // E

                    tessellator.addVertexWithUV(xBallD1, 1 - yBallMid, zBallD1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // D'
                    tessellator.addVertexWithUV(xBallC1, 1 - yBallMid, zBallC1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // C'
                    tessellator.addVertexWithUV(xBallC2, 1 - yBallTop, zBallC2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // C
                    tessellator.addVertexWithUV(xBallD2, 1 - yBallTop, zBallD2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // D

                    tessellator.addVertexWithUV(xBallC1, 1 - yBallMid, zBallC1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // C'
                    tessellator.addVertexWithUV(xBallB1, 1 - yBallMid, zBallB1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // B'
                    tessellator.addVertexWithUV(xBallB2, 1 - yBallTop, zBallB2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // B
                    tessellator.addVertexWithUV(xBallC2, 1 - yBallTop, zBallC2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // C

                    tessellator.addVertexWithUV(xBallB1, 1 - yBallMid, zBallB1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // B'
                    tessellator.addVertexWithUV(xBallA1, 1 - yBallMid, zBallA1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // A'
                    tessellator.addVertexWithUV(xBallA2, 1 - yBallTop, zBallA2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // A
                    tessellator.addVertexWithUV(xBallB2, 1 - yBallTop, zBallB2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // B

                    tessellator.addVertexWithUV(xBallA1, 1 - yBallMid, zBallA1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // A'
                    tessellator.addVertexWithUV(xBallF1, 1 - yBallMid, zBallF1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // F'
                    tessellator.addVertexWithUV(xBallF2, 1 - yBallTop, zBallF2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // F
                    tessellator.addVertexWithUV(xBallA2, 1 - yBallTop, zBallA2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // A

                    // Side Faces
                    tessellator.addVertexWithUV(xBallF2, 1 - yBallBot, zBallF2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // F'
                    tessellator.addVertexWithUV(xBallE2, 1 - yBallBot, zBallE2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // E'
                    tessellator.addVertexWithUV(xBallE1, 1 - yBallMid, zBallE1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // E
                    tessellator.addVertexWithUV(xBallF1, 1 - yBallMid, zBallF1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // F

                    tessellator.addVertexWithUV(xBallE2, 1 - yBallBot, zBallE2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // E'
                    tessellator.addVertexWithUV(xBallD2, 1 - yBallBot, zBallD2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // D'
                    tessellator.addVertexWithUV(xBallD1, 1 - yBallMid, zBallD1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // D
                    tessellator.addVertexWithUV(xBallE1, 1 - yBallMid, zBallE1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // E

                    tessellator.addVertexWithUV(xBallD2, 1 - yBallBot, zBallD2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // D'
                    tessellator.addVertexWithUV(xBallC2, 1 - yBallBot, zBallC2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // C'
                    tessellator.addVertexWithUV(xBallC1, 1 - yBallMid, zBallC1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // C
                    tessellator.addVertexWithUV(xBallD1, 1 - yBallMid, zBallD1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // D

                    tessellator.addVertexWithUV(xBallC2, 1 - yBallBot, zBallC2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // C'
                    tessellator.addVertexWithUV(xBallB2, 1 - yBallBot, zBallB2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // B'
                    tessellator.addVertexWithUV(xBallB1, 1 - yBallMid, zBallB1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // B
                    tessellator.addVertexWithUV(xBallC1, 1 - yBallMid, zBallC1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // C

                    tessellator.addVertexWithUV(xBallB2, 1 - yBallBot, zBallB2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // B'
                    tessellator.addVertexWithUV(xBallA2, 1 - yBallBot, zBallA2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // A'
                    tessellator.addVertexWithUV(xBallA1, 1 - yBallMid, zBallA1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // A
                    tessellator.addVertexWithUV(xBallB1, 1 - yBallMid, zBallB1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // B

                    tessellator.addVertexWithUV(xBallA2, 1 - yBallBot, zBallA2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // A'
                    tessellator.addVertexWithUV(xBallF2, 1 - yBallBot, zBallF2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // F'
                    tessellator.addVertexWithUV(xBallF1, 1 - yBallMid, zBallF1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // F
                    tessellator.addVertexWithUV(xBallA1, 1 - yBallMid, zBallA1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // A

                    // Bottom Face
                    tessellator.addVertexWithUV(xBallB2, 1 - yBallBot, zBallB2, c.getInterpolatedU(uBallB), c.getInterpolatedV(vBallB)); // B
                    tessellator.addVertexWithUV(xBallC2, 1 - yBallBot, zBallC2, c.getInterpolatedU(uBallC), c.getInterpolatedV(vBallC)); // C
                    tessellator.addVertexWithUV(xBallD2, 1 - yBallBot, zBallD2, c.getInterpolatedU(uBallD), c.getInterpolatedV(vBallD)); // D
                    tessellator.addVertexWithUV(xBallA2, 1 - yBallBot, zBallA2, c.getInterpolatedU(uBallA), c.getInterpolatedV(vBallA)); // A

                    tessellator.addVertexWithUV(xBallA2, 1 - yBallBot, zBallA2, c.getInterpolatedU(uBallA), c.getInterpolatedV(vBallA)); // A
                    tessellator.addVertexWithUV(xBallD2, 1 - yBallBot, zBallD2, c.getInterpolatedU(uBallD), c.getInterpolatedV(vBallD)); // D
                    tessellator.addVertexWithUV(xBallE2, 1 - yBallBot, zBallE2, c.getInterpolatedU(uBallE), c.getInterpolatedV(vBallE)); // E
                    tessellator.addVertexWithUV(xBallF2, 1 - yBallBot, zBallF2, c.getInterpolatedU(uBallF), c.getInterpolatedV(vBallF)); // F
                }
                else if (orientation == 1) {
                    // Top Face
                    tessellator.addVertexWithUV(xBallB2, yBallTop, zBallB2, c.getInterpolatedU(uBallB), c.getInterpolatedV(vBallB)); // B
                    tessellator.addVertexWithUV(xBallC2, yBallTop, zBallC2, c.getInterpolatedU(uBallC), c.getInterpolatedV(vBallC)); // C
                    tessellator.addVertexWithUV(xBallD2, yBallTop, zBallD2, c.getInterpolatedU(uBallD), c.getInterpolatedV(vBallD)); // D
                    tessellator.addVertexWithUV(xBallA2, yBallTop, zBallA2, c.getInterpolatedU(uBallA), c.getInterpolatedV(vBallA)); // A

                    tessellator.addVertexWithUV(xBallA2, yBallTop, zBallA2, c.getInterpolatedU(uBallA), c.getInterpolatedV(vBallA)); // A
                    tessellator.addVertexWithUV(xBallD2, yBallTop, zBallD2, c.getInterpolatedU(uBallD), c.getInterpolatedV(vBallD)); // D
                    tessellator.addVertexWithUV(xBallE2, yBallTop, zBallE2, c.getInterpolatedU(uBallE), c.getInterpolatedV(vBallE)); // E
                    tessellator.addVertexWithUV(xBallF2, yBallTop, zBallF2, c.getInterpolatedU(uBallF), c.getInterpolatedV(vBallF)); // F

                    // Side Faces
                    tessellator.addVertexWithUV(xBallF2, yBallTop, zBallF2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // F
                    tessellator.addVertexWithUV(xBallE2, yBallTop, zBallE2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // E
                    tessellator.addVertexWithUV(xBallE1, yBallMid, zBallE1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // E'
                    tessellator.addVertexWithUV(xBallF1, yBallMid, zBallF1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // F'

                    tessellator.addVertexWithUV(xBallE2, yBallTop, zBallE2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // E
                    tessellator.addVertexWithUV(xBallD2, yBallTop, zBallD2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // D
                    tessellator.addVertexWithUV(xBallD1, yBallMid, zBallD1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // D'
                    tessellator.addVertexWithUV(xBallE1, yBallMid, zBallE1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // E'

                    tessellator.addVertexWithUV(xBallD2, yBallTop, zBallD2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // D
                    tessellator.addVertexWithUV(xBallC2, yBallTop, zBallC2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // C
                    tessellator.addVertexWithUV(xBallC1, yBallMid, zBallC1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // C'
                    tessellator.addVertexWithUV(xBallD1, yBallMid, zBallD1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // D'

                    tessellator.addVertexWithUV(xBallC2, yBallTop, zBallC2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // C
                    tessellator.addVertexWithUV(xBallB2, yBallTop, zBallB2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // B
                    tessellator.addVertexWithUV(xBallB1, yBallMid, zBallB1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // B'
                    tessellator.addVertexWithUV(xBallC1, yBallMid, zBallC1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // C'

                    tessellator.addVertexWithUV(xBallB2, yBallTop, zBallB2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // B
                    tessellator.addVertexWithUV(xBallA2, yBallTop, zBallA2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // A
                    tessellator.addVertexWithUV(xBallA1, yBallMid, zBallA1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // A'
                    tessellator.addVertexWithUV(xBallB1, yBallMid, zBallB1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // B'

                    tessellator.addVertexWithUV(xBallA2, yBallTop, zBallA2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // A
                    tessellator.addVertexWithUV(xBallF2, yBallTop, zBallF2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // F
                    tessellator.addVertexWithUV(xBallF1, yBallMid, zBallF1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // F'
                    tessellator.addVertexWithUV(xBallA1, yBallMid, zBallA1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // A'

                    // Side Faces
                    tessellator.addVertexWithUV(xBallF1, yBallMid, zBallF1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // F
                    tessellator.addVertexWithUV(xBallE1, yBallMid, zBallE1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // E
                    tessellator.addVertexWithUV(xBallE2, yBallBot, zBallE2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // E'
                    tessellator.addVertexWithUV(xBallF2, yBallBot, zBallF2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // F'

                    tessellator.addVertexWithUV(xBallE1, yBallMid, zBallE1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // E
                    tessellator.addVertexWithUV(xBallD1, yBallMid, zBallD1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // D
                    tessellator.addVertexWithUV(xBallD2, yBallBot, zBallD2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // D'
                    tessellator.addVertexWithUV(xBallE2, yBallBot, zBallE2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // E'

                    tessellator.addVertexWithUV(xBallD1, yBallMid, zBallD1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // D
                    tessellator.addVertexWithUV(xBallC1, yBallMid, zBallC1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // C
                    tessellator.addVertexWithUV(xBallC2, yBallBot, zBallC2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // C'
                    tessellator.addVertexWithUV(xBallD2, yBallBot, zBallD2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // D'

                    tessellator.addVertexWithUV(xBallC1, yBallMid, zBallC1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // C
                    tessellator.addVertexWithUV(xBallB1, yBallMid, zBallB1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // B
                    tessellator.addVertexWithUV(xBallB2, yBallBot, zBallB2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // B'
                    tessellator.addVertexWithUV(xBallC2, yBallBot, zBallC2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // C'

                    tessellator.addVertexWithUV(xBallB1, yBallMid, zBallB1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // B
                    tessellator.addVertexWithUV(xBallA1, yBallMid, zBallA1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // A
                    tessellator.addVertexWithUV(xBallA2, yBallBot, zBallA2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // A'
                    tessellator.addVertexWithUV(xBallB2, yBallBot, zBallB2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // B'

                    tessellator.addVertexWithUV(xBallA1, yBallMid, zBallA1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // A
                    tessellator.addVertexWithUV(xBallF1, yBallMid, zBallF1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // F
                    tessellator.addVertexWithUV(xBallF2, yBallBot, zBallF2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // F'
                    tessellator.addVertexWithUV(xBallA2, yBallBot, zBallA2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // A'

                    // Bottom Face
                    tessellator.addVertexWithUV(xBallA2, yBallBot, zBallA2, c.getInterpolatedU(uBallA), c.getInterpolatedV(vBallA)); // A
                    tessellator.addVertexWithUV(xBallD2, yBallBot, zBallD2, c.getInterpolatedU(uBallD), c.getInterpolatedV(vBallD)); // D
                    tessellator.addVertexWithUV(xBallC2, yBallBot, zBallC2, c.getInterpolatedU(uBallC), c.getInterpolatedV(vBallC)); // C
                    tessellator.addVertexWithUV(xBallB2, yBallBot, zBallB2, c.getInterpolatedU(uBallB), c.getInterpolatedV(vBallB)); // B

                    tessellator.addVertexWithUV(xBallF2, yBallBot, zBallF2, c.getInterpolatedU(uBallF), c.getInterpolatedV(vBallF)); // F
                    tessellator.addVertexWithUV(xBallE2, yBallBot, zBallE2, c.getInterpolatedU(uBallE), c.getInterpolatedV(vBallE)); // E
                    tessellator.addVertexWithUV(xBallD2, yBallBot, zBallD2, c.getInterpolatedU(uBallD), c.getInterpolatedV(vBallD)); // D
                    tessellator.addVertexWithUV(xBallA2, yBallBot, zBallA2, c.getInterpolatedU(uBallA), c.getInterpolatedV(vBallA)); // A
                }
                else if (orientation == 2) {
                    // Top Face
                    tessellator.addVertexWithUV(zBallA2, xBallA2, 1 - yBallTop, c.getInterpolatedU(uBallA), c.getInterpolatedV(vBallA)); // A
                    tessellator.addVertexWithUV(zBallD2, xBallD2, 1 - yBallTop, c.getInterpolatedU(uBallD), c.getInterpolatedV(vBallD)); // D
                    tessellator.addVertexWithUV(zBallC2, xBallC2, 1 - yBallTop, c.getInterpolatedU(uBallC), c.getInterpolatedV(vBallC)); // C
                    tessellator.addVertexWithUV(zBallB2, xBallB2, 1 - yBallTop, c.getInterpolatedU(uBallB), c.getInterpolatedV(vBallB)); // B

                    tessellator.addVertexWithUV(zBallF2, xBallF2, 1 - yBallTop, c.getInterpolatedU(uBallF), c.getInterpolatedV(vBallF)); // F
                    tessellator.addVertexWithUV(zBallE2, xBallE2, 1 - yBallTop, c.getInterpolatedU(uBallE), c.getInterpolatedV(vBallE)); // E
                    tessellator.addVertexWithUV(zBallD2, xBallD2, 1 - yBallTop, c.getInterpolatedU(uBallD), c.getInterpolatedV(vBallD)); // D
                    tessellator.addVertexWithUV(zBallA2, xBallA2, 1 - yBallTop, c.getInterpolatedU(uBallA), c.getInterpolatedV(vBallA)); // A

                    // Side Faces
                    tessellator.addVertexWithUV(zBallF1, xBallF1, 1 - yBallMid, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // F'
                    tessellator.addVertexWithUV(zBallE1, xBallE1, 1 - yBallMid, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // E'
                    tessellator.addVertexWithUV(zBallE2, xBallE2, 1 - yBallTop, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // E
                    tessellator.addVertexWithUV(zBallF2, xBallF2, 1 - yBallTop, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // F

                    tessellator.addVertexWithUV(zBallE1, xBallE1, 1 - yBallMid, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // E'
                    tessellator.addVertexWithUV(zBallD1, xBallD1, 1 - yBallMid, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // D'
                    tessellator.addVertexWithUV(zBallD2, xBallD2, 1 - yBallTop, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // D
                    tessellator.addVertexWithUV(zBallE2, xBallE2, 1 - yBallTop, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // E

                    tessellator.addVertexWithUV(zBallD1, xBallD1, 1 - yBallMid, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // D'
                    tessellator.addVertexWithUV(zBallC1, xBallC1, 1 - yBallMid, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // C'
                    tessellator.addVertexWithUV(zBallC2, xBallC2, 1 - yBallTop, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // C
                    tessellator.addVertexWithUV(zBallD2, xBallD2, 1 - yBallTop, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // D

                    tessellator.addVertexWithUV(zBallC1, xBallC1, 1 - yBallMid, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // C'
                    tessellator.addVertexWithUV(zBallB1, xBallB1, 1 - yBallMid, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // B'
                    tessellator.addVertexWithUV(zBallB2, xBallB2, 1 - yBallTop, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // B
                    tessellator.addVertexWithUV(zBallC2, xBallC2, 1 - yBallTop, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // C

                    tessellator.addVertexWithUV(zBallB1, xBallB1, 1 - yBallMid, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // B'
                    tessellator.addVertexWithUV(zBallA1, xBallA1, 1 - yBallMid, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // A'
                    tessellator.addVertexWithUV(zBallA2, xBallA2, 1 - yBallTop, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // A
                    tessellator.addVertexWithUV(zBallB2, xBallB2, 1 - yBallTop, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // B

                    tessellator.addVertexWithUV(zBallA1, xBallA1, 1 - yBallMid, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // A'
                    tessellator.addVertexWithUV(zBallF1, xBallF1, 1 - yBallMid, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // F'
                    tessellator.addVertexWithUV(zBallF2, xBallF2, 1 - yBallTop, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // F
                    tessellator.addVertexWithUV(zBallA2, xBallA2, 1 - yBallTop, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // A

                    // Side Faces
                    tessellator.addVertexWithUV(zBallF2, xBallF2, 1 - yBallBot, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // F'
                    tessellator.addVertexWithUV(zBallE2, xBallE2, 1 - yBallBot, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // E'
                    tessellator.addVertexWithUV(zBallE1, xBallE1, 1 - yBallMid, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // E
                    tessellator.addVertexWithUV(zBallF1, xBallF1, 1 - yBallMid, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // F

                    tessellator.addVertexWithUV(zBallE2, xBallE2, 1 - yBallBot, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // E'
                    tessellator.addVertexWithUV(zBallD2, xBallD2, 1 - yBallBot, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // D'
                    tessellator.addVertexWithUV(zBallD1, xBallD1, 1 - yBallMid, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // D
                    tessellator.addVertexWithUV(zBallE1, xBallE1, 1 - yBallMid, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // E

                    tessellator.addVertexWithUV(zBallD2, xBallD2, 1 - yBallBot, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // D'
                    tessellator.addVertexWithUV(zBallC2, xBallC2, 1 - yBallBot, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // C'
                    tessellator.addVertexWithUV(zBallC1, xBallC1, 1 - yBallMid, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // C
                    tessellator.addVertexWithUV(zBallD1, xBallD1, 1 - yBallMid, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // D

                    tessellator.addVertexWithUV(zBallC2, xBallC2, 1 - yBallBot, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // C'
                    tessellator.addVertexWithUV(zBallB2, xBallB2, 1 - yBallBot, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // B'
                    tessellator.addVertexWithUV(zBallB1, xBallB1, 1 - yBallMid, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // B
                    tessellator.addVertexWithUV(zBallC1, xBallC1, 1 - yBallMid, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // C

                    tessellator.addVertexWithUV(zBallB2, xBallB2, 1 - yBallBot, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // B'
                    tessellator.addVertexWithUV(zBallA2, xBallA2, 1 - yBallBot, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // A'
                    tessellator.addVertexWithUV(zBallA1, xBallA1, 1 - yBallMid, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // A
                    tessellator.addVertexWithUV(zBallB1, xBallB1, 1 - yBallMid, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // B

                    tessellator.addVertexWithUV(zBallA2, xBallA2, 1 - yBallBot, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // A'
                    tessellator.addVertexWithUV(zBallF2, xBallF2, 1 - yBallBot, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // F'
                    tessellator.addVertexWithUV(zBallF1, xBallF1, 1 - yBallMid, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // F
                    tessellator.addVertexWithUV(zBallA1, xBallA1, 1 - yBallMid, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // A

                    // Bottom Face
                    tessellator.addVertexWithUV(zBallB2, xBallB2, 1 - yBallBot, c.getInterpolatedU(uBallB), c.getInterpolatedV(vBallB)); // B
                    tessellator.addVertexWithUV(zBallC2, xBallC2, 1 - yBallBot, c.getInterpolatedU(uBallC), c.getInterpolatedV(vBallC)); // C
                    tessellator.addVertexWithUV(zBallD2, xBallD2, 1 - yBallBot, c.getInterpolatedU(uBallD), c.getInterpolatedV(vBallD)); // D
                    tessellator.addVertexWithUV(zBallA2, xBallA2, 1 - yBallBot, c.getInterpolatedU(uBallA), c.getInterpolatedV(vBallA)); // A

                    tessellator.addVertexWithUV(zBallA2, xBallA2, 1 - yBallBot, c.getInterpolatedU(uBallA), c.getInterpolatedV(vBallA)); // A
                    tessellator.addVertexWithUV(zBallD2, xBallD2, 1 - yBallBot, c.getInterpolatedU(uBallD), c.getInterpolatedV(vBallD)); // D
                    tessellator.addVertexWithUV(zBallE2, xBallE2, 1 - yBallBot, c.getInterpolatedU(uBallE), c.getInterpolatedV(vBallE)); // E
                    tessellator.addVertexWithUV(zBallF2, xBallF2, 1 - yBallBot, c.getInterpolatedU(uBallF), c.getInterpolatedV(vBallF)); // F
                }
                else if (orientation == 3) {
                    // Top Face
                    tessellator.addVertexWithUV(zBallB2, xBallB2, yBallTop, c.getInterpolatedU(uBallB), c.getInterpolatedV(vBallB)); // B
                    tessellator.addVertexWithUV(zBallC2, xBallC2, yBallTop, c.getInterpolatedU(uBallC), c.getInterpolatedV(vBallC)); // C
                    tessellator.addVertexWithUV(zBallD2, xBallD2, yBallTop, c.getInterpolatedU(uBallD), c.getInterpolatedV(vBallD)); // D
                    tessellator.addVertexWithUV(zBallA2, xBallA2, yBallTop, c.getInterpolatedU(uBallA), c.getInterpolatedV(vBallA)); // A

                    tessellator.addVertexWithUV(zBallA2, xBallA2, yBallTop, c.getInterpolatedU(uBallA), c.getInterpolatedV(vBallA)); // A
                    tessellator.addVertexWithUV(zBallD2, xBallD2, yBallTop, c.getInterpolatedU(uBallD), c.getInterpolatedV(vBallD)); // D
                    tessellator.addVertexWithUV(zBallE2, xBallE2, yBallTop, c.getInterpolatedU(uBallE), c.getInterpolatedV(vBallE)); // E
                    tessellator.addVertexWithUV(zBallF2, xBallF2, yBallTop, c.getInterpolatedU(uBallF), c.getInterpolatedV(vBallF)); // F

                    // Side Faces
                    tessellator.addVertexWithUV(zBallF2, xBallF2, yBallTop, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // F
                    tessellator.addVertexWithUV(zBallE2, xBallE2, yBallTop, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // E
                    tessellator.addVertexWithUV(zBallE1, xBallE1, yBallMid, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // E'
                    tessellator.addVertexWithUV(zBallF1, xBallF1, yBallMid, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // F'

                    tessellator.addVertexWithUV(zBallE2, xBallE2, yBallTop, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // E
                    tessellator.addVertexWithUV(zBallD2, xBallD2, yBallTop, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // D
                    tessellator.addVertexWithUV(zBallD1, xBallD1, yBallMid, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // D'
                    tessellator.addVertexWithUV(zBallE1, xBallE1, yBallMid, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // E'

                    tessellator.addVertexWithUV(zBallD2, xBallD2, yBallTop, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // D
                    tessellator.addVertexWithUV(zBallC2, xBallC2, yBallTop, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // C
                    tessellator.addVertexWithUV(zBallC1, xBallC1, yBallMid, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // C'
                    tessellator.addVertexWithUV(zBallD1, xBallD1, yBallMid, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // D'

                    tessellator.addVertexWithUV(zBallC2, xBallC2, yBallTop, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // C
                    tessellator.addVertexWithUV(zBallB2, xBallB2, yBallTop, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // B
                    tessellator.addVertexWithUV(zBallB1, xBallB1, yBallMid, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // B'
                    tessellator.addVertexWithUV(zBallC1, xBallC1, yBallMid, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // C'

                    tessellator.addVertexWithUV(zBallB2, xBallB2, yBallTop, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // B
                    tessellator.addVertexWithUV(zBallA2, xBallA2, yBallTop, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // A
                    tessellator.addVertexWithUV(zBallA1, xBallA1, yBallMid, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // A'
                    tessellator.addVertexWithUV(zBallB1, xBallB1, yBallMid, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // B'

                    tessellator.addVertexWithUV(zBallA2, xBallA2, yBallTop, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // A
                    tessellator.addVertexWithUV(zBallF2, xBallF2, yBallTop, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // F
                    tessellator.addVertexWithUV(zBallF1, xBallF1, yBallMid, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // F'
                    tessellator.addVertexWithUV(zBallA1, xBallA1, yBallMid, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // A'

                    // Side Faces
                    tessellator.addVertexWithUV(zBallF1, xBallF1, yBallMid, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // F
                    tessellator.addVertexWithUV(zBallE1, xBallE1, yBallMid, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // E
                    tessellator.addVertexWithUV(zBallE2, xBallE2, yBallBot, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // E'
                    tessellator.addVertexWithUV(zBallF2, xBallF2, yBallBot, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // F'

                    tessellator.addVertexWithUV(zBallE1, xBallE1, yBallMid, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // E
                    tessellator.addVertexWithUV(zBallD1, xBallD1, yBallMid, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // D
                    tessellator.addVertexWithUV(zBallD2, xBallD2, yBallBot, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // D'
                    tessellator.addVertexWithUV(zBallE2, xBallE2, yBallBot, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // E'

                    tessellator.addVertexWithUV(zBallD1, xBallD1, yBallMid, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // D
                    tessellator.addVertexWithUV(zBallC1, xBallC1, yBallMid, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // C
                    tessellator.addVertexWithUV(zBallC2, xBallC2, yBallBot, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // C'
                    tessellator.addVertexWithUV(zBallD2, xBallD2, yBallBot, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // D'

                    tessellator.addVertexWithUV(zBallC1, xBallC1, yBallMid, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // C
                    tessellator.addVertexWithUV(zBallB1, xBallB1, yBallMid, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // B
                    tessellator.addVertexWithUV(zBallB2, xBallB2, yBallBot, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // B'
                    tessellator.addVertexWithUV(zBallC2, xBallC2, yBallBot, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // C'

                    tessellator.addVertexWithUV(zBallB1, xBallB1, yBallMid, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // B
                    tessellator.addVertexWithUV(zBallA1, xBallA1, yBallMid, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // A
                    tessellator.addVertexWithUV(zBallA2, xBallA2, yBallBot, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // A'
                    tessellator.addVertexWithUV(zBallB2, xBallB2, yBallBot, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // B'

                    tessellator.addVertexWithUV(zBallA1, xBallA1, yBallMid, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // A
                    tessellator.addVertexWithUV(zBallF1, xBallF1, yBallMid, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // F
                    tessellator.addVertexWithUV(zBallF2, xBallF2, yBallBot, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // F'
                    tessellator.addVertexWithUV(zBallA2, xBallA2, yBallBot, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // A'

                    // Bottom Face
                    tessellator.addVertexWithUV(zBallA2, xBallA2, yBallBot, c.getInterpolatedU(uBallA), c.getInterpolatedV(vBallA)); // A
                    tessellator.addVertexWithUV(zBallD2, xBallD2, yBallBot, c.getInterpolatedU(uBallD), c.getInterpolatedV(vBallD)); // D
                    tessellator.addVertexWithUV(zBallC2, xBallC2, yBallBot, c.getInterpolatedU(uBallC), c.getInterpolatedV(vBallC)); // C
                    tessellator.addVertexWithUV(zBallB2, xBallB2, yBallBot, c.getInterpolatedU(uBallB), c.getInterpolatedV(vBallB)); // B

                    tessellator.addVertexWithUV(zBallF2, xBallF2, yBallBot, c.getInterpolatedU(uBallF), c.getInterpolatedV(vBallF)); // F
                    tessellator.addVertexWithUV(zBallE2, xBallE2, yBallBot, c.getInterpolatedU(uBallE), c.getInterpolatedV(vBallE)); // E
                    tessellator.addVertexWithUV(zBallD2, xBallD2, yBallBot, c.getInterpolatedU(uBallD), c.getInterpolatedV(vBallD)); // D
                    tessellator.addVertexWithUV(zBallA2, xBallA2, yBallBot, c.getInterpolatedU(uBallA), c.getInterpolatedV(vBallA)); // A
                }
                else if (orientation == 4) {
                    // Top Face
                    tessellator.addVertexWithUV(1 - yBallTop, xBallB2, zBallB2, c.getInterpolatedU(uBallB), c.getInterpolatedV(vBallB)); // B
                    tessellator.addVertexWithUV(1 - yBallTop, xBallC2, zBallC2, c.getInterpolatedU(uBallC), c.getInterpolatedV(vBallC)); // C
                    tessellator.addVertexWithUV(1 - yBallTop, xBallD2, zBallD2, c.getInterpolatedU(uBallD), c.getInterpolatedV(vBallD)); // D
                    tessellator.addVertexWithUV(1 - yBallTop, xBallA2, zBallA2, c.getInterpolatedU(uBallA), c.getInterpolatedV(vBallA)); // A

                    tessellator.addVertexWithUV(1 - yBallTop, xBallA2, zBallA2, c.getInterpolatedU(uBallA), c.getInterpolatedV(vBallA)); // A
                    tessellator.addVertexWithUV(1 - yBallTop, xBallD2, zBallD2, c.getInterpolatedU(uBallD), c.getInterpolatedV(vBallD)); // D
                    tessellator.addVertexWithUV(1 - yBallTop, xBallE2, zBallE2, c.getInterpolatedU(uBallE), c.getInterpolatedV(vBallE)); // E
                    tessellator.addVertexWithUV(1 - yBallTop, xBallF2, zBallF2, c.getInterpolatedU(uBallF), c.getInterpolatedV(vBallF)); // F

                    // Side Faces
                    tessellator.addVertexWithUV(1 - yBallTop, xBallF2, zBallF2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // F
                    tessellator.addVertexWithUV(1 - yBallTop, xBallE2, zBallE2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // E
                    tessellator.addVertexWithUV(1 - yBallMid, xBallE1, zBallE1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // E'
                    tessellator.addVertexWithUV(1 - yBallMid, xBallF1, zBallF1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // F'

                    tessellator.addVertexWithUV(1 - yBallTop, xBallE2, zBallE2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // E
                    tessellator.addVertexWithUV(1 - yBallTop, xBallD2, zBallD2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // D
                    tessellator.addVertexWithUV(1 - yBallMid, xBallD1, zBallD1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // D'
                    tessellator.addVertexWithUV(1 - yBallMid, xBallE1, zBallE1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // E'

                    tessellator.addVertexWithUV(1 - yBallTop, xBallD2, zBallD2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // D
                    tessellator.addVertexWithUV(1 - yBallTop, xBallC2, zBallC2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // C
                    tessellator.addVertexWithUV(1 - yBallMid, xBallC1, zBallC1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // C'
                    tessellator.addVertexWithUV(1 - yBallMid, xBallD1, zBallD1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // D'

                    tessellator.addVertexWithUV(1 - yBallTop, xBallC2, zBallC2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // C
                    tessellator.addVertexWithUV(1 - yBallTop, xBallB2, zBallB2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // B
                    tessellator.addVertexWithUV(1 - yBallMid, xBallB1, zBallB1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // B'
                    tessellator.addVertexWithUV(1 - yBallMid, xBallC1, zBallC1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // C'

                    tessellator.addVertexWithUV(1 - yBallTop, xBallB2, zBallB2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // B
                    tessellator.addVertexWithUV(1 - yBallTop, xBallA2, zBallA2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // A
                    tessellator.addVertexWithUV(1 - yBallMid, xBallA1, zBallA1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // A'
                    tessellator.addVertexWithUV(1 - yBallMid, xBallB1, zBallB1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // B'

                    tessellator.addVertexWithUV(1 - yBallTop, xBallA2, zBallA2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // A
                    tessellator.addVertexWithUV(1 - yBallTop, xBallF2, zBallF2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // F
                    tessellator.addVertexWithUV(1 - yBallMid, xBallF1, zBallF1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // F'
                    tessellator.addVertexWithUV(1 - yBallMid, xBallA1, zBallA1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // A'

                    // Side Faces
                    tessellator.addVertexWithUV(1 - yBallMid, xBallF1, zBallF1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // F
                    tessellator.addVertexWithUV(1 - yBallMid, xBallE1, zBallE1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // E
                    tessellator.addVertexWithUV(1 - yBallBot, xBallE2, zBallE2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // E'
                    tessellator.addVertexWithUV(1 - yBallBot, xBallF2, zBallF2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // F'

                    tessellator.addVertexWithUV(1 - yBallMid, xBallE1, zBallE1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // E
                    tessellator.addVertexWithUV(1 - yBallMid, xBallD1, zBallD1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // D
                    tessellator.addVertexWithUV(1 - yBallBot, xBallD2, zBallD2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // D'
                    tessellator.addVertexWithUV(1 - yBallBot, xBallE2, zBallE2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // E'

                    tessellator.addVertexWithUV(1 - yBallMid, xBallD1, zBallD1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // D
                    tessellator.addVertexWithUV(1 - yBallMid, xBallC1, zBallC1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // C
                    tessellator.addVertexWithUV(1 - yBallBot, xBallC2, zBallC2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // C'
                    tessellator.addVertexWithUV(1 - yBallBot, xBallD2, zBallD2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // D'

                    tessellator.addVertexWithUV(1 - yBallMid, xBallC1, zBallC1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // C
                    tessellator.addVertexWithUV(1 - yBallMid, xBallB1, zBallB1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // B
                    tessellator.addVertexWithUV(1 - yBallBot, xBallB2, zBallB2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // B'
                    tessellator.addVertexWithUV(1 - yBallBot, xBallC2, zBallC2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // C'

                    tessellator.addVertexWithUV(1 - yBallMid, xBallB1, zBallB1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // B
                    tessellator.addVertexWithUV(1 - yBallMid, xBallA1, zBallA1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // A
                    tessellator.addVertexWithUV(1 - yBallBot, xBallA2, zBallA2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // A'
                    tessellator.addVertexWithUV(1 - yBallBot, xBallB2, zBallB2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // B'

                    tessellator.addVertexWithUV(1 - yBallMid, xBallA1, zBallA1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // A
                    tessellator.addVertexWithUV(1 - yBallMid, xBallF1, zBallF1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // F
                    tessellator.addVertexWithUV(1 - yBallBot, xBallF2, zBallF2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // F'
                    tessellator.addVertexWithUV(1 - yBallBot, xBallA2, zBallA2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // A'

                    // Bottom Face
                    tessellator.addVertexWithUV(1 - yBallBot, xBallA2, zBallA2, c.getInterpolatedU(uBallA), c.getInterpolatedV(vBallA)); // A
                    tessellator.addVertexWithUV(1 - yBallBot, xBallD2, zBallD2, c.getInterpolatedU(uBallD), c.getInterpolatedV(vBallD)); // D
                    tessellator.addVertexWithUV(1 - yBallBot, xBallC2, zBallC2, c.getInterpolatedU(uBallC), c.getInterpolatedV(vBallC)); // C
                    tessellator.addVertexWithUV(1 - yBallBot, xBallB2, zBallB2, c.getInterpolatedU(uBallB), c.getInterpolatedV(vBallB)); // B

                    tessellator.addVertexWithUV(1 - yBallBot, xBallF2, zBallF2, c.getInterpolatedU(uBallF), c.getInterpolatedV(vBallF)); // F
                    tessellator.addVertexWithUV(1 - yBallBot, xBallE2, zBallE2, c.getInterpolatedU(uBallE), c.getInterpolatedV(vBallE)); // E
                    tessellator.addVertexWithUV(1 - yBallBot, xBallD2, zBallD2, c.getInterpolatedU(uBallD), c.getInterpolatedV(vBallD)); // D
                    tessellator.addVertexWithUV(1 - yBallBot, xBallA2, zBallA2, c.getInterpolatedU(uBallA), c.getInterpolatedV(vBallA)); // A
                }
                else if (orientation == 5) {
                    // Top Face
                    tessellator.addVertexWithUV(yBallTop, xBallA2, zBallA2, c.getInterpolatedU(uBallA), c.getInterpolatedV(vBallA)); // A
                    tessellator.addVertexWithUV(yBallTop, xBallD2, zBallD2, c.getInterpolatedU(uBallD), c.getInterpolatedV(vBallD)); // D
                    tessellator.addVertexWithUV(yBallTop, xBallC2, zBallC2, c.getInterpolatedU(uBallC), c.getInterpolatedV(vBallC)); // C
                    tessellator.addVertexWithUV(yBallTop, xBallB2, zBallB2, c.getInterpolatedU(uBallB), c.getInterpolatedV(vBallB)); // B

                    tessellator.addVertexWithUV(yBallTop, xBallF2, zBallF2, c.getInterpolatedU(uBallF), c.getInterpolatedV(vBallF)); // F
                    tessellator.addVertexWithUV(yBallTop, xBallE2, zBallE2, c.getInterpolatedU(uBallE), c.getInterpolatedV(vBallE)); // E
                    tessellator.addVertexWithUV(yBallTop, xBallD2, zBallD2, c.getInterpolatedU(uBallD), c.getInterpolatedV(vBallD)); // D
                    tessellator.addVertexWithUV(yBallTop, xBallA2, zBallA2, c.getInterpolatedU(uBallA), c.getInterpolatedV(vBallA)); // A

                    // Side Faces
                    tessellator.addVertexWithUV(yBallMid, xBallF1, zBallF1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // F'
                    tessellator.addVertexWithUV(yBallMid, xBallE1, zBallE1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // E'
                    tessellator.addVertexWithUV(yBallTop, xBallE2, zBallE2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // E
                    tessellator.addVertexWithUV(yBallTop, xBallF2, zBallF2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // F

                    tessellator.addVertexWithUV(yBallMid, xBallE1, zBallE1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // E'
                    tessellator.addVertexWithUV(yBallMid, xBallD1, zBallD1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // D'
                    tessellator.addVertexWithUV(yBallTop, xBallD2, zBallD2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // D
                    tessellator.addVertexWithUV(yBallTop, xBallE2, zBallE2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // E

                    tessellator.addVertexWithUV(yBallMid, xBallD1, zBallD1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // D'
                    tessellator.addVertexWithUV(yBallMid, xBallC1, zBallC1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // C'
                    tessellator.addVertexWithUV(yBallTop, xBallC2, zBallC2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // C
                    tessellator.addVertexWithUV(yBallTop, xBallD2, zBallD2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // D

                    tessellator.addVertexWithUV(yBallMid, xBallC1, zBallC1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // C'
                    tessellator.addVertexWithUV(yBallMid, xBallB1, zBallB1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // B'
                    tessellator.addVertexWithUV(yBallTop, xBallB2, zBallB2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // B
                    tessellator.addVertexWithUV(yBallTop, xBallC2, zBallC2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // C

                    tessellator.addVertexWithUV(yBallMid, xBallB1, zBallB1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // B'
                    tessellator.addVertexWithUV(yBallMid, xBallA1, zBallA1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // A'
                    tessellator.addVertexWithUV(yBallTop, xBallA2, zBallA2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // A
                    tessellator.addVertexWithUV(yBallTop, xBallB2, zBallB2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // B

                    tessellator.addVertexWithUV(yBallMid, xBallA1, zBallA1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // A'
                    tessellator.addVertexWithUV(yBallMid, xBallF1, zBallF1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // F'
                    tessellator.addVertexWithUV(yBallTop, xBallF2, zBallF2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // F
                    tessellator.addVertexWithUV(yBallTop, xBallA2, zBallA2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // A

                    // Side Faces
                    tessellator.addVertexWithUV(yBallBot, xBallF2, zBallF2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // F'
                    tessellator.addVertexWithUV(yBallBot, xBallE2, zBallE2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // E'
                    tessellator.addVertexWithUV(yBallMid, xBallE1, zBallE1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // E
                    tessellator.addVertexWithUV(yBallMid, xBallF1, zBallF1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // F

                    tessellator.addVertexWithUV(yBallBot, xBallE2, zBallE2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // E'
                    tessellator.addVertexWithUV(yBallBot, xBallD2, zBallD2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // D'
                    tessellator.addVertexWithUV(yBallMid, xBallD1, zBallD1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // D
                    tessellator.addVertexWithUV(yBallMid, xBallE1, zBallE1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // E

                    tessellator.addVertexWithUV(yBallBot, xBallD2, zBallD2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // D'
                    tessellator.addVertexWithUV(yBallBot, xBallC2, zBallC2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // C'
                    tessellator.addVertexWithUV(yBallMid, xBallC1, zBallC1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // C
                    tessellator.addVertexWithUV(yBallMid, xBallD1, zBallD1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // D

                    tessellator.addVertexWithUV(yBallBot, xBallC2, zBallC2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // C'
                    tessellator.addVertexWithUV(yBallBot, xBallB2, zBallB2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // B'
                    tessellator.addVertexWithUV(yBallMid, xBallB1, zBallB1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // B
                    tessellator.addVertexWithUV(yBallMid, xBallC1, zBallC1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // C

                    tessellator.addVertexWithUV(yBallBot, xBallB2, zBallB2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // B'
                    tessellator.addVertexWithUV(yBallBot, xBallA2, zBallA2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // A'
                    tessellator.addVertexWithUV(yBallMid, xBallA1, zBallA1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // A
                    tessellator.addVertexWithUV(yBallMid, xBallB1, zBallB1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // B

                    tessellator.addVertexWithUV(yBallBot, xBallA2, zBallA2, c.getInterpolatedU(uBallJ), c.getInterpolatedV(vBallJ)); // A'
                    tessellator.addVertexWithUV(yBallBot, xBallF2, zBallF2, c.getInterpolatedU(uBallI), c.getInterpolatedV(vBallI)); // F'
                    tessellator.addVertexWithUV(yBallMid, xBallF1, zBallF1, c.getInterpolatedU(uBallH), c.getInterpolatedV(vBallH)); // F
                    tessellator.addVertexWithUV(yBallMid, xBallA1, zBallA1, c.getInterpolatedU(uBallG), c.getInterpolatedV(vBallG)); // A

                    // Bottom Face
                    tessellator.addVertexWithUV(yBallBot, xBallB2, zBallB2, c.getInterpolatedU(uBallB), c.getInterpolatedV(vBallB)); // B
                    tessellator.addVertexWithUV(yBallBot, xBallC2, zBallC2, c.getInterpolatedU(uBallC), c.getInterpolatedV(vBallC)); // C
                    tessellator.addVertexWithUV(yBallBot, xBallD2, zBallD2, c.getInterpolatedU(uBallD), c.getInterpolatedV(vBallD)); // D
                    tessellator.addVertexWithUV(yBallBot, xBallA2, zBallA2, c.getInterpolatedU(uBallA), c.getInterpolatedV(vBallA)); // A

                    tessellator.addVertexWithUV(yBallBot, xBallA2, zBallA2, c.getInterpolatedU(uBallA), c.getInterpolatedV(vBallA)); // A
                    tessellator.addVertexWithUV(yBallBot, xBallD2, zBallD2, c.getInterpolatedU(uBallD), c.getInterpolatedV(vBallD)); // D
                    tessellator.addVertexWithUV(yBallBot, xBallE2, zBallE2, c.getInterpolatedU(uBallE), c.getInterpolatedV(vBallE)); // E
                    tessellator.addVertexWithUV(yBallBot, xBallF2, zBallF2, c.getInterpolatedU(uBallF), c.getInterpolatedV(vBallF)); // F
                }
            }

            /* Base */
            // Prepare the icon.
            c = block.getIcon(0, 0);

            // Set up brightness and color.
            tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
            tessellator.setColorOpaque_F(1, 1, 1);

            // Render the base.
            if (orientation == 0) {
                // Base Faces
                tessellator.addVertexWithUV(xPlatMin, 1-yMonoBot, zPlatMax, c.getInterpolatedU(uBaseA4), c.getInterpolatedV(vBaseA4)); // A'
                tessellator.addVertexWithUV(xPlatMax, 1-yMonoBot, zPlatMax, c.getInterpolatedU(uBaseA3), c.getInterpolatedV(vBaseA3)); // B'
                tessellator.addVertexWithUV(xBaseMax, 1-yBaseBot, zBaseMax, c.getInterpolatedU(uBaseA2), c.getInterpolatedV(vBaseA2)); // B
                tessellator.addVertexWithUV(xBaseMin, 1-yBaseBot, zBaseMax, c.getInterpolatedU(uBaseA1), c.getInterpolatedV(vBaseA1)); // A

                tessellator.addVertexWithUV(xPlatMax, 1-yMonoBot, zPlatMax, c.getInterpolatedU(uBaseB4), c.getInterpolatedV(vBaseB4)); // B'
                tessellator.addVertexWithUV(xPlatMax, 1-yMonoBot, zPlatMin, c.getInterpolatedU(uBaseB3), c.getInterpolatedV(vBaseB3)); // C'
                tessellator.addVertexWithUV(xBaseMax, 1-yBaseBot, zBaseMin, c.getInterpolatedU(uBaseB2), c.getInterpolatedV(vBaseB2)); // C
                tessellator.addVertexWithUV(xBaseMax, 1-yBaseBot, zBaseMax, c.getInterpolatedU(uBaseB1), c.getInterpolatedV(vBaseB1)); // B

                tessellator.addVertexWithUV(xPlatMax, 1-yMonoBot, zPlatMin, c.getInterpolatedU(uBaseA4), c.getInterpolatedV(vBaseA4)); // C'
                tessellator.addVertexWithUV(xPlatMin, 1-yMonoBot, zPlatMin, c.getInterpolatedU(uBaseA3), c.getInterpolatedV(vBaseA3)); // D'
                tessellator.addVertexWithUV(xBaseMin, 1-yBaseBot, zBaseMin, c.getInterpolatedU(uBaseA2), c.getInterpolatedV(vBaseA2)); // D
                tessellator.addVertexWithUV(xBaseMax, 1-yBaseBot, zBaseMin, c.getInterpolatedU(uBaseA1), c.getInterpolatedV(vBaseA1)); // C

                tessellator.addVertexWithUV(xPlatMin, 1-yMonoBot, zPlatMin, c.getInterpolatedU(uBaseB4), c.getInterpolatedV(vBaseB4)); // D'
                tessellator.addVertexWithUV(xPlatMin, 1-yMonoBot, zPlatMax, c.getInterpolatedU(uBaseB3), c.getInterpolatedV(vBaseB3)); // A'
                tessellator.addVertexWithUV(xBaseMin, 1-yBaseBot, zBaseMax, c.getInterpolatedU(uBaseB2), c.getInterpolatedV(vBaseB2)); // A
                tessellator.addVertexWithUV(xBaseMin, 1-yBaseBot, zBaseMin, c.getInterpolatedU(uBaseB1), c.getInterpolatedV(vBaseB1)); // D

                // Ring Outer Faces
                tessellator.addVertexWithUV(xMonoA, 1-yRingTop, zMonoA, c.getInterpolatedU(uRingA4), c.getInterpolatedV(vRingA4)); // A'
                tessellator.addVertexWithUV(xMonoB, 1-yRingTop, zMonoB, c.getInterpolatedU(uRingA3), c.getInterpolatedV(vRingA3)); // B'
                tessellator.addVertexWithUV(xRingB, 1-yMonoBot, zRingB, c.getInterpolatedU(uRingA2), c.getInterpolatedV(vRingA2)); // B
                tessellator.addVertexWithUV(xRingA, 1-yMonoBot, zRingA, c.getInterpolatedU(uRingA1), c.getInterpolatedV(vRingA1)); // A

                tessellator.addVertexWithUV(xMonoB, 1-yRingTop, zMonoB, c.getInterpolatedU(uRingB4), c.getInterpolatedV(vRingB4)); // B'
                tessellator.addVertexWithUV(xMonoC, 1-yRingTop, zMonoC, c.getInterpolatedU(uRingB3), c.getInterpolatedV(vRingB3)); // C'
                tessellator.addVertexWithUV(xRingC, 1-yMonoBot, zRingC, c.getInterpolatedU(uRingB2), c.getInterpolatedV(vRingB2)); // C
                tessellator.addVertexWithUV(xRingB, 1-yMonoBot, zRingB, c.getInterpolatedU(uRingB1), c.getInterpolatedV(vRingB1)); // B

                tessellator.addVertexWithUV(xMonoC, 1-yRingTop, zMonoC, c.getInterpolatedU(uRingC4), c.getInterpolatedV(vRingC4)); // C'
                tessellator.addVertexWithUV(xMonoD, 1-yRingTop, zMonoD, c.getInterpolatedU(uRingC3), c.getInterpolatedV(vRingC3)); // D'
                tessellator.addVertexWithUV(xRingD, 1-yMonoBot, zRingD, c.getInterpolatedU(uRingC2), c.getInterpolatedV(vRingC2)); // D
                tessellator.addVertexWithUV(xRingC, 1-yMonoBot, zRingC, c.getInterpolatedU(uRingC1), c.getInterpolatedV(vRingC1)); // C

                tessellator.addVertexWithUV(xMonoD, 1-yRingTop, zMonoD, c.getInterpolatedU(uRingA4), c.getInterpolatedV(vRingA4)); // D'
                tessellator.addVertexWithUV(xMonoE, 1-yRingTop, zMonoE, c.getInterpolatedU(uRingA3), c.getInterpolatedV(vRingA3)); // E'
                tessellator.addVertexWithUV(xRingE, 1-yMonoBot, zRingE, c.getInterpolatedU(uRingA2), c.getInterpolatedV(vRingA2)); // E
                tessellator.addVertexWithUV(xRingD, 1-yMonoBot, zRingD, c.getInterpolatedU(uRingA1), c.getInterpolatedV(vRingA1)); // D

                tessellator.addVertexWithUV(xMonoE, 1-yRingTop, zMonoE, c.getInterpolatedU(uRingB4), c.getInterpolatedV(vRingB4)); // E'
                tessellator.addVertexWithUV(xMonoF, 1-yRingTop, zMonoF, c.getInterpolatedU(uRingB3), c.getInterpolatedV(vRingB3)); // F'
                tessellator.addVertexWithUV(xRingF, 1-yMonoBot, zRingF, c.getInterpolatedU(uRingB2), c.getInterpolatedV(vRingB2)); // F
                tessellator.addVertexWithUV(xRingE, 1-yMonoBot, zRingE, c.getInterpolatedU(uRingB1), c.getInterpolatedV(vRingB1)); // E

                tessellator.addVertexWithUV(xMonoF, 1-yRingTop, zMonoF, c.getInterpolatedU(uRingC4), c.getInterpolatedV(vRingC4)); // F'
                tessellator.addVertexWithUV(xMonoA, 1-yRingTop, zMonoA, c.getInterpolatedU(uRingC3), c.getInterpolatedV(vRingC3)); // A'
                tessellator.addVertexWithUV(xRingA, 1-yMonoBot, zRingA, c.getInterpolatedU(uRingC2), c.getInterpolatedV(vRingC2)); // A
                tessellator.addVertexWithUV(xRingF, 1-yMonoBot, zRingF, c.getInterpolatedU(uRingC1), c.getInterpolatedV(vRingC1)); // F

                // Ring Inner Faces
                tessellator.addVertexWithUV(xMonoA, 1-yMonoBot, zMonoA, c.getInterpolatedU(uRingD4), c.getInterpolatedV(vRingD4)); // A''
                tessellator.addVertexWithUV(xMonoB, 1-yMonoBot, zMonoB, c.getInterpolatedU(uRingD3), c.getInterpolatedV(vRingD3)); // B''
                tessellator.addVertexWithUV(xMonoB, 1-yRingTop, zMonoB, c.getInterpolatedU(uRingD2), c.getInterpolatedV(vRingD2)); // B'
                tessellator.addVertexWithUV(xMonoA, 1-yRingTop, zMonoA, c.getInterpolatedU(uRingD1), c.getInterpolatedV(vRingD1)); // A'

                tessellator.addVertexWithUV(xMonoB, 1-yMonoBot, zMonoB, c.getInterpolatedU(uRingE4), c.getInterpolatedV(vRingE4)); // B''
                tessellator.addVertexWithUV(xMonoC, 1-yMonoBot, zMonoC, c.getInterpolatedU(uRingE3), c.getInterpolatedV(vRingE3)); // C''
                tessellator.addVertexWithUV(xMonoC, 1-yRingTop, zMonoC, c.getInterpolatedU(uRingE2), c.getInterpolatedV(vRingE2)); // C'
                tessellator.addVertexWithUV(xMonoB, 1-yRingTop, zMonoB, c.getInterpolatedU(uRingE1), c.getInterpolatedV(vRingE1)); // B'

                tessellator.addVertexWithUV(xMonoC, 1-yMonoBot, zMonoC, c.getInterpolatedU(uRingF4), c.getInterpolatedV(vRingF4)); // C''
                tessellator.addVertexWithUV(xMonoD, 1-yMonoBot, zMonoD, c.getInterpolatedU(uRingF3), c.getInterpolatedV(vRingF3)); // D''
                tessellator.addVertexWithUV(xMonoD, 1-yRingTop, zMonoD, c.getInterpolatedU(uRingF2), c.getInterpolatedV(vRingF2)); // D'
                tessellator.addVertexWithUV(xMonoC, 1-yRingTop, zMonoC, c.getInterpolatedU(uRingF1), c.getInterpolatedV(vRingF1)); // C'

                tessellator.addVertexWithUV(xMonoD, 1-yMonoBot, zMonoD, c.getInterpolatedU(uRingD4), c.getInterpolatedV(vRingD4)); // D''
                tessellator.addVertexWithUV(xMonoE, 1-yMonoBot, zMonoE, c.getInterpolatedU(uRingD3), c.getInterpolatedV(vRingD3)); // E''
                tessellator.addVertexWithUV(xMonoE, 1-yRingTop, zMonoE, c.getInterpolatedU(uRingD2), c.getInterpolatedV(vRingD2)); // E'
                tessellator.addVertexWithUV(xMonoD, 1-yRingTop, zMonoD, c.getInterpolatedU(uRingD1), c.getInterpolatedV(vRingD1)); // D'

                tessellator.addVertexWithUV(xMonoE, 1-yMonoBot, zMonoE, c.getInterpolatedU(uRingE4), c.getInterpolatedV(vRingE4)); // E''
                tessellator.addVertexWithUV(xMonoF, 1-yMonoBot, zMonoF, c.getInterpolatedU(uRingE3), c.getInterpolatedV(vRingE3)); // F''
                tessellator.addVertexWithUV(xMonoF, 1-yRingTop, zMonoF, c.getInterpolatedU(uRingE2), c.getInterpolatedV(vRingE2)); // F'
                tessellator.addVertexWithUV(xMonoE, 1-yRingTop, zMonoE, c.getInterpolatedU(uRingE1), c.getInterpolatedV(vRingE1)); // E'

                tessellator.addVertexWithUV(xMonoF, 1-yMonoBot, zMonoF, c.getInterpolatedU(uRingF4), c.getInterpolatedV(vRingF4)); // F''
                tessellator.addVertexWithUV(xMonoA, 1-yMonoBot, zMonoA, c.getInterpolatedU(uRingF3), c.getInterpolatedV(vRingF3)); // A''
                tessellator.addVertexWithUV(xMonoA, 1-yRingTop, zMonoA, c.getInterpolatedU(uRingF2), c.getInterpolatedV(vRingF2)); // A'
                tessellator.addVertexWithUV(xMonoF, 1-yRingTop, zMonoF, c.getInterpolatedU(uRingF1), c.getInterpolatedV(vRingF1)); // F'

                c = block.getIcon(8, 0);
                double u = c.getInterpolatedU(uBaseTop);
                double U = c.getInterpolatedU(UBaseTop);
                double v = c.getInterpolatedV(vBaseTop);
                double V = c.getInterpolatedV(VBaseTop);

                // Base Plate
                tessellator.addVertexWithUV(xPlatMin, 1-yMonoBot, zPlatMin, u, V); // D'
                tessellator.addVertexWithUV(xPlatMax, 1-yMonoBot, zPlatMin, U, V); // C'
                tessellator.addVertexWithUV(xPlatMax, 1-yMonoBot, zPlatMax, U, v); // B'
                tessellator.addVertexWithUV(xPlatMin, 1-yMonoBot, zPlatMax, u, v); // A'
            }
            else if (orientation == 1) {
                // Base Faces
                tessellator.addVertexWithUV(xBaseMin, yBaseBot, zBaseMax, c.getInterpolatedU(uBaseA1), c.getInterpolatedV(vBaseA1)); // A
                tessellator.addVertexWithUV(xBaseMax, yBaseBot, zBaseMax, c.getInterpolatedU(uBaseA2), c.getInterpolatedV(vBaseA2)); // B
                tessellator.addVertexWithUV(xPlatMax, yMonoBot, zPlatMax, c.getInterpolatedU(uBaseA3), c.getInterpolatedV(vBaseA3)); // B'
                tessellator.addVertexWithUV(xPlatMin, yMonoBot, zPlatMax, c.getInterpolatedU(uBaseA4), c.getInterpolatedV(vBaseA4)); // A'

                tessellator.addVertexWithUV(xBaseMax, yBaseBot, zBaseMax, c.getInterpolatedU(uBaseB1), c.getInterpolatedV(vBaseB1)); // B
                tessellator.addVertexWithUV(xBaseMax, yBaseBot, zBaseMin, c.getInterpolatedU(uBaseB2), c.getInterpolatedV(vBaseB2)); // C
                tessellator.addVertexWithUV(xPlatMax, yMonoBot, zPlatMin, c.getInterpolatedU(uBaseB3), c.getInterpolatedV(vBaseB3)); // C'
                tessellator.addVertexWithUV(xPlatMax, yMonoBot, zPlatMax, c.getInterpolatedU(uBaseB4), c.getInterpolatedV(vBaseB4)); // B'

                tessellator.addVertexWithUV(xBaseMax, yBaseBot, zBaseMin, c.getInterpolatedU(uBaseA1), c.getInterpolatedV(vBaseA1)); // C
                tessellator.addVertexWithUV(xBaseMin, yBaseBot, zBaseMin, c.getInterpolatedU(uBaseA2), c.getInterpolatedV(vBaseA2)); // D
                tessellator.addVertexWithUV(xPlatMin, yMonoBot, zPlatMin, c.getInterpolatedU(uBaseA3), c.getInterpolatedV(vBaseA3)); // D'
                tessellator.addVertexWithUV(xPlatMax, yMonoBot, zPlatMin, c.getInterpolatedU(uBaseA4), c.getInterpolatedV(vBaseA4)); // C'

                tessellator.addVertexWithUV(xBaseMin, yBaseBot, zBaseMin, c.getInterpolatedU(uBaseB1), c.getInterpolatedV(vBaseB1)); // D
                tessellator.addVertexWithUV(xBaseMin, yBaseBot, zBaseMax, c.getInterpolatedU(uBaseB2), c.getInterpolatedV(vBaseB2)); // A
                tessellator.addVertexWithUV(xPlatMin, yMonoBot, zPlatMax, c.getInterpolatedU(uBaseB3), c.getInterpolatedV(vBaseB3)); // A'
                tessellator.addVertexWithUV(xPlatMin, yMonoBot, zPlatMin, c.getInterpolatedU(uBaseB4), c.getInterpolatedV(vBaseB4)); // D'

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

                // Base Plate
                tessellator.addVertexWithUV(xPlatMin, yMonoBot, zPlatMax, u, v); // A'
                tessellator.addVertexWithUV(xPlatMax, yMonoBot, zPlatMax, U, v); // B'
                tessellator.addVertexWithUV(xPlatMax, yMonoBot, zPlatMin, U, V); // C'
                tessellator.addVertexWithUV(xPlatMin, yMonoBot, zPlatMin, u, V); // D'
            }
            else if (orientation == 2) {
                // Base Faces
                tessellator.addVertexWithUV(zPlatMax, xPlatMin, 1-yMonoBot, c.getInterpolatedU(uBaseB4), c.getInterpolatedV(vBaseB4)); // A'
                tessellator.addVertexWithUV(zPlatMax, xPlatMax, 1-yMonoBot, c.getInterpolatedU(uBaseB3), c.getInterpolatedV(vBaseB3)); // B'
                tessellator.addVertexWithUV(zBaseMax, xBaseMax, 1-yBaseBot, c.getInterpolatedU(uBaseB2), c.getInterpolatedV(vBaseB2)); // B
                tessellator.addVertexWithUV(zBaseMax, xBaseMin, 1-yBaseBot, c.getInterpolatedU(uBaseB1), c.getInterpolatedV(vBaseB1)); // A

                tessellator.addVertexWithUV(zPlatMax, xPlatMax, 1-yMonoBot, c.getInterpolatedU(uBaseA4), c.getInterpolatedV(vBaseA4)); // B'
                tessellator.addVertexWithUV(zPlatMin, xPlatMax, 1-yMonoBot, c.getInterpolatedU(uBaseA3), c.getInterpolatedV(vBaseA3)); // C'
                tessellator.addVertexWithUV(zBaseMin, xBaseMax, 1-yBaseBot, c.getInterpolatedU(uBaseA2), c.getInterpolatedV(vBaseA2)); // C
                tessellator.addVertexWithUV(zBaseMax, xBaseMax, 1-yBaseBot, c.getInterpolatedU(uBaseA1), c.getInterpolatedV(vBaseA1)); // B

                tessellator.addVertexWithUV(zPlatMin, xPlatMax, 1-yMonoBot, c.getInterpolatedU(uBaseB4), c.getInterpolatedV(vBaseB4)); // C'
                tessellator.addVertexWithUV(zPlatMin, xPlatMin, 1-yMonoBot, c.getInterpolatedU(uBaseB3), c.getInterpolatedV(vBaseB3)); // D'
                tessellator.addVertexWithUV(zBaseMin, xBaseMin, 1-yBaseBot, c.getInterpolatedU(uBaseB2), c.getInterpolatedV(vBaseB2)); // D
                tessellator.addVertexWithUV(zBaseMin, xBaseMax, 1-yBaseBot, c.getInterpolatedU(uBaseB1), c.getInterpolatedV(vBaseB1)); // C

                tessellator.addVertexWithUV(zPlatMin, xPlatMin, 1-yMonoBot, c.getInterpolatedU(uBaseA4), c.getInterpolatedV(vBaseA4)); // D'
                tessellator.addVertexWithUV(zPlatMax, xPlatMin, 1-yMonoBot, c.getInterpolatedU(uBaseA3), c.getInterpolatedV(vBaseA3)); // A'
                tessellator.addVertexWithUV(zBaseMax, xBaseMin, 1-yBaseBot, c.getInterpolatedU(uBaseA2), c.getInterpolatedV(vBaseA2)); // A
                tessellator.addVertexWithUV(zBaseMin, xBaseMin, 1-yBaseBot, c.getInterpolatedU(uBaseA1), c.getInterpolatedV(vBaseA1)); // D

                // Ring Outer Faces
                tessellator.addVertexWithUV(zMonoA, xMonoA, 1-yRingTop, c.getInterpolatedU(uRingB4), c.getInterpolatedV(vRingB4)); // A'
                tessellator.addVertexWithUV(zMonoB, xMonoB, 1-yRingTop, c.getInterpolatedU(uRingB3), c.getInterpolatedV(vRingB3)); // B'
                tessellator.addVertexWithUV(zRingB, xRingB, 1-yMonoBot, c.getInterpolatedU(uRingB2), c.getInterpolatedV(vRingB2)); // B
                tessellator.addVertexWithUV(zRingA, xRingA, 1-yMonoBot, c.getInterpolatedU(uRingB1), c.getInterpolatedV(vRingB1)); // A

                tessellator.addVertexWithUV(zMonoB, xMonoB, 1-yRingTop, c.getInterpolatedU(uRingC4), c.getInterpolatedV(vRingC4)); // B'
                tessellator.addVertexWithUV(zMonoC, xMonoC, 1-yRingTop, c.getInterpolatedU(uRingC3), c.getInterpolatedV(vRingC3)); // C'
                tessellator.addVertexWithUV(zRingC, xRingC, 1-yMonoBot, c.getInterpolatedU(uRingC2), c.getInterpolatedV(vRingC2)); // C
                tessellator.addVertexWithUV(zRingB, xRingB, 1-yMonoBot, c.getInterpolatedU(uRingC1), c.getInterpolatedV(vRingC1)); // B

                tessellator.addVertexWithUV(zMonoC, xMonoC, 1-yRingTop, c.getInterpolatedU(uRingA4), c.getInterpolatedV(vRingA4)); // C'
                tessellator.addVertexWithUV(zMonoD, xMonoD, 1-yRingTop, c.getInterpolatedU(uRingA3), c.getInterpolatedV(vRingA3)); // D'
                tessellator.addVertexWithUV(zRingD, xRingD, 1-yMonoBot, c.getInterpolatedU(uRingA2), c.getInterpolatedV(vRingA2)); // D
                tessellator.addVertexWithUV(zRingC, xRingC, 1-yMonoBot, c.getInterpolatedU(uRingA1), c.getInterpolatedV(vRingA1)); // C

                tessellator.addVertexWithUV(zMonoD, xMonoD, 1-yRingTop, c.getInterpolatedU(uRingB4), c.getInterpolatedV(vRingB4)); // D'
                tessellator.addVertexWithUV(zMonoE, xMonoE, 1-yRingTop, c.getInterpolatedU(uRingB3), c.getInterpolatedV(vRingB3)); // E'
                tessellator.addVertexWithUV(zRingE, xRingE, 1-yMonoBot, c.getInterpolatedU(uRingB2), c.getInterpolatedV(vRingB2)); // E
                tessellator.addVertexWithUV(zRingD, xRingD, 1-yMonoBot, c.getInterpolatedU(uRingB1), c.getInterpolatedV(vRingB1)); // D

                tessellator.addVertexWithUV(zMonoE, xMonoE, 1-yRingTop, c.getInterpolatedU(uRingC4), c.getInterpolatedV(vRingC4)); // E'
                tessellator.addVertexWithUV(zMonoF, xMonoF, 1-yRingTop, c.getInterpolatedU(uRingC3), c.getInterpolatedV(vRingC3)); // F'
                tessellator.addVertexWithUV(zRingF, xRingF, 1-yMonoBot, c.getInterpolatedU(uRingC2), c.getInterpolatedV(vRingC2)); // F
                tessellator.addVertexWithUV(zRingE, xRingE, 1-yMonoBot, c.getInterpolatedU(uRingC1), c.getInterpolatedV(vRingC1)); // E

                tessellator.addVertexWithUV(zMonoF, xMonoF, 1-yRingTop, c.getInterpolatedU(uRingA4), c.getInterpolatedV(vRingA4)); // F'
                tessellator.addVertexWithUV(zMonoA, xMonoA, 1-yRingTop, c.getInterpolatedU(uRingA3), c.getInterpolatedV(vRingA3)); // A'
                tessellator.addVertexWithUV(zRingA, xRingA, 1-yMonoBot, c.getInterpolatedU(uRingA2), c.getInterpolatedV(vRingA2)); // A
                tessellator.addVertexWithUV(zRingF, xRingF, 1-yMonoBot, c.getInterpolatedU(uRingA1), c.getInterpolatedV(vRingA1)); // F

                // Ring Inner Faces
                tessellator.addVertexWithUV(zMonoA, xMonoA, 1-yMonoBot, c.getInterpolatedU(uRingE4), c.getInterpolatedV(vRingE4)); // A''
                tessellator.addVertexWithUV(zMonoB, xMonoB, 1-yMonoBot, c.getInterpolatedU(uRingE3), c.getInterpolatedV(vRingE3)); // B''
                tessellator.addVertexWithUV(zMonoB, xMonoB, 1-yRingTop, c.getInterpolatedU(uRingE2), c.getInterpolatedV(vRingE2)); // B'
                tessellator.addVertexWithUV(zMonoA, xMonoA, 1-yRingTop, c.getInterpolatedU(uRingE1), c.getInterpolatedV(vRingE1)); // A'

                tessellator.addVertexWithUV(zMonoB, xMonoB, 1-yMonoBot, c.getInterpolatedU(uRingF4), c.getInterpolatedV(vRingF4)); // B''
                tessellator.addVertexWithUV(zMonoC, xMonoC, 1-yMonoBot, c.getInterpolatedU(uRingF3), c.getInterpolatedV(vRingF3)); // C''
                tessellator.addVertexWithUV(zMonoC, xMonoC, 1-yRingTop, c.getInterpolatedU(uRingF2), c.getInterpolatedV(vRingF2)); // C'
                tessellator.addVertexWithUV(zMonoB, xMonoB, 1-yRingTop, c.getInterpolatedU(uRingF1), c.getInterpolatedV(vRingF1)); // B'

                tessellator.addVertexWithUV(zMonoC, xMonoC, 1-yMonoBot, c.getInterpolatedU(uRingD4), c.getInterpolatedV(vRingD4)); // C''
                tessellator.addVertexWithUV(zMonoD, xMonoD, 1-yMonoBot, c.getInterpolatedU(uRingD3), c.getInterpolatedV(vRingD3)); // D''
                tessellator.addVertexWithUV(zMonoD, xMonoD, 1-yRingTop, c.getInterpolatedU(uRingD2), c.getInterpolatedV(vRingD2)); // D'
                tessellator.addVertexWithUV(zMonoC, xMonoC, 1-yRingTop, c.getInterpolatedU(uRingD1), c.getInterpolatedV(vRingD1)); // C'

                tessellator.addVertexWithUV(zMonoD, xMonoD, 1-yMonoBot, c.getInterpolatedU(uRingE4), c.getInterpolatedV(vRingE4)); // D''
                tessellator.addVertexWithUV(zMonoE, xMonoE, 1-yMonoBot, c.getInterpolatedU(uRingE3), c.getInterpolatedV(vRingE3)); // E''
                tessellator.addVertexWithUV(zMonoE, xMonoE, 1-yRingTop, c.getInterpolatedU(uRingE2), c.getInterpolatedV(vRingE2)); // E'
                tessellator.addVertexWithUV(zMonoD, xMonoD, 1-yRingTop, c.getInterpolatedU(uRingE1), c.getInterpolatedV(vRingE1)); // D'

                tessellator.addVertexWithUV(zMonoE, xMonoE, 1-yMonoBot, c.getInterpolatedU(uRingF4), c.getInterpolatedV(vRingF4)); // E''
                tessellator.addVertexWithUV(zMonoF, xMonoF, 1-yMonoBot, c.getInterpolatedU(uRingF3), c.getInterpolatedV(vRingF3)); // F''
                tessellator.addVertexWithUV(zMonoF, xMonoF, 1-yRingTop, c.getInterpolatedU(uRingF2), c.getInterpolatedV(vRingF2)); // F'
                tessellator.addVertexWithUV(zMonoE, xMonoE, 1-yRingTop, c.getInterpolatedU(uRingF1), c.getInterpolatedV(vRingF1)); // E'

                tessellator.addVertexWithUV(zMonoF, xMonoF, 1-yMonoBot, c.getInterpolatedU(uRingD4), c.getInterpolatedV(vRingD4)); // F''
                tessellator.addVertexWithUV(zMonoA, xMonoA, 1-yMonoBot, c.getInterpolatedU(uRingD3), c.getInterpolatedV(vRingD3)); // A''
                tessellator.addVertexWithUV(zMonoA, xMonoA, 1-yRingTop, c.getInterpolatedU(uRingD2), c.getInterpolatedV(vRingD2)); // A'
                tessellator.addVertexWithUV(zMonoF, xMonoF, 1-yRingTop, c.getInterpolatedU(uRingD1), c.getInterpolatedV(vRingD1)); // F'

                c = block.getIcon(8, 0);
                double u = c.getInterpolatedU(uBaseTop);
                double U = c.getInterpolatedU(UBaseTop);
                double v = c.getInterpolatedV(vBaseTop);
                double V = c.getInterpolatedV(VBaseTop);

                // Base Plate
                tessellator.addVertexWithUV(zPlatMin, xPlatMin, 1-yMonoBot, u, V); // D'
                tessellator.addVertexWithUV(zPlatMin, xPlatMax, 1-yMonoBot, U, V); // C'
                tessellator.addVertexWithUV(zPlatMax, xPlatMax, 1-yMonoBot, U, v); // B'
                tessellator.addVertexWithUV(zPlatMax, xPlatMin, 1-yMonoBot, u, v); // A'
            }
            else if (orientation == 3) {
                // Base Faces
                tessellator.addVertexWithUV(zBaseMax, xBaseMin, yBaseBot, c.getInterpolatedU(uBaseB1), c.getInterpolatedV(vBaseB1)); // A
                tessellator.addVertexWithUV(zBaseMax, xBaseMax, yBaseBot, c.getInterpolatedU(uBaseB2), c.getInterpolatedV(vBaseB2)); // B
                tessellator.addVertexWithUV(zPlatMax, xPlatMax, yMonoBot, c.getInterpolatedU(uBaseB3), c.getInterpolatedV(vBaseB3)); // B'
                tessellator.addVertexWithUV(zPlatMax, xPlatMin, yMonoBot, c.getInterpolatedU(uBaseB4), c.getInterpolatedV(vBaseB4)); // A'

                tessellator.addVertexWithUV(zBaseMax, xBaseMax, yBaseBot, c.getInterpolatedU(uBaseA1), c.getInterpolatedV(vBaseA1)); // B
                tessellator.addVertexWithUV(zBaseMin, xBaseMax, yBaseBot, c.getInterpolatedU(uBaseA2), c.getInterpolatedV(vBaseA2)); // C
                tessellator.addVertexWithUV(zPlatMin, xPlatMax, yMonoBot, c.getInterpolatedU(uBaseA3), c.getInterpolatedV(vBaseA3)); // C'
                tessellator.addVertexWithUV(zPlatMax, xPlatMax, yMonoBot, c.getInterpolatedU(uBaseA4), c.getInterpolatedV(vBaseA4)); // B'

                tessellator.addVertexWithUV(zBaseMin, xBaseMax, yBaseBot, c.getInterpolatedU(uBaseB1), c.getInterpolatedV(vBaseB1)); // C
                tessellator.addVertexWithUV(zBaseMin, xBaseMin, yBaseBot, c.getInterpolatedU(uBaseB2), c.getInterpolatedV(vBaseB2)); // D
                tessellator.addVertexWithUV(zPlatMin, xPlatMin, yMonoBot, c.getInterpolatedU(uBaseB3), c.getInterpolatedV(vBaseB3)); // D'
                tessellator.addVertexWithUV(zPlatMin, xPlatMax, yMonoBot, c.getInterpolatedU(uBaseB4), c.getInterpolatedV(vBaseB4)); // C'

                tessellator.addVertexWithUV(zBaseMin, xBaseMin, yBaseBot, c.getInterpolatedU(uBaseA1), c.getInterpolatedV(vBaseA1)); // D
                tessellator.addVertexWithUV(zBaseMax, xBaseMin, yBaseBot, c.getInterpolatedU(uBaseA2), c.getInterpolatedV(vBaseA2)); // A
                tessellator.addVertexWithUV(zPlatMax, xPlatMin, yMonoBot, c.getInterpolatedU(uBaseA3), c.getInterpolatedV(vBaseA3)); // A'
                tessellator.addVertexWithUV(zPlatMin, xPlatMin, yMonoBot, c.getInterpolatedU(uBaseA4), c.getInterpolatedV(vBaseA4)); // D'

                // Ring Outer Faces
                tessellator.addVertexWithUV(zRingA, xRingA, yMonoBot, c.getInterpolatedU(uRingB1), c.getInterpolatedV(vRingB1)); // A
                tessellator.addVertexWithUV(zRingB, xRingB, yMonoBot, c.getInterpolatedU(uRingB2), c.getInterpolatedV(vRingB2)); // B
                tessellator.addVertexWithUV(zMonoB, xMonoB, yRingTop, c.getInterpolatedU(uRingB3), c.getInterpolatedV(vRingB3)); // B'
                tessellator.addVertexWithUV(zMonoA, xMonoA, yRingTop, c.getInterpolatedU(uRingB4), c.getInterpolatedV(vRingB4)); // A'

                tessellator.addVertexWithUV(zRingB, xRingB, yMonoBot, c.getInterpolatedU(uRingC1), c.getInterpolatedV(vRingC1)); // B
                tessellator.addVertexWithUV(zRingC, xRingC, yMonoBot, c.getInterpolatedU(uRingC2), c.getInterpolatedV(vRingC2)); // C
                tessellator.addVertexWithUV(zMonoC, xMonoC, yRingTop, c.getInterpolatedU(uRingC3), c.getInterpolatedV(vRingC3)); // C'
                tessellator.addVertexWithUV(zMonoB, xMonoB, yRingTop, c.getInterpolatedU(uRingC4), c.getInterpolatedV(vRingC4)); // B'

                tessellator.addVertexWithUV(zRingC, xRingC, yMonoBot, c.getInterpolatedU(uRingA1), c.getInterpolatedV(vRingA1)); // C
                tessellator.addVertexWithUV(zRingD, xRingD, yMonoBot, c.getInterpolatedU(uRingA2), c.getInterpolatedV(vRingA2)); // D
                tessellator.addVertexWithUV(zMonoD, xMonoD, yRingTop, c.getInterpolatedU(uRingA3), c.getInterpolatedV(vRingA3)); // D'
                tessellator.addVertexWithUV(zMonoC, xMonoC, yRingTop, c.getInterpolatedU(uRingA4), c.getInterpolatedV(vRingA4)); // C'

                tessellator.addVertexWithUV(zRingD, xRingD, yMonoBot, c.getInterpolatedU(uRingB1), c.getInterpolatedV(vRingB1)); // D
                tessellator.addVertexWithUV(zRingE, xRingE, yMonoBot, c.getInterpolatedU(uRingB2), c.getInterpolatedV(vRingB2)); // E
                tessellator.addVertexWithUV(zMonoE, xMonoE, yRingTop, c.getInterpolatedU(uRingB3), c.getInterpolatedV(vRingB3)); // E'
                tessellator.addVertexWithUV(zMonoD, xMonoD, yRingTop, c.getInterpolatedU(uRingB4), c.getInterpolatedV(vRingB4)); // D'

                tessellator.addVertexWithUV(zRingE, xRingE, yMonoBot, c.getInterpolatedU(uRingC1), c.getInterpolatedV(vRingC1)); // E
                tessellator.addVertexWithUV(zRingF, xRingF, yMonoBot, c.getInterpolatedU(uRingC2), c.getInterpolatedV(vRingC2)); // F
                tessellator.addVertexWithUV(zMonoF, xMonoF, yRingTop, c.getInterpolatedU(uRingC3), c.getInterpolatedV(vRingC3)); // F'
                tessellator.addVertexWithUV(zMonoE, xMonoE, yRingTop, c.getInterpolatedU(uRingC4), c.getInterpolatedV(vRingC4)); // E'

                tessellator.addVertexWithUV(zRingF, xRingF, yMonoBot, c.getInterpolatedU(uRingA1), c.getInterpolatedV(vRingA1)); // F
                tessellator.addVertexWithUV(zRingA, xRingA, yMonoBot, c.getInterpolatedU(uRingA2), c.getInterpolatedV(vRingA2)); // A
                tessellator.addVertexWithUV(zMonoA, xMonoA, yRingTop, c.getInterpolatedU(uRingA3), c.getInterpolatedV(vRingA3)); // A'
                tessellator.addVertexWithUV(zMonoF, xMonoF, yRingTop, c.getInterpolatedU(uRingA4), c.getInterpolatedV(vRingA4)); // F'

                // Ring Inner Faces
                tessellator.addVertexWithUV(zMonoA, xMonoA, yRingTop, c.getInterpolatedU(uRingE1), c.getInterpolatedV(vRingE1)); // A'
                tessellator.addVertexWithUV(zMonoB, xMonoB, yRingTop, c.getInterpolatedU(uRingE2), c.getInterpolatedV(vRingE2)); // B'
                tessellator.addVertexWithUV(zMonoB, xMonoB, yMonoBot, c.getInterpolatedU(uRingE3), c.getInterpolatedV(vRingE3)); // B''
                tessellator.addVertexWithUV(zMonoA, xMonoA, yMonoBot, c.getInterpolatedU(uRingE4), c.getInterpolatedV(vRingE4)); // A''

                tessellator.addVertexWithUV(zMonoB, xMonoB, yRingTop, c.getInterpolatedU(uRingF1), c.getInterpolatedV(vRingF1)); // B'
                tessellator.addVertexWithUV(zMonoC, xMonoC, yRingTop, c.getInterpolatedU(uRingF2), c.getInterpolatedV(vRingF2)); // C'
                tessellator.addVertexWithUV(zMonoC, xMonoC, yMonoBot, c.getInterpolatedU(uRingF3), c.getInterpolatedV(vRingF3)); // C''
                tessellator.addVertexWithUV(zMonoB, xMonoB, yMonoBot, c.getInterpolatedU(uRingF4), c.getInterpolatedV(vRingF4)); // B''

                tessellator.addVertexWithUV(zMonoC, xMonoC, yRingTop, c.getInterpolatedU(uRingD1), c.getInterpolatedV(vRingD1)); // C'
                tessellator.addVertexWithUV(zMonoD, xMonoD, yRingTop, c.getInterpolatedU(uRingD2), c.getInterpolatedV(vRingD2)); // D'
                tessellator.addVertexWithUV(zMonoD, xMonoD, yMonoBot, c.getInterpolatedU(uRingD3), c.getInterpolatedV(vRingD3)); // D''
                tessellator.addVertexWithUV(zMonoC, xMonoC, yMonoBot, c.getInterpolatedU(uRingD4), c.getInterpolatedV(vRingD4)); // C''

                tessellator.addVertexWithUV(zMonoD, xMonoD, yRingTop, c.getInterpolatedU(uRingE1), c.getInterpolatedV(vRingE1)); // D'
                tessellator.addVertexWithUV(zMonoE, xMonoE, yRingTop, c.getInterpolatedU(uRingE2), c.getInterpolatedV(vRingE2)); // E'
                tessellator.addVertexWithUV(zMonoE, xMonoE, yMonoBot, c.getInterpolatedU(uRingE3), c.getInterpolatedV(vRingE3)); // E''
                tessellator.addVertexWithUV(zMonoD, xMonoD, yMonoBot, c.getInterpolatedU(uRingE4), c.getInterpolatedV(vRingE4)); // D''

                tessellator.addVertexWithUV(zMonoE, xMonoE, yRingTop, c.getInterpolatedU(uRingF1), c.getInterpolatedV(vRingF1)); // E'
                tessellator.addVertexWithUV(zMonoF, xMonoF, yRingTop, c.getInterpolatedU(uRingF2), c.getInterpolatedV(vRingF2)); // F'
                tessellator.addVertexWithUV(zMonoF, xMonoF, yMonoBot, c.getInterpolatedU(uRingF3), c.getInterpolatedV(vRingF3)); // F''
                tessellator.addVertexWithUV(zMonoE, xMonoE, yMonoBot, c.getInterpolatedU(uRingF4), c.getInterpolatedV(vRingF4)); // E''

                tessellator.addVertexWithUV(zMonoF, xMonoF, yRingTop, c.getInterpolatedU(uRingD1), c.getInterpolatedV(vRingD1)); // F'
                tessellator.addVertexWithUV(zMonoA, xMonoA, yRingTop, c.getInterpolatedU(uRingD2), c.getInterpolatedV(vRingD2)); // A'
                tessellator.addVertexWithUV(zMonoA, xMonoA, yMonoBot, c.getInterpolatedU(uRingD3), c.getInterpolatedV(vRingD3)); // A''
                tessellator.addVertexWithUV(zMonoF, xMonoF, yMonoBot, c.getInterpolatedU(uRingD4), c.getInterpolatedV(vRingD4)); // F''

                c = block.getIcon(8, 0);
                double u = c.getInterpolatedU(uBaseTop);
                double U = c.getInterpolatedU(UBaseTop);
                double v = c.getInterpolatedV(vBaseTop);
                double V = c.getInterpolatedV(VBaseTop);

                // Base Plate
                tessellator.addVertexWithUV(zPlatMax, xPlatMin, yMonoBot, u, v); // A'
                tessellator.addVertexWithUV(zPlatMax, xPlatMax, yMonoBot, U, v); // B'
                tessellator.addVertexWithUV(zPlatMin, xPlatMax, yMonoBot, U, V); // C'
                tessellator.addVertexWithUV(zPlatMin, xPlatMin, yMonoBot, u, V); // D'
            }
            else if (orientation == 4) {
                // Base Faces
                tessellator.addVertexWithUV(1-yBaseBot, xBaseMin, zBaseMax, c.getInterpolatedU(uBaseA1), c.getInterpolatedV(vBaseA1)); // A
                tessellator.addVertexWithUV(1-yBaseBot, xBaseMax, zBaseMax, c.getInterpolatedU(uBaseA2), c.getInterpolatedV(vBaseA2)); // B
                tessellator.addVertexWithUV(1-yMonoBot, xPlatMax, zPlatMax, c.getInterpolatedU(uBaseA3), c.getInterpolatedV(vBaseA3)); // B'
                tessellator.addVertexWithUV(1-yMonoBot, xPlatMin, zPlatMax, c.getInterpolatedU(uBaseA4), c.getInterpolatedV(vBaseA4)); // A'

                tessellator.addVertexWithUV(1-yBaseBot, xBaseMax, zBaseMax, c.getInterpolatedU(uBaseB1), c.getInterpolatedV(vBaseB1)); // B
                tessellator.addVertexWithUV(1-yBaseBot, xBaseMax, zBaseMin, c.getInterpolatedU(uBaseB2), c.getInterpolatedV(vBaseB2)); // C
                tessellator.addVertexWithUV(1-yMonoBot, xPlatMax, zPlatMin, c.getInterpolatedU(uBaseB3), c.getInterpolatedV(vBaseB3)); // C'
                tessellator.addVertexWithUV(1-yMonoBot, xPlatMax, zPlatMax, c.getInterpolatedU(uBaseB4), c.getInterpolatedV(vBaseB4)); // B'

                tessellator.addVertexWithUV(1-yBaseBot, xBaseMax, zBaseMin, c.getInterpolatedU(uBaseA1), c.getInterpolatedV(vBaseA1)); // C
                tessellator.addVertexWithUV(1-yBaseBot, xBaseMin, zBaseMin, c.getInterpolatedU(uBaseA2), c.getInterpolatedV(vBaseA2)); // D
                tessellator.addVertexWithUV(1-yMonoBot, xPlatMin, zPlatMin, c.getInterpolatedU(uBaseA3), c.getInterpolatedV(vBaseA3)); // D'
                tessellator.addVertexWithUV(1-yMonoBot, xPlatMax, zPlatMin, c.getInterpolatedU(uBaseA4), c.getInterpolatedV(vBaseA4)); // C'

                tessellator.addVertexWithUV(1-yBaseBot, xBaseMin, zBaseMin, c.getInterpolatedU(uBaseB1), c.getInterpolatedV(vBaseB1)); // D
                tessellator.addVertexWithUV(1-yBaseBot, xBaseMin, zBaseMax, c.getInterpolatedU(uBaseB2), c.getInterpolatedV(vBaseB2)); // A
                tessellator.addVertexWithUV(1-yMonoBot, xPlatMin, zPlatMax, c.getInterpolatedU(uBaseB3), c.getInterpolatedV(vBaseB3)); // A'
                tessellator.addVertexWithUV(1-yMonoBot, xPlatMin, zPlatMin, c.getInterpolatedU(uBaseB4), c.getInterpolatedV(vBaseB4)); // D'

                // Ring Outer Faces
                tessellator.addVertexWithUV(1-yMonoBot, xRingA, zRingA, c.getInterpolatedU(uRingA1), c.getInterpolatedV(vRingA1)); // A
                tessellator.addVertexWithUV(1-yMonoBot, xRingB, zRingB, c.getInterpolatedU(uRingA2), c.getInterpolatedV(vRingA2)); // B
                tessellator.addVertexWithUV(1-yRingTop, xMonoB, zMonoB, c.getInterpolatedU(uRingA3), c.getInterpolatedV(vRingA3)); // B'
                tessellator.addVertexWithUV(1-yRingTop, xMonoA, zMonoA, c.getInterpolatedU(uRingA4), c.getInterpolatedV(vRingA4)); // A'

                tessellator.addVertexWithUV(1-yMonoBot, xRingB, zRingB, c.getInterpolatedU(uRingB1), c.getInterpolatedV(vRingB1)); // B
                tessellator.addVertexWithUV(1-yMonoBot, xRingC, zRingC, c.getInterpolatedU(uRingB2), c.getInterpolatedV(vRingB2)); // C
                tessellator.addVertexWithUV(1-yRingTop, xMonoC, zMonoC, c.getInterpolatedU(uRingB3), c.getInterpolatedV(vRingB3)); // C'
                tessellator.addVertexWithUV(1-yRingTop, xMonoB, zMonoB, c.getInterpolatedU(uRingB4), c.getInterpolatedV(vRingB4)); // B'

                tessellator.addVertexWithUV(1-yMonoBot, xRingC, zRingC, c.getInterpolatedU(uRingC1), c.getInterpolatedV(vRingC1)); // C
                tessellator.addVertexWithUV(1-yMonoBot, xRingD, zRingD, c.getInterpolatedU(uRingC2), c.getInterpolatedV(vRingC2)); // D
                tessellator.addVertexWithUV(1-yRingTop, xMonoD, zMonoD, c.getInterpolatedU(uRingC3), c.getInterpolatedV(vRingC3)); // D'
                tessellator.addVertexWithUV(1-yRingTop, xMonoC, zMonoC, c.getInterpolatedU(uRingC4), c.getInterpolatedV(vRingC4)); // C'

                tessellator.addVertexWithUV(1-yMonoBot, xRingD, zRingD, c.getInterpolatedU(uRingA1), c.getInterpolatedV(vRingA1)); // D
                tessellator.addVertexWithUV(1-yMonoBot, xRingE, zRingE, c.getInterpolatedU(uRingA2), c.getInterpolatedV(vRingA2)); // E
                tessellator.addVertexWithUV(1-yRingTop, xMonoE, zMonoE, c.getInterpolatedU(uRingA3), c.getInterpolatedV(vRingA3)); // E'
                tessellator.addVertexWithUV(1-yRingTop, xMonoD, zMonoD, c.getInterpolatedU(uRingA4), c.getInterpolatedV(vRingA4)); // D'

                tessellator.addVertexWithUV(1-yMonoBot, xRingE, zRingE, c.getInterpolatedU(uRingB1), c.getInterpolatedV(vRingB1)); // E
                tessellator.addVertexWithUV(1-yMonoBot, xRingF, zRingF, c.getInterpolatedU(uRingB2), c.getInterpolatedV(vRingB2)); // F
                tessellator.addVertexWithUV(1-yRingTop, xMonoF, zMonoF, c.getInterpolatedU(uRingB3), c.getInterpolatedV(vRingB3)); // F'
                tessellator.addVertexWithUV(1-yRingTop, xMonoE, zMonoE, c.getInterpolatedU(uRingB4), c.getInterpolatedV(vRingB4)); // E'

                tessellator.addVertexWithUV(1-yMonoBot, xRingF, zRingF, c.getInterpolatedU(uRingC1), c.getInterpolatedV(vRingC1)); // F
                tessellator.addVertexWithUV(1-yMonoBot, xRingA, zRingA, c.getInterpolatedU(uRingC2), c.getInterpolatedV(vRingC2)); // A
                tessellator.addVertexWithUV(1-yRingTop, xMonoA, zMonoA, c.getInterpolatedU(uRingC3), c.getInterpolatedV(vRingC3)); // A'
                tessellator.addVertexWithUV(1-yRingTop, xMonoF, zMonoF, c.getInterpolatedU(uRingC4), c.getInterpolatedV(vRingC4)); // F'

                // Ring Inner Faces
                tessellator.addVertexWithUV(1-yRingTop, xMonoA, zMonoA, c.getInterpolatedU(uRingD1), c.getInterpolatedV(vRingD1)); // A'
                tessellator.addVertexWithUV(1-yRingTop, xMonoB, zMonoB, c.getInterpolatedU(uRingD2), c.getInterpolatedV(vRingD2)); // B'
                tessellator.addVertexWithUV(1-yMonoBot, xMonoB, zMonoB, c.getInterpolatedU(uRingD3), c.getInterpolatedV(vRingD3)); // B''
                tessellator.addVertexWithUV(1-yMonoBot, xMonoA, zMonoA, c.getInterpolatedU(uRingD4), c.getInterpolatedV(vRingD4)); // A''

                tessellator.addVertexWithUV(1-yRingTop, xMonoB, zMonoB, c.getInterpolatedU(uRingE1), c.getInterpolatedV(vRingE1)); // B'
                tessellator.addVertexWithUV(1-yRingTop, xMonoC, zMonoC, c.getInterpolatedU(uRingE2), c.getInterpolatedV(vRingE2)); // C'
                tessellator.addVertexWithUV(1-yMonoBot, xMonoC, zMonoC, c.getInterpolatedU(uRingE3), c.getInterpolatedV(vRingE3)); // C''
                tessellator.addVertexWithUV(1-yMonoBot, xMonoB, zMonoB, c.getInterpolatedU(uRingE4), c.getInterpolatedV(vRingE4)); // B''

                tessellator.addVertexWithUV(1-yRingTop, xMonoC, zMonoC, c.getInterpolatedU(uRingF1), c.getInterpolatedV(vRingF1)); // C'
                tessellator.addVertexWithUV(1-yRingTop, xMonoD, zMonoD, c.getInterpolatedU(uRingF2), c.getInterpolatedV(vRingF2)); // D'
                tessellator.addVertexWithUV(1-yMonoBot, xMonoD, zMonoD, c.getInterpolatedU(uRingF3), c.getInterpolatedV(vRingF3)); // D''
                tessellator.addVertexWithUV(1-yMonoBot, xMonoC, zMonoC, c.getInterpolatedU(uRingF4), c.getInterpolatedV(vRingF4)); // C''

                tessellator.addVertexWithUV(1-yRingTop, xMonoD, zMonoD, c.getInterpolatedU(uRingD1), c.getInterpolatedV(vRingD1)); // D'
                tessellator.addVertexWithUV(1-yRingTop, xMonoE, zMonoE, c.getInterpolatedU(uRingD2), c.getInterpolatedV(vRingD2)); // E'
                tessellator.addVertexWithUV(1-yMonoBot, xMonoE, zMonoE, c.getInterpolatedU(uRingD3), c.getInterpolatedV(vRingD3)); // E''
                tessellator.addVertexWithUV(1-yMonoBot, xMonoD, zMonoD, c.getInterpolatedU(uRingD4), c.getInterpolatedV(vRingD4)); // D''

                tessellator.addVertexWithUV(1-yRingTop, xMonoE, zMonoE, c.getInterpolatedU(uRingE1), c.getInterpolatedV(vRingE1)); // E'
                tessellator.addVertexWithUV(1-yRingTop, xMonoF, zMonoF, c.getInterpolatedU(uRingE2), c.getInterpolatedV(vRingE2)); // F'
                tessellator.addVertexWithUV(1-yMonoBot, xMonoF, zMonoF, c.getInterpolatedU(uRingE3), c.getInterpolatedV(vRingE3)); // F''
                tessellator.addVertexWithUV(1-yMonoBot, xMonoE, zMonoE, c.getInterpolatedU(uRingE4), c.getInterpolatedV(vRingE4)); // E''

                tessellator.addVertexWithUV(1-yRingTop, xMonoF, zMonoF, c.getInterpolatedU(uRingF1), c.getInterpolatedV(vRingF1)); // F'
                tessellator.addVertexWithUV(1-yRingTop, xMonoA, zMonoA, c.getInterpolatedU(uRingF2), c.getInterpolatedV(vRingF2)); // A'
                tessellator.addVertexWithUV(1-yMonoBot, xMonoA, zMonoA, c.getInterpolatedU(uRingF3), c.getInterpolatedV(vRingF3)); // A''
                tessellator.addVertexWithUV(1-yMonoBot, xMonoF, zMonoF, c.getInterpolatedU(uRingF4), c.getInterpolatedV(vRingF4)); // F''

                c = block.getIcon(8, 0);
                double u = c.getInterpolatedU(uBaseTop);
                double U = c.getInterpolatedU(UBaseTop);
                double v = c.getInterpolatedV(vBaseTop);
                double V = c.getInterpolatedV(VBaseTop);

                // Base Plate
                tessellator.addVertexWithUV(1-yMonoBot, xPlatMin, zPlatMax, u, v); // A'
                tessellator.addVertexWithUV(1-yMonoBot, xPlatMax, zPlatMax, U, v); // B'
                tessellator.addVertexWithUV(1-yMonoBot, xPlatMax, zPlatMin, U, V); // C'
                tessellator.addVertexWithUV(1-yMonoBot, xPlatMin, zPlatMin, u, V); // D'
            }
            else if (orientation == 5) {
                // Base Faces
                tessellator.addVertexWithUV(yMonoBot, xPlatMin, zPlatMax, c.getInterpolatedU(uBaseA4), c.getInterpolatedV(vBaseA4)); // A'
                tessellator.addVertexWithUV(yMonoBot, xPlatMax, zPlatMax, c.getInterpolatedU(uBaseA3), c.getInterpolatedV(vBaseA3)); // B'
                tessellator.addVertexWithUV(yBaseBot, xBaseMax, zBaseMax, c.getInterpolatedU(uBaseA2), c.getInterpolatedV(vBaseA2)); // B
                tessellator.addVertexWithUV(yBaseBot, xBaseMin, zBaseMax, c.getInterpolatedU(uBaseA1), c.getInterpolatedV(vBaseA1)); // A

                tessellator.addVertexWithUV(yMonoBot, xPlatMax, zPlatMax, c.getInterpolatedU(uBaseB4), c.getInterpolatedV(vBaseB4)); // B'
                tessellator.addVertexWithUV(yMonoBot, xPlatMax, zPlatMin, c.getInterpolatedU(uBaseB3), c.getInterpolatedV(vBaseB3)); // C'
                tessellator.addVertexWithUV(yBaseBot, xBaseMax, zBaseMin, c.getInterpolatedU(uBaseB2), c.getInterpolatedV(vBaseB2)); // C
                tessellator.addVertexWithUV(yBaseBot, xBaseMax, zBaseMax, c.getInterpolatedU(uBaseB1), c.getInterpolatedV(vBaseB1)); // B

                tessellator.addVertexWithUV(yMonoBot, xPlatMax, zPlatMin, c.getInterpolatedU(uBaseA4), c.getInterpolatedV(vBaseA4)); // C'
                tessellator.addVertexWithUV(yMonoBot, xPlatMin, zPlatMin, c.getInterpolatedU(uBaseA3), c.getInterpolatedV(vBaseA3)); // D'
                tessellator.addVertexWithUV(yBaseBot, xBaseMin, zBaseMin, c.getInterpolatedU(uBaseA2), c.getInterpolatedV(vBaseA2)); // D
                tessellator.addVertexWithUV(yBaseBot, xBaseMax, zBaseMin, c.getInterpolatedU(uBaseA1), c.getInterpolatedV(vBaseA1)); // C

                tessellator.addVertexWithUV(yMonoBot, xPlatMin, zPlatMin, c.getInterpolatedU(uBaseB4), c.getInterpolatedV(vBaseB4)); // D'
                tessellator.addVertexWithUV(yMonoBot, xPlatMin, zPlatMax, c.getInterpolatedU(uBaseB3), c.getInterpolatedV(vBaseB3)); // A'
                tessellator.addVertexWithUV(yBaseBot, xBaseMin, zBaseMax, c.getInterpolatedU(uBaseB2), c.getInterpolatedV(vBaseB2)); // A
                tessellator.addVertexWithUV(yBaseBot, xBaseMin, zBaseMin, c.getInterpolatedU(uBaseB1), c.getInterpolatedV(vBaseB1)); // D

                // Ring Outer Faces
                tessellator.addVertexWithUV(yRingTop, xMonoA, zMonoA, c.getInterpolatedU(uRingA4), c.getInterpolatedV(vRingA4)); // A'
                tessellator.addVertexWithUV(yRingTop, xMonoB, zMonoB, c.getInterpolatedU(uRingA3), c.getInterpolatedV(vRingA3)); // B'
                tessellator.addVertexWithUV(yMonoBot, xRingB, zRingB, c.getInterpolatedU(uRingA2), c.getInterpolatedV(vRingA2)); // B
                tessellator.addVertexWithUV(yMonoBot, xRingA, zRingA, c.getInterpolatedU(uRingA1), c.getInterpolatedV(vRingA1)); // A

                tessellator.addVertexWithUV(yRingTop, xMonoB, zMonoB, c.getInterpolatedU(uRingB4), c.getInterpolatedV(vRingB4)); // B'
                tessellator.addVertexWithUV(yRingTop, xMonoC, zMonoC, c.getInterpolatedU(uRingB3), c.getInterpolatedV(vRingB3)); // C'
                tessellator.addVertexWithUV(yMonoBot, xRingC, zRingC, c.getInterpolatedU(uRingB2), c.getInterpolatedV(vRingB2)); // C
                tessellator.addVertexWithUV(yMonoBot, xRingB, zRingB, c.getInterpolatedU(uRingB1), c.getInterpolatedV(vRingB1)); // B

                tessellator.addVertexWithUV(yRingTop, xMonoC, zMonoC, c.getInterpolatedU(uRingC4), c.getInterpolatedV(vRingC4)); // C'
                tessellator.addVertexWithUV(yRingTop, xMonoD, zMonoD, c.getInterpolatedU(uRingC3), c.getInterpolatedV(vRingC3)); // D'
                tessellator.addVertexWithUV(yMonoBot, xRingD, zRingD, c.getInterpolatedU(uRingC2), c.getInterpolatedV(vRingC2)); // D
                tessellator.addVertexWithUV(yMonoBot, xRingC, zRingC, c.getInterpolatedU(uRingC1), c.getInterpolatedV(vRingC1)); // C

                tessellator.addVertexWithUV(yRingTop, xMonoD, zMonoD, c.getInterpolatedU(uRingA4), c.getInterpolatedV(vRingA4)); // D'
                tessellator.addVertexWithUV(yRingTop, xMonoE, zMonoE, c.getInterpolatedU(uRingA3), c.getInterpolatedV(vRingA3)); // E'
                tessellator.addVertexWithUV(yMonoBot, xRingE, zRingE, c.getInterpolatedU(uRingA2), c.getInterpolatedV(vRingA2)); // E
                tessellator.addVertexWithUV(yMonoBot, xRingD, zRingD, c.getInterpolatedU(uRingA1), c.getInterpolatedV(vRingA1)); // D

                tessellator.addVertexWithUV(yRingTop, xMonoE, zMonoE, c.getInterpolatedU(uRingB4), c.getInterpolatedV(vRingB4)); // E'
                tessellator.addVertexWithUV(yRingTop, xMonoF, zMonoF, c.getInterpolatedU(uRingB3), c.getInterpolatedV(vRingB3)); // F'
                tessellator.addVertexWithUV(yMonoBot, xRingF, zRingF, c.getInterpolatedU(uRingB2), c.getInterpolatedV(vRingB2)); // F
                tessellator.addVertexWithUV(yMonoBot, xRingE, zRingE, c.getInterpolatedU(uRingB1), c.getInterpolatedV(vRingB1)); // E

                tessellator.addVertexWithUV(yRingTop, xMonoF, zMonoF, c.getInterpolatedU(uRingC4), c.getInterpolatedV(vRingC4)); // F'
                tessellator.addVertexWithUV(yRingTop, xMonoA, zMonoA, c.getInterpolatedU(uRingC3), c.getInterpolatedV(vRingC3)); // A'
                tessellator.addVertexWithUV(yMonoBot, xRingA, zRingA, c.getInterpolatedU(uRingC2), c.getInterpolatedV(vRingC2)); // A
                tessellator.addVertexWithUV(yMonoBot, xRingF, zRingF, c.getInterpolatedU(uRingC1), c.getInterpolatedV(vRingC1)); // F

                // Ring Inner Faces
                tessellator.addVertexWithUV(yMonoBot, xMonoA, zMonoA, c.getInterpolatedU(uRingD4), c.getInterpolatedV(vRingD4)); // A''
                tessellator.addVertexWithUV(yMonoBot, xMonoB, zMonoB, c.getInterpolatedU(uRingD3), c.getInterpolatedV(vRingD3)); // B''
                tessellator.addVertexWithUV(yRingTop, xMonoB, zMonoB, c.getInterpolatedU(uRingD2), c.getInterpolatedV(vRingD2)); // B'
                tessellator.addVertexWithUV(yRingTop, xMonoA, zMonoA, c.getInterpolatedU(uRingD1), c.getInterpolatedV(vRingD1)); // A'

                tessellator.addVertexWithUV(yMonoBot, xMonoB, zMonoB, c.getInterpolatedU(uRingE4), c.getInterpolatedV(vRingE4)); // B''
                tessellator.addVertexWithUV(yMonoBot, xMonoC, zMonoC, c.getInterpolatedU(uRingE3), c.getInterpolatedV(vRingE3)); // C''
                tessellator.addVertexWithUV(yRingTop, xMonoC, zMonoC, c.getInterpolatedU(uRingE2), c.getInterpolatedV(vRingE2)); // C'
                tessellator.addVertexWithUV(yRingTop, xMonoB, zMonoB, c.getInterpolatedU(uRingE1), c.getInterpolatedV(vRingE1)); // B'

                tessellator.addVertexWithUV(yMonoBot, xMonoC, zMonoC, c.getInterpolatedU(uRingF4), c.getInterpolatedV(vRingF4)); // C''
                tessellator.addVertexWithUV(yMonoBot, xMonoD, zMonoD, c.getInterpolatedU(uRingF3), c.getInterpolatedV(vRingF3)); // D''
                tessellator.addVertexWithUV(yRingTop, xMonoD, zMonoD, c.getInterpolatedU(uRingF2), c.getInterpolatedV(vRingF2)); // D'
                tessellator.addVertexWithUV(yRingTop, xMonoC, zMonoC, c.getInterpolatedU(uRingF1), c.getInterpolatedV(vRingF1)); // C'

                tessellator.addVertexWithUV(yMonoBot, xMonoD, zMonoD, c.getInterpolatedU(uRingD4), c.getInterpolatedV(vRingD4)); // D''
                tessellator.addVertexWithUV(yMonoBot, xMonoE, zMonoE, c.getInterpolatedU(uRingD3), c.getInterpolatedV(vRingD3)); // E''
                tessellator.addVertexWithUV(yRingTop, xMonoE, zMonoE, c.getInterpolatedU(uRingD2), c.getInterpolatedV(vRingD2)); // E'
                tessellator.addVertexWithUV(yRingTop, xMonoD, zMonoD, c.getInterpolatedU(uRingD1), c.getInterpolatedV(vRingD1)); // D'

                tessellator.addVertexWithUV(yMonoBot, xMonoE, zMonoE, c.getInterpolatedU(uRingE4), c.getInterpolatedV(vRingE4)); // E''
                tessellator.addVertexWithUV(yMonoBot, xMonoF, zMonoF, c.getInterpolatedU(uRingE3), c.getInterpolatedV(vRingE3)); // F''
                tessellator.addVertexWithUV(yRingTop, xMonoF, zMonoF, c.getInterpolatedU(uRingE2), c.getInterpolatedV(vRingE2)); // F'
                tessellator.addVertexWithUV(yRingTop, xMonoE, zMonoE, c.getInterpolatedU(uRingE1), c.getInterpolatedV(vRingE1)); // E'

                tessellator.addVertexWithUV(yMonoBot, xMonoF, zMonoF, c.getInterpolatedU(uRingF4), c.getInterpolatedV(vRingF4)); // F''
                tessellator.addVertexWithUV(yMonoBot, xMonoA, zMonoA, c.getInterpolatedU(uRingF3), c.getInterpolatedV(vRingF3)); // A''
                tessellator.addVertexWithUV(yRingTop, xMonoA, zMonoA, c.getInterpolatedU(uRingF2), c.getInterpolatedV(vRingF2)); // A'
                tessellator.addVertexWithUV(yRingTop, xMonoF, zMonoF, c.getInterpolatedU(uRingF1), c.getInterpolatedV(vRingF1)); // F'

                c = block.getIcon(8, 0);
                double u = c.getInterpolatedU(uBaseTop);
                double U = c.getInterpolatedU(UBaseTop);
                double v = c.getInterpolatedV(vBaseTop);
                double V = c.getInterpolatedV(VBaseTop);

                // Base Plate
                tessellator.addVertexWithUV(yMonoBot, xPlatMin, zPlatMin, u, V); // D'
                tessellator.addVertexWithUV(yMonoBot, xPlatMax, zPlatMin, U, V); // C'
                tessellator.addVertexWithUV(yMonoBot, xPlatMax, zPlatMax, U, v); // B'
                tessellator.addVertexWithUV(yMonoBot, xPlatMin, zPlatMax, u, v); // A'
            }

            // If there is a monolith...
            if (monolith != 0 && state) {
                /* Beams */
                if (tileEnergyPylon.getPylons() != null) {
                    // Prepare the icon variables.
                    double u;
                    double U;
                    double v;
                    double V;

                    // Prepare the brightness.
                    tessellator.setBrightness(brightness);

                    // Go through each pylon entry.
                    for (HexPylon entry : tileEnergyPylon.getPylons()) {
                        int monolithEntry = monolith;
                        if (HexUtils.checkChunk(tileEnergyPylon.getWorldObj(), entry.x, entry.z)) {
                            TileEnergyPylon tileEnergyPylonEntry = (TileEnergyPylon) tileEnergyPylon.getWorldObj().getTileEntity(entry.x, entry.y, entry.z);
                            if (tileEnergyPylonEntry != null)
                                monolithEntry = tileEnergyPylonEntry.getMonolith();
                        }

                        // Check if the target pylon is ON.
                        if (!HexUtils.getMetaBit(BlockEnergyPylon.META_STATE, world, entry.x, entry.y, entry.z)) {
                            // Check if both of the pylons are rainbow.
                            if (monolith == 18 && monolithEntry == 18) {
                                // If they are, set the rainbow texture.
                                tessellator.setColorOpaque_F(HexColors.COLOR_WHITE_R, HexColors.COLOR_WHITE_G, HexColors.COLOR_WHITE_B);
                                c = block.getIcon(11, 0);
                                u = c.getMinU();
                                U = c.getMaxU();
                                v = c.getMinV();
                                V = c.getMaxV();
                            }
                            else if (monolith == 18) {
                                // If this is rainbow and target is not, use target color.
                                float tr = HexColors.COLOR_WHITE_R;
                                float tg = HexColors.COLOR_WHITE_G;
                                float tb = HexColors.COLOR_WHITE_B;
                                if (monolithEntry == 1) {
                                    tr = HexColors.COLOR_RED_R;
                                    tg = HexColors.COLOR_RED_G;
                                    tb = HexColors.COLOR_RED_B;
                                }
                                else if (monolithEntry == 2) {
                                    tr = HexColors.COLOR_ORANGE_R;
                                    tg = HexColors.COLOR_ORANGE_G;
                                    tb = HexColors.COLOR_ORANGE_B;
                                }
                                else if (monolithEntry == 3) {
                                    tr = HexColors.COLOR_YELLOW_R;
                                    tg = HexColors.COLOR_YELLOW_G;
                                    tb = HexColors.COLOR_YELLOW_B;
                                }
                                else if (monolithEntry == 4) {
                                    tr = HexColors.COLOR_LIME_R;
                                    tg = HexColors.COLOR_LIME_G;
                                    tb = HexColors.COLOR_LIME_B;
                                }
                                else if (monolithEntry == 5) {
                                    tr = HexColors.COLOR_GREEN_R;
                                    tg = HexColors.COLOR_GREEN_G;
                                    tb = HexColors.COLOR_GREEN_B;
                                }
                                else if (monolithEntry == 6) {
                                    tr = HexColors.COLOR_TORQUOISE_R;
                                    tg = HexColors.COLOR_TORQUOISE_G;
                                    tb = HexColors.COLOR_TORQUOISE_B;
                                }
                                else if (monolithEntry == 7) {
                                    tr = HexColors.COLOR_CYAN_R;
                                    tg = HexColors.COLOR_CYAN_G;
                                    tb = HexColors.COLOR_CYAN_B;
                                }
                                else if (monolithEntry == 8) {
                                    tr = HexColors.COLOR_SKY_BLUE_R;
                                    tg = HexColors.COLOR_SKY_BLUE_G;
                                    tb = HexColors.COLOR_SKY_BLUE_B;
                                }
                                else if (monolithEntry == 9) {
                                    tr = HexColors.COLOR_BLUE_R;
                                    tg = HexColors.COLOR_BLUE_G;
                                    tb = HexColors.COLOR_BLUE_B;
                                }
                                else if (monolithEntry == 10) {
                                    tr = HexColors.COLOR_PURPLE_R;
                                    tg = HexColors.COLOR_PURPLE_G;
                                    tb = HexColors.COLOR_PURPLE_B;
                                }
                                else if (monolithEntry == 11) {
                                    tr = HexColors.COLOR_MAGENTA_R;
                                    tg = HexColors.COLOR_MAGENTA_G;
                                    tb = HexColors.COLOR_MAGENTA_B;
                                }
                                else if (monolithEntry == 12) {
                                    tr = HexColors.COLOR_PINK_R;
                                    tg = HexColors.COLOR_PINK_G;
                                    tb = HexColors.COLOR_PINK_B;
                                }
                                else if (monolithEntry == 13) {
                                    tr = HexColors.COLOR_WHITE_R;
                                    tg = HexColors.COLOR_WHITE_G;
                                    tb = HexColors.COLOR_WHITE_B;
                                }
                                else if (monolithEntry == 14) {
                                    tr = HexColors.COLOR_LIGHT_GRAY_R;
                                    tg = HexColors.COLOR_LIGHT_GRAY_G;
                                    tb = HexColors.COLOR_LIGHT_GRAY_B;
                                }
                                else if (monolithEntry == 15) {
                                    tr = HexColors.COLOR_GRAY_R;
                                    tg = HexColors.COLOR_GRAY_G;
                                    tb = HexColors.COLOR_GRAY_B;
                                }
                                else if (monolithEntry == 16) {
                                    tr = HexColors.COLOR_DARK_GRAY_R;
                                    tg = HexColors.COLOR_DARK_GRAY_G;
                                    tb = HexColors.COLOR_DARK_GRAY_B;
                                }
                                else if (monolithEntry == 17) {
                                    tr = HexColors.COLOR_BLACK_R;
                                    tg = HexColors.COLOR_BLACK_G;
                                    tb = HexColors.COLOR_BLACK_B;
                                }
                                tessellator.setColorOpaque_F(tr, tg, tb);
                                c = block.getIcon(10, 0);
                                u = c.getMinU();
                                U = c.getMaxU();
                                v = c.getMinV();
                                V = c.getMaxV();
                            }
                            else {
                                // Otherwise, set the color normally.
                                tessellator.setColorOpaque_F(r, g, b);
                                c = block.getIcon(10, 0);
                                u = c.getMinU();
                                U = c.getMaxU();
                                v = c.getMinV();
                                V = c.getMaxV();
                            }

                            // Create the vector from pylon A to pylon B.
                            Vec3 vec0 = Vec3.createVectorHelper(x, y, z).subtract(Vec3.createVectorHelper(entry.x, entry.y, entry.z));

                            // Prepare additional vectors.
                            Vec3 vec2;
                            Vec3 vec3;
                            Vec3 vec4;
                            Vec3 vec5;

                            // If the pylons are exactly above each other...
                            if (vec0.xCoord == 0 && vec0.yCoord != 0 && vec0.zCoord == 0) {
                                // Create start vectors.
                                vec2 = Vec3.createVectorHelper(beamRadius, 0, 0); // A
                                vec2 = centerVector(vec2);

                                vec3 = Vec3.createVectorHelper(0, 0, beamRadius); // B
                                vec3 = centerVector(vec3);

                                vec4 = Vec3.createVectorHelper(-beamRadius, 0, 0); // C
                                vec4 = centerVector(vec4);

                                vec5 = Vec3.createVectorHelper(0, 0, -beamRadius); // D
                                vec5 = centerVector(vec5);
                            }
                            else {
                                // Create helper vector.
                                Vec3 vec1 = Vec3.createVectorHelper(vec0.xCoord, vec0.yCoord, vec0.zCoord);
                                vec1.rotateAroundY((float) -Math.PI / 2);
                                vec1.yCoord = 0;

                                // Create start vectors.
                                vec2 = Vec3.createVectorHelper(vec1.xCoord, vec1.yCoord, vec1.zCoord); // A
                                vec2 = vec2.normalize();
                                vec2 = scaleVector(vec2, beamRadius / 2);
                                vec2 = centerVector(vec2);

                                vec3 = vec1.crossProduct(vec0); // B
                                vec3 = vec3.normalize();
                                vec3 = scaleVector(vec3, beamRadius / 2);
                                vec3 = centerVector(vec3);

                                vec4 = Vec3.createVectorHelper(vec1.xCoord, vec1.yCoord, vec1.zCoord); // C
                                vec4 = vec4.normalize();
                                vec4 = scaleVector(vec4, -beamRadius / 2);
                                vec4 = centerVector(vec4);

                                vec5 = vec1.crossProduct(vec0); // D
                                vec5 = vec5.normalize();
                                vec5 = scaleVector(vec5, -beamRadius / 2);
                                vec5 = centerVector(vec5);
                            }

                            // Create destination vectors.
                            Vec3 vec6 = vec2.addVector(vec0.xCoord, vec0.yCoord, vec0.zCoord); // A'
                            Vec3 vec7 = vec3.addVector(vec0.xCoord, vec0.yCoord, vec0.zCoord); // B'
                            Vec3 vec8 = vec4.addVector(vec0.xCoord, vec0.yCoord, vec0.zCoord); // C'
                            Vec3 vec9 = vec5.addVector(vec0.xCoord, vec0.yCoord, vec0.zCoord); // D'

                            // Draw the beam.
                            tessellator.addVertexWithUV(vec2.xCoord, vec2.yCoord, vec2.zCoord, u, v); // A
                            tessellator.addVertexWithUV(vec6.xCoord, vec6.yCoord, vec6.zCoord, U, v); // A'
                            tessellator.addVertexWithUV(vec7.xCoord, vec7.yCoord, vec7.zCoord, U, V); // B'
                            tessellator.addVertexWithUV(vec3.xCoord, vec3.yCoord, vec3.zCoord, u, V); // B

                            tessellator.addVertexWithUV(vec3.xCoord, vec3.yCoord, vec3.zCoord, u, V); // B
                            tessellator.addVertexWithUV(vec7.xCoord, vec7.yCoord, vec7.zCoord, U, V); // B'
                            tessellator.addVertexWithUV(vec8.xCoord, vec8.yCoord, vec8.zCoord, U, v); // C'
                            tessellator.addVertexWithUV(vec4.xCoord, vec4.yCoord, vec4.zCoord, u, v); // C

                            tessellator.addVertexWithUV(vec4.xCoord, vec4.yCoord, vec4.zCoord, u, v); // C
                            tessellator.addVertexWithUV(vec8.xCoord, vec8.yCoord, vec8.zCoord, U, v); // C'
                            tessellator.addVertexWithUV(vec9.xCoord, vec9.yCoord, vec9.zCoord, U, V); // D'
                            tessellator.addVertexWithUV(vec5.xCoord, vec5.yCoord, vec5.zCoord, u, V); // D

                            tessellator.addVertexWithUV(vec5.xCoord, vec5.yCoord, vec5.zCoord, u, V); // D
                            tessellator.addVertexWithUV(vec9.xCoord, vec9.yCoord, vec9.zCoord, U, V); // D'
                            tessellator.addVertexWithUV(vec6.xCoord, vec6.yCoord, vec6.zCoord, U, v); // A'
                            tessellator.addVertexWithUV(vec2.xCoord, vec2.yCoord, vec2.zCoord, u, v); // A
                        }
                    }
                }
            }

            tessellator.addTranslation(-x, -y, -z);
        }
        // If this is the second (transparent) render pass...
        else {
            // If there is a monolith...
            if (monolith != 0) {
                /* Monolith */
                // Prepare the Tessellator.
                Tessellator tessellator = Tessellator.instance;
                tessellator.addTranslation(x, y, z);

                // Prepare the icon.
                double u = c.getInterpolatedU(uMonoSide);
                double U = c.getInterpolatedU(UMonoSide);
                double v = c.getInterpolatedV(vMonoSide);
                double V = c.getInterpolatedV(VMonoSide);

                // Set up brightness and color.
                tessellator.setBrightness(brightness);
                if (state)
                    tessellator.setColorRGBA_F(r, g, b, opacity);
                else
                    tessellator.setColorRGBA_F(r * darkMonolith, g * darkMonolith, b * darkMonolith, opacity);

                // Render the monolith.
                if (orientation == 0) {
                    // Top Face
                    tessellator.addVertexWithUV(xMonoA, 1 - yMonoTop, zMonoA, c.getInterpolatedU(uMonoTopA), c.getInterpolatedV(vMonoTopA)); // A
                    tessellator.addVertexWithUV(xMonoD, 1 - yMonoTop, zMonoD, c.getInterpolatedU(uMonoTopD), c.getInterpolatedV(vMonoTopD)); // D
                    tessellator.addVertexWithUV(xMonoC, 1 - yMonoTop, zMonoC, c.getInterpolatedU(uMonoTopC), c.getInterpolatedV(vMonoTopC)); // C
                    tessellator.addVertexWithUV(xMonoB, 1 - yMonoTop, zMonoB, c.getInterpolatedU(uMonoTopB), c.getInterpolatedV(vMonoTopB)); // B

                    tessellator.addVertexWithUV(xMonoF, 1 - yMonoTop, zMonoF, c.getInterpolatedU(uMonoTopF), c.getInterpolatedV(vMonoTopF)); // F
                    tessellator.addVertexWithUV(xMonoE, 1 - yMonoTop, zMonoE, c.getInterpolatedU(uMonoTopE), c.getInterpolatedV(vMonoTopE)); // E
                    tessellator.addVertexWithUV(xMonoD, 1 - yMonoTop, zMonoD, c.getInterpolatedU(uMonoTopD), c.getInterpolatedV(vMonoTopD)); // D
                    tessellator.addVertexWithUV(xMonoA, 1 - yMonoTop, zMonoA, c.getInterpolatedU(uMonoTopA), c.getInterpolatedV(vMonoTopA)); // A

                    // Side Faces
                    tessellator.addVertexWithUV(xMonoF, 1 - yMonoBot, zMonoF, u, V); // F'
                    tessellator.addVertexWithUV(xMonoE, 1 - yMonoBot, zMonoE, U, V); // E'
                    tessellator.addVertexWithUV(xMonoE, 1 - yMonoTop, zMonoE, U, v); // E
                    tessellator.addVertexWithUV(xMonoF, 1 - yMonoTop, zMonoF, u, v); // F

                    tessellator.addVertexWithUV(xMonoE, 1 - yMonoBot, zMonoE, u, V); // E'
                    tessellator.addVertexWithUV(xMonoD, 1 - yMonoBot, zMonoD, U, V); // D'
                    tessellator.addVertexWithUV(xMonoD, 1 - yMonoTop, zMonoD, U, v); // D
                    tessellator.addVertexWithUV(xMonoE, 1 - yMonoTop, zMonoE, u, v); // E

                    tessellator.addVertexWithUV(xMonoD, 1 - yMonoBot, zMonoD, u, V); // D'
                    tessellator.addVertexWithUV(xMonoC, 1 - yMonoBot, zMonoC, U, V); // C'
                    tessellator.addVertexWithUV(xMonoC, 1 - yMonoTop, zMonoC, U, v); // C
                    tessellator.addVertexWithUV(xMonoD, 1 - yMonoTop, zMonoD, u, v); // D

                    tessellator.addVertexWithUV(xMonoC, 1 - yMonoBot, zMonoC, u, V); // C'
                    tessellator.addVertexWithUV(xMonoB, 1 - yMonoBot, zMonoB, U, V); // B'
                    tessellator.addVertexWithUV(xMonoB, 1 - yMonoTop, zMonoB, U, v); // B
                    tessellator.addVertexWithUV(xMonoC, 1 - yMonoTop, zMonoC, u, v); // C

                    tessellator.addVertexWithUV(xMonoB, 1 - yMonoBot, zMonoB, u, V); // B'
                    tessellator.addVertexWithUV(xMonoA, 1 - yMonoBot, zMonoA, U, V); // A'
                    tessellator.addVertexWithUV(xMonoA, 1 - yMonoTop, zMonoA, U, v); // A
                    tessellator.addVertexWithUV(xMonoB, 1 - yMonoTop, zMonoB, u, v); // B

                    tessellator.addVertexWithUV(xMonoA, 1 - yMonoBot, zMonoA, u, V); // A'
                    tessellator.addVertexWithUV(xMonoF, 1 - yMonoBot, zMonoF, U, V); // F'
                    tessellator.addVertexWithUV(xMonoF, 1 - yMonoTop, zMonoF, U, v); // F
                    tessellator.addVertexWithUV(xMonoA, 1 - yMonoTop, zMonoA, u, v); // A
                }
                else if (orientation == 1) {
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
                }
                else if (orientation == 2) {
                    // Top Face
                    tessellator.addVertexWithUV(zMonoA, xMonoA, 1 - yMonoTop, c.getInterpolatedU(uMonoTopA), c.getInterpolatedV(vMonoTopA)); // A
                    tessellator.addVertexWithUV(zMonoD, xMonoD, 1 - yMonoTop, c.getInterpolatedU(uMonoTopD), c.getInterpolatedV(vMonoTopD)); // D
                    tessellator.addVertexWithUV(zMonoC, xMonoC, 1 - yMonoTop, c.getInterpolatedU(uMonoTopC), c.getInterpolatedV(vMonoTopC)); // C
                    tessellator.addVertexWithUV(zMonoB, xMonoB, 1 - yMonoTop, c.getInterpolatedU(uMonoTopB), c.getInterpolatedV(vMonoTopB)); // B

                    tessellator.addVertexWithUV(zMonoF, xMonoF, 1 - yMonoTop, c.getInterpolatedU(uMonoTopF), c.getInterpolatedV(vMonoTopF)); // F
                    tessellator.addVertexWithUV(zMonoE, xMonoE, 1 - yMonoTop, c.getInterpolatedU(uMonoTopE), c.getInterpolatedV(vMonoTopE)); // E
                    tessellator.addVertexWithUV(zMonoD, xMonoD, 1 - yMonoTop, c.getInterpolatedU(uMonoTopD), c.getInterpolatedV(vMonoTopD)); // D
                    tessellator.addVertexWithUV(zMonoA, xMonoA, 1 - yMonoTop, c.getInterpolatedU(uMonoTopA), c.getInterpolatedV(vMonoTopA)); // A

                    // Side Faces
                    tessellator.addVertexWithUV(zMonoF, xMonoF, 1 - yMonoBot, u, V); // F'
                    tessellator.addVertexWithUV(zMonoE, xMonoE, 1 - yMonoBot, U, V); // E'
                    tessellator.addVertexWithUV(zMonoE, xMonoE, 1 - yMonoTop, U, v); // E
                    tessellator.addVertexWithUV(zMonoF, xMonoF, 1 - yMonoTop, u, v); // F

                    tessellator.addVertexWithUV(zMonoE, xMonoE, 1 - yMonoBot, u, V); // E'
                    tessellator.addVertexWithUV(zMonoD, xMonoD, 1 - yMonoBot, U, V); // D'
                    tessellator.addVertexWithUV(zMonoD, xMonoD, 1 - yMonoTop, U, v); // D
                    tessellator.addVertexWithUV(zMonoE, xMonoE, 1 - yMonoTop, u, v); // E

                    tessellator.addVertexWithUV(zMonoD, xMonoD, 1 - yMonoBot, u, V); // D'
                    tessellator.addVertexWithUV(zMonoC, xMonoC, 1 - yMonoBot, U, V); // C'
                    tessellator.addVertexWithUV(zMonoC, xMonoC, 1 - yMonoTop, U, v); // C
                    tessellator.addVertexWithUV(zMonoD, xMonoD, 1 - yMonoTop, u, v); // D

                    tessellator.addVertexWithUV(zMonoC, xMonoC, 1 - yMonoBot, u, V); // C'
                    tessellator.addVertexWithUV(zMonoB, xMonoB, 1 - yMonoBot, U, V); // B'
                    tessellator.addVertexWithUV(zMonoB, xMonoB, 1 - yMonoTop, U, v); // B
                    tessellator.addVertexWithUV(zMonoC, xMonoC, 1 - yMonoTop, u, v); // C

                    tessellator.addVertexWithUV(zMonoB, xMonoB, 1 - yMonoBot, u, V); // B'
                    tessellator.addVertexWithUV(zMonoA, xMonoA, 1 - yMonoBot, U, V); // A'
                    tessellator.addVertexWithUV(zMonoA, xMonoA, 1 - yMonoTop, U, v); // A
                    tessellator.addVertexWithUV(zMonoB, xMonoB, 1 - yMonoTop, u, v); // B

                    tessellator.addVertexWithUV(zMonoA, xMonoA, 1 - yMonoBot, u, V); // A'
                    tessellator.addVertexWithUV(zMonoF, xMonoF, 1 - yMonoBot, U, V); // F'
                    tessellator.addVertexWithUV(zMonoF, xMonoF, 1 - yMonoTop, U, v); // F
                    tessellator.addVertexWithUV(zMonoA, xMonoA, 1 - yMonoTop, u, v); // A
                }
                else if (orientation == 3) {
                    // Top Face
                    tessellator.addVertexWithUV(zMonoB, xMonoB, yMonoTop, c.getInterpolatedU(uMonoTopB), c.getInterpolatedV(vMonoTopB)); // B
                    tessellator.addVertexWithUV(zMonoC, xMonoC, yMonoTop, c.getInterpolatedU(uMonoTopC), c.getInterpolatedV(vMonoTopC)); // C
                    tessellator.addVertexWithUV(zMonoD, xMonoD, yMonoTop, c.getInterpolatedU(uMonoTopD), c.getInterpolatedV(vMonoTopD)); // D
                    tessellator.addVertexWithUV(zMonoA, xMonoA, yMonoTop, c.getInterpolatedU(uMonoTopA), c.getInterpolatedV(vMonoTopA)); // A

                    tessellator.addVertexWithUV(zMonoA, xMonoA, yMonoTop, c.getInterpolatedU(uMonoTopA), c.getInterpolatedV(vMonoTopA)); // A
                    tessellator.addVertexWithUV(zMonoD, xMonoD, yMonoTop, c.getInterpolatedU(uMonoTopD), c.getInterpolatedV(vMonoTopD)); // D
                    tessellator.addVertexWithUV(zMonoE, xMonoE, yMonoTop, c.getInterpolatedU(uMonoTopE), c.getInterpolatedV(vMonoTopE)); // E
                    tessellator.addVertexWithUV(zMonoF, xMonoF, yMonoTop, c.getInterpolatedU(uMonoTopF), c.getInterpolatedV(vMonoTopF)); // F

                    // Side Faces
                    tessellator.addVertexWithUV(zMonoF, xMonoF, yMonoTop, u, v); // F
                    tessellator.addVertexWithUV(zMonoE, xMonoE, yMonoTop, U, v); // E
                    tessellator.addVertexWithUV(zMonoE, xMonoE, yMonoBot, U, V); // E'
                    tessellator.addVertexWithUV(zMonoF, xMonoF, yMonoBot, u, V); // F'

                    tessellator.addVertexWithUV(zMonoE, xMonoE, yMonoTop, u, v); // E
                    tessellator.addVertexWithUV(zMonoD, xMonoD, yMonoTop, U, v); // D
                    tessellator.addVertexWithUV(zMonoD, xMonoD, yMonoBot, U, V); // D'
                    tessellator.addVertexWithUV(zMonoE, xMonoE, yMonoBot, u, V); // E'

                    tessellator.addVertexWithUV(zMonoD, xMonoD, yMonoTop, u, v); // D
                    tessellator.addVertexWithUV(zMonoC, xMonoC, yMonoTop, U, v); // C
                    tessellator.addVertexWithUV(zMonoC, xMonoC, yMonoBot, U, V); // C'
                    tessellator.addVertexWithUV(zMonoD, xMonoD, yMonoBot, u, V); // D'

                    tessellator.addVertexWithUV(zMonoC, xMonoC, yMonoTop, u, v); // C
                    tessellator.addVertexWithUV(zMonoB, xMonoB, yMonoTop, U, v); // B
                    tessellator.addVertexWithUV(zMonoB, xMonoB, yMonoBot, U, V); // B'
                    tessellator.addVertexWithUV(zMonoC, xMonoC, yMonoBot, u, V); // C'

                    tessellator.addVertexWithUV(zMonoB, xMonoB, yMonoTop, u, v); // B
                    tessellator.addVertexWithUV(zMonoA, xMonoA, yMonoTop, U, v); // A
                    tessellator.addVertexWithUV(zMonoA, xMonoA, yMonoBot, U, V); // A'
                    tessellator.addVertexWithUV(zMonoB, xMonoB, yMonoBot, u, V); // B'

                    tessellator.addVertexWithUV(zMonoA, xMonoA, yMonoTop, u, v); // A
                    tessellator.addVertexWithUV(zMonoF, xMonoF, yMonoTop, U, v); // F
                    tessellator.addVertexWithUV(zMonoF, xMonoF, yMonoBot, U, V); // F'
                    tessellator.addVertexWithUV(zMonoA, xMonoA, yMonoBot, u, V); // A'
                }
                else if (orientation == 4) {
                    // Top Face
                    tessellator.addVertexWithUV(1 - yMonoTop, xMonoB, zMonoB, c.getInterpolatedU(uMonoTopB), c.getInterpolatedV(vMonoTopB)); // B
                    tessellator.addVertexWithUV(1 - yMonoTop, xMonoC, zMonoC, c.getInterpolatedU(uMonoTopC), c.getInterpolatedV(vMonoTopC)); // C
                    tessellator.addVertexWithUV(1 - yMonoTop, xMonoD, zMonoD, c.getInterpolatedU(uMonoTopD), c.getInterpolatedV(vMonoTopD)); // D
                    tessellator.addVertexWithUV(1 - yMonoTop, xMonoA, zMonoA, c.getInterpolatedU(uMonoTopA), c.getInterpolatedV(vMonoTopA)); // A

                    tessellator.addVertexWithUV(1 - yMonoTop, xMonoA, zMonoA, c.getInterpolatedU(uMonoTopA), c.getInterpolatedV(vMonoTopA)); // A
                    tessellator.addVertexWithUV(1 - yMonoTop, xMonoD, zMonoD, c.getInterpolatedU(uMonoTopD), c.getInterpolatedV(vMonoTopD)); // D
                    tessellator.addVertexWithUV(1 - yMonoTop, xMonoE, zMonoE, c.getInterpolatedU(uMonoTopE), c.getInterpolatedV(vMonoTopE)); // E
                    tessellator.addVertexWithUV(1 - yMonoTop, xMonoF, zMonoF, c.getInterpolatedU(uMonoTopF), c.getInterpolatedV(vMonoTopF)); // F

                    // Side Faces
                    tessellator.addVertexWithUV(1 - yMonoTop, xMonoF, zMonoF, u, v); // F
                    tessellator.addVertexWithUV(1 - yMonoTop, xMonoE, zMonoE, U, v); // E
                    tessellator.addVertexWithUV(1 - yMonoBot, xMonoE, zMonoE, U, V); // E'
                    tessellator.addVertexWithUV(1 - yMonoBot, xMonoF, zMonoF, u, V); // F'

                    tessellator.addVertexWithUV(1 - yMonoTop, xMonoE, zMonoE, u, v); // E
                    tessellator.addVertexWithUV(1 - yMonoTop, xMonoD, zMonoD, U, v); // D
                    tessellator.addVertexWithUV(1 - yMonoBot, xMonoD, zMonoD, U, V); // D'
                    tessellator.addVertexWithUV(1 - yMonoBot, xMonoE, zMonoE, u, V); // E'

                    tessellator.addVertexWithUV(1 - yMonoTop, xMonoD, zMonoD, u, v); // D
                    tessellator.addVertexWithUV(1 - yMonoTop, xMonoC, zMonoC, U, v); // C
                    tessellator.addVertexWithUV(1 - yMonoBot, xMonoC, zMonoC, U, V); // C'
                    tessellator.addVertexWithUV(1 - yMonoBot, xMonoD, zMonoD, u, V); // D'

                    tessellator.addVertexWithUV(1 - yMonoTop, xMonoC, zMonoC, u, v); // C
                    tessellator.addVertexWithUV(1 - yMonoTop, xMonoB, zMonoB, U, v); // B
                    tessellator.addVertexWithUV(1 - yMonoBot, xMonoB, zMonoB, U, V); // B'
                    tessellator.addVertexWithUV(1 - yMonoBot, xMonoC, zMonoC, u, V); // C'

                    tessellator.addVertexWithUV(1 - yMonoTop, xMonoB, zMonoB, u, v); // B
                    tessellator.addVertexWithUV(1 - yMonoTop, xMonoA, zMonoA, U, v); // A
                    tessellator.addVertexWithUV(1 - yMonoBot, xMonoA, zMonoA, U, V); // A'
                    tessellator.addVertexWithUV(1 - yMonoBot, xMonoB, zMonoB, u, V); // B'

                    tessellator.addVertexWithUV(1 - yMonoTop, xMonoA, zMonoA, u, v); // A
                    tessellator.addVertexWithUV(1 - yMonoTop, xMonoF, zMonoF, U, v); // F
                    tessellator.addVertexWithUV(1 - yMonoBot, xMonoF, zMonoF, U, V); // F'
                    tessellator.addVertexWithUV(1 - yMonoBot, xMonoA, zMonoA, u, V); // A'
                }
                else if (orientation == 5) {
                    // Top Face
                    tessellator.addVertexWithUV(yMonoTop, xMonoA, zMonoA, c.getInterpolatedU(uMonoTopA), c.getInterpolatedV(vMonoTopA)); // A
                    tessellator.addVertexWithUV(yMonoTop, xMonoD, zMonoD, c.getInterpolatedU(uMonoTopD), c.getInterpolatedV(vMonoTopD)); // D
                    tessellator.addVertexWithUV(yMonoTop, xMonoC, zMonoC, c.getInterpolatedU(uMonoTopC), c.getInterpolatedV(vMonoTopC)); // C
                    tessellator.addVertexWithUV(yMonoTop, xMonoB, zMonoB, c.getInterpolatedU(uMonoTopB), c.getInterpolatedV(vMonoTopB)); // B

                    tessellator.addVertexWithUV(yMonoTop, xMonoF, zMonoF, c.getInterpolatedU(uMonoTopF), c.getInterpolatedV(vMonoTopF)); // F
                    tessellator.addVertexWithUV(yMonoTop, xMonoE, zMonoE, c.getInterpolatedU(uMonoTopE), c.getInterpolatedV(vMonoTopE)); // E
                    tessellator.addVertexWithUV(yMonoTop, xMonoD, zMonoD, c.getInterpolatedU(uMonoTopD), c.getInterpolatedV(vMonoTopD)); // D
                    tessellator.addVertexWithUV(yMonoTop, xMonoA, zMonoA, c.getInterpolatedU(uMonoTopA), c.getInterpolatedV(vMonoTopA)); // A

                    // Side Faces
                    tessellator.addVertexWithUV(yMonoBot, xMonoF, zMonoF, u, V); // F'
                    tessellator.addVertexWithUV(yMonoBot, xMonoE, zMonoE, U, V); // E'
                    tessellator.addVertexWithUV(yMonoTop, xMonoE, zMonoE, U, v); // E
                    tessellator.addVertexWithUV(yMonoTop, xMonoF, zMonoF, u, v); // F

                    tessellator.addVertexWithUV(yMonoBot, xMonoE, zMonoE, u, V); // E'
                    tessellator.addVertexWithUV(yMonoBot, xMonoD, zMonoD, U, V); // D'
                    tessellator.addVertexWithUV(yMonoTop, xMonoD, zMonoD, U, v); // D
                    tessellator.addVertexWithUV(yMonoTop, xMonoE, zMonoE, u, v); // E

                    tessellator.addVertexWithUV(yMonoBot, xMonoD, zMonoD, u, V); // D'
                    tessellator.addVertexWithUV(yMonoBot, xMonoC, zMonoC, U, V); // C'
                    tessellator.addVertexWithUV(yMonoTop, xMonoC, zMonoC, U, v); // C
                    tessellator.addVertexWithUV(yMonoTop, xMonoD, zMonoD, u, v); // D

                    tessellator.addVertexWithUV(yMonoBot, xMonoC, zMonoC, u, V); // C'
                    tessellator.addVertexWithUV(yMonoBot, xMonoB, zMonoB, U, V); // B'
                    tessellator.addVertexWithUV(yMonoTop, xMonoB, zMonoB, U, v); // B
                    tessellator.addVertexWithUV(yMonoTop, xMonoC, zMonoC, u, v); // C

                    tessellator.addVertexWithUV(yMonoBot, xMonoB, zMonoB, u, V); // B'
                    tessellator.addVertexWithUV(yMonoBot, xMonoA, zMonoA, U, V); // A'
                    tessellator.addVertexWithUV(yMonoTop, xMonoA, zMonoA, U, v); // A
                    tessellator.addVertexWithUV(yMonoTop, xMonoB, zMonoB, u, v); // B

                    tessellator.addVertexWithUV(yMonoBot, xMonoA, zMonoA, u, V); // A'
                    tessellator.addVertexWithUV(yMonoBot, xMonoF, zMonoF, U, V); // F'
                    tessellator.addVertexWithUV(yMonoTop, xMonoF, zMonoF, U, v); // F
                    tessellator.addVertexWithUV(yMonoTop, xMonoA, zMonoA, u, v); // A
                }

                tessellator.addTranslation(-x, -y, -z);
            }
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

    /**
     * Scales a normalized vector to a desired distance.
     * @param vec Vector to scale.
     * @param l Desired length.
     */
    private Vec3 scaleVector(Vec3 vec, double l) {
        double x = vec.xCoord * l;
        double y = vec.yCoord * l;
        double z = vec.zCoord * l;
        return Vec3.createVectorHelper(x, y, z);
    }

    /**
     * Positions a vector at the center of a block.
     * @param vec Vector to reposition.
     */
    private Vec3 centerVector(Vec3 vec) {
        return vec.addVector(0.5, 0.5, 0.5);
    }
}
