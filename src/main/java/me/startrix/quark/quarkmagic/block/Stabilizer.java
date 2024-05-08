package me.startrix.quark.quarkmagic.block;

import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.startrix.quark.quarkmagic.QuarkMagicalItemsDefine;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import static me.startrix.quark.quarkmagic.QuarkMagicalItemsDefine.CategoryMagicalMachines;

public class Stabilizer extends AContainer {
    protected Stabilizer() {
        super(CategoryMagicalMachines, QuarkMagicalItemsDefine.Stabilizer,RecipeType.NULL,new ItemStack[]{null});
    }

    @Override
    public ItemStack getProgressBar() {
        return null;
    }

    @NotNull
    @Override
    public String getMachineIdentifier() {
        return null;
    }
}
