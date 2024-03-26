package me.startrix.quark.quarkaddons.FluffyMachines;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.startrix.quark.Quark;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import static me.startrix.quark.define.AddonsAddonsGroupDefine.*;
import static me.startrix.quark.quarkaddons.FluffyMachines.FluffyMachinesDefine.*;

public class FluffyMachinesSetup {
    public static final FluffyMachinesSetup INSTANCE = new FluffyMachinesSetup();
    private final SlimefunAddon plugin;
    private boolean initialised;

    public FluffyMachinesSetup() {
        this.plugin = Quark.getInstance();
    }

    public void init() {
        if (!this.initialised) {
            this.initialised = true;
            this.registerTest();
        }
    }
    public void registerTest() {
        this.registerItemNoRecipe(CategoryFluffyMachines,test);
    }

    private void registerItemNoRecipe(ItemGroup group, SlimefunItemStack item) {
        SlimefunItem sfitem = new SlimefunItem(group,item,new RecipeType(new CustomItemStack(Material.BARRIER,"Not yet implemented"),"notimplemented"),new ItemStack[]{});
        sfitem.register(this.plugin);
    }
}
