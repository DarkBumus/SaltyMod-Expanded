package darkbum.saltmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;

import ganymedes01.etfuturum.blocks.ores.BlockDeepslateOre;

public class SaltDeepslateOre extends BlockDeepslateOre {
    //@SideOnly(Side.CLIENT)
    //private IIcon SIDE;

    public SaltDeepslateOre(Block block) {
        super(block);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister par1) {
        blockIcon = par1.registerIcon("saltmod:SaltDeepslateOre");
        //SIDE = par1.registerIcon("saltmod:SaltDeepslateOre_Side");
    }

}
