package ru.liahim.saltmod.inventory.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ru.liahim.saltmod.inventory.container.ContainerExtractor;
import ru.liahim.saltmod.tileentity.TileEntityExtractor;

public class GuiExtractorHandler implements IGuiHandler {
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile_entity = world.getTileEntity(x, y, z);
        switch (id) {
            case 0:
                return new ContainerExtractor(player.inventory, (TileEntityExtractor)tile_entity);
        }
        return null;
    }

    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile_entity = world.getTileEntity(x, y, z);
        switch (id) {
            case 0:
                return new GuiExtractor(player.inventory, (TileEntityExtractor)tile_entity);
        }
        return null;
    }
}
