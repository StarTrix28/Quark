package me.startrix.quark.libraries.magicalenergy;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.libraries.commons.lang.Validate;
import io.github.thebusybiscuit.slimefun4.libraries.dough.common.ChatColors;
import io.github.thebusybiscuit.slimefun4.utils.NumberUtils;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineFuel;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.interfaces.InventoryBlock;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;

public abstract class AbstractMagicalEnergyProvider extends SlimefunItem implements InventoryBlock, RecipeDisplayItem, MagicalEnergyNetProvider {
    protected final Set<MachineFuel> fuelTypes = new HashSet();

    @ParametersAreNonnullByDefault
    protected AbstractMagicalEnergyProvider(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Nonnull
    public String getInventoryTitle() {
        return this.getItemName();
    }

    @Nonnull
    public abstract ItemStack getProgressBar();

    public abstract int getEnergyProduction();

    protected abstract void registerDefaultFuelTypes();

    @Nonnull
    public final MagicalEnergyNetComponentType getEnergyComponentType() {
        return MagicalEnergyNetComponentType.GENERATOR;
    }

    public void registerFuel(@Nonnull MachineFuel fuel) {
        Validate.notNull(fuel, "Machine Fuel cannot be null!");
        this.fuelTypes.add(fuel);
    }

    @Nonnull
    public Set<MachineFuel> getFuelTypes() {
        return this.fuelTypes;
    }

    public String getLabelLocalPath() {
        return "guide.tooltips.recipes.generator";
    }

    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> list = new ArrayList();
        Iterator var2 = this.fuelTypes.iterator();

        while(var2.hasNext()) {
            MachineFuel fuel = (MachineFuel)var2.next();
            ItemStack item = fuel.getInput().clone();
            ItemMeta im = item.getItemMeta();
            List<String> lore = new ArrayList();
            int var10001 = fuel.getTicks();
            lore.add(ChatColors.color("&8⇨ &7Lasts " + NumberUtils.getTimeLeft(var10001 / 2)));
            var10001 = this.getEnergyProduction();
            lore.add(ChatColors.color("&8⇨ &e\uD83E\uDE84 &7" + var10001 * 2) + " ME/s");
            String var7 = NumberUtils.getCompactDouble((double)fuel.getTicks() * (double)this.getEnergyProduction());
            lore.add(ChatColors.color("&8⇨ &e\uD83E\uDE84 &7" + var7 + " ME in total"));
            im.setLore(lore);
            item.setItemMeta(im);
            list.add(item);
        }

        return list;
    }
}
