package darkbum.saltymod.item;

import java.util.*;

import cpw.mods.fml.common.Loader;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import darkbum.saltymod.potion.ProbablePotionEffect;

import squeek.applecore.api.food.FoodValues;
import squeek.applecore.api.food.IEdible;

import cpw.mods.fml.common.Optional;

/**
 * Item superclass, that represents a custom food item with multiple variants,
 * each with distinct properties such as healing, saturation, effects, and container items.
 * This class implements the {@link IEdible} interface to provide compatibility with AppleCore.
 * Variants can be registered with unique metadata, unlocalized names, textures, and other attributes.
 */
@Optional.Interface(modid = "AppleCore", iface = "squeek.applecore.api.food.IEdible")
public abstract class ItemSaltFoodBase extends ItemFood implements IEdible {

    /**
     * Represents a single food variant with specific attributes such as healing, saturation, container item, and potion effects.
     */
    private static class Variant {
        public final String unlocalizedName, textureName;
        public final List<ItemStack> containers;
        public final int heal;
        public final float saturation;
        public final int maxStackSize;
        public final boolean isDogFood;
        public final EnumAction useAction;
        public final ProbablePotionEffect[] effects;
        public IIcon icon;

        /**
         * Constructs a new food variant.
         *
         * @param unlocalizedName The unlocalized name of the variant.
         * @param textureName     The texture name of the variant.
         * @param heal            The amount of hunger restored.
         * @param saturation      The saturation value.
         * @param isDogFood       Whether the variant is considered as dog food.
         * @param maxStackSize       The maximum stack size.
         * @param containers       The container item returned upon consumption.
         * @param useAction       The use action (e.g., eat or drink).
         * @param effects         The probable potion effects applied when consumed.
         */
        public Variant(String unlocalizedName, String textureName, int heal,
                       float saturation, boolean isDogFood, int maxStackSize, List<ItemStack> containers,
                       EnumAction useAction, ProbablePotionEffect... effects) {
            this.unlocalizedName = unlocalizedName;
            this.textureName = textureName;
            this.heal = heal;
            this.saturation = saturation;
            this.isDogFood = isDogFood;
            this.maxStackSize = maxStackSize > 0 ? maxStackSize : 64;
            this.containers = containers;
            this.useAction = useAction != null ? useAction : EnumAction.eat;
            this.effects = effects != null ? effects : new ProbablePotionEffect[0];
        }
    }

    private final Map<Integer, Variant> variants = new HashMap<>();

    /**
     * Constructs a new ItemSaltFood instance with the specified base name.
     *
     * @param baseName The base unlocalized name for the item.
     */
    public ItemSaltFoodBase(String baseName) {
        super(0, 0.0f, false);
        setUnlocalizedName(baseName);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    /**
     * Retrieves the food values for the specified item stack.
     * Only returns values if AppleCore is loaded.
     *
     * @param stack The item stack to check.
     * @return the food values for the item stack.
     */
    @Override
    public FoodValues getFoodValues(ItemStack stack) {
        if (Loader.isModLoaded("AppleCore")) {
            Variant v = variants.get(stack.getItemDamage());
            return v != null ? new FoodValues(v.heal, v.saturation) : new FoodValues(0, 0.0f);
        } else {
            return null;
        }
    }

    /**
     * Registers a new food variant.
     *
     * @param meta         The metadata value.
     * @param unlocalizedName The unlocalized name.
     * @param textureName  The texture name.
     * @param heal         The hunger value restored.
     * @param saturation   The saturation value.
     * @param isDogFood    Whether it is dog food.
     * @param maxStackSize    The maximum stack size.
     * @param containers    The container item returned upon consumption.
     * @param useAction    The use action (eat or drink).
     * @param effects      The potion effects applied upon consumption.
     * @return this item instance for chaining.
     */
    public ItemSaltFoodBase addVariant(int meta, String unlocalizedName, String textureName,
                                       int heal, float saturation, boolean isDogFood, int maxStackSize, List<ItemStack> containers,
                                       EnumAction useAction, ProbablePotionEffect... effects) {
        variants.put(meta, new Variant(unlocalizedName, textureName, heal, saturation,
            isDogFood, maxStackSize, containers, useAction, effects));
        return this;
    }

    public ItemSaltFoodBase addVariant(int meta, String unlocalizedName, String textureName,
                                       int heal, float saturation, boolean isDogFood, int maxStackSize, List<ItemStack> containers,
                                       EnumAction useAction) {
        variants.put(meta, new Variant(unlocalizedName, textureName, heal, saturation,
            isDogFood, maxStackSize, containers, useAction));
        return this;
    }

    public ItemSaltFoodBase addVariant(int meta, String unlocalizedName, String textureName,
                                       int heal, float saturation, boolean isDogFood) {
        return addVariant(meta, unlocalizedName, textureName, heal, saturation, isDogFood, 64, null, EnumAction.eat);
    }

    public ItemSaltFoodBase addVariant(int meta, String unlocalizedName, String textureName,
                                       int heal, float saturation, boolean isDogFood,
                                       ProbablePotionEffect... effects) {
        return addVariant(meta, unlocalizedName, textureName, heal, saturation, isDogFood, 64, null, EnumAction.eat, effects);
    }

    public ItemSaltFoodBase addVariant(int meta, String unlocalizedName, String textureName,
                                       int heal, float saturation, boolean isDogFood, int maxStackSize, List<ItemStack> containers,
                                       ProbablePotionEffect... effects) {
        return addVariant(meta, unlocalizedName, textureName, heal, saturation, isDogFood,
            maxStackSize, containers, EnumAction.eat, effects);
    }

    /**
     * Retrieves the unlocalized name for the given item stack.
     *
     * @param stack The item stack.
     * @return the unlocalized name.
     */
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        Variant v = variants.get(stack.getItemDamage());
        return v != null ? "item." + v.unlocalizedName : "item.unknown_saltfood";
    }

