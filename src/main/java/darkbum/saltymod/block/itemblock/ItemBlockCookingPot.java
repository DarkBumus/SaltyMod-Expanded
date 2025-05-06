package darkbum.saltymod.block.itemblock;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.IIcon;

public class ItemBlockCookingPot extends ItemBlock {

    private IIcon cooking_pot;

    public ItemBlockCookingPot(Block block) {
        super(block);
        setHasSubtypes(false);
        setMaxStackSize(1);
    }

    @Override
    public void registerIcons(IIconRegister register) {
        this.cooking_pot = register.registerIcon("saltymod:cooking_pot");
    }

    @Override
    public IIcon getIconFromDamage(int damage) {
        return cooking_pot;
    }
}
