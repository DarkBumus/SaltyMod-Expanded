package ru.liahim.saltmod.item;

import java.util.List;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class EffectFoodNeg extends SaltFood {
  public EffectFoodNeg(String name, CreativeTabs tab, String textureName) {
    super("effectFoodNeg", 0, 0.0F, new PotionEffect[] { new PotionEffect(Potion.blindness.id, 1200, 0), new PotionEffect(Potion.confusion.id, 1200, 0), new PotionEffect(Potion.digSlowdown.id, 1200, 0), new PotionEffect(Potion.harm.id, 1200, 0), new PotionEffect(Potion.hunger.id, 1200, 0), new PotionEffect(Potion.moveSlowdown.id, 1200, 0), new PotionEffect(Potion.poison.id, 1200, 0), new PotionEffect(Potion.weakness.id, 1200, 0), new PotionEffect(Potion.wither.id, 1200, 0) });
    setUnlocalizedName(name);
    setCreativeTab(tab);
    setTextureName("saltmod:" + textureName);
    setAlwaysEdible();
  }
  
  public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
    list.add(I18n.format(getUnlocalizedName() + ".tooltip", new Object[0]));
  }
}