package me.startrix.quark.setup;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.startrix.quark.Quark;
import me.startrix.quark.quarkmagic.energymagic.MagicEnergyGenerator;
import me.startrix.quark.quarkmagic.energymagic.MagicalCapacitor;
import me.startrix.quark.quarkmagic.energymagic.MagicalEnergyConnector;
import me.startrix.quark.quarkmagic.energymagic.MagicalEnergyRegulator;
import me.startrix.quark.quarkmagic.magic.*;
import me.startrix.quark.libraries.LiquidBucketItem;
import me.startrix.quark.libraries.UnstableItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static me.startrix.quark.define.QuarkItemsDefine.Iron_Cap;
import static me.startrix.quark.define.QuarkItemsDefine.Steel_Cage;
import static me.startrix.quark.define.QuarkMagicalItemsDefine.*;
import static me.startrix.quark.define.QuarkMagicalItemsDefine.MagicGlass;

public class MagicItemsSetup {
    public static final MagicItemsSetup INSTANCE = new MagicItemsSetup();
    private final SlimefunAddon plugin;
    private boolean initialised;

    public MagicItemsSetup() {
        this.plugin = Quark.getInstance();
    }

    public void init() {
        if (!this.initialised) {
            this.initialised = true;
            this.registerEssences();
            this.registerMagicalItems();
            this.registerMagicalResources();
            this.registerMagicalMachines();
            this.registerEnergyMagic();
        }
    }
    public void registerMagicalMachines() {
        (new EssenceGrinder()).register(this.plugin);
    }
    public void registerMagicalItems() {
        (new MagicStone()).register(this.plugin);
        (new MagicWand(CategoryMagic,16,MagicWandIron, RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{null,null,Iron_Cap,null,new ItemStack(Material.STICK),null,Iron_Cap,null,null})).register(this.plugin);
        (new MagicalCrucible()).register(this.plugin);
        (new LiquidBucketItem(CategoryMagic,MagicWater,0,new RecipeType(new CustomItemStack(Material.CAULDRON,"Magical Crucible"),"magiccrucible"),new ItemStack[]{new ItemStack(Material.WATER_BUCKET),MagicalEssence})).register(this.plugin);
    }
    public void registerEssences() {
        (new MagicalEssence()).register(this.plugin);
        this.registerItemNoRecipe(CategoryEssences,StabilityEssence);
        this.registerItemNoRecipe(CategoryEssences,HeatEssence);
        this.registerItemNoRecipe(CategoryEssences,ColdEssence);
        this.registerItemNoRecipe(CategoryEssences,RedEssence);
        this.registerItemNoRecipe(CategoryEssences,DarkEssence);
    }
    public void registerMagicalResources() {
        this.registerItem(CategoryMagicalResources,Magic_Rune,RecipeType.ANCIENT_ALTAR, SlimefunItems.MAGIC_LUMP_3,SlimefunItems.MAGIC_LUMP_3,SlimefunItems.MAGIC_LUMP_3,SlimefunItems.MAGIC_LUMP_3,SlimefunItems.BLANK_RUNE,SlimefunItems.MAGIC_LUMP_3,SlimefunItems.MAGIC_LUMP_3,SlimefunItems.MAGIC_LUMP_3,SlimefunItems.MAGIC_LUMP_3);
        this.registerUnstableWandRecipeItem(1,CategoryMagicalResources,MagicalGlowstoneDust,new ItemStack(Material.GLOWSTONE_DUST));
        this.registerUnstableWandRecipeItem(1,CategoryMagicalResources,MagicalGlowstone,new ItemStack(Material.GLOWSTONE));
        this.registerItemNoRecipe(CategoryMagicalResources,MagicGlass);
    }
    private void registerEnergyMagic() {
        (new MagicalCapacitor(CategoryEnergyMagic,64,Basic_Magic_Capacitor,RecipeType.MAGIC_WORKBENCH,new ItemStack[]{MagicGlass,SlimefunItems.BILLON_INGOT,MagicGlass,MagicGlass,Steel_Cage,MagicGlass,MagicGlass,SlimefunItems.BILLON_INGOT,MagicGlass})).register(this.plugin);
        (new MagicalCapacitor(CategoryEnergyMagic,128,Advanced_Magic_Capacitor, RecipeType.MAGIC_WORKBENCH,new ItemStack[]{MagicGlass,SlimefunItems.REINFORCED_ALLOY_INGOT,MagicGlass,MagicGlass,Basic_Magic_Capacitor,MagicGlass,MagicGlass,SlimefunItems.REDSTONE_ALLOY,MagicGlass})).register(this.plugin);
        (new MagicalEnergyRegulator()).register(this.plugin);
        (new MagicalEnergyConnector()).register(this.plugin);
        (new MagicEnergyGenerator()).register(this.plugin);
    }
    private void registerItemWandRecipe(ItemGroup group, SlimefunItemStack item, ItemStack recipe) {
        SlimefunItem sfitem = new SlimefunItem(group,item,new RecipeType(new CustomItemStack(Material.STICK,"Magic Wand Interaction"),"magicwand"),new ItemStack[]{null,null,new CustomItemStack(Material.STICK,"Magic Wand"),null,recipe,null,null,null,null});
        sfitem.register(this.plugin);
    }
    private void registerUnstableWandRecipeItem(int stability,ItemGroup group,SlimefunItemStack item,ItemStack recipe) {
        (new UnstableItem(group, item,stability, new RecipeType(new CustomItemStack(Material.STICK, "Magic Wand Interaction"), "magicwand"), new ItemStack[]{null, null, new CustomItemStack(Material.STICK, "Magic Wand"), null, recipe, null, null, null, null})).register(this.plugin);
    }
    private void registerItem(ItemGroup group, SlimefunItemStack item, RecipeType type, ItemStack... items) {
        SlimefunItem sfitem = new SlimefunItem(group,item,type, items);
        sfitem.register(this.plugin);
    }
    private void registerItemNoRecipe(ItemGroup group,SlimefunItemStack item) {
        SlimefunItem sfitem = new SlimefunItem(group,item,new RecipeType(new CustomItemStack(Material.BARRIER,"Not yet implemented"),"notimplemented"),new ItemStack[]{});
        sfitem.register(this.plugin);
    }
}
