package darkbum.saltymod.item;

import java.util.List;

import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.configuration.ModConfiguration;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemFizzyDrink extends Item {
    public ItemFizzyDrink(String name, CreativeTabs tab) {
        setMaxStackSize(1);
        setUnlocalizedName(name);
        setCreativeTab(tab);
    }

    @Override
    public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
        list.add(I18n.format(getUnlocalizedName() + ".tooltip"));
    }

    public ItemStack onEaten(ItemStack item, World world, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode)
            item.stackSize--;
        if (!world.isRemote) {
            if (ModConfiguration.fizzyDrinkEffect) {
                player.clearActivePotions();
            } else {
                player.curePotionEffects(new ItemStack(Items.milk_bucket));
            }
            if (player.isBurning()) {
                player.addStat(ModAchievementList.consumeFizzyDrink, 1);
                player.extinguish();
            }
        }
        return (item.stackSize <= 0) ? new ItemStack(Items.glass_bottle) : item;
    }

    public int getMaxItemUseDuration(ItemStack item) {
        return 32;
    }

    public EnumAction getItemUseAction(ItemStack item) {
        return EnumAction.drink;
    }

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
        player.setItemInUse(item, getMaxItemUseDuration(item));
        return item;
    }
}
