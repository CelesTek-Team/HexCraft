package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.renderer.HexModelRendererHatch;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import static net.minecraftforge.common.util.ForgeDirection.*;
import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.WEST;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.6.0
 * @since 2015-04-14
 */

public class BlockHexoriumHatch extends HexBlockModel {

    // Set default block name.
    public static String UNLOCALISEDNAME = "blockHexoriumHatch";

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     */
    public BlockHexoriumHatch(String blockName) {
        super(Material.iron);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.tabDecorative);

        // Assign harvest levels to all metas.
        for (int i = 0; i < 8; i++)
            this.setHarvestLevel("pickaxe", 2, i);

        for (int i = 8; i < 16; i++)
            this.setHarvestLevel("pickaxe", 3, i);

        this.setStepSound(Block.soundTypeMetal);
        this.setLightOpacity(0);
    }

    /**
     * Returns the block hardness at a location. Args: world, x, y, z
     */
    @Override
    public float getBlockHardness(World world, int x, int y, int z) {
        // If this is a normal block, return normal hardness.
        if (world.getBlockMetadata(x, y, z) < 8)
            return 1.5F;
            // If this is a reinforced block, return obsidian hardness.
        else
            return 50F;
    }

    /**
     * Location sensitive version of getExplosionRestance
     */
    @Override
    public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ) {
        // If this is a normal block, return normal resistance.
        if (world.getBlockMetadata(x, y, z) < 8)
            return 30F / 5F;
            // If this is a reinforced block, return obsidian resistance.
        else
            return 6000F / 5F;
    }

    /**
     * Returns if mobs can walk through the block.
     */
    @Override
    public boolean getBlocksMovement(IBlockAccess world, int x, int y, int z) {
        // Check meta and return true if the hatch is open.
        int meta = world.getBlockMetadata(x, y, z);
        if (meta > 7)
            meta = meta - 8;

        return meta > 3;
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
        int orientation = -1;

        // First check if the side it was placed on can accept it. If it can, place it there.
        if (side == 2 && world.isSideSolid(x, y, z + 1, NORTH))
            orientation = 0;
        else if (side == 3 && world.isSideSolid(x, y, z - 1, SOUTH))
            orientation = 2;
        else if (side == 4 && world.isSideSolid(x + 1, y, z, WEST))
            orientation = 3;
        else if (side == 5 && world.isSideSolid(x - 1, y, z, EAST))
            orientation = 1;
        // If the side it was placed on cannot accept it, place it on closest possible other side.
        else {
            if (world.isSideSolid(x, y, z + 1, NORTH))
                orientation = 0;
            else if (world.isSideSolid(x - 1, y, z, EAST))
                orientation = 1;
            else if (world.isSideSolid(x, y, z - 1, SOUTH))
                orientation = 2;
            else if (world.isSideSolid(x + 1, y, z, WEST))
                orientation = 3;
        }
        // Return the new orientation as meta.
        return orientation;
    }

    /**
     * Called when a block near is changed.
     */
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        // Get the meta and normalize it.
        int meta = world.getBlockMetadata(x, y, z);
        if (meta > 7)
            meta = meta - 8;
        int meta1;
        if (meta > 3)
            meta1 = meta - 4;
        else
            meta1 = meta;

        // Check if the attached side is still solid.
        if ((meta1 == 0 && !world.isSideSolid(x, y, z + 1, NORTH)) ||
                (meta1 == 1 && !world.isSideSolid(x - 1, y, z, EAST)) ||
                (meta1 == 2 && !world.isSideSolid(x, y, z - 1, SOUTH)) ||
                (meta1 == 3 && !world.isSideSolid(x + 1, y, z, WEST))) {
            // If it isn't, drop it and set the block to air.
            this.dropBlockAsItem(world, x, y, z, 0, 0);
            world.setBlockToAir(x, y, z);
        }

        // Calculate if the hatch is powered and toggle the hatch state if needed.
        if ((world.isBlockIndirectlyGettingPowered(x, y, z) || block.canProvidePower()) && block != this)
        {
            // Open the hatch.
            if (meta < 4 && world.isBlockIndirectlyGettingPowered(x, y, z)) {
                world.setBlockMetadataWithNotify(x, y, z, meta + 4, 3);
                world.playAuxSFXAtEntity(null, 1003, x, y, z, 0);
            }
            // Close the hatch.
            else if (meta > 3 && !world.isBlockIndirectlyGettingPowered(x, y, z)) {
                world.setBlockMetadataWithNotify(x, y, z, meta - 4, 3);
                world.playAuxSFXAtEntity(null, 1003, x, y, z, 0);
            }
        }
    }

    /**
     * Returns the bounding box of the wired rectangular prism to render.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
    {
        this.setBlockBoundsBasedOnState(world, x, y, z);
        return super.getSelectedBoundingBoxFromPool(world, x, y, z);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        this.setBlockBoundsBasedOnState(world, x, y, z);
        return super.getCollisionBoundingBoxFromPool(world, x, y, z);
    }

    /**
     * Updates the blocks bounds based on its current state.
     */
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
    {
        // Prepare the variables.
        float hThck = HexModelRendererHatch.hThck;

        // Prepare block meta and normalize meta.
        int meta = world.getBlockMetadata(x, y, z);
        if (meta > 7)
            meta = meta - 8;

        // Set block bounds depending on parameters.
        if (meta == 0 || meta == 1 || meta == 2 || meta == 3)
            this.setBlockBounds(0, 0, 0, 1, hThck, 1);
        else if (meta == 4)
            this.setBlockBounds(0, 0, 1 - hThck, 1, 1, 1);
        else if (meta == 5)
            this.setBlockBounds(0, 0, 0, hThck, 1, 1);
        else if (meta == 6)
            this.setBlockBounds(0, 0, 0, 1, 1, hThck);
        else if (meta == 7)
            this.setBlockBounds(1 - hThck, 0, 0, 1, 1, 1);
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
            // Prepare a variable if the hatch is in a usable state.
            boolean use = false;
            // If player has no item in hand.
            if (player.getCurrentEquippedItem() == null)
                use = true;
            // If player has an item in hand.
            else {
                // Don't use hatch if Hexorium Manipulator is present.
                if (player.getCurrentEquippedItem().getItem() == HexItems.itemHexoriumReinforcer) {
                    // If the hatch is not upgraded, upgrade it.
                    if (world.getBlockMetadata(x, y, z) < 8) {
                        world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 8, 3);
                        ItemStack stack = player.getCurrentEquippedItem();
                        stack.stackSize--;
                        if (stack.stackSize == 0)
                            stack = null;
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, stack);
                    } else
                        use = true;
                }
                else
                    use = true;
            }

            // Use hatch.
            if (use) {
                // get block meta.
                int meta = world.getBlockMetadata(x, y, z);

                // Change meta on click.
                if (meta < 8) {
                    if (meta < 4)
                        meta = meta + 4;
                    else
                        meta = meta - 4;
                } else {
                    if (meta < 12)
                        meta = meta + 4;
                    else
                        meta = meta - 4;
                }

                // Set according block meta and play sound.
                world.setBlockMetadataWithNotify(x, y, z, meta, 3);
                world.playAuxSFXAtEntity(null, 1003, x, y, z, 0);
            }

            return true;
        }
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
            if (i < 9)
                icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME + "/" + UNLOCALISEDNAME + "0" + (i+1));
            else
                icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME + "/" + UNLOCALISEDNAME + (i+1));
        }
        // Load the inner texture.
        if(this == HexBlocks.blockHexoriumHatchRainbow)
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
        // Prepare texture parameters: rei - reinforced
        int rei = 0;

        // Calculate different parameters.
        if (meta > 7) {
            rei = 5;
            meta = meta - 8;
        }

        // Return icons based on parameters, side and meta.
        if (side == 6)
            return icon[11];
        else if (side == 7)
            return icon[10];
        else if (meta == 0 || meta == 1 || meta == 2 || meta == 3) {
            if (side < 2)
                return icon[meta + rei];
            else
                return icon[4 + rei];
        }
        else if (meta == 4 || meta == 6) {
            if (side > 1 && side < 4)
                return icon[rei];
            else
                return icon[4 + rei];
        }
        else if (meta == 5 || meta == 7) {
            if (side > 3)
                return icon[rei];
            else
                return icon[4 + rei];
        }
        return icon[0];
    }
}
