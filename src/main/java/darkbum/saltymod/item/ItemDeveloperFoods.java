package darkbum.saltymod.item;

import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import darkbum.saltymod.potion.ProbablePotionEffect;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

import static darkbum.saltymod.init.ModItems.*;

public class ItemDeveloperFoods extends ItemSaltFood {

    public ItemDeveloperFoods(String baseName, CreativeTabs tab) {
        super(baseName);
        setCreativeTab(tab);
        this.addVariant(0, "void_apple", "dev/void_apple", 0, 0.0f, false,
            new ProbablePotionEffect(hunger, 70, 99));
        this.addVariant(1, "stuffing_apple", "dev/stuffing_apple", 20, 1.0f, false);
/*        this.addVariant(2, "testing_apple", "dev/test_food", 2, 0.3f, false,
            new ProbablePotionEffect(well_fed, 6000));*/
        setAlwaysEdible();
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {
        String baseKey = getUnlocalizedName(stack);
        String tooltipKey = baseKey + ".tooltip";

        String tooltip = I18n.format(tooltipKey);
        if (!tooltip.equals(tooltipKey)) {
            list.add(tooltip);
        }
    }

    @Override
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            int meta = stack.getItemDamage();
            if (meta == 0 || meta == 1) {
                player.clearActivePotions();
            }
            super.onEaten(stack, world, player);
        }
        return stack;
    }
}
