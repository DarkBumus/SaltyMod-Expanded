package darkbum.saltmod.init;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltmod.blockitems.ItemBlossomSign;
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
    public static Item testFood = new SaltFood("testFood", 2, 0.3F, new PotionEffect(Potion.field_76443_y.id, 300)).setAlwaysEdible().setCreativeTab(tab).setTextureName("saltmod:" + "dev/" + "test_food");

    public static Item achievItem = new AchievItem("achievItem", null);

    public static Item blossom = new SaltItems("blossom", tab, "blossom");

    public static Item queenBee = new SaltItems("queenBee", tab, "queen_bee").setMaxStackSize(1).setMaxDamage(18);

    public static Item waxComb = new SaltItems("waxComb", tab, "waxcomb");

    public static Item honeyComb = new SaltItems("honeyComb", tab, "honeycomb");

    public static Item beeGrub = new SaltItems("beeGrub", tab, "bee_grub");

    public static Item royalJelly = new SaltItems("royalJelly", tab, "royal_jelly");

    public static Item mineralMud = new SaltItems("mineralMud", tab, "mineral_mud");

    public static Item soda = new SaltItems("soda", tab, "baking_soda");

    public static Item powderedMilk = new SaltItems("powderedMilk", tab, "powdered_milk");

    public static Item salt = new Salt("salt", tab, "salt");

    public static Item saltPinch = new SaltItems("saltPinch", tab, "salt_pinch");

    public static Item sugarPinch = new SaltItems("sugarPinch", tab, "sugar_pinch");

    public static Item dough = new Dough("dough", tab, "dough");

    public static Item onion = new ItemSeedFood(2, 0.3F, ModBlocks.cropOnion, Blocks.farmland).setUnlocalizedName("onion").setCreativeTab(tab).setTextureName("saltmod:onion");

    public static Item saltWortSeed = new SaltWortSeed("saltWortSeed", tab);

    public static Item goldenSaltWortSeed = new SaltFood("goldenSaltWortSeed", 6, 1.2F, new PotionEffect(Potion.regeneration.id, 60, 2)).setCreativeTab(tab).setTextureName("saltmod:glistering_saltwort");

    public static Item goldenPotato = new SaltFood("goldenPotato", 6, 1.2F).setCreativeTab(tab).setTextureName("saltmod:glistering_potato");

    public static Item goldenBerries = new GoldenBerries(3, 0.6F, false).setAlwaysEdible().setPotionEffect(Potion.regeneration.id, 5, 1, 1.0F).setUnlocalizedName("goldenBerries").setCreativeTab(tab).setTextureName("saltmod:glistering_berries");

    public static Item saltPorkchopCooked = new SaltFood("saltPorkchopCooked", 6, 0.7F, new PotionEffect(Potion.field_76434_w.id, 300, 3)).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_porkchop");

    public static Item saltBeefCooked = new SaltFood("saltBeefCooked", 6, 0.7F, new PotionEffect(Potion.field_76434_w.id, 300, 3)).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_beef");

    public static Item saltChickenCooked = new SaltFood("saltChickenCooked", 5, 0.7F, new PotionEffect(Potion.field_76434_w.id, 300, 3)).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_chicken");

    public static Item saltRabbitCooked = new SaltFood("saltRabbitCooked", 5, 0.7F, new PotionEffect(Potion.field_76434_w.id, 300, 3)).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_rabbit");

    public static Item saltMuttonCooked = new SaltFood("saltMuttonCooked", 6, 0.7F, new PotionEffect(Potion.field_76434_w.id, 300, 3)).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_mutton");

    public static Item striderRaw = new SaltFood("striderRaw", 2, 0.6F).setCreativeTab(tab).setTextureName("saltmod:strider");

    public static Item striderCooked = new SaltFood("striderCooked", 4, 0.6F).setCreativeTab(tab).setTextureName("saltmod:cooked_strider");

    public static Item saltStriderCooked = new SaltFood("saltStriderCooked", 6, 0.7F, new PotionEffect(Potion.field_76434_w.id, 300, 3)).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_strider");

    public static Item haunchRaw = new SaltFood("haunchRaw", 2, 0.6F).setCreativeTab(tab).setTextureName("saltmod:haunch");

    public static Item haunchCooked = new SaltFood("haunchCooked", 4, 0.6F).setCreativeTab(tab).setTextureName("saltmod:cooked_haunch");

    public static Item saltHaunchCooked = new SaltFood("saltHaunchCooked", 6, 0.7F, new PotionEffect(Potion.field_76434_w.id, 300, 3)).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_haunch");

    public static Item cornedBeef = new SaltFood("cornedBeef", 4, 0.7F, new PotionEffect(Potion.field_76434_w.id, 300, 4)).setCreativeTab(tab).setTextureName("saltmod:cured_meat");

    public static Item saltFishCodCooked = new SaltFood("saltFishCodCooked", 4, 0.6F, new PotionEffect(Potion.field_76434_w.id, 300, 2)).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_cod");

    public static Item saltFishSalmonCooked = new SaltFood("saltFishSalmonCooked", 4, 0.6F, new PotionEffect(Potion.field_76434_w.id, 300, 2)).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_salmon");

    public static Item fishClownfishCooked = new SaltFood("fishClownfishCooked", 3, 0.5F).setCreativeTab(tab).setTextureName("saltmod:cooked_tropical_fish");

    public static Item saltFishClownfishCooked = new SaltFood("saltFishClownfishCooked", 4, 0.6F, new PotionEffect(Potion.field_76434_w.id, 300, 2)).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_tropical_fish");

    public static Item calamariRaw = new SaltFood("calamariRaw", 2, 0.5F).setCreativeTab(tab).setTextureName("saltmod:calamari");

    public static Item calamariCooked = new SaltFood("calamariCooked", 3, 0.5F, new PotionEffect(Potion.field_76434_w.id, 300, 2)).setCreativeTab(tab).setTextureName("saltmod:cooked_calamari");

    public static Item saltCalamariCooked = new SaltFood("saltCalamariCooked", 5, 0.6F).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_calamari");

    public static Item saltBread = new SaltFood("saltBread", 4, 0.6F, new PotionEffect(Potion.field_76434_w.id, 300, 1)).setCreativeTab(tab).setTextureName("saltmod:salt_bread");

    public static Item saltPotatoBaked = new SaltFood("saltPotatoBaked", 4, 0.6F, new PotionEffect(Potion.field_76434_w.id, 300, 1)).setCreativeTab(tab).setTextureName("saltmod:salt_baked_potato");

    public static Item saltBeetroot = new SaltFood("saltBeetroot", 2, 0.3F, new PotionEffect(Potion.field_76434_w.id, 300, 0)).setCreativeTab(tab).setTextureName("saltmod:salt_beetroot");

    public static Item saltEgg = new SaltFood("saltEgg", 2, 0.3F, new PotionEffect(Potion.field_76434_w.id, 300, 0)).setMaxStackSize(16).setCreativeTab(tab).setTextureName("saltmod:salt_egg");

    public static Item saltMushroomStew = new SaltFood("saltMushroomStew", 6, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_mushroom_stew");

    public static Item saltRabbitStew = new SaltFood("saltRabbitStew", 8, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_rabbit_ragout");

    public static Item saltBeetrootSoup = new SaltFood("saltBeetrootSoup", 6, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_borscht");

    public static Item pumpkinPorridge = new SaltFood("pumpkinPorridge", 5, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:pumpkin_porridge");

    public static Item saltPumpkinPorridge = new SaltFood("saltPumpkinPorridge", 6, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_pumpkin_porridge");

    public static Item cactusStew = new SaltFood("cactusStew", 5, 0.7F, Items.bowl, new PotionEffect(Potion.heal.id, 20, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:cactus_stew");

    public static Item saltCactusStew = new SaltFood("saltCactusStew", 6, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.heal.id, 20, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_cactus_stew");

    public static Item vegetableStew = new SaltFood("vegetableStew", 6, 0.7F, Items.bowl, new PotionEffect(Potion.nightVision.id, 300, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:stewed_vegetables");

    public static Item saltVegetableStew = new SaltFood("saltVegetableStew", 7, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.nightVision.id, 600, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_stewed_vegetables");

    public static Item potatoMushroom = new SaltFood("potatoMushroom", 5, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:potato_mushroom");

    public static Item saltPotatoMushroom = new SaltFood("saltPotatoMushroom", 6, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_potato_mushroom");

    public static Item goldenVegetables = new SaltFood("goldenVegetables", 10, 1.2F, Items.bowl, new PotionEffect(Potion.regeneration.id, 120, 2)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:glistering_vegetables");

    public static Item saltGoldenVegetables = new SaltFood("saltGoldenVegetables", 11, 1.2F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.regeneration.id, 180, 2)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_glistering_vegetables");

    public static Item fishSoup = new SaltFood("fishSoup", 6, 0.7F, Items.bowl, new PotionEffect(Potion.waterBreathing.id, 300, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:cod_soup");

    public static Item saltFishSoup = new SaltFood("saltFishSoup", 7, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.waterBreathing.id, 600, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_cod_soup");

    public static Item fishSalmonSoup = new SaltFood("fishSalmonSoup", 6, 0.7F, Items.bowl, new PotionEffect(Potion.waterBreathing.id, 300, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salmon_soup");

    public static Item saltFishSalmonSoup = new SaltFood("saltFishSalmonSoup", 7, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.waterBreathing.id, 600, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_salmon_soup");

    public static Item fishClownfishSoup = new SaltFood("fishClownfishSoup", 6, 0.7F, Items.bowl, new PotionEffect(Potion.waterBreathing.id, 300, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:tropical_fish_soup");

    public static Item saltFishClownfishSoup = new SaltFood("saltFishClownfishSoup", 7, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.waterBreathing.id, 600, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_tropical_fish_soup");

    public static Item dandelionSalad = new SaltFood("dandelionSalad", 6, 0.7F, Items.bowl, new PotionEffect(Potion.resistance.id, 300, 0), new PotionEffect(Potion.heal.id, 20, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:dandelion_salad");

    public static Item saltDandelionSalad = new SaltFood("saltDandelionSalad", 7, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.resistance.id, 600, 0), new PotionEffect(Potion.heal.id, 20, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_dandelion_salad");

    public static Item wheatSprouts = new SaltFood("wheatSprouts", 4, 0.7F, Items.bowl, new PotionEffect(Potion.heal.id, 20, 2)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:wheat_sprouts");

    public static Item saltWheatSprouts = new SaltFood("saltWheatSprouts", 5, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.heal.id, 20, 3)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_wheat_sprouts");

    public static Item beetrootSalad = new SaltFood("beetrootSalad", 6, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:beetroot_salad");

    public static Item saltBeetrootSalad = new SaltFood("saltBeetrootSalad", 7, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_beetroot_salad");

    public static Item herringUFC = new SaltFood("herringUFC", 6, 0.7F, Items.bowl, new PotionEffect(Potion.nightVision.id, 300, 0), new PotionEffect(Potion.waterBreathing.id, 300, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:dressed_herring");

    public static Item saltHerringUFC = new SaltFood("saltHerringUFC", 7, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.nightVision.id, 600, 0), new PotionEffect(Potion.waterBreathing.id, 600, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_dressed_herring");

    public static Item saltWortSalad = new SaltFood("saltWortSalad", 5, 0.7F, Items.bowl, new PotionEffect(Potion.regeneration.id, 180, 2)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:saltwort_salad");

    public static Item goldenSaltWortSalad = new SaltFood("goldenSaltWortSalad", 6, 1.2F, Items.bowl, new PotionEffect(Potion.regeneration.id, 180, 3)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:glistering_saltwort_salad");

    public static Item saltWortPorkchop = new SaltFood("saltWortPorkchop", 12, 0.9F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.regeneration.id, 300, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:saltwort_cooked_porkchop");

    public static Item saltWortHoneyPorkchop = new SaltFood("saltWortHoneyPorkchop", 12, 0.9F, Items.bowl, new PotionEffect(Potion.regeneration.id, 300, 1), new PotionEffect(Potion.field_76444_x.id, 900, 2)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:saltwort_honey_porkchop");

    public static Item saltWortBeef = new SaltFood("saltWortBeef", 12, 0.9F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.regeneration.id, 300, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:saltwort_cooked_beef");

    public static Item saltWortMutton = new SaltFood("saltWortMutton", 12, 0.9F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.regeneration.id, 300, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:saltwort_cooked_mutton");

    public static Item saltWortStrider = new SaltFood("saltWortStrider", 12, 0.9F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.regeneration.id, 300, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:saltwort_cooked_strider");

    public static Item saltWortHaunch = new SaltFood("saltWortHaunch", 12, 0.9F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.regeneration.id, 300, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:saltwort_cooked_haunch");

    public static Item sugarApple = new SaltFood("sugarApple", 4, 0.5F, new PotionEffect(Potion.moveSpeed.id, 120, 0)).setCreativeTab(tab).setTextureName("saltmod:sugar_apple");

    public static Item sugarMelon = new SaltFood("sugarMelon", 3, 0.5F, new PotionEffect(Potion.moveSpeed.id, 120, 0)).setCreativeTab(tab).setTextureName("saltmod:sugar_melon_slice");

    public static Item sugarBerries = new SaltFood("sugarBerries", 3, 0.5F, new PotionEffect(Potion.moveSpeed.id, 120, 0)).setCreativeTab(tab).setTextureName("saltmod:sugar_sweet_berries");

    public static Item fruitSalad = new SaltFood("fruitSalad", 6, 0.7F, Items.bowl, new PotionEffect(Potion.jump.id, 60, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:fruit_salad");

    public static Item sugarFruitSalad = new SaltFood("sugarFruitSalad", 7, 0.8F, Items.bowl, new PotionEffect(Potion.moveSpeed.id, 120, 0), new PotionEffect(Potion.jump.id, 60, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:sugar_fruit_salad");

    public static Item goldenFruitSalad = new SaltFood("goldenFruitSalad", 8, 0.7F, Items.bowl, new PotionEffect(Potion.regeneration.id, 120, 1), new PotionEffect(Potion.field_76444_x.id, 3000)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:glistering_fruit_salad");

    public static Item sugarGoldenFruitSalad = new SaltFood("sugarGoldenFruitSalad", 9, 0.8F, Items.bowl, new PotionEffect(Potion.moveSpeed.id, 120, 0), new PotionEffect(Potion.regeneration.id, 240, 1), new PotionEffect(Potion.field_76444_x.id, 3000, 1), new PotionEffect(Potion.heal.id, 1, 1)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:sugar_glistering_fruit_salad");

    public static Item gratedCarrot = new SaltFood("gratedCarrot", 6, 0.7F, Items.bowl, new PotionEffect(Potion.nightVision.id, 600, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:grated_carrot");

    public static Item sugarGratedCarrot = new SaltFood("sugarGratedCarrot", 7, 0.8F, Items.bowl, new PotionEffect(Potion.moveSpeed.id, 120, 0), new PotionEffect(Potion.nightVision.id, 1200, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:sugar_grated_carrot");

    public static Item melonSoup = new SaltFood("melonSoup", 5, 0.7F, Items.bowl, new PotionEffect(Potion.jump.id, 600, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:melon_soup");

    public static Item sugarMelonSoup = new SaltFood("sugarMelonSoup", 6, 0.8F, Items.bowl, new PotionEffect(Potion.moveSpeed.id, 120, 0), new PotionEffect(Potion.jump.id, 1200, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:sugar_melon_soup");

    public static Item honeyPorkchop = new SaltFood("honeyPorkchop", 6, 0.7F, new PotionEffect(Potion.field_76444_x.id, 900, 2)).setCreativeTab(tab).setTextureName("saltmod:honey_porkchop");

    public static Item honeyApple = new SaltFood("honeyApple", 4, 0.5F, new PotionEffect(Potion.field_76444_x.id, 600, 1)).setCreativeTab(tab).setTextureName("saltmod:honey_apple");

    public static Item honeyBerries = new SaltFood("honeyBerries", 3, 0.5F, new PotionEffect(Potion.field_76444_x.id, 300)).setCreativeTab(tab).setTextureName("saltmod:honey_berries");

    public static Item chocolateBerries = new SaltFood("chocolateBerries", 3, 0.5F, new PotionEffect(Potion.digSpeed.id, 300, 0)).setCreativeTab(tab).setTextureName("saltmod:chocolate_berries");

    public static Item chocolateBar = new ChocolateBar("chocolateBar", tab, "chocolate_bar");

    public static Item chocolatePie = new SaltFood("chocolatePie", 7, 0.9F, new PotionEffect(Potion.digSpeed.id, 900, 2)).setCreativeTab(tab).setTextureName("saltmod:chocolate_pie");

    public static Item applePie = new SaltFood("applePie", 8, 0.9F).setCreativeTab(tab).setTextureName("saltmod:apple_pie");

    public static Item sweetberryPie = new SaltFood("sweetberryPie", 7, 0.9F).setCreativeTab(tab).setTextureName("saltmod:sweetberry_pie");

    public static Item carrotPie = new SaltFood("carrotPie", 8, 0.9F, new PotionEffect(Potion.nightVision.id, 1200, 0)).setCreativeTab(tab).setTextureName("saltmod:carrot_pie");

    public static Item mushroomPie = new SaltFood("mushroomPie", 7, 0.9F, new PotionEffect(Potion.damageBoost.id, 300, 1), new PotionEffect(Potion.blindness.id, 60, 0)).setCreativeTab(tab).setTextureName("saltmod:mushroom_pie");

    public static Item potatoPie = new SaltFood("potatoPie", 7, 0.9F).setCreativeTab(tab).setTextureName("saltmod:potato_pie");

    public static Item onionPie = new SaltFood("onionPie", 8, 0.9F).setCreativeTab(tab).setTextureName("saltmod:onion_pie");

    public static Item shepherdsPie = new SaltFood("shepherdsPie", 10, 0.9F).setCreativeTab(tab).setTextureName("saltmod:shepherds_pie");

    public static Item fishPie = new SaltFood("fishPie", 7, 0.9F, new PotionEffect(Potion.waterBreathing.id, 300, 0)).setCreativeTab(tab).setTextureName("saltmod:cod_pie");

    public static Item fishSalmonPie = new SaltFood("fishSalmonPie", 7, 0.9F, new PotionEffect(Potion.waterBreathing.id, 300, 0)).setCreativeTab(tab).setTextureName("saltmod:salmon_pie");

    public static Item fishClownfishPie = new SaltFood("fishClownfishPie", 7, 0.9F, new PotionEffect(Potion.waterBreathing.id, 300, 0)).setCreativeTab(tab).setTextureName("saltmod:tropical_fish_pie");

    public static Item calamariPie = new SaltFood("calamariPie", 7, 0.9F, new PotionEffect(Potion.waterBreathing.id, 300, 0)).setCreativeTab(tab).setTextureName("saltmod:calamari_pie");

    public static Item saltWortPie = new SaltFood("saltWortPie", 7, 0.9F, new PotionEffect(Potion.regeneration.id, 600, 1)).setCreativeTab(tab).setTextureName("saltmod:saltwort_pie");

    public static Item fermentedSaltWort = new SaltFood("fermentedSaltWort", 5, 0.7F, Items.glass_bottle, new PotionEffect(Potion.regeneration.id, 900, 2)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:fermented_saltwort");

    public static Item pickledFern = new SaltFood("pickledFern", 4, 0.7F, Items.glass_bottle, new PotionEffect(Potion.field_76434_w.id, 1200, 1), new PotionEffect(Potion.resistance.id, 900, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:pickled_fern");

    public static Item pickledMushroom = new SaltFood("pickledMushroom", 4, 0.7F, Items.glass_bottle, new PotionEffect(Potion.field_76434_w.id, 1200, 1), new PotionEffect(Potion.damageBoost.id, 600, 1), new PotionEffect(Potion.blindness.id, 120, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:pickled_mushroom");

    public static Item pickledCalamari = new SaltFood("pickledCalamari", 6, 0.7F, Items.glass_bottle, new PotionEffect(Potion.field_76434_w.id, 1200, 1), new PotionEffect(Potion.waterBreathing.id, 600, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:pickled_calamari");

    public static Item pickledBeetroot = new SaltFood("pickledBeetroot", 5, 0.8F, Items.glass_bottle, new PotionEffect(Potion.field_76434_w.id, 1200, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:pickled_beetroot");

    public static Item pickledOnion = new SaltFood("pickledOnion", 6, 0.8F, Items.glass_bottle, new PotionEffect(Potion.field_76434_w.id, 1200, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:pickled_onion");

    public static Item preservedApple = new SaltFood("preservedApple", 8, 0.8F, Items.glass_bottle, new PotionEffect(Potion.moveSpeed.id, 300, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:apple_preserves");

    public static Item preservedMelon = new SaltFood("preservedMelon", 6, 0.8F, Items.glass_bottle, new PotionEffect(Potion.moveSpeed.id, 300, 1), new PotionEffect(Potion.jump.id, 600, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:melon_preserves");

    public static Item preservedSweetberries = new SaltFood("preservedSweetberries", 6, 0.8F, Items.glass_bottle, new PotionEffect(Potion.moveSpeed.id, 300, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:sweet_berry_preserves");

    public static Item cobblerConcoction = new CobblerConcoction("cobblerConcoction", tab, "cobbler_concoction");

    public static Item fizzyDrink = new FizzyDrink("fizzyDrink", tab, "fizzy_drink");

    public static Item muffin = new Muffin("muffin", tab, "muffin");

    public static Item hemoglobin = new SaltFood("hemoglobin", 2, 4.0F, new PotionEffect(Potion.heal.id, 1, 1)).setAlwaysEdible().setCreativeTab(tab).setTextureName("saltmod:hemoglobin");

    public static Item mudHelmet = new MudArmor("mud_helmet", CommonProxy.mudMaterial, 0);

    public static Item mudChestplate = new MudArmor("mud_chestplate", CommonProxy.mudMaterial, 1);

    public static Item mudLeggings = new MudArmor("mud_leggings", CommonProxy.mudMaterial, 2);

    public static Item mudBoots = new MudArmor("mud_boots", CommonProxy.mudMaterial, 3);

    public static Item toughJelly = new ToughJelly("toughJelly", tab, "tough_jelly");

    public static Item rainmakerStar = new SaltItems("rainmakerStar", tab, "rainmaker_star");

    public static Item rainmaker = new Rainmaker("rainmaker", tab, "rainmaker");

//    public static Item itemBlossomBoat = new ItemBlossomBoat();

//    public static Item itemBlossomChestBoat = new ItemBlossomChestBoat();

    public static Item itemBlossomSign = new ItemBlossomSign();


    public static Item tf_saltVenisonCooked = new SaltFood("tf_saltVenisonCooked", 9, 0.9F).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "tf_saltwort_cooked_venison");

    public static Item tf_saltMeefSteak = new SaltFood("tf_saltMeefSteak", 7, 0.7F).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "tf_salt_meef_steak");

    public static Item tf_saltMeefStroganoff = new SaltFood("tf_saltMeefStroganoff", 9, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "tf_salt_meef_stroganoff");

    public static Item tf_saltHydraChop = new SaltFood("tf_saltHydraChop", 19, 2.1F).setPotionEffect(Potion.regeneration.id, 5, 0, 1.0F).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "tf_salt_hydra_chop");

    public static Item tf_pickledMushgloom = new SaltFood("tf_pickledMushgloom", 6, 0.8F, Items.glass_bottle, new PotionEffect(Potion.nightVision.id, 1200, 0), new PotionEffect(Potion.moveSlowdown.id, 100, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "tf_pickled_mushgloom");

    public static Item tf_saltWortVenison = new SaltFood("tf_saltWortVenison", 10, 0.9F, Items.bowl, new PotionEffect(Potion.regeneration.id, 100, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "tf_saltwort_cooked_venison");

    public static Item tf_saltWortMeefSteak = new SaltFood("tf_saltWortMeefSteak", 8, 0.9F, Items.bowl, new PotionEffect(Potion.regeneration.id, 100, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "tf_saltwort_meef_steak");

    public static Item bop_poison = new SaltItems("bop_poison", tab, "BOP_Poison").setTextureName("saltmod:" + "bop/" + "bop_poison");

    public static Item bop_saltShroomPowder = ((ItemFood)(new SaltFood("bop_saltShroomPowder", 2, 0.2F)).setAlwaysEdible().setCreativeTab(tab)).setPotionEffect(Potion.confusion.id, 15, 0, 0.3F).setTextureName("saltmod:" + "bop/" + "bop_salt_shroom_powder");

    public static Item bop_sugarSaladFruit = ((ItemFood)(new SaltFood("bop_sugarSaladFruit", 7, 0.7F, Items.bowl)).setMaxStackSize(1).setCreativeTab(tab)).setPotionEffect(Potion.digSpeed.id, 1200, 2, 0.1F).setTextureName("saltmod:" + "bop/" + "bop_sugar_fruit_salad");

    public static Item bop_saltSaladVeggie = ((ItemFood)(new SaltFood("bop_saltSaladVeggie", 7, 0.7F, Items.bowl)).setMaxStackSize(1).setCreativeTab(tab)).setPotionEffect(Potion.field_76434_w.id, 1550, 2, 0.1F).setTextureName("saltmod:" + "bop/" + "bop_salt_veggie_salad");

    public static Item bop_saltSaladShroom = ((ItemFood)(new SaltFood("bop_saltSaladShroom", 7, 0.7F, Items.bowl)).setMaxStackSize(1).setCreativeTab(tab)).setPotionEffect(Potion.jump.id, 900, 2, 0.1F).setTextureName("saltmod:" + "bop/" + "bop_salt_shroom_salad");

    public static Item bop_saltRiceBowl = new SaltFood("bop_saltRiceBowl", 3, 0.2F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:" + "bop/" + "bop_salt_rice_bowl");

    public static Item bop_pickledTurnip = new SaltFood("bop_pickledTurnip", 6, 0.8F, Items.glass_bottle).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:" + "bop/" + "bop_pickled_turnip");

    public static void init() {
        SaltMod.logger.info("Start to initialize Items");

        if(SaltConfig.developerFoods) {
            GameRegistry.registerItem(hungerFood, "hungerFood");
            GameRegistry.registerItem(stuffedFood, "stuffedFood");
            GameRegistry.registerItem(effectFoodPos, "effectFoodPos");
            GameRegistry.registerItem(effectFoodNeg, "effectFoodNeg");
            GameRegistry.registerItem(testFood, "testFood");
        }
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
        GameRegistry.registerItem(saltPorkchopCooked, "saltPorkchopCooked");
        GameRegistry.registerItem(saltBeefCooked, "saltBeefCooked");
        GameRegistry.registerItem(saltChickenCooked, "saltChickenCooked");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(saltRabbitCooked, "saltRabbitCooked");
            GameRegistry.registerItem(saltMuttonCooked, "saltMuttonCooked");
        }
        if(Loader.isModLoaded("etfuturum") && !Loader.isModLoaded("netherlicious")) {
            GameRegistry.registerItem(striderRaw, "striderRaw");
            GameRegistry.registerItem(striderCooked, "striderCooked");
        }
//        if(Loader.isModLoaded("netherlicious")) {
            GameRegistry.registerItem(saltStriderCooked, "saltStriderCooked");
//        }
        GameRegistry.registerItem(haunchRaw, "haunchRaw");
        GameRegistry.registerItem(haunchCooked, "haunchCooked");
        GameRegistry.registerItem(saltHaunchCooked, "saltHaunchCooked");
        GameRegistry.registerItem(cornedBeef, "cornedBeef");
        GameRegistry.registerItem(saltFishCodCooked, "saltFishCodCooked");
        GameRegistry.registerItem(saltFishSalmonCooked, "saltFishSalmonCooked");
        GameRegistry.registerItem(fishClownfishCooked, "fishClownfishCooked");
        GameRegistry.registerItem(saltFishClownfishCooked, "saltFishClownfishCooked");
        GameRegistry.registerItem(calamariRaw, "calamariRaw");
        GameRegistry.registerItem(calamariCooked, "calamariCooked");
        GameRegistry.registerItem(saltCalamariCooked, "saltCalamariCooked");
        GameRegistry.registerItem(saltBread, "saltBread");
        GameRegistry.registerItem(saltPotatoBaked, "saltPotatoBaked");
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
        GameRegistry.registerItem(saltWortPorkchop, "saltWortPorkchop");
        GameRegistry.registerItem(saltWortHoneyPorkchop, "saltWortHoneyPorkchop");
        GameRegistry.registerItem(saltWortBeef, "saltWortBeef");
//        if(Loader.isModLoaded("netherlicious")) {
            GameRegistry.registerItem(saltWortStrider, "saltWortStrider");
//        }
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
        GameRegistry.registerItem(honeyPorkchop, "honeyPorkchop");
        GameRegistry.registerItem(honeyApple, "honeyApple");
        GameRegistry.registerItem(honeyBerries, "honeyBerries");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(chocolateBerries, "chocolateBerries");
        }
        GameRegistry.registerItem(chocolateBar, "chocolateBar");
        GameRegistry.registerItem(chocolatePie, "chocolatePie");
        GameRegistry.registerItem(applePie, "applePie");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(sweetberryPie, "sweetberryPie");
        }
        GameRegistry.registerItem(carrotPie, "carrotPie");
        GameRegistry.registerItem(mushroomPie, "mushroomPie");
        GameRegistry.registerItem(potatoPie, "potatoPie");
        GameRegistry.registerItem(onionPie, "onionPie");
        GameRegistry.registerItem(shepherdsPie, "shepherdsPie");
        GameRegistry.registerItem(shepherdsPie, "shepherdsPie");
        GameRegistry.registerItem(fishPie, "fishPie");
        GameRegistry.registerItem(fishSalmonPie, "fishSalmonPie");
        GameRegistry.registerItem(fishClownfishPie, "fishClownfishPie");
        GameRegistry.registerItem(calamariPie, "calamariPie");
        GameRegistry.registerItem(saltWortPie, "saltWortPie");
        GameRegistry.registerItem(fermentedSaltWort, "fermentedSaltWort");
        GameRegistry.registerItem(pickledFern, "pickledFern");
        GameRegistry.registerItem(pickledMushroom, "pickledMushroom");
        GameRegistry.registerItem(pickledCalamari, "pickledCalamari");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(pickledBeetroot, "pickledBeetroot");
        }
        GameRegistry.registerItem(pickledOnion, "pickledOnion");
        GameRegistry.registerItem(preservedApple, "preservedApple");
        GameRegistry.registerItem(preservedMelon, "preservedMelon");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(preservedSweetberries, "preservedSweetberries");
        }
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
        if(Loader.isModLoaded("etfuturum")) {
//            GameRegistry.registerItem(itemBlossomBoat, "itemBlossomBoat");
//            GameRegistry.registerItem(itemBlossomChestBoat, "itemBlossomChestBoat");
            GameRegistry.registerItem(itemBlossomSign, "itemBlossomSign");
        }

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
