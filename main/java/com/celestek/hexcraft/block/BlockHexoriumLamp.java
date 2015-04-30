package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-14
 */

public class BlockHexoriumLamp extends HexBlock {

    // Set default block name.
    public static String UNLOCALISEDNAME = "blockHexoriumLamp";
    public static String UNLOCALISEDNAMEINV = "blockInvHexoriumLamp";

    // Used later for texture identification.
    private String blockName;

    // Used for checking if the lamp should be inverted.
    private boolean isInverted;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     */
    public BlockHexoriumLamp(String blockName, boolean isInverted) {
        super(Material.glass);

        // Load the constructor parameters.
        this.blockName = blockName;
        this.isInverted = isInverted;

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.hexCraftTab);
        this.setHardness(1.5F);
        this.setStepSound(Block.soundTypeGlass);
        this.setHarvestLevel("pickaxe", 0);
    }

    /**
     * Called whenever the block is added into the world.
     */
    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        processMeta(world, x, y, z);
    }

    /**
     * Called when a block near is changed.
     */
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        processMeta(world, x, y, z);
    }

    /**
     * Processes the block meta to adjust light of the lamp.
     */
    private void processMeta(World world, int x, int y, int z) {
        // If this is the server thread.
        if (!world.isRemote) {
            // Compare if the block is inverted and if it is getting power.
            if (!isInverted && world.isBlockIndirectlyGettingPowered(x, y, z))
                world.setBlockMetadataWithNotify(x, y, z, 1, 2);
            else if (!isInverted && !world.isBlockIndirectlyGettingPowered(x, y, z))
                world.setBlockMetadataWithNotify(x, y, z, 0, 2);
            else if (isInverted && !world.isBlockIndirectlyGettingPowered(x, y, z))
                world.setBlockMetadataWithNotify(x, y, z, 1, 2);
            else if (isInverted && world.isBlockIndirectlyGettingPowered(x, y, z))
                world.setBlockMetadataWithNotify(x, y, z, 0, 2);
        }
    }

    /**
     * Get the light value according to meta.
     */
    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        Block block = world.getBlock(x, y, z);
        int meta = world.getBlockMetadata(x, y, z);
        if (block == this && meta == 1)
            return 15;
        else
            return 0;
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
            icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME);
        // Load the inner texture. Use special texture if it is a rainbow.
        if(blockName.contains("Rainbow"))
            icon[6] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glowRainbow");
        else
            icon[6] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glow");
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
