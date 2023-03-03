package darkbum.saltmod.common;

import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltmod.init.ModBlocks;
import darkbum.saltmod.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ShapelessRecipes {

    public static void init() {
//  Salty Food Rules:				1. Salt/Sugar Pinch, 2. Ingredient
//  Bowl Rules:					    1. Salt/Sugar Pinch, 2. Bowl, 3. Ingredients (Apple-Carrot-Melon-Potato-Mushroom-Fish-Seeds/Saltwort-Dandelion-Allium)
//  Honeyed Food Rules:			    1. Honey, 2. Food
//  Chocolate Food Rules:			1. Cocoa Beans, 2. Food
//  Pie Rules:					    1. Salt/Sugar Pinch, 2. Ingredients, 3. Dough, 4. Egg,
//  Fermented Ingredient Rules:	    1. Ghast Tear, 2. Glass Bottle, 3. Ingredient
//  Pickled Ingredient Rules:		1. Salt Pinch, 2. Water Bottle, 3. Ingredient

        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.grass), new ItemStack(Blocks.dirt), new ItemStack(Items.wheat_seeds));

        GameRegistry.addShapelessRecipe(new ItemStack(Items.wheat_seeds, 9), new ItemStack(ModBlocks.storageSack));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.milk_bucket), new ItemStack(ModItems.powderedMilk), new ItemStack(Items.water_bucket), new ItemStack(Items.bucket));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.fish, 9), new ItemStack(ModBlocks.storageBarrel));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.fish, 9, 1), new ItemStack(ModBlocks.storageBarrel, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.fish, 9, 2), new ItemStack(ModBlocks.storageBarrel, 1, 2));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.fish, 9, 3), new ItemStack(ModBlocks.storageBarrel, 1, 3));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 2), new ItemStack(ModItems.saltWortSeed));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 9), new ItemStack(ModItems.blossom));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.cookie, 8), new ItemStack(ModItems.dough), new ItemStack(Items.dye, 1, 3));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.melon_seeds, 9), new ItemStack(ModBlocks.storageSack, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.pumpkin_seeds, 9), new ItemStack(ModBlocks.storageSack, 1, 2));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.carrot, 9), new ItemStack(ModBlocks.storageCrate));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.potato, 9), new ItemStack(ModBlocks.storageCrate, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.poisonous_potato, 9), new ItemStack(ModBlocks.storageCrate, 1, 2));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.pumpkin_pie, 1), new ItemStack(Items.sugar), new ItemStack(Blocks.pumpkin), new ItemStack(ModItems.dough), new ItemStack(Items.egg));

        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.saltDirt), new ItemStack(ModItems.salt), new ItemStack(Blocks.dirt));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.saltDirt), new ItemStack(ModBlocks.saltDirtLite), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.saltPinch));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.saltGrass), new ItemStack(ModBlocks.saltDirtLite), new ItemStack(Items.wheat_seeds));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blossomPlanks, 4), new ItemStack(ModBlocks.blossomLog));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blossomPlanks, 4), new ItemStack(ModBlocks.blossomStrippedLog));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blossomPlanks, 4), new ItemStack(ModBlocks.blossomWood));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blossomPlanks, 4), new ItemStack(ModBlocks.blossomStrippedWood));

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.royalJelly), new ItemStack(ModItems.beeGrub));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.mineralMud, 4), new ItemStack(ModBlocks.mudBlock));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt, 9), new ItemStack(ModBlocks.saltBlock, 1, OreDictionary.WILDCARD_VALUE));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPinch, 9),  new ItemStack(ModItems.salt));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPinch, 40), new ItemStack(ModBlocks.saltSlab, 1, OreDictionary.WILDCARD_VALUE));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarPinch, 9), new ItemStack(Items.sugar));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.dough, 3), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.sugarPinch), new ItemStack(ModItems.soda), new ItemStack(Items.wheat), new ItemStack(Items.wheat), new ItemStack(Items.wheat), new ItemStack(Items.water_bucket));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.onion, 9), new ItemStack(ModBlocks.storageCrate, 1, 3));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWortSeed, 9), new ItemStack(ModBlocks.storageSack, 1, 3));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltBeefCooked), new ItemStack(ModItems.saltPinch), new ItemStack(Items.cooked_beef) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPorkchopCooked), new ItemStack(ModItems.saltPinch), new ItemStack(Items.cooked_porkchop) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltHaunchCooked), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.haunchCooked) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPotatoBaked), new ItemStack(ModItems.saltPinch), new ItemStack(Items.baked_potato) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltChickenCooked), new ItemStack(ModItems.saltPinch), new ItemStack(Items.cooked_chicken) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishCod), new ItemStack(ModItems.saltPinch), new ItemStack(Items.fish) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishCodCooked), new ItemStack(ModItems.saltPinch), new ItemStack(Items.cooked_fished) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishSalmon), new ItemStack(ModItems.saltPinch), new ItemStack(Items.fish, 1, 1) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishSalmonCooked), new ItemStack(ModItems.saltPinch), new ItemStack(Items.cooked_fished, 1, 1) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishClownfish), new ItemStack(ModItems.saltPinch), new ItemStack(Items.fish, 1, 2) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishClownfishCooked), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.fishClownfishCooked) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltCalamariCooked), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.calamariCooked) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltBread), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bread) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltEgg), new ItemStack(ModItems.saltPinch), new ItemStack(Items.egg) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltMushroomStew), new ItemStack(ModItems.saltPinch), new ItemStack(Items.mushroom_stew) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pumpkinPorridge), new ItemStack(Items.bowl), new ItemStack(Blocks.pumpkin) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPumpkinPorridge), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Blocks.pumpkin) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPumpkinPorridge), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.pumpkinPorridge) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cactusStew), new ItemStack(Items.bowl), new ItemStack(Blocks.cactus), new ItemStack(Blocks.cactus), new ItemStack(Blocks.cactus) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltCactusStew), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Blocks.cactus), new ItemStack(Blocks.cactus), new ItemStack(Blocks.cactus) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltCactusStew), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.cactusStew) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltVegetableStew), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.vegetableStew) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPotatoMushroom), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.potatoMushroom) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.goldenVegetables), new ItemStack(Items.bowl), new ItemStack(Items.golden_carrot), new ItemStack(ModItems.goldenPotato), new ItemStack(ModItems.goldenSaltWortSeed) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltGoldenVegetables), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.goldenVegetables) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltGoldenVegetables), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.golden_carrot), new ItemStack(ModItems.goldenPotato), new ItemStack(ModItems.goldenSaltWortSeed) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fishSoup), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(Items.fish) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishSoup), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(Items.fish) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishSoup), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.fishSoup) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fishSalmonSoup), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(Items.fish, 1, 1) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishSalmonSoup), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(Items.fish, 1, 1) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishSalmonSoup), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.fishSalmonSoup) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fishClownfishSoup), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(Items.fish, 1, 2) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishClownfishSoup), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(Items.fish, 1, 2) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishClownfishSoup), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.fishClownfishSoup) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.dandelionSalad), new ItemStack(Items.bowl), new ItemStack(Items.wheat_seeds), new ItemStack(Blocks.yellow_flower), new ItemStack(ModItems.onion) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltDandelionSalad), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.wheat_seeds), new ItemStack(Blocks.yellow_flower), new ItemStack(ModItems.onion) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltDandelionSalad), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.dandelionSalad) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.wheatSprouts), new ItemStack(Items.bowl), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWheatSprouts), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWheatSprouts), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.wheatSprouts) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWortSalad), new ItemStack(Items.bowl), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.goldenSaltWortSalad), new ItemStack(Items.bowl), new ItemStack(ModItems.goldenSaltWortSeed), new ItemStack(ModItems.goldenSaltWortSeed), new ItemStack(ModItems.goldenSaltWortSeed), new ItemStack(ModItems.goldenSaltWortSeed), new ItemStack(ModItems.goldenSaltWortSeed), new ItemStack(ModItems.goldenSaltWortSeed) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWortBeef), new ItemStack(Items.bowl), new ItemStack(Items.cooked_beef), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWortPorkchop), new ItemStack(Items.bowl), new ItemStack(Items.cooked_porkchop), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWortHoneyedPorkchop), new ItemStack(Items.bowl), new ItemStack(ModItems.honeyedPorkchop), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWortHaunch), new ItemStack(Items.bowl), new ItemStack(ModItems.haunchCooked), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarApple), new ItemStack(ModItems.sugarPinch), new ItemStack(Items.apple) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarMelon), new ItemStack(ModItems.sugarPinch), new ItemStack(Items.melon) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarFruitSalad), new ItemStack(ModItems.sugarPinch), new ItemStack(ModItems.fruitSalad) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarGoldenFruitSalad), new ItemStack(ModItems.sugarPinch), new ItemStack(ModItems.goldenFruitSalad) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.gratedCarrot), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.carrot), new ItemStack(Items.carrot) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarGratedCarrot), new ItemStack(ModItems.sugarPinch), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.carrot), new ItemStack(Items.carrot) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarGratedCarrot), new ItemStack(ModItems.sugarPinch), new ItemStack(ModItems.gratedCarrot) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.melonSoup), new ItemStack(Items.bowl), new ItemStack(Items.melon), new ItemStack(Items.melon), new ItemStack(Items.melon) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarMelonSoup), new ItemStack(ModItems.sugarPinch), new ItemStack(Items.bowl), new ItemStack(Items.melon), new ItemStack(Items.melon), new ItemStack(Items.melon) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarMelonSoup), new ItemStack(ModItems.sugarPinch), new ItemStack(ModItems.melonSoup) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.chocolatePie), new ItemStack(Items.dye, 1, 3), new ItemStack(Items.dye, 1, 3), new ItemStack(ModItems.dough), new ItemStack(Items.egg) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.carrotPie), new ItemStack(Items.sugar), new ItemStack(Items.carrot), new ItemStack(Items.carrot), new ItemStack(Items.egg) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.applePie), new ItemStack(Items.sugar), new ItemStack(Items.apple), new ItemStack(Items.apple), new ItemStack(Items.egg) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.potatoPie), new ItemStack(ModItems.salt), new ItemStack(Items.potato), new ItemStack(Items.potato), new ItemStack(Items.egg) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.onionPie), new ItemStack(ModItems.salt), new ItemStack(ModItems.onion), new ItemStack(ModItems.onion), new ItemStack(Items.egg) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fishPie), new ItemStack(ModItems.salt), new ItemStack(Items.fish), new ItemStack(ModItems.dough), new ItemStack(Items.egg) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fishSalmonPie), new ItemStack(ModItems.salt), new ItemStack(Items.fish, 1, 1), new ItemStack(ModItems.dough), new ItemStack(Items.egg) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fishClownfishPie), new ItemStack(ModItems.salt), new ItemStack(Items.fish, 1, 2), new ItemStack(ModItems.dough), new ItemStack(Items.egg) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.calamariPie), new ItemStack(ModItems.salt), new ItemStack(ModItems.calamariRaw), new ItemStack(ModItems.dough), new ItemStack(Items.egg) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWortPie), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.dough), new ItemStack(Items.egg) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fermentedSaltWort), new ItemStack(Items.ghast_tear), new ItemStack(Items.glass_bottle), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pickledFern), new ItemStack(ModItems.saltPinch), new ItemStack(Items.potionitem), new ItemStack(Blocks.tallgrass, 1, 2), new ItemStack(Blocks.tallgrass, 1, 2) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pickledCalamari), new ItemStack(ModItems.saltPinch), new ItemStack(Items.potionitem), new ItemStack(ModItems.calamariRaw), new ItemStack(ModItems.calamariRaw) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pickledOnion), new ItemStack(ModItems.saltPinch), new ItemStack(Items.potionitem), new ItemStack(ModItems.onion), new ItemStack(ModItems.onion) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.preservedMelon), new ItemStack(ModItems.sugarPinch), new ItemStack(Items.potionitem), new ItemStack(Items.melon), new ItemStack(Items.melon) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.preservedApple), new ItemStack(ModItems.sugarPinch), new ItemStack(Items.potionitem), new ItemStack(Items.apple), new ItemStack(Items.apple) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cobblerConcoction), new ItemStack(Items.ghast_tear), new ItemStack(Items.glass_bottle), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.sugarPinch), new ItemStack(ModItems.soda), new ItemStack(Items.dye, 1, 3), new ItemStack(ModItems.mineralMud), new ItemStack(Items.redstone), new ItemStack(Items.glowstone_dust) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fizzyDrink), new ItemStack(ModItems.soda), new ItemStack(Items.potionitem) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.rainmakerStar), new ItemStack(Items.gunpowder), new ItemStack(ModItems.salt), new ItemStack(ModItems.salt), new ItemStack(ModItems.salt), new ItemStack(ModItems.salt), new ItemStack(ModItems.soda), new ItemStack(ModItems.soda), new ItemStack(ModItems.soda), new ItemStack(ModItems.soda) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.rainmaker), new ItemStack(ModItems.rainmakerStar), new ItemStack(ModItems.rainmakerStar), new ItemStack(ModItems.rainmakerStar), new ItemStack(ModItems.rainmakerStar), new ItemStack(ModItems.rainmakerStar), new ItemStack(Items.paper), new ItemStack(Items.gunpowder), new ItemStack(Items.gunpowder), new ItemStack(Items.gunpowder) );
    }
}
