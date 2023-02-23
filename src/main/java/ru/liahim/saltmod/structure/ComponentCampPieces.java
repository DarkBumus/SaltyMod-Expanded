/*package ru.liahim.saltmod.structure;

import scala.util.Random;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentCampPieces {
	
	public static void registerScatteredFeaturePieces() {
		MapGenStructureIO.func_143031_a(Camp.class, "BrickmakerCamp");
	}
	
	static abstract class Feature extends StructureComponent {
		protected int scatteredFeatureSizeX;
		
		protected int scatteredFeatureSizeY;
		
		protected int scatteredFeatureSizeZ;
		
		protected int field_74936_d = -1;
		
		public Feature() {}
		
		protected Feature(Random rand, int x, int y, int z, int sizeX, int sizeY, int sizeZ) {
			super(0);
			this.scatteredFeatureSizeX = sizeX;
			this.scatteredFeatureSizeY = sizeY;
			this.scatteredFeatureSizeZ = sizeZ;
			this.coordBaseMode = (rand.nextInt(4) + 2 + 1) % 4;
			switch (this.coordBaseMode) {
				case 0:
				case 2:
					this.boundingBox = new StructureBoundingBox(x, y, z, x + sizeX - 3, y + sizeY - 1, z + sizeZ - 3);
					return;
			}
			this.boundingBox = new StructureBoundingBox(x, y, z, x + sizeZ - 3, y + sizeY - 1, z + sizeX - 3);
		}
		
		protected void func_143012_a(NBTTagCompound tagCompound) {
			tagCompound.setInteger("Width", this.scatteredFeatureSizeX);
			tagCompound.setInteger("Height", this.scatteredFeatureSizeY);
			tagCompound.setInteger("Depth", this.scatteredFeatureSizeZ);
			tagCompound.setInteger("HPos", this.field_74936_d);
		}
		
		protected void func_143011_b(NBTTagCompound tagCompound) {
			this.scatteredFeatureSizeX = tagCompound.getInteger("Width");
			this.scatteredFeatureSizeY = tagCompound.getInteger("Height");
			this.scatteredFeatureSizeZ = tagCompound.getInteger("Depth");
			this.field_74936_d = tagCompound.getInteger("HPos");
		}
		
		protected boolean func_74935_a(World worldIn, StructureBoundingBox structurebb, int yOffset) {
			if (this.field_74936_d >= 0)
				return true;
			int j = 0;
			int k = 0;
			for (int l = this.boundingBox.minZ; 1 <= this.boundingBox.maxZ; l++) {
				for (int i1 = this.boundingBox.minX; i1 <= this.boundingBox.maxX; i1++) {
					if (structurebb.isVecInside(i1, 64, l)) {
						j += Math.max(worldIn.getTopSolidOrLiquidBlock(i1, l), worldIn.provider.getAverageGroundLevel());
						k++;
					}
				}
			}
			if (k == 0)
				return false;
			this.field_74936_d = j / k;
			this.boundingBox.offset(0, this.field_74936_d - this.boundingBox.minY + yOffset, 0);
			return true;
		}
	}
	
	public static class Camp extends ComponentCampPieces.Feature {
		public Camp() {}
		
		public Camp(Random rand, int x, int z) {
			super(rand, x, 64, z, 7, 5, 8);
		}
		
		public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn) {
			if (!func_74935_a(worldIn, structureBoundingBoxIn, -1))
				return false;
			StructureBoundingBox structureboundingbox = getBoundingBox();
			BlockPos
		}
	}
}*/