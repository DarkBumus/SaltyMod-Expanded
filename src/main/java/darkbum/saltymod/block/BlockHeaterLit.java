package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockHeaterLit extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon BOTTOM;

    @SideOnly(Side.CLIENT)
    private IIcon TOP;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE;

    @SideOnly(Side.CLIENT)
    private IIcon FRONT;

    public BlockHeaterLit(String name, CreativeTabs tab) {
        super(Material.rock);
        setTickRandomly(true);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(2.0F);
        setResistance(6.0F);
        setLightLevel(0.8667F);
        setStepSound(soundTypeStone);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.TOP = icon.registerIcon("saltymod:heater_top_lit");
        this.BOTTOM = icon.registerIcon("saltymod:heater_bottom");
        this.SIDE = icon.registerIcon("saltymod:heater_side");
        this.FRONT = icon.registerIcon("saltymod:heater_front_lit");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        switch (meta) {
            case 0:
                switch (side) {
                    case 0:
                        return BOTTOM;
                    case 1:
                        return TOP;
                    case 2:
                    case 4:
                    case 5:
                        return SIDE;
                    case 3:
                        return FRONT;
                }
            case 1:
                switch (side) {
                    case 0:
                        return BOTTOM;
                    case 1:
                        return TOP;
                    case 2:
                    case 5:
                    case 3:
                        return SIDE;
                    case 4:
                        return FRONT;
                }
            case 2:
                switch (side) {
                    case 0:
                        return BOTTOM;
                    case 1:
                        return TOP;
                    case 2:
                        return FRONT;
                    case 4:
                    case 5:
                    case 3:
                        return SIDE;
                }
            case 3:
                switch (side) {
                    case 0:
                        return BOTTOM;
                    case 1:
                        return TOP;
                    case 2:
                    case 3:
                    case 4:
                        return SIDE;
                    case 5:
                        return FRONT;
                }
        }
        return null;
    }

    public void onBlockPlacedBy(World worldIn, int x, int y, int z, EntityLivingBase placer, ItemStack itemIn) {
        int l = MathHelper.floor_double((double) (placer.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        worldIn.setBlockMetadataWithNotify(x, y, z, l, 2);
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player,
                                    int side, float hitX, float hitY, float hitZ) {

        ItemStack heldItem = player.getCurrentEquippedItem();

        if (heldItem == null) return false;
        int meta = world.getBlockMetadata(x, y, z);

        if (heldItem.getItem() == Items.water_bucket || heldItem.getItem() instanceof ItemSpade) {
            if (!world.isRemote) {
                world.setBlock(x, y, z, ModBlocks.heater, meta, 3);
                if (heldItem.getItem() == Items.water_bucket) {
                    world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "random.fizz", 1.0F, world.rand.nextFloat() * 0.4F + 0.8F);
                    if (!player.capabilities.isCreativeMode) {
                        player.setCurrentItemOrArmor(0, new ItemStack(Items.bucket));
                        if (heldItem.stackSize <= 0) {
                            player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                        }
                    }
                } else if (heldItem.getItem() instanceof ItemSpade) {
                    world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "random.fizz", 1.0F, world.rand.nextFloat() * 0.4F + 0.8F);
                    if (!player.capabilities.isCreativeMode) {
                        heldItem.damageItem(1, player);
                        if (heldItem.getItemDamage() >= heldItem.getMaxDamage()) {
                            player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block neighborBlock) {
        if (world.isRemote) return;

        if (isWater(world, x + 1, y, z) ||
            isWater(world, x - 1, y, z) ||
            isWater(world, x, y + 1, z) ||
            isWater(world, x, y - 1, z) ||
            isWater(world, x, y, z + 1) ||
            isWater(world, x, y, z - 1)) {

            int meta = world.getBlockMetadata(x, y, z);
            world.setBlock(x, y, z, ModBlocks.heater, meta, 3);
            world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
        }
    }
    private boolean isWater(World world, int x, int y, int z) {
        Block block = world.getBlock(x, y, z);
        return block == Blocks.water || block == Blocks.flowing_water;
    }
}
