package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.renderer.HexBlockRenderer;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.init.HexItems;
import com.celestek.hexcraft.util.HexEnums;
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

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class BlockEnergyNodeCore extends HexBlock implements IHexBlock, IBlockHexNode {

    // Block ID
    public static final String ID = "blockEnergyNodeCore";

    public enum Tiers {
        T1("T1", "itemHexoriumProcessor", BlockAdvancedRainbowCore.ID),
        T2("T2", "ingotIron",             ID + "T1"),
        T3("T3", "ingotGold",             ID + "T2"),
        T4("T4", "gemDiamond",            ID + "T3");

        public final String name, material, core;

        Tiers(String name, String material, String core) {
            this.name = name;
            this.material = material;
            this.core = core;
        }
    }

    // Tier
    private final BlockEnergyNodeCore.Tiers tier;

    /**
     * Constructor for the block.
     *
     * @param blockName Unlocalized name for the block.
     * @param tier Tier of the core.
     */
    public BlockEnergyNodeCore(String blockName, BlockEnergyNodeCore.Tiers tier) {
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
        icon = new IIcon[2];
        // Load the outer textures.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + tier.name);
        // Load the inner texture.
        icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glowRainbow");
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
            return icon[1];
    }

    @Override
    public String getID() {
        return ID;
    }

    public static void registerBlocks() {
        if (HexConfig.cfgEnergyNodeEnable) {
            for (BlockEnergyNodeCore.Tiers tier : BlockEnergyNodeCore.Tiers.values()) {
                String name = ID + tier.name;
                Block block = new BlockEnergyNodeCore(name, tier);
                GameRegistry.registerBlock(block, name);
            }
        }
    }

    public static void registerRenders() {
        if (HexConfig.cfgEnergyNodeEnable) {
            for (BlockEnergyNodeCore.Tiers tier : BlockEnergyNodeCore.Tiers.values()) {
                renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
                RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                        HexEnums.Brightness.BRIGHT, HexEnums.Colors.RAINBOW));
            }
        }
    }

    public static void registerRecipes() {
        if (HexConfig.cfgEnergyNodeEnable) {
            for (BlockEnergyNodeCore.Tiers tier : BlockEnergyNodeCore.Tiers.values()) {
                Block block = HexBlocks.getHexBlock(ID + tier.name);

                Block core = HexBlocks.getHexBlock(tier.core);

                if (tier == BlockEnergyNodeCore.Tiers.T1) {
                    Item material = HexItems.getHexItem(tier.material);
                    GameRegistry.addRecipe(new ShapedOreRecipe(
                            block,
                            "RMR",
                            "MCM",
                            "RMR",
                            'C', core, 'M', material, 'R', Blocks.redstone_block));
                }
                else {
                    String material = tier.material;
                    GameRegistry.addRecipe(new ShapedOreRecipe(
                            block,
                            "RMR",
                            "MCM",
                            "RMR",
                            'C', core, 'M', material, 'R', Blocks.redstone_block));
                }
            }
        }
    }
}
