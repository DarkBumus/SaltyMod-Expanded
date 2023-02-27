package darkbum.saltmod.item;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class StuffedFood extends SaltFood {
    public StuffedFood(String name, CreativeTabs tab, String textureName) {
        super("stuffedFood", 20, 1.0F, new PotionEffect(Potion.field_76443_y.id, 20, 100));
        setUnlocalizedName(name);
        setCreativeTab(tab);
        setTextureName("saltmod:" + textureName);
        setAlwaysEdible();
    }

    @Override
    public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
        list.add(I18n.format(getUnlocalizedName() + ".tooltip"));
    }
}
