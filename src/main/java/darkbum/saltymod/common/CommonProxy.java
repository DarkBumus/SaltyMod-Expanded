package darkbum.saltymod.common;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.api.EvaporateRegistry;
import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.world.generator.*;
import net.minecraft.block.BlockDispenser;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import darkbum.saltymod.dispenser.DispenserBehaviorRainmaker;
import darkbum.saltymod.dispenser.DispenserBehaviorSaltPinch;
import darkbum.saltymod.entity.EntityRainmaker;
import darkbum.saltymod.entity.EntityRainmakerDust;
import darkbum.saltymod.inventory.gui.GuiEvaporatorHandler;
import darkbum.saltymod.network.EvaporatorButtonMessage;
import darkbum.saltymod.network.SaltModEventHandler;
import darkbum.saltymod.network.SaltWortMessage;
import darkbum.saltymod.tileentity.TileEntityEvaporator;

public class CommonProxy {

    public static CreativeTabs tabSalt = new TabSalt("salt");

    public static SaltOreGenerator saltOreGenerator = new SaltOreGenerator();

    public static SaltCrystalGenerator saltCrystalGenerator = new SaltCrystalGenerator();

    public static SaltLakeGenerator saltLakeGenerator = new SaltLakeGenerator();

    public static BlossomTreeGenerator blossomTreeGenerator = new BlossomTreeGenerator();

    public static SaltFlowerGenerator saltFlowerGenerator = new SaltFlowerGenerator();

    public static ItemArmor.ArmorMaterial mudMaterial = EnumHelper.addArmorMaterial("mudMaterial", 4, new int[]{1, 1, 1, 1}, 15);

    @SideOnly(Side.CLIENT)
    public static IIcon milkIcon;

    public static Fluid milk;

    public static SimpleNetworkWrapper network;

    public void preInit(FMLPreInitializationEvent event) {
        SaltModEventHandler sEvent = new SaltModEventHandler();
        FMLCommonHandler.instance().bus().register(sEvent);
        MinecraftForge.EVENT_BUS.register(sEvent);
        NetworkRegistry.INSTANCE.registerGuiHandler(SaltyMod.instance, new GuiEvaporatorHandler());
        network = NetworkRegistry.INSTANCE.newSimpleChannel("SaltMod");
        network.registerMessage(EvaporatorButtonMessage.Handler.class, EvaporatorButtonMessage.class, 0, Side.SERVER);
        network.registerMessage(SaltWortMessage.Handler.class, SaltWortMessage.class, 1, Side.CLIENT);
    }

