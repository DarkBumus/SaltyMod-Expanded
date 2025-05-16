package darkbum.saltymod.util;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.oredict.OreDictionary;

import java.util.*;

import static darkbum.saltymod.init.ModBlocks.*;
import static darkbum.saltymod.init.ModExternalItemLoader.*;
import static darkbum.saltymod.init.ModItems.*;
import static net.minecraft.init.Blocks.*;
import static net.minecraft.init.Items.*;

/**
 * Utility class for managing and registering machine-related items and blocks,
 * such as valid heaters, pinch items, vessel items, bowl items, and spade items.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class MachineUtilRegistry {

    public static final Set<Block> validHeaterBlocks = new HashSet<>();
    public static final Set<String> validHeaterOreDicts = new HashSet<>();
    public static final Set<ItemStack> validPinchItems = new HashSet<>();
    public static final Set<String> validPinchOreDicts = new HashSet<>();
    public static final Set<ItemStack> validVesselItems = new HashSet<>();
    public static final Set<String> validVesselOreDicts = new HashSet<>();
    public static final Set<ItemStack> validBowlItems = new HashSet<>();
    public static final Set<String> validBowlOreDicts = new HashSet<>();
    public static final Set<ItemStack> validSpadeItems = new HashSet<>();
    public static final Set<String> validSpadeOreDicts = new HashSet<>();

    static {

        Block magma = etFuturumBlocks.get("magma");
        Block campfire = campfireBackportBlocks.get("campfire");
        Block soul_campfire = campfireBackportBlocks.get("soul_campfire");

        // Heater Registry
        validHeaterBlocks.add(flowing_lava);
        validHeaterBlocks.add(lava);
        validHeaterBlocks.add(fire);
        validHeaterBlocks.add(lit_furnace);
        validHeaterBlocks.add(lit_stove);
        if (magma != null) validHeaterBlocks.add(magma);
        if (campfire != null) validHeaterBlocks.add(campfire);
        if (soul_campfire != null) validHeaterBlocks.add(soul_campfire);

        validHeaterOreDicts.add("blockHeater");

        // Pinch Items
        registerPinchItem(new ItemStack(salt_pinch));
        registerPinchItem(new ItemStack(sugar_pinch));

        registerPinchOreDict("itemPinch");

        // Vessel Items
        registerVesselItem(new ItemStack(bucket));
        registerVesselItem(new ItemStack(water_bucket));
        registerVesselItem(new ItemStack(potionitem, 1, 0));
        registerVesselItem(new ItemStack(glass_bottle));
        registerVesselItem(new ItemStack(fizzy_drink));

        registerVesselOreDict("itemVessel");

        //Bowl Items
        registerBowlItem(new ItemStack(bowl));

        registerBowlOreDict("itemBowl");

        //Spade items
        registerSpadeItem(new ItemStack(wooden_shovel, 1, OreDictionary.WILDCARD_VALUE));

        registerSpadeOreDict("itemSpade");
    }

    // === Heater Methods ===

    /**
     * Checks if a given block is a valid heater block.
     *
     * @param block The block to check.
     * @return true, if the block is a valid heater, false otherwise.
     */
    public static boolean isValidHeater(Block block) {
        if (block == null || block == air) return false;

        if (validHeaterBlocks.contains(block)) {
            return true;
        }

        ItemStack stack = new ItemStack(block);
        int[] oreIds = OreDictionary.getOreIDs(stack);

        for (int oreId : oreIds) {
            String oreName = OreDictionary.getOreName(oreId);
            if (validHeaterOreDicts.contains(oreName)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Registers a block as a valid heater.
     *
     * @param block The block to register.
     */
    @SuppressWarnings("unused")
    public static void registerHeater(Block block) {
        if (block != null) validHeaterBlocks.add(block);
    }

    /**
     * Unregisters a block as a valid heater.
     *
     * @param block The block to unregister.
     */
    @SuppressWarnings("unused")
    public static void unregisterHeater(Block block) {
        validHeaterBlocks.remove(block);
    }

    /**
     * Registers an OreDict entry as a valid heater.
     *
     * @param oreDict The OreDict entry to register.
     */
    @SuppressWarnings("unused")
    public static void registerHeaterOreDict(String oreDict) {
        if (oreDict != null && !oreDict.isEmpty()) validHeaterOreDicts.add(oreDict);
    }

    /**
     * Unregisters an OreDict entry as a valid heater.
     *
     * @param oreDict The OreDict entry to unregister.
     */
    @SuppressWarnings("unused")
    public static void unregisterHeaterOreDict(String oreDict) {
        validHeaterOreDicts.remove(oreDict);
    }

    /**
     * Returns a set of all valid heater blocks.
     *
     * @return A set of valid heater blocks.
     */
    @SuppressWarnings("unused")
    public static Set<Block> getValidHeaters() {
        return new HashSet<>(validHeaterBlocks);
    }

    /**
     * Returns a set of all valid OreDict entries for heaters.
     *
     * @return A set of valid OreDict entries.
     */
    @SuppressWarnings("unused")
    public static Set<String> getValidHeaterOreDicts() {
        return new HashSet<>(validHeaterOreDicts);
    }

    // === Pinch Item Methods ===

    /**
     * Checks if a given item stack is a valid pinch item.
     *
     * @param stack The item stack to check.
     * @return true, if the item is a valid pinch item, false otherwise.
     */
    public static boolean isValidPinch(ItemStack stack) {
        if (stack == null) return false;

        for (ItemStack valid : validPinchItems) {
            if (areStacksEqualStrict(stack, valid)) return true;
        }

        int[] oreIds = OreDictionary.getOreIDs(stack);
        for (int oreId : oreIds) {
            String oreName = OreDictionary.getOreName(oreId);
            if (validPinchOreDicts.contains(oreName)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Registers an item stack as a valid pinch item.
     *
     * @param stack The item stack to register.
     */
    @SuppressWarnings("unused")
    public static void registerPinchItem(ItemStack stack) {
        if (stack != null) validPinchItems.add(stack);
    }

    /**
     * Unregisters an item stack as a valid pinch item.
     *
     * @param stack The item stack to unregister.
     */
    @SuppressWarnings("unused")
    public static void unregisterPinchItem(ItemStack stack) {
        validPinchItems.removeIf(valid -> areStacksEqualStrict(stack, valid));
    }

    /**
     * Registers an OreDict entry as a valid pinch item.
     *
     * @param oreDict The OreDict entry to register.
     */
    @SuppressWarnings("unused")
    public static void registerPinchOreDict(String oreDict) {
        if (oreDict != null && !oreDict.isEmpty()) validPinchOreDicts.add(oreDict);
    }

    /**
     * Unregisters an OreDict entry as a valid pinch item.
     *
     * @param oreDict The OreDict entry to unregister.
     */
    @SuppressWarnings("unused")
    public static void unregisterPinchOreDict(String oreDict) {
        validPinchOreDicts.remove(oreDict);
    }

    /**
     * Returns a set of all valid pinch items.
     *
     * @return A set of valid pinch items.
     */
    @SuppressWarnings("unused")
    public static Set<ItemStack> getValidPinchItems() {
        return new HashSet<>(validPinchItems);
    }

    /**
     * Returns a set of all valid OreDict entries for pinch items.
     *
     * @return A set of valid OreDict entries.
     */
    @SuppressWarnings("unused")
    public static Set<String> getValidPinchOreDicts() {
        return new HashSet<>(validPinchOreDicts);
    }

    // === Vessel Item Methods ===

    /**
     * Checks if a given item stack is a valid vessel item.
     *
     * @param stack The item stack to check.
     * @return true, if the item is a valid vessel item, false otherwise.
     */
    public static boolean isValidVessel(ItemStack stack) {
        if (stack == null) return false;

        for (ItemStack valid : validVesselItems) {
            if (areStacksEqualStrict(stack, valid)) return true;
        }

        int[] oreIds = OreDictionary.getOreIDs(stack);
        for (int oreId : oreIds) {
            String oreName = OreDictionary.getOreName(oreId);
            if (validVesselOreDicts.contains(oreName)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Registers an item stack as a valid vessel item.
     *
     * @param stack The item stack to register.
     */
    @SuppressWarnings("unused")
    public static void registerVesselItem(ItemStack stack) {
        if (stack != null) validVesselItems.add(stack);
    }

    /**
     * Unregisters an item stack as a valid vessel item.
     *
     * @param stack The item stack to unregister.
     */
    @SuppressWarnings("unused")
    public static void unregisterVesselItem(ItemStack stack) {
        validVesselItems.removeIf(valid -> areStacksEqualStrict(stack, valid));
    }

    /**
     * Registers an Ore Dictionary name as a valid vessel item.
     *
     * @param oreDict The OreDict name to register.
     */
    @SuppressWarnings("unused")
    public static void registerVesselOreDict(String oreDict) {
        if (oreDict != null && !oreDict.isEmpty()) validVesselOreDicts.add(oreDict);
    }

    /**
     * Unregisters an OreDict entry as a valid vessel item.
     *
     * @param oreDict The OreDict entry to unregister.
     */
    @SuppressWarnings("unused")
    public static void unregisterVesselOreDict(String oreDict) {
        validVesselOreDicts.remove(oreDict);
    }

    /**
     * Returns a set of all valid vessel items.
     *
     * @return A set of valid vessel items.
     */
    @SuppressWarnings("unused")
    public static Set<ItemStack> getValidVesselItems() {
        return new HashSet<>(validVesselItems);
    }

    /**
     * Returns a set of all valid OreDict entries for vessel items.
     *
     * @return A set of valid OreDict entries.
     */
    @SuppressWarnings("unused")
    public static Set<String> getValidVesselOreDicts() {
        return new HashSet<>(validVesselOreDicts);
    }

    // === Bowl Item Methods ===

    /**
     * Checks if a given item stack is a valid bowl item.
     *
     * @param stack The item stack to check.
     * @return true, if the item is a valid bowl item, false otherwise.
     */
    public static boolean isValidBowl(ItemStack stack) {
        if (stack == null) return false;

        for (ItemStack valid : validBowlItems) {
            if (areStacksEqualStrict(stack, valid)) return true;
        }

        int[] oreIds = OreDictionary.getOreIDs(stack);
        for (int oreId : oreIds) {
            String oreName = OreDictionary.getOreName(oreId);
            if (validBowlOreDicts.contains(oreName)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Registers an item stack as a valid bowl item.
     *
     * @param stack The item stack to register.
     */
    @SuppressWarnings("unused")
    public static void registerBowlItem(ItemStack stack) {
        if (stack != null) validBowlItems.add(stack);
    }

    /**
     * Unregisters an item stack as a valid bowl item.
     *
     * @param stack The item stack to unregister.
     */
    @SuppressWarnings("unused")
    public static void unregisterBowlItem(ItemStack stack) {
        validBowlItems.removeIf(valid -> areStacksEqualStrict(stack, valid));
    }

    /**
     * Registers an OreDict entry as a valid bowl item.
     *
     * @param oreDict The OreDict entry to register.
     */
    @SuppressWarnings("unused")
    public static void registerBowlOreDict(String oreDict) {
        if (oreDict != null && !oreDict.isEmpty()) validBowlOreDicts.add(oreDict);
    }

    /**
     * Unregisters an OreDict entry as a valid bowl item.
     *
     * @param oreDict The OreDict entry to unregister.
     */
    @SuppressWarnings("unused")
    public static void unregisterBowlOreDict(String oreDict) {
        validBowlOreDicts.remove(oreDict);
    }

    /**
     * Returns a set of all valid bowl items.
     *
     * @return A set of valid bowl items.
     */
    @SuppressWarnings("unused")
    public static Set<ItemStack> getValidBowlItems() {
        return new HashSet<>(validBowlItems);
    }

    /**
     * Returns a set of all valid OreDict entries for bowl items.
     *
     * @return A set of valid OreDict entries.
     */
    @SuppressWarnings("unused")
    public static Set<String> getValidBowlOreDicts() {
        return new HashSet<>(validBowlOreDicts);
    }

    // === Spade Item Methods ===

    /**
     * Checks if a given item stack is a valid spade item.
     *
     * @param stack The item stack to check.
     * @return True if the item is a valid spade item, false otherwise.
     */
    public static boolean isValidSpade(ItemStack stack) {
        if (stack == null) return false;

        for (ItemStack valid : validSpadeItems) {
            if (OreDictionary.itemMatches(valid, stack, false)) return true;
        }

        int[] oreIds = OreDictionary.getOreIDs(stack);
        for (int oreId : oreIds) {
            String oreName = OreDictionary.getOreName(oreId);
            if (validSpadeOreDicts.contains(oreName)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Registers an item stack as a valid spade item.
     *
     * @param stack The item stack to register.
     */
    @SuppressWarnings("unused")
    public static void registerSpadeItem(ItemStack stack) {
        if (stack != null) validSpadeItems.add(stack);
    }

    /**
     * Unregisters an item stack as a valid spade item.
     *
     * @param stack The item stack to unregister.
     */
    @SuppressWarnings("unused")
    public static void unregisterSpadeItem(ItemStack stack) {
        validSpadeItems.removeIf(valid -> areStacksEqualStrict(stack, valid));
    }

    /**
     * Registers an OreDict entry as a valid spade item.
     *
     * @param oreDict The OreDict entry to register.
     */
    @SuppressWarnings("unused")
    public static void registerSpadeOreDict(String oreDict) {
        if (oreDict != null && !oreDict.isEmpty()) validSpadeOreDicts.add(oreDict);
    }

    /**
     * Unregisters an OreDict entry as a valid spade item.
     *
     * @param oreDict The OreDict entry to unregister.
     */
    @SuppressWarnings("unused")
    public static void unregisterSpadeOreDict(String oreDict) {
        validSpadeOreDicts.remove(oreDict);
    }

    /**
     * Returns a set of all valid spade items.
     *
     * @return A set of valid spade items.
     */
    @SuppressWarnings("unused")
    public static Set<ItemStack> getValidSpadeItems() {
        return new HashSet<>(validSpadeItems);
    }

    /**
     * Returns a set of all valid OreDict entries for spade items.
     *
     * @return A set of valid OreDict entries.
     */
    @SuppressWarnings("unused")
    public static Set<String> getValidSpadeOreDicts() {
        return new HashSet<>(validSpadeOreDicts);
    }

    // === Apiary Enum Methods ===

    /**
     * Enum representing different types of bees in the game.
     */
    public enum BeeType {
        HONEY_BEE(new int[]{70, 98}, new ItemStack[]{new ItemStack(honeycomb), new ItemStack(waxcomb), new ItemStack(bee_larva)}),
        CARPENTER_BEE(new int[]{20, 98}, new ItemStack[]{new ItemStack(honeycomb), new ItemStack(waxcomb), new ItemStack(bee_larva)}),
        REGAL_BEE(new int[]{35, 50, 85}, new ItemStack[]{new ItemStack(honeycomb), new ItemStack(royal_jelly), new ItemStack(waxcomb), new ItemStack(bee_larva)}),
        BOREAL_BEE(new int[]{70, 98}, new ItemStack[]{new ItemStack(frozen_honey), new ItemStack(waxcomb), new ItemStack(bee_larva)});

        private final int[] thresholds;
        private final ItemStack[] items;

        /**
         * Constructs a BeeType with specific temperature thresholds and item drops.
         *
         * @param thresholds The temperature thresholds for the bee type.
         * @param items The items produced by this bee type.
         */
        BeeType(int[] thresholds, ItemStack[] items) {
            this.thresholds = thresholds;
            this.items = items;
        }

        /**
         * Retrieves the BeeType based on the given bee item.
         *
         * @param beeItem The ItemStack representing a bee item.
         * @return the corresponding BeeType, or null if no match is found.
         */
        public static BeeType getByBeeItem(ItemStack beeItem) {
            if (beeItem == null) return null;
            if (beeItem.getItem() == honey_bee) return HONEY_BEE;
            if (beeItem.getItem() == carpenter_bee) return CARPENTER_BEE;
            if (beeItem.getItem() == regal_bee) return REGAL_BEE;
            if (beeItem.getItem() == boreal_bee) return BOREAL_BEE;
            return null;
        }

        /**
         * Determines the produce item dropped by this bee based on a random chance.
         *
         * @param rand A Random instance used to determine the produce.
         * @return the item produced by the bee.
         */
        public ItemStack getProduce(Random rand) {
            int rndNum = rand.nextInt(100);
            for (int i = 0; i < thresholds.length; i++) {
                if (rndNum < thresholds[i]) {
                    return items[i];
                }
            }
            return items[items.length - 1];
        }
    }

    // === Fish Farm Enum Methods ===

    /**
     * Enum representing different types of fish that can be caught by the fish farm.
     */
    public enum FishType {
        COD(20, new ItemStack(fish, 1, 0)),
        SALMON(20, new ItemStack(fish, 1, 1)),
        CLOWNFISH(20, new ItemStack(fish, 1, 2)),
        PUFFERFISH(20, new ItemStack(fish, 1, 3)),
        TAILOR(20, new ItemStack(tailor, 1, 0));

        private final int baseChance;
        private final ItemStack item;

        /**
         * Constructs a FishType with a specified base chance and associated item.
         *
         * @param baseChance The base chance of catching this fish.
         * @param item The item representing the fish caught.
         */
        FishType(int baseChance, ItemStack item) {
            this.baseChance = baseChance;
            this.item = item;
        }

        /**
         * Returns the base chance of catching this fish.
         *
         * @return The base chance of catching the fish.
         */
        @SuppressWarnings("unused")
        public int getBaseChance() {
            return baseChance;
        }

        /**
         * Returns the item associated with this fish type.
         *
         * @return the ItemStack representing the fish item.
         */
        public ItemStack getItem() {
            return item;
        }

        /**
         * Adjusts the base chance of catching this fish depending on the biome.
         *
         * @param biome The biome where the fish is being caught.
         * @return the adjusted chance for this fish in the given biome.
         */
        public int getAdjustedChance(BiomeGenBase biome) {
            int adjustedChance = this.baseChance;

            if (biome == BiomeGenBase.river || biome == BiomeGenBase.frozenRiver) {
                if (this == COD || this == SALMON || this == TAILOR) {
                    adjustedChance += 10;
                }
                if (this == CLOWNFISH || this == PUFFERFISH) {
                    adjustedChance -= 15;
                }
            }

            if (biome == BiomeGenBase.ocean || biome == BiomeGenBase.frozenOcean || biome == BiomeGenBase.deepOcean) {
                if (this == CLOWNFISH || this == PUFFERFISH) {
                    adjustedChance += 10;
                }
                if (this == COD || this == SALMON || this == TAILOR) {
                    adjustedChance -= 7;
                }
            }
            return adjustedChance;
        }


        /**
         * Returns a random FishType based on the biome and random chance.
         *
         * @param world The world where the fish is being caught.
         * @param x The x coordinate of the catch location.
         * @param z The z coordinate of the catch location.
         * @param rnd A Random instance used for the selection.
         * @return a randomly selected FishType based on the location and biome.
         */
        public static FishType getRandomFish(World world, int x, int z, Random rnd) {
            BiomeGenBase biome = world.getBiomeGenForCoords(x, z);

            int totalChance = 0;
            for (FishType type : values()) {
                totalChance += type.getAdjustedChance(biome);
            }

            int rndNum = rnd.nextInt(totalChance);
            int cumulativeChance = 0;

            for (FishType type : values()) {
                cumulativeChance += type.getAdjustedChance(biome);
                if (rndNum < cumulativeChance) {
                    return type;
                }
            }

            return TAILOR;
        }
    }

    // === Utility ===

    /**
     * Compares two ItemStacks strictly for equality, considering item type, damage, and NBT tags.
     *
     * @param first The first ItemStack to compare.
     * @param second The second ItemStack to compare.
     * @return true, if both ItemStacks are exactly equal, false otherwise.
     */
    public static boolean areStacksEqualStrict(ItemStack first, ItemStack second) {
        return first != null && second != null &&
            first.getItem() == second.getItem() &&
            first.getItemDamage() == second.getItemDamage() &&
            Objects.equals(first.getTagCompound(), second.getTagCompound());
    }

    /**
     * Spawns experience orbs at the specified location in the world.
     * The orbs will be randomly distributed near the specified coordinates.
     *
     * @param world The world in which the experience orbs will spawn.
     * @param x The x coordinate of the spawn location.
     * @param y The y coordinate of the spawn location.
     * @param z The z coordinate of the spawn location.
     * @param xpAmount The amount of experience to spawn.
     */
    public static void spawnXp(World world, double x, double y, double z, float xpAmount) {
        if (world == null || world.isRemote || xpAmount <= 0) return;

        int xp = Math.round(xpAmount);

        double baseX = x + 0.5D;
        double baseY = y + 0.5D;
        double baseZ = z + 0.5D;

        List<EntityPlayer> nearbyPlayers = new ArrayList<>();
        for (Object obj : world.playerEntities) {
            if (obj instanceof EntityPlayer player) {
                double distSq = player.getDistanceSq(x, y, z);
                if (distSq <= 100.0D) {
                    nearbyPlayers.add(player);
                }
            }
        }

        if (nearbyPlayers.size() == 1) {
            EntityPlayer targetPlayer = nearbyPlayers.get(0);
            baseX = targetPlayer.posX;
            baseY = targetPlayer.posY + 0.5D;
            baseZ = targetPlayer.posZ;
        }

        Random rand = world.rand;

        while (xp > 0) {
            int split = EntityXPOrb.getXPSplit(xp);
            xp -= split;

            double offsetX = (rand.nextFloat() - 0.5D) * 0.5D;
            double offsetY = (rand.nextFloat() - 0.5D) * 0.25D;
            double offsetZ = (rand.nextFloat() - 0.5D) * 0.5D;

            EntityXPOrb orb = new EntityXPOrb(world, baseX + offsetX, baseY + offsetY, baseZ + offsetZ, split);

            orb.motionX = (rand.nextDouble() - 0.5D) * 0.02D;
            orb.motionY = (rand.nextDouble()) * 0.02D;
            orb.motionZ = (rand.nextDouble() - 0.5D) * 0.02D;

            world.spawnEntityInWorld(orb);
        }
    }
}
