package com.celestek.hexcraft.item;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.BlockEnergizedHexoriumMonolith;
import com.celestek.hexcraft.block.BlockHexoriumCable;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import com.celestek.hexcraft.init.HexItems;
import com.celestek.hexcraft.util.HexEnums;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class HexItemComponent extends Item {

    /**
     * Constructor for the item.
     * @param itemName Unlocalized name for the item.
     */
    public HexItemComponent(String itemName) {
        setUnlocalizedName(itemName);
        setCreativeTab(HexCraft.tabComponents);
        setMaxStackSize(64);
        setTextureName(HexCraft.MODID + ":" + itemName);
    }

    public static Item registerItem(String name, boolean enabled) {
        if (enabled)
            return registerItem(name);
        else
            return null;
    }

    public static Item registerItem(String name) {
        Item item = new HexItemComponent(name);
        GameRegistry.registerItem(item, name);
        return item;
    }

    public static void registerRecipes() {
        Block cable = HexBlocks.getHexBlock(BlockHexoriumCable.ID, HexEnums.Colors.RAINBOW);

        String dr = "dustRedstone";
        String ni = "nuggetIron";
        String ng = "nuggetGold";
        String ii = "ingotIron";
        String ig = "ingotGold";
        String gd = "gemDiamond";
        String gRed = "gemHexoriumRed";
        String gGrn = "gemHexoriumGreen";
        String gBlu = "gemHexoriumBlue";
        String gWht = "gemHexoriumWhite";
        String gBlk = "gemHexoriumBlack";

        /* Components T1 */

        // Iron Ingot
        GameRegistry.addRecipe(new ShapelessOreRecipe(
                Items.iron_ingot,
                ni, ni, ni, ni, ni, ni, ni, ni, ni));

        // Iron Nugget
        GameRegistry.addRecipe(new ShapelessOreRecipe(
                new ItemStack(HexItems.itemIronNugget, 9),
                ii));

        // Rainbow Energized Globule
        GameRegistry.addRecipe(new ShapelessOreRecipe(
                HexItems.itemRainbowEnergizedGlobule,
                gRed, gGrn, gBlu, gWht, dr));

        // Spatial Projector
        GameRegistry.addRecipe(new ShapedOreRecipe(
                HexItems.itemSpatialProjector,
                "IGI",
                " I ",
                " R ",
                'R', dr, 'G', gBlk, 'I', ni));

        // Ore Actuator
        if (HexConfig.cfgSeparatorEnable)
            GameRegistry.addRecipe(new ShapedOreRecipe(
                    HexItems.itemOreActuator,
                    "I  ",
                    "PIR",
                    "I  ",
                    'R', dr, 'P', Items.iron_pickaxe, 'I', ni));

        // Pylon Socket
        GameRegistry.addRecipe(new ShapedOreRecipe(
                HexItems.itemPylonSocket,
                "ICI",
                "RRR",
                'R', dr, 'C', cable, 'I', ni));

        // Hexorium-Glass Package
        GameRegistry.addRecipe(new ShapedOreRecipe(
                HexItems.itemHexoriumGlassPackage,
                "ILI",
                "LGL",
                "ILI",
                'G', "gemHexorium", 'I', ni, 'L', "blockGlass"));

        /* Components T2 */

        // Rainbow Core
        GameRegistry.addRecipe(new ShapedOreRecipe(
                HexItems.itemRainbowCore,
                " R ",
                "GEG",
                " R ",
                'R', dr, 'E', HexItems.itemRainbowEnergizedGlobule, 'G', ng));

        // Hexorium Coprocessor
        GameRegistry.addRecipe(new ShapedOreRecipe(
                HexItems.itemHexoriumCoprocessor,
                " R ",
                "RWR",
                "III",
                'R', dr, 'W', HexItems.itemWhiteHexoriumWafer, 'I', ni));

        // Hexorium Processor
        GameRegistry.addRecipe(new ShapedOreRecipe(
                HexItems.itemHexoriumProcessor,
                " R ",
                "RWR",
                "GGG",
                'R', dr, 'W', HexItems.itemBlackHexoriumWafer, 'G', ng));

        // Mineral Analyzer
        if (HexConfig.cfgSeparatorEnable)
            GameRegistry.addRecipe(new ShapedOreRecipe(
                    HexItems.itemMineralAnalyzer,
                    "RGB",
                    "IDC",
                    " S ",
                    'S', dr, 'C', HexItems.itemHexoriumCoprocessor, 'R', gRed, 'G', gGrn, 'B', gBlu, 'D', gd, 'I', ig));

        // Hexorium Energy Converter
        GameRegistry.addRecipe(new ShapedOreRecipe(
                HexItems.itemHexoriumEnergyConverter,
                "ICI",
                "POS",
                "CIC",
                'C', cable, 'O', HexItems.itemRainbowCore, 'P', HexItems.itemHexoriumProcessor, 'S', HexItems.itemHexoriumCoprocessor, 'I', ni));

        // Energy Injector
        GameRegistry.addRecipe(new ShapedOreRecipe(
                HexItems.itemEnergyInjector,
                "RGB",
                "NSN",
                " C ",
                'C', cable, 'S', HexItems.itemSpatialProjector, 'R', gRed, 'G', gGrn, 'B', gBlu, 'N', ng));

        // Molecular Recoder
        if (HexConfig.cfgTeleportEnable)
            GameRegistry.addRecipe(new ShapedOreRecipe(
                    HexItems.itemMolecularRecoder,
                    "IRI",
                    "OPO",
                    "ICI",
                    'R', dr, 'C', cable, 'P', HexItems.itemHexoriumProcessor, 'O', HexItems.itemRainbowCore, 'I', ni));

        // Hexorium RF Adapter
        if (HexConfig.cfgEnergyNodeEnable && HexConfig.cfgEnergyNodePortsRFEnable)
            GameRegistry.addRecipe(new ShapedOreRecipe(
                    HexItems.itemHexoriumRFAdapter,
                    "RGR",
                    "RCR",
                    "RGR",
                    'R', dr, 'C', HexItems.itemRainbowCore, 'G', ng));

        /* Components MP */

        // Machine Control Panel
        GameRegistry.addRecipe(new ShapedOreRecipe(
                HexItems.itemMachineControlPanel,
                "BG ",
                "BPR",
                "BG ",
                'R', dr, 'P', HexItems.itemHexoriumProcessor, 'G', ng, 'B', Blocks.stone_button));

        // Machine Energy Router
        GameRegistry.addRecipe(new ShapedOreRecipe(
                HexItems.itemMachineEnergyRouter,
                "IP",
                "CR",
                "IG",
                'R', dr, 'C', cable, 'P', HexItems.itemHexoriumCoprocessor, 'G', ng, 'I', ni));

        // Heat Dissipator
        GameRegistry.addRecipe(new ShapedOreRecipe(
                HexItems.itemHeatDissipator,
                "IIR",
                "IIG",
                "IIR",
                'R', dr, 'G', gWht, 'I', ni));

        // Heating Array
        if (HexConfig.cfgFurnaceEnable)
            GameRegistry.addRecipe(new ShapedOreRecipe(
                    HexItems.itemHeatingArray,
                    "RRI",
                    "RGI",
                    "RRI",
                    'R', dr, 'G', gWht, 'I', ni));

        // Crystal Extraction Unit
        if (HexConfig.cfgSeparatorEnable)
            GameRegistry.addRecipe(new ShapedOreRecipe(
                    HexItems.itemCrystalExtractionUnit,
                    " AI",
                    "OCI",
                    " RI",
                    'R', dr, 'C', HexItems.itemHexoriumCoprocessor, 'A', HexItems.itemMineralAnalyzer, 'O', HexItems.itemOreActuator, 'I', ni));

        // Matrix Adjuster
        GameRegistry.addRecipe(new ShapedOreRecipe(
                HexItems.itemMatrixAdjuster,
                " DI",
                "SOC",
                " RI",
                'R', dr, 'C', HexItems.itemHexoriumCoprocessor, 'O', HexItems.itemRainbowCore, 'S', HexItems.itemSpatialProjector, 'I', ni, 'D', gd));

        // Material Interaction Plane
        if (HexConfig.cfgTeleportEnable)
            GameRegistry.addRecipe(new ShapedOreRecipe(
                    HexItems.itemMaterialInteractionPlane,
                    "GGG",
                    "GRG",
                    "NPN",
                    'R', dr, 'G', gBlk, 'P', HexItems.itemHexoriumProcessor, 'N', ng));

        // Teleportation Field Projector
        if (HexConfig.cfgTeleportEnable)
            GameRegistry.addRecipe(new ShapedOreRecipe(
                    HexItems.itemTeleportationFieldProjector,
                    "GDG",
                    "CSC",
                    "NRN",
                    'R', dr, 'G', gWht, 'C', HexItems.itemHexoriumCoprocessor, 'S', HexItems.itemSpatialProjector, 'D', gd, 'N', ng));

        // Observational Eye
        if (HexConfig.cfgObserverEnable)
            GameRegistry.addRecipe(new ShapedOreRecipe(
                    HexItems.itemObservationalEye,
                    "M",
                    "E",
                    "P",
                    'M', HexBlocks.getHexBlock(BlockEnergizedHexoriumMonolith.ID, HexEnums.Colors.BLACK), 'P', HexItems.itemHexoriumProcessor, 'E', Items.ender_eye));

        // Digital Smartpipe
        if (HexConfig.cfgTankEnable)
            GameRegistry.addRecipe(new ShapedOreRecipe(
                    HexItems.itemDigitalSmartpipe,
                    "ARR",
                    " II",
                    "BCR",
                    'R', dr, 'A', gRed, 'B', gGrn, 'C', HexItems.itemHexoriumCoprocessor, 'I', ni));

        // Sound Emission Module
        GameRegistry.addRecipe(new ShapedOreRecipe(
                HexItems.itemSoundEmissionModule,
                "AGB",
                "RDR",
                "ICI",
                'R', dr, 'A', gRed, 'B', gBlu, 'C', gGrn, 'D', gWht, 'G', HexItems.itemRainbowEnergizedGlobule, 'I', ii));

        // White Hexorium Wafer
        ItemStack waferWhite = new ItemStack(HexItems.itemWhiteHexoriumWafer, 1);
        GameRegistry.addSmelting(HexItems.itemHexoriumCrystalWhite, waferWhite, 0.1F);

        // White Hexorium Wafer
        ItemStack waferBlack = new ItemStack(HexItems.itemBlackHexoriumWafer, 1);
        GameRegistry.addSmelting(HexItems.itemHexoriumCrystalBlack, waferBlack, 0.1F);
    }
}
