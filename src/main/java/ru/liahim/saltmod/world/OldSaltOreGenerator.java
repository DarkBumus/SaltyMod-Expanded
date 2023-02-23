/*int I = 0;
  
  public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
    if (Loader.isModLoaded("TwilightForest"))
      this.I = SaltConfig.TFDim; 
    if (world.provider.dimensionId == 0 || (world.provider.dimensionId == this.I && SaltConfig.TFOreGen))
      generateOverworld(world, random, chunkX * 16, chunkZ * 16); 
  }
  
  public void generateOverworld(World world, Random rand, int chunkX, int chunkZ) {
    int H = 96;
    if (world.provider.dimensionId == 0) {
      H = 96;
    } else if (world.provider.dimensionId == this.I) {
      H = 64;
    } 
    for (int i = 0; i < SaltConfig.saltOreFrequency; i++) {
      int randPosX = chunkX + rand.nextInt(16);
      int randPosY = rand.nextInt(H);
      int randPosZ = chunkZ + rand.nextInt(16);
      (new WorldGenMinable(ModBlocks.saltOre, SaltConfig.saltOreSize)).generate(world, rand, randPosX, randPosY, randPosZ);
    } 
  }
}*/