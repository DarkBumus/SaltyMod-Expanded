package darkbum.saltymod.item;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import darkbum.saltymod.potion.ModPotion;
import darkbum.saltymod.potion.ProbablePotionEffect;

public class ItemStuffingApple extends ItemSaltFood {

    public ItemStuffingApple(String name, CreativeTabs tab) {
        super(name, 20, 1.0F, new ProbablePotionEffect(ModPotion.wellFed.id, 20, 99));
        setCreativeTab(tab);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean flag) {
        list.add(I18n.format(getUnlocalizedName() + ".tooltip"));
    }
}