    public void init(FMLInitializationEvent event) {

        ModAchievementList.init();
        ClientProxy.setBlockRenderers();
        if (event.getSide().isClient()) {
            ClientProxy.setEntityRenderers();
        }

        GameRegistry.registerTileEntity(TileEntityEvaporator.class, "tileEntityEvaporator");

        EntityRegistry.registerModEntity(EntityRainmaker.class, "entityRainmaker", 0, SaltyMod.instance, 64, 20, true);
        EntityRegistry.registerModEntity(EntityRainmakerDust.class, "entityRainmakerDust", 1, SaltyMod.instance, 64, 20, false);

        BlockDispenser.dispenseBehaviorRegistry.putObject(ModItems.rainmaker, new DispenserBehaviorRainmaker());
        BlockDispenser.dispenseBehaviorRegistry.putObject(ModItems.salt_pinch, new DispenserBehaviorSaltPinch());

        GameRegistry.registerWorldGenerator(saltOreGenerator, 0);
        GameRegistry.registerWorldGenerator(blossomTreeGenerator, 0);
        GameRegistry.registerWorldGenerator(saltFlowerGenerator, 0);
        GameRegistry.registerWorldGenerator(saltCrystalGenerator, 10);
        GameRegistry.registerWorldGenerator(saltLakeGenerator, 15);

        EvaporateRegistry.instance().addEvaporating(FluidRegistry.WATER, ModItems.salt_pinch, 1000, 0.0F);

        ChestGenHooks.addItem("bonusChest", new WeightedRandomChestContent(new ItemStack(ModItems.salt), 2, 5, 5));
        ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(ModItems.salt), 2, 5, 5));
        ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(ModItems.saltwort), 2, 3, 3));
        ChestGenHooks.addItem("strongholdCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.salt), 2, 5, 5));
        ChestGenHooks.addItem("strongholdCrossing", new WeightedRandomChestContent(new ItemStack(ModItems.saltwort), 2, 5, 5));
        ChestGenHooks.addItem("mineshaftCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.salt), 2, 5, 10));
        ChestGenHooks.addItem("villageBlacksmith", new WeightedRandomChestContent(new ItemStack(ModItems.salt), 2, 5, 10));
        ChestGenHooks.addItem("pyramidDesertyChest", new WeightedRandomChestContent(new ItemStack(ModItems.saltwort), 2, 3, 3));
        ChestGenHooks.addItem("pyramidJungleChest", new WeightedRandomChestContent(new ItemStack(ModItems.saltwort), 2, 5, 5));

// D E B U G // T E S T I N G //
        ItemStack stick = new ItemStack(Items.stick);

        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.wet_mud_brick, 1, 1), new ItemStack(ModBlocks.wet_mud_brick), stick);
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.wet_mud_brick, 1, 2), new ItemStack(ModBlocks.wet_mud_brick, 1, 1), stick);

        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.apiary, 1, 1), new ItemStack(ModBlocks.apiary), stick);
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.apiary, 1, 2), new ItemStack(ModBlocks.apiary, 1, 1), stick);
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.apiary, 1, 3), new ItemStack(ModBlocks.apiary, 1, 2), stick);
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.apiary, 1, 4), new ItemStack(ModBlocks.apiary, 1, 3), stick);
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.apiary, 1, 5), new ItemStack(ModBlocks.apiary, 1, 4), stick);
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.apiary, 1, 6), new ItemStack(ModBlocks.apiary, 1, 5), stick);

        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.salt_crusted_oak_log, 1, 1), new ItemStack(ModBlocks.salt_crusted_oak_log), stick);
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.salt_crusted_oak_log, 1, 2), new ItemStack(ModBlocks.salt_crusted_oak_log, 1, 1), stick);
// D E B U G // T E S T I N G //
    }

    public void postInit(FMLPostInitializationEvent event) {

        if (FluidRegistry.isFluidRegistered("milk")) {
            Fluid milk = FluidRegistry.getFluid("milk");
            EvaporateRegistry.instance().addEvaporating(milk, ModItems.powdered_milk, 1000, 0.0F);
        } else {
            CommonProxy.milk = new Fluid("milk");
            FluidRegistry.registerFluid(CommonProxy.milk);
            FluidContainerRegistry.registerFluidContainer(new FluidStack(CommonProxy.milk, 1000), new ItemStack(Items.milk_bucket), FluidContainerRegistry.EMPTY_BUCKET);
            EvaporateRegistry.instance().addEvaporating(CommonProxy.milk, ModItems.powdered_milk, 1000, 0.0F);
        }
        if (FluidRegistry.isFluidRegistered("blood")) {
            Fluid blood = FluidRegistry.getFluid("blood");
            GameRegistry.registerItem(ModItems.bop_hemoglobin, "hemoglobin");
            EvaporateRegistry.instance().addEvaporating(blood, ModItems.bop_hemoglobin, 1000, 1.0F);
        }
        if (FluidRegistry.isFluidRegistered("hell_blood")) {
            Fluid blood = FluidRegistry.getFluid("hell_blood");
            GameRegistry.registerItem(ModItems.bop_hemoglobin, "hemoglobin");
            EvaporateRegistry.instance().addEvaporating(blood, ModItems.bop_hemoglobin, 1000, 1.0F);
        }
        Item bop_dart = GameRegistry.findItem("BiomesOPlenty", "dart");
        ItemStack bop_poisondart = new ItemStack(bop_dart, 1, 1);
        if (bop_dart != null && FluidRegistry.isFluidRegistered("poison")) {
            Fluid poisonFl = FluidRegistry.getFluid("poison");
            GameRegistry.registerItem(ModItems.bop_poison, "bop_poison");
            EvaporateRegistry.instance().addEvaporating(poisonFl, ModItems.bop_poison, 1000, 1.0F);
            GameRegistry.addShapelessRecipe(bop_poisondart, new ItemStack(bop_dart), ModItems.bop_poison);
        }

        if (Loader.isModLoaded("harvestcraft")) {
            Item honeycombItem = GameRegistry.findItem("harvestcraft", "honeycombItem");
            Item royaljellyItem = GameRegistry.findItem("harvestcraft", "royaljellyItem");
            if (honeycombItem != null) {
                OreDictionary.registerOre("itemSweetener", honeycombItem);
                OreDictionary.registerOre("itemHoney", honeycombItem);
            }
            if (royaljellyItem != null) {
                OreDictionary.registerOre("itemRoyaljelly", royaljellyItem);
            }
        }

        if (Loader.isModLoaded("Forestry")) {
            Item beeCombs = GameRegistry.findItem("Forestry", "beeCombs");
            if (beeCombs != null) {
                OreDictionary.registerOre("itemSweetener", beeCombs);
                OreDictionary.registerOre("itemHoney", beeCombs);
            }
        }

        if (Loader.isModLoaded("Growthcraft")) {
            Item honeyCombFilled = GameRegistry.findItem("Growthcraft|Bees", "grc.honeyCombFilled");
            if (honeyCombFilled != null) {
                OreDictionary.registerOre("itemSweetener", honeyCombFilled);
                OreDictionary.registerOre("itemHoney", honeyCombFilled);
            }
        }

        if (Loader.isModLoaded("netherlicious")) {
            Item StriderFlankCooked = GameRegistry.findItem("netherlicious", "StriderFlankCooked");
            Item StriderFlankRaw = GameRegistry.findItem("netherlicious", "StriderFlankRaw");
            if ((StriderFlankRaw != null) &&
                (StriderFlankCooked != null)) {

                OreDictionary.registerOre("itemRedmeat", StriderFlankCooked);

                OreDictionary.registerOre("itemFood", StriderFlankRaw);
                OreDictionary.registerOre("itemFood", StriderFlankCooked);

                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_cooked_strider), new ItemStack(ModItems.salt_pinch), new ItemStack(StriderFlankCooked));
            }
        }

        if (Loader.isModLoaded("etfuturum") && !Loader.isModLoaded("netherlicious")) {
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_cooked_strider), new ItemStack(ModItems.salt_pinch), new ItemStack(ModItems.cooked_strider));

            GameRegistry.addSmelting(new ItemStack(ModItems.strider), new ItemStack(ModItems.cooked_strider), 0.35F);
        }

        if (Loader.isModLoaded("etfuturum")) {
            Item suspicious_stew = GameRegistry.findItem("etfuturum", "suspicious_stew");
            Item mutton_raw = GameRegistry.findItem("etfuturum", "mutton_raw");
            Item mutton_cooked = GameRegistry.findItem("etfuturum", "mutton_cooked");
            Item rabbit_raw = GameRegistry.findItem("etfuturum", "rabbit_raw");
            Item rabbit_cooked = GameRegistry.findItem("etfuturum", "rabbit_cooked");
            Item rabbit_stew = GameRegistry.findItem("etfuturum", "rabbit_stew");
            Item beetroot = GameRegistry.findItem("etfuturum", "beetroot");
            Item beetroot_seeds = GameRegistry.findItem("etfuturum", "beetroot_seeds");
            Item beetroot_soup = GameRegistry.findItem("etfuturum", "beetroot_soup");
            Item chorus_fruit = GameRegistry.findItem("etfuturum", "chorus_fruit");
            Item sweet_berries = GameRegistry.findItem("etfuturum", "sweet_berries");
            Item dye = GameRegistry.findItem("etfuturum", "dye");
            if ((suspicious_stew != null) &&
                (mutton_raw != null) &&
                (mutton_cooked != null) &&
                (rabbit_raw != null) &&
                (rabbit_cooked != null) &&
                (rabbit_stew != null) &&
                (beetroot != null) &&
                (beetroot_seeds != null) &&
                (beetroot_soup != null) &&
                (chorus_fruit != null) &&
                (sweet_berries != null) &&
                (dye != null)) {

                OreDictionary.registerOre("blockMushroom", Blocks.red_mushroom);
                OreDictionary.registerOre("blockMushroom", Blocks.brown_mushroom);

                OreDictionary.registerOre("itemRedmeat", mutton_cooked);
                OreDictionary.registerOre("itemHoney", ModItems.honeycomb);

                OreDictionary.registerOre("itemFood", new ItemStack(suspicious_stew, OreDictionary.WILDCARD_VALUE));
                OreDictionary.registerOre("itemFood", mutton_raw);
                OreDictionary.registerOre("itemFood", mutton_cooked);
                OreDictionary.registerOre("itemFood", rabbit_raw);
                OreDictionary.registerOre("itemFood", rabbit_cooked);
                OreDictionary.registerOre("itemFood", rabbit_stew);
                OreDictionary.registerOre("itemFood", beetroot);
                OreDictionary.registerOre("itemFood", beetroot_soup);
                OreDictionary.registerOre("itemFood", chorus_fruit);
                OreDictionary.registerOre("itemFood", sweet_berries);

                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_cooked_mutton), new ItemStack(ModItems.salt_pinch), new ItemStack(mutton_cooked));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_cooked_rabbit), new ItemStack(ModItems.salt_pinch), new ItemStack(rabbit_cooked));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_rabbit_stew), new ItemStack(ModItems.salt_pinch), new ItemStack(rabbit_stew));
                GameRegistry.addShapelessRecipe(new ItemStack(beetroot, 9), new ItemStack(ModBlocks.storage_crate, 1, 4));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_beetroot), new ItemStack(ModItems.salt_pinch), new ItemStack(beetroot));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_beetroot_soup), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.bowl), new ItemStack(beetroot), new ItemStack(beetroot), new ItemStack(beetroot), new ItemStack(beetroot), new ItemStack(beetroot), new ItemStack(beetroot));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.beetroot_salad), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(beetroot));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_beetroot_salad), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(beetroot));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.dressed_herring), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(beetroot), new ItemStack(Items.egg), new ItemStack(Items.fish), new ItemStack(ModItems.onion));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_dressed_herring), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(beetroot), new ItemStack(Items.egg), new ItemStack(Items.fish), new ItemStack(ModItems.onion));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pickled_beetroot), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.potionitem), new ItemStack(beetroot), new ItemStack(beetroot));
                GameRegistry.addShapelessRecipe(new ItemStack(beetroot_seeds, 9), new ItemStack(ModBlocks.storage_sack, 1, 4));
                GameRegistry.addShapelessRecipe(new ItemStack(beetroot_soup), new ItemStack(Items.bowl), new ItemStack(beetroot), new ItemStack(beetroot), new ItemStack(beetroot), new ItemStack(beetroot), new ItemStack(beetroot), new ItemStack(beetroot));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt_beetroot_soup), new ItemStack(ModItems.salt_pinch), new ItemStack(beetroot_soup));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.chocolate_berries), new ItemStack(Items.dye, 1, 3), new ItemStack(sweet_berries));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sweetberry_pie), new ItemStack(Items.sugar), new ItemStack(sweet_berries), new ItemStack(sweet_berries), new ItemStack(Items.egg));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugar_berries), new ItemStack(ModItems.sugar_pinch), new ItemStack(sweet_berries));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fruit_salad), new ItemStack(Items.bowl), new ItemStack(Items.apple), new ItemStack(sweet_berries), new ItemStack(Items.melon));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugar_fruit_salad), new ItemStack(ModItems.sugar_pinch), new ItemStack(Items.bowl), new ItemStack(Items.apple), new ItemStack(sweet_berries), new ItemStack(Items.melon));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.golden_fruit_salad), new ItemStack(Items.bowl), new ItemStack(Items.golden_apple), new ItemStack(ModItems.golden_berries), new ItemStack(Items.speckled_melon));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugar_golden_fruit_salad), new ItemStack(ModItems.sugar_pinch), new ItemStack(Items.bowl), new ItemStack(Items.golden_apple), new ItemStack(ModItems.golden_berries), new ItemStack(Items.speckled_melon));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.berry_preserves), new ItemStack(ModItems.sugar_pinch), new ItemStack(Items.potionitem), new ItemStack(sweet_berries), new ItemStack(sweet_berries));
                GameRegistry.addShapelessRecipe(new ItemStack(dye, 1,0), new ItemStack(ModBlocks.salt_flower, 1, 0));

                GameRegistry.addRecipe(new ItemStack(ModBlocks.storage_crate, 1, 4), "xxx", "xxx", "xxx", 'x', new ItemStack(beetroot));
                GameRegistry.addRecipe(new ItemStack(ModBlocks.storage_sack, 1, 4), "xxx", "xxx", "xxx", 'x', new ItemStack(beetroot_seeds));
                GameRegistry.addRecipe(new ItemStack(ModItems.golden_berries), "xxx", "xyx", "xxx", 'x', Items.gold_nugget, 'y', new ItemStack(sweet_berries));
                GameRegistry.addRecipe(new ItemStack(ModItems.golden_berries, 1, 1), "xxx", "xyx", "xxx", 'x', Blocks.gold_block, 'y', new ItemStack(sweet_berries));

                GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.salt_rabbit_stew), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.bowl), new ItemStack(rabbit_cooked), new ItemStack(Items.carrot), new ItemStack(Items.baked_potato), "blockMushroom"));
                GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(rabbit_stew), new ItemStack(Items.bowl), new ItemStack(rabbit_cooked), new ItemStack(Items.carrot), new ItemStack(Items.baked_potato), "blockMushroom"));
                GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.honey_berries), "itemHoney", new ItemStack(sweet_berries)));
            } else {
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fruit_salad), new ItemStack(Items.bowl), new ItemStack(Items.apple), new ItemStack(Items.carrot), new ItemStack(Items.melon));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugar_fruit_salad), new ItemStack(ModItems.sugar_pinch), new ItemStack(Items.bowl), new ItemStack(Items.apple), new ItemStack(Items.carrot), new ItemStack(Items.melon));
                GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 15), new ItemStack(ModBlocks.salt_flower, 0));
            }
        }

        if (Loader.isModLoaded("TwilightForest")) {
            Item venisonCooked = GameRegistry.findItem("TwilightForest", "item.venisonCooked");
            Item meefSteak = GameRegistry.findItem("TwilightForest", "item.meefSteak");
            Item meefStroganoff = GameRegistry.findItem("TwilightForest", "item.meefStroganoff");
            Item hydraChop = GameRegistry.findItem("TwilightForest", "item.hydraChop");
            Item mushgloom = GameRegistry.findItem("TwilightForest", "tile.TFPlant");
            if ((venisonCooked != null) &&
                (meefSteak != null) &&
                (meefStroganoff != null) &&
                (hydraChop != null) &&
                (mushgloom != null)) {

                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tf_salt_cooked_venison), new ItemStack(ModItems.salt_pinch), new ItemStack(venisonCooked));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tf_salt_meef_steak), new ItemStack(ModItems.salt_pinch), new ItemStack(meefSteak));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tf_salt_meef_stroganoff), new ItemStack(ModItems.salt_pinch), new ItemStack(meefStroganoff));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tf_salt_hydra_chop), new ItemStack(ModItems.salt_pinch), new ItemStack(hydraChop));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tf_pickled_mushgloom), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.potionitem), new ItemStack(mushgloom, 1, 9), new ItemStack(mushgloom, 1, 9));

            }
        }

        if (Loader.isModLoaded("BiomesOPlenty")) {
            Item food = GameRegistry.findItem("BiomesOPlenty", "food");
            if (food != null) {
                OreDictionary.registerOre("itemSweetener", new ItemStack(food, 1, 9));
                OreDictionary.registerOre("itemHoney", new ItemStack(food, 1, 9));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bop_salt_shroom_powder), new ItemStack(ModItems.salt_pinch), new ItemStack(food, 1, 1));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bop_sugar_fruit_salad), new ItemStack(ModItems.sugar_pinch), new ItemStack(food, 1, 4));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bop_salt_veggie_salad), new ItemStack(ModItems.salt_pinch), new ItemStack(food, 1, 5));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bop_salt_shroom_salad), new ItemStack(ModItems.salt_pinch), new ItemStack(food, 1, 6));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bop_salt_rice_bowl), new ItemStack(ModItems.salt_pinch), new ItemStack(food, 1, 13));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bop_pickled_turnip), new ItemStack(ModItems.salt_pinch), new ItemStack(Items.potionitem), new ItemStack(food, 1, 11), new ItemStack(food, 1, 11));
            }
        }
    }
}
