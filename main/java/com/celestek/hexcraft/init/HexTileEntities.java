package com.celestek.hexcraft.init;

import com.celestek.hexcraft.tileentity.*;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.8.2
 */

public class HexTileEntities {
    /**
     * Initializes the Tile Entities.
     */
    public static void initializeTileEntities() {
        GameRegistry.registerTileEntity(TileHexoriumGenerator.class, TileHexoriumGenerator.ID);
        GameRegistry.registerTileEntity(TileHexoriumFurnace.class, TileHexoriumFurnace.ID);
        GameRegistry.registerTileEntity(TileCrystalSeparator.class, TileCrystalSeparator.ID);
        GameRegistry.registerTileEntity(TileMatrixReconstructor.class, TileMatrixReconstructor.ID);

        if (HexConfig.cfgTeleportEnable)
            GameRegistry.registerTileEntity(TilePersonalTeleportationPad.class, TilePersonalTeleportationPad.ID);

        GameRegistry.registerTileEntity(TileEnergyPylon.class, TileEnergyPylon.ID);

        if (HexConfig.cfgTankEnable) {
            GameRegistry.registerTileEntity(TileTankValve.class, TileTankValve.ID);
            GameRegistry.registerTileEntity(TileTankRender.class, TileTankRender.ID);
        }

        if (HexConfig.cfgEnergyNodeEnable) {
            GameRegistry.registerTileEntity(TileEnergyNodePortHEX.class, TileEnergyNodePortHEX.ID);
            GameRegistry.registerTileEntity(TileEnergyNodePortRF.class, TileEnergyNodePortRF.ID);
            if (Loader.isModLoaded("IC2"))
                GameRegistry.registerTileEntity(TileEnergyNodePortEU.class, TileEnergyNodePortEU.ID);
        }
    }
}
