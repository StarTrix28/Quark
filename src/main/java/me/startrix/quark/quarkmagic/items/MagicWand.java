package me.startrix.quark.quarkmagic.items;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.startrix.quark.core.items.RightClickRecipeItem;
import me.startrix.quark.core.magicalenergy.MagicallyRechargeable;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

import static me.startrix.quark.core.utils.Utils.useOnGroundgetOutput;
import static me.startrix.quark.quarkmagic.QuarkMagicalItemsDefine.*;

public class MagicWand extends RightClickRecipeItem implements MagicallyRechargeable {
    private final int capacity;
    public MagicWand(ItemGroup itemGroup, int capacity, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        this.capacity = capacity;
    }

    @Override
    public void registerDefaultRecipes() {
        this.registerRecipe(new ItemStack(Material.GLOWSTONE_DUST),MagicalGlowstoneDust);
        this.registerRecipe(new ItemStack(Material.GLOWSTONE),MagicalGlowstone);
    }

    @Override
    public void preRegister() {
        ItemUseHandler h1 = this::onRightClickItem;
        this.addItemHandler(h1);
    }

    protected void onRightClickItem(PlayerRightClickEvent event) {
        Player p = event.getPlayer();
        ItemStack handitem = event.getItem();
        Entity[] entities = p.getWorld().getNearbyEntities(event.getClickedBlock().get().getLocation(), 2, 2, 2).toArray(new Entity[0]);
        for (Entity e : entities) {
            if (e.getType() == EntityType.DROPPED_ITEM) {
                Item item = (Item) e;
                ItemStack itemstack = item.getItemStack();

                if ((itemstack.getType().equals(Material.NETHER_STAR) && Objects.requireNonNull(itemstack.getItemMeta()).getDisplayName().equals(MagicalEssence.getDisplayName()))) {
                    if (this.getItemCharge(handitem)+4*item.getItemStack().getAmount() <= this.getMaxItemCharge(handitem)) {
                        item.remove();
                        this.addItemCharge(handitem, 4*item.getItemStack().getAmount());
                    } else {
                        p.sendMessage("Too full");
                    }

                } else {
                    ItemStack output = useOnGroundgetOutput(itemstack,this.getRecipes());
                    if (output != null) {
                        item.remove();
                        e.getLocation().getWorld().dropItemNaturally(e.getLocation(),output);

                    }
                }
            }
        }

    }
    @Override
    public float getMaxItemCharge(ItemStack var1) {
        return this.capacity;
    }
}
