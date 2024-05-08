package me.startrix.quark.quarkmagic;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.startrix.quark.Quark;
import me.startrix.quark.core.items.LiquidBucketItem;
import me.startrix.quark.core.items.UnstableItem;
import me.startrix.quark.quarkmagic.block.*;
import me.startrix.quark.quarkmagic.energymagic.MagicEnergyGenerator;
import me.startrix.quark.quarkmagic.energymagic.MagicalCapacitor;
import me.startrix.quark.quarkmagic.energymagic.MagicalEnergyConnector;
import me.startrix.quark.quarkmagic.energymagic.MagicalEnergyRegulator;
import me.startrix.quark.quarkmagic.items.MagicHammer;
import me.startrix.quark.quarkmagic.items.MagicStone;
import me.startrix.quark.quarkmagic.items.MagicWand;
import me.startrix.quark.quarkmagic.items.essence.*;
import me.startrix.quark.quarkmagic.items.essence.unstable.*;
import me.startrix.quark.quarkmagic.items.time.TimeSand;
import me.startrix.quark.quarkmagic.items.time.TimeStableClock;
import me.startrix.quark.quarkmagic.items.time.TimeSword;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static me.startrix.quark.quark.QuarkItemsDefine.Iron_Cap;
import static me.startrix.quark.quark.QuarkItemsDefine.Steel_Cage;
import static me.startrix.quark.quarkmagic.QuarkMagicalItemsDefine.*;

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
        (new EssenceInfuser()).register(this.plugin);
        (new EssencePhotonicSeparator()).register(this.plugin);
        (new EssencePhotonicSeparator2()).register(this.plugin);
        (new ResearchHub()).register(this.plugin);
        (new GlowStoneGrinder()).register(this.plugin);
    }
    public void registerMagicalItems() {
        (new MagicStone()).register(this.plugin);
        (new MagicWand(CategoryMagic,16,MagicWandIron, RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{null,null,Iron_Cap,null,new ItemStack(Material.STICK),null,Iron_Cap,null,null})).register(this.plugin);
        (new MagicalCrucible()).register(this.plugin);
        (new LiquidBucketItem(CategoryMagic,MagicWater,0,new RecipeType(new CustomItemStack(Material.CAULDRON,"Magical Crucible"),"magiccrucible"),new ItemStack[]{new ItemStack(Material.WATER_BUCKET),MagicalEssence})).register(this.plugin);
        (new MagicHammer()).register(this.plugin);
        (new TimeSword()).register(this.plugin);
        (new TimeStableClock()).register(this.plugin);
        (new TimeSand()).register(this.plugin);
    }
    public void registerEssences() {
        (new MagicalEssence()).register(this.plugin);
        (new BlueEssence()).register(this.plugin);
        (new GreenEssence()).register(this.plugin);
        (new StableEssence()).register(this.plugin);
        (new RedEssence()).register(this.plugin);
        (new BlackEssence()).register(this.plugin);
        (new PositionalEssence()).register(this.plugin);
        (new FabricEssence()).register(this.plugin);
        (new ColdEssence()).register(this.plugin);
        (new HotEssence()).register(this.plugin);
        (new UnstableRedEssence()).register(this.plugin);
        (new UnstableBlackEssence()).register(this.plugin);
        (new UnstablePositionalEssence()).register(this.plugin);
        (new UnstableFabricEssence()).register(this.plugin);
        (new UnstableColdEssence()).register(this.plugin);
        (new UnstableHotEssence()).register(this.plugin);
    }
    public void registerMagicalResources() {
        this.registerItem(CategoryMagicalResources,Magic_Rune,RecipeType.ANCIENT_ALTAR, SlimefunItems.MAGIC_LUMP_3,SlimefunItems.MAGIC_LUMP_3,SlimefunItems.MAGIC_LUMP_3,SlimefunItems.MAGIC_LUMP_3,SlimefunItems.BLANK_RUNE,SlimefunItems.MAGIC_LUMP_3,SlimefunItems.MAGIC_LUMP_3,SlimefunItems.MAGIC_LUMP_3,SlimefunItems.MAGIC_LUMP_3);
        this.registerUnstableWandRecipeItem(1,CategoryMagicalResources,MagicalGlowstoneDust,new ItemStack(Material.GLOWSTONE_DUST));
        this.registerUnstableWandRecipeItem(1,CategoryMagicalResources,MagicalGlowstone,new ItemStack(Material.GLOWSTONE));
        this.registerItemNoRecipe(CategoryMagicalResources,MagicGlass);
        this.registerItemNoRecipe(CategoryMagicalResources,MagicGlassDust);
        this.registerItemNoRecipe(CategoryMagicalResources,GlassDust);
        this.registerItemNoRecipe(CategoryMagicalResources,Photonus);
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
