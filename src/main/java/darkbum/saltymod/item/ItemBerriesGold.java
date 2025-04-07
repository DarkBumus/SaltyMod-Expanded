package darkbum.saltymod.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBerriesGold extends ItemFood {

    public ItemBerriesGold(int amount, float saturation, boolean dogFood) {
        super(amount, saturation, dogFood);
        this.setHasSubtypes(true);
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemStack) {
        return itemStack.getItemDamage() > 0;
    }

    public EnumRarity getRarity(ItemStack itemStack) {
        return itemStack.getItemDamage() == 0 ? EnumRarity.rare : EnumRarity.epic;
    }

    protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            player.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 1200, 0));
        }
        if (itemStack.getItemDamage() > 0) {
            if (!world.isRemote) {
                player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 300, 3));
                player.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 1200, 3));
                player.addPotionEffect(new PotionEffect(Potion.resistance.id, 3000, 0));
                player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 3000, 0));
            }
        } else {
            super.onFoodEaten(itemStack, world, player);
        }
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tabs, List list) {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
    }
}
