package me.startrix.quark.quark.energy;

import io.github.thebusybiscuit.slimefun4.api.items.ItemHandler;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.attributes.HologramOwner;
import io.github.thebusybiscuit.slimefun4.core.attributes.Rechargeable;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.startrix.quark.Quark;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.List;

import static me.startrix.quark.define.QuarkItemsDefine.CategoryAdvancedElectricity;

public class PowerCube extends SlimefunItem implements EnergyNetComponent, Rechargeable, HologramOwner {
    private final int capacity;
    private final SlimefunItemStack sis;

    public PowerCube(int capacity, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(CategoryAdvancedElectricity, item, recipeType, recipe);
        this.capacity = capacity;
        this.sis = item;
    }

    @Override
    public void preRegister() {
        super.preRegister();
        this.addItemHandler(onPlace());
        this.addItemHandler(onBreak());
        this.addItemHandler(new BlockTicker() {
            public boolean isSynchronized() {
                return false;
            }

            public void tick(Block b, SlimefunItem item, Config data) {
                PowerCube.this.tick(b);
            }
        });
    }
    private ItemHandler onPlace() {
        return new BlockPlaceHandler(false) {
            @Override
            public void onPlayerPlace(@NotNull BlockPlaceEvent event) {
                PowerCube.this.setCharge(event.getBlock().getLocation(), (int) PowerCube.this.getItemCharge(event.getItemInHand()));
            }
        };
    }
    private  ItemHandler onBreak() {
        return new BlockBreakHandler(true,true) {
            @Override
            public void onPlayerBreak(BlockBreakEvent event, ItemStack itemStack, List<ItemStack> list) {
                PowerCube.this.removeHologram(event.getBlock());
                Collection<ItemStack> pc = event.getBlock().getDrops();
                event.setDropItems(false);
                event.getBlock().getDrops().clear();
                SlimefunItemStack sis = new SlimefunItemStack(PowerCube.this.sis,1);
                PowerCube.this.setItemCharge(sis,PowerCube.this.getCharge(event.getBlock().getLocation()));
                event.getPlayer().getWorld().dropItemNaturally(event.getBlock().getLocation(),sis);

            }
        };
    }
    private void tick(@Nonnull Block b) {
        int charge = this.getCharge(b.getLocation());
        double x = (double) (100 * charge) /this.getCapacity();
        String formating = MessageFormat.format("%.{0}f", Quark.getCfg().getInt("PowerCubeDecimals"));
        this.updateHologram(b, ChatColor.GREEN+String.format(formating, x)+"%");
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
