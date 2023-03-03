package darkbum.saltmod.network;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import java.util.UUID;

import darkbum.saltmod.api.RainMakerEvent;
import darkbum.saltmod.common.CommonProxy;
import darkbum.saltmod.init.AchievSalt;
import darkbum.saltmod.init.ModBlocks;
import darkbum.saltmod.init.ModItems;
import darkbum.saltmod.init.SaltConfig;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fluids.FluidRegistry;

public class SaltModEvent {
    private static final UUID uuid1 = UUID.fromString("ca3f8f85-df1e-4fe8-8cf6-e7030f33ed8e");

    private static final UUID uuid2 = UUID.fromString("42e70891-8397-4cf0-aca3-1a1d237768eb");

    private static final UUID uuid3 = UUID.fromString("b94a045b-f0e9-413a-86fe-2a8473f9ce9d");

    private static final UUID uuid4 = UUID.fromString("8fc1c0b4-350a-45d8-83c7-c788ec55b501");

    private static final AttributeModifier headModifierUP = new AttributeModifier(uuid1, "mudBoostUP", 4.0D, 0);

    private static final AttributeModifier bodyModifierUP = new AttributeModifier(uuid2, "mudBoostUP", 6.0D, 0);

    private static final AttributeModifier legsModifierUP = new AttributeModifier(uuid3, "mudBoostUP", 6.0D, 0);

    private static final AttributeModifier feetModifierUP = new AttributeModifier(uuid4, "mudBoostUP", 4.0D, 0);

