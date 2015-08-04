package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
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
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        return null;
    }

    /**
     * Updates the blocks bounds based on its current state.
     */
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
    {
        // Prepare the variables.
        float sbBack = HexModelRendererSwitchButton.sbBack;
        float sbFron = HexModelRendererSwitchButton.sbFron;
        float sbHori = HexModelRendererSwitchButton.sbHori;
        float sbVert = HexModelRendererSwitchButton.sbVert;
        float sbPixl = HexModelRendererSwitchButton.sbPixl;
        float push;

        // Prepare block meta.
        int meta = world.getBlockMetadata(x, y, z);
        if (meta > 7) {
            push = sbPixl;
            meta = meta - 8;
        }
        else
            push = sbFron;

        // Set bounds based on meta.
        if (meta == 1)
            this.setBlockBounds(sbHori, sbBack, sbVert, 1 - sbHori, push, 1 - sbVert);
        else if (meta == 7)
            this.setBlockBounds(sbVert, sbBack, sbHori, 1 - sbVert, push, 1 - sbHori);
        else if (meta == 2)
            this.setBlockBounds(sbHori, sbVert, 1 - push, 1 - sbHori, 1 - sbVert, 1 - sbBack);
        else if (meta == 3)
            this.setBlockBounds(sbHori, sbVert, sbBack, 1 - sbHori, 1 - sbVert, push);
        else if (meta == 4)
            this.setBlockBounds(1 - push, sbVert, sbHori, 1 - sbBack, 1 - sbVert, 1 - sbHori);
        else if (meta == 5)
            this.setBlockBounds(sbBack, sbVert, sbHori, push, 1 - sbVert, 1 - sbHori);
        else if (meta == 6)
            this.setBlockBounds(sbVert, 1 - push, sbHori, 1 - sbVert, 1 - sbBack, 1 - sbHori);
        else
            this.setBlockBounds(sbHori, 1 - push, sbVert, 1 - sbHori, 1 - sbBack, 1 - sbVert);
    }

    /**
     * How many world ticks before ticking.
     */
    public int tickRate(World world)
    {
        // 1 second duration.
        return 20;
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        if (!world.isRemote) {
            int meta = world.getBlockMetadata(x, y, z);
            if (processState(world, x, y, z) && meta < 4) {
                world.setBlockMetadataWithNotify(x, y, z, meta + 4, 3);
                // Play a sound effect.
                world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "random.click", 0.3F, 0.6F);
                world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
            }
        }
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World world, int x, int y, int z, Random random)
    {
        if (!world.isRemote) {
            int meta = world.getBlockMetadata(x, y, z);
            boolean active = processState(world, x, y, z);
            if (!active && meta > 3) {
                world.setBlockMetadataWithNotify(x, y, z, meta - 4, 3);
                // Play a sound effect.
                world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "random.click", 0.3F, 0.5F);
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

        float f = 0.125F;
        List list = null;
        if (meta == 0)
            list = world.getEntitiesWithinAABBExcludingEntity((Entity) null, AxisAlignedBB.getBoundingBox(x + f, y, z + f, x + 1 - f, y + 0.25D, z + 1 - f));
        else if (meta == 1)
            list = world.getEntitiesWithinAABBExcludingEntity((Entity)null, AxisAlignedBB.getBoundingBox(x + f, y, z + f, x + 1 - f, y + 0.25D, z + 1 - f));
        else if (meta == 2)
            list = world.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB.getBoundingBox(x + f, y, z + f, x + 1 - f, y + 0.25D, z + 1 - f));
        else if (meta == 3)
            list = world.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(x + f, y, z + f, x + 1 - f, y + 0.25D, z + 1 - f));

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
    public void breakBlock(World world, int x, int y, int z, Block block, int meta)
    {
        // If the button was active...
        if (meta > 7)
        {
            // Notify surrounding blocks of the change.
            world.notifyBlocksOfNeighborChange(x, y, z, this);

            // Notify blocks around the strongly powered block.
            meta = meta - 8;
            if(meta == 0) {
                world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
            }
            else if(meta == 1) {
                world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
            }
            else if(meta == 2) {
                world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
            }
            else if(meta == 3) {
                world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
            }
            else if(meta == 4) {
                world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
            }
            else if(meta == 5) {
                world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
            }
        }

        super.breakBlock(world, x, y, z, block, meta);
    }

    /**
     * Checks if the block is providing weak power.
     */
    public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z, int meta)
    {
        // Return 15 if button is on.
        if (world.getBlockMetadata(x, y, z) > 7)
            return 15;
        else
            return 0;
    }

    /**
     * Checks if the block is providing strong power.
     */
    public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int side)
    {
        // Prepare block meta.
        int meta = world.getBlockMetadata(x, y, z);

        /// Return 15 based on side and if button is on.
        if (meta > 7)
        {
            meta = meta - 8;
            if (meta == 0 && side == 0)
                return 15;
            else if (meta == 1 && side == 1)
                return 15;
            else if (meta == 2 && side == 2)
                return 15;
            else if (meta == 3 && side == 3)
                return 15;
            else if (meta == 4 && side == 4)
                return 15;
            else if (meta == 5 && side == 5)
                return 15;
            else
                return 0;
        }
        else
            return 0;
    }

    /**
     * Can this block provide power.
     */
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
