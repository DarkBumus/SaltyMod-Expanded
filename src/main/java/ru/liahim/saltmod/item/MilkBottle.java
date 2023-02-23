package ru.liahim.saltmod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MilkBottle extends Item {
  public MilkBottle(String name, CreativeTabs tab, String textureName) {
    setMaxStackSize(1);
    setUnlocalizedName(name);
    setCreativeTab(tab);
    setTextureName("saltmod:" + textureName);
  }
  
  public ItemStack onEaten(ItemStack item, World world, EntityPlayer player) {
    if (!player.capabilities.isCreativeMode)
      item.stackSize--; 
    if (!world.isRemote)
      player.curePotionEffects(new ItemStack(Items.milk_bucket)); 
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