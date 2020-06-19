package com.celestek.hexcraft.block;

import coloredlightscore.src.api.CLApi;
import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.renderer.HexMiniBlockRenderer;
import com.celestek.hexcraft.init.HexAchievements;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.init.HexItems;
import com.celestek.hexcraft.util.HexEnums;
import com.celestek.hexcraft.util.HexUtils;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.ArrayList;

import static com.celestek.hexcraft.client.HexClientProxy.renderID;
import static com.celestek.hexcraft.client.renderer.HexMiniBlockRenderer.o;

public class BlockMiniEnergizedHexorium extends HexBlock implements IHexBlock, IBlockHexColor {

    // Block ID
    public static final String ID = "blockMiniEnergizedHexorium";

    // Meta Bits
    public static final int META_ORIENTATION_0 = 0;
    public static final int META_ORIENTATION_1 = 1;
    public static final int META_ORIENTATION_2 = 2;
    public static final int META_GLOWING = 3;

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
        return (!world.isAirBlock(x, y - 1, z)) ||
                (!world.isAirBlock(x, y + 1, z)) ||
                (!world.isAirBlock(x, y, z + 1)) ||
                (!world.isAirBlock(x, y, z - 1)) ||
                (!world.isAirBlock(x + 1, y, z)) ||
                (!world.isAirBlock(x - 1, y, z));
    }

    /**
     * Called when a block is placed using its ItemBlock.
     */
    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
        // Prepare the orientation.
        int orientation = -1;

        // First check if the side it was placed on can accept it. If it can, place it there.
        if (side == 0 && !world.isAirBlock(x, y + 1, z))
            orientation = side;
        else if (side == 1 && !world.isAirBlock(x, y - 1, z))
            orientation = side;
        else if (side == 2 && !world.isAirBlock(x, y, z + 1))
            orientation = side;
        else if (side == 3 && !world.isAirBlock(x, y, z - 1))
            orientation = side;
        else if (side == 4 && !world.isAirBlock(x + 1, y, z))
            orientation = side;
        else if (side == 5 && !world.isAirBlock(x - 1, y, z))
            orientation = side;
            // If the side it was placed on cannot accept it, place it on closest possible other side.
        else {
            if (!world.isAirBlock(x, y + 1, z))
                orientation = 0;
            else if (!world.isAirBlock(x, y - 1, z))
                orientation = 1;
            else if (!world.isAirBlock(x, y, z + 1))
                orientation = 2;
            else if (!world.isAirBlock(x - 1, y, z))
                orientation = 5;
            else if (!world.isAirBlock(x, y, z - 1))
                orientation = 3;
            else if (!world.isAirBlock(x + 1, y, z))
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
            if (world.isAirBlock(x, y + 1, z)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(orientation == 1) {
            if (world.isAirBlock(x, y - 1, z)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(orientation == 2) {
            if (world.isAirBlock(x, y, z + 1)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(orientation == 3) {
            if (world.isAirBlock(x, y, z - 1)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(orientation == 4) {
            if (world.isAirBlock(x + 1, y, z)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(orientation == 5) {
            if (world.isAirBlock(x - 1, y, z)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
    }

    /**
     * Gets the light value according to meta.
     */
    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        if (HexUtils.getMetaBit(META_GLOWING, world, x, y, z))
            if (Loader.isModLoaded("coloredlightscore")) {
                float multi = (float) HexConfig.cfgGeneralGlowstoneLightLevel / 15;
                return CLApi.makeRGBLightValue(color.r * multi, color.g * multi, color.b * multi);
            }
            else
                return HexConfig.cfgGeneralGlowstoneLightLevel;
        else
            return 0;
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

        // If the block was destroyed using the Manipulator...
        if (fortune == HexCraft.HEX_FORTUNE) {
            // If the block had Glowstone added to it.
            if (HexUtils.getMetaBit(META_GLOWING, world, x, y, z))
                drops.add(new ItemStack(Items.glowstone_dust, 1));
        }

        // Return the created drop array.
        return drops;
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        int orientation = HexUtils.getMetaBitTriInt(META_ORIENTATION_0, META_ORIENTATION_1, META_ORIENTATION_2, world, x, y, z);

        float a = 0;
        float b = 0;
        float c = 0;
        float d = 0;
        float e = 0;
        float f = 0;

        // UP
        if (orientation == 0) {
            a = 0 + o;
            b = 1 - o;
            c = 0 + o * 2;
            d = 1;
            e = 0 + o;
            f = 1 - o;
        }
        // DOWN
        else if (orientation == 1) {
            a = 0 + o;
            b = 1 - o;
            c = 0;
            d = 1 - o * 2;
            e = 0 + o;
            f = 1 - o;
        }
        // SOUTH
        else if (orientation == 2) {
            a = 0 + o;
            b = 1 - o;
            c = 0 + o;
            d = 1 - o;
            e = 0 + o * 2;
            f = 1;
        }
        // NORTH
        else if (orientation == 3) {
            a = 0 + o;
            b = 1 - o;
            c = 0 + o;
            d = 1 - o;
            e = 0;
            f = 1 - o * 2;
        }
        // EAST
        else if (orientation == 4) {
            a = 0 + o * 2;
            b = 1;
            c = 0 + o;
            d = 1 - o;
            e = 0 + o;
            f = 1 - o;
        }
        // WEST
        else if (orientation == 5) {
            a = 0;
            b = 1 - o * 2;
            c = 0 + o;
            d = 1 - o;
            e = 0 + o;
            f = 1 - o;
        }

        return AxisAlignedBB.getBoundingBox(x + a, y + c, z + e, x + b, y + d, z + f);
    }

    /**
     * Returns the bounding box of the wired rectangular prism to render.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
        int orientation = HexUtils.getMetaBitTriInt(META_ORIENTATION_0, META_ORIENTATION_1, META_ORIENTATION_2, world, x, y, z);

        float a = 0;
        float b = 0;
        float c = 0;
        float d = 0;
        float e = 0;
        float f = 0;

        // UP
        if (orientation == 0) {
            a = 0 + o;
            b = 1 - o;
            c = 0 + o * 2;
            d = 1;
            e = 0 + o;
            f = 1 - o;
        }
        // DOWN
        else if (orientation == 1) {
            a = 0 + o;
            b = 1 - o;
            c = 0;
            d = 1 - o * 2;
            e = 0 + o;
            f = 1 - o;
        }
        // SOUTH
        else if (orientation == 2) {
            a = 0 + o;
            b = 1 - o;
            c = 0 + o;
            d = 1 - o;
            e = 0 + o * 2;
            f = 1;
        }
        // NORTH
        else if (orientation == 3) {
            a = 0 + o;
            b = 1 - o;
            c = 0 + o;
            d = 1 - o;
            e = 0;
            f = 1 - o * 2;
        }
        // EAST
        else if (orientation == 4) {
            a = 0 + o * 2;
            b = 1;
            c = 0 + o;
            d = 1 - o;
            e = 0 + o;
            f = 1 - o;
        }
        // WEST
        else if (orientation == 5) {
            a = 0;
            b = 1 - o * 2;
            c = 0 + o;
            d = 1 - o;
            e = 0 + o;
            f = 1 - o;
        }

        setBlockBounds(a, c, e, b, d, f);
        return AxisAlignedBB.getBoundingBox(x + a, y + c, z + e, x + b, y + d, z + f);
    }

    /**
     * Fired when a player right clicks on the pylon.
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        if (!world.isRemote) {
            boolean isGlowing = HexUtils.getMetaBit(META_GLOWING, world, x, y, z);

            // Check if the item in player's hand is not null and if there is no monolith already inserted.
            if (player.getCurrentEquippedItem() != null && !isGlowing) {
                Item equipped = player.getCurrentEquippedItem().getItem();
                ArrayList<ItemStack> items = OreDictionary.getOres("dustGlowstone");
                boolean isGlowstone = false;
                for (ItemStack item : items) {
                    if (item.getItem() == equipped) {
                        isGlowstone = true;
                        break;
                    }
                }
                if (isGlowstone) {
                    ItemStack stack = player.getCurrentEquippedItem();
                    stack.stackSize--;
                    if (stack.stackSize == 0)
                        stack = null;
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, stack);

                    HexUtils.setMetaBit(META_GLOWING, true, HexUtils.META_NOTIFY_BOTH, world, x, y, z);

                    // Grant player the achievement.
                    if (HexConfig.cfgGeneralUseAchievements)
                        player.addStat(HexAchievements.achUseGlowstone, 1);

                    return true;
                }
            }
        }
        else
            return true;

        return false;
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
     * Makes the block not interact with AO.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isBlockNormalCube() {
        return false;
    }

    /**
     * Forces the block not to hide faces of other blocks.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isOpaqueCube() {
        return false;
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

    /**
     * Forces the block not to conduct Redstone current.
     */
    @Override
    public boolean shouldCheckWeakPower(IBlockAccess world, int x, int y, int z, int side) {
        return false;
    }

    /**
     * Return true if the block is a normal, solid cube.  This
     * determines indirect power state, entity ejection from blocks, and a few
     * others.
     *
     * @param world The current world
     * @param x X Position
     * @param y Y position
     * @param z Z position
     * @return True if the block is a full cube
     */
    @Override
    public boolean isNormalCube(IBlockAccess world, int x, int y, int z) {
        return false;
    }

    @Override
    public boolean isNormalCube() {
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
        for (HexEnums.Colors color : HexEnums.Colors.values()) {
            ItemStack blocks = new ItemStack(HexBlocks.getHexBlock(ID, color), 8);

            Block energized = HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, color);

            GameRegistry.addRecipe(new ShapelessOreRecipe(
                    blocks,
                    energized, HexItems.itemHexoriumSaw));
        }
    }

    @Override
    public HexEnums.Colors getColor() {
        return color;
    }
}
