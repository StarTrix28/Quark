package me.startrix.quark.quarkmagic.magic;

import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.startrix.quark.libraries.abstracts.NoPowerAContainer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import static me.startrix.quark.define.QuarkMagicalItemsDefine.*;
public final class MagicalCrucible extends NoPowerAContainer {

    private static final int[] border = new int[]{0,8,9,17,18,26,27,28,34,35,36,37,43,44};
    private static final int[] border_in = new int[]{1,7,10,16,19,20,21,22,23,24,25};
    private static final int[] border_out = new int[]{29,30,31,32,33,38,42};

    public MagicalCrucible() {
        super(CategoryMagic,MagicCrucible, RecipeType.MAGIC_WORKBENCH,new ItemStack[]{null,null,null,null,new ItemStack(Material.WATER_CAULDRON),null,null,new ItemStack(Material.FIRE),null});
    }

    @Override
    protected void registerDefaultRecipes() {
        registerRecipe(5,new ItemStack[]{new ItemStack(Material.WATER_BUCKET),MagicalEssence},new ItemStack[]{MagicWater});
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.FIRE);
    }
    @Nonnull
    public String getInventoryTitle() {
        return "&5Magical Crucible";
    }

    @Nonnull
    public String getMachineIdentifier() {
        return "MAGICAL_CRUCIBLE";
    }
    public int getSpeed() {
        return 1;
    }
    public int[] getInputSlots() {
        return new int[]{2,3,4,5,6,11,12,13,14,15};
    }

    public int[] getOutputSlots() {
        return new int[]{39,40,41};
    }
    protected void constructMenu(BlockMenuPreset preset) {
        int[] var2 = border;
        int var3 = var2.length;

        int var4;
        int i;
        for(var4 = 0; var4 < var3; ++var4) {
            i = var2[var4];
            preset.addItem(i, ChestMenuUtils.getBackground(), ChestMenuUtils.getEmptyClickHandler());
        }

        var2 = border_in;
        var3 = var2.length;

        for(var4 = 0; var4 < var3; ++var4) {
            i = var2[var4];
            preset.addItem(i, ChestMenuUtils.getInputSlotTexture(), ChestMenuUtils.getEmptyClickHandler());
        }

        var2 = border_out;
        var3 = var2.length;

        for(var4 = 0; var4 < var3; ++var4) {
            i = var2[var4];
            preset.addItem(i, ChestMenuUtils.getOutputSlotTexture(), ChestMenuUtils.getEmptyClickHandler());
        }

        preset.addItem(22, new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE, " ", new String[0]), ChestMenuUtils.getEmptyClickHandler());
        var2 = this.getOutputSlots();
        var3 = var2.length;

        for(var4 = 0; var4 < var3; ++var4) {
            i = var2[var4];
            preset.addMenuClickHandler(i, new ChestMenu.AdvancedMenuClickHandler() {
                public boolean onClick(Player p, int slot, ItemStack cursor, ClickAction action) {
                    return false;
                }

                public boolean onClick(InventoryClickEvent e, Player p, int slot, ItemStack cursor, ClickAction action) {
                    return cursor == null || cursor.getType() == null || cursor.getType() == Material.AIR;
                }
            });
        }

    }
}
