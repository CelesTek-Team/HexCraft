package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.renderer.HexModelRendererDoor;
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
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import static com.celestek.hexcraft.client.HexClientProxy.renderID;
import static net.minecraftforge.common.util.ForgeDirection.*;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class BlockHexoriumDoor extends HexBlockModel implements IHexBlock, IBlockHexColor, IBlockHexVariant, IBlockUsableTransposer {

    // Block ID
    public static final String ID = "blockHexoriumDoor";

    // Meta Bits
    public static final int META_ROTATION_0 = 0;
    public static final int META_ROTATION_1 = 1;
    public static final int META_STATE = 2;
    public static final int META_REINFORCED = 3; // Stored on both doors.
    public static final int META_FLIPPED = 0; // Stored on upper door.

    // Color and variant
    private final HexEnums.Colors color;
    private final HexEnums.Variants variant;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     * @param color The color of the block to use.
     * @param variant The variant to use.
     */
    public BlockHexoriumDoor(String blockName, HexEnums.Colors color, HexEnums.Variants variant) {
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
    public boolean getBlocksMovement(IBlockAccess world, int x, int y, int z) {
        // Check meta and return true if the door is open.
        if (world.getBlock(x, y + 1, z) == this) {
            if (HexUtils.getMetaBit(META_STATE, world, x, y, z))
                return true;
        }
        else if (world.getBlock(x, y - 1, z) == this) {
            if (HexUtils.getMetaBit(META_STATE, world, x, y - 1, z))
                return true;
        }
        return false;
    }

    /**
     * Called when a player tries to place the door.
     */
    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        // Check if bottom block is solid and if there is space above.
        return (world.isSideSolid(x, y - 1, z, UP) && world.isAirBlock(x, y + 1, z)) ||
                (world.isSideSolid(x, y - 2, z, UP) && world.getBlock(x, y - 1, z) == this);
    }

    /**
     * Called when a block is placed by a player.
     */
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
        // Calculate door orientation.
        int rotation = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        // Set the upper door.
        if (world.isAirBlock(x, y + 1, z))
            world.setBlock(x, y + 1, z, this);

        // Set the block's meta data according to direction.
        HexUtils.setMetaBitBiInt(META_ROTATION_0, META_ROTATION_1, rotation, HexUtils.META_NOTIFY_UPDATE, world, x, y, z);

        // Set make the door flipped if it should be double-doors.
        if (rotation == 0) {
            if (world.getBlock(x + 1, y, z) instanceof BlockHexoriumDoor) {
                int rot = HexUtils.getMetaBitBiInt(META_ROTATION_0, META_ROTATION_1, world, x + 1, y, z);
                if (rot == 0)
                    HexUtils.setMetaBit(META_FLIPPED, true, HexUtils.META_NOTIFY_UPDATE, world, x, y + 1, z);
            }
        }
        else if (rotation == 1) {
            if (world.getBlock(x, y, z + 1) instanceof BlockHexoriumDoor) {
                int rot = HexUtils.getMetaBitBiInt(META_ROTATION_0, META_ROTATION_1, world, x, y, z + 1);
                if (rot == 1)
                    HexUtils.setMetaBit(META_FLIPPED, true, HexUtils.META_NOTIFY_UPDATE, world, x, y + 1, z);
            }
        }
        else if (rotation == 2) {
            if (world.getBlock(x - 1, y, z) instanceof BlockHexoriumDoor) {
                int rot = HexUtils.getMetaBitBiInt(META_ROTATION_0, META_ROTATION_1, world, x - 1, y, z);
                if (rot == 2)
                    HexUtils.setMetaBit(META_FLIPPED, true, HexUtils.META_NOTIFY_UPDATE, world, x, y + 1, z);
            }
        }
        else if (rotation == 3) {
            if (world.getBlock(x, y, z - 1) instanceof BlockHexoriumDoor) {
                int rot = HexUtils.getMetaBitBiInt(META_ROTATION_0, META_ROTATION_1, world, x, y, z - 1);
                if (rot == 3)
                    HexUtils.setMetaBit(META_FLIPPED, true, HexUtils.META_NOTIFY_UPDATE, world, x, y + 1, z);
            }
        }
    }

    /**
     * Called when a block near is changed.
     */
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        // Check if the block below is still solid and if the upper door still exists, or if the lower door still exists.
        if (!((world.isSideSolid(x, y - 1, z, UP) && world.getBlock(x, y + 1, z) == this) ||
                (world.getBlock(x, y - 1, z) == this))) {
            // If it doesn't, and this is the lower door, drop it and set the block to air.
            if (world.getBlock(x, y + 1, z) == this)
                this.dropBlockAsItem(world, x, y, z, 0, 0);
            world.setBlockToAir(x, y, z);
        }

        // Calculate if the door is powered and toggle the door state if needed.
        if (block.canProvidePower()) {
            if (world.getBlock(x, y + 1, z) == this) {
                boolean state = HexUtils.getMetaBit(META_STATE, world, x, y, z);
                boolean powered = world.isBlockIndirectlyGettingPowered(x, y, z) || world.isBlockIndirectlyGettingPowered(x, y + 1, z);
                int rotation = HexUtils.getMetaBitBiInt(META_ROTATION_0, META_ROTATION_1, world, x, y, z);

                if (!HexUtils.getMetaBit(META_FLIPPED, world, x, y + 1, z)) {
                    if (rotation == 0 && world.getBlock(x - 1, y + 1, z) instanceof BlockHexoriumDoor && HexUtils.getMetaBit(META_FLIPPED, world, x - 1, y + 1, z))
                        powered = powered || world.isBlockIndirectlyGettingPowered(x - 1, y, z) || world.isBlockIndirectlyGettingPowered(x - 1, y + 1, z);
                    else if (rotation == 1 && world.getBlock(x, y + 1, z - 1) instanceof BlockHexoriumDoor && HexUtils.getMetaBit(META_FLIPPED, world, x, y + 1, z - 1))
                        powered = powered || world.isBlockIndirectlyGettingPowered(x, y, z - 1) || world.isBlockIndirectlyGettingPowered(x, y + 1, z - 1);
                    else if (rotation == 2 && world.getBlock(x + 1, y + 1, z) instanceof BlockHexoriumDoor && HexUtils.getMetaBit(META_FLIPPED, world, x + 1, y + 1, z))
                        powered = powered || world.isBlockIndirectlyGettingPowered(x + 1, y, z) || world.isBlockIndirectlyGettingPowered(x + 1, y + 1, z);
                    else if (rotation == 3 && world.getBlock(x, y + 1, z + 1) instanceof BlockHexoriumDoor && HexUtils.getMetaBit(META_FLIPPED, world, x, y + 1, z + 1))
                        powered = powered || world.isBlockIndirectlyGettingPowered(x, y, z + 1) || world.isBlockIndirectlyGettingPowered(x, y + 1, z + 1);
                }
                else {
                    if (rotation == 0 && world.getBlock(x + 1, y + 1, z) instanceof BlockHexoriumDoor)
                        powered = powered || world.isBlockIndirectlyGettingPowered(x + 1, y, z) || world.isBlockIndirectlyGettingPowered(x + 1, y + 1, z);
                    else if (rotation == 1 && world.getBlock(x, y + 1, z + 1)  instanceof BlockHexoriumDoor)
                        powered = powered || world.isBlockIndirectlyGettingPowered(x, y, z + 1) || world.isBlockIndirectlyGettingPowered(x, y + 1, z + 1);
                    else if (rotation == 2 && world.getBlock(x - 1, y + 1, z) instanceof BlockHexoriumDoor)
                        powered = powered || world.isBlockIndirectlyGettingPowered(x - 1, y, z) || world.isBlockIndirectlyGettingPowered(x - 1, y + 1, z);
                    else if (rotation == 3 && world.getBlock(x, y + 1, z - 1) instanceof BlockHexoriumDoor)
                        powered = powered || world.isBlockIndirectlyGettingPowered(x, y, z - 1) || world.isBlockIndirectlyGettingPowered(x, y + 1, z - 1);
                }

                if (!state && powered) {
                    HexUtils.setMetaBit(META_STATE, true, HexUtils.META_NOTIFY_UPDATE, world, x, y, z);
                    world.markBlockForUpdate(x, y + 1, z);
                    world.playAuxSFXAtEntity(null, 1003, x, y, z, 0);
                }
                else if (state && !powered) {
                    HexUtils.setMetaBit(META_STATE, false, HexUtils.META_NOTIFY_UPDATE, world, x, y, z);
                    world.markBlockForUpdate(x, y + 1, z);
                    world.playAuxSFXAtEntity(null, 1003, x, y, z, 0);
                }

                // Toggle the flipped door.
                if (!HexUtils.getMetaBit(META_FLIPPED, world, x, y + 1, z)) {
                    if (rotation == 0 && world.getBlock(x - 1, y + 1, z) instanceof BlockHexoriumDoor && HexUtils.getMetaBit(META_FLIPPED, world, x - 1, y + 1, z)) {
                        HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y, z), HexUtils.META_NOTIFY_UPDATE, world, x - 1, y, z);
                        world.markBlockForUpdate(x - 1, y + 1, z);
                    }
                    else if (rotation == 1 && world.getBlock(x, y + 1, z - 1) instanceof BlockHexoriumDoor && HexUtils.getMetaBit(META_FLIPPED, world, x, y + 1, z - 1)) {
                        HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y, z), HexUtils.META_NOTIFY_UPDATE, world, x, y, z - 1);
                        world.markBlockForUpdate(x, y + 1, z - 1);
                    }
                    else if (rotation == 2 && world.getBlock(x + 1, y + 1, z) instanceof BlockHexoriumDoor && HexUtils.getMetaBit(META_FLIPPED, world, x + 1, y + 1, z)) {
                        HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y, z), HexUtils.META_NOTIFY_UPDATE, world, x + 1, y, z);
                        world.markBlockForUpdate(x + 1, y + 1, z);
                    }
                    else if (rotation == 3 && world.getBlock(x, y + 1, z + 1) instanceof BlockHexoriumDoor && HexUtils.getMetaBit(META_FLIPPED, world, x, y + 1, z + 1)) {
                        HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y, z), HexUtils.META_NOTIFY_UPDATE, world, x, y, z + 1);
                        world.markBlockForUpdate(x, y + 1, z + 1);
                    }
                }
                else {
                    if (rotation == 0 && world.getBlock(x + 1, y + 1, z) instanceof BlockHexoriumDoor) {
                        HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y, z), HexUtils.META_NOTIFY_UPDATE, world, x + 1, y, z);
                        world.markBlockForUpdate(x + 1, y + 1, z);
                    }
                    else if (rotation == 1 && world.getBlock(x, y + 1, z + 1) instanceof BlockHexoriumDoor) {
                        HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y, z), HexUtils.META_NOTIFY_UPDATE, world, x, y, z + 1);
                        world.markBlockForUpdate(x, y + 1, z + 1);
                    }
                    else if (rotation == 2 && world.getBlock(x - 1, y + 1, z) instanceof BlockHexoriumDoor) {
                        HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y, z), HexUtils.META_NOTIFY_UPDATE, world, x - 1, y, z);
                        world.markBlockForUpdate(x - 1, y + 1, z);
                    }
                    else if (rotation == 3 && world.getBlock(x, y + 1, z - 1) instanceof BlockHexoriumDoor) {
                        HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y, z), HexUtils.META_NOTIFY_UPDATE, world, x, y, z - 1);
                        world.markBlockForUpdate(x, y + 1, z - 1);
                    }
                }
            }
            else if (world.getBlock(x, y - 1, z) == this) {
                boolean state = HexUtils.getMetaBit(META_STATE, world, x, y - 1, z);
                boolean powered = world.isBlockIndirectlyGettingPowered(x, y, z) || world.isBlockIndirectlyGettingPowered(x, y - 1, z);
                int rotation = HexUtils.getMetaBitBiInt(META_ROTATION_0, META_ROTATION_1, world, x, y - 1, z);

                if (!HexUtils.getMetaBit(META_FLIPPED, world, x, y, z)) {
                    if (rotation == 0 && world.getBlock(x - 1, y, z) instanceof BlockHexoriumDoor && HexUtils.getMetaBit(META_FLIPPED, world, x - 1, y, z))
                        powered = powered || world.isBlockIndirectlyGettingPowered(x - 1, y, z) || world.isBlockIndirectlyGettingPowered(x - 1, y - 1, z);
                    else if (rotation == 1 && world.getBlock(x, y, z - 1) instanceof BlockHexoriumDoor && HexUtils.getMetaBit(META_FLIPPED, world, x, y, z - 1))
                        powered = powered || world.isBlockIndirectlyGettingPowered(x, y, z - 1) || world.isBlockIndirectlyGettingPowered(x, y - 1, z - 1);
                    else if (rotation == 2 && world.getBlock(x + 1, y, z) instanceof BlockHexoriumDoor && HexUtils.getMetaBit(META_FLIPPED, world, x + 1, y, z))
                        powered = powered || world.isBlockIndirectlyGettingPowered(x + 1, y, z) || world.isBlockIndirectlyGettingPowered(x + 1, y - 1, z);
                    else if (rotation == 3 && world.getBlock(x, y, z + 1) instanceof BlockHexoriumDoor && HexUtils.getMetaBit(META_FLIPPED, world, x, y, z + 1))
                        powered = powered || world.isBlockIndirectlyGettingPowered(x, y, z + 1) || world.isBlockIndirectlyGettingPowered(x, y - 1, z + 1);
                }
                else {
                    if (rotation == 0 && world.getBlock(x + 1, y, z) instanceof BlockHexoriumDoor)
                        powered = powered || world.isBlockIndirectlyGettingPowered(x + 1, y, z) || world.isBlockIndirectlyGettingPowered(x + 1, y - 1, z);
                    else if (rotation == 1 && world.getBlock(x, y, z + 1) instanceof BlockHexoriumDoor)
                        powered = powered || world.isBlockIndirectlyGettingPowered(x, y, z + 1) || world.isBlockIndirectlyGettingPowered(x, y - 1, z + 1);
                    else if (rotation == 2 && world.getBlock(x - 1, y, z) instanceof BlockHexoriumDoor)
                        powered = powered || world.isBlockIndirectlyGettingPowered(x - 1, y, z) || world.isBlockIndirectlyGettingPowered(x - 1, y - 1, z);
                    else if (rotation == 3 && world.getBlock(x, y, z - 1) instanceof BlockHexoriumDoor)
                        powered = powered || world.isBlockIndirectlyGettingPowered(x, y, z - 1) || world.isBlockIndirectlyGettingPowered(x, y - 1, z - 1);
                }

                if (!state && powered) {
                    HexUtils.setMetaBit(META_STATE, true, HexUtils.META_NOTIFY_UPDATE, world, x, y - 1, z);
                    world.markBlockForUpdate(x, y, z);
                    world.playAuxSFXAtEntity(null, 1003, x, y, z, 0);
                }
                else if (state && !powered) {
                    HexUtils.setMetaBit(META_STATE, false, HexUtils.META_NOTIFY_UPDATE, world, x, y - 1, z);
                    world.markBlockForUpdate(x, y, z);
                    world.playAuxSFXAtEntity(null, 1003, x, y, z, 0);
                }

                // Toggle the flipped door.
                if (!HexUtils.getMetaBit(META_FLIPPED, world, x, y, z)) {
                    if (rotation == 0 && world.getBlock(x - 1, y, z) instanceof BlockHexoriumDoor && HexUtils.getMetaBit(META_FLIPPED, world, x - 1, y, z)) {
                        HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y - 1, z), HexUtils.META_NOTIFY_UPDATE, world, x - 1, y - 1, z);
                        world.markBlockForUpdate(x - 1, y, z);
                    }
                    else if (rotation == 1 && world.getBlock(x, y, z - 1) instanceof BlockHexoriumDoor && HexUtils.getMetaBit(META_FLIPPED, world, x, y, z - 1)) {
                        HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y - 1, z), HexUtils.META_NOTIFY_UPDATE, world, x, y - 1, z - 1);
                        world.markBlockForUpdate(x, y, z - 1);
                    }
                    else if (rotation == 2 && world.getBlock(x + 1, y, z) instanceof BlockHexoriumDoor && HexUtils.getMetaBit(META_FLIPPED, world, x + 1, y, z)) {
                        HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y - 1, z), HexUtils.META_NOTIFY_UPDATE, world, x + 1, y - 1, z);
                        world.markBlockForUpdate(x + 1, y, z);
                    }
                    else if (rotation == 3 && world.getBlock(x, y, z + 1) instanceof BlockHexoriumDoor && HexUtils.getMetaBit(META_FLIPPED, world, x, y, z + 1)) {
                        HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y - 1, z), HexUtils.META_NOTIFY_UPDATE, world, x, y - 1, z + 1);
                        world.markBlockForUpdate(x, y, z + 1);
                    }
                }
                // Toggle the main door.
                else {
                    if (rotation == 0 && world.getBlock(x + 1, y, z) instanceof BlockHexoriumDoor) {
                        HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y - 1, z), HexUtils.META_NOTIFY_UPDATE, world, x + 1, y - 1, z);
                        world.markBlockForUpdate(x + 1, y, z);
                    }
                    else if (rotation == 1 && world.getBlock(x, y, z + 1) instanceof BlockHexoriumDoor) {
                        HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y - 1, z), HexUtils.META_NOTIFY_UPDATE, world, x, y - 1, z + 1);
                        world.markBlockForUpdate(x, y, z + 1);
                    }
                    else if (rotation == 2 && world.getBlock(x - 1, y, z) instanceof BlockHexoriumDoor) {
                        HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y - 1, z), HexUtils.META_NOTIFY_UPDATE, world, x - 1, y - 1, z);
                        world.markBlockForUpdate(x - 1, y, z);
                    }
                    else if (rotation == 3 && world.getBlock(x, y, z - 1) instanceof BlockHexoriumDoor) {
                        HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y - 1, z), HexUtils.META_NOTIFY_UPDATE, world, x, y - 1, z - 1);
                        world.markBlockForUpdate(x, y, z - 1);
                    }
                }
            }
        }
    }

    /**
     * Returns the bounding box of the wired rectangular prism to render.
     */
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
        this.setBlockBoundsBasedOnState(world, x, y, z);
        return super.getSelectedBoundingBoxFromPool(world, x, y, z);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        this.setBlockBoundsBasedOnState(world, x, y, z);
        return super.getCollisionBoundingBoxFromPool(world, x, y, z);
    }

    /**
     * Updates the blocks bounds based on its current state.
     */
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        // Prepare the variables.
        float dThck = HexModelRendererDoor.dThck;

        int rotation = 0;
        boolean flipped = false;
        boolean state = false;
        if (world.getBlock(x, y - 1, z) == this) {
            rotation = HexUtils.getMetaBitBiInt(META_ROTATION_0, META_ROTATION_1, world, x, y - 1, z);
            state = HexUtils.getMetaBit(META_STATE, world, x, y - 1, z);
            flipped = HexUtils.getMetaBit(META_FLIPPED, world, x, y, z);
        }
        else if (world.getBlock(x, y + 1, z) == this) {
            rotation = HexUtils.getMetaBitBiInt(META_ROTATION_0, META_ROTATION_1, world, x, y, z);
            state = HexUtils.getMetaBit(META_STATE, world, x, y, z);
            flipped = HexUtils.getMetaBit(META_FLIPPED, world, x, y + 1, z);
        }

        // Set block bounds depending on parameters.
        if (flipped) {
            if ((rotation == 0 && !state) || (rotation == 1 && state))
                this.setBlockBounds(0, 0, 0, 1, 1, dThck);
            else if (rotation == 1 || (rotation == 2  && state))
                this.setBlockBounds(1 - dThck, 0, 0, 1, 1, 1);
            else if (rotation == 2 || (rotation == 3  && state))
                this.setBlockBounds(0, 0, 1 - dThck, 1, 1, 1);
            else if (rotation == 3 || rotation == 0)
                this.setBlockBounds(0, 0, 0, dThck, 1, 1);
        }
        else {
            if ((rotation == 0 && !state) || (rotation == 3 && state))
                this.setBlockBounds(0, 0, 0, 1, 1, dThck);
            else if ((rotation == 1 && !state) || rotation == 0)
                this.setBlockBounds(1 - dThck, 0, 0, 1, 1, 1);
            else if ((rotation == 2 && !state) || rotation == 1)
                this.setBlockBounds(0, 0, 1 - dThck, 1, 1, 1);
            else if (rotation == 3 || rotation == 2)
                this.setBlockBounds(0, 0, 0, dThck, 1, 1);
        }
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int a, float b, float c, float d) {
        if (!world.isRemote) {
            if (player.getHeldItem() != null && ((player.getHeldItem().getItem() instanceof ItemHexoriumDye) || (player.getHeldItem().getItem() instanceof ItemMolecularTransposer)))
                return true;

            // Prepare a variable if the door is in a usable state.
            boolean use = false;
            // If player has no item in hand.
            if (player.getCurrentEquippedItem() == null)
                use = true;
                // If player has an item in hand.
            else {
                // Don't use door if Hexorium Reinforcer is present.
                if (player.getCurrentEquippedItem().getItem() == HexItems.itemHexoriumReinforcer) {
                    // If the door is not upgraded, upgrade it.
                    if (!HexUtils.getMetaBit(META_REINFORCED, world, x, y, z)) {
                        HexUtils.setMetaBit(META_REINFORCED, true, HexUtils.META_NOTIFY_UPDATE, world, x, y, z);
                        if (world.getBlock(x, y, z) == world.getBlock(x, y - 1, z))
                            HexUtils.setMetaBit(META_REINFORCED, true, HexUtils.META_NOTIFY_UPDATE, world, x, y - 1, z);
                        else if (world.getBlock(x, y, z) == world.getBlock(x, y + 1, z))
                            HexUtils.setMetaBit(META_REINFORCED, true, HexUtils.META_NOTIFY_UPDATE, world, x, y + 1, z);

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

            // Use door.
            if (use) {
                // Set according block meta and play sound.
                if (world.getBlock(x, y - 1, z) == this) {
                    HexUtils.flipMetaBit(META_STATE, HexUtils.META_NOTIFY_UPDATE, world, x, y - 1, z);
                    world.markBlockForUpdate(x, y, z);
                    world.playAuxSFXAtEntity(null, 1003, x, y - 1, z, 0);

                    int rotation = HexUtils.getMetaBitBiInt(META_ROTATION_0, META_ROTATION_1, world, x, y - 1, z);
                    // Toggle the flipped door.
                    if (!HexUtils.getMetaBit(META_FLIPPED, world, x, y, z)) {
                        if (rotation == 0 && world.getBlock(x - 1, y, z) instanceof BlockHexoriumDoor && HexUtils.getMetaBit(META_FLIPPED, world, x - 1, y, z)) {
                            HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y - 1, z), HexUtils.META_NOTIFY_UPDATE, world, x - 1, y - 1, z);
                            world.markBlockForUpdate(x - 1, y, z);
                        }
                        else if (rotation == 1 && world.getBlock(x, y, z - 1) instanceof BlockHexoriumDoor && HexUtils.getMetaBit(META_FLIPPED, world, x, y, z - 1)) {
                            HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y - 1, z), HexUtils.META_NOTIFY_UPDATE, world, x, y - 1, z - 1);
                            world.markBlockForUpdate(x, y, z - 1);
                        }
                        else if (rotation == 2 && world.getBlock(x + 1, y, z) instanceof BlockHexoriumDoor && HexUtils.getMetaBit(META_FLIPPED, world, x + 1, y, z)) {
                            HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y - 1, z), HexUtils.META_NOTIFY_UPDATE, world, x + 1, y - 1, z);
                            world.markBlockForUpdate(x + 1, y, z);
                        }
                        else if (rotation == 3 && world.getBlock(x, y, z + 1) instanceof BlockHexoriumDoor && HexUtils.getMetaBit(META_FLIPPED, world, x, y, z + 1)) {
                            HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y - 1, z), HexUtils.META_NOTIFY_UPDATE, world, x, y - 1, z + 1);
                            world.markBlockForUpdate(x, y, z + 1);
                        }
                    }
                    // Toggle the main door.
                    else {
                        if (rotation == 0 && world.getBlock(x + 1, y, z) instanceof BlockHexoriumDoor) {
                            HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y - 1, z), HexUtils.META_NOTIFY_UPDATE, world, x + 1, y - 1, z);
                            world.markBlockForUpdate(x + 1, y, z);
                        }
                        else if (rotation == 1 && world.getBlock(x, y, z + 1) instanceof BlockHexoriumDoor) {
                            HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y - 1, z), HexUtils.META_NOTIFY_UPDATE, world, x, y - 1, z + 1);
                            world.markBlockForUpdate(x, y, z + 1);
                        }
                        else if (rotation == 2 && world.getBlock(x - 1, y, z) instanceof BlockHexoriumDoor) {
                            HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y - 1, z), HexUtils.META_NOTIFY_UPDATE, world, x - 1, y - 1, z);
                            world.markBlockForUpdate(x - 1, y, z);
                        }
                        else if (rotation == 3 && world.getBlock(x, y, z - 1) instanceof BlockHexoriumDoor) {
                            HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y - 1, z), HexUtils.META_NOTIFY_UPDATE, world, x, y - 1, z - 1);
                            world.markBlockForUpdate(x, y, z - 1);
                        }
                    }
                }
                else {
                    HexUtils.flipMetaBit(META_STATE, HexUtils.META_NOTIFY_UPDATE, world, x, y, z);
                    world.markBlockForUpdate(x, y + 1, z);
                    world.playAuxSFXAtEntity(null, 1003, x, y, z, 0);

                    int rotation = HexUtils.getMetaBitBiInt(META_ROTATION_0, META_ROTATION_1, world, x, y, z);
                    // Toggle the flipped door.
                    if (!HexUtils.getMetaBit(META_FLIPPED, world, x, y + 1, z)) {
                        if (rotation == 0 && world.getBlock(x - 1, y + 1, z) instanceof BlockHexoriumDoor && HexUtils.getMetaBit(META_FLIPPED, world, x - 1, y + 1, z)) {
                            HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y, z), HexUtils.META_NOTIFY_UPDATE, world, x - 1, y, z);
                            world.markBlockForUpdate(x - 1, y + 1, z);
                        }
                        else if (rotation == 1 && world.getBlock(x, y + 1, z - 1) instanceof BlockHexoriumDoor && HexUtils.getMetaBit(META_FLIPPED, world, x, y + 1, z - 1)) {
                            HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y, z), HexUtils.META_NOTIFY_UPDATE, world, x, y, z - 1);
                            world.markBlockForUpdate(x, y + 1, z - 1);
                        }
                        else if (rotation == 2 && world.getBlock(x + 1, y + 1, z) instanceof BlockHexoriumDoor && HexUtils.getMetaBit(META_FLIPPED, world, x + 1, y + 1, z)) {
                            HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y, z), HexUtils.META_NOTIFY_UPDATE, world, x + 1, y, z);
                            world.markBlockForUpdate(x + 1, y + 1, z);
                        }
                        else if (rotation == 3 && world.getBlock(x, y + 1, z + 1) instanceof BlockHexoriumDoor && HexUtils.getMetaBit(META_FLIPPED, world, x, y + 1, z + 1)) {
                            HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y, z), HexUtils.META_NOTIFY_UPDATE, world, x, y, z + 1);
                            world.markBlockForUpdate(x, y + 1, z + 1);
                        }
                    }
                    else {
                        if (rotation == 0 && world.getBlock(x + 1, y + 1, z) instanceof BlockHexoriumDoor) {
                            HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y, z), HexUtils.META_NOTIFY_UPDATE, world, x + 1, y, z);
                            world.markBlockForUpdate(x + 1, y + 1, z);
                        }
                        else if (rotation == 1 && world.getBlock(x, y + 1, z + 1) instanceof BlockHexoriumDoor) {
                            HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y, z), HexUtils.META_NOTIFY_UPDATE, world, x, y, z + 1);
                            world.markBlockForUpdate(x, y + 1, z + 1);
                        }
                        else if (rotation == 2 && world.getBlock(x - 1, y + 1, z) instanceof BlockHexoriumDoor) {
                            HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y, z), HexUtils.META_NOTIFY_UPDATE, world, x - 1, y, z);
                            world.markBlockForUpdate(x - 1, y + 1, z);
                        }
                        else if (rotation == 3 && world.getBlock(x, y + 1, z - 1) instanceof BlockHexoriumDoor) {
                            HexUtils.setMetaBit(META_STATE, HexUtils.getMetaBit(META_STATE, world, x, y, z), HexUtils.META_NOTIFY_UPDATE, world, x, y, z - 1);
                            world.markBlockForUpdate(x, y + 1, z - 1);
                        }
                    }
                }
            }
        }

        return true;
    }

    /**
     * Called right before the block is destroyed by a player.  Args: world, x, y, z, metaData
     */
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int i) {
        if (world.getBlock(x, y - 1, z) == this)
            world.setBlockToAir(x, y - 1, z);
        else if (world.getBlock(x, y + 1, z) == this)
            world.setBlockToAir(x, y + 1, z);
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
        icon = new IIcon[11];
        // Load the outer textures.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + this.variant.name + "01");
        icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + this.variant.name + "02");
        // Load the flipped outer textures.
        icon[2] = new IconFlipped(icon[0], true, false);
        icon[3] = new IconFlipped(icon[1], true, false);
        icon[4] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + this.variant.name + "03");
        // Load the outer reinforced textures.
        icon[5] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "04");
        icon[6] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "05");
        // Load the flipped outer reinforced textures.
        icon[7] = new IconFlipped(icon[5], true, false);
        icon[8] = new IconFlipped(icon[6], true, false);
        icon[9] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "06");
        // Load the inner texture.
        if(this.color == HexEnums.Colors.RAINBOW)
            icon[10] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glowRainbow");
        else
            icon[10] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glow");
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        // Retrieve icon based on side and meta.
        if (meta == 1)
            return icon[side];
        else
            return icon[0];
    }


    /**
     * Retrieves the icons and sets the connected texture.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
        // Get the meta and determine if door should be flipped.
        int rotation = 0;
        boolean flipped = false;
        boolean state = false;
        if (world.getBlock(x, y - 1, z) == this) {
            rotation = HexUtils.getMetaBitBiInt(META_ROTATION_0, META_ROTATION_1, world, x, y - 1, z);
            state = HexUtils.getMetaBit(META_STATE, world, x, y - 1, z);
            flipped = HexUtils.getMetaBit(META_FLIPPED, world, x, y, z);
        }
        else if (world.getBlock(x, y + 1, z) == this) {
            rotation = HexUtils.getMetaBitBiInt(META_ROTATION_0, META_ROTATION_1, world, x, y, z);
            state = HexUtils.getMetaBit(META_STATE, world, x, y, z);
            flipped = HexUtils.getMetaBit(META_FLIPPED, world, x, y + 1, z);
        }

        // Prepare texture parameters: rei - reinforced, flp - flipped, upp - upper door
        int rei = 0;
        int flp = 0;
        int upp = 0;

        // Calculate different parameters.
        if (HexUtils.getMetaBit(META_REINFORCED, world, x, y, z))
            rei = 5;
        if (flipped && !state)
            flp = 2;
        if (world.getBlock(x, y - 1, z) == this)
            upp = 1;

        // Return icons based on parameters, side and meta.
        if ((rotation == 0 && !state) || (rotation == 1 && state))
            switch (side) {
                case 0:
                    return icon[4 + rei];
                case 1:
                    return icon[4 + rei];
                case 2:
                    return icon[1 + rei + flp - upp];
                case 3:
                    return icon[3 + rei - flp - upp];
                case 4:
                    return icon[4 + rei];
                case 5:
                    return icon[4 + rei];
            }
        else if (rotation == 1 || (rotation == 2 && state))
            switch (side) {
                case 0:
                    return icon[4 + rei];
                case 1:
                    return icon[4 + rei];
                case 2:
                    return icon[4 + rei];
                case 3:
                    return icon[4 + rei];
                case 4:
                    return icon[3 + rei - flp - upp];
                case 5:
                    return icon[1 + rei + flp - upp];
            }
        else if (rotation == 2 || (rotation == 3 && state))
            switch (side) {
                case 0:
                    return icon[4 + rei];
                case 1:
                    return icon[4 + rei];
                case 2:
                    return icon[3 + rei - flp - upp];
                case 3:
                    return icon[1 + rei + flp - upp];
                case 4:
                    return icon[4 + rei];
                case 5:
                    return icon[4 + rei];
            }
        else if (rotation == 3 || rotation == 0)
            switch (side) {
                case 0:
                    return icon[4 + rei];
                case 1:
                    return icon[4 + rei];
                case 2:
                    return icon[4 + rei];
                case 3:
                    return icon[4 + rei];
                case 4:
                    return icon[1 + rei + flp - upp];
                case 5:
                    return icon[3 + rei - flp - upp];
            }
        return icon[0];
    }

    /**
     * Hide the touching sides.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
        // Hide side touching the upper or lower door.
        if (side == 0 && world.getBlock(x, y, z) == this)
            return false;
        else if (side == 1 && world.getBlock(x, y, z) == this)
            return false;
        else
            return true;
    }

    @Override
    public String getID() {
        return ID;
    }

    public static void registerBlocks() {
        for (HexEnums.Variants variant : HexEnums.Variants.values()) {
            for (HexEnums.Colors color : HexEnums.Colors.values()) {
                String name = ID + variant.name + color.name;
                Block block = new BlockHexoriumDoor(name, color, variant);
                GameRegistry.registerBlock(block, name);
            }
        }
    }

    public static void registerRenders() {
        for (HexEnums.Variants variant : HexEnums.Variants.values()) {
            for (HexEnums.Colors color : HexEnums.Colors.values()) {
                renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
                RenderingRegistry.registerBlockHandler(new HexModelRendererDoor(renderID[HexCraft.idCounter],
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

                GameRegistry.addRecipe(new ShapedOreRecipe(block,
                        "II ",
                        "HG ",
                        "II ",
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
