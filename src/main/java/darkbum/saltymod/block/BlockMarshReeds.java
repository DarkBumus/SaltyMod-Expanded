package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.common.proxy.ClientProxy;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.util.BlockHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

import java.util.ArrayList;
import java.util.Random;

import static darkbum.saltymod.util.BlockHelper.*;

/**
 * Parent class for the marsh reeds block.
 * This class encompasses both {@link BlockMarshReedsTop} and {@link BlockMarshReedsBottom}
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class BlockMarshReeds {

    /**
     * Static block class for the marsh reeds block.
     * The marsh reeds is a regular plant block that is tethered to {@link BlockMarshReedsBottom}.
     *
     * @author DarkBum
     * @since 2.0.0
     */
    public static class BlockMarshReedsTop extends BlockBush implements IShearable {

        @SideOnly(Side.CLIENT)
        public IIcon iconTop;

        /**
         * Constructs a new block instance with a given name and a creative tab.
         * <p>
         * Also assigns a material and other base properties through {@link BlockHelper}.
         *
         * @param name  The internal name of the block.
         * @param tab   The creative tab in which the block appears.
         */
        public BlockMarshReedsTop(String name, CreativeTabs tab) {
            super(Material.plants);
            setBlockName(name);
            setCreativeTab(tab);
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            propertiesSaltPlantsAll(this);
        }

        /**
         * Registers the textures for the different sides of the block.
         *
         * @param icon  The icon register used to load textures.
         */
        @Override
        @SideOnly(Side.CLIENT)
        public void registerBlockIcons(IIconRegister icon) {
            iconTop = icon.registerIcon("saltymod:marsh_reeds_top");
            blockIcon = iconTop;
        }

        /**
         * @return the icon name for the block.
         */
        @Override
        public String getItemIconName() {
            return "marsh_reeds";
        }

        /**
         * Gets the render type for this block.
         *
         * @return a custom render type ID, provided by the client proxy.
         */
        @Override
        public int getRenderType() {
            return ClientProxy.marshReedsRenderType;
        }

        /**
         * Specifies the render pass this block should be rendered in.
         *
         * @return 1 to render this block during the transparent render pass.
         */
        @Override
        public int getRenderBlockPass() {
            return 1;
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
        @SideOnly(Side.CLIENT)
        public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
            return new ItemStack(Item.getItemFromBlock(ModBlocks.marsh_reeds_b));
        }

        /**
         * Whether this block can be placed at the specified coordinates.
         *
         * @return true if the block can be placed, false otherwise.
         */
        @Override
        public boolean canPlaceBlockAt(World world, int x, int y, int z) {
            Block block = world.getBlock(x, y, z);
            Block blockBelow = world.getBlock(x, y - 1, z);
            return block.isAir(world, x, y, z) && blockBelow == ModBlocks.marsh_reeds_b;
        }

        /**
         * Whether this block can stay at the specified coordinates.
         *
         * @return true if the block can stay, false otherwise.
         */
        @Override
        public boolean canBlockStay(World world, int x, int y, int z) {
            Block blockBelow = world.getBlock(x, y - 1, z);
            return blockBelow == ModBlocks.marsh_reeds_b;
        }

        /**
         * Called when the block is broken, including handling inventory drops.
         * <p>
         * The block will check for its counterpart below and destroy itself and the counterpart when destroyed.
         *
         * @param block     The block that was replaced.
         * @param meta      The metadata of the block.
         */
        @Override
        public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
            if (world.getBlock(x, y - 1, z) == ModBlocks.marsh_reeds_b) {
                world.setBlock(x, y - 1, z, Blocks.water);
            }
            world.setBlockToAir(x, y, z);

            super.breakBlock(world, x, y, z, block, meta);
        }

        /**
         * Returns the item dropped when this block is broken.
         * Returns null so that nothing is dropped directly.
         *
         * @param fortune  The fortune level of the player's tool.
         * @return null when the chance doesn't return a drop.
         */
        @Override
        public Item getItemDropped(int meta, Random random, int fortune) {
            if (random.nextInt(8) == 0) {
                return Items.wheat_seeds;
            } else if (random.nextInt(8) == 0) {
                return ModItems.salt_pinch;
            }
            return null;
        }

        /**
         * Whether the block is replacable by water or other means.
         *
         * @return true, indicating that the block gets destroyed by water.
         */
        @Override
        public boolean isReplaceable(IBlockAccess world, int x, int y, int z) {
            Block blockAbove = world.getBlock(x, y + 1, z);
            return blockAbove.getMaterial().isLiquid();
        }

        /**
         * Whether the block is shearable.
         *
         * @return true, to make the block have special drops when destroyed with shears.
         */
        @Override
        public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
            return true;
        }

        /**
         * Returns a list of drops when this block is sheared.
         *
         * @param stack     The shear itemstack.
         * @return a list containing one itemstack of the base marsh reeds block.
         */
        @Override
        public ArrayList<ItemStack> onSheared(ItemStack stack, IBlockAccess world, int x, int y, int z, int fortune) {
            ArrayList<ItemStack> ret = new ArrayList<>();
            ret.add(new ItemStack(Item.getItemFromBlock(ModBlocks.marsh_reeds_b), 1, world.getBlockMetadata(x, y, z)));
            return ret;
        }
    }


    /**
     * Static block class for the marsh reeds block.
     * The marsh reeds is a regular plant block that is tethered to {@link BlockMarshReedsTop}.
     *
     * @author DarkBum
     * @since 2.0.0
     */
    public static class BlockMarshReedsBottom extends BlockBush implements IShearable {

        @SideOnly(Side.CLIENT)
        public IIcon iconBottom;

        /**
         * Constructs a new block instance with a given name and a creative tab.
         * <p>
         * Also assigns a material and other base properties through {@link BlockHelper}.
         *
         * @param name The internal name of the block.
         * @param tab  The creative tab in which the block appears.
         */
        public BlockMarshReedsBottom(String name, CreativeTabs tab) {
            super(Material.water);
            setBlockName(name);
            setCreativeTab(tab);
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            propertiesSaltPlantsAll(this);
        }

        /**
         * Registers the textures for the different sides of the block.
         *
         * @param icon The icon register used to load textures.
         */
        @Override
        @SideOnly(Side.CLIENT)
        public void registerBlockIcons(IIconRegister icon) {
            iconBottom = icon.registerIcon("saltymod:marsh_reeds_bottom");
            blockIcon = iconBottom;
        }

        /**
         * @return the icon name for the block.
         */
        @Override
        public String getItemIconName() {
            return "marsh_reeds";
        }

        /**
         * Gets the render type for this block.
         *
         * @return a custom render type ID, provided by the client proxy.
         */
        @Override
        public int getRenderType() {
            return ClientProxy.marshReedsRenderType;
        }

        /**
         * Specifies the render pass this block should be rendered in.
         *
         * @return 1 to render this block during the transparent render pass.
         */
        @Override
        public int getRenderBlockPass() {
            return 1;
        }

        /**
         * Whether this block can be placed at the specified coordinates.
         *
         * @return true if the block can be placed, false otherwise.
         */
        @Override
        public boolean canPlaceBlockAt(World world, int x, int y, int z) {
            Block block = world.getBlock(x, y, z);
            Block blockBelow = world.getBlock(x, y - 1, z);
            Block blockAbove = world.getBlock(x, y + 1, z);
            return blockBelow == ModBlocks.mineral_mud && block == Blocks.water && (blockAbove.isAir(world, x, y + 1, z) || blockAbove == ModBlocks.marsh_reeds_t);
        }

        /**
         * Whether this block can stay at the specified coordinates.
         *
         * @return true if the block can stay, false otherwise.
         */
        @Override
        public boolean canBlockStay(World world, int x, int y, int z) {
            Block blockBelow = world.getBlock(x, y - 1, z);
            Block blockAbove = world.getBlock(x, y + 1, z);
            return blockBelow == ModBlocks.mineral_mud && (blockAbove == ModBlocks.marsh_reeds_t);
        }

        /**
         * Called when the block is added to the world.
         * Places the top part of the marsh reeds automatically if air is present above.
         *
         * @param world The world the block is in.
         * @param x     The x-coordinate of the block.
         * @param y     The y-coordinate of the block.
         * @param z     The z-coordinate of the block.
         */
        @Override
        public void onBlockAdded(World world, int x, int y, int z) {
            super.onBlockAdded(world, x, y, z);

            if (!world.isRemote) {
                Block blockAbove = world.getBlock(x, y + 1, z);

                if (blockAbove.isAir(world, x, y + 1, z)) {
                    world.setBlock(x, y + 1, z, ModBlocks.marsh_reeds_t, 0, 3);
                }
            }
        }

        /**
         * Handles right-click interaction with the block.
         *
         * @param player The player interacting with the block.
         * @param side   The side the block is interacted with.
         * @param hitX   The x-coordinate of the hit location on the block.
         * @param hitY   The y-coordinate of the hit location on the block.
         * @param hitZ   The z-coordinate of the hit location on the block.
         * @return true, if a GUI was opened, false otherwise
         */
        @Override
        public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
            ItemStack heldItem = player.getHeldItem();
            return heldItem != null && heldItem.getItem() == Items.bucket;
        }

        /**
         * Called when a neighboring block changes.
         * Causes flowing water to appear in cardinal directions if there's air.
         *
         * @param neighborBlock The block that changed.
         */
        @Override
        public void onNeighborBlockChange(World world, int x, int y, int z, Block neighborBlock) {
            super.onNeighborBlockChange(world, x, y, z, neighborBlock);

            for (int dx = -1; dx <= 1; dx++) {
                for (int dz = -1; dz <= 1; dz++) {
                    if (Math.abs(dx) + Math.abs(dz) == 1) {
                        if (world.isAirBlock(x + dx, y, z + dz)) {
                            world.setBlock(x + dx, y, z + dz, Blocks.flowing_water, 1, 2);
                        }
                    }
                }
            }
        }

        /**
         * Called when the block is broken, including handling inventory drops.
         * <p>
         * The block will check for its counterpart above and destroy itself and the counterpart when destroyed.
         *
         * @param block The block that was replaced.
         * @param meta  The metadata of the block.
         */
        @Override
        public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
            Block above = world.getBlock(x, y + 1, z);

            if (above == ModBlocks.marsh_reeds_t) {
                if (!world.isRemote) {
                    int metaAbove = world.getBlockMetadata(x, y + 1, z);
                    above.dropBlockAsItem(world, x, y + 1, z, metaAbove, 0);
                }

                world.setBlockToAir(x, y + 1, z);
            }
            world.setBlock(x, y, z, Blocks.water);

            super.breakBlock(world, x, y, z, block, meta);
        }

        /**
         * Returns the item dropped when this block is broken.
         * Returns null so that nothing is dropped directly.
         *
         * @param fortune The fortune level of the player's tool.
         * @return null, indicating no item drop.
         */
        @Override
        public Item getItemDropped(int meta, Random random, int fortune) {
            return null;
        }

        /**
         * Whether the block is replacable by water or other means.
         *
         * @return true, indicating that the block gets destroyed by water.
         */
        @Override
        public boolean isReplaceable(IBlockAccess world, int x, int y, int z) {
            Block blockAbove = world.getBlock(x, y + 1, z);
            return blockAbove.getMaterial().isLiquid();
        }

        /**
         * Whether the block is shearable.
         *
         * @return true, to make the block have special drops when destroyed with shears.
         */
        @Override
        public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
            return true;
        }

        /**
         * Returns a list of drops when this block is sheared.
         *
         * @param stack The shear itemstack.
         * @return a list containing one itemstack of the base marsh reeds block.
         */
        @Override
        public ArrayList<ItemStack> onSheared(ItemStack stack, IBlockAccess world, int x, int y, int z, int fortune) {
            ArrayList<ItemStack> ret = new ArrayList<>();
            ret.add(new ItemStack(Item.getItemFromBlock(ModBlocks.marsh_reeds_b), 1, world.getBlockMetadata(x, y, z)));
            return ret;
        }
    }
}
