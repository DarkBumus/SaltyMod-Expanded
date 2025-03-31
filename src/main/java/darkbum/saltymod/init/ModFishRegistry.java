package darkbum.saltymod.init;

import darkbum.saltymod.init.ModItems;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomFishable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ModFishRegistry {
    public static void registerItems() {
        normalFishLoot(new ItemStack(ModItems.tailor, 1, 0), 100);
    }

    public static void normalFishLoot(ItemStack item, int weight) {
        try {
            Field field = EntityFishHook.class.getDeclaredField("field_146036_f");
            List list = new ArrayList(getStaticFinalList(field));
            list.add(new WeightedRandomFishable(item, weight));
            setStaticFinalList(EntityFishHook.class.getDeclaredField("field_146036_f"), list);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static List getStaticFinalList(Field field) throws Exception {
        field.setAccessible(true);
        Field modifiers = Field.class.getDeclaredField("modifiers");
        modifiers.setAccessible(true);
        modifiers.setInt(field, field.getModifiers() & 0xFFFFFFEF);
        return (List)field.get(field);
    }

    private static void setStaticFinalList(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Field modifiers = Field.class.getDeclaredField("modifiers");
        modifiers.setAccessible(true);
        modifiers.setInt(field, field.getModifiers() & 0xFFFFFFEF);
        field.set(null, object);
    }
}
