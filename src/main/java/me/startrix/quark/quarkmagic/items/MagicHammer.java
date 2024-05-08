package me.startrix.quark.quarkmagic.items;

import io.github.thebusybiscuit.slimefun4.api.items.ItemHandler;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import me.startrix.quark.core.items.RightClickRecipeItem;
import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

import static me.startrix.quark.quarkmagic.QuarkMagicalItemsDefine.*;
public class MagicHammer extends RightClickRecipeItem {
    public MagicHammer() {
        super(CategoryMagic,MagicHammer,RecipeType.MAGIC_WORKBENCH,new ItemStack[]{null,new ItemStack(Material.IRON_INGOT),MagicalEssence,null,new ItemStack(Material.STICK),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.STICK),null,null});
    }

    @Override
    public void registerDefaultRecipes() {
        this.registerRecipe(new ItemStack(Material.GLOWSTONE_DUST),Photonus);
    }

    @Override
    public void preRegister() {
        super.preRegister();
        super.addItemHandler(onBreak());
    }


    protected ItemHandler onBreak() {
        return new BlockBreakHandler(true,true) {
            @Override
            public void onPlayerBreak(BlockBreakEvent blockBreakEvent, ItemStack itemStack, List<ItemStack> list) {
                blockBreakEvent.setCancelled(false);
                blockBreakEvent.setDropItems(false);
            }
        };
    }
}
