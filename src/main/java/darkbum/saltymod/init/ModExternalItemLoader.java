package darkbum.saltymod.init;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ModExternalItemLoader {

    public static final Map<String, Item> harvestcraftItems = new HashMap<>();

    public static final Map<String, Item> forestryItems = new HashMap<>();

    public static final Map<String, Item> growthcraftItems = new HashMap<>();

    public static final Map<String, Item> netherliciousItems = new HashMap<>();

    public static final Map<String, Item> etFuturumItems = new HashMap<>();
    public static final Map<String, Block> etFuturumBlocks = new HashMap<>();

    public static final Map<String, Block> campfireBackportBlocks = new HashMap<>();

    public static final Map<String, Item> twilightForestItems = new HashMap<>();

    public static final Map<String, Item> biomesOPlentyItems = new HashMap<>();

    public static void loadAll() {
        if (Loader.isModLoaded("harvestcraft")) {
            loadHarvestcraft();
        }
        if (Loader.isModLoaded("Forestry")) {
            loadForestry();
        }
        if (Loader.isModLoaded("Growthcraft")) {
            loadGrowthcraft();
        }
        if (Loader.isModLoaded("netherlicious")) {
            loadNetherlicious();
        }
        if (Loader.isModLoaded("etfuturum")) {
            loadEtFuturum();
        }
        if (Loader.isModLoaded("campfirebackport")) {
            loadCampfireBackport();
        }
        if (Loader.isModLoaded("TwilightForest")) {
            loadTwilightForest();
        }
        if (Loader.isModLoaded("BiomesOPlenty")) {
            loadBiomesOPlenty();
        }
    }

    public static void loadHarvestcraft() {
        if (!Loader.isModLoaded("harvestcraft")) return;
        harvestcraftItems.put("honeycombItem", GameRegistry.findItem("harvestcraft", "honeycombItem"));
        harvestcraftItems.put("royaljellyItem", GameRegistry.findItem("harvestcraft", "royaljellyItem"));
    }

    public static void loadForestry() {
        if (!Loader.isModLoaded("Forestry")) return;
        forestryItems.put("beeCombs", GameRegistry.findItem("Forestry", "beeCombs"));
    }

    public static void loadGrowthcraft() {
        if (!Loader.isModLoaded("Growthcraft")) return;
        growthcraftItems.put("honeyCombFilled", GameRegistry.findItem("Growthcraft|Bees", "grc.honeyCombFilled"));
    }

    public static void loadNetherlicious() {
        if (!Loader.isModLoaded("netherlicious")) return;
        netherliciousItems.put("StriderFlankRaw", GameRegistry.findItem("netherlicious", "StriderFlankRaw"));
        netherliciousItems.put("StriderFlankCooked", GameRegistry.findItem("netherlicious", "StriderFlankCooked"));
    }

    public static void loadEtFuturum() {
        if (!Loader.isModLoaded("etfuturum")) return;
        etFuturumItems.put("suspicious_stew", GameRegistry.findItem("etfuturum", "suspicious_stew"));
        etFuturumItems.put("mutton_raw", GameRegistry.findItem("etfuturum", "mutton_raw"));
        etFuturumItems.put("mutton_cooked", GameRegistry.findItem("etfuturum", "mutton_cooked"));
        etFuturumItems.put("rabbit_raw", GameRegistry.findItem("etfuturum", "rabbit_raw"));
        etFuturumItems.put("rabbit_cooked", GameRegistry.findItem("etfuturum", "rabbit_cooked"));
        etFuturumItems.put("rabbit_stew", GameRegistry.findItem("etfuturum", "rabbit_stew"));
        etFuturumItems.put("beetroot", GameRegistry.findItem("etfuturum", "beetroot"));
        etFuturumItems.put("beetroot_seeds", GameRegistry.findItem("etfuturum", "beetroot_seeds"));
        etFuturumItems.put("beetroot_soup", GameRegistry.findItem("etfuturum", "beetroot_soup"));
        etFuturumItems.put("chorus_fruit", GameRegistry.findItem("etfuturum", "chorus_fruit"));
        etFuturumItems.put("sweet_berries", GameRegistry.findItem("etfuturum", "sweet_berries"));
        etFuturumItems.put("dye", GameRegistry.findItem("etfuturum", "dye"));
        etFuturumBlocks.put("nether_fungus", GameRegistry.findBlock("etfuturum", "nether_fungus"));
        etFuturumBlocks.put("honeycomb_block", GameRegistry.findBlock("etfuturum", "honeycomb_block"));
        etFuturumBlocks.put("beehive", GameRegistry.findBlock("etfuturum", "beehive"));
    }

    public static void loadCampfireBackport() {
        if (!Loader.isModLoaded("campfirebackport")) return;
        campfireBackportBlocks.put("campfire", GameRegistry.findBlock("campfirebackport", "campfire"));
        campfireBackportBlocks.put("soul_campfire", GameRegistry.findBlock("campfirebackport", "soul_campfire"));
    }

    public static void loadTwilightForest() {
        if (!Loader.isModLoaded("TwilightForest")) return;
        twilightForestItems.put("venisonCooked", GameRegistry.findItem("TwilightForest", "item.venisonCooked"));
        twilightForestItems.put("meefSteak", GameRegistry.findItem("TwilightForest", "item.meefSteak"));
        twilightForestItems.put("meefStroganoff", GameRegistry.findItem("TwilightForest", "item.meefStroganoff"));
        twilightForestItems.put("hydraChop", GameRegistry.findItem("TwilightForest", "item.hydraChop"));
        twilightForestItems.put("mushgloom", GameRegistry.findItem("TwilightForest", "tile.TFPlant"));
    }

    public static void loadBiomesOPlenty() {
        if (!Loader.isModLoaded("BiomesOPlenty")) return;
        biomesOPlentyItems.put("food", GameRegistry.findItem("BiomesOPlenty", "food"));
    }
}
