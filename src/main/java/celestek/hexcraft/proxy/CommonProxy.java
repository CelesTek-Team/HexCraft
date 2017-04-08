package celestek.hexcraft.proxy;

import celestek.hexcraft.init.ModItems;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
        // Initialization of blocks and items typically goes here:
        //ModBlocks.init();
        //ModItems.init();
        //ModCrafting.init();
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }

    public void registerItemRenderer(Item item, int meta, String id, String variant) {
    }
}
