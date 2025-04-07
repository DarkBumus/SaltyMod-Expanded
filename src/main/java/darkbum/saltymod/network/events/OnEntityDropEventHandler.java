package darkbum.saltymod.network.events;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkbum.saltymod.init.ModItems;

public class OnEntityDropEventHandler {

    public static Random random;

    public static int dropped;

    @SubscribeEvent
    public void onEntityDrop(LivingDropsEvent event) {

        random = new Random();
        dropped = random.nextInt(2);

        int dropAmountHorse = random.nextInt(2) + 1;
        int dropAmountSquid = random.nextInt(3) + 1;
        int dropAmountZombie = 1;
        int dropAmountStrider = 1;

        if (event.entityLiving instanceof net.minecraft.entity.monster.EntityZombie && !event.entityLiving.isChild()
            && ThreadLocalRandom.current()
                .nextInt(0, 1000) < 25) {
            event.entityLiving.entityDropItem(new ItemStack(ModItems.onion, dropAmountZombie), dropped);
        } else if (event.entityLiving instanceof net.minecraft.entity.passive.EntitySquid) {
            if (event.entityLiving.isBurning()) {
                event.entityLiving.entityDropItem(new ItemStack(ModItems.cooked_calamari, dropAmountSquid), dropped);
            } else {
                event.entityLiving.entityDropItem(new ItemStack(ModItems.calamari, dropAmountSquid), dropped);
            }
        } else if (event.entityLiving instanceof net.minecraft.entity.passive.EntityHorse
            && !event.entityLiving.isChild()) {
                if (event.entityLiving.isBurning()) {
                    event.entityLiving.entityDropItem(new ItemStack(ModItems.cooked_haunch, dropAmountHorse), dropped);
                } else {
                    event.entityLiving.entityDropItem(new ItemStack(ModItems.haunch, dropAmountHorse), dropped);
                }
            } else if (event.entityLiving instanceof net.minecraft.entity.passive.EntityBat) {
                if (event.entityLiving.isBurning()) {
                    event.entityLiving
                        .entityDropItem(new ItemStack(ModItems.cooked_strider, dropAmountStrider), dropped);
                } else {
                    event.entityLiving.entityDropItem(new ItemStack(ModItems.strider, dropAmountStrider), dropped);
                }
            }
    }
}
