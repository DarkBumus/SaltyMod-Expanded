package ru.liahim.saltmod.init;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import ru.liahim.saltmod.SaltMod;
import ru.liahim.saltmod.common.CommonProxy;
import ru.liahim.saltmod.item.AchievItem;
import ru.liahim.saltmod.item.ChocolateBar;
import ru.liahim.saltmod.item.CobblerConcoction;
import ru.liahim.saltmod.item.EffectFoodPos;
import ru.liahim.saltmod.item.EffectFoodNeg;
import ru.liahim.saltmod.item.FizzyDrink;
import ru.liahim.saltmod.item.MainItems;
import ru.liahim.saltmod.item.MudArmor;
import ru.liahim.saltmod.item.Muffin;
import ru.liahim.saltmod.item.Rainmaker;
import ru.liahim.saltmod.item.Salt;
import ru.liahim.saltmod.item.SaltFood;
import ru.liahim.saltmod.item.SaltWortSeed;
import ru.liahim.saltmod.item.HungerFood;
import ru.liahim.saltmod.item.StuffedFood;

public class ModItems {
    static CreativeTabs tab = CommonProxy.saltTab;

    public static Item hungerFood = new HungerFood("hungerFood", tab, "HungerFood").setTextureName("saltmod:" + "dev/" + "HungerFood");

    public static Item stuffedFood = new StuffedFood("stuffedFood", tab, "StuffedFood").setTextureName("saltmod:" + "dev/" + "StuffedFood");

    public static Item effectFoodPos = new EffectFoodPos("effectFoodPos", tab, "EffectFoodPos").setTextureName("saltmod:" + "dev/" + "EffectFoodPos");

    public static Item effectFoodNeg = new EffectFoodNeg("effectFoodNeg", tab, "EffectFoodNeg").setTextureName("saltmod:" + "dev/" + "EffectFoodNeg");

//  field_76434_w = Health Boost
//  field_76443_y = Saturation
//  field_76444_x = Absorption
//    public static Item testFood = new SaltFood("testFood", 8, 0.6F, new PotionEffect[0]).setAlwaysEdible().setCreativeTab(tab).setTextureName("saltmod:" + "dev/" + "TestFood");

    public static Item achievItem = new AchievItem("achievItem", null);

    public static Item goldenPotato = (new SaltFood("goldenPotato", 6, 0.9F, new PotionEffect(Potion.regeneration.id, 60, 0) ).setCreativeTab(tab).setTextureName("saltmod:GoldenPotato"));

    public static Item goldenBerries = (new SaltFood("goldenBerries", 2, 1.2F).setCreativeTab(tab).setTextureName("saltmod:GoldenBerries"));

    public static Item fishClownfishCooked = new SaltFood("fishClownfishCooked", 4, 0.6F).setCreativeTab(tab).setTextureName("saltmod:FishClownfishCooked");

    public static Item haunchRaw = new SaltFood("haunchRaw", 3, 0.3F).setCreativeTab(tab).setTextureName("saltmod:HaunchRaw");

    public static Item haunchCooked = new SaltFood("haunchCooked", 8, 0.8F).setCreativeTab(tab).setTextureName("saltmod:HaunchCooked");

    public static Item calamariRaw = new SaltFood("calamariRaw", 2, 0.1F).setCreativeTab(tab).setTextureName("saltmod:CalamariRaw");

    public static Item calamariCooked = new SaltFood("calamariCooked", 5, 0.6F).setCreativeTab(tab).setTextureName("saltmod:CalamariCooked");

    public static Item mineralMud = new MainItems("mineralMud", tab, "MineralMud");

    public static Item soda = new MainItems("soda", tab, "Soda");

    public static Item powderedMilk = new MainItems("powderedMilk", tab, "PowderedMilk");

    public static Item salt = new Salt("salt", tab, "Salt");

    public static Item saltPinch = new MainItems("saltPinch", tab, "SaltPinch");

    public static Item sugarPinch = new MainItems("sugarPinch", tab, "SugarPinch");

    public static Item escargot = ((ItemFood)(new SaltFood("escargot", 2, 0.1F)).setAlwaysEdible().setCreativeTab(tab)).setPotionEffect(Potion.confusion.id, 15, 0, 0.3F).setTextureName("saltmod:Escargot");

