package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.renderer.HexBlockRenderer;
import com.celestek.hexcraft.client.renderer.HexMiniBlockRenderer;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexItems;
import com.celestek.hexcraft.util.HexEnums;
import com.celestek.hexcraft.util.HexUtils;
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
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.ArrayList;

import static com.celestek.hexcraft.client.HexClientProxy.renderID;
import static net.minecraftforge.common.util.ForgeDirection.*;
import static net.minecraftforge.common.util.ForgeDirection.EAST;

public class BlockMiniEnergizedHexorium extends HexBlock implements IHexBlock, IBlockHexColor {

    // Block ID
    public static final String ID = "blockMiniEnergizedHexorium";

    // Meta Bits
    public static final int META_ORIENTATION_0 = 0;
    public static final int META_ORIENTATION_1 = 1;
    public static final int META_ORIENTATION_2 = 2;

    // Color
    private final HexEnums.Colors color;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     */
    public BlockMiniEnergizedHexorium(String blockName, HexEnums.Colors color) {
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
     * Called when a player tries to place the monolith.
     */
    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        // Check if any of the sides around the block are solid, if yes, it means it can be placed.
        return (world.isSideSolid(x, y - 1, z, UP)) ||
                (world.isSideSolid(x, y + 1, z, DOWN)) ||
                (world.isSideSolid(x, y, z + 1, NORTH)) ||
                (world.isSideSolid(x, y, z - 1, SOUTH)) ||
                (world.isSideSolid(x + 1, y, z, WEST)) ||
                (world.isSideSolid(x - 1, y, z, EAST));
    }

    /**
     * Called when a block is placed using its ItemBlock.
     */
    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
        // Prepare the orientation.
        int orientation = -1;

        // First check if the side it was placed on can accept it. If it can, place it there.
        if (side == 0 && world.isSideSolid(x, y + 1, z, DOWN))
            orientation = side;
        else if (side == 1 && world.isSideSolid(x, y - 1, z, UP))
            orientation = side;
        else if (side == 2 && world.isSideSolid(x, y, z + 1, NORTH))
            orientation = side;
        else if (side == 3 && world.isSideSolid(x, y, z - 1, SOUTH))
            orientation = side;
        else if (side == 4 && world.isSideSolid(x + 1, y, z, WEST))
            orientation = side;
        else if (side == 5 && world.isSideSolid(x - 1, y, z, EAST))
            orientation = side;
            // If the side it was placed on cannot accept it, place it on closest possible other side.
        else {
            if (world.isSideSolid(x, y + 1, z, DOWN))
                orientation = 0;
            else if (world.isSideSolid(x, y - 1, z, UP))
                orientation = 1;
            else if (world.isSideSolid(x, y, z + 1, NORTH))
                orientation = 2;
            else if (world.isSideSolid(x - 1, y, z, EAST))
                orientation = 5;
            else if (world.isSideSolid(x, y, z - 1, SOUTH))
                orientation = 3;
            else if (world.isSideSolid(x + 1, y, z, WEST))
                orientation = 4;
        }

        orientation = HexUtils.setBitTriInt(META_ORIENTATION_0, META_ORIENTATION_1, META_ORIENTATION_2, orientation, 0);

        // Return the new orientation as meta.
        return orientation;
    }

    /**
     * Called when a block near is changed.
     */
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        int orientation = HexUtils.getMetaBitTriInt(META_ORIENTATION_0, META_ORIENTATION_1, META_ORIENTATION_2, world, x, y, z);

        // Compare all neighbouring blocks, and if one of them correspond to the rotation, remove the monolith and drop the crystals.
        if(orientation == 0) {
            if (!world.isSideSolid(x, y + 1, z, DOWN)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(orientation == 1) {
            if (!world.isSideSolid(x, y - 1, z, UP)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(orientation == 2) {
            if (!world.isSideSolid(x, y, z + 1, NORTH)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(orientation == 3) {
            if (!world.isSideSolid(x, y, z - 1, SOUTH)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(orientation == 4) {
            if (!world.isSideSolid(x + 1, y, z, WEST)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(orientation == 5) {
            if (!world.isSideSolid(x - 1, y, z, EAST)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
    }

    /**
     * Sets up items to drop.
     */
    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        // Prepare a drop list.
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();

        // Return the block.
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

    public static void registerBlocks() {
        for (HexEnums.Colors color : HexEnums.Colors.values()) {
            String name = ID + color.name;
            Block block = new BlockMiniEnergizedHexorium(name, color);
            GameRegistry.registerBlock(block, name);
        }
    }

    public static void registerRenders() {
        for (HexEnums.Colors color : HexEnums.Colors.values()) {
            renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(new HexMiniBlockRenderer(renderID[HexCraft.idCounter],
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

    @Override
    public HexEnums.Colors getColor() {
        return color;
    }
}
