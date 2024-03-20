package me.startrix.quark.quark.tools;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.startrix.quark.define.QuarkItemsDefine;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static me.startrix.quark.define.QuarkItemsDefine.CategoryTools;

public class Hammer extends SlimefunItem {
    public Hammer() {
        super(CategoryTools, QuarkItemsDefine.Hammer,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{null,new ItemStack(Material.IRON_INGOT),null,null,new ItemStack(Material.STICK),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.STICK),null,null});
    }
}
