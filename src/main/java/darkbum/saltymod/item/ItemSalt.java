package darkbum.saltymod.item;

import java.util.Random;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Item class for the salt item.
 * The salt is an item with a entity interaction.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class ItemSalt extends Item {

    /**
     * Constructs a new item instance with the specified name and creative tab.
     *
     * @param name The base name of the item.
     * @param tab The creative tab to display this item in.
     */
    public ItemSalt(String name, CreativeTabs tab) {
        setUnlocalizedName(name);
        setCreativeTab(tab);
    }

    /**
     * Called when the player uses this item on an entity.
     *
     * @param stack The ItemStack being used.
     * @param player The player using the item.
     * @param entity The entity being interacted with.
     * @return true, if the interaction was successful and the item was used, false otherwise.
     */
    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase entity) {
        if (entity instanceof EntityCow cow) {
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
        if (entity instanceof EntityHorse horse) {
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
