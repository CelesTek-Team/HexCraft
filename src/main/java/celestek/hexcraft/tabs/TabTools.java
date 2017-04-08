package celestek.hexcraft.tabs;

import celestek.hexcraft.init.ModItems;
import celestek.hexcraft.item.ItemCrystal;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */
public class TabTools extends CreativeTabs {

    public TabTools() {
        super("tabTools");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return ModItems.CRYSTAL;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public int getIconItemDamage() {
        return ItemCrystal.EnumType.HEXORIUM_WHITE.getMeta();
    }
}
