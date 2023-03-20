package darkbum.saltmod.items;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemVoidApple extends ItemSaltFood {
    public ItemVoidApple(String name, CreativeTabs tab) {
        super(name, 0, 0.0F, new PotionEffect(Potion.hunger.id, 70, 100));
        setCreativeTab(tab);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean flag) {
        list.add(I18n.format(getUnlocalizedName() + ".tooltip"));
    }
}
