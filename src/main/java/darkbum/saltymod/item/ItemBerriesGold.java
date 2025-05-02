package darkbum.saltymod.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

import darkbum.saltymod.potion.ProbablePotionEffect;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

import static darkbum.saltymod.init.ModItems.*;

public class ItemBerriesGold extends ItemSaltFood {

    public ItemBerriesGold(String baseName, CreativeTabs tab) {
        super(baseName);
        setCreativeTab(tab);
        setHasSubtypes(true);
        addVariant(0, "golden_berries", "golden_berries", 3, 0.6f, false,
            new ProbablePotionEffect(regeneration, 100, 1),
            new ProbablePotionEffect(absorption, 1200),
            new ProbablePotionEffect(speed, 900, 1));
        addVariant(1, "golden_berries", "golden_berries", 3, 0.6f, false,
            new ProbablePotionEffect(regeneration, 300, 3),
            new ProbablePotionEffect(absorption, 1200, 3),
            new ProbablePotionEffect(resistance, 3000),
            new ProbablePotionEffect(fire_resistance, 3000),
            new ProbablePotionEffect(speed, 900, 1));
        setAlwaysEdible();
    }

    public EnumRarity getRarity(ItemStack itemStack) {
        return itemStack.getItemDamage() == 0 ? EnumRarity.rare : EnumRarity.epic;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemStack, int pass) {
        return itemStack.getItemDamage() > 0;
    }
}
