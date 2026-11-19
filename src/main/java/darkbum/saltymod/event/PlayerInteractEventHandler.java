package darkbum.saltymod.event;

import darkbum.saltymod.util.HoeHarvestHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import static darkbum.saltymod.common.config.ModConfigurationVanillaChanges.*;

public class PlayerInteractEventHandler {

    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (!enableHoeHarvesting) return;

        if (event.action != PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        EntityPlayer player = event.entityPlayer;
        ItemStack heldItem = player.getCurrentEquippedItem();

        if (heldItem == null || !(heldItem.getItem() instanceof ItemHoe)) {
            return;
        }

        World world = event.world;

        int x = event.x;
        int y = event.y;
        int z = event.z;

        if (!player.canPlayerEdit(x, y, z, event.face, heldItem)) {
            return;
        }

        if (HoeHarvestHelper.isHarvestable(world, x, y, z)) {
            return;
        }

        // Only cancel and harvest on the server.
        if (!world.isRemote) {
            java.util.List<net.minecraft.item.ItemStack> drops = HoeHarvestHelper.harvest(world, x, y, z);

            if (drops == null) return;

            event.setCanceled(true);

            HoeHarvestHelper.spawnDrops(world, x, y, z, drops);

            // Damage the hoe exactly once per manual harvest.
            heldItem.damageItem(1, player);
        }
    }
}
