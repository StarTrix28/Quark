package me.startrix.atom.items.magic;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import static me.startrix.atom.ItemsDefine.*;
public class EssenceGrinder extends AContainer {

    public EssenceGrinder() {
        super(CategoryMagicalMachines,MEssenceGrinder,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.REDSTONE_ALLOY,SlimefunItems.SMALL_CAPACITOR,SlimefunItems.REDSTONE_ALLOY,new ItemStack(Material.IRON_BLOCK),null,new ItemStack(Material.IRON_BLOCK),SlimefunItems.REDSTONE_ALLOY,new ItemStack(Material.GRINDSTONE),SlimefunItems.REDSTONE_ALLOY});
    }

    @Override
    public ItemStack getProgressBar() {
        CustomItemStack s = new CustomItemStack(Material.IRON_AXE,"Hammer");
        s.addUnsafeEnchantment(Enchantment.LURE,1);
        s.addFlags(ItemFlag.HIDE_ENCHANTS);
        return s;
    }

    @NotNull
    @Override
    public String getMachineIdentifier() {
        return "ESSENCE_GRINDER";
    }

    @NotNull
    @Override
    public String getInventoryTitle() {
        return "Essence Grinder";
    }
    public int getCapacity() {
        return this.getDefaultEnergyConsumption() * 5;
    }

    public int getDefaultEnergyConsumption() {return 16;}

    public int getEnergyConsumption() {
        return this.getDefaultEnergyConsumption();
    }

    public int getSpeed() {
        return 1;
    }
    @Override
    protected void registerDefaultRecipes() {
        this.registerRecipe(8,new ItemStack[]{MagicalEssence},new ItemStack[]{});
    }
}
