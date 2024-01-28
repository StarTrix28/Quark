package me.startrix.quark.items.energymagic;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.inventory.ItemStack;

import static me.startrix.quark.ItemsDefine.*;

public class AdvancedMagicCapacitor extends SlimefunItem {
    public AdvancedMagicCapacitor() {
        super(CategoryEnergyMagic,Advanced_Magic_Capacitor, RecipeType.MAGIC_WORKBENCH,new ItemStack[]{null,null,null,null,Basic_Magic_Capacitor,null,null,null,null});
    }
}
