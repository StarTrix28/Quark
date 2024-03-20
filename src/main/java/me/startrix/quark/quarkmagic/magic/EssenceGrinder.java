package me.startrix.quark.quarkmagic.magic;

import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import static me.startrix.quark.define.QuarkMagicalItemsDefine.*;

public class EssenceGrinder extends AContainer {
    private static final int[] border = new int[]{0,8,9,17,18,26,27,28,29,33,34,35,36,37,38,42,43,44};
    private static final int[] inputBorder = new int[]{30,31,32,39,41};
    private static final int[] outputBorder = new int[]{1,7,10,16,19,20,21,22,23,24,25};

    public EssenceGrinder() {
        super(CategoryMagicalMachines,MEssenceGrinder,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.REDSTONE_ALLOY,SlimefunItems.SMALL_CAPACITOR,SlimefunItems.REDSTONE_ALLOY,new ItemStack(Material.IRON_BLOCK),null,new ItemStack(Material.IRON_BLOCK),SlimefunItems.REDSTONE_ALLOY,new ItemStack(Material.GRINDSTONE),SlimefunItems.REDSTONE_ALLOY});
    }

    @Override
    public ItemStack getProgressBar() {
        CustomItemStack s = new CustomItemStack(Material.IRON_AXE,"Hammer");
        s.addUnsafeEnchantment(Enchantment.LURE,1);
        s.addFlags(ItemFlag.HIDE_ENCHANTS);
        return s;
    }

    @NotNull
    @Override
    public String getMachineIdentifier() {
        return "ESSENCE_GRINDER";
    }

    @NotNull
    @Override
    public String getInventoryTitle() {
        return "Essence Grinder";
    }
    public int getCapacity() {
        return this.getDefaultEnergyConsumption() * 5;
    }

    public int getDefaultEnergyConsumption() {return 16;}

    public int getEnergyConsumption() {
        return this.getDefaultEnergyConsumption();
    }

    public int getSpeed() {
        return 1;
    }
    @Override
    protected void registerDefaultRecipes() {
        this.registerRecipe(8,new ItemStack[]{MagicalEssence},new ItemStack[]{StabilityEssence,HeatEssence,ColdEssence,RedEssence,DarkEssence,MagicGlass});
    }
    public int[] getInputSlots() {
        return new int[]{40};
    }

    public int[] getOutputSlots() {
        return new int[]{2,3,4,5,6,11,12,13,14,15};
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

        var2 = inputBorder;
        var3 = var2.length;

        for(var4 = 0; var4 < var3; ++var4) {
            i = var2[var4];
            preset.addItem(i, ChestMenuUtils.getInputSlotTexture(), ChestMenuUtils.getEmptyClickHandler());
        }

        var2 = outputBorder;
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
