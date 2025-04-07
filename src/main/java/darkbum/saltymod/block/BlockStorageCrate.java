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

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.configuration.configs.ModConfigurationItems;

public class BlockStorageCrate extends Block {

    public static final String[] types = new String[] { "carrot", "potato", "poisonous_potato", "onion", "beetroot" };

    @SideOnly(Side.CLIENT)
    private IIcon BOTTOM;

    @SideOnly(Side.CLIENT)
    private IIcon CARROTSIDE;

    @SideOnly(Side.CLIENT)
    private IIcon CARROTTOP;

    @SideOnly(Side.CLIENT)
    private IIcon POTATOSIDE;

    @SideOnly(Side.CLIENT)
    private IIcon POTATOTOP;

    @SideOnly(Side.CLIENT)
    private IIcon POIPOTATOSIDE;

    @SideOnly(Side.CLIENT)
    private IIcon POIPOTATOTOP;

    @SideOnly(Side.CLIENT)
    private IIcon ONIONSIDE;

    @SideOnly(Side.CLIENT)
    private IIcon ONIONTOP;

    @SideOnly(Side.CLIENT)
    private IIcon BEETROOTSIDE;

    @SideOnly(Side.CLIENT)
    private IIcon BEETROOTTOP;

    public BlockStorageCrate(String name, CreativeTabs tab) {
        super(Material.wood);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(2.5F);
        setResistance(2.5F);
        setStepSound(soundTypeWood);
    }

    /*
     * @Override
     * public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) {
     * for (int i = 0; i < types.length; ++i) {
     * list.add(new ItemStack(block, 1, i));
     * }
     * }
     */

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        for (int i = 0; i < 5; ++i) {
            if (i == 3 && !ModConfigurationItems.enableOnion) continue;
            if (i == 4 && !Loader.isModLoaded("etfuturum")) continue;
            list.add(new ItemStack(item, 1, i));
        }
    }

    public IIcon getIcon(int side, int meta) {

        meta = MathHelper.clamp_int(meta, 0, 4);

        if (side > 0) {
            if (meta == 0) {
                if (side == 1) return this.CARROTTOP;
                return this.CARROTSIDE;
            }
            if (meta == 1) {
                if (side == 1) return this.POTATOTOP;
                return this.POTATOSIDE;
            }
            if (meta == 2) {
                if (side == 1) return this.POIPOTATOTOP;
                return this.POIPOTATOSIDE;
            }
            if (meta == 3) {
                if (side == 1) return this.ONIONTOP;
                return this.ONIONSIDE;
            }
            if (meta == 4) {
                if (side == 1) return this.BEETROOTTOP;
                return this.BEETROOTSIDE;
            }
        }
        return this.BOTTOM;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.BOTTOM = icon.registerIcon("saltymod:storage_crate_bottom");
        this.CARROTSIDE = icon.registerIcon("saltymod:storage_crate_carrot_side");
        this.CARROTTOP = icon.registerIcon("saltymod:storage_crate_carrot_top");
        this.POTATOSIDE = icon.registerIcon("saltymod:storage_crate_potato_side");
        this.POTATOTOP = icon.registerIcon("saltymod:storage_crate_potato_top");
        this.POIPOTATOSIDE = icon.registerIcon("saltymod:storage_crate_poisonous_potato_side");
        this.POIPOTATOTOP = icon.registerIcon("saltymod:storage_crate_poisonous_potato_top");
        this.ONIONSIDE = icon.registerIcon("saltymod:storage_crate_onion_side");
        this.ONIONTOP = icon.registerIcon("saltymod:storage_crate_onion_top");
        this.BEETROOTSIDE = icon.registerIcon("saltymod:storage_crate_beetroot_side");
        this.BEETROOTTOP = icon.registerIcon("saltymod:storage_crate_beetroot_top");
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }
}