    public static Item saltWortSeed = new SaltWortSeed("saltWortSeed", tab);

    public static Item goldenSaltWortSeed = new SaltFood("goldenSaltWortSeed", 6, 0.8F, new PotionEffect(Potion.regeneration.id, 80, 1) ).setCreativeTab(tab).setTextureName("saltmod:GoldenSaltWortSeed");

    public static Item blossom = new MainItems("blossom", tab, "Blossom");

    public static Item queenBee = new MainItems("queenBee", tab, "QueenBee");

    public static Item waxComb = new MainItems("waxComb", tab, "WaxComb");

    public static Item honeyComb = new MainItems("honeyComb", tab, "HoneyComb");

    public static Item beeGrub = new MainItems("beeGrub", tab, "BeeGrub");

    public static Item royalJelly = new MainItems("royalJelly", tab, "RoyalJelly");

    public static Item saltBeefCooked = new SaltFood("saltBeefCooked", 9, 0.9F).setCreativeTab(tab).setTextureName("saltmod:SaltBeefCooked");

    public static Item saltPorkchopCooked = new SaltFood("saltPorkchopCooked", 9, 0.9F).setCreativeTab(tab).setTextureName("saltmod:SaltPorkchopCooked");

    public static Item saltMuttonCooked = new SaltFood("saltMuttonCooked", 7, 0.9F).setCreativeTab(tab).setTextureName("saltmod:SaltMuttonCooked");

    public static Item saltStriderCooked = new SaltFood("saltStriderCooked", 9, 0.9F).setCreativeTab(tab).setTextureName("saltmod:SaltStriderCooked");

    public static Item saltHaunchCooked = new SaltFood("saltHaunchCooked", 9, 0.9F).setCreativeTab(tab).setTextureName("saltmod:SaltHaunchCooked");

    public static Item saltPotatoBaked = new SaltFood("saltPotatoBaked", 7, 0.7F).setCreativeTab(tab).setTextureName("saltmod:SaltPotatoBaked");

    public static Item saltChickenCooked = new SaltFood("saltChickenCooked", 7, 0.7F).setCreativeTab(tab).setTextureName("saltmod:SaltChickenCooked");

    public static Item saltRabbitCooked = new SaltFood("saltRabbitCooked", 6, 0.7F).setCreativeTab(tab).setTextureName("saltmod:SaltRabbitCooked");

    public static Item saltFishCod = new SaltFood("saltFishCod", 5, 0.2F).setCreativeTab(tab).setTextureName("saltmod:SaltFishCod");

    public static Item saltFishCodCooked = new SaltFood("saltFishCodCooked", 6, 0.7F).setCreativeTab(tab).setTextureName("saltmod:SaltFishCodCooked");

    public static Item saltFishSalmon = new SaltFood("saltFishSalmon", 6, 0.2F).setCreativeTab(tab).setTextureName("saltmod:SaltFishSalmon");

    public static Item saltFishSalmonCooked = new SaltFood("saltFishSalmonCooked", 7, 0.9F).setCreativeTab(tab).setTextureName("saltmod:SaltFishSalmonCooked");

    public static Item saltFishClownfish = new SaltFood("saltFishClownfish", 4, 0.2F).setCreativeTab(tab).setTextureName("saltmod:SaltFishClownfish");

    public static Item saltFishClownfishCooked = new SaltFood("saltFishClownfishCooked", 5, 0.7F).setCreativeTab(tab).setTextureName("saltmod:SaltFishClownfishCooked");

    public static Item saltCalamariCooked = new SaltFood("saltCalamariCooked", 6, 0.6F).setCreativeTab(tab).setTextureName("saltmod:SaltCalamariCooked");

    public static Item cornedBeef = new SaltFood("cornedBeef", 5, 1.2F).setCreativeTab(tab).setTextureName("saltmod:CornedBeef");

    public static Item saltBread = new SaltFood("saltBread", 6, 0.7F).setCreativeTab(tab).setTextureName("saltmod:SaltBread");

    public static Item saltBeetroot = new SaltFood("saltBeetroot", 2, 0.7F).setCreativeTab(tab).setTextureName("saltmod:SaltBeetroot");

