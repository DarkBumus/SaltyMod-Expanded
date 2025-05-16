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
        if (isModLoaded("harvestcraft")) loadHarvestcraft();
        if (isModLoaded("Forestry")) loadForestry();
        if (isModLoaded("Growthcraft")) loadGrowthcraft();
        if (isModLoaded("netherlicious")) loadNetherlicious();
        if (isModLoaded("etfuturum")) loadEtFuturum();
        if (isModLoaded("campfirebackport")) loadCampfireBackport();
        if (isModLoaded("TwilightForest")) loadTwilightForest();
        if (isModLoaded("BiomesOPlenty")) loadBiomesOPlenty();
    }

    /**
     * Loads item references from Harvestcraft.
     */
    public static void loadHarvestcraft() {
        if (!isModLoaded("harvestcraft")) return;
        harvestcraftItems.put("honeycombItem", findItem("harvestcraft", "honeycombItem"));
        harvestcraftItems.put("royaljellyItem", findItem("harvestcraft", "royaljellyItem"));
    }

    /**
     * Loads item references from Forestry.
     */
    public static void loadForestry() {
        if (!isModLoaded("Forestry")) return;
        forestryItems.put("beeCombs", findItem("Forestry", "beeCombs"));
    }

    /**
     * Loads item references from Growthcraft.
     */
    public static void loadGrowthcraft() {
        if (!isModLoaded("Growthcraft")) return;
        growthcraftItems.put("honeyCombFilled", findItem("Growthcraft|Bees", "grc.honeyCombFilled"));
    }

    /**
     * Loads item references from Netherlicious.
     */
    public static void loadNetherlicious() {
        if (!isModLoaded("netherlicious")) return;
        netherliciousItems.put("StriderFlankRaw", findItem("netherlicious", "StriderFlankRaw"));
        netherliciousItems.put("StriderFlankCooked", findItem("netherlicious", "StriderFlankCooked"));
    }

    /**
     * Loads item and block references from Et Futurum Requiem.
     */
    public static void loadEtFuturum() {
        if (!isModLoaded("etfuturum")) return;
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
        etFuturumBlocks.put("blue_ice", findBlock("etfuturum", "blue_ice"));
        etFuturumBlocks.put("magma", findBlock("etfuturum", "magma"));
        etFuturumBlocks.put("nether_fungus", findBlock("etfuturum", "nether_fungus"));
        etFuturumBlocks.put("honeycomb_block", findBlock("etfuturum", "honeycomb_block"));
        etFuturumBlocks.put("beehive", findBlock("etfuturum", "beehive"));
    }

    /**
     * Loads block references from Campfire Backport.
     */
    public static void loadCampfireBackport() {
        if (!isModLoaded("campfirebackport")) return;
        campfireBackportBlocks.put("campfire", findBlock("campfirebackport", "campfire"));
        campfireBackportBlocks.put("soul_campfire", findBlock("campfirebackport", "soul_campfire"));
    }

    /**
     * Loads item references from Twilight Forest.
     */
    public static void loadTwilightForest() {
        if (!isModLoaded("TwilightForest")) return;
        twilightForestItems.put("venisonCooked", findItem("TwilightForest", "item.venisonCooked"));
        twilightForestItems.put("meefSteak", findItem("TwilightForest", "item.meefSteak"));
        twilightForestItems.put("meefStroganoff", findItem("TwilightForest", "item.meefStroganoff"));
        twilightForestItems.put("hydraChop", findItem("TwilightForest", "item.hydraChop"));
        twilightForestItems.put("mushgloom", findItem("TwilightForest", "tile.TFPlant"));
    }

    /**
     * Loads item references from Biomes o'Plenty
     */
    public static void loadBiomesOPlenty() {
        if (!isModLoaded("BiomesOPlenty")) return;
        biomesOPlentyItems.put("food", findItem("BiomesOPlenty", "food"));
    }
}
