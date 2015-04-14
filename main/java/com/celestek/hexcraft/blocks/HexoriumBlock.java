package com.celestek.hexcraft.blocks;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.RenderClientProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class HexoriumBlock extends Block {

    public static String UNLOCALISEDNAME = "hexoriumBlock";

    private String hexoriumColorName;

    public HexoriumBlock(String hexoriumColorName) {
        super(Material.glass);
        this.hexoriumColorName = hexoriumColorName;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        if (hexoriumColorName.equals(UNLOCALISEDNAME)) {
            return RenderClientProxy.hexoriumBlock;
        }
        else if (hexoriumColorName.equals(UNLOCALISEDNAME + "Green")) {
            return RenderClientProxy.hexoriumBlockGreen;
        }
        else {
            return RenderClientProxy.hexoriumBlock;
        }
    }

    @SideOnly(Side.CLIENT)
    private IIcon icon;

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        icon = iconRegister.registerIcon(HexCraft.MODID+":"+UNLOCALISEDNAME);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2) {
        return icon;
    }

    @Override
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
        return true;
    }

    @Override
    public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public boolean isBlockNormalCube()
    {
        return true;
    }
}
