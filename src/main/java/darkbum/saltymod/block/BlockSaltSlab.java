package darkbum.saltymod.block;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.configuration.configs.ModConfigurationBlocks;
import darkbum.saltymod.init.ModBlocks;

public class BlockSaltSlab extends BlockSlab {

    protected boolean crystal = true;

    public static final String[] type = new String[] { "block", "brick", "pillar" };

    @SideOnly(Side.CLIENT)
    private IIcon SALTBLOCK;

    @SideOnly(Side.CLIENT)
    private IIcon SALTBLOCKSIDE;

    @SideOnly(Side.CLIENT)
    private IIcon BRICKTOP;

    @SideOnly(Side.CLIENT)
    private IIcon BRICKBOTTOM;

    @SideOnly(Side.CLIENT)
    private IIcon LINES;

    @SideOnly(Side.CLIENT)
    private IIcon LINESTOP;

    public BlockSaltSlab(boolean isDouble, String name, CreativeTabs tab) {
        super(isDouble, Material.rock);
        setTickRandomly(true);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(5.0F);
        setResistance(10.0F);
        setHarvestLevel("pickaxe", 1);
        this.useNeighborBrightness = true;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (meta < 0 || (meta > 2 && meta < 8) || meta > 10) meta = 0;
        if (meta == 0 || meta == 8) {
            if (side == 0 || side == 1) return this.SALTBLOCK;
            return this.SALTBLOCKSIDE;
        }
        if (meta == 2 || meta == 10) {
            if (side == 0 || side == 1) return this.LINESTOP;
            return this.LINES;
        }
        if (side == 0) return this.BRICKBOTTOM;
        if (side == 1) return this.BRICKTOP;
        return this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1) {
        this.blockIcon = par1.registerIcon("saltymod:salt_bricks");
        this.BRICKTOP = par1.registerIcon("saltymod:salt_bricks_top");
        this.BRICKBOTTOM = par1.registerIcon("saltymod:salt_bricks_bottom");
        this.SALTBLOCK = par1.registerIcon("saltymod:salt_block");
        this.SALTBLOCKSIDE = par1.registerIcon("saltymod:salt_slab_side");
        this.LINES = par1.registerIcon("saltymod:salt_pillar");
        this.LINESTOP = par1.registerIcon("saltymod:salt_pillar_top");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list) {
        if (item != Item.getItemFromBlock(ModBlocks.double_salt_slab)) {
            list.add(new ItemStack(item, 1, 0));
            list.add(new ItemStack(item, 1, 1));
            list.add(new ItemStack(item, 1, 2));
        }
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Item.getItemFromBlock(ModBlocks.salt_slab);
    }

