package darkbum.saltmod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltmod.common.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class SaltDeepslateOre extends Block {
    //@SideOnly(Side.CLIENT)
    //private IIcon SIDE;

    public SaltDeepslateOre(Block block) {
        super(Material.rock);
        setBlockName("saltDeepslateOre");
        setStepSound(ganymedes01.etfuturum.client.sound.ModSounds.soundDeepslate);
        setCreativeTab(CommonProxy.saltTab);
        setHardness(4.5F);
        setResistance(3.0F);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister par1) {
        blockIcon = par1.registerIcon("saltmod:deepslate_salt_ore");
        //SIDE = par1.registerIcon("saltmod:deepslate_salt_ore_side");
    }
}
