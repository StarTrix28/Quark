package me.startrix.atom.items.energymagic;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineFuel;
import me.startrix.atom.ItemsDefine;
import me.startrix.atom.libraries.magicalenergy.AMagicalGenerator;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

import static me.startrix.atom.ItemsDefine.CategoryEnergyMagic;
import static me.startrix.atom.ItemsDefine.Magical_Energy_Generator;

public class MagicEnergyGenerator  extends AMagicalGenerator {
    @ParametersAreNonnullByDefault
    public MagicEnergyGenerator() {
        super(CategoryEnergyMagic, Magical_Energy_Generator,new RecipeType(new CustomItemStack(Material.BARRIER,"Not yet implemented"),"notimplemented"),new ItemStack[]{});
    }

    @NotNull
    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.STICK);
    }

    @Override
    protected void registerDefaultFuelTypes() {
        this.setCapacity(16);
        this.setEnergyProduction(2);
        this.registerFuel(new MachineFuel(2,ItemsDefine.MagicalEssence));
    }


}
