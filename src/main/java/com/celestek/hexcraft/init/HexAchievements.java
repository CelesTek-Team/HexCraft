package com.celestek.hexcraft.init;

import com.celestek.hexcraft.block.*;
import com.celestek.hexcraft.util.HexEnums;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

import java.util.ArrayList;

public class HexAchievements {

    // Prepare a list of all achievements.
    public static ArrayList<Achievement> achList = new ArrayList<Achievement>();

    // Prepare achievements.
    // Mining
    public static Achievement achMineHexOre;
    public static Achievement achMineHexMonolith;

    // Energized Hexorium
    public static Achievement achCraftEnergizedRed;
    public static Achievement achCraftEnergizedOrange;
    public static Achievement achCraftEnergizedYellow;
    public static Achievement achCraftEnergizedLime;
    public static Achievement achCraftEnergizedGreen;
    public static Achievement achCraftEnergizedTurquoise;
    public static Achievement achCraftEnergizedCyan;
    public static Achievement achCraftEnergizedSkyBlue;
    public static Achievement achCraftEnergizedBlue;
    public static Achievement achCraftEnergizedPurple;
    public static Achievement achCraftEnergizedMagenta;
    public static Achievement achCraftEnergizedPink;

    public static Achievement achCraftEnergizedWhite;
    public static Achievement achCraftEnergizedLightGray;
    public static Achievement achCraftEnergizedGray;
    public static Achievement achCraftEnergizedDarkGray;
    public static Achievement achCraftEnergizedBlack;

    public static Achievement achCraftEnergizedRainbow;

    // Energized Hexorium Specials
    public static Achievement achGroupColors;
    public static Achievement achGroupGrays;

    // Decorative
    public static Achievement achCraftEngineeredBlock;
    public static Achievement achCraftFramedBlock;
    public static Achievement achCraftPlatedBlock;
    public static Achievement achCraftConcentricBlock;
    public static Achievement achCraftStructureCasing;
    public static Achievement achCraftDoor;
    public static Achievement achCraftHatch;
    public static Achievement achCraftGlowingGlass;
    public static Achievement achCraftLamp;
    public static Achievement achCraftLampInv;

    // Decorative Special
    public static Achievement achGroupDecorations;

    // Reinforcer
    public static Achievement achUseReinforcer;

    // Dyeing
    public static Achievement achUseDye;

    // Hexorium-Coated
    public static Achievement achCraftHexoriumCoatedStone;
    public static Achievement achCraftGlowingHexoriumCoatedStone;

    // T1 Sound Machines
    public static Achievement achCraftSoundEmissionModule;

    // T2 Sound Machines
    public static Achievement achCraftSoundProjector;

    // T1 Machines
    public static Achievement achCraftMachineBlock;
    public static Achievement achCraftCable;

    // T2 Machines
    public static Achievement achCraftMachineGenerator;
    public static Achievement achCraftMachineFurnace;
    public static Achievement achCraftMachineSeparator;
    public static Achievement achCraftMachineReconstructor;
    public static Achievement achCraftMachineTankValve;
    public static Achievement achCraftMachineTeleport;
    public static Achievement achCraftMachineQuantumObserver;
    public static Achievement achCraftPylon;

    // Machines Special
    public static Achievement achGroupMachines;

    // Manipulator
    public static Achievement achCraftManipulator;
    
    // Transposer
    public static Achievement achCraftTransposer;
    public static Achievement achUseTransposer;
    public static Achievement achAttackTransposer;

    // Probe
    public static Achievement achCraftProbe;
    public static Achievement achUseProbeMachine;
    public static Achievement achUseProbeNetwork;

    // Hexorium Tank
    public static Achievement achFormHexoriumTank;

    // Linking and Teleporting
    public static Achievement achLinkTeleport;
    public static Achievement achLinkPylon;
    public static Achievement achUseTeleport;

    // Energy Node
    public static Achievement achCraftAdvancedRainbowCore;
    public static Achievement achCraftEnergyNodeCore;
    public static Achievement achCraftEnergyNodePort;
    public static Achievement achFormEnergyNode;
    public static Achievement achLinkEnergyNodePorts;