    public static Item saltEgg = new SaltFood("saltEgg", 3, 0.4F).setMaxStackSize(16).setCreativeTab(tab).setTextureName("saltmod:SaltEgg");

    public static Item saltMushroomStew = new SaltFood("saltMushroomStew", 7, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SaltMushroomStew");

    public static Item saltRabbitStew = new SaltFood("saltRabbitStew", 11, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SaltRabbitStew");

    public static Item saltBeetrootSoup = new SaltFood("saltBeetrootSoup", 7, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SaltBeetrootSoup");

    public static Item pumpkinPorridge = new SaltFood("pumpkinPorridge", 6, 0.6F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:PumpkinPorridge");

    public static Item saltPumpkinPorridge = new SaltFood("saltPumpkinPorridge", 7, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SaltPumpkinPorridge");

    public static Item cactusStew = new SaltFood("cactusStew", 3, 0.6F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 400, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:CactusStew");

    public static Item saltCactusStew = new SaltFood("saltCactusStew", 4, 0.7F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 800, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SaltCactusStew");

    public static Item vegetableStew = new SaltFood("vegetableStew", 5, 0.6F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:VegetableStew");

    public static Item saltVegetableStew = new SaltFood("saltVegetableStew", 6, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SaltVegetableStew");

    public static Item potatoMushroom = new SaltFood("potatoMushroom", 5, 0.6F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:PotatoMushroom");

    public static Item saltPotatoMushroom = new SaltFood("saltPotatoMushroom", 6, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SaltPotatoMushroom");

    public static Item goldenVegetables = new SaltFood("goldenVegetables", 6, 1.2F, Items.bowl, new PotionEffect(Potion.regeneration.id, 80, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:GoldenVegetables");

    public static Item saltGoldenVegetables = new SaltFood("saltGoldenVegetables", 7, 1.2F, Items.bowl, new PotionEffect(Potion.regeneration.id, 100, 2)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SaltGoldenVegetables");

    public static Item fishSoup = new SaltFood("fishSoup", 6, 0.6F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:FishSoup");

    public static Item saltFishSoup = new SaltFood("saltFishSoup", 7, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SaltFishSoup");

    public static Item fishSalmonSoup = new SaltFood("fishSalmonSoup", 7, 0.8F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:FishSalmonSoup");

    public static Item saltFishSalmonSoup = new SaltFood("saltFishSalmonSoup", 8, 0.9F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SaltFishSalmonSoup");

    public static Item fishClownfishSoup = new SaltFood("fishClownfishSoup", 4, 0.6F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:FishClownfishSoup");

    public static Item saltFishClownfishSoup = new SaltFood("saltFishClownfishSoup", 5, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SaltFishClownfishSoup");

    public static Item dandelionSalad = new SaltFood("dandelionSalad", 4, 0.6F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 800, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:DandelionSalad");

    public static Item saltDandelionSalad = new SaltFood("saltDandelionSalad", 5, 0.7F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 1200, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SaltDandelionSalad");

    public static Item wheatSprouts = new SaltFood("wheatSprouts", 3, 0.6F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 600, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:WheatSprouts");

    public static Item saltWheatSprouts = new SaltFood("saltWheatSprouts", 4, 0.7F, Items.bowl, new PotionEffect(Potion.field_76434_w.id, 900, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SaltWheatSprouts");

    public static Item beetrootSalad = new SaltFood("beetrootSalad", 5, 0.4F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:BeetrootSalad");

    public static Item saltBeetrootSalad = new SaltFood("saltBeetrootSalad", 6, 0.5F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SaltBeetrootSalad");

    public static Item herringUFC = new SaltFood("herringUFC", 8, 0.9F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:HerringUFC");

    public static Item saltHerringUFC = new SaltFood("saltHerringUFC", 9, 1.0F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SaltHerringUFC");

    public static Item saltWortSalad = new SaltFood("saltWortSalad", 6, 0.4F, Items.bowl, new PotionEffect(Potion.regeneration.id, 200, 1)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SaltWortSalad");

    public static Item goldenSaltWortSalad = new SaltFood("goldenSaltWortSalad", 7, 1.2F, Items.bowl, new PotionEffect(Potion.regeneration.id, 400, 1)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:GoldenSaltWortSalad");

    public static Item saltWortBeef = new SaltFood("saltWortBeef", 10, 0.9F, Items.bowl, new PotionEffect(Potion.regeneration.id, 400, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SaltWortBeef");

    public static Item saltWortPorkchop = new SaltFood("saltWortPorkchop", 10, 0.9F, Items.bowl, new PotionEffect(Potion.regeneration.id, 400, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SaltWortPorkchop");

    public static Item saltWortHoneyedPorkchop = new SaltFood("saltWortHoneyedPorkchop", 9, 0.9F, Items.bowl, new PotionEffect(Potion.regeneration.id, 400, 1), new PotionEffect(Potion.field_76444_x.id, 900, 2)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SaltWortHoneyedPorkchop");

    public static Item saltWortMutton = new SaltFood("saltWortMutton", 8, 0.9F, Items.bowl, new PotionEffect(Potion.regeneration.id, 400, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SaltWortMutton");

    public static Item saltWortHaunch = new SaltFood("saltWortHaunch", 10, 0.9F, Items.bowl, new PotionEffect(Potion.regeneration.id, 400, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SaltWortHaunch");

    public static Item sugarApple = new SaltFood("sugarApple", 5, 0.4F).setCreativeTab(tab).setTextureName("saltmod:SugarApple");

    public static Item sugarMelon = new SaltFood("sugarMelon", 3, 0.4F).setCreativeTab(tab).setTextureName("saltmod:SugarMelon");

    public static Item sugarBerries = new SaltFood("sugarBerries", 3, 0.2F).setCreativeTab(tab).setTextureName("saltmod:SugarBerries");

    public static Item fruitSalad = new SaltFood("fruitSalad", 5, 0.4F, Items.bowl, new PotionEffect(Potion.moveSpeed.id, 900, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:FruitSalad");

    public static Item sugarFruitSalad = new SaltFood("sugarFruitSalad", 6, 0.5F, Items.bowl, new PotionEffect(Potion.moveSpeed.id, 1200, 1)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SugarFruitSalad");

    public static Item goldenFruitSalad = new SaltFood("goldenFruitSalad", 5, 0.8F, Items.bowl, new PotionEffect(Potion.regeneration.id, 100, 1), new PotionEffect(Potion.field_76444_x.id, 2400), new PotionEffect(Potion.heal.id, 1)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:GoldenFruitSalad");

    public static Item sugarGoldenFruitSalad = new SaltFood("sugarGoldenFruitSalad", 6, 0.8F, Items.bowl, new PotionEffect(Potion.regeneration.id, 125, 2), new PotionEffect(Potion.field_76444_x.id, 3000, 1), new PotionEffect(Potion.heal.id, 1, 1)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SugarGoldenFruitSalad");

    public static Item gratedCarrot = new SaltFood("gratedCarrot", 5, 0.4F, Items.bowl, new PotionEffect(Potion.nightVision.id, 900, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:GratedCarrot");

    public static Item sugarGratedCarrot = new SaltFood("sugarGratedCarrot", 6, 0.5F, Items.bowl, new PotionEffect(Potion.nightVision.id, 1200, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SugarGratedCarrot");

    public static Item melonSoup = new SaltFood("melonSoup", 4, 0.4F, Items.bowl, new PotionEffect(Potion.jump.id, 900, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:MelonSoup");

    public static Item sugarMelonSoup = new SaltFood("sugarMelonSoup", 4, 0.4F, Items.bowl, new PotionEffect(Potion.jump.id, 1200, 1)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SugarMelonSoup");

    public static Item honeyedBerries = new SaltFood("honeyedBerries", 2, 0.2F, new PotionEffect(Potion.field_76444_x.id, 300)).setCreativeTab(tab).setTextureName("saltmod:HoneyedBerries");

    public static Item honeyedApple = new SaltFood("honeyedApple", 4, 0.4F, new PotionEffect(Potion.field_76444_x.id, 600, 1)).setCreativeTab(tab).setTextureName("saltmod:HoneyedApple");

    public static Item honeyedPorkchop = new SaltFood("honeyedPorkchop", 8, 0.9F, new PotionEffect(Potion.field_76444_x.id, 900, 2)).setCreativeTab(tab).setTextureName("saltmod:HoneyedPorkchop");

    public static Item chocolateBerries = new SaltFood("chocolateBerries", 2, 0.2F, new PotionEffect(Potion.digSpeed.id, 300, 0)).setCreativeTab(tab).setTextureName("saltmod:ChocolateBerries");

    public static Item chocolateBar = new ChocolateBar("chocolateBar", tab, "ChocolateBar");

    public static Item chocolatePie = new SaltFood("chocolatePie", 7, 0.3F, new PotionEffect(Potion.digSpeed.id, 900, 2)).setCreativeTab(tab).setTextureName("saltmod:ChocolatePie");

    public static Item carrotPie = new SaltFood("carrotPie", 8, 0.3F).setCreativeTab(tab).setTextureName("saltmod:CarrotPie");

    public static Item applePie = new SaltFood("applePie", 8, 0.3F).setCreativeTab(tab).setTextureName("saltmod:ApplePie");

    public static Item sweetberryPie = new SaltFood("sweetberryPie", 7, 0.3F).setCreativeTab(tab).setTextureName("saltmod:SweetberryPie");

    public static Item potatoPie = new SaltFood("potatoPie", 8, 0.3F).setCreativeTab(tab).setTextureName("saltmod:PotatoPie");

    public static Item onionPie = new SaltFood("onionPie", 7, 0.3F).setCreativeTab(tab).setTextureName("saltmod:OnionPie");

    public static Item fishPie = new SaltFood("fishPie", 8, 0.6F).setCreativeTab(tab).setTextureName("saltmod:FishPie");

    public static Item fishSalmonPie = new SaltFood("fishSalmonPie", 9, 0.6F).setCreativeTab(tab).setTextureName("saltmod:FishSalmonPie");

    public static Item fishClownfishPie = new SaltFood("fishClownfishPie", 8, 0.6F).setCreativeTab(tab).setTextureName("saltmod:FishClownfishPie");

    public static Item calamariPie = new SaltFood("calamariPie", 8, 0.6F).setCreativeTab(tab).setTextureName("saltmod:CalamariPie");

    public static Item shepherdsPie = new SaltFood("shepherdsPie", 10, 0.8F).setCreativeTab(tab).setTextureName("saltmod:ShepherdsPie");

    public static Item mushroomPie = new SaltFood("mushroomPie", 8, 0.3F).setCreativeTab(tab).setTextureName("saltmod:MushroomPie");

    public static Item saltWortPie = new SaltFood("saltWortPie", 6, 0.3F, new PotionEffect(Potion.regeneration.id, 100, 0)).setAlwaysEdible().setCreativeTab(tab).setTextureName("saltmod:SaltWortPie");

    public static Item fermentedSaltWort = new SaltFood("fermentedSaltWort", 5, 0.8F, Items.glass_bottle, new PotionEffect(Potion.regeneration.id, 600, 2)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:SaltWortFermented");

    public static Item pickledMushroom = new SaltFood("pickledMushroom", 6, 0.8F, Items.glass_bottle).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:PickledMushroom");

    public static Item pickledFern = new SaltFood("pickledFern", 4, 0.8F, Items.glass_bottle, new PotionEffect(Potion.resistance.id, 800, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:PickledFern");

    public static Item pickledCalamari = new SaltFood("pickledCalamari", 6, 0.8F, Items.glass_bottle).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:PickledCalamari");

    public static Item pickledOnion = new SaltFood("pickledOnion", 4, 0.8F, Items.glass_bottle, new PotionEffect(Potion.resistance.id, 800, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:PickledOnion");

    public static Item preservedMelon = new SaltFood("preservedMelon", 6, 0.8F, Items.glass_bottle).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:PreservedMelon");

    public static Item preservedSweetberries = new SaltFood("preservedSweetberries", 6, 0.8F, Items.glass_bottle).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:PreservedSweetberries");

    public static Item preservedApple = new SaltFood("preservedApple", 8, 0.8F, Items.glass_bottle).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:PreservedApple");

    public static Item cobblerConcoction = new CobblerConcoction("cobblerConcoction", tab, "CobblerConcoction");

    public static Item fizzyDrink = new FizzyDrink("fizzyDrink", tab, "FizzyDrink");

    public static Item muffin = new Muffin("muffin", tab, "Muffin");

    public static Item hemoglobin = new SaltFood("hemoglobin", 2, 4.0F, new PotionEffect(Potion.heal.id, 1, 1)).setAlwaysEdible().setCreativeTab(tab).setTextureName("saltmod:Hemoglobin");

    public static Item mudHelmet = new MudArmor("mudHelmet", CommonProxy.mudMaterial, 0);

    public static Item mudChestplate = new MudArmor("mudChestplate", CommonProxy.mudMaterial, 1);

    public static Item mudLeggings = new MudArmor("mudLeggings", CommonProxy.mudMaterial, 2);

    public static Item mudBoots = new MudArmor("mudBoots", CommonProxy.mudMaterial, 3);

    public static Item saltStar = new MainItems("saltStar", tab, "SaltStar");

    public static Item rainmaker = new Rainmaker("rainmaker", tab, "Rainmaker");


    public static Item tf_saltVenisonCooked = new SaltFood("tf_saltVenisonCooked", 9, 0.9F).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "TF_SaltVenisonCooked");

    public static Item tf_saltMeefSteak = new SaltFood("tf_saltMeefSteak", 7, 0.7F).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "TF_SaltMeefSteak");

    public static Item tf_saltMeefStroganoff = new SaltFood("tf_saltMeefStroganoff", 9, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "TF_SaltMeefStroganoff");

    public static Item tf_saltHydraChop = new SaltFood("tf_saltHydraChop", 19, 2.1F).setPotionEffect(Potion.regeneration.id, 5, 0, 1.0F).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "TF_SaltHydraChop");

    public static Item tf_pickledMushgloom = new SaltFood("tf_pickledMushgloom", 6, 0.8F, Items.glass_bottle, new PotionEffect(Potion.nightVision.id, 1200, 0), new PotionEffect(Potion.moveSlowdown.id, 100, 0)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "TF_PickledMushgloom");

    public static Item tf_saltWortVenison = new SaltFood("tf_saltWortVenison", 10, 0.9F, Items.bowl, new PotionEffect(Potion.regeneration.id, 100, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "TF_SaltWortVenison");

    public static Item tf_saltWortMeefSteak = new SaltFood("tf_saltWortMeefSteak", 8, 0.9F, Items.bowl, new PotionEffect(Potion.regeneration.id, 100, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:" + "tf/" + "TF_SaltWortMeefSteak");

    public static Item bop_poison = new MainItems("bop_poison", tab, "BOP_Poison").setTextureName("saltmod:" + "bop/" + "BOP_Poison");

    public static Item bop_saltShroomPowder = ((ItemFood)(new SaltFood("bop_saltShroomPowder", 2, 0.2F)).setAlwaysEdible().setCreativeTab(tab)).setPotionEffect(Potion.confusion.id, 15, 0, 0.3F).setTextureName("saltmod:" + "bop/" + "BOP_SaltShroomPowder");

    public static Item bop_sugarSaladFruit = ((ItemFood)(new SaltFood("bop_sugarSaladFruit", 7, 0.7F, Items.bowl)).setMaxStackSize(1).setCreativeTab(tab)).setPotionEffect(Potion.digSpeed.id, 1200, 2, 0.1F).setTextureName("saltmod:" + "bop/" + "BOP_SaltSaladVeggie");

    public static Item bop_saltSaladVeggie = ((ItemFood)(new SaltFood("bop_saltSaladVeggie", 7, 0.7F, Items.bowl)).setMaxStackSize(1).setCreativeTab(tab)).setPotionEffect(Potion.field_76434_w.id, 1550, 2, 0.1F).setTextureName("saltmod:" + "bop/" + "BOP_SaltSaladVeggie");

    public static Item bop_saltSaladShroom = ((ItemFood)(new SaltFood("bop_saltSaladShroom", 7, 0.7F, Items.bowl)).setMaxStackSize(1).setCreativeTab(tab)).setPotionEffect(Potion.jump.id, 900, 2, 0.1F).setTextureName("saltmod:" + "bop/" + "BOP_SaltSaladShroom");

    public static Item bop_saltRiceBowl = new SaltFood("bop_saltRiceBowl", 3, 0.2F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:" + "bop/" + "BOP_SaltRiceBowl");

    public static Item bop_pickledTurnip = new SaltFood("bop_pickledTurnip", 6, 0.8F, Items.glass_bottle).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltmod:" + "bop/" + "BOP_PickledTurnip");

    public static void init() {
        SaltMod.logger.info("Start to initialize Items");
        GameRegistry.registerItem(hungerFood, "hungerFood");
        GameRegistry.registerItem(stuffedFood, "stuffedFood");
        GameRegistry.registerItem(effectFoodPos, "effectFoodPos");
        GameRegistry.registerItem(effectFoodNeg, "effectFoodNeg");
//        GameRegistry.registerItem(testFood, "testFood");
        GameRegistry.registerItem(achievItem, "achivItem");
        GameRegistry.registerItem(goldenPotato, "goldenPotato");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(goldenBerries, "goldenBerries");
        }
        GameRegistry.registerItem(fishClownfishCooked, "fishClownfishCooked");
        GameRegistry.registerItem(haunchRaw, "haunchRaw");
        GameRegistry.registerItem(haunchCooked, "haunchCooked");
        GameRegistry.registerItem(calamariRaw, "calamariRaw");
        GameRegistry.registerItem(calamariCooked, "calamariCooked");
        GameRegistry.registerItem(mineralMud, "mineralMud");
        GameRegistry.registerItem(soda, "soda");
        GameRegistry.registerItem(powderedMilk, "powderedMilk");
        GameRegistry.registerItem(salt, "salt");
        GameRegistry.registerItem(saltPinch, "saltPinch");
        GameRegistry.registerItem(sugarPinch, "sugarPinch");
        GameRegistry.registerItem(escargot, "escargot");
        GameRegistry.registerItem(saltWortSeed, "saltWortSeed");
        GameRegistry.registerItem(goldenSaltWortSeed, "goldenSaltWortSeed");
        GameRegistry.registerItem(blossom, "blossom");
        GameRegistry.registerItem(queenBee, "queenBee");
        GameRegistry.registerItem(waxComb, "waxComb");
        GameRegistry.registerItem(honeyComb, "honeyComb");
        GameRegistry.registerItem(beeGrub, "beeGrub");
        GameRegistry.registerItem(royalJelly, "royalJelly");
        GameRegistry.registerItem(saltBeefCooked, "saltBeefCooked");
        GameRegistry.registerItem(saltPorkchopCooked, "saltPorkchopCooked");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerItem(saltMuttonCooked, "saltMuttonCooked");
        }
        if(Loader.isModLoaded("netherlicious")) {
            GameRegistry.registerItem(saltStriderCooked, "saltStriderCooked");
        }
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
        GameRegistry.registerItem(saltFishClownfish, "saltFishClownfish");
        GameRegistry.registerItem(saltFishClownfishCooked, "saltFishClownfishCooked");
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
        if(Loader.isModLoaded("sbv")) {
            GameRegistry.registerItem(goldenVegetables, "goldenVegetables");
            GameRegistry.registerItem(saltGoldenVegetables, "saltGoldenVegetables");
        }
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
        if(Loader.isModLoaded("harvestcraft") || Loader.isModLoaded("Forestry") || Loader.isModLoaded("Growthcraft|Bees")|| Loader.isModLoaded("BiomesOPlenty")) {
            GameRegistry.registerItem(saltWortHoneyedPorkchop, "saltWortHoneyedPorkchop");
        }
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
        if(Loader.isModLoaded("etfuturum") && Loader.isModLoaded("harvestcraft") || Loader.isModLoaded("Forestry") || Loader.isModLoaded("Growthcraft|Bees") || Loader.isModLoaded("BiomesOPlenty")) {
            GameRegistry.registerItem(honeyedBerries, "honeyedBerries");
        }
        if(Loader.isModLoaded("harvestcraft") || Loader.isModLoaded("Forestry") || Loader.isModLoaded("Growthcraft|Bees")|| Loader.isModLoaded("BiomesOPlenty")) {
            GameRegistry.registerItem(honeyedApple, "honeyedApple");
            GameRegistry.registerItem(honeyedPorkchop, "honeyedPorkchop");
        }
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
        GameRegistry.registerItem(saltStar, "saltStar");
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
