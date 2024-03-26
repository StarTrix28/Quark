package me.startrix.quark.setup;

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
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.generators.CoalGenerator;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.generators.SolarGenerator;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.ElectricDustWasher;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.ElectricGoldPan;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.ElectricIngotFactory;
import io.github.thebusybiscuit.slimefun4.implementation.items.multiblocks.miner.IndustrialMiner;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.startrix.quark.quark.energy.EnergyRod;
import me.startrix.quark.quark.energy.PowerCube;
import me.startrix.quark.quark.machines.StoneGenerator;
import me.startrix.quark.libraries.UnstableItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static me.startrix.quark.define.QuarkItemsDefine.*;

public class ItemSetup {
    public static final ItemSetup INSTANCE = new ItemSetup();
    private final SlimefunAddon plugin;
    private boolean initialised;

    public ItemSetup() {
        this.plugin = me.startrix.quark.Quark.getInstance();
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
        this.registerHelmet(CategoryGear,Wooden_Helmet,new ItemStack(Material.OAK_LOG));
        this.registerChestplate(CategoryGear,Wooden_Chestplate,new ItemStack(Material.OAK_LOG));
        this.registerLeggings(CategoryGear,Wooden_Leggings,new ItemStack(Material.OAK_LOG));
        this.registerBoots(CategoryGear,Wooden_Boots,new ItemStack(Material.OAK_LOG));
        this.registerSword(CategoryGear,Flint_Sword,new ItemStack(Material.FLINT));
        this.registerPickaxe(CategoryGear,Flint_Pickaxe,new ItemStack(Material.FLINT));
        this.registerAxe(CategoryGear,Flint_Axe,new ItemStack(Material.FLINT));
        this.registerShovel(CategoryGear,Flint_Shovel,new ItemStack(Material.FLINT));
        this.registerHelmet(CategoryGear,Obsidian_Helmet,new ItemStack(Material.OBSIDIAN));
        this.registerChestplate(CategoryGear,Obsidian_Chestplate,new ItemStack(Material.OBSIDIAN));
        this.registerLeggings(CategoryGear,Obsidian_Leggings,new ItemStack(Material.OBSIDIAN));
        this.registerBoots(CategoryGear,Obsidian_Boots,new ItemStack(Material.OBSIDIAN));
        this.registerSword(CategoryGear,Obsidian_Sword,new ItemStack(Material.OBSIDIAN));
        this.registerPickaxe(CategoryGear,Obsidian_Pickaxe,new ItemStack(Material.OBSIDIAN));
        this.registerAxe(CategoryGear,Obsidian_Axe,new ItemStack(Material.OBSIDIAN));
        this.registerShovel(CategoryGear,Obsidian_Shovel,new ItemStack(Material.OBSIDIAN));
    }
    private void registerMultiBlock() {
        (new IndustrialMiner(CategoryMultiblock, KiloMiner, Material.ANCIENT_DEBRIS, true, 15)).register(this.plugin);
        (new IndustrialMiner(CategoryMultiblock, MegaMiner, Material.NETHERITE_BLOCK, true, 20)).register(this.plugin);
    }
    private void registerAdvancedElectricity() {
        (new SolarGenerator(CategoryAdvancedElectricity,512,256,Solar_Generator5,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.SOLAR_GENERATOR_4,SlimefunItems.REINFORCED_PLATE,SlimefunItems.SOLAR_GENERATOR_4,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.SOLAR_GENERATOR_4,SlimefunItems.REINFORCED_PLATE,SlimefunItems.SOLAR_GENERATOR_4})).register(this.plugin);
        (new SolarGenerator(CategoryAdvancedElectricity,1024,512,Solar_Generator6,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Solar_Generator5,SlimefunItems.REINFORCED_PLATE,Solar_Generator5,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,Solar_Generator5,SlimefunItems.REINFORCED_PLATE,Solar_Generator5})).register(this.plugin);
        (new SolarGenerator(CategoryAdvancedElectricity,2048,1024,Solar_Generator7,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Solar_Generator6,SlimefunItems.REINFORCED_PLATE,Solar_Generator6,SlimefunItems.REINFORCED_PLATE,Boosted_ElectroMagnet,SlimefunItems.REINFORCED_PLATE,Solar_Generator6,SlimefunItems.REINFORCED_PLATE,Solar_Generator6})).register(this.plugin);
        (new SolarGenerator(CategoryAdvancedElectricity,4096,2048,Solar_Generator8,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Solar_Generator7,SlimefunItems.REINFORCED_PLATE,Solar_Generator7,SlimefunItems.REINFORCED_PLATE,Boosted_ElectroMagnet,SlimefunItems.REINFORCED_PLATE,Solar_Generator7,SlimefunItems.REINFORCED_PLATE,Solar_Generator7})).register(this.plugin);
        (new SolarGenerator(CategoryAdvancedElectricity,8192,4096,Solar_Generator9,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Solar_Generator8,SlimefunItems.REINFORCED_PLATE,Solar_Generator8,SlimefunItems.REINFORCED_PLATE,Boosted_ElectroMagnet,SlimefunItems.REINFORCED_PLATE,Solar_Generator8,SlimefunItems.REINFORCED_PLATE,Solar_Generator8})).register(this.plugin);
        (new SolarGenerator(CategoryAdvancedElectricity,16384,8192,Solar_Generator10,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Solar_Generator9,SlimefunItems.REINFORCED_PLATE,Solar_Generator9,RedstoneAlloy_Plate,Block_of_Blistering_Ingot,RedstoneAlloy_Plate,Solar_Generator9,RedstoneAlloy_Plate,Solar_Generator9})).register(plugin);
        (new SolarGenerator(CategoryAdvancedElectricity,32768,16384,Solar_Generator11,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Solar_Generator10,RedstoneAlloy_Plate,Solar_Generator10,RedstoneAlloy_Plate,Block_of_Blistering_Ingot,RedstoneAlloy_Plate,Solar_Generator10,RedstoneAlloy_Plate,Solar_Generator10})).register(plugin);
        (new SolarGenerator(CategoryAdvancedElectricity,65536,32768,Solar_Generator12,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Solar_Generator11,RedstoneAlloy_Plate,Solar_Generator11,RedstoneAlloy_Plate,Block_of_Blistering_Ingot,RedstoneAlloy_Plate,Solar_Generator11,RedstoneAlloy_Plate,Solar_Generator11})).register(plugin);
        (new SolarGenerator(CategoryAdvancedElectricity,131072,65536,Solar_Generator13,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Solar_Generator12,RedstoneAlloy_Plate,Solar_Generator12,RedstoneAlloy_Plate,Block_of_Blistering_Ingot,RedstoneAlloy_Plate,Solar_Generator12,RedstoneAlloy_Plate,Solar_Generator12})).register(plugin);
        (new Capacitor(CategoryAdvancedElectricity,1000000, Capacitor6,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR})).register(this.plugin);
        (new Capacitor(CategoryAdvancedElectricity,2000000,Capacitor7,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Capacitor6,SlimefunItems.REINFORCED_PLATE,Capacitor6,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,Capacitor6,SlimefunItems.REINFORCED_PLATE,Capacitor6})).register(plugin);
        (new Capacitor(CategoryAdvancedElectricity,4000000,Capacitor8,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Capacitor7,SlimefunItems.REINFORCED_PLATE,Capacitor7,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,Capacitor7,SlimefunItems.REINFORCED_PLATE,Capacitor7})).register(plugin);
        (new Capacitor(CategoryAdvancedElectricity,8000000,Capacitor9,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Capacitor8,SlimefunItems.REINFORCED_PLATE,Capacitor8,SlimefunItems.REINFORCED_PLATE,Boosted_ElectroMagnet,SlimefunItems.REINFORCED_PLATE,Capacitor8,SlimefunItems.REINFORCED_PLATE,Capacitor8})).register(plugin);
        (new Capacitor(CategoryAdvancedElectricity,16000000, Capacitor10,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Capacitor9,RedstoneAlloy_Plate,Capacitor9,RedstoneAlloy_Plate,Boosted_ElectroMagnet,RedstoneAlloy_Plate,Capacitor9,RedstoneAlloy_Plate,Capacitor9})).register(plugin);
        (new Capacitor(CategoryAdvancedElectricity,32000000,Capacitor11,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Capacitor10,RedstoneAlloy_Plate,Capacitor10,RedstoneAlloy_Plate,Boosted_ElectroMagnet,RedstoneAlloy_Plate,Capacitor10,RedstoneAlloy_Plate,Capacitor10})).register(plugin);
        (new Capacitor(CategoryAdvancedElectricity,64000000,Capacitor12,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Capacitor11,RedstoneAlloy_Plate,Capacitor11,RedstoneAlloy_Plate,Boosted_ElectroMagnet,RedstoneAlloy_Plate,Capacitor11,RedstoneAlloy_Plate,Capacitor11})).register(plugin);
        (new Capacitor(CategoryAdvancedElectricity,128000000,Capacitor13,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Capacitor12,RedstoneAlloy_Plate,Capacitor12,RedstoneAlloy_Plate,Block_of_Blistering_Ingot,RedstoneAlloy_Plate,Capacitor12,RedstoneAlloy_Plate,Capacitor12})).register(plugin);
        (new Capacitor(CategoryAdvancedElectricity,256000000,Capacitor14,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Capacitor13,RedstoneAlloy_Plate,Capacitor13,RedstoneAlloy_Plate,Block_of_Blistering_Ingot,RedstoneAlloy_Plate,Capacitor13,RedstoneAlloy_Plate,Capacitor13})).register(plugin);
        (new PowerCube(128,PowerCube1,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.REINFORCED_PLATE,Boosted_ElectroMagnet,SlimefunItems.REINFORCED_PLATE,Boosted_ElectroMagnet,SlimefunItems.BIG_CAPACITOR,Boosted_ElectroMagnet,SlimefunItems.REINFORCED_PLATE,Boosted_ElectroMagnet,SlimefunItems.REINFORCED_PLATE})).register(this.plugin);
        (new CoalGenerator(CategoryAdvancedElectricity,CoalGenerator3,RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunItems.HEATING_COIL,Boosted_ElectroMagnet,SlimefunItems.HEATING_COIL,SlimefunItems.HEATING_COIL,SlimefunItems.COAL_GENERATOR_2,SlimefunItems.HEATING_COIL,SlimefunItems.STEEL_PLATE,SlimefunItems.STEEL_PLATE,SlimefunItems.STEEL_PLATE})).setCapacity(512).setEnergyProduction(32).register(plugin);
        (new CoalGenerator(CategoryAdvancedElectricity,CoalGenerator4,RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunItems.HEATING_COIL,Boosted_ElectroMagnet,SlimefunItems.HEATING_COIL,SlimefunItems.HEATING_COIL,CoalGenerator3,SlimefunItems.HEATING_COIL,SlimefunItems.STEEL_PLATE,new ItemStack(Material.BLAST_FURNACE),SlimefunItems.STEEL_PLATE})).setCapacity(1024).setEnergyProduction(64).register(plugin);
        (new CoalGenerator(CategoryAdvancedElectricity,CoalGenerator5,RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunItems.HEATING_COIL,SlimefunItems.COAL_GENERATOR,SlimefunItems.HEATING_COIL,SlimefunItems.HEATING_COIL,CoalGenerator4,SlimefunItems.HEATING_COIL,SlimefunItems.REDSTONE_ALLOY,new ItemStack(Material.LAVA_BUCKET),SlimefunItems.REINFORCED_ALLOY_INGOT})).setCapacity(2048).setEnergyProduction(128).register(plugin);
        (new ElectricGoldPan(CategoryAdvancedElectricity,ElectricGoldenPan4,RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunItems.REDSTONE_ALLOY, SlimefunItems.GOLD_PAN,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.GOLD_PAN,SlimefunItems.ELECTRIC_GOLD_PAN_3,SlimefunItems.GOLD_PAN,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.GOLD_PAN,SlimefunItems.REDSTONE_ALLOY})).setCapacity(128).setEnergyConsumption(12).setProcessingSpeed(15).register(plugin);
        (new ElectricGoldPan(CategoryAdvancedElectricity,ElectricGoldenPan5,RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunItems.REDSTONE_ALLOY, SlimefunItems.GOLD_PAN,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.GOLD_PAN,ElectricGoldenPan4,SlimefunItems.GOLD_PAN,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.GOLD_PAN,SlimefunItems.REDSTONE_ALLOY})).setCapacity(128).setEnergyConsumption(16).setProcessingSpeed(20).register(plugin);
        (new ElectricDustWasher(CategoryAdvancedElectricity,ElectricDustWasher4,RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{})).setCapacity(128).setEnergyConsumption(32).setProcessingSpeed(15).register(plugin);
        (new ElectricDustWasher(CategoryAdvancedElectricity,ElectricDustWasher5,RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{})).setCapacity(128).setEnergyConsumption(48).setProcessingSpeed(20).register(plugin);
        (new ElectricIngotFactory(CategoryAdvancedElectricity,ElectricIngotFactory4,RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{})).setCapacity(1024).setEnergyConsumption(24).setProcessingSpeed(12).register(plugin);
        (new ElectricIngotFactory(CategoryAdvancedElectricity,ElectricIngotFactory5,RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{})).setCapacity(1024).setEnergyConsumption(32).setProcessingSpeed(18).register(plugin);
        (new StoneGenerator()).register(this.plugin);

    }
    public void registerMiscellaneous() {
        this.registerItem(CategoryMiscellaneous,Steel_Cage,RecipeType.ENHANCED_CRAFTING_TABLE,SlimefunItems.STEEL_INGOT,SlimefunItems.STEEL_INGOT,SlimefunItems.STEEL_INGOT,new ItemStack(Material.IRON_BARS),new ItemStack(Material.IRON_BARS),new ItemStack(Material.IRON_BARS), SlimefunItems.STEEL_INGOT,SlimefunItems.STEEL_INGOT,SlimefunItems.STEEL_INGOT);
        this.registerItem(CategoryMiscellaneous,Iron_Cap,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack(Material.IRON_NUGGET),new ItemStack(Material.IRON_NUGGET),new ItemStack(Material.IRON_NUGGET),new ItemStack(Material.IRON_NUGGET),null,new ItemStack(Material.IRON_NUGGET));
        //this.registerItem(CategoryMiscellaneous,ConcentratedFireCharge,RecipeType.MAGIC_WORKBENCH,new ItemStack(Material.FIRE_CHARGE),new ItemStack(Material.FIRE_CHARGE),new ItemStack(Material.FIRE_CHARGE),new ItemStack(Material.FIRE_CHARGE),new ItemStack(Material.FIRE_CHARGE),new ItemStack(Material.FIRE_CHARGE),new ItemStack(Material.FIRE_CHARGE),new ItemStack(Material.FIRE_CHARGE),new ItemStack(Material.FIRE_CHARGE));
        //this.registerItem(CategoryMiscellaneous,ConcentratedFireChargeS,new RecipeType(new ItemStack(Material.STICK),"wand_interaction"),null,null,null,null,null,new CustomItemStack(Material.STICK,"Wand"),null,new CustomItemStack(Material.MAGMA_BLOCK,"Right Click"));
        (new RadioactiveItem(CategoryMiscellaneous,Radioactivity.VERY_DEADLY, Block_of_Blistering_Ingot, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.BLISTERING_INGOT_3})).register(this.plugin);
        (new EnchantedItem(CategoryMiscellaneous,Boosted_ElectroMagnet,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.IRON_DUST,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.IRON_DUST,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.ELECTRO_MAGNET,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.IRON_DUST,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.IRON_DUST,})).register(this.plugin);
        this.registerItem(CategoryMiscellaneous,Golden_Rod,RecipeType.ENHANCED_CRAFTING_TABLE,null,SlimefunItems.GOLD_18K,null,null,SlimefunItems.GOLD_18K,null,null,SlimefunItems.GOLD_18K,null);
        this.registerItem(CategoryMiscellaneous,RedstoneAlloy_Plate,RecipeType.COMPRESSOR,new SlimefunItemStack(SlimefunItems.REDSTONE_ALLOY,8));
    }
    private void registerTools() {
        this.registerItem(CategoryTools,Hammer,RecipeType.ENHANCED_CRAFTING_TABLE,null,new ItemStack(Material.IRON_INGOT),null,null,new ItemStack(Material.STICK),new ItemStack(Material.IRON_INGOT),new ItemStack(Material.STICK),null,null);
    }
    private void registerItem(ItemGroup group, SlimefunItemStack item, RecipeType type, ItemStack... items) {
        SlimefunItem sfitem = new SlimefunItem(group,item,type, items);
        sfitem.register(this.plugin);
    }
    private void registerItemNoRecipe(ItemGroup group,SlimefunItemStack item) {
        SlimefunItem sfitem = new SlimefunItem(group,item,new RecipeType(new CustomItemStack(Material.BARRIER,"Not yet implemented"),"notimplemented"),new ItemStack[]{});
        sfitem.register(this.plugin);
    }
    private void registerHelmet(ItemGroup group,SlimefunItemStack item,ItemStack x) {
        SlimefunItem sfitem = new SlimefunItem(group,item,RecipeType.ARMOR_FORGE,new ItemStack[]{x,x,x,x,null,x,null,null,null});
        sfitem.register(this.plugin);
    }
    private void registerChestplate(ItemGroup group,SlimefunItemStack item,ItemStack x) {
        SlimefunItem sfitem = new SlimefunItem(group,item,RecipeType.ARMOR_FORGE,new ItemStack[]{x,null,x,x,x,x,x,x,x});
        sfitem.register(this.plugin);
    }
    private void registerLeggings(ItemGroup group,SlimefunItemStack item,ItemStack x) {
        SlimefunItem sfitem = new SlimefunItem(group,item,RecipeType.ARMOR_FORGE,new ItemStack[]{x,x,x,x,null,x,x,null,x});
        sfitem.register(this.plugin);
    }
    private void registerBoots(ItemGroup group,SlimefunItemStack item,ItemStack x) {
        SlimefunItem sfitem = new SlimefunItem(group,item,RecipeType.ARMOR_FORGE,new ItemStack[]{x,null,x,x,null,x,null,null,null});
        sfitem.register(this.plugin);
    }
    private void registerSword(ItemGroup group,SlimefunItemStack item,ItemStack x) {
        SlimefunItem sfitem = new SlimefunItem(group,item,RecipeType.ARMOR_FORGE,new ItemStack[]{null,x,null,null,x,null,null,new ItemStack(Material.STICK),null});
        sfitem.register(this.plugin);
    }
    private void registerPickaxe(ItemGroup group,SlimefunItemStack item,ItemStack x) {
        SlimefunItem sfitem = new SlimefunItem(group,item,RecipeType.ARMOR_FORGE,new ItemStack[]{x,x,x,null,new ItemStack(Material.STICK),null,null,new ItemStack(Material.STICK),null});
        sfitem.register(this.plugin);
    }
    private void registerAxe(ItemGroup group,SlimefunItemStack item,ItemStack x) {
        SlimefunItem sfitem = new SlimefunItem(group,item,RecipeType.ARMOR_FORGE,new ItemStack[]{x,x,null,x,new ItemStack(Material.STICK),null,null,new ItemStack(Material.STICK),null});
        sfitem.register(this.plugin);
    }
    private void registerShovel(ItemGroup group,SlimefunItemStack item,ItemStack x) {
        SlimefunItem sfitem = new SlimefunItem(group,item,RecipeType.ARMOR_FORGE,new ItemStack[]{null,x,null,null,new ItemStack(Material.STICK),null,null,new ItemStack(Material.STICK),null});
        sfitem.register(this.plugin);
    }
}

