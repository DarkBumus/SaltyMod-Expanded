package darkbum.saltymod.blocks;

import java.util.Random;

import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.init.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockMineralMud extends Block {
    public BlockMineralMud(String name, CreativeTabs tab) {
        super(Material.ground);
        setBlockName(name);
        setStepSound(ModSounds.soundTypeMud);
        setCreativeTab(tab);
        setHardness(0.5F);
        setResistance(0.5F);
        setHarvestLevel("shovel", 0);
        setBlockTextureName("saltmod:mud");
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        float f = 0.125F;
        return AxisAlignedBB.getBoundingBox(x, y, z, (x + 1), ((y + 1) - f), (z + 1));
    }

    public Item getItemDropped(int meta, Random rand, int fortune) {
        return ModItems.mineral_mud_ball;
    }

    public int quantityDropped(Random rand) {
        return 4;
    }

    public MapColor getMapColor(int meta) {
        return MapColor.grayColor;
    }
}
