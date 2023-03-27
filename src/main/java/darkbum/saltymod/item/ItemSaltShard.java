package darkbum.saltymod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSaltShard extends Item {

    public ItemSaltShard(String name, CreativeTabs tab) {
        setUnlocalizedName(name);
        setCreativeTab(tab);
    }

    public boolean hitEntity(ItemStack stack, EntityLivingBase p_77644_2_, EntityLivingBase p_77644_3_) {
        return false;
    }
}
