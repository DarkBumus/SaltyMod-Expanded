package darkbum.saltymod.block;

import java.util.Random;

import darkbum.saltymod.util.BlockHelper;
import net.minecraft.block.*;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.common.proxy.ClientProxy;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;

import static darkbum.saltymod.util.BlockHelper.*;

/**
 * Block class for the salt grass block.
 * The salt grass is a regular block with multiple variations.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class BlockSaltGrass extends Block implements IGrowable {

    @SideOnly(Side.CLIENT)
    private IIcon iconTop;

    @SideOnly(Side.CLIENT)
    private IIcon iconSide;

    @SideOnly(Side.CLIENT)
    private IIcon iconSideL;

    @SideOnly(Side.CLIENT)
    private IIcon iconSideR;

    @SideOnly(Side.CLIENT)
    private IIcon iconBottom0;

    @SideOnly(Side.CLIENT)
    private IIcon iconBottom1;

    /**
     * Constructs a new block instance with a given name and a creative tab.
     * <p>
     * Also assigns a material and other base properties through {@link BlockHelper}.
     *
     * @param name The internal name of the block.
     * @param tab  The creative tab in which the block appears.
     */
    public BlockSaltGrass(String name, CreativeTabs tab) {
        super(Material.grass);
        setBlockName(name);
        setCreativeTab(tab);
        setTickRandomly(true);
        propertiesSaltGrass(this);
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon The icon register used to load textures.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.blockIcon = icon.registerIcon("saltymod:salt_grass");
        this.iconTop = icon.registerIcon("saltymod:salt_grass_top");
        this.iconSide = icon.registerIcon("saltymod:salt_grass_saltside");
        this.iconSideL = icon.registerIcon("saltymod:salt_grass_saltside_l");
        this.iconSideR = icon.registerIcon("saltymod:salt_grass_saltside_r");
        this.iconBottom0 = icon.registerIcon("saltymod:salt_dirt_lite_0");
        this.iconBottom1 = icon.registerIcon("saltymod:salt_dirt_lite_bottom");
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
        IIcon[] icons = {this.iconSide, this.iconSideL, this.iconSideR, this.iconBottom1, this.iconBottom0, this.iconTop};

        switch (side) {
            case 1:
                return icons[5];
            case 0:
                if (meta > 0) {
                    return icons[3];
                } else {
                    return icons[4];
                }
            case 2:
                if (meta == 7 || meta == 11 || meta == 14 || meta == 15) {
                    return icons[0];
                } else if (meta == 3 || meta == 8 || meta == 12) {
                    return icons[1];
                } else if (meta == 6 || meta == 10 || meta == 13) {
                    return icons[2];
                }
                break;
            case 5:
                if (meta == 8 || meta == 11 || meta == 12 || meta == 15) {
                    return icons[0];
                } else if (meta == 4 || meta == 9 || meta == 13) {
                    return icons[1];
                } else if (meta == 3 || meta == 7 || meta == 14) {
                    return icons[2];
                }
                break;
            case 3:
                if (meta == 9 || meta == 12 || meta == 13 || meta == 15) {
                    return icons[0];
                } else if (meta == 5 || meta == 10 || meta == 14) {
                    return icons[1];
                } else if (meta == 4 || meta == 8 || meta == 11) {
                    return icons[2];
                }
                break;
            case 4:
                if (meta == 10 || meta == 13 || meta == 14 || meta == 15) {
                    return icons[0];
                } else if (meta == 6 || meta == 7 || meta == 11) {
                    return icons[1];
                } else if (meta == 5 || meta == 9 || meta == 12) {
                    return icons[2];
                }
                break;
        }
        return this.blockIcon;
    }

    /**
     * Gets the render type for this block.
     *
     * @return a custom render type ID, provided by the client proxy.
     */
    @Override
    public int getRenderType() {
        return ClientProxy.saltGrassRenderType;
    }

    /**
     * Returns the map color used for this block in maps.
     *
     * @param meta The metadata of the block.
     * @return the map color.
     */
    @Override
    public MapColor getMapColor(int meta) {
        return MapColor.grassColor;
    }

    /**
     * Returns the color of the block, determined by the grass colorizer.
     * This method is typically used for the block's coloring.
     * It calculates the grass color based on two constant values and calls
     * the {@link ColorizerGrass#getGrassColor(double, double)} method to get the final color.
     *
     * @return The calculated color of the block in RGB format, as an integer.
     */
    @SideOnly(Side.CLIENT)
    public int getBlockColor() {
        double d0 = 0.5D;
        double d1 = 1.0D;
        return ColorizerGrass.getGrassColor(d0, d1);
    }

    /**
     * Calculates the color modification of a block based on its position in the world.
     * This method is called to compute color modifications for blocks on the client side.
     * In this implementation, the method always returns the value {@code 16777215}, which corresponds to white color.
     *
     * @param world The world the block is in.
     * @param x     The x-coordinate of the block.
     * @param y     The y-coordinate of the block.
     * @param z     The z-coordinate of the block.
     * @return the calculated color of the block, as an integer in RGB format. In this implementation, always {@code 16777215} (white).
     */
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess world, int x, int y, int z) {
        return 16777215;
    }

    /**
     * Handles right-click interaction with the block.
     *
     * @param player The player interacting with the block.
     * @return true, if the block was successfully stripped, false otherwise.
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        ItemStack currentItem = player.getCurrentEquippedItem();

        if (currentItem != null && currentItem.getItem() instanceof ItemHoe) {
            if (!world.isRemote) {
                world.setBlock(x, y, z, Blocks.farmland);
                world.spawnEntityInWorld(new EntityItem(world, x + 0.5, y + 1, z + 0.5, new ItemStack(ModItems.salt_pinch)));
            }
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
     * @param random The random number generator for events like crystal growth.
     */
    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
        if (world.isRemote) return;

        int meta = world.getBlockMetadata(x, y, z);
        Block blockAbove = world.getBlock(x, y + 1, z);
        Material materialAbove = blockAbove.getMaterial();

        if (blockAbove == Blocks.snow_layer) world.setBlockToAir(x, y + 1, z);

        if (world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2)
            world.setBlock(x, y, z, ModBlocks.salt_dirt_lite, meta, 3);

        else if (!materialAbove.isSolid() && world.getBlockLightValue(x, y + 1, z) >= 9) {
            for (int l = 0; l < 4; l++) {
                int offsetX = x + random.nextInt(3) - 1;
                int offsetY = y + random.nextInt(5) - 3;
                int offsetZ = z + random.nextInt(3) - 1;

                if (world.getBlock(offsetX, offsetY, offsetZ) == ModBlocks.salt_dirt_lite
                    && world.getBlockMetadata(offsetX, offsetY, offsetZ) == 0
                    && world.getBlockLightValue(offsetX, offsetY + 1, offsetZ) >= 4
                    && world.getBlockLightOpacity(offsetX, offsetY + 1, offsetZ) <= 2) {
                    world.setBlock(offsetX, offsetY, offsetZ, ModBlocks.salt_grass);
                }
                if (world.getBlock(offsetX, offsetY, offsetZ) == Blocks.dirt && world.getBlockMetadata(offsetX, offsetY, offsetZ) == 0
                    && world.getBlockLightValue(offsetX, offsetY + 1, offsetZ) >= 4
                    && world.getBlockLightOpacity(offsetX, offsetY + 1, offsetZ) <= 2) {
                    world.setBlock(offsetX, offsetY, offsetZ, Blocks.grass);
                }
            }
        }
    }

    @Override
    public boolean func_149851_a(World world, int x, int y, int z, boolean flag) {
        return true;
    }

    @Override
    public boolean func_149852_a(World world, Random random, int x, int y, int z) {
        return true;
    }

    @Override
    public void func_149853_b(World world, Random random, int x, int y, int z) {
        for (int iteration = 0; iteration < 128; iteration++) {
            int currentX = x;
            int currentY = y + 1;
            int currentZ = z;

            int tries = 0;

            while (tries < iteration / 16) {
                currentX += random.nextInt(3) - 1;
                currentY += (random.nextInt(3) - 1) * random.nextInt(3) / 2;
                currentZ += random.nextInt(3) - 1;

                if ((world.getBlock(currentX, currentY - 1, currentZ) instanceof BlockGrass || world.getBlock(currentX, currentY - 1, currentZ) == this)
                    && !world.getBlock(currentX, currentY, currentZ).isNormalCube()) {
                    tries++;
                    continue;
                }
                break;
            }
            if (world.getBlock(currentX, currentY, currentZ).getMaterial() == Material.air) {
                if (random.nextInt(8) != 0) {
                    if (Blocks.tallgrass.canBlockStay(world, currentX, currentY, currentZ)) {
                        world.setBlock(currentX, currentY, currentZ, Blocks.tallgrass, 1, 3);
                    }
                } else {
                    world.getBiomeGenForCoords(currentX, currentZ).plantFlower(world, random, currentX, currentY, currentZ);
                }
            }
        }
    }

    /**
     * Whether this block can support a given plant.
     *
     * @param world         The block access object.
     * @param x             The x-coordinate of the block.
     * @param y             The y-coordinate of the block.
     * @param z             The z-coordinate of the block.
     * @param direction     The planting direction.
     * @param plantable     The plant to check.
     * @return true, if the plant can be sustained, false otherwise.
     */
    @Override
    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable) {
        Block plant = plantable.getPlant(world, x, y + 1, z);
        if (plantable == Blocks.reeds || plantable == Blocks.cactus || plantable == Blocks.deadbush) {
            return false;
        }
        return !(plant instanceof BlockCrops) && !(plant instanceof BlockStem) && !(plant instanceof BlockNetherWart);
    }
}
