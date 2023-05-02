package darkbum.saltymod.common;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltymod.configuration.ModConfiguration;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ModOreDictionary {

    public static void init() {
//Salty Mod Ore Dictionaries
        OreDictionary.registerOre("blockMushroom", Blocks.red_mushroom);
        OreDictionary.registerOre("blockMushroom", Blocks.brown_mushroom);
        OreDictionary.registerOre("oreSalt", ModBlocks.salt_ore);
        OreDictionary.registerOre("blockSalt", new ItemStack(ModBlocks.salt_block, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("stairSalt", ModBlocks.salt_brick_stairs);
        OreDictionary.registerOre("slabSalt", new ItemStack(ModBlocks.salt_slab, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("blockMud", ModBlocks.mineral_mud);
        OreDictionary.registerOre("blockMud", ModBlocks.wet_mud_brick);
        OreDictionary.registerOre("blockMud", ModBlocks.dry_mud_brick);
        OreDictionary.registerOre("logWood", ModBlocks.blossom_log);
        OreDictionary.registerOre("logWood", ModBlocks.blossom_stripped_log);
        OreDictionary.registerOre("logWood", ModBlocks.blossom_wood);
        OreDictionary.registerOre("plankWood", ModBlocks.blossom_planks);
        OreDictionary.registerOre("stairWood", ModBlocks.blossom_stairs);
        OreDictionary.registerOre("slabWood", ModBlocks.blossom_slab);
        OreDictionary.registerOre("treeLeaves", ModBlocks.blossom_leaves);

        OreDictionary.registerOre("itemRedmeat", Items.cooked_beef);
        OreDictionary.registerOre("itemRedmeat", ModItems.cooked_haunch);
        OreDictionary.registerOre("itemRedmeat", ModItems.cooked_strider);
        OreDictionary.registerOre("itemFish", new ItemStack(Items.fish, 1, 0));
        OreDictionary.registerOre("itemFish", new ItemStack(Items.fish, 1, 1));
        OreDictionary.registerOre("itemFish", new ItemStack(Items.fish, 1, 2));
        OreDictionary.registerOre("itemFish", ModItems.tailor);
        OreDictionary.registerOre("materialWaxcomb", ModItems.waxcomb);
        OreDictionary.registerOre("itemSweetener", Items.sugar);
        OreDictionary.registerOre("itemSweetener", ModItems.honeycomb);
        OreDictionary.registerOre("itemHoney", ModItems.honeycomb);
        OreDictionary.registerOre("itemRoyaljelly", ModItems.royal_jelly);
        OreDictionary.registerOre("itemIngredientBucket", Items.water_bucket);
        OreDictionary.registerOre("itemIngredientBucket", Items.milk_bucket);
        OreDictionary.registerOre("cropOnion", ModItems.onion);
        OreDictionary.registerOre("cropSaltwort", ModItems.saltwort);

        OreDictionary.registerOre("itemFood", Items.apple);
        OreDictionary.registerOre("itemFood", Items.melon);
        OreDictionary.registerOre("itemFood", Items.carrot);
        OreDictionary.registerOre("itemFood", Items.potato);
        OreDictionary.registerOre("itemFood", ModItems.onion);
        OreDictionary.registerOre("itemFood", ModItems.saltwort);
        OreDictionary.registerOre("itemFood", new ItemStack(Items.fish, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("itemFood", ModItems.calamari);
        OreDictionary.registerOre("itemFood", Items.porkchop);
        OreDictionary.registerOre("itemFood", Items.beef);
        OreDictionary.registerOre("itemFood", Items.chicken);
        OreDictionary.registerOre("itemFood", ModItems.haunch);
        OreDictionary.registerOre("itemFood", ModItems.strider);
        OreDictionary.registerOre("itemFood", Items.rotten_flesh);
        OreDictionary.registerOre("itemFood", Items.spider_eye);
        OreDictionary.registerOre("itemFood", Items.poisonous_potato);
        OreDictionary.registerOre("itemFood", ModItems.dough);
        OreDictionary.registerOre("itemFood", ModItems.tough_jelly);
        OreDictionary.registerOre("itemFood", new ItemStack(Items.golden_apple, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("itemFood", new ItemStack(ModItems.golden_berries, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("itemFood", Items.golden_carrot);
        OreDictionary.registerOre("itemFood", ModItems.golden_potato);
        OreDictionary.registerOre("itemFood", ModItems.golden_saltwort);
        OreDictionary.registerOre("itemFood", Items.baked_potato);
        OreDictionary.registerOre("itemFood", new ItemStack(Items.cooked_fished, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("itemFood", ModItems.cooked_tropical_fish);
        OreDictionary.registerOre("itemFood", ModItems.tailor);
        OreDictionary.registerOre("itemFood", ModItems.cooked_tailor);
        OreDictionary.registerOre("itemFood", ModItems.salt_cooked_tailor);
        OreDictionary.registerOre("itemFood", ModItems.cooked_calamari);
        OreDictionary.registerOre("itemFood", Items.cooked_porkchop);
        OreDictionary.registerOre("itemFood", Items.cooked_beef);
        OreDictionary.registerOre("itemFood", Items.cooked_chicken);
        OreDictionary.registerOre("itemFood", ModItems.cooked_haunch);
        OreDictionary.registerOre("itemFood", ModItems.cooked_strider);
        OreDictionary.registerOre("itemFood", Items.bread);
        OreDictionary.registerOre("itemFood", ModItems.sugar_apple);
        OreDictionary.registerOre("itemFood", ModItems.sugar_melon_soup);
        OreDictionary.registerOre("itemFood", ModItems.sugar_berries);
        OreDictionary.registerOre("itemFood", ModItems.honey_apple);
        OreDictionary.registerOre("itemFood", ModItems.honey_berries);
        OreDictionary.registerOre("itemFood", ModItems.chocolate_berries);
        OreDictionary.registerOre("itemFood", ModItems.salt_baked_potato);
        OreDictionary.registerOre("itemFood", ModItems.salt_beetroot);
        OreDictionary.registerOre("itemFood", ModItems.salt_cooked_cod);
        OreDictionary.registerOre("itemFood", ModItems.salt_cooked_salmon);
        OreDictionary.registerOre("itemFood", ModItems.salt_cooked_tropical_fish);
        OreDictionary.registerOre("itemFood", ModItems.salt_cooked_calamari);
        OreDictionary.registerOre("itemFood", ModItems.salt_cooked_porkchop);
        OreDictionary.registerOre("itemFood", ModItems.salt_cooked_beef);
        OreDictionary.registerOre("itemFood", ModItems.salt_cooked_chicken);
        OreDictionary.registerOre("itemFood", ModItems.salt_cooked_rabbit);
        OreDictionary.registerOre("itemFood", ModItems.salt_cooked_mutton);
        OreDictionary.registerOre("itemFood", ModItems.salt_cooked_haunch);
        OreDictionary.registerOre("itemFood", ModItems.salt_cooked_strider);
        OreDictionary.registerOre("itemFood", ModItems.cured_meat);
        OreDictionary.registerOre("itemFood", ModItems.honey_porkchop);
        OreDictionary.registerOre("itemFood", ModItems.salt_bread);
        OreDictionary.registerOre("itemFood", ModItems.salt_egg);
        OreDictionary.registerOre("itemFood", Items.cookie);
        OreDictionary.registerOre("itemFood", Items.cake);
        OreDictionary.registerOre("itemFood", ModItems.chocolate_bar);
        OreDictionary.registerOre("itemFood", Items.mushroom_stew);
        OreDictionary.registerOre("itemFood", ModItems.pumpkin_porridge);
        OreDictionary.registerOre("itemFood", ModItems.cactus_soup);
        OreDictionary.registerOre("itemFood", ModItems.stewed_vegetables);
        OreDictionary.registerOre("itemFood", ModItems.potato_mushroom);
        OreDictionary.registerOre("itemFood", ModItems.golden_vegetables);
        OreDictionary.registerOre("itemFood", ModItems.fish_soup);
        OreDictionary.registerOre("itemFood", ModItems.dandelion_salad);
        OreDictionary.registerOre("itemFood", ModItems.wheat_sprouts);
        OreDictionary.registerOre("itemFood", ModItems.beetroot_salad);
        OreDictionary.registerOre("itemFood", ModItems.dressed_herring);
        OreDictionary.registerOre("itemFood", ModItems.saltwort_salad);
        OreDictionary.registerOre("itemFood", ModItems.golden_saltwort_salad);
        OreDictionary.registerOre("itemFood", ModItems.fruit_salad);
        OreDictionary.registerOre("itemFood", ModItems.golden_fruit_salad);
        OreDictionary.registerOre("itemFood", ModItems.grated_carrot);
        OreDictionary.registerOre("itemFood", ModItems.melon_soup);
        OreDictionary.registerOre("itemFood", ModItems.fermented_saltwort);
        OreDictionary.registerOre("itemFood", ModItems.fermented_mushroom);
        OreDictionary.registerOre("itemFood", ModItems.fermented_fern);
        OreDictionary.registerOre("itemFood", ModItems.pickled_calamari);
        OreDictionary.registerOre("itemFood", ModItems.pickled_onion);
        OreDictionary.registerOre("itemFood", ModItems.pickled_beetroot);
        OreDictionary.registerOre("itemFood", ModItems.melon_preserves);
        OreDictionary.registerOre("itemFood", ModItems.berry_preserves);
        OreDictionary.registerOre("itemFood", ModItems.apple_preserves);
        OreDictionary.registerOre("itemFood", ModItems.salt_mushroom_stew);
        OreDictionary.registerOre("itemFood", ModItems.salt_rabbit_stew);
        OreDictionary.registerOre("itemFood", ModItems.salt_beetroot_soup);
        OreDictionary.registerOre("itemFood", ModItems.salt_pumpkin_porridge);
        OreDictionary.registerOre("itemFood", ModItems.salt_cactus_soup);
        OreDictionary.registerOre("itemFood", ModItems.salt_stewed_vegetables);
        OreDictionary.registerOre("itemFood", ModItems.salt_potato_mushroom);
        OreDictionary.registerOre("itemFood", ModItems.salt_golden_vegetables);
        OreDictionary.registerOre("itemFood", ModItems.salt_fish_soup);
        OreDictionary.registerOre("itemFood", ModItems.salt_dandelion_salad);
        OreDictionary.registerOre("itemFood", ModItems.salt_wheat_sprouts);
        OreDictionary.registerOre("itemFood", ModItems.salt_beetroot_salad);
        OreDictionary.registerOre("itemFood", ModItems.salt_dressed_herring);
        OreDictionary.registerOre("itemFood", ModItems.saltwort_cooked_beef);
        OreDictionary.registerOre("itemFood", ModItems.saltwort_cooked_porkchop);
        OreDictionary.registerOre("itemFood", ModItems.saltwort_honey_porkchop);
        OreDictionary.registerOre("itemFood", ModItems.saltwort_cooked_strider);
        OreDictionary.registerOre("itemFood", ModItems.saltwort_cooked_mutton);
        OreDictionary.registerOre("itemFood", ModItems.saltwort_cooked_haunch);
        OreDictionary.registerOre("itemFood", ModItems.sugar_fruit_salad);
        OreDictionary.registerOre("itemFood", ModItems.sugar_golden_fruit_salad);
        OreDictionary.registerOre("itemFood", ModItems.sugar_grated_carrot);
        OreDictionary.registerOre("itemFood", ModItems.sugar_melon_soup);
        OreDictionary.registerOre("itemFood", Items.pumpkin_pie);
        OreDictionary.registerOre("itemFood", ModItems.chocolate_pie);
        OreDictionary.registerOre("itemFood", ModItems.carrot_pie);
        OreDictionary.registerOre("itemFood", ModItems.apple_pie);
        OreDictionary.registerOre("itemFood", ModItems.sweetberry_pie);
        OreDictionary.registerOre("itemFood", ModItems.potato_pie);
        OreDictionary.registerOre("itemFood", ModItems.onion_pie);
        OreDictionary.registerOre("itemFood", ModItems.cod_pie);
        OreDictionary.registerOre("itemFood", ModItems.salmon_pie);
        OreDictionary.registerOre("itemFood", ModItems.tropical_fish_pie);
        OreDictionary.registerOre("itemFood", ModItems.calamari_pie);
        OreDictionary.registerOre("itemFood", ModItems.shepherds_pie);
        OreDictionary.registerOre("itemFood", ModItems.mushroom_pie);
        OreDictionary.registerOre("itemFood", ModItems.saltwort_pie);
        OreDictionary.registerOre("itemFood", ModItems.muffin);

        if(ModConfiguration.mudArmorBeeResistant) {
            OreDictionary.registerOre("beeResistant", new ItemStack(ModItems.mud_helmet, 1, OreDictionary.WILDCARD_VALUE));
            OreDictionary.registerOre("beeResistant", new ItemStack(ModItems.mud_chestplate, 1, OreDictionary.WILDCARD_VALUE));
            OreDictionary.registerOre("beeResistant", new ItemStack(ModItems.mud_leggings, 1, OreDictionary.WILDCARD_VALUE));
            OreDictionary.registerOre("beeResistant", new ItemStack(ModItems.mud_boots, 1, OreDictionary.WILDCARD_VALUE));
        }

//HarvestCraft Ore Dictionaries
        if (Loader.isModLoaded("harvestcraft")) {
            OreDictionary.registerOre("listAllfishraw", ModItems.tailor);
            OreDictionary.registerOre("listAllfishcooked", ModItems.cooked_tropical_fish);
            OreDictionary.registerOre("listAllfishcooked", ModItems.cooked_tailor);
            OreDictionary.registerOre("listAllmeatraw", ModItems.strider);
            OreDictionary.registerOre("listAllmeatcooked", ModItems.cooked_strider);
            OreDictionary.registerOre("listAllmeatraw", ModItems.haunch);
            OreDictionary.registerOre("listAllmeatcooked", ModItems.cooked_haunch);
            OreDictionary.registerOre("listAllfishraw", ModItems.calamari);
            OreDictionary.registerOre("listAllfishcooked", ModItems.cooked_calamari);
            OreDictionary.registerOre("listAllmilk", ModItems.powdered_milk);
            OreDictionary.registerOre("foodSalt", ModItems.salt);
            OreDictionary.registerOre("foodSalt", ModItems.salt_pinch);
            OreDictionary.registerOre("dustSalt", ModItems.salt);
            OreDictionary.registerOre("dustSalt", ModItems.salt_pinch);
            OreDictionary.registerOre("itemSalt", ModItems.salt);
            OreDictionary.registerOre("itemSalt", ModItems.salt_pinch);
            OreDictionary.registerOre("listAllsugar", ModItems.sugar_pinch);
            OreDictionary.registerOre("foodDough", ModItems.dough);
            OreDictionary.registerOre("listAllseeds", ModItems.saltwort);
            OreDictionary.registerOre("listAllsugar", ModItems.honeycomb);
        }

//Ore Recipes
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.mineral_mud_ball), new ItemStack(ModItems.baking_soda), new ItemStack(ModItems.salt), "itemCoal", new ItemStack(Items.clay_ball)));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.dough, 3), new ItemStack(ModItems.salt_pinch), new ItemStack(ModItems.sugar_pinch), new ItemStack(ModItems.baking_soda), new ItemStack(Items.wheat), new ItemStack(Items.wheat), new ItemStack(Items.wheat), "itemIngredientBucket"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.salt_mushroom_stew), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.bowl), "blockMushroom", "blockMushroom"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.stewed_vegetables), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), "blockMushroom"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.salt_stewed_vegetables), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), "blockMushroom"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.potato_mushroom), new ItemStack(Items.bowl), new ItemStack(Items.potato), new ItemStack(Items.potato), "blockMushroom"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.salt_potato_mushroom), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.bowl), new ItemStack(Items.potato), new ItemStack(Items.potato), "blockMushroom"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.fish_soup), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), "itemFish"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.salt_fish_soup), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), "itemFish"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.honey_apple), "itemHoney", new ItemStack(Items.apple)));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.honey_porkchop), "itemHoney", new ItemStack(Items.cooked_porkchop)));
        if(ModConfiguration.enableDough) {
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.shepherds_pie), new ItemStack(ModItems.salt), "itemRedmeat", new ItemStack(ModItems.dough), new ItemStack(Items.egg)));
        } else {
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.shepherds_pie), new ItemStack(ModItems.salt), "itemRedmeat", new ItemStack(Items.wheat), new ItemStack(Items.egg)));
        }
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.mushroom_pie), new ItemStack(ModItems.salt), "blockMushroom", "blockMushroom", new ItemStack(Items.egg)));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.fermented_mushroom), new ItemStack(Items.ghast_tear), new ItemStack(Items.glass_bottle), "blockMushroom", "blockMushroom", "blockMushroom", "blockMushroom", "blockMushroom"));
        if(ModConfiguration.enableHoney) {
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.muffin), "itemRoyaljelly", new ItemStack(Items.dye, 1, 3), new ItemStack(ModItems.dough), new ItemStack(Items.egg)));
        } else {
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.muffin), new ItemStack(Items.sugar), new ItemStack(Items.dye, 1, 3), new ItemStack(ModItems.dough), new ItemStack(Items.egg)));
        }
//        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.muffin), "itemRoyaljelly", new ItemStack(Items.dye, 1, 3), new ItemStack(Items.wheat), new ItemStack(Items.egg)));
//        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.muffin), new ItemStack(Items.sugar), new ItemStack(Items.dye, 1, 3), new ItemStack(Items.wheat), new ItemStack(Items.egg)));


        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.apiary), "xxx", "yyy", "xxx", 'x', "plankWood", 'y', Items.item_frame));
    }
}
