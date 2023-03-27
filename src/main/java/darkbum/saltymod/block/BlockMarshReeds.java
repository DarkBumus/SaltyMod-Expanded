package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockMarshReeds extends BlockDoublePlant {

    @SideOnly(Side.CLIENT)
    private IIcon[] doublePlantBottomIcons;
    @SideOnly(Side.CLIENT)
    private IIcon[] doublePlantTopIcons;

    public BlockMarshReeds(String name, CreativeTabs tab) {
        super();
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(0.0F);
        setStepSound(Block.soundTypeGrass);
        setBlockTextureName("saltymod:marsh_reeds");
    }

    public int getRenderType() {
        return 40;
    }

    public boolean canPlaceBlockAt(World worldIn, int x, int y, int z) {
        return super.canPlaceBlockAt(worldIn, x, y, z) && worldIn.isAirBlock(x, y + 1, z);
    }

    protected void checkAndDropBlock(World worldIn, int x, int y, int z) {
        if (!this.canBlockStay(worldIn, x, y, z)) {
            int l = worldIn.getBlockMetadata(x, y, z);
            if (!func_149887_c(l)) {
                this.dropBlockAsItem(worldIn, x, y, z, l, 0);
                if (worldIn.getBlock(x, y + 1, z) == this) {
                    worldIn.setBlock(x, y + 1, z, Blocks.air, 0, 2);
                }
            }
            worldIn.setBlock(x, y, z, Blocks.air, 0, 2);
        }
    }

    public boolean canBlockStay(World worldIn, int x, int y, int z) {
        if (worldIn.getBlock(x, y, z) != this) return super.canBlockStay(worldIn, x, y, z); //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
        int l = worldIn.getBlockMetadata(x, y, z);
        return func_149887_c(l) ? worldIn.getBlock(x, y - 1, z) == this : worldIn.getBlock(x, y + 1, z) == this && super.canBlockStay(worldIn, x, y, z);
    }

    public Item getItemDropped(int meta, Random random, int fortune) {
        if (func_149887_c(meta)) {
            return null;
        } else {
            int k = func_149890_d(meta);
            return k != 3 && k != 2 ? Item.getItemFromBlock(this) : null;
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return func_149887_c(meta) ? this.doublePlantBottomIcons[0] : this.doublePlantBottomIcons[meta & 7];
    }

    @SideOnly(Side.CLIENT)
    public IIcon func_149888_a(boolean p_149888_1_, int p_149888_2_) {
        return p_149888_1_ ? this.doublePlantTopIcons[p_149888_2_] : this.doublePlantBottomIcons[p_149888_2_];
    }

    public void harvestBlock(World worldIn, EntityPlayer player, int x, int y, int z, int meta) {
        if (worldIn.isRemote || player.getCurrentEquippedItem() == null || player.getCurrentEquippedItem().getItem() != Items.shears || func_149887_c(meta) || !this.func_149886_b(worldIn, x, y, z, meta, player)) {
            super.harvestBlock(worldIn, player, x, y, z, meta);
        }
    }

    public void onBlockHarvested(World worldIn, int x, int y, int z, int meta, EntityPlayer player) {
        if (func_149887_c(meta)) {
            if (worldIn.getBlock(x, y - 1, z) == this) {
                if (!player.capabilities.isCreativeMode) {
                    int i1 = worldIn.getBlockMetadata(x, y - 1, z);
                    int j1 = func_149890_d(i1);

                    if (j1 != 3 && j1 != 2) {
                        worldIn.func_147480_a(x, y - 1, z, true);
                    } else {
                        if (!worldIn.isRemote && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Items.shears) {
                            this.func_149886_b(worldIn, x, y, z, i1, player);
                        }
                        worldIn.setBlockToAir(x, y - 1, z);
                    }
                } else {
                    worldIn.setBlockToAir(x, y - 1, z);
                }
            }
        } else if (player.capabilities.isCreativeMode && worldIn.getBlock(x, y + 1, z) == this) {
            worldIn.setBlock(x, y + 1, z, Blocks.air, 0, 2);
        }
        super.onBlockHarvested(worldIn, x, y, z, meta, player);
    }

    private boolean func_149886_b(World p_149886_1_, int p_149886_2_, int p_149886_3_, int p_149886_4_, int p_149886_5_, EntityPlayer p_149886_6_) {
        int i1 = func_149890_d(p_149886_5_);

        if (i1 != 3 && i1 != 2) {
            return false;
        } else {
            p_149886_6_.addStat(StatList.mineBlockStatArray[Block.getIdFromBlock(this)], 1);
            byte b0 = 1;

            if (i1 == 3) {
                b0 = 2;
            }

            this.dropBlockAsItem(p_149886_1_, p_149886_2_, p_149886_3_, p_149886_4_, new ItemStack(Blocks.tallgrass, 2, b0));
            return true;
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg) {
        this.doublePlantBottomIcons = new IIcon[field_149892_a.length];
        this.doublePlantTopIcons = new IIcon[field_149892_a.length];

        for (int i = 0; i < this.doublePlantBottomIcons.length; ++i) {
            this.doublePlantBottomIcons[i] = reg.registerIcon("double_plant_" + field_149892_a[i] + "_bottom");
            this.doublePlantTopIcons[i] = reg.registerIcon("double_plant_" + field_149892_a[i] + "_top");
        }

        this.sunflowerIcons = new IIcon[2];
        this.sunflowerIcons[0] = reg.registerIcon("double_plant_sunflower_front");
        this.sunflowerIcons[1] = reg.registerIcon("double_plant_sunflower_back");
    }


}
