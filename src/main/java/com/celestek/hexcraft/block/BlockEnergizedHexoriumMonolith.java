package com.celestek.hexcraft.block;

import coloredlightscore.src.api.CLApi;
import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.HexClientProxy;
import com.celestek.hexcraft.client.renderer.HexModelRendererMonolith;
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

import java.util.ArrayList;

import static com.celestek.hexcraft.client.HexClientProxy.renderID;
import static net.minecraftforge.common.util.ForgeDirection.*;

public class BlockEnergizedHexoriumMonolith extends HexBlockModel implements IHexBlock, IBlockHexColor {

    // Block ID
    public static final String ID = "blockEnergizedHexoriumMonolith";

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
    public BlockEnergizedHexoriumMonolith(String blockName, HexEnums.Colors color) {
        super(Material.glass);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.color = color;
        this.setCreativeTab(HexCraft.tabDecorative);

        this.setHardness(0.3F);

        this.setStepSound(Block.soundTypeGlass);
        this.setLightOpacity(0);
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
     * Gets the light value according to meta.
     */
    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        if (HexUtils.getMetaBit(META_GLOWING, world, x, y, z))
            if (Loader.isModLoaded("coloredlightscore")) {
                float multi = (float) HexConfig.cfgGeneralMonolithGlowstoneLightLevel / 15;
                return CLApi.makeRGBLightValue(color.r * multi, color.g * multi, color.b * multi);
            }
            else
                return HexConfig.cfgGeneralMonolithGlowstoneLightLevel;
        else
            return 0;
    }

    /**
     * Sets up items to drop.
     */
    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();

