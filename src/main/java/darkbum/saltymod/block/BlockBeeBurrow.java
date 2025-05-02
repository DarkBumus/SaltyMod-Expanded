package darkbum.saltymod.block;

import java.util.ArrayList;
import java.util.Random;

import cpw.mods.fml.common.Loader;
import darkbum.saltymod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.potion.ModPotion;

public class BlockBeeBurrow extends Block {

    public enum BeeBurrowType {
        SPRUCE, BIRCH
    }

    private final BlockBeeBurrow.BeeBurrowType type;

    @SideOnly(Side.CLIENT)
    private IIcon TOP;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE;

    @SideOnly(Side.CLIENT)
    private IIcon BURROW;

    public BlockBeeBurrow(String name, CreativeTabs tab, BeeBurrowType type) {
        super(Material.wood);
        this.type = type;
        setStepSound(soundTypeWood);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(1.5F);
        setResistance(2.0F);
        setHarvestLevel("axe", 0);
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<>();
        Random random = new Random();

        BlockBeeBurrow.BeeBurrowType actualType = (meta >= 4) ? BeeBurrowType.BIRCH : BeeBurrowType.SPRUCE;

        if (actualType == BeeBurrowType.SPRUCE) {
            drops.add(new ItemStack(ModItems.carpenter_bee));
            if (random.nextFloat() < 0.3f) {
                int count = random.nextInt(3);
                if (count > 0) drops.add(new ItemStack(ModItems.waxcomb, count));
            }
        } else {
            drops.add(new ItemStack(ModItems.regal_bee));
            if (random.nextFloat() < 0.3f) {
                int count = random.nextInt(3);
                if (count > 0) drops.add(new ItemStack(ModItems.honeycomb, count));
            }
        }

        return drops;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        if (type == BeeBurrowType.SPRUCE) {
            this.TOP = icon.registerIcon("saltymod:bee_burrow_spruce_top");
            this.SIDE = icon.registerIcon("log_spruce");
            this.BURROW = icon.registerIcon("saltymod:bee_burrow_spruce");
        } else {
            this.TOP = icon.registerIcon("saltymod:bee_burrow_birch_top");
            this.SIDE = icon.registerIcon("log_birch");
            this.BURROW = icon.registerIcon("saltymod:bee_burrow_birch");
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        switch (meta) {
            case 0:
            case 4:
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
            case 5:
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
            case 6:
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
            case 7:
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

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase placer, ItemStack itemIn) {
        int directionMeta = MathHelper.floor_double((double) (placer.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        int baseMeta = (type == BlockBeeBurrow.BeeBurrowType.BIRCH) ? 4 : 0;
        world.setBlockMetadataWithNotify(x, y, z, baseMeta + directionMeta, 2);
    }

    protected boolean canSilkHarvest() {
        return false;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        ItemStack heldItem = player.getCurrentEquippedItem();

        if (Loader.isModLoaded("etfuturum")) {
            if (heldItem != null && heldItem.getItem() instanceof ItemAxe) {
                if (!world.isRemote) {
                    int meta = world.getBlockMetadata(x, y, z);

                    BlockBeeBurrow.BeeBurrowType type = this.type;
                    Block replacement = null;
                    if (type == BlockBeeBurrow.BeeBurrowType.SPRUCE) {
                        replacement = ModBlocks.bee_burrow_spruce_stripped;
                    } else if (type == BlockBeeBurrow.BeeBurrowType.BIRCH) {
                        replacement = ModBlocks.bee_burrow_birch_stripped;
                    }
                    if (replacement != null) {
                        world.setBlock(x, y, z, replacement, meta, 3);
                        if (!player.capabilities.isCreativeMode) {
                            heldItem.damageItem(1, player);
                            PotionEffect effect = new PotionEffect(ModPotion.swarmed.id, 600, 0, true);
                            effect.getCurativeItems().clear();
                            player.addPotionEffect(effect);
                            world.playSoundEffect(x, y, z, "saltymod:block.bee_burrow.bees", 1.0F, 1.5F);
                            return true;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            PotionEffect effect = new PotionEffect(ModPotion.swarmed.id, 900, 0, true);
            effect.getCurativeItems().clear();
            player.addPotionEffect(effect);
            world.playSoundEffect(x, y, z, "saltymod:block.bee_burrow.bees", 1.0F, 1.5F);
        }
    }

    @Override
    public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
        return true;
    }
}
