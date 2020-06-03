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
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.ArrayList;
import java.util.List;

import static com.celestek.hexcraft.client.HexClientProxy.renderID;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class BlockEnergizedHexorium extends HexBlock implements IBlockHexID, IBlockHexColor {

    // Block ID
    public static final String ID = "blockEnergizedHexorium";

    // Color
    private final HexEnums.Colors color;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     */
    public BlockEnergizedHexorium(String blockName, HexEnums.Colors color) {
        super(Material.glass);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.color = color;
        this.setCreativeTab(HexCraft.tabDecorative);

        this.setHardness(0.3F);

        this.setStepSound(Block.soundTypeGlass);
    }

    /**
     * Return true if a player with Silk Touch can harvest this block directly, and not its normal drops.
     */
    @Override
    protected boolean canSilkHarvest() {
        return false;
    }

    /**
     * Sets up items to drop.
     */
    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        // Prepare a drop list.
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();

        // If the block wasn't destroyed using the Manipulator...
        if(fortune != HexCraft.hexFortune) {
            // Set the according crystal color combinations.
            if (this == HexBlocks.blockEnergizedHexoriumRed) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 8));
            }
            else if (this == HexBlocks.blockEnergizedHexoriumOrange) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 6));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 2));
            }
            else if (this == HexBlocks.blockEnergizedHexoriumYellow) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 4));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 4));
            }
            else if (this == HexBlocks.blockEnergizedHexoriumLime) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 2));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 6));
            }
            else if (this == HexBlocks.blockEnergizedHexoriumGreen) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 8));
            }
            else if (this == HexBlocks.blockEnergizedHexoriumTurquoise) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 6));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 2));
            }
            else if (this == HexBlocks.blockEnergizedHexoriumCyan) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 4));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 4));
            }
            else if (this == HexBlocks.blockEnergizedHexoriumSkyBlue) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 2));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 6));
            }
            else if (this == HexBlocks.blockEnergizedHexoriumBlue) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 8));
            }
            else if (this == HexBlocks.blockEnergizedHexoriumPurple) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 6));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 2));
            }
            else if (this == HexBlocks.blockEnergizedHexoriumMagenta) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 4));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 4));
            }
            else if (this == HexBlocks.blockEnergizedHexoriumPink) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 2));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 6));

            }
            else if (this == HexBlocks.blockEnergizedHexoriumWhite) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 8));
            }
            else if (this == HexBlocks.blockEnergizedHexoriumLightGray) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 6));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlack, 2));
            }
            else if (this == HexBlocks.blockEnergizedHexoriumGray) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 4));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlack, 4));
            }
            else if (this == HexBlocks.blockEnergizedHexoriumDarkGray) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 2));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlack, 6));
            }
            else if (this == HexBlocks.blockEnergizedHexoriumBlack) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlack, 8));

            }
            else if (this == HexBlocks.blockEnergizedHexoriumRainbow) {
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 2));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 2));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 2));
                drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 2));
            }
        }
        else
            // Return the block (because of Manipulator).
            drops.add(new ItemStack(this, 1));

        // Return the created drop array.
        return drops;
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
        // Load the outer texture.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + "transparent");
        // Load the inner texture. Use special texture if it is a rainbow.
        if(this.color == HexEnums.Colors.RAINBOW)
            icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glowRainbow");
        else
            icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glow");
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

    /**
     * Forces the block not to accept torch placement on top.
     */
    @Override
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
        return false;
    }

    /**
     * Forces the block not to accept torch placement on sides.
     */
    @Override
    public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
        return false;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public HexEnums.Colors getColor() {
        return color;
    }

    public static void registerBlocks() {
        for (HexEnums.Colors color : HexEnums.Colors.values()) {
            String name = ID + color.name;
            BlockEnergizedHexorium block = new BlockEnergizedHexorium(name, color);
            GameRegistry.registerBlock(block, name);
        }
    }

    public static void registerRenders() {
        for (HexEnums.Colors color : HexEnums.Colors.values()) {
            renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                    HexEnums.Brightness.BRIGHT, color));
        }
    }

    public static void registerRecipes() {
        String xrx = "dustRedstone";
        String red = "gemHexoriumRed";
        String grn = "gemHexoriumGreen";
        String blu = "gemHexoriumBlue";
        String wht = "gemHexoriumWhite";
        String blk = "gemHexoriumBlack";

        GameRegistry.addRecipe(new ShapelessOreRecipe(
                HexBlocks.getHexBlock(ID, HexEnums.Colors.RED),
                red, red, red,
                xrx, red, red,
                red, red, red));
        GameRegistry.addRecipe(new ShapelessOreRecipe(
                HexBlocks.getHexBlock(ID, HexEnums.Colors.ORANGE),
                red, red, grn,
                xrx, red, red,
                red, grn, red));
        GameRegistry.addRecipe(new ShapelessOreRecipe(
                HexBlocks.getHexBlock(ID, HexEnums.Colors.YELLOW),
                red, grn, grn,
                xrx, red, grn,
                red, grn, red));
        GameRegistry.addRecipe(new ShapelessOreRecipe(
                HexBlocks.getHexBlock(ID, HexEnums.Colors.LIME),
                grn, grn, red,
                xrx, grn, grn,
                grn, red, grn));
        GameRegistry.addRecipe(new ShapelessOreRecipe(
                HexBlocks.getHexBlock(ID, HexEnums.Colors.GREEN),
                grn, grn, grn,
                xrx, grn, grn,
                grn, grn, grn));
        GameRegistry.addRecipe(new ShapelessOreRecipe(
                HexBlocks.getHexBlock(ID, HexEnums.Colors.TURQUOISE),
                grn, grn, blu,
                xrx, grn, grn,
                grn, blu, grn));
        GameRegistry.addRecipe(new ShapelessOreRecipe(
                HexBlocks.getHexBlock(ID, HexEnums.Colors.CYAN),
                grn, blu, blu,
                xrx, grn, blu,
                grn, blu, grn));
        GameRegistry.addRecipe(new ShapelessOreRecipe(
                HexBlocks.getHexBlock(ID, HexEnums.Colors.SKY_BLUE),
                blu, blu, grn,
                xrx, blu, blu,
                blu, grn, blu));
        GameRegistry.addRecipe(new ShapelessOreRecipe(
                HexBlocks.getHexBlock(ID, HexEnums.Colors.BLUE),
                blu, blu, blu,
                xrx, blu, blu,
                blu, blu, blu));
        GameRegistry.addRecipe(new ShapelessOreRecipe(
                HexBlocks.getHexBlock(ID, HexEnums.Colors.PURPLE),
                blu, blu, red,
                xrx, blu, blu,
                blu, red, blu));
        GameRegistry.addRecipe(new ShapelessOreRecipe(
                HexBlocks.getHexBlock(ID, HexEnums.Colors.MAGENTA),
                blu, red, red,
                xrx, blu, red,
                blu, red, blu));
        GameRegistry.addRecipe(new ShapelessOreRecipe(
                HexBlocks.getHexBlock(ID, HexEnums.Colors.PINK),
                red, red, blu,
                xrx, red, red,
                red, blu, red));

        GameRegistry.addRecipe(new ShapelessOreRecipe(
                HexBlocks.getHexBlock(ID, HexEnums.Colors.WHITE),
                wht, wht, wht,
                xrx, wht, wht,
                wht, wht, wht));
        GameRegistry.addRecipe(new ShapelessOreRecipe(
                HexBlocks.getHexBlock(ID, HexEnums.Colors.LIGHT_GRAY),
                wht, wht, blk,
                xrx, wht, wht,
                wht, blk, wht));
        GameRegistry.addRecipe(new ShapelessOreRecipe(
                HexBlocks.getHexBlock(ID, HexEnums.Colors.GRAY),
                wht, blk, blk,
                xrx, wht, blk,
                wht, blk, wht));
        GameRegistry.addRecipe(new ShapelessOreRecipe(
                HexBlocks.getHexBlock(ID, HexEnums.Colors.DARK_GRAY),
                blk, blk, wht,
                xrx, blk, blk,
                blk, wht, blk));
        GameRegistry.addRecipe(new ShapelessOreRecipe(
                HexBlocks.getHexBlock(ID, HexEnums.Colors.BLACK),
                blk, blk, blk,
                xrx, blk, blk,
                blk, blk, blk));

        GameRegistry.addRecipe(new ShapelessOreRecipe(
                HexBlocks.getHexBlock(ID, HexEnums.Colors.RAINBOW),
                red, grn, wht,
                xrx, blu, grn,
                blu, wht, red));
    }
}
