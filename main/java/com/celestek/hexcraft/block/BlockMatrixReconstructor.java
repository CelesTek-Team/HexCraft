package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-14
 */

public class BlockMatrixReconstructor extends HexBlock {

    // Set default block name.
    public static String UNLOCALISEDNAME = "blockMatrixReconstructor";

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block.
     */
    public BlockMatrixReconstructor(String blockName) {
        super(Material.rock);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.hexCraftTab);
        this.setHardness(1.5F);
        this.setStepSound(Block.soundTypeMetal);
        this.setHarvestLevel("pickaxe", 0);
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
        icon = new IIcon[9];
        // Load the outer textures.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + "machineBottom");
        icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + "machineBack");
        for (int i = 1; i < 7; i++)
            icon[i + 1] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME + "/" + UNLOCALISEDNAME + "0" + i);
        // Load the inner texture
        icon[8] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glow");
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int i, int meta) {
        switch (i) {
            case 0:
                return icon[0];
            case 1:
                return icon[5];
            case 2:
                return icon[7];
            case 3:
                return icon[7];
            case 4:
                return icon[1];
            case 5:
                return icon[6];
            case 6:
                return icon[8];
        }
        return icon[i];
    }
}
