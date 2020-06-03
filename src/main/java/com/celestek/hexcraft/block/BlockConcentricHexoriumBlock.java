package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.renderer.HexBlockRenderer;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexItems;
import com.celestek.hexcraft.item.ItemHexoriumDye;
import com.celestek.hexcraft.util.HexEnums;
import com.celestek.hexcraft.util.HexUtils;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import static com.celestek.hexcraft.client.HexClientProxy.renderID;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class BlockConcentricHexoriumBlock extends HexBlockMT implements IBlockHexID, IBlockHexColor, IBlockHexVariant, IBlockUsableTransposer, IBlockMultiBlock {

    // Block ID
    public static final String ID = "blockConcentricHexoriumBlock";

    // Color and variant
    private final HexEnums.Colors color;
    private final HexEnums.Variants variant;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     * @param color The color of the block to use.
     * @param variant The variant to use.
     */
    public BlockConcentricHexoriumBlock(String blockName, HexEnums.Colors color, HexEnums.Variants variant) {
        super(Material.iron);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.color = color;
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
        // Load the outer normal texture.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + this.variant.name);
        // Load the outer reinforced texture.
        icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "Reinforced");
        // Load the inner texture. Use special texture if it is a rainbow.
        if(this.color == HexEnums.Colors.RAINBOW)
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
    public String getID() {
        return ID;
    }

    @Override
    public HexEnums.Variants getVariant() {
        return this.variant;
    }

    @Override
    public HexEnums.Colors getColor() {
        return color;
    }

    public static void registerBlocks() {
        for (HexEnums.Variants variant : HexEnums.Variants.values()) {
            for (HexEnums.Colors color : HexEnums.Colors.values()) {
                String name = ID + variant.name + color.name;
                BlockConcentricHexoriumBlock block = new BlockConcentricHexoriumBlock(name, color, variant);
                GameRegistry.registerBlock(block, name);
            }
        }
    }

    public static void registerRenders() {
        for (HexEnums.Variants variant : HexEnums.Variants.values()) {
            for (HexEnums.Colors color : HexEnums.Colors.values()) {
                renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
                RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                        HexEnums.Brightness.BRIGHT, color));
            }
        }
    }

    public static void registerRecipes() {
        for (HexEnums.Variants variant : HexEnums.Variants.values()) {
            for (HexEnums.Colors color : HexEnums.Colors.values()) {
                Block block = HexBlocks.getHexBlock(ID, variant, color);

                Block energized = HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, color);
                Block stone = HexBlocks.getHexBlock(BlockHexoriumCoatedStone.ID, variant);
                Item dye = HexItems.getHexItem(ItemHexoriumDye.ID, variant);

                GameRegistry.addRecipe(new ShapedOreRecipe(block,
                        "S  ",
                        " H ",
                        "  I",
                        'H', energized, 'I', "nuggetIron", 'S', stone));

                for (HexEnums.Variants variant2 : HexEnums.Variants.values()) {
                    if (variant != variant2) {
                        Block blockOther = HexBlocks.getHexBlock(ID, variant2, color);
                        GameRegistry.addRecipe(new ShapelessOreRecipe(
                                block,
                                blockOther, dye));
                    }
                }
            }
        }
    }
}
