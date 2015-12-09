package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.init.HexItems;
import com.celestek.hexcraft.tileentity.TileTankValve;
import com.celestek.hexcraft.util.HexUtils;
import com.celestek.hexcraft.util.TankAnalyzer;
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
import net.minecraftforge.fluids.FluidContainerRegistry;

/**
 * @author CoffeePirate     <celestek@openmailbox.org>
 * @version 0.8.1
 */

public class BlockTankValve extends HexBlockContainer {

    // Block ID
    public static final String ID = "blockTankValve";

    // Meta Bits
    public static final int META_ROTATION = 2;

    /**
     * Constructor for the block.
     *
     * @param blockName Unlocalized name for the block.
     */
    public BlockTankValve(String blockName) {
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
        return new TileTankValve();
    }

    /**
     * Called when a block is placed by a player.
     */
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
        // Get the direction of the block.
        int direction = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        // Set the block's meta data according to direction.
        HexUtils.setMetaBit(META_ROTATION, !HexUtils.getBit(0, direction), HexUtils.META_NOTIFY_UPDATE, world, x, y, z);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float float1, float float2, float float3) {
        ItemStack playerItem = player.getCurrentEquippedItem();

        if (playerItem != null) {
            if (!(playerItem.getItem() == HexItems.itemHexoriumManipulator) && !(playerItem.getItem() == HexItems.itemHexoriumProbe)) {
                if (FluidContainerRegistry.isContainer(playerItem)) {
                    TileTankValve tileTankValve = (TileTankValve) world.getTileEntity(x,y,z);
                    if (tileTankValve != null)
                        tileTankValve.playerUseValve(player);
                }
                else
                    player.openGui(HexCraft.instance, 6, world, x, y, z);
            }
        }
        else
            player.openGui(HexCraft.instance, 6, world, x, y, z);

        return true;
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if ((block instanceof HexBlockMT
                || block == HexBlocks.blockTemperedHexoriumGlass
                || block == HexBlocks.blockHexoriumCoatedStone
                || block == HexBlocks.blockTankValve)
                && HexUtils.getMetaBit(HexBlocks.META_STRUCTURE_IS_PART, world, x, y, z)) {

            if (HexConfig.cfgTankDebug)
                System.out.println("[Tank Valve] (" + x + ", " + y + ", " + z + "): Neighbour tank block destroyed, analyzing!");

            /* DO ANALYSIS */
            TankAnalyzer analyzer = new TankAnalyzer();
            analyzer.analyzeTank(world, x, y, z);
        }
    }

    /**
     * Called when the block is broken.
     */
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        TileTankValve tileTankValve = (TileTankValve) world.getTileEntity(x, y, z);
        if (tileTankValve != null)
            tileTankValve.valveDestroyedStructureReset();
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
        icon = new IIcon[5];
        // Load the outer textures.
        for (int i = 0; i < 4; i++)
            icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "0" + (i + 1));
        // Load the inner texture
        icon[4] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glow");
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        // Prepare variables.
        int formed = 0;
        boolean rotation = HexUtils.getBit(META_ROTATION, meta);
        if (HexUtils.getBit(HexBlocks.META_STRUCTURE_IS_PART, meta))
            formed = 1;

        // Retrieve icon based on side.
        switch (side) {
            case 0:
                if (rotation)
                    return icon[3];
                else
                    return icon[2];
            case 1:
                if (rotation)
                    return icon[3];
                else
                    return icon[2];
            case 2:
                if (rotation)
                    return icon[formed];
                else
                    return icon[2];
            case 3:
                if (rotation)
                    return icon[formed];
                else
                    return icon[2];
            case 4:
                if (rotation)
                    return icon[2];
                else
                    return icon[formed];
            case 5:
                if (rotation)
                    return icon[2];
                else
                    return icon[formed];
        }
        return icon[4];
    }
}
