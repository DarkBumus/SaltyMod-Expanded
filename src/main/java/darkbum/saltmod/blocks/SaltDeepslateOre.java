package darkbum.saltmod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltmod.common.CommonProxy;
import darkbum.saltmod.common.SaltTab;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;

import ganymedes01.etfuturum.blocks.ores.BlockDeepslateOre;

public class SaltDeepslateOre extends BlockDeepslateOre {
    //@SideOnly(Side.CLIENT)
    //private IIcon SIDE;

    public SaltDeepslateOre(Block block) {
        super(block);
        setCreativeTab(CommonProxy.saltTab);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister par1) {
        blockIcon = par1.registerIcon("saltmod:deepslate_salt_ore");
        //SIDE = par1.registerIcon("saltmod:deepslate_salt_ore_side");
    }

}
