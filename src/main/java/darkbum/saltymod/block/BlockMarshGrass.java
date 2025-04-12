package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;

import darkbum.saltymod.common.ClientProxy;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockMarshGrass extends BlockBush implements IShearable {

    @SideOnly(Side.CLIENT)
    public IIcon BOTTOM;

    @SideOnly(Side.CLIENT)
    public IIcon TOP;

    public BlockMarshGrass(String name, CreativeTabs tab) {
        super(Material.grass);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(0.0F);
        setStepSound(soundTypeGrass);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if(meta == 0) {
            return BOTTOM;
        }
        return TOP;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg) {
        this.BOTTOM = reg.registerIcon("saltymod:marsh_reeds_bottom");
        this.TOP = reg.registerIcon("saltymod:marsh_reeds_top");
    }

    @Override
    public int getRenderType() {
        return 1 /*ClientProxy.marshGrassRenderType*/;
    }

    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        Block block = world.getBlock(x, y, z);
        Block blockBelow = world.getBlock(x, y - 1, z);
        Block blockAbove = world.getBlock(x, y + 1, z);
        return block == Blocks.water && blockBelow == ModBlocks.mineral_mud && blockAbove.isAir(world, x, y + 1, z);
    }

    protected void checkAndDropBlock(World world, int x, int y, int z) {
        if (!this.canBlockStay(world, x, y, z)) {
            int l = world.getBlockMetadata(x, y, z);

            // Überprüfe benachbarte Blöcke auf Material.water
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    Block neighborBlock = world.getBlock(x + i, y, z + j);
                    if (neighborBlock.getMaterial() == Material.water) {
                        // Wenn sich der Nachbarblock ändert und Wasser ist, lasse den Block stehen
                        return;
                    }
                }
            }

            // Andernfalls, wenn keine Wasserblöcke in der Nähe sind, droppe den Block
            if (!isSpecialBlockType(l)) {
                this.dropBlockAsItem(world, x, y, z, l, 0);

                if (world.getBlock(x, y + 1, z) == this) {
                    world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
                }
            }
            world.setBlock(x, y, z, Blocks.air, 0, 2);
        }
    }

    public boolean canBlockStay(World worldIn, int x, int y, int z) {
        if (worldIn.getBlock(x, y, z) != this) return super.canBlockStay(worldIn, x, y, z);
        int l = worldIn.getBlockMetadata(x, y, z);
        return isSpecialBlockType(l) ? worldIn.getBlock(x, y - 1, z) == this : worldIn.getBlock(x, y + 1, z) == this && super.canBlockStay(worldIn, x, y, z);
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        // Simuliere Wasserverhalten bei benachbarten Wasserquellen
        if (world.getBlock(x, y - 1, z) == Blocks.water) {
            // Setze das Blockverhalten ähnlich wie ein Wasserblock
            // Zum Beispiel: Block unter Wasser beeinflusst den Block darüber
            world.scheduleBlockUpdate(x, y, z, this, tickRate(world));
        }
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        // Wenn der Block hinzugefügt wird, überprüfen, ob er sich in der Nähe von Wasser befindet
        if (world.getBlock(x, y - 1, z) == Blocks.water) {
            // Wenn ja, setze eine Wasser-Simulation (Metawert setzen)
            world.setBlockMetadataWithNotify(x, y, z, 1, 2);
        }
    }

    public Item getItemDropped(int meta, Random random, int fortune) {
        if (!isSpecialBlockType(meta)) {
            if (random.nextInt(8) == 0) {
                return Items.wheat_seeds;
            } else if (random.nextInt(8) == 0) {
                return ModItems.salt_pinch;
            }
        }
        return null;
    }

    public static boolean isSpecialBlockType(int metadata) {
        return (metadata & 8) != 0;
    }

    public static int getSpecialBlockType(int metadata) {
        return metadata & 7;
    }

    public void onBlockPlacedBy(World worldIn, int x, int y, int z, EntityLivingBase placer, ItemStack itemIn) {
        int l = ((MathHelper.floor_double((double)(placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) + 2) % 4;
        worldIn.setBlock(x, y + 1, z, this, 8 | l, 2);
    }

    public void harvestBlock(World worldIn, EntityPlayer player, int x, int y, int z, int meta) {
        if (worldIn.isRemote || player.getCurrentEquippedItem() == null || player.getCurrentEquippedItem().getItem() != Items.shears || isSpecialBlockType(meta) || !this.handleBlockBreak(worldIn, x, y, z, meta, player)) {
            super.harvestBlock(worldIn, player, x, y, z, meta);
        }
    }

    public void onBlockHarvested(World worldIn, int x, int y, int z, int meta, EntityPlayer player) {
        if (isSpecialBlockType(meta)) {
            if (worldIn.getBlock(x, y - 1, z) == this) {
                if (!player.capabilities.isCreativeMode) {
                    int i1 = worldIn.getBlockMetadata(x, y - 1, z);
                    int j1 = getSpecialBlockType(i1);

                    if (j1 != 3 && j1 != 2) {
                        worldIn.func_147480_a(x, y - 1, z, true);
                    } else {
                        if (!worldIn.isRemote && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Items.shears) {
                            this.handleBlockBreak(worldIn, x, y, z, i1, player);
                        }
                        worldIn.setBlockToAir(x, y - 1, z);
                    }
                } else {
                    worldIn.setBlockToAir(x, y - 1, z);
                }
            }
        } else if (player.capabilities.isCreativeMode && worldIn.getBlock(x, y + 1, z) == this) {
            worldIn.setBlock(x, y + 1, z, Blocks.air, 0, 2);
        }
        super.onBlockHarvested(worldIn, x, y, z, meta, player);
    }

    private boolean handleBlockBreak(World world, int p_149886_2_, int x, int y, int z, EntityPlayer player) {
        int i1 = getSpecialBlockType(z);

        if (i1 != 3 && i1 != 2) {
            return false;
        } else {
            player.addStat(StatList.mineBlockStatArray[Block.getIdFromBlock(this)], 1);
            byte b0 = 1;

            if (i1 == 3) {
                b0 = 2;
            }
            this.dropBlockAsItem(world, p_149886_2_, x, y, new ItemStack(ModItems.marsh_reeds_grass, b0));
            return true;
        }
    }

    @Override
    public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
        return true;
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
        ArrayList<ItemStack> ret = new ArrayList<>();
        ret.add(new ItemStack(ModItems.marsh_reeds_grass, 1, world.getBlockMetadata(x, y, z)));
        return ret;
    }
}
