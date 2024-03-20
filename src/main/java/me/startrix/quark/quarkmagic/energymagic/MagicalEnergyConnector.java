package me.startrix.quark.quarkmagic.energymagic;

import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.common.ChatColors;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.startrix.quark.libraries.magicalenergy.MagicalEnergyNet;
import me.startrix.quark.libraries.magicalenergy.MagicalEnergyNetComponent;
import me.startrix.quark.libraries.magicalenergy.MagicalEnergyNetComponentType;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import static me.startrix.quark.define.QuarkMagicalItemsDefine.CategoryEnergyMagic;
import static me.startrix.quark.define.QuarkMagicalItemsDefine.Magical_Energy_Connector;

public class MagicalEnergyConnector extends SimpleSlimefunItem<BlockUseHandler> implements MagicalEnergyNetComponent {
    @ParametersAreNonnullByDefault
    public MagicalEnergyConnector() {
        super(CategoryEnergyMagic,Magical_Energy_Connector,new RecipeType(new CustomItemStack(Material.BARRIER,"Not yet implemented"),"notimplemented"),new ItemStack[]{});
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

