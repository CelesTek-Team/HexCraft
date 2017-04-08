package celestek.hexcraft.client.model;

import celestek.hexcraft.block.BlockOre;
import celestek.hexcraft.init.ModBlocks;
import celestek.hexcraft.init.ModItems;
import celestek.hexcraft.item.ItemComponent;
import celestek.hexcraft.item.ItemCrystal;
import celestek.hexcraft.util.IVariant;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.HashSet;
import java.util.Set;
import java.util.function.ToIntFunction;

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
        INSTANCE.registerBlockModels();
        INSTANCE.registerItemModels();
    }

    /**
     * Register this mod's models.
     */
    private void registerBlockModels() {

        registerVariantBlockItemModels(
                ModBlocks.ORE.getDefaultState(),
                BlockOre.TYPE
        );

        ModBlocks.RegistrationHandler.ITEM_BLOCKS.stream().filter(item -> !itemsRegistered.contains(item)).forEach(this::registerItemModel);
    }

    /**
     * Register a single model for an {@link Item}.
     * <p>
     * Uses the registry name as the domain/path and {@code "inventory"} as the variant.
     *
     * @param item The Item
     */
    private void registerItemModel(Item item) {
        registerItemModel(item, item.getRegistryName().toString());
    }


    /**
     * Register a single model for an {@link Item}.
     * <p>
     * Uses {@code modelLocation} as the domain/path and {@link "inventory"} as the variant.
     *
     * @param item          The Item
     * @param modelLocation The model location
     */
    private void registerItemModel(Item item, String modelLocation) {
        final ModelResourceLocation fullModelLocation = new ModelResourceLocation(modelLocation, "inventory");
        registerItemModel(item, fullModelLocation);
    }


    /**
     * Register a single model for an {@link Item}.
     * <p>
     * Uses {@code fullModelLocation} as the domain, path and variant.
     *
     * @param item              The Item
     * @param fullModelLocation The full model location
     */
    private void registerItemModel(Item item, ModelResourceLocation fullModelLocation) {
        ModelBakery.registerItemVariants(item, fullModelLocation); // Ensure the custom model is loaded and prevent the default model from being loaded
        registerItemModel(item, MeshDefinitionFix.create(stack -> fullModelLocation));
    }

    /**
     * Register an {@link ItemMeshDefinition} for an {@link Item}.
     *
     * @param item           The Item
     * @param meshDefinition The ItemMeshDefinition
     */
    private void registerItemModel(Item item, ItemMeshDefinition meshDefinition) {
        itemsRegistered.add(item);
        ModelLoader.setCustomMeshDefinition(item, meshDefinition);
    }

    /**
     * A {@link StateMapperBase} used to create property strings.
     */
    private final StateMapperBase propertyStringMapper = new StateMapperBase() {
        @Override
        protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
            return new ModelResourceLocation("minecraft:air");
        }
    };

    /**
     * Register a model for a metadata value of the {@link Item}.
     * <p>
     * Uses the registry name as the domain/path and the {@link IBlockState} as the variant.
     *
     * @param state    The state to use as the variant
     * @param metadata The item metadata to register the model for
     */
    private void registerBlockItemModelForMeta(IBlockState state, int metadata) {
        final Item item = Item.getItemFromBlock(state.getBlock());

        if (item != null) {
            registerItemModelForMeta(item, metadata, propertyStringMapper.getPropertyString(state.getProperties()));
        }
    }


    /**
     * Register a model for each metadata value of the {@link Item} corresponding to the values of an {@link IProperty}.
     * <p>
     * For each value:
     * <li>The domain/path is the registry name</li>
     * <li>The variant is {@code baseState} with the {@link IProperty} set to the value</li>
     * <p>
     * The {@code getMeta} function is used to get the metadata of each value.
     *
     * @param baseState The base state to use for the variant
     * @param property  The property whose values should be used
     * @param getMeta   A function to get the metadata of each value
     * @param <T>       The value type
     */
    private <T extends Comparable<T>> void registerVariantBlockItemModels(IBlockState baseState, IProperty<T> property, ToIntFunction<T> getMeta) {
        property.getAllowedValues().forEach(value -> registerBlockItemModelForMeta(baseState.withProperty(property, value), getMeta.applyAsInt(value)));
    }

    /**
     * Register a model for each metadata value of the {@link Item} corresponding to the values of an {@link IProperty}.
     * <p>
     * For each value:
     * <li>The domain/path is the registry name</li>
     * <li>The variant is {@code baseState} with the {@link IProperty} set to the value</li>
     * <p>
     * {@link IVariant#getMeta()} is used to get the metadata of each value.
     *
     * @param baseState The base state to use for the variant
     * @param property  The property whose values should be used
     * @param <T>       The value type
     */
    private <T extends IVariant & Comparable<T>> void registerVariantBlockItemModels(IBlockState baseState, IProperty<T> property) {
        registerVariantBlockItemModels(baseState, property, IVariant::getMeta);
    }

    /**
     * The {@link Item}s that have had models registered so far.
     */
    private final Set<Item> itemsRegistered = new HashSet<>();

    /**
     * Register this mod's {@link Item} models.
     */
    private void registerItemModels() {
        registerVariantItemModels(ModItems.CRYSTAL,   "type", ItemCrystal.EnumType.values());
        registerVariantItemModels(ModItems.COMPONENT, "type", ItemComponent.EnumType.values());
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
