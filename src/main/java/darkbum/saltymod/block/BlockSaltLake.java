package darkbum.saltymod.block;

import java.util.Random;

import darkbum.saltymod.util.BlockUtils;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.init.ModBlocks;

import static darkbum.saltymod.block.BlockSaltBlock.*;
import static darkbum.saltymod.util.BlockUtils.*;

/**
 * Block class for the salt lake block.
 * The salt lake is a regular block with multiple variations.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class BlockSaltLake extends BlockSaltOre {

    @SideOnly(Side.CLIENT)
    private IIcon iconTop;

    @SideOnly(Side.CLIENT)
    private IIcon iconSide;

    /**
     * Constructs a new block instance with a given name and a creative tab.
     * <p>
     * Also assigns a material and other base properties through {@link BlockUtils}.
     *
     * @param name The internal name of the block.
     * @param tab  The creative tab in which the block appears.
     */
    public BlockSaltLake(String name, CreativeTabs tab) {
        super(name, tab);
        setTickRandomly(true);
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon The icon register used to load textures.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        blockIcon = icon.registerIcon("saltymod:salt_lake_ore");
        iconTop = icon.registerIcon("saltymod:salt_lake_ore_top");
        iconSide = icon.registerIcon("saltymod:salt_lake_ore_side");
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
        return (side == 1) ? this.iconTop
            : ((side == 0) ? ModBlocks.salt_ore.getBlockTextureFromSide(side)
            : (((side == 2 && meta % 2 == 1) || (side == 5 && meta % 4 >= 2)
            || (side == 3 && meta % 8 >= 4)
            || (side == 4 && meta >= 8)) ? this.iconSide : this.blockIcon));
    }

    /**
     * Returns the map color used for this block in maps.
     *
     * @param meta The metadata of the block.
     * @return the map color.
     */
    @Override
    public MapColor getMapColor(int meta) {
        return MapColor.quartzColor;
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

        checkAndDamageNearbyEntities(world, x, y, z, this);
        tryMeltIceAndSnow(world, x, y, z, rand, this);
        crystal = false;
    }

    /**
     * Handles the effect when an entity walks on this block.
     * This method is used to apply effects or trigger actions when an entity steps on the block.
     *
     * @param entity The entity that is walking on the block.
     */
    @Override
    public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
        handleEntityWalkingSaltVulnerableUpdate(world, x, y, z, entity, this);
        if (entity instanceof EntityPlayer) {
            ((EntityPlayer) entity).addStat(ModAchievementList.nav_salt_lake, 1);
        }
    }
}
