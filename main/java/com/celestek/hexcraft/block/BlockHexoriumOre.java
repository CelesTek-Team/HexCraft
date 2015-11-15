package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.init.HexAchievements;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
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
 * @version 0.7.0
 */

public class BlockHexoriumOre extends HexBlock {

    // Block ID
    public static final String ID = "blockHexoriumOre";

    /// Used later for texture identification.
    private String blockName;

    // Used for drop rates.
    private int hexoriumDropMin;
    private int hexoriumDropMax;

    // Used for tool enchants.
    private int fortune = 0;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     * @param hexoriumDropMin Minimum amount of Hexorium Crystals dropped.
     * @param hexoriumDropMax Maximum amount of Hexorium Crystals dropped.
     */
    public BlockHexoriumOre(String blockName, int hexoriumDropMin, int hexoriumDropMax) {
        super(Material.rock);

        // Load the constructor parameters.
        this.blockName = blockName;
        this.hexoriumDropMin = hexoriumDropMin;
        this.hexoriumDropMax = hexoriumDropMax;

        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.tabComponents);

        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(3F);
        this.setResistance(5F);

        this.setStepSound(Block.soundTypeStone);
    }

    /**
     * Return true if a player with Silk Touch can harvest this block directly, and not its normal drops.
     */
    protected boolean canSilkHarvest() {
        return true;
    }

    /**
     * Checks if the player harvesting the block has Fortune enchant.
     */
    @Override
    public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
        // Reset the fortune and silk touch parameters.
        fortune = 0;
        // Check if the player has something in their hand.
        if(player.getCurrentEquippedItem() != null) {
            NBTTagList list = player.getCurrentEquippedItem().getEnchantmentTagList();

            if (list != null)
                // Go through all entries and if Fortune (id 35) is found, set the level value.
                for (int i = 0; i < list.tagCount(); i++)
                    if (list.getCompoundTagAt(i).getByte("id") == 35)
                        fortune = list.getCompoundTagAt(i).getByte("lvl");
        }
        // Grant player the achievement.
        if (HexConfig.cfgGeneralUseAchievements && !player.capabilities.isCreativeMode && this.canHarvestBlock(player, meta))
            player.addStat(HexAchievements.achMineHexOre, 1);
    }

    /**
     * Sets quantity of items to drop.
     */
    @Override
    public int quantityDropped(Random random) {
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

    /**
     * Sets up items to drop. Fired the number of times dictated by quantityDropped.
     */
    @Override
    public Item getItemDropped(int metadata, Random random, int fortune) {
        // Return the according crystal color.
        if (this == HexBlocks.blockHexoriumOreRed)
            return HexItems.itemHexoriumCrystalRed;
        else if (this == HexBlocks.blockHexoriumOreGreen)
            return HexItems.itemHexoriumCrystalGreen;
        else if (this == HexBlocks.blockHexoriumOreBlue)
            return HexItems.itemHexoriumCrystalBlue;
        else if (this == HexBlocks.blockHexoriumOreWhite)
            return HexItems.itemHexoriumCrystalWhite;
        else if (this == HexBlocks.blockHexoriumOreBlack)
            return HexItems.itemHexoriumCrystalBlack;
        else
            return null;
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
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + blockName + "B");
        // Load the inner texture.
        icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + blockName + "A");
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
