package com.celestek.hexcraft.init;

import com.celestek.hexcraft.block.HexBlock;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

import java.util.ArrayList;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.8.1
 */

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
        // Prepare default unlocalized string parts.
        String hex1 = "achievement.hexcraft.";
        String hex2 = "hexcraft.";

        // Register the crafting handler.
        final HexCraftingHandler craftingHandler = new HexCraftingHandler();
        FMLCommonHandler.instance().bus().register(craftingHandler);

        // Mining
        achMineHexOre = new Achievement(hex1 + "achMineHexOre", hex2 + "achMineHexOre", -1, -4, HexBlocks.blockHexoriumOreGreen, null).registerStat();
        achList.add(achMineHexOre);
        achMineHexMonolith = new Achievement(hex1 + "achMineHexMonolith", hex2 + "achMineHexMonolith", 0, -4, HexBlocks.blockHexoriumMonolithGreen, null).registerStat();
        achList.add(achMineHexMonolith);

        // Energized Hexorium
        achCraftEnergizedRed = new Achievement(hex1 + "achCraftEnergizedRed", hex2 + "achCraftEnergizedRed", 1, -2, HexBlocks.blockEnergizedHexoriumRed, achMineHexOre).registerStat();
        achList.add(achCraftEnergizedRed);
        achCraftEnergizedOrange = new Achievement(hex1 + "achCraftEnergizedOrange", hex2 + "achCraftEnergizedOrange", 2, -2, HexBlocks.blockEnergizedHexoriumOrange, achMineHexOre).registerStat();
        achList.add(achCraftEnergizedOrange);
        achCraftEnergizedYellow = new Achievement(hex1 + "achCraftEnergizedYellow", hex2 + "achCraftEnergizedYellow", 3, -2, HexBlocks.blockEnergizedHexoriumYellow, achMineHexOre).registerStat();
        achList.add(achCraftEnergizedYellow);
        achCraftEnergizedLime = new Achievement(hex1 + "achCraftEnergizedLime", hex2 + "achCraftEnergizedLime", 4, -2, HexBlocks.blockEnergizedHexoriumLime, achMineHexOre).registerStat();
        achList.add(achCraftEnergizedLime);
        achCraftEnergizedGreen = new Achievement(hex1 + "achCraftEnergizedGreen", hex2 + "achCraftEnergizedGreen", 5, -2, HexBlocks.blockEnergizedHexoriumGreen, achMineHexOre).registerStat();
        achList.add(achCraftEnergizedGreen);
        achCraftEnergizedTurquoise = new Achievement(hex1 + "achCraftEnergizedTurquoise", hex2 + "achCraftEnergizedTurquoise", 6, -2, HexBlocks.blockEnergizedHexoriumTurquoise, achMineHexOre).registerStat();
        achList.add(achCraftEnergizedTurquoise);
        achCraftEnergizedCyan = new Achievement(hex1 + "achCraftEnergizedCyan", hex2 + "achCraftEnergizedCyan", 7, -2, HexBlocks.blockEnergizedHexoriumCyan, achMineHexOre).registerStat();
        achList.add(achCraftEnergizedCyan);
        achCraftEnergizedSkyBlue = new Achievement(hex1 + "achCraftEnergizedSkyBlue", hex2 + "achCraftEnergizedSkyBlue", 8, -2, HexBlocks.blockEnergizedHexoriumSkyBlue, achMineHexOre).registerStat();
        achList.add(achCraftEnergizedSkyBlue);
        achCraftEnergizedBlue = new Achievement(hex1 + "achCraftEnergizedBlue", hex2 + "achCraftEnergizedBlue", 9, -2, HexBlocks.blockEnergizedHexoriumBlue, achMineHexOre).registerStat();
        achList.add(achCraftEnergizedBlue);
        achCraftEnergizedPurple = new Achievement(hex1 + "achCraftEnergizedPurple", hex2 + "achCraftEnergizedPurple", 10, -2, HexBlocks.blockEnergizedHexoriumPurple, achMineHexOre).registerStat();
        achList.add(achCraftEnergizedPurple);
        achCraftEnergizedMagenta = new Achievement(hex1 + "achCraftEnergizedMagenta", hex2 + "achCraftEnergizedMagenta", 11, -2, HexBlocks.blockEnergizedHexoriumMagenta, achMineHexOre).registerStat();
        achList.add(achCraftEnergizedMagenta);
        achCraftEnergizedPink = new Achievement(hex1 + "achCraftEnergizedPink", hex2 + "achCraftEnergizedPink", 12, -2, HexBlocks.blockEnergizedHexoriumPink, achMineHexOre).registerStat();
        achList.add(achCraftEnergizedPink);

        achCraftEnergizedWhite = new Achievement(hex1 + "achCraftEnergizedWhite", hex2 + "achCraftEnergizedWhite", 1, 0, HexBlocks.blockEnergizedHexoriumWhite, achMineHexOre).registerStat();
        achList.add(achCraftEnergizedWhite);
        achCraftEnergizedLightGray = new Achievement(hex1 + "achCraftEnergizedLightGray", hex2 + "achCraftEnergizedLightGray", 2, 0, HexBlocks.blockEnergizedHexoriumLightGray, achMineHexOre).registerStat();
        achList.add(achCraftEnergizedLightGray);
        achCraftEnergizedGray = new Achievement(hex1 + "achCraftEnergizedGray", hex2 + "achCraftEnergizedGray", 3, 0, HexBlocks.blockEnergizedHexoriumGray, achMineHexOre).registerStat();
        achList.add(achCraftEnergizedGray);
        achCraftEnergizedDarkGray = new Achievement(hex1 + "achCraftEnergizedDarkGray", hex2 + "achCraftEnergizedDarkGray", 4, 0, HexBlocks.blockEnergizedHexoriumDarkGray, achMineHexOre).registerStat();
        achList.add(achCraftEnergizedDarkGray);
        achCraftEnergizedBlack = new Achievement(hex1 + "achCraftEnergizedBlack", hex2 + "achCraftEnergizedBlack", 5, 0, HexBlocks.blockEnergizedHexoriumBlack, achMineHexOre).registerStat();
        achList.add(achCraftEnergizedBlack);

        achCraftEnergizedRainbow = new Achievement(hex1 + "achCraftEnergizedRainbow", hex2 + "achCraftEnergizedRainbow", 1, 2, HexBlocks.blockEnergizedHexoriumRainbow, achMineHexOre).registerStat();
        achList.add(achCraftEnergizedRainbow);

        // Energized Hexorium Specials
        achGroupColors = new Achievement(hex1 + "achGroupColors", hex2 + "achGroupColors", 14, -2, HexItems.itemRainbowEnergizedGlobule, achMineHexOre).setSpecial().registerStat();
        achList.add(achGroupColors);
        achGroupGrays = new Achievement(hex1 + "achGroupGrays", hex2 + "achGroupGrays", 7, 0, HexItems.itemBlackHexoriumWafer, achMineHexOre).setSpecial().registerStat();
        achList.add(achGroupGrays);

        // Decorative
        achCraftEngineeredBlock = new Achievement(hex1 + "achCraftEngineeredBlock", hex2 + "achCraftEngineeredBlock", -3, -2, HexBlocks.blockEngineeredHexoriumBlockGreen, achMineHexOre).registerStat();
        achList.add(achCraftEngineeredBlock);
        achCraftFramedBlock = new Achievement(hex1 + "achCraftFramedBlock", hex2 + "achCraftFramedBlock", -4, -2, HexBlocks.blockFramedHexoriumBlockGreen, achMineHexOre).registerStat();
        achList.add(achCraftFramedBlock);
        achCraftPlatedBlock = new Achievement(hex1 + "achCraftPlatedBlock", hex2 + "achCraftPlatedBlock", -5, -2, HexBlocks.blockPlatedHexoriumBlockGreen, achMineHexOre).registerStat();
        achList.add(achCraftPlatedBlock);
        achCraftConcentricBlock = new Achievement(hex1 + "achCraftConcentricBlock", hex2 + "achCraftConcentricBlock", -6, -2, HexBlocks.blockConcentricHexoriumBlockGreen, achMineHexOre).registerStat();
        achList.add(achCraftConcentricBlock);
        achCraftStructureCasing = new Achievement(hex1 + "achCraftStructureCasing", hex2 + "achCraftStructureCasing", -7, -2, HexBlocks.blockHexoriumStructureCasingGreen, achMineHexOre).registerStat();
        achList.add(achCraftStructureCasing);
        achCraftDoor = new Achievement(hex1 + "achCraftDoor", hex2 + "achCraftDoor", -8, -2, HexBlocks.blockHexoriumDoorGreen, achMineHexOre).registerStat();
        achList.add(achCraftDoor);
        achCraftHatch = new Achievement(hex1 + "achCraftHatch", hex2 + "achCraftHatch", -9, -2, HexBlocks.blockHexoriumHatchGreen, achMineHexOre).registerStat();
        achList.add(achCraftHatch);
        achCraftGlowingGlass = new Achievement(hex1 + "achCraftGlowingGlass", hex2 + "achCraftGlowingGlass", -10, -2, HexBlocks.blockGlowingHexoriumGlassGreen, achMineHexOre).registerStat();
        achList.add(achCraftGlowingGlass);
        achCraftLamp = new Achievement(hex1 + "achCraftLamp", hex2 + "achCraftLamp", -11, -2, HexBlocks.blockHexoriumLampGreen, achMineHexOre).registerStat();
        achList.add(achCraftLamp);
        achCraftLampInv = new Achievement(hex1 + "achCraftLampInv", hex2 + "achCraftLampInv", -12, -2, HexBlocks.blockHexoriumLampInvGreen, achMineHexOre).registerStat();
        achList.add(achCraftLampInv);

        // Decorative Special
        achGroupDecorations = new Achievement(hex1 + "achGroupDecorations", hex2 + "achGroupDecorations", -14, -2, HexBlocks.blockEnergizedHexoriumMonolithGreen, achMineHexOre).setSpecial().registerStat();
        achList.add(achGroupDecorations);

        // Reinforcer
        achUseReinforcer = new Achievement(hex1 + "achUseReinforcer", hex2 + "achUseReinforcer", -3, -3, HexItems.itemHexoriumReinforcer, achMineHexOre).registerStat();
        achList.add(achUseReinforcer);

        // T1 Machines
        achCraftMachineBlock = new Achievement(hex1 + "achCraftMachineBlock", hex2 + "achCraftMachineBlock", -4, 1, HexBlocks.blockHexoriumMachineBlock, achCraftEnergizedWhite).registerStat();
        achList.add(achCraftMachineBlock);
        achCraftCable = new Achievement(hex1 + "achCraftCable", hex2 + "achCraftCable", -3, 0, HexBlocks.blockHexoriumCableGreen, achMineHexOre).registerStat();
        achList.add(achCraftCable);

        // T2 Machines
        achCraftMachineGenerator = new Achievement(hex1 + "achCraftMachineGenerator", hex2 + "achCraftMachineGenerator", -9, 3, HexBlocks.blockHexoriumGenerator, achCraftMachineBlock).registerStat();
        achList.add(achCraftMachineGenerator);
        achCraftMachineFurnace = new Achievement(hex1 + "achCraftMachineFurnace", hex2 + "achCraftMachineFurnace", -8, 3, HexBlocks.blockHexoriumFurnace, achCraftMachineBlock).registerStat();
        achList.add(achCraftMachineFurnace);
        achCraftMachineSeparator = new Achievement(hex1 + "achCraftMachineSeparator", hex2 + "achCraftMachineSeparator", -7, 3, HexBlocks.blockCrystalSeparator, achCraftMachineBlock).registerStat();
        achList.add(achCraftMachineSeparator);
        achCraftMachineReconstructor = new Achievement(hex1 + "achCraftMachineReconstructor", hex2 + "achCraftMachineReconstructor", -6, 3, HexBlocks.blockMatrixReconstructor,achCraftMachineBlock).registerStat();
        achList.add(achCraftMachineReconstructor);
        if (HexConfig.cfgTankEnable) {
            achCraftMachineTankValve = new Achievement(hex1 + "achCraftMachineTankValve", hex2 + "achCraftMachineTankValve", -5, 3, HexBlocks.blockTankValve, achCraftMachineBlock).registerStat();
            achList.add(achCraftMachineTankValve);
        }
        if (HexConfig.cfgTeleportEnable) {
            achCraftMachineTeleport = new Achievement(hex1 + "achCraftMachineTeleport", hex2 + "achCraftMachineTeleport", -4, 3, HexBlocks.blockPersonalTeleportationPad, achCraftMachineBlock).registerStat();
            achList.add(achCraftMachineTeleport);
        }
        achCraftPylon = new Achievement(hex1 + "achCraftPylon", hex2 + "achCraftPylon", -3, 3, HexBlocks.blockEnergyPylon, achCraftCable).registerStat();
        achList.add(achCraftPylon);

        // Machines Special
        achGroupMachines = new Achievement(hex1 + "achGroupMachines", hex2 + "achGroupMachines", -11, 3, HexItems.itemMachineControlPanel, achCraftMachineBlock).setSpecial().registerStat();
        achList.add(achGroupMachines);

        // Manipulator
        achCraftManipulator = new Achievement(hex1 + "achCraftManipulator", hex2 + "achCraftManipulator", -1, 8, HexItems.itemHexoriumManipulator, achMineHexOre).registerStat();
        achList.add(achCraftManipulator);

        // Transposer
        achCraftTransposer = new Achievement(hex1 + "achCraftTransposer", hex2 + "achCraftTransposer", 1, 8, HexItems.itemMolecularTransposer, achCraftManipulator).registerStat();
        achList.add(achCraftTransposer);
        achUseTransposer = new Achievement(hex1 + "achUseTransposer", hex2 + "achUseTransposer", 3, 8, HexItems.itemMolecularTransposer, achCraftTransposer).registerStat();
        achList.add(achUseTransposer);
        if (HexConfig.cfgGeneralTransposerAttack) {
            achAttackTransposer = new Achievement(hex1 + "acAttackTransposer", hex2 + "achAttackTransposer", 3, 7, HexItems.itemMolecularTransposer, achCraftTransposer).registerStat();
            achList.add(achAttackTransposer);
        }

        // Probe
        achCraftProbe = new Achievement(hex1 + "achCraftProbe", hex2 + "achCraftProbe", 1, 5, HexItems.itemHexoriumProbe, achMineHexOre).registerStat();
        achList.add(achCraftProbe);
        achUseProbeMachine = new Achievement(hex1 + "achUseProbeMachine", hex2 + "achUseProbeMachine", 3, 5, HexItems.itemHexoriumProbe, achCraftProbe).registerStat();
        achList.add(achUseProbeMachine);
        achUseProbeNetwork = new Achievement(hex1 + "achUseProbeNetwork", hex2 + "achUseProbeNetwork", 3, 4, HexItems.itemHexoriumProbe, achCraftProbe).registerStat();
        achList.add(achUseProbeNetwork);

        // Hexorium Tank
        if (HexConfig.cfgTankEnable) {
            achFormHexoriumTank = new Achievement(hex1 + "achFormHexoriumTank", hex2 + "achFormHexoriumTank", -5, 5, HexItems.itemHexoriumManipulator, achCraftMachineTankValve).registerStat();
            achList.add(achFormHexoriumTank);
        }

        // Linking and Teleporting
        if (HexConfig.cfgTeleportEnable) {
            achLinkTeleport = new Achievement(hex1 + "achLinkTeleport", hex2 + "achLinkTeleport", -4, 5, HexItems.itemHexoriumManipulator, achCraftMachineTeleport).registerStat();
            achList.add(achLinkTeleport);
        }
        achLinkPylon = new Achievement(hex1 + "achLinkPylon", hex2 + "achLinkPylon", -3, 5, HexItems.itemHexoriumManipulator, achCraftPylon).registerStat();
        achList.add(achLinkPylon);
        if (HexConfig.cfgTeleportEnable) {
            achUseTeleport = new Achievement(hex1 + "achUseTeleport", hex2 + "achUseTeleport", -4, 7, HexItems.itemTeleportationFieldProjector, achLinkTeleport).setSpecial().registerStat();
            achList.add(achUseTeleport);
        }

        // Energy Node
        if (HexConfig.cfgEnergyNodeEnable) {
            achCraftAdvancedRainbowCore = new Achievement(hex1 + "achCraftAdvancedRainbowCore", hex2 + "achCraftAdvancedRainbowCore", 3, 2, HexBlocks.blockAdvancedRainbowCore, achCraftEnergizedRainbow).registerStat();
            achList.add(achCraftAdvancedRainbowCore);
            achCraftEnergyNodeCore = new Achievement(hex1 + "achCraftEnergyNodeCore", hex2 + "achCraftEnergyNodeCore", 5, 2, HexBlocks.blockEnergyNodeCoreT1, achCraftAdvancedRainbowCore).registerStat();
            achList.add(achCraftEnergyNodeCore);
            achCraftEnergyNodePort = new Achievement(hex1 + "achCraftEnergyNodePort", hex2 + "achCraftEnergyNodePort", 5, 3, HexBlocks.blockEnergyNodePortHEX, achCraftEnergizedRainbow).registerStat();
            achList.add(achCraftEnergyNodePort);
            achFormEnergyNode = new Achievement(hex1 + "achFormEnergyNode", hex2 + "achFormEnergyNode", 7, 2, HexItems.itemHexoriumManipulator, achCraftEnergyNodeCore).registerStat();
            achList.add(achFormEnergyNode);
            achLinkEnergyNodePorts = new Achievement(hex1 + "achLinkEnergyNodePorts", hex2 + "achLinkEnergyNodePorts", 7, 3, HexItems.itemHexoriumManipulator, achCraftEnergyNodePort).registerStat();
            achList.add(achLinkEnergyNodePorts);
        }

        // Energy Node Special
        if (HexConfig.cfgEnergyNodeEnable) {
            achGroupEnergyNode = new Achievement(hex1 + "achGroupEnergyNode", hex2 + "achGroupEnergyNode", 7, 5, HexBlocks.blockEnergyNodeCoreT4, achFormEnergyNode).setSpecial().registerStat();
            achList.add(achGroupEnergyNode);
        }

        // Register the achievement page.
        AchievementPage.registerAchievementPage(new AchievementPage("HEXCraft", achList.toArray(new Achievement[achList.size()])));
    }
}
