package darkbum.saltymod.block;

import java.util.Random;

import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModSounds;
import darkbum.saltymod.potion.ModPotion;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
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

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitx, float hity, float hitz) {
        ItemStack heldStack = player.getCurrentEquippedItem();
        if(heldStack != null && heldStack.getItem() instanceof ItemAxe) {
            world.setBlock(x, y, z, ModBlocks.blossom_stripped_burrow);
            player.addPotionEffect(new PotionEffect(Potion.wither.id, 500,4));
//            player.addPotionEffect(new PotionEffect(ModPotion.bees.id, 500, 4)); DOESN'T WORK YET
//            world.playSoundEffect(x, y, z, "saltymod:block.blossom_burrow.bees", 1.0F, 1.0F); DOESN'T WORK YET
        }
        return false;
    }
}
