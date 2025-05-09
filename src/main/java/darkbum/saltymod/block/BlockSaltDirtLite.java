package darkbum.saltymod.block;

import java.util.Random;

import darkbum.saltymod.util.BlockHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;

import static darkbum.saltymod.util.BlockHelper.*;

/**
 * Block class for the lite salt dirt block.
 * The lite salt dirt block is a regular block with multiple variations.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class BlockSaltDirtLite extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon iconSide;

    @SideOnly(Side.CLIENT)
    private IIcon iconSideL;

    @SideOnly(Side.CLIENT)
    private IIcon iconSideR;

    @SideOnly(Side.CLIENT)
    private IIcon iconBottom;

    @SideOnly(Side.CLIENT)
    private IIcon iconSide1;

    @SideOnly(Side.CLIENT)
    private IIcon iconSide2;

    /**
     * Constructs a new block instance with a given name and a creative tab.
     * <p>
     * Also assigns a material and other base properties through {@link BlockHelper}.
     *
     * @param name The internal name of the block.
     * @param tab  The creative tab in which the block appears.
     */
    public BlockSaltDirtLite(String name, CreativeTabs tab) {
        super(Material.ground);
        setBlockName(name);
        setCreativeTab(tab);
        setTickRandomly(true);
        propertiesSaltDirtSaltDirtLite(this);
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon The icon register used to load textures.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.blockIcon = icon.registerIcon("saltymod:salt_dirt_lite_0");
        this.iconSide1 = icon.registerIcon("saltymod:salt_dirt_lite_1");
        this.iconSide2 = icon.registerIcon("saltymod:salt_dirt_lite_2");
        this.iconSide = icon.registerIcon("saltymod:salt_dirt_lite_saltside");
        this.iconSideL = icon.registerIcon("saltymod:salt_dirt_lite_saltside_l");
        this.iconSideR = icon.registerIcon("saltymod:salt_dirt_lite_saltside_r");
        this.iconBottom = icon.registerIcon("saltymod:salt_dirt_lite_bottom");
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
        IIcon[] icons = {iconSide, iconSide1, iconSide2, iconSideL, iconSideR, iconBottom};

        return switch (meta) {
            case 1 -> icons[1];
            case 2 -> icons[2];
            case 0 -> blockIcon;
            default -> {
                if (side == 0) yield icons[5];

                if ((side == 2 && (meta == 7 || meta == 11 || meta == 14 || meta == 15)) ||
                    (side == 5 && (meta == 8 || meta == 11 || meta == 12 || meta == 15)) ||
                    (side == 3 && (meta == 9 || meta == 12 || meta == 13 || meta == 15)) ||
                    (side == 4 && (meta == 10 || meta == 13 || meta == 14 || meta == 15))) {
                    yield icons[0];
                }
                if ((side == 2 && (meta == 3 || meta == 8 || meta == 12)) ||
                    (side == 5 && (meta == 4 || meta == 9 || meta == 13)) ||
                    (side == 3 && (meta == 5 || meta == 10 || meta == 14)) ||
                    (side == 4 && (meta == 6 || meta == 7 || meta == 11))) {
                    yield icons[3];
                }
                if ((side == 2 && (meta == 6 || meta == 10 || meta == 13)) ||
                    (side == 5 && (meta == 3 || meta == 7 || meta == 14)) ||
                    (side == 3 && (meta == 4 || meta == 8 || meta == 11)) ||
                    (side == 4 && (meta == 5 || meta == 9 || meta == 12))) {
                    yield icons[4];
                }
                yield this.blockIcon;
            }
        };
    }

    /**
     * Handles right-click interaction with the block.
     *
     * @param player The player interacting with the block.
     * @return true, if the block was successfully stripped, false otherwise.
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitx, float hity, float hitz) {
        ItemStack currentItem = player.getCurrentEquippedItem();

        if (currentItem != null && currentItem.getItem() == ModItems.salt_pinch) {
            if (world.getBlock(x, y + 1, z) == ModBlocks.saltworts)
                player.addStat(ModAchievementList.farm_saltwort, 1);

            int meta = world.getBlockMetadata(x, y, z);

            if (meta == 0 || meta > 2) {
                world.setBlock(x, y, z, this, 1, 3);
            } else if (meta == 1) {
                world.setBlock(x, y, z, this, 2, 3);
            } else if (meta == 2) {
                world.setBlock(x, y, z, ModBlocks.salt_dirt);
            }
            if (!player.capabilities.isCreativeMode) currentItem.stackSize--;
            return true;
        }

        if (player.capabilities.isCreativeMode && currentItem != null && currentItem.getItem() == ModItems.salt) {
            int currentMeta = world.getBlockMetadata(x, y, z);
            int newMeta = calculateSaltDirtSaltGrassNewMeta(currentMeta, side);
            world.setBlock(x, y, z, this, newMeta, 3);
            return true;
        }
        return false;
    }

    /**
     * Updates the block's state during a tick.
     * This method is called on each tick to update the block's behavior.
     * It checks for nearby entities, tries to grow salt crystals, and attempts to melt ice or snow.
     *
     * @param random The random number generator.
     */
    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
        if (world.isRemote) return;

        Block blockAbove = world.getBlock(x, y + 1, z);
        Material materialAbove = blockAbove.getMaterial();

        if (blockAbove == Blocks.snow_layer) world.setBlockToAir(x, y + 1, z);

        else if (!materialAbove.isSolid() && world.getFullBlockLightValue(x, y + 1, z) > 7) {
            int metadata = world.getBlockMetadata(x, y, z);
            if (metadata > 2) {
                for (int x1 = x - 1; x1 <= x + 1; x1++) {
                    for (int z1 = z - 1; z1 <= z + 1; z1++) {
                        Block currentBlock = world.getBlock(x1, y, z1);
                        if ((currentBlock == Blocks.grass || currentBlock == ModBlocks.salt_grass)
                            && world.getBlock(x, y, z) == ModBlocks.salt_dirt_lite
                            && world.getBlockLightValue(x, y + 1, z) > 7
                            && random.nextInt(5) == 0) {
                            world.setBlock(x, y, z, ModBlocks.salt_grass, metadata, 3);
                        }
                    }
                }
            }
        }
    }
}
