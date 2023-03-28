package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.common.CommonProxy;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;
import net.minecraft.block.BlockSign;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockBlossomSign extends BlockSign {

    public final boolean standing;

    public BlockBlossomSign(Class tileEntity, boolean stand) {
        super(tileEntity, stand);
        setHardness(1.0F);
        setResistance(1.0F);
        setBlockName("blossom_sign");
        setStepSound(soundTypeWood);
        setCreativeTab(null);
        standing = stand;
    }

    public void registerBlockIcons(IIconRegister icon) {
        blockIcon = icon.registerIcon("saltymod:blossom_planks");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int meta, int side) {
        return blockIcon;
    }

    @Override
    public Item getItemDropped(int meta, Random rand, int fortune) {
        return ModItems.item_blossom_sign;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z) {
        return ModItems.item_blossom_sign;
    }
}
