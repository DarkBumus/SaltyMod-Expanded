package darkbum.saltymod.block;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
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

public class BlockBeeNest extends Block {

    public enum BeeNestType {
        TEMPERATE, BOREAL
    }

    private final BeeNestType type;

    @SideOnly(Side.CLIENT)
    private IIcon TOP;

    @SideOnly(Side.CLIENT)
    private IIcon BOTTOM;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE;

    @SideOnly(Side.CLIENT)
    private IIcon BURROW;

    public BlockBeeNest(String name, CreativeTabs tab, BeeNestType type) {
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

        BeeNestType actualType = (meta >= 4) ? BeeNestType.BOREAL : BeeNestType.TEMPERATE;

        if (actualType == BeeNestType.TEMPERATE) {
            drops.add(new ItemStack(ModItems.honey_bee));
            if (random.nextFloat() < 0.3f) {
                int count = random.nextInt(3);
                if (count > 0) drops.add(new ItemStack(ModItems.honeycomb, count));
            }
        } else {
            drops.add(new ItemStack(ModItems.boreal_bee));
            if (random.nextFloat() < 0.3f) {
                int count = random.nextInt(3);
                if (count > 0) drops.add(new ItemStack(ModItems.frozen_honey, count));
            }
        }

        if (random.nextFloat() < 0.1f) {
            int waxcombCount = random.nextInt(3);
            if (waxcombCount > 0) {
                drops.add(new ItemStack(ModItems.waxcomb, waxcombCount));
            }
        }

        return drops;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        String prefix = "saltymod:";

        if (type == BeeNestType.TEMPERATE) {
            TOP = icon.registerIcon("saltymod:bee_nest_temperate_top");
            BOTTOM = icon.registerIcon("saltymod:bee_nest_temperate_bottom");
            SIDE = icon.registerIcon("saltymod:bee_nest_temperate_side");
            BURROW = icon.registerIcon("saltymod:bee_nest_temperate_burrow");
        } else {
            TOP = icon.registerIcon("saltymod:bee_nest_boreal_top");
            BOTTOM = icon.registerIcon("saltymod:bee_nest_boreal_bottom");
            SIDE = icon.registerIcon("saltymod:bee_nest_boreal_side");
            BURROW = icon.registerIcon("saltymod:bee_nest_boreal_burrow");
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        int rotationMeta = meta % 4;
        switch (rotationMeta) {
            case 0:
                switch (side) {
                    case 0: return BOTTOM;
                    case 1: return TOP;
                    case 2: case 4: case 5: return SIDE;
                    case 3: return BURROW;
                }
            case 1:
                switch (side) {
                    case 0: return BOTTOM;
                    case 1: return TOP;
                    case 2: case 5: case 3: return SIDE;
                    case 4: return BURROW;
                }
            case 2:
                switch (side) {
                    case 0: return BOTTOM;
                    case 1: return TOP;
                    case 2: return BURROW;
                    case 3: case 4: case 5: return SIDE;
                }
            case 3:
                switch (side) {
                    case 0: return BOTTOM;
                    case 1: return TOP;
                    case 2: case 3: case 4: return SIDE;
                    case 5: return BURROW;
                }
        }
        return SIDE;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase placer, ItemStack itemIn) {
        int directionMeta = MathHelper.floor_double((double) (placer.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        int baseMeta = (type == BeeNestType.BOREAL) ? 4 : 0;
        world.setBlockMetadataWithNotify(x, y, z, baseMeta + directionMeta, 2);
    }

    @Override
    protected boolean canSilkHarvest() {
        return false;
    }

    @Override
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
