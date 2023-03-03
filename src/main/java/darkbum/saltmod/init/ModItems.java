package darkbum.saltmod.init;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltmod.items.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import darkbum.saltmod.SaltMod;
import darkbum.saltmod.common.CommonProxy;

public class ModItems {
    static CreativeTabs tab = CommonProxy.saltTab;

    public static Item hungerFood = new HungerFood("hungerFood", tab, "HungerFood").setTextureName("saltmod:" + "dev/" + "hunger_food");

    public static Item stuffedFood = new StuffedFood("stuffedFood", tab, "StuffedFood").setTextureName("saltmod:" + "dev/" + "stuffed_food");

    public static Item effectFoodPos = new EffectFoodPos("effectFoodPos", tab, "EffectFoodPos").setTextureName("saltmod:" + "dev/" + "positive_effect_food");

    public static Item effectFoodNeg = new EffectFoodNeg("effectFoodNeg", tab, "EffectFoodNeg").setTextureName("saltmod:" + "dev/" + "negative_effect_food");

//    field_76434_w = Health Boost
//    field_76443_y = Saturation
//    field_76444_x = Absorption
//    public static Item testFood = new SaltFood("testFood", 8, 0.6F, Items.glass_bottle).setAlwaysEdible().setCreativeTab(tab).setTextureName("saltmod:" + "dev/" + "test_food");

    public static Item achievItem = new AchievItem("achievItem", null);

    public static Item blossom = new MainItems("blossom", tab, "blossom");

    public static Item queenBee = new MainItems("queenBee", tab, "queen_bee");

    public static Item waxComb = new MainItems("waxComb", tab, "waxcomb");

    public static Item honeyComb = new MainItems("honeyComb", tab, "honeycomb");

    public static Item beeGrub = new MainItems("beeGrub", tab, "bee_grub");

    public static Item royalJelly = new MainItems("royalJelly", tab, "royal_jelly");

    public static Item mineralMud = new MainItems("mineralMud", tab, "mineral_mud");

    public static Item soda = new MainItems("soda", tab, "baking_soda");

    public static Item powderedMilk = new MainItems("powderedMilk", tab, "powdered_milk");

    public static Item salt = new Salt("salt", tab, "salt");

    public static Item saltPinch = new MainItems("saltPinch", tab, "salt_pinch");

    public static Item sugarPinch = new MainItems("sugarPinch", tab, "sugar_pinch");

    public static Item dough = new Dough("dough", tab, "dough");

    public static Item onion = new ItemSeedFood(2, 0.2F, ModBlocks.cropOnion, Blocks.farmland).setUnlocalizedName("onion").setCreativeTab(tab).setTextureName("saltmod:onion");

    public static Item saltWortSeed = new SaltWortSeed("saltWortSeed", tab);

    public static Item goldenSaltWortSeed = new SaltFood("goldenSaltWortSeed", 6, 0.8F, new PotionEffect(Potion.regeneration.id, 80, 1) ).setCreativeTab(tab).setTextureName("saltmod:glistering_saltwort");

    public static Item goldenPotato = (new SaltFood("goldenPotato", 6, 0.9F, new PotionEffect(Potion.regeneration.id, 60, 0) ).setCreativeTab(tab).setTextureName("saltmod:glistering_potato"));

    public static Item goldenBerries = (new SaltFood("goldenBerries", 2, 1.2F).setCreativeTab(tab).setTextureName("saltmod:glistering_berries"));

    public static Item saltBeefCooked = new SaltFood("saltBeefCooked", 9, 0.9F).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_beef");

    public static Item saltPorkchopCooked = new SaltFood("saltPorkchopCooked", 9, 0.9F).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_porkchop");

    public static Item saltMuttonCooked = new SaltFood("saltMuttonCooked", 7, 0.9F).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_mutton");

    public static Item saltStriderCooked = new SaltFood("saltStriderCooked", 9, 0.9F).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_strider");

    public static Item haunchRaw = new SaltFood("haunchRaw", 3, 0.3F).setCreativeTab(tab).setTextureName("saltmod:haunch");

    public static Item haunchCooked = new SaltFood("haunchCooked", 8, 0.8F).setCreativeTab(tab).setTextureName("saltmod:cooked_haunch");

    public static Item saltHaunchCooked = new SaltFood("saltHaunchCooked", 9, 0.9F).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_haunch");

    public static Item saltPotatoBaked = new SaltFood("saltPotatoBaked", 7, 0.7F).setCreativeTab(tab).setTextureName("saltmod:salt_baked_potato");

