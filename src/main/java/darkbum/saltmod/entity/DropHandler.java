package darkbum.saltmod.entity;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import darkbum.saltmod.init.ModItems;
import ganymedes01.etfuturum.items.equipment.ItemEFRArmour;
import net.minecraft.block.BlockEnchantmentTable;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraft.block.*;

public class DropHandler {

    public static Random random;
    public static int dropped;

    @SubscribeEvent
    public void onEntityDrop(LivingDropsEvent event) {

        random = new Random();
        dropped = random.nextInt(2);

        int dropAmountHorse = random.nextInt(2) + 1;
        int dropAmountSquid = random.nextInt(3) + 1;
        int dropAmountZombie = 1;
        if (event.entityLiving instanceof net.minecraft.entity.passive.EntitySquid)
            if (event.entityLiving.isBurning()) {
                event.entityLiving.entityDropItem(new ItemStack(ModItems.calamariCooked, dropAmountSquid), dropped);
            } else {
                event.entityLiving.entityDropItem(new ItemStack(ModItems.calamariRaw, dropAmountSquid), dropped);
            }
        if (event.entityLiving instanceof net.minecraft.entity.passive.EntityHorse &&
            !event.entityLiving.isChild())
            if (event.entityLiving.isBurning()) {
                event.entityLiving.entityDropItem(new ItemStack(ModItems.haunchCooked, dropAmountHorse), dropped);
            } else {
                event.entityLiving.entityDropItem(new ItemStack(ModItems.haunchRaw, dropAmountHorse), dropped);
            }
        if (event.entityLiving instanceof net.minecraft.entity.monster.EntityZombie &&
            !event.entityLiving.isChild() &&
            ThreadLocalRandom.current().nextInt(0, 1000) < 25) {
            event.entityLiving.entityDropItem(new ItemStack(ModItems.onion, dropAmountZombie), dropped);
        }
    }


    @SubscribeEvent
    public void onDrops(BlockEvent.HarvestDropsEvent event) {

        if (event.block == Blocks.red_flower &&
            event.blockMetadata == 2 &&
            event.harvester != null &&
            event.harvester.getHeldItem() != null &&
            event.harvester.getHeldItem().getItem() instanceof ItemHoe) {
            event.drops.add(new ItemStack(ModItems.onion));
        }
    }
}
