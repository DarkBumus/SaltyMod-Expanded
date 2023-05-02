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
import darkbum.saltymod.configuration.ModConfiguration;
import darkbum.saltymod.potion.ModPotion;
import darkbum.saltymod.structure.ChestLootHandler;
import net.minecraft.util.EnumChatFormatting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import darkbum.saltymod.init.ModBiomes;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.structure.ChestContent;

@Mod(modid = SaltyMod.MODID, name = SaltyMod.NAME, version = SaltyMod.VERSION, acceptedMinecraftVersions = "[1.7.10]", dependencies = SaltyMod.DEPENDENCIES)
public class SaltyMod {
    public static final String MODID = "saltymod";

    public static final String NAME = "SaltyMod Expanded";

    public static final String VERSION = "GRADLETOKEN_VERSION";

    public static final String DEPENDENCIES = "after:etfuturum";

    public static final Logger logger = LogManager.getLogger(MODID);

    public static ChestContent chestContent;

//    public static OldModConfiguration config;

    public static ModConfiguration config;

    @Instance("saltymod")
    public static SaltyMod instance;

    @SidedProxy(clientSide = "darkbum.saltymod.common.ClientProxy", serverSide = "darkbum.saltymod.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger.info("Starting SaltyMod Expanded PreInitialization");
        event.getModMetadata().name = EnumChatFormatting.GOLD + SaltyMod.NAME;
        event.getModMetadata().version = EnumChatFormatting.YELLOW + SaltyMod.VERSION;
        event.getModMetadata().credits = EnumChatFormatting.AQUA + "Thanks to original author Liahim85 and contributors jss2a98aj, Roadhog360, DelirusCrux, AstroTibs, Just Moe";
//        config = new OldModConfiguration(event.getSuggestedConfigurationFile());
        config = new ModConfiguration(event.getSuggestedConfigurationFile());
        config.preInit();
        ModPotion.init();
        ModItems.init();
        ModBlocks.init();
        ModBiomes.SaltMod();
        ModFishRegistry.registerItems();
        GameRegistry.registerFuelHandler(new ModFuelHandler());
        if (ModConfiguration.enableBrickmakerCamp) {
            ChestLootHandler.campChest();
        }
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        config.init();
        proxy.init(event);
        ModOreDictionary.init();
        ModRecipeRemover.init();
        ModShapedRecipes.init();
        ModShapelessRecipes.init();
        ModSmeltingRecipes.init();
        if (ModConfiguration.enableBrickmakerCamp) {
            ChestContent.addDungeonLoot();
        }
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        config.postInit();
        proxy.postInit(event);
        ModExternalRecipes.init();
        ModExternalFoodValueRegistry.init();
        if(ModConfiguration.enableSaltOre && Loader.isModLoaded("etfuturum") && new ComparableVersion(Loader.instance().getIndexedModList().get("etfuturum").getProcessedVersion().getVersionString()).compareTo(new ComparableVersion("2.4.5")) <= 0) {
            System.out.println("deepslate ore registered");
            ganymedes01.etfuturum.core.utils.DeepslateOreRegistry.addOre(ModBlocks.salt_ore, ModBlocks.deepslate_salt_ore);
        }
    }

/*        //TO-DO-LIST//
            Things I can do on my own (probably):
            - Restructure/Merge Items?
            - Restructure Config file/class
            - At least think of a way to automate fishing
            - Relocate Recipes to Init


            Things I (might) need help with:
            - PROPERLY SET REFERENCES WITHOUT HARD DEPENDENCY
            - Rainmaker behavior!!!
            - Create/Finish Blossom Sign [Later Boat&Chest Boat&Hanging Sign]
            - Tackle Powdered Milk Recipe [Duplicating Bucket]
            - Change particles of the Swarmed effect
            - Change Heart texture of the Swarmed effect
            - Mix Salt Flower Patches
            - Fix Fish Hunger Values [Probably set up Mixins in general?]
            - Cast ItemStack to set potion effects to pies
            - Set Sweetberry Pie to only register if EFR is loaded
            - Fix up Evaporator behavior
            - Create/Finish Brickmaker Camps [Schematica?]
            - Underground Salt Lakes? [MAYBE]
            - Underground Salt Caves/Tunnels/Mines? [MAYBE]
            - Make the "automate fishing" idea work, lol
            - Recipe Book [LATER, ALSO MAYBE]
            - Change EFR's suspicious stew from giving Saturation to giving Well Fed
            - Fix up the latest Config changes
                - Specify singular blocks from Array Lists (Preventing Onion Alliums crashing the AlliumPatch.java when Salt Flowers are deactivated)
                - Same as above, singleing out Onion Crates to deactivate without removing all storage blocks)


            Things I probably have to outsource (sorted by order of importance): ##################### HI JONATHAN :) ###########################
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
                - Just add the Burrow to the tree (just under the leaves, still visible, and only when naturally generating) and have it choose a random Meta value out of 0, 1, 2, 3.
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
            - Fix the "Bee Resistant" functionality in the "Swarmed" effect
            - (Maybe) Fix rendering of Blossom Trapdoor in inventory (low priority)*/
}
