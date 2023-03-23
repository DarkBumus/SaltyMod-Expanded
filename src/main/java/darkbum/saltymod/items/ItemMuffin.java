package darkbum.saltymod.items;

import java.util.List;
import java.util.Random;

import darkbum.saltymod.init.AchievSalt;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemMuffin extends ItemFood {
    public ItemMuffin(String name, CreativeTabs tab) {
        super(3, 3.4F, false);
        setUnlocalizedName(name);
        setCreativeTab(tab);
    }

    @Override
    public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
        list.add(I18n.format(getUnlocalizedName() + ".tooltip"));
    }

    public void onFoodEaten(ItemStack item, World world, EntityPlayer player) {
        boolean chek = false;
        if (player.getFoodStats().getFoodLevel() == 20)
            chek = true;
        if (!world.isRemote && chek) {
            player.addPotionEffect(new PotionEffect(Potion.field_76443_y.id, 2400));
            player.addStat(AchievSalt.muffin, 1);
        }
        if (world.isRemote && player.getFoodStats().getFoodLevel() == 20) {
            Random rand = new Random();
            player.addChatMessage(new ChatComponentText(I18n.format(getUnlocalizedName() + ".mess." + rand.nextInt(4))));
        }
    }
}
