package darkbum.saltymod.api;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltymod.init.ModBlocks;
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

    // === Apiary Enum Methods ===

    public enum BeeType {
        HONEY_BEE(new int[]{70, 98}, new ItemStack[]{new ItemStack(ModItems.honeycomb), new ItemStack(ModItems.waxcomb), new ItemStack(ModItems.bee_larva)}),
        CARPENTER_BEE(new int[]{20, 98}, new ItemStack[]{new ItemStack(ModItems.honeycomb), new ItemStack(ModItems.waxcomb), new ItemStack(ModItems.bee_larva)}),
        REGAL_BEE(new int[]{35, 50, 85}, new ItemStack[]{new ItemStack(ModItems.honeycomb), new ItemStack(ModItems.royal_jelly), new ItemStack(ModItems.waxcomb), new ItemStack(ModItems.bee_larva)}),
        BOREAL_BEE(new int[]{70, 98}, new ItemStack[]{new ItemStack(ModItems.frozen_honey), new ItemStack(ModItems.waxcomb), new ItemStack(ModItems.bee_larva)});

        private final int[] thresholds;
        private final ItemStack[] items;

        BeeType(int[] thresholds, ItemStack[] items) {
            this.thresholds = thresholds;
            this.items = items;
        }

        public static BeeType getByBeeItem(ItemStack beeItem) {
            if (beeItem == null) return null;
            if (beeItem.getItem() == ModItems.honey_bee) return HONEY_BEE;
            if (beeItem.getItem() == ModItems.carpenter_bee) return CARPENTER_BEE;
            if (beeItem.getItem() == ModItems.regal_bee) return REGAL_BEE;
            if (beeItem.getItem() == ModItems.boreal_bee) return BOREAL_BEE;
            return null;
        }

        public ItemStack getProduce(Random rnd) {
            int rndNum = rnd.nextInt(100);
            for (int i = 0; i < thresholds.length; i++) {
                if (rndNum < thresholds[i]) {
                    return items[i];
                }
            }
            return items[items.length - 1];
        }
    }

    // === Fish Farm Enum Methods ===

    public enum FishType {
        COD(20, new ItemStack(Items.fish, 1, 0)),
        SALMON(20, new ItemStack(Items.fish, 1, 1)),
        CLOWNFISH(20, new ItemStack(Items.fish, 1, 2)),
        PUFFERFISH(20, new ItemStack(Items.fish, 1, 3)),
        TAILOR(20, new ItemStack(ModItems.tailor, 1, 0));

        private final int baseChance;
        private final ItemStack item;

        FishType(int baseChance, ItemStack item) {
            this.baseChance = baseChance;
            this.item = item;
        }

        public int getBaseChance() {
            return baseChance;
        }

        public ItemStack getItem() {
            return item;
        }

        public int getAdjustedChance(BiomeGenBase biome) {
            int adjustedChance = this.baseChance;

            if (biome == BiomeGenBase.river || biome == BiomeGenBase.frozenRiver) {
                if (this == COD || this == SALMON || this == TAILOR) {
                    adjustedChance += 10;
                }
                if ( this == CLOWNFISH || this == PUFFERFISH) {
                    adjustedChance -= 15;
                }
            }

            if (biome == BiomeGenBase.ocean || biome == BiomeGenBase.frozenOcean || biome == BiomeGenBase.deepOcean) {
                if ( this == CLOWNFISH || this == PUFFERFISH) {
                    adjustedChance += 10;
                }
                if (this == COD || this == SALMON || this == TAILOR) {
                    adjustedChance -= 7;
                }
            }
            return adjustedChance;
        }

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

    public static boolean areStacksEqualStrict(ItemStack a, ItemStack b) {
        return a != null && b != null &&
            a.getItem() == b.getItem() &&
            a.getItemDamage() == b.getItemDamage() &&
            Objects.equals(a.getTagCompound(), b.getTagCompound());
    }

    public static void spawnXp(World world, double x, double y, double z, float xpAmount) {
        if (world == null || world.isRemote || xpAmount <= 0) return;

        int xp = Math.round(xpAmount);

        EntityPlayer player = world.getClosestPlayer(x, y, z, 5.0D);

        double baseX = x + 0.5D;
        double baseY = y + 0.5D;
        double baseZ = z + 0.5D;

        boolean spawnAtPlayer = player != null;

        if (spawnAtPlayer) {
            baseX = player.posX;
            baseY = player.posY + 0.5D;
            baseZ = player.posZ;
        }

        Random rand = world.rand;  // Nutze Minecraft's Random-Instanz

        while (xp > 0) {
            int split = EntityXPOrb.getXPSplit(xp);
            xp -= split;

            // Leichte Zufallsbewegung
            double offsetX = (rand.nextFloat() - 0.5D) * 0.5D;  // ±0.25 Blöcke
            double offsetY = (rand.nextFloat() - 0.5D) * 0.25D; // ±0.125 Blöcke
            double offsetZ = (rand.nextFloat() - 0.5D) * 0.5D;

            EntityXPOrb orb = new EntityXPOrb(world, baseX + offsetX, baseY + offsetY, baseZ + offsetZ, split);

            // Optional: Noch sanfte Startbewegung
            orb.motionX = (rand.nextDouble() - 0.5D) * 0.02D; // Sehr leichte Bewegung
            orb.motionY = (rand.nextDouble()) * 0.02D;
            orb.motionZ = (rand.nextDouble() - 0.5D) * 0.02D;

            world.spawnEntityInWorld(orb);
        }
    }
}
