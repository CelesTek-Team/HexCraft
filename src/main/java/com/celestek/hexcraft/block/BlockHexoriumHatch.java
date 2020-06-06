package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.renderer.HexModelRendererHatch;
import com.celestek.hexcraft.init.HexAchievements;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.init.HexItems;
import com.celestek.hexcraft.item.ItemHexoriumDye;
import com.celestek.hexcraft.item.ItemMolecularTransposer;
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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import static com.celestek.hexcraft.client.HexClientProxy.renderID;
import static net.minecraftforge.common.util.ForgeDirection.*;
import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.WEST;

public class BlockHexoriumHatch extends HexBlockModel implements IHexBlock, IBlockHexColor, IBlockHexVariant, IBlockUsableTransposer {

    // Block ID
    public static final String ID = "blockHexoriumHatch";

    // Meta Bits
    public static final int META_ROTATION_0 = 0;
    public static final int META_ROTATION_1 = 1;
    public static final int META_STATE = 2;
    public static final int META_REINFORCED = 3;

    // Color and variant
    private final HexEnums.Colors color;
    private final HexEnums.Variants variant;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     * @param color The color of the block to use.
     * @param variant The variant to use.
     */
    public BlockHexoriumHatch(String blockName, HexEnums.Colors color, HexEnums.Variants variant) {
        super(Material.iron);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.color = color;
        this.variant = variant;
        this.setCreativeTab(HexCraft.tabDecorative);

        // Assign harvest levels to all metas.
        for (int i = 0; i < 16; i++)
            if (HexUtils.getBit(META_REINFORCED, i))
                this.setHarvestLevel("pickaxe", 3, i);
            else
                this.setHarvestLevel("pickaxe", 2, i);

        this.setStepSound(Block.soundTypeMetal);
        this.setLightOpacity(0);
    }

    /**
     * Returns the block hardness at a location. Args: world, x, y, z
     */
    @Override
    public float getBlockHardness(World world, int x, int y, int z) {
        // If this is a normal block, return normal hardness. Otherwise, return obsidian hardness.
        if (!HexUtils.getMetaBit(META_REINFORCED, world, x, y, z))
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
        if (!HexUtils.getMetaBit(META_REINFORCED, world, x, y, z))
            return 30F / 5F;
        else
            return 6000F / 5F;
    }

    /**
     * Returns if mobs can walk through the block.
     */
    @Override
    public boolean getBlocksMovement(IBlockAccess world, int x, int y, int z) {
        // Check meta and return true if the hatch is open.
        return HexUtils.getMetaBit(META_STATE, world, x, y, z);
    }

    /**
     * Called when a player tries to place the hatch.
     */
    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        // Check if side block is solid.
        return (world.isSideSolid(x, y, z + 1, NORTH)) ||
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
        int rotation = -1;

        // First check if the side it was placed on can accept it. If it can, place it there.
        if (side == 2 && world.isSideSolid(x, y, z + 1, NORTH))
            rotation = 0;
        else if (side == 3 && world.isSideSolid(x, y, z - 1, SOUTH))
            rotation = 2;
        else if (side == 4 && world.isSideSolid(x + 1, y, z, WEST))
            rotation = 3;
        else if (side == 5 && world.isSideSolid(x - 1, y, z, EAST))
            rotation = 1;
        // If the side it was placed on cannot accept it, place it on closest possible other side.
        else {
            if (world.isSideSolid(x, y, z + 1, NORTH))
                rotation = 0;
            else if (world.isSideSolid(x - 1, y, z, EAST))
                rotation = 1;
            else if (world.isSideSolid(x, y, z - 1, SOUTH))
                rotation = 2;
            else if (world.isSideSolid(x + 1, y, z, WEST))
                rotation = 3;
        }

        rotation = HexUtils.setBitBiInt(META_ROTATION_0, META_ROTATION_1, rotation, 0);