    public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
        if (!world.isRemote && entity instanceof net.minecraft.entity.EntityLivingBase
            && EntityList.getEntityString(entity) != null
            && ((EntityList.getEntityString(entity)
                .toLowerCase()
                .contains("slime")
                && !EntityList.getEntityString(entity)
                    .toLowerCase()
                    .contains("lava"))
                || EntityList.getEntityString(entity)
                    .toLowerCase()
                    .contains("witch")))
            world.scheduleBlockUpdate(x, y, z, this, 0);
    }

    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        if (!world.isRemote && entity instanceof net.minecraft.entity.EntityLivingBase
            && EntityList.getEntityString(entity) != null
            && ((EntityList.getEntityString(entity)
                .toLowerCase()
                .contains("slime")
                && !EntityList.getEntityString(entity)
                    .toLowerCase()
                    .contains("lava"))
                || EntityList.getEntityString(entity)
                    .toLowerCase()
                    .contains("witch")))
            world.scheduleBlockUpdate(x, y, z, this, 0);
    }

    public void updateTick(World world, int x, int y, int z, Random rand) {
        if (!world.isRemote) {
            int yUP, yDOWN;
            boolean DOWN;
            int d1 = 0;
            double d0 = 0.0625D;
            AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox(x, y, z, (x + 1), (y + 1), (z + 1))
                .expand(d0, d0, d0);
            List<Entity> list = world.getEntitiesWithinAABB(Entity.class, axisalignedbb);
            Iterator<Entity> iterator = list.iterator();
            while (iterator.hasNext()) {
                Entity entity = iterator.next();
                if (entity instanceof net.minecraft.entity.EntityLivingBase
                    && EntityList.getEntityString(entity) != null
                    && ((EntityList.getEntityString(entity)
                        .toLowerCase()
                        .contains("slime")
                        && !EntityList.getEntityString(entity)
                            .toLowerCase()
                            .contains("lava"))
                        || EntityList.getEntityString(entity)
                            .toLowerCase()
                            .contains("witch"))) {
                    entity.attackEntityFrom(DamageSource.cactus, 1.0F);
                    d1 = 3;
                }
                if (d1 > 0) {
                    d1--;
                    for (int x1 = x - 1; x1 < x + 2; x1++) {
                        for (int z1 = z - 1; z1 < z + 2; z1++) {
                            if (world.getBlock(x1, y, z1) == ModBlocks.salt_block
                                || world.getBlock(x1, y, z1) == ModBlocks.salt_lamp
                                || world.getBlock(x1, y, z1) == ModBlocks.salt_lake
                                || world.getBlock(x1, y, z1) == ModBlocks.salt_dirt
                                || world.getBlock(x1, y, z1) == ModBlocks.salt_brick_stairs
                                || world.getBlock(x1, y, z1) == ModBlocks.salt_slab
                                || world.getBlock(x1, y, z1) == ModBlocks.double_salt_slab)
                                world.scheduleBlockUpdate(x1, y, z1, this, 10);
                        }
                    }
                }
            }
            if ((world.getBlock(x + 1, y + 1, z) == ModBlocks.salt_block
                || world.getBlock(x + 1, y + 1, z) == ModBlocks.double_salt_slab)
                && (world.getBlock(x - 1, y + 1, z) == ModBlocks.salt_block
                    || world.getBlock(x - 1, y + 1, z) == ModBlocks.double_salt_slab)
                && (world.getBlock(x, y + 1, z + 1) == ModBlocks.salt_block
                    || world.getBlock(x, y + 1, z + 1) == ModBlocks.double_salt_slab)
                && (world.getBlock(x, y + 1, z - 1) == ModBlocks.salt_block
                    || world.getBlock(x, y + 1, z - 1) == ModBlocks.double_salt_slab)
                && world.getBlock(x + 1, y + 1, z + 1)
                    .getMaterial() == Material.water
                && world.getBlock(x + 1, y + 1, z - 1)
                    .getMaterial() == Material.water
                && world.getBlock(x - 1, y + 1, z + 1)
                    .getMaterial() == Material.water
                && world.getBlock(x - 1, y + 1, z - 1)
                    .getMaterial() == Material.water
                && world.getFullBlockLightValue(x, y + 1, z) < 15
                && world.getBlock(x, y, z) == ModBlocks.double_salt_slab) {
                if (rand.nextInt(ModConfigurationBlocks.saltCrystalGrowthSpeed) == 0 && this.crystal)
                    if (world.getBlock(x, y + 1, z) == Blocks.air) {
                        world.setBlock(x, y + 1, z, ModBlocks.salt_crystal, 2, 3);
                    } else if (world.getBlock(x, y + 1, z) == ModBlocks.salt_crystal
                        && world.getBlockMetadata(x, y + 1, z) == 2) {
                            world.setBlock(x, y + 1, z, ModBlocks.salt_crystal, 1, 3);
                        } else if (world.getBlock(x, y + 1, z) == ModBlocks.salt_crystal
                            && world.getBlockMetadata(x, y + 1, z) == 1) {
                                world.setBlock(x, y + 1, z, ModBlocks.salt_crystal);
                            }
                this.crystal = true;
            }
            if (world.getBlock(x, y, z) == ModBlocks.double_salt_slab) {
                yUP = 2;
                yDOWN = 1;
                DOWN = true;
            } else if (World.doesBlockHaveSolidTopSurface(world, x, y, z)) {
                yUP = 2;
                yDOWN = 0;
                DOWN = false;
            } else {
                yUP = 1;
                yDOWN = 1;
                DOWN = true;
            }
            for (int x2 = x - 1; x2 < x + 2; x2++) {
                for (int y2 = y - yDOWN; y2 < y + yUP; y2++) {
                    for (int z2 = z - 1; z2 < z + 2; z2++) {
                        if ((world.getBlock(x2, y2, z2) == Blocks.ice || world.getBlock(x2, y2, z2) == Blocks.snow
                            || (world.getBlock(x2, y2, z2) == Blocks.snow_layer && y2 != y - 1 && DOWN))
                            && ((x2 - 1 == x
                                && (world.getBlock(x2 - 1, y2, z2) == this || world.getBlock(x2 - 1, y2, z2)
                                    .getMaterial() == Material.water))
                                || (x2 + 1 == x
                                    && (world.getBlock(x2 + 1, y2, z2) == this || world.getBlock(x2 + 1, y2, z2)
                                        .getMaterial() == Material.water))
                                || (y2 - 1 == y
                                    && (world.getBlock(x2, y2 - 1, z2) == this || world.getBlock(x2, y2 - 1, z2)
                                        .getMaterial() == Material.water))
                                || (y2 + 1 == y
                                    && (world.getBlock(x2, y2 + 1, z2) == this || world.getBlock(x2, y2 + 1, z2)
                                        .getMaterial() == Material.water))
                                || (z2 - 1 == z
                                    && (world.getBlock(x2, y2, z2 - 1) == this || world.getBlock(x2, y2, z2 - 1)
                                        .getMaterial() == Material.water))
                                || (z2 + 1 == z
                                    && (world.getBlock(x2, y2, z2 + 1) == this || world.getBlock(x2, y2, z2 + 1)
                                        .getMaterial() == Material.water)))) {
                            this.crystal = false;
                            world.scheduleBlockUpdate(x, y, z, this, 5);
                            if (rand.nextInt(20) == 0) {
                                if (world.getBlock(x2, y2, z2) == Blocks.ice
                                    || world.getBlock(x2, y2, z2) == Blocks.snow) {
                                    world.setBlock(x2, y2, z2, Blocks.water);
                                    this.crystal = true;
                                }
                                if (world.getBlock(x2, y2, z2) == Blocks.snow_layer) {
                                    world.setBlockToAir(x2, y2, z2);
                                    this.crystal = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    protected boolean canSilkHarvest() {
        return false;
    }

    @Override
    public String func_150002_b(int par1) {
        if (par1 < 0 || par1 >= type.length) par1 = 0;
        return getUnlocalizedName() + "." + type[par1];
    }

    public MapColor getMapColor(int meta) {
        return MapColor.quartzColor;
    }
}
