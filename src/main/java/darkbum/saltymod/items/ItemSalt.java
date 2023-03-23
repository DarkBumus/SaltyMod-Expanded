package darkbum.saltymod.items;

import java.util.Random;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSalt extends Item {
    public ItemSalt(String name, CreativeTabs tab) {
        setUnlocalizedName(name);
        setCreativeTab(tab);
    }

    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase entity) {
        if (entity instanceof EntityCow) {
            EntityCow cow = (EntityCow)entity;
            if (cow.isChild()) {
                cow.addGrowth(10);
                stack.stackSize--;
                return true;
            }
            if (cow.getGrowingAge() == 0 && !cow.isInLove()) {
                cow.func_146082_f(player);
                stack.stackSize--;
                return true;
            }
        }
        if (entity instanceof EntityHorse) {
            EntityHorse horse = (EntityHorse)entity;
            boolean flag = false;
            if (horse.getHealth() < horse.getMaxHealth()) {
                horse.heal(2.0F);
                flag = true;
            }
            if (!horse.isAdultHorse()) {
                horse.addGrowth(10);
                flag = true;
            }
            if (flag) {
                horse.worldObj.playSoundAtEntity(horse, "eating", 1.0F, 1.0F + ((new Random()).nextFloat() - (new Random()).nextFloat()) * 0.2F);
                stack.stackSize--;
                return true;
            }
            return false;
        }
        return false;
    }
}
