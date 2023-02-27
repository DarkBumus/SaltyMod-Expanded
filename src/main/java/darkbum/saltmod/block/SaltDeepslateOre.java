package darkbum.saltmod.block;

import java.util.Random;

import darkbum.saltmod.init.ModItems;
import darkbum.saltmod.init.ModSounds;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class SaltDeepslateOre extends Block {
    @SideOnly(Side.CLIENT)
    private IIcon SIDE;

    public SaltDeepslateOre(String name, CreativeTabs tab) {
        super(Material.rock);
        setStepSound(ModSounds.soundTypeDeepslate);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(4.5F);
        setResistance(3.0F);
        setHarvestLevel("pickaxe", 1);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1) {
        this.blockIcon = par1.registerIcon("saltmod:SaltDeepslateOre");
        this.SIDE = par1.registerIcon("saltmod:SaltDeepslateOre_Side");
    }

    public Item getItemDropped(int par1, Random random, int par2) {
        return ModItems.salt;
    }

    public int quantityDropped(Random random) {
        return 1 + random.nextInt(3);
    }

    public int quantityDroppedWithBonus(int fortune, Random random) {
        if (fortune > 0) {
            int j = random.nextInt(fortune + 1);
            if (j > 2)
                return 2;
            return quantityDropped(random) + j;
        }
        return quantityDropped(random);
    }

    public int getExpDrop(IBlockAccess par1, int par2, int par3) {
        return 1;
    }
}
