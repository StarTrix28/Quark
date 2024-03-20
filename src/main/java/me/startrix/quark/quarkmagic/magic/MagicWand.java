package me.startrix.quark.quarkmagic.magic;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.startrix.quark.libraries.magicalenergy.MagicallyRechargeable;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.*;

import static me.startrix.quark.libraries.utils.Utils.useOnGroundgetOutput;
import static me.startrix.quark.define.QuarkMagicalItemsDefine.*;

public class MagicWand extends SlimefunItem implements MagicallyRechargeable {
    private final int capacity;
    private final Map recipes;
    public MagicWand(ItemGroup itemGroup, int capacity, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        this.capacity = capacity;
        this.recipes = new HashMap<Object, ItemStack>();
        this.registerRecipes();
    }
    public void registerRecipes() {
        this.recipes.put(new ItemStack(Material.GLOWSTONE_DUST),MagicalGlowstoneDust);
        this.recipes.put(new ItemStack(Material.GLOWSTONE),MagicalGlowstone);
    }

    public void preRegister() {
        ItemUseHandler handler1 = this::onRightClickItem;
        addItemHandler(handler1);
    }

    private void onRightClickItem(PlayerRightClickEvent event) {
        Player p = event.getPlayer();
        ItemStack handitem = event.getItem();
        Entity[] entities = p.getWorld().getNearbyEntities(event.getClickedBlock().get().getLocation(), 2, 2, 2).toArray(new Entity[0]);
        for (Entity e : entities) {
            if (e.getType() == EntityType.DROPPED_ITEM) {
                Item item = (Item) e;
                ItemStack itemstack = item.getItemStack();

                if (!(itemstack.getType().equals(Material.NETHER_STAR) && Objects.requireNonNull(itemstack.getItemMeta()).getDisplayName().equals(MagicalEssence.getDisplayName()))) {
                ItemStack output = useOnGroundgetOutput(itemstack,this.recipes);
                if (output != null) {
                    item.remove();
                    p.getWorld().dropItemNaturally(event.getClickedBlock().get().getLocation(),output);
                    p.getWorld().playSound(event.getClickedBlock().get().getLocation(), Sound.ITEM_TRIDENT_RIPTIDE_3,100,100);
                }
                } else {
                    if (this.getItemCharge(handitem)+4*item.getItemStack().getAmount() <= this.getMaxItemCharge(handitem)) {
                        item.remove();
                        this.addItemCharge(handitem, 4*item.getItemStack().getAmount());
                    } else {
                        p.sendMessage("Too full");
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
