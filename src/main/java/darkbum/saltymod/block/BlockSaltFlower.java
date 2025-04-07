package darkbum.saltymod.block;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.common.CommonProxy;
import darkbum.saltymod.init.ModItems;

public class BlockSaltFlower extends BlockFlower {

    public static final String[] types = new String[] { "daucus", "wild_carrot", "solanum", "wild_potato", "wild_onion",
        "maritima", "wild_beet" };

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

    @SideOnly(Side.CLIENT)
    private IIcon MARITIMA;

    @SideOnly(Side.CLIENT)
    private IIcon WILD_BEET;

    public BlockSaltFlower() {
        super(1);
        setBlockName("salt_flower");
        setCreativeTab(CommonProxy.tabSalt);
        setStepSound(soundTypeGrass);
    }

    @Override
    public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) {
        for (int i = 0; i < types.length; ++i) {
            list.add(new ItemStack(block, 1, i));
        }
    }

    public IIcon getIcon(int side, int meta) {
        meta = MathHelper.clamp_int(meta, 0, 6);
        switch (meta) {
            case 1:
                return WILD_CARROT;
            case 2:
                return SOLANUM;
            case 3:
                return WILD_POTATO;
            case 4:
                return WILD_ONION;
            case 5:
                return MARITIMA;
            case 6:
                return WILD_BEET;
        }
        return DAUCUS;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        DAUCUS = icon.registerIcon("saltymod:flower_daucus");
        WILD_CARROT = icon.registerIcon("saltymod:flower_wild_carrot");
        SOLANUM = icon.registerIcon("saltymod:flower_solanum");
        WILD_POTATO = icon.registerIcon("saltymod:flower_wild_potato");
        WILD_ONION = icon.registerIcon("saltymod:flower_wild_onion");
        MARITIMA = icon.registerIcon("saltymod:flower_maritima");
        WILD_BEET = icon.registerIcon("saltymod:flower_wild_beet");
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
            case 5:
                drop.add(new ItemStack(this, 1, 5));
                break;
            case 6:
                drop.add(new ItemStack(this, 1, 5));
                if (Loader.isModLoaded("etfuturum")
                    && ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableBeetroot) {
                    Item beetroot = GameRegistry.findItem("etfuturum", "beetroot");
                    if (beetroot != null) {
                        drop.add(new ItemStack(beetroot));
                    }
                }
                break;
        }
        return drop;
    }
}
