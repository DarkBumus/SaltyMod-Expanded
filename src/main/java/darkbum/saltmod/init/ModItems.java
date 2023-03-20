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
    static CreativeTabs tab = CommonProxy.tabSalt;

    public static Item achievement_item = new ItemAchievementItem("achievement_item", null);

    public static Item void_apple = new ItemVoidApple("void_apple", null).setAlwaysEdible().setTextureName("saltmod:" + "dev/" + "void_apple");

    public static Item stuffing_apple = new ItemStuffingApple("stuffing_apple", null).setAlwaysEdible().setTextureName("saltmod:" + "dev/" + "stuffing_apple");

    public static Item effect_apple = new ItemEffectApple("effect_apple", null).setAlwaysEdible();

//    field_76434_w = Health Boost
//    field_76443_y = Saturation
//    field_76444_x = Absorption
    public static Item testing_apple = new ItemSaltFood("testing_apple", 2, 0.3F, new PotionEffect(Potion.field_76443_y.id, 300)).setAlwaysEdible().setCreativeTab(null).setTextureName("saltmod:" + "dev/" + "test_food");

    public static Item blossom = new Item().setCreativeTab(tab).setUnlocalizedName("blossom").setTextureName("saltmod:blossom");

    public static Item bee_grub = new Item().setCreativeTab(tab).setUnlocalizedName("bee_grub").setTextureName("saltmod:bee_grub");

    public static Item carpenter_bee = new ItemCarpenterBee("carpenter_bee", tab, "carpenter_bee").setMaxStackSize(1).setMaxDamage(18);

    public static Item waxcomb = new Item().setCreativeTab(tab).setUnlocalizedName("waxcomb").setTextureName("saltmod:waxcomb");

    public static Item honeycomb = new Item().setCreativeTab(tab).setUnlocalizedName("honeycomb").setTextureName("saltmod:honeycomb");

    public static Item royal_jelly = new Item().setCreativeTab(tab).setUnlocalizedName("royal_jelly").setTextureName("saltmod:royal_jelly");

    public static Item mineral_mud_ball = new Item().setCreativeTab(tab).setUnlocalizedName("mineralMud").setTextureName("saltmod:mineral_mud");

    public static Item soda = new Item().setCreativeTab(tab).setUnlocalizedName("soda").setTextureName("saltmod:baking_soda");

    public static Item powdered_milk = new ItemPowderedMilk("powderedMilk", tab, "powdered_milk");

    public static Item salt = new ItemSalt("salt", tab, "salt");

    public static Item salt_pinch = new Item().setCreativeTab(tab).setUnlocalizedName("saltPinch").setTextureName("saltmod:salt_pinch");

    public static Item sugar_pinch = new Item().setCreativeTab(tab).setUnlocalizedName("sugarPinch").setTextureName("saltmod:sugar_pinch");

    public static Item dough = new ItemDough("dough", tab, "dough");

    public static Item onion = new ItemSeedFood(2, 0.3F, ModBlocks.onions, Blocks.farmland).setUnlocalizedName("onion").setCreativeTab(tab).setTextureName("saltmod:onion");

    public static Item saltwort = new ItemSaltwort("saltWortSeed", tab);

    public static Item golden_saltwort = new ItemSaltFood("golden_saltwort", 6, 1.2F, new PotionEffect(Potion.regeneration.id, 60, 2)).setCreativeTab(tab).setTextureName("saltmod:golden_saltwort");

    public static Item golden_potato = new ItemSaltFood("golden_potato", 6, 1.2F).setCreativeTab(tab).setTextureName("saltmod:golden_potato");

    public static Item golden_berries = new ItemBerriesGold(3, 0.6F, false).setAlwaysEdible().setPotionEffect(Potion.regeneration.id, 5, 1, 1.0F).setUnlocalizedName("golden_berries").setCreativeTab(tab).setTextureName("saltmod:golden_berries");

    public static Item salt_cooked_porkchop = new ItemSaltFood("saltPorkchopCooked", 6, 0.7F, new PotionEffect(Potion.field_76434_w.id, 300, 3)).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_porkchop");

    public static Item salt_cooked_beef = new ItemSaltFood("saltBeefCooked", 6, 0.7F, new PotionEffect(Potion.field_76434_w.id, 300, 3)).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_beef");

    public static Item salt_cooked_chicken = new ItemSaltFood("saltChickenCooked", 5, 0.7F, new PotionEffect(Potion.field_76434_w.id, 300, 3)).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_chicken");

    public static Item salt_cooked_rabbit = new ItemSaltFood("saltRabbitCooked", 5, 0.7F, new PotionEffect(Potion.field_76434_w.id, 300, 3)).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_rabbit");

    public static Item salt_cooked_mutton = new ItemSaltFood("saltMuttonCooked", 6, 0.7F, new PotionEffect(Potion.field_76434_w.id, 300, 3)).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_mutton");

    public static Item strider = new ItemSaltFood("strider", 2, 0.6F).setCreativeTab(tab).setTextureName("saltmod:strider");

    public static Item cooked_strider = new ItemSaltFood("cooked_strider", 4, 0.6F).setCreativeTab(tab).setTextureName("saltmod:cooked_strider");

    public static Item salt_cooked_strider = new ItemSaltFood("salt_cooked_strider", 6, 0.7F, new PotionEffect(Potion.field_76434_w.id, 300, 3)).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_strider");

    public static Item haunch = new ItemSaltFood("haunchRaw", 2, 0.6F).setCreativeTab(tab).setTextureName("saltmod:haunch");

    public static Item cooked_haunch = new ItemSaltFood("haunchCooked", 4, 0.6F).setCreativeTab(tab).setTextureName("saltmod:cooked_haunch");

    public static Item salt_cooked_haunch = new ItemSaltFood("saltHaunchCooked", 6, 0.7F, new PotionEffect(Potion.field_76434_w.id, 300, 3)).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_haunch");

    public static Item cured_meat = new ItemSaltFood("cornedBeef", 4, 0.7F, new PotionEffect(Potion.field_76434_w.id, 300, 4)).setCreativeTab(tab).setTextureName("saltmod:cured_meat");

    public static Item salt_cooked_cod = new ItemSaltFood("saltFishCodCooked", 4, 0.6F, new PotionEffect(Potion.field_76434_w.id, 300, 2)).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_cod");

    public static Item salt_cooked_salmon = new ItemSaltFood("saltFishSalmonCooked", 4, 0.6F, new PotionEffect(Potion.field_76434_w.id, 300, 2)).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_salmon");

    public static Item cooked_tropical_fish = new ItemSaltFood("cooked_tropical_fish", 3, 0.5F).setCreativeTab(tab).setTextureName("saltmod:cooked_tropical_fish");

    public static Item salt_cooked_tropical_fish = new ItemSaltFood("saltFishClownfishCooked", 4, 0.6F, new PotionEffect(Potion.field_76434_w.id, 300, 2)).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_tropical_fish");

    public static Item tailor = new ItemSaltFood("tailor", 1, 0.5F, new PotionEffect(Potion.waterBreathing.id, 3, 0)).setCreativeTab(tab).setTextureName("saltmod:tailor");

    public static Item cooked_tailor = new ItemSaltFood("cooked_tailor", 3, 0.5F).setCreativeTab(tab).setTextureName("saltmod:cooked_tailor");

    public static Item salt_cooked_tailor = new ItemSaltFood("salt_cooked_tailor", 4, 0.6F, new PotionEffect(Potion.field_76434_w.id, 300, 2)).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_tailor");

    public static Item calamari = new ItemSaltFood("calamariRaw", 2, 0.5F).setCreativeTab(tab).setTextureName("saltmod:calamari");

    public static Item cooked_calamari = new ItemSaltFood("calamariCooked", 3, 0.5F).setCreativeTab(tab).setTextureName("saltmod:cooked_calamari");

    public static Item salt_cooked_calamari = new ItemSaltFood("saltCalamariCooked", 5, 0.6F, new PotionEffect(Potion.field_76434_w.id, 300, 2)).setCreativeTab(tab).setTextureName("saltmod:salt_cooked_calamari");

    public static Item salt_bread = new ItemSaltFood("saltBread", 4, 0.6F, new PotionEffect(Potion.field_76434_w.id, 300, 1)).setCreativeTab(tab).setTextureName("saltmod:salt_bread");

    public static Item salt_baked_potato = new ItemSaltFood("saltPotatoBaked", 4, 0.6F, new PotionEffect(Potion.field_76434_w.id, 300, 1)).setCreativeTab(tab).setTextureName("saltmod:salt_baked_potato");

    public static Item salt_beetroot = new ItemSaltFood("saltBeetroot", 2, 0.3F, new PotionEffect(Potion.field_76434_w.id, 300, 0)).setCreativeTab(tab).setTextureName("saltmod:salt_beetroot");

    public static Item salt_egg = new ItemSaltFood("saltEgg", 2, 0.3F, new PotionEffect(Potion.field_76434_w.id, 300, 0)).setMaxStackSize(16).setCreativeTab(tab).setTextureName("saltmod:salt_egg");

    public static Item salt_mushroom_stew = new ItemSaltFood("saltMushroomStew", 6, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_mushroom_stew");

    public static Item salt_rabbit_stew = new ItemSaltFood("saltRabbitStew", 8, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_rabbit_stew");

    public static Item salt_beetroot_soup = new ItemSaltFood("saltBeetrootSoup", 6, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_beetroot_soup");

    public static Item pumpkin_porridge = new ItemSaltFood("pumpkinPorridge", 5, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:pumpkin_porridge");

    public static Item salt_pumpkin_porridge = new ItemSaltFood("saltPumpkinPorridge", 6, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_pumpkin_porridge");

    public static Item cactus_stew = new ItemSaltFood("cactusStew", 5, 0.7F, Items.bowl, new PotionEffect(Potion.heal.id, 20, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:cactus_stew");

    public static Item salt_cactus_stew = new ItemSaltFood("saltCactusStew", 6, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.heal.id, 20, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_cactus_stew");

    public static Item stewed_vegetables = new ItemSaltFood("vegetableStew", 6, 0.7F, Items.bowl, new PotionEffect(Potion.nightVision.id, 300, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:stewed_vegetables");

    public static Item salt_stewed_vegetables = new ItemSaltFood("saltVegetableStew", 7, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.nightVision.id, 600, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_stewed_vegetables");

    public static Item potato_mushroom = new ItemSaltFood("potatoMushroom", 5, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:potato_mushroom");

    public static Item salt_potato_mushroom = new ItemSaltFood("saltPotatoMushroom", 6, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_potato_mushroom");

    public static Item golden_vegetables = new ItemSaltFood("golden_vegetables", 10, 1.2F, Items.bowl, new PotionEffect(Potion.regeneration.id, 120, 2)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:golden_vegetables");

    public static Item salt_golden_vegetables = new ItemSaltFood("salt_golden_vegetables", 11, 1.2F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.regeneration.id, 180, 2)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_golden_vegetables");

    public static Item fish_soup = new ItemSaltFood("fishSoup", 6, 0.7F, Items.bowl, new PotionEffect(Potion.waterBreathing.id, 300, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:fish_soup");

    public static Item salt_fish_soup = new ItemSaltFood("saltFishSoup", 7, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.waterBreathing.id, 600, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_fish_soup");

    public static Item dandelion_salad = new ItemSaltFood("dandelionSalad", 6, 0.7F, Items.bowl, new PotionEffect(Potion.resistance.id, 300, 0), new PotionEffect(Potion.heal.id, 20, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:dandelion_salad");

    public static Item salt_dandelion_salad = new ItemSaltFood("saltDandelionSalad", 7, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.resistance.id, 600, 0), new PotionEffect(Potion.heal.id, 20, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_dandelion_salad");

    public static Item wheat_sprouts = new ItemSaltFood("wheatSprouts", 4, 0.7F, Items.bowl, new PotionEffect(Potion.heal.id, 20, 2)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:wheat_sprouts");

    public static Item salt_wheat_sprouts = new ItemSaltFood("saltWheatSprouts", 5, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.heal.id, 20, 3)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_wheat_sprouts");

    public static Item beetroot_salad = new ItemSaltFood("beetrootSalad", 6, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:beetroot_salad");

    public static Item salt_beetroot_salad = new ItemSaltFood("saltBeetrootSalad", 7, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_beetroot_salad");

    public static Item dressed_herring = new ItemSaltFood("herringUFC", 6, 0.7F, Items.bowl, new PotionEffect(Potion.nightVision.id, 300, 0), new PotionEffect(Potion.waterBreathing.id, 300, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:dressed_herring");

    public static Item salt_dressed_herring = new ItemSaltFood("saltHerringUFC", 7, 0.8F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.nightVision.id, 600, 0), new PotionEffect(Potion.waterBreathing.id, 600, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:salt_dressed_herring");

    public static Item saltwort_salad = new ItemSaltFood("saltWortSalad", 5, 0.7F, Items.bowl, new PotionEffect(Potion.regeneration.id, 180, 2)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:saltwort_salad");

    public static Item golden_saltwort_salad = new ItemSaltFood("golden_saltwort_salad", 6, 1.2F, Items.bowl, new PotionEffect(Potion.regeneration.id, 180, 3)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:golden_saltwort_salad");

    public static Item saltwort_cooked_porkchop = new ItemSaltFood("saltWortPorkchop", 12, 0.9F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.regeneration.id, 300, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:saltwort_cooked_porkchop");

    public static Item saltwort_honey_porkchop = new ItemSaltFood("saltwort_honey_porkchop", 12, 0.9F, Items.bowl, new PotionEffect(Potion.regeneration.id, 300, 1), new PotionEffect(Potion.field_76444_x.id, 900, 2)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:saltwort_honey_porkchop");

    public static Item saltwort_cooked_beef = new ItemSaltFood("saltWortBeef", 12, 0.9F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.regeneration.id, 300, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:saltwort_cooked_beef");

    public static Item saltwort_cooked_mutton = new ItemSaltFood("saltWortMutton", 12, 0.9F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.regeneration.id, 300, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:saltwort_cooked_mutton");

    public static Item saltwort_cooked_strider = new ItemSaltFood("saltwort_cooked_strider", 12, 0.9F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.regeneration.id, 300, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:saltwort_cooked_strider");

    public static Item saltwort_cooked_haunch = new ItemSaltFood("saltWortHaunch", 12, 0.9F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 120, 0), new PotionEffect(Potion.regeneration.id, 300, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:saltwort_cooked_haunch");

    public static Item sugar_apple = new ItemSaltFood("sugar_apple", 4, 0.5F, new PotionEffect(Potion.moveSpeed.id, 120, 0)).setCreativeTab(tab).setTextureName("saltmod:sugar_apple");

    public static Item sugar_melon = new ItemSaltFood("sugar_melon", 3, 0.5F, new PotionEffect(Potion.moveSpeed.id, 120, 0)).setCreativeTab(tab).setTextureName("saltmod:sugar_melon_slice");

    public static Item sugar_berries = new ItemSaltFood("sugar_berries", 3, 0.5F, new PotionEffect(Potion.moveSpeed.id, 120, 0)).setCreativeTab(tab).setTextureName("saltmod:sugar_sweet_berries");

    public static Item fruit_salad = new ItemSaltFood("fruitSalad", 6, 0.7F, Items.bowl, new PotionEffect(Potion.jump.id, 60, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:fruit_salad");

    public static Item sugar_fruit_salad = new ItemSaltFood("sugarFruitSalad", 7, 0.8F, Items.bowl, new PotionEffect(Potion.moveSpeed.id, 120, 0), new PotionEffect(Potion.jump.id, 60, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:sugar_fruit_salad");

    public static Item golden_fruit_salad = new ItemSaltFood("golden_fruit_salad", 8, 0.7F, Items.bowl, new PotionEffect(Potion.regeneration.id, 120, 1), new PotionEffect(Potion.field_76444_x.id, 3000)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:golden_fruit_salad");

    public static Item sugar_golden_fruit_salad = new ItemSaltFood("sugar_golden_fruit_salad", 9, 0.8F, Items.bowl, new PotionEffect(Potion.moveSpeed.id, 120, 0), new PotionEffect(Potion.regeneration.id, 240, 1), new PotionEffect(Potion.field_76444_x.id, 3000, 1), new PotionEffect(Potion.heal.id, 1, 1)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:sugar_golden_fruit_salad");

    public static Item grated_carrot = new ItemSaltFood("gratedCarrot", 6, 0.7F, Items.bowl, new PotionEffect(Potion.nightVision.id, 600, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:grated_carrot");

    public static Item sugar_grated_carrot = new ItemSaltFood("sugarGratedCarrot", 7, 0.8F, Items.bowl, new PotionEffect(Potion.moveSpeed.id, 120, 0), new PotionEffect(Potion.nightVision.id, 1200, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:sugar_grated_carrot");

    public static Item melon_soup = new ItemSaltFood("melonSoup", 5, 0.7F, Items.bowl, new PotionEffect(Potion.jump.id, 600, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:melon_soup");

    public static Item sugar_melon_soup = new ItemSaltFood("sugarMelonSoup", 6, 0.8F, Items.bowl, new PotionEffect(Potion.moveSpeed.id, 120, 0), new PotionEffect(Potion.jump.id, 1200, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:sugar_melon_soup");

    public static Item honey_porkchop = new ItemSaltFood("honey_porkchop", 6, 0.7F, new PotionEffect(Potion.field_76444_x.id, 900, 2)).setCreativeTab(tab).setTextureName("saltmod:honey_porkchop");

    public static Item honey_apple = new ItemSaltFood("honey_apple", 4, 0.5F, new PotionEffect(Potion.field_76444_x.id, 600, 1)).setCreativeTab(tab).setTextureName("saltmod:honey_apple");

    public static Item honey_berries = new ItemSaltFood("honey_berries", 3, 0.5F, new PotionEffect(Potion.field_76444_x.id, 300)).setCreativeTab(tab).setTextureName("saltmod:honey_berries");

    public static Item chocolate_berries = new ItemSaltFood("chocolateBerries", 3, 0.5F, new PotionEffect(Potion.digSpeed.id, 300, 0)).setCreativeTab(tab).setTextureName("saltmod:chocolate_berries");

    public static Item chocolate_bar = new ChocolateBar("chocolateBar", tab, "chocolate_bar");

    public static Item chocolate_pie = new ItemSaltFood("chocolatePie", 7, 0.9F, new PotionEffect(Potion.digSpeed.id, 900, 2)).setCreativeTab(tab).setTextureName("saltmod:chocolate_pie");

    public static Item apple_pie = new ItemSaltFood("applePie", 8, 0.9F).setCreativeTab(tab).setTextureName("saltmod:apple_pie");

    public static Item sweetberry_pie = new ItemSaltFood("sweetberryPie", 7, 0.9F).setCreativeTab(tab).setTextureName("saltmod:sweetberry_pie");

    public static Item carrot_pie = new ItemSaltFood("carrotPie", 8, 0.9F, new PotionEffect(Potion.nightVision.id, 1200, 0)).setCreativeTab(tab).setTextureName("saltmod:carrot_pie");

    public static Item mushroom_pie = new ItemSaltFood("mushroomPie", 7, 0.9F, new PotionEffect(Potion.damageBoost.id, 300, 1), new PotionEffect(Potion.blindness.id, 60, 0)).setCreativeTab(tab).setTextureName("saltmod:mushroom_pie");

    public static Item potato_pie = new ItemSaltFood("potatoPie", 7, 0.9F).setCreativeTab(tab).setTextureName("saltmod:potato_pie");

    public static Item onion_pie = new ItemSaltFood("onionPie", 8, 0.9F).setCreativeTab(tab).setTextureName("saltmod:onion_pie");

    public static Item shepherds_pie = new ItemSaltFood("shepherdsPie", 10, 0.9F).setCreativeTab(tab).setTextureName("saltmod:shepherds_pie");

    public static Item cod_pie = new ItemSaltFood("fishPie", 7, 0.9F, new PotionEffect(Potion.waterBreathing.id, 300, 0)).setCreativeTab(tab).setTextureName("saltmod:cod_pie");

    public static Item salmon_pie = new ItemSaltFood("fishSalmonPie", 7, 0.9F, new PotionEffect(Potion.waterBreathing.id, 300, 0)).setCreativeTab(tab).setTextureName("saltmod:salmon_pie");

    public static Item tropical_fish_pie = new ItemSaltFood("fishClownfishPie", 7, 0.9F, new PotionEffect(Potion.waterBreathing.id, 300, 0)).setCreativeTab(tab).setTextureName("saltmod:tropical_fish_pie");

    public static Item tailor_pie = new ItemSaltFood("tailor_pie", 7, 0.9F, new PotionEffect(Potion.waterBreathing.id, 300, 0)).setCreativeTab(tab).setTextureName("saltmod:tailor_pie");

    public static Item calamari_pie = new ItemSaltFood("calamariPie", 7, 0.9F, new PotionEffect(Potion.waterBreathing.id, 300, 0)).setCreativeTab(tab).setTextureName("saltmod:calamari_pie");

    public static Item saltwort_pie = new ItemSaltFood("saltWortPie", 7, 0.9F, new PotionEffect(Potion.regeneration.id, 600, 1)).setCreativeTab(tab).setTextureName("saltmod:saltwort_pie");

    public static Item fermented_saltwort = new ItemSaltFood("fermentedSaltWort", 5, 0.7F, Items.glass_bottle, new PotionEffect(Potion.regeneration.id, 900, 2)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:fermented_saltwort");

    public static Item pickled_fern = new ItemSaltFood("pickledFern", 4, 0.7F, Items.glass_bottle, new PotionEffect(Potion.field_76434_w.id, 1200, 1), new PotionEffect(Potion.resistance.id, 900, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:pickled_fern");

    public static Item pickled_mushroom = new ItemSaltFood("pickledMushroom", 4, 0.7F, Items.glass_bottle, new PotionEffect(Potion.field_76434_w.id, 1200, 1), new PotionEffect(Potion.damageBoost.id, 600, 1), new PotionEffect(Potion.blindness.id, 120, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:pickled_mushroom");

    public static Item pickled_calamari = new ItemSaltFood("pickledCalamari", 6, 0.7F, Items.glass_bottle, new PotionEffect(Potion.field_76434_w.id, 1200, 1), new PotionEffect(Potion.waterBreathing.id, 600, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:pickled_calamari");

    public static Item pickled_beetroot = new ItemSaltFood("pickled_beetroot", 5, 0.8F, Items.glass_bottle, new PotionEffect(Potion.field_76434_w.id, 1200, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:pickled_beetroot");

    public static Item pickled_onion = new ItemSaltFood("pickledOnion", 6, 0.8F, Items.glass_bottle, new PotionEffect(Potion.field_76434_w.id, 1200, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:pickled_onion");

    public static Item apple_preserves = new ItemSaltFood("apple_preserves", 8, 0.8F, Items.glass_bottle, new PotionEffect(Potion.moveSpeed.id, 300, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:apple_preserves");

    public static Item melon_preserves = new ItemSaltFood("melon_preserves", 6, 0.8F, Items.glass_bottle, new PotionEffect(Potion.moveSpeed.id, 300, 1), new PotionEffect(Potion.jump.id, 600, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:melon_preserves");

    public static Item berry_preserves = new ItemSaltFood("berry_preserves", 6, 0.8F, Items.glass_bottle, new PotionEffect(Potion.moveSpeed.id, 300, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:berry_preserves");

    public static Item tunneler_concoction = new ItemTunnelerConcoction("tunneler_concoction", tab, "tunneler_concoction");

    public static Item fizzy_drink = new ItemFizzyDrink("fizzyDrink", tab, "fizzy_drink");

    public static Item muffin = new ItemMuffin("muffin", tab, "muffin");

    public static Item hemoglobin = new ItemSaltFood("hemoglobin", 2, 4.0F, new PotionEffect(Potion.heal.id, 1, 1)).setAlwaysEdible().setCreativeTab(tab).setTextureName("saltmod:hemoglobin");

    public static Item mud_helmet = new ItemMudArmor("mud_helmet", CommonProxy.mudMaterial, 0);

    public static Item mud_chestplate = new ItemMudArmor("mud_chestplate", CommonProxy.mudMaterial, 1);

    public static Item mud_leggings = new ItemMudArmor("mud_leggings", CommonProxy.mudMaterial, 2);

    public static Item mud_boots = new ItemMudArmor("mud_boots", CommonProxy.mudMaterial, 3);

    public static Item tough_jelly = new ItemToughJelly("toughJelly", tab, "tough_jelly");

    public static Item rainmaker_star = new Item().setCreativeTab(tab).setUnlocalizedName("rainmaker_star").setTextureName("saltmod:rainmaker_star");

    public static Item rainmaker = new ItemRainmaker("rainmaker", tab, "rainmaker");

//    public static Item itemBlossomBoat = new ItemBlossomBoat();

//    public static Item itemBlossomChestBoat = new ItemBlossomChestBoat();

//    public static Item itemBlossomSign = new ItemBlossomSign();


    public static Item tf_salt_cooked_venison = new ItemSaltFood("tf_saltVenisonCooked", 9, 0.9F).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "tf_saltwort_cooked_venison");

    public static Item tf_salt_meef_steak = new ItemSaltFood("tf_saltMeefSteak", 7, 0.7F).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "tf_salt_meef_steak");

    public static Item tf_salt_meef_stroganoff = new ItemSaltFood("tf_saltMeefStroganoff", 9, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "tf_salt_meef_stroganoff");

    public static Item tf_salt_hydra_chop = new ItemSaltFood("tf_saltHydraChop", 19, 2.1F).setPotionEffect(Potion.regeneration.id, 5, 0, 1.0F).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "tf_salt_hydra_chop");

    public static Item tf_pickled_mushgloom = new ItemSaltFood("tf_pickledMushgloom", 6, 0.8F, Items.glass_bottle, new PotionEffect(Potion.nightVision.id, 1200, 0), new PotionEffect(Potion.moveSlowdown.id, 100, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "tf_pickled_mushgloom");

    public static Item tf_saltwort_cooked_venison = new ItemSaltFood("tf_saltWortVenison", 10, 0.9F, Items.bowl, new PotionEffect(Potion.regeneration.id, 100, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "tf_saltwort_cooked_venison");

    public static Item tf_saltwort_meef_steak = new ItemSaltFood("tf_saltWortMeefSteak", 8, 0.9F, Items.bowl, new PotionEffect(Potion.regeneration.id, 100, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "tf_saltwort_meef_steak");

    public static Item bop_poison = new Item().setCreativeTab(tab).setUnlocalizedName("bop_poison").setTextureName("saltmod:" + "bop/" + "bop_poison");

    public static Item bop_salt_shroom_powder = ((ItemFood)(new ItemSaltFood("bop_saltShroomPowder", 2, 0.2F)).setAlwaysEdible().setCreativeTab(tab)).setPotionEffect(Potion.confusion.id, 15, 0, 0.3F).setTextureName("saltmod:" + "bop/" + "bop_salt_shroom_powder");

    public static Item bop_sugar_fruit_salad = ((ItemFood)(new ItemSaltFood("bop_sugarSaladFruit", 7, 0.7F, Items.bowl)).setMaxStackSize(1).setCreativeTab(tab)).setPotionEffect(Potion.digSpeed.id, 1200, 2, 0.1F).setTextureName("saltmod:" + "bop/" + "bop_sugar_fruit_salad");

    public static Item bop_salt_veggie_salad = ((ItemFood)(new ItemSaltFood("bop_saltSaladVeggie", 7, 0.7F, Items.bowl)).setMaxStackSize(1).setCreativeTab(tab)).setPotionEffect(Potion.field_76434_w.id, 1550, 2, 0.1F).setTextureName("saltmod:" + "bop/" + "bop_salt_veggie_salad");

    public static Item bop_salt_shroom_salad = ((ItemFood)(new ItemSaltFood("bop_saltSaladShroom", 7, 0.7F, Items.bowl)).setMaxStackSize(1).setCreativeTab(tab)).setPotionEffect(Potion.jump.id, 900, 2, 0.1F).setTextureName("saltmod:" + "bop/" + "bop_salt_shroom_salad");

    public static Item bop_salt_rice_bowl = new ItemSaltFood("bop_saltRiceBowl", 3, 0.2F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:" + "bop/" + "bop_salt_rice_bowl");

    public static Item bop_pickled_turnip = new ItemSaltFood("bop_pickledTurnip", 6, 0.8F, Items.glass_bottle).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:" + "bop/" + "bop_pickled_turnip");

    public static void init() {
        SaltMod.logger.info("Start to initialize Items");

        GameRegistry.registerItem(achievement_item, "achievement_item");
        if(SaltConfig.developerFoods) {
            GameRegistry.registerItem(void_apple, "void_apple");
            GameRegistry.registerItem(stuffing_apple, "stuffing_apple");
            GameRegistry.registerItem(effect_apple, "effect_apple");
            GameRegistry.registerItem(testing_apple, "testing_apple");
        }
        GameRegistry.registerItem(blossom, "blossom");
        GameRegistry.registerItem(bee_grub, "bee_grub");
        GameRegistry.registerItem(carpenter_bee, "carpenter_bee");
        GameRegistry.registerItem(waxcomb, "waxcomb");
        GameRegistry.registerItem(honeycomb, "honeycomb");
        GameRegistry.registerItem(royal_jelly, "royal_jelly");
        GameRegistry.registerItem(mineral_mud_ball, "mineralMud");
        GameRegistry.registerItem(soda, "soda");
        GameRegistry.registerItem(powdered_milk, "powderedMilk");
        GameRegistry.registerItem(salt, "salt");
        GameRegistry.registerItem(salt_pinch, "saltPinch");
        GameRegistry.registerItem(sugar_pinch, "sugarPinch");
        GameRegistry.registerItem(dough, "dough");
        GameRegistry.registerItem(onion, "onion");
        GameRegistry.registerItem(saltwort, "saltWortSeed");
        GameRegistry.registerItem(golden_saltwort, "golden_saltwort");
        GameRegistry.registerItem(golden_potato, "golden_potato");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(golden_berries, "golden_berries");
        }
        GameRegistry.registerItem(salt_cooked_porkchop, "saltPorkchopCooked");
        GameRegistry.registerItem(salt_cooked_beef, "saltBeefCooked");
        GameRegistry.registerItem(salt_cooked_chicken, "saltChickenCooked");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(salt_cooked_rabbit, "saltRabbitCooked");
            GameRegistry.registerItem(salt_cooked_mutton, "saltMuttonCooked");
        }
        if(Loader.isModLoaded("etfuturum") && !Loader.isModLoaded("netherlicious")) {
            GameRegistry.registerItem(strider, "strider");
            GameRegistry.registerItem(cooked_strider, "cooked_strider");
        }
//        if(Loader.isModLoaded("netherlicious")) {
            GameRegistry.registerItem(salt_cooked_strider, "salt_cooked_strider");
//        }
        GameRegistry.registerItem(haunch, "haunchRaw");
        GameRegistry.registerItem(cooked_haunch, "haunchCooked");
        GameRegistry.registerItem(salt_cooked_haunch, "saltHaunchCooked");
        GameRegistry.registerItem(cured_meat, "cornedBeef");
        GameRegistry.registerItem(salt_cooked_cod, "saltFishCodCooked");
        GameRegistry.registerItem(salt_cooked_salmon, "saltFishSalmonCooked");
        GameRegistry.registerItem(cooked_tropical_fish, "cooked_tropical_fish");
        GameRegistry.registerItem(salt_cooked_tropical_fish, "saltFishClownfishCooked");
        GameRegistry.registerItem(tailor, "tailor");
        GameRegistry.registerItem(cooked_tailor, "cooked_tailor");
        GameRegistry.registerItem(salt_cooked_tailor, "salt_cooked_tailor");
        GameRegistry.registerItem(calamari, "calamariRaw");
        GameRegistry.registerItem(cooked_calamari, "calamariCooked");
        GameRegistry.registerItem(salt_cooked_calamari, "saltCalamariCooked");
        GameRegistry.registerItem(salt_bread, "saltBread");
        GameRegistry.registerItem(salt_baked_potato, "saltPotatoBaked");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(salt_beetroot, "saltBeetroot");
        }
        GameRegistry.registerItem(salt_egg, "saltEgg");
        GameRegistry.registerItem(salt_mushroom_stew, "saltMushroomStew");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(salt_rabbit_stew, "saltRabbitStew");
            GameRegistry.registerItem(salt_beetroot_soup, "saltBeetrootSoup");
        }
        GameRegistry.registerItem(pumpkin_porridge, "pumpkinPorridge");
        GameRegistry.registerItem(salt_pumpkin_porridge, "saltPumpkinPorridge");
        GameRegistry.registerItem(cactus_stew, "cactusStew");
        GameRegistry.registerItem(salt_cactus_stew, "saltCactusStew");
        GameRegistry.registerItem(stewed_vegetables, "vegetableStew");
        GameRegistry.registerItem(salt_stewed_vegetables, "saltVegetableStew");
        GameRegistry.registerItem(potato_mushroom, "potatoMushroom");
        GameRegistry.registerItem(salt_potato_mushroom, "saltPotatoMushroom");
        GameRegistry.registerItem(golden_vegetables, "golden_vegetables");
        GameRegistry.registerItem(salt_golden_vegetables, "salt_golden_vegetables");
        GameRegistry.registerItem(fish_soup, "fishSoup");
        GameRegistry.registerItem(salt_fish_soup, "saltFishSoup");
        GameRegistry.registerItem(dandelion_salad, "dandelionSalad");
        GameRegistry.registerItem(salt_dandelion_salad, "saltDandelionSalad");
        GameRegistry.registerItem(wheat_sprouts, "wheatSprouts");
        GameRegistry.registerItem(salt_wheat_sprouts, "saltWheatSprouts");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(beetroot_salad, "beetrootSalad");
            GameRegistry.registerItem(salt_beetroot_salad, "saltBeetrootSalad");
            GameRegistry.registerItem(dressed_herring, "herringUFC");
            GameRegistry.registerItem(salt_dressed_herring, "saltHerringUFC");
        }
        GameRegistry.registerItem(saltwort_salad, "saltWortSalad");
        GameRegistry.registerItem(golden_saltwort_salad, "golden_saltwort_salad");
        GameRegistry.registerItem(saltwort_cooked_porkchop, "saltWortPorkchop");
        GameRegistry.registerItem(saltwort_honey_porkchop, "saltwort_honey_porkchop");
        GameRegistry.registerItem(saltwort_cooked_beef, "saltWortBeef");
//        if(Loader.isModLoaded("netherlicious")) {
            GameRegistry.registerItem(saltwort_cooked_strider, "saltwort_cooked_strider");
//        }
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(saltwort_cooked_mutton, "saltWortMutton");
        }
        GameRegistry.registerItem(saltwort_cooked_haunch, "saltWortHaunch");
        GameRegistry.registerItem(sugar_apple, "sugar_apple");
        GameRegistry.registerItem(sugar_melon, "sugar_melon");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(sugar_berries, "sugar_berries");
        }
        GameRegistry.registerItem(fruit_salad, "fruitSalad");
        GameRegistry.registerItem(sugar_fruit_salad, "sugarFruitSalad");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(golden_fruit_salad, "golden_fruit_salad");
            GameRegistry.registerItem(sugar_golden_fruit_salad, "sugar_golden_fruit_salad");
        }
        GameRegistry.registerItem(grated_carrot, "gratedCarrot");
        GameRegistry.registerItem(sugar_grated_carrot, "sugarGratedCarrot");
        GameRegistry.registerItem(melon_soup, "melonSoup");
        GameRegistry.registerItem(sugar_melon_soup, "sugarMelonSoup");
        GameRegistry.registerItem(honey_porkchop, "honey_porkchop");
        GameRegistry.registerItem(honey_apple, "honey_apple");
        GameRegistry.registerItem(honey_berries, "honey_berries");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(chocolate_berries, "chocolateBerries");
        }
        GameRegistry.registerItem(chocolate_bar, "chocolateBar");
        GameRegistry.registerItem(chocolate_pie, "chocolatePie");
        GameRegistry.registerItem(apple_pie, "applePie");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(sweetberry_pie, "sweetberryPie");
        }
        GameRegistry.registerItem(carrot_pie, "carrotPie");
        GameRegistry.registerItem(mushroom_pie, "mushroomPie");
        GameRegistry.registerItem(potato_pie, "potatoPie");
        GameRegistry.registerItem(onion_pie, "onionPie");
        GameRegistry.registerItem(shepherds_pie, "shepherdsPie");
        GameRegistry.registerItem(shepherds_pie, "shepherdsPie");
        GameRegistry.registerItem(cod_pie, "fishPie");
        GameRegistry.registerItem(salmon_pie, "fishSalmonPie");
        GameRegistry.registerItem(tropical_fish_pie, "fishClownfishPie");
        GameRegistry.registerItem(tailor_pie, "tailor_pie");
        GameRegistry.registerItem(calamari_pie, "calamariPie");
        GameRegistry.registerItem(saltwort_pie, "saltWortPie");
        GameRegistry.registerItem(fermented_saltwort, "fermentedSaltWort");
        GameRegistry.registerItem(pickled_fern, "pickledFern");
        GameRegistry.registerItem(pickled_mushroom, "pickledMushroom");
        GameRegistry.registerItem(pickled_calamari, "pickledCalamari");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(pickled_beetroot, "pickled_beetroot");
        }
        GameRegistry.registerItem(pickled_onion, "pickledOnion");
        GameRegistry.registerItem(apple_preserves, "apple_preserves");
        GameRegistry.registerItem(melon_preserves, "melon_preserves");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(berry_preserves, "berry_preserves");
        }
        GameRegistry.registerItem(tunneler_concoction, "tunneler_concoction");
        GameRegistry.registerItem(fizzy_drink, "fizzyDrink");
        GameRegistry.registerItem(muffin, "muffin");
        GameRegistry.registerItem(mud_helmet, "mudHelmet");
        GameRegistry.registerItem(mud_chestplate, "mudChestplate");
        GameRegistry.registerItem(mud_leggings, "mudLeggings");
        GameRegistry.registerItem(mud_boots, "mudBoots");
        GameRegistry.registerItem(tough_jelly, "toughJelly");
        GameRegistry.registerItem(rainmaker_star, "rainmaker_star");
        GameRegistry.registerItem(rainmaker, "rainmaker");
//        if(Loader.isModLoaded("etfuturum")) {
//            GameRegistry.registerItem(itemBlossomBoat, "itemBlossomBoat");
//            GameRegistry.registerItem(itemBlossomChestBoat, "itemBlossomChestBoat");
//            GameRegistry.registerItem(itemBlossomSign, "itemBlossomSign");
//        }

        if(Loader.isModLoaded("TwilightForest")) {
            GameRegistry.registerItem(tf_salt_cooked_venison, "tf_saltVenisonCooked");
            GameRegistry.registerItem(tf_salt_meef_steak, "tf_saltMeefSteak");
            GameRegistry.registerItem(tf_salt_meef_stroganoff, "stf_altMeefStroganoff");
            GameRegistry.registerItem(tf_salt_hydra_chop, "tf_saltHydraChop");
            GameRegistry.registerItem(tf_pickled_mushgloom, "tf_pickledMushgloom");
            GameRegistry.registerItem(tf_saltwort_cooked_venison, "tf_saltWortVenison");
            GameRegistry.registerItem(tf_saltwort_meef_steak, "tf_saltWortMeefSteak");
        }
        if(Loader.isModLoaded("BiomesOPlenty")) {
            GameRegistry.registerItem(bop_poison, "bop_poison");
            GameRegistry.registerItem(bop_salt_shroom_powder, "bop_saltShroomPowder");
            GameRegistry.registerItem(bop_sugar_fruit_salad, "bop_sugarSaladFruit");
            GameRegistry.registerItem(bop_salt_veggie_salad, "bop_saltSaladVeggie");
            GameRegistry.registerItem(bop_salt_shroom_salad, "bop_saltSaladShroom");
            GameRegistry.registerItem(bop_salt_rice_bowl, "bop_saltRiceBowl");
            GameRegistry.registerItem(bop_pickled_turnip, "bop_pickledTurnip");
        }

        SaltMod.logger.info("Finished initializing Items");
    }
}
