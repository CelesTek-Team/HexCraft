package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.util.CableAnalyzer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-14
 */

public class CableHexoriumCable extends HexBlockModel {

    // Set default block name.
    public static String UNLOCALISEDNAME = "cableHexoriumCable";

    // Used later for texture identification.
    private String blockName;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     */
    public CableHexoriumCable(String blockName) {
        super(Material.glass);

        // Load the constructor parameters.
        this.blockName = blockName;

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.hexCraftTab);
        this.setHardness(3F);
        this.setStepSound(Block.soundTypeGlass);
    }

    /**
     * Called when a block is placed using its ItemBlock.
     */
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
        if(!world.isRemote) {
            System.out.println("Cable placed, analyzing!");
            /* DO ANALYSIS */
            CableAnalyzer analyzer = new CableAnalyzer();
            analyzer.analyze(world, x, y, z, "tile." + blockName, 0);
            analyzer.push();
        }
    }

    /**
     * Called when a block near is changed.
     */
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        String blockName = block.getUnlocalizedName();
        if (blockName.contains(UNLOCALISEDNAME) ||
            blockName.contains(MachineMatrixReconstructor.UNLOCALISEDNAME)) {
            System.out.println("Neighbour cable or machine destroyed, analyzing!");
            /* DO ANALYSIS */
            CableAnalyzer analyzer = new CableAnalyzer();
            analyzer.analyze(world, x, y, z, "tile." + blockName, 0);
            analyzer.push();
        }
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
        icon = new IIcon[7];
        // Load the outer textures.
        for(int i = 0; i < 6; i++)
            icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + "transparent");
        // Load the monolith texture. Use special texture if it is a rainbow.
        if(blockName.equals(UNLOCALISEDNAME + "Rainbow"))
            icon[6] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME + "Rainbow");
        else
            icon[6] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME);
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int i, int meta) {
        // Retrieve icon based on side.
        return icon[i];
    }
}
