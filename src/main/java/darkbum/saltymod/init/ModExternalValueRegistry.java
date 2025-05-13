package darkbum.saltymod.init;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSoup;

import static cpw.mods.fml.common.Loader.isModLoaded;
import static cpw.mods.fml.common.registry.GameRegistry.findItem;
import static darkbum.saltymod.common.config.ModConfigurationModCompatibility.*;
import static darkbum.saltymod.common.config.ModConfigurationVanillaChanges.*;
import static darkbum.saltymod.init.ModItems.*;

/**
 * External Value Registry class.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class ModExternalValueRegistry {

    /**
     * Initializes all updated external values.
     */
    public static void init() {

        if (enableVanillaFoodValueChanges) {

            ItemFood apple = (ItemFood) Items.apple;
            apple.healAmount = 2;
            apple.saturationModifier = 0.3f;
            apple.setPotionEffect(speed, 5, 0, one_third);

            ItemFood mushroom_stew = (ItemFood) Items.mushroom_stew;
            mushroom_stew.healAmount = 5;
            mushroom_stew.saturationModifier = 0.7f;
            mushroom_stew.setPotionEffect(strength, 15, 0, one_third);

            ItemFood bread = (ItemFood) Items.bread;
            bread.healAmount = 3;
            bread.saturationModifier = 0.5f;

            ItemFood porkchop = (ItemFood) Items.porkchop;
            porkchop.healAmount = 2;
            porkchop.saturationModifier = 0.6f;

            ItemFood cooked_porkchop = (ItemFood) Items.cooked_porkchop;
            cooked_porkchop.healAmount = 4;
            cooked_porkchop.saturationModifier = 0.6f;
            cooked_porkchop.setPotionEffect(health_boost, 5, 0, one_third);

            ItemFood golden_apple = (ItemFood) Items.golden_apple;
            golden_apple.healAmount = 4;
            golden_apple.saturationModifier = 0.6f;
            golden_apple.setPotionEffect(speed, 45, 1, 1.0f);

            ItemFishFood fish = (ItemFishFood) Items.fish;
            ItemFishFood.FishType.COD.field_150991_j = 1;
            ItemFishFood.FishType.COD.field_150992_k = 0.5f;
            ItemFishFood.FishType.COD.field_150989_l = 3;
            ItemFishFood.FishType.COD.field_150990_m = 0.5f;

            ItemFishFood.FishType.SALMON.field_150991_j = 1;
            ItemFishFood.FishType.SALMON.field_150992_k = 0.5f;
            ItemFishFood.FishType.SALMON.field_150989_l = 3;
            ItemFishFood.FishType.SALMON.field_150990_m = 0.5f;

            ItemFishFood.FishType.CLOWNFISH.field_150991_j = 1;
            ItemFishFood.FishType.CLOWNFISH.field_150992_k = 0.5f;
            ItemFishFood.FishType.CLOWNFISH.field_150989_l = 0;
            ItemFishFood.FishType.CLOWNFISH.field_150990_m = 0.0f;

            ItemFishFood.FishType.PUFFERFISH.field_150991_j = 1;
            ItemFishFood.FishType.PUFFERFISH.field_150992_k = 0.5f;
            ItemFishFood.FishType.PUFFERFISH.field_150989_l = 0;
            ItemFishFood.FishType.PUFFERFISH.field_150990_m = 0.0f;

            fish.setPotionEffect(water_breathing, 5, 0, one_third);

            ItemFood cookie = (ItemFood) Items.cookie;
            cookie.healAmount = 2;
            cookie.saturationModifier = 0.1f;
            cookie.setPotionEffect(haste, 10, 0, one_third);

            ItemFood melon = (ItemFood) Items.melon;
            melon.healAmount = 1;
            melon.saturationModifier = 0.3f;
            melon.setPotionEffect(fire_resistance, 5, 0, one_third);

            ItemFood beef = (ItemFood) Items.beef;
            beef.healAmount = 2;
            beef.saturationModifier = 0.6f;

            ItemFood cooked_beef = (ItemFood) Items.cooked_beef;
            cooked_beef.healAmount = 4;
            cooked_beef.saturationModifier = 0.6f;
            cooked_beef.setPotionEffect(health_boost, 5, 0, one_third);

            ItemFood chicken = (ItemFood) Items.chicken;
            chicken.healAmount = 1;
            chicken.saturationModifier = 0.6f;

            ItemFood cooked_chicken = (ItemFood) Items.cooked_chicken;
            cooked_chicken.healAmount = 3;
            cooked_chicken.saturationModifier = 0.6f;
            cooked_chicken.setPotionEffect(health_boost, 5, 0, one_third);

            ItemFood rotten_flesh = (ItemFood) Items.rotten_flesh;
            rotten_flesh.healAmount = 1;
            rotten_flesh.saturationModifier = 0.3f;

            ItemFood spider_eye = (ItemFood) Items.spider_eye;
            spider_eye.healAmount = 1;
            spider_eye.saturationModifier = 0.3f;

            ItemFood carrot = (ItemFood) Items.carrot;
            carrot.healAmount = 1;
            carrot.saturationModifier = 0.3f;
            carrot.setPotionEffect(night_vision, 5, 0, one_third);

            ItemFood potato = (ItemFood) Items.potato;
            potato.healAmount = 2;
            potato.saturationModifier = 0.3f;

            ItemFood baked_potato = (ItemFood) Items.baked_potato;
            baked_potato.healAmount = 4;
            baked_potato.saturationModifier = 0.5f;

            ItemFood poisonous_potato = (ItemFood) Items.poisonous_potato;
            poisonous_potato.healAmount = 1;
            poisonous_potato.saturationModifier = 0.3f;

            ItemFood golden_carrot = (ItemFood) Items.golden_carrot;
            golden_carrot.healAmount = 4;
            golden_carrot.saturationModifier = 1.2f;
            golden_carrot.setPotionEffect(night_vision, 45, 0, two_thirds);

            ItemFood pumpkin_pie = (ItemFood) Items.pumpkin_pie;
            pumpkin_pie.healAmount = 7;
            pumpkin_pie.saturationModifier = 0.9f;
            pumpkin_pie.setPotionEffect(resistance, 90, 1, two_thirds);
        }

        if (isModLoaded("etfuturum") && enableEFRFoodValueChanges) {
            Item raw_mutton = findItem("etfuturum", "raw_mutton");
            if (raw_mutton instanceof ItemFood ItemMuttonRaw) {
                ItemMuttonRaw.healAmount = 2;
                ItemMuttonRaw.saturationModifier = 0.6f;
            }

            Item mutton_cooked = findItem("etfuturum", "mutton_cooked");
            if (mutton_cooked instanceof ItemFood ItemMuttonCooked) {
                ItemMuttonCooked.healAmount = 4;
                ItemMuttonCooked.saturationModifier = 0.6f;
                ItemMuttonCooked.setPotionEffect(health_boost, 5, 0, one_third);
            }

            Item rabbit_raw = findItem("etfuturum", "rabbit_raw");
            if (rabbit_raw instanceof ItemFood ItemRabbitRaw) {
                ItemRabbitRaw.healAmount = 1;
                ItemRabbitRaw.saturationModifier = 0.6f;
            }

            Item rabbit_cooked = findItem("etfuturum", "rabbit_cooked");
            if (rabbit_cooked instanceof ItemFood ItemRabbitCooked) {
                ItemRabbitCooked.healAmount = 3;
                ItemRabbitCooked.saturationModifier = 0.6f;
                ItemRabbitCooked.setPotionEffect(health_boost, 5, 0, one_third);
            }

            Item rabbit_stew = findItem("etfuturum", "rabbit_stew");
            if (rabbit_stew instanceof ItemFood ItemRabbitStew) {
                ItemRabbitStew.healAmount = 7;
                ItemRabbitStew.saturationModifier = 0.7f;
                ItemRabbitStew.setPotionEffect(health_boost, 30, 0, one_third);
            }

            Item beetroot = findItem("etfuturum", "beetroot");
            if (beetroot instanceof ItemFood ItemBeetroot) {
                ItemBeetroot.healAmount = 1;
                ItemBeetroot.saturationModifier = 0.3f;
                ItemBeetroot.setPotionEffect(jump_boost, 5, 0, one_third);
            }

            Item beetroot_soup = findItem("etfuturum", "beetroot_soup");
            if (beetroot_soup instanceof ItemFood ItemBeetrootSoup) {
                ItemBeetrootSoup.healAmount = 5;
                ItemBeetrootSoup.saturationModifier = 0.7f;
                ItemBeetrootSoup.setPotionEffect(jump_boost, 60, 1, one_third);
            }

            Item chorus_fruit = findItem("etfuturum", "chorus_fruit");
            if (chorus_fruit instanceof ItemFood ItemChorusFruit) {
                ItemChorusFruit.healAmount = 1;
                ItemChorusFruit.saturationModifier = 0.3f;
            }

            Item suspicious_stew = findItem("etfuturum", "suspicious_stew");
            if (suspicious_stew instanceof ItemFood ItemSuspiciousStew) {
                ItemSuspiciousStew.healAmount = 5;
                ItemSuspiciousStew.saturationModifier = 0.7f;
            }

            Item sweet_berries = findItem("etfuturum", "sweet_berries");
            if (sweet_berries instanceof ItemFood ItemSweetBerries) {
                ItemSweetBerries.healAmount = 1;
                ItemSweetBerries.saturationModifier = 0.3f;
                ItemSweetBerries.setPotionEffect(speed, 5, 0, one_third);
            }
        }

        if (enableMushroomStewStacksize16) {
            Item mushroom_stew = findItem("minecraft", "mushroom_stew");
            mushroom_stew.setMaxStackSize(16);
        }

        if (isModLoaded("etfuturum") && enableEFRStewsStacksize16) {
            Item rabbit_stew = findItem("etfuturum", "rabbit_stew");
            if (rabbit_stew instanceof ItemSoup ItemRabbitStew) {
                ItemRabbitStew.setMaxStackSize(16);
            }

            Item beetroot_soup = findItem("etfuturum", "beetroot_soup");
            if (beetroot_soup instanceof ItemSoup ItemBeetrootSoup) {
                ItemBeetrootSoup.setMaxStackSize(16);
            }

            Item suspicious_stew = findItem("etfuturum", "suspicious_stew");
            if (suspicious_stew instanceof ItemSoup ItemSuspiciousStew) {
                ItemSuspiciousStew.setMaxStackSize(16);
            }
        }
        Item woodenShovel = findItem("minecraft", "wooden_shovel");
        woodenShovel.setMaxDamage(64);
    }
}
