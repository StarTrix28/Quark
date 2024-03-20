package me.startrix.quark.libraries;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.inventory.ItemStack;

public class UnstableItem extends SlimefunItem {
    private int stability;
    public UnstableItem(ItemGroup itemGroup, SlimefunItemStack item, int stability, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        this.stability = stability;
    }
    public int getStability() {
        return this.stability;
    }
    public void setStability(int n) {
        this.stability = n;
    }
}
