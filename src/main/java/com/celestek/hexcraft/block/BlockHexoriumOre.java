package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.client.renderer.HexBlockRenderer;
import com.celestek.hexcraft.init.HexAchievements;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.init.HexItems;
import com.celestek.hexcraft.util.HexEnums;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
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
import net.minecraftforge.oredict.OreDictionary;

import java.util.Random;

import static com.celestek.hexcraft.client.HexClientProxy.renderID;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class BlockHexoriumOre extends HexBlock implements IHexBlock {

    // Block ID
    public static final String ID = "blockHexoriumOre";

    public enum Colors {
        RED(  "Red",   2, 4, 8),
        GREEN("Green", 2, 4, 8),
        BLUE( "Blue",  2, 4, 8),
        WHITE("White", 1, 2, 6),
        BLACK("Black", 1, 2, 6);

        public final String name;
        public final int min, max, proc;

        Colors(String name, int min, int max, int proc) {
            this.name = name;
            this.min = min;
            this.max = max;
            this.proc = proc;
        }
    }

    // Color
    private final Colors color;

    // Used for tool enchants.
    private int fortune = 0;

    /**
     * Constructor for the block.
     * @param blockName Unlocalized name for the block. Contains color name.
     * @param color The color of the block to use.
     */
    public BlockHexoriumOre(String blockName, Colors color) {
        super(Material.rock);

        // Set all block parameters.
        this.setBlockName(blockName);
        this.color = color;
        this.setCreativeTab(HexCraft.tabComponents);

        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(3F);
        this.setResistance(5F);

        this.setStepSound(Block.soundTypePiston);
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
        this.fortune = 0;
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
        if (this.color.min == this.color.max)
            return this.color.min;
        else
            return this.fortune + this.color.min + random.nextInt(this.color.max - this.color.min + 1);
    }

    /**
     * Sets up items to drop. Fired the number of times dictated by quantityDropped.
     */
    @Override
    public Item getItemDropped(int metadata, Random random, int fortune) {
        return HexItems.getHexItem("itemHexoriumCrystal" + this.color.name);
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
        icon[0] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + this.color.name + "B");
        // Load the inner texture.
        icon[1] = iconRegister.registerIcon(HexCraft.MODID + ":" + ID + this.color.name + "A");
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

    @Override
    public String getID() {
        return ID;
    }

    public static void registerBlocks() {
        for (Colors color : Colors.values()) {
            String name = ID + color.name;
            Block block = new BlockHexoriumOre(name, color);
            GameRegistry.registerBlock(block, name);
        }
    }

    public static void registerRenders() {
        for (Colors color : Colors.values()) {
            renderID[HexCraft.idCounter] = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(new HexBlockRenderer(renderID[HexCraft.idCounter],
                    HexEnums.Brightness.BRIGHT, HexEnums.Colors.GRAY));
        }
    }

    public static void registerOres() {
        for (Colors color : Colors.values()) {
            OreDictionary.registerOre("oreHexorium" + color.name, HexBlocks.getHexBlock(ID + color.name));
        }
    }
}
