package darkbum.saltymod.util;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;

public final class HoeHarvestRegistry {

    private static final Map<Block, IHoeHarvestable> HANDLERS = new HashMap<>();

    private HoeHarvestRegistry() {}

    public static void register(Block block, IHoeHarvestable handler) {
        if (block == null || handler == null) {
            throw new IllegalArgumentException("Block and handler must not be null.");
        }

        HANDLERS.put(block, handler);
    }

    public static IHoeHarvestable getHandler(Block block) {
        return HANDLERS.get(block);
    }

    @SuppressWarnings("unused")
    public static void unregister(Block block) {
        HANDLERS.remove(block);
    }
}
