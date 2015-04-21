package com.celestek.hexcraft;

import com.celestek.hexcraft.client.HexClientProxy;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexItems;
import com.celestek.hexcraft.init.HexRecipes;
import com.celestek.hexcraft.init.HexWorldGen;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.item.Item;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-14
 */

// TODO: Power system
// TODO: Energy Pylons
// TODO: Cables
// TODO: Basic machines, including the Matix Recombiner and a generator
// TODO: Multiblock tank
// TODO: More decoration blocks
// TODO: Glass

@Mod(modid = HexCraft.MODID, name = HexCraft.MODNAME, version = HexCraft.VERSION)
public class HexCraft
{
    // Set default mod info.
    public static final String MODID = "hexcraft";
    public static final String MODNAME = "HEXCraft";
    public static final String VERSION = "0.1.0";

    // Set up the instance.
    @Mod.Instance(value = HexCraft.MODID)
    public static HexCraft instance;

    // HEXCraft's ID counter for automatic populating.
    public static int idCounter;

    // A fortune number unique for HEXCraft.
    public static int hexFortune = 64758;

    @SidedProxy(clientSide = "com.celestek.hexcraft.client.HexClientProxy", serverSide = "com.celestek.hexcraft.server.HexServerProxy")
    public static HexCommonProxy proxy;

    // Set up creative tab.
    public static CreativeTabs hexCraftTab = new CreativeTabs("tabHexCraft") {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return HexItems.itemHexoriumCrystalBlue;
        }
    };

    /**
     * Handles preInit.
     */
    @EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        proxy.preInit(e);
    }

    /**
     * Handles load.
     */
    @EventHandler
    public void init(FMLInitializationEvent e)
    {
        proxy.init(e);
    }

    /**
     * Handles postInit.
     */
    @EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
        proxy.postInit(e);
    }
}
