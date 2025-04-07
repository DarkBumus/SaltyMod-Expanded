package darkbum.saltymod.inventory.gui;

import darkbum.saltymod.inventory.container.ContainerPress;
import darkbum.saltymod.tileentity.TileEntityPress;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.IGuiHandler;
import darkbum.saltymod.inventory.container.ContainerApiary;
import darkbum.saltymod.inventory.container.ContainerEvaporator;
import darkbum.saltymod.inventory.container.ContainerFishFarm;
import darkbum.saltymod.tileentity.TileEntityApiary;
import darkbum.saltymod.tileentity.TileEntityEvaporator;
import darkbum.saltymod.tileentity.TileEntityFishFarm;

public class GuiHandler implements IGuiHandler {

    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile_entity = world.getTileEntity(x, y, z);
        return switch (id) {
            case 0 -> new ContainerEvaporator(player.inventory, (TileEntityEvaporator) tile_entity);
            case 1 -> new ContainerFishFarm(player.inventory, (TileEntityFishFarm) tile_entity);
            case 2 -> new ContainerApiary(player.inventory, (TileEntityApiary) tile_entity);
            case 3 -> new ContainerPress(player.inventory, (TileEntityPress) tile_entity);
            default -> null;
        };
    }

    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile_entity = world.getTileEntity(x, y, z);
        return switch (id) {
            case 0 -> new GuiEvaporator(player.inventory, (TileEntityEvaporator) tile_entity);
            case 1 -> new GuiFishFarm(player.inventory, (TileEntityFishFarm) tile_entity);
            case 2 -> new GuiApiary(player.inventory, (TileEntityApiary) tile_entity);
            case 3 -> new GuiPress(player.inventory, (TileEntityPress) tile_entity);
            default -> null;
        };
    }
}
