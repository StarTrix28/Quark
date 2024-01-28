package me.startrix.quark;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.startrix.quark.items.energymagic.AdvancedMagicCapacitor;
import me.startrix.quark.items.energymagic.BasicMagicCapacitor;
import me.startrix.quark.items.energymagic.MagicalEnergyConnector;
import me.startrix.quark.items.magic.MagicStone;
import me.startrix.quark.items.machines.StoneGenerator;
import me.startrix.quark.items.magic.MagicWandIron;
import me.startrix.quark.items.magic.MagicalCrucible;
import me.startrix.quark.items.energymagic.MagicalEnergyRegulator;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static me.startrix.quark.ItemsDefine.*;

public class ItemSetup {
    static final ItemSetup INSTANCE = new ItemSetup();
    private final SlimefunAddon plugin;
    private boolean initialised;
    public ItemSetup() {
        this.plugin = Main.getInstance();
    }

    public void init() {
        if (!this.initialised) {
            this.initialised = true;
            this.registerBasic();
            this.registerMachines();
            this.registerMagicalItems();
            this.registerEnergyMagic();
        }
    }
    private void registerBasic() {
        this.registerItem(CategoryBasic,Wooden_Helmet,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack(Material.OAK_LOG), new ItemStack(Material.OAK_LOG), new ItemStack(Material.OAK_LOG),new ItemStack(Material.OAK_LOG), null, new ItemStack(Material.OAK_LOG),null, null, null);
        this.registerItem(CategoryBasic,Wooden_Chestplate,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack(Material.OAK_LOG),null,new ItemStack(Material.OAK_LOG),new ItemStack(Material.OAK_LOG),new ItemStack(Material.OAK_LOG),new ItemStack(Material.OAK_LOG),new ItemStack(Material.OAK_LOG), new ItemStack(Material.OAK_LOG), new ItemStack(Material.OAK_LOG));
        this.registerItem(CategoryBasic,Wooden_Leggings,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack(Material.OAK_LOG), new ItemStack(Material.OAK_LOG), new ItemStack(Material.OAK_LOG),new ItemStack(Material.OAK_LOG), null, new ItemStack(Material.OAK_LOG),new ItemStack(Material.OAK_LOG), null, new ItemStack(Material.OAK_LOG));
        this.registerItem(CategoryBasic,Wooden_Boots,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack(Material.OAK_LOG), null, new ItemStack(Material.OAK_LOG),new ItemStack(Material.OAK_LOG), null, new ItemStack(Material.OAK_LOG),null, null, null);
        this.registerItem(CategoryBasic,Flint_Pickaxe,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack(Material.FLINT),new ItemStack(Material.FLINT),new ItemStack(Material.FLINT),null,new ItemStack(Material.STICK),null,null,new ItemStack(Material.STICK), null);
    }
    private void registerMachines() {
        (new StoneGenerator()).register(this.plugin);
    }
    public void registerMagicalItems() {
        this.registerItem(CategoryMagic,Magic_Rune,RecipeType.ANCIENT_ALTAR, SlimefunItems.MAGIC_LUMP_3,SlimefunItems.MAGIC_LUMP_3,SlimefunItems.MAGIC_LUMP_3,SlimefunItems.MAGIC_LUMP_3,SlimefunItems.BLANK_RUNE,SlimefunItems.MAGIC_LUMP_3,SlimefunItems.MAGIC_LUMP_3,SlimefunItems.MAGIC_LUMP_3,SlimefunItems.MAGIC_LUMP_3);
        (new MagicStone()).register(this.plugin);
        (new MagicWandIron()).register(this.plugin);
        (new MagicalCrucible()).register(this.plugin);
        this.registerItem(CategoryMagic,MagicalEssence,RecipeType.MOB_DROP,null,null,null,null,new CustomItemStack(Material.PURPLE_WOOL,"Witch"));
        this.registerItemNoRecipe(CategoryMagic,MagicalGlowstoneDust);
        this.registerItemNoRecipe(CategoryMagic,MagicalGlowstone);
    }
    public void registerMiscellaneous() {
        this.registerItem(CategoryMiscellaneous,Steel_Cage,RecipeType.ENHANCED_CRAFTING_TABLE,SlimefunItems.STEEL_INGOT,SlimefunItems.STEEL_INGOT,SlimefunItems.STEEL_INGOT,new ItemStack(Material.IRON_BARS),new ItemStack(Material.IRON_BARS),new ItemStack(Material.IRON_BARS), SlimefunItems.STEEL_INGOT,SlimefunItems.STEEL_INGOT,SlimefunItems.STEEL_INGOT);
        this.registerItem(CategoryMiscellaneous,Iron_Cap,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack(Material.IRON_NUGGET),new ItemStack(Material.IRON_NUGGET),new ItemStack(Material.IRON_NUGGET),new ItemStack(Material.IRON_NUGGET),null,new ItemStack(Material.IRON_NUGGET));
    }
    private void registerEnergyMagic() {
        (new BasicMagicCapacitor()).register(this.plugin);
        (new AdvancedMagicCapacitor()).register(this.plugin);
        (new MagicalEnergyRegulator()).register(this.plugin);
        (new MagicalEnergyConnector()).register(this.plugin);
    }
    private void registerItem(ItemGroup group, SlimefunItemStack item, RecipeType type, ItemStack... items) {
        SlimefunItem sfitem = new SlimefunItem(group,item,type, items);
        sfitem.register(this.plugin);
    }
    private void registerItemNoRecipe(ItemGroup group,SlimefunItemStack item) {
        SlimefunItem sfitem = new SlimefunItem(group,item,RecipeType.NULL,new ItemStack[]{});
        sfitem.register(this.plugin);
    }

}
