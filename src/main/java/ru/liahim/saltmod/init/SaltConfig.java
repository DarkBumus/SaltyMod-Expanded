package ru.liahim.saltmod.init;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.config.Configuration;
import ru.liahim.saltmod.SaltMod;
import ru.liahim.saltmod.common.CommonProxy;
import ru.liahim.saltmod.item.MainItems;
import ru.liahim.saltmod.item.SaltFood;

public class SaltConfig extends Configuration {

  public static int saltOreFrequency;
  
  public static int saltOreSize;
  
  public static int saltDeepslateOreHeight;
  
  public static int saltLakeGroupRarity;
  
  public static int saltLakeQuantity;
  
  public static int saltLakeDistance;
  
  public static int saltLakeRadius;
  
  public static int saltCrystalGrowSpeed;
  
  public static int saltWortGrowSpeed;
  
  public static boolean fizzyEffect;
  
  public static boolean mudArmorWaterDam;
  
  public static int mudRegenSpeed;
  
  public static boolean mudBrickComplex;
  
  public static int extractorVolume;
  
  public static Map<Integer, Integer> cloudLevel;
  
  private String[] loadedCloudLevel;
  
  public static int TFDim;
  
  public static boolean TFOreGen;
  
  public static int SaltMarshBiomeID;
  
  public static int SaltMarshBiomeWeight;
  
  public static int saltOreFrequencyBiome;
  
  public static boolean saltOreBiome;
  
  public static boolean enableBrickmakerCamp;
  
  public static int brickmakerCampFrequency;
  
  private File file;
  
  public SaltConfig(File file) {
    super(file);
    this.file = file;
  }
  
  public void preInit() {
    String[] defaultCloudLevel = { "0=128", "7=160" };
    load();
    saltOreFrequency = getInt("SaltOreFrequency", "World", 4, 1, 10, "Salt ore frequency");
    saltOreSize = getInt("SaltOreSize", "World", 5, 1, 10, "Salt ore size");
    saltDeepslateOreHeight = getInt("SaltDeepslateOreHeight", "World", 22, 2, 94, "Salt Deepslate Ore Height");
    saltLakeGroupRarity = getInt("SaltLakeGroupRarity", "World", 500, 1, 1000, "Rarity of the salt lake groups");
    saltLakeQuantity = getInt("SaltLakeQuantity", "World", 5, 1, 10, "The maximum quantity of the salt lakes in the salt lake groups");
    saltLakeDistance = getInt("SaltLakeDistance", "World", 30, 10, 50, "The maximum distance between the salt lakes in the salt lake groups");
    saltLakeRadius = getInt("SaltLakeRadius", "World", 20, 5, 50, "The maximum radius of the salt lake");
    saltCrystalGrowSpeed = getInt("SaltCrystalGrowRate", "Farm", 14, 1, 20, "The salt crystals growth rate (1 - fastly, 20 - slowly)");
    saltWortGrowSpeed = getInt("SaltWortGrowRate", "Farm", 7, 1, 20, "The saltwort growth rate (1 - fastly, 20 - slowly)");
    mudBrickComplex = getBoolean("Makes Mud Bricks complex [Currently doesn't do anything and only disables the recipe to get dry mud bricks]", "Blocks", false, "If true, makes Wet Mud Bricks dry when put on the ground, instead of in the furnace");
    extractorVolume = getInt("EvaporatorVolume", "Evaporator", 1, 1, 3, "The number of buckets in evaporator");
    fizzyEffect = getBoolean("FizzyEffect", "Effects", false, "Do Fizzy Drink removes all effects? (true - all effects, false - milk analogue)");
    mudArmorWaterDam = getBoolean("MudArmorWaterDamage", "Armor", true, "Mud Armor water damage");
    mudRegenSpeed = getInt("MudRegenSpeed", "Effects", 100, 10, 100, "Speed of Mud Armor & Block regeneration effect (10 - fastly, 100 - slowly)");
    this.loadedCloudLevel = getStringList("DimCloudLevel", "Rainmaker", defaultCloudLevel, "The height of the clouds in a specific dimension (DimensionID=CloudLevel)");
    TFOreGen = getBoolean("TFOreGen", "TwilightForest", true, "Salt ore generation in the Twilight Forest dimention");
    SaltMarshBiomeID = get("Biome Generation", "SaltMarsh ID, set to -1 to completly disable the Biome", 40).getInt(40);
    SaltMarshBiomeWeight = get("Biome Generation", "SaltMarsh Weight, The spawn chance of this biome", 10).getInt(10);
    saltOreFrequencyBiome = getInt("Additional SaltOreFrequency", "Biome Generation", 4, 1, 10, "Additional Salt ore frequency in SaltMarsh");
    saltOreBiome = getBoolean("Generate Additional Salt Ore", "Biome Generation", true, "If true, generates additional salt ore in SaltMarsh");
    enableBrickmakerCamp = getBoolean("Enables Brickmaker Camps", "Biome Generation", true, "If true, spawns Brickmaker Camps in the Salt Marsh");
    brickmakerCampFrequency = getInt("BrickmakerCampFrequency", "Biome Generation", 300, 10, 1000, "Changes the frequency of Brickmaker Camps in Salt Marshes");
    save();
  }
  
  public void init() {
    Configuration configTF = new Configuration(new File("./config", "TwilightForest.cfg"));
    configTF.load();
    TFDim = configTF.get("dimension", "dimensionID", 7).getInt();
  }
  
  public void postInit() {
    cloudLevel = new HashMap<Integer, Integer>();
    Pattern splitpattern = Pattern.compile("=");
    for (int i = 0; i < this.loadedCloudLevel.length; i++) {
      String s = this.loadedCloudLevel[i];
      String[] pair = splitpattern.split(s);
      if (pair.length != 2) {
        SaltMod.logger.warn("Invalid key-value pair at DimCloudLevel[" + i + "]");
      } else {
        int dim, level;
        try {
          dim = Integer.parseInt(pair[0]);
        } catch (NumberFormatException e) {
          SaltMod.logger.warn("Cannot parse DimensionID \"" + pair[0] + "\" to integer point at DimCloudLevel line " + (i + 1));
          break;
        } 
        try {
          level = Integer.parseInt(pair[1]);
        } catch (NumberFormatException e) {
          SaltMod.logger.warn("Cannot parse CloudLevel \"" + pair[1] + "\" to integer point at DimCloudLevel line " + (i + 1));
          break;
        } 
        cloudLevel.put(Integer.valueOf(dim), Integer.valueOf(level));
      } 
    } 
  }
}