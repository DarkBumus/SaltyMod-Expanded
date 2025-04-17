/*package darkbum.saltymod.item;

import java.util.*;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import darkbum.saltymod.api.SaltFoodData;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.item.EnumAction;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.potion.ProbablePotionEffect;

public class ItemMetaSaltFood extends ItemFood {

    private final Map<Integer, IIcon> icons = new HashMap<>();
    private final Map<Integer, SaltFoodData> metaSaltFoodData = new HashMap<>();
    private EnumAction action = EnumAction.eat;

    public ItemMetaSaltFood(String baseName) {
        super(0, 0.0F, false); // Dummy-Werte – echte kommen aus Map
        setHasSubtypes(true);
        setUnlocalizedName(baseName);
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {
        for (Map.Entry<Integer, SaltFoodData> entry : metaSaltFoodData.entrySet()) {
            int meta = entry.getKey();
            SaltFoodData data = entry.getValue();
            String iconPath = "saltymod:" + data.unlocalizedName; // z.B. saltymod:pumpkin_porridge
            icons.put(meta, register.registerIcon(iconPath));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return icons.containsKey(meta) ? icons.get(meta) : itemIcon;
    }

    public ItemMetaSaltFood addVariant(int meta, String unlocalizedName, int amount, float saturation,
                                   Item container, boolean visibleInCreativeTab, CreativeTabs creativeTab,
                                   ProbablePotionEffect... effects) {
        metaSaltFoodData.put(meta, new SaltFoodData(unlocalizedName, amount, saturation, container,
            visibleInCreativeTab, creativeTab, effects));

        // Stelle sicher, dass der Tab wirklich übergeben wird
        if (visibleInCreativeTab && creativeTab != null) {
            setCreativeTab(creativeTab);  // Dies könnte nötig sein
        }

        return this;
    }

    public ItemMetaSaltFood setItemUseAction(EnumAction action) {
        this.action = action;
        return this;
    }

    private SaltFoodData getSaltFoodData(ItemStack stack) {
        return metaSaltFoodData.get(stack.getItemDamage());
    }

    @Override
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
        SaltFoodData data = getSaltFoodData(stack);

        if (!world.isRemote && data != null) {
            // Nahrungswert manuell anwenden
            player.getFoodStats().addStats(data.healAmount, data.saturation);

            // Effekte auftragen
            for (ProbablePotionEffect effect : data.effects) {
                effect.procEffect(player, itemRand);
            }

            // Spezialverhalten für Salz-Ei
            if (ModItems.salt_egg != null && getUnlocalizedName(stack).equals(ModItems.salt_egg.getUnlocalizedName())) {
                world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ,
                    new ItemStack(Items.dye, 1, 15)));
            }
        }

        // Container zurückgeben
        return data != null && data.container != null ? new ItemStack(data.container) : stack;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        SaltFoodData data = getSaltFoodData(stack);
        return data != null ? "item." + data.unlocalizedName : super.getUnlocalizedName();
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> list) {
        for (Map.Entry<Integer, SaltFoodData> entry : metaSaltFoodData.entrySet()) {
            SaltFoodData data = entry.getValue();

            // Überprüfen, ob das Item eine Textur hat und richtig für den Tab angezeigt werden soll
            if (data.visibleInCreativeTab && (data.creativeTab == null || data.creativeTab == tab)) {
                if (icons.containsKey(entry.getKey())) {
                    ItemStack stack = new ItemStack(item, 1, entry.getKey());
                    list.add(stack);
                } else {
                    // Optional: Debugging - Verhindere Geisteritems
                    System.out.println("Item missing texture for meta: " + entry.getKey());
                }
            }
        }
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {
        super.addInformation(stack, player, list, advanced);
        SaltFoodData data = getSaltFoodData(stack);
        if (data != null) {
            for (ProbablePotionEffect effect : data.effects) {
                list.add(effect.generateTooltip());
            }
        }
    }
}*/
