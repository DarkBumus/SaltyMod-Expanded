package darkbum.saltymod.api;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashSet;
import java.util.Set;

public class PressingRecipeVesselRegistry {

    private static final Set<Item> validVesselItems = new HashSet<>();

    static {
        validVesselItems.add(Items.glass_bottle);
        validVesselItems.add(Items.bucket);
    }

    public static boolean isValidVessel(ItemStack stack) {
        return stack != null && validVesselItems.contains(stack.getItem());
    }

    public static void registerVesselItem(Item item) {
        validVesselItems.add(item);
    }

    public static void unregisterVesselItem(Item item) {
        validVesselItems.remove(item);
    }

    public static Set<Item> getValidVesselItems() {
        return new HashSet<>(validVesselItems);
    }
}
