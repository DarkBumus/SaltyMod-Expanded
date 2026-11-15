package darkbum.saltymod.init.recipes;

import darkbum.saltymod.tileentity.TileEntityClayOven;
import darkbum.saltymod.util.OvenbakingRecipe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static darkbum.saltymod.init.ModExternalLoader.*;
import static darkbum.saltymod.util.ConditionalRegistrar.*;
import static darkbum.saltymod.common.config.ModConfigurationBlocks.*;
import static darkbum.saltymod.common.config.ModConfigurationItems.*;
import static darkbum.saltymod.common.config.ModConfigurationModCompatibility.*;
import static darkbum.saltymod.common.config.ModConfigurationVanillaChanges.*;
import static darkbum.saltymod.util.OvenbakingRecipe.*;
import static darkbum.saltymod.init.ModItems.*;
import static darkbum.saltymod.init.ModItems.calamari;
import static net.minecraft.init.Blocks.*;
import static net.minecraft.init.Items.*;
import static net.minecraft.init.Items.dye;
import static net.minecraft.init.Items.wheat;

/**
 * Recipe class for {@link TileEntityClayOven}.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ModClayOvenRecipes {

    /**
     * Initializes all custom oven recipes.
     * <p>
     * Recipe definition:
     * OvenbakingRecipe.baking().registerRecipe(OUTPUT(ItemStack), HEATER?(boolean), XPCHANCE(float), INPUTS(ItemStack));
     * If you want to use this in your own mod, you need to import the static methods for stack and ore ingredients from {@link OvenbakingRecipe}.
     * NOTE:    The requiresHeater boolean intentionally functions in a way where setting the value to "false" will require the heater to NOT
     *          be present for the recipe to function.
     */
    public static void init() {

        Item mutton_raw = etFuturumItems.get("mutton_raw");
        Item mutton_cooked = etFuturumItems.get("mutton_cooked");
        Item rabbit_raw = etFuturumItems.get("rabbit_raw");
        Item rabbit_cooked = etFuturumItems.get("rabbit_cooked");
        Item chorus_fruit = etFuturumItems.get("chorus_fruit");
        Item chorus_fruit_popped = etFuturumItems.get("chorus_fruit_popped");
        Item sweet_berries = etFuturumItems.get("sweet_berries");

        addOvenRecipe(new ItemStack(bread),
            new boolean[]{enableDough, enableRecipeChanges},
            true,
            0.35f,
            stack(new ItemStack(dough)));
        addOvenRecipe(new ItemStack(bread),
            new boolean[]{!enableDough, enableRecipeChanges},
            true,
            0.35f,
            stack(new ItemStack(wheat)),
            stack(new ItemStack(wheat)),
            stack(new ItemStack(wheat)));

        addOvenRecipe(new ItemStack(cooked_porkchop),
            new boolean[]{enableRecipeChanges},
            true,
            0.15f,
            stack(new ItemStack(porkchop)));

        addOvenRecipe(new ItemStack(cooked_fished, 1, 0),
            new boolean[]{enableRecipeChanges},
            true,
            0.15f,
            stack(new ItemStack(fish, 1, 0)));

        addOvenRecipe(new ItemStack(cooked_fished, 1, 1),
            new boolean[]{enableRecipeChanges},
            true,
            0.15f,
            stack(new ItemStack(fish, 1, 1)));

        addOvenRecipe(new ItemStack(cookie, 4),
            new boolean[]{enableDough, enableRecipeChanges},
            true,
            0.25f,
            stack(new ItemStack(dough)),
            stack(new ItemStack(dye, 1, 3)));
        addOvenRecipe(new ItemStack(cookie, 4),
            new boolean[]{!enableDough, enableRecipeChanges},
            true,
            0.25f,
            stack(new ItemStack(wheat)),
            stack(new ItemStack(dye, 1, 3)));

        addOvenRecipe(new ItemStack(cooked_beef),
            new boolean[]{enableRecipeChanges},
            true,
            0.15f,
            stack(new ItemStack(beef)));

        addOvenRecipe(new ItemStack(cooked_chicken),
            new boolean[]{enableRecipeChanges},
            true,
            0.15f,
            stack(new ItemStack(chicken)));

        addOvenRecipe(new ItemStack(baked_potato),
            new boolean[]{enableRecipeChanges},
            true,
            0.15f,
            stack(new ItemStack(potato)));

        addOvenRecipe(new ItemStack(pumpkin_pie),
            new boolean[]{enableDough, enableRecipeChanges},
            true,
            0.45f,
            stack(new ItemStack(sugar)),
            stack(new ItemStack(pumpkin)),
            stack(new ItemStack(dough)),
            stack(new ItemStack(egg)));
        addOvenRecipe(new ItemStack(pumpkin_pie),
            new boolean[]{!enableDough, enableRecipeChanges},
            true,
            0.45f,
            stack(new ItemStack(sugar)),
            stack(new ItemStack(pumpkin)),
            stack(new ItemStack(wheat)),
            stack(new ItemStack(egg)));

        addOvenRecipe(new ItemStack(mutton_cooked),
            new boolean[]{enableRecipeChanges},
            true,
            0.15f,
            stack(new ItemStack(mutton_raw)));

        addOvenRecipe(new ItemStack(rabbit_cooked),
            new boolean[]{enableRecipeChanges},
            true,
            0.15f,
            stack(new ItemStack(rabbit_raw)));

        addOvenRecipe(new ItemStack(chorus_fruit_popped),
            new boolean[]{enableRecipeChanges},
            true,
            0.15f,
            stack(new ItemStack(chorus_fruit)));

        addOvenRecipe(new ItemStack(salt_cooked_porkchop),
            new boolean[]{enableRecipeChanges},
            true,
            0.25f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(porkchop)));

        addOvenRecipe(new ItemStack(salt_cooked_beef),
            new boolean[]{enableRecipeChanges},
            true,
            0.25f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(beef)));

        addOvenRecipe(new ItemStack(salt_cooked_chicken),
            new boolean[]{enableRecipeChanges},
            true,
            0.25f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(chicken)));

        addOvenRecipe(new ItemStack(salt_cooked_rabbit),
            new boolean[]{enableRecipeChanges},
            true,
            0.25f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(rabbit_raw)));

        addOvenRecipe(new ItemStack(salt_cooked_mutton),
            new boolean[]{enableRecipeChanges},
            true,
            0.25f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(mutton_raw)));

        addOvenRecipe(new ItemStack(strider, 1, 1),
            new boolean[]{enableRecipeChanges},
            true,
            0.15f,
            stack(new ItemStack(strider, 1, 0)));

        addOvenRecipe(new ItemStack(strider, 1, 2),
            new boolean[]{enableRecipeChanges},
            true,
            0.25f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(strider, 1, 0)));

        addOvenRecipe(new ItemStack(haunch, 1, 1),
            new boolean[]{enableRecipeChanges},
            true,
            0.15f,
            stack(new ItemStack(haunch, 1, 0)));

        addOvenRecipe(new ItemStack(haunch, 1, 2),
            new boolean[]{enableRecipeChanges},
            true,
            0.25f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(haunch, 1, 0)));

        addOvenRecipe(new ItemStack(salt_cooked_cod),
            new boolean[]{enableRecipeChanges},
            true,
            0.25f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(fish, 1, 0)));

        addOvenRecipe(new ItemStack(salt_cooked_salmon),
            new boolean[]{enableRecipeChanges},
            true,
            0.25f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(fish, 1, 1)));

        addOvenRecipe(new ItemStack(cooked_tropical_fish, 1, 0),
            new boolean[]{enableRecipeChanges},
            true,
            0.15f,
            stack(new ItemStack(fish, 1, 2)));

        addOvenRecipe(new ItemStack(cooked_tropical_fish, 1, 1),
            new boolean[]{enableRecipeChanges},
            true,
            0.25f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(fish, 1, 2)));

        addOvenRecipe(new ItemStack(tailor, 1, 1),
            new boolean[]{enableRecipeChanges},
            true,
            0.15f,
            stack(new ItemStack(tailor, 1, 0)));

        addOvenRecipe(new ItemStack(tailor, 1, 2),
            new boolean[]{enableRecipeChanges},
            true,
            0.25f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(tailor, 1, 0)));

        addOvenRecipe(new ItemStack(calamari, 1, 1),
            new boolean[]{enableRecipeChanges},
            true,
            0.15f,
            stack(new ItemStack(calamari, 1, 0)));

        addOvenRecipe(new ItemStack(calamari, 1, 2),
            new boolean[]{enableRecipeChanges},
            true,
            0.25f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(calamari, 1, 0)));

        addOvenRecipe(new ItemStack(salt_bread),
            new boolean[]{enableDough, enableRecipeChanges},
            true,
            0.45f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(dough)));
        addOvenRecipe(new ItemStack(salt_bread),
            new boolean[]{!enableDough, enableRecipeChanges},
            true,
            0.45f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(wheat)),
            stack(new ItemStack(wheat)),
            stack(new ItemStack(wheat)));

        addOvenRecipe(new ItemStack(salt_baked_potato),
            new boolean[]{enableRecipeChanges},
            true,
            0.25f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(potato)));

        addOvenRecipe(new ItemStack(sweetberry_cookie, 4),
            new boolean[]{enableDough, enableBerryCookie},
            true,
            0.2f,
            stack(new ItemStack(dough)),
            stack(new ItemStack(sweet_berries)));
        addOvenRecipe(new ItemStack(sweetberry_cookie, 4),
            new boolean[]{!enableDough, enableBerryCookie},
            true,
            0.2f,
            stack(new ItemStack(wheat)),
            stack(new ItemStack(sweet_berries)));

        addOvenRecipe(new ItemStack(chorus_cookie, 4),
            new boolean[]{enableDough, enableChorusCookie},
            true,
            0.25f,
            stack(new ItemStack(dough)),
            stack(new ItemStack(chorus_fruit)));
        addOvenRecipe(new ItemStack(chorus_cookie, 4),
            new boolean[]{!enableDough, enableChorusCookie},
            true,
            0.25f,
            stack(new ItemStack(wheat)),
            stack(new ItemStack(chorus_fruit)));

        addOvenRecipe(new ItemStack(chocolate_pie),
            new boolean[]{enableDough, enableChocolatePie},
            true,
            0.5f,
            stack(new ItemStack(dye, 1, 3)),
            stack(new ItemStack(dye, 1, 3)),
            stack(new ItemStack(dough)),
            stack(new ItemStack(egg)));
        addOvenRecipe(new ItemStack(chocolate_pie),
            new boolean[]{enableDough, enableChocolatePie},
            true,
            0.5f,
            stack(new ItemStack(dye, 1, 3)),
            stack(new ItemStack(dye, 1, 3)),
            stack(new ItemStack(wheat)),
            stack(new ItemStack(egg)));

        addOvenRecipe(new ItemStack(birthday_pie),
            new boolean[]{enableDough, enableEvaporator, enableBirthdayPie},
            true,
            0.4f,
            stack(new ItemStack(sugar)),
            ore("itemMilk"),
            stack(new ItemStack(dough)),
            stack(new ItemStack(egg)));
        addOvenRecipe(new ItemStack(birthday_pie),
            new boolean[]{enableDough, !enableEvaporator, enableBirthdayPie},
            true,
            0.4f,
            stack(new ItemStack(sugar)),
            stack(new ItemStack(milk_bucket)),
            stack(new ItemStack(dough)),
            stack(new ItemStack(egg)));
        addOvenRecipe(new ItemStack(birthday_pie),
            new boolean[]{!enableDough, enableEvaporator, enableBirthdayPie},
            true,
            0.4f,
            stack(new ItemStack(sugar)),
            ore("itemMilk"),
            stack(new ItemStack(wheat)),
            stack(new ItemStack(egg)));
        addOvenRecipe(new ItemStack(birthday_pie),
            new boolean[]{!enableDough, !enableEvaporator, enableBirthdayPie},
            true,
            0.4f,
            stack(new ItemStack(sugar)),
            stack(new ItemStack(milk_bucket)),
            stack(new ItemStack(wheat)),
            stack(new ItemStack(egg)));

        addOvenRecipe(new ItemStack(apple_pie),
            new boolean[]{enableDough, enableApplePie},
            true,
            0.4f,
            stack(new ItemStack(sugar)),
            stack(new ItemStack(apple)),
            stack(new ItemStack(dough)),
            stack(new ItemStack(egg)));
        addOvenRecipe(new ItemStack(apple_pie),
            new boolean[]{!enableDough, enableApplePie},
            true,
            0.4f,
            stack(new ItemStack(sugar)),
            stack(new ItemStack(apple)),
            stack(new ItemStack(wheat)),
            stack(new ItemStack(egg)));

        addOvenRecipe(new ItemStack(sweetberry_pie),
            new boolean[]{enableDough, enableBerryPie},
            true,
            0.4f,
            stack(new ItemStack(sugar)),
            stack(new ItemStack(sweet_berries)),
            stack(new ItemStack(dough)),
            stack(new ItemStack(egg)));
        addOvenRecipe(new ItemStack(sweetberry_pie),
            new boolean[]{!enableDough, enableBerryPie},
            true,
            0.4f,
            stack(new ItemStack(sugar)),
            stack(new ItemStack(sweet_berries)),
            stack(new ItemStack(wheat)),
            stack(new ItemStack(egg)));

        addOvenRecipe(new ItemStack(carrot_pie),
            new boolean[]{enableDough, enableCarrotPie},
            true,
            0.4f,
            stack(new ItemStack(sugar)),
            stack(new ItemStack(carrot)),
            stack(new ItemStack(dough)),
            stack(new ItemStack(egg)));
        addOvenRecipe(new ItemStack(carrot_pie),
            new boolean[]{!enableDough, enableCarrotPie},
            true,
            0.4f,
            stack(new ItemStack(sugar)),
            stack(new ItemStack(carrot)),
            stack(new ItemStack(wheat)),
            stack(new ItemStack(egg)));

        addOvenRecipe(new ItemStack(mushroom_pie),
            new boolean[]{enableDough, enableMushroomPie},
            true,
            0.45f,
            stack(new ItemStack(salt)),
            ore("blockMushroom"),
            stack(new ItemStack(dough)),
            stack(new ItemStack(egg)));
        addOvenRecipe(new ItemStack(mushroom_pie),
            new boolean[]{!enableDough, enableMushroomPie},
            true,
            0.45f,
            stack(new ItemStack(salt)),
            ore("blockMushroom"),
            stack(new ItemStack(wheat)),
            stack(new ItemStack(egg)));

        addOvenRecipe(new ItemStack(potato_pie),
            new boolean[]{enableDough, enablePotatoPie},
            true,
            0.4f,
            stack(new ItemStack(salt)),
            stack(new ItemStack(potato)),
            stack(new ItemStack(dough)),
            stack(new ItemStack(egg)));
        addOvenRecipe(new ItemStack(potato_pie),
            new boolean[]{!enableDough, enablePotatoPie},
            true,
            0.4f,
            stack(new ItemStack(salt)),
            stack(new ItemStack(potato)),
            stack(new ItemStack(wheat)),
            stack(new ItemStack(egg)));

        addOvenRecipe(new ItemStack(onion_pie),
            new boolean[]{enableDough, enableOnion, enableOnionPie},
            true,
            0.4f,
            stack(new ItemStack(salt)),
            stack(new ItemStack(onion)),
            stack(new ItemStack(dough)),
            stack(new ItemStack(egg)));
        addOvenRecipe(new ItemStack(onion_pie),
            new boolean[]{!enableDough, enableOnion, enableOnionPie},
            true,
            0.4f,
            stack(new ItemStack(salt)),
            stack(new ItemStack(onion)),
            stack(new ItemStack(wheat)),
            stack(new ItemStack(egg)));

        addOvenRecipe(new ItemStack(shepherds_pie),
            new boolean[]{enableDough, enableShepherdsPie},
            true,
            0.4f,
            stack(new ItemStack(salt)),
            ore("itemRedmeat"),
            stack(new ItemStack(dough)),
            stack(new ItemStack(egg)));
        addOvenRecipe(new ItemStack(shepherds_pie),
            new boolean[]{!enableDough, enableShepherdsPie},
            true,
            0.4f,
            stack(new ItemStack(salt)),
            ore("itemRedmeat"),
            stack(new ItemStack(wheat)),
            stack(new ItemStack(egg)));

        addOvenRecipe(new ItemStack(cod_pie),
            new boolean[]{enableDough, enableCodPie},
            true,
            0.4f,
            stack(new ItemStack(salt)),
            stack(new ItemStack(fish)),
            stack(new ItemStack(dough)),
            stack(new ItemStack(egg)));
        addOvenRecipe(new ItemStack(cod_pie),
            new boolean[]{!enableDough, enableCodPie},
            true,
            0.4f,
            stack(new ItemStack(salt)),
            stack(new ItemStack(fish)),
            stack(new ItemStack(wheat)),
            stack(new ItemStack(egg)));

        addOvenRecipe(new ItemStack(salmon_pie),
            new boolean[]{enableDough, enableSalmonPie},
            true,
            0.4f,
            stack(new ItemStack(salt)),
            stack(new ItemStack(fish, 1, 1)),
            stack(new ItemStack(dough)),
            stack(new ItemStack(egg)));
        addOvenRecipe(new ItemStack(salmon_pie),
            new boolean[]{!enableDough, enableSalmonPie},
            true,
            0.4f,
            stack(new ItemStack(salt)),
            stack(new ItemStack(fish, 1, 1)),
            stack(new ItemStack(wheat)),
            stack(new ItemStack(egg)));

        addOvenRecipe(new ItemStack(tropical_fish_pie),
            new boolean[]{enableDough, enableTropicalFishPie},
            true,
            0.4f,
            stack(new ItemStack(salt)),
            stack(new ItemStack(fish, 1, 2)),
            stack(new ItemStack(dough)),
            stack(new ItemStack(egg)));
        addOvenRecipe(new ItemStack(tropical_fish_pie),
            new boolean[]{!enableDough, enableTropicalFishPie},
            true,
            0.4f,
            stack(new ItemStack(salt)),
            stack(new ItemStack(fish, 1, 2)),
            stack(new ItemStack(wheat)),
            stack(new ItemStack(egg)));

        addOvenRecipe(new ItemStack(tailor_pie),
            new boolean[]{enableDough, enableTailor, enableTailorPie},
            true,
            0.4f,
            stack(new ItemStack(salt)),
            stack(new ItemStack(tailor)),
            stack(new ItemStack(dough)),
            stack(new ItemStack(egg)));
        addOvenRecipe(new ItemStack(tailor_pie),
            new boolean[]{!enableDough, enableTailor, enableTailorPie},
            true,
            0.4f,
            stack(new ItemStack(salt)),
            stack(new ItemStack(tailor)),
            stack(new ItemStack(wheat)),
            stack(new ItemStack(egg)));

        addOvenRecipe(new ItemStack(calamari_pie),
            new boolean[]{enableDough, enableCalamari, enableCalamariPie},
            true,
            0.4f,
            stack(new ItemStack(salt)),
            stack(new ItemStack(calamari)),
            stack(new ItemStack(dough)),
            stack(new ItemStack(egg)));
        addOvenRecipe(new ItemStack(calamari_pie),
            new boolean[]{!enableDough, enableCalamari, enableCalamariPie},
            true,
            0.4f,
            stack(new ItemStack(salt)),
            stack(new ItemStack(calamari)),
            stack(new ItemStack(wheat)),
            stack(new ItemStack(egg)));

        addOvenRecipe(new ItemStack(saltwort_pie),
            new boolean[]{enableDough, enableSaltwortPie},
            true,
            0.4f,
            stack(new ItemStack(saltwort)),
            stack(new ItemStack(saltwort)),
            stack(new ItemStack(dough)),
            stack(new ItemStack(egg)));

        addOvenRecipe(new ItemStack(muffin),
            new boolean[]{enableDough, enableHoney, enableMuffin},
            true,
            0.4f,
            ore("itemRoyaljelly"),
            stack(new ItemStack(dye, 1, 3)),
            stack(new ItemStack(dough)),
            stack(new ItemStack(egg)));
        addOvenRecipe(new ItemStack(muffin),
            new boolean[]{enableDough, !enableHoney, enableMuffin},
            true,
            0.4f,
            stack(new ItemStack(sugar)),
            stack(new ItemStack(dye, 1, 3)),
            stack(new ItemStack(dough)),
            stack(new ItemStack(egg)));
        addOvenRecipe(new ItemStack(muffin),
            new boolean[]{!enableDough, enableHoney, enableMuffin},
            true,
            0.4f,
            ore("itemRoyaljelly"),
            stack(new ItemStack(dye, 1, 3)),
            stack(new ItemStack(wheat)),
            stack(new ItemStack(egg)));
        addOvenRecipe(new ItemStack(muffin),
            new boolean[]{!enableDough, !enableHoney, enableMuffin},
            true,
            0.4f,
            stack(new ItemStack(sugar)),
            stack(new ItemStack(dye, 1, 3)),
            stack(new ItemStack(wheat)),
            stack(new ItemStack(egg)));
    }
}
