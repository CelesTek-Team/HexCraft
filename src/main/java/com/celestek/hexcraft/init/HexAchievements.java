package com.celestek.hexcraft.init;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.*;
import com.celestek.hexcraft.client.renderer.HexModelRendererCable;
import com.celestek.hexcraft.util.HexEnums;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

import java.util.ArrayList;

import static com.celestek.hexcraft.client.HexClientProxy.renderID;

/**
 * @author Thorinair   <celestek@openmailbox.org>
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
        // Prepare default unlocalized string parts.
        String hex1 = "achievement.hexcraft.";
        String hex2 = "hexcraft.";

        // Register the crafting handler.
        final HexCraftingHandler craftingHandler = new HexCraftingHandler();
        FMLCommonHandler.instance().bus().register(craftingHandler);

        // Mining
        achMineHexOre = new Achievement(hex1 + "achMineHexOre", hex2 + "achMineHexOre", -1, -6, HexBlocks.getHexBlock(BlockHexoriumOre.ID + BlockHexoriumOre.Colors.GREEN.name), null).registerStat();
        achList.add(achMineHexOre);
        achMineHexMonolith = new Achievement(hex1 + "achMineHexMonolith", hex2 + "achMineHexMonolith", 0, -6, HexBlocks.blockHexoriumMonolithGreen, null).registerStat();
        achList.add(achMineHexMonolith);

        // Energized Hexorium
        achCraftEnergizedRed = new Achievement(hex1 + "achCraftEnergized" + HexEnums.Colors.RED.name, hex2 + "achCraftEnergized" + HexEnums.Colors.RED.name, 1, -2, HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.RED), achMineHexOre).registerStat();
        achList.add(achCraftEnergizedRed); 
        achCraftEnergizedOrange = new Achievement(hex1 + "achCraftEnergized" + HexEnums.Colors.ORANGE.name, hex2 + "achCraftEnergized" + HexEnums.Colors.ORANGE.name, 2, -2, HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.ORANGE), achMineHexOre).registerStat();
        achList.add(achCraftEnergizedOrange);  
        achCraftEnergizedYellow = new Achievement(hex1 + "achCraftEnergized" + HexEnums.Colors.YELLOW.name, hex2 + "achCraftEnergized" + HexEnums.Colors.YELLOW.name, 3, -2, HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.YELLOW), achMineHexOre).registerStat();
        achList.add(achCraftEnergizedYellow);
        achCraftEnergizedLime = new Achievement(hex1 + "achCraftEnergized" + HexEnums.Colors.LIME.name, hex2 + "achCraftEnergized" + HexEnums.Colors.LIME.name, 4, -2, HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.LIME), achMineHexOre).registerStat();
        achList.add(achCraftEnergizedLime);
        achCraftEnergizedGreen = new Achievement(hex1 + "achCraftEnergized" + HexEnums.Colors.GREEN.name, hex2 + "achCraftEnergized" + HexEnums.Colors.GREEN.name, 5, -2, HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.GREEN), achMineHexOre).registerStat();
        achList.add(achCraftEnergizedGreen);
        achCraftEnergizedTurquoise = new Achievement(hex1 + "achCraftEnergized" + HexEnums.Colors.TURQUOISE.name, hex2 + "achCraftEnergized" + HexEnums.Colors.TURQUOISE.name, 6, -2, HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.TURQUOISE), achMineHexOre).registerStat();
        achList.add(achCraftEnergizedTurquoise);
        achCraftEnergizedCyan = new Achievement(hex1 + "achCraftEnergized" + HexEnums.Colors.CYAN.name, hex2 + "achCraftEnergized" + HexEnums.Colors.CYAN.name, 7, -2, HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.CYAN), achMineHexOre).registerStat();
        achList.add(achCraftEnergizedCyan);
        achCraftEnergizedSkyBlue = new Achievement(hex1 + "achCraftEnergized" + HexEnums.Colors.SKY_BLUE.name, hex2 + "achCraftEnergized" + HexEnums.Colors.SKY_BLUE.name, 8, -2, HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.SKY_BLUE), achMineHexOre).registerStat();
        achList.add(achCraftEnergizedSkyBlue);
        achCraftEnergizedBlue = new Achievement(hex1 + "achCraftEnergized" + HexEnums.Colors.BLUE.name, hex2 + "achCraftEnergized" + HexEnums.Colors.BLUE.name, 9, -2, HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.BLUE), achMineHexOre).registerStat();
        achList.add(achCraftEnergizedBlue);
        achCraftEnergizedPurple = new Achievement(hex1 + "achCraftEnergized" + HexEnums.Colors.PURPLE.name, hex2 + "achCraftEnergized" + HexEnums.Colors.PURPLE.name, 10, -2, HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.PURPLE), achMineHexOre).registerStat();
        achList.add(achCraftEnergizedPurple);
        achCraftEnergizedMagenta = new Achievement(hex1 + "achCraftEnergized" + HexEnums.Colors.MAGENTA.name, hex2 + "achCraftEnergized" + HexEnums.Colors.MAGENTA.name, 11, -2, HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.MAGENTA), achMineHexOre).registerStat();
        achList.add(achCraftEnergizedMagenta);       
        achCraftEnergizedPink = new Achievement(hex1 + "achCraftEnergized" + HexEnums.Colors.PINK.name, hex2 + "achCraftEnergized" + HexEnums.Colors.PINK.name, 12, -2, HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.PINK), achMineHexOre).registerStat();
        achList.add(achCraftEnergizedPink);
        achCraftEnergizedWhite = new Achievement(hex1 + "achCraftEnergized" + HexEnums.Colors.WHITE.name, hex2 + "achCraftEnergized" + HexEnums.Colors.WHITE.name, 1, 0, HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.WHITE), achMineHexOre).registerStat();
        achList.add(achCraftEnergizedWhite);
        achCraftEnergizedLightGray = new Achievement(hex1 + "achCraftEnergized" + HexEnums.Colors.LIGHT_GRAY.name, hex2 + "achCraftEnergized" + HexEnums.Colors.LIGHT_GRAY.name, 2, 0, HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.LIGHT_GRAY), achMineHexOre).registerStat();
        achList.add(achCraftEnergizedLightGray);
        achCraftEnergizedGray = new Achievement(hex1 + "achCraftEnergized" + HexEnums.Colors.GRAY.name, hex2 + "achCraftEnergized" + HexEnums.Colors.GRAY.name, 3, 0, HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.GRAY), achMineHexOre).registerStat();
        achList.add(achCraftEnergizedGray);
        achCraftEnergizedDarkGray = new Achievement(hex1 + "achCraftEnergized" + HexEnums.Colors.DARK_GRAY.name, hex2 + "achCraftEnergized" + HexEnums.Colors.DARK_GRAY.name, 4, 0, HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.DARK_GRAY), achMineHexOre).registerStat();
        achList.add(achCraftEnergizedDarkGray);
        achCraftEnergizedBlack = new Achievement(hex1 + "achCraftEnergized" + HexEnums.Colors.BLACK.name, hex2 + "achCraftEnergized" + HexEnums.Colors.BLACK.name, 5, 0, HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.BLACK), achMineHexOre).registerStat();
        achList.add(achCraftEnergizedBlack);
        achCraftEnergizedRainbow = new Achievement(hex1 + "achCraftEnergized" + HexEnums.Colors.RAINBOW.name, hex2 + "achCraftEnergized" + HexEnums.Colors.RAINBOW.name, 1, 2, HexBlocks.getHexBlock(BlockEnergizedHexorium.ID, HexEnums.Colors.RAINBOW), achMineHexOre).registerStat();
        achList.add(achCraftEnergizedRainbow);

        // Energized Hexorium Specials
        achGroupColors = new Achievement(hex1 + "achGroupColors", hex2 + "achGroupColors", 14, -2, HexItems.itemRainbowEnergizedGlobule, achMineHexOre).setSpecial().registerStat();
        achList.add(achGroupColors);
        achGroupGrays = new Achievement(hex1 + "achGroupGrays", hex2 + "achGroupGrays", 7, 0, HexItems.itemBlackHexoriumWafer, achMineHexOre).setSpecial().registerStat();
        achList.add(achGroupGrays);

        // Decorative
        achCraftEngineeredBlock = new Achievement(hex1 + "achCraftEngineeredBlock", hex2 + "achCraftEngineeredBlock", -3, -2,  HexBlocks.getHexBlock(BlockEngineeredHexoriumBlock.ID, HexEnums.Colors.GREEN), achMineHexOre).registerStat();
        achList.add(achCraftEngineeredBlock);
        achCraftFramedBlock = new Achievement(hex1 + "achCraftFramedBlock", hex2 + "achCraftFramedBlock", -4, -2, HexBlocks.getHexBlock(BlockFramedHexoriumBlock.ID, HexEnums.Colors.GREEN), achMineHexOre).registerStat();
        achList.add(achCraftFramedBlock);
        achCraftPlatedBlock = new Achievement(hex1 + "achCraftPlatedBlock", hex2 + "achCraftPlatedBlock", -5, -2, HexBlocks.getHexBlock(BlockPlatedHexoriumBlock.ID, HexEnums.Colors.GREEN), achMineHexOre).registerStat();
        achList.add(achCraftPlatedBlock);
        achCraftConcentricBlock = new Achievement(hex1 + "achCraftConcentricBlock", hex2 + "achCraftConcentricBlock", -6, -2, HexBlocks.getHexBlock(BlockConcentricHexoriumBlock.ID, HexEnums.Colors.GREEN), achMineHexOre).registerStat();
        achList.add(achCraftConcentricBlock);
        achCraftStructureCasing = new Achievement(hex1 + "achCraftStructureCasing", hex2 + "achCraftStructureCasing", -7, -2, HexBlocks.getHexBlock(BlockHexoriumStructureCasing.ID, HexEnums.Colors.GREEN), achMineHexOre).registerStat();
        achList.add(achCraftStructureCasing);
        achCraftDoor = new Achievement(hex1 + "achCraftDoor", hex2 + "achCraftDoor", -8, -2, HexBlocks.getHexBlock(BlockHexoriumDoor.ID, HexEnums.Colors.GREEN), achMineHexOre).registerStat();
        achList.add(achCraftDoor);
        achCraftHatch = new Achievement(hex1 + "achCraftHatch", hex2 + "achCraftHatch", -9, -2, HexBlocks.getHexBlock(BlockHexoriumHatch.ID, HexEnums.Colors.GREEN), achMineHexOre).registerStat();
        achList.add(achCraftHatch);
        achCraftGlowingGlass = new Achievement(hex1 + "achCraftGlowingGlass", hex2 + "achCraftGlowingGlass", -10, -2, HexBlocks.getHexBlock(BlockGlowingHexoriumGlass.ID, HexEnums.Colors.GREEN), achMineHexOre).registerStat();
        achList.add(achCraftGlowingGlass);
        achCraftLamp = new Achievement(hex1 + "achCraftLamp", hex2 + "achCraftLamp", -11, -2, HexBlocks.getHexBlock(BlockHexoriumLamp.ID, HexEnums.Colors.GREEN), achMineHexOre).registerStat();
        achList.add(achCraftLamp);
        achCraftLampInv = new Achievement(hex1 + "achCraftLampInv", hex2 + "achCraftLampInv", -12, -2, HexBlocks.getHexBlock(BlockHexoriumLampInv.ID, HexEnums.Colors.GREEN), achMineHexOre).registerStat();
        achList.add(achCraftLampInv);

        // Decorative Special
        achGroupDecorations = new Achievement(hex1 + "achGroupDecorations", hex2 + "achGroupDecorations", -14, -2, HexBlocks.getHexBlock(BlockHexoriumMonolith.ID, HexEnums.Colors.GREEN), achMineHexOre).setSpecial().registerStat();
        achList.add(achGroupDecorations);

        // Reinforcer
        achUseReinforcer = new Achievement(hex1 + "achUseReinforcer", hex2 + "achUseReinforcer", -3, -4, HexItems.itemHexoriumReinforcer, achMineHexOre).registerStat();
        achList.add(achUseReinforcer);

        // Dyeing
        achUseDye = new Achievement(hex1 + "achUseDye", hex2 + "achUseDye", -3, -3, HexBlocks.blockHexoriumCoatedStoneWhite, achMineHexOre).registerStat();
        achList.add(achUseDye);

        // Energized Hexorium
        achCraftHexoriumCoatedStone = new Achievement(hex1 + "achCraftHexoriumCoatedStone", hex2 + "achCraftHexoriumCoatedStone", 1, -3, HexBlocks.blockHexoriumCoatedStone, achMineHexOre).registerStat();
        achList.add(achCraftHexoriumCoatedStone);
        achCraftGlowingHexoriumCoatedStone = new Achievement(hex1 + "achCraftGlowingHexoriumCoatedStone", hex2 + "achCraftGlowingHexoriumCoatedStone", 3, -3, HexBlocks.getHexBlock(BlockGlowingHexoriumCoatedStone.ID, HexEnums.Colors.GREEN), achCraftHexoriumCoatedStone).registerStat();
        achList.add(achCraftGlowingHexoriumCoatedStone);

        // T1 Sound Machines
        achCraftSoundEmissionModule = new Achievement(hex1 + "achCraftSoundEmissionModule", hex2 + "achCraftSoundEmissionModule", -6, -1, HexItems.itemSoundEmissionModule, achMineHexOre).registerStat();
        achList.add(achCraftSoundEmissionModule);

        // T2 Sound Machines
        achCraftSoundProjector = new Achievement(hex1 + "achCraftSoundProjector", hex2 + "achCraftSoundProjector", -6, 1, HexBlocks.blockSoundProjector, achCraftSoundEmissionModule).registerStat();
        achList.add(achCraftSoundProjector);

        // T1 Machines
        achCraftMachineBlock = new Achievement(hex1 + "achCraftMachineBlock", hex2 + "achCraftMachineBlock", -4, 1, HexBlocks.blockHexoriumMachineBlock, achCraftEnergizedWhite).registerStat();
        achList.add(achCraftMachineBlock);
        achCraftCable = new Achievement(hex1 + "achCraftCable", hex2 + "achCraftCable", -3, 0, HexBlocks.getHexBlock(BlockHexoriumCable.ID, HexEnums.Colors.GREEN), achMineHexOre).registerStat();
        achList.add(achCraftCable);

        // T2 Machines
        achCraftMachineGenerator = new Achievement(hex1 + "achCraftMachineGenerator", hex2 + "achCraftMachineGenerator", -10, 3, HexBlocks.blockHexoriumGenerator, achCraftMachineBlock).registerStat();
        achList.add(achCraftMachineGenerator);
        if (HexConfig.cfgFurnaceEnable) {
            achCraftMachineFurnace = new Achievement(hex1 + "achCraftMachineFurnace", hex2 + "achCraftMachineFurnace", -9, 3, HexBlocks.blockHexoriumFurnace, achCraftMachineBlock).registerStat();
            achList.add(achCraftMachineFurnace);
        }
        if (HexConfig.cfgSeparatorEnable) {
            achCraftMachineSeparator = new Achievement(hex1 + "achCraftMachineSeparator", hex2 + "achCraftMachineSeparator", -8, 3, HexBlocks.blockCrystalSeparator, achCraftMachineBlock).registerStat();
            achList.add(achCraftMachineSeparator);
        }
        achCraftMachineReconstructor = new Achievement(hex1 + "achCraftMachineReconstructor", hex2 + "achCraftMachineReconstructor", -7, 3, HexBlocks.blockMatrixReconstructor,achCraftMachineBlock).registerStat();
        achList.add(achCraftMachineReconstructor);
        if (HexConfig.cfgObserverEnable) {
            achCraftMachineQuantumObserver = new Achievement(hex1 + "achCraftMachineQuantumObserver", hex2 + "achCraftMachineQuantumObserver", -6, 3, HexBlocks.blockQuantumObserver, achCraftMachineBlock).registerStat();
            achList.add(achCraftMachineQuantumObserver);
        }
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
        achGroupMachines = new Achievement(hex1 + "achGroupMachines", hex2 + "achGroupMachines", -12, 3, HexItems.itemMachineControlPanel, achCraftMachineBlock).setSpecial().registerStat();
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
