package darkbum.saltymod.block.itemblock;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.IIcon;

public class ItemBlockMarshReeds extends ItemBlock {

    private IIcon marsh_reeds;

    public ItemBlockMarshReeds(Block block) {
        super(block);
        setHasSubtypes(false);
        setMaxStackSize(64);
    }

    @Override
    public void registerIcons(IIconRegister register) {
        this.marsh_reeds = register.registerIcon("saltymod:marsh_reeds");
    }

    @Override
    public IIcon getIconFromDamage(int damage) {
        return marsh_reeds;
    }
}
