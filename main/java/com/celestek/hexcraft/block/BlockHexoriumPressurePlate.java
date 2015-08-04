package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.renderer.HexModelRendererPressurePlate;
import com.celestek.hexcraft.client.renderer.HexModelRendererSwitchButton;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static net.minecraftforge.common.util.ForgeDirection.*;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.6.0
 * @since 2015-04-14
 */

public class BlockHexoriumPressurePlate extends HexBlockModel {

    // Set default block name.
    public static String UNLOCALISEDNAME = "blockHexoriumPressurePlate";

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block.
     */
    public BlockHexoriumPressurePlate(String blockName) {
        super(Material.iron);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.hexCraftTab);

        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(5F);
        this.setResistance(10F);

        this.setStepSound(Block.soundTypeMetal);
        this.setLightOpacity(0);
    }

    /**
     * Called when a player tries to place the button.
     */
    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        // Check if block below is solid, if yes, it means it can be placed.
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
        if (!world.getBlock(x, y - 1, z).isSideSolid(world, x, y, z, UP)) {
            this.dropBlockAsItem(world, x, y, z, 0, 0);
            world.setBlockToAir(x, y, z);
        }
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        return null;
    }

    /**
     * Updates the blocks bounds based on its current state.
     */
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
    {
        // Prepare the variables.
        float pThck = HexModelRendererPressurePlate.pThck;
        float pSide = HexModelRendererPressurePlate.pSide;

        // Prepare block meta.
        int meta = world.getBlockMetadata(x, y, z);

        // Set bounds based on meta.
        if (meta < 4)
            this.setBlockBounds(pSide, 0, pSide, 1 - pSide, pThck, 1 - pSide);
        else
            this.setBlockBounds(pSide, 0, pSide, 1 - pSide, pThck / 2, 1 - pSide);
    }

    /**
     * How many world ticks before ticking.
     */
    @Override
    public int tickRate(World world)
    {
        // 1 second duration.
        return 20;
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        if (!world.isRemote) {
            int meta = world.getBlockMetadata(x, y, z);
            if (processState(world, x, y, z) && meta < 4) {
                world.setBlockMetadataWithNotify(x, y, z, meta + 4, 3);
                // Play a sound effect.
                world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "random.click", 0.3F, 0.6F);
                world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
                // Notify surrounding blocks of the change.
                world.notifyBlocksOfNeighborChange(x, y, z, this);
                world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
            }
        }
    }

    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(World world, int x, int y, int z, Random random)
    {
        if (!world.isRemote) {
            int meta = world.getBlockMetadata(x, y, z);
            boolean active = processState(world, x, y, z);
            if (!active && meta > 3) {
                world.setBlockMetadataWithNotify(x, y, z, meta - 4, 3);
                // Play a sound effect.
                world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "random.click", 0.3F, 0.5F);
                // Notify surrounding blocks of the change.
                world.notifyBlocksOfNeighborChange(x, y, z, this);
                world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
            }
            else if (active) {
                world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
            }
        }
    }

    private boolean processState(World world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);
        if (meta > 3)
            meta = meta - 4;

        float pSide = HexModelRendererPressurePlate.pSide;
        List list = null;
        if (meta == 0)
            list = world.getEntitiesWithinAABBExcludingEntity((Entity) null, AxisAlignedBB.getBoundingBox(x + pSide, y, z + pSide, x + 1 - pSide, y + 0.25D, z + 1 - pSide));
        else if (meta == 1)
            list = world.getEntitiesWithinAABBExcludingEntity((Entity)null, AxisAlignedBB.getBoundingBox(x + pSide, y, z + pSide, x + 1 - pSide, y + 0.25D, z + 1 - pSide));
        else if (meta == 2)
            list = world.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB.getBoundingBox(x + pSide, y, z + pSide, x + 1 - pSide, y + 0.25D, z + 1 - pSide));
        else if (meta == 3)
            list = world.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(x + pSide, y, z + pSide, x + 1 - pSide, y + 0.25D, z + 1 - pSide));

        if (list != null && !list.isEmpty()) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                Entity entity = (Entity)iterator.next();
                if (meta == 1) {
                    if (!(entity instanceof EntityLiving) && !(entity instanceof EntityPlayer))
                        return true;
                } else if (!entity.doesEntityNotTriggerPressurePlate())
                    return true;
            }
        }
        return false;
    }

    /**
     * Called upon breaking the block.
     */
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta)
    {
        // If the button was active...
        if (meta > 3)
        {
            // Notify surrounding blocks of the change.
            world.notifyBlocksOfNeighborChange(x, y, z, this);

            // Notify blocks around the strongly powered block.
            world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
        }

        super.breakBlock(world, x, y, z, block, meta);
    }

    /**
     * Checks if the block is providing weak power.
     */
    @Override
    public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z, int meta)
    {
        // Return 15 if button is on.
        if (world.getBlockMetadata(x, y, z) > 3)
            return 15;
        else
            return 0;
    }

    /**
     * Checks if the block is providing strong power.
     */
    @Override
    public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int side)
    {
        /// Return 15 based on side and if button is on.
        if (world.getBlockMetadata(x, y, z) > 3)
            if (side == 1)
                return 15;

        return 0;
    }

    /**
     * Can this block provide power.
     */
    @Override
    public boolean canProvidePower()
    {
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
        // Load the outer texture.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME);
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
