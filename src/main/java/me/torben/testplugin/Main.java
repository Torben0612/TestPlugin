package me.torben.testplugin;

import me.torben.testplugin.music.PlayNBS;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {


    @Override
    public void onEnable() {
        // Plugin startup
        saveDefaultConfig();
        saveResource("Higher.nbs", false);
        saveResource("Faded.nbs", false);
        saveResource("Hello.nbs", false);
        if(!this.getDataFolder().exists()){
            this.getDataFolder().mkdir();
        }

        getCommand("play-nbs").setExecutor(new PlayNBS(this));
    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
