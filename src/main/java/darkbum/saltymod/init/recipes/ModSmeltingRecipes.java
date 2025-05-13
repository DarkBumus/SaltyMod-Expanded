package darkbum.saltymod.init.recipes;

import net.minecraft.item.ItemStack;

import static cpw.mods.fml.common.Loader.isModLoaded;
import static darkbum.saltymod.util.ConditionalRegistrar.*;
import static darkbum.saltymod.common.config.ModConfigurationBlocks.*;
import static darkbum.saltymod.common.config.ModConfigurationItems.*;
import static darkbum.saltymod.common.config.ModConfigurationVanillaChanges.*;
import static darkbum.saltymod.init.ModBlocks.*;
import static darkbum.saltymod.init.ModItems.*;
import static net.minecraft.init.Items.*;

/**
 * Recipe class for Furnace Recipes.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class ModSmeltingRecipes {

    /**
     * Initializes all furnace recipes.
     */
    public static void init() {

        addSmelting(new ItemStack(dough),
            new ItemStack(bread),
            0.35f,
            enableRecipeChanges, enableDough);

        addSmelting(new ItemStack(leather),
            new ItemStack(slime_ball),
            0.5F);
        addSmelting(new ItemStack(rotten_flesh),
            new ItemStack(leather),
            0.5F);

        addSmelting(new ItemStack(salt_ore),
            new ItemStack(salt, 1),
            0.7F);
        addSmelting(new ItemStack(deepslate_salt_ore),
            new ItemStack(salt, 1),
            0.7F,
            deepslate_salt_ore != null);
        addSmelting(new ItemStack(salt_lake),
            new ItemStack(salt, 1),
            0.7F);

        addSmelting(new ItemStack(salt_block, 1, 0),
            new ItemStack(salt_block, 1, 6),
            0.1F,
            enableSaltBlocks);
        addSmelting(new ItemStack(salt_block, 1, 5),
            new ItemStack(salt_block, 1, 7),
            0.1F,
            enableSaltBlocks);

        addSmelting(new ItemStack(wet_mud_brick),
            new ItemStack(dry_mud_brick),
            0.1F,
            enableMudBricks, !complexMudBricks);

        addSmelting(new ItemStack(saltwort),
            new ItemStack(baking_soda, 1),
            0.5F);
        addSmelting(new ItemStack(haunch),
            new ItemStack(haunch, 1, 1),
            0.35F);

        addSmelting(new ItemStack(strider, 1, 0),
            new ItemStack(strider, 1, 1),
            0.35F,
            isModLoaded("etfuturum"), !isModLoaded("netherlicious"));
        addSmelting(new ItemStack(fish, 1, 2),
            new ItemStack(cooked_tropical_fish),
            0.35F,
            enableTropicalFish);
        addSmelting(new ItemStack(tailor),
            new ItemStack(tailor, 1, 1),
            0.35F);
        addSmelting(new ItemStack(calamari),
            new ItemStack(calamari, 1, 1),
            0.35F);
    }
}
