package ru.liahim.saltmod.item;

import java.util.List;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import ru.liahim.saltmod.init.ModItems;

public class SaltFood extends ItemFood {
    private Item container;

    private PotionEffect[] effects;

    public SaltFood(String name, int amount, float saturation, Item container, PotionEffect... potionEffect) {
        super(amount, saturation, false);
        setUnlocalizedName(name);
        this.container = container;
        this.effects = potionEffect;
    }

    public SaltFood(String name, int amount, float saturation, PotionEffect... potionEffect) {
        super(amount, saturation, false);
        setUnlocalizedName(name);
        this.container = null;
        this.effects = potionEffect;
    }

    public SaltFood(String name, int amount, float saturation) {
        super(amount, saturation, false);
        setUnlocalizedName(name);
        this.container = null;
        this.effects = null;
    }

    @Override
    public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
        super.addInformation(is, player, list, flag);
        if (this.effects != null)
            for (PotionEffect effect : this.effects) {
                String mess = "";
                if (effect != null && effect.getPotionID() > 0) {
                    mess = mess + (Potion.potionTypes[effect.getPotionID()].isBadEffect() ? EnumChatFormatting.RED : EnumChatFormatting.GRAY);
                    mess = mess + StatCollector.translateToLocal(effect.getEffectName()).trim();
                    if (effect.getAmplifier() == 1) {
                        mess = mess + " II";
                    } else if (effect.getAmplifier() == 2) {
                        mess = mess + " III";
                    } else if (effect.getAmplifier() == 3) {
                        mess = mess + " IV";
                    } else if (effect.getAmplifier() == 4) {
                        mess = mess + " V";
                    }
                    if (effect.getDuration() > 20)
                        mess = mess + " (" + Potion.getDurationString(effect) + ")";
                    mess = mess + EnumChatFormatting.RESET;
                    list.add(mess);
                }
            }
    }

    public EnumAction getItemUseAction(ItemStack item) {
        if (getUnlocalizedName().equals(ModItems.fermentedSaltWort.getUnlocalizedName()))
            return EnumAction.drink;
        return EnumAction.eat;
    }

    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
        super.onEaten(stack, world, player);
        if (this.effects != null)
            for (PotionEffect effect : this.effects) {
                if (!world.isRemote && effect != null && effect.getPotionID() > 0)
                    player.addPotionEffect(new PotionEffect(effect));
            }
        if (!world.isRemote && getUnlocalizedName().equals(ModItems.saltEgg.getUnlocalizedName()))
            world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, new ItemStack(Items.dye, 1, 15)));
        return (this.container != null) ? new ItemStack(this.container) : stack;
    }
}
