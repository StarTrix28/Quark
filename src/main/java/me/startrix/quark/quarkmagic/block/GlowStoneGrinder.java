package me.startrix.quark.quarkmagic.block;

import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import static me.startrix.quark.quarkmagic.QuarkMagicalItemsDefine.*;

public class GlowStoneGrinder extends AContainer {
    public GlowStoneGrinder() {
        super(CategoryMagic,GlowStoneGrinder,RecipeType.NULL,new ItemStack[]{null,null,null,null,null,null,null,null,null});
    }

    @Override
    protected void registerDefaultRecipes() {
        this.registerRecipe(4,new ItemStack[]{new ItemStack(Material.GLOWSTONE_DUST)},new ItemStack[]{GlassDust,Photonus});
    }

    @Override
    public int getCapacity() {
        return 256;
    }

    @Override
    public int getEnergyConsumption() {
        return 16;
    }

    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    public ItemStack getProgressBar() {
        return MagicHammer.getData().toItemStack(1);
    }

    @NotNull
    @Override
    public String getMachineIdentifier() {
        return "GLOWSTONE_GRINDER";
    }
}
