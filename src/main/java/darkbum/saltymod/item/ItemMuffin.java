package darkbum.saltymod.item;

import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.potion.ProbablePotionEffect;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

import static darkbum.saltymod.init.ModItems.*;

public class ItemMuffin extends ItemSaltFood {

    public ItemMuffin(String baseName, CreativeTabs tab) {
        super(baseName);
        setCreativeTab(tab);
        this.addVariant(0, "muffin", "muffin", 3, 3.4f, false,
            new ProbablePotionEffect(well_fed, 3600, 0, 1.0f, 20));
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
            player.triggerAchievement(ModAchievementList.consumespec_muffin);

            String message = I18n.format(getUnlocalizedName() + ".mess." + world.rand.nextInt(4));
            player.addChatMessage(new net.minecraft.util.ChatComponentText(message));
        }
    }
}
