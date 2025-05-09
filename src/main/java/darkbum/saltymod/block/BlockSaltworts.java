package darkbum.saltymod.block;

import java.util.ArrayList;
import java.util.Random;

import darkbum.saltymod.util.BlockHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.common.config.ModConfigurationBlocks;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;

import static darkbum.saltymod.util.BlockHelper.*;

/**
 * Block class for the saltworts block.
 * The saltworts are an irregular crop block.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class BlockSaltworts extends BlockBush implements IGrowable {

    @SideOnly(Side.CLIENT)
    private IIcon iconStage1;

    @SideOnly(Side.CLIENT)
    private IIcon iconStage2;

    @SideOnly(Side.CLIENT)
    private IIcon iconStage3;

    @SideOnly(Side.CLIENT)
    private IIcon iconStage4;

    @SideOnly(Side.CLIENT)
    private IIcon iconDead;

    /**
     * Constructs a new block instance with a given name and a creative tab.
     * <p>
     * Also assigns a material and other base properties through {@link BlockHelper}.
     *
     * @param name The internal name of the block.
     * @param tab  The creative tab in which the block appears.
     */
    public BlockSaltworts(String name, CreativeTabs tab) {
        setBlockName(name);
        setCreativeTab(tab);
        setTickRandomly(true);
        setBlockTextureName("saltymod:saltwort");
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
        this.blockIcon = icon.registerIcon(getTextureName() + "_0");
        this.iconStage1 = icon.registerIcon(getTextureName() + "_1");
        this.iconStage2 = icon.registerIcon(getTextureName() + "_2");
        this.iconStage3 = icon.registerIcon(getTextureName() + "_3");
        this.iconStage4 = icon.registerIcon(getTextureName() + "_4");
        this.iconDead = icon.registerIcon(getTextureName() + "_5");
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
        if (meta < 0 || meta > 5) meta = 0;
        return (meta == 1) ? this.iconStage1
            : ((meta == 2) ? this.iconStage2
            : ((meta == 3) ? this.iconStage3
            : ((meta == 4) ? this.iconStage4 : ((meta == 5) ? this.iconDead : this.blockIcon))));
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
        float g = 0.375F;
        float v = 0.625F;
        if (meta == 1) {
            v = 0.5F;
        }
        if (meta == 2) {
            g = 0.3125F;
            v = 0.375F;
        }
        if (meta == 3) {
            g = 0.25F;
            v = 0.25F;
        }
        if (meta == 4) {
            g = 0.1875F;
            v = 0.125F;
        }
        if (meta == 5) {
            g = 0.3125F;
            v = 0.5625F;
        }
        setBlockBounds(0.0F + g, 0.0F, 0.0F + g, 1.0F - g, 1.0F - v, 1.0F - g);
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
        return new ItemStack(ModItems.saltwort);
    }

    /**
     * Whether this block can stay at the specified coordinates.
     *
     * @return true if the block can stay, false otherwise.
     */
    @Override
    public boolean canBlockStay(World world, int x, int y, int z) {
        Block blockBelow = world.getBlock(x, y - 1, z);
        Material materialBelow = blockBelow.getMaterial();

        return ((materialBelow == Material.grass
            || (materialBelow == Material.ground && blockBelow != ModBlocks.salt_dirt)
            || (blockBelow == ModBlocks.salt_dirt
            && world.getBlockMetadata(x, y - 1, z) == 0))
            && World.doesBlockHaveSolidTopSurface(world, x, y - 1, z));
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
        if (world.isRemote) return false;

        ItemStack heldItem = player.getCurrentEquippedItem();
        int meta = world.getBlockMetadata(x, y, z);

        if (meta == 4 && heldItem != null && heldItem.getItem() == Items.shears) {
            world.setBlock(x, y, z, ModBlocks.saltworts, 2, 3);

            int dropCount = getDropCount(heldItem);
            ItemStack dropItem = new ItemStack(ModItems.saltwort, dropCount);

            spawnEntityItem(world, x, y, z, dropItem);

            world.playSoundEffect(x + 0.5D, y + 1.0D, z + 0.5D, "saltymod:item.shears.shear", 1.0F, 1.2F);

            damageShears(player, heldItem);
        }
        return false;
    }

    /**
     * Calculates the drop count based on Fortune enchantment level.
     */
    private int getDropCount(ItemStack shears) {
        Random rand = new Random();
        int baseDrop = rand.nextInt(3) + 1;
        int fortuneLevel = EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, shears);

        if (fortuneLevel > 0) {
            return rand.nextInt(5 - fortuneLevel) + fortuneLevel;
        }
        return baseDrop;
    }

    /**
     * Spawns an entity item in the world at the given coordinates.
     */
    private void spawnEntityItem(World world, int x, int y, int z, ItemStack itemStack) {
        EntityItem entityItem = new EntityItem(world, x + 0.5D, y + 0.5D, z + 0.5D, itemStack);
        entityItem.delayBeforeCanPickup = 10;
        world.spawnEntityInWorld(entityItem);
    }

    /**
     * Damages the shears by 1 and removes them if durability is exceeded.
     */
    private void damageShears(EntityPlayer player, ItemStack shears) {
        if (!player.capabilities.isCreativeMode) {
            shears.damageItem(1, player);
            if (shears.getItemDamage() > shears.getMaxDamage()) {
                shears.stackSize--;
            }
        }
    }

    @Override
    protected boolean canSilkHarvest() {
        return false;
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
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune) {
        ArrayList<ItemStack> drop = new ArrayList<>();
        Random random = new Random();
        if (meta <= 1) drop.add(new ItemStack(ModItems.saltwort));
        if (meta == 2) {
            int i = random.nextInt(2) + 1;
            drop.add(new ItemStack(ModItems.saltwort, i));
        }
        if (meta == 3) {
            int i = random.nextInt(3) + 1;
            drop.add(new ItemStack(ModItems.saltwort, i));
        }
        if (meta == 4) {
            int i = random.nextInt(4) + 2;
            drop.add(new ItemStack(ModItems.saltwort, i));
        }
        return drop;
    }

    /**
     * Updates the block's state during a tick.
     * This method is called on each tick to update the block's behavior.
     * It checks for nearby entities, tries to grow salt crystals, and attempts to melt ice or snow.
     *
     * @param rand The random number generator for events like crystal growth.
     */
    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        if (world.isRemote) return;

        Block blockBelow = world.getBlock(x, y - 1, z);
        int metaBelow = world.getBlockMetadata(x, y - 1, z);
        int meta = world.getBlockMetadata(x, y, z);

        if (isValidGround(blockBelow, metaBelow)) {
            if (rand.nextInt(ModConfigurationBlocks.saltwortGrowthSpeed) == 0) {
                handleGrowth(world, x, y, z, meta, blockBelow, metaBelow);
            }
        } else if (rand.nextInt(ModConfigurationBlocks.saltwortGrowthSpeed + 1) == 0) {
            if (meta == 0) {
                world.setBlock(x, y, z, this, 1, 3);
            } else if (meta == 1) {
                world.setBlock(x, y, z, this, 5, 3);
            }
        }
    }

    /**
     * Handles the growth and spread of the Saltwort plant.
     */
    private void handleGrowth(World world, int x, int y, int z, int meta, Block groundBlock, int groundMeta) {
        int light = world.getFullBlockLightValue(x, y, z);

        if (meta == 0) {
            world.setBlock(x, y, z, this, 1, 3);
        } else if (light >= 12) {
            if (meta == 1) {
                world.setBlock(x, y, z, this, 2, 3);
                transformGround(world, x, y - 1, z, groundBlock, groundMeta);
            } else if (meta >= 2 && meta <= 4) {
                growPlant(world, x, y, z, meta);
            }
        }
    }

    /**
     * Grows the plant to the next stage.
     */
    private void growPlant(World world, int x, int y, int z, int meta) {
        switch (meta) {
            case 2:
                world.setBlock(x, y, z, this, 3, 3);
                break;
            case 3:
                world.setBlock(x, y, z, this, 4, 3);
                break;
        }
    }

    public boolean func_149851_a(World world, int x, int y, int z, boolean isClient) {
        return fertilize(world, x, y, z);
    }

    public static boolean fertilize(World world, int x, int y, int z) {
        if (world.isRemote) return false;

        boolean check = false;

        for (int x3 = x - 1; x3 <= x + 1; x3++) {
            for (int z3 = z - 1; z3 <= z + 1; z3++) {
                Block blockBelow = world.getBlock(x3, y - 1, z3);
                int metaBelow = world.getBlockMetadata(x3, y - 1, z3);
                Block block = world.getBlock(x3, y, z3);
                int meta = world.getBlockMetadata(x3, y, z3);

                if (block == ModBlocks.saltworts && meta < 4 && isValidGround(blockBelow, metaBelow)) {
                    int newMeta = meta + 1;
                    world.setBlock(x3, y, z3, ModBlocks.saltworts, newMeta, 3);
                    transformGround(world, x3, y - 1, z3, blockBelow, metaBelow);
                    check = true;

                    world.playSoundEffect(x3, y, z3, "random.bonemeal", 1.0F, 1.0F);
                }
            }
        }
        return check;
    }

    /**
     * Checks if the given block and metadata combination is a valid ground for Saltwort.
     */
    private static boolean isValidGround(Block block, int meta) {
        return (block == ModBlocks.salt_dirt && meta == 0) ||
            (block == ModBlocks.salt_dirt_lite && (meta == 1 || meta == 2));
    }

    /**
     * Transforms the ground based on its current state.
     */
    private static void transformGround(World world, int x, int y, int z, Block groundBlock, int meta) {
        if (groundBlock == ModBlocks.salt_dirt) {
            world.setBlock(x, y, z, ModBlocks.salt_dirt_lite, 2, 3);
        } else if (groundBlock == ModBlocks.salt_dirt_lite) {
            int newMeta = 1;
            world.setBlock(x, y, z, ModBlocks.salt_dirt_lite, newMeta, 3);
        }
    }

    public boolean func_149852_a(World world, Random rand, int x, int y, int z) {
        return false;
    }

    public void func_149853_b(World world, Random rand, int x, int y, int z) {
    }
}
