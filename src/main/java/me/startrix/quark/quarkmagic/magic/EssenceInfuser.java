package me.startrix.quark.quarkmagic.magic;

import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import static me.startrix.quark.define.QuarkMagicalItemsDefine.*;
public class EssenceInfuser extends AContainer {
    protected EssenceInfuser() {
        super(CategoryMagicalMachines,EssenceInfuser,new RecipeType(new CustomItemStack(Material.BARRIER,"Not yet implemented"),"notimplemented"),new ItemStack[]{});
    }

    @Override
    public int getCapacity() {
        return 256;
    }
    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    public int getEnergyConsumption() {
        return 64;
    }

    @Override
    public ItemStack getProgressBar() {
        return new CustomItemStack(Material.EMERALD);
    }

    @NotNull
    @Override
    public String getMachineIdentifier() {
        return "ESSENCE_INFUSER";
    }
}
