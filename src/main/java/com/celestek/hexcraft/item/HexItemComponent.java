package com.celestek.hexcraft.item;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.BlockHexoriumCable;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.init.HexItems;
import com.celestek.hexcraft.util.HexEnums;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class HexItemComponent extends Item {

    /**
     * Constructor for the item.
     * @param itemName Unlocalized name for the item.
     */
    public HexItemComponent(String itemName) {
        setUnlocalizedName(itemName);
        setCreativeTab(HexCraft.tabComponents);
        setMaxStackSize(64);
        setTextureName(HexCraft.MODID + ":" + itemName);
    }

    public static Item registerItem(String name, boolean enabled) {
        if (enabled)
            return registerItem(name);
        else
            return null;
    }

    public static Item registerItem(String name) {
        Item item = new HexItemComponent(name);
        GameRegistry.registerItem(item, name);
        return item;
    }

    public static void registerRecipes() {
        String dr = "dustRedstone";
        String ni = "nuggetIron";
        String ii = "ingotIron";
        String gRed = "gemHexoriumRed";
        String gGrn = "gemHexoriumGreen";
        String gBlu = "gemHexoriumBlue";
        String gWht = "gemHexoriumWhite";
        String gBlk = "gemHexoriumBlack";

        String glass = "blockGlassColorless";
        if (OreDictionary.doesOreNameExist("glass"))
            glass = "glass";

        /* Components T1 */

        // Iron Ingot
        GameRegistry.addRecipe(new ShapelessOreRecipe(
                Items.iron_ingot,
                ni, ni, ni, ni, ni, ni, ni, ni, ni));

        // Iron Nugget
        GameRegistry.addRecipe(new ShapelessOreRecipe(
                new ItemStack(HexItems.itemIronNugget, 9),
                ii));

        // Rainbow Energized Globule
        GameRegistry.addRecipe(new ShapelessOreRecipe(
                HexItems.itemRainbowEnergizedGlobule,
                gRed, gGrn, gBlu, gWht, dr));

        // Spatial Projector
        GameRegistry.addRecipe(new ShapedOreRecipe(
                HexItems.itemSpatialProjector,
                "IGI",
                " I ",
                " R ",
                'R', dr, 'G', gBlk, 'I', ni));

        // Ore Actuator
        if (HexConfig.cfgSeparatorEnable)
            GameRegistry.addRecipe(new ShapedOreRecipe(
                    HexItems.itemOreActuator,
                    "I  ",
                    "PIR",
                    "I  ",
                    'R', dr, 'P', Items.iron_pickaxe, 'I', ni));

        // Pylon Socket
        GameRegistry.addRecipe(new ShapedOreRecipe(
                HexItems.itemPylonSocket,
                "ICI",
                "RRR",
                'R', dr, 'C', HexBlocks.getHexBlock(BlockHexoriumCable.ID, HexEnums.Colors.RAINBOW), 'I', ni));

        // Hexorium-Glass Package
        GameRegistry.addRecipe(new ShapedOreRecipe(
                HexItems.itemHexoriumGlassPackage,
                "ILI",
                "LGL",
                "ILI",
                'G', "gemHexorium", 'I', ni, 'L', glass));
    }
}
