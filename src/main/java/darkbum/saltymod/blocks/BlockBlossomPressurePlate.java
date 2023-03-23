package darkbum.saltymod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModBlocks;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class BlockBlossomPressurePlate extends BlockPressurePlate {

    private final int meta;

    public BlockBlossomPressurePlate(int meta, CreativeTabs tab) {
        super("saltmod:blossom_planks", Material.wood, Sensitivity.everything);
        this.meta = meta;
        this.disableStats();
        this.setHardness(0.5F);
        this.setStepSound(soundTypeWood);
        this.setBlockName("blossom_pressure_plate");
        this.setCreativeTab(tab);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int _meta) {
        return ModBlocks.blossom_planks.getIcon(side, this.meta);
    }
}
