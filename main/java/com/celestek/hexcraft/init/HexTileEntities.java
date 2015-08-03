package com.celestek.hexcraft.init;

import com.celestek.hexcraft.tileentity.*;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.6.0
 * @since 2015-04-25
 */
public class HexTileEntities {
    /**
     * Initializes the Tile Entities.
     */
    public static void initializeTileEntities()
    {
        GameRegistry.registerTileEntity(TileHexoriumGenerator.class, "tileHexoriumGenerator");
        GameRegistry.registerTileEntity(TileHexoriumFurnace.class, "tileHexoriumFurnace");
        GameRegistry.registerTileEntity(TileCrystalSeparator.class, "tileCrystalSeparator");
        GameRegistry.registerTileEntity(TileMatrixReconstructor.class, "tileMatrixReconstructor");

        GameRegistry.registerTileEntity(TilePersonalTeleportationPad.class, "tilePersonalTeleportationPad");

        GameRegistry.registerTileEntity(TileEnergyPylon.class, "tileEnergyPylon");
    }
}
