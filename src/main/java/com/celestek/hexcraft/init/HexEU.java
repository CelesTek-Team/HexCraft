package com.celestek.hexcraft.init;

import com.celestek.hexcraft.block.BlockConcentricHexoriumBlock;
import com.celestek.hexcraft.block.BlockEngineeredHexoriumBlock;
import com.celestek.hexcraft.block.BlockFramedHexoriumBlock;
import com.celestek.hexcraft.block.BlockPlatedHexoriumBlock;
import com.celestek.hexcraft.util.HexEnums;
import com.cricketcraft.chisel.api.carving.CarvingUtils;
import com.cricketcraft.chisel.api.carving.ICarvingRegistry;
import ic2.api.energy.EnergyNet;

import java.util.ArrayList;
import java.util.List;

public class HexEU {

    private static final List<Integer> tiers = new ArrayList<>();

    public static void initializeEU() {
        for (int i = 0; i <= 13; i++) {
            int tier = (int) EnergyNet.instance.getPowerFromTier(i);
            tiers.add(tier);
        }
    }

    public static int getTierPower(int tier) {
        return tiers.get(tier);
    }
}
