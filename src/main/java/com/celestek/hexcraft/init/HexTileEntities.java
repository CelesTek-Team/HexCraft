package com.celestek.hexcraft.init;

import com.celestek.hexcraft.tileentity.*;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class HexTileEntities {
    /**
     * Initializes the Tile Entities.
     */
    public static void initializeTileEntities() {
        GameRegistry.registerTileEntity(TileHexoriumGenerator.class, TileHexoriumGenerator.ID);

        if (HexConfig.cfgFurnaceEnable)
            GameRegistry.registerTileEntity(TileHexoriumFurnace.class, TileHexoriumFurnace.ID);

        if (HexConfig.cfgSeparatorEnable)
            GameRegistry.registerTileEntity(TileCrystalSeparator.class, TileCrystalSeparator.ID);

        GameRegistry.registerTileEntity(TileMatrixReconstructor.class, TileMatrixReconstructor.ID);

        if (HexConfig.cfgTeleportEnable)
            GameRegistry.registerTileEntity(TilePersonalTeleportationPad.class, TilePersonalTeleportationPad.ID);

        if (HexConfig.cfgObserverEnable)
            GameRegistry.registerTileEntity(TileQuantumObserver.class, TileQuantumObserver.ID);

        GameRegistry.registerTileEntity(TileEnergyPylon.class, TileEnergyPylon.ID);

        if (HexConfig.cfgTankEnable) {
            GameRegistry.registerTileEntity(TileTankValve.class, TileTankValve.ID);
            GameRegistry.registerTileEntity(TileTankRender.class, TileTankRender.ID);
        }

        if (HexConfig.cfgEnergyNodeEnable) {
            GameRegistry.registerTileEntity(TileEnergyNodePortHEX.class, TileEnergyNodePortHEX.ID);
            if (HexConfig.cfgEnergyNodePortsRFEnable)
                GameRegistry.registerTileEntity(TileEnergyNodePortRF.class, TileEnergyNodePortRF.ID);
            if (Loader.isModLoaded("IC2") && HexConfig.cfgEnergyNodePortsEUEnable)
                GameRegistry.registerTileEntity(TileEnergyNodePortEU.class, TileEnergyNodePortEU.ID);
            if (Loader.isModLoaded("gregapi") && HexConfig.cfgEnergyNodePortsLUEnable)
                GameRegistry.registerTileEntity(TileEnergyNodePortLU.class, TileEnergyNodePortLU.ID);
        }

        GameRegistry.registerTileEntity(TileSoundProjector.class, TileSoundProjector.ID);
    }
}
