package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.init.HexGui;
import com.celestek.hexcraft.init.HexItems;
import com.celestek.hexcraft.tileentity.TileQuantumObserver;
import com.celestek.hexcraft.util.HexUtils;
import com.celestek.hexcraft.util.NetworkAnalyzer;
import com.celestek.hexcraft.util.ObserverAnalyzer;
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
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class BlockQuantumObserver extends HexBlockContainer implements IHexBlock, IBlockHexEnergyDrain {

    // Block ID
    public static final String ID = "blockQuantumObserver";

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block.
     */
    public BlockQuantumObserver(String blockName) {
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
    public TileEntity createNewTileEntity(World world, int par2) {
        return new TileQuantumObserver();
    }

    /**
     * Called when a block is placed by a player.
     */
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
        int meta = HexUtils.setBitBiInt(HexBlocks.META_MACHINE_STATUS_0, HexBlocks.META_MACHINE_STATUS_1, HexBlocks.MACHINE_STATE_DEAD, 0);
        world.setBlockMetadataWithNotify(x, y, z, meta, HexUtils.META_NOTIFY_UPDATE);

        // Check if the code is executed on the server.
        if(!world.isRemote) {
            if (HexConfig.cfgGeneralNetworkDebug)
                System.out.println("[Quantum Observer] (" + x + ", " + y + ", " + z + "): Quantum Observer placed, analyzing!");

            /* DO ANALYSIS, BASED ON ORIENTATION */
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            analyzer.analyzeMachines(world, x, y, z, 0);

            if (HexConfig.cfgObserverDebug)
                System.out.println("[Quantum Observer] (" + x + ", " + y + ", " + z + "): Anchor analysis started!");

            ObserverAnalyzer observerAnalyzer = new ObserverAnalyzer();
            observerAnalyzer.analyzeObserver(world, x, y - 1, z);
        }
    }

    /**
     * Fired when a player right clicks on the machine.
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        // Check if the equipped item is not a Hexorium Manipulator.
        ItemStack itemStack = player.getCurrentEquippedItem();
        if (itemStack != null) {
            if (itemStack.getItem() != HexItems.itemHexoriumManipulator && itemStack.getItem() != HexItems.itemHexoriumProbe)
                // Open the GUI.
                player.openGui(HexCraft.instance, HexGui.GUI_ID_QUANTUM_OBSERVER, world, x, y, z);
        }
        else
            // Open the GUI.
            player.openGui(HexCraft.instance, HexGui.GUI_ID_QUANTUM_OBSERVER, world, x, y, z);
        return true;
    }

    /**
     * Called when a block near is changed.
     */
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {

        // Check if the changed block is a cable.
        if (block instanceof BlockHexoriumCable
                || block instanceof BlockPylonBase
                || block instanceof BlockEnergyNodePortHEX) {
            if (HexConfig.cfgGeneralNetworkDebug)
                System.out.println("[Quantum Observer] (" + x + ", " + y + ", " + z + "): Neighbour block changed, analyzing!");

            /* DO ANALYSIS, BASED ON ORIENTATION */
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            analyzer.analyzeMachines(world, x, y, z, 0);
        }
        else if (block == HexBlocks.blockQuantumAnchor) {
            if (HexConfig.cfgObserverDebug)
                System.out.println("[Quantum Observer] (" + x + ", " + y + ", " + z + "): Neighbour anchor changed, analyzing!");

            ObserverAnalyzer observerAnalyzer = new ObserverAnalyzer();
            observerAnalyzer.analyzeObserver(world, x, y - 1, z);
        }
    }

    /**
     * Called when the block is broken.
     */
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        TileQuantumObserver tileQuantumObserver = (TileQuantumObserver) world.getTileEntity(x, y, z);

        if (tileQuantumObserver != null) {
            tileQuantumObserver.stopChunkLoading();
            world.func_147453_f(x, y, z, block);
        }
        super.breakBlock(world, x, y, z, block, meta);
    }

    /**
     * Gets the light value according to meta.
     */
    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        // If the machine is active, make it emit light.
        if (HexUtils.getMetaBitBiInt(HexBlocks.META_MACHINE_STATUS_0,
                HexBlocks.META_MACHINE_STATUS_1, world, x, y, z) == HexBlocks.MACHINE_STATE_ACTIVE)
            return 12;
        else
            return 0;
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
        icon = new IIcon[6];
        // Load the outer textures.
        for (int i = 0; i < 5; i++)
            icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "/" + ID + "0" + (i + 1));
        // Load the inner texture
        icon[5] = iconRegister.registerIcon(HexCraft.MODID + ":" + "glow");
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        int state1 = 0;
        if(HexUtils.getBitBiInt(HexBlocks.META_MACHINE_STATUS_0, HexBlocks.META_MACHINE_STATUS_1, meta) == HexBlocks.MACHINE_STATE_DEAD)
            state1 = 1;
        int state2 = 2;
        if(HexUtils.getBitBiInt(HexBlocks.META_MACHINE_STATUS_0, HexBlocks.META_MACHINE_STATUS_1, meta) == HexBlocks.MACHINE_STATE_ACTIVE)
            state2 = 3;

        switch (side) {
            case 0: return icon[4];
            case 1: return icon[state1];
            case 2: return icon[state2];
            case 3: return icon[state2];
            case 4: return icon[state2];
            case 5: return icon[state2];
            case 6: return icon[5];
        }
        return icon[side];
    }

    @Override
    public String getID() {
        return ID;
    }
}
