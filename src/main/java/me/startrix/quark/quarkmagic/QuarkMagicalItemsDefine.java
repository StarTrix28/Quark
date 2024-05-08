package me.startrix.quark.quarkmagic;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerSkin;
import io.github.thebusybiscuit.slimefun4.utils.HeadTexture;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.startrix.quark.Quark;
import me.startrix.quark.core.utils.QuarkLoreBuilder;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public final class QuarkMagicalItemsDefine {

    public static final NestedItemGroup QuarkMagic = new NestedItemGroup(new NamespacedKey(Quark.getInstance(),"quarkmagic"),new CustomItemStack(Material.GLOWSTONE,"Quark - Magic [WIP]"));
    public static final SubItemGroup CategoryEssences = new SubItemGroup(new NamespacedKey(Quark.getInstance(),"quarkmagic-essences"),QuarkMagic,new CustomItemStack(Material.NETHER_STAR,"Essences"));
    public static final SubItemGroup CategoryMagicalResources = new SubItemGroup(new NamespacedKey(Quark.getInstance(),"quarkmagic-resources"),QuarkMagic,new CustomItemStack(Material.GOLD_INGOT,"Resources"));
    public static final SubItemGroup CategoryMagic = new SubItemGroup(new NamespacedKey(Quark.getInstance(), "quarkmagic-magic"), QuarkMagic,new CustomItemStack(new ItemStack(Material.FIREWORK_STAR), Color.PURPLE,"Magic"));
    public static final SubItemGroup CategoryMagicalMachines = new SubItemGroup(new NamespacedKey(Quark.getInstance(),"quarkmagic-machines"),QuarkMagic,new CustomItemStack(Material.FURNACE,"Machines"));
    public static final SubItemGroup CategoryEnergyMagic = new SubItemGroup(new NamespacedKey(Quark.getInstance(), "quarkmagic-energymagic"), QuarkMagic,new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmMzZDY4YTYyZDMyZjZhODViNzhiN2U2OThmN2M3MzgzNTRlZjc4MzVkMTRkZWYwYjk0OGVjZWYxMzQwMTYzNiJ9fX0=")),"Energy Magic"));

    //Essences
    public static final SlimefunItemStack MagicalEssence;
    public static final SlimefunItemStack BlueEssence;
    public static final SlimefunItemStack GreenEssence;
    public static final SlimefunItemStack StableEssence;
    public static final SlimefunItemStack RedEssence;
    public static final SlimefunItemStack DarkEssence;
    public static final SlimefunItemStack YellowEssence;
    public static final SlimefunItemStack LocationEssence;
    public static final SlimefunItemStack RotationEssence;
    public static final SlimefunItemStack FabricEssence;
    public static final SlimefunItemStack ColdEssence;
    public static final SlimefunItemStack HotEssence;
    //Unstable
    public static final SlimefunItemStack UnstableRedEssence;
    public static final SlimefunItemStack UnstableDarkEssence;
    public static final SlimefunItemStack UnstableYellowEssence;
    public static final SlimefunItemStack UnstableLocationEssence;
    public static final SlimefunItemStack UnstableRotationEssence;
    public static final SlimefunItemStack UnstableFabricEssence;
    public static final SlimefunItemStack UnstableColdEssence;
    public static final SlimefunItemStack UnstableHotEssence;
    //MagicResources
    public static final SlimefunItemStack Magic_Rune;
    public static final SlimefunItemStack MagicalGlowstoneDust;
    public static final SlimefunItemStack MagicalGlowstone;
    public static final SlimefunItemStack MagicGlass;
    public static final SlimefunItemStack MagicGlassDust;
    public static final SlimefunItemStack GlassDust;
    public static final SlimefunItemStack Photonus;
    //Magic
    public static final SlimefunItemStack MagicStone;
    public static final SlimefunItemStack MagicWandIron;
    public static final SlimefunItemStack MagicCrucible;
    public static final SlimefunItemStack MagicWater;
    public static final SlimefunItemStack MagicHammer;
    public static final SlimefunItemStack TimeSword;
    public static final SlimefunItemStack TimeStableClock;
    public static final SlimefunItemStack SandOfTime;
    //Machines
    public static final SlimefunItemStack PhotonicSeparator;
    public static final SlimefunItemStack PhotonicSeparator2;
    public static final SlimefunItemStack ResearchHub;
    public static final SlimefunItemStack EssenceInfuser;
    public static final SlimefunItemStack Stabilizer;
    public static final SlimefunItemStack DarkEssenceStabilizer;
    //Magical Energy
    public static final SlimefunItemStack Magical_Energy_Regulator;
    public static final SlimefunItemStack Magical_Energy_Connector;
    public static final SlimefunItemStack Magical_Energy_Generator;
    public static final SlimefunItemStack Basic_Magic_Capacitor;
    public static final SlimefunItemStack Advanced_Magic_Capacitor;
    public static final SlimefunItemStack GlowStoneGrinder;

    static {
        //Essences
        MagicalEssence = new SlimefunItemStack("MAGICAL_ESSENCE",Material.NETHER_STAR,"Magical Essence","Most Essential Magical Item", QuarkLoreBuilder.Stability(0));
        BlueEssence = new SlimefunItemStack("BLUE_ESSENCE",Material.BLUE_DYE,"Blue Essence",QuarkLoreBuilder.Stability(0));
        GreenEssence = new SlimefunItemStack("GREEN_ESSENCE",Material.GREEN_DYE,"Green Essence",QuarkLoreBuilder.Stability(0));
        StableEssence = new SlimefunItemStack("STABLE_ESSENCE",Material.LAPIS_LAZULI,"Stable Essence",QuarkLoreBuilder.Stability(0));
        RedEssence = new SlimefunItemStack("RED_ESSENCE",Material.RED_DYE,"Red Essence",QuarkLoreBuilder.Stability(0));
        DarkEssence = new SlimefunItemStack("DARK_ESSENCE",Material.BLACK_DYE,"Dark Essence",QuarkLoreBuilder.Stability(0));
        YellowEssence = new SlimefunItemStack("YELLOW_ESSENCE",Material.YELLOW_DYE,"Yellow Essence",QuarkLoreBuilder.Stability(0));
        LocationEssence = new SlimefunItemStack("LOC_ESSENCE",Material.NETHER_STAR,"Location Essence",QuarkLoreBuilder.Stability(0));
        RotationEssence = new SlimefunItemStack("ROTATION_ESSENCE",Material.NETHER_STAR,"Rotation Essence",QuarkLoreBuilder.Stability(0));
        FabricEssence = new SlimefunItemStack("FABRIC_ESSENCE",Material.NETHER_STAR,"Fabric Essence",QuarkLoreBuilder.Stability(0));
        ColdEssence = new SlimefunItemStack("COLD_ESSENCE",Material.NETHER_STAR,"Cold Essence",QuarkLoreBuilder.Stability(0));
        HotEssence = new SlimefunItemStack("HOT_ESSENCE",Material.NETHER_STAR,"Hot Essence",QuarkLoreBuilder.Stability(0));
        //Unstable Essences
        UnstableRedEssence = new SlimefunItemStack("UNSTABLE_RED_ESSENCE",Material.RED_DYE,"Red Essence",QuarkLoreBuilder.Stability(5));
        UnstableDarkEssence = new SlimefunItemStack("UNSTABLE_DARK_ESSENCE",Material.BLACK_DYE,"Dark Essence",QuarkLoreBuilder.Stability(6));
        UnstableYellowEssence = new SlimefunItemStack("UNSTABLE_YELLOW_ESSENCE",Material.YELLOW_DYE,"Yellow Essence",QuarkLoreBuilder.Stability(5));
        UnstableLocationEssence = new SlimefunItemStack("UNSTABLE_LOC_ESSENCE",Material.NETHER_STAR,"Location Essence",QuarkLoreBuilder.Stability(5));
        UnstableRotationEssence = new SlimefunItemStack("UNSTABLE_ROTATION_ESSENCE",Material.NETHER_STAR,"Rotation Essence",QuarkLoreBuilder.Stability(5));
        UnstableFabricEssence = new SlimefunItemStack("UNSTABLE_FABRIC_ESSENCE",Material.NETHER_STAR,"Fabric Essence",QuarkLoreBuilder.Stability(5));
        UnstableColdEssence = new SlimefunItemStack("UNSTABLE_COLD_ESSENCE",Material.NETHER_STAR,"Cold Essence",QuarkLoreBuilder.Stability(5));
        UnstableHotEssence = new SlimefunItemStack("UNSTABLE_HOT_ESSENCE",Material.NETHER_STAR,"Hot Essence",QuarkLoreBuilder.Stability(5));
        //MagicalResources
        Magic_Rune = new SlimefunItemStack("MAGIC_RUNE",Material.FIREWORK_STAR,Color.PURPLE,"&5Magic Rune",QuarkLoreBuilder.Stability(0));
        MagicalGlowstoneDust = new SlimefunItemStack("MAGICAL_GLOWSTONE_DUST",Material.GLOWSTONE_DUST,"Magical Glowstone Dust",QuarkLoreBuilder.Stability(1));
        MagicalGlowstone = new SlimefunItemStack("MAGICAL_GLOWSTONE",Material.GLOWSTONE,"Magical Glowstone",QuarkLoreBuilder.Stability(1));
        MagicGlass = new SlimefunItemStack("MAGIC_GLASS",Material.GLASS_PANE,"MaGlass","Glass that can hold Magic","without any troubles");
        MagicGlassDust = new SlimefunItemStack("MAGIC_GLASS_DUST",Material.SUGAR,"MaGlass Dust","melt it down to get MaGlass");
        GlassDust = new SlimefunItemStack("GLASS_DUST",Material.SUGAR,"Glass Dust");
        Photonus = new SlimefunItemStack("PHOTONUS",Material.SUNFLOWER,"Photonus","The essence of light");
        //Magic
        MagicStone = new SlimefunItemStack("MAGIC_STONE",Material.STONE,"Magic Stone",QuarkLoreBuilder.Stability(1));
        MagicWandIron = new SlimefunItemStack("MAGIC_WAND",Material.STICK,"Magic Wand","&5Caps Material - &fIron", QuarkLoreBuilder.powerCharged(0,16));
        MagicCrucible = new SlimefunItemStack("MAGIC_CRUCIBLE",Material.CAULDRON,"Magic Crucible");
        MagicWater = new SlimefunItemStack("MAGIC_WATER",Material.WATER_BUCKET,"Magic Water Bucket","Essential Item in Magic Crucible");
        MagicHammer = new SlimefunItemStack("MAGIC_HAMMER",Material.IRON_AXE,"Magic Hammer");
        TimeSword = new SlimefunItemStack("TIME_SWORD",Material.GOLDEN_SWORD,"Time Sword");
        TimeStableClock = new SlimefunItemStack("TIME_STABLE_CLOCK",Material.CLOCK,"Time Stable Clock");
        SandOfTime = new SlimefunItemStack("TIME_SAND",Material.SANDSTONE,"Time Sand");
        //Machines
        GlowStoneGrinder = new SlimefunItemStack("GLOWSTONE_GRINDER",Material.IRON_BLOCK,"Glowstone Grinder");
        PhotonicSeparator = new SlimefunItemStack("ESSENCE_GRINDER",Material.BEACON,"Essence Grinder","", LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE), LoreBuilder.speed(1), LoreBuilder.powerPerSecond(128));
        PhotonicSeparator2 = new SlimefunItemStack("ESSENCE_GRINDER2",Material.BEACON,"Essence Grinder II","", LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE), LoreBuilder.speed(1), LoreBuilder.powerPerSecond(256));
        ResearchHub = new SlimefunItemStack("RESEARCH_HUB",Material.LECTERN,"Research Hub");
        EssenceInfuser = new SlimefunItemStack("ESSENCE_INFUSER",Material.ENCHANTING_TABLE,"Essence Infuser");
        Stabilizer = new SlimefunItemStack("STABILIZER",Material.EMERALD_BLOCK,"Stabilizer");
        DarkEssenceStabilizer = new SlimefunItemStack("DARK_ESSENCE_STABILIZER",Material.OBSIDIAN,"Dark Essence Stabilizer");
        //Energy Magic
        Magical_Energy_Regulator = new SlimefunItemStack("MAGICAL_ENERGY_REGULATOR", HeadTexture.ENERGY_REGULATOR, "&6Magical Energy Regulator", "", "&fCore Component of an Energy Network");
        Magical_Energy_Connector = new SlimefunItemStack("MAGICAL_ENERGY_CONNECTOR", HeadTexture.ENERGY_CONNECTOR, "&eMagical Energy Connector", LoreBuilder.range(6), "", "&fPlace this between machines", "&fand generators to connect them", "&fto your regulator.");
        Basic_Magic_Capacitor = new SlimefunItemStack("BASIC_MAGIC_CAPACITOR",PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmMzZDY4YTYyZDMyZjZhODViNzhiN2U2OThmN2M3MzgzNTRlZjc4MzVkMTRkZWYwYjk0OGVjZWYxMzQwMTYzNiJ9fX0=")),"Basic Magic Capacitor","&1Used to store magic energy","&1Magic capacity -&5 64 ME&r");
        Advanced_Magic_Capacitor = new SlimefunItemStack("ADVANCED_MAGIC_CAPACITOR",PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGMyYmI5OThkZTEzM2U5MzM0MTkyYWM5ZGNhZTMzZDZhYTBlY2I3ZjhjYTRjMmM2YWY3ZDU4MWI2Nzc0ZWY5YSJ9fX0=")),"Advanced Magic Capacitor","&1Used to store magic energy","&1Magic capacity -&5 256 ME&r");
        Magical_Energy_Generator = new SlimefunItemStack("MAGICAL_ENERGY_GENERATOR",Material.PURPLE_WOOL,"Magical Energy 'Generator'","Generates MagicalEnergy from MagicalEssence");

    }
}
