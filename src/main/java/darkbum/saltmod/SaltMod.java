package darkbum.saltmod;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.versioning.ComparableVersion;
import cpw.mods.fml.common.registry.GameRegistry;

import darkbum.saltmod.common.*;
import darkbum.saltmod.structure.ChestLootHandler;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.util.EnumChatFormatting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import darkbum.saltmod.init.ModBiomes;
import darkbum.saltmod.init.ModBlocks;
import darkbum.saltmod.init.ModItems;
import darkbum.saltmod.init.SaltConfig;
import darkbum.saltmod.structure.ChestContent;

@Mod(modid = SaltMod.MODID, name = SaltMod.NAME, version = SaltMod.VERSION)
public class SaltMod {
    public static final String MODID = "SaltMod";

    public static final String NAME = "Saltymod Expanded";

    public static final String VERSION = "GRADLETOKEN_VERSION";

    public static final Logger logger = LogManager.getLogger("Salty Mod Expanded");

    public static ChestContent chestConent;

    public static SaltConfig config;

    @Instance("SaltMod")
    public static SaltMod instance;

    @SidedProxy(clientSide = "darkbum.saltmod.common.ClientProxy", serverSide = "darkbum.saltmod.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger.info("Starting SaltMod PreInitialization");
        event.getModMetadata().name = EnumChatFormatting.GOLD+SaltMod.NAME;
        event.getModMetadata().version = EnumChatFormatting.YELLOW+SaltMod.VERSION;
        event.getModMetadata().credits = EnumChatFormatting.AQUA + "Thanks to original author Liahim85 and contributors jss2a98aj, Roadhog360, DelirusCrux, AstroTibs, Just Moe";
        config = new SaltConfig(event.getSuggestedConfigurationFile());
        config.preInit();
        ModItems.init();
        ModBlocks.init();
        ModBiomes.SaltMod();
        FishRegistry.registerItems();
        OreDictionary.init();
        RecipeRemover.init();
        ShapedRecipes.init();
        ShapelessRecipes.init();
        SmeltingRecipes.init();
        if(SaltConfig.enableBrickmakerCamp) {
            ChestLootHandler.campChest();
        }
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        config.init();
        proxy.init(event);
    if(SaltConfig.enableBrickmakerCamp) {
    	ChestContent.addDungeonLoot();
    }
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        config.postInit();
        proxy.postInit(event);

        if(Loader.isModLoaded("etfuturum") && new ComparableVersion(Loader.instance().getIndexedModList().get("etfuturum").getProcessedVersion().getVersionString()).compareTo(new ComparableVersion("2.4.4")) <= 0) {
            System.out.println("deepslate ore registered");
            ganymedes01.etfuturum.core.utils.DeepslateOreRegistry.addOre(ModBlocks.salt_ore, ModBlocks.salt_deepslate_ore);
        }

        ItemFood apple = (ItemFood) Items.apple;
        apple.healAmount = 2;
        apple.saturationModifier = 0.3F;

        ItemFood melon = (ItemFood) Items.melon;
        melon.healAmount = 1;
        melon.saturationModifier = 0.3F;
        melon.setPotionEffect(Potion.jump.id, 3, 0, 1.0F);

        Item sweet_berries = GameRegistry.findItem("etfuturum", "sweet_berries");
        if(sweet_berries instanceof ItemFood) {
            ItemFood ItemSweetBerries = (ItemFood) sweet_berries;
            ItemSweetBerries.healAmount = 1;
            ItemSweetBerries.saturationModifier = 0.3F;
        }

        Item chorus_fruit = GameRegistry.findItem("etfuturum", "chorus_fruit");
        if(chorus_fruit instanceof ItemFood) {
            ItemFood ItemChorusFruit = (ItemFood)chorus_fruit;
            ItemChorusFruit.healAmount = 1;
            ItemChorusFruit.saturationModifier = 0.3F;
        }

        ItemFood carrot = (ItemFood) Items.carrot;
        carrot.healAmount = 2;
        carrot.saturationModifier = 0.3F;

        ItemFood potato = (ItemFood) Items.potato;
        potato.healAmount = 1;
        potato.saturationModifier = 0.3F;

        Item beetroot = GameRegistry.findItem("etfuturum", "beetroot");
        if(beetroot instanceof ItemFood) {
            ItemFood ItemBeetroot = (ItemFood)beetroot;
            ItemBeetroot.healAmount = 1;
            ItemBeetroot.saturationModifier = 0.3F;
        }

        ItemFishFood fish = (ItemFishFood) Items.fish;
        fish.healAmount = 1;
        fish.saturationModifier = 0.5F;
        fish.setPotionEffect(Potion.waterBreathing.id, 3, 0, 1.0F);

        ItemFood porkchop = (ItemFood) Items.porkchop;
        porkchop.healAmount = 2;
        porkchop.saturationModifier = 0.6F;

        ItemFood beef = (ItemFood) Items.beef;
        beef.healAmount = 2;
        beef.saturationModifier = 0.6F;

        ItemFood chicken = (ItemFood) Items.chicken;
        chicken.healAmount = 1;
        chicken.saturationModifier = 0.6F;

        Item raw_rabbit = GameRegistry.findItem("etfuturum", "raw_rabbit");
        if(raw_rabbit instanceof ItemFood) {
            ItemFood ItemRabbitRaw = (ItemFood)raw_rabbit;
            ItemRabbitRaw.healAmount = 1;
            ItemRabbitRaw.saturationModifier = 0.6F;
        }

        Item raw_mutton = GameRegistry.findItem("etfuturum", "raw_mutton");
        if(raw_mutton instanceof ItemFood) {
            ItemFood ItemMuttonRaw = (ItemFood)raw_mutton;
            ItemMuttonRaw.healAmount = 2;
            ItemMuttonRaw.saturationModifier = 0.6F;
        }

        Item StriderFlankRaw = GameRegistry.findItem("netherlicious", "StriderFlankRaw");
        if(StriderFlankRaw instanceof ItemFood) {
            ItemFood ItemStriderFlankRaw = (ItemFood)StriderFlankRaw;
            ItemStriderFlankRaw.healAmount = 2;
            ItemStriderFlankRaw.saturationModifier = 0.6F;
        }

        ItemFood rotten_flesh = (ItemFood) Items.rotten_flesh;
        rotten_flesh.healAmount = 1;
        rotten_flesh.saturationModifier = 0.3F;

        ItemFood spider_eye = (ItemFood) Items.spider_eye;
        spider_eye.healAmount = 1;
        spider_eye.saturationModifier = 0.3F;

        ItemFood poisonous_potato = (ItemFood) Items.poisonous_potato;
        poisonous_potato.healAmount = 1;
        poisonous_potato.saturationModifier = 0.3F;

        ItemFood golden_apple = (ItemFood) Items.golden_apple;
        golden_apple.healAmount = 4;
        golden_apple.saturationModifier = 0.6F;

        ItemFood golden_carrot = (ItemFood) Items.golden_carrot;
        golden_carrot.healAmount = 6;
        golden_carrot.saturationModifier = 1.2F;

        ItemFood baked_potato = (ItemFood) Items.baked_potato;
        baked_potato.healAmount = 3;
        baked_potato.saturationModifier = 0.5F;

        ItemFishFood cooked_fished = (ItemFishFood) Items.cooked_fished;
        cooked_fished.healAmount = 3;
        cooked_fished.saturationModifier = 0.5F;

        ItemFood cooked_porkchop = (ItemFood) Items.cooked_porkchop;
        cooked_porkchop.healAmount = 4;
        cooked_porkchop.saturationModifier = 0.6F;

        ItemFood cooked_beef = (ItemFood) Items.cooked_beef;
        cooked_beef.healAmount = 4;
        cooked_beef.saturationModifier = 0.6F;

        ItemFood cooked_chicken = (ItemFood) Items.cooked_chicken;
        cooked_chicken.healAmount = 3;
        cooked_chicken.saturationModifier = 0.6F;

        Item cooked_rabbit = GameRegistry.findItem("etfuturum", "cooked_rabbit");
        if(cooked_rabbit instanceof ItemFood) {
            ItemFood ItemRabbitCooked = (ItemFood)cooked_rabbit;
            ItemRabbitCooked.healAmount = 3;
            ItemRabbitCooked.saturationModifier = 0.6F;
        }

        Item mutton_cooked = GameRegistry.findItem("etfuturum", "mutton_cooked");
        if(mutton_cooked instanceof ItemFood) {
            ItemFood ItemMuttonCooked = (ItemFood)mutton_cooked;
            ItemMuttonCooked.healAmount = 4;
            ItemMuttonCooked.saturationModifier = 0.6F;
        }

        Item StriderFlankCooked = GameRegistry.findItem("netherlicious", "StriderFlankCooked");
        if(StriderFlankCooked instanceof ItemFood) {
            ItemFood ItemStriderFlankCooked = (ItemFood)StriderFlankCooked;
            ItemStriderFlankCooked.healAmount = 4;
            ItemStriderFlankCooked.saturationModifier = 0.6F;
        }

        ItemFood bread = (ItemFood) Items.bread;
        bread.healAmount = 3;
        bread.saturationModifier = 0.5F;

        ItemFood mushroom_stew = (ItemFood) Items.mushroom_stew;
        mushroom_stew.healAmount = 5;
        mushroom_stew.saturationModifier = 0.7F;

        Item suspicious_stew = GameRegistry.findItem("etfuturum", "suspicious_stew");
        if(suspicious_stew instanceof ItemFood) {
            ItemFood ItemSuspiciousStew = (ItemFood) suspicious_stew;
            ItemSuspiciousStew.healAmount = 5;
            ItemSuspiciousStew.saturationModifier = 0.7F;
        }

        Item rabbit_stew = GameRegistry.findItem("etfuturum", "rabbit_stew");
        if(rabbit_stew instanceof ItemFood) {
            ItemFood ItemRabbitStew = (ItemFood)rabbit_stew;
            ItemRabbitStew.healAmount = 7;
            ItemRabbitStew.saturationModifier = 0.7F;
        }

        Item beetroot_soup = GameRegistry.findItem("etfuturum", "beetroot_soup");
        if(beetroot_soup instanceof ItemFood) {
            ItemFood ItemBeetrootSoup = (ItemFood)beetroot_soup;
            ItemBeetrootSoup.healAmount = 5;
            ItemBeetrootSoup.saturationModifier = 0.7F;
        }

        ItemFood cookie = (ItemFood) Items.cookie;
        cookie.healAmount = 2;
        cookie.saturationModifier = 0.1F;

        ItemFood pumpkin_pie = (ItemFood) Items.pumpkin_pie;
        pumpkin_pie.healAmount = 7;
        pumpkin_pie.saturationModifier = 0.9F;

        }

/*    @Mod.EventHandler
    public void missingMapping(FMLMissingMappingsEvent event) {
        for (FMLMissingMappingsEvent.MissingMapping mapping : event.getAll()) {
            if (mapping.type == GameRegistry.Type.BLOCK) {
                switch (mapping.name) {
                    case "SaltMod:saltLamp":
                        mapping.remap(GameRegistry.findBlock(MODID, "salt_lamp"));
                        break;
                    default:
                }
            }
        }
    }*/
}
