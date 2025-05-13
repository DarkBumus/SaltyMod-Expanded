package darkbum.saltymod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.BlockSnowBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.common.config.ModConfigurationBlocks;
import darkbum.saltymod.init.ModBlocks;

import static darkbum.saltymod.SaltyMod.*;
import static darkbum.saltymod.util.BlockUtil.*;

public class BlockWetMudBrick extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public BlockWetMudBrick(String name, CreativeTabs tab) {
        super(Material.clay);
        setBlockName(name);
        setCreativeTab(tab);
        setTickRandomly(ModConfigurationBlocks.complexMudBricks);
        logger.info("MUD BRICK TICKS RANDOMLY {}", ModConfigurationBlocks.complexMudBricks);
        propertiesWetMudBrick(this);
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon The icon register used to load textures.
     */
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        icons = new IIcon[3];
        for (int i = 0; i < 3; i++) {
            icons[i] = icon.registerIcon("saltymod:wet_mud_bricks_" + i);
        }
    }

    /**
     * Returns the appropriate icon for a given side and metadata value.
     *
     * @param side The side of the block being rendered.
     * @param meta The metadata of the block.
     * @return the icon to render.
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return icons[meta % 3];
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
        int meta = world.getBlockMetadata(x, y, z);
        Block blockBelow = world.getBlock(x, y - 1, z);

        if (isHeated(blockBelow)) {
            advanceDrying(world, x, y, z, meta);
            return;
        }

        if (isRainingAbove(world, x, y, z)) {
            world.setBlock(x, y, z, this, 0, 2);
            return;
        }

        if (isSnowingAbove(world, x, y, z)) {
            return;
        }

        if (!world.isRemote && shouldDry(world, rand, meta)) {
            int[] factors = calculateFactors(world, x, y, z, meta);
            float dryingChance = calculateDryingChance(factors[0], factors[1], ModConfigurationBlocks.mudBricksDryingSpeed);

            if (rand.nextFloat() < dryingChance) {
                advanceDrying(world, x, y, z, meta);
            }
        }
    }

    /**
     * Checks if the block below is a heat source.
     */
    private boolean isHeated(Block blockBelow) {
        Material material = blockBelow.getMaterial();
        return material == Material.fire || material == Material.lava;
    }

    /**
     * Advances the drying process or converts to a dry mud brick.
     */
    private void advanceDrying(World world, int x, int y, int z, int meta) {
        if (meta == 2) {
            world.setBlock(x, y, z, ModBlocks.dry_mud_brick);
        } else {
            world.setBlock(x, y, z, this, meta + 1, 2);
        }
    }

    /**
     * Checks if it is raining above the block.
     */
    private boolean isRainingAbove(World world, int x, int y, int z) {
        return world.isRaining() && world.canBlockSeeTheSky(x, y + 1, z)
            && world.getBiomeGenForCoords(x, z).rainfall > 0
            && !world.getBiomeGenForCoords(x, z).func_150559_j();
    }

    /**
     * Checks if it is snowing above the block.
     */
    private boolean isSnowingAbove(World world, int x, int y, int z) {
        Block blockAbove = world.getBlock(x, y + 1, z);

        if (blockAbove instanceof BlockSnow || blockAbove instanceof BlockSnowBlock) {
            return true;
        }

        return world.getBiomeGenForCoords(x, z).getFloatTemperature(x, y, z) <= 0.15F
            && world.canBlockSeeTheSky(x, y + 1, z)
            && world.isRaining();
    }

    /**
     * Determines whether the block should proceed with the drying process.
     */
    private boolean shouldDry(World world, Random rand, int meta) {
        return (world.provider.dimensionId == -1 || rand.nextFloat() < 0.75F) && meta < 3;
    }

    /**
     * Calculates speed and slow factors for the drying process.
     */
    private int[] calculateFactors(World world, int x, int y, int z, int meta) {
        int speedFactor = 0;
        int slowFactor = 0;

        for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
            Block nearbyBlock = world.getBlock(x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ);

            if (dir != ForgeDirection.DOWN && nearbyBlock.getMaterial() == Material.water) {
                world.setBlock(x, y, z, this, 0, 2);
                return new int[]{0, 0};
            }

            if (dir == ForgeDirection.UP && nearbyBlock.getMaterial() == Material.snow) {
                return new int[]{0, 0};
            }

            if (nearbyBlock instanceof BlockDryMudBrick) {
                speedFactor++;
            } else if (nearbyBlock instanceof BlockWetMudBrick) {
                int nearbyMeta = world.getBlockMetadata(x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ);
                if (nearbyMeta % 3 > meta % 3) {
                    speedFactor++;
                } else if (nearbyMeta % 3 < meta % 3) {
                    slowFactor++;
                }
            }
        }
        return new int[]{speedFactor, slowFactor};
    }

    /**
     * Calculates the chance of drying based on speed and slow factors.
     */
    private float calculateDryingChance(int speedFactor, int slowFactor, int dryingSpeedModifier) {
        float baseChance = (float) (speedFactor + 1) / (float) (speedFactor + slowFactor + 1);
        float modifier = 1.0F / dryingSpeedModifier;
        float adjustedChance = baseChance * baseChance * modifier;

        return MathHelper.clamp_float(adjustedChance, 0.0F, 1.0F);
    }

    /**
     * Handles right-click interaction with the block.
     *
     * @param player    The player interacting with the block.
     * @param side      The side the block is interacted with.
     * @param hitX      The x-coordinate of the hit location on the block.
     * @param hitY      The y-coordinate of the hit location on the block.
     * @param hitZ      The z-coordinate of the hit location on the block.
     * @return true, if a GUI was opened, false otherwise
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        int meta = world.getBlockMetadata(x, y, z);
        ItemStack stack = player.getCurrentEquippedItem();

        if (meta > 0 && meta < 3 && stack != null) {
            Item item = stack.getItem();

            if (stack.getItemDamage() == 0 && item == Items.potionitem &&
                (!stack.hasTagCompound() || !stack.getTagCompound().hasKey("CustomPotionEffects"))) {

                player.swingItem();

                final ItemStack bottle = new ItemStack(Items.glass_bottle);
                if (!player.capabilities.isCreativeMode) {
                    if (player.getCurrentEquippedItem().stackSize <= 1) {
                        player.setCurrentItemOrArmor(0, bottle);
                    } else {
                        player.inventory.decrStackSize(player.inventory.currentItem, 1);
                        if (!player.inventory.addItemStackToInventory(bottle)) {
                            player.dropPlayerItemWithRandomChoice(bottle, false);
                        }
                    }
                }

                world.playSound(x + 0.5D, y + 0.5D, z + 0.5D, "random.splash", 0.15F, 1.0F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.4F, false);
                world.setBlock(x, y, z, this, 0, 2);
                addWaterSplashes(world, x, y, z);

                return true;
            }
        }
        return false;
    }

    private void addWaterSplashes(World world, int x, int y, int z) {
        Random random = world.rand;
        double d0 = 0.0625D;

        for (int l = 0; l < 32; ++l) {
            double d1 = (float) x + random.nextDouble();
            double d2 = (float) y + random.nextDouble();
            double d3 = (float) z + random.nextDouble();

            if (l == 0 && !world.getBlock(x, y + 1, z).isOpaqueCube()) {
                d2 = (double) (y + 1) + d0;
            }
            if (l == 1 && !world.getBlock(x, y - 1, z).isOpaqueCube()) {
                d2 = (double) (y) - d0;
            }
            if (l == 2 && !world.getBlock(x, y, z + 1).isOpaqueCube()) {
                d3 = (double) (z + 1) + d0;
            }
            if (l == 3 && !world.getBlock(x, y, z - 1).isOpaqueCube()) {
                d3 = (double) (z) - d0;
            }
            if (l == 4 && !world.getBlock(x + 1, y, z).isOpaqueCube()) {
                d1 = (double) (x + 1) + d0;
            }
            if (l == 5 && !world.getBlock(x - 1, y, z).isOpaqueCube()) {
                d1 = (double) (x) - d0;
            }
            if (d1 < (double) x || d1 > (double) (x + 1)
                || d2 < 0.0D
                || d2 > (double) (y + 1)
                || d3 < (double) z
                || d3 > (double) (z + 1)) {
                world.spawnParticle("splash", d1, d2, d3, 0.0D, 0.0D, 0.0D);
            }
        }
    }
}
