package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-14
 */

public class BlockHexoriumNetherOre extends HexBlock {

    /// Set default block name.
    public static String UNLOCALISEDNAME = "blockHexoriumNetherOre";

    /// Used later for texture identification.
    private String blockName;

    // Used for drop rates.
    private int hexoriumDropMin;
    private int hexoriumDropMax;

    // Used for tool enchants.
    private int fortune = 0;
    private boolean silk = false;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     * @param hexoriumDropMin Minimum amount of Hexorium Crystals dropped.
     * @param hexoriumDropMax Maximum amount of Hexorium Crystals dropped.
     */
    public BlockHexoriumNetherOre(String blockName, int hexoriumDropMin, int hexoriumDropMax) {
        super(Material.rock);

        // Load the constructor parameters.
        this.blockName = blockName;
        this.hexoriumDropMin = hexoriumDropMin;
        this.hexoriumDropMax = hexoriumDropMax;

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.hexCraftTab);
        this.setHardness(3F);
        this.setStepSound(Block.soundTypeStone);
        this.setHarvestLevel("pickaxe", 2);
    }

    /**
     * Checks if the player harvesting the block has Silk Touch enchant and/or Fortune enchant.
     */
    @Override
    public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
        // Check if the player has something in their hand.
        if(player.getCurrentEquippedItem() != null) {
            // Prepare a list of all enchants.
            NBTTagList list = player.getCurrentEquippedItem().getEnchantmentTagList();
            // If the list is not empty...
            if (list != null)
                // Go through all entries.
                for (int i = 0; i < list.tagCount(); i++) {
                    // If Silk Touch (id 33) is found, set it to true.
                    silk = list.getCompoundTagAt(i).getByte("id") == 33;
                    // If Fortune (id 35) is found, set the level value.
                    if (list.getCompoundTagAt(i).getByte("id") == 35)
                        fortune = list.getCompoundTagAt(i).getByte("lvl");
                    else
                        fortune = 0;
                }
        }
    }

    /**
     * Sets quantity of items to drop.
     */
    @Override
    public int quantityDropped(Random random) {
        // Check if Silk Touch should be used. If not...
        if(!silk) {
            // Prepare the fortune extra drop count.
            int fortuneDrop = 0;

            // Set the according fortune extra drop count.
            if (fortune == 1)
                fortuneDrop = 1;
            else if (fortune == 2)
                fortuneDrop = 2;
            else if (fortune == 3)
                fortuneDrop = 3;

            // If max and min drop rates are identical, drop only one value, otherwise, do a random calculation.
            if (hexoriumDropMin == hexoriumDropMax)
                return hexoriumDropMin;
            else
                return fortuneDrop + hexoriumDropMin + random.nextInt(hexoriumDropMax - hexoriumDropMin + 1);
        }
        else
            // Return only 1 block (because of Silk Touch).
            return 1;
    }

    /**
     * Sets up items to drop. Fired the number of times dictated by quantityDropped.
     */
    @Override
    public Item getItemDropped(int metadata, Random random, int fortune) {
        // Check if Silk Touch should be used. If not...
        if(!silk) {
            // Return the according crystal color.
            if (this == HexBlocks.blockHexoriumNetherOreRed)
                return HexItems.itemHexoriumCrystalRed;
            else if (this == HexBlocks.blockHexoriumNetherOreGreen)
                return HexItems.itemHexoriumCrystalGreen;
            else if (this == HexBlocks.blockHexoriumNetherOreBlue)
                return HexItems.itemHexoriumCrystalBlue;
            else if (this == HexBlocks.blockHexoriumNetherOreWhite)
                return HexItems.itemHexoriumCrystalWhite;
            else if (this == HexBlocks.blockHexoriumNetherOreBlack)
                return HexItems.itemHexoriumCrystalBlack;
            else
                return null;
        }
        else
            // Return the block (because of Silk Touch).
            return Item.getItemFromBlock(this);
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
        // Load the outer textures.
        for(int i = 0; i < 6; i++)
            icon[i] = iconRegister.registerIcon(HexCraft.MODID + ":" + blockName + "B");
        // Load the inner texture from normal ore.
        icon[6] = iconRegister.registerIcon(HexCraft.MODID + ":" + blockName.replaceAll("Nether", "") + "A");
    }

    /**
     * Retrieves the icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int i, int meta) {
        // Retrieve icon based on side.
        return icon[i];
    }
}
