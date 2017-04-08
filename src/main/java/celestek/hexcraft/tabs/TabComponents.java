package celestek.hexcraft.tabs;

import celestek.hexcraft.init.ModItems;
import celestek.hexcraft.item.ItemComponent;
import celestek.hexcraft.item.ItemCrystal;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */
public class TabComponents extends CreativeTabs {

    public TabComponents() {
        super("tabComponents");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return ModItems.COMPONENT;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getIconItemDamage() {
        return ItemComponent.EnumType.HEXORIUM_GLASS_PACKAGE.getMeta();
    }
}
