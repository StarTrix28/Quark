package me.startrix.atom;

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
import me.startrix.atom.libraries.utils.QuarkLoreBuilder;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import javax.naming.Name;

import java.util.function.Consumer;

import static org.bukkit.enchantments.Enchantment.*;

public final class ItemsDefine {
    public static final NestedItemGroup Quark = new NestedItemGroup(new NamespacedKey(NamespacedKey.BUKKIT,"quark"),new CustomItemStack(Material.DIAMOND,"&4Quark"));
    public static final SubItemGroup CategoryBasic = new SubItemGroup(new NamespacedKey(NamespacedKey.BUKKIT, "quark-basic"), Quark, new CustomItemStack(new ItemStack(Material.LEATHER_CHESTPLATE),Color.fromRGB(64,23,0),"Basic"));
    public static final SubItemGroup CategoryTools = new SubItemGroup(new NamespacedKey(NamespacedKey.BUKKIT,"quark-tools"),Quark,new CustomItemStack(Material.IRON_PICKAXE,"Tools"));
    public static final SubItemGroup CategoryMultiblock = new SubItemGroup(new NamespacedKey(NamespacedKey.BUKKIT,"quark-multiblock"),Quark,new CustomItemStack(Material.CRAFTING_TABLE,"MultiBlocks"));
    public static final SubItemGroup CategoryAdvancedElectricity = new SubItemGroup(new NamespacedKey(NamespacedKey.BUKKIT, "quark-advanced_energy_and_electricity"), Quark, new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWFjNTI0MTliOTkwMjU4MjhjODlmYTgyNTk0NWU2OTQ4ZTQ1YmI1YTIyZTQ0MjVhNTllOTA5NmU0YzFhYzM4In19fQ==")),"Advanced Energy and Electricity [WIP]"));
    public static final SubItemGroup CategoryTechnicalGear = new SubItemGroup(new NamespacedKey(NamespacedKey.BUKKIT,"quark-technicalgear"),Quark,new CustomItemStack(Material.BLAZE_ROD,"Technical Gear [WIP]"));
    public static final SubItemGroup CategoryMiscellaneous = new SubItemGroup(new NamespacedKey(NamespacedKey.BUKKIT,"quark-miscellaneous"),Quark,new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDhlNjUyNTM4NWY3NDgzMjJlZWNjNDE2ODliNjkwYWExZWJiYjIxNzJlYzJjNGEyZWFjMTRmMjJkOTRlZTNiYSJ9fX0=")),"Miscellaneous"));

    public static final NestedItemGroup QuarkMagic = new NestedItemGroup(new NamespacedKey(NamespacedKey.BUKKIT,"quarkmagic"),new CustomItemStack(Material.GLOWSTONE,"Quark - Magic [WIP]"));
    public static final SubItemGroup CategoryEssences = new SubItemGroup(new NamespacedKey(NamespacedKey.BUKKIT,"quarkmagic-essences"),QuarkMagic,new CustomItemStack(Material.NETHER_STAR,"Essences"));
    public static final SubItemGroup CategoryMagicalResources = new SubItemGroup(new NamespacedKey(NamespacedKey.BUKKIT,"quarkmagic-resources"),QuarkMagic,new CustomItemStack(Material.GOLD_INGOT,"Resources"));
    public static final SubItemGroup CategoryMagic = new SubItemGroup(new NamespacedKey(NamespacedKey.BUKKIT, "quarkmagic-magic"), QuarkMagic,new CustomItemStack(new ItemStack(Material.FIREWORK_STAR),Color.PURPLE,"Magic"));
    public static final SubItemGroup CategoryMagicalMachines = new SubItemGroup(new NamespacedKey(NamespacedKey.BUKKIT,"quarkmagic-machines"),QuarkMagic,new CustomItemStack(Material.FURNACE,"Machines"));
    public static final SubItemGroup CategoryEnergyMagic = new SubItemGroup(new NamespacedKey(NamespacedKey.BUKKIT, "quarkmagic-energymagic"), QuarkMagic,new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmMzZDY4YTYyZDMyZjZhODViNzhiN2U2OThmN2M3MzgzNTRlZjc4MzVkMTRkZWYwYjk0OGVjZWYxMzQwMTYzNiJ9fX0=")),"Energy Magic"));

    public static final NestedItemGroup QuarkFluids = new NestedItemGroup(new NamespacedKey(NamespacedKey.BUKKIT,"quarkfluids"),new CustomItemStack(Material.WATER_BUCKET,"Quark - Fluids [WIP]"));
    public static final SubItemGroup Pipes = new SubItemGroup(new NamespacedKey(NamespacedKey.BUKKIT,"quarkpipes-pipes"),QuarkFluids,new CustomItemStack(Material.BUCKET,"Pipes"));
    //Basic
    public static final SlimefunItemStack Wooden_Helmet;
    public static final SlimefunItemStack Wooden_Chestplate;
    public static final SlimefunItemStack Wooden_Leggings;
    public static final SlimefunItemStack Wooden_Boots;
    public static final SlimefunItemStack Flint_Pickaxe;
    //Tools
    public static final SlimefunItemStack Hammer;
    //Multiblock
    public static final SlimefunItemStack KiloMiner;
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
    //Resources


    //Pipes

    //Magic

    //Essences
    public static final SlimefunItemStack MagicalEssence;
    //MagicResources
    public static final SlimefunItemStack Magic_Rune;
    public static final SlimefunItemStack MagicalGlowstoneDust;
    public static final SlimefunItemStack MagicalGlowstone;
    //Magic
    public static final SlimefunItemStack MagicStone;
    public static final SlimefunItemStack MagicWandIron;
    public static final SlimefunItemStack MagicCrucible;
    public static final SlimefunItemStack MagicWater;
    //Machines
    public static final SlimefunItemStack MEssenceGrinder;
    //Magical Energy
    public static final SlimefunItemStack Magical_Energy_Regulator;
    public static final SlimefunItemStack Magical_Energy_Connector;
    public static final SlimefunItemStack Magical_Energy_Generator;
    public static final SlimefunItemStack Basic_Magic_Capacitor;
    public static final SlimefunItemStack Advanced_Magic_Capacitor;

    ItemsDefine() {
    }
    static {
        //Basic
        Wooden_Helmet = new SlimefunItemStack("WOODEN_HELMET",Material.LEATHER_HELMET, Color.fromRGB(64,23,0),"Wooden Helmet");
        Wooden_Chestplate = new SlimefunItemStack("WOODEN_CHESTPLATE",Material.LEATHER_CHESTPLATE, Color.fromRGB(64,23,0),"Wooden Chestplate");
        Wooden_Leggings = new SlimefunItemStack("WOODEN_LEGGINGS",Material.LEATHER_LEGGINGS, Color.fromRGB(64,23,0),"Wooden Leggings");
        Wooden_Boots = new SlimefunItemStack("WOODEN_BOOTS",Material.LEATHER_BOOTS, Color.fromRGB(64,23,0),"Wooden Boots");
        Flint_Pickaxe = new SlimefunItemStack("FLINT_PICKAXE",Material.STONE_PICKAXE,"Flint Pickaxe");
        //Tools
        Hammer = new SlimefunItemStack("HAMMER",Material.IRON_AXE,"Hammer");
        //Multiblock
        KiloMiner = new SlimefunItemStack("KILO_MINER",Material.NETHERITE_PICKAXE,"Kilo Miner", "", "&fThis Multiblock will mine any Ores", "&fin a 15x15 area underneath it.", "&fPlace coal in", "&fits chest to fuel this machine.", "", "&a+ Silk Touch");
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

        //Magic

        //Essences
        MagicalEssence = new SlimefunItemStack("MAGICAL_ESSENCE",Material.NETHER_STAR,"Magical Essence","Most Essential Magical Item");
        //MagicalResources
        Magic_Rune = new SlimefunItemStack("MAGIC_RUNE",Material.FIREWORK_STAR,Color.PURPLE,"&5Magic Rune");
        MagicalGlowstoneDust = new SlimefunItemStack("MAGICAL_GLOWSTONE_DUST",Material.GLOWSTONE_DUST,"Magical Glowstone Dust");
        MagicalGlowstone = new SlimefunItemStack("MAGICAL_GLOWSTONE",Material.GLOWSTONE,"Magical Glowstone");
        //Magic
        MagicStone = new SlimefunItemStack("MAGIC_STONE",Material.STONE,"Magic Stone");
        MagicWandIron = new SlimefunItemStack("MAGIC_WAND",Material.STICK,"Magic Wand","&5Caps Material - &fIron", QuarkLoreBuilder.powerCharged(0,16));
        MagicCrucible = new SlimefunItemStack("MAGIC_CRUCIBLE",Material.CAULDRON,"Magic Crucible");
        MagicWater = new SlimefunItemStack("MAGIC_WATER",Material.WATER_BUCKET,"Magic Water Bucket","Essential Item in Magic Crucible");
        //Machines
        MEssenceGrinder = new SlimefunItemStack("ESSENCE_GRINDER",Material.BEACON,"Essence Grinder");
        //Energy Magic
        Magical_Energy_Regulator = new SlimefunItemStack("MAGICAL_ENERGY_REGULATOR", HeadTexture.ENERGY_REGULATOR, "&6Magical Energy Regulator", "", "&fCore Component of an Energy Network");
        Magical_Energy_Connector = new SlimefunItemStack("MAGICAL_ENERGY_CONNECTOR", HeadTexture.ENERGY_CONNECTOR, "&eMagical Energy Connector", LoreBuilder.range(6), "", "&fPlace this between machines", "&fand generators to connect them", "&fto your regulator.");
        Basic_Magic_Capacitor = new SlimefunItemStack("BASIC_MAGIC_CAPACITOR",PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmMzZDY4YTYyZDMyZjZhODViNzhiN2U2OThmN2M3MzgzNTRlZjc4MzVkMTRkZWYwYjk0OGVjZWYxMzQwMTYzNiJ9fX0=")),"Basic Magic Capacitor","&1Used to store magic energy","&1Magic capacity -&5 64 ME&r");
        Advanced_Magic_Capacitor = new SlimefunItemStack("ADVANCED_MAGIC_CAPACITOR",PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGMyYmI5OThkZTEzM2U5MzM0MTkyYWM5ZGNhZTMzZDZhYTBlY2I3ZjhjYTRjMmM2YWY3ZDU4MWI2Nzc0ZWY5YSJ9fX0=")),"Advanced Magic Capacitor","&1Used to store magic energy","&1Magic capacity -&5 256 ME&r");
        Magical_Energy_Generator = new SlimefunItemStack("MAGICAL_ENERGY_GENERATOR",Material.PURPLE_WOOL,"Magical Energy 'Generator'","Generates MagicalEnergy from MagicalEssence");


        //Enchantments and Flags
        Wooden_Helmet.addUnsafeEnchantment(DURABILITY,5);Wooden_Chestplate.addUnsafeEnchantment(DURABILITY,5);
        Wooden_Leggings.addUnsafeEnchantment(DURABILITY,5);Wooden_Boots.addUnsafeEnchantment(DURABILITY,5);
        Flint_Pickaxe.addEnchantment(DURABILITY,2);Flint_Pickaxe.addEnchantment(DIG_SPEED,3);
    }
}
