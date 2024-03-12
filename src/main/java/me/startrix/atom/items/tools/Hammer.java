package me.startrix.atom.items.tools;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.startrix.atom.ItemsDefine;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static me.startrix.atom.ItemsDefine.CategoryTools;

public class Hammer extends SlimefunItem {
    public Hammer() {
        super(CategoryTools, ItemsDefine.Hammer,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{null,new ItemStack(Material.IRON_INGOT),null,null,new ItemStack(Material.STICK),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.STICK),null,null});
    }
}
