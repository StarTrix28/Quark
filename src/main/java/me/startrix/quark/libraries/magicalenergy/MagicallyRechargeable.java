package me.startrix.quark.libraries.magicalenergy;

import io.github.thebusybiscuit.slimefun4.core.attributes.ItemAttribute;
import io.github.thebusybiscuit.slimefun4.libraries.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public interface MagicallyRechargeable extends ItemAttribute {
    float getMaxItemCharge(ItemStack var1);

    default void setItemCharge(ItemStack item, float charge) {
        if (item != null && item.getType() != Material.AIR) {
            float maximum = this.getMaxItemCharge(item);
            if (!(charge < 0.0F) && !(charge > maximum)) {
                ItemMeta meta = item.getItemMeta();
                MagicalChargeUtils.setCharge(meta, charge, maximum);
                item.setItemMeta(meta);
            } else {
                throw new IllegalArgumentException("Charge must be between zero and " + maximum + ".");
            }
        } else {
            throw new IllegalArgumentException("Cannot set Item charge for null or AIR");
        }
    }

    default float getItemCharge(ItemStack item) {
        if (item != null && item.getType() != Material.AIR) {
            return MagicalChargeUtils.getCharge(item.getItemMeta());
        } else {
            throw new IllegalArgumentException("Cannot get Item charge for null or AIR");
        }
    }

    default boolean addItemCharge(ItemStack item, float charge) {
        Validate.isTrue(charge > 0.0F, "Charge must be above zero!");
        if (item != null && item.getType() != Material.AIR) {
            ItemMeta meta = item.getItemMeta();
            float currentCharge = MagicalChargeUtils.getCharge(meta);
            float maximum = this.getMaxItemCharge(item);
            if (currentCharge >= maximum) {
                return false;
            } else {
                float newCharge = Math.min(currentCharge + charge, maximum);
                MagicalChargeUtils.setCharge(meta, newCharge, maximum);
                item.setItemMeta(meta);
                return true;
            }
        } else {
            throw new IllegalArgumentException("Cannot add Item charge for null or AIR");
        }
    }

    default boolean removeItemCharge(ItemStack item, float charge) {
        Validate.isTrue(charge > 0.0F, "Charge must be above zero!");
        if (item != null && item.getType() != Material.AIR) {
            ItemMeta meta = item.getItemMeta();
            float currentCharge = MagicalChargeUtils.getCharge(meta);
            if (currentCharge < charge) {
                return false;
            } else {
                float newCharge = Math.max(currentCharge - charge, 0.0F);
                MagicalChargeUtils.setCharge(meta, newCharge, this.getMaxItemCharge(item));
                item.setItemMeta(meta);
                return true;
            }
        } else {
            throw new IllegalArgumentException("Cannot remove Item charge for null or AIR");
        }
    }
}
