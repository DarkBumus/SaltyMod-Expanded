package darkbum.saltymod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.common.CommonProxy;
import darkbum.saltymod.init.ModItems;
import ganymedes01.etfuturum.blocks.BlockFlowerBase;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class BlockSaltFlower extends BlockFlowerBase {

    public static final String[] types = new String[] {"daucus", "wild_carrot", "solanum", "wild_potato", "wild_onion"};

    @SideOnly(Side.CLIENT)
    private IIcon DAUCUS;

    @SideOnly(Side.CLIENT)
    private IIcon WILD_CARROT;

    @SideOnly(Side.CLIENT)
    private IIcon SOLANUM;

    @SideOnly(Side.CLIENT)
    private IIcon WILD_POTATO;

    @SideOnly(Side.CLIENT)
    private IIcon WILD_ONION;


    public BlockSaltFlower() {
        super();
        setBlockName("salt_flower");
        setCreativeTab(CommonProxy.tabSalt);
    }

    @Override
    public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) {
        for (int i = 0; i < types.length; ++i) {
            list.add(new ItemStack(block, 1, i));
        }
    }

    public IIcon getIcon(int side, int meta) {

        meta = MathHelper.clamp_int(meta, 0, 4);

        if(meta == 1) {
            return this.WILD_CARROT;
        }
        if(meta == 2) {
            return this.SOLANUM;
        }
        if(meta == 3) {
            return this.WILD_POTATO;
        }
        if(meta == 4) {
            return this.WILD_ONION;
        }
        return this.DAUCUS;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.DAUCUS = icon.registerIcon("saltymod:flower_daucus");
        this.WILD_CARROT = icon.registerIcon("saltymod:flower_wild_carrot");
        this.SOLANUM = icon.registerIcon("saltymod:flower_solanum");
        this.WILD_POTATO = icon.registerIcon("saltymod:flower_wild_potato");
        this.WILD_ONION = icon.registerIcon("saltymod:flower_wild_onion");
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }

    @Override
    public ArrayList getDrops(World world, int x, int y, int z, int meta, int fortune) {
        ArrayList drop = new ArrayList();
        switch (meta) {
            case 0:
                drop.add(new ItemStack(this, 1, 0));
                break;
            case 1:
                drop.add(new ItemStack(this, 1, 0));
                drop.add(new ItemStack(Items.carrot));
                break;
            case 2:
                drop.add(new ItemStack(this, 1, 2));
                break;
            case 3:
                drop.add(new ItemStack(this, 1, 2));
                drop.add(new ItemStack(Items.potato));
                break;
            case 4:
                drop.add(new ItemStack(Blocks.red_flower, 1, 2));
                drop.add(new ItemStack(ModItems.onion));
                break;
        }
        return drop;
    }
}
