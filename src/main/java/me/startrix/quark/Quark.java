package me.startrix.quark;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import me.startrix.quark.define.QuarkItemsDefine;
import me.startrix.quark.define.QuarkMagicalItemsDefine;
import me.startrix.quark.quarkaddons.FluffyMachines.FluffyMachinesDefine;
import me.startrix.quark.quarkaddons.FluffyMachines.FluffyMachinesSetup;
import me.startrix.quark.setup.ItemSetup;
import me.startrix.quark.setup.MagicItemsSetup;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class Quark extends JavaPlugin implements SlimefunAddon {
    private static Quark instance;
    private final Config config;

    public Quark() {
        this.config = new Config(this);
    }

    @Override
    public void onEnable() {
        setInstance(this);
        this.getCommand("itemstack").setExecutor(new Commands());
        if (this.config.getBoolean("QuarkBase")) {
            new QuarkItemsDefine();
            ItemSetup.INSTANCE.init();
        }
        if (this.config.getBoolean("QuarkMagic")) {
            new QuarkMagicalItemsDefine();
            MagicItemsSetup.INSTANCE.init();

        }
        if (Bukkit.getPluginManager().isPluginEnabled("FluffyMachines") && this.config.getBoolean("Quark-FluffyMachines")) {
            Bukkit.getConsoleSender().sendRawMessage("[Quark] FluffyMachines - Enabled");
            new FluffyMachinesDefine();
            FluffyMachinesSetup.INSTANCE.init();
        }
    }

    @Override
    public void onDisable() {
        setInstance((Quark)null);
    }
    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Nullable
    @Override
    public String getBugTrackerURL() {
        return null;
    }

    public static Quark getInstance() {
        return instance;
    }
    private static void setInstance(Quark ins) {instance = ins;}


}