        // Return the new orientation as meta.
        return rotation;
    }

    /**
     * Called when a block near is changed.
     */
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        int rotation = HexUtils.getMetaBitBiInt(META_ROTATION_0, META_ROTATION_1, world, x, y, z);

        // Check if the attached side is still solid.
        if ((rotation == 0 && !world.isSideSolid(x, y, z + 1, NORTH)) ||
                (rotation == 1 && !world.isSideSolid(x - 1, y, z, EAST)) ||
                (rotation == 2 && !world.isSideSolid(x, y, z - 1, SOUTH)) ||
                (rotation == 3 && !world.isSideSolid(x + 1, y, z, WEST))) {
            // If it isn't, drop it and set the block to air.
            this.dropBlockAsItem(world, x, y, z, 0, 0);
            world.setBlockToAir(x, y, z);
        }

        // Calculate if the hatch is powered and toggle the hatch state if needed.
        if (block.canProvidePower()) {
            boolean state = HexUtils.getMetaBit(META_STATE, world, x, y, z);
            boolean powered = world.isBlockIndirectlyGettingPowered(x, y, z);

            if (!state && powered) {
                HexUtils.setMetaBit(META_STATE, true, HexUtils.META_NOTIFY_UPDATE, world, x, y, z);
                world.playAuxSFXAtEntity(null, 1003, x, y, z, 0);
            }
            else if (state && !powered) {
                HexUtils.setMetaBit(META_STATE, false, HexUtils.META_NOTIFY_UPDATE, world, x, y, z);
                world.playAuxSFXAtEntity(null, 1003, x, y, z, 0);
            }
        }
    }

    /**
     * Returns the bounding box of the wired rectangular prism to render.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
        this.setBlockBoundsBasedOnState(world, x, y, z);
        return super.getSelectedBoundingBoxFromPool(world, x, y, z);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        this.setBlockBoundsBasedOnState(world, x, y, z);
        return super.getCollisionBoundingBoxFromPool(world, x, y, z);
    }

    /**
     * Updates the blocks bounds based on its current state.
     */
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        // Prepare the variables.
        float hThck = HexModelRendererHatch.hThck;

        // Prepare block meta and normalize meta.
        int rotation = HexUtils.getMetaBitBiInt(META_ROTATION_0, META_ROTATION_1, world, x, y, z);
        boolean state = HexUtils.getMetaBit(META_STATE, world, x, y, z);

        // Set block bounds depending on parameters.
        if (!state)
            this.setBlockBounds(0, 0, 0, 1, hThck, 1);
        else if (rotation == 0)
            this.setBlockBounds(0, 0, 1 - hThck, 1, 1, 1);
        else if (rotation == 1)
            this.setBlockBounds(0, 0, 0, hThck, 1, 1);
        else if (rotation == 2)
            this.setBlockBounds(0, 0, 0, 1, 1, hThck);
        else if (rotation == 3)
            this.setBlockBounds(1 - hThck, 0, 0, 1, 1, 1);
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int a, float b, float c, float d) {
        if (!world.isRemote) {
            if (player.getHeldItem() != null && ((player.getHeldItem().getItem() instanceof ItemHexoriumDye) || (player.getHeldItem().getItem() instanceof ItemMolecularTransposer)))
                return true;

            // Prepare a variable if the hatch is in a usable state.
            boolean use = false;
            // If player has no item in hand.
            if (player.getCurrentEquippedItem() == null)
                use = true;
                // If player has an item in hand.
            else {
                // Don't use hatch if Hexorium Reinforcer is present.
                if (player.getCurrentEquippedItem().getItem() == HexItems.itemHexoriumReinforcer) {
                    // If the hatch is not upgraded, upgrade it.
                    if (!HexUtils.getMetaBit(META_REINFORCED, world, x, y, z)) {
                        HexUtils.setMetaBit(META_REINFORCED, true, HexUtils.META_NOTIFY_UPDATE, world, x, y, z);

                        // Grant player the achievement.
                        if (HexConfig.cfgGeneralUseAchievements)
                            player.addStat(HexAchievements.achUseReinforcer, 1);

                        ItemStack stack = player.getCurrentEquippedItem();
                        stack.stackSize--;
                        if (stack.stackSize == 0)
                            stack = null;
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, stack);
                    }
                    else
                        use = true;
                }
                else
                    use = true;
            }

            // Use hatch.
            if (use) {
                // Set according block meta and play sound.
                HexUtils.flipMetaBit(META_STATE, HexUtils.META_NOTIFY_UPDATE, world, x, y, z);
                world.playAuxSFXAtEntity(null, 1003, x, y, z, 0);
            }
        }

        return true;
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
        icon = new IIcon[12];
        // Load the outer textures.
        for (int i = 0; i < 11; i++) {
            if (i <= 4 || i >= 10) {
                if (i < 9)
                    icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + this.variant.name + "0" + (i + 1));
                else
                    icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + this.variant.name + (i + 1));
            }
            else {
                if (i < 9)
                    icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "0" + (i + 1));
                else
                    icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + (i + 1));
            }
        }
        // Load the inner texture.
        if(this.color == HexEnums.Colors.RAINBOW)
            icon[11] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glowRainbow");
        else
            icon[11] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glow");
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        boolean state = HexUtils.getBit(META_STATE, meta);
        int rotation = HexUtils.getBitBiInt(META_ROTATION_0, META_ROTATION_1, meta);

        // Prepare texture parameters: rei - reinforced
        int rei = 0;

        if (HexUtils.getBit(META_REINFORCED, meta))
            rei = 5;

        // Return icons based on parameters, side and meta.
        if (side == 6)
            return icon[11];
        else if (side == 7)
            return icon[10];
        else if (!state) {
            if (side < 2)
                return icon[rotation + rei];
            else
                return icon[4 + rei];
        }
        else if (rotation == 0 || rotation == 2) {
            if (side > 1 && side < 4)
                return icon[rei];
            else
                return icon[4 + rei];
        }
        else if (rotation == 1 || rotation == 3) {
            if (side > 3)
                return icon[rei];
            else
                return icon[4 + rei];
        }
        return icon[0];
    }

    @Override
    public String getID() {
        return ID;
    }

    public static void registerBlocks() {
        for (HexEnums.Variants variant : HexEnums.Variants.values()) {
            for (HexEnums.Colors color : HexEnums.Colors.values()) {
                String name = ID + variant.name + color.name;
                Block block = new BlockHexoriumHatch(name, color, variant);
                GameRegistry.registerBlock(block, name);
            }
        }
    }

    public static void registerRenders() {
        for (HexEnums.Variants variant : HexEnums.Variants.values()) {
            for (HexEnums.Colors color : HexEnums.Colors.values()) {
                renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
                RenderingRegistry.registerBlockHandler(new HexModelRendererHatch(renderID[HexCraft.idCounter],
                        HexEnums.Brightness.BRIGHT, color));
            }
        }
    }

    public static void registerRecipes() {
        for (HexEnums.Variants variant : HexEnums.Variants.values()) {
            for (HexEnums.Colors color : HexEnums.Colors.values()) {
                Block block = HexBlocks.getHexBlock(ID, variant, color);

                Block energized = HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, color);
                Block glass = HexBlocks.getHexBlock(BlockTemperedHexoriumGlass.ID, variant);
                Item dye = HexItems.getHexItem(ItemHexoriumDye.ID, variant);

                GameRegistry.addRecipe(new ShapedOreRecipe(
                        block,
                        "IGI",
                        "IHI",
                        "   ",
                        'H', energized, 'I', "ingotIron", 'G', glass));

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
