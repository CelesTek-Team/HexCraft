package celestek.hexcraft.init;

import celestek.hexcraft.HEXCraft;
import celestek.hexcraft.item.ItemComponent;
import celestek.hexcraft.item.ItemCrystal;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.IForgeRegistry;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */
@SuppressWarnings("WeakerAccess")
@GameRegistry.ObjectHolder(HEXCraft.MODID)
public class ModItems {

    @GameRegistry.ObjectHolder("crystal")
    public static final ItemCrystal CRYSTAL     = new ItemCrystal();

    @GameRegistry.ObjectHolder("component")
    public static final ItemComponent COMPONENT = new ItemComponent();

    private ModItems(){}

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        public static final Set<Item> ITEMS = new HashSet<>();

        /**
         * Register this mod's {@link Item}s.
         *
         * @param event The event
         */
        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            final Item[] items = {
                    CRYSTAL,
                    COMPONENT,
            };

            final IForgeRegistry<Item> registry = event.getRegistry();

            for (final Item item : items) {
                registry.register(item);
                ITEMS.add(item);
            }
        }
    }
}
