package me.startrix.quark.libraries.magicalenergy;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.*;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineProcessHolder;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.machines.MachineProcessor;
import io.github.thebusybiscuit.slimefun4.implementation.handlers.SimpleBlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.implementation.operations.CraftingOperation;
import io.github.thebusybiscuit.slimefun4.libraries.commons.lang.Validate;
import io.github.thebusybiscuit.slimefun4.libraries.dough.inventory.InvUtils;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import io.github.thebusybiscuit.slimefun4.utils.itemstack.ItemStackWrapper;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.interfaces.InventoryBlock;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;

public abstract class AMagicalContainer extends SlimefunItem implements InventoryBlock, MagicalEnergyNetComponent, MachineProcessHolder<CraftingOperation> {
    private static final int[] BORDER = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 13, 31, 36, 37, 38, 39, 40, 41, 42, 43, 44};
    private static final int[] BORDER_IN = new int[]{9, 10, 11, 12, 18, 21, 27, 28, 29, 30};
    private static final int[] BORDER_OUT = new int[]{14, 15, 16, 17, 23, 26, 32, 33, 34, 35};
    protected final List<MachineRecipe> recipes;
    private final MachineProcessor<CraftingOperation> processor;
    private int magicalenergyConsumedPerTick;
    private int magicalenergyCapacity;
    private int processingSpeed;

    @ParametersAreNonnullByDefault
    protected AMagicalContainer(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        this.recipes = new ArrayList();
        this.processor = new MachineProcessor(this);
        this.magicalenergyConsumedPerTick = -1;
        this.magicalenergyCapacity = -1;
        this.processingSpeed = -1;
        this.processor.setProgressBar(this.getProgressBar());
        this.createPreset(this, this.getInventoryTitle(), this::constructMenu);
        this.addItemHandler(new ItemHandler[]{this.onBlockBreak()});
    }

    @Nonnull
    protected BlockBreakHandler onBlockBreak() {
        return new SimpleBlockBreakHandler() {
            public void onBlockBreak(Block b) {
                BlockMenu inv = BlockStorage.getInventory(b);
                if (inv != null) {
                    inv.dropItems(b.getLocation(), AMagicalContainer.this.getInputSlots());
                    inv.dropItems(b.getLocation(), AMagicalContainer.this.getOutputSlots());
                }

                AMagicalContainer.this.processor.endOperation(b);
            }
        };
    }

    @ParametersAreNonnullByDefault
    protected AMagicalContainer(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, ItemStack recipeOutput) {
        this(itemGroup, item, recipeType, recipe);
        this.recipeOutput = recipeOutput;
    }

    public MachineProcessor<CraftingOperation> getMachineProcessor() {
        return this.processor;
    }

    protected void constructMenu(BlockMenuPreset preset) {
        int[] var2 = BORDER;
        int var3 = var2.length;

        int var4;
        int i;
        for(var4 = 0; var4 < var3; ++var4) {
            i = var2[var4];
            preset.addItem(i, ChestMenuUtils.getBackground(), ChestMenuUtils.getEmptyClickHandler());
        }

        var2 = BORDER_IN;
        var3 = var2.length;

        for(var4 = 0; var4 < var3; ++var4) {
            i = var2[var4];
            preset.addItem(i, ChestMenuUtils.getInputSlotTexture(), ChestMenuUtils.getEmptyClickHandler());
        }

        var2 = BORDER_OUT;
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

    @Nonnull
    public String getInventoryTitle() {
        return this.getItemName();
    }

    public abstract ItemStack getProgressBar();

    public int getCapacity() {
        return this.magicalenergyCapacity;
    }

    public int getEnergyConsumption() {
        return this.magicalenergyConsumedPerTick;
    }

    public int getSpeed() {
        return this.processingSpeed;
    }

    public final AMagicalContainer setCapacity(int capacity) {
        Validate.isTrue(capacity > 0, "The capacity must be greater than zero!");
        if (this.getState() == ItemState.UNREGISTERED) {
            this.magicalenergyCapacity = capacity;
            return this;
        } else {
            throw new IllegalStateException("You cannot modify the capacity after the Item was registered.");
        }
    }

    public final AMagicalContainer setProcessingSpeed(int speed) {
        Validate.isTrue(speed > 0, "The speed must be greater than zero!");
        this.processingSpeed = speed;
        return this;
    }

    public final AMagicalContainer setEnergyConsumption(int energyConsumption) {
        Validate.isTrue(energyConsumption > 0, "The energy consumption must be greater than zero!");
        Validate.isTrue(this.magicalenergyCapacity > 0, "You must specify the capacity before you can set the consumption amount.");
        Validate.isTrue(energyConsumption <= this.magicalenergyCapacity, "The energy consumption cannot be higher than the capacity (" + this.magicalenergyCapacity + ")");
        this.magicalenergyConsumedPerTick = energyConsumption;
        return this;
    }

    public void register(@Nonnull SlimefunAddon addon) {
        this.addon = addon;
        if (this.getCapacity() <= 0) {
            this.warn("The capacity has not been configured correctly. The Item was disabled.");
            this.warn("Make sure to call '" + this.getClass().getSimpleName() + "#setEnergyCapacity(...)' before registering!");
        }

        if (this.getEnergyConsumption() <= 0) {
            this.warn("The energy consumption has not been configured correctly. The Item was disabled.");
            this.warn("Make sure to call '" + this.getClass().getSimpleName() + "#setEnergyConsumption(...)' before registering!");
        }

        if (this.getSpeed() <= 0) {
            this.warn("The processing speed has not been configured correctly. The Item was disabled.");
            this.warn("Make sure to call '" + this.getClass().getSimpleName() + "#setProcessingSpeed(...)' before registering!");
        }

        if (this.getCapacity() > 0 && this.getEnergyConsumption() > 0 && this.getSpeed() > 0) {
            super.register(addon);
        }

        this.registerDefaultRecipes();
    }

    @Nonnull
    public abstract String getMachineIdentifier();

    protected void registerDefaultRecipes() {
    }

    public List<MachineRecipe> getMachineRecipes() {
        return this.recipes;
    }

    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> displayRecipes = new ArrayList(this.recipes.size() * 2);
        Iterator var2 = this.recipes.iterator();

        while(var2.hasNext()) {
            MachineRecipe recipe = (MachineRecipe)var2.next();
            if (recipe.getInput().length == 1) {
                displayRecipes.add(recipe.getInput()[0]);
                displayRecipes.add(recipe.getOutput()[0]);
            }
        }

        return displayRecipes;
    }

    public int[] getInputSlots() {
        return new int[]{19, 20};
    }

    public int[] getOutputSlots() {
        return new int[]{24, 25};
    }

    public MagicalEnergyNetComponentType getEnergyComponentType() {
        return MagicalEnergyNetComponentType.CONSUMER;
    }

    public void registerRecipe(MachineRecipe recipe) {
        recipe.setTicks(recipe.getTicks() / this.getSpeed());
        this.recipes.add(recipe);
    }

    public void registerRecipe(int seconds, ItemStack[] input, ItemStack[] output) {
        this.registerRecipe(new MachineRecipe(seconds, input, output));
    }

    public void registerRecipe(int seconds, ItemStack input, ItemStack output) {
        this.registerRecipe(new MachineRecipe(seconds, new ItemStack[]{input}, new ItemStack[]{output}));
    }

    public void preRegister() {
        this.addItemHandler(new ItemHandler[]{new BlockTicker() {
            public void tick(Block b, SlimefunItem sf, Config data) {
                AMagicalContainer.this.tick(b);
            }

            public boolean isSynchronized() {
                return false;
            }
        }});
    }

    protected void tick(Block b) {
        BlockMenu inv = BlockStorage.getInventory(b);
        CraftingOperation currentOperation = (CraftingOperation)this.processor.getOperation(b);
        if (currentOperation != null) {
            if (this.takeCharge(b.getLocation())) {
                if (!currentOperation.isFinished()) {
                    this.processor.updateProgressBar(inv, 22, currentOperation);
                    currentOperation.addProgress(1);
                } else {
                    inv.replaceExistingItem(22, new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE, " ", new String[0]));
                    ItemStack[] var4 = currentOperation.getResults();
                    int var5 = var4.length;

                    for(int var6 = 0; var6 < var5; ++var6) {
                        ItemStack output = var4[var6];
                        inv.pushItem(output.clone(), this.getOutputSlots());
                    }

                    this.processor.endOperation(b);
                }
            }
        } else {
            MachineRecipe next = this.findNextRecipe(inv);
            if (next != null) {
                currentOperation = new CraftingOperation(next);
                this.processor.startOperation(b, currentOperation);
                this.processor.updateProgressBar(inv, 22, currentOperation);
            }
        }

    }

    protected boolean takeCharge(@Nonnull Location l) {
        Validate.notNull(l, "Can't attempt to take charge from a null location!");
        if (this.isChargeable()) {
            int charge = this.getCharge(l);
            if (charge < this.getEnergyConsumption()) {
                return false;
            } else {
                this.setCharge(l, charge - this.getEnergyConsumption());
                return true;
            }
        } else {
            return true;
        }
    }

    protected MachineRecipe findNextRecipe(BlockMenu inv) {
        Map<Integer, ItemStack> inventory = new HashMap();
        int[] var3 = this.getInputSlots();
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            int slot = var3[var5];
            ItemStack item = inv.getItemInSlot(slot);
            if (item != null) {
                inventory.put(slot, ItemStackWrapper.wrap(item));
            }
        }

        Map<Integer, Integer> found = new HashMap();
        Iterator var15 = this.recipes.iterator();

        while(var15.hasNext()) {
            MachineRecipe recipe = (MachineRecipe)var15.next();
            ItemStack[] var17 = recipe.getInput();
            int var19 = var17.length;

            for(int var8 = 0; var8 < var19; ++var8) {
                ItemStack input = var17[var8];
                int[] var10 = this.getInputSlots();
                int var11 = var10.length;

                for(int var12 = 0; var12 < var11; ++var12) {
                    int slot = var10[var12];
                    if (SlimefunUtils.isItemSimilar((ItemStack)inventory.get(slot), input, true)) {
                        found.put(slot, input.getAmount());
                        break;
                    }
                }
            }

            if (found.size() == recipe.getInput().length) {
                if (!InvUtils.fitAll(inv.toInventory(), recipe.getOutput(), this.getOutputSlots())) {
                    return null;
                }

                Iterator var18 = found.entrySet().iterator();

                while(var18.hasNext()) {
                    Map.Entry<Integer, Integer> entry = (Map.Entry)var18.next();
                    inv.consumeItem((Integer)entry.getKey(), (Integer)entry.getValue());
                }

                return recipe;
            }

            found.clear();
        }

        return null;
    }
}
