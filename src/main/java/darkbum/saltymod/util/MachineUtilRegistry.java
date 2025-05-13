package darkbum.saltymod.util;

import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModExternalItemLoader;
import darkbum.saltymod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.oredict.OreDictionary;

import java.util.*;

/**
 * Utility class for managing and registering machine-related items and blocks,
 * such as valid heaters, pinch items, vessel items, bowl items, and spade items.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class MachineUtilRegistry {

    public static final Set<Block> validHeaterBlocks = new HashSet<>();
    public static final Set<ItemStack> validPinchItems = new HashSet<>();
    public static final Set<ItemStack> validVesselItems = new HashSet<>();
    public static final Set<ItemStack> validBowlItems = new HashSet<>();
    public static final Set<ItemStack> validSpadeItems = new HashSet<>();

    static {

        Block magma = ModExternalItemLoader.etFuturumBlocks.get("magma");
        Block campfire = ModExternalItemLoader.campfireBackportBlocks.get("campfire");
        Block soul_campfire = ModExternalItemLoader.campfireBackportBlocks.get("soul_campfire");

        // Heater Registry
        validHeaterBlocks.add(Blocks.flowing_lava);
        validHeaterBlocks.add(Blocks.lava);
        validHeaterBlocks.add(Blocks.fire);
        validHeaterBlocks.add(Blocks.lit_furnace);
        validHeaterBlocks.add(ModBlocks.lit_stove);
        if (magma != null) validHeaterBlocks.add(magma);
        if (campfire != null) validHeaterBlocks.add(campfire);
        if (soul_campfire != null) validHeaterBlocks.add(soul_campfire);


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

    /**
     * Checks if a given block is a valid heater block.
     *
     * @param block The block to check.
     * @return true, if the block is a valid heater, false otherwise.
     */
    public static boolean isValidHeater(Block block) {
        return block != null && block != Blocks.air && validHeaterBlocks.contains(block);
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
     * Returns a set of all valid heater blocks.
     *
     * @return A set of valid heater blocks.
     */
    @SuppressWarnings("unused")
    public static Set<Block> getValidHeaters() {
        return new HashSet<>(validHeaterBlocks);
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
     * Returns a set of all valid pinch items.
     *
     * @return A set of valid pinch items.
     */
    @SuppressWarnings("unused")
    public static Set<ItemStack> getValidPinchItems() {
        return new HashSet<>(validPinchItems);
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
     * Returns a set of all valid vessel items.
     *
     * @return A set of valid vessel items.
     */
    @SuppressWarnings("unused")
    public static Set<ItemStack> getValidVesselItems() {
        return new HashSet<>(validVesselItems);
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
     * Returns a set of all valid bowl items.
     *
     * @return A set of valid bowl items.
     */
    @SuppressWarnings("unused")
    public static Set<ItemStack> getBowlPinchItems() {
        return new HashSet<>(validBowlItems);
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
     * Returns a set of all valid spade items.
     *
     * @return A set of valid spade items.
     */
    @SuppressWarnings("unused")
    public static Set<ItemStack> getSpadePinchItems() {
        return new HashSet<>(validSpadeItems);
    }

    // === Apiary Enum Methods ===

    /**
     * Enum representing different types of bees in the game.
     */
    public enum BeeType {
        HONEY_BEE(new int[]{70, 98}, new ItemStack[]{new ItemStack(ModItems.honeycomb), new ItemStack(ModItems.waxcomb), new ItemStack(ModItems.bee_larva)}),
        CARPENTER_BEE(new int[]{20, 98}, new ItemStack[]{new ItemStack(ModItems.honeycomb), new ItemStack(ModItems.waxcomb), new ItemStack(ModItems.bee_larva)}),
        REGAL_BEE(new int[]{35, 50, 85}, new ItemStack[]{new ItemStack(ModItems.honeycomb), new ItemStack(ModItems.royal_jelly), new ItemStack(ModItems.waxcomb), new ItemStack(ModItems.bee_larva)}),
        BOREAL_BEE(new int[]{70, 98}, new ItemStack[]{new ItemStack(ModItems.frozen_honey), new ItemStack(ModItems.waxcomb), new ItemStack(ModItems.bee_larva)});

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
            if (beeItem.getItem() == ModItems.honey_bee) return HONEY_BEE;
            if (beeItem.getItem() == ModItems.carpenter_bee) return CARPENTER_BEE;
            if (beeItem.getItem() == ModItems.regal_bee) return REGAL_BEE;
            if (beeItem.getItem() == ModItems.boreal_bee) return BOREAL_BEE;
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
        COD(20, new ItemStack(Items.fish, 1, 0)),
        SALMON(20, new ItemStack(Items.fish, 1, 1)),
        CLOWNFISH(20, new ItemStack(Items.fish, 1, 2)),
        PUFFERFISH(20, new ItemStack(Items.fish, 1, 3)),
        TAILOR(20, new ItemStack(ModItems.tailor, 1, 0));

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
