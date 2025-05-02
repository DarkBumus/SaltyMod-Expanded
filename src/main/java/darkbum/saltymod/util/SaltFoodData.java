package darkbum.saltymod.util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import darkbum.saltymod.potion.ProbablePotionEffect;

public class SaltFoodData {
    public final String unlocalizedName;
    public final int healAmount;
    public final float saturation;
    public final Item container;
    public final ProbablePotionEffect[] effects;
    public final boolean visibleInCreativeTab;
    public final CreativeTabs creativeTab;

    public SaltFoodData(String unlocalizedName, int healAmount, float saturation, Item container,
                    boolean visibleInCreativeTab, CreativeTabs creativeTab,
                    ProbablePotionEffect... effects) {
        this.unlocalizedName = unlocalizedName;
        this.healAmount = healAmount;
        this.saturation = saturation;
        this.container = container;
        this.effects = effects != null ? effects : new ProbablePotionEffect[0];
        this.visibleInCreativeTab = visibleInCreativeTab;
        this.creativeTab = creativeTab;
    }
}
