package me.startrix.quark.core.utils;

import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class Utils {
    public static ItemStack useOnGroundgetOutput(ItemStack input, Map<ItemStack,ItemStack> recipes) {
        return recipes.getOrDefault(input, null);
    }

}
