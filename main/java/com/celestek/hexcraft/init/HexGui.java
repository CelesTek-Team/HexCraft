package com.celestek.hexcraft.init;

import com.celestek.hexcraft.gui.*;
import com.celestek.hexcraft.inventory.*;
import com.celestek.hexcraft.tileentity.*;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.6.1
 * @since 2015-04-25
 */
public class HexGui implements IGuiHandler {


    public HexGui () {}

    /**
     * Retrieves the server side of the GUI.
     */
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        // Get different GUI depending on ID.
        if(ID == 0){
            TileHexoriumGenerator tileEntity = (TileHexoriumGenerator) world.getTileEntity(x, y, z);
            return new ContainerHexoriumGenerator(player.inventory, tileEntity);
        }
        else if(ID == 1){
            TileHexoriumFurnace tileEntity = (TileHexoriumFurnace) world.getTileEntity(x, y, z);
            return new ContainerHexoriumFurnace(player.inventory, tileEntity);
        }
        else if(ID == 2){
            TileCrystalSeparator tileEntity = (TileCrystalSeparator) world.getTileEntity(x, y, z);
            return new ContainerCrystalSeparator(player.inventory, tileEntity);
        }
        else if(ID == 3){
            TileMatrixReconstructor tileEntity = (TileMatrixReconstructor) world.getTileEntity(x, y, z);
            return new ContainerMatrixReconstructor(player.inventory, tileEntity);
        }
        else if(ID == 4){
            TilePersonalTeleportationPad tileEntity = (TilePersonalTeleportationPad) world.getTileEntity(x, y, z);
            return new ContainerPersonalTeleportationPad(player.inventory, tileEntity);
        }
        else if(ID == 5){
            ItemStack itemStack = player.getCurrentEquippedItem();
            return new ContainerMolecularTransposer(player, player.inventory, itemStack);
        }
        return null;
    }

    /**
     * Retrieves the client side of the GUI.
     */
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        // Get different GUI depending on ID.
        if(ID == 0){
            TileHexoriumGenerator tileEntity = (TileHexoriumGenerator) world.getTileEntity(x, y, z);
            return new GuiHexoriumGenerator(player.inventory, tileEntity);
        }
        else if(ID == 1){
            TileHexoriumFurnace tileEntity = (TileHexoriumFurnace) world.getTileEntity(x, y, z);
            return new GuiHexoriumFurnace(player.inventory, tileEntity);
        }
        else if(ID == 2){
            TileCrystalSeparator tileEntity = (TileCrystalSeparator) world.getTileEntity(x, y, z);
            return new GuiCrystalSeparator(player.inventory, tileEntity);
        }
        else if(ID == 3){
            TileMatrixReconstructor tileEntity = (TileMatrixReconstructor) world.getTileEntity(x, y, z);
            return new GuiMatrixReconstructor(player.inventory, tileEntity);
        }
        else if(ID == 4){
            TilePersonalTeleportationPad tileEntity = (TilePersonalTeleportationPad) world.getTileEntity(x, y, z);
            return new GuiPersonalTeleportationPad(player.inventory, tileEntity);
        }
        else if(ID == 5){
            ItemStack itemStack = player.getCurrentEquippedItem();
            return new GuiMolecularTransposer(player, player.inventory, itemStack);
        }
        return null;
    }
}
