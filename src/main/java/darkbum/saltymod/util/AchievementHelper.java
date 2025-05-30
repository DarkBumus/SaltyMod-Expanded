package darkbum.saltymod.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;

public class AchievementHelper {

    public static void tryAward(EntityPlayer player, Item pickedItem, Item targetItem, Achievement achievement) {
        if (pickedItem == targetItem) {
            player.addStat(achievement, 1);
        }
    }
}
