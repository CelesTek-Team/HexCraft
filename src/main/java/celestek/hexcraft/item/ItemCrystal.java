package celestek.hexcraft.item;

import celestek.hexcraft.HEXCraft;
import celestek.hexcraft.util.IVariant;
import net.minecraft.block.BlockPlanks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */
public class ItemCrystal extends ItemBase {

    public ItemCrystal() {
        super("crystal");
        setHasSubtypes(true);
        setCreativeTab(HEXCraft.tabMaterials);
    }

    public enum EnumType implements IVariant {

        // Raw Materials
        HEXORIUM_RED  (0, "hexorium_red"),
        HEXORIUM_GREEN(1, "hexorium_green"),
        HEXORIUM_BLUE (2, "hexorium_blue"),
        HEXORIUM_WHITE(3, "hexorium_white"),
        HEXORIUM_BLACK(4, "hexorium_black");

        private static final EnumType[] META_LOOKUP = Stream.of(values()).sorted(Comparator.comparing(EnumType::getMeta)).toArray(EnumType[]::new);

        private final int meta;
        private final String name;

        EnumType(int meta, String name) {
            this.meta = meta;
            this.name = name;
        }

        @Override
        public int getMeta() {
            return meta;
        }

        @Override
        public String getName() {
            return name;
        }

        public static EnumType byMetadata(int meta) {
            if (meta < 0 || meta >= META_LOOKUP.length) {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName(stack) + "." + EnumType.byMetadata(stack.getMetadata()).getName();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
        final List<ItemStack> items = Stream.of(EnumType.values())
                .map(enumType -> new ItemStack(itemIn, 1, enumType.getMeta()))
                .collect(Collectors.toList());

        subItems.addAll(items);
    }
}
