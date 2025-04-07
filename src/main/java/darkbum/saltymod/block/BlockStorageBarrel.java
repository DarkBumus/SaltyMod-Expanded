package darkbum.saltymod.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.configuration.configs.ModConfigurationItems;

public class BlockStorageBarrel extends Block {

    public static final String[] types = new String[] { "cod", "salmon", "clownfish", "tailor", "pufferfish" };

    @SideOnly(Side.CLIENT)
    private IIcon BOTTOM;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE;

    @SideOnly(Side.CLIENT)
    private IIcon COD;

    @SideOnly(Side.CLIENT)
    private IIcon SALMON;

    @SideOnly(Side.CLIENT)
    private IIcon CLOWNFISH;

    @SideOnly(Side.CLIENT)
    private IIcon TAILOR;

    @SideOnly(Side.CLIENT)
    private IIcon PUFFERFISH;

    public BlockStorageBarrel(String name, CreativeTabs tab) {
        super(Material.wood);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(2.5F);
        setResistance(2.5F);
        setStepSound(soundTypeWood);
    }

    @Override
    public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) {
        for (int i = 0; i < types.length; ++i) {
            if (i == 3 && !ModConfigurationItems.enableTailor) continue;
            list.add(new ItemStack(block, 1, i));
        }
    }

    public IIcon getIcon(int side, int meta) {

        meta = MathHelper.clamp_int(meta, 0, 5);

        if (side > 0) {
            if (meta == 0) {
                if (side == 1) return this.COD;
                return this.SIDE;
            }
            if (meta == 1) {
                if (side == 1) return this.SALMON;
                return this.SIDE;
            }
            if (meta == 2) {
                if (side == 1) return this.CLOWNFISH;
                return this.SIDE;
            }
            if (meta == 3) {
                if (side == 1) return this.TAILOR;
                return this.SIDE;
            }
            if (meta == 4) {
                if (side == 1) return this.PUFFERFISH;
                return this.SIDE;
            }
        }
        return this.BOTTOM;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        BOTTOM = icon.registerIcon("saltymod:storage_barrel_bottom");
        SIDE = icon.registerIcon("saltymod:storage_barrel");
        COD = icon.registerIcon("saltymod:storage_barrel_cod");
        SALMON = icon.registerIcon("saltymod:storage_barrel_salmon");
        CLOWNFISH = icon.registerIcon("saltymod:storage_barrel_clownfish");
        TAILOR = icon.registerIcon("saltymod:storage_barrel_tailor");
        PUFFERFISH = icon.registerIcon("saltymod:storage_barrel_pufferfish");
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }
}
