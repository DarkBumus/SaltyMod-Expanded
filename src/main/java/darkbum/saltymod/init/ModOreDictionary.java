package darkbum.saltymod.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static darkbum.saltymod.init.ModExternalLoader.*;
import static net.minecraftforge.oredict.OreDictionary.*;
import static darkbum.saltymod.util.ConditionalRegistrar.*;
import static darkbum.saltymod.common.config.ModConfigurationItems.*;
import static darkbum.saltymod.init.ModBlocks.*;
import static darkbum.saltymod.init.ModItems.*;
import static darkbum.saltymod.init.ModItems.calamari;
import static net.minecraft.init.Blocks.*;
import static net.minecraft.init.Items.*;
import static net.minecraft.init.Items.cake;

/**
 * OreDictionary class.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class ModOreDictionary {

    /**
     * Initializes all ore dictionaries.
     */
    public static void init() {

        Item honeycombItem = harvestcraftItems.get("honeycombItem");
        Item royaljellyItem = harvestcraftItems.get("royaljellyItem");

        Item beeCombs = forestryItems.get("beeCombs");
        Item royalJelly = forestryItems.get("royalJelly");

        Item honeyCombFilled = growthcraftItems.get("honeyCombFilled");

        Item StriderFlankRaw = netherliciousItems.get("StriderFlankRaw");
        Item StriderFlankCooked = netherliciousItems.get("StriderFlankCooked");

        Block smooth_sandstone = etFuturumBlocks.get("smooth_sandstone");
        Block magma = etFuturumBlocks.get("magma");
        Block nether_fungus = etFuturumBlocks.get("nether_fungus");
        Item suspicious_stew = etFuturumItems.get("suspicious_stew");
        Item mutton_raw = etFuturumItems.get("mutton_raw");
        Item mutton_cooked = etFuturumItems.get("mutton_cooked");
        Item rabbit_raw = etFuturumItems.get("rabbit_raw");
        Item rabbit_cooked = etFuturumItems.get("rabbit_cooked");
        Item rabbit_stew = etFuturumItems.get("rabbit_stew");
        Item beetroot = etFuturumItems.get("beetroot");
        Item beetroot_soup = etFuturumItems.get("beetroot_soup");
        Item chorus_fruit = etFuturumItems.get("chorus_fruit");
        Item sweet_berries = etFuturumItems.get("sweet_berries");

        Item food = biomesOPlentyItems.get("food");

        Block campfire = campfireBackportBlocks.get("campfire");
        Block soul_campfire = campfireBackportBlocks.get("soul_campfire");

        // Salty Mod Ore Dictionaries
        registerOre("blockSandstone", new ItemStack(sandstone, 1, WILDCARD_VALUE), sandstone != null);
        registerOre("blockSandstone", smooth_sandstone, smooth_sandstone != null);
        registerOre("blockMushroom", red_mushroom, red_mushroom != null);
        registerOre("blockMushroom", brown_mushroom, brown_mushroom != null);
        registerOre("oreSalt", salt_ore, salt_ore != null);
        registerOre("blockSalt", new ItemStack(salt_block, 1, WILDCARD_VALUE), salt_block != null);
        registerOre("stairSalt", salt_brick_stairs, salt_brick_stairs != null);
        registerOre("slabSalt", new ItemStack(salt_slab, 1, WILDCARD_VALUE), salt_slab != null);
        registerOre("blockMud", mineral_mud, mineral_mud != null);
        registerOre("blockMud", wet_mud_brick, wet_mud_brick != null);
        registerOre("blockMud", dry_mud_brick, dry_mud_brick != null);

        registerOre("itemRedmeat", cooked_beef, cooked_beef != null);
        registerOre("itemRedmeat", new ItemStack(haunch, 1, 1), haunch != null);
        registerOre("itemRedmeat", new ItemStack(strider, 1, 1), strider != null);
        registerOre("itemFish", new ItemStack(fish, 1, 0), fish != null);
        registerOre("itemFish", new ItemStack(fish, 1, 1), fish != null);
        registerOre("itemFish", new ItemStack(fish, 1, 2), fish != null);
        registerOre("itemFish", tailor, tailor != null);
        registerOre("itemMilk", milk_bucket, milk_bucket != null);
        registerOre("itemMilk", powdered_milk, powdered_milk != null);
        registerOre("itemSweetener", sugar, sugar != null);
        registerOre("itemSweetener", honeycomb, honeycomb != null);
        registerOre("itemHoney", honeycomb, honeycomb != null);
        registerOre("itemRoyaljelly", royal_jelly, royal_jelly != null);
        registerOre("itemIngredientBucket", water_bucket, water_bucket != null);
        registerOre("itemIngredientBucket", milk_bucket, milk_bucket != null);
        registerOre("itemSalt", salt, salt != null);
        registerOre("materialWaxcomb", waxcomb, waxcomb != null);
        registerOre("materialWax", waxcomb, waxcomb != null);
        registerOre("cropOnion", onion, onion != null);
        registerOre("cropSaltwort", saltwort, saltwort != null);
        registerOre("foodCalamariraw", new ItemStack(calamari, 1, 0), calamari != null);
        registerOre("foodCalamaricooked", new ItemStack(calamari, 1, 1), calamari != null);

        registerOre("itemFood", apple, apple != null);
        registerOre("itemFood", melon, melon != null);
        registerOre("itemFood", carrot, carrot != null);
        registerOre("itemFood", potato, potato != null);
        registerOre("itemFood", onion, onion != null);
        registerOre("itemFood", saltwort, saltwort != null);
        registerOre("itemFood", new ItemStack(fish, 1, WILDCARD_VALUE), fish != null);
        registerOre("itemFood", calamari, calamari != null);
        registerOre("itemFood", porkchop, porkchop != null);
        registerOre("itemFood", beef, beef != null);
        registerOre("itemFood", chicken, chicken != null);
        registerOre("itemFood", haunch, haunch != null);
        registerOre("itemFood", strider, strider != null);
        registerOre("itemFood", rotten_flesh, rotten_flesh != null);
        registerOre("itemFood", spider_eye, spider_eye != null);
        registerOre("itemFood", poisonous_potato, poisonous_potato != null);
        registerOre("itemFood", dough, dough != null);
        registerOre("itemFood", tough_jelly, tough_jelly != null);
        registerOre("itemFood", new ItemStack(golden_apple, 1, WILDCARD_VALUE), golden_apple != null);
        registerOre("itemFood", new ItemStack(golden_berries, 1, WILDCARD_VALUE), golden_berries != null);
        registerOre("itemFood", golden_carrot, golden_carrot != null);
        registerOre("itemFood", golden_potato, golden_potato != null);
        registerOre("itemFood", golden_saltwort, golden_saltwort != null);
        registerOre("itemFood", baked_potato, baked_potato != null);
        registerOre("itemFood", new ItemStack(cooked_fished, 1, WILDCARD_VALUE), cooked_fished != null);
        registerOre("itemFood", cooked_tropical_fish, cooked_tropical_fish != null);
        registerOre("itemFood", new ItemStack(tailor, 1, 0), tailor != null);
        registerOre("itemFood", new ItemStack(tailor, 1, 1), tailor != null);
        registerOre("itemFood", new ItemStack(tailor, 1, 2), tailor != null);
        registerOre("itemFood", new ItemStack(calamari, 1, 1), calamari != null);
        registerOre("itemFood", cooked_porkchop, cooked_porkchop != null);
        registerOre("itemFood", cooked_beef, cooked_beef != null);
        registerOre("itemFood", cooked_chicken, cooked_chicken != null);
        registerOre("itemFood", new ItemStack(haunch, 1, 1), haunch != null);
        registerOre("itemFood", new ItemStack(strider, 1, 1), strider != null);
        registerOre("itemFood", bread, bread != null);
        registerOre("itemFood", sugar_apple, sugar_apple != null);
        registerOre("itemFood", new ItemStack(melon_soup, 1, 1), melon_soup != null);
        registerOre("itemFood", sugar_berries, sugar_berries != null);
        registerOre("itemFood", honey_apple, honey_apple != null);
        registerOre("itemFood", honey_berries, honey_berries != null);
        registerOre("itemFood", chocolate_berries, chocolate_berries != null);
        registerOre("itemFood", salt_baked_potato, salt_baked_potato != null);
        registerOre("itemFood", salt_beetroot, salt_beetroot != null);
        registerOre("itemFood", salt_cooked_cod, salt_cooked_cod != null);
        registerOre("itemFood", salt_cooked_salmon, salt_cooked_salmon != null);
        registerOre("itemFood", new ItemStack(cooked_tropical_fish, 1, 1), cooked_tropical_fish != null);
        registerOre("itemFood", new ItemStack(calamari, 1, 2), calamari != null);
        registerOre("itemFood", salt_cooked_porkchop, salt_cooked_porkchop != null);
        registerOre("itemFood", salt_cooked_beef, salt_cooked_beef != null);
        registerOre("itemFood", salt_cooked_chicken, salt_cooked_chicken != null);
        registerOre("itemFood", salt_cooked_rabbit, salt_cooked_rabbit != null);
        registerOre("itemFood", salt_cooked_mutton, salt_cooked_mutton != null);
        registerOre("itemFood", new ItemStack(haunch, 1, 2), haunch != null);
        registerOre("itemFood", new ItemStack(strider, 1, 2), strider != null);
        registerOre("itemFood", cured_meat, cured_meat != null);
        registerOre("itemFood", honey_porkchop, honey_porkchop != null);
        registerOre("itemFood", salt_bread, salt_bread != null);
        registerOre("itemFood", salt_egg, salt_egg != null);
        registerOre("itemFood", cookie, cookie != null);
        registerOre("itemFood", cake, cake != null);
        registerOre("itemFood", chocolate_bar, chocolate_bar != null);
        registerOre("itemFood", mushroom_stew, mushroom_stew != null);
        registerOre("itemFood", pumpkin_porridge, pumpkin_porridge != null);
        registerOre("itemFood", cactus_soup, cactus_soup != null);
        registerOre("itemFood", stewed_vegetables, stewed_vegetables != null);
        registerOre("itemFood", potato_mushroom, potato_mushroom != null);
        registerOre("itemFood", golden_vegetables, golden_vegetables != null);
        registerOre("itemFood", fish_soup, fish_soup != null);
        registerOre("itemFood", dandelion_salad, dandelion_salad != null);
        registerOre("itemFood", wheat_sprouts, wheat_sprouts != null);
        registerOre("itemFood", beetroot_salad, beetroot_salad != null);
        registerOre("itemFood", dressed_herring, dressed_herring != null);
        registerOre("itemFood", saltwort_salad, saltwort_salad != null);
        registerOre("itemFood", golden_saltwort_salad, golden_saltwort_salad != null);
        registerOre("itemFood", fruit_salad, fruit_salad != null);
        registerOre("itemFood", golden_fruit_salad, golden_fruit_salad != null);
        registerOre("itemFood", grated_carrot, grated_carrot != null);
        registerOre("itemFood", melon_soup, melon_soup != null);
        registerOre("itemFood", fermented_saltwort, fermented_saltwort != null);
        registerOre("itemFood", fermented_mushroom, fermented_mushroom != null);
        registerOre("itemFood", fermented_fern, fermented_fern != null);
        registerOre("itemFood", pickled_calamari, pickled_calamari != null);
        registerOre("itemFood", pickled_onion, pickled_onion != null);
        registerOre("itemFood", pickled_beetroot, pickled_beetroot != null);
        registerOre("itemFood", melon_preserves, melon_preserves != null);
        registerOre("itemFood", berry_preserves, berry_preserves != null);
        registerOre("itemFood", apple_preserves, apple_preserves != null);
        registerOre("itemFood", salt_mushroom_stew, salt_mushroom_stew != null);
        registerOre("itemFood", salt_rabbit_stew, salt_rabbit_stew != null);
        registerOre("itemFood", salt_beetroot_soup, salt_beetroot_soup != null);
        registerOre("itemFood", new ItemStack(pumpkin_porridge, 1, 1), pumpkin_porridge != null);
        registerOre("itemFood", new ItemStack(cactus_soup, 1, 1), cactus_soup != null);
        registerOre("itemFood", new ItemStack(stewed_vegetables, 1, 1), stewed_vegetables != null);
        registerOre("itemFood", new ItemStack(potato_mushroom, 1, 1), potato_mushroom != null);
        registerOre("itemFood", new ItemStack(golden_vegetables, 1, 1), golden_vegetables != null);
        registerOre("itemFood", new ItemStack(fish_soup, 1, 1), fish_soup != null);
        registerOre("itemFood", new ItemStack(dandelion_salad, 1, 1), dandelion_salad != null);
        registerOre("itemFood", new ItemStack(wheat_sprouts, 1, 1), wheat_sprouts != null);
        registerOre("itemFood", new ItemStack(beetroot_salad, 1, 1), beetroot_salad != null);
        registerOre("itemFood", new ItemStack(dressed_herring, 1, 1), dressed_herring != null);
        registerOre("itemFood", saltwort_cooked_beef, saltwort_cooked_beef != null);
        registerOre("itemFood", saltwort_cooked_porkchop, saltwort_cooked_porkchop != null);
        registerOre("itemFood", saltwort_honey_porkchop, saltwort_honey_porkchop != null);
        registerOre("itemFood", saltwort_cooked_strider, saltwort_cooked_strider != null);
        registerOre("itemFood", saltwort_cooked_mutton, saltwort_cooked_mutton != null);
        registerOre("itemFood", saltwort_cooked_haunch, saltwort_cooked_haunch != null);
        registerOre("itemFood", new ItemStack(fruit_salad, 1, 1), fruit_salad != null);
        registerOre("itemFood", new ItemStack(golden_fruit_salad, 1, 1), golden_fruit_salad != null);
        registerOre("itemFood", new ItemStack(grated_carrot, 1, 1), grated_carrot != null);
        registerOre("itemFood", new ItemStack(melon_soup, 1, 1), melon_soup != null);
        registerOre("itemFood", pumpkin_pie, pumpkin_pie != null);
        registerOre("itemFood", chocolate_pie, chocolate_pie != null);
        registerOre("itemFood", carrot_pie, carrot_pie != null);
        registerOre("itemFood", apple_pie, apple_pie != null);
        registerOre("itemFood", sweetberry_pie, sweetberry_pie != null);
        registerOre("itemFood", potato_pie, potato_pie != null);
        registerOre("itemFood", onion_pie, onion_pie != null);
        registerOre("itemFood", cod_pie, cod_pie != null);
        registerOre("itemFood", salmon_pie, salmon_pie != null);
        registerOre("itemFood", tropical_fish_pie, tropical_fish_pie != null);
        registerOre("itemFood", calamari_pie, calamari_pie != null);
        registerOre("itemFood", shepherds_pie, shepherds_pie != null);
        registerOre("itemFood", mushroom_pie, mushroom_pie != null);
        registerOre("itemFood", saltwort_pie, saltwort_pie != null);
        registerOre("itemFood", muffin, muffin != null);

        registerOre("itemCoal", new ItemStack(coal, 1, 0), coal != null);
        registerOre("itemCoal", new ItemStack(coal, 1, 1), coal != null);

        registerOre("beeResistant", new ItemStack(mud_helmet, 1, WILDCARD_VALUE), mudArmorBeeResistant, mud_helmet != null);
        registerOre("beeResistant", new ItemStack(mud_chestplate, 1, WILDCARD_VALUE), mudArmorBeeResistant, mud_chestplate != null);
        registerOre("beeResistant", new ItemStack(mud_leggings, 1, WILDCARD_VALUE), mudArmorBeeResistant, mud_leggings != null);
        registerOre("beeResistant", new ItemStack(mud_boots, 1, WILDCARD_VALUE), mudArmorBeeResistant, mud_boots != null);

        registerOre("blockHeater", flowing_lava, flowing_lava != null);
        registerOre("blockHeater", lava, lava != null);
        registerOre("blockHeater", fire, fire != null);
        registerOre("blockHeater", lit_furnace, lit_furnace != null);
        registerOre("blockHeater", lit_stove, lit_stove != null);

        registerOre("itemPinch", salt_pinch, salt_pinch != null);
        registerOre("itemPinch", sugar_pinch, sugar_pinch != null);

        registerOre("itemVessel", bucket, bucket != null);
        registerOre("itemVessel", water_bucket, water_bucket != null);
        registerOre("itemVessel", new ItemStack(potionitem, 1, 0), potionitem != null);
        registerOre("itemVessel", glass_bottle, glass_bottle != null);
        registerOre("itemVessel", fizzy_drink, fizzy_drink != null);

        registerOre("itemBowl", bowl, bowl != null);

        registerOre("itemSpade", new ItemStack(wooden_shovel, 1, WILDCARD_VALUE), wooden_shovel != null);

        //External Ore Dictionaries
        registerOre("itemSweetener", honeycombItem, honeycombItem != null);
        registerOre("itemHoney", honeycombItem, honeycombItem != null);
        registerOre("itemRoyaljelly", royaljellyItem, royaljellyItem != null);

        registerOre("itemSweetener", beeCombs, beeCombs != null);
        registerOre("itemHoney", beeCombs, beeCombs != null);
        registerOre("itemRoyaljelly", royalJelly, royalJelly != null);

        registerOre("itemSweetener", honeyCombFilled, honeyCombFilled != null);
        registerOre("itemHoney", honeyCombFilled, honeyCombFilled != null);

        registerOre("itemFood", StriderFlankRaw, StriderFlankRaw != null);
        registerOre("itemRedmeat", StriderFlankCooked, StriderFlankCooked != null);
        registerOre("itemFood", StriderFlankCooked, StriderFlankCooked != null);

        registerOre("blockFungus", new ItemStack(nether_fungus, 1, 0), nether_fungus != null);
        registerOre("blockFungus", new ItemStack(nether_fungus, 1, 1), nether_fungus != null);

        registerOre("itemFood", new ItemStack(suspicious_stew, 1, WILDCARD_VALUE), suspicious_stew != null);
        registerOre("itemFood", mutton_raw, mutton_raw != null);
        registerOre("itemRedmeat", mutton_cooked, mutton_cooked != null);
        registerOre("itemFood", mutton_cooked, mutton_cooked != null);
        registerOre("itemFood", rabbit_raw, rabbit_raw != null);
        registerOre("itemFood", rabbit_cooked, rabbit_cooked != null);
        registerOre("itemFood", rabbit_stew, rabbit_stew != null);
        registerOre("itemFood", beetroot, beetroot != null);
        registerOre("itemFood", beetroot_soup, beetroot_soup != null);
        registerOre("itemFood", chorus_fruit, chorus_fruit != null);
        registerOre("itemFood", sweet_berries, sweet_berries != null);

        registerOre("itemSweetener", new ItemStack(food, 1, 9), food != null);
        registerOre("itemHoney", new ItemStack(food, 1, 9), food != null);

        registerOre("blockHeater", magma, magma != null);

        registerOre("blockHeater", campfire, campfire != null);
        registerOre("blockHeater", soul_campfire, soul_campfire != null);
    }
}
