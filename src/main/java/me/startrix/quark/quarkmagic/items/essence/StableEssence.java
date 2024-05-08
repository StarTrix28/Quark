package me.startrix.quark.quarkmagic.items.essence;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.inventory.ItemStack;

import static me.startrix.quark.quarkmagic.QuarkMagicalItemsDefine.CategoryEssences;
import static me.startrix.quark.quarkmagic.QuarkMagicalItemsDefine.StableEssence;

public class StableEssence extends SlimefunItem {
    public StableEssence() {
        super(CategoryEssences,StableEssence,RecipeType.NULL,new ItemStack[]{null});
    }
}
