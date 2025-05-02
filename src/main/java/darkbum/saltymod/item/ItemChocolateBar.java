package darkbum.saltymod.item;

import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import darkbum.saltymod.potion.ProbablePotionEffect;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

import static darkbum.saltymod.init.ModItems.*;

public class ItemChocolateBar extends ItemSaltFood {

    public ItemChocolateBar(String baseName, CreativeTabs tab) {
        super(baseName);
        setCreativeTab(tab);
        this.addVariant(0, "chocolate_bar", "chocolate_bar", 3, 0.2f, false,
            new ProbablePotionEffect(haste, 200, 0, one_third),
            new ProbablePotionEffect(nausea, 300, 0, 1.0f, 20));
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
    protected void onFoodEaten(ItemStack stack, net.minecraft.world.World world, EntityPlayer player) {
        if (!world.isRemote && player.getFoodStats().getFoodLevel() >= 20) {

            String message = I18n.format(getUnlocalizedName() + ".mess." + world.rand.nextInt(4));
            player.addChatMessage(new net.minecraft.util.ChatComponentText(message));
        }
    }
}
