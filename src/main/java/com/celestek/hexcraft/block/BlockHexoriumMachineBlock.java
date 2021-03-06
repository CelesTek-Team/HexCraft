package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.renderer.HexBlockRenderer;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexItems;
import com.celestek.hexcraft.util.HexEnums;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraftforge.oredict.ShapedOreRecipe;

import static com.celestek.hexcraft.client.HexClientProxy.renderID;

public class BlockHexoriumMachineBlock extends HexBlock implements IHexBlock {

    // Block ID
    public static final String ID = "blockHexoriumMachineBlock";

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block.
     */
    public BlockHexoriumMachineBlock(String blockName) {
        super(Material.iron);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.tabComponents);

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
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + "machineBottom");
        icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + "machineSide");
        // Load the inner texture
        icon[2] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glow");
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        // Retrieve icon based on side.
        if (side == 0)
            return icon[0];
        else if (side > 0 && side < 6)
            return icon[1];
        else
            return icon[2];
    }

    @Override
    public String getID() {
        return ID;
    }

    public static void registerBlocks() {
        GameRegistry.registerBlock(new BlockHexoriumMachineBlock(ID), ID);
    }

    public static void registerRenders() {
        renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                HexEnums.Brightness.BRIGHT, HexEnums.Colors.WHITE));
    }

    public static void registerRecipes() {
        Block block = HexBlocks.getHexBlock(ID);

        Block energized = HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.WHITE);
        Item projector = HexItems.itemSpatialProjector;

        GameRegistry.addRecipe(new ShapedOreRecipe(
                block,
                "I I",
                "RHR",
                "IPI",
                'H', energized, 'P', projector, 'R', "dustRedstone", 'I', "ingotIron"));
    }
}
