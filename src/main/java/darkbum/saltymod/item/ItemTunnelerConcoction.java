package darkbum.saltymod.item;

import darkbum.saltymod.potion.ProbablePotionEffect;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.List;

import static darkbum.saltymod.init.ModItems.*;
import static net.minecraft.item.EnumAction.drink;

public class ItemTunnelerConcoction extends ItemSaltFood {

    public ItemTunnelerConcoction(String baseName, CreativeTabs tab) {
        super(baseName);
        setCreativeTab(tab);
        this.addVariant(0, "tunneler_concoction", "tunneler_concoction", 0, 0.0f, false, 1, new ItemStack(Items.glass_bottle), drink,
                new ProbablePotionEffect(haste, 3600, 4),
                new ProbablePotionEffect(instant_damage, 1, 1, 1.0f, 20),
                new ProbablePotionEffect(nausea, 300, 0, 1.0f, 20));
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
    protected void onFoodEaten(ItemStack stack, net.minecraft.world.World world, EntityPlayer player) {
        if (!world.isRemote && player.getFoodStats().getFoodLevel() >= 20) {

            String message = I18n.format(getUnlocalizedName() + ".mess." + world.rand.nextInt(4));
            player.addChatMessage(new net.minecraft.util.ChatComponentText(message));
        }
    }
}
