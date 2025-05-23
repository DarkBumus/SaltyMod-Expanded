package darkbum.saltymod.event;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraftforge.event.world.BlockEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;

/**
 * Event handler class for block harvesting-related events.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class BlockHarvestDropsEventHandler {

    /**
     * Handles the modifying of the drops from flower pots containing saltworts.
     * If a flower pot contains a saltwort, the drop is replaced with a saltwort item.
     *
     * @param event The block harvest event containing information about the block and its drops.
     */
    @SuppressWarnings("unused")
    @SubscribeEvent
    public void onBlockHarvest(BlockEvent.HarvestDropsEvent event) {
        if (event.world.getTileEntity(event.x, event.y, event.z) instanceof TileEntityFlowerPot tileEntityFlowerPot) {
            if (tileEntityFlowerPot.getFlowerPotItem() == Item.getItemFromBlock(ModBlocks.saltworts)) {
                event.drops.set(1, new ItemStack(ModItems.saltwort));
            }
        }
    }
}
