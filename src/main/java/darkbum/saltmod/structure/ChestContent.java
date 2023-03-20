package darkbum.saltmod.structure;

import darkbum.saltmod.init.ModBlocks;
import darkbum.saltmod.init.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class ChestContent {

	public static void addDungeonLoot() {
		final ItemStack shovelSilk = new ItemStack(Items.iron_shovel, 1, 100);
		shovelSilk.addEnchantment(Enchantment.silkTouch, 1);
		final ItemStack bookSilk = new ItemStack(Items.enchanted_book, 1, 0);
		bookSilk.addEnchantment(Enchantment.silkTouch, 1);

		final ChestGenHooks campChest_I = ChestGenHooks.getInfo("campChest_I");
		campChest_I.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.salt), 1, 2, 10));
		campChest_I.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.saltwort), 1, 4, 20));
		campChest_I.addItem(new WeightedRandomChestContent(new ItemStack(Items.wheat), 1, 4, 20));
		campChest_I.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.salt_cooked_porkchop), 1, 3, 5));
		campChest_I.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.salt_cooked_mutton), 1, 3, 5));
		campChest_I.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.salt_cooked_beef), 1, 3, 5));
		campChest_I.addItem(new WeightedRandomChestContent(new ItemStack(ModBlocks.mineral_mud), 1, 3, 30));
		campChest_I.addItem(new WeightedRandomChestContent(new ItemStack(ModBlocks.dry_mud_brick), 1, 6, 30));
		campChest_I.addItem(new WeightedRandomChestContent(shovelSilk, 1, 1, 1));
		campChest_I.addItem(new WeightedRandomChestContent(bookSilk, 1, 1, 1));
		campChest_I.setMin(5);
		campChest_I.setMax(10);

		final ChestGenHooks campChest_II = ChestGenHooks.getInfo("campChest_II");
		campChest_II.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.salt), 1, 3, 10));
		campChest_II.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.saltwort), 1, 6, 20));
		campChest_II.addItem(new WeightedRandomChestContent(new ItemStack(Items.wheat), 1, 6, 20));
		campChest_II.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.salt_cooked_porkchop), 1, 4, 5));
		campChest_II.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.salt_cooked_mutton), 1, 4, 5));
		campChest_II.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.salt_cooked_beef), 1, 4, 5));
		campChest_II.addItem(new WeightedRandomChestContent(new ItemStack(ModBlocks.mineral_mud), 1, 4, 30));
		campChest_II.addItem(new WeightedRandomChestContent(new ItemStack(ModBlocks.dry_mud_brick), 1, 9, 30));
		campChest_II.addItem(new WeightedRandomChestContent(new ItemStack(Items.emerald), 1, 3, 1));
		campChest_II.setMin(6);
		campChest_II.setMax(12);

		final ChestGenHooks campChest_III = ChestGenHooks.getInfo("campChest_III");
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
