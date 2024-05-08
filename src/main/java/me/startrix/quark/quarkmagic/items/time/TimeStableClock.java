package me.startrix.quark.quarkmagic.items.time;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.startrix.quark.quarkmagic.QuarkMagicalItemsDefine;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static me.startrix.quark.quarkmagic.QuarkMagicalItemsDefine.CategoryMagic;

public class TimeStableClock extends SlimefunItem {
    public TimeStableClock() {
        super(CategoryMagic, QuarkMagicalItemsDefine.TimeStableClock,RecipeType.NULL,new ItemStack[]{null});
    }

    @Override
    public void preRegister() {
        super.preRegister();
        ItemUseHandler handler1 = this::RightClick;
        this.addItemHandler(handler1);
    }

    private void RightClick(PlayerRightClickEvent event) {
        if (event.getClickedBlock().get().getType().equals(Material.SAND)) {
            event.getClickedBlock().get().setType(Material.SANDSTONE);
            BlockStorage.store(event.getClickedBlock().get(),(new TimeSand()).getId());
        }
    }
}
