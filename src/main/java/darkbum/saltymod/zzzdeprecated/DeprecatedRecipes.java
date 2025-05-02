package darkbum.saltymod.zzzdeprecated;

import darkbum.saltymod.util.ConditionalRegistrar;
import darkbum.saltymod.common.config.ModConfigurationBlocks;
import darkbum.saltymod.common.config.ModConfigurationItems;
import darkbum.saltymod.common.config.ModConfigurationModCompatibility;
import darkbum.saltymod.common.config.ModConfigurationVanillaChanges;
import darkbum.saltymod.init.ModExternalItemLoader;
import darkbum.saltymod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DeprecatedRecipes {

    public static void init() {

        Block nether_fungus = ModExternalItemLoader.etFuturumBlocks.get("nether_fungus");
        Item rabbit_raw = ModExternalItemLoader.etFuturumItems.get("rabbit_raw");
        Item rabbit_stew = ModExternalItemLoader.etFuturumItems.get("rabbit_stew");
        Item beetroot = ModExternalItemLoader.etFuturumItems.get("beetroot");
        Item beetroot_soup = ModExternalItemLoader.etFuturumItems.get("beetroot_soup");
        Item chorus_fruit = ModExternalItemLoader.etFuturumItems.get("chorus_fruit");
        Item sweet_berries = ModExternalItemLoader.etFuturumItems.get("sweet_berries");


        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(Items.mushroom_stew),
            new boolean[]{ModConfigurationVanillaChanges.enableRecipeChanges},
            new ItemStack(Items.bowl),
            "blockMushroom",
            "blockMushroom");

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(Items.cookie, 4),
            new boolean[]{ModConfigurationVanillaChanges.enableRecipeChanges, ModConfigurationItems.enableDough},
            new ItemStack(ModItems.dough),
            new ItemStack(Items.dye, 1, 3));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(Items.cookie, 4),
            new boolean[]{ModConfigurationVanillaChanges.enableRecipeChanges, !ModConfigurationItems.enableDough},
            new ItemStack(Items.wheat),
            new ItemStack(Items.wheat),
            new ItemStack(Items.dye, 1, 3));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(Items.pumpkin_pie),
            new boolean[]{ModConfigurationVanillaChanges.enableRecipeChanges, ModConfigurationItems.enableDough},
            new ItemStack(Items.sugar),
            new ItemStack(Blocks.pumpkin),
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));

        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(rabbit_stew),
            new boolean[]{rabbit_stew != null, rabbit_raw != null},
            new ItemStack(Items.bowl),
            new ItemStack(rabbit_raw),
            new ItemStack(Items.carrot),
            new ItemStack(Items.potato),
            "blockMushroom");

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(beetroot_soup),
            new boolean[]{beetroot != null, beetroot_soup != null, ModConfigurationVanillaChanges.enableRecipeChanges},
            new ItemStack(Items.bowl),
            new ItemStack(beetroot),
            new ItemStack(beetroot),
            new ItemStack(beetroot));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.dough),
            new boolean[]{ModConfigurationItems.enableDough},
            new ItemStack(Items.wheat),
            new ItemStack(Items.potionitem));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.egg_bowl),
            new boolean[]{ModConfigurationItems.enableEgg},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(Items.egg),
            new ItemStack(Items.egg),
            new ItemStack(Items.egg),
            new ItemStack(Items.egg));

        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.salt_mushroom_stew),
            new boolean[]{ModConfigurationItems.enableSaltedMushroomStew},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.bowl),
            "blockMushroom",
            "blockMushroom");

        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.salt_rabbit_stew),
            new boolean[]{rabbit_raw != null, ModConfigurationModCompatibility.enableSaltedRabbitRagout},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(rabbit_raw),
            new ItemStack(Items.carrot),
            new ItemStack(Items.potato),
            "blockMushroom");

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.salt_beetroot_soup),
            new boolean[]{beetroot != null, ModConfigurationModCompatibility.enableSaltedBorscht},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(beetroot),
            new ItemStack(beetroot),
            new ItemStack(beetroot));

        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.fungus_stew),
            new boolean[]{nether_fungus != null, ModConfigurationModCompatibility.enableFungusStew},
            new ItemStack(Items.bowl),
            "blockFungus",
            "blockFungus");
        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.fungus_stew, 1, 1),
            new boolean[]{nether_fungus != null, ModConfigurationModCompatibility.enableFungusStew},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.bowl),
            "blockFungus",
            "blockFungus");

        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.chicken_soup),
            new boolean[]{ModConfigurationItems.enableChickenSoup},
            new ItemStack(Items.bowl),
            new ItemStack(Items.chicken),
            new ItemStack(Items.carrot),
            new ItemStack(Items.potato),
            "blockMushroom");
        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.chicken_soup, 1, 1),
            new boolean[]{ModConfigurationItems.enableChickenSoup},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(Items.chicken),
            new ItemStack(Items.carrot),
            new ItemStack(Items.potato),
            "blockMushroom");

        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.beef_stew),
            new boolean[]{ModConfigurationItems.enableBeefStew},
            new ItemStack(Items.bowl),
            new ItemStack(Items.beef),
            new ItemStack(Items.carrot),
            new ItemStack(Items.potato),
            "blockMushroom");
        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.beef_stew, 1, 1),
            new boolean[]{ModConfigurationItems.enableBeefStew},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(Items.beef),
            new ItemStack(Items.carrot),
            new ItemStack(Items.potato),
            "blockMushroom");

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.pumpkin_porridge),
            new boolean[]{ModConfigurationItems.enablePumpkinPorridge},
            new ItemStack(Items.bowl),
            new ItemStack(Blocks.pumpkin));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.pumpkin_porridge, 1, 1),
            new boolean[]{ModConfigurationItems.enablePumpkinPorridge},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(Blocks.pumpkin));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.cactus_soup),
            new boolean[]{ModConfigurationItems.enableCactusSoup},
            new ItemStack(Items.bowl),
            new ItemStack(Blocks.cactus),
            new ItemStack(Blocks.cactus),
            new ItemStack(Blocks.cactus));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.cactus_soup, 1, 1),
            new boolean[]{ModConfigurationItems.enableCactusSoup},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(Blocks.cactus),
            new ItemStack(Blocks.cactus),
            new ItemStack(Blocks.cactus));

        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.bone_marrow_soup),
            new boolean[]{ModConfigurationItems.enableBoneMarrowSoup},
            new ItemStack(Items.bowl),
            new ItemStack(Items.bone),
            "blockMushroom");
        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.bone_marrow_soup, 1, 1),
            new boolean[]{ModConfigurationItems.enableBoneMarrowSoup},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(Items.bone),
            "blockMushroom");

        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.stewed_vegetables),
            new boolean[]{ModConfigurationItems.enableStewedVegetables},
            new ItemStack(Items.bowl),
            new ItemStack(Items.carrot),
            new ItemStack(Items.potato),
            "blockMushroom");
        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.stewed_vegetables, 1, 1),
            new boolean[]{ModConfigurationItems.enableStewedVegetables},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(Items.carrot),
            new ItemStack(Items.potato),
            "blockMushroom");

        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.potato_mushroom),
            new boolean[]{ModConfigurationItems.enablePotatoMushroom},
            new ItemStack(Items.bowl),
            new ItemStack(Items.potato),
            new ItemStack(Items.potato),
            "blockMushroom");
        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.potato_mushroom, 1, 1),
            new boolean[]{ModConfigurationItems.enablePotatoMushroom},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(Items.potato),
            new ItemStack(Items.potato),
            "blockMushroom");

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.golden_vegetables),
            new boolean[]{ModConfigurationItems.enableGoldenFoods},
            new ItemStack(Items.bowl),
            new ItemStack(Items.golden_carrot),
            new ItemStack(ModItems.golden_potato),
            new ItemStack(ModItems.golden_saltwort));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.golden_vegetables, 1, 1),
            new boolean[]{ModConfigurationItems.enableGoldenFoods},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(Items.golden_carrot),
            new ItemStack(ModItems.golden_potato),
            new ItemStack(ModItems.golden_saltwort));

        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.fish_soup),
            new boolean[]{ModConfigurationItems.enableFishSoup},
            new ItemStack(Items.bowl),
            "itemFish",
            new ItemStack(Items.carrot),
            new ItemStack(Items.potato));
        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.fish_soup, 1, 1),
            new boolean[]{ModConfigurationItems.enableFishSoup},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.bowl),
            "itemFish",
            new ItemStack(Items.carrot),
            new ItemStack(Items.potato));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.dandelion_salad),
            new boolean[]{ModConfigurationItems.enableOnion, ModConfigurationItems.enableDandelionSalad},
            new ItemStack(Items.bowl),
            new ItemStack(Blocks.tallgrass, 1,2),
            new ItemStack(Blocks.yellow_flower),
            new ItemStack(ModItems.onion));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.dandelion_salad, 1, 1),
            new boolean[]{ModConfigurationItems.enableOnion, ModConfigurationItems.enableDandelionSalad},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(Blocks.tallgrass, 1,2),
            new ItemStack(Blocks.yellow_flower),
            new ItemStack(ModItems.onion));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.wheat_sprouts),
            new boolean[]{ModConfigurationItems.enableWheatSprouts},
            new ItemStack(Items.bowl),
            new ItemStack(Items.wheat_seeds),
            new ItemStack(Items.wheat_seeds),
            new ItemStack(Items.wheat_seeds),
            new ItemStack(Items.wheat_seeds),
            new ItemStack(Items.wheat_seeds),
            new ItemStack(Items.wheat_seeds));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.wheat_sprouts, 1, 1),
            new boolean[]{ModConfigurationItems.enableWheatSprouts},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(Items.wheat_seeds),
            new ItemStack(Items.wheat_seeds),
            new ItemStack(Items.wheat_seeds),
            new ItemStack(Items.wheat_seeds),
            new ItemStack(Items.wheat_seeds),
            new ItemStack(Items.wheat_seeds));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.beetroot_salad),
            new boolean[]{beetroot != null, ModConfigurationModCompatibility.enableBeetrootSalad},
            new ItemStack(Items.bowl),
            new ItemStack(beetroot),
            new ItemStack(Items.carrot),
            new ItemStack(Items.potato));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.beetroot_salad, 1, 1),
            new boolean[]{beetroot != null, ModConfigurationModCompatibility.enableBeetrootSalad},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(beetroot),
            new ItemStack(Items.carrot),
            new ItemStack(Items.potato));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.dressed_herring),
            new boolean[]{beetroot != null, ModConfigurationItems.enableOnion, ModConfigurationModCompatibility.enableDressedHerring},
            new ItemStack(Items.bowl),
            new ItemStack(Items.fish),
            new ItemStack(ModItems.onion),
            new ItemStack(Items.carrot),
            new ItemStack(Items.potato),
            new ItemStack(beetroot),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.dressed_herring, 1, 1),
            new boolean[]{beetroot != null, ModConfigurationItems.enableOnion, ModConfigurationModCompatibility.enableDressedHerring},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(Items.fish),
            new ItemStack(ModItems.onion),
            new ItemStack(Items.carrot),
            new ItemStack(Items.potato),
            new ItemStack(beetroot),
            new ItemStack(Items.egg));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.saltwort_salad),
            new boolean[]{ModConfigurationItems.enableSaltwortSalad},
            new ItemStack(Items.bowl),
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.saltwort));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.golden_saltwort_salad),
            new boolean[]{ModConfigurationItems.enableSaltwortSalad},
            new ItemStack(Items.bowl),
            new ItemStack(ModItems.golden_saltwort),
            new ItemStack(ModItems.golden_saltwort),
            new ItemStack(ModItems.golden_saltwort),
            new ItemStack(ModItems.golden_saltwort),
            new ItemStack(ModItems.golden_saltwort),
            new ItemStack(ModItems.golden_saltwort));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.saltwort_cooked_porkchop),
            new boolean[]{ModConfigurationItems.enableSaltwortPorkchop},
            new ItemStack(Items.bowl),
            new ItemStack(ModItems.salt_cooked_porkchop),
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.saltwort));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.saltwort_honey_porkchop),
            new boolean[]{ModConfigurationItems.enableHoney, ModConfigurationItems.enableHoneyPorkchop, ModConfigurationItems.enableSaltwortHoneyPorkchop},
            new ItemStack(Items.bowl),
            new ItemStack(ModItems.honey_porkchop),
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.saltwort));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.saltwort_cooked_beef),
            new boolean[]{ModConfigurationItems.enableSaltwortBeef},
            new ItemStack(Items.bowl),
            new ItemStack(ModItems.salt_cooked_beef),
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.saltwort));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.saltwort_cooked_mutton),
            new boolean[]{ModConfigurationModCompatibility.enableSaltwortMutton},
            new ItemStack(Items.bowl),
            new ItemStack(ModItems.salt_cooked_mutton),
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.saltwort));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.saltwort_cooked_strider),
            new boolean[]{ModConfigurationItems.enableStrider, ModConfigurationItems.enableSaltwortStrider},
            new ItemStack(Items.bowl),
            new ItemStack(ModItems.strider, 1, 2),
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.saltwort));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.saltwort_cooked_haunch),
            new boolean[]{ModConfigurationItems.enableSaltwortHaunch},
            new ItemStack(Items.bowl),
            new ItemStack(ModItems.haunch, 1, 2),
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.saltwort));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.fruit_salad),
            new boolean[]{sweet_berries != null, ModConfigurationItems.enableFruitSalad},
            new ItemStack(Items.bowl),
            new ItemStack(Items.apple),
            new ItemStack(Items.melon),
            new ItemStack(sweet_berries));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.fruit_salad),
            new boolean[]{sweet_berries == null, ModConfigurationItems.enableFruitSalad},
            new ItemStack(Items.bowl),
            new ItemStack(Items.apple),
            new ItemStack(Items.melon),
            new ItemStack(Items.carrot));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.fruit_salad, 1, 1),
            new boolean[]{sweet_berries != null, ModConfigurationItems.enableFruitSalad},
            new ItemStack(ModItems.sugar_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(Items.apple),
            new ItemStack(Items.melon),
            new ItemStack(sweet_berries));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.fruit_salad, 1, 1),
            new boolean[]{sweet_berries == null, ModConfigurationItems.enableFruitSalad},
            new ItemStack(ModItems.sugar_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(Items.apple),
            new ItemStack(Items.melon),
            new ItemStack(Items.carrot));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.golden_fruit_salad),
            new boolean[]{sweet_berries != null, ModConfigurationItems.enableGoldenFoods},
            new ItemStack(Items.bowl),
            new ItemStack(Items.golden_apple, 1, 0),
            new ItemStack(ModItems.golden_berries, 1, 0),
            new ItemStack(Items.speckled_melon));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.golden_fruit_salad),
            new boolean[]{sweet_berries == null, ModConfigurationItems.enableGoldenFoods},
            new ItemStack(Items.bowl),
            new ItemStack(Items.golden_apple, 1, 0),
            new ItemStack(Items.golden_carrot),
            new ItemStack(Items.speckled_melon));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.golden_fruit_salad, 1, 1),
            new boolean[]{sweet_berries != null, ModConfigurationItems.enableGoldenFoods},
            new ItemStack(ModItems.sugar_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(Items.golden_apple, 1, 0),
            new ItemStack(ModItems.golden_berries, 1, 0),
            new ItemStack(Items.speckled_melon));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.golden_fruit_salad, 1, 1),
            new boolean[]{sweet_berries == null, ModConfigurationItems.enableGoldenFoods},
            new ItemStack(ModItems.sugar_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(Items.golden_apple, 1, 0),
            new ItemStack(Items.golden_carrot),
            new ItemStack(Items.speckled_melon));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.grated_carrot),
            new boolean[]{ModConfigurationItems.enableGratedCarrot},
            new ItemStack(Items.bowl),
            new ItemStack(Items.carrot),
            new ItemStack(Items.carrot),
            new ItemStack(Items.carrot));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.grated_carrot, 1, 1),
            new boolean[]{ModConfigurationItems.enableGratedCarrot},
            new ItemStack(ModItems.sugar_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(Items.carrot),
            new ItemStack(Items.carrot),
            new ItemStack(Items.carrot));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.melon_soup),
            new boolean[]{ModConfigurationItems.enableMelonSoup},
            new ItemStack(Items.bowl),
            new ItemStack(Items.melon),
            new ItemStack(Items.melon),
            new ItemStack(Items.melon));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.melon_soup, 1, 1),
            new boolean[]{ModConfigurationItems.enableMelonSoup},
            new ItemStack(ModItems.sugar_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(Items.melon),
            new ItemStack(Items.melon),
            new ItemStack(Items.melon));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.sweetberry_cookie, 4),
            new boolean[]{sweet_berries != null, ModConfigurationItems.enableDough, ModConfigurationModCompatibility.enableBerryCookie},
            new ItemStack(ModItems.dough),
            new ItemStack(sweet_berries));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.sweetberry_cookie, 4),
            new boolean[]{sweet_berries != null, !ModConfigurationItems.enableDough, ModConfigurationModCompatibility.enableBerryCookie},
            new ItemStack(Items.wheat),
            new ItemStack(Items.wheat),
            new ItemStack(sweet_berries));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.chorus_cookie, 4),
            new boolean[]{chorus_fruit != null, ModConfigurationItems.enableDough, ModConfigurationModCompatibility.enableChorusCookie},
            new ItemStack(ModItems.dough),
            new ItemStack(chorus_fruit));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.chorus_cookie, 4),
            new boolean[]{chorus_fruit != null, !ModConfigurationItems.enableDough, ModConfigurationModCompatibility.enableChorusCookie},
            new ItemStack(Items.wheat),
            new ItemStack(Items.wheat),
            new ItemStack(chorus_fruit));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.chocolate_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enableChocolatePie},
            new ItemStack(Items.dye, 1, 3),
            new ItemStack(Items.dye, 1, 3),
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.chocolate_pie),
            new boolean[]{!ModConfigurationItems.enableDough, ModConfigurationItems.enableChocolatePie},
            new ItemStack(Items.dye, 1, 3),
            new ItemStack(Items.dye, 1, 3),
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));

        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.birthday_pie),
            new boolean[]{ModConfigurationBlocks.enableEvaporator, ModConfigurationItems.enableDough, ModConfigurationItems.enableBirthdayPie},
            new ItemStack(Items.sugar),
            "itemMilk",
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.birthday_pie),
            new boolean[]{ModConfigurationBlocks.enableEvaporator, !ModConfigurationItems.enableDough, ModConfigurationItems.enableBirthdayPie},
            new ItemStack(Items.sugar),
            "itemMilk",
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.birthday_pie),
            new boolean[]{!ModConfigurationBlocks.enableEvaporator, ModConfigurationItems.enableDough, ModConfigurationItems.enableBirthdayPie},
            new ItemStack(Items.sugar),
            new ItemStack(Items.milk_bucket),
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.birthday_pie),
            new boolean[]{!ModConfigurationBlocks.enableEvaporator, !ModConfigurationItems.enableDough, ModConfigurationItems.enableBirthdayPie},
            new ItemStack(Items.sugar),
            new ItemStack(Items.milk_bucket),
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.apple_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enableApplePie},
            new ItemStack(Items.sugar),
            new ItemStack(Items.apple),
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.apple_pie),
            new boolean[]{!ModConfigurationItems.enableDough, ModConfigurationItems.enableApplePie},
            new ItemStack(Items.sugar),
            new ItemStack(Items.apple),
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.carrot_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enableCarrotPie},
            new ItemStack(Items.sugar),
            new ItemStack(Items.carrot),
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.carrot_pie),
            new boolean[]{!ModConfigurationItems.enableDough, ModConfigurationItems.enableCarrotPie},
            new ItemStack(Items.sugar),
            new ItemStack(Items.carrot),
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));

        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.mushroom_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enableMushroomPie},
            new ItemStack(ModItems.salt),
            "blockMushroom",
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.mushroom_pie),
            new boolean[]{!ModConfigurationItems.enableDough, ModConfigurationItems.enableMushroomPie},
            new ItemStack(ModItems.salt),
            "blockMushroom",
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.potato_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enablePotatoPie},
            new ItemStack(ModItems.salt),
            new ItemStack(Items.potato),
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.potato_pie),
            new boolean[]{!ModConfigurationItems.enableDough, ModConfigurationItems.enablePotatoPie},
            new ItemStack(ModItems.salt),
            new ItemStack(Items.potato),
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.onion_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enableOnion, ModConfigurationItems.enableOnionPie},
            new ItemStack(ModItems.salt),
            new ItemStack(ModItems.onion),
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.onion_pie),
            new boolean[]{!ModConfigurationItems.enableDough, ModConfigurationItems.enableOnion, ModConfigurationItems.enableOnionPie},
            new ItemStack(ModItems.salt),
            new ItemStack(ModItems.onion),
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));

        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.shepherds_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enableShepherdsPie},
            new ItemStack(ModItems.salt),
            "itemRedmeat",
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.shepherds_pie),
            new boolean[]{!ModConfigurationItems.enableDough, ModConfigurationItems.enableShepherdsPie},
            new ItemStack(ModItems.salt),
            "itemRedmeat",
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.cod_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enableCodPie},
            new ItemStack(ModItems.salt),
            new ItemStack(Items.fish),
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.cod_pie),
            new boolean[]{!ModConfigurationItems.enableDough, ModConfigurationItems.enableCodPie},
            new ItemStack(ModItems.salt),
            new ItemStack(Items.fish),
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.salmon_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enableSalmonPie},
            new ItemStack(ModItems.salt),
            new ItemStack(Items.fish, 1, 1),
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.salmon_pie),
            new boolean[]{!ModConfigurationItems.enableDough, ModConfigurationItems.enableSalmonPie},
            new ItemStack(ModItems.salt),
            new ItemStack(Items.fish, 1, 1),
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.tropical_fish_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enableTropicalFishPie},
            new ItemStack(ModItems.salt),
            new ItemStack(Items.fish, 1, 2),
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.tropical_fish_pie),
            new boolean[]{!ModConfigurationItems.enableDough, ModConfigurationItems.enableTropicalFishPie},
            new ItemStack(ModItems.salt),
            new ItemStack(Items.fish, 1, 2),
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.tailor_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enableTailor, ModConfigurationItems.enableTailorPie},
            new ItemStack(ModItems.salt),
            new ItemStack(ModItems.tailor),
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.tailor_pie),
            new boolean[]{!ModConfigurationItems.enableDough, ModConfigurationItems.enableTailor, ModConfigurationItems.enableTailorPie},
            new ItemStack(ModItems.salt),
            new ItemStack(ModItems.tailor),
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.calamari_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enableCalamari, ModConfigurationItems.enableCalamariPie},
            new ItemStack(ModItems.salt),
            new ItemStack(ModItems.calamari),
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.calamari_pie),
            new boolean[]{!ModConfigurationItems.enableDough, ModConfigurationItems.enableCalamari, ModConfigurationItems.enableCalamariPie},
            new ItemStack(ModItems.salt),
            new ItemStack(ModItems.calamari),
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.saltwort_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enableSaltwortPie},
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.saltwort_pie),
            new boolean[]{!ModConfigurationItems.enableDough, ModConfigurationItems.enableSaltwortPie},
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.saltwort),
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.tunneler_concoction),
            new boolean[]{ModConfigurationItems.enableTunnelersConcoction},
            new ItemStack(ModItems.horn),
            new ItemStack(ModItems.fizzy_drink));
    }
}
