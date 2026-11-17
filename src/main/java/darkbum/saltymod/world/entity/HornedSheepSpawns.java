package darkbum.saltymod.world.entity;

import darkbum.saltymod.entity.EntityHornedSheep;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import static net.minecraft.world.biome.BiomeGenBase.*;

public class HornedSheepSpawns {

    private HornedSheepSpawns() {}

    public static void register() {
        addSpawn(plains, 2, 4, 4);
        addSpawn(extremeHills, 4, 4, 4);
        addSpawn(forest, 2, 4, 4);
        addSpawn(taiga, 4, 4, 4);
        addSpawn(swampland, 2, 4, 4);
        addSpawn(forestHills, 2, 4, 4);
        addSpawn(taigaHills, 4, 4, 4);
        addSpawn(extremeHillsEdge, 4, 4, 4);
        addSpawn(jungle, 0, 4, 4);
        addSpawn(jungleHills, 0, 4, 4);
        addSpawn(jungleEdge, 0, 4, 4);
        addSpawn(birchForest, 2, 4, 4);
        addSpawn(birchForestHills, 2, 4, 4);
        addSpawn(roofedForest, 2, 4, 4);
        addSpawn(coldTaiga, 4, 4, 4);
        addSpawn(coldTaigaHills, 4, 4, 4);
        addSpawn(megaTaiga, 4, 4, 4);
        addSpawn(megaTaigaHills, 4, 4, 4);
        addSpawn(extremeHillsPlus, 4, 4, 4);
        addSpawn(savanna, 0, 4, 4);
        addSpawn(savannaPlateau, 0, 4, 4);
        addSpawn(mesa, 0, 4, 4);
        addSpawn(mesaPlateau_F, 0, 4, 4);
        addSpawn(mesaPlateau, 0, 2, 2);
    }

    private static void addSpawn(BiomeGenBase biome, int weight, int minGroupCount, int maxGroupCount) {
        if (weight <= 0) {
            return;
        }
        biome.getSpawnableList(EnumCreatureType.creature).add(new BiomeGenBase.SpawnListEntry(EntityHornedSheep.class, weight, minGroupCount, maxGroupCount));
    }
}
