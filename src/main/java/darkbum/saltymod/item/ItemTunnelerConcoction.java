package darkbum.saltymod.item;

import java.util.List;
import java.util.Random;

import darkbum.saltymod.potion.ProbablePotionEffect;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemTunnelerConcoction extends ItemSaltFood {
    public ItemTunnelerConcoction(String name, CreativeTabs tab) {
        super("cobblerConcoction", 0, 0.0F, Items.glass_bottle, new ProbablePotionEffect(Potion.digSpeed.id, 3600, 3));
        setMaxStackSize(1);
        setUnlocalizedName(name);
        setCreativeTab(tab);
        setAlwaysEdible();
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean flag) {
        list.add(I18n.format(getUnlocalizedName() + ".tooltip"));
    }

    public EnumAction getItemUseAction(ItemStack item) {
        return EnumAction.drink;
    }

    public void onFoodEaten(ItemStack item, World world, EntityPlayer player) {
        boolean check = false;
        if (player.getFoodStats().getFoodLevel() == 20)
            check = true;
        if (!world.isRemote && check) {
            player.addPotionEffect(new PotionEffect(Potion.harm.id, 1, 1));
            player.addPotionEffect(new PotionEffect(Potion.confusion.id, 120, 0));
        }
        if (world.isRemote && player.getFoodStats().getFoodLevel() == 20) {
            Random rand = new Random();
            player.addChatMessage(new ChatComponentText(I18n.format(getUnlocalizedName() + ".mess." + rand.nextInt(4))));
        }
    }
}
