package me.startrix.quark.define;

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
import me.startrix.quark.libraries.utils.QuarkLoreBuilder;
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
    public static final SlimefunItemStack StabilityEssence;
    public static final SlimefunItemStack HeatEssence;
    public static final SlimefunItemStack ColdEssence;
    public static final SlimefunItemStack RedEssence;
    public static final SlimefunItemStack DarkEssence;
    //MagicResources
    public static final SlimefunItemStack Magic_Rune;
    public static final SlimefunItemStack MagicalGlowstoneDust;
    public static final SlimefunItemStack MagicalGlowstone;
    public static final SlimefunItemStack MagicGlass;
    //Magic
    public static final SlimefunItemStack MagicStone;
    public static final SlimefunItemStack MagicWandIron;
    public static final SlimefunItemStack MagicCrucible;
    public static final SlimefunItemStack MagicWater;
    //Machines
    public static final SlimefunItemStack MEssenceGrinder;
    public static final SlimefunItemStack EssenceInfuser;
    //Magical Energy
    public static final SlimefunItemStack Magical_Energy_Regulator;
    public static final SlimefunItemStack Magical_Energy_Connector;
    public static final SlimefunItemStack Magical_Energy_Generator;
    public static final SlimefunItemStack Basic_Magic_Capacitor;
    public static final SlimefunItemStack Advanced_Magic_Capacitor;
    static {
        //Essences
        MagicalEssence = new SlimefunItemStack("MAGICAL_ESSENCE",Material.NETHER_STAR,"Magical Essence","Most Essential Magical Item", QuarkLoreBuilder.Stability(0));
        StabilityEssence = new SlimefunItemStack("STABILITY_ESSENCE",Material.NETHER_STAR,"Stability Essence",QuarkLoreBuilder.Stability(0),"Perfect");
        HeatEssence = new SlimefunItemStack("HEAT_ESSENCE",Material.NETHER_STAR,"Heat Essence",QuarkLoreBuilder.Stability(3));
        ColdEssence = new SlimefunItemStack("COLD_ESSENCE",Material.NETHER_STAR,"Cold Essence",QuarkLoreBuilder.Stability(3));
        RedEssence = new SlimefunItemStack("RED_ESSENCE",Material.NETHER_STAR,"Red Essence",QuarkLoreBuilder.Stability(5));
        DarkEssence = new SlimefunItemStack("DARK_ESSENCE",Material.BLACK_DYE,"Dark Essence",QuarkLoreBuilder.Stability(6));
        //MagicalResources
        Magic_Rune = new SlimefunItemStack("MAGIC_RUNE",Material.FIREWORK_STAR,Color.PURPLE,"&5Magic Rune",QuarkLoreBuilder.Stability(0));
        MagicalGlowstoneDust = new SlimefunItemStack("MAGICAL_GLOWSTONE_DUST",Material.GLOWSTONE_DUST,"Magical Glowstone Dust",QuarkLoreBuilder.Stability(1));
        MagicalGlowstone = new SlimefunItemStack("MAGICAL_GLOWSTONE",Material.GLOWSTONE,"Magical Glowstone",QuarkLoreBuilder.Stability(1));
        MagicGlass = new SlimefunItemStack("MAGIC_GLASS",Material.GLASS_PANE,"MaGlass","Glass that can hold Magic","without any troubles");
        //Magic
        MagicStone = new SlimefunItemStack("MAGIC_STONE",Material.STONE,"Magic Stone",QuarkLoreBuilder.Stability(1));
        MagicWandIron = new SlimefunItemStack("MAGIC_WAND",Material.STICK,"Magic Wand","&5Caps Material - &fIron", QuarkLoreBuilder.powerCharged(0,16));
        MagicCrucible = new SlimefunItemStack("MAGIC_CRUCIBLE",Material.CAULDRON,"Magic Crucible");
        MagicWater = new SlimefunItemStack("MAGIC_WATER",Material.WATER_BUCKET,"Magic Water Bucket","Essential Item in Magic Crucible");
        //Machines
        MEssenceGrinder = new SlimefunItemStack("ESSENCE_GRINDER",Material.BEACON,"Essence Grinder","", LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE), LoreBuilder.speed(1), LoreBuilder.powerPerSecond(32));
        EssenceInfuser = new SlimefunItemStack("ESSENCE_INFUSER",Material.ENCHANTING_TABLE,"Essence Infuser");
        //Energy Magic
        Magical_Energy_Regulator = new SlimefunItemStack("MAGICAL_ENERGY_REGULATOR", HeadTexture.ENERGY_REGULATOR, "&6Magical Energy Regulator", "", "&fCore Component of an Energy Network");
        Magical_Energy_Connector = new SlimefunItemStack("MAGICAL_ENERGY_CONNECTOR", HeadTexture.ENERGY_CONNECTOR, "&eMagical Energy Connector", LoreBuilder.range(6), "", "&fPlace this between machines", "&fand generators to connect them", "&fto your regulator.");
        Basic_Magic_Capacitor = new SlimefunItemStack("BASIC_MAGIC_CAPACITOR",PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmMzZDY4YTYyZDMyZjZhODViNzhiN2U2OThmN2M3MzgzNTRlZjc4MzVkMTRkZWYwYjk0OGVjZWYxMzQwMTYzNiJ9fX0=")),"Basic Magic Capacitor","&1Used to store magic energy","&1Magic capacity -&5 64 ME&r");
        Advanced_Magic_Capacitor = new SlimefunItemStack("ADVANCED_MAGIC_CAPACITOR",PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGMyYmI5OThkZTEzM2U5MzM0MTkyYWM5ZGNhZTMzZDZhYTBlY2I3ZjhjYTRjMmM2YWY3ZDU4MWI2Nzc0ZWY5YSJ9fX0=")),"Advanced Magic Capacitor","&1Used to store magic energy","&1Magic capacity -&5 256 ME&r");
        Magical_Energy_Generator = new SlimefunItemStack("MAGICAL_ENERGY_GENERATOR",Material.PURPLE_WOOL,"Magical Energy 'Generator'","Generates MagicalEnergy from MagicalEssence");

    }
}
