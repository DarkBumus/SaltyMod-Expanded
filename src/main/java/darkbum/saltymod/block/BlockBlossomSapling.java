/*package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.util.ForgeDirection;
import darkbum.saltymod.world.WorldGenBlossomBigTree;

import java.util.List;
import java.util.Random;

public class BlockBlossomSapling extends BlockSapling {

    @SideOnly(Side.CLIENT)
    private IIcon MAIN;

    public BlockBlossomSapling(String name, CreativeTabs tab) {
        setHardness(0.0F);
        setBlockName(name);
        setCreativeTab(tab);
        setStepSound(soundTypeGrass);
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return this.MAIN;
    }

    public void registerBlockIcons(IIconRegister icon) {
        this.MAIN = icon.registerIcon("saltymod:blossom_sapling");
    }

    public boolean isValidPosition(World world, int x, int y, int z, int validblock) {
        Block block = world.getBlock(x, y - 1, z);
        return (block == Blocks.grass || block == Blocks.dirt || block == Blocks.farmland || block.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this));
    }

    public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side) {
        return isValidPosition(world, x, y, z, -1);
    }

    public boolean canBlockStay(World world, int x, int y, int z) {
        Block soil = world.getBlock(x, y - 1, z);
        if (world.getBlockMetadata(x, y, z) != 1)
            return ((world.getFullBlockLightValue(x, y, z) >= 8 || world.canBlockSeeTheSky(x, y, z)) && soil != null && soil.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this));
        return ((world.getFullBlockLightValue(x, y, z) >= 8 || world.canBlockSeeTheSky(x, y, z)) && soil != null && soil.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this));
    }

    public void updateTick(World world, int x, int y, int z, Random random) {
        if (!world.isRemote)
            if (world.getBlockLightValue(x, y + 1, z) >= 9 && random.nextInt(7) == 0)
                func_149878_d(world, x, y, z, random);
    }

    public void func_149878_d(World world, int x, int y, int z, Random random) {
        int meta = world.getBlockMetadata(x, y, z) & 0xF;
        Object obj = null;
        int rnd = random.nextInt(8);
        if (obj == null)
            obj = new WorldGenBlossomBigTree(true, false);
        if (obj != null) {
            world.setBlockToAir(x, y, z);
            if (!((WorldGenerator)obj).generate(world, random, x, y, z))
                world.setBlock(x, y, z, this, meta, 2);
        }
    }

    @Override
    public void getSubBlocks(Item block, CreativeTabs tab, List list) {
        list.add(new ItemStack(block, 1, 0));
    }

    public int damageDropped(int meta) {
        return 0;
    }

    public int getDamageValue(World world, int x, int y, int z) {
        return 0;
    }
}
*/
