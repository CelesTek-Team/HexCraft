package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.renderer.HexBlockRenderer;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.init.HexItems;
import com.celestek.hexcraft.item.ItemHexoriumDye;
import com.celestek.hexcraft.util.EnergyNodeAnalyzer;
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
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import static com.celestek.hexcraft.client.HexClientProxy.renderID;

public class BlockHexoriumStructureCasing extends HexBlockMT implements IHexBlock, IBlockHexNode, IBlockHexColor, IBlockHexVariant, IBlockUsableTransposer, IBlockMultiBlock {

    // Block ID
    public static final String ID = "blockHexoriumStructureCasing";

    // Prepare an array of all possible situations.
    private static final int[] textureRefByID = {
             0,  0,  6,  6,  0,  0,  6,  6,  3,  3, 19, 15,  3,  3, 19, 15,
             1,  1, 18, 18,  1,  1, 13, 13,  2,  2, 23, 31,  2,  2, 27, 14,
             0,  0,  6,  6,  0,  0,  6,  6,  3,  3, 19, 15,  3,  3, 19, 15,
             1,  1, 18, 18,  1,  1, 13, 13,  2,  2, 23, 31,  2,  2, 27, 14,
             4,  4,  5,  5,  4,  4,  5,  5, 17, 17, 22, 26, 17, 17, 22, 26,
            16, 16, 20, 20, 16, 16, 28, 28, 21, 21, 46, 42, 21, 21, 43, 38,
             4,  4,  5,  5,  4,  4,  5,  5,  9,  9, 30, 12,  9,  9, 30, 12,
            16, 16, 20, 20, 16, 16, 28, 28, 25, 25, 45, 37, 25, 25, 40, 32,
             0,  0,  6,  6,  0,  0,  6,  6,  3,  3, 19, 15,  3,  3, 19, 15,
             1,  1, 18, 18,  1,  1, 13, 13,  2,  2, 23, 31,  2,  2, 27, 14,
             0,  0,  6,  6,  0,  0,  6,  6,  3,  3, 19, 15,  3,  3, 19, 15,
             1,  1, 18, 18,  1,  1, 13, 13,  2,  2, 23, 31,  2,  2, 27, 14,
             4,  4,  5,  5,  4,  4,  5,  5, 17, 17, 22, 26, 17, 17, 22, 26,
             7,  7, 24, 24,  7,  7, 10, 10, 29, 29, 44, 41, 29, 29, 39, 33,
             4,  4,  5,  5,  4,  4,  5,  5,  9,  9, 30, 12,  9,  9, 30, 12,
             7,  7, 24, 24,  7,  7, 10, 10,  8,  8, 36, 35,  8,  8, 34, 11
    };

