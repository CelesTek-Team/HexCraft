package com.celestek.hexcraft.init;

import com.celestek.hexcraft.block.HexBlock;
import com.celestek.hexcraft.item.HexItemComponent;
import com.celestek.hexcraft.item.ItemHexoriumManipulator;
import com.celestek.hexcraft.item.ItemHexoriumReinforcer;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

import java.util.ArrayList;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.6.0
 * @since 2015-04-15
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
    public static Achievement achCraftMachineTeleport;
    public static Achievement achCraftPylon;

    // Machines Special
    public static Achievement achGroupMachines;

    // Manipulator
    public static Achievement achCraftManipulator;

    // Linking and Teleporting
    public static Achievement achLinkTeleport;
    public static Achievement achLinkPylon;
    public static Achievement achUseTeleport;

    /**
     * Initializes all achievements.
     */
    public static void initializeAchievements()
    {
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
        achCraftDoor = new Achievement(hex1 + "achCraftDoor", hex2 + "achCraftDoor", -7, -2, HexBlocks.blockHexoriumDoorGreen, achMineHexOre).registerStat();
        achList.add(achCraftDoor);
        achCraftHatch = new Achievement(hex1 + "achCraftHatch", hex2 + "achCraftHatch", -8, -2, HexBlocks.blockHexoriumHatchGreen, achMineHexOre).registerStat();
        achList.add(achCraftHatch);
        achCraftGlowingGlass = new Achievement(hex1 + "achCraftGlowingGlass", hex2 + "achCraftGlowingGlass", -9, -2, HexBlocks.blockGlowingHexoriumGlassGreen, achMineHexOre).registerStat();
        achList.add(achCraftGlowingGlass);
        achCraftLamp = new Achievement(hex1 + "achCraftLamp", hex2 + "achCraftLamp", -10, -2, HexBlocks.blockHexoriumLampGreen, achMineHexOre).registerStat();
        achList.add(achCraftLamp);
        achCraftLampInv = new Achievement(hex1 + "achCraftLampInv", hex2 + "achCraftLampInv", -11, -2, HexBlocks.blockHexoriumLampInvGreen, achMineHexOre).registerStat();
        achList.add(achCraftLampInv);

        // Decorative Special
        achGroupDecorations = new Achievement(hex1 + "achGroupDecorations", hex2 + "achGroupDecorations", -13, -2, HexBlocks.blockEnergizedHexoriumMonolithGreen, achMineHexOre).setSpecial().registerStat();
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
        achCraftMachineGenerator = new Achievement(hex1 + "achCraftMachineGenerator", hex2 + "achCraftMachineGenerator", -8, 3, HexBlocks.blockHexoriumGenerator, achCraftMachineBlock).registerStat();
        achList.add(achCraftMachineGenerator);
        achCraftMachineFurnace = new Achievement(hex1 + "achCraftMachineFurnace", hex2 + "achCraftMachineFurnace", -7, 3, HexBlocks.blockHexoriumFurnace, achCraftMachineBlock).registerStat();
        achList.add(achCraftMachineFurnace);
        achCraftMachineSeparator = new Achievement(hex1 + "achCraftMachineSeparator", hex2 + "achCraftMachineSeparator", -6, 3, HexBlocks.blockCrystalSeparator, achCraftMachineBlock).registerStat();
        achList.add(achCraftMachineSeparator);
        achCraftMachineReconstructor = new Achievement(hex1 + "achCraftMachineReconstructor", hex2 + "achCraftMachineReconstructor", -5, 3, HexBlocks.blockMatrixReconstructor,achCraftMachineBlock).registerStat();
        achList.add(achCraftMachineReconstructor);
        achCraftMachineTeleport = new Achievement(hex1 + "achCraftMachineTeleport", hex2 + "achCraftMachineTeleport", -4, 3, HexBlocks.blockPersonalTeleportationPad, achCraftMachineBlock).registerStat();
        achList.add(achCraftMachineTeleport);
        achCraftPylon = new Achievement(hex1 + "achCraftPylon", hex2 + "achCraftPylon", -3, 3, HexBlocks.blockEnergyPylon, achCraftCable).registerStat();
        achList.add(achCraftPylon);

        // Machines Special
        achGroupMachines = new Achievement(hex1 + "achGroupMachines", hex2 + "achGroupMachines", -10, 3, HexItems.itemMachineControlPanel, achCraftMachineBlock).setSpecial().registerStat();
        achList.add(achGroupMachines);

        // Manipulator
        achCraftManipulator = new Achievement(hex1 + "achCraftManipulator", hex2 + "achCraftManipulator", -1, 5, HexItems.itemHexoriumManipulator, achMineHexOre).registerStat();
        achList.add(achCraftManipulator);

        // Linking and Teleporting
        achLinkTeleport = new Achievement(hex1 + "achLinkTeleport", hex2 + "achLinkTeleport", -4, 5, HexItems.itemHexoriumManipulator, achCraftMachineTeleport).registerStat();
        achList.add(achLinkTeleport);
        achLinkPylon = new Achievement(hex1 + "achLinkPylon", hex2 + "achLinkPylon", -3, 5, HexItems.itemHexoriumManipulator, achCraftPylon).registerStat();
        achList.add(achLinkPylon);
        achUseTeleport = new Achievement(hex1 + "achUseTeleport", hex2 + "achUseTeleport", -6, 5, HexItems.itemTeleportationFieldProjector, achLinkTeleport).setSpecial().registerStat();
        achList.add(achUseTeleport);

        // Register the achievement page.
        AchievementPage.registerAchievementPage(new AchievementPage("HEXCraft", achList.toArray(new Achievement[achList.size()])));
    }
}
