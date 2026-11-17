package darkbum.saltymod.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkbum.saltymod.world.biome.SaltMarshMapGenCaves;
import darkbum.saltymod.world.biome.SaltMarshMapGenRavine;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.MapGenRavine;
import net.minecraftforge.event.terraingen.InitMapGenEvent;

public class MapGenInitEventHandler {

    @SubscribeEvent
    public void onInitMapGen(InitMapGenEvent event) {

        if (event.type == InitMapGenEvent.EventType.CAVE
            && event.newGen instanceof MapGenCaves) {

            event.newGen = new SaltMarshMapGenCaves();
        }

        if (event.type == InitMapGenEvent.EventType.RAVINE
            && event.newGen instanceof MapGenRavine) {

            event.newGen = new SaltMarshMapGenRavine();
        }
    }
}
