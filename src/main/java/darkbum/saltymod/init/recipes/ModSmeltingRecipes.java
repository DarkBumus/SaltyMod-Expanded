package darkbum.saltymod.init.recipes;

import cpw.mods.fml.common.Loader;
import darkbum.saltymod.util.ConditionalRegistrar;
import darkbum.saltymod.common.config.ModConfigurationVanillaChanges;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import darkbum.saltymod.common.config.ModConfigurationBlocks;
import darkbum.saltymod.common.config.ModConfigurationItems;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;

public class ModSmeltingRecipes {

    public static void init() {


        ConditionalRegistrar.addSmelting(new ItemStack(ModItems.dough),
            new ItemStack(Items.bread),
            0.35f,
            ModConfigurationVanillaChanges.enableRecipeChanges, ModConfigurationItems.enableDough);

        ConditionalRegistrar.addSmelting(new ItemStack(Items.leather),
            new ItemStack(Items.slime_ball),
            0.5F);
        ConditionalRegistrar.addSmelting(new ItemStack(Items.rotten_flesh),
            new ItemStack(Items.leather),
            0.5F);

        ConditionalRegistrar.addSmelting(new ItemStack(ModBlocks.salt_ore),
            new ItemStack(ModItems.salt, 1),
            0.7F);
        ConditionalRegistrar.addSmelting(new ItemStack(ModBlocks.deepslate_salt_ore),
            new ItemStack(ModItems.salt, 1),
            0.7F,
            ModBlocks.deepslate_salt_ore != null);
        ConditionalRegistrar.addSmelting(new ItemStack(ModBlocks.salt_lake),
            new ItemStack(ModItems.salt, 1),
            0.7F);

        ConditionalRegistrar.addSmelting(new ItemStack(ModBlocks.salt_block, 1, 0),
            new ItemStack(ModBlocks.salt_block, 1, 6),
            0.1F,
            ModConfigurationBlocks.enableSaltBlocks);
        ConditionalRegistrar.addSmelting(new ItemStack(ModBlocks.salt_block, 1, 5),
            new ItemStack(ModBlocks.salt_block, 1, 7),
            0.1F,
            ModConfigurationBlocks.enableSaltBlocks);

        ConditionalRegistrar.addSmelting(new ItemStack(ModBlocks.wet_mud_brick),
            new ItemStack(ModBlocks.dry_mud_brick),
            0.1F,
            ModConfigurationBlocks.enableMudBricks, !ModConfigurationBlocks.complexMudBricks);

        ConditionalRegistrar.addSmelting(new ItemStack(ModItems.saltwort),
            new ItemStack(ModItems.baking_soda, 1),
            0.5F);
        ConditionalRegistrar.addSmelting(new ItemStack(ModItems.haunch),
            new ItemStack(ModItems.haunch, 1, 1),
            0.35F);

        ConditionalRegistrar.addSmelting(new ItemStack(ModItems.strider, 1, 0),
            new ItemStack(ModItems.strider, 1, 1),
            0.35F,
            Loader.isModLoaded("etfuturum"), !Loader.isModLoaded("netherlicious"));
        ConditionalRegistrar.addSmelting(new ItemStack(Items.fish, 1, 2),
            new ItemStack(ModItems.cooked_tropical_fish),
            0.35F,
            ModConfigurationItems.enableTropicalFish);
        ConditionalRegistrar.addSmelting(new ItemStack(ModItems.tailor),
            new ItemStack(ModItems.tailor, 1, 1),
            0.35F);
        ConditionalRegistrar.addSmelting(new ItemStack(ModItems.calamari),
            new ItemStack(ModItems.calamari, 1, 1),
            0.35F);
    }
}
