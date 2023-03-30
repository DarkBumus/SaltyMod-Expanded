package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModConfiguration;
import net.minecraft.block.Block;
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

public class BlockSaltBlock extends Block {
    protected boolean crystal = true;

    @SideOnly(Side.CLIENT)
    private IIcon LINES;

    @SideOnly(Side.CLIENT)
    private IIcon LINESTOP;

    @SideOnly(Side.CLIENT)
    private IIcon CHISELED;

    @SideOnly(Side.CLIENT)
    private IIcon BRICK;

    @SideOnly(Side.CLIENT)
    private IIcon BRICKTOP;

    @SideOnly(Side.CLIENT)
    private IIcon BRICKBOTTOM;

    @SideOnly(Side.CLIENT)
    private IIcon BLOCKCRACKED;

    @SideOnly(Side.CLIENT)
    private IIcon BRICKCRACKED;

    @SideOnly(Side.CLIENT)
    private IIcon BRICKCRACKEDTOP;

    @SideOnly(Side.CLIENT)
    private IIcon BRICKCRACKEDBOTTOM;

    @SideOnly(Side.CLIENT)
    private IIcon BRICKCHISELED;

    @SideOnly(Side.CLIENT)
    private IIcon BRICKCHISELEDTOP;

    @SideOnly(Side.CLIENT)
    private IIcon BRICKCHISELEDBOTTOM;

    @SideOnly(Side.CLIENT)
    private IIcon CHAPITER;

    @SideOnly(Side.CLIENT)
    private IIcon CHAPITERTOP;

    public BlockSaltBlock(CreativeTabs tab) {
        super(Material.rock);
        setTickRandomly(true);
        setCreativeTab(tab);
        setHardness(5.0F);
        setResistance(10.0F);
        setHarvestLevel("pickaxe", 1);
    }

