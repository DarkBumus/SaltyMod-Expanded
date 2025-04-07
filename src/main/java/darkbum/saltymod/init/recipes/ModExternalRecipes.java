package darkbum.saltymod.init.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltymod.configuration.configs.ModConfigurationBlocks;
import darkbum.saltymod.configuration.configs.ModConfigurationItems;
import darkbum.saltymod.configuration.configs.ModConfigurationModCompatibility;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;

public class ModExternalRecipes {

    public static void init() {

        if (Loader.isModLoaded("harvestcraft")) {
            Item honeycombItem = GameRegistry.findItem("harvestcraft", "honeycombItem");
            Item royaljellyItem = GameRegistry.findItem("harvestcraft", "royaljellyItem");
            if (honeycombItem != null) {
                OreDictionary.registerOre("itemSweetener", honeycombItem);
                OreDictionary.registerOre("itemHoney", honeycombItem);
            }
            if (royaljellyItem != null) {
                OreDictionary.registerOre("itemRoyaljelly", royaljellyItem);
            }
        }

        if (Loader.isModLoaded("Forestry")) {
            Item beeCombs = GameRegistry.findItem("Forestry", "beeCombs");
            if (beeCombs != null) {
                OreDictionary.registerOre("itemSweetener", beeCombs);
                OreDictionary.registerOre("itemHoney", beeCombs);
            }
        }

        if (Loader.isModLoaded("Growthcraft")) {
            Item honeyCombFilled = GameRegistry.findItem("Growthcraft|Bees", "grc.honeyCombFilled");
            if (honeyCombFilled != null) {
                OreDictionary.registerOre("itemSweetener", honeyCombFilled);
                OreDictionary.registerOre("itemHoney", honeyCombFilled);
            }
        }

        if (Loader.isModLoaded("netherlicious")) {
            Item StriderFlankCooked = GameRegistry.findItem("netherlicious", "StriderFlankCooked");
            Item StriderFlankRaw = GameRegistry.findItem("netherlicious", "StriderFlankRaw");
            if ((StriderFlankRaw != null) && (StriderFlankCooked != null)) {

                OreDictionary.registerOre("itemRedmeat", StriderFlankCooked);

                OreDictionary.registerOre("itemFood", StriderFlankRaw);
                OreDictionary.registerOre("itemFood", StriderFlankCooked);

                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.salt_cooked_strider),
                    new ItemStack(ModItems.salt_pinch),
                    new ItemStack(StriderFlankCooked));
            }
        }

        if (Loader.isModLoaded("etfuturum") && !Loader.isModLoaded("netherlicious")) {
            GameRegistry.addShapelessRecipe(
                new ItemStack(ModItems.salt_cooked_strider),
                new ItemStack(ModItems.salt_pinch),
                new ItemStack(ModItems.cooked_strider));

            GameRegistry.addSmelting(new ItemStack(ModItems.strider), new ItemStack(ModItems.cooked_strider), 0.35F);
        }

        if (Loader.isModLoaded("etfuturum")) {
            Item suspicious_stew = GameRegistry.findItem("etfuturum", "suspicious_stew");
            Item mutton_raw = GameRegistry.findItem("etfuturum", "mutton_raw");
            Item mutton_cooked = GameRegistry.findItem("etfuturum", "mutton_cooked");
            Item rabbit_raw = GameRegistry.findItem("etfuturum", "rabbit_raw");
            Item rabbit_cooked = GameRegistry.findItem("etfuturum", "rabbit_cooked");
            Item rabbit_stew = GameRegistry.findItem("etfuturum", "rabbit_stew");
            Item beetroot = GameRegistry.findItem("etfuturum", "beetroot");
            Item beetroot_seeds = GameRegistry.findItem("etfuturum", "beetroot_seeds");
            Item beetroot_soup = GameRegistry.findItem("etfuturum", "beetroot_soup");
            Item chorus_fruit = GameRegistry.findItem("etfuturum", "chorus_fruit");
            Item sweet_berries = GameRegistry.findItem("etfuturum", "sweet_berries");
            Item dye = GameRegistry.findItem("etfuturum", "dye");
            if ((suspicious_stew != null) && (mutton_raw != null)
                && (mutton_cooked != null)
                && (rabbit_raw != null)
                && (rabbit_cooked != null)
                && (rabbit_stew != null)
                && (beetroot != null)
                && (beetroot_seeds != null)
                && (beetroot_soup != null)
                && (chorus_fruit != null)
                && (sweet_berries != null)
                && (dye != null)) {

                OreDictionary.registerOre("itemRedmeat", mutton_cooked);

                OreDictionary.registerOre("itemFood", new ItemStack(suspicious_stew, OreDictionary.WILDCARD_VALUE));
                OreDictionary.registerOre("itemFood", mutton_raw);
                OreDictionary.registerOre("itemFood", mutton_cooked);
                OreDictionary.registerOre("itemFood", rabbit_raw);
                OreDictionary.registerOre("itemFood", rabbit_cooked);
                OreDictionary.registerOre("itemFood", rabbit_stew);
                OreDictionary.registerOre("itemFood", beetroot);
                OreDictionary.registerOre("itemFood", beetroot_soup);
                OreDictionary.registerOre("itemFood", chorus_fruit);
                OreDictionary.registerOre("itemFood", sweet_berries);

                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.salt_cooked_mutton),
                    new ItemStack(ModItems.salt_pinch),
                    new ItemStack(mutton_cooked));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.salt_cooked_rabbit),
                    new ItemStack(ModItems.salt_pinch),
                    new ItemStack(rabbit_cooked));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.salt_rabbit_stew),
                    new ItemStack(ModItems.salt_pinch),
                    new ItemStack(rabbit_stew));
                if (ModConfigurationBlocks.enableStorageBlocks) {
                    GameRegistry
                        .addShapelessRecipe(new ItemStack(beetroot, 9), new ItemStack(ModBlocks.storage_crate, 1, 4));
                }
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.salt_beetroot),
                    new ItemStack(ModItems.salt_pinch),
                    new ItemStack(beetroot));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.salt_beetroot_soup),
                    new ItemStack(ModItems.salt_pinch),
                    new ItemStack(Items.bowl),
                    new ItemStack(beetroot),
                    new ItemStack(beetroot),
                    new ItemStack(beetroot),
                    new ItemStack(beetroot),
                    new ItemStack(beetroot),
                    new ItemStack(beetroot));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.beetroot_salad),
                    new ItemStack(Items.bowl),
                    new ItemStack(Items.carrot),
                    new ItemStack(Items.potato),
                    new ItemStack(beetroot));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.salt_beetroot_salad),
                    new ItemStack(ModItems.salt_pinch),
                    new ItemStack(Items.bowl),
                    new ItemStack(Items.carrot),
                    new ItemStack(Items.potato),
                    new ItemStack(beetroot));
                if (ModConfigurationItems.enableOnion) {
                    GameRegistry.addShapelessRecipe(
                        new ItemStack(ModItems.dressed_herring),
                        new ItemStack(Items.bowl),
                        new ItemStack(Items.carrot),
                        new ItemStack(Items.potato),
                        new ItemStack(beetroot),
                        new ItemStack(Items.egg),
                        new ItemStack(Items.fish),
                        new ItemStack(ModItems.onion));
                    GameRegistry.addShapelessRecipe(
                        new ItemStack(ModItems.salt_dressed_herring),
                        new ItemStack(ModItems.salt_pinch),
                        new ItemStack(Items.bowl),
                        new ItemStack(Items.carrot),
                        new ItemStack(Items.potato),
                        new ItemStack(beetroot),
                        new ItemStack(Items.egg),
                        new ItemStack(Items.fish),
                        new ItemStack(ModItems.onion));
                }
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.pickled_beetroot),
                    new ItemStack(ModItems.salt_pinch),
                    new ItemStack(Items.potionitem),
                    new ItemStack(beetroot),
                    new ItemStack(beetroot));
                if (ModConfigurationBlocks.enableStorageBlocks) {
                    GameRegistry.addShapelessRecipe(
                        new ItemStack(beetroot_seeds, 9),
                        new ItemStack(ModBlocks.storage_sack, 1, 4));
                }
                GameRegistry.addShapelessRecipe(
                    new ItemStack(beetroot_soup),
                    new ItemStack(Items.bowl),
                    new ItemStack(beetroot),
                    new ItemStack(beetroot),
                    new ItemStack(beetroot),
                    new ItemStack(beetroot),
                    new ItemStack(beetroot),
                    new ItemStack(beetroot));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.salt_beetroot_soup),
                    new ItemStack(ModItems.salt_pinch),
                    new ItemStack(beetroot_soup));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.chocolate_berries),
                    new ItemStack(Items.dye, 1, 3),
                    new ItemStack(sweet_berries));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.sweetberry_pie),
                    new ItemStack(Items.sugar),
                    new ItemStack(sweet_berries),
                    new ItemStack(sweet_berries),
                    new ItemStack(Items.egg));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.sugar_berries),
                    new ItemStack(ModItems.sugar_pinch),
                    new ItemStack(sweet_berries));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.fruit_salad),
                    new ItemStack(Items.bowl),
                    new ItemStack(Items.apple),
                    new ItemStack(sweet_berries),
                    new ItemStack(Items.melon));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.sugar_fruit_salad),
                    new ItemStack(ModItems.sugar_pinch),
                    new ItemStack(Items.bowl),
                    new ItemStack(Items.apple),
                    new ItemStack(sweet_berries),
                    new ItemStack(Items.melon));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.golden_fruit_salad),
                    new ItemStack(Items.bowl),
                    new ItemStack(Items.golden_apple),
                    new ItemStack(ModItems.golden_berries),
                    new ItemStack(Items.speckled_melon));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.sugar_golden_fruit_salad),
                    new ItemStack(ModItems.sugar_pinch),
                    new ItemStack(Items.bowl),
                    new ItemStack(Items.golden_apple),
                    new ItemStack(ModItems.golden_berries),
                    new ItemStack(Items.speckled_melon));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.berry_preserves),
                    new ItemStack(ModItems.sugar_pinch),
                    new ItemStack(Items.potionitem),
                    new ItemStack(sweet_berries),
                    new ItemStack(sweet_berries));
                GameRegistry.addShapelessRecipe(new ItemStack(dye, 1, 0), new ItemStack(ModBlocks.salt_flower, 1, 0));

                if (ModConfigurationBlocks.enableStorageBlocks) {
                    GameRegistry.addRecipe(
                        new ItemStack(ModBlocks.storage_crate, 1, 4),
                        "xxx",
                        "xxx",
                        "xxx",
                        'x',
                        new ItemStack(beetroot));
                    GameRegistry.addRecipe(
                        new ItemStack(ModBlocks.storage_sack, 1, 4),
                        "xxx",
                        "xxx",
                        "xxx",
                        'x',
                        new ItemStack(beetroot_seeds));
                }
                GameRegistry.addRecipe(
                    new ItemStack(ModItems.golden_berries),
                    "xxx",
                    "xyx",
                    "xxx",
                    'x',
                    Items.gold_nugget,
                    'y',
                    new ItemStack(sweet_berries));
                GameRegistry.addRecipe(
                    new ItemStack(ModItems.golden_berries, 1, 1),
                    "xxx",
                    "xyx",
                    "xxx",
                    'x',
                    Blocks.gold_block,
                    'y',
                    new ItemStack(sweet_berries));

                GameRegistry.addRecipe(
                    new ShapelessOreRecipe(
                        new ItemStack(ModItems.salt_rabbit_stew),
                        new ItemStack(ModItems.salt_pinch),
                        new ItemStack(Items.bowl),
                        new ItemStack(rabbit_cooked),
                        new ItemStack(Items.carrot),
                        new ItemStack(Items.baked_potato),
                        "blockMushroom"));
                GameRegistry.addRecipe(
                    new ShapelessOreRecipe(
                        new ItemStack(rabbit_stew),
                        new ItemStack(Items.bowl),
                        new ItemStack(rabbit_cooked),
                        new ItemStack(Items.carrot),
                        new ItemStack(Items.baked_potato),
                        "blockMushroom"));
                if (ModConfigurationItems.enableHoney) {
                    GameRegistry.addRecipe(
                        new ShapelessOreRecipe(
                            new ItemStack(ModItems.honey_berries),
                            "itemHoney",
                            new ItemStack(sweet_berries)));
                }
            } else {
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.fruit_salad),
                    new ItemStack(Items.bowl),
                    new ItemStack(Items.apple),
                    new ItemStack(Items.carrot),
                    new ItemStack(Items.melon));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.sugar_fruit_salad),
                    new ItemStack(ModItems.sugar_pinch),
                    new ItemStack(Items.bowl),
                    new ItemStack(Items.apple),
                    new ItemStack(Items.carrot),
                    new ItemStack(Items.melon));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.golden_fruit_salad),
                    new ItemStack(Items.bowl),
                    new ItemStack(Items.golden_apple),
                    new ItemStack(Items.golden_carrot),
                    new ItemStack(Items.speckled_melon));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.sugar_golden_fruit_salad),
                    new ItemStack(ModItems.sugar_pinch),
                    new ItemStack(Items.bowl),
                    new ItemStack(Items.golden_apple),
                    new ItemStack(Items.golden_carrot),
                    new ItemStack(Items.speckled_melon));
                GameRegistry
                    .addShapelessRecipe(new ItemStack(Items.dye, 1, 15), new ItemStack(ModBlocks.salt_flower, 0));
            }
        }

        if (Loader.isModLoaded("TwilightForest")) {
            Item venisonCooked = GameRegistry.findItem("TwilightForest", "item.venisonCooked");
            Item meefSteak = GameRegistry.findItem("TwilightForest", "item.meefSteak");
            Item meefStroganoff = GameRegistry.findItem("TwilightForest", "item.meefStroganoff");
            Item hydraChop = GameRegistry.findItem("TwilightForest", "item.hydraChop");
            Item mushgloom = GameRegistry.findItem("TwilightForest", "tile.TFPlant");
            if ((venisonCooked != null) && (meefSteak != null)
                && (meefStroganoff != null)
                && (hydraChop != null)
                && (mushgloom != null)) {

                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.tf_salt_cooked_venison),
                    new ItemStack(ModItems.salt_pinch),
                    new ItemStack(venisonCooked));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.tf_salt_meef_steak),
                    new ItemStack(ModItems.salt_pinch),
                    new ItemStack(meefSteak));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.tf_salt_meef_stroganoff),
                    new ItemStack(ModItems.salt_pinch),
                    new ItemStack(meefStroganoff));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.tf_salt_hydra_chop),
                    new ItemStack(ModItems.salt_pinch),
                    new ItemStack(hydraChop));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.tf_pickled_mushgloom),
                    new ItemStack(ModItems.salt_pinch),
                    new ItemStack(Items.potionitem),
                    new ItemStack(mushgloom, 1, 9),
                    new ItemStack(mushgloom, 1, 9));

            }
        }

        if (Loader.isModLoaded("BiomesOPlenty")) {
            Item food = GameRegistry.findItem("BiomesOPlenty", "food");
            if (food != null) {
                OreDictionary.registerOre("itemSweetener", new ItemStack(food, 1, 9));
                OreDictionary.registerOre("itemHoney", new ItemStack(food, 1, 9));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.bop_salt_shroom_powder),
                    new ItemStack(ModItems.salt_pinch),
                    new ItemStack(food, 1, 1));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.bop_sugar_fruit_salad),
                    new ItemStack(ModItems.sugar_pinch),
                    new ItemStack(food, 1, 4));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.bop_salt_veggie_salad),
                    new ItemStack(ModItems.salt_pinch),
                    new ItemStack(food, 1, 5));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.bop_salt_shroom_salad),
                    new ItemStack(ModItems.salt_pinch),
                    new ItemStack(food, 1, 6));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.bop_salt_rice_bowl),
                    new ItemStack(ModItems.salt_pinch),
                    new ItemStack(food, 1, 13));
                GameRegistry.addShapelessRecipe(
                    new ItemStack(ModItems.bop_pickled_turnip),
                    new ItemStack(ModItems.salt_pinch),
                    new ItemStack(Items.potionitem),
                    new ItemStack(food, 1, 11),
                    new ItemStack(food, 1, 11));
            }
        }
    }
}
