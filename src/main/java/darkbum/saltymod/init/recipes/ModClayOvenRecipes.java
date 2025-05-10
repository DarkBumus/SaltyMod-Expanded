package darkbum.saltymod.init.recipes;

import darkbum.saltymod.util.ConditionalRegistrar;
import darkbum.saltymod.common.config.ModConfigurationBlocks;
import darkbum.saltymod.common.config.ModConfigurationItems;
import darkbum.saltymod.common.config.ModConfigurationModCompatibility;
import darkbum.saltymod.common.config.ModConfigurationVanillaChanges;
import darkbum.saltymod.init.ModExternalItemLoader;
import darkbum.saltymod.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static darkbum.saltymod.util.OvenbakingRecipe.*;

public class ModClayOvenRecipes {

    public static void init() {

        Item chorus_fruit = ModExternalItemLoader.etFuturumItems.get("chorus_fruit");
        Item sweet_berries = ModExternalItemLoader.etFuturumItems.get("sweet_berries");

        ConditionalRegistrar.addOvenRecipe(new ItemStack(Items.cookie, 4),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationVanillaChanges.enableRecipeChanges},
            true,
            0.25f,
            stack(new ItemStack(ModItems.dough)),
            stack(new ItemStack(Items.dye, 1, 3)));

        ConditionalRegistrar.addOvenRecipe(new ItemStack(Items.pumpkin_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationVanillaChanges.enableRecipeChanges},
            true,
            0.45f,
            stack(new ItemStack(Items.sugar)),
            stack(new ItemStack(Blocks.pumpkin)),
            stack(new ItemStack(ModItems.dough)),
            stack(new ItemStack(Items.egg)));

