package com.celestek.hexcraft.init;

import com.celestek.hexcraft.client.gui.*;
import com.celestek.hexcraft.container.*;
import com.celestek.hexcraft.tileentity.*;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.7.0
 */

public class HexGui implements IGuiHandler {

    public static final int GUI_ID_HEXORIUM_GENERATOR = 0;
    public static final int GUI_ID_HEXORIUM_FURNACE = 1;
    public static final int GUI_ID_CRYSTAL_SEPARATOR = 2;
    public static final int GUI_ID_MATRIX_RECONSTRUCTOR = 3;
    public static final int GUI_ID_PERSONAL_TELEPORTATION_PAD = 4;
    public static final int GUI_ID_MOLECULAR_TRANSPOSER = 5;
    public static final int GUI_ID_TANK_VALVE = 6;

    public HexGui () {}

    /**
     * Retrieves the server side of the GUI.
     */
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        // Get different GUI depending on ID.
        if(ID == GUI_ID_HEXORIUM_GENERATOR) {
            TileHexoriumGenerator tileEntity = (TileHexoriumGenerator) world.getTileEntity(x, y, z);
            return new ContainerHexoriumGenerator(player.inventory, tileEntity);
        }
        else if(ID == GUI_ID_HEXORIUM_FURNACE) {
            TileHexoriumFurnace tileEntity = (TileHexoriumFurnace) world.getTileEntity(x, y, z);
            return new ContainerHexoriumFurnace(player.inventory, tileEntity);
        }
        else if(ID == GUI_ID_CRYSTAL_SEPARATOR) {
            TileCrystalSeparator tileEntity = (TileCrystalSeparator) world.getTileEntity(x, y, z);
            return new ContainerCrystalSeparator(player.inventory, tileEntity);
        }
        else if(ID == GUI_ID_MATRIX_RECONSTRUCTOR) {
            TileMatrixReconstructor tileEntity = (TileMatrixReconstructor) world.getTileEntity(x, y, z);
            return new ContainerMatrixReconstructor(player.inventory, tileEntity);
        }
        else if(ID == GUI_ID_PERSONAL_TELEPORTATION_PAD) {
            TilePersonalTeleportationPad tileEntity = (TilePersonalTeleportationPad) world.getTileEntity(x, y, z);
            return new ContainerPersonalTeleportationPad(tileEntity);
        }
        else if(ID == GUI_ID_MOLECULAR_TRANSPOSER) {
            ItemStack itemStack = player.getCurrentEquippedItem();
            return new ContainerMolecularTransposer(player, player.inventory, itemStack);
        }
        else if(ID == GUI_ID_TANK_VALVE) {
            TileTankValve tileEntity = (TileTankValve) world.getTileEntity(x, y, z);
            return new ContainerTankValve(tileEntity);
        }
        return null;
    }

    /**
     * Retrieves the client side of the GUI.
     */
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        // Get different GUI depending on ID.
        if(ID == GUI_ID_HEXORIUM_GENERATOR) {
            TileHexoriumGenerator tileEntity = (TileHexoriumGenerator) world.getTileEntity(x, y, z);
            return new GuiHexoriumGenerator(player.inventory, tileEntity);
        }
        else if(ID == GUI_ID_HEXORIUM_FURNACE) {
            TileHexoriumFurnace tileEntity = (TileHexoriumFurnace) world.getTileEntity(x, y, z);
            return new GuiHexoriumFurnace(player.inventory, tileEntity);
        }
        else if(ID == GUI_ID_CRYSTAL_SEPARATOR) {
            TileCrystalSeparator tileEntity = (TileCrystalSeparator) world.getTileEntity(x, y, z);
            return new GuiCrystalSeparator(player.inventory, tileEntity);
        }
        else if(ID == GUI_ID_MATRIX_RECONSTRUCTOR) {
            TileMatrixReconstructor tileEntity = (TileMatrixReconstructor) world.getTileEntity(x, y, z);
            return new GuiMatrixReconstructor(player.inventory, tileEntity);
        }
        else if(ID == GUI_ID_PERSONAL_TELEPORTATION_PAD) {
            TilePersonalTeleportationPad tileEntity = (TilePersonalTeleportationPad) world.getTileEntity(x, y, z);
            return new GuiPersonalTeleportationPad(tileEntity);
        }
        else if(ID == GUI_ID_MOLECULAR_TRANSPOSER) {
            ItemStack itemStack = player.getCurrentEquippedItem();
            return new GuiMolecularTransposer(player, player.inventory, itemStack);
        }
        else if(ID == GUI_ID_TANK_VALVE) {
            TileTankValve tileEntity = (TileTankValve) world.getTileEntity(x, y, z);
            return new GuiTankValve(tileEntity);
        }
        return null;
    }
}
