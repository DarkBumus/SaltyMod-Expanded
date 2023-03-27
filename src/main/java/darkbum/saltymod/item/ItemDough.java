package darkbum.saltymod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemDough extends ItemSaltFood {
    public ItemDough(String name, CreativeTabs tab) {
        super("dough", 1, 0.3F);
        setUnlocalizedName(name);
        setCreativeTab(tab);
    }

    public void onFoodEaten(ItemStack item, World world, EntityPlayer player) {
        boolean check = false;
        if (player.getFoodStats().getFoodLevel() == 20)
            check = true;
        if (!world.isRemote && check) {
            player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 300));
        }
        if (!world.isRemote) {
            player.addPotionEffect(new PotionEffect(Potion.confusion.id, 100));
        }
    }
}
