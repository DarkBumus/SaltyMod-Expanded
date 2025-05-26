package darkbum.saltymod.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

import static cpw.mods.fml.common.Loader.isModLoaded;
import static cpw.mods.fml.common.registry.GameRegistry.*;

/**
 * External Loader class.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ModExternalLoader {

    public static boolean hc = isModLoaded("harvestcraft");
    public static boolean fo = isModLoaded("Forestry");
    public static boolean gc = isModLoaded("Growthcraft");
    public static boolean nl = isModLoaded("netherlicious");
    public static boolean efr = isModLoaded("etfuturum");
    public static boolean cfb = isModLoaded("campfirebackport");
    public static boolean tf = isModLoaded("TwilightForest");
    public static boolean bop = isModLoaded("BiomesOPlenty");
    public static boolean wm = isModLoaded("wildmobsmod");

    public static final Map<String, Item> harvestcraftItems = new HashMap<>();
    public static final Map<String, Item> forestryItems = new HashMap<>();
    public static final Map<String, Item> growthcraftItems = new HashMap<>();
    public static final Map<String, Item> netherliciousItems = new HashMap<>();
    public static final Map<String, Block> etFuturumBlocks = new HashMap<>();
    public static final Map<String, Item> etFuturumItems = new HashMap<>();
    public static final Map<String, Block> campfireBackportBlocks = new HashMap<>();
    public static final Map<String, Block> twilightForestBlocks = new HashMap<>();
    public static final Map<String, Item> twilightForestItems = new HashMap<>();
    public static final Map<String, Item> biomesOPlentyItems = new HashMap<>();
    public static final Map<String, Item> wildMobsItems = new HashMap<>();

    /**
     * Initializes all external loaders.
     */
    public static void init() {
        loadAll();
    }

    /**
     * Loads external items and blocks from all supported mods.
     * Checks if each mod is loaded before attempting to load its items and blocks.
     */
    public static void loadAll() {
        if (hc) loadHarvestcraft();
        if (fo) loadForestry();
        if (gc) loadGrowthcraft();
        if (nl) loadNetherlicious();
        if (efr) loadEtFuturum();
        if (cfb) loadCampfireBackport();
        if (tf) loadTwilightForest();
        if (bop) loadBiomesOPlenty();
        if (wm) loadWildMobs();
    }

    /**
     * Loads item references from Harvestcraft.
     */
    public static void loadHarvestcraft() {
        if (!hc) return;
        harvestcraftItems.put("honeycombItem", findItem("harvestcraft", "honeycombItem"));
        harvestcraftItems.put("royaljellyItem", findItem("harvestcraft", "royaljellyItem"));
    }

    /**
     * Loads item references from Forestry.
     */
    public static void loadForestry() {
        if (!fo) return;
        forestryItems.put("beeCombs", findItem("Forestry", "beeCombs"));
    }

    /**
     * Loads item references from Growthcraft.
     */
    public static void loadGrowthcraft() {
        if (!gc) return;
        growthcraftItems.put("honeyCombFilled", findItem("Growthcraft|Bees", "grc.honeyCombFilled"));
    }

    /**
     * Loads item references from Netherlicious.
     */
    public static void loadNetherlicious() {
        if (!nl) return;
        netherliciousItems.put("StriderFlankRaw", findItem("netherlicious", "StriderFlankRaw"));
        netherliciousItems.put("StriderFlankCooked", findItem("netherlicious", "StriderFlankCooked"));
    }

    /**
     * Loads item and block references from Et Futurum Requiem.
     */
    public static void loadEtFuturum() {
        if (!efr) return;
        etFuturumBlocks.put("blue_ice", findBlock("etfuturum", "blue_ice"));
        etFuturumBlocks.put("deepslate", findBlock("etfuturum", "deepslate"));
        etFuturumBlocks.put("magma", findBlock("etfuturum", "magma"));
        etFuturumBlocks.put("nether_fungus", findBlock("etfuturum", "nether_fungus"));
        etFuturumBlocks.put("honeycomb_block", findBlock("etfuturum", "honeycomb_block"));
        etFuturumBlocks.put("beehive", findBlock("etfuturum", "beehive"));

        etFuturumItems.put("suspicious_stew", findItem("etfuturum", "suspicious_stew"));
        etFuturumItems.put("mutton_raw", findItem("etfuturum", "mutton_raw"));
        etFuturumItems.put("mutton_cooked", findItem("etfuturum", "mutton_cooked"));
        etFuturumItems.put("rabbit_raw", findItem("etfuturum", "rabbit_raw"));
        etFuturumItems.put("rabbit_cooked", findItem("etfuturum", "rabbit_cooked"));
        etFuturumItems.put("rabbit_stew", findItem("etfuturum", "rabbit_stew"));
        etFuturumItems.put("beetroot", findItem("etfuturum", "beetroot"));
        etFuturumItems.put("beetroot_seeds", findItem("etfuturum", "beetroot_seeds"));
        etFuturumItems.put("beetroot_soup", findItem("etfuturum", "beetroot_soup"));
        etFuturumItems.put("chorus_fruit", findItem("etfuturum", "chorus_fruit"));
        etFuturumItems.put("sweet_berries", findItem("etfuturum", "sweet_berries"));
        etFuturumItems.put("dye", findItem("etfuturum", "dye"));
        etFuturumItems.put("honey_bottle", findItem("etfuturum", "honey_bottle"));
    }

    /**
     * Loads block references from Campfire Backport.
     */
    public static void loadCampfireBackport() {
        if (!cfb) return;
        campfireBackportBlocks.put("campfire", findBlock("campfirebackport", "campfire"));
        campfireBackportBlocks.put("soul_campfire", findBlock("campfirebackport", "soul_campfire"));
    }

    /**
     * Loads item references from Twilight Forest.
     */
    public static void loadTwilightForest() {
        if (!tf) return;
        twilightForestBlocks.put("mushgloom", findBlock("TwilightForest", "tile.TFPlant"));

        twilightForestItems.put("venisonCooked", findItem("TwilightForest", "item.venisonCooked"));
        twilightForestItems.put("meefSteak", findItem("TwilightForest", "item.meefSteak"));
        twilightForestItems.put("meefStroganoff", findItem("TwilightForest", "item.meefStroganoff"));
        twilightForestItems.put("hydraChop", findItem("TwilightForest", "item.hydraChop"));
    }

    /**
     * Loads item references from Biomes o'Plenty
     */
    public static void loadBiomesOPlenty() {
        if (!bop) return;
        biomesOPlentyItems.put("food", findItem("BiomesOPlenty", "food"));
        biomesOPlentyItems.put("dart", findItem("BiomesOPlenty", "dart"));
    }

    public static void loadWildMobs() {
        if (!wm) return;
        wildMobsItems.put("cooked_bison_meat", findItem("wildmobsmod", "cooked_bison_meat"));
        wildMobsItems.put("cooked_calamari", findItem("wildmobsmod", "cooked_calamari"));
        wildMobsItems.put("cooked_chevon", findItem("wildmobsmod", "cooked_chevon"));
        wildMobsItems.put("cooked_goose", findItem("wildmobsmod", "cooked_goose"));
        wildMobsItems.put("cooked_mouse", findItem("wildmobsmod", "cooked_mouse"));
        wildMobsItems.put("cooked_venison", findItem("wildmobsmod", "cooked_venison"));
    }
}
