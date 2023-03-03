package darkbum.saltmod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltmod.init.ModBlocks;
import ganymedes01.etfuturum.EtFuturum;
import ganymedes01.etfuturum.blocks.BlockWoodDoor;
import ganymedes01.etfuturum.blocks.BlockWoodPressurePlate;
import ganymedes01.etfuturum.blocks.IConfigurable;
import ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems;
import ganymedes01.etfuturum.core.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;

public class BlossomPressurePlate extends BlockPressurePlate implements IConfigurable {

    private final int meta;

    public BlossomPressurePlate(int meta, CreativeTabs tab) {
        super("saltmod:blossom_planks", Material.wood, Sensitivity.everything);
        this.meta = meta;
        this.disableStats();
        this.setHardness(0.5F);
        this.setStepSound(soundTypeWood);
        this.setBlockName("blossomPressurePlate");
        this.setCreativeTab(tab);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int _meta) {
        return ModBlocks.blossomPlanks.getIcon(side, this.meta);
    }

    @Override
    public boolean isEnabled() {
        return ConfigBlocksItems.enableWoodRedstone;
    }
}
