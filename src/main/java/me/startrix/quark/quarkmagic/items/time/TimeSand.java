package me.startrix.quark.quarkmagic.items.time;

import io.github.thebusybiscuit.slimefun4.api.items.ItemHandler;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.startrix.quark.quarkmagic.QuarkMagicalItemsDefine;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static me.startrix.quark.quarkmagic.QuarkMagicalItemsDefine.CategoryMagic;
import static me.startrix.quark.quarkmagic.QuarkMagicalItemsDefine.SandOfTime;

public class TimeSand extends SlimefunItem {
    public TimeSand() {
        super(CategoryMagic,SandOfTime,RecipeType.NULL,new ItemStack[]{null});
    }

    @Override
    public void preRegister() {
        super.preRegister();
        this.addItemHandler(new BlockTicker() {
            public boolean isSynchronized() {
                return true;
            }

            public void tick(Block b, SlimefunItem item, Config data) {TimeSand.this.tick(b);}
        });
        this.addItemHandler(onBreak());
    }
    private void tick(Block b) {
        try {
            Location loc = new Location(b.getWorld(), b.getX() + 0.5, b.getY() + 1, b.getZ() + 0.5);
            Collection<Entity> entities = loc.getWorld().getNearbyEntities(loc, 0.25, 0.25, 0.25);
            for (Entity entity : entities) {
                EntityType et = entity.getType();
                if (et.equals(EntityType.PLAYER)) {
                    ItemStack is = Objects.requireNonNull(((Player) entity).getEquipment()).getItemInOffHand();
                    try {
                        if (!(Slimefun.getItemDataService().hasEqualItemData(Objects.requireNonNull(is.getItemMeta()), Objects.requireNonNull(QuarkMagicalItemsDefine.TimeStableClock.getItemMeta())))) {
                            ((Player) entity).damage(10);
                            ((Player) entity).sendMessage(String.valueOf(((Player) entity).getEquipment().getItemInOffHand()));
                            ((Player) entity).sendMessage(String.valueOf((ItemStack) QuarkMagicalItemsDefine.TimeStableClock));
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else if (et.isAlive()) {
                    ((LivingEntity) entity).setAI(false);
                }
            }
            Collection<Entity> entities2 = loc.getWorld().getNearbyEntities(loc, 1, 1, 1);
            for (Entity entity : entities2) {
                if (!(entity.getType().equals(EntityType.PLAYER)) && entity.getType().isAlive()) {
                    if (!(entities.contains(entity))) {
                        ((LivingEntity) entity).setAI(true);
                    }
                }
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendRawMessage("[Quark] Error");
        }
    }
    public ItemHandler onBreak() {
        return new BlockBreakHandler(true,true) {
            @Override
            public void onPlayerBreak(BlockBreakEvent e, ItemStack itemStack, List<ItemStack> list) {
                Location loc = new Location(e.getPlayer().getWorld(),e.getBlock().getX(),e.getBlock().getY()+1,e.getBlock().getZ());
                Collection<Entity> entities = loc.getWorld().getNearbyEntities(loc,1,1,1);
                for(Entity entity:entities) {
                    if (!(entity.getType().equals(EntityType.PLAYER)) && entity.getType().isAlive()) {
                        ((LivingEntity)entity).setAI(true);
                    }
                }
            }
        };
    }
}
