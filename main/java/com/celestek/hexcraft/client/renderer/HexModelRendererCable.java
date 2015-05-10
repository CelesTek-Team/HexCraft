package com.celestek.hexcraft.client.renderer;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.*;
import com.celestek.hexcraft.client.HexClientProxy;
import com.celestek.hexcraft.init.HexBlocks;
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

public class HexModelRendererCable implements ISimpleBlockRenderingHandler {

    // Variables
    private int renderID;
    private int renderBlockID;
    private int brightness;
    private float r = 1F;
    private float g = 1F;
    private float b = 1F;

    // Model constants.
    private float yMin = 0F;
    private float yMid = 0.35F;
    private float yMax = 1F;

    private float xA = 0.4F;
    private float xB = 0.45F;
    private float xC = 0.55F;
    private float xD = 0.6F;
    private float xE = 0.55F;
    private float xF = 0.45F;

    private float zA = 0.5F;
    private float zB = 0.5866F;
    private float zC = 0.5866F;
    private float zD = 0.5F;
    private float zE = 0.4134F;
    private float zF = 0.4134F;

    private float topAu = 0F;
    private float topAv = 1.3856F;
    private float topBu = 0.8F;
    private float topBv = 0F;
    private float topCu = 2.8F;
    private float topCv = 0F;
    private float topDu = 3.6F;
    private float topDv = 1.3856F;
    private float topEu = 2.8F;
    private float topEv = 2.7712F;
    private float topFu = 0.8F;
    private float topFv = 2.7712F;

    public static float cMin = 0.35F;
    public static float cMax = 0.65F;

    private float sideu = 0F;
    private float sideU = 2F;
    private float sidev = 0F;
    private float sideV = 16F;

    private float miniu = 6F;
    private float miniU = 8F;
    private float miniv = 0F;
    private float miniV = 5.5F;

    private float cubeu = 6F;
    private float cubeU = 11F;
    private float cubev = 5.5F;
    private float cubeV = 10.5F;

    private float off = 0.01F;

    /**
     * Constructor for custom monolith rendering.
     * @param renderID Minecraft's internal ID of a certain block.
     * @param brightness Intensity of the monolith glow.
     * @param r Red component of the monolith color.
     * @param g Green component of the monolith color
     * @param b Blue component of the monolith color.
     */
    public HexModelRendererCable(int renderID, int brightness, float r, float g, float b)
    {
        // Save the current HexCraft block ID.
        this.renderBlockID = HexCraft.idCounter;

        // Load the constructor parameters.
        this.renderID = renderID;
        this.brightness = brightness;
        this.r = r;
        this.g = g;
        this.b = b;

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

        /* Inner part */
        // Set up brightness and color.
        tessellator.setBrightness(brightness);
        tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0F, 1F, 0F);

        // Prepare the icon.
        IIcon c = block.getIcon(6, 0);
        double u = c.getInterpolatedU(sideu);
        double U = c.getInterpolatedU(sideU);
        double v = c.getInterpolatedV(sidev);
        double V = c.getInterpolatedV(sideV);

