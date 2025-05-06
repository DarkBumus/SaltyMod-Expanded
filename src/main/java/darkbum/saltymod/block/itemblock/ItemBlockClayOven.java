package darkbum.saltymod.block.itemblock;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.IIcon;

public class ItemBlockClayOven extends ItemBlock {

    private IIcon clay_oven;

    public ItemBlockClayOven(Block block) {
        super(block);
        setHasSubtypes(false);
        setMaxStackSize(1);
    }

    @Override
    public void registerIcons(IIconRegister register) {
        this.clay_oven = register.registerIcon("saltymod:clay_oven");
    }

    @Override
    public IIcon getIconFromDamage(int damage) {
        return clay_oven;
    }
}
