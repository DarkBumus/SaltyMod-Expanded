package darkbum.saltymod.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public final class HoeHarvestHelper {

    private HoeHarvestHelper() {}

    /**
     * Checks whether the block is a mature crop supported by hoe harvesting.
     */
    public static boolean isHarvestable(World world, int x, int y, int z) {
        Block block = world.getBlock(x, y, z);

        if (block instanceof BlockCrops) {
            return world.getBlockMetadata(x, y, z) < 7;
        }

        IHoeHarvestable handler = HoeHarvestRegistry.getHandler(block);

        return handler == null || handler.isMature(world, x, y, z);
    }

    /**
     * Harvests a supported crop, resets it and returns its drops.
     * Returns null if the block cannot be harvested.
     */
    public static List<ItemStack> harvest(World world, int x, int y, int z) {
        if (world == null || world.isRemote) return null;

        Block block = world.getBlock(x, y, z);

        if (block instanceof BlockCrops) {
            return harvestBlockCrops((BlockCrops) block, world, x, y, z);
        }

        IHoeHarvestable handler = HoeHarvestRegistry.getHandler(block);

        if (handler == null || handler.isMature(world, x, y, z)) {
            return null;
        }

        List<ItemStack> drops = copyDrops(
            handler.getHarvestDrops(world, x, y, z)
        );

        handler.resetCrop(world, x, y, z);

        return drops;
    }

    private static List<ItemStack> harvestBlockCrops(BlockCrops block, World world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);

        if (meta < 7) return null;

        List<ItemStack> drops = block.getDrops(world, x, y, z, meta, 0);

        Item cropItem = block.getItemDropped(meta, world.rand, 0);
        Item seedItem = block.getItemDropped(0, world.rand, 0);

        removeOneSeed(drops, seedItem, cropItem);

        world.setBlockMetadataWithNotify(x, y, z, 0, 2);

        return copyDrops(drops);
    }

    private static void removeOneSeed(
        List<ItemStack> drops, Item seedItem, Item cropItem
    ) {
        if (seedItem == null || drops == null) return;

        int matchingItems = 0;

        for (ItemStack stack : drops) {
            if (stack != null && stack.getItem() == seedItem) {
                matchingItems += stack.stackSize;
            }
        }

        // If the crop and seed are the same item, keep at least one.
        if (seedItem == cropItem && matchingItems <= 1) return;

        for (int i = drops.size() - 1; i >= 0; i--) {
            ItemStack stack = drops.get(i);

            if (stack != null && stack.getItem() == seedItem
                && stack.stackSize > 0) {

                stack.stackSize--;

                if (stack.stackSize <= 0) {
                    drops.remove(i);
                }

                return;
            }
        }
    }

    private static List<ItemStack> copyDrops(List<ItemStack> drops) {
        List<ItemStack> result = new ArrayList<>();

        if (drops == null) return result;

        for (ItemStack stack : drops) {
            if (stack != null && stack.stackSize > 0) {
                result.add(stack.copy());
            }
        }

        return result;
    }

    /**
     * Spawns drops at the crop position.
     */
    public static void spawnDrops(
        World world, int x, int y, int z, List<ItemStack> drops
    ) {
        if (world == null || world.isRemote || drops == null) return;

        for (ItemStack stack : drops) {
            if (stack == null || stack.stackSize <= 0) continue;

            EntityItem entityItem = new EntityItem(
                world,
                x + 0.5D,
                y + 0.5D,
                z + 0.5D,
                stack.copy()
            );

            world.spawnEntityInWorld(entityItem);
        }
    }
}
