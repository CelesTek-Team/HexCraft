package celestek.hexcraft;

import celestek.hexcraft.init.ModItems;
import celestek.hexcraft.item.ItemCrystal;
import celestek.hexcraft.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */
@Mod(modid = HEXCraft.MODID, name = HEXCraft.MODNAME, version = HEXCraft.MODVERSION, useMetadata = true)
public class HEXCraft {
    public static final String MODID      = "hexcraft";
    public static final String MODNAME    = "HEXCraft";
    public static final String MODVERSION = "0.1.0";

    // Set up creative tabs.
    public static CreativeTabs tabMaterials = new CreativeTabs("tabMaterials") {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return ModItems.CRYSTAL;
        }
    };
    public static CreativeTabs tabComponents = new CreativeTabs("tabComponents") {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return ModItems.CRYSTAL;
        }
        @Override
        @SideOnly(Side.CLIENT)
        public int getIconItemDamage() {
            return ItemCrystal.EnumType.HEXORIUM_GREEN.getMeta();
        }
    };
    public static CreativeTabs tabMachines = new CreativeTabs("tabMachines") {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return ModItems.CRYSTAL;
        }
        @Override
        @SideOnly(Side.CLIENT)
        public int getIconItemDamage() {
            return ItemCrystal.EnumType.HEXORIUM_BLUE.getMeta();
        }
    };
    public static CreativeTabs tabDecorative = new CreativeTabs("tabDecorative") {
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
    };

    @SidedProxy(clientSide = "celestek.hexcraft.proxy.ClientProxy", serverSide = "celestek.hexcraft.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static HEXCraft instance;

    //public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
