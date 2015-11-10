package com.celestek.hexcraft.init;

import com.celestek.hexcraft.tileentity.*;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.7.0
 */

public class HexTileEntities {
    /**
     * Initializes the Tile Entities.
     */
    public static void initializeTileEntities()
    {
        GameRegistry.registerTileEntity(TileHexoriumGenerator.class, TileHexoriumGenerator.ID);
        GameRegistry.registerTileEntity(TileHexoriumFurnace.class, TileHexoriumFurnace.ID);
        GameRegistry.registerTileEntity(TileCrystalSeparator.class, "tileCrystalSeparator");
        GameRegistry.registerTileEntity(TileMatrixReconstructor.class, "tileMatrixReconstructor");

        if (HexConfig.cfgTeleportEnable)
            GameRegistry.registerTileEntity(TilePersonalTeleportationPad.class, "tilePersonalTeleportationPad");

        GameRegistry.registerTileEntity(TileEnergyPylon.class, "tileEnergyPylon");

        if (HexConfig.cfgTankEnable) {
            GameRegistry.registerTileEntity(TileTankValve.class, TileTankValve.ID);
            GameRegistry.registerTileEntity(TileTankRender.class, "tileTankRender");
        }
    }
}
