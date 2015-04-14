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

public class EnergizedHexoriumBlock extends HexCraftBlock {

    public static String UNLOCALISEDNAME = "energizedHexoriumBlock";

    private String hexoriumColorName;

    public EnergizedHexoriumBlock(String hexoriumColorName) {
        super(Material.glass);
        this.hexoriumColorName = hexoriumColorName;
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
}
