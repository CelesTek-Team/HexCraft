package celestek.hexcraft.item;

import celestek.hexcraft.HEXCraft;
import celestek.hexcraft.util.IVariant;
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
public class ItemComponent extends ItemBase {

    public ItemComponent() {
        super("component");
        setHasSubtypes(true);
        setCreativeTab(HEXCraft.tabComponents);
    }

    public enum EnumType implements IVariant {

        // Components T1
        RAINBOW_ENERGIZED_GLOBULE(0, "rainbow_energized_globule"),
        WHITE_HEXORIUM_WAFER     (1, "white_hexorium_wafer"     ),
        BLACK_HEXORIUM_WAFER     (2, "black_hexorium_wafer"     ),
        SPATIAL_PROJECTOR        (3, "spatial_projector"        ),
        ORE_ACTUATOR             (4, "ore_actuator"             ),
        PYLON_SOCKET             (5, "pylon_socket"             ),
        HEXORIUM_GLASS_PACKAGE   (6, "hexorium_glass_package"   ),

        // Components T2
        RAINBOW_CORE             (7,  "rainbow_core"             ),
        HEXORIUM_PROCESSOR       (8,  "hexorium_processor"       ),
        HEXORIUM_COPROCESSOR     (9,  "hexorium_coprocessor"     ),
        MINERAL_ANALYZER         (10, "mineral_analyzer"         ),
        HEXORIUM_ENERGY_CONVERTER(11,  "hexorium_energy_converter"),
        ENERGY_INJECTOR          (12, "energy_injector"          ),
        MOLECULAR_RECODER        (13, "molecular_recoder"        ),
        HEXORIUM_RF_ADAPTER      (14, "hexorium_rf_adapter"      ),

        // Components MP
        MACHINE_CONTROL_PANEL        (15, "machine_control_panel"        ),
        MACHINE_ENERGY_ROUTER        (16, "machine_energy_router"        ),
        HEAT_DISSIPATOR              (17, "heat_dissipator"              ),
        HEATING_ARRAY                (18, "heating_array"                ),
        CRYSTAL_EXTRACTION_UNIT      (19, "crystal_extraction_unit"      ),
        MATRIX_ADJUSTER              (20, "matrix_adjuster"              ),
        MATERIAL_INTERACTION_PLANE   (21, "material_interaction_plane"   ),
        TELEPORTATION_FIELD_PROJECTOR(22, "teleportation_field_projector"),
        DIGITAL_SMARTPIPE            (23, "digital_smartpipe"            );

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
