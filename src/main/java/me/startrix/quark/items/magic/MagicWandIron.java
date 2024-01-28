package me.startrix.quark.items.magic;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static me.startrix.quark.ItemsDefine.*;

public class MagicWandIron extends SlimefunItem {

    public MagicWandIron() {
        super(CategoryMagic,MagicWandIron,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{null,null,Iron_Cap,null,new ItemStack(Material.STICK),null,Iron_Cap,null,null});
    }
    public void preRegister() {
        ItemUseHandler handler1 = this::onRightClickItem;
        addItemHandler(handler1);
    }

    private void onRightClickItem(PlayerRightClickEvent event) {
        Entity[] entities = event.getPlayer().getWorld().getNearbyEntities(event.getClickedBlock().get().getLocation(), 2, 2, 2).toArray(new Entity[0]);
            for (Entity e : entities) {
                if (e.getType() == EntityType.DROPPED_ITEM) {
                    Item item = (Item) e;
                    event.getPlayer().sendMessage();
                    if (item.getItemStack().getType() == Material.GLOWSTONE_DUST) {
                        item.setItemStack(MagicalGlowstoneDust);
                    }
                }
            }

    }


}
