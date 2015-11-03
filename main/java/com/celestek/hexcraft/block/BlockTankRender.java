package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.HexClientProxy;
import com.celestek.hexcraft.tileentity.TileTankRender;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.Sys;


public class BlockTankRender extends HexBlockContainer {
    public static String UNLOCALISEDNAME = "blockTankRender";

    /**
     * Constructor for the block.
     *
     * @param blockName Un
     */
    public BlockTankRender(String blockName) {
        super(Material.iron);

        // Set all block parameters.
        this.setBlockName(blockName);

        this.setBlockUnbreakable();
        this.setResistance(6000000.0F);

        this.setStepSound(Block.soundTypeMetal);
        this.setLightOpacity(0);

        this.setBlockBounds(0.25F, 0.25F, 0.25F, 0.75F, 0.75F, 0.75F);
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TileTankRender();
    }

    // Prepare the icons.
    @SideOnly(Side.CLIENT)
    private IIcon icon[];

    /**
     * Registers the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        // Initialize the icons.
        icon = new IIcon[1];
        // Load the pylon base texture.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME);
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return icon[0];
    }

    /**
     * Makes the block noz interact with AO.
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

    /**
     * Makes the block render on both passes.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean canRenderInPass(int pass) {
        if (pass == 1) {
            // Save the current rendering pass of the block to HexClientProxy.
            HexClientProxy.renderPass[idBlock] = pass;
            return true;
        }
        return false;
    }

    /**
     * Makes the block render on both passes.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }
}
