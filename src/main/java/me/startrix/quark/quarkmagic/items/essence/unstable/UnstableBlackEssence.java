package me.startrix.quark.quarkmagic.items.essence.unstable;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.startrix.quark.quarkmagic.QuarkMagicalItemsDefine;
import org.bukkit.inventory.ItemStack;

import static me.startrix.quark.quarkmagic.QuarkMagicalItemsDefine.CategoryEssences;

public class UnstableBlackEssence extends SlimefunItem {
    public UnstableBlackEssence() {
        super(CategoryEssences, QuarkMagicalItemsDefine.UnstableDarkEssence,RecipeType.NULL,new ItemStack[]{null});
    }
}
