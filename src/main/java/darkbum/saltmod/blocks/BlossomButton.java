package darkbum.saltmod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltmod.common.CommonProxy;
import darkbum.saltmod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockButtonWood;
import net.minecraft.command.ICommand;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;

public class BlossomButton extends BlockButton {
    private static final String __OBFID = "CL_00000336";

    public BlossomButton() {
        super(true);
        setCreativeTab(CommonProxy.saltTab);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return ModBlocks.blossomPlanks.getBlockTextureFromSide(1);
    }
}
