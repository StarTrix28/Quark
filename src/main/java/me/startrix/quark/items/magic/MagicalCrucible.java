package me.startrix.quark.items.magic;

import io.github.thebusybiscuit.slimefun4.core.multiblocks.MultiBlockMachine;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.List;

import static me.startrix.quark.ItemsDefine.*;

public final class MagicalCrucible extends MultiBlockMachine {


    public MagicalCrucible() {
        super(CategoryMagic,MagicCrucible,new ItemStack[]{null,null,null,null,new ItemStack(Material.WATER_CAULDRON),null,null,new ItemStack(Material.FIRE),null},BlockFace.SELF);

    }

    @Override
    protected void registerDefaultRecipes(@Nonnull List<ItemStack> recipes) {
        addRecipe(new ItemStack[]{SlimefunItems.GOLD_24K},SlimefunItems.BLANK_RUNE);
        super.registerDefaultRecipes(recipes);
    }
    @Override
    public void onInteract(Player player, Block block) {

    }
}