    public IIcon getIcon(int side, int meta) {
        if (meta < 0 || meta > 9)
            meta = 0;
        if (meta == 1)
            return this.CHISELED;
        if (meta == 2) {
            if (side < 2)
                return this.LINESTOP;
            return this.LINES;
        }
        if (meta == 3) {
            if (side > 3)
                return this.LINESTOP;
            return this.LINES;
        }
        if (meta == 4) {
            if (side == 2 || side == 3)
                return this.LINESTOP;
            return this.LINES;
        }
        if (meta == 5) {
            if (side == 1)
                return this.BRICKTOP;
            if (side == 0)
                return this.BRICKBOTTOM;
            return this.BRICK;
        }
        if (meta == 6)
            return this.BLOCKCRACKED;
        if (meta == 7) {
            if (side == 1)
                return this.BRICKCRACKEDTOP;
            if (side == 0)
                return this.BRICKCRACKEDBOTTOM;
            return this.BRICKCRACKED;
        }
        if (meta == 8) {
            if (side == 1)
                return this.BRICKCHISELEDTOP;
            if (side == 0)
                return this.BRICKCHISELEDBOTTOM;
            return this.BRICKCHISELED;
        }
        if (meta == 9) {
            if (side == 1)
                return this.CHAPITERTOP;
            if (side == 0)
                return this.LINESTOP;
            return this.CHAPITER;
        }
        return this.blockIcon;
    }

    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
        if (meta == 2)
            switch (side) {
                case 0:
                case 1:
                    meta = 2;
                    break;
                case 2:
                case 3:
                    meta = 4;
                    break;
                case 4:
                case 5:
                    meta = 3;
                    break;
            }
        return meta;
    }

    public int getRenderType() {
        return 39;
    }

    public int damageDropped(int meta) {
        return (meta != 3 && meta != 4) ? meta : 2;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
        list.add(new ItemStack(item, 1, 2));
        list.add(new ItemStack(item, 1, 5));
        list.add(new ItemStack(item, 1, 6));
        list.add(new ItemStack(item, 1, 7));
        list.add(new ItemStack(item, 1, 8));
        list.add(new ItemStack(item, 1, 9));
    }

    protected ItemStack createStackedBlock(int meta) {
        return (meta != 3 && meta != 4) ? super.createStackedBlock(meta) : new ItemStack(Item.getItemFromBlock(this), 1, 2);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1) {
        this.blockIcon = par1.registerIcon("saltymod:salt_block");
        this.CHISELED = par1.registerIcon("saltymod:chiseled_salt_block");
        this.LINES = par1.registerIcon("saltymod:salt_pillar");
        this.LINESTOP = par1.registerIcon("saltymod:salt_pillar_top");
        this.BRICK = par1.registerIcon("saltymod:salt_bricks");
        this.BRICKTOP = par1.registerIcon("saltymod:salt_bricks_top");
        this.BRICKBOTTOM = par1.registerIcon("saltymod:salt_bricks_bottom");
        this.BLOCKCRACKED = par1.registerIcon("saltymod:cracked_salt_block");
        this.BRICKCRACKED = par1.registerIcon("saltymod:cracked_salt_bricks");
        this.BRICKCRACKEDTOP = par1.registerIcon("saltymod:cracked_salt_bricks_top");
        this.BRICKCRACKEDBOTTOM = par1.registerIcon("saltymod:cracked_salt_bricks_bottom");
        this.BRICKCHISELED = par1.registerIcon("saltymod:chiseled_salt_bricks");
        this.BRICKCHISELEDTOP = par1.registerIcon("saltymod:chiseled_salt_bricks_top");
        this.BRICKCHISELEDBOTTOM = par1.registerIcon("saltymod:chiseled_salt_bricks_bottom");
        this.CHAPITER = par1.registerIcon("saltymod:salt_chapiter");
        this.CHAPITERTOP = par1.registerIcon("saltymod:salt_chapiter_top");
    }

    public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
        if (!world.isRemote && entity instanceof net.minecraft.entity.EntityLivingBase &&
            EntityList.getEntityString(entity) != null && ((
            EntityList.getEntityString(entity).toLowerCase().contains("slime") && !EntityList.getEntityString(entity).toLowerCase().contains("lava")) ||
            EntityList.getEntityString(entity).toLowerCase().contains("witch")))
            world.scheduleBlockUpdate(x, y, z, this, 0);
    }

    public void updateTick(World world, int x, int y, int z, Random rand) {
        if (!world.isRemote) {
            int d1 = 0;
            double d0 = 0.0625D;
            AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox(x, y, z, (x + 1), (y + 1), (z + 1)).expand(d0, d0, d0);
            List<Entity> list = world.getEntitiesWithinAABB(Entity.class, axisalignedbb);
            Iterator<Entity> iterator = list.iterator();
            while (iterator.hasNext()) {
                Entity entity = iterator.next();
                if (entity instanceof net.minecraft.entity.EntityLivingBase && EntityList.getEntityString(entity) != null && ((
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
            if ((world.getBlock(x + 1, y + 1, z) == ModBlocks.salt_block || world.getBlock(x + 1, y + 1, z) == ModBlocks.double_salt_slab) && (world
                .getBlock(x - 1, y + 1, z) == ModBlocks.salt_block || world.getBlock(x - 1, y + 1, z) == ModBlocks.double_salt_slab) && (world
                .getBlock(x, y + 1, z + 1) == ModBlocks.salt_block || world.getBlock(x, y + 1, z + 1) == ModBlocks.double_salt_slab) && (world
                .getBlock(x, y + 1, z - 1) == ModBlocks.salt_block || world.getBlock(x, y + 1, z - 1) == ModBlocks.double_salt_slab) && world
                .getBlock(x + 1, y + 1, z + 1).getMaterial() == Material.water && world
                .getBlock(x + 1, y + 1, z - 1).getMaterial() == Material.water && world
                .getBlock(x - 1, y + 1, z + 1).getMaterial() == Material.water && world
                .getBlock(x - 1, y + 1, z - 1).getMaterial() == Material.water && world
                .getFullBlockLightValue(x, y + 1, z) < 15) {
                if (rand.nextInt(ModConfiguration.saltCrystalGrowSpeed) == 0 && this.crystal)
                    if (world.getBlock(x, y + 1, z) == Blocks.air) {
                        world.setBlock(x, y + 1, z, ModBlocks.salt_crystal, 2, 3);
                    } else if (world.getBlock(x, y + 1, z) == ModBlocks.salt_crystal && world.getBlockMetadata(x, y + 1, z) == 2) {
                        world.setBlock(x, y + 1, z, ModBlocks.salt_crystal, 1, 3);
                    } else if (world.getBlock(x, y + 1, z) == ModBlocks.salt_crystal && world.getBlockMetadata(x, y + 1, z) == 1) {
                        world.setBlock(x, y + 1, z, ModBlocks.salt_crystal);
                    }
                this.crystal = true;
            }
            for (int x2 = x - 1; x2 < x + 2; x2++) {
                for (int y2 = y - 1; y2 < y + 2; y2++) {
                    for (int z2 = z - 1; z2 < z + 2; z2++) {
                        if ((world.getBlock(x2, y2, z2) == Blocks.ice || world.getBlock(x2, y2, z2) == Blocks.snow || (world
                            .getBlock(x2, y2, z2) == Blocks.snow_layer && y2 != y - 1)) && ((x2 - 1 == x && (world
                            .getBlock(x2 - 1, y2, z2) == this || world.getBlock(x2 - 1, y2, z2).getMaterial() == Material.water)) || (x2 + 1 == x && (world
                            .getBlock(x2 + 1, y2, z2) == this || world.getBlock(x2 + 1, y2, z2).getMaterial() == Material.water)) || (y2 - 1 == y && (world
                            .getBlock(x2, y2 - 1, z2) == this || world.getBlock(x2, y2 - 1, z2).getMaterial() == Material.water)) || (y2 + 1 == y && (world
                            .getBlock(x2, y2 + 1, z2) == this || world.getBlock(x2, y2 + 1, z2).getMaterial() == Material.water)) || (z2 - 1 == z && (world
                            .getBlock(x2, y2, z2 - 1) == this || world.getBlock(x2, y2, z2 - 1).getMaterial() == Material.water)) || (z2 + 1 == z && (world
                            .getBlock(x2, y2, z2 + 1) == this || world.getBlock(x2, y2, z2 + 1).getMaterial() == Material.water)))) {
                            this.crystal = false;
                            world.scheduleBlockUpdate(x, y, z, this, 5);
                            if (rand.nextInt(20) == 0) {
                                if (world.getBlock(x2, y2, z2) == Blocks.ice || world.getBlock(x2, y2, z2) == Blocks.snow) {
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

    public MapColor getMapColor(int meta) {
        return MapColor.quartzColor;
    }
}
