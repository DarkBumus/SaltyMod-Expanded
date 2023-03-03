package darkbum.saltmod.blocks;

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

public class StorageBarrel extends Block {
    public static final String[] types = new String[] {"cod", "salmon", "clownfish", "pufferfish"};

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
    private IIcon PUFFERFISH;


    public StorageBarrel(String name, CreativeTabs tab) {
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
            list.add(new ItemStack(block, 1, i));
        }
    }

    public IIcon getIcon(int side, int meta) {
        if (meta < 0 || meta > 3)
            meta = 0;

        if (meta == 0) {
            if (side == 0)
                return this.BOTTOM;
            if (side == 1)
                return this.COD;
            return this.SIDE;
        }
        if (meta == 1) {
            if (side == 0)
                return this.BOTTOM;
            if (side == 1)
                return this.SALMON;
            return this.SIDE;
        }
        if (meta == 2) {
            if (side == 0)
                return this.BOTTOM;
            if (side == 1)
                return this.CLOWNFISH;
            return this.SIDE;
        }
        if (meta == 3) {
            if (side == 0)
                return this.BOTTOM;
            if (side == 1)
                return this.PUFFERFISH;
            return this.SIDE;
        }
        return null;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.BOTTOM = icon.registerIcon("saltmod:storage_barrel_bottom");
        this.SIDE = icon.registerIcon("saltmod:storage_barrel");
        this.COD = icon.registerIcon("saltmod:storage_barrel_cod");
        this.SALMON = icon.registerIcon("saltmod:storage_barrel_salmon");
        this.CLOWNFISH = icon.registerIcon("saltmod:storage_barrel_clownfish");
        this.PUFFERFISH = icon.registerIcon("saltmod:storage_barrel_pufferfish");
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }
}
