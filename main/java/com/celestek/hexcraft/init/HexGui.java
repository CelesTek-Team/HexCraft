package com.celestek.hexcraft.init;

import com.celestek.hexcraft.inventory.*;
import com.celestek.hexcraft.tileentity.TileCrystalSeparator;
import com.celestek.hexcraft.tileentity.TileHexoriumFurnace;
import com.celestek.hexcraft.tileentity.TileHexoriumGenerator;
import com.celestek.hexcraft.tileentity.TileMatrixReconstructor;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
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
        if(ID == 1){
            TileHexoriumFurnace tileEntity = (TileHexoriumFurnace) world.getTileEntity(x, y, z);
            return new ContainerHexoriumFurnace(player.inventory, tileEntity);
        }
        if(ID == 2){
            TileCrystalSeparator tileEntity = (TileCrystalSeparator) world.getTileEntity(x, y, z);
            return new ContainerCrystalSeparator(player.inventory, tileEntity);
        }
        if(ID == 3){
            TileMatrixReconstructor tileEntity = (TileMatrixReconstructor) world.getTileEntity(x, y, z);
            return new ContainerMatrixReconstructor(player.inventory, tileEntity);
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
        if(ID == 1){
            TileHexoriumFurnace tileEntity = (TileHexoriumFurnace) world.getTileEntity(x, y, z);
            return new GuiHexoriumFurnace(player.inventory, tileEntity);
        }
        if(ID == 2){
            TileCrystalSeparator tileEntity = (TileCrystalSeparator) world.getTileEntity(x, y, z);
            return new GuiCrystalSeparator(player.inventory, tileEntity);
        }
        if(ID == 3){
            TileMatrixReconstructor tileEntity = (TileMatrixReconstructor) world.getTileEntity(x, y, z);
            return new GuiMatrixReconstructor(player.inventory, tileEntity);
        }
        return null;
    }
}
