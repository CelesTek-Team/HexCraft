package com.celestek.hexcraft.blocks;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.RenderClientProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class EngineeringBlock extends HexCraftBlock {

    public static String UNLOCALISEDNAME = "engineeringBlock";

    private String hexoriumColorName;

    public EngineeringBlock(String hexoriumColorName) {
        super(Material.rock);
        this.hexoriumColorName = hexoriumColorName;
    }

    @Override
    public int getRenderType() {
        if (hexoriumColorName.equals(UNLOCALISEDNAME)) {
            return RenderClientProxy.engineeringBlock;
        }
        else if (hexoriumColorName.equals(UNLOCALISEDNAME + "Purple")) {
            return RenderClientProxy.engineeringBlockPurple;
        }
        else {
            return RenderClientProxy.engineeringBlock;
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
