package darkbum.saltymod.network;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import darkbum.saltymod.api.RainMakerEvent;
import darkbum.saltymod.common.CommonProxy;
import darkbum.saltymod.init.*;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fluids.FluidRegistry;

public class SaltyModEventHandler {

    public static Random random;

    public static int dropped;

    @SubscribeEvent
    public void addTempt(EntityJoinWorldEvent event) {
        if (event.entity instanceof EntityAnimal) {
            EntityAnimal animal = (EntityAnimal)event.entity;
            if (animal instanceof net.minecraft.entity.passive.EntityCow || animal instanceof net.minecraft.entity.passive.EntityHorse)
                animal.tasks.addTask(3, new EntityAITempt(animal, 1.25D, ModItems.salt, false));
            if (animal instanceof net.minecraft.entity.passive.EntityPig)
                animal.tasks.addTask(3, new EntityAITempt(animal, 1.25D, ModItems.onion, false));
        }
    }

    @SubscribeEvent
    public void addRain(RainMakerEvent event) {
        if (!event.world.isRemote) {
            int i = (300 + (new Random()).nextInt(600)) * 20;
            event.world.getWorldInfo().setRainTime(i);
            event.world.getWorldInfo().setRaining(true);
            if (event.isThunder) {
                event.world.getWorldInfo().setThunderTime(i);
                event.world.getWorldInfo().setThundering(true);
            } else {
                event.world.getWorldInfo().setThundering(false);
            }
            if (event.player != null)
                event.player.addStat(ModAchievementList.makeRain, 1);
        }
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void registerIcons(TextureStitchEvent.Pre event) {
        if (event.map.getTextureType() == 0 && FluidRegistry.isFluidRegistered(CommonProxy.milk))
            CommonProxy.milkIcon = event.map.registerIcon("saltymod:milk");
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void registerIcons(TextureStitchEvent.Post event) {
        if (FluidRegistry.isFluidRegistered(CommonProxy.milk))
            CommonProxy.milk.setIcons(CommonProxy.milkIcon);
    }

    @SubscribeEvent
    public void itemPickup(EntityItemPickupEvent event) {
        World world = event.entityPlayer.worldObj;
        if (!world.isRemote) {
            if (event.item.getEntityItem().getItem() == ModItems.salt)
                event.entityPlayer.addStat(ModAchievementList.findSalt, 1);
            if (event.item.getEntityItem().getItem() == ModItems.salt_shard)
                event.entityPlayer.addStat(ModAchievementList.findSaltCrystal, 1);
            if (event.item.getEntityItem().getItem() == ModItems.mineral_mud_ball)
                event.entityPlayer.addStat(ModAchievementList.findMineralMud, 1);
            if (event.item.getEntityItem().getItem() == ModItems.saltwort)
                event.entityPlayer.addStat(ModAchievementList.findSaltwort, 1);
            if (event.item.getEntityItem().getItem() == Item.getItemFromBlock(ModBlocks.dry_mud_brick))
                event.entityPlayer.addStat(ModAchievementList.findMudBrick, 1);
            if (event.item.getEntityItem().getItem() == Item.getItemFromBlock(ModBlocks.blossom_log))
                event.entityPlayer.addStat(ModAchievementList.findBlossomLog, 1);
        }
    }

    @SubscribeEvent
    public void crafting(PlayerEvent.ItemCraftedEvent event) {
        if (event.crafting.getItem() == ModItems.mineral_mud_ball)
            event.player.addStat(ModAchievementList.findMineralMud, 1);
        if (event.crafting.getItem() == Item.getItemFromBlock(ModBlocks.apiary))
            event.player.addStat(ModAchievementList.craftApiary, 1);
    }

    @SubscribeEvent
    public void breakBlock(BlockEvent.HarvestDropsEvent event) {
        if (event.world.getTileEntity(event.x, event.y, event.z) != null &&
            event.world.getTileEntity(event.x, event.y, event.z) instanceof TileEntityFlowerPot) {
            TileEntityFlowerPot te = (TileEntityFlowerPot)event.world.getTileEntity(event.x, event.y, event.z);
            if (te.getFlowerPotItem() == Item.getItemFromBlock(ModBlocks.saltworts))
                event.drops.set(1, new ItemStack(ModItems.saltwort));
        }
    }

    @SubscribeEvent
    public void navigateBiome(TickEvent.PlayerTickEvent event) {
        int px = MathHelper.floor_double(event.player.posX);
        int pz = MathHelper.floor_double(event.player.posZ);
        if (event.player.worldObj.getBiomeGenForCoords(px, pz) == ModBiomes.saltMarsh)
            event.player.addStat(ModAchievementList.navSaltMarsh, 1);
    }

    @SubscribeEvent
    public void onEntityDrop(LivingDropsEvent event) {

        random = new Random();
        dropped = random.nextInt(2);

        int dropAmountHorse = random.nextInt(2) + 1;
        int dropAmountSquid = random.nextInt(3) + 1;
        int dropAmountZombie = 1;
        int dropAmountStrider = 1;

        if (event.entityLiving instanceof net.minecraft.entity.monster.EntityZombie &&
            !event.entityLiving.isChild() &&
            ThreadLocalRandom.current().nextInt(0, 1000) < 25) {
            event.entityLiving.entityDropItem(new ItemStack(ModItems.onion, dropAmountZombie), dropped);
        } else if (event.entityLiving instanceof net.minecraft.entity.passive.EntitySquid) {
            if (event.entityLiving.isBurning()) {
                event.entityLiving.entityDropItem(new ItemStack(ModItems.cooked_calamari, dropAmountSquid), dropped);
            } else {
                event.entityLiving.entityDropItem(new ItemStack(ModItems.calamari, dropAmountSquid), dropped);
            }
        } else if (event.entityLiving instanceof net.minecraft.entity.passive.EntityHorse && !event.entityLiving.isChild()) {
            if (event.entityLiving.isBurning()) {
                event.entityLiving.entityDropItem(new ItemStack(ModItems.cooked_haunch, dropAmountHorse), dropped);
            } else {
                event.entityLiving.entityDropItem(new ItemStack(ModItems.haunch, dropAmountHorse), dropped);
            }
        } else if (event.entityLiving instanceof net.minecraft.entity.passive.EntityBat) {
            if (event.entityLiving.isBurning()) {
                event.entityLiving.entityDropItem(new ItemStack(ModItems.cooked_strider, dropAmountStrider), dropped);
            } else {
                event.entityLiving.entityDropItem(new ItemStack(ModItems.strider, dropAmountStrider), dropped);
            }
        }
    }
}