        // If the block wasn't destroyed using the Manipulator...
        if (fortune != HexCraft.hexFortune) {
            switch (this.color) {
                case RED:
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 8));
                    break;
                case ORANGE:
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 6));
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 2));
                    break;
                case YELLOW:
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 4));
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 4));
                    break;
                case LIME:
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 2));
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 6));
                    break;
                case GREEN:
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 8));
                    break;
                case TURQUOISE:
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 6));
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 2));
                    break;
                case CYAN:
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 4));
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 4));
                    break;
                case SKY_BLUE:
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 2));
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 6));
                    break;
                case BLUE:
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 8));
                    break;
                case PURPLE:
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 6));
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 2));
                    break;
                case MAGENTA:
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 4));
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 4));
                    break;
                case PINK:
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 2));
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 6));
                    break;
                case WHITE:
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 8));
                    break;
                case LIGHT_GRAY:
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 6));
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlack, 2));
                    break;
                case GRAY:
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 4));
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlack, 4));
                    break;
                case DARK_GRAY:
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 2));
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlack, 6));
                    break;
                case BLACK:
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlack, 8));
                    break;
                case RAINBOW:
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalRed, 2));
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalGreen, 2));
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalBlue, 2));
                    drops.add(new ItemStack(HexItems.itemHexoriumCrystalWhite, 2));
                    break;
            }
        }
        // Return the block (because of Manipulator).
        else {
            drops.add(new ItemStack(this, 1));

            // If the monolith had Glowstone added to it.
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

        // Return bounding box depending on meta.
        switch (HexUtils.getMetaBitTriInt(META_ORIENTATION_0, META_ORIENTATION_1, META_ORIENTATION_2, world, x, y, z)) {
            case 0:
                return AxisAlignedBB.getBoundingBox((double)x + HexModelRendererMonolith.xA, (double)y + 1 - HexModelRendererMonolith.yMax, (double)z + HexModelRendererMonolith.zF,
                        (double)x + HexModelRendererMonolith.xD, (double)y + 1 - HexModelRendererMonolith.yMin, (double)z + HexModelRendererMonolith.zB);
            case 1:
                return AxisAlignedBB.getBoundingBox((double)x + HexModelRendererMonolith.xA, (double)y + HexModelRendererMonolith.yMin, (double)z + HexModelRendererMonolith.zF,
                        (double)x + HexModelRendererMonolith.xD, (double)y + HexModelRendererMonolith.yMax, (double)z + HexModelRendererMonolith.zB);
            case 2:
                return AxisAlignedBB.getBoundingBox((double)x + HexModelRendererMonolith.zF, (double)y + HexModelRendererMonolith.xA, (double)z + 1 - HexModelRendererMonolith.yMax,
                        (double)x + HexModelRendererMonolith.zB, (double)y + HexModelRendererMonolith.xD, (double)z + 1 - HexModelRendererMonolith.yMin);
            case 3:
                return AxisAlignedBB.getBoundingBox((double)x + HexModelRendererMonolith.zF, (double)y + HexModelRendererMonolith.xA, (double)z + HexModelRendererMonolith.yMin,
                        (double)x + HexModelRendererMonolith.zB, (double)y + HexModelRendererMonolith.xD, (double)z + HexModelRendererMonolith.yMax);
            case 4:
                return AxisAlignedBB.getBoundingBox((double)x + 1 - HexModelRendererMonolith.yMax, (double)y + HexModelRendererMonolith.xA, (double)z + HexModelRendererMonolith.zF,
                        (double)x + 1 - HexModelRendererMonolith.yMin, (double)y + HexModelRendererMonolith.xD, (double)z + HexModelRendererMonolith.zB);
            case 5:
                return AxisAlignedBB.getBoundingBox((double)x + HexModelRendererMonolith.yMin, (double)y + HexModelRendererMonolith.xA, (double)z + HexModelRendererMonolith.zF,
                        (double)x + HexModelRendererMonolith.yMax, (double)y + HexModelRendererMonolith.xD, (double)z + HexModelRendererMonolith.zB);
            default:
                return AxisAlignedBB.getBoundingBox((double)x + 0, (double)y + 0, (double)z + 0, (double)x + 1, (double)y + 1, (double)z + 1);
        }
    }

    /**
     * Returns the bounding box of the wired rectangular prism to render.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {

        // Return bounding box depending on meta.
        switch (HexUtils.getMetaBitTriInt(META_ORIENTATION_0, META_ORIENTATION_1, META_ORIENTATION_2, world, x, y, z)) {
            case 0: setBlockBounds(HexModelRendererMonolith.xA, 1 - HexModelRendererMonolith.yMax, HexModelRendererMonolith.zF,
                    HexModelRendererMonolith.xD, 1 - HexModelRendererMonolith.yMin, HexModelRendererMonolith.zB);
                return AxisAlignedBB.getBoundingBox((double)x + HexModelRendererMonolith.xA, (double)y + 1 - HexModelRendererMonolith.yMax, (double)z + HexModelRendererMonolith.zF,
                        (double)x + HexModelRendererMonolith.xD, (double)y + 1 - HexModelRendererMonolith.yMin, (double)z + HexModelRendererMonolith.zB);
            case 1: setBlockBounds(HexModelRendererMonolith.xA, HexModelRendererMonolith.yMin, HexModelRendererMonolith.zF,
                    HexModelRendererMonolith.xD, HexModelRendererMonolith.yMax, HexModelRendererMonolith.zB);
                return AxisAlignedBB.getBoundingBox((double)x + HexModelRendererMonolith.xA, (double)y + HexModelRendererMonolith.yMin, (double)z + HexModelRendererMonolith.zF,
                        (double)x + HexModelRendererMonolith.xD, (double)y + HexModelRendererMonolith.yMax, (double)z + HexModelRendererMonolith.zB);
            case 2: setBlockBounds(HexModelRendererMonolith.zF, HexModelRendererMonolith.xA, 1 - HexModelRendererMonolith.yMax,
                    HexModelRendererMonolith.zB, HexModelRendererMonolith.xD, 1 - HexModelRendererMonolith.yMin);
                return AxisAlignedBB.getBoundingBox((double)x + HexModelRendererMonolith.zF, (double)y + HexModelRendererMonolith.xA, (double)z + 1 - HexModelRendererMonolith.yMax,
                        (double)x + HexModelRendererMonolith.zB, (double)y + HexModelRendererMonolith.xD, (double)z + 1 - HexModelRendererMonolith.yMin);
            case 3: setBlockBounds(HexModelRendererMonolith.zF, HexModelRendererMonolith.xA, HexModelRendererMonolith.yMin,
                    HexModelRendererMonolith.zB, HexModelRendererMonolith.xD, HexModelRendererMonolith.yMax);
                return AxisAlignedBB.getBoundingBox((double)x + HexModelRendererMonolith.zF, (double)y + HexModelRendererMonolith.xA, (double)z + HexModelRendererMonolith.yMin,
                        (double)x + HexModelRendererMonolith.zB, (double)y + HexModelRendererMonolith.xD, (double)z + HexModelRendererMonolith.yMax);
            case 4: setBlockBounds(1 - HexModelRendererMonolith.yMax, HexModelRendererMonolith.xA, HexModelRendererMonolith.zF,
                    1 - HexModelRendererMonolith.yMin, HexModelRendererMonolith.xD, HexModelRendererMonolith.zB);
                return AxisAlignedBB.getBoundingBox((double)x + 1 - HexModelRendererMonolith.yMax, (double)y + HexModelRendererMonolith.xA, (double)z + HexModelRendererMonolith.zF,
                        (double)x + 1 - HexModelRendererMonolith.yMin, (double)y + HexModelRendererMonolith.xD, (double)z + HexModelRendererMonolith.zB);
            case 5: setBlockBounds(HexModelRendererMonolith.yMin, HexModelRendererMonolith.xA, HexModelRendererMonolith.zF,
                    HexModelRendererMonolith.yMax, HexModelRendererMonolith.xD, HexModelRendererMonolith.zB);
                return AxisAlignedBB.getBoundingBox((double)x + HexModelRendererMonolith.yMin, (double)y + HexModelRendererMonolith.xA, (double)z + HexModelRendererMonolith.zF,
                        (double)x + HexModelRendererMonolith.yMax, (double)y + HexModelRendererMonolith.xD, (double)z + HexModelRendererMonolith.zB);
            default:
                return AxisAlignedBB.getBoundingBox((double)x + 0, (double)y + 0, (double)z + 0, (double)x + 1, (double)y + 1, (double)z + 1);
        }
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
                Item item = player.getCurrentEquippedItem().getItem();
                if (item == Items.glowstone_dust) {
                    ItemStack stack = player.getCurrentEquippedItem();
                    stack.stackSize--;
                    if (stack.stackSize == 0)
                        stack = null;
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, stack);

                    HexUtils.setMetaBit(META_GLOWING, true, HexUtils.META_NOTIFY_BOTH, world, x, y, z);

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
        // Load the monolith texture. Use special texture if it is a rainbow.
        if(this.color == HexEnums.Colors.RAINBOW)
            icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "Rainbow");
        else
            icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID);
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
     * Makes the block render only on one pass.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean canRenderInPass(int pass) {
        if (pass == 1) {
            // Save the current rendering pass of the block to HexClientProxy.
            HexClientProxy.renderPass[idBlock] = pass;
            return true;
        }
        return false;
    }

    /**
     * Makes the block render only on one pass.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    public String getID() {
        return ID;
    }

    public static void registerBlocks() {
        for (HexEnums.Colors color : HexEnums.Colors.values()) {
            String name = ID + color.name;
            Block block = new BlockEnergizedHexoriumMonolith(name, color);
            GameRegistry.registerBlock(block, name);
        }
    }

    public static void registerRenders() {
        for (HexEnums.Colors color : HexEnums.Colors.values()) {
            renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(new HexModelRendererMonolith(renderID[HexCraft.idCounter],
                    HexEnums.Brightness.BRIGHT, HexEnums.OPACITY_SLIGHT, color, false));
        }
    }

    @Override
    public HexEnums.Colors getColor() {
        return color;
    }
}
