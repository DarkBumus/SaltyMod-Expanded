package darkbum.saltymod.init.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltymod.configuration.ModConfiguration;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.item.ItemSaltShard;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ModShapelessRecipes {

    public static void init() {
//  Salty Food Rules:				1. Salt/Sugar Pinch, 2. Ingredient
//  Bowl Rules:					    1. Salt/Sugar Pinch, 2. Bowl, 3. Ingredients (Apple-Carrot-Melon-Potato-Mushroom-Fish-Seeds/Saltwort-Dandelion-Allium)
//  Honeyed Food Rules:			    1. Honey, 2. Food
//  Chocolate Food Rules:			1. Cocoa Beans, 2. Food
//  Pie Rules:					    1. Salt/Sugar Pinch, 2. Ingredients, 3. Dough, 4. Egg,
//  Fermented Ingredient Rules:	    1. Ghast Tear, 2. Glass Bottle, 3. Ingredient
//  Pickled Ingredient Rules:		1. Salt Pinch, 2. Water Bottle, 3. Ingredient

        GameRegistry.addShapelessRecipe(new ItemStack(Items.wheat_seeds, 9), new ItemStack(ModBlocks.storage_sack));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.milk_bucket), new ItemStack(ModItems.powdered_milk), new ItemStack(Items.water_bucket), new ItemStack(Items.bucket));
        if(ModConfiguration.enableStorageBlocks) {
            GameRegistry.addShapelessRecipe(new ItemStack(Items.fish, 9), new ItemStack(ModBlocks.storage_barrel));
            GameRegistry.addShapelessRecipe(new ItemStack(Items.fish, 9, 1), new ItemStack(ModBlocks.storage_barrel, 1, 1));
            GameRegistry.addShapelessRecipe(new ItemStack(Items.fish, 9, 2), new ItemStack(ModBlocks.storage_barrel, 1, 2));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tailor, 9), new ItemStack(ModBlocks.storage_barrel, 1, 3));
            GameRegistry.addShapelessRecipe(new ItemStack(Items.fish, 9, 3), new ItemStack(ModBlocks.storage_barrel, 1, 4));
        }
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 2), new ItemStack(ModItems.saltwort));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 5), new ItemStack(ModBlocks.salt_flower, 1, 2));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 10), new ItemStack(ModBlocks.salt_flower, 1, 5));
        if(ModConfiguration.enableStorageBlocks) {
            GameRegistry.addShapelessRecipe(new ItemStack(Items.melon_seeds, 9), new ItemStack(ModBlocks.storage_sack, 1, 1));
            GameRegistry.addShapelessRecipe(new ItemStack(Items.pumpkin_seeds, 9), new ItemStack(ModBlocks.storage_sack, 1, 2));
            GameRegistry.addShapelessRecipe(new ItemStack(Items.carrot, 9), new ItemStack(ModBlocks.storage_crate));
            GameRegistry.addShapelessRecipe(new ItemStack(Items.potato, 9), new ItemStack(ModBlocks.storage_crate, 1, 1));
            GameRegistry.addShapelessRecipe(new ItemStack(Items.poisonous_potato, 9), new ItemStack(ModBlocks.storage_crate, 1, 2));
        }

        if(ModConfiguration.enableSaltDirt) {
            GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.salt_dirt), new ItemStack(ModItems.salt), new ItemStack(Blocks.dirt));
            GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.salt_dirt), new ItemStack(ModBlocks.salt_dirt), new ItemStack(ModItems.salt_pinch), new ItemStack(ModItems.salt_pinch), new ItemStack(ModItems.salt_pinch));
        }

        if(ModConfiguration.enableHoney) {
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.honey_bee, 1, 0), new ItemStack(ModItems.bee_larva), new ItemStack(ModItems.royal_jelly));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.carpenter_bee, 1, 0), new ItemStack(ModItems.bee_larva), new ItemStack(ModItems.royal_jelly), new ItemStack(Items.stick));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.regal_bee, 1, 0), new ItemStack(ModItems.bee_larva), new ItemStack(ModItems.royal_jelly), new ItemStack(Items.gold_nugget));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.royal_jelly), new ItemStack(ModItems.honey_bee, 1, 18));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.royal_jelly), new ItemStack(ModItems.carpenter_bee, 1, 18));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.royal_jelly), new ItemStack(ModItems.regal_bee, 1, 18));
//            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.royal_jelly), new ItemStack(ModItems.bee_larva));
        }
        if(ModConfiguration.enableMineralMud) {
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.mineral_mud_ball, 4), new ItemStack(ModBlocks.mineral_mud));
        }
        if(ModConfiguration.enableSaltBlocks) {
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt, 9), new ItemStack(ModBlocks.salt_block, 1, OreDictionary.WILDCARD_VALUE));
        }
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_pinch, 9),  new ItemStack(ModItems.salt));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_pinch, 40), new ItemStack(ModBlocks.salt_slab, 1, OreDictionary.WILDCARD_VALUE));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugar_pinch, 9), new ItemStack(Items.sugar));
        if(ModConfiguration.enableStorageBlocks) {
            if(ModConfiguration.enableOnion) {
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.onion, 9), new ItemStack(ModBlocks.storage_crate, 1, 3));
            }
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltwort, 9), new ItemStack(ModBlocks.storage_sack, 1, 3));
        }
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_cooked_porkchop), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.cooked_porkchop));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_cooked_beef), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.cooked_beef));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_cooked_chicken), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.cooked_chicken));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_cooked_haunch), new ItemStack(ModItems.salt_pinch), new ItemStack(ModItems.cooked_haunch));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_baked_potato), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.baked_potato));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_cooked_cod), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.cooked_fished));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_cooked_salmon), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.cooked_fished, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_cooked_tropical_fish), new ItemStack(ModItems.salt_pinch), new ItemStack(ModItems.cooked_tropical_fish));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_cooked_tailor), new ItemStack(ModItems.salt_pinch), new ItemStack(ModItems.cooked_tailor));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_cooked_calamari), new ItemStack(ModItems.salt_pinch), new ItemStack(ModItems.cooked_calamari));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_bread), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.bread));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_egg), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.egg));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_mushroom_stew), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.mushroom_stew));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pumpkin_porridge), new ItemStack(Items.bowl), new ItemStack(Blocks.pumpkin));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_pumpkin_porridge), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.bowl), new ItemStack(Blocks.pumpkin));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_pumpkin_porridge), new ItemStack(ModItems.salt_pinch), new ItemStack(ModItems.pumpkin_porridge));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cactus_soup), new ItemStack(Items.bowl), new ItemStack(Blocks.cactus), new ItemStack(Blocks.cactus), new ItemStack(Blocks.cactus));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_cactus_soup), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.bowl), new ItemStack(Blocks.cactus), new ItemStack(Blocks.cactus), new ItemStack(Blocks.cactus));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_cactus_soup), new ItemStack(ModItems.salt_pinch), new ItemStack(ModItems.cactus_soup));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_stewed_vegetables), new ItemStack(ModItems.salt_pinch), new ItemStack(ModItems.stewed_vegetables));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_potato_mushroom), new ItemStack(ModItems.salt_pinch), new ItemStack(ModItems.potato_mushroom));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.golden_vegetables), new ItemStack(Items.bowl), new ItemStack(Items.golden_carrot), new ItemStack(ModItems.golden_potato), new ItemStack(ModItems.golden_saltwort));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_golden_vegetables), new ItemStack(ModItems.salt_pinch), new ItemStack(ModItems.golden_vegetables));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_golden_vegetables), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.bowl), new ItemStack(Items.golden_carrot), new ItemStack(ModItems.golden_potato), new ItemStack(ModItems.golden_saltwort));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_fish_soup), new ItemStack(ModItems.salt_pinch), new ItemStack(ModItems.fish_soup));
        if(ModConfiguration.enableOnion) {
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.dandelion_salad), new ItemStack(Items.bowl), new ItemStack(Blocks.tallgrass, 1, 2), new ItemStack(Blocks.yellow_flower), new ItemStack(ModItems.onion));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_dandelion_salad), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.bowl), new ItemStack(Blocks.tallgrass, 1, 2), new ItemStack(Blocks.yellow_flower), new ItemStack(ModItems.onion));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_dandelion_salad), new ItemStack(ModItems.salt_pinch), new ItemStack(ModItems.dandelion_salad));
        }
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.wheat_sprouts), new ItemStack(Items.bowl), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_wheat_sprouts), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.bowl), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_wheat_sprouts), new ItemStack(ModItems.salt_pinch), new ItemStack(ModItems.wheat_sprouts));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_beetroot_salad), new ItemStack(ModItems.salt_pinch), new ItemStack(ModItems.beetroot_salad));
        if(ModConfiguration.enableOnion) {
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_dressed_herring), new ItemStack(ModItems.salt_pinch), new ItemStack(ModItems.dressed_herring));
        }
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltwort_salad), new ItemStack(Items.bowl), new ItemStack(ModItems.saltwort), new ItemStack(ModItems.saltwort), new ItemStack(ModItems.saltwort), new ItemStack(ModItems.saltwort), new ItemStack(ModItems.saltwort), new ItemStack(ModItems.saltwort));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.golden_saltwort_salad), new ItemStack(Items.bowl), new ItemStack(ModItems.golden_saltwort), new ItemStack(ModItems.golden_saltwort), new ItemStack(ModItems.golden_saltwort), new ItemStack(ModItems.golden_saltwort), new ItemStack(ModItems.golden_saltwort), new ItemStack(ModItems.golden_saltwort));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltwort_cooked_porkchop), new ItemStack(Items.bowl), new ItemStack(ModItems.salt_cooked_porkchop), new ItemStack(ModItems.saltwort), new ItemStack(ModItems.saltwort));
        if(ModConfiguration.enableHoney) {
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltwort_honey_porkchop), new ItemStack(Items.bowl), new ItemStack(ModItems.honey_porkchop), new ItemStack(ModItems.saltwort), new ItemStack(ModItems.saltwort));
        }
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltwort_cooked_beef), new ItemStack(Items.bowl), new ItemStack(ModItems.salt_cooked_beef), new ItemStack(ModItems.saltwort), new ItemStack(ModItems.saltwort));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltwort_cooked_mutton), new ItemStack(Items.bowl), new ItemStack(ModItems.salt_cooked_mutton), new ItemStack(ModItems.saltwort), new ItemStack(ModItems.saltwort));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltwort_cooked_strider), new ItemStack(Items.bowl), new ItemStack(ModItems.salt_cooked_strider), new ItemStack(ModItems.saltwort), new ItemStack(ModItems.saltwort));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltwort_cooked_haunch), new ItemStack(Items.bowl), new ItemStack(ModItems.salt_cooked_haunch), new ItemStack(ModItems.saltwort), new ItemStack(ModItems.saltwort));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugar_apple), new ItemStack(ModItems.sugar_pinch), new ItemStack(Items.apple));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugar_melon), new ItemStack(ModItems.sugar_pinch), new ItemStack(Items.melon));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugar_fruit_salad), new ItemStack(ModItems.sugar_pinch), new ItemStack(ModItems.fruit_salad));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugar_golden_fruit_salad), new ItemStack(ModItems.sugar_pinch), new ItemStack(ModItems.golden_fruit_salad));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.grated_carrot), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.carrot), new ItemStack(Items.carrot));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugar_grated_carrot), new ItemStack(ModItems.sugar_pinch), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.carrot), new ItemStack(Items.carrot));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugar_grated_carrot), new ItemStack(ModItems.sugar_pinch), new ItemStack(ModItems.grated_carrot));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.melon_soup), new ItemStack(Items.bowl), new ItemStack(Items.melon), new ItemStack(Items.melon), new ItemStack(Items.melon));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugar_melon_soup), new ItemStack(ModItems.sugar_pinch), new ItemStack(Items.bowl), new ItemStack(Items.melon), new ItemStack(Items.melon), new ItemStack(Items.melon));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugar_melon_soup), new ItemStack(ModItems.sugar_pinch), new ItemStack(ModItems.melon_soup));
        if(ModConfiguration.enableDough) {
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.chocolate_pie), new ItemStack(Items.dye, 1, 3), new ItemStack(Items.dye, 1, 3), new ItemStack(ModItems.dough), new ItemStack(Items.egg));
        } else {
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.chocolate_pie), new ItemStack(Items.dye, 1, 3), new ItemStack(Items.dye, 1, 3), new ItemStack(Items.wheat), new ItemStack(Items.egg));
        }
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.carrot_pie), new ItemStack(Items.sugar), new ItemStack(Items.carrot), new ItemStack(Items.carrot), new ItemStack(Items.egg));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.apple_pie), new ItemStack(Items.sugar), new ItemStack(Items.apple), new ItemStack(Items.apple), new ItemStack(Items.egg));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.potato_pie), new ItemStack(ModItems.salt), new ItemStack(Items.potato), new ItemStack(Items.potato), new ItemStack(Items.egg));
        if(ModConfiguration.enableOnion) {
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.onion_pie), new ItemStack(ModItems.salt), new ItemStack(ModItems.onion), new ItemStack(ModItems.onion), new ItemStack(Items.egg));
        }
        if(ModConfiguration.enableDough) {
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cod_pie), new ItemStack(ModItems.salt), new ItemStack(Items.fish), new ItemStack(ModItems.dough), new ItemStack(Items.egg));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salmon_pie), new ItemStack(ModItems.salt), new ItemStack(Items.fish, 1, 1), new ItemStack(ModItems.dough), new ItemStack(Items.egg));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tropical_fish_pie), new ItemStack(ModItems.salt), new ItemStack(Items.fish, 1, 2), new ItemStack(ModItems.dough), new ItemStack(Items.egg));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tailor_pie), new ItemStack(ModItems.salt), new ItemStack(ModItems.tailor), new ItemStack(ModItems.dough), new ItemStack(Items.egg));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.calamari_pie), new ItemStack(ModItems.salt), new ItemStack(ModItems.calamari), new ItemStack(ModItems.dough), new ItemStack(Items.egg));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltwort_pie), new ItemStack(ModItems.saltwort), new ItemStack(ModItems.saltwort), new ItemStack(ModItems.dough), new ItemStack(Items.egg));
        } else {
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cod_pie), new ItemStack(ModItems.salt), new ItemStack(Items.fish), new ItemStack(Items.wheat), new ItemStack(Items.egg));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salmon_pie), new ItemStack(ModItems.salt), new ItemStack(Items.fish, 1, 1), new ItemStack(Items.wheat), new ItemStack(Items.egg));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tropical_fish_pie), new ItemStack(ModItems.salt), new ItemStack(Items.fish, 1, 2), new ItemStack(Items.wheat), new ItemStack(Items.egg));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tailor_pie), new ItemStack(ModItems.salt), new ItemStack(ModItems.tailor), new ItemStack(Items.wheat), new ItemStack(Items.egg));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.calamari_pie), new ItemStack(ModItems.salt), new ItemStack(ModItems.calamari), new ItemStack(Items.wheat), new ItemStack(Items.egg));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltwort_pie), new ItemStack(ModItems.saltwort), new ItemStack(ModItems.saltwort), new ItemStack(Items.wheat), new ItemStack(Items.egg));
        }
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fermented_saltwort), new ItemStack(Items.ghast_tear), new ItemStack(Items.glass_bottle), new ItemStack(ModItems.saltwort), new ItemStack(ModItems.saltwort), new ItemStack(ModItems.saltwort), new ItemStack(ModItems.saltwort), new ItemStack(ModItems.saltwort));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fermented_fern), new ItemStack(Items.ghast_tear), new ItemStack(Items.glass_bottle), new ItemStack(Blocks.tallgrass, 1, 2), new ItemStack(Blocks.tallgrass, 1, 2), new ItemStack(Blocks.tallgrass, 1, 2), new ItemStack(Blocks.tallgrass, 1, 2), new ItemStack(Blocks.tallgrass, 1, 2));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pickled_calamari), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.potionitem), new ItemStack(ModItems.calamari), new ItemStack(ModItems.calamari));
        if(ModConfiguration.enableOnion) {
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pickled_onion), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.potionitem), new ItemStack(ModItems.onion), new ItemStack(ModItems.onion));
        }
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.melon_preserves), new ItemStack(ModItems.sugar_pinch), new ItemStack(Items.potionitem), new ItemStack(Items.melon), new ItemStack(Items.melon));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.apple_preserves), new ItemStack(ModItems.sugar_pinch), new ItemStack(Items.potionitem), new ItemStack(Items.apple), new ItemStack(Items.apple));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tunneler_concoction), new ItemStack(Items.ghast_tear), new ItemStack(Items.glass_bottle), new ItemStack(ModItems.salt_pinch), new ItemStack(ModItems.sugar_pinch), new ItemStack(ModItems.baking_soda), new ItemStack(Items.dye, 1, 3), new ItemStack(ModItems.mineral_mud_ball), new ItemStack(Items.redstone), new ItemStack(Items.glowstone_dust));
        if(ModConfiguration.enableFizzyDrink) {
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fizzy_drink), new ItemStack(ModItems.baking_soda), new ItemStack(Items.potionitem));
        }
        if(ModConfiguration.enableRainmaker) {
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.rainmaker_star), new ItemStack(Items.gunpowder), new ItemStack(ModItems.salt), new ItemStack(ModItems.salt), new ItemStack(ModItems.salt), new ItemStack(ModItems.salt), new ItemStack(ModItems.baking_soda), new ItemStack(ModItems.baking_soda), new ItemStack(ModItems.baking_soda), new ItemStack(ModItems.baking_soda));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.rainmaker), new ItemStack(ModItems.rainmaker_star), new ItemStack(ModItems.rainmaker_star), new ItemStack(ModItems.rainmaker_star), new ItemStack(ModItems.rainmaker_star), new ItemStack(ModItems.rainmaker_star), new ItemStack(Items.paper), new ItemStack(Items.gunpowder), new ItemStack(Items.gunpowder), new ItemStack(Items.gunpowder));
        }

        if(ModConfiguration.enableTFFoods) {
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tf_saltwort_cooked_venison), new ItemStack(Items.bowl), new ItemStack(ModItems.tf_salt_cooked_venison), new ItemStack(ModItems.saltwort), new ItemStack(ModItems.saltwort));
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tf_saltwort_meef_steak), new ItemStack(Items.bowl), new ItemStack(ModItems.tf_salt_meef_steak), new ItemStack(ModItems.saltwort), new ItemStack(ModItems.saltwort));
        }
    }
}
