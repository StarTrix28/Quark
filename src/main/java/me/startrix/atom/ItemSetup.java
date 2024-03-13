package me.startrix.atom;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.EnchantedItem;
import io.github.thebusybiscuit.slimefun4.implementation.items.RadioactiveItem;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.Capacitor;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.generators.SolarGenerator;
import io.github.thebusybiscuit.slimefun4.implementation.items.multiblocks.miner.IndustrialMiner;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.startrix.atom.items.energy.EnergyRod;
import me.startrix.atom.items.energy.PowerCube;
import me.startrix.atom.items.energymagic.*;
import me.startrix.atom.items.magic.*;
import me.startrix.atom.items.machines.StoneGenerator;
import me.startrix.atom.libraries.LiquidBucketItem;
import me.startrix.atom.libraries.UnstableItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static me.startrix.atom.ItemsDefine.*;

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
            this.registerTools();
            this.registerMiscellaneous();
            this.registerMultiBlock();
            this.registerTechnicalGear();
            this.registerAdvancedElectricity();
            this.registerEssences();
            this.registerMagicalItems();
            this.registerMagicalResources();
            this.registerMagicalMachines();
            this.registerEnergyMagic();

        }
    }

    private void registerTechnicalGear() {
        (new EnergyRod(128,EnergyRod1,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.REDSTONE_ALLOY,Golden_Rod,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.REDSTONE_ALLOY,Golden_Rod,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.BIG_CAPACITOR,SlimefunItems.REDSTONE_ALLOY})).register(this.plugin);
        (new EnergyRod(512,EnergyRod2,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.REDSTONE_ALLOY,Golden_Rod,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.REDSTONE_ALLOY,EnergyRod1,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.BIG_CAPACITOR,SlimefunItems.REDSTONE_ALLOY})).register(this.plugin);
        (new EnergyRod(1024,EnergyRod3,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.REDSTONE_ALLOY,Golden_Rod,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.REDSTONE_ALLOY,EnergyRod2,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.SMALL_CAPACITOR,SlimefunItems.REDSTONE_ALLOY})).register(this.plugin);
        (new EnergyRod(8192,EnergyRod4,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.REDSTONE_ALLOY,Golden_Rod,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.REDSTONE_ALLOY,EnergyRod3,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.MEDIUM_CAPACITOR,SlimefunItems.REDSTONE_ALLOY})).register(this.plugin);
        (new EnergyRod(16384,EnergyRod5,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.REDSTONE_ALLOY,Golden_Rod,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.REDSTONE_ALLOY,EnergyRod4,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.BIG_CAPACITOR,SlimefunItems.REDSTONE_ALLOY})).register(this.plugin);
        (new EnergyRod(32768,EnergyRod6,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.REDSTONE_ALLOY,Golden_Rod,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.REDSTONE_ALLOY,EnergyRod5,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.LARGE_CAPACITOR,SlimefunItems.REDSTONE_ALLOY})).register(this.plugin);
        (new EnergyRod(65536,EnergyRod7,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.REDSTONE_ALLOY,Golden_Rod,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.REDSTONE_ALLOY,EnergyRod6,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.LARGE_CAPACITOR,SlimefunItems.REDSTONE_ALLOY})).register(this.plugin);
        (new EnergyRod(131072,EnergyRod8,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.REDSTONE_ALLOY,Golden_Rod,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.REDSTONE_ALLOY,EnergyRod7,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REDSTONE_ALLOY})).register(this.plugin);
        (new EnergyRod(262144,EnergyRod9,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.REDSTONE_ALLOY,Golden_Rod,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.REDSTONE_ALLOY,EnergyRod8,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.REDSTONE_ALLOY,Capacitor6,SlimefunItems.REDSTONE_ALLOY})).register(this.plugin);
    }

    private void registerBasic() {
        this.registerItem(CategoryBasic,Wooden_Helmet,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack(Material.OAK_LOG), new ItemStack(Material.OAK_LOG), new ItemStack(Material.OAK_LOG),new ItemStack(Material.OAK_LOG), null, new ItemStack(Material.OAK_LOG),null, null, null);
        this.registerItem(CategoryBasic,Wooden_Chestplate,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack(Material.OAK_LOG),null,new ItemStack(Material.OAK_LOG),new ItemStack(Material.OAK_LOG),new ItemStack(Material.OAK_LOG),new ItemStack(Material.OAK_LOG),new ItemStack(Material.OAK_LOG), new ItemStack(Material.OAK_LOG), new ItemStack(Material.OAK_LOG));
        this.registerItem(CategoryBasic,Wooden_Leggings,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack(Material.OAK_LOG), new ItemStack(Material.OAK_LOG), new ItemStack(Material.OAK_LOG),new ItemStack(Material.OAK_LOG), null, new ItemStack(Material.OAK_LOG),new ItemStack(Material.OAK_LOG), null, new ItemStack(Material.OAK_LOG));
        this.registerItem(CategoryBasic,Wooden_Boots,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack(Material.OAK_LOG), null, new ItemStack(Material.OAK_LOG),new ItemStack(Material.OAK_LOG), null, new ItemStack(Material.OAK_LOG),null, null, null);
        this.registerItem(CategoryBasic,Flint_Pickaxe,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack(Material.FLINT),new ItemStack(Material.FLINT),new ItemStack(Material.FLINT),null,new ItemStack(Material.STICK),null,null,new ItemStack(Material.STICK), null);
    }
    private void registerMultiBlock() {
        (new IndustrialMiner(CategoryMultiblock,KiloMiner,Material.ANCIENT_DEBRIS,true,15)).register(this.plugin);
        (new IndustrialMiner(CategoryMultiblock,MegaMiner,Material.NETHERITE_BLOCK,true,20)).register(this.plugin);
    }
    private void registerAdvancedElectricity() {
        (new SolarGenerator(CategoryAdvancedElectricity,512,256,Solar_Generator5,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.SOLAR_GENERATOR_4,SlimefunItems.REINFORCED_PLATE,SlimefunItems.SOLAR_GENERATOR_4,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.SOLAR_GENERATOR_4,SlimefunItems.REINFORCED_PLATE,SlimefunItems.SOLAR_GENERATOR_4})).register(this.plugin);
        (new SolarGenerator(CategoryAdvancedElectricity,1024,512,Solar_Generator6,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Solar_Generator5,SlimefunItems.REINFORCED_PLATE,Solar_Generator5,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,Solar_Generator5,SlimefunItems.REINFORCED_PLATE,Solar_Generator5})).register(this.plugin);
        (new SolarGenerator(CategoryAdvancedElectricity,2048,1024,Solar_Generator7,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Solar_Generator6,SlimefunItems.REINFORCED_PLATE,Solar_Generator6,SlimefunItems.REINFORCED_PLATE,Boosted_ElectroMagnet,SlimefunItems.REINFORCED_PLATE,Solar_Generator6,SlimefunItems.REINFORCED_PLATE,Solar_Generator6})).register(this.plugin);
        (new SolarGenerator(CategoryAdvancedElectricity,4096,2048,Solar_Generator8,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Solar_Generator7,SlimefunItems.REINFORCED_PLATE,Solar_Generator7,SlimefunItems.REINFORCED_PLATE,Boosted_ElectroMagnet,SlimefunItems.REINFORCED_PLATE,Solar_Generator7,SlimefunItems.REINFORCED_PLATE,Solar_Generator7})).register(this.plugin);
        (new SolarGenerator(CategoryAdvancedElectricity,8192,4096,Solar_Generator9,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Solar_Generator8,SlimefunItems.REINFORCED_PLATE,Solar_Generator8,SlimefunItems.REINFORCED_PLATE,Boosted_ElectroMagnet,SlimefunItems.REINFORCED_PLATE,Solar_Generator8,SlimefunItems.REINFORCED_PLATE,Solar_Generator8})).register(this.plugin);
        (new SolarGenerator(CategoryAdvancedElectricity,16384,8192,Solar_Generator10,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Solar_Generator9,SlimefunItems.REINFORCED_PLATE,Solar_Generator9,RedstoneAlloy_Plate,Block_of_Blistering_Ingot,RedstoneAlloy_Plate,Solar_Generator9,RedstoneAlloy_Plate,Solar_Generator9})).register(this.plugin);
        (new SolarGenerator(CategoryAdvancedElectricity,32768,16384,Solar_Generator11,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Solar_Generator10,RedstoneAlloy_Plate,Solar_Generator10,RedstoneAlloy_Plate,Block_of_Blistering_Ingot,RedstoneAlloy_Plate,Solar_Generator10,RedstoneAlloy_Plate,Solar_Generator10})).register(this.plugin);
        (new SolarGenerator(CategoryAdvancedElectricity,65536,32768,Solar_Generator12,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Solar_Generator11,RedstoneAlloy_Plate,Solar_Generator11,RedstoneAlloy_Plate,Block_of_Blistering_Ingot,RedstoneAlloy_Plate,Solar_Generator11,RedstoneAlloy_Plate,Solar_Generator11})).register(this.plugin);
        (new SolarGenerator(CategoryAdvancedElectricity,131072,65536,Solar_Generator13,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Solar_Generator12,RedstoneAlloy_Plate,Solar_Generator12,RedstoneAlloy_Plate,Block_of_Blistering_Ingot,RedstoneAlloy_Plate,Solar_Generator12,RedstoneAlloy_Plate,Solar_Generator12})).register(this.plugin);
        (new Capacitor(CategoryAdvancedElectricity,1000000, Capacitor6,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR})).register(this.plugin);
        (new Capacitor(CategoryAdvancedElectricity,2000000,Capacitor7,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Capacitor6,SlimefunItems.REINFORCED_PLATE,Capacitor6,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,Capacitor6,SlimefunItems.REINFORCED_PLATE,Capacitor6})).register(this.plugin);
        (new Capacitor(CategoryAdvancedElectricity,4000000,Capacitor8,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Capacitor7,SlimefunItems.REINFORCED_PLATE,Capacitor7,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,Capacitor7,SlimefunItems.REINFORCED_PLATE,Capacitor7})).register(this.plugin);
        (new Capacitor(CategoryAdvancedElectricity,8000000,Capacitor9,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Capacitor8,SlimefunItems.REINFORCED_PLATE,Capacitor8,SlimefunItems.REINFORCED_PLATE,Boosted_ElectroMagnet,SlimefunItems.REINFORCED_PLATE,Capacitor8,SlimefunItems.REINFORCED_PLATE,Capacitor8})).register(this.plugin);
        (new Capacitor(CategoryAdvancedElectricity,16000000, Capacitor10,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Capacitor9,RedstoneAlloy_Plate,Capacitor9,RedstoneAlloy_Plate,Boosted_ElectroMagnet,RedstoneAlloy_Plate,Capacitor9,RedstoneAlloy_Plate,Capacitor9})).register(this.plugin);
        (new Capacitor(CategoryAdvancedElectricity,32000000,Capacitor11,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Capacitor10,RedstoneAlloy_Plate,Capacitor10,RedstoneAlloy_Plate,Boosted_ElectroMagnet,RedstoneAlloy_Plate,Capacitor10,RedstoneAlloy_Plate,Capacitor10})).register(this.plugin);
        (new Capacitor(CategoryAdvancedElectricity,64000000,Capacitor12,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Capacitor11,RedstoneAlloy_Plate,Capacitor11,RedstoneAlloy_Plate,Boosted_ElectroMagnet,RedstoneAlloy_Plate,Capacitor11,RedstoneAlloy_Plate,Capacitor11})).register(this.plugin);
        (new Capacitor(CategoryAdvancedElectricity,128000000,Capacitor13,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Capacitor12,RedstoneAlloy_Plate,Capacitor12,RedstoneAlloy_Plate,Block_of_Blistering_Ingot,RedstoneAlloy_Plate,Capacitor12,RedstoneAlloy_Plate,Capacitor12})).register(this.plugin);
        (new Capacitor(CategoryAdvancedElectricity,256000000,Capacitor14,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Capacitor13,RedstoneAlloy_Plate,Capacitor13,RedstoneAlloy_Plate,Block_of_Blistering_Ingot,RedstoneAlloy_Plate,Capacitor13,RedstoneAlloy_Plate,Capacitor13})).register(this.plugin);
        (new PowerCube(128,PowerCube1,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.REINFORCED_PLATE,Boosted_ElectroMagnet,SlimefunItems.REINFORCED_PLATE,Boosted_ElectroMagnet,SlimefunItems.BIG_CAPACITOR,Boosted_ElectroMagnet,SlimefunItems.REINFORCED_PLATE,Boosted_ElectroMagnet,SlimefunItems.REINFORCED_PLATE})).register(this.plugin);
        (new StoneGenerator()).register(this.plugin);
    }
    public void registerMagicalMachines() {
        (new EssenceGrinder()).register(this.plugin);
    }
    public void registerMagicalItems() {
        (new MagicStone()).register(this.plugin);
        (new MagicWand(CategoryMagic,16,MagicWandIron,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{null,null,Iron_Cap,null,new ItemStack(Material.STICK),null,Iron_Cap,null,null})).register(this.plugin);
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
    public void registerMiscellaneous() {
        this.registerItem(CategoryMiscellaneous,Steel_Cage,RecipeType.ENHANCED_CRAFTING_TABLE,SlimefunItems.STEEL_INGOT,SlimefunItems.STEEL_INGOT,SlimefunItems.STEEL_INGOT,new ItemStack(Material.IRON_BARS),new ItemStack(Material.IRON_BARS),new ItemStack(Material.IRON_BARS), SlimefunItems.STEEL_INGOT,SlimefunItems.STEEL_INGOT,SlimefunItems.STEEL_INGOT);
        this.registerItem(CategoryMiscellaneous,Iron_Cap,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack(Material.IRON_NUGGET),new ItemStack(Material.IRON_NUGGET),new ItemStack(Material.IRON_NUGGET),new ItemStack(Material.IRON_NUGGET),null,new ItemStack(Material.IRON_NUGGET));
        this.registerItem(CategoryMiscellaneous,ConcentratedFireCharge,RecipeType.MAGIC_WORKBENCH,new ItemStack(Material.FIRE_CHARGE),new ItemStack(Material.FIRE_CHARGE),new ItemStack(Material.FIRE_CHARGE),new ItemStack(Material.FIRE_CHARGE),new ItemStack(Material.FIRE_CHARGE),new ItemStack(Material.FIRE_CHARGE),new ItemStack(Material.FIRE_CHARGE),new ItemStack(Material.FIRE_CHARGE),new ItemStack(Material.FIRE_CHARGE));
        this.registerItem(CategoryMiscellaneous,ConcentratedFireChargeS,new RecipeType(new ItemStack(Material.STICK),"wand_interaction"),null,null,null,null,null,new CustomItemStack(Material.STICK,"Wand"),null,new CustomItemStack(Material.MAGMA_BLOCK,"Right Click"));
        (new RadioactiveItem(CategoryMiscellaneous,Radioactivity.VERY_DEADLY, Block_of_Blistering_Ingot, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.BLISTERING_INGOT_3})).register(this.plugin);
        (new EnchantedItem(CategoryMiscellaneous,Boosted_ElectroMagnet,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.IRON_DUST,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.IRON_DUST,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.ELECTRO_MAGNET,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.IRON_DUST,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.IRON_DUST,})).register(this.plugin);
        this.registerItem(CategoryMiscellaneous,Golden_Rod,RecipeType.ENHANCED_CRAFTING_TABLE,null,SlimefunItems.GOLD_18K,null,null,SlimefunItems.GOLD_18K,null,null,SlimefunItems.GOLD_18K,null);
        this.registerItem(CategoryMiscellaneous,RedstoneAlloy_Plate,RecipeType.COMPRESSOR,new SlimefunItemStack(SlimefunItems.REDSTONE_ALLOY,8));
    }
    private void registerEnergyMagic() {
        (new MagicalCapacitor(CategoryEnergyMagic,64,Basic_Magic_Capacitor,RecipeType.MAGIC_WORKBENCH,new ItemStack[]{MagicGlass,SlimefunItems.BILLON_INGOT,MagicGlass,MagicGlass,Steel_Cage,MagicGlass,MagicGlass,SlimefunItems.BILLON_INGOT,MagicGlass})).register(this.plugin);
        (new MagicalCapacitor(CategoryEnergyMagic,128,Advanced_Magic_Capacitor, RecipeType.MAGIC_WORKBENCH,new ItemStack[]{MagicGlass,SlimefunItems.REINFORCED_ALLOY_INGOT,MagicGlass,MagicGlass,Basic_Magic_Capacitor,MagicGlass,MagicGlass,SlimefunItems.REDSTONE_ALLOY,MagicGlass})).register(this.plugin);
        (new MagicalEnergyRegulator()).register(this.plugin);
        (new MagicalEnergyConnector()).register(this.plugin);
        (new MagicEnergyGenerator()).register(this.plugin);
    }
    private void registerTools() {
        this.registerItem(CategoryTools,Hammer,RecipeType.ENHANCED_CRAFTING_TABLE,null,new ItemStack(Material.IRON_INGOT),new ItemStack(Material.STICK),null,new ItemStack(Material.STICK),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.STICK),null,null);
    }
    private void registerItem(ItemGroup group, SlimefunItemStack item, RecipeType type, ItemStack... items) {
        SlimefunItem sfitem = new SlimefunItem(group,item,type, items);
        sfitem.register(this.plugin);
    }
    private void registerItemNoRecipe(ItemGroup group,SlimefunItemStack item) {
        SlimefunItem sfitem = new SlimefunItem(group,item,new RecipeType(new CustomItemStack(Material.BARRIER,"Not yet implemented"),"notimplemented"),new ItemStack[]{});
        sfitem.register(this.plugin);
    }
    private void registerItemWandRecipe(ItemGroup group,SlimefunItemStack item,ItemStack recipe) {
        SlimefunItem sfitem = new SlimefunItem(group,item,new RecipeType(new CustomItemStack(Material.STICK,"Magic Wand Interaction"),"magicwand"),new ItemStack[]{null,null,new CustomItemStack(Material.STICK,"Magic Wand"),null,recipe,null,null,null,null});
        sfitem.register(this.plugin);
    }
    private void registerUnstableWandRecipeItem(int stability,ItemGroup group,SlimefunItemStack item,ItemStack recipe) {
        (new UnstableItem(group, item,stability, new RecipeType(new CustomItemStack(Material.STICK, "Magic Wand Interaction"), "magicwand"), new ItemStack[]{null, null, new CustomItemStack(Material.STICK, "Magic Wand"), null, recipe, null, null, null, null})).register(this.plugin);
    }
}

