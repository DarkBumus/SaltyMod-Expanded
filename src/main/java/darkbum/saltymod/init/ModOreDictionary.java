package darkbum.saltymod.init;

import darkbum.saltymod.tileentity.TileEntityEvaporator;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

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
 * Recipe class for {@link TileEntityEvaporator}
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

        Item honeyCombFilled = growthcraftItems.get("honeyCombFilled");

        Item StriderFlankRaw = netherliciousItems.get("StriderFlankRaw");
        Item StriderFlankCooked = netherliciousItems.get("StriderFlankCooked");

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
        registerOre("blockMushroom", red_mushroom);
        registerOre("blockMushroom", brown_mushroom);
        registerOre("oreSalt", salt_ore);
        registerOre("blockSalt", new ItemStack(salt_block, 1, WILDCARD_VALUE));
        registerOre("stairSalt", salt_brick_stairs);
        registerOre("slabSalt", new ItemStack(salt_slab, 1, WILDCARD_VALUE));
        registerOre("blockMud", mineral_mud);
        registerOre("blockMud", wet_mud_brick);
        registerOre("blockMud", dry_mud_brick);

        registerOre("itemRedmeat", cooked_beef);
        registerOre("itemRedmeat", new ItemStack(haunch, 1, 1));
        registerOre("itemRedmeat", new ItemStack(strider, 1, 1));
        registerOre("itemFish", new ItemStack(fish, 1, 0));
        registerOre("itemFish", new ItemStack(fish, 1, 1));
        registerOre("itemFish", new ItemStack(fish, 1, 2));
        registerOre("itemFish", tailor);
        registerOre("itemMilk", milk_bucket);
        registerOre("itemMilk", powdered_milk);
        registerOre("materialWaxcomb", waxcomb);
        registerOre("materialWax", waxcomb);
        registerOre("itemSweetener", sugar);
        registerOre("itemSweetener", honeycomb);
        registerOre("itemHoney", honeycomb);
        registerOre("itemRoyaljelly", royal_jelly);
        registerOre("itemIngredientBucket", water_bucket);
        registerOre("itemIngredientBucket", milk_bucket);
        registerOre("cropOnion", onion);
        registerOre("cropSaltwort", saltwort);

        registerOre("itemFood", apple);
        registerOre("itemFood", melon);
        registerOre("itemFood", carrot);
        registerOre("itemFood", potato);
        registerOre("itemFood", onion);
        registerOre("itemFood", saltwort);
        registerOre("itemFood", new ItemStack(fish, 1, WILDCARD_VALUE));
        registerOre("itemFood", calamari);
        registerOre("itemFood", porkchop);
        registerOre("itemFood", beef);
        registerOre("itemFood", chicken);
        registerOre("itemFood", haunch);
        registerOre("itemFood", strider);
        registerOre("itemFood", rotten_flesh);
        registerOre("itemFood", spider_eye);
        registerOre("itemFood", poisonous_potato);
        registerOre("itemFood", dough);
        registerOre("itemFood", tough_jelly);
        registerOre("itemFood", new ItemStack(golden_apple, 1, WILDCARD_VALUE));
        registerOre("itemFood", new ItemStack(golden_berries, 1, WILDCARD_VALUE));
        registerOre("itemFood", golden_carrot);
        registerOre("itemFood", golden_potato);
        registerOre("itemFood", golden_saltwort);
        registerOre("itemFood", baked_potato);
        registerOre("itemFood", new ItemStack(cooked_fished, 1, WILDCARD_VALUE));
        registerOre("itemFood", cooked_tropical_fish);
        registerOre("itemFood", new ItemStack(tailor, 1, 0));
        registerOre("itemFood", new ItemStack(tailor, 1, 1));
        registerOre("itemFood", new ItemStack(tailor, 1, 2));
        registerOre("itemFood", new ItemStack(calamari, 1, 1));
        registerOre("itemFood", cooked_porkchop);
        registerOre("itemFood", cooked_beef);
        registerOre("itemFood", cooked_chicken);
        registerOre("itemFood", new ItemStack(haunch, 1, 1));
        registerOre("itemFood", new ItemStack(strider, 1, 1));
        registerOre("itemFood", bread);
        registerOre("itemFood", sugar_apple);
        registerOre("itemFood", new ItemStack(melon_soup, 1, 1));
        registerOre("itemFood", sugar_berries);
        registerOre("itemFood", honey_apple);
        registerOre("itemFood", honey_berries);
        registerOre("itemFood", chocolate_berries);
        registerOre("itemFood", salt_baked_potato);
        registerOre("itemFood", salt_beetroot);
        registerOre("itemFood", salt_cooked_cod);
        registerOre("itemFood", salt_cooked_salmon);
        registerOre("itemFood", new ItemStack(cooked_tropical_fish, 1, 1));
        registerOre("itemFood", new ItemStack(calamari, 1, 2));
        registerOre("itemFood", salt_cooked_porkchop);
        registerOre("itemFood", salt_cooked_beef);
        registerOre("itemFood", salt_cooked_chicken);
        registerOre("itemFood", salt_cooked_rabbit);
        registerOre("itemFood", salt_cooked_mutton);
        registerOre("itemFood", new ItemStack(haunch, 1, 2));
        registerOre("itemFood", new ItemStack(strider, 1, 2));
        registerOre("itemFood", cured_meat);
        registerOre("itemFood", honey_porkchop);
        registerOre("itemFood", salt_bread);
        registerOre("itemFood", salt_egg);
        registerOre("itemFood", cookie);
        registerOre("itemFood", cake);
        registerOre("itemFood", chocolate_bar);
        registerOre("itemFood", mushroom_stew);
        registerOre("itemFood", pumpkin_porridge);
        registerOre("itemFood", cactus_soup);
        registerOre("itemFood", stewed_vegetables);
        registerOre("itemFood", potato_mushroom);
        registerOre("itemFood", golden_vegetables);
        registerOre("itemFood", fish_soup);
        registerOre("itemFood", dandelion_salad);
        registerOre("itemFood", wheat_sprouts);
        registerOre("itemFood", beetroot_salad);
        registerOre("itemFood", dressed_herring);
        registerOre("itemFood", saltwort_salad);
        registerOre("itemFood", golden_saltwort_salad);
        registerOre("itemFood", fruit_salad);
        registerOre("itemFood", golden_fruit_salad);
        registerOre("itemFood", grated_carrot);
        registerOre("itemFood", melon_soup);
        registerOre("itemFood", fermented_saltwort);
        registerOre("itemFood", fermented_mushroom);
        registerOre("itemFood", fermented_fern);
        registerOre("itemFood", pickled_calamari);
        registerOre("itemFood", pickled_onion);
        registerOre("itemFood", pickled_beetroot);
        registerOre("itemFood", melon_preserves);
        registerOre("itemFood", berry_preserves);
        registerOre("itemFood", apple_preserves);
        registerOre("itemFood", salt_mushroom_stew);
        registerOre("itemFood", salt_rabbit_stew);
        registerOre("itemFood", salt_beetroot_soup);
        registerOre("itemFood", new ItemStack(pumpkin_porridge, 1, 1));
        registerOre("itemFood", new ItemStack(cactus_soup, 1, 1));
        registerOre("itemFood", new ItemStack(stewed_vegetables, 1, 1));
        registerOre("itemFood", new ItemStack(potato_mushroom, 1, 1));
        registerOre("itemFood", new ItemStack(golden_vegetables, 1, 1));
        registerOre("itemFood", new ItemStack(fish_soup, 1, 1));
        registerOre("itemFood", new ItemStack(dandelion_salad, 1, 1));
        registerOre("itemFood", new ItemStack(wheat_sprouts, 1, 1));
        registerOre("itemFood", new ItemStack(beetroot_salad, 1, 1));
        registerOre("itemFood", new ItemStack(dressed_herring, 1, 1));
        registerOre("itemFood", saltwort_cooked_beef);
        registerOre("itemFood", saltwort_cooked_porkchop);
        registerOre("itemFood", saltwort_honey_porkchop);
        registerOre("itemFood", saltwort_cooked_strider);
        registerOre("itemFood", saltwort_cooked_mutton);
        registerOre("itemFood", saltwort_cooked_haunch);
        registerOre("itemFood", new ItemStack(fruit_salad, 1, 1));
        registerOre("itemFood", new ItemStack(golden_fruit_salad, 1, 1));
        registerOre("itemFood", new ItemStack(grated_carrot, 1, 1));
        registerOre("itemFood", new ItemStack(melon_soup, 1, 1));
        registerOre("itemFood", pumpkin_pie);
        registerOre("itemFood", chocolate_pie);
        registerOre("itemFood", carrot_pie);
        registerOre("itemFood", apple_pie);
        registerOre("itemFood", sweetberry_pie);
        registerOre("itemFood", potato_pie);
        registerOre("itemFood", onion_pie);
        registerOre("itemFood", cod_pie);
        registerOre("itemFood", salmon_pie);
        registerOre("itemFood", tropical_fish_pie);
        registerOre("itemFood", calamari_pie);
        registerOre("itemFood", shepherds_pie);
        registerOre("itemFood", mushroom_pie);
        registerOre("itemFood", saltwort_pie);
        registerOre("itemFood", muffin);

        registerOre("itemCoal", new ItemStack(coal, 1, 0));
        registerOre("itemCoal", new ItemStack(coal, 1, 1));

        registerOre("beeResistant", new ItemStack(mud_helmet, 1, WILDCARD_VALUE), mudArmorBeeResistant);
        registerOre("beeResistant", new ItemStack(mud_chestplate, 1, WILDCARD_VALUE), mudArmorBeeResistant);
        registerOre("beeResistant", new ItemStack(mud_leggings, 1, WILDCARD_VALUE), mudArmorBeeResistant);
        registerOre("beeResistant", new ItemStack(mud_boots, 1, WILDCARD_VALUE), mudArmorBeeResistant);

        registerOre("blockHeater", flowing_lava);
        registerOre("blockHeater", lava);
        registerOre("blockHeater", fire);
        registerOre("blockHeater", lit_furnace);
        registerOre("blockHeater", lit_stove);

        registerOre("itemPinch", salt_pinch);
        registerOre("itemPinch", sugar_pinch);

        registerOre("itemVessel", bucket);
        registerOre("itemVessel", water_bucket);
        registerOre("itemVessel", new ItemStack(potionitem, 1, 0));
        registerOre("itemVessel", glass_bottle);
        registerOre("itemVessel", fizzy_drink);

        registerOre("itemBowl", bowl);

        registerOre("itemSpade", new ItemStack(wooden_shovel, 1, OreDictionary.WILDCARD_VALUE));

        //External Ore Dictionaries
        registerOre("itemSweetener", honeycombItem, honeycombItem != null);
        registerOre("itemHoney", honeycombItem, honeycombItem != null);
        registerOre("itemRoyaljelly", royaljellyItem, royaljellyItem != null);

        registerOre("itemSweetener", beeCombs, beeCombs != null);
        registerOre("itemHoney", beeCombs, beeCombs != null);

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

        registerOre("blockHeater", magma);

        registerOre("blockHeater", campfire);
        registerOre("blockHeater", soul_campfire);
    }
}
