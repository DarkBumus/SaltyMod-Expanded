package darkbum.saltymod.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemEffectApple extends ItemSaltFood {

    private IIcon[] icon;

    public ItemEffectApple(String name, CreativeTabs tab) {
        super(name, 0, 0.0F);
        setCreativeTab(tab);
        this.setHasSubtypes(true);
    }

    public EnumRarity getRarity(ItemStack itemStack) {
        return itemStack.getItemDamage() == 0 ? EnumRarity.epic : EnumRarity.common;
    }

    protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) {
        if (itemStack.getItemDamage() == 0) {
            if (!world.isRemote) {
                player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1200, 0));
                player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 1200, 0));
                player.addPotionEffect(new PotionEffect(Potion.field_76434_w.id, 1200, 0));
                player.addPotionEffect(new PotionEffect(Potion.field_76443_y.id, 1200, 0));
                player.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 1200, 0));
                player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 1200, 0));
                player.addPotionEffect(new PotionEffect(Potion.heal.id, 1200, 0));
                player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 1200, 0));
                player.addPotionEffect(new PotionEffect(Potion.jump.id, 1200, 0));
                player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1200, 0));
                player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 1200, 0));
                player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1200, 0));
                player.addPotionEffect(new PotionEffect(Potion.resistance.id, 1200, 0));
                player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 1200, 0));
            }
        }
        if (itemStack.getItemDamage() == 1) {
            if (!world.isRemote) {
                player.addPotionEffect(new PotionEffect(Potion.blindness.id, 1200, 0));
                player.addPotionEffect(new PotionEffect(Potion.confusion.id, 1200, 0));
                player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 1200, 0));
                player.addPotionEffect(new PotionEffect(Potion.harm.id, 1200, 0));
                player.addPotionEffect(new PotionEffect(Potion.hunger.id, 1200, 0));
                player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1200, 0));
                player.addPotionEffect(new PotionEffect(Potion.poison.id, 1200, 0));
                player.addPotionEffect(new PotionEffect(Potion.weakness.id, 1200, 0));
                player.addPotionEffect(new PotionEffect(Potion.wither.id, 1200, 0));
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

    public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
        list.add(I18n.format(getUnlocalizedName() + ".tooltip"));
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg) {
        this.icon = new IIcon[2];
        this.icon[0] = reg.registerIcon("saltmod:dev/effect_apple_positive");
        this.icon[1] = reg.registerIcon("saltmod:dev/effect_apple_negative");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return this.icon[meta];
    }
}
