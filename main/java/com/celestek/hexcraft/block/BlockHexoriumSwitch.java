package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.renderer.HexModelRendererMonolith;
import com.celestek.hexcraft.client.renderer.HexModelRendererSwitch;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;

import static net.minecraftforge.common.util.ForgeDirection.*;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.5.1
 * @since 2015-04-14
 */

public class BlockHexoriumSwitch extends HexBlockModel {

    // Set default block name.
    public static String UNLOCALISEDNAME = "blockHexoriumSwitch";

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block.
     */
    public BlockHexoriumSwitch(String blockName) {
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
     * Called when a block is placed by a player.
     */
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
        // Get the direction of the block.
        int direction;
        int meta = world.getBlockMetadata(x, y, z);
        if (meta == 0 || meta == 1) {
            direction = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
            // If player is looking towards NSWE.
            if (direction == 0 || direction == 2)
                direction = meta;
            else if (direction == 1 || direction == 3) {
                if (meta == 0)
                    direction = 6;
                else
                    direction = 7;
            }
        }
        else
            direction = meta;

        // Set the block's meta data according to direction.
        world.setBlockMetadataWithNotify(x, y, z, direction, 2);
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
        // Compare all neighbouring blocks, and if one of them correspond to the rotation, drop the switch.
        if(meta == 0 || meta == 6) {
            if (!world.getBlock(x, y + 1, z).isSideSolid(world, x, y, z, DOWN)) {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
        else if(meta == 1 || meta == 7) {
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
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        return null;
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
    {
        float switchBack = HexModelRendererSwitch.switchBack;
        float switchFron = HexModelRendererSwitch.switchFron;
        float switchHori = HexModelRendererSwitch.switchHori;
        float switchVert = HexModelRendererSwitch.switchVert;

        int meta = world.getBlockMetadata(x, y, z);
        if (meta > 7)
            meta = meta - 8;

        if (meta == 1)
            this.setBlockBounds(switchHori, switchBack, switchVert, 1 - switchHori, switchFron, 1 - switchVert);
        else if (meta == 7)
            this.setBlockBounds(switchVert, switchBack, switchHori, 1 - switchVert, switchFron, 1 - switchHori);
        else if (meta == 2)
            this.setBlockBounds(switchHori, switchVert, 1 - switchFron, 1 - switchHori, 1 - switchVert, 1 - switchBack);
        else if (meta == 3)
            this.setBlockBounds(switchHori, switchVert, switchBack, 1 - switchHori, 1 - switchVert, switchFron);
        else if (meta == 4)
            this.setBlockBounds(1 - switchFron, switchVert, switchHori, 1 - switchBack, 1 - switchVert, 1 - switchHori);
        else if (meta == 5)
            this.setBlockBounds(switchBack, switchVert, switchHori, switchFron, 1 - switchVert, 1 - switchHori);
        else if (meta == 6)
            this.setBlockBounds(switchVert, 1 - switchFron, switchHori, 1 - switchVert, 1 - switchBack, 1 - switchHori);
        else
            this.setBlockBounds(switchHori, 1 - switchFron, switchVert, 1 - switchHori, 1 - switchBack, 1 - switchVert);
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int a, float b, float c, float d)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            int meta = world.getBlockMetadata(x, y, z);

            int meta1;
            if (meta > 7)
                meta1 = meta - 8;
            else
                meta1 = meta;

            if (meta > 7)
                world.setBlockMetadataWithNotify(x, y, z, meta - 8, 3);
            else
                world.setBlockMetadataWithNotify(x, y, z, meta + 8, 3);

            world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "random.click", 0.3F, meta > 7 ? 0.5F : 0.6F);
            world.notifyBlocksOfNeighborChange(x, y, z, this);

            if(meta1 == 0 || meta1 == 6) {
                world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
            }
            else if(meta1 == 1 || meta1 == 7) {
                world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
            }
            else if(meta1 == 2) {
                world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
            }
            else if(meta1 == 3) {
                world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
            }
            else if(meta1 == 4) {
                world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
            }
            else if(meta1 == 5) {
                world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
            }

            return true;
        }
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int meta)
    {
        if (meta > 7)
        {
            world.notifyBlocksOfNeighborChange(x, y, z, this);
            meta = meta - 8;

            if(meta == 0 || meta == 6) {
                world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
            }
            else if(meta == 1 || meta == 7) {
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

    public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z, int meta)
    {
        if (world.getBlockMetadata(x, y, z) > 7)
            return 15;
        else
            return 0;
    }

    public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int side)
    {
        int meta = world.getBlockMetadata(x, y, z);

        if (meta > 7)
        {
            meta = meta - 8;
            if (meta == 0 && side == 0)
                return 15;
            else if (meta == 6 && side == 0)
                return 15;
            else if (meta == 1 && side == 1)
                return 15;
            else if (meta == 7 && side == 1)
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
     * Can this block provide power. Only wire currently seems to have this change based on its state.
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
