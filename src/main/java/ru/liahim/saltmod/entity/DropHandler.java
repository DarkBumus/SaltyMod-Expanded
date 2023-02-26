package ru.liahim.saltmod.entity;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import java.util.Random;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import ru.liahim.saltmod.init.ModItems;

public class DropHandler {

    public static Random random;
    public static int dropped;

@SubscribeEvent
    public void onEntityDrop(LivingDropsEvent event) {

    random = new Random();
    dropped = random.nextInt(2);

    int dropAmountHorse = random.nextInt(2) + 1;
    int dropAmountSquid = random.nextInt(3) + 1;
    if (event.entityLiving instanceof net.minecraft.entity.passive.EntitySquid)
        if (event.entityLiving.isBurning()) {
            event.entityLiving.entityDropItem(new ItemStack(ModItems.calamariCooked, dropAmountSquid), dropped);
        } else {
            event.entityLiving.entityDropItem(new ItemStack(ModItems.calamariRaw, dropAmountSquid), dropped);
        }

    if (event.entityLiving instanceof net.minecraft.entity.passive.EntityHorse && !event.entityLiving.isChild())
        if (event.entityLiving.isBurning()) {
            event.entityLiving.entityDropItem(new ItemStack(ModItems.haunchCooked, dropAmountHorse), dropped);
        } else {
            event.entityLiving.entityDropItem(new ItemStack(ModItems.haunchRaw, dropAmountHorse), dropped);
        }       }
}
