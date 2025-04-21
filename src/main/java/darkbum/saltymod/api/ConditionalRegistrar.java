package darkbum.saltymod.api;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ConditionalRegistrar {

    public static <T extends Item> void registerItem(T item, String name, boolean... conditions) {
        for (boolean condition : conditions) {
            if (!condition) return;
        }
        GameRegistry.registerItem(item, name);
    }
}
