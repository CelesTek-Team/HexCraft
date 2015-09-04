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
 * @version 0.6.1
 * @since 2015-04-14
 */

public class HexBlockModel extends Block {

    // HexCraft's ID for the block.
    public int idBlock;

    /**
     * Constructor for the block.
     * @param material Default material to use.
     */
    public HexBlockModel(Material material) {
        super(material);
        // Save the current HexCraft block ID.
        idBlock = HexCraft.idCounter;

        // Increment block counter in HexCraft class.
        HexCraft.idCounter++;
    }

    /**
     * Forces the usage of custom renderer.
     */
    @Override
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
     * Makes the block render on both passes.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean canRenderInPass(int pass) {
        // Save the current rendering pass of the block to HexClientProxy.
        HexClientProxy.renderPass[idBlock] = pass;
        return true;
    }

    /**
     * Makes the block render on both passes.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }

    /**
     * Makes the block not interact with AO.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isBlockNormalCube() {
        return false;
    }

    /**
     * Forces the block not to hide faces of other blocks.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isOpaqueCube() {
        return false;
    }

    /**
     * Forces the block not to accept torch placement on top.
     */
    @Override
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
        return false;
    }

    /**
     * Forces the block not to accept torch placement on sides.
     */
    @Override
    public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
        return false;
    }

    /**
     * Forces the block not to conduct Redstone current.
     */
    @Override
    public boolean shouldCheckWeakPower(IBlockAccess world, int x, int y, int z, int side) {
        return false;
    }

    /**
     * Return true if the block is a normal, solid cube.  This
     * determines indirect power state, entity ejection from blocks, and a few
     * others.
     *
     * @param world The current world
     * @param x X Position
     * @param y Y position
     * @param z Z position
     * @return True if the block is a full cube
     */
    @Override
    public boolean isNormalCube(IBlockAccess world, int x, int y, int z)
    {
        return false;
    }

    @Override
    public boolean isNormalCube()
    {
        return false;
    }
}
