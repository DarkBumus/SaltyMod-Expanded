package darkbum.saltymod.network.events;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraftforge.event.world.BlockEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;

public class BlockHarvestDropsEventHandler {

    @SubscribeEvent
    public void blockHarvestDrops1(BlockEvent.HarvestDropsEvent event) {
        if (event.world.getTileEntity(event.x, event.y, event.z) != null
            && event.world.getTileEntity(event.x, event.y, event.z) instanceof TileEntityFlowerPot) {
            TileEntityFlowerPot te = (TileEntityFlowerPot) event.world.getTileEntity(event.x, event.y, event.z);
            if (te.getFlowerPotItem() == Item.getItemFromBlock(ModBlocks.saltworts)) {
                event.drops.set(1, new ItemStack(ModItems.saltwort));
            }
        }
    }
}
