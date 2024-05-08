package me.startrix.quark.core.items;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

import static me.startrix.quark.core.utils.Utils.useOnGroundgetOutput;

public class RightClickRecipeItem extends SlimefunItem {
    public final Map recipes;
    public RightClickRecipeItem(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        this.recipes = new HashMap<ItemStack, ItemStack>();
        this.registerDefaultRecipes();
    }

    public void registerDefaultRecipes() {

    }

    public void registerRecipe(ItemStack i, ItemStack o) {
        this.recipes.put(i,(ItemStack) o);
    }
    public void registerRecipe(SlimefunItemStack i, ItemStack o) {
        this.recipes.put(i,(ItemStack) o);
    }
    public void registerRecipe(SlimefunItemStack i, SlimefunItemStack o) {
        this.recipes.put(i,(ItemStack) o);
    }
    public void registerRecipe(ItemStack i, SlimefunItemStack o) {
        this.recipes.put(i,(ItemStack) o);
    }

    @Override
    public void preRegister() {
        ItemUseHandler handler1 = this::onRightClick;
        addItemHandler(handler1);
    }
    public Map getRecipes() {
        return this.recipes;
    }
    protected void onRightClick(PlayerRightClickEvent event) {
        Player p = event.getPlayer();
        ItemStack handitem = event.getItem();
        Entity[] entities = p.getWorld().getNearbyEntities(event.getClickedBlock().get().getLocation(), 2, 2, 2).toArray(new Entity[0]);
        for (Entity e : entities) {
            if (e.getType() == EntityType.DROPPED_ITEM) {
                Item item = (Item) e;
                ItemStack itemstack = item.getItemStack();
                ItemStack output = useOnGroundgetOutput(itemstack, this.recipes);
                if (output != null) {
                    item.remove();
                    e.getLocation().getWorld().dropItemNaturally(e.getLocation(), output);
                }
            }
        }
    }
}
