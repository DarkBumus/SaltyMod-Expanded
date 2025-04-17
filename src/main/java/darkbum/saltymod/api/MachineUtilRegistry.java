package darkbum.saltymod.api;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MachineUtilRegistry {

    public static final Set<Block> validHeaterBlocks = new HashSet<>();
    public static final Set<ItemStack> validPinchItems = new HashSet<>();
    public static final Set<ItemStack> validVesselItems = new HashSet<>();
    public static final Set<ItemStack> validBowlItems = new HashSet<>();
    public static final Set<ItemStack> validSpadeItems = new HashSet<>();

    static {
        // Heater Registry
        validHeaterBlocks.add(Blocks.flowing_lava);
        validHeaterBlocks.add(Blocks.lava);
        validHeaterBlocks.add(Blocks.fire);
        validHeaterBlocks.add(Blocks.lit_furnace);
        validHeaterBlocks.add(ModBlocks.lit_stove);
        if (Loader.isModLoaded("campfirebackport")) {
            Block campfire = GameRegistry.findBlock("campfirebackport", "campfire");
            Block soulCampfire = GameRegistry.findBlock("campfirebackport", "soul_campfire");
            if (campfire != null) validHeaterBlocks.add(campfire);
            if (soulCampfire != null) validHeaterBlocks.add(soulCampfire);
        }

        // Pinch Items
        registerPinchItem(new ItemStack(ModItems.salt_pinch));
        registerPinchItem(new ItemStack(ModItems.sugar_pinch));

        // Vessel Items
        registerVesselItem(new ItemStack(Items.bucket));
        registerVesselItem(new ItemStack(Items.water_bucket));
        registerVesselItem(new ItemStack(Items.potionitem, 1, 0));
        registerVesselItem(new ItemStack(Items.glass_bottle));
        registerVesselItem(new ItemStack(ModItems.fizzy_drink));

        //Bowl Items
        registerBowlItem(new ItemStack(Items.bowl));

        //Spade items
        registerSpadeItem(new ItemStack(Items.wooden_shovel, 1, OreDictionary.WILDCARD_VALUE));
    }

    // === Heater Methods ===

    public static boolean isValidHeater(Block block) {
        return block != null && block != Blocks.air && validHeaterBlocks.contains(block);
    }

    public static void registerHeater(Block block) {
        if (block != null) validHeaterBlocks.add(block);
    }

    public static void unregisterHeater(Block block) {
        validHeaterBlocks.remove(block);
    }

    public static Set<Block> getValidHeaters() {
        return new HashSet<>(validHeaterBlocks);
    }

    // === Pinch Item Methods ===

    public static boolean isValidPinch(ItemStack stack) {
        if (stack == null) return false;
        for (ItemStack valid : validPinchItems) {
            if (areStacksEqualStrict(stack, valid)) return true;
        }
        return false;
    }

    public static void registerPinchItem(ItemStack stack) {
        if (stack != null) validPinchItems.add(stack);
    }

    public static void unregisterPinchItem(ItemStack stack) {
        validPinchItems.removeIf(valid -> areStacksEqualStrict(stack, valid));
    }

    public static Set<ItemStack> getValidPinchItems() {
        return new HashSet<>(validPinchItems);
    }

    // === Vessel Item Methods ===

    public static boolean isValidVessel(ItemStack stack) {
        if (stack == null) return false;
        for (ItemStack valid : validVesselItems) {
            if (areStacksEqualStrict(stack, valid)) return true;
        }
        return false;
    }

    public static void registerVesselItem(ItemStack stack) {
        if (stack != null) validVesselItems.add(stack);
    }

    public static void unregisterVesselItem(ItemStack stack) {
        validVesselItems.removeIf(valid -> areStacksEqualStrict(stack, valid));
    }

    public static Set<ItemStack> getValidVesselItems() {
        return new HashSet<>(validVesselItems);
    }

    // === Bowl Item Methods ===

    public static boolean isValidBowl(ItemStack stack) {
        if (stack == null) return false;
        for (ItemStack valid : validBowlItems) {
            if (areStacksEqualStrict(stack, valid)) return true;
        }
        return false;
    }

    public static void registerBowlItem(ItemStack stack) {
        if (stack != null) validBowlItems.add(stack);
    }

    public static void unregisterBowlItem(ItemStack stack) {
        validBowlItems.removeIf(valid -> areStacksEqualStrict(stack, valid));
    }

    public static Set<ItemStack> getBowlPinchItems() {
        return new HashSet<>(validBowlItems);
    }

    // === Spade Item Methods ===

    public static boolean isValidSpade(ItemStack stack) {
        if (stack == null) return false;
        for (ItemStack valid : validSpadeItems) {
            if (OreDictionary.itemMatches(valid, stack, false)) return true;
        }
        return false;
    }

    public static void registerSpadeItem(ItemStack stack) {
        if (stack != null) validSpadeItems.add(stack);
    }

    public static void unregisterSpadeItem(ItemStack stack) {
        validSpadeItems.removeIf(valid -> areStacksEqualStrict(stack, valid));
    }

    public static Set<ItemStack> getSpadePinchItems() {
        return new HashSet<>(validSpadeItems);
    }

    // === Utility ===

    public static boolean areStacksEqualStrict(ItemStack a, ItemStack b) {
        return a != null && b != null &&
            a.getItem() == b.getItem() &&
            a.getItemDamage() == b.getItemDamage() &&
            Objects.equals(a.getTagCompound(), b.getTagCompound());
    }
}
