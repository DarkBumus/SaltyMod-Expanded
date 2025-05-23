package darkbum.saltymod.common.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import darkbum.saltymod.SaltyMod;

/**
 * Handles the configuration management for SaltyMod Expanded, organizing configuration files into separate categories.
 * The configuration files are divided into blocks, effects, entities, items, mod compatibility, vanilla changes,
 * world generation, and other miscellaneous settings.
 * <p>
 * This class creates and manages these configuration files and provides methods to initialize and load them during
 * different stages of the mod lifecycle (preInit, init, postInit).
 * <p>
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ModConfigurationBase extends Configuration {

    /** Configuration definitions. */
    public static Configuration blocksConfig;
    public static Configuration effectsConfig;
    public static Configuration entitiesConfig;
    public static Configuration itemsConfig;
    public static Configuration modCompatConfig;
    public static Configuration vanillaChangesConfig;
    public static Configuration worldGenConfig;
    public static Configuration otherConfig;

    /**
     * Constructs a new ModConfigurationBase instance and initializes the configuration files.
     *
     * @param mainFile The main configuration file, used to derive the config directory.
     */
    public ModConfigurationBase(File mainFile) {
        File configDir = mainFile.getParentFile();
        File subDir = new File(configDir, "saltymod");

        // Create the config directory if it doesn't exist
        if (!subDir.exists()) {
            if (subDir.mkdirs()) {
                SaltyMod.logger
                    .warn("[SaltyMod Expanded] Failed to create config directory:{}", subDir.getAbsolutePath());
            }
        }

        // Initialize configuration files
        blocksConfig = new Configuration(new File(subDir, "blocks.cfg"));
        effectsConfig = new Configuration(new File(subDir, "effects.cfg"));
        entitiesConfig = new Configuration(new File(subDir, "entities.cfg"));
        itemsConfig = new Configuration(new File(subDir, "items.cfg"));
        modCompatConfig = new Configuration(new File(subDir, "mod_compatibility.cfg"));
        vanillaChangesConfig = new Configuration(new File(subDir, "vanilla_changes.cfg"));
        worldGenConfig = new Configuration(new File(subDir, "world_generation.cfg"));
        otherConfig = new Configuration(new File(subDir, "other.cfg"));
    }


    /**
     * Handles the pre-initialization stage of the mod, where the primary configuration files
     * are loaded and their respective initialization methods are called.
     */
    public void preInit() {
        // Array of configuration files to be processed in this stage
        Configuration[] configs = {blocksConfig, effectsConfig, entitiesConfig, itemsConfig, modCompatConfig, vanillaChangesConfig, worldGenConfig};

        // Load all configurations
        for (Configuration config : configs) {
            config.load();
        }

        // Initialize configuration modules
        ModConfigurationBlocks.init(blocksConfig);
        ModConfigurationEffects.init(effectsConfig);
        ModConfigurationEntities.init(entitiesConfig);
        ModConfigurationItems.init(itemsConfig);
        ModConfigurationModCompatibility.init(modCompatConfig);
        ModConfigurationVanillaChanges.init(vanillaChangesConfig);
        ModConfigurationWorldGeneration.init(worldGenConfig);

        // Save any changes made during initialization
        for (Configuration config : configs) {
            if (config.hasChanged()) config.save();
        }
    }

    /**
     * Handles the initialization stage. This method is currently unused but reserved
     * for future expansion or handling of runtime configuration changes.
     */
    public void init() {}

    /**
     * Handles the post-initialization stage, specifically for the 'other' configuration file.
     * This stage is executed after the primary configurations have been processed.
     */
    public void postInit() {
        otherConfig.load();

        ModConfigurationOther.init(otherConfig);

        if (otherConfig.hasChanged()) otherConfig.save();
    }
}
