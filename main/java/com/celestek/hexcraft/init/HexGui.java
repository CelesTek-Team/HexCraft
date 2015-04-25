package com.celestek.hexcraft.init;

import com.celestek.hexcraft.inventory.ContainerMatrixReconstructor;
import com.celestek.hexcraft.inventory.GuiMatrixReconstructor;
import com.celestek.hexcraft.tileentity.TileEntityMatrixReconstructor;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-04-25
 */
public class HexGui implements IGuiHandler {


    public HexGui (){

    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == 0){
            TileEntityMatrixReconstructor tileEntityMatrixReconstructor = (TileEntityMatrixReconstructor) world.getTileEntity(x, y, z);
            return new ContainerMatrixReconstructor(player.inventory, tileEntityMatrixReconstructor);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == 0){
            TileEntityMatrixReconstructor tileEntityMatrixReconstructor = (TileEntityMatrixReconstructor) world.getTileEntity(x, y, z);
            return new GuiMatrixReconstructor(player.inventory, tileEntityMatrixReconstructor);
        }
        return null;
    }
}
