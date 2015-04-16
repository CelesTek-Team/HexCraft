package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.HexClientProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-14
 */

public class HexBlock extends Block {

    /* HexCraft's ID for the block. */
    private int idBlock;

    /**
     * Constructor for the block.
     * @param material Default material to use.
     */
    public HexBlock(Material material) {
        super(material);
        /* Save the current HexCraft block ID. */
        idBlock = HexCraft.idCounter;

        /* Increment block counter in HexCraft class. */
        HexCraft.idCounter++;
    }

    /**
     * Forces the usage of custom renderer.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean renderAsNormalBlock() {
        return false;
    }

    /**
     * Retrieves Minecraft's internal ID of the block from HexClientProxy.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderType() {
        return HexClientProxy.renderID[idBlock];
    }

    /**
     * Makes the block render on both passes and saves the current pass to the according ID in HexClientProxy.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean canRenderInPass(int pass)
    {
        HexClientProxy.renderPass[idBlock] = pass;
        // System.out.println("Pass ID: " + idBlock + " Pass: " + pass);
        return true;
    }

    /**
     * Makes the block render on both passes.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }

    /**
     * Makes the block properly interract with AO.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isBlockNormalCube()
    {
        return true;
    }

    /**
     * Forces torch placement on top.
     */
    @Override
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
        return true;
    }

    /**
     * Forces torch placement on sides.
     */
    @Override
    public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
        return true;
    }

    /**
     * Forces Redstone conduction.
     */
    @Override
    public boolean shouldCheckWeakPower(IBlockAccess world, int x, int y, int z, int side)
    {
        return true;
    }
}
