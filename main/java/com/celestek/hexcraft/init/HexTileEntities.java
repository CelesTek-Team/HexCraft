package com.celestek.hexcraft.init;

import com.celestek.hexcraft.tileentity.*;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.6.2

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
