
package darkbum.saltymod.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import java.util.HashMap;
import java.util.Map;

import static darkbum.saltymod.init.ModExternalLoader.etFuturumItems;

public class SuspiciousStewRegistry {

    private static final Map<String, ItemStack> suspiciousStews = new HashMap<>();

    /**
     * Initializes all available suspicious stew variants.
     */
    public static void init() {
        suspiciousStews.clear();

        Item stew = etFuturumItems.get("suspicious_stew");
        if (stew == null) return;

        register(stew, "allium_stew", 12, 80);
        register(stew, "azure_bluet_stew", 15, 160);
        register(stew, "blue_orchid_stew", 23, 7);
        register(stew, "dandelion_stew", 23, 7);
        register(stew, "oxeye_daisy_stew", 10, 160);
        register(stew, "poppy_stew", 16, 100);
        register(stew, "red_tulip_stew", 18, 180);
        register(stew, "orange_tulip_stew", 18, 180);
        register(stew, "white_tulip_stew", 18, 180);
        register(stew, "pink_tulip_stew", 18, 180);
        register(stew, "lily_of_the_valley_stew", 19, 240);
        register(stew, "cornflower_stew", 8, 120);
        register(stew, "wither_rose_stew", 20, 160);
    }

    /**
     * Registers a suspicious stew variant with its corresponding effect.
     */
    private static void register(Item stew, String name, int effectId, int duration) {
        ItemStack stack = new ItemStack(stew);

        NBTTagCompound effect = new NBTTagCompound();
        effect.setByte("EffectId", (byte) effectId);
        effect.setInteger("EffectDuration", duration);

        NBTTagList effects = new NBTTagList();
        effects.appendTag(effect);

        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setTag("Effects", effects);

        stack.setTagCompound(nbt);

        suspiciousStews.put(name, stack);
    }

    /**
     * Retrieves a suspicious stew variant.
     */
    public static ItemStack get(String name) {
        ItemStack stack = suspiciousStews.get(name);
        return stack != null ? stack.copy() : null;
    }
}
