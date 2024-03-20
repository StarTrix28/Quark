package me.startrix.quark.quarkmagic.energymagic;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.HologramOwner;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import io.github.thebusybiscuit.slimefun4.implementation.handlers.SimpleBlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.startrix.quark.libraries.magicalenergy.MagicalEnergyNet;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import static me.startrix.quark.define.QuarkMagicalItemsDefine.CategoryEnergyMagic;
import static me.startrix.quark.define.QuarkMagicalItemsDefine.Magical_Energy_Regulator;

public class MagicalEnergyRegulator extends SlimefunItem implements HologramOwner {
    @ParametersAreNonnullByDefault
    public MagicalEnergyRegulator() {
        super(CategoryEnergyMagic,Magical_Energy_Regulator,new RecipeType(new CustomItemStack(Material.BARRIER,"Not yet implemented"),"notimplemented"),new ItemStack[]{});
        this.addItemHandler(this.onBreak());
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
        this.addItemHandler(this.onPlace());
        this.addItemHandler(new BlockTicker() {
            public boolean isSynchronized() {
                return false;
            }

            public void tick(Block b, SlimefunItem item, Config data) {
                MagicalEnergyRegulator.this.tick(b);
            }
        });
    }

    private void tick(@Nonnull Block b) {
        MagicalEnergyNet network = MagicalEnergyNet.getNetworkFromLocationOrCreate(b.getLocation());
        network.tick(b);
    }
}

