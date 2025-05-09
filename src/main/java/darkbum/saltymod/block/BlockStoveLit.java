package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModBlocks;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

import static darkbum.saltymod.util.BlockHelper.*;

public class BlockStoveLit extends BlockStove {

    @SideOnly(Side.CLIENT)
    private IIcon iconBottom;

    @SideOnly(Side.CLIENT)
    private IIcon iconTop;

    @SideOnly(Side.CLIENT)
    private IIcon iconSide;

    @SideOnly(Side.CLIENT)
    private IIcon iconFront;

    public BlockStoveLit(String name, CreativeTabs tab) {
        super(name, tab);
        setTickRandomly(true);
        setLightLevel(0.875f);
        propertiesStove(this);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.iconTop = icon.registerIcon("saltymod:stove_top_on");
        this.iconBottom = icon.registerIcon("saltymod:stove_bottom");
        this.iconSide = icon.registerIcon("saltymod:stove_side");
        this.iconFront = icon.registerIcon("saltymod:stove_front_on");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        IIcon[] icons = {iconBottom, iconTop, iconSide, iconFront};

        return switch (meta) {
            case 0 -> switch (side) {
                case 0 -> icons[0];
                case 1 -> icons[1];
                case 3 -> icons[3];
                default -> icons[2];
            };
            case 1 -> switch (side) {
                case 0 -> icons[0];
                case 1 -> icons[1];
                case 4 -> icons[3];
                default -> icons[2];
            };
            case 2 -> switch (side) {
                case 0 -> icons[0];
                case 1 -> icons[1];
                case 2 -> icons[3];
                default -> icons[2];
            };
            case 3 -> switch (side) {
                case 0 -> icons[0];
                case 1 -> icons[1];
                case 5 -> icons[3];
                default -> icons[2];
            };
            default -> null;
        };
    }

    /**
     * Returns the item stack to be picked when the block is targeted in creative mode.
     * Always returns a single slab, even if targeting a double slab.
     *
     * @param target    The targeted block hit result.
     * @param world     The world the block is in.
     * @param x         The x-coordinate of the block.
     * @param y         The y-coordinate of the block.
     * @param z         The z-coordinate of the block.
     * @param player    The player picking the block.
     * @return an item stack of the single dry mud brick slab.
     */
    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
        return new ItemStack(ModBlocks.stove);
    }

    /**
     * Handles right-click interaction with the block.
     *
     * @param side      The side the block is interacted with.
     * @param hitX      The x-coordinate of the hit location on the block.
     * @param hitY      The y-coordinate of the hit location on the block.
     * @param hitZ      The z-coordinate of the hit location on the block.
     * @return true, if a GUI was opened, false otherwise
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        ItemStack heldItem = player.getCurrentEquippedItem();
        return heldItem != null && extinguishBlock(world, x, y, z, player, heldItem);
    }

    /**
     * Determines the drops when the block is harvested. The drops are dependent on the block's type.
     * <p>
     * This block will always drop a bee for the specific burrow type, aswell as having a 30% chance
     * to drop 1-3 combs of the appropriate type.
     *
     * @param fortune The fortune level of the player's tool.
     * @return a list of item stacks representing the items dropped by the block.
     */
    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<>();
        drops.add(new ItemStack(ModBlocks.stove));
        return drops;
    }

    /**
     * Called randomly on the client side to display audiovisual effects such as particles and sounds.
     *
     * @param random A random number generator.
     */
    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        float f = ((float) (4 + random.nextInt(8) + 1) + random.nextFloat()) / 16.0F;
        if (random.nextDouble() < 0.1) {
            world.playSound((double) x + (double) 0.5F, (double) y + (double) 0.5F, (double) z + (double) 0.5F, "saltymod:block.stove.crackle", 1.0F, world.rand.nextFloat() * 0.1F + 0.9F, false);
        }
    }
}
