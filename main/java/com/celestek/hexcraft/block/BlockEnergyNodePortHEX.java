package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.util.HexUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.7.0
 */

public class BlockEnergyNodePortHEX extends HexBlock implements IBlockHexNode, IBlockHexEnergyPort {

    // Block ID
    public static final String ID = "blockEnergyNodePortHEX";

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block.
     */
    public BlockEnergyNodePortHEX(String blockName) {
        super(Material.iron);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.tabMachines);

        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(5F);
        this.setResistance(10F);

        this.setStepSound(Block.soundTypeMetal);
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
        icon = new IIcon[5];
        // Load the outer textures.
        for (int i = 0; i < 4; i++)
            icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "0" + (i + 1));
        // Load the inner texture
        icon[4] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glowRainbow");
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        // Retrieve icon based on meta.
        if (side < 6) {
            if (HexUtils.getBit(HexBlocks.META_STRUCTURE_IS_PART, meta)) {
                int state = HexUtils.getBitBiInt(BlockEnergyNodeCore.META_MODE_0, BlockEnergyNodeCore.META_MODE_1, meta);
                if (state < 3)
                    return icon[1 + state];
                else
                    return icon[1];
            }
            else
                return icon[0];
        }
        else
            return icon[4];
    }
}
