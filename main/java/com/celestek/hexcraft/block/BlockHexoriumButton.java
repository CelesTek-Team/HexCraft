package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.renderer.HexModelRendererSwitchButton;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

import static net.minecraftforge.common.util.ForgeDirection.*;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.6.2

 */

public class BlockHexoriumButton extends HexBlockModel {

    // Set default block name.
    public static String UNLOCALISEDNAME = "blockHexoriumButton";

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block.
     */
    public BlockHexoriumButton(String blockName) {
        super(Material.iron);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.tabMachines);

        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(1.5F);
        this.setResistance(10F);

        this.setStepSound(Block.soundTypeMetal);
        this.setLightOpacity(0);
    }

    /**
     * Called when a player tries to place the button.
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
            if (world.isSideSolid(x, y - 1, z, UP))
                orientation = 1;
            else if (world.isSideSolid(x, y, z + 1, NORTH))
                orientation = 2;
            else if (world.isSideSolid(x - 1, y, z, EAST))
                orientation = 5;
            else if (world.isSideSolid(x, y, z - 1, SOUTH))
                orientation = 3;
            else if (world.isSideSolid(x + 1, y, z, WEST))
                orientation = 4;
            else if (world.isSideSolid(x, y + 1, z, DOWN))
                orientation = 0;
        }

        // Return the new orientation as meta.
        return orientation;
    }

    /**
     * Called when a block near is changed.
     */
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        // Prepare block meta.
        int meta = world.getBlockMetadata(x, y, z);
        if (meta > 7)
            meta = meta - 8;
        // Compare all neighbouring blocks, and if one of them correspond to the rotation, drop the button.
        if(meta == 0) {
            if (!world.getBlock(x, y + 1, z).isSideSolid(world, x, y, z, DOWN)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(meta == 1) {
            if (!world.getBlock(x, y - 1, z).isSideSolid(world, x, y, z, UP)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(meta == 2) {
            if (!world.getBlock(x, y, z + 1).isSideSolid(world, x, y, z, NORTH)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(meta == 3) {
            if (!world.getBlock(x, y, z - 1).isSideSolid(world, x, y, z, SOUTH)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(meta == 4) {
            if (!world.getBlock(x + 1, y, z).isSideSolid(world, x, y, z, WEST)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(meta == 5) {
            if (!world.getBlock(x - 1, y, z).isSideSolid(world, x, y, z, EAST)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
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
     * Called upon block activation (right click on the block.)
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int a, float b, float c, float d)
    {
        // If this is client side...
        if (world.isRemote)
        {
            // Simply return true.
            return true;
        }
        else
        {
            // Otherwise, get block meta.
            int meta = world.getBlockMetadata(x, y, z);

            // Change meta on click.
            if (meta < 8) {
                world.setBlockMetadataWithNotify(x, y, z, meta + 8, 3);

                // Prepare block for render update.
                world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);

                // Play a sound effect.
                world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "random.click", 0.3F, 0.6F);

                // Notify surrounding blocks of the change.
                world.notifyBlocksOfNeighborChange(x, y, z, this);

                // Notify blocks around the strongly powered block.
                if (meta > 7)
                    meta = meta - 8;
                if (meta == 0) {
                    world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
                } else if (meta == 1) {
                    world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
                } else if (meta == 2) {
                    world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
                } else if (meta == 3) {
                    world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
                } else if (meta == 4) {
                    world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
                } else if (meta == 5) {
                    world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
                }

                // Schedule an update tick.
                world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
            }
            return true;
        }
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
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(World world, int x, int y, int z, Random random)
    {
        if (!world.isRemote)
        {
            int meta = world.getBlockMetadata(x, y, z);

            if (meta > 7)
            {
                world.setBlockMetadataWithNotify(x, y, z, meta - 8, 3);

                // Prepare block for render update.
                world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);

                // Play a sound effect.
                world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "random.click", 0.3F, 0.5F);

                // Notify surrounding blocks of the change.
                world.notifyBlocksOfNeighborChange(x, y, z, this);

                // Notify blocks around the strongly powered block.
                if (meta > 7)
                    meta = meta - 8;
                if (meta == 0) {
                    world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
                } else if (meta == 1) {
                    world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
                } else if (meta == 2) {
                    world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
                } else if (meta == 3) {
                    world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
                } else if (meta == 4) {
                    world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
                } else if (meta == 5) {
                    world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
                }
            }
        }
    }

    /**
     * Called upon breaking the block.
     */
    @Override
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
    @Override
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
    @Override
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
