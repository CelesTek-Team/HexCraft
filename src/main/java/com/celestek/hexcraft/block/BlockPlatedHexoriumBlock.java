package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.util.HexUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import static com.celestek.hexcraft.init.HexBlocks.DECORATIVE_VARIANT_BLACK;
import static com.celestek.hexcraft.init.HexBlocks.DECORATIVE_VARIANT_WHITE;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class BlockPlatedHexoriumBlock extends HexBlockMT implements IBlockHexDyable {

    // Block ID
    public static final String ID_BLACK = "blockPlatedHexoriumBlock";
    public static final String ID_WHITE = "blockPlatedHexoriumBlockWhite";

    // Used for identifying the decoration variant.
    private int variant;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     * @param variant The decoration variant to use.
     */
    public BlockPlatedHexoriumBlock(String blockName, int variant) {
        super(Material.iron);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.variant = variant;
        this.setCreativeTab(HexCraft.tabDecorative);

        // Assign harvest levels to all metas.
        for (int i = 0; i < 16; i++)
            if (HexUtils.getBit(HexBlocks.META_DECORATIVE_REINFORCED, i))
                this.setHarvestLevel("pickaxe", 3, i);
            else
                this.setHarvestLevel("pickaxe", 2, i);

        this.setStepSound(Block.soundTypeMetal);
    }

    /**
     * Returns the block hardness at a location. Args: world, x, y, z
     */
    @Override
    public float getBlockHardness(World world, int x, int y, int z) {
        // If this is a normal block, return normal hardness. Otherwise, return obsidian hardness.
        if (!HexUtils.getMetaBit(HexBlocks.META_DECORATIVE_REINFORCED, world, x, y, z))
            return 1.5F;
        else
            return 50F;
    }

    /**
     * Location sensitive version of getExplosionRestance
     */
    @Override
    public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ) {
        // If this is a normal block, return normal resistance. Otherwise, return obsidian resistance.
        if (!HexUtils.getMetaBit(HexBlocks.META_DECORATIVE_REINFORCED, world, x, y, z))
            return 30F / 5F;
        else
            return 6000F / 5F;
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
        icon = new IIcon[3];
        // Map decoration and variant.
        String id = ID_BLACK;
        if (this.variant == DECORATIVE_VARIANT_WHITE)
            id = ID_WHITE;
        // Load the outer normal texture.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + id);
        // Load the outer reinforced texture.
        icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID_BLACK + "Reinforced");
        // Load the inner texture. Use special texture if it is a rainbow.
        if(this == HexBlocks.blockPlatedHexoriumBlockRainbow || this == HexBlocks.blockPlatedHexoriumBlockWhiteRainbow)
            icon[2] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glowRainbow");
        else
            icon[2] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glow");
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        int rei = 0;
        if (HexUtils.getBit(HexBlocks.META_DECORATIVE_REINFORCED, meta))
            rei = 1;

        // Retrieve icon based on side.
        if (side < 6)
            return icon[rei];
        else if (side == 6)
            return icon[2];
        else
            return icon[0];
    }

    @Override
    public int getVariant() {
        return this.variant;
    }

    @Override
    public String getVariantName() {
        switch (this.variant) {
            case DECORATIVE_VARIANT_BLACK: return ID_BLACK;
            case DECORATIVE_VARIANT_WHITE: return ID_WHITE;
            default: return null;
        }
    }

    @Override
    public String getVariantName(int variant) {
        switch (variant) {
            case DECORATIVE_VARIANT_BLACK: return ID_BLACK;
            case DECORATIVE_VARIANT_WHITE: return ID_WHITE;
            default: return null;
        }
    }
}
