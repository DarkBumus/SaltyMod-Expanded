package darkbum.saltymod.block;

import java.util.ArrayList;

import net.minecraft.block.BlockBush;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;

public class BlockSaltCrystal extends BlockBush {

    protected boolean silkdrop = false;

    @SideOnly(Side.CLIENT)
    private IIcon SMALL;

    @SideOnly(Side.CLIENT)
    private IIcon MEDIUM;

    public BlockSaltCrystal(String name, CreativeTabs tab) {
        setBlockName(name);
        setCreativeTab(tab);
        setBlockTextureName("saltymod:salt_crystal");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (meta < 0 || meta > 2) meta = 0;
        return (meta == 2) ? this.SMALL : ((meta == 1) ? this.MEDIUM : this.blockIcon);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);
        float g = 0.125F;
        float v = 0.375F;
        if (meta == 1) v = 0.625F;
        if (meta == 2) v = 0.875F;
        setBlockBounds(0.0F + g, 0.0F, 0.0F + g, 1.0F - g, 1.0F - v, 1.0F - g);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1) {
        this.blockIcon = par1.registerIcon(getTextureName() + "_2");
        this.MEDIUM = par1.registerIcon(getTextureName() + "_1");
        this.SMALL = par1.registerIcon(getTextureName() + "_0");
    }

    public boolean canBlockStay(World world, int x, int y, int z) {
        return World.doesBlockHaveSolidTopSurface(world, x, y - 1, z);
    }

    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
        int silk = EnchantmentHelper
            .getEnchantmentLevel(Enchantment.silkTouch.effectId, player.getCurrentEquippedItem());
        if (!world.isRemote) {
            if (player.getCurrentEquippedItem() != null && silk > 0) silkdrop = true;
            if (world.getBlockMetadata(x, y, z) == 0 && (world.getBlock(x, y - 1, z) == ModBlocks.salt_block
                || world.getBlock(x, y - 1, z) == ModBlocks.double_salt_slab))
                player.addStat(ModAchievementList.farm_salt, 1);
        }
    }

    @Override
    public ArrayList getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList drop = new ArrayList();
        if (metadata == 0) if (silkdrop) {
            drop.add(new ItemStack(ModItems.salt_shard));
        } else {
            drop.add(new ItemStack(ModItems.salt_pinch));
        }
        silkdrop = false;
        return drop;
    }

    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        if (world.isRemote) {
            return;
        }
        if ((entity instanceof EntitySlime && !EntityList.getEntityString(entity)
            .toLowerCase()
            .contains("lava")) || entity instanceof EntityWitch) {
            entity.attackEntityFrom(DamageSource.generic, 30.0F);
            entity.entityDropItem(new ItemStack(ModItems.salt_pinch, 1, 0), 0).delayBeforeCanPickup = 10;
            world.playSoundEffect(entity.posX, entity.posY, entity.posZ, "dig.stone", 2.0F, 1.0F);
            world.playSoundEffect(entity.posX, entity.posY, entity.posZ, "dig.glass", 2.0F, 2.0F);
            world.setBlock(x, y, z, Blocks.air, 0, 3);
            EntityPlayer player = world.getClosestPlayerToEntity(entity, 32D);
            if (player != null) {
                player.addStat(ModAchievementList.navelse_salt_crystal, 1);
            }
        }
    }

    public MapColor getMapColor(int meta) {
        return MapColor.airColor;
    }
}
