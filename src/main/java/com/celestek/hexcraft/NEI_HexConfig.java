package com.celestek.hexcraft;

import com.celestek.hexcraft.compat.nei.NEI_CrystalSeparator;
import com.celestek.hexcraft.compat.nei.NEI_MatrixReconstructor;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.processing.HexProcessingCrystalSeparator;
import com.celestek.hexcraft.processing.HexProcessingMatrixReconstructor;

/* Special thanks to GregoriusT for helping me get this thing working! */

public class NEI_HexConfig implements codechicken.nei.api.IConfigureNEI {
    public static boolean added = true;

    @Override
    public void loadConfig() {
        added = false;

        if (HexConfig.cfgSeparatorEnable)
            new NEI_CrystalSeparator(HexProcessingCrystalSeparator.processing().getHashMap());
        new NEI_MatrixReconstructor(HexProcessingMatrixReconstructor.processing().getHashMap());

        added = true;
    }

    @Override
    public String getName() {
        return HexCraft.MODNAME + " NEI Plugin";
    }

    @Override
    public String getVersion() {
        return HexCraft.VERSION;
    }
}
