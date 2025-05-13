package darkbum.saltymod.init;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomFishable;

import static darkbum.saltymod.common.config.ModConfigurationItems.*;
import static darkbum.saltymod.init.ModItems.*;

/**
 * Fish Registry class.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class ModFishRegistry {

    /**
     * Registers custom fishing loot items based on the configuration.
     * If the configuration allows, it adds a tailor item to the fishing loot list.
     */
    public static void registerItems() {
        if (enableTailor) {
            normalFishLoot(new ItemStack(tailor, 1, 0), 50);
        }
    }

    /**
     * Adds a custom item to the fishing loot table with a specified weight.
     * This method uses reflection to modify the static fishing loot field in the
     * {@link EntityFishHook} class, adding a new {@link WeightedRandomFishable} entry.
     *
     * @param item The item to add to the fishing loot table.
     * @param weight The weight of the item, affecting its probability of appearing in fishing loot.
     */
    public static void normalFishLoot(ItemStack item, int weight) {
        try {
            Field field = EntityFishHook.class.getDeclaredField("field_146036_f");
            List<WeightedRandomFishable> list = new ArrayList<>(getStaticFinalList(field));
            list.add(new WeightedRandomFishable(item, weight));
            setStaticFinalList(EntityFishHook.class.getDeclaredField("field_146036_f"), list);
        } catch (Exception exception) {
            Logger.getLogger(ModFishRegistry.class.getName()).log(Level.SEVERE, "Failed to register fishing loot item: " + item, exception);
        }
    }

    /**
     * Retrieves the internal list of fishing loot from the {@link EntityFishHook} class using reflection.
     * This list is stored in a private static field, and this method accesses it by bypassing Java's access restrictions.
     *
     * @param field The field of {@link EntityFishHook} containing the fishing loot list.
     * @return the list of {@link WeightedRandomFishable} objects representing the current fishing loot.
     * @throws Exception If there is an issue accessing the field or performing the reflection operations.
     */
    @SuppressWarnings("unchecked")
    private static List<WeightedRandomFishable> getStaticFinalList(Field field) throws Exception {
        field.setAccessible(true);
        Field modifiers = Field.class.getDeclaredField("modifiers");
        modifiers.setAccessible(true);
        modifiers.setInt(field, field.getModifiers() & 0xFFFFFFEF);

        return (List<WeightedRandomFishable>) field.get(field);
    }

    /**
     * Sets the internal list of fishing loot in the {@link EntityFishHook} class using reflection.
     * This method bypasses Java's access restrictions to modify the private static field in {@link EntityFishHook}.
     *
     * @param field The field of {@link EntityFishHook} that stores the fishing loot list.
     * @param object The new value to set for the fishing loot list.
     * @throws Exception If there is an issue accessing the field or performing the reflection operations.
     */
    private static void setStaticFinalList(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Field modifiers = Field.class.getDeclaredField("modifiers");
        modifiers.setAccessible(true);
        modifiers.setInt(field, field.getModifiers() & 0xFFFFFFEF);
        field.set(null, object);
    }
}
