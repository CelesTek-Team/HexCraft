package com.celestek.hexcraft.init;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class HexConfig {

    // General
    public static boolean cfgGeneralNetworkDebug = false;
    public static boolean cfgGeneralVerboseNetworkDebug = false;
    public static boolean cfgGeneralMachineNetworkDebug = false;
    public static int cfgGeneralPylonRange = 32;
    public static boolean cfgGeneralUseAchievements = true;
    public static boolean cfgFurnaceEnable = true;
    public static boolean cfgGeneralTransposerAttack = true;
    public static boolean cfgGeneralTransposerAttackPlayers = true;
    public static int cfgGeneralTransposerAttackDamage = 20;
    public static int cfgGeneralMonolithGlowstoneLightLevel = 10;
    public static float cfgGeneralFlickerFix = 0.000F;

    // General - Personal Teleportation Pad
    public static String categoryTeleport = "General - Personal Teleportation Pad";
    public static boolean cfgTeleportEnable = true;
    public static boolean cfgTeleportShouldDamagePlayers = true;
    public static int cfgTeleportDamageAmount = 4;
    public static int cfgTeleportUsageCost = 102400;

    // General - Quantum Observer
    public static String categoryObserver = "General - Quantum Observer";
    public static boolean cfgObserverEnable = true;
    public static int cfgObserverSize1 = 4;
    public static int cfgObserverSize2 = 32;
    public static int cfgObserverSize3 = 96;
    public static int cfgObserverSize4 = 192;
    public static int cfgObserverSize5 = 320;
    public static int cfgObserverSize6 = 480;
    public static boolean cfgObserverDebug = false;
    public static boolean cfgObserverVerboseDebug = false;

    // General - Crystal Separator
    public static String categorySeparator = "General - Crystal Separator";
    public static boolean cfgSeparatorEnable = true;
    public static boolean cfgSeparatorProcessNonHexcraft = true;
    public static int cfgSeparatorMultiNonHexcraft = 4;
    public static boolean cfgSeparatorProcessChromatiCraft = true;
    public static int cfgSeparatorMultiChromatiCraft = 24;

    // General - Hexorium Tank
    public static String categoryTank = "General - Hexorium Tank";
    public static boolean cfgTankEnable = true;
    public static int cfgTankMaxDimension = 18;
    public static int cfgTankCapacityMultiplier = 16;
    public static int cfgTankKeepFluid = 75;
    public static boolean cfgTankDebug = false;
    public static boolean cfgTankVerboseDebug = false;
    public static boolean cfgTankRenderDebug = false;

    // General - Energy Node
    public static String categoryEnergyNode = "General - Energy Node";
    public static boolean cfgEnergyNodeEnable = true;
    public static boolean cfgEnergyNodeDebug = false;
    public static boolean cfgEnergyNodeVerboseDebug = false;

    // General - Energy Ports
    public static String categoryEnergyPorts = "General - Energy Ports";
    public static boolean cfgEnergyNodePortsRFEnable = true;
    public static boolean cfgEnergyNodePortsRFInputOnly = false;
    public static boolean cfgEnergyNodePortsEUEnable = true;
    public static boolean cfgEnergyNodePortsEUInputOnly = false;
    public static boolean cfgEnergyNodePortsLUEnable = true;
    public static boolean cfgEnergyNodePortsLUInputOnly = false;

    // General - Energy Transfer
    public static String categoryEnergyTransfer = "General - Energy Transfer";
    public static float cfgEnergyTransferLUMinMulti = 0.5F;
    public static float cfgEnergyTransferLUMaxMulti = 2.0F;
    public static int cfgEnergyTransferTier1HEX     = 64;
    public static int cfgEnergyTransferTier2HEX     = 256;
    public static int cfgEnergyTransferTier3HEX     = 1024;
    public static int cfgEnergyTransferTier4HEX     = 4096;
    public static int cfgEnergyTransferTier1RF      = 200;
    public static int cfgEnergyTransferTier2RF      = 800;
    public static int cfgEnergyTransferTier3RF      = 8000;
    public static int cfgEnergyTransferTier4RF      = 32000;
    public static int cfgEnergyTransferTier1EU      = 1;
    public static int cfgEnergyTransferTier2EU      = 2;
    public static int cfgEnergyTransferTier3EU      = 3;
    public static int cfgEnergyTransferTier4EU      = 4;
    public static int cfgEnergyTransferTier1LU      = 32;
    public static int cfgEnergyTransferTier2LU      = 128;
    public static int cfgEnergyTransferTier3LU      = 512;
    public static int cfgEnergyTransferTier4LU      = 2048;

    // General - Energy Conversion
    public static String categoryEnergyConversion = "General - Energy Conversion";
    public static int cfgEnergyBufferMultiplier             = 4;
    public static int cfgEnergyConversionEfficiencyNone     = 50;
    public static int cfgEnergyConversionEfficiencyBasic    = 75;
    public static int cfgEnergyConversionEfficiencyAdvanced = 100;
    public static float cfgEnergyConversionRatioHEXtoRF     = 0.3125F;
    public static float cfgEnergyConversionRatioHEXtoEU     = 0.078125F;
    public static float cfgEnergyConversionRatioHEXtoLU     = 0.078125F;
    public static float cfgEnergyConversionRatioRFtoHEX     = 3.2F;
    public static float cfgEnergyConversionRatioRFtoEU      = 0.25F;
    public static float cfgEnergyConversionRatioRFtoLU      = 0.25F;
    public static float cfgEnergyConversionRatioEUtoHEX     = 12.8F;
    public static float cfgEnergyConversionRatioEUtoRF      = 4F;
    public static float cfgEnergyConversionRatioEUtoLU      = 1F;
    public static float cfgEnergyConversionRatioLUtoHEX     = 12.8F;
    public static float cfgEnergyConversionRatioLUtoRF      = 4F;
    public static float cfgEnergyConversionRatioLUtoEU      = 1F;

    
    
    // Ore Generation
    public static String categoryOre = "Ore Generation";
    public static boolean cfgOreGeneralShouldGenerate = true;
    public static boolean cfgOreOverworldShouldGenerate = true;
    public static boolean cfgOreNetherShouldGenerate = true;
    public static boolean cfgOreOtherShouldGenerate = true;

    // Ore Generation - Overworld
    // Ore Generation - Overworld Ore Red
    public static String categoryOverworldOreRed = "Ore Generation - Overworld Ore Red";
    public static boolean cfgOverworldOreRedShouldGenerate = true;
    public static int cfgOverworldOreRedVeins = 10;
    public static int cfgOverworldOreRedCountMin = 2;
    public static int cfgOverworldOreRedCountMax = 6;
    public static int cfgOverworldOreRedHeightMin = 0;
    public static int cfgOverworldOreRedHeightMax = 64;

    // Ore Generation - Overworld Ore Green
    public static String categoryOverworldOreGreen = "Ore Generation - Overworld Ore Green";
    public static boolean cfgOverworldOreGreenShouldGenerate = true;
    public static int cfgOverworldOreGreenVeins = 10;
    public static int cfgOverworldOreGreenCountMin = 2;
    public static int cfgOverworldOreGreenCountMax = 6;
    public static int cfgOverworldOreGreenHeightMin = 0;
    public static int cfgOverworldOreGreenHeightMax = 64;

    // Ore Generation - Overworld Ore Blue
    public static String categoryOverworldOreBlue = "Ore Generation - Overworld Ore Blue";
    public static boolean cfgOverworldOreBlueShouldGenerate = true;
    public static int cfgOverworldOreBlueVeins = 10;
    public static int cfgOverworldOreBlueCountMin = 2;
    public static int cfgOverworldOreBlueCountMax = 6;
    public static int cfgOverworldOreBlueHeightMin = 0;
    public static int cfgOverworldOreBlueHeightMax = 64;

    // Ore Generation - Overworld Ore White
    public static String categoryOverworldOreWhite = "Ore Generation - Overworld Ore White";
    public static boolean cfgOverworldOreWhiteShouldGenerate = true;
    public static int cfgOverworldOreWhiteVeins = 5;
    public static int cfgOverworldOreWhiteCountMin = 1;
    public static int cfgOverworldOreWhiteCountMax = 3;
    public static int cfgOverworldOreWhiteHeightMin = 0;
    public static int cfgOverworldOreWhiteHeightMax = 20;

    // Ore Generation - Overworld Ore Black
    public static String categoryOverworldOreBlack = "Ore Generation - Overworld Ore Black";
    public static boolean cfgOverworldOreBlackShouldGenerate = true;
    public static int cfgOverworldOreBlackVeins = 5;
    public static int cfgOverworldOreBlackCountMin = 1;
    public static int cfgOverworldOreBlackCountMax = 3;
    public static int cfgOverworldOreBlackHeightMin = 0;
    public static int cfgOverworldOreBlackHeightMax = 20;

    // Ore Generation - Nether
    // Ore Generation - Nether Ore Red
    public static String categoryNetherOreRed = "Ore Generation - Nether Ore Red";
    public static boolean cfgNetherOreRedShouldGenerate = true;
    public static int cfgNetherOreRedVeins = 5;
    public static int cfgNetherOreRedCountMin = 1;
    public static int cfgNetherOreRedCountMax = 3;
    public static int cfgNetherOreRedHeightMin = 0;
    public static int cfgNetherOreRedHeightMax = 127;

    // Ore Generation - Nether Ore Green
    public static String categoryNetherOreGreen = "Ore Generation - Nether Ore Green";
    public static boolean cfgNetherOreGreenShouldGenerate = true;
    public static int cfgNetherOreGreenVeins = 5;
    public static int cfgNetherOreGreenCountMin = 1;
    public static int cfgNetherOreGreenCountMax = 3;
    public static int cfgNetherOreGreenHeightMin = 0;
    public static int cfgNetherOreGreenHeightMax = 127;

    // Ore Generation - Nether Ore Blue
    public static String categoryNetherOreBlue = "Ore Generation - Nether Ore Blue";
    public static boolean cfgNetherOreBlueShouldGenerate = true;
    public static int cfgNetherOreBlueVeins = 5;
    public static int cfgNetherOreBlueCountMin = 1;
    public static int cfgNetherOreBlueCountMax = 3;
    public static int cfgNetherOreBlueHeightMin = 0;
    public static int cfgNetherOreBlueHeightMax = 127;

    // Ore Generation - Nether Ore White
    public static String categoryNetherOreWhite = "Ore Generation - Nether Ore White";
    public static boolean cfgNetherOreWhiteShouldGenerate = true;
    public static int cfgNetherOreWhiteVeins = 10;
    public static int cfgNetherOreWhiteCountMin = 2;
    public static int cfgNetherOreWhiteCountMax = 6;
    public static int cfgNetherOreWhiteHeightMin = 0;
    public static int cfgNetherOreWhiteHeightMax = 127;

    // Ore Generation - Nether Ore Black
    public static String categoryNetherOreBlack = "Ore Generation - Nether Ore Black";
    public static boolean cfgNetherOreBlackShouldGenerate = true;
    public static int cfgNetherOreBlackVeins = 10;
    public static int cfgNetherOreBlackCountMin = 2;
    public static int cfgNetherOreBlackCountMax = 6;
    public static int cfgNetherOreBlackHeightMin = 0;
    public static int cfgNetherOreBlackHeightMax = 127;

    // Ore Generation - Other
    // Ore Generation - Other Ore Red
    public static String categoryOtherOreRed = "Ore Generation - Other Ore Red";
    public static boolean cfgOtherOreRedShouldGenerate = true;
    public static int cfgOtherOreRedVeins = 10;
    public static int cfgOtherOreRedCountMin = 2;
    public static int cfgOtherOreRedCountMax = 6;
    public static int cfgOtherOreRedHeightMin = 0;
    public static int cfgOtherOreRedHeightMax = 64;

    // Ore Generation - Other Ore Green
    public static String categoryOtherOreGreen = "Ore Generation - Other Ore Green";
    public static boolean cfgOtherOreGreenShouldGenerate = true;
    public static int cfgOtherOreGreenVeins = 10;
    public static int cfgOtherOreGreenCountMin = 2;
    public static int cfgOtherOreGreenCountMax = 6;
    public static int cfgOtherOreGreenHeightMin = 0;
    public static int cfgOtherOreGreenHeightMax = 64;

    // Ore Generation - Other Ore Blue
    public static String categoryOtherOreBlue = "Ore Generation - Other Ore Blue";
    public static boolean cfgOtherOreBlueShouldGenerate = true;
    public static int cfgOtherOreBlueVeins = 10;
    public static int cfgOtherOreBlueCountMin = 2;
    public static int cfgOtherOreBlueCountMax = 6;
    public static int cfgOtherOreBlueHeightMin = 0;
    public static int cfgOtherOreBlueHeightMax = 64;

    // Ore Generation - Other Ore White
    public static String categoryOtherOreWhite = "Ore Generation - Other Ore White";
    public static boolean cfgOtherOreWhiteShouldGenerate = true;
    public static int cfgOtherOreWhiteVeins = 5;
    public static int cfgOtherOreWhiteCountMin = 1;
    public static int cfgOtherOreWhiteCountMax = 3;
    public static int cfgOtherOreWhiteHeightMin = 0;
    public static int cfgOtherOreWhiteHeightMax = 20;

    // Ore Generation - Other Ore Black
    public static String categoryOtherOreBlack = "Ore Generation - Other Ore Black";
    public static boolean cfgOtherOreBlackShouldGenerate = true;
    public static int cfgOtherOreBlackVeins = 5;
    public static int cfgOtherOreBlackCountMin = 1;
    public static int cfgOtherOreBlackCountMax = 3;
    public static int cfgOtherOreBlackHeightMin = 0;
    public static int cfgOtherOreBlackHeightMax = 20;



    // Monolith Generation
    public static String categoryMonolith = "Monolith Generation";
    public static boolean cfgMonolithGeneralShouldGenerate = true;
    public static boolean cfgMonolithNetherShouldGenerate = true;
    public static boolean cfgMonolithOverworldShouldGenerate = true;
    public static boolean cfgMonolithOtherShouldGenerate = true;

    // Monolith Generation - Overworld
    // Monolith Generation - Overworld Monolith Red
    public static String categoryOverworldMonolithRed = "Monolith Generation - Overworld Monolith Red";
    public static boolean cfgOverworldMonolithRedShouldGenerate = true;
    public static int cfgOverworldMonolithRedChance = 100;
    public static int cfgOverworldMonolithRedCount = 1;
    public static int cfgOverworldMonolithRedHeightMin = 0;
    public static int cfgOverworldMonolithRedHeightMax = 60;

    // Monolith Generation - Overworld Monolith Green
    public static String categoryOverworldMonolithGreen = "Monolith Generation - Overworld Monolith Green";
    public static boolean cfgOverworldMonolithGreenShouldGenerate = true;
    public static int cfgOverworldMonolithGreenChance = 100;
    public static int cfgOverworldMonolithGreenCount = 1;
    public static int cfgOverworldMonolithGreenHeightMin = 0;
    public static int cfgOverworldMonolithGreenHeightMax = 60;

    // Monolith Generation - Overworld Monolith Blue
    public static String categoryOverworldMonolithBlue = "Monolith Generation - Overworld Monolith Blue";
    public static boolean cfgOverworldMonolithBlueShouldGenerate = true;
    public static int cfgOverworldMonolithBlueChance = 100;
    public static int cfgOverworldMonolithBlueCount = 1;
    public static int cfgOverworldMonolithBlueHeightMin = 0;
    public static int cfgOverworldMonolithBlueHeightMax = 60;

    // Monolith Generation - Overworld Monolith White
    public static String categoryOverworldMonolithWhite = "Monolith Generation - Overworld Monolith White";
    public static boolean cfgOverworldMonolithWhiteShouldGenerate = true;
    public static int cfgOverworldMonolithWhiteChance = 10;
    public static int cfgOverworldMonolithWhiteCount = 1;
    public static int cfgOverworldMonolithWhiteHeightMin = 0;
    public static int cfgOverworldMonolithWhiteHeightMax = 20;

    // Monolith Generation - Overworld Monolith Black
    public static String categoryOverworldMonolithBlack = "Monolith Generation - Overworld Monolith Black";
    public static boolean cfgOverworldMonolithBlackShouldGenerate = true;
    public static int cfgOverworldMonolithBlackChance = 10;
    public static int cfgOverworldMonolithBlackCount = 1;
    public static int cfgOverworldMonolithBlackHeightMin = 0;
    public static int cfgOverworldMonolithBlackHeightMax = 20;

    // Monolith Generation - Nether
    // Monolith Generation - Nether Monolith Red
    public static String categoryNetherMonolithRed = "Monolith Generation - Nether Monolith Red";
    public static boolean cfgNetherMonolithRedShouldGenerate = true;
    public static int cfgNetherMonolithRedChance = 10;
    public static int cfgNetherMonolithRedCount = 1;
    public static int cfgNetherMonolithRedHeightMin = 0;
    public static int cfgNetherMonolithRedHeightMax = 127;

    // Monolith Generation - Nether Monolith Green
    public static String categoryNetherMonolithGreen = "Monolith Generation - Nether Monolith Green";
    public static boolean cfgNetherMonolithGreenShouldGenerate = true;
    public static int cfgNetherMonolithGreenChance = 10;
    public static int cfgNetherMonolithGreenCount = 1;
    public static int cfgNetherMonolithGreenHeightMin = 0;
    public static int cfgNetherMonolithGreenHeightMax = 127;

    // Monolith Generation - Nether Monolith Blue
    public static String categoryNetherMonolithBlue = "Monolith Generation - Nether Monolith Blue";
    public static boolean cfgNetherMonolithBlueShouldGenerate = true;
    public static int cfgNetherMonolithBlueChance = 10;
    public static int cfgNetherMonolithBlueCount = 1;
    public static int cfgNetherMonolithBlueHeightMin = 0;
    public static int cfgNetherMonolithBlueHeightMax = 127;

    // Monolith Generation - Nether Monolith White
    public static String categoryNetherMonolithWhite = "Monolith Generation - Nether Monolith White";
    public static boolean cfgNetherMonolithWhiteShouldGenerate = true;
    public static int cfgNetherMonolithWhiteChance = 50;
    public static int cfgNetherMonolithWhiteCount = 1;
    public static int cfgNetherMonolithWhiteHeightMin = 0;
    public static int cfgNetherMonolithWhiteHeightMax = 127;

    // Monolith Generation - Nether Monolith Black
    public static String categoryNetherMonolithBlack = "Monolith Generation - Nether Monolith Black";
    public static boolean cfgNetherMonolithBlackShouldGenerate = true;
    public static int cfgNetherMonolithBlackChance = 50;
    public static int cfgNetherMonolithBlackCount = 1;
    public static int cfgNetherMonolithBlackHeightMin = 0;
    public static int cfgNetherMonolithBlackHeightMax = 127;

    // Monolith Generation - Other
    // Monolith Generation - Other Monolith Red
    public static String categoryOtherMonolithRed = "Monolith Generation - Other Monolith Red";
    public static boolean cfgOtherMonolithRedShouldGenerate = true;
    public static int cfgOtherMonolithRedChance = 100;
    public static int cfgOtherMonolithRedCount = 1;
    public static int cfgOtherMonolithRedHeightMin = 0;
    public static int cfgOtherMonolithRedHeightMax = 60;

    // Monolith Generation - Other Monolith Green
    public static String categoryOtherMonolithGreen = "Monolith Generation - Other Monolith Green";
    public static boolean cfgOtherMonolithGreenShouldGenerate = true;
    public static int cfgOtherMonolithGreenChance = 100;
    public static int cfgOtherMonolithGreenCount = 1;
    public static int cfgOtherMonolithGreenHeightMin = 0;
    public static int cfgOtherMonolithGreenHeightMax = 60;

    // Monolith Generation - Other Monolith Blue
    public static String categoryOtherMonolithBlue = "Monolith Generation - Other Monolith Blue";
    public static boolean cfgOtherMonolithBlueShouldGenerate = true;
    public static int cfgOtherMonolithBlueChance = 100;
    public static int cfgOtherMonolithBlueCount = 1;
    public static int cfgOtherMonolithBlueHeightMin = 0;
    public static int cfgOtherMonolithBlueHeightMax = 60;

    // Monolith Generation - Other Monolith White
    public static String categoryOtherMonolithWhite = "Monolith Generation - Other Monolith White";
    public static boolean cfgOtherMonolithWhiteShouldGenerate = true;
    public static int cfgOtherMonolithWhiteChance = 10;
    public static int cfgOtherMonolithWhiteCount = 1;
    public static int cfgOtherMonolithWhiteHeightMin = 0;
    public static int cfgOtherMonolithWhiteHeightMax = 20;

    // Monolith Generation - Other Monolith Black
    public static String categoryOtherMonolithBlack = "Monolith Generation - Other Monolith Black";
    public static boolean cfgOtherMonolithBlackShouldGenerate = true;
    public static int cfgOtherMonolithBlackChance = 10;
    public static int cfgOtherMonolithBlackCount = 1;
    public static int cfgOtherMonolithBlackHeightMin = 0;
    public static int cfgOtherMonolithBlackHeightMax = 20;

    /**
     * Initializes all block and adds them to GameRegistry.
     */
    public static void initializeConfig(FMLPreInitializationEvent event) {
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();

        // General
        config.setCategoryComment(Configuration.CATEGORY_GENERAL, "General configuration for different machines and details of the mod.");
        cfgGeneralNetworkDebug = config.getBoolean("HEX Energy Network debugging", Configuration.CATEGORY_GENERAL, cfgGeneralNetworkDebug, "If set to true, will output the HEX Energy Network connections between machines to console\nupon scanning.\n");
        cfgGeneralVerboseNetworkDebug = config.getBoolean("HEX Energy Network debugging (verbose)", Configuration.CATEGORY_GENERAL, cfgGeneralVerboseNetworkDebug, "If set to true, will output extremely detailed path of machine scanning. HEX Energy Network\ndebugging needs to be enabled.\n");
        cfgGeneralMachineNetworkDebug = config.getBoolean("HEX Energy Network debugging (machines)", Configuration.CATEGORY_GENERAL, cfgGeneralMachineNetworkDebug, "If set to true, will output details about machine communication. Will get very spammy while\nenergy sources are being drained. HEX Energy Network debugging needs to be enabled.\n");
        cfgGeneralPylonRange = config.getInt("Energy Pylon link range", Configuration.CATEGORY_GENERAL, cfgGeneralPylonRange, 2, 64, "The maximum range at which Energy Pylong can be linked.\n");
        cfgGeneralUseAchievements = config.getBoolean("Use achievements", Configuration.CATEGORY_GENERAL, cfgGeneralUseAchievements, "If set to true, HEXCraft will use an achievement system.\n");
        cfgFurnaceEnable = config.getBoolean("Enable Hexorium Furnace", Configuration.CATEGORY_GENERAL, cfgFurnaceEnable, "Enables the Hexorium Furnace block.\n");
        cfgGeneralTransposerAttack = config.getBoolean("Molecular Transposer can attack", Configuration.CATEGORY_GENERAL, cfgGeneralTransposerAttack, "Determines if the Molecular Transposer can be used to attack entities.\n");
        cfgGeneralTransposerAttackPlayers = config.getBoolean("Molecular Transposer can attack players", Configuration.CATEGORY_GENERAL, cfgGeneralTransposerAttackPlayers, "Determines if the Molecular Transposer can be used to attack players. Attacking of all\nentities has to be enabled first.\n");
        cfgGeneralTransposerAttackDamage = config.getInt("Molecular Transposer attack damage", Configuration.CATEGORY_GENERAL, cfgGeneralTransposerAttackDamage, 1, 100, "The amount of damage Molecular Transposer deals, 2 equals 1 heart.\n");
        cfgGeneralMonolithGlowstoneLightLevel = config.getInt("Monolith Glowstone Light Level", Configuration.CATEGORY_GENERAL, cfgGeneralMonolithGlowstoneLightLevel, 0, 15, "The light level which Energized Hexorium Monoliths will emit when Glowstone is added to them.\n");
        cfgGeneralFlickerFix = config.getFloat("Flicker Fix", Configuration.CATEGORY_GENERAL, cfgGeneralFlickerFix, 0.000F, 0.010F, "While the rendering of the mod should pose no problems, certain mods which modify the rendering may break it and cause flickering of the textures.\nThis value introduces a slight offset to the inner glowing block texture to compensate. A very low value like 0.005 is suggested.\n");


        // General - Personal Teleportation Pad
        config.setCategoryComment(categoryTeleport, "Configuration for the Personal Teleportation Pad.");
        cfgTeleportEnable = config.getBoolean("Enable Personal Teleportation Pad", categoryTeleport, cfgTeleportEnable, "Enables the Personal Teleportation Pad block.\n");
        cfgTeleportShouldDamagePlayers = config.getBoolean("Teleport should damage", categoryTeleport, cfgTeleportShouldDamagePlayers, "If the teleportation should damage players and apply the potion effect.\n");
        cfgTeleportDamageAmount = config.getInt("Teleport damage amount", categoryTeleport, cfgTeleportDamageAmount, 1, 20, "The amount of damage teleportation deals, 2 equals 1 heart.\n");
        cfgTeleportUsageCost = config.getInt("Teleport usage cost", categoryTeleport, cfgTeleportUsageCost, 1, 1628400, "The cost of a single teleport, 51200 equals one Coal.\n");


        // General - Quantum Observer
        config.setCategoryComment(categoryObserver, "Configuration for the Quantum Observer (Chunk Loader).");
        cfgObserverEnable = config.getBoolean("Enable Quantum Observer", categoryObserver, cfgObserverEnable, "Enables the Quantum Observer and Quantum Anchor blocks.\n");
        cfgObserverSize1 = config.getInt("1x1 chunk loading usage cost", categoryObserver, cfgObserverSize1, 1, 3840, "The HEX/t usage when loading 1x1 chunks.\n");
        cfgObserverSize2 = config.getInt("3x3 chunk loading usage cost", categoryObserver, cfgObserverSize2, 1, 3840, "The HEX/t usage when loading 3x3 chunks.\n");
        cfgObserverSize3 = config.getInt("5x5 chunk loading usage cost", categoryObserver, cfgObserverSize3, 1, 3840, "The HEX/t usage when loading 5x5 chunks.\n");
        cfgObserverSize4 = config.getInt("7x7 chunk loading usage cost", categoryObserver, cfgObserverSize4, 1, 3840, "The HEX/t usage when loading 7x7 chunks.\n");
        cfgObserverSize5 = config.getInt("9x9 chunk loading usage cost", categoryObserver, cfgObserverSize5, 1, 3840, "The HEX/t usage when loading 9x9 chunks.\n");
        cfgObserverSize6 = config.getInt("11x11 chunk loading usage cost", categoryObserver, cfgObserverSize6, 1, 3840, "The HEX/t usage when loading 11x11 chunks.\n");
        cfgObserverDebug = config.getBoolean("Quantum Observer debugging", categoryObserver, cfgObserverDebug, "If set to true, will output the Quantum Observer debugging to console.\n");
        cfgObserverVerboseDebug = config.getBoolean("Quantum Observer debugging (verbose)", categoryObserver, cfgObserverVerboseDebug, "If set to true, will output extremely detailed Quantum Observer debugging info. Quantum Observer\ndebugging needs to be enabled.\n");

        // General - Crystal Separator
        config.setCategoryComment(categorySeparator, "Configuration for the Crystal Separator.");
        cfgSeparatorEnable = config.getBoolean("Enable Crystal Separator", categorySeparator, cfgSeparatorEnable, "Enables the Crystal Separator block.\n");
        cfgSeparatorProcessNonHexcraft = config.getBoolean("Process Non-Hexcraft ores", categorySeparator, cfgSeparatorProcessNonHexcraft, "Enables processing of crystal ores other than HEXCraft ones.\n");
        cfgSeparatorMultiNonHexcraft = config.getInt("Non-Hexcraft multiplier", categorySeparator, cfgSeparatorMultiNonHexcraft, 1, 64, "The number of crystals gained when processing ores from other mods and vanilla.\n");
        cfgSeparatorProcessChromatiCraft = config.getBoolean("Process Chromaticraft crystals", categorySeparator, cfgSeparatorProcessChromatiCraft, "Enables processing of ChromatiCraft Cave Crystals.\nNOTE: If 'Process Non-Hexcraft ores' is disabled, this is disabled as well.\n");
        cfgSeparatorMultiChromatiCraft = config.getInt("Chromaticraft multiplier", categorySeparator, cfgSeparatorMultiChromatiCraft, 1, 64, "The number of ChromatiCraft Crystal Shards gained when processing one whole Cave Crystal.\n");

        // General - Hexorium Tank
        config.setCategoryComment(categoryTank, "Configuration for the Hexorium Tank multiblock structure.");
        cfgTankEnable = config.getBoolean("Enable Hexorium Tank", categoryTank, cfgTankEnable, "Enables the Hexorium Tank multiblock structure.\n");
        cfgTankMaxDimension = config.getInt("Hexorium Tank size limit", categoryTank, cfgTankMaxDimension, 3, 18, "The maximum outer size of the Hexorium Tank.\n");
        cfgTankCapacityMultiplier = config.getInt("Hexorium Tank capacity multiplier", categoryTank, cfgTankCapacityMultiplier, 1, 256, "Number of buckets per internal block of the tank.\n");
        cfgTankKeepFluid = config.getInt("Percentage of fluid to recover", categoryTank, cfgTankKeepFluid, 0, 100, "The percentage of fluid that will be recovered when the tank is broken and re-formed. Set\nto 0 to disable.\n");
        cfgTankDebug = config.getBoolean("Hexorium Tank debugging", categoryTank, cfgTankDebug, "If set to true, will output the Hexorium Tank debugging to console.\n");
        cfgTankVerboseDebug = config.getBoolean("Hexorium Tank debugging (verbose)", categoryTank, cfgTankVerboseDebug, "If set to true, will output extremely detailed Hexorium Tank debugging info. Hexorium Tank\ndebugging needs to be enabled.\n");
        cfgTankRenderDebug = config.getBoolean("Hexorium Tank debugging (rendering)", categoryTank, cfgTankRenderDebug, "If set to true, will show a small cube where the center of the tank rendering tile entity\nis located.\n");

        // General - Energy Node
        config.setCategoryComment(categoryEnergyNode, "Configuration for the Energy Node multiblock structure.");
        cfgEnergyNodeEnable = config.getBoolean("Enable Energy Node", categoryEnergyNode, cfgEnergyNodeEnable, "Enables the Energy Node multiblock structure.\n");
        cfgEnergyNodeEnable = config.getBoolean("Enable Energy Node", categoryEnergyNode, cfgEnergyNodeEnable, "Enables the Energy Node multiblock structure.\n");
        cfgEnergyNodeDebug = config.getBoolean("Energy Node debugging", categoryEnergyNode, cfgEnergyNodeDebug, "If set to true, will output the Energy Node debugging to console.\n");
        cfgEnergyNodeVerboseDebug = config.getBoolean("Energy Node debugging (verbose)", categoryEnergyNode, cfgEnergyNodeVerboseDebug, "If set to true, will output extremely detailed Energy Node debugging info. Energy Node\ndebugging needs to be enabled.\n");

        // General - Energy Ports
        config.setCategoryComment(categoryEnergyPorts, "Configuration for the Energy Node ports.");
        cfgEnergyNodePortsRFEnable = config.getBoolean("Enable Energy Node Port: RF", categoryEnergyPorts, cfgEnergyNodePortsRFEnable, "Enables the RF Port for the Energy Node.\n");
        cfgEnergyNodePortsEUEnable = config.getBoolean("Enable Energy Node Port: EU", categoryEnergyPorts, cfgEnergyNodePortsRFEnable, "Enables the EU Port for the Energy Node.\nNOTE: If you don't have IndustrialCraft 2, the port is automatically disabled.\n");
        cfgEnergyNodePortsLUEnable = config.getBoolean("Enable Energy Node Port: LU", categoryEnergyPorts, cfgEnergyNodePortsRFEnable, "Enables the LU Port for the Energy Node.\nNOTE: If you don't have GregTech 6, the port is automatically disabled.\n");
        cfgEnergyNodePortsRFInputOnly = config.getBoolean("Input only on RF Port", categoryEnergyPorts, cfgEnergyNodePortsRFInputOnly, "If enabled, the RF Port for the Energy Node can only be used in input mode.\nNOTE: If the port is already in output mode placed in the world, it won't automatically switch.\n");
        cfgEnergyNodePortsEUInputOnly = config.getBoolean("Input only on EU Port", categoryEnergyPorts, cfgEnergyNodePortsEUInputOnly, "If enabled, the EU Port for the Energy Node can only be used in input mode.\nNOTE: If the port is already in output mode placed in the world, it won't automatically switch.\n");
        cfgEnergyNodePortsLUInputOnly = config.getBoolean("Input only on LU Port", categoryEnergyPorts, cfgEnergyNodePortsEUInputOnly, "If enabled, the LU Port for the Energy Node can only be used in input mode.\nNOTE: If the port is already in output mode placed in the world, it won't automatically switch.\n");

        // General - Energy Transfer
        config.setCategoryComment(categoryEnergyTransfer, "Configuration for the energy per tick rates of different tiers and ports.\nNote that the HEX setting are only applied when a HEX port is paired with a HEX port.");
        cfgEnergyTransferLUMinMulti = config.getFloat("Minimum LU input multiplier:", categoryEnergyTransfer, cfgEnergyTransferLUMinMulti, 0.0F, 10.0F, "");
        cfgEnergyTransferLUMaxMulti = config.getFloat("Maximum LU input multiplier:", categoryEnergyTransfer, cfgEnergyTransferLUMaxMulti, 0.0F, 10.0F, "");
        cfgEnergyTransferTier1HEX = config.getInt("HEX/t Tier 1:", categoryEnergyTransfer, cfgEnergyTransferTier1HEX, 0, 640000, "");
        cfgEnergyTransferTier2HEX = config.getInt("HEX/t Tier 2:", categoryEnergyTransfer, cfgEnergyTransferTier2HEX, 0, 640000, "");
        cfgEnergyTransferTier3HEX = config.getInt("HEX/t Tier 3:", categoryEnergyTransfer, cfgEnergyTransferTier3HEX, 0, 640000, "");
        cfgEnergyTransferTier4HEX = config.getInt("HEX/t Tier 4:", categoryEnergyTransfer, cfgEnergyTransferTier4HEX, 0, 640000, "");
        cfgEnergyTransferTier1RF = config.getInt("RF/t Tier 1:", categoryEnergyTransfer, cfgEnergyTransferTier1RF, 0, 640000, "");
        cfgEnergyTransferTier2RF = config.getInt("RF/t Tier 2:", categoryEnergyTransfer, cfgEnergyTransferTier2RF, 0, 640000, "");
        cfgEnergyTransferTier3RF = config.getInt("RF/t Tier 3:", categoryEnergyTransfer, cfgEnergyTransferTier3RF, 0, 640000, "");
        cfgEnergyTransferTier4RF = config.getInt("RF/t Tier 4:", categoryEnergyTransfer, cfgEnergyTransferTier4RF, 0, 640000, "");
        cfgEnergyTransferTier1EU = config.getInt("EU Tier 1 Power:", categoryEnergyTransfer, cfgEnergyTransferTier1EU, 1, 13, "LV: 1\nMV: 2\nHV: 3\nEV: 4\nIV: 5\nThere may be more...");
        cfgEnergyTransferTier2EU = config.getInt("EU Tier 2 Power:", categoryEnergyTransfer, cfgEnergyTransferTier2EU, 1, 13, "");
        cfgEnergyTransferTier3EU = config.getInt("EU Tier 3 Power:", categoryEnergyTransfer, cfgEnergyTransferTier3EU, 1, 13, "");
        cfgEnergyTransferTier4EU = config.getInt("EU Tier 4 Power:", categoryEnergyTransfer, cfgEnergyTransferTier4EU, 1, 13, "");
        cfgEnergyTransferTier1LU = config.getInt("LU/t Tier 1:", categoryEnergyTransfer, cfgEnergyTransferTier1LU, 0, 640000, "");
        cfgEnergyTransferTier2LU = config.getInt("LU/t Tier 2:", categoryEnergyTransfer, cfgEnergyTransferTier2LU, 0, 640000, "");
        cfgEnergyTransferTier3LU = config.getInt("LU/t Tier 3:", categoryEnergyTransfer, cfgEnergyTransferTier3LU, 0, 640000, "");
        cfgEnergyTransferTier4LU = config.getInt("LU/t Tier 4:", categoryEnergyTransfer, cfgEnergyTransferTier4LU, 0, 640000, "");

        // General - Energy Conversion
        config.setCategoryComment(categoryEnergyConversion, "Configuration for the loss and conversion ratios of the Energy Node.");
        cfgEnergyBufferMultiplier = config.getInt("Buffer Multiplier:", categoryEnergyConversion, cfgEnergyBufferMultiplier, 1, 32, "Multiplier which is used to calculate the buffer size in ports.\nThe energy/tick value is multiplied with this value to get the buffer size..");
        cfgEnergyConversionEfficiencyNone = config.getInt("Efficiency None:", categoryEnergyConversion, cfgEnergyConversionEfficiencyNone, 0, 100, "Efficiency without any Conversion Computer installed.");
        cfgEnergyConversionEfficiencyBasic = config.getInt("Efficiency Basic:", categoryEnergyConversion, cfgEnergyConversionEfficiencyBasic, 0, 100, "Efficiency with a Basic Conversion Computer installed.");
        cfgEnergyConversionEfficiencyAdvanced = config.getInt("Efficiency Advanced:", categoryEnergyConversion, cfgEnergyConversionEfficiencyAdvanced, 0, 100, "Efficiency with an Advanced Conversion Computer installed.");
        cfgEnergyConversionRatioHEXtoRF = config.getFloat("Conversion ratio: HEX -> RF ", categoryEnergyConversion, cfgEnergyConversionRatioHEXtoRF, 0.0001F, 128, "");
        cfgEnergyConversionRatioHEXtoEU = config.getFloat("Conversion ratio: HEX -> EU ", categoryEnergyConversion, cfgEnergyConversionRatioHEXtoEU, 0.0001F, 128, "");
        cfgEnergyConversionRatioHEXtoLU = config.getFloat("Conversion ratio: HEX -> LU ", categoryEnergyConversion, cfgEnergyConversionRatioHEXtoLU, 0.0001F, 128, "");
        cfgEnergyConversionRatioRFtoHEX = config.getFloat("Conversion ratio: RF  -> HEX", categoryEnergyConversion, cfgEnergyConversionRatioRFtoHEX, 0.0001F, 128, "");
        cfgEnergyConversionRatioRFtoEU  = config.getFloat("Conversion ratio: RF  -> EU ", categoryEnergyConversion, cfgEnergyConversionRatioRFtoEU, 0.0001F, 128, "");
        cfgEnergyConversionRatioRFtoLU  = config.getFloat("Conversion ratio: RF  -> LU ", categoryEnergyConversion, cfgEnergyConversionRatioRFtoLU, 0.0001F, 128, "");
        cfgEnergyConversionRatioEUtoHEX = config.getFloat("Conversion ratio: EU  -> HEX", categoryEnergyConversion, cfgEnergyConversionRatioEUtoHEX, 0.0001F, 128, "");
        cfgEnergyConversionRatioEUtoRF  = config.getFloat("Conversion ratio: EU  -> RF ", categoryEnergyConversion, cfgEnergyConversionRatioEUtoRF, 0.0001F, 128, "");
        cfgEnergyConversionRatioEUtoLU  = config.getFloat("Conversion ratio: EU  -> LU ", categoryEnergyConversion, cfgEnergyConversionRatioEUtoLU, 0.0001F, 128, "");
        cfgEnergyConversionRatioLUtoHEX = config.getFloat("Conversion ratio: LU  -> HEX", categoryEnergyConversion, cfgEnergyConversionRatioLUtoHEX, 0.0001F, 128, "");
        cfgEnergyConversionRatioLUtoRF  = config.getFloat("Conversion ratio: LU  -> RF ", categoryEnergyConversion, cfgEnergyConversionRatioLUtoRF, 0.0001F, 128, "");
        cfgEnergyConversionRatioLUtoEU  = config.getFloat("Conversion ratio: LU  -> EU ", categoryEnergyConversion, cfgEnergyConversionRatioLUtoEU, 0.0001F, 128, "");



        // Ore Generation
        config.setCategoryComment(categoryOre, "Configuration for ore generation. The ore gen can be completely disabled, or\nconfigured per dimension and ore.");
        cfgOreGeneralShouldGenerate = config.getBoolean("Generate ores", categoryOre, cfgOreGeneralShouldGenerate, "If ore generator should be working at all. Setting this to false disables ALL ore generation.\nIgnores ore and dimension-specific settings.\n");
        cfgOreNetherShouldGenerate = config.getBoolean("Generate Nether ores", categoryOre, cfgOreNetherShouldGenerate, "If ores should be generating in the Nether. Setting this to false disables ALL ore generation\nin the Nether. Ignores ore-specific settings.\n");
        cfgOreOverworldShouldGenerate = config.getBoolean("Generate Overworld ores", categoryOre, cfgOreOverworldShouldGenerate, "If ores should be generating in the Overworld. Setting this to false disables ALL ore generation\nin the Overworld. Ignores ore-specific settings.\n");
        cfgOreOtherShouldGenerate = config.getBoolean("Generate Other ores", categoryOre, cfgOreOtherShouldGenerate, "If ores should be generating in other dimensions. Setting this to false disables ALL ore\ngeneration in other dimensions. Ignores ore-specific settings.\n");

        // Ore Generation - Overworld
        // Ore Generation - Overworld Ore Red
        cfgOverworldOreRedShouldGenerate = config.getBoolean("Generate ores", categoryOverworldOreRed, cfgOverworldOreRedShouldGenerate, "");
        cfgOverworldOreRedVeins = config.getInt("Veins per chunk", categoryOverworldOreRed, cfgOverworldOreRedVeins, 1, 64, "");
        cfgOverworldOreRedCountMin = config.getInt("Ores per vein (Min)", categoryOverworldOreRed, cfgOverworldOreRedCountMin, 1, 64, "");
        cfgOverworldOreRedCountMax = config.getInt("Ores per vein (Max)", categoryOverworldOreRed, cfgOverworldOreRedCountMax, 1, 64, "");
        cfgOverworldOreRedHeightMin = config.getInt("Height (Min)", categoryOverworldOreRed, cfgOverworldOreRedHeightMin, 0, 255, "");
        cfgOverworldOreRedHeightMax = config.getInt("Height (Max)", categoryOverworldOreRed, cfgOverworldOreRedHeightMax, 0, 255, "");

        // Ore Generation - Overworld Ore Green
        cfgOverworldOreGreenShouldGenerate = config.getBoolean("Generate ores", categoryOverworldOreGreen, cfgOverworldOreGreenShouldGenerate, "");
        cfgOverworldOreGreenVeins = config.getInt("Veins per chunk", categoryOverworldOreGreen, cfgOverworldOreGreenVeins, 1, 64, "");
        cfgOverworldOreGreenCountMin = config.getInt("Ores per vein (Min)", categoryOverworldOreGreen, cfgOverworldOreGreenCountMin, 1, 64, "");
        cfgOverworldOreGreenCountMax = config.getInt("Ores per vein (Max)", categoryOverworldOreGreen, cfgOverworldOreGreenCountMax, 1, 64, "");
        cfgOverworldOreGreenHeightMin = config.getInt("Height (Min)", categoryOverworldOreGreen, cfgOverworldOreGreenHeightMin, 0, 255, "");
        cfgOverworldOreGreenHeightMax = config.getInt("Height (Max)", categoryOverworldOreGreen, cfgOverworldOreGreenHeightMax, 0, 255, "");

        // Ore Generation - Overworld Ore Blue
        cfgOverworldOreBlueShouldGenerate = config.getBoolean("Generate ores", categoryOverworldOreBlue, cfgOverworldOreBlueShouldGenerate, "");
        cfgOverworldOreBlueVeins = config.getInt("Veins per chunk", categoryOverworldOreBlue, cfgOverworldOreBlueVeins, 1, 64, "");
        cfgOverworldOreBlueCountMin = config.getInt("Ores per vein (Min)", categoryOverworldOreBlue, cfgOverworldOreBlueCountMin, 1, 64, "");
        cfgOverworldOreBlueCountMax = config.getInt("Ores per vein (Max)", categoryOverworldOreBlue, cfgOverworldOreBlueCountMax, 1, 64, "");
        cfgOverworldOreBlueHeightMin = config.getInt("Height (Min)", categoryOverworldOreBlue, cfgOverworldOreBlueHeightMin, 0, 255, "");
        cfgOverworldOreBlueHeightMax = config.getInt("Height (Max)", categoryOverworldOreBlue, cfgOverworldOreBlueHeightMax, 0, 255, "");

        // Ore Generation - Overworld Ore White
        cfgOverworldOreWhiteShouldGenerate = config.getBoolean("Generate ores", categoryOverworldOreWhite, cfgOverworldOreWhiteShouldGenerate, "");
        cfgOverworldOreWhiteVeins = config.getInt("Veins per chunk", categoryOverworldOreWhite, cfgOverworldOreWhiteVeins, 1, 64, "");
        cfgOverworldOreWhiteCountMin = config.getInt("Ores per vein (Min)", categoryOverworldOreWhite, cfgOverworldOreWhiteCountMin, 1, 64, "");
        cfgOverworldOreWhiteCountMax = config.getInt("Ores per vein (Max)", categoryOverworldOreWhite, cfgOverworldOreWhiteCountMax, 1, 64, "");
        cfgOverworldOreWhiteHeightMin = config.getInt("Height (Min)", categoryOverworldOreWhite, cfgOverworldOreWhiteHeightMin, 0, 255, "");
        cfgOverworldOreWhiteHeightMax = config.getInt("Height (Max)", categoryOverworldOreWhite, cfgOverworldOreWhiteHeightMax, 0, 255, "");

        // Ore Generation - Overworld Ore Black
        cfgOverworldOreBlackShouldGenerate = config.getBoolean("Generate ores", categoryOverworldOreBlack, cfgOverworldOreBlackShouldGenerate, "");
        cfgOverworldOreBlackVeins = config.getInt("Veins per chunk", categoryOverworldOreBlack, cfgOverworldOreBlackVeins, 1, 64, "");
        cfgOverworldOreBlackCountMin = config.getInt("Ores per vein (Min)", categoryOverworldOreBlack, cfgOverworldOreBlackCountMin, 1, 64, "");
        cfgOverworldOreBlackCountMax = config.getInt("Ores per vein (Max)", categoryOverworldOreBlack, cfgOverworldOreBlackCountMax, 1, 64, "");
        cfgOverworldOreBlackHeightMin = config.getInt("Height (Min)", categoryOverworldOreBlack, cfgOverworldOreBlackHeightMin, 0, 255, "");
        cfgOverworldOreBlackHeightMax = config.getInt("Height (Max)", categoryOverworldOreBlack, cfgOverworldOreBlackHeightMax, 0, 255, "");

        // Ore Generation - Nether
        // Ore Generation - Nether Ore Red
        cfgNetherOreRedShouldGenerate = config.getBoolean("Generate ores", categoryNetherOreRed, cfgNetherOreRedShouldGenerate, "");
        cfgNetherOreRedVeins = config.getInt("Veins per chunk", categoryNetherOreRed, cfgNetherOreRedVeins, 1, 64, "");
        cfgNetherOreRedCountMin = config.getInt("Ores per vein (Min)", categoryNetherOreRed, cfgNetherOreRedCountMin, 1, 64, "");
        cfgNetherOreRedCountMax = config.getInt("Ores per vein (Max)", categoryNetherOreRed, cfgNetherOreRedCountMax, 1, 64, "");
        cfgNetherOreRedHeightMin = config.getInt("Height (Min)", categoryNetherOreRed, cfgNetherOreRedHeightMin, 0, 127, "");
        cfgNetherOreRedHeightMax = config.getInt("Height (Max)", categoryNetherOreRed, cfgNetherOreRedHeightMax, 0, 127, "");

        // Ore Generation - Nether Ore Green
        cfgNetherOreGreenShouldGenerate = config.getBoolean("Generate ores", categoryNetherOreGreen, cfgNetherOreGreenShouldGenerate, "");
        cfgNetherOreGreenVeins = config.getInt("Veins per chunk", categoryNetherOreGreen, cfgNetherOreGreenVeins, 1, 64, "");
        cfgNetherOreGreenCountMin = config.getInt("Ores per vein (Min)", categoryNetherOreGreen, cfgNetherOreGreenCountMin, 1, 64, "");
        cfgNetherOreGreenCountMax = config.getInt("Ores per vein (Max)", categoryNetherOreGreen, cfgNetherOreGreenCountMax, 1, 64, "");
        cfgNetherOreGreenHeightMin = config.getInt("Height (Min)", categoryNetherOreGreen, cfgNetherOreGreenHeightMin, 0, 127, "");
        cfgNetherOreGreenHeightMax = config.getInt("Height (Max)", categoryNetherOreGreen, cfgNetherOreGreenHeightMax, 0, 127, "");

        // Ore Generation - Nether Ore Blue
        cfgNetherOreBlueShouldGenerate = config.getBoolean("Generate ores", categoryNetherOreBlue, cfgNetherOreBlueShouldGenerate, "");
        cfgNetherOreBlueVeins = config.getInt("Veins per chunk", categoryNetherOreBlue, cfgNetherOreBlueVeins, 1, 64, "");
        cfgNetherOreBlueCountMin = config.getInt("Ores per vein (Min)", categoryNetherOreBlue, cfgNetherOreBlueCountMin, 1, 64, "");
        cfgNetherOreBlueCountMax = config.getInt("Ores per vein (Max)", categoryNetherOreBlue, cfgNetherOreBlueCountMax, 1, 64, "");
        cfgNetherOreBlueHeightMin = config.getInt("Height (Min)", categoryNetherOreBlue, cfgNetherOreBlueHeightMin, 0, 127, "");
        cfgNetherOreBlueHeightMax = config.getInt("Height (Max)", categoryNetherOreBlue, cfgNetherOreBlueHeightMax, 0, 127, "");

        // Ore Generation - Nether Ore White
        cfgNetherOreWhiteShouldGenerate = config.getBoolean("Generate ores", categoryNetherOreWhite, cfgNetherOreWhiteShouldGenerate, "");
        cfgNetherOreWhiteVeins = config.getInt("Veins per chunk", categoryNetherOreWhite, cfgNetherOreWhiteVeins, 1, 64, "");
        cfgNetherOreWhiteCountMin = config.getInt("Ores per vein (Min)", categoryNetherOreWhite, cfgNetherOreWhiteCountMin, 1, 64, "");
        cfgNetherOreWhiteCountMax = config.getInt("Ores per vein (Max)", categoryNetherOreWhite, cfgNetherOreWhiteCountMax, 1, 64, "");
        cfgNetherOreWhiteHeightMin = config.getInt("Height (Min)", categoryNetherOreWhite, cfgNetherOreWhiteHeightMin, 0, 127, "");
        cfgNetherOreWhiteHeightMax = config.getInt("Height (Max)", categoryNetherOreWhite, cfgNetherOreWhiteHeightMax, 0, 127, "");

        // Ore Generation - Nether Ore Black
        cfgNetherOreBlackShouldGenerate = config.getBoolean("Generate ores", categoryNetherOreBlack, cfgNetherOreBlackShouldGenerate, "");
        cfgNetherOreBlackVeins = config.getInt("Veins per chunk", categoryNetherOreBlack, cfgNetherOreBlackVeins, 1, 64, "");
        cfgNetherOreBlackCountMin = config.getInt("Ores per vein (Min)", categoryNetherOreBlack, cfgNetherOreBlackCountMin, 1, 64, "");
        cfgNetherOreBlackCountMax = config.getInt("Ores per vein (Max)", categoryNetherOreBlack, cfgNetherOreBlackCountMax, 1, 64, "");
        cfgNetherOreBlackHeightMin = config.getInt("Height (Min)", categoryNetherOreBlack, cfgNetherOreBlackHeightMin, 0, 127, "");
        cfgNetherOreBlackHeightMax = config.getInt("Height (Max)", categoryNetherOreBlack, cfgNetherOreBlackHeightMax, 0, 127, "");

        // Ore Generation - Other
        // Ore Generation - Other Ore Red
        cfgOtherOreRedShouldGenerate = config.getBoolean("Generate ores", categoryOtherOreRed, cfgOtherOreRedShouldGenerate, "");
        cfgOtherOreRedVeins = config.getInt("Veins per chunk", categoryOtherOreRed, cfgOtherOreRedVeins, 1, 64, "");
        cfgOtherOreRedCountMin = config.getInt("Ores per vein (Min)", categoryOtherOreRed, cfgOtherOreRedCountMin, 1, 64, "");
        cfgOtherOreRedCountMax = config.getInt("Ores per vein (Max)", categoryOtherOreRed, cfgOtherOreRedCountMax, 1, 64, "");
        cfgOtherOreRedHeightMin = config.getInt("Height (Min)", categoryOtherOreRed, cfgOtherOreRedHeightMin, 0, 255, "");
        cfgOtherOreRedHeightMax = config.getInt("Height (Max)", categoryOtherOreRed, cfgOtherOreRedHeightMax, 0, 255, "");

        // Ore Generation - Other Ore Green
        cfgOtherOreGreenShouldGenerate = config.getBoolean("Generate ores", categoryOtherOreGreen, cfgOtherOreGreenShouldGenerate, "");
        cfgOtherOreGreenVeins = config.getInt("Veins per chunk", categoryOtherOreGreen, cfgOtherOreGreenVeins, 1, 64, "");
        cfgOtherOreGreenCountMin = config.getInt("Ores per vein (Min)", categoryOtherOreGreen, cfgOtherOreGreenCountMin, 1, 64, "");
        cfgOtherOreGreenCountMax = config.getInt("Ores per vein (Max)", categoryOtherOreGreen, cfgOtherOreGreenCountMax, 1, 64, "");
        cfgOtherOreGreenHeightMin = config.getInt("Height (Min)", categoryOtherOreGreen, cfgOtherOreGreenHeightMin, 0, 255, "");
        cfgOtherOreGreenHeightMax = config.getInt("Height (Max)", categoryOtherOreGreen, cfgOtherOreGreenHeightMax, 0, 255, "");

        // Ore Generation - Other Ore Blue
        cfgOtherOreBlueShouldGenerate = config.getBoolean("Generate ores", categoryOtherOreBlue, cfgOtherOreBlueShouldGenerate, "");
        cfgOtherOreBlueVeins = config.getInt("Veins per chunk", categoryOtherOreBlue, cfgOtherOreBlueVeins, 1, 64, "");
        cfgOtherOreBlueCountMin = config.getInt("Ores per vein (Min)", categoryOtherOreBlue, cfgOtherOreBlueCountMin, 1, 64, "");
        cfgOtherOreBlueCountMax = config.getInt("Ores per vein (Max)", categoryOtherOreBlue, cfgOtherOreBlueCountMax, 1, 64, "");
        cfgOtherOreBlueHeightMin = config.getInt("Height (Min)", categoryOtherOreBlue, cfgOtherOreBlueHeightMin, 0, 255, "");
        cfgOtherOreBlueHeightMax = config.getInt("Height (Max)", categoryOtherOreBlue, cfgOtherOreBlueHeightMax, 0, 255, "");

        // Ore Generation - Other Ore White
        cfgOtherOreWhiteShouldGenerate = config.getBoolean("Generate ores", categoryOtherOreWhite, cfgOtherOreWhiteShouldGenerate, "");
        cfgOtherOreWhiteVeins = config.getInt("Veins per chunk", categoryOtherOreWhite, cfgOtherOreWhiteVeins, 1, 64, "");
        cfgOtherOreWhiteCountMin = config.getInt("Ores per vein (Min)", categoryOtherOreWhite, cfgOtherOreWhiteCountMin, 1, 64, "");
        cfgOtherOreWhiteCountMax = config.getInt("Ores per vein (Max)", categoryOtherOreWhite, cfgOtherOreWhiteCountMax, 1, 64, "");
        cfgOtherOreWhiteHeightMin = config.getInt("Height (Min)", categoryOtherOreWhite, cfgOtherOreWhiteHeightMin, 0, 255, "");
        cfgOtherOreWhiteHeightMax = config.getInt("Height (Max)", categoryOtherOreWhite, cfgOtherOreWhiteHeightMax, 0, 255, "");

        // Ore Generation - Other Ore Black
        cfgOtherOreBlackShouldGenerate = config.getBoolean("Generate ores", categoryOtherOreBlack, cfgOtherOreBlackShouldGenerate, "");
        cfgOtherOreBlackVeins = config.getInt("Veins per chunk", categoryOtherOreBlack, cfgOtherOreBlackVeins, 1, 64, "");
        cfgOtherOreBlackCountMin = config.getInt("Ores per vein (Min)", categoryOtherOreBlack, cfgOtherOreBlackCountMin, 1, 64, "");
        cfgOtherOreBlackCountMax = config.getInt("Ores per vein (Max)", categoryOtherOreBlack, cfgOtherOreBlackCountMax, 1, 64, "");
        cfgOtherOreBlackHeightMin = config.getInt("Height (Min)", categoryOtherOreBlack, cfgOtherOreBlackHeightMin, 0, 255, "");
        cfgOtherOreBlackHeightMax = config.getInt("Height (Max)", categoryOtherOreBlack, cfgOtherOreBlackHeightMax, 0, 255, "");



        // Monolith Generation
        config.setCategoryComment(categoryMonolith, "Configuration for monolith generation. The monolith gen can be completely disabled, or\nconfigured per dimension and monolith.");
        cfgMonolithGeneralShouldGenerate = config.getBoolean("Generate monolith", categoryMonolith, cfgMonolithGeneralShouldGenerate, "If monolith generator should be working at all. Setting this to false disables ALL monolith\ngeneration. Ignores monolith and dimension-specific settings.\n");
        cfgMonolithNetherShouldGenerate = config.getBoolean("Generate Nether monolith", categoryMonolith, cfgMonolithNetherShouldGenerate, "If monoliths should be generating in the Nether. Setting this to false disables ALL monolith\ngeneration in the Nether. Ignores monolith-specific settings.\n");
        cfgMonolithOverworldShouldGenerate = config.getBoolean("Generate Overworld monolith", categoryMonolith, cfgMonolithOverworldShouldGenerate, "If monoliths should be generating in the Overworld. Setting this to false disables ALL monolith\ngeneration in the Overworld. Ignores monolith-specific settings.\n");
        cfgMonolithOtherShouldGenerate = config.getBoolean("Generate Other monolith", categoryMonolith, cfgMonolithOtherShouldGenerate, "If monoliths should be generating in other dimensions. Setting this to false disables ALL\nmonolith generation in other dimensions. Ignores monolith-specific settings.\n");

        // Monolith Generation - Overworld
        // Monolith Generation - Overworld Monolith Red
        cfgOverworldMonolithRedShouldGenerate = config.getBoolean("Generate monoliths", categoryOverworldMonolithRed, cfgOverworldMonolithRedShouldGenerate, "");
        cfgOverworldMonolithRedChance = config.getInt("Chance of spawning", categoryOverworldMonolithRed, cfgOverworldMonolithRedChance, 1, 100, "");
        cfgOverworldMonolithRedCount = config.getInt("Monoliths per chunk", categoryOverworldMonolithRed, cfgOverworldMonolithRedCount, 1, 64, "");
        cfgOverworldMonolithRedHeightMin = config.getInt("Height (Min)", categoryOverworldMonolithRed, cfgOverworldMonolithRedHeightMin, 0, 255, "");
        cfgOverworldMonolithRedHeightMax = config.getInt("Height (Max)", categoryOverworldMonolithRed, cfgOverworldMonolithRedHeightMax, 0, 255, "");

        // Monolith Generation - Overworld Monolith Green
        cfgOverworldMonolithGreenShouldGenerate = config.getBoolean("Generate monoliths", categoryOverworldMonolithGreen, cfgOverworldMonolithGreenShouldGenerate, "");
        cfgOverworldMonolithGreenChance = config.getInt("Chance of spawning", categoryOverworldMonolithGreen, cfgOverworldMonolithGreenChance, 1, 100, "");
        cfgOverworldMonolithGreenCount = config.getInt("Monoliths per chunk", categoryOverworldMonolithGreen, cfgOverworldMonolithGreenCount, 1, 64, "");
        cfgOverworldMonolithGreenHeightMin = config.getInt("Height (Min)", categoryOverworldMonolithGreen, cfgOverworldMonolithGreenHeightMin, 0, 255, "");
        cfgOverworldMonolithGreenHeightMax = config.getInt("Height (Max)", categoryOverworldMonolithGreen, cfgOverworldMonolithGreenHeightMax, 0, 255, "");

        // Monolith Generation - Overworld Monolith Blue
        cfgOverworldMonolithBlueShouldGenerate = config.getBoolean("Generate monoliths", categoryOverworldMonolithBlue, cfgOverworldMonolithBlueShouldGenerate, "");
        cfgOverworldMonolithBlueChance = config.getInt("Chance of spawning", categoryOverworldMonolithBlue, cfgOverworldMonolithBlueChance, 1, 100, "");
        cfgOverworldMonolithBlueCount = config.getInt("Monoliths per chunk", categoryOverworldMonolithBlue, cfgOverworldMonolithBlueCount, 1, 64, "");
        cfgOverworldMonolithBlueHeightMin = config.getInt("Height (Min)", categoryOverworldMonolithBlue, cfgOverworldMonolithBlueHeightMin, 0, 255, "");
        cfgOverworldMonolithBlueHeightMax = config.getInt("Height (Max)", categoryOverworldMonolithBlue, cfgOverworldMonolithBlueHeightMax, 0, 255, "");

        // Monolith Generation - Overworld Monolith White
        cfgOverworldMonolithWhiteShouldGenerate = config.getBoolean("Generate monoliths", categoryOverworldMonolithWhite, cfgOverworldMonolithWhiteShouldGenerate, "");
        cfgOverworldMonolithWhiteChance = config.getInt("Chance of spawning", categoryOverworldMonolithWhite, cfgOverworldMonolithWhiteChance, 1, 100, "");
        cfgOverworldMonolithWhiteCount = config.getInt("Monoliths per chunk", categoryOverworldMonolithWhite, cfgOverworldMonolithWhiteCount, 1, 64, "");
        cfgOverworldMonolithWhiteHeightMin = config.getInt("Height (Min)", categoryOverworldMonolithWhite, cfgOverworldMonolithWhiteHeightMin, 0, 255, "");
        cfgOverworldMonolithWhiteHeightMax = config.getInt("Height (Max)", categoryOverworldMonolithWhite, cfgOverworldMonolithWhiteHeightMax, 0, 255, "");

        // Monolith Generation - Overworld Monolith Black
        cfgOverworldMonolithBlackShouldGenerate = config.getBoolean("Generate monoliths", categoryOverworldMonolithBlack, cfgOverworldMonolithBlackShouldGenerate, "");
        cfgOverworldMonolithBlackChance = config.getInt("Chance of spawning", categoryOverworldMonolithBlack, cfgOverworldMonolithBlackChance, 1, 100, "");
        cfgOverworldMonolithBlackCount = config.getInt("Monoliths per chunk", categoryOverworldMonolithBlack, cfgOverworldMonolithBlackCount, 1, 64, "");
        cfgOverworldMonolithBlackHeightMin = config.getInt("Height (Min)", categoryOverworldMonolithBlack, cfgOverworldMonolithBlackHeightMin, 0, 255, "");
        cfgOverworldMonolithBlackHeightMax = config.getInt("Height (Max)", categoryOverworldMonolithBlack, cfgOverworldMonolithBlackHeightMax, 0, 255, "");

        // Monolith Generation - Nether
        // Monolith Generation - Nether Monolith Red
        cfgNetherMonolithRedShouldGenerate = config.getBoolean("Generate monoliths", categoryNetherMonolithRed, cfgNetherMonolithRedShouldGenerate, "");
        cfgNetherMonolithRedChance = config.getInt("Chance of spawning", categoryNetherMonolithRed, cfgNetherMonolithRedChance, 1, 100, "");
        cfgNetherMonolithRedCount = config.getInt("Monoliths per chunk", categoryNetherMonolithRed, cfgNetherMonolithRedCount, 1, 64, "");
        cfgNetherMonolithRedHeightMin = config.getInt("Height (Min)", categoryNetherMonolithRed, cfgNetherMonolithRedHeightMin, 0, 127, "");
        cfgNetherMonolithRedHeightMax = config.getInt("Height (Max)", categoryNetherMonolithRed, cfgNetherMonolithRedHeightMax, 0, 127, "");

        // Monolith Generation - Nether Monolith Green
        cfgNetherMonolithGreenShouldGenerate = config.getBoolean("Generate monoliths", categoryNetherMonolithGreen, cfgNetherMonolithGreenShouldGenerate, "");
        cfgNetherMonolithGreenChance = config.getInt("Chance of spawning", categoryNetherMonolithGreen, cfgNetherMonolithGreenChance, 1, 100, "");
        cfgNetherMonolithGreenCount = config.getInt("Monoliths per chunk", categoryNetherMonolithGreen, cfgNetherMonolithGreenCount, 1, 64, "");
        cfgNetherMonolithGreenHeightMin = config.getInt("Height (Min)", categoryNetherMonolithGreen, cfgNetherMonolithGreenHeightMin, 0, 127, "");
        cfgNetherMonolithGreenHeightMax = config.getInt("Height (Max)", categoryNetherMonolithGreen, cfgNetherMonolithGreenHeightMax, 0, 127, "");

        // Monolith Generation - Nether Monolith Blue
        cfgNetherMonolithBlueShouldGenerate = config.getBoolean("Generate monoliths", categoryNetherMonolithBlue, cfgNetherMonolithBlueShouldGenerate, "");
        cfgNetherMonolithBlueChance = config.getInt("Chance of spawning", categoryNetherMonolithBlue, cfgNetherMonolithBlueChance, 1, 100, "");
        cfgNetherMonolithBlueCount = config.getInt("Monoliths per chunk", categoryNetherMonolithBlue, cfgNetherMonolithBlueCount, 1, 64, "");
        cfgNetherMonolithBlueHeightMin = config.getInt("Height (Min)", categoryNetherMonolithBlue, cfgNetherMonolithBlueHeightMin, 0, 127, "");
        cfgNetherMonolithBlueHeightMax = config.getInt("Height (Max)", categoryNetherMonolithBlue, cfgNetherMonolithBlueHeightMax, 0, 127, "");

        // Monolith Generation - Nether Monolith White
        cfgNetherMonolithWhiteShouldGenerate = config.getBoolean("Generate monoliths", categoryNetherMonolithWhite, cfgNetherMonolithWhiteShouldGenerate, "");
        cfgNetherMonolithWhiteChance = config.getInt("Chance of spawning", categoryNetherMonolithWhite, cfgNetherMonolithWhiteChance, 1, 100, "");
        cfgNetherMonolithWhiteCount = config.getInt("Monoliths per chunk", categoryNetherMonolithWhite, cfgNetherMonolithWhiteCount, 1, 64, "");
        cfgNetherMonolithWhiteHeightMin = config.getInt("Height (Min)", categoryNetherMonolithWhite, cfgNetherMonolithWhiteHeightMin, 0, 127, "");
        cfgNetherMonolithWhiteHeightMax = config.getInt("Height (Max)", categoryNetherMonolithWhite, cfgNetherMonolithWhiteHeightMax, 0, 127, "");

        // Monolith Generation - Nether Monolith Black
        cfgNetherMonolithBlackShouldGenerate = config.getBoolean("Generate monoliths", categoryNetherMonolithBlack, cfgNetherMonolithBlackShouldGenerate, "");
        cfgNetherMonolithBlackChance = config.getInt("Chance of spawning", categoryNetherMonolithBlack, cfgNetherMonolithBlackChance, 1, 100, "");
        cfgNetherMonolithBlackCount = config.getInt("Monoliths per chunk", categoryNetherMonolithBlack, cfgNetherMonolithBlackCount, 1, 64, "");
        cfgNetherMonolithBlackHeightMin = config.getInt("Height (Min)", categoryNetherMonolithBlack, cfgNetherMonolithBlackHeightMin, 0, 127, "");
        cfgNetherMonolithBlackHeightMax = config.getInt("Height (Max)", categoryNetherMonolithBlack, cfgNetherMonolithBlackHeightMax, 0, 127, "");

        // Monolith Generation - Other
        // Monolith Generation - Other Monolith Red
        cfgOtherMonolithRedShouldGenerate = config.getBoolean("Generate monoliths", categoryOtherMonolithRed, cfgOtherMonolithRedShouldGenerate, "");
        cfgOtherMonolithRedChance = config.getInt("Chance of spawning", categoryOtherMonolithRed, cfgOtherMonolithRedChance, 1, 100, "");
        cfgOtherMonolithRedCount = config.getInt("Monoliths per chunk", categoryOtherMonolithRed, cfgOtherMonolithRedCount, 1, 64, "");
        cfgOtherMonolithRedHeightMin = config.getInt("Height (Min)", categoryOtherMonolithRed, cfgOtherMonolithRedHeightMin, 0, 255, "");
        cfgOtherMonolithRedHeightMax = config.getInt("Height (Max)", categoryOtherMonolithRed, cfgOtherMonolithRedHeightMax, 0, 255, "");

        // Monolith Generation - Other Monolith Green
        cfgOtherMonolithGreenShouldGenerate = config.getBoolean("Generate monoliths", categoryOtherMonolithGreen, cfgOtherMonolithGreenShouldGenerate, "");
        cfgOtherMonolithGreenChance = config.getInt("Chance of spawning", categoryOtherMonolithGreen, cfgOtherMonolithGreenChance, 1, 100, "");
        cfgOtherMonolithGreenCount = config.getInt("Monoliths per chunk", categoryOtherMonolithGreen, cfgOtherMonolithGreenCount, 1, 64, "");
        cfgOtherMonolithGreenHeightMin = config.getInt("Height (Min)", categoryOtherMonolithGreen, cfgOtherMonolithGreenHeightMin, 0, 255, "");
        cfgOtherMonolithGreenHeightMax = config.getInt("Height (Max)", categoryOtherMonolithGreen, cfgOtherMonolithGreenHeightMax, 0, 255, "");

        // Monolith Generation - Other Monolith Blue
        cfgOtherMonolithBlueShouldGenerate = config.getBoolean("Generate monoliths", categoryOtherMonolithBlue, cfgOtherMonolithBlueShouldGenerate, "");
        cfgOtherMonolithBlueChance = config.getInt("Chance of spawning", categoryOtherMonolithBlue, cfgOtherMonolithBlueChance, 1, 100, "");
        cfgOtherMonolithBlueCount = config.getInt("Monoliths per chunk", categoryOtherMonolithBlue, cfgOtherMonolithBlueCount, 1, 64, "");
        cfgOtherMonolithBlueHeightMin = config.getInt("Height (Min)", categoryOtherMonolithBlue, cfgOtherMonolithBlueHeightMin, 0, 255, "");
        cfgOtherMonolithBlueHeightMax = config.getInt("Height (Max)", categoryOtherMonolithBlue, cfgOtherMonolithBlueHeightMax, 0, 255, "");

        // Monolith Generation - Other Monolith White
        cfgOtherMonolithWhiteShouldGenerate = config.getBoolean("Generate monoliths", categoryOtherMonolithWhite, cfgOtherMonolithWhiteShouldGenerate, "");
        cfgOtherMonolithWhiteChance = config.getInt("Chance of spawning", categoryOtherMonolithWhite, cfgOtherMonolithWhiteChance, 1, 100, "");
        cfgOtherMonolithWhiteCount = config.getInt("Monoliths per chunk", categoryOtherMonolithWhite, cfgOtherMonolithWhiteCount, 1, 64, "");
        cfgOtherMonolithWhiteHeightMin = config.getInt("Height (Min)", categoryOtherMonolithWhite, cfgOtherMonolithWhiteHeightMin, 0, 255, "");
        cfgOtherMonolithWhiteHeightMax = config.getInt("Height (Max)", categoryOtherMonolithWhite, cfgOtherMonolithWhiteHeightMax, 0, 255, "");

        // Monolith Generation - Other Monolith Black
        cfgOtherMonolithBlackShouldGenerate = config.getBoolean("Generate monoliths", categoryOtherMonolithBlack, cfgOtherMonolithBlackShouldGenerate, "");
        cfgOtherMonolithBlackChance = config.getInt("Chance of spawning", categoryOtherMonolithBlack, cfgOtherMonolithBlackChance, 1, 100, "");
        cfgOtherMonolithBlackCount = config.getInt("Monoliths per chunk", categoryOtherMonolithBlack, cfgOtherMonolithBlackCount, 1, 64, "");
        cfgOtherMonolithBlackHeightMin = config.getInt("Height (Min)", categoryOtherMonolithBlack, cfgOtherMonolithBlackHeightMin, 0, 255, "");
        cfgOtherMonolithBlackHeightMax = config.getInt("Height (Max)", categoryOtherMonolithBlack, cfgOtherMonolithBlackHeightMax, 0, 255, "");

        config.save();
    }
}
