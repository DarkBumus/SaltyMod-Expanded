package darkbum.saltymod.util;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Adapter interface for crops that can be harvested using a hoe.
 */
public interface IHoeHarvestable {

    boolean isMature(World world, int x, int y, int z);

    List<ItemStack> getHarvestDrops(World world, int x, int y, int z);

    void resetCrop(World world, int x, int y, int z);
}
