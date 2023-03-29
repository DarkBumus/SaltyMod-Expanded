package darkbum.saltymod.block;

import java.util.Random;

import cpw.mods.fml.common.Loader;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.potion.ModPotion;
import darkbum.saltymod.tileentity.TileEntityExtractor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockBlossomBurrow extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon TOP;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE;

    @SideOnly(Side.CLIENT)
    private IIcon BURROW;

    public BlockBlossomBurrow(String name, CreativeTabs tab) {
        super(Material.wood);
        setStepSound(soundTypeWood);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(1.5F);
        setResistance(2.0F);
        setHarvestLevel("axe", 0);
    }

    public Item getItemDropped(int meta, Random random, int fortune) {
        return ModItems.carpenter_bee;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.TOP = icon.registerIcon("saltymod:blossom_log_top");
        this.SIDE = icon.registerIcon("saltymod:blossom_log");
        this.BURROW = icon.registerIcon("saltymod:blossom_burrow");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return (side == 1) ? this.TOP : ((side == 0) ? this.TOP : ((side != meta) ? this.SIDE : this.BURROW));
    }

/*    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
        direction(world, x, y, z);
    }

    private void direction(World world, int x, int y, int z) {
        if (!world.isRemote) {
            Block block = world.getBlock(x, y, z - 1);
            Block block1 = world.getBlock(x, y, z + 1);
            Block block2 = world.getBlock(x - 1, y, z);
            Block block3 = world.getBlock(x + 1, y, z);
            byte b0 = 3;
            if (block.func_149730_j() && !block1.func_149730_j())
                b0 = 3;
            if (block1.func_149730_j() && !block.func_149730_j())
                b0 = 2;
            if (block2.func_149730_j() && !block3.func_149730_j())
                b0 = 5;
            if (block3.func_149730_j() && !block2.func_149730_j())
                b0 = 4;
            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
        }
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
        int l = MathHelper.floor_double((entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 0x3;
        if (l == 0)
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        if (l == 1)
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        if (l == 2)
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        if (l == 3)
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        if (itemStack.hasDisplayName())
            ((TileEntityExtractor)world.getTileEntity(x, y, z)).func_145951_a(itemStack.getDisplayName());
    }*/

    protected boolean canSilkHarvest () {
        return false;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitx, float hity, float hitz) {
        if (Loader.isModLoaded("etfuturum")) {
            ItemStack heldStack = player.getCurrentEquippedItem();
            if (heldStack != null && heldStack.getItem() instanceof ItemAxe) {
                world.setBlock(x, y, z, ModBlocks.blossom_stripped_burrow);
                player.addPotionEffect(new PotionEffect(ModPotion.bees.id, 600, 0));
                world.playSoundEffect(x, y, z, "saltymod:block.blossom_burrow.bees", 1.0F, 1.5F);
            }
        }
        return false;
    }

    public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
        if(!player.capabilities.isCreativeMode) {
            player.addPotionEffect(new PotionEffect(ModPotion.bees.id, 900, 0));
            world.playSoundEffect(x, y, z, "saltymod:block.blossom_burrow.bees", 1.0F, 1.5F);
        }
    }
}
