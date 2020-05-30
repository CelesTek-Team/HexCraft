package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.renderer.HexModelRendererPressurePlate;
import com.celestek.hexcraft.util.HexUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static com.celestek.hexcraft.init.HexBlocks.DECORATIVE_VARIANT_WHITE;
import static net.minecraftforge.common.util.ForgeDirection.*;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class BlockHexoriumPressurePlate extends HexBlockModel {

    // Block ID
    public static final String ID_BLACK = "blockHexoriumPressurePlate";
    public static final String ID_WHITE = "blockHexoriumPressurePlateWhite";

    // Meta Bits
    public static final int META_SETTING_0 = 0;
    public static final int META_SETTING_1 = 1;
    public static final int META_STATE = 2;

    // Used for identifying the decoration variant.
    private int variant;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block.
     * @param variant The decoration variant to use.
     */
    public BlockHexoriumPressurePlate(String blockName, int variant) {
        super(Material.iron);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.variant = variant;
        this.setCreativeTab(HexCraft.tabMachines);

        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(1.5F);
        this.setResistance(10F);

        this.setStepSound(Block.soundTypeMetal);
        this.setLightOpacity(0);
    }

    /**
     * Called when a player tries to place the pressure plate.
     */
    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        return world.isSideSolid(x, y - 1, z, UP);
    }

    /**
     * Returns if mobs can walk through the block.
     */
    @Override
    public boolean getBlocksMovement(IBlockAccess world, int x, int y, int z) {
        return true;
    }

    /**
     * Called when a block near is changed.
     */
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        // If the block below is destroyed, drop it.
        if (!world.isSideSolid(x, y - 1, z, UP)) {
            this.dropBlockAsItem(world, x, y, z, 0, 0);
            world.setBlockToAir(x, y, z);
        }
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        return null;
    }

    /**
     * Updates the blocks bounds based on its current state.
     */
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        // Prepare the variables.
        float pThck = HexModelRendererPressurePlate.pThck;
        float pSide = HexModelRendererPressurePlate.pSide;

        // Set bounds based on meta.
        if (!HexUtils.getMetaBit(META_STATE, world, x, y, z))
            this.setBlockBounds(pSide, 0, pSide, 1 - pSide, pThck, 1 - pSide);
        else
            this.setBlockBounds(pSide, 0, pSide, 1 - pSide, pThck / 2, 1 - pSide);
    }

    /**
     * How many world ticks before ticking.
     */
    @Override
    public int tickRate(World world) {
        // 1 second duration.
        return 20;
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        if (!world.isRemote) {
            // Fetch if the pressure plate is to be activated and if it was in an inactive state.
            if (processState(world, x, y, z) && !HexUtils.getMetaBit(META_STATE, world, x, y, z)) {
                HexUtils.setMetaBit(META_STATE, true, HexUtils.META_NOTIFY_BOTH, world, x, y, z);
                world.notifyBlocksOfNeighborChange(x, y - 1, z, this);

                // Play a sound effect.
                world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "random.click", 0.3F, 0.6F);

                // Schedule an update tick.
                world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
            }
        }
    }

    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
        if (!world.isRemote) {
            // Fetch if the pressure plate is to be deactivated.
            boolean active = processState(world, x, y, z);
            // If it shouldn't be active and if it was in an active state...
            if (!active && HexUtils.getMetaBit(META_STATE, world, x, y, z)) {
                HexUtils.setMetaBit(META_STATE, false, HexUtils.META_NOTIFY_BOTH, world, x, y, z);
                world.notifyBlocksOfNeighborChange(x, y - 1, z, this);

                // Play a sound effect.
                world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "random.click", 0.3F, 0.5F);
            }
            // Otherwise, check again in 1 second.
            else if (active) {
                world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
            }
        }
    }

    /**
     * Checks if the pressure plate should be active.
     */
    private boolean processState(World world, int x, int y, int z) {
        // Prepare variables.
        float pSide = HexModelRendererPressurePlate.pSide;

        // Prepare a list of entities.
        List list = null;

        // Populate the list differently by setting.
        int setting = HexUtils.getMetaBitBiInt(META_SETTING_0, META_SETTING_1, world, x, y, z);
        if (setting == 0)
            // Populate with all entities.
            list = world.getEntitiesWithinAABBExcludingEntity((Entity) null, AxisAlignedBB.getBoundingBox(x + pSide, y, z + pSide, x + 1 - pSide, y + 0.25D, z + 1 - pSide));
        else if (setting == 1)
            // Populate with all entities (extra handling done later).
            list = world.getEntitiesWithinAABBExcludingEntity((Entity) null, AxisAlignedBB.getBoundingBox(x + pSide, y, z + pSide, x + 1 - pSide, y + 0.25D, z + 1 - pSide));
        else if (setting == 2)
            // Populate only with mobs.
            list = world.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB.getBoundingBox(x + pSide, y, z + pSide, x + 1 - pSide, y + 0.25D, z + 1 - pSide));
        else if (setting == 3)
            // Populate only with players.
            list = world.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(x + pSide, y, z + pSide, x + 1 - pSide, y + 0.25D, z + 1 - pSide));

        // Analyze the created list.
        if (list != null && !list.isEmpty()) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                Entity entity = (Entity)iterator.next();
                // If the pressure plate should only detect entities like dropped items, handle it differently.
                if (setting == 1) {
                    if (!(entity instanceof EntityLiving) && !(entity instanceof EntityPlayer) && !entity.doesEntityNotTriggerPressurePlate())
                        return true;
                // Otherwise, continue normally.
                }
                else if (!entity.doesEntityNotTriggerPressurePlate())
                    return true;
            }
        }
        return false;
    }

    /**
     * Called upon breaking the block.
     */
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        // If the pressure plate was active...
        if (HexUtils.getMetaBit(META_STATE, world, x, y, z))
            // Notify blocks around the strongly powered block.
            world.notifyBlocksOfNeighborChange(x, y - 1, z, this);

        super.breakBlock(world, x, y, z, block, meta);
    }

    /**
     * Checks if the block is providing weak power.
     */
    @Override
    public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z, int meta) {
        // Return 15 if pressure plate is on.
        if (HexUtils.getMetaBit(META_STATE, world, x, y, z))
            return 15;
        else
            return 0;
    }

    /**
     * Checks if the block is providing strong power.
     */
    @Override
    public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int side) {
        // Return 15 below if pressure plate is on.
        if (HexUtils.getMetaBit(META_STATE, world, x, y, z))
            if (side == 1)
                return 15;

        return 0;
    }

    /**
     * Can this block provide power.
     */
    @Override
    public boolean canProvidePower() {
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
        icon = new IIcon[2];
        // Map decoration and variant.
        String id = ID_BLACK;
        if (this.variant == DECORATIVE_VARIANT_WHITE)
            id = ID_WHITE;
        // Load the outer texture.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + id);
        // Load the inner texture.
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
}
