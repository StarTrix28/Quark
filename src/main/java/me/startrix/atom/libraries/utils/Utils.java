package me.startrix.atom.libraries.utils;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Map;

public class Utils {
    public static ItemStack useOnGroundgetOutput(ItemStack input, Map<ItemStack,ItemStack> recipes) {
        return recipes.getOrDefault((ItemStack)input, null);
    }
}
