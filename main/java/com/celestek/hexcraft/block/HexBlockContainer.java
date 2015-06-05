package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.HexClientProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.5.0
 * @since 2015-04-14
 */

public class HexBlockContainer extends BlockContainer {

    // HexCraft's ID for the block.
    public int idBlock;

    /**
     * Constructor for the block.
     * @param material Default material to use.
     */
    public HexBlockContainer(Material material) {
        super(material);
        // Save the current HexCraft block ID.
        idBlock = HexCraft.idCounter;

        // Increment block counter in HexCraft class.
        HexCraft.idCounter++;
    }

    public TileEntity createNewTileEntity(World world, int par2) {
        return new TileEntity();
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
     * Makes the block properly interact with AO.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isBlockNormalCube() {
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
    public boolean shouldCheckWeakPower(IBlockAccess world, int x, int y, int z, int side) {
        return true;
    }
}
