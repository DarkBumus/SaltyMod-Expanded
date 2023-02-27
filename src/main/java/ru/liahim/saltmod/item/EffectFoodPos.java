package ru.liahim.saltmod.item;

import java.util.List;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class EffectFoodPos extends SaltFood {
    public EffectFoodPos(String name, CreativeTabs tab, String textureName) {
        super("effectFoodPos", 0, 0.0F, new PotionEffect(Potion.damageBoost.id, 1200, 0), new PotionEffect(Potion.digSpeed.id, 1200, 0), new PotionEffect(Potion.field_76434_w.id, 1200, 0), new PotionEffect(Potion.field_76443_y.id, 1200, 0), new PotionEffect(Potion.field_76444_x.id, 1200, 0), new PotionEffect(Potion.fireResistance.id, 1200, 0), new PotionEffect(Potion.heal.id, 1200, 0), new PotionEffect(Potion.invisibility.id, 1200, 0), new PotionEffect(Potion.jump.id, 1200, 0), new PotionEffect(Potion.moveSpeed.id, 1200, 0),
            new PotionEffect(Potion.nightVision.id, 1200, 0), new PotionEffect(Potion.regeneration.id, 1200, 0), new PotionEffect(Potion.resistance.id, 1200, 0), new PotionEffect(Potion.waterBreathing.id, 1200, 0));
        setUnlocalizedName(name);
        setCreativeTab(tab);
        setTextureName("saltmod:" + textureName);
        setAlwaysEdible();
    }

    public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
        list.add(I18n.format(getUnlocalizedName() + ".tooltip"));
    }
}
