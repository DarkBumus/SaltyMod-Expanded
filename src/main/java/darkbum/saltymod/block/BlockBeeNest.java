package darkbum.saltymod.block;

import java.util.ArrayList;
import java.util.Random;

import darkbum.saltymod.util.BlockHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModItems;

/**
 * Block class for the bee nest block.
 * The bee nest is a regular block with two types, which produce special drops when destroyed.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class BlockBeeNest extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon iconTop;

    @SideOnly(Side.CLIENT)
    private IIcon iconBottom;

    @SideOnly(Side.CLIENT)
    private IIcon iconSide;

    @SideOnly(Side.CLIENT)
    private IIcon iconBurrow;

    /**
     * Enum to differentiate between the types of bee burrows.
     */
    public enum BeeNestType {
        TEMPERATE, BOREAL
    }

    private final BeeNestType type;

    /**
     * Constructs a new block instance with a given name, a creative tab and a type.
     * <p>
     * Also assigns a material and other base properties through {@link BlockHelper}.
     *
     * @param name The internal name of the block.
     * @param tab  The creative tab in which the block appears.
     * @param type The type of bee burrow.
     */
    public BlockBeeNest(String name, CreativeTabs tab, BeeNestType type) {
        super(Material.wood);
        this.type = type;
        setBlockName(name);
        setCreativeTab(tab);
        BlockHelper.propertiesBeeNest(this);
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon The icon register used to load textures.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        if (type == BeeNestType.TEMPERATE) {
            iconTop = icon.registerIcon("saltymod:bee_nest_temperate_top");
            iconBottom = icon.registerIcon("saltymod:bee_nest_temperate_bottom");
            iconSide = icon.registerIcon("saltymod:bee_nest_temperate_side");
            iconBurrow = icon.registerIcon("saltymod:bee_nest_temperate_burrow");
        } else {
            iconTop = icon.registerIcon("saltymod:bee_nest_boreal_top");
            iconBottom = icon.registerIcon("saltymod:bee_nest_boreal_bottom");
            iconSide = icon.registerIcon("saltymod:bee_nest_boreal_side");
            iconBurrow = icon.registerIcon("saltymod:bee_nest_boreal_burrow");
        }
    }

    /**
     * Returns the appropriate icon for a given side and metadata value.
     *
     * @param side The side of the block being rendered.
     * @param meta The metadata of the block.
     * @return the icon to render.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        IIcon[] icons = {iconTop, iconTop, iconSide, iconSide, iconBurrow, iconSide};
        int facing = meta % 4;

        if (side == 0) return iconBottom;
        if (side == 1) return iconTop;

        return switch (facing) {
            case 0 -> icons[side == 2 || side == 4 || side == 5 ? 2 : (side == 3 ? 4 : 2)];
            case 1 -> icons[side == 2 || side == 5 || side == 3 ? 2 : (side == 4 ? 4 : 2)];
            case 2 -> icons[side == 2 ? 4 : 2];
            case 3 -> icons[side == 5 ? 4 : 2];
            default -> iconSide;
        };
    }

    /**
     * Called when the block is placed by an entity.
     * Sets metadata based on player's rotation and block type.
     *
     * @param world  The world the block is in.
     * @param x      The x-coordinate of the block.
     * @param y      The y-coordinate of the block.
     * @param z      The z-coordinate of the block.
     * @param entity The entity placing the block.
     * @param stack  The item used to place the block.
     */
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
        int directionMeta = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        int baseMeta = (type == BeeNestType.BOREAL) ? 4 : 0;
        world.setBlockMetadataWithNotify(x, y, z, baseMeta + directionMeta, 2);
    }

    /**
     * Whether this block can be silk-harvested.
     *
     * @return false, silk touch is not supported.
     */
    @Override
    protected boolean canSilkHarvest() {
        return false;
    }

    /**
     * Called when the block is harvested by the player.
     * If the player is not in creative mode, it applies the "Swarmed" effect to the player when the block is harvested.
     */
    @Override
    public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            BlockHelper.applySwarmedEffect(world, player, x, y, z, 900);
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
        ArrayList<ItemStack> drops = new ArrayList<>();
        Random random = new Random();

        BeeNestType actualType = (meta >= 4) ? BeeNestType.BOREAL : BeeNestType.TEMPERATE;    // 4+ means birch
        ItemStack bee = (actualType == BeeNestType.TEMPERATE) ? new ItemStack(ModItems.honey_bee) : new ItemStack(ModItems.boreal_bee);
        ItemStack comb = (actualType == BeeNestType.TEMPERATE) ? new ItemStack(ModItems.honeycomb) : new ItemStack(ModItems.frozen_honey);
        drops.add(bee);

        if (random.nextFloat() < 0.3f) {
            int count = random.nextInt(3) + 1;  // 1-3 combs
            ItemStack stack = comb.copy();
            stack.stackSize = count;
            drops.add(stack);
        }
        return drops;
    }

    /**
     * Whether this block can sustain leaves.
     *
     * @return true when it can sustain leaves.
     */
    @Override
    public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
        return true;
    }
}
