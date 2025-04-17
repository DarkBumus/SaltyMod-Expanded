package darkbum.saltymod.init;

import cpw.mods.fml.common.Loader;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSoup;
import net.minecraft.potion.Potion;

import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltymod.configuration.configs.ModConfigurationModCompatibility;
import darkbum.saltymod.configuration.configs.ModConfigurationVanillaChanges;

public class ModExternalValueRegistry {

    public static void init() {

        if (ModConfigurationVanillaChanges.enableVanillaFoodValueChanges) {

            ItemFood apple = (ItemFood) Items.apple;
            apple.healAmount = 2;
            apple.saturationModifier = 0.3F;

            ItemFood mushroom_stew = (ItemFood) Items.mushroom_stew;
            mushroom_stew.healAmount = 5;
            mushroom_stew.saturationModifier = 0.7F;

            ItemFood bread = (ItemFood) Items.bread;
            bread.healAmount = 3;
            bread.saturationModifier = 0.5F;

            ItemFood porkchop = (ItemFood) Items.porkchop;
            porkchop.healAmount = 2;
            porkchop.saturationModifier = 0.6F;

            ItemFood cooked_porkchop = (ItemFood) Items.cooked_porkchop;
            cooked_porkchop.healAmount = 4;
            cooked_porkchop.saturationModifier = 0.6F;

            ItemFood golden_apple = (ItemFood) Items.golden_apple;
            golden_apple.healAmount = 4;
            golden_apple.saturationModifier = 0.6F;

            ItemFishFood fish = (ItemFishFood) Items.fish;
            ItemFishFood.FishType.COD.field_150991_j = 1;
            ItemFishFood.FishType.COD.field_150992_k = 0.5F;
            ItemFishFood.FishType.COD.field_150989_l = 3;
            ItemFishFood.FishType.COD.field_150990_m = 0.5F;

            ItemFishFood.FishType.SALMON.field_150991_j = 1;
            ItemFishFood.FishType.SALMON.field_150992_k = 0.5F;
            ItemFishFood.FishType.SALMON.field_150989_l = 3;
            ItemFishFood.FishType.SALMON.field_150990_m = 0.5F;

            ItemFishFood.FishType.CLOWNFISH.field_150991_j = 1;
            ItemFishFood.FishType.CLOWNFISH.field_150992_k = 0.5F;
            ItemFishFood.FishType.CLOWNFISH.field_150989_l = 0;
            ItemFishFood.FishType.CLOWNFISH.field_150990_m = 0.0F;

            ItemFishFood.FishType.PUFFERFISH.field_150991_j = 1;
            ItemFishFood.FishType.PUFFERFISH.field_150992_k = 0.5F;
            ItemFishFood.FishType.PUFFERFISH.field_150989_l = 0;
            ItemFishFood.FishType.PUFFERFISH.field_150990_m = 0.0F;

            fish.setPotionEffect(Potion.waterBreathing.id, 3, 0, 1.0F);

            ItemFood cookie = (ItemFood) Items.cookie;
            cookie.healAmount = 2;
            cookie.saturationModifier = 0.1F;

            ItemFood melon = (ItemFood) Items.melon;
            melon.healAmount = 1;
            melon.saturationModifier = 0.3F;
            melon.setPotionEffect(Potion.jump.id, 3, 0, 1.0F);

            ItemFood beef = (ItemFood) Items.beef;
            beef.healAmount = 2;
            beef.saturationModifier = 0.6F;

            ItemFood cooked_beef = (ItemFood) Items.cooked_beef;
            cooked_beef.healAmount = 4;
            cooked_beef.saturationModifier = 0.6F;

            ItemFood chicken = (ItemFood) Items.chicken;
            chicken.healAmount = 1;
            chicken.saturationModifier = 0.6F;

            ItemFood cooked_chicken = (ItemFood) Items.cooked_chicken;
            cooked_chicken.healAmount = 3;
            cooked_chicken.saturationModifier = 0.6F;

            ItemFood rotten_flesh = (ItemFood) Items.rotten_flesh;
            rotten_flesh.healAmount = 1;
            rotten_flesh.saturationModifier = 0.3F;

            ItemFood spider_eye = (ItemFood) Items.spider_eye;
            spider_eye.healAmount = 1;
            spider_eye.saturationModifier = 0.3F;

            ItemFood carrot = (ItemFood) Items.carrot;
            carrot.healAmount = 2;
            carrot.saturationModifier = 0.3F;

            ItemFood potato = (ItemFood) Items.potato;
            potato.healAmount = 1;
            potato.saturationModifier = 0.3F;

            ItemFood baked_potato = (ItemFood) Items.baked_potato;
            baked_potato.healAmount = 3;
            baked_potato.saturationModifier = 0.5F;

            ItemFood poisonous_potato = (ItemFood) Items.poisonous_potato;
            poisonous_potato.healAmount = 1;
            poisonous_potato.saturationModifier = 0.3F;

            ItemFood golden_carrot = (ItemFood) Items.golden_carrot;
            golden_carrot.healAmount = 6;
            golden_carrot.saturationModifier = 1.2F;

            ItemFood pumpkin_pie = (ItemFood) Items.pumpkin_pie;
            pumpkin_pie.healAmount = 7;
            pumpkin_pie.saturationModifier = 0.9F;
        }

        if (Loader.isModLoaded("etfuturum") && ModConfigurationModCompatibility.enableEFRFoodValueChanges) {

            Item raw_mutton = GameRegistry.findItem("etfuturum", "raw_mutton");
            if (raw_mutton instanceof ItemFood ItemMuttonRaw) {
                ItemMuttonRaw.healAmount = 2;
                ItemMuttonRaw.saturationModifier = 0.6F;
            }

            Item mutton_cooked = GameRegistry.findItem("etfuturum", "mutton_cooked");
            if (mutton_cooked instanceof ItemFood ItemMuttonCooked) {
                ItemMuttonCooked.healAmount = 4;
                ItemMuttonCooked.saturationModifier = 0.6F;
            }

            Item rabbit_raw = GameRegistry.findItem("etfuturum", "rabbit_raw");
            if (rabbit_raw instanceof ItemFood ItemRabbitRaw) {
                ItemRabbitRaw.healAmount = 1;
                ItemRabbitRaw.saturationModifier = 0.6F;
            }

            Item rabbit_cooked = GameRegistry.findItem("etfuturum", "rabbit_cooked");
            if (rabbit_cooked instanceof ItemFood ItemRabbitCooked) {
                ItemRabbitCooked.healAmount = 3;
                ItemRabbitCooked.saturationModifier = 0.6F;
            }

            Item rabbit_stew = GameRegistry.findItem("etfuturum", "rabbit_stew");
            if (rabbit_stew instanceof ItemFood ItemRabbitStew) {
                ItemRabbitStew.healAmount = 7;
                ItemRabbitStew.saturationModifier = 0.7F;
            }

            Item beetroot = GameRegistry.findItem("etfuturum", "beetroot");
            if (beetroot instanceof ItemFood ItemBeetroot) {
                ItemBeetroot.healAmount = 1;
                ItemBeetroot.saturationModifier = 0.3F;
            }

            Item beetroot_soup = GameRegistry.findItem("etfuturum", "beetroot_soup");
            if (beetroot_soup instanceof ItemFood ItemBeetrootSoup) {
                ItemBeetrootSoup.healAmount = 5;
                ItemBeetrootSoup.saturationModifier = 0.7F;
            }

            Item chorus_fruit = GameRegistry.findItem("etfuturum", "chorus_fruit");
            if (chorus_fruit instanceof ItemFood ItemChorusFruit) {
                ItemChorusFruit.healAmount = 1;
                ItemChorusFruit.saturationModifier = 0.3F;
            }

            Item suspicious_stew = GameRegistry.findItem("etfuturum", "suspicious_stew");
            if (suspicious_stew instanceof ItemFood ItemSuspiciousStew) {
                ItemSuspiciousStew.healAmount = 5;
                ItemSuspiciousStew.saturationModifier = 0.7F;
            }

            Item sweet_berries = GameRegistry.findItem("etfuturum", "sweet_berries");
            if (sweet_berries instanceof ItemFood ItemSweetBerries) {
                ItemSweetBerries.healAmount = 1;
                ItemSweetBerries.saturationModifier = 0.3F;
            }
        }

        if (ModConfigurationVanillaChanges.enableMushroomStewStacksize16) {

            Item mushroom_stew = GameRegistry.findItem("minecraft", "mushroom_stew");
            mushroom_stew.setMaxStackSize(16);
        }

        if (Loader.isModLoaded("etfuturum") && ModConfigurationModCompatibility.enableEFRStewsStacksize16) {

            Item rabbit_stew = GameRegistry.findItem("etfuturum", "rabbit_stew");
            if (rabbit_stew instanceof ItemSoup ItemRabbitStew) {
                ItemRabbitStew.setMaxStackSize(16);
            }

            Item beetroot_soup = GameRegistry.findItem("etfuturum", "beetroot_soup");
            if (beetroot_soup instanceof ItemSoup ItemBeetrootSoup) {
                ItemBeetrootSoup.setMaxStackSize(16);
            }

            Item suspicious_stew = GameRegistry.findItem("etfuturum", "suspicious_stew");
            if (suspicious_stew instanceof ItemSoup ItemSuspiciousStew) {
                ItemSuspiciousStew.setMaxStackSize(16);
            }
        }

        Item woodenShovel = GameRegistry.findItem("minecraft", "wooden_shovel");
            woodenShovel.setMaxDamage(64);
    }
}