    // Energy Node Special
    public static Achievement achGroupEnergyNode;

    /**
     * Initializes all achievements.
     */
    public static void initializeAchievements() {
        // Register the crafting handler.
        final HexCraftingHandler craftingHandler = new HexCraftingHandler();
        FMLCommonHandler.instance().bus().register(craftingHandler);

        // Mining
        achMineHexOre      = register("achMineHexOre",      HexBlocks.getHexBlock(BlockHexoriumOre.ID + BlockHexoriumOre.Colors.GREEN.name),           null, -1, -6);
        achMineHexMonolith = register("achMineHexMonolith", HexBlocks.getHexBlock(BlockHexoriumMonolith.ID + BlockHexoriumMonolith.Colors.GREEN.name), null, 0, -6);

        // Energized Hexorium
        achCraftEnergizedRed       = register("achCraftEnergized" + HexEnums.Colors.RED.name,        HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.RED),        achMineHexOre, 1, -2);
        achCraftEnergizedOrange    = register("achCraftEnergized" + HexEnums.Colors.ORANGE.name,     HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.ORANGE),     achMineHexOre, 2, -2);
        achCraftEnergizedYellow    = register("achCraftEnergized" + HexEnums.Colors.YELLOW.name,     HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.YELLOW),     achMineHexOre, 3, -2);
        achCraftEnergizedLime      = register("achCraftEnergized" + HexEnums.Colors.LIME.name,       HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.LIME),       achMineHexOre, 4, -2);
        achCraftEnergizedGreen     = register("achCraftEnergized" + HexEnums.Colors.GREEN.name,      HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.GREEN),      achMineHexOre, 5, -2);
        achCraftEnergizedTurquoise = register("achCraftEnergized" + HexEnums.Colors.TURQUOISE.name,  HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.TURQUOISE),  achMineHexOre, 6, -2);
        achCraftEnergizedCyan      = register("achCraftEnergized" + HexEnums.Colors.CYAN.name,       HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.CYAN),       achMineHexOre, 7, -2);
        achCraftEnergizedSkyBlue   = register("achCraftEnergized" + HexEnums.Colors.SKY_BLUE.name,   HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.SKY_BLUE),   achMineHexOre, 8, -2);
        achCraftEnergizedBlue      = register("achCraftEnergized" + HexEnums.Colors.BLUE.name,       HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.BLUE),       achMineHexOre, 9, -2);
        achCraftEnergizedPurple    = register("achCraftEnergized" + HexEnums.Colors.PURPLE.name,     HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.PURPLE),     achMineHexOre, 10, -2);
        achCraftEnergizedMagenta   = register("achCraftEnergized" + HexEnums.Colors.MAGENTA.name,    HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.MAGENTA),    achMineHexOre, 11, -2);
        achCraftEnergizedPink      = register("achCraftEnergized" + HexEnums.Colors.PINK.name,       HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.PINK),       achMineHexOre, 12, -2);
        achCraftEnergizedWhite     = register("achCraftEnergized" + HexEnums.Colors.WHITE.name,      HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.WHITE),      achMineHexOre, 1, 0);
        achCraftEnergizedLightGray = register("achCraftEnergized" + HexEnums.Colors.LIGHT_GRAY.name, HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.LIGHT_GRAY), achMineHexOre, 2, 0);
        achCraftEnergizedGray      = register("achCraftEnergized" + HexEnums.Colors.GRAY.name,       HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.GRAY),       achMineHexOre, 3, 0);
        achCraftEnergizedDarkGray  = register("achCraftEnergized" + HexEnums.Colors.DARK_GRAY.name,  HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.DARK_GRAY),  achMineHexOre, 4, 0);
        achCraftEnergizedBlack     = register("achCraftEnergized" + HexEnums.Colors.BLACK.name,      HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.BLACK),      achMineHexOre, 5, 0);
        achCraftEnergizedRainbow   = register("achCraftEnergized" + HexEnums.Colors.RAINBOW.name,    HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.RAINBOW),    achMineHexOre, 1, 2);

        // Energized Hexorium Specials
        achGroupColors = registerSpecial("achGroupColors", HexItems.itemRainbowEnergizedGlobule, achMineHexOre, 14, -2);
        achGroupGrays  = registerSpecial("achGroupGrays",  HexItems.itemBlackHexoriumWafer,      achMineHexOre, 7, 0);

        // Decorative
        achCraftEngineeredBlock = register("achCraftEngineeredBlock", HexBlocks.getHexBlock(BlockEngineeredHexoriumBlock.ID, HexEnums.Colors.GREEN), achMineHexOre, -3, -2);
        achCraftFramedBlock     = register("achCraftFramedBlock",     HexBlocks.getHexBlock(BlockFramedHexoriumBlock.ID,     HexEnums.Colors.GREEN), achMineHexOre, -4, -2);
        achCraftPlatedBlock     = register("achCraftPlatedBlock",     HexBlocks.getHexBlock(BlockPlatedHexoriumBlock.ID,     HexEnums.Colors.GREEN), achMineHexOre, -5, -2);
        achCraftConcentricBlock = register("achCraftConcentricBlock", HexBlocks.getHexBlock(BlockConcentricHexoriumBlock.ID, HexEnums.Colors.GREEN), achMineHexOre, -6, -2);
        achCraftStructureCasing = register("achCraftStructureCasing", HexBlocks.getHexBlock(BlockHexoriumStructureCasing.ID, HexEnums.Colors.GREEN), achMineHexOre, -7, -2);
        achCraftDoor            = register("achCraftDoor",            HexBlocks.getHexBlock(BlockHexoriumDoor.ID,            HexEnums.Colors.GREEN), achMineHexOre, -8, -2);
        achCraftHatch           = register("achCraftHatch",           HexBlocks.getHexBlock(BlockHexoriumHatch.ID,           HexEnums.Colors.GREEN), achMineHexOre, -9, -2);
        achCraftGlowingGlass    = register("achCraftGlowingGlass",    HexBlocks.getHexBlock(BlockGlowingHexoriumGlass.ID,    HexEnums.Colors.GREEN), achMineHexOre, -10, -2);
        achCraftLamp            = register("achCraftLamp",            HexBlocks.getHexBlock(BlockHexoriumLamp.ID,            HexEnums.Colors.GREEN), achMineHexOre, -11, -2);
        achCraftLampInv         = register("achCraftLampInv",         HexBlocks.getHexBlock(BlockHexoriumLampInv.ID,         HexEnums.Colors.GREEN), achMineHexOre, -12, -2);

        // Decorative Special
        achGroupDecorations = registerSpecial("achGroupDecorations", HexBlocks.getHexBlock(BlockHexoriumMonolith.ID, HexEnums.Colors.GREEN), achMineHexOre, -14, -2);

        // Reinforcer
        achUseReinforcer = register("achUseReinforcer", HexItems.itemHexoriumReinforcer, achMineHexOre, -3, -4);

        // Dyeing
        achUseDye = register("achUseDye", HexBlocks.getHexBlock(BlockHexoriumCoatedStone.ID, HexEnums.Variants.WHITE), achMineHexOre, -3, -3);

        // Hexorium CoatedStone
        achCraftHexoriumCoatedStone        = register("achCraftHexoriumCoatedStone",        HexBlocks.getHexBlock(BlockHexoriumCoatedStone.ID,        HexEnums.Variants.BLACK), achMineHexOre,               1, -3);
        achCraftGlowingHexoriumCoatedStone = register("achCraftGlowingHexoriumCoatedStone", HexBlocks.getHexBlock(BlockGlowingHexoriumCoatedStone.ID, HexEnums.Colors.GREEN),   achCraftHexoriumCoatedStone, 3, -3);

        // T1 Sound Machines
        achCraftSoundEmissionModule = register("achCraftSoundEmissionModule", HexItems.itemSoundEmissionModule, achMineHexOre, -6, -1);

        // T2 Sound Machines
        achCraftSoundProjector = register("achCraftSoundProjector", HexBlocks.getHexBlock(BlockSoundProjector.ID), achCraftSoundEmissionModule, -6, 1);

        // T1 Machines
        achCraftMachineBlock = register("achCraftMachineBlock", HexBlocks.getHexBlock(BlockHexoriumMachineBlock.ID),                 achCraftEnergizedWhite, -4, 1);
        achCraftCable        = register("achCraftCable",        HexBlocks.getHexBlock(BlockHexoriumCable.ID, HexEnums.Colors.GREEN), achMineHexOre,          -3, 0);

        // T2 Machines
        achCraftMachineGenerator       = register("achCraftMachineGenerator",       HexBlocks.getHexBlock(BlockHexoriumGenerator.ID),        achCraftMachineBlock, -10, 3);
        achCraftMachineFurnace         = register("achCraftMachineFurnace",         HexBlocks.getHexBlock(BlockHexoriumFurnace.ID),          achCraftMachineBlock, -9, 3, HexConfig.cfgFurnaceEnable);
        achCraftMachineSeparator       = register("achCraftMachineSeparator",       HexBlocks.getHexBlock(BlockCrystalSeparator.ID),         achCraftMachineBlock, -8, 3, HexConfig.cfgSeparatorEnable);
        achCraftMachineReconstructor   = register("achCraftMachineReconstructor",   HexBlocks.getHexBlock(BlockMatrixReconstructor.ID),      achCraftMachineBlock, -7, 3);
        achCraftMachineQuantumObserver = register("achCraftMachineQuantumObserver", HexBlocks.getHexBlock(BlockQuantumObserver.ID),          achCraftMachineBlock, -6, 3, HexConfig.cfgObserverEnable);
        achCraftMachineTankValve       = register("achCraftMachineTankValve",       HexBlocks.getHexBlock(BlockTankValve.ID),                achCraftMachineBlock, -5, 3, HexConfig.cfgTankEnable);
        achCraftMachineTeleport        = register("achCraftMachineTeleport",        HexBlocks.getHexBlock(BlockPersonalTeleportationPad.ID), achCraftMachineBlock, -4, 3, HexConfig.cfgTeleportEnable);
        achCraftPylon                  = register("achCraftPylon",                  HexBlocks.getHexBlock(BlockEnergyPylon.ID),              achCraftCable,        -3, 3);

        // Machines Special
        achGroupMachines = registerSpecial("achGroupMachines", HexItems.itemMachineControlPanel, achCraftMachineBlock, -12, 3);

        // Manipulator
        achCraftManipulator = register("achCraftManipulator", HexItems.itemHexoriumManipulator, achMineHexOre, -1, 8);

        // Transposer
        achCraftTransposer  = register("achCraftTransposer",  HexItems.itemMolecularTransposer, achCraftManipulator, 1, 8);
        achUseTransposer    = register("achUseTransposer",    HexItems.itemMolecularTransposer, achCraftTransposer,  3, 8);
        achAttackTransposer = register("achAttackTransposer", HexItems.itemMolecularTransposer, achCraftTransposer,  3, 7, HexConfig.cfgGeneralTransposerAttack);

        // Probe
        achCraftProbe      = register("achCraftProbe", HexItems.itemHexoriumProbe, achMineHexOre, 1, 5);
        achUseProbeMachine = register("achUseProbeMachine", HexItems.itemHexoriumProbe, achCraftProbe, 3, 5);
        achUseProbeNetwork = register("achUseProbeNetwork", HexItems.itemHexoriumProbe, achCraftProbe, 3, 4);

        // Hexorium Tank
        achFormHexoriumTank = register("achFormHexoriumTank", HexItems.itemHexoriumManipulator, achCraftMachineTankValve, -5, 5, HexConfig.cfgTankEnable);

        // Teleport & Linking
        achLinkTeleport = register("achLinkTeleport", HexItems.itemHexoriumManipulator, achCraftMachineTeleport, -4, 5, HexConfig.cfgTeleportEnable);
        achLinkPylon    = register("achLinkPylon",    HexItems.itemHexoriumManipulator, achCraftPylon,           -3, 5);

        // Teleport Special
        achUseTeleport = registerSpecial("achUseTeleport", HexItems.itemTeleportationFieldProjector, achLinkTeleport, -4, 7, HexConfig.cfgTeleportEnable);

        // Energy Node
        achCraftAdvancedRainbowCore = register("achCraftAdvancedRainbowCore", HexBlocks.getHexBlock(BlockAdvancedRainbowCore.ID),                                achCraftEnergizedRainbow,    3, 2, HexConfig.cfgEnergyNodeEnable);
        achCraftEnergyNodeCore      = register("achCraftEnergyNodeCore",      HexBlocks.getHexBlock(BlockEnergyNodeCore.ID + BlockEnergyNodeCore.Tiers.T1.name), achCraftAdvancedRainbowCore, 5, 2, HexConfig.cfgEnergyNodeEnable);
        achCraftEnergyNodePort      = register("achCraftEnergyNodePort",      HexBlocks.getHexBlock(BlockEnergyNodePortHEX.ID),                                  achCraftEnergizedRainbow,    5, 3, HexConfig.cfgEnergyNodeEnable);
        achFormEnergyNode           = register("achFormEnergyNode",           HexItems.itemHexoriumManipulator,                                                  achCraftEnergyNodeCore,      7, 2, HexConfig.cfgEnergyNodeEnable);
        achLinkEnergyNodePorts      = register("achLinkEnergyNodePorts",      HexItems.itemHexoriumManipulator,                                                  achCraftEnergyNodePort,      7, 3, HexConfig.cfgEnergyNodeEnable);

        // Energy Node Special
        achGroupEnergyNode = registerSpecial("achGroupEnergyNode", HexBlocks.getHexBlock(BlockEnergyNodeCore.ID + BlockEnergyNodeCore.Tiers.T4.name), achFormEnergyNode, 7, 5, HexConfig.cfgEnergyNodeEnable);

        // Register the achievement page.
        AchievementPage.registerAchievementPage(new AchievementPage("HEXCraft", achList.toArray(new Achievement[achList.size()])));
    }


    private static Achievement register(String name, Block block, Achievement prev, int x, int y, boolean enabled) {
        if (enabled)
            return register(name, block, prev, x, y);
        else
            return null;
    }

    private static Achievement register(String name, Block block, Achievement prev, int x, int y) {
        Achievement achievement;
        achievement = new Achievement("achievement.hexcraft." + name, "hexcraft." + name, x, y, block, prev).registerStat();
        achList.add(achievement);
        return achievement;
    }

    private static Achievement register(String name, Item item, Achievement prev, int x, int y, boolean enabled) {
        if (enabled)
            return register(name, item, prev, x, y);
        else
            return null;
    }

    private static Achievement register(String name, Item item, Achievement prev, int x, int y) {
        Achievement achievement;
        achievement = new Achievement("achievement.hexcraft." + name, "hexcraft." + name, x, y, item, prev).registerStat();
        achList.add(achievement);
        return achievement;
    }

    private static Achievement registerSpecial(String name, Block block, Achievement prev, int x, int y, boolean enabled) {
        if (enabled)
            return registerSpecial(name, block, prev, x, y);
        else
            return null;
    }

    private static Achievement registerSpecial(String name, Block block, Achievement prev, int x, int y) {
        Achievement achievement;
        achievement = new Achievement("achievement.hexcraft." + name, "hexcraft." + name, x, y, block, prev).setSpecial().registerStat();
        achList.add(achievement);
        return achievement;
    }

    private static Achievement registerSpecial(String name, Item item, Achievement prev, int x, int y, boolean enabled) {
        if (enabled)
            return registerSpecial(name, item, prev, x, y);
        else
            return null;
    }

    private static Achievement registerSpecial(String name, Item item, Achievement prev, int x, int y) {
        Achievement achievement;
        achievement = new Achievement("achievement.hexcraft." + name, "hexcraft." + name, x, y, item, prev).setSpecial().registerStat();
        achList.add(achievement);
        return achievement;
    }
}
