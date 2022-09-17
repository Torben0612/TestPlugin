package com.torben.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.enginehub.squirrelid.Profile;
import org.enginehub.squirrelid.resolver.HttpRepositoryService;
import org.enginehub.squirrelid.resolver.ProfileService;

import java.io.IOException;
import java.util.UUID;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        ProfileService resolver = HttpRepositoryService.forMinecraft();
        Profile profile = null;
        try {
            profile = resolver.findByName("TornadoK");
            if (profile != null){
                System.out.println(profile.getUniqueId());
            } else {
                System.out.println("[ERROR] failed to receive profile!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(profile.getUniqueId());
    }
}
