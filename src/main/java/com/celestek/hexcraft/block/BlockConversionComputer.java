package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.renderer.HexBlockRenderer;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.init.HexItems;
import com.celestek.hexcraft.util.HexEnergyNode;
import com.celestek.hexcraft.util.HexEnums;
import com.celestek.hexcraft.util.HexUtils;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraftforge.oredict.ShapedOreRecipe;

import static com.celestek.hexcraft.client.HexClientProxy.renderID;

public class BlockConversionComputer extends HexBlock implements IHexBlock, IBlockHexNode {

    // Block ID
    public static final String ID = "blockConversionComputer";

    public enum Tiers {
        BASIC(   "Basic",    1),
        ADVANCED("Advanced", 2);

        public final String name;
        public final int efficiency;

        Tiers(String name, int efficiency) {
            this.name = name;
            this.efficiency = efficiency;
        }
    }

    // Tier
    private final BlockConversionComputer.Tiers tier;

    /**
     * Constructor for the block.
     *
     * @param blockName Unlocalized name for the block.
     * @param tier Tier of the core.
     */
    public BlockConversionComputer(String blockName, BlockConversionComputer.Tiers tier) {
        super(Material.iron);
        
        // Set all block parameters.
        this.setBlockName(blockName);
        this.tier = tier;
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
        icon = new IIcon[3];
        // Load the outer textures.
        for (int i = 0; i < 2; i++)
            icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + this.tier.name + "0" + (i + 1));
        // Load the inner texture.
        icon[2] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glowRainbow");
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        // Retrieve icon based on side.
        if (side < 6) {
            if (HexUtils.getBit(HexBlocks.META_STRUCTURE_IS_PART, meta))
                return icon[1];
            else
                return icon[0];
        }
        else
            return icon[2];
    }

    @Override
    public String getID() {
        return ID;
    }

    public static void registerBlocks() {
        if (HexConfig.cfgEnergyNodeEnable) {
            for (BlockConversionComputer.Tiers tier : BlockConversionComputer.Tiers.values()) {
                String name = ID + tier.name;
                Block block = new BlockConversionComputer(name, tier);
                GameRegistry.registerBlock(block, name);
            }
        }
    }

    public static void registerRenders() {
        if (HexConfig.cfgEnergyNodeEnable) {
            for (BlockConversionComputer.Tiers tier : BlockConversionComputer.Tiers.values()) {
                renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
                RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                        HexEnums.Brightness.BRIGHT, HexEnums.Colors.RAINBOW));
            }
        }
    }

    public static void registerRecipes() {
        if (HexConfig.cfgEnergyNodeEnable) {
            Block block1 = HexBlocks.getHexBlock(ID + Tiers.BASIC.name);
            Block block2 = HexBlocks.getHexBlock(ID + Tiers.ADVANCED.name);

            Block energized = HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.RAINBOW);

            GameRegistry.addRecipe(new ShapedOreRecipe(
                    block1,
                    "IPI",
                    "DED",
                    "CIC",
                    'E', energized, 'P', HexItems.itemMachineControlPanel, 'C', HexItems.itemHexoriumProcessor, 'D', "gemDiamond", 'I', "ingotIron"));
            GameRegistry.addRecipe(new ShapedOreRecipe(
                    block2,
                    "CDC",
                    "DED",
                    "CDC",
                    'E', block1, 'C', HexItems.itemHexoriumProcessor, 'D', "gemDiamond"));
        }
    }

    public int getEfficiency() {
        return this.tier.efficiency;
    }
}
