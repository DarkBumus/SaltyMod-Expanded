package ru.liahim.saltmod.item;

import java.util.List;
import java.util.Random;

import ru.liahim.saltmod.init.AchievSalt;
import ru.liahim.saltmod.init.SaltConfig;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatBase;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class CobblerConcoction extends SaltFood {
  public CobblerConcoction(String name, CreativeTabs tab, String textureName) {
	super("cobblerConcoction", 0, 0.0F, Items.glass_bottle, new PotionEffect[] {new PotionEffect(Potion.digSpeed.id, 3600, 3) });
	setMaxStackSize(1);
	setUnlocalizedName(name);
	setCreativeTab(tab);
	setTextureName("saltmod:" + textureName);
	setAlwaysEdible();
  }
	
  @Override
  public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
	list.add(I18n.format(getUnlocalizedName() + ".tooltip", new Object[0]));
  }
	  
  public EnumAction getItemUseAction(ItemStack item) {
	return EnumAction.drink;
  }
  
  public void onFoodEaten(ItemStack item, World world, EntityPlayer player) {
	boolean chekk = false;
	if (player.getFoodStats().getFoodLevel() == 20)
	  chekk = true; 
	if (!world.isRemote && chekk) {
	  player.addPotionEffect(new PotionEffect(Potion.harm.id, 1, 1));
	} 
	if (world.isRemote && player.getFoodStats().getFoodLevel() == 20) {
	  Random rand = new Random();
	  player.addChatMessage((IChatComponent)new ChatComponentText(I18n.format(getUnlocalizedName() + ".mess." + rand.nextInt(4), new Object[0])));
	} 
  } 
}