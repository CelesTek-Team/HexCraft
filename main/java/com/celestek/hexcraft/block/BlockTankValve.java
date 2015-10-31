package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.tileentity.TileTankValve;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * @Author CoffeePirate     <celestek@openmailbox.org>
 * @Version 0.1.0
 */
public class BlockTankValve extends HexBlockContainer {
    // Set default block name.
    public static String UNLOCALISEDNAME = "blockTankValve";
    // Prepare the icons.
    @SideOnly(Side.CLIENT) private IIcon icon[];

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

    @Override public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player,
        int metadata, float float1, float float2, float float3) {
        ItemStack playerItem = player.getCurrentEquippedItem();

        TileEntity tileEntity = world.getTileEntity(x,y,z);

        if (playerItem == null) {
            player.openGui(HexCraft.instance, 6, world, x, y, z);
        } else {
            TileTankValve tileTankValve = (TileTankValve) tileEntity;
            tileTankValve.interactedWithTank(player);
            player.getCurrentEquippedItem();
        }

        return true;
    }


    @Override public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor) {
        TileTankValve tileHexoriumValve = (TileTankValve) world.getTileEntity(x, y, z);
        tileHexoriumValve.notifyChange();

        super.onNeighborBlockChange(world, x, y, z, neighbor);
    }

    @Override public TileEntity createTileEntity(World world, int metadata) {
        return new TileTankValve();
    }

    /**
     * Registers the icons.
     */
    @Override @SideOnly(Side.CLIENT) public void registerBlockIcons(IIconRegister iconRegister) {
        // Initialize the icons.
        icon = new IIcon[3];
        // Load the outer textures.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + "blockTankValve");
        icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + "blockTankValve");
        // Load the inner texture
        icon[2] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glow");
    }

    /**
     * Retrieves the icons.
     */
    @Override @SideOnly(Side.CLIENT) public IIcon getIcon(int side, int meta) {
        // Retrieve icon based on side.
        if (side == 0)
            return icon[0];
        else if (side > 0 && side < 6)
            return icon[1];
        else
            return icon[2];
    }
}
