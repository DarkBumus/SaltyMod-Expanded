package darkbum.saltymod.configuration;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.configuration.configs.*;

public class ModConfigurationBase extends Configuration {

    public static Configuration blocksConfig;
    public static Configuration effectsConfig;
    public static Configuration entitiesConfig;
    public static Configuration itemsConfig;
    public static Configuration modCompatConfig;
    public static Configuration vanillaChangesConfig;
    public static Configuration worldGenConfig;
    public static Configuration otherConfig;

    public ModConfigurationBase(File mainFile) {
        File configDir = mainFile.getParentFile();
        File subDir = new File(configDir, "saltymod");
        if (!subDir.exists()) {
            if (subDir.mkdirs()) {
                SaltyMod.logger
                    .warn("[SaltyMod Expanded] Failed to create config directory:{}", subDir.getAbsolutePath());
            }
        }

        blocksConfig = new Configuration(new File(subDir, "blocks.cfg"));
        effectsConfig = new Configuration(new File(subDir, "effects.cfg"));
        entitiesConfig = new Configuration(new File(subDir, "entities.cfg"));
        itemsConfig = new Configuration(new File(subDir, "items.cfg"));
        modCompatConfig = new Configuration(new File(subDir, "mod_compatibility.cfg"));
        vanillaChangesConfig = new Configuration(new File(subDir, "vanilla_changes.cfg"));
        worldGenConfig = new Configuration(new File(subDir, "world_generation.cfg"));
        otherConfig = new Configuration(new File(subDir, "other.cfg"));
    }

    public void preInit() {
        Configuration[] configs = { blocksConfig, effectsConfig, entitiesConfig, itemsConfig, modCompatConfig, vanillaChangesConfig,
            worldGenConfig};

        for (Configuration config : configs) {
            config.load();
        }

        ModConfigurationBlocks.init(blocksConfig);
        ModConfigurationEffects.init(effectsConfig);
        ModConfigurationEntities.init(entitiesConfig);
        ModConfigurationItems.init(itemsConfig);
        ModConfigurationModCompatibility.init(modCompatConfig);
        ModConfigurationVanillaChanges.init(vanillaChangesConfig);
        ModConfigurationWorldGeneration.init(worldGenConfig);

        for (Configuration config : configs) {
            if (config.hasChanged()) config.save();
        }
    }

    public void init() {}

    public void postInit() {
        otherConfig.load();

        ModConfigurationOther.init(otherConfig);

        if (otherConfig.hasChanged()) otherConfig.save();
    }
}
