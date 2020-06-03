package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.renderer.HexBlockRenderer;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.util.HexEnums;
import com.celestek.hexcraft.util.HexUtils;
import com.celestek.hexcraft.util.TankAnalyzer;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import static com.celestek.hexcraft.client.HexClientProxy.renderID;
import static com.celestek.hexcraft.init.HexBlocks.DECORATIVE_VARIANT_BLACK;
import static com.celestek.hexcraft.init.HexBlocks.DECORATIVE_VARIANT_WHITE;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class BlockHexoriumCoatedStone extends Block implements IBlockHexID, IBlockHexVariant, IBlockMultiBlock {

    // Set default block name.
    public static final String ID = "blockHexoriumCoatedStone";

    // Variant
    private final HexEnums.Variants variant;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block.
     * @param variant The decoration variant to use.
     */
    public BlockHexoriumCoatedStone(String blockName, HexEnums.Variants variant) {
        super(Material.rock);

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

        this.setStepSound(Block.soundTypePiston);
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
        // Initialize the icon.
        icon = new IIcon[2];
        // Load the icon.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + this.variant.name);
        // Load the reinforced texture.
        icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "Reinforced");
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

        return icon[rei];
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if ((block instanceof HexBlockMT
                || block == HexBlocks.blockTemperedHexoriumGlass
                || block == HexBlocks.blockHexoriumCoatedStone
                || block == HexBlocks.blockTankValve)
                && HexUtils.getMetaBit(HexBlocks.META_STRUCTURE_IS_PART, world, x, y, z)) {

            if (HexConfig.cfgTankDebug)
                System.out.println("[Tempered Hexorium Glass] (" + x + ", " + y + ", " + z + "): Neighbour tank block destroyed, analyzing!");

            /* DO ANALYSIS */
            TankAnalyzer analyzer = new TankAnalyzer();
            analyzer.analyzeTank(world, x, y, z);
        }
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public HexEnums.Variants getVariant() {
        return this.variant;
    }

    public static void registerBlocks() {
        for (HexEnums.Variants variant : HexEnums.Variants.values()) {
            String name = ID + variant.name;
            BlockHexoriumCoatedStone block = new BlockHexoriumCoatedStone(name, variant);
            GameRegistry.registerBlock(block, name);
        }
    }
}
