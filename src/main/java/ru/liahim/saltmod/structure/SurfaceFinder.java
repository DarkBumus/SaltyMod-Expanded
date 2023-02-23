/*package ru.liahim.saltmod.structure;

import java.util.Random;

import ru.liahim.saltmod.init.SaltConfig;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class SurfaceFinder implements IWorldGenerator {
	
	public void generate(final Random rand, final int chunkX, final int chunkZ, final World world, final IChunkProvider chunkGenerator, final IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
			case 0: {
				this.placeOn(world, rand, chunkX * 16, chunkZ * 16);
				break;
			}
		}
	}
	
	private void placeOn(final World world, final Random rand, final int x, final int z) {
		if (!world.isClient) {
			final int randX = x + rand.nextInt(16);
			final int randZ = z + rand.nextInt(16);
			if (rand.nextInt(SaltConfig.brickmakerCampFrequency) == 0)
				for (int y = 50; y < 80; ++y) {
					if (world.getFullBlockLightValue(x, y + 1, z) >= 12 && world.getBlock(x, y, z).getMaterial().isSolid() && (world.getBlock(x, y, z).getMaterial() == Material.ground || world.getBlock(x, y, z).getMaterial() == Material.grass || world.getBlock(x, y, z).getMaterial() == Material.rock || world.getBlock(x, y, z).getMaterial() == Material.sand) && world.getBlock(x, y + 1, z).getMaterial() != Material.water && world.getBlock(x, y + 1, z).getMaterial() != Material.lava) {
						boolean chek = false;
						for (int ix = x - 3; ix < x + 4; ++ix) {
							for (int iy = y - 1; iy < y + 2; ++iy) {
								for (int iz = z - 3; iz < z + 4; ++iz) {
									if (!chek) {
										boolean chek2 = true;
										for (int jx = ix - 2; jx < ix + 3; ++jx) {
											for (int jz = iz - 2; jz < iz + 3; ++jz) {
												if (!chek2 || world.getFullBlockLightValue(jx, iy + 1, jz) < 4 || !world.getBlock(jx, iy, jz).getMaterial().isSolid() || (world.getBlock(jx, iy, jz).getMaterial() != Material.ground && world.getBlock(jx, iy, jz).getMaterial() != Material.grass && world.getBlock(jx, iy, jz).getMaterial() != Material.rock && world.getBlock(jx, iy, jz).getMaterial() != Material.sand) || world.getBlock(jx, iy + 1, jz).getMaterial() == Material.water || world.getBlock(jx, iy + 1, jz).getMaterial() == Material.lava) {
													chek2 = false;
												}
											}
										}
										if (chek2) {
											chek = true;
											if (world.getBlock(ix, iy, iz).getMaterial() == Material.ground || world.getBlock(ix, iy, iz).getMaterial() == Material.grass || world.getBlock(ix, iy, iz).getMaterial() == Material.rock) {
                                                BrickmakerCampGen.brickmakerCampGen(world, rand, ix, iy, iz);
											}
										}
									}
								}
							}
						}
					}
				}
		}
	}
}*/