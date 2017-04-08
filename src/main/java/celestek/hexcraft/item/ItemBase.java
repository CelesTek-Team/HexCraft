package celestek.hexcraft.item;

import celestek.hexcraft.HEXCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class ItemBase extends Item {

    public ItemBase(String itemName) {
        setItemName(this, itemName);
    }

    /**
     * Set the registry name of {@code item} to {@code itemName} and the unlocalised name to the full registry name.
     *
     * @param item     The item
     * @param itemName The item's name
     */
    public static void setItemName(Item item, String itemName) {
        item.setRegistryName(HEXCraft.MODID, itemName);
        item.setUnlocalizedName(item.getRegistryName().toString());
    }
}