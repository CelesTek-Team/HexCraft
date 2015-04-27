package com.celestek.hexcraft.client.renderer;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.HexClientProxy;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-14
 */

public class HexModelRendererMonolith implements ISimpleBlockRenderingHandler {

    // Variables
    private int renderID;
    private int renderBlockID;
    private int brightness;
    private float opacity;
    private float r = 1F;
    private float g = 1F;
    private float b = 1F;
    private boolean renderStone;

    // Model constants.    
    private float yMin = 0F;
    private float yMax = 0.75F;

    private float xA = 0.1874F;
    private float xB = 0.3437F;
    private float xC = 0.6563F;
    private float xD = 0.8126F;
    private float xE = 0.6563F;
    private float xF = 0.3437F;

    private float zA = 0.5F;
    private float zB = 0.7707F;
    private float zC = 0.7707F;
    private float zD = 0.5F;
    private float zE = 0.2292F;
    private float zF = 0.2292F;

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
     * @param opacity Opacity of the monolith.
     * @param r Red component of the monolith color.
     * @param g Green component of the monolith color
     * @param b Blue component of the monolith color.
     */
    public HexModelRendererMonolith(int renderID, int brightness, float opacity, float r, float g, float b, boolean renderStone)
    {
        // Save the current HexCraft block ID.
        this.renderBlockID = HexCraft.idCounter;

        // Load the constructor parameters.
        this.renderID = renderID;
        this.brightness = brightness;
        this.opacity = opacity;
        this.r = r;
        this.g = g;
        this.b = b;
        this.renderStone = renderStone;

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
        double u = c.getInterpolatedU(sideu);
        double U = c.getInterpolatedU(sideU);
        double v = c.getInterpolatedV(sidev);
        double V = c.getInterpolatedV(sideV);

        // Top Face
        tessellator.setNormal(xB, yMax, zB);
        tessellator.addVertexWithUV(xB, yMax, zB, c.getInterpolatedU(topBu), c.getInterpolatedV(topBv)); // B
        tessellator.addVertexWithUV(xC, yMax, zC, c.getInterpolatedU(topCu), c.getInterpolatedV(topCv)); // C
        tessellator.addVertexWithUV(xD, yMax, zD, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
        tessellator.addVertexWithUV(xA, yMax, zA, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A

        tessellator.addVertexWithUV(xA, yMax, zA, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A
        tessellator.addVertexWithUV(xD, yMax, zD, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
        tessellator.addVertexWithUV(xE, yMax, zE, c.getInterpolatedU(topEu), c.getInterpolatedV(topEv)); // E
        tessellator.addVertexWithUV(xF, yMax, zF, c.getInterpolatedU(topFu), c.getInterpolatedV(topFv)); // F

        // Side Faces
        tessellator.addVertexWithUV(xF, yMax, zF, u, v); // F
        tessellator.addVertexWithUV(xE, yMax, zE, U, v); // E
        tessellator.addVertexWithUV(xE, yMin, zE, U, V); // E'
        tessellator.addVertexWithUV(xF, yMin, zF, u, V); // F'

        tessellator.addVertexWithUV(xE, yMax, zE, u, v); // E
        tessellator.addVertexWithUV(xD, yMax, zD, U, v); // D
        tessellator.addVertexWithUV(xD, yMin, zD, U, V); // D'
        tessellator.addVertexWithUV(xE, yMin, zE, u, V); // E'

        tessellator.addVertexWithUV(xD, yMax, zD, u, v); // D
        tessellator.addVertexWithUV(xC, yMax, zC, U, v); // C
        tessellator.addVertexWithUV(xC, yMin, zC, U, V); // C'
        tessellator.addVertexWithUV(xD, yMin, zD, u, V); // D'

        tessellator.addVertexWithUV(xC, yMax, zC, u, v); // C
        tessellator.addVertexWithUV(xB, yMax, zB, U, v); // B
        tessellator.addVertexWithUV(xB, yMin, zB, U, V); // B'
        tessellator.addVertexWithUV(xC, yMin, zC, u, V); // C'

        tessellator.addVertexWithUV(xB, yMax, zB, u, v); // B
        tessellator.addVertexWithUV(xA, yMax, zA, U, v); // A
        tessellator.addVertexWithUV(xA, yMin, zA, U, V); // A'
        tessellator.addVertexWithUV(xB, yMin, zB, u, V); // B'

        tessellator.addVertexWithUV(xA, yMax, zA, u, v); // A
        tessellator.addVertexWithUV(xF, yMax, zF, U, v); // F
        tessellator.addVertexWithUV(xF, yMin, zF, U, V); // F'
        tessellator.addVertexWithUV(xA, yMin, zA, u, V); // A'

        // If the stone texture should be rendered...
        if(renderStone)
        {
            // Set up brightness and color.
            tessellator.setBrightness(HexColors.brightnessBright);
            tessellator.setColorOpaque_F(1, 1, 1);

            // Prepare the icon.
            c = block.getIcon(7, 0);
            u = c.getInterpolatedU(sideu);
            U = c.getInterpolatedU(sideU);
            v = c.getInterpolatedV(sidev);
            V = c.getInterpolatedV(sideV);

            // Side Faces
            tessellator.addVertexWithUV(xF - off, yMax, zF - off, u, v); // F
            tessellator.addVertexWithUV(xE + off, yMax, zE - off, U, v); // E
            tessellator.addVertexWithUV(xE + off, yMin, zE - off, U, V); // E'
            tessellator.addVertexWithUV(xF - off, yMin, zF - off, u, V); // F'

            tessellator.addVertexWithUV(xE + off, yMax, zE - off, u, v); // E
            tessellator.addVertexWithUV(xD + off, yMax, zD      , U, v); // D
            tessellator.addVertexWithUV(xD + off, yMin, zD      , U, V); // D'
            tessellator.addVertexWithUV(xE + off, yMin, zE - off, u, V); // E'

            tessellator.addVertexWithUV(xD + off, yMax, zD      , u, v); // D
            tessellator.addVertexWithUV(xC + off, yMax, zC + off, U, v); // C
            tessellator.addVertexWithUV(xC + off, yMin, zC + off, U, V); // C'
            tessellator.addVertexWithUV(xD + off, yMin, zD      , u, V); // D'

            tessellator.addVertexWithUV(xC + off, yMax, zC + off, u, v); // C
            tessellator.addVertexWithUV(xB - off, yMax, zB + off, U, v); // B
            tessellator.addVertexWithUV(xB - off, yMin, zB + off, U, V); // B'
            tessellator.addVertexWithUV(xC + off, yMin, zC + off, u, V); // C'

            tessellator.addVertexWithUV(xB - off, yMax, zB + off, u, v); // B
            tessellator.addVertexWithUV(xA - off, yMax, zA      , U, v); // A
            tessellator.addVertexWithUV(xA - off, yMin, zA      , U, V); // A'
            tessellator.addVertexWithUV(xB - off, yMin, zB + off, u, V); // B'

            tessellator.addVertexWithUV(xA - off, yMax, zA      , u, v); // A
            tessellator.addVertexWithUV(xF - off, yMax, zF - off, U, v); // F
            tessellator.addVertexWithUV(xF - off, yMin, zF - off, U, V); // F'
            tessellator.addVertexWithUV(xA - off, yMin, zA      , u, V); // A'
        }

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

            // Set up brightness and color.
            tessellator.setBrightness(brightness);
            tessellator.setColorRGBA_F(r, g, b, opacity);

            // Prepare the icon.
            IIcon c = block.getIcon(6, 0);
            double u = c.getInterpolatedU(sideu);
            double U = c.getInterpolatedU(sideU);
            double v = c.getInterpolatedV(sidev);
            double V = c.getInterpolatedV(sideV);

            // Use the block meta to rotate the model.
            if(meta == 0) {
                // Top Face
                tessellator.addVertexWithUV(xA, 1-yMax, zA, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A
                tessellator.addVertexWithUV(xD, 1-yMax, zD, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
                tessellator.addVertexWithUV(xC, 1-yMax, zC, c.getInterpolatedU(topCu), c.getInterpolatedV(topCv)); // C
                tessellator.addVertexWithUV(xB, 1-yMax, zB, c.getInterpolatedU(topBu), c.getInterpolatedV(topBv)); // B

                tessellator.addVertexWithUV(xF, 1-yMax, zF, c.getInterpolatedU(topFu), c.getInterpolatedV(topFv)); // F
                tessellator.addVertexWithUV(xE, 1-yMax, zE, c.getInterpolatedU(topEu), c.getInterpolatedV(topEv)); // E
                tessellator.addVertexWithUV(xD, 1-yMax, zD, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
                tessellator.addVertexWithUV(xA, 1-yMax, zA, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A

                // Side Faces
                tessellator.addVertexWithUV(xF, 1-yMin, zF, u, V); // F'
                tessellator.addVertexWithUV(xE, 1-yMin, zE, U, V); // E'
                tessellator.addVertexWithUV(xE, 1-yMax, zE, U, v); // E
                tessellator.addVertexWithUV(xF, 1-yMax, zF, u, v); // F

                tessellator.addVertexWithUV(xE, 1-yMin, zE, u, V); // E'
                tessellator.addVertexWithUV(xD, 1-yMin, zD, U, V); // D'
                tessellator.addVertexWithUV(xD, 1-yMax, zD, U, v); // D
                tessellator.addVertexWithUV(xE, 1-yMax, zE, u, v); // E

                tessellator.addVertexWithUV(xD, 1-yMin, zD, u, V); // D'
                tessellator.addVertexWithUV(xC, 1-yMin, zC, U, V); // C'
                tessellator.addVertexWithUV(xC, 1-yMax, zC, U, v); // C
                tessellator.addVertexWithUV(xD, 1-yMax, zD, u, v); // D

                tessellator.addVertexWithUV(xC, 1-yMin, zC, u, V); // C'
                tessellator.addVertexWithUV(xB, 1-yMin, zB, U, V); // B'
                tessellator.addVertexWithUV(xB, 1-yMax, zB, U, v); // B
                tessellator.addVertexWithUV(xC, 1-yMax, zC, u, v); // C

                tessellator.addVertexWithUV(xB, 1-yMin, zB, u, V); // B'
                tessellator.addVertexWithUV(xA, 1-yMin, zA, U, V); // A'
                tessellator.addVertexWithUV(xA, 1-yMax, zA, U, v); // A
                tessellator.addVertexWithUV(xB, 1-yMax, zB, u, v); // B

                tessellator.addVertexWithUV(xA, 1-yMin, zA, u, V); // A'
                tessellator.addVertexWithUV(xF, 1-yMin, zF, U, V); // F'
                tessellator.addVertexWithUV(xF, 1-yMax, zF, U, v); // F
                tessellator.addVertexWithUV(xA, 1-yMax, zA, u, v); // A
            }
            else if(meta == 1) {
                // Top Face
                tessellator.addVertexWithUV(xB, yMax, zB, c.getInterpolatedU(topBu), c.getInterpolatedV(topBv)); // B
                tessellator.addVertexWithUV(xC, yMax, zC, c.getInterpolatedU(topCu), c.getInterpolatedV(topCv)); // C
                tessellator.addVertexWithUV(xD, yMax, zD, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
                tessellator.addVertexWithUV(xA, yMax, zA, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A

                tessellator.addVertexWithUV(xA, yMax, zA, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A
                tessellator.addVertexWithUV(xD, yMax, zD, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
                tessellator.addVertexWithUV(xE, yMax, zE, c.getInterpolatedU(topEu), c.getInterpolatedV(topEv)); // E
                tessellator.addVertexWithUV(xF, yMax, zF, c.getInterpolatedU(topFu), c.getInterpolatedV(topFv)); // F

                // Side Faces
                tessellator.addVertexWithUV(xF, yMax, zF, u, v); // F
                tessellator.addVertexWithUV(xE, yMax, zE, U, v); // E
                tessellator.addVertexWithUV(xE, yMin, zE, U, V); // E'
                tessellator.addVertexWithUV(xF, yMin, zF, u, V); // F'

                tessellator.addVertexWithUV(xE, yMax, zE, u, v); // E
                tessellator.addVertexWithUV(xD, yMax, zD, U, v); // D
                tessellator.addVertexWithUV(xD, yMin, zD, U, V); // D'
                tessellator.addVertexWithUV(xE, yMin, zE, u, V); // E'

                tessellator.addVertexWithUV(xD, yMax, zD, u, v); // D
                tessellator.addVertexWithUV(xC, yMax, zC, U, v); // C
                tessellator.addVertexWithUV(xC, yMin, zC, U, V); // C'
                tessellator.addVertexWithUV(xD, yMin, zD, u, V); // D'

                tessellator.addVertexWithUV(xC, yMax, zC, u, v); // C
                tessellator.addVertexWithUV(xB, yMax, zB, U, v); // B
                tessellator.addVertexWithUV(xB, yMin, zB, U, V); // B'
                tessellator.addVertexWithUV(xC, yMin, zC, u, V); // C'

                tessellator.addVertexWithUV(xB, yMax, zB, u, v); // B
                tessellator.addVertexWithUV(xA, yMax, zA, U, v); // A
                tessellator.addVertexWithUV(xA, yMin, zA, U, V); // A'
                tessellator.addVertexWithUV(xB, yMin, zB, u, V); // B'

                tessellator.addVertexWithUV(xA, yMax, zA, u, v); // A
                tessellator.addVertexWithUV(xF, yMax, zF, U, v); // F
                tessellator.addVertexWithUV(xF, yMin, zF, U, V); // F'
                tessellator.addVertexWithUV(xA, yMin, zA, u, V); // A'
            }
            else if(meta == 2) {
                // Top Face
                tessellator.addVertexWithUV(zA, xA, 1-yMax, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A
                tessellator.addVertexWithUV(zD, xD, 1-yMax, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
                tessellator.addVertexWithUV(zC, xC, 1-yMax, c.getInterpolatedU(topCu), c.getInterpolatedV(topCv)); // C
                tessellator.addVertexWithUV(zB, xB, 1-yMax, c.getInterpolatedU(topBu), c.getInterpolatedV(topBv)); // B

                tessellator.addVertexWithUV(zF, xF, 1-yMax, c.getInterpolatedU(topFu), c.getInterpolatedV(topFv)); // F
                tessellator.addVertexWithUV(zE, xE, 1-yMax, c.getInterpolatedU(topEu), c.getInterpolatedV(topEv)); // E
                tessellator.addVertexWithUV(zD, xD, 1-yMax, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
                tessellator.addVertexWithUV(zA, xA, 1-yMax, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A

                // Side Faces
                tessellator.addVertexWithUV(zF, xF, 1-yMin, u, V); // F'
                tessellator.addVertexWithUV(zE, xE, 1-yMin, U, V); // E'
                tessellator.addVertexWithUV(zE, xE, 1-yMax, U, v); // E
                tessellator.addVertexWithUV(zF, xF, 1-yMax, u, v); // F

                tessellator.addVertexWithUV(zE, xE, 1-yMin, u, V); // E'
                tessellator.addVertexWithUV(zD, xD, 1-yMin, U, V); // D'
                tessellator.addVertexWithUV(zD, xD, 1-yMax, U, v); // D
                tessellator.addVertexWithUV(zE, xE, 1-yMax, u, v); // E

                tessellator.addVertexWithUV(zD, xD, 1-yMin, u, V); // D'
                tessellator.addVertexWithUV(zC, xC, 1-yMin, U, V); // C'
                tessellator.addVertexWithUV(zC, xC, 1-yMax, U, v); // C
                tessellator.addVertexWithUV(zD, xD, 1-yMax, u, v); // D

                tessellator.addVertexWithUV(zC, xC, 1-yMin, u, V); // C'
                tessellator.addVertexWithUV(zB, xB, 1-yMin, U, V); // B'
                tessellator.addVertexWithUV(zB, xB, 1-yMax, U, v); // B
                tessellator.addVertexWithUV(zC, xC, 1-yMax, u, v); // C

                tessellator.addVertexWithUV(zB, xB, 1-yMin, u, V); // B'
                tessellator.addVertexWithUV(zA, xA, 1-yMin, U, V); // A'
                tessellator.addVertexWithUV(zA, xA, 1-yMax, U, v); // A
                tessellator.addVertexWithUV(zB, xB, 1-yMax, u, v); // B

                tessellator.addVertexWithUV(zA, xA, 1-yMin, u, V); // A'
                tessellator.addVertexWithUV(zF, xF, 1-yMin, U, V); // F'
                tessellator.addVertexWithUV(zF, xF, 1-yMax, U, v); // F
                tessellator.addVertexWithUV(zA, xA, 1-yMax, u, v); // A
                }
            else if(meta == 3) {
                // TopFace
                tessellator.addVertexWithUV(zB, xB, yMax, c.getInterpolatedU(topBu), c.getInterpolatedV(topBv)); // B
                tessellator.addVertexWithUV(zC, xC, yMax, c.getInterpolatedU(topCu), c.getInterpolatedV(topCv)); // C
                tessellator.addVertexWithUV(zD, xD, yMax, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
                tessellator.addVertexWithUV(zA, xA, yMax, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A

                tessellator.addVertexWithUV(zA, xA, yMax, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A
                tessellator.addVertexWithUV(zD, xD, yMax, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
                tessellator.addVertexWithUV(zE, xE, yMax, c.getInterpolatedU(topEu), c.getInterpolatedV(topEv)); // E
                tessellator.addVertexWithUV(zF, xF, yMax, c.getInterpolatedU(topFu), c.getInterpolatedV(topFv)); // F

                // Side Faces
                tessellator.addVertexWithUV(zF, xF, yMax, u, v); // F
                tessellator.addVertexWithUV(zE, xE, yMax, U, v); // E
                tessellator.addVertexWithUV(zE, xE, yMin, U, V); // E'
                tessellator.addVertexWithUV(zF, xF, yMin, u, V); // F'

                tessellator.addVertexWithUV(zE, xE, yMax, u, v); // E
                tessellator.addVertexWithUV(zD, xD, yMax, U, v); // D
                tessellator.addVertexWithUV(zD, xD, yMin, U, V); // D'
                tessellator.addVertexWithUV(zE, xE, yMin, u, V); // E'

                tessellator.addVertexWithUV(zD, xD, yMax, u, v); // D
                tessellator.addVertexWithUV(zC, xC, yMax, U, v); // C
                tessellator.addVertexWithUV(zC, xC, yMin, U, V); // C'
                tessellator.addVertexWithUV(zD, xD, yMin, u, V); // D'

                tessellator.addVertexWithUV(zC, xC, yMax, u, v); // C
                tessellator.addVertexWithUV(zB, xB, yMax, U, v); // B
                tessellator.addVertexWithUV(zB, xB, yMin, U, V); // B'
                tessellator.addVertexWithUV(zC, xC, yMin, u, V); // C'

                tessellator.addVertexWithUV(zB, xB, yMax, u, v); // B
                tessellator.addVertexWithUV(zA, xA, yMax, U, v); // A
                tessellator.addVertexWithUV(zA, xA, yMin, U, V); // A'
                tessellator.addVertexWithUV(zB, xB, yMin, u, V); // B'

                tessellator.addVertexWithUV(zA, xA, yMax, u, v); // A
                tessellator.addVertexWithUV(zF, xF, yMax, U, v); // F
                tessellator.addVertexWithUV(zF, xF, yMin, U, V); // F'
                tessellator.addVertexWithUV(zA, xA, yMin, u, V); // A'
            }
            else if(meta == 4) {
                // Top Face
                tessellator.addVertexWithUV(1-yMax, xB, zB, c.getInterpolatedU(topBu), c.getInterpolatedV(topBv)); // B
                tessellator.addVertexWithUV(1-yMax, xC, zC, c.getInterpolatedU(topCu), c.getInterpolatedV(topCv)); // C
                tessellator.addVertexWithUV(1-yMax, xD, zD, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
                tessellator.addVertexWithUV(1-yMax, xA, zA, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A

                tessellator.addVertexWithUV(1-yMax, xA, zA, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A
                tessellator.addVertexWithUV(1-yMax, xD, zD, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
                tessellator.addVertexWithUV(1-yMax, xE, zE, c.getInterpolatedU(topEu), c.getInterpolatedV(topEv)); // E
                tessellator.addVertexWithUV(1-yMax, xF, zF, c.getInterpolatedU(topFu), c.getInterpolatedV(topFv)); // F

                // Side Faces
                tessellator.addVertexWithUV(1-yMax, xF, zF, u, v); // F
                tessellator.addVertexWithUV(1-yMax, xE, zE, U, v); // E
                tessellator.addVertexWithUV(1-yMin, xE, zE, U, V); // E'
                tessellator.addVertexWithUV(1-yMin, xF, zF, u, V); // F'

                tessellator.addVertexWithUV(1-yMax, xE, zE, u, v); // E
                tessellator.addVertexWithUV(1-yMax, xD, zD, U, v); // D
                tessellator.addVertexWithUV(1-yMin, xD, zD, U, V); // D'
                tessellator.addVertexWithUV(1-yMin, xE, zE, u, V); // E'

                tessellator.addVertexWithUV(1-yMax, xD, zD, u, v); // D
                tessellator.addVertexWithUV(1-yMax, xC, zC, U, v); // C
                tessellator.addVertexWithUV(1-yMin, xC, zC, U, V); // C'
                tessellator.addVertexWithUV(1-yMin, xD, zD, u, V); // D'

                tessellator.addVertexWithUV(1-yMax, xC, zC, u, v); // C
                tessellator.addVertexWithUV(1-yMax, xB, zB, U, v); // B
                tessellator.addVertexWithUV(1-yMin, xB, zB, U, V); // B'
                tessellator.addVertexWithUV(1-yMin, xC, zC, u, V); // C'

                tessellator.addVertexWithUV(1-yMax, xB, zB, u, v); // B
                tessellator.addVertexWithUV(1-yMax, xA, zA, U, v); // A
                tessellator.addVertexWithUV(1-yMin, xA, zA, U, V); // A'
                tessellator.addVertexWithUV(1-yMin, xB, zB, u, V); // B'

                tessellator.addVertexWithUV(1-yMax, xA, zA, u, v); // A
                tessellator.addVertexWithUV(1-yMax, xF, zF, U, v); // F
                tessellator.addVertexWithUV(1-yMin, xF, zF, U, V); // F'
                tessellator.addVertexWithUV(1-yMin, xA, zA, u, V); // A'
            }
            else if(meta == 5) {
                // Top Face
                tessellator.addVertexWithUV(yMax, xA, zA, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A
                tessellator.addVertexWithUV(yMax, xD, zD, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
                tessellator.addVertexWithUV(yMax, xC, zC, c.getInterpolatedU(topCu), c.getInterpolatedV(topCv)); // C
                tessellator.addVertexWithUV(yMax, xB, zB, c.getInterpolatedU(topBu), c.getInterpolatedV(topBv)); // B

                tessellator.addVertexWithUV(yMax, xF, zF, c.getInterpolatedU(topFu), c.getInterpolatedV(topFv)); // F
                tessellator.addVertexWithUV(yMax, xE, zE, c.getInterpolatedU(topEu), c.getInterpolatedV(topEv)); // E
                tessellator.addVertexWithUV(yMax, xD, zD, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
                tessellator.addVertexWithUV(yMax, xA, zA, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A

                // Side Faces
                tessellator.addVertexWithUV(yMin, xF, zF, u, V); // F'
                tessellator.addVertexWithUV(yMin, xE, zE, U, V); // E'
                tessellator.addVertexWithUV(yMax, xE, zE, U, v); // E
                tessellator.addVertexWithUV(yMax, xF, zF, u, v); // F

                tessellator.addVertexWithUV(yMin, xE, zE, u, V); // E'
                tessellator.addVertexWithUV(yMin, xD, zD, U, V); // D'
                tessellator.addVertexWithUV(yMax, xD, zD, U, v); // D
                tessellator.addVertexWithUV(yMax, xE, zE, u, v); // E

                tessellator.addVertexWithUV(yMin, xD, zD, u, V); // D'
                tessellator.addVertexWithUV(yMin, xC, zC, U, V); // C'
                tessellator.addVertexWithUV(yMax, xC, zC, U, v); // C
                tessellator.addVertexWithUV(yMax, xD, zD, u, v); // D

                tessellator.addVertexWithUV(yMin, xC, zC, u, V); // C'
                tessellator.addVertexWithUV(yMin, xB, zB, U, V); // B'
                tessellator.addVertexWithUV(yMax, xB, zB, U, v); // B
                tessellator.addVertexWithUV(yMax, xC, zC, u, v); // C

                tessellator.addVertexWithUV(yMin, xB, zB, u, V); // B'
                tessellator.addVertexWithUV(yMin, xA, zA, U, V); // A'
                tessellator.addVertexWithUV(yMax, xA, zA, U, v); // A
                tessellator.addVertexWithUV(yMax, xB, zB, u, v); // B

                tessellator.addVertexWithUV(yMin, xA, zA, u, V); // A'
                tessellator.addVertexWithUV(yMin, xF, zF, U, V); // F'
                tessellator.addVertexWithUV(yMax, xF, zF, U, v); // F
                tessellator.addVertexWithUV(yMax, xA, zA, u, v); // A
            }

            // If the stone texture should be rendered...
            if(renderStone)
            {
                // Set up brightness and color.
                tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
                tessellator.setColorOpaque_F(1, 1, 1);

                // Prepare the icon.
                c = block.getIcon(7, 0);
                u = c.getInterpolatedU(sideu);
                U = c.getInterpolatedU(sideU);
                v = c.getInterpolatedV(sidev);
                V = c.getInterpolatedV(sideV);

                // Use the block meta to rotate the model.
                if(meta == 0) {
                    // Side Faces
                    tessellator.addVertexWithUV(xF - off, 1-yMin, zF - off, u, V); // F'
                    tessellator.addVertexWithUV(xE + off, 1-yMin, zE - off, U, V); // E'
                    tessellator.addVertexWithUV(xE + off, 1-yMax, zE - off, U, v); // E
                    tessellator.addVertexWithUV(xF - off, 1-yMax, zF - off, u, v); // F

                    tessellator.addVertexWithUV(xE + off, 1-yMin, zE - off, u, V); // E'
                    tessellator.addVertexWithUV(xD + off, 1-yMin, zD      , U, V); // D'
                    tessellator.addVertexWithUV(xD + off, 1-yMax, zD      , U, v); // D
                    tessellator.addVertexWithUV(xE + off, 1-yMax, zE - off, u, v); // E

                    tessellator.addVertexWithUV(xD + off, 1-yMin, zD      , u, V); // D'
                    tessellator.addVertexWithUV(xC + off, 1-yMin, zC + off, U, V); // C'
                    tessellator.addVertexWithUV(xC + off, 1-yMax, zC + off, U, v); // C
                    tessellator.addVertexWithUV(xD + off, 1-yMax, zD      , u, v); // D

                    tessellator.addVertexWithUV(xC + off, 1-yMin, zC + off, u, V); // C'
                    tessellator.addVertexWithUV(xB - off, 1-yMin, zB + off, U, V); // B'
                    tessellator.addVertexWithUV(xB - off, 1-yMax, zB + off, U, v); // B
                    tessellator.addVertexWithUV(xC + off, 1-yMax, zC + off, u, v); // C

                    tessellator.addVertexWithUV(xB - off, 1-yMin, zB + off, u, V); // B'
                    tessellator.addVertexWithUV(xA - off, 1-yMin, zA      , U, V); // A'
                    tessellator.addVertexWithUV(xA - off, 1-yMax, zA      , U, v); // A
                    tessellator.addVertexWithUV(xB - off, 1-yMax, zB + off, u, v); // B

                    tessellator.addVertexWithUV(xA - off, 1-yMin, zA      , u, V); // A'
                    tessellator.addVertexWithUV(xF - off, 1-yMin, zF - off, U, V); // F'
                    tessellator.addVertexWithUV(xF - off, 1-yMax, zF - off, U, v); // F
                    tessellator.addVertexWithUV(xA - off, 1-yMax, zA      , u, v); // A
                }
                else if(meta == 1) {
                    // Side Faces
                    tessellator.addVertexWithUV(xF - off, yMax, zF - off, u, v); // F
                    tessellator.addVertexWithUV(xE + off, yMax, zE - off, U, v); // E
                    tessellator.addVertexWithUV(xE + off, yMin, zE - off, U, V); // E'
                    tessellator.addVertexWithUV(xF - off, yMin, zF - off, u, V); // F'

                    tessellator.addVertexWithUV(xE + off, yMax, zE - off, u, v); // E
                    tessellator.addVertexWithUV(xD + off, yMax, zD      , U, v); // D
                    tessellator.addVertexWithUV(xD + off, yMin, zD      , U, V); // D'
                    tessellator.addVertexWithUV(xE + off, yMin, zE - off, u, V); // E'

                    tessellator.addVertexWithUV(xD + off, yMax, zD      , u, v); // D
                    tessellator.addVertexWithUV(xC + off, yMax, zC + off, U, v); // C
                    tessellator.addVertexWithUV(xC + off, yMin, zC + off, U, V); // C'
                    tessellator.addVertexWithUV(xD + off, yMin, zD      , u, V); // D'

                    tessellator.addVertexWithUV(xC + off, yMax, zC + off, u, v); // C
                    tessellator.addVertexWithUV(xB - off, yMax, zB + off, U, v); // B
                    tessellator.addVertexWithUV(xB - off, yMin, zB + off, U, V); // B'
                    tessellator.addVertexWithUV(xC + off, yMin, zC + off, u, V); // C'

                    tessellator.addVertexWithUV(xB - off, yMax, zB + off, u, v); // B
                    tessellator.addVertexWithUV(xA - off, yMax, zA      , U, v); // A
                    tessellator.addVertexWithUV(xA - off, yMin, zA      , U, V); // A'
                    tessellator.addVertexWithUV(xB - off, yMin, zB + off, u, V); // B'

                    tessellator.addVertexWithUV(xA - off, yMax, zA      , u, v); // A
                    tessellator.addVertexWithUV(xF - off, yMax, zF - off, U, v); // F
                    tessellator.addVertexWithUV(xF - off, yMin, zF - off, U, V); // F'
                    tessellator.addVertexWithUV(xA - off, yMin, zA      , u, V); // A'
                }
                else if(meta == 2) {
                    // Side Faces
                    tessellator.addVertexWithUV(zF - off, xF - off, 1-yMax, u, v); // F
                    tessellator.addVertexWithUV(zE - off, xE + off, 1-yMin, U, V); // E'
                    tessellator.addVertexWithUV(zE - off, xE + off, 1-yMax, U, v); // E
                    tessellator.addVertexWithUV(zF - off, xF - off, 1-yMin, u, V); // F'

                    tessellator.addVertexWithUV(zE - off, xE + off, 1-yMin, u, V); // E'
                    tessellator.addVertexWithUV(zD      , xD + off, 1-yMin, U, V); // D'
                    tessellator.addVertexWithUV(zD      , xD + off, 1-yMax, U, v); // D
                    tessellator.addVertexWithUV(zE - off, xE + off, 1-yMax, u, v); // E

                    tessellator.addVertexWithUV(zD      , xD + off, 1-yMin, u, V); // D'
                    tessellator.addVertexWithUV(zC + off, xC + off, 1-yMin, U, V); // C'
                    tessellator.addVertexWithUV(zC + off, xC + off, 1-yMax, U, v); // C
                    tessellator.addVertexWithUV(zD      , xD + off, 1-yMax, u, v); // D

                    tessellator.addVertexWithUV(zC + off, xC + off, 1-yMin, u, V); // C'
                    tessellator.addVertexWithUV(zB + off, xB - off, 1-yMin, U, V); // B'
                    tessellator.addVertexWithUV(zB + off, xB - off, 1-yMax, U, v); // B
                    tessellator.addVertexWithUV(zC + off, xC + off, 1-yMax, u, v); // C

                    tessellator.addVertexWithUV(zB + off, xB - off, 1-yMin, u, V); // B'
                    tessellator.addVertexWithUV(zA      , xA - off, 1-yMin, U, V); // A'
                    tessellator.addVertexWithUV(zA      , xA - off, 1-yMax, U, v); // A
                    tessellator.addVertexWithUV(zB + off, xB - off, 1-yMax, u, v); // B

                    tessellator.addVertexWithUV(zA      , xA - off, 1-yMin, u, V); // A'
                    tessellator.addVertexWithUV(zF - off, xF - off, 1-yMin, U, V); // F'
                    tessellator.addVertexWithUV(zF - off, xF - off, 1-yMax, U, v); // F
                    tessellator.addVertexWithUV(zA      , xA - off, 1-yMax, u, v); // A
                }
                else if(meta == 3) {
                    // Side Faces
                    tessellator.addVertexWithUV(zF - off, xF - off, yMax, u, v); // F
                    tessellator.addVertexWithUV(zE - off, xE + off, yMax, U, v); // E
                    tessellator.addVertexWithUV(zE - off, xE + off, yMin, U, V); // E'
                    tessellator.addVertexWithUV(zF - off, xF - off, yMin, u, V); // F'

                    tessellator.addVertexWithUV(zE - off, xE + off, yMax, u, v); // E
                    tessellator.addVertexWithUV(zD      , xD + off, yMax, U, v); // D
                    tessellator.addVertexWithUV(zD      , xD + off, yMin, U, V); // D'
                    tessellator.addVertexWithUV(zE - off, xE + off, yMin, u, V); // E'

                    tessellator.addVertexWithUV(zD      , xD + off, yMax, u, v); // D
                    tessellator.addVertexWithUV(zC + off, xC + off, yMax, U, v); // C
                    tessellator.addVertexWithUV(zC + off, xC + off, yMin, U, V); // C'
                    tessellator.addVertexWithUV(zD      , xD + off, yMin, u, V); // D'

                    tessellator.addVertexWithUV(zC + off, xC + off, yMax, u, v); // C
                    tessellator.addVertexWithUV(zB + off, xB - off, yMax, U, v); // B
                    tessellator.addVertexWithUV(zB + off, xB - off, yMin, U, V); // B'
                    tessellator.addVertexWithUV(zC + off, xC + off, yMin, u, V); // C'

                    tessellator.addVertexWithUV(zB + off, xB - off, yMax, u, v); // B
                    tessellator.addVertexWithUV(zA      , xA - off, yMax, U, v); // A
                    tessellator.addVertexWithUV(zA      , xA - off, yMin, U, V); // A'
                    tessellator.addVertexWithUV(zB + off, xB - off, yMin, u, V); // B'

                    tessellator.addVertexWithUV(zA      , xA - off, yMax, u, v); // A
                    tessellator.addVertexWithUV(zF - off, xF - off, yMax, U, v); // F
                    tessellator.addVertexWithUV(zF - off, xF - off, yMin, U, V); // F'
                    tessellator.addVertexWithUV(zA      , xA - off, yMin, u, V); // A'
                }
                else if(meta == 4) {
                    // Side Faces
                    tessellator.addVertexWithUV(1-yMax, xF - off, zF - off, u, v); // F
                    tessellator.addVertexWithUV(1-yMax, xE + off, zE - off, U, v); // E
                    tessellator.addVertexWithUV(1-yMin, xE + off, zE - off, U, V); // E'
                    tessellator.addVertexWithUV(1-yMin, xF - off, zF - off, u, V); // F'

                    tessellator.addVertexWithUV(1-yMax, xE + off, zE - off, u, v); // E
                    tessellator.addVertexWithUV(1-yMax, xD + off, zD      , U, v); // D
                    tessellator.addVertexWithUV(1-yMin, xD + off, zD      , U, V); // D'
                    tessellator.addVertexWithUV(1-yMin, xE + off, zE - off, u, V); // E'

                    tessellator.addVertexWithUV(1-yMax, xD + off, zD      , u, v); // D
                    tessellator.addVertexWithUV(1-yMax, xC + off, zC + off, U, v); // C
                    tessellator.addVertexWithUV(1-yMin, xC + off, zC + off, U, V); // C'
                    tessellator.addVertexWithUV(1-yMin, xD + off, zD      , u, V); // D'

                    tessellator.addVertexWithUV(1-yMax, xC + off, zC + off, u, v); // C
                    tessellator.addVertexWithUV(1-yMax, xB - off, zB + off, U, v); // B
                    tessellator.addVertexWithUV(1-yMin, xB - off, zB + off, U, V); // B'
                    tessellator.addVertexWithUV(1-yMin, xC + off, zC + off, u, V); // C'

                    tessellator.addVertexWithUV(1-yMax, xB - off, zB + off, u, v); // B
                    tessellator.addVertexWithUV(1-yMax, xA - off, zA      , U, v); // A
                    tessellator.addVertexWithUV(1-yMin, xA - off, zA      , U, V); // A'
                    tessellator.addVertexWithUV(1-yMin, xB - off, zB + off, u, V); // B'

                    tessellator.addVertexWithUV(1-yMax, xA - off, zA      , u, v); // A
                    tessellator.addVertexWithUV(1-yMax, xF - off, zF - off, U, v); // F
                    tessellator.addVertexWithUV(1-yMin, xF - off, zF - off, U, V); // F'
                    tessellator.addVertexWithUV(1-yMin, xA - off, zA      , u, V); // A'
                }
                else if(meta == 5) {
                    // Side Faces
                    tessellator.addVertexWithUV(yMin, xF - off, zF - off, u, V); // F'
                    tessellator.addVertexWithUV(yMin, xE + off, zE - off, U, V); // E'
                    tessellator.addVertexWithUV(yMax, xE + off, zE - off, U, v); // E
                    tessellator.addVertexWithUV(yMax, xF - off, zF - off, u, v); // F

                    tessellator.addVertexWithUV(yMin, xE + off, zE - off, u, V); // E'
                    tessellator.addVertexWithUV(yMin, xD + off, zD      , U, V); // D'
                    tessellator.addVertexWithUV(yMax, xD + off, zD      , U, v); // D
                    tessellator.addVertexWithUV(yMax, xE + off, zE - off, u, v); // E

                    tessellator.addVertexWithUV(yMin, xD + off, zD      , u, V); // D'
                    tessellator.addVertexWithUV(yMin, xC + off, zC + off, U, V); // C'
                    tessellator.addVertexWithUV(yMax, xC + off, zC + off, U, v); // C
                    tessellator.addVertexWithUV(yMax, xD + off, zD      , u, v); // D

                    tessellator.addVertexWithUV(yMin, xC + off, zC + off, u, V); // C'
                    tessellator.addVertexWithUV(yMin, xB - off, zB + off, U, V); // B'
                    tessellator.addVertexWithUV(yMax, xB - off, zB + off, U, v); // B
                    tessellator.addVertexWithUV(yMax, xC + off, zC + off, u, v); // C

                    tessellator.addVertexWithUV(yMin, xB - off, zB + off, u, V); // B'
                    tessellator.addVertexWithUV(yMin, xA - off, zA      , U, V); // A'
                    tessellator.addVertexWithUV(yMax, xA - off, zA      , U, v); // A
                    tessellator.addVertexWithUV(yMax, xB - off, zB + off, u, v); // B

                    tessellator.addVertexWithUV(yMin, xA - off, zA      , u, V); // A'
                    tessellator.addVertexWithUV(yMin, xF - off, zF - off, U, V); // F'
                    tessellator.addVertexWithUV(yMax, xF - off, zF - off, U, v); // F
                    tessellator.addVertexWithUV(yMax, xA - off, zA      , u, v); // A
                }
            }

            tessellator.addTranslation(-x, -y, -z);
        }
        // If this is the first (opaque) render pass...
        else {
            // If Tessellator doesn't do anything, it will crash, so make a dummy quad.
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