    public static Item saltChickenCooked = new SaltFood("saltChickenCooked", 7, 0.7F).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_chicken");

    public static Item saltRabbitCooked = new SaltFood("saltRabbitCooked", 6, 0.7F).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_rabbit");

    public static Item saltFishCod = new SaltFood("saltFishCod", 5, 0.2F).setCreativeTab(tab).setTextureName("saltmod:salt_cod");

    public static Item saltFishCodCooked = new SaltFood("saltFishCodCooked", 6, 0.7F).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_cod");

    public static Item saltFishSalmon = new SaltFood("saltFishSalmon", 6, 0.2F).setCreativeTab(tab).setTextureName("saltmod:salt_salmon");

    public static Item saltFishSalmonCooked = new SaltFood("saltFishSalmonCooked", 7, 0.9F).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_salmon");

    public static Item fishClownfishCooked = new SaltFood("fishClownfishCooked", 4, 0.6F).setCreativeTab(tab).setTextureName("saltmod:cooked_tropical_fish");

    public static Item saltFishClownfish = new SaltFood("saltFishClownfish", 4, 0.2F).setCreativeTab(tab).setTextureName("saltmod:salt_tropical_fish");

    public static Item saltFishClownfishCooked = new SaltFood("saltFishClownfishCooked", 5, 0.7F).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_tropical_fish");

    public static Item calamariRaw = new SaltFood("calamariRaw", 2, 0.1F).setCreativeTab(tab).setTextureName("saltmod:calamari");

    public static Item calamariCooked = new SaltFood("calamariCooked", 5, 0.6F).setCreativeTab(tab).setTextureName("saltmod:cooked_calamari");

    public static Item saltCalamariCooked = new SaltFood("saltCalamariCooked", 6, 0.6F).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_calamari");

    public static Item cornedBeef = new SaltFood("cornedBeef", 5, 1.2F).setCreativeTab(tab).setTextureName("saltmod:cured_meat");

    public static Item saltBread = new SaltFood("saltBread", 6, 0.7F).setCreativeTab(tab).setTextureName("saltmod:salt_bread");

    public static Item saltBeetroot = new SaltFood("saltBeetroot", 2, 0.7F).setCreativeTab(tab).setTextureName("saltmod:salt_beetroot");

    public static Item saltEgg = new SaltFood("saltEgg", 3, 0.4F).setMaxStackSize(16).setCreativeTab(tab).setTextureName("saltmod:salt_egg");

