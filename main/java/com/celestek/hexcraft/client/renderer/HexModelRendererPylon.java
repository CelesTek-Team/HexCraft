package com.celestek.hexcraft.client.renderer;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.HexClientProxy;
import com.celestek.hexcraft.tileentity.TileEnergyPylon;
import com.celestek.hexcraft.util.HexColors;
import com.celestek.hexcraft.util.HexPylon;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;

import java.math.MathContext;

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

    // Model constants.
    private static float invOffset = 0.4F;

    public static float yMonoBot = 0.125F;
    public static float yMonoTop = 0.875F;

    private static float xMonoA = 0.1874F;
    private static float xMonoB = 0.3437F;
    private static float xMonoC = 0.6563F;
    private static float xMonoD = 0.8126F;
    private static float xMonoE = 0.6563F;
    private static float xMonoF = 0.3437F;

    private static float zMonoA = 0.5F;
    private static float zMonoB = 0.7707F;
    private static float zMonoC = 0.7707F;
    private static float zMonoD = 0.5F;
    private static float zMonoE = 0.2292F;
    private static float zMonoF = 0.2292F;


    public static float yBaseBot = 0F;

    public static float xBaseMin = 0F;
    public static float xBaseMax = 1F;
    
    public static float zBaseMin = 0F;
    public static float zBaseMax = 1F;

    private static float xPlatMin = 0.125F;
    private static float xPlatMax = 0.875F;
    
    private static float zPlatMin = 0.125F;
    private static float zPlatMax = 0.875F;


    private static float yRingTop = 0.25F;

    private static float xRingA = 0.125F;
    private static float xRingB = 0.3125F;
    private static float xRingC = 0.6875F;
    private static float xRingD = 0.875F;
    private static float xRingE = 0.6875F;
    private static float xRingF = 0.3125F;

    private static float zRingA = 0.5F;
    private static float zRingB = 0.8248F;
    private static float zRingC = 0.8248F;
    private static float zRingD = 0.5F;
    private static float zRingE = 0.1752F;
    private static float zRingF = 0.1752F;
    

    private static float uMonoTopA = 0.3F;
    private static float vMonoTopA = 4.5F;
    private static float uMonoTopB = 2.6F;
    private static float vMonoTopB = 0.25F;
    private static float uMonoTopC = 7.4F;
    private static float vMonoTopC = 0.25F;
    private static float uMonoTopD = 9.7F;
    private static float vMonoTopD = 4.5F;
    private static float uMonoTopE = 7.4F;
    private static float vMonoTopE = 8.75F;
    private static float uMonoTopF = 2.6F;
    private static float vMonoTopF = 8.75F;

    private static float uMonoSide = 11.25F;
    private static float UMonoSide = 15.75F;
    private static float vMonoSide = 0.25F;
    private static float VMonoSide = 11.75F;



    private static float uBaseTop = 2F;
    private static float vBaseTop = 2F;
    private static float UBaseTop = 14F;
    private static float VBaseTop = 14F;

    private static float uBaseA1 = 0F;
    private static float vBaseA1 = 0F;
    private static float uBaseA2 = 16F;
    private static float vBaseA2 = 0F;
    private static float uBaseA3 = 14F;
    private static float vBaseA3 = 3F;
    private static float uBaseA4 = 2F;
    private static float vBaseA4 = 3F;

    private static float uBaseB1 = 0F;
    private static float vBaseB1 = 3F;
    private static float uBaseB2 = 16F;
    private static float vBaseB2 = 3F;
    private static float uBaseB3 = 14F;
    private static float vBaseB3 = 6F;
    private static float uBaseB4 = 2F;
    private static float vBaseB4 = 6F;


    private static float uRingA1 = 0F;
    private static float vRingA1 = 6.5F;
    private static float uRingA2 = 6F;
    private static float vRingA2 = 6.5F;
    private static float uRingA3 = 5.5F;
    private static float vRingA3 = 9F;
    private static float uRingA4 = 0.5F;
    private static float vRingA4 = 9F;

    private static float uRingB1 = 8F;
    private static float vRingB1 = 6.5F;
    private static float uRingB2 = 14F;
    private static float vRingB2 = 6.5F;
    private static float uRingB3 = 13.5F;
    private static float vRingB3 = 9F;
    private static float uRingB4 = 8.5F;
    private static float vRingB4 = 9F;

    private static float uRingC1 = 0F;
    private static float vRingC1 = 11F;
    private static float uRingC2 = 6F;
    private static float vRingC2 = 11F;
    private static float uRingC3 = 5.5F;
    private static float vRingC3 = 13.5F;
    private static float uRingC4 = 0.5F;
    private static float vRingC4 = 13.5F;

    private static float uRingD1 = 0.5F;
    private static float vRingD1 = 9F;
    private static float uRingD2 = 5.5F;
    private static float vRingD2 = 9F;
    private static float uRingD3 = 5.5F;
    private static float vRingD3 = 11F;
    private static float uRingD4 = 0.5F;
    private static float vRingD4 = 11F;

    private static float uRingE1 = 8.5F;
    private static float vRingE1 = 9F;
    private static float uRingE2 = 13.5F;
    private static float vRingE2 = 9F;
    private static float uRingE3 = 13.5F;
    private static float vRingE3 = 11F;
    private static float uRingE4 = 8.5F;
    private static float vRingE4 = 11F;

    private static float uRingF1 = 0.5F;
    private static float vRingF1 = 13.5F;
    private static float uRingF2 = 5.5F;
    private static float vRingF2 = 13.5F;
    private static float uRingF3 = 5.5F;
    private static float vRingF3 = 15.5F;
    private static float uRingF4 = 0.5F;
    private static float vRingF4 = 15.5F;

    private static float off = 0.01F;

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

        // Set up brightness.
        tessellator.setNormal(0F, 1F, 0F);

        // Prepare the icon.
        IIcon c = block.getIcon(0, 0);

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
        tessellator.addVertexWithUV(xMonoF, invOffset+yRingTop, zMonoF, c.getInterpolatedU(uRingC4), c.getInterpolatedV(vRingC4)); // F'

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

        if (meta >= 6)
            meta = meta - 6;

        // Prepare the Tessellator.
        Tessellator tessellator = Tessellator.instance;
        tessellator.addTranslation(x, y, z);

        // Check if this is the second (transparent) render pass, if it is...
        if(HexClientProxy.renderPass[renderBlockID] == 1) {

            TileEnergyPylon tileEntity = (TileEnergyPylon) world.getTileEntity(x, y, z);

            boolean renderMonolith = false;
            if (tileEntity != null)
                if (tileEntity.monolith > 0)
                    renderMonolith = true;

            if (renderMonolith) {
                float r = HexColors.colorWhiteR;
                float g = HexColors.colorWhiteG;
                float b = HexColors.colorWhiteB;
                IIcon c = block.getIcon(6, 0);

                if (tileEntity.monolith == 1) {
                    r = HexColors.colorRedR;
                    g = HexColors.colorRedG;
                    b = HexColors.colorRedB;
                } else if (tileEntity.monolith == 2) {
                    r = HexColors.colorOrangeR;
                    g = HexColors.colorOrangeG;
                    b = HexColors.colorOrangeB;
                } else if (tileEntity.monolith == 3) {
                    r = HexColors.colorYellowR;
                    g = HexColors.colorYellowG;
                    b = HexColors.colorYellowB;
                } else if (tileEntity.monolith == 4) {
                    r = HexColors.colorLimeR;
                    g = HexColors.colorLimeG;
                    b = HexColors.colorLimeB;
                } else if (tileEntity.monolith == 5) {
                    r = HexColors.colorGreenR;
                    g = HexColors.colorGreenG;
                    b = HexColors.colorGreenB;
                } else if (tileEntity.monolith == 6) {
                    r = HexColors.colorTurquoiseR;
                    g = HexColors.colorTurquoiseG;
                    b = HexColors.colorTurquoiseB;
                } else if (tileEntity.monolith == 7) {
                    r = HexColors.colorCyanR;
                    g = HexColors.colorCyanG;
                    b = HexColors.colorCyanB;
                } else if (tileEntity.monolith == 8) {
                    r = HexColors.colorSkyBlueR;
                    g = HexColors.colorSkyBlueG;
                    b = HexColors.colorSkyBlueB;
                } else if (tileEntity.monolith == 9) {
                    r = HexColors.colorBlueR;
                    g = HexColors.colorBlueG;
                    b = HexColors.colorBlueB;
                } else if (tileEntity.monolith == 10) {
                    r = HexColors.colorPurpleR;
                    g = HexColors.colorPurpleG;
                    b = HexColors.colorPurpleB;
                } else if (tileEntity.monolith == 11) {
                    r = HexColors.colorMagentaR;
                    g = HexColors.colorMagentaG;
                    b = HexColors.colorMagentaB;
                } else if (tileEntity.monolith == 12) {
                    r = HexColors.colorPinkR;
                    g = HexColors.colorPinkG;
                    b = HexColors.colorPinkB;
                } else if (tileEntity.monolith == 13) {
                    r = HexColors.colorWhiteR;
                    g = HexColors.colorWhiteG;
                    b = HexColors.colorWhiteB;
                } else if (tileEntity.monolith == 14) {
                    r = HexColors.colorLightGrayR;
                    g = HexColors.colorLightGrayG;
                    b = HexColors.colorLightGrayB;
                } else if (tileEntity.monolith == 15) {
                    r = HexColors.colorGrayR;
                    g = HexColors.colorGrayG;
                    b = HexColors.colorGrayB;
                } else if (tileEntity.monolith == 16) {
                    r = HexColors.colorDarkGrayR;
                    g = HexColors.colorDarkGrayG;
                    b = HexColors.colorDarkGrayB;
                } else if (tileEntity.monolith == 17) {
                    r = HexColors.colorBlackR;
                    g = HexColors.colorBlackG;
                    b = HexColors.colorBlackB;
                } else if (tileEntity.monolith == 18) {
                    c = block.getIcon(7, 0);
                }

                /* Monolith */
                // Set up brightness and color.
                tessellator.setBrightness(brightness);
                tessellator.setColorRGBA_F(r, g, b, opacity);

                // Prepare the icon.
                double u = c.getInterpolatedU(uMonoSide);
                double U = c.getInterpolatedU(UMonoSide);
                double v = c.getInterpolatedV(vMonoSide);
                double V = c.getInterpolatedV(VMonoSide);

                // Render the monolith. Use the block meta to rotate the model.
                if (meta == 0) {
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
                } else if (meta == 1) {
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
                } else if (meta == 2) {
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
                } else if (meta == 3) {
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
                } else if (meta == 4) {
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
                } else if (meta == 5) {
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

                if (tileEntity.pylons != null) {
                    tessellator.setColorRGBA_F(r, g, b, HexColors.opacityOpaque);
                    c = block.getIcon(10, 0);
                    u = c.getMinU();
                    U = c.getMaxU();
                    v = c.getMinV();
                    V = c.getMaxV();
                    for (HexPylon pylon : tileEntity.pylons) {
                        if (pylon.pylon != null)
                            if (pylon.beam) {
                                if (tileEntity.monolith == 18 || pylon.pylon.monolith == 18) {
                                    r = HexColors.colorWhiteR;
                                    g = HexColors.colorWhiteG;
                                    b = HexColors.colorWhiteB;
                                    c = block.getIcon(10, 0);
                                    u = c.getMinU();
                                    U = c.getMaxU();
                                    v = c.getMinV();
                                    V = c.getMaxV();
                                }
                                Vec3 vec1 = Vec3.createVectorHelper(x, y, z).subtract(Vec3.createVectorHelper(pylon.pylon.xCoord, pylon.pylon.yCoord, pylon.pylon.zCoord));

                                Vec3 vec10 = Vec3.createVectorHelper(vec1.xCoord, vec1.yCoord, vec1.zCoord);
                                vec10.rotateAroundY((float) -Math.PI / 2);
                                vec10.yCoord = 0;

                                Vec3 vec2 = Vec3.createVectorHelper(vec1.xCoord, vec1.yCoord, vec1.zCoord);
                                vec2.rotateAroundY((float) -Math.PI / 2);
                                vec2.yCoord = 0;
                                vec2 = scaleAndCenterVector(vec2, 0.1);
                                Vec3 vec3 = vec2.addVector(vec1.xCoord, vec1.yCoord, vec1.zCoord);

                                Vec3 vec4 = Vec3.createVectorHelper(vec1.xCoord, vec1.yCoord, vec1.zCoord);
                                vec4.rotateAroundY((float) -Math.PI / 2);
                                vec4.yCoord = 0;
                                vec4 = scaleAndCenterVector(vec4, -0.1);
                                Vec3 vec5 = vec4.addVector(vec1.xCoord, vec1.yCoord, vec1.zCoord);

                                Vec3 vec6 = vec10.crossProduct(vec1);
                                vec6 = scaleAndCenterVector(vec6, 0.1);
                                Vec3 vec7 = vec6.addVector(vec1.xCoord, vec1.yCoord, vec1.zCoord);

                                Vec3 vec8 = vec10.crossProduct(vec1);
                                vec8 = scaleAndCenterVector(vec8, -0.1);
                                Vec3 vec9 = vec8.addVector(vec1.xCoord, vec1.yCoord, vec1.zCoord);

                                tessellator.addVertexWithUV(vec2.xCoord, vec2.yCoord, vec2.zCoord, u, v); // A
                                tessellator.addVertexWithUV(vec3.xCoord, vec3.yCoord, vec3.zCoord, U, v); // B
                                tessellator.addVertexWithUV(vec5.xCoord, vec5.yCoord, vec5.zCoord, U, V); // C
                                tessellator.addVertexWithUV(vec4.xCoord, vec4.yCoord, vec4.zCoord, u, V); // D

                                tessellator.addVertexWithUV(vec4.xCoord, vec4.yCoord, vec4.zCoord, u, V); // D
                                tessellator.addVertexWithUV(vec5.xCoord, vec5.yCoord, vec5.zCoord, U, V); // C
                                tessellator.addVertexWithUV(vec3.xCoord, vec3.yCoord, vec3.zCoord, U, v); // B
                                tessellator.addVertexWithUV(vec2.xCoord, vec2.yCoord, vec2.zCoord, u, v); // A

                                tessellator.addVertexWithUV(vec6.xCoord, vec6.yCoord, vec6.zCoord, u, v); // E
                                tessellator.addVertexWithUV(vec7.xCoord, vec7.yCoord, vec7.zCoord, U, v); // F
                                tessellator.addVertexWithUV(vec9.xCoord, vec9.yCoord, vec9.zCoord, U, V); // G
                                tessellator.addVertexWithUV(vec8.xCoord, vec8.yCoord, vec8.zCoord, u, V); // H

                                tessellator.addVertexWithUV(vec8.xCoord, vec8.yCoord, vec8.zCoord, u, V); // H
                                tessellator.addVertexWithUV(vec9.xCoord, vec9.yCoord, vec9.zCoord, U, V); // G
                                tessellator.addVertexWithUV(vec7.xCoord, vec7.yCoord, vec7.zCoord, U, v); // F
                                tessellator.addVertexWithUV(vec6.xCoord, vec6.yCoord, vec6.zCoord, u, v); // E

                                System.out.println(vec1);
                                System.out.println(vec2);
                                System.out.println(vec3);
                                System.out.println(vec4);
                                System.out.println(vec5);
                                System.out.println(vec6);
                                System.out.println(vec7);
                                System.out.println(vec8);
                                System.out.println(vec9);
                            }
                    }
                }
            }
            else {
                // If Tessellator doesn't do anything, it will crash, so make a dummy quad.
                tessellator.addVertex(0, 0, 0);
                tessellator.addVertex(0, 0, 0);
                tessellator.addVertex(0, 0, 0);
                tessellator.addVertex(0, 0, 0);
            }
        }
        // If this is the first (opaque) render pass...
        else {
            /* Base */
            // Set up brightness and color.
            tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
            tessellator.setColorOpaque_F(1, 1, 1);

            // Prepare the icon.
            IIcon c = block.getIcon(0, 0);

            // Render the base. Use the block meta to rotate the model.
            if (meta == 0) {
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

                tessellator.addVertexWithUV(xPlatMin, 1-yMonoBot, zPlatMin, u, V); // D'
                tessellator.addVertexWithUV(xPlatMax, 1-yMonoBot, zPlatMin, U, V); // C'
                tessellator.addVertexWithUV(xPlatMax, 1-yMonoBot, zPlatMax, U, v); // B'
                tessellator.addVertexWithUV(xPlatMin, 1-yMonoBot, zPlatMax, u, v); // A'
            }
            else if (meta == 1) {
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

                tessellator.addVertexWithUV(xPlatMin, yMonoBot, zPlatMax, u, v); // A'
                tessellator.addVertexWithUV(xPlatMax, yMonoBot, zPlatMax, U, v); // B'
                tessellator.addVertexWithUV(xPlatMax, yMonoBot, zPlatMin, U, V); // C'
                tessellator.addVertexWithUV(xPlatMin, yMonoBot, zPlatMin, u, V); // D'
            }
            else if (meta == 2) {
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

                tessellator.addVertexWithUV(zPlatMin, xPlatMin, 1-yMonoBot, u, V); // D'
                tessellator.addVertexWithUV(zPlatMin, xPlatMax, 1-yMonoBot, U, V); // C'
                tessellator.addVertexWithUV(zPlatMax, xPlatMax, 1-yMonoBot, U, v); // B'
                tessellator.addVertexWithUV(zPlatMax, xPlatMin, 1-yMonoBot, u, v); // A'
            }
            else if (meta == 3) {
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

                tessellator.addVertexWithUV(zPlatMax, xPlatMin, yMonoBot, u, v); // A'
                tessellator.addVertexWithUV(zPlatMax, xPlatMax, yMonoBot, U, v); // B'
                tessellator.addVertexWithUV(zPlatMin, xPlatMax, yMonoBot, U, V); // C'
                tessellator.addVertexWithUV(zPlatMin, xPlatMin, yMonoBot, u, V); // D'
            }
            else if (meta == 4) {
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

                tessellator.addVertexWithUV(1-yMonoBot, xPlatMin, zPlatMax, u, v); // A'
                tessellator.addVertexWithUV(1-yMonoBot, xPlatMax, zPlatMax, U, v); // B'
                tessellator.addVertexWithUV(1-yMonoBot, xPlatMax, zPlatMin, U, V); // C'
                tessellator.addVertexWithUV(1-yMonoBot, xPlatMin, zPlatMin, u, V); // D'
            }
            else if (meta == 5) {
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

                tessellator.addVertexWithUV(yMonoBot, xPlatMin, zPlatMin, u, V); // D'
                tessellator.addVertexWithUV(yMonoBot, xPlatMax, zPlatMin, U, V); // C'
                tessellator.addVertexWithUV(yMonoBot, xPlatMax, zPlatMax, U, v); // B'
                tessellator.addVertexWithUV(yMonoBot, xPlatMin, zPlatMax, u, v); // A'
            }
        }

        tessellator.addTranslation(-x, -y, -z);
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

    private Vec3 scaleAndCenterVector(Vec3 vec, double l) {
        vec.xCoord = vec.xCoord / vec.lengthVector() * l;
        vec.yCoord = vec.yCoord / vec.lengthVector() * l;
        vec.zCoord = vec.zCoord / vec.lengthVector() * l;
        return vec.addVector(0.5, 0.5, 0.5);
    }
}
