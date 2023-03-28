package darkbum.saltymod.item;

import java.util.List;

import darkbum.saltymod.potion.ProbablePotionEffect;
import darkbum.saltymod.init.ModItems;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSaltFood extends ItemFood {
    private final Item container;
    private final ProbablePotionEffect[] effects;
    private EnumAction action = EnumAction.eat;

    public ItemSaltFood(String name, int amount, float saturation, Item container, ProbablePotionEffect... potionEffects) {
        super(amount, saturation, false);
        setUnlocalizedName(name);
        this.container = container;
        this.effects = potionEffects;
    }

    public ItemSaltFood(String name, int amount, float saturation, ProbablePotionEffect... potionEffects) {
        super(amount, saturation, false);
        setUnlocalizedName(name);
        this.container = null;
        this.effects = potionEffects;
    }

    public ItemSaltFood(String name, int amount, float saturation) {
        super(amount, saturation, false);
        setUnlocalizedName(name);
        this.container = null;
        this.effects = null;
    }

    @Override
    public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
        super.addInformation(is, player, list, flag);
        if(effects != null) {
            for(ProbablePotionEffect effect : effects) {
                list.add(effect.generateTooltip());
            }
        }
    }

    public EnumAction getItemUseAction(ItemStack item) {
        return action;
    }

    public ItemSaltFood setItemUseAction(EnumAction action) {
        this.action = action;
        return this;
    }

    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
        super.onEaten(stack, world, player);
        if(effects != null && !world.isRemote) {
            for(ProbablePotionEffect effect : effects) {
                effect.procEffect(player, itemRand);
            }
        }
        if(!world.isRemote && getUnlocalizedName().equals(ModItems.salt_egg.getUnlocalizedName())) {
            world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, new ItemStack(Items.dye, 1, 15)));
        }
        return container != null ? new ItemStack(container) : stack;
    }

}
