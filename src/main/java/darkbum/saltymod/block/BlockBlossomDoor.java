/*package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.World;

import java.util.Random;

public class BlockBlossomDoor extends BlockDoor {

    public BlockBlossomDoor(String name, CreativeTabs tab) {
        super(Material.wood);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(3.0F);
        setResistance(3.0F);
        setStepSound(soundTypeWood);
        setBlockTextureName("saltymod:blossom_door");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z) {
        return Item.getItemFromBlock(this);
    }

    @Override
    public Item getItemDropped(int meta, Random rand, int fortune) {
        return Item.getItemFromBlock(this);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getItemIconName() {
        return getTextureName();
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return 7;
    }


}
*/
