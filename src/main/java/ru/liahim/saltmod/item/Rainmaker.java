package ru.liahim.saltmod.item;

import java.util.List;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import ru.liahim.saltmod.entity.EntityRainmaker;

public class Rainmaker extends Item {
  public static NBTTagCompound tag = new NBTTagCompound();
  
  private static NBTTagCompound tag1 = new NBTTagCompound();
  
  private static NBTTagList nbtlist = new NBTTagList();
  
  public Rainmaker(String name, CreativeTabs tab, String textureName) {
    setUnlocalizedName(name);
    setCreativeTab(tab);
    setTextureName("saltmod:" + textureName);
    tag1.setIntArray("Colors", new int[] { 2651799, 4312372 });
    tag1.setIntArray("FadeColors", new int[] { 15790320 });
    tag1.setBoolean("Trail", true);
    tag1.setByte("Type", (byte)1);
    nbtlist.appendTag((NBTBase)tag1);
    tag.setTag("Explosions", (NBTBase)nbtlist);
  }
  
  @Override
  public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
    list.add(I18n.format(getUnlocalizedName() + ".tooltip", new Object[0]));
  }
  
  public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
    if (!world.isRemote) {
      EntityRainmaker entityRainmaker = new EntityRainmaker(world, (x + hitX), (y + hitY), (z + hitZ), player);
      world.spawnEntityInWorld((Entity)entityRainmaker);
      if (!player.capabilities.isCreativeMode)
        stack.stackSize--; 
      return true;
    } 
    return false;
  }
}