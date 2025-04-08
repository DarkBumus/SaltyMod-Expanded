package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.common.ClientProxy;
import darkbum.saltymod.configuration.configs.ModConfigurationWorldGeneration;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

import java.util.ArrayList;
import java.util.Random;

public class BlockMarshReeds extends BlockBush implements IShearable {

    @SideOnly(Side.CLIENT)
    public IIcon UPPER;

    @SideOnly(Side.CLIENT)
    public IIcon LOWER;

    public BlockMarshReeds(String name, CreativeTabs tab) {
        super(Material.plants);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(0.0F);
        setStepSound(soundTypeGrass);
        setTickRandomly(true);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void registerBlockIcons(IIconRegister icon) {
        this.UPPER = icon.registerIcon("saltymod:marsh_reeds_top");
        this.LOWER = icon.registerIcon("saltymod:marsh_reeds_bottom");
    }

    public IIcon getIcon(int side, int meta) {
        return UPPER;
    }

    public int getRenderType() {
        return ClientProxy.marshReedsRenderType;
    }

    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        Block blockBelow = world.getBlock(x, y - 1, z);
        Block blockTwoBelow = world.getBlock(x, y - 2, z);
        return blockBelow == Blocks.water && blockTwoBelow == ModBlocks.mineral_mud;
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
        int chanceValue = ModConfigurationWorldGeneration.marshReedUpdateFrequency;
        int maxChance = 100;
        int checkChance = Math.min(maxChance, chanceValue);

        if (random.nextInt(100) < checkChance) {
            if (!canPlaceBlockAt(world, x, y, z)) {
                dropIfCantStay(world, x, y, z, new ItemStack(this, 1, world.getBlockMetadata(x, y, z)));
            }
        }
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block neighborBlock) {
        if (world.getBlock(x, y, z) != null && !canPlaceBlockAt(world, x, y, z)) {
            dropIfCantStay(world, x, y, z, new ItemStack(world.getBlock(x, y, z), 1, world.getBlockMetadata(x, y, z)));
        }
    }

    public void dropIfCantStay(World world, int x, int y, int z, ItemStack stack) {
        if (!canPlaceBlockAt(world, x, y, z)) {
            ArrayList<ItemStack> drops = this.getDrops(world, x, y, z, world.getBlockMetadata(x, y, z), 0);

            for (ItemStack drop : drops) {
                world.spawnEntityInWorld(new EntityItem(world, x + 0.5D, y + 1.0D, z + 0.5D, drop));

                world.setBlockToAir(x, y, z);
                world.playSoundEffect(x + 0.5D, y + 2.0D, z + 0.5D, "dig.grass", 1.0F, 1.0F);
            }
        }
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
        return new ItemStack(ModItems.marsh_reeds_grass);
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<>();

        Random rand = world.rand;

        if (rand.nextInt(8) == 0) {
            drops.add(new ItemStack(Items.wheat_seeds, getFortuneAmount(fortune, rand)));
        }

        if (rand.nextInt(8) == 0) {
            drops.add(new ItemStack(ModItems.salt_pinch, getFortuneAmount(fortune, rand)));
        }
        return drops;
    }

    private int getFortuneAmount(int fortune, Random rand) {
        switch (fortune) {
            case 3: return 1 + rand.nextInt(7); // 1–7
            case 2: return 1 + rand.nextInt(5); // 1–5
            case 1: return 1 + rand.nextInt(3); // 1–3
            default: return 1;
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


