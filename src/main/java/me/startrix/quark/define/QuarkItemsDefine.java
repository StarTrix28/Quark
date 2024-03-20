package me.startrix.quark.define;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerSkin;
import io.github.thebusybiscuit.slimefun4.utils.HeadTexture;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.enchantments.Enchantment.*;

public final class QuarkItemsDefine {
    public static final NestedItemGroup Quark = new NestedItemGroup(new NamespacedKey(me.startrix.quark.Quark.getInstance(),"quark"),new CustomItemStack(Material.DIAMOND,"&4Quark"));
    public static final SubItemGroup CategoryGear = new SubItemGroup(new NamespacedKey(me.startrix.quark.Quark.getInstance(), "quark-gear"), Quark, new CustomItemStack(new ItemStack(Material.LEATHER_CHESTPLATE),Color.fromRGB(64,23,0),"Gear"));
    public static final SubItemGroup CategoryTools = new SubItemGroup(new NamespacedKey(me.startrix.quark.Quark.getInstance(),"quark-tools"),Quark,new CustomItemStack(Material.IRON_PICKAXE,"Tools"));
    public static final SubItemGroup CategoryMultiblock = new SubItemGroup(new NamespacedKey(me.startrix.quark.Quark.getInstance(),"quark-multiblock"),Quark,new CustomItemStack(Material.CRAFTING_TABLE,"MultiBlocks"));
    public static final SubItemGroup CategoryAdvancedElectricity = new SubItemGroup(new NamespacedKey(me.startrix.quark.Quark.getInstance(), "quark-advanced_energy_and_electricity"), Quark, new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWFjNTI0MTliOTkwMjU4MjhjODlmYTgyNTk0NWU2OTQ4ZTQ1YmI1YTIyZTQ0MjVhNTllOTA5NmU0YzFhYzM4In19fQ==")),"Advanced Energy and Electricity [WIP]"));
    public static final SubItemGroup CategoryTechnicalGear = new SubItemGroup(new NamespacedKey(me.startrix.quark.Quark.getInstance(),"quark-technicalgear"),Quark,new CustomItemStack(Material.BLAZE_ROD,"Technical Gear [WIP]"));
    public static final SubItemGroup CategoryMiscellaneous = new SubItemGroup(new NamespacedKey(me.startrix.quark.Quark.getInstance(),"quark-miscellaneous"),Quark,new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDhlNjUyNTM4NWY3NDgzMjJlZWNjNDE2ODliNjkwYWExZWJiYjIxNzJlYzJjNGEyZWFjMTRmMjJkOTRlZTNiYSJ9fX0=")),"Miscellaneous"));

    //Basic
    public static final SlimefunItemStack Wooden_Helmet;
    public static final SlimefunItemStack Wooden_Chestplate;
    public static final SlimefunItemStack Wooden_Leggings;
    public static final SlimefunItemStack Wooden_Boots;
    public static final SlimefunItemStack Flint_Sword;
    public static final SlimefunItemStack Flint_Pickaxe;
    public static final SlimefunItemStack Flint_Axe;
    public static final SlimefunItemStack Flint_Shovel;
    public static final SlimefunItemStack Obsidian_Helmet;
    public static final SlimefunItemStack Obsidian_Chestplate;
    public static final SlimefunItemStack Obsidian_Leggings;
    public static final SlimefunItemStack Obsidian_Boots;
    public static final SlimefunItemStack Obsidian_Sword;
    public static final SlimefunItemStack Obsidian_Pickaxe;
    public static final SlimefunItemStack Obsidian_Axe;
    public static final SlimefunItemStack Obsidian_Shovel;
    public static final SlimefunItemStack Reinforced_Helmet;
    public static final SlimefunItemStack Reinforced_Chestplate;
    public static final SlimefunItemStack Reinforced_Leggings;
    public static final SlimefunItemStack Reinforced_Boots;
    public static final SlimefunItemStack Reinforced_Sword;
    public static final SlimefunItemStack Reinforced_Pickaxe;
    public static final SlimefunItemStack Reinforced_Axe;
    public static final SlimefunItemStack Reinforced_Shovel;
    //Tools
    public static final SlimefunItemStack Hammer;
    //Multiblock
    public static final SlimefunItemStack KiloMiner;
    public static final SlimefunItemStack MegaMiner;
    //Machines
    public static final SlimefunItemStack Solar_Generator5;
    public static final SlimefunItemStack Solar_Generator6;
    public static final SlimefunItemStack Solar_Generator7;
    public static final SlimefunItemStack Solar_Generator8;
    public static final SlimefunItemStack Solar_Generator9;
    public static final SlimefunItemStack Solar_Generator10;
    public static final SlimefunItemStack Solar_Generator11;
    public static final SlimefunItemStack Solar_Generator12;
    public static final SlimefunItemStack Solar_Generator13;
    public static final SlimefunItemStack Capacitor6;
    public static final SlimefunItemStack Capacitor7;
    public static final SlimefunItemStack Capacitor8;
    public static final SlimefunItemStack Capacitor9;
    public static final SlimefunItemStack Capacitor10;
    public static final SlimefunItemStack Capacitor11;
    public static final SlimefunItemStack Capacitor12;
    public static final SlimefunItemStack Capacitor13;
    public static final SlimefunItemStack Capacitor14;
    public static final SlimefunItemStack CoalGenerator3;
    public static final SlimefunItemStack CoalGenerator4;
    public static final SlimefunItemStack CoalGenerator5;
    public static final SlimefunItemStack ElectricGoldenPan4;
    public static final SlimefunItemStack ElectricGoldenPan5;
    public static final SlimefunItemStack ElectricGoldenPan6;
    public static final SlimefunItemStack ElectricDustWasher4;
    public static final SlimefunItemStack ElectricDustWasher5;
    public static final SlimefunItemStack ElectricDustWasher6;
    public static final SlimefunItemStack ElectricIngotFactory4;
    public static final SlimefunItemStack ElectricIngotFactory5;
    public static final SlimefunItemStack ElectricIngotFactory6;
    public static final SlimefunItemStack PowerCube1;
    public static final SlimefunItemStack PowerCube2;
    public static final SlimefunItemStack PowerCube3;
    public static final SlimefunItemStack PowerCube4;
    public static final SlimefunItemStack Cobble_Generator;
    //TechnicalGear
    public static final SlimefunItemStack EnergyRod1;
    public static final SlimefunItemStack EnergyRod2;
    public static final SlimefunItemStack EnergyRod3;
    public static final SlimefunItemStack EnergyRod4;
    public static final SlimefunItemStack EnergyRod5;
    public static final SlimefunItemStack EnergyRod6;
    public static final SlimefunItemStack EnergyRod7;
    public static final SlimefunItemStack EnergyRod8;
    public static final SlimefunItemStack EnergyRod9;

    //Miscellaneous
    public static final SlimefunItemStack Steel_Cage;
    public static final SlimefunItemStack Iron_Cap;
    public static final SlimefunItemStack ConcentratedFireCharge;
    public static final SlimefunItemStack ConcentratedFireChargeS;
    public static final SlimefunItemStack Block_of_Blistering_Ingot;
    public static final SlimefunItemStack Boosted_ElectroMagnet;
    public static final SlimefunItemStack Golden_Rod;
    public static final SlimefunItemStack RedstoneAlloy_Plate;
    //Resources

    //Magic



    public QuarkItemsDefine() {
    }
    static {
        //Basic
        Wooden_Helmet = new SlimefunItemStack("WOODEN_HELMET",Material.LEATHER_HELMET, Color.fromRGB(64,23,0),"Wooden Helmet");
        Wooden_Chestplate = new SlimefunItemStack("WOODEN_CHESTPLATE",Material.LEATHER_CHESTPLATE, Color.fromRGB(64,23,0),"Wooden Chestplate");
        Wooden_Leggings = new SlimefunItemStack("WOODEN_LEGGINGS",Material.LEATHER_LEGGINGS, Color.fromRGB(64,23,0),"Wooden Leggings");
        Wooden_Boots = new SlimefunItemStack("WOODEN_BOOTS",Material.LEATHER_BOOTS, Color.fromRGB(64,23,0),"Wooden Boots");
        Flint_Sword = new SlimefunItemStack("FLINT_SWORD",Material.STONE_SWORD,"Flint Sword");
        Flint_Pickaxe = new SlimefunItemStack("FLINT_PICKAXE",Material.STONE_PICKAXE,"Flint Pickaxe");
        Flint_Axe = new SlimefunItemStack("FLINT_AXE",Material.STONE_AXE,"Flint Axe");
        Flint_Shovel = new SlimefunItemStack("FLINT_SHOVEL",Material.STONE_SHOVEL,"Flint Shovel");
        Obsidian_Helmet = new SlimefunItemStack("OBSIDIAN_HELMET",Material.LEATHER_HELMET, Color.fromRGB(0,0,0),"Obsidian Helmet","Brittle");
        Obsidian_Chestplate = new SlimefunItemStack("OBSIDIAN_CHESTPLATE",Material.LEATHER_CHESTPLATE, Color.fromRGB(64,23,0),"Obsidian Chestplate","Brittle");
        Obsidian_Leggings = new SlimefunItemStack("OBSIDIAN_LEGGINGS",Material.LEATHER_LEGGINGS, Color.fromRGB(0,0,0),"Obsidian Leggings","Brittle");
        Obsidian_Boots = new SlimefunItemStack("OBSIDIAN_BOOTS",Material.LEATHER_BOOTS, Color.fromRGB(0,0,0),"Obsidian Boots","Brittle");
        Obsidian_Sword = new SlimefunItemStack("OBSIDIAN_SWORD",Material.STONE_SWORD,"Obsidian Sword");
        Obsidian_Pickaxe = new SlimefunItemStack("OBSIDIAN_PICKAXE",Material.DIAMOND_PICKAXE,"Obsidian Pickaxe");
        Obsidian_Axe = new SlimefunItemStack("OBSIDIAN_AXE",Material.STONE_AXE,"Obsidian Axe");
        Obsidian_Shovel = new SlimefunItemStack("OBSIDIAN_SHOVEL",Material.STONE_SHOVEL,"Obsidian Shovel");
        Reinforced_Helmet = new SlimefunItemStack("REINFORCED_HELMET",Material.IRON_HELMET,"Reinforced Helmet");
        Reinforced_Chestplate = new SlimefunItemStack("REINFORCED_CHESTPLATE",Material.IRON_CHESTPLATE,"Reinforced Chestplate");
        Reinforced_Leggings = new SlimefunItemStack("REINFORCED_LEGGINGS",Material.IRON_LEGGINGS,"Reinforced Leggings");
        Reinforced_Boots = new SlimefunItemStack("REINFORCED_BOOTS",Material.IRON_BOOTS,"Reinforced Boots");
        Reinforced_Sword = new SlimefunItemStack("REINFORCED_SWORD",Material.IRON_SWORD,"Flint Sword");
        Reinforced_Pickaxe = new SlimefunItemStack("REINFORCED_PICKAXE",Material.IRON_PICKAXE,"Flint Pickaxe");
        Reinforced_Axe = new SlimefunItemStack("REINFORCED_AXE",Material.IRON_AXE,"Flint Axe");
        Reinforced_Shovel = new SlimefunItemStack("REINFORCED_SHOVEL",Material.IRON_SHOVEL,"Flint Shovel");
        //Tools
        Hammer = new SlimefunItemStack("HAMMER",Material.IRON_AXE,"Hammer");
        //Multiblock
        KiloMiner = new SlimefunItemStack("KILO_MINER",Material.NETHERITE_PICKAXE,"Kilo Miner", "", "&fThis Multiblock will mine any Ores", "&fin a 15x15 area underneath it.", "&fPlace coal in", "&fits chest to fuel this machine.", "", "&a+ Silk Touch");
        MegaMiner = new SlimefunItemStack("MEGA_MINER",Material.NETHERITE_PICKAXE,"Mega Miner", "", "&fThis Multiblock will mine any Ores", "&fin a 20x20 area underneath it.", "&fPlace coal in", "&fits chest to fuel this machine.", "", "&a+ Silk Touch");
        //Advanced Energy and Electricity
        Solar_Generator5 = new SlimefunItemStack("SOLAR_GENERATOR5", Material.DAYLIGHT_DETECTOR, "&bHighlyEnergized Solar Generator", "", LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR), LoreBuilder.powerBuffer(0),LoreBuilder.powerPerSecond(512) + " (Day)", LoreBuilder.powerPerSecond(256) + " (Night)");
        Solar_Generator6 = new SlimefunItemStack("SOLAR_GENERATOR6", Material.DAYLIGHT_DETECTOR, "&bHyperEnergized Solar Generator", "", LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR), LoreBuilder.powerBuffer(0),LoreBuilder.powerPerSecond(1024) + " (Day)", LoreBuilder.powerPerSecond(512) + " (Night)");
        Solar_Generator7 = new SlimefunItemStack("SOLAR_GENERATOR7", Material.DAYLIGHT_DETECTOR, "&bUltraEnergized Solar Generator", "", LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR), LoreBuilder.powerBuffer(0),LoreBuilder.powerPerSecond(2048) + " (Day)", LoreBuilder.powerPerSecond(1024) + " (Night)");
        Solar_Generator8 = new SlimefunItemStack("SOLAR_GENERATOR8", Material.DAYLIGHT_DETECTOR, "&bMegaEnergized Solar Generator", "", LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR), LoreBuilder.powerBuffer(0),LoreBuilder.powerPerSecond(4096) + " (Day)", LoreBuilder.powerPerSecond(2048) + " (Night)");
        Solar_Generator9 = new SlimefunItemStack("SOLAR_GENERATOR9", Material.DAYLIGHT_DETECTOR, "&bGigaEnergized Solar Generator", "", LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR), LoreBuilder.powerBuffer(0),LoreBuilder.powerPerSecond(8192) + " (Day)", LoreBuilder.powerPerSecond(4096) + " (Night)");
        Solar_Generator10 = new SlimefunItemStack("SOLAR_GENERATOR10", Material.DAYLIGHT_DETECTOR, "&bTeraEnergized Solar Generator", "", LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR), LoreBuilder.powerBuffer(0),LoreBuilder.powerPerSecond(16384) + " (Day)", LoreBuilder.powerPerSecond(8192) + " (Night)");
        Solar_Generator11 = new SlimefunItemStack("SOLAR_GENERATOR11", Material.DAYLIGHT_DETECTOR, "&bPetaEnergized Solar Generator", "", LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR), LoreBuilder.powerBuffer(0),LoreBuilder.powerPerSecond(32768) + " (Day)", LoreBuilder.powerPerSecond(16384) + " (Night)");
        Solar_Generator12 = new SlimefunItemStack("SOLAR_GENERATOR12", Material.DAYLIGHT_DETECTOR, "&bExaEnergized Solar Generator", "", LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR), LoreBuilder.powerBuffer(0),LoreBuilder.powerPerSecond(65536) + " (Day)", LoreBuilder.powerPerSecond(32768) + " (Night)");
        Solar_Generator13 = new SlimefunItemStack("SOLAR_GENERATOR13", Material.DAYLIGHT_DETECTOR, "&bZettaEnergized Solar Generator", "", LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR), LoreBuilder.powerBuffer(0),LoreBuilder.powerPerSecond(131072) + " (Day)", LoreBuilder.powerPerSecond(65536) + " (Night)");
        Capacitor6 = new SlimefunItemStack("CAPACITOR6", HeadTexture.CAPACITOR_25, "&aHighlyEnergized Energy Capacitor", LoreBuilder.range(6), "", LoreBuilder.machine(MachineTier.END_GAME, MachineType.CAPACITOR), "&8⇨ &e⚡ &71000000 J Capacity");
        Capacitor7 = new SlimefunItemStack("CAPACITOR7", HeadTexture.CAPACITOR_25, "&aHyperEnergized Energy Capacitor", LoreBuilder.range(6), "", LoreBuilder.machine(MachineTier.END_GAME, MachineType.CAPACITOR), "&8⇨ &e⚡ &72000000 J Capacity");
        Capacitor8 = new SlimefunItemStack("CAPACITOR8", HeadTexture.CAPACITOR_25, "&aUltraEnergized Energy Capacitor", LoreBuilder.range(6), "", LoreBuilder.machine(MachineTier.END_GAME, MachineType.CAPACITOR), "&8⇨ &e⚡ &74000000 J Capacity");
        Capacitor9 = new SlimefunItemStack("CAPACITOR9", HeadTexture.CAPACITOR_25, "&aMegaEnergized Energy Capacitor", LoreBuilder.range(6), "", LoreBuilder.machine(MachineTier.END_GAME, MachineType.CAPACITOR), "&8⇨ &e⚡ &78000000 J Capacity");
        Capacitor10 = new SlimefunItemStack("CAPACITOR10", HeadTexture.CAPACITOR_25, "&aGigaEnergized Energy Capacitor", LoreBuilder.range(6), "", LoreBuilder.machine(MachineTier.END_GAME, MachineType.CAPACITOR), "&8⇨ &e⚡ &716000000 J Capacity");
        Capacitor11 = new SlimefunItemStack("CAPACITOR11", HeadTexture.CAPACITOR_25, "&aTeraEnergized Energy Capacitor", LoreBuilder.range(6), "", LoreBuilder.machine(MachineTier.END_GAME, MachineType.CAPACITOR), "&8⇨ &e⚡ &732000000 J Capacity");
        Capacitor12 = new SlimefunItemStack("CAPACITOR12", HeadTexture.CAPACITOR_25, "&aPetaEnergized Energy Capacitor", LoreBuilder.range(6), "", LoreBuilder.machine(MachineTier.END_GAME, MachineType.CAPACITOR), "&8⇨ &e⚡ &764000000 J Capacity");
        Capacitor13 = new SlimefunItemStack("CAPACITOR13", HeadTexture.CAPACITOR_25, "&aExaEnergized Energy Capacitor", LoreBuilder.range(6), "", LoreBuilder.machine(MachineTier.END_GAME, MachineType.CAPACITOR), "&8⇨ &e⚡ &7128000000 J Capacity");
        Capacitor14 = new SlimefunItemStack("CAPACITOR14", HeadTexture.CAPACITOR_25, "&aZettaEnergized Energy Capacitor", LoreBuilder.range(6), "", LoreBuilder.machine(MachineTier.END_GAME, MachineType.CAPACITOR), "&8⇨ &e⚡ &7256000000 J Capacity");
        PowerCube1 = new SlimefunItemStack("POWERCUBE1",PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTE2YjY4Mzc2YzE4MWM5YTczNDNmZWUzNjk3ZmFhY2VjMzUxMjlmYjY0ZGU1OTE0YmRiZjg2OWM2NTJjIn19fQ==")),"[WIP] Power Cube I",LoreBuilder.powerCharged(0,128));
        PowerCube2 = new SlimefunItemStack("POWERCUBE2",PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTE2YjY4Mzc2YzE4MWM5YTczNDNmZWUzNjk3ZmFhY2VjMzUxMjlmYjY0ZGU1OTE0YmRiZjg2OWM2NTJjIn19fQ==")),"[WIP] Power Cube II",LoreBuilder.powerCharged(0,512));
        PowerCube3 = new SlimefunItemStack("POWERCUBE3",PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTE2YjY4Mzc2YzE4MWM5YTczNDNmZWUzNjk3ZmFhY2VjMzUxMjlmYjY0ZGU1OTE0YmRiZjg2OWM2NTJjIn19fQ==")),"[WIP] Power Cube III",LoreBuilder.powerCharged(0,2048));
        PowerCube4 = new SlimefunItemStack("POWERCUBE4",PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTE2YjY4Mzc2YzE4MWM5YTczNDNmZWUzNjk3ZmFhY2VjMzUxMjlmYjY0ZGU1OTE0YmRiZjg2OWM2NTJjIn19fQ==")),"[WIP] Power Cube IV",LoreBuilder.powerCharged(0,8192));
        CoalGenerator3 = new SlimefunItemStack("COAL_GENERATOR3", HeadTexture.GENERATOR, "&cCoal Generator III", "", LoreBuilder.machine(MachineTier.ADVANCED, MachineType.GENERATOR), LoreBuilder.powerBuffer(512), LoreBuilder.powerPerSecond(32));
        CoalGenerator4 = new SlimefunItemStack("COAL_GENERATOR4", HeadTexture.GENERATOR, "&cCoal Generator IV", "", LoreBuilder.machine(MachineTier.GOOD, MachineType.GENERATOR), LoreBuilder.powerBuffer(1024), LoreBuilder.powerPerSecond(64));
        CoalGenerator5 = new SlimefunItemStack("COAL_GENERATOR5", HeadTexture.GENERATOR, "&cCoal Generator V", "", LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR), LoreBuilder.powerBuffer(2048), LoreBuilder.powerPerSecond(128));
        ElectricGoldenPan4 = new SlimefunItemStack("ELECTRIC_GOLD_PAN4", Material.BROWN_TERRACOTTA, "&6Electric Gold Pan IV", "", LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE), LoreBuilder.speed(15), LoreBuilder.powerPerSecond(12));
        ElectricGoldenPan5 = new SlimefunItemStack("ELECTRIC_GOLD_PAN5", Material.BROWN_TERRACOTTA, "&6Electric Gold Pan V", "", LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE), LoreBuilder.speed(20), LoreBuilder.powerPerSecond(16));
        ElectricGoldenPan6 = new SlimefunItemStack("ELECTRIC_GOLD_PAN6", Material.BROWN_TERRACOTTA, "&6Electric Gold Pan VI", "", LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE), LoreBuilder.speed(50), LoreBuilder.powerPerSecond(32));
        ElectricDustWasher4 = new SlimefunItemStack("ELECTRIC_DUST_WASHER4", Material.BLUE_STAINED_GLASS, "&3Electric Dust Washer IV", "", LoreBuilder.machine(MachineTier.BASIC, MachineType.MACHINE), LoreBuilder.speed(15), LoreBuilder.powerPerSecond(32));
        ElectricDustWasher5 = new SlimefunItemStack("ELECTRIC_DUST_WASHER5", Material.BLUE_STAINED_GLASS, "&3Electric Dust Washer V", "", LoreBuilder.machine(MachineTier.BASIC, MachineType.MACHINE), LoreBuilder.speed(20), LoreBuilder.powerPerSecond(48));
        ElectricDustWasher6 = new SlimefunItemStack("ELECTRIC_DUST_WASHER6", Material.BLUE_STAINED_GLASS, "&3Electric Dust Washer VI", "", LoreBuilder.machine(MachineTier.BASIC, MachineType.MACHINE), LoreBuilder.speed(50), LoreBuilder.powerPerSecond(64));
        ElectricIngotFactory4 = new SlimefunItemStack("ELECTRIC_INGOT_FACTORY4", Material.RED_TERRACOTTA, "&cElectric Ingot Factory IV", "", LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE), LoreBuilder.speed(10), LoreBuilder.powerPerSecond(24));
        ElectricIngotFactory5 = new SlimefunItemStack("ELECTRIC_INGOT_FACTORY5", Material.RED_TERRACOTTA, "&cElectric Ingot Factory V", "", LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE), LoreBuilder.speed(15), LoreBuilder.powerPerSecond(32));
        ElectricIngotFactory6 = new SlimefunItemStack("ELECTRIC_INGOT_FACTORY6", Material.RED_TERRACOTTA, "&cElectric Ingot Factory VI", "", LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE), LoreBuilder.speed(20), LoreBuilder.powerPerSecond(48));
        Cobble_Generator = new SlimefunItemStack("COBBLE_GENERATOR",PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjVjOTc2MjcyOWQ0OGQwYTE2ZmU4OTU3M2JkZDJmYWY1MDE5NmZlYTE1ZDQ5YjVhNmJmZWE0ODliZTcxIn19fQ==")),"Cobble Generator");

        //TechnicalGear
        EnergyRod1 = new SlimefunItemStack("ENERGYROD1",Material.GOLDEN_SWORD,"Energy Rod I",LoreBuilder.powerCharged(0,128));
        EnergyRod2 = new SlimefunItemStack("ENERGYROD2",Material.GOLDEN_SWORD,"Energy Rod II",LoreBuilder.powerCharged(0,512));
        EnergyRod3 = new SlimefunItemStack("ENERGYROD3",Material.GOLDEN_SWORD,"Energy Rod III",LoreBuilder.powerCharged(0,1024));
        EnergyRod4 = new SlimefunItemStack("ENERGYROD4",Material.GOLDEN_SWORD,"Energy Rod IV",LoreBuilder.powerCharged(0,8192));
        EnergyRod5 = new SlimefunItemStack("ENERGYROD5",Material.GOLDEN_SWORD,"Energy Rod V",LoreBuilder.powerCharged(0,16384));
        EnergyRod6 = new SlimefunItemStack("ENERGYROD6",Material.GOLDEN_SWORD,"Energy Rod VI",LoreBuilder.powerCharged(0,32768));
        EnergyRod7 = new SlimefunItemStack("ENERGYROD7",Material.GOLDEN_SWORD,"Energy Rod VII",LoreBuilder.powerCharged(0,65536));
        EnergyRod8 = new SlimefunItemStack("ENERGYROD8",Material.GOLDEN_SWORD,"Energy Rod VIII",LoreBuilder.powerCharged(0,131072));
        EnergyRod9 = new SlimefunItemStack("ENERGYROD9",Material.GOLDEN_SWORD,"Energy Rod IX",LoreBuilder.powerCharged(0,262144));

        //Miscellaneous
        ConcentratedFireCharge = new SlimefunItemStack("STACKED_FIRECHARGE_UNSTABLE",Material.MAGMA_BLOCK,"&7Concentrated Fire Charge","&4&lUnstable");
        ConcentratedFireChargeS = new SlimefunItemStack("STACKED_FIRECHARGE",Material.MAGMA_BLOCK,"&7Concentrated Fire Charge","&a&lStable&4");
        Steel_Cage = new SlimefunItemStack("STEEL_CAGE",PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDhlNjUyNTM4NWY3NDgzMjJlZWNjNDE2ODliNjkwYWExZWJiYjIxNzJlYzJjNGEyZWFjMTRmMjJkOTRlZTNiYSJ9fX0=")),"Steel Cage");
        Iron_Cap = new SlimefunItemStack("IRON_CAP",Material.IRON_INGOT,"Iron Cap");
        Block_of_Blistering_Ingot = new SlimefunItemStack("BLOCKOF_BLISTERING_INGOT",Material.GOLD_BLOCK,"Block of Blistering Ingot","&e&lAlmost Unstable",LoreBuilder.radioactive(Radioactivity.VERY_DEADLY));
        Boosted_ElectroMagnet = new SlimefunItemStack("BOOSTED_ELECTROMAGNET",HeadTexture.MAGNET,"Boosted ElectroMagnet");
        Golden_Rod = new SlimefunItemStack("GOLDENROD",Material.BLAZE_ROD,"Golden Rod");
        RedstoneAlloy_Plate = new SlimefunItemStack("REDSTONEALLOY_PLATE",Material.BRICK,"Redstone Alloy Plate");

        //Enchantments and Flags
        Wooden_Helmet.addUnsafeEnchantment(DURABILITY,5);Wooden_Chestplate.addUnsafeEnchantment(DURABILITY,5);
        Wooden_Leggings.addUnsafeEnchantment(DURABILITY,5);Wooden_Boots.addUnsafeEnchantment(DURABILITY,5);
        Flint_Sword.addEnchantment(DURABILITY,2);Flint_Sword.addEnchantment(DAMAGE_ALL,3);
        Flint_Pickaxe.addEnchantment(DURABILITY,2);Flint_Pickaxe.addEnchantment(DIG_SPEED,3);
        Flint_Axe.addEnchantment(DURABILITY,2);Flint_Axe.addEnchantment(DIG_SPEED,3);
        Flint_Shovel.addEnchantment(DURABILITY,2);Flint_Shovel.addEnchantment(DIG_SPEED,3);
        Wooden_Helmet.setDurability((short) 10);Wooden_Chestplate.setDurability((short) 10);
        Wooden_Leggings.setDurability((short) 10);Wooden_Boots.setDurability((short) 10);
        Obsidian_Sword.addUnsafeEnchantment(DURABILITY,5);Obsidian_Sword.addUnsafeEnchantment(DAMAGE_ALL,10);
        Obsidian_Pickaxe.addUnsafeEnchantment(DURABILITY,5);Obsidian_Pickaxe.addUnsafeEnchantment(DIG_SPEED,10);
        Obsidian_Axe.addUnsafeEnchantment(DURABILITY,5);Obsidian_Axe.addUnsafeEnchantment(DIG_SPEED,10);
        Obsidian_Shovel.addUnsafeEnchantment(DURABILITY,5);Obsidian_Shovel.addUnsafeEnchantment(DIG_SPEED,10);
        Reinforced_Helmet.addUnsafeEnchantment(DURABILITY,10);Reinforced_Helmet.addUnsafeEnchantment(PROTECTION_ENVIRONMENTAL,10);
        Reinforced_Chestplate.addUnsafeEnchantment(DURABILITY,10);Reinforced_Chestplate.addUnsafeEnchantment(PROTECTION_ENVIRONMENTAL,10);
        Reinforced_Leggings.addUnsafeEnchantment(DURABILITY,10);Reinforced_Leggings.addUnsafeEnchantment(PROTECTION_ENVIRONMENTAL,10);
        Reinforced_Boots.addUnsafeEnchantment(DURABILITY,10);Reinforced_Boots.addUnsafeEnchantment(PROTECTION_ENVIRONMENTAL,10);
        Reinforced_Sword.addEnchantment(DURABILITY,2);Reinforced_Sword.addUnsafeEnchantment(DAMAGE_ALL,10);
        Reinforced_Pickaxe.addEnchantment(DURABILITY,2);Reinforced_Pickaxe.addUnsafeEnchantment(DIG_SPEED,10);
        Reinforced_Axe.addEnchantment(DURABILITY,2);Reinforced_Axe.addUnsafeEnchantment(DIG_SPEED,10);
        Reinforced_Shovel.addEnchantment(DURABILITY,2);Reinforced_Shovel.addUnsafeEnchantment(DIG_SPEED,10);
    }
}
