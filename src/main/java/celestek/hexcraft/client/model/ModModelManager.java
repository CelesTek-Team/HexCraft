package celestek.hexcraft.client.model;

import celestek.hexcraft.init.ModItems;
import celestek.hexcraft.item.ItemCrystal;
import celestek.hexcraft.util.IVariant;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */
@Mod.EventBusSubscriber(Side.CLIENT)
public class ModModelManager {
    public static final ModModelManager INSTANCE = new ModModelManager();


    /**
     * Register this mod's {@link Item} models.
     *
     * @param event The event
     */
    @SubscribeEvent
    public static void registerAllModels(ModelRegistryEvent event) {
        INSTANCE.registerItemModels();
    }

    /**
     * The {@link Item}s that have had models registered so far.
     */
    private final Set<Item> itemsRegistered = new HashSet<>();

    /**
     * Register this mod's {@link Item} models.
     */
    private void registerItemModels() {
        registerVariantItemModels(ModItems.CRYSTAL, "variant", ItemCrystal.EnumType.values());
    }

    /**
     * Register a model for each metadata value of an {@link Item} corresponding to the values in {@code values}.
     * <p>
     * Uses the registry name as the domain/path and {@code "[variantName]=[valueName]"} as the variant.
     * <p>
     * Uses {@link IVariant#getMeta()} to determine the metadata of each value.
     *
     * @param item        The Item
     * @param variantName The variant name
     * @param values      The values
     * @param <T>         The value type
     */
    private <T extends IVariant> void registerVariantItemModels(Item item, String variantName, T[] values) {
        for (T value : values) {
            registerItemModelForMeta(item, value.getMeta(), variantName + "=" + value.getName());
        }
    }

    /**
     * Register a model for a metadata value an {@link Item}.
     * <p>
     * Uses the registry name as the domain/path and {@code variant} as the variant.
     *
     * @param item     The Item
     * @param metadata The metadata
     * @param variant  The variant
     */
    private void registerItemModelForMeta(Item item, int metadata, String variant) {
        registerItemModelForMeta(item, metadata, new ModelResourceLocation(item.getRegistryName(), variant));
    }

    /**
     * Register a model for a metadata value of an {@link Item}.
     * <p>
     * Uses {@code modelResourceLocation} as the domain, path and variant.
     *
     * @param item                  The Item
     * @param metadata              The metadata
     * @param modelResourceLocation The full model location
     */
    private void registerItemModelForMeta(Item item, int metadata, ModelResourceLocation modelResourceLocation) {
        itemsRegistered.add(item);
        ModelLoader.setCustomModelResourceLocation(item, metadata, modelResourceLocation);
    }

}
