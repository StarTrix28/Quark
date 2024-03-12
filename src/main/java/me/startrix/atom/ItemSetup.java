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
            this.registerTechnicalGear();
            this.registerMultiBlock();
            this.registerMiscellaneous();
            this.registerMagicalItems();
            this.registerEnergyMagic();
            this.registerAdvancedElectricity();
            this.registerMagicalMachines();
        }
    }

    private void registerTechnicalGear() {
        (new EnergyRod(128,EnergyRod1,RecipeType.NULL,new ItemStack[]{})).register(this.plugin);
        (new EnergyRod(512,EnergyRod2,RecipeType.NULL,new ItemStack[]{})).register(this.plugin);
        (new EnergyRod(1024,EnergyRod3,RecipeType.NULL,new ItemStack[]{})).register(this.plugin);
        (new EnergyRod(8192,EnergyRod4,RecipeType.NULL,new ItemStack[]{})).register(this.plugin);
        (new EnergyRod(16384,EnergyRod5,RecipeType.NULL,new ItemStack[]{})).register(this.plugin);
        (new EnergyRod(32768,EnergyRod6,RecipeType.NULL,new ItemStack[]{})).register(this.plugin);
        (new EnergyRod(65536,EnergyRod7,RecipeType.NULL,new ItemStack[]{})).register(this.plugin);
        (new EnergyRod(131072,EnergyRod8,RecipeType.NULL,new ItemStack[]{})).register(this.plugin);
        (new EnergyRod(262144,EnergyRod9,RecipeType.NULL,new ItemStack[]{})).register(this.plugin);
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
    }
    private void registerAdvancedElectricity() {
        (new SolarGenerator(CategoryAdvancedElectricity,512,256,Solar_Generator5,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.SOLAR_GENERATOR_4,SlimefunItems.REINFORCED_PLATE,SlimefunItems.SOLAR_GENERATOR_4,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.SOLAR_GENERATOR_4,SlimefunItems.REINFORCED_PLATE,SlimefunItems.SOLAR_GENERATOR_4})).register(this.plugin);
        (new SolarGenerator(CategoryAdvancedElectricity,1024,512,Solar_Generator6,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Solar_Generator5,SlimefunItems.REINFORCED_PLATE,Solar_Generator5,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,Solar_Generator5,SlimefunItems.REINFORCED_PLATE,Solar_Generator5})).register(this.plugin);
        (new SolarGenerator(CategoryAdvancedElectricity,2048,1024,Solar_Generator7,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Solar_Generator6,SlimefunItems.REINFORCED_PLATE,Solar_Generator6,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,Solar_Generator6,SlimefunItems.REINFORCED_PLATE,Solar_Generator6})).register(this.plugin);
        (new SolarGenerator(CategoryAdvancedElectricity,4096,2048,Solar_Generator8,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Solar_Generator7,SlimefunItems.REINFORCED_PLATE,Solar_Generator7,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,Solar_Generator7,SlimefunItems.REINFORCED_PLATE,Solar_Generator7})).register(this.plugin);
        (new SolarGenerator(CategoryAdvancedElectricity,8192,4096,Solar_Generator9,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Solar_Generator8,SlimefunItems.REINFORCED_PLATE,Solar_Generator8,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,Solar_Generator8,SlimefunItems.REINFORCED_PLATE,Solar_Generator8})).register(this.plugin);
        (new SolarGenerator(CategoryAdvancedElectricity,16384,8192,Solar_Generator10,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Solar_Generator9,SlimefunItems.REINFORCED_PLATE,Solar_Generator9,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,Solar_Generator9,SlimefunItems.REINFORCED_PLATE,Solar_Generator9})).register(this.plugin);
        (new SolarGenerator(CategoryAdvancedElectricity,32768,16384,Solar_Generator11,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Solar_Generator10,SlimefunItems.REINFORCED_PLATE,Solar_Generator10,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,Solar_Generator10,SlimefunItems.REINFORCED_PLATE,Solar_Generator10})).register(this.plugin);
        (new SolarGenerator(CategoryAdvancedElectricity,65536,32768,Solar_Generator12,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Solar_Generator11,SlimefunItems.REINFORCED_PLATE,Solar_Generator11,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,Solar_Generator11,SlimefunItems.REINFORCED_PLATE,Solar_Generator11})).register(this.plugin);
        (new SolarGenerator(CategoryAdvancedElectricity,131072,65536,Solar_Generator13,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{Solar_Generator12,SlimefunItems.REINFORCED_PLATE,Solar_Generator12,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,Solar_Generator12,SlimefunItems.REINFORCED_PLATE,Solar_Generator12})).register(this.plugin);
        (new Capacitor(CategoryAdvancedElectricity,1000000, Capacitor6,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR})).register(this.plugin);
        (new Capacitor(CategoryAdvancedElectricity,2000000,Capacitor7,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR})).register(this.plugin);
        (new Capacitor(CategoryAdvancedElectricity,4000000,Capacitor8,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR})).register(this.plugin);
        (new Capacitor(CategoryAdvancedElectricity,8000000,Capacitor9,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR})).register(this.plugin);
        (new Capacitor(CategoryAdvancedElectricity,16000000, Capacitor10,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR})).register(this.plugin);
        (new Capacitor(CategoryAdvancedElectricity,32000000,Capacitor11,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR})).register(this.plugin);
        (new Capacitor(CategoryAdvancedElectricity,64000000,Capacitor12,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR})).register(this.plugin);
        (new Capacitor(CategoryAdvancedElectricity,128000000,Capacitor13,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR})).register(this.plugin);
        (new Capacitor(CategoryAdvancedElectricity,256000000,Capacitor14,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR,SlimefunItems.REINFORCED_PLATE,SlimefunItems.ENERGIZED_CAPACITOR})).register(this.plugin);
        (new PowerCube(128,PowerCube1,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.REINFORCED_PLATE,Boosted_ElectroMagnet,SlimefunItems.REINFORCED_PLATE,Boosted_ElectroMagnet,SlimefunItems.BIG_CAPACITOR,Boosted_ElectroMagnet,SlimefunItems.REINFORCED_PLATE,Boosted_ElectroMagnet,SlimefunItems.REINFORCED_PLATE})).register(this.plugin);
        (new StoneGenerator()).register(this.plugin);
    }
    public void registerMagicalMachines() {
        (new EssenceGrinder()).register(this.plugin);
    }
    public void registerMagicalItems() {
        this.registerItem(CategoryMagicalResources,Magic_Rune,RecipeType.ANCIENT_ALTAR, SlimefunItems.MAGIC_LUMP_3,SlimefunItems.MAGIC_LUMP_3,SlimefunItems.MAGIC_LUMP_3,SlimefunItems.MAGIC_LUMP_3,SlimefunItems.BLANK_RUNE,SlimefunItems.MAGIC_LUMP_3,SlimefunItems.MAGIC_LUMP_3,SlimefunItems.MAGIC_LUMP_3,SlimefunItems.MAGIC_LUMP_3);
        (new MagicStone()).register(this.plugin);
        (new MagicWand(CategoryMagic,16,MagicWandIron,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{null,null,Iron_Cap,null,new ItemStack(Material.STICK),null,Iron_Cap,null,null})).register(this.plugin);
        (new MagicalCrucible()).register(this.plugin);
        (new MagicalEssence()).register(this.plugin);
        this.registerItemWandRecipe(CategoryMagicalResources,MagicalGlowstoneDust,new ItemStack(Material.GLOWSTONE_DUST));
        this.registerItemWandRecipe(CategoryMagicalResources,MagicalGlowstone,new ItemStack(Material.GLOWSTONE));
        (new MagicWater()).register(this.plugin);
    }
    public void registerMiscellaneous() {
        this.registerItem(CategoryMiscellaneous,Steel_Cage,RecipeType.ENHANCED_CRAFTING_TABLE,SlimefunItems.STEEL_INGOT,SlimefunItems.STEEL_INGOT,SlimefunItems.STEEL_INGOT,new ItemStack(Material.IRON_BARS),new ItemStack(Material.IRON_BARS),new ItemStack(Material.IRON_BARS), SlimefunItems.STEEL_INGOT,SlimefunItems.STEEL_INGOT,SlimefunItems.STEEL_INGOT);
        this.registerItem(CategoryMiscellaneous,Iron_Cap,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack(Material.IRON_NUGGET),new ItemStack(Material.IRON_NUGGET),new ItemStack(Material.IRON_NUGGET),new ItemStack(Material.IRON_NUGGET),null,new ItemStack(Material.IRON_NUGGET));
        this.registerItem(CategoryMiscellaneous,ConcentratedFireCharge,RecipeType.MAGIC_WORKBENCH,new ItemStack(Material.FIRE_CHARGE),new ItemStack(Material.FIRE_CHARGE),new ItemStack(Material.FIRE_CHARGE),new ItemStack(Material.FIRE_CHARGE),new ItemStack(Material.FIRE_CHARGE),new ItemStack(Material.FIRE_CHARGE),new ItemStack(Material.FIRE_CHARGE),new ItemStack(Material.FIRE_CHARGE),new ItemStack(Material.FIRE_CHARGE));
        this.registerItem(CategoryMiscellaneous,ConcentratedFireChargeS,new RecipeType(new ItemStack(Material.STICK),"wand_interaction"),null,null,null,null,null,new CustomItemStack(Material.STICK,"Wand"),null,new CustomItemStack(Material.MAGMA_BLOCK,"Right Click"));
        (new RadioactiveItem(CategoryMiscellaneous,Radioactivity.VERY_DEADLY, Block_of_Blistering_Ingot, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.BLISTERING_INGOT_3})).register(this.plugin);
        (new EnchantedItem(CategoryMiscellaneous,Boosted_ElectroMagnet,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[]{SlimefunItems.IRON_DUST,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.IRON_DUST,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.ELECTRO_MAGNET,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.IRON_DUST,SlimefunItems.REDSTONE_ALLOY,SlimefunItems.IRON_DUST,})).register(this.plugin);
    }
    private void registerEnergyMagic() {
        (new MagicalCapacitor(CategoryEnergyMagic,64,Basic_Magic_Capacitor,RecipeType.MAGIC_WORKBENCH,new ItemStack[]{null,null,null,null,Steel_Cage,null,null,null,null})).register(this.plugin);
        (new MagicalCapacitor(CategoryEnergyMagic,128,Advanced_Magic_Capacitor, RecipeType.MAGIC_WORKBENCH,new ItemStack[]{null,null,null,null,Basic_Magic_Capacitor,null,null,null,null})).register(this.plugin);
        (new MagicalEnergyRegulator()).register(this.plugin);
        (new MagicalEnergyConnector()).register(this.plugin);
        (new MagicEnergyGenerator()).register(this.plugin);
    }
    private void registerTools() {

    }
    private void registerItem(ItemGroup group, SlimefunItemStack item, RecipeType type, ItemStack... items) {
        SlimefunItem sfitem = new SlimefunItem(group,item,type, items);
        sfitem.register(this.plugin);
    }
    private void registerItemNoRecipe(ItemGroup group,SlimefunItemStack item) {
        SlimefunItem sfitem = new SlimefunItem(group,item,RecipeType.NULL,new ItemStack[]{});
        sfitem.register(this.plugin);
    }
    private void registerItemWandRecipe(ItemGroup group,SlimefunItemStack item,ItemStack recipe) {
        SlimefunItem sfitem = new SlimefunItem(group,item,new RecipeType(new CustomItemStack(Material.STICK,"Magic Wand Interaction"),"magicwand"),new ItemStack[]{null,null,new CustomItemStack(Material.STICK,"Magic Wand"),null,recipe,null,null,null,null});
        sfitem.register(this.plugin);
    }

}