    public static Item saltMushroomStew = new SaltFood("saltMushroomStew", 7, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_mushroom_stew");

    public static Item saltRabbitStew = new SaltFood("saltRabbitStew", 11, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_rabbit_ragout");

    public static Item saltBeetrootSoup = new SaltFood("saltBeetrootSoup", 7, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_borscht");

    public static Item pumpkinPorridge = new SaltFood("pumpkinPorridge", 6, 0.6F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:pumpkin_porridge");

    public static Item saltPumpkinPorridge = new SaltFood("saltPumpkinPorridge", 7, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_pumpkin_porridge");

    public static Item cactusStew = new SaltFood("cactusStew", 3, 0.6F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 400, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:cactus_stew");

    public static Item saltCactusStew = new SaltFood("saltCactusStew", 4, 0.7F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 800, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_cactus_stew");

    public static Item vegetableStew = new SaltFood("vegetableStew", 5, 0.6F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:stewed_vegetables");

    public static Item saltVegetableStew = new SaltFood("saltVegetableStew", 6, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_stewed_vegetables");

    public static Item potatoMushroom = new SaltFood("potatoMushroom", 5, 0.6F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:potato_mushroom");

    public static Item saltPotatoMushroom = new SaltFood("saltPotatoMushroom", 6, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_potato_mushroom");

    public static Item goldenVegetables = new SaltFood("goldenVegetables", 6, 1.2F, Items.bowl, new PotionEffect(Potion.regeneration.id, 80, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:glistering_vegetables");

    public static Item saltGoldenVegetables = new SaltFood("saltGoldenVegetables", 7, 1.2F, Items.bowl, new PotionEffect(Potion.regeneration.id, 100, 2)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_glistering_vegetables");

    public static Item fishSoup = new SaltFood("fishSoup", 6, 0.6F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:cod_soup");

    public static Item saltFishSoup = new SaltFood("saltFishSoup", 7, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_cod_soup");

    public static Item fishSalmonSoup = new SaltFood("fishSalmonSoup", 7, 0.8F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salmon_soup");

    public static Item saltFishSalmonSoup = new SaltFood("saltFishSalmonSoup", 8, 0.9F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_salmon_soup");

    public static Item fishClownfishSoup = new SaltFood("fishClownfishSoup", 4, 0.6F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:tropical_fish_soup");

    public static Item saltFishClownfishSoup = new SaltFood("saltFishClownfishSoup", 5, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_tropical_fish_soup");

    public static Item dandelionSalad = new SaltFood("dandelionSalad", 4, 0.6F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 800, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:dandelion_salad");

    public static Item saltDandelionSalad = new SaltFood("saltDandelionSalad", 5, 0.7F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 1200, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_dandelion_salad");

    public static Item wheatSprouts = new SaltFood("wheatSprouts", 3, 0.6F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 600, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:wheat_sprouts");

    public static Item saltWheatSprouts = new SaltFood("saltWheatSprouts", 4, 0.7F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 900, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_wheat_sprouts");

    public static Item beetrootSalad = new SaltFood("beetrootSalad", 5, 0.4F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:beetroot_salad");

    public static Item saltBeetrootSalad = new SaltFood("saltBeetrootSalad", 6, 0.5F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_beetroot_salad");

    public static Item herringUFC = new SaltFood("herringUFC", 8, 0.9F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:dressed_herring");

    public static Item saltHerringUFC = new SaltFood("saltHerringUFC", 9, 1.0F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_dressed_herring");

    public static Item saltWortSalad = new SaltFood("saltWortSalad", 6, 0.4F, Items.bowl, new PotionEffect(Potion.regeneration.id, 200, 1)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:saltwort_salad");

    public static Item goldenSaltWortSalad = new SaltFood("goldenSaltWortSalad", 7, 1.2F, Items.bowl, new PotionEffect(Potion.regeneration.id, 400, 1)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:glistering_saltwort_salad");

    public static Item saltWortBeef = new SaltFood("saltWortBeef", 10, 0.9F, Items.bowl, new PotionEffect(Potion.regeneration.id, 400, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:saltwort_cooked_beef");

    public static Item saltWortPorkchop = new SaltFood("saltWortPorkchop", 10, 0.9F, Items.bowl, new PotionEffect(Potion.regeneration.id, 400, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:saltwort_cooked_porkchop");

    public static Item saltWortHoneyedPorkchop = new SaltFood("saltWortHoneyedPorkchop", 9, 0.9F, Items.bowl, new PotionEffect(Potion.regeneration.id, 400, 1), new PotionEffect(Potion.field_76444_x.id, 900, 2)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:saltwort_honey_porkchop");

    public static Item saltWortMutton = new SaltFood("saltWortMutton", 8, 0.9F, Items.bowl, new PotionEffect(Potion.regeneration.id, 400, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:saltwort_cooked_mutton");

    public static Item saltWortHaunch = new SaltFood("saltWortHaunch", 10, 0.9F, Items.bowl, new PotionEffect(Potion.regeneration.id, 400, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:saltwort_cooked_haunch");

    public static Item sugarApple = new SaltFood("sugarApple", 5, 0.4F).setCreativeTab(tab).setTextureName("saltmod:sugar_apple");

    public static Item sugarMelon = new SaltFood("sugarMelon", 3, 0.4F).setCreativeTab(tab).setTextureName("saltmod:sugar_melon_slice");

    public static Item sugarBerries = new SaltFood("sugarBerries", 3, 0.2F).setCreativeTab(tab).setTextureName("saltmod:sugar_sweet_berries");

    public static Item fruitSalad = new SaltFood("fruitSalad", 5, 0.4F, Items.bowl, new PotionEffect(Potion.moveSpeed.id, 900, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:fruit_salad");

    public static Item sugarFruitSalad = new SaltFood("sugarFruitSalad", 6, 0.5F, Items.bowl, new PotionEffect(Potion.moveSpeed.id, 1200, 1)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:sugar_fruit_salad");

    public static Item goldenFruitSalad = new SaltFood("goldenFruitSalad", 5, 0.8F, Items.bowl, new PotionEffect(Potion.regeneration.id, 100, 1), new PotionEffect(Potion.field_76444_x.id, 2400), new PotionEffect(Potion.heal.id, 1)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:glistering_fruit_salad");

    public static Item sugarGoldenFruitSalad = new SaltFood("sugarGoldenFruitSalad", 6, 0.8F, Items.bowl, new PotionEffect(Potion.regeneration.id, 125, 2), new PotionEffect(Potion.field_76444_x.id, 3000, 1), new PotionEffect(Potion.heal.id, 1, 1)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:sugar_glistering_fruit_salad");

    public static Item gratedCarrot = new SaltFood("gratedCarrot", 5, 0.4F, Items.bowl, new PotionEffect(Potion.nightVision.id, 900, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:grated_carrot");

    public static Item sugarGratedCarrot = new SaltFood("sugarGratedCarrot", 6, 0.5F, Items.bowl, new PotionEffect(Potion.nightVision.id, 1200, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:sugar_grated_carrot");

    public static Item melonSoup = new SaltFood("melonSoup", 4, 0.4F, Items.bowl, new PotionEffect(Potion.jump.id, 900, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:melon_soup");

    public static Item sugarMelonSoup = new SaltFood("sugarMelonSoup", 4, 0.4F, Items.bowl, new PotionEffect(Potion.jump.id, 1200, 1)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:sugar_melon_soup");

    public static Item honeyedBerries = new SaltFood("honeyedBerries", 2, 0.2F, new PotionEffect(Potion.field_76444_x.id, 300)).setCreativeTab(tab).setTextureName("saltmod:honey_berries");

    public static Item honeyedApple = new SaltFood("honeyedApple", 4, 0.4F, new PotionEffect(Potion.field_76444_x.id, 600, 1)).setCreativeTab(tab).setTextureName("saltmod:honey_apple");

    public static Item honeyedPorkchop = new SaltFood("honeyedPorkchop", 8, 0.9F, new PotionEffect(Potion.field_76444_x.id, 900, 2)).setCreativeTab(tab).setTextureName("saltmod:honey_porkchop");

    public static Item chocolateBerries = new SaltFood("chocolateBerries", 2, 0.2F, new PotionEffect(Potion.digSpeed.id, 300, 0)).setCreativeTab(tab).setTextureName("saltmod:chocolate_berries");

    public static Item chocolateBar = new ChocolateBar("chocolateBar", tab, "chocolate_bar");

    public static Item chocolatePie = new SaltFood("chocolatePie", 7, 0.3F, new PotionEffect(Potion.digSpeed.id, 900, 2)).setCreativeTab(tab).setTextureName("saltmod:chocolate_pie");

    public static Item carrotPie = new SaltFood("carrotPie", 8, 0.3F).setCreativeTab(tab).setTextureName("saltmod:carrot_pie");

    public static Item applePie = new SaltFood("applePie", 8, 0.3F).setCreativeTab(tab).setTextureName("saltmod:apple_pie");

    public static Item sweetberryPie = new SaltFood("sweetberryPie", 7, 0.3F).setCreativeTab(tab).setTextureName("saltmod:sweetberry_pie");

    public static Item potatoPie = new SaltFood("potatoPie", 8, 0.3F).setCreativeTab(tab).setTextureName("saltmod:potato_pie");

    public static Item onionPie = new SaltFood("onionPie", 7, 0.3F).setCreativeTab(tab).setTextureName("saltmod:onion_pie");

    public static Item fishPie = new SaltFood("fishPie", 8, 0.6F).setCreativeTab(tab).setTextureName("saltmod:cod_pie");

    public static Item fishSalmonPie = new SaltFood("fishSalmonPie", 9, 0.6F).setCreativeTab(tab).setTextureName("saltmod:salmon_pie");

    public static Item fishClownfishPie = new SaltFood("fishClownfishPie", 8, 0.6F).setCreativeTab(tab).setTextureName("saltmod:tropical_fish_pie");

    public static Item calamariPie = new SaltFood("calamariPie", 8, 0.6F).setCreativeTab(tab).setTextureName("saltmod:calamari_pie");

    public static Item shepherdsPie = new SaltFood("shepherdsPie", 10, 0.8F).setCreativeTab(tab).setTextureName("saltmod:shepherds_pie");

    public static Item mushroomPie = new SaltFood("mushroomPie", 8, 0.3F).setCreativeTab(tab).setTextureName("saltmod:mushroom_pie");

    public static Item saltWortPie = new SaltFood("saltWortPie", 6, 0.3F, new PotionEffect(Potion.regeneration.id, 100, 0)).setAlwaysEdible().setCreativeTab(tab).setTextureName("saltmod:saltwort_pie");

    public static Item fermentedSaltWort = new SaltFood("fermentedSaltWort", 5, 0.8F, Items.glass_bottle, new PotionEffect(Potion.regeneration.id, 600, 2)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:fermented_saltwort");

    public static Item pickledMushroom = new SaltFood("pickledMushroom", 6, 0.8F, Items.glass_bottle).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:pickled_mushroom");

    public static Item pickledFern = new SaltFood("pickledFern", 4, 0.8F, Items.glass_bottle, new PotionEffect(Potion.resistance.id, 800, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:pickled_fern");

    public static Item pickledCalamari = new SaltFood("pickledCalamari", 6, 0.8F, Items.glass_bottle).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:pickled_calamari");

    public static Item pickledOnion = new SaltFood("pickledOnion", 6, 0.8F, Items.glass_bottle, new PotionEffect(Potion.resistance.id, 800, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:pickled_onion");

    public static Item pickledBeetroot = new SaltFood("pickledBeetroot", 5, 0.8F, Items.glass_bottle).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:pickled_beetroot");

    public static Item preservedMelon = new SaltFood("preservedMelon", 6, 0.8F, Items.glass_bottle).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:melon_preserves");

    public static Item preservedSweetberries = new SaltFood("preservedSweetberries", 6, 0.8F, Items.glass_bottle).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:sweet_berry_preserves");

    public static Item preservedApple = new SaltFood("preservedApple", 8, 0.8F, Items.glass_bottle).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:apple_preserves");

    public static Item cobblerConcoction = new CobblerConcoction("cobblerConcoction", tab, "cobbler_concoction");

    public static Item fizzyDrink = new FizzyDrink("fizzyDrink", tab, "fizzy_drink");

    public static Item muffin = new Muffin("muffin", tab, "muffin");

    public static Item hemoglobin = new SaltFood("hemoglobin", 2, 4.0F, new PotionEffect(Potion.heal.id, 1, 1)).setAlwaysEdible().setCreativeTab(tab).setTextureName("saltmod:hemoglobin");

    public static Item mudHelmet = new MudArmor("mud_helmet", CommonProxy.mudMaterial, 0);

    public static Item mudChestplate = new MudArmor("mud_chestplate", CommonProxy.mudMaterial, 1);

    public static Item mudLeggings = new MudArmor("mud_leggings", CommonProxy.mudMaterial, 2);

    public static Item mudBoots = new MudArmor("mud_boots", CommonProxy.mudMaterial, 3);

    public static Item toughJelly = new ToughJelly("toughJelly", tab, "tough_jelly");

    public static Item rainmakerStar = new MainItems("rainmakerStar", tab, "rainmaker_star");

    public static Item rainmaker = new Rainmaker("rainmaker", tab, "rainmaker");


    public static Item tf_saltVenisonCooked = new SaltFood("tf_saltVenisonCooked", 9, 0.9F).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "tf_saltwort_cooked_venison");

    public static Item tf_saltMeefSteak = new SaltFood("tf_saltMeefSteak", 7, 0.7F).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "tf_salt_meef_steak");

    public static Item tf_saltMeefStroganoff = new SaltFood("tf_saltMeefStroganoff", 9, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "tf_salt_meef_stroganoff");

    public static Item tf_saltHydraChop = new SaltFood("tf_saltHydraChop", 19, 2.1F).setPotionEffect(Potion.regeneration.id, 5, 0, 1.0F).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "tf_salt_hydra_chop");

    public static Item tf_pickledMushgloom = new SaltFood("tf_pickledMushgloom", 6, 0.8F, Items.glass_bottle, new PotionEffect(Potion.nightVision.id, 1200, 0), new PotionEffect(Potion.moveSlowdown.id, 100, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "tf_pickled_mushgloom");

    public static Item tf_saltWortVenison = new SaltFood("tf_saltWortVenison", 10, 0.9F, Items.bowl, new PotionEffect(Potion.regeneration.id, 100, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "tf_saltwort_cooked_venison");

    public static Item tf_saltWortMeefSteak = new SaltFood("tf_saltWortMeefSteak", 8, 0.9F, Items.bowl, new PotionEffect(Potion.regeneration.id, 100, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "tf_saltwort_meef_steak");

    public static Item bop_poison = new MainItems("bop_poison", tab, "BOP_Poison").setTextureName("saltmod:" + "bop/" + "bop_poison");

    public static Item bop_saltShroomPowder = ((ItemFood)(new SaltFood("bop_saltShroomPowder", 2, 0.2F)).setAlwaysEdible().setCreativeTab(tab)).setPotionEffect(Potion.confusion.id, 15, 0, 0.3F).setTextureName("saltmod:" + "bop/" + "bop_salt_shroom_powder");

    public static Item bop_sugarSaladFruit = ((ItemFood)(new SaltFood("bop_sugarSaladFruit", 7, 0.7F, Items.bowl)).setMaxStackSize(1).setCreativeTab(tab)).setPotionEffect(Potion.digSpeed.id, 1200, 2, 0.1F).setTextureName("saltmod:" + "bop/" + "bop_sugar_fruit_salad");

    public static Item bop_saltSaladVeggie = ((ItemFood)(new SaltFood("bop_saltSaladVeggie", 7, 0.7F, Items.bowl)).setMaxStackSize(1).setCreativeTab(tab)).setPotionEffect(Potion.field_76434_w.id, 1550, 2, 0.1F).setTextureName("saltmod:" + "bop/" + "bop_salt_veggie_salad");

    public static Item bop_saltSaladShroom = ((ItemFood)(new SaltFood("bop_saltSaladShroom", 7, 0.7F, Items.bowl)).setMaxStackSize(1).setCreativeTab(tab)).setPotionEffect(Potion.jump.id, 900, 2, 0.1F).setTextureName("saltmod:" + "bop/" + "bop_salt_shroom_salad");

    public static Item bop_saltRiceBowl = new SaltFood("bop_saltRiceBowl", 3, 0.2F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:" + "bop/" + "bop_salt_rice_bowl");

    public static Item bop_pickledTurnip = new SaltFood("bop_pickledTurnip", 6, 0.8F, Items.glass_bottle).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:" + "bop/" + "bop_pickled_turnip");

    public static void init() {
        SaltMod.logger.info("Start to initialize Items");

        GameRegistry.registerItem(hungerFood, "hungerFood");
        GameRegistry.registerItem(stuffedFood, "stuffedFood");
        GameRegistry.registerItem(effectFoodPos, "effectFoodPos");
        GameRegistry.registerItem(effectFoodNeg, "effectFoodNeg");
//        GameRegistry.registerItem(testFood, "testFood");
        GameRegistry.registerItem(achievItem, "achivItem");
        GameRegistry.registerItem(blossom, "blossom");
        GameRegistry.registerItem(queenBee, "queenBee");
        GameRegistry.registerItem(waxComb, "waxComb");
        GameRegistry.registerItem(honeyComb, "honeyComb");
        GameRegistry.registerItem(beeGrub, "beeGrub");
        GameRegistry.registerItem(royalJelly, "royalJelly");
        GameRegistry.registerItem(mineralMud, "mineralMud");
        GameRegistry.registerItem(soda, "soda");
        GameRegistry.registerItem(powderedMilk, "powderedMilk");
        GameRegistry.registerItem(salt, "salt");
        GameRegistry.registerItem(saltPinch, "saltPinch");
        GameRegistry.registerItem(sugarPinch, "sugarPinch");
        GameRegistry.registerItem(dough, "dough");
        GameRegistry.registerItem(onion, "onion");
        GameRegistry.registerItem(saltWortSeed, "saltWortSeed");
        GameRegistry.registerItem(goldenSaltWortSeed, "goldenSaltWortSeed");
        GameRegistry.registerItem(goldenPotato, "goldenPotato");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(goldenBerries, "goldenBerries");
        }
        GameRegistry.registerItem(saltBeefCooked, "saltBeefCooked");
        GameRegistry.registerItem(saltPorkchopCooked, "saltPorkchopCooked");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(saltMuttonCooked, "saltMuttonCooked");
        }
        if(Loader.isModLoaded("netherlicious")) {
            GameRegistry.registerItem(saltStriderCooked, "saltStriderCooked");
        }
        GameRegistry.registerItem(haunchRaw, "haunchRaw");
        GameRegistry.registerItem(haunchCooked, "haunchCooked");
        GameRegistry.registerItem(saltHaunchCooked, "saltHaunchCooked");
        GameRegistry.registerItem(saltPotatoBaked, "saltPotatoBaked");
        GameRegistry.registerItem(saltChickenCooked, "saltChickenCooked");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(saltRabbitCooked, "saltRabbitCooked");
        }
        GameRegistry.registerItem(saltFishCod, "saltFishCod");
        GameRegistry.registerItem(saltFishCodCooked, "saltFishCodCooked");
        GameRegistry.registerItem(saltFishSalmon, "saltFishSalmon");
        GameRegistry.registerItem(saltFishSalmonCooked, "saltFishSalmonCooked");
        GameRegistry.registerItem(fishClownfishCooked, "fishClownfishCooked");
        GameRegistry.registerItem(saltFishClownfish, "saltFishClownfish");
        GameRegistry.registerItem(saltFishClownfishCooked, "saltFishClownfishCooked");
        GameRegistry.registerItem(calamariRaw, "calamariRaw");
        GameRegistry.registerItem(calamariCooked, "calamariCooked");
        GameRegistry.registerItem(saltCalamariCooked, "saltCalamariCooked");
        GameRegistry.registerItem(cornedBeef, "cornedBeef");
        GameRegistry.registerItem(saltBread, "saltBread");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(saltBeetroot, "saltBeetroot");
        }
        GameRegistry.registerItem(saltEgg, "saltEgg");
        GameRegistry.registerItem(saltMushroomStew, "saltMushroomStew");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(saltRabbitStew, "saltRabbitStew");
            GameRegistry.registerItem(saltBeetrootSoup, "saltBeetrootSoup");
        }
        GameRegistry.registerItem(pumpkinPorridge, "pumpkinPorridge");
        GameRegistry.registerItem(saltPumpkinPorridge, "saltPumpkinPorridge");
        GameRegistry.registerItem(cactusStew, "cactusStew");
        GameRegistry.registerItem(saltCactusStew, "saltCactusStew");
        GameRegistry.registerItem(vegetableStew, "vegetableStew");
        GameRegistry.registerItem(saltVegetableStew, "saltVegetableStew");
        GameRegistry.registerItem(potatoMushroom, "potatoMushroom");
        GameRegistry.registerItem(saltPotatoMushroom, "saltPotatoMushroom");
        GameRegistry.registerItem(goldenVegetables, "goldenVegetables");
        GameRegistry.registerItem(saltGoldenVegetables, "saltGoldenVegetables");
        GameRegistry.registerItem(fishSoup, "fishSoup");
        GameRegistry.registerItem(saltFishSoup, "saltFishSoup");
        GameRegistry.registerItem(fishSalmonSoup, "fishSalmonSoup");
        GameRegistry.registerItem(saltFishSalmonSoup, "saltFishSalmonSoup");
        GameRegistry.registerItem(fishClownfishSoup, "fishClownfishSoup");
        GameRegistry.registerItem(saltFishClownfishSoup, "saltFishClownfishSoup");
        GameRegistry.registerItem(dandelionSalad, "dandelionSalad");
        GameRegistry.registerItem(saltDandelionSalad, "saltDandelionSalad");
        GameRegistry.registerItem(wheatSprouts, "wheatSprouts");
        GameRegistry.registerItem(saltWheatSprouts, "saltWheatSprouts");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(beetrootSalad, "beetrootSalad");
            GameRegistry.registerItem(saltBeetrootSalad, "saltBeetrootSalad");
            GameRegistry.registerItem(herringUFC, "herringUFC");
            GameRegistry.registerItem(saltHerringUFC, "saltHerringUFC");
        }
        GameRegistry.registerItem(saltWortSalad, "saltWortSalad");
        GameRegistry.registerItem(goldenSaltWortSalad, "goldenSaltWortSalad");
        GameRegistry.registerItem(saltWortBeef, "saltWortBeef");
        GameRegistry.registerItem(saltWortPorkchop, "saltWortPorkchop");
        GameRegistry.registerItem(saltWortHoneyedPorkchop, "saltWortHoneyedPorkchop");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(saltWortMutton, "saltWortMutton");
        }
        GameRegistry.registerItem(saltWortHaunch, "saltWortHaunch");
        GameRegistry.registerItem(sugarApple, "sugarApple");
        GameRegistry.registerItem(sugarMelon, "sugarMelon");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(sugarBerries, "sugarBerries");
        }
        GameRegistry.registerItem(fruitSalad, "fruitSalad");
        GameRegistry.registerItem(sugarFruitSalad, "sugarFruitSalad");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(goldenFruitSalad, "goldenFruitSalad");
            GameRegistry.registerItem(sugarGoldenFruitSalad, "sugarGoldenFruitSalad");
        }
        GameRegistry.registerItem(gratedCarrot, "gratedCarrot");
        GameRegistry.registerItem(sugarGratedCarrot, "sugarGratedCarrot");
        GameRegistry.registerItem(melonSoup, "melonSoup");
        GameRegistry.registerItem(sugarMelonSoup, "sugarMelonSoup");
        GameRegistry.registerItem(honeyedBerries, "honeyedBerries");
        GameRegistry.registerItem(honeyedApple, "honeyedApple");
        GameRegistry.registerItem(honeyedPorkchop, "honeyedPorkchop");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(chocolateBerries, "chocolateBerries");
        }
        GameRegistry.registerItem(chocolateBar, "chocolateBar");
        GameRegistry.registerItem(chocolatePie, "chocolatePie");
        GameRegistry.registerItem(carrotPie, "carrotPie");
        GameRegistry.registerItem(applePie, "applePie");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(sweetberryPie, "sweetberryPie");
        }
        GameRegistry.registerItem(potatoPie, "potatoPie");
        GameRegistry.registerItem(onionPie, "onionPie");
        GameRegistry.registerItem(fishPie, "fishPie");
        GameRegistry.registerItem(fishSalmonPie, "fishSalmonPie");
        GameRegistry.registerItem(fishClownfishPie, "fishClownfishPie");
        GameRegistry.registerItem(calamariPie, "calamariPie");
        GameRegistry.registerItem(shepherdsPie, "shepherdsPie");
        GameRegistry.registerItem(mushroomPie, "mushroomPie");
        GameRegistry.registerItem(saltWortPie, "saltWortPie");
        GameRegistry.registerItem(fermentedSaltWort, "fermentedSaltWort");
        GameRegistry.registerItem(pickledMushroom, "pickledMushroom");
        GameRegistry.registerItem(pickledFern, "pickledFern");
        GameRegistry.registerItem(pickledCalamari, "pickledCalamari");
        GameRegistry.registerItem(pickledOnion, "pickledOnion");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(pickledBeetroot, "pickledBeetroot");
        }
        GameRegistry.registerItem(preservedMelon, "preservedMelon");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(preservedSweetberries, "preservedSweetberries");
        }
        GameRegistry.registerItem(preservedApple, "preservedApple");
        GameRegistry.registerItem(cobblerConcoction, "cobblerConcoction");
        GameRegistry.registerItem(fizzyDrink, "fizzyDrink");
        GameRegistry.registerItem(muffin, "muffin");
        GameRegistry.registerItem(mudHelmet, "mudHelmet");
        GameRegistry.registerItem(mudChestplate, "mudChestplate");
        GameRegistry.registerItem(mudLeggings, "mudLeggings");
        GameRegistry.registerItem(mudBoots, "mudBoots");
        GameRegistry.registerItem(toughJelly, "toughJelly");
        GameRegistry.registerItem(rainmakerStar, "rainmakerStar");
        GameRegistry.registerItem(rainmaker, "rainmaker");

        if(Loader.isModLoaded("TwilightForest")) {
            GameRegistry.registerItem(tf_saltVenisonCooked, "tf_saltVenisonCooked");
            GameRegistry.registerItem(tf_saltMeefSteak, "tf_saltMeefSteak");
            GameRegistry.registerItem(tf_saltMeefStroganoff, "stf_altMeefStroganoff");
            GameRegistry.registerItem(tf_saltHydraChop, "tf_saltHydraChop");
            GameRegistry.registerItem(tf_pickledMushgloom, "tf_pickledMushgloom");
            GameRegistry.registerItem(tf_saltWortVenison, "tf_saltWortVenison");
            GameRegistry.registerItem(tf_saltWortMeefSteak, "tf_saltWortMeefSteak");
        }
        if(Loader.isModLoaded("BiomesOPlenty")) {
            GameRegistry.registerItem(bop_poison, "bop_poison");
            GameRegistry.registerItem(bop_saltShroomPowder, "bop_saltShroomPowder");
            GameRegistry.registerItem(bop_sugarSaladFruit, "bop_sugarSaladFruit");
            GameRegistry.registerItem(bop_saltSaladVeggie, "bop_saltSaladVeggie");
            GameRegistry.registerItem(bop_saltSaladShroom, "bop_saltSaladShroom");
            GameRegistry.registerItem(bop_saltRiceBowl, "bop_saltRiceBowl");
            GameRegistry.registerItem(bop_pickledTurnip, "bop_pickledTurnip");
        }

        SaltMod.logger.info("Finished initializing Items");
    }
}
