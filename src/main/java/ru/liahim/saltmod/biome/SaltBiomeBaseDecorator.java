package ru.liahim.saltmod.biome;

import java.util.Random;

import net.minecraft.world.World;

public class SaltBiomeBaseDecorator {

	protected World world;
	protected Random rand;
	protected int x, z;
	protected int xx, yy, zz, attempt;


	protected SaltBiomeBaseDecorator() {
	}



	public final void decorate(World world, Random rand, int x, int z) {

		this.world = world;
		this.rand = rand;
		this.x = x;
		this.z = z;

		decorate();


	}

	protected void decorate() {
	}

	protected final int offsetXZ() {
		return rand.nextInt(16) + 8;
	}

}