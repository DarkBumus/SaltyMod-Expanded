package darkbum.saltymod.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import darkbum.saltymod.common.config.ModConfigurationBlocks;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.util.BlockUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.common.proxy.CommonProxy;
import darkbum.saltymod.init.ModItems;

import static darkbum.saltymod.util.BlockUtils.*;

/**
 * Block class for the salt flower block.
 * The salt flower is a block collection.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class BlockSaltFlowerDirt extends BlockFlower {

    @SideOnly(Side.CLIENT)
    private IIcon iconDaucus;

    @SideOnly(Side.CLIENT)
    private IIcon iconWildCarrot;

    @SideOnly(Side.CLIENT)
    private IIcon iconSolanum;

    @SideOnly(Side.CLIENT)
    private IIcon iconWildPotato;

    @SideOnly(Side.CLIENT)
    private IIcon iconWildOnion;

    public static final String[] types = new String[]{"daucus", "wild_carrot", "solanum", "wild_potato", "wild_onion"};

    /**
     * Constructs a new block instance.
     * <p>
     * Also assigns base properties through {@link BlockUtils}.
     */
    public BlockSaltFlowerDirt() {
        super(1);
        setBlockName("salt_flower");
        setCreativeTab(CommonProxy.tabSaltBlocks);
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
        iconDaucus = icon.registerIcon("saltymod:flower_daucus");
        iconWildCarrot = icon.registerIcon("saltymod:flower_wild_carrot");
        iconSolanum = icon.registerIcon("saltymod:flower_solanum");
        iconWildPotato = icon.registerIcon("saltymod:flower_wild_potato");
        iconWildOnion = icon.registerIcon("saltymod:flower_wild_onion");
    }

    /**
     * Returns the appropriate icon for a given side and metadata value.
     *
     * @param side The side of the block being rendered.
     * @param meta The metadata of the block.
     * @return the icon to render.
     */
    @Override
    public IIcon getIcon(int side, int meta) {
        IIcon[] icons = {iconDaucus, iconWildCarrot, iconSolanum, iconWildPotato, iconWildOnion};
        return switch (meta) {
            case 1 -> icons[1];
            case 2 -> icons[2];
            case 3 -> icons[3];
            case 4 -> icons[4];
            default -> icons[0];
        };
    }

    /**
     * Sets the bounding box for the block based on its current state.
     *
     * @param world The world the block is in.
     * @param x     The x-coordinate of the block.
     * @param y     The y-coordinate of the block.
     * @param z     The z-coordinate of the block.
     */
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);

        if (ModConfigurationBlocks.saltFlowersLargeHitbox == 1) {
            if (meta == 1 || meta == 3 || meta == 4 || meta == 6) {
                float minX = 2.0f / 16.0f;
                float minY = 0.0f;
                float minZ = 2.0f / 16.0f;
                float maxX = 14.0f / 16.0f;
                float maxY = 13.0f / 16.0f;
                float maxZ = 14.0f / 16.0f;
                this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
                return;
            }
        } else if (ModConfigurationBlocks.saltFlowersLargeHitbox == 2) {
            if (meta == 1 || meta == 2 || meta == 3 || meta == 4 || meta == 5 || meta == 6) {
                float minX = 2.0f / 16.0f;
                float minY = 0.0f;
                float minZ = 2.0f / 16.0f;
                float maxX = 14.0f / 16.0f;
                float maxY = 13.0f / 16.0f;
                float maxZ = 14.0f / 16.0f;
                this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
                return;
            }
        }
        this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 0.6F, 0.7F);
    }

    /**
     * Adds the available sub-blocks of this item to the creative tab.
     * This method is used to specify the different variations of this item
     * that can be displayed in the creative inventory.
     *
     * @param item The item to add sub-blocks for.
     * @param tabs The creative tab where the item is being displayed.
     * @param list The list of item stacks to add the sub-blocks to.
     */
    @Override
    public void getSubBlocks(Item item, CreativeTabs tabs, List<ItemStack> list) {
        for (int i = 0; i < types.length; ++i) {
            list.add(new ItemStack(item, 1, i));
        }
    }

    /**
     * Whether this block can be placed at the specified coordinates.
     *
     * @param world The world the block is in.
     * @param x     The x-coordinate of the block.
     * @param y     The y-coordinate of the block.
     * @param z     The z-coordinate of the block.
     * @return true if the block can be placed, false otherwise.
     */
    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        Block blockBelow = world.getBlock(x, y - 1, z);
        int metaBelow = world.getBlockMetadata(x, y - 1, z);
        return blockBelow == Blocks.grass || blockBelow == ModBlocks.salt_grass || (blockBelow == Blocks.dirt && metaBelow == 2);
    }

    /**
     * Whether this block can stay at the specified coordinates.
     *
     * @return true if the block can stay, false otherwise.
     */
    @Override
    public boolean canBlockStay(World world, int x, int y, int z) {
        Block blockBelow = world.getBlock(x, y - 1, z);
        int metaBelow = world.getBlockMetadata(x, y - 1, z);
        return blockBelow == Blocks.grass || blockBelow == ModBlocks.salt_grass || (blockBelow == Blocks.dirt && metaBelow == 2);
    }

    /**
     * Called when the block is placed by an entity.
     * Sets metadata based on player's rotation and block type.
     *
     * @param entity The entity placing the block.
     * @param stack  The item used to place the block.
     */
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
        int meta = stack.getItemDamage();

        if (!canBlockStay(world, x, y, z)) {
            world.setBlockToAir(x, y, z);
            if (!world.isRemote) {
                ArrayList<ItemStack> drops = getDrops(world, x, y, z, meta, 0);
                for (ItemStack drop : drops) {
                    world.spawnEntityInWorld(new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, drop));
                }
            }
        }
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
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune) {
        ArrayList<ItemStack> drop = new ArrayList<>();
        Random rand = world.rand;

        switch (meta) {
            case 0:
                drop.add(new ItemStack(this, 1, 0));
                break;
            case 1:
                drop.add(new ItemStack(this, 1, 0));
                drop.add(new ItemStack(Items.carrot));
                break;
            case 2:
                drop.add(new ItemStack(this, 1, 2));
                break;
            case 3:
                drop.add(new ItemStack(this, 1, 2));
                drop.add(new ItemStack(Items.potato));
                break;
            case 4:
                drop.add(new ItemStack(Blocks.red_flower, 1, 2));
                if (rand.nextFloat() < 0.5f) drop.add(new ItemStack(Blocks.red_flower, 1, 2));
                drop.add(new ItemStack(ModItems.onion));
                break;
        }
        return drop;
    }
}

