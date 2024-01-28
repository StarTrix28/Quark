package me.startrix.quark.libraries.magicalenergy;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.ItemHandler;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.HologramOwner;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNet;
import io.github.thebusybiscuit.slimefun4.implementation.handlers.SimpleBlockBreakHandler;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class MagicalEnergyRegulator extends SlimefunItem implements HologramOwner {
    @ParametersAreNonnullByDefault
    public MagicalEnergyRegulator(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        this.addItemHandler(new ItemHandler[]{this.onBreak()});
    }

    @Nonnull
    private BlockBreakHandler onBreak() {
        return new SimpleBlockBreakHandler() {
            public void onBlockBreak(@Nonnull Block b) {
                MagicalEnergyRegulator.this.removeHologram(b);
            }
        };
    }

    @Nonnull
    private BlockPlaceHandler onPlace() {
        return new BlockPlaceHandler(false) {
            public void onPlayerPlace(BlockPlaceEvent e) {
                MagicalEnergyRegulator.this.updateHologram(e.getBlock(), "&7Connecting...");
            }
        };
    }

    public void preRegister() {
        this.addItemHandler(new ItemHandler[]{this.onPlace()});
        this.addItemHandler(new ItemHandler[]{new BlockTicker() {
            public boolean isSynchronized() {
                return false;
            }

            public void tick(Block b, SlimefunItem item, Config data) {
                io.github.thebusybiscuit.slimefun4.implementation.items.electric.EnergyRegulator.this.tick(b);
            }
        }});
    }

    private void tick(@Nonnull Block b) {
        EnergyNet network = EnergyNet.getNetworkFromLocationOrCreate(b.getLocation());
        network.tick(b);
    }
}

