package com.celestek.hexcraft.init;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.*;
import com.celestek.hexcraft.util.HexEnums;
import com.celestek.hexcraft.util.HexUtils;
import cpw.mods.fml.common.Loader;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class HexBlocks {

    // Meta Bits
    public static final int META_MACHINE_ROTATION_0 = 0;
    public static final int META_MACHINE_ROTATION_1 = 1;
    public static final int META_MACHINE_STATUS_0 = 2;
    public static final int META_MACHINE_STATUS_1 = 3;
    public static final int META_DECORATIVE_REINFORCED = 0;
    public static final int META_STRUCTURE_IS_PART = 1;

    // Machine States
    public static final int MACHINE_STATE_READY = 0;
    public static final int MACHINE_STATE_ACTIVE = 1;
    public static final int MACHINE_STATE_DEAD = 2;

    /**
     * ADDING NEW BLOCKS
     * To add a new block:
     * 1) Increment countBlocks.
     * 2) Add a public static Block.
     * 3) Add the 2 required lines to initializeBlocks() (Check other blocks).
     * 4) Add the 2 required lines to HexClientProxy.setCustomRenderers() (Check other blocks).
     */

    // Total count of blocks to add.
    public static final int countBlocks = 538;

    /**
     * Initializes all block and adds them to GameRegistry.
     */
    public static void initializeBlocks() {
        // Prepare HexCraft's block ID counter.
        HexCraft.idCounter = 0;

        // Ores
        BlockHexoriumOre.registerBlocks();
        BlockHexoriumMonolith.registerBlocks();
        BlockHexoriumNetherOre.registerBlocks();
        BlockHexoriumNetherMonolith.registerBlocks();

        // Block of Hexorium Crystal
        BlockOfHexoriumCrystal.registerBlocks();

        // Decorative
        BlockEnergizedHexorium.registerBlocks();
        BlockMiniEnergizedHexorium.registerBlocks();
        BlockEngineeredHexoriumBlock.registerBlocks();
        BlockFramedHexoriumBlock.registerBlocks();
        BlockPlatedHexoriumBlock.registerBlocks();
        BlockConcentricHexoriumBlock.registerBlocks();
        BlockHexoriumStructureCasing.registerBlocks();
        BlockGlowingHexoriumCoatedStone.registerBlocks();
        BlockGlowingHexoriumGlass.registerBlocks();
        BlockEnergizedHexoriumMonolith.registerBlocks();
        BlockHexoriumLamp.registerBlocks();
        BlockHexoriumLampInv.registerBlocks();
        BlockHexoriumDoor.registerBlocks();
        BlockHexoriumHatch.registerBlocks();

        // Machines
        BlockHexoriumMachineBlock.registerBlocks();
        BlockAdvancedRainbowCore.registerBlocks();
        BlockHexoriumGenerator.registerBlocks();
        BlockHexoriumFurnace.registerBlocks();
        BlockCrystalSeparator.registerBlocks();
        BlockMatrixReconstructor.registerBlocks();
        BlockPersonalTeleportationPad.registerBlocks();
        BlockQuantumObserver.registerBlocks();
        BlockQuantumAnchor.registerBlocks();

        // Tank
        BlockTankValve.registerBlocks();
        BlockTankRender.registerBlocks();
        
        // Energy Node
        BlockEnergyNodeCore.registerBlocks();
        BlockConversionComputer.registerBlocks();
        BlockEnergyNodePortHEX.registerBlocks();
        BlockEnergyNodePortRF.registerBlocks();
        if (Loader.isModLoaded("IC2"))
            BlockEnergyNodePortEU.registerBlocks();
        if (Loader.isModLoaded("gregapi"))
            BlockEnergyNodePortLU.registerBlocks();

        // Cables
        BlockHexoriumCable.registerBlocks();
        
        // Energy Pylon
        BlockEnergyPylon.registerBlocks();

        // Redstone
        BlockHexoriumSwitch.registerBlocks();
        BlockHexoriumButton.registerBlocks();
        BlockHexoriumPressurePlate.registerBlocks();

        // Regular Blocks
        BlockTemperedHexoriumGlass.registerBlocks();
        BlockHexoriumCoatedStone.registerBlocks();
        BlockPylonBase.registerBlocks();
        BlockSoundProjector.registerBlocks();
    }

    public static int getMachineState(World world, int x, int y, int z) {
        return HexUtils.getMetaBitBiInt(
                META_MACHINE_STATUS_0,
                META_MACHINE_STATUS_1,
                world, x, y, z);
    }

    public static int getMachineState(IBlockAccess world, int x, int y, int z) {
        return HexUtils.getMetaBitBiInt(
                META_MACHINE_STATUS_0,
                META_MACHINE_STATUS_1,
                world, x, y, z);
    }

    public static void setMachineState(int state, World world, int x, int y, int z) {
        HexUtils.setMetaBitBiInt(
                META_MACHINE_STATUS_0,
                META_MACHINE_STATUS_1,
                state, HexUtils.META_NOTIFY_UPDATE, world, x, y, z);
    }

    public static Block getHexBlock(String id, HexEnums.Variants variant, HexEnums.Colors color) {
        return Block.getBlockFromName(HexCraft.MODID + ":" + id + variant.name + color.name);
    }

    public static Block getHexBlock(String id, HexEnums.Variants variant, String extra) {
        return Block.getBlockFromName(HexCraft.MODID + ":" + id + variant.name + extra);
    }

    public static Block getHexBlock(String id, HexEnums.Colors color) {
        return Block.getBlockFromName(HexCraft.MODID + ":" + id + color.name);
    }

    public static Block getHexBlock(String id, HexEnums.Variants variant) {
        return Block.getBlockFromName(HexCraft.MODID + ":" + id + variant.name);
    }

    public static Block getHexBlock(String id) {
        return Block.getBlockFromName(HexCraft.MODID + ":" + id);
    }
}
