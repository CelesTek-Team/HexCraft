package celestek.hexcraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */
public class ItemVariant extends ItemBase {

    public ItemVariant(String name) {
        super(name);
        setHasSubtypes(true);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
        final List<ItemStack> items = Stream.of(ItemCrystal.EnumType.values())
                .map(enumType -> new ItemStack(itemIn, 1, enumType.getMeta()))
                .collect(Collectors.toList());

        subItems.addAll(items);
    }

}
