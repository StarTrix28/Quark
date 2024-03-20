package me.startrix.quark.libraries;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import org.bukkit.inventory.ItemStack;

public class LiquidBucketItem extends UnstableItem {
    public LiquidBucketItem(ItemGroup itemGroup, SlimefunItemStack item, int stability, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, stability, recipeType, recipe);
    }
    @Override
    public void preRegister() {
        super.preRegister();
        ItemUseHandler handler1 = this::RightClick;
        this.addItemHandler(handler1);
    }

    protected void RightClick(PlayerRightClickEvent event) {
        event.cancel();
    }
}
