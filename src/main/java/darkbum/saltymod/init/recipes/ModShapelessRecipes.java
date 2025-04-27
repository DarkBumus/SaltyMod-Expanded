package darkbum.saltymod.init.recipes;

import darkbum.saltymod.api.ConditionalRegistrar;
import darkbum.saltymod.configuration.configs.ModConfigurationVanillaChanges;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltymod.configuration.configs.ModConfigurationBlocks;
import darkbum.saltymod.configuration.configs.ModConfigurationItems;
import darkbum.saltymod.configuration.configs.ModConfigurationModCompatibility;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;

public class ModShapelessRecipes {

    public static void init() {
        // Salty Food Rules: 1. Salt/Sugar Pinch, 2. Ingredient
        // Bowl Rules: 1. Salt/Sugar Pinch, 2. Bowl, 3. Ingredients
        // (Apple-Carrot-Melon-Potato-Mushroom-Fish-Seeds/Saltwort-Dandelion-Allium)
        // Honeyed Food Rules: 1. Honey, 2. Food
        // Chocolate Food Rules: 1. Cocoa Beans, 2. Food
        // Pie Rules: 1. Salt/Sugar Pinch, 2. Ingredients, 3. Dough, 4. Egg,
        // Fermented Ingredient Rules: 1. Ghast Tear, 2. Glass Bottle, 3. Ingredient
        // Pickled Ingredient Rules: 1. Salt Pinch, 2. Water Bottle, 3. Ingredient

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(Items.wheat_seeds, 9),
            new ItemStack(ModBlocks.storage_sack));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(Items.milk_bucket),
            new ItemStack(ModItems.powdered_milk),
            new ItemStack(Items.water_bucket),
            new ItemStack(Items.bucket));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(Items.fish, 9),
            new boolean[]{ModConfigurationBlocks.enableStorageBlocks},
            new ItemStack(ModBlocks.storage_barrel));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(Items.fish, 9, 1),
            new boolean[]{ModConfigurationBlocks.enableStorageBlocks},
            new ItemStack(ModBlocks.storage_barrel, 1, 1));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(Items.fish, 9, 2),
            new boolean[]{ModConfigurationBlocks.enableStorageBlocks},
            new ItemStack(ModBlocks.storage_barrel, 1, 2));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(Items.fish, 9, 3),
            new boolean[]{ModConfigurationBlocks.enableStorageBlocks},
            new ItemStack(ModBlocks.storage_barrel, 1, 4));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 2),
            new ItemStack(ModItems.saltwort));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 5),
            new ItemStack(ModBlocks.salt_flower, 1, 2));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 10),
            new ItemStack(ModBlocks.salt_flower, 1, 5));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(Items.cookie, 8),
            new boolean[]{ModConfigurationVanillaChanges.enableRecipeChanges, ModConfigurationItems.enableDough},
            new ItemStack(ModItems.dough),
            new ItemStack(Items.dye, 1, 3));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(Items.melon_seeds, 9),
            new boolean[]{ModConfigurationBlocks.enableStorageBlocks},
            new ItemStack(ModBlocks.storage_sack, 1, 1));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(Items.pumpkin_seeds, 9),
            new boolean[]{ModConfigurationBlocks.enableStorageBlocks},
            new ItemStack(ModBlocks.storage_sack, 1, 2));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(Items.carrot, 9),
            new boolean[]{ModConfigurationBlocks.enableStorageBlocks},
            new ItemStack(ModBlocks.storage_crate));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(Items.potato, 9),
            new boolean[]{ModConfigurationBlocks.enableStorageBlocks},
            new ItemStack(ModBlocks.storage_crate, 1, 1));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(Items.poisonous_potato, 9),
            new boolean[]{ModConfigurationBlocks.enableStorageBlocks},
            new ItemStack(ModBlocks.storage_crate, 1, 2));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(Items.pumpkin_pie),
            new boolean[]{ModConfigurationVanillaChanges.enableRecipeChanges, ModConfigurationItems.enableDough},
            new ItemStack(Items.sugar),
            new ItemStack(Blocks.pumpkin),
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModBlocks.salt_dirt),
            new boolean[]{ModConfigurationBlocks.enableSaltDirt},
            new ItemStack(Blocks.dirt),
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(ModItems.salt_pinch));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModBlocks.salt_dirt),
            new boolean[]{ModConfigurationBlocks.enableSaltDirt},
            new ItemStack(ModBlocks.salt_dirt_lite),
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(ModItems.salt_pinch));

        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.fish_bait, 4),
                new boolean[]{ModConfigurationBlocks.enableFishFarm},
                "itemFish",
                new ItemStack(ModItems.saltwort),
                new ItemStack(Items.wheat),
                new ItemStack(Items.wheat));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.honey_bee, 1, 0),
            new boolean[]{ModConfigurationItems.enableHoney},
            new ItemStack(ModItems.bee_larva),
            new ItemStack(ModItems.honey_bee, 1, 18));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.carpenter_bee, 1, 0),
            new boolean[]{ModConfigurationItems.enableHoney},
            new ItemStack(ModItems.bee_larva),
            new ItemStack(ModItems.carpenter_bee, 1, 18));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.regal_bee, 1, 0),
            new boolean[]{ModConfigurationItems.enableHoney},
            new ItemStack(ModItems.bee_larva),
            new ItemStack(ModItems.regal_bee, 1, 18));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.royal_jelly),
            new boolean[]{ModConfigurationItems.enableHoney},
            new ItemStack(ModItems.honey_bee, 1, 18));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.royal_jelly),
            new boolean[]{ModConfigurationItems.enableHoney},
            new ItemStack(ModItems.carpenter_bee, 1, 18));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.royal_jelly),
            new boolean[]{ModConfigurationItems.enableHoney},
            new ItemStack(ModItems.regal_bee, 1, 18));

        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.mineral_mud_ball),
                new boolean[]{ModConfigurationItems.enableMineralMud},
                new ItemStack(ModItems.baking_soda),
                new ItemStack(ModItems.salt),
                "itemCoal",
                new ItemStack(Items.clay_ball));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.mineral_mud_ball, 4),
            new boolean[]{ModConfigurationItems.enableMineralMud},
            new ItemStack(ModBlocks.mineral_mud));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.salt, 9),
            new boolean[]{ModConfigurationBlocks.enableSaltBlocks},
            new ItemStack(ModBlocks.salt_block, 1, OreDictionary.WILDCARD_VALUE));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.salt_pinch, 9),
            new ItemStack(ModItems.salt));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.salt_pinch, 40),
            new boolean[]{ModConfigurationBlocks.enableSaltBlocks},
            new ItemStack(ModBlocks.salt_slab, 1, OreDictionary.WILDCARD_VALUE));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.sugar_pinch, 9),
            new ItemStack(Items.sugar));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.onion, 9),
            new boolean[]{ModConfigurationBlocks.enableStorageBlocks, ModConfigurationItems.enableOnion},
            new ItemStack(ModBlocks.storage_crate, 1, 3));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.saltwort, 9),
            new boolean[]{ModConfigurationBlocks.enableStorageBlocks},
            new ItemStack(ModBlocks.storage_sack, 1, 3));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.salt_cooked_porkchop),
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.cooked_porkchop));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.salt_cooked_beef),
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.cooked_beef));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.salt_cooked_chicken),
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.cooked_chicken));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.haunch, 1, 2),
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(ModItems.haunch, 1, 1));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.salt_cooked_cod),
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.cooked_fished));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.salt_cooked_salmon),
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.cooked_fished, 1, 1));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.cooked_tropical_fish, 1, 1),
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(ModItems.cooked_tropical_fish));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.tailor, 9),
            new boolean[]{ModConfigurationBlocks.enableStorageBlocks, ModConfigurationItems.enableTailor},
            new ItemStack(ModBlocks.storage_barrel, 1, 3));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.tailor, 1, 2),
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(ModItems.tailor, 1, 1));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.calamari, 1, 2),
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(ModItems.calamari, 1, 1));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.salt_bread),
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.bread));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.salt_baked_potato),
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.baked_potato));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.sugar_apple),
            new ItemStack(ModItems.sugar_pinch),
            new ItemStack(Items.apple));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.sugar_melon),
            new ItemStack(ModItems.sugar_pinch),
            new ItemStack(Items.melon));

        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.honey_apple),
            new boolean[]{ModConfigurationItems.enableHoney},
            "itemHoney",
            new ItemStack(Items.apple));
        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.honey_porkchop),
            new boolean[]{ModConfigurationItems.enableHoney},
            "itemHoney",
            new ItemStack(Items.cooked_porkchop));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.chocolate_pie),
            new boolean[]{ModConfigurationItems.enableDough},
            new ItemStack(Items.dye, 1, 3),
            new ItemStack(Items.dye, 1, 3),
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.chocolate_pie),
            new boolean[]{!ModConfigurationItems.enableDough},
            new ItemStack(Items.dye, 1, 3),
            new ItemStack(Items.dye, 1, 3),
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));

        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.birthday_pie),
            new boolean[]{ModConfigurationBlocks.enableEvaporator, ModConfigurationItems.enableDough},
            new ItemStack(Items.sugar),
            "itemMilk",
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.birthday_pie),
            new boolean[]{ModConfigurationBlocks.enableEvaporator, !ModConfigurationItems.enableDough},
            new ItemStack(Items.sugar),
            "itemMilk",
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.birthday_pie),
            new boolean[]{!ModConfigurationBlocks.enableEvaporator, ModConfigurationItems.enableDough},
            new ItemStack(Items.sugar),
            new ItemStack(Items.milk_bucket),
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.birthday_pie),
            new boolean[]{!ModConfigurationBlocks.enableEvaporator, !ModConfigurationItems.enableDough},
            new ItemStack(Items.sugar),
            new ItemStack(Items.milk_bucket),
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));


        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.apple_pie),
            new ItemStack(Items.sugar),
            new ItemStack(Items.apple),
            new ItemStack(Items.apple),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.carrot_pie),
            new ItemStack(Items.sugar),
            new ItemStack(Items.carrot),
            new ItemStack(Items.carrot),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.mushroom_pie),
            new ItemStack(ModItems.salt),
            "blockMushroom",
            "blockMushroom",
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.potato_pie),
            new ItemStack(ModItems.salt),
            new ItemStack(Items.potato),
            new ItemStack(Items.potato),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.onion_pie),
            new boolean[]{ModConfigurationItems.enableOnion},
            new ItemStack(ModItems.salt),
            new ItemStack(ModItems.onion),
            new ItemStack(ModItems.onion),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.shepherds_pie),
            new boolean[]{ModConfigurationItems.enableDough},
            new ItemStack(ModItems.salt),
            "itemRedmeat",
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.cod_pie),
            new boolean[]{ModConfigurationItems.enableDough},
            new ItemStack(ModItems.salt),
            new ItemStack(Items.fish),
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.salmon_pie),
            new boolean[]{ModConfigurationItems.enableDough},
            new ItemStack(ModItems.salt),
            new ItemStack(Items.fish, 1, 1),
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.tropical_fish_pie),
            new boolean[]{ModConfigurationItems.enableDough},
            new ItemStack(ModItems.salt),
            new ItemStack(Items.fish, 1, 2),
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.tailor_pie),
            new boolean[]{ModConfigurationItems.enableDough},
            new ItemStack(ModItems.salt),
            new ItemStack(ModItems.tailor),
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.calamari_pie),
            new boolean[]{ModConfigurationItems.enableDough},
            new ItemStack(ModItems.salt),
            new ItemStack(ModItems.calamari),
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.saltwort_pie),
            new boolean[]{ModConfigurationItems.enableDough},
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.shepherds_pie),
            new boolean[]{!ModConfigurationItems.enableDough},
            new ItemStack(ModItems.salt),
            "itemRedmeat",
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.cod_pie),
            new boolean[]{!ModConfigurationItems.enableDough},
            new ItemStack(ModItems.salt),
            new ItemStack(Items.fish),
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.salmon_pie),
            new boolean[]{!ModConfigurationItems.enableDough},
            new ItemStack(ModItems.salt),
            new ItemStack(Items.fish, 1, 1),
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.tropical_fish_pie),
            new boolean[]{!ModConfigurationItems.enableDough},
            new ItemStack(ModItems.salt),
            new ItemStack(Items.fish, 1, 2),
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.tailor_pie),
            new boolean[]{!ModConfigurationItems.enableDough},
            new ItemStack(ModItems.salt),
            new ItemStack(ModItems.tailor),
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.calamari_pie),
            new boolean[]{!ModConfigurationItems.enableDough},
            new ItemStack(ModItems.salt),
            new ItemStack(ModItems.calamari),
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.saltwort_pie),
            new boolean[]{!ModConfigurationItems.enableDough},
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.saltwort),
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.fermented_saltwort),
            new ItemStack(Items.ghast_tear),
            new ItemStack(Items.glass_bottle),
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.saltwort));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.fermented_saltwort),
            new ItemStack(Items.ghast_tear),
            new ItemStack(Items.glass_bottle),
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.saltwort));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.fermented_fern),
            new ItemStack(Items.ghast_tear),
            new ItemStack(Items.glass_bottle),
            new ItemStack(Blocks.tallgrass, 1, 2),
            new ItemStack(Blocks.tallgrass, 1, 2),
            new ItemStack(Blocks.tallgrass, 1, 2),
            new ItemStack(Blocks.tallgrass, 1, 2),
            new ItemStack(Blocks.tallgrass, 1, 2));
        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.fermented_mushroom),
            new ItemStack(Items.ghast_tear),
            new ItemStack(Items.glass_bottle),
            "blockMushroom",
            "blockMushroom",
            "blockMushroom",
            "blockMushroom",
            "blockMushroom");
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.pickled_calamari),
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.potionitem),
            new ItemStack(ModItems.calamari),
            new ItemStack(ModItems.calamari));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.pickled_onion),
            new boolean[]{ModConfigurationItems.enableOnion},
            new ItemStack(ModItems.salt_pinch),
            new ItemStack(Items.potionitem),
            new ItemStack(ModItems.onion),
            new ItemStack(ModItems.onion));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.melon_preserves),
            new ItemStack(ModItems.sugar_pinch),
            new ItemStack(Items.potionitem),
            new ItemStack(Items.melon),
            new ItemStack(Items.melon));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.apple_preserves),
            new ItemStack(ModItems.sugar_pinch),
            new ItemStack(Items.potionitem),
            new ItemStack(Items.apple),
            new ItemStack(Items.apple));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.fizzy_drink),
            new boolean[]{ModConfigurationItems.enableFizzyDrink},
            new ItemStack(ModItems.baking_soda),
            new ItemStack(Items.potionitem));

        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.muffin),
            new boolean[]{ModConfigurationItems.enableHoney, ModConfigurationItems.enableDough},
            "itemRoyaljelly",
            new ItemStack(Items.dye, 1, 3),
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessOreRecipe(new ItemStack(ModItems.muffin),
            new boolean[]{ModConfigurationItems.enableHoney, !ModConfigurationItems.enableDough},
            "itemRoyaljelly",
            new ItemStack(Items.dye, 1, 3),
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.muffin),
            new boolean[]{!ModConfigurationItems.enableHoney, ModConfigurationItems.enableDough},
            new ItemStack(Items.sugar),
            new ItemStack(Items.dye, 1, 3),
            new ItemStack(ModItems.dough),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.muffin),
            new boolean[]{!ModConfigurationItems.enableHoney, !ModConfigurationItems.enableDough},
            new ItemStack(Items.sugar),
            new ItemStack(Items.dye, 1, 3),
            new ItemStack(Items.wheat),
            new ItemStack(Items.egg));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.rainmaker_star),
            new boolean[]{ModConfigurationItems.enableRainmaker},
            new ItemStack(Items.gunpowder),
            new ItemStack(ModItems.salt),
            new ItemStack(ModItems.salt),
            new ItemStack(ModItems.salt),
            new ItemStack(ModItems.salt),
            new ItemStack(ModItems.baking_soda),
            new ItemStack(ModItems.baking_soda),
            new ItemStack(ModItems.baking_soda),
            new ItemStack(ModItems.baking_soda));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.rainmaker),
            new boolean[]{ModConfigurationItems.enableRainmaker},
            new ItemStack(ModItems.rainmaker_star),
            new ItemStack(ModItems.rainmaker_star),
            new ItemStack(ModItems.rainmaker_star),
            new ItemStack(ModItems.rainmaker_star),
            new ItemStack(ModItems.rainmaker_star),
            new ItemStack(Items.paper),
            new ItemStack(Items.gunpowder),
            new ItemStack(Items.gunpowder),
            new ItemStack(Items.gunpowder));

        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.tf_saltwort_cooked_venison),
            new boolean[]{ModConfigurationModCompatibility.enableTFFoods},
            new ItemStack(Items.bowl),
            new ItemStack(ModItems.tf_salt_cooked_venison),
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.saltwort));
        ConditionalRegistrar.addShapelessRecipe(new ItemStack(ModItems.tf_saltwort_meef_steak),
            new boolean[]{ModConfigurationModCompatibility.enableTFFoods},
            new ItemStack(Items.bowl),
            new ItemStack(ModItems.tf_salt_meef_steak),
            new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.saltwort));
    }
}
