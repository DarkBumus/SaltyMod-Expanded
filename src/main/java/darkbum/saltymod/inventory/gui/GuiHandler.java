package darkbum.saltymod.inventory.gui;

import darkbum.saltymod.inventory.container.*;
import darkbum.saltymod.tileentity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile_entity = world.getTileEntity(x, y, z);
        return switch (id) {
            case 0 -> new ContainerEvaporator(player.inventory, (TileEntityEvaporator) tile_entity);
            case 1 -> new ContainerFishFarm(player.inventory, (TileEntityFishFarm) tile_entity);
            case 2 -> new ContainerApiary(player.inventory, (TileEntityApiary) tile_entity);
            case 3 -> new ContainerPress(player.inventory, (TileEntityPress) tile_entity);
            case 4 -> new ContainerCookingPot(player.inventory, (TileEntityCookingPot) tile_entity);
            case 5 -> new ContainerClayOven(player.inventory, (TileEntityClayOven) tile_entity);
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
            case 4 -> new GuiCookingPot(player.inventory, (TileEntityCookingPot) tile_entity);
            case 5 -> new GuiClayOven(player.inventory, (TileEntityClayOven) tile_entity);
            default -> null;
        };
    }
}
