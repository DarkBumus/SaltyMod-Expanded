package darkbum.saltymod.world.structure;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;

import java.util.Random;

public class ChestContent {

    public static void init() {
        addDungeonLoot();
    }

    public static void addDungeonLoot() {
        Random rand = new Random();
        int meta = 100 + rand.nextInt(101);
        ItemStack shovelSilk = new ItemStack(Items.iron_shovel, 1, meta);
        shovelSilk.addEnchantment(Enchantment.silkTouch, 1);

        ChestGenHooks campChest_I = ChestGenHooks.getInfo("campChest_I");
        campChest_I.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.salt), 1, 2, 10));
        campChest_I.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.saltwort), 1, 4, 20));
        campChest_I.addItem(new WeightedRandomChestContent(new ItemStack(Items.wheat), 1, 4, 20));
        campChest_I.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.salt_cooked_porkchop), 1, 3, 5));
        campChest_I.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.salt_cooked_mutton), 1, 3, 5));
        campChest_I.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.salt_cooked_beef), 1, 3, 5));
        campChest_I.addItem(new WeightedRandomChestContent(new ItemStack(ModBlocks.mineral_mud), 1, 3, 30));
        campChest_I.addItem(new WeightedRandomChestContent(new ItemStack(ModBlocks.dry_mud_brick), 1, 6, 30));
        campChest_I.addItem(new WeightedRandomChestContent(shovelSilk, 1, 1, 1));
        campChest_I.setMin(5);
        campChest_I.setMax(10);

        ChestGenHooks campChest_II = ChestGenHooks.getInfo("campChest_II");
        campChest_II.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.salt), 1, 3, 10));
        campChest_II.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.saltwort), 1, 6, 20));
        campChest_II.addItem(new WeightedRandomChestContent(new ItemStack(Items.wheat), 1, 6, 20));
        campChest_II.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.salt_cooked_porkchop), 1, 4, 5));
        campChest_II.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.salt_cooked_mutton), 1, 4, 5));
        campChest_II.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.salt_cooked_beef), 1, 4, 5));
        campChest_II.addItem(new WeightedRandomChestContent(new ItemStack(ModBlocks.mineral_mud), 1, 4, 30));
        campChest_II.addItem(new WeightedRandomChestContent(new ItemStack(ModBlocks.dry_mud_brick), 1, 9, 30));
        campChest_II.addItem(new WeightedRandomChestContent(new ItemStack(Items.emerald), 1, 3, 1));
        campChest_II.addItem(new WeightedRandomChestContent(shovelSilk, 1, 1, 1));
        campChest_II.setMin(6);
        campChest_II.setMax(12);

        ChestGenHooks campChest_III = ChestGenHooks.getInfo("campChest_III");
        campChest_III.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.salt), 1, 1, 10));
        campChest_III.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.saltwort), 1, 2, 20));
        campChest_III.addItem(new WeightedRandomChestContent(new ItemStack(Items.wheat), 1, 2, 20));
        campChest_III.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.salt_cooked_porkchop), 1, 2, 5));
        campChest_III.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.salt_cooked_mutton), 1, 2, 5));
        campChest_III.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.salt_cooked_beef), 1, 2, 5));
        campChest_III.addItem(new WeightedRandomChestContent(new ItemStack(ModBlocks.mineral_mud), 1, 2, 30));
        campChest_III.addItem(new WeightedRandomChestContent(new ItemStack(ModBlocks.dry_mud_brick), 1, 3, 30));
        campChest_III.setMin(3);
        campChest_III.setMax(6);
    }
}
