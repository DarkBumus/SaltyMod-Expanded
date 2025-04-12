package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneLight;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockMill extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon BOTTOM;

    @SideOnly(Side.CLIENT)
    private IIcon TOP;

    @SideOnly(Side.CLIENT)
    private IIcon SIDESOFF;

    @SideOnly(Side.CLIENT)
    private IIcon SIDESON;

    @SideOnly(Side.CLIENT)
    private IIcon FRONT;

    @SideOnly(Side.CLIENT)
    private IIcon BACK;

    public BlockMill(String name, CreativeTabs tab) {
        super(Material.wood);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(2.5F);
        setResistance(2.5F);
        setStepSound(soundTypeWood);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.BOTTOM = icon.registerIcon("saltymod:mill_bottom");
        this.TOP = icon.registerIcon("saltymod:mill_top");
        this.SIDESOFF = icon.registerIcon("saltymod:mill_side_off");
        this.SIDESON = icon.registerIcon("saltymod:mill_side_on");
        this.FRONT = icon.registerIcon("saltymod:mill_front");
        this.BACK = icon.registerIcon("saltymod:mill_back");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        switch (meta) {
            case 0:
                switch (side) {
                    case 0:
                        return BOTTOM;
                    case 1:
                        return TOP;
                    case 2:
                        return BACK;
                    case 3:
                        return FRONT;
                    case 4:
                    case 5:
                        return SIDESOFF;
                }
            case 1:
                switch (side) {
                    case 0:
                        return BOTTOM;
                    case 1:
                        return TOP;
                    case 2:
                    case 3:
                        return SIDESOFF;
                    case 4:
                        return FRONT;
                    case 5:
                        return BACK;
                }
            case 2:
                switch (side) {
                    case 0:
                        return BOTTOM;
                    case 1:
                        return TOP;
                    case 2:
                        return FRONT;
                    case 3:
                        return BACK;
                    case 4:
                    case 5:
                        return SIDESOFF;
                }
            case 3:
                switch (side) {
                    case 0:
                        return BOTTOM;
                    case 1:
                        return TOP;
                    case 2:
                    case 3:
                        return SIDESOFF;
                    case 4:
                        return BACK;
                    case 5:
                        return FRONT;
                }
            case 4:
                switch (side) {
                    case 0:
                        return BOTTOM;
                    case 1:
                        return TOP;
                    case 2:
                        return BACK;
                    case 3:
                        return FRONT;
                    case 4:
                    case 5:
                        return SIDESON;
                }
            case 5:
                switch (side) {
                    case 0:
                        return BOTTOM;
                    case 1:
                        return TOP;
                    case 2:
                    case 3:
                        return SIDESON;
                    case 4:
                        return FRONT;
                    case 5:
                        return BACK;
                }
            case 6:
                switch (side) {
                    case 0:
                        return BOTTOM;
                    case 1:
                        return TOP;
                    case 2:
                        return FRONT;
                    case 3:
                        return BACK;
                    case 4:
                    case 5:
                        return SIDESON;
                }
            case 7:
                switch (side) {
                    case 0:
                        return BOTTOM;
                    case 1:
                        return TOP;
                    case 2:
                    case 3:
                        return SIDESON;
                    case 4:
                        return BACK;
                    case 5:
                        return FRONT;
                }
        }
        return null;
    }

    public void onBlockPlacedBy(World worldIn, int x, int y, int z, EntityLivingBase placer, ItemStack itemIn) {
        int l = MathHelper.floor_double((double) (placer.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        worldIn.setBlockMetadataWithNotify(x, y, z, l, 2);
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor) {
        super.onNeighborBlockChange(world, x, y, z, neighbor);

        boolean isPowered = world.isBlockIndirectlyGettingPowered(x, y, z);

        int meta = world.getBlockMetadata(x, y, z);

        if (isPowered) {
            switch (meta) {
                case 0:
                    world.setBlockMetadataWithNotify(x, y, z, 4, 3);
                    break;
                case 1:
                    world.setBlockMetadataWithNotify(x, y, z, 5, 3);
                    break;
                case 2:
                    world.setBlockMetadataWithNotify(x, y, z, 6, 3);
                    break;
                case 3:
                    world.setBlockMetadataWithNotify(x, y, z, 7, 3);
                    break;
            }
        } else {
            switch (meta) {
                case 4:
                    world.setBlockMetadataWithNotify(x, y, z, 0, 3);
                    break;
                case 5:
                    world.setBlockMetadataWithNotify(x, y, z, 1, 3);
                    break;
                case 6:
                    world.setBlockMetadataWithNotify(x, y, z, 2, 3);
                    break;
                case 7:
                    world.setBlockMetadataWithNotify(x, y, z, 3, 3);
                    break;
            }
        }
    }
}
