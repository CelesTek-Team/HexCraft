package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.init.HexItems;
import com.celestek.hexcraft.item.ItemHexoriumDye;
import com.celestek.hexcraft.util.HexEnums;
import com.celestek.hexcraft.util.HexUtils;
import com.celestek.hexcraft.util.NetworkAnalyzer;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class BlockPylonBase extends Block implements IHexBlock {

    // Block ID
    public static final String ID = "blockPylonBase";

    public enum Types {
        T_5_TO_1("51"),
        T_1_TO_5("15");

        public final String name;

        Types(String name) {
            this.name = name;
        }
    }

    // Meta Bits
    public static final int META_ORIENTATION_0 = 0;
    public static final int META_ORIENTATION_1 = 1;
    public static final int META_ORIENTATION_2 = 2;

    // Used for identifying the type of base.
    private final Types type;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block.
     */
    public BlockPylonBase(String blockName, Types type) {
        super(Material.iron);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.type = type;
        this.setCreativeTab(HexCraft.tabMachines);

        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(5F);
        this.setResistance(10F);

        this.setStepSound(Block.soundTypeMetal);
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

        if(!world.isRemote) {

            if (HexConfig.cfgGeneralNetworkDebug)
                System.out.println("[Pylon Base] (" + x + ", " + y + ", " + z + "): Base placed, analyzing!");

            /* DO ANALYSIS */
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            analyzer.analyzeCable(world, x, y, z, this);
        }
    }

    /**
     * Called when a block near is changed.
     */
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {

        // Check if the changed block belongs to the energy system.
        if (block instanceof BlockHexoriumCable
                || block instanceof BlockPylonBase
                || block == HexBlocks.blockEnergyPylon
                || block instanceof IBlockHexEnergySource
                || block instanceof IBlockHexEnergyDrain
                || block instanceof BlockEnergyNodePortHEX) {

            if (HexConfig.cfgGeneralNetworkDebug)
                System.out.println("[Pylon Base] (" + x + ", " + y + ", " + z + "): Neighbour cable or machine destroyed or changed, analyzing!");

            /* DO ANALYSIS */
            NetworkAnalyzer analyzer = new NetworkAnalyzer();
            analyzer.analyzeCable(world, x, y, z, this);
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
        icon = new IIcon[2];

        // Load all the different icons.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "A");
        icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + "B");
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        int orientation = HexUtils.getBitTriInt(META_ORIENTATION_0, META_ORIENTATION_1, META_ORIENTATION_2, meta);

        // Return only one icon depending on orientation.
        switch (type) {
            case T_5_TO_1:
                if (orientation == side)
                    return icon[1];
                else
                    return icon[0];
            case T_1_TO_5:
                if (orientation == side)
                    return icon[0];
                else
                    return icon[1];
        }

        return icon[0];
    }

    @Override
    public String getID() {
        return ID;
    }

    public static void registerBlocks() {
        for (Types type : Types.values()) {
            String name = ID + type.name;
            Block block = new BlockPylonBase(name, type);
            GameRegistry.registerBlock(block, name);
        }
    }

    public static void registerRecipes() {
        for (Types type : Types.values()) {
            Block block = HexBlocks.getHexBlock(ID + type.name);

            Block cable = HexBlocks.getHexBlock(BlockHexoriumCable.ID, HexEnums.Colors.BLACK);
            Item socket = HexItems.itemPylonSocket;
            Item converter = HexItems.itemHexoriumEnergyConverter;

            switch (type) {
                case T_5_TO_1:
                    GameRegistry.addRecipe(new ShapedOreRecipe(
                            block,
                            "ICI",
                            "COC",
                            "ISI",
                            'C', cable, 'S', socket, 'O', converter, 'I', "ingotIron"));
                    break;
                case T_1_TO_5:
                    GameRegistry.addRecipe(new ShapedOreRecipe(
                            block,
                            "ISI",
                            "SOS",
                            "ICI",
                            'C', cable, 'S', socket, 'O', converter, 'I', "ingotIron"));
                    break;
            }
        }
    }


}
