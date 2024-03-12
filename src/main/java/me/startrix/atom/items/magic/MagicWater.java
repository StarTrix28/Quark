package me.startrix.atom.items.magic;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import static me.startrix.atom.ItemsDefine.*;
public class MagicWater extends SlimefunItem {

    public MagicWater() {
        super(CategoryMagic,MagicWater,new RecipeType(new CustomItemStack(Material.CAULDRON,"Magical Crucible"),"magiccrucible"),new ItemStack[]{new ItemStack(Material.WATER_BUCKET),MagicalEssence});
    }

    @Override
    public void preRegister() {
        super.preRegister();
        ItemUseHandler handler1 = this::RightClick;
        this.addItemHandler(handler1);
    }

    private void RightClick(PlayerRightClickEvent event) {
        event.cancel();
    }
}
