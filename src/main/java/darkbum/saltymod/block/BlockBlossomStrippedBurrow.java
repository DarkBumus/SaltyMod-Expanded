package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.potion.ModPotion;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockBlossomStrippedBurrow extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon TOP;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE;

    @SideOnly(Side.CLIENT)
    private IIcon BURROW;

    public BlockBlossomStrippedBurrow(String name, CreativeTabs tab) {
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
        this.TOP = icon.registerIcon("saltymod:blossom_log_stripped_top");
        this.SIDE = icon.registerIcon("saltymod:blossom_log_stripped");
        this.BURROW = icon.registerIcon("saltymod:blossom_burrow_stripped");
    }

    public IIcon getIcon(int side, int meta) {
        if (side == 0)
            return this.TOP;
        if (side == 1)
            return this.TOP;
        if (side == 3)
            return this.BURROW;
        return this.SIDE;
    }

    protected boolean canSilkHarvest () {
        return false;
    }

    public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            player.addPotionEffect(new PotionEffect(ModPotion.swarmed.id, 900, 0, true));
            world.playSoundEffect(x, y, z, "saltymod:block.blossom_burrow.bees", 1.0F, 1.5F);
        }
    }
}
