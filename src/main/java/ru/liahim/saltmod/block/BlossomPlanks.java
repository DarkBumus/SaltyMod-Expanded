package ru.liahim.saltmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlossomPlanks extends Block {
    public BlossomPlanks(String name, CreativeTabs tab) {
        super(Material.wood);
        setHardness(2.0F);
        setResistance(3.0F);
        setStepSound(soundTypeWood);
        setBlockName(name);
        setCreativeTab(tab);
        setBlockTextureName("saltmod:BlossomPlanks");
    }
}
