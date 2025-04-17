package darkbum.saltymod.item;

import java.util.List;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.world.World;

import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.potion.ProbablePotionEffect;

public class ItemSaltFood extends ItemFood {

    private final Item container;
    private final ProbablePotionEffect[] effects;
    private EnumAction action = EnumAction.eat;

    public ItemSaltFood(String name, int amount, float saturation, Item container,
                        ProbablePotionEffect... potionEffects) {
        super(amount, saturation, false);
        setUnlocalizedName(name);
        this.container = container;
        this.effects = potionEffects != null ? potionEffects : new ProbablePotionEffect[0];
    }

    public ItemSaltFood(String name, int amount, float saturation, ProbablePotionEffect... potionEffects) {
        this(name, amount, saturation, null, potionEffects);
    }

    public ItemSaltFood(String name, int amount, float saturation) {
        this(name, amount, saturation, null, new ProbablePotionEffect[0]);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean flag) {
        super.addInformation(itemStack, player, list, flag);
        for (ProbablePotionEffect effect : effects) {
            list.add(effect.generateTooltip());
        }
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return this.action;
    }

    public ItemSaltFood setItemUseAction(EnumAction action) {
        this.action = action;
        return this;
    }

    @Override
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
        super.onEaten(stack, world, player);

        if (!world.isRemote) {
            for (ProbablePotionEffect effect : effects) {
                effect.procEffect(player, itemRand);
            }

            // Sonderverhalten für Salz-Ei
            if (stack.getItem() == ModItems.salt_egg) {
                world.spawnEntityInWorld(new EntityItem(
                    world, player.posX, player.posY, player.posZ,
                    new ItemStack(Items.dye, 1, 15) // Knochenmehl
                ));
            }

            // Container zurückgeben, ohne Stapel zu zerstören
            if (container != null) {
                ItemStack containerStack = new ItemStack(container);
                if (!player.inventory.addItemStackToInventory(containerStack)) {
                    world.spawnEntityInWorld(new EntityItem(
                        world, player.posX, player.posY, player.posZ, containerStack
                    ));
                }
            }
        }

        return stack;
    }
}
