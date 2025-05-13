package darkbum.saltymod.util;

import darkbum.saltymod.item.ItemSaltFood;
import darkbum.saltymod.item.ItemSaltwort;
import darkbum.saltymod.potion.ProbablePotionEffect;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import java.util.List;

import static darkbum.saltymod.init.ModItems.*;
import static net.minecraft.item.EnumAction.*;

/**
 * Utility class for handling various item-related functionalities.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ItemUtil {

    /**
     * Adds a tooltip to the provided ItemStack based on its unlocalized name.
     *
     * @param stack the ItemStack to add the tooltip to
     * @param list  the list to which the tooltip will be added
     */
    public static void addItemTooltip(ItemStack stack, List<String> list) {
        String baseKey = stack.getUnlocalizedName();
        String tooltipKey = baseKey + ".tooltip";

        String tooltip = I18n.format(tooltipKey);
        if (!tooltip.equals(tooltipKey)) {
            list.add(tooltip);
        }
    }

    /**
     * Sends a random chat message to the player if they have full hunger.
     *
     * @param world           the world where the player resides
     * @param player          the player to send the message to
     * @param unlocalizedName the base name of the message
     * @param numberOfMessages the number of possible messages to choose from
     */
    public static void sendRandomFullChatMessage(World world, EntityPlayer player, String unlocalizedName, int numberOfMessages) {
        if (!world.isRemote && player.getFoodStats().getFoodLevel() >= 20) {
            String message = I18n.format(unlocalizedName + ".mess." + world.rand.nextInt(numberOfMessages));
            player.addChatMessage(new ChatComponentText(message));
        }
    }

    /**
     * Adds variants to the Golden Berries food item with different potion effects.
     *
     * @param item the ItemSaltFood object to add the variants to
     */
    public static void variantsGoldenBerries(ItemSaltFood item) {
        item.addVariant(0, "golden_berries", "golden_berries", 3, 0.6f, false,
            new ProbablePotionEffect(regeneration, 100, 1),
            new ProbablePotionEffect(absorption, 1200),
            new ProbablePotionEffect(speed, 900, 1));
        item.addVariant(1, "golden_berries", "golden_berries", 3, 0.6f, false,
            new ProbablePotionEffect(regeneration, 300, 3),
            new ProbablePotionEffect(absorption, 1200, 3),
            new ProbablePotionEffect(resistance, 3000),
            new ProbablePotionEffect(fire_resistance, 3000),
            new ProbablePotionEffect(speed, 900, 1));
    }

    /**
     * Adds variants to the food item.
     *
     * @param item the ItemSaltFood object to add the variants to
     */
    public static void variantsChocolateBar(ItemSaltFood item) {
        item.addVariant(0, "chocolate_bar", "chocolate_bar", 3, 0.2f, false,
            new ProbablePotionEffect(haste, 200, 0, one_third),
            new ProbablePotionEffect(nausea, 300, 0, 1.0f, 20));
    }

    public static void variantsChorusCookie(ItemSaltFood item) {
        item.addVariant(0, "chorus_cookie", "chorus_cookie", 2, 0.1f, false);
    }

    public static void variantsDeveloperFoods(ItemSaltFood item) {
        item.addVariant(0, "void_apple", "dev/void_apple", 0, 0.0f, false,
            new ProbablePotionEffect(hunger, 70, 99));
        item.addVariant(1, "stuffing_apple", "dev/stuffing_apple", 20, 1.0f, false);
//        item.addVariant(2, "testing_apple", "dev/test_food", 2, 0.3f, false, new ProbablePotionEffect(well_fed, 6000));
    }

    public static void variantsMuffin(ItemSaltFood item) {
        item.addVariant(0, "muffin", "muffin", 3, 3.4f, false,
            new ProbablePotionEffect(well_fed, 3600, 0, 1.0f, 20));
    }

    public static void variantsSaltwort(ItemSaltwort item) {
        item.addVariant(0, "saltwort", "saltwort", 1, 0.3f, false,
            new ProbablePotionEffect(regeneration, 100, 1, one_third));
    }

    public static void variantsTunnelerConcoction(ItemSaltFood item) {
        item.addVariant(0, "tunneler_concoction", "tunneler_concoction", 0, 0.0f, false, 1, new ItemStack(Items.glass_bottle), drink,
            new ProbablePotionEffect(haste, 3600, 4),
            new ProbablePotionEffect(instant_damage, 1, 1, 1.0f, 20),
            new ProbablePotionEffect(nausea, 300, 0, 1.0f, 20));
    }
}
