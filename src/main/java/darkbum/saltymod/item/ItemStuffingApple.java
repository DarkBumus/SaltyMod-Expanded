package darkbum.saltymod.item;

import java.util.List;

import darkbum.saltymod.common.ProbablePotionEffect;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

public class ItemStuffingApple extends ItemSaltFood {
    public ItemStuffingApple(String name, CreativeTabs tab) {
        super(name, 20, 1.0F, new ProbablePotionEffect(Potion.field_76443_y.id, 20, 100));
        setCreativeTab(tab);
    }

    @Override
    public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
        list.add(I18n.format(getUnlocalizedName() + ".tooltip"));
    }
}
