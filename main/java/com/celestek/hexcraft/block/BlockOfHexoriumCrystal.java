package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.Random;

import static net.minecraftforge.common.util.ForgeDirection.*;
import static net.minecraftforge.common.util.ForgeDirection.DOWN;
import static net.minecraftforge.common.util.ForgeDirection.WEST;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.5.1
 * @since 2015-04-14
 */

public class BlockOfHexoriumCrystal extends HexBlock {

    // Set default block name.
    public static String UNLOCALISEDNAME = "blockOfHexoriumCrystal";

    // Used later for texture identification.
    private String blockName;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     */
    public BlockOfHexoriumCrystal(String blockName) {
        super(Material.glass);

        // Load the constructor parameters.
        this.blockName = blockName;

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.hexCraftTab);

        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(5F);
        this.setResistance(10F);

        this.setStepSound(Block.soundTypeGlass);
    }

    /**
     * Called when a block is placed using its ItemBlock.
     */
    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
        return side;
    }

    /// Prepare the icons.
    @SideOnly(Side.CLIENT)
    private IIcon icon[];

    /**
     * Registers the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        // Initialize the icons.
        icon = new IIcon[18];
        // Load the outer texture.
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + "transparent");
        // Load the inner textures.
        for(int i = 1; i < 13; i++)
            if(i < 10)
                icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME + "/" + blockName + "0" + (i));
            else
                icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + UNLOCALISEDNAME + "/" + blockName + (i));
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        // Return the icons based on meta (rotation) and side.
        if (side < 6)
            return icon[0];
        else {
            if (meta == 0) {
                switch (side) {
                    case 6: return icon[1];
                    case 7: return icon[11];
                    case 8: return icon[5];
                    case 9: return icon[5];
                    case 10: return icon[9];
                    case 11: return icon[9];
                }
            } else if (meta == 1) {
                switch (side) {
                    case 6: return icon[11];
                    case 7: return icon[1];
                    case 8: return icon[3];
                    case 9: return icon[3];
                    case 10: return icon[7];
                    case 11: return icon[7];
                }
            } else if (meta == 2) {
                switch (side) {
                    case 6: return icon[7];
                    case 7: return icon[7];
                    case 8: return icon[2];
                    case 9: return icon[12];
                    case 10: return icon[6];
                    case 11: return icon[4];
                }
            } else if (meta == 3) {
                switch (side) {
                    case 6: return icon[9];
                    case 7: return icon[9];
                    case 8: return icon[12];
                    case 9: return icon[2];
                    case 10: return icon[4];
                    case 11: return icon[6];
                }
            } else if (meta == 4) {
                switch (side) {
                    case 6: return icon[10];
                    case 7: return icon[10];
                    case 8: return icon[4];
                    case 9: return icon[6];
                    case 10: return icon[2];
                    case 11: return icon[12];
                }
            } else if (meta == 5) {
                switch (side) {
                    case 6: return icon[8];
                    case 7: return icon[8];
                    case 8: return icon[6];
                    case 9: return icon[4];
                    case 10: return icon[12];
                    case 11: return icon[2];
                }
            }
            return icon[side];
        }
    }
}
