package com.celestek.hexcraft;

import com.celestek.hexcraft.init.*;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.ForgeChunkManager;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class HexCommonProxy {

    /**
     * Handles preInit.
     */
    public void preInit(FMLPreInitializationEvent e) {
        // Set up config.
        HexConfig.initializeConfig(e);
        // Set up all ingame blocks, items and recipes.
        HexBlocks.initializeBlocks();
        HexItems.initializeItems();
        HexOreDict.registerOres();
        HexRecipes.initializeRecipes();
        HexTileEntities.initializeTileEntities();
        // Set up chunk loading.
        ForgeChunkManager.setForcedChunkLoadingCallback(HexCraft.instance, null);
    }

    /**
     * Handles init.
     */
    public void init(FMLInitializationEvent e) {
        GameRegistry.registerWorldGenerator(new HexWorldGen(), 0);
        NetworkRegistry.INSTANCE.registerGuiHandler(HexCraft.instance, new HexGui());
        if (HexConfig.cfgGeneralUseAchievements)
            HexAchievements.initializeAchievements();
        if (Loader.isModLoaded("ForgeMultipart")) {
            HexMultipart.initializeMicroblocks();
        }
        if (Loader.isModLoaded("chisel")) {
            HexChisel.initializeChisel();
        }
    }

    /**
     * Handles postInit.
     */
    public void postInit(FMLPostInitializationEvent e) {

    }
}