    // Color and variant
    private final HexEnums.Colors color;
    private final HexEnums.Variants variant;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     * @param color The color of the block to use.
     * @param variant The variant to use.
     */
    public BlockHexoriumStructureCasing(String blockName, HexEnums.Colors color, HexEnums.Variants variant) {
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

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if ((block instanceof BlockHexoriumStructureCasing || block instanceof BlockEnergyNodeCore || block instanceof BlockConversionComputer || block instanceof IBlockHexEnergyPort)
                && HexUtils.getMetaBit(HexBlocks.META_STRUCTURE_IS_PART, world, x, y, z)) {

            if (HexConfig.cfgEnergyNodeDebug)
                System.out.println("[Energy Node Block] (" + x + ", " + y + ", " + z + "): Neighbour Energy Node block destroyed, analyzing!");

            /* DO ANALYSIS */
            EnergyNodeAnalyzer analyzer = new EnergyNodeAnalyzer();
            analyzer.analyzeEnergyNode(world, x, y, z);
        }

        super.onNeighborBlockChange(world, x, y, z, block);
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
        icon = new IIcon[97];

        // Load all the different outer icons.
        for(int i = 0; i < 48; i++) {
            if(i < 9)
                icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + this.variant.name + "0" + (i + 1));
            else
                icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + this.variant.name + (i + 1));
        }
        for(int i = 0; i < 48; i++) {
            if(i < 9)
                icon[i + 48] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "Reinforced" + "0" + (i + 1));
            else
                icon[i + 48] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "Reinforced" + (i + 1));
        }

        // Load the inner texture. Use special texture if it is a rainbow.
        if(this.color == HexEnums.Colors.RAINBOW)
            icon[96] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glowRainbow");
        else
            icon[96] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glow");
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        // Retrieve icon based on side.
        if (side < 6)
            return icon[0];
        else
            return icon[96];
    }


    /**
     * Retrieves the icons and sets the connected texture.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {

        if (side < 6) {
            // Prepare a new 8-bit array.
            boolean[] bitMatrix = new boolean[8];

            // Analyze neighbouring blocks and set bits.
            if (side == 0 || side == 1) {
                bitMatrix[0] = world.getBlock(x - 1, y, z - 1) == this;
                bitMatrix[1] = world.getBlock(x, y, z - 1) == this;
                bitMatrix[2] = world.getBlock(x + 1, y, z - 1) == this;
                bitMatrix[3] = world.getBlock(x - 1, y, z) == this;
                bitMatrix[4] = world.getBlock(x + 1, y, z) == this;
                bitMatrix[5] = world.getBlock(x - 1, y, z + 1) == this;
                bitMatrix[6] = world.getBlock(x, y, z + 1) == this;
                bitMatrix[7] = world.getBlock(x + 1, y, z + 1) == this;
            }
            else if (side == 2 || side == 3) {
                bitMatrix[0] = world.getBlock(x + (side == 2 ? 1 : -1), y + 1, z) == this;
                bitMatrix[1] = world.getBlock(x, y + 1, z) == this;
                bitMatrix[2] = world.getBlock(x + (side == 3 ? 1 : -1), y + 1, z) == this;
                bitMatrix[3] = world.getBlock(x + (side == 2 ? 1 : -1), y, z) == this;
                bitMatrix[4] = world.getBlock(x + (side == 3 ? 1 : -1), y, z) == this;
                bitMatrix[5] = world.getBlock(x + (side == 2 ? 1 : -1), y - 1, z) == this;
                bitMatrix[6] = world.getBlock(x, y - 1, z) == this;
                bitMatrix[7] = world.getBlock(x + (side == 3 ? 1 : -1), y - 1, z) == this;
            }
            else if (side == 4 || side == 5) {
                bitMatrix[0] = world.getBlock(x, y + 1, z + (side == 5 ? 1 : -1)) == this;
                bitMatrix[1] = world.getBlock(x, y + 1, z) == this;
                bitMatrix[2] = world.getBlock(x, y + 1, z + (side == 4 ? 1 : -1)) == this;
                bitMatrix[3] = world.getBlock(x, y, z + (side == 5 ? 1 : -1)) == this;
                bitMatrix[4] = world.getBlock(x, y, z + (side == 4 ? 1 : -1)) == this;
                bitMatrix[5] = world.getBlock(x, y - 1, z + (side == 5 ? 1 : -1)) == this;
                bitMatrix[6] = world.getBlock(x, y - 1, z) == this;
                bitMatrix[7] = world.getBlock(x, y - 1, z + (side == 4 ? 1 : -1)) == this;
            }

            // Convert the bit array to a dec number.
            int idBuilder = 0;
            for (int i = 0; i < 8; i++)
                idBuilder = idBuilder + (bitMatrix[i] ? (i == 0 ? 1 : (i == 1 ? 2 : (i == 2 ? 4 : (i == 3 ? 8 : (i == 4 ? 16 : (i == 5 ? 32 : (i == 6 ? 64 : 128))))))) : 0);

            // Return the according texture.
            if (!HexUtils.getMetaBit(HexBlocks.META_DECORATIVE_REINFORCED, world, x, y, z))
                return icon[textureRefByID[idBuilder]];
            else
                return icon[textureRefByID[idBuilder] + 48];
        }
        else
            return icon[96];

    }

    @Override
    public String getID() {
        return ID;
    }

    public static void registerBlocks() {
        for (HexEnums.Variants variant : HexEnums.Variants.values()) {
            for (HexEnums.Colors color : HexEnums.Colors.values()) {
                String name = ID + variant.name + color.name;
                Block block = new BlockHexoriumStructureCasing(name, color, variant);
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

                GameRegistry.addRecipe(new ShapedOreRecipe(
                        block,
                        " I ",
                        "RHR",
                        " S ",
                        'H', energized, 'I', "nuggetIron", 'S', stone, 'R', "dustRedstone"));

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

    @Override
    public HexEnums.Variants getVariant() {
        return this.variant;
    }

    @Override
    public HexEnums.Colors getColor() {
        return color;
    }
}