        // Top Face
        tessellator.addVertexWithUV(xB, yMax, zB, c.getInterpolatedU(topBu), c.getInterpolatedV(topBv)); // B
        tessellator.addVertexWithUV(xC, yMax, zC, c.getInterpolatedU(topCu), c.getInterpolatedV(topCv)); // C
        tessellator.addVertexWithUV(xD, yMax, zD, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
        tessellator.addVertexWithUV(xA, yMax, zA, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A

        tessellator.addVertexWithUV(xA, yMax, zA, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A
        tessellator.addVertexWithUV(xD, yMax, zD, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
        tessellator.addVertexWithUV(xE, yMax, zE, c.getInterpolatedU(topEu), c.getInterpolatedV(topEv)); // E
        tessellator.addVertexWithUV(xF, yMax, zF, c.getInterpolatedU(topFu), c.getInterpolatedV(topFv)); // F

        // Bottom Face
        tessellator.addVertexWithUV(xA, yMin, zA, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A
        tessellator.addVertexWithUV(xD, yMin, zD, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
        tessellator.addVertexWithUV(xC, yMin, zC, c.getInterpolatedU(topCu), c.getInterpolatedV(topCv)); // C
        tessellator.addVertexWithUV(xB, yMin, zB, c.getInterpolatedU(topBu), c.getInterpolatedV(topBv)); // B

        tessellator.addVertexWithUV(xF, yMin, zF, c.getInterpolatedU(topFu), c.getInterpolatedV(topFv)); // F
        tessellator.addVertexWithUV(xE, yMin, zE, c.getInterpolatedU(topEu), c.getInterpolatedV(topEv)); // E
        tessellator.addVertexWithUV(xD, yMin, zD, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
        tessellator.addVertexWithUV(xA, yMin, zA, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A

        // Side Faces
        tessellator.addVertexWithUV(xF, yMax, zF, u, v); // F
        tessellator.addVertexWithUV(xE, yMax, zE, U, v); // E
        tessellator.addVertexWithUV(xE, yMin, zE, U, V); // E'
        tessellator.addVertexWithUV(xF, yMin, zF, u, V); // F'

        u = c.getInterpolatedU(sideu + 2);
        U = c.getInterpolatedU(sideU + 2);
        tessellator.addVertexWithUV(xE, yMax, zE, u, v); // E
        tessellator.addVertexWithUV(xD, yMax, zD, U, v); // D
        tessellator.addVertexWithUV(xD, yMin, zD, U, V); // D'
        tessellator.addVertexWithUV(xE, yMin, zE, u, V); // E'

        u = c.getInterpolatedU(sideu + 4);
        U = c.getInterpolatedU(sideU + 4);
        tessellator.addVertexWithUV(xD, yMax, zD, u, v); // D
        tessellator.addVertexWithUV(xC, yMax, zC, U, v); // C
        tessellator.addVertexWithUV(xC, yMin, zC, U, V); // C'
        tessellator.addVertexWithUV(xD, yMin, zD, u, V); // D'

        u = c.getInterpolatedU(sideu + 6);
        U = c.getInterpolatedU(sideU + 6);
        tessellator.addVertexWithUV(xC, yMax, zC, u, v); // C
        tessellator.addVertexWithUV(xB, yMax, zB, U, v); // B
        tessellator.addVertexWithUV(xB, yMin, zB, U, V); // B'
        tessellator.addVertexWithUV(xC, yMin, zC, u, V); // C'

        u = c.getInterpolatedU(sideu + 8);
        U = c.getInterpolatedU(sideU + 8);
        tessellator.addVertexWithUV(xB, yMax, zB, u, v); // B
        tessellator.addVertexWithUV(xA, yMax, zA, U, v); // A
        tessellator.addVertexWithUV(xA, yMin, zA, U, V); // A'
        tessellator.addVertexWithUV(xB, yMin, zB, u, V); // B'

        u = c.getInterpolatedU(sideu + 10);
        U = c.getInterpolatedU(sideU + 10);
        tessellator.addVertexWithUV(xA, yMax, zA, u, v); // A
        tessellator.addVertexWithUV(xF, yMax, zF, U, v); // F
        tessellator.addVertexWithUV(xF, yMin, zF, U, V); // F'
        tessellator.addVertexWithUV(xA, yMin, zA, u, V); // A'

        // Finish drawing.
        tessellator.draw();

        /* Outer part */
        // Prepare the Tessellator.
        tessellator.startDrawingQuads();

        // Set up brightness.
        tessellator.setNormal(0F, 1F, 0F);

        // Prepare the icon.
        c = block.getIcon(0, 0);
        u = c.getInterpolatedU(sideu);
        U = c.getInterpolatedU(sideU);
        v = c.getInterpolatedV(sidev);
        V = c.getInterpolatedV(sideV);

        // Side Faces
        tessellator.addVertexWithUV(xF, yMax, zF, u, v); // F
        tessellator.addVertexWithUV(xE, yMax, zE, U, v); // E
        tessellator.addVertexWithUV(xE, yMin, zE, U, V); // E'
        tessellator.addVertexWithUV(xF, yMin, zF, u, V); // F'

        u = c.getInterpolatedU(sideu + 2);
        U = c.getInterpolatedU(sideU + 2);
        tessellator.addVertexWithUV(xE, yMax, zE, u, v); // E
        tessellator.addVertexWithUV(xD, yMax, zD, U, v); // D
        tessellator.addVertexWithUV(xD, yMin, zD, U, V); // D'
        tessellator.addVertexWithUV(xE, yMin, zE, u, V); // E'

        u = c.getInterpolatedU(sideu + 4);
        U = c.getInterpolatedU(sideU + 4);
        tessellator.addVertexWithUV(xD, yMax, zD, u, v); // D
        tessellator.addVertexWithUV(xC, yMax, zC, U, v); // C
        tessellator.addVertexWithUV(xC, yMin, zC, U, V); // C'
        tessellator.addVertexWithUV(xD, yMin, zD, u, V); // D'

        u = c.getInterpolatedU(sideu);
        U = c.getInterpolatedU(sideU);
        tessellator.addVertexWithUV(xC, yMax, zC, u, v); // C
        tessellator.addVertexWithUV(xB, yMax, zB, U, v); // B
        tessellator.addVertexWithUV(xB, yMin, zB, U, V); // B'
        tessellator.addVertexWithUV(xC, yMin, zC, u, V); // C'

        u = c.getInterpolatedU(sideu + 2);
        U = c.getInterpolatedU(sideU + 2);
        tessellator.addVertexWithUV(xB, yMax, zB, u, v); // B
        tessellator.addVertexWithUV(xA, yMax, zA, U, v); // A
        tessellator.addVertexWithUV(xA, yMin, zA, U, V); // A'
        tessellator.addVertexWithUV(xB, yMin, zB, u, V); // B'

        u = c.getInterpolatedU(sideu + 4);
        U = c.getInterpolatedU(sideU + 4);
        tessellator.addVertexWithUV(xA, yMax, zA, u, v); // A
        tessellator.addVertexWithUV(xF, yMax, zF, U, v); // F
        tessellator.addVertexWithUV(xF, yMin, zF, U, V); // F'
        tessellator.addVertexWithUV(xA, yMin, zA, u, V); // A'

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
        boolean sides[] = processCableSides(world, x, y, z, world.getBlock(x, y, z));
        boolean straight = false;

        // Determine if the cable is straight.
        if (sides[0] && sides[1] && !sides[2] && !sides[3] && !sides[4] && !sides[5])
            straight = true;
        else if (!sides[0] && !sides[1] && sides[2] && sides[3] && !sides[4] && !sides[5])
            straight = true;
        else if (!sides[0] && !sides[1] && !sides[2] && !sides[3] && sides[4] && sides[5])
            straight = true;

        // Prepare the Tessellator.
        Tessellator tessellator = Tessellator.instance;
        tessellator.addTranslation(x, y, z);

        // Check if this is the first (opaque) render pass, if it is...
        if(HexClientProxy.renderPass[renderBlockID] == 0) {

            // Set up brightness and color.
            tessellator.setBrightness(brightness);
            tessellator.setColorOpaque_F(r, g, b);

            // Prepare the icon.
            IIcon c = block.getIcon(6, 0);

            // Check if the cable is straight.
            if (straight) {
                double u = c.getInterpolatedU(sideu);
                double U = c.getInterpolatedU(sideU);
                double v = c.getInterpolatedV(sidev);
                double V = c.getInterpolatedV(sideV);

                // Use different drawing depending on orientation.
                if (sides[0] && sides[1] && !sides[2] && !sides[3] && !sides[4] && !sides[5]) {
                    // Side Faces
                    tessellator.addVertexWithUV(xF, yMax, zF, u, v); // F
                    tessellator.addVertexWithUV(xE, yMax, zE, U, v); // E
                    tessellator.addVertexWithUV(xE, yMin, zE, U, V); // E'
                    tessellator.addVertexWithUV(xF, yMin, zF, u, V); // F'

                    u = c.getInterpolatedU(sideu + 2);
                    U = c.getInterpolatedU(sideU + 2);
                    tessellator.addVertexWithUV(xE, yMax, zE, u, v); // E
                    tessellator.addVertexWithUV(xD, yMax, zD, U, v); // D
                    tessellator.addVertexWithUV(xD, yMin, zD, U, V); // D'
                    tessellator.addVertexWithUV(xE, yMin, zE, u, V); // E'

                    u = c.getInterpolatedU(sideu + 4);
                    U = c.getInterpolatedU(sideU + 4);
                    tessellator.addVertexWithUV(xD, yMax, zD, u, v); // D
                    tessellator.addVertexWithUV(xC, yMax, zC, U, v); // C
                    tessellator.addVertexWithUV(xC, yMin, zC, U, V); // C'
                    tessellator.addVertexWithUV(xD, yMin, zD, u, V); // D'

                    u = c.getInterpolatedU(sideu + 6);
                    U = c.getInterpolatedU(sideU + 6);
                    tessellator.addVertexWithUV(xC, yMax, zC, u, v); // C
                    tessellator.addVertexWithUV(xB, yMax, zB, U, v); // B
                    tessellator.addVertexWithUV(xB, yMin, zB, U, V); // B'
                    tessellator.addVertexWithUV(xC, yMin, zC, u, V); // C'

                    u = c.getInterpolatedU(sideu + 8);
                    U = c.getInterpolatedU(sideU + 8);
                    tessellator.addVertexWithUV(xB, yMax, zB, u, v); // B
                    tessellator.addVertexWithUV(xA, yMax, zA, U, v); // A
                    tessellator.addVertexWithUV(xA, yMin, zA, U, V); // A'
                    tessellator.addVertexWithUV(xB, yMin, zB, u, V); // B'

                    u = c.getInterpolatedU(sideu + 10);
                    U = c.getInterpolatedU(sideU + 10);
                    tessellator.addVertexWithUV(xA, yMax, zA, u, v); // A
                    tessellator.addVertexWithUV(xF, yMax, zF, U, v); // F
                    tessellator.addVertexWithUV(xF, yMin, zF, U, V); // F'
                    tessellator.addVertexWithUV(xA, yMin, zA, u, V); // A'
                } else if (!sides[0] && !sides[1] && sides[2] && sides[3] && !sides[4] && !sides[5]) {
                    // Side Faces
                    tessellator.addVertexWithUV(yMin, xF, zF, u, V); // F'
                    tessellator.addVertexWithUV(yMin, xE, zE, U, V); // E'
                    tessellator.addVertexWithUV(yMax, xE, zE, U, v); // E
                    tessellator.addVertexWithUV(yMax, xF, zF, u, v); // F

                    u = c.getInterpolatedU(sideu + 2);
                    U = c.getInterpolatedU(sideU + 2);
                    tessellator.addVertexWithUV(yMin, xE, zE, u, V); // E'
                    tessellator.addVertexWithUV(yMin, xD, zD, U, V); // D'
                    tessellator.addVertexWithUV(yMax, xD, zD, U, v); // D
                    tessellator.addVertexWithUV(yMax, xE, zE, u, v); // E

                    u = c.getInterpolatedU(sideu + 4);
                    U = c.getInterpolatedU(sideU + 4);
                    tessellator.addVertexWithUV(yMin, xD, zD, u, V); // D'
                    tessellator.addVertexWithUV(yMin, xC, zC, U, V); // C'
                    tessellator.addVertexWithUV(yMax, xC, zC, U, v); // C
                    tessellator.addVertexWithUV(yMax, xD, zD, u, v); // D

                    u = c.getInterpolatedU(sideu + 6);
                    U = c.getInterpolatedU(sideU + 6);
                    tessellator.addVertexWithUV(yMin, xC, zC, u, V); // C'
                    tessellator.addVertexWithUV(yMin, xB, zB, U, V); // B'
                    tessellator.addVertexWithUV(yMax, xB, zB, U, v); // B
                    tessellator.addVertexWithUV(yMax, xC, zC, u, v); // C

                    u = c.getInterpolatedU(sideu + 8);
                    U = c.getInterpolatedU(sideU + 8);
                    tessellator.addVertexWithUV(yMin, xB, zB, u, V); // B'
                    tessellator.addVertexWithUV(yMin, xA, zA, U, V); // A'
                    tessellator.addVertexWithUV(yMax, xA, zA, U, v); // A
                    tessellator.addVertexWithUV(yMax, xB, zB, u, v); // B

                    u = c.getInterpolatedU(sideu + 10);
                    U = c.getInterpolatedU(sideU + 10);
                    tessellator.addVertexWithUV(yMin, xA, zA, u, V); // A'
                    tessellator.addVertexWithUV(yMin, xF, zF, U, V); // F'
                    tessellator.addVertexWithUV(yMax, xF, zF, U, v); // F
                    tessellator.addVertexWithUV(yMax, xA, zA, u, v); // A
                } else if (!sides[0] && !sides[1] && !sides[2] && !sides[3] && sides[4] && sides[5]) {
                    // Side Faces
                    tessellator.addVertexWithUV(zF, xF, yMax, u, v); // F
                    tessellator.addVertexWithUV(zE, xE, yMax, U, v); // E
                    tessellator.addVertexWithUV(zE, xE, yMin, U, V); // E'
                    tessellator.addVertexWithUV(zF, xF, yMin, u, V); // F'

                    u = c.getInterpolatedU(sideu + 2);
                    U = c.getInterpolatedU(sideU + 2);
                    tessellator.addVertexWithUV(zE, xE, yMax, u, v); // E
                    tessellator.addVertexWithUV(zD, xD, yMax, U, v); // D
                    tessellator.addVertexWithUV(zD, xD, yMin, U, V); // D'
                    tessellator.addVertexWithUV(zE, xE, yMin, u, V); // E'

                    u = c.getInterpolatedU(sideu + 4);
                    U = c.getInterpolatedU(sideU + 4);
                    tessellator.addVertexWithUV(zD, xD, yMax, u, v); // D
                    tessellator.addVertexWithUV(zC, xC, yMax, U, v); // C
                    tessellator.addVertexWithUV(zC, xC, yMin, U, V); // C'
                    tessellator.addVertexWithUV(zD, xD, yMin, u, V); // D'

                    u = c.getInterpolatedU(sideu + 6);
                    U = c.getInterpolatedU(sideU + 6);
                    tessellator.addVertexWithUV(zC, xC, yMax, u, v); // C
                    tessellator.addVertexWithUV(zB, xB, yMax, U, v); // B
                    tessellator.addVertexWithUV(zB, xB, yMin, U, V); // B'
                    tessellator.addVertexWithUV(zC, xC, yMin, u, V); // C'

                    u = c.getInterpolatedU(sideu + 8);
                    U = c.getInterpolatedU(sideU + 8);
                    tessellator.addVertexWithUV(zB, xB, yMax, u, v); // B
                    tessellator.addVertexWithUV(zA, xA, yMax, U, v); // A
                    tessellator.addVertexWithUV(zA, xA, yMin, U, V); // A'
                    tessellator.addVertexWithUV(zB, xB, yMin, u, V); // B'

                    u = c.getInterpolatedU(sideu + 10);
                    U = c.getInterpolatedU(sideU + 10);
                    tessellator.addVertexWithUV(zA, xA, yMax, u, v); // A
                    tessellator.addVertexWithUV(zF, xF, yMax, U, v); // F
                    tessellator.addVertexWithUV(zF, xF, yMin, U, V); // F'
                    tessellator.addVertexWithUV(zA, xA, yMin, u, V); // A'
                }
            // If the cable is not straight...
            } else {
                // Draw central cube.
                double u = c.getInterpolatedU(cubeu);
                double U = c.getInterpolatedU(cubeU);
                double v = c.getInterpolatedV(cubev);
                double V = c.getInterpolatedV(cubeV);

                tessellator.addVertexWithUV(cMin, cMin, cMax, u, V);
                tessellator.addVertexWithUV(cMin, cMin, cMin, u, v);
                tessellator.addVertexWithUV(cMax, cMin, cMin, U, v);
                tessellator.addVertexWithUV(cMax, cMin, cMax, U, V);

                tessellator.addVertexWithUV(cMin, cMax, cMin, u, v);
                tessellator.addVertexWithUV(cMin, cMax, cMax, u, V);
                tessellator.addVertexWithUV(cMax, cMax, cMax, U, V);
                tessellator.addVertexWithUV(cMax, cMax, cMin, U, v);

                tessellator.addVertexWithUV(cMax, cMin, cMin, u, V);
                tessellator.addVertexWithUV(cMin, cMin, cMin, U, V);
                tessellator.addVertexWithUV(cMin, cMax, cMin, U, v);
                tessellator.addVertexWithUV(cMax, cMax, cMin, u, v);

                tessellator.addVertexWithUV(cMin, cMax, cMax, u, v);
                tessellator.addVertexWithUV(cMin, cMin, cMax, u, V);
                tessellator.addVertexWithUV(cMax, cMin, cMax, U, V);
                tessellator.addVertexWithUV(cMax, cMax, cMax, U, v);

                tessellator.addVertexWithUV(cMin, cMin, cMin, u, V);
                tessellator.addVertexWithUV(cMin, cMin, cMax, U, V);
                tessellator.addVertexWithUV(cMin, cMax, cMax, U, v);
                tessellator.addVertexWithUV(cMin, cMax, cMin, u, v);

                tessellator.addVertexWithUV(cMax, cMin, cMax, u, V);
                tessellator.addVertexWithUV(cMax, cMin, cMin, U, V);
                tessellator.addVertexWithUV(cMax, cMax, cMin, U, v);
                tessellator.addVertexWithUV(cMax, cMax, cMax, u, v);

                v = c.getInterpolatedV(miniv);
                V = c.getInterpolatedV(miniV);

                // Draw a short cable for every side found.
                if(sides[0]) {
                    // Side Faces
                    u = c.getInterpolatedU(sideu);
                    U = c.getInterpolatedU(sideU);
                    tessellator.addVertexWithUV(xF, yMid, zF, u, v); // F
                    tessellator.addVertexWithUV(xE, yMid, zE, U, v); // E
                    tessellator.addVertexWithUV(xE, yMin, zE, U, V); // E'
                    tessellator.addVertexWithUV(xF, yMin, zF, u, V); // F'

                    u = c.getInterpolatedU(sideu + 2);
                    U = c.getInterpolatedU(sideU + 2);
                    tessellator.addVertexWithUV(xE, yMid, zE, u, v); // E
                    tessellator.addVertexWithUV(xD, yMid, zD, U, v); // D
                    tessellator.addVertexWithUV(xD, yMin, zD, U, V); // D'
                    tessellator.addVertexWithUV(xE, yMin, zE, u, V); // E'

                    u = c.getInterpolatedU(sideu + 4);
                    U = c.getInterpolatedU(sideU + 4);
                    tessellator.addVertexWithUV(xD, yMid, zD, u, v); // D
                    tessellator.addVertexWithUV(xC, yMid, zC, U, v); // C
                    tessellator.addVertexWithUV(xC, yMin, zC, U, V); // C'
                    tessellator.addVertexWithUV(xD, yMin, zD, u, V); // D'

                    u = c.getInterpolatedU(sideu + 6);
                    U = c.getInterpolatedU(sideU + 6);
                    tessellator.addVertexWithUV(xC, yMid, zC, u, v); // C
                    tessellator.addVertexWithUV(xB, yMid, zB, U, v); // B
                    tessellator.addVertexWithUV(xB, yMin, zB, U, V); // B'
                    tessellator.addVertexWithUV(xC, yMin, zC, u, V); // C'

                    u = c.getInterpolatedU(sideu + 8);
                    U = c.getInterpolatedU(sideU + 8);
                    tessellator.addVertexWithUV(xB, yMid, zB, u, v); // B
                    tessellator.addVertexWithUV(xA, yMid, zA, U, v); // A
                    tessellator.addVertexWithUV(xA, yMin, zA, U, V); // A'
                    tessellator.addVertexWithUV(xB, yMin, zB, u, V); // B'

                    u = c.getInterpolatedU(sideu + 10);
                    U = c.getInterpolatedU(sideU + 10);
                    tessellator.addVertexWithUV(xA, yMid, zA, u, v); // A
                    tessellator.addVertexWithUV(xF, yMid, zF, U, v); // F
                    tessellator.addVertexWithUV(xF, yMin, zF, U, V); // F'
                    tessellator.addVertexWithUV(xA, yMin, zA, u, V); // A'
                }
                if(sides[1]) {
                    // Side Faces
                    u = c.getInterpolatedU(sideu);
                    U = c.getInterpolatedU(sideU);
                    tessellator.addVertexWithUV(xF, 1-yMin, zF, u, V); // F'
                    tessellator.addVertexWithUV(xE, 1-yMin, zE, U, V); // E'
                    tessellator.addVertexWithUV(xE, 1-yMid, zE, U, v); // E
                    tessellator.addVertexWithUV(xF, 1-yMid, zF, u, v); // F

                    u = c.getInterpolatedU(sideu + 2);
                    U = c.getInterpolatedU(sideU + 2);
                    tessellator.addVertexWithUV(xE, 1-yMin, zE, u, V); // E'
                    tessellator.addVertexWithUV(xD, 1-yMin, zD, U, V); // D'
                    tessellator.addVertexWithUV(xD, 1-yMid, zD, U, v); // D
                    tessellator.addVertexWithUV(xE, 1-yMid, zE, u, v); // E

                    u = c.getInterpolatedU(sideu + 4);
                    U = c.getInterpolatedU(sideU + 4);
                    tessellator.addVertexWithUV(xD, 1-yMin, zD, u, V); // D'
                    tessellator.addVertexWithUV(xC, 1-yMin, zC, U, V); // C'
                    tessellator.addVertexWithUV(xC, 1-yMid, zC, U, v); // C
                    tessellator.addVertexWithUV(xD, 1-yMid, zD, u, v); // D

                    u = c.getInterpolatedU(sideu + 6);
                    U = c.getInterpolatedU(sideU + 6);
                    tessellator.addVertexWithUV(xC, 1-yMin, zC, u, V); // C'
                    tessellator.addVertexWithUV(xB, 1-yMin, zB, U, V); // B'
                    tessellator.addVertexWithUV(xB, 1-yMid, zB, U, v); // B
                    tessellator.addVertexWithUV(xC, 1-yMid, zC, u, v); // C

                    u = c.getInterpolatedU(sideu + 8);
                    U = c.getInterpolatedU(sideU + 8);
                    tessellator.addVertexWithUV(xB, 1-yMin, zB, u, V); // B'
                    tessellator.addVertexWithUV(xA, 1-yMin, zA, U, V); // A'
                    tessellator.addVertexWithUV(xA, 1-yMid, zA, U, v); // A
                    tessellator.addVertexWithUV(xB, 1-yMid, zB, u, v); // B

                    u = c.getInterpolatedU(sideu + 10);
                    U = c.getInterpolatedU(sideU + 10);
                    tessellator.addVertexWithUV(xA, 1-yMin, zA, u, V); // A'
                    tessellator.addVertexWithUV(xF, 1-yMin, zF, U, V); // F'
                    tessellator.addVertexWithUV(xF, 1-yMid, zF, U, v); // F
                    tessellator.addVertexWithUV(xA, 1-yMid, zA, u, v); // A
                }
                if(sides[2]) {
                    // Side Faces
                    u = c.getInterpolatedU(sideu);
                    U = c.getInterpolatedU(sideU);
                    tessellator.addVertexWithUV(yMin, xF, zF, u, V); // F'
                    tessellator.addVertexWithUV(yMin, xE, zE, U, V); // E'
                    tessellator.addVertexWithUV(yMid, xE, zE, U, v); // E
                    tessellator.addVertexWithUV(yMid, xF, zF, u, v); // F

                    u = c.getInterpolatedU(sideu + 2);
                    U = c.getInterpolatedU(sideU + 2);
                    tessellator.addVertexWithUV(yMin, xE, zE, u, V); // E'
                    tessellator.addVertexWithUV(yMin, xD, zD, U, V); // D'
                    tessellator.addVertexWithUV(yMid, xD, zD, U, v); // D
                    tessellator.addVertexWithUV(yMid, xE, zE, u, v); // E

                    u = c.getInterpolatedU(sideu + 4);
                    U = c.getInterpolatedU(sideU + 4);
                    tessellator.addVertexWithUV(yMin, xD, zD, u, V); // D'
                    tessellator.addVertexWithUV(yMin, xC, zC, U, V); // C'
                    tessellator.addVertexWithUV(yMid, xC, zC, U, v); // C
                    tessellator.addVertexWithUV(yMid, xD, zD, u, v); // D

                    u = c.getInterpolatedU(sideu + 6);
                    U = c.getInterpolatedU(sideU + 6);
                    tessellator.addVertexWithUV(yMin, xC, zC, u, V); // C'
                    tessellator.addVertexWithUV(yMin, xB, zB, U, V); // B'
                    tessellator.addVertexWithUV(yMid, xB, zB, U, v); // B
                    tessellator.addVertexWithUV(yMid, xC, zC, u, v); // C

                    u = c.getInterpolatedU(sideu + 8);
                    U = c.getInterpolatedU(sideU + 8);
                    tessellator.addVertexWithUV(yMin, xB, zB, u, V); // B'
                    tessellator.addVertexWithUV(yMin, xA, zA, U, V); // A'
                    tessellator.addVertexWithUV(yMid, xA, zA, U, v); // A
                    tessellator.addVertexWithUV(yMid, xB, zB, u, v); // B

                    u = c.getInterpolatedU(sideu + 10);
                    U = c.getInterpolatedU(sideU + 10);
                    tessellator.addVertexWithUV(yMin, xA, zA, u, V); // A'
                    tessellator.addVertexWithUV(yMin, xF, zF, U, V); // F'
                    tessellator.addVertexWithUV(yMid, xF, zF, U, v); // F
                    tessellator.addVertexWithUV(yMid, xA, zA, u, v); // A
                }
                if(sides[3]) {
                    // Side Faces
                    u = c.getInterpolatedU(sideu);
                    U = c.getInterpolatedU(sideU);
                    tessellator.addVertexWithUV(1-yMid, xF, zF, u, v); // F
                    tessellator.addVertexWithUV(1-yMid, xE, zE, U, v); // E
                    tessellator.addVertexWithUV(1-yMin, xE, zE, U, V); // E'
                    tessellator.addVertexWithUV(1-yMin, xF, zF, u, V); // F'

                    u = c.getInterpolatedU(sideu + 2);
                    U = c.getInterpolatedU(sideU + 2);
                    tessellator.addVertexWithUV(1-yMid, xE, zE, u, v); // E
                    tessellator.addVertexWithUV(1-yMid, xD, zD, U, v); // D
                    tessellator.addVertexWithUV(1-yMin, xD, zD, U, V); // D'
                    tessellator.addVertexWithUV(1-yMin, xE, zE, u, V); // E'

                    u = c.getInterpolatedU(sideu + 4);
                    U = c.getInterpolatedU(sideU + 4);
                    tessellator.addVertexWithUV(1-yMid, xD, zD, u, v); // D
                    tessellator.addVertexWithUV(1-yMid, xC, zC, U, v); // C
                    tessellator.addVertexWithUV(1-yMin, xC, zC, U, V); // C'
                    tessellator.addVertexWithUV(1-yMin, xD, zD, u, V); // D'

                    u = c.getInterpolatedU(sideu + 6);
                    U = c.getInterpolatedU(sideU + 6);
                    tessellator.addVertexWithUV(1-yMid, xC, zC, u, v); // C
                    tessellator.addVertexWithUV(1-yMid, xB, zB, U, v); // B
                    tessellator.addVertexWithUV(1-yMin, xB, zB, U, V); // B'
                    tessellator.addVertexWithUV(1-yMin, xC, zC, u, V); // C'

                    u = c.getInterpolatedU(sideu + 8);
                    U = c.getInterpolatedU(sideU + 8);
                    tessellator.addVertexWithUV(1-yMid, xB, zB, u, v); // B
                    tessellator.addVertexWithUV(1-yMid, xA, zA, U, v); // A
                    tessellator.addVertexWithUV(1-yMin, xA, zA, U, V); // A'
                    tessellator.addVertexWithUV(1-yMin, xB, zB, u, V); // B'

                    u = c.getInterpolatedU(sideu + 10);
                    U = c.getInterpolatedU(sideU + 10);
                    tessellator.addVertexWithUV(1-yMid, xA, zA, u, v); // A
                    tessellator.addVertexWithUV(1-yMid, xF, zF, U, v); // F
                    tessellator.addVertexWithUV(1-yMin, xF, zF, U, V); // F'
                    tessellator.addVertexWithUV(1-yMin, xA, zA, u, V); // A'
                }
                if(sides[4]) {
                    // Side Faces
                    u = c.getInterpolatedU(sideu);
                    U = c.getInterpolatedU(sideU);
                    tessellator.addVertexWithUV(zF, xF, yMid, u, v); // F
                    tessellator.addVertexWithUV(zE, xE, yMid, U, v); // E
                    tessellator.addVertexWithUV(zE, xE, yMin, U, V); // E'
                    tessellator.addVertexWithUV(zF, xF, yMin, u, V); // F'

                    u = c.getInterpolatedU(sideu + 2);
                    U = c.getInterpolatedU(sideU + 2);
                    tessellator.addVertexWithUV(zE, xE, yMid, u, v); // E
                    tessellator.addVertexWithUV(zD, xD, yMid, U, v); // D
                    tessellator.addVertexWithUV(zD, xD, yMin, U, V); // D'
                    tessellator.addVertexWithUV(zE, xE, yMin, u, V); // E'

                    u = c.getInterpolatedU(sideu + 4);
                    U = c.getInterpolatedU(sideU + 4);
                    tessellator.addVertexWithUV(zD, xD, yMid, u, v); // D
                    tessellator.addVertexWithUV(zC, xC, yMid, U, v); // C
                    tessellator.addVertexWithUV(zC, xC, yMin, U, V); // C'
                    tessellator.addVertexWithUV(zD, xD, yMin, u, V); // D'

                    u = c.getInterpolatedU(sideu + 6);
                    U = c.getInterpolatedU(sideU + 6);
                    tessellator.addVertexWithUV(zC, xC, yMid, u, v); // C
                    tessellator.addVertexWithUV(zB, xB, yMid, U, v); // B
                    tessellator.addVertexWithUV(zB, xB, yMin, U, V); // B'
                    tessellator.addVertexWithUV(zC, xC, yMin, u, V); // C'

                    u = c.getInterpolatedU(sideu + 8);
                    U = c.getInterpolatedU(sideU + 8);
                    tessellator.addVertexWithUV(zB, xB, yMid, u, v); // B
                    tessellator.addVertexWithUV(zA, xA, yMid, U, v); // A
                    tessellator.addVertexWithUV(zA, xA, yMin, U, V); // A'
                    tessellator.addVertexWithUV(zB, xB, yMin, u, V); // B'

                    u = c.getInterpolatedU(sideu + 10);
                    U = c.getInterpolatedU(sideU + 10);
                    tessellator.addVertexWithUV(zA, xA, yMid, u, v); // A
                    tessellator.addVertexWithUV(zF, xF, yMid, U, v); // F
                    tessellator.addVertexWithUV(zF, xF, yMin, U, V); // F'
                    tessellator.addVertexWithUV(zA, xA, yMin, u, V); // A'
                }
                if(sides[5]) {
                    // Side Faces
                    u = c.getInterpolatedU(sideu);
                    U = c.getInterpolatedU(sideU);
                    tessellator.addVertexWithUV(zF, xF, 1-yMin, u, V); // F'
                    tessellator.addVertexWithUV(zE, xE, 1-yMin, U, V); // E'
                    tessellator.addVertexWithUV(zE, xE, 1-yMid, U, v); // E
                    tessellator.addVertexWithUV(zF, xF, 1-yMid, u, v); // F

                    u = c.getInterpolatedU(sideu + 2);
                    U = c.getInterpolatedU(sideU + 2);
                    tessellator.addVertexWithUV(zE, xE, 1-yMin, u, V); // E'
                    tessellator.addVertexWithUV(zD, xD, 1-yMin, U, V); // D'
                    tessellator.addVertexWithUV(zD, xD, 1-yMid, U, v); // D
                    tessellator.addVertexWithUV(zE, xE, 1-yMid, u, v); // E

                    u = c.getInterpolatedU(sideu + 4);
                    U = c.getInterpolatedU(sideU + 4);
                    tessellator.addVertexWithUV(zD, xD, 1-yMin, u, V); // D'
                    tessellator.addVertexWithUV(zC, xC, 1-yMin, U, V); // C'
                    tessellator.addVertexWithUV(zC, xC, 1-yMid, U, v); // C
                    tessellator.addVertexWithUV(zD, xD, 1-yMid, u, v); // D

                    u = c.getInterpolatedU(sideu + 6);
                    U = c.getInterpolatedU(sideU + 6);
                    tessellator.addVertexWithUV(zC, xC, 1-yMin, u, V); // C'
                    tessellator.addVertexWithUV(zB, xB, 1-yMin, U, V); // B'
                    tessellator.addVertexWithUV(zB, xB, 1-yMid, U, v); // B
                    tessellator.addVertexWithUV(zC, xC, 1-yMid, u, v); // C

                    u = c.getInterpolatedU(sideu + 8);
                    U = c.getInterpolatedU(sideU + 8);
                    tessellator.addVertexWithUV(zB, xB, 1-yMin, u, V); // B'
                    tessellator.addVertexWithUV(zA, xA, 1-yMin, U, V); // A'
                    tessellator.addVertexWithUV(zA, xA, 1-yMid, U, v); // A
                    tessellator.addVertexWithUV(zB, xB, 1-yMid, u, v); // B

                    u = c.getInterpolatedU(sideu + 10);
                    U = c.getInterpolatedU(sideU + 10);
                    tessellator.addVertexWithUV(zA, xA, 1-yMin, u, V); // A'
                    tessellator.addVertexWithUV(zF, xF, 1-yMin, U, V); // F'
                    tessellator.addVertexWithUV(zF, xF, 1-yMid, U, v); // F
                    tessellator.addVertexWithUV(zA, xA, 1-yMid, u, v); // A
                }

            }
        }
        // If this is the second (transparent) render pass...
        else {
            // Set up brightness.
            tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
            tessellator.setColorOpaque_F(1, 1, 1);

            // Prepare the icon.
            IIcon c = block.getIcon(0, 0);

            // Check if the cable is straight.
            if (straight) {
                double u = c.getInterpolatedU(sideu);
                double U = c.getInterpolatedU(sideU);
                double v = c.getInterpolatedV(sidev);
                double V = c.getInterpolatedV(sideV);

                // Use different drawing depending on orientation.
                if (sides[0] && sides[1] && !sides[2] && !sides[3] && !sides[4] && !sides[5]) {
                    // Side Faces
                    tessellator.addVertexWithUV(xF, yMax, zF, u, v); // F
                    tessellator.addVertexWithUV(xE, yMax, zE, U, v); // E
                    tessellator.addVertexWithUV(xE, yMin, zE, U, V); // E'
                    tessellator.addVertexWithUV(xF, yMin, zF, u, V); // F'

                    u = c.getInterpolatedU(sideu + 2);
                    U = c.getInterpolatedU(sideU + 2);
                    tessellator.addVertexWithUV(xE, yMax, zE, u, v); // E
                    tessellator.addVertexWithUV(xD, yMax, zD, U, v); // D
                    tessellator.addVertexWithUV(xD, yMin, zD, U, V); // D'
                    tessellator.addVertexWithUV(xE, yMin, zE, u, V); // E'

                    u = c.getInterpolatedU(sideu + 4);
                    U = c.getInterpolatedU(sideU + 4);
                    tessellator.addVertexWithUV(xD, yMax, zD, u, v); // D
                    tessellator.addVertexWithUV(xC, yMax, zC, U, v); // C
                    tessellator.addVertexWithUV(xC, yMin, zC, U, V); // C'
                    tessellator.addVertexWithUV(xD, yMin, zD, u, V); // D'

                    u = c.getInterpolatedU(sideu + 0);
                    U = c.getInterpolatedU(sideU + 0);
                    tessellator.addVertexWithUV(xC, yMax, zC, u, v); // C
                    tessellator.addVertexWithUV(xB, yMax, zB, U, v); // B
                    tessellator.addVertexWithUV(xB, yMin, zB, U, V); // B'
                    tessellator.addVertexWithUV(xC, yMin, zC, u, V); // C'

                    u = c.getInterpolatedU(sideu + 2);
                    U = c.getInterpolatedU(sideU + 2);
                    tessellator.addVertexWithUV(xB, yMax, zB, u, v); // B
                    tessellator.addVertexWithUV(xA, yMax, zA, U, v); // A
                    tessellator.addVertexWithUV(xA, yMin, zA, U, V); // A'
                    tessellator.addVertexWithUV(xB, yMin, zB, u, V); // B'

                    u = c.getInterpolatedU(sideu + 4);
                    U = c.getInterpolatedU(sideU + 4);
                    tessellator.addVertexWithUV(xA, yMax, zA, u, v); // A
                    tessellator.addVertexWithUV(xF, yMax, zF, U, v); // F
                    tessellator.addVertexWithUV(xF, yMin, zF, U, V); // F'
                    tessellator.addVertexWithUV(xA, yMin, zA, u, V); // A'
                }
                else if (!sides[0] && !sides[1] && sides[2] && sides[3] && !sides[4] && !sides[5]) {
                    // Side Faces
                    tessellator.addVertexWithUV(yMin, xF, zF, u, V); // F'
                    tessellator.addVertexWithUV(yMin, xE, zE, U, V); // E'
                    tessellator.addVertexWithUV(yMax, xE, zE, U, v); // E
                    tessellator.addVertexWithUV(yMax, xF, zF, u, v); // F

                    u = c.getInterpolatedU(sideu + 2);
                    U = c.getInterpolatedU(sideU + 2);
                    tessellator.addVertexWithUV(yMin, xE, zE, u, V); // E'
                    tessellator.addVertexWithUV(yMin, xD, zD, U, V); // D'
                    tessellator.addVertexWithUV(yMax, xD, zD, U, v); // D
                    tessellator.addVertexWithUV(yMax, xE, zE, u, v); // E

                    u = c.getInterpolatedU(sideu + 4);
                    U = c.getInterpolatedU(sideU + 4);
                    tessellator.addVertexWithUV(yMin, xD, zD, u, V); // D'
                    tessellator.addVertexWithUV(yMin, xC, zC, U, V); // C'
                    tessellator.addVertexWithUV(yMax, xC, zC, U, v); // C
                    tessellator.addVertexWithUV(yMax, xD, zD, u, v); // D

                    u = c.getInterpolatedU(sideu + 0);
                    U = c.getInterpolatedU(sideU + 0);
                    tessellator.addVertexWithUV(yMin, xC, zC, u, V); // C'
                    tessellator.addVertexWithUV(yMin, xB, zB, U, V); // B'
                    tessellator.addVertexWithUV(yMax, xB, zB, U, v); // B
                    tessellator.addVertexWithUV(yMax, xC, zC, u, v); // C

                    u = c.getInterpolatedU(sideu + 2);
                    U = c.getInterpolatedU(sideU + 2);
                    tessellator.addVertexWithUV(yMin, xB, zB, u, V); // B'
                    tessellator.addVertexWithUV(yMin, xA, zA, U, V); // A'
                    tessellator.addVertexWithUV(yMax, xA, zA, U, v); // A
                    tessellator.addVertexWithUV(yMax, xB, zB, u, v); // B

                    u = c.getInterpolatedU(sideu + 4);
                    U = c.getInterpolatedU(sideU + 4);
                    tessellator.addVertexWithUV(yMin, xA, zA, u, V); // A'
                    tessellator.addVertexWithUV(yMin, xF, zF, U, V); // F'
                    tessellator.addVertexWithUV(yMax, xF, zF, U, v); // F
                    tessellator.addVertexWithUV(yMax, xA, zA, u, v); // A
                }
                else if (!sides[0] && !sides[1] && !sides[2] && !sides[3] && sides[4] && sides[5]) {
                    // Side Faces
                    tessellator.addVertexWithUV(zF, xF, yMax, u, v); // F
                    tessellator.addVertexWithUV(zE, xE, yMax, U, v); // E
                    tessellator.addVertexWithUV(zE, xE, yMin, U, V); // E'
                    tessellator.addVertexWithUV(zF, xF, yMin, u, V); // F'

                    u = c.getInterpolatedU(sideu + 2);
                    U = c.getInterpolatedU(sideU + 2);
                    tessellator.addVertexWithUV(zE, xE, yMax, u, v); // E
                    tessellator.addVertexWithUV(zD, xD, yMax, U, v); // D
                    tessellator.addVertexWithUV(zD, xD, yMin, U, V); // D'
                    tessellator.addVertexWithUV(zE, xE, yMin, u, V); // E'

                    u = c.getInterpolatedU(sideu + 4);
                    U = c.getInterpolatedU(sideU + 4);
                    tessellator.addVertexWithUV(zD, xD, yMax, u, v); // D
                    tessellator.addVertexWithUV(zC, xC, yMax, U, v); // C
                    tessellator.addVertexWithUV(zC, xC, yMin, U, V); // C'
                    tessellator.addVertexWithUV(zD, xD, yMin, u, V); // D'

                    u = c.getInterpolatedU(sideu);
                    U = c.getInterpolatedU(sideU);
                    tessellator.addVertexWithUV(zC, xC, yMax, u, v); // C
                    tessellator.addVertexWithUV(zB, xB, yMax, U, v); // B
                    tessellator.addVertexWithUV(zB, xB, yMin, U, V); // B'
                    tessellator.addVertexWithUV(zC, xC, yMin, u, V); // C'

                    u = c.getInterpolatedU(sideu + 2);
                    U = c.getInterpolatedU(sideU + 2);
                    tessellator.addVertexWithUV(zB, xB, yMax, u, v); // B
                    tessellator.addVertexWithUV(zA, xA, yMax, U, v); // A
                    tessellator.addVertexWithUV(zA, xA, yMin, U, V); // A'
                    tessellator.addVertexWithUV(zB, xB, yMin, u, V); // B'

                    u = c.getInterpolatedU(sideu + 4);
                    U = c.getInterpolatedU(sideU + 4);
                    tessellator.addVertexWithUV(zA, xA, yMax, u, v); // A
                    tessellator.addVertexWithUV(zF, xF, yMax, U, v); // F
                    tessellator.addVertexWithUV(zF, xF, yMin, U, V); // F'
                    tessellator.addVertexWithUV(zA, xA, yMin, u, V); // A'
                }
            // If the cable is not straight...
            } else {
                // Draw central cube.
                double u = c.getInterpolatedU(cubeu);
                double U = c.getInterpolatedU(cubeU);
                double v = c.getInterpolatedV(cubev);
                double V = c.getInterpolatedV(cubeV);

                tessellator.addVertexWithUV(cMin, cMin, cMax, u, V);
                tessellator.addVertexWithUV(cMin, cMin, cMin, u, v);
                tessellator.addVertexWithUV(cMax, cMin, cMin, U, v);
                tessellator.addVertexWithUV(cMax, cMin, cMax, U, V);

                tessellator.addVertexWithUV(cMin, cMax, cMin, u, v);
                tessellator.addVertexWithUV(cMin, cMax, cMax, u, V);
                tessellator.addVertexWithUV(cMax, cMax, cMax, U, V);
                tessellator.addVertexWithUV(cMax, cMax, cMin, U, v);

                tessellator.addVertexWithUV(cMax, cMin, cMin, u, V);
                tessellator.addVertexWithUV(cMin, cMin, cMin, U, V);
                tessellator.addVertexWithUV(cMin, cMax, cMin, U, v);
                tessellator.addVertexWithUV(cMax, cMax, cMin, u, v);

                tessellator.addVertexWithUV(cMin, cMax, cMax, u, v);
                tessellator.addVertexWithUV(cMin, cMin, cMax, u, V);
                tessellator.addVertexWithUV(cMax, cMin, cMax, U, V);
                tessellator.addVertexWithUV(cMax, cMax, cMax, U, v);

                tessellator.addVertexWithUV(cMin, cMin, cMin, u, V);
                tessellator.addVertexWithUV(cMin, cMin, cMax, U, V);
                tessellator.addVertexWithUV(cMin, cMax, cMax, U, v);
                tessellator.addVertexWithUV(cMin, cMax, cMin, u, v);

                tessellator.addVertexWithUV(cMax, cMin, cMax, u, V);
                tessellator.addVertexWithUV(cMax, cMin, cMin, U, V);
                tessellator.addVertexWithUV(cMax, cMax, cMin, U, v);
                tessellator.addVertexWithUV(cMax, cMax, cMax, u, v);

                v = c.getInterpolatedV(miniv);
                V = c.getInterpolatedV(miniV);

                // Draw a short cable for every side found.
                if(sides[0]) {
                    // Side Faces
                    u = c.getInterpolatedU(miniu);
                    U = c.getInterpolatedU(miniU);
                    tessellator.addVertexWithUV(xF, yMid, zF, u, v); // F
                    tessellator.addVertexWithUV(xE, yMid, zE, U, v); // E
                    tessellator.addVertexWithUV(xE, yMin, zE, U, V); // E'
                    tessellator.addVertexWithUV(xF, yMin, zF, u, V); // F'

                    u = c.getInterpolatedU(miniu + 2);
                    U = c.getInterpolatedU(miniU + 2);
                    tessellator.addVertexWithUV(xE, yMid, zE, u, v); // E
                    tessellator.addVertexWithUV(xD, yMid, zD, U, v); // D
                    tessellator.addVertexWithUV(xD, yMin, zD, U, V); // D'
                    tessellator.addVertexWithUV(xE, yMin, zE, u, V); // E'

                    u = c.getInterpolatedU(miniu + 4);
                    U = c.getInterpolatedU(miniU + 4);
                    tessellator.addVertexWithUV(xD, yMid, zD, u, v); // D
                    tessellator.addVertexWithUV(xC, yMid, zC, U, v); // C
                    tessellator.addVertexWithUV(xC, yMin, zC, U, V); // C'
                    tessellator.addVertexWithUV(xD, yMin, zD, u, V); // D'

                    u = c.getInterpolatedU(miniu);
                    U = c.getInterpolatedU(miniU);
                    tessellator.addVertexWithUV(xC, yMid, zC, u, v); // C
                    tessellator.addVertexWithUV(xB, yMid, zB, U, v); // B
                    tessellator.addVertexWithUV(xB, yMin, zB, U, V); // B'
                    tessellator.addVertexWithUV(xC, yMin, zC, u, V); // C'

                    u = c.getInterpolatedU(miniu + 2);
                    U = c.getInterpolatedU(miniU + 2);
                    tessellator.addVertexWithUV(xB, yMid, zB, u, v); // B
                    tessellator.addVertexWithUV(xA, yMid, zA, U, v); // A
                    tessellator.addVertexWithUV(xA, yMin, zA, U, V); // A'
                    tessellator.addVertexWithUV(xB, yMin, zB, u, V); // B'

                    u = c.getInterpolatedU(miniu + 4);
                    U = c.getInterpolatedU(miniU + 4);
                    tessellator.addVertexWithUV(xA, yMid, zA, u, v); // A
                    tessellator.addVertexWithUV(xF, yMid, zF, U, v); // F
                    tessellator.addVertexWithUV(xF, yMin, zF, U, V); // F'
                    tessellator.addVertexWithUV(xA, yMin, zA, u, V); // A'
                }
                if(sides[1]) {
                    // Side Faces
                    u = c.getInterpolatedU(miniu);
                    U = c.getInterpolatedU(miniU);
                    tessellator.addVertexWithUV(xF, 1-yMin, zF, u, V); // F'
                    tessellator.addVertexWithUV(xE, 1-yMin, zE, U, V); // E'
                    tessellator.addVertexWithUV(xE, 1-yMid, zE, U, v); // E
                    tessellator.addVertexWithUV(xF, 1-yMid, zF, u, v); // F

                    u = c.getInterpolatedU(miniu + 2);
                    U = c.getInterpolatedU(miniU + 2);
                    tessellator.addVertexWithUV(xE, 1-yMin, zE, u, V); // E'
                    tessellator.addVertexWithUV(xD, 1-yMin, zD, U, V); // D'
                    tessellator.addVertexWithUV(xD, 1-yMid, zD, U, v); // D
                    tessellator.addVertexWithUV(xE, 1-yMid, zE, u, v); // E

                    u = c.getInterpolatedU(miniu + 4);
                    U = c.getInterpolatedU(miniU + 4);
                    tessellator.addVertexWithUV(xD, 1-yMin, zD, u, V); // D'
                    tessellator.addVertexWithUV(xC, 1-yMin, zC, U, V); // C'
                    tessellator.addVertexWithUV(xC, 1-yMid, zC, U, v); // C
                    tessellator.addVertexWithUV(xD, 1-yMid, zD, u, v); // D

                    u = c.getInterpolatedU(miniu);
                    U = c.getInterpolatedU(miniU);
                    tessellator.addVertexWithUV(xC, 1-yMin, zC, u, V); // C'
                    tessellator.addVertexWithUV(xB, 1-yMin, zB, U, V); // B'
                    tessellator.addVertexWithUV(xB, 1-yMid, zB, U, v); // B
                    tessellator.addVertexWithUV(xC, 1-yMid, zC, u, v); // C

                    u = c.getInterpolatedU(miniu + 2);
                    U = c.getInterpolatedU(miniU + 2);
                    tessellator.addVertexWithUV(xB, 1-yMin, zB, u, V); // B'
                    tessellator.addVertexWithUV(xA, 1-yMin, zA, U, V); // A'
                    tessellator.addVertexWithUV(xA, 1-yMid, zA, U, v); // A
                    tessellator.addVertexWithUV(xB, 1-yMid, zB, u, v); // B

                    u = c.getInterpolatedU(miniu + 4);
                    U = c.getInterpolatedU(miniU + 4);
                    tessellator.addVertexWithUV(xA, 1-yMin, zA, u, V); // A'
                    tessellator.addVertexWithUV(xF, 1-yMin, zF, U, V); // F'
                    tessellator.addVertexWithUV(xF, 1-yMid, zF, U, v); // F
                    tessellator.addVertexWithUV(xA, 1-yMid, zA, u, v); // A
                }
                if(sides[2]) {
                    // Side Faces
                    u = c.getInterpolatedU(miniu);
                    U = c.getInterpolatedU(miniU);
                    tessellator.addVertexWithUV(yMin, xF, zF, u, V); // F'
                    tessellator.addVertexWithUV(yMin, xE, zE, U, V); // E'
                    tessellator.addVertexWithUV(yMid, xE, zE, U, v); // E
                    tessellator.addVertexWithUV(yMid, xF, zF, u, v); // F

                    u = c.getInterpolatedU(miniu + 2);
                    U = c.getInterpolatedU(miniU + 2);
                    tessellator.addVertexWithUV(yMin, xE, zE, u, V); // E'
                    tessellator.addVertexWithUV(yMin, xD, zD, U, V); // D'
                    tessellator.addVertexWithUV(yMid, xD, zD, U, v); // D
                    tessellator.addVertexWithUV(yMid, xE, zE, u, v); // E

                    u = c.getInterpolatedU(miniu + 4);
                    U = c.getInterpolatedU(miniU + 4);
                    tessellator.addVertexWithUV(yMin, xD, zD, u, V); // D'
                    tessellator.addVertexWithUV(yMin, xC, zC, U, V); // C'
                    tessellator.addVertexWithUV(yMid, xC, zC, U, v); // C
                    tessellator.addVertexWithUV(yMid, xD, zD, u, v); // D

                    u = c.getInterpolatedU(miniu);
                    U = c.getInterpolatedU(miniU);
                    tessellator.addVertexWithUV(yMin, xC, zC, u, V); // C'
                    tessellator.addVertexWithUV(yMin, xB, zB, U, V); // B'
                    tessellator.addVertexWithUV(yMid, xB, zB, U, v); // B
                    tessellator.addVertexWithUV(yMid, xC, zC, u, v); // C

                    u = c.getInterpolatedU(miniu + 2);
                    U = c.getInterpolatedU(miniU + 2);
                    tessellator.addVertexWithUV(yMin, xB, zB, u, V); // B'
                    tessellator.addVertexWithUV(yMin, xA, zA, U, V); // A'
                    tessellator.addVertexWithUV(yMid, xA, zA, U, v); // A
                    tessellator.addVertexWithUV(yMid, xB, zB, u, v); // B

                    u = c.getInterpolatedU(miniu + 4);
                    U = c.getInterpolatedU(miniU + 4);
                    tessellator.addVertexWithUV(yMin, xA, zA, u, V); // A'
                    tessellator.addVertexWithUV(yMin, xF, zF, U, V); // F'
                    tessellator.addVertexWithUV(yMid, xF, zF, U, v); // F
                    tessellator.addVertexWithUV(yMid, xA, zA, u, v); // A
                }
                if(sides[3]) {
                    // Side Faces
                    u = c.getInterpolatedU(miniu);
                    U = c.getInterpolatedU(miniU);
                    tessellator.addVertexWithUV(1-yMid, xF, zF, u, v); // F
                    tessellator.addVertexWithUV(1-yMid, xE, zE, U, v); // E
                    tessellator.addVertexWithUV(1-yMin, xE, zE, U, V); // E'
                    tessellator.addVertexWithUV(1-yMin, xF, zF, u, V); // F'

                    u = c.getInterpolatedU(miniu + 2);
                    U = c.getInterpolatedU(miniU + 2);
                    tessellator.addVertexWithUV(1-yMid, xE, zE, u, v); // E
                    tessellator.addVertexWithUV(1-yMid, xD, zD, U, v); // D
                    tessellator.addVertexWithUV(1-yMin, xD, zD, U, V); // D'
                    tessellator.addVertexWithUV(1-yMin, xE, zE, u, V); // E'

                    u = c.getInterpolatedU(miniu + 4);
                    U = c.getInterpolatedU(miniU + 4);
                    tessellator.addVertexWithUV(1-yMid, xD, zD, u, v); // D
                    tessellator.addVertexWithUV(1-yMid, xC, zC, U, v); // C
                    tessellator.addVertexWithUV(1-yMin, xC, zC, U, V); // C'
                    tessellator.addVertexWithUV(1-yMin, xD, zD, u, V); // D'

                    u = c.getInterpolatedU(miniu);
                    U = c.getInterpolatedU(miniU);
                    tessellator.addVertexWithUV(1-yMid, xC, zC, u, v); // C
                    tessellator.addVertexWithUV(1-yMid, xB, zB, U, v); // B
                    tessellator.addVertexWithUV(1-yMin, xB, zB, U, V); // B'
                    tessellator.addVertexWithUV(1-yMin, xC, zC, u, V); // C'

                    u = c.getInterpolatedU(miniu + 2);
                    U = c.getInterpolatedU(miniU + 2);
                    tessellator.addVertexWithUV(1-yMid, xB, zB, u, v); // B
                    tessellator.addVertexWithUV(1-yMid, xA, zA, U, v); // A
                    tessellator.addVertexWithUV(1-yMin, xA, zA, U, V); // A'
                    tessellator.addVertexWithUV(1-yMin, xB, zB, u, V); // B'

                    u = c.getInterpolatedU(miniu + 4);
                    U = c.getInterpolatedU(miniU + 4);
                    tessellator.addVertexWithUV(1-yMid, xA, zA, u, v); // A
                    tessellator.addVertexWithUV(1-yMid, xF, zF, U, v); // F
                    tessellator.addVertexWithUV(1-yMin, xF, zF, U, V); // F'
                    tessellator.addVertexWithUV(1-yMin, xA, zA, u, V); // A'
                }
                if(sides[4]) {
                    // Side Faces
                    u = c.getInterpolatedU(miniu);
                    U = c.getInterpolatedU(miniU);
                    tessellator.addVertexWithUV(zF, xF, yMid, u, v); // F
                    tessellator.addVertexWithUV(zE, xE, yMid, U, v); // E
                    tessellator.addVertexWithUV(zE, xE, yMin, U, V); // E'
                    tessellator.addVertexWithUV(zF, xF, yMin, u, V); // F'

                    u = c.getInterpolatedU(miniu + 2);
                    U = c.getInterpolatedU(miniU + 2);
                    tessellator.addVertexWithUV(zE, xE, yMid, u, v); // E
                    tessellator.addVertexWithUV(zD, xD, yMid, U, v); // D
                    tessellator.addVertexWithUV(zD, xD, yMin, U, V); // D'
                    tessellator.addVertexWithUV(zE, xE, yMin, u, V); // E'

                    u = c.getInterpolatedU(miniu + 4);
                    U = c.getInterpolatedU(miniU + 4);
                    tessellator.addVertexWithUV(zD, xD, yMid, u, v); // D
                    tessellator.addVertexWithUV(zC, xC, yMid, U, v); // C
                    tessellator.addVertexWithUV(zC, xC, yMin, U, V); // C'
                    tessellator.addVertexWithUV(zD, xD, yMin, u, V); // D'

                    u = c.getInterpolatedU(miniu);
                    U = c.getInterpolatedU(miniU);
                    tessellator.addVertexWithUV(zC, xC, yMid, u, v); // C
                    tessellator.addVertexWithUV(zB, xB, yMid, U, v); // B
                    tessellator.addVertexWithUV(zB, xB, yMin, U, V); // B'
                    tessellator.addVertexWithUV(zC, xC, yMin, u, V); // C'

                    u = c.getInterpolatedU(miniu + 2);
                    U = c.getInterpolatedU(miniU + 2);
                    tessellator.addVertexWithUV(zB, xB, yMid, u, v); // B
                    tessellator.addVertexWithUV(zA, xA, yMid, U, v); // A
                    tessellator.addVertexWithUV(zA, xA, yMin, U, V); // A'
                    tessellator.addVertexWithUV(zB, xB, yMin, u, V); // B'

                    u = c.getInterpolatedU(miniu + 4);
                    U = c.getInterpolatedU(miniU + 4);
                    tessellator.addVertexWithUV(zA, xA, yMid, u, v); // A
                    tessellator.addVertexWithUV(zF, xF, yMid, U, v); // F
                    tessellator.addVertexWithUV(zF, xF, yMin, U, V); // F'
                    tessellator.addVertexWithUV(zA, xA, yMin, u, V); // A'
                }
                if(sides[5]) {
                    // Side Faces
                    u = c.getInterpolatedU(miniu);
                    U = c.getInterpolatedU(miniU);
                    tessellator.addVertexWithUV(zF, xF, 1-yMin, u, V); // F'
                    tessellator.addVertexWithUV(zE, xE, 1-yMin, U, V); // E'
                    tessellator.addVertexWithUV(zE, xE, 1-yMid, U, v); // E
                    tessellator.addVertexWithUV(zF, xF, 1-yMid, u, v); // F

                    u = c.getInterpolatedU(miniu + 2);
                    U = c.getInterpolatedU(miniU + 2);
                    tessellator.addVertexWithUV(zE, xE, 1-yMin, u, V); // E'
                    tessellator.addVertexWithUV(zD, xD, 1-yMin, U, V); // D'
                    tessellator.addVertexWithUV(zD, xD, 1-yMid, U, v); // D
                    tessellator.addVertexWithUV(zE, xE, 1-yMid, u, v); // E

                    u = c.getInterpolatedU(miniu + 4);
                    U = c.getInterpolatedU(miniU + 4);
                    tessellator.addVertexWithUV(zD, xD, 1-yMin, u, V); // D'
                    tessellator.addVertexWithUV(zC, xC, 1-yMin, U, V); // C'
                    tessellator.addVertexWithUV(zC, xC, 1-yMid, U, v); // C
                    tessellator.addVertexWithUV(zD, xD, 1-yMid, u, v); // D

                    u = c.getInterpolatedU(miniu);
                    U = c.getInterpolatedU(miniU);
                    tessellator.addVertexWithUV(zC, xC, 1-yMin, u, V); // C'
                    tessellator.addVertexWithUV(zB, xB, 1-yMin, U, V); // B'
                    tessellator.addVertexWithUV(zB, xB, 1-yMid, U, v); // B
                    tessellator.addVertexWithUV(zC, xC, 1-yMid, u, v); // C

                    u = c.getInterpolatedU(miniu + 2);
                    U = c.getInterpolatedU(miniU + 2);
                    tessellator.addVertexWithUV(zB, xB, 1-yMin, u, V); // B'
                    tessellator.addVertexWithUV(zA, xA, 1-yMin, U, V); // A'
                    tessellator.addVertexWithUV(zA, xA, 1-yMid, U, v); // A
                    tessellator.addVertexWithUV(zB, xB, 1-yMid, u, v); // B

                    u = c.getInterpolatedU(miniu + 4);
                    U = c.getInterpolatedU(miniU + 4);
                    tessellator.addVertexWithUV(zA, xA, 1-yMin, u, V); // A'
                    tessellator.addVertexWithUV(zF, xF, 1-yMin, U, V); // F'
                    tessellator.addVertexWithUV(zF, xF, 1-yMid, U, v); // F
                    tessellator.addVertexWithUV(zA, xA, 1-yMid, u, v); // A
                }
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

    /**
     * Processes the block sides and returns them as an array.
     * @param block Block to process.
     */
    public static boolean[] processCableSides(IBlockAccess world, int x, int y, int z, Block block)
    {
        // Prepare side and meta int arrays.
        boolean sides[] = new boolean[6];
        int metas[] = new int[4];

        // Look for machines.
        if (world.getBlock(x - 1, y, z) == HexBlocks.blockHexoriumGenerator ||
                world.getBlock(x - 1, y, z) == HexBlocks.blockHexoriumFurnace ||
                world.getBlock(x - 1, y, z) == HexBlocks.blockCrystalSeparator ||
                world.getBlock(x - 1, y, z) == HexBlocks.blockMatrixReconstructor)
            metas[0] = world.getBlockMetadata(x - 1, y, z);
        else
            metas[0] = -1;
        if (world.getBlock(x + 1, y, z) == HexBlocks.blockHexoriumGenerator ||
                world.getBlock(x + 1, y, z) == HexBlocks.blockHexoriumFurnace ||
                world.getBlock(x + 1, y, z) == HexBlocks.blockCrystalSeparator ||
                world.getBlock(x + 1, y, z) == HexBlocks.blockMatrixReconstructor)
            metas[1] = world.getBlockMetadata(x + 1, y, z);
        else
            metas[1] = -1;
        if (world.getBlock(x, y, z - 1) == HexBlocks.blockHexoriumGenerator ||
                world.getBlock(x, y, z - 1) == HexBlocks.blockHexoriumFurnace ||
                world.getBlock(x, y, z - 1) == HexBlocks.blockCrystalSeparator ||
                world.getBlock(x, y, z - 1) == HexBlocks.blockMatrixReconstructor)
            metas[2] = world.getBlockMetadata(x, y, z - 1);
        else
            metas[2] = -1;
        if (world.getBlock(x, y, z + 1) == HexBlocks.blockHexoriumGenerator ||
                world.getBlock(x, y, z + 1) == HexBlocks.blockHexoriumFurnace ||
                world.getBlock(x, y, z + 1) == HexBlocks.blockCrystalSeparator ||
                world.getBlock(x, y, z + 1) == HexBlocks.blockMatrixReconstructor)
            metas[3] = world.getBlockMetadata(x, y, z + 1);
        else
            metas[3] = -1;

        for(int i = 0; i < 4; i++) {
            if (metas[i] >= 4 && metas[i] < 8)
                metas[i] = metas[i] - 4;
            else if (metas[i] >= 8)
                metas[i] = metas[i] - 8;
        }

        // Count sides.
        if ((block == HexBlocks.blockHexoriumCableRainbow && world.getBlock(x, y - 1, z) instanceof BlockHexoriumCable) ||
                block == world.getBlock(x, y - 1, z) ||
                world.getBlock(x, y - 1, z) == HexBlocks.blockHexoriumCableRainbow ||
                (world.getBlock(x, y - 1, z) == HexBlocks.blockPylonBase51 && world.getBlockMetadata(x, y - 1, z) != 1) ||
                (world.getBlock(x, y - 1, z) == HexBlocks.blockPylonBase15 && world.getBlockMetadata(x, y - 1, z) == 1))
            sides[0] = true;
        if ((block == HexBlocks.blockHexoriumCableRainbow && world.getBlock(x, y + 1, z) instanceof BlockHexoriumCable) ||
                block == world.getBlock(x, y + 1, z) ||
                world.getBlock(x, y + 1, z) == HexBlocks.blockHexoriumCableRainbow ||
                (world.getBlock(x, y + 1, z) == HexBlocks.blockPylonBase51 && world.getBlockMetadata(x, y + 1, z) != 0) ||
                (world.getBlock(x, y + 1, z) == HexBlocks.blockPylonBase15 && world.getBlockMetadata(x, y + 1, z) == 0))
            sides[1] = true;
        if ((block == HexBlocks.blockHexoriumCableRainbow && world.getBlock(x - 1, y, z) instanceof BlockHexoriumCable) ||
                block == world.getBlock(x - 1, y, z) ||
                world.getBlock(x - 1, y, z) == HexBlocks.blockHexoriumCableRainbow ||
                (world.getBlock(x - 1, y, z) == HexBlocks.blockPylonBase51 && world.getBlockMetadata(x - 1, y, z) != 5) ||
                (world.getBlock(x - 1, y, z) == HexBlocks.blockPylonBase15 && world.getBlockMetadata(x - 1, y, z) == 5) ||
                metas[0] == 3)
            sides[2] = true;
        if ((block == HexBlocks.blockHexoriumCableRainbow && world.getBlock(x + 1, y, z) instanceof BlockHexoriumCable) ||
                block == world.getBlock(x + 1, y, z) ||
                world.getBlock(x + 1, y, z) == HexBlocks.blockHexoriumCableRainbow ||
                (world.getBlock(x + 1, y, z) == HexBlocks.blockPylonBase51 && world.getBlockMetadata(x + 1, y, z) != 4) ||
                (world.getBlock(x + 1, y, z) == HexBlocks.blockPylonBase15 && world.getBlockMetadata(x + 1, y, z) == 4) ||
                metas[1] == 1)
            sides[3] = true;
        if ((block == HexBlocks.blockHexoriumCableRainbow && world.getBlock(x, y, z - 1) instanceof BlockHexoriumCable) ||
                block == world.getBlock(x, y, z - 1) ||
                world.getBlock(x, y, z - 1) == HexBlocks.blockHexoriumCableRainbow ||
                (world.getBlock(x, y, z - 1) == HexBlocks.blockPylonBase51 && world.getBlockMetadata(x, y, z - 1) != 3) ||
                (world.getBlock(x, y, z - 1) == HexBlocks.blockPylonBase15 && world.getBlockMetadata(x, y, z - 1) == 3) ||
                metas[2] == 0)
            sides[4] = true;
        if ((block == HexBlocks.blockHexoriumCableRainbow && world.getBlock(x, y, z + 1) instanceof BlockHexoriumCable) ||
                block == world.getBlock(x, y, z + 1) ||
                world.getBlock(x, y, z + 1) == HexBlocks.blockHexoriumCableRainbow ||
                (world.getBlock(x, y, z + 1) == HexBlocks.blockPylonBase51 && world.getBlockMetadata(x, y, z + 1) != 2) ||
                (world.getBlock(x, y, z + 1) == HexBlocks.blockPylonBase15 && world.getBlockMetadata(x, y, z + 1) == 2) ||
                metas[3] == 2)
            sides[5] = true;

        return sides;
    }
}
