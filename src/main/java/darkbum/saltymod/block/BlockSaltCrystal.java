package darkbum.saltymod.block;

import java.util.ArrayList;

import darkbum.saltymod.util.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;

import static darkbum.saltymod.util.BlockUtil.*;

/**
 * Block class for the salt crystal block.
 * The salt crystal is a regular block with that grows on salt.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class BlockSaltCrystal extends BlockBush {

    protected boolean silkdrop = false;

    @SideOnly(Side.CLIENT)
    private IIcon iconSmall;

    @SideOnly(Side.CLIENT)
    private IIcon iconMedium;

    @SideOnly(Side.CLIENT)
    private IIcon iconLarge;

    /**
     * Constructs a new block instance with a given name and a creative tab.
     * <p>
     * Also assigns a material and other base properties through {@link BlockUtil}.
     *
     * @param name  The internal name of the block.
     * @param tab   The creative tab in which the block appears.
     */
    public BlockSaltCrystal(String name, CreativeTabs tab) {
        setBlockName(name);
        setCreativeTab(tab);
        setBlockTextureName("saltymod:salt_crystal");
        propertiesSaltCrystal(this);
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon  The icon register used to load textures.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.iconLarge = icon.registerIcon(getTextureName() + "_2");
        this.iconMedium = icon.registerIcon(getTextureName() + "_1");
        this.iconSmall = icon.registerIcon(getTextureName() + "_0");
    }

    /**
     * Returns the appropriate icon for a given side and metadata value.
     *
     * @param side  The side of the block being rendered.
     * @param meta  The metadata of the block.
     * @return the icon to render.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        IIcon[] icons = {iconLarge, iconMedium, iconSmall};
        return switch (meta) {
            case 1 -> icons[1];
            case 2 -> icons[2];
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
        float g = 0.125F;
        float v = 0.375F;
        if (meta == 1) v = 0.625F;
        if (meta == 2) v = 0.875F;
        setBlockBounds(0.0F + g, 0.0F, 0.0F + g, 1.0F - g, 1.0F - v, 1.0F - g);
    }

    /**
     * Returns the map color used for this block in maps.
     *
     * @param meta The metadata of the block.
     * @return the map color.
     */
    @Override
    public MapColor getMapColor(int meta) {
        return MapColor.airColor;
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

        return World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) &&
            (blockBelow == ModBlocks.salt_block ||
                blockBelow == ModBlocks.salt_lamp ||
                blockBelow == ModBlocks.salt_lake ||
                (blockBelow == ModBlocks.salt_dirt && metaBelow == 1) ||
                (blockBelow == ModBlocks.salt_brick_stairs && metaBelow >= 4) ||
                (blockBelow == ModBlocks.salt_slab && metaBelow >= 8) ||
                blockBelow == ModBlocks.double_salt_slab);
    }

    /**
     * Called when the block is harvested by the player.
     * If the player is not in creative mode, it applies the "Swarmed" effect to the player when the block is harvested.
     *
     * @param player    The player harvesting the block.
     */
    @Override
    public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
        if (world.isRemote) return;
        if (player.capabilities.isCreativeMode) return;

        ItemStack heldItem = player.getCurrentEquippedItem();
        Block blockBelow = world.getBlock(x, y - 1, z);

        if (heldItem != null && EnchantmentHelper.getEnchantmentLevel(Enchantment.silkTouch.effectId, heldItem) > 0) {
            silkdrop = true;
        }
        if (meta == 0 && (blockBelow == ModBlocks.salt_block || blockBelow == ModBlocks.double_salt_slab)) {
            player.addStat(ModAchievementList.farm_salt, 1);
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
        if (meta == 0) if (silkdrop) {
            drop.add(new ItemStack(ModItems.salt_shard));
        } else {
            drop.add(new ItemStack(ModItems.salt_pinch));
        }
        silkdrop = false;
        return drop;
    }

    /**
     * Handles the effect when an entity collides with this block.
     * This method is used to apply effects or trigger actions when an entity collides with the block.
     *
     * @param entity The entity that is colliding with the block.
     */
    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        if (world.isRemote) return;

        if (entity instanceof EntityLivingBase livingEntity && livingEntity.fallDistance >= 3.0f) {
            int meta = world.getBlockMetadata(x, y, z);
            ItemStack saltDrop = new ItemStack(ModItems.salt_pinch, 1, 0);
            EntityItem saltEntity = new EntityItem(world, x + 0.5, y + 1.0, z + 0.5, saltDrop);
            saltEntity.delayBeforeCanPickup = 10;
            if (meta == 0) {
                world.spawnEntityInWorld(saltEntity);
            }

            world.playSoundEffect(x + 0.5, y + 0.5, z + 0.5, "dig.stone", 2.0f, 1.0f);
            world.playSoundEffect(x + 0.5, y + 0.5, z + 0.5, "dig.glass", 2.0f, 2.0f);

            world.setBlock(x, y, z, Blocks.air, 0, 3);

            float fallDamage = Math.max(0, (entity.fallDistance - 2) * 2.0f);
            if (entity instanceof EntityPlayer player) {
                player.addStat(ModAchievementList.nav_salt_crystal, 1);

                if (player.fallDistance > 3) {
                    player.attackEntityFrom(DamageSource.fall, fallDamage);
                }
            } else if (isSaltVulnerableEntity(entity)) {
                livingEntity.attackEntityFrom(DamageSource.fall, 30.0f);

                EntityPlayer player = world.getClosestPlayerToEntity(entity, 32D);
                if (player != null) {
                    player.addStat(ModAchievementList.navelse_salt_crystal, 1);
                }
            } else if (livingEntity.fallDistance > 3) {
                livingEntity.attackEntityFrom(DamageSource.fall, fallDamage);
            }
        }
    }
}
