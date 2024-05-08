package me.startrix.quark.quarkmagic.items.essence;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.startrix.quark.quarkmagic.QuarkMagicalItemsDefine;
import org.bukkit.inventory.ItemStack;

import static me.startrix.quark.quarkmagic.QuarkMagicalItemsDefine.CategoryEssences;

public class HotEssence extends SlimefunItem {
    public HotEssence() {
        super(CategoryEssences, QuarkMagicalItemsDefine.HotEssence, RecipeType.NULL,new ItemStack[]{null});
    }
}
