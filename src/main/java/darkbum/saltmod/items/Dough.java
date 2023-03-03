package darkbum.saltmod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Dough extends SaltFood {
    public Dough(String name, CreativeTabs tab, String textureName) {
        super("dough", 1, 0.3F);
        setUnlocalizedName(name);
        setCreativeTab(tab);
        setTextureName("saltmod:" + textureName);
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
