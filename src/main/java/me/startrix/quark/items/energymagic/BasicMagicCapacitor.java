package me.startrix.quark.items.energymagic;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.inventory.ItemStack;

import static me.startrix.quark.ItemsDefine.*;

public class BasicMagicCapacitor extends SlimefunItem {

    public BasicMagicCapacitor() {
        super(CategoryEnergyMagic,Basic_Magic_Capacitor,RecipeType.MAGIC_WORKBENCH,new ItemStack[]{null,null,null,null,Steel_Cage,null,null,null,null});
    }
}