    @Override
    public String getUnlocalizedName() {
        return getUnlocalizedName(new ItemStack(this, 1, 0));
    }

    /**
     * Sets the creative tab for this item.
     * This method overrides the default implementation to return the item instance itself, allowing for method chaining.
     *
     * @param tab The creative tab to which this item will be assigned.
     * @return this item instance, allowing for method chaining.
     */
    @Override
    public ItemSaltFoodBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    /**
     * Registers item icons for each variant.
     *
     * @param iconRegister The icon register.
     */
    @Override
    public void registerIcons(IIconRegister iconRegister) {
        for (Map.Entry<Integer, Variant> entry : variants.entrySet()) {
            Variant v = entry.getValue();
            if (v != null) {
                v.icon = iconRegister.registerIcon("saltymod:" + v.textureName);
            }
        }
    }

    /**
     * Retrieves the icon for the specified metadata.
     *
     * @param meta The metadata value.
     * @return the icon for the variant.
     */
    @Override
    public IIcon getIconFromDamage(int meta) {
        Variant v = variants.get(meta);
        if (v != null) {
            return v.icon;
        }
        return super.getIconFromDamage(meta);
    }

    /**
     * Returns the metadata value for the specified damage value.
     * In this implementation, the damage value is treated as the metadata value, allowing for multiple variants.
     *
     * @param damage The damage value of the item.
     * @return the metadata value, which is the same as the damage value.
     */
    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    /**
     * Adds all the item variants to the creative tab for display.
     * This method iterates through all registered variants and adds each one as a separate item stack.
     *
     * @param item The base item instance.
     * @param tab  The creative tab to which the items will be added.
     * @param list The list of item stacks to be displayed in the creative tab.
     */
    @Override
    public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> list) {
        for (Map.Entry<Integer, Variant> entry : variants.entrySet()) {
            list.add(new ItemStack(this, 1, entry.getKey()));
        }
    }

    /**
     * Provides item stack limit based on the variant's stack size.
     *
     * @param stack The item stack.
     * @return the stack limit.
     */
    @Override
    public int getItemStackLimit(ItemStack stack) {
        Variant v = variants.get(stack.getItemDamage());
        return v != null ? v.maxStackSize : super.getItemStackLimit(stack);
    }

    /**
     * Adds additional information to the item's tooltip.
     *
     * @param stack    The item stack.
     * @param player   The player viewing the tooltip.
     * @param list     The tooltip lines.
     * @param advanced Whether advanced information is displayed.
     */
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean advanced) {
        Variant v = variants.get(stack.getItemDamage());
        if (v != null) {
            for (ProbablePotionEffect effect : v.effects) {
                String tooltip = effect.addTooltip();
                if (tooltip != null) {
                    list.add(tooltip);
                }
            }
        }
    }

    /**
     * Retrieves the use action (e.g., eat or drink) for the given item stack.
     *
     * @param stack The item stack.
     * @return the use action.
     */
    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        Variant v = variants.get(stack.getItemDamage());
        return v != null ? v.useAction : EnumAction.none;
    }

    /**
     * Handles the consumption of the item stack, applying food stats and potion effects.
     *
     * @param stack  The item stack being consumed.
     * @param world  The world in which the player is located.
     * @param player The player consuming the item.
     * @return the modified item stack.
     */
    @Override
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            Variant v = variants.get(stack.getItemDamage());
            if (v != null) {
                player.getFoodStats().addStats(v.heal, v.saturation);

                for (ProbablePotionEffect effect : v.effects) {
                    effect.procEffect(player, itemRand);
                }

                if (v.containers != null) {
                    for (ItemStack container : v.containers) {
                        ItemStack copy = container.copy();
                        if (!player.inventory.addItemStackToInventory(copy)) {
                            world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, copy));
                        }
                    }
                }
            }
        }
        onFoodEaten(stack, world, player);
        stack.stackSize--;
        return stack;
    }
}
