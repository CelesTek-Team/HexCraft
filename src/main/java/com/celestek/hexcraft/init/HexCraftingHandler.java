package com.celestek.hexcraft.init;

import com.celestek.hexcraft.block.*;
import com.celestek.hexcraft.util.HexEnums;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayerMP;

public class HexCraftingHandler {
    /**
     * Fired when player crafts an item.
     */
    @SubscribeEvent
    public void onPlayerCraftingEvent(PlayerEvent.ItemCraftedEvent event) {
        // If this is the player on server side...
        if (event.player instanceof EntityPlayerMP && event.crafting != null) {
            EntityPlayerMP playerMP = (EntityPlayerMP) event.player;
            Block block = Block.getBlockFromItem(event.crafting.getItem());

            // Prepare bools.
            boolean checkDecorations = false;
            boolean checkMachines = false;

            // Energized Hexorium
            if (block instanceof BlockEnergizedHexorium) {
                HexEnums.Colors color = ((IBlockHexColor) block).getColor();
                if (color == HexEnums.Colors.RED)
                    event.player.addStat(HexAchievements.achCraftEnergizedRed, 1);
                if (color == HexEnums.Colors.ORANGE)
                    event.player.addStat(HexAchievements.achCraftEnergizedOrange, 1);
                if (color == HexEnums.Colors.YELLOW)
                    event.player.addStat(HexAchievements.achCraftEnergizedYellow, 1);
                if (color == HexEnums.Colors.LIME)
                    event.player.addStat(HexAchievements.achCraftEnergizedLime, 1);
                if (color == HexEnums.Colors.GREEN)
                    event.player.addStat(HexAchievements.achCraftEnergizedGreen, 1);
                if (color == HexEnums.Colors.TURQUOISE)
                    event.player.addStat(HexAchievements.achCraftEnergizedTurquoise, 1);
                if (color == HexEnums.Colors.CYAN)
                    event.player.addStat(HexAchievements.achCraftEnergizedCyan, 1);
                if (color == HexEnums.Colors.SKY_BLUE)
                    event.player.addStat(HexAchievements.achCraftEnergizedSkyBlue, 1);
                if (color == HexEnums.Colors.BLUE)
                    event.player.addStat(HexAchievements.achCraftEnergizedBlue, 1);
                if (color == HexEnums.Colors.PURPLE)
                    event.player.addStat(HexAchievements.achCraftEnergizedPurple, 1);
                if (color == HexEnums.Colors.MAGENTA)
                    event.player.addStat(HexAchievements.achCraftEnergizedMagenta, 1);
                if (color == HexEnums.Colors.PINK)
                    event.player.addStat(HexAchievements.achCraftEnergizedPink, 1);

                if (playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftEnergizedRed)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftEnergizedOrange)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftEnergizedYellow)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftEnergizedLime)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftEnergizedGreen)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftEnergizedTurquoise)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftEnergizedCyan)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftEnergizedSkyBlue)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftEnergizedBlue)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftEnergizedPurple)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftEnergizedMagenta)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftEnergizedPink))
                    event.player.addStat(HexAchievements.achGroupColors, 1);

                if (color == HexEnums.Colors.WHITE)
                    event.player.addStat(HexAchievements.achCraftEnergizedWhite, 1);
                if (color == HexEnums.Colors.LIGHT_GRAY)
                    event.player.addStat(HexAchievements.achCraftEnergizedLightGray, 1);
                if (color == HexEnums.Colors.GRAY)
                    event.player.addStat(HexAchievements.achCraftEnergizedGray, 1);
                if (color == HexEnums.Colors.DARK_GRAY)
                    event.player.addStat(HexAchievements.achCraftEnergizedDarkGray, 1);
                if (color == HexEnums.Colors.BLACK)
                    event.player.addStat(HexAchievements.achCraftEnergizedBlack, 1);

                if (playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftEnergizedWhite)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftEnergizedLightGray)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftEnergizedGray)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftEnergizedDarkGray)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftEnergizedBlack))
                    event.player.addStat(HexAchievements.achGroupGrays, 1);

                if (color == HexEnums.Colors.RAINBOW)
                    event.player.addStat(HexAchievements.achCraftEnergizedRainbow, 1);
            }

            // Mini Energized
            else if (block instanceof BlockMiniEnergizedHexorium)
                event.player.addStat(HexAchievements.achCraftMiniEnergized, 1);

            // Decorative
            else if (block instanceof BlockEngineeredHexoriumBlock) {
                event.player.addStat(HexAchievements.achCraftEngineeredBlock, 1);
                checkDecorations = true;
            }
            else if (block instanceof BlockFramedHexoriumBlock) {
                event.player.addStat(HexAchievements.achCraftFramedBlock, 1);
                checkDecorations = true;
            }
            else if (block instanceof BlockPlatedHexoriumBlock) {
                event.player.addStat(HexAchievements.achCraftPlatedBlock, 1);
                checkDecorations = true;
            }
            else if (block instanceof BlockConcentricHexoriumBlock) {
                event.player.addStat(HexAchievements.achCraftConcentricBlock, 1);
                checkDecorations = true;
            }
            else if (block instanceof BlockHexoriumStructureCasing) {
                event.player.addStat(HexAchievements.achCraftStructureCasing, 1);
                checkDecorations = true;
            }
            else if (block instanceof BlockHexoriumDoor) {
                event.player.addStat(HexAchievements.achCraftDoor, 1);
                checkDecorations = true;
            }
            else if (block instanceof BlockHexoriumHatch) {
                event.player.addStat(HexAchievements.achCraftHatch, 1);
                checkDecorations = true;
            }
            else if (block instanceof BlockGlowingHexoriumGlass) {
                event.player.addStat(HexAchievements.achCraftGlowingGlass, 1);
                checkDecorations = true;
            }
            else if (block instanceof BlockHexoriumLamp) {
                event.player.addStat(HexAchievements.achCraftLamp, 1);
                checkDecorations = true;
            }
            else if (block instanceof BlockHexoriumLampInv) {
                event.player.addStat(HexAchievements.achCraftLampInv, 1);
                checkDecorations = true;
            }
            else if (block instanceof BlockHexoriumCoatedStone) {
                event.player.addStat(HexAchievements.achCraftHexoriumCoatedStone, 1);
            }
            else if (block instanceof BlockGlowingHexoriumCoatedStone) {
                event.player.addStat(HexAchievements.achCraftGlowingHexoriumCoatedStone, 1);

            }

            // T1 Sound Machines
            else if (event.crafting.getItem() == HexItems.itemSoundEmissionModule)
                event.player.addStat(HexAchievements.achCraftSoundEmissionModule, 1);

            // T2 Sound Machines
            else if (block instanceof BlockSoundProjector)
                event.player.addStat(HexAchievements.achCraftSoundProjector, 1);

            // T1 Machines
            else if (block instanceof BlockHexoriumCable)
                event.player.addStat(HexAchievements.achCraftCable, 1);

            else if (block instanceof BlockHexoriumMachineBlock)
                event.player.addStat(HexAchievements.achCraftMachineBlock, 1);

            else if (block instanceof BlockAdvancedRainbowCore)
                event.player.addStat(HexAchievements.achCraftAdvancedRainbowCore, 1);

            else if (block instanceof BlockEnergyNodeCore)
                event.player.addStat(HexAchievements.achCraftEnergyNodeCore, 1);

            else if (block instanceof IBlockHexEnergyPort)
                event.player.addStat(HexAchievements.achCraftEnergyNodePort, 1);

            // T2 Machines
            else if (block instanceof BlockHexoriumGenerator) {
                event.player.addStat(HexAchievements.achCraftMachineGenerator, 1);
                checkMachines = true;
            }
            else if (block instanceof BlockHexoriumFurnace && HexConfig.cfgFurnaceEnable) {
                event.player.addStat(HexAchievements.achCraftMachineFurnace, 1);
                checkMachines = true;
            }
            else if (block instanceof BlockCrystalSeparator && HexConfig.cfgSeparatorEnable) {
                event.player.addStat(HexAchievements.achCraftMachineSeparator, 1);
                checkMachines = true;
            }
            else if (block instanceof BlockMatrixReconstructor) {
                event.player.addStat(HexAchievements.achCraftMachineReconstructor, 1);
                checkMachines = true;
            }
            else if (block instanceof BlockTankValve && HexConfig.cfgTankEnable) {
                event.player.addStat(HexAchievements.achCraftMachineTankValve, 1);
                checkMachines = true;
            }
            else if (block instanceof BlockPersonalTeleportationPad && HexConfig.cfgTeleportEnable) {
                event.player.addStat(HexAchievements.achCraftMachineTeleport, 1);
                checkMachines = true;
            }
            else if (block instanceof BlockQuantumObserver && HexConfig.cfgObserverEnable) {
                event.player.addStat(HexAchievements.achCraftMachineQuantumObserver, 1);
                checkMachines = true;
            }
            else if (block instanceof BlockEnergyPylon)
                event.player.addStat(HexAchievements.achCraftPylon, 1);

            // Manipulator
            else if (event.crafting.getItem() == HexItems.itemHexoriumManipulator)
                event.player.addStat(HexAchievements.achCraftManipulator, 1);

            // Transposer
            else if (event.crafting.getItem() == HexItems.itemMolecularTransposer)
                event.player.addStat(HexAchievements.achCraftTransposer, 1);

            // Probe
            else if (event.crafting.getItem() == HexItems.itemHexoriumProbe)
                event.player.addStat(HexAchievements.achCraftProbe, 1);

            // Dyeing
            if (block instanceof IBlockHexVariant) {
                HexEnums.Variants variant = ((IBlockHexVariant) block).getVariant();
                if (variant == HexEnums.Variants.WHITE)
                    event.player.addStat(HexAchievements.achUseDye, 1);
            }

            // Decorative Special
            if (checkDecorations)
                if (playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftEngineeredBlock)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftFramedBlock)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftPlatedBlock)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftConcentricBlock)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftStructureCasing)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftDoor)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftHatch)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftGlowingGlass)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftLamp)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftLampInv))
                    event.player.addStat(HexAchievements.achGroupDecorations, 1);

            // Machines Special
            if (checkMachines) {
                if (playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftMachineGenerator)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftMachineReconstructor)) {

                    boolean furnaceAch;
                    if (HexConfig.cfgFurnaceEnable)
                        furnaceAch = playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftMachineFurnace);
                    else
                        furnaceAch = true;

                    boolean separatorAch;
                    if (HexConfig.cfgSeparatorEnable)
                        separatorAch = playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftMachineSeparator);
                    else
                        separatorAch = true;

                    boolean teleportAch;
                    if (HexConfig.cfgTeleportEnable)
                        teleportAch = playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftMachineTeleport);
                    else
                        teleportAch = true;

                    boolean tankAch;
                    if (HexConfig.cfgTankEnable)
                        tankAch = playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftMachineTankValve);
                    else
                        tankAch = true;

                    boolean observerAch;
                    if (HexConfig.cfgObserverEnable)
                        observerAch = playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftMachineQuantumObserver);
                    else
                        observerAch = true;

                    if (furnaceAch && separatorAch && teleportAch && tankAch && observerAch)
                        event.player.addStat(HexAchievements.achGroupMachines, 1);
                }
            }
        }
    }
}
