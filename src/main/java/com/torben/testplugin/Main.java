package com.torben.testplugin;

import org.bstats.bukkit.Metrics;
import org.bstats.charts.SimplePie;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        saveDefaultConfig();

        Metrics metrics = new Metrics(this, 16363);
        metrics.addCustomChart(new SimplePie("config_value", () -> {
            return getConfig().getString("bstats.using-metrics", "true");
        }));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
