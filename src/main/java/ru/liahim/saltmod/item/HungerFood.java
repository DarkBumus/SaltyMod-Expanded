package ru.liahim.saltmod.item;

import java.util.List;
import java.util.Random;

import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class HungerFood extends SaltFood {
public HungerFood(String name, CreativeTabs tab, String textureName) {
    super("hungerFood", 0, 0.0F, new PotionEffect[] {new PotionEffect(Potion.hunger.id, 70, 100) });
    setUnlocalizedName(name);
    setCreativeTab(tab);
    setTextureName("saltmod:" + textureName);
    setAlwaysEdible();
  }

  @Override
  public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
	list.add(I18n.format(getUnlocalizedName() + ".tooltip", new Object[0]));
  }
}