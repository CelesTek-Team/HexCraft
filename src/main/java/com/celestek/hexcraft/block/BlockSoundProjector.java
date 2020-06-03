package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexGui;
import com.celestek.hexcraft.init.HexItems;
import com.celestek.hexcraft.tileentity.TileSound;
import com.celestek.hexcraft.tileentity.TileSoundProjector;
import com.celestek.hexcraft.util.HexUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class BlockSoundProjector extends HexBlockContainer implements IBlockHexId {

    // Block ID
    public static final String ID = "blockSoundProjector";

    // Meta Bits
    public static final int META_ORIENTATION_0 = 0;
    public static final int META_ORIENTATION_1 = 1;
    public static final int META_ORIENTATION_2 = 2;
    public static final int META_POWERED = 3;

    /**
     * Constructor for the block.
     *
     * @param blockName Unlocalized name for the block.
     */
    public BlockSoundProjector(String blockName) {
        super(Material.iron);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.tabMachines);

        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(5F);
        this.setResistance(10F);

        this.setStepSound(Block.soundTypeMetal);
    }

    /**
     * Returns a new instance of a block's TIle Entity class. Called on placing the block.
     */
    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        // Create the new TIle Entity.
        return new TileSoundProjector();
    }

    /**
     * Called when a block is placed by a player.
     */
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
        // Get the direction of the block.
        int direction;
        if (entity.rotationPitch > 60.0F)
            // If player is looking up.
            direction = 1;
        else if (entity.rotationPitch < -60.0F)
            // If player is looking down.
            direction = 0;
        else {
            direction = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
            // If player is looking towards NSWE.
            if (direction == 0)
                direction = 2;
            else if (direction == 1)
                direction = 5;
            else if (direction == 2)
                direction = 3;
            else if (direction == 3)
                direction = 4;
        }

        // Set the block's meta data according to direction.
        HexUtils.setMetaBitTriInt(META_ORIENTATION_0, META_ORIENTATION_1, META_ORIENTATION_2, direction, 0, world, x, y, z);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float float1, float float2, float float3) {
        // Check if the equipped item is not a Hexorium Manipulator.
        ItemStack itemStack = player.getCurrentEquippedItem();
        if (itemStack != null) {
            if (itemStack.getItem() != HexItems.itemHexoriumManipulator && itemStack.getItem() != HexItems.itemHexoriumProbe)
                player.openGui(HexCraft.instance, HexGui.GUI_ID_SOUND_PROJECTOR, world, x, y, z);
        }
        else
            player.openGui(HexCraft.instance, HexGui.GUI_ID_SOUND_PROJECTOR, world, x, y, z);
        return true;
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if (!world.isRemote) {
            boolean state = HexUtils.getMetaBit(META_POWERED, world, x, y, z);
            boolean powered = world.isBlockIndirectlyGettingPowered(x, y, z);
            // Set meta according to power.
            if ((!state && powered) || (state && !powered)) {
                HexUtils.setMetaBit(META_POWERED, powered, HexUtils.META_NOTIFY_UPDATE, world, x, y, z);
                TileSoundProjector tileSoundProjector = (TileSoundProjector) world.getTileEntity(x, y, z);
                tileSoundProjector.setPowered(powered);
            }
        }
    }

    /**
     * Called when the block is broken.
     */
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        TileSoundProjector tileSoundProjector = (TileSoundProjector) world.getTileEntity(x, y, z);

        if (tileSoundProjector != null) {
            world.func_147453_f(x, y, z, block);
        }
        super.breakBlock(world, x, y, z, block, meta);
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
        icon = new IIcon[7];

        // Load all the different icons.
        for (int i = 0; i < 7; i++)
            icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "0" + (i+1));
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        int orientation = HexUtils.getBitTriInt(META_ORIENTATION_0, META_ORIENTATION_1, META_ORIENTATION_2, meta);
        boolean powered = HexUtils.getBit(META_POWERED, meta);

        if (orientation == 0) {
            switch (side) {
                case 0:
                    if (powered)
                        return icon[5];
                    else
                        return icon[4];
                case 1: return icon[6];
                case 2: return icon[0];
                case 3: return icon[0];
                case 4: return icon[0];
                case 5: return icon[0];
            }
        }
        else if (orientation == 1) {
            switch (side) {
                case 0: return icon[6];
                case 1:
                    if (powered)
                        return icon[5];
                    else
                        return icon[4];
                case 2: return icon[2];
                case 3: return icon[2];
                case 4: return icon[2];
                case 5: return icon[2];
            }
        }
        else if (orientation == 2) {
            switch (side) {
                case 0: return icon[2];
                case 1: return icon[2];
                case 2:
                    if (powered)
                        return icon[5];
                    else
                        return icon[4];
                case 3: return icon[6];
                case 4: return icon[1];
                case 5: return icon[3];
            }
        }
        else if (orientation == 3) {
            switch (side) {
                case 0: return icon[0];
                case 1: return icon[0];
                case 2: return icon[6];
                case 3:
                    if (powered)
                        return icon[5];
                    else
                        return icon[4];
                case 4: return icon[3];
                case 5: return icon[1];
            }
        }
        else if (orientation == 4) {
            switch (side) {
                case 0: return icon[1];
                case 1: return icon[1];
                case 2: return icon[3];
                case 3: return icon[1];
                case 4:
                    if (powered)
                        return icon[5];
                    else
                        return icon[4];
                case 5: return icon[6];
            }
        }
        else if (orientation == 5) {
            switch (side) {
                case 0: return icon[3];
                case 1: return icon[3];
                case 2: return icon[1];
                case 3: return icon[3];
                case 4: return icon[6];
                case 5:
                    if (powered)
                        return icon[5];
                    else
                        return icon[4];
            }
        }
        return icon[side];
    }

    @Override
    public String getID() {
        return ID;
    }
}
