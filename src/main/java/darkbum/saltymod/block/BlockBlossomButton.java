package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.common.CommonProxy;
import darkbum.saltymod.init.ModBlocks;
import net.minecraft.block.BlockButton;
import net.minecraft.util.IIcon;

public class BlockBlossomButton extends BlockButton {

    public BlockBlossomButton() {
        super(true);
        setCreativeTab(CommonProxy.tabSalt);
        setStepSound(soundTypeWood);
        setBlockName("blossom_button");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return ModBlocks.blossom_planks.getBlockTextureFromSide(1);
    }
}
