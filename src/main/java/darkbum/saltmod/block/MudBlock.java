package darkbum.saltmod.block;

import java.util.Random;

import darkbum.saltmod.init.ModItems;
import darkbum.saltmod.init.ModSounds;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class MudBlock extends BlockFalling {
    public MudBlock(String name, CreativeTabs tab) {
        super(Material.ground);
        setBlockName(name);
        setStepSound(ModSounds.soundTypeMud);
        setCreativeTab(tab);
        setHardness(0.5F);
        setResistance(0.5F);
        setHarvestLevel("shovel", 0);
        setBlockTextureName("saltmod:MudBlock");
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        float f = 0.125F;
        return AxisAlignedBB.getBoundingBox(x, y, z, (x + 1), ((y + 1) - f), (z + 1));
    }

    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        entity.motionX *= 1.0D;
        entity.motionZ *= 1.0D;
    }

    public Item getItemDropped(int meta, Random rand, int fortune) {
        return ModItems.mineralMud;
    }

    public int quantityDropped(Random rand) {
        return 4;
    }

    public MapColor getMapColor(int meta) {
        return MapColor.grayColor;
    }
}
