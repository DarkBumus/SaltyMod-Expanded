package darkbum.saltmod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltmod.common.CommonProxy;
import darkbum.saltmod.init.ModBlocks;
import net.minecraft.block.BlockButton;
import net.minecraft.util.IIcon;

public class BlossomButton extends BlockButton {

    public BlossomButton() {
        super(true);
        setCreativeTab(CommonProxy.saltTab);
        setStepSound(soundTypeWood);
        setBlockName("blossom_button");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return ModBlocks.blossomPlanks.getBlockTextureFromSide(1);
    }
}
