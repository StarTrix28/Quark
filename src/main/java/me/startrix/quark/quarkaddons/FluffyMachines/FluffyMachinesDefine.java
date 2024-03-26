package me.startrix.quark.quarkaddons.FluffyMachines;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.Material;

public final class FluffyMachinesDefine {
    public static final SlimefunItemStack test;
    public FluffyMachinesDefine() {}
    static {
        test = new SlimefunItemStack("TEST",Material.STICK,"test");
    }
}
