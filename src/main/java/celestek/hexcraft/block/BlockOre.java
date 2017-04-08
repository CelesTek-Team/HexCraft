package celestek.hexcraft.block;

import celestek.hexcraft.HEXCraft;
import celestek.hexcraft.util.IVariant;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */
public class BlockOre extends BlockBase {
    public static final IProperty<EnumType> TYPE = PropertyEnum.create("type", EnumType.class);

    public BlockOre(Material materialIn) {
        super(materialIn, "ore");
        setCreativeTab(HEXCraft.tabMaterials);
    }

    public enum EnumType implements IVariant {

        // Hexorium Ore
        HEXORIUM_RED  (0, "hexorium_red"  ),
        HEXORIUM_GREEN(1, "hexorium_green"),
        HEXORIUM_BLUE (2, "hexorium_blue" ),
        HEXORIUM_WHITE(3, "hexorium_white"),
        HEXORIUM_BLACK(4, "hexorium_black");

        private static final EnumType[] META_LOOKUP = Stream.of(values()).sorted(Comparator.comparing(EnumType::getMeta)).toArray(EnumType[]::new);

        private final int meta;
        private final String name;

        EnumType(int meta, String name) {
            this.meta = meta;
            this.name = name;
        }

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
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, TYPE);
    }

    @SuppressWarnings("deprecation")
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(TYPE, EnumType.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(TYPE).getMeta();
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
        for (final EnumType enumType : EnumType.values()) {
            list.add(new ItemStack(this, 1, enumType.getMeta()));
        }
    }

    /**
     * Get the unlocalised name suffix for the specified {@link ItemStack}.
     *
     * @param stack The ItemStack
     * @return The unlocalised name suffix
     */
    public String getName(ItemStack stack) {
        final int metadata = stack.getMetadata();

        return EnumType.byMetadata(metadata).getName();
    }
}