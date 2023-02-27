package ru.liahim.saltmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import ru.liahim.saltmod.init.AchievSalt;
import ru.liahim.saltmod.init.ModBlocks;
import ru.liahim.saltmod.init.ModItems;

public class SaltDirtLite extends Block {
    @SideOnly(Side.CLIENT)
    private IIcon SIDE;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE_L;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE_R;

    @SideOnly(Side.CLIENT)
    private IIcon BOTTOM;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE_1;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE_2;

    public SaltDirtLite(String name, CreativeTabs tab) {
        super(Material.ground);
        setTickRandomly(true);
        setStepSound(soundTypeGravel);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(0.5F);
        setResistance(1.0F);
        setHarvestLevel("shovel", 0);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return (meta == 1) ? this.SIDE_1 : ((meta == 2) ? this.SIDE_2 : ((side == 0 && meta >= 3) ? this.BOTTOM : (((side == 2 && (meta == 7 || meta == 11 || meta == 14 || meta == 15)) || (side == 5 && (meta == 8 || meta == 11 || meta == 12 || meta == 15)) || (side == 3 && (meta == 9 || meta == 12 || meta == 13 || meta == 15)) || (side == 4 && (meta == 10 || meta == 13 || meta == 14 || meta == 15))) ? this.SIDE : (((side == 2 && (meta == 3 || meta == 8 || meta == 12)) || (side == 5 && (meta == 4 || meta == 9 || meta == 13)) || (side == 3 && (meta == 5 || meta == 10 || meta == 14)) || (side == 4 && (meta == 6 || meta == 7 || meta == 11))) ? this.SIDE_L : (((side == 2 && (meta == 6 || meta == 10 || meta == 13)) || (side == 5 && (meta == 3 || meta == 7 || meta == 14)) || (side == 3 && (meta == 4 || meta == 8 || meta == 11)) || (side == 4 && (meta == 5 || meta == 9 || meta == 12))) ? this.SIDE_R : this.blockIcon)))));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1) {
        this.blockIcon = par1.registerIcon("saltmod:SaltDirtLite_0");
        this.SIDE_1 = par1.registerIcon("saltmod:SaltDirtLite_1");
        this.SIDE_2 = par1.registerIcon("saltmod:SaltDirtLite_2");
        this.SIDE = par1.registerIcon("saltmod:SaltDirtLite_Side");
        this.SIDE_L = par1.registerIcon("saltmod:SaltDirtLite_Side_L");
        this.SIDE_R = par1.registerIcon("saltmod:SaltDirtLite_Side_R");
        this.BOTTOM = par1.registerIcon("saltmod:SaltDirtLite_Bottom");
    }

    public void updateTick(World world, int x, int y, int z, Random rand) {
        if (!world.isRemote)
            if (world.getBlock(x, y + 1, z).getMaterial() == Material.snow) {
                world.setBlockToAir(x, y + 1, z);
            } else if (!world.getBlock(x, y + 1, z).getMaterial().isSolid() && world.getFullBlockLightValue(x, y + 1, z) > 7) {
                int j = world.getBlockMetadata(x, y, z);
                if (j > 2)
                    for (int x1 = x - 1; x1 < x + 2; x1++) {
                        for (int z1 = z - 1; z1 < z + 2; z1++) {
                            if ((world.getBlock(x1, y, z1) == Blocks.grass || world.getBlock(x1, y, z1) == ModBlocks.saltGrass) && world
                                .getBlock(x, y, z) == ModBlocks.saltDirtLite && world.getBlockLightValue(x, y + 1, z) > 7 && rand.nextInt(5) == 0)
                                world.setBlock(x, y, z, ModBlocks.saltGrass, j, 3);
                        }
                    }
            }
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitx, float hity, float hitz) {
        if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == ModItems.saltPinch) {
            ItemStack current = player.getCurrentEquippedItem();
            if (world.getBlock(x, y + 1, z) == ModBlocks.saltWort)
                player.addStat(AchievSalt.saltWortFarm, 1);
            int meta = world.getBlockMetadata(x, y, z);
            if (meta == 0 || meta > 2) {
                world.setBlock(x, y, z, this, 1, 3);
                if (!player.capabilities.isCreativeMode)
                    current.stackSize--;
            } else if (meta == 1) {
                world.setBlock(x, y, z, this, 2, 3);
                if (!player.capabilities.isCreativeMode)
                    current.stackSize--;
            } else if (meta == 2) {
                world.setBlock(x, y, z, ModBlocks.saltDirt);
                if (!player.capabilities.isCreativeMode)
                    current.stackSize--;
            }
            return true;
        }
        if (player.capabilities.isCreativeMode && player
            .getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == ModItems.salt) {
            int i = world.getBlockMetadata(x, y, z);
            if (side <= 1)
                if (i == 0) {
                    i = 3;
                } else if (i < 3 || i > 5) {
                    i = 0;
                } else {
                    i++;
                }
            if (side == 2)
                if (i == 4) {
                    i = 11;
                } else if (i == 5) {
                    i = 14;
                } else if (i < 7) {
                    i = 7;
                } else if (i == 7) {
                    i = 0;
                } else if (i == 8) {
                    i = 11;
                } else if (i == 9) {
                    i = 15;
                } else if (i == 10) {
                    i = 14;
                } else if (i == 11) {
                    i = 8;
                } else if (i == 14) {
                    i = 10;
                } else if (i < 15) {
                    i = 15;
                } else {
                    i = 9;
                }
            if (side == 5)
                if (i == 5) {
                    i = 12;
                } else if (i == 6) {
                    i = 11;
                } else if (i < 7) {
                    i = 8;
                } else if (i == 7) {
                    i = 11;
                } else if (i == 8) {
                    i = 0;
                } else if (i == 9) {
                    i = 12;
                } else if (i == 10) {
                    i = 15;
                } else if (i == 11) {
                    i = 7;
                } else if (i == 12) {
                    i = 9;
                } else if (i < 15) {
                    i = 15;
                } else {
                    i = 10;
                }
            if (side == 3)
                if (i == 3) {
                    i = 12;
                } else if (i == 6) {
                    i = 13;
                } else if (i < 7) {
                    i = 9;
                } else if (i == 7) {
                    i = 15;
                } else if (i == 8) {
                    i = 12;
                } else if (i == 9) {
                    i = 0;
                } else if (i == 10) {
                    i = 13;
                } else if (i == 12) {
                    i = 8;
                } else if (i == 13) {
                    i = 10;
                } else if (i < 15) {
                    i = 15;
                } else {
                    i = 7;
                }
            if (side == 4)
                if (i == 3) {
                    i = 14;
                } else if (i == 4) {
                    i = 13;
                } else if (i < 7) {
                    i = 10;
                } else if (i == 7) {
                    i = 14;
                } else if (i == 8) {
                    i = 15;
                } else if (i == 9) {
                    i = 13;
                } else if (i == 10) {
                    i = 0;
                } else if (i == 13) {
                    i = 9;
                } else if (i == 14) {
                    i = 7;
                } else if (i < 15) {
                    i = 15;
                } else {
                    i = 8;
                }
            world.setBlock(x, y, z, this, i, 3);
            return true;
        }
        return false;
    }
}
