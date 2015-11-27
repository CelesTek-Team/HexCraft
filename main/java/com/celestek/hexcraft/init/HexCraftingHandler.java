package com.celestek.hexcraft.init;

import com.celestek.hexcraft.block.*;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayerMP;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.8.1
 */

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
                if (block == HexBlocks.blockEnergizedHexoriumRed)
                    event.player.addStat(HexAchievements.achCraftEnergizedRed, 1);
                if (block == HexBlocks.blockEnergizedHexoriumOrange)
                    event.player.addStat(HexAchievements.achCraftEnergizedOrange, 1);
                if (block == HexBlocks.blockEnergizedHexoriumYellow)
                    event.player.addStat(HexAchievements.achCraftEnergizedYellow, 1);
                if (block == HexBlocks.blockEnergizedHexoriumLime)
                    event.player.addStat(HexAchievements.achCraftEnergizedLime, 1);
                if (block == HexBlocks.blockEnergizedHexoriumGreen)
                    event.player.addStat(HexAchievements.achCraftEnergizedGreen, 1);
                if (block == HexBlocks.blockEnergizedHexoriumTurquoise)
                    event.player.addStat(HexAchievements.achCraftEnergizedTurquoise, 1);
                if (block == HexBlocks.blockEnergizedHexoriumCyan)
                    event.player.addStat(HexAchievements.achCraftEnergizedCyan, 1);
                if (block == HexBlocks.blockEnergizedHexoriumSkyBlue)
                    event.player.addStat(HexAchievements.achCraftEnergizedSkyBlue, 1);
                if (block == HexBlocks.blockEnergizedHexoriumBlue)
                    event.player.addStat(HexAchievements.achCraftEnergizedBlue, 1);
                if (block == HexBlocks.blockEnergizedHexoriumPurple)
                    event.player.addStat(HexAchievements.achCraftEnergizedPurple, 1);
                if (block == HexBlocks.blockEnergizedHexoriumMagenta)
                    event.player.addStat(HexAchievements.achCraftEnergizedMagenta, 1);
                if (block == HexBlocks.blockEnergizedHexoriumPink)
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

                if (block == HexBlocks.blockEnergizedHexoriumWhite)
                    event.player.addStat(HexAchievements.achCraftEnergizedWhite, 1);
                if (block == HexBlocks.blockEnergizedHexoriumLightGray)
                    event.player.addStat(HexAchievements.achCraftEnergizedLightGray, 1);
                if (block == HexBlocks.blockEnergizedHexoriumGray)
                    event.player.addStat(HexAchievements.achCraftEnergizedGray, 1);
                if (block == HexBlocks.blockEnergizedHexoriumDarkGray)
                    event.player.addStat(HexAchievements.achCraftEnergizedDarkGray, 1);
                if (block == HexBlocks.blockEnergizedHexoriumBlack)
                    event.player.addStat(HexAchievements.achCraftEnergizedBlack, 1);

                if (playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftEnergizedWhite)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftEnergizedLightGray)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftEnergizedGray)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftEnergizedDarkGray)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftEnergizedBlack))
                    event.player.addStat(HexAchievements.achGroupGrays, 1);

                if (block == HexBlocks.blockEnergizedHexoriumRainbow)
                    event.player.addStat(HexAchievements.achCraftEnergizedRainbow, 1);
            }

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

            // T1 Machines
            else if (block instanceof BlockHexoriumCable)
                event.player.addStat(HexAchievements.achCraftCable, 1);

            else if (block == HexBlocks.blockHexoriumMachineBlock)
                event.player.addStat(HexAchievements.achCraftMachineBlock, 1);

            else if (block == HexBlocks.blockAdvancedRainbowCore)
                event.player.addStat(HexAchievements.achCraftAdvancedRainbowCore, 1);

            else if (block instanceof BlockEnergyNodeCore)
                event.player.addStat(HexAchievements.achCraftEnergyNodeCore, 1);

            else if (block instanceof IBlockHexEnergyPort)
                event.player.addStat(HexAchievements.achCraftEnergyNodePort, 1);

            // T2 Machines
            else if (block == HexBlocks.blockHexoriumGenerator) {
                event.player.addStat(HexAchievements.achCraftMachineGenerator, 1);
                checkMachines = true;
            }
            else if (block == HexBlocks.blockHexoriumFurnace) {
                event.player.addStat(HexAchievements.achCraftMachineFurnace, 1);
                checkMachines = true;
            }
            else if (block == HexBlocks.blockCrystalSeparator) {
                event.player.addStat(HexAchievements.achCraftMachineSeparator, 1);
                checkMachines = true;
            }
            else if (block == HexBlocks.blockMatrixReconstructor) {
                event.player.addStat(HexAchievements.achCraftMachineReconstructor, 1);
                checkMachines = true;
            }
            else if (block == HexBlocks.blockTankValve && HexConfig.cfgTankEnable) {
                event.player.addStat(HexAchievements.achCraftMachineTankValve, 1);
                checkMachines = true;
            }
            else if (block == HexBlocks.blockPersonalTeleportationPad && HexConfig.cfgTeleportEnable) {
                event.player.addStat(HexAchievements.achCraftMachineTeleport, 1);
                checkMachines = true;
            }
            else if (block == HexBlocks.blockEnergyPylon)
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
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftMachineFurnace)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftMachineSeparator)
                        && playerMP.func_147099_x().hasAchievementUnlocked(HexAchievements.achCraftMachineReconstructor)) {

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

                    if (teleportAch && tankAch)
                        event.player.addStat(HexAchievements.achGroupMachines, 1);
                }
            }
        }
    }
}
