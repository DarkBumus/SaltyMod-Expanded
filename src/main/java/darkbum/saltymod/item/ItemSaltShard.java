package darkbum.saltymod.item;

import darkbum.saltymod.init.AchievSalt;
import darkbum.saltymod.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
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
            if (stack.stackSize == 0) {
                player.setCurrentItemOrArmor(0, null);
                if (EntityList.getEntityString(entity).toLowerCase().contains("slime") &&
                    !EntityList.getEntityString(entity).toLowerCase().contains("lava")) {
                    entity.attackEntityFrom(DamageSource.cactus, 30.0F);
                    entity.dropItem(ModItems.tough_jelly, 1);
                    world.playSoundEffect(entity.posX, entity.posY, entity.posZ, "dig.stone", 2.0F, 1.0F);
                    world.playSoundEffect(entity.posX, entity.posY, entity.posZ, "dig.glass", 2.0F, 2.0F);
                    player.addStat(AchievSalt.saltSlime, 1);
                } if  (EntityList.getEntityString(entity).toLowerCase().contains("witch")) {
                    entity.attackEntityFrom(DamageSource.cactus, 30.0F);
                    entity.dropItem(ModItems.salt_pinch, 1);
                    world.playSoundEffect(entity.posX, entity.posY, entity.posZ, "dig.stone", 2.0F, 1.0F);
                    world.playSoundEffect(entity.posX, entity.posY, entity.posZ, "dig.glass", 2.0F, 2.0F);
                    player.addStat(AchievSalt.saltWitch, 1);
                }
            }
        }
        return false;
    }
}
