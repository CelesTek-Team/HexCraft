package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.tileentity.TileEnergyNodePortEU;
import com.celestek.hexcraft.util.HexEnergyNode;
import com.celestek.hexcraft.util.HexUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.8.0
 */

public class BlockEnergyNodePortEU extends HexBlockContainer implements IBlockHexNode, IBlockHexEnergyPort {

    // Block ID
    public static final String ID = "blockEnergyNodePortEU";

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block.
     */
    public BlockEnergyNodePortEU(String blockName) {
        super(Material.iron);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.tabMachines);

        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(5F);
        this.setResistance(10F);

        this.setStepSound(Block.soundTypeMetal);
    }

    /**
     * Returns a new instance of a block's TIle Entity class. Called on placing the block.
     */
    @Override
    public TileEntity createNewTileEntity(World world, int par2) {
        return new TileEnergyNodePortEU();
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
        icon = new IIcon[4];
        // Load the outer textures.
        for (int i = 0; i < 3; i++)
            icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "0" + (i + 1));
        // Load the inner texture
        icon[3] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glowRainbow");
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
                int state = HexUtils.getBitBiInt(HexEnergyNode.META_MODE_0, HexEnergyNode.META_MODE_1, meta);
                if (state < 2)
                    return icon[1 + state];
                else
                    return icon[1];
            }
            else
                return icon[0];
        }
        else
            return icon[3];
    }
}
