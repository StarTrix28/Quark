package me.startrix.quark.items.magic;


import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import static me.startrix.quark.ItemsDefine.*;
import static org.bukkit.Material.*;


public class MagicStone extends SlimefunItem {

    public MagicStone() {
        super(CategoryMagic, MagicStone, RecipeType.MAGIC_WORKBENCH, new ItemStack[]{SlimefunItems.MAGIC_LUMP_3, SlimefunItems.GOLD_24K, SlimefunItems.MAGIC_LUMP_3, SlimefunItems.GOLD_24K,Magic_Rune,SlimefunItems.GOLD_24K,SlimefunItems.MAGIC_LUMP_3, SlimefunItems.GOLD_24K,SlimefunItems.MAGIC_LUMP_3});
    }
    public void preRegister() {
        ItemUseHandler itemUseHandler = this::onItemUseRightClick;
        addItemHandler(itemUseHandler);
    }

    private void onItemUseRightClick(PlayerRightClickEvent event) {

        Material ebType = event.getClickedBlock().get().getType();
        Block clickedblock = event.getClickedBlock().get();
        if (event.getPlayer().isSneaking()) {
            if (ebType == GRASS_BLOCK || ebType == DIRT || ebType == SAND) {clickedblock.setType(COBBLESTONE);}
            else if (ebType == COBBLESTONE || ebType == STONE) {clickedblock.setType(GRASS_BLOCK);}
        } else {
            if (ebType == GRASS_BLOCK) {clickedblock.setType(DIRT);}
            else if (ebType == DIRT) {clickedblock.setType(SAND);}
            else if (ebType == SAND) {clickedblock.setType(GRASS_BLOCK);}
            else if (ebType == COBBLESTONE) {clickedblock.setType(STONE);}
            else if (ebType == STONE) {clickedblock.setType(COBBLESTONE);}

        }
        event.cancel();
    }
}
