package me.startrix.quark;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerSkin;
import io.github.thebusybiscuit.slimefun4.utils.HeadTexture;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.enchantments.Enchantment.DIG_SPEED;
import static org.bukkit.enchantments.Enchantment.DURABILITY;
import static org.bukkit.inventory.ItemFlag.HIDE_ENCHANTS;

public final class ItemsDefine {
    public static final NestedItemGroup Quark = new NestedItemGroup(new NamespacedKey(NamespacedKey.BUKKIT,"quark"),new CustomItemStack(Material.DIAMOND,"&4Quark"));
    public static final SubItemGroup CategoryBasic = new SubItemGroup(new NamespacedKey(NamespacedKey.BUKKIT, "basic"), Quark, new CustomItemStack(new ItemStack(Material.LEATHER_CHESTPLATE),Color.fromRGB(64,23,0),"Basic"));
    public static final SubItemGroup CategoryMachines = new SubItemGroup(new NamespacedKey(NamespacedKey.BUKKIT, "machines"), Quark, new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjVjOTc2MjcyOWQ0OGQwYTE2ZmU4OTU3M2JkZDJmYWY1MDE5NmZlYTE1ZDQ5YjVhNmJmZWE0ODliZTcxIn19fQ==")),"Machines"));
    public static final SubItemGroup CategoryMagic = new SubItemGroup(new NamespacedKey(NamespacedKey.BUKKIT, "magic"), Quark,new CustomItemStack(new ItemStack(Material.FIREWORK_STAR),Color.PURPLE,"Magic"));
    public static final SubItemGroup CategoryOres = new SubItemGroup(new NamespacedKey(NamespacedKey.BUKKIT, "ores"), Quark, new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWU5ODYyMmRiNDMwNDg2MWNjOWJlZjhiOTBkNTk2MjE3NDMxOGJmNGU2YTkwZjJkMmViNDJlYzhiZmFlMjlhNyJ9fX0=")),"Ores"));
    public static final SubItemGroup CategoryMiscellaneous = new SubItemGroup(new NamespacedKey(NamespacedKey.BUKKIT,"miscellaneous"),Quark,new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDhlNjUyNTM4NWY3NDgzMjJlZWNjNDE2ODliNjkwYWExZWJiYjIxNzJlYzJjNGEyZWFjMTRmMjJkOTRlZTNiYSJ9fX0=")),"Miscellaneous"));
    public static final SubItemGroup CategoryEnergyMagic = new SubItemGroup(new NamespacedKey(NamespacedKey.BUKKIT, "energymagic"), Quark,new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmMzZDY4YTYyZDMyZjZhODViNzhiN2U2OThmN2M3MzgzNTRlZjc4MzVkMTRkZWYwYjk0OGVjZWYxMzQwMTYzNiJ9fX0=")),"Energy Magic"));

    //Basic
    public static final SlimefunItemStack Wooden_Helmet;
    public static final SlimefunItemStack Wooden_Chestplate;
    public static final SlimefunItemStack Wooden_Leggings;
    public static final SlimefunItemStack Wooden_Boots;
    public static final SlimefunItemStack Flint_Pickaxe;

    //Machines
    public static final SlimefunItemStack Cobble_Generator;

    //Magic
    public static final SlimefunItemStack Magic_Rune;
    public static final SlimefunItemStack MagicStone;
    public static final SlimefunItemStack MagicWandIron;
    public static final SlimefunItemStack MagicCrucible;
    public static final SlimefunItemStack MagicalEssence;
    public static final SlimefunItemStack MagicalGlowstoneDust;
    public static final SlimefunItemStack MagicalGlowstone;

    //Miscellaneous
    public static final SlimefunItemStack Steel_Cage;
    public static final SlimefunItemStack Iron_Cap;

    //Energy Magic
    public static final SlimefunItemStack Magical_Energy_Regulator;
    public static final SlimefunItemStack Magical_Energy_Connector;
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

        //Machines
        Cobble_Generator = new SlimefunItemStack("COBBLE_GENERATOR",PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjVjOTc2MjcyOWQ0OGQwYTE2ZmU4OTU3M2JkZDJmYWY1MDE5NmZlYTE1ZDQ5YjVhNmJmZWE0ODliZTcxIn19fQ==")),"Cobble Generator");

        //Magic
        Magic_Rune = new SlimefunItemStack("MAGIC_RUNE",Material.FIREWORK_STAR,Color.PURPLE,"&5Magic Rune");
        MagicStone = new SlimefunItemStack("MAGIC_STONE",Material.STONE,"Magic Stone");
        MagicWandIron = new SlimefunItemStack("MAGIC_WAND",Material.STICK,"Magic Wand","&5Caps Material - &fIron");
        MagicCrucible = new SlimefunItemStack("MAGIC_CRUCIBLE",Material.CAULDRON,"Magic Crucible");
        MagicalEssence = new SlimefunItemStack("MAGICAL_ESSENCE",Material.NETHER_STAR,"Magical Essence");
        MagicalGlowstoneDust = new SlimefunItemStack("MAGICAL_GLOWSTONE_DUST",Material.GLOWSTONE_DUST,"Magical Glowstone Dust");
        MagicalGlowstone = new SlimefunItemStack("MAGICAL_GLOWSTONE",Material.GLOWSTONE,"Magical Glowstone");

        //Miscellaneous
        Steel_Cage = new SlimefunItemStack("STEEL_CAGE",PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDhlNjUyNTM4NWY3NDgzMjJlZWNjNDE2ODliNjkwYWExZWJiYjIxNzJlYzJjNGEyZWFjMTRmMjJkOTRlZTNiYSJ9fX0=")),"Steel Cage");
        Iron_Cap = new SlimefunItemStack("IRON_CAP",Material.IRON_INGOT,"Iron Cap");

        //Energy Magic
        Magical_Energy_Regulator = new SlimefunItemStack("MAGICAL_ENERGY_REGULATOR", HeadTexture.ENERGY_REGULATOR, "&6Magical Energy Regulator", "", "&fCore Component of an Energy Network");
        Magical_Energy_Connector = new SlimefunItemStack("MAGICAL_ENERGY_CONNECTOR", HeadTexture.ENERGY_CONNECTOR, "&eMagical Energy Connector", LoreBuilder.range(6), "", "&fPlace this between machines", "&fand generators to connect them", "&fto your regulator.");
        Basic_Magic_Capacitor = new SlimefunItemStack("BASIC_MAGIC_CAPACITOR",PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmMzZDY4YTYyZDMyZjZhODViNzhiN2U2OThmN2M3MzgzNTRlZjc4MzVkMTRkZWYwYjk0OGVjZWYxMzQwMTYzNiJ9fX0=")),"Basic Magic Capacitor","&1Used to store magic energy","&1Magic capacity -&5 64 ME&r");
        Advanced_Magic_Capacitor = new SlimefunItemStack("ADVANCED_MAGIC_CAPACITOR",PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGMyYmI5OThkZTEzM2U5MzM0MTkyYWM5ZGNhZTMzZDZhYTBlY2I3ZjhjYTRjMmM2YWY3ZDU4MWI2Nzc0ZWY5YSJ9fX0=")),"Advanced Magic Capacitor","&1Used to store magic energy","&1Magic capacity -&5 256 ME&r");



        //Enchantments and Flags
        Wooden_Helmet.addUnsafeEnchantment(DURABILITY,5);Wooden_Chestplate.addUnsafeEnchantment(DURABILITY,5);
        Wooden_Leggings.addUnsafeEnchantment(DURABILITY,5);Wooden_Boots.addUnsafeEnchantment(DURABILITY,5);
        Flint_Pickaxe.addEnchantment(DURABILITY,2);Flint_Pickaxe.addEnchantment(DIG_SPEED,3);
    }
}
