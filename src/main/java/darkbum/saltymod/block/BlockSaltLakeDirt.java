package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import darkbum.saltymod.init.AchievSalt;
import darkbum.saltymod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockSaltLakeDirt extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon BOTTOM;

    @SideOnly(Side.CLIENT)
    private IIcon TOP;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE;

    public BlockSaltLakeDirt(String name, CreativeTabs tab) {
        super(Material.ground);
        setTickRandomly(true);
        setStepSound(soundTypeGravel);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(0.5F);
        setResistance(1.0F);
        setHarvestLevel("shovel", 0);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        switch(side) {
            case 0:
                return BOTTOM;
            case 1:
                return TOP;
        }
        return SIDE;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.BOTTOM = iconRegister.registerIcon("saltymod:salt_dirt_0");
        this.TOP = iconRegister.registerIcon("saltymod:salt_lake_dirt_top");
        this.SIDE = iconRegister.registerIcon("saltymod:salt_lake_dirt");
    }

    public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
        if (!world.isRemote && world
            .getBlockMetadata(x, y, z) == 1) {
            if (entity instanceof net.minecraft.entity.EntityLivingBase && EntityList.getEntityString(entity) != null && ((
                EntityList.getEntityString(entity).toLowerCase().contains("slime") && !EntityList.getEntityString(entity).toLowerCase().contains("lava")) ||
                EntityList.getEntityString(entity).toLowerCase().contains("witch")))
                world.scheduleBlockUpdate(x, y, z, this, 0);
            if (entity instanceof EntityPlayer)
                ((EntityPlayer)entity).addStat(AchievSalt.saltLake, 1);
        }
    }

    public void updateTick(World world, int x, int y, int z, Random random) {
        if (!world.isRemote) {
            if (world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2) {
                world.setBlock(x, y, z, ModBlocks.salt_dirt, 0, 3);
            } else if (world.getBlockLightValue(x, y + 1, z) >= 9) {
                for (int l = 0; l < 4; ++l) {
                    int i1 = x + random.nextInt(3) - 1;
                    int j1 = y + random.nextInt(5) - 3;
                    int k1 = z + random.nextInt(3) - 1;
                    Block block = world.getBlock(i1, j1 + 1, k1);
                    if (world.getBlock(i1, j1, k1) == ModBlocks.salt_dirt && world.getBlockMetadata(i1, j1, k1) == 0 && world.getBlockLightValue(i1, j1 + 1, k1) >= 4 && world.getBlockLightOpacity(i1, j1 + 1, k1) <= 2) {
                        world.setBlock(i1, j1, k1, ModBlocks.salt_grass);
                    }
                }
            }
            if (world.getBlockMetadata(x, y, z) == 1) {
                int d1 = 0;
                double d0 = 0.0625D;
                AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox(x, y, z, (x + 1), (y + 1) + d0, (z + 1));
                List<Entity> list = world.getEntitiesWithinAABB(Entity.class, axisalignedbb);
                Iterator<Entity> iterator = list.iterator();
                while (iterator.hasNext()) {
                    Entity entity = iterator.next();
                    if (entity instanceof EntityLivingBase && EntityList.getEntityString(entity) != null && ((
                        EntityList.getEntityString(entity).toLowerCase().contains("slime") && !EntityList.getEntityString(entity).toLowerCase().contains("lava")) ||
                        EntityList.getEntityString(entity).toLowerCase().contains("witch"))) {
                        entity.attackEntityFrom(DamageSource.cactus, 1.0F);
                        d1 = 3;
                    }
                    if (d1 > 0) {
                        d1--;
                        for (int x1 = x - 1; x1 < x + 2; x1++) {
                            for (int z1 = z - 1; z1 < z + 2; z1++) {
                                if (world.getBlock(x1, y, z1) == ModBlocks.salt_block || world.getBlock(x1, y, z1) == ModBlocks.salt_lamp || world
                                    .getBlock(x1, y, z1) == ModBlocks.salt_lake_ore || world.getBlock(x1, y, z1) == ModBlocks.salt_lake_dirt || world
                                    .getBlock(x1, y, z1) == ModBlocks.salt_brick_stairs || world.getBlock(x1, y, z1) == ModBlocks.salt_slab || world
                                    .getBlock(x1, y, z1) == ModBlocks.double_salt_slab)
                                    world.scheduleBlockUpdate(x1, y, z1, this, 10);
                            }
                        }
                    }
                }
                if (world.getBlock(x, y + 1, z).getMaterial() == Material.craftedSnow || world
                    .getBlock(x, y + 1, z).getMaterial() == Material.ice)
                    world.setBlock(x, y + 1, z, Blocks.water);
            }
            if (world.getBlock(x, y + 1, z).getMaterial() == Material.snow)
                world.setBlockToAir(x, y + 1, z);
        }
    }

    public MapColor getMapColor(int meta) {
        MapColor color = MapColor.dirtColor;
        if (meta == 1)
            color = MapColor.quartzColor;
        return color;
    }
}
