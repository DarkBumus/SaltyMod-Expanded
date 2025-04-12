package darkbum.saltymod.api;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashSet;
import java.util.Set;

public class PotcookingRecipePinchRegistry {

    private static final Set<Item> validPinchItems = new HashSet<>();

    static {
        validPinchItems.add(Items.glass_bottle);
        validPinchItems.add(Items.bucket);
    }

    public static boolean isValidPinch(ItemStack stack) {
        return stack != null && validPinchItems.contains(stack.getItem());
    }

    public static void registerPinchItem(Item item) {
        validPinchItems.add(item);
    }

    public static void unregisterPinchItem(Item item) {
        validPinchItems.remove(item);
    }

    public static Set<Item> getValidPinchItems() {
        return new HashSet<>(validPinchItems);
    }
}
