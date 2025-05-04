package darkbum.saltymod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.common.proxy.CommonProxy;

public class BlockSaltDeepslateOre extends Block {

    // @SideOnly(Side.CLIENT)
    // private IIcon SIDE;

    public BlockSaltDeepslateOre(Block block) {
        super(Material.rock);
        setBlockName("deepslate_salt_ore");
        setStepSound(ganymedes01.etfuturum.client.sound.ModSounds.soundDeepslate);
        setCreativeTab(CommonProxy.tabSaltBlocks);
        setHardness(4.5F);
        setResistance(3.0F);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister par1) {
        blockIcon = par1.registerIcon("saltymod:deepslate_salt_ore");
        // SIDE = par1.registerIcon("saltmod:deepslate_salt_ore_side");
    }
}
