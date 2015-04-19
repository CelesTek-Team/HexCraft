package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;

import static net.minecraftforge.common.util.ForgeDirection.*;
import static net.minecraftforge.common.util.ForgeDirection.DOWN;
import static net.minecraftforge.common.util.ForgeDirection.WEST;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-14
 */

public class BlockOfHexoriumCrystal extends HexBlock {

    /* Set default block name. */
    public static String UNLOCALISEDNAME = "blockOfHexoriumCrystal";

    /* Used later for texture identification. */
    private String blockName;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     */
    public BlockOfHexoriumCrystal(String blockName) {
        super(Material.glass);

        this.blockName = blockName;
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.hexCraftTab);
        this.setHardness(5.0F);
        this.setHarvestLevel("pickaxe", 2);
        this.setStepSound(Block.soundTypeGlass);
    }

    /**
     * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
     */
    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta)
    {
        return side;
    }

    /* Prepare the icons. */
    @SideOnly(Side.CLIENT)
    private IIcon icon[];

    /**
     * Registers the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        icon = new IIcon[12];
        for(int i = 0; i < 6; i++)
            icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + "transparent");
        icon[6] = iconRegister.registerIcon(HexCraft.MODID + ":" + blockName + "D");
        icon[7] = iconRegister.registerIcon(HexCraft.MODID + ":" + blockName + "A");
        icon[8] = iconRegister.registerIcon(HexCraft.MODID + ":" + blockName + "B");
        icon[9] = iconRegister.registerIcon(HexCraft.MODID + ":" + blockName + "B");
        icon[10] = iconRegister.registerIcon(HexCraft.MODID + ":" + blockName + "C");
        icon[11] = iconRegister.registerIcon(HexCraft.MODID + ":" + blockName + "C");
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2) {
        return icon[par1];
    }
}
