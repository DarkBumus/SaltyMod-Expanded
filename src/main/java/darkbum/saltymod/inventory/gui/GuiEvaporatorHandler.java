package darkbum.saltymod.inventory.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import darkbum.saltymod.tileentity.TileEntityEvaporator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import darkbum.saltymod.inventory.container.ContainerEvaporator;

public class GuiEvaporatorHandler implements IGuiHandler {
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile_entity = world.getTileEntity(x, y, z);
        switch (id) {
            case 0:
                return new ContainerEvaporator(player.inventory, (TileEntityEvaporator)tile_entity);
        }
        return null;
    }

    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile_entity = world.getTileEntity(x, y, z);
        switch (id) {
            case 0:
                return new GuiEvaporator(player.inventory, (TileEntityEvaporator)tile_entity);
        }
        return null;
    }
}
