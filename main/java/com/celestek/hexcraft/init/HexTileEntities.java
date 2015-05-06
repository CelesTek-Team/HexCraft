package com.celestek.hexcraft.init;

import com.celestek.hexcraft.tileentity.TileEntityHexoriumFurnace;
import com.celestek.hexcraft.tileentity.TileEntityHexoriumGenerator;
import com.celestek.hexcraft.tileentity.TileEntityMatrixReconstructor;
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
        GameRegistry.registerTileEntity(TileEntityHexoriumGenerator.class, "tileEntityHexoriumGenerator");
        GameRegistry.registerTileEntity(TileEntityHexoriumFurnace.class, "tileEntityHexoriumFurnace");
        GameRegistry.registerTileEntity(TileEntityMatrixReconstructor.class, "tileEntityMatrixReconstructor");
    }
}
