package me.startrix.quark.libraries.utils;

import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class Utils {
    public static ItemStack useOnGroundgetOutput(ItemStack input, Map<ItemStack,ItemStack> recipes) {
        return recipes.getOrDefault((ItemStack)input, null);
    }

}
