package me.startrix.quark.libraries.magicalenergy;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.common.ChatColors;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class MagicalEnergyConnector extends SimpleSlimefunItem<BlockUseHandler> implements MagicalEnergyNetComponent {
    @ParametersAreNonnullByDefault
    public MagicalEnergyConnector(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, ItemStack recipeOutput) {
        super(itemGroup, item, recipeType, recipe, recipeOutput);
    }

    @Nonnull
    public BlockUseHandler getItemHandler() {
        return (e) -> {
            if (e.getClickedBlock().isPresent()) {
                Player p = e.getPlayer();
                Block b = (Block)e.getClickedBlock().get();
                if (MagicalEnergyNet.getNetworkFromLocation(b.getLocation()) != null) {
                    p.sendMessage(ChatColors.color("&7Connected: &2✔"));
                } else {
                    p.sendMessage(ChatColors.color("&7Connected: &4✘"));
                }

            }
        };
    }

    @Nonnull
    public final MagicalEnergyNetComponentType getEnergyComponentType() {
        return MagicalEnergyNetComponentType.CONNECTOR;
    }

    public int getCapacity() {
        return 0;
    }
}

