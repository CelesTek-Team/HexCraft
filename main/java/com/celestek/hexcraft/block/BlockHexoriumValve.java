package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.tileentity.TileHexoriumValve;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * @Author CoffeePirate     <celestek@openmailbox.org>
 * @Version 0.1.0
 */
public class BlockHexoriumValve extends HexBlockContainer {
    // Set default block name.
    public static String UNLOCALISEDNAME = "blockHexoriumValve";
    // Prepare the icons.
    @SideOnly(Side.CLIENT) private IIcon icon[];

    /**
     * Constructor for the block.
     *
     * @param blockName Unlocalized name for the block.
     */
    public BlockHexoriumValve(String blockName) {
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

        TileEntity tileEntity = world.getTileEntity(x,y,z);

        if (tileEntity != null) {
            TileHexoriumValve tileHexoriumValve = (TileHexoriumValve) tileEntity;
            tileHexoriumValve.interactedWithTank(player);
            player.getCurrentEquippedItem();

            if (player.isSneaking()) {
                System.out.println(tileHexoriumValve.getTankStatus());
            }
        }

        return super.onBlockActivated(world, x, y, z, player, metadata, float1, float2, float3);
    }


    @Override public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor) {
        TileHexoriumValve tileHexoriumValve = (TileHexoriumValve) world.getTileEntity(x, y, z);
        tileHexoriumValve.notifyChange();

        super.onNeighborBlockChange(world, x, y, z, neighbor);
    }

    @Override public TileEntity createTileEntity(World world, int metadata) {
        return new TileHexoriumValve();
    }

    /**
     * Registers the icons.
     */
    @Override @SideOnly(Side.CLIENT) public void registerBlockIcons(IIconRegister iconRegister) {
        // Initialize the icons.
        icon = new IIcon[3];
        // Load the outer textures.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + "blockHexoriumValve");
        icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + "blockHexoriumValve");
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
