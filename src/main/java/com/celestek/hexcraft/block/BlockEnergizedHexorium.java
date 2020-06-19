package com.celestek.hexcraft.block;

import coloredlightscore.src.api.CLApi;
import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.renderer.HexBlockRenderer;
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
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.ArrayList;

import static com.celestek.hexcraft.client.HexClientProxy.renderID;

public class BlockEnergizedHexorium extends HexBlock implements IHexBlock, IBlockHexColor {

    // Block ID
    public static final String ID = "blockEnergizedHexorium";

    // Meta Bits
    public static final int META_GLOWING = 3;

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

        // If the block wasn't destroyed using the Manipulator...
        if(fortune != HexCraft.HEX_FORTUNE) {
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
        else {
            // Return the block (because of Manipulator).
            drops.add(new ItemStack(this, 1));

            // If the block had Glowstone added to it.
            if (HexUtils.getMetaBit(META_GLOWING, world, x, y, z))
                drops.add(new ItemStack(Items.glowstone_dust, 1));
        }

        // Return the created drop array.
        return drops;
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
            Block block = new BlockEnergizedHexorium(name, color);
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

        for (HexEnums.Colors color : HexEnums.Colors.values()) {
            Block block = HexBlocks.getHexBlock(ID, color);

            Block mini = HexBlocks.getHexBlock(BlockMiniEnergizedHexorium.ID, color);

            GameRegistry.addRecipe(new ShapelessOreRecipe(
                    block,
                    mini, mini, mini, mini, mini, mini, mini, mini));
        }
    }

    @Override
    public HexEnums.Colors getColor() {
        return color;
    }
}
