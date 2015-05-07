package com.celestek.hexcraft.init;

import com.celestek.hexcraft.tileentity.TileHexoriumFurnace;
import com.celestek.hexcraft.tileentity.TileHexoriumGenerator;
import com.celestek.hexcraft.tileentity.TileMatrixReconstructor;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-25
 */
public class HexTileEntities {
    /**
     * Initializes the Tile Entities.
     */
    public static void initializeTileEntities()
    {
        GameRegistry.registerTileEntity(TileHexoriumGenerator.class, "tileEntityHexoriumGenerator");
        GameRegistry.registerTileEntity(TileHexoriumFurnace.class, "tileEntityHexoriumFurnace");
        GameRegistry.registerTileEntity(TileMatrixReconstructor.class, "tileEntityMatrixReconstructor");
    }
}
