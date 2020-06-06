package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.renderer.HexBlockRenderer;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.util.HexEnums;
import com.celestek.hexcraft.util.ObserverAnalyzer;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.oredict.ShapedOreRecipe;

import static com.celestek.hexcraft.client.HexClientProxy.renderID;

public class BlockQuantumAnchor extends HexBlock implements IHexBlock {

    // Block ID
    public static final String ID = "blockQuantumAnchor";

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     */
    public BlockQuantumAnchor(String blockName) {
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
     * Called when a block is placed using its ItemBlock.
     */
    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
        // Check if the code is executed on the server.
        if(!world.isRemote) {
            if (HexConfig.cfgObserverDebug)
                System.out.println("[Quantum Anchor] (" + x + ", " + y + ", " + z + "): Anchor analysis started!");

            ObserverAnalyzer observerAnalyzer = new ObserverAnalyzer();
            observerAnalyzer.analyzeObserver(world, x, y, z);
        }

        return 0;
    }

    /**
     * Called when a block near is changed.
     */
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        System.out.println("[Quantum Anchor] (" + x + ", " + y + ", " + z + "): Neighbour block changed, analyzing!");

        ObserverAnalyzer observerAnalyzer = new ObserverAnalyzer();
        observerAnalyzer.analyzeObserver(world, x, y, z);
    }

    /// Prepare the icons.
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
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "01");
        icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "02");
        // Load the inner texture
        icon[2] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glow");
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        // Return the icons based on meta (rotation) and side.
        if (side == 0 || side == 1)
            return icon[0];
        else if (side == 6)
            return icon[2];
        else
            return icon[1];
    }

    @Override
    public String getID() {
        return ID;
    }

    public static void registerBlocks() {
        if (HexConfig.cfgObserverEnable) {
            GameRegistry.registerBlock(new BlockQuantumAnchor(ID), ID);
        }
    }

    public static void registerRenders() {
        if (HexConfig.cfgObserverEnable) {
            renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                    HexEnums.Brightness.BRIGHT, HexEnums.Colors.BLACK));
        }
    }

    public static void registerRecipes() {
        if (HexConfig.cfgObserverEnable) {
            Block block = HexBlocks.getHexBlock(ID);

            Block energized = HexBlocks.getHexBlock(BlockEngineeredHexoriumBlock.ID, HexEnums.Colors.BLACK);

            GameRegistry.addRecipe(new ShapedOreRecipe(
                    block,
                    "B B",
                    "BHB",
                    "B B",
                    'H', energized, 'B', Blocks.iron_bars));
        }
    }
}
