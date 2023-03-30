package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockSaltDirt extends Block {

    public static final byte[] sideTwo = {7, 7, 7, 7, 11, 14, 7, 0, 11, 15, 14, 8, 15, 15, 10, 9};
    public static final byte[] sideThree = {9, 9, 9, 12, 9, 9, 13, 15, 12, 0, 13, 15, 8, 10, 15, 7};
    public static final byte[] sideFour = {10, 10, 10, 14, 13, 10, 10, 14, 15, 13, 0, 15, 15, 9, 7, 8};
    public static final byte[] sideFive = {8, 8, 8, 8, 8, 12, 11, 11, 0, 12, 15, 7, 9, 15, 15, 10};

    @SideOnly(Side.CLIENT)
    private IIcon BOTTOM0;

    @SideOnly(Side.CLIENT)
    private IIcon BOTTOM1;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE_1;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE_2;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE_3;

    @SideOnly(Side.CLIENT)
    private IIcon SALTSIDE;

    @SideOnly(Side.CLIENT)
    private IIcon SALTSIDE_L;

    @SideOnly(Side.CLIENT)
    private IIcon SALTSIDE_R;



//    @SideOnly(Side.CLIENT)
//    private IIcon SIDE_3;

    public BlockSaltDirt(String name, CreativeTabs tab) {
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
    @Override
    public IIcon getIcon(int side, int meta) {
        switch (meta) {
            case 0:
                switch (side) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return BOTTOM0;
                }
            case 1:
                switch (side) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return SIDE_1;
                }
            case 2:
                switch (side) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return SIDE_2;
                }
            case 3:
                switch (side) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return SIDE_3;
                }
            case 7:
                switch (side) {
                    case 0:
                        return BOTTOM1;
                    case 2:
                        return SALTSIDE;
                    case 3:
                        return BOTTOM0;
                    case 4:
                        return SALTSIDE_L;
                    case 5:
                        return SALTSIDE_R;
                }
            case 8:
                switch (side) {
                    case 0:
                        return BOTTOM1;
                    case 2:
                        return SALTSIDE_L;
                    case 3:
                        return SALTSIDE_R;
                    case 4:
                        return BOTTOM0;
                    case 5:
                        return SALTSIDE;
                }
            case 9:
                switch (side) {
                    case 0:
                        return BOTTOM1;
                    case 2:
                        return BOTTOM0;
                    case 3:
                        return SALTSIDE;
                    case 4:
                        return SALTSIDE_R;
                    case 5:
                        return SALTSIDE_L;
                }
            case 10:
                switch (side) {
                    case 0:
                        return BOTTOM1;
                    case 2:
                        return SALTSIDE_R;
                    case 3:
                        return SALTSIDE_L;
                    case 4:
                        return SALTSIDE;
                    case 5:
                        return BOTTOM0;
                }
            case 11:
                switch (side) {
                    case 0:
                        return BOTTOM1;
                    case 2:
                    case 5:
                        return SALTSIDE;
                    case 3:
                        return SALTSIDE_R;
                    case 4:
                        return SALTSIDE_L;
                }
            case 12:
                switch (side) {
                    case 0:
                        return BOTTOM1;
                    case 2:
                        return SALTSIDE_L;
                    case 3:
                    case 5:
                        return SALTSIDE;
                    case 4:
                        return SALTSIDE_R;
                }
            case 13:
                switch (side) {
                    case 0:
                        return BOTTOM1;
                    case 2:
                        return SALTSIDE_R;
                    case 3:
                    case 4:
                        return SALTSIDE;
                    case 5:
                        return SALTSIDE_L;
                }
            case 14:
                switch (side) {
                    case 0:
                        return BOTTOM1;
                    case 2:
                    case 4:
                        return SALTSIDE;
                    case 3:
                        return SALTSIDE_L;
                    case 5:
                        return SALTSIDE_R;
                }
            case 4:
            case 5:
            case 6:
            case 15:
                switch (side) {
                    case 0:
                        return BOTTOM1;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return SALTSIDE;
                }
        }
        return SALTSIDE;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.BOTTOM0 = iconRegister.registerIcon("saltymod:salt_dirt_0");
        this.BOTTOM1 = iconRegister.registerIcon("saltymod:salt_dirt_bottom");
        this.SIDE_1 = iconRegister.registerIcon("saltymod:salt_dirt_1");
        this.SIDE_2 = iconRegister.registerIcon("saltymod:salt_dirt_2");
        this.SIDE_3 = iconRegister.registerIcon("saltymod:salt_dirt_3");
        this.SALTSIDE = iconRegister.registerIcon("saltymod:salt_dirt_saltside");
        this.SALTSIDE_L = iconRegister.registerIcon("saltymod:salt_dirt_saltside_l");
        this.SALTSIDE_R = iconRegister.registerIcon("saltymod:salt_dirt_saltside_r");

    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitx, float hity, float hitz) {
        if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == ModItems.salt_pinch) {
            ItemStack current = player.getCurrentEquippedItem();
            if (world.getBlock(x, y + 1, z) == ModBlocks.saltworts)
                player.addStat(ModAchievementList.saltWortFarm, 1);
            int meta = world.getBlockMetadata(x, y, z);
            if (meta == 0 || meta > 3) {
                world.setBlock(x, y, z, this, 1, 3);
                if (!player.capabilities.isCreativeMode)
                    current.stackSize--;
            } else if (meta == 1) {
                world.setBlock(x, y, z, this, 2, 3);
                if (!player.capabilities.isCreativeMode)
                    current.stackSize--;
            } else if (meta == 2) {
                world.setBlock(x, y, z, this, 3, 3);
                if (!player.capabilities.isCreativeMode)
                    current.stackSize--;
            } else if (meta == 3) {
                player.addChatMessage(new ChatComponentText(I18n.format(getUnlocalizedName() + ".mess")));
            }
            return true;
        }
        ItemStack heldStack = player.getCurrentEquippedItem();
        if(heldStack != null && heldStack.getItem() == ModItems.salt) {
            int meta = world.getBlockMetadata(x, y, z);
            switch(side) {
                case 0:
                case 1:
                    if (meta == 0) {
                        meta = 3;
                    } else if (meta < 3 || meta > 5) {
                        meta = 0;
                    } else {
                        meta++;
                    }
                    break;
                case 2:
                    meta = sideTwo[meta];
                    break;
                case 3:
                    meta = sideThree[meta];
                    break;
                case 4:
                    meta = sideFour[meta];
                    break;
                case 5:
                    meta = sideFive[meta];
                    break;
            }
            world.setBlock(x, y, z, this, meta, 3);
            return true;
        }
        return false;
    }
}
