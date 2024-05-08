package me.startrix.quark.quarkmagic.block;

import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.startrix.quark.core.abstracts.NoPowerAContainer;
import me.startrix.quark.quarkmagic.QuarkMagicalItemsDefine;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import static me.startrix.quark.quarkmagic.QuarkMagicalItemsDefine.CategoryMagicalMachines;

public class ResearchHub extends NoPowerAContainer {
    public ResearchHub() {
        super(CategoryMagicalMachines, QuarkMagicalItemsDefine.ResearchHub,RecipeType.NULL,new ItemStack[]{null});
    }
    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.LIGHT);
    }

    @NotNull
    @Override
    public String getMachineIdentifier() {
        return "RESEARCH_HUB";
    }

    @NotNull
    @Override
    public String getInventoryTitle() {
        return "Research Hub";
    }
}
