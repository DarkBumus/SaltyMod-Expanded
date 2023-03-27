package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

import java.util.List;

public class BlockStorageSack extends Block {
    public static final String[] types = new String[] {"wheatseeds", "melonseeds", "pumpkinseeds", "saltwort", "beetrootseeds"};

    @SideOnly(Side.CLIENT)
    private IIcon BOTTOM;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE;

    @SideOnly(Side.CLIENT)
    private IIcon WHEATSEEDS;

    @SideOnly(Side.CLIENT)
    private IIcon MELONSEEDS;

    @SideOnly(Side.CLIENT)
    private IIcon PUMPKINSEEDS;

    @SideOnly(Side.CLIENT)
    private IIcon SALTWORT;

    @SideOnly(Side.CLIENT)
    private IIcon BEETROOTSEEDS;


    public BlockStorageSack(String name, CreativeTabs tab) {
        super(Material.cloth);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(0.5F);
        setResistance(1.0F);
        setStepSound(soundTypeSnow);
    }

    @Override
    public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) {
        for (int i = 0; i < types.length; ++i) {
            list.add(new ItemStack(block, 1, i));
        }
    }

    public IIcon getIcon(int side, int meta) {

        meta = MathHelper.clamp_int(meta, 0, 4);

        if(side > 0) {
            if (meta == 0) {
                if (side == 1)
                    return this.WHEATSEEDS;
                return this.SIDE;
            }
            if (meta == 1) {
                if (side == 1)
                    return this.MELONSEEDS;
                return this.SIDE;
            }
            if (meta == 2) {
                if (side == 1)
                    return this.PUMPKINSEEDS;
                return this.SIDE;
            }
            if (meta == 3) {
                if (side == 1)
                    return this.SALTWORT;
                return this.SIDE;
            }
            if (meta == 4) {
                if (side == 1)
                    return this.BEETROOTSEEDS;
                return this.SIDE;
            }
        }
        return this.BOTTOM;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.BOTTOM = icon.registerIcon("saltymod:storage_sack_bottom");
        this.SIDE = icon.registerIcon("saltymod:storage_sack");
        this.WHEATSEEDS = icon.registerIcon("saltymod:storage_sack_wheat_seeds");
        this.MELONSEEDS = icon.registerIcon("saltymod:storage_sack_melon_seeds");
        this.PUMPKINSEEDS = icon.registerIcon("saltymod:storage_sack_pumpkin_seeds");
        this.SALTWORT = icon.registerIcon("saltymod:storage_sack_saltwort");
        this.BEETROOTSEEDS = icon.registerIcon("saltymod:storage_sack_beetroot_seeds");
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }
}
