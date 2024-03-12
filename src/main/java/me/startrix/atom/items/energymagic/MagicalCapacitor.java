package me.startrix.atom.items.energymagic;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.startrix.atom.libraries.magicalenergy.MagicalEnergyNetComponent;
import me.startrix.atom.libraries.magicalenergy.MagicalEnergyNetComponentType;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class MagicalCapacitor extends SlimefunItem implements MagicalEnergyNetComponent {
    private final int capacity;

    @ParametersAreNonnullByDefault
    public MagicalCapacitor(ItemGroup itemGroup, int capacity, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        this.capacity = capacity;
    }

    @Nonnull
    public final MagicalEnergyNetComponentType getEnergyComponentType() {
        return MagicalEnergyNetComponentType.CAPACITOR;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
