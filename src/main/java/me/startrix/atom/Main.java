package me.startrix.atom;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.core.services.UpdaterService;
import io.github.thebusybiscuit.slimefun4.core.services.github.GitHubService;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.updater.BlobBuildUpdater;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.logging.Level;

public final class Main extends JavaPlugin implements SlimefunAddon {
    private static Main instance;

    @Override
    public void onEnable() {
        setInstance(this);
        this.getCommand("itemstack").setExecutor(new Commands());
        new ItemsDefine();
        ItemSetup.INSTANCE.init();
    }

    @Override
    public void onDisable() {
        setInstance((Main)null);
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

    public static Main getInstance() {
        return instance;
    }
    private static void setInstance(Main ins) {instance = ins;}


}
