package me.startrix.quark.define;

import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

import static me.startrix.quark.define.QuarkItemsDefine.Quark;

public final class AddonsAddonsGroupDefine {
    public static final NestedItemGroup QuarkAddonsAddons = new NestedItemGroup(new NamespacedKey(me.startrix.quark.Quark.getInstance(),"quark_addons"),new CustomItemStack(Material.APPLE,"Quark - Addons","Quark additions to other addons"));
    public static final SubItemGroup CategoryFluffyMachines = new SubItemGroup(new NamespacedKey(me.startrix.quark.Quark.getInstance(),"quarkfluffymachines"),QuarkAddonsAddons,new CustomItemStack(Material.FURNACE,"Fluffy Machines"));
    public AddonsAddonsGroupDefine() {}
}
