package darkbum.saltymod.block;

import static darkbum.saltymod.SaltyMod.logger;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.util.ForgeDirection;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.common.config.ModConfigurationBlocks;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModSounds;

public class BlockWetMudBrick extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public BlockWetMudBrick(String name, CreativeTabs tab) {
        super(Material.clay);
        setStepSound(ModSounds.soundTypeWetMudBrick);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(1.0F);
        setResistance(3.0F);
        setHarvestLevel("shovel", 0);
        setTickRandomly(ModConfigurationBlocks.complexMudBricks);
        logger.info("MUD BRICK TICKS RANDOMLY " + ModConfigurationBlocks.complexMudBricks);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return icons[meta % 3];
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1) {
        icons = new IIcon[3];
        for (int i = 0; i < 3; i++) {
            icons[i] = par1.registerIcon("saltymod:wet_mud_bricks_" + i);
        }
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        int meta = world.getBlockMetadata(x, y, z);
        Block blockBelow = world.getBlock(x, y - 1, z);
        // Advance the drying stage without any special math, the block below is fire/lava and should take precedent
        // over all.
        if (blockBelow.getMaterial() == Material.fire || blockBelow.getMaterial() == Material.lava) {
            if (meta == 2) {
                world.setBlock(x, y, z, ModBlocks.dry_mud_brick);// Tada! The drying stage was 2, so this one is
                                                                 // promoted to a fully dried brick!
            } else {
                world.setBlock(x, y, z, this, meta + 1, 2);// Advance the drying stage.
            }
            return;
        }
        if (world.isRaining() && world.canBlockSeeTheSky(x, y + 1, z)) { // It is raining or snowing on this mud block
            BiomeGenBase biome = world.getBiomeGenForCoords(x, z);
            if (biome.rainfall > 0) {
                if (!biome.func_150559_j() && meta > 0) {
                    // If it is raining, reset the mud brick to stage 0
                    world.setBlock(x, y, z, this, 0, 2);
                } // Else if it is snowing, (func_150559_j is the boolean for if it snows here) we basically just don't
                  // run the above so the mud brick stays as-is instead of changing
                return;
            }
        }
        int slowFactor = 0;
        int speedFactor = 0;

        if (!world.isRemote && (world.provider.dimensionId == -1 || rand.nextFloat() < 0.75F) && meta < 3) {
            for (int i = 0; i < 6; i++) {// Iterate 6 times, 1 in each direction for each side of the block.
                ForgeDirection dir = ForgeDirection.getOrientation(i);
                Block nearbyBlock = world.getBlock(x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ);
                if (dir != ForgeDirection.DOWN) {// If it's direction.DOWN we skip it because water below the block
                                                 // isn't touching it
                    if (nearbyBlock.getMaterial() == Material.water) {// If it's water, we reset the brick to stage 0.
                        if (meta > 0) {
                            world.setBlock(x, y, z, this, 0, 2);
                        }
                        return;
                    }
                    // Else if there's some sort of snow atop the block, we stop the drying without resetting the mud
                    // brick stage
                    if (dir == ForgeDirection.UP && nearbyBlock.getMaterial() == Material.snow) {
                        return;
                    }
                }
                if (nearbyBlock instanceof BlockDryMudBrick) {
                    speedFactor++;// We don't need any of the below calculations; if it's a fully dry brick it must be
                                  // ahead, add to the drying speed!
                    continue;
                }
                if (nearbyBlock instanceof BlockWetMudBrick) {
                    int nearbyMeta = world.getBlockMetadata(x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ);

                    // If this one's outside of the drying range or is the same stage as this mud block, don't count it
                    // towards speeding or slowing the drying process.
                    if (nearbyMeta == meta || nearbyMeta > 2) continue;

                    if (nearbyMeta % 3 > meta % 3) {
                        ++speedFactor; // One of the mud bricks nearby is ahead of this one in drying stages, so we make
                                       // this one dry a bit faster.
                    } else {
                        ++slowFactor; // One of the mud bricks nearby is behind this one in drying stages, so we make
                                      // this one dry a bit slower.
                    }
                    // The above hopefully gives it a bit of a smoother look overall.
                }
            }
            float f = (float) (speedFactor + 1) / (float) (speedFactor + slowFactor + 1);
            float g = f * f;
            // And some magic math to determine the final drying chance...
            if (rand.nextFloat() < g) {
                if (meta == 2) {
                    world.setBlock(x, y, z, ModBlocks.dry_mud_brick);// Tada! The drying stage was 2, so this one is
                                                                     // promoted to a fully dried brick!
                } else {
                    world.setBlock(x, y, z, this, meta + 1, 2);// Advance the drying stage.
                }
            }
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int p_149727_6_,
        float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        int meta = world.getBlockMetadata(x, y, z);
        ItemStack stack = entityPlayer.getCurrentEquippedItem();
        if (meta > 0 && meta < 3 && stack != null) {
            Item item = stack.getItem();
            if (stack.getItemDamage() == 0 && item == Items.potionitem
                && (!stack.hasTagCompound() || !stack.getTagCompound()
                    .hasKey("CustomPotionEffects"))) {
                final ItemStack bottle = new ItemStack(Items.glass_bottle);
                if (!entityPlayer.capabilities.isCreativeMode) {
                    if (entityPlayer.getCurrentEquippedItem().stackSize <= 1) {
                        entityPlayer.setCurrentItemOrArmor(0, bottle);
                    } else {
                        entityPlayer.inventory.decrStackSize(entityPlayer.inventory.currentItem, 1);
                        if (!entityPlayer.inventory.addItemStackToInventory(bottle)) {
                            entityPlayer.dropPlayerItemWithRandomChoice(bottle, false);
                        }
                    }
                    world.playSound(
                        x + 0.5D,
                        y + 0.5D,
                        z + 0.5D,
                        "random.splash",
                        0.15F,
                        1.0F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.4F,
                        false);
                    world.setBlock(x, y, z, this, 0, 2);
                    addWaterSplashes(world, x, y, z);
                    return true;
                }
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

            if (l == 0 && !world.getBlock(x, y + 1, z)
                .isOpaqueCube()) {
                d2 = (double) (y + 1) + d0;
            }
            if (l == 1 && !world.getBlock(x, y - 1, z)
                .isOpaqueCube()) {
                d2 = (double) (y) - d0;
            }
            if (l == 2 && !world.getBlock(x, y, z + 1)
                .isOpaqueCube()) {
                d3 = (double) (z + 1) + d0;
            }
            if (l == 3 && !world.getBlock(x, y, z - 1)
                .isOpaqueCube()) {
                d3 = (double) (z) - d0;
            }
            if (l == 4 && !world.getBlock(x + 1, y, z)
                .isOpaqueCube()) {
                d1 = (double) (x + 1) + d0;
            }
            if (l == 5 && !world.getBlock(x - 1, y, z)
                .isOpaqueCube()) {
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
