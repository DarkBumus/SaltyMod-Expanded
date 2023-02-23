package ru.liahim.saltmod.biome;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class SaltBiomeBase extends BiomeGenBase {

	private final SaltBiomeBaseDecorator decorator;

	public SaltBiomeBase(int id, SaltBiomeBaseDecorator decorator) {

		super(id);
		this.decorator = decorator;
	}
	@Override
	public void decorate(World world, Random rand, int x, int z) {

		decorator.decorate(world, rand, x, z);
	}
}