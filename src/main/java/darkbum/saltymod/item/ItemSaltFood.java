package darkbum.saltymod.item;

import java.util.*;

import cpw.mods.fml.common.Loader;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import darkbum.saltymod.potion.ProbablePotionEffect;

import squeek.applecore.api.food.FoodValues;
import squeek.applecore.api.food.IEdible;

import cpw.mods.fml.common.Optional;


@Optional.Interface(modid = "AppleCore", iface = "squeek.applecore.api.food.IEdible")
public class ItemSaltFood extends ItemFood implements IEdible {

    private static class Variant {
        public final String unlocalizedName, textureName;
        public final ItemStack container;
        public final int heal;
        public final float saturation;
        public final int stacksize;
        public final boolean isDogFood;
        public final boolean isAlwaysEdible;
        public final boolean hasGlint;
        public final EnumAction useAction;
        public final String customTooltip;
        public final ProbablePotionEffect[] effects;
        public IIcon icon;

        public Variant(String unlocalizedName, String textureName, int heal,
                       float saturation, int stacksize, ItemStack container, boolean isDogFood,
                       boolean isAlwaysEdible, boolean hasGlint, EnumAction useAction, String customTooltip,
                       ProbablePotionEffect... effects) {
            this.unlocalizedName = unlocalizedName;
            this.textureName = textureName;
            this.container = container;
            this.heal = heal;
            this.saturation = saturation;
            this.stacksize = stacksize > 0 ? stacksize : 64;
            this.effects = effects != null ? effects : new ProbablePotionEffect[0];
            this.isDogFood = isDogFood;
            this.isAlwaysEdible = isAlwaysEdible;
            this.hasGlint = hasGlint;
            this.useAction = useAction != null ? useAction : EnumAction.eat;
            this.customTooltip = customTooltip;
        }
    }

    private final Map<Integer, Variant> variants = new HashMap<>();

    public ItemSaltFood(String baseName) {
        super(0, 0.0f, false);
        setUnlocalizedName(baseName);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public FoodValues getFoodValues(ItemStack stack) {
        if (Loader.isModLoaded("AppleCore")) {
            Variant v = variants.get(stack.getItemDamage());
            return v != null ? new FoodValues(v.heal, v.saturation) : new FoodValues(0, 0.0f);
        } else {
            return null;
        }
    }

    public ItemSaltFood addVariant(int meta, String unlocalizedName, String textureName,
                                   int heal, float saturation, int stacksize, ItemStack container,
                                   boolean isDogFood, boolean isAlwaysEdible, boolean hasGlint,
                                   EnumAction useAction, String customTooltip, ProbablePotionEffect... effects) {
        variants.put(meta, new Variant(unlocalizedName, textureName, heal, saturation,
            stacksize, container, isDogFood, isAlwaysEdible, hasGlint, useAction, customTooltip, effects));
        return this;
    }

    public ItemSaltFood addVariant(int meta, String unlocalizedName, String textureName,
                                   int heal, float saturation, EnumAction useAction) {
        return addVariant(meta, unlocalizedName, textureName, heal, saturation, 64,
            null, false, false, false, useAction, null);
    }

    public ItemSaltFood addVariant(int meta, String unlocalizedName, String textureName,
                                   int heal, float saturation, EnumAction useAction,
                                   ProbablePotionEffect... effects) {
        return addVariant(meta, unlocalizedName, textureName, heal, saturation, 64,
            null, false, false, false, useAction, null, effects);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        Variant v = variants.get(stack.getItemDamage());
        return v != null ? "item." + v.unlocalizedName : "item.unknown_saltfood";
    }

    @Override
    public String getUnlocalizedName() {
        return getUnlocalizedName(new ItemStack(this, 1, 0));
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public int getItemStackLimit(ItemStack stack) {
        Variant v = variants.get(stack.getItemDamage());
        return v != null ? v.stacksize : super.getItemStackLimit(stack);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {
        Variant v = variants.get(stack.getItemDamage());
        if (v != null) {
            if (v.customTooltip != null) {
                list.add(StatCollector.translateToLocal(v.customTooltip));
            }
            for (ProbablePotionEffect effect : v.effects) {
                String tooltip = effect.generateTooltip();
                if (tooltip != null) {
                    list.add(tooltip);
                }
            }
        }
    }

    @Override
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            Variant v = variants.get(stack.getItemDamage());
            if (v != null) {
                player.getFoodStats().addStats(v.heal, v.saturation);

                for (ProbablePotionEffect effect : v.effects) {
                    effect.procEffect(player, itemRand);
                }

                if (v.container != null) {
                    ItemStack containerStack = v.container.copy();
                    if (!player.inventory.addItemStackToInventory(containerStack)) {
                        world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, containerStack));
                    }
                }
            }
        }
        stack.stackSize--;
        return stack;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        Variant v = variants.get(stack.getItemDamage());
        if (v != null && player.canEat(v.isAlwaysEdible)) {
            player.setItemInUse(stack, getMaxItemUseDuration(stack));
        }
        return stack;
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for (Map.Entry<Integer, Variant> entry : variants.entrySet()) {
            list.add(new ItemStack(this, 1, entry.getKey()));
        }
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        for (Map.Entry<Integer, Variant> entry : variants.entrySet()) {
            Variant v = entry.getValue();
            if (v != null) {
                v.icon = iconRegister.registerIcon("saltymod:" + v.textureName);
            }
        }
    }

    @Override
    public IIcon getIconFromDamage(int damage) {
        Variant v = variants.get(damage);
        if (v != null) {
            return v.icon;
        }
        return super.getIconFromDamage(damage);
    }

    public boolean isDogFood(ItemStack stack) {
        Variant v = variants.get(stack.getItemDamage());
        return v != null && v.isDogFood;
    }

    @Override
    public ItemSaltFood setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    @Override
    public boolean hasEffect(ItemStack stack, int pass) {
        Variant v = variants.get(stack.getItemDamage());
        return v != null && v.hasGlint;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        Variant v = variants.get(stack.getItemDamage());
        return v != null ? v.useAction : EnumAction.none;
    }
}
