package com.celestek.hexcraft.item;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.BlockHexoriumCoatedStone;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexItems;
import com.celestek.hexcraft.util.HexEnums;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ItemMortarPestle extends Item {

    // Item ID
    public static final String ID = "toolMortarPestle";

    /**
     * Constructor for the item.
     * @param itemName Unlocalized name for the item.
     */
    public ItemMortarPestle(String itemName) {
        setUnlocalizedName(itemName);
        setCreativeTab(HexCraft.tabMachines);
        setMaxStackSize(1);
        setTextureName(HexCraft.MODID + ":" + itemName);
    }

    @Override
    public boolean hasContainerItem(ItemStack itemStack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        return itemStack;
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack) {
        return false;
    }

    public static Item registerItem() {
        Item item = new ItemMortarPestle(ID);
        GameRegistry.registerItem(item, ID);
        return item;
    }

    public static void registerRecipes() {
        Block stone = HexBlocks.getHexBlock(BlockHexoriumCoatedStone.ID, HexEnums.Variants.BLACK);
        GameRegistry.addRecipe(new ShapedOreRecipe(
                HexItems.getHexItem(ID),
                "  W",
                "SDS",
                " S ",
                'S', stone, 'D', "gemDiamond", 'W', "stickWood"));
    }
}
