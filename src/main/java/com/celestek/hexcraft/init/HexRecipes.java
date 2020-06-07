package com.celestek.hexcraft.init;

import com.celestek.hexcraft.block.*;
import com.celestek.hexcraft.item.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class HexRecipes {

    /**
     * Initializes all recipes and adds them to GameRegistry.
     */
    public static void initializeRecipes() {

        /* Blocks */

        // Gem Blocks
        BlockOfHexoriumCrystal.registerRecipes();

        // Energized
        BlockEnergizedHexorium.registerRecipes();

        // Decorative
        BlockEngineeredHexoriumBlock.registerRecipes();
        BlockFramedHexoriumBlock.registerRecipes();
        BlockPlatedHexoriumBlock.registerRecipes();
        BlockConcentricHexoriumBlock.registerRecipes();
        BlockHexoriumStructureCasing.registerRecipes();
        BlockGlowingHexoriumCoatedStone.registerRecipes();
        BlockGlowingHexoriumGlass.registerRecipes();
        BlockHexoriumLamp.registerRecipes();
        BlockHexoriumLampInv.registerRecipes();
        BlockHexoriumDoor.registerRecipes();
        BlockHexoriumHatch.registerRecipes();

        // Machines
        BlockHexoriumMachineBlock.registerRecipes();
        BlockAdvancedRainbowCore.registerRecipes();
        BlockHexoriumGenerator.registerRecipes();
        BlockHexoriumFurnace.registerRecipes();
        BlockCrystalSeparator.registerRecipes();
        BlockMatrixReconstructor.registerRecipes();
        BlockPersonalTeleportationPad.registerRecipes();
        BlockQuantumObserver.registerRecipes();
        BlockQuantumAnchor.registerRecipes();

        // Tank
        BlockTankValve.registerRecipes();

        // Energy Node
        BlockEnergyNodeCore.registerRecipes();
        BlockEnergyNodePortHEX.registerRecipes();
        BlockEnergyNodePortRF.registerRecipes();
        BlockEnergyNodePortEU.registerRecipes();

        // Cables
        BlockHexoriumCable.registerRecipes();

        // Energy Pylon
        BlockEnergyPylon.registerRecipes();

        // Redstone
        BlockHexoriumSwitch.registerRecipes();
        BlockHexoriumButton.registerRecipes();
        BlockHexoriumPressurePlate.registerRecipes();

        // Regular Blocks
        BlockTemperedHexoriumGlass.registerRecipes();
        BlockHexoriumCoatedStone.registerRecipes();
        BlockPylonBase.registerRecipes();
        BlockSoundProjector.registerRecipes();

        /* Items */

        // Hex Components
        HexItemComponent.registerRecipes();

        // Tools
        ItemHexoriumManipulator.registerRecipes();
        ItemHexoriumProbe.registerRecipes();
        ItemMolecularTransposer.registerRecipes();
        ItemHexoriumReinforcer.registerRecipes();
        ItemMortarPestle.registerRecipes();

        // Dyes
        ItemHexoriumDye.registerRecipes();
    }
}