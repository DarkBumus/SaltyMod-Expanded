package darkbum.saltmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class StorageSack extends Block {
    public static final String[] types = new String[] {"Wheatseeds", "Melonseeds", "Pumpkinseeds", "Saltwort", "Beetrootseeds"};

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


    public StorageSack(String name, CreativeTabs tab) {
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
        if (meta < 0 || meta > 4)
            meta = 0;

        if (meta == 0) {
            if (side == 0)
                return this.BOTTOM;
            if (side == 1)
                return this.WHEATSEEDS;
            return this.SIDE;
        }
        if (meta == 1) {
            if (side == 0)
                return this.BOTTOM;
            if (side == 1)
                return this.MELONSEEDS;
            return this.SIDE;
        }
        if (meta == 2) {
            if (side == 0)
                return this.BOTTOM;
            if (side == 1)
                return this.PUMPKINSEEDS;
            return this.SIDE;
        }
        if (meta == 3) {
            if (side == 0)
                return this.BOTTOM;
            if (side == 1)
                return this.SALTWORT;
            return this.SIDE;
        }
        if (meta == 4) {
            if (side == 0)
                return this.BOTTOM;
            if (side == 1)
                return this.BEETROOTSEEDS;
            return this.SIDE;
        }
        return null; // ???
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.BOTTOM = icon.registerIcon("saltmod:StorageSack_Bottom");
        this.SIDE = icon.registerIcon("saltmod:StorageSack_Side");
        this.WHEATSEEDS = icon.registerIcon("saltmod:StorageSack_Wheatseeds");
        this.MELONSEEDS = icon.registerIcon("saltmod:StorageSack_Melonseeds");
        this.PUMPKINSEEDS = icon.registerIcon("saltmod:StorageSack_Pumpkinseeds");
        this.SALTWORT = icon.registerIcon("saltmod:StorageSack_Saltwort");
        this.BEETROOTSEEDS = icon.registerIcon("saltmod:StorageSack_Beetrootseeds");
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }
}
