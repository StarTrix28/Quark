package me.startrix.atom.items.energy;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemHandler;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.attributes.Rechargeable;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.List;

import static me.startrix.atom.ItemsDefine.CategoryAdvancedElectricity;
import static me.startrix.atom.ItemsDefine.PowerCube1;

public class PowerCube extends SlimefunItem implements EnergyNetComponent, Rechargeable {
    private final int capacity;

    public PowerCube(int capacity, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(CategoryAdvancedElectricity, item, recipeType, recipe);
        this.capacity = capacity;
    }

    @Override
    public void preRegister() {
        super.preRegister();
        this.addItemHandler(onPlace());
        this.addItemHandler(onBreak());
    }
    private ItemHandler onPlace() {
        return new BlockPlaceHandler(false) {
            @Override
            public void onPlayerPlace(@NotNull BlockPlaceEvent event) {
                PowerCube.this.setCharge(event.getBlock().getLocation(), (int) PowerCube.this.getItemCharge(PowerCube.this.getItem()));
            }
        };
    }
    private  ItemHandler onBreak() {
        return new BlockBreakHandler(true,true) {
            @Override
            public void onPlayerBreak(BlockBreakEvent blockBreakEvent, ItemStack itemStack, List<ItemStack> list) {
                Player p = blockBreakEvent.getPlayer();
                p.sendMessage(blockBreakEvent.getBlock().toString());
                p.sendMessage(itemStack.toString());
                p.sendMessage(list.toString());
                Object[] arritemstack = blockBreakEvent.getBlock().getDrops().toArray();
                ItemStack itemstack = (ItemStack) arritemstack[0];

                PowerCube.this.setItemCharge(itemstack,PowerCube.this.getCharge(blockBreakEvent.getBlock().getLocation()));

            }
        };
    }
    @NotNull
    @Override
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CAPACITOR;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public float getMaxItemCharge(ItemStack itemStack) {
        return this.capacity;
    }
}
