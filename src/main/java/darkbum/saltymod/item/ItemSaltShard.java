package darkbum.saltymod.item;

import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class ItemSaltShard extends Item {

    public ItemSaltShard(String name, CreativeTabs tab) {
        setUnlocalizedName(name);
        setCreativeTab(tab);
    }

    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        World world = player.worldObj;
        if (!player.capabilities.isCreativeMode) {
            stack.stackSize--;
            if (entity instanceof EntitySlime &&
                !EntityList.getEntityString(entity).toLowerCase().contains("lava")) {
                entity.attackEntityFrom(DamageSource.generic, 30.0F);
                entity.entityDropItem(new ItemStack(ModItems.tough_jelly, 1, 0), 0).delayBeforeCanPickup = 10;
                world.playSoundEffect(entity.posX, entity.posY, entity.posZ, "dig.stone", 2.0F, 1.0F);
                world.playSoundEffect(entity.posX, entity.posY, entity.posZ, "dig.glass", 2.0F, 2.0F);
                player.addStat(ModAchievementList.saltSlime, 1);
                if (stack.stackSize == 0) {
                    player.setCurrentItemOrArmor(0, null);
                }
            } if (entity instanceof EntityWitch) {
                entity.attackEntityFrom(DamageSource.generic, 30.0F);
                entity.entityDropItem(new ItemStack(ModItems.salt_pinch, 1, 0), 0).delayBeforeCanPickup = 10;
                world.playSoundEffect(entity.posX, entity.posY, entity.posZ, "dig.stone", 2.0F, 1.0F);
                world.playSoundEffect(entity.posX, entity.posY, entity.posZ, "dig.glass", 2.0F, 2.0F);
                player.addStat(ModAchievementList.saltWitch, 1);
                if (stack.stackSize == 0) {
                    player.setCurrentItemOrArmor(0, null);
                }
            }
        }
        return false;
    }
}
