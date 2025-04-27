package darkbum.saltymod.network.events;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkbum.saltymod.init.ModBiomes;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

public class DecorateBiomeEventHandler {

    private static final BiomeGenBase SALT_MARSH_BIOME = ModBiomes.saltMarsh;

    @SubscribeEvent
    public void onBiomeDecoration(DecorateBiomeEvent.Decorate event) {
        if (event.type == DecorateBiomeEvent.Decorate.EventType.LAKE && event.world.getBiomeGenForCoords(event.chunkX, event.chunkZ) == SALT_MARSH_BIOME) {
            event.setResult(Event.Result.DENY);
        }
    }
}
