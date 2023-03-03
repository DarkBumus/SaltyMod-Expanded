package darkbum.saltmod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltmod.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;

import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BlockOnion extends BlockCrops {
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public BlockOnion(String name, CreativeTabs tab) {
        setBlockName(name);
        setStepSound(soundTypeGrass);
        setCreativeTab(tab);
        setTickRandomly(true);
        setBlockTextureName("saltmod:onions");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (meta < 7) {
            if (meta == 6)
                meta = 5;
            return this.icons[meta >> 1];
        }
        return this.icons[3];
    }

    protected Item func_149866_i() {
        return ModItems.onion;
    }

    protected Item func_149865_P() {
        return ModItems.onion;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg) {
        this.icons = new IIcon[4];
        for (int i = 0; i < this.icons.length; i++)
            this.icons[i] = reg.registerIcon(getTextureName() + "_stage_" + i);
    }
}
