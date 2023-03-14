/*package darkbum.saltmod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltmod.common.CommonProxy;
import darkbum.saltmod.init.ModBlocks;
import darkbum.saltmod.init.ModItems;
import net.minecraft.block.BlockSign;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlossomSign extends BlockSign {

    public final boolean standing;

    public BlossomSign(Class p_i45426_1_, boolean p_i45426_2_) {
        super(p_i45426_1_, p_i45426_2_);
        setHardness(1.0F);
        setResistance(1.0F);
        setBlockName("blossomSign");
        disableStats();
        setStepSound(soundTypeWood);
        setCreativeTab(CommonProxy.saltTab);
        this.standing = p_i45426_2_;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int _meta) {
        return ModBlocks.blossomPlanks.getIcon(side, 0);
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return ModItems.itemBlossomSign;
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
        return ModItems.itemBlossomSign;
    }
}*/
