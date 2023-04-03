package darkbum.saltymod.network;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.api.RainMakerEvent;
import darkbum.saltymod.common.CommonProxy;
import darkbum.saltymod.init.*;
import darkbum.saltymod.world.biome.SaltMarshBiome;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
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

public class SaltModEventHandler {
    private static final UUID uuid1 = UUID.fromString("ca3f8f85-df1e-4fe8-8cf6-e7030f33ed8e");

    private static final UUID uuid2 = UUID.fromString("42e70891-8397-4cf0-aca3-1a1d237768eb");

    private static final UUID uuid3 = UUID.fromString("b94a045b-f0e9-413a-86fe-2a8473f9ce9d");

    private static final UUID uuid4 = UUID.fromString("8fc1c0b4-350a-45d8-83c7-c788ec55b501");

    private static final AttributeModifier headModifierUP = new AttributeModifier(uuid1, "mudBoostUP", 4.0D, 0);

    private static final AttributeModifier bodyModifierUP = new AttributeModifier(uuid2, "mudBoostUP", 6.0D, 0);

    private static final AttributeModifier legsModifierUP = new AttributeModifier(uuid3, "mudBoostUP", 6.0D, 0);

    private static final AttributeModifier feetModifierUP = new AttributeModifier(uuid4, "mudBoostUP", 4.0D, 0);

    public static Random random;

    public static int dropped;

    @SubscribeEvent
    public void updatePlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START && event.side == Side.SERVER) {
            EntityPlayer player = event.player;
            if (player != null) {
                ItemStack head = player.getCurrentArmor(3);
                ItemStack body = player.getCurrentArmor(2);
                ItemStack legs = player.getCurrentArmor(1);
                ItemStack feet = player.getCurrentArmor(0);
                boolean mud = (player.worldObj.getBlock(MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posY), MathHelper.floor_double(player.posZ)) == ModBlocks.mineral_mud);
                IAttributeInstance boost = event.player.getEntityAttribute(SharedMonsterAttributes.maxHealth);
                if (head != null && boost.getModifier(uuid1) == null && head.getItem() == ModItems.mud_helmet)
                    boost.applyModifier(headModifierUP);
                if ((head == null || head.getItem() != ModItems.mud_helmet) && boost.getModifier(uuid1) != null) {
                    boost.removeModifier(headModifierUP);
                    if (player.getHealth() > player.getMaxHealth())
                        player.setHealth(player.getMaxHealth());
                }
                if (body != null && boost.getModifier(uuid2) == null && body.getItem() == ModItems.mud_chestplate)
                    boost.applyModifier(bodyModifierUP);
                if ((body == null || body.getItem() != ModItems.mud_chestplate) && boost.getModifier(uuid2) != null) {
                    boost.removeModifier(bodyModifierUP);
                    if (player.getHealth() > player.getMaxHealth())
                        player.setHealth(player.getMaxHealth());
                    if (legs != null && boost.getModifier(uuid3) == null && legs.getItem() == ModItems.mud_leggings)
                        boost.applyModifier(legsModifierUP);
                    if ((legs == null || legs.getItem() != ModItems.mud_leggings) && boost.getModifier(uuid3) != null) {
                        boost.removeModifier(legsModifierUP);
                        if (player.getHealth() > player.getMaxHealth())
                            player.setHealth(player.getMaxHealth());
                    }
                    if (((feet != null && feet.getItem() == ModItems.mud_boots) || mud) && boost.getModifier(uuid4) == null)
                        boost.applyModifier(feetModifierUP);
                    if ((feet == null || feet.getItem() != ModItems.mud_boots) && !mud && boost.getModifier(uuid4) != null) {
                        boost.removeModifier(feetModifierUP);
                        if (player.getHealth() > player.getMaxHealth())
                            player.setHealth(player.getMaxHealth());
                    }
                    if (player.getHealth() < player.getMaxHealth() && player.getFoodStats().getFoodLevel() > 0) {
                        int check = 0;
                        if (head != null && head.getItem() == ModItems.mud_helmet)
                            check++;
                        if (body != null && body.getItem() == ModItems.mud_chestplate)
                            check += 2;
                        if (legs != null && legs.getItem() == ModItems.mud_leggings)
                            check += 2;
                        if ((feet != null && feet.getItem() == ModItems.mud_boots) || mud)
                            check++;
                        if (check > 0) {
                            if (player.ticksExisted % (10 - check) * ModConfiguration.mudRegenSpeed == 0)
                                player.heal(1.0F);
                            if (check == 6) {
                                if (player.isBurning())
                                    player.extinguish();
                                event.player.addStat(ModAchievementList.fullMudArmor, 1);
                            }
                        }
                    }
                }
            }
        }
    }

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
