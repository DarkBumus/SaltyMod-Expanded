package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.potion.ModPotion;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class BlockBeeBurrowBirchStripped extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon TOP;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE;

    @SideOnly(Side.CLIENT)
    private IIcon BURROW;

    public BlockBeeBurrowBirchStripped(String name, CreativeTabs tab) {
        super(Material.wood);
        setStepSound(soundTypeWood);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(1.5F);
        setResistance(2.0F);
        setHarvestLevel("axe", 0);
    }

    public Item getItemDropped(int meta, Random random, int fortune) {
        return ModItems.regal_bee;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.TOP = icon.registerIcon("saltymod:bee_burrow_birch_stripped_top");
        this.SIDE = icon.registerIcon("saltymod:bee_burrow_birch_stripped_side");
        this.BURROW = icon.registerIcon("saltymod:bee_burrow_birch_stripped");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        switch (meta) {
            case 0:
                switch (side) {
                    case 0:
                    case 1:
                        return TOP;
                    case 2:
                    case 4:
                    case 5:
                        return SIDE;
                    case 3:
                        return BURROW;
                }
            case 1:
                switch (side) {
                    case 0:
                    case 1:
                        return TOP;
                    case 2:
                    case 5:
                    case 3:
                        return SIDE;
                    case 4:
                        return BURROW;
                }
            case 2:
                switch (side) {
                    case 0:
                    case 1:
                        return TOP;
                    case 2:
                        return BURROW;
                    case 4:
                    case 5:
                    case 3:
                        return SIDE;
                }
            case 3:
                switch (side) {
                    case 0:
                    case 1:
                        return TOP;
                    case 2:
                    case 3:
                    case 4:
                        return SIDE;
                    case 5:
                        return BURROW;
                }
        }
        return null;
    }

    public void onBlockPlacedBy(World worldIn, int x, int y, int z, EntityLivingBase placer, ItemStack itemIn) {
        int l = MathHelper.floor_double((double)(placer.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        worldIn.setBlockMetadataWithNotify(x, y, z, l, 2);
    }

    protected boolean canSilkHarvest () {
        return false;
    }

    public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            player.addPotionEffect(new PotionEffect(ModPotion.swarmed.id, 900, 0, true));
            world.playSoundEffect(x, y, z, "saltymod:block.bee_burrow.bees", 1.0F, 1.5F);
        }
    }
}