    @SubscribeEvent
    public void onPlayerAttack(AttackEntityEvent e) {
        World world = e.entityPlayer.worldObj;
        if (!world.isRemote && e.target instanceof EntityLivingBase) {
            EntityPlayer player = e.entityPlayer;
            EntityLivingBase target = (EntityLivingBase)e.target;
            ItemStack is = player.getHeldItem();
            Block block = null;
            if (is != null && EntityList.getEntityString(target) != null && ((
                EntityList.getEntityString(target).toLowerCase().contains("slime") &&
                    !EntityList.getEntityString(target).toLowerCase().contains("lava")) ||
                EntityList.getEntityString(target).toLowerCase().contains("witch"))) {
                if (is.getItem() instanceof net.minecraft.item.ItemBlock && Block.getBlockFromItem(is.getItem()) != Blocks.air)
                    block = Block.getBlockFromItem(is.getItem());
                if (block != null && block == ModBlocks.saltCrystal) {
                    target.attackEntityFrom(DamageSource.cactus, 30.0F);
                    world.playSoundEffect(target.posX, target.posY, target.posZ, "dig.stone", 2.0F, 1.0F);
                    world.playSoundEffect(target.posX, target.posY, target.posZ, "dig.glass", 2.0F, 2.0F);
                    if (!player.capabilities.isCreativeMode) {
                        is.stackSize--;
                        if (is.stackSize == 0)
                            player.setCurrentItemOrArmor(0, null);
                        EntityItem EI = new EntityItem(world, target.posX, target.posY, target.posZ, new ItemStack(ModItems.saltPinch));
                        EI.delayBeforeCanPickup = 10;
                        world.spawnEntityInWorld(EI);
                        if (EntityList.getEntityString(target).toLowerCase().contains("witch"))
                            player.addStat(AchievSalt.saltWitch, 1);
                        if (target instanceof net.minecraft.entity.monster.EntitySlime) {
                            EntityItem EIS = new EntityItem(world, target.posX, target.posY, target.posZ, new ItemStack(ModItems.toughJelly));
                            EI.delayBeforeCanPickup = 10;
                            world.spawnEntityInWorld(EIS);
                            player.addStat(AchievSalt.saltSlime, 1);
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void updatePlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START && event.side == Side.SERVER) {
            EntityPlayer player = event.player;
            if (player != null) {
                ItemStack head = player.getCurrentArmor(3);
                ItemStack body = player.getCurrentArmor(2);
                ItemStack legs = player.getCurrentArmor(1);
                ItemStack feet = player.getCurrentArmor(0);
                boolean mud = (player.worldObj.getBlock(MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posY), MathHelper.floor_double(player.posZ)) == ModBlocks.mudBlock);
                IAttributeInstance boost = event.player.getEntityAttribute(SharedMonsterAttributes.maxHealth);
                if (head != null && boost.getModifier(uuid1) == null && head.getItem() == ModItems.mudHelmet)
                    boost.applyModifier(headModifierUP);
                if ((head == null || head.getItem() != ModItems.mudHelmet) && boost.getModifier(uuid1) != null) {
                    boost.removeModifier(headModifierUP);
                    if (player.getHealth() > player.getMaxHealth())
                        player.setHealth(player.getMaxHealth());
                }
                if (body != null && boost.getModifier(uuid2) == null && body.getItem() == ModItems.mudChestplate)
                    boost.applyModifier(bodyModifierUP);
                if ((body == null || body.getItem() != ModItems.mudChestplate) && boost.getModifier(uuid2) != null) {
                    boost.removeModifier(bodyModifierUP);
                    if (player.getHealth() > player.getMaxHealth())
                        player.setHealth(player.getMaxHealth());
                    if (legs != null && boost.getModifier(uuid3) == null && legs.getItem() == ModItems.mudLeggings)
                        boost.applyModifier(legsModifierUP);
                    if ((legs == null || legs.getItem() != ModItems.mudLeggings) && boost.getModifier(uuid3) != null) {
                        boost.removeModifier(legsModifierUP);
                        if (player.getHealth() > player.getMaxHealth())
                            player.setHealth(player.getMaxHealth());
                    }
                    if (((feet != null && feet.getItem() == ModItems.mudBoots) || mud) && boost.getModifier(uuid4) == null)
                        boost.applyModifier(feetModifierUP);
                    if ((feet == null || feet.getItem() != ModItems.mudBoots) && !mud && boost.getModifier(uuid4) != null) {
                        boost.removeModifier(feetModifierUP);
                        if (player.getHealth() > player.getMaxHealth())
                            player.setHealth(player.getMaxHealth());
                    }
                    if (player.getHealth() < player.getMaxHealth() && player.getFoodStats().getFoodLevel() > 0) {
                        int chek = 0;
                        if (head != null && head.getItem() == ModItems.mudHelmet)
                            chek++;
                        if (body != null && body.getItem() == ModItems.mudChestplate)
                            chek += 2;
                        if (legs != null && legs.getItem() == ModItems.mudLeggings)
                            chek += 2;
                        if ((feet != null && feet.getItem() == ModItems.mudBoots) || mud)
                            chek++;
                        if (chek > 0) {
                            if (player.ticksExisted % (10 - chek) * SaltConfig.mudRegenSpeed == 0)
                                player.heal(1.0F);
                            if (chek == 6) {
                                if (player.isBurning())
                                    player.extinguish();
                                event.player.addStat(AchievSalt.fullMud, 1);
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
                event.player.addStat(AchievSalt.rain, 1);
        }
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void registerIcons(TextureStitchEvent.Pre event) {
        if (event.map.getTextureType() == 0 && FluidRegistry.isFluidRegistered(CommonProxy.milk))
            CommonProxy.milkIcon = event.map.registerIcon("saltmod:Milk");
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
                event.entityPlayer.addStat(AchievSalt.salt, 1);
            if (event.item.getEntityItem().getItem() == Item.getItemFromBlock(ModBlocks.saltCrystal))
                event.entityPlayer.addStat(AchievSalt.saltCrystalGet, 1);
            if (event.item.getEntityItem().getItem() == ModItems.mineralMud)
                event.entityPlayer.addStat(AchievSalt.mineralMud, 1);
            if (event.item.getEntityItem().getItem() == ModItems.saltWortSeed)
                event.entityPlayer.addStat(AchievSalt.saltWort, 1);
        }
    }

    @SubscribeEvent
    public void crafting(PlayerEvent.ItemCraftedEvent event) {
        if (event.crafting.getItem() == ModItems.mineralMud)
            event.player.addStat(AchievSalt.mineralMud, 1);
    }

    @SubscribeEvent
    public void breakBlock(BlockEvent.HarvestDropsEvent event) {
        if (event.world.getTileEntity(event.x, event.y, event.z) != null && event.world
            .getTileEntity(event.x, event.y, event.z) instanceof TileEntityFlowerPot) {
            TileEntityFlowerPot te = (TileEntityFlowerPot)event.world.getTileEntity(event.x, event.y, event.z);
            if (te.getFlowerPotItem() == Item.getItemFromBlock(ModBlocks.saltWort))
                event.drops.set(1, new ItemStack(ModItems.saltWortSeed));
        }
    }
}
