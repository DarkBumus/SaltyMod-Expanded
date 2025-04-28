package darkbum.saltymod.init.recipes;

import darkbum.saltymod.api.ConditionalRegistrar;
import darkbum.saltymod.init.ModExternalItemLoader;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import cpw.mods.fml.common.Loader;
import darkbum.saltymod.configuration.configs.ModConfigurationBlocks;
import darkbum.saltymod.configuration.configs.ModConfigurationItems;
import darkbum.saltymod.configuration.configs.ModConfigurationModCompatibility;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;

public class ModExternalRecipes {

    public static void init() {

        Item honeycombItem = ModExternalItemLoader.harvestcraftItems.get("honeycombItem");
        Item royaljellyItem = ModExternalItemLoader.harvestcraftItems.get("royaljellyItem");

        Item beeCombs = ModExternalItemLoader.forestryItems.get("beeCombs");

        Item honeyCombFilled = ModExternalItemLoader.growthcraftItems.get("honeyCombFilled");

        Item StriderFlankRaw = ModExternalItemLoader.netherliciousItems.get("StriderFlankRaw");
        Item StriderFlankCooked = ModExternalItemLoader.netherliciousItems.get("StriderFlankCooked");

        Item suspicious_stew = ModExternalItemLoader.etFuturumItems.get("suspicious_stew");
        Item mutton_raw = ModExternalItemLoader.etFuturumItems.get("mutton_raw");
        Item mutton_cooked = ModExternalItemLoader.etFuturumItems.get("mutton_cooked");
        Item rabbit_raw = ModExternalItemLoader.etFuturumItems.get("rabbit_raw");
        Item rabbit_cooked = ModExternalItemLoader.etFuturumItems.get("rabbit_cooked");
        Item rabbit_stew = ModExternalItemLoader.etFuturumItems.get("rabbit_stew");
        Item beetroot = ModExternalItemLoader.etFuturumItems.get("beetroot");
        Item beetroot_seeds = ModExternalItemLoader.etFuturumItems.get("beetroot_seeds");
        Item beetroot_soup = ModExternalItemLoader.etFuturumItems.get("beetroot_soup");
        Item chorus_fruit = ModExternalItemLoader.etFuturumItems.get("chorus_fruit");
        Item sweet_berries = ModExternalItemLoader.etFuturumItems.get("sweet_berries");
        Item dye = ModExternalItemLoader.etFuturumItems.get("dye");
        Block honeycomb_block = ModExternalItemLoader.etFuturumBlocks.get("honeycomb_block");
        Block beehive = ModExternalItemLoader.etFuturumBlocks.get("beehive");

        Block campfire = ModExternalItemLoader.campfireBackportBlocks.get("campfire");

        Item venisonCooked = ModExternalItemLoader.twilightForestItems.get("item.venisonCooked");
        Item meefSteak = ModExternalItemLoader.twilightForestItems.get("item.meefSteak");
        Item meefStroganoff = ModExternalItemLoader.twilightForestItems.get("item.meefStroganoff");
        Item hydraChop = ModExternalItemLoader.twilightForestItems.get("item.hydraChop");
        Item mushgloom = ModExternalItemLoader.twilightForestItems.get("tile.TFPlant");

        Item food = ModExternalItemLoader.biomesOPlentyItems.get("food");


        ConditionalRegistrar.registerOre("itemSweetener", honeycombItem, honeycombItem != null);
        ConditionalRegistrar.registerOre("itemHoney", honeycombItem, honeycombItem != null);
        ConditionalRegistrar.registerOre("itemRoyaljelly", royaljellyItem, royaljellyItem != null);

        ConditionalRegistrar.registerOre("itemSweetener", beeCombs, beeCombs != null);
        ConditionalRegistrar.registerOre("itemHoney", beeCombs, beeCombs != null);

        ConditionalRegistrar.registerOre("itemSweetener", honeyCombFilled, honeyCombFilled != null);
        ConditionalRegistrar.registerOre("itemHoney", honeyCombFilled, honeyCombFilled != null);

        ConditionalRegistrar.registerOre("itemFood", StriderFlankRaw, StriderFlankRaw != null);
        ConditionalRegistrar.registerOre("itemRedmeat", StriderFlankCooked, StriderFlankCooked != null);
        ConditionalRegistrar.registerOre("itemFood", StriderFlankCooked, StriderFlankCooked != null);

        ConditionalRegistrar.registerOre("itemFood", new ItemStack(suspicious_stew, OreDictionary.WILDCARD_VALUE), suspicious_stew != null);
        ConditionalRegistrar.registerOre("itemFood", mutton_raw, mutton_raw != null);
        ConditionalRegistrar.registerOre("itemRedmeat", mutton_cooked, mutton_cooked != null);
        ConditionalRegistrar.registerOre("itemFood", mutton_cooked, mutton_cooked != null);
        ConditionalRegistrar.registerOre("itemFood", rabbit_raw, rabbit_raw != null);
        ConditionalRegistrar.registerOre("itemFood", rabbit_cooked, rabbit_cooked != null);
        ConditionalRegistrar.registerOre("itemFood", rabbit_stew, rabbit_stew != null);
        ConditionalRegistrar.registerOre("itemFood", beetroot, beetroot != null);
        ConditionalRegistrar.registerOre("itemFood", beetroot_soup, beetroot_soup != null);
        ConditionalRegistrar.registerOre("itemFood", chorus_fruit, chorus_fruit != null);
        ConditionalRegistrar.registerOre("itemFood", sweet_berries, sweet_berries != null);

        ConditionalRegistrar.registerOre("itemSweetener", new ItemStack(food, 1, 9), food != null);
        ConditionalRegistrar.registerOre("itemHoney", new ItemStack(food, 1, 9), food != null);


        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.strider, 1, 2),
            new boolean[]{StriderFlankCooked != null},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(StriderFlankCooked));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.strider, 1, 2),
            new boolean[]{Loader.isModLoaded("etfuturum"), !Loader.isModLoaded("netherlicious")},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(ModItems.strider, 1, 1));
        ConditionalRegistrar.addSmelting(new ItemStack(ModItems.strider, 1, 0),
            new ItemStack(ModItems.strider, 1, 1),
            0.35F,
            Loader.isModLoaded("etfuturum"), !Loader.isModLoaded("netherlicious"));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.salt_cooked_rabbit),
            new boolean[]{rabbit_cooked != null},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(rabbit_cooked));

        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(rabbit_stew),
            new boolean[]{rabbit_stew != null, rabbit_cooked != null},
            new ItemStack(Items.bowl),
            new ItemStack(rabbit_cooked),
            new ItemStack(Items.carrot),
            new ItemStack(Items.baked_potato),
            "blockMushroom");

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.salt_cooked_mutton),
            new boolean[]{mutton_cooked != null},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(mutton_cooked));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(beetroot, 9),
            new boolean[]{beetroot != null, ModConfigurationBlocks.enableStorageBlocks},
            new ItemStack(ModBlocks.storage_crate, 1, 4));
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.storage_crate, 1, 4),
            new Object[]{"xxx", "xxx", "xxx",
                'x', beetroot},
            beetroot != null, ModConfigurationBlocks.enableStorageBlocks);
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.salt_beetroot),
            new boolean[]{beetroot != null},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(beetroot));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.salt_beetroot_soup),
            new boolean[]{beetroot != null},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(beetroot),
            new ItemStack(beetroot),
            new ItemStack(beetroot),
            new ItemStack(beetroot),
            new ItemStack(beetroot),
            new ItemStack(beetroot));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.beetroot_salad),
            new boolean[]{beetroot != null},
            new ItemStack(Items.bowl),
            new ItemStack(Items.carrot),
            new ItemStack(Items.potato),
            new ItemStack(beetroot));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.beetroot_salad, 1, 1),
            new boolean[]{beetroot != null},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(Items.carrot),
            new ItemStack(Items.potato),
            new ItemStack(beetroot));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.dressed_herring),
            new boolean[]{beetroot != null, ModConfigurationItems.enableOnion},
            new ItemStack(Items.bowl),
            new ItemStack(Items.carrot),
            new ItemStack(Items.potato),
            new ItemStack(beetroot),
            new ItemStack(Items.egg),
            new ItemStack(Items.fish),
            new ItemStack(ModItems.onion));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.dressed_herring, 1, 1),
            new boolean[]{beetroot != null, ModConfigurationItems.enableOnion},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(Items.carrot),
            new ItemStack(Items.potato),
            new ItemStack(beetroot),
            new ItemStack(Items.egg),
            new ItemStack(Items.fish),
            new ItemStack(ModItems.onion));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.pickled_beetroot),
            new boolean[]{beetroot != null},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.potionitem),
            new ItemStack(beetroot),
            new ItemStack(beetroot));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(beetroot_seeds, 9),
            new boolean[]{beetroot_seeds != null, ModConfigurationBlocks.enableStorageBlocks},
            new ItemStack(ModBlocks.storage_sack, 1, 4));
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.storage_sack, 1, 4),
            new Object[]{"xxx", "xxx", "xxx",
                'x', beetroot_seeds},
            beetroot_seeds != null, ModConfigurationBlocks.enableStorageBlocks);

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.salt_beetroot_soup),
            new boolean[]{beetroot_soup != null},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(beetroot_soup));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(beetroot_soup),
            new boolean[]{beetroot != null, beetroot_soup != null},
            new ItemStack(Items.bowl),
            new ItemStack(beetroot),
            new ItemStack(beetroot),
            new ItemStack(beetroot),
            new ItemStack(beetroot),
            new ItemStack(beetroot),
            new ItemStack(beetroot));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.chocolate_berries),
            new boolean[]{sweet_berries != null},
            new ItemStack(Items.dye, 1, 3),
            new ItemStack(sweet_berries));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.sweetberry_pie),
            new boolean[]{sweet_berries != null},
            new ItemStack(Items.sugar),
            new ItemStack(sweet_berries),
            new ItemStack(sweet_berries),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.sugar_berries),
            new boolean[]{sweet_berries != null},
            new ItemStack(ModItems.sugar_pinch),
            new ItemStack(sweet_berries));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.fruit_salad),
            new boolean[]{sweet_berries != null},
            new ItemStack(Items.bowl),
            new ItemStack(Items.apple),
            new ItemStack(sweet_berries),
            new ItemStack(Items.melon));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.fruit_salad),
            new boolean[]{sweet_berries == null},
            new ItemStack(Items.bowl),
            new ItemStack(Items.apple),
            new ItemStack(Items.carrot),
            new ItemStack(Items.melon));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.fruit_salad, 1, 1),
            new boolean[]{sweet_berries != null},
            new ItemStack(ModItems.sugar_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(Items.apple),
            new ItemStack(sweet_berries),
            new ItemStack(Items.melon));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.fruit_salad, 1, 1),
            new boolean[]{sweet_berries == null},
            new ItemStack(ModItems.sugar_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(Items.apple),
            new ItemStack(Items.carrot),
            new ItemStack(Items.melon));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.golden_fruit_salad),
            new boolean[]{sweet_berries != null},
            new ItemStack(Items.bowl),
            new ItemStack(Items.golden_apple),
            new ItemStack(ModItems.golden_berries),
            new ItemStack(Items.speckled_melon));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.golden_fruit_salad),
            new boolean[]{sweet_berries == null},
            new ItemStack(Items.bowl),
            new ItemStack(Items.golden_apple),
            new ItemStack(Items.golden_carrot),
            new ItemStack(Items.speckled_melon));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.golden_fruit_salad, 1, 1),
            new boolean[]{sweet_berries != null},
            new ItemStack(ModItems.sugar_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(Items.golden_apple),
            new ItemStack(ModItems.golden_berries),
            new ItemStack(Items.speckled_melon));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.golden_fruit_salad, 1, 1),
            new boolean[]{sweet_berries == null},
            new ItemStack(ModItems.sugar_pinch),
            new ItemStack(Items.bowl),
            new ItemStack(Items.golden_apple),
            new ItemStack(Items.golden_carrot),
            new ItemStack(Items.speckled_melon));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.berry_preserves),
            new boolean[]{sweet_berries != null},
            new ItemStack(ModItems.sugar_pinch),
            new ItemStack(Items.potionitem),
            new ItemStack(sweet_berries),
            new ItemStack(sweet_berries));
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModItems.golden_berries),
            new Object[]{"xxx", "xyx", "xxx",
                'x', Items.gold_nugget,
                'y', sweet_berries},
            sweet_berries != null);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModItems.golden_berries, 1, 1),
            new Object[]{"xxx", "xyx", "xxx",
                'x', Blocks.gold_block,
                'y', sweet_berries},
            sweet_berries != null);
        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.honey_berries),
            new boolean[]{sweet_berries != null, ModConfigurationItems.enableHoney},
            "itemHoney",
            new ItemStack(sweet_berries));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(dye, 1, 0),
            new boolean[]{dye != null},
            new ItemStack(ModBlocks.salt_flower, 1, 0));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(Items.dye, 1, 15),
            new boolean[]{dye == null},
            new ItemStack(ModBlocks.salt_flower, 1, 0));

        ConditionalRegistrar.addShapedRecipe(new ItemStack(honeycomb_block),
            new Object[]{"xx", "xx",
                'x', new ItemStack(ModItems.waxcomb)},
            honeycomb_block != null, ModConfigurationModCompatibility.enableEFRHoneyCompatibility);
        ConditionalRegistrar.addShapedOreRecipe(new ItemStack(beehive),
            new Object[]{"xxx", "yyy", "xxx",
                'x', "plankWood",
                'y', new ItemStack(ModItems.waxcomb)},
            beehive != null, ModConfigurationModCompatibility.enableEFRHoneyCompatibility);

        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.stove),
            new Object[]{"xxx", "y y", "yzy",
                'x', new ItemStack(Items.iron_ingot),
                'y', new ItemStack(Blocks.brick_block),
                'z', new ItemStack(campfire)},
            ModConfigurationBlocks.enableMachines, Loader.isModLoaded("campfirebackport"));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.tf_salt_cooked_venison),
            new boolean[]{venisonCooked != null},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(venisonCooked));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.tf_salt_meef_steak),
            new boolean[]{meefSteak != null},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(meefSteak));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.tf_salt_meef_stroganoff),
            new boolean[]{meefStroganoff != null},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(meefStroganoff));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.tf_salt_hydra_chop),
            new boolean[]{hydraChop != null},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(hydraChop));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.tf_pickled_mushgloom),
            new boolean[]{mushgloom != null},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.potionitem),
            new ItemStack(mushgloom, 1, 9),
            new ItemStack(mushgloom, 1, 9));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.bop_salt_shroom_powder),
            new boolean[]{food != null},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(food, 1, 1));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.bop_sugar_fruit_salad),
            new boolean[]{food != null},
            new ItemStack(ModItems.sugar_pinch),
            new ItemStack(food, 1, 4));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.bop_salt_veggie_salad),
            new boolean[]{food != null},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(food, 1, 5));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.bop_salt_shroom_salad),
            new boolean[]{food != null},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(food, 1, 6));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.bop_salt_rice_bowl),
            new boolean[]{food != null},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(food, 1, 13));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.bop_pickled_turnip),
            new boolean[]{food != null},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.potionitem),
            new ItemStack(food, 1, 11),
            new ItemStack(food, 1, 11));
    }
}