        ConditionalRegistrar.addOvenRecipe(new ItemStack(ModItems.sweetberry_cookie, 4),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationModCompatibility.enableBerryCookie},
            true,
            0.2f,
            stack(new ItemStack(ModItems.dough)),
            stack(new ItemStack(sweet_berries)));

        ConditionalRegistrar.addOvenRecipe(new ItemStack(ModItems.chorus_cookie, 4),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationModCompatibility.enableChorusCookie},
            true,
            0.25f,
            stack(new ItemStack(ModItems.dough)),
            stack(new ItemStack(chorus_fruit)));

        ConditionalRegistrar.addOvenRecipe(new ItemStack(ModItems.chocolate_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enableChocolatePie},
            true,
            0.5f,
            stack(new ItemStack(Items.dye, 1, 3)),
            stack(new ItemStack(Items.dye, 1, 3)),
            stack(new ItemStack(ModItems.dough)),
            stack(new ItemStack(Items.egg)));

        ConditionalRegistrar.addOvenRecipe(new ItemStack(ModItems.birthday_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationBlocks.enableEvaporator, ModConfigurationItems.enableBirthdayPie},
            true,
            0.4f,
            stack(new ItemStack(Items.sugar)),
            ore("itemMilk"),
            stack(new ItemStack(ModItems.dough)),
            stack(new ItemStack(Items.egg)));
        ConditionalRegistrar.addOvenRecipe(new ItemStack(ModItems.birthday_pie),
            new boolean[]{ModConfigurationItems.enableDough, !ModConfigurationBlocks.enableEvaporator, ModConfigurationItems.enableBirthdayPie},
            true,
            0.4f,
            stack(new ItemStack(Items.sugar)),
            stack(new ItemStack(Items.milk_bucket)),
            stack(new ItemStack(ModItems.dough)),
            stack(new ItemStack(Items.egg)));

        ConditionalRegistrar.addOvenRecipe(new ItemStack(ModItems.apple_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enableApplePie},
            true,
            0.4f,
            stack(new ItemStack(Items.sugar)),
            stack(new ItemStack(Items.apple)),
            stack(new ItemStack(ModItems.dough)),
            stack(new ItemStack(Items.egg)));
        ConditionalRegistrar.addOvenRecipe(new ItemStack(ModItems.sweetberry_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationModCompatibility.enableBerryPie},
            true,
            0.4f,
            stack(new ItemStack(Items.sugar)),
            stack(new ItemStack(sweet_berries)),
            stack(new ItemStack(ModItems.dough)),
            stack(new ItemStack(Items.egg)));
        ConditionalRegistrar.addOvenRecipe(new ItemStack(ModItems.carrot_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enableCarrotPie},
            true,
            0.4f,
            stack(new ItemStack(Items.sugar)),
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(ModItems.dough)),
            stack(new ItemStack(Items.egg)));

        ConditionalRegistrar.addOvenRecipe(new ItemStack(ModItems.mushroom_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enableMushroomPie},
            true,
            0.45f,
            stack(new ItemStack(ModItems.salt)),
            ore("blockMushroom"),
            stack(new ItemStack(ModItems.dough)),
            stack(new ItemStack(Items.egg)));

        ConditionalRegistrar.addOvenRecipe(new ItemStack(ModItems.potato_mushroom),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enablePotatoPie},
            true,
            0.4f,
            stack(new ItemStack(ModItems.salt)),
            stack(new ItemStack(Items.potato)),
            stack(new ItemStack(ModItems.dough)),
            stack(new ItemStack(Items.egg)));

        ConditionalRegistrar.addOvenRecipe(new ItemStack(ModItems.onion_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enableOnion, ModConfigurationItems.enableOnionPie},
            true,
            0.4f,
            stack(new ItemStack(ModItems.salt)),
            stack(new ItemStack(ModItems.onion)),
            stack(new ItemStack(ModItems.dough)),
            stack(new ItemStack(Items.egg)));

        ConditionalRegistrar.addOvenRecipe(new ItemStack(ModItems.shepherds_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enableShepherdsPie},
            true,
            0.4f,
            stack(new ItemStack(ModItems.salt)),
            ore("itemRedmeat"),
            stack(new ItemStack(ModItems.dough)),
            stack(new ItemStack(Items.egg)));

        ConditionalRegistrar.addOvenRecipe(new ItemStack(ModItems.cod_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enableCodPie},
            true,
            0.4f,
            stack(new ItemStack(ModItems.salt)),
            stack(new ItemStack(Items.fish)),
            stack(new ItemStack(ModItems.dough)),
            stack(new ItemStack(Items.egg)));

        ConditionalRegistrar.addOvenRecipe(new ItemStack(ModItems.salmon_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enableSalmonPie},
            true,
            0.4f,
            stack(new ItemStack(ModItems.salt)),
            stack(new ItemStack(Items.fish, 1, 1)),
            stack(new ItemStack(ModItems.dough)),
            stack(new ItemStack(Items.egg)));

        ConditionalRegistrar.addOvenRecipe(new ItemStack(ModItems.tropical_fish_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enableTropicalFishPie},
            true,
            0.4f,
            stack(new ItemStack(ModItems.salt)),
            stack(new ItemStack(Items.fish, 1, 2)),
            stack(new ItemStack(ModItems.dough)),
            stack(new ItemStack(Items.egg)));

        ConditionalRegistrar.addOvenRecipe(new ItemStack(ModItems.tailor_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enableTailor, ModConfigurationItems.enableTailorPie},
            true,
            0.4f,
            stack(new ItemStack(ModItems.salt)),
            stack(new ItemStack(ModItems.tailor)),
            stack(new ItemStack(ModItems.dough)),
            stack(new ItemStack(Items.egg)));

        ConditionalRegistrar.addOvenRecipe(new ItemStack(ModItems.calamari_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enableCalamari, ModConfigurationItems.enableCalamariPie},
            true,
            0.4f,
            stack(new ItemStack(ModItems.salt)),
            stack(new ItemStack(ModItems.calamari)),
            stack(new ItemStack(ModItems.dough)),
            stack(new ItemStack(Items.egg)));

        ConditionalRegistrar.addOvenRecipe(new ItemStack(ModItems.saltwort_pie),
            new boolean[]{ModConfigurationItems.enableDough, ModConfigurationItems.enableSaltwortPie},
            true,
            0.4f,
            stack(new ItemStack(ModItems.saltwort)),
            stack(new ItemStack(ModItems.saltwort)),
            stack(new ItemStack(ModItems.dough)),
            stack(new ItemStack(Items.egg)));
    }
}
