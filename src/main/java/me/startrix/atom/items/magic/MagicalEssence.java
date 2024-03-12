package me.startrix.atom.items.magic;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.ItemSetting;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.settings.IntRangeSetting;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.attributes.RandomMobDrop;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

import static me.startrix.atom.ItemsDefine.*;

public class MagicalEssence extends SimpleSlimefunItem<ItemUseHandler> implements NotPlaceable, RandomMobDrop {
    private final ItemSetting<Boolean> dropSetting = new ItemSetting(this, "drop-from-witch", true);
    private final ItemSetting<Integer> chance = new IntRangeSetting(this, "witch-drop-chance", 0, 75, 100);

    @ParametersAreNonnullByDefault
    public MagicalEssence() {
        super(CategoryEssences,MagicalEssence,RecipeType.MOB_DROP,new ItemStack[]{null,null,null,null,new CustomItemStack(Material.PURPLE_WOOL,"Witch")});
        this.addItemSetting(this.dropSetting);
        this.addItemSetting(this.chance);
    }

    public int getMobDropChance() {
        return this.chance.getValue();
    }

    public boolean isDroppedFromWitches() {
        return this.dropSetting.getValue();
    }

    public ItemUseHandler getItemHandler() {
        return PlayerRightClickEvent::cancel;
    }
}
