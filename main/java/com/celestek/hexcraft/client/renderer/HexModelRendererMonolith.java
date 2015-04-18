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

    /** Variables */
    private int renderID;
    private int renderBlockID;
    private int brightness;
    private float r = 1F;
    private float g = 1F;
    private float b = 1F;

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

    /**
     * Constructor for custom rendering.
     * @param renderID Minecraft's internal ID of a certain block.
     * @param brightness Intensity of the inner block layer glow.
     * @param r Red component of the inner block layer color.
     * @param g Green component of the inner block layer color.
     * @param b Blue component of the inner block layer color.
     */
    public HexModelRendererMonolith(int renderID, int brightness, float r, float g, float b)
    {
        /** Save the current HexCraft block ID. */
        this.renderBlockID = HexCraft.idCounter;

        this.renderID = renderID;
        this.brightness = brightness;
        this.r = r;
        this.g = g;
        this.b = b;

        /* Increment block counter in HexCraft class. */
        HexCraft.idCounter++;
    }

    /**
     * Render the inventory block icon.
     */
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
    {
        /** Prepare the Tessellator */
        Tessellator tessellator = Tessellator.instance;
        tessellator.addTranslation(-0.5F, -0.5F, -0.5F);
        tessellator.startDrawingQuads();

        /** Set up brightness and color. */
        tessellator.setBrightness(brightness);
        tessellator.setColorRGBA_F(r, g, b, 0.75F);

        /** Top Face */
        IIcon c = block.getIcon(6, 0);
        tessellator.setNormal(xB, yMax, zB);
        tessellator.addVertexWithUV(xB, yMax, zB, c.getInterpolatedU(topBu), c.getInterpolatedV(topBv)); // B
        tessellator.addVertexWithUV(xC, yMax, zC, c.getInterpolatedU(topCu), c.getInterpolatedV(topCv)); // C
        tessellator.addVertexWithUV(xD, yMax, zD, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
        tessellator.addVertexWithUV(xA, yMax, zA, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A

        tessellator.addVertexWithUV(xA, yMax, zA, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A
        tessellator.addVertexWithUV(xD, yMax, zD, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
        tessellator.addVertexWithUV(xE, yMax, zE, c.getInterpolatedU(topEu), c.getInterpolatedV(topEv)); // E
        tessellator.addVertexWithUV(xF, yMax, zF, c.getInterpolatedU(topFu), c.getInterpolatedV(topFv)); // F

        /** Side Faces */
        double u = c.getInterpolatedU(sideu);
        double U = c.getInterpolatedU(sideU);
        double v = c.getInterpolatedV(sidev);
        double V = c.getInterpolatedV(sideV);

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

        tessellator.draw();
        tessellator.addTranslation(0.5F, 0.5F, 0.5F);
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
     * Renders the block in world.
     */
    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        /** Fetch block data. */
        int meta = world.getBlockMetadata(x, y, z);
        System.out.println("Metadata: " + meta);

        /** Prepare the Tessellator */
        Tessellator tessellator = Tessellator.instance;

        /** Check if this is the first (opaque) render pass, if it is... */
        if(HexClientProxy.renderPass[renderBlockID] == 1) {

            /** More tessellator preparation. */
            tessellator.addTranslation(x, y, z);

            /** Set up brightness and color. */
            tessellator.setBrightness(brightness);
            tessellator.setColorRGBA_F(r, g, b, 0.75F);

            /** Prepare the icon */
            IIcon c = block.getIcon(6, 0);
            double u = c.getInterpolatedU(sideu);
            double U = c.getInterpolatedU(sideU);
            double v = c.getInterpolatedV(sidev);
            double V = c.getInterpolatedV(sideV);

            if(meta == 0) {
                // world.getBlock(x, y, z).setBlockBounds(0.1874F, 1 - 0F, 0.2292F, 0.8126F, 1 - 0.75F, 0.7707F);

                /** Top Face */
                tessellator.addVertexWithUV(xA, 1-yMax, zA, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A
                tessellator.addVertexWithUV(xD, 1-yMax, zD, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
                tessellator.addVertexWithUV(xC, 1-yMax, zC, c.getInterpolatedU(topCu), c.getInterpolatedV(topCv)); // C
                tessellator.addVertexWithUV(xB, 1-yMax, zB, c.getInterpolatedU(topBu), c.getInterpolatedV(topBv)); // B

                tessellator.addVertexWithUV(xF, 1-yMax, zF, c.getInterpolatedU(topFu), c.getInterpolatedV(topFv)); // F
                tessellator.addVertexWithUV(xE, 1-yMax, zE, c.getInterpolatedU(topEu), c.getInterpolatedV(topEv)); // E
                tessellator.addVertexWithUV(xD, 1-yMax, zD, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
                tessellator.addVertexWithUV(xA, 1-yMax, zA, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A

                /** Side Faces */
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
                // world.getBlock(x, y, z).setBlockBounds(0.1874F, 0F, 0.2292F, 0.8126F, 0.75F, 0.7707F);

                /** Top Face */
                tessellator.addVertexWithUV(xB, yMax, zB, c.getInterpolatedU(topBu), c.getInterpolatedV(topBv)); // B
                tessellator.addVertexWithUV(xC, yMax, zC, c.getInterpolatedU(topCu), c.getInterpolatedV(topCv)); // C
                tessellator.addVertexWithUV(xD, yMax, zD, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
                tessellator.addVertexWithUV(xA, yMax, zA, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A

                tessellator.addVertexWithUV(xA, yMax, zA, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A
                tessellator.addVertexWithUV(xD, yMax, zD, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
                tessellator.addVertexWithUV(xE, yMax, zE, c.getInterpolatedU(topEu), c.getInterpolatedV(topEv)); // E
                tessellator.addVertexWithUV(xF, yMax, zF, c.getInterpolatedU(topFu), c.getInterpolatedV(topFv)); // F

                /** Side Faces */
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
                // world.getBlock(x, y, z).setBlockBounds(0.1874F, 1 - 0F, 0.2292F, 0.8126F, 1 - 0.75F, 0.7707F);

                /** Top Face */
                tessellator.addVertexWithUV(xB, zB, 1-yMax, c.getInterpolatedU(topBu), c.getInterpolatedV(topBv)); // B
                tessellator.addVertexWithUV(xC, zC, 1-yMax, c.getInterpolatedU(topCu), c.getInterpolatedV(topCv)); // C
                tessellator.addVertexWithUV(xD, zD, 1-yMax, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
                tessellator.addVertexWithUV(xA, zA, 1-yMax, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A

                tessellator.addVertexWithUV(xA, zA, 1-yMax, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A
                tessellator.addVertexWithUV(xD, zD, 1-yMax, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
                tessellator.addVertexWithUV(xE, zE, 1-yMax, c.getInterpolatedU(topEu), c.getInterpolatedV(topEv)); // E
                tessellator.addVertexWithUV(xF, zF, 1-yMax, c.getInterpolatedU(topFu), c.getInterpolatedV(topFv)); // F

                /** Side Faces */
                tessellator.addVertexWithUV(xF, zF, 1-yMax, u, v); // F
                tessellator.addVertexWithUV(xE, zE, 1-yMax, U, v); // E
                tessellator.addVertexWithUV(xE, zE, 1-yMin, U, V); // E'
                tessellator.addVertexWithUV(xF, zF, 1-yMin, u, V); // F'

                tessellator.addVertexWithUV(xE, zE, 1-yMax, u, v); // E
                tessellator.addVertexWithUV(xD, zD, 1-yMax, U, v); // D
                tessellator.addVertexWithUV(xD, zD, 1-yMin, U, V); // D'
                tessellator.addVertexWithUV(xE, zE, 1-yMin, u, V); // E'

                tessellator.addVertexWithUV(xD, zD, 1-yMax, u, v); // D
                tessellator.addVertexWithUV(xC, zC, 1-yMax, U, v); // C
                tessellator.addVertexWithUV(xC, zC, 1-yMin, U, V); // C'
                tessellator.addVertexWithUV(xD, zD, 1-yMin, u, V); // D'

                tessellator.addVertexWithUV(xC, zC, 1-yMax, u, v); // C
                tessellator.addVertexWithUV(xB, zB, 1-yMax, U, v); // B
                tessellator.addVertexWithUV(xB, zB, 1-yMin, U, V); // B'
                tessellator.addVertexWithUV(xC, zC, 1-yMin, u, V); // C'

                tessellator.addVertexWithUV(xB, zB, 1-yMax, u, v); // B
                tessellator.addVertexWithUV(xA, zA, 1-yMax, U, v); // A
                tessellator.addVertexWithUV(xA, zA, 1-yMin, U, V); // A'
                tessellator.addVertexWithUV(xB, zB, 1-yMin, u, V); // B'

                tessellator.addVertexWithUV(xA, zA, 1-yMax, u, v); // A
                tessellator.addVertexWithUV(xF, zF, 1-yMax, U, v); // F
                tessellator.addVertexWithUV(xF, zF, 1-yMin, U, V); // F'
                tessellator.addVertexWithUV(xA, zA, 1-yMin, u, V); // A'
            }
            else if(meta == 3) {
                // world.getBlock(x, y, z).setBlockBounds(0.1874F, 1 - 0F, 0.2292F, 0.8126F, 1 - 0.75F, 0.7707F);

                /** Top Face */
                tessellator.addVertexWithUV(xA, zA, yMax, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A
                tessellator.addVertexWithUV(xD, zD, yMax, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
                tessellator.addVertexWithUV(xC, zC, yMax, c.getInterpolatedU(topCu), c.getInterpolatedV(topCv)); // C
                tessellator.addVertexWithUV(xB, zB, yMax, c.getInterpolatedU(topBu), c.getInterpolatedV(topBv)); // B

                tessellator.addVertexWithUV(xF, zF, yMax, c.getInterpolatedU(topFu), c.getInterpolatedV(topFv)); // F
                tessellator.addVertexWithUV(xE, zE, yMax, c.getInterpolatedU(topEu), c.getInterpolatedV(topEv)); // E
                tessellator.addVertexWithUV(xD, zD, yMax, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
                tessellator.addVertexWithUV(xA, zA, yMax, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A

                /** Side Faces */
                tessellator.addVertexWithUV(xF, zF, yMin, u, V); // F'
                tessellator.addVertexWithUV(xE, zE, yMin, U, V); // E'
                tessellator.addVertexWithUV(xE, zE, yMax, U, v); // E
                tessellator.addVertexWithUV(xF, zF, yMax, u, v); // F

                tessellator.addVertexWithUV(xE, zE, yMin, u, V); // E'
                tessellator.addVertexWithUV(xD, zD, yMin, U, V); // D'
                tessellator.addVertexWithUV(xD, zD, yMax, U, v); // D
                tessellator.addVertexWithUV(xE, zE, yMax, u, v); // E

                tessellator.addVertexWithUV(xD, zD, yMin, u, V); // D'
                tessellator.addVertexWithUV(xC, zC, yMin, U, V); // C'
                tessellator.addVertexWithUV(xC, zC, yMax, U, v); // C
                tessellator.addVertexWithUV(xD, zD, yMax, u, v); // D

                tessellator.addVertexWithUV(xC, zC, yMin, u, V); // C'
                tessellator.addVertexWithUV(xB, zB, yMin, U, V); // B'
                tessellator.addVertexWithUV(xB, zB, yMax, U, v); // B
                tessellator.addVertexWithUV(xC, zC, yMax, u, v); // C

                tessellator.addVertexWithUV(xB, zB, yMin, u, V); // B'
                tessellator.addVertexWithUV(xA, zA, yMin, U, V); // A'
                tessellator.addVertexWithUV(xA, zA, yMax, U, v); // A
                tessellator.addVertexWithUV(xB, zB, yMax, u, v); // B

                tessellator.addVertexWithUV(xA, zA, yMin, u, V); // A'
                tessellator.addVertexWithUV(xF, zF, yMin, U, V); // F'
                tessellator.addVertexWithUV(xF, zF, yMax, U, v); // F
                tessellator.addVertexWithUV(xA, zA, yMax, u, v); // A
            }
            else if(meta == 4) {
                // world.getBlock(x, y, z).setBlockBounds(0.1874F, 1 - 0F, 0.2292F, 0.8126F, 1 - 0.75F, 0.7707F);

                /** Top Face */
                tessellator.addVertexWithUV(1-yMax, xB, zB, c.getInterpolatedU(topBu), c.getInterpolatedV(topBv)); // B
                tessellator.addVertexWithUV(1-yMax, xC, zC, c.getInterpolatedU(topCu), c.getInterpolatedV(topCv)); // C
                tessellator.addVertexWithUV(1-yMax, xD, zD, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
                tessellator.addVertexWithUV(1-yMax, xA, zA, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A

                tessellator.addVertexWithUV(1-yMax, xA, zA, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A
                tessellator.addVertexWithUV(1-yMax, xD, zD, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
                tessellator.addVertexWithUV(1-yMax, xE, zE, c.getInterpolatedU(topEu), c.getInterpolatedV(topEv)); // E
                tessellator.addVertexWithUV(1-yMax, xF, zF, c.getInterpolatedU(topFu), c.getInterpolatedV(topFv)); // F

                /** Side Faces */
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
                // world.getBlock(x, y, z).setBlockBounds(0.1874F, 1 - 0F, 0.2292F, 0.8126F, 1 - 0.75F, 0.7707F);

                /** Top Face */
                tessellator.addVertexWithUV(yMax, xA, zA, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A
                tessellator.addVertexWithUV(yMax, xD, zD, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
                tessellator.addVertexWithUV(yMax, xC, zC, c.getInterpolatedU(topCu), c.getInterpolatedV(topCv)); // C
                tessellator.addVertexWithUV(yMax, xB, zB, c.getInterpolatedU(topBu), c.getInterpolatedV(topBv)); // B

                tessellator.addVertexWithUV(yMax, xF, zF, c.getInterpolatedU(topFu), c.getInterpolatedV(topFv)); // F
                tessellator.addVertexWithUV(yMax, xE, zE, c.getInterpolatedU(topEu), c.getInterpolatedV(topEv)); // E
                tessellator.addVertexWithUV(yMax, xD, zD, c.getInterpolatedU(topDu), c.getInterpolatedV(topDv)); // D
                tessellator.addVertexWithUV(yMax, xA, zA, c.getInterpolatedU(topAu), c.getInterpolatedV(topAv)); // A

                /** Side Faces */
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

            tessellator.addTranslation(-x, -y, -z);

            /* Draw the outer layer of the block. */
            //renderer.renderStandardBlock(block, x, y, z);
        }
        /* If this is the second (transparent) render pass... */
        else {
            /* If Tessellator doesn't do anything, it will crash, so let's make a dummy quad. */
            tessellator.addVertex(0, 0, 0);
            tessellator.addVertex(0, 0, 0);
            tessellator.addVertex(0, 0, 0);
            tessellator.addVertex(0, 0, 0);
        }

        return true;
    }
}
