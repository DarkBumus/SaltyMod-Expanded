package darkbum.saltymod;

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

import darkbum.saltymod.common.*;
import darkbum.saltymod.potion.ModPotion;
import darkbum.saltymod.structure.ChestLootHandler;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.util.EnumChatFormatting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import darkbum.saltymod.init.ModBiomes;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.init.ModConfiguration;
import darkbum.saltymod.structure.ChestContent;

@Mod(modid = SaltyMod.MODID, name = SaltyMod.NAME, version = SaltyMod.VERSION)
public class SaltyMod {
    public static final String MODID = "saltymod";

    public static final String NAME = "SaltyMod Expanded";

    public static final String VERSION = "GRADLETOKEN_VERSION";

    public static final Logger logger = LogManager.getLogger(MODID);

    public static ChestContent chestContent;

    public static ModConfiguration config;

    @Instance("saltymod")
    public static SaltyMod instance;

    @SidedProxy(clientSide = "darkbum.saltymod.common.ClientProxy", serverSide = "darkbum.saltymod.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger.info("Starting SaltyMod Expanded PreInitialization");
        event.getModMetadata().name = EnumChatFormatting.GOLD+ SaltyMod.NAME;
        event.getModMetadata().version = EnumChatFormatting.YELLOW+ SaltyMod.VERSION;
        event.getModMetadata().credits = EnumChatFormatting.AQUA + "Thanks to original author Liahim85 and contributors jss2a98aj, Roadhog360, DelirusCrux, AstroTibs, Just Moe";
        config = new ModConfiguration(event.getSuggestedConfigurationFile());
        config.preInit();
        ModPotion.init();
        ModItems.init();
        ModBlocks.init();
        ModBiomes.SaltMod();
        FishRegistry.registerItems();
        ModOreDictionary.init();
        RecipeRemover.init();
        ShapedRecipes.init();
        ShapelessRecipes.init();
        SmeltingRecipes.init();
        if(ModConfiguration.enableBrickmakerCamp) {
            ChestLootHandler.campChest();
        }
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        config.init();
        proxy.init(event);
    if(ModConfiguration.enableBrickmakerCamp) {
    	ChestContent.addDungeonLoot();
    }
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        config.postInit();
        proxy.postInit(event);

        if(Loader.isModLoaded("etfuturum") && new ComparableVersion(Loader.instance().getIndexedModList().get("etfuturum").getProcessedVersion().getVersionString()).compareTo(new ComparableVersion("2.4.4")) <= 0) {
            System.out.println("deepslate ore registered");
            ganymedes01.etfuturum.core.utils.DeepslateOreRegistry.addOre(ModBlocks.salt_ore, ModBlocks.deepslate_salt_ore);
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
/*        //TO-DO-LIST//
            Things I can do on my own (probably):

            - Restructure/Merge Items?
            - Restructure Config and Achiev file/class
            - At least think of a way to automate fishing


            Things I (might) need help with:

            - Potion Effect [Well Fed]
            - Create/Finish Brickmaker Camps [Schematica?]
            - Rainmaker behavior!!!
            - Create/Finish Blossom Sign [Later Boat&Chest Boat&Hanging Sign]
            - Tackle Powdered Milk Recipe [Duplicating Bucket]
            - Underground Salt Lakes?
            - Underground Salt Caves/Tunnels/Mines?
            - Mix Salt Flower Patches
            - Fix Fish Hunger Values [Probably set up Mixins in general?
            - Change particles of the Swarmed effect
            - Change Heart texture of the Swarmed effect
            - Make the "automate fishing" idea work, lol
            - Recipe Book [LATER, ALSO MAYBE]


            Things I probably have to outsource (sorted by order of importance):

            - Fix Saltwort/Salt Dirt behavior (!!!)
                - When Saltwort item is placed on Salt Dirt, it's supposed to tick down the meta value of the dirt from 3 down to 0, with every growth state (0 to 4)
                - When there is insufficient salt supply in the dirt (for example if Saltwort is placed on Dirt or Salt Dirt (meta 0), saltwort is supposed to
                  jump from growth state 0 right to "dead" (in regular "growth time", not, like... instantly, you know what I mean :P)
                - Resulting Growth state/dirt stages:
                    - Salt Dirt: 3 | Saltwort: 0 (freshly placed)
                    - Salt Dirt: 3 | Saltwort: 1
                    - Salt Dirt: 2 | Saltwort: 2
                    - Salt Dirt: 1 | Saltwort: 3
                    - Salt Dirt: 0 | Saltwort: 4
            - Finish Blossom Burrow/Tree (!!)
                - Roadhog wanted to consolidate BlockBlossomLog & BlockBlossomBurrow (and BlockBlossomStrippedLog & BlockBlossomStrippedBurrow, respectively),
                  while making Burrows rotate properly (Burrows are not supposed to be BlockRotatedPillars)
                - Just add the Burrow to the tree (just under the leaves, still visible) and have it choose a random Meta value out of 2, 3, 4, 5
            - Fix unused/undefined meta value of BlockSaltDirt and BlockSaltGrass from being used in Salt Lake generation (!!)
                - Refer to the respective classes to see which meta values are actually being defined/used)
            - Finish Salt Marsh (!)
                - Flatter (at most (!) 3 blocks above water level)
                - More water being produced in general
                - Water being completely lined with Mineral Mud Blocks (Without them being everywhere under the surface)
                - If you get the better color blending to work, that'd be nice too ¯\_(ツ)_/¯)
                - Lying logs
                    - (If you manage) have the BlockSaltCrustedOakLog be a BlocKRotatedPillar, that, which ever side is set to lie on the ground,
                      will display a salt-crusted effect (Textures are in textures/blocks/oak_log_*)
                    - They should generate alongside the usual Salt Marsh trees (This in combination with a higher water-to-land ratio, should result in a nice blend,
                      especially when we make Brickmaker Camps work)
                - Reeds/Water Grass
                    - Two blocks high
                    - Grow on Mineral Mud Blocks
                    - Grow underwater (one part underwater, one part above the surface, refer to BoP)
                    - [Undecided on Drops still]

            - Finish Apiary [as a whole]
                - GUI texture is in textures/gui/container under "apiary" (Additional "explanation" will be provided in textures/gui/container/dev/apiary [EXPLANATION])
                - Left top slot is supposed to house either the bee or the larva
                - Left bottom slot is supposed to house only blossoms (the item)
                - When a bee is inside the top left slot, the rest of the slots are to be slowly fill up with
                  wax combs, honey combs, bee larvae (refer to HarvestCraft for probabilities, only 1-2 larvae (meta value: 0) should be generated per bee),
                  while the bee ticks down (meta values 0 - 18 already present)
                    - (If possible) after every "column" is filled, it's supposed to change the meta value of the block
                    - 0: Completely empty
                    - 1: 3 slots filled
                    - 2: 6 slots filled
                    - 3: 9 slots filled
                    - 4: 12 slots filled
                    - 5: 15 slots filled
                    - 6: 18 slots filled
                    - Every of that meta values should have a new side texture attached to it (textures/blocks/apiary_front_*)
                - When the apiary is surrounded by flower blocks, that's supposed to fasten up the filling process
                - When a blossom item is inside the lower slot, that's supposed to fasten up the filling process even more, but deleting one blossom every time
                  a slot on the right side is filled
                - When a larva is inside the top left slot, the rest of the slots are to be slowly fill up with
                  wax combs and royal jelly (royal jelly having the same probabilities as larvae above (only 1-2 royal jelly per larva),
                  while the larva ticks down (meta values 0 - 18 aready present)
                - If you a bee or a larva is inside the slot and the Apiary is being broken, you should get the Swarmed effect for 900 ticks with
                  "saltymod:block.blossom_burrow.bees" sound effect playing (refer to BlockBlossomBurrow for volume and pitch)
                    - This effect should be turned off, when either fire (or a lit campfire, if possible) is detected below the Apiary, while it's being broken
                    - The bee/larva is only to drop when said block is detected blow the Apiary
                - Interaction with hopper/comparator would be neat
                    - Hoppers could funnel in bees/larva and blossoms, depending on where they're being put in (like with the furnace, ore/meat goes in the top,
                      coal goes in the side), while all the "result" items (waxcomb, honeycomb, larvae (meta 0), royal jelly), can be pulled out from the bottom
                    - Comparators could register how many items are in there and put out a set redstone strength depending on the meta value/amount of items inside)
            - (Maybe) Fix rendering of Blossom Trapdoor in inventory (low priority)*/
}
