package me.startrix.quark.libraries.magicalenergy;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.ItemHandler;
import io.github.thebusybiscuit.slimefun4.api.items.ItemState;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineProcessHolder;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.machines.MachineProcessor;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.handlers.SimpleBlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.implementation.operations.FuelOperation;
import io.github.thebusybiscuit.slimefun4.libraries.commons.lang.Validate;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import io.github.thebusybiscuit.slimefun4.utils.itemstack.ItemStackWrapper;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineFuel;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class AMagicalGenerator extends AbstractMagicalEnergyProvider implements MachineProcessHolder<FuelOperation> {
    private static final int[] border = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 13, 31, 36, 37, 38, 39, 40, 41, 42, 43, 44};
    private static final int[] border_in = new int[]{9, 10, 11, 12, 18, 21, 27, 28, 29, 30};
    private static final int[] border_out = new int[]{14, 15, 16, 17, 23, 26, 32, 33, 34, 35};
    private final MachineProcessor<FuelOperation> processor = new MachineProcessor(this);
    private int energyProducedPerTick = -1;
    private int energyCapacity = -1;

    @ParametersAreNonnullByDefault
    protected AMagicalGenerator(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        this.processor.setProgressBar(this.getProgressBar());
        BlockMenuPreset var10001 = new BlockMenuPreset(item.getItemId(), this.getInventoryTitle()) {
            public void init() {
                AMagicalGenerator.this.constructMenu(this);
            }

            public boolean canOpen(Block b, Player p) {
                return p.hasPermission("slimefun.inventory.bypass") || Slimefun.getProtectionManager().hasPermission(p, b.getLocation(), Interaction.INTERACT_BLOCK);
            }

            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow) {
                return flow == ItemTransportFlow.INSERT ? AMagicalGenerator.this.getInputSlots() : AMagicalGenerator.this.getOutputSlots();
            }
        };
        this.addItemHandler(new ItemHandler[]{this.onBlockBreak()});
        this.registerDefaultFuelTypes();
    }

    public MachineProcessor<FuelOperation> getMachineProcessor() {
        return this.processor;
    }

    @Nonnull
    protected BlockBreakHandler onBlockBreak() {
        return new SimpleBlockBreakHandler() {
            public void onBlockBreak(Block b) {
                BlockMenu inv = BlockStorage.getInventory(b);
                if (inv != null) {
                    inv.dropItems(b.getLocation(), AMagicalGenerator.this.getInputSlots());
                    inv.dropItems(b.getLocation(), AMagicalGenerator.this.getOutputSlots());
                }

                AMagicalGenerator.this.processor.endOperation(b);
            }
        };
    }

    private void constructMenu(BlockMenuPreset preset) {
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

        preset.addItem(22, new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE, " ", new String[0]), ChestMenuUtils.getEmptyClickHandler());
    }

    public int[] getInputSlots() {
        return new int[]{19, 20};
    }

    public int[] getOutputSlots() {
        return new int[]{24, 25};
    }

    public int getGeneratedOutput(Location l, Config data) {
        BlockMenu inv = BlockStorage.getInventory(l);
        FuelOperation operation = (FuelOperation)this.processor.getOperation(l);
        if (operation != null) {
            if (!operation.isFinished()) {
                this.processor.updateProgressBar(inv, 22, operation);
                if (this.isChargeable()) {
                    int charge = this.getCharge(l, data);
                    if (this.getCapacity() - charge >= this.getEnergyProduction()) {
                        operation.addProgress(1);
                        return this.getEnergyProduction();
                    } else {
                        return 0;
                    }
                } else {
                    operation.addProgress(1);
                    return this.getEnergyProduction();
                }
            } else {
                ItemStack fuel = operation.getIngredient();
                if (this.isBucket(fuel)) {
                    inv.pushItem(new ItemStack(Material.BUCKET), this.getOutputSlots());
                }

                inv.replaceExistingItem(22, new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE, " ", new String[0]));
                this.processor.endOperation(l);
                return 0;
            }
        } else {
            Map<Integer, Integer> found = new HashMap();
            MachineFuel fuel = this.findRecipe(inv, found);
            if (fuel != null) {
                Iterator var7 = found.entrySet().iterator();

                while(var7.hasNext()) {
                    Map.Entry<Integer, Integer> entry = (Map.Entry)var7.next();
                    inv.consumeItem((Integer)entry.getKey(), (Integer)entry.getValue());
                }

                this.processor.startOperation(l, new FuelOperation(fuel));
            }

            return 0;
        }
    }

    private boolean isBucket(@Nullable ItemStack item) {
        if (item == null) {
            return false;
        } else {
            ItemStackWrapper wrapper = ItemStackWrapper.wrap(item);
            return item.getType() == Material.LAVA_BUCKET || SlimefunUtils.isItemSimilar(wrapper, SlimefunItems.FUEL_BUCKET, true) || SlimefunUtils.isItemSimilar(wrapper, SlimefunItems.OIL_BUCKET, true);
        }
    }

    private MachineFuel findRecipe(BlockMenu menu, Map<Integer, Integer> found) {
        Iterator var3 = this.fuelTypes.iterator();

        while(var3.hasNext()) {
            MachineFuel fuel = (MachineFuel)var3.next();
            int[] var5 = this.getInputSlots();
            int var6 = var5.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                int slot = var5[var7];
                if (fuel.test(menu.getItemInSlot(slot))) {
                    found.put(slot, fuel.getInput().getAmount());
                    return fuel;
                }
            }
        }

        return null;
    }

    public int getCapacity() {
        return this.energyCapacity;
    }

    public int getEnergyProduction() {
        return this.energyProducedPerTick;
    }

    public final AMagicalGenerator setCapacity(int capacity) {
        Validate.isTrue(capacity >= 0, "The capacity cannot be negative!");
        if (this.getState() == ItemState.UNREGISTERED) {
            this.energyCapacity = capacity;
            return this;
        } else {
            throw new IllegalStateException("You cannot modify the capacity after the Item was registered.");
        }
    }

    public final AMagicalGenerator setEnergyProduction(int energyProduced) {
        Validate.isTrue(energyProduced > 0, "The energy production must be greater than zero!");
        this.energyProducedPerTick = energyProduced;
        return this;
    }

    public void register(@Nonnull SlimefunAddon addon) {
        this.addon = addon;
        if (this.getCapacity() < 0) {
            this.warn("The capacity has not been configured correctly. The Item was disabled.");
            this.warn("Make sure to call '" + this.getClass().getSimpleName() + "#setEnergyCapacity(...)' before registering!");
        }

        if (this.getEnergyProduction() <= 0) {
            this.warn("The energy consumption has not been configured correctly. The Item was disabled.");
            this.warn("Make sure to call '" + this.getClass().getSimpleName() + "#setEnergyProduction(...)' before registering!");
        }

        if (this.getCapacity() >= 0 && this.getEnergyProduction() > 0) {
            super.register(addon);
        }

    }
}