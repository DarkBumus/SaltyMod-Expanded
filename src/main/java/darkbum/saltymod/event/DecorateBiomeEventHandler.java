package darkbum.saltymod.event;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkbum.saltymod.init.ModBiomes;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

/**
 * Event handler class for biome decorating-related events.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class DecorateBiomeEventHandler {

    private static final BiomeGenBase SALT_MARSH_BIOME = ModBiomes.saltMarsh;

    /**
     * Handles the preventing of lake generation in the salt marsh biome.
     *
     * @param event The decorate biome event, providing information about the decoration type and location.
     */
    @SuppressWarnings("unused")
    @SubscribeEvent
    public void decoateBiomeDecorate(DecorateBiomeEvent.Decorate event) {
        if (event.type == DecorateBiomeEvent.Decorate.EventType.LAKE
            && event.world.getBiomeGenForCoords(event.chunkX, event.chunkZ) == SALT_MARSH_BIOME) {
            event.setResult(Event.Result.DENY);
        }
    }
}
